O **relational model** continua sendo o principal modelo de dados para aplicações comerciais de processamento de dados. Ele conquistou essa posição devido à sua simplicidade, que facilita o trabalho do programador, se comparado a modelo de dados anteriores, como o **network model** ou **hiearchical model**. Manteve essa posição ao longo de meio século incorporando diversos novos recursos e capacidades. Entre essas adições estão funcionalidades **object-relational**, como *complex data types* e *store procedures*, suporte a dados em **XML** e várias ferramentas para lidar com **semi-structured data**.

A independência do **relational model** em relação a estrutura de dados de baixo nível específicas permitiu que ele persistisse mesmo com o surgimento de novas abordagens para armazenamento de dados, incluindo os modernos **column-stores**, que são projetados para **data mining** em larga escala.

Neste capítulo, estudaremos primeiro os fundamentos do *relational model*. Existe uma teoria substancial sobre **relational databases**. 

## 2.1 Structure of Relational Databases
Um banco de dados relacional consiste em uma **coleção de tabelas**, cada uma das quais recebe um nome único. Por exemplo, considera a tabela *instructor* da Figura 2.1, que armazena informações sobre instrutores. A tabela possui quatro cabeçalhos/colunas, sendo elas:
ID
name
dept_name
salary

Cada row (linha) dessa tabela registra informações sobre um instrutor, consistindo no ID, name, dept_name e salary do instrutor.

De maneira similar, a course table da Figura 2.2 armazena informações sobre courses (disciplinas), consistindo de um *course id, title, dept name e credits*, para cada disciplina. Note que cada instructor é identificado pelo valor da coluna ID, enquanto cada course é identificado pelo valor da coluna course id.


