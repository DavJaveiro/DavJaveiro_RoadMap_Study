#flashcards/AWS/cloudpractioner/chaper3

## O AWS Well-Architected Framework
Os objetivos do Well-Architected Framework são elevados. Eles incluem projetar para segurança, performance, resiliência, eficiência e mais. O framework também fornece oportunidades valiosas para avaliar um design proposto em relação aos princípios testados e comprovados contidos no documento. 

A AWS tinha objetivos quando criou esse framework. Estes são os mais importantes deles:
- Construir e implantar soluções mais rápido do que unca
- Reduzir e mitigar os riscos associados a uma mudança para a nuvem
- Tomar decisões informadas sobre como implementar soluções na nuvem
- Aprender as abordagens de melhores práticas mais poderosas para user serviços e ferramentas da AWS.

Para ajudar a organizar o framework e torná-lo mais valioso, a AWS focou o framework em torno de seis pilares:
- Excelência Operacional (Operation Excellence)
- Segurança (Security)
- Confiabilidade (Reliability)
- Eficiência de Performance (Performance Efficiency)
- Otimização de Custos (Cost Optimization)
- Sustainability

Vamos examinar as recomendações gerais de design contidas no framework:
- **Pare de adivinhar suas necessidades de capacidade:** graças à nuvem AWS, podemos aproveitar as capacidades de *autoscaling* de forma rápida. Embora possamos estar "pré-treinado" para adivinhar um grande número de capacidade para nossa solução devido ao desenvolvimento de TI tradicional, devemos lembrar que não é mais necessário fazer isso na nuvem. Podemos economizar dinheiro usando apenas os recursos que precisa com base na demanda real.
- **Teste sistemas em escala de produção:** com os recursos praticamente ilimitados da AWS ao nosso alcance, temos mais facilidade em realizar testes de estresse em nossas soluções empregando grandes quantidades de recursos AWS por um curto período de teste. Isso é frequentemente complicado, se não impossível, em ambientes tradicionais.
- **Automatize com a experimentação arquitetural em mente:** a AWS adota a automação em cada etapa dos nossos serviços e recursos. Como resultado, podemos facilmente testar mudanças em nossas soluções e reverter (roll back) rapidamente se houver problemas. 
- **Considere arquiteturas evolutivas:** a AWS enfatiza fazer mudanças consistentes nas arquiteturas para acompanhar as condições em mudança e até novas tecnologias. 
- **Oriente arquiteturas usando dados:** a AWS facilita o monitoramento de nossas soluções com grande detalhe. Com base em nossos dados de monitoramento, podemos fazer melhorias significativas e eficientes em nosso design ao longo do tempo.
- **Melhore através de "Game days":** nos perguntamos se a nossa solução AWS pode suportar uma falha grave ou uma carga de trabalho massivamente aumentada? Esses tipos de eventos podem facilmente ser simulados na nuvem. Tais simulações de "game-day" são frequentemente difíceis em ambientes de TI tradicionais. 

**NOTA:** Não confunda o **AWS Well-Architected Framework** com a **AWS Well-Architected Tool**.
A AWS Well-Architected Tool é um serviço fornecido pela AWS que ajuda clientes a avaliar suas cargas de trabalho e aplicações em relação às melhores práticas de arquitetura. Ela permite que usuários realizem autoavaliações ou trabalhem com arquitetos de soluções da AWS para revisar suas cargas de trabalho em relação aos seis pilares do Well-Architected Framework. Portanto, enquanto o framework é a documentação crítica que você deve conhecer, a ferramenta ajuda você a alcançar essas melhores práticas documentadas.

Well-Architecd Framewrok na Prova: o exame adota perguntas conceituais sobre os **6 pilares** e os **princípios Gerais de Design**.
- **Pare de adivinhar capacidade (Stop Guessing Capacity):** Este é o insight mais cobrado. A prova vai apresentar um cenário onde um usuário comprou servidores demais e ficou com capacidade ociosa, ou comprou de menos e o site caiu. A resposta correta envolverá _Elasticidade_, _Autoscaling_ ou o princípio de "Parar de adivinhar capacidade".
- **Framework:** conjunto de documentos, whitepapers e conceitos (teoria).
- **Tool:** o serviço no console da AWS onde respondemos perguntas sobre arquitetura para receber um relatório de riscos (prática/ferramenta).
- *Pegadinha*: a prova pode perguntar "Qual serviço ajuda a revisar nossa arquitetura contra as melhores práticas?". A resposta é **AWS Well-Architected Tool**, não o Framework em si. 

