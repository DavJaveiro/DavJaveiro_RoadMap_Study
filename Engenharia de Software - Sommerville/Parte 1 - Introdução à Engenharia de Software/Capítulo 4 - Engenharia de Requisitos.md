**Objetivos**
Os objetivos deste capítulo são introduzir **requisitos de software** e explicar o processo envolvido na descoberta e na documentação desses requisitos. Ao ler este capítulo, seremos capazes de:
- compreender os conceitos de **requisitos de usuário** e **requisitos de sistema** e por que eles devem ser escritos de maneira diferentes;
- compreender as diferenças entre requisitos de software funcionais e não funcionais;
- compreender as principais atividades da engenharia de requisitos: elicitação, análise e validação, e as relações entre elas;
- compreender por que o gerenciamento de requisitos é necessário e como ele apoia outras atividades da engenharia de requisitos.

**Conteúdo**
- [x] 4.1 Requisitos funcionais e não funcionais;
- [x] 4.2 Processos de engenharia de requisitos;
- [ ] 4.3 Elicitação de requisitos;
- [ ] 4.4 Especificação de requisitos;
- [ ] 4.5 Validação de requisitos;
- [ ] 4.6 Mudança de requisitos.

---
Os requisitos de um sistema são as descrições dos serviços que o sistema deve prestar e as restrições a sua operação. Esses requisitos <span style="background:#b1ffff">refletem as necessidades dos clientes de um sistema</span> que atende a um determinado propósito, como controlar um dispositivo, fazer um pedido ou encontrar informações. O processo de **descoberta**, **análise**, **documentação** e **conferência desses serviços** e restrições **é chamado de engenharia de requisitos ER**.

O termo *requisito* não é utilizado consistentemente na indústria de software. Em alguns casos, um requisito é simplesmente uma declaração abstrata de alto nível de **um serviço** que um sistema deve **oferecer** ou de uma **restrição** a um sistema. No outro extremo, é uma **definição formal** detalhada de uma função do sistema. Davis (1993) explica por que essas diferenças existem:

*Se uma empresa deseja assinar um contrato para um grande projeto de desenvolvimento de software, ela deve definir suas necessidades de uma maneira suficientemente abstrata para que não haja uma solução predefinida. Os requisitos devem ser escritos de modo que vários concorrentes possam disputar o contrato, oferecendo, talvez, maneiras diferentes de satisfazer as necessidades da empresa cliente. Depois de assinado o contrato, o contratado deve escrever uma definição mais detalhada do sistema para o cliente, de modo que ele entenda e valide o que o software fará. Esses dois documentos podem ser reunidos em um documento de requisitos de sistema.*

Alguns dos problemas que surgem durante o processo de engenharia de requisitos são consequência de não separar claramente os **diferentes níveis de descrição**. Faço uma distinção entre eles usando os termos *requisitos de usuário* para indicar os requisitos abstratos de alto nível e *requisitos de sistema* para indicar a descrição detalhada do que o sistema deve fazer. Os requisitos de usuário e os requisitos de sistema podem ser definidos da seguinte forma:
1. <span style="background:#d4b106">Requisitos de usuário</span> são declarações, em uma linguagem natural somada a diagramas, dos serviços que se espera que o sistema forneça para os usuários e das limitações soba as quais ele deve operar. Esses requisitos podem variar de declarações amplas das características necessárias do sistema até descrições precisas e detalhadas da sua funcionalidade.
2. Os <span style="background:#d4b106">requisitos de sistema</span> são descrições mais detalhadas das funções, dos serviços e das restrições operacionais do sistema de software. O documento de requisitos de sistema (chamado às vezes de **especificação funcional**) deve definir exatamente o que deve ser implementado. Pode fazer parte do contrato entre o adquirente do sistema e os desenvolvedores de software.

Um requisito de usuário pode ser ampliado para vários requisitos de sistema, os requisitos dos usuários é bem genérico, os requisitos de sistema fornecem informações mais específicas <span style="background:#affad1">sobre os serviços e funções que devem ser implementados</span>.

É necessário escrever os requisitos em diferentes níveis de detalhe, pois diferentes tipos de leitores utilizam esses dados de diferentes maneiras. A Figura 4.2 mostra os tipos de leitores dos requisitos de usuário e de sistema. O primeiro grupo geralmente não está preocupado com o modo como o sistema será implementado, e pode ser composto por gerentes que não estejam interessados nos recursos detalhados do sistema. Por sua vez, o segundo grupo precisa saber com mais precisão o que o sistema fará, seja porque estão interessados em saber como ele apoiará os processos da empresa ou porque estão envolvidos na sua implementação. 
![[Capítulo 4 - Engenharia de Requisitos.png]]

![[Capítulo 4 - Engenharia de Requisitos-1.png]]

Os diferentes tipos de leitores de documento exibidos na Figura 4.2 são exemplos de *stakeholders* do sistema. Assim como usuários, muitas outras pessoas têm algum tipo de interesse no sistema. Os *stakeholders* incluem qualquer um que seja afetado de alguma maneira pelo sistema e, portanto, tenha um interesse legítimo nele. Podem variar de usuários finais de um sistema a gerentes e *stakeholders* externos, como autoridades reguladoras, que certificam a aceitabilidade do sistema. Por exemplo, os *stakeholders* do sistema Mentcare são:
1. Pacientes cujas informações estão registradas no sistema e familiares desses pacientes;
2. médicos responsáveis por avaliar e tratar os pacientes;
3. profissionais de enfermagem que coordenam as consultas com os médicos e administram alguns tratamentos;
4. recepcionistas que marcam as consultas dos pacientes;
5. equipes de TI responsável pela instalação e manutenção do sistema.
6. um gestor de ética médica que deve assegurar que o sistema satisfaz as diretrizes éticas atuais de cuidados com os pacientes;
7. gestores de cuidados com a saúde que obtêm informações gerenciais do sistema;
8. o pessoal de controle do prontuário responsável por garantir que as informações do sistema possam ser mantidas e preservadas e que os procedimentos de manutenção de registros tenham sido adequadamente implementados.

A engenharia de requisitos normalmente é apresentada como o primeiro estágio do processo de engenharia de software. No entanto, pode ser necessário desenvolver algum nível de compreensão dos requisitos de sistema antes de tomar a decisão de adquirir ou desenvolver um sistema. Essa ER inicial estabelece uma visão de alto nível do que o sistema poderia fazer e dos benefícios que poderia proporcionar. Esses pontos podem ser considerados em um estudo de viabilidade, ferramenta usada para avaliar se o sistema é tecnicamente e financeiramente viável. Os resultados desse estudo ajudam a gestão a decidir se deve ou não seguir adiante com a aquisição ou com o desenvolvimento do sistema.

Neste capítulo, apresento uma visão *tradicional* dos requisitos em vez da visão dos processos ágeis, que foi discutido no Capítulo 3. Na maioria dos sistemas grandes, ainda é o caso de haver uma fase de engenharia de requisitos claramente identificável antes de começar a implementação do sistema. O resultado é um documento de requisitos, que pode fazer parte do contrato de desenvolvimento do sistema. Naturalmente, são feitas mudanças subsequentes nos requisitos de usuário, que podem ser ampliados para requisitos de sistema mais detalhados. Às vezes, pode-se utilizar uma abordagem ágil para elicitar simultaneamente os requisitos à medida que o sistema é desenvolvido, a fim de acrescentar detalhes e refinar os requisitos de usuário.

---
**Estudo de viabilidade**
O estudo de viabilidade é um estudo curto e focalizado que deve ser feito no início do processo de ER. Ele deve responder três perguntas fundamentais:
1. O sistema contribui para os objetivos globais da organização?
2. O sistema pode ser implementado dentro do cronograma e orçamento usando a tecnologia atual?
3. O sistema pode ser integrado com outros sistemas utilizados?

Se a resposta a qualquer uma dessas perguntas for *não*, <span style="background:#d3f8b6">provavelmente não se deve prosseguir com o projeto</span>.

