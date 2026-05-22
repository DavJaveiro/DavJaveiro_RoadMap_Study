## Part 1 - Generics
Generics are a powerful, and sometimes controversial, feature of the Java programming language. This part of the book describes generics, using the Collections Frameworks as a source of examples. A comprehensive introduction of the Collections Framework appears in the second part of the book.

The first four chapters focus on the fundamentals of generics. **Chapter 1** gives an overview of generic types and methods. **Chapter 2** reviews how subtyping works and explains how wildcards let we use subtyping in connection with generics. **Chapter 3** describes how generics work with the #Comparable interface, which requires a notion of bounds on type variables. **Chapter 4** looks at how generics work with various declarations, including constructors, static members, and nested classes (classes aninhadas). Once we have these four chapters under your belt, you will be able to use generics effectively in most basic situations.

The next three chapters treat advanced topics. Chapter 5 explains how the same design that leads to ease of evolution also necessarily leads to a few rough edges in the treatment of casts, exceptions, and arrays. <span style="background:#fff88f">The fit between generics and arrays is the worst rough corner of the language</span>, and we formulate two principles to help you work around the problems. <span style="background:#d3f8b6">O ajuste entre genéricos e matrizes é a pior parte da linguagem, e formulamos dois princípios para ajudá-lo a contornar os problemas.</span>

**Chapter 6** explains features that relate generics and reflection, including the type *Class< T>* and additions to the Java library that support reflection, including the type Class< T> and additions to the Java library that support reflection of generic types. **Chapter 7** contains advice on how to use generics effectively in practical coding. We consider a variety of techniques learned fo9rm the experience of using generics in practical development. This chapter also contains a section reviewing some of the design decisions that shaped the generics features of Java.

## Introduction 1
The purpose of generics is to allow the same code to be reused for creating or **handling** (manipular) objects of different types. For example, *List< String>* and *List < Integer>* are different types, but generics allows them to be implemented with the same code, with type safety preventing any possibility of confusion between them. Dois tipos de código Java podem ser genéricos: tipos, como as classes e interfaces de coleção; e métodos, como os métodos estáticos da classe utilitária *java.util.Collections*. Vamos analisar cada um deles a seguir.

### Generic Types
Uma interface ou classe pode ser declarada para aceitar um ou mais **parâmetros de tipo**, que são escritos entre os sinais < e > e <span style="background:#d3f8b6">devem ser fornecidos</span> ao declarar uma <span style="background:#fff88f">variável pertencente à interface</span> ou <span style="background:#fff88f">classe</span>, ou ao criar uma nova instância de uma classe. Aqui está um exemplo:
```java
List<String> words = new ArrayList<String>();
words.add("Hello ");
words.add("world!");
String s = words.get(0)+words.get(1);
assert s.equals("Hello world!");
```

No *Collections Framework*, a classe *ArrayList< E>* implementa a interface *List< E>*, onde E é uma **variável de tipo** _ um espaço reservado para um tipo que será fornecido sempre que *List* ou *ArrayList* forem usados em um programa. 

Este fragmento de código trivial declara a variável *words*, que será usada para referenciar uma lista contendo strings. Em seguida, cria uma instância de um *ArrayList*, atribui sua referência à variável *words*, adiciona duas strings à lista e as recupera.

Não deduza a partir deste exemplo que uma variável do tipo *SomeClass< T>* necessariamente referencia um objeto *SomeClass* contendo objetos do tipo T. Se *SomeClass*  for um tipo de coleção, isso estará correto, mas a ideia geral dos genéricos é mais ampla. Por exemplo, objetos que implementam a interface *Comparable< T>* <span style="background:#40a9ff">não contém objeto T</span>; em vez disso, <span style="background:#b1ffff">eles têm a capacidade de se comparar com objetos do tipo T</span> (consulte "Comparable" na página 35). Para outro exemplo, a classe *java.util.ServiceLoader< S>* localiza provedores para um serviço do tipo S; assim, um *ServiceLoader< CharsetProvider>* localiza serviços para codificar e decodificar conjuntos de caracteres, um *ServiceLoader< FileSystemProvider>* localiza serviços que gerenciam sistemas de arquivos, e assim por diante. Foi isso que quisemos dizer anteriormente quando afirmamos que o mesmo código, o da classe genérica *SomeClass* pode ser reutilizado para criar ou manipular objetos de tipos diferentes (ou seja, tipos que são diferentes instanciações do parâmetro de tipo T). Como discutiremos, genéricos principalmente no contexto de coleções, é compreensível que pensemos que isso implica contenção, mas, na verdade, o conceito é aplicável de forma muito mais ampla.

