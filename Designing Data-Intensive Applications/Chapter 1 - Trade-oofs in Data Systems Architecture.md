## Preface
Existem centenas de bancos de dados para escolher. Qual devemos usar em nossa aplicação? A resposta curta é: "Depende". A resposta longa é... este livro.

Diferentes tecnologias para armazenar e processar dados fazem diferentes *trade-offs*, e nenhuma abordagem é a melhor para todas as situações. O sistema que é perfeito para uma aplicação pode ser totalmente inadequado para outra. Este livro é um guia por todo o panorama dos **data systems**, não apenas analisando um produto, mas comparando os pontos fortes e fracos de muitos sistemas.

Embora o cenário de tecnologias para processar e armazenar dados seja diverso e mude rapidamente, os princípios subjacentes permanecem. Se entendermos estes princípios, estaremos em posição de enxergar onde cada ferramenta se encaixa, como usá-la bem e como evitar suas armadilhas. Este livro foca nesses princípios.

Veremos neste livro, muitos exemplos de **data systems** bem-sucedidos: tecnologias que formam a base de inúmeras aplicações populares e que precisam atender a requisitos de escalabilidade, desempenho e confiabilidade em produção todos os dias. Vamos mergulhar no funcionamento interno desses sistemas, separar seus principais algoritmos e discutir os **trade-offs** que eles fizeram. Nesse jornada, tentaremos encontrar maneiras úteis de pensar sobre **data systems**, não apenas como eles funcionam, mas também por que funcionam dessa forma.

Depois de ler este livro, você estará em ótima posição para determinar quais tipos de tecnologias são apropriados para quais propósitos e para entender como ferramentas podem ser combinadas para formar a base de uma arquitetura de aplicação sólida. Você desenvolverá uma forte intuição sobre o que seus sistemas estão fazendo nos bastidores, para que possa raciocinar sobre seu comportamento, tomar boas decisões de design e rastrear quaisquer problemas que possam surgir.

## Trade-offs in Data Systems Architecture
*"Não existem soluções; existem apenas **trade-offs. [...]** Mas tentamos conseguir o melhor **trade-off** que pudermos, e é tudo o que podemos esperar.* - Thomas Sowell, entrevista com Fred Barnes (2005).

Os dados são centrais para grande parte do desenvolvimento de aplicações hoje em dia. Com aplicações web e mobile, **software as as service (SaaS)** e serviços em nuvem, tornou-se normal armazenar dados de muitos usuários diferentes em uma infraestrutura de dados compartilhada baseada em servidor. Dados provenientes de atividade de usuários, transações comerciais, dispositivos e sensores precisam ser armazenados e disponibilizados para análise. Conforme os usuários interagem com uma aplicação, eles tanto leem os dados que estão armazenados quanto geram mais dados.

Pequenas quantidades de dados, que podem ser armazenadas e processadas em uma única máquina, costuma ser relativamente fáceis de gerenciar. No entanto, à medida que o volume de dados ou a taxa de consultas cresce, eles precisam ser distribuídos por múltiplas máquinas, o que introduz muitos desafios. Conforme as necessidades da aplicação se tornam mais complexas, não é mais suficiente armazenar tudo em um único sistema podendo ser necessário combinar múltiplos sistemas de armazenamento ou processamento que ofereçam diferentes capacidades.

Chamamos uma aplicação de **data-intensive** se o gerenciamento de dados for um dos principais desafios no desenvolvimento da aplicação. Enquanto em sistemas **compute-intensive** o desafio é paralelizar uma computação muito grande, em aplicações **data-intensive** geralmente <span style="background:#fff88f">nos preocupamos</span> mais com coisas como <span style="background:#d3f8b6">armazenar</span> e <span style="background:#d3f8b6">processar grandes volumes de dados</span>, gerenciar mudanças nos dados, <span style="background:#d3f8b6">garantir consistência</span> diante de falhas e concorrência, e assegurar que os serviços <span style="background:#d3f8b6">estejam altamente disponíveis</span>.