---
## 4.1 Requisitos Funcionais e Não Funcionais
Os requisitos de sistema de software são classificados frequentemente como **funcionais** e **não funcionais**:
1. *Requisitos funcionais:* são declarações dos serviços que o sistema deve fornecer, de modo como o sistema deve reagir a determinadas entradas e de como deve se comportar em determinadas situações. Em alguns casos, os requisitos funcionais também podem declarar explicitamente o que o sistema não deve fazer.
2. *Requisitos não funcionais:* são restrições sobre os serviços ou funções oferecidas pelo sistema. Eles incluem restrições de tempo, restrições sobre o processo de desenvolvimento e restrições impostas por padrões. Os requisitos não funcionais se aplicam, frequentemente, ao sistema como um todo, em vez de às características individuais ou aos serviços.

Na realidade, a distinção entre os diferentes tipos de requisitos não é tão clara quanto sugerem essas definições simples. Um requisito de usuário relacionado à segurança da informação (*security*), como uma declaração que limita o acesso aos usuários autorizados, pode parecer um requisito não funcional. No entanto, quando desenvolvido em mais detalhes, esse requisito pode gerar outros requisitos claramente funcionais, como a necessidade de incluir no sistema alguns recursos de autenticação do usuário.

Isso mostra que os requisitos não são independentes e que, frequentemente, um requisito gera ou limita outros. Portanto, os requisitos de sistema especificam não apenas os serviços ou características, mas também a funcionalidade necessária para garantir que esses serviços/características sejam entregues corretamente.

### 4.1.1 Requisitos funcionais
Os requisitos funcionais de um sistema descrevem o que ele deve fazer e dependem do tipo de software e da abordagem geral adotada pela organização ao escrever os requisitos. Quando são apresentados como requisitos de usuário, os requisitos funcionais devem ser escritos de modo compreensível para os usuários e gerentes do sistema. Os requisitos funcionais do sistema expandem os requisitos de usuário e são escritos para os desenvolvedores. Requisitos funcionais devem descrever em detalhes as funções do sistema, suas entradas, saídas e exceções.

Os requisitos funcionais do sistema variam desde os mais gerais, cobrindo o que o sistema deve fazer, até os mais específicos, refletindo os modos de trabalho locais ou os sistemas existentes em uma empresa. A seguir são apresentados exemplos de requisitos funcionais do sistema Mentcare, utilizado para manter informações sobre pacientes recebendo tratamento para problemas de saúde mental:
1. Um usuário deve poder fazer uma busca na lista de consultas de todas as clínicas;
2. O sistema deve gerar, a cada dia e para cada clínica, uma lista de pacientes que devam comparecer às consultas naquele dia;
3. Cada membro da equipe que utiliza o sistema deve ser identificado exclusivamente por seu número de funcionário de oito dígitos.

Esses requisitos de usuário definem funcionalidades específicas que serão incluídas no sistema. Os exemplos mostram que os requisitos funcionais devem ser escritos em diferentes níveis de detalhes.

---
**Requisitos de domínio**
Requisitos de domínio são derivados do domínio de aplicação do sistema, e não das necessidades específicas de seus usuários. Eles podem ser, em sua essência, novos requisitos funcionais, limitar requisitos funcionais existentes ou estabelecer como determinadas computações devem ser executadas. 

O problema com os requisitos de domínio é que os engenheiros de software podem desconhecer as características do domínio no qual o sistema opera, o que significa que eles podem não saber se um requisito de domínio passou ou se entra em conflito com outros.

---
Os requisitos funcionais, como o nome sugere, tem focado tradicionalmente <span style="background:#b1ffff">no que o sistema deve fazer</span>.  No entanto, se uma organização decidir que um sistema de prateleira pode satisfazer suas necessidades, então há muito pouco sentido em desenvolver uma especificação funcional detalhada. Nesses casos, o foco deve ser o desenvolvimento de requisitos de informação que especifiquem as informações necessárias para as pessoas fazerem seu trabalho. Os requisitos de informação especificam as informações necessárias e como elas devem ser fornecidas e organizadas. Portanto, um requisito de informação do sistema Mentcare poderia especificar quais informações devem ser incluídas na lista de pacientes que devem comparecer às consultas do dia.

A imprecisão na especificação de requisitos pode levar a conflitos entre clientes e desenvolvedores de software. É normal que um desenvolvedor de sistemas interprete um requisito ambíguo de uma forma que simplifique a sua implementação. Muitas vezes, porém, não é isso o que o cliente quer. Novos requisitos devem ser estabelecidos e mudanças devem ser feitas, o que resulta em atraso na entrega do sistema e aumento dos custos.

Por exemplo, o primeiro requisito do sistema Mentcare. mencionado anteriormente. afirma que um usuário deve ser capaz de fazer uma busca nas listas de consultas de todas as clinicas. O que justifica esse requisito é que os pacientes com transtornos de saúde mental às vezes se confundem. Eles podem ler uma consulta
em uma clínica, mas acabar indo para outra. Se tiverem uma consulta marcada, serão registrados como atendidos, independentemente da clínica.

Um membro da equipe médica, ao especificar um requisito de busca, pode
esperar que ‘pesquisar’ signifique que. dado o nome de um paciente, o sistema
procure por ele em todas as consultas de todas as clínicas. No entanto, isso não
está explícito. Os desenvolvedores de sistemas podem interpretar o requisito do
modo mais fácil de implementar. Sua função de busca pode exigir que o usuário
escolha uma clínica e depois faça a pesquisa dos pacientes que compareceram a
ela. Isso envolve mais informações fornecidas pelo usuário e leva mais tempo para
completar a busca.

Em condições ideiais, a especificação dos requisitos funcionais de um sistema deve ser completa - todos os serviços e informações requisitadas pelo usuário devem estar definidos - e coerente - os requisitos não devem ser contraditórios.

Na prática, só é possível alcançar a coerência e a completude dos requisitos em sistema de software muito pequenos, e uma das razões para isso é que é mais fácil cometer erros e omissões quando escrevemos especificações de sistemas grandes e complexos. Além disso, sistemas grandes possuem muitos *stakeholders*, com diferentes formações e expectativas, e que tendem a ter necessidades diferentes - e, muitas vezes, inconsistentes. Essas inconsistências podem não ser óbvias quando os requisitos são especificados em um primeiro momento, e os requisitos inconsistentes podem ser descobertos somente após uma análise mais profunda ou durante o desenvolvimento do sistema.

### 4.1.2 Requisitos não funcionais
Os requisitos não funcionais, como o nome sugere, são aqueles que não possuem relação direta com os serviços fornecidos pelo sistema aos seus usuários. Esses requisitos não funcionais normalmente especificam ou restringem as características do sistema como um todo. Eles podem estar relacionados a propriedades emergentes do sistema, como confiabilidade, tempo de resposta e uso da memória. Por outro lado, podem definir restrições à implementação do sistema, como a capacidade dos dispositivos de E/S ou as representações dos dados utilizados nas interfaces com outros sistemas.

Os requisitos não funcionais frequentemente são mais críticos do que os requisitos funcionais individuais. Os usuários do sistema normalmente encontram maneiras de contornar uma função do sistema que não satisfaça suas necessidades. <span style="background:#d4b106">No entanto, descumprir um requisito não funcional pode significar na inutilização total do sistema. </span>

### 📍 Meu exemplo:

> "Eu encontrei uma brecha no aplicativo de marcação de ponto que não atualiza o local atual, fazendo com que eu marque ponto em um local que eu não estou mais."

Isso é um **problema de requisito não funcional** relacionado a:

- 📍 **Precisão de geolocalização** (Requisito não funcional de confiabilidade)
    
- 🛰️ **Atualização em tempo real dos dados de localização** (Requisito de desempenho/atualização em tempo hábil)
    
- 🔒 **Integridade das marcações de ponto** (Requisito de segurança/confiabilidade de dados)

**E por que é tão crítico?**
Porque o sistema não garante que a marcação de ponto seja confiável, então:
- O sistema perde credibilidade;
- Pode causar problemas legais ou trabalhistas (ex: marcações inválidas);
- Pode levar à suspensão do uso por parte dos gestores/empregados.

Ou seja, mesmo que a função de marcar ponto esteja presente (requisito funcional), ela se torna inútil se os requisitos não funcionais não forem respeitados.

Por exemplo, se um sistema de aeronave não satisfazer seus requisitos de confiabilidade, este não será certificado como seguro para operação; se um sistema de controle embarcado não cumprir seus requisitos de desempenho, as funções de controle não vão funcionar corretamente.

