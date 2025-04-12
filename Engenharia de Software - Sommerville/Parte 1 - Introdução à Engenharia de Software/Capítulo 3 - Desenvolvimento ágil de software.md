**Objetivos**
O objetivo deste capítulo é apresentá-lo aos métodos de desenvolvimento ágil de software. Ao ler este capítulo, vamos:
- Compreender a lógica dos métodos de desenvolvimento ágil de software, o manifesto ágil e as diferenças entre o desenvolvimento ágil e o dirigido por plano;
- conhecer as práticas importantes do desenvolvimento ágil, como as histórias do usuário, e a refatoração, a programação em pares e o desenvolvimento com testes a *priori (test-first)*;
- compreenderá desde a abordagem Scrum até o gerenciamento ágil de projetos;
- compreenderemos as questões de escalabilidade dos métodos de desenvolvimento ágil e a combinação das abordagens ágeis com as dirigidas por plano no desenvolvimento de grande sistemas de software.

**Conteúdo**
- [ ] 3.1 Métodos ágeis
- [ ] 3.2 Técnicas de desenvolvimento ágil
- [ ] 3.3 Gerenciamento ágil de projetos
- [ ] 3.4 Escalabilidade dos métodos ágeis


As empresas agora operam em um ambiente global e em constante mudança. Elas precisam responder a novas oportunidades e mercados, condições econômicas mutáveis e o surgimento de produtos e serviços concorrentes. O software é parte essencial de quase todas as operações comerciais, <span style="background:#b1ffff">então novos softwares precisam ser desenvolvidos rapidamente para aproveitar novas oportunidades e responder à pressão competitiva</span>. Portanto, o desenvolvimento e entrega rápidos de software são os requisitos mais críticos para a maioria dos sistemas empresariais.
De fato, as empresas podem estar dispostas a abrir mão da qualidade do software e até mesmo comprometer os requisitos se puderem implantar rapidamente um novo software essencial.

Como essas empresas operam em um ambiente em mudança, é praticamente impossível derivar um conjunto completo de requisitos estáveis. Os requisitos mudam porque os clientes acham difícil prever como um sistema afetará práticas de trabalho, como ele interagirá com outros sistemas e quais operações dos usuários devem ser automatizadas.  Pode ser apenas após a entrega de um sistema e depois que os usuários ganharem experiência com ele que os requisitos reais se tornam claros. E mesmo assim, fatores externos continuam impulsionando mudanças nos requisitos.

Processos de desenvolvimento de software orientados por planos, que especificam completamente os requisitos antes de projetar, construir e testar um sistema, <span style="background:#affad1">não são adequados para o desenvolvimento rápido de software</span>. À medida que os requisitos mudam os problemas nos requisitos são descobertos, o design ou a implementação do sistema precisa ser retrabalhada e retestada. Como consequência, um processo convencional baseado no modelo cascata (waterfall) ou em especificações tende a ser demorado, e o software final é entregue ao cliente muito tempo depois de sua especificação inicial.

Para alguns tipos de software, como sistemas de controle críticos para segurança, onde uma análise completa do sistema é essencial, essa abordagem orientada por planos é a mais adequada. No entanto, em um ambiente empresarial dinâmico, ela pode causar sérios problemas. Quando o software finalmente está disponível para uso, o motivo original de sua aquisição pode já ter mudado de forma tão radical que o software se torna, na prática, inútil. Portanto, especialmente para sistemas de negócios, processos de desenvolvimento que focam em desenvolvimento e entrega rápida de software são essenciais.

A necessidade por desenvolvimento rápido de software e por processos capazes de lidar com requisitos em constante mudança já é reconhecida há muitos anos. No entanto, o desenvolvimento mais ágil de software realmente ganhou força no final da década de 1990 como surgimento da ideia de *agile methods*, como *Extreme Programming (Beck 1999)*, *Scrum* e *DSDM*.

