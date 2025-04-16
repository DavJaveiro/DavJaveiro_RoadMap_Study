*This chapter covers*
- Introducing Spring Data, its needs, and various Spring Data modules;
- [ ] Configuring a relational database, NoSQL database (MongoDB), and access data in a Spring Boot application;
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
In this technique, we'll discuss how to initialize a relational database schema in a Spring Boot application.

**Problem**
In the configuring a relational database in a Spring Boot Application technique, you saw how to configure a relational database in your Spring Boot application. However, before start accessing the database, we need to ensure the database schema is initialized properly. For instance, all the required tables and indexes are created, and associated insert scripts are executed. You need to initialize the database schema at the application startup.

**Solution**
O Spring Boot permite inicializar o esquema do banco de dados tanto com soluções nativas quanto com bibliotecas de terceiros (como soluções ORM). Nesta abordagem, aprenderemos como inicializar o banco de dados usando os **scripts** *schema.sql* e *data.sql* fornecidos pelo próprio Spring Data.

O Spring Boot pode carregar os scripts SQL a partir do classpath (por exemplo, da pasta `src/main/resources`) ou de um local previamente configurado. Por padrão, definimos o arquivo *schema.sql* para incluir todos os scripts DDL e o arquivo *data.sql* para os scripts DML, colocando ambos dentro da pasta *resources* para que o Spring Boot os detecte e execute automaticamente. Além disso, podemos também usar as propriedades *spring.datasource.schema* e *spring.datasource.data* para personalizar esse comportamento padrão.

**DDL and DML in a nutshell**
Data Definition Language is used to define database structures, such as database user, schemas, tables, indexes, constraints in a relational database. For example, in H2, we can use the following DDL statement to create a table named AUTHORS:
```SQL
create table AUTHORS (
	id biginit not null,
	name varchar(255),
	primary key (id)
);
```

Data Manipulation Language is used to manipule data. For example, DML statements allow we to INSERT, UPDATE  and DELETE data in a relational database tables. For example, the following DML script INSERTS data into the AUTHORS table:
```sql
INSERT INTO AUTHORS(id, name) VALUES(1, 'John Doe');
```

Se estivermos usando um banco de dados diferente de um banco de dados incorporado (in-memory), é necessário definir *spring.sql.init.mode* como **always** no arquivo *application.properties*, conforme mostrado na listagem 3.8. Essa propriedade instrui o Spring Boot a sempre inicializar o schema do banco de dados. Por padrão, essa propriedade está configurada com o valor *embedded*. Isso significa que o Spring Boot inicializa automaticamente o schema do banco de dados para tipos de banco de dados incorporados (por exemplo, o banco de dados in-memory H2). **Para inicializar o MySQL ou outros bancos de dados reais, precisamos configurar explicitamente o valor como *always*.** 

Nesta abordagem baseada na inicialização do schema, o Spring Boot recria o schema toda vez que reiniciamos a aplicação. Não há versionamento de schema de banco de dados feito pelo Spring Boot. Por exemplo, no exemplo acima, o Spring Boot remove e recria a tabela *COURSES* a cada reinício da aplicação e executa as instruções DML fornecidas no script *data.sql*. A listagem a seguir mostra o arquivo *application.properties* atualizado.

```json
spring.sql.init.mode=always
```
Outras propriedades da data source, como *username*, *password*, *driver_name* e *connection URL*, instrui o Spring Boot a inicializar o schema do banco de dados. Os valores suportados são **embedded**, **always** e **never**.

Vamos definir os arquivos *schema.sql* e *data.sql*. No entanto, antes disso, vamos recapitular o modelo de negócio com o qual estamos trabalhando nesta aplicação. Neste exemplo, estamos gerenciando os detalhes de **Course** na aplicação de exemplo. Assim, **Course** é o objeto de domínio de negócio da aplicação. O arquivo **schema.sql** cria a tabela **COURSES**, e o **data.sql** inseres alguns cursos de exemplo na tabela **COURSES**. 

