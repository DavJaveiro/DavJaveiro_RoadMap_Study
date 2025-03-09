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

Ao trabalhar com um banco de dados, implementamos todas as funcionalidades relacionadas à camada de persistência em classes que, por convenção, chamamos de repository. 

**Nota:** um repository é uma classe responsável por trabalhar com o banco de dados.