---
**Resumo**
Quando começamos com genéricos, é natural pensarmos assim:
```java
List<String> lista = new ArrayList<>(); // uma lista que CONTÉM STIRNGS;
```

Isso está correto para coleções, mas o autor está alertando: **não generalize isso para todos os genéricos.**

O parâmetro < T> não significa necessariamente "contém T". Ele significa: "esta classe ou método tem uma relação de tipo com T". Essa relação pode ser de contenção, mas também pode ser de comparação, fornecimento, conversão, filtragem, etc.

| lasse Genérica     | O que `<T>` representa      | Tipo de Relação  |
| ------------------ | --------------------------- | ---------------- |
| `List<T>`          | Os elementos armazenados    | 📦 Contenção     |
| `Comparable<T>`    | O tipo com que se compara   | ⚖️ Comparação    |
| `ServiceLoader<T>` | O tipo de serviço procurado | 🔍 Localização   |
| `Function<T,R>`    | Tipo da entrada (e saída)   | 🔄 Transformação |
| `Predicate<T>`     | Tipo do valor testado       | ✅ Verificação    |

Devemos pensar no genérico < T> como um rótulo de especialização, não como uma "caixa":
Entender isso evita dois erros comuns:
1. **Limitação mental**: Se você achar que genéricos só servem para coleções, perderá oportunidades de usar APIs como `Comparator<T>`, `Supplier<T>`, `Optional<T>`, etc.
2. **Leitura de código**: Ao ver `MinhaClasse<X>`, pergunte-se: _"Qual é a relação semântica com X?"_ em vez de assumir _"Ela guarda X"_.

O parâmetro genérico T define com que tipo a classe ou método trabalha, mas a *natureza* desse trabalho (conter, comparar, fornecer, transformar...) depende da semântica da API, não do genérico em si.

O parâmetro < T> é, de fato, um **mecanismo de abstração sobre tipos**, uma ferramenta para escrever código flexível e seguro, não um "recipiente" obrigatório.

> Genéricos são sobre **escrever uma vez, usar com muitos tipos, e deixar o compilador garantir que nada saia do tipo**.

---
Antes de gerar o #Bytecode, o compilador processa primeiro o código-fonte para garantir que o uso dos parâmetros de tipo seja consistente em todo o código. No exemplo anterior, ele verifica se uma referência a uma instância de *ArrayList< String>* pode ser atribuída a uma variável do tipo *List< String>*. Se essa verificação for bem-sucedida, ele descarta os parâmetros de tipo antes de prosseguir para gerar o *bytecode*. Portanto, o código-fonte da linha que é efetivamente compilado é:
```java
List words = new ArrayList();
```

Se visualizarmos este código em nossa IDE, poderemos ser informado, corretamente, que o lado direito da linha é equivalente a *new ArrayList<>()*. Escrevê-lo dessa forma faz com que o compilador insira o tipo fornecido na declaração da variável no lado esquerdo.

Agora, no entanto, *words* é uma lista de #Object. Isso significa que o tipo de retorno de *words.get()* é Object, e o compilador deve inserar *cast* (conversões explícitas) para String para garantir que a linha compile. No Java anterior aos genéricos, o mesmo código teria sido escrito da seguinte forma:
```java
List words = new ArrayList();
words.add("Hello");
words.add("World!");
String s = ((String)words.get(0))+((String)words.get(1));
assert s.equals("Hello world!");
```

