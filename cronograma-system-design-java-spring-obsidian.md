
# Cronograma de Estudos — System Design com foco em Backend Java (Spring Boot)

> Plano em **20 semanas**, estruturado para uso no **Obsidian**, com foco em:
> - Java + Spring Boot
> - APIs REST
> - sistemas distribuídos
> - cache, mensageria e banco de dados
> - entrevistas de system design (pleno/sênior)

---

## Como usar este plano

- Carga sugerida: **10 a 12 horas por semana**
- Ritmo sugerido:
  - **Bloco 1**: leitura principal
  - **Bloco 2**: leitura complementar + notas
  - **Bloco 3**: implementação
  - **Bloco 4**: exercício estilo PR / ADR
  - **Bloco 5**: revisão + perguntas de entrevista
- Mantenha 1 repositório principal no GitHub/GitLab com branches por semana:
  - `week-01-networking-foundations`
  - `week-02-storage-data-modeling`
  - ...
- Em cada semana, gere:
  - 1 PR técnico
  - 1 mini ADR (Architecture Decision Record)
  - 1 resumo de 1 página
  - 1 resposta oral de entrevista gravada em áudio/vídeo

---

## Premissas e observações importantes

- O cronograma foi construído em cima da ementa do treinamento de system design: protocolos de rede, storage/IO, bancos e indexação, CAP/ACID/BASE, microservices vs monólitos, cache, load balancer, BFF, API gateway, comunicação síncrona/assíncrona, service mesh, concorrência, escalabilidade, scale cube, sharding, CQRS, replicação, saga, event sourcing, resiliência, capacity planning, deployment, load/stress, bulkhead, SPOF/DR e observabilidade.
- Quando o índice público de um livro não expõe claramente todos os capítulos/páginas, usei **faixas estimadas** e **blocos temáticos**.
- Este plano foi desenhado para você sair com visão de **engenheiro backend sênior** capaz de:
  - discutir trade-offs de arquitetura
  - defender decisões técnicas
  - evoluir um backend Java real
  - performar melhor em entrevistas de system design

---

## Projeto contínuo do cronograma

# Projeto-base: **EduStream**

Um sistema estilo **YouTube/Netflix para educação**, com:
- catálogo de vídeos
- canais/instrutores
- playlists
- comentários
- likes
- histórico de visualização
- busca
- recomendações simples
- notificações
- assinatura premium
- upload + processamento assíncrono
- analytics básicos

### Arquitetura alvo ao longo das semanas
**Fase 1 — Modular Monolith**
- `identity`
- `catalog`
- `video`
- `playlist`
- `engagement`
- `subscription`
- `notification`

**Fase 2 — Serviços separados**
- `api-gateway`
- `catalog-service`
- `video-service`
- `subscription-service`
- `notification-service`
- `search-read-model`
- `analytics-read-model`

### Stack sugerida
- Java 21+
- Spring Boot
- Spring Web / Validation / Data JPA
- PostgreSQL
- Redis
- RabbitMQ e/ou Kafka
- Docker Compose
- Testcontainers
- Spring Boot Actuator
- Micrometer + Prometheus + Grafana
- OpenTelemetry / Tempo / Zipkin (o que preferir)
- k6 para carga

---

## Mapa dos livros no plano
### 1) Designing Data-Intensive Applications (DDIA)
Use como base de:
- modelagem de dados
- storage engines
- replicação
- particionamento
- transações
- consistência
- processamento em batch/stream

### 2) Fundamentos da Arquitetura de Software
Use como base de:
- characteristics
- trade-offs
- estilos arquiteturais
- arquitetura distribuída
- decisões arquiteturais
- visão de arquiteto

### 3) Building Microservices
Use como base de:
- modelagem e limites
- splitting monolith
- comunicação
- deployment
- testing
- observability
- scaling
- UI/BFF

### 4) Microservices Patterns
Use como base de:
- decomposition
- saga
- CQRS
- event sourcing
- API composition
- business logic e padrões de dados em microservices

### 5) Release It!
Use como base de:
- estabilidade
- circuit breaker
- bulkhead
- timeout
- back pressure
- deployment
- load testing
- caos e operação em produção

### 6) Site Reliability Engineering
Use como base de:
- SLO/SLI
- alerting
- incident response
- postmortem
- load balancing
- overload
- confiabilidade operacional

---

## Banco de vídeos e artigos/docs

> Use os códigos abaixo nas semanas.

### Vídeos

- **V1** — Sam Newman — *Principles of Microservices*
- **V2** — Sam Newman — *Understanding service communication*
- **V3** — *3 System Design Patterns That Show Up in Every Interview* (cache, load balancing, sharding)
- **V4** — *Top 6 Load Balancing Algorithms Every Developer Should Know*
- **V5** — *Consistent Hashing | Algorithms You Should Know*
- **V6** — Martin Kleppmann — *Event Sourcing and Stream Processing at Scale*
- **V7** — Martin Kleppmann — *Thinking in Events: From Databases to Distributed Systems*
- **V8** — *Spring Boot Observability Uncovered*
- **V9** — *Step by Step - Spring Boot Observability*
- **V10** — *The Art of SLOs (Service Level Objectives)*
- **V11** — *Site Reliability Engineering at Google*
- **V12** — *When to Use Kafka or RabbitMQ | System Design*
- **V13** — *gRPC in System Design*
- **V14** — *Service Mesh Explained*
- **V15** — *Chaos Engineering Explained*

