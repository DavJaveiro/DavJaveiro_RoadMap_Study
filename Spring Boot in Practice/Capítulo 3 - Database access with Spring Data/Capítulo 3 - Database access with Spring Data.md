*This chapter covers*
- Introducing Spring Data, its needs, and various Spring Data modules;
- Configuring a relational database, NoSQL database (MongoDB), and access data in a Spring Boot application;
- Enabling Spring Data JPA to manage business domain objects with relational databases;
- Various techniques to access data from a relational database using *@NamedQuery*, *@Query*, Criteria API, and *Querydsl*.

No mundo atual, a maioria das aplicações está incompleta sem um banco de dados que armazene os dados da aplicação - e as aplicações Spring Boot não são exceção.

Neste capítulo, daremos início à nossa jornada interagindo com o banco de dados a partir da nossa aplicação Spring Boot. Descobriremos como é simples configurar o banco de dados, realizar a inicialização completa, acessar os dados e gerenciar objetos de negócio no banco usando Spring Boot!

## 3.1 Introducing Spring Data
O **Spring Data** permite acessar dados a partir de uma variedade de fontes de dados (por exemplo, bancos de dados relacionais e não relacionais, bancos baseados em MapReduce e serviços de dados em nuvem). Ele busca fornecer um modelo de programação uniforme, fácil de usar e familiar por meio do Spring Framework.

É um projeto guarda-chuva dentro do Spring Framework que contém vários subprojetos, cada um voltado para um tipo específicos de banco de dados. Por exemplo, o módulo **Spring Data JPA** é específico para banco de dados relacionais (como H2, MySQL, PostgreSQL). Da mesma forma, o **Spring Data MongoDB** tem como objetivo oferecer suporte ao banco de dados MongoDB.

---
**Java Persistence API (JPA)**
A maioria das aplicações no mundo atual precisa se comunicar com um banco de dados para armazenar e recuperar dados da aplicação. E, para realizar essa interação, os desenvolvedores geralmente precisam escrever muito *boilerplate code* (código repetitivo e padronizado). Por exemplo, na abordagem padrão do **Java Database Connectitivy (JDBC)**, é necessário obter uma conexão com o banco, definir um *PreparedStatement*, configurar as variáveis de ligação (bind variables), executar a consulta e gerenciar os recursos.

A Java Persistence API (JPA) elimina grande parte deste trabalho, oferecendo aos desenvolvedores uma ponte entre o modelo de objetos Java (**por exemplo, objetos de negócio**, package model) e o modelo relacional do banco de dados (por exemplo, tabelas do banco). Esse mapeamento entre objetos Java e o modelo relacional é conhecido como **object-relational mapping ORM**, como ilustrado na figura 3.1.

![[Capítulo 3 - Database access with Spring Data.png]]

JPA é uma **especificação** que fornece um conjunto de interfaces, classes e anotações para persistir e recuperar objetos da aplicação de forma simples e concisa. Vale destacar que ela é apenas uma especificação, ou seja, **define os padrões para as técnicas de ORM** (Object-Relational Mapping).

Existem diversos fornecedores terceiros que oferecerem implementações concretas dessa especificação, como o **Hibernate** e o EclipseLink.


---
## 1. Especificação JPA - O que é definido como padrão
A JPA define as seguintes partes principais:
- Anotações: **@Entity**, **@Id**, **@GeneratedValue**, @Column, etc.
- Interfaces: **@EntityManager**, **@EntityTransaction**, etc.

2. **Implementação concreta - Hibernate**
O Hibernate entre como quem executa de fato o que a especificação pede. Ele transforma objetos Java em registros de banco e vice-versa, cuida das consultas, do SQL, do cache, etc.

No Spring Boot, o Hibernate é incluído automaticamente quando usamos o **starter** *spring-boot-starter-data-jpa*. Ou seja, não precisamos nos preocupar em instanciá-lo diretamente.

**Entidade (JPA)**
```java
import jakarta.persistence.*;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Double preco;

	// getters e setters
}

```

**Repositório (interface do Spring Data que usa JPA)**
```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository< Produto, Long > {
	// podemos usar métodos prontos ou criar métodos de consulta por nome
}
```

### 3.1.1 Why Spring Data?

Um dos temas centrais do Spring Data é oferecer um modelo de programação **consistente para acessar diversas fontes de dados**. Para isso, ele fornece uma API conveniente que permite especificar *metadados* nos objetos de domínio que precisam ser persistidos, garantindo que os objetos de negócio estejam aptos a serem armazenados na *datastore* específica. 

Por exemplo, podemos usar um banco de dados relacional junto com o Spring Data JPA para gerenciar objetos de negócio. Basta adicionar as anotações JPA aos objetos de domínio, e o Spring Data JPA se encarrega de garantir que esses objetos sejam persistidos nas tabelas do banco de dados. Mais adiante neste capítulo, veremos várias dessas anotações e como usá-las nos objetos de domínio.

Os módulos do Spring Data também expõem APIs no formato de *templates*, seguindo o padrão de design usado em classes como *JdbcTemplate* e *JmsTemplate*. Por exemplo, se estiver utilizando o MongoDB, podemos usar o *MongoTemplate* para realizar várias operações no banco MongoDB. Essas classes *template* oferecem diversos métodos utilitários que lidam com o gerenciamento de recursos específico de cada *store* e com a tradução de exceções.

**Templates do Spring**
Os templates eliminam a necessidade de escrever código repetitivo (boilerplate) que normalmente é exigido para utilizar corretamente APIs bastante comuns, como:
- JDBC (Java Database Connectivity)
- JMS (Java Message Service)
- JNDI (Java Naming and Directory Interface)

Esse código repetitivo geralmente envolve etapas como configuração, tratamento de exceções e gerenciamento de recursos - tarefas que precisamos implementar além da lógica principal do nosso sistema.

Por exemplo, em um caso tradicional com JDBC, para executar uma simples consulta ao banco de dados, seria necessário:
1. Obter manualmente uma conexão com o banco;
2. Criar um *PreparedStatement*;
3. Executar a consulta;
4. Tratar possíveis exceções;
5. E garantir que a conexão e o *PreparedStatement* sejam fechados corretamente.

Esse processo é verboso e sujeito a erros.
É aí que entram os templates do Spring.

Eles assumem a responsabilidade por quase toda essa parte repetitiva, permitindo que nos concentremos apenas na lógica de negócio.

Por exemplo, com o *JdbcTemplate*, tudo o que precisamos fazer é fornecer a consulta *query*, e o próprio template gerencia todo o restante, como *conexões, exceções e fechamento de recursos.*

Exemplo básico com *JdbcTemplate*:
```java
private JdbcTemplate jdbcTemplate;

public List<String> listarNomesDosProdutos() {
	String sql = "SELECT nome FROM produto";

	return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("nome"))
}
```

O Spring Data fornece uma camada de abstração de repositório (*repository abstraction layer*) nos bancos de dados suportados como um modelo de programação comum (*common programming model*). A abstração está contida no módulo Spring Data Commons e fornece várias interfaces úteis que permitem executar as operações padrão como create, read, update e delete (CRUD), além de executar queries.

Essa camada de abstração é a camada superior e atua como base para outros módulos do Spring Data.

### 3.1.2 Spring Data modules
Na seção anterior, vimos o papel do Spring Data. Nesta seção, aprenderemos mais sobre os módulos do Spring Data. Podemos consultar o quadro *Spring Data Modules* para ver a lista dos principais subprojetos disponíveis no Spring Data.

**Spring Data Modules**
### Módulos do Spring Data e seus propósitos

| Nome do Módulo                   | Finalidade                                                                  |
| -------------------------------- | --------------------------------------------------------------------------- |
| Spring Data Commons              | Contém os componentes fundamentais usados em todos os projetos Spring Data. |
| Spring Data JDBC                 | Fornece suporte a repositórios utilizando JDBC.                             |
| Spring Data JPA                  | Fornece suporte a repositórios utilizando JPA.                              |
| Spring Data MongoDB              | Oferece suporte ao banco de dados orientado a documentos MongoDB.           |
| Spring Data Redis                | Fornece o suporte necessário para o datastore Redis.                        |
| Spring Data REST                 | Permite expor repositórios Spring Data como recursos REST automaticamente.  |
| Spring Data for Apache Cassandra | Oferece o suporte necessário para trabalhar com o banco Apache Cassandra.   |

Entre todos os módulos do Spring Data, o **Spring Data Commons** é um dos mais importantes. Ele contém os componentes fundamentais e **database-agnostic** (independente de fonte de dados) usados por outros módulos do Spring Data. Por exemplo, o módulo **Spring Data JPA** depende das interfaces definidas no **Spring Data Commons**. A interface *JpaRepository* do Spring Data JPA é uma subinterface da **PagingAndSortingRepository** (do Spring Data Commons) e herda suporte a CRUD, pagination e sorting do módulo Commons.

Como mostrado na Figura 3.2, o Spring Data Commons fornece três interfaces principais de *repository*
- Repository
- CrudRepository
- PagingAndSortingRepository
Como o nome sugere, a **CrudRepository** permite usar operações **CRUD**. Já a **PagingAndSortingRepository** (uma subinterface da **CrudRepository**) permite executar operações **CRUD**, além de **pagination** e **sorting** dos dados retornados do banco. Veremos algumas dessas interfaces em detalhes na **Seção 3.3**

Os submodelos do Spring Data incluem implementações específicas para diferentes tecnologias de banco de dados, como:

- Suporte a famílias de bancos relacionais (Spring Data JDBC, Spring Data JPA);
- Bancos de dados específicos de fornecedores (Spring Data MongoDB para MongoDB);
Esses submodelos aproveitam os recursos do core framework oferecidos pelo **Spring Data Commons**.

![[Capítulo 3 - Database access with Spring Data-1.png]]

## 3.2 Configuring a database in a Spring Boot application
Configurar e acessar um banco de dados é uma das operações fundamentais em qualquer aplicação, e aplicações Spring Boot não são exceção. O Spring Boot oferece várias técnicas para configurar e acessar um banco de dados em nossa aplicação. 

