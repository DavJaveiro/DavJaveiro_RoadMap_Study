*This chapter covers*
- Calling REST endpoints using Spring Cloud OpenFeign
- Calling REST endpoints using RestTemplate
- Calling REST endpoints using WebClient

No capítulo 10, discutimos a implementação de endpoints REST. Os serviços REST são uma maneira comum de implementar a comunicação entre dois componentes de um sistema. O cliente de uma aplicação web pode chamar o backend, assim <span style="background:#d4b106">como outro componente do backend também pode fazê-lo</span>. Em uma solução de backend composta por múltiplos serviços (ver apêndice A), esses componentes precisam "conversar" para trocar dados. Portanto, ao implementar um serviço desse tipo usando Spring, é essencial saber como chamar um endpoint REST exposto por outro serviço.

![[Capítulo 11 - Consuming REST endpoints.png]]
- Um endpoint REST é uma maneira para se implementar comunicação entre dois aplicativos. Um desses aplicativos expõe uma funcionalidade tornando-a acessível através do protocolo HTTP.
- Com frequência, múltiplos aplicativos compõem o backend. Esses aplicativos com frequência se comunicam via serviços REST. Portanto, um aplicativo precisa chamar o endpoint exposto por outro aplicativo.

Neste capítulo, aprenderemos três formas de chamar endpoints REST a partir de uma aplicação Spring:
1. #OpenFeign - uma ferramenta oferecida pelo projeto Spring Cloud. Recomendo que os desenvolvedores utilizem esse recurso em novas aplicações para consumir endpoints REST.
2. #RestTemplate - uma ferramenta conhecida que os desenvolvedores vêm utilizando desde o Spring 3 para realizar chamadas a endpoints REST. O *RestTemplate* ainda é amplamente utilizado em aplicações Spring atualmente. No entanto, como discutiremos neste capítulo, o OpenFeign é uma alternativa superior ao RestTemplate. Portanto, se estivermos trabalhando em uma nova aplicação, provavelmente evitaremos o RestTemplate e usaremos o OpenFeign em seu lugar.
3. #WebClient - um recurso do Spring apresentado como uma alternativa ao RestTemplate. Essa ferramenta utiliza uma abordagem de programação diferente, chamada de **programação reativa**, que discutiremos no final deste capítulo.

A primeira funcionalidade do Spring que discutiremos, na seção 11.1, é o #OpenFeign, ele faz parte da família #Spring-Cloud e é um recurso que recomendo para todas as novas implementações atualmente. Veremos que ele oferece uma sintaxe simples e torna a chamada de um endpoint REST a partir de uma aplicação Spring bastante direta.

Na seção 11.2, usaremos o **RestTemplate**. Mas atenção! O RestTemplate entrou em modo de manutenção a partir do Spring 5 e, eventualmente, será depreciado. Então, por que estou ensinando sobre ele? A maioria dos projetos Spring atuais utiliza o RestTemplate para chamar endpoints REST, pois eles foram iniciados quando essa era a única ou a melhor solução para implementar tal funcionalidade. Para algumas dessas aplicações, as capacidades do RestTemplate são suficientes e funcionam bem, então substituí-las não faz sentido. Além disso, o tempo necessário para substituir o RestTemplate por uma solução mais moderna pode ser muito custoso. Por isso, aprender sobre ele ainda é essencial para um desenvolvedor Spring.

Aqui está um fato interessante que geralmente causa confusão entre os estudantes. Na documentação do #RestTemplate, o #WebClient é recomendado como uma substituição para o uso do RestTemplate. Na seção 11.3, explicarei por que usar o WebClient nem sempre é a melhor alternativa ao RestTemplate. Discutiremos o WebClient e esclareceremos quando é mais apropriado utilizar esse recurso.

Para ensinar essas três abordagens fundamentais, implementaremos um exemplo para cada uma delas. Primeiro, criaremos um projeto que expõe um endpoint. Nosso objetivo é chamar esse endpoint em cada uma das abordagens discutidas neste capítulo: #OpenFeign, #RestTemplate e #WebClient.

