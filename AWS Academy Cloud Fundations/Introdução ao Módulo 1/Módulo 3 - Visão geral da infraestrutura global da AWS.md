
**Tópicos abordados:**
- Infraestrutura global da AWS;
- Visão geral dos serviços e das categorias de serviços da AWS;

**Demonstração**
- Infraestrutura global da AWS;

**Atividades**
- Navegando no Console de Gerenciamento da AWS;

Vamos aprender a identificar a diferença entre regiões, zonas de disponibilidade e pontos de presença da AWS.

- Também identificar categorias de serviços da AWS;


## Seção 1 - Infraestrutura global da AWS
A AWS possuí 36 regiões lançadas, atualmente, cada uma com várias zonas de disponibilidade;
114 zonas de disponibilidades
Mais de 700 POPs do CloudFront.

**Região da AWS**
Uma região da AWS é uma área geográfica;
- Portanto, a replicação dos dados entre as regiões são controlados por nós.
- A comunicação entre regiões usa a infraestrutura de rede **backbone** da AWS.

- Cada região fornece redundância total e conectividade com a rede.
- Uma região normalmente consiste em duas ou mais **zonas de disponibilidade**.

Portanto, os dados não são replicados automaticamente. 

Para obter informações sobre ping, podemos usar o cloudping.info https://www.cloudping.info/

Cada região tem várias zonas de disponibilidade e, cada zona de disponibilidade, é uma partição totalmente isolada da infraestrutura da AWS.

As **zonas de disponibilidade** consistem em **datacenters** distintos. Sendo projetados para isolar falhas, e são conectados a outras zonas de disponibilidade usando redes privadas de alta velocidade. Escolhemos nossas zonas de disponibilidade. 

![[Módulo 3 - Visão geral da infraestrutura global da AWS.png]]

Os datacenters da AWS são projetados para segurança, uma zona de disponibilidade é a unidade mais granular. Os *datacenters* são os locais onde os dados residem  e o processamento de dados ocorre. Cada datacenter tem energia, redes e conectividade redundantes e está hospedado em uma instalação separada.
Normalmente, um datacenter tem de 50.000 a 80.000 servidores físicos. 

#ODMs são modelados os **Modelos de Dados Operacionais** usados para representar, organizar e gerenciar dados em serviços da AWS, especialmente em contextos como aplicações empresariais, saúde, finanças, manufatura, entre outros.

São modelos prontos ou personalizáveis que ajudam a organizar dados de maneira padronizada dentro de aplicações que rodam na AWS, facilitando a integração entre sistemas, a análise de dados e a automação de processos. 

Recursos de infraestrutura da AWS
- Elasticidade e escalabilidade: 
	- Infraestrutura elástica; adaptação dinâmica da capacidade;
	- Infraestrutura escalável; adapta-se para acomodar o crescimento;

- Tolerância a falhas:
	- Continua funcionando corretamente na presença de uma falha;
	- Redundância integrada de componentes

- Alta disponibilidade
	- Alto nível de desempenho operacional;
	- Tempo de inatividade mínimo
	- Sem intervenção humana

## Seção 2 - Serviços Fundamentais da AWS
A infraestrutura global da AWS pode ser dividida em três elementos principais:

**Serviços de Armazenamento**
- Amazon Simple Storage Service (Amazon S3): ele armazena objetos, como arquivos de fotos, vídeos, backups etc. Possuí alta durabilidade e escalabilidade.

- Amazon EBS (Elastic Block Store): armazenamento em blocos, serve como um HD para instâncias EC2, suo típico para sistemas operacionais, bancos de dados, etc.

- Amazon EFS (Elastic File System): armazenamento de arquivos, como sistemas de arquivos em rede, compartilha arquivo entre várias instâncias EC2, montável em várias máquinas ao mesmo tempo.

- Amazon S3 Glacier: armazenamento de arquivos para arquivamento, são dados que raramente serão acessados (ex.: históricos), barato, mas com tempo maior de recuperação.

**Serviços de computação**
- **Amazon EC2 (Elastic Compute Cloud)**: permite que criemos e gerenciarmos servidores virtuais (instâncias) na nuvem. Escolhemos a quantidade de memória, CPU, sistema operacional e armazenamento. Ideal para aplicações tradicionais que req
- uerem controle total do ambiente (como um servidor web, backend Java, banco de dados etc). Podemos acessar via SSH e instalar tudo manualmente. Uma instância do EC2 é **uma máquina virtual completa**, com: 
	- Seu próprio sistema operacional (Linux, Windows etc.);
	- CPU, memória RAM, disco;
	- Rede configurável;
	- Acesso completo via SSH (Linux) ou RDP (Windows).
