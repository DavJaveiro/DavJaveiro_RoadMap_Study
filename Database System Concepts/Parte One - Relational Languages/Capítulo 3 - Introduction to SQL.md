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
- **foreign key (Ak, Ak2, ..., Akn) references** s: 