Neste capítulo, assim como nos Capítulos 4 e 5, estudaremos a linguagem de consulta a banco de dados mais amplamente utilizada: o SQL.

Embora nos refiramos ao SQL como uma *linguagem de consulta*, ele é capaz de muito mais do que apenas consultar um banco de dados. Ele **pode definir a estrutura dos dados, modificar dados no banco e especificar restrições de segurança.**

Não é nossa intenção fornecer um guia completo do uso do SQL. Em vez disso, apresentamos os **principais conceitos e construções fundamentais** da linguagem. Implementações individuais do SQL podem diferir em certos detalhes ou oferecer suporte apenas a um **subconjunto da linguagem completa**. 

## 3.1 Visão Geral da Linguagem de Consulta SQL
A IBM desenvolveu a versão original do SQL, que inicialmente se chamava Sequel, como parte do projeto System R no início da década de 1970. A linguagem evoluiu desde então, e seu nome foi alterado para SQL (Structured Query Language). Atualmente, muitos produtos oferecem suporte à linguagem SQL, que se consolidou claramente como o **padrão das linguagens para bancos de dados relacionais.**

Em 1986, o American National Standards Institute (ANSI) e a International Organization for Standerdization ISO publicaram o primeiro padrão oficial do SQL, chamado SQL-86. 
O ANSI publicou uma versão estendida do padrão em 1989, chamada **SQL-89**. A versão seguinte foi o **SQL-92**, seguida por **SQL:1999**, **SQL:2003**, **SQL:2006**, **SQL:2008**, **SQL:2011** e, mais recentemente, **SQL:2016**

A linguagem SQL possuí várias partes:
- **Data-definition language (DDL) -** a linguagem de definição de dados do SQL fornece comandos para definir *schemas* de relações (tabelas), excluir relações e modificar *schemas* existentes.
- **Data-manipulation language (DML)** - a linguagem de manipulação de dados permite consultar informações no banco de dados, inserir tuplas, remover tuplas e modificar tuplas já existentes.
- **Integridade -** A DDL do SQL inclui comandos para especificar restrições de integridade que os dados armazenados no banco devem obedecer. Atualizações que violam essas restrições são proibidas. 
- **Definição de visões (views) -** A DDL do SQL inclui comando para definir views, que são tabelas virtuais baseadas em consultas.
- **Controle de transações -** O SQL inclui comandos para especificar o início e o fim de transações, permitindo agrupar várias operações como uma única unidade lógica;
- **SQL embutido (Embedded SQL) e SQL dinâmico (Dynamic SQL) -** essas variações definem como instruções SQL podem ser incorporadas dentro de linguagens de programação de uso geral, como C, C++ e Java.
- **Autorização:** A DDL do SQL também fornece comandos para especificar direitos de acesso a relações e views, controlando quem pode consultar ou modificar os dados.

Neste capítulo, apresentamos uma visão geral dos recursos básicos de DML e DDL do SQL. As funcionalidades descritas aqui fazem parte do padrão SQL desde o SQL-92.

No capítulo 4, fornecemos uma cobertura mais detalhada da linguagem de consulta SQL, incluindo:
1) várias expressões de join;
2) views;
3) transações;
4) restrições de integridade;
5) o sistema de tipos, e
6) autorização.

No capítulo 5, abordaremos recursos mais avançados da linguagem SQL, incluindo:
1) mecanismos para permitir o acesos ao SQL a partir de uma linguagem de programação;
2) funções e procedimentos SQL,
3) triggers (gatilhos),
4) consultas recursivas;
5) recursos avançados de agregação, e
6) várias funcionalidades voltadas para análise de dados.

Embora a maioria das implementações de SQL ofereça suporte aos recursos padrão descritos aqui, existem **diferenças entre as implementações**. Muitas delas incluem funcionalidades **não padronizadas** e, ao mesmo tempo, deixam de oferecer suporte a alguns recursos **mais avançados ou mais recentes**.  
Caso você perceba que alguma funcionalidade descrita aqui **não funciona no sistema de banco de dados que você está usando**, consulte a **documentação oficial** desse sistema para descobrir exatamente quais recursos ele suporta.