Isso é, na prática, o mesmo código que o compilador de genéricos usa para gerar o *bytecode* após o pré-processamento descrito acima, de modo que o *bytecode* compilador a partir das duas fontes será idêntico. Dizemos que os genéricos são implementados por meio do **apagamento de tipo** (type erasuse) porque os tipos *List< Integer>* e *List< String>*, e, a propósito, *List< List< String>>*, são representados em tempo de execução pelo mesmo tipo, List. Também usamos o termo erasure (apagamento) para descrever o processo que converte o primeiro programa no segundo. Há uma descrição mais detalhada do apagamento em "Como o Apagamento Funciona" na página 65, mas, por enquanto, podemos entendê-lo da seguinte forma:

> **Apagamento:** O processo em tempo de compilação pelo quais as anotações de tipo são removidas antes da geração do _bytecode_.

O tempo *apagamento* é um leve equívoco, pois o processo não apenas apaga os parâmetros de tipo, mas também adiciona *casts*.

Como este exemplo mostra, os genéricos realizam implicitamente o mesmo *cast* que é feito explicitamente sem genéricos. Se esses _casts_ pudessem falhar, seria difícil depurar código escrito com genéricos. É por isso que é tranquilizador saber que os genéricos vêm com a seguinte garantia:
> **Garantia absoluta: os casts implícitos adicionados pela compilação de genéricos nunca falham.**

Há uma ressalva importante para essa garantia: ela se aplica apenas quando não ocorrem avisos não verificados (*uncheked warnings*). Esses são avisos gerados pelo compilador em situações em que ele não pode garantir a segurança de tipos. Mais adiante, discutiremos detalhes o que causa a emissão de avisos não verificados e como minimizar seus efeitos.

Implementar genéricos por meio do apagamento teve vários efeitos importantes. Manteve as coisas simples, pois os genéricos não exigiram alterações na JVM ou no _bytecode_. Manteve as coisas compactas, pois há exatamente uma implementação de `List`, não uma versão para cada tipo. E facilitou a evolução, já que a mesma biblioteca pode ser acessada tanto em formas não genéricas quanto genéricas. Este último ponto merece uma elaboração. Ele significou que você nunca enfrentaria problemas desagradáveis por manter duas versões das bibliotecas: uma versão legada que funcionava com Java pré-genéricos e uma versão genérica que funcionava com Java genérico. No nível de _bytecode_, o código que não usa genéricos é idêntico ao que usa. Isso significou que nunca foi necessário migrar para genéricos de uma só vez — você poderia evoluir seu código atualizando apenas um pacote, classe ou método por vez para começar a usar genéricos.² (Claro, a garantia absoluta mencionada só se mantém se você adicionar tipos genéricos que correspondam ao código legado.)

Outra consequência de implementar genéricos por meio do apagamento é que os tipos de _array_ diferem de maneiras importantes dos tipos parametrizados. Executar `new String[size]` aloca um _array_ e armazena nele uma indicação de que seus componentes são do tipo `String`. Em contraste, executar `new ArrayList<String>()` <span style="background:#fff88f">aloca uma lista</span>, mas não armazena na lista qualquer indicação do tipo de seus elementos. Dizemos que o Java **reifica** os tipos dos componentes de _array_ — ou seja, os preserva para uso em tempo de execução —, mas não reifica os tipos dos elementos de lista (ou outros tipos genéricos). Como explicado anteriormente, esse projeto foi crucial para facilitar a evolução e, portanto, para a popularidade contínua do Java. Anos depois, por outro lado, ele continua complicando _casts_, testes de instância e a criação de _arrays_, como veremos no Capítulo 5. A última seção desse capítulo, “Sobre o Projeto dos Genéricos do Java” na página 94, analisa os argumentos a favor e contra o uso do apagamento e se ele ainda é a escolha correta para o projeto do Java hoje.

---
**O que significa "reificar"?**
No jargão do Java, reificar significa "tornar o tipo concreto e disponível em tempo de execução".
- Se um tipo é **reificado**, a JVM sabe exatamente o que ele é enquanto o programa roda.
- Se **não é reificado**, essa informação só existe para o compilador e desaparece quando vira `.class`.

