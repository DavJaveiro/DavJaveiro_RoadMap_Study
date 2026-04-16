# Desenvolvimento Ágil de Software 3
## Introdução
- **Objetivos**
O objetivo deste capítulo é apresentar os métodos de desenvolvimento ágil de software. Ao ler este capítulo, vamos:
- compreender a lógica dos métodos de desenvolvimento ágil de software, o manifesto ágil e as diferenças entre o desenvolvimento ágil e o dirigido por plano;
- conheceremos as práticas importantes do desenvolvimento ágil, como as histórias dos usuários, a refatoração, a programação em pares e o desenvolvimento com testes a *priori* (test-first);
- compreenderemos desde a abordagem Scrum até o gerenciamento ágil de projetos;
- compreenderemos as questões de escalabilidade dos métodos de desenvolvimento ágil e a combinação das abordagens ágeis com as dirigidas por plano no desenvolvimento de grandes sistemas de software.

- **Conteúdo**
3.1 Métodos ágeis
3.2 Técnicas de desenvolvimento ágil
3.3 Gerenciamento ágil de projetos
3.4 Escalabilidade dos métodos ágeis

As empresas de hoje em dia operam em um ambiente global em rápida mudança. Elas precisam responder às novas oportunidades e mercados. O software faz parte de quase todas as operações de negócios, então novo software tem de ser desenvolvido rapidamente, para que seja possível tirar vantagens das novas oportunidades e responder à pressão da concorrência. A <span style="background:#affad1">entrega e desenvolvimento rápidos</span> são, portanto, os requisitos mais importantes da maioria dos sistemas de negócios. Na verdade, as empresas podem estar dispostas a negociar a qualidade e comprometer requisitos se puderem implantar um novo software rapidamente.

Como essas empresas operam em um ambiente dinâmico, <span style="background:#affad1">é praticamente impossível</span> derivar <span style="background:#affad1">um conjunto completo de requisitos de software estáveis</span>. Esses requisitos mudam porque os clientes acham impossível prever como um sistema irá afetar as práticas profissionais, como irá interagir com outros sistemas e quais operações de usuário devem ser automatizadas. <span style="background:#affad1">Pode ser que só depois que um sistema tenha sido entregue</span>, e os usuários tenham adquirido experiência com ele, <span style="background:#affad1">que os verdadeiros requisitos fiquem claros</span>. Mesmo assim, <span style="background:#affad1">fatores externos orientam sua mudança</span>. 

Os processos de desenvolvimento de software dirigidos por plano que especificam completamente os requisitos e depois projetam, <span style="background:#fff88f">constroem e testam um sistema não são voltados para o desenvolvimento rápido de software</span>.  À medida que os requisitos mudam ou que problemas de requisitos são descobertos, o projeto ou a implementação do sistema precisam ser retrabalhados e testados novamente. Como consequência, um processo convencional em cascata ou baseado em especificação normalmente é demorado e o software final é entregue ao cliente muito depois do prazo originalmente estipulado.

Para alguns tipos de software, como os <span style="background:#fff88f">sistemas de controle críticos em segurança</span>, para os quais uma análise completa do sistema é essencial, essa <span style="background:#d3f8b6">abordagem dirigida por plano</span> é a mais indicada. No entanto, em um ambiente empresarial dinâmico, isso pode ser problemático. Quando <span style="background:#fff88f">o software finalmente estiver disponível</span> para uso, <span style="background:#d3f8b6">o motivo original da sua aquisição pode ter mudado tão radicalmente que ele acaba sendo inútil.</span> Portanto, especialmente no caso de sistemas de negócio, os processos de desenvolvimento e entrega rápidos são essenciais.

A necessidade de desenvolvimento rápido de software e de processos que possam lidar com requisitos que mudam foi reconhecida há muitos anos (LARMAN; BASILI, 2003). Entretanto, o desenvolvimento mais rápido do software só decolou no final dos anos 1990, quando surgiu a ideia de "métodos ágeis" como a programação Extrema, do inglês *Extreme Programming*, ou XP (BECK, 1999), o Scrum e o DSDM, do inglês *Dynamic Systems Development Method* (STAPLETON, 2003). 