### Artigos / documentação

- **A1** — Martin Fowler — *Microservices*
- **A2** — Spring Guide — *Building a RESTful Web Service*
- **A3** — Spring Guide — *Building REST services with Spring*
- **A4** — Spring Guide — *Caching Data with Spring*
- **A5** — Spring Guide — *Messaging with RabbitMQ*
- **A6** — Spring Guide — *Spring Cloud Stream*
- **A7** — Spring Guide — *Building a RESTful Web Service with Spring Boot Actuator*
- **A8** — Spring Guide — *Service Registration and Discovery*
- **A9** — gRPC docs — *Introduction to gRPC*
- **A10** — Istio docs — *What is Istio / Service Mesh*
- **A11** — microservices.io — *API Gateway / Backends for Frontends*
- **A12** — microservices.io — *Saga Pattern*
- **A13** — microservices.io — *CQRS Pattern*
- **A14** — microservices.io — *Event Sourcing Pattern*
- **A15** — AWS Prescriptive Guidance — *Circuit Breaker*
- **A16** — AWS Prescriptive Guidance — *Retry with Backoff*
- **A17** — AWS Well-Architected — *Bulkhead / Cell-based Architecture*
- **A18** — Spring Boot docs — *Caching*
- **A19** — Spring Boot docs — *Kafka Support*
- **A20** — Spring Boot docs — *AMQP / RabbitMQ Support*
- **A21** — Spring Boot docs — *Observability*
- **A22** — Google SRE Workbook — *Implementing SLOs*
- **A23** — Google SRE Workbook — *Alerting on SLOs*
- **A24** — Grafana k6 docs — *API Load Testing / Get Started*
- **A25** — Martin Fowler — *Event Sourcing*
- **A26** — Martin Fowler — *CQRS*
- **A27** — Confluent — *RabbitMQ vs Apache Kafka*
- **A28** — AWS Prescriptive Guidance — *Strangler Fig*
- **A29** — AWS Well-Architected — *Disaster Recovery testing*
- **A30** — AWS Guidance — *Reducing Scope of Impact with Cell-Based Architecture*

---

# Cronograma semanal

---

## Semana 1 — Fundamentos de system design + protocolos de rede

### Objetivos
- Entender o que significa projetar sistemas confiáveis, escaláveis e manuteníveis.
- Revisar HTTP, TCP/IP, DNS, latência, throughput e disponibilidade.
- Começar o projeto EduStream como monólito modular.

### Leitura principal (ordem)
1. **DDIA** — Cap. 1 — *Reliable, Scalable, and Maintainable Applications* — **pp. 1–32 (estim.)**
2. **Fundamentos da Arquitetura de Software (2ª ed.)** — **pp. 1–40**
3. **SRE** — Cap. 1 e 2

### Conteúdos teóricos
- Latência vs throughput
- Availability vs reliability
- Failures em redes e efeitos em sistemas distribuídos
- Características arquiteturais
- Primeira leitura de trade-offs

### Prática aplicada
- Criar repositório `edustream`
- Subir projeto Spring Boot com módulos:
  - `catalog`
  - `identity`
  - `video`
- Criar endpoint `/health` e `/api/videos`
- Documentar diagrama C4 nível 1 e 2

### Exercícios estilo PR
- [ ] **PR-01**: bootstrap do projeto com arquitetura em camadas + validação + tratamento global de erro
- [ ] **PR-02**: endpoint REST para cadastro/listagem de vídeos
- [ ] **ADR-01**: por que começar com modular monolith em vez de microservices?

### Perguntas de entrevista
- O que é escalabilidade?
- Diferença entre disponibilidade e confiabilidade?
- Onde latência de rede vira gargalo em microservices?

### Desafio progressivo
- **Nível júnior**: explique por que um sistema com 99,9% de disponibilidade ainda pode ser ruim para o usuário.

### Conteúdo complementar
- Vídeos: **V1, V3**
- Artigos/docs: **A1, A2**

---

## Semana 2 — Storage, I/O, modelagem de dados e indexação

### Objetivos
- Entender como escolhas de storage impactam leitura/escrita.
- Revisar modelagem relacional, índices e acesso a disco/memória.
- Modelar o domínio principal do EduStream.

### Leitura principal (ordem)
1. **DDIA** — Cap. 2 — *Data Models and Query Languages* — **pp. 33–70 (estim.)**
2. **DDIA** — Cap. 3 — *Storage and Retrieval* — **pp. 71–116 (estim.)**
3. **Fundamentos** — **pp. 41–75**

### Conteúdos teóricos
- B-tree, hash index, full scan
- Modelos relacional, documento e grafo
- OLTP e padrões de acesso
- Índices compostos e trade-offs de escrita

### Prática aplicada
- Modelar entidades:
  - `Video`
  - `Channel`
  - `Playlist`
  - `SubscriptionPlan`
  - `User`
- Criar migrations
- Adicionar índices para:
  - busca por slug
  - listagem por canal
  - ordenação por data de publicação

### Exercícios estilo PR
- [ ] **PR-03**: modelagem JPA + migrations versionadas
- [ ] **PR-04**: benchmark simples de queries com e sem índice
- [ ] **ADR-02**: PostgreSQL primeiro, e não MongoDB, para o core transacional

### Perguntas de entrevista
- Quando um índice ajuda e quando piora?
- Quando escolher SQL vs NoSQL?
- O que muda entre leitura randômica e sequencial?

