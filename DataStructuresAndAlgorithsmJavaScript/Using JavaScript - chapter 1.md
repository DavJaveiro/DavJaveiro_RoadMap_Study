O JavaScript evoluiu e adicionou funcionalidades significativas desde sua versão original de 1995. O acréscimo de classes à linguagem ajudou na programação orientada a objetos, de modo que não é mais necessário trabalhar com protótipos complexos. Os operadores de desestruturação e propagação simplificaram o trabalho com objetos e matrizes e permitem que gerenciemos várias atribuições ao mesmo tempo. A introdução das arrow functions permite que trabalhemos de forma mais sucinta e expressiva, aprimorando o recurso de programação funcional do JavaScript. Por fim, o conceito de módulos simplificou a organização código e permite que dividamos e agrupe o nosso código de maneira lógica. 

Este capítulo explora brevemente esses recursos modernos da linguagem que o ajudam a escrever códigos melhores, mais curtos e mais compreensíveis. 

## Modern JavaScript Features
We'll start with an exploration of some modern JavaScript features that will simplify coding: arrow functons, classes, spreading values, destrucuring, and modules. This list ins't exhaustive, and we'll look at other features in later chapters, including functional programming, map/reduce and similar array methods, functions as first-class objects, recursion, and more. We certainly can't cover all of the language's features, but here the focus in on the most important and newer features that are used throughout the book.

### Arrow Functions
O JavaScript oferece muitas formas de definir uma função, como:
- Funções nomeadas, que são as mais comuns: *function alpha() {...}*
- Expressões de função sem nome: *const bravo = function () {...}*;
- Expressões de função nomeadas: *const charlie = function something() {...}*;
- Construtores de função: *const delta = new Function()*
- Arrow functions (funções de seta): *const echo = () => {...}*

Todas essas definições funcionam basicamente da mesma forma, mas as arrow functions os "novatos" do JavaScript, possuem estas diferenças importanes:
- Elas podem retornar um valor mesmo sem incluir uma instrução *return*;
- Elas não podem ser usadas como construtores nem como geradores;
- Elas não fazem bind do valor de this
- Elas não possuem um objeto *arguments* nem uma propriedade *prototype*.

Em especial, a primeira característica da lista acima é muito utilizada neste livro; a possibilidade de omitir a palavra-chave *return* permite escrever um código mais curto e mais conciso. Por exemplo, no Capítulo 12, encontraremos a seguinte função:
```js
const _getHeight = (tree) => (isEmpty(tree) ? 0 : tree.height);
```
Dado um argumento tree, essa função retorna 0 se a árvore estiver vazia; caso contrário, ela retorna o atributo *height* do objeto *tree*.

O exemplo a seguir usa *return* e é uma forma equivalente (porém mais longa) de escrever a mesma função:
```js
const _getHeight = (tree) => {
	return isEmpty(tree) ? 0 : tree.height;
};
```

A versão mais longa não é necessária: código mais curto é melhor;

Se usarmos a versão encurtada e quisermos retornar um objeto, é preciso colocá-lo entre parênteses. 

Outro exemplo de arrow function:
```js
const newNode = (key) => ({
	key,
	left: null,
	right: null,
	height: 1
});
```

Dado um key, essa função retorna um nó (na verdade, um objeto) com essa chave como atributo, além de referências left e right definidas como null e um atributo height configurado com o valor 1.

Outra característica comum das arrow functions é a definição de valores padrão para parâmetros ausentes:
```js
const print = (tree, s = "") => {
	if (tree !== null) {
		console.log(s, tree.key);
		print(tree.left, `${s} L:`);
	    print(tree.right, `${s} R:`);
	}
};
```
Funções recursivas ^

Isso é justamente o padrão de percurso de árvore binária (tranversal). Cada chamada vai imprimir o nó atual e depois explorar recursivamente os filhos esquerdo e direito.

### Classes
Embora não usemos muito as classes neste livro, o JavaScript moderno evoluiu bastante desde o seu início e, em vez de ter que lidar com o #prototype e adicionar código confuso para implementar herança, agora é possível obter herança com facilidade. 