Embora muitas vezes seja possível identificar quais componentes do sistema implementam requisitos funcionais específicos (por exemplo, pode haver componentes de formatação que implementem requisitos de relatório), isso é mais difícil com os requisitos não funcionais. Sua implementação pode estar espalhada por todo o sistema por duas *razões*:
1. Os requisitos não funcionais podem afetar a arquitetura geral de um sistema em vez de seus componentes individuais. Por exemplo, para garantir que sejam cumpridos os requisitos de desempenho em um sistema embarcado, pode ser necessário organizá-lo a fim de minimizar a comunicação entre seus componentes.
2. Um requisito não funcional individual, como um requisito de segurança da informação *security*, pode gerar vários requisitos funcionais relacionados que definem novos serviços do sistema que se fazem necessários caso o requisito não funcional seja implementado. Além disso, também pode gerar requisitos que restringem outros requisitos existentes; por exemplo, pode limitar o acesso à informação no sistema. 

Os requisitos não funcionais surgem das necessidades dos usuários, que se devem a restrições orçamentárias, políticas organizacionais, necessidade de interoperabilidade com outros sistemas de software ou hardware, ou fatores externos, como normas de segurança *safety* ou legislação relativo à privacidade. A figura 4.3 mostra uma classificação dos requisitos não funcionais. É possível ver nesse diagrama que esses requisitos podem ser provenientes  das características exigidas do software (requisitos do produto), da organização que o desenvolve (requisitos organizacionais) ou de fontes externas:

1. *Requisitos do produto:* esses requisitos especificam ou restringem o comportamento do software durante a execução. Os exemplos incluem requisitos de desempenho, relativos à rapidez com que o sistema deve executar e de quanto memória ele precisa; requisitos de confiabilidade, que estabelecem a taxa de falha aceitável; requisitos de segurança da informação; e requisitos de usabilidade.
2. *Requisitos organizacionais:* são requisitos de sistema amplos, derivados das políticas e procedimentos nas organizações do cliente e do desenvolvedor. Os exemplos incluem requisitos de processos operacionais, que definem como o sistema será utilizado; requisitos de processos de desenvolvimento ou os padrões de processo a serem utilizados; e os requisitos ambientais, que especificam o ambiente operacional do sistema. 
3. *Requisitos externos:* esse título abrangente cobre todos os requisitos derivados de fatores externos ao sistema e seu processo de desenvolvimento. Podem incluir requisitos regulatórios, que estabelecem o que deve ser feito para o sistema ser aprovado por uma entidade reguladores, como uma autoridade de segurança nuclear; requisitos legislativos, que devem ser seguidos para garantir que o sistema opere dentro da lei; e requisitos éticos, que garantem que o sistema será aceitável para os usuários e para o público em geral.

![[Capítulo 4 - Engenharia de Requisitos-2.png]]

![[Capítulo 4 - Engenharia de Requisitos-3.png]]

O requisito organizacional especifica a forma de autenticação dos usuários. A autoridade de saúde que opera o sistema está aplicando em todo o software um <span style="background:#d4b106">procedimento de autenticação</span> padrão que, em vez de ser feito através de um *login*, passa a ser feito por uma leitora que reconhece o cartão de identificação dos usuários. O requisito externo deriva da necessidade de o sistema obedecer a legislação relativa à privacidade. Esta é, obviamente, uma questão muito importante nos sistemas de saúde, e o requisito especifica que o sistema deve ser desenvolvido de acordo com um padrão nacional de privacidade.

Um problema comum com os requisitos não funcionais é que os *stakeholders* propõem esses requisitos na forma de metas gerais, como a facilidade de uso, a capacidade do sistema para se recuperar de uma falha ou a resposta rápida do usuário. As metas estabelecem boas intenções, mas causam problemas para o desenvolvedores do sistema, uma vez que abrem espaço para interpretação e subsequente conflito após o sistema ser entregue. Por exemplo, a meta do sistema a seguir é um exemplo típico de como os requisitos de usabilidade seriam solicitados por um gestor:
*O sistema deve ser fácil de usar pela equipe médica a ser organizado de tal modo que os erros de usuário sejam minimizados.*

Reescrevi isso para mostrar como a meta poderia ser expressa como um requisito não funcional testável. É impossível verificar de forma imparcial a meta do sistema, mas na descrição a seguir é possível, ao menos, incluir a instrumentação de software para contar os erros cometidos pelos usuários quando estiverem realizando um teste.
*A equipe médica deve ser capaz de utilizar todas as funções do sistema após duas horas de treinamento. Após essa etapa, a quantidade média de erros cometidos pelos usuários experientes não deve ultrapassar dois erros por hora de uso do sistema.*

Sempre que possível, os requisitos não funcionais devem ser escritos de forma quantitativa para que possam ser testados objetivamente. A figura 4.5 exibe as métricas para especificar as propriedades não funcionais do sistema. É possível mensurar essas características quando o sistema estiver sendo testado, para conferir se ele cumpriu ou não seus requisitos não funcionais.

![[Capítulo 4 - Engenharia de Requisitos-4.png]]

Na prática, os clientes de um sistema costumam achar difícil traduzir suas metas para requisitos mensuráveis. Para algumas metas, como a manutenibilidade. não há métricas simples que possam ser utilizadas. Em outros casos, quando é possível fazer uma especificação quantitativa, os clientes podem não conseguir relacionar suas necessidades com essas especificações. Eles não entendem, por exemplo, o que algum número definindo confiabilidade significa em termos de experiência cotidiana com sistemas de computador. Além disso, o custo de verificar objetivamente os requisitos não funcionais mensuráveis pode ser muito alto e os clientes que pagam pelo sistema podem achar que esses valores não são justificáveis.
Frequentemente, os requisitos não funcionais entram em conflito e interagem com outros funcionais ou não funcionais. Por exemplo, o requisito de identificação na Figura 4.4 requer que uma leitora de cartão seja instalada em cada computador conectado ao sistema. No entanto, pode haver outro requisito que exija acesso móvel ao sistema, por meio de tablets e smartphones dos médicos e profissionais de enfermagem. Esses dispositivos normalmente não são equipados com leitoras de cartão; portanto, nessas circunstâncias, pode ser necessário o suporte para algum método de identificação alternativo.
<span style="background:#d4b106">É difícil separar os requisitos funcionais dos não funcionais no documento de requisitos. </span>Se os não funcionais forem declarados separadamente dos funcionais, a relação entre eles pode ser difícil de compreender Entretanto, em condições ideais, deve-se destacar os requisitos claramente relacionados às propriedades emergentes do sistema, como desempenho ou confiabilidade. É possível fazer isso colocando-os em uma seção separada do documento de requisitos ou distinguindo-os. de alguma forma, dos demais requisitos de sistema.

Os requisitos não funcionais, como confiabilidade, segurança e confidencialidade, são particularmente importantes para os sistemas críticos. Na Parte 2, os requisitos de dependabilidade serão abordados, bem como as maneiras de especificar confiabilidade. segurança (safety) e segurança da informação (security) na forma de requisitos.

## 4.2 Processos de Engenharia de Requisitos
Conforme discutido no Capítulo 2, a engenharia de requisitos envolve três atividades fundamentais: a descoberta dos requisitos por meio da interação com *stakeholders* (elicitação e análise); a conversão desses requisitos em uma forma padrão (especificação); e a averiguação de que os requisitos realmente definem o sistema que o cliente quer (validação). O processo foi demonstrado de forma sequencial, entretanto, na prática, a engenharia de requisitos é um processo iterativo, no qual as atividades são intercaladas, como mostra a Figura 4.6.
![[Capítulo 4 - Engenharia de Requisitos-5.png]]

As atividades são organizadas como um processo iterativo em torno de uma espiral, e o resultado do processo de ER é um documento de requisitos de sistema. A quantidade de tempo e esforço dedicados a cada atividade em uma iteração depende do estágio do processo geral, do sistema a ser desenvolvido e do orçamento disponível.

