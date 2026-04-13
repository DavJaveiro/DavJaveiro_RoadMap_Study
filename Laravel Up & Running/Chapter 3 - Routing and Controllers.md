A função essencial de qualquer framework de aplicação web é receber requisições de um usuário e entregar respostas, geralmente via HTTP(s). Isso significa que definir as rotas de uma aplicação é o primeiro e mais importante projeto a ser abordado ao aprender um framework web; sem rotas, temos pouca ou nenhuma capacidade de interagir com o usuário final.

Neste capítulo, examinaremos as rotas no Laravel; veremos como defini-las, como apontá-las para o código que devem executar e como usar as ferramentas de roteamento do Laravel para lidar com uma diverse array de necessidades de roteamento.

## A Quick Introduction to MVC, the HTTP verbs, and REST
A maior parte do que discutiremos neste capítulo faz referência a como as aplicações Model-View-Controller (MVC) são estruturadas, e muitos dos exemplos que veremos utilizam nomes e verbos no estilo REST, então vamos dar uma rápida olhada em ambos.

### What is MVC?
No MVC, temos três conceitos principais:
**Model**: representa uma tabela individual do banco de dados (ou um registro dessa tabela), pense em "Empresa" ou "Cachorro".

**View:** representa o template que exibe os nossos dados para o usuário final, pensemos no "template da página de login como este determinado conjunto de HTML, CSS e JavaScript".

**Controller (Controlador)**: como um guarda de trânsito, recebe requisições HTTP do navegador, obtém os dados corretos do banco de dados e de outros mecanismos de armazenamento, valida a entrada do usuário e, eventualmente, envia uma resposta de volta ao usuário.

!![image-20263292114451.png](/image-20263292114451.png)

Na figura 1.3 acima, podemos ver o que o usuário final primeira interagirá com o controller, enviando uma requisição HTTP usando o seu navegador. O controller, em resposta a essa requisição, pode gravar dados e/ou buscar dados do modelo (banco de dados). Em seguida, o controller provavelmente enviará dados para uma view, e então a view será retornada ao usuário final para ser exibida em seu navegador.

Vamos abordar alguns casos de uso do Laravel que não se encaixam nessa maneira relativamente simplista de enxergar a arquitetura da aplicação, então não se prenda muito ao *MVC*, mas isso pelo menos vai nos preparar para abordar o restante deste capítulo enquanto falamos sobre *views* e *controllers*.

### The HTTP Verbs
Os verbos HTTP mais comuns são GET e POST, seguidos por PUT e Delete. Existem também HEAD, OPTIONS e PATCH, além de outros dois que raramente são usados no desenvolvimento web convencional: #TRACE e #CONNECT.

Aqui está um resumo rápido:
- #GET: solicita um recurso (ou uma lista de recursos)
- #HEAD: solicita apenas os cabeçalhos da resposta de um #get 
- #POST: cria um recurso
- #PUT: Sobrescreve um recurso
- #PATCH: modifica um recursos
- #DELETE: exclui um recurso
- #OPTIONS: pergunta ao servidor quais verbos são permitidos nesta URL

A tabela 3-1 abaixo mostra as ações disponíveis em um *resource controller*. Cada ação espera que chamemos um padrão de URL específico usando um verbo específico, o que ajuda a entender a finalidade de cada verbo.


**Tabela 3-1. Os métodos dos resource controllers do Laravel**

| Verb          | URL                 | Controller method | Name            | Description                               |
| ------------- | ------------------- | ----------------- | --------------- | ----------------------------------------- |
| `GET`         | `tasks`             | `index()`         | `tasks.index`   | Mostrar todas as tarefas                  |
| `GET`         | `tasks/create`      | `create()`        | `tasks.create`  | Mostrar o formulário de criação de tarefa |
| `POST`        | `tasks`             | `store()`         | `tasks.store`   | Aceitar o envio do formulário de criação  |
| `GET`         | `tasks/{task}`      | `show()`          | `tasks.show`    | Mostrar uma tarefa específica             |
| `GET`         | `tasks/{task}/edit` | `edit()`          | `tasks.edit`    | Editar uma tarefa específica              |
| `PUT`/`PATCH` | `tasks/{task}`      | `update()`        | `tasks.update`  | Aceitar o envio do formulário de edição   |
| `DELETE`      | `tasks/{task}`      | `destroy()`       | `tasks.destroy` | Excluir uma tarefa específica             |

