"Para as coisas que temos que aprender antes de podermos fazê-las, aprendemos fazendo-as." - Aristóteles

Este capítulo estabelece as bases para a compreensão das partes mais profundas do JavaScript apresentadas em capítulos posteriores. Ele também lhe dará a vantagem de entender os mecanismos subjacentes aos conceitos básicos. Problemas práticos de codificação são fornecidos no final de cada seção de cada capítulo para que possamos solidificar o nosso conhecimento e melhorar a codificação em JavaScript. Muitas vezes, os aspectos básicos do JavaScript são ignorados em favor das partes mais avançadas. Aprender os fundamentos bem o suficiente nos dará a vantagem de poder compreender mais facilmente bibliotecas e estruturas como JQuery, React.js, Vue.js e outras.

Talvez você já tenha lido sobre esses conceitos e até mesmo os tenha usado em seus projetos. Nesse caso, sugiro que reforce suas habilidades praticando os exercícios de codificação no final de cada seção. Você deve usar as informações do capítulo como guia. Os exercícios vão além do básico; portanto, um conhecimento prévio de JavaScript ajuda. Neste capítulo, abordaremos os seguintes tópicos principais: 
- O que você precisa saber sobre o ECMAScript 
- Tipos de dados e variáveis 
- Operadores e comparações 
- Coerção de tipos 
- Iteração 
- Declarações condicionais

## 1.1 What we need to know about ECMA Script
A ECMA, abreviação de European Computer Manufacturer's Association, é uma organização internacional que cria padrões para tecnologias. Um desses padrões é chamado ECMA-262. O ECMA-262 é o padrão para a criação de uma linguagem de script de uso geral. Esse padrão é comumente chamado de especificação ECMAScript. Essa especificação contém regras e diretrizes para a criação de uma linguagem de script. O JavaScript é uma das principais implementações da especificação ECMAScript.

ES (ECMAScript) followed by a number, references the specific version of ECMAScript, for example, ES1, ES2, etc. So far there are 10 versions of ES from ES1 to ES10. ES.Next references the next upcoming version of ES.

Except for ES1 and ES2, each version of ES introduces a new set of features to the language. For example, regular expressions and try-catch exception handling were added to ES3. Whereas ES6 additions include arrow function expressions, *const* e *let* keywords and more.

Therefore, JavaScript continually evolves, with yearly additions POST ES6. We will explore major ES updates for each version in this interview workbook. *It is important to know what features are available for you to use rather than memorizing what ES version they belong to*.

As adições anuais do ES permitem que os fornecedores e desenvolvedores de navegadores implementem recursos em um ritmo constante. Cada navegador usa um mecanismo JavaScript diferente. O V8 é o mecanismo JavaScript do Chrome, o FireFox usa o SpiderMonkey e o Chackra é o mecanismo JavaScript do Internet Explorer. Cada navegador adota os recursos mais recentes do ES em taxas diferentes. Portanto, ao trbalhar com os recursos mais recentes do ES, podemos:
- Verificar o suporte do navegador para um recurso específico;
- Transpilar o nosso código

## 1.2 - Variables and Data Types
Variables can be defined with the following keywords:
1. Var
2. let
3. const

let and const are ES6 additions and it is preferable to use them instead of *var*, for reasons discussed later on.
var - function & global scope e Re-assignment
let (ES6) - Block Scope - Yes (outside current scope)
const (ES6) - Block scope - No Re-assignment

### 1.2.1 Scope
A própria palavra "escopo" significa "extensão" ou "intervalo" ao qual um assunto está limitado. No contexto da codificação, isso significa que o fato de podermos ou não usar uma variável é determinado pelo local em que ela é declarada no código. Há 4 tipos de escopo em um documento JavaScript, por exemplo, script.js

1. **Global scope**
Inside a JavaScript document, global scope is the area outside any functions and blocks of code. A block of code is denoted by the presence of opening and closing curly braces {}.
For example
```js
// Global scope
function x() {}
```
Here, the space outside of *function x* is called global scope.


2. **Local scope**
Local scope refers to variables that are declared and/or assigned a value within a function. For example:
```js
function localScope() {
	// local scope
}
```

Anything inside the opening and closing curly braces of function localScope has local scope.

3. **Block scope**
Block scope is defined as the area within curly braces {}. For example inside of, if-else conditional statements switch conditions, for and while loops.

