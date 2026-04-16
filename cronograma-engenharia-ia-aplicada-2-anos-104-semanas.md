# Cronograma de 2 Anos — Engenharia de IA Aplicada (104 semanas)

> Formato pensado para **Obsidian**.
>
> Foco principal: **engenharia de IA aplicada em produção**, com **Java 21 + Spring Boot + Spring AI** no backend.
>
> Linguagens auxiliares:
> - **TypeScript/JavaScript** para MCP, front-end e automações onde fizer sentido
> - **Python** apenas quando o ecossistema for claramente dominante (evals, notebooks, LoRA/PEFT, experimentos)
>
> **Objetivo final:** sair da trilha com repertório para **projetar, implementar, operar e defender sistemas de IA em produção**, incluindo RAG, agents, MCP, multimodalidade, observabilidade, fine-tuning, governança e preparação para entrevistas.

---

## Como este plano foi desenhado

Este plano foi refeito do zero para ficar **sustentável ao longo de 2 anos**, sem concentrar leitura demais em poucas semanas.

### Ritmo semanal sugerido

- **Segunda a sexta:** leitura + laboratório curto
- **Sábado:** bloco de implementação mais profundo
- **Domingo:** revisão leve / descanso / organização do Obsidian

### Carga semanal sugerida

- **8 a 12 horas por semana**
- Distribuição média:
  - **3h a 4h** leitura
  - **3h a 5h** prática aplicada
  - **1h a 2h** exercício estilo PR + ADR
  - **30 a 60 min** drill de entrevista

### Como ler “páginas por dia”

1. **Livros**: as faixas abaixo foram planejadas para as edições listadas na bibliografia.
2. **Documentação online**: quando a semana pedir docs, trate a leitura como **equivalente de 6–10 páginas densas**.
3. **Ranges aproximados**: em especial para alguns capítulos de *Hands-On Large Language Models* e para trechos online, as páginas são **estimadas** para manter um ritmo saudável. Pequenas diferenças de edição não quebram o plano.

### Regra de ouro de cada semana

Toda semana deve terminar com:

- [ ] 1 incremento real no projeto `SignalDesk AI`
- [ ] 1 nota técnica no Obsidian
- [ ] 1 mini ADR ou decisão registrada
- [ ] 1 exercício estilo PR
- [ ] 1 rodada curta de perguntas de entrevista

---

## Projeto contínuo da trilha — `SignalDesk AI`

Ao longo das 104 semanas você vai evoluir um **micro-SaaS AI-first** com estes blocos:

1. **Knowledge Hub / RAG**
   - ingestão de documentos
   - chunking
   - embeddings
   - busca semântica
   - respostas com grounding

2. **Agent Layer**
   - tools
   - planning
   - execution
   - memory
   - guardrails
   - human-in-the-loop

3. **MCP Layer**
   - tools, resources e prompts
   - UI-ready / AI-ready interfaces
   - clientes e servidores MCP

4. **Multimodal Layer**
   - OCR / documentos
   - áudio / transcrição
   - visão / screenshots / imagens

5. **Ops Layer**
   - observabilidade
   - evals
   - custo por request
   - CI/CD
   - ChatOps
   - automações seguras

6. **Governance Layer**
   - segurança para LLMs
   - trilhas de auditoria
   - política de uso
   - critérios de aprovação
   - documentação e defesa técnica

---

## Bibliografia-base

### Livros principais
1. **AI Engineering** — Chip Huyen  
2. **Hands-On Large Language Models** — Jay Alammar, Maarten Grootendorst  
3. **Designing Machine Learning Systems** — Chip Huyen  
4. **Machine Learning Design Patterns** — Valliappa Lakshmanan, Sara Robinson, Michael Munn  

### Documentação-base
- Spring AI
- Spring AI MCP
- MCP Specification
- LangGraph
- OpenAI evals / fine-tuning / optimization
- OpenTelemetry
- Ollama
- NIST AI RMF
- OWASP Top 10 for LLM Applications

---

## Mapa das 8 fases (2 anos)

### Ano 1
- **Q1 (Semanas 1–13):** Fundamentos, LLMs, setup, primeiros endpoints
- **Q2 (Semanas 14–26):** Prompt engineering, APIs, evals básicos, RAG inicial
- **Q3 (Semanas 27–39):** RAG avançado + observabilidade + MCP
- **Q4 (Semanas 40–52):** Agents, LangGraph, context engineering, multi-agent

### Ano 2
- **Q5 (Semanas 53–65):** Multimodalidade e UX/UI com IA
- **Q6 (Semanas 66–78):** DevOps com IA, IaC, Kubernetes, AIOps
- **Q7 (Semanas 79–91):** Gestão, arquitetura AI-first, roteamento, enterprise design
- **Q8 (Semanas 92–104):** Fine-tuning, governança, capstone, entrevistas

---

## Convenções dos exercícios estilo PR

Use sempre este molde:

```md
## Contexto
## Problema
## Hipóteses consideradas
## Decisão adotada
## Trade-offs
## Evidências / testes / métricas
## Riscos remanescentes
## Plano de rollback
## Próximos passos
```

---

## Plano semanal detalhado
## Visão dos módulos
| Módulo | Semanas | Resultado-chave |
|---|---:|---|
| Módulo 1 — Fundamentos de IA, ML e LLMs para Programadores | 1–8 | Basear o projeto contínuo `SignalDesk AI`: um micro-SaaS de conhecimento + copiloto operacional com backend em Java/Spring AI. |
| Módulo 2 — APIs de IA Generativa, Prompt Engineering e Evals Básicos | 9–16 | Transformar o backend em uma camada de APIs generativas previsíveis, testáveis e com custo monitorado. |
| Módulo 3 — RAG, Embeddings e Busca Semântica (Fundamentos) | 17–24 | Construir o núcleo do conhecimento do produto: ingestão, indexação e busca semântica confiável. |
| Módulo 4 — RAG Avançado, Evals e Observabilidade | 25–32 | Sair do RAG demonstrável para o RAG operável: com métricas, testes e critérios de qualidade. |
| Módulo 5 — MCP: Model Context Protocol do Conceito à Produção | 33–40 | Tornar a plataforma AI-ready, com integração padronizada entre host, backend, ferramentas e contexto. |
| Módulo 6 — Agents: Arquitetura, ReAct, Tool Use e Function Calling | 41–48 | Sair de fluxos lineares e entrar em workflows agentic controlados e rastreáveis. |
| Módulo 7 — Contexto, LangGraph, Human-in-the-Loop e Multi-Agent Systems | 49–56 | Construir orquestração stateful com autonomia limitada, aprovação humana e comunicação entre agentes. |
| Módulo 8 — Multimodalidade, UX/UI com IA e Experiência do Usuário | 57–64 | Levar o produto para além do chat textual, conectando IA à experiência real do usuário. |
| Módulo 9 — Ferramentas de IA para DevOps: IaC, Kubernetes e Troubleshooting | 65–72 | Acoplar IA à operação sem abrir mão de validação, reversibilidade e observabilidade. |
| Módulo 10 — AIOps, ChatOps, Segurança, CI/CD e FinOps | 73–80 | Fechar o ciclo operacional: medir, alertar, aprovar, agir e comprovar resultado. |
| Módulo 11 — IA para Gestão de Projetos, Processos e Governança Operacional | 81–88 | Mostrar que engenharia de IA também precisa melhorar processo, rastreabilidade e comunicação. |
| Módulo 12 — Arquitetura AI-First, Fine-Tuning e Dados para Modelos | 89–96 | Conectar arquitetura, dados e tuning sem perder custo, segurança e capacidade de operação. |
| Módulo 13 — Segurança, Governança, Capstone e Entrevistas | 97–104 | Fechar a trilha com um artefato real de mercado: arquitetura defendível, demo, documentação e narrativa profissional. |

---

# Módulo 1 — Fundamentos de IA, ML e LLMs para Programadores

**Resultado do módulo:** Basear o projeto contínuo `SignalDesk AI`: um micro-SaaS de conhecimento + copiloto operacional com backend em Java/Spring AI.

## Semana 001 — História da IA, escopo da trilha e setup do ambiente

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **história da ia, escopo da trilha e setup do ambiente**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 1, pp. 1–5
- **Dia 2:** AI Engineering — Cap. 1, pp. 6–10
- **Dia 3:** AI Engineering — Cap. 1, pp. 11–15
- **Dia 4:** AI Engineering — Cap. 1, pp. 16–20
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Introduction e conceitos centrais** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar o repositório `signaldesk-ai` com backend Spring Boot, Docker Compose e uma pasta `notes/` para ADRs.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): historia-da-ia-escopo-da-trilha-e-setup-do-ambient`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `História da IA, escopo da trilha e setup do ambiente` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Repo base versionado, README inicial e ambiente local subindo.

---
## Semana 002 — ML, DL, LLMs e o papel da engenharia de IA

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **ml, dl, llms e o papel da engenharia de ia**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 1, pp. 21–25
- **Dia 2:** AI Engineering — Cap. 1, pp. 26–30
- **Dia 3:** AI Engineering — Cap. 1, pp. 31–35
- **Dia 4:** AI Engineering — Cap. 1, pp. 36–40
- **Dia 5:** documentação / revisão guiada — **Ollama — Quickstart e API Introduction** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Escrever um ADR curto comparando software tradicional, ML clássico e apps com LLM.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): ml-dl-llms-e-o-papel-da-engenharia-de-ia`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `ML, DL, LLMs e o papel da engenharia de IA` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- ADR-001 com escopo e critérios de sucesso.

---
## Semana 003 — Vetores, embeddings, tokens e representações

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **vetores, embeddings, tokens e representações**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 1, pp. 41–45
- **Dia 2:** AI Engineering — Cap. 1, pp. 46–48 + Hands-On LLMs — Cap. 1, pp. 1–2
- **Dia 3:** Hands-On LLMs — Cap. 1, pp. 3–7
- **Dia 4:** Hands-On LLMs — Cap. 1, pp. 8–12
- **Dia 5:** documentação / revisão guiada — **OpenAI Academy — Prompting fundamentals (visão geral para iniciantes)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar um endpoint `/embeddings/preview` que recebe texto e retorna metadados básicos.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): vetores-embeddings-tokens-e-representacoes`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Vetores, embeddings, tokens e representações` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Primeiro endpoint de IA no backend.

---
## Semana 004 — Transformers e attention sem glamour desnecessário

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **transformers e attention sem glamour desnecessário**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 1, pp. 13–17
- **Dia 2:** Hands-On LLMs — Cap. 1, pp. 18–22
- **Dia 3:** Hands-On LLMs — Cap. 1, pp. 23–27
- **Dia 4:** Hands-On LLMs — Cap. 1, pp. 28–32
- **Dia 5:** documentação / revisão guiada — **Anthropic Docs — Prompt engineering overview (leitura panorâmica)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Desenhar um diagrama de sequência explicando prompt → tokenização → inferência → resposta.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): transformers-e-attention-sem-glamour-desnecessario`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Transformers e attention sem glamour desnecessário` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Diagrama versionado no repositório.

---
## Semana 005 — Spring AI por dentro: abstrações, modelos e portabilidade

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **spring ai por dentro: abstrações, modelos e portabilidade**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 1, pp. 33–37
- **Dia 2:** Hands-On LLMs — Cap. 1, pp. 38–42
- **Dia 3:** Hands-On LLMs — Cap. 1, pp. 43–47
- **Dia 4:** Hands-On LLMs — Cap. 1, p. 48 + Designing Machine Learning Systems — Cap. 1, pp. 1–4
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Introduction e conceitos centrais** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Integrar um provider simples via Spring AI e criar `/chat/ping` com resposta determinística.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): spring-ai-por-dentro-abstracoes-modelos-e-portabil`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Spring AI por dentro: abstrações, modelos e portabilidade` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Chat endpoint mínimo funcionando.

---
## Semana 006 — Modelos locais com Ollama e comparação com API remota

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **modelos locais com ollama e comparação com api remota**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 1, pp. 5–8
- **Dia 2:** Designing Machine Learning Systems — Cap. 1, pp. 9–12
- **Dia 3:** Designing Machine Learning Systems — Cap. 1, pp. 13–16
- **Dia 4:** Designing Machine Learning Systems — Cap. 1, pp. 17–20
- **Dia 5:** documentação / revisão guiada — **Ollama — Quickstart e API Introduction** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Subir Ollama localmente e criar uma estratégia de seleção entre modelo local e remoto.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): modelos-locais-com-ollama-e-comparacao-com-api-rem`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Modelos locais com Ollama e comparação com API remota` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- `ModelRouter` inicial com configuração por profile.

---
## Semana 007 — Primeira IA do zero: ciclo dados → treino → validação → inferência

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **primeira ia do zero: ciclo dados → treino → validação → inferência**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 1, pp. 21–24
- **Dia 2:** Designing Machine Learning Systems — Cap. 1, pp. 25–28
- **Dia 3:** Designing Machine Learning Systems — Cap. 1, pp. 29–32
- **Dia 4:** Designing Machine Learning Systems — Cap. 1, pp. 33–36
- **Dia 5:** documentação / revisão guiada — **OpenAI Academy — Prompting fundamentals (visão geral para iniciantes)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Treinar uma rede neural simples em notebook/script e expor resultado via documentação técnica no projeto.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): primeira-ia-do-zero-ciclo-dados-treino-validacao-i`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Primeira IA do zero: ciclo dados → treino → validação → inferência` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Notebook ou script versionado com relatório curto.

---
## Semana 008 — Consolidação do módulo e mini review técnico

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **consolidação do módulo e mini review técnico**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 1, pp. 37–40
- **Dia 2:** Designing Machine Learning Systems — Cap. 1, pp. 41–44
- **Dia 3:** Designing Machine Learning Systems — Cap. 1, pp. 45–48
- **Dia 4:** Designing Machine Learning Systems — Cap. 1, pp. 49–52
- **Dia 5:** documentação / revisão guiada — **Anthropic Docs — Prompt engineering overview (leitura panorâmica)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Gravar um screencast curto ou escrever uma demo guiada do que já foi construído.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): consolidacao-do-modulo-e-mini-review-tecnico`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Consolidação do módulo e mini review técnico` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Entrega 0: demo técnica do setup e fundamentos.

---

# Módulo 2 — APIs de IA Generativa, Prompt Engineering e Evals Básicos

**Resultado do módulo:** Transformar o backend em uma camada de APIs generativas previsíveis, testáveis e com custo monitorado.

## Semana 009 — Panorama de provedores, modelos e trade-offs

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **panorama de provedores, modelos e trade-offs**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 2, pp. 49–56
- **Dia 2:** AI Engineering — Cap. 2, pp. 57–64
- **Dia 3:** AI Engineering — Cap. 2, pp. 65–72
- **Dia 4:** AI Engineering — Cap. 2, pp. 73–80
- **Dia 5:** documentação / revisão guiada — **OpenAI Help / Academy — Best practices for prompt engineering** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar uma matriz comparando OpenAI, Anthropic, Google e Ollama por custo, latência e casos de uso.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): panorama-de-provedores-modelos-e-trade-offs`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Panorama de provedores, modelos e trade-offs` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Tabela de decisão de provedores.

---
## Semana 010 — Prompting básico de produção: instruções, contexto e delimitação

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **prompting básico de produção: instruções, contexto e delimitação**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 2, pp. 81–88
- **Dia 2:** AI Engineering — Cap. 2, pp. 89–96
- **Dia 3:** AI Engineering — Cap. 2, pp. 97–104
- **Dia 4:** AI Engineering — Cap. 2, pp. 105–112
- **Dia 5:** documentação / revisão guiada — **Anthropic Docs — Prompting best practices e uso de exemplos** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar uma biblioteca de prompts versionada (`/prompts`) com variáveis e testes manuais.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): prompting-basico-de-producao-instrucoes-contexto-e`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Prompting básico de produção: instruções, contexto e delimitação` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Catálogo inicial de prompts.

---
## Semana 011 — Prompt templates, few-shot e saídas estruturadas

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **prompt templates, few-shot e saídas estruturadas**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 3, pp. 113–120
- **Dia 2:** AI Engineering — Cap. 3, pp. 121–127
- **Dia 3:** AI Engineering — Cap. 3, pp. 128–134
- **Dia 4:** AI Engineering — Cap. 3, pp. 135–141
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — Evaluation best practices** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar structured output para um caso real: classificação de tickets ou sumário técnico.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): prompt-templates-few-shot-e-saidas-estruturadas`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Prompt templates, few-shot e saídas estruturadas` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Endpoint com schema JSON estável.

---
## Semana 012 — Consistência, cache e redução de custo

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **consistência, cache e redução de custo**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 3, pp. 142–148
- **Dia 2:** AI Engineering — Cap. 3, pp. 149–155
- **Dia 3:** AI Engineering — Cap. 3, pp. 156–158 + AI Engineering — Cap. 5, pp. 211–214
- **Dia 4:** AI Engineering — Cap. 5, pp. 215–221
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — Model optimization / cost-performance basics** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar cache para prompts/embeddings e medir redução de tokens ou chamadas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): consistencia-cache-e-reducao-de-custo`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Consistência, cache e redução de custo` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Métrica simples de economia por request.

---
## Semana 013 — Introdução a avaliações: por que demos não bastam

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q1  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **introdução a avaliações: por que demos não bastam**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 5, pp. 222–228
- **Dia 2:** AI Engineering — Cap. 5, pp. 229–235
- **Dia 3:** AI Engineering — Cap. 5, pp. 236–242
- **Dia 4:** AI Engineering — Cap. 5, pp. 243–249
- **Dia 5:** documentação / revisão guiada — **OpenAI Help / Academy — Best practices for prompt engineering** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar um dataset pequeno de avaliação com 20 casos e critérios de aceite.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): introducao-a-avaliacoes-por-que-demos-nao-bastam`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Introdução a avaliações: por que demos não bastam` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- `evals/dataset-v1.jsonl`.

### Checkpoint trimestral
- Releia ADRs, limpe backlog técnico, atualize README e anote as 3 decisões mais importantes do trimestre.
- Rode uma demo de ponta a ponta e marque os gargalos de produto, engenharia e operação.

---
## Semana 014 — Integração real com Spring AI: autenticação, retries e timeouts

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **integração real com spring ai: autenticação, retries e timeouts**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 5, pp. 250–252 + Hands-On LLMs — Cap. 2, pp. 49–52
- **Dia 2:** Hands-On LLMs — Cap. 2, pp. 53–59
- **Dia 3:** Hands-On LLMs — Cap. 2, pp. 60–66
- **Dia 4:** Hands-On LLMs — Cap. 2, pp. 67–73
- **Dia 5:** documentação / revisão guiada — **Anthropic Docs — Prompting best practices e uso de exemplos** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Aplicar timeout, retry e circuit breaker ao serviço de LLM.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): integracao-real-com-spring-ai-autenticacao-retries`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Integração real com Spring AI: autenticação, retries e timeouts` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Cliente robusto para inferência.

---
## Semana 015 — Multimodal de entrada: texto + imagem + áudio (visão geral)

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **multimodal de entrada: texto + imagem + áudio (visão geral)**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 2, pp. 74–80
- **Dia 2:** Hands-On LLMs — Cap. 2, pp. 81–84 + Hands-On LLMs — Cap. 6, pp. 174–176
- **Dia 3:** Hands-On LLMs — Cap. 6, pp. 177–183
- **Dia 4:** Hands-On LLMs — Cap. 6, pp. 184–190
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — Evaluation best practices** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Prototipar um fluxo simples de OCR/análise de documento em backend.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): multimodal-de-entrada-texto-imagem-audio-visao-ger`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Multimodal de entrada: texto + imagem + áudio (visão geral)` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Endpoint experimental para documento/imagem.

---
## Semana 016 — Consolidação do módulo e review de prompts

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **consolidação do módulo e review de prompts**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 6, pp. 191–197
- **Dia 2:** Hands-On LLMs — Cap. 6, pp. 198–204
- **Dia 3:** Hands-On LLMs — Cap. 6, pp. 205–211
- **Dia 4:** Hands-On LLMs — Cap. 6, pp. 212–218
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — Model optimization / cost-performance basics** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Revisar os prompts criados, descartar os frágeis e publicar guidelines internas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): consolidacao-do-modulo-e-review-de-prompts`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Consolidação do módulo e review de prompts` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Guia `prompt-style-guide.md`.

---

# Módulo 3 — RAG, Embeddings e Busca Semântica (Fundamentos)

**Resultado do módulo:** Construir o núcleo do conhecimento do produto: ingestão, indexação e busca semântica confiável.

## Semana 017 — Embeddings na prática e quando semântica vence keyword

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **embeddings na prática e quando semântica vence keyword**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 6, pp. 253–259
- **Dia 2:** AI Engineering — Cap. 6, pp. 260–266
- **Dia 3:** AI Engineering — Cap. 6, pp. 267–273
- **Dia 4:** AI Engineering — Cap. 6, pp. 274–280
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Embeddings, Vector Stores e Advisors** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar serviço de embeddings e persistência em PostgreSQL/pgvector.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): embeddings-na-pratica-e-quando-semantica-vence-key`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Embeddings na prática e quando semântica vence keyword` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Tabela vetorial e pipeline inicial.

---
## Semana 018 — Chunking e modelagem de documentos

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **chunking e modelagem de documentos**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 6, pp. 281–287
- **Dia 2:** AI Engineering — Cap. 6, pp. 288–294
- **Dia 3:** AI Engineering — Cap. 6, pp. 295–301
- **Dia 4:** AI Engineering — Cap. 6, pp. 302–306 + Designing Machine Learning Systems — Cap. 2, pp. 53–54
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — PgVector / Vector DB support** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar particionamento de documentos com metadados, source id e versionamento.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): chunking-e-modelagem-de-documentos`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Chunking e modelagem de documentos` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Ingestor de documentos v1.

