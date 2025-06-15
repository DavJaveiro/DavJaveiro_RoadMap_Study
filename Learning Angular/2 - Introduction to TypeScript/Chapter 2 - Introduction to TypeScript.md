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
