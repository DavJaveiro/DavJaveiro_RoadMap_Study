## 1.2 What can we do with AWS?
### 1.2.1 Hosting a web shop
We wants to develop a fast, reliable, and scalable web shop. We can evaluating how our company can take advantage of AWS by running the same setup on AWS, instead  on-premises server.

- Smaller virtual machines at no extra cost. If one of these virtual machines fails, the **load balancer** will send customer requests to the other virtual machines. 


!![image-20251125295527.png](/image-20251125295527.png)

### 1.2.2 Running a Java EE application in our private network
!![image-202511253641391.png](/image-202511253641391.png)

Cada data center possuí apenas uma instância da aplicação.

### 1.2.4 Profiting from low costs for batch processing infrastructure
Geração de um relatório diário contendo as condições de manutenção de centenas de equipamentos. 

- *AWS bills virtual machines per second with a minimum of 60 seconds.* Doing so allows, we pay for computing infrastructure only when actually using it.
- *AWS offers spare capacity in their data centers at a substantial discount*.
!![image-202511255334872.png](/image-202511255334872.png)

## 1.3 How we can benefit from using AWS
Qual é a vantagem mais importante de se utilizar a AWS? Economia de custos, podemos dizer. Mas economizar dinheiro não é a única vantagem. 
### 1.3.1 Innovative and fast-growing 
A AWS anuncia novos serviços, recursos e melhorias constantemente. Fazer uso das tecnologias inovadoras fornecidas pela AWS ajuda a gerarmos soluções valiosas para nossos clientes e, assim, alcançar uma vantagem competitiva. A Amazon reportou vendas líquidas de $62 bilhões para 2021. 

### 1.3.2 Serviços resolvem problemas comuns
A AWS é uma plataforma de serviços. Problemas comuns, como balanceamento de cargas, filas, **envio de e-mail** e armazenamento de arquivos, são resolvidos através de seus serviços. Não precisamos reinventar a roda. O nosso trabalhar é escolher os serviços certos para construir sistemas complexos. Deixamos que a AWS gerencie esses serviços enquanto nos concentramos em nossos clientes.

### 1.3.3 Habilitando automação
Como a AWS é orientada a API, podemos automatizar tudo: escrever código para criar redes, iniciar clusters de máquinas virtuais ou implantar um banco de dados relacional. A automação aumenta a confiabilidade e melhora e eficiência. Quanto mais dependências nosso sistema tiver, mais complexo ele se tornará. Um ser humano pode perder a perspectiva rapidamente, enquanto um computador pode lidar com sistemas interconectados de qualquer tamanho. Podemos nos concentrar nas tarefas que os seres humanos são bons, como descrever um sistema, enquanto o computador descobre como resolver todas essas dependências para criar o sistema. A configuração de um ambiente na nuvem com base em nossos projetos pode ser automatizada com a ajuda da infraestrutura como código (IaC), abordada no capítulo 4.

### 1.3.4 Capacidade flexível (escalabilidade)
A capacidade flexível reduz o excesso de capacidade. Podemos escalar de uma máquina virtual para milhares de máquinas virtuais. Nosso armazenamento pode crescer de gigabytes para petabyes. Não precisamos mais prever nossas necessidades futuras de capacidade para os próximos meses e anos para comprar hardware. Se administramos uma loja virtual, possuímos padrões de tráfego sazonais, como mostrado na figura 1.7.
!![image-202512203413108.png](/image-202512203413108.png)

Pensemos em dia versus noite, e dia de semana versum fim de semana ou feriado. Não seria bom se pudessemos adicionar capacidade quando o tráfego aumente e remover capacidade quando o tráfego diminui? É exatamente disso que se trata a capacidade flexível. Podemos iniciar novas máquinas virtuais em minutos e descartá-las algumas horas depois. A nuvem quase não tem restrições de capacidade. Não precisamos mais pensar em espaço no rack, switches e fontes de alimentação, podemos adicionar quantas máquinas virtuais desejarmos. Se os volumes de dados crescer, sempre poderemos adicionar uma nova capacidade de armazenamento. Capacidade flexível também significa que podemos desligar sistemas não utilizados. Em um de nossos últimos projetos, o ambiente de teste funcionava apenas das 7h às 20h nos dias de semana, permitindo-nos economizas 60%.

### 1.3.5 Construído para falhas (confiabilidade)
A maioria dos serviços da AWS é altamente disponível ou tolerante a falhas por padrão. Se usarmos esses serviços, obtemos confiabilidade gratuitamente. Além disso, a AWS fornece ferramentas que permitem construir sistemas de maneira confiável. Ela fornece tudo o que precisamos para criar nossos próprios sistemas altamente disponíveis ou até mesmo tolerante a falhas.

### 1.3.6 Reduzindo o tempo de lançamento no mercado (Time to Market)
Na AWS, solicitamos uma nova máquina virtual e, alguns minutos depois, essa máquina virtual é inicializada e está pronta para uso. O mesmo vale para qualquer outro serviço da AWS disponível. Podemos usar todos eles sob demanda. Seu processo de desenvolvimento será mais rápido devido aos ciclos de feedback mais curtos. Podemos eliminar restrições como o número de ambientes de teste disponíveis; se precisarmos de outro ambiente de teste, podemos criá-lo por algumas horas.