---
## Semana 019 — Vector DB, pgvector e consultas de similaridade

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **vector db, pgvector e consultas de similaridade**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 2, pp. 55–61
- **Dia 2:** Designing Machine Learning Systems — Cap. 2, pp. 62–68
- **Dia 3:** Designing Machine Learning Systems — Cap. 2, pp. 69–75
- **Dia 4:** Designing Machine Learning Systems — Cap. 2, pp. 76–82
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — RAG / retrieval-oriented guides** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Construir `/search/semantic` com top-k e score.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): vector-db-pgvector-e-consultas-de-similaridade`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Vector DB, pgvector e consultas de similaridade` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Busca vetorial funcionando.

---
## Semana 020 — Ingestion pipeline assíncrono e reprocessamento

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **ingestion pipeline assíncrono e reprocessamento**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 2, pp. 83–89
- **Dia 2:** Designing Machine Learning Systems — Cap. 2, pp. 90–96
- **Dia 3:** Designing Machine Learning Systems — Cap. 2, pp. 97–98 + Designing Machine Learning Systems — Cap. 3, pp. 99–103
- **Dia 4:** Designing Machine Learning Systems — Cap. 3, pp. 104–110
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry — observability primer (aplicar desde o início)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Separar upload, parsing e indexação em etapas assíncronas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): ingestion-pipeline-assincrono-e-reprocessamento`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Ingestion pipeline assíncrono e reprocessamento` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Fila/worker de ingestão.

---
## Semana 021 — Hybrid search e filtros estruturados

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **hybrid search e filtros estruturados**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 3, pp. 111–117
- **Dia 2:** Designing Machine Learning Systems — Cap. 3, pp. 118–124
- **Dia 3:** Designing Machine Learning Systems — Cap. 3, pp. 125–131
- **Dia 4:** Designing Machine Learning Systems — Cap. 3, pp. 132–138
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Embeddings, Vector Stores e Advisors** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Combinar similaridade vetorial com filtros por tipo, data e domínio.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): hybrid-search-e-filtros-estruturados`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Hybrid search e filtros estruturados` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Busca híbrida simples.

---
## Semana 022 — Spring AI para RAG: advisors, retrievers e composition

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **spring ai para rag: advisors, retrievers e composition**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 3, pp. 139–140 + Machine Learning Design Patterns — Cap. 2, pp. 19–23
- **Dia 2:** Machine Learning Design Patterns — Cap. 2, pp. 24–30
- **Dia 3:** Machine Learning Design Patterns — Cap. 2, pp. 31–37
- **Dia 4:** Machine Learning Design Patterns — Cap. 2, pp. 38–44
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — PgVector / Vector DB support** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Acoplar recuperação ao endpoint de chat com contexto recuperado.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): spring-ai-para-rag-advisors-retrievers-e-compositi`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Spring AI para RAG: advisors, retrievers e composition` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Primeiro chat com grounding.

---
## Semana 023 — Avaliação inicial de retrieval

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **avaliação inicial de retrieval**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 2, pp. 45–51
- **Dia 2:** Machine Learning Design Patterns — Cap. 2, pp. 52–58
- **Dia 3:** Machine Learning Design Patterns — Cap. 2, pp. 59–65
- **Dia 4:** Machine Learning Design Patterns — Cap. 2, pp. 66–72
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — RAG / retrieval-oriented guides** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar 15 consultas conhecidas e medir se os documentos corretos aparecem no top-k.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): avaliacao-inicial-de-retrieval`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Avaliação inicial de retrieval` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Relatório de relevância v1.

---
## Semana 024 — Entrega 1 — Primeiro RAG funcional

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 1 — primeiro rag funcional**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 2, pp. 73–78 + Hands-On LLMs — Cap. 8 (estimado), p. 266
- **Dia 2:** Hands-On LLMs — Cap. 8 (estimado), pp. 267–273
- **Dia 3:** Hands-On LLMs — Cap. 8 (estimado), pp. 274–280
- **Dia 4:** Hands-On LLMs — Cap. 8 (estimado), pp. 281–286
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry — observability primer (aplicar desde o início)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Preparar uma demo CLI/API respondendo com fontes e citações mínimas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-1---primeiro-rag-funcional`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 1 — Primeiro RAG funcional` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- RAG v1 pronto para validação.

---

# Módulo 4 — RAG Avançado, Evals e Observabilidade

**Resultado do módulo:** Sair do RAG demonstrável para o RAG operável: com métricas, testes e critérios de qualidade.

## Semana 025 — Rerankers, query expansion e decomposição de perguntas

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **rerankers, query expansion e decomposição de perguntas**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 3, pp. 113–120
- **Dia 2:** AI Engineering — Cap. 3, pp. 121–128
- **Dia 3:** AI Engineering — Cap. 3, pp. 129–136
- **Dia 4:** AI Engineering — Cap. 3, pp. 137–144
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — Working with evals / evaluation best practices** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar reordenação de resultados e medir impacto em top-3.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): rerankers-query-expansion-e-decomposicao-de-pergun`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Rerankers, query expansion e decomposição de perguntas` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Busca com reranking configurável.

---
## Semana 026 — Contextual retrieval e prevenção de contexto ruim

**Nível-alvo:** Base (júnior → júnior forte)  
**Fase:** Q2  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **contextual retrieval e prevenção de contexto ruim**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 3, pp. 145–152
- **Dia 2:** AI Engineering — Cap. 3, pp. 153–158 + AI Engineering — Cap. 4, pp. 159–160
- **Dia 3:** AI Engineering — Cap. 4, pp. 161–168
- **Dia 4:** AI Engineering — Cap. 4, pp. 169–176
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry — traces, signals e collector basics** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Testar estratégias de chunk overlap, summaries e metadata boosting.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Foque em implementar o mínimo funcional, nomear bem as abstrações e documentar decisões simples.

### PR da semana
- **Título sugerido:** `feat(ai): contextual-retrieval-e-prevencao-de-contexto-ruim`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Contextual retrieval e prevenção de contexto ruim` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Experimentos documentados.

### Checkpoint trimestral
- Releia ADRs, limpe backlog técnico, atualize README e anote as 3 decisões mais importantes do trimestre.
- Rode uma demo de ponta a ponta e marque os gargalos de produto, engenharia e operação.

---
## Semana 027 — Grounding, citações e resposta verificável

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **grounding, citações e resposta verificável**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 4, pp. 177–184
- **Dia 2:** AI Engineering — Cap. 4, pp. 185–192
- **Dia 3:** AI Engineering — Cap. 4, pp. 193–200
- **Dia 4:** AI Engineering — Cap. 4, pp. 201–207
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Observability e LLM-as-a-Judge Evaluation guide** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Garantir que a resposta exponha fontes, trechos e score de confiança.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): grounding-citacoes-e-resposta-verificavel`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Grounding, citações e resposta verificável` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Resposta com evidência mínima.

---
## Semana 028 — Agentic RAG sem overengineering

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **agentic rag sem overengineering**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 4, pp. 208–210 + Designing Machine Learning Systems — Cap. 5, pp. 171–174
- **Dia 2:** Designing Machine Learning Systems — Cap. 5, pp. 175–181
- **Dia 3:** Designing Machine Learning Systems — Cap. 5, pp. 182–188
- **Dia 4:** Designing Machine Learning Systems — Cap. 5, pp. 189–195
- **Dia 5:** documentação / revisão guiada — **Anthropic Engineering — context engineering for agents** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Inserir uma etapa leve de decisão: recuperar, sintetizar ou pedir clarificação.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): agentic-rag-sem-overengineering`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Agentic RAG sem overengineering` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Workflow RAG adaptativo v1.

---
## Semana 029 — Harness de avaliação de aplicação

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **harness de avaliação de aplicação**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 5, pp. 196–202
- **Dia 2:** Designing Machine Learning Systems — Cap. 5, pp. 203–209
- **Dia 3:** Designing Machine Learning Systems — Cap. 5, pp. 210–216
- **Dia 4:** Designing Machine Learning Systems — Cap. 5, pp. 217–223
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — Working with evals / evaluation best practices** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar pipeline local que rode evals em lote após mudanças importantes.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): harness-de-avaliacao-de-aplicacao`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Harness de avaliação de aplicação` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- `./gradlew evalRag` ou equivalente.

---
## Semana 030 — Tracing, logs e métricas por request

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **tracing, logs e métricas por request**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 5, pp. 224–230
- **Dia 2:** Designing Machine Learning Systems — Cap. 5, pp. 231–237
- **Dia 3:** Designing Machine Learning Systems — Cap. 5, pp. 238–244
- **Dia 4:** Designing Machine Learning Systems — Cap. 5, pp. 245–251
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry — traces, signals e collector basics** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Instrumentar latency, tokens, custo e falhas usando OpenTelemetry.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): tracing-logs-e-metricas-por-request`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Tracing, logs e métricas por request` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Dashboards básicos de IA.

---
## Semana 031 — Tratamento de erros, alucinação e guardrails iniciais

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **tratamento de erros, alucinação e guardrails iniciais**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 5, pp. 252–258
- **Dia 2:** Designing Machine Learning Systems — Cap. 5, p. 259 + Machine Learning Design Patterns — Cap. 5, pp. 201–206
- **Dia 3:** Machine Learning Design Patterns — Cap. 5, pp. 207–213
- **Dia 4:** Machine Learning Design Patterns — Cap. 5, pp. 214–220
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Observability e LLM-as-a-Judge Evaluation guide** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar recusa, fallback e classificação de risco para prompts perigosos.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): tratamento-de-erros-alucinacao-e-guardrails-inicia`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Tratamento de erros, alucinação e guardrails iniciais` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Guardrails v1.

---
## Semana 032 — Entrega 2 — RAG observável e testável

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 2 — rag observável e testável**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 5, pp. 221–227
- **Dia 2:** Machine Learning Design Patterns — Cap. 5, pp. 228–234
- **Dia 3:** Machine Learning Design Patterns — Cap. 5, pp. 235–241
- **Dia 4:** Machine Learning Design Patterns — Cap. 5, pp. 242–248
- **Dia 5:** documentação / revisão guiada — **Anthropic Engineering — context engineering for agents** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Publicar uma demo com métricas e resultados de avaliação antes/depois.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-2---rag-observavel-e-testavel`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 2 — RAG observável e testável` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- RAG v2 com evals e observabilidade.

---

# Módulo 5 — MCP: Model Context Protocol do Conceito à Produção

**Resultado do módulo:** Tornar a plataforma AI-ready, com integração padronizada entre host, backend, ferramentas e contexto.

## Semana 033 — MCP: problema que resolve, arquitetura e objetos centrais

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **mcp: problema que resolve, arquitetura e objetos centrais**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 10, pp. 449–454
- **Dia 2:** AI Engineering — Cap. 10, pp. 455–460
- **Dia 3:** AI Engineering — Cap. 10, pp. 461–466
- **Dia 4:** AI Engineering — Cap. 10, pp. 467–472
- **Dia 5:** documentação / revisão guiada — **Model Context Protocol — Intro e Specification** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Modelar quais capacidades do `SignalDesk AI` virarão tools, resources e prompts.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): mcp-problema-que-resolve-arquitetura-e-objetos-cen`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `MCP: problema que resolve, arquitetura e objetos centrais` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Mapa MCP da aplicação.