No início do processo, a maior parte do esforço é dedicada à compreensão do negócio em alto nível e dos requisitos não funcionais, além dos requisitos de usuário do sistema. Em uma etapa mais avançada do processo - anéis mais externos da espiral -, mais esforço será dedicado à elicitação e à compreensão dos requisitos não funcionais e dos requisitos de sistema mais detalhados.

Esse modelo em espiral acomoda abordagens para o desenvolvimento nas quais os requisitos são desenvolvidos em diferentes níveis de detalhe. O número te iterações em torno da espiral pode variar, de modo que ela pode ser encerrada após alguns ou todos os requisitos de usuário terem sido elicitados. O desenvolvimento ágil pode ser utilizado, em vez da prototipação, para que os requisitos e a implementação do sistema sejam desenvolvidos em conjunto.

Em praticamente todos os sistemas, os requisitos mudam. As pessoas envolvidas desenvolvem uma compreensão melhor do que elas querem que o software faça; a organização que está adquirindo o sistema muda; e são feitas modificações no hardware, no software e no ambiente organizacional do sistema. As mudanças devem ser gerenciadas para entender tanto o impacto em outros requisitos quanto as implicações no sistema e o custo de realizã-las. 

## 4.3 Elicitação de Requisitos
Os objetivos do processo de elicitação de requisitos são compreender o trabalho que os *stakeholders* realizam e entender como usariam um novo sistema para apoiar o trabalho deles. Durante a elicitação de requisitos, os engenheiros de software trabalham com os *stakeholders* para saber mais sobre o domínio da aplicação, as atividades envolvidas no trabalho, os serviços e as características do sistema que eles querem, <span style="background:#affad1">o desempenho desejado para o sistema</span>, as limitações de hardware etc.
Elicitar e compreender os requisitos dos *stakeholders* no sistema é um processo difícil por várias razões:
1. Muitas vezes os *stakeholders* não sabem o que querem de um sistema de computador, exceto em aspectos mais gerais; eles podem achar difícil articular o que querem que o sistema faça; podem fazer exigências irreais porque não sabem o que é viável ou não;
2. Em um sistema, é natural que os *stakeholders* expressem os requisitos em seus próprios termos e com conhecimento implícito de seu próprio trabalho. Os **engenheiros de requisitos**, sem experiência no domínio do cliente, podem não entender tais requisitos.
3. Diferentes *stakeholders*, com requisitos distintos, podem expressá-los de maneiras variadas. Os engenheiros de requisitos têm de descobrir todas as possíveis fontes de requisitos, além dos pontos de convergência e de conflito.
4. Fatores políticos podem influenciar os requisitos de um sistema. Os gerentes podem exigir requisitos de sistema específicos, o que lhes permite aumentar sua influência na organização.
5. O ambiente econômico e de negócios no qual a análise ocorre é dinâmico. Inevitavelmente, ele muda durante o processo de análise. A importância de determinados requisitos pode mudar. Novos requisitos podem surgir de novos *stakeholders* que não foram consultados originalmente.

Um modelo do processo de elicitação e análise é exibido na Figura 4.7, abaixo. Cada organização terá sua própria versão ou instanciação desse modelo geral, dependendo de fatores locais como a experiência da equipe, o tipo de sistema sendo desenvolvido e os padrões utilizados.

![[Capítulo 4 - Engenharia de Requisitos-6.png]]
1. Descoberta e compreensão dos requisitos;
2. Classificação e organização dos requisitos;
3. Priorização e negociação dos requisitos;
4. Documentação dos requisitos.

- *Descoberta e compreensão dos requisitos:* esse é o processo de interagir com os *stakeholders* do sistema para descobrir seus requisitos. Os requisitos de domínio dos *stakeholders* e documentação também são descobertos durante essa atividade. 
- *Classificação e organização dos requisitos.* Essa atividade pega o conjunto não estruturado de requisitos, agrupa os requisitos relacionados e os organiza em grupos coerentes.
- *Priorização e negociação dos requisitos*. Inevitavelmente, quando estão envolvidos vários stakeholders, os requisitos entrarão em conflito. Essa atividade está relacionada com a priorização dos requisitos e com a descoberta e negociação para resolução de conflitos. Normalmente, os **stakeholders** devem se reunir para resolver as diferenças e chegar a um acordo sobre os requisitos. 
- *Documentação dos requisitos.* Os requisitos são documentados e servem de entrada para a próxima volta da espiral. Um rascunho inicial pode ser produzido nesse estágio ou os requisitos podem simplesmente ser mantidos de modo informal em lousas, *wikis* ou outros espaços compartilhados.

A Figura 4.7 mostra que a elicitação e análise de requisitos é um processo iterativo, com feedback contínuo de cada atividade para as demais. O ciclo do processo começa com a descoberta de requisitos e termina com a documentação dos requisitos. A compreensão do analista sobre os requisitos melhora a cada rodada do ciclo. O ciclo se encerra quando o documento de requisitos é produzido. 

Para simplificar a análise de requisitos, é útil organizar e agrupar as informações dos stakeholders. Uma maneira de fazer isso é considerar cada grupo de stakeholders como um **ponto de vista** e reunir todos os requisitos desse grupo nesse ponto de vista. Também é possível incluir pontos de vista para representar requisitos de domínio e restrições de outros sistemas. Alternativamente, pode-se utilizar um modelo da arquitetura do sistema para identificar **subsístemas** e associar requisitos a cada um deles.

Inevitavelmente, diferentes stakeholders têm preocupações distintas sobre a importância e prioridade dos requisitos, e, em alguns casos, essas percepções podem ser conflitantes. Se alguns stakeholders sentirem que suas opiniões não foram devidamente consideradas, podem tentar minar deliberadamente o processo de engenharia de requisitos. Portanto, é essencial organizar reuniões regulares entre stakeholders, garantindo que todos tenham a oportunidade de expressar suas preocupações e chegar a compromissos em relação aos requisitos.

Na etapa de documentação de requisitos, é fundamental utilizar uma linguagem simples e diagramas para descrever os requisitos. Isso facilita a compreensão por parte dos stakeholders, permitindo que comentem e façam sugestões. Para tornar o compartilhamento de informações mais eficiente, é recomendável usar um **documento compartilhado** (como no Google Docs ou Office 365) ou um wiki acessível a todos os stakeholders interessados. Dessa forma, todos podem acompanhar as atualizações e contribuir de maneira colaborativa ao longo do processo.

### 4.3.1 Técnicas de elicitação de requisitos
Requirements elicitation involves meeting with stakeholders of different kinds to discover information about the proposed system. You may supplement this information with knowledge of existing  systems and their usage and information from documents of various kinds. You need to spend time understanding how people work, what they produce, how they use other systems, and how they may need to change to accommodate a new system.

There are two fundamental approaches to requirements elicitation:
1. Interviewing, where you talk to people about what they do.
2. Observation or ethnography, where you watch people doing their job to see what artifacts they use, how they use them, and so on.

You should use a mix of interviewing and observation to collect information and, from that, your derive the requirements, which are then the basis for further discussions.

#### 4.3.1.1 Interviewing
Formal or informal interviews with system stakeholders are part of most requirements engineering processes. In these interviews, the requirements engineering team puts questions to stakeholders about the system that they currently use and the sustem to be developed. 

Na prática, as entrevistas com os *stakeholders* normalmente são uma mistura dos dois tipos. É possível obter a resposta de determinadas perguntas, mas, normalmente, elas levam a outras questões discutidas de uma maneira menos estruturada. As discussões totalmente abertas raramente funcionam bem. Em geral, deve-se fazer algumas perguntas para começar e manter a entrevista focada no sistema a ser desenvolvido.

As entrevistas são boas para obter uma compreensão global do que os *stakeholders* fazem, de como interagiriam com o novo sistema e das dificuldades que enfrentam nos sistemas atuais. As pessoas gostam de falar sobre o trabalho delas e, por isso, normalmente ficam felizes em participar de entrevistas. No entanto, a não ser que haja um protótipo do sistema para demonstrar, não se deve esperar que os *stakeholders* sugiram requisitos específicos e detalhados. Todo mundo acha difícil imaginar como um sistema poderia se parecer, portanto, é preciso analisar as informações coletadas e gerar os requisitos a partir disso.

