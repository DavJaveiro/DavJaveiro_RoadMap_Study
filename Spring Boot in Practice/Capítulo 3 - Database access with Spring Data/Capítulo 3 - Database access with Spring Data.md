*This chapter covers*
- [ ] Introducing Spring Data, its needs, and various Spring Data modules;
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
 1. Especificação JPA - O que é definido como padrão
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

---

 **Revisando**
Como desenvolvedor Java/Kotlin, surge uma grande questão: como acessamos bancos de dados relacionais a partir de código? A resposta está na API JDBC, incluída no Java nos pacotes *java.sqle javax.sql*. Ela faz a mediação entre o código e o banco de dados relacional executando instruções SQL.

A maior parte da API é composta por interfaces não implementadas. Portanto, precisamos de uma implementação de API, chamada *driver JDBC*, desenvolvida para o banco de dados que usamos. Com essa abordagem, não importa se usamos PorstgresSQL ou MySQL, por exemplo. O código Java é sempre o mesmo, pois depende da API JDBC.

![[Capítulo 3 - Database access with Spring Data-4.png]]

Programar com a API JDBC é extremamente trabalhoso. É sempre o mesmo *ritual*:

- Obter uma conexão;
- Criar um objeto *Statement* ou *PreparedStatement* que contenha a instrução SQL e suas possíveis variáveis;
- Executar o SQL para obter os resultados em um objeto do tipo *ResultSet*;
- Itere *ResultSet* e converta os resultados em objetos. Essa tarefa geralmente envolver lidar com valores nulos, índices e conversões de tipo;
- Manipule as exceções verificadas (SQLException).

E sempre precisamos lembrar de fechar os recursos que abrirmos.

Essa verbosidade do código não se deve a um design defeituoso da API JDBC, é uma consequência da natureza da API. Ela representa o nível mais baixo de abstração para comunicação Java com bancos de dados. 

Seja como for, se fôssemos pagos pelo número de linhas escritas, o JDBC seria uma máquina de fazer dinheiro. Como imagino que nenhum desenvolvedor esteja nessa situação, deveríamos encapsular e reutilizar código boilerplate que quase não muda entre as consultas. Boas notícias: o *Spring Framework* faz isso por nós.

 **SQL fácil com modelo Spring JDBC**
O Spring JDBC Template simplifica as tarefas tediosas relacionadas ao uso do JDBC. Ele nos permite focar na escrita de instruções SQL  e nos livra do gerenciamento manual de conexões, transações e exceções. 

 **JPA**
Vamos dar um passo adiante. Ferramentas de mapeamento objeto-relacional ORMs impulsionam a produtividade dos desenvolvedores. Simplificando, um ORM move dados entre tabelas e classes e vice-versa. Ele atua como uma dobradiça que une os mundos relacional e orientado a objetos.

![[Capítulo 3 - Database access with Spring Data-5.png]]
O ORM atua como um tradutor entre os objetos das classes e os registros das tabelas, conforme indicado por certas configurações (linha tracejada). O programa interage com o banco de dados via ORM, usando Java e o modelo de classes do programa em vez de SQL e registros (ResultSet). Como resultado, o programa se livra do código responsável pela tradução (mapToCountry()) e aumenta a sua abstração.

É aqui que entra a especificação Jakarta Persistence (JPA). Ela padroniza os recursos básicos dos produtos ORM desenvolvidos para Java. Os ORMs compatíveis com JPA são conhecidos como provedores JPA e devem oferecer a funcionalidade completa do padrão, conforme descrito em sua documentação. Dessa forma, o código que utiliza classes e interfaces JPA funciona da mesma forma com qualquer provedor JPA.

A figura abaixo mostra a camada de abstração que o JPA adiciona sobre a API JDBC, com a colaboração indispensável de um provedor JPA.

![[Capítulo 3 - Database access with Spring Data-6.png]]

 **Spring Data JPA**
A missão do Spring Data é fornecer um modelo de programação familiar e consistente, baseado em Spring, para acesso a dados, mantendo ao mesmo tempo as características especiais do armazenamento de dados subjacente.

Facilita o uso de tecnologias de acesso a dados, bancos de dados relacionais e não relacionais, estruturas de mapeamento e redução de serviços de dados baseados em nuvem.

O Spring Data JPA nos permite interagir com bancos de dados relacionais usando Spring Data e Hibernate, o provedor JPA mais popular. 
![[Capítulo 3 - Database access with Spring Data-7.png]]


---
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


 **Resumo do que eu fiz**
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

Agora, podemos criar um repositório personalizado do Spring Data estendendo a interface *CrudRepository*, o que permitirá gerenciar os detalhes de **Course**. 

Dessa forma, a interface *CourseRepository* herda o suporte às operações CRUD da interface estendida. A listagem a seguir mostra a interface *CourseRepository*. 

Anotamos a interface *CourseRepository* com a anotation **@Repository** para indicar que se trata de um repositório do Spring. Embora pareça ser uma interface vazia, em tempo de execução sua implementação concreta é fornecida pelo **Spring Data JPA**, que então é usada para executar as operações CRUD.

A última alteração que precisamos fazer é atualizar o properties com a propriedade *spring.jpa.hibernate.ddl-auto* definida como *create*. Essa propriedade instrui o **Hibernate** (o provedor JPA padrão no Spring Data JPA) a gerenciar as tabelas do banco de dados para as entidades.

O valor *create* instrui o Hibernate a **criar todas as tabelas do banco de dados ao iniciar a aplicação**, baseando-se nos modelos definidos pelas entidades Java, que no nosso caso é *Course*. Porém, essa opção também apaga e recria as tabelas existentes no banco, o que significa que todos os dados previamente armazenados são perdidos toda vez que a aplicação é reiniciada.

Vale notar que essa propriedade é específica do Hibernate e **não se aplica** se outro provedor JPA for utilizado.

Let's now write a test case to see the CRUD operations in practice, as shown in the following listing.

Neste teste de unidade, nós realizamos o autowire do *CourseRepository* e definimos três casos de teste:
- O primeiro caso de teste cria um novo curso e o salva no banco de dados. Em seguida, buscamos o curso pelo seu ID e verificamos se é o mesmo curso que foi criado;
- O segundo caso de teste cria e salva um curso no banco de dados. Depois, atualiza o **course rating** e verifica se a atualização foi bem-sucedida.
- O último caso de teste cria e deleta um curso. Ele verifica se a exclusão do curso foi bem-sucedida.

---
LER AMANHA CEDO
Boa, Davidson! A opção 1 resolveu porque o erro que estava aparecendo era causado por isso aqui:
```java
assertEquals(expectedCourse, actualCourse);
```
Sem sobrescrever `equals()` e `hashCode()`, o Java compara os dois objetos da seguinte forma:

👉 **"Eles apontam para o mesmo endereço na memória?"**

E como você:

- criou um objeto `Course`,
    
- salvou no banco,
    
- depois buscou outro objeto do banco (mesmo curso, mas **outra instância**),
    

…o Java considerava que eles eram **objetos diferentes**, mesmo que tivessem os mesmos dados.

---

### Por que `equals()` resolveu?

Quando você sobrescreve `equals()` corretamente (por exemplo, comparando pelo `id` ou por outro conjunto de atributos que identifica unicamente o objeto), você está dizendo para o Java:

> "Considere dois `Course` como iguais **quando seus dados forem iguais**, mesmo que sejam instâncias diferentes."

Assim, o `assertEquals()` passou a funcionar, porque agora ele usa o critério que você definiu.

---

**Discussion**
Neste técnica, aprendemos a gerenciar objetos de domínio de negócio por meio do **Spring Data JPA**. Para começar, atualizamos a classe de domínio de negócio com **anotações JPA**. O Spring Data JPA utiliza essas anotações para gerenciar os objetos de domínio. Vamos explorar essas anotações JPA em detalhes:
- **@Entity**: utilizamos essa anotação para indicar que essa classe é uma **entidade JPA**. Uma entidade JPA é uma classe POJO que representa o objeto de domínio de negócio que precisa ser persistido em uma tabela do banco de dados. Como configuração padrão, o Spring Data usa o nome da classe como o nome da entidade. No entanto, podemos especificar um nome personalizado para a entidade usando o atributo *name* da anotação *@Entity* (por exemplo: *@Entity(name= "COURSE")*).

- **@Table**: Por padrão, o nome da classe da entidade também representa o nome da tabela no banco de dados onde os dados da entidade devem ser persistidos. Assim, o nome da classe POJO *Course* (ou seja, *Course*) garante que os detalhes do curso sejam persistidos em uma tabela chamada *COURSE* no banco de dados. O Spring Data usa essa estratégia como padrão caso nenhuma informação de tabela seja fornecida na classe. No entanto, neste exemplo, personalizamos o nome da tabela como *COURSES* utilizando a anotação *@Table*.