Essas aplicações são tipicamente construídas a partir de blocos de construção padrão que fornecem funcionalidades comumente necessárias. Por exemplo, muitas aplicações precisam fazer o seguinte:
- Armazenar dados para que eles, ou outra aplicação, possam encontrá-los novamente mais tarde (**database**);
- Lembrar o resultado de uma operação cara, para acelerar leituras ( #caches);
- Permitir que usuários busquem dados por palavra-chave ou os filtrem de várias maneiras ( #search-indexes);
- Lidar com eventos e mudanças nos dados assim que eles ocorrem ( #stream-processing);
- Processar periodicamente um grande volume de dados acumulados ( #batch-processing)

Ao construir uma aplicação, normalmente pegamos vários sistemas ou serviços de software, como #databases ou #APIs, e os integramos com código de aplicação. Se estivermos realizando exatamente aquilo para o qual os #data-systems foram projetados, esse processo pode ser bastante fácil.

No entanto, à medida que a nossa aplicação se torna mais ambiciosa, surgem desafios. Existem muitos sistemas de banco de dados com características diferentes, adequados para diferentes propósitos, como escolher qual usar? Existem várias abordagens para cache, diversas maneiras de construir índices de pesquisa e assim por diante — como você raciocina sobre os prós e contras de cada um? Você precisa descobrir quais ferramentas e quais abordagens são as mais apropriadas para a tarefa em questão, e pode ser difícil combinar ferramentas quando você precisa fazer algo que uma única ferramenta não consegue fazer sozinha.

Nenhuma abordagem é fundamentalmente melhor que as outras; tudo tem prós e contras. Com este livro, aprenderemos a fazer perguntas certas para avaliar e comparar sistemas de dados, para que possamos descobrir qual a abordagem atenderá melhor às necessidades da nossa aplicação específica.

Começaremos a nossa jornada analisando algumas das maneiras como os dados são tipicamente usados nas organizações hoje. Muitas das ideias aqui têm origem em software corporativo (ou seja, as necessidades de software e práticas de engenharia de grandes organizações, como grandes corporações e governos), já que historicamente apenas as grandes organizações tinham os grandes volumes de dados que exigiam soluções técnicas sofisticadas. Se o seu volume de dados for pequeno o suficiente, você pode simplesmente mantê-lo em uma planilha! No entanto, mais recentemente também se tornou comum que empresas menores e startups gerenciem grandes volumes de dados e construam sistemas com uso intensivo de dados.

Um dos principais desafios com sistemas de dados é que pessoas diferentes precisam fazer coisas muito diferentes com os dados. Se trabalhamos em uma empresa, eu e a minha equipe teremos um conjunto de prioridades, enquanto outra equipe pode ter objetivos totalmente diferentes, mesmo que estejamos trabalhando com o mesmo conjuntos de dados! Além disso, esses objetivos podem não ser articulados explicitamente, o que pode levar a mal-entendidos e discordâncias sobre a abordagem correta. 

---
 2. Insights Valiosos
- **Ecossistema Spring e a Facilidade de Integração:** O Spring Boot abstrai grande parte da complexidade de conectar diferentes fontes de dados. É muito simples adicionar o `spring-boot-starter-data-jpa` para um PostgreSQL e o `spring-boot-starter-data-redis` para cache no mesmo projeto. No entanto, essa facilidade técnica pode mascarar o custo arquitetural. O erro comum é introduzir tecnologias apenas porque o *framework* facilita, sem avaliar se o _trade-off_ operacional (manutenção, custo) se justifica.

Não existe bala de prata. Tudo tem prós e contras. O nosso trabalho como engenheiros não é buscar a tecnologia perfeita, mas sim fazer as perguntas certas para combinar as ferramentas que resolvem o problema atual do negócio. 

---
Para ajudá-lo a entender suas escolhas, este capítulo compara vários conceitos contrastantes e explora seus prós e contras (_trade-offs_). Consideraremos os seguintes tópicos:
- A diferença entre sistemas operacionais e analísticos ((“Sistemas Operacionais Versus Analíticos” na página 3));
- Os prós e contras de serviços em nuvem e sistemas auto-hospedados (“Nuvem Versus Auto-hospedagem” na página 12)
- Quando migrar de sistemas de nó único para sistemas distribuídos (“Sistemas Distribuídos Versus Sistemas de Nó Único” na página 19)
- Equilibrando as necessidades do negócio e os direitos do usuário (“Sistemas de Dados, Lei e Sociedade” na página 24)
Este capítulo também definirá as terminologias que iremos precisar para o restante do livro.

**Terminologia: Frontends e Backends**
Muito do que discutiremos neste livro se relaciona ao desenvolvimento backend. Para explicar esse termo: em aplicações web, o código do lado do cliente (que roda em um navegador web) é chamado de frontend, e o código do lado do servidor que lida com as requisições do usuário é conhecido como backend. Aplicativos móveis são semelhantes aos frontends, pois fornecem interfaces de usuário que frequentemente se comunicam pela internet com um backend no servidor. Às vezes, os frontends gerenciam dados localmente no dispositivo do usuário [2], mas os maiores desafios da infraestrutura de dados geralmente residem no backend: um frontend precisa lidar apenas com os dados de um usuário, enquanto o backend gerencia dados em nome de todos os usuários. 

Um serviço backend geralmente é acessível via #HTTP (ou às vezes #WebSocket); ele costuma consistir em código de aplicação que lê e grava dados  em um ou mais bancos de dados e, por vezes, faz interface com sistemas de dados adicionais, como caches ou filas de mensagens (que podemos chamar coletivamente de infraestrutura de dados). O código da aplicação costuam ser sem estado (*stateless*, ou seja, quando termina de lidar com uma requisição HTTP, ele esquece tudo sobre aquela requisição), e qualquer informação que precise persistir de uma requisição para outra deve ser armazenada ou na infraestrutura de dados do lado do servidor.

**Insights Valiosos**
- **Arquitetura Stateless e Spring Security**: o texto reforça que o backend deve ser inerentemente *stateless*. Na prática com Java e Sprint Boot, isso exige o abandono da autenticação baseada em sessão em memória ( #HttpSession) no Spring Security. O padrão passa a ser o uso de JWT (JSON Web Tokens). O estado da autenticação reside no cliente (frontend), e o backend atua apenas validando a criptografia do token a cada requisição. Isso previne dores de cabeça severas em ambientes distribuídos, eliminando a necessidade de replicação de sessões entre diferentes nós do servidor.
- **A Jornada para Sistemas Distribuídos e Contêineres:** Migrar de um "nó único" para um "sistema distribuído" é onde a nuvem brilha. Uma aplicação Spring Boot _stateless_ é a candidata ideal para conteinerização com Docker. Uma vez em um contêiner, ferramentas de orquestração como Kubernetes (EKS na AWS) ou Amazon ECS podem escalar o serviço horizontalmente sem atrito. O backend esquece a requisição anterior, então não importa se a requisição "A" caiu no Pod 1 e a requisição "B" no Pod 2.
- **Sistemas Operacionais vs. Analíticos com Spring Data:** Um erro arquitetural clássico em aplicações Java é tentar executar relatórios complexos no mesmo banco de dados relacional que atende as transações dos usuários (OLTP via `Spring Data JPA` conectado ao Amazon RDS). À medida que a escala aumenta, é mandatório separar essas cargas, movendo os dados analíticos para data lakes ou <i>data warehouses</i> (como Amazon Redshift ou Athena) via rotinas de ingestão, para não comprometer a performance da aplicação em tempo real.
- **Integração com Infraestrutura de Dados AWS:** O texto cita a interface do backend com caches e filas de mensagens. No ecossistema Spring, essa integração é feita adotando o `Spring Data Redis` para acionar o Amazon ElastiCache (absorvendo picos de leitura e poupando o RDS) e o `Spring Cloud AWS` para enviar eventos ao Amazon SQS (desacoplando processos lentos e assíncronos da thread HTTP principal).
- **Boas Práticas de Documentação e Contratos API:** Como o backend gerencia dados "em nome de todos os usuários", a comunicação com o frontend deve ser perfeitamente orquestrada. A falta de estado significa que o payload HTTP deve conter todo o contexto necessário. Usar bibliotecas como `springdoc-openapi` para gerar documentação Swagger automaticamente garante que os desenvolvedores do frontend saibam exatamente qual o contrato de dados necessário, reduzindo falhas de integração e gargalos no CI/CD.

## Operational Versus Analytical Systems
If we are working on data systems in an enterprise, we are likely to encounter several different types of people who work with data. The first type are *backend engineers* who build services that handle requests for reading and updating data; this services often (frequentemente) serve external users, either directly or indirectly via other services (see "Microservices and Serverless" on page 21). Sometimes services are for internal use by other parts of the organization.

In addition to the teams managing backend services, two other groups of people typically require access to an organization's data: *business analysts*, who generate reports about the activities of the organization to help management make better decisions (*business intelligence, or BI*), and data *scientists* who look for novel insights in data or who create user-facing product features that are enabled by data analysis and machine learning (ML)/AI (e.g., "people who bought X also bought Y" recomendations on an ecommerce website, predictive analytics such as risk scoring or spam filtering, and ranking of search results).

Although business analysts and data scientists tend to use different tools and operate in different ways, <span style="background:#fff88f">they have some practices in common</span>. 
- First, both perform *analytics,* which means <span style="background:#fff88f">the look at the data that</span> the users and backend services have generated. 
- Second, they generally do not modify this data (except perhaps for fixing mistakes), although they might create derived datasets in which the original data has been processed in some way. 

This had led to a split between two types of systems, a distinction that we will use throughout this book:
- *Operational systems*: consist of the backend services and data infrastructure where the data is created, for example, by serving external users. Here, the application code both reads and modifies the data in its databases, based on the actions performed by the users.
- *Analytical systems:* serve the needs of business analysts and data scientists. The contain a read-only copy of the data from the operational systems, and they are optimized for the types of data processing that are needed for analytics. 

As we **shall** (**devemos**) see in the next section, #operational and #analytical systems are often kept separate, for good reasons (por bons motivos).  As these system have matured, two new specialized roles have emerged: *data engineers* and *analytics engineers*. *
- **Data Engineers** are the people who know how to integrate the operational and analytical systems and who take responsibility  for the organization's data infrastructure more widely (amplamente).  
- **Analytics engineers** model and transform data to make it more useful for the business analysts and data scientists in a organization.

Many engineers specialize in either the operational or the analytical side. However, this book covers both operational and analytical data systems, since both play an important role in the lifecycle of data within an organization. We will explore in depth the data infrastructure that is used to deliver services to both internal and external users so that we can work  better with our colleagues on the other side of this divide.

## Characterizing Transaction Processing and Analytics
In the early days of business data processing, a write to the database typically corresponded to a commercial transaction taking place: making a sale, placing an order with a supplier, paying an employee's salary, etc. As databases expanded into areas that didn't involve money changing hands, the term *transaction* nevertheless stuck, referring to a group of read and writes that form a logical unit. 

> Chapter 8 explores in detail what we mean by a transaction. This chapter uses the term loosely to refer to low-latency reads and writes.

Embora os bancos de dados tenham começado a ser usados para muitos tipos de dados, postagens de mídias sociais, jogadas em um jogo, contatos em um catálogo de endereços e muito, muito mais, o padrão básico de acesso permaneceu semelhante ao processamento de transações comerciais. Normalmente, um sistema operacional procura um pequeno número de registros por uma chave (isso é chamado de consulta pontual). Os registros são inseridos, atualizados ou excluídos com base na entrada do usuário. Como esses aplicativos são interativos, esse padrão de acesso ficou conhecido como <span style="background:#fff88f">processamento de transações on-line</span> ( #OLTP).

No entanto, os bancos de dados também começaram a ser cada vez mais usados para análise, que tem padrões de acesso muito diferentes em comparação com o OLTP. 

Normalmente, uma consulta analítica faz a varredura de um grande número de registros e calcula estatísticas agregadas (como contagem, soma ou média) em vez de retornar os registros individuais ao usuário. Por exemplo, um analista de negócios de uma rede de supermercados pode querer responder a consultas analíticas como estas:
- Qual foi a receita total de cada uma de nossas lojas em janeiro?
- Quantas bananas a mais do que o normal vendemos durante nossa última promoção?
- Qual marca de comida para bebês é mais frequentemente comprada junto com fraldas da marca X?

Os relatórios resultantes desses tipos de consultas são importantes para o BI, ajudando a gerência a decidir o que fazer em seguida. Para diferenciar esse padrão de uso de banco de dados do processamento de transações, ele foi chamado de processamento analítico on-line ( #OLAP). A diferença entre OLTP e analítica nem sempre é clara, mas algumas características típicas estão listadas na Tabela 1-1.
!![image-2026416421318.png](/image-2026416421318.png)

O significado de on-line em OLAP não é claro; provavelmente indica que as consultas não são apenas para relatórios predefinidos, mas que os analistas usam o sistema OLAP interativamente para consultar exploratórias.

Nos sistemas operacionais, os usuários geralmente não têm permissão para criar consultas SQL personalizadas e executá-las no banco de dados, pois isso poderia permitir que eles lessem ou modificassem dados que não têm permissão para acessar. Eles também podem escrever consultas cuja execução é cara e, portanto, afetar o desempenho do banco de dados para outros usuários. Por esses motivos, os sistemas OLTP executam, em sua maioria, conjuntos fixos de consultas incorporadas ao código do aplicativo, com consultas personalizadas únicas usadas apenas ocasionalmente para manutenção ou solução de problemas. Por outro lado, os bancos de dados analíticos geralmente dão aos seus usuários a liberdade de escrever consultas SQL arbitrárias manualmente ou de gerar consultas automaticamente usando uma ferramenta de visualização de dados ou de painel, como Tableau, Looker ou Microsoft Power BI.

Outro tipo de sistema é projetado para cargas de trabalho analíticas (consultas que agregam muito registros), mas incorporado a produtos voltados para o usuário. Os sistemas projetados para esse tipo de uso, conhecidos como análise de produtos ou análise em tempo real, incluem #Pinot, #Druid e #CLickHouse. Esses sistemas integerem dados em tempo real e são otimizados para responstas de consultas de baixa latência. Por outro lado, os sistemas OLAP tradicionais normalmente ingerem dados em lotes e são otimizados para o processamento de consultas de alto rendimento.

OLTP e OLAP não são tecnologias, são **padrões de acesso a dados.** A arquitetura que irá decidir separá-los, como separar e como sincronizar. Um único sistema não consegue ser ótimo para tudo, então nós otimizamos para escrita rápida OLTP ou para leitura analítica (OLAP), raramente os dois ao mesmo tempo. Portanto, OLTP e OLAP, são formas de uso dos dados. Não são bancos específicos, mas na prática, viram bancos diferentes. Separação evita gargalo e melhora escalabilidade.

## Data Warehousing
No início, os mesmos bancos de dados eram usados tanto para o processamento de transações quanto para consultas analíticas. O SQL se mostrou bastante flexível nesse aspecto; ele funciona bem para os dois tipos de consultas. No final da década de 1980 e início da década de 1990, no entanto, surgiu uma tendência de as empresas pararem de usar seus sistemas OLTP para fins de análise e, em vez disso, executarem a análise em um sistema de banco de dados separado. Esse banco de dados separado era chamado de *data warehouse*.

Uma grande empresa pode ter dezenas, até centenas, de sistemas OLTP: sistemas que alimentam o site voltado para o cliente, controlam sistemas de ponto de venda (checkout) em lojas físicas, rastreiam o estoque em armazéns, <span style="background:#fff88f">planejam rotas para veículos</span>, gerenciam fornecedores, administram funcionários e executam muitas outras tarefas. Cada um desses sistemas é complexo e precisa de uma equipe de pessoas para mantê-los, de modo que eles acabam operando de forma independente uns dos outros.

Geralmente, <span style="background:#fff88f">é indesejável que os analistas de negócios e cientistas de dados consultem diretamente esses sistemas OLTP</span>, por vários motivos:
- Os dados de interesse podem estar espalhados por vários sistemas operacionais, o que dificulta a combinação desses conjuntos de dados em uma única consulta (um problema conhecido como silos de dados) *data silos*.
- Os tipos de esquemas e layouts de dados que são bons para OLTP são menos adequados para análise (consulte Start and Snowflakes, esquemas para análise).
- As consultas analíticas podem ser bastante caras e executá-las em um banco de dados OLTP afetaria o desempenho de outros usuários;
- Os sistemas OLTP podem residir em uma rede separada à qual os usuários não tem permissão para acessar diretamente, por motivos de segurança ou conformidade.

Um *data warehouse*, por outro lado, é um banco de dados separados que os analistas podem consultar à vontade  , sem afetar as operações OLTP. Como veremos no capítulo 4, os data warehouse geralmente <span style="background:#fff88f">armazenam dados</span> de forma muito <span style="background:#d3f8b6">diferente dos bancos de dados OLTP,</span> para otimizar os tipos de consultas que são comuns na análise. 

O *data warehouse* contém uma cópia somente de leitura dos dados de todos os sistemas OLTP da empresa. Os <span style="background:#fff88f">dados são extraídos dos bancos de dados OLTP</span> (por meio de um despejo periódico de dados ou de um fluxo contínuo de atualizações), transformados em um esquema de fácil análise, limpos e, em seguida, carregados no data warehouse. Esse processo de obtenção de dados para o data warehouse é conhecido como <span style="background:#fff88f">extração-transformação-carregamento</span> (ETL) e está ilustrado na Figura 1.1. Às vezes, a ordem das etapas de transformação e carregamento é trocada (ou seja, a transformação é feita no data warehouse, depois do carregamento), resultando em ELT.

!![image-2026416223702.png](/image-2026416223702.png)

Em alguns casos, as <span style="background:#fff88f">fontes de dados dos processos de ETL</span> são produtos SaaS externos, como gerenciamento de relacionamento com o cliente (CRM), marketing por e-mail ou sistemas de processamento de cartão de crédito. Nesses casos, não temos acesso direto ao banco de dados original, pois ele é acessível somente por meio da API do fornecedor do software. Trazer os dados desses sistemas externos para o seu próprio data warehouse pode permitir análises que não são possíveis por meio da API de SaaS. A ETL para APIs de SaaS geralmente é implementada por serviços especializados de conector de dados, como Fivetran, Singer ou Airbyte.

Alguns sistemas de banco de dados oferecem processamento transacional/analítico híbrido (HTAP), que visa permitir OLTP e análise em um único sistema sem exigir ETL de um sistema para outro. No entanto, muitos sistemas HTAP consistem internamente em um sistema OLTP acoplado a um sistema analítico separado, oculto por trás de uma interface comum, portanto, a distinção entre os dois continua sendo importante para entender como esses sistemas funcionam.

Além disso, embora existe o HTAP, é comum haver uma separação entre os sistemas transacionais e analíticos devido a seus <span style="background:#fff88f">diferentes objetivos e requisitos</span>. Em particular, é considerada uma boa prática que cada sistema operacional tenha seu próprio banco de dados (consulte "Microsserviços e sem servidor"), o que pode resultar em centenas de banco de dados operacionais separados; por outro lado o HTAP, portanto, não substituiu os data warehouse. Em vez disso, ele é útil quando o mesmo aplicativo precisa realizar consultas analíticas que examinam um grande número de linhas e ler e atualizar registros individuais com baixa latência. A detecção de fraudes pode envolver essas cargas de trabalho, por exemplo.  

<span style="background:#fff88f">A separação entre sistemas operacionais e analíticos faz parte de uma tendência mais ampla.</span> À medida que as cargas de trabalho se tornaram mais exigentes, os sistemas se tornaram mais especializados e otimizados para determinadas cargas de trabalho. Os sistemas de uso geral podem lidar confortavelmente com pequenos volumes de dados, mas quanto maior a escala, mais especializados os sistemas tendem a se tornar.

### From data warehouse to data lake
Um *Data Warehouse* frequentemente utiliza um modelo de dados relacional que é consultado por meio de SQL, possivelmente utilizando software especializado de BI. Este modelo funciona bem para os tipos de consultas que os analistas de negócios *business analysts* precisam realizar, mas é menos adequado às necessidades dos *data scientists* ao realizarem tarefas como estas:
- **Transformar os dados:** em um formato adequado para treinar um modelo ML. Isso frequentemente exige converter as linhas e colunas de uma tabela de banco de dados em um vetor ou matriz de valores numéricos denominados *features*. O processo de realizar essa transformação visando maximizar o desempenho do modelo treinado é chamado *feature engineering*, e frequentemente requer código personalizado, que pode ser difícil de expressar utilizando apenas SQL.
- **Utilizar técnicas de Natural Language Processing (NLP):** em dados textuais (por exemplo, avaliações de um produto) para tentar extrair informações estruturadas delas (como o sentimento do autor ou os tópicos mencionados). Da mesma forma, os *data scientists* podem precisar extrair informações estruturadas de fotografias, utilizando técnicas de #Computer-Vision.

Embora tenha havido esforços para adicionar operadores de ML a um modelo de dados SQL e para construir sistemas de ML eficientes sobre uma base relacional, muitos *data scientists* preferem não trabalhar dentro de um banco de dados relacional, como uma *data warehouse*. Em vez disso, muitos optam por usar bibliotecas de análise de dados em Python, como Pandas e scikit-learn, linguagens de análise estatística como R e *frameworks* de análise distribuída como o Spark [14]. Discutiremos esses tópicos com mais detalhes em "DataFrames, Matrices, and Arrays¨ na página 105.

Consequentemente, as organizações precisam disponibilizar os dados em uma forma que seja adequada para o uso por *data scientists*. A solução é um *data laker*: um repositório centralizado de dados que armazena uma cópia de qualquer informação que possa ser útil para análise, obtida de sistemas operacionais por meio de processos ETL.

A diferença para uma *data warehouse* é que uma *data lake* simplesmente contém arquivos, sem impor nenhum formato de arquivo, modelo de dados ou esquema específico. Os arquivos em um *data lake* podem ser coleções de registro de banco de dados, codificados utilizando um formato de arquivo como Arvro ou Parquet, mas uma *data lake* pode igualmente conter texto, imagens, vídeos, leituras de sensores, *matrizes esparsas*, *features vectors*, sequências genômicas ou qualquer outro tipo de dados. Além de ser mais flexível, um *data lake* também costuma ser mais econômica do que o armazenamento de dados relacionais, já que pode utilizar armazenamento de arquivos *commoditized* (de padrão de mercado/econômico), como *object stores*.

Os processos ETL foram generalizados como *data pipelines* (ou dutos de dados) e, em alguns casos, a *data lake* tornou-se uma parada intermediária no caminho entre os sistemas operacionais e a *data warehouse*.  A *data lake* contém os dados na forma "raw" (bruta/crua) produzida pelos sistemas operacionais, sem sofrer a transformação para um esquema de *data warehouse*m relacional. Essa abordagem tem a vantagem de que cada consumidor dos dados pode transformar os dados brutos na forma que melhor atender às suas necessidades. Frequentemente, isso é chamado de princípio do sushi: "dados crus são melhores".

## Além da *data lake*
À medida que as práticas de *analytics* amadureceram, as organizações vêm prestando cada vez mais atenção à gestão e operação de sistemas analísticos e *data pipelines*, algo expresso, por exemplo, no *DataOps Manifesto*. Isso tem sido impulsionado parcialmente por questões de governança, privacidade e *compliance* com regulamentações como o *Gengeral Data Protection Regulation *(GDPR)* e a *California Consumer Privacy Act (CCPA).*

Os dados utilizados em análises estão sendo disponibilizados não apenas como arquivos e tabelas relacionais, mas também como * #streams* de eventos. Como a análise de dados baseada em arquivos (*file-based*), é possível reexecutar a análise periodicamente (por exemplo, diariamente) para acompanhar alterações nos dados; já o *stream processing* permitem que os sistemas analíticos respondam aos eventos muito mais rapidamente, na ordem de segundos. Dependendo da aplicação e da sua sensibilidade temporal, uma abordagem baseada em *stream processing* pode ser extremamente valiosa, por exemplo, para identificar e bloquear atividades potencialmente fraudulentas ou abusivas.

Em alguns casos, as saídas de sistemas analíticos são disponibilizadas para sistemas operacionais (um processo muitas vezes denominado *reverse ETL*). Por exemplo, um modelo ML, treinado com dados de um sistema analítico, pode ser implantado em *production* para gerar recomendações para usuários finais, como "pessoas" que compraram X também compraram Y". Modelos de aprendizado de máquina (*machine learning*) podem ser implantados em sistemas operacionais utilizando ferramentas especializadas como TFX, Kuberflow ou MLflow.

---
#stream-processing 
O stream processing transforma a maneira como sistemas consomem e entendem dados ao tratar fluxos contínuos como entidades processáveis. Sua relevância se sustenta em cinco pilares:
1.  **Baixa latência e decisões em tempo real**: ao contrário do batch processing (que opera em janelas fixas), o stream processa dados conforme chegam, permitindo respostas na ordem de milissegundos a segundos. Críticos para deteção de fraude, monitoramento industrial, recomendações dinâmicas e resposta a incidentes.
2. **Processamento stateful e contextual**: permite manter estado entre eventos ao longo do tempo, janelas temporais windowing, agregações contínuas, correlações e enriquecimento com referências externas, sem precisar reprocessar históricos completos. 
3. **Escalabilidade horizontal e resiliência nativas**: frameworks modernos dividem stream em partições, permitem reequilíbrio automático rebalacing e oferecem garantias de entrega (at-least-once, exactly-once), com checkpointing e recovery automático sem perda de dados.
4. **Arquitetura event-driven e cloud-native** alinha-se naturalmente a padrões modernos: microsserviços reativos, CDC (Change Data Capture), IoT, e ecossistemas que substituem filas tradicionais por brokers duráveis de eventos.
5. **Complementaridade com batch (Lambda / Kappa)**  
    O stream cuida da frescura operacional e alertas imediatos; o batch garante consistência histórica e modelos treinados offline. Muitas organizações hoje migram para arquiteturas Kappa, onde um único pipeline serve ambas as necessidades.


Antes de implementarmos Java/Stream, faremos 3 perguntas:
1. ¨Se eu atrasar a resposta em 10 minutos (ou 1 dia), algo importante acontece?"
	- Sim (perda financeira, perigo humano) -> use Stream.
	- Não (relatórios, backups, histórico) -> não utilizar Stream.
2. **"Existe uma sequência de ações dependendo de outras?**"
	1. Exemplo: receber evento A, depois B, e depois C..." -> Stream é bom.
	2. Exemplo: "Guardar esse arquivo e esquecer."-> banco relacional serve melhor.
3. **Tenho infraestrutura e equipe para isso?**
	1. Manter um pipeline de Stream exige monitoramento constante. Se não tiver gente especializada, o sistema quebra e ninguém sabe o motivo.


