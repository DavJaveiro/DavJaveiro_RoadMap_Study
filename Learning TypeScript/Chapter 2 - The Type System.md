Como um verificador de tipos funciona, de fato?

Um *tipo* m TypeScript é, essencialmente, uma **descrição da forma de um valor JavaScript**, quais propriedades e métodos ele possui e como o operador *typeof* o classificaria.

**Tipos primitivos básicos**
O TypeScript reconhece os mesmos sete tipos primitivos do JavaScript:
- null
- undefined
- boolean - true ou false
- string
- number - 0, 2.1, -4...
- bigint - On, 13337n...
- symbol - Symbol(), Symbol("id")...

```ts
let singer = "Aretha";
// TypeScript infere automaticamente que singer é do tipo string
```

**Inferência de Tipos**
O compilador é capaz de deduzir tipos mesmo em expressões mais complexas.
```ts
// Inferred type : string
let bestSong = Math.random() > 0.5
	? "Chain of Fools"
	: "Respect";
```
Aqui, o TypeScript percebe que o resultado do operador ternário será sempre uma *string*.

**Objetos vs. primitivos**
Em JavaScript, existem classes como *Boolean* e *Number* que envolvem os valores primitivos. No entanto, **a boa prática em TypeScript é usar sempre os nomes em minúsculo** (boolean, number) para se referir aos tipos primitivos.

**Resumo**
Tipos são uma forma que o TypeScript usa para descrever valores e garantir segurança no código. Eles podem ser explícitos (quando declaramos) ou inferidos (quando o compilador deduz).
## Type Systems
Um sistema de tipos é, basicamente, o **conjunto de regras que uma linguagem usa para entender quais tipos cada construção do programa pode ter.**
No caso do TypeScript, o processo funciona assim:
1. Ele lê o código e identifica todas as variáveis, funções e valores existentes.
2. Para cada valor, verifica qual tipo sua declaração inicial sugere;
3. Observa como esse valor é usado ao longo do código.
4. Reclama (gera erro) como usuário se o uso de um valor não corresponde ao seu **type**

Vamos percorrer esse processo de **type inference** em detalhe.

Considere o seguinte trecho, no qual o TypeScript emite um **type error** sobre uma propriedade de **member** sendo erroneamente chamada como uma função:
```ts
let firstName = "Whitney";
firstName.length();
// ~~~~~~
// This expression is not callable.
// Type 'Number' has no call signatures
```

O TypeScript chegou a essa reclamação seguindo os passos:
1. Leu o código e entendeu que existe uma variável chamada *firstName*;
2. Concluiu que *firstName* é do tipo String porque seu valor inicial é uma String "Whitney"
3. Viu que o código está tentando acessar o **member** .length de *firstName* e chamá-lo como uma função
4. Reclamou que o **member** *.length* de uma string é um **member**, não uma função (não pode ser chamado como função)

Compreender o **type system** do TypeScript é uma habilidade importante para entender código em TypeScript. Os trechos de código neste capítulo e ao longo do restante do livro mostrarão **types** cada vez mais complexos que o TypeScript será capaz de inferir a partir do código.

## Kinds of Errors
Ao escrever TypeScript, os dois tipos de "errors" que encontraremos com mais frequência são:
- Syntax - bloqueia o TypeScript de ser convertido para JavaScript
- Type - Algo incompatível foi detectado pelo **type checker**
As diferenças entre os dois são importantes.

**Syntax Errors**
Syntax errors acontecem quando o TypeScript detecta uma sintaxe incorreta que ele não consegue entender como código. Esses erros **bloqueiam** o TypeScript **de gerar corretamente o JavaScript** de saída a partir do nosso arquivo. Dependendo das ferramentas e configurações usadas para converter o nosso código TypeScript em JavaScript, podemos ainda obter algum tipo de saída em JavaScript (nas configurações padrão do tsc). Mas, se isso acontece, provavelmente não será o que esperamos.

```ts
let let wat;
// ~~~
// Error: ',' expected.
```
O JavaScript compilado, dependendo da versão do compilador TypeScript, pode se parecer com:
```js
let let, wat;
```

