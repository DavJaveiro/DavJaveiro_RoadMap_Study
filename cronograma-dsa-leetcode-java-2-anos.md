# Cronograma de 2 anos — LeetCode, Data Structures and Algorithms em Java

> Plano aprofundado de 24 meses para formar base sólida em estruturas de dados, algoritmos, resolução de problemas e entrevistas técnicas usando **Java**.
>
> Livro-base: **Data Structures: Abstraction and Design Using Java (4th ed.)**, de Elliot B. Koffman e Paul A. T. Wolfgang.

---

## Objetivo final

Ao final dos 24 meses, você deverá ser capaz de:

- implementar as principais estruturas de dados em Java do zero;
- analisar complexidade de tempo e espaço com segurança;
- reconhecer padrões clássicos de LeetCode com rapidez;
- resolver problemas de nível easy, medium e parte relevante dos hard;
- justificar trade-offs de implementação em entrevistas;
- manter uma biblioteca própria de templates e soluções em Java;
- fazer entrevistas de DSA com perfil de **pleno/sênior**.

---

## Como usar este cronograma

### Ritmo semanal padrão

- **Segunda:** leitura teórica + resumo em Obsidian
- **Terça:** implementação da estrutura/algoritmo do mês em Java
- **Quarta:** 2 problemas LeetCode focados no padrão da semana
- **Quinta:** 2 problemas LeetCode + revisão de soluções
- **Sexta:** exercício estilo PR + testes + refatoração
- **Sábado:** 1 simulado curto ou revisão espaçada
- **Domingo:** descanso ou flashcards de complexidade/padrões

### Regra de estudo para cada problema

Para cada problema, registre no Obsidian:
- enunciado resumido
- padrão identificado
- solução bruta
- solução otimizada
- complexidade de tempo e espaço
- armadilhas
- versão final em Java
- 3 aprendizados

### Estrutura do repositório
Crie um repositório chamado `java-dsa-lab` com esta organização:
```text
java-dsa-lab/
  docs/
    notes/
    complexity/
    interview-notes/
  src/
    arrays/
    strings/
    linkedlist/
    stack/
    queue/
    recursion/
    trees/
    heap/
    hash/
    sorting/
    graph/
    dp/
    greedy/
    unionfind/
    bit/
  test/
  templates/
  leetcode/
    easy/
    medium/
    hard/
```

---

## Estratégia macro dos 24 meses

## Fase 1 — Fundação técnica (Meses 1–6)
Foco em Java para DSA, ADTs, complexidade, listas, testes, stacks, queues e recursão.

## Fase 2 — Núcleo de estruturas (Meses 7–12)
Foco em árvores, heaps, hashing, maps, sorting e primeiras revisões pesadas.
## Fase 3 — Estruturas avançadas e grafos (Meses 13–18)
Foco em self-balancing trees, grafos, BFS/DFS, shortest path, topological sort, union-find, tries e padrões intermediários/avançados.

## Fase 4 — Entrevista e mastery (Meses 19–24)
Foco em dynamic programming, bit manipulation, greedy, hard problems, contests, mock interviews e revisão em espiral.

---

## Mapeamento do livro-base

### Capítulos principais do livro

- **Cap. 1:** Object-Oriented Programming and Class Hierarchies
- **Cap. 2:** Lists and the Collections Framework
- **Cap. 3:** Testing and Debugging
- **Cap. 4:** Stacks, Queues, and Deques
- **Cap. 5:** Recursion
- **Cap. 6:** Trees
- **Cap. 7:** Sets and Maps
- **Cap. 8:** Sorting
- **Cap. 9:** Self-Balancing Search Trees
- **Cap. 10:** Graphs
- **Apêndice A:** Introduction to Java

### Faixas aproximadas de leitura

> As faixas abaixo são aproximadas, pensadas para planejamento.

- Cap. 1: **p. 1–53**
- Cap. 2: **p. 54–122**
- Cap. 3: **p. 123–148**
- Cap. 4: **p. 149–212**
- Cap. 5: **p. 213–256**
- Cap. 6: **p. 257–321**
- Cap. 7: **p. 322–383**
- Cap. 8: **p. 384–427**
- Cap. 9: **p. 428–491**
- Cap. 10: **p. 492–541**

---

# Ano 1

## Mês 1 — Java para DSA, ADTs e base de complexidade

### Objetivo

Construir a base mental correta para estudar algoritmos em Java: ADTs, interfaces, OOP e noções iniciais de análise de complexidade.
### Leitura

- **Apêndice A**: revisão de Java necessária para DSA
- **Cap. 1.1–1.4**
- Faixa sugerida: **p. 1–25** + trechos do apêndice conforme lacunas
### Conteúdos

- ADT vs implementação
- interfaces, herança, polimorfismo
- classes abstratas
- generics em Java
- Big-O, Big-Theta, Big-Omega
- análise de laços simples

