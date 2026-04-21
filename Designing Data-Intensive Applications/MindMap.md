# Chapter 1 - Trade-Offs
## 📚 Prefácio & Filosofia Central
- **Premissa fundamental**: "Não existe bala de prata" → tudo tem trade-offs
- **Objetivo do livro**: Ensinar a fazer as perguntas certas para avaliar sistemas
- **Data-intensive applications**: 
  - Desafio principal: gerenciar dados (não apenas computação)
  - Preocupações: armazenar, processar, consistência, disponibilidade
- **Blocos de construção padrão**:
  - `#databases` → persistência
  - `#caches` → acelerar leituras
  - `#search-indexes` → busca/filtro
  - `#stream-processing` → eventos em tempo real
  - `#batch-processing` → processamento periódico

## ⚖️ Operational vs Analytical Systems
### Sistemas Operacionais (OLTP)
- **Propósito**: Servir usuários externos/internos em tempo real
- **Padrão de acesso**: 
  - Consultas pontuais (poucos registros por chave)
  - Leituras/escritas de baixa latência
  - Dados atualizados constantemente
- **Exemplos**: E-commerce, redes sociais, sistemas de reserva

### Sistemas Analíticos (OLAP)
- **Propósito**: Business Intelligence, Data Science, ML
- **Padrão de acesso**:
  - Varredura de muitos registros + agregações
  - Consultas complexas, alta latência aceitável
  - Dados geralmente somente-leitura (cópias derivadas)
- **Exemplos**: Relatórios de receita, análise de campanhas, treinamento de modelos

### Data Warehouse
- **Definição**: Banco separado para análise, com cópia dos dados OLTP
- **ETL/ELT**: Extrair → Transformar → Carregar
- **Vantagens**:
  - Não impacta performance dos sistemas operacionais
  - Esquema otimizado para análise (star/snowflake schemas)
  - Permite consultas arbitrárias de analistas

### Data Lake
- **Definição**: Repositório centralizado de dados "raw" em qualquer formato
- **Diferença para Warehouse**: Sem esquema imposto; arquivos brutos (Parquet, Avro, texto, imagens)
- **Uso típico**: Data Science, ML, processamento distribuído (Spark, Pandas)
- **Princípio do sushi**: "Dados crus são melhores" → cada consumidor transforma conforme necessidade

### Sistemas Híbridos & Tendências
- **HTAP**: Processamento transacional + analítico no mesmo sistema (limitado na prática)
- **Stream Processing**: 
  - Baixa latência (milissegundos)
  - Stateful processing, windowing, exactly-once semantics
  - Perguntas antes de implementar:
    1. "Atrasar 10min/1dia causa dano?" → Se sim, use stream
    2. "Existe sequência de eventos dependentes?" → Stream ajuda
    3. "Tenho equipe/infra para manter?" → Stream exige monitoramento constante
- **Reverse ETL**: Saídas analíticas alimentando sistemas operacionais (ex: modelos ML em produção)

## 🔁 Systems of Record vs Derived Data
### Sistema de Registro (Source of Truth)
- **Características**:
  - Versão autoritativa/canônica dos dados
  - Cada fato representado exatamente uma vez (normalizado)
  - Em caso de discrepância: este valor é o correto por definição
- **Exemplos**: Banco de dados principal de usuários, catálogo de produtos

### Sistema de Dados Derivados
- **Características**:
  - Resultado de transformação/processamento de outra fonte
  - Redundante por natureza, mas essencial para performance
  - Pode ser recriado a partir da fonte original
- **Exemplos**: 
  - `#caches`, índices, visões materializadas
  - Dados desnormalizados, modelos de ML treinados
  - Sistemas analíticos (OLAP), data warehouses

### Insight Arquitetural
> "A distinção não está na ferramenta, mas no uso que você faz dela"
- Clareza sobre derivações simplifica arquitetura
- Evita inconsistências e facilita integrações
- Necessidade de pipelines para propagação de atualizações

## ☁️ Cloud vs Self-Hosting
### Decisão Fundamental: Build or Buy?
- **Regra prática**: 
  - Core competency/vantagem competitiva → construir internamente
  - Não-core, rotineiro, commodity → terceirizar/fornecedor

### Espectro de Opções

### Prós da Nuvem
- ✅ Elasticidade: escala sob demanda, paga pelo uso
- ✅ Menos overhead operacional para cargas variáveis
- ✅ Alta disponibilidade nativa, tolerância a falhas
- ✅ Acesso rápido a serviços especializados (ML, analytics)

