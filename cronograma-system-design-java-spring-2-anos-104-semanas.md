# Cronograma de 2 anos — System Design com foco em Backend Java + Spring Boot

> Versão refeita do plano anterior, agora com **104 semanas**, carga de leitura mais leve e checkpoints frequentes.
> Objetivo: sair do ciclo com repertório para atuar com mais segurança em **backend sênior**, discutir **arquitetura distribuída** e performar melhor em **entrevistas de system design**.

## Princípios deste plano

- **Carga sustentável**: a maior parte das semanas fica em **10–25 páginas** de leitura útil, não capítulos inteiros comprimidos.
- **1 semana de consolidação por bloco**: ao fim de cada trimestre há uma semana mais leve, focada em revisão, refatoração e comunicação arquitetural.
- **Projeto contínuo realista**: o projeto evolui de **monólito modular** para um conjunto pequeno de serviços distribuídos.
- **Profundidade antes de hype**: primeiro fundamentos de dados, rede, contratos e limites distribuídos; depois patterns avançados.
- **Java + Spring como trilha principal**: tudo que for prática deve convergir para ecossistema Java/Spring.

## Projeto contínuo

Você vai evoluir o projeto **StreamForge**, uma plataforma estilo **YouTube/Netflix educacional**, com:

- usuários, criadores e assinaturas;
- catálogo de vídeos/aulas;
- comentários, notificações e analytics;
- gateway, BFF, cache, mensageria e observabilidade;
- cenários de escala, consistência eventual, resiliência e DR.

## Ritmo semanal recomendado

- **Sessão 1**: leitura + notas no Obsidian
- **Sessão 2**: leitura + resumo técnico / ADR
- **Sessão 3**: prática aplicada
- **Sessão 4**: PR da semana
- **Sessão 5**: revisão + pergunta de entrevista em voz alta

> Meta de tempo: **6 a 8 horas por semana**.  
> Se uma semana apertar, preserve a prática e empurre parte da leitura para a semana de consolidação seguinte.

## Como usar este cronograma

- Marque cada semana como concluída apenas quando tiver:
  - lido o trecho principal;
  - feito a prática;
  - aberto/feito o PR da semana;
  - respondido pelo menos uma pergunta de entrevista sem consultar notas.
- Sempre que possível, escreva:
  - `ADR`
  - `trade-offs`
  - `riscos`
  - `o que eu faria diferente em produção`

## Livros-base

- **Designing Data-Intensive Applications (DDIA)**
- **Fundamentals of Software Architecture**
- **Building Microservices (2nd ed.)**
- **Microservices Patterns**
- **Release It! (2nd ed.)**
- **Site Reliability Engineering**

## Observação sobre páginas

As **faixas de páginas são intencionalmente conservadoras** e podem variar conforme a edição impressa/digital, idioma e diagramação.  
Aqui o foco é: **capítulo exato + trecho leve + cadência sustentável**.

---

# Plano semanal detalhado
## Q1 — Fundamentos: arquitetura, rede, storage e dados

### Semana 01 — Kickoff, ambiente e método de estudo
- [ ] **Objetivos**
  - Definir o ritmo realista de 2 anos e organizar o vault/repositório.
  - Criar a base do projeto contínuo `StreamForge` em Spring Boot.
- [ ] **Leitura da semana**
  - Fundamentals of Software Architecture (FOSA) — cap. 1, leitura leve (~10–15 págs).
  - Ementa do curso: visão geral dos blocos de protocolos, storage, bancos, microsserviços, resiliência e observabilidade.
- [ ] **Prática aplicada**
  - Criar monorepo com módulos `api`, `domain`, `infra`, `docs`.
  - Subir Spring Boot + PostgreSQL + Redis via Docker Compose; escrever README inicial e convenções de branch/PR.
- [ ] **Exercício estilo PR**
  - PR 001: bootstrap do projeto, arquitetura inicial em camadas, healthcheck, Actuator e README com setup.
- [ ] **Perguntas de entrevista**
  - Explique a diferença entre #arquitetura, #design e #implementação.
  - Quando faz sentido começar com monólito em vez de microsserviços?

### Semana 02 — Pensamento arquitetural + DDIA capítulo 1 (parte 1)

- [ ] **Objetivos**
  - Entender confiabilidade, escalabilidade e manutenibilidade.
  - Aprender a observar trade-offs como arquiteto, não só como implementador.
- [ ] **Leitura da semana**
  - FOSA — cap. 2: Architectural Thinking (~12–18 págs).
  - DDIA — cap. 1, blocos 'Thinking About Data Systems' e 'Reliability' (~12–18 págs).
- [ ] **Prática aplicada**
  - Criar ADR 001 definindo objetivos arquiteturais do StreamForge.
  - Implementar endpoint `/health/details` e uma tela/JSON de runtime com versão, banco e cache.
- [ ] **Exercício estilo PR**
  - PR 002: ADR 001 + endpoint de health detalhado + justificativa de características arquiteturais prioritárias.
- [ ] **Perguntas de entrevista**
  - O que é uma arquitetura escalável?
  - Quais atributos de qualidade você priorizaria para uma plataforma estilo YouTube/Netflix educativa?

### Semana 03 — DDIA capítulo 1 (parte 2)

- [ ] **Objetivos**
  - Fixar os conceitos de carga, performance e evolução do sistema.
  - Relacionar SLOs futuros com decisões de design presentes.
- [ ] **Leitura da semana**
  - DDIA — cap. 1, blocos 'Scalability' e 'Maintainability' (~15–20 págs).
  - Revisão curta das anotações da semana 2.
- [ ] **Prática aplicada**
  - Criar benchmark ingênuo de um endpoint simples com 100/500/1000 reqs.
  - Documentar gargalos óbvios: pool de conexão, serialização, latência de banco.
- [ ] **Exercício estilo PR**
  - PR 003: benchmark inicial + documento 'baseline-performance.md' com hipóteses e riscos.
- [ ] **Perguntas de entrevista**
  - Como você descreveria carga e performance de um sistema para um entrevistador?
  - Escalabilidade vertical e horizontal: quando cada uma é aceitável?

### Semana 04 — Protocolos de rede I: TCP/IP, DNS, HTTP

- [ ] **Objetivos**
  - Construir base sólida de rede para discutir system design com clareza.
  - Entender como DNS, TCP e HTTP aparecem no dia a dia de APIs.
- [ ] **Leitura da semana**
  - Leitura guiada das notas próprias sobre TCP/IP, DNS, HTTP/1.1 e HTTP/2 (~15 págs produzidas por você).
  - FOSA — revisão cap. 1–2, sem leitura nova pesada.
- [ ] **Prática aplicada**
  - Implementar `/videos` e `/users` com REST básico, paginação simples e códigos HTTP corretos.
  - Desenhar fluxo cliente → DNS → LB → app → banco em um diagrama Mermaid.
- [ ] **Exercício estilo PR**
  - PR 004: endpoints REST básicos + diagrama de requisição ponta a ponta + convenções HTTP.
- [ ] **Perguntas de entrevista**
  - Explique o caminho de uma requisição do navegador até a aplicação.
  - Quando HTTP/2 ajuda e quando não resolve gargalo nenhum?

### Semana 05 — Storage, RAID, I/O e latência

- [ ] **Objetivos**
  - Relacionar discos, memória, throughput e latência com decisões de backend.
  - Evitar decisões arquiteturais 'abstratas demais' sem noção de hardware.
- [ ] **Leitura da semana**
  - Anotações de storage/RAID/I/O (~12–18 págs estudadas com calma).
  - DDIA — retomada curta do cap. 1 com foco em latência e custo de acesso a dados.
- [ ] **Prática aplicada**
  - Instrumentar tempo de resposta por camada: controller, service, repository.
  - Rodar testes comparando resposta cacheada x não cacheada.
- [ ] **Exercício estilo PR**
  - PR 005: métricas de latência por camada + relatório curto 'io-e-latencia.md'.
- [ ] **Perguntas de entrevista**
  - Por que latência de disco e latência de rede importam em desenho de sistemas?
  - Como storage influencia escolha entre cache, fila e banco?

### Semana 06 — DDIA capítulo 2 (parte 1): modelos de dados

- [ ] **Objetivos**
  - Comparar modelo relacional, documento e grafo sem dogmatismo.
  - Entender quando o modelo de dados vira gargalo de produto.
- [ ] **Leitura da semana**
  - DDIA — cap. 2, blocos 'Relational vs. Document Model' e 'Query Languages for Data' (~15–20 págs).
  - FOSA — cap. 3: Modularity (parte 1, ~10–12 págs).
- [ ] **Prática aplicada**
  - Modelar entidades iniciais: usuário, vídeo, aula, playlist, comentário, inscrição.
  - Criar migrations e restrições básicas no PostgreSQL.
- [ ] **Exercício estilo PR**
  - PR 006: modelagem inicial + migrations + justificativa de escolha relacional com trade-offs.
- [ ] **Perguntas de entrevista**
  - Document database ou relational database para catálogo de vídeos e comentários?
  - Como relações many-to-many impactam sua escolha de banco?

### Semana 07 — DDIA capítulo 2 (parte 2): grafos, consultas e relacionamentos

- [ ] **Objetivos**
  - Aprofundar o raciocínio de consultas e evolução do domínio.
  - Perceber onde grafos e busca podem entrar futuramente.
- [ ] **Leitura da semana**
  - DDIA — cap. 2, blocos 'Graph-like Data Models' e resumo final (~12–18 págs).
  - FOSA — cap. 3: Modularity (parte 2, ~10–12 págs).
- [ ] **Prática aplicada**
  - Refatorar agregados e repositórios para evitar acoplamento desnecessário.
  - Criar consulta para feed básico de vídeos por categoria e autor.
- [ ] **Exercício estilo PR**
  - PR 007: refatoração modular do domínio + consulta de feed + documento de invariantes do domínio.
- [ ] **Perguntas de entrevista**
  - Quando um grafo faz mais sentido do que joins tradicionais?
  - Como modularidade ruim cobra juros no futuro?

### Semana 08 — DDIA capítulo 3 (parte 1): índices e estruturas

- [ ] **Objetivos**
  - Entender hash indexes, LSM-trees e B-trees em nível arquitetural.
  - Ligar indexação com custo de leitura e escrita.
- [ ] **Leitura da semana**
  - DDIA — cap. 3, blocos 'Data Structures that Power Your Database', 'Hash indexes' e 'SSTables and LSM-trees' (~15–20 págs).
  - Sem leitura nova de outro livro nesta semana.
- [ ] **Prática aplicada**
  - Criar índices para listagem de vídeos, busca por autor e ordenação por data.
  - Usar `EXPLAIN ANALYZE` para comparar query sem índice x com índice.
- [ ] **Exercício estilo PR**
  - PR 008: índices iniciais + relatório de plano de execução + decisão de trade-off leitura/escrita.
- [ ] **Perguntas de entrevista**
  - O que é um índice e por que ele não é 'de graça'?
  - Quando muitos índices atrapalham mais do que ajudam?

### Semana 09 — DDIA capítulo 3 (parte 2): OLTP vs analytics

- [ ] **Objetivos**
  - Separar carga transacional de carga analítica.
  - Perceber quando um único banco começa a servir mal objetivos diferentes.
- [ ] **Leitura da semana**
  - DDIA — cap. 3, blocos 'B-trees', 'Transaction Processing or Analytics?' e resumo (~15–20 págs).
  - FOSA — cap. 4: Architecture Characteristics Defined (parte 1, ~10–12 págs).
- [ ] **Prática aplicada**
  - Criar tabela/materialização simples de métricas de vídeo por dia.
  - Gerar endpoint administrativo `/analytics/videos/top` sem degradar a API principal.
- [ ] **Exercício estilo PR**
  - PR 009: read model analítico simples + documentação do porquê separar OLTP de analytics.
- [ ] **Perguntas de entrevista**
  - OLTP e OLAP: diferença prática em uma entrevista.
  - Quando vale ter read model separado ou data warehouse?

### Semana 10 — DDIA capítulo 4 (parte 1): encoding e contratos

- [ ] **Objetivos**
  - Aprender por que serialização e contratos quebram sistemas distribuídos.
  - Preparar terreno para versionamento de APIs e eventos.
- [ ] **Leitura da semana**
  - DDIA — cap. 4, blocos 'Formats for Encoding Data' até 'Avro' (~15–20 págs).
  - FOSA — cap. 4: parte 2, concluindo características arquiteturais.
- [ ] **Prática aplicada**
  - Versionar DTOs de entrada/saída e documentar política de compatibilidade retroativa.
  - Criar evento de domínio `VideoPublished` em JSON versionado.
- [ ] **Exercício estilo PR**
  - PR 010: versionamento inicial de contrato REST + primeiro evento versionado + testes de compatibilidade.
- [ ] **Perguntas de entrevista**
  - Por que evoluir contrato é mais difícil em sistemas distribuídos?
  - Backward e forward compatibility: onde isso aparece no dia a dia?

### Semana 11 — DDIA capítulo 4 (parte 2): data flow

- [ ] **Objetivos**
  - Entender fluxo via banco, serviços e mensageria.
  - Preparar a transição do monólito para integração entre serviços.
- [ ] **Leitura da semana**
  - DDIA — cap. 4, blocos 'Modes of Data Flow' e resumo (~12–18 págs).
  - FOSA — cap. 5: Identifying Architectural Characteristics (parte 1, ~10–12 págs).
- [ ] **Prática aplicada**
  - Documentar quais fluxos do StreamForge serão síncronos, assíncronos e batch.
  - Criar ADR 002 para contratos REST e eventos internos.
- [ ] **Exercício estilo PR**
  - PR 011: ADR 002 + mapa de fluxos de dados + testes de serialização.
- [ ] **Perguntas de entrevista**
  - Quando você escolhe REST, fila ou banco compartilhado para integrar módulos?
  - Qual o principal risco de banco compartilhado entre serviços?

### Semana 12 — ACID, isolamento e modelagem transacional

- [ ] **Objetivos**
  - Consolidar noções de consistência local antes de distribuição.
  - Aprender a falar de isolation levels sem decorar buzzwords.
- [ ] **Leitura da semana**
  - DDIA — cap. 7, introdução + 'The meaning of ACID' (~12–18 págs).
  - FOSA — cap. 5: parte 2, fechando atributos prioritários.
- [ ] **Prática aplicada**
  - Implementar caso de uso 'inscrever usuário em curso/plano' com transação explícita.
  - Escrever testes cobrindo erro parcial e rollback.
- [ ] **Exercício estilo PR**
  - PR 012: inscrição transacional + testes de rollback + nota sobre invariantes críticas.
- [ ] **Perguntas de entrevista**
  - O que ACID resolve e o que ACID não resolve?
  - Qual bug de concorrência você esperaria nesse fluxo de inscrição?

### Semana 13 — Consolidação do 1º trimestre

- [ ] **Objetivos**
  - Revisar profundamente semanas 1–12 sem adicionar carga pesada.
  - Fechar a versão `v0.1` do projeto com base monolítica sólida.
- [ ] **Leitura da semana**
  - Revisão das anotações, ADRs e capítulos já estudados; sem capítulo novo obrigatório.
  - Checklist de lacunas: rede, banco, transações, índices, contratos.
- [ ] **Prática aplicada**
  - Refatorar pacotes, remover dívida técnica óbvia e padronizar testes.
  - Preparar apresentação de 10 minutos explicando a arquitetura atual.
- [ ] **Exercício estilo PR**
  - PR 013: cleanup do trimestre + changelog arquitetural + demo gravada curta.
- [ ] **Perguntas de entrevista**
  - Desenhe a arquitetura atual em 5 minutos.
  - Quais decisões você manteria e quais adiaria para evitar overengineering?


## Q2 — Modularidade, decomposição e dados distribuídos
### Semana 14 — FOSA capítulo 6: medir e governar características arquiteturais

- [ ] **Objetivos**
  - Aprender a medir em vez de apenas afirmar atributos de qualidade.
  - Introduzir fitness functions e critérios observáveis.
- [ ] **Leitura da semana**
  - FOSA — cap. 6 (parte 1, ~10–15 págs).
  - Revisão breve de métricas já coletadas no projeto.
- [ ] **Prática aplicada**
  - Criar checklist de fitness functions: tempo de build, tempo de resposta, cobertura mínima, lint, smoke test.
  - Adicionar pipeline CI inicial.
- [ ] **Exercício estilo PR**
  - PR 014: CI inicial + fitness functions básicas + documento de governança leve.
- [ ] **Perguntas de entrevista**
  - Como provar que sua arquitetura suporta escalabilidade ou confiabilidade?
  - O que é uma fitness function?

### Semana 15 — FOSA capítulos 6–7: governança e escopo

- [ ] **Objetivos**
  - Entender que nem toda decisão vale para todo o sistema.
  - Separar regras globais de regras locais.
- [ ] **Leitura da semana**
  - FOSA — cap. 6 (parte 2) e cap. 7 (parte 1), ~12–18 págs no total.
  - Leitura leve das ADRs já escritas.
- [ ] **Prática aplicada**
  - Definir quais regras são globais (observabilidade, versionamento, segurança) e quais são por módulo.
  - Criar template oficial de ADR para o repositório.
- [ ] **Exercício estilo PR**
  - PR 015: template de ADR + matriz 'regra global vs regra local'.
- [ ] **Perguntas de entrevista**
  - Quais decisões devem ser centralizadas e quais podem ser descentralizadas?
  - Como excesso de padronização prejudica um time?

### Semana 16 — FOSA capítulo 8: component-based thinking

- [ ] **Objetivos**
  - Modelar módulos por responsabilidade e coesão.
  - Preparar futura separação em serviços sem sair quebrando tudo.
- [ ] **Leitura da semana**
  - FOSA — cap. 8 (parte 1, ~10–15 págs).
  - Revisão do domínio atual do StreamForge.
- [ ] **Prática aplicada**
  - Refatorar o monólito para módulos mais explícitos: catálogo, usuários, billing, notificações, analytics.
  - Remover acesso cruzado indevido entre módulos.
- [ ] **Exercício estilo PR**
  - PR 016: modularização explícita do monólito + testes de fronteira entre módulos.
- [ ] **Perguntas de entrevista**
  - O que caracteriza um bom componente?
  - Como saber se um módulo está grande demais?

### Semana 17 — Monólito, modular monolith e bounded contexts

- [ ] **Objetivos**
  - Entender migração saudável antes de falar em microservices.
  - Praticar separação por contexto de negócio.
- [ ] **Leitura da semana**
  - Building Microservices (BM) — cap. 1, metade 1 (~12–15 págs).
  - FOSA — cap. 8, parte 2 (~8–10 págs).
- [ ] **Prática aplicada**
  - Mapear bounded contexts: catálogo, identidade, assinatura, comentários, notificações, ingestão de mídia.
  - Desenhar event storming textual simples.
- [ ] **Exercício estilo PR**
  - PR 017: mapa de bounded contexts + proposta de fronteiras + decisão de manter monólito modular por enquanto.
- [ ] **Perguntas de entrevista**
  - Como você escolheria as fronteiras iniciais de microsserviços?
  - Por que modular monolith pode ser uma etapa ótima?

### Semana 18 — Building Microservices capítulo 1 (parte 2)

- [ ] **Objetivos**
  - Avaliar benefícios e custos de microsserviços sem romantização.
  - Traduzir conceitos do livro para Java/Spring.
- [ ] **Leitura da semana**
  - BM — cap. 1, metade 2 (~12–15 págs).
  - Microservices Patterns (MP) — cap. 1, introdução (~8–10 págs).
- [ ] **Prática aplicada**
  - Escrever documento 'quando NÃO quebrar em microservices' para o projeto.
  - Criar backlog de sinais de extração futura por módulo.
- [ ] **Exercício estilo PR**
  - PR 018: decisão arquitetural com critérios de extração futura + exemplos concretos do StreamForge.
- [ ] **Perguntas de entrevista**
  - Microsserviços não são bala de prata: dê exemplos reais.
  - Quais sinais indicam que um módulo merece virar serviço separado?

### Semana 19 — Building Microservices capítulo 2 (parte 1): modelagem de serviços

- [ ] **Objetivos**
  - Aprofundar modelagem de serviços e acoplamento.
  - Entender o custo de fronteiras ruins.
- [ ] **Leitura da semana**
  - BM — cap. 2, metade 1 (~12–15 págs).
  - MP — cap. 2, introdução à decomposição (~8–10 págs).
- [ ] **Prática aplicada**
  - Escolher um candidato real à extração: notificações.
  - Criar contrato interno e dependências explícitas para esse módulo.
- [ ] **Exercício estilo PR**
  - PR 019: proposta de extração do módulo de notificações + contrato interno + trade-offs.
- [ ] **Perguntas de entrevista**
  - Como você evita criar 'distributed monolith'?
  - Qual critério vale mais: organograma, banco, ou domínio?

### Semana 20 — Building Microservices capítulo 2 (parte 2)

- [ ] **Objetivos**
  - Fechar fundamentos de modelagem de microservices.
  - Relacionar fronteira de serviço com autonomia de times.
- [ ] **Leitura da semana**
  - BM — cap. 2, metade 2 (~12–15 págs).
  - MP — cap. 2, leitura complementar leve (~8–10 págs).
- [ ] **Prática aplicada**
  - Criar métricas de acoplamento entre módulos (chamadas, imports, dependências de banco).
  - Refatorar um ponto de acoplamento alto encontrado.
- [ ] **Exercício estilo PR**
  - PR 020: redução mensurável de acoplamento + relatório antes/depois.
- [ ] **Perguntas de entrevista**
  - Como time topology influencia desenho de serviços?
  - O que acontece quando um serviço precisa mudar a cada deploy de outro?

### Semana 21 — Splitting the Monolith

- [ ] **Objetivos**
  - Estudar estratégias incrementais de extração.
  - Planejar a primeira separação com baixo risco.
- [ ] **Leitura da semana**
  - BM — cap. 3, metade 1 (~12–15 págs).
  - MP — revisão cap. 1–2; sem leitura pesada extra.
- [ ] **Prática aplicada**
  - Extrair o módulo de notificações para uma aplicação Spring Boot separada, ainda simples.
  - Manter comunicação inicialmente por REST assíncrono simulado ou fila local.
- [ ] **Exercício estilo PR**
  - PR 021: primeiro serviço extraído (`notification-service`) + documentação do corte arquitetural.
- [ ] **Perguntas de entrevista**
  - Strangler fig: como você aplicaria aqui?
  - Que tipo de módulo você extrairia primeiro e por quê?

### Semana 22 — Replicação (DDIA capítulo 5, parte 1)

- [ ] **Objetivos**
  - Entender líder-seguidor e lag de replicação.
  - Separar leitura e escrita conceitualmente.
- [ ] **Leitura da semana**
  - DDIA — cap. 5, blocos 'Leaders and Followers' e 'Problems with Replication Lag' (~15–20 págs).
  - Sem capítulo novo de outro livro.
- [ ] **Prática aplicada**
  - Simular read replica conceitualmente no projeto: endpoint de leitura separado e documentação dos riscos.
  - Criar testes que demonstrem 'read your own writes' como requisito.
- [ ] **Exercício estilo PR**
  - PR 022: proposta de read/write split + documento dos riscos de lag e mitigação.
