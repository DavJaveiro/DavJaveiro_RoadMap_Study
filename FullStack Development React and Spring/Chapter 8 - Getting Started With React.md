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
O componente da classe contém o método obrigatório render(), responsável por exibir e atualizar a saída renderizada do componente. Ao comparar os componentes funcionais e de classe App, percebe-se que o método render() não é necessário no componente funcional.