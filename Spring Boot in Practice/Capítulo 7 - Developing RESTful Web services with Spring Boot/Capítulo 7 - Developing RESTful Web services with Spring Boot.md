Este capítulo cobrirá:
- desenhando e projetando RESTful Web Services with Spring Boot
- Tratamento de exceções em RESTful Web Services
- Desenvolvimento de casos de teste unitário para testar RESTful Web services
- Documentação dos RESTful Web services através do OpenAPI
- Implementação de diferentes estratégias de versionamento para RESTful Web Services
- Técnicas para garantir a segurança dos RESTful Web Services

Na arquitetura baseada em microservices, é uma prática comum expor funcionalidades da aplicação por meio de RESTful APIs. Essas APIs podem então ser acessadas por uma variedade de dispositivos de aplicação, como aplicações desktop, dispositivos móveis, bem como outras APIs.

Neste capítulo, vamos apresentar o design e a construção de RESTful APIs com Spring Boot. Aprenderemos a documentar a API, para que os consumidores da API possam encontrar os detalhes necessários sobre ela, como as estruturas de request e response, e os métodos HTTP. Finalmente, aprenderemos a desenvolver casos de testes unitários para testar a API. Por último, veremos como proteger a nossa API RESTful. 

## 7.1 Developing a RESTful API with Spring Boot
Uma API RESTful (também conhecida como REST API) é uma interface de programaçao de aplicações que segue as restrições do estilo arquitetural REST, REST é um acrônimo para *representational state transfer* e foi criado por Roy Fielding. Em uma REST API, quando um cliente solicita um recurso ao servidor, o servidor fornece uma representação do estado do recurso solicitado ao cliente. Essa representação pode ser entregue em vários formatos, como JSON, texto puro, HTML e outros. Entretanto, o JSON é o formato mais amplamente utilizado no contexto de APIs REST.

O Spring Boot oferece suporte embutido no framework para projetar e construir REST APIs. O Spring Boot é um dos frameworks mais populares no ecossistema Java para o desenvolvimento de REST APIs. Nesta seção, exploraremos o desenvolvimento de uma API RESTful com Spring Boot.

### 7.1.1 Technique: Developing a RESTful API using Spring Boot
Nesta técnica, demonstraremos como desenvolver uma API RESTful utilizando o Spring Boot.

**Problem**
Anteriormente, utilizamos a aplicação Spring Boot Course Tracker com Thymeleaf como frontend. Agora, é necessário expor a aplicação Course Tracker como uma API RESTful. Expor a funcionalidade do backend