**Antes de começar**
Temos usado números como 1, 2, 3, 34, 101, etc., desde que aprendemos a contar. E um pouco mais tarde, também conhecemos os números como 0, -11, -40.

Esses números são chamados de **inteiros**, eles vem equipados com duas operações, "mais" e "vezes". Você conhece algumas das propriedades dessas operações: por exemplo, 3 + 5 = 5 + 3 e, mais geralmente, m + n = n + m. Outro exemplo: 3 * 5 * 7 é o mesmo qualquer que seja a ordem da multiplicação, ou mais absolutamente, (k * m) * n = k * (m * n).

Começamos escrevendo uma lista de propriedades dos inteiros que sua experiência anterior lhe dirá que devem ser consideradas verdadeiras, coisas em que você sempre acreditou de qualquer maneira.

Chamamos essas propriedades de #axiomas. Axiomas são afirmações que formam o ponto de partida de uma discussão matemática; itens que são assumidos (por um acordo entre autor e leitor) sem questionamento ou análise mais profunda. Uma vez que os axiomas estejam estabelecidos, exploramos então o quanto pode ser logicamente deduzido a partir deles. Uma teoria matemática é rica se uma grande quantidade de coisas puder ser deduzida a partir de poucos axiomas primitivos (e intuitivamente aceitáveis). 

Em resumo, temos que começar de algum lugar. Os axiomas em um curso podem, na verdade, ser teoremas em um curso mais profundo, cujos axiomas são mais primitivos. A lista de axiomas é simplesmente um ponto de partida claramente declarado. 

**Se abrirmos um livro de matemática na biblioteca, geralmente não veremos uma lista de axiomas na primeira página, mas eles estão presentes implicitamente: o autor está assumindo o conhecimento de uma matemática mais básica que repousa sobre axiomas conhecidos pelo leitor.**

## 1.1 Axioms
Assumimos que existe um conjunto, denotado por Z, cujos membros são chamados de **inteiros**. Este conjunto Z é equipado com operações binárias chamadas de adição e multiplicação. Satisfazendo os cinco axiomas a seguir, bem como os Axiomas 2.1 e 2.15 a serem introduzidos no capítulo 2.

(*Uma operação binária em um conjunto S é um procedimento que recebe dois elementos de S como entrada e fornece outro elemento de S como saída.*)

**Axioma 1.1**. Se *m*, *n* e *p* são inteiros, então:
(i) m + n = n + m  (*commutativity of addition*)
(ii) (m + n) + p = m + (n + p). (*associativity of addition*)
(iii) m*(n+p) = m * n + m * p (*distributivity*)
(iv) m * n = n * m (*commutativity of multiplication*)
(v) (m * n ) * p = m * (n * p) (*associativity of multiplication*)

Axioma 1.2. Existe um inteiro $0$ tal que, sempre que $m \in \mathbb{Z}$, $m+0 = m$. (elemento identidade para a adição)

**Axioma 1.3.** Existe um inteiro $1$ tal que $1 \neq 0$ e, sempre que $m \in \mathbb{Z}$, $m \cdot 1 = m$. (elemento identidade para a multiplicação)

**Axioma 1.4.** For each $m \in \mathbb{Z}$, there exist an integer denoted by -m, such that m + (-m) = 0.

**Axioma 1.5.** Let m, n, and p be integers. If m * n = m * p and m diferente de 0, then n = p. *(cancellation)*.



**Podemos nos perguntar: como um conjunto é definido? Usaremos a palavra intuitivamente; um conjunto é uma coleção de "coisas" ou elementos ou membros. Falaremos mais sobre isso no Capítulo 5.**

