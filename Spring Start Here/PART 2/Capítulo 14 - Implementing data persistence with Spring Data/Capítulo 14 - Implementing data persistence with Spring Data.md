*This chapter covers*
- How Spring Data works;
- Defining Spring Data repositories
- Using Spring Data JDBC to implement a Spring app's persistence layer

Neste capítulo, aprender a usar o Spring Data, um projeto do ecossistema Spring que permite implementar a *persistence layer* de uma aplicação Spring com o **mínimo de esforço**. Como já sabemos, a função principal de um **framework** é fornecer recursos **out-of-the-box** que podem ser integrados diretamente aos apps. Os **frameworks** nos ajudam a economizar tempo e também simplificam o **design** das aplicações.

[[Engenharia de Software - Sommerville/Parte 1 - Introdução à Engenharia de Software/Capítulo 1 - Introdução|Capítulo 1 - Introdução | Engenharia de Software Sommerville]] - As aplicações corporativas não são programadas do zero, mas envolvem um amplo reuso de componentes e programas.

Aprenderemos a criar os *repositories* do app apenas declarando #interfaces - o *framework* se encarregará de fornecer as implementações para essas *interfaces*. Literalmente, habilitaremos a nossa aplicação para trabalhar com um #database sem precisar implementar o *repository* manualmente e com esforço mínimo.

Iniciaremos o capítulo discutindo como o *Spring Data* funciona. Na seção 14.2, veremos como ele se integra a aplicações Spring. Em seguida, na seção 14.3, partiremos para um exemplo prático, onde aprenderemos a usar o **Spring Data JDBC** para implementar uma *persitence layer*.

## 14.1 What Spring Data is
**Nesta seção, discutiremos o que é o Spring Data e por que devemos usar esse projeto para implementar os recursos de persistência em uma aplicação Spring**.

O **Spring Data** é um projeto do ecossistema Spring que simplifica o desenvolvimento da #persistence layer, <span style="background:#d4b106">fornecendo implementações</span> de acordo com a tecnologia de persistência utilizada. Dessa forma, precisamos escrever apenas algumas linhas de código para definir os **repositories** da nossa aplicação Spring.

A figura abaixo apresenta uma representação visual do papel do Spring Data na perspectiva de uma aplicação:
![[Capítulo 14 - Implementing data persistence with Spring Data.png]]

- Spring Data é uma camada de alto nível que simplifica a implementação da persistence unificando as diversas **tecnologias de persistência** através de algumas abstrações.
---
**Off-session**
As *tecnologias de persistência* referem-se a ferramentas, bibliotecas e frameworks que permitem armazenar, acessar e gerenciar dados em aplicações, geralmente em bancos de dados ou outros sistemas de armazenamento. No contexto do *Spring Data*, essas tecnologias são abstraídas para que possamos trabalhar com diferentes formas de persistência usando uma interface comum.

**Exemplos comuns de tecnologias de persistência:**
1. **Spring Data JDBC**: simplifica o acesso a banco de dados relacionais usando JDBC (sem JPA/Hibernate);
2. **Spring Data JPA:** baseado no Jakarta Persistence API (JPA), usa Hibernate ou EclipseLink como implementação para ORM (*Object-Relational Mapping*).
3. **Spring Data MongoDB:** integração com banco de dados NoSQL MongoDB (document-based).
4. **Spring Data Redis:** Persistência em banco de dados Redis (armazenamento chave-valor);
5. **Spring Data Cassandra:** para bancos de dados distribuídos Apache Cassandra (NoSQL column-family);
6. **Spring Data Elasticsearch:** integração com mecanismos de busca/índices Elasticsearch;
7. **Spring Data R2DBC:** acesso reativo a bancos de dados relacionais (alternativa ao JDBC bloqueante), JDBC bloqueante refere-se ao comportamento síncrono e bloqueante do JDBC, o termo bloqueante, refere-se ao fato da #thread que está executando essa operação ficar **bloqueada** até que o banco de dados retorne uma resposta. Durante este período, a thread não pode realizar outras tarefas, pois está aguardando a conclusão da operação.