---
## Semana 034 — MCP client/server em Java e Spring

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **mcp client/server em java e spring**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 10, pp. 473–478
- **Dia 2:** AI Engineering — Cap. 10, pp. 479–484
- **Dia 3:** AI Engineering — Cap. 10, pp. 485–490
- **Dia 4:** AI Engineering — Cap. 10, pp. 491–494 + Designing Machine Learning Systems — Cap. 6, pp. 260–261
- **Dia 5:** documentação / revisão guiada — **Spring AI MCP Reference — Overview e Getting Started** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Subir um MCP Server mínimo expondo uma tool de busca interna.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): mcp-client-server-em-java-e-spring`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `MCP client/server em Java e Spring` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Servidor MCP v1.

---
## Semana 035 — Tools, resources e prompts bem desenhados

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **tools, resources e prompts bem desenhados**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 6, pp. 262–267
- **Dia 2:** Designing Machine Learning Systems — Cap. 6, pp. 268–273
- **Dia 3:** Designing Machine Learning Systems — Cap. 6, pp. 274–279
- **Dia 4:** Designing Machine Learning Systems — Cap. 6, pp. 280–285
- **Dia 5:** documentação / revisão guiada — **Spring AI MCP Reference — Java SDK / Spring MCP** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Refatorar contratos para entrada/saída previsíveis e schemas claros.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): tools-resources-e-prompts-bem-desenhados`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Tools, resources e prompts bem desenhados` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Contratos MCP revisados.

---
## Semana 036 — Expor serviços internos via MCP

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **expor serviços internos via mcp**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 6, pp. 286–290
- **Dia 2:** Designing Machine Learning Systems — Cap. 6, pp. 291–295
- **Dia 3:** Designing Machine Learning Systems — Cap. 6, pp. 296–300
- **Dia 4:** Designing Machine Learning Systems — Cap. 6, pp. 301–305
- **Dia 5:** documentação / revisão guiada — **MCP roadmap / governance notes para entender a evolução do ecossistema** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar uma resource para documentos e uma tool para incident summary.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): expor-servicos-internos-via-mcp`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Expor serviços internos via MCP` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- MCP mais útil ao negócio.

---
## Semana 037 — Autenticação, service tokens e rate limiting

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **autenticação, service tokens e rate limiting**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 6, pp. 306–310
- **Dia 2:** Designing Machine Learning Systems — Cap. 6, pp. 311–315
- **Dia 3:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 249–253
- **Dia 4:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 254–258
- **Dia 5:** documentação / revisão guiada — **Model Context Protocol — Intro e Specification** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Aplicar autenticação e proteção básica contra abuso.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): autenticacao-service-tokens-e-rate-limiting`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Autenticação, service tokens e rate limiting` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- MCP protegido para uso interno.

---
## Semana 038 — Testes de compatibilidade com múltiplos clientes

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **testes de compatibilidade com múltiplos clientes**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 259–263
- **Dia 2:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 264–268
- **Dia 3:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 269–273
- **Dia 4:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 274–278
- **Dia 5:** documentação / revisão guiada — **Spring AI MCP Reference — Overview e Getting Started** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Validar o MCP em pelo menos dois clientes/hosts compatíveis.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): testes-de-compatibilidade-com-multiplos-clientes`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Testes de compatibilidade com múltiplos clientes` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Checklist de compatibilidade.

---
## Semana 039 — Integração UI + backend + MCP

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q3  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **integração ui + backend + mcp**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 279–283
- **Dia 2:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 284–288
- **Dia 3:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 289–293
- **Dia 4:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 294–298
- **Dia 5:** documentação / revisão guiada — **Spring AI MCP Reference — Java SDK / Spring MCP** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar uma tela simples que demonstre como a UI expõe/consome contexto programaticamente.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): integracao-ui-backend-mcp`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Integração UI + backend + MCP` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Demonstração MCP + UI.

### Checkpoint trimestral
- Releia ADRs, limpe backlog técnico, atualize README e anote as 3 decisões mais importantes do trimestre.
- Rode uma demo de ponta a ponta e marque os gargalos de produto, engenharia e operação.

---
## Semana 040 — Entrega 3 — MCP em produção local

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 3 — mcp em produção local**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 299–303
- **Dia 2:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 304–308
- **Dia 3:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 309–313
- **Dia 4:** Machine Learning Design Patterns — Cap. 6 (trecho), pp. 314–318
- **Dia 5:** documentação / revisão guiada — **MCP roadmap / governance notes para entender a evolução do ecossistema** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Documentar setup, segurança, limites e casos de uso reais.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-3---mcp-em-producao-local`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 3 — MCP em produção local` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Servidor MCP pronto para demos internas.

---

# Módulo 6 — Agents: Arquitetura, ReAct, Tool Use e Function Calling

**Resultado do módulo:** Sair de fluxos lineares e entrar em workflows agentic controlados e rastreáveis.

## Semana 041 — Agent loop: percepção → raciocínio → ação → feedback

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **agent loop: percepção → raciocínio → ação → feedback**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 6 (revisita), pp. 174–180
- **Dia 2:** Hands-On LLMs — Cap. 6 (revisita), pp. 181–187
- **Dia 3:** Hands-On LLMs — Cap. 6 (revisita), pp. 188–194
- **Dia 4:** Hands-On LLMs — Cap. 6 (revisita), pp. 195–201
- **Dia 5:** documentação / revisão guiada — **LangGraph Overview** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar um agente simples que decide entre responder direto ou chamar busca.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): agent-loop-percepcao-raciocinio-acao-feedback`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Agent loop: percepção → raciocínio → ação → feedback` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Single agent v1.

---
## Semana 042 — ReAct na prática

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **react na prática**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 6 (revisita), pp. 202–208
- **Dia 2:** Hands-On LLMs — Cap. 6 (revisita), pp. 209–215
- **Dia 3:** Hands-On LLMs — Cap. 6 (revisita), pp. 216–218 + Hands-On LLMs — Cap. 7, pp. 219–222
- **Dia 4:** Hands-On LLMs — Cap. 7, pp. 223–229
- **Dia 5:** documentação / revisão guiada — **LangGraph Graph API** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Codificar um loop ReAct simples com logs de pensamento/ação/observação em alto nível.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): react-na-pratica`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `ReAct na prática` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Executor iterativo básico.

---
## Semana 043 — Plan-and-Execute e decomposição de tarefas

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **plan-and-execute e decomposição de tarefas**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 7, pp. 230–236
- **Dia 2:** Hands-On LLMs — Cap. 7, pp. 237–243
- **Dia 3:** Hands-On LLMs — Cap. 7, pp. 244–250
- **Dia 4:** Hands-On LLMs — Cap. 7, pp. 251–257
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Building Effective Agents** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Separar planner e executor para requests mais longas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): plan-and-execute-e-decomposicao-de-tarefas`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Plan-and-Execute e decomposição de tarefas` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Planner/executor acoplados.

---
## Semana 044 — Function calling e design de JSON schemas

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **function calling e design de json schemas**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 7, pp. 258–264
- **Dia 2:** Hands-On LLMs — Cap. 7, p. 265 + AI Engineering — Cap. 6 (revisita), pp. 253–258
- **Dia 3:** AI Engineering — Cap. 6 (revisita), pp. 259–264
- **Dia 4:** AI Engineering — Cap. 6 (revisita), pp. 265–270
- **Dia 5:** documentação / revisão guiada — **Anthropic Engineering — Effective context engineering for AI agents** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Expor tools robustas com schemas e validação forte.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): function-calling-e-design-de-json-schemas`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Function calling e design de JSON schemas` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Tool calling previsível.

---
## Semana 045 — Memória curta vs longa

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **memória curta vs longa**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 6 (revisita), pp. 271–276
- **Dia 2:** AI Engineering — Cap. 6 (revisita), pp. 277–282
- **Dia 3:** AI Engineering — Cap. 6 (revisita), pp. 283–288
- **Dia 4:** AI Engineering — Cap. 6 (revisita), pp. 289–294
- **Dia 5:** documentação / revisão guiada — **LangGraph Overview** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar memória de conversa curta e uma memória persistente resumida.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): memoria-curta-vs-longa`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Memória curta vs longa` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Memory store v1.

---
## Semana 046 — Reflection e self-correction

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **reflection e self-correction**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 6 (revisita), pp. 295–300
- **Dia 2:** AI Engineering — Cap. 6 (revisita), pp. 301–306
- **Dia 3:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 79–84
- **Dia 4:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 85–90
- **Dia 5:** documentação / revisão guiada — **LangGraph Graph API** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar uma etapa de revisão para respostas críticas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): reflection-e-self-correction`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Reflection e self-correction` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Reflection pass opcional.

---
## Semana 047 — Limites de autonomia e guardrails

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **limites de autonomia e guardrails**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 91–96
- **Dia 2:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 97–102
- **Dia 3:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 103–108
- **Dia 4:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 109–114
- **Dia 5:** documentação / revisão guiada — **Spring AI Reference — Building Effective Agents** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Restringir escopo do agente e registrar decisões críticas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): limites-de-autonomia-e-guardrails`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Limites de autonomia e guardrails` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Guardrails agentic v1.

---
## Semana 048 — Entrega 4 — Agente autônomo inicial

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 4 — agente autônomo inicial**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 115–120
- **Dia 2:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 121–126
- **Dia 3:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 127–132
- **Dia 4:** Machine Learning Design Patterns — Cap. 3 (trecho), pp. 133–138
- **Dia 5:** documentação / revisão guiada — **Anthropic Engineering — Effective context engineering for AI agents** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Fazer uma demo de um agente que consulta, planeja e executa com segurança.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-4---agente-autonomo-inicial`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 4 — Agente autônomo inicial` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Single-agent pronto para benchmark interno.

---

# Módulo 7 — Contexto, LangGraph, Human-in-the-Loop e Multi-Agent Systems

**Resultado do módulo:** Construir orquestração stateful com autonomia limitada, aprovação humana e comunicação entre agentes.

## Semana 049 — Context engineering: contexto ativo e poda

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **context engineering: contexto ativo e poda**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 10 (revisita), pp. 449–454
- **Dia 2:** AI Engineering — Cap. 10 (revisita), pp. 455–460
- **Dia 3:** AI Engineering — Cap. 10 (revisita), pp. 461–466
- **Dia 4:** AI Engineering — Cap. 10 (revisita), pp. 467–472
- **Dia 5:** documentação / revisão guiada — **LangGraph Overview / persistence / state concepts** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Definir política de `context window budget` para diferentes fluxos.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): context-engineering-contexto-ativo-e-poda`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Context engineering: contexto ativo e poda` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Política de contexto documentada.

---
## Semana 050 — Pruning, stitching e recuperação de memória

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **pruning, stitching e recuperação de memória**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 10 (revisita), pp. 473–478
- **Dia 2:** AI Engineering — Cap. 10 (revisita), pp. 479–484
- **Dia 3:** AI Engineering — Cap. 10 (revisita), pp. 485–490
- **Dia 4:** AI Engineering — Cap. 10 (revisita), pp. 491–494 + Machine Learning Design Patterns — Cap. 6 (revisita), pp. 249–250
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry — signals e correlação entre traces, metrics e logs** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar resumo incremental e stitching de contexto.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): pruning-stitching-e-recuperacao-de-memoria`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Pruning, stitching e recuperação de memória` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Gestão de contexto v2.