Pode ser difícil obter conhecimento de uma certa área por meio de entrevistas, por duas razões:
1. Todos os especialistas em aplicações usam jargões específicos de sua área de trabalho. É impossível discutir os requisitos sem usar esse tipo de terminologia. Normalmente, usam palavras de maneira precisa e sutil, que os engenheiros podem entender erroneamente..
2. Certos conhecimentos da área podem ser tão familiares aos *stakeholders* que eles acham difícil explicá-los, ou podem ser tão básicos que eles pensam que não vale a pena mencioná-los. Por exemplo, para um bibliotecário, não é preciso dizer que todas as aquisições são catalogadas antes de serem acrescentadas à biblioteca. No entanto, isso pode não ser óbvio para o entrevistador e, por esse motivo, sequer ser levado em conta entre os requisitos.

As entrevistas não são uma técnica eficaz para elicitar conhecimento a respeito dos requisitos e das restrições organizacionais porque existem relações de poder sutis entre as pessoas em uma empresa. As estruturas organizacionais divulgadas raramente correspondem à realidade da tomada de decisão em uma empresa, mas os entrevistados podem não querer revelar para um estranho a estrutura real em vez da teórica. Em geral, a maioria das pessoas reluta em discutir questões políticas e organizacionais que possam afetar os requisitos.

Para uma entrevista eficaz, duas coisas devem ser levadas em conta:
1. Ter a mente aberta, evitar ideais preconcebidas a respeito dos requisitos e ter disposição de ouvir os *stakeholders*. Se ele tiver propostas de requisitos surpreendentes, então é necessário estar disposto a mudar de ideia a respeito do sistema.
2. Incentivar o entrevistado a manter a conversa fazendo uma pergunta que sirva como trampolim ou uma proposta de requisitos; ou então trabalhando juntos em um sistema protótipo. Provavelmente, falar para as pessoas "diga-me o que você quer" não vai resultar em informações úteis, pois é muito mais fácil falar em um contexto definido do que em termos gerais.

As informações das entrevistas são utilizadas junto com outras que dizem respeito ao sistema, como a documentação que descreve os processos do negócio ou dos sistemas existentes, as observações do usuário e a experiência do desenvolvedor. Às vezes, além das informações nos documentos do sistema, as informações da entrevista podem ser a única fonte de informação sobre os requisitos de sistema. Entretanto, a entrevista em si está sujeita à perda de informações essenciais e, portanto, deve ser utilizada em conjunto com outras técnicas de elicitação de requisitos.

#### 4.3.1.2 Etnografia
Os sistemas de software não existem isoladamente. Eles são utilizados em um ambiente social e organizacional e seus requisitos podem ser gerados ou restringidos por ele. Uma razão pela qual muitos sistemas de software são entregues, mas jamais utilizados, é que <span style="background:#b1ffff">seus requisitos não levam em conta como esses fatores sociais e organizacionais afetam sua operação prática</span>. Portanto, é muito importante que, <span style="background:#d4b106">durante o processo de engenharia de requisitos</span>, se tente entender os problemas que afetam o uso do sistema.

E etnografia é uma técnica de observação que pode ser utilizada para entender os processos operacionais e para ajudar a derivar os requisitos do software que apoia esses processos. <span style="background:#affad1">Um analista deve ficar imerso no ambiente de trabalho em que o sistema será utilizado com o objetivo de observar o dia a dia e tomar nota das tarefas reais nas quais os participantes estão envolvidos</span>. A vantagem da etnografia é que ela ajuda a descobrir requisitos implícitos do sistema, os quais refletem o verdadeiro modo de trabalho das pessoas, em vez dos processos formais definidos pela organização.

Frequentemente, as pessoas acham difícil articular detalhes do seu trabalho porque é tão natural para elas que não precisam mais pensar a respeito dele. Elas entendem seu próprio trabalho, mas não a relação que ele possui com outros trabalhos na organização. Fatores sociais e organizacionais que afetam o trabalho, mas que não 

Suchman (1983) foi pioneira no uso da etnografia para estudar o trabalho de escritório. Ela constatou que as práticas de trabalho reais eram muito mais ricas, complexas e dinâmicas do que os modelos simples presumidos pelos sistemas de automação.  A diferença entre o trabalho presumido e o real foi a razão mais importante para esses sistemas de escritório não produzirem um efeito significativo na produtividade. #Crabtree (2003) discute uma ampla gama de estudos desde então e descreve, em geral, o uso da etnografia no projeto de sistemas. Em minha própria pesquisa, investiguei método de integração da etnografia nos processos de engenharia de software vinculando-a com os métodos de engenharia de requisitos e padrões de documentação da interação em sistemas cooperativos.
A etnografia é particularmente eficaz <span style="background:rgba(205, 244, 105, 0.55)">para descobrir dois tipos de requisitos</span>:
1. Requisitos derivados da maneira que as pessoas realmente trabalham, e não da maneira que as definições de processos de negócio dizem que deveriam trabalhar. Na prática, as pessoas nunca seguem processos formais. Por exemplo, os controladores de tráfego aéreo podem desligar um sistema de alerta de conflitos que detecta aeronaves que estão em rotas de colisão, embora os procedimentos de controle normais especifiquem que tal sistema deva ser utilizado. O sistema de alerta de conflitos é sensível e emite alertas sonoros mesmo quando os aviões estão bem distante. Os controladores consideram que isso os distrai e preferem outras alternativas para assegurar que os aviões não sigam trajetórias de voo conflitantes.
2. Requisitos derivados da cooperação e do conhecimento das atividades das outras pessoas. Por exemplo, os controladores de tráfego aéreo podem usar o conhecimento do trabalho dos demais controladores para prever o número de aeronaves que entrarão em seu setor. Depois, eles modificam suas estratégias de controle, dependendo da carga de trabalho prevista. Portanto, um sistema de controle de tráfego aéreo automatizado deve permitir que os controladores em um setor tenham alguma visibilidade do trabalho realizado nos setores adjacentes.

A etnografia pode ser combinada com o desenvolvimento de um protótipo do sistema e informa o desenvolvimento do protótipo, de modo que sejam necessários menos ciclos de refinamento. Além disso, a prototipação permite dar foco à etnografia por identificar problemas e questões que depois poderão ser discutidas com o etnógrafo, que buscará respostas para essas perguntas durante a próxima fase de estudo do sistema.

A etnografia é útil para compreender os sistemas existentes, mas essa compreensão nem sempre ajuda na inovação. Esta é particularmente relevante para o desenvolvimento de novos produtos. Alguns analistas sugeriram que a Nokia usava etnografia para descobrir como as pessoas utilizavam seus telefones e, com base nisso, desenvolver novos modelos de telefone; a Apple, por outro lado, ignorou o uso atual e revolucionou a indústria de celular com a introdução do iPhone.

Os estudos etnográficos podem revelar detalhes críticos dos processos que muitas vezes passam despercebidos por outras técnicas de elicitação de requisitos. Entretanto, em virtude do foco no usuário final, essa abordagem não é eficaz para descobrir requisitos de empresas ou de áreas mais amplas, nem para sugerir inovações. Portanto, a etnografia é uma entre as várias técnicas de elicitação de requisitos.

### 4.3.2 Histórias e cenários
As pessoas acham mais fácil se identificar com exemplos da vida real do que com descrições abstratas. Elas não são boas para falar requisitos de sistema. No entanto, podem ser capazes de descrever como lidam com determinadas situações ou imaginar coisas que poderiam fazer com uma nova forma de trabalhar. As histórias e cenários são maneiras de capturar esse tipo de informação, que pode ser usada posteriormente ao entrevistas grupos de *stakeholders* para discutir o sistema com outros grupos e desenvolver requisitos de sistema mais específicos.

Histórias e cenários são essencialmente a mesma coisa. Trata-se de uma descrição de como o sistema pode ser utilizado em alguma tarefa em particular. Histórias e cenários descrevem o que as pessoas fazem, quais informações usam e produzem e quais sistemas podem adotar nesse processo. A diferença está no modo como as descrições são estruturadas e no nível de detalhe apresentado. As histórias são escritas como texto narrativo e apresentam uma descrição de alto nível do uso do sistema; os cenários normalmente são estruturados com informações específicas coletadas, como entradas e saídas. Considero as histórias eficazes para estabelecer o 'panorama geral'. Partes delas podem ser desenvolvidas em mais detalhes e representadas como cenários.

