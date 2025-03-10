## 1.1 The structures of a Java class and a source code file
*Define the structure of a java class*

Esta seção aborda as estruturas e componentes tanto de um arquivo de código-fonte Java (arquivo *.java*) quanto de uma classe Java (definida usando a palavra-chave *class*). Também aborda as diferenças entre um arquivo de código-fonte Java e uma classe Java.

Primeiro as coisas mais importantes (first things first). Comece sua preparação para o exame com uma compreensão clara do que é exigido de você no exame de certificação. Por exemplo, tente responder à seguinte dúvida de um candidato à certificação: *Eu me deparo com o termo classe com diferentes significados: **class Person**, o arquivo de código-fonte Java (Person.java) e o bytecode Java armazenado em Person.class. Quais dessas estruturas estarão no exame?*. 

- Classe *Person* -> Person.java;
- Bytecode Java armazendo em -> Person.class.
![[Capítulo 1 - Java Basics.png]]

Como podemos ver na figura 1.1, uma pessoa pode ser representada por uma classe Java *Person*. Essa classe deve residir em um arquivo de código-fonte Java (*Person.java*). Usando esse arquivo de código-fonte Java, o compilador Java *javac.exe* no Windows ou *javac* Mac OS X/Linux/UNIX gera o **bytecode** (código compilado para a Java Virtual Machine) e o armazena em *Person.class*. 

### 1.1.1 Structure of a Java class
The  OCA Java SE 8 Programmer I exam will question you on the<span style="background:#d4b106"> structure and components</span> of a Java source file and the classes or interfaces that you can define in it. Figure 1.2 shows the components of a Java class file (interfaces are covered in detail in chapter 6).

In this sections, I'll discuss all Java class file components. Let's get started with the *package* statement.
![[Capítulo 1 - Java Basics-1.png]]

**NOTA:** O código deste livro não inclui muitos espaços - ele imita o tipo de código que veremos no exame. Mas, ao trabalhar com projetos reais, recomendo fortemente que usemos espaços ou comentários para tornar o nosso código legível.

**Package Statement**
All Java classes are part of a package. A Java class can be explicitly defined in a named package; caso contrário, ela se torna parte de um pacote padrão, que não possui nome. Uma declaração de pacote *package* é usada para definir explicitamente a qual pacote uma classe pertence. Se uma classe incluir uma declaração de pacote, esta deve ser a primeira instrução na definição da classe:

```java
package certification;
class Course {

}
```
A declaração de pacote *package* não pode aparecer dentro da declaração de uma classe ou após a declaração da classe. 

Also, if present, the *package* statement must appear exactly once in a class. 
```java
package com.cert; // A class can't define multiple package statements;
package com.exams;
class Course {

}
```

**Import Statement**
Classes e interfaces no mesmo pacote podem usar umas às outras sem precisar prefixar seus nomes com o nome do pacote. No entanto, para usar uma classe ou interface de outro pacote, devemos usar seu **nome totalmente qualificado**, ou seja, *packageName.anySubPackageName.ClassName*. Por exemplo, o nome totalmente qualificado da classe #String é *java.lang.String*. 

Como o uso de nomes totalmente qualificados pode ser tedioso e tornar o nosso código difícil de ler, podemos usar a declaração *import* para utilizar o nome simples de uma classe ou interface em nosso código.

Vamos analisar isso usando um exemplo de class, *AnnualExam*, que está definida no pacote *university*. A classe *AnnualExam* está associada à classe *certification.examQuestion*, conforme mostrado no diagrama de classes da **Unified Modeling Language (UML)** na figura 1.3.

![[Capítulo 1 - Java Basics-2.png]]

**NOTA:** um diagrama de classes UML representa a visão estática de uma aplicação. Ele mostra entidades como pacotes, classes, interfaces e seus atributos (campos e métodos) e também descreve as relações entre eles. Ele indica quais classes e interfaces estão definidas em um pacote. Representa a relação de herança entre classes e interfaces. Também pode ilustrar as associações entre elas - quando uma classe ou interface define um atributo de outro tipo. Todas as representações UML neste capítulo são diagramas de classes. O exame não cobre diagramas UML. No entanto, o uso desses diagramas rápidos e simples facilita a compreensão entre as entidades Java - tanto no exame quanto em seus projetos do mundo real.

