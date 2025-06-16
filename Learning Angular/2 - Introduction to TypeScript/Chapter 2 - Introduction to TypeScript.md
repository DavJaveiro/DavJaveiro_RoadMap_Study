Como vimos no capítulo anterior, ao construirmos nossa primeira aplicação Angular, o **código de um projeto Angular é escrito em TypeScript**.

Escrever em TypeScript e aproveitar sua **tipagem estática** nos dá uma **vantagem notável** em relação a outras linguagens de script.

Este capítulo **não é uma visão completa da linguagem TypeScript**. Em vez disso, vamos nos concentrar nos **elementos essenciais que serão úteis ao longo deste livro**.

Como veremos em breve, ter um **bom conhecimento desses mecanismos é fundamental para entender como funciona a injeção de dependência no Angular**.

Neste capítulo, vamos abordar os seguintes tópicos principais:
- Fundamentos do JavaScript
- O que é TypeScript?
- Introdução ao TypeScript.

## JavaScript essentials
JavaScript é uma linguagem de programação que contém muitos recursos para construir aplicações web.

Nesta seção, vamos revisitar e reforçar nosso conhecimento sobre alguns dos recursos mais básicos, pois eles estão diretamente relacionados ao desenvolvimento com TypeScript e Angular.

O TypeScript é um **superset sintáticos do JavaScript**, ou seja, ele adiciona funcionalidades como **tipos**, **interfaces** e **genéricos**. 

Vamos analisar com mais detalhes os seguintes recursos do JavaScript:
- Declaração de variáveis
- Parâmetros de funções
- Funções arrow
- Encadeamento opcional
- Coalescência nula
- Classes
- Módulos
- Programação Assíncrona (Promises e *async/await*): essencial para lidar com operações como chamadas HTTP para buscar dados de um servidor
- **Métodos de Array:** map, filter e reduce: como iremos manipular listas e coleções de dados constantemente, e esses métodos tornam o processo muito mais declarativo e limpo.
- **Desestruturação:** uma forma conveniente de extrair valores de objetos e arrays, tornando o código mais enxuto.

## Declaração de variáveis
Tradicionalmente, os desenvolvedores JavaScript utilizavam a palavra-chave *var* para declarar objetos, variáveis e outros elementos.

O motivo é que a antiga semântica da linguagem tinha apenas escopo de função, ou seja, as variáveis eram únicas dentro do contexto da função:
```js
function myFunc() {
	var x = 0;
}
```

Na função acima, nenhuma outra variável pode ser declarada como x dentro do corpo da função. Se declararmos outra variável x dentro do escopo da função, na prática, estaremos redefinindo essa variável.

No entanto, há casos em que o escopo não é aplicado da mesma forma, como em loops:
```js
var x = 20;
for( var x = 0; x < 10; x++) {
}
```

Para superar essa limitação de escopo, o JavaScript introduziu a palavra-chave *let*:
```js
function myFunc() {
	let x = 0;
	x = 10;
}
```

A palavra-chave let permite que a referência de uma variável seja alterada várias vezes no código. 

Outra forma de definir variáveis em JavaScript é com a palavra chave *const*, que indica que a variável não deve mudar.

À medida que o código cresce, alterações podem acontecer por engando, o que pode ser custoso.

O uso de const ajuda a prevenir esse tipo de erro.

Considere o seguinte trecho de código:
`const price = 100; price = 50;`

Se tentarmos executar isso, teremos o seguinte erro:
`TypeError: Assignment to constant variable.`

Esse erro aparece **quando tentamos reatribuir uma variável `const` no escopo principal**.

Isso não se aplica da mesma forma a objetos declarados como constantes:
```javascript
const product = { price:100 };
product.price = 50;
```
Declarar *product* como constante não impede alterações nas propriedades internas do objeto, apenas na referência.

Ou seja, o código acima é válido, pois estamos modificando uma propriedade, e não a referência do objeto.

