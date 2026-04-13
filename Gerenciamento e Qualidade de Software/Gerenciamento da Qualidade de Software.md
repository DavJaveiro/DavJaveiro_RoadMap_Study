Podemos perceber que a <span style="background:#d3f8b6">qualidade de software </span>desempenha um papel fundamental no desenvolvimento de software, garantindo que o produto atenda às necessidades dos usuários. Essa busca pela <span style="background:#fff88f">excelência</span> abrange um conjunto de <span style="background:#d3f8b6">características</span> e <span style="background:#d3f8b6">propriedades</span> que definem o grau de qualidade de um software.

Priorizar a <span style="background:#fff88f">qualidade</span> <span style="background:#fff88f">em</span> <span style="background:#fff88f">produtos de software</span> é crucial para <span style="background:#d3f8b6">prevenção de problemas e retrabalho</span>, garantindo a <span style="background:#d3f8b6">satisfação dos clientes</span>. Nesta aula, exploraremos os diversos fatores pelos quais a qualidade pode ser avaliada, além de analisar as estratégias e práticas que podem ser adotadas para assegurar a qualidade em todas as etapas do desenvolvimento.

Contudo, enfrentamos um <span style="background:#fff88f">dilema comum no desenvolvimento de software</span>: o equilíbrio entre entregar um produto de qualidade aceitável quanto à <span style="background:#d3f8b6">perfeição excessiva pela qualidade</span>. Para superar esse desafio, discutiremos quais as formas de encontrar esse equilíbrio.

**Fatores da Qualidade de Software**
O levantamento sobre o estado das práticas de qualidade de *software*, realizado em 2014, sugere que as atividades de manutenção e evolução de *software* representam até 90% do total dos custos de desenvolvimento de software. 

**O que é:** a resposta não é tão simples quanto se imagina. Sabe-se que é qualidade ao vê-la e, mesmo assim, pode ser algo difícil de definir. Porém, para *software* de computador, qualidade é algo que tem de ser definido, e é isso o que é feito neste capítulo. 

**Quem realiza?** Todos os participantes, engenheiros de *software*, gerentes, envolvidos, da produção de software são responsáveis pela qualidade.

**Por que é importante?** Ou você faz certo da primeira vez ou faz tudo de novo. Se uma equipe de software buscar a qualidade em todas as atividades de engenharia de software, a quantidade de retrabalho será reduzida. Isso resulta em custos menores e, mais importante, menor tempo para disponibilização do produto no mercado.

**Quais são as etapas envolvidas?** Para obter *software* de alta qualidade, devem ocorrer quatro atividades: processo e prática comprovados de engenharia de software, gerenciamento consistente de projetos, controle global de qualidade e a presença de uma infraestrutura para garantir a qualidade.

A qualidade do software hoje em dia continua a ser um problema, mas quem é o culpado? Os clientes culpam os desenvolvedores, os desenvolvedores culpam os clientes (e outros envolvidos), argumentando que datas de entrega absurdas e um fluxo contínuo de mudanças os obrigam a entregar o *software* antes de ele estar completamente validado. Quem está com a razão? 


## Qualidade, o que é?
Algumas coisas são melhores do que as outras; ou seja, elas têm mais qualidade. Algumas coisas são melhores do que a outras, mas o que quer dizer "melhor?"... e por aí vai (andando em círculos)...

Qualidade é algo que se reconhece imediatamente, mas não conseguimos definir explicitamente. A *visão do usuário* enxerga a qualidade em termos das metas específicas de um usuário. 

O produto atende a meta? Então ele tem qualidade.

*Qualidade de projeto* refere-se às características que os projetistas especificam para um produto. A qualidade dos materiais, as tolerâncias e as especificações de desempenho, todos são os fatores que contribuem para a qualidade de um projeto. Quanto mais materiais de alta qualidade forem usados, tolerâncias mais rígidas e níveis de desempenho maiores forem especificados, mais aumentará a qualidade de porojeto de um produto se ele for fabricado de acordo com essas especificações.

A qualidade de projeto e qualidade de conformidade são as únicas questões que os engenheiros de *software* devem considerar? Robert Glass sustenta que o indicado é uma relação mais "intuitiva":
*satisfação do usuário = produto compatível + boa qualidade + entrega dentro do orçamento e do prazo previsto*

