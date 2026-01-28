A comunicação é o foco central do nosso trabalho como engenheiro de software, especialmente a comunicação entre nós e outros desenvolvedores. Apesar do computador se preocupar com o código sintaticamente correto, a comunicação com outros seres humanos exige mais. O nosso código deve ser bem documentado e organizado de modo que possa ser entendido por outras pessoas. Mas, podemos exigir mais! Ao longo do projeto, usaremos modelos de **software ou diagramas de caixa e linha para expressar a nossa intenção técnica**.

Assim como um bom código, os bons modelos de software são claros e fáceis de serem compreendidos pelas partes interessadas. Se o nossos modelos não forem claros, as pessoas que os consumirem não entenderão a nossa intenção técnica. Não há escassez de consumidores para nossos modelos: usuários, testadores, outros desenvolvedores, segurança, pessoas que preenchem os cheques, gerente de projeto e arquitetos. Dependendo, o único consumidor de um diagrama, pode ser nós mesmo! Um diagrama que é bom para um desenvolvedor pode não funcionar tão bem para o vice-presidente de engenharia. E vice-versa. O nosso desafio, portanto, é saber qual diagrama criar e quando criá-lo.


## What is Software Modeling and Why Do We do It?
A indústria de software, é relativamente uma indústria jovem e, como tal, tomou emprestados conceitos e abordagens de disciplinas mais maduras. Também houve várias "ondas" de abordagens de modelagem, desde a Unified Modeling Language (UML) até o modelo C4.

O setor de construção cria um conjunto completo de plantas antes de iniciar um novo projeto; os projetos de software não deveriam fazer o mesmo? Talvez...

A modelagem de software é o processo de criação de representações abstratas de um sistema de software para entender, analisar e comunicar melhor a nossa estrutura, comportamento e funcionalidade. Esses modelos orientam desenvolvedores, designers e partes interessadas durante o processo de design e desenvolvimento do sistema. <span style="background:#affad1">Bons modelos de software refletem o domínio do problema do mundo real, fornecendo insights durante todo o processo de desenvolvimento</span>.

No entanto, é importante entender as diferenças fundamentais entre escrever software e construir uma casa. Refatorar o mundo físico é difícil e caro; <span style="background:#d3f8b6">Após o término da construção, as plantas podem ser usadas para confirmar que tudo foi construído de acordo com as especificações. </span>

O software, entretanto, pode ser refatorado. O código pode ser alterado em algumas horas por algumas centenas de dólares. O custo de "refatorar" o mundo físico é consideravelmente maior; sem dúvida, as casas seriam construídas de forma diferente se o custo de quase todas as pequenas alterações fosse de algumas horas extras  e algumas centenas de dólares. As plantas não seriam tão essenciais para o processo de construção. <span style="background:#affad1">Como o software é mais maleável, a diagramação pode não ser tão essencial para o sucesso do projeto. </span> 

Os diagramas não são compilados, não resultam em código executável que contribua para a conclusão do nosso projeto. Na verdade, é possível argumentar que, para os desenvolvedores, o código é o artefato de design definitivo. Jack Reeves, autor dos influentes documentos Code as Design, argumenta que a programação é fundamentalmente uma atividade design e que a expressão mais pura desse design é o próprio código. 

<span style="background:#d3f8b6">Se os diagramas não compilam, por qual motivo eles são úteis?</span> Os diagramas podem fornecer contexto. Eles podem ser usados para entender e gerenciar a complexidade de um sistema e decompor o problema. Podemos usá-los para prever atributos de qualidade, também conhecidos como requisitos não funcionais ou habilidades.  

Os diagramas podem nos ajudar a projetar determinados atributos de qualidade. Algumas organizações exigem que a gente crie vários diagramas como parte do SDLC. Esses requisitos podem ser uma benção e uma maldição. 

<span style="background:#affad1">Os diagramas podem nos ajudar a planejar todo o sistema.</span> Uma ou duas horas para esboçar uma solução podem nos poupar dias de tempo de desenvolvimento. 

