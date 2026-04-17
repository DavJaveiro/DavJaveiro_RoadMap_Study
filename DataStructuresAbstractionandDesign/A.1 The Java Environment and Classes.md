Before we talk about the Java Language, we will briefly discuss the Java Environment and how Java programs are executed. Java, developed by Sun Microsystems Corporation, enjoys its popularity because it is a *platform-independent*, object-oriented language and because Java facilitated developing software for the World Wide Web. 

Ser independente de plataforma significa que um programa Java será executado em qualquer tipo de computador. Embora a independência de plataforma seja uma meta para todos os programas de linguagem de alto nível, ela nem sempre é alcançada.

Java está mais perto de atingir esse objetivo do que a maioria, fornecendo implementações da JVM (discutida a seguir) para muitas plataformas.

## The Java Virtual Machine
O Java é independente de plataforma porque os projetistas do Java utilizam o conceito de uma Máquina Virtual Java (JVM), que é um "computador" de software executado em um computador real. 

Antes de poder executar um programa Java, as classes do programa Java devem primeiro ser traduzidas da linguagem Java na qual foram escritas para um **formato executável** da maneira tradicional por um programa compilador.  Entretanto, em vez de um arquivo de instruções de linguagem de máquina dependentes da plataforma, que é a saída normal de um compilador, o compilador Java gera um arquivo de instruções de código de byte Java independentes da plataforma. 

Quando executamos o programa, o JVM do nosso computador interpreta cada instrução de código de byte e executa. A JVM para máquinas que executam o Microsoft Windows é diferente da JVM para máquinas UNIX ou Apple, mas todas processam as instruções de código de byte da mesma forma.

## The Java Compiler
O compilador Java também é específico da plataforma, embora produza o mesmo arquivo de código de bytes para um determinado programa-fonte Java em todas as plataformas. Ele deve ser específico da plataforma porque executa instruções em linguagem de máquina para uma determinada plataforma, e essas instruções não são as mesmas para todas as plataformas. 

## Classes and Objects
Em Java e na programação orientada a objetos em geral, a classe é a unidade fundamental de programação. Todo programa é escrito como uma coleção de classes, e todo código que escrevemos deve fazer parte de uma classe. Em Java, as definições de classes são armazenadas em arquivos separados com a extensão *.java*. O nome do arquivo deve ser o mesmo que o nome da classe definida dentro dele.

Uma classe é uma descrição geral de um grupo de entidades (chamadas de objetos ou instâncias da classe) que possuem todas as mesmas características, ou seja, todas podem executar os mesmos tipos de operações (métodos da classe), e as mesmas informações (atributos ou campos de dados da classe) são significativamente para todas elas. Por exemplo, a classe Casa descreveria uma coleção de entidades que possuem cada uma um número de quartos, um número de banheiros, um tipo de telhado, e assim por diante (mas não uma potência em cavalos ou quilometragem); todas podem ser construídas, reformadas, avaliadas para imposto sobre a proriedade, etc. (mas não ter o fluido de transmissão trocado). A casa onde moramos e a casa onde o nosso melhor amigo mora podem ser representadas por dois objetos da classe Casa.

As classes estendem Java fornecendo tipos de dados adicionais. Por exemplo, a classe **String** é uma classe predefinida que permite ao programador processar sequências de caracteres facilmente.

## The Java API
A linguagem de programação Java consiste em um núcleo de linguagem relativamente pequeno, complementado por uma extensa coleção de pacotes (chamados de bibliotecas em outras linguagens), que constituem a API do Java e conferem capacidades adicionais à linguagem. Cada pacote contém um conjunto de classes Java relacionadas. Utilizaremos vários desses pacotes neste livro didático. Entre eles estão o pacote *javax.swing* e o pacote *java.util*. Podemos obter informações sobre esses pacotes acessando o site da Java mantido pela Oracle Corporation.

A documentação do Java é fornecida como uma coleção interligada de páginas da Web. Na seção A.7, discutiremos como podemos escrever nossa própria documentação.

## The *import* Statement
A seguir, mostramos um exemplo de arquivo-fonte Java (HellowWorld.java) que contém um programa aplicativo (classe HelloWorld). Nosso objetivo no restante desta seção é fornecer uma visão geral do processo de criação e execução de um programa de aplicativo. 
```java
import java.util.Scanner;

/** 
* Uma classe HelloWorld.
* @author Koffman and Wolfgang
**/
public class HelloWorld {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		String nome = scan.nextLine();
		System.out.println("Olá " + nome + ", bem-vindo ao Java!";)
	}
}
```

O arquivo-fonte Java começa com a instrução:
```java
import java.util.Scanner;
```

Essa instrução informa ao compilador Java para tornar a classe *Scanner*, definida no pacote *java.util*, acessível a este arquivo. O ponto e vírgula no final da linha é usado para encerrar uma instrução Java. As três linhas seguintes, delimitadas por /** e * /, são comentários que fornecem informações sobre a classe, mas não são instruções Java executáveis.

A classe *HelloWorld* começa com a linha:
```java
public class HelloWorld {}
```

que identifica *HelloWorld* como uma classe pública e a torna visível para outras classes (ou para a JVM).

## Método main
A linha
```java
public static void main(String[] args) {}
```

identifica o início da definição do método *main*. É aqui que a JVM {Máquina Virtual Java} começa a execução de um programa aplicativo. As palavras *public static void* informam ao compilador que *main* é acessível fora da classe (public), é um método estático (explicado na Seção A.4) e não retorna um valor (void). A parte entre parênteses após *main* descreve os parâmetros do método: um array de Strings chamado *args*. Arrays são discutidos na Seção A.8. Sempre escrevemos o cabeçalho do método *main* dessa forma.

A primeira instrução dentro de *main* declara um objeto *Scanner* chamado *scan* que será usado para ler a entrada do console (System.in). A segunda instrução exibe a mensagem:
```java
Digite seu nome:
```
no console: A instrução
```java
String name = scan.nextLine();
```
lê os caracteres que são digitados antes que a tecla Enter seja pressionada. Esses caracteres são convertidos em uma String e armazenados na variável *name*. Supondo que os caracteres "Kathy" tenham sido digitados, a instrução:
```java
System.out.println("Hello " + name + ", welcome to Java!");
```

## Execution of a Java Program
