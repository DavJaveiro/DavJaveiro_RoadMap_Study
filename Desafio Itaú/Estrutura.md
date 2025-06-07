## 1. Estrutura do Projeto
### 1.1 Dependências:
**Spring Actuator**:
Para resolução *4. Observabilidade*, 

**Spring Web**:
 Conjunto de módulos e funcionalidades dentro do ecossistema Spring dedicados à criação de aplicações web e *APIs RESTful* em Java. O módulo mais proeminente e central aqui é o Spring MVC (Model-View-Controller).
 1. **Spring MVC:**
	- O que é? É um framework robusto e flexível que implementa o padrão de design Model-View-Controller para aplicações web. Ele <span style="background:#b1ffff">fornece uma arquitetura clara para separar as responsabilidades da nossa aplicação</span>.
	- **DispatcherServlet:** é o coração do Spring MVC. Trata-se de um *front controller* que intercepta todas as requisições HTTP de entrada. Ele consulta manipuladores *handlers* e adaptadores para decidir qual controller deve processar a requisição e, em seguida, direciona a resposta de volta ao cliente, muitas vezes renderizando uma view.
	


**Projeto Lombok** 
Visando reduzir drasticamente a quantidade de código *boilerplate* (código repetitivo e previsível) que os desenvolvedores precisam escrever. Ele funciona "conectando-se" ao processo de compilação e gerando automaticamente métodos Java comuns, como **getters**, **setters**, **constructores (toString()), equals(), hashCode()**, entre outros, com base em anotações que adicionamos ao nosso código.

1. **Principais anotações e o que elas fazem:**
	- **@Getter** e **@Setter**: geram os métodos getter e setter para os campos.
	- **@ToString**: gera uma implementação do método **toString()**, exibindo o nome da classe e os valores dos campos.
	- **@EqualsAndHashCode**: gera os métodos **equals()** e **hashCode()** com base nos campos da classe, fundamental para coleções e comparações.
	
	**Construtores**:
	- **@NoArgsConstructor**: Gera um construtor sem argumentos
	- **@RequiredArgsConstructor**: Gera um construtor com argumentos para campos *final* ou marcados com *@NonNull* que não foram inicializados.
	- **@AllArgsConstructor**: gera um construtor com argumentos para todos os campos da classe.

### 1.2 Estrutura ou Arquitetura
Ok, uma API básica em Java geralmente segue uma arquitetura em camadas para organizar as responsabilidades e facilitar a manutenção. 
Uma estrutura de pacotes comum poderia ser algo assim:
```
com.suaempresa.suaapi
├── controller       // Camada de Apresentação
│   ├── SeuController.java
│   └── dto
│       └── SeuRequestDTO.java
│       └── SeuResponseDTO.java
├── service          // Camada de Serviço
│   ├── SeuServico.java
│   └── impl
│       └── SeuServicoImpl.java // Implementação da interface do serviço (opcional, mas boa prática)
├── repository       // Camada de Acesso a Dados
│   └── SeuRepositorio.java // Geralmente uma interface com Spring Data JPA
├── model            // Ou 'entity' - Contém as entidades JPA
│   └── SuaEntidade.java
├── exception        // Classes de exceção personalizadas
│   └── RecursoNaoEncontradoException.java
├── config           // Configurações da aplicação (ex: segurança, banco de dados)
│   └── SecurityConfig.java
└── SuaAplicacao.java  // Classe principal com o método main (ex: Spring Boot @SpringBootApplication)
```
### 1.3 Arquitetura Típica de uma API Java
#### 1.3.1 Camada de Apresentação (Controller)
Camada responsável por lidar com as requisições HTTP (GET, POST, PUT, DELETE, etc) e enviar as respostas. É o ponto de entrada de nossa API.
**Componentes Típicos**: 
- #Controllers (controladores): são classes que mapeiam as URLs para métodos específicos. Elas recebem os dados da requisição, validam (às vezes delegam para serviços de validação) e chamam os serviços apropriados na camada de serviço.
- #DTOs (Data Transfer Objects): objetos simples para transportar dados entre as camadas, especialmente entre a camada de apresentação e a de serviço.

**Frameworks Comuns:** #Spring-MVC (com anotações *@RestController*, *@GetMapping*, *@PostMapping*) ou JAX-RS (para APIs RESTful Java EE).

#### 1.3.2 Camada de Serviço (Service)
É a camada que contém a lógica de negócios de nossa aplicação. Orquestra as chamadas para a camada de acesso a dados e pode interagir com outros serviços.

**Componentes Típicos**
- #Services: são classes que implementam as regras de negócios. Por exemplo, *UserService* poderia ter métodos como *createUser*, *getUserById*, *updateUserPassword*, etc.
- #Validação-negócios: Lógica para garantir que os dados e as operações sigam as regras de negócio.

**Frameworks Comuns**
- Spring Framework (com anotações como *@Service*) ajuda na injeção de dependência e gerenciamento de transações. 

