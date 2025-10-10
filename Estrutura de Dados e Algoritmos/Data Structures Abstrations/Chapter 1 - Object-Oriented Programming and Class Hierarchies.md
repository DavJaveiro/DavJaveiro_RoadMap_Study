# Preface
Nosso objetivo ao escrever este livro foi combinar uma forte ênfase em resolução de problemas, análise, projeto e teste de programas com o estudo de estruturas de dados. Para isso, discutimos aplicações de cada estrutura de dados para motivar seu estudo. Após fornecer a especificação (interface) e a implementação (uma classe Java), abordamos estudos de caso que usam a estrutura de dados para resolver um problema significativo. Exemplos incluem manter uma lista ordenada, avaliar expressões aritméticas usando uma pilha, gerenciar uma lista de contatos de celular, encontrar o caminho mais curto através de um labirinto, encontrar a rota mais curta para um destino e a codificação de Huffman usando uma árvore binária e uma fila de propriedades.

Na implementação de cada estrutura de dados e nas soluções dos estudos de caso, reforçamos a mensagem "Pense, depois codifique" realizando uma análise completa do problema e, em seguida, projetando cuidadosamente uma solução (usando pseudocódigo e diagramas de classe UML) antes da implementação. Também fornecemos uma análise de desempenho quando apropriado e exemplos de como testar o código desenvolvido no texto.

Os leitores obtêm uma compreensão do porquê diferentes estruturas de dados são necessárias, das aplicações para as quais são adequadas e das vantagens e desvantagens de suas possíveis implementações.

**Ênfase no Java Collections Framework**
O livro foca nas interfaces e classes do Java Collection Framework. Iniciamos o estudo de uma nova estrutura de dados especificando um **tipo abstrato de dados (TAD)** como uma interface, que adaptamos da API Java. Os leitores são incentivados ao longo do texto a usar o Java Collections Framework como um recurso para sua programação.

Queremos que nossos leitores entendam como usar as classes da API Java em sua própria programação e compreendam como esses classes são implementadas. Cada implementação de classe no texto segue a abordagem adotada pelos designers do Java, quando apropriado. No entanto, quando suas soluções de "força industrial" parecem muito complicadas para iniciantes entenderem, fornecemos implementações mais simples, mas tentando ser fiéis à abordagem deles.

**Pense, Depois Codifique**
Para ajudar a "Pensar, depois Codificar", discutimos a resolução de problemas e introduzimos ferramentas de design de software apropriadas ao longo do livro-texto. A maioria das ferramentas para OOD é fornecida nos três primeiros capítulos e aplicada em todo o livro.

Por exemplo, o Capítulo 1 foca em OOD e Hierarquias de Classes. Ele introduz a UML, trada também no **Apêndice B**, para documentar um projeto OOD. Introduz o uso de interfaces para especificar tipos abstratos de dados (TAD) e facilitar a programação por contrato, e descreve como documentar classes usando comentários no estilo Javadoc. Há também cobertura de exceções e tratamento de exceções.

O capítulo 2 começa com uma discussão sobre análise de algoritmos e ilustra como usar a notação Big O para comparar o desempenho de diferentes algoritmos. Também introduz o Java Collections Framework e foca na interface List. Discute as implementações *ArrayList* e *LinkedList* desta interface e mostra como elas podem ser usadas para implementar listas simplesmente encadeadas, duplamente encadeadas e listas ordenadas.

No Capítulo 3, cobrimos diferentes estratégias de teste e depuração. Mostramos como rastrear a execução do programa inserindo instruções de saídas extras e também usando um programa debugger em duas IDES. Também discutimos o uso da plataforma JUnit para escrever classes de teste. Por fim, demonstramos como usar o **test-driven design** como uma técnica para o desenvolvimento de programas.

# Object-Oriented Programming and Class Hierarchies

**Chapter Objectives**
- To learn about interfaces and their role in Java
- To understand inheritance and how it facilitates code reuse
- To understand how Java determines which method to execute when there are multiple methods with the same name in a class hierarchy
- To become familiar with the *Exception* class hierarchy and the difference between checked and unchecked exception