### What is REST?
Abordaremos o REST com mais detalhes na seção "The Basics of REST-Like JSON APIS", mas, como uma breve introdução, trata-se de um estilo arquitetônico para a construção de APIs. Quando falamos sobre REST neste livro, estaremos nos referindo principalmente a algumas características, tais como: 
- Ser estruturado em torno de um recurso principal por vez (ex.: tasks)
- Consistir em interações com estruturas de URL previsíveis usando verbos HTTP;
- Retornar JSON e, frequentemente, ser solicitado com dados em formato JSON.

Há mais aspectos envolvidos, mas geralmente o termo "RESTful", conforme usado neste livro, significará "padronizado após essas estruturas baseadas em URL, permitindo chamadas previsíveis como *GET /tasks/14/edit* " para página de edição. Isso é relevante (mesmo quando não estamos construindo APIs) porque as estruturas de roteamento do Laravel são baseadas em uma estrutura semelhante ao REST.

As APIs baseadas em REST seguem basicamente essa mesma estrutura, exceto pelo fato de que **não possuem uma rota de criação CREATE, nem uma rota de edição EDIT**, pois as APIs representam apenas ações, e não páginas que preparam o usuário para essas ações.

Portanto, temos dois mundos diferentes, **aplicações web tradicionais (com páginas visuais)** e **APIs (que trocam apenas dados)**.

**Contexto das APIs RESTful**
Uma API não tem "telas" ou "formulários visuais". Ela é usada por softwares (como um aplicativo de celular ou um front-end em React/Angular) que já sabem como montar o formulário.

## Route Definitions
Em uma aplicação Laravel, definimos nossas rotas *web* em `routes\web.php` e as nossas rotas de API em `routes/api.php`.
- **Rotas Web:** são as visitadas pelos usuários finais (navegadores)
- **Rotas de API:** são destinadas à nossa API (caso tenhamos uma)
Por enquanto, focaremos principalmente nas rotas do arquivo routes\web.php.

**Definição Básica de Rotas**
A maneira mais simples de definir uma rota é associar um caminho (path), como \, a um **closure**, conforme visto no exemplo 3-1:

**Exemplo 3-1. Definição básica de rota**
```php
// routes/web.php
Route::get('/', function() {
	return 'Hello, World!';
});
```

>**O que é um Closure?**
> #Closures são a versão do PHP para funções anônimas. Um closure é uma função que podemos:
> - Passar como um objeto;
> - Atribuir a uma variável;
> - Passar como parâmetro para outras funções e métodos;
> - Ou até mesmo serializar.
>Por qual motivo usar? Queremos uma função rápida e local, sem precisar criar algo separado. É uma função que criamos na hora e usamos naquele mesmo local. No #Laravel, #closures são usados muito em rotas, callbacks, coleções (map, filter). Exemplo (Collect([1, 2, 3])->map(function($n) {return $n * 2;});)

Ao definir isso, estamos dizendo ao roteador do Laravel: "Se alguém visitar / (a raiz do domínio), execute este closure e retorno o resultado".

>Note: note que nós usamos *return* para enviar o conteúdo, e não **echo** ou **print**.

**Uma introdução Rápida ao Middleware**
Por qual motivo estamos usando *return 'Hello, World!'* em vez de echo?

Existem várias razões, mas a mais simples é que há muitas camadas envolvendo o ciclo de requisição e resposta do Laravel, incluindo algo chamado #middleware. 
- Quando o nosso closure de rota ou método de controller termina, ainda não é hora de enviar a saída diretamente para o navegador.
- Usar *return* permite que o conteúdo continue fluindo através da pilha de resposta (response stack) e passe pelo **middleware** antes de ser finalmente entregue ao usuário.
- Se usamos o *echo*, o conteúdo seria enviado imediatamente, ignorando essas camadas importantes de processamento (como sessões, CSRF, autenticação, etc.).

Muitos sites simples poderiam ser definidos dentro do arquivo de rotas web. Com algumas rotas GET simples combinadas com templates (views), como ilustrado no Exemplo 3-2, podemos servir um site clássico facilmente:
**Exemplo 3-2. Site de exemplo**
```php
Route::get('/', function() {
	return view('Welcome');
});

Route::get('about', function () {
	return view('about');
});

Route::get('products', function () {
	return view('products');
});

Route::get('services', function () {
	return view('services');
});
```

**Chamadas Estáticas e Facades**
Se temos experiência desenvolvendo com PHP, podemos ficar surpreso ao ver chamadas estáticas na classe Route, exemplo Route::get...
- Isso não é tecnicamente um método estático comum.
- É, na verdade, um uso de Service Location através das Facades do Laravel (que abordaremos no Capítulo 11).

