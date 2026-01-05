Para iniciarmos a nossa jornada em serverless, faremas um breve tour pela nuvem e, em seguida, definiremos o que é serverless. Depois disso, entraremos na AWS, isso será novidade para alguns de nós. 

Com esses fundamentos estabelecidos, apresentaremos o Lambda, o que é, por que podemos usá-lo, o que podemos construir com ele e como Java e Lambda trabalham juntos.

**Uma Breve Lição de História** Vamos viajar de volta no tempo para 2006. Ninguém tem um iPhone ainda, Ruby on Rails é o ambiente de programação "quente" do momento e o Twitter está sendo lançado. Mais relevante para nós, no entanto, é que neste ponto no tempo muitas pessoas estão hospedando suas aplicações server-side em servidores físicos que elas possuem e instalaram em racks em um data center.

Em agosto de 2006, algo aconteceu que mudaria fundamentalmente esse modelo. A nova divisão de TI da Amazon, a AWS, anunciou o lançamento do Elastic Compute Cloud (EC2).

O EC2 foi um dos primeiros produtos de infraestrutura como serviço (IaaS). IaaS permite que empresas aluguem capacidade computacional, isto é, um host para rodar nossas aplicações de servidor voltadas para a internet, em vez de comprar suas próprias máquinas. Também permite provisionar hosts *just-in-time*  {na hora exata}, reduzindo a demora entre a solicitação de uma máquina e sua disponibilidade para a ordem de minutos. Em 2006, tudo isso foi possível devido aos avanços na tecnologia de virtualização, todos os hosts EC2 naquela época eram máquina virtuais. 

As cinco principais vantagens do EC2 são:
- **Custo de mão de obra reduzido:** antes da IaaS, as empresas precisavam contratar equipes de operações técnicas específicas que trabalhariam em data centers e gerenciariam seus servidores físicos. Isso significava tudo, desde energia e rede até instalação em racks e reparo de problemas físicos com máquinas, como memória RAM defeituosa, até a configuração do sistema operacional (SO). Com IaaS, tudo isso desaparece e se torna responsabilidade do provedor de serviço IaaS (AWS, no caso do EC2).

- **Risco reduzido:** ao gerenciar seus próprios servidores físicos, as empresas ficam expostas a problemas causados por incidentes não planejados, como falhas de hardware. Isso introduz períodos de inatividade de duração altamente volátil, já que problemas de hardware geralmente são infrequentes e podem levar muito tempo para serem corridigos. Com IaaS, o cliente embora ainda tenha algum trabalho a fazer no caso de uma falha de hardware, não precisa mais saber como consertar o hardware. Em vez disso, o cliente pode simplesmente solicitar uma nova instância de máquina, disponível em poucos minutos, e reinstalar a aplicação, limitando a exposição a tais problemas.

- **Custo de infraestrutura reduzido:** em muitos cenários, o custo de uma instância EC2 conectada é mais barato do que manter seu próprio hardware, quando se leva em conta energia, rede, etc. Isso é especialmente válido quando você quer rodar hosts por apenas alguns dias ou semanas, em vez de muitos meses ou anos a fio. Da mesma forma, alugar hosts por hora em vez de comprá-los permite uma contabilidade diferente: máquinas EC2 são uma despesa operacional (Opex) em vez de despesas de capital (Capex) de máquinas físicas, permitindo tipicamente uma flexibilidade contábil muito mais favorável.

- **Escalabilidade:** os custos de infraestrutura caem significativamente ao considerar os benefícios de escalabilidade que a IaaS traz. Com IaaS, as empresas têm muito mais flexibilidade para escalar a quantidade e os tipos de servidores que executam. Não há mais necessidade de comprar 10 servidores de ponta antecipadamente porque você acha que pode precisar deles em alguns meses. Em vez disso, você pode começar com uma ou duas máquinas virtuais (VMs) de baixa potência e baixo custo e, então, aumentar e diminuir o número e tipos de VMs ao longo do tempo sem qualquer impacto negativo nos custos.

- **Tempo de espera (Lead time)**: nos velhos tempos ruins de servidores auto-hospedados, poderia levar meses para adquirir e provisionar um servidor para uma nova aplicação. Se você tivesse uma ideia que quisesse testar dentro de algumas semanas, azar o seu. Com IaaS, o tempo de espera vai de meses para minutos. Isso inaugurou a era da experimentação rápida de produtos, conforme encorajado pelas ideias do *Lean Startup*.

*Insights*
No modelo IaaS descrito (EC2), o Spring Boot brilhava ao empacotar um servidor web (Tomcat/Jetty) dentro do JAR. A aplicação ficava rodando 24/7 esperando requisições. 
Ao mover para Lambda, o modelo "servidor embutido" do Spring Boot tradicional torna-se um peso desnecessário. O Insight aqui é entender que migrar de EC2 para Lambda exige abandonar o contêiner web tradicional e adotar abordagens como **Spring Cloud Function** ou adaptações via **AWS Serverless Java Container**. Não precisamos mais gerenciar a thread do Tomcat; a AWS invoca o método diretamente.

