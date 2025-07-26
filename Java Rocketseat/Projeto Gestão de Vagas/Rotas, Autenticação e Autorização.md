## Controller
A classe controller é um controlador em uma aplicação Spring Boot. Ela é responsável por definir #endpoints para operações relacionadas ao recurso "candidate" (candidato).

É a classe onde definimos os pontos de entrada HTTP (endpoinst) para interagir com o recurso "candidate". 

## Anotações
A anotação #RestController informa ao Spring que esta classe é um **controlador de API REST**. Isso significa que os #métodos desta classe retornam dados diretamente como resposta da API, em vez de redirecionar para uma página HTML. 

Os dados são geralmente retornados em formato JSON (ou outro tipo de mídia), tornando-os ideais para consumo por clientes frontend ou outras aplicações. 

#RequestMapping: essa anotação, usada na classe, define o caminho base para todos os endpoints dentro do candidateController. Nesse caso, /candidate é o caminho inicial.  Todos os métodos dentro deste controlador terão URLs começando com /candidate.

## Método Create
@PostMapping
Essa anotação mapeia o método create() para responder a **requisições HTTP do tipo POST** no caminho /candidate/.

## Exception Handler
O lançamento de exceções é algo fundamental em um software. Quando ocorre um erro no fluxo, é importante que ele seja mapeado para informar de modo evidente o que aconteceu por logs ou retorno ao usuário.

Em aplicações REST, a exceção é motrada na resposta do endpoint. A forma mais simples de se fazer seria adicionar um try-catch no controlador:
```java
@PostMapping("/users")  
fun createUser(@Valid @RequestBody user: User): User {  
try {  
return user  
} catch (exception: MethodArgumentNotValidException){  
// ... criar retorno padronizado  
// ex: { "field": "email", "error": "not follows the pattern mail@mail.com" }  
}  
}
```
Mas essa abordagem traz alguns problemas:
- Em cada função do controlador, deveremos usar um try-catch;
- Ao adicionar uma nova exceção, deveremos mudar em todos os controladores que iriam capturá-la;

Desse modo, o ideal seria centralizar a captura de exceções em uma outra parte do código e esta montar o retorno para nós. No final, o controlador ficaria com um código mais simples e, quando ocorresse a exceção, um controlador específico de exceções iria montar o retorno para gente. 

Quando criamos a classe global para tratar as exceções lançadas pelo endpoint da controladora, nós precisamos informar ao Spring que esta classe vai interceptar o retorno do endpoint e modificá-lo dependendo da exceção lançada, usamos o <span style="background:#d3f8b6">@ControllerAdvice</span> 

## Inserindo Spring Data JPA
- **Repositories**: usamos para definir interfaces que estendem #JpaRepository (ou outras), e o framework autoimplementa operações CRUD básicas, além de #paginação e #ordenação.

- #Query-methods **Métodos de consulta derivados**: queries são geradas automaticamente com base no nome do método (*findByNome*, *findByAuthor_Estado*, etc), com suporte a *@Query*, #Querydsl, #Specifications e #Query-by-Example.

- **Paginação e ordenação**: suporte integrado com #Pageable, #Page e #sort, eliminando quase todo o boilerplate.

- **Projeções e Entity Graphs**: permite retorno em #DTOs (proj. por construtor ou interfaces) e o uso de #EntityGraph para evitar *N+1* selects mais facilmente.

- **Auditoria**: anotações como #CreatedDate e #LastModifiedDate para rastreamento automático de alterações.

- **Transações e tradução de exceções:** integra com transações do Spring #Transactional e converte exceções JPA em hierarquia #DataAccessException.

Use #JpaRepository com métodos derivativos e *@Query* para reduzir boilerplate, aplicação paginação, transações e auditáveis de forma declarativa. API REST com endpoints CRUD simples e pagináveis, integrando fácil com *HttpClient* no frontend.

O **Spring Data JPA** utiliza por padrão o #Hibernate como #ORM (Object-Relational Mapping).

## Criando tabela de candidato
Vamos configurar a nossa entidade, CandidateEntity, para que ela seja uma referência em nosso banco de dados.

```java
@Data  
@Entity(name = "candidate")  
public class CandidateEntity {}
```

