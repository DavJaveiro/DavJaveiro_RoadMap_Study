Capítulo conceitual, não há muita configuração técnica, mas é a base do *vocabulário AWS*. Se não entendermos a diferença entre IaaS e PaaS agora, erraremos questões sobre #RDS vs #EC2 lá na frente.

---
## Semana 1: Fundamentos e Modelos de Nuvem (19/11 a 25/11)
**O que fazer ao ler:**
1. **NIST Characteristics (Elasticity vs Scalability):**
    - _Conceito:_ Entenda a diferença sutil. Escalabilidade é crescer; Elasticidade é crescer **e encolher** automaticamente conforme a demanda.
    - _Ação Anki:_ Crie cards de cenário.
        
2. **Service Models (IaaS vs PaaS vs SaaS):**
    - _Conceito:_ Quem gerencia o Sistema Operacional? Se é você = IaaS (EC2). Se é a AWS = PaaS (RDS, Lambda).
    - _Ação Anki:_ Associe serviços aos modelos.

**Estratégia Anki (Exemplos Práticos para Copiar):**
> **Card Tipo:** Omissão (Cloze) **Texto:** Em um modelo {{c1::IaaS}}, o cliente é responsável pelo gerenciamento do Sistema Operacional, enquanto no {{c2::PaaS}}, a AWS gerencia o SO e o runtime.

> **Card Tipo:** Basic (Conceito) **Frente:** Qual característica da Cloud Computing (NIST) permite que recursos sejam provisionados e liberados automaticamente para escalar rapidamente para dentro e para fora com a demanda? **Verso:** Rapid Elasticity (Elasticidade Rápida).

---
O exame SAA-C03 mede nossa competência técnica em **architecting workloads** (arquitetar cargas de trabalho) para rodar com sucesso na nuvem AWS. A AWS não espero que sejamos um especialista em cada serviço de nuvem (isso é impossível). No entanto, eles esperam que demonstremos alto nível de competência sobre como #architect (desenhar, fazer o **deploy**, monitorar e gerenciar) workloads baseados nos domínios de conhecimento do exame. 

**💡Orientação de Estudo:**
- A prova quer saber se sabemos **COMO** desenhar um sistema que seja seguro, rápido e barato.
- **Mentalidade:** como desenvolvedor Java, estamos acostumados a pensar em código. Aqui, precisamos subir o nível de abstração: pensar em **componentes** (O Banco de Dados, O Servidor de Aplicação, O Balanceador de Carga).

Se temos um background técnico, mas não sabe muito sobre a nuvem AWS, comece por este primeiro capítulo e leia cuidadosamente.

Precisamos de aproximadamente 72% de acerto para passar (a nota é de 100 a 1000, precisamos de 720). O exame tem **65 questões** de múltipla escolha. **IMPORTANTE:** 15 dessas 65 questões são **BETA QUESTIONS** (questões de teste da AWS) e **não contam na nota!** Portanto, apenas 50 questões valem a nota. Se acertarmos aproximadamente 37 questões das 50 que contam, passamos.

- Isso é vital para o seu psicológico durante a prova. Você vai encontrar questões muito estranhas ou difíceis. **Assuma que elas são as Beta Questions**, não entre em pânico e siga para a próxima.

**Sistema de Pontuação (Scaled Scoring)**
O exame é corrigido usando **Scaled Scoring**. As nossas questões provavelmente não serão as mesmas do candidato ao lado. A dificuldade de cada questão é **Weighted (ponderada)** para garantir que o nível de conhecimento exigido seja consistente.

**💡O que significa:*** Não podemos nos desesperar se pegarmos uma prova que pareça impossível. Se as questões forem muito difíceis, elas valem mais, e precisamos acertar menos delas para passar. O sistema equilibra a dificuldade.

- **Read the FAQs:** cada serviço tem uma página de perguntas frequentes. Não devemos ler tudo agora, quando estudarmos o Capítulo do S3, leremos o FAQ.
- **Read the AWS Well-Architected Framework PDFs:** o exame é baseado nesses PDFs. Eles definem a mentalidade da AWS. 
****💡Orientação de Estudo:*** O texto destaca os pilares: _Security, Reliability, Performance Efficiency, Cost Optimization_. (Nota: Hoje existem 6 pilares, incluindo _Operational Excellence_ e _Sustainability_, mas foque nos que o livro pede por enquanto).

