The kinds of values that can be represented and manipulated in a programming language are known as types, and one one of the most fundmanetal characteristic of a programming language is the set of types it supports. When a program needs to retain a value for future use, it assings the value to (or "stores" the value in) a variable. Variables have names, and they allow use of those names in our refer to values. The way that variables work is another fundamental characteristic of programming language. This chapter explains types, values, and variables in JavaScript. It begins with an overview and some definitions.

## 3.1 Overview and Definitions
Os tipos do JavaScript podem ser divididos em duas categorias: tipos primitivos e tipos de objeto. Os tipos primitivos do JavaScript incluem números, cadeias de texto (conhecidas como booleanos). Uma parte significativa deste capítulo é dedicada a uma explicação detalhada dos tipos numéricos e de cadeia de caracteres no JavaScript. Os booleanos são abordados no 3.4.

### 3.2.6 Dates and Times
JavaScript defines a simple Date class for representing and manipulating the numbers that represent date and times. As datas do JavaScript são objetos, mas também têm uma representação numérica como um carimbo de data/hora que específica o número de milissegundos decorridos desde 1° de janeiro de 1970:
```javascript
let timestamp = Data.now(); // hora atual como um carimbo de data/hora (um número)
```

let now = new Date(); // The current time as a Date object;
No dia a dia do desenvolvimento moderno, existem algumas melhores práticas e particularidades sobre como usamos isso dentro de cada uma dessas tecnologias.

- [ ] **Use sempre const ao invés de let**
Se vamos apenas capturar o momento atual e não vamos reatribuir a variável para outra data completamente diferente, é recomendável usar *const*
```js
// O TypeScript infere automaticamente que 'now' é do tipo Date
const now = New Date();
```
No TypeScript, o objeto Date já possui tipagem nativa. Podemos chamar métodos diretos para manipular ou ler a data.
```ts
const now = new Date();

// Exemplos de métodos nativos úteis
const year: number = now.getFullYear();
const month: number = now.getMonth(); // Janeiro é 0
const isoString: string = now.toISOString();
```




let ms = now.getTime(); // Convert to a millisecond timestamp

let iso = now.toISOString(); // Convert to a string in standard format


## 3.10 Variable Declaration and Assignment
One of the most fundamental techniques of computer programming is the use of names, or *identifiers*, to represent values. Binding a name to a value gives us a way to refer to that value and use it in the programs we write. When we do this, we typically say that we are assigning a value to a *variable*. The term "variable" implies that new values can be assigned: that the value associated with the variable may vary as our program runs. If we permanently assign a value to a name, then we call that name a *constant* instead of a variable.

Before we can use a variable or constant in a JavaScript program, we must *declare* it. In ES6 and later, this is done with the **let** and **const** keywords, which we explain next. Prior to ES6, variables were declared with *var*, which is more idiosyncratic and is explained later on this section.

### 3.10.1 Declarations with let and const
In modern JavaScript (ES6 and later), variables are declared with the *let* keyword, like this:
let i;
let sum;

We can also declare multiple variables in a single let statement:
```js
let i, sum;
```
It is a good programming practice to assign an initia value to our variables when we declare them, when this is possible:
```js
let message = "Hello";
let i = 0, j = 0, k = 0;
let x = 2, y = x*x;
```

If we don't specify an initial value for a variable with the let statement, the variable is declared, but its value is *undefined* until our code assigns a value to it.

To declare a constant instead of a variable, use *const* instead of *let* const works just like *let* except that we must initialize the constant when we declare it:
```js
const H0 = 74; // Hubble constant (km/s/Mpc)
const C = 299792.458; // Speed of light in a vacum (km/s)
const AU = 1.496E8; // Astronomical 
```
As the name implies, constants cannot have their values changed, and any attempt to do so causes a **TypeError** to be thrown.

It is a common (but not universal) convention to declare constants using names with all capital letters such as H0 or HTTP_NOT_FOUND as a way to distinguish them from variables.

