*This chapter covers*
- What a data source is;
- Configuring a data source in a Spring app;
- Using JdcbTemplate to work with a database.

Quase todos os aplicativos hoje precisam armazenar os dados com os quais trabalham, e muitas vezes os aplicativos utilizam bancos de dados para gerenciar os dados que persistem. Por muitos anos, os bancos de dados relacionais têm fornecido aos aplicativos uma maneira simples e elegante de armazenar os dados, que pode ser aplica com sucesso em muitos cenários. Aplicativos Spring, assim como outros aplicativos, muitas vezes precisam usar bancos de dados para persistir dados, e por essa razão, precisamos aprender como implementar essas funcionalidades em nossos aplicativos Spring.

Neste capítulo, discutimos o que é uma fonte de dados (**data source**) e a maneira mais direta de fazer seu aplicativo Spring trabalhar com um banco de dados. Essa maneira direta é a ferramenta **JdbcTemplate** que o Spring oferece. 

A figura 12.1 mostra o seu progresso nos capítulos anteriores ao aprender a usar o Spring para implementar várias funcionalidades fundamentais em um sistema. Fizemos um bom progresso, e agora podemos usar o Spring para implementar funcionalidades em várias partes de um sistema.

## 12.1 What a data source is
Nesta seção, discutimos um componente essencial que nosso aplicativo Spring precisa para acessar um banco de dados: a **fonte de dados**. A fonte de dados é um componente que gerencia as conexões com o servidor que manipula o banco de dados (o sistema de gerenciamento de banco de dados, também conhecido como **DBMS**). 

**NOTA:** o DBMS é um software cuja responsabilidade é permitir que gerenciemos dados persistentes de forma eficiente (adicionar, alterar, recuperar), mantendo-os seguros. Um DBMS gerencia os dados em bancos de dados. Um **banco de dados** é uma coleção persistente de dados.

![[Capítulo 12 - Using Data Sources in Spring Apps.png]]
1. A fonte de dados gerencia as conexões. Ela fornece ao aplicativo conexões quando solicitadas e garante que novas conexões sejam criadas apenas quando necessário.

2. Uma fonte de dados (data sources) usa o driver JDBC para conectar-se ao DBMS (sistema de gerenciamento de banco de dados).

Sem um objeto assumindo a responsabilidade de um **data source**, o aplicativo precisaria solicitar uma nova conexão para cada operação envolvendo os dados. Essa abordagem não é viável em um cenário de produção, pois estabelecer uma nova conexão via rede para cada operação **reduziria drasticamente o desempenho** do aplicativo e causaria problemas de eficiência. O **data source** garante que o aplicativo só solicite uma nova conexão quando realmente necessário, melhorando assim o desempenho geral.

Ao trabalhar com qualquer ferramenta relacionada à persistência de dados em um banco de dados relacional, o Spring espera que definamos um **data source**. Por isso, é importante primeiro discutirmos onde o **data source** se encaixa na camada de persistência (**persistence layer**) do aplicativo e, em seguida, demonstraremos como implementar essa camada de persistência em exemplos práticos.

Em um aplicativo Java, a capacidade da linguagem de se conectar a um banco de dados relacional é chamada de **Java Database Connectivity (JDBC)**. O #JDBC oferece uma maneira de conetar-se a um #DBMS para trabalhar com um banco de dados. No entanto, o JDK não fornece uma implementação específica para trabalhar com uma tecnologia particular (como MySQL, Postgres ou Oracle).

O JDK apenas <span style="background:#d4b106">fornece as abstrações</span> dos objetos que um aplicativo precisa para trabalhar com um banco de dados relacional. Para obter a implementação dessas abstrações e permitir que seu aplicativo se conecte a uma determinada tecnologia de DBMS, você adiciona uma dependência em tempo de execução chamada **JDBC Driver**. Cada fornecedor de tecnologia disponibiliza o **JDBC Driver** que precisamos adicionar ao nosso aplicativo para permitir que ele se conecte àquela tecnologia específica. O **JDBC driver** não faz parte nem do JDK nem de frameworks como o Spring.