## 3.2 SQL Data Definition
O conjunto de relações em um banco de dados é especificado usando uma linguagem de definição de dados (DDL).
A #DDL do SQL permite especificar não apenas um conjunto de relações, mas também informações sobre cada relação, incluindo:
- o **schema** de cada relação;
- os tipos de valores associados a cada atributo;
- as restrições de integridade;
- o conjunto de índices que devem ser mantidos para cada relação;
- as informações de segurança e autorização para cada relação;
- a estrutura física de armazenamento em disco para cada relação.
Neste trecho, discutimos a definição básica de schemas e os tipos básicos; a discussão sobre os outros recursos da DDL do SQL será tratada nos Capítulos 4 e 5.

### 3.2.1 Basic Types
O padrão SQL suporta uma variedade de tipos embutidos, incluindo:
- **char(n)**: uma cadeia de caracteres de comprimento fixo com comprimento especificado pelo usuário (n). A forma completa, **character**, pode ser usada como alternativa;
	Exemplo: **CHAR(5)** pode armazenar *abc* como *abc  .*  (com 2 espaços no final).

- **varchar(n)**: uma cadeia de caracteres de comprimento variável com comprimento máximo especificado pelo usuário (n). A forma completa, **character varying**, é equivalente.

- **int**: um número inteiro (um subconjunto finito dos inteiros que depende da máquina). A forma completa, **integer**, é equivalente.

- **smallint:** um número inteiro pequeno (um subconjunto do tipo inteiro que depende da máquina);

- **numeric(p, d)**: um número de ponto fixo com precisão especificada pelo usuário. O número consiste de p dígitos (mais um sinal), e d dos p dígitos estão à direita do ponto decimal. Assim,  **numeric(3,1)** permite que 44.5 seja armazenado exatamente, mas nem 444.5, nem 0.32 podem ser armazenados exatamente em um campo desse tipo. Logo, numeric(3, 1) aceitam números com até 2 dígitos antes da vírgula e 1 depois.

- **real, double precision**: números de ponto flutuante e de ponto flutuante de precisão dupla com precisão dependente da máquina.

- **float(n)**: um número de ponto flutuante com precisão de pelo menos n dígitos.

Tipos adicionais são abordados na Seção 4.5.
Cada tipo pode incluir um valor especial chamado **valor nulo**. Um valor nulo indica um valor ausente que pode existir, mas ser desconhecido, ou que pode não existir de forma alguma. Em certos casos, podemos desejar proibir a entrada de valores nulos, como veremos em breve.

O tipo de dado **char** armazena strings de comprimento fixo. Considere, por exemplo, um atributo **A** do tipo **char(10)**. Se armazenarmos a string "Avi" neste atributo, sete espaços serão adicionados à string par torná-la com 10 caracteres de comprimento. Por outro lado, se o atributo B for do tipo **varchar(10)** e armazenarmos "Avi" no atributo **B**, nenhum espaço será adicionado.

Ao comparar dois valores do tipo **char**, se eles forem de comprimentos diferentes, espaços extras são automaticamente adicionados ao valor mais curto  para igualar seus tamanhos antes da comparação. Ao comparar um tipo **char** com um tipo **varchar**, pode-se esperar que espaços extras sejam adicionados ao tipo **varchar** para igualar os comprimentos antes da comparação; entretanto, isso pode ou não ser feito, dependendo do sistema de banco de dados. Como resultado, mesmo que o mesmo valor *Avi* seja armazenado nos atributos A e B, uma comparação A = B pode retornar falso. Recomendamos que sempre utilize o tipo **varchar** em vez do tipo **char** para evitar esses problemas.

O SQL também fornece o tipo **nvarchar** para armazenar dados multilíngues usando a representação Unicode. No entanto, muitos bancos de dados permitem  que o Unicode (na representação UTF-8) seja armazenado até mesmo em tipos **varchar**. 