- **Use the AWS Well-Architected Tool:** Uma ferramenta no console da AWS onde respondemos perguntas sobre nossa arquitetura e se ela está segura ou não.

*There is no hardware ownership, the cloud provider owns the services, and customers rent cloud services as required.*
Não existe Hardware Ownership (Propriedade de Hardware), o provedor de nuvem é dono dos serviços, e os clientes alugam serviços de nuvem conforme necessário.

Isso é o básico de OPEX (Despesa Operacional) vc CAPEX (Despesa de Capital). Na nuvem, trocamos investimento fixo (comprar servidor) por custo variável (aluguel).

Podemos pensar que a nuvem pública só oferece recursos virtuais, mas a AWS pode fornecer servidores **Bare Metal** (físicos, dedicados, sem virtualização) se solicitado.

A AWS tem instâncias EC2 do tipo *Bare Metal*. 
- *Cenário de Prova:* "uma empresa tem um software legado com uma licença complexa que exige acesso direto ao hardware físico ou contagem específica de núcleos físicos. Como migrar para a AWS?" Resposta: Usar EC2 Bare Metal Instances.

A AWS também oferece o AWS Outposts, que permite aos clientes rodar um número crescente de serviços de nuvem AWS On-Premises (no seu próprio data center).

*Cenário de prova:* Um hospital precisa processar imagens de raio-X com latência de microssegundos e os dados não podem sair do prédio por regulação, mas eles querem usar as APIs da AWS. **AWS Outposts (A AWS literalmente manda um rack de servidor para o seu prédio)**.

A maioria dos serviços (como Load Balancers ou RDS) roda em cima de máquinas virtuais **Amazon EC2**. O texto também cita o AWS Config (gerencia compliance/conformidade) e o **AWS Backup** (serviço centralizado de backup).


## AWS Cloud Computing and NIST
As cincos características essenciais do modelo de nuvem definidas pelo NIST são:
1. **On-demand Self-service (Autoatendimento sob demanda)**: clicamos em um botão e o servidor aparece. Não precisamos ligar para um técnico ou abrir um ticket de suporte.
2. **Broad Network Access (Amplo acesso à rede):** acessamos o serviço via internet, de qualquer dispositivo (celular, notebook), em qualquer lugar.
3. **Resource Pooling (Agrupamento de recursos):** o hardware físico é compartilhado entre vários clientes (Multi-tenancy), mas nós não visualizamos o vizinho.
4. **Rapid Elasticity (Elasticidade Rápida):** capacidade de crescer e diminuir recursos instantaneamente (muitas vezes automaticamente).
5. **Measured Service (Serviço Medido):** modelo de "pague pelo o que usar" (utility billing), igual conta de luz ou água.

On-demand Self-Service e o Rapid Elasticity.

A AWS cobra muito sobre como a elasticidade funciona e *como* a cobrança é feita (especialmente tráfego de dados).

1. **On-Demand Self-Service (Autoatendimento sob demanda)**
	- **Conceito**: não pedimos permissão. Clicamos e utilizamos
	- **Na prova:** se uma questão disser que um desenvolvedor teve que abrir um ticket para a TI provisionar um servidor, isso **viola** esse princípio. Na AWS, usamos o **Management Console**, CLI ou SDKs para provisionar em minutos/segundos.
2. **Broad Network Access (Amplo acesso à rede)**
	- **A pegadinha:** o texto diz que isso geralmente é via internet (HTTPS).  Mas a AWS alerta: "our company might not want... public Internet".
	- **Conceito chave:** acesso via VPN ou AWS Direct Connect (fibra dedicada) também conta como *Broad Network Access privado*.
3. **Resource Pooling (Agrupamento de Recursos)**
	- O segrego: a AWS tem Regions (Regiões) e Availability Zones (AZs).
	- **S3 Unlimited:** "Amazon s3 object storage is offered as unlimited."
		- Na prova, nunca devemos responder que o S3 "encheu". Podemos não ter o dinheiro para pagar, mas espaço, nunca falta.
