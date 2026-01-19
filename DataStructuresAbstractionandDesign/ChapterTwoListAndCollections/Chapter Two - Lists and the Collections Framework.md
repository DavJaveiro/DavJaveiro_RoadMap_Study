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
Sempre que escrevemos uma nova classe, discutiremos a eficiência de seus métodos para que saibamos como eles se comparam a métodos similares em outras classes. <span style="background:#d2cbff">Não conseguimos medir facilmente a quantidade de tempo que leva para rodar um programa em computadores modernos. </span>Quando emitimos o comando *java MeuPrograma* (ou clicamos no botão Executar dentro do nosso ambiente de desenvolvimento integrado [IDE]), o sistema operacional primeiro carrega a Máquina Virtual Java (JVM). A JVM então carrega o arquivo .class do *MeuPrograma*, carrega outros arquivos .class que o *MeuPrograma* referencia e, finalmente, o nosso programa é executado.  (Se os arquivos .class ainda não tiverem sido criados, a IDE Java compilará o arquivo fonte antes de executar o programa). A maior parte do tempo necessário para o nosso programa é ocupada pelos dois primeiros passos. Se rodarmos o nosso programa uma segunda vez imediatamente após a primeira execução, pode parecer que leva menos tempo. Isso acontece porque o sistema operacional pode ter mantido os arquivos em uma área de memória local chamada #cache. No entanto, se tivermos um problema grande ou complicado o suficiente, o tempo real de execução do nosso programa dominará o tempo necessário para carregar a JVM e os arquivos *.class*. 

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
		for (int j = i + 1; j < x.length; j++) {
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

*Insights valiosos (Simplificando Algoritmos e Java)*
- **A Analogia do "Álbum de Figurinhas" (Hash Set):** Para resolver o problema de duplicatas no LeetCode ou na vida real, não comparamos um por um. Nós usamos um *HashSet* (Conjunto). 


- *Contains*: em Java, se temos um *ArrayList* e realizamos um *list.containsitem)*, o Java está fazendo exatamente o "trabalho burro": ele percorre a lista do início ao fim procurando o item.
	- Se precisamos verificar "esse item existe aqui?" Muitas vezes, nunca use o #List, use o #Set (HashSet). A diferença de performance é brutal.

## Big-O Notation
Entender como o tempo de execução (e os requisitos de memória) de um algoritmo cresce como função do aumento do tamanho da estrada dá aos programadores uma ferramenta para comparar vários algoritmos e como eles performarão. Cientistas da computação desenvolveram uma terminologia e notação úteis para investigar e descrever a relação entre tamanho da entrada e tempo de execução. Por exemplo, se o tempo é aproximadamente dobrado quando o número de entrada, *n*, é dobrado, então o algoritmo cresce a uma taxa linear. Assim, dizemos que a taxa de crescimento tem uma ordem de *n*. Se, no entanto, o tempo é aproximadamente quadruplicado quando o número de entradas é dobrado, então o algoritmo cresce a uma taxa quadrática. Neste caso, dizemos que a taxa de crescimento tem uma ordem de n^2. 

Na seção anterior, olhamos para quatro métodos: um cujo tempo de execução estava relacionado a `x.length`, outro cujo tempo estava relacionado a `x.length` vezes `y.length`, um cujo tempo estava relacionado a `(x.length)^2`, e um cujo tempo estava relacionado a `(x.length)^2` e `x.length`. Cientistas da computação usam a notação $O(n)$ para representar o primeiro caso, $O(n \times m)$ para representar o segundo, e $O(n^2)$ para representar o terceiro e o quarto, onde $n$ é `x.length` e $m$ é `y.length`. O símbolo $O$ pode ser pensado como uma abreviação para "ordem de grandeza" (order of magnitude). Essa notação é chamada de notação Big-O.

Frequentemente, uma maneira simples de determinar o Big-O de um algoritmo ou programa é olhar para os loops e ver se os loops estão aninhados. Assumindo que o corpo do loop consista apenas de instruções simples, um único loop é $O(n)$, um par de loops aninhados é $O(n^2)$, um par de loops aninhados dentro de outro é $O(n^3)$, e assim por diante. No entanto, também devemos examinar o número de vezes que o loop executa.

