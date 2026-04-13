# The Definitive Guide - Chapter 1
- Cap 1 (1.1 - 1.3)
## Introduction to JavaScript
JavaScript é a linguagem de programação da web. A esmagadora maioria dos sites utiliza JavaScript, e todos os navegadores modernos — em desktops, tablets e smartphones — incluem interpretadores de JavaScript, tornando-a a linguagem de programação mais amplamente implantada da história.<span style="background:#d3f8b6"> Na última década, o Node.js permitiu a programação em JavaScript fora dos navegadores</span>, e o sucesso estrondoso do Node fez com que JavaScript se tornasse também a linguagem mais utilizada entre desenvolvedores de software. Esteja você começando do zero ou já utilizando JavaScript profissionalmente, este livro ajudará você a dominar a linguagem.


Se você já está familiarizado com outras linguagens de programação, pode ser útil saber que JavaScript é uma linguagem de programação de alto nível, **dinâmica** e **interpretada**, que se adapta bem aos estilos de programação **orientada a objetos** e funcional. As <span style="background:#fff88f">variáveis em JavaScript não possuem tipo fixo</span> por este motivo, utilizamos #TypeScript. Sua sintaxe é vagamente baseada em Java, mas fora isso, as linguagens não têm relação. JavaScript herda suas funções de primeira classe de *Scheme* e sua herança baseada em protótipos da linguagem pouco conhecida Self. No entanto, você não precisa conhecer nenhuma dessas linguagens, nem estar familiarizado com esses termos, para utilizar este livro e aprender JavaScript.

O nome "JavaScript" é bastante enganoso. Exceto por uma semelhança sintática superficial, JavaScript é completamente diferente da linguagem de programação Java. E JavaScript já superou há muito tempo suas origens como linguagem de script para se tornar uma linguagem de propósito geral robusta e eficiente, <span style="background:#d3f8b6">adequada para engenharia de software</span> séria e projetos com bases de código imensas.

>JavaScript: Nomes, Versões e Modos
>O JavaScript foi criado na Netscape nos primórdios da web e, tecnicamente, "JavaScript" é uma marca registrada licenciada da Sun Microsystems (atualmente Oracle) usada para descrever a implementação da linguagem pela Netscape (agora mozila). A Netscape submeteu a linguagem para padronização à ECMA — _European Computer Manufacturer's Association_ — e, devido a questões de marca registrada, a versão padronizada da linguagem recebeu o nome inconveniente de "ECMAScript". Na prática, todos simplesmente chamam a linguagem de JavaScript. Este livro utiliza o nome "ECMAScript" e a abreviação "ES" para se referir ao padrão da linguagem e às suas versões.
>Durante a maior parte dos anos 2010, a versão 5 do padrão ECMAScript foi suportada por todos os navegadores. Este livro trata o ES5 como a base de compatibilidade e não aborda mais versões anteriores da linguagem. O ES6 foi lançado em 2015 e trouxe grandes novidades — incluindo a sintaxe de classes e módulos — que transformaram JavaScript de uma linguagem de script em uma linguagem de propósito geral robusta, adequada para engenharia de software em larga escala. Desde o ES6, a especificação ECMAScript adotou um ritmo de lançamento anual, e as versões da linguagem — ES2016, ES2017, ES2018, ES2019 e ES2020 — são agora identificadas pelo ano de lançamento.
>Conforme JavaScript evoluiu, os projetistas da linguagem tentaram corrigir falhas das versões iniciais (anteriores ao ES5). Para manter a compatibilidade com versões anteriores, não é possível remover funcionalidades legadas, por mais problemáticas que sejam. Porém, no ES5 e versões posteriores, os programas podem optar pelo _strict mode_ do JavaScript, no qual diversos erros antigos da linguagem foram corrigidos. O mecanismo para aderir a ele é a diretiva `"use strict"`, descrita na seção §5.6.3. Essa seção também resume as diferenças entre o JavaScript legado e o JavaScript em modo estrito. No ES6 e versões posteriores, o uso de novos recursos da linguagem frequentemente invoca implicitamente o modo estrito. Por exemplo, se você usar a palavra-chave `class` do ES6 ou criar um módulo ES6, todo o código dentro da classe ou módulo será automaticamente estrito, e os recursos antigos e problemáticos não estarão disponíveis nesses contextos. Este livro abordará os recursos legados do JavaScript, mas terá o cuidado de apontar que eles não estão disponíveis no modo estrito.


