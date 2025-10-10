#flashcards/Estrutura-De-Dados
## Preface
Estrutura de dados são os blocos de construção da Ciência da Computação. O objetivo deste texto é enfatizar os fundamentos de estrutura de dados como um assunto introdutório. Ele é projetado para iniciantes que gostariam de aprender o básico de estrutura de dados e sua implementação usando a linguagem de programação Java. Com este foco em mente, apresentamos vários fundamentos do assunto, bem suportados com analogias do mundo real para permitir uma rápida compreensão dos conceitos técnicos e para ajudar a identificar estruturas de dados apropriadas para resolver problemas práticos e específicos.

Este livro servirá ao propósito de um livro-texto/livro de referência e será de imensa ajuda, especialmente para estudantes de graduação ou pós-graduação de vários cursos em tecnologia da informação, engenharia, aplicações computacionais e ciências da informação.

---
**Fala motivacional introdutória**: 
**Título do vídeo:** Por que aprender Estruturas de dados vai mudar a sua carreira?
As estruturas de dados são os *building blocks*, ou seja, os tijolos fundamentais de toda a Ciência da Computação. 

Geralmente, sempre nos fazemos aquela clássica pergunta, *mas afinal, onde eu vou isso na vida real?*. Por isso, nesse vídeo eu quero explicar para vocês não apenas o que são estruturas de dados, mas nos convencermos de que elas são extremamente importantes. 

Bom, então, podemos dizer que com uma base sólida em estrutura de dados, você começa:
1. A pensar como um Arquiteto de Software e para de ''programar no escuro'' :
	- **Sem estrutura de Dados:** você usa o que é mais fácil naquele momento (geralmente um array ou um list) para *qualquer* problema. O código vai funcionar, e num primeiro momento, não há nada de errado nisso. Mas com o tempo, com o aumento da demanda, o código se tornará lento, irá consumir bastante memória e será um pesadelo para dar manutenção. É como tentar construir uma casa usando apenas fita adesiva e madeira.
	- **Com estruturas de dados:** você faz perguntas inteligentes: "os dados precisam ser acessados rapidamente?" A ordem de acesso importa? Preciso de inserções frequentes? **auxiliará o leitor a desenvolver a capacidade de identificar a estrutura de dados mais apropriada e eficiente para resolver um problema real específico**
2. É o Maior "Abre Portas" para Empresas de Tecnologia (FAANG e Outras)/
	1. Isso é um fato. Praticamente 100% dos processos seletivos para vagas de engenharia de software, das grandes big techs às startups promissoras, têm uma etapa técnica focada em Estrutura de Dados e Algoritmos.
	2. Dominar esse assunto não é apenas uma habilidade técnica; é seu ingresso para essas entrevistas e fazer bonito, na hora. Isso mostra que você tem a base sólida para resolver problemas complexos, que é exatamente o que essas empresas buscam.

3. **Você escreve código "econômico", rápido e que gasta poucos recursos**.
	- Imagine seu aplicativo travando porque ficou lento com milhares de usuários (precisamos sempre pensar que a nossa solução vai escalar), que receberemos milhares de usuários ou sistemas consumindo nossa API, o seu servidor também pode custar uma fortuna na nuvem porque consome memória demais. Isso seria um desastre, é como começarmos com o pé esquerdo!
	- Escolher a **Estrutura de Dados** correta é a forma mais direta de **Otimizar** o sue código. Um sistema que processa um pedido em 1 segundo é bom; um que processa em 10 milissegundos é imbatível. E a diferença, muitas vezes, está na escolha entre um **ArrayList** e um **HashSet**, por exemplo. Você impacta diretamente na **performance** e #escalabilidade de sua aplicação.

4. **Você conseguirá resolver problemas do Mundo Real de forma Elegante**.

5. Você se tornará um Programador Mais Versátil e Independente da Linguagem.
	- As sintaxes mudam: um for em Java é diferente em Python ou Go. Mas uma Árvore Binária é uma Árvore Binária em *qualquer linguagem.*
	- O conceito é universal. Uma vez que você domina as estrutura de dados, você consegue aprender qualquer nova linguagem com muito mais facilidade, porque o raciocínio por trás já está internalizado. Sua base fica inquebrável.

