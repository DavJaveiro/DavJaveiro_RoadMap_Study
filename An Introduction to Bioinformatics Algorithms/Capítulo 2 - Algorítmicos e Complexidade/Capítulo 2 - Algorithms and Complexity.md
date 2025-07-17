This book is about how to design algorithms that solve biological problems. We will see how popular bioinformatics algorithms work and we will see what principles drove their designs. Its is important to understand how an algorithm works in order to be confident in its results;
Before considering any algorithms in detail, we need to define loosely what we mean by the word *algorithm* and what might qualify as one. In many places throughout this text we try to avoid tedious mathematical formalisms, yet leave intact the rigor and intuition behind the important concept.

## What is an Algorithm?
A grosso modo, um algoritmo é uma sequência de instruções que se deve executar para resolver um problema bem formulado. Nós especificaremos os problemas em termos de suas entradas (inputs) e suas saídas (outputs), e o algoritmo será o método para traduzir as entradas nas saídas. Um problema bem formulado é inequívoco e preciso, não deixando margem para má interpretação. 
*Na bioinformática, a montagem de genomas e um problema bem formulado onde o input são milhões de fragmentos de sequências e o output é o genoma completo, exigindo algoritmos que resolvam a complexa sobreposição dos fragmentos.*

Para resolver um problema, alguma entidade precisa executar os passos especificados pelo algoritmo. Um ser humano com caneta e papel seria capaz de fazer isso, mas os humanos são geralmente lentos, cometem erros e preferem não realizar trabalhos repetitivos. Um computador é menos inteligente, mas pode executar passos simples de forma rápida e confiável. Um computador não consegue entender o português, então os algoritmos devem ser reformulados em uma linguagem de programação como C ou Java para fornecer instruções específicas ao processador.  Cada detalhe deve ser especificado ao computador no formato exato, o que torna difícil descrever algoritmos; detalhes insignificantes que uma pessoa entenderia naturalmente precisam ser especificados. Se um computador tivesse que calçar sapatos, seria preciso dizer a ele para encontrar um par que combine e sirva, para colocar o sapato esquerdo no pé esquerdo, o direito no pé direito, e para amarrar os cadarços. Neste livro, no entanto, preferimos simplesmente resumir a "Calce um par de sapatos".
*Construir soluções em bioinformática é traduzir uma questão biológica em um workflow computacional, onde cada passo, da busca em bancos de dados à analise, é uma instrução precisa e detalhada para a máquina.*

No entanto, para entender como um algoritmo funciona, precisamos de uma forma de listar os passos que o algoritmo executa, sem ser vago ou formal demais. Usaremos o **pseudocódigo**, cujas operações elementares estão resumidas abaixo. Pseucodógio é uma linguagem que cientistas da computação frequentemente usam para descrever algoritmos: ele ignora muitos dos detalhes exigidos em uma linguagem de programação, mas é mais preciso e menos ambíguo do que, por exemplo, uma receita de um livro de culinária. Individualmente, as operações não resolvem nenhum problema particularmente difícil, mas podem ser agrupadas em mini algoritmos chamados de **sub-rotinas**.

Em nossa versão específica de pseudocódigo, usamos os conceitos de **variáveis, arrays (vetores) e argumentos**. Uma variável, escrita como **x** ou **total**, contém algum valor numérico e pode receber um novo valor numérico em diferentes pontos ao longo da execução de um algoritmo. Um array de *n* elementos é uma coleção ordenada de *n*  variáveis, *a1, a2, ..., an*. Geralmente, denotamos arrays com letras em negrito como **a = (a1, a2, ..., an.)** e escrevemos os elementos individuais como ai, onde i está entre 1 e n. Um algoritmo em pseudocódigo é denotado por um nome, seguido pela lista de argumentos que ele requer, como **MAX(a, b)** abaixo; isso é seguido pelas instruções que descrevem as ações do algoritmo.

Pode-se invocar um algoritmo passando a ele os valores apropriados para seus argumentos. Por exemplo, **MAX(1, 99)** retornaria o maior valor entre 1 e 99. A operação return informa o resultado do programa ou simplesmente sinaliza seu término. Abaixo estão breves descrições dos comandos elementares que usamos no pseudocódigo ao longo deste livro.
*O pseudocódigo formaliza a lógica de algoritmos complexos, como o UPGMA para clustering, permitindo o planejamento e a validação do método antes de sua implementação em uma linguagem de programação específica em bioinformática.*


**Assignment ou Atribuição**
**Formato**: a ← b
**Efeito:** Define o valor da variável *a* como o valor de *b*.
**Exemplo:** `b ← 2` `a ← b`
**Resultado:** O valor de **a** passa a ser 2.

