## Preface
A história de como comecei a usar o Laravel é comum: Eu escrevia PHP há anos, mas estava saindo pela porta, buscando o poder do Rails e de outros frameworks modernos da Web. O Rails, em particular, tinha uma comunidade animada, uma combinação perfeita de padrões opinativos e flexibilidade, e o poder do Ruby-Gems para alavancar o código comum pré-empacotado. Algo me impediu de abandonar o barco, e fiquei feliz por isso quando encontrei o Laravel. Ele oferecia tudo o que me atraía no Rails, mas não era apenas um clone do Rails; era um framework inovador com documentação incrível, uma comunidade acolhedora e influências claras de muitas linguagens e frameworks.

Desde aquele dia, pude compartilhar minha jornada de aprendizado do Laravel por meio de blogs, podcasts e palestras em conferências; escrevi dezenas de aplicativos em Laravel para o trabalho e projetos paralelos; e conheci milhares de desenvolvedores de Laravel on-line e pessoalmente. Tenho muitas ferramentas em meu kit de desenvolvimento, mas sinceramente fico feliz quando me sento em frente a uma linha de comando e digito *laravel new projectName*.

## What This Book is About
Este não é o primeiro livro sobre Laravel, e não será o último. Não pretendo que este seja um livro que cubra cada linha de código ou cada padrão de implementação. Não quero que este seja o tipo de livro que fica desatualizado quando uma nova versão do Laravel é lançada. Em vez disso, seu objetivo principal é fornecer aos desenvolvedores uma visão geral de alto nível e exemplos concretos para aprender o que eles precisam para trabalhar em qualquer base de código do Laravel com todo e qualquer recurso e subsistema do Laravel. Em vez de espelhar os documentos, quero ajudá-lo a entender os conceitos fundamentais por trás do Laravel.

O Laravel é uma estrutura PHP poderosa e flexível. Ele tem uma comunidade próspera e um amplo ecossistema de ferramentas e, como resultado, está crescendo em apelo e alcance. Este livro destina-se a desenvolvedores que já sabem como criar sites e aplicativos e querem aprender a fazer isso bem com o Laravel.

## How This Book is Structured
Este livro está estruturado no que imagino ser uma ordem cronológica: se você estiver criando seu primeiro aplicativo da Web com o Laravel, os primeiros capítulos abordam os componentes fundamentais de que você precisará para começar, e os últimos capítulos abordam recursos menos fundamentais ou mais esotéricos.

Where applicable, each chapter will end with two sections: "Testing" and "TL;DR". If you're not familiar, "TL;DR" means "too long; didn't read". These final sections will show how our write tests for the features covered in each chapter and will give a high-level overview of what was covered.

# Chapter 1 - Why Laravel?
Nos primeiros dias da web dinâmica, escrever uma aplicação web era bem diferente do que é hoje. Naquela época, os desenvolvedores eram responsáveis por escrever o código não apenas da lógica de negócio específica de suas aplicações, mas também de cada um dos componentes que hoje são tão comuns em sites — autenticação de usuários, validação de entrada de dados, acesso a banco de dados, **templating** (sistema de templates), entre outros.

Hoje, os programadores têm dezenas de frameworks de desenvolvimento de aplicações e milhares de componentes e bibliotecas facilmente acessíveis. Existe até uma frase comum entre programadores: **quando você termina de aprender um framework, três novos (supostamente melhores) já apareceram tentando substituí-lo.**

"Só porque está la" pode ser uma justificativa válida para escalar uma montanha, mas existem razões melhores para escolher um framework específico, ou até mesmo para decidir usar um framework.

## Por que usar um Framework?
É fácil perceber por que é vantajoso utilizar **compononentes individuais,** ou **pacotes**, que estão disponíveis para desenvolvedores PHP. Com pacotes, outra pessoa fica responsável por desenvolver e manter uma parte isolada do código que possui uma função bem definida. Em teoria, essa pessoa tem um entendimento muito mais profundo desse componente específico do que teríamos tempo para ter.