Eles também podem nos ajudar durante uma expedição de arqueologia de software, quando estamos aprendendo sobre um novo sistema ou quando somos expostos a ele pela primeira vez. Mas os diagramas devem estar alinhados com o sistema. <span style="background:#affad1">Os diagramas podem ser úteis na integração de novos engenheiros. Novamente, suponde que sejam precisos, eles também podem ser úteis na transferência de conhecimento para um novo membro da equipe, mais uma vez presumindo que sejam precisos. </span>Podem ser essenciais na depuração de um sistema, pois conhecer os limites de um sistema e suas principais responsabilidades pode ajudar-nos a projetar casos de teste ou determinar como abordar a depuração.

Como já percebemos, muito depende dos nossos diagramas serem precisos e atualizados. <span style="background:#affad1">Se um diagrama não for claro ou não representar o estado atual do código, o seu valor será bastante reduzido. </span>Isso leva a uma pergunta bastante interessante: quão permanente são os diagramas? Pode-se argumentar que os diagramas devem ter uma data de validade e que é perfeitamente aceitável jogar um diagrama fora quando ele não for mais útil. Eles podem ser tão efêmeros quanto um esboço em um quadro branco. Também podem ser formais e feitos com uma ferramenta de modelagem.

> Se nos pegarmos desenhando o mesmo diagrama várias vezes, isso é uma boa indicação de que deve formalizá-lo de alguma forma. Reserve um tempo para criá-lo com uma ferramenta e armazená-lo de forma centralizada para o nosso projeto; se ele for útil para a gente, também será para um colega de equipe. Para diagramas maiores, utilize uma impressora plotter; uma cópia física pendurada na parede pode ser útil para toda a equipel. Em alguns casos, imprimir um diagrama em papel cartão pode fazer com que ele pareça mais real e valioso para as pessoas. É claro que nós também podemos simplesmente tirar uma foto do diagrama e adicioná-lo à documentação do projeto. Não deixe que uma ferramenta nos atrase.

Não há escassez de ferramentas de modelagem à sua disposição. Elas variam de ferramentas simples de diagramação a ferramentas de modelagem empresarial de ponta e com recursos completos. Também é possível gerar código a partir de modelos, algo que pode ser encontrado principalmente em sistemas críticos de segurança. 5 Para que você não precise fazer uma pesquisa na Web, a notação Z é uma linguagem de especificação formal desenvolvida no final da década de 1970 e é baseada em matemática. com grandes equipes espalhadas pelo mundo podem encontrar um valor significativo na padronização de uma determinada ferramenta corporativa. <span style="background:#d3f8b6">Algumas ferramentas servem para esboçar modelos à mão, enquanto outras podem gerar modelos a partir do código.</span> Você explorará as ferramentas mais adiante neste capítulo, mas ferramentas sofisticadas não significam que você terá diagramas melhores que atenderão às suas necessidades. Além das ferramentas, também há muitos tipos de diagramas para escolher.

## Which Diagrams Do You Need?
Quando se trata de diagramas de modelagem de software, temos uma infinidade de opções ao nosso alcance. O desafio é saber qual diagrama criar e quando criá-lo durante todo processo de desenvolvimento de software. **Em outras palavras, de quais diagramas a gente realmente precisa e quais são os mais importantes neste momento do projeto?**
O que estamos tentando fazer?
Qual é a complexidade do problema?
Quão arriscado é o aplicativo?
Esse aplicativo é novo ou já foi criado algo similar anteriormente?
Qual é o orçamento do projeto?
Esse projeto é essencial para os negócios?

Os diagramas podem ser formais ou informais. Os modelos formais usam notação técnica, como a UML. 

!![image-20261271145574.png](/image-20261271145574.png)

Precisamos entender o nosso público-alvo do modelo. Quanto mais formal for o modelo, mais técnico deverá ser o público para consumi-lo. Isso normalmente significa que um subconjunto menor de pessoas entenderá a nossa intenção. 


The less formal the method, the less technical our audience will need to be to understand what we are trying to communicate. This allows for a larger audience that can consume our diagram.

## Context Diagrams
Eles definem a fronteira entre sistemas ou partes de um sistema. Eles mostram o ambiente, bem como a forma como as entidades interagem. Estas são entidades lógicas de dados que podem incluir informações sobre volume e frequência. Diagramas de contexto são de altíssimo nível.

