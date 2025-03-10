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