Demonstrando uma classe real e como defini-la:
```javascript
class Tree {
	_children = [];
	
	constructor(rootkey) {
		this._key = rootkey;
	}
	
	isEmpty() {
		return this._key === undefined;
	}
	
	get key() {
		this._throwIfEmpty();
		return this._key;
	}
	
	set key(v) {
		this._key = v;
	}
}
```

Podemos definir uma classe simples, como é o caso aqui, ou estender uma já existente. Por exemplo, podemos ter outra classe **BinaryTree extends Tree** para definir uma classe baseada em **Tree**. É possível definir atributos fora do construtor; não é obrigatório fazer isso dentro do construtor. Construtores estão disponíveis caso precisemos de uma inicialização mais complexa das instâncias do objeto.

Getters e Setters são outros recursos poderosos. Eles vinculam uma propriedade do objeto a funções que são chamadas sempre que tentamos modificar ou acessar essa propriedade.

Outros recursos não utilizados neste exemplo são as propriedades e métodos *static*; esses atributos não fazem parte das instâncias da classe, mas sim pertencem à própria classe.

**NOTA:** A partir do ECMAScript 2022, o JavaScript também inclui propriedades privadas: campos, métodos, getters, setters e assim por diante.

### The Spread Operator
O operador de espalhamento (...) permite, basicamente, "espalhar" um array, string ou objeto em valores separados em uma única operação, possibilitando usos interessantes com arrays e objetos.

Com arrays, ele é usado assim:
```js
const myArray = [3, 1, 4, 1, 5, 9, 2, 6];
const arrayMax = Math.max(...myArray);
const newArray = [...myArray];
```
Escrever `...myArray` é o mesmo que escrever `3, 1, 4, 1, 5, 9, 2, 6`, então o primeiro uso de `...myArray` nesse exemplo produz `9`, e o segundo cria um novo array com exatamente os mesmos elementos de `myArray`.

Podemos usar o operador de espalhamento para criar uma cópia de um objeto, que depois pode ser modificada de forma independente:
```js
const myObject = { last: "Darwin", year: 1809};
const newObject = { ...myObject, first: "Charles", year: 1882};
```

Nesse caso, `newObject` primeiro recebe uma cópia dos atributos de `myObject`, e depois o atributo `year` é sobrescrito. Você poderia fazer isso “da maneira antiga”, com várias atribuições individuais, mas usar o operador de espalhamento permite um código mais curto e claro.

Um terceiro uso do operador de espalhamento é em funções que precisam lidar com um número indefinido de parâmetros. Versões antigas do JavaScript usavam o objeto `arguments` (semelhante a um array) para tratar essa situação. O objeto `arguments` é “semelhante a um array” porque a única propriedade de array que ele possui é `.length`. Ele não inclui outras propriedades que arrays têm.

Podemos escrever, nossa própria versão de Math.max() assim:
```js
const myMax = (...nums) => {
  let max = nums[0];
  for (let i = 1; i < nums.length; i++) {
    if (max < nums[i]) max = nums[i];
  }
  return max;
};
```
Agora, podemos usar **myMax()** como usaríamos **Math.max()**, mas não há motivo para reinventar essa função. Esse exemplo mostra como podemos imitar recursos de funções existentes, neste caso, a capacidade de passar vários argumentos para uma função.

O *spread operator* pode ser usado para iterar item por item de coleções como arrays, strings ou objetos iteráveis. Ele basicamente "espalha" os elementos, permitindo que sejam tratados individualmente.

```js
const frutas = ["🍎", "🍌"];
const maisFrutas = ["🍇", "🍍"];

const todas = [...frutas, ...maisFrutas];
console.log(todas); // ["🍎", "🍌", "🍇", "🍍"]
```

Espalhar uma string em caracteres
```js
const palavra = "Copilot";
const letras = [...palavra];
console.log(letras); // ["C", "o", "p", "i", "l", "o", "t"]
```