- [ ] **Perguntas de entrevista**
  - O que é replication lag e como isso afeta UX?
  - Quando usar leitura eventual é aceitável?

### Semana 23 — Replicação (DDIA capítulo 5, parte 2)

- [ ] **Objetivos**
  - Aprofundar multi-leader e leaderless replication.
  - Entender conflitos e por que consenso é caro.
- [ ] **Leitura da semana**
  - DDIA — cap. 5, blocos 'Multi-leader replication', 'Leaderless replication' e resumo (~15–20 págs).
  - FOSA — revisão curta das características arquiteturais.
- [ ] **Prática aplicada**
  - Modelar um cenário onde comentários podem ser enviados com consistência eventual.
  - Descrever políticas de resolução de conflito em linguagem de negócio.
- [ ] **Exercício estilo PR**
  - PR 023: design doc de replicação para comentários/feed + cenários de conflito.
- [ ] **Perguntas de entrevista**
  - Multi-leader é uma boa ideia? Quando sim e quando não?
  - Quorum resolve tudo?

### Semana 24 — Partitioning (DDIA capítulo 6, parte 1)

- [ ] **Objetivos**
  - Entender particionamento por range, hash e hot spots.
  - Ligar partição com distribuição de carga.
- [ ] **Leitura da semana**
  - DDIA — cap. 6, blocos 'Partitioning of key-value data' e 'Partitioning and secondary indexes' (~15–20 págs).
  - MP — reler seção de scale cube citada no cap. 1.
- [ ] **Prática aplicada**
  - Criar strategy note para particionar catálogo ou comentários por `videoId`/`userId`.
  - Modelar risco de hot key em vídeos virais.
- [ ] **Exercício estilo PR**
  - PR 024: documento de particionamento + proposta de chave e plano anti-hotspot.
- [ ] **Perguntas de entrevista**
  - Como você escolheria a shard key de comentários?
  - Por que particionar por range pode concentrar escrita?

### Semana 25 — Partitioning (DDIA capítulo 6, parte 2)

- [ ] **Objetivos**
  - Fechar rebalancing, request routing e implicações operacionais.
  - Entender que distribuição de dados afeta toda a stack.
- [ ] **Leitura da semana**
  - DDIA — cap. 6, blocos 'Rebalancing partitions', 'Request routing', 'Parallel query execution' (~12–18 págs).
  - Sem leitura nova adicional.
- [ ] **Prática aplicada**
  - Criar pequeno router lógico para decidir qual partição seria consultada em uma simulação.
  - Escrever ADR 003 sobre estratégia de particionamento futura.
- [ ] **Exercício estilo PR**
  - PR 025: ADR 003 + roteamento lógico de partição + cenários de rebalancing.
- [ ] **Perguntas de entrevista**
  - O que é rebalancing e por que ele é perigoso em produção?
  - Como request routing muda quando o dado está particionado?

### Semana 26 — Consolidação do 2º trimestre

- [ ] **Objetivos**
  - Revisar modularidade, decomposição, replicação e particionamento.
  - Fechar a versão `v0.2` com monólito modular + primeiro microserviço.
- [ ] **Leitura da semana**
  - Revisão dirigida dos caps. BM 1–3, DDIA 5–6 e FOSA 6–8; sem leitura nova.
  - Releitura dos ADRs 001–003.
- [ ] **Prática aplicada**
  - Reorganizar o repositório para suportar múltiplas apps Spring com padrão consistente.
  - Apresentar arquitetura atual em 1 diagrama C4 nível 1 e 2.
- [ ] **Exercício estilo PR**
  - PR 026: reestruturação do repo multiapp + diagramas C4 + revisão técnica do trimestre.
- [ ] **Perguntas de entrevista**
  - Qual foi a principal mudança arquitetural do trimestre?
  - O que ainda impediria você de ir para microservices em larga escala?

## Q3 — APIs, gateway, BFF, cache e comunicação


### Semana 27 — Communication styles (BM capítulo 4, parte 1)

- [ ] **Objetivos**
  - Entender estilos de comunicação entre serviços.
  - Comparar síncrono, assíncrono, request/response e eventos.
- [ ] **Leitura da semana**
  - BM — cap. 4, metade 1 (~12–15 págs).
  - MP — cap. 3, introdução à comunicação entre serviços (~8–10 págs).
- [ ] **Prática aplicada**
  - Documentar cada integração existente no projeto com tipo de acoplamento e falha provável.
  - Implementar cliente interno com timeout configurado.
- [ ] **Exercício estilo PR**
  - PR 027: mapa de integrações + timeout/client config + matriz de acoplamento.
- [ ] **Perguntas de entrevista**
  - Quando um serviço deve chamar outro de forma síncrona?
  - Qual o custo arquitetural de cadeias longas de chamadas?

### Semana 28 — REST bem desenhado em Spring

- [ ] **Objetivos**
  - Melhorar maturidade de APIs REST além do básico CRUD.
  - Aprender paginação, filtros, idempotência e versionamento pragmáticos.
- [ ] **Leitura da semana**
  - BM — cap. 4, metade 2 (~12–15 págs).
  - DDIA — revisão cap. 4, trecho de REST e RPC.
- [ ] **Prática aplicada**
  - Refatorar endpoints de catálogo para filtros, paginação e contratos de erro consistentes.
  - Adicionar idempotency key em uma operação sensível.
- [ ] **Exercício estilo PR**
  - PR 028: refatoração REST + contrato de erro padrão + idempotency key em operação crítica.
- [ ] **Perguntas de entrevista**
  - O que faz uma API REST ser estável para clientes?
  - Onde idempotência realmente importa?

### Semana 29 — HTTP clients, retries e timeouts

- [ ] **Objetivos**
  - Evitar chamadas ingênuas entre serviços.
  - Tornar explícita a política de timeout e retry.
- [ ] **Leitura da semana**
  - Release It! — Parte I / caps. 1–2, leitura leve introdutória (~10–15 págs totais).
  - BM — revisão curta de comunicação.
- [ ] **Prática aplicada**
  - Trocar `RestTemplate` legado por `WebClient` ou `Feign` com timeout e retry controlado.
  - Testar comportamento com serviço de notificação fora do ar.
- [ ] **Exercício estilo PR**
  - PR 029: client resiliente + testes de falha + documento de política de timeout.
- [ ] **Perguntas de entrevista**
  - Por que retry cego pode piorar um incidente?
  - Como você escolhe timeout entre serviços?

### Semana 30 — gRPC, RPC e contratos fortemente tipados

- [ ] **Objetivos**
  - Comparar REST, gRPC e RPC de forma prática.
  - Entender onde gRPC cabe bem em ecossistemas internos.
- [ ] **Leitura da semana**
  - DDIA — revisão do trecho 'Data flow through services: REST and RPC'.
  - Leitura leve sobre gRPC e Protobuf (~10–15 págs/notas).
- [ ] **Prática aplicada**
  - Criar POC pequena de integração gRPC entre `catalog-service` e `analytics-service` simulados.
  - Comparar payload, ergonomia e esforço de contrato com REST.
- [ ] **Exercício estilo PR**
  - PR 030: POC gRPC + tabela comparativa REST vs gRPC no contexto do projeto.
- [ ] **Perguntas de entrevista**
  - Quando gRPC é melhor do que REST?
  - Quais os downsides de adotar gRPC cedo demais?

### Semana 31 — Proxies reversos e load balancers

- [ ] **Objetivos**
  - Entender balanceamento de tráfego, sticky sessions e terminação TLS.
  - Ligar Nginx/Ingress com comportamento real da aplicação.
- [ ] **Leitura da semana**
  - SRE — cap. 19, leitura seletiva leve sobre frontend load balancing (~10–12 págs equivalentes).
  - Anotações próprias sobre reverse proxy e LB.
- [ ] **Prática aplicada**
  - Subir Nginx como reverse proxy para duas instâncias da API.
  - Medir distribuição de tráfego e discutir sessão vs stateless.
- [ ] **Exercício estilo PR**
  - PR 031: Nginx como reverse proxy + 2 réplicas da API + relatório de balanceamento.
- [ ] **Perguntas de entrevista**
  - Round robin, least connections e sticky session: quando usar?
  - Por que sessões em memória complicam escalabilidade horizontal?

### Semana 32 — API Gateway

- [ ] **Objetivos**
  - Centralizar cross-cutting concerns sem engordar demais o gateway.
  - Definir políticas de autenticação, rate limit e roteamento.
- [ ] **Leitura da semana**
  - Microservices Patterns — cap. 8, início sobre API patterns (~10–15 págs).
  - FOSA — revisão de characteristics ligadas a security e scalability.
- [ ] **Prática aplicada**
  - Criar `gateway-service` com Spring Cloud Gateway.
  - Mover autenticação simples, roteamento e um rate limit básico para o gateway.
- [ ] **Exercício estilo PR**
  - PR 032: API Gateway inicial + rate limiting + roteamento + justificativa do que NÃO vai para o gateway.
- [ ] **Perguntas de entrevista**
  - O que pertence ao API Gateway e o que não pertence?
  - BFF substitui gateway?

### Semana 33 — Backend for Frontend (BFF)

- [ ] **Objetivos**
  - Adaptar APIs por canal sem poluir serviços de domínio.
  - Aprender a reduzir chatty APIs.
- [ ] **Leitura da semana**
  - Microservices Patterns — cap. 8, continuação sobre external API patterns (~10–15 págs).
  - Leitura leve sobre BFF em arquiteturas com múltiplos clientes.
- [ ] **Prática aplicada**
  - Criar BFF web com endpoint agregado para página inicial do StreamForge.
  - Comparar número de chamadas antes/depois do BFF.
- [ ] **Exercício estilo PR**
  - PR 033: `bff-web` com endpoint agregado + cálculo de redução de roundtrips.
- [ ] **Perguntas de entrevista**
  - Quando BFF é uma boa ideia?
  - Qual o risco de criar um BFF virando novo monólito?

### Semana 34 — Estratégias de cache I

- [ ] **Objetivos**
  - Aprender cache-aside, write-through, write-behind e local cache.
  - Evitar uso ingênuo de cache como band-aid.
- [ ] **Leitura da semana**
  - DDIA — revisão do cap. 1 e 3 em trechos que tocam cache e leitura.
  - Release It! — leitura leve de padrões de estabilidade ligados a dogpile/cache (~8–12 págs).
- [ ] **Prática aplicada**
  - Adicionar cache-aside no catálogo de vídeos populares com Redis.
  - Definir TTL e política de invalidação por publicação/edição de vídeo.
- [ ] **Exercício estilo PR**
  - PR 034: cache de catálogo + estratégia de invalidação + testes de stale data aceitável.
- [ ] **Perguntas de entrevista**
  - Qual a diferença entre aliviar banco e garantir consistência?
  - Por que cache invalidation é difícil?

### Semana 35 — Estratégias de cache II

- [ ] **Objetivos**
  - Aprofundar cache distribuído e stampede prevention.
  - Entender quando não cachear.
- [ ] **Leitura da semana**
  - Release It! — seção de dogpile/stability patterns, leitura leve (~10–12 págs).
  - Anotações sobre Redis, hot keys e cache warming.
- [ ] **Prática aplicada**
  - Implementar proteção simples contra cache stampede.
  - Medir hit ratio e latência de leitura do catálogo.
- [ ] **Exercício estilo PR**
  - PR 035: prevenção de stampede + métricas de cache hit/miss + dashboard simples.
- [ ] **Perguntas de entrevista**
  - O que é cache stampede?
  - Quando cache piora seu sistema?

### Semana 36 — Cache e consistência

- [ ] **Objetivos**
  - Relacionar cache com replicação, invalidação e UX.
  - Modelar janelas de inconsistência aceitáveis por contexto.