O EC2 serve para rodar qualquer aplicação que normalmente rodaríamos em um servidor físico, por exemplo: servidor web, backend, banco de dados, ambiente de desenvolvimento/teste, hospedagem de sites, aplicações legadas...


### Amazon EC2 Auto Scaling
Esse serviço complementa o EC2. Ele monitora nossas instâncias e ajusta automaticamente a capacidade se o tráfego aumentar, ele cria novas instâncias. Se o tráfego cair, ele reduz o número de instâncias, e substituí instâncias com problemas automaticamente. Casos de uso, um site que recebe picos de acesso, como o e-commerce ou apps sazonais.

### Amazon ECS (Elastic Container Service)
É um orquestrador de containers Docker. Permite criarmos clusters de containers, definir tarefas, serviços etc. Totalmente integrado com outros serviços como EC2 e Fargate. Definimos imagens (geralmente do ECR) e o ECS cuida da execução. 

## Amazon ECR (Elastic Container Registry)
Um repositório privado e seguro para armazenar imagens Docker. Integra-se diretamente com o ECS e o EKS. Evita depender de Docker Hub ou outras soluções externas. Podemos, então, armazenar as imagens Docker do nosso backend, frontend ou microsserviços antes de implantar com o ECS ou EKS.

## AWS Elastic Beanstalk
Plataforma como serviço (PaaS) para quem não quer lidar com infraestrutura. Subimos o nosso código (Java, Node, Python, etc), e ele cuida da criação dos servidores, load balancer, auto scaling e monitoração. Ainda nos dá a liberdade de configurarmos se precisar.

## AWS Lambda
Serviço de computação serverless: escrevemos funções pequenas e o Lambda executa sob demanda. Sem servidores, não pagamos por inatividade, integra-se com outros serviços como S3, DynamoDB, API Gateway, etc. Muito usado em arquiteturas baseada em eventos. Podemos processar uma imagem quando ela for enviada para um bucket S3, ou criar uma API simples. 

## Amazon EKS (Elastic Kubernetes Service)
É um serviço gerenciado de Kubernetes na AWS. Serve para equipes que já usam Kubernetes e querem rodá-la na nuvem sem configurar tudo do zero. O EKS gerencia o plano de controle e permite que foquemos nos nossos pods e serviços, suporta integração com Fargate para execução de pods sem EC2. 

## AWS Fargate
Serviço que permite rodar containers sem se preocupar com servidores. Só definimos os requisitos CPU, RAM, imagem Docker, e o Fargate executa a escala conforme necessário. É ideal para workloads altamente dinâmicas ou de curta duração.

| Serviço           | Descrição resumida                                      |
| ----------------- | ------------------------------------------------------- |
| EC2               | Criação de servidores virtuais personalizáveis.         |
| EC2 Auto Scaling  | Escala automática de instâncias EC2.                    |
| ECS               | Orquestração de containers Docker.                      |
| ECR               | Armazenamento privado de imagens Docker.                |
| Elastic Beanstalk | PaaS para implantar apps sem gerenciar infraestrutura.  |
| Lambda            | Execução de código sob demanda, sem servidor.           |
| EKS               | Kubernetes gerenciado na AWS.                           |
| Fargate           | Executa containers sem precisar provisionar servidores. |

**Categoria de serviço de banco de dados**
**Amazon Relational Database Service (RDS)**: é um serviço gerenciado que facilita o provisionamento, configuração, operação e escalonamento de bancos de dados relacionais. Suporta vários tipos de bancos de dados populares, como MySQL, PostgreSQL, Oracle, SQL Server e Aurora. Gerencia automaticamente tarefas de manutenção, como backups, atualizações de software e replicação de dados. Oferece alta disponibilidade através de instâncias multi-AZ (Availability Zone).  Permite fácil escalabilidade vertical (mais CPU ou memória) e horizontal (mais nós). Ideal para aplicativos que requerem um banco de dados relacional tradicional. Uso comum em aplicações web que precisam de um banco de dados relacional robusto e para migrar bancos de dados existentes para a nuvem sem alterações significativas no código.

**Amazon Aurora**: é um banco de dados compatível com MySQL e PostgreSQL, projetado para ser rápido, confiável e econômico. É até 5 vezes mais rápido do que um banco de dados padrão MySQL e até 3x mais rápido do que PostgreSQL. Oferece alta disponibilidade com replicação síncrona em múltiplas AZs. Armazena dados em volumes de armazenamento SSD altamente duráveis. Gerencia automaticamente backups, recuperação de falhas e otimização de desempenho. Ideal para cargas de trabalho de alto desempenho e baixa latência. Seu uso, geralmente ocorre em aplicações que exigem um banco de dados relacional com alto desempenho e escalabilidade. 

