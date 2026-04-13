Parte do sucesso do PHP se deve ao fator de ser difícil encontrar um servidor web que não consiga rodar PHP. A melhor forma de desenvolver para o Laravel é garantir um ambiente de servidor local e remoto consistente para o nosso código e, felizmente, o ecossistema do Laravel possui algumas ferramentas para isso.

O nosso ambiente de desenvolvimento precisará ter todos os seguintes itens instalados para servir sites Laravel:
- PHP >= 8.1
- Extensão PHP OpenSSL
- Extensão PHP PDO
- PHP Mbstring
- PHP Tokenizer
- PHP XML
- Ctype
- JSON
- BCMATH

Além disso, qualquer máquina que estejamos desenvolvendo precisará ter o **Composer** instalado globalmente. O #Compose é uma ferramenta que está na base da maioria do desenvolvimento PHP moderno. É um gerenciador de dependências para PHP. 

Assim como o NPM, o Composer também é a base de grande parte dos nossos testes, carregamento de scripts locais, scripts de instalação e muito mais. Precisaremos do Composer para instalar o Laravel, atualizar o Laravel e trazer dependências externas.

## Local Development Environments
Podemos rodar o Laravel com o servidor embutido do PHP. php -S localhost:8000 -t public a partir da pasta raiz do nosso projeto Laravel, e o servidor web embutido do PHP servirá o nosso site.

Porém, se quisermos um pouco mais de poder no nosso ambiente de desenvolvimento (domínios locais diferentes para cada projeto, gerenciamento de dependências como MySQL, etc.), vamos querer usar uma ferramenta mais poderosa do que apenas o servidor embutido do PHP.

O Laravel oferece cinco ferramentas para desenvolvimento local: **Artisan serve**, **Sail**, **Valet**, **Herd** e **Homestead.**

Quando rodamos *php artisan serve* após configurarmos a nossa aplicação Laravel, ele a servirá. 

## Laravel Sail
Sail é a maneira mais simples de começarmos com o desenvolvimento local Laravel, de uma forma que é a mesma independentemente do nosso sistema operacional. Ele vem com um servidor web PHP, bancos de dados e uma série de outras facilidades que tornam muito fácil executar uma única instalação do Laravel que seja consistente para todos os desenvolvedores do projeto, independentemente das dependências do projeto ou um dos ambientes de trabalho dos seus desenvolvedores.

## Creating a New Laravel Project
Há duas maneiras de criar um novo projeto Laravel, ambas executadas a partir da linha de comando. A primeira opção é instalar globalmente a ferramenta de instalação do Laravel (usando o Composer); a segunda é usar o recurso create-project do Composer.

Podemos aprender ambas as opções com mais detalhes na página de documentação de Instalação. 

**Creating an Application**
After we have installed PHP, Composer, and the Laravel installer, we're ready to create a new Laravel application. The Laravel installer will prompt we to select our preferred testing framework, database, and starter kit:
*laravel new example-app*

Onde the application has been created, we can start Laravel's local development server, queue worker, and Vite development server using the *dev* Composer script:
```bash
cd example-app
npm install && npm run build
composer run dev
```

## Installing Laravel with Sail
Se desejamos planejar trabalhar com o Laravel Sail, podemos instalar um aplicativo Laravel e iniciar o processo de instalação do Sail ao mesmo tempo. Certifiquemos de ter o Docker instalado em nossa máquina e, em seguida, execute o seguinte comando, substituindo *example-app* pelo nome do nosso aplicativo:
```bash
curl -s "https://laravel.build/example-app" | bash
```

Isso instalará o Laravel na pasta **example-app** dentro do nosso diretório atual e, em seguida, iniciará o processo de instalação do Sail.

Assim que o processo de instalação for concluído, acesse seu novo diretório e inicie o Sail:

cd example-app
./vendor/bin/sail up

> **Nota:** A primeira vez que você executar `sail up`, levará consideravelmente mais tempo do que outros processos de instalação, pois ele precisa construir a imagem inicial do Docker.

## Laravel's Directory Structure
When we open up a directory that contains a skeleton Laravel application, we'll see the following files and directores:
app/
boostrap/
config/
database/
public/
resourcers/
routes/
storage/
tests/
vendor/
.editorconfig
.env
.env.example
.gitattributes
.gitignore
artisan
composer.json
composer.lock
package.json
phpunit.xml
readme.md
vite.config.js

Let's walk through them one by one to get familiar.

## The Folders
The root directory contains the following folders by default:
*app*
	Where the bulk of our actual application will go. **Models**, **controllers**, comands, and our PHP domain code all go in here.

*bootstrap*
	Contains the files that the Laravel framework uses to boot every time it runs.

*config*
	Where all the configuration files live.

*database*
	Where database migrations, seeds, and factories live.

*public*
	The directory the server points where it's serving the website. This contains index.php, which is the front controller that kicks off the bootstrapping process and routes all requests appropriately. It's also where any public-facing files like images, stylesheets, scripts, or downloads go.

*resoucers*
	Where files that are needed for other scripts live. Views, and (optionally) source CSS and source JavaScript files live here.

*routes*
	Where caches, logs, and compiled system files live.

*tests*
	Where unit and integration tests live.

*vendor*
	Where Composer installs its dependencies. It's Git-ignored (marked to be excluded from our version control system) because Composer is expected to run as a part of our deploy me process on any remote servers.

## The Loose Files
The root directory also contains the following files:

*.editorconfig*
	Gives our IDE/text editor instructions about Laravel's coding standards (e.g., the size of indents, the charset, and wheter to trim trailing whitespace).

*.env and .env.example*
	Dictate the environment variables (variables that are expected to be different in each environment and are therefore not commited to version control.) .env.example is a template that each environment should duplicate to create its own *.env* file, which is Git-ignored.

*.gitignore and .gitattributes*
	Git configuration files.

*artisan*
	Allows our to run Artisan commands (see Chapter 8) from the command line.

*composer.json and composer.lock*
	Configuration files for Compose; *composer.json* is user-editable and *composer.lock* is not. These files share some basic information about the project and also define its PHP dependencies.


*package.json*
	Like *composer.json*, but for frontend assets and dependencies of the build system; it instructs NPM about which JavaScript-based dependencies to pull in.

*phpunit.xml*
	A configuration file for PHPUnit, the tool Laravel uses for testing out of the box.

*readme.xml*
	A markdown file giving a basic introduction to Laravel. We won't see this file if we use the Laravel installer.

*vite.config.js*
	The (optional) configuration file for Vite. This file instructs our build system about how to compile and process our frontend assets.

## Configuration
The core settings of our Laravel application, database connection, settings, queue and mail settings, etc. - lives in files in the *config* folder. Each of these files returns a PHP array, and each value in the array is accessible by a config key that is comprised of the filename and all descendant keys, separated by dots (.).

### database.php
Com relação ao arquivo *database.php*, o Laravel usa a chave ``'default' => env('DB_CONNECTION', 'sqlite')``, ou seja, se não configurarmos nada no .env, ele tentar usar #SQLite como conexão padrão.

!![image-2026315405380.png](/image-2026315405380.png)

O #redis que aparece no mesmo arquivo **não é uma conexão de banco relacional** como MySQL ou PostgreSQL. O Redis é configurado ali porque o arquivo centraliza configurações de acesso a serviços de dados, mas ele costuma ser usado para **cache**, **filas**, **sessões**, e outros usos de chave-valor, não como banco relacional principal da aplicação. O Laravel documenta Redis separadamente e também documenta cache com suporte a Redis.

Portanto, na prática normalmente só mudamos o *.env*, por exemplo:
```bash
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=meu_banco
DB_USERNAME=root
DB_PASSWORD=senha
```

Portanto, dentro do arquivo temos:
- *default:* conexões de banco que o Laravel pode usar
- *connections:* qual dessas conexões será usada automaticamente
- *redis*: configuração do Redis
- *migrations*: tabela que guarda quais migrations já rodam.

So, if we create a file at *config/services.php* that looks like this:
```php
<?php
return [
	'sparkpost' => [
		'secret' => 'abcdefg',
	],
];
```

We can access that config variable using config('services.sparkpost.secret').

Any configuration variables that should be distinct for each environment (and therefore not committed to source control), will instead live in our .env files. Let's say our want to use a different Bugsnag API key for each environment. Our'd set the config file to pull it from *.env*:
```php
// Config/services.php
<?php
return [
	'bugsnag' => [
		'api_key' => env('BUGSNAP_API_KEY'),
	],
];
```

This env() helper function pulls a value from our .env file with that same key. So, now, add that key to our .env (settings for this environment) and .env.example (template for all environments) files:

Our *.env* file will already contain quite a few environment-specific variables needed by the framework, like which mail driver our'll be using and that our basic database settings are.

Usando env() Fora de Arquivos de Configuração
Certos recursos no Laravel, incluindo algumas funcionalidades de cache e otimização, não estarão disponíveis se chamarmos usando .env() em qualquer lugar fora dos arquivos de configuração.

A melhor maneira de obter variáveis de ambiente é configurar itens de configuração para tudo o que você deseja que seja específico do ambiente. Faça com que esses itens de configuração leiam as variáveis de ambiente e, em seguida, faça referência às variáveis de configuração em qualquer lugar do nosso aplicativo:
```php
// config/services.php
return [
    'bugsnag' => [
        'key' => env('BUGSNAG_API_KEY'),
    ],
];

// No controller, ou qualquer outro lugar
$bugsnag = new Bugsnag(config('services.bugsnag.key'));
```