### Desafio progressivo
- **Nível júnior/pleno**: modelar tabelas para vídeos, likes e comentários sem cair em N+1 e sem indexar tudo.

### Conteúdo complementar
- Vídeos: **V3, V4**
- Artigos/docs: **A3**

---

## Semana 3 — ACID, BASE, CAP, PACELC e consistência

### Objetivos
- Entender consistência em bancos distribuídos.
- Dominar transações, isolamento, replicação e trade-offs.
- Decidir o que será fortemente consistente no EduStream.

### Leitura principal (ordem)
1. **DDIA** — Cap. 7 — *Transactions* — **pp. 249–286 (estim.)**
2. **DDIA** — Cap. 8 — *The Trouble with Distributed Systems* — **pp. 287–328 (estim.)**
3. **DDIA** — Cap. 9 — *Consistency and Consensus* — **pp. 329–370 (estim.)**
4. **Fundamentos** — **pp. 76–110**

### Conteúdos teóricos
- ACID vs BASE
- CAP e PACELC
- Isolation levels
- Consistência forte, eventual, causal
- Quorum e consenso

### Prática aplicada
- Definir matriz de consistência do EduStream:
  - pagamento/assinatura: forte
  - likes/contadores: eventual aceitável
  - feed: eventual
- Implementar casos transacionais no módulo de assinatura

### Exercícios estilo PR
- [ ] **PR-05**: endpoint de assinatura com transação local consistente
- [ ] **PR-06**: documento de trade-offs de consistência por funcionalidade
- [ ] **ADR-03**: por que nem tudo precisa de consistência forte

### Perguntas de entrevista
- O CAP theorem é uma regra de escolha absoluta?
- Quando consistência eventual é aceitável?
- O que é write skew?

### Desafio progressivo
- **Nível pleno**: defender por que o feed pode tolerar atraso, mas o billing não.

### Conteúdo complementar
- Vídeos: **V3**
- Artigos/docs: **A22**

---

## Semana 4 — Monólito modular, domínios e decomposição em microservices

### Objetivos
- Entender limites de domínio e decomposição.
- Saber quando NÃO usar microservices.
- Reestruturar o EduStream com bounded contexts claros.

### Leitura principal (ordem)
1. **Building Microservices** — Cap. 1 — *What Are Microservices?* — **pp. 1–30 (estim.)**
2. **Building Microservices** — Cap. 2 — *How to Model Microservices* — **pp. 31–60 (estim.)**
3. **Building Microservices** — Cap. 3 — *Splitting the Monolith* — **pp. 61–90 (estim.)**
4. **Microservices Patterns** — Cap. 1 e início do Cap. 2
5. **Fundamentos** — bloco sobre estilos arquiteturais distribuídos — **pp. 111–150**

### Conteúdos teóricos
- Coupling e cohesion
- Bounded context
- Database per service
- Strangler fig
- Modular monolith como passo intermediário

### Prática aplicada
- Separar pacotes/módulos por domínio:
  - `catalog`
  - `billing`
  - `engagement`
  - `notification`
- Criar contratos entre módulos

### Exercícios estilo PR
- [ ] **PR-07**: refatorar o projeto de camadas técnicas para domínios
- [ ] **PR-08**: criar interfaces internas entre módulos para reduzir acoplamento
- [ ] **ADR-04**: critérios para extrair o primeiro microservice

### Perguntas de entrevista
- Como saber se o sistema deve continuar monolítico?
- O que caracteriza um bom boundary?
- Quais os sintomas de um “microserviço errado”?

### Desafio progressivo
- **Nível pleno**: escolher o primeiro serviço a sair do monólito e justificar.

### Conteúdo complementar
- Vídeos: **V1, V2**
- Artigos/docs: **A1, A28**

---

## Semana 5 — REST, contratos de API, API Gateway e BFF

### Objetivos
- Consolidar design de APIs HTTP com Spring.
- Entender API gateway e BFF.
- Expor o EduStream de forma segura e organizada para cliente web/mobile.

### Leitura principal (ordem)
1. **Building Microservices** — Cap. 4 — *Microservice Communication Styles* — **pp. 91–118 (estim.)**
2. **Building Microservices** — Cap. 5 — *Implementing Microservice Communication* — **pp. 119–154 (estim.)**
3. **Microservices Patterns** — Cap. 8 — *External API Patterns*
4. **Fundamentos** — **pp. 151–180**

### Conteúdos teóricos
- REST pragmático
- versionamento
- idempotência em HTTP
- API gateway
- BFF
- agregação vs exposição direta de serviços

### Prática aplicada
- Criar contrato da API pública:
  - `/api/videos`
  - `/api/channels`
  - `/api/playlists`
  - `/api/subscriptions`
- Criar camada gateway simples (mesmo que inicialmente seja lógica de edge em um módulo separado)
- Criar BFF para tela “home”

### Exercícios estilo PR
- [ ] **PR-09**: padronizar responses, validation errors e paginação
- [ ] **PR-10**: implementar endpoint agregado para home do cliente
- [ ] **ADR-05**: quando usar BFF e quando evitar

### Perguntas de entrevista
- API gateway é sempre necessário?
- BFF resolve quais dores?
- Quando um endpoint agregado vira gargalo?

### Desafio progressivo
- **Nível pleno**: desenhar API pública e API interna sem duplicar responsabilidade.

### Conteúdo complementar
- Vídeos: **V2, V13**
- Artigos/docs: **A2, A11**

