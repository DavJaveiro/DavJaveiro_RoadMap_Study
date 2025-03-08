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

---
## 1. **Criação da Interface Proxy (PaymentsProxy.java)**
A interface *PaymentsProxy* usa a anotação *@FeignClient* para indicar que essa interface será implementada dinamicamente pelo OpenFeign para chamar o serviço de pagamentos.

```java
@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {

	@PostMapping("/payment")
	Payment createPayment(
		@RequestHeader String requestId,
		@RequestBody Payment payment
	);
}
```

- *@FeignClient(name = "payments", url = "${name.service.url}")*:
	- Define o cliente Feign com o nome *payments*;
	- A declaração *url = "${name.service.url}"* define dinamicamente a URL do serviço de pagamentos (configurada no application.properties);

- *@PostMapping("/payment"):* indica que esse método será chamado via uma requisição HTTP Post para o endpoint */payment* no serviço de pagamentos. 

## 2. Como OpenFeign Interage com o Serviço de Pagamentos
A segunda imagem descreve bem o fluxo da requisição:
1. Um cliente faz uma requisição *POST /payment* para a aplicação Feign (porta 8081);
2. O *PaymentsController* recebe essa requisição e chama o método *createPayment()* da interface *PaymentsProxy*;
3. Como essa interface foi anotada com *@FeignClient*, o OpenFeign cria automaticamente uma implementação dessa interface.
4. Essa implementação gera uma requisição HTTP e a envia para o *Service Payment* rodando na porta 8080;
5. O Service Payment recebe a requisição, processa o pagamento e retorna a resposta.
6. O OpenFeign recebe essa resposta e retorna o resultado para o *PaymentsController*, que por sua vez devolve a resposta ao cliente original.
---

## 11.2 Calling REST endpoints using RestTemplate
Nesta seção, implementaremos novamente o aplicativo que chama o endpoint */payment* do serviço de pagamento, mas desta vez usando uma abordagem diferente: o *RestTemplate*.

O *RestTemplate* está sendo aposentado não porque não funciona corretamente ou porque não é uma boa ferramenta, mas, à medida que os aplicativos evoluíram, começamos a precisar de mais capacidades. Os desenvolvedores queriam poder se beneficiar de diferentes funcionalidades que não são fáceis de implementar com o *RestTemplate*, tais como:
- Chamar endpoints de forma síncrona e assíncrona;
- Escrever menos código e tratar menos exceções (eliminar código repetitivo);
- Repetir a execução de chamadas e implementar operações de fallback (lógica executada quando o aplicativo não consegue realizar uma chamada REST específica por qualquer motivo).

Em outras palavras, os desenvolvedores preferem obter mais funcionalidades prontas para uso, uma vez de implementá-las sempre que possível. Lembre-se de que reutilizar código e evitar código repetitivo é um dos principais objetivos dos frameworks. 

**NOTA:** aqui está uma boa lição que aprendi com minha experiência: quando algo é chamado de "depreciado" ou "legado", isso não significa necessariamente que não devamos aprendê-lo. Às vezes, tecnologias depreciadas ainda são usadas em projetos muitos anos após serem declaradas como tal, incluindo o *RestTemplate* e o projeto Spring Security OAuth. 

Com relação ao Spring Security OAuth, a recomendação é utilizar o Spring Security 5 (com o OAuth 2.0 nativo).

Os passos para definir a chamadas são os seguintes:
1. **Definir os cabeçalhos HTTP** criando e configurando uma instância de *HttpHeaders*;
2. **Ciar uma instância de HttEntity** que representa os dados da solicitação (cabeçalhos e corpo);
3. **Enviar a chamada HTTP** usando o método *exchange()* e obter a resposta HTTP.

![[Capítulo 11 - Consuming REST endpoints-4.png]]

Começamos a implementar este exemplo no projeto sq-ch11-ex2. Na listagem 11.5, encontramos a definição da classe proxy. Observe como o método createPayment() define o cabeçalho criando uma instância de HttpHeaders e adicionando o cabeçalho necessário "requestId" a essa instância usando o método add(). 

