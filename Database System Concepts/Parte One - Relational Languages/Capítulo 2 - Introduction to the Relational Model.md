O **relational model** continua sendo o principal modelo de dados para aplicações comerciais de processamento de dados. Ele conquistou essa posição devido à sua simplicidade, que facilita o trabalho do programador, se comparado a modelo de dados anteriores, como o **network model** ou **hiearchical model**. Manteve essa posição ao longo de meio século incorporando diversos novos recursos e capacidades. Entre essas adições estão funcionalidades **object-relational**, como *complex data types* e *store procedures*, suporte a dados em **XML** e várias ferramentas para lidar com **semi-structured data**.

A independência do **relational model** em relação a estrutura de dados de baixo nível específicas permitiu que ele persistisse mesmo com o surgimento de novas abordagens para armazenamento de dados, incluindo os modernos **column-stores**, que são projetados para **data mining** em larga escala.

Neste capítulo, estudaremos primeiro os fundamentos do *relational model*. Existe uma teoria substancial sobre **relational databases**. 

## 2.1 Structure of Relational Databases
Um banco de dados relacional consiste em uma **coleção de tabelas**, cada uma das quais recebe um nome único. Por exemplo, considera a tabela *instructor* da Figura 2.1, que armazena informações sobre instrutores. A tabela possui quatro cabeçalhos/colunas, sendo elas:
ID
name
dept_name
salary

Cada row (linha) dessa tabela registra informações <span style="background:#b1ffff">sobre um instrutor</span>, consistindo no ID, name, dept_name e salary do instrutor.

De maneira similar, a course table da Figura 2.2 armazena informações sobre courses (disciplinas), consistindo de um *course id, title, dept name e credits*, para cada disciplina. Note que cada instructor é identificado pelo valor da coluna ID, enquanto cada course é identificado pelo valor da coluna course id.
![[Capítulo 2 - Introduction to the Relational Model.png]]

![[Capítulo 2 - Introduction to the Relational Model-1.png]]

A figura 2.3 apresenta uma terceira tabela, *prereq*, que armazena os cursos pré-requisitos para cada curso. A tabela possuí duas colunas, *curse_id e prereq_id*. Cada linha consiste em um par de identificadores de curso, de modo que o segundo curso seja um pré-requisito para o primeiro curso. Assim, uma linha na tabela *prereq* indica que dois cursos estão relacionados no sentido de que um curso é um pré-requesito para o outro. Como outro exemplo, ao considerarmos a tabela instructor, uma linha na tabela pode ser interpretada como representando o relacionamento.

Em geral, uma linha em uma tabela representa um relacionamento entre um conjunto de valores. Como uma tabela é uma coleção de tais relacionamentos, há uma correspondência próxima entre o conceito de tabela e o conceito matemático de relação, do qual o modelo de dados relacional recebe seu nome. Em terminologia matemática, uma *tuple* é simplesmente uma sequência (ou lista) de valores. Um relacionamento entre n-valores é representado matematicamente por um *n-tuple* valores, ou seja, uma tuple com n valres, que corresponde a uma linha em uma tabela.

Assim, no modelo relacional, o termo *relation* é usado para se referir a uma **tabela**, enquanto o termo *tuple* é usado para se referir a uma **linha**. Da mesma forma, o termo *attribute* se refere a uma **coluna** de uma tabela.

A relação *instructor* possui quatro *atributos:* ID, name, dept name e salary. Utilizamos o termo *relation instance* para nos referir a uma instância específica de uma relação, ou seja, contendo um conjunto específico de linhas. A instância de *instructor* mostrada na figura 2.1, possui 12 *tuples* correspondentes a 12 instrutores. 

Neste capítulo, utilizaremos diversas relações para ilustrar os diversos conceitos que fundamentam o modelo de dados relacional. Essas relações representam parte de uma universidade. Para simplificar a apresentação, excluímos muitos dos dados que um bancos de dados universitário real conteria. Discutiremos os critérios para a adequação das estruturas relacionais em detalhes no Capítulo 6 e no Capítulo 7.

