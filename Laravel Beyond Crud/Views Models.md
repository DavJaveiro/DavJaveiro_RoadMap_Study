É hora de darmos um primeiro mergulho profundo na camada de aplicativos. Uma das ideias centrais deste livro é manter o código limpo, conciso e gerenciável. 

O padrão que usaremos para nos ajudar é chamado de padrão de modelo de visualização. Como o próprio nome sugere, <span style="background:#b1ffff">essas classes são modelos</span> para os nossos arquivos de visualização; elas são responsáveis por fornecer dados a uma visualização que, de outra forma, <span style="background:#affad1">viriam diretamente do controller</span> ou do modelo de domínio. 

Em essência, os modelos de visualização são classes simples que pegam os dados e os transformam em algo utilizável para a view. Neste capítulo, mostraremos os princípios básicos do padrão, daremos uma olhada em como eles se integram nos projetos Laravel e, por fim, mostraremos como usamos o padrão em um de nossos projetos.

ViewModel pode (e muitas vezes deve) receber os dados vindos do DTO.

Pensemos em um fluxo limpo assim:
Request → Controller → DTO → Service → DTO → ViewModel → Blade

Vamos começar com um exemplo simplificado. Digamos que tenhamos um formulário que cria uma postagem de blog com uma categoria. A gente precisa de uma maneira de preencher a caixa de seleção na exibição com opções de categoria, e o controller deverá fornecê-las. 
```php
public function create() {
	return view('blog.form', [
		'categories' => Category::all(),
	]);
}
```

O exemplo acima funciona para o método de criação, mas não podemos nos esquecer de que também devemos poder editar as postagens existentes.

```php
public function edit(Post $post) {
	return view('blog.form', [
		'post' => $post,
		'categories' => Category::all(),
	]);
}
```

Em seguida, há um novo requisito comercial: os usuários devem ser restringidos quanto às categorias em que têm permissão para postar. Em outras palavras, a seleção da categoria deve ser restrita com base no usuário.
```php
return view('blog.form', [
	'categories' => Category::allowerdForUser(
		current_user()
	)->get(),
]);
```

Infelizmente, porém, essa abordagem não é escalonável porque, para começar, teremos de alterar o código no método de criação e de edição. Então, os modelos de visualização podem imaginar o que acontece quando precisamos adicionar tags a uma postagem? Ou se houver outro formulário especial de adm para criar e editar posts?

A próxima solução é fazer com que o próprio modelo de postagem forneça as categorias, como:
```php
class Post extends Model {
	public static function allowedCategories(): Collection {
		return Category::query()
			->allowerdForUser(current_user())
			->get();
	}
}
```

Há vários motivos pelos quais essa é uma má ideia, embora eu tenha vista esta abordagem ser usada com frequência em projetos Laravel, vamos nos concentrar no problema mais relevante para o nosso caso: ele ainda permite a duplicação.

Digamos que haja outro modelo de news que também precise da mesma seleção de categoria. Isso causa duplicação, mas no nível do modelo em vez de nos controllers.

Outra opção é colocar o método allowedCategories no modelo User, o que faz mais sentido, mas também dificulta a manutenção. Por exemplo, imagine que estamos usando tags como mencionado anteriormente; elas não dependem do usuário, mas agora precisamos obter as categorias do modelo do usuário e as tags de outro lugar.

Usar modelos como provedores de dados para exibição não é uma solução escalável. De onde quer que a gente tente obter as categorias, sempre parece haver alguma duplicação de código, o que dificulta a manutenção e o raciocínio sobre o código.

É nesse ponto que os modelos de visualização entram em ação, pois encapsulam toda essa lógica para que ela possa ser reutilizada em diferentes lugares. É fundamental que eles tenham uma única responsabilidade: fornecer à visualização os dados corretos. 
```php
class PostFormViewModel 
{
	public function _contruct(User $user, Post $post = null)
	{
		$this->user = $user;
		$this->post = $post;
	}
	
	public function post(): Post
	{
		return $this->post ?? new Post();
	}
	
	public function categories(): Collection
	{
		return Category::allowedForUser($this->user)->get();
	}
}
```

Let's name a few key features of such a class:
- Todas as dependências são injetadas, o que proporciona maior flexibilidade ao contexto externo;
- O modelo de visualização expõe alguns métodos que podem ser usados pela visualização;
- Haverá uma postagem nova ou existente fornecida pelo método post, dependendo se estamos criando ou editando uma postagem.

This is what the controller looks like:
```php
class PostsController
{
	public function create()
	{
		$viewModel = new PostFormViewModel(current_user());
		
		return view('blog.form', compact('viewModel'));
	}
	
	public function edit(Post $post)
	{
		$viewModel = new PostFormVideoModel(
			$viewModel = new PostFormViewModel(
				current_user(),
				$post
			);
			
			reutnr view('blog.form', comapct('viewModel'));
		)
	}
}
```

And finally, it can be used in the view like so:
```php
<input value="{{ $viewModel->post()->title }}" />
<input value="{{ $viewModel->post()->body}}" />

<select>
	@foreach($viewModel->categories() as $category)
		<option value="{{ $category->id}}">
			{{ $category->name}}
</select>
```

**View models in Laravel**
O exemplo anterior mostrou uma classe simples como nosso modelo de visualização. Isso é suficiente para usar o padrão, mas nos projetos do Laravel, há mais alguns detalhes que podemos adicionar. Por exemplo, podemos passar um modelo de visualização diretamente para a função de visualização se o modelo de visualização implementar Arrayable.
```php
public function create()
{
	$viewModel = new PostFormViewModel(
		current_user()
	);
	
	return view('blog.form', $viewModel);
}
```
Agora, a visualização pode usar diretamente as propriedades do modelo de visualização, como $post e $categories. O exemplo anterior agora tem a seguinte aparência:

!![image-202632362128.png](/image-202632362128.png)

Podemos retornar o próprio modelo de exibição como dados JSON, implementando Responsabile. Isso pode ser útil quando estivermos salvando o formulário por meio de uma chamada AJAX e quando quisermos preencê-lo novamente com dados atualizados após a conclusão da chamada.

!![image-2026323826625.png](/image-2026323826625.png)

Podemos ver uma semelhança entre os modelos de visualização e os recursos do Laravel. Lembremos de que os recursos mapeiam um a um em um modelo, enquanto os modelos de visualização podem fornecer os dados que desejarem.

In somes places, we're actually using resourcers and view models combined:

```php
class PostViewModel
{
	// ...
	
	public function values(): array
	{
		return PostResource::make(
			$this->post ?? new Post()
		)->resolve();
	}
}
```

**View Composers**
Podemos estar pensando que há alguma sobreposição com os compositores de visualização do Laravel, mas não podemos nos enganar. A documentação do Laravel explica os view composers da seguinte forma:

>Os compositores de exibição são retornos de chamada ou métodos de classe que são chamados quando uma exibição é renderizada. Se tivermos dados que desejamos vincular a uma visualização sempre que ela for renderizada, um compositor de visualização poderá ajudar-nos a organizar essa lógica em um único local.

View composers are registered like this:
```php
class ViewComposerServiceProvider extends ServiceProvider {
	public function boot() {
		View::composer('profile', ProfileComposer::class);
		View::composer('dashboard', function ($view) {
			// ...
		});
	}
	// ...
}
```

Como podemos ver, é possível usar uma classe e um fechamento para adicionar variáveis a uma exibição.

Here's how view composers are used in controllers:
```php
class ProfileController
{
	public function index()
	{
		return view('profile');
	}
}
```

