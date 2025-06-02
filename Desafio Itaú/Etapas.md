## 📅 Plano de Estudo e Prática (Etapas Semanais)

https://www.youtube.com/watch?v=9xrx1pxZEGU

Cada etapa será praticada por **10 dias**, onde o ideal é você:

- Codar **sem olhar o código anterior** (como um treino de memória muscular).
    
- Seguir as boas práticas.
    
- Testar via Postman.
    
- Comitar por partes (um commit por endpoint, no mínimo).
    
- Ao final de cada etapa, você já deve conseguir reproduzi-la com confiança antes de seguir.
    

---

### ✅ **Etapa 1 – Setup + POST /transacao com Validação**

📆 **Dias 1 a 10**

#### Objetivo:

- Iniciar projeto Spring Boot.
    
- Criar o endpoint `POST /transacao`.
    
- Validar entrada (valor ≥ 0, data não futura).
    
- Responder com 201, 422 e 400 apropriadamente.
    
- Usar `OffsetDateTime`.
    

#### Tarefas:

- Criar novo projeto no [Spring Initializr](https://start.spring.io/)
    
    - Java 17+
        
    - Spring Web
        
    - Lombok
        
    - Validation (Jakarta)

- Estrutura de pacotes: `controller`, `service`, `model`, `dto`, `exception`, `config`

- Criar DTO para entrada (`TransacaoRequest`): 
Para que criamos um DTO? Ele serve para **modelar e validar os dados de entrada** de uma requisição de transação. Em vez de receber dados brutos (como um JSON genérico) diretamente no sistema, definimos uma classe **TransacaoRequest** com os campos esperados para uma transação (por exemplo, **valor, tipo, descricao**).
Isso traz várias vantagens:
- **Contrato Claro:** Define explicitamente quais dados são esperados pela nossa API ou serviço. Funciona como um contrato entre o cliente e o servidor.
- **Validação:** Facilita a validação dos dados recebidos. Podemos adicionar anotações de validação (como *@NotNull*, *@Min(0)*, *@Size(max=10)*) diretamente nos campos do DTO. Se os dados não estiverem conforme o esperado, uma exceção pode ser lançada antes mesmo de chegar à lógica de negócios.
- **Tipagem Forte:** garante que os dados estejam nos tipos corretos (por exemplo, **BigDecimal** para valor, **String** para descrição), evitando erros de conversão e manipulação. 
- **Segurança**: ajuda a prevenir ataques de "mass assignment" ou *over-posting*, onde um cliente mal-intencionado envia campos extras que não deveriam ser alterados. O DTO só mapeará os campos explicitamente definidos.
- **Imutabilidade (Opcional):** DTOs de entrada podem ser projetados para serem imutáveis, o que pode simplificar o raciocínio sobre o estados dos dados.
- **Desacoplamento:** Desacopla a estrutura dos dados de entrada da sua lógica de negócios ou entidades de persistência. Se a forma como os dados chegam mudar, podemos precisar mudar apenas o DTO, sem impactar o resto do sistema.
- **Documentação:** o próprio DTO serve como uma forma de documentação para os dados esperados pela nossa aplicação.

- Criar validações:
    - Campo nulo
    - Valor negativo
    - Data futura

```java
public class TransacaoRequest {
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
	private Double valor;

	@NotNull
	private OffsetDateTime dataHora;

	public Double getValor() {
		return valor;
	}

	public OffSetDateTime getDataHora() {
		return dataHora;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setDataHora(OffsetDaateTime dataHora) {
		this.dataHora = dataHora;
	}
}
```

- Criar classe `TransactionService` com lista em memória

- Criar handler para exceções (400, 422)

- Escrever testes unitários do service

- Escrever testes de integração (MockMvc)


🧠 Repita essa etapa até conseguir criá-la **sem colar código anterior**.

---

### ✅ **Etapa 2 – DELETE /transacao**

📆 **Dias 11 a 20 (e refazendo a Etapa 1 também)**

#### Objetivo:

- Criar endpoint `DELETE /transacao`
    
- Limpar a memória (lista de transações)
    
- Responder com 200 OK
    

#### Tarefas:

- Criar endpoint no controller
    
- Adicionar método `limparTransacoes()` no service
    
- Escrever testes unitários e de integração
    
- Refatorar código se necessário
    

📌 Nessa fase, você treina:

- Reuso de código
    
- Boas práticas REST
    
- Integração entre controller-service
    

---

### ✅ **Etapa 3 – GET /estatistica**

📆 **Dias 21 a 30 (repetindo as etapas 1 + 2 também)**

#### Objetivo:

- Retornar estatísticas das últimas 60s de transações.
    
- Utilizar `DoubleSummaryStatistics` ou lógica customizada.
    
- Se nenhuma transação nos últimos 60s, retornar todos os valores como `0`.
    

#### Tarefas:

- Criar DTO de resposta `EstatisticaResponse`
    
- Criar lógica no `TransactionService` para:
    
    - Filtrar transações com `OffsetDateTime.now().minusSeconds(60)`
        
    - Calcular `sum`, `avg`, `min`, `max`, `count`
        
- Escrever testes unitários para estatística
    
- Escrever testes de integração (com e sem dados)
    
- Configurar JSON formatado corretamente
    

---

### ✅ **Etapa 4 – Polimento e Refatoração**

📆 **Dias 31 a 40 (repetindo as etapas 1 a 3)**

#### Objetivo:

- Refatorar código para seguir:
    
    - Clean Architecture (se quiser ir além)
        
    - Padrão SOLID
        
- Criar README bonito e descritivo no GitHub
    
- Criar cobertura de testes > 80%
    
- Melhorar tratamento de exceções com `@ControllerAdvice`
    
- Comentar código com JavaDoc
    

---

## 📌 Extras para Praticar a Cada Ciclo

-  **Fazer todos os commits com mensagens claras.**
    
-  **Testar com Postman e salvar a collection.**
    
-  **Rodar o app com `mvn spring-boot:run` ou `./mvnw`.**
    
-  **Evitar reusar código anterior (refaça do zero mesmo que mais rápido).**
    
-  **Criar README com instruções e objetivos.**
    
-  **Explique o projeto em voz alta ou grave um vídeo (simulando entrevista).**
    

---

## ✅ Conclusão do Ciclo (após 40 dias)

Ao final dos 40 dias, você terá:

- Um desafio técnico completo feito do zero várias vezes.
    
- Domínio sobre API REST com Spring Boot.
    
- Testes, boas práticas, Git e organização.
    
- Confiança para encarar desafios em entrevistas técnicas.
    

---

Se quiser, posso te ajudar a montar **tarefas diárias** detalhadas (por exemplo, "dia 1: criar projeto", "dia 2: criar DTO" etc). Deseja que eu faça isso também?

E me avise se quiser que isso tudo seja colocado em um README para você seguir com mais clareza.