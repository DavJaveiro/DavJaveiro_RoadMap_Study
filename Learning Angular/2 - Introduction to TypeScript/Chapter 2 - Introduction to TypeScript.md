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
In the preceding command, we chose to install TypeScript globally in our system so that we can use it from any path our development environment. Let's see how we can use TypeScript through a simple example: 
1. Open VSCode and select File | New File... from the main menu options;
2. Enter app.ts in the New File... dialog and press *Enter*.
3. Type the following snippet into the *app.ts* file:
	1. const title = 'Hello TypeScript!';

Embora tenhamos criado um arquivo TypeScript, o trecho de código anterior é um código JavaScript válido. Lembre-se que o TypeScript é um superconjunto do JavaScript que oferece *syntatic sugar* (recursos sintáticos) por meio de seu sistema de tipagem. No entanto, escrever código JavaScript puro com TypeScript não nos traz nenhum benefício claro.

4. Open a terminal window and run the following command to compile the TypeScript file into JavaScript:
`tsc app.ts`

The preceding command initiates a process called transpilation performed by the tsc executable, a compiler is at the core of the TypeScript language. <span style="background:#d4b106">Precisamos compilar o código TypeScript para JavaScript</span> porque os navegadores atualmente não oferecem suporte nativo ao TypeScript.

O Angular usa um compilador que aproveita o compilador do TypeScript nos bastidores para construir aplicações Angular.