*Em programação dinâmica para alinhamento de sequências, a atribuição é crucial: o valor de cada célula da matriz (score) é atribuído com base nos valores ótimos das células vizinhas já computadas.*

**Aritmética**
- **Formato:** a + b, a - b, a * b, a / b, a<sup>b</sup> 
- **Efeito:** adição, subtração, multiplicação, divisão e exponenciação de números.
- **Exemplo:** DIST(x₁, y₁, x₂, y₂)
	1. dx ← (x₂ − x₁)²
	2. dy ← (y₂ − y₁)²
	3. return √(dx + dy)
- **Resultado:** `DIST(x₁, y₁, x₂, y₂)` calcula a distância Euclidiana entre pontos com coordenadas (x₁, y₁) e (x₂, y₂). `DIST(0, 0, 3, 4)` retorna 5.
*Operações aritméticas são a base para quantificar relações biológicas, como no método UPGMA, onde a distância evolutiva entre novos agrupamentos é calculada como a média aritmética das distâncias originais entre sequências.*

**Condicional**
- **Formato:**
se A é verdadeira B, senão C.
- **Efeito:** se a declaração A for verdadeira, executa as instruções B; caso contrário, executa as instruções C. O bloco **senão C** pode ser omitido.
- **Exemplo:** MAX(a, b)
	1. se a < b
	2. return b
	3. senao
	4. return a
*A lógica condicional é central em alinhamentos de sequência. A cada passo, o algoritmo decide (se/senão) qual o melhor caminho, match, inserção ou deleção, baseado na maximização da pontuação acumulada.*

### **Laços `for`**

- **Formato:** `para i ← a até b` `B`
    
- **Efeito:** Executa as instruções `B` repetidamente, com a variável `i` assumindo os valores de `a` até `b`, um a um.
    
- **Exemplo:** `SUMINTEGERS(n)`
    
    1. `sum ← 0`
        
    2. `para i ← 1 até n`
        
    3. `sum ← sum + i`
        
    4. `return sum`
        
- **Resultado:** `SUMINTEGERS(n)` calcula a soma dos inteiros de 1 a `n`.
*Laços 'for' são essenciais para percorrer sequências biológicas. Em bioinformática, eles permitem analisar um genoma base por base, por exemplo, para identificar todos os k-mers e calcular suas frequências de ocorrência.*

### **Laços `while`**

- **Formato:** `enquanto A é verdadeiro` `B`
- **Efeito:** Executa as instruções `B` repetidamente enquanto a condição `A` for verdadeira.
- **Exemplo:** `ADDUNTIL(b)`
    1. `i ← 1`
        
    2. `total ← i`
        
    3. `enquanto total ≤ b`
        
    4. `i ← i + 1`
        
    5. `total ← total + i`
        
    6. `return i`
        
- **Resultado:** `ADDUNTIL(b)` calcula o menor inteiro `i` tal que a soma de 1 até `i` seja maior que `b`.
*Laços 'while' são ideais para processos iterativos cujo fim não é pré-determinado, como na construção de árvores filogenéticas, onde os agrupamentos são refeitos 'enquanto' houver mais de um cluster de sequências.*

### **Acesso a Array (Vetor)**

- **Formato:** `aᵢ`
    
- **Efeito:** Acessa o i-ésimo elemento do array `a` = (a₁, . . . aᵢ, . . . aₙ).
    
- **Exemplo:** `FIBONACCI(n)`
    
    1. `F₁ ← 1`
    2. `F₂ ← 1`
    3. `para i ← 3 até n`
    4. `Fᵢ ← Fᵢ₋₁ + Fᵢ₋₂`
    5. `return Fₙ`
        
- **Resultado:** `FIBONACCI(n)` calcula o n-ésimo número de Fibonacci. `FIBONACCI(8)` retorna 21.
*Arrays são estruturas de dados centrais em genômica. Uma sequência de DNA é um array de caracteres, e a matriz de programação dinâmica para alinhamento é um array 2D onde o acesso a elementos vizinhos é fundamental.*

Embora cientistas da computação estejam acostumados com o jargão do pesudocódigo acima, tememos que alguns biólogos, ao lê-lo, possam decidir que este livro é muito enigmático e, portanto, inútil. Apesar de biólogos modernos lidarem com algoritmos diariamente, a linguagem que usam para descrever um algoritmo pode ser mais próxima daquela usada em um livro de receitas, como a receita de torta de abóbora na figura 2.1. Consequentemente, alguns livros de bioinformática são escritos nesse jargão familiar como um esforço para fazer com o que os biólogos se sintam à vontade com diferentes conceitos de bioinformática.