**Problemas com relação ao JDBC Bloqueante**
Esse comportamento bloqueante traz algumas desvantagens, especialmente em sistemas modernos que exigem alta escalabilidade e eficiência:
1. **Escalabilidade Limitada**
	- Em sistemas com muitas requisições simultâneas, cada requisição geralmente usa uma #thread para acessar o banco de dados;
	- Como as threads ficam bloqueadas durante as operações de I/O (acesso ao banco de dados), é necessário criar muitas threads para lidar com várias requisições concorrentes. 
	- Cada thread consome memória e recursos do sistema, o que pode levar a problemas de desempenho e limitar a capacidade de escalabilidade.

2. **Ineficiência de Recursos**
	- Threads bloqueadas são inativas enquanto esperam as operações, desperdiçando recursos computacionais;
	- Isso torna o sistema menos eficiente, especialmente em cenários de alto volume de requisições.

3. **Experiência do Usuário**
	- Em sistemas web ou APIs, o bloqueio das threads pode aumentar o tempo de resposta, impactando negativamente a experiência do usuário.

**Alternativa: Programação Reativa (Não-Bloqueante)**
Para resolver os problemas do JDBC bloqueante, sugiram abordagens reativas, como o **Spring Data R2DBC**. Essas abordagens permitem acessar bancos de dados de forma **não-bloqueante** e **assíncrona**, utilizando fluxos reativos ( #Flux e #Mono no caso do Spring).

**Como o Spring Data unifica essas tecnologias?**
O Spring Data oferece uma **camada de abstração comum** através de:
- **Repositórios genéricos (como *CrudRepository*, *JpaRepository*,** que funcionam para múltiplas tecnologias.
- **Query methods** - métodos declarados em interfaces que são automaticamente implementados pelo Spring;
- **Suporte a consultas customizadas** - (via JPQL, queries nativas, ou sintaxes específicas do banco, como MongoDB Aggregations).

**E onde o JDBC Template entra nessa história?**

1. **Camada mais baixa que o Spring Data**
	- Enquanto o **Spring Data (JPA, MongoDB, etc)** oferece abstrações de alto nível (como repositórios automáticos), o **JdbcTemplate** é uma ferramenta mais próxima do JDBC puro, porém com simplificações.
	- Ele elimina o boilerplate do JDBC tradicional (como fechar conexões manualmente), mas ainda exige que escrevamos SQL explicitamente.

2. **Tecnologia de persistências mais manual**
	- Definimos as queries SQL e mapeia os resultados para objetos manualmente (usando #RowMapper ou #ResultSetExtractor).

3. **Não usa JPA ou ORM**
	- Diferente do Spring Data JPA (que usa Hibernate/EclipseLink), o #JdbcTemplate não tem conceitos como entidades, cache de primeiro nível, ou lazy loading.


### **Comparação com Spring Data JDBC/JPA**

| Feature                          | JDBC Template                                               | Spring Data JDBC               | Spring Data JPA              |
| -------------------------------- | ----------------------------------------------------------- | ------------------------------ | ---------------------------- |
| **Nível de abstração**           | Baixo (próximo do SQL)                                      | Médio (ORM simplificado)       | Alto (ORM completo)          |
| **Escreve SQL?**                 | ✅ Sim                                                       | ⚠️ Parcialmente (gerado)       | ❌ Raro (usa JPQL/HQL)        |
| **Mapeamento objeto-relacional** | Manual (`RowMapper`)                                        | Automático (entidades simples) | Automático (com annotations) |
| **Boilerplate**                  | Reduzido (vs JDBC puro)                                     | Mínimo                         | Mínimo                       |
| **Bom para**                     | <font color="#d99694">Consultas complexas/otimizadas</font> | Apps simples com SQL explícito | Apps complexas com ORM       |
**Quando usar o JDBC Template?**
1. **Performance crítica**. Se precisamos controlar cada detalhe do SQL (ex.: otimizações específicas para bancos grandes);
2. **Legado ou SQL complexo:** quando há queries muito customizadas (ex.: CTEs, funções de banco) que são difíceis de expressar em JPA/HQL.
3. **Sem JPA:** Se queremos evitar o overhead de um ORM completo.

---

**Vamos ver onde o Spring Data se encaixa em uma aplicação Spring.**

Em uma aplicação, existem várias tecnologias que podemos usar para trabalhar com dados persistentes. Nos capítulos 12 e 13, utilizamos o JDBC, que se conecta diretamente a um SGBD relacional por meio de um *driver manager*. No entanto, o JDBC não é a única abordagem possível para se conectar a um banco de dados relacional. <span style="background:#b1ffff">Outra forma comum de implementar persistência de dados é usando um framework ORM</span>, como o #Hibernate. Além disso, os bancos de dados relacionais não são o único tipo de tecnologia de persistência de dados. Uma aplicação pode utilizar uma das várias tecnologias NoSQL disponíveis para armazenar os dados.

A figura abaixo mostra algumas das alternativas do Spring para persistir dados. Cada alternativa possui sua própria maneira de implementar os repositórios da aplicação. Às vezes, <span style="background:#b1ffff">podemos ter ainda mais opções para implementar a camada de persistência da aplicação para uma única tecnologia</span> (como o JDBC). Por exemplo, com o JDBC, podemos usar o #JdbcTemplate, mas também podemos trabalhar diretamente com as interfaces do JDK ( #Statement, #PreparedStatement e #ResultSet). Ter tantas formas de implementar as capacidades de persistência da aplicação adiciona complexidade. 

![[Capítulo 14 - Implementing data persistence with Spring Data-1.png]]

O diagrama fica mais complicado se incluirmos frameworks de ORM, como o Hibernate. A figura 14.3 mostra o lugar do Hibernate nesse cenário. Nossa aplicação pode usar o JDBC diretamente de várias formas, mas também pode depender de um framework implementado sobre o JDBC.

![[Capítulo 14 - Implementing data persistence with Spring Data-2.png]]

O #Hibernate é um *framework* #ORM que se baseia no JDBC e simplifica alguns aspectos do trabalho com dados persistidos.

O conhecimento que aprendemos nos capítulos 12 e 13 sobre JDBC é o suficiente como base para começarmos a aprender Spring Data. A pergunta, que inclusive já foi respondida, é a seguinte: Existe uma maneira de implementar a persistência para todas essas tecnologias, em vez de ter que conhecer abordagens diferentes para cada uma? Sim, e o Spring Data nos ajuda a alcançar esse objetivo.

O Spring Data simplifica a implementação da camada de persistência ao fazer o seguinte:
- **Fornecer um conjunto comum de abstrações (interfaces) para várias tecnologias de persistência**. Dessa forma, usamos uma abordagem semelhante para implementar a persistência em diferentes tecnologias.
- **Permitir que o usuário implemente as operações de persistência usando apenas as abstrações, para as quais o Spring Data fornece as implementações**. Assim, escrevemos menos código, acelerando a implementação das funcionalidades da aplicação. Com menos código escrito, a aplicação também se torna mais fácil de entender e manter.

A figura 14.4 mostra a posição do Spring Data em uma aplicação Spring. O Spring Data é uma camada de alto nível sobre as diversas formas de implementar a persistência. Portanto, independentemente de nossa escolha para implementar a persistência da aplicação, se usarmos Spring Data, escreveremos as operações de persistência de maneira semelhante. 

![[Capítulo 14 - Implementing data persistence with Spring Data-3.png]]

## 14.2 How Spring Data Works
Nesta seção, vamos discutir como o Spring Data funciona e como nós podemos utilizá-lo para implementar a nossa camada de persistência em uma aplicação Spring.

Quando estamos nos referindo ao termo *Spring Data*, estamos falando, de forma geral, sobre todas as capacidades que esse projeto oferece para conectarmos nossa aplicação Spring a uma tecnologia de persistência específica (seja JDBC, Hibernate, MongoDB ou outras).

O projeto Spring Data fornece *módulos independentes* para cada tecnologia suportada. Ao invés de uma única dependência **Spring Data**, adicionamos ao nosso projeto **dependência Maven específicas** para o módulo correspondente à tecnologia escolhida. Por exemplo:
- **Spring Data JDBC:** para conexão direta com um SGBD via JDBC;
- **Spring Data MongoDB:** para integração com bancos MongoDB.
The figures 14.5 shows what Spring Data looks like using JDBC:

![[Capítulo 14 - Implementing data persistence with Spring Data-4.png]]

Em uma aplicação, será utilizada uma ou outra tecnologia de persistência. O aplicativo só precisa do módulo **do Spring Data** correspondente à tecnologia escolhida. 

Podemos encontrar a lista de módulos Spring Data na página oficial, https://spring.io/projects/spring-data.

Qualquer que seja a tecnologia de persistência utilizada pelo seu aplicativo, o Spring Data fornece um conjunto comum de interfaces (contratos) que estendemos para definir os recursos de persistência do app. A figura 14.6 apresenta as seguintes interfaces:

**Como o Spring Data funciona**
![[Capítulo 14 - Implementing data persistence with Spring Data-5.png]]

- #Repository: é o contrato mais abstrato. Ao estendê-lo, o nosso app reconhece a interface como um repositório Spring Data, mas sem herdar operações pré-definidas (como adicionar um registro, recuperar todos os registros ou buscar por chave primária). 
- #CrudRepository: é o contrato mais simples que já inclui funcionalidades de persistência. Ao estendê-lo, obtemos as operações #CRUD básicas.
- #PagingAdnSortingRepository: estende o #CrudRepository e adiciona operações para **ordenar registros** ou recuperá-los em **páginas** (conjuntos com número específico de itens).

**NOTA:** Não confunda a anotação @Repository com a interface *Repository* do Spring Data.
- @Repository é um *stereotype annotation* usada em classes para instruir o Spring a adicionar uma instância da classe anotada ao *application context*.
- A interface *Repository* discutida neste capítulo é específica do **Spring Data**. Estendemos ela ou outra interface que deriva dela, como *CrudRepository* para definir um *Spring Data Repository*. 

Mas, por que o Spring Data oferece múltiplas interfaces que herdam umas das outras, em vez de uma única interface com todas as operações? Essa abordagem segue um princípio conhecido como *Interface Segregation Principle (ISP)* (DESENVOLVIMENTO ÁGIL LIMPO), que visa:
1. **Evitar contratos inchados**, (fat interfaces). Se todas as operações (CRUD, paginação, ordenação), estivessem em uma única interface, aplicações que precisam apenas de CRUD seriam sobrecarregadas com funcionalidades não utilizadas.
2. **Permitir flexibilidade:** se o nosso app só precisa de operações básicas de CRUD, basta estender *CrudRepository*. Se precisar de paginação/sorting, estendemos *PagingAndSortingRepository* (que já inclui o CRUD).
3. **Simplificar a implementação:** aplicações só herdam o que realmente usam, reduzindo complexidade desnecessária. 

![[Capítulo 14 - Implementing data persistence with Spring Data-6.png]]

Se a nossa aplicação precisa de operações CRUD simples, mas não precisa filtrar ou de paginação, então a nossa aplicação repository pode extender diretamente a interface Spring Data's CrudRepository.

Agora, se a nossa aplicação precisar de funcionalidades de paginação ou filtragem, capacidades além de uma simples operação CRUD, é melhor extender um contrato mais particular:
![[Capítulo 14 - Implementing data persistence with Spring Data-7.png]]

Alguns módulos do Spring Data podem fornecer contratos específicos para a tecnologia que representam. Por exemplo, ao usar o Spring Data JPA, podemos estender diretamente a *interface* *JpaRepository*. A interface *JpaRepository* é um contrato mais específico do que *PagingAndSortingRepository*. Esse contrato adiciona operações aplicáveis apenas quando se utiliza tecnologias específicas, como o #Hibernate, que implementa a especificação *Jakarta Persistence API (JPA)*.

Outro exemplo é o uso de uma tecnologia NoSQL, como o *MongoDB*. Para usar o Spring Data com MongoDB ao nosso aplicativo, o Spring Data Mongo oferece um contrato específico chamado *MongoRepository*, adicionando operações específicas para essa tecnologias de persistência.

Quando uma aplicação utiliza certas tecnologias, ele estende contratos do Spring Data que fornecem operações particulares para essa tecnologia. O aplicativo ainda pode implementar *CrudRepository* caso não precise de mais do que as operações CRUD, mas esses contratos específicos geralmente oferecem soluções adequadas para a tecnologia para a qual foram projetados. 

![[Capítulo 14 - Implementing data persistence with Spring Data-8.png]]

![[Capítulo 14 - Implementing data persistence with Spring Data-9.png]]

Se a nossa aplicação estiver usando um framework ORM como o Hibernate, é recomendado estender *JpaRepository* em vez de *CrudRepository*, pois ele oferece métodos adicionais mais adequados para o JPA. Isso significa que a escolha da interface depende das necessidades da aplicação e da tecnologia utilizada.

## 14.3 Using Spring Data JDBC
Vamos utilizar o Spring Data JDBC para implementar a camada de persistência de uma aplicação Spring. Discutimos que tudo o que você precisa fazer é estender um contrato do Spring Data, mas vamos ver isso em ação. Além de implementar um repositório básico, também aprenderemos como criar e usar operações personalizadas de repositório.

Vamos construir uma carteira eletrônica que gerencia as contas dos usuários. Um usuário pode transferir dinheiro de sua conta para outra conta. Neste tutorial, implementamos o caso de uso de transferência de dinheiro para permitir que o usuário envie dinheiro de uma conta para outra. A operação de dinheiro possui duas etapas:
1. Retirar (*withdraw*) um valor específico da conta do remetente;
2. Depositar (*deposit*) o valor na conta de destino.

Essa abordagem garante que ambas as etapas sejam executadas de forma consistente, mantendo a integridade dos dados no sistema.

Vamos armazenar os detalhes da conta em uma tabela no banco de dados. 

A tabela de contas possui os seguintes campos:
- *Id* - a chave primária. Definimos este campo como um valor do tipo *Int* que é autoincrementado;
- *name* - o nome do proprietário da conta;
- *amount* - a quantidade de dinheiro que o proprietário possui na conta.

Lembre-se de que, para valores decimais, recomendo o uso de BigDecimal em vez de double ou float para evitar possíveis problemas de precisão em operações aritméticas.

Para várias operações que o *Spring Data* oferece, como recuperar dados do banco de dados, ele precisa saber <span style="background:#affad1">qual campo mapeia a chave primária da tabela.</span> Usamos a anotação *@Id*, conforme mostrado na listagem 14.1, para marcar a chave primária:
[[Spring Start Here/codes/sq-ch14-ex1/src/main/java/org/example/sqch13ex1/model/Account.java|Account]]

Portanto, a anotação *@Id* do Spring Data (e do JPA) serve para indicar que um determinado campo de uma entidade representa a *chave primária* no banco de dados. 

Logo, no *Spring Data JDBC*, o gerenciamento do ID não é feito automaticamente pelo framework, como acontece no JPA com *@GeneratedValue*. 
Portanto, no **Spring Data JDBC**, o banco de dados precisa ser configurado para gerar a chave primária (exemplo: colunas *AUTO-INCREMENT* no MySQL ou *SERIAL* no *PostgreSQL*).

O campo *amount* foi definido como *BigDecimal* para garantir a precisão nas operações aritméticas envolvendo valores monetários. Isso evita erros de arredondamento que podem ocorrer com tipos como *double* ou *float*.

Agora que temos uma classe de modelo, podemos implementar o repositório do *Spring Data*. Como essa operação requer apenas operações CRUD, vamos criar uma *interface* que estende a interface *CrudRepository*. Todas as interfaces do *Spring Data* <span style="background:#d4b106">possuem dois tipos genéricos que precisam ser fornecidos</span>:
1. A classe de modelo (às vezes chamada de entidade) para a qual estamos criando o repositório;
2. O tipo do campo da chave primária.

```java
public interface AccountRepository extends CrudRepository(Account, Integer) {

}
```

Quando você estende a interface *CrudRepository*, o *SpringData* fornece operações simples, como obter um valor por sua chave primária, recuperar todos os registros da tabela, excluir registros etc. No entanto, ele não oferece todas as operações possíveis que podemos implementar com consultas SQL. Em uma aplicação real, muitas vezes são necessárias operações personalizadas, que exigem a escrita de uma consulta SQL para serem implementadas. <span style="background:#b1ffff">Como podemos implementar uma operação personalizada em um repositório do Spring Data</span>?

O Spring Data é capaz de interpretar os nomes dos métodos com base em algumas regras de nomenclatura predefinidas e cria a consulta SQL automaticamente nos bastidores. Por exemplo, suponha que desejamos escrever uma operação para obter todas as contas associadas a um determinado nome. No **Spring Data**, podemos apenas declarar um método com o seguinte nome: *findAccountsByName*.

```java
public interface AccountRepository
	extends CrudRepository<Account, Integer> {

		// Método personalizado para buscar contas pelo nome
		List<Account> findAccountsByName(String name);
	}
```

Quando o nome do método começa com *find*, o *Spring Data* entende que estamos realizando uma operação de *SELECT*. Em seguida, a palavra *Accounts* informa ao *Spring Data* o que desejamos selecionar. O *Spring Data* também permitiria a anotação *findByName*, e ele ainda saberia o que selecionar simplesmente porque o método está na interface *AccountRepository*.

Após o *By* no nome do método, o Spring Data espera receber a condição de consulta (a cláusula *WHERE*). No nosso exemplo, queremos selecionar *ByName*, então o **Spring Data** traduz isso para *HERE name = ?*.
![[Capítulo 14 - Implementing data persistence with Spring Data-10.png]]

A mágica de traduzir o nome de um método em uma consulta parece incrível à primeira vista. No entanto, com a experiência, percebemos que essa abordagem não é a solução perfeita. Ela apresenta algumas desvantagens, e por isso sempre recomendamos que os desenvolvedores especifiquem explicitamente as consultas SQL, em vez de depender da tradução automática do *Spring Data* com base no nome do método. As principais desvantagens de confiar no nome do método são as seguintes:
1. Consultas complexas tornam os nomes dos métodos extensos e Difíceis de Ler:
	- Se a operação exigir uma consulta mais complexa (por exemplo, envolvendo múltiplas condições, junções ou funções agregadas), o nome do método pode se tornar excessivamente longo e difícil de interpretar.
	- Exemplo: List< Account> findAccountsByNameAndAmountGreaterThanAndIdLessThanOrderByAmountDesc(String name, BigDecimal amount, Integer id);

2. **Risco de Refatoração Acidental:**
	- Se um desenvolvedor renomear o método por engano durante uma refatoração, ele pode alterar involuntariamente o comportamento da aplicação sem perceber.
	- Infelizmente, nem todas as aplicações possuem testes abrangentes, e esse tipo de erro pode passar despercebido até causar problemas em produção.

3. **Curva de Aprendizado das Regras de Nomenclatura**
	- A menos que estejamos utilizando uma IDE que ofereça sugestões enquanto escreve o nome do método, será necessário aprender as regras de nomenclatura específicas do Spring Data.
	- Como a maioria dos desenvolvedores já conhece SQL, aprender um conjunto adicional de regras que só se aplicam ao *Spring Data* pode não ser vantajoso.

4. **Impacto no Desempenho**
	- O **Spring Data** precisa traduzir o nome do método em uma consulta SQL durante a inicialização da aplicação. Isso adiciona um pequeno #overhead ao tempo de inicialização, especialmente em projetos grandes com muitos métodos personalizados.
	- Embora o impacto seja geralmente mínimo, ele pode se tornar perceptível em cenários onde o <span style="background:#b1ffff">desempenho de inicialização</span> é crítico.

**Quando utilizar consultas explícitas?**
Para evitar essas desvantagens, é recomendável usar consultar SQL explícitas quando:
- A consulta for complexa ou envolver múltiplas condições;
- Houver necessidade de otimizar o desempenho;
- A legibilidade do código for importante para facilitar a manutenção.

A maneira mais simples de evitar esses problemas é usando a anotação *@Query* para especificar a consulta SQL que o aplicativo executará quando chamarmos esse método. Quando anotamos um método com *@Query*, o nome do método deixa de ser relevante. O *Spring Data* usará a consulta fornecida em vez de traduzir o nome do método em uma consulta SQL. Além disso, o comportamento se torna mais eficiente, pois elimina o #overhead de interpretação do nome do método durante a inicialização da aplicação. A listagem a seguir mostra como usar a anotação *@query*
```java
public interface AccountRepository extends CrudRepository<Account, Integer> {
		@Query("SELECT * FROM account WHERE name = :name and amount > :amount ODER by amount DESC")
		List<Account> findAccountWithNameAndAmount(
			@Param("name") String name,
			@Param("amount") BigDecimal amount
		);
}
```
Precisamos lembrar que o nome do parâmetro na consulta deve ser o mesmo que o nome do parâmetro do método. Não deve haver nenhum espaço entre o dois-ponto (:) e o nome do parâmetro.

Usamos a anotação #Query da mesma maneira para definir qualquer consulta. No entanto, quando nossa consulta altera dados (como em operações de **Update**, **Insert** ou **Delete**), precisamos incluir a anotação *@Modifying*. A anotação informa ao **Spring Data** que a consulta não é apenas uma operação de leitura *SELECT*, mas sim uma operação que modifica os dados no banco de dados. A listagem a seguir mostra como usar *@Query* junto com *@Modifying* para definir uma consulta de **UPDATE** em um método de repositório.

Agora, utilizaremos a injeção de dependência (DI) para obter um bean que implementa a interface *AccountRepository* sempre que precisarmos dela em nossa aplicação. Não precisamos nos preocupar com o fato de ter escrito apenas uma *interface* do *AccountRepository*, o Spring Data cria uma implementação dinâmica e adiciona um bean ao Spring Context Application. A listagem a seguir, mostra como o componente *TransferService* do aplicativo usa injeção de construtor para obter um bean do tipo *AccountRepository*. 

## Summary
- O **Spring Data** é um projeto do ecossistema Spring que nos ajuda a implementar de forma mais fácil a camada de persistência de um aplicativo Spring. O **Spring Data** fornece uma camada de abstração sobre várias tecnologias de persistência e facilita a implementação ao fornecer um conjunto comum de contratos. 

- Com o **Spring Data**, implementamos repositórios por meio de *interfaces* que estendem contratos padrão do Spring Data: 
	- Repository, que não fornece nenhuma operação de persistência; 
	- #CrudRepository: fornece operações simples de CREATE, READ, UPDATE, DELETE (CRUD);
	- #PagingAdnSortingRepository: estende CrudRepository e adiciona operações para paginação e ordenação dos registros recuperados;

- Ao usar o **Spring Data**, escolhemos um módulo específico de acordo com a tecnologia de persistência que nosso aplicativo utiliza. Por exemplo, se nosso aplicativo se conecta ao DBMS através de JDBC, nosso aplicativo precisará do módulo *Spring Data JDBC*, enquanto se o nosso aplicativo usar uma implementação NoSQL, como o MongoDB, ele precisará do módulo Spring Data Mongo.

- Ao estender um contrato do Spring Data, nosso aplicativo herda e pode usar operações definidas por esse contrato. No entanto,<span style="background:#b1ffff"> nosso aplicativo pode definir operações personalizadas com métodos nas interfaces de repositório</span>.

- Usamos a anotação *@Query* com o método do repositório do *Spring Data* para definir a consulta SQL que nosso aplicativo executa para essa operação específica.

- Se declararmos um método e não especificar explicitamente uma consulta com a anotação *@Query*, o **Spring Data** traduzirá o nome do método em uma consulta SQL. O nome do método precisa ser definido com base nas regras do Spring Data para entender e traduzi-lo na consulta correta. Se o Spring Data não conseguir resolver o nome do método, o aplicativo falhará ao iniciar e lançara uma exceção.

- É preferível usar a anotação *@Query* e evitar depender do Spring Data para traduzir o nome do método na consulta. Usar a abordagem de tradução do nome pode trazer dificuldades. 
	- Cria nomes de métodos longos e difíceis de ler para operações mais complexas, o que afeta a manutenibilidade do aplicativo. 
	- Torna mais lenta a inicialização do aplicativo, pois agora ele precisa também traduzir os nomes dos métodos;
	- Vamos precisar aprender a convenção de nomes de métodos do Spring Data.

- Qualquer operação que altere dados (por exemplo, execute consultar INSERT, UPDATE ou DELETE) deve ser anotada com a anotação @Modifying para instruir o Spring Data de que a operação altera os registros de dados.

