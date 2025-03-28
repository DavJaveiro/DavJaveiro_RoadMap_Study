**Objetivos**
O objetivo deste capítulo é introduzir o conceito de processo de software, um conjunto coerente de atividades para produção de software. Ao ler este capítulo, aprenderemos:
- *Conceitos e os modelos de processo de software;*
- *seremos apresentados a três modelos genéricos de processo de software e às situações nas quais eles podem ser utilizados*;
- *Conheceremos as atividades de processo fundamentais da engenharia de requisitos, do desenvolvimento, dos testes e da evolução de software;*
- *compreenderemos que os processos devem ser organizados para lidar com as mudanças nos requisitos e no projeto do software;*
- *compreenderemos o conceito de melhoria do processo de software e os fatores que afetam a qualidade do processo*.

**Conteúdo**
2.1 Modelos de processo de software;
2.2 Atividades do processo;
2.3 Lidando com mudanças;
2.4 Melhoria de processo.

---
Um processo de software é um conjunto de atividades relacionadas que levam à <span style="background:#affad1">produção de um sistema de software</span>. Conforme discutimos no Capítulo 1, existem muitos tipos diferentes de sistemas de software e <span style="background:#d4b106">não há um método universal de engenharia de software</span> que seja aplicável a todos eles. Consequentemente, não existem processos de software universalmente aplicáveis. O processo utilizado nas diferentes empresas depende do tipo de software que está sendo desenvolvido, dos requisitos do cliente e das habilidades das pessoas que o desenvolvem.

No entanto, embora <span style="background:#d4b106">existam muitos processos de software diferentes</span>, todos eles devem incluir, de alguma forma, as quatro atividades fundamentais da engenharia de software:
1. *Especificação:* a funcionalidade do software e as restrições sobre sua operação devem ser definidas;
2. *Desenvolvimento:* o software deve produzir para atender à especificação;
3. *Validação:* o software deve ser validado para garantir que atenda ao que o cliente deseja;
4. *Evolução:* o software deve evoluir para atender às mudanças nas necessidades dos clientes.

Essas atividades são complexas por si só e incluem subatividades como validação de requisitos, projeto de arquitetura e teste de unidade. Os processos incluem, ainda, atividades como gerenciamento de configuração do software e planejamento de projeto, que também apoiam as atividades de produção.

Quando descrevemos e discutimos os processos, normalmente falamos sobre as atividades nesses processos, especificar um modelo de dados e projetar uma interface com o usuário, por exemplo, e sobre a sequência correta dessas atividades. Todos nós podemos identificar o que as pessoas fazem para desenvolver um software, mas, quando se trata de processos de software, é importante descrever também quem está envolvido, o que está sendo produzido e quais condições influenciam a sequência dessas atividades:
1. Uma atividade de processo resulta em **produtos** ou em **entregas**. Por exemplo, o resultado da atividade de projeto da arquitetura pode ser um modelo da arquitetura do software. 
2. Os papéis refletem as responsabilidades das pessoas envolvidas no processo. Entre os exemplos de papéis, temos os do gerente de projeto, do gerente de configuração e do programador.
3. Há condições que devem ser mantidas antes ou depois de uma atividade do processo ter sido aprovada ou um produto ter sido produzido. Antes de começar o projeto da arquitetura, por exemplo, uma precondição poderia ser a de que o consumidor tenha aprovado todos os requisitos, depois que essa atividade for concluída, uma pós-condição poderia ser a de que os modelos em UML descrevendo a arquitetura fossem revisados.

Os processos de software são complexos e, como processos intelectuais e criativos, dependem da tomada de decisão e do julgamento das pessoas. Uma vez que não existe um processo universal que valha para todos os tipos de software, a maioria das empresas produtoras de software concebeu seus próprios processos de desenvolvimento. Estes evoluíram e passaram a aproveitar a capacidade dos desenvolvedores de software em uma organização e as características dos sistemas que estão sendo desenvolvidos. No caso dos sistemas críticos de em segurança, é necessário um processo de desenvolvimento estruturado e que registros detalhados sejam mantidos. Nos sistemas de negócio, com requisitos que mudam rapidamente, talvez seja melhor adotar um processo mais flexível e ágil.