O <span style="background:#fff88f">desenvolvimento rápido de software</span> passou a ser conhecido como <span style="background:#d3f8b6">desenvolvimento ágil</span>, ou <span style="background:#d3f8b6">métodos ágeis</span>. Esses métodos são concebidos para produzir software útil de maneira rápida. Todos eles compartilham uma série de características comuns:
1. Os <span style="background:#fff88f">processos de especificação, projeto e implementação</span> são <span style="background:#d3f8b6">intercalados</span>. Não há especificação detalhada do sistema e <span style="background:#fff88f">a documentação do projeto</span> é <span style="background:#d3f8b6">minimizada</span> ou <span style="background:#d3f8b6">gerada automaticamente</span> pelo ambiente de programação utilizado para implementar o sistema. O <span style="background:#fff88f">documento de requisitos do usuário</span> é uma <span style="background:#d3f8b6">definição resumida</span> contendo apenas as características mais importantes do sistema.
2. <span style="background:#fff88f">O sistema</span> é desenvolvido em uma <span style="background:#d3f8b6">série de incrementos</span>. Os <span style="background:#fff88f">usuários finais e outros *stakeholders*</span> estão envolvidos na <span style="background:#d3f8b6">especificação</span> e <span style="background:#d3f8b6">avaliação</span> de cada um deles. Além de mudanças no software, eles também podem propor novos requisitos para serem implementados em uma versão posterior do sistema.
3. O amplo apoio <span style="background:#fff88f">de ferramentas</span> é usado para ajudar no <span style="background:#d3f8b6">processo de desenvolvimento</span>. Podem ser utilizadas <span style="background:#d3f8b6">ferramentas de teste automatizado</span>, ferramentas de apoio ao gerenciamento de configuração e à integração de sistemas, além de ferramentas para automatizar a produção da interface com o usuário. 

Os métodos ágeis se baseiam no desenvolvimento incremental; os incrementos são pequenos e, normalmente, novas versões do sistemas são criadas e disponibilizadas para os clientes a cada duas ou três semanas, para que seja possível obter deles um *feedback* rápido nos requisitos que mudam. Além disso, esses métodos minimizam a documentação usando comunicação informal em vez de reuniões formais com documentos escritos.

As abordagens ágeis de desenvolvimento de software consideram o projeto (*design*) e a implementação como as atividades centrais no processo de software. Elas incorporam outras tarefas a essas atividades, como a elicitação dos requisitos e os testes. Por outro lado, uma abordagem dirigida por plano identifica etapas diferentes no processo de software, com resultados associados a cada uma delas. Esses dados são utilizados como base para o planejamento da atividade de processo seguinte.

A figura 3.1 mostra as diferenças fundamentais entre as abordagens ágil e dirigida por plano na especificação de sistemas. Em um processo de desenvolvimento de software dirigido por plano, a iteração ocorre dentro das atividades, com documentos formais sendo utilizados como meio de comunicação entre as etapas do processo. Por exemplo: os requisitos evoluirão e, no final das constas, será produzida uma especificação deles, que servirá como entrada para o processo de projeto e implementação. Em uma <span style="background:#fff88f">abordagem ágil</span>, por outro lado, <span style="background:#d3f8b6">a iteração ocorre ao longo das atividades</span>. Portanto, <span style="background:#fff88f">os requisitos</span> e <span style="background:#fff88f">o projeto (design)</span> <span style="background:#d3f8b6">são desenvolvidos juntos</span>, e não separadamente. 
!![image-2026473229150.png](/image-2026473229150.png)

Na prática, conforme explicamos na Seção 3.4.1, os processos dirigidos por plano são utilizados frequentemente com práticas de programação ágil, e os métodos ágeis podem incorporar algumas atividades planejadas, além da programação e dos testes. Em um processo dirigido por plano, é perfeitamente viável alocar requisitos e planejar a fase de projeto (design) e desenvolvimento como uma série de incrementos. Já um processo ágil não é inevitavelmente focado no código e pode produzir alguma documentação de projeto (design). Nos métodos ágeis, os desenvolvedores podem decidir que uma iteração não produzirá código novo, mas sim modelos e documentação de sistema.

## 3.1 Métodos Ágeis
Nos anos 1980 e início dos anos 1990, havia uma percepção generalizada de que a maneira mais indicada para obter um software melhor era por meio do planejamento cuidadoso do projeto, da garantia de qualidade formalizada, do uso de métodos de análise e projeto (*design*) apoiados por ferramentas de software e de processos de desenvolvimento controlados e rigorosos. Essa percepção veio da comunidade de engenharia de software que era responsável por desenvolver sistemas grandes e duradouros, como os destinados aos setores aeroespacial e governamental.

Essa abordagem dirigida por plano foi desenvolvida para o software criado por grandes times, trabalhando para diferentes empresas. Os times costumavam ficar dispersos geograficamente e trabalhavam no software por longos períodos. Um exemplo de software produzido dessa maneira são os sistemas de controle de uma aeronave moderna, que poderiam levar até dez anos para serem desenvolvidos, desde sua especificação inicial até a sua implantação. As abordagens dirigidas por plano envolvem sobrecargas no planejamento, no desenvolvimento e na documentação do sistema. Essa sobrecarga é justificada quando o trabalho de vários times de desenvolvimento precisa ser coordenado, quando o sistema é crítico e quando muitas pessoas diferentes estarão envolvidas na manutenção do software ao longo de sua vida útil.