Se preferirmos evitar o uso de Facades, podemos realizar as mesmas definições injetando a instância do roteador ($router):
```php
$router->get('/', function() {
	return 'Hello, World!';
});
```

O autor menciona essa possibilidade para mostrar que o Route::get é apenas um "syntactic sugar". Por baixo dos panos, o Laravel sempre usa uma instância do objeto Router. 
### Route Verbs
Podemos notar que temos usado o `Route::get()` em nossas definições de rotas. Isso significa que estamos dizendo ao Laravel para corresponder a essas rotas **apenas** quando a requisição HTTP utilizar o verbo **GET**.

Mas e se for um **POST** de formulário, ou talvez algum JavaScript enviando requisições **PUT** ou **DELETE**? Existem algumas outras opções de métodos para chamar na definição de uma rota, conforme ilustrado no Exemplo 3-3.

**Exemplo 3-3. Verbos de Rota**
```php
// Correspondente apenas a requisições GET
Route::get('/', function(){
	return 'Hello, World!';
});

// Correspondente apenas a requisições POST
Route::post('/', function () {
	// Lida com alguém enviando uma requisição POST para esta rota
});

// Correspondente apenas a requisições PUT
Route::put('/', function () {
	// Liga com alguém enviando uma requisição PUT para essa rota
});

Route::delete('/', function() {
	// Lida com alguém enviando uma requisição DELETE para essa rota
});

Route::any('/', function() {
	// Lida com qualquer tipo de requisição de verbo para esta rota
});

Route::match(['get', 'post'], '/', function() {
	// Lida com requisições GET ou POST para esta rota
});
```

### Route Handling
Passar um closure para a definição da rota não é a única maneira de ensinar o Laravel a resolver uma rota. Closures são rápidos e simples, mas à medida que a nossa aplicação cresce, torna-se cada vez mais desajeitado colocar toda a nossa lógica de roteamento em um único arquivo.

Além disso, aplicações que utilizam <span style="background:#d3f8b6">closures de rota</span> não podem aproveitar o **cache de rotas** do Laravel (mais sobre isso adiante), o que pode economizar centenas de milissegundos em cada requisição. 

Outra opção comum é passar o nome de um **controller** e seu **método** como uma *string* (ou array) no lugar do closure, conforme ilustrado no Exemplo 3-4.
 **Exemplos 3-4. Rotas chamando métodos de controller**
```php
use App\Http\Controllers\WelcomeController;

// Sintaxe moderna recomendada (Callable Array)
Route::get('/', [WelcomeController::class, 'index']);
```

Isso diz ao Laravel para enviar as requisições para aquele caminho ao método *index()* do controller `App\Http\Controllers\WelcomeController`. Este método receberá os mesmos parâmetros e será tratado da mesma forma que um closure que poderíamos ter colocado no lugar.

**Sintaxe de Referência Controller/Método do Laravel**
O Laravel possui uma convenção para se referir a um método específico em um determinado controller:
[controllerName::class, methodName], conhecida como **sintaxe de tupla** ou **sintaxe de array executável** (callable array syntax).
- Às vezes, isso é apenas uma convenção de comunicação informal.
- Mas também é usado em vinculações reais de código, como no Exemplo 3-4.
- O **primeiro item** do array identifica o **controller**;
- O **segundo item** identifica o **método**.

### Route Parameters
Se a rota que estamos definindo possui parâmetros, segmentos na estrutura da URL que são variáveis, é simples defini-los em nossa rota e passá-los para o nosso closure:

**Exemplo 3-5. Parâmetros de rota**
```php
Route::get('users/{id}/friends', function ($id) {
	//
});
```
Neste caso, {id} é um segmento variável. O valor capturado na URL é injetado automaticamente na variável $id do closure.

Também podemos tornar os nossos parâmetros de rota **opcionais** incluindo um ponto de interrogação (?) após o nome do parâmetro, conforme ilustrado no Exebmplo 3-6. Neste caso, também devemos fornecer **um valor padrão** para a variável correspondente da rota.

**Exemplo 3-6. Parâmetros de rota opcionais**
```php
Route::get('users/{id?}', function ($id = 'fallbackId') {
	//
}); 
```

Aqui, tanto users/123 ou users (sem ID) serão correspondidos pela mesma rota. Se nenhum ID for fornecido, $id assumirá o valor 'fallbackId'.