Infelizmente, a linguagem de livro de receitas é insuficiente para descrever ideias algorítmicas mais complexas que são necessárias até mesmo para as ferramentas mais simples em bioinformática. O problema é que as linguagens naturais não são adequadas para comunicar ideais algorítmicas mais complexas do que a da torta de abóbora. Cientistas da computação ainda não inventaram nada melhor do que o pseudocódigo para este propósito, então o utilizaremos neste livro.

Para ilustrar de forma mais concreta a distinção entre pseudocódigo e uma linguagem informal, podemos escrever um "algoritmo" para fazer uma torta de abóbora que imita a receita mostrada na figura 2.1. O pseudocódigo intencionalmente elaborado abaixo, **MAKEPUMPKINPIE**, é consideravelmente mais explícito.
*A inferência filogenética, como a busca pela árvore de máxima parcimônia, exige a precisão do pseudocódigo, pois uma descrição informal de "achar a árvore mais curta" é ambígua e computacionalmente inviável de se executar.*

## 2.2 Biological Algorithms versus Computer Algorithms
A natureza usa procedimentos do tipo algorítmico para resolver problemas biológicos, por exemplo, no processo de replicação do DNA. Antes que uma célula possa se dividir, ela precisa primeiro fazer uma cópia completa de todo o seu material genético.

A replicação do DNA ocorre em fases, cada uma exigindo uma cooperação elaborada entre diferentes tipos de moléculas. Para simplificar, descrevemos o processo de replicação como ele ocorre em bactérias, em vez do processo em humanos ou outros mamíferos, que é consideravelmente mais complexo. O mecanismo básico foi proposto por James Watson e Francis Crick no início da década de 1950, mas só pode ser verificado através do engenhoso experimento de Meselson-Stahl em 1957. O processo de replicação começa com um par de fitas complementares de DNA e termina com dois pares de fitas complementares.
*Ao tratar a replicação como um algoritmo, a bioinformática transforma a questão "onde a replicação começa?" em um problema computacional: encontrar a origem de replicação (oriC) pela busca de padrões de sequência específicos no genoma.*

![[Capítulo 2 - Algorithms and Complexity.png]]

1. Uma máquina molecular (ou seja, um complexo proteico) chamada de DNA helicase, liga-se ao DNA em certas posições denominadas origens de replicação.
	- *A identificação de origens de replicação é crucial para a bioinformática no desenvolvimento de algoritmos que simulem ou prevejam o início da replicação em genomas, otimizando análises de sequenciamento e montagem.*
![[Capítulo 2 - Algorithms and Complexity-1.png]]

2. A helicase separa as duas fitas de DNA, criando a chamada forquilha de replicação. As duas fitas são complementares e correm em direções opostas (uma fita é denotada 3' -> 5', a outra 5' -> 3'). Duas outras máquinas moleculares, a topoisomerase e a proteína de ligação de fita simples (não mostradas), ligam-se às fitas simples para ajudar a aliviar a instabilidade do DNA de fita simples.
	- *A compreensão da direcionalidade das fitas (3' -> 5' e 5'->3') e da complementaridade é fundamental para o design de primers e sondas em biologia molecular, bem como para algoritmos de alinhamento de sequências que respeitem essas propriedades.*3![[Capítulo 2 - Algorithms and Complexity-3.png]]

3. Os primers, que são pequenas fitas simples de RNA, são sintetizados por um complexo proteico chamado primase e se ligam a posições específicas nas fitas recém-abertas, fornecendo uma âncora para a próxima etapa. Sem os primers, a próxima etapa não pode começar.
	*A dependência de primers para o início da síntese destaca a importância do design computacional de primers na biologia molecular, para reações de PCR e sequenciamento, garantindo especificidade e eficiência.*
	![[Capítulo 2 - Algorithms and Complexity-4.png]]

4. Uma DNA polimerase (outra máquina molecular) liga-se a cada fita molde de DNA recém-separada; a DNA polimerase percorre as fitas parentais apenas na direção 3'->5'. Portanto, as DNA polimerase ligadas às duas fitas de DNA movem-se em direções opostas.
	![[Capítulo 2 - Algorithms and Complexity-5.png]]