**Arrays vs. Genéricos: a diferença na prática**
1. **Arrays são reificados**
```java
String[] palavras = new String[5];
palavras[0] = "Olá";
palavras[1] = 42; // ❌ ArrayStoreException em tempo de execução
```

Quando fazemos *new String[5]*, a JVM cria um objeto que **carrega uma "etiqueta" permanente** dizendo: "Eu só aceito String". Se tentarmos guardar outro tipo, a JVM barra na hora.

2. **Genéricos NÃO são reificados**
```Java
List<String> lista = new ArrayList<>();
lista.add("olá");
// lista.add(42); → ❌ Erro de COMPILAÇÃO, não de runtime
```
Aqui, *< String>* só existe para o compilador. Depois que ele verifica a segurança e gera o bytecode, a informação *< String>* é **apagada**. Na JVM, isso vira simplesmente:
```java
List lista = new ArrayList(); // Raw type na prática
```

A lita não "sabe" que deveria conter apenas strings. Se passarmos um *cast* não verificado ou misturar com código legado, podemos inserir um *Integer* e só descobrir o erro quanto tentarmos recuperar o elemento como String - #ClassCastException.

**Resumo Visual**

| Característica              | Arrays (`String[]`)         | Coleções Genéricas (`ArrayList<String>`) |
| --------------------------- | --------------------------- | ---------------------------------------- |
| **Reificado?**              | ✅ Sim                       | ❌ Não (erasure)                          |
| **Sabe o tipo em runtime?** | Sim                         | Não                                      |
| **Verificação de tipo**     | Em tempo de execução        | Apenas em tempo de compilação            |
| `new Tipo[size]`            | ✅ Permitido                 | ❌ `new List<String>[10]` → erro          |
| `instanceof`                | ✅ `arr instanceof String[]` | ❌ `list instanceof List<String>`         |

**Por que isso importa hoje?**
1. **Prefira coleções a arrays** quando possível. Elas são mais seguras, mais flexíveis e itnegram melhor com a API moderna do Java.
2. **Nunca ignore *unchecked warnings*.** Elas são o compilador dizendo: "Não posso garantir que isso não vai estourar em runtime."
3. **Entenda que genéricos são uma promessa do compilador**, não uma garantia da JVM. A segurança depende de não burlarmos com *raw types* ou *casts* inseguros.

---
## Generics Versus Templates
Os genéricos em Java se assemelham aos *templates* do C++. Há apenas dois pontos importantes a ter em mente sobre a relação entre os genéricos do Java e os templates do C++:  sintaxe e **semântica**. A sintaxe foi deliberadamente tornada similar, enquanto a semântica foi deliberadamente tornada diferente.

**Sintaxe**
Os sinais de "menor que" e "maior que" (<>) foram escolhidos porque são familiares para usuário e C++ e porque colchetes ([]) seriam difíceis de analisar sintaticamente *parse* no contexto da linguagem Java.

**Semântica**
Diferença fundamental:

|Característica|Java Genéricos|C++ Templates|
|---|---|---|
|**Mecanismo**|Apagamento de tipo (_erasure_)|Expansão de código (_expansion_)|
|**Compilação**|Uma única versão do bytecode para todos os tipos|Uma nova versão do código é compilada para cada tipo utilizado|
|**Exemplo**|`List<String>`, `List<Integer>` → mesmo código em runtime|`std::list<std::string>`, `std::list<int>` → códigos distintos gerados|

Em C++, cada instanciação de um _template_ com um novo tipo é compilada separadamente. Se usarmos uma lista de inteiros, uma lista de strings e uma lista de listas de strings, haverá **três versões distintas do código**. Se usarmos listas de cem tipos diferentes, haverá cem versões, um problema conhecido como "**code bloat**" (inchaço de código).

No Java, independentemente de quantos tipos de lista utilizarmos, **sempre haverá apenas uma versão do código**, portanto o *bloat* não ocorre.