```sql
CREATE TABLE COURSES (
	id int(15) NOT NULL,
	name varchar(100) NOT NULL,
	category varchar(20) NOT NULL,
	rating int(1) NOT NULL,
	description varchar(1000) NOT NULL,
	PRIMARY KEY (id)
);
```

---
**✅Configurando as propriedades de controle do schema ou DDL**
#### **Opção 1: Tornar o `CREATE TABLE` condicional**

Altere o seu `schema.sql` para que a tabela só seja criada se ainda não existir:

`CREATE TABLE IF NOT EXISTS COURSES (     id INT(15) NOT NULL,     name VARCHAR(100) NOT NULL,     category VARCHAR(20) NOT NULL,     rating INT(1) NOT NULL,     description VARCHAR(1000) NOT NULL,     PRIMARY KEY (id) );`

💡 Essa é a forma mais simples e **recomendada para MySQL**, pois evita erro se a tabela já existir.

#### **Opção 2: Deixe o banco cuidar do schema**

Se o seu banco já está criado e você **não quer que o Spring Boot crie nada**, desative o `schema.sql` com:

`spring.sql.init.mode=never`

Isso impede a execução do `schema.sql`, mas ainda permite usar `data.sql` para inserir dados (dependendo do caso).

#### **Opção 3: Deixe o Hibernate gerenciar o schema**

Se estiver usando JPA/Hibernate, você pode deixar ele cuidar do schema com:

`spring.jpa.hibernate.ddl-auto=update spring.sql.init.mode=never`

Esse `update` tenta atualizar a estrutura da tabela **sem apagar dados**.

---

**Arquivos SQL específicos para cada banco de dados**
Além dos arquivos *schema.sql* e *data.sql*, o Spring Boot oferece suporte a SQLs específicos para cada banco de dados. Por exemplo, se a nossa aplicação oferece suporte a múltiplos tipos de banco de dados, e há diferenças de sintaxe SQL entre eles, podemos usar os arquivos *schema-${platform}.sql* e *data- ${platform}.sql*. Assim, podemos definir um *schema-h2.sql* e um *data-h2.sql* se precisarmos dar suporte ao banco de dados H2.

Logo, podemos especificar a plataforma do banco de dados definido *spring.datasource.platform=h2* no arquivo *application.properties*.

---

# Resumo do que eu fiz
### ✅ 1. **Criou arquivos SQL específicos para PostgreSQL**

- `schema-postgres.sql` → define a tabela `COURSES_POSTGRES`
    
- `data-postgres.sql` → insere dados nessa tabela

### ✅ 2. **Organizou as configurações de perfil**

- No `application.properties`:
```json
spring.profiles.active=postgres
```
Isso ativa o *application-postgres.propertes*

### ✅ 3. **Configurou a conexão com o banco no `application-postgres.properties`**
```json
spring.datasource.url=jdbc:postgresql://localhost:5432/teste
spring.datasource.username=admin
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver
```

### ✅ 4. **Habilitou a execução automática dos scripts SQL**
Você adicionou (ou corrigiu) as seguintes linhas, no *application.properties:*
```json
spring.profiles.active=postgres  
spring.sql.init.platform=postgres  
spring.sql.init.mode=always
```

### ✅ 5. **Scripts SQL foram executados automaticamente**
Quando a aplicação subiu, o Spring Boot:
- Executou o *schema-postgres.sql* criando a tabela;
- Executou o *data-postgres.sql* populando os dados.



## 3.3 Understanding the CrudRepository interface
Antes de analisarmos a interface *CrudRepository*, precisamos conhecer a interface #Repository. O repositório do Spring Data utiliza essa interface genérica como **principal abstração para uma fonte de dados**. Ela recebe uma classe de domínio de negócio que precisa ser gerenciada e um tipo de identificador dessa classe como atributos de tipo *type parameters*.

Uma **classe de domínio de negócio** é uma classe Java que representa uma entidade de negócio e que precisa ser persistida. 

A #Repository é uma **interface marcadora** (*marker interface*) e é usada principalmente para capturar **informações sobre a classe de domínio** e o tipo do seu ID. Uma interface marcadora não possui métodos ou constantes e fornece informações de tipo em tempo de execução sobre os objetos.

