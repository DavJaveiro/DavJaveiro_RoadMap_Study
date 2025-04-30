# Economia e Faturamento da Nuvem
**Visão geral do módulo**
- Conceitos básicos da definição de preço;
- Custo total de propriedade;
- Calculadora Mensal
- Introdução ao AWS Organizations
- Gerenciamento de custos e faturamento da AWS
- Visão geral dos planos e custos de suporte técnico da AWS

**Demonstração**
- Visão geral do painel de faturamento;

**Atividades**
- Calculadora Mensal
- Levantamento de informações sobre planos de suporte

**Depois de concluir este módulo, seremos capazes de:**
- Explicar a filosofia de definição de preço da AWS;
- Reconhecer as características fundamentais da definição de preço;
- Indicar os elementos do custo total de propriedade;
- Discutir os resultados da Calculadora Mensal
- Identificar como configurar uma estrutura organizacional que simplifica o faturamento e a visibilidade da conta para analisar os dados de custo.
- Identificar a funcionalidade no Painel de faturamento da AWS;
- Descrever como usar as contas da AWS, o AWS Cost Explorer, o AWS Budgets e os relatórios de uso e custos da AWS;
- Identificar os vários planos e recursos de suporte técnico da AWS;

## Fundamentos da definição de preços
Existem três fatores fundamentais de custo com a AWS:
- **Computação:** cobrado por hora/segundo; varia por tipo de instância.

- **Armazenamento:** cobrado normalmente por GB.

- **Transferência de dados**
	- A saída é agregada e cobrada
	- A entrada não tem cobrança (com algumas exceções)
	- Cobrado normalmente por GB

A transferência de dados entre serviços na mesma região é gratuita.

Como pagamos pela AWS:
- Pagamos pelo o que usamos; 
- Pagamos menos ao fazer reserva;
- Pagamos menos quando usamos mais e conforme a AWS cresce.

Pagamos apenas pelos serviços que consumimos, sem grandes despesas iniciais.
![[Módulo 2.png]]

Todos os serviços estão disponíveis sob demanda, sem pagamento adiantado ou contratos de longo prazo. 

Conforme utilizamos, pagamos menos:
- Economias à medida que o uso aumenta;
- Definição de preço em camadas para serviços como Amazon Simple Storage Service (Amazon S3), Amazon Elastic Block Store (Amazon EBS) ou Amazon Elastic File System (Amazon EFS) - quanto mais utilizamos, menos pagaremos por GB;
- Vários serviços de armazenamento oferecem custos de armazenamento mais baixos com base nas necessidades.

A própria AWS costuma destacar isso nos materiais institucionais e nas certificações, inclusive no **Cloud Practitioner (CLF-C02)**, que desde o sue lançamento em 2006, a redução de preço <span style="background:#d4b106">ocorreu mais de 100 vezes</span>, como parte do compromisso com a redução contínua de custos para os clientes. 

A AWS compreender que cada cliente tem necessidades diferentes. Por isso, possui uma definição de preço personalizada.
- Atenda a necessidades variáveis por meio de definição de preço personalizada;
- Disponível para projetos de alto volume com requisitos exclusivos. 

Para ajudar novos clientes da AWS a começar a usar os serviços, a AWS possuí níveis gratuitos.

O nível gratuito da AWS permite que obtenhamos experiências prática gratuita com os produtos e os serviços da AWS. Gratuito por 1 ano para novos clientes. 

Se formos um cliente novo da AWS, poderemos executar uma microinstância T2 gratuita do Amazon EC2 por um ano;
Um nível gratuito para o Amazon S3 e para o Amazon EBS (Amazon Elastic Block Storage)

**Serviços sem custo adicional**:
Amazon VPC
Elastic beanstalk
**Auto Scaling**
AWS CloudFormation
AWS Identity and Access Management (IAM)


---
**Amazon Elastic Block Store** #EBS - é um serviço de armazenamento em blocos **persistente e escalável** para instâncias EC2 na AWS. Ele serve para:
- **Armazenar dados críticos** que precisam persistir mesmo após o desligamento ou exclusão de uma instância (ex.: banco de dados, sistemas de arquivos).
- Oferecer **alta disponibilidade e durabilidade**, com replicação automática dentro de uma zona de disponibilidade;
- Fornecer **desempenho consistente** com opções de volumes SSD (baixa latência, ideal para bancos de dados) e HDD (Alto throughput, para big data).
- Permitir **snapshots** (cópias de segurança) para o Amazon S3, facilitando backups e recuperação de dados.
- Ser **flexível**, permitindo redimensionar volumes e alterar tipos conforme a demanda.

---
O **Auto Scaling** no **Amazon EC2** é um serviço que **ajusta automaticamente o número de instâncias EC2** em execução com base na **demanda do aplicativo**. 

Portanto, visa manter a **disponibilidade e otimizar custos**, adicionando ou removendo instâncias conforme necessário. 
- **Funciona com base em regras:** como uso da CPU, tráfego de rede ou outras métricas.
**Tipos básicos**:
- *Target Tracking*: mantém uma métrica em um valor de alvo (ex.: CPU em 50%);
- *Step Scaling*: ajusta conforme mudanças bruscas na carga;
- *Simple Scaling*: ajusta com um pequeno atraso após uma alteração na carga.