---

## Semana 6 — Load balancer, reverse proxy, discovery e service mesh

### Objetivos
- Entender distribuição de tráfego.
- Diferenciar balanceamento, proxy reverso, discovery e mesh.
- Preparar o EduStream para crescer horizontalmente.

### Leitura principal (ordem)
1. **Release It!** — bloco *Interconnect* — **pp. 165–173 (estim.)**
2. **SRE** — Cap. 19 e 20
3. **Building Microservices** — revisar comunicação e scaling
4. **Fundamentos** — **pp. 181–205**

### Conteúdos teóricos
- Round-robin, least connections, hashing
- reverse proxy
- service discovery
- server-side vs client-side discovery
- service mesh: data plane vs control plane

### Prática aplicada
- Colocar Nginx ou Spring Cloud Gateway na frente do EduStream
- Simular múltiplas instâncias do serviço de catálogo
- Implementar roteamento por caminho
- Desenhar versão futura com service mesh

### Exercícios estilo PR
- [ ] **PR-11**: subir duas instâncias do serviço de catálogo atrás de um proxy
- [ ] **PR-12**: documentar estratégia de discovery para ambiente local e produtivo
- [ ] **ADR-06**: por que não adotar service mesh cedo demais

### Perguntas de entrevista
- Diferença entre load balancer e reverse proxy?
- O que o service mesh resolve sem mexer no código?
- Quando sticky session vira problema?

### Desafio progressivo
- **Nível pleno**: decidir quando o custo operacional do service mesh passa a valer a pena.

### Conteúdo complementar
- Vídeos: **V4, V14**
- Artigos/docs: **A8, A10**

---

## Semana 7 — Cache distribuído e estratégias de performance

### Objetivos
- Entender cache-aside, write-through, TTL, invalidação e stampede.
- Reduzir latência e pressão no banco.
- Introduzir Redis no EduStream.

### Leitura principal (ordem)
1. **DDIA** — revisar partes de storage/retrieval
2. **Release It!** — antipatterns: *Dogpile*, *Slow Responses*; patterns: *Shed Load*, *Back Pressure* — **pp. 116–143 / estim.**
3. **Fundamentos** — bloco sobre performance e characteristics — **pp. 206–230**

### Conteúdos teóricos
- Cache local vs distribuído
- cache-aside
- cache stampede
- invalidação orientada a evento
- query cache vs object cache

### Prática aplicada
- Adicionar Redis
- Cachear:
  - detalhes de vídeo
  - home feed
  - canais populares
- Criar estratégia de invalidação em update de vídeo

### Exercícios estilo PR
- [ ] **PR-13**: adicionar cache em endpoint crítico com métricas de hit/miss
- [ ] **PR-14**: evitar cache stale em atualização de metadados
- [ ] **ADR-07**: o que pode ser cacheado e o que não pode

### Perguntas de entrevista
- Quais os riscos de cache distribuído?
- Como evitar cache stampede?
- Quando cache piora consistência demais?

### Desafio progressivo
- **Nível pleno**: projetar invalidação para home, vídeo e playlists com custo aceitável.

### Conteúdo complementar
- Vídeos: **V3**
- Artigos/docs: **A4, A18**

---

## Semana 8 — Comunicação síncrona, gRPC, concorrência e paralelismo

### Objetivos
- Comparar REST, RPC e gRPC.
- Entender quando paralelizar chamadas e quando evitar acoplamento temporal.
- Aplicar isso ao backend do EduStream.

### Leitura principal (ordem)
1. **Building Microservices** — Cap. 5 — revisão
2. **Fundamentos** — bloco sobre arquitetura distribuída e comunicação — **pp. 231–255**
3. **SRE** — Cap. 21 e 22

### Conteúdos teóricos
- request/response
- fan-out síncrono
- timeout budget
- thread pools
- concorrência em aplicações Java
- bulk requests e agregação

### Prática aplicada
- Criar chamada interna simulada entre `catalog` e `engagement`
- Implementar timeout e fallback
- Criar protótipo gRPC para consulta interna de metadados

### Exercícios estilo PR
- [ ] **PR-15**: cliente HTTP interno com timeout configurável
- [ ] **PR-16**: PoC simples com gRPC para leitura interna
- [ ] **ADR-08**: REST público + gRPC interno faz sentido?

### Perguntas de entrevista
- Quando usar gRPC em vez de REST?
- Por que fan-out síncrono pode destruir disponibilidade?
- Como evitar esgotamento de threads?

### Desafio progressivo
- **Nível pleno**: refatorar endpoint da home para reduzir dependências síncronas em cascata.

### Conteúdo complementar
- Vídeos: **V13, V2**
- Artigos/docs: **A9**

---

## Semana 9 — Mensageria, eventos e streaming

### Objetivos
- Entender comunicação assíncrona com filas e streams.
- Diferenciar RabbitMQ e Kafka.
- Assincronizar partes do EduStream.

### Leitura principal (ordem)
1. **Building Microservices** — Cap. 4 e 5 (revisão focada em async)
2. **Spring Cloud Stream** / docs de messaging
3. **Fundamentos** — **pp. 256–280**

### Conteúdos teóricos
- fila vs log
- pub/sub
- ordering
- consumer groups
- retry em consumidores
- exactly-once vs at-least-once no mundo real

### Prática aplicada
- Publicar evento `VideoPublished`
- Consumir evento em:
  - notificações
  - analytics
  - read model de busca