5. Em cada nucleotídeo, a DNA polimerase associa o nucleotídeo da fita molde com a base complementar e a adiciona à cadeia sintetizada em crescimento. Antes de passar para o próximo nucleotídeo, a DNA polimerase verifica se a base correta foi pareada na posição atual; se não, ela remove a base incorreta e tenta novamente. Como a DNA polimerase só pode percorrer o DNA na direção 3'->5', e como as duas fitas de DNA correm em direções opostas, apenas uma fita do DNA molde pode ser usada pela polimerase para sintetizar continuamente seu complemento; a outra fita requer paradas e reinícios ocasionais. Isso resulta em pequenos segmentos chamados fragmentos de Okazaki. *A fidelidade da replicação, com a capacidade de verificação da DNA polimerase, é um conceito central em genômica, influenciando o estudo de mutações, polimorfismos e a evolução da sequências genômicas ao longo do tempo.*
6. Outra máquina molecular, a DNA ligase, repara as lacunas na cadeia principal do DNA recém-sintetizado, ligando efetivamente todos os fragmentos de Okazaki em uma única molécula e limpando quaisquer quebras na fita primária. *A ação da DNA ligase na união de fragmentos tem paralelos em bioinformática com algoritmos de montagem de genomas, onde fragmentos de sequências são unidos para reconstruir o genoma completo.*
7. Quanto todo o DNA foi copiado dessa maneira, as fitas originais se separam, de modo que são formados dois pares de fitas de DNA, cada par consistindo de uma fita antiga e uma recém-sintetizada. Obviamente, uma quantidade surpreendente de logística molecular é necessária para garantir a replicação do DNA completamente precisa: a DNA helicase separa as fitas, a DNA polimerase garante a complementaridade adequada e assim por diante. No entanto, em termos da lógica do processo, nenhuma dessa complicada maquinaria molecular realmente importa, para mimetizar esse processo em um algoritmo, precisamos simplesmente pegar uma *string* que representa o DNA e retornar uma cópia dela. *A replicação semiconservativa é a base para a transmissão da informação genética, um princípio fundamental para a compreensão da hereditariedade e da evolução em biologia e genômica.*

Obviamente, uma quantidade surpreendente de logística molecular é necessária para garantir uma replicação de DNA completamente precisa: a DNA helicase separa as fitas, a DNA polimerase garante a complementaridade adequada, e assim por diante. No entanto, em termos da lógica do processo, nenhuma dessa complicada maquinaria molecular realmente importa, para mimetizar esse processo em um algoritmo, precisamos simplesmente pegar uma #string que representa o DNA e retornar uma cópia dele.

**Problema de Duplicação de String:**
Dada uma *string* de letras, retornar uma cópia.
Entrada: uma string s = (s1, s2, ..., sn) de comprimento n, como um arranjo de caracteres
Saída: uma string representando uma cópia de s.
É claro que este é um problema particularmente fácil de resolver e não produz absolutamente nenhuma intuição algorítmica interessante. No entanto, ainda é ilustrativo escrever o pseudocódigo. O programa STRINGCOPY abaixo usa a _string_ t para manter uma cópia da _string_ de entrada s, e retorna o resultado t.

STRINGCOPY(s, n) 1 para i←1 até n 2 ti​←si​ 3 retornar t

Embora STRINGCOPY seja um algoritmo trivial, o número de operações que um computador real executa para copiar uma _string_ é surpreendentemente grande. Para uma arquitetura de computador em particular, podemos acabar emitindo milhares de instruções para um processador. Cientistas da computação se distanciam dessa complexidade inventando linguagens de programação que permitem ignorar muitos desses detalhes. Biólogos ainda não inventaram uma "linguagem" similar para descrever algoritmos biológicos operando na célula. *A discrepância entre a simplicidade algorítmica de copiar uma string e a complexidade biológica da replicação ressalta o desafio da bioinformática em modelas a intrincada logística molecular com representações computacionais eficientes.*

A quantidade de *inteligência* que o organismo mais simples, como uma bactéria, exibe para realizar qualquer tarefa rotineira, incluindo a replicação, é surpreendente. Ao contrário do algoritmo STRINGCOPY, que apenas executa operações abstratas, a bactéria realmente constrói novo DNA usando materiais que estão flutuando perto da forquilha de replicação. O que aconteceria se acabassem? Para evitar isso, uma bactéria examina o ambiente, importa novos materiais de fora ou se move para procurar alimento. Além disso, ela espera para iniciar a cópia de seu DNA até que materiais suficientes estejam disponíveis. Essas observações, sem mencionar a coordenação entre as moléculas individuais, nos levam a questionar se mesmo os programas de computador mais sofisticados podem igualar o comportamento complicado exibido por até mesmo um organismo unicelular. 
*A capacidade bacteriana de gerenciar recursos e adaptar a replicação à disponibilidade ambiental destaca a necessidade de modelos bioinformáticos que integrem não apenas a mecânica molecular, mas também a regulação metabólica e a sensoriamento do ambiente.*