**Gerenciamento de Estado e Memória (JAVA):**
O texto menciona "bad RAM" em servidores físicos. No EC2, controlamos a JVM (Heap, Garbare Collection) e ela persiste por dias.

Em Serverless, o hardware é efêmero. Nossa aplicação Java sobe, executa e congela/morre. Isso torna **Singleton Beans** so Spring perigosos se guardarem estado de usuário, pois o container pode ser reutilizado para outro usuário. O gerenciamento de memória torna-se uma questão de custo direto: pagamos por GB-segundo. Otimizar o consumo de memória do Spring não é mais sobre performance, é sobre fatura no fim do mês.

**Custo e Cold Starts**
O scaling do EC2 é lento (minutos para bootar uma VM). O scaling do Lambda é milissegundos. Porém, Java tem o famoso "Cold Start" (tempo para subir a JVM e o Contexto do Spring).
Podemos utilizar GraalVM Native Images ou AWS Lambda SnapStart para eliminar esse delay. O modelo mental de deixar o servidor ligado morre aqui.

## A Nuvem Cresce
A IaaS foi um dos primeiros elementos-chave da nuvem, juntamente com o armazenamento (por exemplo, AWS Simple Storage Service (S3)). A AWS foi uma das primeira a atuar em serviços de nuvem e ainda é uma provedora líder, mas existem muitos outros fornecedores, como Microsoft e Google.

A próxima evolução da nuvem foi a Plataforma como Serviço (PaaS). Um dos provedores de PaaS mais populares é o Heroku. O PaaS atua como uma camada acima da IaaS, abstraindo o gerenciamento do sistema operacional do host. Com PaaS, implantamos apenas as aplicações, e a plataforma é responsável pela instalação do SO, atualizações de patch, monitoramento em nível de sistema, descoberta de serviço, etc.

Uma alternativa ao uso de PaaS é utilizar contêineres. O Docker tornou-se incrivelmente popular nos últimos anos como uma maneira de delinear mais claramente os requisitos de sistema de uma aplicação em relação aos detalhes minuciosos do próprio sistema operacional. Existem serviços baseados em nuvem para hospedar e gerenciar/orquestrar contêineres em nome de uma equipe; estes são frequentemente referidos como produtos de Contêineres como Serviço (CaaS). Amazon, Google e Microsoft oferecem plataformas CaaS. O gerenciamento de frotas de contêineres Docker foi facilitado pelo uso de ferramentas como Kubernetes, seja em uma forma autogerenciada ou como parte de um CaaS (por exemplo, GKE do Google, EKS da Amazon ou AKS da Microsoft).

Todas essas três ideias, IaaS, PaaS e CaaS, podem ser agrupadas como "computação como serviço"; em outras palavras, são diferentes tipos de ambientes genéricos nos quais podemos rodar nosso próprio software especializado. PaaS e CaaS diferem da IaaS por elevarem ainda mais o nível de abstração, permitindo-nos transferir mais do nosso "trabalho pesado" para terceiros.

*Insight:* Ao ir para CaaS (Docker) ou Serverless (Lambda), o Spring Boot tradicional carrega muitas dependências que eram vitais para PaaS (gerenciamento de threads, servlets complexos), mas que no Lambda aumentam o *Cold Start*. O uso de **Spring Framework 6+ e Spring Boot 3+** com foco em AOT (Ahead-of-Time compilation) é a resposta para manter o Java relevante nessa nova abstração.

**Erro Comum:** tratar lambda como um "Docker que roda rápido".
*Insight:* no Docker, nossa JVM roda continuamente. No lambda, ela congela. Se nós utilizamos connection pools de banco de dados (HikariCP, padrão no Spring), no Docker eles mantêm conexões vivas. No Lambda, eles podem causar erros de conexão fechada ou exaurir as conexões do banco se não configurados corretamente (ou se não usarmos o Amazon RDS Proxy).

- Hoje, temos o AWS Fargate, que é "Servless for Coantiners". Rodamos Docker sem gerenciar servidores (EC2), unindo o mundo dos contêineres com o modelo de cobrança e gestão do Serveless.

## Entrando no Mundo Serverless
Serverless é a próxima evolução da computação em nuvem e poder ser dividido em duas ideias: Backend como Serviço (BaaS) e Funções como Serviço (FaaS).

### Backend como Serviços (BaaS)
O Backend como Serviço (BaaS) nos permite substituir componentes do lado do servidor que nós mesmos programaríamos e/ou gerenciaríamos por serviços prontos ("off-the-shelf"). Conceitualmente, está mais próximo do Software como Serviço (SaaS) do que de coisas como instâncias virtuais e contêineres. O SaaS é tipicamente sobre terceirizar processos de negócios, pense em ferramentas de RH, vendas ou, no lado técnico, produtos como GitHub, enquanto com o BaaS, estamos quebrando nossas aplicações em pedaços menores e implementando alguns desses pedaços inteiramente com produtos hospedados externamente. 

