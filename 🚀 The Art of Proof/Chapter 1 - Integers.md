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

**O que é verdade? Isso é para os filósofos discutirem. Os matemáticos tentam evitar tais questões pelo método axiomático: na matemática, uma afirmação é considerada verdadeira se segue logicamente dos axiomas acordados.**

Usamos $\square$ para marcar o fim de uma demonstração.

Tudo o que usamos foram algumas afirmações que sabemos ser verdadeiras (Axiomas 1.1 (iii) e (iv), e combinamos essas afirmações de uma maneira que nos forneceu a afirmação da Proposição 1.6). 

Podemos dar uma olhada na estrutura desta demonstração: assumimos que nos foram dados inteiros *m, n, p* e, usando os axiomas, chegamos à afirmação $(m+n)p = mp+np$. Pensando na última linha da demonstração como o objetivo do nosso trabalho, e geralmente é uma boa ideia escrever este objetivo antes de mostrar como chegar do que é dado ao que deve ser provado.

O que significa "provar se ~ então |"? A afirmação "se ~então|" pode ser verdadeira, mas não óbvia; a questão é como vamos de ~ até |. Essa jornada é chamada de demonstração da afirmação "se ~então |". 

---
A frase do livro usa símbolos gráficos (coração e paus) como *variáveis proposicionais*, algo que alguns autores fazem quando querem dar um exemplo totalmente abstrato de lógica proposicional, sem usar letras como *P* e *Q*. 

“prove if ♡ then ♣”

significa simplesmente: 
Prove: se ♡ é verdadeiro, então ♣ é verdadeiro.

---
Significa: nós começamos assumindo P. Notamos que, já que *P* é verdadeiro, *Q* deve também ser verdadeiro. E assim por diante..., onde no último passo vemos que *Q* deve ser verdadeiro. 

You can prove the next propositions in a similar way; try it.

**Proposition 1.7.** *If m is an integer, then* $0+m = m$ and $1*m = m$.