- Subir RabbitMQ ou Kafka localmente

### Exercícios estilo PR
- [ ] **PR-17**: produtor de eventos de publicação
- [ ] **PR-18**: consumidor idempotente para notificações
- [ ] **ADR-09**: RabbitMQ agora, Kafka depois? justificar

### Perguntas de entrevista
- Quando usar Kafka? Quando usar RabbitMQ?
- O que muda entre command e event?
- O que significa consumer group?

### Desafio progressivo
- **Nível pleno**: decidir qual broker usar para upload processado, notificações e analytics.

### Conteúdo complementar
- Vídeos: **V12**
- Artigos/docs: **A5, A6, A27**

---

## Semana 10 — Resiliência: idempotência, retry, timeout, circuit breaker, fallback, bulkhead

### Objetivos
- Tornar o sistema resistente a falhas parciais.
- Aplicar padrões clássicos do Release It!.
- Usar Resilience4j no EduStream.

### Leitura principal (ordem)
1. **Release It!** — *Stability Patterns* — **pp. 130–143 (estim.)**
2. **Release It!** — *Stability Antipatterns* — **pp. 116–129 (estim.)**
3. **SRE** — Cap. 21 e 22 (handling overload / cascading failures)
4. **Building Microservices** — Cap. 12 — *Resiliency* — **pp. 339–374 (estim.)**

### Conteúdos teóricos
- timeout
- retry com backoff
- circuit breaker
- fallback
- bulkhead
- idempotência em consumers e APIs

### Prática aplicada
- Proteger chamadas entre serviços com Resilience4j
- Criar `Idempotency-Key` para operação crítica
- Simular falha no serviço de pagamentos/assinatura

### Exercícios estilo PR
- [ ] **PR-19**: aplicar circuit breaker + retry + timeout em uma integração
- [ ] **PR-20**: endpoint idempotente para upgrade de assinatura
- [ ] **ADR-10**: quando fallback mascara problema em vez de resolver

### Perguntas de entrevista
- Retry sempre ajuda?
- Qual a diferença entre circuit breaker e timeout?
- Como projetar idempotência sem duplicar cobrança?

### Desafio progressivo
- **Nível pleno/sênior**: desenhar fluxo resiliente para cobrança + emissão de recibo + e-mail.

### Conteúdo complementar
- Vídeos: **V2, V15**
- Artigos/docs: **A15, A16, A17**

---

## Semana 11 — Scale cube, capacidade e escalabilidade

### Objetivos
- Entender scale-up, scale-out, X/Y/Z axis.
- Trabalhar capacidade, throughput e bottlenecks.
- Fazer o primeiro capacity model do EduStream.

### Leitura principal (ordem)
1. **Microservices Patterns** — Cap. 1 (scale cube)
2. **Building Microservices** — Cap. 13 — *Scaling* — **pp. 415–452 (estim.)**
3. **SRE** — Cap. 3 e 27
4. **Fundamentos** — **pp. 281–305**

### Conteúdos teóricos
- vertical vs horizontal scaling
- scale cube
- sticky vs stateless
- resource bottlenecks
- capacity planning inicial

### Prática aplicada
- Estimar:
  - usuários ativos
  - requests/s
  - storage diário
  - crescimento de catálogo
- Criar planilha de capacidade do EduStream

### Exercícios estilo PR
- [ ] **PR-21**: documento de capacity model com hipóteses e fórmulas
- [ ] **PR-22**: tornar endpoint de leitura stateless para scale-out
- [ ] **ADR-11**: onde escalar no eixo X, Y e Z no projeto

### Perguntas de entrevista
- O que é o scale cube?
- Quando shardear pelo domínio e quando pelo dado?
- Como você estima capacidade sem dados perfeitos?

### Desafio progressivo
- **Nível pleno/sênior**: estimar infraestrutura para 1M de usuários cadastrados e 50k concorrentes.

### Conteúdo complementar
- Vídeos: **V3, V5**
- Artigos/docs: **A22**

---

## Semana 12 — Replicação, particionamento, sharding e roteamento

### Objetivos
- Entender como distribuir dados.
- Saber quando usar réplica, partição e shard.
- Aplicar desenho de dados distribuídos no EduStream.

### Leitura principal (ordem)
1. **DDIA** — Cap. 5 — *Replication* — **pp. 155–204 (estim.)**
2. **DDIA** — Cap. 6 — *Partitioning* — **pp. 205–248 (estim.)**
3. **Fundamentos** — **pp. 306–330**

### Conteúdos teóricos
- read replicas
- replication lag
- leader/follower
- partition key
- hot partitions
- consistent hashing

### Prática aplicada
- Desenhar estratégia futura para:
  - shard por região
  - read replica para catálogo
  - particionamento de eventos/analytics
- Criar read path separado para consultas mais pesadas

### Exercícios estilo PR
- [ ] **PR-23**: documento de chave de particionamento e riscos de hot key
- [ ] **PR-24**: criar caminho de leitura separado para consultas pesadas
- [ ] **ADR-12**: por que replicação não substitui particionamento

### Perguntas de entrevista
- Diferença entre replica e shard?
- O que é replication lag e como ele afeta UX?
- Como escolher partition key?

### Desafio progressivo
- **Nível sênior**: projetar particionamento para analytics sem explodir custo e sem perder ordenação importante.

### Conteúdo complementar
- Vídeos: **V5**
- Artigos/docs: **A24** (usar também como leitura sobre performance mindset)

