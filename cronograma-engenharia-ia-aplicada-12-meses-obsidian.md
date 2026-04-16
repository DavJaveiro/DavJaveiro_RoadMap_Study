# Cronograma de 12 Meses — Engenharia de IA Aplicada

> Formato pensado para **Obsidian**.
> 
> Foco: **Engenharia de IA aplicada**, com viés de **backend/plataforma**, usando **Java 21 + Spring Boot + Spring AI** como stack principal de aplicação, e **Python apenas onde o ecossistema é dominante** (evals, notebooks, LoRA/PEFT, experimentos e tooling).

---

## 1. Objetivo final da trilha

Ao final destes 12 meses, você deverá ser capaz de:

- projetar aplicações de IA em produção com **RAG, agents, MCP, multimodalidade e observabilidade**;
- decidir com clareza entre **prompting, RAG, fine-tuning e workflows determinísticos**;
- integrar IA a um **backend real em Java/Spring**;
- construir sistemas com **guardrails, avaliação, governança, custo controlado e deploy confiável**;
- discutir arquitetura de IA em entrevistas de nível **pleno/sênior**;
- defender decisões com trade-offs de **latência, custo, precisão, segurança e manutenção**.

---

## 2. Como usar este cronograma

### Carga sugerida

- **10 a 14 horas por semana**
- Distribuição ideal:
  - **4h leitura/estudo teórico**
  - **4h implementação prática**
  - **2h exercícios estilo PR**
  - **1h interview drill**
  - **1h revisão/anotações**

### Regra de ouro por semana

Toda semana deve ter:

- [ ] 1 bloco de leitura principal
- [ ] 1 implementação real
- [ ] 1 exercício em estilo Pull Request
- [ ] 1 decisão arquitetural com trade-offs escritos
- [ ] 1 simulado curto de entrevista
- [ ] 1 revisão das notas no Obsidian

### Formato dos exercícios estilo PR

Use sempre este molde:

```md
## Contexto
## Problema
## Hipótese de solução
## Decisão adotada
## Trade-offs
## Evidências / testes / métricas
## Riscos remanescentes
## Próximos passos
```

---

## 3. Projeto contínuo da trilha

## Projeto-base: **EngOps Copilot**

Você vai evoluir ao longo de 12 meses um **micro-SaaS interno de engenharia** com estes módulos:

1. **RAG de documentação técnica**
   - runbooks
   - post-mortems
   - READMEs
   - playbooks internos

2. **Assistente de incidentes**
   - consulta documentação
   - sugere hipóteses
   - executa ferramentas seguras
   - gera timeline e resumo técnico

3. **Camada MCP**
   - expõe tools/resources/prompts
   - integra backend, UI e agentes

4. **Módulo de observabilidade**
   - tracing
   - custo por request
   - qualidade de resposta
   - eventos de segurança

5. **Módulo DevOps/AIOps**
   - copiloto de IaC
   - suporte a Kubernetes
   - ChatOps com aprovação humana

6. **Capstone final**
   - API + UI + MCP + deploy + documentação + defesa técnica

---

## 4. Stack recomendada

### Núcleo de aplicação
- Java 21
- Spring Boot 3
- Spring AI
- Maven ou Gradle
- PostgreSQL + pgvector
- Redis
- Kafka (ou RabbitMQ)
- Docker Compose
- Kubernetes (mais adiante)
- OpenTelemetry
- Grafana / Prometheus / Loki / Tempo

### Ferramentas auxiliares
- Python 3.11+ para evals, notebooks e fine-tuning
- Jupyter
- Ollama para modelos locais
- OpenRouter ou APIs de provedores
- LangGraph / LangChain para workflows avançados
- OPA para policy-as-code

---

## 5. Livros-base da trilha

## Livro 1 — *AI Engineering* — Chip Huyen

### Ordem principal de leitura
1. Chapter 1 — *Introduction to Building AI Applications with Foundation Models* (pp. 1–48)
2. Chapter 2 — *Understanding Foundation Models* (pp. 49–112)
3. Chapter 3 — *Evaluation Methodology* (pp. 113–156)
4. Chapter 4 — *Evaluate AI Systems* (pp. 159–208)
5. Chapter 5 — *Prompt Engineering* (pp. 211–252)
6. Chapter 6 — *RAG and Agents* (pp. 253–305)
7. Chapter 7 — *Finetuning* (pp. 307–361)
8. Chapter 8 — *Dataset Engineering* (pp. 363–403)
9. Chapter 9 — *Inference Optimization* (pp. 405–447)
10. Chapter 10 — *AI Engineering Architecture and User Feedback* (pp. 449–492)

## Livro 2 — *Hands-On Large Language Models* — Jay Alammar / Maarten Grootendorst

### Capítulos mais importantes nesta trilha
1. Introduction to Language Models
2. Tokens and Embeddings
3. Looking Inside Transformer LLMs
4. Text Classification
5. Text Clustering and Topic Modeling
6. Prompt Engineering
7. Advanced Text Generation Techniques and Tools
8. Semantic Search and RAG
9. Multimodal LLMs
10. Creating Text Embedding Models
11. Fine-tuning Representation Models for Classification
12. Fine-tuning Generation Models

## Livro 3 — *Designing Machine Learning Systems* — Chip Huyen

### Ordem principal de leitura
1. Chapter 1 — *Overview of ML Systems* (p. 1)
2. Chapter 2 — *Introduction to ML Systems Design* (p. 25)
3. Chapter 3 — *Data Engineering Fundamentals* (p. 49)
4. Chapter 4 — *Training Data* (p. 81)
5. Chapter 5 — *Feature Engineering* (p. 119)
6. Chapter 6 — *Model Development and Offline Evaluation* (p. 149)
7. Chapter 7 — *Model Deployment and Prediction Service* (p. 191)
8. Chapter 8 — *Data Distribution Shifts and Monitoring* (p. 225)
9. Chapter 9 — *Continual Learning and Test in Production* (p. 263)

## Livro 4 — *Machine Learning Design Patterns* — Lakshmanan, Robinson, Munn

### Ordem principal de leitura
1. Chapter 1 — *The Need for ML Design Patterns* (p. 1)
2. Chapter 2 — *Data Representation Design Patterns* (p. 19)
3. Chapter 3 — *Problem Representation Design Patterns* (p. 79)
4. Chapter 4 — *Model Training Patterns* (p. 139)
5. Chapter 5 — *Design Patterns for Resilient Serving* (p. 201)
6. Chapter 6 — *Reproducibility Design Patterns* (p. 249)
7. Chapter 7 — *Responsible AI* (p. 319)
8. Chapter 8 — *Connected Patterns* (p. 359)

## Livros de apoio opcional
- *Designing Data-Intensive Applications*
- *Fundamentals of Software Architecture*

---

## 6. Banco de recursos recorrentes

## Vídeos (use ao longo da trilha)

