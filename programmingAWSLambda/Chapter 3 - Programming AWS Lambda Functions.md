## Programando Funções AWS Lambda
Este capítulo trata de aprofundar o que significa construir funções Lambda - como elas se parecem, como configuramos a execução e como especificamos nossa própria configuração ambiental. Aprenderemos sobre esses tópicos examinando os conceitos centrais para ambientes de execução Lambda, entrada e saída, *timeout*, memória e CPU e, finalmente, como Lambda usa variáveis de ambiente para configuração da aplicação. Para começar, vamos dar uma olhada  em como as funções Lambda são executadas. 

## Conceitos Centrais: Modelo de Runtime, Invocação
No Capítulo 2, criamos uma classe Java, fizemos o upload para o serviço Lambda em algum lugar na "nuvem" nebulosa e, magicamente, conseguimos executar aquele código. Não precisamos considerar sistemas operacionais, contêineres, scripts de inicialização, deploy do código em um host real ou configuração da JVM. Não precisamos pensar em nenhum daqueles irritantes "servidores". Então, como o nosso código foi executado? Para entender isso, precisamos primeiro compreender o básico do ambiente de execução Lambda.

!![image-202512223636620.png](/image-202512223636620.png)

## O Ambiente de Execução Lambda
Como mencionamos no Capítulo 2, tanto o gerenciamento da AWS quanto as operações da função (frequentemente referidos como plano de controle e plano de dados, respectivamente) fazem uso extensivo de APIs. <span style="background:#d3f8b6">O Lambda não é diferente e oferece uma API tanto para o gerenciamento de funções quanto para a execução delas</span>. Uma função é executada, ou invocada, sempre que o comando *invoke* da API do AWS Lambda é chamado. Isso acontece nos seguintes momentos:
- Quando uma função é acionada por uma fonte de eventos (*event source*);
- Quando usamos a ferramenta de teste no console web;
- Quando chamamos *invoke* da API Lambda por conta própria, tipicamente via CLI ou SDK, a partir do nosso próprio código ou scripts;

Invocar uma função pela primeira vez iniciará a seguinte cadeia de atividade que terminará na execução do nosso código. 
1. Primeiro, o serviço Lambda criará um ambiente Linux hospedeiro, uma micro máquina leve. Tipicamente não precisaremos nos preocupar com a natureza precisa de que tipo de ambiente é esse (qua kernel, qual distribuição, etc.), mas caso precisemos, a Amazon torna essa informação pública. 

2. Uma vez que o ambiente hospedeiro tenha sido criado, o Lambda iniciará um runtime de linguagem dentro dele, em nosso caso, uma Máquina Virtual Java (JVM). 

3. A  JVM é iniciada com um conjunto de flags de ambiente que não podemos alterar. 

A aplicação Java de nível superior é o próprio servidor de aplicação Java da Amazon, ao qual nos referiremos como **Lambda Java Runtime**. Esse é o próximo componente a ser iniciado. O runtime é responsável pelo tratamento de erros de nível superior, logs e muito mais. A principal preocupação do Lambda Java Runtime é executar nosso código. Os passos finais da cadeia de invocação são:
1. carregar nossas classes Java
2. chamar o método *handler* (manipulador) que especificamos durante o deploy;

## Tipos de Invocação
O SAM CLI possuí um nível mais alto de abstração. A AWS CLI está um pouco mais próxima das entranhas da máquina AWS. Especificamente, vamos usar um comando na AWS CLI para chamar funções Lambda: *aws lambda invoke*.

Quando chamamos *invoke*, especificamos --invocation-type RequestResponse, isso significa que estamos chamando a função de forma  *síncrona* (ou seja, o runtime Lambda chama nosso código e espera pelo resultado). O comportamento **síncrono** (ou seja, o runtime Lambda chama nosso código e espera pelo resultado). O comportamento síncrono é útil para cenários como APIs web...

Agora, vamos mudar a flag para *--invocation-type Event*
O resultado agora retorna um *StatusCode: 202*. Dessa vez, chamamos a função de forma *assíncrona*. O runtime Lambda chama nosso código precisamente como antes, mas não espera nem utiliza o valor retornado pelo nosso código, esse valor é descartado. O objetivo da execução assíncrona é que possamos realizar um "efeito colateral" em outra função ou serviço (como fazer upload de um arquivo para o S3).