- [ ] **Leitura da semana**
  - DDIA — revisão dos capítulos 5 e 6 com olhar de consistência de leitura.
  - Sem leitura nova pesada.
- [ ] **Prática aplicada**
  - Definir regras diferentes: feed e recomendações podem ser eventuais; billing não.
  - Escrever contrato de freshness por endpoint.
- [ ] **Exercício estilo PR**
  - PR 036: matriz 'endpoint x requisito de freshness' + ajustes de cache conforme criticidade.
- [ ] **Perguntas de entrevista**
  - Como explicar eventual consistency para produto/negócio?
  - Quais fluxos do seu sistema exigem consistência forte?

### Semana 37 — Comunicação entre serviços com foco em falhas

- [ ] **Objetivos**
  - Entender acoplamento temporal e semântico.
  - Preparar o sistema para falhas parciais.
- [ ] **Leitura da semana**
  - MP — cap. 3, continuidade (~12–15 págs).
  - Release It! — revisão das noções de falha parcial.
- [ ] **Prática aplicada**
  - Criar testes de contrato consumidor-fornecedor entre gateway/BFF e serviços.
  - Simular indisponibilidade parcial e fallback controlado.
- [ ] **Exercício estilo PR**
  - PR 037: consumer-driven contracts iniciais + fallback simples e observável.
- [ ] **Perguntas de entrevista**
  - O que é acoplamento temporal?
  - Por que contratos são importantes em microservices?

### Semana 38 — Mensageria assíncrona I

- [ ] **Objetivos**
  - Introduzir filas/eventos como ferramenta de desacoplamento.
  - Diferenciar comando, evento e integração assíncrona.
- [ ] **Leitura da semana**
  - DDIA — cap. 11, blocos 'Messaging systems' e 'Partitioned logs' (parte 1, ~15–20 págs).
  - BM — cap. 5, início sobre implementação de comunicação (~8–10 págs).
- [ ] **Prática aplicada**
  - Subir RabbitMQ ou Kafka localmente.
  - Publicar evento `VideoPublished` e consumi-lo no serviço de notificações.
- [ ] **Exercício estilo PR**
  - PR 038: barramento assíncrono inicial + publicação/consumo de evento + testes básicos.
- [ ] **Perguntas de entrevista**
  - Fila e stream são a mesma coisa?
  - Quando você prefere evento a chamada síncrona?

### Semana 39 — Consolidação do 3º trimestre

- [ ] **Objetivos**
  - Revisar API design, gateway, BFF, cache e mensageria.
  - Fechar a versão `v0.3` da plataforma de integração.
- [ ] **Leitura da semana**
  - Revisão dos caps. BM 4, MP 3, DDIA 11 (parte lida) e anotações de cache.
  - Sem leitura nova obrigatória.
- [ ] **Prática aplicada**
  - Documentar a topologia atual: gateway → BFF → serviços → fila → banco/cache.
  - Executar demo end-to-end de publicação de vídeo com notificação.
- [ ] **Exercício estilo PR**
  - PR 039: demo integrada do trimestre + diagrama atualizado + revisão de acoplamentos.
- [ ] **Perguntas de entrevista**
  - Que trade-offs você introduziu ao adicionar gateway, cache e fila?
  - Como você explicaria a evolução arquitetural do projeto até aqui?

## Q4 — Assíncrono, concorrência, performance e scale cube


### Semana 40 — Mensageria assíncrona II: semântica de entrega

- [ ] **Objetivos**
  - Entender at-least-once, duplicidade e ordenação.
  - Evitar promessas irreais como 'exactly once' sem contexto.
- [ ] **Leitura da semana**
  - DDIA — cap. 11, continuidade sobre streams e sincronização de sistemas (~12–18 págs).
  - Leitura complementar leve sobre semântica de entrega.
- [ ] **Prática aplicada**
  - Tornar consumidor de notificações idempotente.
  - Criar tabela/outbox simples para publicação segura.
- [ ] **Exercício estilo PR**
  - PR 040: idempotência de consumidor + POC de transactional outbox.
- [ ] **Perguntas de entrevista**
  - O que significa 'at-least-once' na prática?
  - Como você lidaria com mensagens duplicadas?

### Semana 41 — Eventos, comandos e contratos de integração

- [ ] **Objetivos**
  - Modelar melhor fronteiras assíncronas.
  - Evitar eventos anêmicos ou contratos mal versionados.
- [ ] **Leitura da semana**
  - BM — cap. 5, parte 2 (~12–15 págs).
  - DDIA — revisão do cap. 4 sobre evolução de contratos.
- [ ] **Prática aplicada**
  - Separar claramente comando interno de evento de integração.
  - Versionar o evento `SubscriptionActivated`.
- [ ] **Exercício estilo PR**
  - PR 041: revisão de contratos assíncronos + versionamento + documentação de esquema.
- [ ] **Perguntas de entrevista**
  - Evento de domínio e evento de integração são iguais?
  - Como evitar que um evento vaze detalhes internos do serviço?

### Semana 42 — Stream processing (DDIA capítulo 11, parte 2)

- [ ] **Objetivos**
  - Entender processamento contínuo de eventos e materialização.
  - Explorar usos reais para analytics e feed.
- [ ] **Leitura da semana**
  - DDIA — cap. 11, blocos 'Change data capture', 'Event sourcing', 'Processing Streams' (parte 1, ~15–20 págs).
  - Sem leitura pesada extra.
- [ ] **Prática aplicada**
  - Criar pipeline simples que atualiza contador de views por vídeo a partir de eventos.
  - Gerar read model para ranking diário.
- [ ] **Exercício estilo PR**
  - PR 042: pipeline de eventos para ranking diário + documentação da atualização eventual.
- [ ] **Perguntas de entrevista**
  - Quando stream processing vale o custo?
  - Qual diferença entre CDC e consumo de eventos de domínio?

### Semana 43 — Keeping systems in sync

- [ ] **Objetivos**
  - Aprender a manter múltiplos modelos de leitura em sincronia eventual.
  - Lidar com reprocessamento e replay.
- [ ] **Leitura da semana**
  - DDIA — cap. 11, parte final (~12–18 págs).
  - MP — revisão do material de queries em microservices.
- [ ] **Prática aplicada**
  - Permitir rebuild do ranking a partir de replay de eventos ou carga batch controlada.
  - Criar comando administrativo de reprocessamento.
- [ ] **Exercício estilo PR**
  - PR 043: mecanismo de rebuild de read model + documentação de replay e riscos.
- [ ] **Perguntas de entrevista**
  - Como você reconstruiria um read model corrompido?
  - Replay de eventos é sempre barato?

### Semana 44 — Concorrência e paralelismo em Java I

- [ ] **Objetivos**
  - Reforçar fundamentos necessários para throughput e segurança.
  - Relacionar concorrência local com concorrência distribuída.
- [ ] **Leitura da semana**
  - Leitura leve de notas sobre `CompletableFuture`, pools, locks e filas em Java (~12–18 págs).
  - Release It! — trecho sobre blocked threads, leitura complementar curta.
- [ ] **Prática aplicada**
  - Refatorar processamento assíncrono local usando executors apropriados.
  - Medir fila, threads e saturação sob carga simples.
- [ ] **Exercício estilo PR**
  - PR 044: uso consciente de executors + métricas de pool + relatório de saturação.
- [ ] **Perguntas de entrevista**
  - Concorrência e paralelismo: diferença prática.
  - Por que pool errado derruba throughput?

### Semana 45 — Concorrência e paralelismo em Java II

- [ ] **Objetivos**
  - Entender backpressure, filas internas e bounded resources.
  - Preparar o projeto para capacidade previsível.
- [ ] **Leitura da semana**
  - Release It! — continuidade sobre blocked threads/unbounded result sets (~10–12 págs).
  - Notas próprias de backpressure e filas limitadas.
- [ ] **Prática aplicada**
  - Aplicar limites em pools, paginação e tamanhos de payload.
  - Impedir operação administrativa que retornava resultado gigantesco.
- [ ] **Exercício estilo PR**
  - PR 045: limites de recurso + paginação defensiva + testes com payload grande.
- [ ] **Perguntas de entrevista**
  - O que é backpressure?
  - Por que operações não limitadas viram problema em produção?

### Semana 46 — Workflow e introdução a sagas

- [ ] **Objetivos**
  - Entender processos de negócio distribuídos.
  - Comparar orquestração, coreografia e transação distribuída.
- [ ] **Leitura da semana**
  - BM — cap. 6, metade 1 (~12–15 págs).
  - MP — cap. 4, introdução a sagas (~8–10 págs).
- [ ] **Prática aplicada**
  - Modelar fluxo de assinatura: cobrança → ativação → notificação.
  - Listar passos compensáveis e não compensáveis.
- [ ] **Exercício estilo PR**
  - PR 046: diagrama de saga da assinatura + definição dos comandos/eventos envolvidos.
- [ ] **Perguntas de entrevista**
  - O que é uma saga?
  - Por que 2PC raramente é a melhor resposta em microservices?

### Semana 47 — Performance e capacidade I

- [ ] **Objetivos**
  - Criar modelo mental de throughput, latência e utilização.
  - Aprender a estimar antes de escalar 'no chute'.
- [ ] **Leitura da semana**
  - SRE — cap. 3: Embracing Risk (leitura seletiva, ~10–12 págs).
  - Notas sobre Little's Law, filas e saturação (~8–10 págs).
- [ ] **Prática aplicada**
  - Calcular capacidade inicial para 100, 1000 e 10k usuários concorrentes.
  - Criar planilha/markdown de capacity assumptions.
- [ ] **Exercício estilo PR**
  - PR 047: capacity assumptions v1 + metas de resposta + riscos conhecidos.
- [ ] **Perguntas de entrevista**
  - Como você estima capacidade sem ter produção ainda?
  - Qual métrica você acompanha primeiro: CPU, latência ou fila?

### Semana 48 — Performance e capacidade II

- [ ] **Objetivos**
  - Lig ar medições com hipóteses de gargalo.
  - Treinar raciocínio de benchmark minimamente sério.
- [ ] **Leitura da semana**
  - DDIA — revisão do cap. 1 sobre carga/performance.
  - SRE — cap. 4: Service Level Objectives (início, ~10–12 págs).
- [ ] **Prática aplicada**
  - Definir SLI/objetivo simples para listagem de catálogo e checkout de assinatura.
  - Rodar benchmark repetível e comparar com a meta.
- [ ] **Exercício estilo PR**
  - PR 048: SLI/SLO iniciais + benchmark repetível + gap analysis.
- [ ] **Perguntas de entrevista**
  - O que é SLI, SLO e error budget?
  - Por que 99,99% nem sempre é a meta certa?

### Semana 49 — Scale Cube

- [ ] **Objetivos**
  - Aplicar scale cube (X/Y/Z) ao projeto.
  - Comparar replicação, decomposição funcional e particionamento.
- [ ] **Leitura da semana**
  - MP — cap. 1, seção sobre Scale Cube; revisão dirigida (~8–10 págs).
  - Leitura complementar leve de exemplos de X, Y e Z-axis.
- [ ] **Prática aplicada**
  - Mapear como o StreamForge escalaria em X, Y e Z.
  - Escolher uma evolução plausível para os próximos seis meses do sistema.
- [ ] **Exercício estilo PR**
  - PR 049: documento `scale-cube-streamforge.md` com proposta faseada.
- [ ] **Perguntas de entrevista**
  - Explique o scale cube usando seu projeto.
  - Qual eixo você atacaria primeiro e por quê?

### Semana 50 — Testes de carga e estresse I

- [ ] **Objetivos**
  - Introduzir disciplina de load, stress e soak tests.
  - Evitar confundir benchmark local com capacidade real.