### Padrões LeetCode do mês

- arrays básicos
- strings básicas
- simulação
- hashing introdutório

### Meta LeetCode

- **20 problemas**
  - 12 easy
  - 8 medium

### Prática Java

- implementar `DynamicArray<T>` simplificado
- criar `ComplexityNotes.md`
- escrever testes unitários para operações básicas

### Exercícios estilo PR

- **PR 001:** criar pacote `arrays` com `DynamicArray<T>`
- **PR 002:** documentar complexidade de `add`, `get`, `set`, `remove`
- **PR 003:** refatorar código para usar interface e esconder detalhes internos

### Entrevista

- O que é um ADT?
- Qual a diferença entre array e ArrayList?
- Quando a complexidade amortizada aparece?

### Checklist

- [ ] Revisar sintaxe Java necessária para DSA
- [ ] Entender ADT vs implementação
- [ ] Dominar O(1), O(log n), O(n), O(n log n), O(n²)
- [ ] Resolver 20 problemas
- [ ] Abrir 3 PRs no repositório

---

## Mês 2 — OOP aplicado + listas e ArrayList

### Objetivo

Aprender a modelar estruturas com interfaces e classes Java, e dominar listas baseadas em array.

### Leitura

- **Cap. 1.5–1.8**
- **Cap. 2.1–2.3**
- Faixa sugerida: **p. 26–83**

### Conteúdos

- casting, `instanceof`, visibilidade
- exceções e hierarquia de classes
- packages e encapsulamento
- `List`, `ArrayList`, collections
- aplicações de listas

### Padrões LeetCode do mês

- two sum / hashing
- prefix sum básico
- array traversal
- string normalization

### Meta LeetCode

- **22 problemas**
  - 10 easy
  - 12 medium

### Prática Java

- construir `MyArrayList<T>` mais robusto
- comparar com `java.util.ArrayList`
- implementar benchmark simples com `System.nanoTime`

### Exercícios estilo PR

- **PR 004:** `MyArrayList<T>` com resize
- **PR 005:** testes de borda para índices inválidos
- **PR 006:** benchmark comparando array fixo e array dinâmico

### Entrevista

- Qual a diferença entre capacidade e tamanho?
- Por que `ArrayList` é bom para acesso por índice?
- Quando remoções no meio ficam caras?

### Checklist

- [ ] Fechar leitura do início do Cap. 2
- [ ] Implementar resize corretamente
- [ ] Fazer benchmark básico
- [ ] Resolver 22 problemas

---

## Mês 3 — Linked lists de verdade

### Objetivo

Dominar listas ligadas, ponteiros por referência em Java e diferenças práticas entre listas baseadas em array e listas encadeadas.

### Leitura

- **Cap. 2.4–2.6**
- Faixa sugerida: **p. 84–105**

### Conteúdos

- singly linked list
- doubly linked list
- circular list
- custo de inserção e remoção
- trade-offs de memória e locality

### Padrões LeetCode do mês

- linked list traversal
- fast and slow pointers
- reversal
- merge de listas

### Meta LeetCode

- **24 problemas**
  - 8 easy
  - 14 medium
  - 2 hard opcionais

### Prática Java

- implementar `SinglyLinkedList<T>`
- implementar `DoublyLinkedList<T>`
- adicionar iteradores simples

### Exercícios estilo PR

- **PR 007:** `reverse()` iterativo e recursivo
- **PR 008:** detectar ciclo com Floyd
- **PR 009:** comparação documentada: `ArrayList` vs linked list

### Entrevista

- Quando linked list é melhor que array?
- Como detectar ciclo em O(1) espaço?
- Qual o custo de inserir no início, meio e fim?

### Checklist

- [ ] Implementar lista simples e dupla
- [ ] Resolver ciclo e reverse
- [ ] Resolver 24 problemas

---

## Mês 4 — Iterators, Collections Framework e testes

### Objetivo

Aprender a usar e implementar iterators, entender design de collections e começar a estudar DSA com disciplina de testes.

### Leitura

- **Cap. 2.7–2.10**
- **Cap. 3.1–3.7**
- Faixa sugerida: **p. 106–148**

### Conteúdos

- `Iterator`, `ListIterator`, `Iterable`
- design da Collections Framework
- testes de unidade em DSA
- casos de borda
- debugging estruturado
- TDD para estruturas de dados

### Padrões LeetCode do mês

- implementação + design de estrutura
- custom iterator
- matriz básica
- busca linear vs busca binária introdutória

### Meta LeetCode

- **24 problemas**
  - 8 easy
  - 14 medium
  - 2 design

### Prática Java

- adicionar `Iterator` às listas implementadas
- criar suíte JUnit por estrutura
- criar template de testes para futuros problemas

### Exercícios estilo PR