---

## Semana 13 — Transações distribuídas e Saga pattern

### Objetivos
- Entender por que 2PC costuma ser evitado em microservices.
- Implementar saga coreografada ou orquestrada.
- Aplicar isso ao fluxo premium do EduStream.

### Leitura principal (ordem)
1. **Building Microservices** — Cap. 6 — *Workflow* — **pp. 155–190 (estim.)**
2. **Microservices Patterns** — Cap. 4 — *Managing transactions with sagas*
3. **Fundamentos** — **pp. 331–350**

### Conteúdos teóricos
- transação distribuída
- saga orchestration
- saga choreography
- compensação
- isolamento fraco

### Prática aplicada
- Implementar saga de:
  - criar assinatura
  - reservar cobrança
  - ativar plano
  - enviar confirmação
- Adicionar compensação em falha

### Exercícios estilo PR
- [ ] **PR-25**: saga do fluxo premium usando eventos
- [ ] **PR-26**: compensação quando cobrança falhar
- [ ] **ADR-13**: choreography ou orchestration?

### Perguntas de entrevista
- Por que 2PC costuma ser problemático em microservices?
- Como garantir consistência sem transação global?
- O que fazer quando compensação falha?

### Desafio progressivo
- **Nível sênior**: desenhar saga de compra de plano anual com cupom, cobrança e notificação.

### Conteúdo complementar
- Vídeos: **V2, V12**
- Artigos/docs: **A12**

---

## Semana 14 — Queries distribuídas, API Composition e CQRS

### Objetivos
- Resolver leitura em arquitetura distribuída.
- Comparar API Composition vs CQRS.
- Criar read model para a home do EduStream.

### Leitura principal (ordem)
1. **Microservices Patterns** — Cap. 7 — *Implementing queries in a microservice architecture*
2. **Martin Fowler / CQRS**
3. **Fundamentos** — **pp. 351–370**

### Conteúdos teóricos
- distributed query problem
- API composition
- read model
- write model
- duplicação intencional de dados

### Prática aplicada
- Criar `home-feed-read-model`
- Montar pipeline simples de atualização por eventos
- Comparar latência:
  - composição síncrona
  - leitura pronta no read model

### Exercícios estilo PR
- [ ] **PR-27**: read model da home baseado em eventos
- [ ] **PR-28**: endpoint de leitura desacoplado do write model
- [ ] **ADR-14**: API composition vs CQRS para a home

### Perguntas de entrevista
- CQRS é obrigatório em microservices?
- Quando API composition basta?
- Qual o custo operacional de um read model?

### Desafio progressivo
- **Nível sênior**: justificar em quais telas do produto vale CQRS e em quais não vale.

### Conteúdo complementar
- Vídeos: **V3**
- Artigos/docs: **A13, A26**

---

## Semana 15 — Event sourcing, domain events e trilhas de auditoria

### Objetivos
- Entender o padrão de event sourcing sem romantização.
- Saber quando usá-lo e quando evitá-lo.
- Aplicar event log em parte pequena do EduStream.

### Leitura principal (ordem)
1. **Microservices Patterns** — Cap. 5 — *Designing business logic...*
2. **Microservices Patterns** — Cap. 6 — *Event sourcing*
3. **Martin Fowler** — *Event Sourcing*
4. **DDIA** — Cap. 11 — *Stream Processing* — **pp. 431–494 (estim.)**

### Conteúdos teóricos
- event log
- replay
- projections
- snapshots
- versionamento de eventos
- custo cognitivo do pattern

### Prática aplicada
- Implementar event sourcing apenas em um subdomínio controlado:
  - histórico de assinatura
  - ou auditoria de mudanças de playlist
- Criar projection consultável

### Exercícios estilo PR
- [ ] **PR-29**: event store simples para histórico de assinatura
- [ ] **PR-30**: projection de estado atual a partir do log
- [ ] **ADR-15**: por que limitar event sourcing a um subdomínio

### Perguntas de entrevista
- Event sourcing é banco de dados?
- Qual a diferença entre event sourcing e apenas publicar eventos?
- Quando snapshots são necessários?

### Desafio progressivo
- **Nível sênior**: defender por que event sourcing aumenta poder analítico, mas também aumenta complexidade operacional.

### Conteúdo complementar
- Vídeos: **V6, V7**
- Artigos/docs: **A14, A25**

---

## Semana 16 — Deployment: blue/green, canary, feature toggles, versionamento

### Objetivos
- Entender release segura.
- Praticar rollout controlado.
- Reduzir risco de deploy no EduStream.

### Leitura principal (ordem)
1. **Release It!** — *Design for Deployment* e *Handling Versions* — **pp. 192–205 (estim.)**
2. **SRE** — Cap. 8 e 27
3. **Building Microservices** — Cap. 8 — *Deployment* — **pp. 227–264 (estim.)**

### Conteúdos teóricos
- blue/green
- canary
- feature toggles
- backward compatibility
- API versioning
- rollout + rollback

### Prática aplicada
- Simular deploy blue/green com Docker Compose
- Adicionar feature flag para recomendações
- Garantir compatibilidade entre versões do evento `VideoPublished`

### Exercícios estilo PR
- [ ] **PR-31**: pipeline de deploy com duas versões simultâneas
- [ ] **PR-32**: feature flag para um endpoint/funcionalidade nova
- [ ] **ADR-16**: como versionar eventos e APIs sem quebrar consumidores

