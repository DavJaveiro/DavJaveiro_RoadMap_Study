O tópico de _observability_ gerou um suprimento constante de atenção e burburinho ao longo dos últimos 10 anos, desde que foi introduzido pela primeira vez no campo de desenvolvimento de software. No entanto, como ocorre com a maioria dos tópicos complexos, uma maré crescente de adoção por profissionais e interesse em _observability_ foi rapidamente combatida por uma onda de simplificação excessiva e apropriação, impulsionada por _hype_ e orçamentos de marketing.

Quando você vê esse ciclo se desenrolar repetidamente, é fácil ser cínico: talvez as palavras simplesmente não signifiquem nada quando o dinheiro se envolve. Vale a pena dar um passo atrás para considerar: por que todos nós ficamos tão empolgados em primeiro lugar? O que foi tão revelador e por que isso importava?

Este capítulo examina as origens matemáticas do termo "observability" e como a indústria de desenvolvimento de software o interpretou e adaptou ao nosso mundo. Também observamos as placas tectônicas que estão colidindo em quase todas as empresas agora, entre os velhos métodos (que evoluíram das operações de servidores e ainda dominam o ecossistema) e os novos métodos, derivados de primeiros princípios e muito mais expansivos em capacidades, embora nadando contra a correnteza da forma como as coisas sempre foram feitas.

Ao longo do caminho, argumentaremos que #observability não é apenas uma técnica de depuração ou uma categoria de ferramentas; é uma propriedade de confiabilidade do software, tão fundamental quanto a #Reability ou #Availability.

A observability nasceu da necessidade, quando ferramentas e técnicas tradicionais simplesmente <span style="background:#fff88f">não conseguiam acompanhar a longa cauda (long tail)</span> de problemas novos surgindo de nossos sistemas cada vez mais complexos.

Nosso melhor palpite é que a IA será a coisa que forçará as equipes a finalmente se afastarem do modelo operacional de _Telemetry_ e em direção a um modelo mais unificado, da mesma forma que os dados de negócios fizeram nos anos 2000. _Observability_ é a última linha de defesa para código gerado por IA, e o comportamento de agentes é inerentemente imprevisível e muda com o tempo. <span style="background:#fff88f">A única maneira de saber o que ele está fazendo é com dados ricos em contexto e ferramentas de precisão enquanto roda em produção</span>.

Por outro lado, pensamos a mesma coisa 10 anos atrás. Pensávamos que não havia como o modelo de três pilares sobreviver à complexidade de microsserviços, serverless e persistência poliglota. Mas, de alguma forma, sobreviveu. Somos engenheiros, não prognosticadores.

**Insights valiosos com foco em Observabilidade e Operação**
O texto de introdução toca no cerne do que separa a engenharia de software sênior da operação tradicional: a transição de um monitoramento puramente de infraestrutura ("velhos métodos") para uma investigação baseada em contexto e dados ("novos métodos").

- A "Longa Cauda" dos Problemas em Sistemas Distribuídos: em arquiteturas modernas (Kubernetes, microsserviços Spring Boot, Kafka), as falhas não são mais binárias (servidor ligado ou desligado). Elas são complexas e multifatoriais: um *Thread Pool* exausto no Tomcat devido a uma latência de rede intermitente como banco de dados, causando contenção e afetando o Throughput global. A observabilidade real surge para responder ao unknown-unknown (o que nem sabia que precisavamos monitorar).
- **O Mito dos Três Pilares Isolados:** O autor menciona que o "modelo de três pilares" sobreviveu de alguma forma, mas na operação prática, ter _Logs_ (ex: ELK), _Metrics_ (ex: Prometheus) e _Traces_ (ex: Jaeger) em ferramentas separadas **sem correlação** é o maior gargalo operacional atual. Em um _Incident_ real, a equipe de SRE perde um tempo valioso tentando achar o log exato de um pico de latência. A verdadeira _Observability_ conecta os pilares: uma métrica anômala no Grafana deve possuir um _Exemplar_ que leva diretamente ao _Distributed Tracing_ no Tempo, que por sua vez filtra os _Logs_ exatos daquela requisição no Loki.
- **Observabilidade como Propriedade do Software:** Como citado no texto, não é apenas instalar um agente de _APM_. É uma decisão arquitetural. No ecossistema Java, isso significa que os desenvolvedores precisam projetar a aplicação usando Spring Boot Actuator e Micrometer, injetando _Correlation IDs_ e garantindo que o comportamento da _JVM_ (_Garbage Collection_, _Heap_, _Metaspace_) e o contexto de negócio (ex: `tenant_id`) sejam externalizados adequadamente para o OpenTelemetry.
- **IA e a Necessidade de Alta Cardinalidade:** à medida que sistemas integram agentes de IA e comportamentos dinâmicos, Dashboards estáticos com agregações pré-computadas não são suficientes. Precisamos interrogar o sistema na mosca. Isso exige suporte e alta Cardinalidade (capacidade de agrupar/filtrar por atributos infinitos e únicos), algo que ferramentas legadas lutam para entregar sem custos explosivos.