O nível Practioner exige saber o **objetivo** de cada pilar e os princípios gerais de design ("Stop guessing capacity", "Test at scale", etc), mas não como configurar regras de segurança específicas dentro do pilar de Security (isso é nível Associate). 

**Card 1** **Frente:** Qual é o princípio de design do AWS Well-Architected Framework que recomenda substituir o investimento fixo em infraestrutura por despesas variáveis baseadas no consumo real? 
?
*Stop guessing your capacity needs* (Pare de adivinhas suas necessidades de capacidade). Na nuvem, usamos o *Autoscalling* para ajustar recursos à demanda, evitando pagar por servidores ociosos, ao contrário do modelo on-premise onde precisamos adivinhar o pico de uso 

**Card 2 Frente:** uma empresa quer revisar suas cargas de trabalho atuais para garantir que estão seguindo as melhores práticas de segurança e confiabilidade da AWS. Qual serviço deve ser utilizado?
?
**Verso:** AWS Well-Architected Tool. **Explicação:** A ferramenta (Tool) é o serviço no console que permite realizar a avaliação baseada nos pilares do Framework. O Framework é apenas o conceito/documentação.

**Card 3** **Frente:** Qual pilar do AWS Well-Architected Framework foca na capacidade de um sistema de se recuperar de falhas de infraestrutura ou serviço e mitigar interrupções? 
?
**Verso:** Reliability (Confiabilidade). **Explicação:** Confiabilidade trata de garantir que o sistema continue funcionando ou se recupere rapidamente em caso de falhas, incluindo conceitos como recuperação de desastres e alta disponibilidade.

**Card 4** **Frente:** Qual pilar do AWS Well-Architected Framework inclui a consideração de impactos ambientais a longo prazo nas decisões arquiteturais?
?
**Verso:** Sustainability (Sustentabilidade). **Explicação:** Este pilar foca em minimizar o impacto ambiental da execução de cargas de trabalho na nuvem, otimizando o uso de energia e eficiência.

## Operational Excellence
O objetivo geral do pilar de excelência operacional é garantir que executemos e monitoremos sistemas para assegurar que eles estejam fornecendo valor paras as metas de negócios da organização. Este pilar foca nas melhores práticas operacionais para execução e monitoramento de sistemas e na melhoria contínua de processos e procedimentos.

**NOTA:** embora muito de nós em tecnologias achemos a nuvem incrivelmente "legal", não devemos utilizar tecnologias pelo fato de serem empolgantes, em vez disso, devemos utilizar a tecnologias porque ela auxilia nossa organização a alcançar os objetivos de negócios mais importantes.

Este pilar consiste nos seguintes princípios de design importantes:
- **Realize operações como código (Perform operations as code):** quando estivermos realmente avançando com a excelência operacional, construiremos nossa infraestrutura e serviços de nuvem como código. A sigla utilizada para esse princípio é #IaC, que é a abreviação de *infrastructure as code* (infraestrutura como código). Por que a obsessão em fazer tudo como código? <span style="background:#d3f8b6">Isso ajuda a eliminar erros humanos e garante consistência em nossas operações.</span>
- **Faça mudanças pequenas e reversíveis frequentes na arquitetura para melhora-lá**: ao implementar procedimentos operacionais, precisamos estar sempre vigilante para identificar chances de melhorias. À medida que nossa carga de trabalho passa por desenvolvimento, garantimos que seus procedimentos evoluam de acordo. Devemos considerar agendar "game days" de rotina para avaliar e confirmar a eficácia de todos os procedimentos e para garantir que nossas equipes estejam bem familiarizadas com eles.
- **Antecipe falhas e tenha planos de recuperação prontos:** para atingir esse objetivo de design, devemos estar engajados em testar, testar e testar ainda mais. Teste falhas e teste suas respostas. Teste como suas equipes reagem a falhas e tente tornar as variáveis desconhecidas em fatos conhecidos daqui para frente. É muito mais fácil operar diante da adversidade se testamos completamente nossas respostas a falhas e sabemos que nossos procedimentos de recuperação são sólidos.
- **Aprenda com todas as falhas operacionais em nossa arquitetura:** devemos promover a evolução de nossas soluções AWS extraindo insights de cada evento operacional e, talvez ainda mais importante, de cada falha. 