- **V01** — 3Blue1Brown — *But what is a neural network?*
- **V02** — 3Blue1Brown — *Gradient Descent / Backprop*
- **V03** — Andrej Karpathy — *Intro to Large Language Models*
- **V04** — Jay Alammar — *The Illustrated Transformer*
- **V05** — StatQuest — *Embeddings / Word Embeddings*
- **V06** — DeepLearning.AI — *Prompt Engineering for Developers*
- **V07** — DeepLearning.AI / GenAI — *RAG fundamentals*
- **V08** — LangGraph / LangChain official — *agent orchestration*
- **V09** — Spring I/O / Spring official — *Spring AI & Java for AI apps*
- **V10** — Kubernetes / Nana / CNCF — *Kubernetes fundamentals*
- **V11** — Grafana / Prometheus — *observability + PromQL/LogQL*
- **V12** — Google / GenAI — *multimodal systems*
- **V13** — Hugging Face — *Fine-tuning, LoRA e PEFT*
- **V14** — Chip Huyen / AI Engineer Summit — *evals e arquitetura*
- **V15** — OpenTelemetry talks — *tracing e LLM observability*
- **V16** — OPA / security talks — *policy as code + guardrails*

## Artigos / docs oficiais

- **A01** — Spring AI Reference — Introduction  
  https://docs.spring.io/spring-ai/reference/index.html
- **A02** — Spring AI Reference — MCP Overview  
  https://docs.spring.io/spring-ai/reference/api/mcp/mcp-overview.html
- **A03** — Spring AI Reference — Vector Databases  
  https://docs.spring.io/spring-ai/reference/api/vectordbs.html
- **A04** — MCP official docs — Intro  
  https://modelcontextprotocol.io/docs/getting-started/intro
- **A05** — Anthropic — Intro to MCP  
  https://www.anthropic.com/news/model-context-protocol
- **A06** — LangGraph Overview  
  https://docs.langchain.com/oss/python/langgraph/overview
- **A07** — OpenAI — Model optimization / fine-tuning  
  https://developers.openai.com/api/docs/guides/model-optimization
- **A08** — OpenAI — Supervised fine-tuning  
  https://developers.openai.com/api/docs/guides/supervised-fine-tuning
- **A09** — OpenAI — Fine-tuning best practices  
  https://developers.openai.com/api/docs/guides/fine-tuning-best-practices
- **A10** — OpenTelemetry docs  
  https://opentelemetry.io/docs/
- **A11** — OpenTelemetry — LLM observability  
  https://opentelemetry.io/blog/2024/llm-observability/
- **A12** — Spring AI — Getting started with MCP  
  https://docs.spring.io/spring-ai/reference/guides/getting-started-mcp.html
- **A13** — OPA docs  
  https://openpolicyagent.org/docs
- **A14** — NIST AI RMF  
  https://www.nist.gov/itl/ai-risk-management-framework
- **A15** — OWASP Top 10 for LLM Applications  
  https://owasp.org/www-project-top-10-for-large-language-model-applications/
- **A16** — Spring AI project page  
  https://spring.io/projects/spring-ai

---

# 7. Cronograma de 12 meses

---

# Mês 1 — Fundamentos de IA, LLMs e base da plataforma

## Semana 1 — Panorama de IA, ML, DL e Engenharia de IA

**Objetivos**
- Entender o que diferencia IA aplicada de software tradicional.
- Diferenciar ML, DL, LLMs, AI Engineering e ML Engineering.
- Definir o escopo do projeto EngOps Copilot.

**Conteúdos teóricos**
- História e contexto da IA.
- Diferença entre regras determinísticas e sistemas probabilísticos.
- O ciclo de vida de uma aplicação com foundation models.

**Leitura da semana**
- *AI Engineering* — Ch. 1 (pp. 1–48)
- *Designing Machine Learning Systems* — Ch. 1 (pp. 1–24)
- *Hands-On LLMs* — Ch. 1

**Prática aplicada**
- Criar o repositório monorepo:
  - `backend-java/`
  - `evals/`
  - `ui/`
  - `infra/`
  - `docs/`
- Criar README com problema, público-alvo, proposta de valor e arquitetura inicial.

**Exercício estilo PR**
- **PR-001**: bootstrap do projeto + arquitetura inicial + ADR-001 explicando por que o projeto começará com RAG antes de fine-tuning.

**Interview drill**
- O que muda quando o comportamento do sistema depende de um modelo e não só de regras?
- O que é AI Engineering e como ela difere de ML Engineering?

**Complementos**
- Vídeos: V03, V14
- Artigos/docs: A16

---

## Semana 2 — Tokens, embeddings, tensores e atenção

**Objetivos**
- Entender a base conceitual dos LLMs.
- Compreender embeddings e por que eles são centrais para RAG.
- Mapear onde isso entra no backend Java.

**Conteúdos teóricos**
- Tokens e tokenização.
- Embeddings, similaridade vetorial e coseno.
- Atenção e transformers em alto nível.

**Leitura da semana**
- *AI Engineering* — Ch. 2 (pp. 49–80)
- *Hands-On LLMs* — Ch. 2 e Ch. 3

**Prática aplicada**
- Criar serviço em Java para gerar embeddings via provedor externo.
- Salvar vetores no Postgres de forma provisória.
- Criar endpoint `/embeddings/test`.

**Exercício estilo PR**
- **PR-002**: módulo de embeddings + testes de integração + comparação entre duas estratégias de chunking pequenas.

**Interview drill**
- O que é embedding?
- Qual a diferença entre busca lexical e semântica?

**Complementos**
- Vídeos: V04, V05
- Artigos/docs: A03

---

## Semana 3 — Redes neurais, treino e inferência

**Objetivos**
- Consolidar a base de treino → validação → inferência.
- Não virar pesquisador, mas entender o suficiente para projetar sistemas melhores.

**Conteúdos teóricos**
- Redes neurais básicas.
- Loss, gradiente, overfitting, generalização.
- Offline evaluation vs online behavior.

**Leitura da semana**
- *Designing Machine Learning Systems* — Ch. 2 (pp. 25–48)
- *Machine Learning Design Patterns* — Ch. 1 (pp. 1–18)

**Prática aplicada**
- Implementar um notebook simples em Python com classificação textual mínima.
- Registrar métricas de treino e erros comuns.
- Documentar os limites do experimento para não extrapolar para produção.

**Exercício estilo PR**
- **PR-003**: notebook + relatório curto explicando por que um experimento local não equivale a um sistema robusto em produção.

**Interview drill**
- Por que alta acurácia offline pode falhar em produção?
- O que é overfitting em linguagem prática?

**Complementos**
- Vídeos: V01, V02
- Artigos/docs: A10

---

## Semana 4 — Primeira API de IA com Java + Spring AI

**Objetivos**
- Colocar um LLM atrás de uma API em Java.
- Entender timeout, retries, logs e versionamento de prompts.

**Conteúdos teóricos**
- Integração backend ↔ provedor de modelo.
- Controle de custo e previsibilidade.
- Saídas estruturadas e validação.

**Leitura da semana**
- *AI Engineering* — revisar Ch. 1 e Ch. 2
- Docs Spring AI: A01

**Prática aplicada**
- Criar endpoint `/ai/chat` usando Spring AI.
- Adicionar `requestId`, tempo de resposta e logging.
- Criar versão inicial de prompt template.