O compilador TypeScript oferece opções adicionais de configuração que podemos passar para o executável *tsc* através da janela do terminal ou de um arquivo de configuração. A lista completa de opções de compilador disponíveis pode ser encontrada em [TypeScript: Documentation - tsc CLI Options (typescriptlang.org)](https://www.typescriptlang.org/docs/handbook/compiler-options.html?form=MG0AV3)

5. The transpilation process will create an *app.js* file in the same folder as the TypeScript file. The new file will contain the following code: `var title = 'Hello TypeScript';`

Como ainda não utilizamos nenhum recurso específico do TypeScript, o trecho anterior parece quase idêntico ao original, exceto pela declaração de variável.

7. O processo de transpialão substitui a palavra-chave *const* pela palavra-chave *var* porque o compilador *TypeScript* usa, por padrão, uma versão antiga do JavaScript. Podemos alterar isso especificando um alvo no comando *tsc*: `tsc app.ts --target es2022`
No comando acima, especificamos o *es2022*, que representa a versão mais recente da linguagem JavaScript no momento da escrita. As aplicações Angular que construiremos ao longo deste livro também visam essa versão do JavaScript por padrão.

## Types
Trabalhar com TypeScript ou qualquer outra linguagem de programação significar lidar com dados, e esses dados podem representar diferentes tipos de conteúdo, chamados de tipos ou **types**. Os tipos são usados para representar o fato de que os dados podem ser texto, um valor inteiro ou um array desses tipos de valores, entre outros.


*Types disappear during transpilation and are not included in the final JavaScript code.*

Podemos já ter encontrado tipos em JavaScript, pois sempre trabalhamos implicitamente com eles. No JavaScript, qualquer variável pode assumir (ou retomar, no caso de funções) qualquer valor. Às vezes, isso leva a erros e exceções no código devido a conflitos de tipos entre o valor retornado e o esperado. No entanto, a tipagem estática das nossas variáveis proporciona à IDE e a nós uma visão claro do tipo de dados que devemos encontrar em cada instância do código. Isso se torna uma maneira valiosa de ajudar a depurar nossas aplicações no momento da compilação, antes que o código seja executado.

**String**
Um dos tipos primitivos mais utilizados é a *String*, que atribui texto a uma variável:
```ts
const product: string = 'keyboard';
```
O tipo é definido adicionando dois pontos (:) e o nome do tipo ao lado da variável.

O JavaScript atribui dinamicamente o tipo *string* à variável *product* com base no valor fornecido. Essa característica é chamada de *tipagem dinâmica*, o que significa que os tipos das variáveis são determinados em tempo de execução.

Por outro lado, em TypeScript, podemos explicitamente definir o tipo da variável para garantir mais segurança e evitar erros inesperados durante o desenvolvimento. Esse é um dos motivos pelos quais TypeScript é tão útil para projetos grandes e complexos.

**Boolean**
The boolean type defines a variable that can have a value of either true or false:
```ts
const isActive: boolean = true;
```
The result of a boolean variable represents the fulfillment of a conditional statement.

**Number**
The *number* type is probably the other most widely used primitive data type, along with string and boolean:
```ts
const price: number = 100;
```
O tipo *number* em TypeScript pode representar diversos formatos numéricos, incluindo números de ponto flutuante e literais hexadecimais, decimais, binários e octais. 

**Array**
O tipo *array* define uma lista de itens que contêm apenas um tipo específico. Isso ajuda a evitar erros comuns, como a atribuição de tipos errados dentro da lista. Em TypeScript, podemos definir arrays de duas maneiras:
```ts
const categories: string[] = ['Computing', 'Multimedia'];
const categories: Array<string> = ['Computing', 'Multimedia'];
```
Ambas as sintaxes acima são equivalentes e garantem que *categories* seja um array que só pode conter valores do tipo *string*. Isso melhora a segurança do código e evita problemas inesperados ao trabalhar com listas.

**any**
Em todos os casos anteriores, a tipagem é opcional porque o TypeScript é inteligente o suficiente para inferir os tipos de dados das variáveis com base em seus valores com um certo nível de precisão.

*Permitir que o sistema de tipagem infira os tipos é muito importante, em vez de defini-los manualmente. O sistema de tipos nunca está errado, mas o desenvolvedor pode ser.*

No entanto, se isso não for possível, o sistema de tipagem atribuirá automaticamente o tipo dinâmico *any* aos dados com tipagem fraca, reduzindo a verificação de tipos ao mínimo. Além disso, podemos adicionar manualmente o tipo any ao nosso código quando for difícil inferir o tipo de dados a partir das informações que temos em determinado momento. O tipo *any* inclui todos os outros tipos existentes, permitindo que qualquer valor seja atribuído a ele posteriormente:
```ts
let order:any;

function setOrderNo() {
	order = '0011';
}
```

O TypeScript contém outro tipo, semelhante ao tipo *any*, chamado de *unknown*. Uma variável do tipo *Unknown* pode ter um valor de qualquer tipo. A principal diferença é que o TypeScript não permite que realizemos operações arbitrárias com valores *unknown*, como chamar um método, a menos que façamos uma verificações de tipo primeiro.

No entanto, com grande poder vem grandes responsabilidades. Se ignorarmos a conveniência da verificação estática de tipos, abrimos a porta para erros de tipo ao transmitir dados através da nossa aplicação. Cabe a nós garantir a segurança dos tipos em toda a aplicação.

**Custom types**
Em TypeScript, podemos criar nosso próprio tipo, se necessário, utilizando a palavra-chave *type*, da seguinte forma:
```ts
type Categories = 'computing' | 'multimedia';
```

Podemos então criar uma variável com esse tipo específico:
```ts
const category: Categories = 'computing';

```

Isso nos permite definir tipos personalizados e garantir que uma variável contenha apenas valores permitidos dentro desse tipo.

O código anteriores é perfeitamente válido, pois *computing* é um dos valores permitidos e funciona conforme o esperado. Tipos personalizados são uma excelente maneira de adicionar tipos com um número finito de valores permitidos.

Quando queremos criar um tipo personalizado a partir de um objeto, podemos usar o operador *keyof*. O operador *keyof* nos permite iterar sobre as propriedades de um objeto e extraí-las para um novo tipo:
```ts
type Category = {
	computing: string;
	multimedia: string;
};
type CategoryType = keyof Category;
```
No trecho acima, `CategoryType` produz o mesmo resultado que o tipo `Categories`.

Aprenderemos como usar o operador `keyof` para iterar dinamicamente sobre as propriedades de um objeto no **Capítulo 4 - Enriquecendo Aplicações com Pipes e Diretivas**.

O sistema de tipagem do TypeScript é usado principalmente para **anotar código JavaScript com tipos**, melhorando a experiência do desenvolvedor ao fornecer _IntelliSense_ e evitando bugs precocemente no desenvolvimento.

**Functions**
As funções em TypeScript não são muito diferentes das funções em JavaScript tradicionais, exceto pelo fato de que, assim como tudo no TypeScript, elas podem ser anotadas com tipos estáticos. Isso melhora o compilador ao fornecer informações sobre a assinatura da função e o tipo de dado que ela pretende retornar, se houver.

O exemplo a seguir mostra como uma função regular é anotada em TypeScript:
```ts
function getProduct(): string {
	return 'keyboard';
}
```

No trecho acima, adicionamos o tipo *string* à declaração da função para especificar o tipo do valor retornado. Também podemos adicionar tipos aos parâmetros da função, como mostrado abaixo:
```ts
function getFullname(firstName: string, lastName: string): string {
	return `${this.firstName ${this.lastName}`;
}
```

Aqui, os parâmetros foram anotados com seus respectivos tipos, garantindo que o compilador verifique se os dados fornecidos possuem os tipos corretos.

Quando uma função não retorna um valor, podemos anotá-la usando o tipo *void*:
```ts
function printFullname(firstName: string, lastName: string): void {
	console.log(`${this.firstName} ${this.lastName}`);
}
```

Já aprendemos como usar parâmetros *default* e *rest* em funções JavaScript. O TypeScript amplia esses recursos ao introduzir *parâmetros opcionais*, que são definidos adicionando o caractere ? após o nome do parâmetro:
```ts
function addtoCart(productId: number, quantity?: number) {
	const product = {
		id: productId,
		qty: quantity ?? 1
	};
}
```

Na função acima, quantity foi definido como um **parâmetro opcional**. Além disso, utilizamos a **sintaxe de coalescência nula (??)** para definir a propriedade qty do objecto product, caso, quantity não seja passado.

**Classes**
```ts
export clas User {
	firstName: string = ' ';
	lastName: string = ' ';
	private isActive: boolean = false;
}
```

**Modify the constructor by adding types to parameters**:
```ts
constructor(firstName: string, lastName: string, isActive: boolean = true) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.isActive = isActive;
}
```
Finally, add types in the *active* property accessor and the *getFullname* method:
```ts
getFullname(): string {
	return `${this.firstName} ${this.lastName}`;
}

get active(): boolean {
	return this.isActive;
}
```

**Interfaces**
Uma interface é um contrato de código que define um esquema específico.