Serviços BaaS são componentes remotos de domínio genérico (ou seja, não são bibliotecas em processo) que podemos incorporar em nossos produtos, sendo a interface de programação de aplicações (API) um paradigma típico de integração.

O BaaS tornou-se especialmente popular com equipes que desenvolvem aplicativos móveis ou aplicaçoes web de página única SPA. Muitas dessas equipes conseguem depender significativamente de serviços de terceiros para realizar tarefas que, de outra forma, precisariam fazer sozinhas. Vamos olhar alguns exemplos.

Primeiro, temos serviços como o Firebase do Google. O Firebase é um produto de banco de dados totalmente gerenciado por um fornecedor (Google, neste caso) que pode ser acessado diretamente de uma aplicação móvel ou web sem a necessidade de nosso próprio servidor de aplicação intermediário. Isso representa um aspecto do BaaS: serviços que gerenciam componentes de dados em nosso nome.

Serviços BaaS também nos permitem contar com a lógica de aplicação que outra pessoa implementou. Um bom exemplo aqui é a autenticação — muitas aplicações implementam seu próprio código para realizar cadastro, login, gerenciamento de senhas, etc., mas na maioria das vezes esse código é semelhante entre muitos aplicativos. Tal repetição entre equipes e empresas está pronta para ser extraída para um serviço externo, e esse é precisamente o objetivo de produtos como AuthO e Amazon Cognito. Ambos permitem que aplicativos móveis e web tenham autenticação e gerenciamento de usuários completos, mas sem que a equipe de desenvolvimento precise escrever ou gerenciar qualquer código para implementar esses recursos.

O termos BaaS ganhou destaque com o aumento do desenvolvimento de aplicativos móveis; de fato, o termo às vezes é referido como *Mobile Backend as a Service (MBaaS)*. No entanto, a ideia chave de usar produtos totalmente gerenciados externamente como parte de desenvolvimento da nossa aplicação não é exclusiva do desenvolvimento móvel, ou mesmo do desenvolvimento frontend em geral.

**Funções como Serviço (FaaS):**
A outra metade do serverless é Funções como Serviço (FaaS). FaaS, assim como IaaS, PaaS e CaaS, é outra forma de computação como serviço, um ambiente genérico dentro do qual podemos rodar nosso próprio software. Algumas pessoas preferem usar o termo *serverless compute* em vez de FaaS.

Com FaaS, implantamos nosso código como funções ou operações independentes e configuramos essas funções para serem chamadas, ou acionadas, quando um evento ou requisição específica ocorre dentro da plataforma FaaS. A própria plataforma chama nossas funções instanciando um ambiente dedicado para cada evento, este ambiente consiste em uma máquina virtual leve ou contêiner efêmero e totalmente gerenciado; o runtime do FaaS; e nosso código.

O resultado desse tipo de ambiente é que não temos preocupação com o gerenciamento do runtime do nosso código, ao contrário de qualquer outro estilo de plataforma de computação. Além disso, devido a vários fatores do serverless em geral que descreveremos em um momento, com FaaS não temos preocupação com hosts ou processos, e o escalonamento e o gerenciamento de recursos são tratados em nosso nome. 

### Diferenciando o Serverless
A ideia de usar componentes de aplicação hospedados externamente, como fazemos com BaaS, não é nova, as pessoas usam bancos de dados SQL hospedados há uma década ou mais, então o que faz alguns desses serviços se qualificarem como backends como serviço? E quais aspectos BaaS e FaaS têm em comum que nos levam a agrupá-los na ideia de computação serverless?

Existem cinco critérios principais que diferenciam o serviços serverless, tanto BaaS quanto FaaS que nos permitem abordar a arquitetura de aplicações de uma nova maneira. Esses critérios são os seguintes:
1. **Não requer gerenciamento de um host ou instância de aplicações de longa duração:** este é o núcleo do serverless. A maioria das outras formas de operar software no servidor exige que implantemos, executemos e monitoremos uma instância de uma aplicação, e a vida útil dessa aplicação abrange mais de uma requisição. Serverless implica o oposto: não há processo de servidor ou host de longa duração que precisemos gerenciar. Isso não significa que esses servidores não existam, eles absolutamente existem, mas não são nossa preocupação ou responsabilidade.
2. **Autoescalável e autoprovisionável, depende da carga:** o autoescalonamento é a capacidade de um sistema ajustar os requisitos de capacidade dinamicamente com base na carga. A maioria das soluções de autoescalonamento existentes exige algum trabalho da equipe que as utiliza. Serviços serverless se autoescalam desde a primeira vez que você os usa, sem nenhum esforço. Serviços serveless também se autoprovisionam quando realizam o autoescalonamento. Eles removem todo o esforço de alocar capacidade, tanto em termos de número quanto de tamanho dos recursos subjacentes. Isso é um enorme fardo operacional removido.
3. **Possui custos baseados no uso preciso, desde zero até o pico:** isso está intimamente ligado ao ponto anteiror, os custos de serverless são precisamente correlacionados com o uso. O custo de usar o banco de dados BaaS, por exemplo, deve estar intimamente ligado ao uso, não a uma capacidade predefinida. Esse custo deve ser largamente derivado da quantidade real de armazenament usado e/ou requisições feitas. Note que não estamos dizendo que os custos devem ser baseados unicamente no uso, pode haver algum custo fixo pelo uso do serviço em geral, mas a maior parte dos custos deve ser proporcional ao uso granular.
4. **Possui capacidades de desempenho definidas em termos que não sejam tamanho/quantidade de host:** é razoável e útil para uma plataforma de serverless expor alguma configuração de desempenho. No entanto, essa configuração deve ser completamente abstraída de quaisquer tipos de instância ou host subjacentes que estejam sendo usados.
5. **Possui alta disponibilidade implícita:** ao operar aplicações, tipicamente usamos o termo alta disponibilidade (HA) para significar que um serviço continuará a processar requisições mesmo quando um componente subjacente falhar. Com um serviço serverless, esperamos que o fornecedor entregue de forma transparente HA de forma transparente para nós. Como exemplo, se estamos usando um banco de dados BaaS, assumimos que o provedor está fazendo o que for necessário para lidar com a falha de hosts individuais ou componentes internos.