- **PR 010:** adicionar `iterator()` nas listas
- **PR 011:** escrever testes de regressão para bugs encontrados
- **PR 012:** criar `README-testing.md` com estratégia de testes

### Entrevista

- Como você testaria uma estrutura de dados customizada?
- O que é um caso de borda clássico em listas?
- Quando TDD ajuda em algoritmos?

### Checklist

- [ ] Estruturas cobertas por testes
- [ ] Template de JUnit pronto
- [ ] Resolver 24 problemas

---

## Mês 5 — Stacks e expressões

### Objetivo

Dominar stack como ADT e reconhecer problemas que dependem de LIFO, parsing e validação de estruturas.

### Leitura

- **Cap. 4.1–4.4**
- Faixa sugerida: **p. 149–180**

### Conteúdos

- stack ADT
- implementação com array e lista ligada
- parênteses balanceados
- postfix / infix / parsing
- monotonic stack introdutória

### Padrões LeetCode do mês

- stack clássica
- monotonic stack básica
- valid parentheses
- next greater element

### Meta LeetCode

- **24 problemas**
  - 6 easy
  - 16 medium
  - 2 hard opcionais

### Prática Java

- `ArrayStack<T>`
- `LinkedStack<T>`
- avaliador de expressão postfix

### Exercícios estilo PR

- **PR 013:** implementar duas stacks e comparar trade-offs
- **PR 014:** parser simples de expressões
- **PR 015:** resolver 5 problemas com monotonic stack e registrar padrões

### Entrevista

- Quando usar stack em vez de recursão explícita?
- O que é monotonic stack?
- Como converter infix para postfix?

### Checklist

- [ ] Implementar stack por array e lista
- [ ] Resolver 24 problemas
- [ ] Explicar monotonic stack sem consultar anotações

---

## Mês 6 — Queues, deques e primeiros simulados

### Objetivo

Entender fila, deque, circular array e como reconhecer problemas FIFO e problemas de janela.

### Leitura

- **Cap. 4.5–4.8**
- **Cap. 5.1–5.2**
- Faixa sugerida: **p. 181–227**

### Conteúdos

- queue ADT
- deque
- circular queue
- BFS como aplicação de fila
- introdução forte à recursão

### Padrões LeetCode do mês

- queue
- deque
- sliding window básica
- BFS em árvore e grade básica

### Meta LeetCode

- **24 problemas**
  - 6 easy
  - 16 medium
  - 2 hard opcionais

### Prática Java

- `CircularQueue<T>`
- `Deque<T>` simplificada
- simulador de filas com métricas básicas

### Exercícios estilo PR

- **PR 016:** circular queue com resize
- **PR 017:** deque com testes de limite
- **PR 018:** primeiro simulado de 60 minutos com 3 questões

### Entrevista

- Qual a diferença entre queue e deque?
- Como implementar fila circular?
- O que muda entre BFS e DFS em termos de estrutura auxiliar?

### Checklist

- [ ] Implementar queue e deque
- [ ] Fazer 1 simulado cronometrado
- [ ] Resolver 24 problemas

---

## Mês 7 — Recursão, busca e backtracking

### Objetivo

Dominar recursão, stack frames, busca binária recursiva e primeiros problemas de backtracking.

### Leitura

- **Cap. 5.3–5.6**
- Faixa sugerida: **p. 228–256**

### Conteúdos

- recursive search
- binary search
- recursive data structures
- backtracking
- poda e árvore de decisão

### Padrões LeetCode do mês

- binary search
- subsets
- permutations
- backtracking em matriz

### Meta LeetCode

- **26 problemas**
  - 4 easy
  - 18 medium
  - 4 hard opcionais

### Prática Java

- template de backtracking
- biblioteca de `binarySearch` variants
- gerar subconjuntos e permutações

### Exercícios estilo PR

- **PR 019:** `BinarySearchVariants.java`
- **PR 020:** `BacktrackingTemplates.java`
- **PR 021:** documentação de heurísticas de poda

### Entrevista

- Como decidir entre iteração e recursão?
- O que torna um problema de backtracking?
- Como evitar recomputação desnecessária?

### Checklist

- [ ] Ter template de binary search
- [ ] Ter template de backtracking
- [ ] Resolver 26 problemas

---

## Mês 8 — Árvores e traversals

### Objetivo

Construir intuição forte em árvores, travessias e modelagem de problemas hierárquicos.

### Leitura

- **Cap. 6.1–6.4**
- Faixa sugerida: **p. 257–295**

### Conteúdos

- terminologia de árvores
- binary trees
- traversals: preorder, inorder, postorder, level order
- implementação de `BinaryTree<E>`
- introdução a lambdas funcionais no contexto do livro

### Padrões LeetCode do mês

- DFS em árvore
- BFS em árvore
- recursion on tree
- divide and conquer em árvore