A qualidade é importante, mas se o usuário não estiver satisfeito, nada mais importa.

A qualidade de um produto é função do quanto ele transforma o mundo para melhor. 

Em 1977, McCall desenvolveu um dos primeiros modelos formais para avaliar a qualidade, conhecido como Modelo de Fatores de Qualidade de McCall. Esse modelo propôs uma estrutura organizada para refletir sobre os aspectos fundamentais que influenciam na qualidade do software.

Os fatores de qualidade desempenham um papel fundamental na avaliação e garantia de qualidade do software, sendo estes os atributos e as características que determinam o grau de excelência do produto: produtos usados para avaliar o quão bem o <span style="background:#d3f8b6">software atende aos requisitos do usuário</span> e às expectativas de qualidade.

De acordo com a Figura 1, o modelo de fatores de qualidade de McCall focou em três categorias principais que abrangem diferentes fatores de produtos de software.

!![image-2026432339401.png](/image-2026432339401.png)

A **revisão do produto** aborda a capacidade do software de ser modificado, atualizado e corrigido com facilidade, sem impactar negativamente sua estrutura e funcionalidade. Inclui fatores, como:
	- **Manutenibilidade:** passar por mudanças ou evoluções de forma rápida e com baixo impacto em sua estrutura e funcionamento.
	- **Flexibilidade:** ajustar ou adaptar facilmente a novas exigências, como: novos cenários, requisitos ou funcionalidades adicionais.
	- **Testabilidade:** submeter a testes de forma abrangente, eficiente e confiável, a fim de verificar se ele atende aos requisitos e se funciona corretamente em diferentes cenários.

A **transição do produto** aborda a capacidade do software de ser adaptado e transferido para diferentes ambientes e plataformas sem a necessidade de grandes modificações. Inclui fatores, como:
- **Portabilidade:** ser transferido em diferentes sistemas operacionais, plataformas de hardware ou ambientes de execução. Um software portável pode ser executado em diversos dispositivos ou ambientes sem a necessidade de modificações significativas.
- **Reusabilidade:** ter componentes ou módulos reutilizados para outros softwares. Um código bem estruturado e modular facilita a reutilização de suas partes, economizando tempo e recursos no desenvolvimento de novos sistemas.
- **Interoperabilidade:** funciona de forma integrada com outros sistemas e aplicativos, independentemente das plataformas ou tecnologias usadas, garantindo que dados e serviços possam ser compartilhados e trocados de maneira eficiente.

A **operação do produto** aborda a forma que o software se comporta e executa suas funções em condições normais de uso, ou seja, quando está em pleno funcionamento pelos usuários. Inclui fatores, como:
- **Correção:** satisfazer as especificações e cumprir os objetivos visados pelo cliente.
- - **Confiabilidade:** executar as funções de maneira estável, sendo livre de defeitos, evitando interrupções inesperadas durante o uso.
- - **Usabilidade:** fácil entendimento de uso e intuitivo, permitindo que os usuários interajam com o sistema de forma simples e sem dificuldades.
- - **Integridade:** manter e preservar a integridade dos dados e das informações manipuladas durante o seu funcionamento, evitando corrupção, perda ou acesso não autorizado.
- **Eficiência:** desempenho do software em relação à velocidade e utilização de recursos, garantindo que as tarefas sejam executadas de forma rápida e sem atrasos excessivos.


A fim de garantir a qualidade do software, é importante compreender que a <span style="background:#fff88f">garantia da qualidade</span> <span style="background:#d3f8b6">deve estar presente em todas as etapas do desenvolvimento de software</span>, vide exemplo na Figura 2. Seu principal objetivo é detectar problemas antes que sejam migrados para a próxima fase.
![Figura2.png](/Figura2.png)

- **Definição do modelo de negócios:** nesta fase, ocorre a modelagem e a identificação das necessidades do cliente, proporcionando uma compreensão do produto a ser desenvolvido, bem como a sua viabilidade, o seu cronograma e os custos. A garantia da <span style="background:#d3f8b6">qualidade assegura que as necessidades relatadas pelos clientes são claras e objetivas</span>, além de verificar a existência de um planejamento que abranja a avaliação de viabilidade de execução do projeto, o cumprimento do prazo e os custos envolvidos.