A ordem em que as *tuples* aparecem em uma relação é irrelevante, pois uma relação é um conjunto de *tuples*. Assim, não importa se as *tuples* de uma relação estão listadas em ordem classificatória, ou estão desordenadas. As relações serão as mesmas, já que ambas possuem o mesmo conjunto de *tuples*. Para facilitar a exposição, geralmente mostramos as relações ordenadas pelo primeiro atributo.

Para cada atributo de uma relação, há um conjunto de valores permitidos, chamado *domain* daquele atributo. Assim, o *domain* do atributo *salary* da relação *instructor* é um conjunto de todos os valores salariais possíveis, enquanto o *domain* do atributo *name* é o conjunto de todos os possíveis nomes de instrutores.

**Resumindo**
- **Tuple:** é uma linha em uma tabela relacional. Representa um conjunto ordenado de valores que descrevem uma única entrada ou instância.
- **Domínio:** é o conjunto de valores permitidos para um atributo específico de uma tabela. Por exemplo, o domínio do atributo *salário* pode ser qualquer valor numérico.
- **Relational:** refere-se ao modelo relacional, onde os dados são organizados em tabelas (ou relações) formadas por linhas (tuples) e colunas attributes.
- **Attribute**: é uma coluna em uma tabela, representando uma característica ou propriedade dos dados. Por exemplo, *ID* e *Nome* podem ser atributos de uma tabela chamada *instructor*.

Exigimos que, para todas as relações *r*, os *domínios* de todos os atributos de *r* sejam atômicos.

Um domínio é atômico se os elementos do domínio forem considerados unidades indivisíveis.

Por exemplo, suponha que a tabela *instructor* tivesse um atributo *phone_number*, que pode armazenar um conjunto de números de telefone do professor. Nesse caso, o domínio do atributo número de telefone não seria atômico, pois um do seus elementos é um conjunto de números, com várias partes internas (os próprios números individuais).

O ponto mais importante aqui não é o que o domínio é por si só, mas como usamos esses elementos na base de dados.

Agora, suponha que o atributo de número de telefone armazene apenas um número por vez. Mesmo assim, se dividirmos esse valor em código do país, código de área e número local, então estamos tratando o valor como **não atômico**.

Se, por outro lado, tratarmos cada número de telefone <span style="background:#fff88f">como uma unidade indivisíve</span>l, então o atributo terá, sim, um domínio atômico.

O valor nulo é um valor especial que indica que o valor é desconhecido ou não existe. Por exemplo, suponha que, como no exemplo anterior, tenhamos o atributo número de telefone na relação de professores. Pode ser que o professor não tenha telefone, ou que o número seja confidencial. Nesses casos, precisamos usar o valor nulo para indicar que o valor é desconhecido ou inexistente.

Mais adiante, veremos que os valores nulos causam **diversas dificuldades** ao acessar ou atualizar a base de dados, e por isso, **devem ser evitados sempre que possível**. Vamos assumir inicialmente que os valores nulos não existem, e na Seção 3.6, será descrito como os nulos afetam as operações.

A estrutura relativamente rígida das relações traz várias vantagens práticas importantes no **armazenamento** e **no processamento de dados**, como veremos.
Essa estrutura rígida funciona bem para aplicações bem definidas e relativamente estáticas. Porém, ela não é tão adequada para aplicações em que não só os dados, mas também os tipos e a estrutura desses dados mudam com o tempo.

Uma empresa moderna precisa encontrar **equilíbrio** entre a eficiência dos dados estruturados e aquelas situações onde uma **estrutura pré-definida se torna uma limitação**.

## 2.2 Database Schema
Quando falamos de um banco de dados, devemos diferenciar entre o **esquema do banco de dados**, que é uma captura instantânea dos dados no banco em um momento específico.

O conceito de uma **relação** corresponde à noção de uma **variável** em linguagens de programação, enquanto o conceito de um **esquema de relação** corresponde à ideia de **definição de tipo** em linguagens de programação.