### Meta LeetCode

- **26 problemas**
  - 4 easy
  - 18 medium
  - 4 hard opcionais

### Prática Java

- implementar `BinaryTree<T>`
- versões recursiva e iterativa de traversals
- serialização simples de árvore

### Exercícios estilo PR

- **PR 022:** traversals iterativos usando stack
- **PR 023:** level-order com queue
- **PR 024:** serializer/deserializer simples de árvore binária

### Entrevista

- Qual traversal usar para serializar uma árvore?
- Como transformar DFS recursiva em iterativa?
- O que muda entre altura, profundidade e nível?

### Checklist

- [ ] Dominar 4 traversals principais
- [ ] Resolver 26 problemas
- [ ] Conseguir resolver árvore sem desenhar demais

---

## Mês 9 — BST, heaps, priority queue e Huffman

### Objetivo

Dominar BST e heaps, entendendo quando usar árvore de busca ou heap.

### Leitura

- **Cap. 6.5–6.7**
- Faixa sugerida: **p. 296–321**

### Conteúdos

- BST
- operações de insert/search/delete
- heap binário
- priority queue
- Huffman tree

### Padrões LeetCode do mês

- BST operations
- kth smallest/largest
- heap / top-k
- merge k structures

### Meta LeetCode

- **26 problemas**
  - 4 easy
  - 18 medium
  - 4 hard opcionais

### Prática Java

- `BinarySearchTree<T>`
- `BinaryHeap<T>`
- min-heap e max-heap com comparador

### Exercícios estilo PR

- **PR 025:** `BinarySearchTree<T>` com remoção correta
- **PR 026:** heap do zero sem `PriorityQueue`
- **PR 027:** top-k frequent usando heap

### Entrevista

- Quando usar BST e quando usar heap?
- Por que heap não serve bem para busca arbitrária?
- Qual a complexidade de remover na BST?

### Checklist

- [ ] Implementar BST e heap
- [ ] Resolver 26 problemas
- [ ] Dominar top-k em Java

---

## Mês 10 — Sets, maps e hashing

### Objetivo

Dominar hashing, colisão, implementação de hash tables e uso de maps/sets em problemas de entrevista.

### Leitura

- **Cap. 7.1–7.4**
- Faixa sugerida: **p. 322–360**

### Conteúdos

- set e map interfaces
- hash functions
- open addressing
- chaining
- implementação de hash map

### Padrões LeetCode do mês

- hash map counting
- prefix sum + hash
- group anagrams
- frequency maps

### Meta LeetCode

- **28 problemas**
  - 4 easy
  - 20 medium
  - 4 hard opcionais

### Prática Java

- `MyHashMap<K,V>`
- `MyHashSet<T>`
- resolver problemas sem depender demais de API pronta

### Exercícios estilo PR

- **PR 028:** hash map por chaining
- **PR 029:** hash map por open addressing
- **PR 030:** documento comparando colisão e load factor

### Entrevista

- O que é colisão?
- Qual a diferença entre chaining e open addressing?
- Quando hash piora para O(n)?

### Checklist

- [ ] Implementar hash map
- [ ] Resolver 28 problemas
- [ ] Explicar load factor e rehash

---

## Mês 11 — Maps avançados, ordered maps e revisão do ano

### Objetivo

Ampliar o uso de maps/sets, entender ordered structures e revisar todas as estruturas lineares e hashing.

### Leitura

- **Cap. 7.5–7.7**
- Faixa sugerida: **p. 361–383**

### Conteúdos

- `hashCode` e `equals`
- adapters
- `TreeMap`, `TreeSet`
- navigable maps
- revisão de array, list, stack, queue, hash

### Padrões LeetCode do mês

- interval scheduling básico
- ordered set/map
- sweep line introdutória
- design de estrutura

### Meta LeetCode

- **28 problemas**
  - 4 easy
  - 20 medium
  - 4 hard opcionais

### Prática Java

- custom key com `equals/hashCode`
- ordered map cases
- revisão pesada das estruturas já implementadas

### Exercícios estilo PR

- **PR 031:** corrigir e padronizar `equals/hashCode`
- **PR 032:** ordered index com `TreeMap`
- **PR 033:** refatoração geral do repositório do ano 1

### Entrevista

- O que acontece se `equals` e `hashCode` forem inconsistentes?
- Quando `TreeMap` é melhor que `HashMap`?
- Qual a complexidade esperada de cada operação?

### Checklist

- [ ] Entender `equals/hashCode`
- [ ] Resolver 28 problemas
- [ ] Refatorar repositório

---

## Mês 12 — Sorting I: básicos, merge, shell, comparação

### Objetivo

Dominar algoritmos de ordenação clássicos e a linguagem de trade-offs entre estabilidade, espaço extra e melhor/pior caso.

### Leitura