**Amazon Redshift**: é um serviço de data warehouse totalmente gerenciado, projetado para análise de grandes volumes de dados. Ele é escalável e otimizado para consultas complexas e análises de grande volume de dados. Usa arquitetura columnar para melhorar o desempenho de leitura e compreensão de dados. Integra-se facilmente com ferramentas de BI (Business Intelligence), como Tableau, Power BI e AWS QuickSight. Oferece segurança robusta, incluindo criptografia de dados em repouso e em trânsito. Ideal para análises de negócios, relatórios e visualizações de dados. Seu uso é comum em análises de dados históricos e tendências, processamento de grandes conjuntos de dados para tomada de decisões estratégicas e aplicações de  analytics empresariais.

**Amazon DynamoDB**: é um banco de dados NoSQL completamente gerenciado, projetado para fornecer consistência forte e escalabilidade ilimitada. Possuí modelo de chave primária e suporte a índices secundários globais e locais, oferece throughput ajustável e previsível, garantindo desempenho consistente. Armazena dados em formato JSON, permitindo flexibilidade na estrutura dos dados. Gerencia automaticamente backups, replicação e recuperação de falhas.

**Serviços de Rede e entrega de conteúdo** que permitem a construção de infraestruturas robustas, escaláveis e altamente disponíveis. Esses serviços são essenciais para gerenciar tráfego, garantir segurança, melhorar o desempenho e entregar de forma eficiente aos usuários finais. 

**Amazon VPC (Virtual Private Cloud)**: é um serviço que permite criar redes virtuais isoladas dentro da infraestrutura da AWS. Com o VPC, podemos definir sub-redes, controlar o tráfego de rede usando firewalls e roteadores, e estabelecer conexões seguras com sua infraestrutura local. Seu uso é mais comum em implantação de aplicações em ambientes isolados e seguros, extensão de redes locais para a nuvem através de VPN ou AWS Direct Connect bem como criação de arquiteturas multicamadas (front-end/back-end) com isolamento de recursos.

**Elastic Load Balancing (ELB)**: ele distribuí automaticamente o tráfego de rede entre instâncias de servidor, como EC2, para garantir alta disponibilidade e escalabilidade. 
**Tipos de Load Balancers:** 
- **Application Load Balancer (ALB)** : Ideal para aplicativos baseados em camada de aplicação (HTTP/HTTPS).
- **Network Load Balancer (NLB)** : Ideal para cargas de trabalho de alto desempenho e baixa latência (TCP/UDP).
- **Classic Load Balancer** : Versão mais antiga, ainda suportada, mas menos recomendada para novos projetos.

- **Características** :
    - Distribuição automática do tráfego entre instâncias de servidor.
    - Monitoramento de saúde das instâncias e remoção automática de instâncias inativas.
    - Suporte a SSL/TLS para criptografia de dados.
    - Escalabilidade horizontal automática conforme a demanda.
- **Uso Comum** :
    - Distribuição de carga para clusters de servidores web ou aplicativos.
    - Garantia de alta disponibilidade e tolerância a falhas.

Neste módulo, aprendemos a:
- Identificar a diferença entre regiões, zonas de disponibilidade e pontos de presença da AWS;
- Identificar categorias de serviços e serviços da AWS;

---
1. Qual componente da infraestrutura global da AWS o Amazon CloudFront usa para garantir a entrega de baixa latência?
Pontos de Presença da AWS

2. Podemos executar aplicativos e cargas de trabalho de uma região mais próxima dos usuários finais para diminuir a latência. 

3. Redes, armazenamento, computação e bancos de dados são exemplos de categorias de serviços que a AWS oferece.
**Verdadeiro, a AWS oferece, sim, serviços de Resdes (ou networking), sendo uma das principais categorias de serviços da nuvem da AWS. Alguns exemplos são:**
- Amazon VPC (Virtual Private Cloud): permite provisionar uma rede isolada logicamente na nuvem;
- AWS Direct Connect: conecta a nossa local diretamente à AWS;
- Elastic Load Balancing (ELB): distribui automaticamente o tráfego de entrada entre várias instâncias
- Amazon Route 53: serviço de DNS altamente disponível e escalável;
- AWS Transit Gateway: conecta VPCs e redes locais usando um hub centralizado.

3. Quais das seguintes são áreas geográficas que hospedam duas ou mais zonas de disponibilidade?
	As **Regiões da AWS** são áreas geográficas amplas ao redor do mundo que hospedam duas ou mais Zonas de Disponibilidade (Availability Zones). Cada zona de disponibilidade, por sua vez, é composta por um ou mais datacenters fisicamente separados, mas interconectados por redes de alta velocidade.