O desenvolvimento rápido de software passou a ser conhecido como *agile development* ou *agile methods*. Esses *agile methods* são projetados para produzir software útil de forma rápida. Todos os métodos ágeis que foram propostos compartilham uma série de características em comum:
1. Os processos de *especificação, design e implementação* são intercalados. Não há um sistema de especificação detalhado, e a documentação de *design* é **minimizada ou gerada automaticamente pelo ambiente de programação utilizado para implementar o sistema**. O documento de requisitos de usuário é uma definição resumida das características mais importantes do sistema.
Para geração da documentação automática a partir dos controladores REST e anotações do Spring, podemos utilizar o #Springdoc-OpenAPI
Outra opção é utilizar o #Swagger.


2. O sistema é desenvolvido em uma série de *increments*. *End-users* e outros **stakeholders** estão envolvidos na especificação e avaliação de cada *increment*. Eles podem propor mudanças no software e novos *requirements* que devem ser implementados em uma versão futura do sistema.

3. Um amplo suporte de ferramentas é utilizado para apoiar o processo de desenvolvimento. As ferramentas que podem ser usadas incluem ferramentas de *automated testing*, ferramentas de suporte à *configuration management*, *system integration* e ferramentas para automatizar a produção das interfaces de usuário.
![[Capítulo 3 - Desenvolvimento ágil de software.png]]

*Agile methods* são métodos de desenvolvimento incremental nos quais os *increments* são pequenos e, geralmente, novas versões do sistema são criadas e disponibilizadas aos clientes e cada duas ou três semanas. Eles envolvem os *customers* no processo de desenvolvimento para obter um feedback rápido sobre requisitos em mudanças. A documentação é minimizada por meio de comunicações informais, em vez de reuniões formais com documentos escritos. 

As abordagens ágeis para o desenvolvimento de software consideram o *design* e a implementação como as atividades centrais no processo de software. Elas incorporam outras atividades, como *requirements elicitation* e *testing*, dentro do *design* e da *implementation*. 

Em contraste, uma abordagem *plan-driven* para a engenharia de software identifica estágios separados no processo de software, com outputs associados a cada estágio. Os outputs de um estágio são usados como base para o planejamento da próxima atividade do processo.

Em uma abordagem _agile_, a _iteration_ ocorre através das atividades. Portanto, os _requirements_ e o _design_ são desenvolvidos juntos, e não separadamente.

## 3.1 Agile methods
Na década de 1980 e início dos anos 1990, havia uma visão amplamente difundida de que a melhor forma de alcançar um software de melhor qualidade era por meio de um planejamento cuidadoso do projeto, garantia de qualidade formalizada, uso de métodos de análise e design apoiados por ferramentas de software, e processos de desenvolvimento de software controlados e rigorosos. Essa visão vinha da comunidade de _software engineering_ responsável por desenvolver sistemas de software grandes e de longa duração, como sistemas aeroespaciais e governamentais.

Essa abordagem _plan-driven_ foi desenvolvida para softwares criados por grandes equipes, trabalhando para diferentes empresas. As equipes eram frequentemente geograficamente dispersas e trabalhavam no software por longos períodos. Um exemplo desse tipo de software são os _control systems_ de uma aeronave moderna, que podem levar até 10 anos desde a especificação inicial até a implantação. Abordagens _plan-driven_ envolvem uma sobrecarga significativa em planejamento, design e documentação do sistema. Essa sobrecarga é justificada quando o trabalho de múltiplas equipes de desenvolvimento precisa ser coordenado, quando o sistema é um _critical system_ e quando muitas pessoas diferentes estarão envolvidas na manutenção do software ao longo de sua vida útil.

No entanto, quando essa abordagem robusta e _plan-driven_ é aplicada a sistemas de negócios de pequeno e médio porte, a sobrecarga envolvida é tão grande que domina o processo de desenvolvimento de software. Gasta-se mais tempo em como o sistema deve ser desenvolvido do que no desenvolvimento e _testing_ do programa. À medida que os _requirements_ do sistema mudam, o _rework_ se torna essencial e, pelo menos em princípio, a _specification_ e o _design_ precisam mudar juntamente com o programa.

