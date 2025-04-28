**This chapter covers**
- [ ] *Introducing Spring Boot autoconfiguration, various types of conditional annotation, and in-edpth discussion.*
- [ ] *An overview of Spring Boot DevTools, how to configure it, and its various purposes*;
- [ ] *Introducing Spring Boot FailureAnalyzer and how to define a custom application-specific FailureAnalyzer*;
- [ ] *An ind-depth discussion on Spring Boot Actuator and how to define custom metrics*;

Já aprendemos bastante sobre Spring Boot nos últimos três capítulos. Agora temos uma base sólida em Spring Boot, tendo visto várias funcionalidades do framework e diversas tarefas comuns que precisamos realizar diariamente. Também aprendemos como se comunicar e usar um banco de dados em uma aplicação Spring Boot.

Neste capítulo, exploraremos dois conceitos principais do Spring Boot: a **autoconfiguração do Spring Boot** e o **Spring Boot Actuator**. Aprenderemos vários blocos de construção da autoconfiguração do Spring Boot e exploraremos como ela funciona em uma aplicação. Vamos explorar diversas anotações condicionais (*conditional annotations*), que são a base da autoconfiguração do Spring Boot. Em seguida, descobriremos o Spring Boot Actuator, que permite monitor a saúde da nossa aplicação e interagir com ela.

## 4.1 Understanding Spring Boot autoconfiguration
- [ ] 4.1.1 Understanding *@Conditional* annotation
- [ ] 4.1.2 Deep dive into autoconfiguration

A **autoconfiguration** do Spring Boot é provavelmente a característica mais importante e uma das principais razões por trás da popularidade do **Spring Boot**. Como o nome sugere, a **autoconfiguration** configura automaticamente os componentes da aplicação que precisaríamos ao desenvolver uma aplicação **Spring**. Ela faz uma suposição sensata sobre os componentes da aplicação e tenta fornecer uma configuração padrão com a qual inicializa a aplicação. Por exemplo, se incluirmos a dependência **spring-boot-starter-web** em nosso arquivo de configuração de **build**, então o **Spring Boot** assuma que precisamos de um **webserver** para executar a aplicação web. Assim, ele configura automaticamente o **webserver Apache Tomcat**. 

Outra característica interessante é a sua flexibilidade. Se a **autoconfiguração** determina que o desenvolvedor configurou explicitamente um componente da aplicação, ela simplesmente recua e não configura automaticamente esse componente específico, utilizando em vez disso a configuração fornecida pelo desenvolvedor.

Por exemplo, ao usar a dependência **spring-boot-starter-web**, o **Spring Boot** utiliza o **Apache Tomcat** como o **web server** padrão. No entanto, se configurarmos um **web server** diferente e excluirmos o **Apache Tomcat**, o **Spring Boot** desiste de sua configuração padrão com **Tomcat** e passa a usar o **web server** definido pelo usuário. 

O trecho a seguir mostra a configuração do **Jetty web server** em uma aplicação **Spring Boot**, substituindo o **Tomcat** padrão:
```json
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency
```

Imagine que estamos trabalhando em uma organização onde <span style="background:#d4b106">equipes de desenvolvimento estão trabalhando em vários projetos</span> usando o **Spring framework**. Em determinado momento, um dos desenvolvedores percebe que alguns **beans** de configuração do **Spring** <span style="background:#d4b106">são utilizados por todas as equipes</span> e estão <span style="background:#d4b106">duplicados entre os projetos</span>. Diante disso, o desenvolvedor pode decidir extrair essas configurações duplicadas em uma configuração comum de **application context**, conforme mostrado no seguinte exemplo:

```java
@Configuration
public class CommonApplicationContextConfiguration {

	// Creates a Spring Bean of type RelationalDataSourceConfiguration
	
	@Bean
		public RelationalDataSourceConfiguration dataSourceConfiguration() {
			return new RelationalDataSourceConfiguration();
		}

		// Other commoly used Spring bean definitions
}
```
A anotação *@Configuration* indica que essa é uma classe de configuração.