>When To Use const
>There are two schools of thought about the use of the const keyword. One approach is to use *const* only for values that are fundamentally unchanging, like the physical constant shows, or program version numbers, or byte sequences used to identify file types, for example. Outra abordagem reconhece que muitas das chamadas variáveis em nosso programa nunca mudam de fato durante a execução do programa. Nessa abordagem, declaramos tudo com const e, em seguida, se descobrimos que de fato queremos permitir que o valor varie, mudamos a declaração para let. Isso pode ajudar a evitar bugs ao excluir alterações acidentais nas variáveis que não podem mudar. Na outra, usamos const para qualquer valor que não mude. Prefiro a primeira abordagem em meu próprio código. 

In chapter 5, we'll learn about the for, for/in, and for/of loop statements in JavaScript.
Each of these loops includes a loop variable that gets a new value assigned to it on each iteration, of the loop. JavaScript allows us to declare the loop variable as part of the loop syntax, and this is another common way tu use let:
```js
for(let i = 0, len = data.length; i < len; i++) console.log(data[i]);
for(let datum of data) console.log(datum);
for(let property in object) console.log(property)
```

Pode parecer surpreendente, mas você também pode usar const para declarar as "variáveis" do loop para loops for/in e for/of, desde que o corpo do loop não reatribua um novo valor. Nesse caso, a declaração const está apenas dizendo que o valor é constante durante a iteração de um loop: 
for(const datum of data) console.log(datum); 
for(const property in object) console.log(property);

**No for...of (para Arrays) e for...in (para Objetos): SIM (Pode e deve)**
Nesses loops mais modernos, podemos usar *const*, e isso é considerado uma boa prática pela comunidade.
```js
const frutas = ['Maçã', 'Banana', 'Laranja'];
for(const fruta of frutas) {
	console.log(fruta);
}
```
Por que funciona? Porque no for...of ou for..., o JavaScript não está pegando uma mesma variável e somando +1 nela. Na verdade, a cada volta do loop, o JavaScript destrói a variável anterior e cria uma variável *const* totalmente nova para aquele bloco específico. 

Como a variável fruta nasce, recebe o valor de 'Maçã', e nós não tentamos mudar o nome 'Maçã' por outra coisa dentro daquele mesmo bloco, o *const* é perfeitamente válido.

**Resumo da ópera**
- Tem contador (i++)? Use let
- Está percorrendo itens prontos (for...of ou for...in)? Use const.

No mundo do React, nós raramente usamos loops for (seja um let ou const) para renderizar listas na tela.

A grande diferença no React (e no JSX em geral) é que não podemos escrever um **for** tradicional direto no meio do HTML, porque um for é uma declaração de controle de fluxo, não algo que "retorna" um valor para a tela.

O método **.map()** do JavaScript resolve isso perfeitamente, porque ele pega um array original, passa por cada item e **retorna um novo array** cheio de elementos HTML/JSX prontinhos para o React desenhar.

Imagine que você precise listar alguns cupons ou notas fiscais na tela. Veja como fica o código:
```TypeScript
function ListaDeCupons() {
  // 1. Temos o nosso array de dados (geralmente viria de uma API ou banco de dados)
  const cuponsFiscais = [
    { id: 1, estabelecimento: 'Supermercado X', valor: 150.50 },
    { id: 2, estabelecimento: 'Posto de Gasolina Y', valor: 200.00 },
    { id: 3, estabelecimento: 'Padaria Z', valor: 25.00 }
  ];

  return (
    <div>
      <h2>Meus Cupons</h2>
      <ul>
        {/* 2. Abrimos chaves {} para escrever JavaScript dentro do HTML */}
        {cuponsFiscais.map((cupom) => (
          
          /* 3. Retornamos o HTML para cada item. 
             A propriedade "key" é OBRIGATÓRIA no React para ele não se perder! */
          <li key={cupom.id}>
            <strong>{cupom.estabelecimento}</strong> - R$ {cupom.valor.toFixed(2)}
          </li>

        ))}
      </ul>
    </div>
  );
}
```
Por que o React exige essa key?
Quando adicionamos, removemos ou reordenamos um item nessa lista, o React precisa saber exatamente qual item mudou para não ter que recarregar a lista inteira. A key (que geralmente é o ID do banco de dados) serve como um "RG" único para aquele elemento na tela.