Here's the code for class *AnnualExam:*
```java
package university;
import certification.ExamQuestion;
class AnnualExam {
	ExamQuestion eq;
}
```
Observe que a declaração *import* segue a declaração de pacote (*package*), mas precede a declaração da classe. O que acontece se a classe *AnnualExam* não estiver em um pacote? Haverá alguma mudança no código se as classes *AnnualExam* e *ExamQuestion* estiverem relacionadas, conforme ilustrado na Figura 1.4?

Neste caso, a classe *AnnualExam* não faz parte de um pacote explícito, mas a classe *ExamQuestion* faz parte do pacote *certification*. 

Se uma declaração de pacote estiver presente em uma classe, a declaração de importação deve vir após a declaração de pacote. É importante manter a ordem de ocorrência das declarações de pacote e importação. 

```java
import certification.ExamQuestion;
package university;
class AnnualExam {
	ExamQuestion eq;
}
```

O código acima não irá compilar, por causa de uma declaração de import definida antes da declaração de *package*.

**Comments**
Também podemos adicionar comentários ao nosso código Java. Os comentários podem aparecer em vários lugares em uma classe. Um comentário pode aparecer <span style="background:#d4b106">antes ou depois de uma declaração de pacote</span>, antes ou depois da definição da classe, assim como antes, dentro ou após a definição de um método. Os comentários vêm em dois tipos: comentários de múltiplas linhas e comentários de fim de linha. 

Multiline comments span multiple lines of code. They start with /* and end with * /.

No código anterior, os comentários não começam com um asterisco em cada linha. Mas na maioria das vezes, quando você vê um comentário de múltiplas linhas em um arquivo de código-fonte Java (.java), notará que ele usa um asterisco ( * ) para iniciar o comentário na próxima linha. Observe que isso não é obrigatório — é feito mais por razões estéticas. Aqui está um exemplo:
```java
/*
*
*
*
/*
```

Os comentários de fim de linha começam com // e, como evidente pelo nome, são colocados no final de uma linha de código ou em uma linha em branco. O texto entre // e o final da linha é tratado como um comentário, que normalmente usamos para descrever brevemente a linha de código.
```java
class Person {
	String fName; // variable to store Person's first name
	String id; // a 6 letter id generated by the database
}
```

Embora o uso de comentários de múltiplas linhas no código a seguir seja incomum, o exame espera que saibamos saiba que o código é válido:
```java
String name = /* Harry */ "Paul";
System.out.println(name);
```
A saída acima será Paul;

```Java
String name = "/* Harry */ Paul"; 
System.out.println(name);
```
Outputs será /* Harry */ Paul

Quando incluímos dentro de aspas duplas, os comentários de múltiplas linhas são tratados como caracteres comuns e não como comentários. Portanto, o código a seguir não será compilado porque o valor atribuído à variável *name* é um literal de string não fechado:
```java
String name = "Shre /* ya 
*/ Paul"; 
System.out.println(name);
```

Na seção anterior sobre a declaração do pacote, vimos que uma declaração de pacote, se presente, deve ser a primeira linha de código em uma classe. <span style="background:#d4b106">A única exceção a essa regra é a presença de comentários.</span> Um comentário pode preceder uma declaração de pacote. O código a seguir define uma declaração de pacote, com comentários de múltiplas linhas e de fim de linha:
```java
/* Este é um comentário de múltiplas linhas
   que precede a declaração de pacote */
// Este é um comentário de fim de linha
package university;