## 2.3 The Change Problem
O primeiro, e muitas vezes o mais difícil, passo para resolver um problema computacional e identificar precisamente qual é o problema. Usando as técnicas descritas neste livro, poderemos desenvolver um algoritmo que o resolva. No entanto, não podemos parar por aí. Duas perguntas importantes a fazer são: "Funciona corretamente?" e "Quanto tempo levará?". Certamente, não ficaríamos satisfeitos com um algoritmo que só retornasse resultados corretos metade das vezes, ou que levasse 600 anos para chegar a uma resposta. Estabelecer expectativas razoáveis para um algoritmo é um passo importante para entende quão bem o algoritmo resolve o problema e se podemos confiar em sua resposta.
- *Na bioinformática e biologia molecular, a validação de algoritmos não se restringe à correção lógica; e a eficiência computacional é crucial para processar grandes volumes de dados genômicos, exigindo métricas rigorosas de tempo e precisão.*

Um problema descreve uma classe de tarefas computacionais. Uma instância de problema é uma entrada particular dessa classe. Para ilustrar a diferença entre um problema e uma instância de um problema, considere o seguinte exemplo. Você se encontra em uma livraria comprando uma caneta bastante cara por $4,23, que você paga com uma nota de $5 (fig. 2.2). Você receberia 77 centavos de troco, e o caixa agora toma uma decisão sobre exatamente como você os recebe. Você ficaria irritado com um punhado de 77 moedas de um centavo ou 15 moedas de cinco centavos e 2 moedas de um centavo, o que levanta a questão de como dar o troco da maneira menos irritante. A maioria dos caixas tenta minimizar o número de moedas devolvidas para uma determinada quantidade de troco. O exemplo de 77 centavos representa uma instância do problema do Troco dos Estados Unidos, que podemos formular da seguinte forma.
*Na bioinformática, diferenciar problemas (e.g., alinhamento de sequências)
de nossas instâncias (e.g., alinhamento de duas sequências específicas) é crucial para desenvolver algoritmos robustos e eficientes, aplicáveis a uma vasta gama de dados biológicos.*

**Problema do Troco dos Estados Unidos**
Converter uma certa quantia de dinheiro no menor número de moedas.
**Entrada:** uma quantia de dinheiro, *M*, em centavos.
**Saída:** o menor número de moedas de vinte e cinco centavo *q*, moedas de dez centavos *d*, moedas de cinco centavos *n*, e moedas de um centavo *p* cujos valores somam *M* (ou seja, *25*q + 10d  + 5n + p = M e q + d + n + p é o menor possível).
O algoritmo que é usado por caixas em todos os Estados Unidos para resolver este problema é simples:
USCHANGE(*M*)
1 enquanto M > 0
2 c← Maior moeda que é menor (ou igual) a M
3 Entregar moeda com denominação *c* ao cliente
4 M ←M−c

Uma descrição ligeiramente mais detalhada deste algoritmo é:
1 Entregar a parte inteira de M/25 moedas de vinte e cinco centavos ao cliente.
2 Deixar o resto como a quantia restante devida ao cliente.
3 Entregar a parte inteira de resto/10 moedas de dez centavos ao cliente.
4 Deixar o resto como a quantia restante devida ao cliente. 
5 Entregar a parte inteira de resto/5 moedas de cinco centavos ao cliente. 
6 Deixar o resto como a quantia restante devida ao cliente. 
7 Entregar o resto em moedas de um centavo ao cliente.
USCHANGE(M) 1 r←M 
2 q←r/25 
3 r←r−25⋅q 
4 d←r/10 
5 r←r−10⋅d 
6 n←r/5 
7 r←r−5⋅n 
8 p←r 
a9 retornar (q,d,n,p)

Quando r / 25 não é um número inteiro, pegamos o piso de r / 25, ou seja, a parte inteira de 5 / 25. Quando o caixa executa USCHANGE(77), ele retorna três moedas de vinte e cinco centavos, nenhuma moeda de dez ou cinco centavos, e duas moedas de um centavo, que é o resultado desejado (não há outra combinação que tenha menos moedas e some 77 centavos). 

Primeiro, a variável *r* é definida como 77. Então*q*, o número de moedas de vinte e cinco centavos, é definido como o valor 3, já que [77 /25] = 3. A variável *r* é então utilizada na linha 3 para ser igual a 2, que é a diferença entre a quantia de dinheiro que o caixa está trocando (77 centavos) e as três moedas de vinte e cinco centavos que ele escolheu devolver. As variáveis *d* e *n*, moedas de dez e cinco centavos, respectivamente, são subsequentemente definidas como 0 nas linhas 4 e 6, já que [2 / 10] = 0 e [2 / 5] = 0; *r* permanece inalterado nas linhas 5 e 7, já que *d* e *n* são 0. Finalmente, a variável *p*, que significa "moedas de um centavo", é definida como 2, que é a quantia na variável *r*. Os valores das quatro variáveis, *q, d, n* e *p*, são retornados como a solução para o problema.
*A abordagem gulosa do problema do troco ilustra a otimização local em algoritmos, um conceito aplicável na bioinformática ao buscar soluções eficientes para problemas complexos como o alinhamento de sequências, onde a escolha ótima em cada etapa nem sempre garante o resultado globalmente melhor.*