Frameworks como **Laravel, Symfony, Lumen e Slim** empacotam uma coleção de **componentes de terceiros** juntamente com uma "cola" própria do framework, como **arquivos de configuração, service providers, estruturas de diretórios padronizadas e o processo de inicialização da aplicação (bootstrap).**

Assim, o benefício de usar um **framework**, de forma geral, é que **alguém já tomou decisões por você**, não apenas sobre quais **componentes utilizar**, mas também sobre como esses componentes devem se integrar e funcionar juntos.

## I'll Just Build It Myself
Digamos que você inicie um novo aplicativo web sem o benefício de um framework. Por onde você começa? Bem, ele provavelmente precisa fazer o roteamento de requisições HTTP, então agora você precisa avaliar todas as bibliotecas de _request_ e _response_ HTTP disponíveis e escolher uma. Depois, você terá que escolher um roteador (_router_).

Ah, e você provavelmente precisará configurar algum tipo de arquivo de configuração de rotas. Qual sintaxe ele deve usar? Onde ele deve ficar? E quanto aos _controllers_? Onde eles ficam localizados e como são carregados?

Bem, você provavelmente precisa de um _container_ de injeção de dependência para resolver os _controllers_ e suas dependências. Mas qual deles?

Além disso, se você realmente dedicar tempo para responder a todas essas perguntas e criar seu aplicativo com sucesso, qual será o impacto para o próximo desenvolvedor? E quando você tiver quatro desses aplicativos baseados em um framework personalizado, ou uma dúzia, e tiver que lembrar onde os _controllers_ ficam em cada um ou qual é a sintaxe de roteamento?

## Consistency and Flexibility
Os frameworks solucionam essa questão ao fornecer uma resposta cuidadosamente pensada para a pergunta "Qual componente devemos utilizar aqui?" e garantindo que os componentes escolhidos funcionem bem em conjunto. Além disso, os frameworks oferecem **convenções** que reduzem a quantidade de código que um desenvolvedor novo no projeto precisa entender, se você entende como o roteamento funciona em um projeto Laravel, por exemplo, você entende como funciona em todos os projetos Laravel.


Quando alguém recomenda criar seu próprio framework para cada novo projeto, o que estão realmente defendendo é a capacidade de controlar o que entra e o que não entra na base de nossa aplicação. Isso significa que os melhores frameworks não apenas fornecerão uma base sólida, mas também darão a liberdade de personalizar à vontade. E isso, como mostrarei no resto deste livro, é a parte do que torno o Laravel tão especial. 

No Laravel, não precisamos escolher qual biblioteca de e-mail usar, o Laravél já traz o #mail. Não precisa escolher como fazer login, ele já traz o #Auth. Isso economiza tempo de pesquisa e decisão. 

Se aprendemos a fazer rotas no Laravel hoje, daqui a 5 anos, em outro emprego que usa Laravel, já saberemos fazer. Não precisamos reaprender a base toda vez.

O Laravel tem uma estrutura de pastas padrão, mas caso precisemos mudar onde os controllers ficam, podemos, ele não nos prende, mas nos guia.

## Uma Breve História dos Frameworks Web e PHP
Uma parte importante para poder responder à pergunta "Por que Laravel"? é entender a história do Laravel, e entender o que veio antes dele. Antes da ascensão da popularidade do Laravel, havia uma variedade de frameworks e outros movimentos em PHP e em outros espaços de desenvolvimento web.

## **Ruby on Rails**
David Heinemeier Hansson lançou a primeira versão do Ruby on Rails em 2004, e desde então tem sido difícil encontrar um framework de aplicação web que não tenha sido influenciado pelo Rails de alguma forma.

O Rails popularizou o MVC, APIs JSON RestFul, convenção sobre configuração, ActiveRecord e muitas outras ferramentas e convenções que tiveram uma influência na maneira como os desenvolvedores web abordavam suas aplicações, especialmente no que diz respeito ao desenvolvimento rápido de aplicações.

Muita das ideias do Ruby on Rails foram replicadas em frameworks de outras linguagens. Ele popularizou o uso dele na web moderna. 