*Compartilhamento de imagens na sala de aula* é um exemplo de história que desenvolvi para entender o requisitos do ambiente de aprendizagem digital iLearn. Ela descreve uma situação em uma escola primária (ensino fundamental) em que o professor está usando o ambiente para apoiar os projetos dos alunos sobre a indústria pesqueira. Dá para ver que se trata de uma descrição de alto nível. Sua finalidade é facilitar a discussão sobre como o iLearn poderia ser utilizado e atuar como um ponto de partida para a elicitação dos requisitos do sistema.

*Compartilhamento de imagens na sala de aula*
Jack é um professor de escola primária em Ullapool (uma vila no norte da Escócia). Ele decidiu que um projeto de sala de aula deveria se concentrar na indústria pesqueira da região, examinando a história, o desenvolvimento e o impacto econômico da pesca. Como parte do projeto, ele pode que os alunos reúnam e compartilhem lembranças dos parentes, usem arquivos de jornais e coletem fotografias antigas relacionadas à pesca e às comunidades pesqueiras da região. Os alunos usam um *wiki* do iLearn para reunir histórias sobre pesca e o SCRAN (um site de recursos de história) para acessar os arquivos do jornal e as fotografias. No entanto, Jack também precisa de um site de compartilhamento de imagens, pois quer que os alunos troquem e comentem as fotos uns dos outros e coloquem no site as imagens escaneadas de fotografias antigas que possam ter em suas famílias.

Jack envia um e-mail para um grupo de professores de escola primária, do qual é membro, para ver se alguém pode recomendar um sistema adequado. Dois professores respondem e ambos sugerem que ele use o KidsTakePics, um site de compartilhamento de imagens que permite aos professores conferirem e moderarem o conteúdo. Como o KidsTakePics não é integrado ao serviço de autenticação do iLearn, ele cria uma conta de professor e uma conta de turma. Ele utiliza o serviço de configuração do iLearn para adicionar o KidsTakePics aos serviços visualizados pelos alunos em sua turma para que, quando fizerem o login, possam usar imediatamente o sistema para enviar fotos de seus celulares, tablets e computadores da sala de aula.

A vantagem das histórias é que todo mundo pode ser identificar facilmente com elas. Achamos que essa abordagem é especialmente útil para obter informações de uma comunidade mais ampla do que poderíamos entrevistar na realidade. Disponibilizamos as histórias em um wiki e convidamos professores e alunos dos país inteiro para comentá-las.

Essas histórias de mais alto nível não entram em detalhes sobre um sistema, mas podem ser desenvolvidas em cenários mais específicos. Os cenários são descrições de exemplos de sessões de interação do usuário. Acredito que seja melhor apresentar os cenários de uma maneira estruturada, em vez de um texto narrativo. As histórias de usuários nos métodos ágeis, como na Programação Externa, são cenários narrativos e não histórias genéricas para ajudar a elicitar requisitos.
Um cenário começa com uma descrição da interação. Durante o processo de elicitação, são acrescentados detalhes para criar uma descrição completa dessa interação. De modo geral, um cenário pode incluir:
1. uma descrição do que o sistema e os usuários esperam quando o cenário se inicia;
2. uma descrição do fluxo normal dos eventos no cenário;
3. uma descrição do que pode dar errado e de como esses problemas podem
ser enfrentados;
4. informações sobre outras atividades que poderíam ocorrer ao mesmo tempo;
5. uma descrição do estado do sistema quando o cenário termina.

Como exemplo de um cenário, o texto abaixo descreve o que acontece quando um aluno envia fotos para o sistema KidsTakePics. A diferença fundamental estre esse e outros sistemas é que o professor modera as fotos enviadas para conferir se são adequadas ao compartilhamento. 

Nota-se que essa é uma descrição muito mais detalhada do que a da história relatada na Figura 4.9 e, portanto, pode ser utilizada para propor requisitos do sistema iLearn. Assim como as histórias, os cenários podem ser empregados para facilitar discussões com os stakeholders, que às vezes podem ter maneiras diferentes de atingir o mesmo resultado.

📸 Enviar fotos para o KidsTakePics

🧩 Pressuposto inicial
Um usuário ou grupo de usuários possui uma ou mais fotografias digitais armazenadas em um **tablet** ou **notebook**. Eles realizaram login no site **KidsTakePics**.

✅ Fluxo normal
- O usuário opta por enviar fotos.
- O sistema solicita:
  - Seleção das fotos no computador.
  - Escolha do nome do **projeto** onde as fotos serão armazenadas.
  - Digitação de **palavras-chave** associadas a cada foto.
- As fotos recebem um nome automático criado pela junção:
  - Nome do usuário + nome do arquivo original.
- Após o envio:
  - Um e-mail automático é enviado ao **moderador do projeto**.
  - Uma mensagem é exibida ao usuário informando que a verificação foi iniciada.

 ⚠️ O que pode dar errado

🔸 Projeto sem moderador
- Caso nenhum moderador esteja associado ao projeto:
  - Um e-mail é enviado ao **administrador da escola** solicitando a nomeação de um moderador.
  - O usuário é informado sobre possível **atraso na visibilidade** das fotos.

🔸 Conflito de nomes
- Se fotos com o mesmo nome já foram enviadas pelo mesmo usuário:
  - O sistema pergunta se o usuário deseja:
    - **Reenviar (sobrescrever)** as fotos.
    - **Renomear automaticamente** (acrescentando um número).
    - **Cancelar o envio**.

🔄 Outras atividades
- O moderador pode estar logado e **aprovar fotos** conforme são enviadas.

🏁 Estado final do sistema
- O usuário permanece **logado**.
- As fotos foram enviadas e receberam o status:
  - `'aguardando moderação'`
- As fotos estão visíveis para:
  - O **moderador**
  - O **usuário que as enviou**

## 4.4 Especificação de requisitos
A especificação de requisitos é o processo de escrever os requisitos de usuário e de sistema em um documento de requisitos. Em condições ideais, esses requisitos devem ser claros, inequívocos, fáceis de entender, completos e consistentes. Na prática, isso é quase impossível de alcançar. Os #stakeholders interpretam os requisitos de maneiras diferentes e muitas vezes há conflitos e incoerências inerentes a eles.

Os requisitos de usuário quase sempre são escritos em linguagem natural, complementada por diagramas e tabelas apropriadas no documento de requisitos. Os requisitos de sistemas também podem ser escritos em linguagem natural, mas outras notações baseadas em formulários, gráficos ou modelos matemáticos do sistema também podem ser utilizadas. A Figura 4.11 resume as possíveis notações para escrever requisitos de sistema.

**Notações para escrever requisitos de sistema**
**Sentença em linguagem natural** - os requisitos são escritos usando frases numeradas em linguagem natural. Cada frase deve expressar um requisito.
**Linguagem natural estruturada** - os requisitos são escritos em linguagem natural em um formulário ou *template*. Cada campo fornece informações sobre um aspecto do requisito.
**Notações gráficas**: Modelos gráficos, suplementados por anotações em texto, são utilizados para definir os requisitos funcionais do sistema. São utilizados com frequência os diagramas de casos de uso e de sequência da UML.
**Especificações matemáticas** - Essas notações se baseiam em conceitos matemáticos como as máquinas de estados finitos ou conjuntos. Embora essas especificações inequívocas possam reduzir a ambiguidade em um documento de requisitos, a maioria dos clientes não compreende uma especificação formal. Eles não conseguem averiguar se ela representa o que desejam e relutam em aceitar essa especificação como um contrato do sistema.


Os requisitos de usuário de um sistema devem descrever os requisitos funcionais e não funcionais de modo que sejam compreensíveis para os usuários do sistema que não têm conhecimento técnico detalhado. Em condições ideias, eles devem especificar apenas o comportamento externo do sistema. O documento de requisitos não deve incluir detalhes da arquitetura ou do projeto *design* do sistema. Consequentemente, ao escrever requisitos de usuário, não se deve usar jargões de software, notações estruturadas ou notações formais. Os requisitos de usuário devem ser escritos em linguagem natural, com tabelas simples, formulários e diagramas intuitivos.