### 3.2.2 Basic Schema Definition
Definimos uma relação SQL utilizando o comando **create table**. O seguinte comando cria uma tabela **department** no banco de dados:
```sql
create table department (
	dept_name varchar(20),
	building varchar(15),
	budget numeric(12, 2),
	primary key (dept_name));
)
```
A relação criada acima possui três atributos:
- **dept_name**, que é uma cadeia de caracteres com um comprimento máximo de 20;
- **building**, que é uma cadeia de caracteres com um comprimento máximo de 15;
- **budget**, que é um número com 12 dígitos no total, sendo dois deles após o ponto decimal.

O comando **create table** também especifica que o atributo **dept_name** é a **chave primária** da relação **department**.

A forma geral do comando *create table* é:
```sql
create table r(
	A1 D1,
	A2 D2,
	...,
	An Dn,
	(integrity-constraint),
	...,
	(integrity-constraint)
);
```
Onde r é o nome da *relation (relação)*, cada Ai é o nome de um atributo no schema da relação r, e D1 é o domain (domínio) do atributo Ai; ou seja, Di específica o tipo do atributo Ai juntamente com restrições opcionais que limitam o conjunto de valores permitidos para Ai.

O ponto e vírgula mostrado no final dos comandos *create table*, assim como no final de outros comandos SQL ao longo deste capítulo, é opcional em muitas implementações de SQL.

SQL oferece suporte a diversos *integrity constraints* (restrições de integridade). Nesta seção, discutiremos apenas algumas delas:
- **primary keys**: A especificação de *primary key* indica que os atributos Aj1, Aj2, ..., Ajm formam a *primary key* (chave primária) da *relation* (relação). Os atributos da *primary key* devem ser *nonnull* (não nulos) e *uniqueu (únicos)*; ou seja, nenhuma *tuple (tupla)* pode ter um valor nulo para um atributo da *primary key*, e nenhuma dupla de *tuples* na *relation* pode ter os mesmos valores em todos os atributos da *primary key*. Embora a especificação de *primary key* seja opcional, geralmente é uma boa prática definir uma primary key para cada *relation*.
- **foreign key (Ak1, Ak2, ..., Akn) referências s:** A especificação da chave estrangeira diz que os valores dos atributos (Ak1, Ak2) para qualquer tupla na relação devem corresponder aos valores dos atributos da chave primária de alguma tupla na relação s. 
A figura 3.1 apresenta uma definição parcial em SQL DDL do banco de dados universitário que usamos no texto. A definição da tabela course contém a declaração *foreign key* (dept_name) references department. Sem essa restrição, seria possível que um curso especificasse um nome de departamento inexistente. 

Alguns sistemas de bancos de dados, incluindo o MySQL, exigem uma sintaxe alternativa: "foreign key (dept_name) references department(dept_name)", onde os atributos referenciados na tabela referenciada são listados explicitamente.

**not null:** a restrição **not null** em um atributo especifica que o valor nulo não é permitido para esse atributo; em outras palavras, a restrição exclui o valor nulo do domínio desse atributo. Por exemplo, na Figura 3.1, a restrição **not null** no atributo **name** da relação **instructor** garante que o nome de um instrutor não pode ser nulo. 

Mais detalhes sobre a restrição de **foreign-key**, bem como sobre outras restrições de integridade que o comando **create table** pode incluir, são fornecidos posteriormente, na seção 4.4. <span style="background:#d4b106">O SQL impede qualquer atualização no banco de dados que viole uma restrição de integridade</span>. Por exemplo, se uma tupla recém-inserida ou modificada em uma relação tiver valores nulos para qualquer atributo da chave primária, ou se a tupla tiver o mesmo valor nos atributos da chave primária que outra tupla na relação, o SQL sinaliza um erro e impede a atualização. Da mesma forma, a inserção de uma tupla em **course** com um valor de **dept_name** que não aparece na relação **department** violaria a restrição de **foreign-key** em **course**, e o SQL impediria que tal inserção ocorresse.

Uma relação recém-criada é inicialmente vazia. A inserção de tuplas em uma relação, sua atualização e sua exclusão são feitas por meio das instruções de manipulação de dados **insert, update e delete.**