**Aplicações Práticas:**
- Analogias do mundo real como aplicações práticas são fornecidas ao longo do texto para uma compreensão rápida e para conectar os fundamentos das estruturas de dados com cenários do dia a dia. Essa abordagem, por sua vez, **auxiliará o leitor a desenvolver a capacidade de identificar a estrutura de dados mais apropriada e eficiente para resolver um problema real específico**. 

**Algoritmos e Programas:** para entender melhor os fundamentos das estruturas de dados em um nível genérico, seguido por sua implementação orientada a objetos em Java, algoritmos independentes de sintaxe, bem como programas implementados em Java, são discutidos ao longo da jornada. Esta apresentação auxiliará o leitor a encontrar tanto os algoritmos quanto sua implementação correspondente em um único livro.

**Exercício Numéricos e Conceituais:** para ajudar o leitor a desenvolver uma base sólida sobre o assunto, vários problemas numéricos e conceituais são incluídos ao longo do texto.

**Questões de Múltipla Escolha (MCQ)**: para nos auxiliarmos em exames voltados para colocação profissional em várias áreas de TI, diversos exercícios são selecionados adequadamente e fornecidos em formato de múltipla escolha, eu irei compilar essa lista de exercício com base em todo o mundo que eu consultei para montar essa aula, o conteúdo estará disponibilizado em minha conta do github. 


---
## Chapter 1 - Introduction to Data Structures
### 1.1 Introdução
Uma estrutura de dados é uma forma eficiente de armazenar elementos de dados na memória do computador. Dado significa um valor ou um conjunto de valores. Estrutura refere-se a um método de organizar os dados. A representação matemática ou lógica dos dados na memória é denominada estrutura de dados. 

O objetivo de uma estrutura de dados é armazenar, recuperar e atualizar os dados de forma eficiente. Uma estrutura de dados pode ser definida como elementos agrupados sob um mesmo nome. Os elementos de dados são chamados de **membros** e podem ser de tipos diferentes. As estruturas de dados são usadas em quase todos os **programas** e **sistemas de software**. 

Existem vários tipos de estruturas de dados adequadas para diferentes tipos de aplicações. As estruturas de dados são os blocos de construção de um programa. Para que um programa seja executado com eficiência, um **programador** deve escolher as estruturas de dados apropriadas. Uma estrutura de dados é uma parte crucial do **gerenciamento de dados**. Como o nome sugere, o gerenciamento de dados é uma tarefa que inclui diferentes atividades, como a coleta de dados, a organização de dados em estruturas e muito mais. Alguns exemplos de estruturas de dados utilizadas incluem **stacks**, **queus**, **arrays**, **binary trees**, **linked lists**, **hash tables**, entre outras.

Uma estrutura de dados nos ajuda a entender a relação de um elemento com outro e a organizá-lo dentro da memória. É uma representação matemática ou lógica, ou uma organização dos dados na memória. As estruturas de dados são amplamente aplicadas nas seguintes áreas:
- Compiler Design
- Database Management Systems (DBMS)
- Artificial Intelligence
- Network and Numerical Analisys
- Statistical Analysis Packages
- Graphics
- Operating Systems (OS)
- Simulations

Como vemos na lista anterior, há muitas aplicações nas quais diferentes estruturas de dados são usadas para suas operações. A**lgumas estruturas de dados sacrificam a velocidade para uma utilização eficiente na memória, enquanto outras sacrificam a utilização da memória e resultam em maior velocidade**. No mundo de hoje, os programadores visam não apenas construir um programa, mas sim construir um rograma eficaz. COmo discutido anteriormente, para que um programa seja eficiente, um programador deve escolher estruturas de dados apropriadas. Portanto, as estruturas de dados são classificadas em vários tipos. Portanto, vamos aprender sobre os diferentes tipos de estrutura de dados.