### Perguntas de entrevista
- Quando usar canary vs blue/green?
- O que precisa ser backward compatible?
- Como rollback interage com schema e eventos?

### Desafio progressivo
- **Nível sênior**: desenhar rollout seguro para novo serviço de recomendação.

### Conteúdo complementar
- Vídeos: **V1**
- Artigos/docs: **A28**

---

## Semana 17 — Observabilidade, métricas, tracing, logs e SLOs

### Objetivos
- Entender observabilidade como pilar de operação.
- Instrumentar o EduStream.
- Criar SLI/SLO para jornadas críticas.

### Leitura principal (ordem)
1. **SRE** — Cap. 4, 5, 10
2. **Spring Boot docs** — *Observability*
3. **Spring Guide** — *Actuator*
4. **Building Microservices** — Cap. 10 — *From Monitoring to Observability* — **pp. 303–338 (estim.)**

### Conteúdos teóricos
- logs, metrics, traces
- correlação
- golden signals
- SLI, SLO, SLA
- error budget

### Prática aplicada
- Adicionar Actuator + Micrometer
- Exportar métricas
- Criar dashboards:
  - latência p95
  - erro por endpoint
  - consumo de fila
  - cache hit ratio
- Criar SLO para:
  - playback metadata API
  - checkout de assinatura

### Exercícios estilo PR
- [ ] **PR-33**: métricas e health checks produtivos
- [ ] **PR-34**: tracing em fluxo com evento assíncrono
- [ ] **ADR-17**: quais SLOs importam de verdade para o produto

### Perguntas de entrevista
- O que você monitora primeiro?
- Diferença entre monitoramento e observabilidade?
- Como definir um bom SLO?

### Desafio progressivo
- **Nível sênior**: definir 3 SLOs úteis e evitar métricas vanity.

### Conteúdo complementar
- Vídeos: **V8, V9**
- Artigos/docs: **A7, A21, A22, A23**

---

## Semana 18 — Testes de carga, stress, chaos e engenharia de performance

### Objetivos
- Validar comportamento sob carga.
- Diferenciar load, stress, spike, soak e breakpoint test.
- Levar performance para o ciclo de entrega.

### Leitura principal (ordem)
1. **Release It!** — *Load Testing* + *Chaos Engineering* — **pp. 206–226 (estim.)**
2. **SRE** — Cap. 17
3. **Grafana k6 docs**

### Conteúdos teóricos
- tipos de teste de carga
- thresholds
- capacity validation
- chaos experiment
- falha controlada

### Prática aplicada
- Criar testes k6 para:
  - listagem de vídeos
  - home feed
  - checkout premium
- Rodar smoke, load e stress
- Simular indisponibilidade do Redis ou do broker

### Exercícios estilo PR
- [ ] **PR-35**: suíte de carga inicial com thresholds
- [ ] **PR-36**: relatório com gargalos encontrados e plano de mitigação
- [ ] **ADR-18**: quais cenários devem entrar no CI e quais ficam sob demanda

### Perguntas de entrevista
- Diferença entre load test e stress test?
- Como escolher volume de usuários concorrentes?
- O que fazer quando o teste não reproduz produção?

### Desafio progressivo
- **Nível sênior**: desenhar experimento para provar se o gargalo está no banco, cache ou aplicação.

### Conteúdo complementar
- Vídeos: **V15**
- Artigos/docs: **A24**

---

## Semana 19 — Bulkhead, cell-based architecture, SPOF e disaster recovery

### Objetivos
- Reduzir blast radius.
- Mapear pontos únicos de falha.
- Desenhar continuidade operacional para o EduStream.

### Leitura principal (ordem)
1. **Release It!** — *Bulkheads* e *Stopping Crack Propagation* — **pp. 109–143 (estim.)**
2. **AWS / bulkhead / cell-based guidance**
3. **SRE** — Cap. 22, 23 e 26

### Conteúdos teóricos
- SPOF
- blast radius
- bulkhead
- cell-based architecture
- backup, failover, RTO, RPO
- disaster recovery drills

### Prática aplicada
- Mapear SPOFs:
  - banco principal
  - redis
  - broker
  - gateway
  - auth
- Definir estratégia DR:
  - backup
  - restore
  - documentação
  - runbook

### Exercícios estilo PR
- [ ] **PR-37**: documento de SPOF + mitigação
- [ ] **PR-38**: runbook de indisponibilidade do banco ou do broker
- [ ] **ADR-19**: quando vale partir para cell-based

### Perguntas de entrevista
- O que é bulkhead?
- Como identificar SPOF escondido?
- Qual a diferença entre alta disponibilidade e DR?

### Desafio progressivo
- **Nível sênior**: projetar o EduStream para isolar falha por região, tenant ou célula.

### Conteúdo complementar
- Vídeos: **V11, V15**
- Artigos/docs: **A17, A29, A30**

---

## Semana 20 — Consolidação sênior + entrevistas de system design

### Objetivos
- Consolidar tudo em visão de arquiteto/backend sênior.
- Treinar resposta estruturada para entrevistas.
- Fechar o projeto com arquitetura defendável.

### Leitura principal (ordem)
1. **Fundamentos** — **pp. 371–496** (fechamento, governança, decisão, revisão)
2. **Building Microservices** — Cap. 14, 15 e 16 — **pp. 453–550 (estim.)**
3. **SRE** — Cap. 14, 15 e 34
4. **DDIA** — Cap. 12 — *The Future of Data Systems* — **pp. 495–556 (estim.)**