### Contras da Nuvem
- ❌ Vendor lock-in: APIs proprietárias, custo de migração
- ❌ Menos controle: debugging difícil, personalizações limitadas
- ❌ Dependência de terceiros: downtime, mudanças de produto
- ❌ Conformidade: dados em jurisdições diferentes, soberania

### Quando Self-Hosting Pode Ser Melhor
- Carga previsível e estável
- Equipe experiente em operação do sistema
- Requisitos de latência extrema (ex: high-frequency trading)
- Conformidade/regulamentação específica

## 🏗️ Cloud Native Architecture
### Definição
> Arquitetura projetada desde o início para aproveitar serviços de nuvem

### Vantagens de Sistemas Cloud Native
- 🚀 Melhor desempenho no mesmo hardware
- 🔄 Recuperação mais rápida de falhas
- 📈 Escalabilidade automática sob carga variável
- 💾 Suporte a datasets maiores via armazenamento distribuído

### Layering de Serviços
- **IaaS**: VMs genéricas → você gerencia SO + aplicação
- **PaaS/Managed**: Banco, cache, fila como serviço → foco na aplicação
- **Abstrações de alto nível**: 
  - `Object Storage` (S3, Blob) → arquivos grandes, durabilidade automática
  - Serviços construídos sobre storage: Snowflake, BigQuery, etc.

### Separação Storage/Compute (Disaggregation)
- **Tradicional**: Mesmo nó = storage + compute (RAID, disco local)
- **Cloud Native**: 
  - Storage: serviços dedicados (S3) → durabilidade, escalabilidade
  - Compute: instâncias efêmeras → stateless, escalável horizontalmente
  - Trade-off: transferência de dados pela rede (latência, custo)

### Multitenancy
- **Definição**: Múltiplos clientes compartilham mesma infraestrutura
- **Benefícios**: Melhor utilização de hardware, custos reduzidos
- **Desafios**: Isolamento de performance, segurança, "noisy neighbor"

## 👨‍💻 Operations in the Cloud Era
### Evolução dos Papéis
- **Tradicional**: DBAs/Sysadmins → gestão de máquinas individuais
- **DevOps/SRE**: 
  - Automação > processos manuais
  - VMs efêmeras > servidores de longa duração
  - Deploy frequente, aprendizado com incidentes
  - Preservação do conhecimento organizacional

### Novas Responsabilidades na Nuvem
- 🎯 Escolha de serviços apropriados para cada caso de uso
- 🔗 Integração entre múltiplos serviços (falta de padrões)
- 💰 Otimização de custos (capacity planning → financial planning)
- 🔐 Segurança da aplicação, bibliotecas, interações entre serviços
- 📊 Monitoramento, troubleshooting distribuído (observabilidade)

### Ferramentas & Práticas
- **Orquestração**: Kubernetes, ECS, EKS
- **Observabilidade**: OpenTelemetry, Zipkin, Jaeger (distributed tracing)
- **Infra as Code**: Terraform, CloudFormation, Pulumi
- **CI/CD**: Pipelines automatizados para deploy seguro

## 🔗 Distributed vs Single-Node Systems
### Quando Distribuir?
| Motivo | Descrição | Exemplo |
|--------|-----------|---------|
| **Distribuição inerente** | Usuários em dispositivos diferentes | App mobile + backend |
| **Tolerância a falhas** | Redundância para alta disponibilidade | Multi-AZ, multi-region |
| **Escalabilidade** | Volume além de uma máquina | Sharding, replication |
| **Latência** | Usuários geograficamente dispersos | CDN, edge computing |
| **Elasticidade** | Carga variável no tempo | Auto-scaling groups |
| **Hardware especializado** | Workloads diferentes, hardware diferente | GPUs para ML, muitos discos para storage |
| **Conformidade legal** | Data residency requirements | GDPR, LGPD |
| **Sustentabilidade** | Executar onde há energia renovável | Green computing |

### Desvantagens de Sistemas Distribuídos
- ⚠️ **Falhas parciais**: rede, timeout, retry semantics complexos
- ⚠️ **Latência de rede**: chamada remota >> chamada local
- ⚠️ **Consistência**: manter dados sincronizados entre serviços
- ⚠️ **Troubleshooting**: difícil localizar gargalos (observabilidade essencial)
- ⚠️ **Complexidade operacional**: mais peças móveis, mais pontos de falha

### Regra de Ouro
> "Não distribua se um nó único com hardware moderno + banco single-node (DuckDB, SQLite, KùzuDB) atende sua carga"

## 🧩 Microservices & Serverless
### Microservices Architecture
- **Definição**: Serviços com propósito bem definido, API própria, equipe dedicada
- **Vantagens**:
  - Deploy independente, evolução assíncrona entre times
  - Escalabilidade granular por serviço
  - Isolamento de falhas, tecnologia heterogênea possível
