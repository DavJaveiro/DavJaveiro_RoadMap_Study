*Chapter Objectives*
- To understand the meaning (significado) of big-O notation and how it is used as a measure of an algorithm's efficiency;
- To become familiar with the List interface and the Java Collections Framework
- To understand how to write an array-based implementation of the #List interface
- To study the differences between single-, double-, and circular-linked list data structures
- To learn how to implement a single-linked list
- To learn how to implement the List interface using a double-linked list
- To understand the #Iterator interface
- To learn how to implement the #Iterator for a linked list
- To become familiar with the Java Collections Framework

So far, we have one data structure that we can use in our programming- the #array. Giving a programmer an array and asking her to develop software systems is like giving a carpenter a hammer and asking him to build a house.  In both cases, more tools are needed. The Java designers attempted to supply those tools by <span style="background:#b1ffff">providing a rich set of data structures written as Java classes</span>. The classes are all part of a hierarchy called the <span style="background:#ff4d4f">Java Collection Framework</span>. We will discuss classes from this hierarchy in the rest of the book, starting in this chapter with the classes that are considered lists.

<span style="background:#40a9ff">A list is an expandable collection of elements in which each element has a position or index</span>. Some lists enable their elements to be accessed in arbitrary order (called *random access*) using a position value to select an element. Alternatively, we can start at the beginning and process the elements in sequence. We will also discuss iterators and their role in facilitating sequential access to lists.

In this chapter, we will discuss the #ArrayList and #linked-list (class #LikedList) and their similarities and differences. We will show that these classes are subclasses of the abstract class #AbstractList and that they implement the #List interface.

First, we will discuss algorithm efficiency and how to characterize the efficiency of an algorithm. We will learn about big-O notation, which we can use to compare the relative efficiency of different algorithms.

## 2.1 Algorithm Efficiency and Big-O
Sempre que escrevemos uma nova classe, discutiremos a eficiência de seus métodos para que saibamos como eles se comparam a métodos similares em outras classes. Não conseguimos medir facilmente a quantidade de tempo que leva para rodar um programa em computadores modernos. Quando emitimos o comando *java MeuPrograma* (ou clicamos no botão Executar dentro do nosso ambiente de desenvolvimento integrado [IDE]), o sistema operacional primeiro carrega a Máquina Virtual Java (JVM). A JVM então carrega o arquivo .class do *MeuPrograma*, carrega outros arquivos .class que o *MeuPrograma* referencia e, finalmente, o nosso programa é executado.  (Se os arquivos .class ainda não tiverem sido criados, a IDE Java compilará o arquivo fonte antes de executar o programa). A maior parte do tempo necessário para o nosso programa é ocupada pelos dois primeiros passos. Se rodarmos o nosso programa uma segunda vez imediatamente após a primeira execução, pode parecer que leva menos tempo. Isso acontece porque o sistema operacional pode ter mantido os arquivos em uma área de memória local chamada #cache. No entanto, se tivermos um problema grande ou complicado o suficiente, o tempo real de execução do nosso programa dominará o tempo necessário para carregar a JVM e os arquivos *.class*. 

Como é muito difícil obter uma medida precisa da performance de um algoritmo ou programa, normalmente tentamos aproximar o efeito de uma mudança no número de itens de dados, *n*, que um algoritmo processa. Dessa forma, podemos ver como o tempo de execução de um algoritmo aumenta em relação a *n*, para que possamos comparar dois algoritmos examinando suas taxas de crescimento. 

Para muitos problemas, existem algoritmos que são relativamente óbvios, mas ineficientes. Embora os computadores estejam ficando mais rápidos a cada dia, com memórias maiores, existem algoritmos cuja taxa de crescimento é tão grande que nenhum computador, não importa quão rápido ou com quanta memória, consegue resolver o problema acima de um certo tamanho. Além disso, se um problema que era grande demais para ser resolvido agora pode ser solucionado com o supercomputador mais recente, maior e mais rápido, adicionar apenas mais algumas entradas pode tornar o problema impraticável, se não impossível, novamente. Portanto, é importante ter alguma ideia da eficiência relativa de diferentes algoritmos. A seguir, veremos como podemos obter tal ideia examinando três métodos nos exemplos seguintes.

### Exemplos 2.1- Considere o seguinte método, que pesquisa um valor em um array:
![[example2_1.java]]

Se o alvo não estiver presente no array, o corpo do loop *for* será executado *x.length* vezes. Se o alvo estiver presente, ele pode estar em qualquer lugar. Se considerarmos a média de todos os casos onde o alvo está presente, então o corpo do loop será executado *x.length/2* vezes. Portanto, o tempo total de execução é diretamente proporcional a *x.length*. Se dobrássemos o tamanho do array, esperaríamos que o tempo dobrasse (sem contar o overhead). 

