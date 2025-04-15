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

Agora, consideramos outro tipo de restrição sobre o conteúdo das relações, chamada de **foreign-key constraint** (restrição de chave estrangeira). Considere o atributo *dept_name* da relação *instructor*. Não faria sentido que uma tupla em *instructor* tivesse um valor para *dept_name* que não correspondesse a um departamento na relação *department*. Assim, em qualquer instância do banco de dados, dada uma tupla qualquer, digamos Ta, da relação *instructor*, deve haver alguma tupla, digamos t_B, na relação *departament*, tal que o valor do atributo *dept_name* de ta, seja o mesmo que o valor da **primary key** dept_name de t_b.

Imagina que você tem duas tabelas no seu banco de dados:

- Uma chamada **`department`**, com os departamentos da faculdade.
    
- Outra chamada **`instructor`**, com os professores.

Cada professor (na tabela `instructor`) tem um campo chamado `dept_name`, que diz a qual departamento ele pertence.

Agora, pensamos: **não faz sentido ter um professor ligado a um departamento que nem existe.**

É aí que entra a **foreign key** (chave estrangeira).

**O que é uma foreign key?**
É uma regra que diz o seguinte:
"O valor deste campo aqui (na tabela `instructor`) **tem que existir** como chave primária na outra tabela (`department`).

Ou seja, se o professor está no departamento "Ciência da Computação", esse nome **precisa existir** na tabela *(department*).

- Chave estrangeira (foreign key): é um campo que aponta para a chave primária de outra tabela (por exemplo, o *dept_name* na tabela *instructor*).

A *foreign key* garante que os dados entre duas tabelas estejam ligados corretamente. Evita que coloquemos um  professor em um departamento que não existe.

Em uma **foreign-key constraint** (restrição de chave estrangeira), os atributos que estão sendo referenciados **devem ser a chave primária (pramary key)** da tabela que está sendo **referida**. 

Existe uma versão mais geral dessa ideia, chamada de **referential-integrity constraint** (restrição de integridade referencial), que não exige que os atributos referenciados sejam a chave primária. 

Então, resumindo:
- Toda **foreign key** é um tipo de **referential integrity**;
- Mas **nem toda referential integrity** pode ser implementada como **foreign key, porque o campo referenciado pode não ser uma *primary key***.

Hoje em dia, os bancos de dados geralmente **suportam foreign keys**, mas **não suportam constraints te integridade referencial** quando o campo não for uma chave primária.

## 2.4 Schema Diagrams
Um **database schema** (esquema de banco de dados), junto com as **primary key** e **foreign-key constraints**, pode ser representado por meio de **schema diagrams** (diagramas de esquema). 

A figura 2.9 mostra o **schema diagram** da nossa organização universitária. Cada **relation** (relação/tabela) aparece como uma caixa, com o nome da relação no topo (em azul) e os **attributes** listados dentro da caixa.

Os atributos que são **primary key** aparecem sublinhados. As **foreign-key constraints** são representadas por setas que vão dos atributos de chave estrangeira (da **referencing relation**) até a **primary key** da **referenced relation**.

Quando queremos indicar uma **referential integrity constraint** (restrição de integridade referencial) que não é uma **foreign-key constraint**, usamos uma **seta de duas pontas** em vez de uma seta simples.

Na **Figura 2.9**, a linha com **seta de duas pontas** que vai de `time_slot_id` na relação `section` para `time_slot_id` na relação `time_slot` representa essa **referential integrity constraint** de `section.time_slot_id` para `time_slot.time_slot_id`.

Muitos sistemas de banco de dados oferecem ferramentas de design com **interface gráfica** para criar **sechemas diagrams**.

Vamos discutir mais adiante outro tipo de representação visual de esquemas, chamada de **entity-relatyionship diagram** (diagrama de entidade-relacionamento), no Capítulo 6. Apesar de haver algumas semelhanças visuais entre os dois, essas notações são **bastante diferentes** e **não devem ser confundidas.**

![[Capítulo 2 - Introduction to the Relational Model-2.png]]

## 2.5 Relational Query Languages
Uma *query language* é uma linguagem na qual um usuário requisita informações do banco de dados. Essas linguagens geralmente operam em um nível mais alto do que uma linguagem de programação padrão. As *query languages* podem ser categorizadas como *imperative*, *functional* ou *declartive*.

Em uma *imperative query language*, o usuário instrui o sistema a executar uma sequência específica de operações no banco de dados para computar o resultado desejado; tais linguagens geralmente possuem a noção de *state variables* (variáveis de estado), que são atualizadas no decorrer da computação.