Para ser útil, toda linguagem precisa de uma plataforma, ou biblioteca padrão, para executar tarefas como entrada e saída básicas. A linguagem JavaScript central define uma API mínima para trabalhar com números, texto, arrays, conjuntos (sets), mapas e assim por diante, <span style="background:#d3f8b6">mas não inclui nenhuma funcionalidade de entrada e saída.</span> A entrada e saída (assim como recursos mais sofisticados, como rede, armazenamento e gráficos) são responsabilidades do "ambient host" no qual o JavaScript está incorporado.

O ambiente host original para JavaScript era o navegador web, e este continua sendo o ambiente de execução mais comum para o código JavaScript. <span style="background:#d3f8b6">O ambiente do navegador permite que o código JavaScript obtenha entrada do usuário por meio do mouse e teclado</span>, além de fazer requisições HTTP. E permite que o código JavaScript exiba saída para o usuário com HTML e CSS.


Desde 2010, outro ambiente host está disponível para o código JavaScript. Em vez de restringir o JavaScript a trabalhar com as APIs fornecidas por um navegador, o #Node concede ao JavaScript acesso a todo o sistema operacional, permitindo que programas em JavaScript leiam e escrevam arquivos, enviem e recebam dados pela rede e façam e atendam requisições HTTP. O Node é uma escolha popular para implementar servidores web e também uma ferramenta conveniente para escrever scripts utilitários simples como alternativa a scripts de shell. 

A maior parte deste livro é focada na própria linguagem JavaScript. O Capítulo 11 documenta a biblioteca padrão do JavaScript, o Capítulo 15 apresenta o ambiente host do navegador e o <span style="background:#d3f8b6">Capítulo 16 apresenta o ambiente host do Node</span>.

Este livro aborda primeiro os fundamentos de baixo nível e, em cima deles, constrói abstrações mais avançadas e de alto nível. Os capítulos devem ser lidos mais ou menos em ordem. Mas aprender uma nova linguagem de programação nunca é um processo linear, e descrever uma linguagem também não é: cada recurso da linguagem está relacionado a outros recursos, e este livro está repleto de referências cruzadas — às vezes para trás, às vezes para frente — a material relacionado. Este capítulo introdutório faz uma primeira passagem rápida pela linguagem, apresentando os principais recursos que facilitarão a compreensão do tratamento aprofundado nos capítulos seguintes. Se você já é um programador JavaScript atuante, provavelmente pode pular este capítulo. (Embora você possa se divertir lendo o Exemplo 1-1 no final do capítulo antes de prosseguir.)

## 1.1 Exploring JavaScript
Ao aprender uma nova linguagem de programação, é importante experimentar os exemplos do livro, depois modificá-los e testá-los novamente para verificar sua compreensão da linguagem. Para fazer isso, precisamos de um interpretador JavaScript.

A maneira mais fácil de testar algumas linhas de JavaScript é abrir as ferramentas de desenvolvedor web em nosso navegador (com F12, Ctr-shift-l ou Command-Option-I) e selecionar a aba Console. Em seguida, podemos digitar código no prompt e ver os resultados à medida que digitamos. As ferramentas de desenvolvedor do navegador geralmente aparecem como painéis na parte inferior ou lateral da janela do navegador, mas normalmente é possível destacá-las como janelas separadas (como ilustrado na Figura 1-1), o que costumam ser bastante conveniente.


**Figura 1-1.** O console JavaScript nas Ferramentas de Desenvolvedor do Firefox

Outra maneira de experimentar código JavaScript é baixar e instalar o Node a partir de *https://nodejs.org*. Assim que o Node estiver instalado em nosso sistema, podemos simplesmente abrir uma janela do Terminal e digitar *node* para iniciar uma sessão interativa de JavaScript como esta:

## Hello World
Quando estivermos pronto para começar a experimentar trechos de código mais longos, esses ambientes interativos linha por linha podem não ser mais adequados, e provavelmente preferiremos escrever o nosso código em um editor de texto. A partir daí, podemos copiar e colar no console JavaScript ou em uma sessão do Node. Ou podemos salvar o nosso código em um arquivo (a extensão tradicional para arquivos de código JavaScript é *.js*) e então executar esse arquivo com o Node:
```bash
node snippet.js
```

Se usarmos o Node de forma não interativa, ele não imprimirá automaticamente o valor de todo o código executado, então vamos precisar fazer isso por conta própria. Podemos usar a função *console.log()* para exibir texto e outros valores de JavaScript na janela do terminal ou no console das ferramentas de desenvolvedor do navegador. Por exemplo, podemos criar um arquivo *hello.js* contendo esta linha de código:
```js
console.log("Hello World!");
```

Ao executarmos o arquivo com `node hello.js`, veremos a mensagem "Hello World!" impressa.

Se quisermos ver a mesma mensagem impressa no console JavaScript de um navegador, devemos criar um novo arquivo chamado *hello.html* e colocar este texto nele:
```html
<script src="hello.js"></script>
```
Em seguida, carreguemos o *hello.html* do nosso navegador usando uma URL...

## 1.3 A Tour of JavaScript
Esta seção apresenta uma introdução rápida, por meio de exemplos de código, à linguagem JavaScript. Após este capítulo introdutório, mergulhamos no JavaScript em seu nível mais baixo: o Capítulo 2 explica coisas como comentários em JavaScript, ponto e vírgula e o conjunto de caracteres Unicode. O Capítulo 3 começa a ficar mais interessante: explica as variáveis em JavaScript e os valores que você pode atribuir a essas variáveis.

Aqui está um exemplo de código para ilustrar os destaques desses dois capítulos:
```js
// Qualquer coisa após duas barras é um comentário.
// Leia os comentários com atenção: eles explicam o código JavaScript.

// Uma variável é um nome simbólico para um valor.
// As variáveis são declaradas com a palavra-chave let:
let x; // Declara uma variável chamada x.

// Valores podem ser atribuídos a variáveis com o sinal =
x = 0; // Agora a variável x tem o valor 0
x // => 0: uma variável é avaliada como seu valor.

// JavaScript suporta vários tipos de valores
x = 1; // Números.
x = 0.01; // Números podem ser inteiros ou reais.
x = "hello world"; // Aspas simples também delimitam strings.
x = true; // um valor booleano.
x = false; // O outro valor booleano.
x = null; // Null é um valor especial que significa "nenhum valor".
x = undefined; // Undefined é outro valor especial como null.
```

Dois outros tipos muitos importantes que os programas JavaScript podem manipular são #objetos e #arrays. Esses são os assuntos dos Capítulos 6 e 7, mas eles são tão importantes que os veremos muitas vezes antes de chegar a esses capítulos:
```js
// O tipo de dado mais importante em JavaScript é o objeto.
// Um objeto é uma coleção de pares nome/valor, ou um mapa de string para valor.
let book = {
	topic: "JavaScript, // A propriedade "topic" tem o valor "JavScript"
	edition: 7 // A propriedade "edition" tem o valor 7
};  // A chave marca o fim do objeto.

// Access the properties of an object with . or []:
book.topic // => "JavaScript"
book["edition"] // 7: another way to access property values
book.autor = "Flanagan";
book.contents = {};

// Acesse propriedades condicionalmente com ?. (ES2020):
book.contents?.ch01?.sect1 // => undefined: bok.contents não tem propriedade ch0.1.

// JavaScript also supports arrays (numerically indexed lists) of values:
let primes = [2, 3, 5, 7]; // An array of 4 values, delimited with [ and ]
primes[0] // => 2: the first element (index 0) of the array
primes.length // => 4: how many elements in the array
primes[primes.length-1] // => 7: the last element of the array.
primes[4] = 9; // add a new element by assignment.
primes[4] = 11; // Or alter an existing element by assignment.
let empty = []; // [] is an empty array with no elements.
empty.length // => 0

// Arrays and objects can hold other arrays and objects:
let points = [
	{x: 0, y: 0},
	{x: 1, y: 1}
];
let data = {  // An object with 2 properties
	trial1: [[1,2], [3, 4]],
	trial2: [[2,3], [4, 5]] // the elements of the arrays are arrays
}
```