Ou seja, o código acima **é válido**, pois estamos **modificando uma propriedade**, e não a referência do objeto.

Mas se fizermos isto:
`const product = { price: 100 }; product = { price: 50 }; // ❌ ERRO!`

Receberemos **o mesmo erro de antes**, pois agora estamos tentando **reatribuir a variável `const`** com um **novo objeto**, e isso **não é permitido**.

É preferível usar **const** quando temos certeza de que a variável (ou a referência) não deverá mudar durante a vida útil do código. Isso ajudar a evitar alterações acidentais, especialmente em projetos maiores.

Quando queremos combinar variáveis, podemos usar a sintaxe do operador spread.

Um parâmetro spread usa três pontos ... para expandir valores de uma variável:
```javascript
const category = 'Informática';
const categories = ['Jogos', 'Multimídia'];
const productCategories = [...categories, category];
```
No trecho acima, combinamos o array *categories* com o item category para criar um novo array.
- O novo array *productCategories* contém três itens

Esse comportamento é chamado de **imutabilidade**, ou seja:
- Não modificamos uma variável original, mas criamos uma nova com base nela.

Um objeto não é imutável se:
- Suas propriedades podem ser alteradas, ou
- Suas propriedades são objetos cujas propriedades também pode ser alteradas.

```js
const product = {
  name: 'Teclado',
  price: 75
};

const newProduct = {
  ...product,
  price: 100,
  category: 'Informática'
};

```
Neste exemplo, não alteramos o objeto *product* original. Em vez disso, criamos um novo objeto *newProduct* que:
- Copia todas as propriedades de *product*
- Substitui *price* de 75 para 100
- Adiciona uma nova propriedade *category*.

Resultado:
```js
{
	name: 'Teclado',
	price: 100,
	category: 'Informática'
}
```
O operador `...`:
- Funciona com **arrays** e **objetos**
- Ajuda a manter a **imutabilidade**
- É muito usado em Angular, React, e qualquer projeto moderno com TypeScript

## Spread Operator

## Function parameters
As funções em JavaScript são como máquinas de processamento: usamos para analisar entradas, processar informações e aplicar transformações aos dados. 

Elas utilizam parâmetros para receber dados, esses dados servem para modificar o estado da aplicação ou retornar um resultado, que pode ser usado para compor a lógica de negócio ou a interatividade da interface com o usuário.

Podemos declarar uma função com parâmetros padrão, de modo que ela assuma um valor predefinido caso esse parâmetro não seja passado durante a execução.
```javascript
function addToCart(productId, quantity = 1) {
	const product = {
		id: productId,
		qty: quantity
	};
}
```
Se não passarmos um valor para o parâmetro *quantity*, ao chamar a função, ela irá assumir automaticamente o valor 1.

Assim, teremos um objeto *product* com a propriedade *qty* igual a 1.

*Parâmetros padrão devem ser definidos após todos os parâmetros obrigatórios na assinatura da função.*

Uma vantagem significativa da flexibilidade do JavaScript ao definir funções é a capacidade de aceitar um número ilimitado de parâmetros não declarados, chamados de *parâmetros rest (rest paramters)*. Basicamente, podemos definir um parâmetro adicionar no final da lista de argumentos, precedido por reticências (...):
```js
function addProduct(name, ...categories) {
	const product = {
		name,
		categories: categories.join(',')
	};
}
addProduct("Notebook", "Eletrônicos", "Informática", "Promoção");
```

Portanto, a função poderá aceitar vários argumentos, mesmo que eles não tenham sido definidos previamente na assinatura da função.

Portanto, o objeto criado seria:
```js
{
	name: "Notebook",
	categories: "Eletrônicos,Informática,Promoção"
}
```

Portanto, o *rest parameters* transforma múltiplos argumentos em um array. Utilizamos ele quando não sabemos quantos argumentos serão passados. 