A listagem 4.2, acima, apresenta uma configuração de exemplo da *CommonApplicationContextConfiguration*:
- A classe de configuração *CommonApplicationContextConfiguration* reside em um projeto separado e é publicado como um componente Maven ou Gradle independente. Assim, outras equipes podem utilizá-la como uma dependência em seus projetos.
- A classe *RelationaDataSourceConfiguration* fornece uma configuração de fonte de dados relacional que inicializa o banco de dados e retorna uma fonte de dados. Como a maioria das equipes utiliza um banco de dados relacional, faz sentido extrair e manter essa configuração separadamente. Além disso, para simplificar, fornecemos apenas uma configuração, mas a classe **CommonApplicationContextConfiguration** pode conter outras configurações comuns, como a definição do bean do gerenciador de transações do Spring.

**Por que isso é útil?**
1. **Evita duplicação** - se 5 equipes precisam da mesma configuração de **DataSource**, em vez de cada uma criar sua própria versão, todas usam essa classe centralizada. 
2. **Facilita a manutenção** - Se a configuração do banco de dados mudar (ex.: novo driver, ajuste de pool de conexões), atualizamos **apenas essa classe**, e todos os projetos que a usam herdam a mudança; 
3. **Promove consistência** - garante que todos os projetos usem a mesma configuração padrão, reduzindo erros.

**Como outros projetos usam essa configuração?**
1. **Empacotando como dependência**
	- Essa classe é colocada em um projeto separado  (ex.: **common-spring-config**) e publica em um repositório Maven/Gradle.
	- Outros projetos adicionam essa dependência no **pom.xml** (Maven) ou **build.gradle** (Gradle);

O exemplo está alinhado com o **Princípio de Responsabilidade única (SRP - Single Responsilbility Principle)**, que é o primeiro dos princípios SOLID de design de software orientado a objetos. 

Outras equipes que precisarem usar a **CommonApplicationContextConfiguration** podem importar essa configuração comum em suas classes de configuração específicas, conforme mostrado na listagem a seguir:
```java
@Configuration
@Import(CommonApplicationContextConfiguration.class)
public class CommonPaymentContextConfiguration {
	// Definições de beans para as equipes de pagamento\
}
```

Importa os **beans** do Spring definidos na classe *CommonApplicationContextConfiguration*. 

As equipes podem definir definições de beans específicas do projeto em seus respectivos arquivos de configuração.  Essa abordagem funciona bem na maioria dos cenários, mas há um problema: se uma equipe quiser usar todos os beans definidos na **CommonApplicationContextConfiguration**, exceto uma definição específica de **bean**?
Por exemplo, uma equipe desejar usar todos os beans definidos na **CommonApplicationContextConfiguration**, mas não o **RelationalDataSourceConfiguration**, pois eles não utilizam um banco de **dados relacional**. Assim, deve haver alguma forma de informar ao Spring que importar a configuração **CommonApplicationContextConfiguration** está correto, mas que o **bean** em específico, não deve ser criado.

Como podemos alcançar isso? A anotação *@Conditional* do Spring tema a resposta para essa questão. Vamos analisar isso em detalhes na próxima seção. 

### 4.1.1 Understanding @Conditional annotation
O framework Spring fornece uma anotação *@Conditional* que pode ser colocada em *@Bean*, *@Component* e *@Configuration* para influenciar a criação dos componentes gerenciados pelo Spring. A anotação *@Conditional* aceita um parâmetro da classe **Condition**. A interface **Condition** possui um método chamado **matches(..)** que retorna um valor booleano. Um valor **true** indica que deve-se continuar avaliando ou criando um *@Bean, @Component* ou *@Configuration*. Um valor **false** significa que não deve prosseguir com a criação do *@Bean*, *@Component* ou *@Configuration*. 

Em nossas implementações personalizadas de **Condition**, implementamos a interface **Condition** e definimos o método **matches(..)**.

Agora, vamos examinar como usar a anotação **@Conditional** no **bean** *RelationalDataSourceConfiguration*. A seguinte listagem mostra a classe de configuração *CommonApplicationContextConfiguration* modificada que utiliza a anotação *@Conditional*. 

```java
@Configuration
public class CommonApplicationContextConfiguration {

	@Bean
	@Conditional(RelationDatabaseCondition.class)
	public RelationalDataSourceConfiguration dataSourceConfiguration() {
		return new RelationalDataSourceConfiguration();
	}

}
```

