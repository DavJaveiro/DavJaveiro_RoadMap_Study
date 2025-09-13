Neste capítulo, criaremos nosso projeto de interface de programação API com Spring Boot; vamos nos concentrar em codificar, criar nossos modelos (models) e adicionar controllers e services para desenvolver nossos endpoints. Também adicionaremos o Remote Dictionary Server (Redis) para cache, afim de ajudar a melhorar o desempenho de nossa aplicação.

Neste capítulo, abordaremos os seguintes tópicos:
- Iniciando o servidor
- Adicionando modelos
- Escrevendo serviços
- Adicionando controllers
- Adicionando Redis para cache

## Iniciando os servidores
Nesta seção, vamos tentar executar nossa aplicação Spring Boot em nosso servidor, mas primeiro, vamos recapitular o capítulo anterior: aprendemos a configurar o Spring Data JPA e a conectar nossa aplicação ao nosso banco de dados PostgreSQL e, o amis importante, instalamos todas as dependências necessárias em nossa aplicação. Todos esses são pré-requisitos para executar a aplicação Spring Boot.

Assumimos que já geramos nossa aplicação Spring Boot com as dependências necessárias. No entanto, se perdemos essa parte ou não temos certeza se todas as dependências foram incluídas em seu projeto gerado, vamos listar novamente todas as dependências que instalamos no capítulo anterior:
- **Spring Data JPA**: dependência para adicionar a Spring Data JPA, usada para implementações relacionadas a armazenamento de dados.
- **Driver PostgresSQL**: um driver JDBC e R2DBC que permitirá a conexão de aplicações Java ao banco de dados PostgreSQL.
- **Banco de Dados H2:** um banco de dados em memória que suporte as APIs JDBC e R2DBC; é comumente usado para **testes unitários**.

**Adding models**
Nesta seção, vamos agora escrever o código para nossa aplicação, e a primeira coisa que criaremos são os modelos (models).

Em termos simples, os modelos são os objetos da nossa aplicação; os modelos servirão como nossas entidades (entities) e definirão nossas tabelas no banco de dados.

Uma vez que criarmos os modelos e executarmos a aplicação, isso também gerará tabelas em nosso banco de dados automaticamente com a ajuda de anotações, que também serão discutidas ao longo deste exemplo.

**Criando modelos com DTOs e Lombok**
Primeiro, mostraremos como escrever modelos usando **Lombok** e **objetos de transferência de dados (DTOs)**.

## DTOs
Os DTOs são responsáveis por transportar dados entre processos para reduzir o número de chamadas de método. DTOs são objetos Java antigos simples (POJOs) que geralmente consistem em métodos de acesso a dados (accessors).

Os DTOs são úteis ara criar representações de nossas entidades a fim de ter visualizações para os clientes sem afetar o padrão e o design. Vejamos um caso de uso de exemplo para DTOs:
```java
public class Blog {
	private String id;
	private String title;
	private String description;
	private string author;
	
	public Blog(String title, String description, Strin author) {
		this.name = title;
		this.description = description;
		this.author = author;
	}
}
```

No exemplo anterior, criamos um exemplo de modelo de domínio (domain model) que representará as entidades em nosso banco de dados. Há casos em que não queremos incluir algumas informações ao enviar dados para o cliente, e é aí que os DTOs entram em cena. Criaremos dois DTOS para o modelo de blog, usados para obter e criar dados, da seguinte forma:
```java
public class BlogDTO {
	private String title;
	private String description;
}
```

No exemplo de DTO anterior, criamos uma classe BlogDTO que será usada para recuperar dados; nosso objetivo é ocultar o nome do autor, portanto, não o incluímos como um campo no DTO. O código é ilustrado no trecho a seguir:
```java
private class BlogCreationDTO {
	private String title;
	private String description;
	private String author;
}
```

O próximo DTO que criamos é o `BlogCreationDTO`, que será usado para criar um novo blog. Podemos ver que todos os campos necessários para criar um novo blog estão incluídos.

Os DTOs criados serão usados em nossos controllers nas próximas seções.

Uma das motivações de utilizar DTOs é evitar enviar objetos de entidade complexos pela rede, especialmente entre servidores e clientes remotos.

```java
public List<ProductDTO> findAll() {
	return repository.findAll()
		.stream()
		.map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()))
		.toList();
}

// Salva um produto recebido como DTO
public ProductDTO save(ProductDTO dto) {
	// Converte DTO -> Entity
	Product product = new Product(dto.name(), dto.price());
	Product saved = repository.save(product);
	
	// Converte Entity -> DTO
	return new ProductDTO(saved.getId(), saved.getName(), saved.getPrice());
}

```

docker run --name meu_postgres -p 5434:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin123 -e POSTGRES_DB=mydb -d postgres