Forma reduzida (shorthand):
```js
const product = {
	name,
	categories: categories.join(',')
};
```

Devemos utilizar o *join(',)* quando quisermos converter o array para uma strnig.
Usamos o *push()* quando quisermos adicionar mais valores ao array, mantendo ele como um *array*.

## Arrow functions
Em JavaScript, podemos criar funções de uma forma alternativa chamada de **funções de seta (arrow functions)**.

O objetivo de uma função de seta é simplificar a sintaxe das funções tradicionais e fornecer uma maneira confiável de lidar com o escopo da função, que normalmente é tratado pelo objeto *this*.

Veja o seguinte exemplo, que calcula um desconto para um produto com base em seu preço:
```js
const discount = (price) => {
	return (price / 100) * 10;
}
```

Neste código, não usamos a palavra-chave *function*, e o corpo da função é definido com uma seta =>.

As arrow functions podem ser ainda mais simplificadas, seguindo estas boas práticas:
- Omitir os parênteses dos parâmetros quando a função tiver **apenas um parâmetro**;
- Omitir as chaves *{}* e a palavra *return* se o corpo da função tiver **apenas uma instrução**.

A função resultante fica muito mais simples e fácil de ler:
```js
const discount = price => (price/100) *10;
```

Agora vamos explicar como as arrow functions estão relacionadas ao controle do escopo. O valor do objeto *this* pode apontar para contextos diferentes, dependendo de onde executamos uma função.

Quando usamos *this* dentro de um **callback**, muitas vezes perdemos a referência do contexto original, o que costuma nos fazer usar truques, como guardar o valor de this em uma variável externa.

```js
function createProduct(name) {
  this.name = name;
  this.getName = function() {
    setTimeout(function() {
      console.log('Product name is:', this.name);
    });
  }
}
```
Se executarmos assim:
```js
const product = new createProduct('Monitor');
product.getName();
```
### Como corrigir?

Basta **converter a função do `setTimeout` em uma arrow function**, assim:

javascript

CopiarEditar

`setTimeout(() => {   console.log('Product name is:', this.name); });`

Agora, nosso código fica mais simples e podemos usar o escopo da função com segurança, pois a arrow function **herda o `this` do contexto onde foi criada** — ou seja, mantém o `this` da instância de `createProduct`.

## Optional chaining (encadeamento opcional)
É um recurso poderoso que ajuda a refatorar e simplificar o nosso código.
Basicamente, ele faz com que o código ignore a execução de uma expressão caso algum valor ao longo dela não exista (se for null ou undefined), evitando erros.

Exemplo básico (em JavaScript):
```js
const getOrder = () => {
	return {
		product: {
			name: 'keyboard'
		}
	};
}
```

Se quisermos acessar o nome do produto de forma segura, usando optional chaining, podemos fazer assim:
```js
const order = getOrder();
const productName = order?.product?.name;
console.log(productName);
```

**Por que usar optinal chaining?**
- Sem optional chaining, se *order* ou *product* forem *null* ou *undefined*, o nosso código lançaria um erro ao tentar acessar **name**.
- Com o ?., a avaliação para e retorna *undefined* se algum valor no caminho não existir, evitando erros.

## Nullish coalescing
Nullish coalescing está relacionado a fornecer um valor padrão quando uma variável não foi definida.

Considere o seguinte exemplo, que atribui um valor à variável *quantity* somente se a variável qty existir:
```js
const quantity = qty ? qty : 1;
```

Essa instrução é chamada de operador ternário, e funciona como uma estrutura condicional curta.

Se a variável qty não tiver valor, quantity será inicializada com o valor padrão 1.

Podemos reescrever essa expressão usando nullish coalescing:
```js
const quantity = qty ?? 1;
```

## Classes
As classes em JavaScript permitem estruturar melhor o código da aplicação e criar instâncias (objetos) com base nessas classes.
Uma classe pode ter:
- Propriedades (variáveis internas)
- Construtor
- Métodos (funções internas)
- Acessores de propriedade (get e set)

Exemplo:
```js
class User {
	firstName = '';
	lastName = '';
	#isActive = false; 
}

constructor(firstName, lastName, isActive = true) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.#isActive = isActive;
}

getFullName() {
	return `${this.firstName} ${this.lastName}`;
}

get active() {
	return this.#isActive;
}
```

**Quais partes essa classe tem?**
- Membros (properites)
	- firstName e lastName: públicas, acessíveis de fora
	- #isActive: privada, só pode ser acessada dentro da própria classe (por isso o #)
- Construtor (constructor):
	- É chamado automaticamente quando criamos um objeto da classe;
	- Usado para inicializar os membros da classe.

Exemplo:
```js
const user = new User("Davidson", "Linhares");
```

Uma classe também pode herdar membros e funcionalidades de outra classe. Podemos fazer isso utilizando a palavra-chave *extends* seguida do nome da classe que queremos herdar.
```js
class Customer extends User {
	taxNumber = '';

	constructor(firstName, lastName) {
		super(firstName, lastName);
	}
}
```

- **super(...)** - serve para executar o construtor da classe pai *User*. 

## Modules
À medida que nossas aplicações crescem, chega um momento em que precisamos organizar melhor o código para que ele seja mais sustentável e reutilizável. Módulos são uma forma poderosa de fazer isso, e é sobre eles que vamos falar agora.

Na seção anterior, aprendemos sobre classes *User*, *Customer*. Porém, manter tudo em um único arquivo é péssimo para projetos maiores. 

Os módulos nos permitem dividir o código em arquivos separados, cada um com uma responsabilidade específica (isso segue o princípio chamado SRP - Princípio da Responsabilidade Única).

Se um arquivo exportar várias coisas:
```js
export class User {...}
export class UserPreferences {...}
```
Importamos assim:
```js
import { User, UserPreferences} from './user.js';
```

## What is TypeScript?
As primeiras versões do JavaScript tinham muitas limitações, o que tornava inviável transformar pequenas aplicações web em clientes robustos e *monolíticos* executados inteiramente no navegador. Em poucas palavras, aplicações JavaScript de grande porte sofriam com sérios problemas de manutenibilidade e escalabilidade conforme aumentavam em tamanho e complexidade. Esse problema ficava ainda mais evidente quando novas bibliotecas e módulos precisavam se integrar de forma transparente às aplicações, pois faltavam mecanismos adequados de interoperabilidade, gerando soluções complicadas e frágeis.

Para superar essas dificuldades, a Microsoft criou um **superset** da linguagem JavaScript que ajudasse a desenvolver aplicações corporativas com menos erros, usando verificação estática de tipos, ferramentas melhores e análise de código. Foi assim que, em 2014, surgiu o TypeScript 1.0.
- Ele se manteve à frente do JavaScript: implementava as mesmas funcionalidades antes mesmo de chegarem aos navegadores, oferecendo um ambiente estável para projetos de larga escala.
- Introduziu **tipagem estática opcional** por meio de anotações de tipo, garantindo validação em tempo de compilação e capturando erros mais cedo;
- Suportou arquivos de declaração .d.ts, permitindo que desenvolvedores descrevessem a interface de seus módulos para que outros pudessem integrá-los de forma mais confiável em seus fluxos de trabalho e ferramentas.

Nas aplicações Angular, não é necessário executar o código TypeScript manualmente, pois isso é feito automaticamente pelo Angular CLI (a ferramenta de linha de comando do Angular).

No entanto, é importante saber como esse processo funciona por baixo dos panos, ou seja, entender o que acontece nos bastidores quando o Angular executa o TypeScript.

## Getting started with TypeScript
The TypeScript language is an npm package that can be installed from the npm registry using the following command:
```shell
npm install -g typescript
```