[[Spring Start Here/codes/sq-ch11-resttemplate/src/main/java/org/example/main/proxy/PaymentsProxy.java|PaymentsProxy]]

Nós definimos um endpoint simples para chamar essa implementação, da mesma forma que fizemos para o pequeno endpoint que chamamos na seção 11.11. O próximo trecho de código mostra como definir a classe do controller:
[[PaymentsController.java]]

## 11.3 Calling REST endpoints using WebClient
Nesta seção, discutimos o uso do WebClient para chamar endpoints REST. O WebClient é uma ferramenta utilizada em diferentes aplicações e é construído com base em uma metodologia que chamamos de abordagem reativa. A metodologia reativa é uma abordagem avançada, e eu recomendo estudá-la assim que dominarmos bem os conceitos básicos. Um bom ponto de partida é a leitura dos capítulos 12 e 13 do livro *Spring in Action*.

A documentação do Spring recomenda o uso do WebClient, mas essa recomendação só é válida para <span style="background:#d4b106">aplicações reativas</span>. Se não estivermos desenvolvendo uma aplicação reativa, use o OpenFeign. Como tudo no desenvolvimento de software, ele se encaixa bem em alguns casos, mas pode complicar outros. Escolher o WebClient para implementar a endpoints está fortemente acoplado à decisão de tornar a nossa aplicação reativa.

**NOTA:** Se não decidirmos implementar uma aplicação reativa, use o OpenFeign para implementar as capacidades REST. Se implementarmos uma aplicação reativa, devemos utilizar uma ferramenta reativa adequada: o WebClient.

Embora as aplicações reativas estejam um pouco além dos conceitos básicos, eu gostaria de garantir que saibamos como é o uso do WebClient e como essa ferramenta difere das outras que discutimos até agora, para que possamos comparar as abordagens. Vamos falar sobre aplicações reativas e, em seguida, usar o WebClient para chamar o endpoint /payment que utilizamos como exemplo nas seções 11.1 e 11.2. Em uma aplicação não reativa, uma thread executa um fluxo de negócios. Várias tarefas compõem um fluxo de negócios, mas essas tarefas não são independentes. A mesma thread executa todas as tarefas que compõem um fluxo. Vamos usar um exemplo para observar onde essa abordagem pode enfrentar problemas e como podemos melhorá-la.

Suponha que implementemos uma aplicação bancária onde um cliente do banco tem uma ou mais contas de crédito. O componente do sistema que implementamos <span style="background:#d4b106">calcula o débito total de um cliente do banco</span>. Para usar essa funcionalidade, outros componentes do sistema fazem uma chamada REST para enviar um ID único do usuário. Para calcular esse valor, o fluxo que implementamos inclui as seguintes etapas:
1. O aplicativo recebe o ID do usuário;
2. Ele chama um serviço diferente do sistema para verificar se o usuário tem créditos com outras instituições;
3. Se o usuário tiver dívidas externas, ele chama um serviço externo para obter o valor da dívida externa;
4. O aplicativo soma as dívidas e retorna o valor em uma resposta HTTP.

![[Capítulo 11 - Consuming REST endpoints-5.png]]
2. A funcionalidade que implementamos precisa primeiro chamar outro serviço do sistema para obter os detalhes do usuário. Quando fazemos isso, o aplicativo aguarda a resposta antes de prosseguir para a etapa 3. Qualquer solicitação a outro componente é uma chamada I/O, o que leva algum tempo. A thread que executa essa chamada fica bloqueada e não pode fazer outra coisa enquanto aguarda.

3. Ao executar a etapa 3, o aplicativo faz novamente uma chamada de I/O para obter o débito interno do usuário. A thread fica bloqueada novamente enquanto o aplicativo realizada a chamada.

![[Capítulo 11 - Consuming REST endpoints-6.png]]