**Defina uma estrutura de dados (pare, pense, e reescreva o que entendeu sobre estrutura de dados):**
uma estrutura de dados busca relacionar e armazenar os dados ou valores, na memória com um determinado propósito, buscando eficiência (garantia de persistência) ou velocidade (operação), de acordo com as necessidades da aplicação através das mais diversas atividades que o sistema pode efetuar sobre os elementos (membros) presentes nos dados, seja uma busca, inserção dos dados, deleção ou atualização. Portanto, é um modelo lógica ou matemático de uma organização específica sobre os dados. 


**Relação entre:**
Matemática Discreta -> Estrutura de Dados -> Programação

**Como cada tópico da Matemática Discreta Sustenta as Estruturas de Dados:**
1. **Teoria dos Conjuntos** - Arrays, Lists, Sets
	- Um array é essencialmente um conjunto ordenado de elementos
	- Operações de união, interseção são a base para estruturas como HashSet, por exemplo...
2. **Lógica Matemática -** Condições e Algoritmos
	- Todas as condições if/else, loops while usam lógica proposicional.
	- A verificação de limites em Arrays e listas depende de predicados lógicos.
3. **Teoria dos Grafos - Graph, Tree, Linked List**
	- Uma **Linked List** é um caso especial de grafo;
	- **Árvores Binárias** são grafos acíclicos direcionados
	- Algoritmos de Busca (BFS/DFS) vêm diretamente da teoria dos grafos.
4. **Combinatória - Análise de Complexidade**
	- Calcular quantas operações um algoritmo executa
	- Analisar casos médios e piores cenários

5. **Relações -> Hash Tables, Databases**
	1. Tabelas hash mapeiam chaves para valores através de relações
	2. Bancos de dados usam relações para organizar dados

- Sem Matemática Discreta: você decora código sem entender o "porquê";
- Com Matemática Discreta: você entende quando e porque usar cada estrutura:
	- Por que um HashTable tem busca O(1)?
	- Por que um **Binary Search Tree** mantém ordem?
	- Como grafos modelam redes sociais?

### 1.2 Types of Data Structures
Data structures are classified into various types.
### 1.2.1 Linear and Non-Linear Data Strucutres
Uma estrutura de dados linear é aquela na qual os elementos de dados são armazenados em uma <span style="background:#affad1">ordem linear ou sequencial</span>; ou seja, os dados são armazenados em locais de memória consecutivos. Uma estrutura de dados linear pode ser representada de duas maneiras:  ou é representada por uma relação linear entre vários elementos utilizando locais de memória consecutivos, como no caso de *arrays*, pode ser representada por uma relação linear entre os elementos utilizando links de um elemento para outro, como no caso de *linked lists*. Exemplos de estruturas de dados lineares incluem *arrays, linked lists, stacks, queues* e assim por diante.

Uma estrutura de dados não linear é aquela na qual os dados não são armazenados em qualquer ordem sequencial ou locais na memória consecutivos. Os elementos de dados nesta estrutura são representados por uma ordem hierárquica. Exemplos de estrutura de dados não lineares incluem graphs, trees e assim por diante.

### 1.2.2 Estruturas de Dados Estáticas e Dinâmicas
Uma estrutura de dados estática é uma coleção de dados na memória cujo tamanho é fixo e não pode ser alterado durante o *runtime*. O tamanho da memória deve ser conhecido antecipadamente, pois a memória não pode ser realocada posteriormente em um programa. Um exemplo é um *array*.

Uma estrutura de dados dinâmica é uma coleção de dados na qual a memória pode ser realocada durante a execução do programa, *run time*. O programador pode adicionar ou remover elementos de acordo com sua necessidade. Exemplos incluem *linked lists, graphs, trees* e assim por diante.

### 1.2.3 Estruturas de Dados Homogêneas e Não Homogêneas
Uma estrutura de dados homogênea é aquela que contém elementos de dados do mesmo tipo, por exemplo, *arrays*. 

Uma estrutura de dados <span style="background:#affad1">não homogênea</span> contém elementos de dados de diferentes tipos, por exemplo, *structures*.