---
## Semana 051 — LangGraph para fluxos stateful

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **langgraph para fluxos stateful**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 251–256
- **Dia 2:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 257–262
- **Dia 3:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 263–268
- **Dia 4:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 269–274
- **Dia 5:** documentação / revisão guiada — **MCP Apps / MCP UI discussions (visão de interface conectada a agentes)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Migrar um fluxo do módulo anterior para grafo explícito.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): langgraph-para-fluxos-stateful`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `LangGraph para fluxos stateful` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Workflow em grafo.

---
## Semana 052 — Retries, fallbacks e durable execution

**Nível-alvo:** Intermediário (pleno em formação)  
**Fase:** Q4  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **retries, fallbacks e durable execution**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 275–280
- **Dia 2:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 281–286
- **Dia 3:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 287–292
- **Dia 4:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 293–298
- **Dia 5:** documentação / revisão guiada — **Spring AI — prompt engineering patterns e observability** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar nós de fallback, retries e checkpoints.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Passe a justificar alternativas rejeitadas e a instrumentar melhor o comportamento do sistema.

### PR da semana
- **Título sugerido:** `feat(ai): retries-fallbacks-e-durable-execution`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Retries, fallbacks e durable execution` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Fluxo resiliente.

### Checkpoint trimestral
- Releia ADRs, limpe backlog técnico, atualize README e anote as 3 decisões mais importantes do trimestre.
- Rode uma demo de ponta a ponta e marque os gargalos de produto, engenharia e operação.

---
## Semana 053 — Human-in-the-loop e approval gates

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **human-in-the-loop e approval gates**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 299–304
- **Dia 2:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 305–310
- **Dia 3:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 311–316
- **Dia 4:** Machine Learning Design Patterns — Cap. 6 (revisita), pp. 317–318 + Designing Machine Learning Systems — Cap. 7, pp. 316–319
- **Dia 5:** documentação / revisão guiada — **LangGraph Overview / persistence / state concepts** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Inserir etapa de aprovação para ações mais arriscadas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): human-in-the-loop-e-approval-gates`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Human-in-the-loop e approval gates` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- HITL funcionando.

---
## Semana 054 — Padrões multiagente: supervisor, delegation e consensus

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **padrões multiagente: supervisor, delegation e consensus**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 7, pp. 320–325
- **Dia 2:** Designing Machine Learning Systems — Cap. 7, pp. 326–331
- **Dia 3:** Designing Machine Learning Systems — Cap. 7, pp. 332–337
- **Dia 4:** Designing Machine Learning Systems — Cap. 7, pp. 338–339 + AI Engineering — Cap. 3 (revisita), pp. 113–116
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry — signals e correlação entre traces, metrics e logs** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar 2–3 agentes especializados com papéis claros.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): padroes-multiagente-supervisor-delegation-e-consen`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Padrões multiagente: supervisor, delegation e consensus` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Mini sistema multiagente.

---
## Semana 055 — Mensageria e comunicação assíncrona entre agentes

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **mensageria e comunicação assíncrona entre agentes**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 3 (revisita), pp. 117–122
- **Dia 2:** AI Engineering — Cap. 3 (revisita), pp. 123–128
- **Dia 3:** AI Engineering — Cap. 3 (revisita), pp. 129–133
- **Dia 4:** AI Engineering — Cap. 3 (revisita), pp. 134–138
- **Dia 5:** documentação / revisão guiada — **MCP Apps / MCP UI discussions (visão de interface conectada a agentes)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Trocar mensagens via fila ou fila simulada com persistência.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): mensageria-e-comunicacao-assincrona-entre-agentes`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Mensageria e comunicação assíncrona entre agentes` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Canal assíncrono entre agentes.

---
## Semana 056 — Entrega 5 — Workflow multiagente

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 5 — workflow multiagente**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 3 (revisita), pp. 139–143
- **Dia 2:** AI Engineering — Cap. 3 (revisita), pp. 144–148
- **Dia 3:** AI Engineering — Cap. 3 (revisita), pp. 149–153
- **Dia 4:** AI Engineering — Cap. 3 (revisita), pp. 154–158
- **Dia 5:** documentação / revisão guiada — **Spring AI — prompt engineering patterns e observability** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Demonstrar um caso completo: analista → planejador → executor → aprovador.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-5---workflow-multiagente`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 5 — Workflow multiagente` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Multi-agent workflow em operação local.

---

# Módulo 8 — Multimodalidade, UX/UI com IA e Experiência do Usuário

**Resultado do módulo:** Levar o produto para além do chat textual, conectando IA à experiência real do usuário.

## Semana 057 — Mapa multimodal: texto, imagem, áudio e documento

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **mapa multimodal: texto, imagem, áudio e documento**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 9, pp. 287–291
- **Dia 2:** Hands-On LLMs — Cap. 9, pp. 292–296
- **Dia 3:** Hands-On LLMs — Cap. 9, pp. 297–301
- **Dia 4:** Hands-On LLMs — Cap. 9, pp. 302–306
- **Dia 5:** documentação / revisão guiada — **Docs do provedor escolhido para Vision / Audio / OCR** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Definir quais entradas multimodais fazem sentido para o produto.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): mapa-multimodal-texto-imagem-audio-e-documento`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Mapa multimodal: texto, imagem, áudio e documento` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Plano multimodal do projeto.

---
## Semana 058 — OCR inteligente e entendimento de documento

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **ocr inteligente e entendimento de documento**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 9, pp. 307–311
- **Dia 2:** Hands-On LLMs — Cap. 9, pp. 312–316
- **Dia 3:** Hands-On LLMs — Cap. 9, pp. 317–320
- **Dia 4:** Hands-On LLMs — Cap. 9, pp. 321–322 + Hands-On LLMs — Cap. 4, pp. 121–122
- **Dia 5:** documentação / revisão guiada — **Spring AI — audio, image e structured outputs (se aplicável)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Prototipar upload de PDF/imagem com extração + sumarização.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): ocr-inteligente-e-entendimento-de-documento`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `OCR inteligente e entendimento de documento` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- OCR/Doc AI v1.

---
## Semana 059 — Áudio: transcrição, sumarização e follow-up

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **áudio: transcrição, sumarização e follow-up**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 4, pp. 123–126
- **Dia 2:** Hands-On LLMs — Cap. 4, pp. 127–130
- **Dia 3:** Hands-On LLMs — Cap. 4, pp. 131–134
- **Dia 4:** Hands-On LLMs — Cap. 4, pp. 135–138
- **Dia 5:** documentação / revisão guiada — **OpenAI / Gemini multimodal docs do provider adotado** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar pipeline para áudio curto → transcript → resumo → ações.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): audio-transcricao-sumarizacao-e-follow-up`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Áudio: transcrição, sumarização e follow-up` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Processador de áudio v1.

---
## Semana 060 — Imagem e visão computacional aplicada

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **imagem e visão computacional aplicada**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 4, pp. 139–142
- **Dia 2:** Hands-On LLMs — Cap. 4, pp. 143–146
- **Dia 3:** Hands-On LLMs — Cap. 4, pp. 147–150
- **Dia 4:** Hands-On LLMs — Cap. 4, pp. 151–154
- **Dia 5:** documentação / revisão guiada — **Guias de design assistido por IA para front-end (foco prático, não mágico)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Integrar um modelo de visão para análise de screenshot ou documento.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): imagem-e-visao-computacional-aplicada`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Imagem e visão computacional aplicada` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Análise visual v1.

---
## Semana 061 — AI-driven UX/UI: text-to-UI e protótipos

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **ai-driven ux/ui: text-to-ui e protótipos**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 2 (revisita), pp. 49–52
- **Dia 2:** AI Engineering — Cap. 2 (revisita), pp. 53–56
- **Dia 3:** AI Engineering — Cap. 2 (revisita), pp. 57–60
- **Dia 4:** AI Engineering — Cap. 2 (revisita), pp. 61–64
- **Dia 5:** documentação / revisão guiada — **Docs do provedor escolhido para Vision / Audio / OCR** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Descrever uma interface em linguagem natural e implementar um wireframe mínimo.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): ai-driven-ux-ui-text-to-ui-e-prototipos`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `AI-driven UX/UI: text-to-UI e protótipos` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Protótipo UI assistido por IA.

---
## Semana 062 — Fluxo front-end com agentes de codificação

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **fluxo front-end com agentes de codificação**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 2 (revisita), pp. 65–68
- **Dia 2:** AI Engineering — Cap. 2 (revisita), pp. 69–72
- **Dia 3:** AI Engineering — Cap. 2 (revisita), pp. 73–76
- **Dia 4:** AI Engineering — Cap. 2 (revisita), pp. 77–80
- **Dia 5:** documentação / revisão guiada — **Spring AI — audio, image e structured outputs (se aplicável)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Usar uma ferramenta/CLI de IA para gerar/refatorar um componente e revisar criticamente.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): fluxo-front-end-com-agentes-de-codificacao`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Fluxo front-end com agentes de codificação` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Componente gerado + review humano.

---
## Semana 063 — Busca semântica e chat de suporte na interface

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **busca semântica e chat de suporte na interface**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 2 (revisita), pp. 81–84
- **Dia 2:** AI Engineering — Cap. 2 (revisita), pp. 85–88
- **Dia 3:** AI Engineering — Cap. 2 (revisita), pp. 89–92
- **Dia 4:** AI Engineering — Cap. 2 (revisita), pp. 93–96
- **Dia 5:** documentação / revisão guiada — **OpenAI / Gemini multimodal docs do provider adotado** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Conectar front-end ao backend de RAG/chat com streaming opcional.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): busca-semantica-e-chat-de-suporte-na-interface`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Busca semântica e chat de suporte na interface` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Tela conversacional básica.

---
## Semana 064 — Entrega 6 — Feature multimodal com UI

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 6 — feature multimodal com ui**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 2 (revisita), pp. 97–100
- **Dia 2:** AI Engineering — Cap. 2 (revisita), pp. 101–104
- **Dia 3:** AI Engineering — Cap. 2 (revisita), pp. 105–108
- **Dia 4:** AI Engineering — Cap. 2 (revisita), pp. 109–112
- **Dia 5:** documentação / revisão guiada — **Guias de design assistido por IA para front-end (foco prático, não mágico)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Apresentar um fluxo completo do usuário com backend, UI e IA.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-6---feature-multimodal-com-ui`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 6 — Feature multimodal com UI` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Feature multimodal demonstrável.

---

# Módulo 9 — Ferramentas de IA para DevOps: IaC, Kubernetes e Troubleshooting

**Resultado do módulo:** Acoplar IA à operação sem abrir mão de validação, reversibilidade e observabilidade.

## Semana 065 — Fundamentos de IA generativa para infraestrutura

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q5  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **fundamentos de ia generativa para infraestrutura**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 6, pp. 260–264
- **Dia 2:** Designing Machine Learning Systems — Cap. 6, pp. 265–269
- **Dia 3:** Designing Machine Learning Systems — Cap. 6, pp. 270–274
- **Dia 4:** Designing Machine Learning Systems — Cap. 6, pp. 275–279
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry docs — collector, traces e signals** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Mapear oportunidades reais de IA no seu fluxo DevOps sem cair em hype.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): fundamentos-de-ia-generativa-para-infraestrutura`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Fundamentos de IA generativa para infraestrutura` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Backlog de automações DevOps com IA.