O Spread não substitui métodos de iteração como *for*, *map*, *forEach*. Ele apenas **expande** os elementos, permitindo que sejam tratados individualmente em contextos específicos (funções, arrays, objetos).
### The Destructuring Statement
A instrução de **desestruturação** está relacionada ao operador de espalhamento. Ela permite atribuir várias variáveis ao mesmo tempo, o que significa podemos combinar várias atribuições independentes em uma só e escrever um código mais curto. Por exemplo:
```js
[first, last] = ["Abraham", "Lincoln"];
```
Neste caso, atribuímos "Abraham" à variável *first* e **Lincoln** à variável *last*.

Também podemos misturar **desestruturação** e **spread**:
```js
[first, last, ...years] = ["Abraham", "Lincoln", 1809, 1865];
```
Os elementos iniciais do array são atribuídos a *first* e *last*, como no exemplo anterior, e todos os elementos restantes (os dois números) são atribuídos ao array **years**. Essa combinação permite escrever o código de forma mais concisa, usando uma única instrução onde antes seriam necessárias várias.

Além disso, podemos usar **valores padrão** quando variáveis do lado esquerdo não têm valores correspondentes no lado direito:
```js
let [first, last, role = "President", party] = ["Abraham", "Lincoln"];
```
Nesse exemplo, a instrução de desestruturação atribui um valor padrão a `role` e deixa `party` como `undefined`.

Também podemos trocar *swap* ou *rotacionar* variáveis, uma técnica usada com frequência mais adiante no livro. Considere esta linha de código do Capítulo 14:
```js
[heap[p], heap[i]] == [heap[i]], heap[p]];
```
Isso troca diretamente os valores de **heap[p]** e **heap[i]** sem usar uma variável auxiliar. Também poderíamos escrever algo como:
```js
[d, e, f] = [e, f, d];
```

para rotacionar os valores de três variáveis, novamente sem precisar de variáveis extras.

Por fim, outro padrão que usaremos bastante é retornar dois ou mais valores de uma função ao mesmo tempo. Por exemplo:
```js
const order2 = (a, b) => {
	if (a < b) {
		return [a, b];
	} else {
		return [b, a];
	}
};

let [smaller, bigger] = order2(22, 9);
```

### Modules
Os módulos permitem dividir o código em partes que podem ser importadas quando necessário, oferecendo uma forma de organizar funcionalidades de modo mais fácil de entender e manter. Cada módulo deve ser um conjunto de funções e classes relacionadas, fornecendo um conjunto de recursos. Uma prática padrão ao usar módulos é a **alta coesão**, que significa que os elementos agrupados realmente devem pertencer juntos, pois funcionalidades não relacionadas não devem ser misturadas no mesmo módulo. Um conceito relacionado, chamado **baixo acoplamento**, significa que módulos distintos devem depender o mínimo possível um dos outros. O JavaScript permite organizar funções em módulos para fornecer um design bem estruturado, com maior legibilidade e manutenibilidade.

Os módulos existem em dois formatos: **CommonJS** (um formato mais antigo, usado principalmente no Node.js) e **ECMAScript Modules (ESM)** (o formato mais recente), geralmente usado por navegadores).

**Módulos CommonsJS**
Com módulos CommonJS, escrevemos código no estilo deste exemplo (resumido) do Capítulo 16:
```js
const EOW = "■";
const newRadixTree = () => null;
const newNode = () => ({ links: {} });
const isEmpty = (rt) => !rt; // null ou undefined
const print = (trie, s = "") => { ... }
const printWords = (trie, s = "") => { ... }
const find = (trie, wordToFind) => { ... }
const add = (trie, wordToAdd, dataToAdd) => { ... }
const remove = (trie, wordToRemove) => { ... }

module.exports = {
	add,
	find,
	isEmpty,
	newRadixTree,
	print,
	printWords,
	remove
};
```