Em uma *functional query language*, a computação é expressa como a avaliação de *functions* que podem operar sobre dados no banco de dados ou sobre os resultados de outras *functions*; essas *functions* não tem efeitos colaterais *side-effect free* e não atualizam o estado do programa.

Em uma *declarative query language*, o usuário descreve as informações  desejadas sem fornecer uma sequência específica de passos ou chamadas de *functions* para obtê-las; as informações desejadas são tipicamente descritas utilizando alguma forma de lógica matemática. Cabe ao sistema de banco de dados descobrir como obter essas informações.

Existem várias *query languages* consideradas **puradas:**
- A *relational algebra*, que descrevemos na Seção 2.6, é uma *functional query language*. A relational algebra forma a base teórica da SQL query language;
- O *tuple relational calculus* e o *domain relational calculus*, que descrevemos no Capítulo 27, são declarative.

Essas _query languages_ são concisas e formais, carecendo do _syntactic sugar_ das linguagens comerciais, mas ilustram as técnicas fundamentais para extração de dados do banco de dados.

As _query languages_ usadas na prática, como a _SQL query language_, incluem elementos das abordagens _imperative_, _functional_ e _declarative_. Estudamos a amplamente utilizada _query language_ SQL do Capítulo 3 ao Capítulo 5. 

## The Relational Algebra
A álgebra relacional consiste em um conjunto de operações que recebem uma ou duas relações como entrada e produzem uma nova relação como resultado.

Algumas dessas operações, como as operações **select**, **project** e **rename**, são chamadas de operações unárias porque operam sobre uma única relação. As outras operações, como **union**, **cartsian product** e **set difference**, operam sobre pares de relações e, portanto, são chamadas de operações binárias.

Embora as operações de álgebra relacional formem a base para a amplamente utilizada linguagem de consulta SQL, os sistemas de bancos de dados não permitem que os usuários escrevam consultas diretamente em álgebra relacional. No entanto, existem implementações da álgebra relacional que foram desenvolvidas para que estudantes possam praticar consultas em álgebra relacional. O site do nosos livro, fornece referências para algumas dessas implementações.

Vale a pena lembrar neste ponto que, como uma relação é um conjunto de tuplas, as relações não podem conter tuplas duplicadas. Na prática, no entanto, as tabelas em sistemas de banco de dados são permitidas conter duplicadas, a menos que uma restrição específica proíba isso. 

### 2.6.1 The Select Operation
A operação **select** seleciona tuplas que satisfazem um predicado dado. Usamos a letra grega minúscula sigma (σ) para denotar a seleção. O predicado aparece como um subscrito de σ. A relação argumento está entre parênteses após o σ. Assim, para selecionar tuplas  da relação **instructor** onde o instrutor pertence ao departamento *Physics*, escrevemos:
<sup>σ</sup>dept_name="Physics"(instructor)

Se a relação *instructor* for como mostrada na Figura 2.1, então a relação resultante da consulta anterior é como mostrada na figura 2.10.

Podemos encontrar todos os instrutores com salário superior a $90.000 escrevendo:
σsalary>90000(instructor)

Em geral, permitimos comparações usando =, ≠, <, ≤, > e >= no predicado da seleção. Além disso, podemos combinar vários predicados em um predicado maior usando os conectivos and or e not. Assim, para encontrar os instrutores do departamento de Física com salário superior a $90.000, escrevemos:
*σdept name =“Physics” ∧ salary>90000 (instructor)*

O predicado de seleção pode incluir comparações entre dois atributos. Para ilustrar, considere a relação **department**. Para encontrar todos os departamentos cujo nome seja igual ao nome de seu prédio, podemos escrever:
**σdept name =building(department)**

### 2.6.2 The Project Operation
Suponha que desejamos listar o ID, o nome e o salário de todos os instrutores, mas não nos importamos com o *dept_name*. A operação *project* nos permite produzir essa relação. A operação *project* é uma operação unária que retorna sua relação argumento, com certos atributos omitidos. Como uma relação é um conjunto, quaisquer linhas duplicadas são eliminadas. A projeção é denotada pela letra grega maiúscula pi. Listamos aqueles atributos que desejamos que apareçam no resultado como um subscrito de pi. A relação argumento segue entre parênteses. Escrevemos a consulta para produzir tal lista como:
**ΠID, name, salary(instructor)**

### 2.6.3 Composition of Relational Operations
O fato de que o resultado de uma operação relacional ser, por si só, uma relação é importante. Considere a consulta mais complicada: "Encontre os nomes de todos os instrutores no departamento de Física." Escrevemos:
Πname (σdept name =“Physics” (instructor))
Observe que, em vez de fornecer o nome de uma relação como argumento da operação de projeção, fornecemos uma expressão que é avaliada como uma relação.