**Operation Excellence** foca em **Pessoas, Processos e Código**. 
**Reliability** foca na resiliência do sistema (recuperação técnica).

1. **Infrastructure as Code (IaC):** a prova associa esse princípio ao serviço AWS CloudFormation. Se a questão falar sobre "reduzir erro humano ao provisionar recursos" ou "garantir consistência na implantação", a resposta correta está ligada a IaC e Excelência Operacional.
2. **Mudanças Pequenas e Reversíveis:** o cenário típico de prova envolve uma empresa que faz grandes atualizações mensais (monolíticas) e sofre com falhas difíceis de corrigir. A solução recomendada pela AWS é mudar para atualizações frequentes, pequenas e reversíveis. Isso minimiza o "Blast Radius" (raio de impacto) de um erro.

**Pegadinha Clássica:**
- Pergunta: "Qual pilar foca na capacidade de recuperar dados após um desastre?" -> **Reliability**.
- Pergunta: "Qual pilar foca em antecipar falhas testando procedimentos de resposta da equipe?" -> **Operational Excellence** (o foco aqui é o procedimento/equipe, não apenas o backup técnico).

**Pergunta (múltipla escolha):**  
Qual princípio de design do pilar **Excelência Operacional** do AWS Well-Architected Framework ajuda a reduzir erros humanos e garantir consistência na criação de infraestrutura?
A) Antecipar falhas  
B) Executar operações como código  
C) Fazer mudanças pequenas e reversíveis  
D) Monitorar métricas de desempenho
?
B) Executar operações como código. A prova associa diretamente **Infrastructure as Code** a redução de erros manuais e padronização. CloudFormation é o exemplo mais citado em questões reais.

**Pergunta (múltipla escolha):**  
Uma empresa deseja melhorar seu processo de implantação para que, caso ocorra um erro, seja possível reverter rapidamente a alteração com impacto mínimo. Qual princípio de design do AWS Well-Architected Framework recomenda essa abordagem?
A) Antecipar falhas  
B) Executar operações como código  
C) Fazer mudanças pequenas e reversíveis frequentes  
D) Automatizar respostas a eventos
?
C) Fazer mudanças pequenas e reversíveis frequentes. Questões reais usam palavras-chave como **rollback rápido**, **impacto mínimo** e **frequência** para apontar esse princípio.

**Pergunta (múltipla escolha):**  
Qual pilar do AWS Well-Architected Framework é responsável por focar na execução, no monitoramento de sistemas e na melhoria contínua de processos para entregar valor de negócio?
A) Segurança  
B) Confiabilidade  
C) Eficiência de Performance  
D) Excelência Operacional
?
D) Excelência Operacional. A prova diferencia bem **processos e operação contínua** (Operational Excellence) de **resiliência técnica** (Reliability).

De acordo com o pilar de **Excelência Operacional**, qual é o principal benefício de **antecipar falhas** em sistemas na AWS?
A) Reduzir custos operacionais automaticamente  
B) Melhorar o desempenho de aplicações  
C) Aprender como sistemas e equipes reagem a falhas antes de ocorrerem em produção  
D) Eliminar completamente a necessidade de monitoramento
?
C) Aprender como sistemas e equipes reagem a falhas antes de ocorrerem em produção. Termos como **Game Days**, **simulação de falhas** e **procedimentos de recuperação** aparecem com frequência em questões reais.

## Security
O trabalho do pilar de segurança é ajudar a proteger nossos ativos, sistemas e informações associadas à AWS. Este pilar também deve ajudar com avaliações de risco e nossas práticas de mitigação. 