De modo geral, um esquema de relação consiste em uma lista de **atributos** e seus respectivos **domínios**. Não nos preocuparemos com a definição precisa do domínio de cada atributo até discutirmos a linguagem SQL no capítulo 3.

O conceito de uma **instância de relação** corresponde à noção de valor de uma variável em linguagens de programação. O valor de uma determinada variável pode mudar com o tempo; similarmente, o conteúdo de uma instância de relação pode mudar ao longo do tempo conforme a relação é atualizada.

Em contraste, o **esquema** de uma relação geralmente não muda.

Embora seja importante compreender a diferença entre um **esquema de relação** e uma **instância de relação**, frequentemente usamos o mesmo nome, como *instructor*, para nos referir tanto ao esquema quanto à instância. Quando necessário, fazemos referência explícita ao esquema ou à instância. Por exemplo, *o esquema instrutor* ou *uma instância da relação instrutor*. No entanto, quando estiver claro se estamos nos referindo ao esquema ou à instância, simplesmente utilizamos o nome da relação.

- O **database schema** é o design lógico do banco de dados (estrutura), enquanto o **database instance** é o estado atual dos dados armazenados em um momento específico.

- Um *relation* em banco de dados é como uma variável em programação, e o *relation schema* é como uma definição de tipo. Geralmente, o *schema* inclui uma lista de atributos e seus domínios. 

- Uma *relation instance* é como o valor de uma variável. Esse valor pode mudar ao longo do tempo conforme os dados são atualizados, enquanto o *schema* geralmente permanece fixo.

Considere a relação *department* da Figura 2.5. O esquema para essa relação é: 
**department (dept_name, building, budget)**

Note que o atributo *dept_name* aparece tanto no esquema de *intructor* quanto no esquema de *department*. Essa duplicação não é uma coincidência. Na verdade, utilizar atributos comuns em esquemas de relações é uma forma de relacionar *tuplas de relações distintas.*

Por exemplo, suponha que desejamos encontrar as informações sobre todos os *instructors* que trabalham no prédio **Watson**. Primeiro, consultamos a relação **department** para encontrar os *dept_name* de todos os departamentos localizados no Watson. Em seguida, para cada um desses departamentos, consultamos a *instructor relation* para encontrar as informações sobre o *instructor* associado ao respectivo *dept_name*.

Cada **course** em uma universidade pode ser oferecido várias vezes, em diferentes semestres, ou até mesmo dentro de um mesmo semestre. Precisamos de uma relação para descrever cada oferta individual, ou *section* da disciplina. O esquema é:
*section (course_id, sec_id, semester, year, building, room_number, time_slot_id)*.

Precisamos de uma relação para descrever a associação entre instrutores e as seções das disciplinas que eles ministram. O esquema da relação que descreve essa associação é:
*teaches (ID, course_id, sec_id, semester, year)*

Como podemos imaginar, há muitas outras relations mantidas em um banco de dados real de universidade. Além das *relations* que já listamos *_instructor, department, course, section, prereq e teaches_*. Utilizamos as seguintes relations neste texto:
- student (ID, name, dept_name, tot_cred);
- advisor (s_ID, i_ID);
- takes (id, course_id, semester, year, grade).

## 2.3 Keys
Devemos ter uma forma de especificar como as tuplas dentro de uma terminada relação são distinguidas. 
Isso é expresso em termos de seus atributos. Ou seja, os valores dos atributos de uma tupla devem ser tais que permitam identificá-la de forma única. Em outras palavras, não é permitido que duas tuplas em uma mesma relação tenham exatamente o mesmo valor para os atributos.

Uma superchave *superkey* é um conjunto de um ou mais atributos que, tomados em conjunto, nos permitem identificar de maneira única uma tupla na relação.
Por exemplo, o atributo #id da relação *instructor* é suficiente para distinguir uma tupla de instrutor de outra. Portanto, #ID é uma superchave.
Já o atributo #name da relação #instructor, por outro lado, <span style="background:#d4b106">não é uma superchave</span>, pois vários instrutores podem ter o mesmo nome.

#tupla - uma tupla é simplesmente uma linha de uma tabela.

