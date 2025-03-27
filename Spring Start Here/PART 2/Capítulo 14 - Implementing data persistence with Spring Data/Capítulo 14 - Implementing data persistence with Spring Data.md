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