- [ ] **Leitura da semana**
  - SRE — cap. 17: Testing for Reliability (leitura seletiva, ~10–12 págs).
  - Notas sobre k6/JMeter/Gatling (~8–10 págs).
- [ ] **Prática aplicada**
  - Criar testes k6 para catálogo, login e assinatura.
  - Medir comportamento com 1, 10 e 50 VUs.
- [ ] **Exercício estilo PR**
  - PR 050: suíte inicial de carga com k6 + relatório de gargalos primários.
- [ ] **Perguntas de entrevista**
  - Qual a diferença entre load, stress e soak tests?
  - O que você observa além de RPS?

### Semana 51 — Testes de carga e estresse II

- [ ] **Objetivos**
  - Relacionar falha observada com decisão arquitetural.
  - Treinar postura de engenharia: medir, corrigir, medir de novo.
- [ ] **Leitura da semana**
  - Release It! — leitura leve de antipadrões ligados a capacidade.
  - Sem outro capítulo novo pesado.
- [ ] **Prática aplicada**
  - Aplicar duas melhorias concretas (índice, cache, pool, paginação, batch).
  - Comparar antes/depois usando a mesma suíte k6.
- [ ] **Exercício estilo PR**
  - PR 051: otimizações guiadas por carga + comparativo antes/depois com gráficos simples.
- [ ] **Perguntas de entrevista**
  - Como você escolhe a próxima otimização?
  - Por que throughput sem estabilidade não basta?

### Semana 52 — Consolidação do 4º trimestre

- [ ] **Objetivos**
  - Fechar o ano 1 com uma arquitetura funcional e mensurável.
  - Preparar a transição para padrões avançados de dados e resiliência.
- [ ] **Leitura da semana**
  - Revisão do ano 1: DDIA 1–6, 11; FOSA 1–8; BM 1–6; MP 1–4 parcial.
  - Sem capítulo novo obrigatório.
- [ ] **Prática aplicada**
  - Publicar release `v1.0-year1` com documentação, diagramas, métricas e backlog do ano 2.
  - Gravar demo técnica de 15 minutos.
- [ ] **Exercício estilo PR**
  - PR 052: release do ano 1 + documentação consolidada + roadmap do ano 2.
- [ ] **Perguntas de entrevista**
  - Que maturidade você ganhou no ano 1?
  - Qual foi o maior trade-off entre simplicidade e escalabilidade?

## Q5 — Particionamento, CQRS, event sourcing e sagas


### Semana 53 — Replicação revisitada com foco em leitura massiva

- [ ] **Objetivos**
  - Usar a base do ano 1 para redesenhar leitura em escala.
  - Treinar raciocínio de feed/read-heavy workloads.
- [ ] **Leitura da semana**
  - DDIA — releitura seletiva do cap. 5 (~12–15 págs).
  - SRE — revisão curta de risco e SLOs.
- [ ] **Prática aplicada**
  - Redesenhar feed e listagens populares considerando réplicas/caches/read models.
  - Documentar o que continua no writer primário.
- [ ] **Exercício estilo PR**
  - PR 053: redesign de leitura em escala + ADR 004 para read path.
- [ ] **Perguntas de entrevista**
  - Se seu feed fica 100x mais popular, o que muda primeiro?
  - Quando read replicas bastam e quando não bastam?

### Semana 54 — Sharding e particionamento prático I

- [ ] **Objetivos**
  - Sair do conceitual e aplicar sharding a um caso real do projeto.
  - Discutir chaves, hotspots e expansão futura.
- [ ] **Leitura da semana**
  - DDIA — releitura seletiva do cap. 6, foco em shard key (~12–15 págs).
  - MP — revisão do scale cube.
- [ ] **Prática aplicada**
  - Escolher `videoId` ou `userId` como base de shard para comentários e eventos de view.
  - Simular distribuição de carga com dados falsos.
- [ ] **Exercício estilo PR**
  - PR 054: estudo comparativo de shard key + resultados da simulação.
- [ ] **Perguntas de entrevista**
  - Como você escolhe shard key para comentários?
  - O que é hotspot e como mitigar?

### Semana 55 — Sharding e particionamento prático II

- [ ] **Objetivos**
  - Entender rebalancing e evolução de estratégia sem downtime grande.
  - Pensar em growth path e não só no estado atual.
- [ ] **Leitura da semana**
  - DDIA — releitura seletiva de rebalancing e request routing (~10–12 págs).
  - Leitura leve sobre consistent hashing.
- [ ] **Prática aplicada**
  - Criar diagrama de expansão de 4 para 16 partições.
  - Escrever runbook de rebalancing conceitual.
- [ ] **Exercício estilo PR**
  - PR 055: runbook de rebalancing + diagrama de expansão + riscos operacionais.
- [ ] **Perguntas de entrevista**
  - Por que migrar shard key é tão caro?
  - Como você reduz risco em rebalancing?

### Semana 56 — Replicação de dados e read/write split

- [ ] **Objetivos**
  - Tornar explícita a topologia de dados do sistema.
  - Separar responsabilidade do caminho de escrita e do caminho de leitura.
- [ ] **Leitura da semana**
  - DDIA — revisão dos caps. 5–6 combinados (~10–15 págs).
  - BM — revisão curta de comunicação e workflow.
- [ ] **Prática aplicada**
  - Implementar camada de leitura separada para analytics e catálogo popular.
  - Documentar quais endpoints toleram atraso de segundos/minutos.
- [ ] **Exercício estilo PR**
  - PR 056: read path separado + policy document de freshness e consistency.
- [ ] **Perguntas de entrevista**
  - Quais endpoints aceitam consistência eventual?
  - Como você explicaria read/write split para o time de produto?

### Semana 57 — CQRS I: por que separar leitura e escrita

- [ ] **Objetivos**
  - Entender o problema que CQRS resolve e o que ele complica.
  - Evitar usar CQRS como moda.
- [ ] **Leitura da semana**
  - Microservices Patterns — cap. 7, início sobre queries em microservices (~10–15 págs).
  - Leitura complementar breve de CQRS.
- [ ] **Prática aplicada**
  - Escolher o caso de uso 'dashboard do criador' para receber CQRS.
  - Definir write model, read model e fluxo de atualização.
- [ ] **Exercício estilo PR**
  - PR 057: design de CQRS para dashboard do criador + trade-offs explícitos.
- [ ] **Perguntas de entrevista**
  - Quando CQRS vale a pena?
  - Por que CQRS aumenta complexidade operacional?

### Semana 58 — CQRS II: implementação em Spring

- [ ] **Objetivos**
  - Aplicar CQRS sem overengineering.
  - Usar eventos para manter read models em sincronia.
- [ ] **Leitura da semana**
  - MP — cap. 7, continuação (~10–15 págs).
  - DDIA — revisão do cap. 11 em trechos úteis.
- [ ] **Prática aplicada**
  - Implementar write API e read API separadas para dashboard/estatísticas.
  - Persistir read model desnormalizado.
- [ ] **Exercício estilo PR**
  - PR 058: CQRS funcional para dashboard + sync assíncrona do read model.
- [ ] **Perguntas de entrevista**
  - Como você lida com atraso entre write e read model?
  - Como testaria CQRS sem virar caos?

### Semana 59 — Event Sourcing I

- [ ] **Objetivos**
  - Entender o padrão e quando ele é exagero.
  - Relacionar event sourcing com audit trail e rebuild.
- [ ] **Leitura da semana**
  - MP — cap. 6, metade 1 (~10–15 págs).
  - DDIA — cap. 11, trecho 'Event sourcing' (releitura curta).
- [ ] **Prática aplicada**
  - Escolher um domínio pequeno e auditável: billing/subscription state.
  - Modelar eventos principais do ciclo de assinatura.
- [ ] **Exercício estilo PR**
  - PR 059: proposta de event sourcing limitada para assinatura + catálogo de eventos.
- [ ] **Perguntas de entrevista**
  - Event sourcing é para tudo?
  - Qual a diferença entre log de auditoria e event store?

### Semana 60 — Event Sourcing II

- [ ] **Objetivos**
  - Implementar a versão mínima e aprender seus custos.
  - Praticar replay e projeção.
- [ ] **Leitura da semana**
  - MP — cap. 6, metade 2 (~10–15 págs).
  - Sem leitura nova extra.
- [ ] **Prática aplicada**
  - Criar aggregate simples de assinatura a partir de eventos.
  - Gerar projeção para status atual do plano do usuário.
- [ ] **Exercício estilo PR**
  - PR 060: aggregate event-sourced + projeção atual + testes de replay.
- [ ] **Perguntas de entrevista**
  - Como lidar com schema evolution em event sourcing?
  - Quais dores operacionais esse padrão traz?

### Semana 61 — Saga I: orquestração

- [ ] **Objetivos**
  - Aplicar saga em fluxo financeiro com passos claros.
  - Comparar coordenador central vs colaboração por eventos.
- [ ] **Leitura da semana**
  - MP — cap. 4, metade 1 (~10–15 págs).
  - BM — revisão do cap. 6.
- [ ] **Prática aplicada**
  - Implementar orquestrador simples para assinatura: cobrança → ativação → e-mail.
  - Adicionar compensação para falha de ativação.
- [ ] **Exercício estilo PR**
  - PR 061: saga orquestrada funcional + compensação explícita + testes de falha.
- [ ] **Perguntas de entrevista**
  - Orquestração ou coreografia: o que você escolheria aqui?
  - O que deve ser compensado e o que deve falhar rápido?

### Semana 62 — Saga II: coreografia

- [ ] **Objetivos**
  - Experimentar abordagem alternativa.
  - Entender o custo de observabilidade e debugging.
- [ ] **Leitura da semana**
  - MP — cap. 4, metade 2 (~10–15 págs).
  - Sem leitura nova adicional.
- [ ] **Prática aplicada**
  - Reimplementar o fluxo de assinatura por eventos coreografados em branch/lab separado.
  - Comparar complexidade e visibilidade com a versão orquestrada.
- [ ] **Exercício estilo PR**
  - PR 062: POC comparativa orquestração vs coreografia + recomendação final.
- [ ] **Perguntas de entrevista**
  - Quando coreografia fica caótica?
  - Como você rastreia uma saga distribuída?

### Semana 63 — Idempotência, deduplicação e falhas parciais

- [ ] **Objetivos**
  - Tornar fluxos distribuídos repetíveis e seguros.
  - Aceitar que duplicidade faz parte do jogo.
- [ ] **Leitura da semana**
  - Release It! — revisão de padrões de estabilidade ligados a integração.
  - DDIA — revisão curta de semântica de mensagens e concorrência.
- [ ] **Prática aplicada**
  - Adicionar idempotency table para eventos/commands críticos.
  - Criar testes com reentrega duplicada e timeout.
- [ ] **Exercício estilo PR**
  - PR 063: camada de idempotência distribuída + testes de duplicidade e reprocessamento.
- [ ] **Perguntas de entrevista**
  - Como implementar idempotência de verdade?
  - Por que 'exactly once' raramente é simples?

### Semana 64 — Consistência eventual e UX

- [ ] **Objetivos**
  - Traduzir decisão distribuída em experiência do usuário.
  - Evitar promessas erradas para produto.
- [ ] **Leitura da semana**
  - SRE — cap. 4, revisão de objetivos de serviço.
  - Leitura leve sobre UX em sistemas eventuais.
- [ ] **Prática aplicada**
  - Criar estados intermediários claros no frontend/API: 'processando', 'pendente', 'confirmado'.
  - Documentar SLA/SLO por fluxo de negócio.
- [ ] **Exercício estilo PR**
  - PR 064: estados transitórios explícitos + documentação de UX para consistência eventual.