Esses são apenas passos fictícios de uma funcionalidade, mas eu os projetei para demonstrar onde o uso de uma aplicação reativa pode ser útil. Vamos analisar essas etapas com mais detalhes. A figura acima apresenta a execução do cenário do ponto de vista da thread. A thread precisa aguardar o término de uma etapa antes de prosseguir para a próxima e fica bloqueada sempre que espera o aplicativo realizar uma chamada I/O.

  1. A thread fica ociosa enquanto uma chamada de I/o a bloqueia. Em vez de utilizar a thread, permitimos que ela permaneça ocupando a memória do aplicativo. Consumimos recursos sem obter nenhum benefício. Com essa abordagem, podemos ter casos em que o aplicativo recebe 10 solicitações simultâneas, mas todas as threads ficam ociosas ao mesmo tempo enquanto aguardam detalhes de outros sistemas. 
  2. Algumas das tarefas não dependem umas das outras. Por exemplo, o aplicativo poderia executar a etapa 2 e a etapa 3 ao mesmo tempo. Não há motivo para o aplicativo esperar o término da etapa 2 antes de executar a etapa 3. O aplicativo só precisa, no final, do resultado de ambas para calcular o débito total.

#Reactive apps mudam a ideia de termos apenas um único fluxo atômico no qual uma thread executa todas as tarefas do início ao fim. Com aplicações reativas, pensamos em tarefas como independentes, e múltiplas threads podem colaborar para completar um fluxo composto por várias tarefas.

Em vez de imaginar essa funcionalidade como etapas em uma linha do tempo, imagine-a como um backlog de tarefas como uma aplicação reativa funciona: os desenvolvedores são as threads, e as tarefas no backlog são as etapas de uma funcionalidade.

Para esta demonstração, usaremos os projetos sq-ch11-payments (o serviço de pagamentos) e sq-ch11-weblcient. Utilizamos o serviço de pagamentos anteriores, ele expõe o endpoint /payment acessível usando o método HTTP Post. Para o aplicativo desta seção, usaremos o WebClient para enviar solicitações ao endpoint exposto pelo serviço de pagamentos. 

Como o webclient impõe uma abordagem reativa, precisamos adicionar uma dependência chamada WebFlux em vez da dependência web padrão. O próximo trecho de código mostra a <span style="background:#d4b106">dependência do WebFlux</span>, que podemos adicionar ao nosso arquivo pom.xml ou selecionar ao construir o projeto usando o start.spring.io:

```properties
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux -->  
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-webflux</artifactId>  
    <version>3.4.3</version>  
</dependency>
```

Para chamar o endpoint REST, precisamos usar uma isntância do WebClient. A melhor maneira de criar acesso fácil é colocá-la no contexto do Spring usando a anotação *@Bean* com um método de classe de configuração, como aprendemos no capítulo 2. O próximo código mostra a classe de configuração do aplicativo.
[[Spring Start Here/codes/sq-ch11-webclient/src/main/java/org/example/main/config/ProjectConfig.java|ProjectConfig]]

O código abaixo mostra a implementação da classe proxy, que usa o WebClient para chamar o endpoint exposto pelo aplicativo. A lógica é semelhante ao que já aprendemos com o RestTemplate. Obtemos a URL base do arquivo de propriedades; especificamos o método HTTP, os cabeçalhos e o corpo; e executamos a chamada. Os nomes dos métodos do WebClient são diferentes, mas é bastante fácil entender o que eles fazem após ler seus nomes.

[[Spring Start Here/codes/sq-ch11-webclient/src/main/java/org/example/main/proxy/PaymentsProxy.java|PaymentsProxy]]

Essa demonstração, usamos uma classe chamada Mono. Essa classe define um produto. No código, encontramos esse caso, onde o método que realiza a chamada não recebe a entrada diretamente. Ao invés disso, enviamos um Mono. Dessa forma, podemos criar uma tarefa independente que fornece o valor do corpo da solicitação. O WebClient que se inscreve nessa tarefa se torna dependente dela.

O método também não retorna um valor diretamente. Em vez disso, ele retorna um Mono, permitindo que outra funcionalidade se inscreva nele. Dessa forma, o aplicativo constrói o fluxo, não encadeando-os em uma thread, mas vinculando as dependências entre tarefas por meio de produtos e consumidores. 

![[Capítulo 11 - Consuming REST endpoints-7.png]]