### 1.3.7 Beneficiando-se de economia de escala
A AWS está aumentando sua infraestrutura global constantemente e, portanto, a AWS se beneficia de uma economia de escala. Como cliente, nos beneficiaremos parcialmente desses efeitos. A AWS reduz os preços de seus serviços em nuvem de tempos em tempos. 

### 1.3.8 Infraestrutura global
Você está atendendo clientes em todo mundo? O uso da infraestrutura global da AWS tem as seguintes vantagens: ter baixas latências de rede entre seus clientes e sua infraestrutura, ser capaz de cumprir os requisitos regionais de proteção de dados e beneficiar-se de preços de infraestrutura diferentes em diferentes regiões.

### 1.3.9 Parceiro profissional
Quando usamos serviços da AWS, podemos ter certeza de que a qualidade e segurança seguem os padrões e certificações mais recentes, como os seguintes:
ISO 27001, ISO 9001, PCI DSS Nível 1.

## 1.4 How much does it cost?
Uma fatura da AWS é semelhante a uma conta de luz. Os serviços são cobrados com base no uso. Você paga pelo tempo que uma máquina virtual ficou ligada, pelo armazenamento usado no *object store* ou pelo número de balanceadores de carda em execução. Os serviços são faturados mensalmente. O preço de cada serviço está disponível publicamente; se quisermos calcular o custo mensal de uma configuração planejada, podemos usar a Calculadora de Preços da AWS (AWS Pricing Calculator).

### 1.4.1 Nível Gratuito (Free Tier)
Podemos utilizar alguns serviços da AWS gratuitamente nos primeiros 12 meses após o cadastro. A ideia por trás do nível gratuito é permitir que experimentemos a AWS e ganhemos experiência usando seus serviços. 

Quando excedemos os limites do Nível gratuito, pagamos pelos recursos consumidos sem aviso prévio. Receberemos uma fatura ao final do mês. 

### 1.4.2 Exemplo de faturamento
- Baseado no tempo de uso (ex: VM por segundo, Load Balancer por hora)
- Baseado no Tráfego (ex: Gigabytes transferidos ou número de requisições)
- Baseado no armazenamento (ex: capacidade provisionada ou uso real)

### 1.4.3 Oportunidades do modelo pague-pelo-uso
O modelo de precificação da AWS cria novas oportunidades. Por exemplo, a barreira para iniciar um projeto novo é menor, pois não precisamos investir em infraestrutura antecipadamente. Outro exemplo: uma máquina virtual grande custa exatamente o mesmo que duas menores com a mesma capacidade total. Assim, podemos dividir nosso sistema em partes menores, pois o custo é o mesmo. Isso torna a tolerância a falhas acessível não apenas para grandes empresas, mas também para orçamentos menores.

*Insights*
No Free Tieer, uma pequena máquina virtual geralmente é uma instância com 1GB de RAM. Aplicações **Spring Boot** tradicionais podem sofrer para rodar se não forem otimizadas. 
**Erro Comum:** subir uma aplicação Java com configurações padrão na EC2 gratuita. O sistema operacional + JVM podem estourar a memória, causando o "OOM Killer" 
**Ação:** configuremos o *swap* do Linux da EC2 (usar disco como memória extra) para evitar que a aplicação caia durante os testes. Em produção real, ajuste o *heap size* (-Xmx) da JVM.

- **Horizontal vs. Vertical Scaling**
*Uma máquina grande custa  o mesmo que duas pequenas.* Isso é a base para preferir Escalabilidade Horizontal.
Ao invés de termos um "monolito gordo" em um servidor caro, é melhor termos duas instâncias menores da nossa aplicação Spring Boot rodando atrás de um Load Balancer.

- **Custo de Tráfego e Eficiência de Código**
Pagamos por tráfego e requisições (banco de dados, S3, internet).
Código ineficiente custa dinheiro. Um loop infinito chamando o banco de dados (o famoso problema N+1 do Hibernate/JPA) ou trafegar JSONs gigantes desnecessariamente não deixa o sistema lente, deixa a conta cara.
**DevOps**: implemente compressão GZIP em nosso *application.properties* para reduzir o tráfego de saída e economizar na conta de "Data Transfer Out".

- **Automação para Economia (DevOps/IaC)**
Serviços esquecidos geram fatura. A prática recomendada é utilizar #Terraform ou scripts para subir o nosso ambiente de estudo. Terminou de estudar? Roda um *terraform destroy*. Isso vai garantir que não deixamos aquele RDS ou Load Balancer ligado consumindo o nosso dinheiro.
**Segurança:** configurar o AWS Budgets imediatamente após criarmos uma conta na AWS. Cria um alerta para avisar se a nossa conta passar de $10 dólares. 

!![image-202512205441207.png](/image-202512205441207.png)


