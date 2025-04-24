**Objetivos**
Os objetivos deste capítulo são introduzir **requisitos de software** e explicar o processo envolvido na descoberta e na documentação desses requisitos. Ao ler este capítulo, seremos capazes de:
- compreender os conceitos de **requisitos de usuário** e **requisitos de sistema** e por que eles devem ser escritos de maneira diferentes;
- compreender as diferenças entre requisitos de software funcionais e não funcionais;
- compreender as principais atividades da engenharia de requisitos: elicitação, análise e validação, e as relações entre elas;
- compreender por que o gerenciamento de requisitos é necessário e como ele apoia outras atividades da engenharia de requisitos.

**Conteúdo**
- 4.1 Requisitos funcionais e não funcionais;
- 4.2 Processos de engenharia de requisitos;
- 4.3 Elicitação de requisitos;
- 4.4 Especificação de requisitos;
- 4.5 Validação de requisitos;
- 4.6 Mudança de requisitos.

---
Os requisitos de um sistema são as descrições dos serviços que o sistema deve prestar e as restrições a sua operação. Esses requisitos <span style="background:#b1ffff">refletem as necessidades dos clientes de um sistema</span> que atende a um determinado propósito, como controlar um dispositivo, fazer um pedido ou encontrar informações. O processo de descoberta, análise, documentação e conferência desses serviços e restrições é chamado de engenharia de requisitos ER.

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
Conforme discutido no Capítulo 2, a engenharia de requisitos envolve três atividades fundamentais: a descoberta dos requisitos por meio da interação com *stakeholders* (elicitação e análise); 