Este pilar consiste nos seguintes princípios de design importantes:
- **Use práticas fortes de identidade em sua arquitetura:** Felizmente, a AWS fornece ferramentas para tornar isso fácil. Por exemplo, com o AWS identity and Access Management (IAM), podemos criar múltiplas contas para usuários e administradores, o que ajuda a garantir que existe uma prática de **menor privilégio** em vigor. Os usuários podem selecionar a conta que fornece apenas as permissões que precisam. Claro, o IAM também centraliza as contas de usuário que precisam interagir com a AWS, e a centralização de contas é outra prática forte de identidade.
- **Garanta rastreabilidade total em todas as operações:** é importante monitorar, alertar e auditar continuamente ações e modificações em seu ambiente conforme elas ocorrem. A AWS fornece excelentes ferramentas para realizar isso. Por exemplo, podemos usar o **AWS CloudWatch** e o **AWS CloudTrail** juntos para monitorar, alertar e auditar perfeitamente. Como parte desse princípio de design, <span style="background:#d3f8b6">você deve incorporar a coleta de logs e métricas em seus sistemas para permitir  investigações e respostas automatizadas</span>. 
- **Implemente segurança em absolutamente todas as camadas de sua arquitetura:** para alcançar esse princípio de design, você deve examinar sua solução AWS camada por camada e componente por componente sob uma perspectiva de segurança. Você deve usar ferramentas em cada camada para ajudar a proteger essa camada e seus recursos. É o que gostamos de chamar de solução de "defesa em profundidade" (*defense in depth*) em TI.
- **Faça um esforço concentrado para automatizar o máximo possível de melhores práticas de segurança**: não se esqueça da segurança quando estiver focando em automação em suas soluções AWS. <span style="background:#affad1">A automação reduz erros humanos</span> e <span style="background:#affad1">ajuda sua segurança a escalar de forma significativa.</span> 
- **Proteja informações em repouso, em trânsito e em uso:** além de seguir uma abordagem de defesa em profundidade, você deve dividir mentalmente seus dados e recursos AWS em três categorias: dados em repouso (at rest), dados em trânsito (in transit) e dados em uso (in use) e aplicar os controles de segurança apropriados para cada categoria. A nuvem AWS tem várias ferramentas integradas diretamente na plataforma. Você também pode contar com soluções de terceiros de parceiros e clientes da AWS no AWS Marketplace.
- **Na medida do possível, mantenha pessoas longe dos dados:** podemos usar as tecnologias da AWS para impedir que pessoas interajam diretamente com os dados. Eu que isso soa muito duro, mas elimina todas os tipos de preocupações de segurança e também aborda preocupações de precisão e excelência operacional.
- **Prepara-se o máximo possível para os inevitáveis eventos de segurança em sua arquitetura e nuvem:** você e suas equipes estão prontos para um grande incidente de segurança na nuvem? Como você pode ter certeza? Você deve estabelecer políticas e procedimentos de gerenciamento de incidentes que estejam alinhados com as necessidades da sua organização. Realize simulações de resposta a incidentes e aproveite ferramentas de automação para agilizar os processos de detecção, investigação e recuperação.

**Conceitos Centrais para a Prova:** O Pilar de Segurança é o mais cobrado tecnicamente no exame CLF-C02. Aqui estão os pontos de conexão direta:
1. **Princípio do Menor Privilégio (Least Privilege):**
	- Esta é a regra de ouro do IAM mencionado no texto.
	- Cenário de prova: um funcionário precisar apenas acessar o S3. Você deve dar acesso de Admin?" Não. Dê acesso apenas ao S3.
	- A AWS sempre quer que você escolha a opção que concede "apenas as permissões necessárias para realizar a tarefa".
2. **Rastreabilidade (Traceability) = CloudTrail**:
	- O texto menciona #CloudWatch  e #CloudTrail. Para a prova, memorize a diferença:
		- CloudTrail: quem fez o quê? (Auditoria, Logs de API, Rastreabilidade). Quem deletou meu bucket?
		- **CloudWath:** o que está acontecendo? (Performance, CPU alta, Alarmes).
		- **AWS Config:** (Não citado explicitamente, mas vital para rastreabilidade de *configuração*). O que mudou na configuração do recurso ao longo do tempo?

