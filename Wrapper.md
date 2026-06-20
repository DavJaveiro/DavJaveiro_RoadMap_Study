Um #wrapper é uma "camada de embrulho" em volta de alguma coisa no software.
Ele serve para **adaptar, simplificar, proteger ou padronizar o uso** de outro código, biblioteca, API, objeto ou recurso.

Em português, podemos pensar nele como:
> "Eu não uso a coisa diretamente. Eu crio uma camada em volta dela para controlar como ela será usada."

**Exemplo simples**
Imagine que estejamos usando uma API externa de pagamento:
```java
PagamentoAPI api = new PagamentoApi();
api.enviarPagamento(valor, cartao, token, "BRL", true);
```

O uso direto pode ficar feio, repetitivo ou muito acoplado à API externa.
Com isso, criamos um **wrapper:**
```java
public class PagamentoWrapper {
	private final PagamentoApi api;
	
	public PagamentoWrapper(PagamentoApi api) {
		this.api = api;
	}
	
	public void pagar(BigDecimal valor, Cartao) {
		api.enviarPagamento(valor, cartao, gerarToken(), "BRL", true);
	}
	
	private String gerarToken() {
		return "token-gerado";
	}
}
```

Agora o resto do sistema usa assim:
```java
pagamentoWrapper.pagar(valor, cartao);
```
Ou seja, o wrapper **esconde a complexidade** da API original.

**Para que um wrapper serve?**
Um wrapper pode servir para: 
1. **simplificar uma biblioteca complicada.** Ao invés de várias chamadas difíceis, criamos métodos mais claros.
2. **Padronizar o uso:** todo mundo no projeto usa do mesmo jeito.
3. **Evitar acoplamento direto**: se amanhã trocarmos a API de pagamento, talvez alteremos apenas o wrapper, e não o sistema inteiro.
4. **Adicionar comportamento extra:** Por exemplo: logs, validação, cache, tratamento de erro, autenticação.
5. **Adaptar uma interface para outra:** quando uma biblioteca não fala exatamente a "língua" do nosso projeto.

**Exemplo com log**
Criamos um wrapper em volta de um serviço para adicionar log:
```java
public class EmailServiceWrapper {
	private final EmailService emailService;
	
	public EmailServiceWrapper(EmailService emailService) {
		this.emailService = emailService;
	}
	
	public void enviar(String destino, String mensagem) {
		System.out.println("Enviando email para: " + destino);
		
		emailService.enviarEmail(destino, mensagem);
		
		System.out.println("Email enviado com sucesso.");
	}
}
```

O *EmailServiceWrapper* não é o serviço original. Ele **envolve** o serviço original e adiciona comportamento. 

**Diferença entre wrapper e adapter**
Eles são parecidos, mas não são exatamente a mesma coisa.

Um **wrapper** é um termo mais genérico: qualquer camada que envolve outra coisa.

Um #Adapter é um tipo específico de wrapper usado para adaptar uma interface incompatível com outra.

> Portanto: wrapper é uma casca em volta de uma implementação, criado para esconder complexidade e controlar como essa implementação será usada.


## Estrutura
**Exemplo comum de organização**
Imaginemos que o nosso sistema usa uma API externa de pagamento.
Uma estrutura boa seria:
src/main/java/com/seuprojeto
 ├── controller
 │    └── PedidoController.java
 │
 ├── service
 │    └── PedidoService.java
 │
 ├── <span style="background:#fff88f">integration</span>
 │    └── <span style="background:#d3f8b6">payment</span>
 │         ├── PaymentClient.java
 │         └── PaymentApiWrapper.java
 │
 ├── model
 │    └── Pedido.java
 │
 └── dto
      └── PedidoRequest.java

O #service é o que de fato usa o wrapper, ele não precisa saber os detalhes da API externa.

```java
@Component
public class PaymentApiWrapper {
	private final PaymentExternalClient client;
	
	public PaymentApiWrapper(PaymentExternalCLient client) {
		this.client = client;
	}
	
	public void pagar(BigDecimal valor, String cartao) {
		try {
			client.enviarPagamento(valor, cartao, "BRL");
		} catch (Exception e) {
			throw new PagamentoException("Erro ao processar pagamento", e);
		}
	}
}
```

O wrapper esconde detalhes técnicos como moeda, autenticação, tratamento de erro, formato da API externa etc.

**Nome dos pacotes mais comuns**
client
integration
infra
adapter
gateway
external
provider

## Trade-off
Os #wrappers ajudam bastante, mas também têm custo. O principal trade-off é:
> ganhamos controle, padronização e isolamento, mas podemos criar mais camadas, mais código e mais complexidade.

1. **Menos acoplamento vs mais código**
Com wrapper, o nosso sistema não fica preso diretamente a uma biblioteca/API externa.
Sem wrapper:
```java
stripClient.charge(amount, cardToken, "BRL");
```