### 1.2.4 Estruturas de Dados Primitivas e Não Primitivas
Estrutura de dados primitivas são estruturas de dados fundamentais ou predefinidas, que são suportadas por uma linguagem de programação. Exemplos de tipos de estrutura de dados primitivos são *integer*, *float*, *char* e assim por diante.

Estruturas de dados não primitivas são estruturas de dados comparativamente mais complicadas, que são criadas usando estruturas de dados primitivas. Exemplos de estruturas de dados não primitivas *arrays*, *files*, *linked lists*, *stacks*, *queues* e assim por diante.

![image-2025108217817.png](image-2025108217817.png)

**Qual a diferença entre estruturas de dados primitivas e não primitivas**
?
Estruturas de dados primitivas são operadas diretamente por instruções de nível de máquina, ou seja, os tipos de dados fundamentais, como *int*, *float*, *char* e assim por diante.
**Estruturas de dados não primitivas:** são todas as estruturas de dados que não são fundamentais, mas usamos as estruturas fundamentais para criá-las.

**Qual a diferença entre estruturas de dados lineares e não lineares?**
1. Estruturas lineares permitem acesso aleatório aos elementos, enquanto as não lineares exigem acesso sequencial.
2. Estruturas lineares organizam os dados em sequência, enquanto as não lineares conectam elementos com múltiplas relações.
3. Estruturas lineares são usadas apenas em bancos de dados, enquanto as não lineares são exclusivas de algoritmos de busca.
4. Estruturas lineares ocupam mais memória que as não lineares.
5. Estruturas não lineares são mais fáceis de implementar na memória do computador do que as lineares.
?
**2. Estruturas lineares organizam os dados em sequência, enquanto as não lineares conectam elementos com múltiplas relações.**
<!--SR:!2025-10-11,3,250-->


### 1.2.5 Arrays
Um #Array é uma coleção de elementos de dados homogêneos (do mesmo tipo) em memória contígua. Um *array* é uma estrutura de dados linear, porque todos os elementos de um *array* são armazenados em uma ordem linear. Os vários elementos do *array* são referenciados pelo seu valor de índice, também conhecido como #subscript. Em Java, um array é declarado usando a seguinte sintaxe;
```java
<data type> name_of_array [lenght]
```
Os elementos são armazenados no array conforme mostrado na Figura 1.2:
![image-2025108483323.png](image-2025108483323.png)

*Arrays* são usados para armazenar uma grande quantidade de dados de tipo semelhante. Eles têm várias vantagens e limitações.

**Vantagens de usar arrays**
1. Os elementos são armazenados em locais de memória adjacentes; portanto, a busca é muito rápida, pois qualquer elemento pode ser acessado facilmente.
2. *Arrays* não suportam alocação dinâmica de memória, portanto, todo o gerenciamento de memória é feito pelo compilador.

**Limitações de se utilizar arrays**
1. A inserção e a exclusão de elementos em *arrays* são complicadas e consome muito tempo, pois requer o deslocamento dos elementos.
2. Arrays são estáticos; portanto, o tamanho deve ser conhecido antecipadamente.
3. Os elementos no *array* são armazenados em locais de memória consecutivos, que podem ou não estar disponíveis.

### 1.2.6 Queues
Uma fila é uma coleção linear de elementos de dados na qual o elemento inserido primeiro será o elemento removido primeiro; ou seja, uma fila é uma estrutura de dados #FIFO (First in First Out) - primeiro a entrar, primeiro a sair. Uma fila é uma estrutura de dados linear popular na qual o primeiro elemento é inserido a partir de uma extremidade chamada REAR, e a remoção pode ocorrer a partir da outra extremidade chamada #FRONT.

**Aplicação prática**
Para uma ilustração simples de uma queue, imagine uma fila de pessoas paradas no ponto de ônibus esperando pelo ônibus. Portanto, a primeira pessoa na fila entrará no ônibus primeiro. 

Na memória do computador, as filas podem ser implementadas usando *arrays* ou *linked lists*. 
![image-20251085830901.png](image-20251085830901.png)