- [ ] **Perguntas de entrevista**
  - Como consistência eventual afeta UX e suporte?
  - Quais fluxos não podem expor estado pendente?

### Semana 65 — Consolidação do 5º trimestre

- [ ] **Objetivos**
  - Revisar CQRS, event sourcing, saga, idempotência e particionamento.
  - Fechar a versão `v1.1` com padrões avançados aplicados de forma seletiva.
- [ ] **Leitura da semana**
  - Revisão dos caps. MP 4, 6, 7; DDIA 5, 6, 11; sem leitura nova.
  - Releitura das ADRs 004 em diante.
- [ ] **Prática aplicada**
  - Decidir oficialmente quais padrões permanecem no projeto e quais ficam apenas como laboratório.
  - Atualizar diagrama de fluxos distribuídos.
- [ ] **Exercício estilo PR**
  - PR 065: consolidação dos padrões adotados + remoção de experimentos descartados + diagrama final do trimestre.
- [ ] **Perguntas de entrevista**
  - Como saber quando um padrão avançado deve ser removido?
  - Que padrão trouxe mais valor real até aqui?

## Q6 — Resiliência, deployment, capacity e hardening


### Semana 66 — Release It! mindset de produção

- [ ] **Objetivos**
  - Mudar o foco de 'funciona localmente' para 'sobrevive em produção'.
  - Criar disciplina de readiness operacional.
- [ ] **Leitura da semana**
  - Release It! — cap. 1 (~10–15 págs).
  - Release It! — cap. 2, leitura leve do estudo de caso (~8–10 págs).
- [ ] **Prática aplicada**
  - Criar checklist de readiness para cada serviço: health, config, logs, timeouts, métricas, alertas mínimos.
  - Adicionar endpoint `/readyz` distinto de `/health`.
- [ ] **Exercício estilo PR**
  - PR 066: production-readiness checklist + readiness endpoint + docs operacionais.
- [ ] **Perguntas de entrevista**
  - O que torna um serviço 'production-ready'?
  - Qual a diferença entre health e readiness?

### Semana 67 — Release It! estabilidade I

- [ ] **Objetivos**
  - Entender falha como comportamento esperado.
  - Introduzir barreiras para conter propagação.
- [ ] **Leitura da semana**
  - Release It! — cap. 3 (~12–15 págs).
  - Sem leitura nova adicional.
- [ ] **Prática aplicada**
  - Auditar todas as integrações do projeto em busca de timeouts ausentes, pools sem limite e chamadas em cascata.
  - Corrigir pelo menos dois pontos de fragilidade.
- [ ] **Exercício estilo PR**
  - PR 067: auditoria de estabilidade + correções concretas em integrações frágeis.
- [ ] **Perguntas de entrevista**
  - O que é reação em cadeia em sistemas distribuídos?
  - Por que blocked threads derrubam um serviço?

### Semana 68 — Release It! estabilidade II: antipadrões

- [ ] **Objetivos**
  - Reconhecer antipadrões recorrentes antes do incidente.
  - Treinar leitura crítica de integrações.
- [ ] **Leitura da semana**
  - Release It! — cap. 4 (~12–15 págs).
  - Revisão curta de topologia atual do projeto.
- [ ] **Prática aplicada**
  - Mapear no StreamForge: self-denial attack, dogpile, unbounded results, slow response, unbalanced capacities.
  - Criar plano de mitigação para cada um.
- [ ] **Exercício estilo PR**
  - PR 068: catálogo de antipadrões presentes/possíveis + mitigação priorizada.
- [ ] **Perguntas de entrevista**
  - Qual antipadrão costuma aparecer primeiro em APIs REST?
  - Como uma query 'inocente' vira incidente?

### Semana 69 — Release It! estabilidade III: padrões

- [ ] **Objetivos**
  - Aplicar timeouts, circuit breakers, bulkheads e fail-fast com critério.
  - Evitar resiliência cosmética.
- [ ] **Leitura da semana**
  - Release It! — cap. 5 (~12–15 págs).
  - Sem leitura nova extra.
- [ ] **Prática aplicada**
  - Adicionar Resilience4j em integrações críticas.
  - Definir thresholds iniciais simples e observáveis.
- [ ] **Exercício estilo PR**
  - PR 069: circuit breaker + timeout + retry controlado + bulkhead em integração crítica.
- [ ] **Perguntas de entrevista**
  - Quando circuit breaker ajuda?
  - Quando fallback é perigoso?

### Semana 70 — Resiliência na prática

- [ ] **Objetivos**
  - Consolidar políticas reais de retry, timeout e fallback.
  - Relacionar configuração de resiliência com SLO.
- [ ] **Leitura da semana**
  - Release It! — revisão prática cap. 5.
  - SRE — revisão curta cap. 3–4.
- [ ] **Prática aplicada**
  - Executar cenários de falha e medir impacto do breaker e retry no sistema.
  - Ajustar thresholds com base em dados, não feeling.
- [ ] **Exercício estilo PR**
  - PR 070: testes de resiliência automatizados + ajuste de thresholds baseado em resultado.
- [ ] **Perguntas de entrevista**
  - Por que retry pode amplificar sobrecarga?
  - Como escolher fallback aceitável sem esconder erro crítico?

### Semana 71 — Bulkheads, rate limiting e isolamento

- [ ] **Objetivos**
  - Conter blast radius.
  - Separar recursos por criticidade.
- [ ] **Leitura da semana**
  - Release It! — releitura seletiva dos padrões de isolamento.
  - SRE — revisão de risco e simplicidade.
- [ ] **Prática aplicada**
  - Separar pools/quotas para tráfego público e tarefas internas.
  - Aplicar rate limit por usuário/IP no gateway.
- [ ] **Exercício estilo PR**
  - PR 071: isolamento de recursos + rate limiting + teste de contenção de blast radius.
- [ ] **Perguntas de entrevista**
  - O que é bulkhead pattern?
  - Como rate limit protege tanto disponibilidade quanto custo?

### Semana 72 — Capacity planning

- [ ] **Objetivos**
  - Transformar hipóteses em plano de crescimento.
  - Ligar volume de tráfego a CPU, memória, banco e fila.
- [ ] **Leitura da semana**
  - SRE — cap. 3 e 4, revisão aplicada.
  - Notas próprias de capacity planning (~8–10 págs).
- [ ] **Prática aplicada**
  - Criar capacity plan trimestral fictício para 10x usuários.
  - Definir pontos de escala: app, cache, banco, fila, storage.
- [ ] **Exercício estilo PR**
  - PR 072: `capacity-plan-v2.md` com cenários normal/pico/campanha.
- [ ] **Perguntas de entrevista**
  - Como você apresenta capacity planning a negócio?
  - O que você escala primeiro em um sistema read-heavy?

### Semana 73 — Modelos de deployment

- [ ] **Objetivos**
  - Estudar blue/green, canary e feature flags com foco prático.
  - Preparar releases mais seguras.
- [ ] **Leitura da semana**
  - SRE — cap. 8: Release Engineering (~10–12 págs).
  - Leitura leve sobre canary/feature toggles.
- [ ] **Prática aplicada**
  - Criar estratégia de deployment canário simulada para `notification-service`.
  - Adicionar feature flag simples para novo fluxo de e-mail.
- [ ] **Exercício estilo PR**
  - PR 073: canary plan + feature flag + rollback plan documentado.
- [ ] **Perguntas de entrevista**
  - Blue/green vs canary: quando escolher cada um?
  - Feature flag pode virar dívida?

### Semana 74 — Containers, imagens e K8s básico

- [ ] **Objetivos**
  - Entender o que o container resolve e o que não resolve.
  - Preparar a arquitetura para execução mais próxima de produção.
- [ ] **Leitura da semana**
  - BM — cap. 8, metade 1 (~12–15 págs).
  - Leitura leve de Docker/Kubernetes aplicada ao projeto.
- [ ] **Prática aplicada**
  - Dockerizar todos os serviços com imagens pequenas e prontas para health/readiness.
  - Criar manifests básicos ou Compose avançado equivalente.
- [ ] **Exercício estilo PR**
  - PR 074: padronização de imagens/containerização + manifests básicos.
- [ ] **Perguntas de entrevista**
  - Containerizar é o mesmo que arquitetar bem?
  - Quais sinais indicam que Kubernetes ainda é prematuro?

### Semana 75 — Service Mesh Pattern

- [ ] **Objetivos**
  - Entender o que service mesh abstrai e seu custo operacional.
  - Evitar adicioná-lo cedo demais por hype.
- [ ] **Leitura da semana**
  - Leitura leve sobre service mesh e observabilidade de tráfego (~10–12 págs).
  - BM — cap. 10, introdução à observabilidade (início).
- [ ] **Prática aplicada**
  - Desenhar como mTLS, retries e tracing poderiam ir para mesh vs aplicação.
  - Escrever ADR 005: por que não adotar service mesh agora / ou quando adotar.
- [ ] **Exercício estilo PR**
  - PR 075: ADR 005 + matriz 'na app x no mesh'.
- [ ] **Perguntas de entrevista**
  - Quando service mesh faz sentido?
  - Quais custos cognitivos e operacionais ele traz?

### Semana 76 — Testes de carga, estresse e soak II

- [ ] **Objetivos**
  - Amadurecer suíte de testes para cenários longos e degradados.
  - Observar fila, GC, conexões e saturação.
- [ ] **Leitura da semana**
  - SRE — cap. 17, revisão aplicada.
  - Sem leitura nova adicional.
- [ ] **Prática aplicada**
  - Executar teste de 30–60 minutos com tráfego misto.
  - Registrar sinais de vazamento, fila crescente, degradação de latência e erro.
- [ ] **Exercício estilo PR**
  - PR 076: suíte de soak test + relatório de comportamento sustentado.
- [ ] **Perguntas de entrevista**
  - Por que soak test acha bugs que stress test não acha?
  - Quais sinais de degradação lenta você procuraria?

### Semana 77 — Cell-based architecture

- [ ] **Objetivos**
  - Entender segmentação sistêmica e contenção geográfica/funcional.
  - Pensar em crescimento por células.
- [ ] **Leitura da semana**
  - Leitura leve sobre cell-based architecture (~10–12 págs).
  - SRE — capítulos de simplicidade e gestão de incidentes, leitura seletiva.
- [ ] **Prática aplicada**
  - Desenhar o StreamForge em células por região ou tenant.
  - Mapear dados compartilhados, isolados e o custo de coordenação.
- [ ] **Exercício estilo PR**
  - PR 077: documento de arquitetura cell-based + avaliação de viabilidade para o projeto.
- [ ] **Perguntas de entrevista**
  - O que é cell-based architecture?
  - Quando vale isolar por célula em vez de só replicar tudo?

### Semana 78 — Consolidação do 6º trimestre

- [ ] **Objetivos**
  - Fechar a fase de hardening de produção.
  - Deixar o projeto com postura operacional muito mais madura.
- [ ] **Leitura da semana**
  - Revisão dos estudos de Release It!, SRE (caps. iniciais), BM 8 e docs de deployment.
  - Sem capítulo novo obrigatório.
- [ ] **Prática aplicada**
  - Padronizar readiness, graceful shutdown, resource limits, dashboards básicos e runbooks iniciais.
  - Publicar release `v1.2-hardening`.
- [ ] **Exercício estilo PR**
  - PR 078: hardening completo + runbooks iniciais + release `v1.2-hardening`.
- [ ] **Perguntas de entrevista**
  - Se você tivesse que colocar esse sistema em produção amanhã, o que ainda faltaria?
  - Qual a maior fragilidade operacional restante?

## Q7 — SRE, observabilidade, incidentes e DR


### Semana 79 — SRE fundamentos

