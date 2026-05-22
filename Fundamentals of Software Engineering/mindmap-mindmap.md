---

mindmap-plugin: markdown

---


# 🧠 Software Engineering Fundamentals


## 1. From Programmer → Engineer

- Diferença fundamental
    - Programador → foca em escrever código
    - Engenheiro → resolve problemas no sistema como um todo
    - 👉 Engenharia envolve trade-offs (escala, custo, segurança)
- SDLC (visão completa)
    - Não basta codar → precisa entender:
        - requisitos → design → implementação → testes → deploy → manutenção
    - 👉 Valor real está no ciclo completo, não na feature isolada
- Mentalidade de engenharia
    - Pensar além do código:
        - escalabilidade
        - confiabilidade
        - eficiência
        - segurança
- Gap do aprendizado
    - Faculdade/bootcamp:
        - ensinam sintaxe
        - ignoram mundo real
    - Mundo real:
        - sistemas grandes
        - código legado
        - trabalho em equipe
- Realidade do software
    - Software = produto contínuo
    - Nunca “termina”
    - Sempre evolui, corrige, melhora
- Boas práticas
    - Evitar “quick fixes”
    - Entender causa raiz
    - Shift-left:
        - testar cedo
        - detectar bugs antes da produção

## 2. Reading Code (Código existente)

- Realidade importante
    - Você lê mais código do que escreve
    - 👉 habilidade crítica ignorada no ensino
- Tipos de ambiente
    - Greenfield → código novo
    - Brownfield → código existente (realidade)
- Desafios principais
    - Entender domínio de negócio
    - Entender decisões anteriores
    - Lidar com abstrações ruins
    - Navegar dívida técnica
- Código legado
    - Nem sempre é ruim
    - 👉 se está em produção, já entregou valor
- Vieses cognitivos
    - IKEA effect:
        - você acha seu código melhor
    - Familiaridade:
        - apego à linguagem/framework
- Estratégias práticas
    - Ler:
        - README
        - documentação
        - ADRs (decisões arquiteturais)
    - Usar testes como documentação
    - Explorar código via:
        - callers
        - endpoints
    - Executar sistema para entender fluxo
- Regra de ouro
    - Evite reescrever tudo
    - Prefira:
        - refatoração incremental

## 3. Writing Code (Código de qualidade)

- Objetivo real
    - Código é comunicação entre humanos
    - 👉 máquina entende qualquer coisa válida, humano não
- Princípios principais
    - Clareza > inteligência
    - Simplicidade > complexidade
    - Menos código = melhor manutenção
- Reuso antes de criar
    - Ordem de decisão:
        1. Código existente
        2. Linguagem
        3. Framework
        4. Bibliotecas
    - 👉 evitar reinventar roda
- Qualidade estrutural
    - Alta coesão → coisas relacionadas juntas
    - Baixo acoplamento → mudanças isoladas
- Boas práticas
    - Métodos pequenos (uma responsabilidade)
    - Nomes claros (intenção explícita)
    - Evitar comentários desnecessários
        - código deve se explicar
- Design moderno
    - Preferir composição > herança
    - 👉 mais flexível e testável
- Complexidade
    - Essencial → inerente ao problema
    - Acidental → criada pelo dev (evitar)
- Engenharia moderna (2026)
    - Dev não é só criador
    - 👉 é curador e revisor (inclusive de código gerado por IA)
- Code Review
    - Foco em:
        - arquitetura
        - lógica de negócio
    - Não em:
        - estilo (automatizado)

## 4. Modeling (Modelagem)

- Objetivo
    - Comunicar e entender sistemas
    - Reduzir complexidade
- Definição
    - Modelo = abstração do sistema
- Insight importante
    - Código = design final
    - Diagramas = apoio
- Quando usar
    - Planejamento
    - Onboarding
    - Debug
    - Comunicação com stakeholders
- Tipos principais

### Context Diagram

- Visão macro
- Define fronteiras do sistema
- Mostra integrações externas

### Component Diagram

- Estrutura do sistema em runtime
- Como partes interagem

### Class Diagram

- Relação entre classes
- Herança e composição

### Sequence Diagram

- Fluxo de execução
- Interações entre componentes
- Boas práticas
    - Escolher diagrama conforme necessidade
    - Manter atualizado (ou descartar)
    - Não exagerar
- Tendências
    - Diagram as Code
    - Integração com IA e eventos

## 5. Automated Testing

- Ideia central
    - Qualidade é hábito
- Benefícios
    - Testes = documentação viva
    - Aumentam confiança
    - Permitem refatorar sem medo
- Insight importante
    - Testes melhoram design
    - 👉 revelam problemas de arquitetura cedo
- Pirâmide de testes

### Unit Tests

- Testam partes isoladas
- Rápidos e baratos
- Base do sistema

### Integration Tests

- Testam interação entre módulos
- Mais complexos

### End-to-End (E2E)

- Simulam usuário real
- Lentos e frágeis
- Estratégia correta
    - Muitos unitários
    - Poucos E2E
- Boas práticas
    - Testar:
        - lógica de negócio
    - Evitar:
        - frameworks
        - código gerado
    - Usar mocks/stubs
- Cobertura de código
    - Indicador útil
    - Mas pode enganar
- Insight final
    - Sem testes:
        - você programa com medo
    - Com testes:
        - você evolui o sistema com segurança