### Checkpoint trimestral
- Releia ADRs, limpe backlog técnico, atualize README e anote as 3 decisões mais importantes do trimestre.
- Rode uma demo de ponta a ponta e marque os gargalos de produto, engenharia e operação.

---
## Semana 066 — IaC Copilot para Terraform/Pulumi/Helm

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **iac copilot para terraform/pulumi/helm**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 6, pp. 280–284
- **Dia 2:** Designing Machine Learning Systems — Cap. 6, pp. 285–289
- **Dia 3:** Designing Machine Learning Systems — Cap. 6, pp. 290–294
- **Dia 4:** Designing Machine Learning Systems — Cap. 6, pp. 295–299
- **Dia 5:** documentação / revisão guiada — **Kubernetes docs oficiais (objetos básicos, probes, autoscaling)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Gerar um módulo Terraform simples e validá-lo com revisão humana.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): iac-copilot-para-terraform-pulumi-helm`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `IaC Copilot para Terraform/Pulumi/Helm` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- IaC copilot v1.

---
## Semana 067 — Policy-as-Code e validação automatizada

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **policy-as-code e validação automatizada**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 6, pp. 300–304
- **Dia 2:** Designing Machine Learning Systems — Cap. 6, pp. 305–309
- **Dia 3:** Designing Machine Learning Systems — Cap. 6, pp. 310–314
- **Dia 4:** Designing Machine Learning Systems — Cap. 6, p. 315 + Machine Learning Design Patterns — Cap. 5, pp. 201–204
- **Dia 5:** documentação / revisão guiada — **Argo CD / Flux docs (visão geral de GitOps)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar Checkov/OPA e explicar violações em linguagem natural.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): policy-as-code-e-validacao-automatizada`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Policy-as-Code e validação automatizada` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Validação de políticas integrada.

---
## Semana 068 — Agentes para Kubernetes: manifests, HPA, VPA e ingress

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **agentes para kubernetes: manifests, hpa, vpa e ingress**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 5, pp. 205–209
- **Dia 2:** Machine Learning Design Patterns — Cap. 5, pp. 210–214
- **Dia 3:** Machine Learning Design Patterns — Cap. 5, pp. 215–219
- **Dia 4:** Machine Learning Design Patterns — Cap. 5, pp. 220–224
- **Dia 5:** documentação / revisão guiada — **Checkov / OPA / Sentinel / policy-as-code docs** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar um fluxo que gere e revise manifests para uma app simples.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): agentes-para-kubernetes-manifests-hpa-vpa-e-ingres`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Agentes para Kubernetes: manifests, HPA, VPA e ingress` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- K8s copilot v1.

---
## Semana 069 — GitOps, rollout e rollback guiados

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **gitops, rollout e rollback guiados**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 5, pp. 225–229
- **Dia 2:** Machine Learning Design Patterns — Cap. 5, pp. 230–234
- **Dia 3:** Machine Learning Design Patterns — Cap. 5, pp. 235–239
- **Dia 4:** Machine Learning Design Patterns — Cap. 5, pp. 240–244
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry docs — collector, traces e signals** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Desenhar um pipeline GitOps com aprovação e rollback assistido.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): gitops-rollout-e-rollback-guiados`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `GitOps, rollout e rollback guiados` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- ADR de rollout inteligente.

---
## Semana 070 — Troubleshooting com ReAct

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **troubleshooting com react**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 5, pp. 245–248
- **Dia 2:** AI Engineering — Cap. 9, pp. 405–408
- **Dia 3:** AI Engineering — Cap. 9, pp. 409–412
- **Dia 4:** AI Engineering — Cap. 9, pp. 413–416
- **Dia 5:** documentação / revisão guiada — **Kubernetes docs oficiais (objetos básicos, probes, autoscaling)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Simular erro de pod e guiar o agente por investigação estruturada.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): troubleshooting-com-react`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Troubleshooting com ReAct` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Diagnóstico automatizado v1.

---
## Semana 071 — Root cause analysis com logs, métricas e traces

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **root cause analysis com logs, métricas e traces**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 9, pp. 417–420
- **Dia 2:** AI Engineering — Cap. 9, pp. 421–424
- **Dia 3:** AI Engineering — Cap. 9, pp. 425–428
- **Dia 4:** AI Engineering — Cap. 9, pp. 429–432
- **Dia 5:** documentação / revisão guiada — **Argo CD / Flux docs (visão geral de GitOps)** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Correlacionar um incidente simples usando dados observáveis.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): root-cause-analysis-com-logs-metricas-e-traces`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Root cause analysis com logs, métricas e traces` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Relatório RCA assistido por IA.

---
## Semana 072 — Entrega 7 — Ops Copilot v1

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 7 — ops copilot v1**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 9, pp. 433–436
- **Dia 2:** AI Engineering — Cap. 9, pp. 437–440
- **Dia 3:** AI Engineering — Cap. 9, pp. 441–444
- **Dia 4:** AI Engineering — Cap. 9, pp. 445–448
- **Dia 5:** documentação / revisão guiada — **Checkov / OPA / Sentinel / policy-as-code docs** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Demonstrar geração de IaC/K8s e investigação de incidente com salvaguardas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-7---ops-copilot-v1`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 7 — Ops Copilot v1` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Coprocessador DevOps funcional.

---

# Módulo 10 — AIOps, ChatOps, Segurança, CI/CD e FinOps

**Resultado do módulo:** Fechar o ciclo operacional: medir, alertar, aprovar, agir e comprovar resultado.

## Semana 073 — AIOps e detecção de anomalias

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **aiops e detecção de anomalias**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6, pp. 249–253
- **Dia 2:** Machine Learning Design Patterns — Cap. 6, pp. 254–258
- **Dia 3:** Machine Learning Design Patterns — Cap. 6, pp. 259–263
- **Dia 4:** Machine Learning Design Patterns — Cap. 6, pp. 264–268
- **Dia 5:** documentação / revisão guiada — **NIST AI RMF e perfil para GenAI / trustworthy AI** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar um detector simples de desvio em métricas-chave do sistema.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): aiops-e-deteccao-de-anomalias`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `AIOps e detecção de anomalias` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Anomaly detector v1.

---
## Semana 074 — PromQL/LogQL/Grafana assistidos por IA

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **promql/logql/grafana assistidos por ia**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6, pp. 269–273
- **Dia 2:** Machine Learning Design Patterns — Cap. 6, pp. 274–278
- **Dia 3:** Machine Learning Design Patterns — Cap. 6, pp. 279–283
- **Dia 4:** Machine Learning Design Patterns — Cap. 6, pp. 284–288
- **Dia 5:** documentação / revisão guiada — **OWASP Top 10 for LLM Applications 2025** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Gerar consultas a partir de linguagem natural e revisar manualmente.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): promql-logql-grafana-assistidos-por-ia`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `PromQL/LogQL/Grafana assistidos por IA` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Biblioteca de queries úteis.

---
## Semana 075 — ChatOps com aprovação humana

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **chatops com aprovação humana**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6, pp. 289–293
- **Dia 2:** Machine Learning Design Patterns — Cap. 6, pp. 294–298
- **Dia 3:** Machine Learning Design Patterns — Cap. 6, pp. 299–303
- **Dia 4:** Machine Learning Design Patterns — Cap. 6, pp. 304–308
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — evals e model optimization** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Modelar comandos seguros como `/investigar`, `/rollback` e `/deploy`.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): chatops-com-aprovacao-humana`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `ChatOps com aprovação humana` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Fluxo ChatOps seguro.

---
## Semana 076 — Segurança para apps com LLMs

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **segurança para apps com llms**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 6, pp. 309–313
- **Dia 2:** Machine Learning Design Patterns — Cap. 6, pp. 314–318
- **Dia 3:** AI Engineering — Cap. 9 (revisita), pp. 405–409
- **Dia 4:** AI Engineering — Cap. 9 (revisita), pp. 410–414
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry / Grafana / Prometheus docs** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Testar prompt injection, abuso de tools e saída insegura.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): seguranca-para-apps-com-llms`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Segurança para apps com LLMs` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Checklist de riscos LLM.

---
## Semana 077 — CI/CD copilot e análise de impacto em PRs

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **ci/cd copilot e análise de impacto em prs**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 9 (revisita), pp. 415–418
- **Dia 2:** AI Engineering — Cap. 9 (revisita), pp. 419–422
- **Dia 3:** AI Engineering — Cap. 9 (revisita), pp. 423–426
- **Dia 4:** AI Engineering — Cap. 9 (revisita), pp. 427–430
- **Dia 5:** documentação / revisão guiada — **NIST AI RMF e perfil para GenAI / trustworthy AI** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar job de CI que roda evals, testes e checagens de segurança para features de IA.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): ci-cd-copilot-e-analise-de-impacto-em-prs`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `CI/CD copilot e análise de impacto em PRs` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Pipeline inteligente v1.

---
## Semana 078 — FinOps, custo por request e forecast

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q6  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **finops, custo por request e forecast**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 9 (revisita), pp. 431–434
- **Dia 2:** AI Engineering — Cap. 9 (revisita), pp. 435–438
- **Dia 3:** AI Engineering — Cap. 9 (revisita), pp. 439–442
- **Dia 4:** AI Engineering — Cap. 9 (revisita), pp. 443–446
- **Dia 5:** documentação / revisão guiada — **OWASP Top 10 for LLM Applications 2025** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Estimar custo por rota/cenário e testar model tiering.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): finops-custo-por-request-e-forecast`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `FinOps, custo por request e forecast` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Painel simples de custos.

### Checkpoint trimestral
- Releia ADRs, limpe backlog técnico, atualize README e anote as 3 decisões mais importantes do trimestre.
- Rode uma demo de ponta a ponta e marque os gargalos de produto, engenharia e operação.

---
## Semana 079 — RAG de runbooks e post-mortems

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **rag de runbooks e post-mortems**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 9 (revisita), pp. 447–448 + NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 1–2
- **Dia 2:** NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 3–6
- **Dia 3:** NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 7–10
- **Dia 4:** NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 11–14
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — evals e model optimization** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Indexar runbooks operacionais e responder perguntas com citações.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): rag-de-runbooks-e-post-mortems`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `RAG de runbooks e post-mortems` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Assistente operacional v2.

---
## Semana 080 — Entrega 8 — Auto-remediação segura

**Nível-alvo:** Avançado (pleno → sênior)  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 8 — auto-remediação segura**.

### Leitura diária
- **Dia 1:** NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 15–18
- **Dia 2:** NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 19–22
- **Dia 3:** NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 23–26
- **Dia 4:** NIST AI RMF GenAI Profile / AI RMF 1.0 (trechos orientativos), pp. 27–30
- **Dia 5:** documentação / revisão guiada — **OpenTelemetry / Grafana / Prometheus docs** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Simular alerta → análise → proposta → aprovação → execução → validação.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Trate confiabilidade, segurança, observabilidade e governança como requisitos de primeira classe.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-8---auto-remediacao-segura`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 8 — Auto-remediação segura` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Fluxo de mitigação assistida.