### 1.2.7 Stack (pilhas)
Uma pilha é uma coleção linear de elementos de dados na qual a inserção e a exclusão ocorrem apenas no topo da pilha. Uma pilha é uma estrutura de dados LIFO (Last in First Out) - último a entrar, primeiro a sair, porque o último elemento inserido na pilha será o primeiro elemento a ser removido dela. As três operações que podem ser realizadas na pilha incluem as operações **PUSH**, **POP** e **PEEP**.

A operação **PUSH** insere um elemento ao topo da pilha, enquanto a POP remove um elemento da pilha. A operação PEEP retorna o valor do elemento do topo da pilha sem removê-lo. Toda pilha tem uma variável TOP associada a ela. O nó TOP armazena o endereço do elemento mais superior na pilha. O TOP é a posição onde a inserção e a exclusão ocorrem.

**Aplicação Prática**
Um exemplo da vida real de uma pilha é uma pilha de pratos arrumados em uma mesa. Uma pessoa pegará o primeiro prato do topo da pilha.

Na memória do computador, as pilhas podem ser implementadas usando arrays ou linkedLists.
```java
Stack<String> pilha = new Stack<>();

// Add elements (push)
pilha.push("A");
pilha.push("B");
pilha.push("C");

// Remove o topo (pop)
Sout("Removido: " + pilha.pop());

// Verifica se está vazia
System.out.println("Está vazia? " + pilha.isEmpty());
```
![image-2025108616256.png](image-2025108616256.png)

### 1.2.8 Linked Lists
A principal desvantagem do *array* é que o tamanho ou o número de elementos deve ser conhecido antecipadamente. Assim, essa desvantagem deu origem ao novo conceito de *linked list* (lista encadeada). Uma *linked list* é uma coleção linear de elementos de dados. Esses elementos de dados são chamados de *nodes*, e cada nó armazena o endereço do próximo nó.

Um linked list é uma sequência de nós na qual cada nó contém um ou mais campos de dados e um campo de endereço que armazena o endereço do próximo nó. Além disso, as *linked lists* são dinâmicas; ou seja, a memória é alocada conforme a necessidade. 

Na figura anterior, uma linked list na qual cada nó é dividido em dois espaços:
![image-20251081915541.png](image-20251081915541.png)

1. O primeiro espaço contém a informação/dado.
2. O segundo espaço contém o endereço do próximo nó.

**Aplicação Prática**
Um exemplo simples da vida real é um trem; aqui cada vagão está conectado ao seu vagão anterior e seguinte (exceto o primeiro e o último vagão).

A parte de endereço do último nó armazena um valor especial chamado Null, que denota o fim da *linked list*. A vantagem de uma *linked list* sobre arrays é que agora é mais fácil inserir e excluir elementos de dados, pois não precisamos fazer deslocamentos a cada vez. No entanto, a busca por um elemento tornou-se mais difícil. Além disso, é necessário mais tempo para buscar um elemento, e também requer alto espaço na memória. Portanto, as *linked lists* são usadas onde uma coleção de elementos de dados é necessária, mas o número de elementos de dados na coleção não nos é conhecido antecipadamente.

### 1.2.9 Trees
Uma tree (árvore) é uma estrutura de dados não linear popular na qual os elementos de dados ou os *nodes* (nós) são representados em uma ordem hierárquica.  Aqui, um dos nós é mostrado como o **root node** (nós raiz) da árvore, e os nós restantes são particionados em dois conjuntos disjuntos, de modo que cada conjunto é parte de uma subtree (subárvore). Uma árvore torna o processo de busca muito fácil e sua programação recursiva torna um programa otimizado e fácil de entender. 

Uma **binary tree** (árvore binária) é a forma mais simples de uma árvore. Uma árvore binária consiste em um nó raiz e duas subárvores conhecidas como **left subtree** (subárvore esquerda) e **right subtree** (subárvore direita), onde ambas as subárvores também são árvores binárias. Cada nó em uma árvore consiste em três partes, ou seja, a parte extrema esquerda armazena o endereço da subárea esquerda, a parte do meio consiste no elemento de dados e a parte extrema direita armazena o endereço da subárvore direita. A raiz é o elemento mais superior da árvore. Quando não há nós em uma árvore, ou seja, quando **ROOT = NULL**, isso é chamado de árvore vazia.

