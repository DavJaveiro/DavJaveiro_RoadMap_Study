Neste capítulo, descreveremos os fundamentos da programação React. Abordaremos as habilidades necessárias para criar funcionalidades básicas em nosso frontend React. Em JavaScript, utilizamos a sintaxe do ECMAScript 2015 (ES6), pois ela oferece diversos recursos que tornam o código mais limpo.

Neste capítulo, veremos os seguintes tópicos:

Criação de componentes React

Recursos úteis do ES6

JSX e estilização

Props e estado

Renderização condicional

Hooks do React

A Context API

Manipulação de listas, eventos e formulários com React

## Creating React components

O React é uma biblioteca JavaScript para interfaces do usuário (UIs). A partir da versão 15, o React tem sido desenvolvido sob a licença MIT. O React é baseado em componentes, e esses componentes são independentes e reutilizáveis. Os componentes são os blocos fundamentais do React.

Quando começamos a desenvolver uma interface com React, é recomendável iniciar criando interfaces simuladas (mock interfaces). Dessa forma, fica mais fácil identificar quais tipos de componentes serão necessários e como eles interagem entre si.

A partir da seguinte interface simulada, podemos ver como a UI pode ser dividida em componentes. Nesse caso, haverá um componente raiz da aplicação, um componente de barra de pesquisa, um componente de tabela e um componente de linha da tabela:

The components podem ser organizados de forma hierárquica, como mostrado na figura abaixo:

The root componente possuí dois componentes filhos: the search componente e a tabela componente. A tabela componente tem apenas um único filho, the table row componente.

O ponto importante a entender sobre o React é que o fluxo de dados ocorre do componente pai para o componente filho. Mais adiante, aprenderemos como os dados podem ser passados de um componente pai para um componente filho utilizando props.

O React utiliza o modelo de objeto de documento virtual (Virtual Document Object Model - VDOM) para a re-renderização seletiva da interface do usuário, o que torna o processo mais eficiente. O modelo de objeto de documento (DOM) é uma interface de programação para documentos web que representa a página da web como uma árvore estruturada de objetos. Cada objeto na árvore corresponde a uma parte do documento. Usando o DOM, programadores podem criar documentos, navegar por sua estrutura e adicionar, modificar ou excluir elementos e conteúdos. O VDOM é uma cópia leve do DOM, e a manipulação do VDOM é muito mais rápida do que a manipulação do DOM real. Após a atualização do VDOM, o React o compara com uma captura anterior (snapshot) do VDOM tomada antes das alterações. Após essa comparação, o React identifica quais partes foram modificadas e somente essas partes serão atualizadas no DOM real.

Quando o estado da aplicação muda, a biblioteca (React) atualiza o VDOM em vez do DOM real imediatamente.

O framework compara a versão anterior do VDOM com a nova (diffing algorithm).

Ele calcula qual parte realmente mudou.

Só então aplica as mudanças necessárias no DOM real (reconciliation).

Ele diminui operações pesadas no DOM real, atualizando apenas o necessário.

Permite programar como se toda a UI fosse redesenhada sempre, mas de forma eficiente.

Facilita a criação de interfaces reativas que acompanham mudanças de estado sem esforço manual.

Exemplo de uso: alteramos o texto de um botão baseado em um estado. O React recria o VDOM com o novo botão, ele percebe que só o texto mudou e atualiza apenas esse detalhe no DOM real, sem mexer no resto da página.

O VDOM mostra vantagem em aplicações complexas e dinâmicas, onde o estado muda o tempo todo (dashboards, redes sociais, apps de mensagens).

Um componente React pode ser definido utilizando uma função JavaScript, um componente funcional, ou uma classe JavaScript ES6, um componente de classe. Exploraremos o ES6 mais profundamente na próxima seção.

Aqui está um exemplo simples de código-fonte de um componente que renderiza o texto "Hello World". Este primeiro bloco utiliza uma função JavaScript

```javascript
function app() {
	return <h1> Hello World</h1>
}
```

A declaração return obrigatória no componente funcional React define como o componente será exibido.

Alternativamente, o código a seguir utiliza uma classe ES6 para criar um componente:

```javascript
class App extends React.Component {
	render() {
		return <h1>Hello World</h1>
	}
}
```
O componente da classe contém o método obrigatório render(), responsável por exibir e atualizar a saída renderizada do componente. Ao comparar os componentes funcionais e de classe App, percebe-se que o método render() não é necessário no componente funcional. Antes da versão 16.8 do React, era necessário usar class componentes para usar states. Agora, você pode usar hooks para criar states com functional components também. Aprenderemos sobre states e hooks mais adiante neste capítulo.

Neste livro, criaremos componentes usando funções, o que significa que temos que escrever menos código. Functional components são uma maneira moderna de escrever componentes React, e recomendamos evitar o uso de classes.

O nome do component React deve começar com uma letra maiúscula. Também é recomendado usar a convenção de nomenclatura *PascalCase*, pela qual cada palavra começa com uma letra maiúscula.

Suponha que estejamos fazendo alterações na declaração de retorno do nosso componente de exemplo e adicionando um novo elemento h2, conforme a seguir:
```js
function App() {
	return (
		<h1>Hello World</h1>
		<h2>This is my first React component</h2>
	)
}
```
Agora, se o aplicativo for executado, veremos um erro "Adjacent JSX elements must be wrapped in an enclosing tag", conforme indicado na captura de tela a seguir:

Eu fiz a alteração e continuou funcionando. Mesmo funcionando, é uma boa prática usar um wrapper explícito:
```js
function App() {
	return (
		<>
			<h1>Hello World</h1>
			<h2>This is my first React component</h2>
		</>
	);
}
```

A opção 2, com div #wrapper:
```js
function App() {
	return (
	<div>
		<h1>Hello World</h1>
		<h2>This is my first React component
	);

}
```

Se o nosso **componente retorna múltiplos elementos**, precisamos agrupá-los dentro de um elemento pai.

Para corrigir esse erro, temos que envolver os elementos de cabeçalho em um elemento, como uma div, conforme ilustrado no seguinte trecho de código:
```js
function App() {
	return (
		<div>
			<h1>Hell World</h1>
			<h2>This is my first React component</h2>
		</div>
	);
}
```
Também podemos usar um Fragment do React, como mostrado no seguinte trecho de código. **Fragments** não adicionam nenhum nó extra à árvore DOM:
```js
// Usando fragments
function App() {
	return (
		<React.Fragment>
			<h1>Hello World</h2>
			<h2>This is my first React component</h2>
		</React.Fragment>
	);
}
```

Também existe uma sintaxe mais curta para fragments, que se parece com tags JSX vazias. 
```js
funciton App() {
	return (
		<>
		<h1>Hello World</h1>
		<h2>This is my first React component</h2>
		</>
	);

}
```
JSX é transformado em JavaScript
O JSX é convertido em chamadas de função *React.createElement()* pelo Babel.
```jsx
// Isso NÃO funciona em JavaScript:
return (
  React.createElement('h1', null, 'Hello World')
  React.createElement('h2', null, 'This is my first React component')
);
```
```jsx
// Isso funciona:
return (
  React.createElement('div', null,
    React.createElement('h1', null, 'Hello World'),
    React.createElement('h2', null, 'This is my first React component')
  )
);
```
Uma função só pode retornar **um valor**, assim como em JavaScript puro, uma função *return* só pode retornar uma única expressão.
Estrutura de árvore coerente, o React precisa de uma estrutura hierárquica clara para gerenciar a reconciliação e atualizações.
É como tentar retornar múltiplos valores de uma função:
```js
// ❌ Não funciona
function exemplo() {
  return "valor1", "valor2";
}

// ✅ Funciona - retorna um array/objeto
function exemplo() {
  return ["valor1", "valor2"];
}
```

```js
function App() {
  return (
    <div>
      <h1>Hello World</h1>
      <h2>This is my first React component</h2>
    </div>
  );
}
```
O que realmente acontece: 
```js
function App() {
	return React.createElement(
		'div',
		null,
		React.createElement('h1', null, 'Hello World'),
		React.createElement('h2, null, 'This is my first React component')
	);
}
```
- A função retorna APENAS UM elemento: a < div >
- Os elementos h1 e h2 são filhos (children) dessa div
- É uma árvore hierárquica div -> [h1, h2]


## Examining our first React app
Vamos examinar com mais cuidado o primeiro aplicativo React que criamos.

O código-fonte do arquivo *main.jsx* na pasta raiz tem esta aparência:
```js
ReactDOM.createRoot(document.getElementById('root')).render(  
  <React.StrictMode>  
    <App />  </React.StrictMode>,  
)
```
No início do arquivo, existem declarações *import* que carregam componentes e recursos para nosso arquivo. Por exemplo, a segunda linha importa o pacote *react-dom* da pasta *node_modules*, e a terceira linha importa o componente App (do arquivo App.jsx) na pasta src.  A quarta linha importa a folha de estilos index.css, que está na mesma pasta do arquivo main.jsx.

O pacote *react-dom* fornece métodos específicos do DOM para nós. Para renderizar o componente React no DOM, podemos usar o método render do pacote *react-dom*. O *React.StrictMode* é usado para encontrar problemas potenciais em nossa aplicação React e estes são impressos no console do navegador.

O Strict Mode executa apenas em modo de desenvolvimento e renderiza seus componentes uma vez extra, para que tenha tempo de encontrar bugs.

A API root é usada para renderizar componentes React dentro de um nó DOM do navegador. No exemplo a seguir, primeiro criamos uma root passando o elemento DOM para o método **createRoot**. A root chama o método *render* para renderizar um elemento na root:
```js
import ReactDOM from 'react-dom/client';
import App from './App';

// Busca no HTML um elemento com id="root"
const container = document.getElementById('root');

// Cria uma área de trabalho do React
const root = ReactDOM.createRoot(container);


// Renderiza um elemento ou o nosso componente na root
root.render(<App />);
```

Estamos conectando o mundo virtual do React com o mundo real do navegador.

O main é como nossa classe de configuração ou ponto de inicialização do aplicativo. Portanto
1. Configuração do Renderizador
	1. Define ONDE o React vai injetar os componentes (#root)
	2. Configura o sistema de renderização (ReactDOM.createRoot)

2. Configuração de Aplicação
	1. Define o componente raiz (<App />)
	2. Configura modos especiais </React.StrictMode>
	3. Importa estilos globais import './index.css'

É o primeiro arquivo JavaSscript executado, ele monta a aplicação no DOM e conecta o mundo React com o mundo HTML.. Classe main...

O container na raiz da API é o elemento < div id="root">< / div>, que pode ser encontrado no arquivo index.html na pasta raiz do projeto.