**Restrições com Expressões Regulares (Regex)**
Podemos usar expressões regulares (regex) para definir que uma rota só deve ser correspondida se um parâmetro atender a requisitos específicos, como no Exemplo 3-7:

**Exemplo 3-7. Restrições de rota com expressões regulares**
```php
// O parâmetro 'id' deve conter apenas números
Route::get('users/{id}', function ($id) {
    //
})->where('id', '[0-9]+');

// O parâmetro 'username' deve conter apenas letras (A-Z, a-z)
Route::get('users/{username}', function ($username) {
    //
})->where('username', '[A-Za-z]+');

// Múltiplas restrições em uma única rota
Route::get('posts/{id}/{slug}', function ($id, $slug) {
    //
})->where(['id' => '[0-9]+', 'slug' => '[A-Za-z]+']);
```

Esses helpers substituem a necessidade de escrever expressões regulares complexas manualmente para casos de uso comuns, melhorando a clareza e a manutenção do nosso arquivo de rotas.

**Exemplo 3-8. Helpers de restrição de rota com regex**
```php
// whereNumber: Aceita apenas números
Route::get('users/{id}/friends/{friendname}', function ($id, $friendname) {
    //
})->whereNumber('id')->whereAlpha('friendname');

// whereAlphaNumeric: Aceita letras e números
Route::get('users/{name}', function ($name) {
    //
})->whereAlphaNumeric('name');

// whereUuid: Valida se o parâmetro é um UUID válido
Route::get('users/{id}', function ($id) {
    //
})->whereUuid('id');

// whereUlid: Valida se o parâmetro é um ULID válido
Route::get('users/{id}', function ($id) {
    //
})->whereUlid('id');

// whereIn: Restringe o parâmetro a uma lista específica de valores permitidos
Route::get('friends/types/{type}', function ($type) {
    //
})->whereIn('type', ['acquaintance', 'bestie', 'frenemy']);
```

**A relação de Nomes entre Parâmetros de Rota e Parâmetros do Closure/Controller**
Como podemos ver no Exemplo 3-5, é mais comum usar os mesmos nomes para os seus parâmetros de rota (ex:{id}) e os parâmetros do método onde eles são injetados (ex: function ($id)). Mas isso é necessário?

A menos que estejamos usando **Route Model Binding** (discutido mais adiante neste capítulo), a resposta é **não**.

A única coisa que define qual parâmetro da rota correspondente a qual parâmetro do método é a sua **ordem** (da esquerda para a direita), como podemos ver aqui:
```php
Route::get('users/{usersId}/{commentId}', function(
	$thisIsActuallyTheUserId, // Recebe o valor de {userId}
	$thisIsReallyTheCommentId // Recebe o valor de {commentId}
) {
	//
})
```

Neste exemplo:
- O primeiro parâmetro da URL ({userId}) é injetado na primeira variável da função, independentemente do nome ($thisIsActuallyTheUserId).
- O segundo parâmetro da URL ({commentId}) é injetado na segunda variável ($thisIsReallyTheCommentId).

**Recomendação:** Só porque você _pode_ fazer os nomes serem diferentes, não significa que você _deva_.
Eu recomendo manter os **nomes idênticos** em prol dos futuros desenvolvedores que trabalharão no código. Nomes inconsistentes podem causar confusão e erros ("tripped up") durante a manutenção, já que a maioria das pessoas espera que `{id}` corresponda a `$id`.

### Route Names
A maneira mais simples de referenciar essas rotas em outras partes da nossa aplicação é apenas pelo caminho *path*. Existe um helper global url() para simplificar essa ligação em nossas *views*, se necessário; veja o **Exemplo 3-9**. O helper adicionará automaticamente o domínio complete do nosso site como prefixo à sua rota.

**Exemplo 3-9. O helper url()**
```php
<a href="<?php echo url('/'); ?>">
// Saída: <a href="http://myaspp.com/">
```

No entanto, o Laravel também permite que a gente nomeie cada roda, o que possibilita referenciá-la sem mencionar explicitamente a URL. Isso é útil porque:
- Permite dar apelidos simples a rotas complexas;
- Ao vincular pelo nome, não precisamos reescrever os links do frontend se os caminhos (paths) mudarem no futuro;