Suponha que estejamos implementando uma aplicação que permite aos usuários realizar pagamentos. Para efetuar um pagamento, precisamos chamar um endpoint de outro sistema. A figura 11.2 ilustra visualmente esse cenário, enquanto a figura 11.3 detalha o cenário mostrando as informações da requisição e da resposta.

![[Capítulo 11 - Consuming REST endpoints-1.png]]

1. O usuário interage com o aplicativo front-end em um navegador web;
2. O aplicativo que nós implementamos precisa chamar o endpoint /payment exposto por um serviço de pagamento;
3. O service Payment implementa um endpoint Rest. Para o nosso cenário, nós assumimos que um aplicativo precisa chamar um endpoint para fazer o pagamento.

Quando realizamos o pagamento, o frontend chama o endpoint /payment do aplicativo, o qual no mesmo momento irá chamar o endpoint service de payment.

![[Capítulo 11 - Consuming REST endpoints-2.png]]
- Quando nós chamamos o endpoint /payment, nós fornecemos um request body no formato de um objeto Payment;
- O app também chama a classe service payment, enviando o mesmo body request e adicionando um request header com nome de *requestId* com um valor aleatório. POST /payment | requestId: < some random ID> {"amount":1000}. 
- O service payment responde com o objeto de pagamento, para o qual está com a assinatura com um ID. O aplicativo recebe está resposta e envia em um resposta HTTP de volta.

Modelaremos o pagamento com a classe *Payment*, como apresentada in the next code snippet:
```java
public class Payment {
	private String id;
	private double amount;

	// Omitted getters and setters
}
```
Listing 11.1 shows the endpoint's implementation in the controller class. Technically, it doesn't do much. O método recebe uma instância de *Payment* e define um ID aleatório para o pagamento antes de retorná-lo. O endpoint é simples, mas suficiente para nossa demonstração. Utilizaremos o método HTTP POST. Precisamos especificar um cabeçalho de solicitação (request header) e o corpo da solicitação (request body). Quando chamado, o endpoint retorna um cabeçalho na resposta HTTP (response header) e o objeto Payment no corpo da resposta (response body).

---
**Aula SOBRE UUID NO Java**
O #UUID (Universally Unique Identifier) é um identificador único universal de 128 bits usado para garantir a unicidade entre sistemas distribuídos. No Java, ele é fornecido pela classe *java.util.UUID*.

## 📌 **1. O que é um UUID?**
Um UUID é uma sequência hexadecimal no formato padrão:
```plaintext
`550e8400-e29b-41d4-a716-446655440000`
```
Ele é composto por 5 grupos de caracteres separados por hífens.

Exemplo real de um UUID
`f47ac10b-58cc-4372-a567-0e02b2c3d479`

Os UUIDs são amplamentes usados para identificação única em banco de dados, sistemas distribuídos, APIs REST, etc.

O Java oferece suporte nativo à geração de UUIDs com a classe *java.util.UUID*.

- Gerando um UUID aleatório
```java
import java.util.UUID;

public class UUIDExample {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println("UUID Gerado: " + uuid);
	}
}
```