Ou seja:
❌ ERRADO - Usando `env()` fora de config
```php
// app/Http/Controllers/MeuController.php
class MeuController extends Controller
{
    public function index()
    {
        // Isso vai quebrar quando você usar config:cache!
        $apiKey = env('API_KEY'); 
        
        return view('pagina');
    }
}
```

✅ CORRETO - Usando `env()` apenas em config
```php
// config/services.php (arquivo de configuração)
return [
    'meu_servico' => [
        'api_key' => env('API_KEY'), // ✅ env() é permitido AQUI
        'timeout' => env('API_TIMEOUT', 30), // com valor padrão 30
    ],
];

// app/Http/Controllers/MeuController.php
class MeuController extends Controller
{
    public function index()
    {
        // ✅ Use config() em todo o resto da aplicação
        $apiKey = config('services.meu_servico.api_key');
        $timeout = config('services.meu_servico.timeout');
        
        return view('pagina');
    }
}
```

**Resumo**
- Arquivos de configuração (config/ * .php): utilizar env() à vontade
- Resto da aplicação (Controllers, Models, etc): use *config()*
Devemos pensar nos arquivos de configuração como o tradutor que lê o .env e disponibiliza esses valores para o resto da aplicação de forma segura e otimizada.

O Laravel carrega automaticamente o arquivo .env durante a inicialização da aplicação, através do pacote *vlucas/phpdotenv*. Isso acontece antes de qualquer outra coisa.


## The .env file
Let's take a quick look at the default contents of the .env file. The exact keys will vary depending on which version of Laravel our using, but take a look at Example 2-1 to see what they look like.

```bash
APP_NAME=Laravel
APP_ENV=local
APP_KEY=
APP_DEBUG=true
APP_URL=http://localhost
```

Não entraremos em detalhes sobre todas elas, porque muitas são apenas grupos de informações de autenticação para vários serviços (Pusher, Redis, DB, Mail). No entanto, aqui estão duas variáveis de ambiente importantes:

*APP_KEY*:
	Uma cadeia de caracteres gerada aleatoriamente que é usada para criptografar dados. Se ela estiver vazia, podemos encontrar o erro "No application encryption key has been specified". Neste caso, basta executar php artisan key:generate, e o Laravel gerará uma para a gente.

*APP_DEBUG:*
	Um booleano que determina se os usuários dessa instância da nossa aplicação devem ver erros de depuração, ótimo para ambientes locais e de teste, péssimo para produção. Ele controla se o Laravel mostra erros detalhados da aplicação. Quando está true, o Laravel exibe todas as informações do erro diretamente na tela. Portanto, se ocorrer um erro, o Laravel mostra uma página detalhada com: stack trace completo, caminhos de arquivos do servidor, variáveis da aplicação, configurações carregadas, Queries SQL executadas, versão do PHP, versão do Laravel. Isso expõe a estrutura do servidor. Podendo mostrar caminhos internos como `/var/www/app/Http/Controllers/UserController.php` onde um hacker acaba descobrindo como o nosso sistema está organizado. Vazamentos de dados sensíveis, ajuda os hackers a exploraram falhas, revela a lógica interna da aplicação. 

## Up and Running
Agora que está tudo pronto e funcionando com uma instalação simples do Laravel. Execute o git init, confirme os arquivos simples com git add . e git commit, e estaremos prontos para começar a programar. E se estivermos usando o Valet, podemos executar os seguintes comando e ver instantaneamente o nosso site ao vivo no navegador: `laravel new myProject && cd myProject && valet open`

## Testing
Em todos os capítulos seguintes, a seção "Testes" no final do capítulo mostrará como escrever testes para o recurso ou recursos abordados. Como este capítulo não cobre um recurso testável, vamos falar rapidamente sobre testes. (Para aprender mais sobre como escrever e executar testes no Laravel, vá direto para o capítulo 12.)

Por padrão, o Laravel inclui o PHPunit como dependência e está configurado para executar os testes em qualquer arquivo dentro do diretório *tests* cujo nome termine com *Test.php* (por exemplo, testes/UserTest.php).

Portanto, a maneira mais simples de escrever testes é criar um arquivo no diretório *tests* com um nome que termine em *Test.php*. E a maneira mais fácil de executá-los é rodar *./vendor/bind/phpunit* a partir da linha de comando (na raiz do projeto).

Laravel já traz um wrapper para testes via Artisan CLI:
```cmd
php artisan test
```
Ele internamente chama o PHPUnit.

Se algum teste precisar de acesso ao banco de dados, certifique-se de executar os testes na máquina onde o nosso banco de dados está hospedado, ou seja, se estivermos hospedando o nosso banco de dados no Vagrant, faça ssh em nossa máquina Vargrant para executar os testes a partir dela. 