## 2.4 Correct versus Incorrect Algorithms
Como apresentado, o algoritmo #USCHANGE carece de elegância e generalidade. Está implícita no algoritmo a suposição de que se está lidando com a moeda dos Estados Unidos, e que o caixa possui um suprimento ilimitado de cada denominação, sendo que, em geral, é mais difícil obter moedas de 25 centavos (quarters) do que de 10 centavos (dimes). Gostaríamos de generalizar o algoritmo para acomodar diferentes denominações, sem exigir um algoritmo completamente novo para cada conjunto monetário. Para isso, no entanto, é necessário primeiro generalizar o problema, fornecendo ao algoritmo as denominações com as quais ele pode trocar um valor **M**.
*A necessidade de tornar o algoritmo adaptável a diferentes entradas é análoga ao desafio bioinformático de desenvolver pipelines que aceitem múltiplos genomas de referência ou diferentes anotações, mantendo a consistência analítica entre espécies ou populações*.

O novo problema de Troco descrito abaixo parte da suposição de que existem **d** denominações, em vez das quatro do problema anterior. Essas denominações são representadas por um vetor c = (c1, ..., c_d). Para simplificar, assumimos que as denominações são fornecidas em ordem decrescente de valor. Por exemplo, no caso do problema de Troco dos Estados Unidos, c = (25, 10, 5, 1), enquanto no problema de Troco da União Europeia, c = (20, 10, 5, 2, 1).
*A estrutura vetorial e ordenada das denominações é comparável à representação de sequências gênicas ou estruturas modulares de proteínas, cuja ordenação pode ser crítica para otimizações computacionais em alinhamento, predição estrutural ou análise evolutiva.*

**Problema do Troco**:
Converter uma quantia de dinheiro M em determinadas denominações, utilizando o menor número possível de moedas.
**Entrada:** uma quantia de dinheiro M, e um vetor de **d** denominações **c = c1, c2, ..., c_d)**, em ordem crescente de valor (c1 > c2 > ... > c_d).
**Saída:** uma lista de **d** inteiros i1, i2, ..., i_d tal que c1.i1 + c2.i2 + ... + ... + c_d.i_d =M, e que i1 + i2 + ... + i_d seja o menor valor possível.
*Este tipo de otimização combinatória encontra aplicações diretas na bioinformática, como na montagem de genomas ou compressão de dados genômicos, onde o objetivo é minimizar o número de elementos utilizados sem perder a totalidade da informação.*

Podemos resolver esse problema com um pseudocódigo ainda mais imples e direto, com apenas cinco linhas, do que o algoritmo anterior:
```css
BETTERCHANGE(M, c, d)  
1    r ← M  
2    para k de 1 ate d  
3        i_k ← r / c_k  
4        r ← r − c_k · i_k  
5    retornar (i₁, i₂, ..., i_d)
```

Dizemos que um algoritmo é **correto** quando ele consegue traduzir toda instância de entrada na saída correta. Um algoritmo é considerado **incorreto** quando existe pelo menos uma instância de entrada para a qual ele não produz a saída correta. A princípio, isso pode parecer desproporcional: se o algoritmo falhar em apenas uma entrada, ele é classificado como incorreto. Isso reflete um pessimismo crítico, mas saudável, que deve ser mantido ao se projetar algoritmos: <span style="background:rgba(255, 183, 139, 0.55)">a menos que possamos justificar que um algoritmo sempre retorna os resultados corretos, devemos considerá-lo incorreto</span>.
*A exigência de correção total em algoritmos é paralela à validação de pipelines em bioinformática, onde uma única falha em dados experimentais pode comprometer interpretações biológicas inteiras, especialmente em estudos evolutivos de larga escola como filogenias baseadas em genomas*.