- **Cap. 8.1–8.6**
- Faixa sugerida: **p. 384–410**

### Conteúdos

- sort da biblioteca Java
- selection sort
- insertion sort
- shell sort
- merge sort
- estabilidade

### Padrões LeetCode do mês

- sorting-based problems
- merge intervals
- counting inversions
- divide and conquer

### Meta LeetCode

- **28 problemas**
  - 2 easy
  - 22 medium
  - 4 hard opcionais

### Prática Java

- implementar selection, insertion, shell e merge sort
- medir performance com inputs diversos
- comparar ordenações estáveis e instáveis

### Exercícios estilo PR

- **PR 034:** pacote `sorting/basic`
- **PR 035:** benchmark entre algoritmos
- **PR 036:** relatório sobre estabilidade e cenários ideais

### Entrevista

- Qual a diferença entre merge sort e quicksort?
- O que é algoritmo estável?
- Quando insertion sort ainda faz sentido?

### Checklist

- [ ] Implementar 4 sorts
- [ ] Resolver 28 problemas
- [ ] Fazer benchmark comparativo

---

# Ano 2

## Mês 13 — Sorting II: Timsort, heapsort, quicksort, testes

### Objetivo

Fechar sorting com visão de entrevista e também visão prática de bibliotecas e produção.

### Leitura

- **Cap. 8.7–8.11**
- Faixa sugerida: **p. 411–427**

### Conteúdos

- Timsort
- heapsort
- quicksort
- Dutch National Flag
- testes de algoritmos de ordenação

### Padrões LeetCode do mês

- quickselect
- partitioning
- k-th element
- intervalos + ordenação

### Meta LeetCode

- **28 problemas**
  - 2 easy
  - 22 medium
  - 4 hard

### Prática Java

- implementar `QuickSort`, `HeapSort`, `QuickSelect`
- estudar partição de Lomuto e Hoare
- montar tabela de trade-offs

### Exercícios estilo PR

- **PR 037:** `QuickSort.java`
- **PR 038:** `QuickSelect.java`
- **PR 039:** resolver Dutch National Flag do zero

### Entrevista

- Por que quicksort costuma ser rápido na prática?
- O que é quickselect?
- Como resolver partições em in-place?

### Checklist

- [ ] Fechar sorting do livro
- [ ] Resolver 28 problemas
- [ ] Conseguir explicar Timsort em alto nível

---

## Mês 14 — Self-balancing trees I: balance, rotation e AVL

### Objetivo

Aprender por que árvores precisam de balanceamento e dominar rotações e AVL.

### Leitura

- **Cap. 9.1–9.2**
- Faixa sugerida: **p. 428–455**

### Conteúdos

- balanceamento
- rotações simples e duplas
- AVL tree
- invariantes estruturais

### Padrões LeetCode do mês

- balanced tree checks
- BST validation
- ordered data structures
- augmented trees conceitualmente

### Meta LeetCode

- **30 problemas**
  - 2 easy
  - 24 medium
  - 4 hard

### Prática Java

- implementar rotação esquerda/direita
- implementar `AVLTree<T>`
- testes de invariantes

### Exercícios estilo PR

- **PR 040:** rotações isoladas com testes visuais
- **PR 041:** `AVLTree<T>` com inserção
- **PR 042:** utilitário para imprimir árvores em ASCII

### Entrevista

- Por que BST comum degrada?
- Como rotação preserva ordenação?
- Qual a altura esperada da AVL?

### Checklist

- [ ] Entender rotações sem decorar cegamente
- [ ] Implementar AVL parcial ou completa
- [ ] Resolver 30 problemas

---

## Mês 15 — Self-balancing trees II: red-black, B-trees e busca ordenada

### Objetivo

Conhecer as estruturas balanceadas mais importantes para entrevistas e sistemas reais.

### Leitura

- **Cap. 9.3–9.5**
- Faixa sugerida: **p. 456–491**

### Conteúdos

- red-black tree
- 2-3 trees
- B-trees / B+ trees
- relação com `TreeMap`/`TreeSet`
- noção de estruturas para disco

### Padrões LeetCode do mês

- ordered set problems
- interval queries
- BST advanced
- rank/select conceitual

### Meta LeetCode

- **30 problemas**
  - 2 easy
  - 24 medium
  - 4 hard

### Prática Java

- estudar invariantes de red-black sem obsessão de implementação total
- implementar versões simplificadas ou ao menos rotações e recoloring em exercícios

### Exercícios estilo PR

- **PR 043:** nota técnica comparando AVL vs Red-Black
- **PR 044:** mini implementação guiada de RB insertion ou simulação
- **PR 045:** resumo sobre B-tree e B+ tree para entrevistas

### Entrevista

- AVL vs Red-Black: qual escolher?
- Onde B-trees aparecem na prática?
- Por que B+ tree é útil para storage/indexação?

