## Preface
Este livro é especialmente útil para quem está começando com Angular e ajuda a entendermos a estrutura básica necessária para desenvolver aplicações com o framework. Aprenderemos a criar aplicativos utilizando o poder da CLI (interface de linha de comando) do Angular, escrever testes unitários, aplicar estilos seguindo as diretrizes do Material Design e, por fim, construir a aplicação para produção.

Atualizado para o Angular 19, esta nova edição traz diversos recursos e práticas que respondem aos desafios atuais do desenvolvimento frontend. Ao final do livro, seremos capazes não apenas criar aplicações Angular com TypeScript do zero, mas também de aprimorar as habilidades de codificação com base em boas práticas.

## Building Your First Angular Application
O desenvolvimento web passou por um enorme crescimento na última década. Frameworks, bibliotecas e ferramentas surgiram permitindo que os desenvolvedores criassem excelentes aplicações web. O Angular abriu caminho ao criar um framework focado em desempenho das aplicações, ergonomia no desenvolvimento e técnicas modernas da web.

Antes de desenvolver aplicações com Angular, precisamos aprender algumas coisas básicas, mas essenciais, para ter uma boa experiência com o framework. Um dos principais pontos que devemos entender é o que é o Angular e por que deveríamos usá-lo no desenvolvimento web. Neste capítulo, também faremos uma breve viagem pela história do Angular para entender como o framework evoluiu.

Uma parte significativa deste capítulo é dedicada ao Angular CLI, uma ferramenta desenvolvida pela equipe do Angular que fornece comandos para *scaffolding* (estruturação inicial) e a automação de tarefas em uma aplicação Angular, eliminando configurações repetitivas e permitindo que os desenvolvedores foquem no processo de codificação. Usaremos o Angular CLI para criar nossa primeira aplicação do zero, entender a anatomia de uma aplicação Angular e dar uma espiada como o Angular funciona por trás dos panos.

Trabalhar em um projeto Angular sem a ajuda de ferramentas de desenvolvimento, como uma IDE, pode ser algo penoso! Neste capítulo, destacaremos algumas das ferramentas mais populares do ecossistema Angular, como o Angular DevTools e o Visual Studio Code.

Neste capítulo exploraremos:
- O que é o Angular?
- Por que escolher Angular?
- Configurando o ambiente de trabalho com Angular CLI
- A estrutura de uma aplicação Angular
- Ferramentas do Angular

## Requisitos Técnicos
•       GitHub: https://github.com/PacktPublishing/Learning-Angular-Fifth-Edition/ tree/main/ch01
•       Node.js: https://nodejs.org
•       Git: https://git-scm.com
•       VSCode: https://code.visualstudio.com
•       Angular DevTools: https://angular.dev/tools/devtools

## What is Angular?
Angular é um framework web escrito na linguagem #Typescript e inclui uma CLI, um serviço de linguagem, uma ferramenta de depuração e uma rica coleção de bibliotecas oficiais.

As bibliotecas incluídas no framework Angular e fornecidas prontamente são chamadas de bibliotecas de primeira parte (first-party libraries).

O Angular permite que os desenvolvedores construam aplicações web escaláveis com TypeScript, um superconjunto sintático do JavaScript, o qual estudaremos no Capítulo 2, *Introdução ao TypeScript*.

O Angular foi criado pelo Google. A primeira versão, a 1.0, foi lançada em 2012 com o nome de AngularJS. O AngularJS era um framework baseado em JavaScript, e as aplicações web construídas com ele eram escritas nessa linguagem.

Em 2016, a equipe do Angular decidiu fazer uma mudança revolucionária no AngularJS. Eles colaboraram com a equipe do TypeScript da Microsoft e introduziram essa linguagem no framework. A próxima versão, a 2.0, foi escrita em TypeScript e passou a ser chamada apenas Angular.