4. **Rapid Elasticity (Elasticidade Rápida)**
	- Horizontal vs Vertical: não desligamos servidores para adicionar RAM (vertical Scaling). Realizamos isso **Horizontal Scaling** (adicionando mais servidores).
	- **Automação**: o EC2 Auto Scaling trabalha junto como **Amazon CloudWath** (monitoramento) para adicionar/remover máquinas automaticamente baseada na carga (ex: manter CPU em 65%).
5. **Measured Service (Serviço Medido) CRÍTICO**
	- Ingress (Entrada): (entrar dados na nuvem é grátis);
	- Egress (Saída): (tirar dados da nuvem custa dinheiro). #Egress é todo dado que sai da nuvem para qualquer lugar: para nossa máquina local, para outra nuvem, para outro provedor, para a internet pública, para a casa do cliente. 
	- Ferramentas de Custo: AWS Cost Explorer, AWS Budgets.

**Mindsets (Corporativo vs Startup)**
Startups tendem a usar mais PaaS/Serverless para velocidade, e Corporações tendem a fazer *Rehost* (Lift and Shift) usando IaaS (EC2) inicialmente.

## Platform as a Service (PaaS)

![image-202511194754543.png](/image-202511194754543.png)

1. **O Conceito de PaaS (Platform as a Service)**
Usar um provedor PaaS significa que os desenvolvedores não precisam criar e gerenciar manualmente a infraestrutura. O provedor gerencia o SO, o runtime (ex: JVM), o patch de segurança e o escalonamento.
- **IaaS (EC2)**: nós gerenciamos o SO, instalamos o Java, configuramos o Tomcat.
- **PaaS (Elastic Beanstalk):** você só faz upload do código. A AWS provisiona o EC2, instala o Java e o Tomcat para nós.

1. O perigo da Compatibilidade (Vendor Lock-in)
O PaaS de um vendor (Heroku) não é compatível com outro (Azure). A prova quer saber se entendemos que migrar um PaaS é mais difícil que migrar uma VM (IaaS), porque ficamos dependente das APIs da plataforma.

2. **AWS Elastic Beanstalk**
O Elastic Beanstalk é um serviço gerenciado que libera o cliente de configurar infraestrutura. Ele lida automaticamente com:
- Provisionamento de capacidade (sobe as VMs)
- Load Balancing (balanceamento de carga)
- Auto Scaling (aumenta/diminui servidores)
- Monitoramento de saúde da aplicação (Health Checks)

💡 Ouro para a Prova: Sempre que a questão disse: *Uma equipe de desenvolvedores quer fdazer deploy de uma aplicação Java/PHP/Python rapidamente, eles não têm conhecimento de SysAdmin e não querem gerenciar servidores/SO. Qual a melhor solução?* A resposta é **AWS Elastic Beanstalk**.

4. As ferramentas de Desenvolvimento (Dev Tools)
O texto menciona brevemente uma suite de ferramentas. 
- AWS Cloud9: IDE no navegador (para escrever código)
- AWS CodeCommit: repositório Git gerencial (igual GitHub/GitLab)
- AWS CodeBuild: compila e testa código (igual Jenkins)
- AWS CodeDeploy: automatiza o deploy nas máquinas.

!![image-202511193921644.png](/image-202511193921644.png)

No mundo real, poderíamos rodar Spring Boot num EC2 simples (java -jar app.jar).
No Elastic Beanstalk, subimos o .jar e ele cria o EC2, configura o Nginx como proxy reverso e roda a nossa aplicação.
O Elastic Beanstalk usa recursos de IaaS por baixo dos panos. Ou seja, ele cria instâncias EC2 em nossa conta. Podemos ver essas instâncias no console e até conectar nelas via SSH se quisermos (embora não seja recomendado em PaaS).


1. **Servidores e Custo (TCO)**: o texto reforça que mover para a nuvem reduz custos de operação (energia, refrigeração) e licenças de hipervisor. A AWS tem opções desde 1 CPU (para testes) ate centenas de núcleos (para HPC - High Performance Computing).
2. **Armazenamento (Storage)**: aqui temos a primeira menção explícita da diferença entre os tipos de storage.
	1. Amazon EBS: disco virtual (Hard Drive). É um "HD" do nosso servidor EC2.
	2. Amazon S3: armazenamento de objetos ilimitados (Arquivos, imagens, backups);
	3. Amazon S3 Glacier: arquivo morto (barato, mas lento para recuperar);