---

## Seção 2: Custo total de propriedade
Muitas empresas perguntam, como comparar implementações locais com implementações na nuvem. 
![[Módulo 2-1.png]]

Como podemos identificar a melhor opção? Podemos identificar através da comparação da solução física com a solução em núvem.

**O custo total de propriedade TCO** é a estimativa financeira para ajudar a identificar custos diretos e indiretos de um sistema.

Por que usar o TCO?
- Para comparar os custos da execução de um **ambiente de infraestrutura inteiro ou de uma carga de trabalho específica** no local em comparação com a AWS.
- Para criar um orçamento e um caso de negócios para migrar para a nuvem.

A calculadora de custo total de propriedade da AWS é uma ferramenta que podemos usar para comprar ou contrastar uma implementação física com sua implementação em nuvem.

![[Módulo 2-2.png]]

![[Módulo 2-3.png]]

 **Calculadora Mensal da AWS**
 A calculadora mensal da AWS é utilizada para estimar custos mensais;
 Identificar oportunidades para reduzir custos mensais;
 Usar modelos para comparar serviços e modelos de implantação. 

![[Módulo 2-4.png]]

## Seção 3 - AWS Organizations
Dependendo do tamanho da empresa, às vezes é mais fácil atribuir contas separadas da AWS a cada departamento ou equipe.

Utilizamos o **AWS Organizations** para faturamento consolidado de várias contas. Sendo essencial para empresas que usam várias contas AWS e precisam organizar, controlar acesso, aplicar políticas e gerenciar custos em escala.

**Principais funções (resumidas):**
- **Consolidação de contas:** agrupa várias contas AWS em uma única organização;
- **Controle centralizado:** permite criar e gerenciar políticas para segurança, compliance e governança em todas as contas;
- **Políticas de controle (SCP)**: restringem ações em contas filhas (evitar uso de certos serviços ou regiões);
- **Consolidação de faturamento:** facilita o acompanhamento e pagamento único de várias contas.
- **Organização por unidades organizacionais (OU):** estrutura contas em grupos lógicos.

**Configuração do Organizations**
![[Módulo 2-5.png]]
- Etapa 1: criar a organização;
- Etapa 2: criar unidades organizacionais;
- Etapa 3: criar políticas de controle de serviço;
- Etapa 4: restrições de teste.

As formas de acesso ao AWS Organizations incluem:
- Console de gerenciamento da AWS;
- Ferramentas da interface de linha de comando da AWS (ILC da AWS);
- Kits de desenvolvimento de software (SKDs) - AWS SDK for Java
- Interface de programação de aplicativos (APIs) para consulta HTTPS.


## Seção 4 - AWS Billing and Cost Management
É uma ferramenta da Amazon Web Services que permite visualizar, gerenciar e controlar os custos de uso dos serviços da AWS.

- Ele mostra detalhadamente quais serviços estão sendo usados e quanto cada um está custando.
- Oferece gráficos, listas e dados históricos para entender padrões de consumo;
- Permite criar alertas para quando os custos ultrapassarem um valor definido;
- Envia notificações automáticas sobre aumentos inesperados nos custos.
- Facilita a alocação de custos por projeto, equipe ou departamento, ajudando na governança financeira.
- Faturamento consolidado é útil para quem usa o **AWS Organizations**, pois centraliza o pagamento de várias contas em uma só.
	- **Reservations e Savings Plans:** ajuda a acompanhar e otimizar descontos por compromissos de uso (como EC2 Reserved Instances).

## Seção 5 - Suporte técnico
O AWS Support fornece uma combinação única de ferramentas/especialização:
- AWS Support;
- Planos do AWS Support;

**O suporte é fornecido para:**
- Experimentação com a AWS;
- Uso da AWS na produção;
- Processos de negócios críticos que utilizam AWS;

O AWS Support oferece quatro planos de suporte:
- **Suporte básico:** acesso à central de recursos, painel de status do serviço, perguntas frequentes sobre produtos, fóruns de discussão e suporte a verificações de integridade;
- **Suporte ao desenvolvedor:** suporte para desenvolvimento antecipado na AWS;
- **Suporte comercial:** clientes que executam cargas de trabalho de produção;
- **Suporte empresarial:** clientes que executam cargas de trabalho comerciais  e essenciais à missão.

Qual serviço da AWS fornece recomendações de otimização de segurança de infraestrutura?
AWS Trusted Advisor

Para determinados serviços, como o Amazon Elastic Compute Cloud (Amazon EC2), e o Amazon Relational Database Service (Amazon RDS), é possível investir em capacidade reservada. Quais opções estão disponíveis para instâncias reservadas?
**As instâncias reservadas** no AWS, são formas de economizar custos ao comprometer o uso de recursos por um período pré-determinado. As opções disponíveis para instâncias reservadas são:
1. #MURI = Marketplace Reserved Instance
2. #PURI = Partial Upfront Reserved Instance
3. #DURI (No Upfront Reserved Instance)

O AWS Cost Explorer pode fornecer mais detalhes sobre a atividade de faturamento do Amazon EC2 nos últimos três meses. 

Para receber a taxa com desconto associada às instâncias reservadas, não precisamos fazer um pagamento antecipado de forma completa.

Qual afirmação é verdadeira sobre o modelo de precificação da AWS?