### Checklist

- [ ] Fechar árvores balanceadas do livro
- [ ] Resolver 30 problemas
- [ ] Saber explicar B-tree em linguagem simples

---

## Mês 16 — Grafos I: modelagem, representações, BFS e DFS

### Objetivo

Aprender a pensar em problemas como grafos e dominar as representações clássicas.

### Leitura

- **Cap. 10.1–10.4**
- Faixa sugerida: **p. 492–520**

### Conteúdos

- terminologia de grafos
- directed vs undirected
- adjacency list vs adjacency matrix
- BFS
- DFS

### Padrões LeetCode do mês

- graph traversal
- island problems
- connected components
- grid BFS/DFS

### Meta LeetCode

- **30 problemas**
  - 2 easy
  - 24 medium
  - 4 hard

### Prática Java

- `Graph` interface
- `AdjListGraph`
- `AdjMatrixGraph`
- BFS/DFS iterativa e recursiva

### Exercícios estilo PR

- **PR 046:** interface de grafo + duas implementações
- **PR 047:** BFS e DFS em grafo e grid
- **PR 048:** comparação de memória e custo entre as representações

### Entrevista

- Quando usar adjacency list e adjacency matrix?
- Diferença entre BFS e DFS?
- Como detectar componentes conexas?

### Checklist

- [ ] Implementar grafos do zero
- [ ] Resolver 30 problemas
- [ ] Saber modelar grid como grafo

---

## Mês 17 — Grafos II: topological sort, shortest path, MST e A*

### Objetivo

Dominar os algoritmos de grafo mais recorrentes em entrevista intermediária/avançada.

### Leitura

- **Cap. 10.5–10.7**
- Faixa sugerida: **p. 521–541**

### Conteúdos

- topological sort
- shortest path
- Dijkstra
- MST
- A*

### Padrões LeetCode do mês

- topological sort
- shortest path
- Dijkstra
- heap + graph
- union-find introdutório

### Meta LeetCode

- **30 problemas**
  - 2 easy
  - 22 medium
  - 6 hard

### Prática Java

- `Dijkstra.java`
- `TopologicalSort.java`
- `UnionFind.java` (suplementar)

### Exercícios estilo PR

- **PR 049:** Dijkstra com `PriorityQueue`
- **PR 050:** Kahn + DFS topological sort
- **PR 051:** Union-Find com path compression e union by rank

### Entrevista

- Quando BFS resolve shortest path e quando não resolve?
- O que é topological sort?
- Como Union-Find ajuda em grafos?

### Checklist

- [ ] Fechar livro-base inteiro
- [ ] Resolver 30 problemas
- [ ] Ter templates prontos de grafos

---

## Mês 18 — Tries, Union-Find e padrões fora do livro

### Objetivo

Cobrir padrões que o livro não aprofunda, mas que aparecem bastante em LeetCode e entrevistas.

### Leitura complementar

- revisão das anotações do livro
- estudo suplementar de **Trie**, **Union-Find**, **Monotonic Queue**, **Intervals**

### Conteúdos

- trie
- disjoint set union
- monotonic queue
- merge intervals
- sweep line introdutória

### Padrões LeetCode do mês

- trie
- union-find
- intervals
- monotonic queue

### Meta LeetCode

- **32 problemas**
  - 2 easy
  - 24 medium
  - 6 hard

### Prática Java

- `Trie.java`
- revisão de `UnionFind.java`
- `IntervalProblems.md`

### Exercícios estilo PR

- **PR 052:** trie com insert/search/prefix
- **PR 053:** union-find aplicado em componentes
- **PR 054:** 10 problemas de intervalos categorizados por padrão

### Entrevista

- Quando trie vale a pena?
- Quando union-find é melhor que DFS/BFS?
- Como reconhecer problema de intervalos?

### Checklist

- [ ] Cobrir padrões fora do livro
- [ ] Resolver 32 problemas
- [ ] Consolidar biblioteca própria de templates

---

## Mês 19 — Dynamic Programming I

### Objetivo

Entrar em DP com método, sem pular direto para fórmulas decoradas.

### Conteúdos

- memoization
- tabulation
- 1D DP
- knapsack básico
- LIS introdutório
- house robber, climbing stairs, coin change

### Padrões LeetCode do mês

- 1D DP
- decision DP
- counting DP
- linear recurrence

### Meta LeetCode

- **32 problemas**
  - 4 easy
  - 22 medium
  - 6 hard

### Prática Java

- `dp/one_dimensional/`
- template memo vs tabulation
- documento de transição de estados

### Exercícios estilo PR

- **PR 055:** coleção de templates DP
- **PR 056:** comparar memoization e tabulation em 5 problemas
- **PR 057:** guia “como descobrir o estado”

### Entrevista