---

# Módulo 11 — IA para Gestão de Projetos, Processos e Governança Operacional

**Resultado do módulo:** Mostrar que engenharia de IA também precisa melhorar processo, rastreabilidade e comunicação.

## Semana 081 — Requirements Copilot: épicos, histórias e critérios de aceite

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **requirements copilot: épicos, histórias e critérios de aceite**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 10 (revisita), pp. 449–452
- **Dia 2:** AI Engineering — Cap. 10 (revisita), pp. 453–456
- **Dia 3:** AI Engineering — Cap. 10 (revisita), pp. 457–460
- **Dia 4:** AI Engineering — Cap. 10 (revisita), pp. 461–464
- **Dia 5:** documentação / revisão guiada — **Guias das plataformas que você usar: Jira / Notion / Slack / Trello** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar um fluxo NL → épico → histórias → critérios de aceite.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): requirements-copilot-epicos-historias-e-criterios-`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Requirements Copilot: épicos, histórias e critérios de aceite` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Requirements copilot v1.

---
## Semana 082 — Priorização inteligente de backlog

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **priorização inteligente de backlog**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 10 (revisita), pp. 465–468
- **Dia 2:** AI Engineering — Cap. 10 (revisita), pp. 469–472
- **Dia 3:** AI Engineering — Cap. 10 (revisita), pp. 473–476
- **Dia 4:** AI Engineering — Cap. 10 (revisita), pp. 477–480
- **Dia 5:** documentação / revisão guiada — **OpenAI / Anthropic docs sobre structured output e tool calling** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar um scorer simples com RICE/WSJF assistido por IA.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): priorizacao-inteligente-de-backlog`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Priorização inteligente de backlog` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Backlog scorer.

---
## Semana 083 — Cronograma, capacidade e cenários what-if

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **cronograma, capacidade e cenários what-if**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 10 (revisita), pp. 481–484
- **Dia 2:** AI Engineering — Cap. 10 (revisita), pp. 485–488
- **Dia 3:** AI Engineering — Cap. 10 (revisita), pp. 489–492
- **Dia 4:** AI Engineering — Cap. 10 (revisita), pp. 493–494 + Designing Machine Learning Systems — Cap. 1 (revisita), pp. 1–2
- **Dia 5:** documentação / revisão guiada — **NIST AI RMF — governança e rastreabilidade** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Gerar um cronograma dinâmico para um backlog pequeno e simular restrições.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): cronograma-capacidade-e-cenarios-what-if`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Cronograma, capacidade e cenários what-if` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Simulador de capacidade.

---
## Semana 084 — Estimativas e previsões

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **estimativas e previsões**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 3–6
- **Dia 2:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 7–10
- **Dia 3:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 11–14
- **Dia 4:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 15–18
- **Dia 5:** documentação / revisão guiada — **Spring AI docs para integrações com tools** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Comparar estimativa humana vs assistida por IA e registrar divergências.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): estimativas-e-previsoes`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Estimativas e previsões` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Matriz de estimativas.

---
## Semana 085 — Riscos e mitigação automatizados

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **riscos e mitigação automatizados**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 19–22
- **Dia 2:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 23–26
- **Dia 3:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 27–30
- **Dia 4:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 31–34
- **Dia 5:** documentação / revisão guiada — **Guias das plataformas que você usar: Jira / Notion / Slack / Trello** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Classificar riscos de escopo, prazo e dependências com explicações.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): riscos-e-mitigacao-automatizados`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Riscos e mitigação automatizados` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Risk board assistido por IA.

---
## Semana 086 — Notas de reunião, follow-ups e automação de ações

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **notas de reunião, follow-ups e automação de ações**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 35–38
- **Dia 2:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 39–42
- **Dia 3:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 43–46
- **Dia 4:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 47–50
- **Dia 5:** documentação / revisão guiada — **OpenAI / Anthropic docs sobre structured output e tool calling** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Processar uma ata/reunião e extrair decisões + tarefas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): notas-de-reuniao-follow-ups-e-automacao-de-acoes`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Notas de reunião, follow-ups e automação de ações` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Meeting copilot.

---
## Semana 087 — Status reports, compliance e automação em boards

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **status reports, compliance e automação em boards**.

### Leitura diária
- **Dia 1:** Designing Machine Learning Systems — Cap. 1 (revisita), pp. 51–52 + Machine Learning Design Patterns — Cap. 8, pp. 359–360
- **Dia 2:** Machine Learning Design Patterns — Cap. 8, pp. 361–364
- **Dia 3:** Machine Learning Design Patterns — Cap. 8, pp. 365–367
- **Dia 4:** Machine Learning Design Patterns — Cap. 8, pp. 368–370
- **Dia 5:** documentação / revisão guiada — **NIST AI RMF — governança e rastreabilidade** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Gerar um resumo executivo e um resumo técnico a partir dos mesmos dados.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): status-reports-compliance-e-automacao-em-boards`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Status reports, compliance e automação em boards` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Duas camadas de comunicação.

---
## Semana 088 — Entrega 9 — PM Copilot

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 9 — pm copilot**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 8, pp. 371–373
- **Dia 2:** Machine Learning Design Patterns — Cap. 8, pp. 374–376
- **Dia 3:** Machine Learning Design Patterns — Cap. 8, pp. 377–379
- **Dia 4:** Machine Learning Design Patterns — Cap. 8, pp. 380–382
- **Dia 5:** documentação / revisão guiada — **Spring AI docs para integrações com tools** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Demonstrar um mini fluxo de gestão de projeto assistido por IA.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-9---pm-copilot`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 9 — PM Copilot` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Módulo de produtividade para engenharia/gestão.

---

# Módulo 12 — Arquitetura AI-First, Fine-Tuning e Dados para Modelos

**Resultado do módulo:** Conectar arquitetura, dados e tuning sem perder custo, segurança e capacidade de operação.

## Semana 089 — Arquiteturas AI-first e framework de decisão

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **arquiteturas ai-first e framework de decisão**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 7, pp. 307–313
- **Dia 2:** AI Engineering — Cap. 7, pp. 314–320
- **Dia 3:** AI Engineering — Cap. 7, pp. 321–327
- **Dia 4:** AI Engineering — Cap. 7, pp. 328–334
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — supervised fine-tuning / best practices** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Escrever um decision framework: regra determinística vs prompt vs RAG vs fine-tuning vs agent.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): arquiteturas-ai-first-e-framework-de-decisao`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Arquiteturas AI-first e framework de decisão` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- ADR de arquitetura AI-first.

---
## Semana 090 — Single-agent, multi-agent e roteamento de modelos

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **single-agent, multi-agent e roteamento de modelos**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 7, pp. 335–341
- **Dia 2:** AI Engineering — Cap. 7, pp. 342–348
- **Dia 3:** AI Engineering — Cap. 7, pp. 349–355
- **Dia 4:** AI Engineering — Cap. 7, pp. 356–362
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — model optimization** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Implementar um model router simples por custo/latência/criticidade.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): single-agent-multi-agent-e-roteamento-de-modelos`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Single-agent, multi-agent e roteamento de modelos` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Model routing v1.

---
## Semana 091 — Caching semântico, prompt cache e model tiering

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q7  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **caching semântico, prompt cache e model tiering**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 8, pp. 363–369
- **Dia 2:** AI Engineering — Cap. 8, pp. 370–376
- **Dia 3:** AI Engineering — Cap. 8, pp. 377–383
- **Dia 4:** AI Engineering — Cap. 8, pp. 384–390
- **Dia 5:** documentação / revisão guiada — **Vertex AI / provider docs — tuning overview e LoRA/PEFT contexto** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Adicionar camadas de cache e decidir políticas de invalidação.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): caching-semantico-prompt-cache-e-model-tiering`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Caching semântico, prompt cache e model tiering` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Cache strategy documentada.

### Checkpoint trimestral
- Releia ADRs, limpe backlog técnico, atualize README e anote as 3 decisões mais importantes do trimestre.
- Rode uma demo de ponta a ponta e marque os gargalos de produto, engenharia e operação.

---
## Semana 092 — Enterprise architecture: gateway, orchestration, observability, policy

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **enterprise architecture: gateway, orchestration, observability, policy**.

### Leitura diária
- **Dia 1:** AI Engineering — Cap. 8, pp. 391–397
- **Dia 2:** AI Engineering — Cap. 8, pp. 398–404
- **Dia 3:** Hands-On LLMs — Cap. 10 (estimado), pp. 323–329
- **Dia 4:** Hands-On LLMs — Cap. 10 (estimado), pp. 330–336
- **Dia 5:** documentação / revisão guiada — **Spring AI docs — advisors, structured outputs, observability e deployment** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Desenhar a arquitetura completa do produto em produção.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): enterprise-architecture-gateway-orchestration-obse`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Enterprise architecture: gateway, orchestration, observability, policy` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Diagrama de arquitetura v2.

---
## Semana 093 — Quando fazer fine-tuning e quando não fazer

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **quando fazer fine-tuning e quando não fazer**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 10 (estimado), pp. 337–342
- **Dia 2:** Hands-On LLMs — Cap. 10 (estimado), p. 343 + Hands-On LLMs — Cap. 11 (estimado), pp. 344–348
- **Dia 3:** Hands-On LLMs — Cap. 11 (estimado), pp. 349–354
- **Dia 4:** Hands-On LLMs — Cap. 11 (estimado), pp. 355–360
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — supervised fine-tuning / best practices** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Comparar 3 casos reais do produto e decidir: prompt, RAG ou tune.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): quando-fazer-fine-tuning-e-quando-nao-fazer`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Quando fazer fine-tuning e quando não fazer` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Matriz de decisão de tuning.

---
## Semana 094 — Preparação de datasets e JSONL

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **preparação de datasets e jsonl**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 11 (estimado), pp. 361–366
- **Dia 2:** Hands-On LLMs — Cap. 11 (estimado), pp. 367–370 + Machine Learning Design Patterns — Cap. 4, pp. 139–140
- **Dia 3:** Machine Learning Design Patterns — Cap. 4, pp. 141–146
- **Dia 4:** Machine Learning Design Patterns — Cap. 4, pp. 147–152
- **Dia 5:** documentação / revisão guiada — **OpenAI Developers — model optimization** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar dataset limpo e versionado para um domínio específico.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): preparacao-de-datasets-e-jsonl`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Preparação de datasets e JSONL` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Dataset v1 pronto para treino.