A **expansão** pode levar a implementações mais eficientes do que o **apagamento**, pois oferece mais oportunidades para otimizações, especialmente para **tipos primitivos**, como #int. Para código que manipula grandes volumes de dados (por exemplo, arrays extensos em computação científica), essa diferença pode ser significativa.

No entanto, na prática, para a maioria dos propósitos, a diferença de eficiência **não é crucial**, enquanto os problemas causados pelo *code bloat* podem ser determinantes, especialmente em termos de tamanho do binário, tempo de compilação e manutenção.

O C++ também oferece a capacidade de manipular **valores**, além de tipos, por meio de uma técnica conhecida como **metaprogramação com templates**. Isso permite usar #templates como uma espécie de "pré-processador com esteroides", capaz de realizar cálculos arbitrariamente complexos **em tempo de compilação**.

Os genéricos do Java foram **deliberadamente restritos a tipos**, com o objetivo de evitar complexidade excessiva. No Java, não podemos fazer computação em tempo de compilação baseada em valores genéricos, e isso é uma escolha de projeto, não uma limitação acidental.

## Generic Methods and Varargs
A seção anterior descreveu como interfaces e classes podem aceitar um argumento de tipo. **Métodos individuais também podem ser genéricos**. Aqui está um método que aceita um array de qualquer tipo e o converte em uma lista do mesmo tipo:
```java
class Lists_1 {
	public static <T> List<T> toList(T[] arr) {
		List<T> list = new ArrayList<T>();
		for (T elt : arr) list.add(elt);
		return list;
	}
}
```
O método estático *toList* aceita um array do tipo T[] e retorna uma lista do tipo `List<T>`, fazendo isso para qualquer tipo de referência T. Isso é indicado escrevendo `<T>` no início da declaração do método, o que declara T como uma **nova variável de tipo**. A variável T pode ser qualquer identificador Java válido, mas, por convenção, identificadores de variáveis de tipo geralmente são letras maiúsculas únicas: T para Type (Tipo), R para ReturnType (Tipo de Retorno), U para um segundo parâmetro de tipo, se necessário, e assim por diante. Um método que declara uma variável de tipo dessa forma é chamado de **método genérico**. O escopo da variável de tipo T é local ao próprio método; ela pode aparecer na declaração do método, mas não fora dele.

O método pode ser invocado da seguinte forma:
```java
List<Integer> ints = List_1.toList(new Integer[] {1, 2, 3});
List<String> words = Lists_1.toList(new String[] { "Hello", "world!"});
```

Empacotar os argumentos em um array é trabalhoso. **Parâmetros de aridade variável**, geralmente chamados de *vaargs*, permitem uma sintaxe especial e mais conveniente para o caso em que o último argumento de um método é um array. Para usar esse recurso, substituímos T[] por T... na declaração do método, obtendo uma declaração muito semelhante à de *java.util.List::of*
```java
class Lists_2 {
	public static <T> List<T> toList(T... arr) {
		List<T> list = new ArrayList<T>();
		for (T elt : arr) list.add(elt);
		return list;
	}
}
```

Agora, o método pode ser invocado da seguinte forma:
```java
List<Integer> ints1 = Lists_2.toList(1, 2, 3);
List<String> words = Lists_2.toList("Hello", "World!");
```

Isso é apenas uma abreviação do que escrevemos anteriormente. Em tempo de execução, os argumentos são empacotados em um array que é passado ao método, exatamente como visto antes.

Qualquer número de argumentos pode preceder o argumento *varargs* final. Aqui está uma versão simplificada do método *java.util.Collections::addAll*, que aceita uma lista e adiciona todos os argumentos adicionais ao final da lista:
```java
public static <T> void addAll(List<T> list, T... arr) {
	for (T elt : arr) list.add(elt);
}
```

Ao chamar um método com um parâmetro *varargs*, podemos passar uma lista de argumentos a serem implicitamente empacotados em um array ou passar explicitamente o array diretamente. Assim, *addAll* pode ser invocado da seguinte forma:
```java
List<Integer> ints = new ArrayList<Integer>();
Lists_3.addAll(ints, 1, 2);
Lists_3.addAll(ints, new Integer[] {3, 4});
assert ints.equals(List.of(1, 2, 3, 4));
```