### Conteúdos teóricos
- comunicação arquitetural
- trade-offs explícitos
- argumentação técnica
- postmortem e aprendizado
- evolução arquitetural

### Prática aplicada
- Entregar arquitetura final do EduStream com:
  - diagrama C4
  - fluxo síncrono e assíncrono
  - estratégia de cache
  - read models
  - SLOs
  - capacity planning
  - DR/runbooks
- Fazer 3 mock interviews

### Exercícios estilo PR
- [ ] **PR-39**: arquitetura final consolidada do projeto
- [ ] **PR-40**: README sênior com trade-offs, riscos e roadmap
- [ ] **ADR-20**: decisão final — o que ficou monolítico, o que virou serviço, o que ainda não vale extrair

### Perguntas de entrevista
- Desenhe um sistema tipo YouTube para metadados e feed.
- Como você escala um serviço de catálogo?
- Como você define o que é crítico e o que pode ser eventual?
- Como você faria rollout seguro?
- Como você investigaria latência alta no p95?
- Quais trade-offs você fez e por quê?

### Desafio progressivo
- **Nível sênior**: apresentar o design completo em 35–45 minutos, com requisitos funcionais e não funcionais, gargalos, riscos e mitigação.

### Conteúdo complementar
- Vídeos: **V1, V11**
- Artigos/docs: **A1, A22, A23**

---

# Trilha paralela de exercícios de entrevista (do júnior ao sênior)
## Bloco 1 — Base (Semanas 1–5)
- [ ] O que é escalabilidade horizontal?
- [ ] O que muda entre REST síncrono e fila assíncrona?
- [ ] Como você desenharia uma API de catálogo?
- [ ] Quando um índice no banco ajuda de verdade?
- [ ] O que significa “bounded context”?

## Bloco 2 — Intermediário (Semanas 6–10)
- [ ] Como você faria cache de home feed?
- [ ] Como reduzir acoplamento entre serviços?
- [ ] Como evitar chamadas síncronas em cascata?
- [ ] Kafka ou RabbitMQ: como decidir?
- [ ] Como implementar idempotência em cobrança?

## Bloco 3 — Avançado (Semanas 11–15)
- [ ] Como shardear dados de um sistema grande?
- [ ] Em que cenários CQRS compensa?
- [ ] O que é saga e como ela falha?
- [ ] Event sourcing é necessário aqui?
- [ ] Como separar write model e read model?

## Bloco 4 — Sênior (Semanas 16–20)
- [ ] Como desenhar um rollout canário seguro?
- [ ] Quais seriam seus SLOs?
- [ ] Como você testaria comportamento sob overload?
- [ ] Onde estão os SPOFs?
- [ ] Como reduzir blast radius?
- [ ] O que você manteria simples de propósito?

---

# Checklist de entregáveis finais

- [ ] Monólito modular inicial
- [ ] 2–4 serviços separados
- [ ] API pública documentada
- [ ] Gateway/BFF básico
- [ ] Redis em produção local
- [ ] Broker (RabbitMQ ou Kafka)
- [ ] Pelo menos 1 saga implementada
- [ ] Pelo menos 1 read model CQRS
- [ ] Pelo menos 1 subdomínio com event log/auditoria
- [ ] Resilience4j configurado
- [ ] Observabilidade com métricas + traces + logs
- [ ] Testes de carga com k6
- [ ] Runbook de incidente
- [ ] Documento de capacity planning
- [ ] Documento de SPOF/DR
- [ ] Arquitetura final explicável em entrevista

---

# Ordem macro de leitura dos livros

## Ordem principal
1. DDIA
2. Fundamentos da Arquitetura de Software
3. Building Microservices
4. Microservices Patterns
5. Release It!
6. Site Reliability Engineering

## Ordem prática ao longo do plano
- **Semanas 1–3**: DDIA + Fundamentos
- **Semanas 4–6**: Building Microservices + Microservices Patterns + Fundamentos
- **Semanas 7–10**: Release It! + Spring docs + BM
- **Semanas 11–15**: DDIA + Microservices Patterns + BM
- **Semanas 16–20**: Release It! + SRE + Fundamentos + revisão

---

# Rotina semanal sugerida

## Segunda
- leitura principal (1h30 a 2h)

## Terça
- leitura complementar + anotações

## Quarta
- implementação da semana

## Quinta
- PR técnico + testes

## Sexta
- perguntas de entrevista + ADR

## Sábado
- revisão geral + vídeo complementar

---

# Resultado esperado ao final

Se você executar esse plano com disciplina, no final você deve conseguir:

- explicar arquiteturas distribuídas com clareza
- defender trade-offs de consistência, cache, mensageria e escalabilidade
- sair do “CRUD Spring Boot” para “backend orientado a arquitetura”
- desenhar sistemas em entrevistas com começo, meio e fim
- discutir riscos operacionais e não só modelagem de código
- ter um projeto real para mostrar evolução arquitetural

---

# Próximo passo recomendado

Quando terminar a Semana 4, faça uma pausa curta e responda por escrito:

1. Quais domínios do EduStream estão realmente claros?
2. O que ainda está acoplado sem necessidade?
3. O primeiro microservice precisa mesmo existir?
4. Onde está seu maior gargalo hoje: modelo mental, código ou operação?

Essa reflexão costuma separar estudo passivo de evolução real.