class AnnualExam {
    // Código da classe
}
```

Um comentário de fim de linha também pode ser declarado dentro de um comentário multiline. Isto é aceitável. O comentário de fim de linha será tratado como parte de um comentário multiline, e não como um comentário de fim de linha a parte. 

O comentário de múltiplas linhas é colocado antes da declaração de pacote, o que é aceitável porque os comentários podem aparecer em qualquer lugar do nosso código.

**Comentários Javadoc**
Os comentários #Javadoc são comentários especiais que começam com / ** e terminam com * / em um arquivo de código-fonte Java. Esses comentários são processados pelo #Javadoc, uma ferramenta do JDK, para gerar a documentação de API para seus arquivos de código-fonte Java. Para ver isso em ação, comparamos a documentação da API da classe **String** com seu arquivo de código-fonte (String.java).

**Class Declaration**
The class declaration marks the start of a class. It can be as simples as the keyword *class* followed by the name of a class:
```java
class Person {
//...
//...
}
```

The declaration of a class is composed of the following parts:
- Acess modifiers;
- Nonaccess modifiers;
- Class name;
- Name of the base class, if the class is extending another class;
- All implemented interfaces, if the class is implementing any interfaces;
- Class body (class fields, methods, constructors), included within a pair of curly braces, {}.

Vamos analisar os components de uma declaração de classe usando um exemplo:
*public final class Runner extends Person implements Athlete {}*

Os componentes **obrigatórios** são:
- keyword class;
- Name of the class;
- Class body, marked by the opening and closing curly braces, {}.

Os componentes **opcionais** são:
- Modificadores de acesso, tal como *public*
- Modificadores de class, tal como *final*
- Palavras chaves *extends* junto com o nome da classe extendidas;
- Palavra chave *implements* junto com o nome das interfaces que são implementadas.

**Class Definition**
Uma classe é um projeto usado para especificar os **atributos** e o **comportamento** de um objeto. Os **atributos** de um objeto são implementados **usando variáveis**, e o comportamento é implementado **usando métodos**. Por exemplo, consideramos uma classe como sendo o projeto ou especificação de um telefone celular, e um telefone celular como sendo um objeto desse projeto. O **mesmo projeto** pode ser usado para criar vários telefones celulares, assim como a Máquina Virtual Java usa uma classe para criar seus objetos. Podemos considerar uma classe como sendo uma espécie de molde que pode ser usado para criar objetos significativos e úteis. <span style="background:#d4b106">Uma classe é um projeto a partir do qual um objeto pode ser criado</span>.

Let's define a simple class to represent a mobile phone:
```java
class Phone {
	String model;
	String company;
	Phone(String model) {
		this.model = model;
	}
	double weight;
	void makeCall(String number) {
		// code
	}
	void receiveCall() {
		// code
	}
}
```

**Pontos a recordar**
- O nome de uma classe começa com a palavra chave *class*. Fique atendo para o caso da palavra-chave *class*. O Java é cAsE-sEnSiTiVe. *class* não é o mesmo que Class com maiúsculo. Não podemos usar a palavra Class com  "C" maiúsculo para definir uma classe.
- **O estado de uma classe é definido usando atributos ou variáveis de instância.**
- **Não é obrigatório definir todos os atributos de uma classe antes de definir seus métodos** (a variável *weight* é definida após o construtor de *Phone*). Mas isto está longe de ser ideal para legibilidade.
- **O comportamento é definido usando métodos, que podem incluir parâmetros de método.**
- **A definição de uma classe também pode incluir comentários e construtores.**

**Variáveis**
Como as variáveis *model*, *company* e *weight* são usadas para armazenar o estado de um objeto (também chamado de #instância), elas são chamadas de **variáveis de instância** ou **atributos de instância**. Cada objeto possui sua própria cópia de variáveis de instância. Se alteramos o valor de uma variável de instância para um objeto, o valor da mesma variável de instância não será alterado para outro objeto.

As variáveis de instância são definidas dentro de uma classe, <span style="background:#d4b106">mas fora de todos os métodos da classe</span>.

Uma única cópia de uma variável de classe ou variável estática é compartilhada por todos por todos os objetos de uma classe. As variáveis estáticas são abordadas na seção 1.5.3, com uma discussão detalhada sobre o modificador não acessível *static*.

**Methods**
Os métodos makeCall e receiveCall são chamados de **métodos de instância**, que geralmente são usados para manipular as variáveis de instância. 

Um método de classe ou método estático pode ser usado para manipular as variáveis estáticas, conforme discutido em detalhes na seção 1.5.3.

**Constructors**
A classe **Phone** no exemplo anterior define um único construtor. Um construtor de classe<span style="background:#d4b106"> é usado para criar e inicializar os objetos de uma classe</span>. Uma classe pode definir múltiplos construtores que aceitam diferentes conjuntos de parâmetros de método.

## 1.1.2 Structure and components of a Java source code file
Um arquivo de código fonte Java é usado para definir entidades Java, como uma **classe**, **interface**, enum e anotação.

**NOTA:** as anotações Java não estão no exame e, portanto, não serão discutidas neste livro.

Todo o seu código Java deve ser definido em arquivos de código-fonte Java (arquivo de texto cujos nomes terminam com *.java*). O exame aborda os seguintes aspectos da estrutura de um arquivo de código-fonte Java:
- Definição de uma classe e uma interface em um arquivo de código-fonte Java;
- Definição de classes ou interfaces únicas ou múltiplas no mesmo arquivo de código-fonte Java;
- Aplicação de declarações *import* e *package* para todas as classes em um arquivo de código-fonte Java.

Já abordamos a estrutura detalhada e a definição de classes na seção 1.1.1. Vamos começar com a definição de uma #interface.

**Definition Of An Interface in a Java Source Code File**
Uma #interface específica um contrato para que as classes o implementem. Podemos comparar a implementação de uma interface à assinatura de um contrato. Uma interface é um agrupamento de métodos e constantes relacionados.  Antes do Java 8, os métodos de uma interface eram implicitamente abstratos. Mas a partir da versão 8 do Java, os métodos em uma interface podem definir uma implementação padrão (default implementation). Com o Java 8, as interfaces também podem definir métodos estáticos.

Os métodos eram chamados de **abstratos**, porque:
1. **Não tinham corpo (implementação)**: 
	- Eles só tinham a assinatura do método (nome, parâmetros e tipo de retorno), mas não tinham nenhum código dentro deles.
	- Exemplo: public interface Veiculo {
			void acelerar(); // Método abstrato (sem corpo)
		}

2. **As classes que implementavam a interface eram obrigadas a fornecer a implementação:**
- Qualquer classe que implementasse essa interface precisava implementar todos os métodos declarados nela.
- Exemplo: 
```java
public class Carro implements Veiculo {
	@Override
	public void acelerar() {
		System.out.println("Carro acelerando...");
	}