**BETTERCHANGE** não é um algoritmo correto. Suponha que desejamos trocar 40 centavos por moedas com as seguintes denominações: c1 = 25, c2 = 20, c3 = 10, c4 = 5 e c5 = 1. O algoritmo **BETTERCHANGE** retornaria incorretamente 1 moeda de 25 centavos, 1 de 10 centavos e 1 de 5 centavos, em vez de 2 moedas de 20 centavos. Por mais artificial que isso possa parecer, em 1875 existia uma moeda de vinte centavos nos Estados Unidos. Entre 1865 e 1889, o Tesouro Americano também produziu moedas de três centavos. Quão seguros podemos estar de que **BETTERCHANGE** retorna o número mínimo de moedas para a nossa moeda atual, ou para moedas estrangeiras? Determinar as condições sob as quais **BETTERCHANGE** é um algoritmo correto é deixado como um problema ao final deste capítulo.

Para corrigir o algoritmo **BETTERCHANGE**, poderíamos considerar todas as combinações possíveis de moedas com denominações c1, c2, ..., c_d que somem M, e retornar a combinação com o menor número de moedas. Não precisamos considerar combinações em que i1 > M /c1, ou 12 > M / c2(de forma geral, ik não deve exceder M /ck), pois o contrário, estaríamos retornando um valor estritamente maior que M.

O pseudocódigo abaixo utiliza o símbolo **∑** (sigma), significando soma:
**∑ᵢ₌₁ᵐ aᵢ = a₁ + a₂ + a₃ + ... + aₘ**.
O pseudocódigo também utiliza a noção de *infinito* (∞) como valor inicial para **menorNúmeroDeMoedas**. Existem várias formas de representar isso em um computador real, mas os detalhes não são importante aqui.

```r
BRUTEFORCECHANGE(M, c, d)
1    menorNúmeroDeMoedas ← ∞  
2    para cada (i₁, ..., i_d) de (0, ..., 0) até (M/c₁, ..., M/c_d)  
3            valorDasMoedas ← ∑ₖ₌₁ᵈ iₖ · cₖ  
4            se valorDasMoedas = M  
5                    númeroDeMoedas ← ∑ₖ₌₁ᵈ iₖ  
6                    se númeroDeMoedas < menorNúmeroDeMoedas  
7                            menorNúmeroDeMoedas ← númeroDeMoedas  
8                            melhorTroco ← (i₁, i₂, ..., i_d)  
9    retornar melhorTroco

```

*O uso de força bruta para explorar todas as combinações lembra abordagens exaustivas em bioinformática, como algoritmos par
a predição de estruturas secundárias de RNA ou busca de motivos em sequências. Embora custosa, essa abordagem garante completude e correção, critério essencial em inferências filogenéticas ou no mapeamento de variantes genéticas.*

## 2.5 Recursive Algorithms
A #recursão é um dos conceitos algorítmicos mais ubíquos. De forma simples, um algoritmo é #recursivo se ele chama a si mesmo. 

O quebra-cabeças das Torres de Hanói, introduzido em 1883 por um matemático francês, consiste em três estacas, que rotulamos da esquerda para a direita como 1, 2 e 3, e um certo número de discos de raios decrescentes, cada um com um orifício no centro. Inicialmente, os discos estão empilhados na estaca da esquerda (**estaca 1**), de modo que os discos menores fiquem sobre os maiores. O jogo é jogado movendo-se um disco por vez entre as estacas. Só é permitido colocar um disco menor sobre um disco maior, e qualquer disco pode ser movido para uma estaca vazia. O quebra cabeça é resolvido quando todos os discos forem movidos da estaca 1 para a estaca 3.
*A estrutura recursiva das Torres de Hanói espelha padrões em biologia molecular como o dobramento hierárquico de proteínas ou a replicação do DNA. Na bioinformática, algoritmos recursivos são fundamentais na análise de estruturas em árvores (como filogenias), onde subestruturas são resolvidas antes da estrutural global.*

****
**Towers of Hanoi Problem:**
Produza uma lista de movimento que resolva o quebra-cabeça das Torres de Hanói.

**Entrada:** um número inteiro n.
**Saída:** uma sequência de movimentos que solucionará o quebra-cabeças com **n** discos.

*Definir o problema com `n` discos é similar a parametrizar algoritmos de alinhamento de sequências por comprimento de input, mapeando recursivamente subproblemas de complexidade crescente.* 

Resolver o quebra-cabeça com um disco é trivial: mova o disco para o pino da direita. O desafio com dois discos não é muito maior: mova o disco menor para o pino do meio, depois o dico maior para o pino da direita e, por fim, o disco menor para o pino da direita, sobre o maior. O quebra-cabeça de três discos é um pouco mais complexo, mas a seguinte sequências de sete movimentos o resolve:
- Mover disco do pino 1 para o pino 3
- Mover disco do pino 1 para o pino 2
- Mover disco do pino 3 para o pino 2
- Mover disco do pino 1 para o pino 3
- Mover disco do pino 2 para o pino 1
- Mover disco do pino 2 para o pino 3
- Mover disco do pino 1 para o pino 3
*A solução de sete movimentos para três discos ilustra o crescimento exponencial de combinações, um desafio semelhante ao aumento de possibilidades em análise de variantes genômicas.*