**Exercício estilo PR**
- **PR-004**: endpoint `/ai/chat` com timeout, retries controlados e resposta estruturada.

**Interview drill**
- Quais falhas você espera ao colocar um LLM em produção?
- Como você controlaria custo por request?

**Complementos**
- Vídeos: V09, V06
- Artigos/docs: A01, A16

---

# Mês 2 — Prompt Engineering, avaliação e RAG básico

## Semana 5 — Prompt engineering fundamental

**Objetivos**
- Tornar prompts artefatos de engenharia, não improviso.
- Separar instrução, contexto, exemplos e formato de saída.

**Conteúdos teóricos**
- Zero-shot, few-shot, constraints, output schema.
- Prompt anti-vaguidade.
- Estratégias para reduzir alucinação.

**Leitura da semana**
- *AI Engineering* — Ch. 5 (pp. 211–252)
- *Hands-On LLMs* — Ch. 6

**Prática aplicada**
- Criar pasta `prompts/` versionada.
- Definir padrão de prompt para sumarização técnica, Q&A e classificação.
- Criar contrato JSON de saída para incident summary.

**Exercício estilo PR**
- **PR-005**: refatorar prompts ad hoc para templates versionados com testes de regressão textual.

**Interview drill**
- O que faz um prompt ser bom em produção?
- Quando prompt engineering deixa de ser suficiente?

**Complementos**
- Vídeos: V06
- Artigos/docs: A07

---

## Semana 6 — Metodologia de avaliação para LLM apps

**Objetivos**
- Construir o hábito de medir qualidade desde cedo.
- Diferenciar demo convincente de sistema confiável.

**Conteúdos teóricos**
- Golden datasets.
- Avaliação qualitativa vs quantitativa.
- Métricas: precision@k, groundedness, faithfulness, task success.

**Leitura da semana**
- *AI Engineering* — Ch. 3 (pp. 113–156)
- *AI Engineering* — Ch. 4 (pp. 159–208)

**Prática aplicada**
- Criar pasta `evals/` com 20–30 casos de teste.
- Definir rubrica para resposta correta, parcialmente correta e incorreta.
- Criar script simples de batch evaluation.

**Exercício estilo PR**
- **PR-006**: pipeline inicial de evals + dataset de regressão + relatório de baseline.

**Interview drill**
- Como você mede qualidade de um chatbot com base documental?
- Como detectar regressão sem depender só de feeling?

**Complementos**
- Vídeos: V14
- Artigos/docs: A10, A11

---

## Semana 7 — Custo, latência, contexto e saídas previsíveis

**Objetivos**
- Projetar com limites reais de produção.
- Entender janelas de contexto, chunking e custo/token.

**Conteúdos teóricos**
- Trade-offs de contexto longo.
- Caching de prompts e respostas.
- Structured outputs.

**Leitura da semana**
- *AI Engineering* — trechos finais do Ch. 5
- *Hands-On LLMs* — Ch. 7

**Prática aplicada**
- Adicionar cache para prompts repetidos.
- Medir custo estimado por endpoint.
- Implementar validação de schema na resposta do modelo.

**Exercício estilo PR**
- **PR-007**: introdução de cache + resposta estruturada + dashboard simples de custo.

**Interview drill**
- Como reduzir custo sem derrubar qualidade?
- Qual a diferença entre cache tradicional e semantic cache?

**Complementos**
- Vídeos: V14
- Artigos/docs: A07

---

## Semana 8 — RAG básico com pgvector

**Objetivos**
- Construir o primeiro pipeline RAG real.
- Integrar ingestão, chunking, embeddings, indexação e resposta.

**Conteúdos teóricos**
- Ingestion pipeline.
- Chunking e overlap.
- Retrieval simples.

**Leitura da semana**
- *AI Engineering* — Ch. 6 (início, pp. 253–280)
- *Hands-On LLMs* — Ch. 8

**Prática aplicada**
- Subir Postgres + pgvector.
- Criar pipeline de ingestão de markdown/PDF parseado.
- Criar endpoint `/rag/ask` com citações internas do documento recuperado.

**Exercício estilo PR**
- **PR-008**: primeira versão do RAG do EngOps Copilot com ingestão e endpoint consultável.

**Interview drill**
- Explique RAG em linguagem de arquitetura.
- Quais são as falhas clássicas de um RAG básico?

**Complementos**
- Vídeos: V07
- Artigos/docs: A03

---

# Mês 3 — RAG avançado, multimodal e integração backend

## Semana 9 — Chunking avançado, busca híbrida e reranking

**Objetivos**
- Sair do RAG ingênuo.
- Melhorar recuperação antes de mexer no prompt.

**Conteúdos teóricos**
- Hybrid search.
- Reranking.
- Multi-index e metadata filtering.

**Leitura da semana**
- *AI Engineering* — Ch. 6 (restante)
- *Machine Learning Design Patterns* — Ch. 2 (pp. 19–78)

**Prática aplicada**
- Adicionar filtros por tipo de documento, time, serviço e data.
- Testar estratégia lexical + vetorial.
- Criar reranking simples via modelo ou heurística.

**Exercício estilo PR**
- **PR-009**: busca híbrida + reranking + relatório comparando baseline anterior.

**Interview drill**
- Quando hybrid search vence pure vector search?
- Como explicar recall vs precision num RAG?

**Complementos**
- Vídeos: V07
- Artigos/docs: A03

---

## Semana 10 — Observabilidade e debugging de pipelines RAG

**Objetivos**
- Tornar o pipeline debuggável.
- Saber onde a resposta falhou: ingestão, retrieval ou geração.

**Conteúdos teóricos**
- Tracing de pipelines.
- Logs sem vazar contexto sensível.
- Métricas por etapa.

**Leitura da semana**
- *Designing Machine Learning Systems* — Ch. 8 (p. 225 em diante)
- *AI Engineering* — Ch. 10 (pp. 449–470)

**Prática aplicada**
- Instrumentar ingestão, retrieval e generation com OpenTelemetry.
- Logar `top_k`, score e latência.
- Criar dashboard de falhas de recuperação.

**Exercício estilo PR**
- **PR-010**: tracing ponta a ponta do RAG + painel básico de observabilidade.

**Interview drill**
- Como você investiga uma resposta inventada?
- O que logar sem comprometer segurança?

**Complementos**
- Vídeos: V15, V11
- Artigos/docs: A10, A11

---

## Semana 11 — Multimodalidade: OCR, imagem e áudio

**Objetivos**
- Entender quando multimodal faz sentido.
- Integrar documento, imagem e áudio ao backend.

**Conteúdos teóricos**
- OCR inteligente.
- Visão geral de áudio/transcrição.
- Limites de modelos multimodais.

**Leitura da semana**
- *Hands-On LLMs* — Ch. 9

**Prática aplicada**
- Criar endpoint para upload de imagem/documento.
- Extrair texto e metadados.
- Indexar conteúdo multimodal no pipeline do projeto.

**Exercício estilo PR**
- **PR-011**: OCR + ingestão no RAG + classificação automática do tipo de documento.

**Interview drill**
- Quando usar multimodal e quando não vale o custo?
- Como você validaria OCR ruim?

**Complementos**
- Vídeos: V12
- Artigos/docs: A07