Com wrapper:
```java
paymentGateway.pay(amount, cardToken);
```

*Vantagem:* se amanhã sairmos do Stripe e formos para o Mercado Pago, PagSeguro etc., talvez alteremos apenas o wrapper.

*Custo:* criamos mais uma classe, mais abstração, mais testes e mais manutenção.

2. **Simplicidade para quem usa vs complexidade para quem mantém**
Para o #Service, fica simples
```java
paymentGateway.pay(order.getTotal(), order.getCardToken());
```

Mas o wrapper pode esconder bastante coisa:
```java
@Component
public class PaymentGateway {
	private final StripeClient stripeClient;
	
	public void pay(BigDecimal amount, String cardToken) {
		// monta request
		// adiciona moeda
		// trata erro
		// converte resposta
		// registra log
		// lança exceção do domínio
	}
}
```
*Vantagem:* o restante do sistema usa uma interface limpa.
*Custo:* quem for dar manutenção precisa entender essa camada intermediária.

3. **Padronização vs. perda de recursos específicos**
Um #wrapper pode padronizar  o uso de várias APIs.

Exemplo:
```java
public interface StorageGateway {
	void upload(String fileName, byte[] content);
}
```

Podemos implementar com S3, Azure Blob ou Google Cloud Storage.

*Vantagem:* o nosso sistema não depende diretamente da AWS.

*Custo:* talvez o S3 tenha recursos específicos muitos bons, como versionamento, lifecycle, storage class, pressigned URL, eventos etc. Se o nosso wrapper for <span style="background:#fff88f">genérico</span> demais, <span style="background:#fff88f">podemos acabar escondendo funcionalidades importantes</span>.

Esse é um trade-off clássico:
> quanto mais genérico o *wrapper*, mais fácil trocar a implementação, mas maior a chance de perder recursos específicos.


4. **Testabilidade vs excesso de mocks**
Com wrapper, fica mais fácil testar o *Service*.
```java
@Test
void deveCriarPedidoEProcessarPagamento() {
	PaymentGateway paymentGateway = mock(PaymentGateway.class);
	
	PedidoService service = new PedidoService(paymentGateway);
	
	service.criarPedido(request);
	
	verify(paymentGateway).pay(any(), any());
}
```
**Vantagem:** podemos testar a nossa regra de negócio sem chamar API externa de verdade.

**Custo:** se mockarmos demais, podemos criar testes que passam, mas não garantem que a integração real funciona.

Por isso, além de testes unitário com mock, vale ter também alguns testes de integração.

5. **Tratamento de erro melhor vs risco de esconder erro demais**
Um wrapper pode converter erros técnicos em erros do nosso domínio.
```java
try {
	stripeClient.charge(request);
} catch (StripeException e) {
	throw new PaymentFailedException("Pagamento recusado", e);
}
```

**Vantagem:** o resto do sistema não precisa conhecer **StripeException**.

**Custo:** se simplificarmos demais, podemos perder detalhes úteis para debug, como código do erro, motivo da recusa, timeout, status HTTP etc.

Um wrapper ruim faz isso:
```java
catch (Exception e) {
	throw new RuntimeException("Erro genérico");
}
```
Aí, neste caso, perdemos uma informação importante.

6. **Estabilidade da arquitetura vs abstração prematura**
Wrapper é ótimo quando temos uma dependência externa importante: pagamento, e-mail, S3, SEFAZ, API de terceiros, mensageria, cache etc.

Mas criar wrapper para tudo pode virar exagero.

Exemplo desnecessário:
```java
public class StringWrapper {
	public boolean isBlank(String value) {
		return value == null || value.isBlank();
	}
}
```

Aqui em cima, provavelmente é overengineering.

A pergunta boa é:
*Essa dependência é instável, externa, difícil de testar, difícil de trocar ou cheia de detalhes técnicos?*

Se sim, wrapper faz sentido.

7. **Clareza vs. "Camadas de cebola"**
Um projeto pode ficar assim:
Controller → Service → UseCase → Gateway → Adapter → Client → SDK externo

Às vezes isso é arquitetura bem organizada.

Mas às vezes vira só burocracia.

O problema aparece quando para entender uma chamada simples, precisamos abrir 7 arquivos.

Trade-off
mais camadas dão organização e isolamento, mas podem dificultar a navegação no código.

## Regra prática
Crie um *wrapper* quando estamos lidando com algo que:
- é externo
- pode mudar
- é difícil de testar,
- tem detalhes técnicos demais
- espalharia código repetido
- ou acoplaria o nosso domínio a uma biblioteca específica.

Devemos evitar *wrapper* quando ele só troca um nome por outro e não adiciona proteção, simplificação ou isolamento real.