- **"No concern for runtime management" (Nenhuma preocupação com runtime):** Isso é uma meia-verdade perigosa para Java. Você _precisa_ se preocupar com a versão do Java (8, 11, 17, 21) no Lambda, pois versões mais novas trazem melhorias de performance e Garbage Collectors mais eficientes para serverless. Você não gerencia o SO, mas gerencia a escolha da JVM.


## O que é o AWS Lambda?
O Lambda é a plataforma FaaS da Amazon. Mencionamos FaaS brevemente antes, mas agora é hora de nos aprofundarmos com mais detalhes.

**Funções como Serviço (FaaS)**
FaaS é uma nova maneira de construir e implantar software no lado do servidor, orientada em torna da implantação de funções ou operações individuais. É do FaaS que vem muito do burburinho sobre *serverless*; de fato, muitas pessoas acham que *serverless* é apenas FaaS, mas elas estão perdendo a visão completa. Embora este livro foque em FaaS, encorajamos você a considerar o BaaS também ao construir aplicações maiores.

Quando implantamos software *serverless* tradicional, começamos com uma instância de host, tipicamente uma instância de VM ou um contêiner. Então, implantamos nossa aplicação, que geralmente roda como um processo do sistema operacional, dentro do host. Geralmente, nossa aplicação contém código para várias operações diferentes, mas relacionadas; por exemplo, um serviço web pode permitir tanto a recuperação quanto a atualização de recursos. Do ponto de vista de propriedade, nós, como usuários, somos responsáveis por todos os três aspectos dessa configuração, instância do host, processo da aplicação e, claro, operações do programa.

O FaaS muda esse modelo de implantação e propriedade. Nós removemos tanto a instância do host quanto o processo da aplicação do nosso modelo. <span style="background:#affad1">Em vez disso, focamos apenas nas operações ou funções individuais que expressam a lógica da nossa aplicação.</span> Fazemos o upload dessas funções individualmente para uma plataforma FaaS, que em si é responsabilidade do provedor de nuvem e não nossa.

As funções não ficam constantemente ativas em um processo de aplicação, ficando ociosas até precisarem ser executadas, como fariam em um sistema tradicional. <span style="background:#affad1">A plataforma FaaS é configurada para escutar um evento específico para cada operação</span>. Quando esse evento ocorre, a plataforma instancia a função FaaS e então a chama, passando o evento acionador. Uma vez que a função tenha terminado a execução, a plataforma FaaS está livre para derrubá-la (encerrá-la). Alternativamente, como uma otimização, ela pode manter a função ativa por um curto período até que haja outro evento a ser processado.

**FaasS Implementado pelo Lambda**
O AWS Lambda foi lançado em 2014 e continua a crescer em escopo, maturidade e uso. Algumas funções Lambda podem ter um rendimento (_throughput_) muito baixo — talvez executando apenas uma vez por dia, ou até menos frequentemente que isso. Mas outras podem ser executadas bilhões de vezes por dia. O Lambda implementa o padrão  FaaS instanciando ambientes Linux efêmeros e gerenciados para hospedar cada uma das nossas instâncias de função. O Lambda garante que apenas um evento é processado por ambiente de cada vez. <span style="background:#affad1">No momento da escrita deste texto, O Lambda também exige que a função complete o processamento do eventro dentro de 15 minutos; caso contrário, a execução é abortada. </span>

O Lambda fornece um modelo de programação e implantação excepcionalmente leve, nós apenas fornecemos uma função, e dependências associadas, **em um arquivo ZIP ou JAR**, e o Lambda gerencia totalmente o ambiente de execução *runtime*. O Lambda é fortemente integrado com muitos outros serviços AWS. Isso corresponde a muitos tipos diferentes de fontes de evento que podem acionar funções Lambda, e isso leva à capacidade de construir muitos tipos diferentes de aplicações usando Lambda.

O Lambda é um serviço totalmente *serverless*, conforme definido pelos nossos critérios de diferenciação anteriores, especificamente:
**Não requer gerenciamento de um host ou instância de aplicação de longa duração** Com o Lambda, somos totalmente abstraídos do host subjacente executando nosso código. Além disso, não gerenciamos uma aplicação de longa duração — uma vez que nosso código terminou de processar um evento particular, a AWS está livre para encerrar o ambiente de execução.

**Autoescalável e autoprovisionável, dependente da carga** Este é um dos principais benefícios do Lambda — o gerenciamento de recursos e o escalonamento são completamente transparentes. Uma vez que fazemos o upload do nosso código de função, a plataforma Lambda criará ambientes suficientes apenas para lidar com a carga em qualquer momento específico. Se um ambiente for suficiente, o Lambda criará o ambiente quando for necessário. Se, por outro lado, centenas de instâncias separadas forem necessárias, o Lambda escalará rapidamente e sem qualquer esforço da nossa parte.

**Possui custos baseados no uso preciso, desde zero até o pico** A AWS cobra pelo Lambda apenas pelo tempo que nosso código está executando por ambiente, com uma precisão de até 100 ms [Nota: agora é 1ms]. Se nossa função está ativa por 200 ms a cada 5 minutos, seremos cobrados apenas por 2,4 segundos de uso por hora. Essa estrutura de custo de uso preciso é a mesma, seja exigida uma instância da nossa função ou mil.

**Possui capacidades de desempenho definidas em termos que não sejam tamanho/quantidade de host** Como somos totalmente abstraídos do host subjacente com o Lambda, não podemos especificar um número ou tipo de instâncias EC2 subjacentes para usar. Em vez disso, especificamos quanta memória RAM nossa função requer (até um máximo de 3GB [Nota: agora é 10GB]), e outros aspectos de desempenho estão ligados a isso também. Exploraremos isso em mais detalhes mais tarde no livro.

**Possui alta disponibilidade implícita** Se um host subjacente específico falhar, o Lambda iniciará automaticamente ambientes em um host diferente. Da mesma forma, se um data center/Zona de Disponibilidade (AZ) específico falhar, o Lambda iniciará automaticamente ambientes em uma AZ diferente na mesma região. Note que cabe a nós, como clientes da AWS, lidar com uma falha em toda a região.

**Por que Lambda?** Os benefícios básicos da nuvem, como descrevemos anteriormente, aplicam-se ao Lambda — muitas vezes é mais barato executar em comparação com outros tipos de plataforma de host; requer menos esforço e tempo para operar uma aplicação Lambda; e a flexibilidade de escalonamento do Lambda supera qualquer outra opção de computação dentro da AWS. <span style="background:#affad1">No entanto, o principal benefício da nossa perspectiva é a rapidez com que você pode construir aplicações com Lambda quando combinado com outros serviços AWS.</span> Frequentemente ouvimos falar de empresas construindo aplicações totalmente novas, implantadas em produção, em apenas um ou dois dias. Ser capaz de nos remover de tanto código relacionado à infraestrutura que costumamos escrever em aplicações regulares é um grande economizador de tempo.

- **A Mudança:** Na AWS, a ideia de "Lego" significa desmontar seu Monolito Spring. O agendamento sai do `@Scheduled` do Spring e vai para o **Amazon EventBridge Scheduler**. O cache sai da memória da JVM e vai para o **Amazon ElastiCache (Redis)**. O Spring passa a ser o orquestrador dos Legos da AWS (via SDK), e não o dono de toda a infraestrutura lógica.

**O JAR, o ZIP e a "Gordura" do Java:**
- O texto menciona upload de "ZIP ou JAR".
- **Insight Prático:** No mundo Java Serverless, o tamanho do artefato importa para o _Cold Start_. Um "Fat JAR" (Uber Jar) de 150MB com todas as dependências do Spring Boot demora para ser baixado e descompactado pelo Lambda.
- **Ação:** Use técnicas de **Layered JAR** do Spring Boot ou, melhor ainda, use **Docker (Container Images)** para o **Lambda**. O Docker permite **cacheamento** de camadas, tornando o deploy de atualizações muito mais rápido do que subir um ZIP gigante a cada mudança.

**Memória e CPU: O Acoplamento Crucial:**
- O texto diz: "especificamos quanta memória RAM... outros aspectos [CPU/Rede] estão ligados a isso".
- **O Erro Comum em Java:** Tentar economizar dinheiro configurando o Lambda com 128MB de RAM.
- **A Realidade:** Java precisa de CPU para inicializar a JVM e o Contexto do Spring. Com 128MB, a AWS te dá uma fração minúscula de vCPU. <span style="background:#b1ffff">Sua função vai demorar _muito_ mais para rodar e você vai pagar _mais_ caro por isso (porque paga por tempo).</span>
- **Regra de Ouro:** Para Spring Boot, comece testando com **1024MB ou 1512MB** (o ponto onde você ganha 1 vCPU completa). Frequentemente, mais memória = execução mais rápida = custo menor.