---
## Semana 095 — SFT, LoRA e PEFT

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **sft, lora e peft**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 4, pp. 153–158
- **Dia 2:** Machine Learning Design Patterns — Cap. 4, pp. 159–164
- **Dia 3:** Machine Learning Design Patterns — Cap. 4, pp. 165–170
- **Dia 4:** Machine Learning Design Patterns — Cap. 4, pp. 171–176
- **Dia 5:** documentação / revisão guiada — **Vertex AI / provider docs — tuning overview e LoRA/PEFT contexto** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Executar um experimento pequeno de tuning (API comercial ou ambiente controlado) e registrar custo/ganho.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): sft-lora-e-peft`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `SFT, LoRA e PEFT` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Experimento de tuning documentado.

---
## Semana 096 — Entrega 10 — Modelo customizado + arquitetura consolidada

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **entrega 10 — modelo customizado + arquitetura consolidada**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 4, pp. 177–182
- **Dia 2:** Machine Learning Design Patterns — Cap. 4, pp. 183–188
- **Dia 3:** Machine Learning Design Patterns — Cap. 4, pp. 189–194
- **Dia 4:** Machine Learning Design Patterns — Cap. 4, pp. 195–200
- **Dia 5:** documentação / revisão guiada — **Spring AI docs — advisors, structured outputs, observability e deployment** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Integrar a abordagem escolhida ao backend e comparar com baseline.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): entrega-10---modelo-customizado-arquitetura-consol`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Entrega 10 — Modelo customizado + arquitetura consolidada` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Módulo tunado/avaliado entregue.

---

# Módulo 13 — Segurança, Governança, Capstone e Entrevistas

**Resultado do módulo:** Fechar a trilha com um artefato real de mercado: arquitetura defendível, demo, documentação e narrativa profissional.

## Semana 097 — Governança em IA, interpretabilidade e explicabilidade

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **governança em ia, interpretabilidade e explicabilidade**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 12 (estimado), pp. 371–375
- **Dia 2:** Hands-On LLMs — Cap. 12 (estimado), pp. 376–379
- **Dia 3:** Hands-On LLMs — Cap. 12 (estimado), pp. 380–383
- **Dia 4:** Hands-On LLMs — Cap. 12 (estimado), pp. 384–387
- **Dia 5:** documentação / revisão guiada — **NIST AI RMF** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Criar checklist de governança para o seu produto e mapear lacunas.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): governanca-em-ia-interpretabilidade-e-explicabilid`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Governança em IA, interpretabilidade e explicabilidade` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Governance checklist v1.

---
## Semana 098 — OWASP para LLMs, prompt injection e red teaming

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **owasp para llms, prompt injection e red teaming**.

### Leitura diária
- **Dia 1:** Hands-On LLMs — Cap. 12 (estimado), pp. 388–391
- **Dia 2:** Machine Learning Design Patterns — Cap. 7, pp. 319–322
- **Dia 3:** Machine Learning Design Patterns — Cap. 7, pp. 323–326
- **Dia 4:** Machine Learning Design Patterns — Cap. 7, pp. 327–330
- **Dia 5:** documentação / revisão guiada — **OWASP Top 10 for LLM Applications 2025** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Rodar testes adversariais simples contra seu sistema.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): owasp-para-llms-prompt-injection-e-red-teaming`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `OWASP para LLMs, prompt injection e red teaming` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Relatório de riscos e mitigação.

---
## Semana 099 — Custos, compliance, aspectos humanos e legais

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **custos, compliance, aspectos humanos e legais**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 7, pp. 331–334
- **Dia 2:** Machine Learning Design Patterns — Cap. 7, pp. 335–338
- **Dia 3:** Machine Learning Design Patterns — Cap. 7, pp. 339–342
- **Dia 4:** Machine Learning Design Patterns — Cap. 7, pp. 343–346
- **Dia 5:** documentação / revisão guiada — **MCP / Spring AI deployment and security notes** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Definir limites de custo, retenção de dados e política de uso.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): custos-compliance-aspectos-humanos-e-legais`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Custos, compliance, aspectos humanos e legais` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Política operacional de IA.

---
## Semana 100 — Capstone: ideação final e arquitetura do micro-SaaS

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **capstone: ideação final e arquitetura do micro-saas**.

### Leitura diária
- **Dia 1:** Machine Learning Design Patterns — Cap. 7, pp. 347–350
- **Dia 2:** Machine Learning Design Patterns — Cap. 7, pp. 351–354
- **Dia 3:** Machine Learning Design Patterns — Cap. 7, pp. 355–358
- **Dia 4:** NIST AI RMF 1.0 / GenAI Profile (trechos), pp. 31–34
- **Dia 5:** documentação / revisão guiada — **OpenAI / Anthropic / provider usage policies e guias técnicos relevantes** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Selecionar o escopo final, backlog e milestones do capstone.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): capstone-ideacao-final-e-arquitetura-do-micro-saas`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Capstone: ideação final e arquitetura do micro-SaaS` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Plano do capstone aprovado.

---
## Semana 101 — Capstone sprint 1 — core intelligence

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **capstone sprint 1 — core intelligence**.

### Leitura diária
- **Dia 1:** NIST AI RMF 1.0 / GenAI Profile (trechos), pp. 35–38
- **Dia 2:** NIST AI RMF 1.0 / GenAI Profile (trechos), pp. 39–42
- **Dia 3:** NIST AI RMF 1.0 / GenAI Profile (trechos), pp. 43–46
- **Dia 4:** NIST AI RMF 1.0 / GenAI Profile (trechos), pp. 47–50
- **Dia 5:** documentação / revisão guiada — **NIST AI RMF** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Consolidar RAG/agent/tuning no fluxo principal do produto.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): capstone-sprint-1---core-intelligence`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Capstone sprint 1 — core intelligence` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Core funcional do capstone.

---
## Semana 102 — Capstone sprint 2 — UI, MCP, deploy e CI/CD

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **capstone sprint 2 — ui, mcp, deploy e ci/cd**.

### Leitura diária
- **Dia 1:** NIST AI RMF 1.0 / GenAI Profile (trechos), pp. 51–54
- **Dia 2:** NIST AI RMF 1.0 / GenAI Profile (trechos), p. 55 + OWASP Top 10 for LLM Apps 2025 (trechos), pp. 1–3
- **Dia 3:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 4–7
- **Dia 4:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 8–11
- **Dia 5:** documentação / revisão guiada — **OWASP Top 10 for LLM Applications 2025** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Publicar uma versão implantada com docs e demo.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): capstone-sprint-2---ui-mcp-deploy-e-ci-cd`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Capstone sprint 2 — UI, MCP, deploy e CI/CD` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Solução completa implantada.

---
## Semana 103 — Portfólio, storytelling, RH e entrevistas técnicas

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **portfólio, storytelling, rh e entrevistas técnicas**.

### Leitura diária
- **Dia 1:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 12–15
- **Dia 2:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 16–19
- **Dia 3:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 20–23
- **Dia 4:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 24–27
- **Dia 5:** documentação / revisão guiada — **MCP / Spring AI deployment and security notes** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Preparar README, apresentação e respostas STAR para o projeto.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): portfolio-storytelling-rh-e-entrevistas-tecnicas`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Portfólio, storytelling, RH e entrevistas técnicas` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Pacote de portfólio.

---
## Semana 104 — Semana 104 — defesa técnica final

**Nível-alvo:** Sênior / Staff readiness  
**Fase:** Q8  
**Objetivo da semana:** avançar o `SignalDesk AI` no eixo **semana 104 — defesa técnica final**.

### Leitura diária
- **Dia 1:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 28–31
- **Dia 2:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 32–35
- **Dia 3:** OWASP Top 10 for LLM Apps 2025 (trechos), pp. 36–39
- **Dia 4:** OWASP Top 10 for LLM Apps 2025 (trechos), p. 40 + AI Engineering — Epilogue / revisão, pp. 495–497
- **Dia 5:** documentação / revisão guiada — **OpenAI / Anthropic / provider usage policies e guias técnicos relevantes** *(equivalente a 6–10 páginas)*

### Prática aplicada (sábado)
- Fazer um mock interview completo cobrindo arquitetura, trade-offs, segurança e custos.
- Registrar no Obsidian o que mudou, o que quebrou, como você validou e o que ainda ficou ambíguo.

### Exercícios da semana
- **Exercício 1:** transformar a prática principal em uma entrega pequena, testável e revertível.
- **Exercício 2:** escrever uma nota `trade-offs.md` respondendo: _por que esta solução e não a segunda melhor opção?_
- **Desafio progressivo:** Defenda arquitetura, custo, rollout, risco operacional e evolução do produto como um engenheiro sênior.

### PR da semana
- **Título sugerido:** `feat(ai): semana-104---defesa-tecnica-final`
- Incluir no PR: contexto, decisão adotada, alternativas rejeitadas, testes, métricas, riscos e rollback.
- Tente manter o escopo pequeno o suficiente para revisão humana de qualidade.

### Perguntas de entrevista
- Explique `Semana 104 — defesa técnica final` e cite 2 trade-offs práticos de implementação.
- Como você mediria sucesso aqui em termos de custo, latência, qualidade e segurança?

### Entregável mínimo
- Capstone defendido e pronto para o mercado.

---

# Apêndice A — Como estudar por dia

## Modelo de segunda a sexta
- **Segunda:** leitura + nota curta
- **Terça:** leitura + experimento pequeno
- **Quarta:** leitura + refatoração
- **Quinta:** leitura + teste/avaliação
- **Sexta:** documentação oficial + consolidação das notas

## Modelo de sábado
- bloco mais longo para implementação
- abrir PR local / branch
- atualizar README, ADRs e screenshots
- medir o que mudou

## Modelo de domingo
- revisão leve
- reorganizar notas do Obsidian
- ajustar backlog da próxima semana
- descansar

---

# Apêndice B — Estrutura sugerida do repositório

```text
signaldesk-ai/
  backend/
    src/main/java/...
    src/test/java/...
  infra/
    docker/
    terraform/
    k8s/
  prompts/
  evals/
    datasets/
    rubrics/
    reports/
  docs/
    adrs/
    diagrams/
    runbooks/
  notebooks/
  frontend/
  mcp/
```

---

# Apêndice C — Estrutura sugerida de notas no Obsidian

```text
00-index/
01-weekly/
02-books/
03-concepts/
04-adrs/
05-interviews/
06-capstone/
07-retrospectives/
```

## Template de nota semanal

```md
# Semana XXX
## O que li
## O que implementei
## O que quebrou
## O que medi
## Decisões e trade-offs
## Perguntas de entrevista
## Próximo passo
```

---

# Apêndice D — Critérios de prontidão ao final de 2 anos

Você deve ser capaz de:

- discutir **RAG vs fine-tuning vs agents** sem responder no piloto automático;
- integrar IA a um backend **Java/Spring** com testes, retries, observabilidade e controle de custo;
- construir e expor **MCP servers/clients** com segurança básica;
- desenhar workflows com **LangGraph / stateful orchestration**;
- operar sistemas com **evals, métricas, tracing, logs e guardrails**;
- justificar arquitetura AI-first em termos de **latência, precisão, custo, risco e manutenção**;
- apresentar um **capstone deployado**, com README, demo, ADRs e defesa técnica.

---

# Apêndice E — Observações honestas sobre as leituras

- **AI Engineering** e **Machine Learning Design Patterns** têm faixas de páginas mais estáveis.
- **Designing Machine Learning Systems** pode variar conforme a edição consultada; as faixas aqui foram planejadas para um ritmo seguro.
- **Hands-On Large Language Models** possui alguns trechos com paginação/edições que variam conforme preview/edição; por isso as faixas marcadas como **estimadas** devem ser tratadas como guia, não como contrato.
- Quando a documentação oficial mudar, **prefira a documentação atual** ao cronograma literal.