---

## Semana 12 — Integrando IA a um backend existente

**Objetivos**
- Integrar IA como capability de backend, e não como “feature solta”.
- Trabalhar autenticação, versionamento e testes.

**Conteúdos teóricos**
- API design para serviços de IA.
- Controle de rate limit, autenticação e quotas.
- Testes de integração e mocks de provedor.

**Leitura da semana**
- *Designing Machine Learning Systems* — Ch. 7 (p. 191 em diante)

**Prática aplicada**
- Criar módulo `ai-core` desacoplado.
- Versionar endpoints de IA.
- Adicionar testes de contrato.

**Exercício estilo PR**
- **PR-012**: integração formal do módulo de IA ao backend principal, com camadas bem definidas.

**Interview drill**
- Como você evita acoplamento excessivo ao provedor?
- Onde colocar a lógica de IA numa arquitetura em camadas?

**Complementos**
- Vídeos: V09
- Artigos/docs: A01, A16

---

# Mês 4 — MCP (Model Context Protocol)

## Semana 13 — Fundamentos do MCP

**Objetivos**
- Entender MCP como protocolo e não modinha.
- Diferenciar MCP de plugins/tools proprietárias.

**Conteúdos teóricos**
- Tools, resources, prompts.
- Contexto padronizado.
- Casos de uso corporativos.

**Leitura da semana**
- Ementa MCP
- Docs: A04, A05, A12

**Prática aplicada**
- Modelar quais capacidades do EngOps Copilot serão expostas via MCP.
- Definir primeiro catálogo de tools/resources.

**Exercício estilo PR**
- **PR-013**: ADR do MCP com catálogo inicial de capabilities e políticas de exposição.

**Interview drill**
- O que o MCP resolve que integrações ad hoc não resolvem bem?
- Quando MCP não vale a pena?

**Complementos**
- Vídeos: V09
- Artigos/docs: A04, A05

---

## Semana 14 — Construindo um MCP Server em Java/Spring

**Objetivos**
- Publicar ferramentas reais via MCP.
- Conectar backend, recursos e contexto.

**Conteúdos teóricos**
- Design de tools seguras.
- Schemas e contratos.
- Limites operacionais.

**Leitura da semana**
- Docs: A02, A12

**Prática aplicada**
- Implementar MCP Server com pelo menos 3 tools:
  - `search_runbook`
  - `get_incident_summary`
  - `list_services`
- Expor 2 resources versionados.

**Exercício estilo PR**
- **PR-014**: MCP server funcional integrado ao backend do projeto.

**Interview drill**
- Como projetar tools seguras para agentes?
- Qual a diferença entre resource e tool na prática?

**Complementos**
- Vídeos: V09
- Artigos/docs: A02, A12

---

## Semana 15 — Segurança, governança e AI-ready layer com MCP

**Objetivos**
- Não expor MCP sem controle.
- Desenhar camada AI-ready corporativa.

**Conteúdos teóricos**
- Service tokens.
- Rate limiting.
- WAF e boundary de confiança.

**Leitura da semana**
- Docs: A13, A14, A15

**Prática aplicada**
- Adicionar autenticação para tools.
- Bloquear tools sensíveis sem aprovação humana.
- Criar política de allowlist de ações.

**Exercício estilo PR**
- **PR-015**: autenticação, rate limit e política mínima para o MCP server.

**Interview drill**
- Quais são os principais riscos ao expor ferramentas para agentes?
- Como limitar blast radius?

**Complementos**
- Vídeos: V16
- Artigos/docs: A13, A14, A15

---

## Semana 16 — Clients MCP, composição e experiência para agentes

**Objetivos**
- Testar o MCP server com clientes reais.
- Pensar composição de MCPs e qualidade de uso por agentes.

**Conteúdos teóricos**
- Descoberta de capabilities.
- Ergonomia de tool design.
- Composição de servidores MCP.

**Leitura da semana**
- Revisão: A04, A05, A12

**Prática aplicada**
- Testar o servidor com dois clientes diferentes.
- Melhorar descrições e contratos das tools.
- Documentar exemplos reais de uso.

**Exercício estilo PR**
- **PR-016**: refinamento de UX para agentes consumindo o MCP do projeto.

**Interview drill**
- Como você saberia se uma tool está mal desenhada?
- Que sinais mostram baixa “agent usability”?

**Complementos**
- Vídeos: V08, V09
- Artigos/docs: A04, A12

---

# Mês 5 — Arquitetura de agentes

## Semana 17 — Arquitetura de agentes

**Objetivos**
- Entender loop percepção → raciocínio → ação → feedback.
- Diferenciar workflow determinístico de agent loop.

**Conteúdos teóricos**
- Planner, executor, memory store, toolbox.
- Tipos de agentes.
- Escopo e autonomia.

**Leitura da semana**
- *AI Engineering* — revisar Ch. 6
- Artigos: A06

**Prática aplicada**
- Modelar o **Incident Investigator Agent**.
- Definir estados, entradas, ferramentas e saídas.

**Exercício estilo PR**
- **PR-017**: especificação arquitetural do primeiro agente do projeto.

**Interview drill**
- Quando usar agente e quando usar workflow?
- Como delimitar autonomia?

**Complementos**
- Vídeos: V08
- Artigos/docs: A06

---

## Semana 18 — ReAct, Plan-and-Execute e Reflection

**Objetivos**
- Comparar padrões de raciocínio e execução.
- Escolher padrões conforme custo, risco e previsibilidade.

**Conteúdos teóricos**
- ReAct.
- Plan-and-Execute.
- Reflection e self-correction.

**Leitura da semana**
- Artigos e docs do framework escolhido
- *AI Engineering* — revisar parte de agents

**Prática aplicada**
- Implementar duas versões do mesmo agente:
  - uma com ReAct
  - outra com Plan-and-Execute
- Comparar latência, custo e confiabilidade.

**Exercício estilo PR**
- **PR-018**: experimento comparativo entre padrões de agent execution.

**Interview drill**
- Qual padrão você escolheria para troubleshooting de produção e por quê?
- Como medir eficácia de um agente?

**Complementos**
- Vídeos: V08
- Artigos/docs: A06

---

## Semana 19 — Function calling e design de ferramentas

**Objetivos**
- Fazer agentes agirem com segurança por meio de contratos bem desenhados.

**Conteúdos teóricos**
- Tool use.
- JSON schema.
- Idempotência de ferramentas.

**Leitura da semana**
- Docs do provedor + MCP + framework

**Prática aplicada**
- Criar ferramentas idempotentes com input/output validados.
- Adicionar `dry-run` para ações críticas.

**Exercício estilo PR**
- **PR-019**: function calling robusto + contratos JSON + estratégias de fallback.

**Interview drill**
- O que torna uma tool segura para agent use?
- Como você evitaria chamadas repetidas ou perigosas?

**Complementos**
- Vídeos: V08
- Artigos/docs: A02, A04

---

## Semana 20 — Memória e gerenciamento de contexto

**Objetivos**
- Entender memória curta, longa, episódica e contextual.
- Evitar contexto inchado e caro.