**O Limite de 15 Minutos e `@Transactional`:**
- **Insight:** Se você tem um processo longo (`@Transactional`) que estoura os 15 minutos, o Lambda morre abruptamente. Não há "graceful shutdown" garantido para rollback de banco de dados nesse cenário de timeout da plataforma.
- **Ação:** Se o processo Java demorar mais que alguns minutos, Lambda provavelmente é a ferramenta errada. Use **AWS Step Functions** para orquestrar transações longas ou divida o processamento em Lambdas menores.

**Concorrência por Instância (Single Event Processing):**
- O texto diz: "apenas um evento é processado por ambiente de cada vez".
- **Diferença do Spring MVC tradicional:** No Tomcat (EC2), uma JVM atende 200 threads simultâneas. No Lambda, uma JVM atende 1 requisição. <span style="background:#d3f8b6">Se chegarem 50 requisições simultâneas, a AWS sobe 50 JVMs (50 Cold Starts potenciais).</span>
- **Implicação:** Variáveis estáticas (`static`) não são compartilhadas entre usuários concorrentes (cada um está em sua JVM isolada), mas são compartilhadas entre requisições _sequenciais_ da mesma instância. Cuidado com vazamento de dados em variáveis estáticas (ThreadLocal, por exemplo).

**Limite de Memória (3GB vs 10GB):**

- O texto cita "máximo de 3GB".
- **Atual:** O Lambda suporta até **10GB de RAM** e **6 vCPUs**. Isso viabiliza rodar aplicações Spring Boot pesadas ou processamento de dados em Java que antes eram impossíveis.

**Suporte a Imagens de Container:**
- O texto foca apenas em ZIP/JAR.
- **Atual:** O suporte a **Container Images (OCI)** é fundamental hoje, permitindo usar o ecossistema Docker/Kubernetes no build e deployar no Lambda, facilitando a vida de quem já usa containers.

**SnapStart:**
- O texto não menciona (pois é novo), mas para Java, o **AWS Lambda SnapStart** é o "game changer". Ele tira uma "foto" da memória da JVM inicializada e restaura em milissegundos, eliminando quase todo o problema de _Cold Start_ do Spring Boot.


### Como é uma Aplicação Lambda?
Aplicações de servidor tradicionais de longa duração geralmente possuem pelo menos uma de duas formas de iniciar o trabalho para um estímulo específico: ou elas abrem um socket TCP/IP e aguardam por conexões de entrada, ou possuem um mecanismo de agendamento interno que faz com que elas consultem um recurso remoto para verificar se há novo trabalho. Como o Lambda é fundamentalmente uma plataforma orientada a eventos e como o Lambda impõe um limite de tempo (_timeout_), nenhum desses padrões é aplicável a uma aplicação Lambda. Então, como construímos uma aplicação Lambda?

O primeiro ponto a considerar é que, no nível mais baixo, as funções Lambda podem ser invocadas (chamadas) de uma destas duas maneiras:

- **Sincronamente** — chamada de _RequestResponse_ pela AWS. Neste cenário, um componente chamador (_upstream_) chama a função Lambda e aguarda qualquer resposta que a função gerar.
- **Assincronamente** — chamada de _Event_ pela AWS. Desta vez, a solicitação do chamador é respondida imediatamente pela plataforma Lambda, enquanto a função Lambda prossegue com o processamento da solicitação. Nenhuma resposta adicional é retornada ao chamador neste cenário.

Esses dois modelos de invocação possuem vários outros comportamentos, nos quais entraremos mais tarde, começando em “Tipos de Invocação”. Por enquanto, vamos ver como eles são usados em alguns exemplos de aplicações.

**Web API** 
Uma pergunta óbvia a se fazer é se o Lambda pode ser usado na implementação de uma API HTTP e, felizmente, a resposta é sim! Embora as funções Lambda não sejam servidores HTTP em si, podemos usar outro componente da AWS, o API Gateway, para fornecer o protocolo HTTP e a lógica de roteamento que tipicamente temos dentro de um serviço web.

!![image-202512213055146.png](/image-202512213055146.png)

O diagrama acima mostra uma API típica usada por uma _single-page application_ (SPA) ou por um aplicativo móvel. O cliente do usuário faz várias chamadas, via HTTP, para o backend para recuperar dados e/ou iniciar solicitações. No nosso caso, o componente que lida com os aspectos HTTP da solicitação é o Amazon API Gateway — ele é um servidor HTTP.

Configuramos o API Gateway com um mapeamento de solicitação para manipulador (por exemplo, se um cliente faz uma solicitação `GET /restaurants/123`, podemos configurar o API Gateway para chamar uma função Lambda chamada `RestaurantsFunction`, passando os detalhes da solicitação). O API Gateway invocará a função Lambda de forma síncrona e aguardará que a função avalie a solicitação e retorne uma resposta.