- [ ] **Objetivos**
  - Internalizar a mentalidade SRE para sistemas distribuídos.
  - Separar confiabilidade de heroísmo operacional.
- [ ] **Leitura da semana**
  - SRE — cap. 1 e cap. 2 (~15–20 págs no ritmo leve).
  - Revisão das metas de serviço do projeto.
- [ ] **Prática aplicada**
  - Escrever 'princípios operacionais' do StreamForge.
  - Definir ownership por serviço, mesmo que fictício.
- [ ] **Exercício estilo PR**
  - PR 079: princípios SRE do projeto + ownership e responsabilidades por serviço.
- [ ] **Perguntas de entrevista**
  - O que diferencia SRE de operações tradicionais?
  - Como ownership muda qualidade do sistema?

### Semana 80 — SLOs e error budgets

- [ ] **Objetivos**
  - Aplicar SLO como ferramenta de decisão.
  - Parar de discutir confiabilidade só de forma subjetiva.
- [ ] **Leitura da semana**
  - SRE — cap. 3 e cap. 4 (~15–20 págs).
  - Sem leitura nova extra.
- [ ] **Prática aplicada**
  - Definir SLOs para catálogo, playback metadata, comentários e assinatura.
  - Criar painel simples de error budget consumido.
- [ ] **Exercício estilo PR**
  - PR 080: SLOs por fluxo + painel de error budget + racional de criticidade.
- [ ] **Perguntas de entrevista**
  - Como escolher SLO diferente para endpoints diferentes?
  - O que você faria se o error budget acabasse cedo?

### Semana 81 — Monitoring distributed systems

- [ ] **Objetivos**
  - Distinguir monitoramento orientado a sintomas e a causas.
  - Estruturar sinais mínimos úteis.
- [ ] **Leitura da semana**
  - SRE — cap. 6 (~12–15 págs).
  - BM — cap. 10, metade 1 (~8–10 págs).
- [ ] **Prática aplicada**
  - Instrumentar métricas RED/USE para gateway e um serviço crítico.
  - Criar painel inicial em Grafana.
- [ ] **Exercício estilo PR**
  - PR 081: métricas RED/USE + dashboard inicial + convenções de nomenclatura.
- [ ] **Perguntas de entrevista**
  - Quais métricas mínimas você coleta em um serviço HTTP?
  - Por que logs sozinhos não bastam?

### Semana 82 — Alerting e on-call

- [ ] **Objetivos**
  - Evitar alert fatigue e criar alertas acionáveis.
  - Relacionar alerta com SLO e runbook.
- [ ] **Leitura da semana**
  - SRE — cap. 10 e cap. 11 (leitura seletiva, ~12–18 págs).
  - Sem leitura nova adicional.
- [ ] **Prática aplicada**
  - Criar poucos alertas úteis: latência p95, taxa de erro, fila acumulada, breaker aberto.
  - Escrever runbook curto para cada alerta.
- [ ] **Exercício estilo PR**
  - PR 082: alertas acionáveis + runbooks vinculados + supressão de alertas ruidosos.
- [ ] **Perguntas de entrevista**
  - O que faz um bom alerta?
  - Por que alertar CPU alta sem contexto costuma ser ruim?

### Semana 83 — Troubleshooting e incident response

- [ ] **Objetivos**
  - Aprender a investigar de forma estruturada.
  - Treinar raciocínio durante falha realista.
- [ ] **Leitura da semana**
  - SRE — cap. 12, 13 e 14 (leitura seletiva, ~15–20 págs).
  - Sem leitura extra.
- [ ] **Prática aplicada**
  - Rodar game day: notificação fora do ar, fila acumulando, alta latência no catálogo.
  - Registrar linha do tempo do incidente.
- [ ] **Exercício estilo PR**
  - PR 083: relatório de incidente simulado + timeline + ações corretivas.
- [ ] **Perguntas de entrevista**
  - Como você conduziria troubleshooting sob pressão?
  - Quais dados você coleta primeiro num incidente de latência?

### Semana 84 — Postmortems e aprendizagem

- [ ] **Objetivos**
  - Transformar falha em melhoria sistêmica.
  - Evitar cultura de culpa.
- [ ] **Leitura da semana**
  - SRE — cap. 15 e cap. 16 (leitura seletiva, ~12–18 págs).
  - Revisão do incidente da semana 83.
- [ ] **Prática aplicada**
  - Escrever postmortem blameless do game day.
  - Definir ações preventivas, detectivas e mitigatórias.
- [ ] **Exercício estilo PR**
  - PR 084: postmortem completo + backlog de ações com prioridade e owner.
- [ ] **Perguntas de entrevista**
  - O que é um postmortem blameless?
  - Como evitar que postmortem vire ritual sem efeito?

### Semana 85 — SPOF e disaster recovery I

- [ ] **Objetivos**
  - Identificar single points of failure no projeto.
  - Planejar recuperação em vez de torcer para nada quebrar.
- [ ] **Leitura da semana**
  - SRE — revisão aplicada dos capítulos de incidentes e confiabilidade.
  - Leitura leve sobre RTO, RPO, backups e restore.
- [ ] **Prática aplicada**
  - Mapear SPOFs: banco primário, gateway, DNS, storage de mídia, fila, secrets/config.
  - Definir RTO/RPO desejados para fluxos críticos.
- [ ] **Exercício estilo PR**
  - PR 085: matriz de SPOFs + objetivos de DR (RTO/RPO) por fluxo.
- [ ] **Perguntas de entrevista**
  - O que é SPOF em aplicação, dados e operação?
  - Como RTO e RPO afetam custo?

### Semana 86 — Disaster recovery II e chaos drills

- [ ] **Objetivos**
  - Sair do papel e testar recuperação.
  - Tornar restore e failover verificáveis.
- [ ] **Leitura da semana**
  - Leitura leve sobre backup/restore e chaos basics (~10–12 págs).
  - Sem capítulo novo pesado.
- [ ] **Prática aplicada**
  - Executar restore de banco em ambiente local/lab.
  - Simular indisponibilidade de cache ou fila e validar comportamento.
- [ ] **Exercício estilo PR**
  - PR 086: drill de restore + caos controlado + evidência do tempo de recuperação.
- [ ] **Perguntas de entrevista**
  - Backup sem restore testado serve para quê?
  - Como você introduziria chaos engineering com segurança?

### Semana 87 — Observabilidade I: logs, métricas e traces

- [ ] **Objetivos**
  - Conectar os três pilares da observabilidade.
  - Tornar cada requisição rastreável ponta a ponta.
- [ ] **Leitura da semana**
  - BM — cap. 10, metade 2 (~12–15 págs).
  - Leitura leve sobre OpenTelemetry.
- [ ] **Prática aplicada**
  - Adicionar tracing distribuído com traceId nos logs.
  - Exportar métricas e traces de gateway → serviço → banco.
- [ ] **Exercício estilo PR**
  - PR 087: OpenTelemetry inicial + correlação log/trace/metric.
- [ ] **Perguntas de entrevista**
  - Qual a diferença entre monitoramento e observabilidade?
  - Por que correlation IDs são importantes?

### Semana 88 — Observabilidade II: dashboards e debugging distribuído

- [ ] **Objetivos**
  - Construir painéis úteis para operação e investigação.
  - Aprender a navegar de sintoma até causa provável.
- [ ] **Leitura da semana**
  - SRE — revisão do cap. 6 e BM cap. 10.
  - Sem leitura nova pesada.
- [ ] **Prática aplicada**
  - Criar dashboards por serviço e por jornada (publicar vídeo, assinar plano, comentar).
  - Montar consulta de trace para gargalo em cadeia.
- [ ] **Exercício estilo PR**
  - PR 088: dashboards por jornada + guia de debugging distribuído.
- [ ] **Perguntas de entrevista**
  - Como você desenha dashboard para negócio e para engenharia?
  - Qual visualização ajuda mais em gargalo distribuído?

### Semana 89 — Arquitetura: decisões, trade-offs e ADRs

- [ ] **Objetivos**
  - Aprimorar comunicação arquitetural.
  - Tomar decisões explícitas e revisáveis.
- [ ] **Leitura da semana**
  - FOSA — cap. 19 (parte 1, ~10–15 págs).
  - Revisão de ADRs existentes.
- [ ] **Prática aplicada**
  - Reescrever ADRs antigas ruins ou vagas.
  - Criar padrão obrigatório: contexto, decisão, trade-offs, riscos, rollback.
- [ ] **Exercício estilo PR**
  - PR 089: revisão de ADRs + template final e exemplos bons/ruins.
- [ ] **Perguntas de entrevista**
  - Como justificar uma decisão arquitetural em entrevista?
  - O que torna um ADR realmente útil?

### Semana 90 — Risco arquitetural, diagramas e comunicação

- [ ] **Objetivos**
  - Aprender a apresentar arquitetura com clareza.
  - Tornar risco e opção visíveis para o time.
- [ ] **Leitura da semana**
  - FOSA — cap. 20 e cap. 21 (~15–20 págs no ritmo leve).
  - Sem leitura nova extra.
- [ ] **Prática aplicada**
  - Criar árvore de riscos arquiteturais do projeto.
  - Atualizar diagramas C4 e diagramas de sequência dos fluxos críticos.
- [ ] **Exercício estilo PR**
  - PR 090: risk register arquitetural + C4 atualizado + diagramas de sequência.
- [ ] **Perguntas de entrevista**
  - Como você comunica risco técnico sem alarmismo?
  - Quais diagramas são mais úteis para entrevistas de system design?

### Semana 91 — Consolidação do 7º trimestre

- [ ] **Objetivos**
  - Fechar confiabilidade, DR e observabilidade num nível sólido.
  - Preparar a reta final para entrevistas e capstone.
- [ ] **Leitura da semana**
  - Revisão dos capítulos SRE lidos, BM 10, FOSA 19–21; sem leitura nova.
  - Releitura dos runbooks e postmortems.
- [ ] **Prática aplicada**
  - Executar mini auditoria final de produção: métricas, alertas, traces, runbooks, restore, SLOs.
  - Publicar release `v1.3-reliability`.
- [ ] **Exercício estilo PR**
  - PR 091: auditoria de confiabilidade + correções finais + release `v1.3-reliability`.
- [ ] **Perguntas de entrevista**
  - Se cair uma dependência crítica, como você detecta, isola e comunica?
  - Quais evidências mostram que seu sistema amadureceu operacionalmente?

## Q8 — Arquitetura final, mocks de entrevista e capstone


### Semana 92 — Revisão dos estilos arquiteturais

- [ ] **Objetivos**
  - Revisitar estilos antes do capstone final.
  - Escolher conscientemente em vez de repetir moda.
- [ ] **Leitura da semana**
  - FOSA — caps. 9 a 18, revisão seletiva em ritmo leve (escolha 2–3 estilos por semana, ~15 págs).
  - Sem novo DDIA/BM pesado.
- [ ] **Prática aplicada**
  - Comparar para o StreamForge: layered, event-driven, service-based, microservices, space-based.
  - Documentar por que a solução final é híbrida.
- [ ] **Exercício estilo PR**
  - PR 092: matriz comparativa de estilos arquiteturais aplicados ao projeto.
- [ ] **Perguntas de entrevista**
  - Como escolher estilo arquitetural para um problema novo?
  - Por que sistemas reais acabam híbridos?

### Semana 93 — Service-based vs event-driven vs microservices

- [ ] **Objetivos**
  - Treinar narrativa de escolha arquitetural em entrevistas.
  - Explicitar quando simplificar.
- [ ] **Leitura da semana**
  - FOSA — revisão caps. 13, 14 e 17 (~12–18 págs).
  - BM — revisão dos caps. 1–6.
- [ ] **Prática aplicada**
  - Escrever documento 'três arquiteturas candidatas' para o mesmo problema do projeto.
  - Comparar custo operacional, autonomia, velocidade e observabilidade.
