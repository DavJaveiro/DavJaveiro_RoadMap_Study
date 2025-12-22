## Programando Funções AWS Lambda
Este capítulo trata de aprofundar o que significa construir funções Lambda - como elas se parecem, como configuramos a execução e como especificamos nossa própria configuração ambiental. Aprenderemos sobre esses tópicos examinando os conceitos centrais para ambientes de execução Lambda, entrada e saída, *timeout*, memória e CPU e, finalmente, como Lambda usa variáveis de ambiente para configuração da aplicação. Para começar, vamos dar uma olhada  em como as funções Lambda são executadas. 

## Conceitos Centrais: Modelo de Runtime, Invocação
No Capítulo 2, criamos uma classe Java, fizemos o upload para o serviço Lambda em algum lugar na "nuvem" nebulosa e, magicamente, conseguimos executar aquele código. Não precisamos considerar sistemas operacionais, contêineres, scripts de inicialização, deploy do código em um host real ou configuração da JVM. Não precisamos pensar em nenhum daqueles irritantes "servidores". Então, como o nosso código foi executado? Para entender isso, precisamos primeiro compreender o básico do ambiente de execução Lambda.

!![image-202512223636620.png](/image-202512223636620.png)

## O Ambiente de Execução Lambda
Como mencionamos no Capítulo 2, tanto o gerenciamento da AWS quanto as operações da função (frequentemente referidos como plano de controle e plano de dados, respectivamente) fazem uso extensivo de APIs. O Lambda não é diferente e oferece uma API tanto para o gerenciamento de funções quanto para a execução delas. Uma função é executada, ou invocada, sempre que o comando *invoke* da API do AWS Lambda é chamado. Isso acontece nos seguintes momentos:
- Quando uma função é acionada por uma fonte de eventos (*event source*);
- Quando usamos a ferramenta de teste no console web;
- Quando chamamos *invoke* da API Lambda por conta própria, tipicamente via CLI ou SDK, a partir do nosso próprio código ou scripts;

Invocar uma função pela primeira vez iniciará a seguinte cadeia de atividade que terminará na execução do nosso código. Primeiro, o serviço Lambda criará um ambiente Linux hospedeiro, uma micro máquina leve. Tipicamente não precisaremos nos preocupar com a natureza precisa de que tipo de ambiente é esse (qua kernel, qual distribuição, etc.), mas caso precisemos, a Amazon torna essa informação pública. 

Uma vez que o ambiente hospedeiro tenha sido criado, o Lambda iniciará um runtime de linguagem dentro dele, em nosso caso, uma Máquina Virtual Java (JVM). 

A  JVM é iniciada com um conjunto de flags de ambiente que não podemos alterar. 

A aplicação Java de nível superior é o próprio servidor de aplicação Java da Amazon, ao qual nos referiremos como **Lambda Java Runtime**. Esse é o próximo componente a ser iniciado. O runtime é responsável pelo tratamento de erros de nível superior, logs e muito mais. A principal preocupação do Lambda Java Runtime é executar nosso código. Os passos finais da cadeia de invocação são:
1. carregar nossas classes Java
2. chamar o método *handler* (manipulador) que especificamos durante o deploy;

## Tipos de Invocação
O SAM CLI possuí um nível mais alto de abstração. A AWS CLI está um pouco mais próxima das entranhas da máquina AWS. Especificamente, vamos usar um comando na AWS CLI para chamar funções Lambda: *aws lambda invoke*.

Quando chamamos *invoke*, especificamos --invocation-type RequestResponse, isso significa que estamos chamando a função de forma  *síncrona* (ou seja, o runtime Lambda chama nosso código e espera pelo resultado). O comportamento **síncrono** (ou seja, o runtime Lambda chama nosso código e espera pelo resultado). O comportamento síncrono é útil para cenários como APIs web...

Agora, vamos mudar a flag para *--invocation-type Event*
O resultado agora retorna um *StatusCode: 202*. Dessa vez, chamamos a função de forma *assíncrona*. O runtime Lambda chama nosso código precisamente como antes, mas não espera nem utiliza o valor retornado pelo nosso código, esse valor é descartado. O objetivo da execução assíncrona é que possamos realizar um "efeito colateral" em outra função ou serviço (como fazer upload de um arquivo para o S3).

De forma assíncrona, estamos **disparando (triggering)** a execução da Lambda de forma **assíncrona**. 

## Introdução a Logging
O runtime Lambda captura qualquer coisa escrita pela nossa função nos fluxos de processo de saída padrão ou erro padrão. Em termos de Java, isso corresponde a *System.out* e *System.err*. Uma vez que o runtime Lambda capturou esses dados, ele os envia para o **CloudWatch Logs**. Nenhum programador Java bom e que se preze faz log de produção real *System.out.println*, no entanto, frameworks de logging dão muito mais flexibilidade e controle sobre o comportamento de log.

## Entrada, Saída
Quando uma função Lambda é executada, sempre é passado a ela um argumento de entrada, tipicamente referido como um **evento**. Dentro do ambiente de execução Lambda, esse evento é especificamente sempre um valor JSON. O JSON que criamos em nossos testes, ou que vem de fontes de eventos, é passado para o Lambda Java Runtime. Na maioria dos casos de uso, o Lambda Java Runtime desserializará automaticamente esse payload JSON para nós. 

**Métodos Java Lambda válidos** devem se encaixar em uma das quatro assinaturas a seguir:
- output-type handler-name(input-type input)
- output-type handler-name(input-type input, Context context)
- void handler-name(InputStream is, OutputStream os)
- void handler-name(InputStream is, OutputStream os, Context context).
Onde:
**input-type** e **output-type** podem ser tipos primitivos Java ou tipos serializáveis em JSON.