```java
public interface Repository<T, ID> {}
```

*CrudRepository* é uma subinterface da interface #Repository e fornece operações CRUD. A Listagem 3.14 mostra a interface *CrudRepository* do módulo *spring-data-commons*. 
```java
public interface CrudRepository<T, ID> extends Repository<T, ID> {
	<S extends T> S save(S entity); // Salva uma entidade fornecida
	Optional<T> findById(ID id); // Finds an entity by the given ID
	Iterable<T> findAll(); // Finds all entities
	long count(); // Returns the number of entities available
	void deleteById(ID id); // Deletes the entity with the given ID
}
```

A definição da interface. O tipo genérico **T** representa a classe de domínio, e o tipo **ID** representa o identificador da classe de domínio. 

Além da #CrudRepository, o Spring Data também fornece a interface *PagingAndSortingRepository*, que estende a #CrudRepository e oferece suporte adicional para **paginação e ordenação** das entidades. 

Para gerenciar a persistência de uma classe de domínio de negócio, normalmente criamos uma interface que estender a *CrudRepository* ou a *PagingAndSortingRepository*, fornecendo a classe da entidade e o tipo do seu identificador. 

A interface de repositório personalizada (por exemplo, *CourseRepository*) herda todos os métodos disponíveis da interface estendida (por exemplo, *CrudRepository*).

![[Capítulo 3 - Database access with Spring Data-3.png]]

### 3.3.1 Technique: Managing domain objects in a relational database with Spring Data JPA
Nesta seção, vamos explorar como gerenciar objetos de domínio de negócio em um banco de dados relacional com o **Spring Data JPA**.

**Solução**
Vamos aprender a como utilizar a interface *CrudRepository* para realizar operações de **criação**, **leitura** etc.

Let's start by modifying the *Course* domain class by providing a few JPA annotations so that Spring Data JPA can manage this class. This is shown in the following listing.

- Anotamos a classe com as anotações #Entity e #Table. A primeira anotação marca a classe Java como uma entidade JPA, e a segunda fornece os detalhes da tabela no banco de dados onde a entidade deve ser gerenciada.
- Anotamos os campos da classe Java com a anotação #Column. Isso fornece as informações de mapeamento entre os campos Java e os respectivos nomes das colunas na tabela.
- Anotamos o campo #id com a anotação @id para indicar que esse campo é a chave primária da tabela. Também fornecemos detalhes indicando que **os valores para esse campo devem ser gerados usando a estratégia definida**.
- O <span style="background:#d4b106">construtor de Course não possui o campo id</span>. O ID é gerenciado pelo JPA e é gerado automaticamente.

Agora, podemos um repositório personalizado do Spring Data estendendo a interface *CrudRepository*, o que permitirá gerenciar os detalhes de **Course**. 

Dessa forma, a interface *CourseRepository* herda o suporte às operações CRUD da interface estendida. A listagem a seguir mostra a interface *CourseRepository*. 

Anotamos a interface *CourseRepository* com a anotation **@Repository** para indicar que se trata de um repositório do Spring. Embora pareça ser uma interface vazia, em tempo de execução sua implementação concreta é fornecida pelo **Spring Data JPA**, que então é usada para executar as operações CRUD.

A última alteração que precisamos fazer é atualizar o properties com a propriedade *spring.jpa.hibernate.ddl-auto* definida como *create*. Essa propriedade instrui o **Hibernate** (o provedor JPA padrão no Spring Data JPA) a gerenciar as tabelas do banco de dados para as entidades.

O valor *create* instrui o Hibernate a **criar todas as tabelas do banco de dados ao iniciar a aplicação**, baseando-se nos modelos definidos pelas entidades Java, que no nosso caso é *Course*. Porém, essa opção também apaga e recria as tabelas existentes no banco, o que significa que todos os dados previamente armazenados são perdidos toda vez que a aplicação é reiniciada.z 

Vale notar que essa propriedade é específica do Hibernate e **não se aplica** se outro provedor JPA for utilizado.