A anotação *@Conditional* garante que o **bean** seja criado apenas se a **RelationalDatabaseCondition** avaliá-lo como **true**.

Essa configuração é similar à que vimos na listagem 4.2, com a exceção de que a criação do bean *DataSourceConfiguration* agora depende da condição **RelationalDatabaseCondition**. A seguinte listagem define essa condição:
```java
public class RelationDatabaseCondition implements Condition {

	@Override
	public boolean matches(ConditionText conditionConteext, AnnotatedTypeMetada annotatedTypeMetada) {
		return isMySQlDatabase();
	}

	private boolean isMySQLDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return true;
		}
		cath(ClassNotFoundException e) {
			return false;
		}
	}
}
```

No Spring, às vezes só queremos criar um *@Bean*, *@Component*, ou *@Configuration* se uma condição for verdadeira.
O Spring criou a anotação *@Conditional* exatamente para isso.
- Colocamos o @Conditional em cima do que queremos criar;
- Passamos uma classe de condição (uma classe Java que implemente a interface **Condition**);
- Essa classe de condição define: *"devo criar ou não esse bean?*



### Como funciona a classe de condição?
O que o Spring espera é que criemos uma classe que implemente a interface **Condition**.

Essa interface tem um método:
```java
boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
```
- Se retornarmos true, o Spring vai criar o Bean/Component/Configuração;
- Se retornarmos false, o Spring não vai criar.

**Exemplo do Livro**
1. Temos uma configuração:
```java
@Configuration
public class CommonApplicationContextConfiguration {
	@Bean
	@Conditional(RelationDataBaseCondition.class)
	public RelationalDataSourceConfiguration dataSourceConfiguuration() {
		return new RelationalDataSourceConfiguration();
	}
}
```
Aqui, o Spring só vai criar esse RelationalDataSourceConfiguration se a classe **RelationalDatabaseCondition** disse "ok".

E a classe de condição é essa aqui:
```java
public class RelationDatabaseCondition implements Condition {

	public boolean matches(ConditionContext conditionContext, AnnotatetedTypeMetadata metadata) {
		return isMySQlDatabase();
	}

	private boolean isMySQlDatabase() {
		try { // tenta carregar o driver do MySQL
			Class.forName("com.mysql.jdbc.Driver");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
```
- Ela tenta carregar a classe *com.mysql.jdbc.Driver* usando *Class.forName(...)*;
- Se essa classe existe no projeto, no classpatch, ele entende que estamos usando MySQL, então retorna o método true;
- Se não existir, retorna *false*.

Outro exemplo simples:

**1. Crio a classe de condição:**
```java
public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// Pegando o nome do sistema operacional
		String osName = System.getProperty("os.name");

		// Se o nome do sistema operacional contiver Windows, retornamos tru
		return osName != null && osName.contains("Windows");
	}
}
```

2. **Crio a configuração usando essa condição:**
```java
@Configuration
public class MyConfiguration {
	@Bean
	@Conditional(WindowsCondition.class)
	public String windowsOnlyBean() {
		return "Este bem só existe no Windows!"
	}
}
```

Aqui o Spring vai:
- Verificar se a condição *WindowsCondition* é verdadeira;
- Se for, ele cria o Bean *windowsOnlyBean*;
- Se não for, o Bean simplesmente não existe no contexto da aplicação.

---

## 4.1.1 Continuando
Portanto, no exemplo anterior, do MySQL, ele não olha o DataSource diretamente.
O que ele faz é:
- **Checar se a classe *com.mysql.jdbc.Driver* existe no classpath**
Ou seja:
- Se o projeto importou (via Maven, Gradle ou outro) o driver do MySQL;
- Então essa classe estará disponível no classpath;
- Se a classe está disponível, é um sinal que queremos utilizar o MySQl

- Fornecemos uma implementação da interface **Condition**. Essa interface possui um método **matches()** que retorna um valor booleano;
- Validamos se a classe do driver MySQL está presente no **classpath** da aplicação. Se a classe do driver estiver disponível, a condição retorna true para indicar que um banco de dados relacional está disponível.

Para simplificar, mantivemos a *RelationalDatabaseCondition* direta, com apenas uma validação.  