Arquitetos, lideranças, gerentes de projeto e *product owners* utilizam diagramas de contexto frequentemente. Eles são usados logo no início de um projeto para definir fronteiras e alinhas as pessoas sobre o que está e o que não está incluído em uma determinada aplicação. Eles fornecem uma visão geral útil do que entendemos por um sistema específico e mostram rapidamente as "bordas do mapa".

Podemos pensar nos diagramas de contexto como a visão com o maior nível de zoom de um sistema. Por exemplo, a Figura abaixo é um diagrama de contexto para um sistema que organiza e gerencia todos os dados de um carro autônomo. O carro envia dados que podem ser analisados por cientistas de dados e também envia notificações para o proprietário do veículo.

!![image-20261271928969.png](/image-20261271928969.png)

Em 2026, diagramas de contexto devem considerar integrações com LLMs (Large Language Models) e agentes de IA como entidades externas ativas, e não apenas fluxos de dados passivos. A prática de desenhas esses diagramas em ferramentas puramente visuais (como Visio) está perdendo espaço para o **Diagramas as Code**. Isso permite que a documentação de contexto evolua via Pull Requests, mantendo a fidelidade técnica com o código-fonte.

## Component Diagrams
!![image-2026127249331.png](/image-2026127249331.png)

Mostram os principais elementos de um sistema em tempo de execução (runtime). Eles demonstram como o sistema trabalha em conjunto, ilustrando estrutura e comportamento, além de exibir fluxos de informação e interfaces. Diagramas de componentes são frequentemente utilizados por desenvolvedores, arquitetos, suporte de produção e engenheiros DevOps.

Esses diagramas são usados ao longo de todo o projeto. Originalmente, foram concebidos para definir as interações esperadas, mas também são úteis para contar a "história" do projeto para um público mais técnico. Eles podem ser valiosos na transferência de conhecimento e no *onboarding* de novos membros.

**Serverless e Efemeridade:** em arquiteturas puramente Serverless (AWS Lambda), o conceito de "componente em runtime" mudou. O foco agora é na **orquestração de eventos** e no tempo de inicialização (Cold Start), o que exige diagramas que enfatizem gatilhos e permissões de IAM (Identity and Access Management).

## Class Diagrams
!![image-2026127293593.png](/image-2026127293593.png)

Como o nome sugere, mostram como nossas classes se relacionam entre si. Eles demonstram relacionamentos de herança, bem como relacionamentos de composição, e podem incluir cardinalidade. Eles exibem entidades lógicas e podem incluir métodos quando for útil.

Diagramas de classe são frequentemente extraídos do código existente conforme a necessidade, pois, uma vez criados, eles rapidamente se tornam desatualizados em relação ao código. Eles podem ser visualmente esmagadas em grandes sistemas e podem ser divididos por fronteiras lógicas ou e domínio para torná-los mais compreensíveis.

O público voltado para o diagramas de classe é de natureza estritamente técnica, geralmente outros engenheiros, arquitetos, desenvolvedores, profissionais de operações,. etc . 

## Sequence Diagrams
Mostram uma sequência de interações, embora raramente exibam cada entidade ou interação individualmente. Normalmente, eles apresentam apenas as entidades envolvidas em um fluxo específico. A maioria dos sistemas possui interações quase ilimitadas e, por isso, não há uma forma razoável de documentar cada entidade e cada fluxo. Diagramas de sequência são frequentemente usados para documentar as interações mais interessantes ou arquiteturalmente significativas, ou como uma forma de mostrar um padrão específico ou o uso padrão de uma biblioteca.

Diagramas de sequência podem mostrar operações, incluindo parâmetros e tipos de retorno. Embora isso possa ser útil para os desenvolvedores, também é importante que eles podem se tornar desatualizados rapidamente em relação ao código. É possível extrair diagramas de sequência a  partir de código existente, o que pode ser útil ao iniciar em uma nova base de código. Esses diagramas são geralmente construídos por desenvolvedores ou arquitetos de solução. O público-alvo é tipicamente técnico, incluindo desenvolvedores, arquitetos e DevOps. O time de QA (Garantia de Qualidade) também pode usar diagramas de sequência para ajudá-los a entender o que testar.