Em geral, como o resultado de uma operação da álgebra relacional é do mesmo tipo (relação) que suas entradas, as operações da álgebra relacional podem ser compostas em uma **expressão da álgebra relacional**. Compor operações da álgebra relacional em expressões é semelhante a compor operações aritméticas (como +, -, * e /) em expressões aritméticas.

### 2.6.4 The Cartesian-Product Operation
A operação de **produto cartesiano**, denotada por um sinal de cruz (X), permite que combinemos informações de quaisquer duas relações. Escrevemos o produto cartesiano das relações **r1** e **r2** como **r1 x r2**. 

O produto cartesiano de relações de banco de dados difere ligeiramente em sua definição do produto cartesiano matemático de conjuntos. Em vez de r1 x r2 **produzir pares (t1 e t2)** de tuplas de r1 e r2, a álgebra relacional concatena t1 e t2 em uma única tupla, como mostrado na Figura 2.12.

Como o mesmo nome de atributo pode aparecer nos esquemas de ambos r1 e r2, precisamos criar um esquema de nomenclatura para distinguir entre esses atributos. Fazemos isso aqui anexando ao atributo o nome da relação de onde o atributo originalmente veio. Por exemplo, o esquema de relação para **r = instructor x teaches** é:
*(instructor.ID, instructor.name, instructor.dept name, instructor.salary, teaches.ID, teaches.course id, teaches.sec id, teaches.semester, teaches.year)*

Com esse esquema, podemos distinguir *instructor.ID* de *teaches.ID*. Para os atributos que aparecem em apenas um dos dois esquemas, geralmente omitimos o prefixo com o nome da relação. Essa simplificação não causa ambiguidade. Podemos então escrever o esquema da relação para **r** como:

*(instructor.ID, name, dept name, salary,
teaches.ID, course id, sec id, semester, year)*

Essa convenção de nomenclatura exige que as relações que são argumentos da operação de produto cartesiano tenham nomes distintos. Esse requisito pode causar problemas em alguns casos, como quando é desejado o produto cartesiano de uma relação com ela mesma. Um problema semelhante surge se usarmos o resultado de uma expressão de álgebra relacional em um produto cartesiano, pois precisaremos de um nome para a relação para poder nos referir aos seus atributos. Na seção 2.6.8, veremos como evitar esses problemas usando a operação de **rename**.

Agora que conhecemos o esquema da relação para **r = instructor x teaches**, que tuplas aparecem em **r**? Como podemos suspeitar, construímos uma tupla de **r** a partir de cada par possível de tuplas: uma relação **instructor** e outra da relação **teaches**. Assim, **r** é uma relação grande, como podemos ver na figura 2.12, que inclui apenas uma parte das tuplas que compõem **r**.

Suponha que tenhamos **n1** tuplas em **instructor** e **n2** tuplas em **teaches**. Então, há **n1 * n2** maneiras de escolher um par de tuplas - uma tupla de cada relação; portanto, há **n1 * n2** tuplas em **r**. Em particular, para o nosso exemplo, para algumas tuplas **t** em **r**, pode ocorrer que os dois valores de ID, **instructor.ID** e **teaches.ID**, sejam diferentes.

Em geral, se tivermos relação **r1(R1) e r2(R2)**, então *r1 x r2* é uma relação r(R) cujo esquema R é a concatenação dos esquemas R1 e R2. A relação contém todas as tuplas **t** para as quais existe uma tupla t1 em r1 e uma tupla t2 em r2, de modo que t e t1 tem os mesmo valores nos atributos de R1 e t e t2 tem os mesmos valores nos atributos de R2.

### 2.6.5 The Join Operation
Suponha que desejamos encontrar informações sobre todos os instrutores, juntamente com o **course_id** de todos os cursos que eles lecionaram. Precisamos das informações tanto na relação **instructor** quanto na relação **teaches** para calcular o resultado desejado. O produto cartesiano de **instrutor** e **teaches** de fato reúne informações de ambas as relações, mas, infelizmente, o produto cartesiano associa cada instrutor a todos os cursos que foram ministrados, independentemente de esse instrutor ter ministrado ou não esse curso.

Como a operação de produto cartesiano associa cada tupla de **instructor** a cada tupla de **teaches**, sabemos que, se um instrutor ministrou um curso (conforme registrado na relação **teaches**), então existe alguma tupla em **instructor x teaches** que contém o nome do instrutor e satisfaz *instructor.ID = teaches.ID*. Portanto, se escrevermos:

σinstructor.ID=teaches.ID(instructor × teaches)

obteremos apenas aquelas tuplas de **instructor x teaches** que se referem a instrutores e aos cursos que eles lecioanram.