#### 1.3.3 Camada de Acesso a Dados (Repository/DAO)
Lida com a interação com o banco de dados (ou qualquer outra fonte de dados). Abstrai os detalhes de como os dados são armazenados e recuperados.

**Componentes Típicos**:
- #Repositories ou #DAOs (Data Access Objects): interfaces e suas implementações que fornecem métodos para operações CRUD e outras consultas ao banco de dados.
- #Entities: classes que mapeiam as tabelas do banco de dados (frequentemente usando JPA - Java Persistence API).

**Frameworks**
Spring Data JPA (simplifica muito a criação de repositórios), Hibernate (uma implementação JPA popular), JDBC (para acesso de baixo nível).

## 2. TransacaoService
As classes *services* são classes que implementam as regras de negócio.

```java
@Service
@RequiredArgsConstructor
public class TransacaoService {
	
}
```
#RequiredArgsConstructor: ela gera automaticamente um construtor com argumentos para determinados campos da nossa classe. Portanto, no nosso contexto, ele é utilizado para **injeção de dependência via construtor**. Esta é considerada uma boa prática por diversos motivos.

Supoonhamos que **TransacaoService** precisa de um **TransacaoRepository** para interagir com o banco de dados:
```java
@Service
@RequiredArgsConstructor
public class TransacaoService {
	private final TransacaoRepository transacaoRepository;
}
```

Sem o *@RequiredArgsConstructor*, teríamos que escrever o construtor manualmente. Com ele, o Lombok faz esse trabalho para a gente, mantendo o nosso código mais enxuto e focado na lógica de negócios.

Em resumo: *@RequiredArgsConstructor* em nosso *TransacaoService* é utilizado para que o Lombok gere automaticamente um construtor que aceitará as dependências necessárias .

Neste exemplo, optamos por utilizar um **ArrayList** para armazenar os dados. 
## 3. DTO
Podemos criar o DTO de duas formas:
### 3.1 record TransacaoRequestDTO
```java
public record TransacaoRequestDTO(Double valor, OffSetDateTime dataHora){}
```
**Vantagens:**
1. <span style="background:#b1ffff">Menos código</span>: o record já cria os **getters**, **equals**, **hashCode** e **toString** automaticamente.
2. **Imutabilidade por padrão:** os campos de um **record** são **final**. Isso ajuda a evitar efeitos colaterais em funções. 
3. **Sem boilerplate:** não precisamos de construtores, getters, nem sobrescrever métodos.
4. **Sem necessidade de Lombok:** é nativo do Java
5. **Mais seguro e conciso:** ideal para DTOs, mensagens de eventos, ou objetos de request/response.

**DesVantagens:**
1. Sem validação via anotações diretas em frameworks mais antigos:
	- Ex: as anotações **@NotNull**, **@DecimalMin**, etc, fucionam, mas devem ser colocadas diretamente nos parâmetros do record:
```java
public record TransacaoRequestDTO(@NotNull @DecimalMin("0.0") Double valor, @NotNull OffSetDateTime datahora) {

}
```

Portanto, um #Record, é similar a uma classe que armazena dados. É a mesma ideia de construção similar a um JavaBean, possui **contrutor**, atributos e métodos acessores. Porém, ao invés de possibilitar qualquer alteração, a classe é imutável. Também possui os métodos *equals, hashCode* e *toString*.

Dado o contexto da imutabilidade de um *Record*, existe apenas um construtor com todos os atributos. Também não existem métodos *setter*. 

Outra diferença entre o primeiro design e utilizando *records* é que os métodos acessores não usam a terminologia com *get*, usam apenas o próprio nome do atributo, ou seja, ao invés de *getName()*, usa apenas um *name()*.
```java
String name = user.name();
```

**Usando records para serializar/desserializar classes**
Dentre várias possibilidades usando *records*, uma utilidade seria serializar e desserializar classes que representam payloads de comunicação, também chamados de DTOs. O #payload de comunicação é a parte fundamental e útil de uma transmissão de dados. É a *carga* real que se deseja enviar, seja o texto de um e-mail, o conteúdo de uma imagem, ou a voz em uma chamada de vídeo. Todo o resto, como endereços, protocolos e informações de controle, serve apenas para garantir que essa carga chegue ao destino correto.




### 3.2 Classe Padrão
```java
public class TransacaoRequestDTO() {
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
	private Double valor;

	@NotNull
	private OffSetDateTime dataHora;


	public Double getValor() {
		return valor;
	}

	public OffSetDateTime getDataHora() {
		return dataHora;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
}
```

**Vantagens**:
1. Mais flexível:
	- Pode fazer lógica no construtor ou nos setters
	- Pode ter métodos auxiliares, como *toEntity()*, *isValidDate()*, etc.

2. Mais compatível com frameworks antigos ou bibliotecas específicas
3. Fácil de modificar se o DTO evoluir para ter mais comportamentos.

parei em 28:10 minutos de vídeo