Por exemplo, considere uma árvore binária onde R é o nó raiz da árvore. LEFT e RIGHT são as subárvores esquerda e direita de R, respectivamente. O nó A é designado como o nó raiz da árvore. Os nós B e C são os filhos  esquerdo e direito de A, respectivamente. Os nós B, D, E e G constituem a subárvore esquerda da raiz. Da mesma forma, os nós C, F, H e I constituem a subárvore direita da raiz. 

**Vantagens de uma árvore**
1. O processo de busca é muito rápido em ávores.
2. A inserção e a exclusão dos elementos tornaram-se mais fáceis em comparação com outras estruturas de dados. 

Defina corretamente o termo **árvore binária (binary tree)**.
**A)** Uma árvore binária é uma estrutura de dados onde cada nó pode ter um número ilimitado de filhos, e os dados são organizados de forma linear.
**B)** Uma árvore binária é uma estrutura de dados hierárquica na qual cada nó tem no máximo **dois filhos**, denominados **filho esquerdo** e **filho direito**.
**C)** Uma árvore binária é uma estrutura que armazena elementos em sequência, permitindo acesso direto por índice.
**D)** Uma árvore binária é uma lista encadeada especial onde cada nó aponta para vários nós filhos sem restrição de quantidade.
?

### 1.2.10 Graphs
Um graph (grafo) é uma árvore geral sem uma relação pai-filho definida. É uma estrutura de dados não linear que consiste em vértices (vértices), também chamados de nodes, e edges (arestras) que conectam esses vértices. Em um grafo, pode existir qualquer tipo de relação complexa. Um grafo G pode ser definido como um conjunto finito de V vértices e E arestras. Portanto, G = (V, E), onde V é o conjunto  de vértices e E é o conjunto de arestras. Os grafos são usados em várias aplicações da matemática e da ciência da computação. 

Diferente de um nó raiz em árvores, os grafos não têm nós raiz; em vez disso, os nós podem ser conectados a qualquer outro nó no grafo. Dois nós são denominados neighbors (vizinhos) quando estão conectado por meio de uma aresta.

Um exemplo real de um grafo pode ser visto em estações de trabalho onde vários computadores são conectados uns aos outros por meio de conexões de rede.

## 1.3 Operations on Data Structures
- **Criação**: é o processo de criar uma estrutura de dados. A declaração e inicialização da estrutura de dados são feitas aqui. É a primeira operação.
- **Inserção**: é o processo de adicionar novos elementos de dados na estrutura de dados. Por exemplo, adicionar os detalhes de um funcionário que recentemente ingressou em uma organização.
- **Exclusão:** é o processo de remover um elemento de dados específico da coleção fornecida de elementos de dados. Por exemplo, remover o nome de um funcionário que deixou a empresa.
- **Atualização:** é o processo de modificar os elementos de dados de uma estrutura de dados. Por exemplo, se o endereço de um aluno é alterado, então ele deve ser atualizado.
- **Busca:** é usada para encontrar a localização de um elemento de dados específico ou de todos os elementos de dados com a ajuda de uma chave fornecida. 
- **Ordenação:** é o processo de organizar os elementos de dados em alguma ordem, ou seja, em ordem crescente ou decrescente. Um exemplo é organizar os nomes dos alunos de uma classe em ordem alfabética.
- **Mesclagem:** é o processo de combinar os elementos de dados de duas listas diferentes para formar uma única lista de elementos de dados.
- **Travessia:** é o processo de acessar cada elemento de dados exatamente uma vez para que ele possa ser processado. Um exemplo é imprimir os nomes de todos os alunos de uma classe.
- **Destruição:** é o processo de excluir toda a estrutura de dados. É a última operação na estrutura de dados. 

## 1.4 Algorithms
Um algoritmo é um conjunto sistemático de instruções combinadas para resolver um problema complexo. É uma sequência finita e passo a passo de instruções, cada uma das quais tem um significado claro e pode ser executada com um mínimo de esforço em um tempo finito. Em geral, um algoritmo é um projeto (blueprint) para escrever um programa a fim de resolver o problema. Uma vez que temos um projeto da solução, podemos implementá-lo facilmente em qualquer linguagem de alto nível como C, C++, Java e assim por diante. Ele resolve o problema em um número finito de etapas. Um algoritmo escrito em uma linguagem de programação é conhecido como um programa. Um computador é uma máquina sem cérebro ou inteligência. Portanto, o computador deve ser instruído a executar uma determinada tarefa em etapas não ambíguas. Por conseguinte, um programador deve definir seu problema na forma de um algoritmo escrito em inglês. Assim, tal algortimo deve ter as seguintes características:
1. Um algoritmo deve ser simples e conciso;
2. Deve ser eficiente e eficaz
3. Deve estar livre de ambiguidades; ou seja, a lógica deve ser clara.

Da mesma forma, um algoritmo deve ter as seguintes características:
- **Entrada (Input)**: lê os dados do problema dado.
- **Saída (Output)**: o resultado desejado deve ser produzido
- **Processo/Definitividade**: cada etapa ou instrução deve ser inequívoca.
- **Efetividade (Effectiveness):** cada etapa deve ser precisa e concisa. O resultado desejado deve ser produzido dentro de um tempo finito.
- **Finitude (Finiteness):** o número de etapas deve ser finito.

## 1.5 Approaches for Designing an Algorithm
Um algoritmo complexo é dividido em unidades menores, que são chamados de **módulos**. Em seguida, esses módulos são divididos em submódulos. Dessa forma, um algoritmo complexo pode ser resolvido com facilidade. O processo de dividir um algoritmo em módulos é chamado de modularização. Existem duas abordagens populares para projetar um algoritmo:
- Abordagem Top-Down (de cima para baixo)
- Abordagem Bottom-Up (de baixo para cima)

Agora, vamos entender ambas as abordagens.

**1. Abordagem Top-Down (de cima para baixo)**: uma abordagem *top-down* afirma que o problema/algoritmo complexo/complicado deve ser dividido em módulos menores. Esses módulos menores são então divididos em submódulos. Este processo de decomposição é repetido até atingirmos a complexidade de módulo desejada para o resultado. Uma abordagem *top-down* começa a partir do módulo de nível mais alto, e os módulos são incrementados correspondentemente até que seja alcançado um nível onde não são necessários mais submódulos, ou seja, quando o nível desejado de complexidade é atingido.
![image-2025109166945.png](image-2025109166945.png)

**2. Bottom-Up**: uma abordagem de design de algoritmo *bottom-up* é o oposto da abordagem *top-down*. Neste tipo de abordagem, começamos primeiro projetando os módulos básicos e prosseguimos em direção ao design de módulos de nível mais alto. Os submódulos são agrupados para formar um módulo de um nível superior. Da mesma forma, todos os módulos de alto nível são agrupados para formar módulos ainda mais complexos. Assim, este processo de combinar os submódulos é repetido até obtermos o resultado desejado do algoritmo.

## 1.6 Analyzing an Algorithm
Um algoritmo pode ser analisado por dois fatores: **espaço e tempo**. Nosso objetivo é desenvolver um algoritmo que faça o melhor uso desses dois recursos. Analisar um algoritmo mede a sua eficiência. A eficiência do algoritmo é medida em termos de velocidade e complexidade de tempo.

A **complexidade** de um algoritmo é uma função que mede o espaço e o tempo utilizados por um algoritmo em função do tamanho da entrada.

- **Complexidade de Tempo:** a complexidade de tempo de um algoritmo é a **quantidade de tempo necessária para executar o programa completamente**. É o tempo de execução do programa. A complexidade de tempo é comumente representada pela notação Big O. Por exemplo, a complexidade de tempo de uma busca linear é O(n).
- **Complexidade de Espaço:** a complexidade de espaço de um algoritmo é a quantidade de espaço de memória necessária para executar o programa completamente. A complexidade de espaço de um algoritmo também depende do tamanho da entrada.