**Conteúdos teóricos**
- Context pruning.
- Context stitching.
- Balanceamento entre memória local e global.

**Leitura da semana**
- *AI Engineering* — Ch. 10 (trechos sobre feedback e arquitetura)

**Prática aplicada**
- Implementar memória curta de sessão.
- Implementar memória persistente resumida por incidente.
- Criar heurística para podar contexto.

**Exercício estilo PR**
- **PR-020**: memória persistente + pruning + política de retenção contextual.

**Interview drill**
- Quando memória melhora e quando degrada um agente?
- Como evitar crescimento caótico de contexto?

**Complementos**
- Vídeos: V08, V14
- Artigos/docs: A10

---

# Mês 6 — LangGraph, observabilidade e multi-agent

## Semana 21 — LangGraph e workflows complexos

**Objetivos**
- Orquestrar grafos e não só cadeias lineares.
- Trabalhar fallback, retry e roteamento.

**Conteúdos teóricos**
- Estados de execução.
- Nós, arestas e dependências.
- Recovery e controle.

**Leitura da semana**
- Docs: A06

**Prática aplicada**
- Criar grafo do agente de incidentes com:
  - triagem
  - busca em documentação
  - análise de logs
  - síntese final

**Exercício estilo PR**
- **PR-021**: primeiro workflow em grafo com retries e handlers explícitos.

**Interview drill**
- Qual vantagem de um grafo sobre um pipeline linear?
- Como você depura um workflow multi-step?

**Complementos**
- Vídeos: V08
- Artigos/docs: A06

---

## Semana 22 — Observabilidade, auditoria e guardrails para agentes

**Objetivos**
- Medir execução de agentes com rastreabilidade real.
- Adicionar guardrails e human-in-the-loop.

**Conteúdos teóricos**
- Tracing de decisão.
- Audit trails.
- Approval gates e confidence thresholds.

**Leitura da semana**
- *Machine Learning Design Patterns* — Ch. 5 (pp. 201–248)
- *Machine Learning Design Patterns* — Ch. 7 (pp. 319–358)

**Prática aplicada**
- Logar cada decisão crítica do agente.
- Exigir aprovação humana para ações externas.
- Implementar score de confiança simples.

**Exercício estilo PR**
- **PR-022**: observabilidade e guardrails do agente com trilha de auditoria.

**Interview drill**
- Como você impediria runaway loops?
- O que precisa entrar numa trilha de auditoria útil?

**Complementos**
- Vídeos: V15, V16
- Artigos/docs: A10, A11, A15

---

## Semana 23 — Sprint do agente autônomo completo

**Objetivos**
- Consolidar agente completo com planejamento, execução e memória.

**Conteúdos teóricos**
- Métricas de autonomia, eficácia e resiliência.
- Escopo operacional.

**Leitura da semana**
- Revisão do Mês 5 e 6

**Prática aplicada**
- Entregar a primeira versão completa do **Incident Investigator Agent**.

**Exercício estilo PR**
- **PR-023**: entrega do agente autônomo v1 com demo, métricas e limitações documentadas.

**Interview drill**
- Quais métricas definem sucesso de um agente?
- O que você faria para colocá-lo em produção com segurança?

**Complementos**
- Vídeos: V08, V14
- Artigos/docs: A06, A10

---

## Semana 24 — Sistemas multiagentes

**Objetivos**
- Entender quando decompor um problema em múltiplos agentes.
- Evitar multi-agent por hype.

**Conteúdos teóricos**
- Supervisor, Hierarchical, Delegation, Consensus.
- Coordenação e troca assíncrona de mensagens.

**Leitura da semana**
- Ementa multi-agent + revisão de arquitetura AI-first

**Prática aplicada**
- Criar mini sistema com 3 agentes:
  - Analista
  - Planejador
  - Executor

**Exercício estilo PR**
- **PR-024**: mini sistema multiagente com justificativa de por que ele é melhor que um único agente no caso escolhido.

**Interview drill**
- Quando multi-agent é útil e quando só aumenta complexidade?
- Quais falhas distribuídas aparecem entre agentes?

**Complementos**
- Vídeos: V08
- Artigos/docs: A06

---

# Mês 7 — UX/UI, coding agents e integração cliente-servidor

## Semana 25 — AI-driven UX/UI e prototipação

**Objetivos**
- Entender a camada de experiência em produtos AI-first.

**Conteúdos teóricos**
- Fluxos conversacionais.
- Text-to-UI.
- Validação com usabilidade assistida por IA.

**Leitura da semana**
- Ementa UX/UI

**Prática aplicada**
- Desenhar wireframes do EngOps Copilot.
- Definir estados de loading, confidence e approval.

**Exercício estilo PR**
- **PR-025**: protótipo da interface e ADR de UX para agentes/assistentes.

**Interview drill**
- Como UX muda quando o sistema é probabilístico?
- O que o usuário precisa ver para confiar na IA?

**Complementos**
- Vídeos: V09, V12
- Artigos/docs: A16

---

## Semana 26 — Coding agents, CLI e fluxo do desenvolvedor

**Objetivos**
- Aprender a encaixar agentes no workflow do dev sem terceirizar pensamento.

**Conteúdos teóricos**
- Agentes de codificação.
- Regras, contexto e limites.
- Uso responsável em revisão e scaffolding.

**Leitura da semana**
- Revisão sobre ferramentas para devs

**Prática aplicada**
- Criar uma CLI interna para operações do projeto.
- Usar IA para gerar testes, mas validar tudo manualmente.

**Exercício estilo PR**
- **PR-026**: CLI de apoio + convenções de uso seguro de coding agents no projeto.

**Interview drill**
- Onde IA realmente acelera o desenvolvimento?
- Onde ela costuma introduzir dívida técnica?

**Complementos**
- Vídeos: V09, V14
- Artigos/docs: A16

---

## Semana 27 — UI inteligente com MCP e automação E2E

**Objetivos**
- Expor capabilities do sistema de forma que agentes interajam com a UI.

**Conteúdos teóricos**
- UI + MCP.
- E2E assistido por agentes.
- Depuração de contexto exposto.

**Leitura da semana**
- Revisão de MCP

**Prática aplicada**
- Conectar UI ao backend e ao MCP.
- Criar fluxo de teste E2E com agente para tarefa simples.

**Exercício estilo PR**
- **PR-027**: UI inicial integrada ao backend e com fluxo programático via MCP.

**Interview drill**
- Qual risco existe ao deixar agente interagir com UI?
- Quando isso é melhor do que chamar a API diretamente?

**Complementos**
- Vídeos: V08, V09
- Artigos/docs: A02, A12

---

## Semana 28 — Features inteligentes no cliente e no servidor

**Objetivos**
- Decidir o que fica no cliente e o que fica no backend.

**Conteúdos teóricos**
- Segurança de chamadas client-side.
- Busca semântica e personalização.
- Orquestração no servidor.

**Leitura da semana**
- Revisão geral do Mês 7

**Prática aplicada**
- Criar feature de busca semântica e resumo assistido na UI.
- Manter todas as chamadas críticas no backend.

**Exercício estilo PR**
- **PR-028**: feature inteligente visível ao usuário com responsabilidades bem separadas entre cliente e servidor.