Os requisitos de sistema são versões ampliadas dos requisitos de usuário, que os engenheiros de software usam como ponto de partida para o projeto do sistema, acrescentando detalhes e explicando como o sistema deverá atender os requisitos de usuário. Eles podem ser utilizados como parte do contrato para a implementação do sistema, portanto devem ser uma especificação completa e detalhada do sistema inteiro. 

Em condições ideais, os requisitos de sistema devem descrever apenas o comportamento externo do sistema e suas restrições operacionais. Eles não devem se preocupar com o modo que o sistema deve ser projetado ou implementado. No entanto, no nível de detalhe exigido para especificar completamente um sistema de software complexo, não é possível nem desejável excluir todas as informações de projeto *design*. Existem várias razões para isso:
1. Pode ser necessário fazer o projeto de uma arquitetura inicial do sistema para ajudar a estruturar a especificação dos requisitos. Os requisitos de sistema são organizados de acordo com diferentes subsistemas que o compõem. Fizemos isso quando definimos os requisitos do sistema iLearn, no qual propusemos a arquitetura exibida na Figura 1.8.
2. Na maioria dos casos, os sistemas devem interoperar com os sistemas existentes, o que restringe o projeto e impõe requisitos ao novo sistema.
3. Pode ser necessário o uso de uma arquitetura específica para satisfazer requisitos não funcionais, como a programação N-versões, discutida no Capítulo 11, para alcançar confiabilidade. Um regulador externo que precise certificar-se de que o sistema é segura *safe* pode especificar que deve ser utilizado um projeto de arquitetura já certificado.

### 4.4.1 Especificação em linguagem natural
A linguagem natural tem sido utilizado para descrever requisitos de software desde os anos 1950. É uma linguagem expressiva, intuitiva e universal. Também é potencialmente vaga e ambígua, sendo que a sua interpretação depende da experiência do leitor. Consequentemente, tem havido muitas propostas de maneiras alternativas para escrever os requisitos. No entanto, nenhuma dessas propostas foi adotada amplamente, e a linguagem natural continuará sendo a maneira mais utilizada de especificar requisitos de sistema e software.
Para minimizar os mal-entendido ao escrever requisitos em linguagem natural, recomendo seguir estas diretrizes simples:
1. Inventar um formato padrão e garantir que todas as definições de requisitos o sigam. Padronizar o formato diminui a probabilidade de omissões e torna os requisitos mais fáceis de serem conferidos. Sempre que for possível, sugiro escrever o requisito em uma ou duas frases de linguagem natural.
2. Usar a linguagem coerentemente para distinguir entre requisitos obrigatórios e desejáveis. Os requisitos obrigatórios são aqueles que o sistema deve apoiar, e normalmente são escritos usando 'deve'. Os requisitos desejáveis não são essenciais, e são escritos usando 'pode'.
3. Um realce de texto (negrito, itálico ou cor) para destacar partes importantes do requisito.
4. Não supor que os leitores compreendem a linguagem técnicas da engenharia de software. É fácil que palavras como 'arquitetura' e 'módulo' sejam mal compreendidas. Sempre que possível, evitar o uso de jargões, abreviações e acrônimos.
5. Sempre que possível, tentar associar um racional a cada requisito de usuário. O racional deve explicar por que o requisito foi incluído e quem o propôs (a origem do requisito), de modo que se saiba a quem recorrer se o requisito precisar ser alterado. O racional dos requisitos é particularmente útil quando isso acontece, já que essa mudança pode ajudar a decidir quais alterações seriam indesejáveis.

A figura 4.12 ilustra como essas diretrizes podem ser utilizadas. Ela inclui dois requisitos para software embarcado na bomba de insulina automatizada, introduzida no Capítulo 1. Outros requisitos desse sistema embarcado são definidos no documento de requisitos da bomba de insulina, que pode ser baixado no site do livro (em inglês).

**Exemplos de requisitos do sistema de software da bomba de insluina**
3.2. O sistema deve medir o nível de açúcar no sangue e fornecer insulina, se for necessário, a cada 10 minutos. (As variações do açúcar no sangue são relativamente lentas, então é desnecessário medir com uma frequência maior; a medição menos frequente poderia levar a níveis de açúcar sanguíneo desnecessariamente elevados).
3.6. O sistema deve executar uma rotina de autoteste a cada minuto com as condições a serem testadas e as ações associadas, definidas na Tabela 1 do documento de requisitos. (Uma rotina de autoteste pode descobrir problemas de hardware e alertar o usuário de que a operação normal pode ser impossível).

### 4.4.2 Especificações estruturadas
A linguagem natural estruturada é uma maneira de escrever os requisitos  de sistema, de modo que estes sejam escritos em uma forma padrão em vez de em texto livre. Essa abordagem mantém a maior parte da expressividade e da clareza da linguagem natural, mas garante que alguma uniformidade seja imposta à especificação. As notações que adotam linguagem estruturada usam modelos para especificar requisitos de sistema. Essa especificação pode usar construtos de linguagem de programação para mostrar alternativas e iteração, podendo destacar elementos-chave por intermédio de sombreamento ou de fontes diferentes. Os Robertsons, em seu livro sobre o método VOLERE de engenharia de requisitos, recomendam que os requisitos de usuário sejam escritos inicialmente em cartões, com um requisito por cartão. Eles sugerem uma série de campos em cada cartão, como o racional dos requisitos, as dependências de outros requisitos, a origem dos requisitos e os materiais de apoio. Isso é similar à abordagem utilizada no exemplo de uma especificação estruturada, exibido na Figura 4.13.

**Problemas com o uso da linguagem natural na especificação dos requisitos**
A flexibilidade da linguagem natural, tão útil para a especificação, costuma causar problemas. Existe espaço para escrever requisitos obscuros e os leitores (os projetistas) podem interpretar erroneamente os requisitos porque eles e os usuários têm experiências diferentes. É fácil fundir vários requisitos em uma única frase, o que pode dificultar a estruturação dos requisitos em linguagem natural.

## Bomba de Insulina / Software de Controle / SRS / 3.3.2

| Campo              | Detalhes                                                                                                                                         |
|-------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| **Função**         | Computar a dose de insulina: nível de açúcar segura                                                                                              |
| **Descrição**      | Computa a dose de insulina a ser fornecida quando o nível de açúcar estiver entre 3 e 7 unidades (zona segura).                                 |
| **Entradas**       | Leitura atual do açúcar (`r2`) e duas leituras prévias (`r0` e `r1`).                                                                            |
| **Fonte**          | Sensor de leitura atual de açúcar e memória para leituras anteriores.                                                                            |
| **Saídas**         | `DoseComp` – dose de insulina a ser fornecida.                                                                                                   |
| **Destino**        | Laço de controle principal.                                                                                                                      |
| **Ação**           | - `DoseComp = 0` se o nível estiver estável ou caindo. <br> - Se o nível estiver subindo, mas com desaceleração: `DoseComp = 0`. <br> - Se o nível e a taxa de crescimento estiverem aumentando: `DoseComp = arred( (r2 - r1) / 4 )`. <br> - Se o resultado arredondado for 0: `DoseComp = dose mínima permitida` (ver Figura 4.14). |
| **Requer**         | Leituras `r0` e `r1` para cálculo da taxa de variação do nível de açúcar.                                                                        |
| **Pré-condição**   | O reservatório de insulina contém pelo menos a dose máxima permitida.                                                                            |
| **Pós-condição**   | `r0 ← r1`, depois `r1 ← r2`.                                                                                                                     |
| **Efeitos colaterais** | Nenhum.                                                                                                                                      |

Para usar uma abordagem estruturada para especificar requisitos de sistema, é preciso definir um ou mais *templates* para os requisitos e representá-los como formulários estruturados. A especificação pode ser estruturada em volta dos objetos manipulados pelo sistema, das funções realizadas por ele ou dos eventos processados. Um exemplo de especificação baseada em formulário, nesse caso, é o que define como calcular a dose de insular a ser fornecida quando o açúcar no sangue estiver dentro da faixa segura.