3. **Monitoramento (Monitoring)**
	1. On-Prem: Nagios, SolarWinds.
	2. AWS: Amazon CloudWatch
	3. Regra: se a questão falar em "métricas", "logs", "monitoramento de CPU" ou "alarmes", a resposta é #CloudWatch.
4. **Backup e Híbrido**
	1. AWS Storage Gateway: Esse serviço é vital. Ele conecta nosso data center local ao S3.
	2. _Cenário:_ "A empresa quer manter arquivos acessados frequentemente no escritório local (cache) para ser rápido, mas quer que o resto vá para a nuvem automaticamente." -> **Storage Gateway**.
	3. AWS Backup: serviço centralizado para gerenciar backups de tudo (EC2, RDS, EBS).
5. **Identidade (Identity Management)**
	1. On-Prem: Microsoft Active Directory (AD).
	2. AWS: AWS Directory Service
	3. A AWS não quer que eu recrie meus 5.000 usuários. Ela quer que integre o nosso AD atual, com a AWS, o serviço que faz essa ponte é o AWS Directory Service.



---
#### Semana 2: Segurança, Migração e Well-Architected (26/11 a 02/12)

**O que fazer ao ler:**
1. **Shared Responsibility Model (Modelo de Responsabilidade Compartilhada):**
    - Este é um dos tópicos mais cobrados. Decore: **Segurança DA nuvem** (AWS) vs **Segurança NA nuvem** (Você).
    - _Exemplo:_ A AWS protege o hardware físico. Você protege os dados do cliente e criptografia.

![Imagem de AWS Shared Responsibility Model diagram](https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRlUc7t-SC3hWCy4z7XWVWwbTWXRgYEiQiq19NB4XiyORowYreu2rl7qKCtSgsrcUHErD-N5HzbHwGnwAPkY6ZQ3i4knZDEgr0ilGuqV8ARsHhFO3o)

2. **Migrating Applications (Os "Rs" da migração):**
    - O texto menciona "Applications with local dependencies" (Refactor/Re-architect) e "Hosted on EC2 with no changes" (Rehost/Lift-and-Shift).
    - _Ação:_ Entenda quando _não_ migrar (Retire/Retain).
        
3. **Well-Architected Framework:**
    - Não tente decorar todo o whitepaper agora. Apenas saiba quais são os **6 Pilares** (Operational Excellence, Security, Reliability, Performance Efficiency, Cost Optimization, Sustainability).
        

**Estratégia Anki (Cenários):**
> **Card Tipo:** Cenário (O Pulo do Gato) **Frente:** Uma empresa quer migrar uma aplicação legada "as-is" (exatamente como está) para a AWS o mais rápido possível para fechar o data center. Qual estratégia de migração é essa? **Verso:** Rehost (Lift-and-Shift).

> **Card Tipo:** Cenário (Segurança) **Frente:** Quem é responsável por aplicar patches de segurança no sistema operacional de uma instância Amazon EC2? **Verso:** O Cliente (pois EC2 é IaaS). Se fosse RDS (PaaS), seria a AWS.


### 🛠️ Tarefa Prática Obrigatória (Hands-on)

Como este capítulo é teórico, seu "Lab" será administrativo. Não pule isso!
1. **Crie sua conta AWS Free Tier** (se não tiver).
2. **Configure o MFA (Multi-Factor Authentication)** no usuário Root. (Segurança básica).
3. **Crie um Billing Alarm (Alarme de Faturamento):** Configure para receber um e-mail se a conta passar de $5 USD. Isso evita surpresas no cartão de crédito enquanto você estuda.
    
### ✅ Checklist para finalizar o Capítulo 1

- [ ] Li todo o capítulo focado em garimpar conceitos.
- [ ] Criei pelo menos 15-20 cards no Anki cobrindo IaaS/PaaS, NIST e Modelo Compartilhado.
- [ ] Configurei MFA e Billing Alarm na AWS.
- [ ] Entendi a diferença entre "Rehost" e "Refactor".
- [ ] 