**O lado direito do axioma (iii) deveria ser lido como (m.n)+(m.p). É uma convenção útil sempre multiplicar antes de somar, sempre que uma expressão contiver tanto + quanto . (a menos que essa ordem seja alterada por parênteses.**

**Os símbolos $\in$ e $=$.** O símbolo $\in$ significa "é um elemento de" — por exemplo, $0 \in \mathbb{Z}$ significa "0 é um elemento do conjunto $\mathbb{Z}$". O símbolo "$=$" significa "igual". Dizer $m = n$ significa que $m$ e $n$ são o mesmo número.

Observamos algumas propriedades do símbolo "$=$": 
(i) $m = m$. (reflexividade) 
(ii) Se $m = n$, então $n = m$. (simetria) 
(iii) Se $m = n$ e $n = p$, então $m = p$. (transitividade) 
(iv) Se $m = n$, então $n$ pode ser substituído por $m$ em qualquer afirmação sem alterar o significado dessa afirmação. (substituição)

Um exemplo de (iv): se sabemos que m = n, então podemos concluir que m + p = n + p.

O símbolo "$\neq$" significa "não é igual a". Dizer m $m \neq n$ significa *m* e *n* são números diferentes. Note que $\neq$ satisfaz a simetria, mas não a transitividade e a reflexividade. 

De modo semelhante, o símbolo $\notin$ significa "não é um elemento de".

**Em outros livros didáticos, (i)-(iv) poderiam formar outro axioma, juntamente com axioma para conjuntos. Para chegar à matemática interessante logo no início, optamos por não incluir axiomas sobre teoria dos conjuntos e lógica, mas contamos com sua intuição sobre o que um "conjunto" deve ser e o que significa dois membros de um conjunto serem iguais.**

## 1.2 First Consequences
Neste ponto, os únicos fatos que consideramos conhecidos sobre os inteiros são os Axiomas 1.1-1.5.

Na linguagem da matemática, os axiomas são verdadeiros ou são fatos. Toda vez que provamos que alguma afirmação segue logicamente dos axiomas, estamos provando que ela também é verdadeira, tão verdadeira quanto os axiomas, e a partir de então podemos adicioná-la à nossa lista de fatos. Uma vez que tenhamos estabelecido que a afirmação é um fato (isto é, é verdadeira), podemos usá-la em argumentos lógicos posteriores: ela é tão boa quanto um axioma porque decorre dos axiomas.

De agora em diante, usaremos a notação comum *mn* para denotar *m * n* . Começamos com algumas proposições que mostram que nossos axiomas ainda valem quando alteramos a ordem de alguns termos:

**Proposição 1.6.** Se *m*, *n* e *p* são inteiros, então (m + n)p = mp + np.

**Aqui está uma demonstração da Proposição 1.6.** Sejam $m, n, p \in \mathbb{Z}$. O lado esquerdo (m + n)p do que estamos tentando provar é igual a p(m + n) pelo Axioma 1.1 (iv) [comutatividade]. Agora, podemos usar o Axioma 1.1(iii) [distributividade] para deduzir que *p(m+n) = pm + pn*. Finalmente, usamos o Axioma 1.1 (iv) novamente: *pm = mp e pn = np*. Em resumo, provamos:

(m + n)p = p(m +n) = pm + pn = mp + np
isto é, (m +n)p = mp + np  $\square$.

**O que é verdade? Isso é para os filósofos discutirem. Os matemáticos tentam evitar tais questões pelo método axiomático: na matemática, uma afirmação é considerada verdadeira se segue logicamente os axiomas acordados.**

Usamos $\square$ para marcar o fim de uma demonstração.

Tudo o que usamos foram algumas afirmações que sabemos ser verdadeiras (Axiomas 1.1 (iii) e (iv), e combinamos essas afirmações de uma maneira que nos forneceu a afirmação da Proposição 1.6). 

Podemos dar uma olhada na estrutura desta demonstração: assumimos que nos foram dados inteiros *m, n, p* e, usando os axiomas, chegamos à afirmação $(m+n)p = mp+np$. Pensando na última linha da demonstração como o objetivo do nosso trabalho, e geralmente é uma boa ideia escrever este objetivo antes de mostrar como chegar do que é dado ao que deve ser provado.

O que significa "provar se ♡ então ♣"? A afirmação "se ~então|" pode ser verdadeira, mas não óbvia; a questão é como vamos de ♡ até ♣. Essa jornada é chamada de demonstração da afirmação "se ~então |". 

---
A frase do livro usa símbolos gráficos (coração e paus) como *variáveis proposicionais*, algo que alguns autores fazem quando querem dar um exemplo totalmente abstrato de lógica proposicional, sem usar letras como *P* e *Q*. 

“prove if ♡ then ♣”

significa simplesmente: 
Prove: se ♡ é verdadeiro, então ♣ é verdadeiro.

---
Significa: nós começamos assumindo P. Notamos que, já que *P* é verdadeiro, *Q* deve também ser verdadeiro. E assim por diante..., onde no último passo vemos que *Q* deve ser verdadeiro. 

You can prove the next propositions in a similar way; try it.

**Proposition 1.7.** *If m is an integer, then* $0+m = m$ and $1*m = m$.

**Proposition 1.8.** *If m is an integer, then (-m) + m = 0.*
Pelo axioma (i): (-m)+m=m+(-m); e, pelo axioma 1.4, para cada m pertencente aos inteiros, sempre vai existir um inteiro, denotado por -m, tal que m+(-m)=0; portanto: $(-m)+m=m+(-m)=0$.


**Proposition 1.9.** *Let m, n, and p be integers. If m + n = m + p, then n = p*.

**O que dizer e o que omitir**
Dê uma olhada cuidadosa nas demonstrações que apresentamos até agora, as das Proposições 1.6 e 1.9. Na primeira, declaramos cada uso dos axiomas explicitamente. Na segunda, indicamos quais axiomas e proposições estávamos usando, mas deixamos para você, o leitor, ver exatamente como.

Isso sugere a pergunta: "Quanto eu preciso dizer nas minhas demonstrações?",

Não há uma pergunta fácil de responder, pois depende de duas variáveis: o nível de entendimento matemática de (a) quem escreve e (b) quem lê. Como uma questão prática, o leitor das suas demonstrações neste curso será o instrutor, de quem se pode presumir um profundo domínio da matemática.

Você, o escritor, está aprendendo, então, no início, isto é, para demonstrações neste Capítulo 1, aconselha-se que digamos tudo; em outras palavras, forneça os detalhes como na nossa demonstração da Proposição 1.6.

Ao realizarmos isso, veremos que é demorado e entendiante. Pensaremos: "Muito do que estou fazendo decorre obviamente dos axiomas e proposições, então eu não deveria ter que explicar tudo detalhadamente."

Você está certo a longo prazo, mas (como um de nossos professores nos disse uma vez) "**na matemática, você tem que ganhar o direito de ser vago**".

Portanto, aconselhamos que você pratique com os detalhes até que fique claro para você e seu instrutor o que pode ser omitido. Mas esta regra permanece: você deve dizer o suficiente para que tanto você (o escritor) quanto seu leitor possam ver que seu argumento está correto e devidamente pensado. Essa parte nunca mudará.

---

**Insight do Instrutor:**
**Cenário Rigoroso (Onde estamos agora):** pelos axiomas que lemos, a adição é uma operação *binária*. Ela só sabe somar **dois** números por vez. Se pedirmos para somar $A+B+C$, estritamente falando, essa expressão **não existe**. É ilegal. Só podemos fazer:
1. $(a+b)+c$
2. $a+(b+c)$
**O trabalho "chato":** em breve, teremos que provar (ou aceitar a prova) de que (a + b) + c é sempre igual a $a+(b+c)$.

**A Recompensa ("Ganhar o Direito")**: uma vez que isso é provado, a distinção entre as duas formas irrelevante para o resultado final. Só nesse momento ganhamos o "direito" de escrever $a+b+c$ sem parênteses. A sua "vagueza" ( a falta de parênteses) é permitida porque garantimos que a ambiguidade não altera a verdade. 

Ser vago na matemática não é ser impreciso; é omitir detalhes que **provavelmente** não afetam o resultado. Se pularmos passos antes de entender isso, não estamos sendo eficiente, estamos correndo o risco de assumir verdades que não existem (como tentar fazer isso com a subtração, onde $(a-b)-c \neq a -(b-c)$).

---

### Proposição 1.10: Sejam $m,x_{1},x_{2} \in \mathbb{Z}$. Se $m,x_{1},x_{2}$ satisfazem as equações $m+x_{1}=0$ e $m+x_{2}=0$, então $x_{1}=x_{2}$.

**Nota Lateral:** Isso significa que, dado $m \in \mathbb{Z}$, o inteiro $-m$ mencionado no Axioma 1.4 é a solução única da equação $m+x=0$.

### Proposição 1.11. Se $m, n, p, q$ são inteiros, então:
(i) $(m+n)(p+q)=(mp+np)+(mq+nq)$
(ii) $m+(n+(p+q))=(m+n)+(p+q)=((m+n)+p)+q$.
(iii) $m+(n+p)=(p+m)+n$
(iv) $m(np)=p(mn)$
(v) $m(n+(p+q))=(mn+mp)+mq$
(vi) $(m(n+p)q)=(mn)q+m(pq)$

**Por que nos importamos com demonstrações?** Provar uma afirmação significa convencer a si mesmo ou ao seu público, além de qualquer dúvida, de que a afirmação é verdadeira. <span style="background:#affad1">Uma afirmação provada é um fato novo</span>. A matemática é como um edifício em construção: cada novo fato provado é um novo tijolo. Você não quer tijolos defeituosos.

Aqui estão algumas proposições que refinam nosso conhecimento sobre 0 e 1:

**Proposição 1.12.** Seja $x \in \mathbb{Z}$. Se x tem a propriedade de que para **cada** inteiro m, $,+x=m$, então $x=0$.

**Nota Lateral:** A proposição 1.12 diz que o inteiro 0 mencionado no axioma 1.2 é a solução única da equação m+x=m.

**Proposição 1.13.** Seja $x\in\mathbb{Z}$. Se $x$ tem a propriedade de que existe **um** inteiro *m* tal que $m+x=m$, então $x=0$.

**Proposição 1.14.** Para todo $m\in\mathbb{Z}$, $m*0=0=0*m$

As proposições neste capítulo devem ser provadas na ordem em que são apresentadas aqui.

Quando *m* e *n* são inteiros, dizemos que *m* é **divisível** por *n* (ou alternativamente, *n* divide m) se existe $j\in\mathbb{Z}$ tal que $m=jn$. Usamos a notação $n|m$.

> **Nota Lateral:** Não confunda isso com as notações $n/m$ e $n \div m$ para frações.

**Insight do Instrutor: A Sutileza do Óbvio**
Chamando a atenção para a **Proposição 1.14**. Podemos pensar: *mas isso não é óbvio? Zero vezes qualquer coisa é zero.*

Cuidado! Nos axiomas que vimos até agora, o 0 foi definido apenas como o elemento neutro da **adição** $(m+0=m)$. Não há nenhum axioma dizendo como o 0 se comporta na **multiplicação**.

**O Desafio Matemático:** Você deve provar que $m \cdot 0 = 0$ usando apenas a distributividade (Axioma 1.1-iii) para conectar a adição com a multiplicação. A prova geralmente segue essa linha lógica (o truque do "adicionar zero"):
$m.0=m.(0+0)=m.0+m.0$
E então, cancelamos um m.0 de ambos os lados (usando o inverso aditivo ) para chegar a 0=m.0.

**O Insight do Programador Hard: Otimização Algébrica em Compiladores**
Olhe para a **Proposição 1.11(v)**: $m(n+(p+q)) = (mn+mp)+mq$.
Matematicamente, é uma igualdade. Computacionalmente, o lado esquerdo e o direito tem **custos** diferentes.
1. **Lado Esquerdo:** `m * (n + p + q)`
- Operações: 2 adições, 1 multiplicação.

2. **Lado Direito:** `m*n + m*p + m*q`
- Operações: 2 adições, 3 multiplicações.

Em processadores modernos, a multiplicação geralmente consome mais ciclos de clock e energia do que a adição. Um compilador otimizador (como o GCC ou o JIT do Java) usa essas identidades matemáticas para realizar **Strenght Reduction** e **Common Subexpression Elimination**.

Se escrevermos o código do lado direito, o compilador reconhecerá a estrutura algébrica (fator comum m) e reescreverá o nosso código em Assembly para a forma do lado esquerdo, economizando 2 multiplicações caras. Entender essas propriedades permite que escrevamos código legível sabendo que a matemática garante a otimização, o que a gente otimize manualmente em loops críticos onde o compilador falha.

Além disso, a #divisibilidade (m=jn) é a base da operação de módulo %. Em criptografia RSA, verificar a divisibilidade e trabalhar com restos de números gigantes é 90% do trabalho. A definição forma m = jn é exatamente o que o algoritmo de Euclides estendido explora para quebrar chaves de segurança.

**Exemplo 1.15.** Pensamos sobre divisibilidade no ensino fundamental (antes de saber dividir dois números). Muito provavelmente, o primeiro exemplo foi dado pelos números inteiros pares, que são definidos como aqueles inteiros que são divisíveis por 2.

> **Nota Lateral:** Aqui definimos $2 = 1+1$. Falaremos mais sobre isso no próximo capítulo.

**Proposição 1.16:** Se *m* e *n* são inteiros pares, então *m + n* e *mn* também o são. 

**Proposição 1.17.**. (i) 0 é divisível por todo inteiro; (ii) se *m* é um inteiro diferente 0, então *m* não é divisível por 0.

**Insight do Programador Hard**:
Olhemos para a **Proposição 1.17 (ii):** "Se $m\neq0$", então *m* não é divisível por 0.

Isso é a definição formal do erro mais famoso da computação: **DivisionByZero**.

O tipo int segue estritamente os axiomas de $\mathbb{Z}$ apresentados neste livro.

No nível do hardware (ALU - Arithmetic Logic Unit), a divisão não é uma operação mágica; ela é definida como o inverso da multiplicação. Quando pedimos ao processador para calcular int result 10 /0, o processador busca um número *q* tal que: 0.q=10.

Pela **Proposição 1.14** que vimos antes, o 0.q é sempre 0. Logo, a equação se torna 0 = 10. Isso é uma contradição lógica, o processador não tem como resolver uma contradição, então ele dispara uma interrupção de hardware, que o SO captura e o Java transforma em *java.lang.AritmeticException*

**Proposição 1.18.** Seja $x\in\mathbb{Z}$. Se $x$ tem a propriedade de que para **todo**  $m \in \mathbb{Z}$, $mx = m$, então $x = 1$.

> Nota Lateral: Assim, o inteiro 1 mencionado no Axioma 1.3 é a solução **única** da equação $mx=m$.

**Proposição 1.19.** Seja $x\in\mathbb{Z}$. Se x tem a propriedade de que para algum $m$ não nulo em $\mathbb{Z}$, $mx=m$, então $x=1$.

Essa é outra afirmação do tipo "se-então" se a afirmação *P* for verdadeira, então a afirmação $Q$ é verdadeira também. A afirmação $P$ aqui é "x tem a propriedade de que para algum *m* não nulo em $\mathbb{Z}$", para o qual $mx=m$. Primeiro usamos o Axioma 1.3:
$m.x=m=m.1$
e então aplicamos o Axioma 1.5 aos lados esquerdo e direito desta última equação (note que $m\neq0$) para deduzir que $x=1$. Em resumo, assumindo que $x$ tem a propriedade de que $mx=m$ para algum $m$ não nulo $\in \mathbb{Z}$, concluímos que $x = 1$, e isso prova nossa afirmação se–então. 

Aqui estão mais algumas proposições sobre inversos e cancelamento:

**Proposição 1.20.** Para todos $m, n \in \mathbb{Z},(-m)(-n)=mn$.
Demonstração. Sejam $m, n \in \mathbb{Z}$. Pelo Axioma 1.4,

$$m + (-m) = 0 \quad \text{e} \quad n + (-n) = 0.$$

Multiplicando ambos os lados da primeira equação (à direita) por $n$ e a segunda equação (à esquerda) por $-m$, obtemos, após aplicar a Proposição 1.14 nos lados direitos:

$$(m + (-m))n = 0 \quad \text{e} \quad (-m)(n + (-n)) = 0.$$

Com o Axioma 1.1(iii) e a Proposição 1.6, deduzimos:

$$mn + (-m)n = 0 \quad \text{e} \quad (-m)n + (-m)(-n) = 0.$$
Resta usar o Axioma 1.1(i) à esquerda e, em seguida, a Proposição 1.10 para concluir:

$$mn = (-m)(-n). \quad \blacksquare$$
**Corolário 1.21.** $$(-1)(-1)=1$$
*Nota Lateral: a palavra corolário é usada para uma afirmação que é uma consequência direta da proposição anterior.*

**Proposição 1.22.** Para todo $m\in \mathbb{Z},-(-m)=m$, (ii)$-0=0$.
**Proposição 1.23.** Dados $m, n \in \mathbb{Z}$, existe um e apenas um $x \in \mathbb{Z}$ tal que $m + x = n$.

>Nota lateral: Mais tarde (uma vez que tenhamos introduzido a subtração), chamaremos esta solução de $n-m$.

Essa proposição é uma afirmação de **existência e unicidade**, expressa pela frase "um e apenas um". Para inteiros dados *m* e *n*, ela diz que uma solução, *x*, da equação $m+x=n$ existe (esta é a parte da existência), e que se parecer haver duas soluções, elas devem ser iguais (a parte da unicidade). 

> _Nota lateral:_ A palavra **único** (unique) tem conotações fortes na linguagem comum. Em matemática, unicidade significa simplesmente que se ambos se encaixam, eles devem ser iguais.

**Demonstração da Proposição 1.23**. O inteiro $x = (-m) + n$ é uma solução, pois

$$m + ((-m) + n) = (m + (-m)) + n = 0 + n = n$$

(aqui usamos os Axiomas 1.1 e 1.4, e a Proposição 1.7).

são ambas soluções para $m + x = n$, isto é,

$$m + x_1 = n \quad \text{e} \quad m + x_2 = n.$$

**Proposição 1.24.** Seja $x \in \mathbb{Z}$. Se $x \cdot x = x$, então $x = 0$ ou $1$

**Proposição 1.25.** Para todos $m, n \in \mathbb{Z}$: (i) $-(m + n) = (-m) + (-n)$. (ii) $-m = (-1)m$. (iii) $(-m)n = m(-n) = -(mn)$.

As Proposições 1.24 e 1.26 contêm a palavra de aparência **ou**. Na linguagem cotidiana, o significado de "ou" nem sempre é claro. Pode significar um *ou exclusivo* (como em "ou... ou... mas não ambos") ou um "ou inclusivo" (como em "ou... ou... ou ambos"). Em matemática, a palavra "ou", sem qualificação adicional, é sempre inclusiva. Por exemplo, na proposição 1.26, pode muito bem acontecer que tanto *m* quanto *n* sejam zero. 

Isto é tão importante que diremos novamente: **Em matemática, "A ou B" sempre significa A, ou B, ou ambos A e B**. 

**Demonstração da Proposição 1.26.** Novamente temos uma afirmação _se-então_, então assumimos que os inteiros $m$ e $n$ satisfazem $mn = 0$. Precisamos provar que ou $m = 0$ ou $n = 0$ (ou ambos). Uma ideia que você pode ter é reescrever 0 no lado direito da equação $mn = 0$ como $m \cdot 0$ (usando a Proposição 1.14):

$$m.n=m.0$$

Essa nova equação sugere que usemos o Axioma 1.5 para cancelar *m* em ambos os lados. Temos que ter cuidado aqui: só podemos fazer isso se $m\neq_{0}$. Mas isso não é o problema:  se $m = 0$ terminamos, pois então a afirmação "$m = 0$ ou $n = 0$" é verdadeira (note que, nesse caso, ainda pode acontecer que $n = 0$). Se $m \neq 0$, cancelamos $m$ em (1.1) para deduzir $n = 0$, o que novamente significa que a afirmação "$m = 0$ ou $n = 0$" se sustenta. Em resumo, mostramos que se $mn = 0$ então $m = 0$ ou $n = 0$. $\quad \blacksquare$

> _Nota lateral:_ Em uma prova específica, pode ser vantajoso trocar os papéis de $\mathcal{A}$ e $\mathcal{B}$ (o que você pode fazer livremente, já que a afirmação "$\mathcal{A}$ ou $\mathcal{B}$" é simétrica em $\mathcal{A}$ e $\mathcal{B}$).

Nossa prova ilustra como abordar uma afirmação "ou": se nosso objetivo é provar "$A ou B$", basta provar um entre $A e B$.  Em nossa prova, A era a afirmação $m = o$ e realmente só precisávamos nos preocupar com o caso em que A é falsa e então precisávamos provar que $B$ é verdadeira.

Em contraste, quando precisamos provar uma afirmação "e", devemos provar duas afirmações.

Aqui está algo que podemos mostrar: assumindo os axiomas 1.1-1.5, provamos a Proposição 1.26. Por outro lado, se assumirmos os axiomas 1.1-1.4 e a afirmação da Proposição 1.26, podemos provar a afirmação do Axioma 1.5. Em outras palavras, poderíamos ter tomado a Proposição 1.26 como um axioma no lugar do Axioma 1.5.


---
**Insight Computacional (Java e Lógica de Programação)**
**Unicidade e Determinismo de Funções**
A Proposição 1.23 $(m+x=n)$ tem solução única, é a base teórica para tratarmos a subtração como uma **função**. Em Java, considere o método:
```java
// Contrato: retorna o único x tal que m+x==n
public static int solveForX(int m, int n) {
	return n-m; // A existência e unicidade garantem que este retorno é válido
}
```

Se a solução não fosse única, esse método não poderia retornar um simples *int*; teria que retornar um *List< Integer >* ou **Set< Integer >**. A unicidade matemática é o que nos permite usar tipos primitivos simples como valores de retorno. 

**"Ou" Inclusivo e Short-Circuit**
O texto discute o "Ou Inclusivo". Em Java, o operador || (OR lógico) mapeia exatamente essa ideia, mas com uma característica computacional chamada **Short-Circuit evaluation**.

```java
// Proposição 1.26: se mn = 0, então m = 0 OU n = 0
if (m == 0 || n == 0) {
	// Entramos aqui se m for 0, se n for 0, ou se ambos forem 0
}
```
- **Matemática:** a ordem não importa $A \lor B$ é igual a $B \lor A$ .
- **Java:** A ordem importa para performance e segurança. Se *m == 0* for verdadeiro, o Java nem avalia n == 0 .

**Invariantes e Assertions (Propriedades do Produto Zero)**
A proposição 1.26 é crucial para a integridade de dados. Se temos um produto que resultou em zero, sabemos um fato imutável sobre os operandos.
```java
public void processFactors(int m, int n) {
	int product = m * n;
	
	if (product == 0) {
		// Invariante Matemática: Pelo menos um deve ser zero.
		// Se m não for zero, n OBRIGATORIAMENTE deve ser zero
		if (m != 0) {
			assert n == 0 : "Violação da Propriedade do Produto zero: Impossível em Z";
		}
	}
}
```

Isso é útil em **análise estatística** e **testes unitários**. Se o nosso código encontrar um caso onde *product == 0*, *m != 0* e *n != 0*, descobrimos um bug grave (provavelmente overflow, já que em computação int tem tamanho fixo, diferente de $\mathbb{Z}$ matemático que é infinito).

**Atenção ao Overflow:** Em Java, `int` é limitado (32-bit). É possível que `m * n` seja 0 mesmo que $m, n \neq 0$ se o resultado for múltiplo de $2^{32}$ (comportamento de wrap-around). A matemática do livro assume $\mathbb{Z}$ infinito. Ao programar, o axioma "se $mn=0 \implies m=0 \lor n=0$" só é verdadeiro se não houver overflow.

**Teste de Propriedade (Property-Baased Testing)**
Como testaríamos a Proposição 1.20 $(-m)(-n) == mn$ em Java? Não basta fazer $(-2)*(-3)$. Devemos usar uma ferramenta como #jqwik para testar a propriedade para *todos* os inteiros gerados:
```java
@Property
void negativeTimesNegativeIsPositive(@ForAll int m, @ForAll int n) {
	// Cuidado com Integer.MIN_VALUR devido ao overflow na negação
	Assume.that(m != Integer.MIN_VALUE && n != Integer.MIN_VALUE);
	
	int leftSide = (-m) * (-n);
	int rightSide = m * n;
	
	Assertions.assertEquals(leftSide, rightSide);
}
```

## 1.3 Subtraction