A prova pode perguntar:  "Quem é responsável por proteger os dados do cliente?" O cliente (Shared Responsibility Model). A AWS protege a Nuvem (físico, rede, global), o cliente protege o que está na *nuvem* (dados, criptografia, IAM). O pilar de segurança orienta o *Cliente* nesta tarefa.

- **Autenticação Multi-Fator (MFA) para Root:** Em 2024/2025, a AWS começou a *exigir* MFA para usuários raiz (Root Users) em muitas contas novas e existentes. A prova CLF-C02 reforça muito o uso de MFA como a primeira linha de defesa.


Qual princípio de design do **Pilar de Segurança** do AWS Well-Architected Framework recomenda conceder aos usuários apenas as permissões necessárias para executar suas tarefas, e nada além disso?
A) Defesa em profundidade  
B) Rastreabilidade  
C) Princípio do menor privilégio  
D) Automação de controles de segurança
?
C) Princípio do menor privilégio. A prova associa diretamente **IAM** e **menor privilégio** à redução de riscos. Palavras-chave como _somente o necessário_ e _evitar permissões excessivas_ indicam essa resposta.

Qual serviço da AWS oferece suporte ao princípio de design de **Rastreabilidade**, registrando chamadas de API e eventos da conta para fins de auditoria e conformidade?
A) Amazon CloudWatch  
B) AWS Config  
C) AWS CloudTrail  
D) AWS GuardDuty
?
C) AWS CloudTrail. Questões reais testam a diferença entre **CloudTrail (quem fez o quê)** e **CloudWatch (métricas e logs de performance)**.

De acordo com o **Modelo de Responsabilidade Compartilhada da AWS**, quem é responsável pela criptografia dos dados do lado do cliente, bem como pela configuração da criptografia de dados em repouso e em trânsito?
A) Apenas a AWS  
B) Apenas o cliente  
C) AWS para dados em repouso e o cliente para dados em trânsito  
D) A AWS e o cliente, igualmente
?
B) Apenas o cliente. A prova reforça que a AWS fornece **ferramentas**, como o KMS, mas a **configuração e uso da criptografia** são responsabilidade do cliente (_Security IN the cloud_).

Qual conceito de segurança da AWS envolve a aplicação de controles em múltiplas camadas da arquitetura — como borda, rede, instância e dados — para aumentar a proteção contra falhas?
A) Princípio do menor privilégio  
B) Rastreabilidade  
C) Defesa em profundidade  
D) Isolamento de contas
?
D) Defesa em profundidade. Questões reais citam exemplos como WAF, Security, NACLs e criptografia, indicando múltiplas camadas de proteção.

## Confiabilidade (Reliability)
O pilar de Confiabilidade consiste em diversos princípios de design importantes que têm como foco garantir que nossa arquitetura consiga se recuperar facilmente de falhas de serviço. Ele também assegura que nossa arquitetura possa crescer em recursos conforme a demanda. Confiabilidade na nuvem também significa que interrupções podem ser mitigadas com relativa facilidade. Parece ótimo? É mesmo. Um fator importante para a popularidade da nuvem pública é a capacidade de aumentar drasticamente a confiabilidade de TI sem os grandes investimentos que seriam necessários em um ambiente tradicional.

Os designs deste pilar:
- **Automatizar a recuperação de falhas sempre que possível:** assim como ocorre com controles de segurança, devemos monitorar cuidadosamente nossas soluções na AWS e automatizar respostas apropriadas. Um exemplo é o AWS Auto Scaling. Se nossa solução estiver com poucos recursos, a AWS pode adicionar mais automaticamente. Quando a demanda normaliza, o Auto Scaling reduz os recursos utilizados, trazendo também benefícios de otimização de custos.
- **Testar a recuperação:** normalmente, as organizações praticam estratégias de backup, mas não testam os procedimentos de restauração. Isso pode gerar caos quando uma restauração real é necessária. A AWS permite testar cenários de recuperação para diversos tipos de falhas. Se a recuperação for automatizada, o que está sendo testado é a próprio automação.
- **Escalar horizontalmente automaticamente quando necessário:** Na AWS, é possível escalar verticalmente ou horizontalmente. Escalar verticalmente significar adicionar recursos a uma única instância EC2, mas a AWS recomenda evitar essa abordagem sempre que possível. O ideal é escalar horizontalmente, adicionando várias instâncias menores e distribuindo as requisições. Isso elimina pontos únicos de falha e aumenta a confiabilidade.
- **Parar de adivinhar as capacidades de recursos de TI:** em ambientes tradicionais, engenheiros precisam estimar a capacidade necessária, e erros levam à falta de recursos e a gastos emergenciais elevados. Na nuvem, com ferramentas como o Auto Scaling não é necessário adivinhar capacidade, pois há grande disponibilidade de recursos e economia de escala.
- **Gerenciar mudanças por meio da automação:** além de mudanças pequenas e reversíveis, elas devem ser automatizadas. Por exemplo, se for necessário criar usuário da AWS com permissões de monitoramento para EC2 e Lambda, isso deve ser feito por scripts automatizados usando ferramentas como a AWS CLI.