**Exemplo 3-10: Definindo nomes de rotas**
```php
// Definindo uma rota com name() em routes/web.php
Route::get('members/{id}', [\App\Http\Controller:class, 'show'])
	->name('members.show');
	
// Vinculando a rota em uma view usando o helper route():
<a href="<?php echo route('member.show', ['id' => 14]); ?>">
```
Este exemplo ilustra alguns novos conceitos:
- **Definição Fluente:** estamos usando a definição fluente de rotas para adicionar o nome, encadeando o método *name()* após o método *get*. Isso atribui um alias curto à rota.
- **Convenção de Nomes:** no exemplo, nomeamos a rota como *members.show*. A convenção comum no Laravel para nomes de rotas e views é recursoPlural.acao.

**Convenções de Nomes de Rotas**
Podemos nomear a nossa rota como quisermos, mas a convenção padrão é usar o **plural do nome do recurso,** seguido de um ponto e depois a ação. Para um recurso chamado *photo*, as rotas mais comuns seriam:
- **photos.index**
- **photos.create**
- **photos.store**
- **photos.show**
- **photos.edit**
- **photos.update**
- **photos.update**
- **photos.destroy**

Este exemplo também introduziu o helper *route()*. Assim como url(), ele deve ser usado em *views* para simplificar a ligação a uma rota nomeada.

- **Sem parâmetros:** passe apenas o nome da rota: *route('members.index')*. Retorna a string da URL completa(ex: "http://myapp.com/members").
- **Com parâmetros:** passe-os como um array no segundo argumento, como feito no exemplo 3-10.

> **Recomendação:** Em geral, recomenda-se usar **nomes de rotas** em vez de caminhos fixos e, consequentemente, usar o helper `route()` em vez de `url()`. Embora possa parecer um pouco desajeitado em alguns cenários (como múltiplos subdomínios), isso oferece um nível incrível de flexibilidade para alterar a estrutura de roteamento da aplicação no futuro sem quebrar links existentes.

**Passando Parâmetros ao Helper route()**
Quando a nossa rota possui parâmetros (ex: users/{id}), precisamos defini-los ao usar o helper *route()* para gerar o link. Existem algumas maneiras diferentes de fazer isso.

Imagine uma rota definida como *users/{usersId}/comments/{comentId}*. Se o ID do usuário for 1 e o ID do comentário for 2, veja as opções disponíveis:

**Opção 1: Array Posicional (Ordenado)**
```php
route('users.comments.show', [1, 2])
// Resultado: http://myapp.com/users/1/comments/2
```

Os valores são atribuídos na ordem em que aparecem na URL.

**Opção 2: Array Associativo (Chaveado) - Ordem Correta**
```php
route('users.comments.show', ['userId' => 1, 'commentId' => 2])
// Resultado: http://myapp.com/users/1/comments/2
```

**Opção 3: Array Associativo - Ordem Invertida**
```php
route('users.comments.show', ['commentId' => 2, 'userId' => 1])
// Resultado: http://myapp.com/users/1/comments/2
```

**Opção 4: Parâmetros Extras (Query String)**
```php
route('users.comments.show', ['userId' => 1, 'commentId' => 2, 'opt' => 'a'])
// Resultado: http://myapp.com/users/1/comments/2?opt=a
```

Qualquer chave no array que **não corresponda** a um parâmetro da rota será adicionada automaticamente como um parâmetro de *query string* (após o ?).

## Routes Groups
Muitas vezes, um grupo de rotas compartilha uma característica específica, um certo <span style="background:#affad1">requisito de autenticação</span>, um prefixo de caminho (path prefix) ou talvez um *namespace* de controller. Definir essas características compartilhadas repetidamente em cada rota não só parece tedioso, mas também pode poluir a estrutura do nosso arquivo de rotas e obscurecer algumas das estruturas de nossa aplicação.

Os **grupos de rotas** (route grupes) permitem reduzir essa duplicação agrupando várias rotas e aplicando qualquer configuração compartilhada uma única vez para todo o grupo além. Além disso, os grupos de rotas servem como dicas visuais para futuros desenvolvedores (e para o nosso próprio cérebro) de que essas rotas estão relacionadas.

Para agrupar duas ou mais rotas, "envolvemos" as definições das rotas com um grupo de rotas, conforme mostrado no **Exemplo 3-11**. Na realidade, estamos passando um *closure* para a definição do grupo e definindo as rotas agrupadas dentro desse *closure:*

**Exemplo 3-11. Definindo um grupo de rotas**
```php
Route::group(function () {
	Route::get('hello', function() {
		return 'Hello';
	});
	
	Route::get('world', function () {
		return 'World';
	});
})l
```