> Sintaxe de Comentários em Exemplos de Código
> Alguns comentários começam com uma seta (=>). Eles mostram o valor produzido pelo código antes do comentário e são uma tentativa de emular um ambiente JavaScript interativo, como um console de navegador web, em um livro impresso. Esses comentários // => também funcionam como uma assertion, e eu escrevi uma ferramenta que testa o código e verifica se ele produz o valor especificado no comentário. Isso deve ajudar.

A sintaxe ilustrada aqui para listar elementos de um array dentro de colchetes (square braces) ou mapear nomes de propriedades de objeto para valores de propriedade dentro de chaves (curly braces) é conhecida como expressão inicializadora (initializer expression), e é apenas um dos tópicos do Capítulo 4. Uma expressão (expression) é uma frase do JavaScript que pode ser avaliada para produzir um valor. Por exemplo, o uso de . e [] para se referir ao valor de uma propriedade de objeto ou elemento de array é uma expressão.

One of the most common ways to form expressions in JavaScript is to use operators:

```js
// Operators act on values (the operands) to produce a new value.
// Arithmetic operators are some of the simplest:
3 + 2 // => 5: addition
3 - 2 // => 1: subtraction
3 * 2 // => 6: multiplication
3 / 2 // => 1.5: division
points[1].x - points[0].x // => 1: more complicated operands also work
"3" + "2" // => "32": + adds numbers, concatenates strings

// JavaScript defines some shorthand arithmetic operators
let count = 0; // Define a variable
count++; // Increment the variable
count--; // Decrement the variable
count += 2; // add 2: same as count = count + 2;
count *= 3; // Multiply by 3: same as count = count * 3;
count // => 6: variable names are expressions, too.

// Equality and relational operators test whether two values are equal, unequal, less than, greater than, and so on. They evaluate to true or false.
let x = 2, y = 3;
x === y // false: equality
x !== y // => true: inequality
x < y // True: less-than
x <= y // => true: less-than or equal
x > y // => false: greater-than
x >= y // => false: greater-than or equal
"two" === "three" // false
"two" > "three" // => true: "tw" is alphabetically greater than "th"
false === (x > y) // => true: false is equal to false

// Logical operators combine or invert boolean values
(x === 2) && (y === 3) // => true: both comparisons are true. && is AND
(x > 3) || (y < 3) // => false: neither comparison is true.
!(x === y) // => true: ! inverts a boolean value
```

Se expressões JavaScript são como frases, então as instruções (statements) JavaScripts são como sentenças completas. Statements são o tópico do Capítulo 5. De forma geral, uma expressão (expression) é algo que calcula um valor, mas não faz nada além disso: não altera o estado do programa de nenhuma forma. Já as statements, por outro lado, não têm um valor, mas alteram o estado.

Já vimos declarações de variáveis e instruções de atribuição acima. A outra grande categoria de statement são as estruturas de controle, como condicionais e loops. Veremos exemplos abaixo, depois de cobrirmos funções.

Uma função é um bloco de código JavaScript nomeado e parametrizado que definimos uma vez e pode invocar repetidamente. Funções não são abordadas formalmente até o Capítulo 8, mas, assim como objetos e arrays, os veremos muitas vezes antes de chegarmos lá. Aqui estão alguns exemplos simples:
```js
// Funções são blocos de código JavaScript parametrizados que podemos invocar.
function mais1(x) {
	return x + 1; // Retorna uma unidade maior do que o valor recebido
} // funções são delimitadas por chaves

mais1(y) // => 4: y é 3,então essa invocação retorna 3+1

let quadrado = function(x) {
	return x * x; // Calcula o valor da função
}; // Ponto e vírgula marca o fim da atribuição

quadrado(mais1(y) // => 16: invoca duas funções em uma única expressão)
```