Embora o TypeScript faça o possível para gerar código JavaScript mesmo com **syntax errors**, o código de saída provavelmente não será o que queiramos. É melhor corrigir **syntax errors** antes de tentar executar o JavaScript gerado.

**Type Errors**
Type Erros acontecem quando a nossa sintaxe é valida, mas o **type checker** do Ts detecta um erro nos **types** do programa. Esses erros não bloqueiam a conversão da sintaxe TypeScript para JavaScript. No entanto, geralmente indicam que algo pode falhar ou se comportar de forma inesperada se o código for executado.

Vimos isso no Capítulo 1, *From JavaScript yo TypeScript*, com o exemplo console.blub, onde o código era sintaticamente válido, mas o TypeScript detectou que provavelmente iria falhar ao ser executado:

```ts
console.blub("Nothing is worth more than laughter.");
// Error: Property 'blub' does not exist on type 'Console'.
```

Mesmo que o TypeScript possa gerar código JavaScript apesar da presença de **type errors**, eles geralmente são um sinal de que o JavaScript resultante não funcionará como esperado. É melhor lê-los e considerar corrigir os problemas relatados antes de executar o JavaScript.

Alguns projetos são configurados para bloquear a execução do código durante o desenvolvimento até que todos os **type errors** do TypeScript, não apenas os *syntax errors*, sejam corrigidos. Muitos desenvolvedores (inclusive eu) geralmente acham isso irritante e desnecessário. A maioria dos projetos possui uma forma de não ser bloqueada, como através do arquivo *tsconfig.json* e das opções de configuração abordadas no capítulo 13, *Configuration Options*.

## Assignability
O TypeScript lê os valores iniciais das variáveis para determinar qual *type* essas variáveis podem ter. Se posteriormente ele <span style="background:#d3f8b6">encontrar uma atribuição de um novo valor</span> para essa variável, verificará se o *type* desse novo valor é o mesmo da variável. 

O TypeScript não vê problema em atribuir posteriormente um valor diferente, desde que seja do mesmo type. Se uma variável for, por exemplo, inicialmente uma string, atribuir outra string depois será perfeitamente válido:
```ts
let firstName = "Carole";
firstName = "Joan";
```

Se o TypeScript encontrar uma atribuição de um #type diferente, ele emitirá um *type error*. Não poderíamos, por exemplo, declarar inicialmente uma variável com uma string e depois atribuir um boolean:
```ts
let lastName = "King";
lastName = true;
// Error: type 'boolean' is not assignable to type 'string'.
```

A verificação do TypeScript sobre se um valor pode ser fornecido a uma chamada de função ou variável é chamada de #assignability: se esse valor é #assignable ao #expected type para o qual está sendo passado. Esse será um termo importante nos capítulos seguintes, quando compararmos objetos mais complexos.

### Understanding Assignability Errors
Os erros no formato "Type ... is not assignable to type" serão alguns dos mais comuns que veremos ao escrever código em TypeScript.
- O primeiro Type mencionado na mensagem de erro é o valor que o código está tentando atribuir ao destinatário.
- O segundo type mencionado é o do destinatário que está recebendo o valor.

Por exemplo, quando escrevemos `lastName = true` no trecho anterior, estávamos tentando atribuir o valor `true` - *type boolean* - à variável *LastName* - type string.

Veremos problemas de *assignability* cada vez mais complexos conforme avançarmos neste livro. Devemos sempre lembrarmos da diferença entre **actual types** e os **expected types**. Fazer isso tornará muito mais fácil trabalhar com TypeScript quando ele reclamar de **type errors**.

## Type Annotations
Às vezes, uma variável não tem um valor inicial para o TypeScript ler. O TypeScript não tentará deduzir o *initial type* da variável a partir de usos posteriores. Ele considerará a variável, por padrão, como implicitamente do *any type*: indicando que ela pode ser qualquer coisa.

Variáveis cujo **initial type** não pode ser inferido passam pelo que é chamado de **evolving any**: em vez de import um **type** específico, o TypeScript evolui sua compreensão do Type da variável cada vez que um novo valor é atribuído.