**Contas Criadas a partir de 15 de julho**
Novo Modelo (Free Plan):
- Podemos usar a AWS gratuitamente por até 6 meses a partir da data de criação da conta;
- Novos usuário s recebem créditos AWS gratuitas (U$100 ao criar + até U $100 POR ATRIVIDAES EXTRAS);
- <span style="background:#affad1">Funções 1 milhão de requisições gratuitas por mês;</span> 
- Free Tier do <span style="background:#b1ffff">Lambda</span> inclui 400 GB-segundos de tempo de computação por mês.
- Se você ultrapassar **1 milhão de requisições em um mês**, será cobrado um valor adicional (~US$ 0,20 por milhão de requisições acima do limite).
- Requisições disparadas por outros serviços "(como API Gateway)" podem ter custos próprios além do Lambda;

## 1.6 Explorando os serviços da AWS
O hardware para computação, armazenamento e rede é a base da nuvem AWS. A AWS executa serviços sobre este hardware. 

Podemos gerenciar os serviços enviando solicitações para a API manualmente via uma interface gráfica baseada na web, como o *Management Console*, uma CLI, ou de forma programaticamente via um SDK. Máquinas virtuais possui um recurso especial: podemos nos conectar a elas via SSH e obter acesso de adm. Logo, podemos instalar qualquer software que desejamos em uma máquina virtual. 

!![image-202512202345430.png](/image-202512202345430.png)

Outros serviços, como o serviço de banco de dados NoSQL, oferecem recursos por meio de uma API e ocultam tudo o que está acontecendo nos bastidores. A figura 1.10 mostra um adm instalando uma aplicação web PHP personalizada em uma máquina virtual e gerenciando serviços dependentes, como um banco de dados NoSQL usado pela aplicação.

![[Pasted image 20251220132507.png]]


Os usuários enviam solicitações HTTP para uma máquina virtual. Esta máquina virtual está executando um servidor web junto com uma aplicação web PHP personalizada. A aplicação web precisa falar com os serviços da AWS para responder às solicitações HTTP dos usuários. Por exemplo, a aplicação pode precisar consultar dados de um banco de dados NoSQL, armazenar arquivos estáticos e enviar e-mail. A comunicação entre a aplicação web e os serviços da AWS é tratada pela API.

Neste livro, selecionamos os serviços que nos ajudarão a começar rapidamente a construir um sistema totalmente capaz, responsivo e confiável, e depois a crescer e manter esse sistema.

Os seguintes serviços são cobertos em detalhes:
- **EC2** — Máquinas virtuais
    
- **ECS e Fargate** — Execução e gerenciamento de contêineres
    
- **Lambda** — Execução de funções
    
- **S3** — Armazenamento de objetos
    
- **Glacier** — Arquivamento de dados
    
- **EBS** — Armazenamento em bloco para máquinas virtuais
    
- **RDS** — Bancos de dados SQL
    
- **DynamoDB** — Banco de dados NoSQL
    
- **SQS** — Filas distribuídas
    
- **CloudWatch** — Monitoramento e logs
    
- **CloudFormation** — Automatizando sua infraestrutura
    
- **IAM** — Restringindo o acesso aos seus recursos de nuvem
    
- (Outros listados: EFS, ElastiCache, VPC, ELB, CodeDeploy)

*Insights Valiosos*
- **SDK vs. CLI vs. Console**
O texto menciona três formas de acesso: Console, CLI e SDK.
Como desenvolver, usaremos o AWS SDK for Java v2. No entanto, ao usar Spring Boot, a melhor prática é utilizar o **Spring Cloud AWS**. Ele atua como um *wrapper* sobre o SDK padrão, permitindo que injete clientes como S3Client ou SqsTemplate via injeção de dependência @Autowired, seguindo os padrões idiomáticos do Spring, ao invés de instanciar clientes manualmente com padrões *Builder*.

- **DevOps:** nunca utilize o Console para criar recursos de produção ("ClickOps"). Use o Console apenas para leitura e visualização. Para criação, use IaC (Terraform/CloudFormation). Para scripts rápidos de automação, use o AWS CLI.

- **Pets vs. Cattle (Máquinas Virtuais e SSH)**
Podemos nos conectar via SSH e instalar qualquer software. Embora possível, em arquiteturas modernas (Cloud Native), evitamos tratar servidores como "animais de estimação" (onde entramos via SSH para cuidar e instalar as coisas manualmente).
**Abordagem Moderna (Docker/Kubernetes)**: empacotamos a aplicação Java e suas dependências em uma Docker. Usamos o ECS/Fargate ou Kubernates. Se precisarmos rodar em EC2, usamos "User Data" ou imagens prontas (AMIs) para que a máquina já nasça configurada. SSH em produção deve ser a exceção absoluta, não a regra.


## 1.7 Interacting with AWS
### 1.7.3 SDKs
Use our favorite programming language to interact with de AWS API. AWS offers SDKs for the following platforms and languages:
- JavaScript
- .NET
- Python
- PHP
- Java
- Node
- Go
- C++

SDKs are typically used to integrate AWS services into applications. If we're doing software development and want to integrate an AWS service like a NoSQL database or a push-notification service, an SDK is the right choice for the job. Some services, such as queues and topics, must be used with an SDK.

