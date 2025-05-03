
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

|Serviço|Descrição resumida|
|---|---|
|EC2|Criação de servidores virtuais personalizáveis.|
|EC2 Auto Scaling|Escala automática de instâncias EC2.|
|ECS|Orquestração de containers Docker.|
|ECR|Armazenamento privado de imagens Docker.|
|Elastic Beanstalk|PaaS para implantar apps sem gerenciar infraestrutura.|
|Lambda|Execução de código sob demanda, sem servidor.|
|EKS|Kubernetes gerenciado na AWS.|
|Fargate|Executa containers sem precisar provisionar servidores.|