Aqui, atribuímos à variável *rocker* (do tipo **envolving any**) primeiro uma string, o que significa que ela possui métodos de string como *toUpperCase*, mas depois ela evolui para um número:
```ts
let rocker;
rocker = "Joan Jett";
rocker.toUpperCase();
rocker = 19.58;
rocker.toPrecision(1); // Ok
rocker.toUpperCase();
//~~~~~~~~
// Error: 'toUpperCase' does not exist on type 'number'
```

O Ts conseguiu detectar que estávamos chamando o método **toUpperCase()** em uma variável que havia evoluído para **type number**. No entanto, ela não conseguiu nos dizer antes se era intencional evoluir a variável de **string** para **number**.

Permitir variáveis com **evolving any type** - e usar o **any type** em geral, derrota parcialmente o propósito do **type checking** do TS! O TypeScript funciona melhor quando sabe quais types seus valores devem ter. Grande parte do **type checking** não pode ser aplicada a valores do tipo **any**, porque eles não têm **known types** para serem verificados. O Capítulo 13, *Configuration Options*, mostrará como configurar as reclamações do TypeScript sobre **implicit any**.

### Declaração com Type Annotations
O TS fornece uma sintaxe para declarar o type de uma variável sem precisar atribuir um valor inicial, chamada **type annotation**.

Uma **type annotation** é colocada após o nome da variável e inclui dois pontos seguidos pelo nome de um **type**.

Este exemplo indica que a variável *rocker* deve ser do **type string:**
```ts
let rocker: string;
rocker = "Joan Jett";
```

Essas type annotations existem apenas para o TypeScript, elas não afetam o código em tempo de execução e não são sintaxe válida em JavaScript. Se rodarmos tsc para compilar o código em Js, elas serão apagadas. Por exemplo, o código anterior seria compilado aproximadamente para:
```js
let rocker;
rocker = "Joan Jett";
```

Atribuir um valor cujo *type* não seja assignable ao annotated type da variável causará um type error.

Este trecho atribui um número a uma variável *rocker* previamente declarada como *type string*, causando um *type error:*
```ts
let rocker: string;
rocker = 19.58;
// Error: Type 'number' is not assignable to type 'string'.
```

Nos próximos capítulos, veremos com as type annotations permitem aumentar a capacidade do TypeScript de compreender o nosso código, oferecendo melhores recursos durante o desenvolvimento.

O TypeScript contém várias novas peças de sintaxe, como essas **type annotations**, que existem apenas no **type system**.

Nada do que existe apenas no **type system** é copiado para o JavaScript emitido. Os **types** do TypeScript não afetam o JavaScript gerado.

## Unnecessary Type Annotations
Type Annotations permitem fornecer informações ao TypeScript que ele não conseguiria deduzir sozinho. Também podemos usá-las em variáveis que têm *immediately inferable types*, mas nesse caso não estaria dizendo nada que o TypeScript já não soubesse.

A seguinte **type annotation** `: string` é redundante porque o Ts já poderia inferir que `firstName` é do **type string**
```ts
let firstName: string = "Tina";
// ~~~~~Does not change the type system....

```

Se adicionarmos uma **type annotation** a uma variável com um valor inicial, o TS verificará se ela corresponde ao type do valor da variável.

No exemplo abaixo, *firstName* foi declarado como *type string*, mas seu inicializador é o número 42, o que o TypeScript vê como incompatibilidade:
```ts
let firstName: string = 42;
// ~~~~~~
// Error: type 'number' is not assignable to type 'string'.
```

Muitos desenvolvedores, inclusive eu, geralmente preferem não adicionar **type annotations** em variáveis onde elas não mudariam nada. Ter que escrever manualmente type annotations pode ser trabalhoso, especialmente quando elas mudam, e para os complex types que veremos mais adiante no livro.

Ainda assim, pode ser útil incluir **explicit type annotations** em variáveis para:
- Documentar claramente o código
- Proteger o TypeScript contra mudanças acidentais no **type da variável**.

Nos próximos capítulos veremos como **explicit type annotations** podem, em alguns casos, informar ao TypeScript algo que ele não teria inferido normalmente.

