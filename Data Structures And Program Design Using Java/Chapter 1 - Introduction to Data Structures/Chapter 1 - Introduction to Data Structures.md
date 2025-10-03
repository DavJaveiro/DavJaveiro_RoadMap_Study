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
A *linear data structure is one in which the data elements are stored in a linear, or sequential, order;* 