A complexidade de tempo é categorizada em três tipos:
1. **Melhor Tempo de Execução (Best-Case):** o desempenho do algoritmo será o melhor sob condições ótimas. Por exemplo, o melhor caso para uma busca binária ocorre quando o elemento desejado é o elemento do meio da lista. Outro exemplo pode ser a ordenação; ou seja, se os elementos já estão ordenados em uma lista, então o algoritmo será executado no melhor tempo.
2. **Caso Médio de Execução (Average-Case):** denota o comportamento de um algoritmo quando a entrada é retirada aleatoriamente de uma determinada coleção ou distribuição. É uma estimativa do tempo de execução para uma entrada *média*. Geralmente assume-se que todas as entradas de um determinado tamanho são igualmente prováveis de ocorrer.

3. Pior Tempo de Execução (Worst-Case): o comportamento do algoritmo neste caso refere-se ao pior cenário possível de instância de entrada. O tempo de execução do pior caso de um algoritmo é um limite superior para o tempo de execução de qualquer entrada. Por exemplo, o pior caso para uma busca linear ocorre quando o elemento desejado é o último elemento da lista ou quando o elemento não existe na lista.

### 1.6.1 Time-Space Trade-Off
Na ciência da computação, o *trade-off* tempo-espaço é uma forma de resolver um problema específico usando menos tempo e mais espaço de memória, ou mais tempo e menos espaço de memória. Mas, falando em termos práticos, projetar um algoritmo no qual seja possível economizar tanto espaço quanto tempo é uma tarefa desafiadora. Portanto, podemos usar mais de um algoritmo para resolver um problema. Um pode requerer menos tempo, e o outro pode requerer menos espaço de memória para ser executado. Dessa forma, sacrificamos uma coisa pela outra. Portanto, existe um *trade-off* tempo-espaço ou tempo-memória entre os algoritmos.

Assim, esse *trade-off* tempo-espaço oferece ao programador uma escolha racional a partir de um ponto de vista informado. Então, se o tempo é uma grande preocupação para um programador, ele pode escolher um programa que leve menos ou o mínimo de tempo para ser executado. Por outro lado, se o espaço é a principal preocupação para um programador, então, nesse caso, ele pode escolher um programa que ocupe  menos espaço de memória para ser executado, ao custo de mais tempo.

## 1.8 Notação Big O
O desempenho de um algoritmo, ou seja, seus requisitos de tempo e espaço, pode ser facilmente comparado com outros algoritmos concorrentes usando notações assintóticas, como a notação Big O, a notação Omega e a notação Theta.

A complexidade algorítmica pode ser facilmente aproximada usando notações assintóticas, simplesmente ignorando os fatores dependentes da implementação. Por exemplo, podemos comparar vários algoritmos de ordenação disponíveis usando a notação Big O ou qualquer outra notação assintótica.

A notação Big O é um dos esquemas de caracterização de análise mais populares, pois fornece um limite superior para a complexidade de um algoritmo. Em Big O, O(g) é representativo da classe de todas as funções que crescem não mais rápido que *g*. Portanto, se f(n) = O(g(n)), então, f(n) <= c* g(n) para todo n > n0, onde n- representa um limiar e c representa uma constante.

- Um algoritmo com complexidade O(1) é denominado algoritmo de tempo de computação costante.
- Um algoritmo de complexidade O(n) é denominado algoritmo linear.
- O(n²) para algoritmos quadráticos
- O(2^n) para algoritmos de tempo exponencial
- O (n<sup>k</sup>) para algoritmos de tempo polinomial
- O (log n) para algoritmos de tempo logarítmico.

Um algoritmo com complexidade da ordem de **O(log₂n)** é considerado um dos melhores algoritmos, enquanto um algoritmo com complexidade da ordem de **O(2ⁿ)** é considerado o pior algoritmo. A complexidade das computações ou o número de iterações necessárias em vários tipos de funções pode ser comparada da seguinte forma:

**O(log₂n) < O(n) < O(n log₂n) < O(n²) < O(n³) < O(2ⁿ)**