Veremos mais adiante que, ao tentarmos criar um array contendo um tipo genérico, sempre receberemos um aviso não verificado (*unchecked warning*). Como os *varargs* sempre criam um array, eles devem ser usados com cuidado quando o argumento tiver um tipo genérico (consulte "Criação de Arrays e Varargs" na página 91).

O parâmetro de tipo do método genérico é **inferido** nestes exemplos, o que ilustra a situação usual em que um ou mais argumentos correspondentes a um parâmetro de tipo possuem todos o mesmo tipo. Quando não há argumentos, ou os argumentos são de diferentes subtipos do tipo pretendido, o parâmetro de tipo pode precisar ser fornecido explicitamente. Por exemplo:
```java
var ints = List_2.<Integer>toList();
var objs = Lists_2.<Object>toList(1, "two");
```

No primeiro exemplo, sem o parâmetro de tipo explícito, o tipo inferido seria *Object*. No segundo exemplo, o tipo inferido não apenas herdaria de *Object*, mas também implementaria todas as interfaces que tanto #Integer quanto #String implementam, incluindo (mas não apenas) #Serializable e #Comparable. Isso é um **tipo de interseção;** exploraremos os tipos de interseção em detalhes em "Múltiplos Limites" na página 53.

Quando um parâmetro de tipo é passado para uma invocação de método genérico, ele aparece entre sinais de menor que e maior que à esquerda, assim como na declaração do método. A gramática do Java exige que os parâmetros de tipo apareçam apenas em invocações de método que usam a forma como ponto (*dotted form*). Mesmo que o método *toList* esteja definido na mesma classe que invoca o código ou seja importado como um método estático, **não podemos** abreviá-lo da seguinte forma:
```java
List<Integer> ints = <Integer>toList(); 
```

## Primitive and Reference Types
O último tópico a ser considerado neste capítulo introdutório é o de **tipos primitivos versus tipos de referência.**

Um **tipo de referência** é qualquer classe, interface ou tipo de array, enquanto um **tipo primitivo** é um dos oito listados na Tabela 1-1. Essa distinção é fundamental par aa implementação de genéricos no Java, na qual **apenas tipos de referência podem ser usados como parâmetros de tipo;** tipos primitivos não são permitidos. Assim, por exemplo, em vez de escrever `List<int>`, escrevemos `List<Integer>`.

Todos os tipos de referência são subtipos da classe *Object*, e qualquer variável de tipo de referência pode receber o valor *null*. A tabela 1-1 mostra, para cada um dos oito tipos primitivos, a classe correspondente de tipo de referência na biblioteca, localizada no pacote *java.lang*.

### 📋 Tabela 1-1. Tipos primitivos e tipos de referência correspondentes

| Primitivo | Referência  |
| --------- | ----------- |
| `byte`    | `Byte`      |
| `short`   | `Short`     |
| `int`     | `Integer`   |
| `long`    | `Long`      |
| `float`   | `Float`     |
| `double`  | `Double`    |
| `boolean` | `Boolean`   |
| `char`    | `Character` |

**Boxing e Unboxing**
A conversão de um tipo primitivo para o tipo de referência correspondente é chamada de **boxing**. O compilador frequentemente pode inserir código para realizar essa conversão automaticamente: isso é chamado de **autoboxing**.  A conversão inversa, na qual um valor de referência é "desembrulhado" para produzir um valor do tipo primitivo correspondente é chamado de #unboxing.

As conversões de boxing e unboxing são aplicadas automaticamente quando apropriado:

| Situação                                             | Conversão aplicada           |
| ---------------------------------------------------- | ---------------------------- |
| Expressão `e` do tipo `int` onde se espera `Integer` | Boxing: `Integer.valueOf(e)` |
| Expressão `e` do tipo `Integer` onde se espera `int` | Unboxing: `e.intValue()`     |

