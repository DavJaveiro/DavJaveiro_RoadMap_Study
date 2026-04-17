# Cronograma de 3 anos — LeetCode em Java + Effective Java + CLRS + Data Structures: Abstraction and Design in Java

> Versão refeita para **36 meses / 156 semanas**, em formato de Markdown para Obsidian, com checkboxes e trilhas de revisão.

## Como este plano foi montado
- prioriza **Java** como linguagem de implementação;
- cruza os três livros em vez de estudar cada um isoladamente;
- coloca **LeetCode por padrão / tema**, não por dificuldade solta;
- mistura **teoria, implementação, teste, revisão e mock**;
- usa repetição espaçada: os temas voltam no Ano 3 em ciclos de revisão.

## Resultado esperado ao final
- [ ] Resolver com confiança os padrões centrais de entrevista em Java
- [ ] Ter biblioteca própria de templates (`arrays`, `graph`, `dp`, `design`, `bit`, etc.)
- [ ] Entender o **porquê** das soluções, não apenas decorar
- [ ] Conseguir justificar complexidade, trade-offs e estrutura de dados
- [ ] Chegar ao fim com um repositório/segundo cérebro no Obsidian organizado

## Regras do plano
- [ ] Não pule a leitura teórica
- [ ] Não resolva problema sem anotar padrão
- [ ] Sempre registrar complexidade de tempo e espaço
- [ ] Refazer problemas errados em 24h / 7d / 30d
- [ ] A cada trimestre, revisar os pontos fracos antes de avançar

## Mapa macro de 3 anos

### Ano 1 — Q1 — Fundamentos de Java, ADTs e análise inicial
- Temas-base: Java core + Effective Java, Arrays + Hashing, Testes + exceções, DSA geral / trilhas-base

### Ano 1 — Q2 — Listas ligadas, iteradores, stack, queue, deque e recursão
- Temas-base: Linked Lists, Stack + Queue + Deque, Binary Search + Recursão + Backtracking, Testes + exceções

### Ano 1 — Q3 — Árvores, heaps, BST, hashing e começo forte de Java generics/streams
- Temas-base: Genéricos, Lambdas + Streams, Trees + Heaps + balanced trees, Arrays + Hashing

### Ano 1 — Q4 — Sorting, divide and conquer, binary search patterns, intervals e revisão do Ano 1
- Temas-base: Sorting + Divide and Conquer, Binary Search + Recursão + Backtracking, Arrays + Hashing, Design de estruturas + entrevista

### Ano 2 — Q5 — Balanced trees, B-trees, skip-lists e grafos I
- Temas-base: Trees + Heaps + balanced trees, Grafos, DSA geral / trilhas-base, Design de estruturas + entrevista

### Ano 2 — Q6 — Grafos II, shortest paths, MST, DSU, tries e teoria avançada de estruturas
- Temas-base: Grafos, Strings + Math + Bit, Dynamic Programming + Greedy, DSA geral / trilhas-base

### Ano 2 — Q7 — Dynamic Programming, greedy, matemática, bits e strings clássicas
- Temas-base: Dynamic Programming + Greedy, Strings + Math + Bit, Design de estruturas + entrevista, DSA geral / trilhas-base

### Ano 2 — Q8 — Geometria, NP-complete, aproximação, design de estruturas e Java avançado
- Temas-base: Design de estruturas + entrevista, Concorrência, Serialização, Strings + Math + Bit

### Ano 3 — Q9 — Ano 3 — oficialização via listas curadas e revisão espiral I
- Temas-base: Design de estruturas + entrevista, Arrays + Hashing, Linked Lists, Trees + Heaps + balanced trees, Grafos, Dynamic Programming + Greedy

### Ano 3 — Q10 — Top Interview 150, NeetCode 150 e repertório avançado de entrevista
- Temas-base: Design de estruturas + entrevista, Grafos, Dynamic Programming + Greedy, Strings + Math + Bit

### Ano 3 — Q11 — Mocks, timed sets, hard patterns e preparação real de entrevista
- Temas-base: Design de estruturas + entrevista, Grafos, Dynamic Programming + Greedy, Concorrência

### Ano 3 — Q12 — Fechamento dos 3 anos, capstone, biblioteca Java e revisão final
- Temas-base: Design de estruturas + entrevista, DSA geral / trilhas-base, Java core + Effective Java


## Matriz de cobertura dos livros

### Effective Java
- O cronograma distribui os **90 itens** ao longo dos anos 1 e 2, com revisões recorrentes no ano 3.
- Blocos mais pesados:
  - semanas 1–13: objetos, classes, interfaces, mutabilidade, `equals`/`hashCode`
  - semanas 14–26: genéricos, enums, anotações
  - semanas 27–39: lambdas, streams, métodos
  - semanas 40–52: programação geral e exceções
  - semanas 53–78: concorrência
  - semanas 66–92: serialização e revisões finais

### Data Structures: Abstraction and Design Using Java
- Apêndice A + capítulos 1–10 entram fortemente do ano 1 ao começo do ano 2.
- O plano usa:
  - fundamentos Java e OOP
  - listas, iteradores e Collections Framework
  - testes e debugging
  - stack, queue, deque
  - recursão e backtracking
  - trees, BST, heap, Huffman
  - sets, maps, hashing, skip-lists
  - sorting
  - balanced trees
  - graphs

### CLRS / Algoritmos: Teoria e Prática
- O CLRS é usado em três camadas:
  1. **camada de prova e análise** — notação assintótica, recorrências, probabilístico, amortizada;
  2. **camada de algoritmo clássico** — heaps, quicksort, hashing, BST, red-black, DP, greedy, graphs;
  3. **camada de repertório avançado** — B-trees, Fibonacci heaps, van Emde Boas, all-pairs shortest paths, max-flow, KMP, NP-complete, aproximação.

## Ritmo semanal sugerido
- **Segunda:** leitura teórica + nota em Obsidian
- **Terça:** implementação em Java do zero
- **Quarta:** 2 problemas LeetCode
- **Quinta:** 2 problemas LeetCode + revisão da solução
- **Sexta:** teste / refatoração / PR local
- **Sábado:** revisão espaçada ou mock curto
- **Domingo:** descanso, flashcards ou releitura leve

## Template de nota por problema (Obsidian)
```markdown
# [LC-XXXX] Nome do problema

## Tema
- 

## Padrão
- 

## Minha primeira ideia
- 

## Solução ótima
- 

## Complexidade
- Tempo:
- Espaço:

## Armadilhas
- 

## Código Java
- 

## O que revisar depois
- 
```

## Catálogo de recursos por tema

> Use os recursos abaixo como material-base da semana. Nos blocos semanais eu referencio o tema, não repito todos os links.