- [ ] **Exercício estilo PR**
  - PR 093: comparação de arquiteturas candidatas com recomendação final.
- [ ] **Perguntas de entrevista**
  - Service-based e microservices: qual a diferença prática?
  - Quando event-driven é exagero?

### Semana 94 — Estratégias de migração

- [ ] **Objetivos**
  - Treinar abordagem incremental e pé no chão.
  - Evitar big bang em modernização.
- [ ] **Leitura da semana**
  - BM — revisão do cap. 3: Splitting the Monolith.
  - Leitura leve sobre strangler fig e migration patterns.
- [ ] **Prática aplicada**
  - Escrever plano de migração do StreamForge do estado atual para um cenário 10x maior em 4 etapas.
  - Definir métricas de sucesso por etapa.
- [ ] **Exercício estilo PR**
  - PR 094: roadmap de migração incremental + critérios de sucesso e rollback.
- [ ] **Perguntas de entrevista**
  - Como você migraria um monólito legado para microservices?
  - Quais módulos sair primeiro e quais ficar?

### Semana 95 — Segurança em sistemas distribuídos

- [ ] **Objetivos**
  - Fechar lacunas básicas de authn, authz, secrets e defense in depth.
  - Evitar que escalabilidade ignore segurança.
- [ ] **Leitura da semana**
  - BM — cap. 11 (~12–15 págs).
  - SRE — revisão do papel da segurança na confiabilidade.
- [ ] **Prática aplicada**
  - Revisar JWT/escopos, mTLS conceitual, gestão de segredos e proteção de endpoints internos.
  - Adicionar auditoria básica de ações administrativas.
- [ ] **Exercício estilo PR**
  - PR 095: melhorias de segurança distribuída + auditoria administrativa.
- [ ] **Perguntas de entrevista**
  - Como segurança e confiabilidade se cruzam?
  - O que muda na superfície de ataque com microservices?

### Semana 96 — Times, liderança técnica e governança

- [ ] **Objetivos**
  - Conectar arquitetura com times e processo.
  - Treinar raciocínio de sênior/lead, não só de implementador.
- [ ] **Leitura da semana**
  - FOSA — cap. 22 e cap. 23 (~15–20 págs).
  - Revisão curta dos princípios do projeto.
- [ ] **Prática aplicada**
  - Descrever topologia de times fictícia para operar o sistema em escala.
  - Criar regras leves de governança: ADR, SLO, revisão de APIs, incidentes.
- [ ] **Exercício estilo PR**
  - PR 096: operating model do sistema + governança arquitetural leve.
- [ ] **Perguntas de entrevista**
  - Como a estrutura do time afeta a arquitetura?
  - O que um sênior faz além de codar?

### Semana 97 — Mock interview 1: catálogo e ingestão de mídia

- [ ] **Objetivos**
  - Treinar entrevista em problema mais próximo de YouTube/Netflix.
  - Organizar resposta em requisitos, estimativas, componentes e trade-offs.
- [ ] **Leitura da semana**
  - Sem leitura pesada: revisar suas próprias notas e diagramas.
  - Opcional: releitura seletiva DDIA cap. 3 e 5.
- [ ] **Prática aplicada**
  - Responder em 45–60 min: desenhar sistema de upload/ingestão/metadata de vídeos.
  - Gravar ou escrever a resposta completa.
- [ ] **Exercício estilo PR**
  - PR 097: design doc 'ingestão de mídia' com requisitos, estimativas, diagrama e trade-offs.
- [ ] **Perguntas de entrevista**
  - Como separar upload, transcodificação e entrega de metadata?
  - Onde entram filas, object storage e processamento assíncrono?

### Semana 98 — Mock interview 2: feed, comentários e notificações

- [ ] **Objetivos**
  - Treinar problema social/read-heavy.
  - Comparar push, pull, cache e fan-out.
- [ ] **Leitura da semana**
  - Sem leitura pesada; revisar DDIA 5–6 e MP 7.
  - Revisar cache e read models.
- [ ] **Prática aplicada**
  - Responder design de feed e comentários com vídeos virais.
  - Comparar fan-out on write vs fan-out on read conceitualmente.
- [ ] **Exercício estilo PR**
  - PR 098: design doc de feed/comentários/notificações + hotspots e mitigação.
- [ ] **Perguntas de entrevista**
  - Como você desenharia comentários para vídeos virais?
  - Onde usaria cache, shard e fila?

### Semana 99 — Mock interview 3: billing e assinaturas

- [ ] **Objetivos**
  - Treinar problema transacional/distribuído.
  - Usar saga, idempotência e consistência de forma madura.
- [ ] **Leitura da semana**
  - Sem leitura nova pesada; revisão MP 4 e Release It.
  - Revisar event sourcing somente se fizer sentido.
- [ ] **Prática aplicada**
  - Responder design de assinatura mensal com pagamento, renovação, cancelamento e notificação.
  - Incluir falhas parciais e compensações.
- [ ] **Exercício estilo PR**
  - PR 099: design doc de billing/assinaturas + fluxos de falha e compensação.
- [ ] **Perguntas de entrevista**
  - Como garantir que o usuário não fique com plano ativo sem cobrança confirmada?
  - Onde exigiria consistência forte?

### Semana 100 — Mock interview 4: analytics e ranking

- [ ] **Objetivos**
  - Treinar problema de derived data.
  - Combinar batch, stream e leitura agregada.
- [ ] **Leitura da semana**
  - Sem leitura nova obrigatória; revisão DDIA 10–11.
  - Revisar CQRS/read models do projeto.
- [ ] **Prática aplicada**
  - Responder design de ranking de vídeos, métricas por criador e relatórios diários.
  - Comparar batch vs stream para cada métrica.
- [ ] **Exercício estilo PR**
  - PR 100: design doc de analytics/ranking + decisão batch/stream por caso de uso.
- [ ] **Perguntas de entrevista**
  - Quando batch é suficiente e quando stream vale a pena?
  - Como separar analytics de OLTP?

### Semana 101 — Capstone final I: arquitetura consolidada

- [ ] **Objetivos**
  - Fechar a versão final do projeto como peça de portfólio.
  - Escolher escopo que demonstre senioridade sem virar tese.
- [ ] **Leitura da semana**
  - Revisão seletiva de todos os livros conforme as lacunas encontradas.
  - Sem leitura nova pesada.
- [ ] **Prática aplicada**
  - Definir escopo final demonstrável: gateway, BFF, 3–5 serviços, fila, cache, observabilidade, SLO, runbooks.
  - Congelar backlog e focar acabamento.
- [ ] **Exercício estilo PR**
  - PR 101: escopo final do capstone + roadmap de acabamento + checklist de entrega.
- [ ] **Perguntas de entrevista**
  - O que precisa existir num projeto para comunicar senioridade?
  - Como cortar escopo sem perder profundidade?

### Semana 102 — Capstone final II: acabamento técnico

- [ ] **Objetivos**
  - Elevar qualidade de documentação, testes e operação.
  - Transformar o projeto em material de entrevista e portfólio.
- [ ] **Leitura da semana**
  - Sem leitura nova; revisão dos runbooks, ADRs e diagramas.
  - Opcional: releitura FOSA cap. 21.
- [ ] **Prática aplicada**
  - Completar README, diagramas, scripts de demo, dashboards e casos de falha demonstráveis.
  - Garantir que alguém consiga rodar tudo localmente.
- [ ] **Exercício estilo PR**
  - PR 102: acabamento do portfólio técnico + roteiro de demo + docs finais.
- [ ] **Perguntas de entrevista**
  - Como você apresentaria este projeto a um tech lead?
  - O que costuma faltar em portfólio técnico?

### Semana 103 — Loop final de entrevistas

- [ ] **Objetivos**
  - Treinar comunicação sob tempo limitado.
  - Ganhar fluidez para perguntas abertas de system design.
- [ ] **Leitura da semana**
  - Sem leitura pesada; usar apenas revisão de anotações e respostas antigas.
  - Checklist final de conceitos: CAP, PACELC, cache, filas, CQRS, saga, SLO, DR, observabilidade.
- [ ] **Prática aplicada**
  - Fazer 2–3 simulações cronometradas de entrevista.
  - Reescrever respostas fracas e refinar narrativa de trade-offs.
- [ ] **Exercício estilo PR**
  - PR 103: pasta `interview-prep/` com respostas-modelo, diagramas rápidos e checklists.
- [ ] **Perguntas de entrevista**
  - Como você estrutura sua resposta em uma entrevista de system design?
  - O que fazer quando não sabe um detalhe exato?

### Semana 104 — Revisão final e próximos passos

- [ ] **Objetivos**
  - Encerrar o plano com visão clara do que foi aprendido e do que vem depois.
  - Transformar estudo em rotina sustentável de carreira.
- [ ] **Leitura da semana**
  - Revisão global; sem leitura nova.
  - Retrospectiva dos 2 anos e definição do próximo ciclo (cloud, Kafka avançado, Kubernetes, banco distribuído, etc.).
- [ ] **Prática aplicada**
  - Publicar release final `v2.0-capstone`.
  - Escrever retrospectiva: habilidades ganhas, pontos fracos restantes, próximos estudos.
- [ ] **Exercício estilo PR**
  - PR 104: release final + retrospectiva técnica e plano do próximo ciclo.
- [ ] **Perguntas de entrevista**
  - Hoje, como você se posicionaria em system design backend?
  - Quais lacunas restam para nível sênior forte e como atacá-las?

---

# Apêndice A — Progressão esperada ao longo dos 2 anos

## Fase 1 — Base sólida
Você termina a fase inicial sabendo discutir:

- HTTP, TCP/IP, DNS e impacto em APIs;
- índices, modelagem de dados, transações e isolamento;
- diferença entre monólito em camadas e monólito modular;
- por que distribuir cedo demais é caro.

## Fase 2 — Distribuição consciente
Você passa a conseguir discutir:

- decomposição por domínio;
- replicação, particionamento e consistência eventual;
- REST, gRPC, gateways, BFFs e cache;
- mensageria e contratos de integração.

## Fase 3 — Patterns avançados
Você entra em terreno mais sênior:

- CQRS;
- event sourcing com recorte;
- sagas;
- idempotência;
- sharding e scale cube;
- capacity planning;
- deployments seguros.

## Fase 4 — Operação e entrevistas
Na reta final, você precisa estar confortável em:

- SLOs, error budgets, alerting e incident response;
- runbooks, postmortems e DR;
- ADRs, diagramas e comunicação de trade-offs;
- mock interviews de system design.

# Apêndice B — Critério de qualidade para cada PR semanal

Antes de considerar a semana pronta, confira:

- [ ] O PR tem contexto do problema?
- [ ] O PR explica a decisão técnica?
- [ ] O PR registra trade-offs?
- [ ] O PR cita riscos/limitações?
- [ ] O PR mostra como testar/validar?
- [ ] O PR deixa claro o que mudou na arquitetura?

# Apêndice C — Como revisar sem se perder

A cada 4 semanas, revise:
- conceitos principais em 1 página;
- 3 decisões boas;
- 3 decisões ruins ou prematuras;
- 1 gargalo real observado;
- 1 pergunta de entrevista que você ainda responde mal.

# Apêndice D — Resultado esperado ao final

Ao final das 104 semanas, você deve conseguir:

- desenhar uma arquitetura backend distribuída em nível pleno/sênior;
- justificar trade-offs entre monólito, modular monolith e microservices;
- explicar quando usar cache, fila, CQRS, saga, read model, shard, réplica;
- falar de SLO, observabilidade, incidentes e recovery sem soar teórico demais;
- apresentar um projeto de portfólio com profundidade real em Java + Spring.