Insights valiosos (foco CLF-C02)
- A prova associa **Reliability** diretamente a **Auto Scaling, Elastic Load Balancing e eliminação de single point of failure**.
- Escalar horizontalmente quase sempre indica **Auto Scaling Groups + Load Balancer**.
- "Parar de adivinhar capacidade" é um sinal claro de **elasticidade da nuvem**, não de compra antecipada.
- Erro comum: confundir **Reliability** com **Performance Efficiency**. Confiabilidade é recuperação e continuidade, não velocidade.
- Em prova, automação é sempre preferida a ações manuais.

Ênfase em escala vertical aparece menos nas provas atuais; a AWS reforça quase exclusivamente **escala horizontal**. Uso direto de scripts manuais via CLI é menos citado;

## Performance Efficiency
O pilar de eficiência de performance preocupa-se com o uso mais eficiente possível dos recursos da AWS. A eficiência deve ser mantida à medida que a demanda muda e a tecnologia evolui.
**Objetivos deste pilar**
- **Democratizar tecnologias avançadas (isto é, torná-las disponíveis para as massas):** orçar para quantidades massivas de armazenamento e poder de computação não deve impedir nossa empresa de tirar vantagem da inteligência artificial (IA) e outras tecnologias avançadas. A AWS quer que você aproveite suas economias de escala para utilizar tecnologias de ponta como a IA, análise de negócios (*business analytics*), big data, Internet das Coisas (IoT) e mais.

- **Levar recursos globalmente em minutos:** podemos não conseguir alcançar este princípio de design sem a ajuda da massiva infraestrutura global da AWS. Graças à AWS, é simples tornar uma solução globalmente disponível em segundos. Podemos até tirar vantagem de redes de entrega de conteúdo (CDNs) globais, como o CloudFront. Os clientes ficarão impressionados com o nível de latência (pouca ou nehuma) que experimentam ao acessar suas soluções, não importa onde estejam localizados no planeta. 

- **Priorize a computação sem servidor (serverless) tanto quanto possível:** Por que se preocupar com suas próprias máquinas virtuais ou contêineres quando você precisa de recursos de computação na AWS? Aproveite as opções *serverless* e deixa a AWS fazer todo o trabalho para você. Lembre-se de que a AWS oferece muitas opções para computação *serverless*, desde hospedar um site a partir de um bucket s3 até ter recursos de computação massivos esperando por você no pool de recursos baseados em nuvem chamado AWS Lambda. 

- **Experimente livremente e com frequência:** graças à conveniência de recursos sob demanda e muitas ferramentas de automação, é fácil para nós experimentarmos novas topologias e tecnologias na Nuvem AWS. Mais uma vez, isso seria quase impossível (e caro) em uma infraestrutura de TI tradicional. Infelizmente, para a maioria das organizações de TI, apenas manter as necessidades do dia a dia é tudo em que a equipe pode focar; simplesmente não há recursos disponíveis para experimentação.

- **Mantenha a simpatia mecânica (isto é, combine metas de negócios com  as tecnologias apropriadas):** como estamos aprendendo rapidamente, a AWS tem um serviço ou ferramenta para praticamente qualquer coisa que possamos imaginar relacionada à TI. Parte do nosso trabalho como *cloud  practitioner* (e além) é ser capaz de combinar essas tecnologias com as necessidades e metas de negócios específicas da nossa organização. Felizmente, as soluções estão todas lá para aprendermos a explorar. Mais uma vez, ambientes de TI tradicionais tendem a carecer da maior parte do que realmente precisamos.