**O que está desatualizado ou perigoso na prática atual**
Baseado nas reflexões do capítulo sobre a colisão entre "os velhos métodos" e os novos:
 **Perigo: Monitoramento focado apenas em recursos de Infraestrutura (CPU/Memória)**
    - _Por que é problemático:_ Disparar _Alerting_ apenas porque um pod no Kubernetes atingiu 80% de CPU é uma prática defasada da era de _Windows Server/Linux_ bare-metal. No mundo _Cloud Native_, containers devem usar os recursos disponíveis. O verdadeiro problema não é o uso de CPU, mas sim se isso está gerando _CPU Throttling_ e, consequentemente, afetando a _Latency_ ou _Availability_ da aplicação perante o usuário.

**Desatualizado: Os Três Pilares como Silos Desconectados**
	_Por que é problemático:_ Como o próprio texto sugere, o modelo de pilares isolados não escala mentalmente. O operador tem que pular de uma aba de _Metrics_ para uma de _Logs_ e tentar adivinhar a correlação via _timestamps_, inflando o _MTTR_ (Mean Time To Recovery).
	*Alternativa moderna:* uso do #OpenTelemetry como padrão neutro de insturmentation. A telemetria sai da aplicação Java como contexto atrelado (um Log carrega automaticamente o trace_id e o span_id).


**Perigo: _Dashboards_ Mudos e _Logs_ Verbosos sem Estrutura**
- _Por que é problemático:_ Usar `System.out.println` ou logs formatados em texto puro (`log.info("Processando pedido {} para cliente {}", orderId, clientId)`) impede buscas indexadas eficientes. Da mesma forma, _Dashboards_ com centenas de gráficos sem um _Runbook_ associado apenas geram confusão durante uma crise de madrugada.
- _Alternativa moderna:_ **Logs Estruturados (JSON)** nativos com SLF4J/Logback, e painéis no Grafana que respondam a perguntas claras, sempre linkados a um procedimento operacional padrão (_Runbook_).

Aplicação prática em Java
Para transformar a teoria do texto em engenharia aplicada, precisamos garantir que nossa aplicação Java pare de ser uma "caixa preta" e passe a gerar _Telemetry_ interligada, superando o modelo obsoleto de silos.

Aqui está como implementamos a fundação de _Observability_ unificada no **Spring Boot 3** usando **Micrometer Observation API** (que consolida Métricas e Traces em uma única instrumentação).

O Cenário Ruim (A abordagem legada)
O desenvolvedor loga a informação sem estrutura e sem métricas associadas. Durante um _Incident_, é impossível medir quanto tempo essa operação demorou ou encontrar a origem da falha em uma arquitetura de microsserviços.
```java
@Service
public class OderService {
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	public void processOrder(String orderId) {
		log.info("Processing order: " + orderId);
		// Isso é ruim, sem traceId, difícil de parsear
	}
}
```