Consideramos o seguinte:
```java
for (i = 1; i < x.length; i *= 2) {
	// Faz algo com x[i]
}
```
O corpo do loop executara $k - 1$ vezes, com $i$ tendo os seguintes valores: $1, 2, 4, 8, 16, 32, ..., 2^k$ at
e que $2^k$ seja maior que *x.length*. 

Como $2^k-1 \le x.\text{length} < 2^k$ e $\log_2(2^k)$ é $k$, pois $k*k=2^k$ sabemos que $k-1\le\log_2(x.\text{length}) < k$. Função logarítimica cresce lentamente. O log na base 2 de 1.000.000 é aproximadamente 20. Tipicamente, ao analisar o tempo de execução de algoritmos, usamos logaritmos na base 2.


- **A "Morte" da Lei de Moore e o Paralelismo:** O texto foca em tempo de execução _single-threaded_. Em 2025, um algoritmo $O(n)$ simples pode ser mais lento que um $O(n \log n)$ complexo se o $O(n)$ não puder ser **paralelizado** e o $O(n \log n)$ puder rodar em GPUs ou 64 núcleos de CPU simultaneamente (<span style="background:#affad1">via Java Parallel Streams ou Project Loom</span>). A análise moderna considera "Work" (trabalho total) vs "Span" (caminho crítico paralelo).
- **Custo de Memória vs. Computação**: o texto coloca tempo e memória lado a lado. Atualmente, em ambientes de nuvem (Serverless/Kubernetes), a memória costuma ser o recurso mais caro e o gargalo (Memory Wall). Algoritmos que economizam CPU mas gastam muita memória (como tabelas Hash gigantescas) podem ser rejeitados em arquiteturas modernas em favor de algoritmos que recalculam (O(1) espaço, mais CPU) para economizar custos de RAM.

## Formal Definition of Big-O
Considere um programa que é estruturado da seguinte forma:
```java
for (int i=0; i < n; i++) {
	for (int j = 0; j < n; j++) {
		// Instrução Simples
	}
}

for (int k = 0l i < n; k++) {
	Instrução Simples 1 
	Instrução Simples 2 
	Instrução Simples 3 
	Instrução Simples 4 
	Instrução Simples 5
}
Instrução Simples 6
Instrução Simples 7
...
Instrução Simples 30
```

Vamos assumir que cada instrução Simples leva uma unidade de tempo e que as instruções *for* são gratuitas. O loop aninhado executa uma instrução Simples n² vezes. Em seguida, cinco Instruções Simples são executadas *n* vezes no loop com a variável de controle *k*. 

Em seguida, temos cinco instruções simples sendo executadas *n* vezes no loop com a variável de controle k. 

Finalmente, 25 instruções simples são executadas após este loop. 

Concluiríamos então que a expressão $T(n)=n² +5n +25$ mostra a relação entre o tempo de processamento de *n* (o número de itens de dados processados no loop), onde $T(n)$ representa o tempo de processamento como uma função de $n$. Deve ficar claro que o termo $n²$ domina à medida que *n* se torna grande. 

Em termos de $T(n)$, formalmente, a notação Big-O $T(n) = O(f(n))$ significa que existem duas constantes, $n_0$ e $c$, maiores que zero, e uma função, $f(n)$, tal que para todo $n > n_0$, $cf(n) \ge T(n)$. Em outras palavras, à medida que $n$ fica suficientemente grande (maior que $n_0$), existe alguma constante $c$ para a qual o tempo de processamento será sempre menor ou igual a $cf(n)$, então $cf(n)$ é um limite superior para o desempenho. O desempenho nunca será pior que $cf(n)$ e pode ser melhor.

Se pudermos determinar como o valor de $f(n)$ aumenta com $n$, saberemos como o tempo de processamento aumentará com $n$. A taxa de crescimento de $f(n)$ será determinada pela taxa de crescimento do termo de crescimento mais rápido (aquele com o maior expoente), que, neste caso, é o termo $n^2$. Isso significa que o algoritmo neste exemplo é um algoritmo $O(n^2)$ em vez de um algoritmo $O(n^2 + 5n + 25)$. <span style="background:#ff4d4f">Em geral, é seguro ignorar todas as constantes e descartar os termos de ordem inferior ao determinar a ordem de grandeza de um algoritmo.</span>