Conforme discutimos no Capítulo 1, o desenvolvimento de software profissional é uma atividade gerenciada, logo, o planejamento é parte inerente a todos os processos. Os processos dirigidos por planos são aqueles em que todas as atividades são planejadas antecipadamente e progridem em relação ao que foi planejado. Nos processos ágeis, que discutimos no Capítulo 3, o planejamento é incremental e contínuo à medida que o software é desenvolvido. Portanto, nesses casos, é mais fácil mudar o processo para refletir a mudança dos requisitos do que cliente ou do produto. Conforme explicam Boehm e Turner (2004), cada abordagem é adequada para diferentes tipos de software. <span style="background:#d4b106">Geralmente, nos sistemas grandes, é preciso encontrar um equilíbrio entre os processos dirigidos por planos e os processos ágeis. </span>

Embora não haja um processo de software universal, há espaço para a melhoria dos processos em muitas organizações. Os processos podem incluir técnicas ultrapassadas ou não tirar proveito da prática mais recomendada na engenharia de software industrial. Na realidade, durante seus processos de desenvolvimento, muitas organizações ainda não se valem dos métodos de engenharia de software. <span style="background:#b1ffff">Elas podem melhorar seus processos introduzindo técnicas</span> como a *modelagem com UML* e o *desenvolvimento dirigido por testes*. Discutirei brevemente a melhoria dos processos de software mais adiante neste capítulo, e mais detalhadamente no Capítulo 26.

## 2.1 Modelos de Processo de Software
Como explicado no Capítulo 1, um modelo de processo de software - às vezes chamado de ciclo de vida do desenvolvimento de software (ou modelo SLDC, do inglês *Software Development Life Cycle*) - é uma representação simplificada de um processo de software. Cada modelo representa um processo a partir de uma perspectiva particular e, desse modo, fornece apenas informações parciais sobre esse processo. Por exemplo, <span style="background:#d4b106">um modelo de atividades do processo mostra as atividades e sua sequência</span>, mas não os papéis das pessoas envolvidas nelas. Nesta  seção, apresento uma série de modelos de processo bem genéricos (às vezes chamados de *paradigmas de processo*) partindo de uma perspectiva arquitetural, ou seja, vemos a estrutura do processo, mas não os detalhes de suas atividades.

Esses modelos genéricos são descrições mais gerais e abstratas do processo de software, e podem ser utilizados para explicar as diferentes abordagens ao desenvolvimento de software. Podemos encará-los como estruturas de processo que podem ser ampliadas e adaptadas para criar processos de engenharia de software mais específicos. 

Os modelos de processo genéricos apresentados aqui são:
1. *Modelo em cascata:* representa as atividades fundamentais do processo, como especificação, desenvolvimento, validação e evolução, na forma de fases de processo distintas, como especificação de requisitos, projeto de software, implementação e testes.
2. *Desenvolvimento incremental.* Intercala as atividades de especificação, desenvolvimento e validação. O sistema é desenvolvido como uma série de versões (incrementos), com cada uma delas acrescentando funcionalidade à versão anterior. 
3. *Integração e configuração:* baseia-se na disponibilidade de componentes ou sistemas reusáveis. O processo de desenvolvimento de sistemas se concentra na configuração desses componentes, para que sejam utilizados em um novo contexto, e na integração deles em um sistema.

Não existe modelo de processo universal aplicável a todos os tipos de desenvolvimento de software. O processo correto depende do cliente e dos requisitos que regulam o software, do ambiente em que esse software será utilizado e do tipo de software que está sendo desenvolvido. Os sistemas críticos em segurança , <span style="background:#d4b106">por exemplo, são normalmente desenvolvidos a partir de um processo em cascata</span>, <span style="background:#b1ffff">já que é necessária uma grande quantidade de análise e de documentação antes de começar sua implementação</span>. Por sua vez, os produtos de software são, atualmente, desenvolvidos a partir de um modelo de processo incremental. Os sistemas de negócio são desenvolvidos, cada vez mais, por meio da configuração dos sistemas preexistentes e da integração entre eles, a fim de criar um novo sistema com a funcionalidade exigida.

Na prática, a maior parte dos processos de software se baseia em um modelo genérico, mas frequentemente incorpora características de outros modelos. 