- Context refere-se a `com.amazonaws.services.lambda.runtime.Context`

O #Context permite que a função Lambda acesse informações sobre a execução, como request ID, tempo restante, limites de memórias e logs, sem depender do evento de entrada.

Ele não é payload de entrada, **não vem do cliente**, não é parte do evento. 

Evento (input-type) = dados

```java
package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Hello implements RequestHandler<Object, String> {
    public String handleRequest(final Object input, final Context context) {
        System.out.println(input);
        return "Hello from Lambda!";
    }
}

```

**Insights**
- Java e Spring Framework
	**Abstração com Spring Cloud Function:** o texto mostra a assinatura "crua" do SDK da AWS (*handler-name(input, context)*). No mundo moderno de Spring Boot, raramente escrevemos isso. Utilizamos o **Spring Cloud Function**, onde definimos apenas um Bean funcional: java.util.function.Function< Entrada, Saída>. O Spring cuida de adaptar isso para a assinatura que o Lambda espera.
	- *Exemplo*: em vez de implementar RequestHandler, apenas criamos um @Bean public Function<String, String> uppercase() 
	- Java Records (DTOs): o texto menciona que o runtime desserializa JSON automaticamente. Com versões modernas do Java (17+), use #Records para seus DTOs de entrada e saída. O Jackson (usado pelo Spring e Lambda) mapeia JSON para Records perfeitamente, garantindo imutabilidade e código mais limpo sem o boilerplate de Getters/Setters.

### Boas Práticas de Documentação & Logs
- **O perigo do `System.out`:** O autor alerta corretamente contra `System.out`. Em Java + Spring na AWS, use **SLF4J** com **Logback** ou **Log4j2**.
- **Logs Estruturados (JSON):** Configure seu logger para emitir logs em formato JSON (uma linha de JSON por log). Isso permite que o **CloudWatch Logs Insights** faça queries poderosas (ex: `filter level = "ERROR"`), algo impossível com logs de texto puro gerados por `System.out`.

### DevOps & SDKs
- **SAM vs CDK/Terraform:** O texto usa SAM (`template.yaml`). Embora o SAM ainda seja ótimo para _serverless_ puro, o mercado corporativo migrou fortemente para **AWS CDK (Java/TypeScript)** ou **Terraform**. O CDK permite definir sua infraestrutura (o Lambda, as permissões IAM) usando o próprio Java, o que é muito mais poderoso para quem já é desenvolvedor backend.

**Cold Start (Inicialização a Frio):** O texto descreve a criação da "micro máquina virtual" e do runtime Java. Esse processo é o famoso _Cold Start_, que é lento no Java.
- _Dica de Ouro:_ Para mitigar isso em produção com Spring Boot, você **deve** usar o **AWS Lambda SnapStart** (disponível para Java 11, 17 e 21). Ele tira um "snapshot" da memória após a inicialização e restaura quase instantaneamente nas próximas execuções.


*Handler*: o handler é o ponto de entrada de nossa função Lambda, é o método que a AWS chama quando a nossa função é executada. 

**Interface:** RequestHandler<I, O>
I e O são tipos genéricos, 
- (Input) tipo de parâmetro de entrada #Object. 
- *Output* tipo de retorno String. 

**Parte 2: Método handleRequest**
```java
public String handleRequest(final Object input, final Context context)
```
1. *input:* dados que recebemos quando a função é invocada.
	- Pode ser um *String*, *Map*, *List*, ou qualquer outro objeto.
	- No exemplo: Object (aceita qualquer coisa).
- *Contexto:* objeto com informações sobre a execução. Contém ID da execução, tempo restante, nome da função, etc.
**Retorno** é o que a nossa função responde. 

**Exemplo 1: Chamada Simples**
```bash
# Quando você chama a Lambda com:
{ "nome": "João" }

# O que acontece:
input = { "nome": "João" }  // Como Object
context = informações da execução
return = "Hello from Lambda!"
```

1. Evento chega → { "temperatura": 25 }
   ↓
2. AWS Lambda instancia sua classe `Hello`
   ↓
3. Chama: hello.handleRequest(evento, contexto)
   ↓
4. Seu código processa
   ↓
5. Retorna resultado → "Hello from Lambda!"
   ↓
6. AWS devolve para quem chamou

**Tipos Comuns de Handler**
```Java
public class Pedido {
	private String id;
	private double valor;
	// getters/setters
}
```

```java
public class Processador implements RequestHandler<Pedido, String> {
	public String handleRequest(Pedido pedido, Context context) {
		return "Processador pedido: " + pedido.getId();
	}
}
```

**Com MAP (para JSON flexível)**
```java
public class Handler implementes RequestHandler<Map<String, Object<, Map<String, Object>> {
	public Map<String, Object> handleRequest(Map<String, Object> input, Context context)
	{
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", code 200);
		response.put("body", "Sucesso!");
		return response;
	}
}
```

**Para API Gateway (muito comum)**
```java
public class ApiHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayResponseEvent> {
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
		// Processa requisição HTTP
		return new APIGatewayProxyResponseEvent()
			.withStatusCode(200)
			.withBody("{\"message\":\"OK"\}");
	}
}
```

Na configuração da Lambda, precisamos especificar:
- Handler: example.Hello::handlerRequest
- Formato: `pacote.Classe::método`
## Configurando a Função Handler no Template SAM