**Exemplo 2.5:** Dado $T(n) = n^2+5n+25$, queremos que isso é de fato $O(n^2)$. Portanto, queremos demonstrar que existem constantes $n_0$ e $c$ tais que, para todo $n > n_0$, $cn^2>n^2+5n+25. Uma maneira de fazer isso é encontrar um ponto onde $cn^2=n^2+5n+25$. Se deixarmos $n$ ser $n_0$ e resolvemos para $c$, obtemos $c = 1 + \frac{5}{n_0} + \frac{25}{n_0^2}$ Podemos avaliar a expressão à direita facilmente quando $n_0$ é 5 ($1 + 5/5 + 25/25$). Isso nos dá um $c$ de 3. Então $3n^2 > n^2 + 5n + 25$ para todo $n$ maior que 5, conforme mostrado na Figura 2.1.

```java
for (int i=0; i<n-1; i++) {
	for (int j=i+1; j<n; j++) {
		// 3 instruções simples
	}
}
```
Na primeira passagem pelo loop externo, o loop interno é executado $n - 1$ vezes; na próxima, $n - 2$; e na última vez, uma vez. O loop externo é executado $n$ vezes. Então obtemos a seguinte expressão para $T(n)$: $3(n - 1) + 3(n - 2) + \dots + 3(2) + 3(1)$ Podemos colocar o 3 em evidência para obter $3 \times [(n - 1) + (n - 2) + \dots + 2 + 1]$ A soma $1 + 2 + \dots + (n - 2) + (n - 1)$ (entre parênteses acima) é igual a $\frac{n^2 - n}{2}$ Assim, nosso $T(n)$ final é $T(n) = 1.5n^2 - 1.5n$

Este polinômio é zero quando $n$ é 1. Para valores maiores que 1, $1.5n^2$ é sempre maior que $1.5n^2 - 1.5n$. Portanto, podemos usar 1 para $n_0$ e 1.5 para $c$ para concluir que nosso $T(n)$ é $O(n^2)$ (veja a Figura 2.2).

Se $T(n)$ é a forma de um polinômio de grau $d$ (o maior expoente), então ele é $O(n^d)$. Uma prova matematicamente rigorosa disso está além do escopo deste texto. Uma prova intuitiva é demonstrada nos dois exemplos anteriores. Se os termos restantes tiverem coeficientes positivos, encontre um valor de $n$ onde o primeiro termo é igual aos termos restantes. Conforme $n$ fica maior que este valor, o termo $n^d$ sempre será maior que os termos restantes.

Usamos a expressão $O(1)$ para representar uma taxa de crescimento constante. Este é um valor que não muda com o número de entradas. Os passos simples representam todos $O(1)$. Qualquer número finito de passos $O(1)$ ainda é considerado $O(1)$.

Um loop dentro do outro gera uma curva quadrática, o $O(n^2)$. Mas o conceito mais poderoso é o $O(1)$, ou Tempo Constante. É o nirvana dos algoritmos. Significa que, não importa se você tem dez usuários ou dez milhões, seu código roda na mesma velocidade. Em Java, atingimos isso sabendo usar Arrays ou HashMaps corretamente. O segredo não é decorar a fórmula, mas olhar para o código e identificar: isso vai explodir se o meu cliente crescer, ou vai se manter estável?

---
*Insight*
Imaginemos que o tempo que o nosso código leva para rodar é o dinheiro que temos que pagar. A fórmula do texto era: $T(n)=n²+5n+25$.
Supondo que *n* seja o número de usuários do nosso site, considerando como 1 milhão.

- N² (o termo quadrático): 1.000.000 x 1.000.000 = 1 trilhão de reais;
- 5n (o termo linear): 5x1.000.000 = 5 milhões de reais
- 25 (a constante): 25 reais

Se devemos 1 trilhão de reais ao banco, você se importaria com os 25 reais da conta do bar? Não. Você se importa com os 5 milhões? Também não, é troco de pinga perto de 1 trilhão.
- **Matemática:** "Quando n cresce, ignoramos os termos menores"
- **Prática:** só olharmos para a potência maior. Se tem n², o algoritmo é lento.