Isso vale particularmente para a engenharia dos grandes sistemas. Neles, faz sentido combinar algumas das melhores características de todos os processos genéricos. É preciso ter informações sobre os requisitos de sistema essenciais para projetar uma arquitetura de software que apoie esses requisitos, e não dá para desenvolver isso de modo incremental. Os subsistemas dentro de um sistema maior podem ser desenvolvidos por meio de abordagens diferentes. Partes do sistema que sejam bem compreendidas podem ser especificadas e desenvolvidas usando um processo em cascata ou podem ser adquiridas como sistemas de prateleira para configuração. Outras partes do sistema, difíceis de especificar antecipadamente, devem ser sempre desenvolvidas a partir de uma abordagem incremental. Em ambos os casos, os componentes de software provavelmente serão reusados.

Várias tentativas têm sido feitas para desenvolver modelos de processo *universais* baseados em todos esses modelos genéricos. Um dos mais conhecidos é o *Rational Unified Process RUP*, que foi desenvolvido pela Rational, uma empresa de engenharia de software norte-americana. O RUP é um modelo flexível, que pode ser instanciado de diferentes maneiras para criar processos que se assemelhem a qualquer um dos modelos de processo genéricos discutidos aqui. O RUP foi adotado por algumas grandes empresas de software (principalmente pela IBM), mas não conquistou uma ampla aceitaçao.

### 2.1.1 O modelo em cascata
O primeiro modelo de processo de desenvolvimento de software a ser publicado é derivado dos modelos utilizados na engenharia de grandes sistemas militares. Ele apresenta o processo de desenvolvimento de software como uma série de estágios, conforme a Figura 2.1. Devido à cascata de uma fase para outra, esse modelo é conhecido como modelo em cascata ou ciclo de vida do software. O modelo em cascata é um exemplo de processo dirigido por plano. <span style="background:#d4b106">A princípio, pelo menos, é necessário planejar e criar um cronograma de todas as atividades de processo antes de começar o desenvolvimento do software</span>. (Completamente engessado).

![[Capítulo 2 - Processos de Software.png]]

Os estágios do modelo em cascata refletem diretamente as atividades fundamentais do desenvolvimento de software:
1. *Análise e definição dos requisitos:* os serviços, as restrições e as metas do sistema são estabelecidos por meio de <span style="background:#d4b106">consultas aos usuários</span>. Depois, eles são definidos em detalhes e servem como uma especificação do sistema.
2. *Projeto do sistema e do software:* o processo de projeto do sistema reparte os requisitos entre requisitos de sistema  de hardware e de software, e estabelece uma arquitetura global do sistema. O projeto de software envolve a identificação e a descrição das abstrações fundamentais do sistema de software e seus relacionamentos. 
3. *Implementação e teste de unidade:* durante essa etapa, o projeto do software é realizado como um conjunto de programas ou unidades de programa. O teste de unidade envolve a verificação de cada unidade, conferindo se satisfazem a sua especificação.
4. *Integração e teste de sistema*. As unidades de programa ou os programas são integrados e testados como um sistema completo a fim de garantir que os requisitos de software tenham sido cumpridos. Após os testes, o sistema de software é entregue ao cliente.
5. *Operação e manutenção*: Normalmente, essa é a fase mais longa do ciclo de vida. O sistema é instalado e colocado em uso. A manutenção envolve corrigir os erros que não foram descobertos nas primeiras fases do ciclo de vida, melhorar a implementação das unidades do sistema e aperfeiçoar os serviços do sistema à medida que novos requisitos são descobertos.

A princípio, o resultado de cada fase no modelo em cascata consiste em um ou mais documentos que são aprovados. <span style="background:#d4b106">A fase seguinte não deve começar até que a fase anterior tenha terminado</span>. No desenvolvimento de hardware, que envolve altos custos de produção, isso faz sentido. No entanto, no desenvolvimento de software, esses estágios se sobrepõem e alimentam uns aos outros com informações. Durante o projeto *design*, são identificados problemas com os requisitos; durante a codificação, são encontrados problemas com o projeto, e assim por diante. O processo de software na pratica, nunca é um modelo linear simples, pois envolve feedback entre as fases.

À medida que surgem novas informações em uma etapa do processo, os documentos produzidos nas etapas anteriores devem ser modificados para refletir as mudanças no sistema. Por exemplo, se for descoberto que um requisito é caro demais para ser implementado, o documento de requisitos deve ser modificado para removê-lo. Entretanto, isso exige a aprovação do cliente, o que implica atraso do processo de desenvolvimento como um todo. 

