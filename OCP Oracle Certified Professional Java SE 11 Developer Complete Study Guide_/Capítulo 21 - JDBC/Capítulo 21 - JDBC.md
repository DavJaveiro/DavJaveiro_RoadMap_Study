JDBC significa Java Database Connectivity (Conectividade de Banco de Dados em Java). Este capítulo introduz aos conceitos básicos de acesso a banco de dados a partir do Java. Abordaremos as principais interfaces para conectar, executar consultas e processar os resultados. 

Se você é novo no JDBC, observe que este capítulo cobre apenas os fundamentos do JDBC e o trabalho com banco de dados. O conteúdo é o suficiente para o exame. 

## Introducing Relational Databases and SQL
Dados são informações. Um dado é um único fato, como seu primeiro nome. Um banco de dados é uma coleção organizada de dados. No mundo real, um arquivo físico pode ser considerado um tipo de banco de dados. Ele contém pastas, cada uma das quais guarda folhas de papel. As pastas são organizadas de alguma forma, frequentemente em ordem alfabética. Cada folha de papel é como um dado. Da mesma forma, as pastas em nosso computador funcionam como um banco de dados. As pastas fornecem uma organização, e cada arquivo é um dado.

Um **banco de dados relacional** é um banco de dados organizados em tabelas, que consistem em linhas e colunas. Podemos pensar em uma tabela como uma planilha. Existem duas maneiras principais de acessar um banco de dados relacional a partir do Java:
1. #JDBC (Java Database Connectivity): acessa os dados como linhas e colunas. O JDBC é a API abordada neste capítulo;
2. #JPA (Java Persistence API): acessa os dados por meio de objetos Java utilizando um conceito chamado mapeamento objeto-relacional ORM. A ideia é que a gente não precisa escrever tanto código e os nossos dados estejam disponíveis como objetos Java. 

Um banco de dados relacional é acessado por meio da **Linguagem de Consulta Estruturada** #SQL. O SQL é uma linguagem de programação usada para interagir com os registros do banco de dados. O SQL é uma linguagem de programação usada para interagir com os registros do banco de dados. O JDBC funciona enviando um comando SQL para o banco de dados e, em seguida, processando a resposta.

Além dos bancos de dados relacionais, existem outro tipo de banco de dados chamado **banco de dados NoSQL**. Esse tipo é usado para banco de dados que armazenam seus dados em um formato diferente de tabelas, como pares chave/valor, armazenamento de documentos e bancos de dados baseados em grafos. O NoSQL também está fora do escopo do exame.

Nas próximas seções, apresentaremos um pequeno banco de dados relacional que usaremos para os exemplos neste capítulo e apresentaremos o SQL necessário para acessá-lo. 

**ESCOLHENDO O SOFTWARE DE BANCO DE DADOS**  
Em todos os outros capítulos deste livro, você precisa escrever código e experimentar muitos exemplos. Este capítulo é diferente. Ainda é interessante tentar os exemplos, mas provavelmente você pode acertar as questões de JDBC no exame apenas lendo este capítulo e dominando as perguntas de revisão.