**O que é $O(1) (o interruptor de Luz)**
Tempo Constante ou $O(1)$. 
- Pense num interruptor de luz. Não importa se a sala tem 10m² ou um estádio de futebol de 10.000m². Quando você clica, a luz acende na hora. O esforço não muda com o tamanho da sala.
- Em Java, acessar um array arr[5] é como o interruptor. É instantâneo, não importa se o array tem 10 ou 1 bilhão de posições.

Exercício Básico (O(1) - Instantâneo)
Array Access. Temos uma lista de 1 milhão de produtos ordenados por ID (0 a 999.999). O cliente pede o produto de ID 500.
**Solução:** não procuramos um por um. Vamos direto na gaveta 500 *arr[500]*. Complexidade $O(1)$. Não importa o tamanho da loja. 


### O Poder dos Algoritmos O(log n)
Há um grande potencial de melhoria ao usar um algoritmo $O(log n)$ para processar um grande conjunto de dados em comparação com um algoritmo $O(n)$. Por exemplo, se o tamanho dos dados tem 1024 elementos, haverá apenas 512 elementos restantes para processar após o primeiro teste, 256 elementos após o terceiro teste [nota: o texto original diz 'third' mas o contexto lógico seria 'second']. 

A sequência 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 mostra o tamanho do conjunto de dados restante para processar após cada teste. Portanto, exigirá 10 testes para determinar que um elemento específico não estava presente em um conjunto de dados de tamanho 1024 usando um algoritmo $O(log n)$. Veremos vários exemplos de algoritmos $O(log n)$ neste livro. Portanto, exigirá 10 testes para determinar que um elemento específico não estava presente em um conjunto de dados de tamanho 1024 usando um algoritmo $O(log n)$. Veremos vários exemplos de algoritmos $O (log n) neste livro.

**Regra de Ouro para reconhecer algoritmos O(log n)**
Sempre que virmos algo assim:
- "Divide ao meio"
- "Descarta metade"
- "Árvore balanceada"
- "Busca binária"
- "altura da árvore"
Devemos pensar imediatamente em O(log n).

Portanto, um algoritmo $O(log_n)$ é quando cada iteração reduz o tamanho do problema de forma proporcional (normalmente pela metade). Isso acontece independente da linguagem, mas em Java, veremos isso principalmente em:
- busca binária
- árvores balanceadas
- Estruturas ordenadas
- Algoritmos "divide and conquer"

Exemplo canônico: busca binária em Java
*Pré-requisito:* dados ordenados
```java
public static int buscaBinaria(int[] arr, int alvo) {
	int inicio = 0;
	int fim = arr.length -1;
	
	while (inicio <= fim) {
		int meio = inicio + (fim - inicio) /2;
		
		if(arr[meio] == alvo) {
			return meio;
		}
		
		if (arr[meio] > alvo) {
			fim = meio - 1; // descarta metade direita
		}else {
			fim = meio + 1;
		}
	}
	
	return -1; // não encontrado
}
```

**Padrões que indicam logaritmo**
1. **Variável que divide por 2**
```java
n = n / 2;
```

2. **Laço que cresce exponencialmente**
```java
for (int i = 1; i < n; i *= 2)
```

3. **Estrutura de decisão que elimina metade**
```java
if (...) {
	// metade
} else {
	// outra metade
}
```
**Estruturas Java que usam O(log n)**
Implementadas como Red-Black Tree.
```java
TreeSet<Integer> set = new TreeSet<>();
set.add(10);
set.add(5);
set.add(20);

set.contains(10);
```

**Operações**
- **add** -> O(log n)
- **remove** -> O(log n)
- **contains** -> O(log n)

**Algoritmos com Taxas de Crescimento Exponencial e Fatorial**
Algoritmos com taxas de crescimento exponencial e fatorial (ainda mais rápidas) têm um limite superior prático efetivo no tamanho do problema para o qual podem ser usados, mesmo com computadores cada vez mais rápidos. Por exemplo, se temos um algoritmo $O(2^n)$ que leva uma hora para 100 entradas, adicionar a 101ª.