Por padrão, um grupo de rotas **não faz nada** por si só. Não há diferença prática entre usar o grupo no Exemplo 3-11 e simplesmente separar um segmento das suas rotas com comentários de código. A utilidade real surge quando você passa um array de configurações (como `prefix`, `middleware` ou `namespace`) como primeiro argumento do método `group()`, o que será abordado a seguir.
### Middleware
Provavelmente, o uso mais comum para grupos de rotas é aplicar #middleware a um conjunto de rotas. Vamos aprender mais sobre middleware no Capítulo 10, mas, entre outras coisas, <span style="background:#b1ffff">é o mecanismo que o Laravel usa para autenticar usuários e restringir visitantes não logados</span> (*guests*) de acessar certas partes do site.

No **Exemplo 3-12**, estamos criando um grupo de rotas envolvendo as views de *dashboard* e *account*, aplicando o middleware **auth** a ambas. Neste exemplo, isso significa que os usuários precisam estar **logados** na aplicação para visualizar o painel ou a página da conta.

**Exemplo 3-12. Restringindo um grupo de rotas apenas para usuários logados**
```php
Route::middleware('auth')->group(function () {
	Route::get('dashboard', function() {
		return view('dashboard');
	});
	
	Route::get('account', function() {
		return view('account');
	});
});
```

**Aplicando Middleware no Controller**
Muitas vezes, é mais claro e direto anexar o middleware ao **controller** em vez na definição da rota. Podemos fazer isso chamando o método **middleware()** no **construtor** do nosso controller.

- A *string* passada para o método **middleware()** é o nome do middleware.
- Opcionalmente, você pode encadear métodos modificadores (`only()` e `except()`) para definir quais métodos do controller receberão aquele middleware.

```php
class DashboardController extends Controller
{
    public function __construct()
    {
        // Aplica 'auth' a TODOS os métodos deste controller
        $this->middleware('auth');

        // Aplica 'admin-auth' APENAS ao método 'editUsers'
        $this->middleware('admin-auth')->only('editUsers');

        // Aplica 'team-member' a TODOS os métodos, EXCETO 'editUsers'
        $this->middleware('team-member')->except('editUsers');
    }
}
```

> **Dica de Arquitetura:** Note que se você estiver fazendo muitas customizações com `only()` e `except()`, isso frequentemente é um sinal de que você deveria criar um **novo controller** para as rotas excepcionais. Manter um controller com muitas regras condicionais de middleware pode indicar que ele está assumindo responsabilidades demais (violação do Princípio da Responsabilidade Única).


**A Brief Introduction to Eloquent**
Abordaremos o **Eloquent**, o acesso ao banco de dados e o *query builder* do Laravel em profundidade no Capítulo 5, mas haverá algumas referências até lá que tornarão um entendimento básico muito útil.

**O que é Eloquent?**
O Eloquent é o mapeado *objeto-relacional* (ORM) #ActiveRecord do Laravel. Ele facilita a relação entre uma classe PHP (o Model) a uma tabela do banco de dados.
- **Convenção**: por padrão, uma classe *Post* está relacionada à tabela *posts*.
- **Simplicidade:** podemos recuperar todos os registros dessa tabela com uma chamada simples como:
```php
Post::all();
```

**O que é o Query Builder?**
O *query builder* é a ferramenta que permite construir consultas ao banco de dados encadeando métodos. Ele torna possível fazer chamadas fluentes e legíveis, como:
```php
// Usando o Model Eloquent
Post::where('active', true)->get();

// Ou usando a classe DB diretamente em uma tabela específica
DB::table('users')->all();
```

Nesses exemplos, você está construindo a consulta passo a passo, adicionando condições e ações através do encadeamento de métodos (_method chaining_), em vez de escrever SQL bruto.

Portanto, existem dois tipos principais no Laravel:
1. Query Builder (DB)
```php
DB::table('users')->where('active', true)->get();
```
Esse é o **query builder puro** do Laravel.
- Trabalha direto com tabelas
- Retorna objetos simples
- Mais performático/menos abstração

2. **Eloquent (ORM + Query BuildeR)**
```php
Post::where('active', true)->get();
```

Aqui, estamos usando o Eloquent, que por baixo dos panos usa o Query Builder.
Mas adiciona:
- Models (post, user)
- Relacionamentos (hasMany, belogsTo)
- Mutators, casts, etc.

### Path Prefixes

### Subdomain Routing
### Name Prefixes
### Route Group Controllers
### Fallback Routes

## Signed Routes