Quando um *template* é empregado para especificar requisitos funcionais, as seguintes informações devem ser incluídas:
1. uma descrição da função ou entidade que está sendo especificada;
2. uma descrição das entradas e suas origens;
3. uma descrição das saídas e sua destinação;
4. informações sobre os dados necessários para computar ou outras entidades no sistema que sejam necessárias (a parte 'requer');
5. uma descrição da ação a ser tomada;
6. se for utilizada uma abordagem funcional, uma precondição estabelecendo o que deve ser verdadeiro antes da função ser invocada e uma pós-condição especificando o que deve ser verdadeiro antes da função ser invocada e uma pós-condição especificando o que é verdadeiro após a função ser invocada.
7. uma descrição dos efeitos colaterais (se houver) da operação.


O uso de especificações estruturadas remove alguns dos problemas da especificação em linguagem natural. A variabilidade na especificação é reduzida, e os requisitos são organizados com mais eficácia. No entanto, às vezes é difícil escrever os requisitos de uma maneira clara e inequívoca, particularmente quando computações complexas (como calcular a dose da insulina) devem ser especificadas.

Para resolver esse problema, é possível acrescentar mais informações aos requisitos em linguagem natural, por exemplo, usando tabelas ou modelos gráficos do sistema. Esses recursos podem mostrar como os cálculos são feitos, como o estado do sistema muda, como os usuários interagem com o sistema e como as sequências de ações são realizadas.

### 4.4.3 Casos de uso
Os casos de uso são uma maneira de descrever as interações entre usuários e um sistema usando um modelo gráfico e um texto estruturado. Foram introduzidos pela primeira vez no método #Objectory e hoje se tornaram uma característica fundamental da UML. Em sua forma mais simples, um caso de uso identifica os atores envolvidos em uma interação e nomeia o tipo de interação. Depois, são adicionadas informações descrevendo a interação com o sistema, que pode ser uma descrição textual ou um ou mais modelos gráficos, como os diagramas de sequência ou de máquina de estados da UML.

Os casos de uso são documentados por meio de um diagrama de casos de uso de alto nível. O conjunto de casos de uso representa todas as interações possíveis que serão descritas nos requisitos de sistema. Os atores n processo, que podem ser seres humanos ou outros sistemas, são representados como 'bonecos palito'. Cada classe de interação é representada como uma elipse nomeada. Linhas fazem a ligação entre os atores e a interação. Opcionalmente, pontas da seta podem ser acrescentadas às linhas para mostrar como a interação começa. Isso é ilustrado pela Figura 4.15, que mostra alguns dos casos de uso do sistema Mentcare.
![[Capítulo 4 - Engenharia de Requisitos-7.png]]

Os casos de uso identificam cada interação entre o sistema e seus usuários ou outros sistemas. Cada caso de uso deve ser documentado com uma descriçao textual, que pode ser ligada a outros modelos, também em UML - para compor um cenários mais detalhado. Por exemplo, uma descrição resumida do uso de caso de Realizar discussão de caso da Figura 4.15 poderia ser:
*Realizar discussão de caso permite que dois ou mais médicos, trabalhando em consultórios diferentes, vejam o registro do mesmo paciente ao mesmo tempo. Um médico inicia a discussão do caso de um paciente escolhendo as pessoas envolvidas em um menu suspenso de médicos que estão on-line. O registro do paciente é exibido em suas telas, mas apenas o médico que iniciou a consulta pode editar o registro. Além disso, cria-se um chat para ajudar a coordenar as açoes. Presume-se que uma chamada telefõnica ou comunicação por voz possa ser providenciada separadamente*.

A UML é um padrão para modelagem orientada a objetos, então os casos de uso
e a elicitação de requisitos baseada em casos de uso são utilizadas no processo de
engenharia de requisitos. No entanto, minha experiência com os casos de uso é que
eles são muito refinados para serem úteis na discussão de requisitos. Os stakeholders
não compreendem o termo caso de uso, não acham útil o modelo gráfico e. muitas
vezes, não estão interessados em uma descrição detalhada de cada interação do
sistema. Consequentemente, acho os casos de uso mais úteis no projeto de sistemas
do que na engenharia de requisitos. Discutirei melhor esse assunto no Capitulo 5, que
mostra como os casos de uso são utilizados com outros modelos de sistema para
documentar um projeto (design).

Algumas pessoas acham que cada caso de uso é um cenário de interação único e
detalhado. Outras, como Stevens e Pooley (2006), sugerem que cada caso inclui um
conjunto relacionado de cenários detalhados. Cada um deles é um único caminho do
caso de uso. Portanto, haveria um cenário para a interação normal, além de cenários
para cada exceção possível. Na prática, dá para usá-los de ambas as formas.

### 4.4.4 O documento de requisitos de software
O documento de requisitos de software (às vezes chamado de especificação de requisitos de software ou ERS) é uma declaração oficial do que os desenvolvedores do sistema devem implementar. Ele pode incluir os requisitos de usuário para um sistema e uma especificação detalhada dos requisitos de sistema. Às vezes, os requisitos de usuário e de sistema são integrados em uma descrição única. Em outros casos, os requisitos de usuário são descritos em um capítulo introdutório na especificação de requisitos de sistema.

Os documentos de requisitos são essenciais quando: os sistemas têm o seu desenvolvimento terceirizado, times diferentes desenvolvem partes diferentes do sistema ou uma análise detalhada dos requisitos é obrigatória. Em outras circunstâncias, como o desenvolvimento de um produto de software ou de um sistema de negócio, um documento de requisitos detalhado pode não ser necessário.

Os métodos ágeis argumentam que os requisitos mudam com tanta rapidez que um documento de requisitos fica obsoleto logo que é escrito, então o esforço é quase todo desperdiçado. Em vez de um documento formal, as abordagens ágeis costumam coletar os requisitos de usuário de modo incremental e escrevê-los em cartões ou lousas na forma de pequenas histórias de usuário. Então, o usuário priorizará essas histórias para implementação nos incrementos seguintes do sistema.

Nos sistemas de negócio nos quais os requisitos são instáveis, creio que essa abordagem é boa. No entanto, ainda acredito que seja útil escrever um documento de suporte resumido que defina o negócio e os requisitos de dependabilidade do sistema; é fácil esquecer os requisitos que se aplicam ao sistema como um todo quando nos concentramos nos requisitos funcionais da próxima versão do sistema.

O documento de requisitos tem um conjunto de usuários diversos, variando da alta gerência da organização que está pagando pelo sistema até os engenheiros responsáveis por desenvolver o software. A Faigura 4.16 mostra os possíveis usuários do documento e como eles o utilizam:

**Usuários de um document de requisitos**
**Clientes do sistema**: Especificam os requisitos e os leem para conferir se satisfazem suas necessidades. Os clientes especificam mudanças nos requisitos.

**Gerentes**: usam o documento de requisitos para planejar uma proposta para o sistema e planejar o seu processo de desenvolvimento.

**Engenheiros de sistema**: usam os requisitos para compreender qual sistema deve ser desenvolvido.

**Engenheiros de teste do sistema**: usam os requisitos para desenvolver testes de validação do sistema.

**Engenheiros de manutenção do sistema**: usam os requisitos para entender o sistema e as relações entre suas partes.

O nível de detalhe que deve ser incluído em um documento de requisitos depende do tipo de sistema que está sendo desenvolvido e do processo de desenvolvimento utilizado. Os sistemas críticos precisam de requisitos detalhados porque a segurança *safety* e a segurança  da informação (*security*) devem de ser analisadas em detalhes, a fim de encontrar possíveis erros nos requisitos. Quando o sistema é desenvolvido por uma empresa diferente (por meio de terceirização, por exemplo), as especificações do sistema precisam ser detalhadas e precisas. Se o desenvolvimento for interno, usando um processo de desenvolvimento interativo, o documento de requisitos pode ser menos detalhado. Podem ser acrescentados detalhes aos requisitos e as ambiguidades resolvidas durante o desenvolvimento do sistema.

A Figura 4.17 mostra uma possível organização do documento de requisitos baseada em um padrão do IEEE para esse tipo de documento. Esse padrão é genérico e pode ser adaptado a usos específicos. Nesse caso, o padrão precisa ser ampliado para incluir informações sobre a evolução prevista para o sistema, pois elas ajudam os responsáveis pela manutenção do sistema e permitem que os projetistas incluam suporte para futuras características do sistema.

## 4.5 Validação de Requisitos
A validação 