No entanto, quando essa abordagem pesada é aplicada a sistemas de negócio de pequeno ou médio porte, a sobrecarga é tão grande que domina o processo de desenvolvimento de software. Mais tempo é investido na decisão de como o sistema deve ser desenvolvido do que na programação ou nos testes. À medida que os requisitos mudam, retrabalho é necessário e, ao menos a princípio, sua especificação e seu projeto (design) têm de mudar.

A insatisfação com essas abordagens levou ao surgimento dos métodos ágeis no final da década de 1990. Eles permitem que o o time de desenvolvimento se concentrasse no próprio software, em vez de no projeto (design) ou na documentação. Os <span style="background:#fff88f">métodos ágeis</span> são <span style="background:#d3f8b6">mais adequados</span> para desenvolver aplicações nas quais os <span style="background:#d3f8b6">requisitos do sistema mudam rapidamente</span> durante o processo. Eles se destinam a fornecer rapidamente um software funcional para o cliente, que, por sua vez, pode propor a inclusão de requisitos novos ou modificados nas iterações seguintes. Eles <span style="background:#d3f8b6">visam reduzir a burocracia</span> do processo ao <span style="background:#d3f8b6">evitar o retrabalho</span> com valor duvidoso no longo prazo e <span style="background:#d3f8b6">eliminar a documentação que provavelmente jamais será utilizada</span>. 

A filosofia por trás dos métodos ágeis está refletida no 'manifesto ágil', criado por desenvolvedores líderes desses métodos. O manifesto diz:
>Estamos descobrindo maneiras melhores de desenvolver software, fazendo-o nós mesmos e ajudando outros a fazerem o mesmo. Através deste trabalho, passamos a valorizar:
>*Indíviduos e interações* mais que processos e ferramentas
>*Software em funcionamento* mais que uma documentação abrangante
>Colaboração com o cliente mais que negociação de contratos.
>Responder a mudanças mais que seguir um plano.
>Ou seja, mesmo havendo valor nos itens à direita, valorizamos mais os itens à esquerda.