O padrão MVC já existia antes. Antes do Rails, muitos sites PHP ou Perl misturavam HTML + SQL + lógica de negócio no mesmo arquivo.

Portanto, o que o Rails realmente revolucionou foi o seguinte, em vez de configurar tudo manualmente, o framework **assume padrões**.
**Exemplo:**
```json
models/
controllers/
views/
```

O Rails também popularizou o padrão **Active Record**:

```ruby
User.find(1)
```
Sem escrever SQL diretamente.

Isso inspirou vários ORMs.

**Scaffold (geração automática)**
Rails permitia gerar uma aplicação CRUD inteira com um comando: Isso chocou a comunidade na época.

**REST e APIs**
O Rails ajudou a popularizar **rotas RESTful**.
Exemplo:
GET /posts
GET /posts/1
POST /posts
PUT /posts/1
DELETE /posts/1

## O Influxo (ou Surgimento) de Frameworks PHP
Ficou claro para a maioria dos desenvolvedores que o **Ruby on Rails** e frameworks semelhantes de aplicações web eram a tendência do futuro. Assim, frameworks PHP, incluindo alguns que admitidamente imitavam o Rails, começaram a surgir rapidamente.

CakePHP was the first in 2005, and it was soon followed by Symfony, CodeIgniter, Zend Framework, and Kohana (a CodeIgniter fork). Yii arrived in 2008, and Aura and Slim in 2010. 

O ano de 2011 trouxe FuelPHP e Laravel, que não eram exatamente derivados do Codelgniter, mas foram propostos como **alternativas a ele**.

Alguns desses frameworks eram mais "Rails-like", focando em mapeadores objeto-relacional (ORMs), estruturas MVC e outras ferramentas voltadas para **desenvolvimento rápido**.

## O Lado Bom e o Ruim do Codelgniter
CakePHP e CodeIgniter foram os dois primeiros frameworks PHP que foram mais abertos sobre o quanto sua inspiração foi tirada do Rails. O CodeIgniter rapidamente ganhou fama e, em 2010, era indiscutivelmente o mais popular entre os frameworks PHP independentes.

O CodeIgniter era simples, fácil de usar, e ostentava uma documentação incrível e uma comunidade forte. Mas seu uso de tecnologias e padrões modernos avançava lentamente; e conforme o mundo dos frameworks crescia e as ferramentas do PHP avançavam, o CodeIgniter começou a ficar para trás em termos de avanços tecnológicos e recursos prontos para uso (_out-of-the-box_).

Diferentemente de muitos outros frameworks, o CodeIgniter era gerenciado por uma empresa, e foi lento para acompanhar os novos recursos do PHP 5.3, como _namespaces_, e as migrações para o GitHub e posteriormente o Composer. Foi em 2010 que Taylor Otwell, criador do Laravel, ficou insatisfeito o suficiente com o CodeIgniter a ponto de decidir escrever seu próprio framework.

## Laravel 1, 2 e 3
A primeira beta do Laravel 1 foi lançada em junho de 2011, e foi escrita completamente do zero. Ele apresentava um ORM personalizado (Eloquent); roteamento baseado em _closures_ (inspirado no Ruby Sinatra); um sistema de módulos para extensão; e _helpers_ para formulários, validação, autenticação e mais.

O desenvolvimento inicial do Laravel avançou rapidamente, e o Laravel 2 e 3 foram lançados em novembro de 2011 e fevereiro de 2012, respectivamente. Eles introduziram _controllers_, testes unitários, uma ferramenta de linha de comando, um _container_ de Inversão de Controle (IoC), relacionamentos do Eloquent e _migrations_.

## Laravel 4
Com o Laravel 4, Taylor reescreveu todo o framework do zero. Neste ponto, o Composer, o gerenciador de pacotes agora onipresente do PHP, estava mostrando sinais de se tornar um padrão da indústria, e Taylor viu o valor de reescrever o framework como uma coleção de componentes, distribuídos e agrupados juntos pelo Composer.