Em 2022, o Angular entrou em uma nova era de avanços evolutivos, conhecida como **Renascença do Angular (Angular Renaissance)**. Nesse período, o framework ganhou novo impulso no desenvolvimento web ao introduzir inovações importantes voltadas para melhorar a **experiência do desenvolvedor (DX)** e otimizar a performance das aplicações, como:
- Uma abordagem simples e moderna para escrever aplicações Angular
- Padrões de reatividade aprimorados para gerenciar estado de forma eficiente
- Integração de técnicas de **Renderização do Lado do Servidor (SSR)** para melhorar o desempenho

Um marco importante nessa era foi o Angular 17, quando a equipe do Angular decidiu formular a marca do framework, com um novo logotipo e novas cores, refletindo as mudanças recentes e estabelecendo uma visão para os avanços futuros.

## Why Choose Angular?
**Os pilares principais do framework**
- Multiplataforma (Cross-platform): permite desenvolver aplicações que rodam na web, em dispositivos móveis e até em ambientes desktop.
- Ferramentas poderosas (incredible tooling): oferece um ecossistema robusto de ferramentas integradas, como o Angular CLI, Angular DevTools e suporte em IDEs.
- Facilidade de aprendizado e adoção (Easy onboarding): a estrutura do Angular, sua documentação clara e ferramentas bem integradas facilitam o início no desenvolvimento com o framework.

**A adoção do Angular no mundo todo**
- **Comunidade incrível (An amazing community)** – Conta com uma base global ativa de desenvolvedores que contribuem com bibliotecas, tutoriais, eventos e suporte.
- **Testado em batalhas reais nos produtos do Google (Battle-tested against Google products)** – O Angular é utilizado em larga escala em aplicações críticas do próprio Google, o que valida sua robustez e confiabilidade.

### Multiplataforma (Cross-platform)
Aplicações Angular podem ser executadas em diferentes plataformas: web, servidor, desktop e dispositivos móveis. Apesar de o Angular ser nativamente um framework para a web, ele é **open-source** e conta com um ecossistema de ferramentas robustas que permitem sua execução em outras plataformas por meio de:

- **Angular SSR (Server-Side Rendering):** Permite renderizar aplicações Angular no lado do servidor.
- **Angular Service Worker:** Habilita as aplicações Angular a funcionarem como _Progressive Web Applications (PWAs)_, podendo ser executadas em ambientes desktop e móveis nativos.
- **Ionic/NativeScript:** Frameworks que permitem o desenvolvimento de aplicações móveis usando Angular como base.

### Ferramentas (Tooling)
A equipe do Angular desenvolveu duas ferramentas essenciais que tornam o desenvolvimento com o framework mais produtivo e agradável:
- **Angular CLI:** Uma interface de linha de comando que permite criar, testar, construir e implantar projetos Angular com facilidade.
- **Angular DevTools:** Uma extensão de navegador que permite inspecionar, depurar e analisar o desempenho de aplicações Angular diretamente no navegador.

**Angular CLI e Onboarding**
O CLI é a solução padrão para trabalhar com aplicações Angular. Ela permite que o desenvolvedor se concentre em escrever o código da aplicação, eliminando tarefas de configuração repetitivas, como **scaffolding**, construção, testes e implementação de uma aplicação Angular.

**Onboarding**
Começar a desenvolver com Angular é simples e fácil, pois, ao instalar o Angular, obtemos uma rica coleção de bibliotecas de primeira linha automaticamente, incluindo:
- Angular HTTP client: para realizar comunicações com recursos externos via HTTP.
- Angular Forms: para criar formulários HTML que coletam dados e entradas dos usuários.
- Angular Router: para realizar navegação dentro da aplicação.

Essas bibliotecas são instaladas por padrão quando criamos uma nova aplicação Angular usando Angular CLI. No entanto, elas só serão utilizadas em nossa aplicação se as importarmos explicitamente para o projeto.

## Setting up the Angular CLI workspace
Configurar um projeto com Angular pode ser complicado. É necessário saber quais bibliotecas importar e garantir que os arquivos sejam processados na ordem correta — e é aí que entra o conceito de **scaffolding**. Scaffolding é uma ferramenta que automatiza tarefas como gerar um projeto do zero. Ele se torna essencial à medida que a complexidade aumenta, especialmente quando cada hora conta para gerar valor de negócio em vez de ser desperdiçada com problemas de configuração.

