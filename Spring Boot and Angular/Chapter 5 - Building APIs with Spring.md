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

O consenso é que os DTOs pertencem às camadas mais externas da aplicação, servindo como contratos de dados para a comunicação com o mundo exterior, como APIs REST, clientes de mensageria ou interfaces de usuário. Eles não devem ser confundidos com as entidades de domínio, que representam o núcleo do negócio e contêm as regras de negócio.

A principal função dos DTOs é  modelar os dados que serão enviados ou recebidos, permitindo a dissociação entre a representação interna do domínio e a exposição para os clientes. Isso evita o vazamento de detalhes de implementação e oferece flexibilidade para evoluir a API sem impactar o modelo de domínio.

## Adding Redis for caching
O Redis pode melhorar o desempenho dads nossas aplicações REST. O Redis é um armazenamento de dados em memória, chave-valor e de código aberto, que permite que os dados fiquem na memória para proporcionar baixa latência e acesso mais rápido. Comparado a bancos de dados tradicionais, o Redis não precisa acessar o disco, pois todos os dados ficam em cache na memória, o que proporciona respostas mais rápidas.

Atualmente, ele é amplamente utilizado, especialmente em aplicações de grande porte que recebem milhões de requisições. É compatível com diferentes estruturas de dados, como strings, listas, conjuntos (sets), hashes, bitmaps e dados geoespaciais, além de suportar o padrão Publish/Subscribe, usado em aplicações de chat em tempo real.

Conteúdo extra sobre Redis: https://medium.com/@habbema/introdu%C3%A7%C3%A3o-ao-redis-9a4acbde2e8e

## Configurando Redis no Spring Boot
Já conseguimos configurar e iniciar o servidor Redis na nossa máquina local. O próximo passo é utilizar o Redis no nosso projeto Spring Boot. Vamos seguir os passos abaixo:
1. Adicionar dependências do Redis em nosso pom.xml: 
```json
<!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-redis -->  
<dependency>  
    <groupId>org.springframework.data</groupId>  
    <artifactId>spring-data-redis</artifactId>  
    <version>4.0.0-M6</version>  
</dependency>  
  
<!-- https://mvnrepository.com/artifact/redis.clients/jedis -->  
<dependency>  
    <groupId>redis.clients</groupId>  
    <artifactId>jedis</artifactId>  
    <version>6.2.0</version>  
</dependency>
```
Após adicionar as  dependências com sucesso, o próximo passo é criar a configuração do Redis, que definirá as propriedades de conexão com o servidor Redis, dentro do pacote *config*.

2. Criando a classe **RedisConfig**: crie uma classe chamada *RedisConfig*. Vamos usar a anotação @Configuration para identificar que essa classe possui métodos que definem Beans, os quais serão utilizados durante a execução da aplicação. Dentro da classe, adicione o seguinte método:
```java
@Bean JedisConnectionFactory jedisConnectionFactory() {
	RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
	return new JedisConnectionFactory(redisStandaloneConfiguration);
}
```

O  método *jedisConnectionFactory()* é usado para definir as propriedades de conexão do nosso servidor Redis. Neste exemplo, ele usa valores padrão, pois ainda não especificamos propriedades de conexão.

Se o nosso servidor Redis estiver em outro host, porta diferente ou exigir usuário e senha, podemos usar os seguintes métodos:
- redisStandaloneConfiguration.setHostName("host")
- redisStandaloneConfiguration.setPort("port")
- redisStandaloneConfiguration.setUsername("username")
- redissStandaloneConfiguration.setPassword("password")

O próximo passo é usar a JedisConnectionFactory para criar um RedisTemplate, que será utilizado nas interações com o Redis;

O *RedisTemplate* permite a serilização e desserilização automática entre objetos Java e os dados binários armazenados no Redis.

3. Vamos criar um método que também usará a notação @Bean, nesse método, criaremos um novo **RedisTemplate** e definiremos a **connection factory** com o seguinte código:
```java
@Bean
public RedisTemplate<UUID, Object> redisTemplate() {
    RedisTemplate<UUID, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());

    // Serializers para chaves e hash keys
    template.setKeySerializer(new StringRedisSerializer());
    template.setHashKeySerializer(new StringRedisSerializer());
    
    // Serializer para hash values e values
    template.setHashValueSerializer(new JdkSerializationRedisSerializer());
    template.setValueSerializer(new JdkSerializationRedisSerializer());

    template.setEnableTransactionSupport(true);
    template.afterPropertiesSet();
    
    return template;
}

```

**Usando @RedisHash na entidade**
O último passo é adicionar a anotação *@RedisHash* em nossa **entity**, que serve para marcar objetos como **aggregates roots** a serem armazenados como hashes no Redis:
```java
@RedisHash("AntiHero")
public class AntiHeroEntity {
    ...
}

```
Com isso, o Redis será usado com sucesso como cache de dados em nossa aplicação Spring Boot, enquanto as operações são executadas.