Neste livro, usaremos o **Derby** ([http://db.apache.org/derby](http://db.apache.org/derby) ) na maioria dos exemplos. É um banco de dados pequeno e baseado em memória. Na verdade, você só precisa de um único arquivo JAR para executá-lo. Embora o download seja muito fácil, ainda fornecemos instruções sobre o que fazer. Elas estão vinculadas na página do livro:  
[www.selikoff.net/ocp11-2](http://www.selikoff.net/ocp11-2)

Também existem bancos de dados autônomos que você pode escolher se quiser instalar um banco de dados completo. Gostamos do **MySQL** ([www.mysql.com](http://www.mysql.com/) ) ou do **PostgreSQL** ([www.postgresql.org](http://www.postgresql.org/) ), ambos são de código aberto e existem há mais de 20 anos.

Embora os principais bancos de dados tenham muitas semelhanças, eles possuem diferenças importantes e recursos avançados. Escolher o banco de dados correto para uso no seu trabalho é uma decisão importante que exige bastante pesquisa. Para o exame, qualquer banco de dados serve para prática.

Existem muitos tutoriais para instalar e começar a usar qualquer um desses. Configurar um banco de dados está além do escopo deste livro e do exame, mas fique à vontade para fazer perguntas na seção de banco de dados/JDBC no CodeRanch. Quem sabe você até receba uma resposta dos autores.

**IDENTIFICANDO A ESTRUTURA DE UM BANCO DE DADOS RELACIONAL**
O Nosso banco de dados de exemplo possui duas tabelas. Uma delas contém uma linha para cada espécie presente em nosso zoológico. A outra contém uma linha para cada animal. Essas duas tabelas estão relacionadas entre si porque um animal pertence a uma espécie. Essas relações são o motivo pelo qual esse tipo de banco de dados é chamado de **banco de dados relacional**. A figura 21.1 mostra a estrutura do nosso banco de dados.

# Database: Zoo

## Table: exhibits
| id  | name             | num_acres |
|-----|-----------------|-----------|
| 1   | African Elephant | 7.5       |
| 2   | Zebra           | 1.2       |
## Table: names
| id  | species_id | name  |
|-----|-----------|-------|
| 1   | 1         | Elsa  |
| 2   | 2         | Zelda |
| 3   | 1         | Ester |
| 4   | 1         | Eddie |
| 5   | 2         | Zoe   |
Como podemos observar, temos duas tabelas: uma é chamada de **exhibits** (exposições), e a outra é chamada de **names (nomes)**. Cada tabela possui uma **primary key** (chave primária), que nos dá uma maneira única de referencia cada linha. Logo, dois animais podem ter o mesmo nome, mas não podem ter o mesmo ID.

A *primary key* consiste em apenas uma coluna. Em algumas situações, ela pode ser uma combinação de colunas, conhecida como #compound_key (chave composta). Por exemplo, um **student identifier** e o ano podem formar uma **compound key**.

---
Configuração do Derby
Claro! Aqui está o passo a passo completo para configurar o Derby no modo embutido (Embedded), incluindo a configuração do **CLASSPATH** e a utilização do **IJ** para executar comandos SQL no banco de dados:

### Passo 1: Baixar e Instalar o Apache Derby

1. Baixe a versão do Apache Derby (já que você mencionou a versão `10.17.1.0`).
2. Extraia o conteúdo para o diretório desejado. No seu caso, o diretório é `C:\db-derby-10.17.1.0-bin`.

### Passo 2: Configurar a variável de ambiente `DERBY_HOME`

O Apache Derby precisa saber onde está instalado, e isso é feito configurando a variável `DERBY_HOME`.

1. **Abra o Prompt de Comando**.
    
2. Defina a variável `DERBY_HOME` para o diretório onde o Derby está instalado:
    
    ```bash
    set DERBY_HOME=C:\db-derby-10.17.1.0-bin
    ```
    

### Passo 3: Configurar o `CLASSPATH`

1. No **Prompt de Comando**, defina o `CLASSPATH` para incluir os arquivos `.jar` necessários para o Derby funcionar corretamente. Execute o seguinte comando:
    
    ```bash
    set CLASSPATH=%DERBY_HOME%\lib\derby.jar;%DERBY_HOME%\lib\derbytools.jar;%DERBY_HOME%\lib\derbyoptionaltools.jar;%DERBY_HOME%\lib\derbyshared.jar;.
    ```
    
    Isso inclui os seguintes arquivos no `CLASSPATH`:
    
    - `derby.jar`: Contém o motor Derby e o driver JDBC embutido.
    - `derbytools.jar`: Ferramentas adicionais, como o **IJ** (Interactive JDBC), que será usado para interagir com o banco de dados.
    - `derbyoptionaltools.jar`: Ferramentas opcionais para operações adicionais.
    - `derbyshared.jar`: Contém arquivos compartilhados do Derby.

### Passo 4: Usar o script `setEmbeddedCP.bat` (opcional)

O Derby vem com um script que configura automaticamente o `CLASSPATH` para o modo embutido. Para usá-lo:

1. **Navegue até o diretório `bin`** onde o Derby foi instalado:
    
    ```bash
    cd C:\db-derby-10.17.1.0-bin\bin
    ```
    
2. Execute o script `setEmbeddedCP.bat` para configurar o ambiente automaticamente:
    
    ```bash
    setEmbeddedCP.bat
    ```
    

### Passo 5: Iniciar o **IJ** (Interactive JDBC)

1. No diretório `bin`, execute o comando `ij` para iniciar o prompt interativo:
    
    ```bash
    ij
    ```
    
    Caso o erro `DERBY_HOME is set incorrectly or derby.jar could not be located` apareça, isso indica que o `DERBY_HOME` e o `CLASSPATH` não estão configurados corretamente. Certifique-se de seguir os passos anteriores.
    

### Passo 6: Conectar ao banco de dados com o **IJ**

1. No prompt do **IJ**, você pode se conectar ao banco de dados. Use o seguinte comando, substituindo `mydb` pelo nome do seu banco de dados:
    
    ```sql
    connect 'jdbc:derby:C:\db-derby-10.17.1.0-bin\mydb;create=true';
    ```
    
    - O `jdbc:derby:` indica que você está usando o Derby.
    - O caminho após `jdbc:derby:` especifica onde o banco de dados será armazenado (ou onde ele já está, se existir).
    - O parâmetro `create=true` cria o banco de dados se ele não existir.

### Passo 7: Executar Comandos SQL no **IJ**

Agora que você está conectado ao banco de dados, você pode executar comandos SQL no prompt do **IJ**.

Exemplo para criar uma tabela:

```sql
create table test_table (id int, name varchar(50));
```

### Passo 8: Fechar o **IJ**

Quando terminar, digite `exit;` para sair do **IJ**:

```sql
exit;
```

### Passo 9: Definir as variáveis permanentemente (opcional)

Se você preferir que as variáveis `DERBY_HOME` e `CLASSPATH` sejam configuradas permanentemente (não precisando definir manualmente toda vez que abrir o Prompt de Comando), siga esses passos:

1. **Clique com o botão direito** em "Este PC" (ou "Meu Computador").
    
2. Selecione **Propriedades** > **Configurações Avançadas do Sistema** > **Variáveis de Ambiente**.
    
3. Em **Variáveis do Sistema**, clique em **Nova...** e adicione as seguintes variáveis:
    
    - Nome da variável: `DERBY_HOME`
        
        - Valor da variável: `C:\db-derby-10.17.1.0-bin`
    - Nome da variável: `CLASSPATH`
        
        - Valor da variável: `%DERBY_HOME%\lib\derby.jar;%DERBY_HOME%\lib\derbytools.jar;%DERBY_HOME%\lib\derbyoptionaltools.jar;%DERBY_HOME%\lib\derbyshared.jar;.`

Após essas alterações, o Derby será configurado automaticamente quando você abrir o Prompt de Comando.

---

### Resumo:

1. **Defina o `DERBY_HOME`** para apontar para o diretório de instalação do Derby.
2. **Configure o `CLASSPATH`** para incluir os arquivos `.jar` necessários.
3. **Use o script `setEmbeddedCP.bat`** para configurar automaticamente o `CLASSPATH`.
4. **Inicie o IJ** e conecte-se ao banco de dados usando o comando `connect`.
5. **Execute comandos SQL** no IJ para interagir com o banco de dados.
6. **Feche o IJ** com `exit;`.
7. **Opcionalmente, defina variáveis permanentemente** através das configurações de variáveis do sistema.



---

## Escrevendo Instruções SQL Básicas
A coisa mais importante que precisamos saber sobre SQL para o exame é que existem quatro tipos de instruções para trabalhar com os dados em tabelas. Elas são conhecidas como CRUD (Create, Read, Update, Delete). As palavras-chave do SQL não correspondem diretamente ao acrônimo CRUD, mas estão relacionadas aos mesmos conceitos. 

Isso é tudo. Não precisamos determinar se as instruções SQL estão corretas. Não é necessário identificar erros de sintaxe em instruções SQL. Não precisamos escrever instruções SQL. Percebe um padrão?

Ao contrário do Java, as palavras-chave não são sensíveis a maiúsculas e minúsculas. Isso significa que #select, #SELECT e #Select são equivalentes. Muitas pessoas usam letras maiúsculas para as palavras-chave do banco de dados, de modo que elas se destaquem. Também é prática comum usar *snake case* (sublinhados para separar "palavras") nos nomes de colunas. Seguiremos essas convenções. 

Assim como os tipos primitivos do Java, o SQL possui vários tipos de dados. A maioria deles é autoexplicativa, como o #INTEGER. Há também o #DECIMAL, que funciona de forma semelhante ao #double no Java. O mais peculiar é o #VARCHAR, que significa *caractere viável* e é semelhante a uma String no Java. A parte *variãvel* significa que o banco de dados deve usar apenas o espaço necessário para armazenar o valor.

Agora é hora de escrever algum código. A Instrução INSERt geralmente é usada para criar uma nova linha em uma tabela; aqui está um exemplo:
```sql
INSERT INTO exhibits VALUES (3, 'African Elephant', 7.9);
```

Se houver duas linhas na tabela antes de este comando, e após rodá-lo com sucesso, haverá três linhas após a execução. 

A instrução INSERT lista os valores que desejamos inserir. Por padrão, ela usa a mesma ordem em que as colunas foram definidas, logo, se não especificarmos explicitamente os nomes das colunas, o banco de dados assume que os valores fornecidos na cláusula #VALUES estão na mesma ordem em que as colunas foram definidas na tabela. 

Dados do tipo string são delimitados por 'aspas' simples.


## Introducing the Interfaces of JDBC
Para o exame, precisamos conhecer cinco interfaces-chave do JDBC. Essas interfaces são declaradas no JDK. Isso é semelhante a todas as outras interfaces e classes que já vimos no livro.

No caso do JDBC, as classes concretas vêm do JDBC Driver. Cada banco de dados possui um JAR diferente com essas classes. Por exemplo:
- o JAR do PostgreSQL tem um nome como postgresql-9.4-1201.jdbc4.jar
- O JAR do MySQL tem um nome como mysql-connector-java-5.1.36.ja

Esse JAR do driver contém uma implementação dessas interfaces-chave, além de várias outras interfaces. O ponto principal é que as implementações fornecidas sabem como se comunicar com um banco de dados. Existem também diferentes tipos de drivers; 

A Figura 21.2 mostra as cinco interfaces-chave que precisamos conhecer. Ela também indica que a implementação é fornecida por um JAR de driver imaginário chamado Foo. Eles astutamente incluem um nome Foo em todas as classes.

**JDBC Interfaces e Implementações**
Driver - FooDriver
Connection - FooConnection
PreparedStatement - FooPreparedStatement
CallableStatement - FooCallableStatement
ResultSet - FooResultSet

Não informamos os nomes das classes de implementação em nenhum banco de dados real. O ponto principal é que não precisamos saber. Com o JDBC, usamos apenas as interfaces no nosso código e nunca as classes de implementação diretamente.

O que essas cinco interfaces fazem? Em um nível muito alto, temos o seguinte:
#Driver - estabelece uma conexão com o banco de dados;
#Connection - envia comandos para o banco de dados;
#PreparedStatement - executa uma consulta SQL;
#CallableStatement - executa comandos armazenados no banco de dados (como procedures);
#ResultSet: lê os resultados de uma consulta. 

Todas as interfaces de banco de dados estão no pacote java.sql, então frequentemente omitiremos as importações.

No próximo exemplo, mostraremos como o código JDBC se parece de ponta a ponta. 

## Conectando-se a um Banco de Dados
O primeiro passo para fazer qualquer coisa com um banco de dados é se conectar a ele. Primeiro, mostraremos como construir a URL JDBC. Em seguida, mostraremos como usá-la para obter uma Connection com o banco de dados.

---
## Construindo uma URL JDBC
Para acessar um banco de dados, precisamos conhecer as informações sobre ele. 

Ao contrário das URLs da web, uma URL JDBC possui uma variedade de formatos. No entanto, todos eles têm três partes em comum, conforme mostrado na figura 21.3. A primeira parte é sempre a mesma: protocolo jdbc
2. subprotocolo, que é o nome do banco de dados, como Derby, mysql ou postgres;
3. subnome, que segue um formato específico do banco de dados.
Os dois-pontos : separam as três partes

jdbc:postgres://localhost:5432/zoo

O subnome geralmente contém informações sobre o banco de dados, como a localização e/ou o nome do banco. A sintaxe varia dependendo do banco de dados. 

## Obtendo uma Conexão de Banco de Dados
Existem duas maneiras principais de obter uma #Connection:
1. #DriverManager
2. #DataSource.

O #DriverManager é o que é coberto no exame. Não utilize #DriverManager em código em produção. Um #DataSource possuí mais recursos do que um #DriverManager. Por exemplo, o #DataSource pode gerenciar um pool de conexões ou <span style="background:#d4b106">armazenar as informações de conexão do banco de dados</span> fora da aplicação. 

#Connection - é a interface usada para a manutenção e monitoramento de status de uma sessão de banco de dados. Ela também fornece controle de acesso a dados por meio do uso de bloqueios transacionais (*transaction locking*).

---
**Usando um DataSource**
Em aplicações reais, devemos utilizar um DataSource em vez de DriverManager para obter uma **Connection**. Uma razão para isso é que não há motivo para que precisemos conhecer a senha do banco de dados. É muito melhor se a equipe de banco de dados ou outra equipe puder configurar um data source que possamos referenciar.

A interface **DataSource**, foi introduzida na API de Extensão Padrão JDBC 2.0, é uma forma mais eficiente de conectar-se a uma fonte de dados para realizar ações de manipulação de dados. No JDBC, uma fonte de dados é uma classe que implementa a interface javax.sql.DataSource para conectar-se a um ou mais bancos de dados desejados. O método #getConnection() é sempre usado para configurar essa conexão. 

Um objeto DataSource geralmente é registrado em um serviço de nomes JNDI (Java Naming and Directory Interface). Isso significa que uma aplicação pode recuperar um objeto DataSource pelo nome no serviço 

---

A classe DriverManager está no JDK, pois é uma API que acompanha o Java. Ela utiliza o padrão de projeto #factory, o que significa que chamamos um método estático para obter uma **Connection**, em vez de chamar um construtor diretamente. O padrão factory implica que implica que podemos obter qualquer implementação da interface ao chamar o método.

Para obter uma conexão com o banco de dados, escrevemos o seguinte:
```java
import java.sql.*;
public class TestConnect {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        System.out.println(conn);
    }
}
```