Diagramas de sequência são usados ao longo de todo o projeto. No início, eles definem um padrão, mas são incrivelmente úteis na transferência de conhecimento e no _onboarding_. Por exemplo, o diagrama de sequência na Figura 4-5 retorna ao serviço de API, mostrando que uma busca determina se o usuário está autorizado a executar aquela função e, em caso positivo, como essa requisição flui até o armazenamento de dados e retorna.

!![image-20261273620248.png](/image-20261273620248.png)
## Deployment Diagrams
Diagramas de implantação fornecem uma visão de tempo de execução (runtime) do nosso sistema. Eles mostram os nós físicos de hardware, bem como o software que está sendo executado neles. Frequentemente, eles exibem como o hardware está conectado e mostram tanto os protocolos quanto a cardinalidade.

Os diagramas de implantação destinam-se a um público mais técnico, como arquitetos, desenvolvedores, profissionais DevOps e suporte de produção, além de arquitetos de infraestrutura, segurança e sua equipe de middleware.

Os diagrams de implantação podem ser lógicos ou físicos e devem ser rotulados apropriadamente. Por exemplo, um diagrama de implantação lógico pode representar um *cluster* como uma única entidade, enquanto um diagrama de implantação físico mostraria a quantidade de um determinado balanceador de carga ou servidor executando em um dado momento no referido *cluster*.

Eles são utilizados no início de um projeto para validar atributos de qualidade. Sistemas que exigem suporte 24/7 terão uma implantação muito diferente daqueles que possuem <span style="background:#d3f8b6">requisitos de tempo de atividade</span> (*uptime*) menos rigorosos. Diagramas de implantação podem nos ajudar a entender se uma aplicação atenderá às nossas necessidades de escalabilidade, além de validar a continuidade dos negócios. Eles também podem nos ajudar a encontrar uma implantação mais econômica.

Para sistemas Java, o diagrama físico ajuda a dimensionar os limites de memória (Xmx, Xms) e CPU. Saber se o software roda em instâncias ARM (Graviton) ou x86 impacta diretamente a performance e o custo da JVM.

Muitas organizações possuem um template padrão para suas implantações. A maioria das empresas terá ambientes de nuvem padronizados ou abordagens locais *on-premises*. De muitas formas, diagramas de implantação são como blocos de Lego. Sua empresa pode ter um conjunto definido de ferramentas e tecnologias que podemos usar, na maioria das vezes, teremos que encaixá-las. 

Muitas organizações já possuem arquiteturas de referência padronizadas que descrevem aplicações típicas e, ao mesmo tempo, estabelecem limites para as nossas opções de implantação. 

Também podemos encontrar uma especialização do diagrama de implantação conhecida como **diagrama de segurança**. Este modelo mais detalhado descreve os mecanismos de segurança de uma aplicação. 

Os de segurança, frequentemente incluem protocolos e podem aproveitar uma visão de tecnologia ou de implantação do sistema. Eles são destinados a um público mais técnico, como desenvolvedores, arquitetos e profissionais de segurança.

Diagramas de segurança são usados ao longo de todo o projeto. Eles podem definir um padrão, bem como validar se a solução atende às necessidades de segurança do projeto. É importante considerar **informações de identificação pessoal (PII)** ao interagir com um sistema, bem como quaisquer regulamentações ou leis aplicáveis. 

## Data Models
Estes modelos mostram entidades de dados, bem como seus relacionamentos. Eles podem estar em diferentes níveis de granularidade, desde o conceitual ao lógico, chegando até o layout físico do armazenamento de dados. Essencialmente, eles progridem do nível mais alto para a implementação concreta.

Modelos conceituais são de altíssimo nível e não são normalizados. Modelos lógicos exibem termos de negócio, geralmente em uma forma normal. Modelos de dados físicos mostram detalhes de implementação, incluindo tipos de dados. 

O público para modelos de dados pode variar de clientes a arquitetos de informação e administradores de bancos de dados (DBAs), bem como arquitetos de software, desenvolvedores e pessoal de suporte. Modelos de dados são frequentemente criados bem no início de um projeto para ilustrar o domínio, embora sejam refinados ao longo do ciclo de vida do projeto. 

## Modeling Best Practices
Um diagrama informal é relativamente rápido de rascunhar, o que pode ser tanto uma bênção quanto uma maldição! Diagramas podem sair do controle. 

### Mantenha a Simplicidade