Taylor desenvolveu um conjunto de componentes sob o nome de código #Illuminate e, em maio de 2013, lançou o Laravel 4 com uma estrutura totalmente nova. Em vez de agrupar a maioria do seu código como um download, o Laravel agora importava a maioria de seus componentes do Symfony (outro framework que lançou seus componentes para uso por outros) e os componentes Illuminate através do Composer.

O Laravel 4 também introduziu *queues (filas)*, um componente de mail, facades e database seeding. E porque o Laravel agora estava dependendo de componentes do Symfony, foi anunciado que o Laravel espelharia (não exatamente, mas logo após) o cronograma de lançamento de seis meses que o Symfony segue.

**Laravel 5**

O Laravel 4.3 estava programado para ser lançado em novembro de 2014, mas conforme o desenvolvimento progredia, ficou claro que a significância de suas mudanças merecia uma versão _major_ (principal), e o Laravel 5 foi lançado em fevereiro de 2015.

O Laravel 5 apresentou uma estrutura de diretórios renovada, remoção dos _helpers_ de form e HTML, a introdução das interfaces de _contract_, uma série de novas _views_, **Socialite** para autenticação em redes sociais, **Elixir** para compilação de _assets_, **Scheduler** para simplificar o _cron_, **dotenv** para gerenciamento simplificado de ambiente, _form requests_ e um totalmente novo **REPL** (_read–evaluate–print loop_). Desde então, ele cresceu em recursos e maturidade, mas não houve grandes mudanças como nas versões anteriores.

**Laravel 6**

Em setembro de 2019, o Laravel 6 foi introduzido com duas mudanças principais: primeiro, a remoção dos _helpers_ globais de string e array que o Laravel oferece (em favor de _facades_); e segundo, a mudança para **SemVer** (_Semantic Versioning_ ou Versionamento Semântico) para a numeração de versão.

O efeito prático dessa mudança significa que, para todas as versões do Laravel após a 5, tanto as versões _major_ (6, 7, etc.) quanto as _minor_ (6.1, 6.2, etc.) são lançadas com muito mais frequência.

**Versões do Laravel no Novo Mundo SemVer (6+)**

A partir da versão 6, os lançamentos do Laravel são menos monumentais do que no passado por causa do novo cronograma de lançamento SemVer. Portanto, daqui para frente, os lançamentos serão mais sobre quanto tempo passou e menos sobre grandes novos recursos muito específicos.

**O Que Tem de Tão Especial no Laravel?**

Então, o que é que diferencia o Laravel? Por que vale a pena ter mais de um framework PHP a qualquer momento? Afinal, eles todos usam componentes do Symfony, certo? Vamos falar um pouco sobre o que faz o Laravel "funcionar".

## A Filosofia do Laravel
Você só precisa ler os materiais de marketing e os READMEs do Laravel para começar a ver seus valores. Taylor usa palavras relacionadas à luz como "Illuminate" e "Spark". E então há estas: "Artisans" (Artesãos). "Elegant" (Elegante). Além disso, estas: "Breath of fresh air" (Uma lufada de ar fresco). "Fresh start" (Um novo começo). E finalmente: "Rapid" (Rápido). "Warp speed" (Velocidade de dobra).

Os dois valores mais fortemente comunicados do framework são aumentar a **velocidade do desenvolvedor** e a **felicidade do desenvolvedor**. Taylor descreve a linguagem "Artisan" como intencionalidade contrastante com valores mais utilitários. Você pode ver a gênese desse tipo de pensamento em sua pergunta de 2011 no StackExchange, na qual ele afirmou: "Às vezes passo quantidades ridículas de tempo (horas) agonizando sobre fazer o código 'parecer bonito'" apenas por causa de uma melhor experiência de olhar para o próprio código. E ele frequentemente falou sobre o valor de tornar mais fácil e rápido para os desenvolvedores levarem suas ideias à concretização, livrando-se de barreiras desnecessárias para criar ótimos produtos.