![[Capítulo 12 - Using Data Sources in Spring Apps-1.png]]

- App - precisa persistir os dados em um banco de dados relacional;
- Usa JDBC abstrações da JDK - O aplicativo usa abstrações JDBC fornecidas pela JDK. Interfaces como *Connection, Statement, e ResultSet* do pacote *java.sql.package* fornecidas pelo JDK são comuns em aplicativos que utilizam JDBC para conectar-se a banco de dados.

O JDBC Driver oferece uma maneira de obter uma conexão com o DBMS. 

1. Uma primeira opção é usar o *JDBC driver* diretamente e implementar o nosso aplicativo para requerer uma nova conexão sempre que precisar executar uma nova operação nos dados persistidos. Essa abordagem é frequentemente encontrada em tutoriais básicos de Java. Quando aprendemos JDBC em um tutorial de fundamentos do Java, os exemplos geralmente usam uma classe chamada **DriverManager** para obter uma conexão, como mostrado no trecho de código a seguir:
```java
Connection con = DriverManager.getConnection(url, username, password);
```

O método *getConnection()* utiliza a URL fornecida como valor do primeiro parâmetro para identificar o banco de dados que o aplicativo precisa acessar, além do nome de usuário e a senha para autenticar o acesso ao banco de dados. No entanto, solicitar uma nova conexão e autenticar repetidamente para cada operação é um desperdício de recursos e tempo, tanto para o cliente quanto para o servidor de banco de dados.

![[Capítulo 12 - Using Data Sources in Spring Apps-2.png]]
- Quando o nosso aplicativo utiliza o DriverManager diretamente, ele obtém uma nova conexão toda vez que ele precisar de uma;

Um objeto **data source** pode gerenciar as conexões de forma eficiente para minimizar o número de operações desnecessárias. Em vez de usar diretamente o **JDBC Driver Manager**, utilizamos um **data source** para recuperar e gerenciar as conexões. 

**NOTA:** um *data source* é um objeto cuja responsabilidade é gerenciar as conexões com o servidor de banco de dados para o aplicativo. Ele garante que o nosso aplicativo solicite conexões ao banco de dados de forma eficiente, melhorando o desempenho das operações da camada de persistência.

![[Capítulo 12 - Using Data Sources in Spring Apps-3.png]]

- O data source irá administrar as conexões. Ele fornece ao aplicativos as conexões quando elas são requisitadas e apenas criam novas conexões onde e quando são realmente necessárias;

Para aplicativos Java, existem várias opções de implementações de **data source**, mas a mais amplamente utilizada atualmente é o **HirakiCP (Hiraki Connection Pool)**. A configuração convencional do Spring Boot também considera o HirakiCP como a implementação de **data source** padrão, e é o que usaremos nos exemplos. 

## 12.2 Using JdbcTemplate to work with persisted data
Nesta seção, implementamos nosso primeiro aplicativo Spring que utiliza um banco de dados e discutimos as vantagens que o Spring oferece para implementar a camada de persistência. Seu aplicativo pode usar um **data source** para obter conexões com o servidor de banco de dados de forma eficiente. Mas quão fácil é escrever código para trabalhar com os dados? Usar as classes JDBC fornecidas pelo JDK não se mostrou uma maneira confortável de trabalhar com dados persistidos. Precisamos escrever blocos de códigos verbosos, mesmo para as operações mais simples, em exemplos de fundamentos de Java, podemos ter visto código como o apresentando abaixo:
```java
String sql = "INSERT INTO purchase VALUES (?, ?)";
try (PreparedStatement stmt = con.prepareStatement(sql)) {
    stmt.setString(1, name);
    stmt.setDouble(2, price);
    stmt.executeUpdate();
} catch (SQLException e) {
    // faça algo quando uma exceção ocorrer
}
```