Formalmente, seja R o conjunto de atributos no esquema da relação r. Se dissermos que um suboconjunto K de R é uma superchave para r, estamos restringindo a análise a instâncias da relação r nas quais nenhuma duas tuplas distintas possuem os mesmo valores em todos os atributos de K.
Ou seja, se **t₁** e **t₂** pertencem a **r** e **t₁ ≠ t₂**, então **t₁.K ≠ t₂.K**.

Uma superchave pode conter atributos redundantes. Por exemplo, a combinação de ID e Name é uma superchave para a relação *instructor*. Se **K** é uma superchave, então qualquer superconjunto de K também é uma superchave.

Frequentemente, estamos interessados em superchaves nas quais nenhum subconjunto próprio também seja uma superchave.

Essas superchaves mínimas são chamadas de **chaves candidatadas *candidate keys.***

É possível que vários conjuntos distintos de atributos possam funcionar como chaves candidatas.

Suponhamos que a combinação de **name** e **dept_name** seja suficiente para distinguir os membros da relação **instructor**.

Nesse caso, tanto *{ID}* quanto *{name, dept_name}* são chaves candidatas.

Embora os atributos **ID** e **name** juntos consigam distinguir as tuplas de **instructor**, a combinação de id e name não forma uma chave candidata, pois o atributo **ID** sozinho já é uma chave candidata.

Usaremos o termo **chave primária** para denotar a chave candidata escolhida pelo projetista do banco de dados como o meio principal de identificar tuplas dentro de uma relação.

Uma chave (seja ela primária, candidata ou superchave) é uma propriedade da relação como um todo, e não de tuplas individuais.

Qualquer par de tuplas individuais na relação <span style="background:#d4b106">está proibido de ter</span>, ao mesmo tempo, o mesmo valor nos atributos da chave.

Uma chave (seja ela primária, candidata ou superchave) é uma propriedade da relação como um todo, e não de tuplas individuais.

Qualquer par de tuplas individuais na relação está proibido de ter, ao mesmo tempo, o mesmo valor nos atributos da chave.

A designação de uma chave representa uma restrição no modelo do mundo real que está sendo representado.
Por isso, as chaves primárias também são chamadas de **restrições de chave primária.**

É comum listar os atributos da chave primária de um esquema de relação antes dos demais atributos; por exemplo, o atributo *dept_name* da relação *department* é listado primeiro, já que ele é a chave primária. Os atributos da chave primária também são sublinhados.
Considere a relação *classroom:*
```
classroom(**building**, **room_number**, capacity)
```
Aqui, a **chave primária** é composta por dois atributos, building e room_number, que são sublinhados para indicar que fazem parte da chave primária. Nenhum desses atributos, isoladamente, pode identificar uma sala de aula de forma única, mas juntos eles  a identificam unicamente.

Consideramos também a relação *time_slot:*
time_slot(**time_slot_id**, day, start_time, end_time).

Chaves primárias devem ser escolhidas com cuidado. Como já mencionado, o nome de uma pessoa não é suficiente, pois pode haver muitas pessoas com o mesmo nome.
Nos Estados Unidos, o atributo social security number (número da seguridade social) de uma pessoa seria uma chave candidata (*candidate key*).

Como pessoas de fora dos EUA geralmente não possuem esse número, empresas internacionais precisam gerar seus próprios identificadores únicos.
Uma alternativa é usar alguma combinação única de outros atributos como chave.

A chave primária deve ser escolhida de forma que seus valores nunca mudem ou mudem muito raramente.
Por exemplo, o campo endereço de uma pessoa não deve fazer parte da chave primária, pois é algo que provavelmente poderá altarar-se.

Identificadores únicos gerados por empresas geralmente também não mudam, a menos que duas empresas se fundam; nesse caso, o mesmo identificador pode ter sido atribuído por ambas, e pode ser necessária uma realocação de identificadores para garantir a unicidade.

A Figura 2.8 mostra o conjunto completo de relações que usamos em nosso **esquema de universidade de exemplo,** com os atributos da chave primária (*primary key*) sublinhados.