Como a instância da função Lambda não é em si uma API remotamente chamável, o API Gateway na verdade faz uma chamada para a plataforma Lambda, especificando a função Lambda a ser invocada, o tipo de invocação (_RequestResponse_) e os parâmetros da solicitação. A plataforma Lambda então instancia uma instância da `RestaurantsFunction` e a invoca com os parâmetros da solicitação.

A plataforma Lambda possui algumas limitações, como o tempo limite máximo que já mencionamos, mas fora isso, é praticamente um ambiente Linux padrão. Na `RestaurantsFunction`, podemos, por exemplo, fazer uma chamada a um banco de dados — o Amazon DynamoDB é um banco de dados popular para usar com Lambda, em parte devido às capacidades de escalabilidade semelhantes dos dois serviços.

Uma vez que a função tenha terminado seu trabalho, ela retorna uma resposta, já que foi chamada de forma síncrona. Essa resposta é passada pela plataforma Lambda de volta ao API Gateway, que transforma a resposta em uma mensagem de resposta HTTP, que por sua vez é passada de volta ao cliente.

Tipicamente, uma API web atenderá a múltiplos tipos de solicitações, mapeadas para diferentes caminhos e verbos HTTP (como GET, PUT, POST, etc.). Ao desenvolver uma API web baseada em Lambda, você geralmente implementará diferentes tipos de solicitações como funções Lambda diferentes, embora não seja forçado a usar tal design — você pode lidar com todas as solicitações como uma única função, se preferir, e alternar a lógica dentro da função com base no caminho e verbo da solicitação HTTP original.

**Processamento de Arquivos** Um caso de uso comum para o Lambda é o processamento de arquivos. Vamos imaginar um aplicativo móvel que pode fazer upload de fotos para um servidor remoto, que então queremos disponibilizar para outras partes da nossa suíte de produtos, mas em tamanhos de imagem diferentes.

O S3 é o _Simple Storage Service_ da Amazon — o mesmo que foi lançado em 2006. Aplicativos móveis podem fazer upload de arquivos para o S3 via API da AWS, de forma segura.

O S3 pode ser configurado para invocar a plataforma Lambda quando o arquivo é carregado, especificando a função a ser chamada e passando o caminho para o arquivo. Assim como no exemplo anterior, a plataforma Lambda instancia a função Lambda e a chama com os detalhes da solicitação passados desta vez pelo S3. A diferença agora, porém, é que esta é uma invocação assíncrona (o S3 especificou o tipo de invocação _Event_) — nenhum valor é retornado ao S3, nem o S3 espera por um valor de retorno.

Desta vez, nossa função Lambda existe apenas com o propósito de um efeito colateral — ela carrega o arquivo especificado pelo parâmetro da solicitação e cria novas versões redimensionadas do arquivo em um bucket S3 diferente. Com os efeitos colaterais completos, o trabalho da função Lambda está feito. Como ela criou arquivos em um bucket S3, podemos optar por adicionar um gatilho Lambda a esse bucket também, invocando outras funções Lambda que processam esses arquivos gerados, criando um pipeline de processamento.

**Outros exemplos de aplicações Lambda** Os dois exemplos anteriores mostram dois cenários, com duas fontes de eventos Lambda diferentes. Existem muitas outras fontes de eventos que nos permitem construir muitos outros tipos de aplicações. Apenas algumas delas são as seguintes:
- Podemos construir aplicações de processamento de mensagens, usando barramentos de mensagens como _Simple Notification Service_ (SNS), _Simple Queue Service_ (SQS), EventBridge ou Kinesis como fonte de eventos.
- Podemos construir aplicações de processamento de e-mail, usando o _Simple Email Service_ (SES) como fonte de eventos.
- Podemos construir aplicações de tarefas agendadas, semelhantes a programas cron, usando _CloudWatch Scheduled Events_ como gatilho.

Note que muitos desses serviços, além do Lambda, são serviços BaaS e, portanto, também _serverless_. Combinar FaaS e BaaS para produzir arquiteturas _serverless_ é uma técnica extraordinariamente poderosa devido às suas características semelhantes de escalabilidade, segurança e custo. De fato, são essas combinações de serviços que estão impulsionando a popularidade da computação _serverless_.

**"API Gateway é necessário para HTTP":**
- O texto sugere que para ter HTTP, você precisa do API Gateway.
- **Atualização:** Para casos de uso simples (microservices internos, webhooks), agora existe a **Lambda Function URL**. Ela fornece um endpoint HTTPS direto para a função, sem o custo e a complexidade de configuração do <span style="background:#affad1">API Gateway</span>. É mais barato e mais rápido de configurar.

