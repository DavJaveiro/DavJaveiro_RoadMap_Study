O JavaScript é client-side (lado do usuário). Isso significa que o código é executado no navegador do usuário.

Tanto React quanto Angular permitem desenvolver aplicações que podem ser renderizadas no **lado do cliente (Client-Side Rendering - CSR)** e também no **Lado do Servidor (Server-Side Rendering - SSR)**, dependendo da estratégia escolhida.

O Next.js entrega tudo que o React puro não entrega pronto:
- Renderização no servidor (SSR)
- Geração de páginas estáticas (SSG)
- API Routes (back-end dentro do projeto)
- Roteamento automático
- Otimização de imagens
- SEO facilitado
- Estrutura de projeto organizada

React sozinho é só a camada de UI.
Next.js é um **framework completo para construir aplicações web modernas,** incluindo:
- Front-end
- Back-end leve
- Performance otimizada
- SEO forte

SEO (Search Engine Optimization)
Aplicações React tradicionais renderizam tudo no navegador (Client-Side Rendering).
Isso pode prejudicar SEO.

Next.js permite
- SSR (Server-Side Rendering) - página que já vem pronta do servidor
- SSG (Static Site Generation) - página já gerada antes do usuário acessar

2. **Roteamento Automático**
Criamos um arquivo:
```
/app/blog/page.tsx
```
ele automaticamente vira uma rota:
/blog

Sem precisar configurar nada manualmente.

3. **Back-end embutido**
/app/api/users/route.ts

E isso vira uma API REST
ou seja:
podemos fazer full-stack só com next.

Renderização do Next.js
CSR - Client Side Rendering
SSR - Server Side Rendering
SSG - Static Site Generation

**Manipulamos o Doom com react?**
Manipulamos o DOM, mas quase nunca diretamente.
No desenvolvimento *clássico* (com JavaScript ou jQuery), nós trabalhávamos de forma **imperativa**: dizíamos ao navegador passo a passo o que alterar (ex: "busque o elemento com ID 'botão', mude a cor para azul, adicione a classe 'ativo').

No React (e consequentemente no Next.js), nós trabalhamos de forma **declarativa**: você diz "eu quero que o botão esteja azul quando o estado for ativo", e o React descobre sozinho como alterar o DOM para chegar nesse resultado.

**1. O Virtual DOM (O "Dublê")**
O React utiliza um conceito chamado **Virtual DOM**. É como uma cópia leve e em memória da estrutura da sua página.

Quando alteramos um estado ("useState") ou uma propriedade no React:
1. **Atualização Virtual:** o react cria uma nova versão do Virtual DOM com as mudanças;
2. **Comparação (Diffing):** ele compara a nova versão com a versão anterior (o que estava na tela antes).
3. **Reconciliação:** o react calcula a maneira mais eficiente de atualizar o **DOM Real** (o do navegador) para que ele fique igual ao Virtual.
	Manipular o DOM real é uma operação "cara" e lenta para o navegador. O React agrupa as mudanças e as aplica de uma vez só, garantindo performance. 

**Comparativo Prático**
**Modo Antigo (Manipulação Direta / Imperativo)**
```javascript
// Precisamos procurar o elemento e alterá-lo manualmente
const botao = document.getElementById('meu-botao');
botao.innerText = 'Carregado...';
botao.style.backgroundColor = 'gray';
```

**Modo React (Declarativo):**
```js
// Alteramos apenas o DADO. O React reage e muda a tela
const [isLoading, setIsLoading] = useState(false);

// ... em algum momento: setIsLoading(true);
return (
	<button style={{backgroundColor: isLoading ? 'gray' : 'blue'}}>
	{isLoading ? 'Carregando...' : 'Enviar'}
	</button>
);
```
Percebemos que no exemplo do React, nunca escrevemos *document.getElementById* ou *botao.style*.

Se usarmos o Vite com **Vanilla JS** (JavaScript puro), manipularemos o DOM manualmente. Se usar o Vite com React, seguiremos as regras do React.

**Escopo**
É a região do código onde uma determinada variável é acessível ou visível.

O escopo define o **contexto** no qual uma variável pode ser referenciada e modificada.

Tente pensar no contexto como cômodo de uma casa. Por exemplo, para utilizar o fogão, precisamos estar na cozinha. 

**Tipos de Escopos**
- **Global**: variáveis declaradas fora de qualquer função ou bloco de código (Var);
- **Bloco**: acessíveis apenas dentro do bloco de código onde foram declaradas (let e const);
- **Local (ou escopo de função):** variáveis declaradas dentro de uma função (veremos adiante)

## 3.10 Variable Declaration and Assignment
One of the most fundamental techniques of computer programming is the use of names, or *identifiers*, to represent values. Binding a name to a value gives us a way to refer to that value and use it in the programs we write. When we do this, we typically say that we are assigning a value to a *variable*. The term "variable" implies that new values can be assigned: that the value associated with the variable may vary as our program runs. If we permanently assign a value to a name, then we call that name a *constant* instead of a variable.

## Hoisting
levar ou içar, se refere ao comportamento do interpretador de mover as declarações de variáveis e funções para o topo do escopo em que foram definidas, antes mesmo da execução do código.

Esse comportamento possibilita usar uma variável ou função antes que ela esteja definida.

Todas as declarações de variáveis são movidas para o topo do seu escopo independentemente de onde tenha sido declarada, ela estará disponível para uso em todo o escopo em que foi definida. 

**Importante:** mesmo que as declarações de variáveis sejam movidas para o topo do escopo, elas ainda precisam ser declaradas antes de serem utilizadas. Caso contrário, receberemos uma referência indefinida (undefined).

Hoisting de Funções
Todas as declarações de funções também são movidas par ao topo de escopo. Isso significa que podemos chamar uma função antes mesmo de declará-la.

Vamos utilizar mais let do que var, pois ela tem controle de escopo, coisa que não existe com var.

O JavaScript é case sensitivy.

let username = "Rodrigo";
let userName = "João";

console.log(username)
console.log(userName)

let $email = "rodrigo@gmail.com"

let _email = "joao@gmail.com"

console.log($email)
console.log(_email)

let user_email = "user@gmail.com"

**Recomendações**
Escreva em inglês.
Use camelCase

firstName
lastName