## Types Shapes
O TypeScript faz mais do que verificar se os valores atribuídos às variáveis correspondem aos seus **original types**. Ele também sabe quais **member properties** devem existir em objetos Se tentarmos acessar uma propriedade de uma variável, o TypeScript garantirá que essa propriedade seja conhecida como existente no type da variável.

Suponha que declaramos uma variável *rapper* do tipo string. Mais tarde, ao usarmos essa variável, operações que o TypeScript sabe que funcionam em strings são permitidas:
```ts
let rapper = "Queen Latifah";
rapper.length; // ok
```

Operações que o TypeScript não reconhecem como válidas para strings não serão permitidas:
```ts
rapper.push('!');
```

Os types também pode ter formas mais complexas, principalmente objetos. No trecho a seguir, o Ts sabe que o objeto birthNames não possui uma chave middleName e reclama:
```ts
let cher = {
	firstName: "Cherilyn",
	lastName: "Sarkisian",
};

cher.middleName;
// Property 'middleName' doest not exist on type '{ firstName: string; lastName: string;}'
```

A compreensão do TypeScript sobre **object shapes** permite que ele reporte problemas no uso de objetos, não apenas **assignability**. O capítulo 4, Objects, descreverá mais recursos poderosos do TypeScript relacionados a objetos e **objects types**.

## Modules
A linguagem de programação JavaScript não incluía uma especificação de como arquivos poderiam compartilhar código entre si até relativamente pouco tempo em sua história. O ECMAScript 2015 adicionou os ECMAScript modules (ESM) para padronizar a sintaxe de **import** e **export** entre arquivos.

Para referência, este arquivo de módulo importa um valor de um arquivo irmão *./values* e exporta uma variável dobrada:
```ts
import { value } from "./values";
expor const doubled = value *2;
```

Para corresponder à especificação ECMAScript, neste livro usarei a seguinte nomenclatura:

- **Module**  
    Um arquivo com um **top-level export** ou **import**
- **Script**  
    Qualquer arquivo que não seja um módulo

O TypeScript consegue trabalhar tanto com esses arquivos modernos de módulo quanto com arquivos mais antigos. Qualquer coisa declarada em um arquivo de módulo estará disponível apenas dentro dele, a menos que uma instrução explícita de **export** torne-a acessível. Uma variável declarada em um módulo com o mesmo nome de uma variável em outro arquivo não será considerada um conflito de nomes (a menos que um arquivo importe a variável de outro).

Os seguintes arquivos `a.ts` e `b.ts` são ambos módulos que exportam uma variável chamada `shared` sem problema. Já `c.ts` causa um **type error** porque há um conflito de nomes entre um `imported shared` e seu próprio valor:
```ts
// a.ts
export const shared = "Cher";

// b.ts
export const shared = "Cher";

// c.ts
import { shared } from "./a";
// ~~~~~~
// Error: Import declaration conflicts with local declaration of 'shared'.

export const shared = "Cher";
// ~~~~~~
// Error: Individual declarations in merged declaration
// 'shared' must be all exported or all local.
```

Se um arquivo for um **script**, o TypeScript o considerará como **globally scoped**, ou seja, todos os scripts têm acesso ao seu conteúdo. Isso significa que variáveis declaradas em um arquivo **script** não podem ter o mesmo nome que variáveis declaradas em outros arquivos **script**.

Os seguintes arquivos `a.ts` e `b.ts` são considerados **scripts** porque não possuem instruções de **export** ou **import**. Isso faz com que suas variáveis de mesmo nome entrem em conflito, como se estivessem declaradas no mesmo arquivo

```ts
// a.ts
const shared = "Cher";
// ~~~~~~
// Cannot redeclare block-scoped variable 'shared'.

// b.ts
const shared = "Cher";
// ~~~~~~
// Cannot redeclare block-scoped variable 'shared'.
```

Se você encontrar esses erros **“Cannot redeclare…”** em um arquivo TypeScript, pode ser porque ainda não adicionou uma instrução de **export** ou **import** ao arquivo. De acordo com a especificação ECMAScript, se precisar que um arquivo seja tratado como módulo sem uma instrução de **export** ou **import**, você pode adicionar `export {};` em algum lugar do arquivo para forçar que ele seja considerado um módulo.