```js
{
	// block scope
}
```

4. **Lexical scope**
Em uma função, qualquer bloco de código e função filha que tenha acesso às variáveis definidas dentro do escopo da função pai principal é considerado como tendo escopo lexical. Abaixo está um exemplo de declaração de variável e escopo lexical:
```js
function parentScope() {
	// Variable declared here
	function child() {
		// variables can be accessed here
	}
	child();
}
```
As variáveis declaradas na função principal *parentScope* podem ser acessadas pela função *child()*. Com isso, vamos entender os três tipos de declarações de variáveis (var, let e const) no contexto de seus diferentes escopos.
...

### 1.2.10 Non-primitive data types
This is the second category of data types in JavaScript. Listed below are the three main properties of non-primitive data types:
- Multiple values and types
- Objects
- Pass by reference

1. **Multiple values and types**
Unlike primitive types that reference only one value of a singular data type, non -primitive data types can reference multiple types of values of any data type.

2. **Objects**
Qualquer coisa que não seja um tipo de dados primitivo em JavaScript é classificada como um objeto. Os principais tipos de dados não primitivos que os desenvolvedores usam estão listados a seguir e serão analisados em detalhes nos próximos capítulos.

- Objects
- Arrays
- Functions

2. **Pass by reference**
Non-primitive data types are passed by reference compared to primitive data types that are passed by value. As such non-primitive data types are also called reference types.

Para entender por que eles são chamados de tipos de referência, precisamos examinar brevemente como as variáveis são armazenadas na memória. Uma quantidade fixa de memória é alocada para uma variável depois que ela é declarada. Para tipos de dados primitivos, o valor real na memória é copiado porque o valor atribuído a uma variável é imutável e conhecido. Posteriormente,  quantidade exata de memória que ela ocupará também é conhecida. Por exemplo, deixe user = "Hyoti", que é "100100 1111101 11011111 11110100 1101001" em binário. Já nos tipos de dados de objeto, o endereço na memória do objeto é copiado em vez do valor real. Como os objetos podem ter vários valores, que podem ou não caber na memória fixa. Veja, por exemplo, no código a seguir, o objeto chamado user, que tem uma propriedade para começar. Mas, com o tempo, você pode continuar adicionando mais propriedades conforme desejar.

```js
let user={
	role: 'developer'
};

user.employed = true;
user.name = 'Rocko';
```

When our *console.log* the user object, we see it now has all the newly added properties:
```js
Object {
	employed: true,
	name: "Rocko",
	role: "Developer"
}
```

Portanto, as propriedades e seus valores são adicionados após a declaração do objeto. Isso mostra que o tamanho da memória dos tipos de referência não é conhecido antecipadamente. Portanto, os objetos são copiados por referência em vez de por valor.

**What will the two *console.log* statements return here?**
```run-js
let num1 = 1;
function foo() {
	let num1 = 10;
	console.log(num1);
}

console.log(num1);
foo();
```

4. What is the value of *i* inside the for-loop at each iteration and outside the for-loop once iteration has ended?
```run-js
function countI() {
	for (let i = 0; i <= 5; i++) {
		console.log(i); // 0 1 2 3 4
	}
	console.log("this is " + i);
}
countI();
```

5. What is the value of *a* and *b* when function *scoping()* is called and why?
```run-js
function scoping() {
	let a = 10;
	if( a <= 10) {
		var b = 5;
		a = a + 1;
	}
	console.log(a);
	console.log(b);
}
scoping();
```

6. Analyze the following block of code. What is the value of **book**?
```run-js
{
let book = 'JavaScript is fun';
book = 'JavaScript is fun sometimes';
}
let book = 'Python is fun';
console.log(book);
```

7. **Analyze the following block of code on lexical scope and guess-estimate what will happen:**
```run-js
let outer = function() {
	if (1<2) {
		var x = 10;
	}
	if (2 < 3) {
		var xSum = 1 + x;
		console.log(xSum);
	}
	
	function foo() {
		const z = 1000;
		console.log(x);
	}
	
	foo();
}
outer();
```

8. **What is happening here with the wrapper string object?**
```js
let primitive = 'september';
primitive.vowels = 3;
primitive.vowels; // undefined;
```

### 1.3.3 Comparison operators
A comparison operator will compare 2 operands. The following table displays all the comparison operators that we should be familiar with:
