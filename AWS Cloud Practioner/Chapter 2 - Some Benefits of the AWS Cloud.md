#flashcards/AWS/cloudpractioner/chaper2
## Exam Preparation Tasks

**Review All Key Topics**
### Economics advantages - page 25
Uma das vantagens econômicas fundamentais da AWS é o conceito de "economias de escala". Isso significa uma economia proporcional nos custos obtida através do aumento do nível de produção. Como a AWS cresce constantemente sua infraestrutura e ganha mais clientes, ela consegue ser mais eficiente e repassar essa economia aos clientes na forma de preços mais baixos (redução de preços ao longo do tempo).

- **Como é cobrado:** a prova raramente pede a definição direta. O foco estará em **modelos de preços**. Precisamos entender que, ao consolidar contas usando AWS Organizations, podemos atingir tiers (níveis) de volume mais altos no S3 ou EC2, pagando menos por unidade devido à "economia de escala" agregada da nossa empresa.

**[FRENTE] Questão 1 - Economias de Escala** Uma empresa possui múltiplas contas AWS operando de forma independente. O CFO notou que estão pagando o preço de varejo total pelo armazenamento S3 em todas as contas, apesar do volume total ser alto. Qual recurso da AWS permite à empresa aproveitar economias de escala para reduzir a fatura mensal consolidada?
A) AWS Cost Explorer
B) AWS Organizations com Faturamento Consolidado (Consolidated Billing)
C) AWS Budgets
D) Savings Plans
?
> **[VERSO] Resposta 1** **Resposta:** B) AWS Organizations com Faturamento Consolidado. **Explicação:** O Faturamento Consolidado trata todas as contas como se fossem uma só. Isso permite combinar o uso (ex: armazenamento S3) para atingir faixas de preço (tiers) de volume mais baixo, aplicando o conceito de economia de escala.

**[FRENTE] Questão 2 - Economias de Escala** Como a AWS aplica o conceito de economias de escala para beneficiar diretamente o cliente final em relação aos custos de hardware?
A) Aumentando o custo das instâncias conforme a demanda sobe. 
B) Exigindo contratos de longo prazo para todos os serviços. 
C) Repassando a economia de custos operacionais e de aquisição de hardware na forma de preços "pay-as-you-go" mais baixos. 
D) Oferecendo hardware dedicado para cada cliente gratuitamente.
?
> **[VERSO] Resposta 2** **Resposta:** C) Repassando a economia de custos operacionais e de aquisição de hardware na forma de preços "pay-as-you-go" mais baixos. **Explicação:** A AWS compra hardware em quantidades massivas, obtendo descontos que uma empresa individual não conseguiria. Essa eficiência é repassada como redução de tarifas.

- **CapEx (Capital Expenditure):** gastos antecipados em infraestrutura física (data centers, servidores) antes de qualquer retorno. Na nuvem, o CapEx é substituído por OpEx.
- **OpEx (Operating Expenditure):** despesas operacionais mensais. Pagamos apenas pelo serviço rodando. Isso permite que startups e empresas lancem recursos sem grandes investimentos iniciais. 

A prova apresentará cenários onde uma empresa quer "evitar grandes custos iniciais" ou quer "custos variáveis em vez de fixos." A resposta correta envolverá o uso de instâncias On-Demand ou serviços Serverless (Lambda), em oposição a comprar hardware físico ou pagar tudo adiantado (All Upfront) se a prioridade for fluxo de caixa imediato.
- **Decisão de Design:** Escolher OpEx favorece a agilidade e fluxo de caixa.

**Agility & No Commitments**
Muitos serviços cobram por hora ou segundo. Não há exigência de contratos de longo prazo (ao contrário de data centers tradicionais ou ISPs antigos). Podemos iniciar projetos novos e cancá-los sem multas contratuais, aumentando a agilidade e reduzindo riscos financeiros. 

Para cargas de trabalho *estáveis e de produção*, a AWS recomenda sim compromissos (Reserved Instances ou Savings Plans) para economizar. Quando não ter compromissos (início de projeto, testes) e quando ter (produção estável).  

**Agility:** Uma equipe de desenvolvimento precisa de um ambiente temporário para testar uma nova versão de um software por apenas 48 horas. Qual é a estratégia de compra de computação mais econômica e ágil?
A) Adquirir instâncias Reservadas (Reserved Instances) de 1 ano.
B) Usar instâncias On-Demand e terminar as instâncias após o teste.
C) Usar um Savings Plan de Compute.
D) Solicitar um Hardware Dedicado.
?
> **[VERSO] Resposta 1** **Resposta:** B) Usar instâncias On-Demand e terminar as instâncias após o teste. **Explicação:** Como não há compromisso contratual, o modelo On-Demand é perfeito para cargas de trabalho de curto prazo. Você paga pelas 48 horas e encerra o custo imediatamente ao terminar as instâncias.

**Questão Agility - Redução de Risco** Uma empresa quer experimentar uma nova arquitetura de Machine Learning, mas não tem certeza se será rentável. Eles querem minimizar o "risco financeiro" caso o projeto falhe após uma semana. Qual característica da AWS suporta isso?
A) A capacidade de reservar capacidade por 3 anos. 
B) O modelo de "pague pelo que usar" sem contratos de longo prazo. 
C) O AWS Enterprise Support. 
D) A depreciação de ativos de TI.
?
> **[VERSO] Resposta 2** **Resposta:** B) O modelo de "pague pelo que usar" sem contratos de longo prazo. **Explicação:** A ausência de contratos permite "falhar rápido e barato". Se o projeto não funcionar em uma semana, a empresa desliga os recursos e para de pagar, sem multas de rescisão.

- **"Pay as you go" model:** se precisamos de mais recursos, obtemos sob demanda e pagamos por ele. Se precisarmos de menos, desligamos e paramos de pagar. Isso á análogo a uma conta de luz (utility bill). 

A prova aborda bastante arquiteturas #Serverless (Lambda, DynamoDB On-Demanda, Aurora Serverless) e **AutoScaling**.

**Cenário Clássico:** "Uma aplicação funciona das 8h às 18h e fica ociosa à noite. Como reduzir custos?" Auto Scaling para reduzir a zero ou desligar instâncias (aproveitando o modelo *pay as you go* para não pagar pela noite). 

**Não é possível realizar auto scaling em uma única instância EC2.** O EC2 Auto Scaling funciona apenas com **múltiplas instâncias** (escala horizontal). Escalar uma única EC2 (CPU/RAM) só é possível **manualmente,** com downtime.

**Questão - Pay as you go** Uma aplicação web tem tráfego imprevisível, variando de zero acessos na madrugada a milhões de acessos ao meio-dia. Qual arquitetura maximiza o benefício do modelo "pague pelo que usar", evitando custos por recursos ociosos?
A) EC2 com Auto Scaling Group e Application Load Balancer. 
B) EC2 provisionado para o pico de tráfego. 
C) Amazon RDS com instâncias reservadas. 
D) AWS Lambda com Amazon API Gateway.
?
> **[VERSO] Resposta 1** **Resposta:** D) AWS Lambda com Amazon API Gateway. **Explicação:** Embora o Auto Scaling (Opção A) ajude, ele geralmente mantém um mínimo de instâncias rodando. O AWS Lambda é puramente orientado a eventos; se houver zero acessos, o custo é zero (ou muito próximo disso), representando a forma mais pura do "pay as you go".


**[FRENTE] Questão - Monitoramento de Custos** Conforme o modelo "pay as you go", os custos podem variar mensalmente. Qual ferramenta a AWS oferece para que um Arquiteto de Soluções defina alertas caso os custos excedam o previsto para o mês?
A) AWS Cost Explorer. 
B) AWS Budgets. 
C) AWS Pricing Calculator. 
D) AWS Organizations.
?
**[VERSO] Resposta: B) AWS Budgets. Explicação:** O AWS Budgets permite definir um limite de orçamento (ex: R$ 1000,00) e envia alertas (SNS/Email) se o uso real ou previsto ultrapassar esse valor, essencial para governar o modelo variável de pagamento.

## Global Infrastructure
A infraestrutura global da AWS é o que possibilita a elasticidade e confiabilidade dos serviços. Ela é composta por:
- **Regiões (Regions):** locais físicos geograficamente dispersos (ex: US East N. Virginia, South America São Paulo). Cada região contém múltiplas Zonas de Disponibilidade. 
- **Zonas de Disponibilidade (Availability Zones - Azs)**: uma AZ é composta por um ou mais data centers físicos. Elas possuem redundância de energia, rede e refrigeração, e são separadas fisicamente umas das outras (dentro da mesma região) para mitigar desastres localizados (como incêndios ou inundações).
- **Edges Locations (Locais de Borda):** Data centers menores distribuídos globalmente (muito mais numerosos que as Regiões) usados principalmente pelo **Amazon CloudFront.** Eles fazem cache de conteúdo para entregar dados com baixa latência para o usuário final. 

Se a prova mencionar "compliance legal" ou "os dados não podem sair do país X", a resposta é escolher a **Região** correta. A AWS não mode dados entre regiões sem a nossa permissão. 
**Latência vs. Durabilidade:** Para durabilidade e disponibilidade, usamos Multi-AZ. Para baixa latência global, usamos **Edge Locations (CloudFront)** ou **Global Accelerator**.

**[FRENTE] Questão 1 - Infraestrutura Global** Uma empresa brasileira precisa hospedar um banco de dados de informações médicas sensíveis. Devido a regulamentações governamentais (LGPD/Compliance), os dados não podem trafegar ou serem armazenados fora do território nacional. Como o Arquiteto deve configurar a infraestrutura?
A) Utilizar o Amazon CloudFront para distribuir os dados globalmente. 
B) Hospedar os recursos exclusivamente na Região sa-east-1 (São Paulo). 
C) Utilizar Cross-Region Replication para replicar os dados para us-east-1. 
D) Hospedar os dados em Edge Locations no Brasil.
?
> **[VERSO] Resposta 1** **Resposta:** B) Hospedar os recursos exclusivamente na Região sa-east-1 (São Paulo). **Explicação:** As Regiões permitem controle total sobre a localização geográfica dos dados. Edge Locations não armazenam dados persistentemente (são cache) e replicação para US violaria a regra de soberania.

**[FRENTE] Questão 2 - Edge Locations** Uma empresa de mídia está lançando um site de streaming de vídeo para usuários ao redor do mundo. Os usuários na Europa e Ásia estão reclamando de lentidão (alta latência) ao acessar o conteúdo hospedado nos EUA. Qual componente da infraestrutura global resolve isso de forma mais eficiente?
A) Criar uma VPN Site-to-Site. 
B) Habilitar Multi-AZ na região de origem. 
C) Utilizar o Amazon CloudFront para entregar conteúdo via Edge Locations. 
D) Aumentar o tamanho das instâncias EC2 (Scale Up).
?
> **[VERSO] Resposta 2** **Resposta:** C) Utilizar o Amazon CloudFront para entregar conteúdo via Edge Locations. **Explicação:** Edge Locations fazem cache do conteúdo estático e de streaming perto do usuário final, reduzindo drasticamente a latência de rede.

**Alta disponibilidade (High Availability - HA)**
Alta disponibilidade (HA) envolve desenhar sistemas que permanecem operacionais por longos períodos. É medida em porcentagem de "uptime". Para atingir HA na AWS, devemos seguir algumas diretrizes:
- Eliminar **Pontos Únicos de Falha (SPOF - Single Points of Failure)**
- Implantar sistemas em múltiplos locais (Multi-AZ)
- Ter procedimentos de recuperação automática.

Se a questão pedir "High Availability" ou "Fault Tolerance" para uma aplicação EC2 ou banco de dados  RDS, a resposta quase sempre envolve **Multi-AZ** e **Load Balancer.**
- SPOF: se tem uma aplicação em apenas uma instância EC2, temos um Ponto único de falha. A solução é colocar atrás de um ELB e usar Auto Scaling com mínimo de 2 instâncias em AZs diferentes.

**[FRENTE] Questão 1 - Alta Disponibilidade** Uma aplicação crítica de e-commerce roda atualmente em uma única instância EC2 grande. O CTO exige que a arquitetura seja redesenhada para eliminar pontos únicos de falha (SPOF) e garantir alta disponibilidade se um data center cair. Qual a arquitetura recomendada?
A) Habilitar backups automáticos do EBS (snapshots). 
B) Usar um Application Load Balancer e um Auto Scaling Group distribuindo instâncias em múltiplas Zonas de Disponibilidade (AZs). 
C) Colocar a instância em um Placement Group do tipo Cluster. 
D) Aumentar o tamanho da instância para xlarge (Vertical Scaling).
?
> **[VERSO] Resposta 1** **Resposta:** B) Usar um Application Load Balancer e um Auto Scaling Group distribuindo instâncias em múltiplas AZs. **Explicação:** HA exige redundância geográfica local. Espalhar instâncias por múltiplas AZs garante que, se um DC falhar, a aplicação continua rodando nas outras AZs.

**[FRENTE] Questão 2 - HA em Banco de Dados** Um Arquiteto precisa garantir disponibilidade para um banco de dados Amazon RDS MySQL. Em caso de falha de hardware na instância primária, o banco deve fazer *failover* automático para uma instância secundária sem intervenção manual. Qual recurso deve ser habilitado?
A) Read Replicas. 
B) Multi-AZ deployment. 
C) Backup automatizado com retenção de 35 dias. 
D) DynamoDB Accelerator (DAX).
?
> **[VERSO] Resposta 2** **Resposta:** B) Multi-AZ deployment. **Explicação:** O RDS Multi-AZ cria uma réplica síncrona em outra AZ. Se a primária cair, a AWS vira a chave (DNS flip) para a secundária automaticamente. (Nota: Read Replicas são para performance de leitura, não primariamente para HA/Failover automático, embora possam ser promovidas manualmente).

**Elasticidade e Agilidade (Auto Scaling e ELB)**

- Elasticidade é a capacidade de escalar a infraestrutura para cima/baixo (up/down) ou para fora/dentro (out/in) conforme a demanda.
	- Scale Up/Down *vertical*: aumenta o poder da máquina (CPU/RAM)
	- Scale Out/In *horizontal*: adiciona mais máquinas (instâncias).
- **Auto Scaling:** monitora a aplicação e ajusta a capacidade (adiciona/remove EC2) para manter a performance com custo baixo. 
- **Elastic Load Balancing (ELB)**: distribuí o tráfego de entrada entre múltiplos alvos (EC2, containers). Tipos: HTTP/S, Network (TCP/UDP), Gateway (Firewall), Classic (Legado).

A nuvem prefere **Escalabilidade Horizontal** (mais máquinas pequenas) porque é mais elástica e não exige desligar a máquina para fazer upgrade (diferente do Vertical Scaling que geralmente exige reboot).

**[FRENTE] Questão 1 - Tipos de Escalabilidade** Uma aplicação web experimenta picos repentinos de tráfego. Atualmente, ela roda em uma instância grande que fica ociosa na maior parte do tempo. O objetivo é tornar o sistema "elástico" para reduzir custos e aguentar picos sem intervenção manual. Qual a melhor abordagem?
A) Vertical Scaling: Criar scripts para mudar o tipo da instância (ex: t3.medium para c5.4xlarge) durante os picos. 
B) Horizontal Scaling: Usar Auto Scaling Group para adicionar/remover instâncias menores conforme a demanda de CPU. 
C) Provisionar a maior instância possível e comprar uma Reserved Instance. 
D) Migrar o banco de dados para o Amazon Redshift.
?
> **[VERSO] Resposta 1** **Resposta:** B) Horizontal Scaling: Usar Auto Scaling Group. **Explicação:** A escalabilidade horizontal é a essência da elasticidade na nuvem. Ela permite crescimento granular e automático sem downtime, diferente do escalonamento vertical que é disruptivo.

**[FRENTE] Questão 2 - Elastic Load Balancing** Você está arquitetando uma aplicação baseada em microserviços. Você precisa de um Load Balancer que possa rotear o tráfego baseando-se no caminho da URL (ex: `exemplo.com/pedidos` vai para o Target Group A, `exemplo.com/usuarios` vai para o Target Group B). Qual ELB você deve escolher?
A) Classic Load Balancer (CLB). 
B) Network Load Balancer (NLB). 
C) Application Load Balancer (ALB). 
D) Gateway Load Balancer (GWLB).
?
**[VERSO] Resposta 2** **Resposta:** C) Application Load Balancer (ALB). **Explicação:** O ALB opera na Camada 7 (Aplicação) do modelo OSI, permitindo roteamento inteligente baseado em conteúdo (Path-based routing, Host-based routing), ideal para microserviços. O NLB é Camada 4 (apenas IP/Porta).