- **@Id:** Uma entidade requer um *identifier* para identificar exclusivamente cada linha na tabela do banco de dados subjacente. A anotação **@Id** em um campo Java na *business domain* class especifica a propriedade como a *primary key* da tabela. Dependendo da aplicação, uma *primary key* pode ser um ID simples com um único campo, ou pode ser um *composite ID* com múltiplos campos. 
```sql
create table section(  
    course_id varchar(8),  
    sec_id varchar(8),  
    semester varchar(6),  
    year numeric(4,0),  
    building varchar(15),  
    room_number varchar(7),  
    time_slot_id varchar(4),  
    primary key (course_id, sec_id, semester, year),  
    foreign key (course_id) references course  
)
```

- **@Column** - por padrão, o Spring Data utiliza os nomes dos campos da classe como os nomes das colunas na tabela do banco de dados. Por exemplo, o nome do campo *id* representa a coluna **ID** na tabela do banco. Além disso, se tivermos uma propriedade com mais de uma palavra no formato *camelCase* na classe Java, então o nome da propriedade **camelCase** será representado como *camel_case* no campo da tabela no banco de dados. As palavras no campo são conectadas por um sublinhado _ . Assim, se definimos uma propriedade chamada *courseId*, elas será representada como *course_id* na coluna da tabela.

Embora a estratégia padrão de nomeação de colunas funcione bem na maioria dos cenários, ela nem sempre pode ser usada. Por exemplo, sua organização pode ter uma convenção pré-definida para nomeação de colunas nas tabelas do banco de dados. Assim, podemos ter um nome de coluna no banco de dados diferente do nome de coluna gerado automaticamente. Podemos resolver essa divergência de nomes especificando o nome correspondente da coluna no banco de dados usando a anotação *@Column* no campo do POJO. Por exemplo, *@Column(name="COURSE_ID")* usa **COURSE_ID** como o nome da coluna na tabela **COURSES**, em vez do nome gerado por padrão id.

Também anotamos o campo **id** com a anotação *@GeneratedValue*. Essa anotação indica que o valor da propriedade anotada será gerado automaticamente. A anotação *GeneratedValue* aceita uma estratégia *GenerationType* que define como o valor da propriedade deve ser gerado. Os valores suportados são: **TABLE**, IDENTITY, SEQUENCE E AUTO.

- **Table** - Esta opção indica que o provedor de persistência deve atribuir **primary keys** para uma entidade usando uma database table (tabela do banco de dados). É uma abordagem usada, por exemplo, <span style="background:#d4b106">por frameworks de persistência como o Hibernate</span>, no modo `TABLE` de geração de IDs. Isso é útil em cenários onde você quer centralizar a geração de IDs e evitar conflitos, especialmente em ambientes com múltiplos bancos ou sistemas distribuídos.

- **Identity** - Esta opção indica que o provedor de persistência deve atribuir a chave primária para uma entidade usando uma coluna de identidade do banco de dados. Neste caso, é uma coluna especial configurada no banco de dados para que seus valores sejam gerados automaticamente. 
```sql
CREATE TABLE Cliente (
	ID INT IDENTIFY(1,1) PRIMARY KEY,
	Nome VARCHAR(100)
);
```
- IDENTIFY indica que a numeração começa em 1 e é incrementada de 1 a cada nova inserção. O banco de dados cuida sozinho dessa geração, sem que precisemos atribuir o ID manualmente.

Essa abordagem é útil porque:
1. É eficiente: garante a geração única e automática dos IDs;
2. É simples: facilita o trabalho do desenvolvedor, já que não precisamos implementar lógica para gerar chaves.

- **Sequence -** Como o nome sugere, esta opção permite que o provedor atribua a chave primária utilizando uma sequência do banco de dados;

- **Auto -** Esta opção permite que o provedor determina o esquema de geração de ID.

Já, com relação a interface *CourseRepository*, anotamos ela com @Repository. Essa anotação cumpre dois propósitos importantes:
- **Detecção automática (Auto detection) -** a anotação **@Repository** é meta-anota com a anotação **@Component**. Assim, o *Component scan* do Spring pode detectar automaticamente as interfaces de repositório por meio da varredura do *classpath*, e podemos usar o *autowire* em outras classes.

- **Tradução de exceções (Exception translation)** - Um dos principais benefícios de usar Spring Data JPA é que ele oferece flexibilidade para trocar o provedor de persistência subjacente. Por exemplo, podemos instruir o Spring Boot a usar o EclipseLink como provedor JPA em vez do Hibernate. No entanto, isso também traz a sobrecarga de lidar com exceções específicas do EclipseLink.
A anotação `@Repository` ajuda a gerenciar essa sobrecarga por meio do seu suporte à **tradução de exceções (exception translation)**. Neste contexto, tradução de exceção significa **converter um tipo de exceção específico da tecnologia** (por exemplo, `SQLException`, `EclipseLinkException` ou `HibernateException`) para um tipo genérico de exceção do Spring (por exemplo, `DataAccessException`).

O Spring Data fornece `DataAccessException` e um conjunto de suas classes filhas, que são exceções de tempo de execução (_runtime exceptions_). Essas exceções encapsulam as exceções verificadas específicas da tecnologia original, permitindo que você defina uma estratégia consistente de tratamento de exceções por meio da `DataAccessException`.

**Camada de serviço e camada de objeto de acesso a dados (DAO)**
Normalmente, não utilizamos diretamente um repositório ou as implementações de DAO na aplicação. Deve haver uma **camada** de serviço de negócios (business service layer) que atua como uma ponte entre o *controller* e o *repository* ou a famosa DAO.

O JPA oferece a flexibilidade de <span style="background:#d4b106">inferir automaticamente os DDLs</span> a partir das classes anotadas com *@Entity* e executá-los no banco de dados. A propriedade *spring.jpa.hibernate.ddl-auto* define **como gerenciar os DDLs** em nossa aplicação. Os valores possíveis para essa propriedade são:
- **none** - desativa o gerenciamento automático de DDLs. É o valor padrão para bancos de dados não-embaarcados;
- **validate** - valida o schema do banco de dados, mas não faz nenhuma alteração. O Spring Boot lança um erro se o schema do banco não estiver na estrutura esperada;
- **update** - atualiza o schema já existente no banco de dados, se necessário.
- **create** - cria o schema no banco de dados e remove qualquer dado já existe;
- **create-drop** - cria o schema no início e remove tudo ao final da sessão. Esse é o valor padrão para bancos de dados embarcados.

A propriedade `spring.jpa.hibernate.ddl-auto` é específica para o Hibernate, que é o provedor de persistência padrão no Spring Boot. Se você estiver usando outro provedor de persistência, pode utilizar a propriedade mais genérica `spring.jpa.generate-ddl`, que aceita um valor booleano.

Na técnica anterior, você explorou a possibilidade de usar o `schema.sql` para criar o schema do banco de dados. Na técnica atual, você aprendeu sobre a propriedade `spring.jpa.hibernate.ddl-auto`, que também pode instruir o Spring Data JPA a criar o schema do banco de dados com base nas anotações JPA.

Você precisará garantir que escolha uma das abordagens para criar o schema do banco de dados. Se optar por usar o `schema.sql`, configure a propriedade `spring.jpa.hibernate.ddl-auto` como `none` no arquivo `application.properties`.

Nesta técnica, você explorou o uso da interface `CrudRepository` para realizar operações CRUD em sua aplicação. No entanto, em alguns casos, você pode precisar controlar a exposição dos métodos CRUD. Por exemplo, você pode não querer expor o método `delete(...)` que exclui as entidades de negócios, devido ao design da sua aplicação. Muitas organizações, por exemplo, <span style="background:#d4b106">preferem não excluir dados da aplicação, optando por atualizar os detalhes como inativos no banco de dados.</span> Na próxima técnica, você aprenderá a controlar a exposição dos métodos CRUD definindo um repositório customizado no Spring Data.

### 3.3.2 Technique: Creating a custom Spring Data repository with Spring Data JPA to manage domain objects in a relational database
Nesta técnica, demonstraremos como criar repositórios personalizados do Spring Data.

**Problema** - desejamos utilizar interfaces de repositório do Spring Data para gerenciar os objetos de domínio de nossa aplicação, mas não queremos expor todos os métodos CRUD.

**Por que evitar expor todos os métodos CRUD?**
- **Segurança:** expor todos os métodos CRUD pode permitir operações indesejadas, como exclusões acidentais (*delete*) ou modificações indevidas (*update*), especialmente se essas operações não forem controladas adequadamente.

- **Encapsulamento:** em muitos casos, queremos apenas que operações específicas estejam disponíveis para determinados repositórios.  Por exemplo, talvez só precisemos de um método *save()* e *findAll()* em um repositório, mas não queremos permitir *delete()* ou *findById()*.