**Interview drill**
- O que jamais deveria ir direto do front-end para um provedor de IA?
- Como proteger segredo, custo e governança?

**Complementos**
- Vídeos: V12
- Artigos/docs: A01

---

# Mês 8 — IA para DevOps: fundamentos, IaC e Kubernetes

## Semana 29 — IA generativa para infraestrutura e runbooks

**Objetivos**
- Levar IA para o domínio DevOps com responsabilidade.

**Conteúdos teóricos**
- RAG para documentação técnica.
- Prompting para troubleshooting.
- Limites e validação.

**Leitura da semana**
- *Designing Machine Learning Systems* — Ch. 3 e Ch. 4 (seleções)

**Prática aplicada**
- Ingerir runbooks técnicos no RAG.
- Criar skill de consulta operacional segura.

**Exercício estilo PR**
- **PR-029**: base de conhecimento operacional no EngOps Copilot.

**Interview drill**
- O que muda entre um RAG de conteúdo genérico e um RAG de runbooks?
- Como evitar recomendações perigosas?

**Complementos**
- Vídeos: V11, V16
- Artigos/docs: A15

---

## Semana 30 — IaC Copilot, OPA e revisão PR-first

**Objetivos**
- Criar pipeline de revisão de infraestrutura com IA e políticas.

**Conteúdos teóricos**
- NL → IaC.
- Policy-as-Code.
- Drift e validação automatizada.

**Leitura da semana**
- *Machine Learning Design Patterns* — Ch. 6 (pp. 249–318)

**Prática aplicada**
- Gerar módulo simples de Terraform via prompt.
- Validar com checks automáticos.
- Aplicar política OPA mínima.

**Exercício estilo PR**
- **PR-030**: protótipo de IaC Copilot com validação e policy checks.

**Interview drill**
- Como impedir que IA gere infra insegura?
- Qual o papel de policy-as-code nesse fluxo?

**Complementos**
- Vídeos: V16
- Artigos/docs: A13

---

## Semana 31 — Agentes para Kubernetes, HPA/VPA e rollout

**Objetivos**
- Aplicar IA no ciclo de deploy/operação em K8s sem abrir mão de controle.

**Conteúdos teóricos**
- YAML generation.
- HPA/VPA.
- Canary, blue-green, GitOps.

**Leitura da semana**
- Docs Kubernetes HPA

**Prática aplicada**
- Criar agente que sugere manifest e HPA.
- Adicionar `dry-run` e checklist de readiness.

**Exercício estilo PR**
- **PR-031**: agente para deployment assistido com validação de readiness.

**Interview drill**
- Como IA pode ajudar sem tomar conta do deploy?
- Quais guardrails são obrigatórios?

**Complementos**
- Vídeos: V10
- Artigos/docs: Kubernetes HPA official docs

---

## Semana 32 — Troubleshooting assistido com logs, traces e métricas

**Objetivos**
- Estruturar troubleshooting assistido por IA com dados observáveis.

**Conteúdos teóricos**
- ReAct para troubleshooting.
- Correlação de logs, traces e métricas.
- RCA guiada.

**Leitura da semana**
- *Designing Machine Learning Systems* — Ch. 8 e Ch. 9 (seleções)

**Prática aplicada**
- Permitir ao agente consultar logs e métricas mockadas.
- Gerar hipótese de causa raiz e plano de investigação.

**Exercício estilo PR**
- **PR-032**: fluxo assistido de troubleshooting com explicação rastreável.

**Interview drill**
- Como IA pode errar numa RCA?
- Como forçar evidência antes de concluir causa raiz?

**Complementos**
- Vídeos: V11, V15
- Artigos/docs: A10, A11

---

# Mês 9 — AIOps, ChatOps, segurança e custos

## Semana 33 — AIOps, anomalias e dashboards inteligentes

**Objetivos**
- Adicionar camada de detecção e leitura inteligente de sinais operacionais.

**Conteúdos teóricos**
- Anomalia vs ruído.
- Forecasting.
- Redução de falso positivo.

**Leitura da semana**
- *Machine Learning Design Patterns* — Ch. 5 (releitura)

**Prática aplicada**
- Criar dashboard operacional do projeto.
- Adicionar pipeline simples de detecção de anomalias em métrica sintética.

**Exercício estilo PR**
- **PR-033**: dashboard inteligente + alerta contextualizado.

**Interview drill**
- Como você evitaria alert fatigue?
- O que um alerta inteligente precisa incluir?

**Complementos**
- Vídeos: V11
- Artigos/docs: A10, A11

---

## Semana 34 — ChatOps, RBAC, auditoria e aprovação humana

**Objetivos**
- Construir automação operacional com aprovação humana para ações críticas.

**Conteúdos teóricos**
- ChatOps architecture.
- RBAC.
- Auditability.

**Leitura da semana**
- Revisão de governança e guardrails

**Prática aplicada**
- Criar fluxo `/investigar` e `/sugerir-mitigacao`.
- Não executar mudanças automáticas sem approval gate.

**Exercício estilo PR**
- **PR-034**: bot de ChatOps com fluxo de aprovação e trilha de auditoria.

**Interview drill**
- Como implementar human-in-the-loop de verdade?
- Que ações podem ser automáticas e quais não?

**Complementos**
- Vídeos: V16
- Artigos/docs: A13, A14

---

## Semana 35 — Segurança e compliance em IA aplicada

**Objetivos**
- Tratar IA como superfície de risco real.

**Conteúdos teóricos**
- Prompt injection.
- Vazamento de dados e secrets.
- OWASP LLM Top 10.
- AI risk management.

**Leitura da semana**
- *Machine Learning Design Patterns* — Ch. 7

**Prática aplicada**
- Criar checklist de segurança do projeto.
- Adicionar filtros e validações para entradas sensíveis.
- Revisar logs para remover informação sigilosa.

**Exercício estilo PR**
- **PR-035**: hardening inicial do sistema com foco em segurança para IA.

**Interview drill**
- O que é prompt injection e como se defender em camadas?
- Como separar contexto confiável e não confiável?

**Complementos**
- Vídeos: V16
- Artigos/docs: A14, A15

---

## Semana 36 — CI/CD Copilot, FinOps e otimização de custo

**Objetivos**
- Controlar custo operacional e de desenvolvimento da plataforma de IA.

**Conteúdos teóricos**
- Custo por tenant/feature.
- Model routing.
- Pipeline inteligente e rollback.

**Leitura da semana**
- *AI Engineering* — Ch. 9 (pp. 405–447)

**Prática aplicada**
- Criar painel de custo por endpoint.
- Simular troca de modelo conforme criticidade/custo.
- Definir estratégia de fallback para modelos mais baratos.

**Exercício estilo PR**
- **PR-036**: model tiering + relatório de custo e latência.

**Interview drill**
- Como você controlaria custo num SaaS multi-tenant com IA?
- Quando vale usar roteamento entre modelos?

**Complementos**
- Vídeos: V14
- Artigos/docs: A07

---

# Mês 10 — Gestão com IA + Arquitetura AI-First

## Semana 37 — Requirements Copilot, backlog e priorização com IA

**Objetivos**
- Aplicar IA ao planejamento sem terceirizar a tomada de decisão.

**Conteúdos teóricos**
- NL → épicos, histórias e critérios de aceite.
- RICE, WSJF, MoSCoW com suporte de IA.

**Leitura da semana**
- Ementa Gestão de Projetos com IA

**Prática aplicada**
- Criar backlog formal do capstone final.
- Usar IA para gerar histórias, depois refinar manualmente.

**Exercício estilo PR**
- **PR-037**: backlog estruturado do capstone com critérios de aceite e priorização.

**Interview drill**
- Onde IA ajuda na gestão e onde ela atrapalha?
- Como evitar backlog bonito e inútil?

**Complementos**
- Vídeos: V14
- Artigos/docs: A14

---

## Semana 38 — Estimativas, riscos, status e automação de gestão

**Objetivos**
- Unir execução técnica e gestão baseada em evidência.

**Conteúdos teóricos**
- Previsão, risco, capacidade e reports.
- Resumos executivos e rastreabilidade.

**Leitura da semana**
- Revisão da ementa de gestão

**Prática aplicada**
- Criar template de weekly status do projeto.
- Gerar report técnico e executivo a partir de dados reais do repositório.

**Exercício estilo PR**
- **PR-038**: automação de status report e relatório de riscos do capstone.

**Interview drill**
- Como comunicar risco técnico para gestores?
- Quais métricas importam para defender cronograma de um projeto de IA?

**Complementos**
- Vídeos: V14
- Artigos/docs: A14

---

## Semana 39 — Fundamentos de arquitetura AI-First

**Objetivos**
- Estruturar pensamento arquitetural específico para IA.

**Conteúdos teóricos**
- AI-driven vs sistemas tradicionais.
- Framework de decisão: regras vs IA.
- Trade-offs entre latência, custo, precisão e UX.

**Leitura da semana**
- *AI Engineering* — Ch. 10 (restante)
- *Fundamentals of Software Architecture* — capítulos de trade-offs (opcional)

**Prática aplicada**
- Escrever arquitetura alvo do EngOps Copilot v2.
- Mapear componentes: gateway, orchestration, retrieval, model router, observability.

**Exercício estilo PR**
- **PR-039**: documento de arquitetura AI-First com decisões e trade-offs explícitos.

**Interview drill**
- Como saber se uma feature deve ser IA ou regra tradicional?
- Qual o custo de complexidade de uma arquitetura AI-first?

**Complementos**
- Vídeos: V14
- Artigos/docs: A16

---

## Semana 40 — Arquitetura enterprise: router, gateway, caches, HITL e plataforma

**Objetivos**
- Pensar em operação enterprise de sistemas de IA.

**Conteúdos teóricos**
- API gateway.
- Model router.
- Semantic cache / prompt cache.
- Approval gates e audit trails.

**Leitura da semana**
- *Machine Learning Design Patterns* — Ch. 8 (pp. 359 em diante)

**Prática aplicada**
- Adicionar model router simples.
- Adicionar cache semântico experimental.
- Modelar camada compartilhada de serviços de IA.

**Exercício estilo PR**
- **PR-040**: arquitetura enterprise simplificada da plataforma do projeto.

**Interview drill**
- Como você montaria a plataforma interna de IA de uma empresa?
- O que entra na camada compartilhada?

**Complementos**
- Vídeos: V14, V15
- Artigos/docs: A01, A03, A10

---

# Mês 11 — Dados, fine-tuning e governança

## Semana 41 — Dataset engineering

**Objetivos**
- Entender que qualidade de dado governa qualidade de sistema.

**Conteúdos teóricos**
- Coleta, limpeza, diversidade, balanceamento.
- JSONL e formatos de fine-tuning.
- Versionamento de datasets.

**Leitura da semana**
- *AI Engineering* — Ch. 8 (pp. 363–403)
- *Designing Machine Learning Systems* — Ch. 3 e Ch. 4 (revisão)

**Prática aplicada**
- Montar dataset de domínio do projeto.
- Criar pipeline de limpeza e normalização.
- Versionar dataset com README e rubric.

**Exercício estilo PR**
- **PR-041**: dataset v1 + pipeline de preparação + documentação de qualidade.

**Interview drill**
- O que define um bom dataset para fine-tuning?
- Como você evita lixo caro em treinamento?

**Complementos**
- Vídeos: V13
- Artigos/docs: A08, A09

---

## Semana 42 — Decision framework para fine-tuning e SFT via API

**Objetivos**
- Saber quando fine-tuning faz sentido.
- Comparar prompt-only, RAG e fine-tuning com critério.

**Conteúdos teóricos**
- Quando fine-tuning ajuda.
- Quando RAG basta.
- SFT via API.

**Leitura da semana**
- *AI Engineering* — Ch. 7 (pp. 307–361)
- Docs: A07, A08, A09

**Prática aplicada**
- Escolher uma tarefa do projeto para experimento de fine-tuning.
- Preparar dataset mínimo e pipeline de upload/treino.

**Exercício estilo PR**
- **PR-042**: framework decisório documentado + experimento inicial de SFT.

**Interview drill**
- Quando usar RAG vs fine-tuning?
- Quais sinais mostram que prompt engineering chegou no limite?

**Complementos**
- Vídeos: V13
- Artigos/docs: A07, A08, A09

---

## Semana 43 — PEFT, LoRA, avaliação e red-teaming

**Objetivos**
- Entender fine-tuning eficiente e avaliação séria do modelo ajustado.

**Conteúdos teóricos**
- LoRA, PEFT.
- A/B test entre modelo base e ajustado.
- Overfitting, regressão e segurança.

**Leitura da semana**
- *Hands-On LLMs* — Ch. 11 e Ch. 12

**Prática aplicada**
- Rodar experimento pequeno de avaliação comparativa.
- Definir battery de testes adversariais.

**Exercício estilo PR**
- **PR-043**: comparação modelo base vs ajustado + relatório de ganhos e perdas.

**Interview drill**
- Como provar que o fine-tuning melhorou algo relevante?
- Quais riscos de perda de generalização?

**Complementos**
- Vídeos: V13
- Artigos/docs: A09

---

## Semana 44 — Governança, interpretabilidade, vieses e custos

**Objetivos**
- Fechar a trilha técnica com governança madura.

**Conteúdos teóricos**
- AI governance.
- Interpretabilidade e explicabilidade.
- Risco legal, humano, operacional e financeiro.

**Leitura da semana**
- *Machine Learning Design Patterns* — Ch. 7 (revisão)

**Prática aplicada**
- Criar documento de governança do projeto:
  - uso permitido
  - limites
  - monitoramento
  - resposta a incidentes
  - retenção de dados

**Exercício estilo PR**
- **PR-044**: política mínima de governança e segurança do EngOps Copilot.

**Interview drill**
- O que é governança em IA na prática?
- Como você trataria viés e explicabilidade num sistema corporativo?

**Complementos**
- Vídeos: V16
- Artigos/docs: A14, A15

---

# Mês 12 — Capstone, portfólio e entrevistas

## Semana 45 — Capstone: ideação, escopo e arquitetura final