	@Override
	public void frear() {
		System.out.println("Carro freando...");
	}
}
```

3. **Por que "implicitamente abstratos"?**
- Os métodos não precisavam ser explicitamente marcados como #abstract porque, por definição, todos os métodos em uma interface já eram abstratos. O compilador tratava isso automaticamente.

Aqui está um exemplo rápido para compreendermos a essência das interfaces. Não importa qual marca de televisão cada um de nós tenha, todas as televisões fornecem funcionalidades comuns, como mudar de canal e ajustar o volume. Podemos comparar os controles de um televisor a uma **interface** e o design do televisor a uma **classe** que implementa essa interface de controles.

Vamos definir esta interface:
```java
interface Controls {
	void changeChannel (int channelNumber);
	void increaseVolume();
	void decreaseVolume();
}
```
A definição de uma interface começa com a palavra-chave #interface. Lembre-se, o Java é sensível a maiúsculas e minúsculas, então não podemos usar a palavra chave #Interface com maiúscula.

**Definition of Single And Multiple Classes in A Single Java Source Code File**
Podemos definir uma única classe ou interface em um arquivo de código-fonte Java ou várias dessas entidades. Vamos começar com um exemplo simples: um arquivo de código-fonte Java chamado *SingleClass.java* que define uma única classe *SingleClass*:

```java
class SingleClass {
	//.. we are not detailing this part
}
```

Here's am example of a Java source code file, Multiple.java, that defines multiple interfaces:
```java
interface Printable {
	//.. we are not detailing this part
}
interface Movable {
	//.. we ara not detailing this part
}
```

Também podemos definir uma combinação de classes e interfaces no mesmo arquivo de código-fonte Java. Aqui está um exemplo:
```java
interface Printable {
    //.. não estamos detalhando esta parte
}
class MyClass {
    //.. não estamos detalhando esta parte
}
interface Movable {
    //.. não estamos detalhando esta parte
}
class Car {
    //.. não estamos detalhando esta parte
}
```

Não é necessário uma ordem específica para definir várias classes ou interfaces em um único arquivo de código-fonte Java.

**Dica de Prova:** As classes e interfaces podem ser definidas em qualquer ordem de ocorrência em um arquivo de código-fonte Java.

