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
O Nosso banco de dados de exemplo possui duas tabelas. Uma delas contém uma linha para cada espécie presente em nosso zoológico. A outra contém uma linha para cada animal. 