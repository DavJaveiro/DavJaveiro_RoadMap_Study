**The features of PostgreSQL**
Aqui está uma lista dos recursos que o PostgreSQL oferece:
- Compatibilidade com múltiplos tipos de dados: o PostgreSQL é compatível com vários tipos de dados:
- Estruturados: Arrays, data e hora, Identificadores Únicos Universais (UUIDs) e intervalos (range);
- Personalizados: tipos customizados e compostos
- Primitivos: String, inteiro, numérico e Booleano.
- Geométricos: polígono, círculo, linha e ponto;
- Documento: XLM, JSON/JSONB e chave-valor (HSTORE).

## Spring Data JPA
Spring Data JPA (Java Persistence API) 
O Spring Data JPA (Java Persistence API) é uma especificação (specification) amplamente  utilizada para gerenciar dados relacionais em aplicações Java.  Ele auxilia no desenvolvimento com Spring, pois reduz o código repetitivo (boilerplate) ao não precisar implementar operações de leitura e escrita. Ele também lida com o complexo processo envolvido no acesso ao banco de dados via JDBC e nos mapeamentos objeto-relacionais (ORM).

Antes de discutir o Spring Data JPA em detalhes, vamos abordar suas claras vantagens e por que ele é comumente usado no desenvolvimento com Spring.

**The advantages of Spring Data JPA**
A seguir, as vantagens do Spring Data JPA:
- **Repositórios sem código (no-code repositories)**: O Spring Data JPA promove repositórios "sem código", o que significa que não precisamos escrever o padrão de projeto (design pattern) **repository**, que gera muito código repetitivo. Ele fornece um conjunto de **interfaces** que podemos usar para estender nossas classes e aplicar implementações específicas de dados. Por exemplo, se tivermos uma classe **BlogRepository** em nossa aplicação, ao estendê-la com a interface *CrudRepository<Blog, Long>*, ela terá métodos com as seguintes funcionalidades:
- Persistir, atualizar e deletar uma ou várias entidades de blog.
- Buscar um ou vários blog por suas chaves primárias;
- Contar todos os blogs;
- Validar se um único blog existe;

Estender o repositório com a interface fornecida pelo Spring Data JPA inclui todos os métodos relacionados a dados, **o que nos permite focar mais na lógica de negócio.** 

- **Redução de código repetitivo (boilerplate)**: o Spring Data JPA oferece implementações prontas para os métodos. Como mencionado na primeira vantagem, só precisamos focar na lógica de negócio e não mais codificar operações de leitura e escrita, pois elas já estão definidas nas interfaces. Isso também previne erros humanos, já que todas as implementações já estão registradas para nós.
- **Consultas geradas (generated queries)**: o Spring Data JPA também pode criar consultas com base nos nomes dos métodos. Por exemplo, se quiséssemos consultar um único blog por autor, o único passo que precisamos dar é criar um método em nossa interface com um nome que comece com findBy, e o Spring analisará (parse) o nome e criará a consulta:
```java
public interface BlogRepository extends CrudRepository<Blog, Long> {
	Blog findByAuthor(String author);
}
```

No exemplo anterior, criamos um método **findByAuthor()**, que permitirá ao Spring gerar uma consulta e definir os parâmetros como valores de parâmetros de ligação (bind parameter). Ele executará a consulta assim que chamarmos o método.

**Repositórios fornecidos pelo Spring Data JPA**
O Spring Data JPA fornece repositórios que oferecem diferentes métodos para implementações relacionadas a dados. Os repositórios são os seguintes:
- #CrudRepository: a interface de repositório que fornece as operações básicas para Criar, Ler, Atualizar e Deletar (CRUD);
- #PagingAndSortingRepository: estende a CrudRepository e adiciona um método chamado **findAll**, que pode ordenar os resultados e recuperá-los de forma paginada.
- #JpaRepository: adiciona métodos específicos do JPA e possui todas as funções da CrudRepository e da PagingAndSortingRepository. Ela também adiciona métodos como **flush()**, que descarrega o **contexto de persistência**, e **deleteInBatch()**, que deleta registros em lote.

## Spring Data JPA on Spring Boot
Para implementarmos o Spring Data JPA em nossa aplicação, precisamos dos seguintes componentes:
- **Entidade #Entity**: esta é uma classe simples que define nosso **model**. Ela será usada com uma entidade JPA, gerada com uma chave primária *primary key*. Por exemplo, criaremos uma entidade para Villain (vilão) criando uma classe simples e adicionando a anotação *@Entity* para indicar que a classe *Villain* é uma entidade JPA. A entidade será usada com um tipo ao estender nosso repositório. 
```java
@Entity
public class Villain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
	@Column(nullable = false, updatable = false)
	private UUID id;
	
	@NotNull(message = "First Name is required")
	private String firstName;
	private String lastName;
	private String house;
	private String KnownAs;
}
```

Podemos ver no exemplo anterior que nossa *Villain* está anotada com @Entity, indicando-a como uma entidade JPA. Também definimos um campo *id* do tipo *UUID* e o anotamos com #@Id para indicar que esta é a chave primária, e com **@GeneratedValue**, onde especificamos que ele é gerado automaticamente usando **strategy = GenerationType.AUTO** e que ID gerado deve ser do tipo UUID, usando generator = UUID;

- Repository: this is an interface that we need to extend with JPA repositories for the entities to have built-in operations. In the previous example, we have a villian entity. To implement the CRUD operations, we will create a VillianRepository interface and extend it with CrudRepository
```java
@Repository
public interface VillainRepository extends CrudRepository<Villain, UIID> {
	// custom composite repository here
}
```

- #Service: é aqui que usaremos nosso repositório criado. Podemos usar a anotação *@Autowired* para injetar o repositório e chamar os métodos do JPA e os métodos customizados que definimos:
```java
@Service
public class VillainService {
	private final VillainRepository villainRepository;
	
	@Autowired
	public VillainService (VillainRepository villainRepository) {
	
		this.villainRepository = villainRepository
	}
	
	public Iterable<Villain> findAllVillain() {
		return villainRepository.findAll();
	
	}
	
	public Villain findVillainById (UUID id) {
		return findOrThrow(id);
	}
	
	public void removeVillainById(UUID id) {
	
		villainRepository.deleteById(id);
	}
	
	public Villain addVillain(Villain villain) {
		return villainRepository.save(villain);
	}
	
	public void UpdateVillain(UUID id, Villain villain) {
	
		findOrThrow(id);
		villainRepository.save(villain);
	}
	
	private Villain findOrThrow(final UUID id) {
		return villinRepository
			.findById(id)
			.orElseThrow(
				() -> New NotFoundException("Villain by id " + id + " was not found")
			);
	}
}
```

**Adding Spring Data JPA and PostgreSQL dependencies**
This section will add Spring Data JPA, PostgreSQL, and other valuable dependencies to our application. We will add the dependencies with Spring Initializr and an existing Spring Boot project.