### 3.2.1 Technique: Configuration a relational database in a Spring Boot application
Nesta técnica, demonstraremos como configurar um banco de dados relacional em uma aplicação Spring Boot.

**Problema**
A maioria das aplicações precisa interagir com um banco de dados para armazenar e recuperar dados. No entanto, antes de se comunicar com o banco de dados, é necessário configurá-lo na aplicação.

**Solution**
To configure a relational database with Spring Boot, you can add *spring-boot-starter-data-jpa* and the relational database driver dependency in the pom.xml of you application. Additionally, you need to supply the database details (fornecer os detalhes do banco de dados), such as database username, password, driver class, and connection URL.

The provided details are sufficient for Spring Boot to configure the data source in the application.

Para validar o data source criado, podemos definir um caso de teste que verifica o tipo do datasource e o banco de dados subjacente.

**Listing 3.3 Unit Test to validate the data source details**

Neste caso de teste, utilizamos o *autowired* para injetar a instância do *DataSource* e verificamos que o nome da classe do datasource é *com.zaxxer.hikari.HikariDataSource* e que o nome do produto do banco de dados é *MySQL*.

---
**Summary**

1. **Spring Data Commons** - Essa é o núcleo comum do **Spring Data**. Ele fornece #interfaces genéricas que outras implementações especializadas reutilizam:
	- **Repository**: interface base vazia que marca o tipo como um repositório Spring Data;
	- #CrudRepository: fornece operações CRUD básicas como *save()*, findById(), delete(), etc.
	- #PagingAdnSortingRepository: estende o *CrudRepository* com suporte para **paginação e ordenação**. 

Essas interfaces são herdadas pelos repositórios nas aplicações Spring, e o Spring se encarrega de gerar a implementação em tempo de execução.

 2. **Spring Data Sub Modules** - são módulos especializados que implementam as interfaces do Spring Data Commons para tecnologias específicas de persistência:
	 - **Spring Data JDBC:** para acesso direto via JDBC (sem usar ORM como JPA);
	 - **Spring Data JPA**: para trabalhar com JPA (Hibernate, EclipseLink, etc), ideal para bancos relacionais como MySQL e PostgreSQL;
	 - **Spring Data MongoDB:** integração com banco NoSQL MongoDB;
	 - **Spring Data Cassandra:** integração com o banco NoSQL Cassandra;

### 🔄 Fluxo de cima pra baixo (ou vice-versa)
- Criamos repositórios estendendo interfaces como *CrudRepository*;
- O Spring Data submodule correspondente gera a implementação automaticamente;
- O submódulo se comunica com o banco de dados (via JPA, JDBC, etc) e realiza as operações;
---

**Discussion**
Com essa técnica, aprendemos como configurar um banco de dados relacional em nossa aplicação Spring Boot com poucas configurações. 

Como parte da configuração do banco de dados, o Spring Boot configura automaticamente o pool de conexões de banco de dados HikariCP. Um pool de conexões de banco de dados contém uma ou mais conexões de banco de dados que geralmente são criadas no momento da inicialização da aplicação e ficam disponíveis para uso pela aplicação. A vantagem de um pool de conexões de banco de dados é que um conjunto de conexões de banco de dados é criado durante a inicialização da aplicação e fica disponível para uso. A aplicação pode pegar uma conexão do pool, utilizá-la e devolvê-la ao pool. <span style="background:#b1ffff">O Spring Boot utiliza o</span> #HikariCP como a biblioteca padrão de pool de conexões de banco de dados.

Caso desejamos visualizar a dependência da biblioteca HikariCP, podemos navegar entre as dependências conforme o esquema abaixo:

![[Capítulo 3 - Database access with Spring Data-2.png]]

If you need to use a database connection pooling library other than HikariCP, you can achieve this by exclueding the HikariCP dependency from the *spring-boot-starter-data-jpa* dependency and including your preferred database connection pooling library (e.g, Oracle UCP, Tomcat JDBC, DBCP2, etc). 

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <exclusions>
        <exclusion>                             
	        <groupId>com.zaxxer</groupId>
	        <artifactId>HikariCP</artifactId>
	    </exclusion>
	</exclusions>
</dependency>

<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jdbc</artifactId>
</dependency>
```

O Spring Boot utiliza as seguintes estratégias para detectar a biblioteca de pool de conexões de banco de dados com base na configuração definida na listagem 3.4:
1. Se o HikariCP não estiver disponível, o Spring Boot tenta usar o pool de conexões de banco de dados do Apache Tomcat, caso esteja presente no classpath.
2. Se tanto o HikariCP quanto as dependências do pool de conexões do Apache Tomcat não estiverem disponíveis, o Spring Boot tenta usar a biblioteca Apache Commons DBCP2.
3. Se o DBCP2 também não estiver disponível, o Spring Boot configura a fonte de dados padrão do JDK.


Se estivermos interessados em explorar os parâmetros de configuração de banco de dados disponíveis, podemos consultar a documentação do *application.properties* do Spring Boot. 
https://docs.spring.io/spring-boot/appendix/application-properties/index.html#appendix.application-properties.data

### 3.2.3 Technique: Initializing a relational database schema with a Spring Boot application