## **AWS Lambda no Mundo Java**
O AWS Lambda suporta nativamente um grande número de linguagens. JavaScript e Python são linguagens muito populares "para começar" no Lambda (bem como para aplicações de produção significativas), em parte devido à sua natureza dinamicamente tipada e não compilada, permitindo ciclos de desenvolvimento muito rápidos.
Nós dois começamos, no entanto, usando Lambda com Java. O Java ocasionalmente tem uma má reputação no mundo Lambda — parte da qual é justa, e parte não. Se o que você precisa em uma função Lambda pode ser expresso em 10 linhas ou algo assim, normalmente é mais rápido montar algo em JavaScript ou Python. No entanto, para aplicações maiores, existem muitas razões excelentes para implementar funções Lambda em Java, algumas das quais são as seguintes:

- **Reaproveitamento de Skills:** Se você ou sua equipe estão mais familiarizados com Java do que com as outras linguagens suportadas pelo Lambda, então vocês terão a capacidade de reutilizar essas habilidades e bibliotecas em uma nova plataforma de runtime. O Java é tanto uma "linguagem de primeira classe" no ecossistema Lambda quanto JavaScript, Python, Go, etc. — o Lambda não está limitando você se você usar Java. Além disso, se você já tem muito código implementado em Java, portar parte disso para o Lambda pode ser uma vantagem significativa de _time-to-market_ (tempo de lançamento), em comparação com a reimplementação em uma linguagem diferente.
- **Performance em Alta Vazão:** Em sistemas de mensageria de alto rendimento (_throughput_), o benefício típico de desempenho de tempo de execução do Java sobre JavaScript ou Python pode ser significativo. Não apenas "mais rápido" é normalmente "melhor" em qualquer sistema, mas com o Lambda, "mais rápido" também pode resultar em benefícios de custo tangíveis devido ao modelo de preços do Lambda.

Para cargas de trabalho na JVM, o Lambda suporta nativamente, no momento desta escrita, os runtimes Java 8 e Java 11. A plataforma Lambda instanciará uma versão do _Java Runtime Environment_ (JRE) dentro de seu ambiente Linux e, em seguida, executará nosso código dentro dessa Java VM.

Nosso código, portanto, deve ser compatível com esse ambiente de execução, mas não estamos restritos apenas ao uso da linguagem Java. Scala, Clojure, Kotlin e mais, podem todos ser executados no Lambda.

A plataforma Lambda fornece algumas bibliotecas básicas com o runtime (por exemplo, um pequeno subconjunto da biblioteca AWS Java), mas quaisquer outras bibliotecas que seu código precise devem ser fornecidas com seu próprio código. Você aprenderá como fazer isso em "Build and Package".

Finalmente, embora o Java tenha o construto de programação de "Expressões Lambda", estas não têm relação com as funções AWS Lambda. Você é livre para usar expressões Lambda do Java dentro de sua função AWS Lambda se desejar (já que o AWS Lambda suporta Java 8 e posteriores) ou não.

Aqui está a munição técnica para defender o Java no Serverless e alinhar com o Spring moderno:

- **A "Má Reputação" vs. Realidade (Cold Start):**
    - O texto admite a má fama. Historicamente, o Java sofria muito com _Cold Starts_ (tempo para subir a JVM + Carregar Classes).
        
    - **Insight Spring Boot 3:** O Spring Boot 3 introduziu suporte nativo a **GraalVM Native Images**. Isso compila seu código Java em um executável binário nativo (AOT - Ahead of Time). O _Cold Start_ cai de segundos para milissegundos.
    - **Insight AWS SnapStart:** Se você não quiser usar GraalVM (que tem limitações com reflection), a AWS lançou o **Lambda SnapStart** para Java 11+. Ele inicializa sua função, tira um _snapshot_ da memória e, nas próximas execuções, restaura desse estado. É a "bala de prata" para Java no Lambda hoje.

**SDKs e Dependências (O "Dependency Hell"):**

- O texto avisa: _"quaisquer outras bibliotecas... devem ser fornecidas"_.
- **Boas Práticas:**
    - Não confie nas libs da AWS que já vêm no runtime (elas ficam desatualizadas).
    - Use o **Spring Cloud Function** para empacotar apenas o necessário.
    - Utilize o plugin **Maven Shade** ou o **Spring Boot Thin Layout** para evitar criar JARs gigantescos desnecessariamente, o que aumenta o tempo de download do código pela AWS.


### O que está desatualizado
O texto final do capítulo entrega sua idade em alguns pontos cruciais para quem estuda hoje:

1. **Versões do Java (8 e 11):**
    - **Atualização:** O Java 8 no AWS Lambda está obsoleto/depreciado em muitas regiões ou em modo de suporte estendido. O padrão atual para novos projetos deve ser **Java 17** ou **Java 21**. O Java 21 (LTS) traz melhorias massivas de Garbage Collection (ZGC/Generational ZGC) e Threads Virtuais (Project Loom) que são fantásticas para I/O no Lambda.
2. **Atualização:** Hoje, grandes empresas preferem empacotar a função Lambda como uma **Imagem Docker (OCI)**. Isso facilita o pipeline de CI/CD, permitindo rodar a imagem localmente para testes mais fiéis e contornar o limite de tamanho de 250MB do ZIP (imagens podem ter até 10GB).