<span style="background:#d3f8b6">De forma assíncrona, estamos **disparando (triggering)** a execução da Lambda de forma **assíncrona**. </span>

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

Ele não é payload de entrada, **não vem do cliente**, não é parte do evento. Portanto, ele é **injetado automaticamente pela AWS** e contém informações da execução atual da função, como identificador da requisição, tempo restante, nome da função, versão, limites de memória e métricas básicas.

Em Java, isso é o contrato padrão do handler da Lambda. O primeiro parâmetro é o payload (JSON já desserializado para um objeto ou #Map), e o segundo é o ambiente de execução fornecido pela plataforma.

**Mapeamento**: Quando mapeamentos o JSON para um **Objeto (DTO/POJO)**, ganhamos tipagem forte, validação em tempo de compilação, código mais legível e manutenção mais segura. É o melhor caminho para APIs, eventos com schema definido e qualquer fluxo de negócio que controlamos. Em Java backend sério, esse é o padrão.

Usar **Map<String, Object>** faz sentido quando o formato varia, quando estamos criando uma função genérica (por exemplo, uma Lambda que recebe eventos diferentes), quando estamos apenas repassando dados ou fazendo inspeção parcial do payload. É comum em integrações, webhooks externos ou POCs rápidas.

O custo do #Map é perder contrato: dependemos de casts, chaves em string e erros só aparecem em runtime. Por isso, ele deve ser exceção, não a regra.

Quando estamos realizando **integração e repasse de dados**, não precisamos mapear esse JSON em objeto para depois transformá-lo novamente em JSON.

Mapear tudo para DTO **só irá adicionar custo e complexidade**, sem ganho real.

Devemos usar objeto apenas se:
- precisarmos aplicar regra de negócio
- precisarmos validar campos
- transformar significativamente a estrutura
- garantir contrato estável
- versionar a resposta



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
	- O #final no parâmetro garante que a referência não possa ser reassociada dentro do método.
- *Contexto:* objeto com informações sobre a execução. Contém ID da execução, tempo restante, nome da função, etc.

Em handler de Lambda, o *final* é usado para:
- deixar claro que o parâmetro é **somente leitura**
- evitar reassociação acidental
- reforçar intenção e clareza
- permitir uso em classes internas/lambda (quando aplicável)
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
Até agora, fizemos apenas uma mudança no arquivo de template do SAM, *template.yaml*, para alterar o nome da função. Antes de avançarmos muito, precisamos analisar outra propriedade nesse arquivo: *Handler*.

bra o arquivo `template.yaml` e você verá que `Handler` está atualmente definido como `book.HelloWorld::handler`. O que isso significa é que, para esta função Lambda, a plataforma Lambda tentará encontrar um método chamado *handler* em uma classe HelloWrold, dentro do pacote chamado *book*.

Se criarmos uma nova classe chamada *Cow* em um pacote chamado *old.macdonal.farm*, e tivermos um método chamado *moomoo* que seja a nossa função Lambda, então deveríamos definir o *Handler* como *old.macdonald.farm.Cow::moomoo*.

**Tipos Básicos:**
O Exemplo 3.1 mostra uma classe com três funções handler **Lambda** diferentes (sim, dissemos há pouco que não costumamos usar múltiplas funções Lambda por classe no uso real, mas faremos aqui por brevidade).

**Exemplo 3.1 - Serialização e desserialização de tipos básicos**
```java
package book;
public class StringIntegerBooleanLambda {
	public void handlerString(String s) {
		System.out.println("Hello, " + s);
	}
	public boolean handlerBoolean(boolean input) {
		return !input;
	}
	
	public boolean handlerInt(int input) {
		return input > 100;
	}
```

 No terceiro exemplo, estamos usando um tipo primitivo (int), mas podemos usar tipos encapsulados (*boxed types*) se preferirmos. Por exemplo, somos livres para usar *java.lang.Integer* ao invés de *int*.

O que acontece em todos os casos é que o Runtime Lambda está desserializando a entrada JSON para um tipo simples em nosso nome. Se o evento passado não puder ser desserializado para o tipo de parâmetro especificado, teremos uma falha, com uma mensagem:
`An error occurred during JSON parsing: java.lang.RuntimeException`

- **Spring Cloud Function vs. Handler puro:** o texto ensina a configuração "nativa" (`Pacote.Classe::metodo`). Porém, ao usar **Spring Cloud Function**, raramente apontamos para o nosso método de negócio diretamente no YAML. O Handler no template geralmente aponta para um adaptador genérico do Spring, como *org.springframework.cloud.function.adapteer.aws.FunctionInvoker::handleRequest*. O Spring se encarrega de rotear para o nosso @Bean (Function, Consumer ou Supplier) correto. Isso desaclopa nossa infraestrutura YAML da lógica de código (Java)
Se pensamos como **engenheiro de software**, escolhemos SCF.
Se pensamos como **engenheiro de plataforma**, escolhermos handler puro.

**Serialização:** o texto diz "O Runtime está desserializando...". No ecossistema Java, quem faz isso geralmente é o **Jackson**. 

---
**AWS X-Ray** 
É o serviço de **tracing distribuído da AWS**.
Ele serve para:
- Acompanha uma **requisição ponta a ponta**
- Medir **latência**
- Identificar **gargalos**
- Encontrar **falhas em dependências** (DB, HTTP, S3, DynamoDB etc).

Quando optamos por ativar o X-Ray na Lambda, permitimos *AwsRAYWriteOnlyAccess*, fazendo a Lambda **emitir traces automaticamente**.

No *template.yaml*, isso vira algo como:
Tracing: **Active**

Ganhamos na prática a visualização do fluxo da requisição:
API Gateway
   ↓
Lambda
   ↓
DynamoDB
   ↓
S3

Com tempos de cada etapa.

Conseguimos, a partir dessas métricas, responder perguntas como:
- O Cold Start está custando quanto?
- A lentidão está no meu código ou numa chamada externa?
- O problema é DNS, rede, SDK da AWS ou meu handler?

Diferença de Zip para Image: !![image-20251227173794.png](/image-20251227173794.png)

**Zip** é o modelo clássico de Lambda. Empacotamos o código + dependências (JAR), fazemos o upload para a Lambda, a AWS executa direto no runtime gerenciado (java17). Características:
- Runtime gerenciado pela AWS
- Sem docker
- Build rápido
- Menos controle do SO
**Vantagens:**
- Cold start menor
- build simples (*sam build*)
- Menos infra para manter
- Ideal para Java puro

**Image** a Lambda roda dentro de um **container Docker**.
Criamos um #Dockerfile, buildamos a nossa imagem, subimos no ECR e lambda executa a imagem. 
**Vantagens:**
- Runtime somos nós que definimos
- Total controle do ambiente
- Limite maior de tamanho (até 10 Gb)


---

## List and Maps
O JSON também inclui arrays e objetos/propriedades. O Runtime Java da Lambda desserializará esses elementos automaticamente para *Lists* e *Maps* do Java, respectivamente, e também serializará #Lists e #Maps de saída para arrays e objetos JSON. 

**Exemplo 3.2** - Serialização e desserialização de List e Map

*O Perigo do* Map< String, Object>: embora seja possível receber um *Map*, em Spring Boot e aplicações robustas, isso é considerado um "code smell" para lógica de negócios.
- **Por que evitar:** Mapas são fracamente tipados ("Stringly typed"). Perdemos o autocomplete da IDE, a segurança em tempo de compilação e a capacidade de refatoração segura. 
- **Solução:** sempre prefira criar um **DTO (Data Transfer Object)** ou um **Java Record**. O Jackson (biblioteca que o Spring usa por baixo dos panos) mapeia JSON para objetos melhor do que para Mapas, permitindo validações.

**Segurança**: receber dados como **Mapo** ou **Object** é um risco de segurança.
- **Mass Assignment:** se aceitamos um Mapa genérico e depois o salvamos em um banco de dados, um usuário malicioso pode injetar campos que não esperávamos.
- **Validação:** com POJOS/DTOs, podemos usar anotações do **Bean Validation** (@NotNull, @Size, @Email). Com Map, teríamos que escrever a validação de forma manual ("if keys exists..."), o que é propenso a erros.

- **Documentação (OpenAPI/Swagger)**: se usamos ferramentas para gerar documentação da nossa API Serverless, um *Map<String, String>* será documentado como um objeto genérico sem esquema definido. Um POJO *UserAddress* gerará uma documentação rica com todos os campos esperados. 

## POJOs And Ecosystem Types
Os tipos de entradas anteriores funcionam bem para entradas razoavelmente simples. Uma alternativa para tipos mais complexos é usar a serialização automática de POJO (*Plain Old Java Object*) do Runtime Java da Lambda. O exemplo 3-3 mostra um exemplo onde usamos isso tanto para entrada quanto para saída:
[[PojoLambda.java]]

Podemos usar o exemplo de código acima e enviar os seguintes dados dentro do event.json `"b" : "Input was Hello Lambda"}`. 

Olhando um pouco mais nossa função handler:
*handlerPojo()*. Ela recebe como entrada o tipo *PojoInput*, que é uma classe POJO que definimos. As classes de POJO de entrada podem ser classes estáticas aninhadas (*static nested classes*), como escrevemos aqui, ou classes regulares (externas). O importante é que elas precisam ter um construtor vazio e ter métodos *set* (setters) que sigam a nomenclatura dos campos esperados para serem desserializados a partir do JSON de entrada. Se nenhum campo JSON for encontrado com o mesmo nome de um *setter*, então o campo do POJO será deixado como *null*. 

Os objetos POJO de entrada precisam ser **mutáveis**, já que o runtime irá modificá-los após terem sidos instanciados.

Nossa função handler interroga o objeto POJO e cria uma nova instância da classe *PojoResponse*, que passamos de volta ao runtime da Lambda. O runtime da Lambda a serializa para JSON usando reflexão em todos os métodos get... Há menos limitações nas classes de saídas POJO, já que elas não são criadas ou modificadas pelo runtime da Lambda, somos livres para construí-las como quisermos e livre para torná-las imutáveis. E, assim como as classes de entrada, as classes de saída POJO podem ser classes estáticas aninhadas ou classes regulares.

Tanto para classes POJO de entrada quanto de saída, podemos aninhar outras classes POJO, usando as mesmas regras, para serializar/desserializar objetos JSON aninhados. Além disso, podemos misturar POJOs e os tipos de coleção que discutimos (Listas e Maps) em nossa entrada e saída.

O exemplo que demos anteriormente segue a maior parte da documentação que veremos online: usando uma convenção JavaBean para campos. No entanto, se não quisermos usar *setters* em nossa classe de entrada ou *getters* em nossa classe de saída, estamos livres para usarmos campos públicos. 

Um dos principais usos para desserialização de entrada POJO é quando vinculamos nossa função Lambda a uma das fontes de eventos do ecossistema AWS Lambda. Aqui está um exemplo de uma função handler que processaria o evento de um objeto carregado no serviço de armazenamento S3:
```java
public void handler(S3Event input) {
	//...
}
```

*S3Event* é um tipo que acessamos de uma dependência de biblioteca da AWS,.

---
- **Lombok é Obrigatório**: O texto mostra getters e Setters manuais. No mundo real Spring/Java, isso gera muito ruído visual.
	- **Prática:** utilizar o Projeto Lombok. Anote o nosso DTO de entrada com *@Data* (ou *@Getter* e @Setter) e *@NoArgsConstructor*. Isso mantém o código limpo e legível, essencial para manutenção.

- **Java Records (Modernização):** o texto afirma que objetos de entrada "precisam ser mutáveis" e ter "construtor vazio". 
	- Insigh Spring Boot 3 + / Java 17+: isso mudou. O Jackson agora suporta **Java Records**


---
## Streams
Se tivermos uma estrutura bastante dinâmica e/ou complicada para a qual não podemos, ou não queremos, usar nenhum dos métodos de desserialização padrão?

A resposta é usar a opção 3 ou 4 da lista de assinaturas válidas, fazendo uso de *java.io.InputStream* para o parâmetro do evento. Isso nos fornece acesso aos bytes brutos passados para a nossa função Lambda.


A assinatura para uma Lambda usando um *InputStream* é um pouco diferente, pois ela sempre tem um tipo de retorno *void*. Se recebermos um *InputStream* como parâmetro, também devemos receber um *java.io.OutputStream* como segundo parâmetro. Para retornar um resultado de tal função handler, precisamos escrever ele no *OutputStream*.

O exemplo abaixo mostra um handler que pode processar streams:
Se executarmos esse handler com a entrada "Hello World", ele escreverá "Hello World" no fluxo de saída, que se torna o resultado da função.

Podemos usar o próprio código de manipulação JSON se estivermos usando um *InputStream*, mas deixaremos isso como um exercício. Nós também devemos praticar uma boa "higiene de stream", verificação de erros, fechamento de recursos, etc.

Um uso particularmente prático desse tipo de função Lambda é em tempo de desenvolvimento, quando não conhecemos a estrutura do evento para o qual estamos codificando. O Exemplo 3-6 registrará o evento recebido nos CloudWatch Logs para que a gente possa ver o que ele é.

**Insight Valiosos**
Usar #InputStream é a maneira mais leve de executar Java na Lambda. Evitamos o overhead de reflexão *Reflection* que bibliotecas como Jackson ou Gson usam para converter JSON em POJO.

#Reflection é um recurso do Java que permite ao programa *inspecionar* e manipular classes em tempo de execução, mesmo sem conhecer essas classes em tempo de compilação.

> `O código consegue olhar para si mesmo enquanto está rodando`.

Com o #Reflection a gente consegue, em runtime:
- Descobrir nomes de classes
- Listar atributos, métodos e construtores
- Criar objetos sem usar *new*
- Invocar métodos dinamicamente
- Acessar campos *private* (se permitido)

Se a nossa Lambda precisa de latência baixíssima (millissegundos contam) ou se ela apenas repassa sem ler o conteúdo (ex: um proxy), use Streams.

**Gerenciamento de Memória (Large Payloads)**: o texto menciona "estruturas complicadas", mas o maior trunfo aqui é o volume de dados:
- **Erro Comum:** carregar um arquivo de 50MB (vindo do S3, por exemplo) em uma **String** ou POJO pode estourar a memória da Lambda ( #OutOfMemoryError). 
- **Solução:** com *InputStream*, processamos o arquivo byte a byte ou linha a linha (streaming), mantendo o uso de RAM baixo e constante, não importa o tamanho da entrada.

- **Try-with-resources**: use sempre para garantir que os streams sejam fechados, mesmo se houver exceção.                                                                                                                                                                                                                     
## Context
O que é o objeto Context?
Podemos adicionar um parâmetro *com.amazonaws.services.lambda.runtime.Context* ao final de qualquer lista de parâmetros do handler, e o runtime passará um objeto interessante que podemos usar. Vamos ver um exemplo:
![[ContextLambda.java]]

Este é o primeiro exemplo completo onde precisamos usar um tipo fora da biblioteca padrão do Java. Veremos com mais detalhes as dependências e o empacotamento no próximo capítulo... precisamos adicionar o `aws-lambda-java-core` ao nosso pom.xml.

Ao adicionarmos o Context, o `mvn package` compilará o nosso código usando a biblioteca core da Lambda fornecida pela AWS, permitindo utilizarmos a interface #Context.

O objeto #Context nos fornece informações sobre a invocação atual da Lambda. Podemos usar essa informação durante o processamento de um evento Lambda. Quando invocamos o exemplo (passando qualquer coisa como evento de entrada, ele não será usado). 

Todos os diferentes campos do Context são descritos na documentação da AWS.

A maioria desses campos permanecerá o mesmo sempre que os chamarmos durante o processamento de um evento específico, mas *getReamainigTimeInMillis()* é uma exceção notável. Ele está relacionado ao timeout, que é o que veremos a seguir.

*aws-lambda-java-core* de estar no pom.xml com o escopo *provided*. A AWS já fornece nativamente no ambiente deles. O pacote pode ficar atoa, o que piora o tempo de inicialização (Cold Start). 

## Timeout (Tempo Limite)
As funções Lambda estão sujeitas a um timeout configurável. Podemos especificar esse tempo limite ao criar a função ou atualizá-lo posteriormente na configuração da função.

O timeout no momento da escrita do material é de 15 minutos. Isso significa que a duração máxima de uma única invocação de uma função Lambda é de 15 minutos. Essa restrição é algo que a AWS pode aumentar no futuro (prevalece o tempo máximo de 900 segundos). 

Em nossos exemplos até agora, não especificamos uma configuração de timeout, então ele assume o padrão de 3 segundos. <span style="background:#affad1">Isso significa que, se nossa função não terminar a execução em 3 segundos, o Java Runtime da Lambda o abortará. </span>

Na seção anterior, analisamos o objeto Contexet. Chamar *context.getRaminingTimeInMillis()* informará quanto tempo de execução ainda temos em qualquer ponto durante a execução antes que a função seja abortada pelo runtime. Isso é útil se quisermos salvar algum estado antes que o timeout ocorra.

---
**No nosso caso:**   "getRemainingTimeInMillis": "19314":
- restavam ~19 segundos de execução no momento em que o Context foi lido.
- Timeout padrão da Lambda na AWS = 3 segundos
- NO SAM Local: o timeout assume um valor maior (normalmente 20 segundos).

---
Por que não configurar sempre o timeout para o máximo de 900 segundos (15 minutos)? Os custos da Lambda se baseiam-se significativamente no tempo de execução das funções. Se a nossa função deveria rodar por, no máximo, 10 segundos, não querermos que um bilhão de invocações levem 90 vezes mais tempo, pois seremos cobrados 90 vezes mais do que o planejado.

O timeout não inclui o tempo em que nossa função está sendo instanciada, em outras palavras, o período de timeout não começa a contar durante o *cold start*. O timeout se aplica apenas ao tempo a partir do momento em que a Lambda chama nosso método handler. Discutiremos *cold starts* mais a fundo em *Colds Starts*...

O máximo de 15 minutos é uma restrição significativa para funções Lambda, se estivermos escrevendo uma funcionalidade que precisa de mais de 15 minutos, precisaremos dividi-la em múltiplas funções Lambda orquestradas ou não usar Lambda. 

**Timeout de Banco de Dados vs. Timeout da Lambda:**
- **Regra de Ouro:** O timeout da sua conexão JDBC/JPA (Spring Data) deve ser **sempre menor** que o timeout da Lambda.
- **Exemplo:** Se a Lambda morre em 10s, configure o timeout da query do banco para 7s.
- **Por quê?** Você precisa de tempo (os 3s restantes) para capturar a `QueryTimeoutException`, logar o erro corretamente e enviar uma resposta tratada ou uma mensagem para uma _Dead Letter Queue_. Se os dois timeouts forem iguais, a Lambda é "assassinada" pela AWS antes de você conseguir logar o que aconteceu.

**Custo e o Princípio "Fail Fast":** O texto avisa sobre custos.
- **Cenário Real:** Uma integração com API de terceiro trava. Se seu timeout é 900s (15 min), sua thread Java fica parada esperando. Você paga por 15 minutos de memória RAM alocada.
- **DevOps:** Configure timeouts agressivos. Se uma operação leva normalmente 500ms, um timeout de 5 segundos é mais que suficiente. É melhor falhar rápido e retentar do que queimar dinheiro esperando um processo zumbi.

**Cold Start e Timeout:**
- O texto diz que o timeout não inclui a instanciação (Cold Start). Isso é tecnicamente verdade para o timeout de _execução_.
- **Porém:** Existe um timeout implícito de inicialização. Se o seu Spring Boot demorar mais de 10 segundos apenas para subir o contexto (Init Phase), a AWS pode matar o processo antes mesmo de chamar o `handler`, gerando um erro de "Init Duration". Com **AWS SnapStart**, isso muda drasticamente, pois a inicialização acontece no deploy, não na execução.

## Memory and CPU
As funções Lambda não têm quantidades infinitas de RAM e, de fato, cada função é configurada com uma definição de *memory-size*. A configuração padrão são 128MB, mas isso raramente é suficiente para uma função Lambda em Java de produção, então devemos tratar o tamanho da memória como algo a ser pensado ativamente para cada função.

O *memory-size* pode ser tão pequeno quanto 64MB, embora para funções Lambda em Java, provavelmente vamos usar pelo menos 256MB. O tamanho da memória deve ser um múltiplo de 64MB.

Um ponto muito importante a saber é que a configuração de *memory-size* não define apenas  quanta RAM nossa função possa usar, ela também específica quanto poder de CPU nós recebemos. De fato, o poder de processamento (CPU) de uma função Lambda escala linearmente de 64MB até 1792MB. Portanto, uma função Lambda configurada com 1024MB de RAM tem o dobro do poder de CPU de uma com 512MB de RAM.

Uma função Lambda com 1792MB de RAM recebe um núcleo de vCPU completo, configurações de RAM maiores que isso habilitam frações de um segundo núcleo virtual. Vale a pena saber disso se o nosso código não for multithread, podemos não ver uma melhoria de CPU para configurações de memória superiores a 1792MB  nesse caso.

Por qual motivo não podemos simplesmente definir sempre o *memory-size* para o máximo? A razão é custo. A AWS cobra pelas funções Lambda baseando-se em dois fatores principais:
1. Quanto tempo a função roda;
2. Quanta memória a função está especificada para usar.

Em outras palavras, dado o mesmo tempo de execução, uma função Lambda que tem 2GB de RAM custa o dobro para executar do que uma com 1GB de RAM. Ou, uma com 512MB de RAM custa 17% de uma com 3008MB. Isso, em escala, pode fazer uma tremenda diferença na conta de luz no final do mês.

Devemos sempre usar a menor quantidade de memória possível? Não, nem sempre essa é a melhor escolha. Como uma função com o dobro de memória de uma função menor também tem o dobro de poder de CPU, ela pode levar metade do tempo para executar, o<span style="background:#affad1"> que significa que o custo é o mesmo, e ela termina o trabalho mais rapidamente</span>.

O dimensionamento correto (Right-sizing) de funções Lambda é uma arte. A recomendação é que iniciemos com algo entre 512MB e 1GB e então ajustemos conforme nossas funções cresçam ou conforme precisemos escalá-las.


O código pode ser executado por até 15 minutos em uma única invocação, e uma única função pode usar até 10.240MB de memória, em incrementos de 1MB.

<iframe
  src="https://docs.aws.amazon.com/pt_br/lambda/latest/dg/gettingstarted-limits.html"
  style="width: 100%; height: 800px;"
></iframe>


**Quão cara é a Lambda?**
Ela é ótima para tarefas pequenas, com coisas que não rodam com muita frequência, mas é muito cara para aplicações "de grande porte" que atendem aplicações multiusuário em tempo real.
Vamos olhar para alguns exemplos.
Primeiro, vamos relembrar o redimensionador de fotos. Vamos dizer que configuramos essa função para usar 1.5GB de RAM, ela leva em média 10 segundos para rodar e processa 10.000 fotos por dia. A precificação da Lambda consiste em duas partes: preço por requisição, que é $\$0.20$ por milhão de requisições, e preço por duração, que é $\$0.0000166667$ por gigabyte-segundo. Portanto, precisamos calcular ambas as partes para estimar o custo do nosso redimensionador de fotos:

- O custo de requisição é $\$0.20 \times 0.01 = \$0.002$/dia, ou $\$0.06$/mês.
- O custo de duração é $10 \text{ (segundos)} \times 10,000 \text{ (invocações)} \times 1.5 \text{ (GB)} \times \$0.0000166667 = \$2.50$/dia, ou $\$75$/mês.

Obviamente, o custo de duração é a vasta maioria aqui.

$\$75$/mês é aproximadamente o mesmo custo de uma instância EC2 "m5.large" — que custa $\$70$/mês. Uma instância EC2 m5.large tem 8GB de RAM e duas CPUs, então provavelmente seria uma alternativa adequada para hospedar nosso redimensionador. No entanto, a Lambda tem benefícios significativos como solução, mesmo que os custos pareçam à primeira vista quase os mesmos:
- A Lambda não requer o custo operacional de gerenciar uma instância EC2 — não há necessidade de pensar em patches de sistema operacional, gerenciamento de usuários, etc. Portanto, nosso Custo Total de Propriedade (TCO) é menor para a Lambda.
- - A Lambda já gerencia a natureza "orientada a eventos" da aplicação, então não precisamos construir isso na versão que rodaríamos em um servidor regular.
- A Lambda fará auto-scaling sem esforço e lidará, sem preocupação, com quaisquer picos de tráfego. Uma solução baseada em servidor pode ficar sobrecarregada ou precisar ser construída para incluir buffer. De fato, quanto mais "picos" tiver a carga da sua aplicação, mais custo-efetiva a Lambda é como solução.
- A Lambda já é altamente disponível através de Zonas de Disponibilidade (AZs) — para garantir essa disponibilidade com uma solução baseada em servidor, precisaríamos dobrar ou triplicar nossos custos para duas ou três zonas.


 Insights Valiosos (Foco: Java + Spring)
- **O Mito dos 128MB para Java:** O texto sugere que 128MB é pouco. Para Spring Boot, 128MB é **proibitivo**.
    
    - **Por quê?** A JVM precisa de memória para o Heap (seus objetos), Metaspace (suas classes), Stack de Threads e o próprio compilador JIT. Se você sufocar a Lambda com pouca memória, o Garbage Collector vai rodar o tempo todo ("Stop the world"), causando timeouts e lentidão extrema.
        
    - **Recomendação:** Para Spring Boot 3, comece com **1024MB (1GB)**. Isso não é só por espaço, mas por CPU (ver abaixo).
        
- **Memória = CPU (O Segredo do Cold Start):** O texto explica que 1792MB = 1 vCPU completa.
    
    - **Insight Crítico para Spring:** O Spring Boot gasta muita CPU na inicialização (scan de componentes, criação de beans).
    - **Estratégia:** se o *Cold Start* está lento, **aumento a memória**. Frequentemente, aumentar de 512MB para 2GB faz a função inicializar 4X mais rápido. Como pagamos por tempo, o custo final pode ficar igual ou menor, mas com uma performance muito superior.
    - **Ferramenta:** Utilize o **AWS Lambda Power Tuning**. É uma ferramenta open-source que roda sua função com várias configurações de memória e plota um gráfico de "Custo vs. Performance" para você escolher o melhor ponto. A função entrada é executa em nossa conta da AWS, realizando chamadas HTTP e interagindo com o SDK em tempo real para medir a provável performance em um cenário de produção real. Também podemos implementar um processo de CI/CD para usar essa ferramenta para medir automaticamente a performance das novas funções que implantarmos.
- **Processamento de Imagens (Java vs Node/Python):**
	- Java é extremamente rápido para processamento de imagens após o aquecimento (JIT compilation), muitas vezes batendo Python. Porém o Cold Start é o mínimo.
- **vCPUs Máximas:**
	- Com o aumento da memória para 10GB, agora você pode ter até **6 vCPUs** disponíveis para sua função, o que torna o multithreading do Java extremamente poderoso.

## Variáveis de Ambiente
As duas seções anteriores trataram da configuração do próprio sistema da Lambda, mas e se quisermos usar configurações para a nossa própria aplicação?

Podemos especificar variáveis de ambiente para nossas funções Lambda. Isso nos permite alterar como nossa função é executada em diferentes contextos usando o mesmo código. É muito comum, por exemplo, especificar configurações de conexão para processos externos, ou configurações de segurança, através de variáveis de ambiente.

Somos livres para atualizar a configuração do ambiente tanto quanto quisermos. Ao usar variáveis de ambiente, frequentemente vamos querer armazenar dados sensíveis, por exemplo, chaves de acesso a serviços remotos. Existem várias maneiras de fazermos isso de forma segura com a Lambda, e elas são explicadas na documentação da Amazon.

- **Segurança:**
	- Erro Grave: nunca coloque senhas de banco ou API Keys direto na seção *Environment* do *Template.yaml*. Isso fica visível no console da AWS para qualquer um com acesso de leitura, e fica gravado no histórico do GIT.
	- **Solução moderna:** (Parameter Store/Secrets Manager): use o AWS Systems Manager (SSM) Parameter Store. 
	- No Template: Environment: Variables: DB_PASSWORD: '{{resolve:ssm:/my-app/prod/db-password}}'

<span style="background:#affad1">Ou, podemos usar o Spring Cloud AWS para carregar essas configurações direto do SSM na inicialização da aplicação, sem passarmos por variáveis de ambiente expostas.</span>