- Como saber se um problema é DP?
- Quando usar memoization?
- Como definir estado, transição e base case?

### Checklist

- [ ] Ter template padrão de DP
- [ ] Resolver 32 problemas
- [ ] Explicar DP sem falar só “subproblemas”

---

## Mês 20 — Dynamic Programming II

### Objetivo

Avançar para DP em strings, grade, subsequência e estados mais difíceis.

### Conteúdos

- 2D DP
- LCS
- edit distance
- interval DP introdutória
- DP em grid
- partition DP introdutória

### Padrões LeetCode do mês

- string DP
- subsequence DP
- grid DP
- interval DP

### Meta LeetCode

- **32 problemas**
  - 2 easy
  - 22 medium
  - 8 hard

### Prática Java

- `dp/two_dimensional/`
- `dp/strings/`
- folha de complexidade por estado

### Exercícios estilo PR

- **PR 058:** LCS e edit distance do zero
- **PR 059:** grid DP pack
- **PR 060:** revisão comentada de 8 problemas difíceis de DP

### Entrevista

- Como reduzir memória em DP?
- Quando vale usar rolling array?
- Qual a diferença entre subsequence e substring em DP?

### Checklist

- [ ] Resolver 32 problemas
- [ ] Dominar ao menos 8 problemas clássicos de DP
- [ ] Revisar os erros recorrentes

---

## Mês 21 — Greedy, bit manipulation e matemática

### Objetivo

Cobrir blocos que costumam separar o nível intermediário do avançado em entrevistas.

### Conteúdos

- greedy choice
- interval scheduling
- jump game family
- bit manipulation
- XOR patterns
- gcd/lcm, primalidade, modularidade básica

### Padrões LeetCode do mês

- greedy
- bit
- math
- scheduling

### Meta LeetCode

- **32 problemas**
  - 4 easy
  - 22 medium
  - 6 hard

### Prática Java

- `bit/BitTemplates.java`
- `greedy/GreedyPatterns.md`
- problemas de otimização com prova intuitiva

### Exercícios estilo PR

- **PR 061:** templates de bitwise em Java
- **PR 062:** catálogo de greedy proofs intuitivas
- **PR 063:** conjunto de 12 problemas math/bit comentados

### Entrevista

- Como justificar greedy?
- Quando XOR simplifica o problema?
- Como detectar padrão de bit manipulation?

### Checklist

- [ ] Resolver 32 problemas
- [ ] Saber explicar por que uma solução greedy é correta
- [ ] Dominar operações bit a bit em Java

---

## Mês 22 — Design de estruturas e timed sets

### Objetivo

Treinar problemas onde você precisa desenhar a estrutura de dados certa, não só aplicar algoritmo conhecido.

### Conteúdos

- LRU/LFU conceitualmente
- min stack
- randomized set
- median finder
- autocomplete básico com trie/heap
- time-based key-value store

### Padrões LeetCode do mês

- design
- hash + linked list
- heap dual
- ordered map

### Meta LeetCode

- **34 problemas**
  - 2 easy
  - 24 medium
  - 8 hard

### Prática Java

- pacote `design/`
- timed sets de 45 e 90 minutos
- refatorações focadas em API clean

### Exercícios estilo PR

- **PR 064:** LRU cache do zero
- **PR 065:** median finder com dois heaps
- **PR 066:** documentar trade-offs de pelo menos 5 problemas de design

### Entrevista

- Como desenhar uma LRU cache?
- Por que dois heaps resolvem median stream?
- Como escolher a combinação de estruturas?

### Checklist

- [ ] Resolver 34 problemas
- [ ] Fazer 4 timed sets no mês
- [ ] Escrever trade-offs com clareza

---

## Mês 23 — Entrevistas brancas, revisão em espiral e hard problems

### Objetivo

Treinar performance real de entrevista: identificar padrão rápido, comunicar raciocínio e corrigir bugs sob pressão.

### Conteúdos

- revisão espiral de todos os temas
- timed interviews
- dry run em voz alta
- debugging rápido
- revisão de templates

### Padrões LeetCode do mês

- mistura total
- weak spots pessoais
- hard de grafos, DP e design

### Meta LeetCode

- **34 problemas**
  - 4 medium
  - 24 medium fortes
  - 6 hard pesados

### Prática Java

- 2 mocks por semana
- gravação de resolução em voz alta
- revisar soluções antigas e reescrever sem consultar

### Exercícios estilo PR

- **PR 067:** `interview-templates/` consolidado
- **PR 068:** corrigir 10 soluções antigas com código mais limpo
- **PR 069:** documento “meus 20 erros mais comuns em entrevistas”

### Entrevista

- Como você comunica trade-offs?
- Como reage quando trava?
- Como valida a solução antes de codar?

### Checklist

