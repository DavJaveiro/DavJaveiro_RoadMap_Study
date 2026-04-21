# Chapter 1 - Introduction to Building AI Applications with Foundation Models

## 🚀 Escala da IA (pós-2020)
- Modelos gigantes (LLMs)
- Alto consumo de energia e dados
- Dois efeitos principais:
  - + capacidade → mais aplicações
  - + centralização → poucos players treinam modelos
- Surgimento de:
  - Model as a Service (API)
  - AI Engineering (nova disciplina)

## 🤖 AI Engineering
- Construção de aplicações sobre modelos prontos
- Diferença de ML tradicional:
  - ML: treinar modelos
  - AI Engineering: adaptar modelos
- Técnicas principais:
  - Prompt Engineering
  - RAG (Retrieval-Augmented Generation)
  - Finetuning :contentReference[oaicite:0]{index=0}

## 🧩 Evolução dos Modelos

### 📜 Language Models
- Base estatística da linguagem
- Unidade: Token
- Tipos:
  - Masked (ex: BERT)
  - Autoregressive (ex: GPT)
- Função:
  - Completar texto (completion)
- Natureza:
  - Probabilística
  - Generativa

### 🔁 Self-Supervision
- Não precisa de dados rotulados
- Dados vêm do próprio texto
- Permite:
  - Escalar modelos massivamente
- Diferença:
  - Self-supervised ≠ Unsupervised

### 🧠 Large Language Models (LLMs)
- Crescimento por:
  - Mais parâmetros
  - Mais dados
- Exemplo:
  - GPT-1 → 117M
  - GPT-2 → 1.5B
  - Hoje → 100B+

### 🌐 Foundation Models
- General-purpose
- Multimodais:
  - Texto
  - Imagem
  - Vídeo
- Exemplo:
  - GPT-4V
  - Gemini
- Conceitos:
  - Embeddings
  - Multimodalidade
- Mudança:
  - De modelos específicos → modelos gerais :contentReference[oaicite:1]{index=1}

## 🏗️ AI Engineering Stack

### 1. Application Layer
- Prompting
- UX/UI
- Avaliação
- Casos:
  - Chatbots
  - Copilots

### 2. Model Layer
- Treinamento
- Fine-tuning
- Dataset engineering

### 3. Infrastructure Layer
- Serving
- GPU / compute
- Monitoramento :contentReference[oaicite:2]{index=2}

## 📊 Casos de Uso

### 💻 Coding
- Code generation
- Debug
- Testes
- Tradução de código

### 🎨 Criatividade
- Imagens (Midjourney)
- Vídeos (Runway)
- Marketing

### ✍️ Escrita
- Emails
- SEO
- Documentos

### 🎓 Educação
- Tutoria personalizada
- Geração de exercícios

### 💬 Bots Conversacionais
- Suporte ao cliente
- Assistentes pessoais

### 📚 Informação
- Summarization
- Talk-to-your-docs

### 🗂️ Organização de Dados
- Extração de PDFs
- Busca inteligente

### ⚙️ Automação
- Workflows
- Agentes inteligentes :contentReference[oaicite:3]{index=3}

## ⚡ Fatores do Crescimento da AI Engineering

- Capacidade geral dos modelos
- Investimento massivo
- Baixa barreira de entrada (APIs)

## 🧠 Conceitos Importantes

### 📌 Model Adaptation
- Prompt-based (sem alterar pesos)
- Finetuning (altera pesos)

### 📌 Trade-offs
- Build vs Buy
- Latência vs custo
- Qualidade vs escala

## 🧪 Planejamento de Aplicações

### 🎯 Avaliação de Use Case
- Risco competitivo
- Ganho de produtividade
- Experimentação

### 🤝 Papel da IA
- Complementar vs crítica
- Reativa vs proativa
- Dinâmica vs estática

### 👨‍💻 Human-in-the-loop
- AI sugere → humano decide
- AI parcial → humano revisa
- AI total → automação completa

### 🧱 Defensibilidade
- Tecnologia (fraca)
- Dados (forte)
- Distribuição (muito forte)

## 📈 Métricas

- Qualidade
- Latência
- Custo
- Satisfação do usuário

## 🧗 Desafio do "Last Mile"
- 0 → 60% fácil
- 60 → 100% difícil
- Problemas:
  - Alucinação
  - Ajustes finos

## 🔄 Manutenção

- Modelos mudam rápido
- Custos caem
- APIs evoluem
- Riscos:
  - Regulação
  - Dependência de fornecedores
  - IP

## ⚔️ AI Engineering vs ML Engineering
- Menos foco em treino
- Mais foco em:
  - Adaptação
  - Avaliação
- Problemas novos:
  - Outputs abertos
  - Difícil avaliação
  - Alto custo computacional :contentReference[oaicite:4]{index=4}

# Chapter 2 - Understanding Foundation Models