### Java core + Effective Java
**Vídeos**
- [Joshua Bloch — Effective Java, Third Edition: Keepin' it Effective](https://www.youtube.com/watch?v=7qXfoZIqi2Q)
- [Princeton / Sedgewick — Programming and Data Structures lecture 1](https://www.youtube.com/watch?v=hZi5aEG9z8U)

**Artigos / guias**
- [Oracle Java Tutorials — Learning Paths](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)
- [Martin Fowler — Inversion of Control Containers and the Dependency Injection pattern](https://martinfowler.com/articles/injection.html)

### Testes + exceções
**Vídeos**
- [Joshua Bloch — Keepin' it Effective (revisar partes de exceções e API design)](https://www.youtube.com/watch?v=7qXfoZIqi2Q)
- [Princeton / Sedgewick — debugging e disciplina de implementação](https://www.youtube.com/watch?v=hZi5aEG9z8U)

**Artigos / guias**
- [JUnit 5 User Guide](https://docs.junit.org/5.10.2/user-guide/index.html)
- [Oracle — Lesson: Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [Oracle — try-with-resources](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)

### Genéricos
**Vídeos**
- [Joshua Bloch — Keepin' it Effective (itens sobre API e generics)](https://www.youtube.com/watch?v=7qXfoZIqi2Q)
- [Java generics overview (playlist search landing)](https://www.youtube.com/playlist?list=PLFD341F6E5D654F92)

**Artigos / guias**
- [Oracle — Generic Methods and Bounded Type Parameters](https://docs.oracle.com/javase/tutorial/java/generics/boundedTypeParams.html)
- [Oracle — Wildcards](https://docs.oracle.com/javase/tutorial/java/generics/wildcards.html)
- [Oracle — Upper Bounded Wildcards](https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html)
- [Oracle — Lower Bounded Wildcards](https://docs.oracle.com/javase/tutorial/java/generics/lowerBounded.html)

### Lambdas + Streams
**Vídeos**
- [Venkat Subramaniam — Functional Programming with Java 8](https://www.youtube.com/watch?v=15X0qFtBqiQ)
- [Java Streams tutorial](https://www.youtube.com/watch?v=t1-YZ6bF-g0)

**Artigos / guias**
- [Oracle — Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Oracle — Reduction](https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html)
- [Oracle — Parallelism in Streams](https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html)
- [Baeldung — The Java Stream API Tutorial](https://www.baeldung.com/java-8-streams)

### Concorrência
**Vídeos**
- [Java Multithreading: Synchronization, Locks, Executors, Deadlock, CompletableFuture](https://www.youtube.com/watch?v=4aYvLz4E1Ts)
- [Introduction to CompletableFuture in Java 8](https://www.youtube.com/watch?v=ImtZgX1nmr8)
- [Java ExecutorService Part 1](https://www.youtube.com/watch?v=Nb85yJ1fPXM)

**Artigos / guias**
- [Oracle — Concurrency Basics](https://docs.oracle.com/javaee/7/tutorial/concurrency-utilities001.htm)
- [Oracle — Main Components of the Concurrency Utilities](https://docs.oracle.com/javaee/7/tutorial/concurrency-utilities002.htm)

### Serialização
**Vídeos**
- [Joshua Bloch — Keepin' it Effective (revisar itens de serialization)](https://www.youtube.com/watch?v=7qXfoZIqi2Q)
- [Revisiting Effective Java in 2019](https://www.youtube.com/watch?v=fmOrmNVdKig)

**Artigos / guias**
- [Oracle — Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html)
- [Oracle — Bean Persistence / Serializable overview](https://docs.oracle.com/javase/tutorial/javabeans/advanced/persistence.html)
- [Baeldung — Different Serialization Approaches for Java](https://www.baeldung.com/java-serialization-approaches)
- [Baeldung — readObject() vs readResolve()](https://www.baeldung.com/java-serialization-readobject-vs-readresolve)

### DSA geral / trilhas-base
**Vídeos**
- [William Fiset — Data Structures playlist](https://www.youtube.com/playlist?list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu)
- [William Fiset — Data Structures Easy to Advanced Course](https://www.youtube.com/watch?v=RBSGKlAvoiM)
- [Princeton Algorithms course lecture 1](https://www.youtube.com/watch?v=hZi5aEG9z8U)

**Artigos / guias**
- [cp-algorithms — Main Page](https://cp-algorithms.com/index.html)
- [cp-algorithms — Navigation](https://cp-algorithms.com/navigation.html)
- [LeetCode — Study Plans](https://leetcode.com/studyplan/)
- [NeetCode 150](https://neetcode.io/practice/practice/neetcode150)

### Arrays + Hashing
**Vídeos**
- [NeetCode — Arrays & Hashing playlist landing](https://www.youtube.com/watch?v=IiDuXLqV6e4)
- [William Fiset — Data structures playlist (dynamic arrays / hash tables)](https://www.youtube.com/playlist?list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu)

**Artigos / guias**
- [Baeldung — A Guide to Java HashMap](https://www.baeldung.com/java-hashmap)
- [cp-algorithms — Navigation (data structures fundamentals)](https://cp-algorithms.com/navigation.html)

### Linked Lists
**Vídeos**
- [NeetCode — Linked List playlist landing](https://www.youtube.com/@NeetCode/playlists)
- [William Fiset — Data structures playlist (linked list modules)](https://www.youtube.com/playlist?list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu)

**Artigos / guias**
- [cp-algorithms — Tortoise and Hare algorithm reference via navigation](https://cp-algorithms.com/navigation.html)
- [Oracle Java Tutorials — Collections / interfaces and iteration](https://docs.oracle.com/javase/tutorial/collections/)

### Stack + Queue + Deque
**Vídeos**
- [William Fiset — Data structures playlist (stack, queue, deque)](https://www.youtube.com/playlist?list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu)
- [NeetCode — Stack pattern videos](https://www.youtube.com/@NeetCode/playlists)

**Artigos / guias**
- [cp-algorithms — Minimum Stack / Minimum Queue via navigation](https://cp-algorithms.com/navigation.html)
- [Oracle Java Tutorials — Collections / Queue and Deque overview](https://docs.oracle.com/javase/tutorial/collections/)

### Binary Search + Recursão + Backtracking
**Vídeos**
- [MIT 6.006 — Dynamic Programming Part 1 (bom para recursão → memoização)](https://www.youtube.com/watch?v=r4-cftqTcdI)
- [NeetCode — Binary Search playlist landing](https://www.youtube.com/@NeetCode/playlists)

**Artigos / guias**
- [cp-algorithms — Introduction to Dynamic Programming](https://cp-algorithms.com/dynamic_programming/intro-to-dp.html)
- [LeetCode — Binary Search study plan announcement](https://leetcode.com/discuss/study-guide/1901748/new-study-plans-released-binary-search/)

### Trees + Heaps + balanced trees
**Vídeos**
- [William Fiset — Tree Algorithms / AVL / heap playlists landing](https://www.youtube.com/@WilliamFiset-videos/playlists)
- [NeetCode — Trees playlist landing](https://www.youtube.com/@NeetCode/playlists)

**Artigos / guias**
- [cp-algorithms — Segment Tree](https://cp-algorithms.com/data_structures/segment_tree.html)
- [cp-algorithms — Treap](https://cp-algorithms.com/data_structures/treap.html)

### Sorting + Divide and Conquer
**Vídeos**
- [Princeton Algorithms / Sedgewick course](https://www.youtube.com/watch?v=hZi5aEG9z8U)
- [MIT 6.006 playlist](https://www.youtube.com/playlist?list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb)

**Artigos / guias**
- [cp-algorithms — Navigation (sorting, divide and conquer)](https://cp-algorithms.com/navigation.html)
- [LeetCode — Top Interview 150](https://leetcode.com/studyplan/top-interview-150/)

### Grafos
**Vídeos**
- [William Fiset — Graph Theory playlist landing](https://www.youtube.com/@WilliamFiset-videos/playlists)
- [MIT 6.006 — Graphs / shortest paths playlist](https://www.youtube.com/playlist?list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb)
- [Top 5 Most Common Graph Algorithms for Coding Interviews](https://www.youtube.com/watch?v=utDu3Q7Flrw)

**Artigos / guias**
- [cp-algorithms — Breadth First Search](https://cp-algorithms.com/graph/breadth-first-search.html)
- [cp-algorithms — Depth First Search](https://cp-algorithms.com/graph/depth-first-search.html)
- [cp-algorithms — Topological Sorting](https://cp-algorithms.com/graph/topological-sort.html)
- [cp-algorithms — Dijkstra](https://cp-algorithms.com/graph/dijkstra.html)
- [cp-algorithms — Dijkstra on sparse graphs](https://cp-algorithms.com/graph/dijkstra_sparse.html)
- [cp-algorithms — Strongly Connected Components](https://cp-algorithms.com/graph/strongly-connected-components.html)
- [cp-algorithms — Disjoint Set Union](https://cp-algorithms.com/data_structures/disjoint_set_union.html)

### Dynamic Programming + Greedy
**Vídeos**
- [MIT 6.006 — Dynamic Programming Part 1](https://www.youtube.com/watch?v=r4-cftqTcdI)
- [MIT 6.006 — Dynamic Programming Part 2](https://www.youtube.com/watch?v=KLBCUx1is2c)
- [MIT 6.006 — Dynamic Programming Part 3](https://www.youtube.com/watch?v=TDo3r5M1LNo)
- [MIT 6.006 — Dynamic Programming Part 4](https://www.youtube.com/watch?v=i9OAOk0CUQE)

**Artigos / guias**
- [cp-algorithms — Introduction to Dynamic Programming](https://cp-algorithms.com/dynamic_programming/intro-to-dp.html)
- [cp-algorithms — Longest Increasing Subsequence](https://cp-algorithms.com/dynamic_programming/longest_increasing_subsequence.html)
- [LeetCode — Dynamic Programming study plans announcement](https://leetcode.com/discuss/study-guide/1422121/introducing-new-feature-study-plan/)

### Strings + Math + Bit
**Vídeos**
- [NeetCode — roadmap / playlists landing](https://www.youtube.com/@NeetCode/playlists)
- [Princeton Algorithms course](https://www.youtube.com/watch?v=hZi5aEG9z8U)

**Artigos / guias**
- [cp-algorithms — KMP / prefix function](https://cp-algorithms.com/string/prefix-function.html)
- [cp-algorithms — Aho-Corasick](https://cp-algorithms.com/string/aho_corasick.html)
- [cp-algorithms — Navigation (bit manipulation, algebra, strings)](https://cp-algorithms.com/navigation.html)

### Design de estruturas + entrevista
**Vídeos**
- [NeetCode 150 Course](https://www.youtube.com/watch?v=T0u5nwSA0w0)
- [freeCodeCamp / AlgoMonster — Data Structure & Algorithm Patterns for LeetCode Interviews](https://www.youtube.com/watch?v=ft0owvS5tQA)

**Artigos / guias**
- [LeetCode — Top Interview 150](https://leetcode.com/studyplan/top-interview-150/)
- [LeetCode 75](https://leetcode.com/studyplan/leetcode-75/)
- [LeetCode — Beginner's Guide](https://leetcode.com/explore/featured/card/the-leetcode-beginners-guide/678/sql-)


## Cronograma semanal (156 semanas)


### Ano 1 · Q1 — Fundamentos de Java, ADTs e análise inicial

#### Semana 001 — Java environment, classes, objetos, ADT
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** A.1–A.4; Ch.1 §1.1



- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.1
- [ ] **Ler / revisar — Effective Java:** Introdução; Itens 1–2
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 1. Two Sum
  - [ ] 217. Contains Duplicate
  - [ ] 242. Valid Anagram
  - [ ] 49. Group Anagrams
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 002 — OOP, herança, polimorfismo e visibilidade
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.1 §1.2–1.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.2 §2.1–2.3
- [ ] **Ler / revisar — Effective Java:** Itens 3–5
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 49. Group Anagrams
  - [ ] 347. Top K Frequent Elements
  - [ ] 238. Product of Array Except Self
  - [ ] 36. Valid Sudoku
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 003 — Casting, toString, packages, shape hierarchy
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.1 §1.5–1.8
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.2 revisão + exercícios
- [ ] **Ler / revisar — Effective Java:** Itens 6–7
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 36. Valid Sudoku
  - [ ] 128. Longest Consecutive Sequence
  - [ ] 271. Encode and Decode Strings
  - [ ] 560. Subarray Sum Equals K
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 004 — Strings, StringBuilder, wrappers, arrays em Java
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** A.5–A.9
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.3
- [ ] **Ler / revisar — Effective Java:** Itens 8–9
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 560. Subarray Sum Equals K
  - [ ] 523. Continuous Subarray Sum
  - [ ] 525. Contiguous Array
  - [ ] 1. Two Sum
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 005 — Big-O, crescimento, análise amortizada intuitiva
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.4 §4.1–4.5
- [ ] **Ler / revisar — Effective Java:** Itens 10–12
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 125. Valid Palindrome
  - [ ] 167. Two Sum II - Input Array Is Sorted
  - [ ] 15. 3Sum
  - [ ] 11. Container With Most Water
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 006 — List interface, ArrayList e collections genéricas
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.2–2.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.5
- [ ] **Ler / revisar — Effective Java:** Itens 13–14
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 1. Two Sum
  - [ ] 217. Contains Duplicate
  - [ ] 242. Valid Anagram
  - [ ] 49. Group Anagrams
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 007 — Implementando ArrayList do zero
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.17 §17.1–17.4 (introdução à análise amortizada)
- [ ] **Ler / revisar — Effective Java:** Itens 15–17
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 49. Group Anagrams
  - [ ] 347. Top K Frequent Elements
  - [ ] 238. Product of Array Except Self
  - [ ] 36. Valid Sudoku
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 008 — Phone directory / aplicações com listas
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.3 revisão + projetos
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.4 exercícios escolhidos
- [ ] **Ler / revisar — Effective Java:** Itens 18–19
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 11. Container With Most Water
  - [ ] 42. Trapping Rain Water
  - [ ] 121. Best Time to Buy and Sell Stock
  - [ ] 3. Longest Substring Without Repeating Characters
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 009 — Testing types, boundary conditions, stubs, drivers
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.3 §3.1–3.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.2 + Ch.3 revisão
- [ ] **Ler / revisar — Effective Java:** Itens 20–21
- [ ] **Assistir / ler recursos do tema:** Java core + Effective Java, Testes + exceções, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 20. Valid Parentheses
  - [ ] 155. Min Stack
  - [ ] 125. Valid Palindrome
  - [ ] 704. Binary Search
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 010 — JUnit 5, TDD, testes interativos
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.3 §3.4–3.6
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.1–3 revisão guiada
- [ ] **Ler / revisar — Effective Java:** Itens 22–23
- [ ] **Assistir / ler recursos do tema:** Java core + Effective Java, Testes + exceções, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 704. Binary Search
  - [ ] 1. Two Sum
  - [ ] 146. LRU Cache
  - [ ] 20. Valid Parentheses
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 011 — Debugging disciplinado, revisão de API design
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.3 §3.7
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.4–5 revisão
- [ ] **Ler / revisar — Effective Java:** Itens 24–25
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 36. Valid Sudoku
  - [ ] 128. Longest Consecutive Sequence
  - [ ] 271. Encode and Decode Strings
  - [ ] 560. Subarray Sum Equals K
  - [ ] 523. Continuous Subarray Sum
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 012 — Sprint de revisão: arrays, strings, hash básico
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão A.1–A.9 / Ch.1–3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.1–5 revisão
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 1–25
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 523. Continuous Subarray Sum
  - [ ] 525. Contiguous Array
  - [ ] 1. Two Sum
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 013 — Mock + semana de folga técnica / reforço
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Projetos e programming projects
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Problemas clássicos de revisão
- [ ] **Ler / revisar — Effective Java:** Releitura dos itens mais fracos
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 1 · Q2 — Listas ligadas, iteradores, stack, queue, deque e recursão

#### Semana 014 — Single linked list
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.5
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 §10.2–10.3
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 10–17 (imutabilidade, composição, interfaces)
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Linked Lists
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 206. Reverse Linked List
  - [ ] 21. Merge Two Sorted Lists
  - [ ] 141. Linked List Cycle
  - [ ] 143. Reorder List
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 015 — Double linked list e circular list
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.6
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 §10.1–10.4
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 18–25
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Linked Lists
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 143. Reorder List
  - [ ] 19. Remove Nth Node From End of List
  - [ ] 2. Add Two Numbers
  - [ ] 138. Copy List with Random Pointer
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 016 — Iterator, ListIterator e Iterable
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.7
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 revisão
- [ ] **Ler / revisar — Effective Java:** Itens 26–27
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Linked Lists
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 138. Copy List with Random Pointer
  - [ ] 23. Merge k Sorted Lists
  - [ ] 25. Reverse Nodes in k-Group
  - [ ] 61. Rotate List
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 017 — LinkedList class e ordered list
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.8–2.9
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 exercícios
- [ ] **Ler / revisar — Effective Java:** Itens 28–29
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Linked Lists
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 61. Rotate List
  - [ ] 206. Reverse Linked List
  - [ ] 21. Merge Two Sorted Lists
  - [ ] 141. Linked List Cycle
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 018 — Collections Framework design
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.2 §2.10
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.11 introdução
- [ ] **Ler / revisar — Effective Java:** Itens 30–31
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 146. LRU Cache
  - [ ] 981. Time Based Key-Value Store
  - [ ] 205. Isomorphic Strings
  - [ ] 290. Word Pattern
  - [ ] 763. Partition Labels
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 019 — Stack ADT e implementações
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.4 §4.1–4.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 §10.1
- [ ] **Ler / revisar — Effective Java:** Itens 32–33
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Stack + Queue + Deque
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 20. Valid Parentheses
  - [ ] 155. Min Stack
  - [ ] 150. Evaluate Reverse Polish Notation
  - [ ] 739. Daily Temperatures
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 020 — Aplicações de stack: postfix, infix, parênteses
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.4 §4.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.2 / Ch.7 relação com parsing
- [ ] **Ler / revisar — Effective Java:** Itens 34–35
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Stack + Queue + Deque
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 739. Daily Temperatures
  - [ ] 853. Car Fleet
  - [ ] 84. Largest Rectangle in Histogram
  - [ ] 232. Implement Queue using Stacks
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 021 — Queue ADT e aplicações
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.4 §4.5–4.6
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 §10.1
- [ ] **Ler / revisar — Effective Java:** Itens 36–38
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Stack + Queue + Deque
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 232. Implement Queue using Stacks
  - [ ] 933. Number of Recent Calls
  - [ ] 622. Design Circular Queue
  - [ ] 641. Design Circular Deque
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 022 — Implementando queue e deque
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.4 §4.7–4.8
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 / Ch.22 BFS preview
- [ ] **Ler / revisar — Effective Java:** Itens 39–41
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Stack + Queue + Deque
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 641. Design Circular Deque
  - [ ] 20. Valid Parentheses
  - [ ] 155. Min Stack
  - [ ] 150. Evaluate Reverse Polish Notation
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 023 — Pensamento recursivo e stack frames
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.5 §5.1–5.2
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.4 revisão / recorrências
- [ ] **Ler / revisar — Effective Java:** Itens 42–43
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Binary Search + Recursão + Backtracking
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 704. Binary Search
  - [ ] 35. Search Insert Position
  - [ ] 33. Search in Rotated Sorted Array
  - [ ] 153. Find Minimum in Rotated Sorted Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 024 — Busca linear/busca binária recursiva
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.5 §5.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.2.3 / Ch.9 seleção
- [ ] **Ler / revisar — Effective Java:** Itens 44–45
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Binary Search + Recursão + Backtracking
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 153. Find Minimum in Rotated Sorted Array
  - [ ] 875. Koko Eating Bananas
  - [ ] 74. Search a 2D Matrix
  - [ ] 78. Subsets
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 025 — Recursion on linked structures
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.5 §5.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.12 preview
- [ ] **Ler / revisar — Effective Java:** Itens 46–48
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Binary Search + Recursão + Backtracking
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 78. Subsets
  - [ ] 46. Permutations
  - [ ] 39. Combination Sum
  - [ ] 79. Word Search
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 026 — Backtracking: maze / revisão de recursão
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.5 §5.5–5.6
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.15 preview
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 26–48
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Binary Search + Recursão + Backtracking
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 79. Word Search
  - [ ] 22. Generate Parentheses
  - [ ] 51. N-Queens
  - [ ] 704. Binary Search
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 1 · Q3 — Árvores, heaps, BST, hashing e começo forte de Java generics/streams

#### Semana 027 — Tree terminology e binary trees
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.6 §6.1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.12 §12.1–12.2
- [ ] **Ler / revisar — Effective Java:** Itens 49–50
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 226. Invert Binary Tree
  - [ ] 104. Maximum Depth of Binary Tree
  - [ ] 543. Diameter of Binary Tree
  - [ ] 110. Balanced Binary Tree
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 028 — Tree traversals
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.6 §6.2
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.12 §12.2
- [ ] **Ler / revisar — Effective Java:** Itens 51–52
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 110. Balanced Binary Tree
  - [ ] 100. Same Tree
  - [ ] 572. Subtree of Another Tree
  - [ ] 102. Binary Tree Level Order Traversal
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 029 — Implementando BinaryTree
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.6 §6.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.12 exercícios
- [ ] **Ler / revisar — Effective Java:** Itens 53–54
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 102. Binary Tree Level Order Traversal
  - [ ] 199. Binary Tree Right Side View
  - [ ] 98. Validate Binary Search Tree
  - [ ] 230. Kth Smallest Element in a BST
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 030 — Lambda expressions e functional interfaces
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.6 §6.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.3 revisão + abstração
- [ ] **Ler / revisar — Effective Java:** Itens 55–56
- [ ] **Assistir / ler recursos do tema:** Java core + Effective Java, Lambdas + Streams, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 49. Group Anagrams
  - [ ] 347. Top K Frequent Elements
  - [ ] 56. Merge Intervals
  - [ ] 242. Valid Anagram
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 031 — BST overview e operações
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.6 §6.5
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.12 §12.3–12.4
- [ ] **Ler / revisar — Effective Java:** Itens 57–58
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 230. Kth Smallest Element in a BST
  - [ ] 235. Lowest Common Ancestor of a BST
  - [ ] 105. Construct Binary Tree from Preorder and Inorder Traversal
  - [ ] 124. Binary Tree Maximum Path Sum
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 032 — Heaps e priority queues
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.6 §6.6
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.6
- [ ] **Ler / revisar — Effective Java:** Itens 59–60
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 703. Kth Largest Element in a Stream
  - [ ] 1046. Last Stone Weight
  - [ ] 215. Kth Largest Element in an Array
  - [ ] 973. K Closest Points to Origin
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 033 — Huffman trees e greedy preview
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.6 §6.7
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.16 §16.3
- [ ] **Ler / revisar — Effective Java:** Itens 61–63
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 973. K Closest Points to Origin
  - [ ] 621. Task Scheduler
  - [ ] 295. Find Median from Data Stream
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 034 — Set interface e abstração de conjunto
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.7 §7.1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.11 §11.1–11.3
- [ ] **Ler / revisar — Effective Java:** Itens 64–65
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 763. Partition Labels
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 49. Group Anagrams
  - [ ] 525. Contiguous Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 035 — Map interface e modelos de chave/valor
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.7 §7.2
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.11 §11.4–11.5
- [ ] **Ler / revisar — Effective Java:** Itens 66–68
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 525. Contiguous Array
  - [ ] 438. Find All Anagrams in a String
  - [ ] 146. LRU Cache
  - [ ] 981. Time Based Key-Value Store
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 036 — Hash tables: open addressing e chaining
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.7 §7.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.11 completo
- [ ] **Ler / revisar — Effective Java:** Itens 69–70
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 981. Time Based Key-Value Store
  - [ ] 205. Isomorphic Strings
  - [ ] 290. Word Pattern
  - [ ] 763. Partition Labels
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 037 — Implementando hash tables
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.7 §7.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.11 exercícios
- [ ] **Ler / revisar — Effective Java:** Itens 71–72
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 763. Partition Labels
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 49. Group Anagrams
  - [ ] 525. Contiguous Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 038 — hashCode, equals, TreeMap e TreeSet
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.7 §7.5
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.13 preview
- [ ] **Ler / revisar — Effective Java:** Itens 73–74
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 525. Contiguous Array
  - [ ] 438. Find All Anagrams in a String
  - [ ] 146. LRU Cache
  - [ ] 981. Time Based Key-Value Store
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 039 — Aplicações extras de maps / revisão trimestre
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.7 §7.6–7.7
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.14 preview
- [ ] **Ler / revisar — Effective Java:** Itens 75–77
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 981. Time Based Key-Value Store
  - [ ] 205. Isomorphic Strings
  - [ ] 290. Word Pattern
  - [ ] 763. Partition Labels
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 1 · Q4 — Sorting, divide and conquer, binary search patterns, intervals e revisão do Ano 1

#### Semana 040 — Using Java sorting methods + revisão de Collections
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.2 + Java sort pragmático
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 49–68
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 912. Sort an Array
  - [ ] 75. Sort Colors
  - [ ] 56. Merge Intervals
  - [ ] 57. Insert Interval
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 041 — Selection sort e insertion sort
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.2–8.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.2.1
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 69–77
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 57. Insert Interval
  - [ ] 435. Non-overlapping Intervals
  - [ ] 452. Minimum Number of Arrows to Burst Balloons
  - [ ] 347. Top K Frequent Elements
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 042 — Quadratic sorts e comparação
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.3 / análise assintótica
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 57–68
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 347. Top K Frequent Elements
  - [ ] 215. Kth Largest Element in an Array
  - [ ] 280. Wiggle Sort
  - [ ] 912. Sort an Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 043 — Shell sort
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.5
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.4
- [ ] **Ler / revisar — Effective Java:** Prática de microbenchmark
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 912. Sort an Array
  - [ ] 75. Sort Colors
  - [ ] 56. Merge Intervals
  - [ ] 57. Insert Interval
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 044 — Merge sort
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.6
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.4 / método mestre
- [ ] **Ler / revisar — Effective Java:** Prática de API clean
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 57. Insert Interval
  - [ ] 435. Non-overlapping Intervals
  - [ ] 452. Minimum Number of Arrows to Burst Balloons
  - [ ] 347. Top K Frequent Elements
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 045 — Timsort
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.7
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.17.4 (dynamic tables como intuição de otimização)
- [ ] **Ler / revisar — Effective Java:** Revisão streams/collections
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 347. Top K Frequent Elements
  - [ ] 215. Kth Largest Element in an Array
  - [ ] 280. Wiggle Sort
  - [ ] 912. Sort an Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 046 — Heapsort
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.8
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.6
- [ ] **Ler / revisar — Effective Java:** Revisão heap item
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 295. Find Median from Data Stream
  - [ ] 23. Merge k Sorted Lists
  - [ ] 355. Design Twitter
  - [ ] 767. Reorganize String
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 047 — Quicksort
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.9
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.7
- [ ] **Ler / revisar — Effective Java:** Revisão de particionamento
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 912. Sort an Array
  - [ ] 75. Sort Colors
  - [ ] 56. Merge Intervals
  - [ ] 57. Insert Interval
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 048 — Testing sort algorithms
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.10
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.5 aleatorização
- [ ] **Ler / revisar — Effective Java:** Revisão de JUnit
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 57. Insert Interval
  - [ ] 435. Non-overlapping Intervals
  - [ ] 452. Minimum Number of Arrows to Burst Balloons
  - [ ] 347. Top K Frequent Elements
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 049 — Dutch National Flag, partitioning e quickselect
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.8 §8.11
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.9
- [ ] **Ler / revisar — Effective Java:** Revisão de sobrecarga e assinatura
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 347. Top K Frequent Elements
  - [ ] 215. Kth Largest Element in an Array
  - [ ] 280. Wiggle Sort
  - [ ] 912. Sort an Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 050 — Binary search patterns / resposta / capacity search
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão Ch.5 + Ch.8
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.9 / seleção
- [ ] **Ler / revisar — Effective Java:** Revisão métodos
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Binary Search + Recursão + Backtracking
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 704. Binary Search
  - [ ] 35. Search Insert Position
  - [ ] 33. Search in Rotated Sorted Array
  - [ ] 153. Find Minimum in Rotated Sorted Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 051 — Intervals, sweep line introdutória, monotonic patterns
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.14.3 (interval trees) preview
- [ ] **Ler / revisar — Effective Java:** Revisão general programming
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 912. Sort an Array
  - [ ] 75. Sort Colors
  - [ ] 56. Merge Intervals
  - [ ] 57. Insert Interval
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 052 — Fechamento do Ano 1: mock, revisão espiral e retro
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão geral Ano 1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.1–17 revisão
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 1–77
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 2 · Q5 — Balanced trees, B-trees, skip-lists e grafos I

#### Semana 053 — Tree balance and rotations
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.9 §9.1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.13 §13.1–13.2
- [ ] **Ler / revisar — Effective Java:** Item 78
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 124. Binary Tree Maximum Path Sum
  - [ ] 297. Serialize and Deserialize Binary Tree
  - [ ] 226. Invert Binary Tree
  - [ ] 104. Maximum Depth of Binary Tree
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 054 — AVL trees
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.9 §9.2
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.13 / rotações
- [ ] **Ler / revisar — Effective Java:** Item 79
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 104. Maximum Depth of Binary Tree
  - [ ] 543. Diameter of Binary Tree
  - [ ] 110. Balanced Binary Tree
  - [ ] 100. Same Tree
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 055 — Red-Black trees
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.9 §9.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.13 §13.3–13.4
- [ ] **Ler / revisar — Effective Java:** Item 80
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 100. Same Tree
  - [ ] 572. Subtree of Another Tree
  - [ ] 102. Binary Tree Level Order Traversal
  - [ ] 199. Binary Tree Right Side View
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 056 — 2-3 trees
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.9 §9.4
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.18 preview
- [ ] **Ler / revisar — Effective Java:** Item 81
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 199. Binary Tree Right Side View
  - [ ] 98. Validate Binary Search Tree
  - [ ] 230. Kth Smallest Element in a BST
  - [ ] 235. Lowest Common Ancestor of a BST
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 057 — B-trees, B+ trees, 2-3-4 trees
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.9 §9.5
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.18
- [ ] **Ler / revisar — Effective Java:** Item 82
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 235. Lowest Common Ancestor of a BST
  - [ ] 105. Construct Binary Tree from Preorder and Inorder Traversal
  - [ ] 124. Binary Tree Maximum Path Sum
  - [ ] 297. Serialize and Deserialize Binary Tree
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 058 — Skip-lists e ordered maps alternativos
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.7 §7.8
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS análise probabilística ligação conceitual
- [ ] **Ler / revisar — Effective Java:** Item 83
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 211. Design Add and Search Words Data Structure
  - [ ] 212. Word Search II
  - [ ] 721. Accounts Merge
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 059 — Graph terminology
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.22 §22.1
- [ ] **Ler / revisar — Effective Java:** Item 84
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 200. Number of Islands
  - [ ] 133. Clone Graph
  - [ ] 695. Max Area of Island
  - [ ] 130. Surrounded Regions
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 060 — Graph ADT, Edge, adjacency list/matrix
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.2–10.3
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.22 §22.1
- [ ] **Ler / revisar — Effective Java:** Revisão concorrência
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 130. Surrounded Regions
  - [ ] 994. Rotting Oranges
  - [ ] 417. Pacific Atlantic Water Flow
  - [ ] 207. Course Schedule
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 061 — Graph traversals: BFS
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.4 BFS
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.22 §22.2
- [ ] **Ler / revisar — Effective Java:** Revisão executors / tasks
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 207. Course Schedule
  - [ ] 210. Course Schedule II
  - [ ] 684. Redundant Connection
  - [ ] 547. Number of Provinces
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 062 — Graph traversals: DFS
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.4 DFS
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.22 §22.3
- [ ] **Ler / revisar — Effective Java:** Revisão wait/notify vs utilities
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 547. Number of Provinces
  - [ ] 1584. Min Cost to Connect All Points
  - [ ] 743. Network Delay Time
  - [ ] 787. Cheapest Flights Within K Stops
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 063 — Maze shortest path e graph modeling
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.5 case study 1
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.22 revisão
- [ ] **Ler / revisar — Effective Java:** Revisão thread safety
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 787. Cheapest Flights Within K Stops
  - [ ] 1091. Shortest Path in Binary Matrix
  - [ ] 127. Word Ladder
  - [ ] 310. Minimum Height Trees
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 064 — Topological sort
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.5 case study 2
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.22 §22.4
- [ ] **Ler / revisar — Effective Java:** Revisão lazy init / scheduler
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 310. Minimum Height Trees
  - [ ] 200. Number of Islands
  - [ ] 133. Clone Graph
  - [ ] 695. Max Area of Island
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 065 — Review: balanced trees + graph basics
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão Ch.9–10
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.13/18/22
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 78–84
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 695. Max Area of Island
  - [ ] 130. Surrounded Regions
  - [ ] 994. Rotting Oranges
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 2 · Q6 — Grafos II, shortest paths, MST, DSU, tries e teoria avançada de estruturas

#### Semana 066 — Dijkstra e weighted graphs
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.6
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.24 §24.3
- [ ] **Ler / revisar — Effective Java:** Item 85
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 994. Rotting Oranges
  - [ ] 417. Pacific Atlantic Water Flow
  - [ ] 207. Course Schedule
  - [ ] 210. Course Schedule II
  - [ ] 684. Redundant Connection
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 067 — MST
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.6 MST
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.23
- [ ] **Ler / revisar — Effective Java:** Item 86
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 684. Redundant Connection
  - [ ] 547. Number of Provinces
  - [ ] 1584. Min Cost to Connect All Points
  - [ ] 743. Network Delay Time
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 068 — A*
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Ch.10 §10.7
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.24 visão geral
- [ ] **Ler / revisar — Effective Java:** Item 87
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 743. Network Delay Time
  - [ ] 787. Cheapest Flights Within K Stops
  - [ ] 1091. Shortest Path in Binary Matrix
  - [ ] 127. Word Ladder
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 069 — Union-Find / disjoint sets
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.21
- [ ] **Ler / revisar — Effective Java:** Item 88
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 721. Accounts Merge
  - [ ] 1202. Smallest String With Swaps
  - [ ] 990. Satisfiability of Equality Equations
  - [ ] 1061. Lexicographically Smallest Equivalent String
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 070 — Strongly connected components
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.22 §22.5
- [ ] **Ler / revisar — Effective Java:** Item 89
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 127. Word Ladder
  - [ ] 310. Minimum Height Trees
  - [ ] 200. Number of Islands
  - [ ] 133. Clone Graph
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 071 — Bellman-Ford e DAG shortest paths
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.24 §24.1–24.2
- [ ] **Ler / revisar — Effective Java:** Item 90
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 133. Clone Graph
  - [ ] 695. Max Area of Island
  - [ ] 130. Surrounded Regions
  - [ ] 994. Rotting Oranges
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 072 — Floyd-Warshall / all-pairs shortest paths
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.25
- [ ] **Ler / revisar — Effective Java:** Revisão serialização
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 994. Rotting Oranges
  - [ ] 417. Pacific Atlantic Water Flow
  - [ ] 207. Course Schedule
  - [ ] 210. Course Schedule II
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 073 — Trie / prefix tree
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.32 preview + string matching context
- [ ] **Ler / revisar — Effective Java:** Revisão serialização
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 1061. Lexicographically Smallest Equivalent String
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 211. Design Add and Search Words Data Structure
  - [ ] 212. Word Search II
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 074 — String hashing / prefix-function / KMP intro
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.32
- [ ] **Ler / revisar — Effective Java:** Revisão streams e APIs
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 28. Find the Index of the First Occurrence in a String
  - [ ] 14. Longest Common Prefix
  - [ ] 5. Longest Palindromic Substring
  - [ ] 647. Palindromic Substrings
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 075 — Order statistics / interval trees
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.14
- [ ] **Ler / revisar — Effective Java:** Revisão equals/hashCode
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 297. Serialize and Deserialize Binary Tree
  - [ ] 226. Invert Binary Tree
  - [ ] 104. Maximum Depth of Binary Tree
  - [ ] 543. Diameter of Binary Tree
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 076 — Amortized analysis e dynamic tables
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão + complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.17
- [ ] **Ler / revisar — Effective Java:** Revisão objects and allocation
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 1. Two Sum
  - [ ] 217. Contains Duplicate
  - [ ] 242. Valid Anagram
  - [ ] 49. Group Anagrams
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 077 — Fibonacci heaps / van Emde Boas (visão de repertório)
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.19–20
- [ ] **Ler / revisar — Effective Java:** Revisão performance
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 767. Reorganize String
  - [ ] 703. Kth Largest Element in a Stream
  - [ ] 1046. Last Stone Weight
  - [ ] 215. Kth Largest Element in an Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 078 — Review: graphs + advanced DS
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.21–25
- [ ] **Ler / revisar — Effective Java:** Revisão Itens 85–90
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 210. Course Schedule II
  - [ ] 684. Redundant Connection
  - [ ] 547. Number of Provinces
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 2 · Q7 — Dynamic Programming, greedy, matemática, bits e strings clássicas

#### Semana 079 — DP mindset: memoization vs tabulation
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.15 §15.1–15.3
- [ ] **Ler / revisar — Effective Java:** Revisão methods / parameters
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 70. Climbing Stairs
  - [ ] 198. House Robber
  - [ ] 213. House Robber II
  - [ ] 322. Coin Change
  - [ ] 300. Longest Increasing Subsequence
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 080 — LCS, LIS e subsequências
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.15 §15.4
- [ ] **Ler / revisar — Effective Java:** Revisão streams side effects
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 1143. Longest Common Subsequence
  - [ ] 72. Edit Distance
  - [ ] 115. Distinct Subsequences
  - [ ] 64. Minimum Path Sum
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 081 — Knapsack, subset sum, partition
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.15 + Ch.34 subset sum conexão teórica
- [ ] **Ler / revisar — Effective Java:** Revisão Optional/collections vazias
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 300. Longest Increasing Subsequence
  - [ ] 416. Partition Equal Subset Sum
  - [ ] 494. Target Sum
  - [ ] 91. Decode Ways
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 082 — Matrix chain multiplication / interval DP
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.15 §15.2
- [ ] **Ler / revisar — Effective Java:** Revisão documentação de API
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 64. Minimum Path Sum
  - [ ] 221. Maximal Square
  - [ ] 97. Interleaving String
  - [ ] 139. Word Break
  - [ ] 312. Burst Balloons
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 083 — Tree / graph DP introdutório
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.15 revisão
- [ ] **Ler / revisar — Effective Java:** Revisão concurrency
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 312. Burst Balloons
  - [ ] 518. Coin Change II
  - [ ] 329. Longest Increasing Path in a Matrix
  - [ ] 1143. Longest Common Subsequence
  - [ ] 72. Edit Distance
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 084 — Greedy choice property
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.16 §16.1–16.2
- [ ] **Ler / revisar — Effective Java:** Revisão otimização criteriosa
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 45. Jump Game II
  - [ ] 134. Gas Station
  - [ ] 678. Valid Parenthesis String
  - [ ] 135. Candy
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 085 — Huffman e greedy proofs
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.16 §16.3–16.5
- [ ] **Ler / revisar — Effective Java:** Revisão primitive vs boxed
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 135. Candy
  - [ ] 136. Single Number
  - [ ] 191. Number of 1 Bits
  - [ ] 338. Counting Bits
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 086 — Bit manipulation fundamentals
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.31 preview
- [ ] **Ler / revisar — Effective Java:** Revisão nomenclatura
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 338. Counting Bits
  - [ ] 190. Reverse Bits
  - [ ] 268. Missing Number
  - [ ] 371. Sum of Two Integers
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 087 — Number theory: gcd, modular arithmetic
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.31 §31.1–31.5
- [ ] **Ler / revisar — Effective Java:** Revisão exceptions
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 371. Sum of Two Integers
  - [ ] 50. Pow(x, n)
  - [ ] 202. Happy Number
  - [ ] 45. Jump Game II
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 088 — Primality, power, combinatória leve
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.31 §31.6–31.9
- [ ] **Ler / revisar — Effective Java:** Revisão checked vs runtime
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 45. Jump Game II
  - [ ] 134. Gas Station
  - [ ] 678. Valid Parenthesis String
  - [ ] 135. Candy
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 089 — String matching: naive, Rabin-Karp, KMP
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.32
- [ ] **Ler / revisar — Effective Java:** Revisão strings vs types adequados
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 647. Palindromic Substrings
  - [ ] 49. Group Anagrams
  - [ ] 131. Palindrome Partitioning
  - [ ] 76. Minimum Window Substring
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 090 — Aho-Corasick e tries de dicionário
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.32 + artigo complementar
- [ ] **Ler / revisar — Effective Java:** Revisão generics
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 76. Minimum Window Substring
  - [ ] 424. Longest Repeating Character Replacement
  - [ ] 3. Longest Substring Without Repeating Characters
  - [ ] 28. Find the Index of the First Occurrence in a String
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 091 — Review: DP + greedy + strings
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.15–16 / Ch.31–32
- [ ] **Ler / revisar — Effective Java:** Revisão geral programming
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 72. Edit Distance
  - [ ] 115. Distinct Subsequences
  - [ ] 64. Minimum Path Sum
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 2 · Q8 — Geometria, NP-complete, aproximação, design de estruturas e Java avançado

#### Semana 092 — Computational geometry high level
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.33
- [ ] **Ler / revisar — Effective Java:** Revisão immutability/value objects
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 135. Candy
  - [ ] 136. Single Number
  - [ ] 191. Number of 1 Bits
  - [ ] 338. Counting Bits
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 093 — NP-complete: o que cai em entrevista e o que é repertório
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.34
- [ ] **Ler / revisar — Effective Java:** Revisão API design
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 094 — Approximation algorithms: visão estratégica
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.35
- [ ] **Ler / revisar — Effective Java:** Revisão optimization / measurement
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 095 — LRU cache
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.10 + Hash/Linked structure recap
- [ ] **Ler / revisar — Effective Java:** Revisão composition over inheritance
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 096 — LFU cache e randomized sets
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão hash + frequency
- [ ] **Ler / revisar — Effective Java:** Revisão equals/hashCode
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 097 — Median finder, heaps duplos e time map
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão heaps + maps
- [ ] **Ler / revisar — Effective Java:** Revisão collections return types
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 098 — Autocomplete, trie + heap
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão trie
- [ ] **Ler / revisar — Effective Java:** Revisão interfaces funcionais
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 099 — Concurrency fundamentals: threads, race conditions
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.27 intro
- [ ] **Ler / revisar — Effective Java:** Itens 78–79 revisão profunda
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 100 — Executors, tasks, pools, CompletableFuture
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.27 visão geral
- [ ] **Ler / revisar — Effective Java:** Itens 80–84 revisão profunda
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 101 — Thread safety, locks, atomicity, starvation
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** CLRS Ch.27 / sistemas
- [ ] **Ler / revisar — Effective Java:** Itens 78–84
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 102 — Serialization, readObject, readResolve, proxies
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão orientada
- [ ] **Ler / revisar — Effective Java:** Itens 85–90 revisão profunda
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 103 — Java clean-up sprint: refatorar templates e APIs
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Projeto
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão global
- [ ] **Ler / revisar — Effective Java:** Revisão Effective Java
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 104 — Review + mock do Ano 2
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão CLRS Ano 2
- [ ] **Ler / revisar — Effective Java:** Revisão Effective Java Ano 2
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 3 · Q9 — Ano 3 — oficialização via listas curadas e revisão espiral I

#### Semana 105 — LeetCode 75 kickoff: arrays & hashing
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** LeetCode 75 / Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão Effective Java: objects/classes
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 49. Group Anagrams
  - [ ] 347. Top K Frequent Elements
  - [ ] 238. Product of Array Except Self
  - [ ] 36. Valid Sudoku
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 106 — LeetCode 75: two pointers & sliding window
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão API design
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 3. Longest Substring Without Repeating Characters
  - [ ] 424. Longest Repeating Character Replacement
  - [ ] 567. Permutation in String
  - [ ] 76. Minimum Window Substring
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 107 — LeetCode 75: stack & queue
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão exceptions/testing
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Stack + Queue + Deque
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 150. Evaluate Reverse Polish Notation
  - [ ] 739. Daily Temperatures
  - [ ] 853. Car Fleet
  - [ ] 84. Largest Rectangle in Histogram
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 108 — LeetCode 75: linked list
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão mutability / equals
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Linked Lists
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 141. Linked List Cycle
  - [ ] 143. Reorder List
  - [ ] 19. Remove Nth Node From End of List
  - [ ] 2. Add Two Numbers
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 109 — LeetCode 75: trees
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão recursion
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 543. Diameter of Binary Tree
  - [ ] 110. Balanced Binary Tree
  - [ ] 100. Same Tree
  - [ ] 572. Subtree of Another Tree
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 110 — LeetCode 75: BST / heap / priority queue
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão generics
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 215. Kth Largest Element in an Array
  - [ ] 973. K Closest Points to Origin
  - [ ] 621. Task Scheduler
  - [ ] 295. Find Median from Data Stream
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 111 — LeetCode 75: binary search
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão methods
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Binary Search + Recursão + Backtracking
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 153. Find Minimum in Rotated Sorted Array
  - [ ] 875. Koko Eating Bananas
  - [ ] 74. Search a 2D Matrix
  - [ ] 78. Subsets
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 112 — LeetCode 75: backtracking
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão lambdas
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Binary Search + Recursão + Backtracking
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 78. Subsets
  - [ ] 46. Permutations
  - [ ] 39. Combination Sum
  - [ ] 79. Word Search
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 113 — LeetCode 75: graphs I
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão concurrency
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 547. Number of Provinces
  - [ ] 1584. Min Cost to Connect All Points
  - [ ] 743. Network Delay Time
  - [ ] 787. Cheapest Flights Within K Stops
  - [ ] 1091. Shortest Path in Binary Matrix
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 114 — LeetCode 75: graphs II
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão thread safety
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 1091. Shortest Path in Binary Matrix
  - [ ] 127. Word Ladder
  - [ ] 310. Minimum Height Trees
  - [ ] 200. Number of Islands
  - [ ] 133. Clone Graph
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 115 — LeetCode 75: 1D DP
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão optimization
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 91. Decode Ways
  - [ ] 62. Unique Paths
  - [ ] 55. Jump Game
  - [ ] 70. Climbing Stairs
  - [ ] 198. House Robber
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 116 — LeetCode 75: 2D DP
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão serialization
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 64. Minimum Path Sum
  - [ ] 221. Maximal Square
  - [ ] 97. Interleaving String
  - [ ] 139. Word Break
  - [ ] 312. Burst Balloons
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 117 — Review sprint: weak topics A
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Refazer problemas errados
- [ ] **Ler / revisar — Effective Java:** Revisão notas
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 3 · Q10 — Top Interview 150, NeetCode 150 e repertório avançado de entrevista

#### Semana 118 — Top Interview 150: array/string pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão Java core
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 36. Valid Sudoku
  - [ ] 128. Longest Consecutive Sequence
  - [ ] 271. Encode and Decode Strings
  - [ ] 560. Subarray Sum Equals K
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 119 — Top Interview 150: hash map/set pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão equals/hashCode
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 763. Partition Labels
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 49. Group Anagrams
  - [ ] 525. Contiguous Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 120 — Top Interview 150: intervals + sorting pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão comparator/Comparable
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Sorting + Divide and Conquer, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 57. Insert Interval
  - [ ] 435. Non-overlapping Intervals
  - [ ] 452. Minimum Number of Arrows to Burst Balloons
  - [ ] 347. Top K Frequent Elements
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 121 — Top Interview 150: linked list pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão constructors/builders
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Linked Lists
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 2. Add Two Numbers
  - [ ] 138. Copy List with Random Pointer
  - [ ] 23. Merge k Sorted Lists
  - [ ] 25. Reverse Nodes in k-Group
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 122 — Top Interview 150: binary tree pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão recursion
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 572. Subtree of Another Tree
  - [ ] 102. Binary Tree Level Order Traversal
  - [ ] 199. Binary Tree Right Side View
  - [ ] 98. Validate Binary Search Tree
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 123 — Top Interview 150: graph pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão graph APIs
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 133. Clone Graph
  - [ ] 695. Max Area of Island
  - [ ] 130. Surrounded Regions
  - [ ] 994. Rotting Oranges
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 124 — Top Interview 150: heap / design pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão APIs clean
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 125 — Top Interview 150: backtracking + trie pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão wildcards / generics
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 212. Word Search II
  - [ ] 721. Accounts Merge
  - [ ] 1202. Smallest String With Swaps
  - [ ] 990. Satisfiability of Equality Equations
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 126 — Top Interview 150: 1D DP pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão Optional
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 198. House Robber
  - [ ] 213. House Robber II
  - [ ] 322. Coin Change
  - [ ] 300. Longest Increasing Subsequence
  - [ ] 416. Partition Equal Subset Sum
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 127 — Top Interview 150: 2D DP pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão collectors
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 312. Burst Balloons
  - [ ] 518. Coin Change II
  - [ ] 329. Longest Increasing Path in a Matrix
  - [ ] 1143. Longest Common Subsequence
  - [ ] 72. Edit Distance
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 128 — NeetCode 150: graph hard-ish pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** NeetCode 150
- [ ] **Ler / revisar — Effective Java:** Revisão performance
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 994. Rotting Oranges
  - [ ] 417. Pacific Atlantic Water Flow
  - [ ] 207. Course Schedule
  - [ ] 210. Course Schedule II
  - [ ] 684. Redundant Connection
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 129 — NeetCode 150: design / advanced DS pack
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão guiada
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** NeetCode 150
- [ ] **Ler / revisar — Effective Java:** Revisão concurrency
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 130 — Review sprint: weak topics B
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Refazer errados
- [ ] **Ler / revisar — Effective Java:** Revisão notes
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 3 · Q11 — Mocks, timed sets, hard patterns e preparação real de entrevista

#### Semana 131 — Timed set 1: easy + medium + medium
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Mock
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Refazer feedback
- [ ] **Ler / revisar — Effective Java:** Revisão comunicação
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 132 — Timed set 2: graphs
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Mock
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Refazer feedback
- [ ] **Ler / revisar — Effective Java:** Revisão modelagem
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 684. Redundant Connection
  - [ ] 547. Number of Provinces
  - [ ] 1584. Min Cost to Connect All Points
  - [ ] 743. Network Delay Time
  - [ ] 787. Cheapest Flights Within K Stops
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 133 — Timed set 3: DP
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Mock
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Refazer feedback
- [ ] **Ler / revisar — Effective Java:** Revisão definição de estado
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 72. Edit Distance
  - [ ] 115. Distinct Subsequences
  - [ ] 64. Minimum Path Sum
  - [ ] 221. Maximal Square
  - [ ] 97. Interleaving String
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 134 — Timed set 4: design de estrutura
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Mock
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Refazer feedback
- [ ] **Ler / revisar — Effective Java:** Revisão trade-offs
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 135 — Hard pattern lab: monotonic stack/queue
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão LC
- [ ] **Ler / revisar — Effective Java:** Revisão stream side effects
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Stack + Queue + Deque
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 84. Largest Rectangle in Histogram
  - [ ] 232. Implement Queue using Stacks
  - [ ] 933. Number of Recent Calls
  - [ ] 622. Design Circular Queue
  - [ ] 641. Design Circular Deque
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 136 — Hard pattern lab: shortest path variants
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão LC
- [ ] **Ler / revisar — Effective Java:** Revisão complexity narration
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 787. Cheapest Flights Within K Stops
  - [ ] 1091. Shortest Path in Binary Matrix
  - [ ] 127. Word Ladder
  - [ ] 310. Minimum Height Trees
  - [ ] 200. Number of Islands
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 137 — Hard pattern lab: union-find/trie
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão LC
- [ ] **Ler / revisar — Effective Java:** Revisão APIs
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Strings + Math + Bit
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 990. Satisfiability of Equality Equations
  - [ ] 1061. Lexicographically Smallest Equivalent String
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 211. Design Add and Search Words Data Structure
  - [ ] 212. Word Search II
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 138 — Hard pattern lab: interval DP / partition DP
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Complementar
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão LC
- [ ] **Ler / revisar — Effective Java:** Revisão memo/tab
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 97. Interleaving String
  - [ ] 139. Word Break
  - [ ] 312. Burst Balloons
  - [ ] 518. Coin Change II
  - [ ] 329. Longest Increasing Path in a Matrix
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 139 — Contest routine 1
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Prática
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Contest / virtual
- [ ] **Ler / revisar — Effective Java:** Revisão speed
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 140 — Contest routine 2
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Prática
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Contest / virtual
- [ ] **Ler / revisar — Effective Java:** Revisão speed
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 141 — Whiteboard / dry-run / verbalização
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Prática
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Simulações
- [ ] **Ler / revisar — Effective Java:** Revisão storytelling técnico
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 142 — Refatorar 10 soluções antigas
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Projeto
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Padronizar templates
- [ ] **Ler / revisar — Effective Java:** Revisão clean code
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 143 — Review sprint: weak topics C
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Refazer errados
- [ ] **Ler / revisar — Effective Java:** Revisão final de lacunas
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


### Ano 3 · Q12 — Fechamento dos 3 anos, capstone, biblioteca Java e revisão final

#### Semana 144 — Capstone: repositório final e índice por padrões
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Projeto
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão geral
- [ ] **Ler / revisar — Effective Java:** Revisão final Effective Java
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 145 — Capstone: biblioteca própria de templates Java
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Projeto
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão geral
- [ ] **Ler / revisar — Effective Java:** Revisão final generics/streams
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 146 — Capstone: notes de Big-O, trade-offs e pitfalls
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Projeto
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Revisão CLRS
- [ ] **Ler / revisar — Effective Java:** Revisão exceptions/concurrency
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 147 — Sprint final arrays/strings
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão classes/methods
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Arrays + Hashing, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 560. Subarray Sum Equals K
  - [ ] 523. Continuous Subarray Sum
  - [ ] 525. Contiguous Array
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 148 — Sprint final linked list/stack/queue
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão mutability/API
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Linked Lists
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 25. Reverse Nodes in k-Group
  - [ ] 61. Rotate List
  - [ ] 206. Reverse Linked List
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 149 — Sprint final trees/heap
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão recursion
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Trees + Heaps + balanced trees
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 98. Validate Binary Search Tree
  - [ ] 230. Kth Smallest Element in a BST
  - [ ] 235. Lowest Common Ancestor of a BST
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 150 — Sprint final graphs
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão modeling
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Grafos, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 200. Number of Islands
  - [ ] 133. Clone Graph
  - [ ] 695. Max Area of Island
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 151 — Sprint final DP/greedy
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão method signatures
- [ ] **Assistir / ler recursos do tema:** DSA geral / trilhas-base, Dynamic Programming + Greedy, Design de estruturas + entrevista
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 329. Longest Increasing Path in a Matrix
  - [ ] 1143. Longest Common Subsequence
  - [ ] 72. Edit Distance
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 152 — Sprint final design questions
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Revisão
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Top Interview 150
- [ ] **Ler / revisar — Effective Java:** Revisão data-structure design
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 153 — Mock week 1
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Mock
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Final feedback
- [ ] **Ler / revisar — Effective Java:** Revisão note-taking
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 432. All OOne Data Structure
  - [ ] 146. LRU Cache
  - [ ] 460. LFU Cache
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 154 — Mock week 2
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Mock
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Final feedback
- [ ] **Ler / revisar — Effective Java:** Revisão speed
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 460. LFU Cache
  - [ ] 981. Time Based Key-Value Store
  - [ ] 295. Find Median from Data Stream
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 155 — Mock week 3
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Mock
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Final feedback
- [ ] **Ler / revisar — Effective Java:** Revisão calm under pressure
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 295. Find Median from Data Stream
  - [ ] 355. Design Twitter
  - [ ] 208. Implement Trie (Prefix Tree)
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.

#### Semana 156 — Encerramento: retrospectiva, próximos passos e manutenção
- [ ] **Ler — Data Structures: Abstraction and Design in Java:** Retro
- [ ] **Ler — CLRS / Algoritmos: Teoria e Prática:** Plano pós-3 anos
- [ ] **Ler / revisar — Effective Java:** Revisão final
- [ ] **Assistir / ler recursos do tema:** Design de estruturas + entrevista, Concorrência, Serialização
- [ ] **Resolver LeetCode desta semana:**
  - [ ] 208. Implement Trie (Prefix Tree)
  - [ ] 380. Insert Delete GetRandom O(1)
  - [ ] 432. All OOne Data Structure
- [ ] **Entregável no Obsidian / Git:** 1 nota-resumo + 1 implementação em Java + 1 revisão de complexidade.


## Banco de LeetCode por padrão

> Os problemas abaixo formam a sua biblioteca de revisão. As semanas puxam subconjuntos desses bancos com repetição espaçada.

### arrays-hashing
- [ ] 1. Two Sum
- [ ] 217. Contains Duplicate
- [ ] 242. Valid Anagram
- [ ] 49. Group Anagrams
- [ ] 347. Top K Frequent Elements
- [ ] 238. Product of Array Except Self
- [ ] 36. Valid Sudoku
- [ ] 128. Longest Consecutive Sequence
- [ ] 271. Encode and Decode Strings
- [ ] 560. Subarray Sum Equals K
- [ ] 523. Continuous Subarray Sum
- [ ] 525. Contiguous Array

### two-pointers-window
- [ ] 125. Valid Palindrome
- [ ] 167. Two Sum II - Input Array Is Sorted
- [ ] 15. 3Sum
- [ ] 11. Container With Most Water
- [ ] 42. Trapping Rain Water
- [ ] 121. Best Time to Buy and Sell Stock
- [ ] 3. Longest Substring Without Repeating Characters
- [ ] 424. Longest Repeating Character Replacement
- [ ] 567. Permutation in String
- [ ] 76. Minimum Window Substring
- [ ] 239. Sliding Window Maximum
- [ ] 713. Subarray Product Less Than K

### linked-list
- [ ] 206. Reverse Linked List
- [ ] 21. Merge Two Sorted Lists
- [ ] 141. Linked List Cycle
- [ ] 143. Reorder List
- [ ] 19. Remove Nth Node From End of List
- [ ] 2. Add Two Numbers
- [ ] 138. Copy List with Random Pointer
- [ ] 23. Merge k Sorted Lists
- [ ] 25. Reverse Nodes in k-Group
- [ ] 61. Rotate List

### stack-queue
- [ ] 20. Valid Parentheses
- [ ] 155. Min Stack
- [ ] 150. Evaluate Reverse Polish Notation
- [ ] 739. Daily Temperatures
- [ ] 853. Car Fleet
- [ ] 84. Largest Rectangle in Histogram
- [ ] 232. Implement Queue using Stacks
- [ ] 933. Number of Recent Calls
- [ ] 622. Design Circular Queue
- [ ] 641. Design Circular Deque

### binary-search-recursion-backtracking
- [ ] 704. Binary Search
- [ ] 35. Search Insert Position
- [ ] 33. Search in Rotated Sorted Array
- [ ] 153. Find Minimum in Rotated Sorted Array
- [ ] 875. Koko Eating Bananas
- [ ] 74. Search a 2D Matrix
- [ ] 78. Subsets
- [ ] 46. Permutations
- [ ] 39. Combination Sum
- [ ] 79. Word Search
- [ ] 22. Generate Parentheses
- [ ] 51. N-Queens

### trees
- [ ] 226. Invert Binary Tree
- [ ] 104. Maximum Depth of Binary Tree
- [ ] 543. Diameter of Binary Tree
- [ ] 110. Balanced Binary Tree
- [ ] 100. Same Tree
- [ ] 572. Subtree of Another Tree
- [ ] 102. Binary Tree Level Order Traversal
- [ ] 199. Binary Tree Right Side View
- [ ] 98. Validate Binary Search Tree
- [ ] 230. Kth Smallest Element in a BST
- [ ] 235. Lowest Common Ancestor of a BST
- [ ] 105. Construct Binary Tree from Preorder and Inorder Traversal
- [ ] 124. Binary Tree Maximum Path Sum
- [ ] 297. Serialize and Deserialize Binary Tree

### heap-priority
- [ ] 703. Kth Largest Element in a Stream
- [ ] 1046. Last Stone Weight
- [ ] 215. Kth Largest Element in an Array
- [ ] 973. K Closest Points to Origin
- [ ] 621. Task Scheduler
- [ ] 295. Find Median from Data Stream
- [ ] 23. Merge k Sorted Lists
- [ ] 355. Design Twitter
- [ ] 767. Reorganize String

### hashing-maps
- [ ] 146. LRU Cache
- [ ] 981. Time Based Key-Value Store
- [ ] 205. Isomorphic Strings
- [ ] 290. Word Pattern
- [ ] 763. Partition Labels
- [ ] 380. Insert Delete GetRandom O(1)
- [ ] 49. Group Anagrams
- [ ] 525. Contiguous Array
- [ ] 438. Find All Anagrams in a String

### sorting-intervals
- [ ] 912. Sort an Array
- [ ] 75. Sort Colors
- [ ] 56. Merge Intervals
- [ ] 57. Insert Interval
- [ ] 435. Non-overlapping Intervals
- [ ] 452. Minimum Number of Arrows to Burst Balloons
- [ ] 347. Top K Frequent Elements
- [ ] 215. Kth Largest Element in an Array
- [ ] 280. Wiggle Sort

### graphs
- [ ] 200. Number of Islands
- [ ] 133. Clone Graph
- [ ] 695. Max Area of Island
- [ ] 130. Surrounded Regions
- [ ] 994. Rotting Oranges
- [ ] 417. Pacific Atlantic Water Flow
- [ ] 207. Course Schedule
- [ ] 210. Course Schedule II
- [ ] 684. Redundant Connection
- [ ] 547. Number of Provinces
- [ ] 1584. Min Cost to Connect All Points
- [ ] 743. Network Delay Time
- [ ] 787. Cheapest Flights Within K Stops
- [ ] 1091. Shortest Path in Binary Matrix
- [ ] 127. Word Ladder
- [ ] 310. Minimum Height Trees

### trie-dsu-advanced
- [ ] 208. Implement Trie (Prefix Tree)
- [ ] 211. Design Add and Search Words Data Structure
- [ ] 212. Word Search II
- [ ] 721. Accounts Merge
- [ ] 1202. Smallest String With Swaps
- [ ] 990. Satisfiability of Equality Equations
- [ ] 1061. Lexicographically Smallest Equivalent String

### dp-1d
- [ ] 70. Climbing Stairs
- [ ] 198. House Robber
- [ ] 213. House Robber II
- [ ] 322. Coin Change
- [ ] 300. Longest Increasing Subsequence
- [ ] 416. Partition Equal Subset Sum
- [ ] 494. Target Sum
- [ ] 91. Decode Ways
- [ ] 62. Unique Paths
- [ ] 55. Jump Game

### dp-2d
- [ ] 1143. Longest Common Subsequence
- [ ] 72. Edit Distance
- [ ] 115. Distinct Subsequences
- [ ] 64. Minimum Path Sum
- [ ] 221. Maximal Square
- [ ] 97. Interleaving String
- [ ] 139. Word Break
- [ ] 312. Burst Balloons
- [ ] 518. Coin Change II
- [ ] 329. Longest Increasing Path in a Matrix

### greedy-bit-math
- [ ] 45. Jump Game II
- [ ] 134. Gas Station
- [ ] 678. Valid Parenthesis String
- [ ] 135. Candy
- [ ] 136. Single Number
- [ ] 191. Number of 1 Bits
- [ ] 338. Counting Bits
- [ ] 190. Reverse Bits
- [ ] 268. Missing Number
- [ ] 371. Sum of Two Integers
- [ ] 50. Pow(x, n)
- [ ] 202. Happy Number

### strings-patterns
- [ ] 28. Find the Index of the First Occurrence in a String
- [ ] 14. Longest Common Prefix
- [ ] 5. Longest Palindromic Substring
- [ ] 647. Palindromic Substrings
- [ ] 49. Group Anagrams
- [ ] 131. Palindrome Partitioning
- [ ] 76. Minimum Window Substring
- [ ] 424. Longest Repeating Character Replacement
- [ ] 3. Longest Substring Without Repeating Characters

### design
- [ ] 146. LRU Cache
- [ ] 460. LFU Cache
- [ ] 981. Time Based Key-Value Store
- [ ] 295. Find Median from Data Stream
- [ ] 355. Design Twitter
- [ ] 208. Implement Trie (Prefix Tree)
- [ ] 380. Insert Delete GetRandom O(1)
- [ ] 432. All OOne Data Structure

### testing-exceptions
- [ ] 20. Valid Parentheses
- [ ] 155. Min Stack
- [ ] 125. Valid Palindrome
- [ ] 704. Binary Search
- [ ] 1. Two Sum
- [ ] 146. LRU Cache

### streams-lambdas
- [ ] 49. Group Anagrams
- [ ] 347. Top K Frequent Elements
- [ ] 56. Merge Intervals
- [ ] 242. Valid Anagram
- [ ] 238. Product of Array Except Self
- [ ] 128. Longest Consecutive Sequence