A insatisfação com essas abordagens pesadas de _software engineering_ levou ao desenvolvimento dos _agile methods_ no final da década de 1990. Esses métodos permitiram que a equipe de desenvolvimento <span style="background:#d4b106">focasse no próprio software</span>, em vez de em seu _design_ e documentação. Eles são mais adequados para o desenvolvimento de aplicações em que os _system requirements_ geralmente mudam rapidamente durante o processo de desenvolvimento. Eles têm como objetivo entregar um _working software_ rapidamente aos _customers_, que então podem propor novos _requirements_ ou alterações a serem incluídos nas iterações futuras do sistema. Eles buscam reduzir a burocracia do processo evitando trabalhos com valor duvidoso a longo prazo e eliminando documentação que provavelmente nunca será utilizada.

A filosofia por trás dos _agile methods_ é refletida no _Agile Manifesto_ ([http://agilemanifesto.org](http://agilemanifesto.org)), emitido pelos principais desenvolvedores desses métodos. Esse manifesto declara:

| **Princípio**            | **Descrição**                                                                                                                                                                                                      |
| ------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Customer involvement** | Os _customers_ devem estar envolvidos de perto durante todo o processo de desenvolvimento. Seu papel é fornecer e priorizar novos _system requirements_ e avaliar as iterações do sistema.                         |
| **Embrace change**       | Espera-se que os _system requirements_ mudem, portanto o sistema deve ser projetado para acomodar essas mudanças.                                                                                                  |
| **Incremental delivery** | O _software_ é desenvolvido em _increments_, com o _customer_ especificando os _requirements_ a serem incluídos em cada _increment_.                                                                               |
| **Maintain simplicity**  | O foco deve ser na simplicidade, tanto no _software_ que está sendo desenvolvido quanto no processo de desenvolvimento. Sempre que possível, deve-se trabalhar ativamente para eliminar a complexidade do sistema. |
| **People, not process?** | As _skills_ da equipe de desenvolvimento devem ser reconhecidas e aproveitadas. Os membros da equipe devem ter liberdade para desenvolver suas próprias formas de trabalho, sem processos prescritivos.            |

*Estamos descobrindo maneiras melhores de desenvolver software, fazendo-o nós mesmos e ajudando outros a fazerem o mesmo. Através deste trabalho, passamos a valorizar:*
1. **Indivíduos e interações** mais que processos e ferramentas; (NA PRIMEIRA OPORTUNIDADE, DEMITE E CONTRATA O GPT PLUS)
2. **Software em funcionamento** mais que uma documentação abrangente;
3. **Colaboração com o cliente** mais que a negociação de contratos;
4. **Responder a mudanças** mais que seguir um plano.
*Ou seja, mesmo havendo valor nos itens à direita, valorizamos mais os itens à esquerda;*

Todos os métodos ágeis sugerem que o software deve ser desenvolvido e entregue de forma incremental. Esses métodos são baseados em diferentes processos ágeis.

Os _agile methods_ têm sido particularmente bem-sucedidos em dois tipos de desenvolvimento de sistemas:

1. **Product development**, onde uma empresa de _software_ está desenvolvendo um produto de pequeno ou médio porte para venda. Praticamente todos os _software products_ e _apps_ hoje em dia são desenvolvidos usando uma abordagem ágil.
    
2. **Custom system development** dentro de uma organização, onde há um claro comprometimento do _customer_ em se envolver no processo de desenvolvimento e onde há poucos _external stakeholders_ e regulamentações que afetam o _software_

## 3.2 Agile Development techniques
As ideias que fundamentam os métodos ágeis foram desenvolvidas aproximadamente na mesma época por várias pessoas diferentes durante a década de 1990. No entanto, talvez a abordagem mais significativa para transformar a cultura de desenvolvimento de software tenha sido o desenvolvimento do _Extreme Programming_ (XP). O nome foi cunhado por Kent Beck (Beck, 1998) porque a abordagem foi criada levando práticas reconhecidamente boas, como o desenvolvimento iterativo, a níveis “extremos”. Por exemplo, no XP, diversas novas versões de um sistema podem ser desenvolvidas por programadores diferentes, integradas e testadas em um único dia. A Figura 3.3 ilustra o processo do XP para produzir um incremento do sistema que está sendo desenvolvido.

A Programação Extrema era controversa, pois introduziu uma série de práticas ágeis muito diferentes do desenvolvimento tradicional da época. Elas estão resumidas na Figura 3.4 e refletem os princípios do manifesto ágil:
O desenvolvimento incrementai é apoiado por lançamentos menores e mais frequentes do sistema. Os requisitos se baseiam em histórias simples dos clien­ tes — ou cenários —, utilizados como base para decidir qual funcionalidade deve ser incluída em um determinado incremento.
2.  O envolvimento do cliente é apoiado por seu engajamento contínuo no time de desenvolvimento. O representante do cliente participa do desenvolvimento, e é responsável por definir os testes de aceitação do sistema.
3. As pessoas, não os processos, são apoiadas pela programação em pares, pela propriedade coletiva do código do sistema e por um processo de desenvolvimento sustentável que não envolve expedientes de trabalho longos demais.
4. As mudanças são adotadas por meio de lançamentos regulares do sistema aos clientes, desenvolvimento com testes a priori (test-first), refatoração para evitar a degeneração do código e integração contínua de novas funcionalidades.
5.  A manutenção da simplicidade é apoiada pela refatoração constante, que melhora a qualidade do código, e pelo uso de projetos (designs) simples, que não antecipam desnecessariamente as futuras mudanças no sistema.

Na prática, a aplicação da Programação Extrema como proposta originalmente se provou mais difícil do que o previsto. Ela não pode ser integrada de imediato às práticas de gestão e à cultura da maioria das empresas; assim, as que adotam métodos ágeis selecionam as práticas de Programação Extrema mais adequadas ao seu modo de trabalho. Às vezes, essas técnicas são incorporadas aos processos de desenvolvimento das próprias empresas, mas, na maioria das vezes, são utiliza­ das em conjunto com um método ágil focado em gerenciamento, como o Scrum (RUBIN. 2013).

### 3.2.1 Histórias do usuário
Os requisitos de software sempre mudam. Para lidar com essas mudanças, os métodos ágeis não têm uma atividade de engenharia de requisitos específica ou inde­ pendente. Em vez disso, a elicitação dos requisitos é integrada ao desenvolvimento. Para facilitar esse processo, foi desenvolvida a ideia de ‘histórias do usuário’, <span style="background:#d4b106">com o intuito de formar cenários de uso baseados nas experiências de um usuário do sistema</span>. 

Na medida do possível, <span style="background:#b1ffff">o cliente do sistema trabalha em estreita colaboração com o time de desenvolvimento</span> e discute esses cenários com os membros do time. Juntos, eles desenvolvem um ‘cartão de história’ que descreve resumidamente uma história que reúna as necessidades do usuário. O time de desenvolvimento buscará, então, implementar esse cenário em uma versão futura do software. Um exemplo de cartão de história do sistema Mentcare é exibido na Figura 3.5. Trata-se de uma descrição sucinta de um cenário para prescrever medicação para um paciente.

<span style="background:#d4b106">As histórias do usuário podem ser utilizadas no planejamento das iterações do sistema</span>. Depois de desenvolvidos, os cartões de história devem ser decompostos em tarefas pelo time de desenvolvimento, que estima o esforço e os recursos necessários para implementar cada uma delas. Normalmente, isso envolve discussões com o cliente para refinar os requisitos. O cliente prioriza as histórias a serem implementadas, escolhendo as que podem ser utilizadas imediatamente para proporcionar suporte útil ao negócio. A intenção <span style="background:#d4b106">é identificar funcionalidades essen­ciais que possam ser implementadas em aproximadamente duas semanas</span>, quando a próxima versão do sistema é disponibilizada para o cliente.

Naturalmente, à medida que os requisitos mudam, as histórias não implementadas também mudam ou são descartadas. Se forem necessárias alterações em um sistema que já foi entregue, são elaborados novos cartões de história e, mais uma vez, o cliente decide se essas alterações devem ter ou não prioridade sobre novas funcionalidades.

A ideia de histórias do usuário é poderosa, e as pessoas acham muito mais fácil se identificar com elas do que com o documento convencional de requisitos ou com casos de uso. As histórias podem ser úteis para fazer com que os usuários se envolvam na sugestão de requisitos durante uma atividade de elicitação que anteceda o desenvolvimento.

Por outro lado, o problema principal com as histórias do usuário é a complelude. É difícil julgar se foram desenvolvidas histórias suficientes para cobrir todos os requisitos essenciais de um sistema. Também é difícil julgar se uma única história proporciona uma imagem completa de uma atividade. Usuários mais experientes estão frequentemente tão familiarizados com seu trabalho que deixam de fora algumas coisas quando o descrevem.

### 3.2.2 Refatoração
Uma das premissas fundamentais da engenharia de software tradicional é a de que se deve projetar com vistas à mudança; ou seja, deve-se prever as futuras mudanças no software e projetá-lo para que elas possam ser implementadas com facilidade. No entanto, a Programação Extrema descartou esse princípio, com base na ideia de que projetar já pensando na mudança leva a um desperdício de trabalho. Não vale a pena perder tempo acrescentando generalidades a um programa para lidar com a mudança. Frequentemente, as alterações previstas não se materializam ou as solicitações de mudança podem ser completamente diferentes do previsto.

É natural que, na prática, sempre haja modificações no código que está sendo desenvolvido. Para facilitar esse processo, os desenvolvedores da Programação Extrema sugeriram que o código em desenvolvimento seja refatorado constantemente. 'Refatorar' (FOWLER et aí, 1999) significa que o time de programação deve buscar possíveis melhorias no software e implementá-las imediatamente. Quando os mem­bros do time se deparam com um código que pode ser melhorado, eles executam essas melhorias, mesmo quando não há necessidade imediata delas.

Um problema fundamental do desenvolvimento incrementai é que as mudanças tendem a degradar a estrutura do software; consequentemente, fica cada vez mais difícil realizar outras alterações. Essencialmente, o desenvolvimento prossegue conforme são encontradas soluções alternativas para os problemas, o que resulta na frequente duplicação de código, no reúso indevido de partes do software e na degradação geral da estrutura à medida que código é adicionado ao sistema. A refatoração melhora a estrutura do software e a sua clareza, evitando, com isso, a deterioração estrutural que ocorre naturalmente quando o software é modificado.

Exemplos de refatoração incluem a reorganização de uma hierarquia de classe para remover código duplicado, a organização e renomeação de atributos e métodos e a substituição de seções de código similares, com chamadas para métodos definidos em uma biblioteca. Os ambientes de desenvolvimento de programas geralmente incluem fer­ramentas para refatoração. Essas ferramentas tomam mais fácil o processo de encontrar dependências entre as seções e de fazer modificações globais no código.

A princípio, quando a refatoração faz parte do processo de desenvolvimento, <span style="background:#b1ffff">o software sempre deve ser fácil de compreender e mudar quando são propostos novos requisitos</span>. Na prática, nem sempre é o que acontece. Às vezes, a pressão do desen­volvimento significa que a refatoração é postergada em virtude do tempo dedicado à implementação da nova funcionalidade. Algumas características novas e alterações não podem ser prontamente absorvidas pela refatoração de código e requerem que a arquitetura do sistema seja modificada.

### 3.2.2 Desenvolvimento com testes *a priori (test-first)*
Conforme discutido na introdução deste capítulo, uma das diferenças importantes entre o desenvolvimento incremental e o desenvolvimento dirigido por plano é a maneira como o sistema é testado. Com o desenvolvimento incremental, não há uma especificação do sistema que possa ser utilizada por uma equipe de testes externa para desenvolver testes do sistema. <span style="background:#d4b106">Como consequência, algumas abordagens ao desenvolvimento incremental têm um processo de testes muito informal em comparação com os testes do desenvolvimento dirigido por plano</span>. 

A programação extrema desenvolveu uma nova abordagem ao teste de programas para contornar as dificuldades de se testar sem uma especificação. O teste é automatizado e é fundamental para o processo de desenvolvimento, que não consegue avançar até que todos os testes tenham sido executados com sucessso. As características-chave do teste em Programação Extrema são:
1. Desenvolvimento com testes *a priori (test-first)*;
2. Desenvolvimento de teste incremental a partir de cenários;
3. Envolvimento do usuário no desenvolvimento e validação dos testes e;
4. o uso de *frameworks* de teste automatizados.

Hoje, a filosofia de testes a priori (test-first) da Programação Extrema evoluiu para técnicas de desenvolvimento dirigido por testes mais gerais (JEFFRIES; MELNIK. 2007). Acredito que o desenvolvimento dirigido por testes é uma das inovações mais importantes na engenharia de software. Em vez de escrever o código e depois os testes dele, primeiro se escrevem os testes e depois o código. Isso significa que é possível executar os testes à medida que o código está sendo escrito e descobrir problemas durante o desenvolvimento. Discutiremos o desenvolvimento dirigido por testes com mais profundidade no Capítulo 8.

Escrever os testes define implicitamente uma interface e uma especificação do comportamento da funcionalidade que está sendo desenvolvida. Os problemas de requisitos e má compreensão da interface são menores. O desenvolvimento com testes a priori exige que haja uma relação clara entre os requisitos do sistema e o código que implementa os requisitos correspondentes. Na Programação Extrema, essa relação é clara porque os cartões de história que representam os requisitos são decompostos em tarefas, e essas são a unidade principal de implementação.

No desenvolvimento com testes a priori, as pessoas que implementam as tarefas precisam compreender inteiramente a especificação para que sejam capazes de escrever os testes do sistema. Isso significa que as ambiguidades e omissões na espe­cificação devem ser esclarecidas antes do início da implementação. Além disso, ele também evita o problema de ‘defasagem do teste’, algo que pode acontecer quando o desenvolvedor do sistema trabalha em um ritmo mais veloz que o do lestador. A implementação fica cada vez mais à frente e há uma tendência a ignorar testes para que o cronograma de desenvolvimento possa ser mantido.

A abordagem com testes a priori da Programação Extrema pressupõe que as histórias do usuário foram desenvolvidas e decompostas em um conjunto de cartões de tarefa, conforme a Figura 3.6. Cada tarefa gera um ou mais testes de unidade que conferem a implementação descrita na tarefa. A Figura 3.7 é uma descrição curta de um caso de teste que foi desenvolvido para conferir se a dose prescrita de um medicamento não está fora dos limites de segurança conhecidos.

A automação dos testes é essencial para o desenvolvimento com testes a priori (tesi-firsi). Os testes são escritos como componentes executáveis antes de a tarefa ser implementada. Esses componentes de teste devem ser stand-alone, simular a submis­são da entrada a ser testada e conferir se o resultado satisfaz a especificação de saída. Umframework de teste automatizado é um sistema que facilita a produção de testes executáveis e os submete à execução. O JUnit (TAHCHIEV etal., 2010) é um exemplo de framework de teste automatizado amplamente utilizado para programas em Java.

Como os testes são automatizados, há sempre um conjunto deles que pode ser executado de maneira rápida e fácil. Sempre que qualquer funcionalidade for acres­centada ao sistema, os testes podem ser rodados e os problemas que o novo código introduziu podem ser capturados imediatamente.

O desenvolvimento com testes a priori o teste automatizado resultam normalmente em uma grande quantidade de testes sendo produzidos e executados simultaneamente. No entanto, existem problemas ao garantir que a cobertura dos testes seja completa:
1. Os programadores preferem programar a testar e, às vezes, tomam atalhos quando elaboram os testes. Por exemplo, eles podem escrevê-los incompletos, sem a conferência de todas as possíveis exceções que podem ocorrer.
2. Alguns testes podem ser difíceis de escrever de modo incremental. Por exemplo, em uma interface com o usuário complexa, muitas vezes é difícil escrever testes de unidade para o código que implementa a *lógica de exibição* e o fluxo entre as telas.

É difícil julgar se um conjunto de testes é ou não completo. Embora seja possível ter muitos testes do sistema, seu conjunto pode não promover a cobertura completa. Partes cruciais do sistema podem não ser executadas e. assim, permanecerão não testadas. Portanto, embora um grande conjunto de testes executados frequente­ mente possa dar a impressão de que o sistema está completo e correto, isso pode não ser verdade. Se não for feita uma revisão e outros testes forem produzidos após o desenvolvimento, então os erros não detectados podem seguir junto com o lançamento do sistema.

### 3.2.4 Programação em pares
Outra iniciativa que foi introduzida na Programação Extrema é que os programadores trabalham em pares no desenvolvimento do software. Cada dupla senta-se diante do mesmo computador para desenvolver o software, mas o mesmo par nem sempre programa junto. Em vez disso, os pares são criados dinamicamente para que todos os membros do time trabalhem uns com os outros durante o processo de desenvolvimento.
A programação em pares tem uma série de vantagens:
1. Apoia a ideia de propriedade e responsabilidade coletivas pelo sistema. Isso reflete a ideia de Weinberg, de programação sem ego (WEINBERG 1971), em que o software é de propriedade de todo o time e os indivíduos não são responsabili­zados individualmente pelos problemas com o código. Em vez disso, todos são responsáveis pela resolução de problemas.
2. Ela age como um processo de revisão informal, já que cada linha de código é examinada por ao menos duas pessoas. Essas inspeções e revisões são eficazes na descoberta de um alto percentual de erros de software, mas é preciso muito tempo para organilzá-las e normalmente resultam em atrasos no processo de desenvolvimento. A programação em pares é um processo menos formal, que provavelmente não encontra tantos erros quanto as inspeções de código, mas é mais barata e fácil de organizar do que as inspeções formais.
3. Incentiva a refatoração para melhorar a estrutura do software. O problema em pedir aos programadores para refatorarem em um ambiente de desenvolvimento normal é que o esforço envolvido é investido para obter beneficio no longo prazo. Um desenvolvedor que investe tempo refatorando pode ser considerado menos eficiente do que um que simplesmente desenvolva código. Nas situações em que a programação em pares e a propriedade coletiva são empregadas, outras pessoas se beneficiam imediatamente da refatoração, tendendo a apoiarem o processo.

Pode-se pensar que a programação em pares é menos eficiente do que a programação individual. Em um determinado intervalo de tempo, um par de desenvolvedores produzira a metade do código produzido por dois indivíduos trabalhando sozinhos. Muitas empresas que adotaram métodos ágeis suspeitam da programação em pares e não a utilizam. Outras misturam a programação em pares e a individual, com um programador experiente trabalhando com um colega menos experiente quando encontram problemas.

Estudos formais sobre o valor da programação em pares obtiveram resulta­ dos diversos. Usando estudantes como voluntários. Williams e seus colaboradores (WILLIAMS et al., 2000) constataram que a produtividade da programação em pares parece ser comparável à de duas pessoas trabalhando de maneira independente. Os motivos sugeridos são que os pares discutem o software antes do desenvolvimento e. portanto, provavelmente têm menos partidas em falso e menos retrabalho. Além disso, o número de erros evitados pela inspeção informal é tal que menos tempo é consumido consertando defeitos descobertos durante o processo de teste.

Entretanto, estudos com programadores mais experientes não reproduzem esses resultados (ARISHOLM et al., 2007). Eles constataram que havia uma perda significativa de produtividade se comparado a dois programadores trabalhando isoladamente. Houve alguns benefícios para a qualidade, mas não compensaram totalmente a sobrecarga da programação em pares. Todavia, o compartilhamento de conhecimento que acontece durante a programação em pares é muito importante, já que reduz os riscos globais para um projeto quando os membros do time têm de deixa-lo. Isso já justifica, por si só, a aplicação da programação em pares.