Para remover uma relação de um banco de dados SQL, usamos o comando **drop table**. O comando **drop table** exclui todas as informações sobre a relação removida do banco de dados. O comando é:
```sql
drop table r;
```

---
**Chave estrangeira**
Por padrão, a chave estrangeira (foreign key) aponta para a chave primária da tabela referenciada.

A foreign key pode apontar para qualquer coluna que tenha uma restrição *UNIQUE*. Ou seja, não precisa ser obrigatoriamente a chave primária, mas sim uma **coluna única**.

Podemos ter uma chave primária composta, formada por mais de uma coluna. Várias chaves candidatas, mas apenas uma delas pode ser escolhida como chave primária, e as outras podem receber **restrição** *UNIQUE*. 

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
Esse schema está dizendo que a combinação dessas 4 colunas identifica de forma única cada registro da tabela *section*.

![[Capítulo 3 - Introduction to SQL.png]]
**Tratando a relação:**
- Cada **departament** tem um nome, funciona em um prédio e tem um orçcamenot.
- Cada *course*: tem um título, número de créditos, e pertence a um *department (dept_name, como chave estrangeira)*, muitos cursos podem estar em um único departamento (relação muitos-para-um)
## 3.3 Basic Structure of SQL Queries
A estrutura básica de uma consulta SQL <span style="background:#d4b106">consiste em três cláusulas: select, from e where</span>. Uma consulta recebe como entrada as relações listadas na cláusula **from**, opera sore elas conforme especificados nas cláusulas **where** e **select**, e então produz uma relação como resultado. 
Introduzimos a sintaxe do SQL por meio de exemplos e descrevemos a estrutura geral das consultas SQL posteriormente.

### 3.3.1 Queries on a Single Relation
Vamos considerar uma consulta simples usando nosso exemplo da universidade: "Encontre os nomes de todos os instrutores." Os nomes dos instrutores estão presentes na relação *instructor*, então colocamos essa relação na cláusula *from*. O nome do instrutor aparece no atributo *name*, então colocamos isso também na cláusula *select*:
```sql
select name from instructor;
```

O resultado é uma relação consistindo em um único atributo com o título *name*. Se a relação *instructor* for como mostrado na Figura 2.1, então a relação resultante da consulta acima é mostrada na Figura 3.2.

![[Capítulo 3 - Introduction to SQL-1.png]]

Agora, considere outra consulta: "encontre os nomes dos departamentos de todos os instrutores," que pode ser escrita como:
```sql
select dept_name from instructor;
```
Como mais de um instrutor pode pertencer a um departamento, um nome de departamento pode aparecer mais de uma vez na relação *instructor*. O resultado da consulta acima é uma relação contendo os nomes dos departamentos, mostrada na Figura 3.3.

Na definição formal e matemática do modelo relacional, uma relação é um conjunto. Portanto, tuplas duplicadas nunca apareceriam em relações. <span style="background:#d4b106">Na prática, a eliminação de duplicadas é demorada</span>. Por isso, o SQL permite duplicatas em relações de banco de dados, bem como nos resultados de expressões SQL. Assim, a consulta SQL anterior lista cada nome de departamento uma vez para cada tupla em que ele aparece na relação **instructor**. 

No casos em que queremos forçar a eliminação de duplicatas, inserimos a palavra-chave *distinct* após o *select*. Podemos reescrever a consulta anterior como:
```sql
select distinct dept_name from instructor;
```
se quisermos remover as duplicatas. O resultado da consulta acima conteria cada nome de departamento no máximo uma vez.

![[Capítulo 3 - Introduction to SQL-2.png]]

O SQL também nos permite usar a palavra-chave **all** para especificar explicitamente que as duplicatas não são removidas:
```sql
select all dept_name from instructor;
```
Como a retenção de duplicata é o padrão, não usaremos all em nosso exemplos. Para garantir a eliminação de duplicatas nos resultados de nossas consultas de exemplo, usaremos *distinct* sempre que for necessário. 