### Motivação do uso do Angular CLI
A **principal motivação** por trás da criação da Angular CLI foi **ajudar os desenvolvedores a se concentrarem na construção da aplicação**, eliminando o "boilerplate" de configuração. Com um **único comando**, você pode:
- Iniciar uma aplicação
- Adicionar novos componentes, serviços e outras partes da aplicação (artefatos)
- Atualizar a aplicação
- Criar um pacote pronto para produção

Tudo isso é possível graças aos comandos especiais da CLI chamados de **schematics**.

### Pré-requisitos
Antes de começar, precisamos garantir que o ambiente de desenvolvimento contenha as ferramentas essenciais para o fluxo de trabalho com Angular.

#### Node.js

O **Node.js** é um ambiente de execução de JavaScript baseado no mecanismo V8 do Google Chrome. O Angular requer uma versão **LTS (Long-Term Support)** ativa ou em manutenção.

#### npm
O **npm (Node Package Manager)** é um gerenciador de pacotes que já vem instalado por padrão com o Node.js. Você pode verificar sua instalação com o comando:
`npm -v`
Uma aplicação Angular depende de várias bibliotecas (chamadas de **pacotes**) que são centralizadas em um repositório online chamado **npm registry**. O cliente npm é responsável por **baixar e instalar** essas bibliotecas necessárias para executar sua aplicação Angular no seu computador local.

## Installing the Angular CLI
A **Angular CLI** faz parte do ecossistema Angular e está disponível no repositório de pacotes do **npm**. Como ela é usada para **criar projetos Angular**, é necessário instalá-la **globalmente** no sistema.
```bash
npm install -g @angular/cli
```

## CLI commands
A CLI é uma ferramenta de linha de comando que automatiza tarefas comuns durante o desenvolvimento de aplicações Angular. Ela cuida de processos como:
- servir a aplicação (ng serve)
- Buildar (compilar e empacotar) o projeto **ng build**
- Agrupar arquivos **bundling**
- Atualizar dependências **ng update**
- Testar a aplicação **ng test**

**Sintaxe básica dos comandos**
```bash
ng [comando] [opções]
```
 - opções: são parâmetros opcionais que modificam o comportamento do comando (como --port, --prod, etc..).


### **Comandos principais da Angular CLI (com aliases)**

A Angular CLI permite usar **atalhos** para tornar os comandos mais rápidos de digitar. Abaixo estão os comandos mais comuns que você usará no dia a dia

|Comando|Alias|Descrição|
|---|---|---|
|`new`|`n`|Cria um novo workspace/projeto Angular do zero.|
|`build`|`b`|Compila a aplicação Angular e gera os arquivos de saída (ex: para produção).|
|`generate`|`g`|Gera arquivos da aplicação, como componentes, serviços, módulos etc.|
|`serve`|`dev`|Compila e inicia um servidor local com live-reload.|
|`test`|`t`|Executa os testes unitários da aplicação.|
|`add`|—|Instala uma **biblioteca Angular** (como Angular Material, por exemplo).|
|`update`|—|Atualiza o Angular e as dependências do projeto para a versão mais recente.|

## Creating a new project
Agora que preparamos o nosso ambiente de desenvolvimento, podemos começar a criar nossa primeira aplicação Angular. Usaremos o comando *ng new* e informaremos o nome da nossa aplicação.

1. Abra o terminal, navegue até a uma pasta de sua escolha e execute o comando: ng new my-app
Criar uma nova aplicação Angular é um processo simples. A CLI solicitará alguns detaalhes sobre a aplicação que desejamos criar para que ela possa estrutura o projeto Angular da melhor forma possível.

2. Inicialmente, será perguntado se queremos habilitar a analítica do Angular.
Você gostaria de compartilhar dados de uso pseudonimizados sobre este projeto com a equipe do Angular no Google, conforme a Política de Privacidade do Google...

A CLI fará essa pergunta apenas uma vez, quando criarmos o primeiro projeto Angular, e aplicará a configuração globalmente no sistema. No entanto, é possível alterar essa configuração depois, em um workspace Angular específico.

3. A próxima pergunta está relacionada ao estilo da nossa aplicação:
Qual formato de folha de estilo você gostaria de usar?

É comum usar CSS para estilizar aplicações Angular. No entanto, também podemos usar pré-processadores como SCSS ou Less para adicionar mais recursos ao nosso fluxo de desenvolvimento.

4. Por fim, a CLI perguntará se queremos habilitar SSR e Geração de Site Estático (SSG) em nossa aplicação.
SSR e SSG estão relacionados à melhoria de performance de inicialização e carregamento de uma aplicação Angular.
Vamos aprender mais sobre esses conceitos no Capítulo 15 - Otimizando a Performance da Aplicação .

Por agora, não habilitaremos o SSR e SSG.

Como desenvolvedores, devemos nos concetrar apenas em escrever o código-fonte que implementa as funcionalidades da nossa aplicação. No entanto, ter um conhecimento básico sobre como a aplicação é orquestrada e configurada nos ajudar a entender melhor sua mecânica e a saber como intervir, se necessário.

Vamos iniciar a nossa aplicação com o seguinte comando:
*ng serve*

A Angular CLI compila o projeto Angular e inicia um servidor web que observa mudanças nos arquivos do projeto. Dessa forma, sempre que alteremos o código da aplicação, o servidor recompila o projeto para refletir as novas mudanças.

## The Structure of an Angular application
Vamos dar os primeiros passos corajosos para examinar nossa aplicação Angular. A Angular CLI já estruturou nosso projeto e fez grande parte do trabalho pesado para nós. Tudo o que precisamos fazer agora é abrir nossa IDE favorita e começar a trabalhar no projeto Angular. Neste livro, usaremos o VSCode, mas fique à vontade para escolher qualquer editor com o qual você se sinta confortável. 

Quando desenvolvemos uma aplicação Angular, provavelmente interagiremos bastante com a pasta src. É nela que escrevemos o código e os testes da nossa aplicação. Ela contém:
- app: todos os arquivos relacionados ao Angular da aplicação. Interagimos com essa pasta na maior parte do desenvolvimento.
- index.html: a página HTML principal da aplicação Angular.
- main.ts: Estilos CSS que se aplicam globalmente na aplicação Angular. A extensão desse arquivo depende do formato de folha de estilo que escolhemos ao criar a aplicação.

A pasta *app* contém o código-fonte real que escrevemos para a nossa aplicação. Os desenvolvedores passam a maior parte do tempo dentro dessa pasta. A aplicação Angular foi criada automaticamente pelo Angular CLI e contém os seguintes arquivos:
- **app.css**- contém os estilos CSS específicos da página de exemplo. A extensão desse arquivo depende do formato da folha de estilo escolhido ao criar ao criar a aplicação.
- **app.html** - contém o conteúdo HTML da página de exemplo.
- **app.spect.ts** - contém os testes unitários da página de exemplo.
- **app.config.ts** - contém a configuração da aplicação Angular
- **app.routes.ts** - define a configuração de rotas da aplicação Angular

## Components
Os arquivos cujos nomes começam com *app.component* constituem um componente **Angular**. Um componente no Angular controla uma parte de uma página web, orquestrando a interação entre a lógica de apresentação e o conteúdo HTML da página, chamado de template.

Cada aplicação Angular possui um único arquivo HTML principal, chamado de **index.html**, ele fica dentro da pasta src e contém o seguinte elemento *<body:
```html
<body>
  <app-root></app-root>
</body>

```
A **tag** app-root é usada para identificar o componente principal da aplicação e atua como um contêiner para exibir seu conteúdo HTML. Ela instrui o Angular a renderizar o template do componente principal dentro dessa tag.