Essa relação é a base para algoritmos criptográficos, algoritmos que encriptam texto usando uma chave especial para torná-lo ilegível por qualquer um que o intercepte e não conheça a chave. A encriptação é usada para fornecer segurança para dados sensíveis enviados pela internet. Alguns algoritmos criptográficos podem ser quebrados em tempo $O(2^n)$, onde *n* é o número de bits na chave. Um comprimento de chave de 40 bits é considerado quebrável por um computador pessoal moderno, mas um comprimento de chave de 100 (60 bits a mais) não é, porque a chave com comprimento de 100 bits levará aproximadamente bilhão de bilhões (10^18) de vezes mais tempo que a chave de 40 bits para ser quebrada. Supercomputadores modernos podem quebrar chaves muito mais longas em tempo razoável, então atualmente comprimentos de chave de 2048 ou maiores são recomendados.

## 2.2 The List Interface and ArrayList Class
Um array é uma estrutura de dados indexada, o que significa que podemos selecionar nossos elementos em ordem arbitrária conforme determinado pelo valor do subscrito (índice). Você também pode acessar os elementos em sequência usando um loop que incremente o índice. No entanto, não podemos fazer o seguinte com um objeto array:
- Aumentar ou diminuir seu comprimento, que é fixo;
- Adicionar um elemento em uma posição especificar sem deslocar os outros elementos para abrir espaço; 
- Remover um elemento em uma posição especificada sem deslocar os outros elementos para preencher a lacuna restante;