A cláusula *select* também pode conter expressões aritméticas envolvendo os operadores +, -, * e /, operando em constantes ou atributos de tuplas. Por exemplo, a consulta:
```sql
select ID, name, dept_name, salary * 1.1 from instructor;
```
retorna uma relação que é igual à relação *instructor*, exceto pelo fato de que o atributo *salary* é  multiplicado por 1.1. isso mostra o que aconteceria se déssemos um aumento de 10% a cada instrutor; observe, no entanto, que isso não resulta em nenhuma alteração na relação *instructor*. 

O SQL também fornece tipos de dados especiais, como várias formas do tipo **date**, e permite que várias funções aritméticas operem sobre esses tipos. Discutiremos isso mais detalhadamente na Seção 4.5.1.

A cláusula **where** nos permite selecionar apenas aquelas linhas na relação resultante da cláusula **from** que satisfazem um predicado especificado. Considere a consulta: "Encontre os nomes de todos os instrutores do departamento de Ciência da Computação que têm salário maior que $70.000." Essa consulta pode ser escrita em SQL como:
```sql
select name from instructor where dept_name = 'Computer Science' and salary > 70000;
```
![[Capítulo 3 - Introduction to SQL-3.png]]

```sql
select name
from instructor
where dept_name = ´Comp.sci.' and salary > 70000;
```

O SQL permite o uso dos conectivos lógicos **and**, **or** e **not** nas cláusula *where*. Os operados dos conectivos lógicos podem ser expressões que envolvem os operadores de comparação <, <=, >= e <>. O SQL nos permite usar os operadores de comparação para comparar strings e expressões aritméticas, bem como tipos especiais, como os tipos de data.

Exploraremos outras características dos predicados da cláusula **where** mais adiante neste capítulo.

### 3.3.2 Queries on Multiple Relations
Até agora, nossas consultas de exemplo foram em uma única relação. 

Como exemplo, suponha que queremos responder à consulta "*Recupere os nomes de todos os instrutores, juntamente com os nomes de seus departamentos e o nome do prédio do departamento.*" Analisando o esquema da relação *instructor*, percebemos que podemos obter o nome do departamento a partir do atributo *dept_name*, mas o nome do prédio do departamento está presente no atributo *building* da relação *department*. Para responder à consulta, cada tupla na relação **instructor** deve ser combinada com a tupla na relação  **department** cujo valor de *dept_name* corresponda ao valor de **dept_name** da tupla de **instrutor**.

Em SQL, para responder à consulta acima, listamos as relações que precisam ser acessada na cláusula **from** e especificamos a condição de correspondência na cláusula **where**. A consulta acima pode ser escrita em SQL como:
```sql
select name, instructor.dept_name, building from instructor, department where instructor.dep_name = department.dept_name;
```

 Se as relações *instructor* e *department* forem como mostradas na Figura 2.1 e Figura 2.5, respectivamente, então o resultado dessa consulta é mostrado na Figura 3.5.

Observe que o atributo *dept_name* ocorre em ambas as relações, **instructor e department**, e o nome da relação é usado como prefixo (em *instructor.dept_name*) e *department.dept_name* para deixar claro a qual atributo estamos nos referindo. Em contraste, os atributos **name** e *building* aparecem apenas em uma das relações e, po
rtanto, não precisam ser prefixados pelo nome da relação.

Essa convenção de nomenclatura requer que as relações presentes na cláusula **from** tenham nomes distintos. Essa exigência causa problemas em alguns casos, como quando informações de duas tuplas diferentes na mesma relação precisam ser combinadas. Na seção 3.4.1, veremos como evitar esses problemas usando a operação de renomeação *(rename)*.

Agora consideramos o caso geral de consultas SQL envolvendo múltiplas relações. Como vimos anteriormente, <span style="background:#d4b106">uma consulta SQL pode conter três tipos de cláusulas</span>: a cláusula *select*, a cláusula *from* e a cláusula *where*. O papel de cada cláusula é o seguinte:
- A cláusula *select* é usada para listar os atributos desejados no resultado de uma consulta;
- A cláusula *from* é uma lista das relações a serem acessadas na avaliação da consulta;
- A cláusula *where* é um predicado envolvendo atributos das relações presentes na cláusula *from*.