**Solução** - as interfaces de repositório do Spring Data fornecem uma maneira excelente e fácil de gerenciar os objetos de domínio de negócios. Elas também permitem que definamos nossas próprias interfaces de repositório personalizadas caso aquelas fornecidas pelo framework não atendam às necessidades. Com esta técnica, definiremos uma interface de repositório Spring Data personalizada e a usaremos em nossa aplicação Spring Boot.

Para criar um repositório personalizado, precisamos definir uma interface de repositório base que estenda a interface **Repository** do Spring Data. Poderemos então selecionar e especificar os métodos *CrudRepository* que desejamos expor. Vamos definir uma interface chamada *BaseRepository*, que expõe apenas os métodos *save()* e *findAll()* da interface *CrudRepository*:

```java
@NoRepositoryBean  
public interface BaseRepository<T, ID> extends Repository<T, ID> {  
    <S extends T> S save(S entity);  
  
    Iterable<T> findAll();  
}
```
Anotamos essa interface com a anotação *@NoRepositoryBean*. Como esta é uma interface base, não desejamos que a infraestrutura do Spring Data detecte essa interface e cria uma instância concreta dela. A anotação *@NoRepositoryBean* garante que a interface **BaseRepository** seja excluída da criação de objetos proxy. Também fornecemos as assinaturas de métodos do **CrudRepository** que deseja expor na interface **BaseRepository**. Para essas chamadas de método, o Spring Data direciona as chamadas em tempo de execução para a classe de implementação JPA real, já que elas correspondem à assinatura dos métodos do **CrudRepository**.

Vamos definir uma interface personalizada que estende a interface **BaseRepository**, conforme mostrado na listagem 3.19. Isso garante que o repositório personalizado tenha acesso aos métodos definidos na interface **BaseRepository**. 

A interface **CustomizedCourseRepository** é semelhante à interface **CourseRepository**, com a exceção de que ela estende a interface **BaseRepository** e permite acesso apenas aos métodos **save(..)** e **findAll()**.

Vamos definir um caso de teste que utiliza a interface personalizado **CustomizedCourseRepository**, como mostrado na listagem 3.20. Observe que podemos invocar apenas os métodos **save(..)** e **findAll()**. Tentar acessar outros métodos do **CrudRepository** resultará em um erro de compilação, já que a assinatura desse método não está disponível na interface **BaseRepository**.

**Dicussion**
In this technique, you've learned how to define a custom repository interface in your application. Although the *CrudRepository* interface is suitable in most of the scenarios, sometimes it is useful to control the CRUD operations. With the *@NoRepository* Bean annotation, Spring Data lets you achieve this. 

---
**@SpringBootTest vs. @DataJpaTest**
Na técnica anterior, usamos a anotação *@DataJpaTest* em vez *@SpringBootTest*. 
- *@SpringBootTest* -  é útil quando precisamos inicializar todo o contêiner IoC do Spring. Assim, essa anotação cria o *ApplicationContext* que é usado nos testes. No entanto, às vezes, carregar o contêiner completo é exagerado. Por exemplo, ao testar a camada DAO, estamos interessado apenas em carregar os beans relacionados - não todo o **ApplicationContext**. Para alcançar isso, o Spring Boot fornece várias anotações para dividir os testes em diferentes camadas e testar apenas a camada que estamos interessado. Por exemplo, a anotação *@DataJpaTest* é fornecida para testar apenas os componentes JPA. Da mesma forma, a anotação *@WebMvcTest* foca apenas nos componentes **Spring MVC**. Recomenda-se o uso dessas anotações específicas para funcionalidades sempre que aplicável. 

---

## 3.4 Retrieve data from a database using Spring Data
Nas seções anteriores, aprendemos a como configurar bancos de dados e gerenciar objetos ou entidades de domínio de negócios. Nesta seção, aprenderemos várias técnicas para <span style="background:#b1ffff">acessar dados de um banco de dados</span> de forma eficiente em uma aplicação Spring Boot.
### 3.4.1 Defining query methods
Nós aprendemos a utilizar a interface **CrudRepository** para gerenciar objetos de domínio de negócios. Embora essa interface forneça operações CRUD padrão, <span style="background:#b1ffff">às vezes esses métodos genéricos</span> não são suficientes. Em vez disso, podemos precisar de um controle mais refinado para gerenciar os objetos de domínio. Por exemplo, pode ser necessário consultar entidades com base em propriedades da entidade, em vez de depender apenas do ID da entidade (ou seja, o método padrão *findById(..)*)

Podemos precisar consultar entidades aplicando condições nas propriedades da entidade (por exemplo, *Like*, *StartWith*, *Containing*, etc.). Além disso, pode ser interessante ordenar (isto é, em ordem ascendente ou descendente) as entidades recuperadas com base em uma ou mais propriedades da entidade. 

O **Spring Data JPA** fornece duas maneiras de definir métodos de consulta personalizados que podem atender à maioria dessas necessidades personalizadas:
- **Definir métodos personalizados nas interfaces de repositório com padrões de nomenclatura específicos:** O Spring Data pode analisar internamente esses métodos e gerar a consulta a partir deles.
- **Definir métodos personalizados e fornecer uma consulta SQL que será usada diretamente pelo Spring Data para consultar as entidades.**

Nesta seção, aprenderemos a **primeira opção** para definir assinaturas de métodos de consulta, de modo que o Spring Data possa analisar os métodos fornecidos e gerar as consultas automaticamente. O Spring Data possui um padrão de nomenclatura pré-definido que é compreendido pelo seu **parser de métodos**. Ele suporta os seguintes padrões comumente usados:
- **Query** - para consultar entidades, permite que definamos métodos como **find..By**, **read..By**, **get..By**, **query..By**, **stream..By** e **search..By**.
- **Count** - este padrão é usado para definir métodos como **count..By()** que contam o número de entidades;
- **Exists** - usado para definir métodos como **exists..By()** que verificam a existência de uma entidade;
- **Delete** - para excluir entidades, permite que definamos métodos como **delete..By()** e **remove..By()**.

Esses padrões permitem que criemos consultas complexas sem precisar escrever explicitamente consultas SQL ou JPQL, tornando o código mais limpo e fácil de manter. <span style="background:#b1ffff">O Spring Data interpreta esses métodos com base nos nomes e gera automaticamente as consultas correspondentes no banco de dados.</span>

O Spring Data utiliza o conceito de **Subject** e **Predicate** para analisar os métodos. Ele divide a assinatura do método com base na cláusula By, tratando a primeira parte como **Subject** e o restante como **Predicate**. Assim, se definirmos um método chamado *findDistinctCourseByCategoryOrderByName()*, a parte **DistinctCourse** será o Subject, enquanto **CategoryOrderByName** será o Predicate. Isso é demonstrado na figura 3.6. 
![[Capítulo 3 - Database access with Spring Data-8.png]]

### 3.4.2 Technique: Defining custom query methods to retrieve domain objects from a relational database with Spring Data JPA
In this technique, we'll explore how to create custom query methods to retrieve entities from a relational database.

**Problem**
We need to use Spring Data JPA to define custom query methods query methods to retrieve entities from a relational database in your Spring Boot application.

**Solution**
Spring Data JPA lets define custom query methods to retrieve business entity details from the database.  In this exercise, we'll learn to use this techinique by defining a few custom query methods in the *CourseTracker* application.

Na técnica anterior, usamos a interface *CourseRepository* para estender a interface *CrudRepository* e acessar os métodos definidos nela. Vamos modificar a interface *CourseRepository* para fornecer algumas assinaturas de métodos de consulta, como mostrado na listagem a seguir:

**Por que usar *Stream* direto no repositório?**
1. Eficiência com muitos dados: como o **Stream** é lazy, ele não carrega tudo na memória de uma vez. Por exemplo, ao acessar uma entidade em um banco de dados, os dados relacionados são imediatamente carregados; portanto, o carregamento #lazy "*preguiçoso*", faz os dados serem buscados apenas quando tentarmos acessá-los diretamente.
2. Maior flexibilidade para realizar transformações ( #map, #filter, #collect ) no mesmo fluxo;
3. Permite encadear operações direto no resultado da consulta.

**Mas há um detalhe:**
Quando usamos #Stream em um método de repositório, o **Spring Data JPA** precisa gerenciar a conexão com o banco de forma especial. Por isso, é necessário que o método que consome o #Stream esteja dentro de uma transação.
```java
@Transactional(readOnly = true)
public void imprimirNomesDosCursos(String category) {
	try (Stream<Course> cursos = repository.streamAllByCategory(category)) {
		cursos.map(Course::getName)
			.forEach(System.out::println);
	}
}
```

O *try-with-resources* fecha o *Stream* automaticamente, finalizando a conexão com o banco de dados, que só é mantida aberta enquanto o *Stream* está em uso.

**Exemplo real de uso**:
```java
public interface CourseRepository extends JpaRepository<Course, Long> {
	Stream<Course> streamAllByCategory(String category);
}
```

**Na classe service:**
```java
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Transactional(readOnly = true)
	public List<String> buscarNomesDosCursos(String category) {
		try (Stream<Course> stream = repository.streamAllByCategory(category)) {
			return stream
				.filter(c -> c.getDuration() > 10)
				.map(Course::getName)
				.collect(Collectors.toList());
		}
	}
}
```

---
Em nossa técnica, definimos sete métodos de consulta personalizados que buscam os detalhes do curso e informações relacionadas no banco de dados. Vamos explicar esses métodos em detalhes. Podemos observar que apenas definimos as assinaturas dos métodos, sem fornecer nenhuma implementação para eles. O Spring Data JPA analisa as assinaturas dos métodos e garante uma implementação concreta internamente:
- *findAllByCategory* - este é o método de consulta mais simples que definimos na interface *CourseRepository*. Esse método permite que definamos um método personalizado que encontra uma lista de entidades que pertencem a uma categoria específica. Podemos definir mais métodos de consulta personalizada que utilizem outras propriedades da entidade. Por exemplo, para encontrar um curso que corresponda à descrição do curso fornecida, podemos definir um método chamado *findByDescription(String description)*.

- *findAllByCategoryOrderByName* - esta é uma extensão do método **findAllByCategory**, com a diferença de que ele retorna os cursos em ordem ascendente com base no nome do curso.

- *existsByName* - este método verifica se existe um curso com o nome fornecido. Ele retorna **true** se o curso existir ou **false** caso contrário.

- *countByCategory* - este método retorna a contagem de cursos para a categoria fornecida.

- *findByNameOrCategory* - encontra todos os cursos que correspondem ao nome do curso fornecido ou à categoria do curso. Semelhante à cláusula **OR**, também podemos utilizar a cláusula **AND** se precisarmos definir uma consulta que exija que ambas as propriedades estejam disponíveis.

- *findByNameStartsWith* - encontra todos os cursos cujo nome começa com a string do nome do curso fornecida. O parâmetro do método para o nome do curso pode ser uma substring do nome real do curso.

- *streamAllByCategory* - encontra todos os cursos por categoria e retorna um **Stream** do Java 8. Um tipo de retorno **Stream** é diferente do tipo de retorno **Iterable**. Um **Iterable** é uma **estrutura de dados que contém os dados retornados**, sobre os quais podemos iterar. Um **Stream** não é uma estrutura de dados; em vez disso, ele aponta para uma fonte de dados da qual os dados podem ser transmitidos.

**Discussion**
Nesta seção, aprendemos alguns conceitos importantes do Spring Data JPA. Vamos resumir os conceitos que exploramos até agora:
- Aprendemos como definir métodos de consulta personalizados no repositório com base nas propriedades da entidade. Também vimos como usar vários padrões, como **OR**, **StartsWith** e **OrderBy**, para controlar a consulta e a ordem dos resultados retornados. Essas são apenas algumas das expressões que demostramos neste exemplo. 

- Vimos como definir um método de repositório com um Stream do Java 8 na interface do repositório e, subsequentemente, usar o **Stream** retornado em nossa aplicação. Isso constrasta com o tipo de retorno **Iterable**, através do qual retornamos uma coleção. Podemos aproveitar os recursos do **Stream**, como técnicas de **map-filter-reduce**, usando o método **stream** definido no repositório. 

**Uso do Stream**
Os métodos de streaming do Spring Data JPA mantêm a conexão com o banco de dados aberta para buscar resultados de forma preguiçosa #lazy à medida que processamos o stream. **Isso requer uma transação ativa para manter a conexão** e buscar os resultados de forma preguiçosa #lazy à medida que processamos o stream. Se a conexão, a sessão do banco de dados é fechada quando o método do repositório retorna, tornando o stream inutilizável.

A anotação *@Transacional* mantém a conexão com o banco de dados aberta durante toda a exceução do método anotado.

### 3.4.3 Implementing pagination with PagingAndSortingRepository
Paginação é uma técnica utilizada para dividir um grande conjunto de dados em múltiplas páginas. Trata-se de uma abordagem eficiente e amigável ao servidor para entregar resultados aos seus usuários. Normalmente, os usuários de aplicações não costumam ir além dos primeiros resultados apresentados, independentemente da quantidade total dos resultados disponível. Dessa forma, recuperar, processar e retornar um grande volume de dados pode, em muitos casos, desperdiçar largura de bando e tempo de CPU. Além disso, se os dados retornados incluírem recursos como imagens, isso pode desacelerar o carregamento da aplicação e prejudicar a experiência do usuário. Um exemplo clássico é o de exibir um catálogo de produtos com centenas de itens, sendo que cada item do catálogo contém uma imagem.

O Spring Data oferece a interface #PagingAdnSortingRepository, que permite paginar e ordenar os dados retornados. Como essa interface estende a #CrudRepository, também podemos acessar as funcionalidades básicas de CRUD fornecidas por ela. 

### 3.4.4 Technique: using #PagingAndSortingRepository interface to paginate and sort the data

Nesta técnica, vamos demonstrar como usar a interface para paginação e ordenação.

**Problem**
Carregar, ordenar e retornar um grande conjunto de dados para os usuários da aplicação desperdiça recursos do servidor e impacta negativamente a experiência do usuário. Precisamos retornar os dados em subconjuntos menores, na forma de páginas.

**Solução**
A paginação é a técnica de dividir os dados em porções menores, conhecidas como páginas. É possível configurar o tamanho da página, o que determina a quantidade de registros ou dados contidos nela. Para melhorar a experiência do usuário, podemos, opcionalmente, ordenar os dados em ordem ascendente ou descendente.

Let's define the *CourseRepository* interface that extends the *PagingAndSortingRepository*", we'll look into the *PagingAndSortingRepository*:
```java

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

}
```

Next, let's define a test case that uses the *PagingAndSortingRepository* interface, as shown in the following listing.
```java
@Test
void givenDataAvaibleWhenLoadFirstPageThenGetFiveRecords() {
	Pageable pageable = PageRequest.of(0, 5);
	assertThat(courseRepository.findAll(pageable)).hasSize(5);
	assertThat(pageable.getPageNumber()).isEqualTo(0);

	Pageable nextPageable = pageable.next();
	assertThat(courseRepository.findAll(nextPageable)).hazSize(4);
	assertThat(nextPageable.getPageNumber()).isEqualTo(1);
}
```
No código acima, estamos realizando as seguintes atividades:
- Criando uma instância de **PageRequest** usando o método estático *of*, especificando o número da página e a quantidade de registros na página. Definimos o número da página como 0 e o tamanho dos registros na página como 5.
- Utilizando uma instância de **Pageable** no método **findAll()** da *CourseRepository* para carregar a primeira página. O método **findAll()** é proveniente da interface *PagingAndSortingRepository*. 
- Utilizando os diversos métodos das instâncias de **Pageable** para verificar valores, como próxima página e o número da página.

```java
Pageable pageable = PageRequest.of(0, 5);
```
No exemplo acima, se tivermos 20 registros no banco e usarmos o objeto instanciado *pageable*, o Spring vai retornar:
- A primeira página (índice 0);
- Com 5 registros
- A consulta final terá um *LIMIT 5 OFFSET 0* no SQL.

O objeto *Pageable nextPageable = pageable.next()* é muito útil para navegarmos em uma estrutura de loop ou lógica de paginação automática:
```java
Page<Produto> pagina = produtoRepository.findAll(pageable);

while (pagina.hasContent()) {
	// processa os dados
	pagina.forEach(produto -> System.out.println(produto.getName()));

	if (pagina.hasNext()) {
		pageable = pagina.nextPageable(); 
		pagina = produtoRepository.findAll(pageable);
	} else {
		break;
	}
}
```

Vamos explorar o uso das facilidades de classificação fornecidas na interface *PagingAndSortingRepository*:

**O que é a classe Condition< T>**
*Condition< T>* é uma classe do *AssertJ*, usada para representar uma condição lógica que pode ser testada contra objetos do tipo genérico T.

**O que *matches(Course course)* faz?**
```java
Condition<Course> sortedFirstCourseCondition = new Condition<Course>() {
	public boolean matches(Course course) {
		return course.getId() == 4 && course.getName().equals("Cloud Native Spring Boot Application Development");
	}
}

```
O método está dizendo:
- Um *Course* atende à condição se:
	- Seu **id** for igual a 4;
	- e seu **name** for exatamente "nome passado";

**Discussion**
A interface #PagingAdnSortingRepository é uma interface útil que permite alcançar recursos personalizados de paginação e ordenação em nossa aplicação. O código fonte da interface é o seguinte:
```java

public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
	Page<T> findAll(Pageable pageable);

	Iterable<T> findAll(Sort sort);
}
```

O primeiro método *findAll()* recebe uma instância de **Pageable**. A interface **Pageable** fornece vários métodos úteis para construir requisições de página, além de permitir o acesso às informações da página. Podemos usar o método **of()** para criar a requisição de página, especificando o número da página junto com a quantidade de registros nela. Além disso, essa interface também permite acessar as páginas anteriores e seguintes.

O segundo método **findAll()** recebe uma instância de Sort. A classe Sort é flexível e oferece diversas maneiras de construir uma ordenação personalizada. Em nosso segundo caso de teste, foi criado um critério de ordenação específico, com **rating** em ordem decrescente e **name** em ordem crescente.

### 3.4.5 Specifying query using @NamedQuery
Na seção 3.4.1, foram apresentados dois métodos para definir consultas. O primeiro, abordado anteriormente, trata da <span style="background:#d4b106">definição de métodos de consulta personalizados</span> para recuperar objetos de domínio de um banco de dados relacional usando **Spring Data JPA**. Nesse método, as assinaturas dos métodos de consulta são definidas manualmente, e o **Spring Data** gera automaticamente as consultas com base nos nomes desses métodos.

Vamos explorar, nesta seção, uma segunda abordagem, que consiste em definir manualmente as consultas diretamente nos métodos do repositório. Dessa forma, o **Spring Data** utilizará essas consultas como foram escritas, em vez de derivá-las a partir dos nomes dos métodos.

Embora a <span style="background:#d4b106">abordagem baseada nos nomes dos métodos funcione</span> bem na maioria dos casos, há situações em que definir explicitamente as consultas pode ser mais vantajoso. Algumas dessas circunstâncias incluem:
- Quando uma consulta foi refinada para aproveitar recursos específicos do banco de dados.
- Quando é necessário acessar múltiplas tabelas por meio de **joins**, permitindo a obtenção de dados combinados entre diferentes tabelas.

Vamos aprender a especificar manualmente as consultas utilizando os recursos #NamedQuery, #Query e #QueryDSL do **Spring Data**.

Uma #NamedQuery é uma consulta predefinida associada a uma entidade de negócio. Ela utiliza #JPQL (<span style="background:#b1ffff">Jakarta Persistence Query Language</span>) para definir a consulta. É possível definir uma **NamedQuery** em uma entidade ou em sua superclasse.

Podemos criar a **NameQuery** utilizando a anotação *@NamedQuery* em nossa classe de entidade. Essa anotação possui quatro argumento: **name**, **query**, **lockMode** e **hints**. Os atributos **name** e **query** são obrigatórios. 

### 3.4.6 Technique: Using a named query to manage domain objects in a relational database with Spring Data JPA
In this technique, we'll discuss how to use name query to manage domain objects.

**Problem**
Precisamos usar **NamedQuery** com **Spring Data JPA** para definir consultas personalizadas nos métodos da interface do repositório e gerenciar objetos de domínio em um banco de dados relacional.

**Solution**
Embora os métodos de consulta com a abordagem de definição de assinatura de método funcionem bem na maioria dos cenários, há casos em que apresentam algumas limitações. Por exemplo, se for <span style="background:#d4b106">necessário unir várias tabelas e recuperar os dados</span>, não há uma maneira fácil de definir as assinaturas dos métodos. Com a consulta nomeada, é possível fornecer a consulta junto com a assinatura do método, para que ela possar ser usada para recuperar os dados.

No POJO Course, fornecemos os detalhes da consulta que recupera todos os cursos pela categoria informada na anotação *@NamedQuery*. O atributo name contém o nome da entidade e do método concatenados com um ponto. . Na consulta, fornecemos a consulta junto com dois parâmetros posicionais **?1** e **?2**. Ele usa os valores dos parâmetros informados quando o método do repositório é invocado.

Além disso, podemos usar a anotação *@NamedQuery* <span style="background:#d4b106">mais de uma vez na entidade se precisarmos definir mais de um método de repositório</span> para utilizar o recurso *@NamedQuery*, conforme mostrado na listagem a seguir:

```java
@Entity
@Table(name = "COURSES")
@NamedQueries({
	@NamedQuery(name = "Course.findAllByRating", query = "select c from Course c where c.rating=?1"),
	@NamedQuery(name = "Course.findAllByCategoryAndRating", query = "select c from Course c where c.category=?1 and c.rating=?2),
})
public class Course {
	// omitted
}

```

Let us redefine the *CourseRepository* interface, which now contains a custom method with the same method name provided in the *@NamedQuery* annotation in the *Course* entity.

```java
@Repository  
public interface CourseRepository extends CrudRepository<Course, Long> {  
    Iterable<Course> findAllByCategoryAndRating(String category, int rating);  
}
```
O método do repositório é definido com a anotação *@NamedQuery*. Ele é definido na classe repository para que possamos usá-lo com a instância de *CourseRepository*. 

## 3.5 Specifying query using @Query
Embora as consultas nomeadas para declarar consultas na classe de entidade funcionem bem, elas adicionam <span style="background:#d4b106">desnecessariamente informações de persistência na classe do domínio de negócios</span>. Isso pode ser preocupante, pois acopla fortemente os detalhes de persistência nas classes do domínio de negócios.

Como alternativa, podemos fornecer as informações da consulta na <span style="background:#d4b106">interface do repositório.</span> Isso coloca junto o método de consulta e a consulta JPQL no mesmo local. Podemos usar a anotação *@Query* nos métodos da interface do repositório para fazer isso. Além disso, a vantagem de usar a anotação *@Query* em vez de consultas nomeadas é que a anotação *@Query* <span style="background:#d4b106">permite que utilizemos consultas SQL nativas</span>. Assim, podemos usar tanto JPSQl quanto consultas SQL nativas com a anotação *@Query*.

### 3.5.1 Technique: Using @Query annotation to define queries and retrieve domain objects in a relational database with Spring Data JPA
Neste técnica, discutiremos como usar a anotação *@Query* para definir e recuperar objetos de domínio. 

Devemos utilizar a anotação *@Query* com o Spring Data JPA para definir consultas personalizadas nos métodos da interface do repositório, a fim de gerenciar objetos de domínio em um banco de dados relacional. 
A anotação *@Query* permite que forneçamos as consultas junto com a assinatura do método na interface do repositório. Essa é considerada uma abordagem mais recomendada, pois os objetos de domínio do negócio ficam livres de informações relacionadas à persistência. 

Let's define the *CourseRepository* interface in which you'll provide three repository methods using the *@Query* annotation, as shown in the following listing.

A classe que iremos escrever define diversos métodos de consulta e atualização em entidades do tipo *Course*, utilizando a anotação *@Query* com **JPQL**, parâmetros nomeados, argumentos posicionais, consultas nativas, e também operações de modificação com suporte transacional.

**Método 1: Consulta por categoria (argumento posicional  ou placeholders)**:
```java
@Query("select c from Course c where c.category=?1")
Iterable<Course> findAllByCategory(String category);
```
Este método de repositório encontra todos os cursos que pertencem à categoria fornecida. A anotação *@Query* permite definir uma consulta **JPQL** personalizada. Neste caso, foi usado um **argumento posicional (?1)**, que será substituído pelo valor do parâmetro *category*.

**Método 2: Consulta por categoria e nota mínima (com parâmetros nomeados)**
```java
@Query("select c from Course c where c.category=:category and c.rating > :rating")
Iterable<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);
```
Esse método recupera todos os cursos que:
- pertencem à categoria especificada e;
- possuem uma nota (rating) maior que o valor fornecido
Aqui são usados parâmetros nomeados (*:category* e *:rating*), que são substituídos pelas variáveis correspondentes nos argumentos do método com a anotação *@Param*. 

Podemos escrever a consulta sem o uso de **parâmetros nomeados**, neste caso, usando apenas os placeholders:
```java
@Query("select c from Course c where c.category=?1 and c.rating>?2")
Itrable<Course> findAllByCategoryAndRatingGreaterThan(String category, int rating);
```

**Método 3: Consulta por nota (com SQL nativo)**
```java
@Query("SELECT * FROM COURSE where rating=?1", nativeQuery = true)
Iterable(Course) findAllByRating(int rating);
```
Este método busca todos os cursos com uma nota específica, usando uma consulta SQL nativa.
Como a consulta não é JPQL, foi necessário definir o campo *nativeQuery = true*, logo após a consulta.

**Método 4: atualização da nota do curso pelo nome**
```java
@Modifying
@Transactional
@Query("update Course c set c.rating=?1 where c.name=?2)
int updateCourseRatingByName(int rating, String name);
```

---
When we query changes data, we'll also need to annotate the method with the *@Modifying* annotation. If we use *UPDATE*, *INSERT* or *DELETE*, we also need to annotate the method with *@Modifying*.

### 🔹 1. Uso de `@Query` com parâmetros posicionais

- Você utilizou a anotação `@Query` para definir a **JPQL query** que será usada pelo **Spring Data** para buscar os cursos.
    
- Essa consulta é semelhante à usada na técnica de **named queries** da seção 3.4.6.
    
- A query utiliza **argumentos posicionais** para substituir os parâmetros fornecidos.
    
- Neste caso, você está recuperando todos os cursos que pertencem à **categoria fornecida**.

### 2. Uso de `@Query` com parâmetros nomeados (`@Param`)

- Na consulta seguinte, você também usa a anotação `@Query`, mas com algumas diferenças na sintaxe.
    
- Em vez de argumentos posicionais, você utilizou **parâmetros nomeados**.
    
- Embora o uso de argumentos posicionais funcione bem, ele pode ser **propenso a erros** durante refatorações, caso a posição dos parâmetros mude.
    
- Para evitar esse problema, você usa a anotação `@Param` para **atribuir um nome ao parâmetro** e **fazer o binding desse nome dentro da query**.
### 🔹 3. Uso de `nativeQuery = true`

- Na terceira query, você especificou uma **consulta SQL nativa** e definiu a flag `nativeQuery = true` para indicar que se trata de uma consulta **SQL nativa** (não JPQL).
    
- Normalmente, diferentes fornecedores de banco de dados oferecem **recursos específicos** nativos.
    
- Assim, se for necessário aproveitar recursos específicos de um banco, você pode definir a SQL nativa com `nativeQuery = true`.

🔹 4. Query de modificação de dados com `@Transactional` e `@Modifying`
- A quarta query é particularmente interessante: até agora, a maioria das queries demonstradas eram usadas apenas para recuperar dados.
- Esta, no entanto, é uma **query de manipulação de dados - ela atualiza registros no banco**.

Para isso, o método possui:
- *@Transactional* - usada para garantir que a execução do método ocorra dentro de um contexto transacional; como há uma atualização no banco de dados, a operação precisa ser executada em uma transação. Visamos garantir que todas as ações de um método sejam executadas como parte de uma única transação. 
- 
- *@Modifying*
- Indica que a query definida com `@Query` é uma **modifying query** (query que modifica dados).
- Essa anotação só funciona em conjunto com `@Query`.
- Além de `UPDATE`, também pode ser usada com `INSERT`, `DELETE` e comandos DDL.
- **Atenção**: se você esquecer de usar `@Modifying` em uma query que altera dados, o Spring lançará uma exceção do tipo `InvalidDataAccessApiUsageException`.

O mecanismo @Query é uma excelente funcionalidade que permite especificar consultas JPQL e SQL diretamente nos métodos de consulta do repositório. Ele oferece várias vantagens em comparação com as outras duas abordagens (por exemplo, métodos de consulta e consulta nomeada).

O método de consulta do Spring Data tem uma limitação quando você precisa buscar dados de várias tabelas ou deseja usar algum recurso nativo do banco de dados. A abordagem @Query é útil quando você precisa buscar dados de várias tabelas com uma consulta complexa de junção de tabelas. Você pode definir a consulta e permitir que o repositório do Spring Data utilize essa consulta para recuperar os dados. Você também pode usar recursos nativos do SQL do banco de dados subjacente, se necessário.

Embora semelhante, a abordagem de consulta nomeada introduz detalhes de persistência com a anotação @NamedQuery, o que nem sempre é considerado uma boa prática. Um leitor atento pode argumentar que a abordagem @Query também especifica consultas SQL nativas dentro da classe Java, o que também não é considerado uma boa prática. Para superar esse problema, o Spring Data também permite <span style="background:#d4b106">externalizar as consultas em um arquivo de propriedades</span>. Você pode criar uma pasta chamada META-INF dentro da pasta src\main\resources. Adicione um arquivo chamado jpa-named-queries.properties dentro da pasta META-INF. Em seguida, você pode externalizar as consultas no formato Entidade.metodoFinder=Consulta. Por exemplo, você pode externalizar a consulta para o método findAllByCategory(..), conforme mostrado aqui: Course.findAllByCategory = select c from Course c where c.category=?1. O Spring Data automaticamente fará referência a essa consulta externalizada quando precisar executar o método findAllByCategory(..).

Embora as abordagens de consulta nomeada e consulta pareçam excelentes alternativas para controlar como buscar dados, ambas sofrem de uma grande desvantagem. 

<span style="background:#d4b106">Nessas abordagens, não há verificação de sintaxe da consulta fornecida em tempo de compilação, e qualquer problema de sintaxe na consulta só aparece em tempo de execução. </span>

Na próxima seção, você aprenderá duas técnicas diferentes para definir consultas de forma programática de maneira segura em termos de tipos.

## 3.6 Using Criteria API with Spring Data JPA
Um dos principais inconvenientes de usar JPQL é a falta de segurança de tipos e a ausência de verificação estática de consultas. Isso ocorre porque as consultas JPQL <span style="background:#d4b106">não são validadas em tempo de compilação</span>. Assim, qualquer erro na consulta só pode ser detectado em tempo de execução. 

Portanto, como escrevemos a nossa consulta como uma string, o Java não sabe nada sobre o conteúdo dessa string. Então:
- Se erramos o nome do atributo ou o nome da entidade, o compilador não vai reclamar. Só iremos descobrir o erro em **tempo de execução**, ou seja, quando a nossa aplicação já estiver rodando e a consulta for executada!

A Criteria API, introduzida no JPA 2.0, adiciona uma maneira segura de tipos para criar consultas. Ela permite expressar uma consulta de forma programática e com segurança de tipos. A segurança de tipos da consulta é alcançada usando interfaces e classes que representam várias partes da consulta, como a cláusula *select*, *order-by* e outras. A segurança de tipos também é garantida em termos de referenciar atributos de uma entidade. 

### Technique: Using Criteria API to manage domain objects in a relational database with Spring Data JPA
In this technique, we'lll demonstrate the use of Criteria API.

**Problem**
Usamos JPQL ou consultas SQL nativas para acessar dados do banco de dados. No entanto, tanto o JPSQ quanto o SQL não fornecem nenhum mecanismo para validar a correção das consultas em tempo de compilação. Em vez disso, <span style="background:#d4b106">todos os problemas de sintaxe das consultas são detectados em tempo de execução</span>. Podemos implementar uma técnica que permita definir consultas programaticamente de maneira segura em termos de tipos, a fim de reduzir erros de execução nas consultas. Criteria não é nada simples...

Criteria API is a native API of JPA specification. Thus, we don't need additional libraries to use in our Spring Boot application.

```java
@SpringBootTest  
class CourseTrackerSpringBootApplicationTests {  
  
    @Autowired  
    private CourseRepository courseRepository;  
  
    @Autowired  
    private EntityManager entityManager;  
  
    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails() {  
  
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();  
  
        CriteriaQuery<Course> courseCriteriaQuery = criteriaBuilder.createQuery(Course.class);  
  
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);  
  
        Predicate courseCategoryPredicate = criteriaBuilder.equal(courseRoot.get("category"), "Spring");  
  
        courseCriteriaQuery.where(courseCategoryPredicate);  
  
        TypedQuery<Course> query = entityManager.createQuery(courseCriteriaQuery);  
  
        Assertions.assertThat(query.getResultList().size()).isEqualTo(3);  
    }  
  
}
```

Realizamos as seguintes atividades no caso de teste:
1. Injeção do #EntityManager: injetamos o EntityManager na classe de teste e usamos para criar uma instância de #CriteriaBuilder. Uma instância de *EntityManager* está associada a um contexto de **persistência**, que é um conjunto de instâncias de entidades. Dentro do contexto de persistência, as instâncias de entidades e seus ciclos de vida são gerenciados. A instância de *CriteriaBuilder* permite construirmos consultas de critérios, seleções, ordenações etc.

2. Definição da #CriteriaQuery: o *CriteriaBuilder* reetornado é usado para definir uma *CriteriaQuery*, e seu tipo é vinculado ao tipo *Course*. 

3. Definição de #Root da consulta usando a *CriteriaQuery* retornada: o *Root* representa a raiz da consulta, que é a entidade principal sobre a qual a consulta será executada (neste caso, a entidade *Course*). 

4. Criação de um *Predicate*: posteriormente, definimos o *Predicate* que especifica uma condição. Neste exemplo, o Predicate representa a categoria como *Spring*;

5. Uso do *Predicate* e criação da *TypedQuery*: por fim, usamos o *Predicate* previamente definida e criamos uma *TypedQuery*, que fornece a saída da consulta.  A *TypedQuery* garante a segurança de tipos, permitindo que o resultado da consulta seja diretamente mapeado para o tipo *Course*. 

## 3.7 Using QueryDSL with Spring Data JPA
Na seção 3.6, exploramos o uso da Criteria API com o Spring Data JPA. Embora a Criteria API seja uma API nativa do JPA, um dos principais desafios é a sua natureza verbosa. Para executar uma consulta SELECT simples, é necessário escrever várias linhas de código. 

O #QueryDSL é uma biblioteca alternativa de terceiros que também permite construir consultas seguras em termos de tipos de forma mais concisa, utilizando sua API fluente. Assim como a Criteria API, ele também garante que as seguintes verificações sejam feitas em tempo de compilação:
- Os tipos de entidade especificados em uma consulta;
- Todas as propriedades usadas em uma consulta, se elas existem e podem ser persistidas no banco de dados;
- Todos os operadores SQL recebem os valores do tipo esperado;
- A consulta resultante é sintaticamente correta.

O Spring Data fornece uma interface chamada *QuerydslPredicateExecutor* para aproveitar os recursos do QueryDSL nos módulos do Spring Data. Na próxima técnica, vamos examinar o uso do #Querydsl com o JPA. #QueryDSL.


🔸 **Para queries simples e médias** → `@Query` com JPQL resolve bem.  
🔸 **Para queries dinâmicas e seguras** → QueryDSL é ótimo.  
🔸 **Para queries complexas/otimizadas** → SQL em arquivo `.sql`, carregado via `NamedNativeQuery`, `JdbcTemplate`, ou até frameworks como **MyBatis**.

QuerySQL is an alternative to Criteria API that provides a fluent and concise API. Like Criteria API, it allows you to define the queries programmatically in a type-safe manner. In this technique, you'll see the use of QueryDSL API with Spring Data JPA to manage domain objects in a relational database.

- The *querydsl-apt* library is an annotation processing tool (APT) that enables the processing of the annotation in the source files before they move to the compilation stage. This tool generates the so-called *Q-types classes* that are related to the entity classes present in the application. These Q-types are classes that are directly related to the entity classes of your application but are prefixed with the letter Q. In our example, we'll see a QCourse.java source file created by this tool.
- The *querydsl-jpa* is the *Querydsl* library designed to be working alongside a JPA application. Similarly, if you would like to use QueryDSL with MongoDB database, we need to use querydsl-mongodb Maven dependecy.
- The *apt-maven-plugin* ensures that the **Q-types** are generated at the time of the <span style="background:#d4b106">process goal of the Maven build</span>. Besides, as the name indicates, the *output-directory* property is the place where the generated *Q-types* are kept. Furthermore, this directory needs to be included as the source folder of the project, as you'll use these generated Java files in our application.

Let's now focus on the *CourseRepository* interface, as shown in the following listing.
```java
@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, QuerydslPredicateExecutor<Course> {

}
```
Along with the *CrudRepository* interface, *CourseRepository* now also extends the *QuerydslPredicateExecutor* interface. Although this interface is not compulsory to be implemented to use *Querydsl*, it provides several overloadaed methods that let we use *Querydsl* instances with the familiar query methods (e.g., Iterable< T> findAll()). Note that the query method from the *CrudRepository* interfaces does not take any argument. 

Portanto, ao estender a interface, o nosso repository herda várias métodos prontos que permitem usar a *QueryDSL* de forma fluida e integrada ao Spring Data - sem precisar criar uma query na mão com *JPAQuery*. 

Mesmo que o uso do *QuerydslPredicateExecutor* não seja obrigatório para trabalhar com QueryDSL, ele facilita, pois podemos fazer consultas com predicates  e ordenações, do tipo:
```java
courseRepository.findAll(course.category.eq("Spring"));
courseRepository.finAll(course.category.eq("Spring"), course.rating.desc());
```

Para esta demonstração, não há alteração em nosso POJO. Caso o nosso arquivo-fonte não seja gerado automaticamente, podemos executar o comando *mvn generate-sources* a partir do path root of we project for generated the source-code.


## 3.8 Managing domain object relationships
Acessar os dados de uma única tabela é relativamente simples, mas isso raramente ocorre em aplicações empresariais modernas. Na maioria dos cenários, é provável que usemos mais de uma tabela para recuperar os dados necessários.

Na nomenclatura de banco de dados relacionais, recuperar as colunas necessárias de diferentes tabelas é conhecido como #projection. O Spring Data permite que utilizemos projeções por meio de projeção baseada em #interface ou projeção baseada em class.

Uma projeção baseada em *interface*  permite que definamos atributos de forma limitada de uma entidade, declarando uma interface que expõe métodos de acesso para as propriedades que vem ser lidas. Por exemplo, se desejamos ler apenas o campo *description* da entidade **Course** ao buscar cursos pelo nome, podemos primeiro definir uma interface que retorne apenas a descrição:
```java
public interface DescriptionOnly {
	String getDescription();
}
```

Podemos, após isto, adicionar um método de consulta na interface *CourseRepository* que retorna uma coleção de tipos *DescriptionOnly*:
```java
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	Iterable<DescriptionOnly> getCourseByName(String name);
}
```

O teste abaixo, validaria a projeção baseado em interface:
```java
@Test
public void givenACourseAvaibleWhenGetCourseByNameThenGetCourseDescription() {
	Iterable<DescriptionOnly> result = courseRepository.getCourseByName("Rapidt Spring Boot Application Development");
	
assertThat(result).extracting("description").contains("Spring Boot gives all the power of the Spring )
}
```

Como as *projeções* em Spring Data geralmente estão fortemente acopladas aos repositórios (elas existem para buscar dados parciais diretamente do banco, e não para regra de negócio ou transporte entre camadas), é comum separarmos a estrutura em `repository/projection`, deixando bem explícito que são **projeções ligadas às consultas**. 

com/
└── seuprojeto/
    ├── model/
    ├── repository/
    │    ├── CourseRepository.java
    │    └── projection/
    │         └── CourseView.java
    ├── service/
    ├── controller/
    └── dto/


O método **getCourseByName()** retorna um Iterable do tipo *DescriptionOnly*, e recuperamos a descrição. 

Uma projeção baseada em classe também é conhecida como **DTO**. Um #DTO é uma classe Java POJO que contém as propriedades selecionadas retornadas pela consulta. Como o nome sugere, o principal propósito desse objeto é transferir dados da camada DAO para uma camada superior, como a camada de serviço. Podemos lembrar que, como uma boa prática, a camada de serviço atua como uma ponte entra a camada DAO e os controladores Spring, e as camadas DAO não são acessadas diretamente. 

Outro conceito importante ao lidar com mais de uma entidade é a relação entre elas. Com base em sua associação, essa relação é classificada nas seguintes categorias:
- **um-para-um** (One-to-one) - esse tipo de relacionamento indica que uma entidade está associada a exatamente uma entidade de outro tipo. Por exemplo, em nossos testes, usamos Course, e vamos assumir que temos outra entidade chamada *CourseDetails*, que captura detalhes adicionais sobre um *Course*. Assim, podemos dizer que as entidades **Course** e **CourseDetails** têm um relacionamento um-para-um, pois um **Course** pode ter apenas um **CourseDetails**. 
- **um-para-muitos** (One-to-Many): esse tipo de relacionamento indica que uma entidade está associada a mais de uma entidade de outro tipo. Por exemplo, uma entidade **Person** pode ter mais de um **Address**. Assim, o relacionamento entre **Person** e **Address** é *one-to-many*.
- **muitos-para-um** (Many-to-One): esse tipo de relacionamento indica que várias entidades de um tipo estão associadas a uma única entidade de outro tipo. Por exemplo, o relacionamento entre a entidade **Book** e a entidade **Publisher** é **muito-para-um**, já que vários Books podem ser publicados por um **Publishes**.
- **muitos-para-muitos** (Many-To-Many): esse tipo de relacionamento indica que mais de uma entidade de um tipo está associada a mais de uma entidade de outro tipo. Por exemplo, no gerenciamento de cursos, um Course pode ser escrito por múltiplos Authors. Da mesma forma, um **Author** pode escrever múltiplos **Courses**. O relacionamento, nesse contexto, é **Muito-para-Muitos** entre as entidades author e course.

### 3.8.1 Technique: Managing domain objects with many-to-many relationships in a relational database with Spring Data JPA
Vamos aprender a gerenciar os relacionamentos muitos-para-muitos em objetos de domínio.

Ao gerenciar relacionamentos entre objetos em nossa aplicação, frequentemente encontramos cenários em que os objetos mantêm relacionamentos muitos-para-muitos, em nossa aplicação, as entidades **Author** e **Course** mantêm um relacionamento muitos-para-muitos. Vamos gerenciar o relacionamento muitos-para-muitos entre duas entidades usando o **Spring Data JPA**.

Neste cenário, é necessário mantermos os detalhes do autor e do curso, juntamente com o relacionamento entre curso e o autor. Por exemplo, um **autor** pode escrever vários cursos, e vários autores podem colaborar em um curso. Assim, nesse caso, é necessário manter as informações do autor e do curso, bem como os detalhes de seu relacionamento. Portanto, é necessário mantermos três tabelas:
- uma para os detalhes do Author;
- outra para os detalhes do Course
- uma terceira para as informações relacionadas entre eles.

![[Capítulo 3 - Database access with Spring Data-9.png]]
many-to-many

Antes de continuarmos para os nossos exemplos, vamos entender o modelo de dados que usaremos nesta técnica. A entidade **Author** é representada pela tabela **AUTHOR** no banco de dados.

A tabela de mapeamento entre as entidades **Author** e **Course** é representada pela tabela *AUTHORS_COURSES*. Para representar um relacionamento em um Sistema de Gerenciamento de Banco de Dados Relacional (RDBMS), a regra é usar tabelas de relacionamento, nas quais o relacionamento entre **author** e **course** é representado por uma entrada no banco de dados contendo os identificadores únicos correspondentes das duas tabelas. Por exemplo, a tabela **AUTHOR_COURSES** contém as informações de mapeamento de autores e cursos com base em **author_id** e **course_id**. 

```sql
ALTER TABLE author_courses
	ADD CONSTRAINT course_id_fk FOREIGN KEY
		(course_id) REFERENCES courses (id);
```
Essa instrução adiciona uma restrição de chave estrangeira à taabela author_courses. A restrição garante que o valor da coluna **course_id** na tabela **authors_courses** seja um ID válido existente na tabela **courses** (na coluna id). Isso significa que qualquer valor inserido ou atualizado na coluna **course_id** <span style="background:#d4b106">deve corresponder a um valor presenta na coluna</span> **id** da tabela **courses**, garantindo assim a integridade dos dados e evitando referências inválidas.

- A instrução, portanto, cria **chaves estrangeiras** para garantir que os valores nas colunas **course_id** e **author_id** da tabela **authors_courses** sejam válidos e correspondem a IDs existentes nas tabelas **courses** e **authors**, respectivamente.
- Essas restrições são essenciais para manter a integridade referencial no banco de dados, evitando que registros inválidos ou "órfãos" sejam criados na tabela de relacionamento **authors_courses**.

Para executar automaticamente o **schema.sql** e **data.sql**, adicionamos as seguintes propriedades adicionais no arquivo application.properties:
```json
spring.jpa.hibernate.dll-auto=none
```
Essa propriedade informa ao Spring Boot para **não gerenciar automaticamente o esquema** do banco de dados, já que estamos usando o **schema.sql** para inicializar o esquema.

```json
spring.datasource.initialization-mode=always
```
Essa propriedade instrui o Spring Boot a sempre executar os scripts de inicialização *como schema.sql* e o **data.sql** no banco de dados H2 ao iniciar a aplicação.

O atributo **mappedBy** da anotação *@ManyToMany* é usado em relacionamentos bidirecionais para indicar que a entidade atual (neste caso, o lado não proprietário) não é responsável por gerenciar o relacionamento. Em vez disso, o lado oposto (a entidade *proprietária*) é quem define e controla como o relacionamento é mapeado no banco de dados.

No contexto de um relacionamento *@ManyToMany*, uma tabela de junção (ou tabela de mapeamento) é usada armazenar as associações entre as duas entidades. O lado **mappedBy** informa ao JPA que a configuração do relacionamento já foi definida na outra entidade, evitando a criação duplicada da tabela Join.

**@ManyToMany**
A anotação *@ManyToMany* especifica a associação de vários valores com multiplicidade muitos-para-muitos. Cada associação desse tipo possui dois lados - o lado proprietário e o lado não proprietário. O lado proprietário indica a entidade que possui o relacionamento, enquanto o lado não proprietário é o inverso do relacionamento. 

No caso de um relacionamento um-para-muitos, a parte "muitos" do relacionamento é o lado proprietário. Isso ocorre porque cada objeto da parte "muitos" pode facilmente ter uma ferência para a parte "um". 

Para o relacionamento muitos-para-muitos, podemos escolher qual lado deve ser declarado como o lado proprietário, já que ambos os lados podem possuir o relacionamento. Por exemplo, nesta demonstração, selecionamos a entidade **Author** como o lado proprietário. Essa escolha foi baseada na compreensão de um autor *possui* seus cursos. 

Além disso, especificação a anotação *@JoinTable* no lado proprietário do relacionamento. No caso do lado não proprietário, especificamos o parâmetro **mappedBy** na anotação **@ManyToMany** para indicar o campo do lado proprietário. Veremos o uso do parâmetro **mappedBy** na entidade **Course**.

**@JoinTable**
Essa anotação é especificada no lado proprietário do relacionamento e geralmente é usada no mapeamento de associações **many-to-many** e unidirecionais **um-para-muitos**. Especificamos essa anotação para definir a tabela de junção **AUTHORS_COURSES**. Se essa anotação não for fornecida, os valores padrão da anotação são aplicados. Por exemplo, se o nome da tabela não for fornecido, os nomes das tabelas das entidades serão concatenados com um caractere underline, onde o nome da tabela do lado proprietário é usado primeiro. Além disso, especificamos os atributos **joinColumns** e **inverseJoinColumns** com a anotação *@JoinTable*. O **joinColumns** especifica as colunas de chave estrangeira da tabela de junção, que fazem referência à tabela principal, que é responsável pela associação. O **inverseJoinColumns** especifica as colunas de chave estrangeira da tabela de junção, que fazem referência à tabela principal (por exemplo, **COURSES**) do lado não proprietário.

**@JoinColumn**
Essa anotação permite que especifiquemos uma coluna para realizar a junção (join) de uma associação de entidades. 
```sql
@JoinColumn(name="author_id", referencedColumnName="id", nullable=false, updatable=false)
```
O atributo **name** especifica o nome da coluna de chave estrangeira (foreign key) da tabela de relacionamento. O atributo **referencedColumnName** permite definir qual coluna do banco de dados deve ser referenciada pela chave estrangeira. O atributo **nullable** indica se a coluna pode ser nula. O atributo **updatable** define se a coluna deve ser incluída em instruções **SQL UPDATE** geradas pelo provedor de persistência. 
```java
@Entity(name = "AUTHOR_COURSE")
@Table(name = "AUTHORS_COURSES")
public class AuthorCourse {
	@Id
	@Column(name="author_id")
	private long authorId;

	@Column(name = "course_id")
	private long courseId;
}
```

Esta classe armazena as informações de relacionamento das entidades **Author** e **Course** e contém as chaves primárias de ambas as tabelas. Além disso, essa entidade também representa a tabela **AUTHORS_COURSES**.

**Classe AuthorCourseDto**

```java
public class AuthorCourseDto {
	private long id;
	private String authorName;
	private String courseName;
	private String descripton;

	public AuthorCourseDto(long id, String authorName, String courseName, String description) {
		this.id = id;
		this.authorName = authorName;
		this.courseName = courseName;
		...
	}
}
```

DTO é uma projeção baseada em classe, ela permite recuperarmos dados de diferentes tabelas por meio de uma projeção que pode não ser representada por uma entidade existente. Assim, um **DTO** é uma representação orientada a objetos dos dados projetados (**tuplas**) retornados pelo método do repositório. 

Podemos usar uma classe **DTO** como tipo de retorno do repositório para consultas com **junções**.

```java
@Repository  
public interface AuthorRepository extends CrudRepository<Author, Long> {  
  
    @Query("SELECT new com.manning.sbip.ch03.dto.AuthorCourseDto " +  
            "(c.id, " +  
            "a.name, " +  
            "c.name, " +  
            "c.description) " +  
            "from AUTHOR a, " +  
            "COURSE c," +  
            "AUTHOR_COURSES ac where a.id = ac.authorId and c.id=ac.courseId and ac.authorId=?1")  
    Iterable<Author> getAuthorCourseInfo(long authorId);  
  
}
```
Na interface *AuthorRepository*, acima, o método de consulta recupera os dados contidos na tabela AUTHORS, COURSES e AUTHORS_COURSES. Como os dados obtidos por meio da projeção não representam nem a entidade **Author** nem a **Course**, eles são representados pela classe **AuthorCourseDto**.

A interface estende #CrudRepository para acessar as operações básicas de CRUD. Ela também define um método personalizado *custom finder method* para buscar os detalhes dos cursos escritos por um autor, usando o **authorId**. Como já vistos em técnicas anteriores, a anotação @Query permite especificar a consulta que será usada para recuperar os dados das tabelas do banco de dados. 

Observamos que a consulta especificada na anotação *@Query* não é uma SQL query, mas sim uma JPQL query, que une as três tabelas para buscar os dados e mapeá-los para a instância do DTO fornecido.

Portanto, temos três tabelas: **AUTHORS, AHTORS_COURSES e COURSES**. Definimos um método de consulta com uma query que faz um **JOIN** entre essas tabelas e recupera os dados com base nos critérios especificados. Para isso, criamos o **AuthorCourseDto**, um POJO Java que representa as colunas retornadas na projeção. 

![[Capítulo 3 - Database access with Spring Data-10.png]]

