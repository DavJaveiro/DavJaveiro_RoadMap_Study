### 1. Otimizando a Fase de Leitura (Azul na Tabela)

No seu plano, há "Read Foundation Topics". A leitura passiva tem baixa retenção.
- **Não leia para "terminar o capítulo":** Leia com o objetivo de **minerar** cartões para o Anki.
- **A Regra dos 20%:** O princípio de Pareto se aplica aqui. 20% dos serviços (EC2, S3, VPC, IAM, RDS, Lambda, Auto Scaling, ELB) compõem 80% da prova. Dê ênfase brutal neles.
- **Criação de Cards em Tempo Real:** Não deixe para criar os cards depois.
    
    - _Leu um conceito novo?_ Card.
    - _Viu uma limitação (ex: tamanho máximo de item no DynamoDB)?_ Card.
    - _Entendeu uma diferença (ex: Security Group vs. NACL)?_ Card.

### 2. A Estratégia de Anki para SAA-C03
O maior erro é criar cards ruins (muito texto). Para a AWS, use estes 3 tipos de cards:
#### A. Cards de Omissão (Cloze Deletion)
Ótimos para decorar fatos, números e limites.
> **Card:** O tempo máximo de execução de uma função AWS Lambda é de {{c1::15 minutos}}.

#### B. Cards de Cenário (O "Pulo do Gato")
A prova SAA-C03 é baseada em cenários. Crie cards que forçam você a tomar decisões de arquitetura.
> **Frente:** Um cliente precisa de um banco de dados de alta performance, chave-valor, com latência de milissegundos de um dígito e capacidade de escalar infinitamente. Qual serviço usar?
> **Verso:** Amazon DynamoDB (Accelerator/DAX se precisar de microssegundos).

#### C. Cards de Diagrama (Image Occlusion)
Use a extensão _Image Occlusion_ no Anki.
- Pegue diagramas de arquitetura (ex: VPC Peering, Transit Gateway).
- Esconda os nomes dos componentes e tente adivinhar qual componente se encaixa naquela parte da arquitetura.

### 3. Otimizando a Fase de Revisão e Tarefas (Rosa na Tabela)
No plano está escrito "Define Key Terms" e "Review Key Topics".
- **Substitua "Review" por "Active Recall":** Ao chegar nessa fase, não releia suas anotações. Vá direto para o Anki ou tente explicar o conceito em voz alta (Técnica Feynman) _antes_ de olhar o material.
- **Use o Anki para "Define Key Terms":** Em vez de escrever as definições num caderno, coloque-as no Anki.

### 4. Otimizando a Fase de Testes (Verde na Tabela)
A tabela diz "Take practice test". Aqui é onde a mágica acontece.
- **Não faça testes apenas para ver a nota.** Cada questão errada é um ouro.
- **O Loop de Feedback:**
    1. Errou uma questão no simulado?
    2. Entenda **por que** a resposta certa é a certa.
    3. Entenda **por que** a sua resposta (errada) está incorreta (isso é crucial na AWS, pois muitas opções são "corretas", mas não são a "melhor" para aquele cenário).
    4. **Crie um card no Anki para esse erro.**
        - _Exemplo:_ "Por que eu escolhi S3 Standard-IA e a resposta era S3 Glacier? Porque eu ignorei que o requisito era recuperação em minutos, não milissegundos."

### 5. O Elo Perdido: Laboratórios (Hands-On)
A sua tabela (Study Planner) não menciona explicitamente "Labs" ou "Console". **Você não passará na SAA-C03 apenas lendo.**
- **Modificação sugerida:** Para cada linha "Read Foundation Topics" da sua tabela, adicione uma micro-tarefa prática.
    - _Leu sobre S3?_ Vá no console, crie um bucket, configure o versionamento e crie uma regra de ciclo de vida.
    - _Leu sobre VPC?_ Crie uma VPC do zero (sem o wizard), com subnets públicas e privadas e um NAT Gateway.

---
## Plano de ação
### 📅 Macro-Cronograma: 8 Meses (32 Semanas)
_Data de Início:_ 19/11/2025 _Data Estimada da Prova:_ Julho/2026
Como são 16 Capítulos, temos uma média de **2 semanas por capítulo**. Isso é um ritmo excelente para quem trabalha/estuda outras coisas.
- **Fase 1: Fundação e Core Services (Cap 1-6)** | _Nov - Jan_
- **Fase 2: Bancos de Dados e Alta Disponibilidade (Cap 7-11)** | _Fev - Mar_
- **Fase 3: Serverless, Segurança Avançada e Custos (Cap 12-16)** | _Abr - Maio_
- **Fase 4: Revisão Geral e Simulados Intensivos** | _Jun - Jul_