A atribuição a *module.exports* no final define quais partes do módulo serão visíveis externamente; qualquer coisa que não seja incluída ali, não estará acessível para o restante do sistema. Essa forma de escrever código está alinhada com o conceito de **caixa-preta** em software. Usuários de um módulo não precisam aprender nem conhecer seus detalhes internos, o que favorece maior manutenibilidade. Desde que o módulo continue oferecendo a mesma funcionalidade, seus desenvolvedores podem refatorá-lo ou melhorá-lo sem impactar os usuários.

Se quisermos importar alguma das funções exportas pelo módulo, por exemplo, podemos usar o seguinte estilo de código, que emprega desestruturação, para especificar o que deseja:
```js
const { newRadixTree, add} = require("radix_tree.js");
```

Isso permite acessar (via desestruturação) as funções *newRadixTree()* e *add()*, entre todas as funções exportadas pelo módulo *radix_tree*. Se quisermos adicionar algo à árvore radix, podemos chamar add() diretamente, da mesma forma, podemos chamar *newRadixTree()* para criar uma nova árvore.

```js
const RadixTree = require("radix_tree.js");
```
Nesse caso, para adicionar algo à árvore ou criar uma nova, você precisa chamar `RadixTree.add()` e `RadixTree.newRadixTree()`. Esse uso gera um código mais longo, mas também permite acessar todas as funções do módulo `radix_tree`. O autor prefere o primeiro estilo, que usa desestruturação, porque deixa claro o que está sendo utilizado, mas a escolha é sua.

### Módulos ECMAScript
O estilo mais moderno de definição de módulos no ECMAScript também funciona com arquivos separados, mas em vez de criar um objeto *module.exports*, você reescreve o módulo visto na seção anterior da seguinte forma:

```js
// arquivo: radix_tree.js – estilo moderno
const EOW = "■";

export const newRadixTree = () => null;
const newNode = () => ({ links: {} });
export const isEmpty = (rt) => !rt; // null ou undefined
const print = (trie, s = "") => { ... }
const printWords = (trie, s = "") => { ... }
const find = (trie, wordToFind) => { ... }
const add = (trie, wordToAdd, dataToAdd) => { ... }
const remove = (trie, wordToRemove) => { ... }

export {
  add,
  find,
  print,
  printWords,
  remove
};

```

Podemos exportar algo diretamente onde ele é definido ou deixar para fazer isso no final do arquivo. Ambos os métodos funcionam (e dificilmente alguém usaria os dois estilos ao mesmo tempo, como feito feito neste exemplo), mas a maioria das pessoas prefere deixar todas as instruções *export* juntas no final. A escolha é nossa.

**NOTA:** Você também pode usar instruções `import` e `export` do ECMAScript no Node.js, mas apenas se usar a extensão `.mjs` em vez de `.js`, que é reservada para módulos CommonJS.

Você pode importar funções de um módulo ECMAScript da seguinte forma, que é um uso diferente em comparação com os módulos CommonJS, embora o resultado final seja exatamente o mesmo:
```js
import { newRadixTree, add } from "radix_tree.js";
```

Todas as exportações vistas até agora são **exportações nomeadas**; você pode ter quantas quiser, e também pode ter uma única exportação padrão (default) sem nome. Em um arquivo, em vez de definir o que deseja exportar como descrito antes, você pode incluir algo como isto:
```js
// arquivo: my_module.js
export default something = ... // o que você quiser exportar

```

Depois, em outras partes do código, você pode importar assim:
Você pode dar ao que foi importado o nome que quiser (embora “whatever” não seja um bom nome), em vez de usar o nome pretendido por quem criou o módulo. Isso não é uma prática comum, mas às vezes surgem conflitos de nomes ao usar módulos de autores diferentes.

### **Closures e Funções Imediatamente Invocadas (IIFE)**

Closures e expressões de função imediatamente invocadas não são exatamente novas, mas entendê-las será útil para acompanhar os exemplos deste livro. Uma **closure** é a combinação de uma função com o escopo em que ela foi criada, ao qual a função tem acesso. Isso permite ter **variáveis privadas**, o que, por sua vez, possibilita criar o equivalente a classes e módulos. Por exemplo, considere a seguinte função:

```js
function createPerson(firstN, lastN) {
  let first = firstN;
  let last = lastN;

  return {
    getFirst: function () {
      return first;
    },
    getLast: function () {
      return last;
    },
    fullName: function () {
      return first + " " + last;
    },
    setName: function (firstN, lastN) {
      first = firstN;
      last = lastN;
    }
  };
}
```

O valor retornado (um objeto) terá acesso às variáveis `first` e `last` dentro do escopo da função. Por exemplo:

```js
const me = createPerson("Federico", "Kereki");
console.log(me.getFirst()); // Federico
console.log(me.getLast()); // Kereki
console.log(me.fullName()); // Federico Kereki
me.setName("John", "Doe");
console.log(me.fullName()); // John Doe
```

Essas variáveis não são acessíveis em nenhum outro lugar. Se você tentar acessar `me.first` ou `me.last`, receberá `undefined`. Essas variáveis fazem parte da closure, mas não há como acessá-las diretamente, pois funcionam como valores privados.

Usar closures também permite simular módulos. Para isso, você precisa de uma **função imediatamente invocada** (IIFE — _Immediately Invoked Function Expression_), pronunciada “iffy”, que é uma função definida e executada assim que é criada.

Suponha que você queira um módulo para trabalhar com impostos. Sem usar os novos módulos, você poderia fazer algo semelhante à função `createPerson(...)`:

```js
const tax = (function (basicTax) {
  let vat = basicTax;
  /*
    ...muitas outras variáveis relacionadas a impostos
  */
  return {
    setVat: function (newVat) {
      vat = newVat;
    },
    getVat: function () {
      return vat;
    },
    addVat: function (value) {
      return value * (1 + vat / 100);
    }
    /*
      ...muitas outras funções relacionadas a impostos
    */
  };
})(6);
```

Você cria uma função (sem nome) e a chama imediatamente, e o resultado funciona como um módulo. É possível passar valores iniciais para a IIFE, como 6% para o imposto sobre valor agregado (VAT) padrão. A variável `vat`, e outras que você declarar, são internas e não podem ser acessadas diretamente. No entanto, as funções fornecidas, como `addVat(...)`, podem trabalhar com todas as variáveis internas.

Use o módulo baseado em IIFE assim:

```js
console.log(tax.getVat()); // 6: valor padrão inicial
tax.setVat(8);
console.log(tax.getVat()); // 8
console.log(tax.addVat(200)); // 216
```

Os módulos podem fornecer a mesma funcionalidade básica, mas você verá casos em que closures e IIFEs serão úteis — por exemplo, no Capítulo 5, onde são discutidos memoização e pré-cálculo de um array de valores.

**Formatação com Prettier**
A forma de formatar o código-fonte pode ser outra fonte de discordâncias. Cada desenvolvedor com quem trabalharmos provavelmente terá sua própria opinião sobre esse assunto, defendendo que seu padrão é o melhor. Se você trabalha com uma equipe de desenvolvedores, talvez esteja familiarizado com a situação mostrada na tirinha "How Standards Proliferate" do xkcd (Figura 1-3);

## ESLint
**ESLint** é um analisador de código (linter) para JavaScript...
Ele lê seu código e aponta:
- Erros
- coisas suspeitas
- práticas ruins
- violações de padrão de código

Ou seja: ele é tipo um corretor ortográfico + professor chato + revisor de qualidade, tudo junto, só que para código.

## Outro problemão que ele pega
`[] == 0      // true 0 == "0"     // true [] == "0"    // false 🤯`

Isso acontece por causa do `==` (comparação frouxa).

O ESLint tem a regra **`eqeqeq`**, que obriga usar:

`===  // comparação segura (tipo + valor)`

### Flow and TypeScript
Para desenvolvimento em larga escala, considere usar **Flow** e **TypeScript**, que permitem adicionar informações sobre tipos de dados ao JavaScript. O **Flow** adiciona comentários que descrevem quais tipos de dados são esperados para entradas e saídas de funções, variáveis e assim por diante. Já o #TypeScript é, na verdade, um **superconjunto do JavaScript** que é transpilado para ele.