*Insights*
- **A ilusão do `System.out.currentTimeMillis():`:** o texto menciona a dificuldade de medir tempo devido ao carregamento da JVM. Em Java, benchmarking real requer "aquecimento" da JVM (Warnup) para que o compilador JIT (Just-In-Time) otimize o código. Para entrevistas e LeetCode, ingoramos o tempo de relógio e focamos puramente na Complexidade de Tempo (Big-O). Em sistemas reais, usaríamos ferramentas como JMH (Java Microbenchmark Harness) e não o **SOUT** com timestamps.

- O exemplo mostra uma **Busca Linear** (O(n).) No LeetCode, se o array fornecido no enunciado estiver (ordenado "sorted"), usar esse algoritmo é um erro. Arrays ordenados pedem **busca binária (O (log n))**. A busca linear só é aceitável em arrays desordenados ou pequenos.

- O código acessa *x.length*. Em Java, arrays sabem seu próprio tamanho (propriedade final), o ruq torna essa verificação O(1). Diferente de C, onde precisamos passar o tamanho como argumento, o Java encapsula isso, evitando leitura de memória fora dos limites. Quando criamos um `int[] x = {3, 5, 7, 9, 11};` o Java **guarda internamente** o tamanho desse array no próprio objeto array. Por isso podemos escrever x.length sem precisarmos calcular, percorrer e sem contar os elementos.

- O texto cita *x.length/2* (caso médio). No LeetCode e em análise de algoritmos segura, **sempre focamos no pior caso (Big-O)**. Assumimos que o *target* esteja na última posição ou que ele não exista, garantindo que nossa solução não estoure o tempo limite (Time Limit Exceeded - TLE) em testes ocultos.

### Exemplo 2.2
Agora vamos considerar outro problema. Queremos descobrir se dois arrays não possuem elementos em comum. Podemos usar nosso método de busca (search) para procurar em um array por valores que estejam no outro:
```java
public static boolean areDifferent(int[]x, int[] y) {
	for (int i = 0; i < x.length; i++) {
		if (Search(y, x[i]) != -1)
			return false;
	}
	return true;
}
```

O corpo do loop será executado no máximo *x.length* vezes. Durante cada iteração, ele chamará o método *search* para procurar o elemento atual, *x[i]*, no array y. O corpo do loop em *search* será executado no máximo *y.lenght* vezes. Portanto, o tempo total de execução seria proporcional ao produto de *x.lenght* e *y.lenght*.

**Complexidade**
- *search* - O(n)
- *areDifferent* chama *search* dentro de um loop - O(n²)

### Exemplo 2.3
Vamos considerar o problema de terminar se cada item em um array é único. Poderíamos escrever o seguinte método:
```java
public static boolean areUnique(int[] x) {
	for (int i = 0; i < x.length; i++) {
		for (int j = 0; j < x.length; j++) {
			if (i != j && x[i] == x[j])
				return false;
		}
	}
	return true;
}
```

**Ponto-chave**
i != j não "cria" índices diferentes, ele apenas filtra os pares que já são diferentes.

Os laços *for* geram todos os pares possíveis de índices. O i != j apenas diz: "entre esses pares, só me interessam os que apontam para posições distintas."

**Por que isso não depende de "controle lógico extra"?**
Porque os laços já geram *todos os pares possíveis de índices*:
(0, 0), (0, 1), (0, 2) ....
(1, 0),  (1, 1), (1, 2) ....

O *i != j* elimina os pares inválidos:
(0, 0), (1,1 ), (2, 2), (3, 3)...

Se todos os valores forem únicos, o loop externo será executado *x.length* vezes. Para cada iteração do loop externo, o loop interno também será executado *x.length* vezes. Assim, o número total de vezes que o corpo do loop interno será executado é de (x.length)².

### Exemplo 2.4
O método que mostramos no exemplo 2.3 é muito ineficiente porque fazemos aproximadamente o dobro de testes necessários. Podemos reescrever o loop inteiro da seguinte forma:
```java
public static boolean areUnique(int[] x) {
	for (int i = 0; i < x.length; i++) {
		for (injt j = i + 1; j < x.length; j++) {
			if (x[i] == x[j])
				return false;
		}
	}
	
	return true;
}
```

Podemos iniciar o índice do loop interno em *i + 1* porque já determinamos que os elementos anteriores a este são únicos. Na primeira vez, o loop interno será executado *x.length - 1* vezes. Na segunda vez, ele será executado *x.length - 2* vezes, e assim por diante. Na última vez, ele será executado apenas uma vez. O número total de vezes que ele será executado é:
$x.length-1 + x.length-2 + ... + 2 + 1$

A série 1 + 2 + 3 + ... + (n-1) é uma série bem conhecida que tem o valor de:
$\frac{n \times (n-1)}{2}$ ou $\frac{n^2 - n}{2}$
Portanto, esta soma é $\frac{x.length^2 - x.length}{2}$ 