Por exemplo, a sequência:
```java
// org/jgcbook/chapter01/C_primitive_and_reference_types/Program_1
List<Integer> ints = new ArrayList<Integer>();
ints.add(1);
int n = ints.getFirst();
```


produz um bytecode equivalente ao produzido por:
```java
List<Integer> ints = new ArrayList<Integer>();
ints.add(Integer.valueOf(1));
int n = ints.get(0).intValue();
```

A chamada *Integer.valueof(1)* retorna uma instância de **Integer** representando o valor int. O método de fábrica `Integer::valueOf` é preferível ao construtor `Integer::new`, que foi **depreciado no Java 11** e marcado para remoção no Java 16, pois permite a possibilidade de reutilizar objetos `Integer` em cache.⁴

Na verdade, a _Java Language Specification_ (Gosling et al. 2023, §5.1.7) exige o armazenamento em cache (_caching_) para certos valores: ela determina que quaisquer duas conversões de boxing desses valores devem retornar a **mesma referência**. Os valores concernés são:

- `int` e `short` entre **-128 e 127** (inclusive)
- `char` entre `'\u0000'` e `'\u007f'`
- `byte` (todos os valores)
- `boolean` (todos os valores)

Portanto, esta asserção **sempre terá sucesso**:
```java
assert Integer.valueOf(5) == Integer.valueOf(5);
```

Enquanto esta geralmente terá sucesso, mas pode não ter, dependendo da política de cache da JVM:
```java
assert Integer.valueOf(500) != Integer.valueOf(500);
```


**Exemplo prático: somando uma lista de inteiros**
Aqui está novamente o código para calcular a soma de uma lista de inteiros, convenientemente encapsulado como um método estático:
```java
public static int sum(List<Integer> ints) {
	int s = 0;
	for (int n : ints) { s += n;}
	return s;
}
```

**Por que o argumento tem tipo `List<Integer>` e não `List<int>`?**
Parâmetros de tipos devem sempre ser vinculados a tipos de referência, não a tipos primitivos.

**Por que o método foi definido para retornar int e não Integer?**
Porque tipos de retorno podem ser primitivos ou de referência, e é mais eficiente usar o primitivo do que o segundo. O unboxing ocorre quando cada Integer na lista ints é vinculado à variável *n* do tipo **int**.

Poderíamos reescrever o método, substituindo cada ocorrência de *int* por *Integer*:
```java
public static Integer sumInteger(List<Integer> ints) {
	Integer s = 0;
	for (Integer n : ints) { s += n;}
	return s;
}
```

Esse código compila e executa corretamente, mas realiza muito trabalho desnecessário. A cada iteração do loop, os valores em s e n sofrem unboxing, a adição é realizada e o resultado é novamente submetido a *boxing*. Em uma aplicação contendo código como este em um caminho crítico (critical path), onde ele é executado com muito frequência, o trabalho de boxing e unboxing pode ter **um grande impacto no desempenho**.

 O caso especial do `null`
Existe um valor de `Integer` que não corresponde a um `int` válido: este é o **`null`**, que é membro de todo tipo de referência. Fornecer a qualquer versão do método `sum` uma lista contendo um valor `null` resultará em uma `NullPointerException`. Tomando a segunda versão como exemplo:
```java
jshell> chapter01.C_primitive_and_reference_types.SumInteger.sumInteger(
 ...> Arrays.asList(1, 2, 3, null))
| Exception java.lang.NullPointerException: Cannot invoke \
"java.lang.Integer.intValue()" because "<local3>" is null
|   at SumInteger.sumInteger (SumInteger.java:8)
|   at (#3:1)
```

## Conclusão
Neste capítulo, vimos a ideia básica dos genéricos no Java e aprenderemos seu propósito: **permitir a reutilização do mesmo código em objetos de tipos diferentes de forma segura em relação aos tipos type-safe**

As informações de tipo genérico são descartadas após a compilação; esse processo é chamado de **apagamento (erasure)**, e precisaremos estudar suas consequências em profundidade.

No próximo capítulo, veremos como os genéricos funcionam com o sistema de subtipagem polimórfica orientada a objetos do Java.