Todos os <span style="background:#fff88f">métodos ágeis</span> sugerem que o software deve ser <span style="background:#d3f8b6">desenvolvido e entregue incrementalmente</span>. Esses métodos se baseiam em diferentes processos ágeis, mas compartilham um conjunto de princípios, com base no manifesto ágil, e por isso têm muito em comum. Apresento estes princípios na Figura 3.2.
![[ENGENHARIA DE SOFTWARE 10ED (Ian Sommerville) (z-library.sk, 1lib.sk, z-lib.sk).pdf#page=75&rect=76,543,448,757|ENGENHARIA DE SOFTWARE 10ED (Ian Sommerville) (z-library.sk, 1lib.sk, z-lib.sk), p.75]]

Os <span style="background:#fff88f">métodos ágeis</span> têm sido particularmente úteis para dois tipos de <span style="background:#fff88f">desenvolvimento de sistemas</span>:
1. O desenvolvimento de um <span style="background:#fff88f">produto</span> <span style="background:#d3f8b6">pequeno ou médio</span>, por uma empresa de software, para venda. Praticamente todos os produtos de software e aplicativos são desenvolvidos atualmente usando uma <span style="background:#b1ffff">abordagem ágil</span>.
2. O desenvolvimento de <span style="background:#fff88f">sistemas personalizados</span> dentro de uma organização, em que há um compromisso, e no qual <span style="background:#d3f8b6">há poucos *stakeholders* externos</span> e <span style="background:#d3f8b6">normas</span> que afetam o software.

Neste cenário, os métodos ágeis permitem que haja uma comunicação contínua, sem intermédios, entre o gerente de produto, cliente do sistema e o time de desenvolvimento. O software passa a ser um sistema *stand-alone*, não sendo necessário coordenar desenvolvimento paralelos, onde os sistemas médios e pequenos podem ser desenvolvidos por times locais, isso permite uma comunicação informal entre o time.

## 3.2 Técnicas de Desenvolvimento Ágil
As ideias por trás dos métodos ágeis foram desenvolvidas mais ou menos na mesma época, nos anos 1990, por uma série de pessoas. Entretanto, talvez a <span style="background:#fff88f">abordagem</span> mais importante para mudança de cultura no <span style="background:#affad1">desenvolvimento de software</span> tenha sido o desenvolvimento da Programação Extrema (do inglês *Extreme Programming*, ou XP). O nome foi cunhado por Kent Beck com base na ideia de que essa abordagem leva a níveis "extremos" boas práticas reconhecidas, como o desenvolvimento iterativo. Na programação Extrema, por exemplo, várias versões novas de um sistema podem ser desenvolvidas, por diferentes programadores, integradas e testadas em um dia.

Na XP, os <span style="background:#fff88f">requisitos</span> são expressos em cenários (chamados de histórias do usuário) implementados diretamente como uma série de tarefas. 

Os programadores <span style="background:#fff88f">trabalham</span> em pares e <span style="background:#fff88f">desenvolvem testes</span> para cada tarefa antes de escreverem o código. Todos os testes devem ser executados com sucesso quando o novo código é integrado ao sistema, já que há um curso intervalo de tempo entre os lançamentos *releases* do sistema.

A programação Extrema era controversa, pois introduziu uma série de práticas ágeis muito diferentes do desenvolvimento tradicional da época. Estando resumidas:
1. O <span style="background:#fff88f">desenvolvimento incremental </span>é apoiado por lançamentos menores e mais frequentes do sistema. Os requisitos se baseiam em histórias simples dos clientes, ou cenários, utilizados como base para decidir qual funcionalidade deve ser incluída em um determinado incremento.
2. O <span style="background:#fff88f">envolvimento do cliente</span> é apoiado por seu engajamento contínuo no time de desenvolvimento. O representando do cliente participa do desenvolvimento, e é responsável por definir os testes de aceitação do sistema.
3. As <span style="background:#fff88f">pessoas</span>, não os processos, são apoiadas pela programação em pares, pela propriedade coletiva do código do sistema e por um processo de desenvolvimento sustentável que não envolve expedientes de trabalho longos demais.
4. As <span style="background:#fff88f">mudanças</span> são adotadas por meio de <span style="background:#d3f8b6">lançamentos regulares</span> do sistema aos clientes, desenvolvimento com testes a priori, refatoração para evitar a degeneração do código e a integração contínua de novas funcionalidades.
5. A manutenção da simplicidade é apoiada pela refatoração constante, que melhora a qualidade do código, e pelo uso de projetos (designs) simples, que não antecipam desnecessariamente as futuras mudanças no sistema.

Na prática, a aplicação da Programação Extrema como proposta originalmente se provou mais difícil do que o previsto. Ela não pode ser integrada de imediato às práticas de gestão e à cultura da maioria das empresas; assim, as que adotam métodos ágeis selecionam as práticas de Programação Extrema mais adequadas ao seu modo de trabalho. Às vezes, essas técnicas são incorporadas aos processos de desenvolvimento das próprias empresas, mas, na maioria das vezes, são utilizadas em conjunto com um método ágil focado em gerenciamento, como o Scrum.

Não estamos convencido de que a Programação Extrema seja um método ágil prático para a maioria das empresas, mas sua contribuição mais importante é, provavelmente, o conjunto de práticas de desenvolvimento ágil que introduziu na comunidade. Discuto as mais importantes nesta seção.
### 3.2.1 Histórias do usuário
Os <span style="background:#fff88f">requisitos de software</span> sempre mudam. Para lidar com essas mudanças, os métodos ágeis não têm uma atividade de engenharia de requisitos específica ou independente. Em vez disso, a <span style="background:#fff88f">elicitação dos requisitos</span> é integrada ao desenvolvimento. Para facilitar esse processo, foi desenvolvida a ideia de 'histórias do usuário', com o intuito de formar cenários de uso baseados nas experiências de um usuário do sistema.

Na medida do possível, o cliente do sistema trabalha em estreita colaboração com o time de desenvolvimento e discute esses cenários com os membros do time. Juntos, eles desenvolvem um 'cartão de história' que descreve resumidamente uma história que reúna as necessidades do usuário. O time de desenvolvimento buscará, então, implementar esse cenário em uma versão futura do software.  Um exemplo de cartão de história do sistema Mentcare é exibido na Figura 3.5. Trata-se de uma descrição sucinta de um cenário para prescrever medicação para um paciente.

As <span style="background:#fff88f">histórias do usuário</span> podem ser utilizadas no planejamento das iterações do sistema. Depois de desenvolvidos, os cartões de história devem ser decompostos em tarefas pelo time de desenvolvimento (Figura 3.6), que estima o esforço e os recursos necessários para implementar cada uma delas. Normalmente, isso envolve discussões com o cliente para refinar os requisitos. O cliente prioriza as histórias a serem implementadas, escolhendo as que podem ser utilizadas imediatamente para proporcionar suporte útil ao negócio. A <span style="background:#d3f8b6">intenção é identificar funcionalidades</span> essenciais que possam ser implementadas em aproximadamente duas semanas, quando a próxima versão do sistema é disponibilizada para o cliente. 

!![image-20264135910854.png](/image-20264135910854.png)

Naturalmente, à medida que os requisitos mudam, as histórias não implementadas também mudam ou são descartadas. Se forem necessárias alterações em um sistema que já foi entregue, são elaborados novos cartões de história e, mais uma vez, o cliente decide se essas alterações devem ter ou não prioridade sobre novas funcionalidades. 

A ideia de histórias do usuário é poderosa, e as pessoas acham muito mais fácil se identificar com elas do que com o documento convencional de requisitos ou com casos de uso. As histórias podem ser úteis para fazer com que os usuários se envolvam na sugestão de requisitos durante uma atividade de elicitação que anteceda o desenvolvimento. Discutirei isso em mais detalhes no Capítulo 4.

Por outro lado, o problema principal com as histórias do usuários é a completude. É difícil julgar se foram desenvolvidas histórias suficientes para cobrir todos os requisitos essenciais de um sistema. Também é difícil julgar se uma única história proporciona uma imagem completa de uma atividade. Usuários mais experientes estão frequentemente tão familiarizados com seu trabalho que deixam de fora algumas coisas quando o descrevem.

### 3.2.2 Refatoração
Uma premissa fundamental da engenharia de software tradicional é a de que se deve projetar com vistas à mudança; ou seja, deve-se prever as futuras mudanças no software e projetá-lo para que elas possam ser implementadas com facilidade. No entanto, a Programação Extrema descartou esse princípio, com base na ideia de que projetar já pensando na mudança leva um desperdício de trabalho. Não vale a pena perder tempo acrescentando generalidades a um programa para lidar com a mudança. Frequentemente, as alterações previstas não se materializam ou as solicitações de mudança podem ser completamente diferentes do previsto.

É natural que, na prática, sempre haja modificações no código que está sendo desenvolvido. Para facilitar esse processo, os desenvolvedores da Programação Extrema sugeriram que o código em desenvolvimento seja refatorado constantemente. <span style="background-color: yellow; padding:2px; border-radius:4px;">
‘Refatorar’ (FOWLER et al., 1999) significa que o time de programação deve buscar possíveis melhorias no software e implementálas imediatamente. 
</span>
(p.79). Quando os membros do time se deparam com um código que pode ser melhorado, eles executam essas melhorias, mesmo quando não há necessidade imediata delas. 

Um problema fundamental do desenvolvimento incremental é que as mudanças tendem a degradar a estrutura do software; consequentemente, fica cada vez mais difícil realizar outras alterações. Essencialmente, o desenvolvimento prossegue conforme são encontradas soluções alternativas para os problemas, o que resulta na frequente duplicação de código, no reúso indevido de partes do software e na degradação geral da estrutura à medida que o código é adicionado ao sistema. A refatoração melhora a estrutura do software a sua clareza, evitando, com isso, a deterioração estrutural que ocorre naturalmente quando o software é modificado.

Exemplos de refatoração incluem a reorganização de uma hierarquia de classe para remover código duplicado, a organização e renomeação de atributos e métodos e a substituição de seções de código similares, com chamadas para métodos definidos em uma biblioteca. Os ambientes de desenvolvimento de programas geralmente incluem ferramentas para refatoração. Essas ferramentas tornam mais fácil o processo de encontrar dependências entre as seções e de fazer modificações globais no código. 

A princípio, quando a refatoração faz parte do processo de desenvolvimento, o software sempre deve ser fácil de compreender e mudar quando são propostos novos requisitos. Na prática, nem sempre é o que acontece. Às vezes, a pressão do desenvolvimento significa que a refatoração é postergada em virtude do tempo dedicado à implementação da nova funcionalidade. Algumas características novas e alterações não podem ser prontamente absorvidas pela refatoração de código e requerem que a arquitetura do sistema seja modificada.

### 3.2.3 Desenvolvimento com testes *a priori (test-first)*

Uma das diferenças importantes entre o desenvolvimento incremental e o desenvolvimento dirigido por plano é a maneira como o sistema é testado. Com o desenvolvimento incremental, não há uma especificação do sistema que possa ser utilizada por uma equipe de testes externa para desenvolver testes do sistema. Como consequência, algumas abordagens ao desenvolvimento incremental têm um processo de testes muito informal em comparação com os testes do desenvolvimento dirigido por plano.

A Programação Extrema desenvolveu uma nova abordagem ao teste de programas para contornar as dificuldades de se testar uma especificação. O teste é automatizado e é fundamental para o processo de desenvolvimento, que não consegue avançar até que todos os testes tenham sido executados com sucesso. As características-chave do teste em programação Extrema são:
<span style="background-color: yellow; padding:2px; border-radius:4px;">
1. desenvolvimento com testes a priori (test-first); 
2. desenvolvimento de teste incremental a partir de cenários; 
3. envolvimento do usuário no desenvolvimento e validação dos testes e; 4. o uso de frameworks de teste automatizados.
</span>
(p.80)

Hoje, a filosofia de **testes a priori** da programação Extrema evoluiu para técnicas de desenvolvimento dirigido por testes mais gerais. O desenvolvimento dirigido por testes é uma das inovações mais importantes na engenharia de software. Em vez de escrever o código e depois os testes dele, primeiro escrevem os testes e depois o código. Isso significa que é possível executar os testes à medida que o código está sendo escrito e descobrir problemas durante o desenvolvimento. Discutirei o <span style="background:#d3f8b6">desenvolvimento dirigido por testes com mais profundidade no Capítulo 8</span>.

Escrever os testes define implicitamente uma interface e uma especificação do comportamento da funcionalidade que está sendo desenvolvida. Os problemas de requisitos e má compreensão da interface são menores. O desenvolvimento com testes *a priori* exige que haja uma relação clara entre os requisitos do sistema e o código que implementa os requisitos correspondentes. Na programação Extrema, essa relação é clara porque os cartões de história que representam os requisitos são decompostos em tarefas, e essas são a unidade principal de implementação.

No desenvolvimento com testes a priori, as pessoas que implementam as tarefas precisam compreender inteiramente a especificação para que sejam capazes de escrever os testes do sistema. Isso significa que as ambiguidades e omissões na especificação devem ser esclarecidas antes do início da implementação. Além disso, ele também evita o problema de 'defasagem do teste', algo que pode acontecer quando o desenvolvedor do sistema trabalha em um ritmo mais veloz que o do testados. A implementação fica cada vez mais à frente e há uma tendência a ignorar testes para que o cronograma de desenvolvimento possa ser mantido.

A abordagem com testes a priori da Programação Extrema pressupõe que as histórias do usuário foram desenvolvidas e decompostas em um conjunto de cartões de tarefa, conforme a Figura 3.6. Cada tarefa gera um ou mais testes de unidade que conferem na  implementação descrita na tarefa. A Figura 3.7 é uma descrição curta de um caso de teste que foi desenvolvido para conferir se a dose prescrita de um medicamento não está fora dos limites de segurança conhecidos.

!![image-20264143810219.png](/image-20264143810219.png)

O papel do cliente nesse processo é ajudar a desenvolver testes de aceitação para as histórias que devem ser implementadas no próximo lançamento do sistema. Conforme será explicado no Capítulo 8, o teste de aceitação é o processo pelo qual o sistema é testado usando dados do cliente, com o objetivo de conferir se as suas reais necessidades estão sendo satisfeitas.

A automação dos testes é essencial para o desenvolvimento com testes *a priori* (test-first). Os testes são escritos como componentes executáveis antes de a tarefa ser implementada. Esses componentes de teste devem ser *stand-alone*, simular a submissão da entrada a ser testada e conferir se o resultado satisfaz a especificação de saída. Um *framework* de teste automatizado é um sistema que facilita a produção de testes executáveis e os submete á execução. O JUnit é um exemplo de *framework* de teste automatizado amplamente utilizado para programas em Java. 

Como os testes são automatizados, há sempre um conjunto deles que pode ser executado de maneira mais rápida e fácil. Sempre que qualquer funcionalidade for acrescentada ao sistema, os testes podem ser rodados e os problemas que o novo código introduziu podem ser capturados imediatamente.

O desenvolvimento com testes *a priori* e o teste automatizado resultam normalmente em uma grande quantidade de testes sendo produzidos e executados simultaneamente. No entanto, existem problemas ao garantir que a cobertura dos testes seja completa:
1. Os programadores preferem programar a testar e, às vezes, tomam atalhos quando elaboram os testes. Por exemplo, eles podem escrevê-los incompletos, sem a conferência de todas as possíveis exceções que podem ocorrer.
2. Alguns testes podem ser muito difíceis de escrever de modo incremental. Por exemplo, em uma interface com o usuário complexa, muitas vezes é difícil escrever testes de unidade par ao código que implementa a lógica de exibição e o fluxo entre as telas.

É difícil julgar se um conjunto de testes é ou não completo. Embora seja possível ter muitos testes do sistema, seu conjunto pode não promover a cobertura completa. Partes cruciais do sistema podem não ser executadas e, assim, permanecerão não testadas. Portanto, embora um grande conjunto de testes executados frequentemente possa dar a impressão de que o sistema está completo e correto, isso pode não ser verdade. Se não for feita uma revisão e outros testes forem produzidos após o desenvolvimento, então os erros não detectados podem seguir junto com o lançamento do sistema. 

### 3.2.4 Programação em pares
Outra iniciativa prática que foi introduzida na Programação Extrema é que os programadores trabalham em pares no desenvolvimento do software. Cada dupla senta-se diante do mesmo computador para desenvolver software, mas o mesmo par nem sempre programa junto. Em vez disso, os pares são criados dinamicamente para que todos os membros do time trabalhem uns com os outros durante o processo de desenvolvimento. 

A programação em pares tem uma série de vantagens:
1. Apoia a ideia de propriedade e responsabilidade coletivas pelo sistema. Isso reflete a ideia de Weinberg, de programação sem ego, em que o software é de propriedade de todo o time e os indivíduos não são responsabilizados individualmente pelos problem com o código. Em vez disso, todos são responsáveis pela resolução de problemas.
2. Ela age como um processo de revisão informal, já que cada linha de código é examinada por ao menos duas pessoas. Essas inspeções e revisões (Capítulo 24) são eficazes na descoberta de um alto percentual de erros de software, mas é preciso muito tempo para organizá-las e normalmente resultam em atrasos no processo de desenvolvimento. A programação em pares é um processo formal, que provavelmente não encontra tantos erros quanto as inspeções de código, mas é mais barata e fácil de organizar do que as inspeções formais.
3. Incentiva a refatoração para melhorar a estrutura do software. O problema em pedir aos programadores para refatorarem em um ambiente de desenvolvimento normal é que o esforço envolvido é investido para obter benefício no longo prazo. Um desenvolvedor que investe tempo refatorando pode ser considerado menos eficiente do que um que simplesmente desenvolva código. Nas situações em que a programação em pares e a propriedade coletiva são empregas, outras pessoas se beneficiam imediatamente da refatoração, tendendo a apoiarem o processo.

Pode-se pensar que a programação em pares é menos eficiente do que a programação individual. Em um determinado intervalo de tempo, um par de desenvolvedores produziria a metade do código produzido por dois indivíduos trabalhando sozinhos. Muitas empresas que adotaram métodos ágeis suspeitam da programação em pares e não a utilizam. Outras misturam a programação em pares e a individual, com um programador experiente trabalhando com um colega menos experiente quando encontrar problemas.

<span style="background-color: yellow; padding:2px; border-radius:4px;">
Os motivos sugeridos são que os pares discutem o software antes do desenvolvimento e, portanto, provavelmente têm menos partidas em falso e menos retrabalho. 
</span>
(p.82)

<span style="background-color: red; padding:2px; border-radius:4px;">
Entretanto, estudos com programadores mais experientes não reproduzem esses resultados 
</span>
(p.82). Eles constataram que havia uma perda significativa de produtividade se comparado a dois programadores trabalhando isoladamente. Houve alguns beneficios para a qualidade, mas não compensaram totalmente a sobrecarga da programação em pares. Todavia, o compartilhamento de conhecimento que acontece durante a programação em pares é muito importante...

## 3.3 Gerenciamento Ágil de Projetos
Os gerentes precisam saber o que está acontecendo em qualquer empresa de software, se um projeto tende ou não a cumprir seus objetivos, entregar o software no prazo e dentro do orçamento proposto. As abordagens dirigidas por plano evoluíram para satisfazer essa necessidade. Como discutido no Capítulo 23, os gerentes traçam um plano para o projeto mostrando o que deve ser entregue, quando deve ser entregue e quem vai trabalhar no desenvolvimento dos entregáveis desse projeto. Uma abordagem dirigida por plano exige que um gerente tenha uma visão estável sobre tudo que deve ser desenvolvido e sobre os processos de desenvolvimento.

<span style="background-color: yellow; padding:2px; border-radius:4px;">
O planejamento informal e o controle de projeto propostos pelos primeiros adeptos dos métodos ágeis conflitaram com essas necessidades de visibilidade impostas pelas empresas. 
</span>
(p.83). Os times se auto-organizavam, não produziam documentação e planejavam o desenvolvimento em ciclos muitos curtos. Embora isso possa funcionar (e funcione) nas empresas pequenas que desenvolvem produtos de software, é inadequado para as grandes que precisam saber o que está acontecendo em sua organização.

O desenvolvimento ágil precisa ser gerenciado para que seja feito o melhor uso do tempo e dos recursos disponíveis para o time. Para tratar dessa questão, foi desenvolvimento o <span style="background:#fff88f">método ágil chamado</span> Scrum, montando um arcabouço para organizar os projetos ágeis e, ao menos até certo ponto, dar visibilidade externa do que está acontecendo. Os desenvolvodres do Scrum queriam deixar claro que ele não era um método para gerenciamento de projetos no sentido convencional, então deliberadamente invetaram uma nova terminologia, como *Scrum Master*, que substituía nomes como o do gerente de projeto. 

O #Scrum é um método ágil na medida em que segue os princípios do manifesto ágil. Ele se concentra em proporcionar um arcabouço para a organização ágil do projeto e <span style="background:#d3f8b6">não impõe o uso de práticas de desenvolvimento específicas</span>, como a programação em pares e o desenvolvimento com testes a priori. Isso significa que ele pode ser integrado mais facilmente à prática atual de uma empresa. Consequentemente, à medida que os método ágeis se tornaram a principal abordagem para o desenvolvimento de software, o Scrum emergiu como o método mais utilizado. 

O processo do Scrum ou ciclo da *sprint* é exibido na Figura 3.9. A entrada é o **backlog** do produto e cada iteração do processo gera um incremento do produto que poderia ser entregue para os clientes. 

#Sprint - uma iteração de desenvolvimento. As *sprints* geralmente duram de 2 a 4 semanas. 

- **Backlog do produto:** é uma lista de itens 'a fazer' que o time Scrum deve cumprir. Podem ser definições de características e requisitos do software, histórias do usuário ou descrições de tarefas suplementares que são necessárias, como a definição da arquitetura ou a documentação do usuário. 

- **Scrum Master**: O Scrum Master é responsável por assegurar que o processo Scrum seja seguido e guiar o time no uso eficaz do Scrum. Essa pessoa é responsável pela interação com o resto da empresa e por garantir que o time Scrum não seja desviado por interferências externas. Os desenvolvedores Scrum são inflexíveis quanto ao Scrum Master não ser considerado um gerente de projeto. 

O ponto de partida para o ciclo de *sprint* do Scrum é o backlog do produto, uma lista de itens como características do produto, requisitos e melhorias de engenharia que precisam ser trabalhados pelo time Scrum. A versão inicial desse backlog pode ser derivada de um documento de requisitos, uma lista de histórias do usuário ou uma descrição do software a ser desenvolvido. 

O *backlog* do produto pode ser especificado em vários níveis de detalhe, sendo responsabilidade do *Product Owner*, ou dono do produto, garantir que o nível de detalhe da especificação seja adequado ao trabalho a ser realizado. Por exemplo, um item de **backlog** poderia ser uma história de usuário completa, como mostra a Figura 3.5, ou ser simplesmente uma instrução, como "refotar o código da interface" com o usuário. 

Cada ciclo de *sprint* dura um intervalo de tempo fixo, que normalmente é de 2 a 4 semanas. No início de cada ciclo, o *Product Owner* prioriza os itens do backlog do produto para definir quais são os mais importantes a serem desenvolvidos naquele ciclo. <span style="background:#fff88f">As sprints nunca se estendem para levar em conta trabalhos inacabados.</span> <span style="background:#affad1">Os itens são devolvidos para o backlog do produto se não puderem ser concluídos dentro do tempo alocado para a sprint</span>. 

<span style="background-color: yellow; padding:2px; border-radius:4px;">
Depois, todo o time se envolve na escolha dos itens de mais alta prioridade que acreditam que devam ser concluídos e estimam o tempo necessário para concluílos.
</span>
(p.85)

Durante esse tempo, o time faz reuniões diárias curtas (Scrums) para revisar o progresso e, onde for necessário, alterar as prioridades do trabalho. Durante o Scrum, todos os membros do time compartilham informações, descrevem seu progresso desde a última reunião, trazem os problemas que surgiram e declaram o que foi planejado para o dia seguinte. Desse modo, todos no time sabem o que está acontecendo e, se surgirem problemas, podem planejar novamente o trabalho no curto prazo para lidar com eles. Todos participam desse planejamento e não há uma orientação de cima para baixo partindo do Scrum Master.

As coisas que mais são validadas à respeito do Scrum, são:
<span style="background-color: yellow; padding:2px; border-radius:4px;">
1. O produto é decomposto em um conjunto de “pedaços” gerenciáveis e com preensíveis aos quais os stakeholders podem se referir.
</span>
(p.86)

<span style="background-color: yellow; padding:2px; border-radius:4px;">
2. Requisitos instáveis não impedem o progresso.
</span>
(p.86)

<span style="background-color: yellow; padding:2px; border-radius:4px;">
3. O time inteiro tem visibilidade de tudo e, consequentemente, a comunicação e disposição de seus membros são melhores.
</span>
(p.86)

<span style="background-color: yellow; padding:2px; border-radius:4px;">
4. Os clientes veem a entrega dos incrementos na hora e obtêm feedback de como o produto funciona. Eles não se deparam com surpresas de última hora como quando um time anuncia que o software não será entregue conforme o esperado.
</span>
(p.86)

<span style="background-color: yellow; padding:2px; border-radius:4px;">
5. A confiança entre clientes e desenvolvedores é estabelecida, criando uma cultura positiva na qual todos esperam que o projeto tenha sucesso.
</span>
(p.86)

 Scrum, como foi projetado originalmente, destinavase ao uso por times situados num mesmo local, onde todos os envolvidos pudessem se reunir diariamente. No entanto, hoje, muito do desenvolvimento de software envolve times distribuídos, com membros situados em diferentes lugares no mundo. Isso permite que as empresas tirem proveito de mão de obra mais barata em outros países, possibilita o acesso a habilidades especializadas e permite o desenvolvimento 24 horas por dia, com o trabalho acontecendo em diferentes fusos horários.

## 3.4 Escalabilidade dos métodos ágeis