**Objetivos**
- Consolidar tudo em um sistema coerente e demonstrável.

**Conteúdos teóricos**
- Escopo viável.
- Storytelling técnico.
- Arquitetura para demonstração e defesa.

**Leitura da semana**
- Revisão geral da trilha

**Prática aplicada**
- Definir backlog final.
- Congelar escopo do capstone.
- Preparar diagrama final de arquitetura.

**Exercício estilo PR**
- **PR-045**: kickoff formal do capstone com milestones e arquitetura final.

**Interview drill**
- Como você venderia o valor do sistema em 3 minutos?
- Como justificaria o recorte escolhido?

**Complementos**
- Vídeos: V14
- Artigos/docs: A16

---

## Semana 46 — Capstone: MVP funcional

**Objetivos**
- Entregar o núcleo funcional integrado.

**Conteúdos teóricos**
- Integração entre RAG, agent, API, UI e MCP.

**Prática aplicada**
- Entregar:
  - backend documentado
  - RAG funcional
  - agente principal
  - MCP habilitado
  - UI consumindo a API

**Exercício estilo PR**
- **PR-046**: MVP funcional do capstone.

**Interview drill**
- Quais foram os maiores trade-offs do MVP?
- O que ficou de fora e por quê?

**Complementos**
- Vídeos: V08, V09
- Artigos/docs: A01, A02, A03

---

## Semana 47 — Capstone: hardening, deploy e defesa técnica

**Objetivos**
- Preparar o sistema para demonstração séria e defesa arquitetural.

**Conteúdos teóricos**
- CI/CD.
- Observabilidade.
- Custos e segurança mínimos para produção simulada.

**Prática aplicada**
- Subir ambiente demonstrável.
- Adicionar dashboards, logs, README, instruções e screenshots.
- Gravar ou ensaiar demo ao vivo.

**Exercício estilo PR**
- **PR-047**: release candidate do capstone com documentação completa.

**Interview drill**
- Como você explicaria esta arquitetura para um staff engineer?
- Quais partes você escalaria primeiro?

**Complementos**
- Vídeos: V11, V15
- Artigos/docs: A10, A11

---

## Semana 48 — Carreira, portfólio e entrevistas de Engenharia de IA

**Objetivos**
- Transformar a trilha em vantagem de mercado.

**Conteúdos teóricos**
- Portfólio técnico.
- LinkedIn e storytelling de projeto.
- Perguntas de system design para IA.

**Prática aplicada**
- Atualizar GitHub e README final.
- Criar documento “How I built this”.
- Preparar respostas STAR e pitch profissional.

**Exercício estilo PR**
- **PR-048**: versão pública do portfólio técnico do capstone.

**Interview drill**
- RAG vs fine-tuning?
- Quando usar agents?
- Como controlar custo e falhas?
- Como explicar decisões técnicas para públicos diferentes?

**Complementos**
- Vídeos: V14
- Artigos/docs: A14, A15

---

# 8. Perguntas de entrevista para praticar ao longo do ano

## Fundamentos
- O que diferencia IA aplicada de automação tradicional?
- O que é embedding e por que ele importa?
- O que é attention em alto nível?

## Prompting e avaliação
- Como você mede qualidade em aplicações com LLM?
- Como reduzir alucinação sem treinar modelo novo?
- Como projetar saídas previsíveis?

## RAG
- Quando RAG é melhor que fine-tuning?
- Como você melhoraria recall sem sacrificar muito custo?
- Como depurar um RAG ruim?

## Agents
- Quando usar agente e quando usar workflow determinístico?
- Como limitar autonomia?
- Como desenhar tools seguras?

## MCP
- O que é MCP e por que ele é relevante?
- Como organizar tools/resources/prompts?
- Como proteger um MCP server?

## Arquitetura
- Como montar uma plataforma interna de IA?
- Como controlar custo, latência e observabilidade?
- Como separar capabilities compartilhadas de features de produto?

## Fine-tuning e dados
- Quando o fine-tuning realmente compensa?
- O que faz um dataset ser bom?
- Como comparar modelo base vs ajustado?

## Segurança e governança
- O que é prompt injection?
- Como implementar AI governance mínima?
- Como tratar auditoria e trilha de decisão?

---

# 9. Sistema de revisão mensal

No fim de cada mês, responda:

- [ ] O que eu consigo explicar sem cola?
- [ ] O que eu implementei de verdade?
- [ ] O que ainda está superficial?
- [ ] Quais decisões arquiteturais eu consigo defender?
- [ ] Onde meu projeto ficou frágil?
- [ ] O que precisa entrar no mês seguinte como reforço?

---

# 10. Checklist de maturidade ao final da trilha

## Fundamentos
- [ ] Entendo IA aplicada além do hype
- [ ] Consigo explicar embeddings, RAG e fine-tuning com clareza
- [ ] Sei diferenciar workflow determinístico de agent loop

## Backend e plataforma
- [ ] Sei integrar modelos a APIs Java/Spring
- [ ] Sei projetar logs, métricas e tracing para IA
- [ ] Sei organizar módulos e contratos para reduzir acoplamento

## RAG
- [ ] Sei implementar ingestão, chunking, retrieval e avaliação
- [ ] Sei usar busca híbrida, filtros e reranking
- [ ] Sei diagnosticar falhas de groundedness

## MCP
- [ ] Sei explicar MCP para outra pessoa
- [ ] Sei expor tools/resources com segurança
- [ ] Sei integrar backend e agentes via MCP

## Agents
- [ ] Sei modelar ReAct, Plan-and-Execute e Reflection
- [ ] Sei limitar autonomia com guardrails
- [ ] Sei projetar um agente com memória e auditoria

## DevOps / AIOps
- [ ] Sei usar IA em troubleshooting com responsabilidade
- [ ] Sei desenhar ChatOps com aprovação humana
- [ ] Sei discutir policy-as-code, observabilidade e rollback

## Fine-tuning e dados
- [ ] Sei decidir quando fine-tuning faz sentido
- [ ] Sei preparar dataset e avaliar modelo ajustado
- [ ] Sei discutir LoRA/PEFT em nível prático

## Segurança e governança
- [ ] Conheço riscos centrais de aplicações com LLM
- [ ] Tenho uma política mínima de segurança e governança
- [ ] Sei discutir audit trail, conformidade e custo

## Capstone e carreira
- [ ] Tenho projeto demonstrável e bem documentado
- [ ] Tenho README, diagrama e demo claros
- [ ] Consigo defender arquitetura e trade-offs em entrevista

---

# 11. Resultado esperado

Se você seguir esta trilha com disciplina, ao final do ano você deixa de ser apenas alguém que **usa ferramentas de IA** e passa a atuar como alguém que **projeta, integra, mede, opera e governa sistemas de IA**.

O ganho principal não será só “saber usar LLM”.
Será saber responder, com maturidade:

- **quando usar IA**;
- **quando não usar**;
- **como colocá-la em produção**;
- **como medir se ela funciona**;
- **como impedir que ela vire risco operacional**.

Esse é o tipo de repertório que realmente aproxima você de um nível **pleno/sênior em Engenharia de IA Aplicada**.