- [ ] Fazer ao menos 8 mocks no mês
- [ ] Resolver 34 problemas
- [ ] Revisar os temas com pior taxa de acerto

---

## Mês 24 — Fechamento, Top Interview 150 e preparação final

### Objetivo

Fechar o ciclo com revisão final, alta consistência e ritmo de entrevista.

### Conteúdos

- revisão final do livro-base
- revisão final de templates
- bater listas curadas oficiais
- consolidar biblioteca de soluções Java
- preparar rounds reais

### Meta LeetCode

- **36 problemas**
  - foco em **Top Interview 150** e revisão da **LeetCode 75**
  - re-solução de problemas importantes sem olhar resposta

### Prática Java

- limpar todo o repositório
- padronizar nomenclatura
- finalizar README principal
- criar índice por padrões

### Exercícios estilo PR

- **PR 070:** README final do repositório
- **PR 071:** tabela geral de templates e complexidades
- **PR 072:** “interview cheat sheet” final em Java

### Entrevista

- resolver 1 easy + 1 medium em 45 minutos
- resolver 2 mediums em 60–75 minutos
- justificar complexidade sem hesitar
- escrever código legível e testável

### Checklist

- [ ] Resolver 36 problemas
- [ ] Revisar LeetCode 75
- [ ] Revisar Top Interview 150
- [ ] Fechar repositório final

---

# Metas quantitativas do plano

## Meta total de problemas

**680 problemas** ao longo de 24 meses.

### Distribuição recomendada

- **Easy:** 110–140
- **Medium:** 440–480
- **Hard:** 60–100

## Meta de simulados

- Meses 1–6: **1 simulado/mês**
- Meses 7–12: **2 simulados/mês**
- Meses 13–18: **3 simulados/mês**
- Meses 19–24: **1–2 mocks/semana**

## Meta de revisões

- revisão 24h
- revisão 7 dias
- revisão 30 dias
- revisão trimestral por tema

---

# Padrões que você deve dominar até o fim

## Arrays e Strings

- two pointers
- sliding window
- prefix sum
- hashing
- binary search em resposta
- sorting + scan

## Estruturas lineares

- linked list
- stack
- queue
- deque
- monotonic stack
- monotonic queue

## Árvores

- DFS recursiva
- DFS iterativa
- BFS
- BST
- heap
- trie
- balanced tree em alto nível

## Grafos

- BFS/DFS
- topological sort
- union-find
- Dijkstra
- MST
- shortest path em grid

## Paradigmas

- recursion
- backtracking
- divide and conquer
- greedy
- dynamic programming

## Outros

- intervals
- bit manipulation
- math patterns
- design de data structures

---

# Blocos de revisão trimestral

## Revisão ao final de cada trimestre

### Trimestre 1

- arrays
- ArrayList
- linked list
- Big-O

### Trimestre 2

- iterators
- testing
- stack
- queue
- recursion

### Trimestre 3

- trees
- BST
- heap
- hashing

### Trimestre 4

- maps/sets
- sorting
- design trade-offs

### Trimestre 5

- balanced trees
- graph basics
- BFS/DFS

### Trimestre 6

- shortest path
- topological sort
- union-find
- trie

### Trimestre 7

- DP
- greedy
- bit
- math

### Trimestre 8

- design questions
- timed mocks
- revisão total

---

# Modelo de nota por problema no Obsidian

```markdown
# [LC-XXXX] Nome do problema

## Tema
- array / graph / dp / etc.

## Padrão
- sliding window / bfs / memoization / etc.

## Dificuldade
- easy / medium / hard

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

---

# Critérios de evolução

## Você pode avançar de fase quando:

### Fundação → Núcleo
- resolve easy sem travar em implementação
- consegue implementar stack, queue e linked list do zero
- explica Big-O com segurança

### Núcleo → Estruturas avançadas
- resolve medium de árvore, heap e hash com regularidade
- faz BFS/DFS sem olhar template toda hora
- já consegue corrigir bugs sozinho com teste

### Estruturas avançadas → Mastery
- resolve mediums em 20–35 min
- já fechou grafos principais e primeira leva de DP
- consegue discutir trade-offs de design

---

# Ordem de prioridade quando faltar tempo

Se o tempo apertar, mantenha esta ordem:

1. **mediums clássicos**
2. **revisão dos problemas errados**
3. **templates Java próprios**
4. **mocks cronometrados**
5. **hard problems**

---

# Fechamento

Este plano foi desenhado para transformar estudo de DSA em um processo de longo prazo, com três pilares:

- **teoria sólida pelo livro-base**;
- **implementação real em Java**;
- **repetição deliberada via LeetCode**.

Se você seguir este cronograma com consistência, ao final de 24 meses terá:

- repertório forte de estruturas e algoritmos;
- confiança em Java para entrevistas;
- biblioteca própria de soluções;
- boa maturidade para processos seletivos sérios.