#Data (do Lombok)
Gera automaticamente os seguintes métodos para a classe:
- **getters** e **setters** para todos os campos;
- **toString()**
- **equals()** e **hashCode()**
- **construtor padrão (sem argumentos)**

Só funciona se já tivermos o Lombok configurado em nosso projeto; 

#Entity (do JPA / Hibernate)
Marca a classe como uma entidade JPA, ou seja, um objeto que será mapeado para uma tabela do banco de dados.
- O atributo name = "candidate" define o nome da entidade no JPQL (consultas orientadas a objetos), não o nome da tabela no banco.
Mas para funcionar como entidade JPA real, normalmente você também vai usar:
- **@Id**: para marcar o campo chave primária
- **@GeneratedValue**: para auto incremento do ID
- **@Column, @Table**: para configurar mapeamentos específicos

Usamos @Column apenas quando queremos especificar exatamente um nome para a coluna em específico.

@GeneratedValue(strategy = GenerationType.UUID): a anotação é usada em projetos Java com JPA (Java Persistence API) para **gerar automaticamente identificadores únicos (UUIDs)** como <span style="background:#affad1">chave primária de uma entidade</span>.

O que é UUID? UUID significa **Universally Unique Identifier**, um identificador de 128 bits que é praticamente garantido como único, mesmo em sistemas distribuídos.. Exemplo de UUID: `123e4567-e89b-12d3-a456-426614174000`.

**Vantagens de usar UUID como chave primária**
- **Unicidade global:** ideal para sistemas distribuídos
- **Evita colisões:** mesmo entre bancos diferentes
- **Não depende de auto-incremento do banco:** útil em bancos que não suportam isso nativamente.
O tipo do campo deve ser **UUID** ou **String**, dependendo do mapeamento.
Precisamos nos certificar-se de que o banco de dados suporta o tipo UUID (PostgreSQL, por exemplo, tem suporte nativo).

**Atributo CreationTimestamp**
```java
@CreationTimestamp
private LocalDateTime createdAt;
```

- #CreationTimestamp é uma anotação fornecida pelo Hibernate. Ela instrui o framework a preencher automaticamente o campo com a data e hora no momento em que o objeto é **persistido pela primeira vez** (ou seja, na inserção).

- **LocalDateTime createdAt:** é o tipo do campo que armazena a data e a hora da criação.

Ao implementarmos as anotações necessárias para que o JPA faça o gerenciamento dos campos dentro da nossa classe model, precisamos dizer, através da **configuração** com a propriedade do Spring Boot que controla como o Hibernate (o provedor JPA) manipula o esquema do banco de dados ao iniciar a aplicação.
Quando definimos #ddl-auto como #update, estamos dizendo basicamente:
- **Atualize automaticamente o banco de dados** com base nas mudanças nas entidades (classes @Entity do Java);
- Ou seja, se modificarmos um campo ou adicionarmos uma nova entidade, o Hibernate vai tentar refletir essas mudanças no banco sem apagar dados existentes;
- Isso é útil **durante o desenvolvimento**, porque reduz a necessidade de criar ou alterar tabelas manualmente.
- **Não é recomendado em produção**, porque pode causar mudanças inesperadas ou não suportar alterações complexas de esquema.

**Outras opções:**
- #none: não faz nenhuma alteração no banco
- #create: cria todas as tabelas do zero (apaga as existentes)
- #create-drop: cria no início e apaga no shutdown
- #validate: verifica-se o esquema está em conformidade, sem alterar nada.

Se estivermos testando ou prototipando, #update pode ser um bom aliado. Mas se o nosso projeto já está em produção ou precisamos ter controle total de migrações, vale considerar alternativas como **Flyway** ou **Liquibase** para versionamento do banco. 

## Criando Repositório
A camada Repository é onde a nossa aplicação de fato vai se comunicar com o nosso banco de dados. Precisamos passar os generics para a nossa interface.

```java
@Repository  
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {  
  
}
```

Chamando no Controller:
```java
    @PostMapping("/")  
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity){  
        return this.candidateRepository.save(candidateEntity); 
    }  
}
```
Aqui, estamos retornando os dados do usuário cadastrado.

## Validando usuário já existente