- **Especificação dos requisitos:** nesta fase, são identificadas as características funcionais e não funcionais para a concepção do produto. Durante esta fase, todas as necessidades que emergiram no modelo de negócio são minuciosamente detalhadas através dos requisitos. A garantia da qualidade deve avaliar se <span style="background:#d3f8b6">os requisitos coletados estão completos</span>, claros e sem ambiguidade. Adicionalmente, é essencial verificar se eles foram validados pelos clientes e se existe a rastreabilidade entre os requisitos.

- **Análise e modelagem:** nesta fase, é definido um modelo de solução que abrange todos os requisitos definidos na fase anterior. A <span style="background:#d3f8b6">garantia de qualidade avalia se todos os requisitos foram incluídos nesta solução</span>, bem como verifica a capacidade da arquitetura definida em lidar eficazmente com mudanças significativas, sejam elas relacionadas ao crescimento, à segurança, ao ambiente etc.

- **Implementação:** já na fase de implementação, os modelos e requisitos definidos nas fases anteriores são transformados em código fonte. A garantia da qualidade assegura a <span style="background:#d3f8b6">legibilidade do código fonte</span>; avalia a conformidade com o padrão de desenvolvimento da organização; avalia as mensagens apresentadas ao usuário final e a existência de rotinas de tratamento de erros em processos críticos do sistema.

- **Teste de software:** o objetivo desta fase é identificar falhas para buscar confiabilidade, usabilidade e eficiência do produto, assegurando que funcione conforme o esperado em diferentes cenários e condições. <span style="background:#d3f8b6">A garantia da qualidade avalia se as estratégias</span>, <span style="background:#d3f8b6">as categorias e os casos de testes definidos estão sendo seguidos e executados de acordo com o planejado para alcançar os objetivos propostos</span>.

- **Disponibilização:** fase em que o produto é entregue ao cliente para os usuários realizarem a homologação das funcionalidades do sistema. A garantia de qualidade <span style="background:#d3f8b6">avalia a entrega do sistema e garante o aceite por parte do cliente e as manutenções necessárias</span>.

 **O dilema da qualidade de software**
Ao longo desta jornada, exploramos os conceitos fundamentais sobre qualidade e os meios para garantir a qualidade de software. No entanto, quão intensamente devemos direcionar o esforço e o foco para a garantia da qualidade? O que seria um software “bom o suficiente”?

Essas são questões do dilema da qualidade. Se for desenvolvido um software de baixa qualidade, podemos ter uma falta de interesse do mercado; se buscarmos por um software perfeito, devemos ter em conta os custos altos e um período longo de desenvolvimento. O dilema da qualidade é <span style="background:#d3f8b6">encontrar um equilíbrio entre um produto aceitável</span>, evitando excessos de esforço e gasto, de forma que não comprometam o projeto.

Este dilema surge porque, ao investir em testes rigorosos, revisões extensas e práticas de desenvolvimento de qualidade, pode-se obter um produto final mais estável e confiável, resultando em menos retrabalho, menos problemas após seu lançamento e uma reputação positiva para a empresa. Mas, essa abordagem pode aumentar o tempo de desenvolvimento, atrasar o lançamento do produto e aumentar os custos.

Por outro lado, optar por acelerar o processo de desenvolvimento pode permitir que o produto chegue ao mercado mais rapidamente, o que pode ser vantajoso em um ambiente de competição acirrada. Entretanto, pode resultar em problemas de qualidade, defeitos, vulnerabilidades à segurança e insatisfação do cliente.

Então, o que seria um software “bom o suficiente”?

O software “bom o suficiente” fornece funções e características de alta qualidade desejadas pelos usuários, mas, ao mesmo tempo, fornece outras funções e características mais obscuras ou especializadas que contêm erros conhecidos (Pressman; Maxim, 2021).

Para Pressman e Maxim (2021), é viável a entrega de um software que não seja perfeito, mas que atenda às necessidades do usuário e, ao mesmo tempo, ofereça alguns erros conhecidos. Com um bom time de marketing, pode-se vender este software em sua primeira versão e melhorá-la para a versão 2.0 com aprendizados.

Mas, quanto custa a qualidade? No contexto de assegurar a qualidade, certamente, haverá um investimento financeiro, contudo, a ausência da qualidade também acarretará custos.

![Figura3.png](/Figura3.png)