## 11.1 Calling REST endpoints using Spring Cloud OpenFeign
Nesta seção, we discuss a modern approach for calling REST endpoints from a Spring app. In most apps, developers have used *RestTemplate* (that we'll discuss in section 11.2). 

With #OpenFeigm, as you'll find out in the example we write in this section, you only need to write an interface, and the tool provides you with the implementation.

Para ensinar como o #OpenFeign funciona, criaremos o projeto *sq-ch11-ex1* e implementaremos um aplicativo que usa o OpenFeign para chamar o endpoint exposto pelo aplicativo sq-c11-payments.

Definiremos uma interface onde declaramos os métodos que consomem endpoints REST. A única coisa que precisamos fazer é anotar esses métodos para definir o caminho, o método HTTP e, eventualmente, parâmetros, cabeçalhos e o corpo da solicitação.

O interessante é que não precisamos implementar os métodos nós mesmos. Definimos os métodos da interface com base nas anotações, e o Spring sabe como implementá-los.

![[Capítulo 11 - Consuming REST endpoints-3.png]]

- Para implementar a chamada ao endpoint REST usando o OpenFeign, precisamos apenas definir uma interface e usar anotações para instruir o OpenFeign sobre como implementar essa interface.
- OpenFeign implementa a interface fornecida e define um bean da implementação no Spring context.

**O que acontece no diagrama?**
1. O cliente faz uma requisição HTTP POST para */payment*;
	A requisição chega ao *PaymentsController*, que tem um método anotado com *@PostMapping("/payment")*

2. O *PaymentController* usa *PaymentsProxy*
	O *controller* não chama diretamente o serviço externo.
	Ele delega a chamada para uma interface chamada *PaymentsProxy*

3. O OpenFeign implementa automaticamente o PaymentsProxy
	A interface *PaymentsProxy* define um contrato (método *createPayment()*), mas não tem implementação.
	 O OpenFeign cria uma implementação dessa interface de forma automática.

4. **O OpenFeign chama o serviço de pagamento externo.**
	- A implementação gerada faz a requisição HTTP para o endpoint `/payment` do **Payment Service**.
	- Isso acontece de forma transparente, sem que você precise implementar um `RestTemplate` ou `WebClient` manualmente

5. **O resultado retorna para o Controller e depois para o cliente.**
	- A resposta da requisição ao serviço de pagamento externo volta pela interface **PaymentsProxy**.
	- O **PaymentsController** recebe o resultado e devolve a resposta ao cliente que fez a requisição inicial.

Assim que tivermos nossa dependência configurada, podemos criar a interface de proxy (conforme apresentado na figura 11.5). Na terminologia do OpenFeign, também chamamos essa interface de *client OpenFeign*. O OpenFeign implementa essa interface, então não precisamos em escrever o código que chama o endpoint. Só precisamos usar algumas anotações específicas para informar ao OpenFeign como enviar a solicitação. A listagem a seguir mostra como é simples:

A primeira coisa a fazer é anotar a interface com a anotação *@FeignClient* para informar ao OpenFeign que ele deve fornecer uma implementação para esse contrato. Precisamos atribuir um nome ao proxy usando o atributo *name* da annotação *@FeignClient*, que o OpenFeign utiliza internamente. O nome identifica exclusivamente o cliente em seu aplicativo. A anotação *@FeignClient* também é onde especificamos o URI base da solicitação. Podemos definir o URI base como uma string usando o atributo URL da anotação *@FeignClient*.

[[PaymentsProxy.java]]

**NOTA:** certifique-se de sempre armazenar URLs e outros detalhes que possam variar de um ambiente para outro nos arquivos de propriedades e nunca os codifique diretamente no aplicativo.

Cada método que declaramos na interface representa uma chamada a um endpoint REST. 

Usamos as mesmas anotações que aprendemos no capítulo 10 para as ações do controller que expõem endpoints REST:
- Para especificar o caminho e o método HTTP: @GetMapping, @PostMapping, @PutMapping e assim por diante...
- Para especificar um cabeçalho da solicitação: *@RequestHeader*;
- Para especificar o corpo da requisição da solicitação: *@RequestBody*.

Acho esse aspecto de reutilizar as anotações muito benéfico. Aqui, com "reutilizar as anotações", quero dizer que o OpenFeign usa as mesmas anotações que utilizamos ao definir os endpoints. Não precisamos aprender algo específico para o OpenFeign Basta usar as mesmas anotações que são usadas para expor endpoints REST nas classes controllers do Spring MVC.

O OpenFeign precisa saber onde encontrar as interfaces que definem os contratos dos clientes. Usamos a anotação @EnableFeignClients em uma classe de configuração para habilitar a funcionalidade do OpenFeign e informar ao OpenFeign onde procurar pelos contratos dos clientes.

[[Spring Start Here/codes/sq-ch11-openfeign/src/main/java/org/example/main/config/ProjectConfig.java|ProjectConfig]]
Agora podemos injetar o client OpenFeign por meio da interface que definimos na listagem 11.2. Assim que habilitamos o OpenFeign, ele sabe como implementar as interfaces anotadas com *@FeignClient*. No capítulo 5, discutimos que o Spring é inteligente o suficiente para fornecer uma instância de bean do seu contexto quando usamos uma abstração, e é exatamente isso que fizamos aqui. A listagem a seguir mostra a classe de controller que injeta o FeignClient:
