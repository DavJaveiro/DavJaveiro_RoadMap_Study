Até agora, tivemos a oportunidade de obter uma visão panorâmica do framework Angular. Aprendemos como criar uma nova aplicação Angular usando o Angular CLI e como interagir com um componente Angular utilizando a sintaxe de template. Também exploramos o TypeScript, que nos ajudará a entender como escrever código em Angular. Temos agora tudo o que precisamos para explorar mais a fundo as possibilidades que o Angular oferece na criação de componentes interativos e na forma como eles podem se comunicar entre si.

Neste capítulo, vamos aprender os seguintes conceitos:
- Criar nosso primeiro componente
- Interagir com o template
- Comunicação entre componentes
- Encapsulamento de estilos CSS
- Escolha da estratégia de detecção de mudanças
- Introdução ao ciclo de vida do componente

## Creating our first component
Os componentes são os blocos de construção básicos de uma aplicação Angular. Eles controlam diferentes partes da página web, chamadas de *views*, como uma lista de produtos ou um formulário de finalização de compra. São responsáveis pela lógica de apresentação de uma aplicação Angular e são organizados em uma árvore hierárquica de componentes que podem interagir entre si.

![[3 - Structuring User Interfaces with Components.png]]

A arquitetura de uma aplicação Angular é baseada em componentes Angular. Cada componente pode se comunicar e interagir com um ou mais componentes dentro da árvore de componentes. Como podemos ver na figura 3.1, um componente pode, ao mesmo tempo, ser pai de alguns componentes filhos e filho de outro componente pai.

Nesta seção, exploraremos os seguintes tópicos sobre componentes Angular:
- A estrutura de um componente Angular
- Criação de componentes com o Angular CLI

## The structure of an Angular component
Como aprendemos no Capítulo 1, uma aplicação Angular típica contém pelo menos um componente principal que é composto por vários arquivos. A classe TypeScript do componente é definida no arquivo app.component.ts:
 
O *@Component* é um decorador do Angular que define as propriedades de um componente Angular. Um **decorador Angular** é um método que aceita um objeto com metadados como parâmetro. Esses metadados são usados para configurar uma classe TypeScript como um componente Angular, utilizando as seguintes propriedades:
	- **selector**: um seletor CSS que instrui o Angular a carregar o componente no local onde encontrar a tag correspondente em um template HTML. O Angular CLI adiciona o prefixo app por padrão, mas podemos personalizá-lo usando a opção *--prefix* ao criar o projeto Angular.
	- **imports:** define uma lista de artefatos do Angular que o componente precisa para ser carregado corretamente, como outros componentes Angular. O Angular CLI adiciona o *RouterOutlet* no componente principal da aplicação por padrão. O *RouterOutlet* é utilizado quando precisamos de funcionalidades de roteamento em uma aplicação Angular. Aprenderemos como configurar roteamento no Capítulo 9, Navegando pela Aplicação com Roteamento.
	- **templateUrl:** Define o caminho de um arquivo HTML externo que contém o template diretamente no código usando a propriedade **template**.
	- **styleUrl:** define o caminho de um arquivo externo de folha de estilos CS que contém os estilos do componente. Alternativamente, podemos fornecer os estilos diretamente no código usando a propriedade *styles*.

Portanto, o app.ts é o componente raiz da nossa aplicação Angular. Ele funciona como o **ponto de entrada visual da aplicação,** ou seja, tudo que aparece na tela começa por ele. 

**Reusmindo**:
- É o componente principal da aplicação Angular;
- Serve como base da interface;
- Costuma conter a estrutura global da aplicação (como o menu, rodapé e <router-outlet );
- Está ligado ao HTML via *templateUrl* e *StyleUrl*
- É renderizado dentro da tag app-root no index.html

## Creating components with the Angular CLI
Além do componente principal da aplicação, podemos criar outros componentes Angular que fornecem funcionalidades específicas para a aplicação.

Para criar um novo componente em uma aplicação Angular, usamos o comando *ng generate* do Angular CLI, passando o nome do componente como parâmetro.
Execute o seguinte comando dentro da pasta raiz do workspace atual do Angular CLI:
*ng generate component nome-do-componente*

Este comando irá automaticamente:
- Criar a pasta do componente com quatro arquivos (.ts, .html, .css, .spec.ts)
- Registrar o novo componente no módulo *AppModule* ou outro, dependendo do contexto;
- Preparar a estrutura necessária para começar a usá-lo imediatamente na aplicação.

Na próxima seção, nós aprenderemos como exibir o template HTML de um componente Angular em uma página. Também veremos como usar a sintaxe de template do Angular para permitir a interação entre a classe TypeScript do componente e seu template HTML.

## Interacting with the template
Como aprendemos, criar um componente Angular usando o Angular CLI envolve a geração de um conjunto de arquivos associados. Um desses arquivos é o **template do componente**, que contém o conteúdo HTML exibido na página.

Nesta seção, vamos explorar como exibir e interagir com esse template por meio dos seguintes tópicos:
- Carregando o template do componente;
- Exibindo dados da classe do componente
- Estilizando o componente
- Obtendo dados a partir do template

Vamos começar nossa jornada no template do componente explorando como renderizamos um componente na página web.

## Loading the component template
Aprendemos que o Angular usa a propriedade *selector* para carregar um componente dentro de um template HTML.

Uma aplicação Angular típica carrega o template do componente principal logo na inicialização.
A tag *app-root* 
A tag app-root, que vimos no capítulo 1, Construindo sua Primeira Aplicação Angular, é o selector do componente principal da aplicação.

Para carregar um componente que criamos, como por exemplo um componente de lista de produtos, precisamos adicionar o seu selector dentro de um template HTML

Nesse cenário, vamos carregá-lo dentro do template do componente principal da aplicação:

**Passo 1:**
Abra o arquivo *app.component.html* e mova o conteúdo da tag style para o arquivo app.component.css.

*It is more maintainable and considered a best practice to have all CSS styles in a separated file.*

**Passo 2**:
Modifique o arquivo *app.html* adicionando a tag dentro *app-product-list* dentro de uma *div* com a classe *content*.
```html
<div class="content">
	<app-product-list></app-product-list>
</div>
```
**Passo 3**:
Run the ng serve commando in a terminal window to start the Angular application. The command will fail, stating the following error:
*[ERROR] NG8001: 'app-product-list' is not a known element*
This error is caused because the main application component does not recognize the product list component yet. 

## Displaying data from the component class
Já nos deparamos com **interpolação** para exibir o valor de uma propriedade como texto da classe do componente para o template:
```html
<h1> Hello, {{ title }}</h1>
```

No nosso exemplo acima, o Angular irá procurar a propriedade *title* na classe do componente:
```ts
export class AppComponent {
	title = 'DavJaveiro';
}
```

Substituindo {{ title }} por seu valor.

Portanto, a #interpolação é uma forma de exibir variáveis *typeScript* no HTML de um componente. O Angular avalia a **expressão dentro das chaves duplas {{}}** no contexto da **classe do componente**, e exibe o valor resultante na página.

O Angular converte a propriedade *title* do componente em texto e a exibe na tela. Uma forma alternativa de realizar interpolação é **vincular** a propriedade *title* à propriedade *innerText* do elemento HTML < h1>, utilizando uma técnica chamada **property binding** (vinculação de propriedade):
```html
<h1 [innerText]="title"></h1>
```
No trecho acima, estamos vinculando à propriedade do DOM de um elemento e não ao seu atributo HTML, como pode parecer à primeira vista. A propriedade dentro dos colchetes ([ ]) é chamada de **propriedade-alvo** (*target property*), e corresponde à propriedade do elemento DOM na qual queremos fazer a vinculação. A variável à direita é chamada de **expressão de template** (*template expression*) e corresponde à propriedade *title* do componente.

Quando abrimos uma página da web, o navegador analisa o conteúdo HTML da página e o converte em uma estrutura em árvore chamada #DOM. Cada elemento HTML da página é convertido em um objeto chamado **nó** (node), que representa uma parte do DOM. Um nó define um conjunto de propriedades e é usada para definir o texto interno de um elemento HTML.

Para entender melhor como o mecanismo de templates do Angular funciona, precisamos primeiro compreender como o Angular interage com atributos e propriedades. Ele utiliza os atributos HTML para inicializar uma propriedade do DOM, e depois usa **data binding** para interagir diretamente com essa propriedade.

Para definir um atributo de um elemento HTML, usamos a sintaxe *attr.* através de property binding, seguida do nome do atributo. Por exemplo, para definir o atributo de acessibilidade *aria-label* de um elemento HTML, escreveríamos:
```html
<p [attr.aria-label]="myText"></p>
```

Outro exemplo:
```html
<button [attr.aria-label]="saveLabel">
	<i class="fa fa-save"></i>
</button>
```
Mesmo sem texto, o leitor de tela vai ler "Salvar dados", se saveLabel = `Salvar dados`.

Portanto, quando objetivo não é exibir o texto visualmente, mas fim fornecer metadados para tecnologias assistivas, o attr. é o mais utilizado, em ícones, por exemplo.

## Controlling data representation
A nova sintaxe de controle de fluxo introduzida nas versões mais recentes do framework Angular permite manipular como os dados serão representados no template do componente.

Ela apresenta um conjunto de **blocos integrados** (built-in blocks) que adicionam as seguintes funcionalidades à sintaxe de templates do Angular:
- Exibição condicional de dados
- Iteração sobre conjuntos de dados
- Alternância entre templates

Exemplo:
1. Exibição condicional de dados
```html
@if (user.loggedIn) {
	<p>Bem-vindo, {{user.name}}!</p>
} @else {
	<p>Por favor, faça o login.</p>
}
```

2. Iteração sobre dados, repete um bloco HTML para cada item em uma lista
```html
@for (let item of items) {
	<li>{{item.name}}</li>
}
```

3. Alternância entre templates (switch), mostra diferentes blocos com base no valor de uma variável
```html
@switch (status) {
  @case ('loading') {
    <p>Carregando...</p>
  }
  @case ('error') {
    <p>Ocorreu um erro!</p>
  }
  @default {
    <p>Pronto!</p>
  }
}
```

### Display data conditionally