Um bloco de código tão extenso para uma operação simples de adicionar um novo registro a uma tabela! E considere que omiti a lógica no bloco *catch*. Mas o Spring nos ajuda a minimizar o código que escrevemos para essas operações. Em aplicativos Spring, podemos usar várias alternativas para implementar a camada de persistência, e as mais importantes dessas alternativas serão discutidas neste capítulo e nos capítulos 13 e 14. Nesta seção, usaremos uma ferramenta chamada **JdbcTemplate**, que permite trabalhar com um banco de dados usando JDBC de maneira mais simplificada.

O *JdbcTemplate* é a ferramenta mais simples que o Spring oferece para trabalhar com um banco de dados relacional, mas é uma excelente escolha para aplicativo pequenos, pois não força a usarmos nenhum outro framework de persistência específico. O **JdbcTemplate** é a melhor opção do Spring para implementar uma camada de persistência quando não desejamos que o nosso aplicativo tenha outra dependências. Também considero uma ótima maneira de começarmos a aprender como implementar a camada de persistência em aplicativos Spring.

Para demonstrar como o **JdbcTemplate** é usado, implementaremos um exemplo. Seguiremos os seguintes passos:
1. Criar uma conexão com o DBMS;
2. Codificar a lógica do repositório;
3. Chamar os métodos do repositório que implementam endpoints REST;

Para este aplicativo, temos uma tabela *purchase* em um banco de dados. Essa tabela armazena detalhes sobre os produtos comprados em uma loja online e o preço da compra. As colunas desta tabela são as seguintes:
- **id** - um valor único autoincrementado que também assume a responsabilidade de chave primária da tabela;
- **product** - o nome do produto comprado;
- **price** - o preço da compra.

Neste exemplo, vamos utilizar o H2 (um banco de dados em memória, excelente para exemplos e, como veremos no capítulo 15, para implementar testes de integração) e **MySQL** (uma tecnologia gratuita e leve que podemos instalar facilmente localmente para provar que os exemplos funcionam com algo além de um banco de dados em memória).

**NOTA:** nosso aplicativo também usa um JDBC driver para o banco de dados H2. No entanto, para o H2, não precisamos adicioná-lo separadamente, pois ele já vem incluído na dependência do H2 que foi adicionada no arquivo pom.xml.

Para os exemplos deste livro, parto do pressuposto de que já conhecemos os conceitos básicos de SQL e entende as sintaxes de consultas SQL simples. Também assumo que já tenhamos trabalhado com JDBC, pelo menos em exemplos teóricos, pois isso é ensinado nos fundamentos do Java - um pré-requisito obrigatório para aprender Spring. No entanto, pode ser útil revisar seus conhecimentos nessa área antes de avançar. 

Para a parte de JDBC, recomendo o capítulo 21 do livro _OCP Oracle Certified Professional Java SE 11 Developer Complete Study Guide_ de Jeanne Boyarsky e Scott Selikoff (Sybex, 2020).



Para uma revisão de SQL, recomendo o livro _Learning SQL, 3ª edição_ , de Alan Beaulieu (O’Reilly Media, 2020).

Os requisitos para o aplicativo que vamos implementar são simples. Desenvolveremos um serviço backend que expõe dois endpoints. Os clientes chamam um endpoint para adicionar um novo registro na tabela purchase e um segundo endpoint para obter todos os registros da tabela purchase.

Ao trabalhar com um banco de dados, <span style="background:#d4b106">implementamos todas as funcionalidades relacionadas à camada de persistência em classes que, por convenção, chamamos de repository</span>. 

**Nota:** um repository é uma classe responsável por trabalhar com o banco de dados.

Para demonstrar como o JdbcTemplate é usado, implementaremos um exemplo. Seguiremos estas etapas:
1. Criar uma conexão com o DBMS;
2. Codificar a lógica do repositório;
3. Chamar os métodos do repositório em métodos que implementam as ações dos enpoints REST.

Para este aplicativo, temos uma tabela *purchase* em um banco de dados. Essa tabela armazena detalhe sobre os produtos comprados em uma loja online e o preço. 