As classes que implementam a interface Java #List (parte da API *java.util*) fornecem métodos para fazer essas operações e mais. A tabela 2.4 mostra alguns dos métodos na interface Java #List. Esses métodos realizam as seguintes operações:
- Retornar uma referência a um elemento em um local especificado (método *get*);
- Encontrar um valor alvo especificado (método *indexOf*, embora o texto diga #get erroneamente na lista de bullets, a tabela corrige).
- Adicionar um elemento ao final da lista (método **add**);
- Inserir um elemento em qualquer lugar na lista (método add);
- Remover um elemento (método #remove)
- Substituir um elemento na lista por outro (método #set)
- Retornar o tamanho da lista (método #size)
- Acessar sequencialmente todos os elementos da lista sem ter que manipular um índice;

O símbolo *E* na Tabela 2.4 é um parâmetro de tipo. Parâmetros de tipo são análogos a parâmetros de método. Na declaração de uma interface ou classe, o parâmetro de tipo representa o tipo de dados de todos os objetos  armazenados em uma coleção. Embora todas as classes suportem as operações da Tabela 2.4, elas não as realizam com o mesmo grau de eficiência. Os tipos de operações que pretendemos realizar em uma aplicação específica devem influenciar a nossa decisão sobre qual classe de #List utilizar.

!![image-20261154717426.png](/image-20261154717426.png)

#RandomAccess: é uma interface marcador *marker interface*. Ela não possuí métodos, ela serve para indicar uma característica da classe, ou seja, que a lista permite acesso rápido (O(1)) a qualquer posição pelo índice. 

Se uma classe **implementa** *RandomAccess*, ela está dizendo para a JVM e para os frameworks: 
*Pode acessar meus elementos por índice*.

Exemplo:
```java
List<String> list = new ArrayList<>();

list.get(500_000);
```

Uma funcionalidade que a estrutura de dados array fornece que essas classes não fornecem é a capacidade de armazenar valores de tipos primitivos. As classes *List* armazenam referências a #Objects, portanto, todos os valores de tipo primitivo devem ser encapsulados #wrapped em objetos. 

A classe #Vector foi depreciada...

## The ArrayList Class
A classe mais simples que implementa a interface *List* é a classe #ArrayList. Um objeto #ArrayList é uma melhoria em relação a um objeto array, pois suporta todas as operações recém-listadas. Objetos ArrayList são usados com mais frequência quando um programador deseja ser capaz de aumentar uma lista adicionando novos elementos ao final, mas ainda precisa da capacidade de acessar os elementos armazenados na lista em ordem arbitrária. O tamanho de um ArrayList aumenta automaticamente conforme novos elementos são adicionados a ele, e o tamanho diminui conforme elementos são removidos. Um objeto ArrayList possui um método de instância #size que retorna o seu tamanho atual. Cada objeto ArrayList tem uma capacidade, que é o número de elementos que ele pode armazenar. Se adicionarmos um novo elemento a um #ArrayList cujo tamanho atual é igual à sua capacidade, <span style="background:#affad1">a capacidade é aumentada automaticamente</span> (a eficiência diminui, essa operação de redimensionamento é custosa (O(N)))

> A classe #list do Python é semelhante à classe ArrayList. Ambas podem armazenar uma coleção de objetos e ambas se expandem automaticamente quando o espaço extra é necessário. Ambas possuem métodos para adicionar elementos, inserir elementos e obter o comprimento da lista. Mas não podemos usar a notação de índice de array scores[3] com um ArrayList, mas podemos com uma lista Python.

**Exemplo 2.8** [[ArrayListStudy.java]]

As listas referenciadas por myList e yourList são objetos `ArrayList<String>`. A variável *youtList* é declarada como tipo List na primeira instrução...

Se removermos um elemento de um objeto ArrayList, o tamanho diminui automaticamente, e os elementos seguintes ao removido deslocam-se para preencher o espaço vago. Isso é o mesmo que quando alguém sai de uma fila de ingressos; as pessoas atrás movem-se todas para frente. 

Embora um ArrayList seja uma coleção indexada, não podemos acessar seus elementos usando um subscrito colchetes. Em vez disso, devemos utilizar o método #get para acessar seus elementos. Por exemplo, a instrução *String dwarf = myList.get(2)* armazena uma referência ao objeto string "Jumpy" na variável dwarf, sem alterar myList.

Utilizamos #set para armazenar um valor em um ArrayList. A chamada do método *myList.set(2, "Sneezy")* armazena uma referência à String "Sneezy" no índice 2, substituindo a referência à String. No entanto, a variável ainda é referenciada...

*Insights*
- **Capacidade vs. Tamanho (Otimização Oculta):** o texto menciona a "capacidade inicial de 10". No LeetCode, se sabemos que vamos inserir 10.000 elementos, nunca devemos fazer *New ArrayList<>()*. Isso forçará o Java a redimensionar o array interno múltiplas vezes... A prática recomendada é usar *new ArrayList<>(1000)*. Isso alocará a memória de uma vez só, garantindo complexidade $O(N)$ pura na construção, sem overhead de cópia.

**Exercícios para amanhã: (16/01/2026)**
- **1 → 7**: constroem a base (operações, iteração, lógica)
    
- **8 → 10**: nível **LeetCode real** (pensamento algorítmico + uso correto de `ArrayList`)
    
- Todos com:
    
    - 📘 **Descrição**
        
    - 🧩 **Exemplo**
        
    - 🎯 **O que se espera**
        
    - 💡 **Dicas**
        

> **Regra do jogo:**  
> Use `ArrayList` sempre que possível (não usar Streams nos primeiros exercícios).

---

# 🧠 Exercício 1 — Criando e exibindo uma lista

**Dificuldade:** Fácil
### 📘 Descrição
Crie um método que recebe um inteiro `n` e retorna um `ArrayList<Integer>` contendo os números de `1` até `n`.
### 🧩 Exemplo
```java
Input: n = 5
Output: [1, 2, 3, 4, 5]
```
### 🎯 O que se espera
- Uso de `ArrayList`
- Uso de `add`
### 💡 Dica
Use um `for` simples de `1` até `n`.




---

# 🧠 Exercício 2 — Soma dos elementos

**Dificuldade:** Fácil
### 📘 Descrição
Dado um `ArrayList<Integer>`, retorne a soma de todos os elementos.
### 🧩 Exemplo
```java
Input: [1, 2, 3, 4]
Output: 10
```

### 🎯 O que se espera
- Percorrer a lista corretamente
- Entender `get(i)` e `size()`
### 💡 Dica
Comece a soma com `0`.

---

# 🧠 Exercício 3 — Remover números pares

**Dificuldade:** Fácil → Média
### 📘 Descrição

Dado um `ArrayList<Integer>`, remova **todos os números pares**.

### 🧩 Exemplo

```java
Input: [1, 2, 3, 4, 5, 6]
Output: [1, 3, 5]
```

### 🎯 O que se espera

- Remoção correta
- Não pular elementos
    

### 💡 Dica

Iterar de trás para frente evita erros.

---

# 🧠 Exercício 4 — Contar ocorrências

**Dificuldade:** Média

### 📘 Descrição

Dado um `ArrayList<String>` e uma `String alvo`, conte quantas vezes ela aparece.

### 🧩 Exemplo

```java
Input: ["java", "python", "java", "go"], alvo = "java"
Output: 2
```
### 🎯 O que se espera

- Uso correto de `equals`
- Lógica de contagens
### 💡 Dica
Nunca use `==` para comparar `String`.

---

# 🧠 Exercício 5 — Inverter a lista

**Dificuldade:** Média
### 📘 Descrição
Implemente um método que inverte um `ArrayList<Integer>` **sem usar Collections.reverse()**.
### 🧩 Exemplo

```java
Input: [1, 2, 3, 4]
Output: [4, 3, 2, 1]
```

### 🎯 O que se espera

- Manipulação de índices
- Troca de elementos
### 💡 Dica
Use dois ponteiros: início e fim.

---

# 🧠 Exercício 6 — Remover duplicados

**Dificuldade:** Média → Alta

### 📘 Descrição

Dado um `ArrayList<Integer>`, retorne uma nova lista **sem elementos duplicados**, mantendo a ordem.

### 🧩 Exemplo

```java
Input: [1, 2, 2, 3, 1]
Output: [1, 2, 3]
```

### 🎯 O que se espera

- Lógica de verificação
    
- Preservar ordem
    

### 💡 Dica

Use `contains()` ou uma lista auxiliar.

---

# 🧠 Exercício 7 — Interseção de duas listas

**Dificuldade:** Alta

### 📘 Descrição

Dadas duas listas `ArrayList<Integer>`, retorne uma nova lista contendo apenas os elementos comuns.

### 🧩 Exemplo

```java
Input: [1, 2, 3], [2, 3, 4]
Output: [2, 3]
```

### 🎯 O que se espera

- Comparação entre listas
    
- Evitar duplicatas no resultado
    

### 💡 Dica

Itere na menor lista para otimizar.

---

# 🚀 Exercício 8 — Two Sum (LeetCode clássico)

**Dificuldade:** LeetCode Easy → Medium

### 📘 Descrição

Dado um `ArrayList<Integer>` e um inteiro `target`, retorne os **índices** de dois números que somam `target`.

### 🧩 Exemplo

```java
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
```

### 🎯 O que se espera

- Manipular índices corretamente
    
- Não usar o mesmo elemento duas vezes
    

### 💡 Dica

Primeiro resolva com dois loops (`O(n²)`), depois pense em otimização.

---

# 🚀 Exercício 9 — Remove Element (in-place)

**Dificuldade:** LeetCode Medium

### 📘 Descrição

Remova todas as ocorrências de um valor `val` **in-place** e retorne o novo tamanho da lista.

### 🧩 Exemplo

```java
Input: nums = [3,2,2,3], val = 3
Output: 2
Lista final: [2,2]
```

### 🎯 O que se espera

- Manipulação direta da lista
    
- Controle de índices após remoção
    

### 💡 Dica

Itere de trás para frente.

---

# 🚀 Exercício 10 — Merge Sorted Lists

**Dificuldade:** LeetCode Medium → Hard

### 📘 Descrição

Dadas duas listas **ordenadas**, mescle ambas em uma única lista ordenada.

### 🧩 Exemplo

```java
Input: [1,2,4], [1,3,4]
Output: [1,1,2,3,4,4]
```

### 🎯 O que se espera

- Uso eficiente de índices
    
- Complexidade O(n + m)
    

### 💡 Dica

Use dois ponteiros, um para cada lista.

---

## 🧩 Caminho de aprendizado (importante)

- **1–3** → fundamentos de ArrayList
    
- **4–5** → comparação e manipulação
    
- **6–7** → lógica + controle de duplicatas
    
- **8–10** → pensamento algorítmico real (LeetCode)
    

Se quiser, no próximo passo eu posso:

- resolver **apenas o 1 ao 3**
    
- criar **testes no estilo LeetCode**
    
- ou corrigir suas soluções como se fosse um code review profissional 💻



