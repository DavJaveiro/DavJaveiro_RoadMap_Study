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