Uma consulta SQL típica tem a forma:
```sql
select A1, A2,..., An
from ri, r2,...,rm
where P;
```

Cada **A** representa um *attribute*, e cada **r** é uma relação. P é um *predicate*. Se a *where* fore removido, o predicado P será verdadeiro. Embora as clauses devam ser escritas na ordem **select**, **from**, **where**, a maneira mais fácil de entender as operações especificadas pela *query* é considerar as *clauses* na ordem operacional: primeiro **from**, depois **where**, e então **select**. 

A cláusula **from** por si só define um produto cartesiano das relações listadas na cláusula. Ela é definida formalmente em termos de álgebra relacional, mas também pode ser entendida como um processo iterativo que gera tuplas para a relação resultante da cláusula **from**. 

Portanto, quando fazemos:
```sql
SELECT * FROM A, B;
```
Isso gera todas as combinações possíveis entre as linhas da Tabela A e Tabela B:
A1 | B1  
A1 | B2  
A1 | B3  
A2 | B1  
A2 | B2  
A2 | B3  
Esse processo é chamado de produto cartesiano - ele combina cada linha de uma tabela com todas as linhas da outra. 
Sozinha, a cláusula *FROM* com várias tabelas não filtra nada. Precisamos de condições com *where* ou *JOIN ON* para que o resultado faça sentido, especialmente se estiver relacionando dados.

```SQL
SELECT * FROM clientes, pedidos;
```
Neste exemplo, vamos gerar combinações de todos os clientes com todos os pedidos, o que provavelmente não faz sentido. Por isso, é comum fazer:
```sql
SELECT * FROM clientes JOIN pedidos ON clientes.id = pedidos.client_id;
```
para cada tupla t1 na relação r1
    para cada tupla t2 na relação r2
            para cada tupla tm na relação rm
                Concatenar t1, t2, … , tm em uma única tupla t
                Adicionar t à relação resultante

A relação resultante possui todos os atributos de todas as relações presentes na cláusula **from**. Como o mesmo nome de atributo pode aparecer em mais de uma relação, como vimos anteriormente, prefixamos o nome da relação de origem antes do nome do atributo para evitar ambiguidade. Por exemplo, o esquema relacional para o produto cartesiano das relações **instructor** e **teaches** é:
```sql
(instructor.ID, instructor.name, instructor.dept_name, instructor.salary, teaches.ID, teaches.course_id, teaches.sec_id, teaches.semester, teaches.year)
```

Com esse esquema, podemos distinguir **instructorID** de **teaches.ID**. Para os atributos que aparecem em apenas um dos dois esquemas, geralmente omitimos o prefixo do nome da relação. Essa simplificação não causa ambiguidade. Assim, podemos escrever o esquema relacional como:
```sql
instructor.id, name, dep_name, salary, teaches.ID, course_id, sec_id, semester, year
```

O produto cartesiano por si só combina tuplas de **instructor** e **teaches** que não estão relacionadas entre si. Cada tupla em *instructor* é combinada com todas as tuplas em *teaches*, mesmo aquelas que se referem a um instrutor diferente. O resultado pode ser uma relação extremamente grande, e raramente faz sentido criar um produto cartesiano deste tipo.

Em vez disso, o predicado na cláusula *where* é usado para restringir as combinações criadas pelo produto cartesiano apenas àquelas que são significativas para a resposta desejada. Provavelmente, queremos que uma consulta envolvendo *instructor* e *teaches* combina uma tupla específica **t** em *instructor* apenas com aquelas tuplas em **teaches** que se referem ao mesmo instrutor ao qual t se refere. Ou seja, desejamos combinar tuplas de teaches apenas com tuplas de *instructor* que tenham o mesmo valor de ID. A seguinte consulta SQL garante essa condição e retorna o nome do instrutor e os identificadores dos cursos dessas tuplas combinadas:
```sql
select name, course_id
from instructor, teaches
where instructor.ID = teaches.ID;
```