**Card 1** **Frente:** Uma empresa deseja melhorar a performance de seu site estático global reduzindo a latência para usuários em diferentes países. Qual serviço AWS deve ser utilizado?
?
>**Verso:** *Amazon CloudFront*. **Explicação:** O CloudFront é a CDN (Content Delivery Network) da AWS que armazena cache de conteúdo em Edge Locations (Locais de Borda) próximos aos usuários, reduzindo a latência.

**Card 2** **Frente:** Qual pilar do AWS Well-Architected Framework foca no uso eficiente de recursos de computação e TI, e na seleção do tipo certo de recurso para a carga de trabalho?
?
>**Verso:** Performance Efficiency (Eficiência de Performance). **Explicação:** Este pilar trata de escolher a ferramenta certa (instância, banco de dados) e otimizar o uso para garantir o melhor desempenho.

**Card 3** **Frente:** Qual é o benefício do princípio de design "Democratizar tecnologias avançadas" do pilar de Eficiência de Performance?
?
**Verso:** permite que pequenas empresas usem tecnologias complexas (como IA, Machine Learning e Analytics) sem altos custos iniciais ou conhecimento técnico profundo de hardware. **Explicação:** a nuvem transforma custos fixos elevados (CapEx) em custos variáveis, permitindo acesso a serviços de ponta como serviço.

## Cost Optimization
Este pilar tem como objeto economizar dinheiro e parar de desperdiçar investimentos em tecnologia.
- **Implemente o Gerenciamento Financeiro na Nuvem (CFM):** CFM refere-se ao conjunto de práticas, ferramentas e estratégias que as organizações usam para gerenciar suas finanças e controlar custos no contexto da computação em nuvem. Aspectos de uma abordagem sólida de CFM incluem tarefas como gerenciamento e alocação de custos, orçamento e previsão (*forecasting*), otimização de custos, redimensionamento (*right-sizing*) e uso de tags e rótulos em recursos de nuvem.
- **Adote um modelo de consumo (que enfatiza a abordagem de OpEx para TI):** com a mudança para a AWS, podemos começar a pagar apenas pelos recursos que precisamos, incluindo recursos temporários. Por exemplo, se precisarmos de um ambiente de *staging* ou teste enquanto estamos melhorando uma de nossas soluções, podemos iniciá-lo, fazer nossos testes e depois desligá-lo ou até mesmo desliga-lo e excluí-lo em seguida.
- **Meça a eficiência da arquitetura de perto:** a AWS torna isso simples com muitas ferramentas relacionadas a custos. É muito fácil fazer mudanças e depois monitorar as implicações financeiras dessas mudanças. Temos mais visibilidade sobre o custo de nossas soluções com a Nuvem AWS do que teríamos com um ambiente tradicional.
- **Pare de gastar dinheiro desnecessariamente para tentar resolver problemas de TI:** A AWS inerentemente torna possível este objetivo de design. Não precisamos mais nos preocuparmos em comprar novos racks de servidores, novo cabeamento, novos arrays de armazenamento e assim por diante quando se trata das últimas tecnologias avançadas.
- **Análise de perto as despesas em nossa implementação AWS:** aqui está outro objetivo de design que a AWS torna simples, graças às numerosas ferramentas disponíveis para rastrear custos. Podemos até usar *tagging* e rotulagem de nossos recursos AWS para que seja fácil atribuir nossos custos e soluções, departamentos ou equipes específicas. Nossos contadores internos devem adorar essa nova habilidade.

*Insights Valiosos*
**OpEx vs. CapEx:** o texto menciona "modelo de consumo". Para  a prova, associe isso diretamente a **Despesa Operacional (OpEx).** CapEx (Capital Expenditure) é gasto antecipado com Data Centers físicos (modelo tradicional). 

- **Cost Allocation Tags:** Se a questão perguntar "Como saber quanto o departamento de Marketing gastou?", a resposta é **Tags**.
- **AWS Budgets**: é a ferramenta para definir um limite de gastos e receber **alertas** (e-mail/SMS) se esse limite for excedido.
- **AWS Cost Explorer:** ferramenta gráfica para visualizar gastos passados e **prever (forecast)** gastos futuros para os próximos meses.
- **AWS Pricing Calculator:** para estimar custos **antes** de criar os recursos.