As colunas desta tabela são as seguintes:
- #id - um valor único autoincrementado que também assume a responsabilidade de chave primária da tabela;
- #product - o nome do product comprado;
- #price - o preço da compra.

Os exemplos deste livro não dependem de tecnologia de banco de dados relacional que escolhermos. Podemos usar o mesmo código com uma tecnologia de nossa escolha. No entanto, precisei escolher uma tecnologia específica para os exemplos. Neste livro, usaremos o H2. 

Os requisitos para o aplicativo que implementaremos são simples. Desenvolveremos um serviço backend que expõe dois endpoints. Os clientes chamam um endpoint para adicionar um novo registro na tabela de compras e um segundo endpoint para obter todos os registros da tabela de compras.

Ao trabalhar com um banco de dados, implementamos todas as funcionalidades relacionadas à camada de persistência em classes que (por convenção) nomeamos como repository. A figura 12.7 mostra o design da classe do aplicativo que queremos implementar.

**NOTA:** um repositório é uma classe responsável por trabalhar com um banco de dados.

![[Capítulo 12 - Using Data Sources in Spring Apps-4.png]]

- *PurchaseController* é um controller REST. Ele expõe dois enpoints. O cliente chamada o endpoint **POST** */purchase* para adicionar um novo registro de compra e GET /purchase endpoint para obter todas as compras registradas no banco de dados.

*PurchaseRepository* usa o template do Jdbc fornecido pelo Spring. JdbcTemplate usa um #DataSource e se conecta com um banco de dados no servidor através do JDBC.

Em nosso projeto Maven, precisamos criar o nosso arquivo *schema.sql* na pasta resources, é o local onde iremos escrever as queries que irão definir a estrutura do nosso banco de dados. O Spring executa essas queries quando o aplicativo é iniciado.
[[OCP Oracle Certified Professional Java SE 11 Developer Complete Study Guide_/Capítulo 21 - JDBC/databasecode/sq-ch12-ex1/src/main/resources/schema.sql|schema]]

Precisamos adicionar uma tabela que armazena os registros de compras. Em exemplos teóricos, é fácil criar uma estrutura de banco de dados adicionando uma arquivo chamado *schema.sql* à pasta de recursos do projeto Maven

Nesse arquivo, precisamos escrever todas as querys SQL estruturais necessárias para definir a estrutura do banco de dados. Também podemos encontrar desenvolvedores referindo-se a essas consultas como *Linguagem de descrição de dados"* (DDL). Também adicionaremos um arquivo desse tipo ao nosso projeto e incluiremos a consulta para criar a tabela de compras, conforme apresentado no próximo trecho de código:

**NOTA:** Usar um arquivo *schema.sql* para definir a estrutura do banco de dados só funciona para exemplos teóricos. Essa abordagem é fácil porque é rápida e permite que a gente se concentre nas coisas que estamos aprendendo, em vez focar na definição da estrutura do banco de dados em um tutorial. Mas, em um exemplo do mundo real, precisaremos utilizar uma dependência que também permita versionar seus scripts de banco de dados. Recomendo que você conheça o Flyway ([https://flywaydb.org/](https://flywaydb.org/) ) e o Liquibase ([https://www.liquibase.org/](https://www.liquibase.org/) ). Essas são duas dependências muito apreciadas para versionamento de esquemas de banco de dados. Elas estão além dos conceitos básicos do Spring, então não as usaremos nos exemplos deste livro. Mas é uma das coisas que recomendo que você aprenda logo após os fundamentos.

Precisamos de uma classe modelo para definir os dados de compra em nosso aplicativo. As instâncias dessa classe mapeiam as linhas da tabela *purchase* no banco de dados, então cada instância precisar ter um ID, o produto e o preço como atributos. O trecho de código a seguir mostra a classe de modelo *Purchase*:
```java
public class Purchase {
	private int id;
	private String product;
	private BigDecimal price;

	// Getters e setters omitidos
}
```

Você pode achar interessante que o tipo do atributo price da classe *Purchase* é BigDecimaal. Não poderíamos tê-lo definido como double? Aqui está algo importante sobre o que quero que você esteja ciente: em exemplos teóricos, muitas vezes você encontra double sendo usado para valores decimais, mas em muitos exemplos do mundo real, usar double ou float para números decimais não é a coisa certa a se fazer. Ao operar com valores double e float, você pode perder a precisão até em operações aritméticas simples, como adição ou subtração. Esse efeito é causado pela forma como o Java armazena esses valores na memória. Quando você trabalhar com informações sensíveis, como preços, deve usar o tipo #BigDecimal. Não se preocupe com a conversão. Todas as funcionalidades essenciais que o Spring fornece sabem como usar BigDecimal.

**NOTA:** quando você deseja armazenar um valor de ponto flutuante com precisão e garantir que não perca a precisão decimal ao executar várias operações com os valores, use #BigDecimal e não #double ou #float.

Para obter facilmente uma instância de #PurchaseRepository quando precisarmos dela no #controller, também tornaremos esse objeto um bean no contexto do Spring. A abordagem mais simples é usar uma anotação de estereótipo (como *@Component* ou *@Service*), conforme você aprendeu no capítulo 3. Mas, ao invés de usar *@Component*, o Spring fornece uma anotação específica para repositórios que podemos usar: *@Repository*. Como aprendemos no capítulo 3 a usar *@Service* para classes de serviço, para repositórios, devemos usar a anotação de estereótipo *@Repository* para instruir o Spring a adicionar um bean ao seu contexto. A listagem a seguir mostra a definição de classe do repositório.

```java
@Repository
public class PurchaseRepository {

}
```
- We use the @Repository annotation to add a bean of this class type to the Spring context.

Agora que *PurchaseRepository* é um bean no contexto da aplicação, podemos injetar uma instância do #JdbcTemplate que usaremos para trabalhar com o banco de dados. Eu sei o que você está pensando! De onde vem essa instância de **JdbcTemplate?** Quem criou essa instância para que possamos injetá-la em nosso repositório? Neste exemplo, como em muitos cenários de produção, mais uma vez beneficiaremos da mágica do Spring Boot. Quando o Spring Boot detectou que adicionamos a dependência do H2, ele automaticamente configurou uma fonte de dados e uma instância de **JdbcTemplate**. 

Se você usar o Spring, mas não o Spring Boot, será necessário definir o bean #DataSource e o bean #JdbcTemplate  (você pode adicioná-lo ao contexto do Spring usando a anotação @Bean na classe de configuração, como já aprendemos). Na seção 12.3, mostrarei como personalizá-lo e em quais cenários você precisa definir suas próprias instâncias de **DataSource** e JdbcTemplate. A listagem a seguir mostra como injetar a instância de JdbcTempalte que o Spring Boot configurou para sua aplicação.


[[PurchaseRepository.java]]

Finalmente, temos uma instância de JdbcTempalte, então podemos implementar os requisitos da aplicação. O #JdbcTemplate possui um método #update que podemos usar para executar qualquer consulta de mutação de dados: #insert, #update ou #delete. Basta passar o SQL e os parâmetros necessários, e pronto; deixe o JdbcTemplate cuidar do resto (obter uma conexão, criar uma declaração, tratar o SQLException, e assim por diante). A listagem a seguir adiciona um método *storePurchase()* à classe PurchaseRepository. O método storePurchase() usa o Jdbctempalte para adicionar um novo registro na tabela:

[[PurchaseRepository.java]]
- O método update() do JdbcTempalte envia a query para o servidor de banco de dados. O primeiro parâmetro que o método recebe é a consulta, e os próximos parâmetros são os valores para os parâmetros da consulta. Esses valores substituem, na mesma ordem, cada ponto de interrogação na consulta.
Logo, quando o método **update** é executado, ele substitui os ? pelos valores fornecidos, temos a substituição dos Placeholders. 

---
**Um pouco mais sobre o método *Update***
O método *update()* é um dos métodos fornecidos pela classe *JdbcTemplate* para executar consultas SQL que alteram os dados no banco de dados. Ele é usado quando desejamos:
1. **Inserir** novos registros (`INSERT`).
2. **Atualizar** registros existentes (`UPDATE`).
3. **Excluir** registros (`DELETE`).

Ele é chamado de update() porque essas operações geralmente resultam em uma atualização no estado do banco de dados.

**Sintaxe Básica**
A assinatura do método *update()* é a seguinte:
```java
int update(String sql, Object ... args)
```

**Parâmetros**:
1. SQL: a consulta SQL que será executada. Pode conter placeholders (?) para representar valores dinâmicos.
2. Args: os valores que substituirão os placeholders (?) na consulta SQL. Esses valores são passamos como argumentos adicionais após a String SQL.
**Retorno**: o método retorna um inteiro (int), que representa o número de linhas afetadas pela operação SQL.
- Por exemplo:

---
Com algumas linhas de código, podemos inserir, atualizar ou excluir registros em tabelas.
Recuperar dados não é muito mais difícil do que isso. Assim como no caso do Insert, você escreve e envia uma consulta. Para recuperar dados, desta vez, escreveremos uma consulta com #Select. E para informar ao JdbcTemplate como transformar os dados em objetos #Purchase (nossa classe modelo), implementamos um #RowMapper: um objeto responsável por transformar uma linha do #ResultSet em um objeto específico. Por exemplo, se quisermos obter os dados do banco de dados modelados como objetos Purchase, precisará implementar um #RowMapper para definir como uma linha é mapeada para uma instância de Purchase.


![[Capítulo 12 - Using Data Sources in Spring Apps-5.png]]
### 🔹 **Passo a passo do fluxo no diagrama**

#### **1️⃣ Obtenção da conexão com o banco de dados**
- O **JdbcTemplate** solicita uma conexão ao **DataSource** para enviar consultas SQL ao banco de dados (DBMS).
- O **DataSource** verifica se há uma conexão disponível no pool e, se necessário, cria uma nova.
- O banco retorna a conexão ativa para o **JdbcTemplate**.
#### **2️⃣ Envio da consulta SQL e recuperação dos dados**
- O **JdbcTemplate** envia a consulta `SELECT` ao banco para obter os dados.
- O banco processa a consulta e retorna um **ResultSet** contendo os registros da tabela.
#### **3️⃣ Conversão dos registros do ResultSet em objetos Purchase**
- Para **cada linha** do **ResultSet**, o **JdbcTemplate** chama o **RowMapper**, que extrai os dados da linha e os transforma em um objeto `Purchase`.
- O resultado final é uma **lista de objetos `Purchase`**, que pode ser usada no código da aplicação.

O #RowMapper é uma interface funcional usada pelo JdbcTemplate para converter linhas do ResultSet em objetos Java. Ele recebe uma linha do ResultSet, extrai as colunas e retorna uma instância da classe correspondente.

**ATENÇÃO**: este processo não é um ORM(Object-Relational Mapping), mas sim uma abordagem manual de mapeamento de resultados do banco para objetos Java.

Um ORM (como Hibernate, JPA, Spring Data JPA), faz mais do que apenas mapear linhas de um banco de dados para objetos Java. Ele abstraí a interação com o banco de dados fornecendo recursos como:
- Geração automática de SQL;
- Gerenciamento de transações;
- Cache de objetos;
- Relacionamentos entre entidades;
- Mapeamento declarativo via anotações (@Entity, @OneToMany, etc.)

Uma vez que você tem os métodos na classe *repository* e seja capaz de armazenar e recuperar registros no banco de dados, é hora de expor esses métodos por meio de *endpoints*. A listagem a seguir mostra a implementação da classe *controller*.

Adicionar um Logger aos métodos. O Spring Boot fornece ferramentas para registrar mensagens no console usando o framework de logging integrado (como o SLF4J com Logback). 