O Laravel é, em seu núcleo, sobre equipar e capacitar desenvolvedores. Seu objetivo é fornecer código e recursos claros, simples e bonitos que ajudem os desenvolvedores a aprender, começar, desenvolver e escrever código rapidamente de forma simples, clara e duradoura.

O conceito de visar os desenvolvedores é claro em todos os materiais do Laravel. "Happy Developers make the best code" está escrito na documentação. "Developer happiness fro download to deploy"), foi o slogan não oficial por um tempo.

Claro, qualquer ferramenta ou framework dirá que quer que os desenvolvedores sejam felizes. Mas ter a felicidade do desenvolvedor como uma preocupação primária, rather than secondary (em vez de secundária), teve um enorme impacto no estilo e no progresso da tomada de decisões do Laravel. Onde os outros frameworks podem visar a **pureza arquitetural** como seu objetivo principal, ou compatibilidade com os objetivos e valores de equipes de desenvolvimento corporativo, o foco primário do Laravel é servir o **desenvolvedor individual.**

Isso não significa que não possamos escrever aplicações arquiteturalmente puras ou prontas para empresas no Laravel, mas não teremos que ser às custas da legibilidade e compreensibilidade da nossa base de código. 

## Como o Laravel Alcança a Felicidade do Desenvolvedor
Existe várias maneiras pelas quais o Laravel tenta facilitar a vida dos desenvolvedores.

Primeiro, o Laravel é um framework de **desenvolvimento rápido de aplicações** (*rapid application development*). Isso significa que ele foca em uma curva de aprendizado suave (fácil) e em minimizar os passos entre iniciar um novo aplicativo e publicá-lo. Todas as tarefas mais comuns na construção de aplicações web, desde interações com banco de dados até autenticação, filas, e-mail e cache, são simplificados pelos componentes que o Laravel fornece. Mas os componentes do Laravel não são apenas ótimos por si só; eles fornecem uma **API consistente** e estruturas previsíveis em todo o framework. Isso significa que, quando estamos tentando algo novo no Laravél, é muito provável que nós acabemos dizendo: "... e simplesmente funciona".

Isso não termina com o framework em si, também. O Laravel fornece um **ecossistema inteiro de ferramentas** para construir e lançar aplicações. Temos o Sail, Valet e Homestead para desenvolvimento local, Forge para gerenciamento de servidor, e Envoyer e Vapor para implantação avançada. E há um conjunto de pacotes adicionais: Cashier para pagamentos e assinaturas, Echo para WebSockets, **Scout** para busca, **Sanctum** e **Passport** para autenticação de API, **Dusk** para testes de frontend, **Socialite** para login social, **Horizon** para monitoramento de filas, **Nova** para construir painéis administrativos e **Spark** para inicilizarmos o nosso SaaS. O Laravel está tentando tirar o trabalho repetitivo das tarefas dos desenvolvedores para que eles possam fazer algo único.

Em seguida, o Laravel foca em **convenção sobre configuração** (*convention over configuration*), significando que, se estivermos disposto a usar os padrões do Laravel, teremos muito menos trabalho do que com outros frameworks que exigem que declaremos todas as suas configurações, mesmo que esteja usando a configuração recomendada. Projetos construídos sobre Laravel levam menos tempo do que aqueles construídos sobre a maioria dos outros frameworks PHP.

O Laravel também foca profundamente na **simplicidade**. É possível usar injeção de dependência e *mocking* e o padrão **Data Mapper** e repositórios e segregação de responsabilidade de consulta de comando CQRS e todos os tipos de outros padrões arquiteturais mais complexos com o Laravel. 

Mas enquanto outros frameworks podem sugerir o uso dessas ferramentas e estruturas em cada projeto, o Laravel e sua documentação e comunidade tendem a começar com a **implementação mais simples possível** — uma função global aqui, uma _facade_ ali, ActiveRecord acolá. Isso permite aos desenvolvedores criar a aplicação mais simples possível para resolver suas necessidades, sem limitar sua utilidade em ambientes complexos.

## Como Funciona
Até agora, tudo o que compartilhei aqui foi totalmente abstrato. 