**Card Frente** Uma empresa deseja ser notificada por e-mail quando seus gastos mensais na AWS ultrapassarem um limite definido de $1.000. Qual serviço deve ser utilizado para alertar sobre o limite estabelecido?
?
>AWS Budgets

**Card 2** **Frente:** Qual ferramenta da AWS permite visualizar padrões de gastos históricos e fornece previsões (forecasts) de custos para os próximos 12 meses?
?
>**Verso:** AWS Cost Explorer

## Sustainability
O objetivo deste pilar é nobre: tentar ajudar os clientes a minimizar os impactos ambientais da execução de cargas de trabalho na nuvem. Para o desenvolvimento deste pilar, a AWS baseou-se na Comissão Mundial sobre Meio Ambiente e Desenvolvimento das Nações Unidas, cuja definição de sustentabilidade encoraja o desenvolvimento que "atende às necessidades do presente sem comprometer a capacidade das gerações futuras de atenderem às suas próprias necessidades". 

Os principais princípios de design para este pilar mais novo da arquitetura são os seguintes:
- **Entenda seu impacto:** A AWS permite que você quantifique a influência da sua carga de trabalho na nuvem e preveja suas ramificações futuras. Esta avaliação deve englobar todas as fontes de impacto, abrangendo impactos decorrentes da utilização do produto pelo cliente e a fase final de descontinuação e retirada do produto. Você pode analisar os recursos e emissões necessários por unidade de trabalho e compará-los com o impacto geral das suas cargas de trabalho na nuvem. Esta informação pode servir como base para estabelecer indicadores-chave de desempenho (KPIs), avaliar estratégias para aumentar a produtividade enquanto minimiza o impacto e projetar o impacto das alterações propostas ao longo do tempo.
- - **Estabeleça metas de sustentabilidade:** É importante definir objetivos de sustentabilidade duradouros para cada carga de trabalho na nuvem, como a redução de recursos de computação e armazenamento necessários por transação. Você também deve criar modelos de retorno sobre investimento (ROI) para avaliar as melhorias de sustentabilidade para cargas de trabalho atuais e fornecer aos proprietários das cargas de trabalho os recursos necessários para investir no alcance dessas metas de sustentabilidade.
- - **Maximize a utilização:** Este princípio pode parecer contraintuitivo, mas a AWS está dizendo que você não deve superprovisionar (_overprovision_) seus recursos. Infelizmente, o superprovisionamento é muito comum em ambientes de TI tradicionais, onde a capacidade é frequentemente tratada alocando e provisionando muito mais recursos do que os realmente necessários. Com a AWS, você pode dimensionar corretamente (_right-size_) os recursos que precisa consumir.
- - **Antecipe e adote ofertas de hardware e software novas e mais eficientes:** Aqui está outro princípio de design onde a AWS ajuda você por padrão. A AWS está constantemente tornando tecnologias mais novas e eficientes disponíveis para você e utilizando-as ela mesma.
- - **Use serviços gerenciados:** Quando você recorre aos serviços gerenciados massivamente populares da AWS (por exemplo, armazenamento S3), você está aproveitando o princípio de maximização eficiente de recursos. A AWS apropriou-se de quantidades verdadeiramente massivas de recursos e ajuda você a usá-los de forma eficiente. Isso é muito melhor para o meio ambiente do que cada cliente da AWS ao redor do globo tentar criar seus próprios recursos.
- **Reduza o impacto downstream (a jusante) das suas cargas de trabalho na nuvem:** Para ajudar a alcançar este princípio de design, você pode tomar várias medidas. Primeiro, reduza a quantidade de energia ou recursos necessários para usar seus serviços. Em seguida, reduza a necessidade de os clientes atualizarem seus dispositivos para usar seus serviços. Finalmente, teste soluções com clientes para entender o impacto real do uso de seus serviços.



1. Which of the following is not a pillar of the AWS Well-Architected Framework?
a. Simplicity
b. Performance efficiency
c. Security
d. Reliability