**O Cenário Melhorado (Observabilidade Moderna)**
No Spring Boot 3, incluímos as dependências de atuadores e *Tracing*:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-tracing-bridge-otel</artifactId>
</dependency>
```

Instrumentando o código para Observabilidade Rica:
```java
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private final ObservationRegistry observationRegistry;

    public OrderService(ObservationRegistry observationRegistry) {
        this.observationRegistry = observationRegistry;
    }

    public void processOrder(String orderId, String tenantId) {
        // Criando uma "Observation". Isso gera automaticamente:
        // 1. Métrica no Prometheus (timer)
        // 2. Span de Trace (compatível com OpenTelemetry)
        // 3. Injeta traceId no MDC para os Logs
        Observation.createNotStarted("order.processing", observationRegistry)
            .lowCardinalityKeyValue("tenant.id", tenantId) // Bom para agrupamento de Métricas (baixo número de valores únicos)
            .highCardinalityKeyValue("order.id", orderId)  // Excelente para Traces/Logs (alta variação)
            .observe(() -> {
                // Como o MDC está populado pela Observation, este log sairá com traceId e spanId nativamente
                log.info("Starting order processing in business logic"); 
                
                try {
                    // Simula processamento
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
    }
}
```

Como diagnosticar com essa estrutura (O fluxo SRE):
1. **Alertmanager:** Dispara um alerta no Slack informando: `Alerta: order.processing_seconds_max > 2s`. A _Latency_ de negócio foi afetada, ameaçando o _SLA_.
2.  **Prometheus & Grafana:** Você abre o _Dashboard_ no Grafana e vê o gráfico de latência da métrica `order_processing_seconds`.
3. **Correlação (_Exemplars_):** No Grafana, graças ao Micrometer e OpenTelemetry, você clica diretamente em um ponto fora da curva (um _Exemplar_), que faz a ponte instantânea da _Metric_ para o _Trace_. 
4. **Tempo/Jaeger:** o Distributed Tracing abre, mostrando que dos 2.5 segundos, 2.3 segundos foram gastos esperando o Connection Pool (HikariCP) obter uma conexão com o PostgreSQL, e não no processamento da OrderService em si.
5. **Loki:** o Trace fornece os logs exatos daquela requisição.
6. **Ação Operacional**: redução imediata de MTTR. Em vez de reiniciar os pods Kubernetes ou escalar CPU, a engenharia sabe que o problema está na exaustão de conexões com o banco ou lentidão na base de dados (um trade-off claro onde escalar a aplicação Java apenas pioraria a sobrecarga no banco).

## The Origins of Observability
O termo "_observability_" foi cunhado pelo engenheiro Rudolf E. Kálmán em 1960, em um artigo que hoje citamos como o nascimento da teoria de controle moderna — a matemática de sistemas que você deseja guiar para um estado desejado, apesar de ruídos, distúrbios e informações incompletas.

A principal percepção de Kálmán foi que _observability_ e controlabilidade são duais. Um sistema que você não pode observar é, em um sentido matemático preciso, um sistema que você não pode controlar, e vice-versa.

Para Kálmán, observability significava fazer a pergunta: dadas as saídas que podemos medir, conseguimos inferir o estado interno completo do sistema? Se sim, o sistema é observável. Se não, algum estado interno está permanentemente oculto, e nenhuma engenharia inteligente o recuperará, porque a informação nunca foi capturada para começo de conversa.

O software pegou isso emprestado da engenharia de sistemas. Como a maioria das coisas que pegamos emprestado, chegou com parte do significado original intacta e algumas partes perdidas no caminho. (A parte de controlabilidade não tem equivalente em software.)

Mas quando aplicamos os princípios de _observability_ ao domínio mais maleável do software, isso abre novas e radicais formas de interagir e entender o código que você escreve.

**Inferir o estado interno**, na prática de Software. Em uma aplicação Java, o "Estado interno" é a Heap da JVM, o número de threads ativas, as conexões ocupadas no Connection Pool (HikariCP), os parâmetros de uma requisição REST e o estágio do Garbage Collection. Nós não podemos pausar a execução em produção com um debugger para ver esse estado. Portanto, usamos Telemetry Logs, Metrics, Traces como as "saídas mensuaráveis" de Kálmán para deduzir o que a aplicação está fazendo.

A falácia do "Nenhuma engenharia inteligente recuperará:" este é o ponto mais crítico para desenvolvedores. Se um incident ocorrer (ex: OutOfMemoryError) e a aplicação não estiver exportando métricas de memória ou gerando Heap Dumps, o MTTR explode. Não importa se temos o Grafana ou Datadog; se o Spring Boot não foi instrumentado (Instrumentation) para emitir os dados no momento exato em que a falha começou, a causa raiz está "permanentemente oculta". A observability é uma decisão de design de código, não apenas um agente instalado na infraestrutura.

- _Por que é problemático:_ Apenas pingar um endpoint `/health` de fora para ver se retorna `200 OK` (caixa preta) viola o princípio de Kálmán de inferir o "estado interno". O sistema pode estar retornando 200 OK, mas exaurindo o _Connection Pool_ silenciosamente ou acumulando _Garbage Collection_ longo (Stop-The-World), prestes a causar uma indisponibilidade severa.

- - _Alternativa moderna:_ Monitoramento de Caixa Branca (_White-box monitoring_). Uso do Spring Boot Actuator para expor o estado interno da _JVM_, _Métricas_ de negócio customizadas via Micrometer e _Traces_ detalhados com OpenTelemetry.

- _Por que é problemático:_ Em sistemas monolíticos antigos, podíamos inferir o estado lendo gigabytes de #arquivos de texto no Linux. Em uma arquitetura de microsserviços distribuídos no Kubernetes, ler _Logs_ sem estrutura para entender uma <span style="background:#fff88f">lentidão é impossível e custa muito caro em armazenamento</span> (_Custos de Cloud_).ipo9luyght0jf.k ( #Zozo em 20/06/2026 fez bagunça).

Para aplicar Kálmán em Java, precisamos garantir que o sistema exponha as saídas corretas (instrumentação) para que possamos deduzir seu estado interno em produção.

**O cenário Ruim (Estado Interno Oculto)**
O código não exporta nenhuma telemetria útil. Se houver lentidão na API externa, o operador verá apenas picos de uso de CPU genéricos, sem saber o que causou.

```java
@Service
public class PaymentGatewayService {
	public void processPayment(String paymentId) {
		// Nenhuma métrica gerada. // Se a API abaixo demorar 10 segundos, o estado interno da aplicação // (threads bloqueadas esperando I/O) não será inferível.
		restTemplate.postForObject("https://api.gateway.com/charge", request, Response.class);
	}
}
```

**O Cenário Melhorado (Inferindo o estado interno com Micrometer/Actuator)**
No ecossistema Spring Boot moderno, usamos o Micrometer para encapsular a operação e expor o estado.
```java
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentGatewayService {

    private final RestTemplate restTemplate;
    private final Timer paymentTimer;

    public PaymentGatewayService(RestTemplate restTemplate, MeterRegistry registry) {
        this.restTemplate = restTemplate;
        // Definindo a saída (output) mensurável para Kálmán
        this.paymentTimer = Timer.builder("payment.gateway.request.duration")
                .description("Tempo gasto integrando com o gateway de pagamento externo")
                // SLO: Queremos medir quantos requests caem em faixas de tempo específicas
                .publishPercentileHistogram() 
                .register(registry);
    }

    public void processPayment(String paymentId, String gatewayName) {
        // Envolvemos a execução para medir com precisão a Latency interna e o Throughput
        paymentTimer.record(() -> {
            try {
                restTemplate.postForObject("https://api.gateway.com/charge", request, Response.class);
            } catch (Exception e) {
                // Em um cenário completo, adicionaríamos uma métrica separada de falhas (Counters)
                throw new RuntimeException("Falha no pagamento", e);
            }
        });
    }
}
```

**Como diagnosticar o "Estado Interno" com essa implementação:**
1. **Exposição:** O Spring Boot Actuator expõe o endpoint `/actuator/prometheus`. O Prometheus faz o _scrape_ periodicamente.
2. **Dashboard no Grafana:** Criamos um gráfico visualizando o percentil 99 (p99) de `payment_gateway_request_duration_seconds`.
3. **Dedução de Estado:** Você nota no painel que a _Latency_ p99 subiu de 200ms para 5000ms. Imediatamente, você _infere o estado interno_: a aplicação Java está sofrendo contenção de _Threads_ porque o _RestTemplate_ está bloqueado aguardando o provedor terceiro.
4. **Ação Operacional (O Controle):** Com o estado interno claro, você atua: ajusta o _Timeout_ do `RestTemplate`, aciona um _Circuit Breaker_ ou redireciona o tráfego. Sem a métrica exposta, o sistema seria inobservável e a causa raiz ficaria invisível.

## Aplicando Observability a Sistemas de Software

A engenharia de software tem uma longa e rica história de pegar emprestado de outros domínios: biologia, arquitetura e todos os tipos de engenharia. Podemos fazer isso no software porque estamos menos atados a restrições físicas. Quanto mais alto você sobe na _stack_, mais você se liberta de praticidades como gravidade, massa ou a velocidade da luz. A única estrutura que temos é a estrutura que damos a nós mesmos, usando lógica, linguagem e metáfora.

O software pode não estar fundamentado em nenhuma das restrições de suas partes constituintes — átomos, elétrons, fibra ótica e assim por diante — mas o software tem suas próprias restrições e considerações com as quais se preocupar. E os princípios por trás da definição de Kálmán de _observability_ provaram ser úteis para raciocinar sobre sistemas de software modernos.

Nossos sistemas e práticas mudaram continuamente ao longo dos anos. Nossa compreensão de _observability_ também mudou.

Na primeira edição, descrevemos _observability_ como uma nova geração de ferramentas, definida pelas capacidades que você poderia desbloquear ao repensar o armazenamento e a análise de dados. Essa definição incomodou muita gente — e compreensivelmente, já que implicava que as ferramentas mais tradicionais não ofereciam nenhuma _observability_. Passamos a desfavorecer essa definição por um motivo diferente: ela enfatizava recursos e capacidades, mas o que as pessoas realmente se importam são os resultados.

Desde então, adotamos uma visão mais abrangente, que é a de que _observability_ é uma propriedade de sistemas de software, como _Reliability_ ou performance. Argumentaremos que a _observability_ do seu software é um atributo central de sua confiabilidade (_dependability_).

"Confiabilidade" (_Dependability_) é outro conceito emprestado (da engenharia de sistemas, desta vez) no qual agora confiamos. A confiabilidade do software é tipicamente expressa em um espectro que vai de baixo a alto, assim como cada um de seus atributos.

Vamos começar examinando as outras propriedades da confiabilidade do software. Depois, veremos como medir a propriedade de _observability_.

### Propriedades da Confiabilidade (Dependability) do Software
O software engoliu o mundo. Toda vez que ligamos para um amigo, pegamos o trem ou recebemos o salário, dependemos de uma enorme e invisível teia de softwares se comportando mais ou menos como esperado, apesar do fato perene de que <span style="background:#fff88f">todo hardware vai quebrar e todo software tem bugs</span>.

As falhas são um fato da vida. A indústria de software pode ter obtido apenas ganhos modestos na prevenção de bugs, mas fizemos muito para tornar nossos sistemas mais resilientes a eles. Á medida que a <span style="background:#fff88f">tecnologia</span> desempenha um <span style="background:#fff88f">papel ainda maior em nossas vidas</span>, nossa <span style="background:#d3f8b6">tolerância à imprevisibilidade diminuiu</span>. Isso faz da confiabilidade, "a fidedignidade de um sistema de computador", uma preocupação central na nossa era.

A confiabilidade do software não pode ser quantificada numericamente. Não existe uma pontuação de confiabilidade 9 ou uma nota B+ para confiabilidade. Alguns componentes, como _Availability_, costumam ser medidos com noves — por exemplo, _uptime_ que é 99.9%, 99.99% ou 99.999% disponível. Você pode medir segundos de _Availability_, mas essa métrica não diz nada sobre confiabilidade. Os noves não importam se os usuários não estiverem felizes.

Felizmente, existe um caminho bem estabelecido para medir as características de confiabilidade. Em 1995, Jean-Claude Laprie propôs um _framework_ para medir a confiabilidade do software avaliando seis propriedades complementares que, juntas, descrevem a fidedignidade geral de um sistema:

- #Availability: a capacidade do sistema de entregar serviços quando solicitado;
- #Reliability: a capacidade do sistema de entregar conforme especificado;
- #Manutenibilidade: a capacidade do sistema de passar por reparos e evolução;
- #Segurança: a ausência de consequências catastróficas;
- #Confidencialidade: a ausência de divulgação não autorizada de informações.
- #Integridade: a ausência de alterações impróprias no sistema.

Para avaliar a confiabilidade, você precisa analisar três coisas em conjunto: o que o sistema deve fazer (funções), o que ele realmente faz (comportamento) e como ele é construído (estrutura). Isso se aplica tanto a hardware quanto a software, incluindo o ambiente em que operam — e, crucialmente, as pessoas que interagem com o sistema. Laprie definiu sistemas de software como inerentemente sociotécnicos.

Esse último ponto é importante e fácil de ignorar. Você não pode analisar totalmente a confiabilidade olhando para o código. Os humanos no sistema são parte do sistema.

Observabilidade não é o Datadog, o Dynatrace ou Grafana que compramos. É como a nossa aplicação Java foi desenhada. Uma API REST não injeta Correlation IDs ou que suprimete Exceptions críticas em catch blocks vazios tem "baixa observabilidade", independemente de quão cara seja a sua ferramenta de APM.

- **O Fator Sociotécnico no _Incident Response_:** A afirmação "os humanos no sistema são parte do sistema" é o que difere a operação amadora da profissional. Um _Dashboard_ no Grafana com 150 gráficos super detalhados sobre métricas internas da _JVM_ (_Garbage Collection_ _pause times_, _Eden space_, _Survivor space_) não tem utilidade prática às 3 da manhã se o engenheiro de plantão (_On-call_) não souber qual gráfico olhar. A _Maintainability_ cai drasticamente quando a carga cognitiva do operador não é considerada no design dos _Alerting_s e _Runbooks_.

### Observabilidade é uma Propriedade de Software Confiável
Em meados da década de 1990, o framework de Laprie era abrangente o suficiente para descrever coletivamente a confiabilidade (_dependability_) do software, assim como o monitoramento era suficiente para atender às necessidades de _Reliability_ dos sistemas da época.

Sistemas monolíticos eram relativamente previsíveis. Os problemas que encontrávamos em produção eram em sua maioria binários: o site estava no ar, ou estava fora do ar. (Às vezes, se não tivéssemos sorte, ele tinha um terceiro estado: inexplicavelmente lento). O monitoramento era be adequado para isso. Ele detectava se um serviço estava no ar, fora do ar ou com baixo desempenho, e as equipes de engenharia respondiam com trabalho de correção de quebras para restaurar a disponibilidade.

Na era de Cloud Native, muitos modelos de falha de infraestrutura são abstraídos e tratados pela plataforma. Os monólitos deram lugar aos microsserviços. O esforço de toda a indústria para melhorar a resiliência tornou tudo mais distribuído, trazendo muitos efeitos de segunda ordem. O mais significativo deles foi uma mudança radicla em como pensamos sobre a disponibilidade.

A era da nuvem introduziu um vasto zoológico de estados de falha parcial. O terceiro estado, antes raro — lentidão inexplicável sem uma evidência clara (_no smoking gun_) — tornou-se o modo de falha mais comum: um balanceador de carga parcialmente degradado; uma configuração _hardcoded_ apontando para us-east-1 a partir de containers na Índia; uma dependência rodando na infraestrutura de outra equipe, atrás de uma API, onde você nem consegue ver o que ela está fazendo. Parece uma típica segunda-feira.

Sistemas de monitoramento simples podem dizer que o nosso sistema está majoritariamente no ar ou fora do ar. Um monitoramento mais sofisticado pode lhe dizer onde algo está lento. Mas o monitoramento não pode lhe dizer o porquê. Precisamos de todos os três para resolver problemas em produção.

A confiabilidade do software, agora deve incluir a rapidez com que as falhas são detectadas, a rapidez com que suas origens podem ser identificadas e a eficácia com que as equipes conseguem raciocinar sobre o motivo dessas falhas estarem ocorrendo, mesmo quando elas são muito pequenas. Em outras palavras, você precisa ser capaz de fazer isso em qualquer nível: de uma visão de alto nível de todo o sistema, até cada salto de rede (_network hop_) entre os serviços em uma determinada sessão, e qualquer subconjunto ou combinação de requisições no meio disso.

É por isso que acreditamos que é hora de adicionar uma sétima propriedade à lista de Laprie:
#observability 
A capacidade de entender ou depurar qualquer estado de um dado sistema.

Esta não é uma alteração menor. Passaremos o resto desse livro desempacotando por que ela pertence a essa lista e como alcançá-la.

**O Fim da Disponibilidade Binária:** a afirmação de que falhas agora são um "zoológico de estados de falha parcial" reflete o dia a dia operando Kubernetes e ecossistemas Spring Boot. Um cluster inteiro não cai de uma vez. O que ocorre é um único *pod* sofrendo de longas pausas de Garbage Collection (GC), causando Timeouts intermitentes que afetam 5% das requisições. O monitoramento clássico (ping) dirá que a Availability é 100%, mas a realidade real para o usuário está comprometida.

**Monitoramento (O Quê) vs Observabilidade (O Porquê):** o autor descreve brilhantemente a diferença. O Dashboard do Grafana mostrando que a métrica de Latency disparou de 50ms para 3000ms é o "Onde" e o "O Quê". A observabilidade real surge quando clicamos nessa métrica e navegamos via um Exemplar direto para um #Trace ( #Jaeger/Tempo) que cruza os limites da nossa aplicação Java, entra no API Gateway, passa pelo Kafka e mostra exatamente em qual dependência remota ocorreu o gargalo.

**O "Terceiro Estado" e a Carga Cognitiva:** a lentidão inexplicável é o maior consumidor de tempo MTTR em incidentes. Em um sistema distribuído, um gargalo em um microsserviço no final da cadeia pode causar o esgotamento do Connection Pool e do Thread Pool em serviços a montantes (efeito cascata). Sem o Distributed Tracing interligado a Logs e Metrics, o engenheiro tenta adivinhar a causa raiz olhando painéis de CPU isolados, o que é ineficaz.

- _Por que é problemático:_ Tentar diagnosticar uma lentidão "inexplicável" olhando apenas para o uso global de CPU, RAM e I/O dos _nodes_ do Kubernetes. A "lentidão sem evidência clara" geralmente mora na rede, em _timeouts_ ocultos, na serialização/desserialização JSON excessiva ou na latência entre zonas de disponibilidade (AZs).

- - _Alternativa moderna:_ Instrumentar a rede e as chamadas externas. Usar _Service Mesh_ (ex: #Istio) para telemetria de rede e o Spring Boot Micrometer + OpenTelemetry para capturar métricas de cliente HTTP (ex: `http.client.requests`).

## Quão Observável é o seu Software?
Propriedades de confiabilidade, como #Reliability, segurança e manutenibilidade, não são medidas numericamente; o mesmo vale para a #observability. Mas podemos raciocinar sobre ela qualitativamente, e esse é um bom ponto de partida.

A detecção de falhas é relativamente direta: sabemos que um problema está ocorrendo antes que nossos clientes relatam? Se você já gerenciou uma aplicação _Cloud Native_ moderna, sabe o quão comum é o monitoramento deixar passar problemas críticos. Sua equipe de suporte ao cliente sinaliza um pico de reclamações, então você verifica o _Dashboard_, mas tudo parece bem — se isso soa familiar, você tem um problema de detecção de falhas.

A triagem, descobrir onde um problema está ocorrendo, fica mais difícil à medida que a complexidade arquitetural aumenta.  Em sistemas de baixa #observabilitY, isso frequentemente se manifesta como tempestades de alertas (*alerts storms*): uma falha em um sistema subjacente aciona dezenas ou centenas de alertas em outros. Quando uma dependência crítica falha, você sabe exatamente para onde olhar? Ou você tem que verificar várias fontes e investigar até encontrar a origem da cascata?  

Entender o porquê de um problema estar ocorrendo é geralmente a parte mais difícil. Uma vez que encontramos a origem, temos que descobrir o que a causou. Identificar a trilha causal pode ser muito desafiador, mas é no meta-processo que as equipes mais sofrem: descobrir como elas descobriram, e codificar essa trilha de migalhas no sistema em vez de viver exclusivamente na cabeça de engenheiros seniores e se manifestar como saltos intuitivos. 

Como Scotty de Jornada nas Estrelas disse uma vez: "Eu poderia lhe dizer a velocidade que estávamos viajando pela vibração das placas do convés." Bom para você, Scotty, mas isso não ajuda o resto da tripulação. Podemos ter a velocidade de dobra atual exibida onde os outros possam ver, por favor?

Qualquer engenheiro da nossa equipe, independentemente da experiência, consegue diagnosticar rapidamente problemas complexos interrogando os dados que o nosso sistema emite? Ou um diagnóstico correto exige profundo conhecimento institucional em um sexto sentido?

A resposta para essa pergunta é quão observável é o seu software. As mudanças que a IA está trazendo para a indústria tornarão isso exponencialmente mais relevante.

**CARDINALITY (CARDINALIDADE)**

Na matemática, _Cardinality_ refere-se ao número de elementos em um conjunto. Em bancos de dados, significa o número de valores únicos em uma coluna. Uma coluna chamada "Status" que contém "true" ou "false" tem uma _Cardinality_ de 2, enquanto um identificador único universal (UUID) ou qualquer outro conjunto exclusivo de valores tem a maior _Cardinality_ possível. 

Dados de alta Cardinalidade são os mais descritivos e identificadores, e são vitais para a Observabilidade. Pense em todos os atributos mais úteis pelos ques gostaríamos de pesquisar ou agrupar: número da build, hash do commit, ID do Container, span_id, ID do Usuário, nome da aplicação, hash da query, etc. Todos são de alta cadinalidade, e é por isso que são úteis.

Valores de alta _Cardinality_ podem sofrer _Sampling_ ou _downsampling_ (ex: agrupar sobrenomes por prefixo ou substituir todos os códigos de erro HTTP por "5xx"), mas isso não pode ser desfeito. Se você agrega os dados antes de gravá-los no disco, nunca mais conseguirá juntar as peças novamente.

_Cardinality_ é um incômodo sem fim para equipes que dependem fortemente de _Metrics_. Dados de alta _Cardinality_ são os mais valiosos, mas as _Metrics_ não são construídas para lidar com eles. Uma única métrica pode aumentar sua conta em dezenas de milhares de dólares por semana se cardinalidade suficiente escapar para os dados de forma despercebida.

Em um <span style="background:#fff88f">sistema</span> de software <span style="background:#fff88f">com um alto grau de Observabilidade</span>, devemos ser capazes de:
- Entender qualquer estado que a nossa aplicação possa ter alcançado, mesmo os completamente novos, sem enviar código novo para lidar com isso (o que implicaria que precisamos saber sobre ele para encontrá-lo);
- Comparar um conjunto de feature flags contra qualquer outro conjunto, então quebrar e agrupar por endpoint, chave de API, hash da query ou qualquer outra combinação de dimensões interessantes, sem limites de Cardinality.
- Ver como os usuários estão interagindo com a funcionalidade que acabamos de lançar;
- Fazer um #Trace por requisição de transação, sessão de navegador, sessão de aplicativo móvel ou histórico de chat.
- Se qualquer um dos seus _SLO_s estiver "queimando rápido" (consumindo o _Error Budget_), você deve ser capaz de selecionar os eventos violadores e evidenciar quaisquer padrões. ("O pico de requisições lentas está vindo de réplicas de leitura na Austrália, de um ID de build que acabamos de implantar para 1% de canários usando as flags x, y e z; a string de erro do cliente diz que o DNS está dando _timeout_.")
- Encontrar _outliers_ (pontos fora da curva). De qualquer tipo. Facilmente.

Para responder a essas perguntas, você precisa de precisão, flexibilidade e (idealmente) velocidade.

Sistemas de software com graus menores de _Observability_ são aqueles onde essas perguntas só podem ser respondidas com um enorme investimento de tempo e trabalho manual, ou por um especialista que praticamente intui as respostas.

- **O "Anti-pattern do Scotty" e a Democratização da Operação:** Depender de "heróis" ou do "sexto sentido" de engenheiros seniores é um risco inaceitável para a _Reliability_. Em um incidente de madrugada, o tempo que o SRE gasta acordando o especialista para perguntar onde olhar infla diretamente o MTTR (Mean Time To Recovery). A _Observability_ externaliza o estado da _JVM_ e do negócio para o Grafana, permitindo que um operador júnior leia o #Runbook, veja a _Metric_ de exaustão de _Thread Pool_ e tome a decisão correta de acionar o _Circuit Breaker_.
- **A Guerra da _Cardinality_ nas Métricas:** Este é o _insight_ mais crítico do texto. Em ferramentas como o Prometheus, cada combinação única de _labels_ (etiquetas) cria uma nova série temporal (_time series_) em memória. Injetar um ID de transação ou ID de usuário como um _label_ causará uma explosão de cardinalidade, derrubando o servidor Prometheus com um _Out of Memory_ (OOM) e gerando faturas astronômicas de _cloud_. _Metrics_ servem para tendências agregadas (baixa cardinalidade); detalhes granulares pertencem aos _Traces_ e _Logs_.

## Dois Modelos Concorrentes para Telemetry: Três Pilares Versus Dados Unificados
Qualquer ferramenta pode ser avaliada pelo quão bem ela te ajuda a alcançar um alto grau de _observability_. Os princípios são o que importam — e os princípios por trás das duas abordagens mais comuns são muito diferentes.

Essas duas placas tectônicas estão em rota de colisão agora mesmo, em toda a indústria, à medida que a rocha inamovível de "como sempre fizemos as coisas" encontra a força imparável da IA e das pressões competitivas. As equipes de engenharia vão atualizar seu kit de ferramentas, ou os três pilares irão se adaptar e provar serem impossíveis de desalojar? Nós vamos descobrir.

### O Modelo de Três Pilares
A primeira placa é a maneira antiga. Nós a chamamos de "três pilares", Metrics, Logs e Traces, mas isso é uma ficção educada. Existem muito mais do que três tipos de sinais: erros, exceções, dados de _profiling_, análises de produto, eventos de segurança, etc. Cada tipo de sinal é transmitido e armazenado em seu próprio silo especial, como mostrado na Figura 1-1.

!![image-2026621293379.png](/image-2026621293379.png)

Cada tipo de sinal é enviado e armazenado em seu próprio silo separado. Metrics vão para um banco de dados de séries temporais (TSDB), Logs vão para um serviço de agregação de logs e Traces vão para um serviço de tracing. Se o código gera exceções, erros, dados de profiling ou quaisquer outros sinais, cada um seria armazenado em seu próprio silo.

Para ilustrar o ponto, considere uma requisição web simples de _checkout_, como esta: `GET /api/checkout trace_id=7f3a9c user_id=u_8821 200 OK 142ms`

Ela geraria pelo menos três conjuntos distintos de dados de telemetria: _Metrics_, _Logs_ e um _Trace_, como mostrado nas Figuras 1-2, 1-3 e 1-4, respectivamente.

*Metrics*
!![image-20266213156712.png](/image-20266213156712.png)

*Debug*
!![image-20266213227608.png](/image-20266213227608.png)

!![image-202662133464.png](/image-202662133464.png)

#Trace é o **rastro de uma requisição enquanto ela atravessa o sistema.**
Ele mostra o caminho completo de uma operação, por exemplo:
```text
Usuário clica em "Comprar"
        ↓
API Gateway
        ↓
Serviço de Pedido
        ↓
Serviço de Pagamento
        ↓
Banco de Dados
        ↓
Serviço de Notificação
```

Em Sistemas distribuídos, trace é essencial, em monólitos simples, às vezes os logs já ajudam bastante.
Mas em microsserviços, podemos ter:
```
frontend → api-gateway → pedido-service → pagamento-service → antifraude-service → banco
```
Sem trace, fica difícil saber onde a requisição travou.
Com trace, vemos o caminho inteiro.

A maioria dos engenheiros de software nunca usou nada além da abordagem dos três pilares e seus silos. Por quê? Porque infraestrutura e operações sempre foram donos das ferramentas, e os três pilares atendem às suas necessidades.

Se você trabalha em infraestrutura, provavelmente opera centenas ou milhares de componentes que você não escreveu e não pode alterar. O código de terceiros vai emitir o que quiser emitir; você tem pouca voz nisso. Você só precisa colocar isso em algum lugar e tirar o melhor proveito possível.

Esse é o problema da infraestrutura, e ele gera um fluxo estrondoso de _Logs_ e _Metrics_ o tempo todo. A solução óbvia ainda é a solução certa: armazenar as métricas em um armazenamento de métricas e armazenar os logs em um armazenamento de logs. E, de preferência, barato — esses sinais têm algum valor, mas não muito.

Esse é o problema da infraestrutura. O problema do desenvolvimento é diferente. Para o código que sua equipe realmente escreve — os serviços que definem sua empresa, seus diferenciais competitivos, seu produto — você tem controle total sobre o que é emitido, como é estruturado e para onde vai.

Você não está preso a aceitar o que quer que o código emita e tentar tirar o melhor proveito disso. Você pode realizar a _Instrumentation_ de forma deliberada. Você pode tomar boas decisões sobre qual contexto preservar, quais relacionamentos manter e como organizar sua _Telemetry_ para preservar opções para o seu eu do futuro.
E isso desbloqueia um valor tremendo se você fizer isso.

**NOTA** Para o restante deste livro, usaremos "_Observability_ tradicional" ou "legada" para descrever essas práticas mais antigas. Usaremos "modelo de três pilares" ou "modelo de múltiplos pilares" quando estivermos nos referindo explicitamente à prática de isolar tipos de sinais em silos, e "_Observability_ moderna" ou "modelo unificado" para a nova abordagem. Trataremos a _Observability_ como um espectro: o estilo tradicional de três pilares produz um baixo grau de observabilidade, enquanto a abordagem que defendemos produz um alto grau.

Isso é importante porque se o verdadeiro custo do software é medido pelo custo de mantê-lo, a _Telemetry_ é provavelmente o ponto de alavancagem mais poderoso que você tem. _Telemetry_ é o seu código respondendo a você de volta da produção, dizendo o que está acontecendo. As decisões que você toma sobre como emitir, armazenar e analisar esses dados não são decisões de infraestrutura, mas decisões de produto. A maioria das equipes tem tomado essas decisões por padrão, não por design.

A primeira placa tectônica, em resumo, é um conjunto de ferramentas construídas para operadores e herdadas por engenheiros. Mas ela acumulou tanta gravidade no ecossistema que continua sendo o padrão — tão profundamente enraizada nas estruturas das equipes, nos relacionamentos com fornecedores e na ergonomia da memória muscular que a maioria das organizações nunca a questiona.

#OpenTelemetry ou #OTel, é um padrão/framework open source para **gerar**, **coletar** e **exportar dados de observabilidade** da nossa aplicação: traces, métricas e logs. Ele é vendor-neutral, ou seja, não é preso a Datadog, New Relic, Grafana, Elastic, AWS, Azure etc.

### The unified Storage Model