Agora, vamos descobrir quantos passos são necessários para resolver um quebra-cabeça de quatro discos. Não é possível completar este jogo sem mover o disco de maior tamanho. No entanto, para mover o disco maior, primeiro precisamos mover todos os discos menores para um pino vazio.
*O padrão de deslocar  todos os discos menores antes de tocar no maior ecoa protocolos de pré-processamento em bioinformática, que isolam fragmentos pequenos de DNA antes de manipular estruturas genômicas de maior complexidade.*

Se tivéssemos quatro discos em vez de três, então primeiro teríamos que mover os três discos superiores para um pino vazio (7 movimentos), depois mover o disco maior (1 movimento), e por então novamente mover os três discos do pino temporário para repousar sobre o disco maior (outros 7 movimentos). O procedimento todo levará 7 + 1 + 7 = 15 movimentos.

*A sequência 7 + 1 + 7 destaca a progressão sistemática e sugere crescimento quase exponencial, similar ao aumento de combinações em análises de variantes de genoma de alto profundidade.*

De modo mais geral, para mover uma pilha de tamanho n do pino esquerdo para o pino direito, é preciso primeiro mover uma pilha de tamanho n -1 do pino esquerdo para o pino do meio, e então do pino do meio para o pino direito, depois de ter movido o enésimo disco para o pino direito. Para mover uma pilha de tamanho n - 1 do pino do meio para o pino direito, é preciso primeiro mover uma pilha de tamanho n - 2 do pino do meio para o pino esquerdo, depois mover o (n -1) ésimo disco para o pino direito, e então mover a pilha de n -2 do pino esquuerdo para o pino direito, e assim por diante.

*A formulação recursiva de T(n) = 2 T(n-1) + 1 reflete o princípio de subdivisão de problemas, análogo à programação dinâmica em alinhamentos de sequências, onde soluções ótimas usam resultados de subproblemas.*

À primeira vista, o problema das Torres de Hannoi parece difícil. No entanto, o seguinte algoritmo recursivo resolve o problema das Torres de Hannoi com n discos. A versão iterativa deste algoritmo é mais difícil de escrever e analisar.
```r
HANOITOWERS(n, fromPeg, toPeg)
1    if n = 1
2        output “Mover disco do pino fromPeg para o pino toPeg”
3        return
4    unusedPeg ← 6 − fromPeg − toPeg
5    HANOITOWERS(n − 1, fromPeg, unusedPeg)
6    output “Mover disco do pino fromPeg para o pino toPeg”
7    HANOITOWERS(n − 1, unusedPeg, toPeg)
8    return
```
Os parâmetros fromPeg, toPeg e unusedPeg referem-se aos três pinos de modo que `HANOITOWERS(n, 1, 3)` mova n discos do primeiro pino para o terceiro. A variável unusedPeg indica qual dos três pinos pode servir de destino temporário para os n−1 discos menores. Observe que fromPeg + toPeg + unusedPeg é sempre igual a 1 + 2 + 3 = 6, de modo que o valor de unusedPeg pode ser calculado como 6 − fromPeg − toPeg, conforme definido na linha 4 (veja a Tabela 2.1).

As instruções subsequentes (linhas 5–7) resolvem o subproblema menor de mover a pilha de tamanho n−1 primeiro ao pino temporário, depois mover o disco maior e, em seguida, mover os n−1 discos menores ao destino final. Note que não precisamos especificar qual disco mover: sempre é o disco do topo do pino fromPeg que é realocado.

Embora a solução seja expressa em apenas 8 linhas de pseudocódigo, ela demanda um tempo surpreendentemente longo para executar. Resolver uma torre de cinco discos requer 31 movimentos, mas resolver uma torre de cem discos exigiria mais movimentos do que o número de átomos no universo.
*O crescimento exponencial do número de chamadas reflete desafios de escalabilidade em simulações de dobramento de RNA, onde o espaço de configurações explode com o número de nucleotídeos.*

O rápido crescimento do número de movimentos que HANOITOWERS requer é fácil de visualizar: cada vez que chamamos HAOITOWERS(n, 1, 3), ela chama a si mesma duas vezes para n-1, o que por sua vez dispara quatro chamadas para n-2, e assim por diante. 

![[Capítulo 2 - Algorithms and Complexity-6.png]]

## 2.6 Iterative versus Recursive Algorithms