Aprenderemos como isso funciona no **Capítulo 3: Estruturando Interfaces de Usuário com Componentes**.

Quando o Angular CLI compila uma aplicação Angular, ele analisa o arquivo *index.html* e identifica as tags HTML dentro do elemento *body*. Uma aplicação Angular é sempre renderizada dentro do *body* e é composta por uma *árvore de componentes*.

Quando o Angular CLI encontra uma tag que não é um elemento HTML nativo, como < app-root >, ele começa a procurar entre os componentes da árvore da aplicação. 

## Bootstrapping
O método de inicialização de uma aplicação Angular é chamado de **bootstraping**, e ele é definido no arquivo *main.ts*, que fica dentro da pasta *src*:

```TS
import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

```

Bootstrapping é o processo em que o Angular carrega e inicia a aplicação. O arquivo *main.ts* é o ponto de entrada da aplicação Angular, ou seja, é o primeiro código que o navegador executa. O método bootstrapApplication() é responsável por inicializar o componente raiz, que neste caso, é o App Component. 

A principal tarefa do arquivo de bootstrapping (inicialização) é definir o componente que será carregado na inicialização da aplicação. Ele chama o método *bootstrapApplication*, passando *AppComponent* como parâmetro para especificar o componente inicial da aplicação.

Também passa o objeto *appConfig* como segundo parâmetro, para especificar as configurações que serão usadas na inicialização da aplicação. A configuração da aplicação é descrita no arquivo *app.config.ts*.

O objeto appConfig contém uma propriedade chamada *providers* para definir os serviços disponibilizados em toda a aplicação Angular. Vamos aprender mais sobre serviços no Capítulo 5: Gerenciando Tarefas Complexas com Serviços.

Uma nova aplicação criada com Angular CLI já fornece os serviços de roteamento por padrão.

Roteamento está relacionado à navegação interna (dentro da aplicação) entre diferentes componentes, utilizando URL do navegador.

Esse roteamento é ativado utilizando o método *providerRouter*, passando um objeto *routes*, chamando de configuração de rotas.

```ts
import { Routes } from '@angular/router';

export const routes: Routes = [];
```

Our application does not have a route configuration yet, as indicated by the empty routes array. We will learn how to set up routing and configure it in *Chapter 9 - Navigatin through Applications with Routing*.

## Template syntax
A palavra *my-app*, que corresponde ao nome da aplicação, vem de uma variável declarada no arquivo TypeScript do componente principal.

```html
<h1> Hello, {{ title }}</h1>
```

A propriedade *title* está envolvida por duas chaves duplas, uma sintaxe chamada de interpolação, que faz parte da sintaxe de template do Angular.

De forma resumida, a interpolação converte o valor da propriedade *title* em texto e o exibe na página.

O Angular utiliza uma sintaxe de template específica para expandir e enriquecer a sintaxe padrão do HTML dentro do template da aplicaçãao.

Aprenderemos mais sobre a sintaxe de template do Angular no Capítulo 3: Estruturando Interfaces de Usuário com Componentes.

## Angular tooling
Um dos motivos pelos quais o framework Angular é popular entre os desenvolvedores é o rico ecossistema de ferramentas disponíveis.

A comunidade Angular criou ferramentas para complementar e automatizar diversas tarefas, como:
- depuração (*debuggin*)
- inspeção, e
- desenvolvimento (authoring) de aplicação Angular.

As principais ferramentas são:
- Angular DevTools
- Depurador do VSCode
- Perfis do VsCode

O AngularDevTools é uma extensão do navegador criada e mantida pela equipe do Angular.
Ela nos permite inspecionar e fazer o perfil (profiling) de aplicações Angular diretamente no navegador.

A aba Angular contém três abas adicionais:
- **Component**: exibe a árvore de componentes da aplicação Angular
- **Profiler:** permite fazer profiling (análise de desempenho) e inspecionar o comportamento da aplicação.
- **Injector Tree:** exibe os serviços injetados na aplicação Angular, mostrando a estrutura do sistema de injeção de dependência.