**Exemplo 1-1. "Hello, World" em** *routes/web.php*
```php
<?php
Route::get('/', function(){
	return 'Hello, World!';
});
```

A ação mais simples possível que podemos realizar em uma aplicação Laravel é definir uma rota e retornar um resultado sempre que alguém visitar essa rota. Se iniciarmos uma aplicação Laravel totalmente nova em nossa máquina, definir a rota no Exemplo 1-1 e, em seguida, servir o site a partir do diretório *public*, teremos um exemplo "Hello, World" totalmente funcional.

Isso parece muito similar com *controllers*, como podemos ver no exemplo 1-2 (que, se quisermos testar imediatamente, precisamos apenas rodar *php artisan make:controller WelcomeController*) primeiro para criar o controller.

De forma resumida, precisamos de três peças para fecharmos o nosso quebra-cabeça:
1. routes/web.php
	Ele diz: quando alguém acessar /, execute tal controller.
```php
<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HomeController;

Route::get('/', [HomeController::class, 'index']);
```

2. app/Http/Controllers/Controller.php
	Esse é o **controller base do Laravel.**
	Todos os controllers normalmente **herdam dele**.
```php
<?php

namespace App\Http\Controllers;

abstract class Controller
{
    //
}
```

3. app/Http/Controllers/HomeController.php
Esse é o controller que criamos. Ele precisa ter o método index.
```php
<?php

namespace App\Http\Controllers;

class HomeController extends Controller
{
    public function index()
    {
        return 'Hello, World!';
    }
}
```

**Exemplo 1-2. "Hello, World" com controllers**
```php
// Arquivo: routes/web.php
<?php
use App\Http\Controllers\WelcomeController;

Route::get('/', [WelcomeController::class, 'index']);

// Arquivo: app/Http/Controllers/WelcomeController.php
<?php
namespace App\Http\Controllers;

class WelcomeController extends Controller
{
 public function index()
 {
 return 'Hello, World!';
 }
}
```

Se tivermos armazenado nossas saudações em um banco de dados, também parecerá bem similar:
**Routes**
```php
<?php

use App\Greeting;

Route::get('create-greeting', function() {
	$greeting = new Greeting;
	$greeting->boddy = 'Hello, World!';
	$greeting->save();
});

Route::get('first-greeting', function() {
	return Greeting::first()->body;
});
```

**Model Greeting**
```php
<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

Class Greeting extends Model
{
	use HasFactory;
}
```

**Migrations**
```php
<?php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new Class extends Migration
{
	/** * Run the migrations. */
	
	public function up(): void
	{
		Schema::create('greetings', function (Blueprint $table){
			$table->id();
			$table->string('body');
			$table->timestamps();
		});
	}
	
	// Reverse the migrations
	
	public function down(): void
	{
		Schema::dropIfExists('greetings');
	}
};
```

Migration = **controle de versão do banco de dados.**

Ao invés de rodarmos SQL manualmente, escrevemos código e o Laravel gera o SQL.

**Migration**
Classe base que define o que uma **migration precisar ter**.
Ela exige dois métodos:
- **up()** -> aplicar mudança no banco;
- **down()** -> desfazer mudança;

**Schema:**
O **Laravel Schema Builder** é a API do Laravel para criar e modificar tabelas.
Exemplo:
```php
Schema::create(...)
Schema::table(...)
Schema::drop(...)
```

Ele gera SQL por trás.

**Blueprint**
Blueprint é o objeto que representa a estrutura da tabela.

Ele funciona como um projeto da tabela. 

Usamos ele para declarar colunas.
Exemplo mental:
**Blueprint = planta da tabela**

O que fazer quando rodar a migration
Ele roda quando executarmos:
**php artisan migrate**

*Schema::create('greetings', function (Blueprint $table)*

Isso significa criar uma tabela chamada **greetings**.

O Exemplo 1.3 acima pode ser um pouco avassalador e, se for, apenas pule por enquanto. Aprenderemos sobre tudo o que está acontecendo aqui em capítulos posteriores