- **Desvantagens**:
  - Complexidade de testes (dependências entre serviços)
  - Overhead operacional (deploy, monitoramento, logging por serviço)
  - Evolução de APIs: versionamento, backward compatibility
  - Consistência distribuída: distributed transactions raramente viáveis

### Serverless / FaaS
- **Modelo**: Provedor gerencia infra; você paga apenas pelo tempo de execução
- **Vantagens**: 
  - Zero gestão de servidores, scaling automático
  - Ideal para cargas esporádicas ou imprevisíveis
- **Limitações**:
  - Cold starts, limites de runtime, ambientes restritos
  - Debugging mais difícil, vendor lock-in potencial

### Decisão: Microservices ou Monolito?
- **Grandes empresas/múltiplos times** → Microservices podem valer a pena
- **Startups/equipes pequenas** → Monolito modular é mais simples e eficiente
- **Regra**: Comece simples, extraia serviços apenas quando a complexidade organizacional justificar

## 🧮 Cloud Computing vs Supercomputing (HPC)
| Aspecto | Cloud Computing | HPC / Supercomputing |
|---------|----------------|---------------------|
| **Carga típica** | Serviços online, alta disponibilidade | Batch jobs científicos, simulações |
| **Tolerância a falhas** | Continuidade do serviço essencial | Checkpoint + restart do job |
| **Comunicação** | Rede IP/Ethernet, segurança forte | RDMA, shared memory, trust assumido |
| **Topologia de rede** | Clos (bisection bandwidth) | Meshes, toruses (padrões conhecidos) |
| **Distribuição geográfica** | Multi-region nativo | Nós fisicamente próximos |
| **Modelo de acesso** | Interativo, sob demanda | Batch, agendado |

> Sistemas analíticos em larga escala podem se beneficiar de técnicas de HPC, mas a maioria dos sistemas deste livro foca em disponibilidade contínua.

## ⚖️ Data Systems, Law & Society
### Regulamentações Chave
- **GDPR** (UE): Direitos de acesso, retificação, exclusão ("right to be forgotten")
- **CCPA** (Califórnia): Transparência, opt-out de venda de dados
- **EU AI Act**: Restrições ao uso de dados pessoais em sistemas de IA

### Desafios de Engenharia
- **Exclusão em sistemas imutáveis**: Como deletar dados em append-only logs?
- **Dados derivados**: Como remover dados de modelos de ML treinados?
- **Data minimization**: Coletar apenas o necessário, reter pelo mínimo de tempo
- **Segurança por design**: Criptografia, acesso mínimo, auditoria

### Riscos Além do Custo de Storage
- 🛡️ Vazamento de dados → dano reputacional, multas
- 🌍 Jurisdição de dados → conformidade com leis locais
- 🔐 Dados sensíveis → risco real para usuários (ex: localização revela comportamentos criminalizados)

### Princípio Guia
> "Armazenar menos pode reduzir risco legal, reputacional e humano — e ainda economizar custos"

## 💡 Insights Práticos (Spring + AWS)
### Arquitetura Stateless + Spring Security
- Backend stateless → JWT em vez de HttpSession
- Token no cliente, validação criptográfica a cada requisição
- Elimina replicação de sessão em ambientes distribuídos

### Integração com Infraestrutura AWS
- `Spring Data Redis` + ElastiCache → cache para aliviar RDS
- `Spring Cloud AWS` + SQS → desacoplamento assíncrono
- `Spring Data JPA` + RDS → OLTP; Redshift/Athena → OLAP (separar cargas!)

### Documentação & Contratos de API
- `springdoc-openapi` → Swagger automático
- Payload HTTP deve conter todo contexto (stateless)
- Reduz falhas de integração frontend/backend

### Migração para Distribuído + Containers
- App Spring Boot stateless → candidato ideal para Docker
- Kubernetes/ECS → scaling horizontal sem atrito
- Observabilidade essencial: tracing, métricas, logs centralizados

## 🎯 Resumo Final: Como Decidir?
1. **Entenda o padrão de acesso**: OLTP ou OLAP? Leitura ou escrita intensiva?
2. **Avalie a escala**: Um nó basta? Quando escalar?
3. **Considere a equipe**: Habilidades existentes? Capacidade operacional?
4. **Pense em custos**: Capex vs Opex, custo total de propriedade
5. **Não ignore conformidade**: Privacidade, segurança, jurisdição
6. **Comece simples**: Adicione complexidade apenas quando justificada pelo negócio

> "Arquitetura de dados é sobre escolhas contextualizadas. Não há solução universal — avalie requisitos técnicos, custos, equipe e conformidade antes de decidir."

