*This chapter covers*
- Estabelecendo relacionamentos entre beans;
- Usando injeção de dependência;
- Acessando os beans do contexto do Spring através de injeção de dependência.

No capítulo 2, discutimos o contexto do Spring: o local na memória do aplicativo onde adicionamos as instâncias de objetos que queremos que o Spring gerencie. Como o Spring usa o princípio IoC, conforme discutimos no capítulo 1, <span style="background:#affad1">precisamos dizer ao Spring quais objetos do nosso aplicativo ele precisa controlar</span>. O Spring precisa controlar alguns dos objetos do nosso aplicativo para aprimorá-los com as capacidades que ele fornece. No capítulo 2, aprendemos várias maneiras de *adicionar instâncias de objetos* ao contexto do Spring. Aprendemos que também adicionamos essas instâncias (beans) ao contexto do Spring para torná-lo ciente delas.

Neste capítulo, discutimos como acessar os beans que adicionamos ao contexto do Spring. No capítulo 2, usamos o método *getBean()* da instância do contexto diretamente para acessar os beans, mas, em aplicativos, precisamos referenciar um bean a partir de outro de uma maneira direta - dizendo ao Spring para fornecer uma referência a uma instância do seu contexto onde for necessário. Dessa forma, estabelecemos relacionamentos entre os beans (um beans terá uma referência a outro para delegar chamadas quando necessário). 

Como já sabemos, muitas vezes, em qualquer linguagem de programação orientada a objetos, **um objeto precisa delegar responsabilidades específicas a outros** ao implementar seu comportamento, então *você precisa saber como estabelecer tais relacionamentos* entre objetos ao usar o Spring como framework também. 

Você aprenderá que há mais maneiras de acessar os objetos que adicionou ao contexto do Spring, e estudaremos cada uma com exemplos, visuais e, claro, trechos de código. Ao final deste capítulo, teremos as habilidades necessárias para usar o contexto do Spring e configurar beans e os relacionamentos entre eles. Esta habilidade é a base do uso do Spring; não há nenhum aplicativo Spring em que não aplicaremos as abordagens discutidas neste capítulo. Por isso, tudo neste livro (e tudo que aprenderemos em qualquer outro livro, artigo ou tutorial em vídeo) depende do entendimento adequado das abordagens discutidas nos capítulos 2 a 5.

No capítulo 2, aprendemos a usar a anotação *@Bean* para adicionar beans ao contexto do Spring. Na seção 3.1, começamos implementando um relacionamento entre dois beans que definimos na classe de configuração usando a anotação *@Bean*. Aqui, <span style="background:#d4b106">discutimos duas maneiras de estabelecer relacionamentos entre beans</span>:

- Vincular os beans chamando diretamente os métodos que os criam (o que chamaremos de *wiring*);
- Permitir que o Spring nos forneça um valor usando um parâmetro de método (o que chamaremos de *auto-wiring.*

Então, na seção 3.2, discutimos uma terceira abordagem, que é uma técnica suportada pelo princípio IoC: injeção de dependência (DI). Discutiremos como usar DI (injeção de dependência) no Spring, aplicando a anotação *@Autowired* para implementar o relacionamento entre dois beans (que também é um exemplo de auto-wiring). Usaremos essas duas abordagens juntas em projetos do mundo real.

**NOTA:** Podemos pensar que os exemplos nos capítulos 2 e 3 não estão próximos o suficiente do código de produção. Afinal, aplicativos reais não gerenciam papagaios e pessoas! Mas eu quero começar suavemente com os exemplos mais simples e garantir que você se concentre nessas sintaxes essenciais, que você usará em praticamente todos os aplicativos Spring. Desta forma, garanto que você compreenda adequadamente como as abordagens discutidas funcionam e se concentre apenas nelas. <span style="background:#d4b106">A partir do capítulo 4, nosso design de classe ficará mais próximo do que você encontrará em projetos do mundo real</span>.


## 3.1 Implementing relationships among beans defined in the configuration file

Nesta seção, aprenderemos a implementar o relacionamento entre dois beans definidos na classe de configuração, anotando métodos com a anotação *@Bean*. Frequentemente encontraremos essa abordagem para estabelecer os relacionamentos entre beans usando a configuração do Spring. No capítulo 2, discutimos que usamos a anotação *@Bean* para adicionar beans ao contexto do Spring nos casos em que não podemos alterar a classe para a qual queremos adicionar o beans, por exemplo, se a classe faz parte do JDK ou de outra dependência. E para estabelecer relacionamentos entre esses beans, precisamos aprender as abordagens discutidas nesta seção. Discutiremos como essas abordagens funcionam, fornecerei os passos necessários para implementar os relacionamentos entre os beans e, em seguida, aplicaremos esses passos com pequenos projetos de código.

Suponhamos que temos duas instâncias no contexto do Spring: um papagaio e uma pessoa. Vamos criar e adicionar essas instâncias ao contexto. Em outras palavras, precisamos vincular as duas instâncias. Este exemplo simples nos ajuda a discutir as duas abordagens para vincular os beans no contexto do Spring sem adicionar complexidade desnecessária e permite que nos concentremos apenas nas configurações do Spring.

Portanto, para cada uma das duas abordagens (wiring e auto-wiring), temos dois passos:
1. Adicionar os beans de pessoa e papagaio ao contexto do Spring (como aprendemos no capítulo 2);
2. Estabelecer um relacionamento entre a pessoa e o papagaio. 

![[Capítulo 3 - The Spring Context - Wiring Beans.png]]

**STEP 1:** In the Spring context you add a parrot and a person as beans;
**STEP 2:** You make the person own the parrot.

Antes de mergulharmos em qualquer uma das abordagens, vamos começar com o primeiro exemplo deste capítulo para lembrar como adicionar os beans ao contexto do Spring usando métodos anotados com *@Bean* na classe de configuração. **(Passo 1)**

Adicionaremos uma instância de papagaio e uma instância de pessoa. Depois que tivermos esse projeto pronto, mudamos para estabelecer a relação entre as duas instâncias **(passo 2)**. 

No arquivo pom.xml do projeto Maven, adicionamos a dependência para o contexto do Spring, conforme encontramos no trecho de código a seguir:

```java
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-context</artifactId>
<version>5.2.7.RELEASE</version>
</dependency>
```
Então, definimos uma classe para descrever o objeto *Parrot* e outra para descrever o objeto *Person*. 

[[Spring Start Here/PART 1/Capítulo 3 - The Spring context - Wiring beans/SpringStartHere3/src/main/java/com/DavJaveiro/helloWorldJPA/main/Person.java| Classe Person]]
[[Spring Start Here/PART 1/Capítulo 3 - The Spring context - Wiring beans/SpringStartHere3/src/main/java/com/DavJaveiro/helloWorldJPA/main/Parrot.java| Class Parrot]]

Agora, vamos definir as anotações *@Beans* na classe de configuração:

[[Spring Start Here/PART 1/Capítulo 3 - The Spring context - Wiring beans/SpringStartHere3/target/classes/com/DavJaveiro/helloWorldJPA/configuration/ProjectConfig.class|ProjectConfig]]

 A coisa mais importante a ser observada aqui é que o papagaio da pessoa (terceira linha de saída) é nulo. No entanto, tanto a instância da pessoa quanto a do papagaio estão no contexto. A saída é nula, o que significa que não há uma relação entre as instâncias.

### 3.1.1 Wiring the beans using a direct method call between the @Bean methods

Nesta seção, <span style="background:#d4b106">estabeleceremos a relação entre as duas instâncias de Person e Parrot</span>. A primeira maneira (ligação) de conseguir isso é chamar um método a partir de outro na classe de configuração. Veremos bastante essa forma, pois é uma abordagem direta. Na listagem a seguir, encontramos uma pequena mudança que fizemos na classe de configuração para <span style="background:#d4b106">estabelecer um link entre a pessoa e o papagaio</span>. Para manter todos os passos separados e ajudar a entender o código com mais facilidade.

[[Spring Start Here/PART 1/Capítulo 3 - The Spring context - Wiring beans/SpringStartHere3/src/main/java/com/DavJaveiro/helloWorldJPA/main/Main.java|Main]]

```java
@Configuration
public class ProjectConfig {
	@Bean
	public Parrot parrot() {
		Parrot p = new Parrot();
		p.setName("Koko")
		return p;
	}

	@Bean
	public Person person() {
		Person p = new Person();
		p.setName("Ella");
		p.setParrot(parrot());
		return p;
	}
}
```

Acima, nós definimos a relação entre um bean person e um bean parrot chamando diretamente o método que retorna o bean que nós setamos.

The result is the has-A relationship between the two beans. The person has-A (owns) the parrot.

Sempre que ensino essa abordagem em uma aula, sei que alguns têm a pergunta: isso não significa que criamos duas instâncias de Parrot - uma instância que o Spring cria e adiciona em seu contexto e outra quando o método *person()* faz a chamada direta ao método *parrot()*? Não, na verdade temos apenas uma instância de parrot nesta aplicação.

Pode parecer estranho no início, mas o Spring é esperto o suficiente para entender que ao chamar o método *parrot()*, queremos nos referir ao bean parrot em seu contexto. Quando usamos a anotação @Bean para definir beans no contexto do Spring, o Spring controla como os métodos são chamados e pode aplicar lógica acima da chamada do método (aprenderemos como o Spring intercepta métodos no capítulo 6). Por enquanto, lembre-se de que quando o método *person()* chama o método parrot(), o Spring aplicará lógica, conforme descrito a seguir:
![[Capítulo 3 - The Spring Context - Wiring Beans-1.png]]

*Isso significa que são criadas duas instâncias do tipo parrot?*

Se o bean parrot já existir no contexto, em vez de chamar o método parrot(), o Spring pegará diretamente a instância do seu contexto. Se o bean parrot ainda não existir no contexto, o Spring chama o método parrot() e retorna o bean. 
![[Capítulo 3 - The Spring Context - Wiring Beans-2.png]]
1. A primeira etapa é chamar o método *parrot()* @Bean a partir do método *person()* @Bean;
2. O Bean *Parrot* já existe no contexto do Spring?
3. **A** Se sim, retorna diretamente o bean parrot do contexto do Spring sem delegar a chamada ao método *parrot()*;
**3.B** Se não, chama o método parrot(), adiciona o valor retornado ao contexto do Spring, e retorne o valor para a chamada real feita pelo método person().

Na verdade, é bem fácil testar esse comportamento. Basta adicionar um construtor sem argumentos (no-args constructor) à classe *Parrot* e imprimir uma mensagem no console a partir dele. Quantas vezes a mensagem será impressa no console? Se o comportamento estiver correto, você verá a mensagem apenas uma vez. Vamos fazer este experimento. No próximo trecho de código, eu modifiquei a classe *Parrot* para adicionar um construtor sem argumentos:
```java
public class Parrot {
	private String name;

	public Parrot() {
		System.out.println("Parrot created");
	}

	// Getters e setters omitidos

	@Override
	public String toString() {
		return "Parrot : " + name;
	}
}
```

Dessa forma, você pode observar quantas vezes a mensagem "Parrot created" será impressa no console, indicando a criação de uma instância da classe Parrot.

### 3.1.2 Wiring the beans using the *@Bean* annotated method's paramteres
Nesta seção, iremos mostrar uma abordagem alternativa para chamar diretamente o método *@Bean*. Em vez de chamar diretamente o método que define o *bean* ao qual desejamos nos referir, adicionamos um parâmetro ao método do tipo correspondente ao objeto e contamos com o Spring para nos fornecer um valor através desse parâmetro. Essa abordagem é um pouco mais flexível do que a que discutimos na seção 3.1.1. Com essa abordagem, não importa se o bean ao qual queremos nos referir é definido com um método anotado com *@Bean* ou usando uma anotação de esteriótipo como *@Component*.

Em minha experiência, porém, observei que não é necessariamente essa flexibilidade que faz os desenvolvedores usarem essa abordagem; é principalmente o gosto de cada desenvolvedor que determina qual abordagem eles usam ao trabalhar com beans. Eu não diria que uma é melhor que a outra, mas encontraremos ambas as abordagens em cenários do mundo real, então precisamos entender e ser capaz de usá-las.

Para demonstrar essa abordagem onde usamos um parâmetro em vez de chamar diretamente o método *@Bean*, vamos pegar o código que desenvolvemos no projeto, e alterálo para estabelecer a ligação entre as duas instâncias no contexto. Eu separei o novo exemplo em um projeto chamado *ch3-ex3*.

Dessa forma podemos observar como o Spring consegue gerenciar dependências automaticamente, fornecendo a instância adequada através do parâmetro do método. Essa prática torna o código mais flexível e desacoplado das implementações.

```java
@Bean
public Person person(Parrot parrot) {
	Person p = new Person();
	p.setName("Davidson");
	p.setParrot(parrot);
	return p;
}
```

We instruct Spring to provide (fornecer) a bean from its context by defining a paramter for the method.

*p.setParrot(parrot);* - We set the value of the pseron's attribute with the reference Spring provided.

O resultado que temos é a relação entre dois beans. The person has-A (owns) the parrot.

A classe person tem-A (contém) um *parrot*.

---
**Resumo**
O Spring permite duas formas de injeção de dependência ao definir um Bean:
1. **Injeção de método diretamente:** aqui, criamos uma instância de *Person* e, dentro do método *person()*, definimos o atributo *parrot* chamando o método *parrot()*, que retorna a instância do *Parrot*. É uma forma de obter a dependência de dentro do mesmo contêiner de Spring:
```java
@Bean
public Person person() {
	Person p = new Person();
	p.setName("Davidson");
	p.setParrot(parrot()); // set the reference of the parrot bean to the person's parrot attribute
	return p;

}
```

1. **Injeção por argumento:** neste caso, o método *person()* recebe um parâmetro do tipo *Parrot*, que é injetado automaticamente pelo Spring. **Esta abordagem é útil quando desejamos que o Spring resolva e injete a dependência diretamente**:
```java
@Bean
public Person person(Parrot parrot) {
	Person p = new Person();
	p.setName("Davidson");
	// set the reference of the parrot bean to the person's parrot attribute
	p.setParrot(parrot);
	return p; 
}
```

---
No parágrafo anterior, usei a palavra "injetar". Refiro-me aqui ao que chamamos de agora em diante de injeção de dependência *DI*. Como o nome sugere, <span style="background:#d4b106">DI é uma técnica que envolve o framework definir um valor em um campo ou parâmetro específico</span>. No nosso caso, o Spring define um valor particular no parâmetro do método *person()* ao chamá-lo e resolve uma dependência desse método. DI é uma aplicação do princípio de inversão de controle IoC, e IoC implica que o framework controla a aplicação durante a execução. Repito a figura 3.8, que vimos, como lembrete para nossa discussão sobre IoC.

Logo, o Spring está injetando um valor automaticamente no parâmetro do método *person(Parrot parrot)*. Isso acontece porque o Spring gerencia os *beans* da aplicação e resolve as dependências para nós:

```java
@Bean
public Person person(Parrot parrot) {
	Person p = new Person();
	p.setName("Davidson");
	p.setParrot(parrot);
	return p;
}
```
Quando o Spring encontra esse método anotado com *@Bean*, ele precisa criar um *bean* do tipo *Person*. Para isso, ele vê que o método recebe um parâmetro do tipo *Parrot*. Mas, de onde vem esse *Parrot*?

Aqui entra a *Injeção de Dependência (DI)*. Se houver um bean do tipo *Parrot* já registrado no contexto do Spring, ele automaticamente passa esse bean como argumento para o método *person()*. Ou seja, não precisamos criar manualmente um objeto *Parrot* dentro desse método; o Spring já faz isso para nós. 

Portanto, se *Parrot* não estivesse registrado como um *bean*, o Spring não conseguiria injetá-lo e daria um erro de inicialização.

Isso faz parte do conceito de **Inversão de Controle (IoC)**, onde o próprio framework gerencia a criação e injeção dos objetos, em vez de nós instanciá-los manualmente.



---
**Método chamando outro método diretamente vs *Método que recebe a dependência como parâmetro***

**Desvantagens chamando outro método**:
1. O método *parrot()* pode ser chamado duas vezes, uma para o *bean* *Parrot* e outra dentro de *person()*, gerando instâncias diferentes de *Parrot*. Isso pode quebrar a injeção esperada.
2. O Spring tenta evitar isso usando CGLIB proxying, mas esse comportamento pode variar conforme o escopo do bean.
3. *person()* depende diretamente de *parrot()*, o que significa que se *parrot()* mudar (por exemplo, passar a vir de outro *bean* ou serviço externo), *person()* precisa ser alterado manualmente.
4. Se *parrot()* não estivesse na mesma classe, teríamos que criar uma instância de *ProjectConfig* para chamar *parrot()*, o que não faz sentido dentro do contexto Spring.


A principal diferença entre essas duas abordagens está na forma como o Spring gerencia os _beans_ e suas dependências. Vamos analisar as vantagens e desvantagens de cada uma.

| Critério                      | **Passagem via parâmetro (`public Person person(Parrot parrot)`)** | **Chamada direta do método (`public Person person()`)**     |
| ----------------------------- | ------------------------------------------------------------------ | ----------------------------------------------------------- |
| **Gerenciamento pelo Spring** | ✅ Melhor, pois Spring injeta automaticamente                       | ❌ Pode criar instâncias duplicadas                          |
| **Menos acoplamento**         | ✅ Sim, o método não precisa conhecer a implementação               | ❌ Sim, pois chama diretamente `parrot()`                    |
| **Facilidade de testes**      | ✅ Sim, mais fácil injetar mocks                                    | ❌ Mais difícil substituir `parrot()` sem alterar o código   |
| **Escalabilidade**            | ✅ Melhor para projetos grandes                                     | ❌ Pode gerar comportamento inesperado em escopos diferentes |

💡 **Conclusão:**  
A abordagem com injeção via parâmetro (`public Person person(Parrot parrot)`) é a mais recomendada no Spring porque evita dependências diretas e garante que o Spring sempre controle as instâncias.

Se quiser garantir que `parrot()` retorne a mesma instância ao chamar diretamente `parrot()`, você poderia usar `@Lazy` ou `@DependsOn`, mas o ideal é deixar o Spring gerenciar as dependências corretamente. 🚀

Você frequentemente usará DI (e não apenas no Spring) porque é uma maneira muito confortável de gerenciar instâncias de objetos que são criadas e nos ajudam a minimizar o código que escrevemos ao desenvolver nossos aplicativos.

## 3.2 Using the @Autowired annotation to inject beans
Nesta seção, nós vamos discutir uma outra abordagem utilizada para criar links entre beans no Spring context. Frequentemente encontraremos essa técnica, que se refere a uma anotação chamada *@Autowired*, quando você pode mudar a classe para a qual definimos o bean (quando essa classe não faz parte de uma dependência). Usando a anotação *@Autowired*, marcamos a propriedade de um objeto onde queremos que o Spring injete um valor do contexto, e marcamos essa intenção diretamente na classe que define o objeto que precisa de dependência. Esta abordagem torna mais fácil ver a relação entre o dois objetos do que as alternativas que discutimos na seção 3.1. Como veremos, existem três maneiras de usar a anotação *@Autowired:*
- Injetando o valor no campo da classe, que geralmente encontramos em exemplos e provas de conceito;
- Injetando o valor através dos parâmetros do construtor da classe, uma abordagem que usaremos com mais frequência em cenários do mundo real;
- Injetando o valor através do setter, que raramente usaremos em código pronto para produção. 

### 3.2.1 Using *@Autowired* to inject the values through the class fields
Nesta seção, começamos discutindo a mais simples das três possibilidades de uso do *@Autowired*, que também é a que os desenvolvedores frequentemente usam em exemplos: usando a anotação sobre o campo figura 3.9. Como aprenderemos, mesmo que essa abordagem seja muito direta, ela tem seus pecados, e é por isso que evitamos usá-la ao escrever código de produção. No entanto, veremos essa abordagem sendo usada frequentemente em exemplos, provas de conceito e na escrita de testes, como discutiremos no capítulo 15, então precisaremos saber como usar essa abordagem.

Vamos desenvolver o projeto no qual anotamos o campo *parrot* da classe *Person* com a anotação *@Autowired* para informar ao Spring que queremos injetar um valor ali a partir  do seu contexto. Vamos começar com as classes que definem nossos dois objetos: *Person* e *Parrot*. Aqui está a definição da classe *Parrot*:
```java
@Component
public class Parrot {
	private String name = "Koko";

	// Omitted getters and setters
	
	@Override
	public String toString() {
		return "Parrot : " + name;
	}
}
```

```java
@Component
public class Person {
	private String name = "Davidson";

	@Autowired
	private Parrot parrot;
}
```
- *@Component* - The stereotype annotation instruí o Spring a criar e adicionar um bean ao context de um tipo da classe *Person*; 
- *@Autowired* - We instruct Spring to provide a bean from its context and set it directly as the value of the field, annotated with *@Autowired*. This way we establish a relationship between the two beans.

**NOTA:** Usei anotações de estereótipo para adicionar os beans no contexto do Spring para este exemplo. Eu poderia ter definido os beans usando *@Bean*, mas, na maioria das vezes, em cenários do mundo real, encontraremos o *@Autowired* usado junto com anotações de estereótipo. Portanto, vamos focar nessa abordagem

Para continuar nosso exemplo, definimos uma classe de configuração. Vamos nomear a classe de configuração como *ProjectConfig*. Sobre essa classe, usarei a anotação *@ComponentScan* para informar ao Spring onde encontrar as classes que anotei com *@Component*, como aprendemos no capítulo 2. 
[[Spring Start Here/PART 1/Capítulo 3 - The Spring context - Wiring beans/SpringStartHere3Ex4/src/main/java/com/DavJaveiro/helloWorldJPA/configuration/ProjectConfig.java|ProjectConfig]]

Vamos adicionar a classe principal (main class) para provar que o Spring injetou corretamente a referência do bean *parrot*:
[[Spring Start Here/PART 1/Capítulo 3 - The Spring context - Wiring beans/SpringStartHere3Ex4/target/classes/com/DavJaveiro/helloWorldJPA/main/Main.class|Main]]

Neste exemplo, usamos a classe ProjectConfig para configurar o contexto do Spring e, em seguida, obtemos o bean *Person* a partir desse contexto. Quando executamos o código, o Spring deve injetar a instância de Parrot no campo parrot da classe Person, e a saída deve mostrar que a injeção foi bem sucedida.

<span style="background:#d4b106">Por qual motivo essa abordagem não é desejada em código de produção?</span> Não é totalmente errado usá-la, mas precisamos garantir que o nosso aplicativo seja mantenível e testável em código de produção. Ao injetar o valor diretamente no campo:
- não temos a opção de tornar o campo *final* (veja o próximo trecho de código), e desta forma, garantir que ninguém possa alterar seu valor após a inicialização;
```java
@Component
public class Person {
	private String name = "Ella";

	@Autowired
	private final Parrot parrot; 
	// This doesn't compile. You cannot define a final dield without an initial value;
}
```

### 3.2.2 Using *@Autowired* to Inject the values through the constructor
A segunda maneira que temos como opção para injetar valores nos atributos do objeto quando o Spring cria um bean <span style="background:#d4b106">é usar o construtor da classe definindo a instância</span> (figura 3.10). Esta abordagem é a mais frequentemente utilizada em código de produção e é a que eu recomendo. Ela permite que definamos campos como *final*, garantindo que ninguém possa alterar seus valores após a inicialização pelo Spring. A possi bilidade de definir os valores ao chamar o construtor também é útil ao escrever testes unitários específicos nos quais não desejamos depende do Spring para realizar a injeção de campo. 

```java
@Component
public class Person {
	private String name = "Ella";

	private final Parrot parrot;

	@Autowired
	public Person(Parrot parrot) {
		this.parrot = parrot;
	}
}
```
- *@Component* - A anotação do tipo Stereotype instruí o Spring a criar e adicionar um bean ao contexto do tipo dessa classe: Person;
- Quando o Spring cria o bean do tipo *Person*, ele chama o construtor anotado com *@Autowired*. O Spring fornece um bean do tipo *Parrot* do seu contexto como valor do parâmetro.

Podemos rapidamente alterar a implementação do projeto para utilizar *a injeção via construtor em vez de injeção de campo.* Só precisamos modificar a classe *Person*. É necessário definir um construtor para a classe e anotá-lo com *@Autowired*. Agora, também podemos tornar o campo *parrot* como *final*. Não é preciso fazer nenhuma alteração na sua classe de configuração.

```java
@Component
public class Person {
	private String name = "Davidson";
	
	private final Parrot parrot; //
	
	@Autowired
	public Person(Parrot parrot) {
		this.parrot = parrot;
	}
}
```

## 3.2.3 Using dependency injection through the setter
Raramente encontraremos desenvolvedores aplicando a abordagem de usar o *setter* para injeção de dependência. Esta abordagem *tem mais desvantagens do que vantagens*: é mais desafiadora de ler, não permite que torne o campo final e não facilita os testes. Precisamos abordar esse maneira de fazer DI, pois podemos encontrá-la em algum momento.

Mudando a classe *person* para implementar dessa forma:
[[Spring Start Here/PART 1/Capítulo 3 - The Spring context - Wiring beans/SpringStartHere3Ex6/src/main/java/com/DavJaveiro/helloWorldJPA/main/Person.java|Person]]

## 3.3 Dealing with circular dependencies

É confortável deixar o Spring construir e definir as dependências dos objetos da nossa aplicação. Permitir que o Spring faça esse trabalho por nós permite que economizemos tempo e várias linhas de código, além de facilitar a leitura e compreensão do aplicativo. <span style="background:#d4b106">Mas o Spring também pode se confundir em alguns casos</span>. Um cenário frequentemente encontrado na prática é gerar uma dependência por engano.

Uma dependência circular é uma situação em que, para criar um bean (vamos chamá-lo de Bean A), o Spring precisa injetar outro bean que ainda não existe *Bean B*. Mas o Bean B também solicita uma dependência do Bean A. Então, para criar o Bean B, o Spring precisa primeiro ter o Bean A. Agora, o Spring está em um impasse. Ele não pode criar o Bean A porque precisa do Bean B, e não pode criar o Bean B porque precisa do Bean A.

**Exemplo de uma dependência circular**
1. Spring needs to create a bean of type Parrot;
2. To call the *Parrot* class constructor, Spring needs a bean of type *Person*;
```java
@Component
public class Parrot {
	private final Person person;

	@Autowired
	public Parrot(Person person) {
		this.person = person;
	}
}
```

1. Spring tries to create the bean of type Person;
2. To create a bean of type Person, Spring needs a bean of type Parrot. Spring is now in a deadlock!

Uma dependência circular é fácil de evitar. <span style="background:#d4b106">Precisamos apenas garantir que não defina objetos cuja criação depende um do outro</span>. Ter dependências desse tipo entre objetos é um mau design de classes. Nesse caso, vamos precisar reescrever o nosso código.

Quando tentamos executar um programa, uma exceção é lançada:
*With this exception, Spring tries to tell you the problem it encountered. The exception
message is quite clear: Spring deals with a circular dependency and the classes
that caused the situation. Whenever you find such an exception, you need to go to the
classes specified by the exception and eliminate the circular dependency.*

Com essa exceção, o Spring tenta informar o problema que encontrou. A mensagem de exceção é bastante clara: o Spring está lidando com uma dependência circular e as classes que causaram a situação. Sempre que você encontrar tal exceção, <span style="background:#d4b106">precisa ir até as classes especificadas pela exceção e eliminar a dependência circular</span>.

## 3.4 Choosing from multiple beans in the Spring context
Nesta seção, discutiremos o cenário em que o Spring precisa injetar um valor em um parâmetro ou campo de classe, <span style="background:#d4b106">mas possui vários beans do mesmo tipo para escolher</span>. Suponha que tenhamos três beans de Parrot no Spring Context. Configuramos o Spring para injetar um valor do tipo Parrot em um parâmetro. Como o Spring se comportará? Qual dos beans do mesmo tipo o framework escolheria para injetar nesse cenário?
Dependendo da nossa implementação, temos os seguintes casos:
1. O identificador do parâmetro coincide com o nome de um dos beans do contexto (que é o mesmo nome do método anotado com @Bean que retorna seu valor). Nesse caso, <span style="background:#d4b106">o Spring escolherá o bean cujo nome é o mesmo que o do parâmetro</span>;
2. O identificador do parâmetro não coincide com nenhum dos nomes dos beans do contexto. Então, temos as seguintes opções: a. <span style="background:#d4b106">marcamos um dos beans como primary</span> (usando a annotation *@Primary*). Nesse caso, o Spring selecionará o bean primário para a injeção. **b**. <span style="background:#d4b106">Precisamos selecionar explicitamente um bean especifico usando a anotação</span> *@Qualifier*, que discutimos. **C.** Se nenhum dos beans for primário e não usarmos @Qualifier, o aplicativo falhará com uma exceção, reclamando que o contexto contém mais beans do mesmo tipo e o Spring não sabe qual escolher.

Vamos simular uma situação em que temos mais de uma instância de um tipo no Spring Context.

Em um cenário do mundo real, prefiro evitar confiar no nome do parâmetro, que pode ser facilmente refatorado e alterado por engano por outro desenvolvedor. Para me sentir mais confortável, geralmente escolho uma abordagem mais visível para expressar minha intenção de injetar um bean específico: usando a anotação *@Qualifier*. Novamente, na minha experiência, encontrei desenvolvedores argumentando a favor e contra o uso da anotação *@Qualifier*. 

```java
@Bean
public Person person(@Qualifier("parrot2") Parrot parrot) {
	Person p = new Person();
	p.setName("Ela");
	p.setParrot(parrot);
	return p;
}
```

- *@Qualifier* - Using the @Qualifier annotation, you clearly mark your intention to inject a specif bean from the context.

Uma situação semelhante também pode acontecer ao usar a anotação *@Autowired*. 