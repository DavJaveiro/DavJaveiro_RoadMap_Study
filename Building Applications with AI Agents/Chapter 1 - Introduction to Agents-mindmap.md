---

mindmap-plugin: markdown

---


## Preface


Quando comecei a conectar language models, tools, orchestration e memory juntos no que agora chamamos de #agent, fiquei surpreso com o quão capaz esse design pattern era e com a quantidade de confusão que havia sobre esse tópico. Durante meu tempo construindo agents e compartilhando minhas descobertas sobre incident investigation, threat hunting, vulnerability detection e mais, percebi que esse mais recente design pattern nos permitiu resolver classes inteiramente novas de problemas, mas também trouxe muitos obstáculos práticos para torná-los confiáveis para aplicações do mundo real. Engenheiros, cientistas, gerentes de produto e liderança queriam saber mais. “Como faço para o meu agent funcionar?” “Consigo fazer o meu agent funcionar às vezes, mas como faço para que ele funcione na maioria ou em todo o tempo?” “Como escolho um model para o meu use case?” “Como projeto tools eficientes para o meu agent?” “Que tipo de memory eu preciso?” “Devo usar RAG?” “Devo construir um single-agent ou um multiagent system?” “Qual architecture devo usar?” “Preciso fazer fine-tune?” “Como permito que os agents aprendam com a experiência e melhorem com o tempo?”


Embora existam muitos posts de blog e research papers que focam em aspectos específicos do tópico de design de agent systems, percebi que havia uma falta de guias acessíveis, holísticos e confiáveis para isso. Não consegui encontrar o livro que eu queria compartilhar com meus colegas, então decidi escrevê-lo.


Por meio de discussões aprofundadas, ajudei equipes a navegar pelas complexidades dos AI agents, considerando seus objetivos, constraints e ambientes únicos. AI agent systems são intrincados, combinando autonomy, decision making e interaction de maneiras que o software tradicional não combina. Eles são data-driven, adaptativos e envolvem múltiplos componentes como perception, reasoning, action e learning, tudo isso enquanto se conectam a usuários, tools e outros agents. Complicando a situação, os foundation models que impulsionam esses agents são probabilistic and stochastic por natureza, tornando a evaluation e testing mais desafiadores.


Este livro adota uma abordagem abrangente para a construção de aplicações com AI agents. Ele cobre o lifecycle completo, desde a concepção até o deployment e maintenance, ilustrado com case studies do mundo real, apoiado por referências e revisado por profissionais da área. Seções sobre tópicos avançados — como agent architectures, tool integration, memory systems, orchestration, multiagent coordination, measurement, monitoring, security e ethical considerations — são ainda mais refinadas por contribuições de especialistas.


Escrever este livro também foi uma jornada de descoberta para mim. Os rascunhos iniciais geraram conversas que desafiaram minhas perspectivas e introduziram novas ideias. Espero que esse processo continue enquanto você o lê, trazendo suas próprias percepções. Sinta-se à vontade para compartilhar qualquer feedback que você tenha sobre este livro via Twitter (X), LinkedIn, meu site pessoal ou quaisquer outros canais que encontrar.


### What This Book is About


Este livro oferece um framework prático para construir aplicações robustas utilizando agentes de IA. Ele aborda desafios essenciais e apresenta soluções para perguntas como:

- O que define um agente de IA e quando devo utilizar um? Como os agentes diferem dos sistemas tradicionais de aprendizado de máquina (ML)?
- Como projetar arquiteturas de agentes para casos de uso específicos, incluindo seleção de cenários e componentes essenciais como ferramentas, memória, planejamento e orquestração?
- Quais são as estratégias eficazes para planejamento, raciocínio, execução, seleção de ferramentas e topologias como cadeias, árvores e grafos?
- Como possibilitar que agentes aprendam com a experiência por meio de métodos não paramétricos, ajuste fino ( #fine-tuning) e aprendizado por transferência ( #transfer-learning)?
- Como evoluir de sistemas com um único agente para sistemas multiagente, incluindo padrões de coordenação como abordagens democráticas, hierárquicas ou #actor-critic?
- Como avaliar e melhorar o desempenho dos agentes com métricas, testes e monitoramento em produção?
- Quais ferramentas e frameworks são mais adequados para desenvolvimento, implantação e proteção dos agentes contra riscos?
- Como garantir que os agentes sejam seguros, éticos e escaláveis, considerando aspectos de experiência do usuário (UX), confiança, viés, justiça e conformidade regulatória?

O conteúdo do livro baseia-se em princípios de engenharia consolidados em práticas emergentes no campo de agentes de IA, com estudos de caso (como agentes para suporte ao cliente, assistente pessoais, áreas jurídicas, publicidade e revisão de código) e discussões sobre trade-offs para ajudar-nos a adaptar as soluções às nossas necessidades.


## Introduction to Agents


Estamos testemunhando uma profunda transformação tecnológica impulsionada por agentes autônomos, sistemas de software inteligentes capazes de raciocínio independente, tomada de decisão e interação eficaz em ambientes dinâmicos. Diferentemente do software tradicional, os agentes autônomos interpretam contextos, adptam-se a cenários e executam ações sofisticadas com supervisão humana mínima.


### Definindo Agentes de IA


Agentes autônomos são sistemas inteligentes projetados para analisar dados de forma independente, interpretar seu ambiente e tomar decisões orientada pelo contexto. À medida que a popularidade do termo "agente" cresce, seu significado tem se diluído, sendo frequentemente aplicado a sistemas que não possuem autonomia genuína. Na prática,  a agência existe em um espectro. Agentes verdadeiramente autônomos demonstram tomada de decisão significativa, raciocínio orientado pelo contexto e comportamentos adaptativos. Por outro lado, muitos sistemas rotulados como *agentes* podem simplesmente executar scripts determinísticos ou fluxos de trabalho rigidamente controlados. Projetar agentes genuinamente autônomos e adaptativos é desafiador, o que leva muitas equipes a adotar abordagens mais simples para obter resultados mais rápidos. Portanto, o teste fundamental para identificar um agente verdadeiro é verificar  se ele demonstra tomada de decisão real, em vez de seguir scripts estáticos.


A rápida evolução dos agentes autônomos é impulsionada principalmente por avanços de fundação * #foundation-models* e aprendizado por reforço. Embora os casos de uso tradicionais com modelos de função tenham se concentrado na geração de saídas legíveis por humanos, os avanços mais recentes permitem que esses modelos gerem assinaturas de funções estruturadas e seleções de parâmetros. Frameworks de orquestração podem então executar essas funções, possibilitando que os agentes consultem dados, manipulem sistemas externos e realizem  ações concretas.


Ao longo do livro, utilizaremos o termo "<span style="background:#fff88f">sistema agêntico</span>" para descrever toda a funcionalidade de suporte que permite a um agente operar eficazmente, incluindo ferramentas, memória, modelo de função, orquestração e infraestrutura de apoio.


Com um gama crescente de protocolos, como o *Model Context Protocol* e o *Agent-to-Agent protocol* (discutido no Capítulo 8), esses agentes poderão utilizar ferramentas remotas e colaborar com outros agentes para resolver problemas. Isso abre enormes oportunidades para automação sofisticada, mas também traz uma responsabilidade profunda de projetar, medir e gerenciar esses sistemas de forma cuidadosa, garantindo que suas ações estejam alinhadas com os valores humanos e operam com segurança em ambientes complexos e dinâmicos.


## The Pretraining Revolution


Embora o aprendizado de máquina (ML) tradicional seja uma técnica incrivelmente poderosa, ele geralmente é limitado pela quantidade e qualidade do conjunto de dados. Profissionais de ML normalmente dirão que passam a maior parte do tempo não treinando modelos, mas sim coletando e limpando os dados que serão utilizados para o treinamento. O sucesso extraordinário dos modelos generativos treinados em grandes volumes de dados demonstrou que modelos únicos agora podem se adaptar a uma ampla gama de tarefas sem qualquer treinamento adicional. Isso revoluciona anos de prática. Anteriormente, construir uma aplicação que utilizava ML exigia contratar um engenheiro de ML ou cientista de dados, fazer com que coletassem dados e, então, implantar esse modelo. Com os avanços mais recentes em grandes modelos generativos pré-treinados, modelos de alta qualidade que funcionam razoavelmente bem para muitos casos de uso agora estão disponíveis por meio de uma única chamada a um modelo hospedado, sem necessidade de treinamento ou hospedagem própria. Isso reduz drasticamente o custo e a complexidade de desenvolver aplicações habilitadas por ML e IA.


Avanços recentes em grandes modelos de linguagem (LLMs), como GPT-5, Claude da Anthropic, Llama da Meta, Gemini Ultra do Google e V3 da DeepSeek, aumentaram ainda mais o desempenho em uma série de tarefas difíceis, ampliando o escopo de problemas solucionáveis com modelos pré-treinados. Esses <span style="background:#fff88f">modelos de fundação</span> (*foundation models*) <span style="background:#d3f8b6">oferecem compreensão robusta de linguagem natural</span> e capacidades de geração de conteúdo, <span style="background:#fff88f">aprimorando a funcionalidade</span> dos agentes por meio de:

- **Compreensão de linguagem natural:** interpretar e responder de forma intuitiva a entrada do usuário.
- **Interação consciente do contexto:** manter o contexto para respostas relevantes e precisas ao longo de interações prolongadas.
- **Geração de conteúdo estruturado:** produzir texto, código e saídas estruturadas essenciais para tarefas analíticas e criativas.

Embora esses modelos sejam muito capazes por si só, eles também podem ser usados para tomar decisões em áreas bem delimitadas, adaptar-se a novas informações e invocar ferramentas para realizar trabalho real. <span style="background:#fff88f">A integração com frameworks sofisticados de orquestração</span> permite que esses modelos <span style="background:#d3f8b6">interajam diretamente com sistemas externos</span> e <span style="background:#d3f8b6">executem tarefas</span> práticas. Esses modelos são capazes de:

- **Interpretação contextual e tomada de decisão**: Navegar por situações ambíguas sem programação exaustiva prévia.
- **Uso de ferramentas**: Chamar outros softwares para recuperar informações ou realizar ações.
- **Planejamento adaptativo:** planejar e executar ações complexas e em múltiplas etapas de forma autônoma.
- **Sumarização de informações:** processar rapidamente documentos extensos, extraindo insights-chave, auxiliando assim em análise jurídica, síntese de pesquisas e curadoria de conteúdo.
- **Gestão de dados não estruturados:** interpretar e responder de forma inteligente a textos não estruturados, como e-mails, documentos, logs e relatórios.
- **Geração de código:** escrever e executar código, além de criar testes unitários.
- **Automação de tarefas rotineiras:** lidar eficientemente com atividades repetitivas em fluxos de trabalho de atendimento ao cliente e administrativos, liberando trabalhadores humanos para focar em tarefas mais nuances.
- **Síntese de informações multimodais:** realizar análises intrincadas de dados de imagem, áudio ou vídeo em escala.

Essa flexibilidade aprimorada permite que agentes autônomos lidem eficazmente com cenários complexos e dinâmicos que os modelos estáticos de ML normalmente não conseguem abordar.


## Types of Agents


À medida que o termo "agente" ganha popularidade, seu significado se ampliou para abranger uma ampla gama de sistemas habilitados por IA, frequentemente gerando confusão sobre o que realmente constitui um agente de IA. *The Information* categoriza os agentes em sete tipos práticos, refletindo como essas tecnologias estão sendo aplicadas atualmente:


### Agentes de tarefas empresariais


Esses agentes automatizam fluxos de trabalho empresariais predefinidos, como a automação de processos robóticos da UiPath, os fluxos low-code do Microsoft Power Automate ou as integrações de aplicativos do Zapier. Eles executam sequências de ações determinísticas, geralmente acionadas por eventos, com raciocínio contextual mínimo.


### Agentes conversacionais


Esta categoria inclui chatbots e agentes de atendimento ao cliente que interagem com os usuários por meio de interfaces de linguagem natural. Eles são otimizados para gerenciamento de diálogo, reconhecimento de intenção e alternância de turnos conversacionais, como assistentes virtuais incorporados a plataformas de suporte ao cliente.


### Agentes de pesquisa


Agentes de pesquisa realizam tarefas de coleta, síntese e sumarização de informações. Eles analisam documentos, bases de conhecimento ou a web para fornecer saídas estruturadas que auxiliam analistas humanos. Exemplos incluem Perplexity AI e Elicit.


### Agentes de Análise


Agentes de análise, como Power BI Copilot ou Glean, focam em interpretar conjuntos de dados estruturados e gerar insights, painéis e relatórios. Eles frequentemente se integram de forma estreita a data warehouses empresariais, permitindo que os usuários consultem dados complexos em linguagem natural.


### Agentes para desenvolvedores


Ferramentas como Cursor, Windsurf e GitHub Copilot representam agentes de codificação, que auxiliam desenvolvedorres gerando, refatorando e explicando código. Eles se integram profundamente aos fluxos de trabalho de IDes para aumentar a produtividade no desenvolvimento de software.


### Agentes específicos de domínio


Esses agentes são ajustados para domínios profissionais especializados, como agentes jurídicos (Harvey), médicos (Hippocratic AI) ou financeiros. Eles combinam conhecimento específico do domínio com fluxos de trabalho estruturados para oferecer assistência direcionada e em nível de especialista.


### Agentes que utilizam navegadores


Esses agentes navegam, interagem, extraem informações e realizam ações em sites sem interação humana. Diferentemente da automação de processos robóticos tradicional, que segue etapas pré-scriptadas, os agentes modernos que utilizam navegadores combinam compreensão de linguagem, percepção visual e planejamento dinâmico para se adaptar em tempo real.


Além desses sete tipos de agentes, os agentes de voz e vídeo são importantes e também devem ter sua adoção aumentada nos próximos anos:


### Agentes de voz


Alimentados por compreensão e geração de fala de ponta a ponta, esses agentes estão possibilitando a automação conversacional em áreas como atendimento ao cliente, agendamento de compromissos e até mesmo processamento de pedidos em tempo real.


### Agentes de vídeo


Esses agentes apresentam aos usuários respostas em vídeo baseadas em avatares, combinando sincronia labial, expressões faciais e gestos. Eles estão emergindo rapidamente em vendas, treinamento, onboarding de clientes, marketing e ferramentas de presença virtual — permitindo interações em vídeo escaláveis e personalizadas sem produção manual.


---
É importante destacar que o número e a variedade de tipos de agentes estão crescendo rapidamente, e é provável que vejamos novos tipos de agentes surgirem em muitos domínios à medida que o campo e suas tecnologias subjacentes evoluem. Neste livro, nossa ênfase está na categoria principal de agentes construídos em torno de modelos de linguagem, particularmente aqueles que utilizam texto e código. Embora abordemos automação de tarefas empresariais, voz e vídeo, exploraremos principalmente agentes construídos em torno de modelos de linguagem, suas arquiteturas, raciocínio e UX, nos capítulos subsequentes.


Agora que discutimos os tipos de agentes em evolução, a próxima questão crítica se torna: qual modelo você deve escolher para alimentar seu agente? A seleção de modelos é um domínio complexo e em rápida mudança. Como discutido na próxima seção, você precisará equilibrar fatores como complexidade da tarefa, suporte a modalidades, restrições  de latência e custo, e requisitos de integração para fazer a escolha certa para o nosso agente.


## Model Selection


Hoje, temos a sorte de contar com uma proliferação de modelos poderosos disponíveis tanto de provedores comerciais quanto da comunidade de código aberto. OpenAI, Anthropic, Google, Meta e DeepSeek oferecem, cada uma, modelos de fundação (_foundation models_) de ponta com capacidades impressionantes para fins gerais. Ao mesmo tempo, modelos de pesos abertos (_open-weight_), como Llama, Mistral e Gemma, estão expandindo os limites do que pode ser alcançado com implantações locais ou ajustadas (_fine-tuned_). Ainda mais impressionante é o rápido avanço de modelos pequenos e médios. Novas técnicas para destilação, quantização e geração de dados sintéticos estão permitindo que modelos compactos herdem níveis surpreendentes de capacidade de suas contrapartes maiores.


Essa explosão de opções é uma boa notícia: a competição está impulsionando inovação mais rápida, melhor desempenho e custos menores. Mas também cria um dilema — como escolher o modelo certo para o seu sistema agêntico? A verdade é que não existe uma resposta única que sirva para todos os casos. Na verdade, um dos pontos de partida mais razoáveis é simplesmente usar o modelo de propósito geral mais recente de um provedor líder, como OpenAI ou Anthropic. Como você pode ver na Tabela 1-1, esses modelos oferecem desempenho robusto pronto para uso, exigem pouca personalização e podem levá-lo surpreendentemente longe em muitas aplicações. O GPT-5 mini (ago/2025) lidera no geral com a maior pontuação média (0,819), seguido de perto por o4-mini (0,812) e o3 (0,811). Modelos proprietários e de acesso aberto, como Qwen3, Grok 4, Claude 4 e Kimi K2, também apresentam resultados competitivos.


**Tabela 1-1. Leaderboard do HELM Core Scenario (agosto de 2025). Desempenho comparativo em benchmarks dos 10 principais modelos em tarefas de raciocínio e avaliação: MMLU-Pro, GPQA, IFEval, WildBench e Omni-MATH.**


| Modelo                                        | Pontuação média | MMLU-Pro — COT correct | GPQA — COT correct | IFEval — IFEval Strict Acc | WildBench — WB Score | Omni-MATH — Acc |
| --------------------------------------------- | --------------- | ---------------------- | ------------------ | -------------------------- | -------------------- | --------------- |
| GPT-5 mini (2025-08-07)                       | 0,819           | 0,835                  | 0,756              | 0,927                      | 0,855                | 0,722           |
| o4-mini (2025-04-16)                          | 0,812           | 0,820                  | 0,735              | 0,929                      | 0,854                | 0,720           |
| o3 (2025-04-16)                               | 0,811           | 0,859                  | 0,753              | 0,869                      | 0,861                | 0,714           |
| GPT-5 (2025-08-07)                            | 0,807           | 0,863                  | 0,791              | 0,875                      | 0,857                | 0,647           |
| Qwen3 235B A22B Instruct 2507 FP8             | 0,798           | 0,844                  | 0,726              | 0,835                      | 0,866                | 0,718           |
| Grok 4 (0709)                                 | 0,785           | 0,851                  | 0,726              | 0,949                      | 0,797                | 0,603           |
| Claude 4 Opus (20250514, extended thinking)   | 0,780           | 0,875                  | 0,709              | 0,849                      | 0,852                | 0,616           |
| gpt-oss-120b                                  | 0,770           | 0,795                  | 0,684              | 0,836                      | 0,845                | 0,688           |
| Kimi K2 Instruct                              | 0,768           | 0,819                  | 0,652              | 0,850                      | 0,862                | 0,654           |
| Claude 4 Sonnet (20250514, extended thinking) | 0,766           | 0,843                  | 0,706              | 0,840                      | 0,838                | 0,602           |


Dito isso, eles nem sempre são a escolha mais eficiente. Para muitas tarefas — especialmente aquelas bem definidas, de baixa latência ou sensíveis a custos — modelos muito menores podem oferecer desempenho quase equivalente por uma fração do custo. Isso levou a uma tendência crescente: seleção automatizada de modelos. Algumas plataformas agora direcionam consultas mais simples para modelos pequenos, rápidos e baratos, reservando os modelos grandes e caros para raciocínios mais complexos. Essa otimização dinâmica em tempo de execução está se mostrando eficaz e aponta para um futuro em que sistemas multimodelo se tornem a norma.


A principal lição é que se gastarmos um esforço enorme otimizando a seleção de modelos para ganhos marginais, mas, a menos que nossa escala ou restrições exijam isso, começar de forma simples é perfeitamente aceitável. Com o tempo, muitas vezes vale a pena experimentar modelos menores, ajuste fino ou adicionar recuperação (*retrieval*) para melhorar o desempenho e reduzir custos. Apenas lembre-se: o futuro é quase certamente multimodelo, e projetar com flexibilidade agora trará benefícios no longo prazo.


## From Synchronous to Asynchronous Operations


Os sistemas de software tradicionais normalmente executam tarefas de forma síncrona, avançando passo a passo e aguardando a conclusão de cada ação antes de iniciar a próxima. Embora essa abordagem seja direta, ela pode gerar ineficiências significativas, especialmente ao aguardar entradas externas ou processar grandes volumes de dados.


Em contraste, os agentes autônomos são projetados para operação assíncrona. Eles podem gerenciar múltiplas tarefas em paralelo, adapta-se rapidamente a novas informações e priorizar ações dinamicamente com base em condições em mudança. Esse processamento assíncrono aprimora drasticamente a eficiência, reduzindo o tempo ocioso e otimizando o uso de recursos computacionais.


As implicações práticas dessa mudança são substanciais. Por exemplo:

- E-mails podem chegar com rascunhos de resposta já preparados;
- Faturas podem vir com detalhes de pagamentos pré-preenchidos;
- Engenheiros de software podem receber tickets acompanhados de código para resolvê-los e testes unitários para avaliá-los
- Agentes de suporte ao cliente podem receber sugestões de respostas e ações recomendadas;
- Analistas de segurança podem receber alertas que já foram automaticamente investigados e enriquecidos com inteligência relevante sobre ameaças.

Em cada caso, os agentes não estão apenas acelerando fluxos de trabalho rotineiros, eles estão mudando a natureza do próprio trabalho. <span style="background:#fff88f">Essa evolução transforma os papéis humanos de executores de tarefas para gestores de tarefas</span>. Em vez de gastar tempo com etapas repetitivas ou mecânicas, os indivíduos podem focar em supervisão estratégica, revisão e tomada de decisão de alto valor, ampliando a criatividade e o julgamento humanos, enquanto os agentes cuidam dos detalhes operacionais. Esses agentes tornam muito mais fácil para os papéis humanos serem proativos, em vez de reativos.


## Practical Applications and Use Cases


A versatilidade dos agentes autônomos abre uma infinidade de aplicações em diferentes setores. Para manter este livro ancorado em casos de uso claros e específicos, selecionei sete exemplos de agentes do mundo real, com sistemas de avaliação disponíveis no repositório público do GitHub que dá suporte a este livro. Frequentemente, retornaremos a esses exemplos à medida que explorarmos os aspectos-chave dos sistemas de agentes:


### **Agente de suporte ao cliente**


O suporte ao cliente é uma das aplicações mais prevalentes para agentes autônomos. Esses agentes lidam com consultas comuns, processam reembolsos, atualizam pedidos e escalam questões complexas para representantes humanos, oferecendo suporte 24/7 enquanto aumentam a satisfação do cliente e reduzem custos operacionais.


### **Agentes de serviços financeiros**


No setor bancário e de serviços financeiros, os agentes auxiliam no gerenciamento de contas, processamento de empréstimos, investigação de fraudes e rebalanceamento de carteiras de investimento. Eles otimizam o atendimento ao cliente, aceleram o processamento de transações e aprimoram a segurança ao detectar atividades suspeitas em tempo real.


### **Agente de triagem e admissão de pacientes na área de saúda**


Esses agentes dão suporte às operações de saúde na linha de frente, registrando novos pacientes, verificando seguros, avaliando sintomas para priorizar o atendimento, agendando consultas, gerenciando históricos médicos e coordenando encaminhamentos, melhorando assim a eficiência do fluxo de trabalho e os resultados para os pacientes.


### **Agente de help desk de TI**


Agentes de help desk de TI gerenciam o acesso de usuário, solucionam problemas de rede e sistema, implantam atualização de software, respondem a incidentes de segurança e escalam questões não resolvidas para especialistas. Eles aumentam a produtividade ao resolver problemas técnicos comuns com rapidez.


### **Agente de revisão de documentos jurídicos**


Agentes jurídicos auxiliam advogados e paralegais na revisão de contratos, realização de pesquisas jurídicas, admissão de clientes e verificações de conflito, gerenciamento de descoberta de provas, avaliação de conformidade, cálculo de danos e acompanhamento de prazos. Isso ajuda a otimizar fluxos de trabalho e melhorar a precisão nas operações jurídicas.


### **Agente analista de Centro de Operações de Segurança (SOC)**


Agentes analistas de SOC investigam alertas de segurança, coletam inteligência sobre ameaças, consultam logs, realizam triagem de incidentes, isolam hosts comprometidos e fornecem atualizações às equipes de segurança. Eles aceleram a resposta a incidentes e fortalecem a postura de segurança organizacional.


### **Agente de cadeia de suprimentos e logística**


Na gestão da cadeia de suprimentos, os agentes otimizam estoques, rastreiam remessas, avaliam fornecedores, coordenam operações de armazém, preveem demanda, gerenciam interrupções e lidam com requisitos de conformidade. Essas capacidades ajudam a manter a resiliência e a eficiência em redes globais.


Os agentes autônomos oferecem um potencial significativo em diversos casos de uso, desde suporte ao cliente e assistência pessoal até serviços jurídicos e publicidade. Ao integrar esses agentes às nossas operações, as organizações podem alcançar maior eficiência, melhorar a qualidade do serviço e desbloquear novas oportunidades de inovação e crescimento. À medida que continuamos a explorar as capacidades e aplicações dos agentes autônomos neste livro, fica evidente que seu impacto será profundo e abrangente em múltiplos setores.


Agora que examinamos alguns exemplos de agentes, na próxima seção, discutiremos algumas das considerações-chave ao projetar nossos sistemas agênticos.


## Workflows and Agentes


E muitos projetos reais, escolher entre um script simples, um fluxo de trabalho determinístico, um chatbot tradicional, um sistema de geração aumentada por recuperação (RAG) ou um agente autônomo completo pode ser a diferença entre uma solução elegante e uma arquitetura supercomplexa e difícil de manter. Para <span style="background:#fff88f">tornar essa escolha mais clara</span>, considere <span style="background:#d3f8b6">quatro fatores</span> principais: a <span style="background:#d3f8b6">variabilidade das nossas entradas</span>, a <span style="background:#affad1">complexidade do raciocínio necessário</span>, <span style="background:#b1ffff">quaisquer restrições de desempenho ou conformidade</span> e a <span style="background:#fdbfff">carga de manutenção contínua</span>.


Primeiro, quando escolheríamos não usar um modelo de função, ou qualquer componente de ML? Se <span style="background:#fff88f">nossas entradas</span> são <span style="background:#d3f8b6">totalmente previsíveis</span> e <span style="background:#d3f8b6">cada saída possível pode ser descrita antecipadamente</span>, algumas <span style="background:#fdbfff">poucas linhas de código procedural costumam ser mais rápidas</span>, mais baratas e muito mais fáceis de testar do que um pipeline baseado em ML.


Por exemplo, analisar um arquivo de log que sempre segue o formato "AAAA-MM-DD HH:MM:SS-mensagem" pode ser feito de forma confiável com um pequeno analisador baseado em expressões regulares em Python ou Go.


Da mesma forma, se o nosso aplicativo exige latência na casa dos milissegundos, como um sistema embarcado que deve reagir a dados de sensores em tempo real, simples não há tempo para uma chamada de API a um modelo de linguagem.


Nesses casos, o código tradicional é a escolha certa. Por fim, setores regulamentados (dispositivos médicos, aeronáutica, certos sistemas financeiros) frequentemente exigem lógica de decisão totalmente determinística e auditável, modelos <span style="background:#fff88f">neurais de caixa preta</span> não atenderão aos requisitos de ceriticação.


---
O termo "modelos neurais de caixa preta" (ou *black-box neural models,* no original em inglês) trata-se de uma expressão técnica consolidada e amplamente utilizada na literatura de inteligência artificial, aprendizado de máquina e engenharia de software.


**Caixa preta (black box)** é um conceito clássico da engenharia e da ciência que descreve um sistema no qual:

- É possível observar as **entradas** e as **saídas**
- Mas o **processo interno de transformação** é opaco, complexo ou difícil de interpretar.

Quando aplicado a **redes neurais**, o termo destaca que, embora possamos ver os dados que entram e as previsões que saem, as transformações matemáticas de alta dimensão que ocorrem nas camadas internas da rede são difíceis de explicar de forma intuitiva ou auditável para seres humanos.


---
Se qualquer uma dessas condições se aplicar, entradas determinísticas, necessidades rigorosas de desempenho ou explicabilidade, ou um domínio de problema estático, código puro é quase sempre preferível a um modelo de fundação.


Sem seguida, considere fluxos de trabalho determinístico ou semiautomatizados. Aqui, a lógica pode ser expressa como um conjunto finito de etapas ou ramificações, e sabemos antecipadamente onde podemos precisar de intervenção humana ou tratamento extra de erros. Suponha que processemos faturas de um pequeno conjunto de fornecedores e cada fatura chegue em um dos três formatos conhecidos: CSV, JSON ou PDF. Podemos construir um fluxo que encaminha cada formato para seu analisador correspondente, verifica inconsistências e pausa para revisão humana se algum campo falhar em uma reconciliação simples, nenhum entendimento semântico profundo é necessário. Da mesma forma, se seu sistema precisar repetir etapas falhadas com *backoff* exponencial ou pausar para a aprovação de um gestor, um motor de fluxo de trabalho (como Airflow, AWS Step Functions ou um conjunto bem estruturado de scripts) oferece controle mais claro sobre os caminhos de erro que um LLM poderia oferecer. Fluxos de trabalho determinísticos fazem sentido sempre que conseguimos enumerar antecipadamente todas as ramificações de decisão e precisa de controle rigoroso e auditável sobre cada uma.


Nesses cenários, os fluxos de trabalho escalam de forma natural do que scripts grandes e improvisados, mas ainda evitam a complexidade e o custo de executar um pipeline baseado em agentes.


Chatbots tradicionais ou sistemas RAG ocupam o próximo nível de complexidade: eles adicionam compreensão de linguagem natural e recuperação de documentos, mas ficam aquém do planejamento autônomo e em múltiplas etapas. Se a nossa necessidade principal é permitir que os usuários façam perguntas sobre uma base de conhecimento, digamos, pesquisando em um manual de produto, um arquivo jurídico ou *wikis* corporativas, um sistema RAG pode incorporar documentos a um armazenamento vetorial, recuperar trechos relevantes em resposta a uma consulta e gerar respostas coerentes e contextualizadas.


Por exemplo, um *help desk* de TI interno pode usar RAG para responder "Como redefino minhas credenciais de VPN?" buscando o guia de solução de problemas mais recente e resumindo as etapas relevantes. Diferentemente dos agentes autônomos, <span style="background:#fff88f">os sistemas RAG</span> <span style="background:#d3f8b6">não decidem independentemente</span> sobre ações subsequentes (como abrir um ticker ou agendar um retorno); eles simplesmente <span style="background:#d3f8b6">disponibilizam a informação</span>. Uma abordagem de <span style="background:#fff88f">chatbot tradicional ou RAG</span> faz sentido quando <span style="background:#d3f8b6">a tarefa é principalmente perguntas e respostas sobre conteúdo estruturado ou não estruturado</span>, com necessidade limitada de chamada a APIs externas ou orquestração de decisões. Os custos de manutenção são menores do que os de agentes, seu principal esforço está em manter os *embeddings* dos documentos atualizados e refinar os *prompts*, mas sacrificamos a capacidade do agente de planejar fluxos de trabalho em múltiplas etapas ou aprender com *loops* de feedback.


Por fim, chegamos aos agentes autônomos, situações em que nem código simples, nem fluxos de trabalhos rígidos, nem RAG são suficientes, porque <span style="background:#fff88f">as entradas</span> são não estruturadas,<span style="background:#d3f8b6"> inéditas ou altamente variáveis</span>, e porque <span style="background:#d3f8b6">exige planejamento dinâmico</span> em múltiplas etapas ou <span style="background:#d3f8b6">aprendizado contínuo</span> a partir de feedback. 
Considere um centro de suporte ao cliente que recebe e-mails de texto livre com problemas que variam de "a bateria do meu notebook está inchando e pode explodir" a "continuo sendo cobrado por serviços que não contratei". Um fluxo baseado em regras ou uma consulta a FAQ baseada em RAG não daria conta de tamanha variedade aberta, mas um agente alimentado por um modelo de função pode interpretar a intenção, extrair entidades relevantes, consultar uma base de conhecimento, redigir uma resposta adequada e até mesmo escalar para um humano, se necessário, tudo isso sem que cada ramificação possível tenha sido definida antecipadamente. Da mesma forma, na gestão da cadeia de suprimentos, um agente que ingere dados de inventário em tempo real, prazos de entrega de fornecedores e previsões de vendas pode replanejar dinamicamente os cronogramas de envio; um fluxo de trabalho determinístico exigiria atualizações manuais constantes para lidar com as novas exceções.


Os agentes também se destacam quando muitas subtarefas precisam ser executadas em paralelo, como um agente de operações de segurança que consulta simultaneamente API's de inteligência de ameaças, escaneia telemetria de rede<span style="background:#fdbfff"> e realiza análise em *sandbox* de binários suspeitos</span>. Como os agentes operam assíncrona e repriorizam com base em dados em tempo real, eles evitam a natureza frágil do "um passo de cada vez" típicas de fluxos de trabalho ou sistemas RAG.  Para justificar os custos mais altos de computação e manutenção de executar um modelo de função, podemos precisar desse nível de raciocínio contextual, orquestração paralela de tarefas ou melhoria contínua, cenários em que código rígido, fluxos de trabalho ou chatbots seriam frágeis ou caros demais para manter.


**sandbox analysis** significa executar códigos suspeitos em um ambiente seguro e isolado para observar seu comportamento e determinar se são maliciosos, tudo isso de forma automatizada pelo agente de segurança, sem colocar a infraestrutura em risco.


**Tabela 1-2. Diferenciando fluxos de trabalho e agentes do código tradicional**


|Característica|Código tradicional|Fluxo de trabalho|Agente autônomo|
|---|---|---|---|
|Estrutura de entrada|Esquemas totalmente previsíveis|Majoritariamente previsíveis com ramificações finitas|Entradas altamente não estruturadas ou inéditas|
|Explicabilidade|Transparência total; facilmente auditável|Rastreamento de auditoria explícito, ramificação por ramificação|Componentes de caixa preta que exigem ferramentas adicionais|
|Latência|Latência ultrabaixa|Latência moderada|Latência mais alta|
|Adaptabilidade e aprendizado|Nenhum|Limitado|Alto (aprendizado por feedback)|


Cada caminho traz compensações (*trade-offs*). Código puro é barato e rápido, mas inflexível; fluxos de trabalho oferecem controle, mas falham quando as entradas se tornam extremamente variáveis; chatbots tradicionais ou RAG são ótimos para perguntas e respostas sobre documentos, mas não conseguem orquestrar ações em múltiplas etapas; e agentes são poderosos, mas exigentes, tanto em termos de computação em nuvem quanto em esforço de engenharia para monitorar, ajustar e governar. Antes de escolher, pergunte-se: minhas entradas são não estruturas ou imprevisíveis? Preciso de planejamento em múltiplas etapas que se adapte a resultados intermediários? Um sistema de recuperação de documentos é suficiente para as necessidades de informação dos meus usuários, ou o sistema deve decidir e agir de forma autônoma? Quero que esse sistema melhore a si mesmo ao longo do tempo com intervenção humana mínima? E consigo tolerar a latência e a carga de manutenção de um modelo de fundação?


Em resumo, se sua tarefa é uma transformação fixa e determinística, escreva um código simples. Se houver algumas ramificações conhecidas e exigirmos pontos de verificação explícitos para tratamento de erros, use um fluxo de trabalho determinístico. Se a nossa necessidade principal for perguntas e respostas em linguagem natural sobre um *corpus*,  escolha uma arquitetura de chatbot tradicional ou RAG. Mas, se enfrentamos alta variabilidade, raciocínio aberto, necessidades de planejamento dinâmico ou requisitos de aprendizado contínuo, invista em um agente autônomo. Fazer essa escolha de forma ponderada garante que obtenhamos o equilíbrio certo entre simplicidade, desempenho e adaptabilidade, para que a solução permaneça eficaz e fácil de manter à medida que os requisitos evoluem.


## Principles for Building Effective Agentic Systems


Creating successful autonomous agents requires an approach that prioritizes scalability, modularity, continuous learning, resilience, and future-proofing:


### **Escalabilidade**


Garanta que os agentes consigam lidar com cargas de trabalho crescentes e tarefas diversas utilizando arquiteturas distribuídas, infraestrutura baseada em nuvem e algoritmos eficientes que suportem processamento paralelo distribuídas, infraestrutura baseada em nuvem e algoritmos eficientes que suportem processamento paralelo e otimização de recursos. **Exemplo:** um agente de suporte ao cliente que processa 10 tickets minutos pode travar ou sair do ar quando o tráfego subir para 1.000 se não estiver respaldado por uma infraestrutura com *autoscaling*.


### **Modularidade**


Projete agentes com componentes independentes e intercambiáveis, conectados por meio de interfaces bem definidas. Essa abordagem modular simplifica a manutenção, promove flexibilidade e facilita a adaptação rápida a novos requisitos ou tecnologias. **Exemplo:** um agente pouco modular, que codifica rigidamente (*hardcodes*) todas as suas ferramentas no serviço principal, exigiria uma reimplementação completa sempre que uma pequena adição ou modificação fosse necessária em uma ferramenta.


### **Aprendizado contínuo**


Equipar os agentes com mecanismos para aprender com a experiência, como aprendizado no contexto (*in-context learning*). Integre feedback dos usuários para refinar os comportamentos do agente e manter a relevância do desempenho à medida que as tarefas evoluem. **Exemplo:** agentes que ignoram loops de feedback podem continuar cometendo os mesmos erros, como classificar incorretamente cláusulas contratuais ou falhar ao escalar problemas críticos de suporte.


### Resiliência


Desenvolva arquiteturas robustas de resiliência, capazes de lidar graciosamente com erros, ameaças de segurança, *timeouts* e condições inesperadas. Incorpore tratamento abrangente de erros, medidas rigorosas de segurança e redundância para garantir operações confiáveis e contínuas dos agentes. **Exemplo:** agentes sem lógica de repetição (*retry*) ou contingência (*fallback*) podem falhar completamente quando uma única chamada de API falha, deixando o usuário aguardando e confuso.


### Preparação para o futuro (_Future-proofing_)


Construa sistemas de agentes em torno de padrões abertos e infraestrutura escalável, fomentando uma cultura de inovação para adaptar-se rapidamente a tecnologias emergentes e às expectativas em evolução dos usuários. **Exemplo:** acoplar rigidamente seu agente ao formato de _prompt_ de um único fornecedor proprietário pode tornar a troca de modelos dolorosa e limitar a experimentação.


Aderir a esses princípios permite que as organizações desenvolvam agentes autônomos que permaneçam eficazes e relevantes, adaptando-se de forma transparente aos avanços tecnológicos e às mudanças nos ambientes operacionais.


## Organizing for Success in Building Agentic Systems


A ampla disponibilidade de modelos de função (*foundation models*) por meio de chamadas simples de API impulsionou uma extensa experimentação com sistemas de agentes em diversas organizações. Equipes frequentemente iniciam provas de conceito independentes, levando a descobertas valiosas e ideias inovadoras. No entanto, essa <span style="background:#fff88f">facilidade de experimentação </span>muitas vezes resulta em fragmentação, projetos sobrepostos, <span style="background:#d3f8b6">esforços duplicados</span> e experimentos inacabados acabam espalhados por toda a organização. Por outro lado, a <span style="background:#fff88f">padronização prematura</span> pode <span style="background:#d3f8b6">sufocar a criatividade</span> e p<span style="background:#d3f8b6">render as organizações</span> a <span style="background:#fff88f">estruturas rígidas</span> ou soluções específicas de fornecedores.


Alcançar o sucesso exige equilibrar flexibilidade para experimentação com alinhamento suficiente para escalabilidade e coerência.


### Fases iniciais: incentive a exploração


Nas fases iniciais do desenvolvimento de agentes, as organizações devem incentivar ativamente esforços exploratórios, permitindo que as equipes testem livremente várias arquiteturas, fluxos de trabalho e modelos. Com o tempo, à medida que padrões bem-sucedidos e melhores práticas se tornam evidentes, o <span style="background:#d3f8b6">alinhamento estratégico passa a ser crítico</span>. Implementar uma estratégia de "um padrão por grande grupo" pode equilibrar eficazmente essa necessidade. Dentro do departamento ou áreas funcionais específicas, as equipes podem padronizar ferramentas e metodologias comuns, otimizando a colaboração sem restringir a inovação em nível organizacional mais amplo.


### Evite o lock-in de fornecedores


Outro aspecto essencial para o sucesso é evitar a dependência excessiva de um único fornecedor (vendor *lock-in*) adotando padrões abertos, como OpenAPI, e abrançando designs de sistemas modulares. Essas práticas ajudam a garantir flexibilidade e reduzem a dependência de qualquer tecnologia ou provedor específico, facilitando a adaptabilidade futura.


### Compartilhamento eficaz de conhecimento


O compartilhamento eficaz de conhecimentos também é crucial. Lições aprendidas tanto em experimentos bem-sucedidos quanto em fracassados devem ser comunicadas amplamente por meio de fóruns internos, repositórios compartilhados e documentação abrangente. Essa abordagem colaborativa acelera o aprendizado organizacional, minimiza esforços redundantes e promove a melhoria coletiva.


### Governança leve e flexível


Por fim, os frameworks de governança devem permanecer leves e flexíveis, enfatizando princípios orientadores em vez de mandatos rígidos. Uma estrutura de governança simplificada permite que as equipes inovem com confiança, mantendo-se alinhadas aos objetivos organizacionais mais amplos.


### Um processo fundamentalmente iterativo


Organizar-se com sucesso em torno de sistemas de agentes é fundamentalmente iterativo. As organizações devem reavaliar continuamente suas estratégias para manter um equilíbrio dinâmico entre exploração e padronização. Ao cultivar um ambiente que valoriza a experimentação, o aprendizado colaborativo e os padrões abertos, as organizações podem efetivamente transformar sistemas de agentes, de experimentos isolados, em soluções escaláveis e transformadoras, profundamente integradas aos seus processos operacionais.


## Agentic Frameworks


Numerosos frameworks existem atualmente para o desenvolvimento de agentes autônomos, cada um abordando funcionalidades críticas como integração de habilidades, gerenciamento de memória, planejamento, orquestração, aprendizado por experiência e coordenação multiagente. Esta lista certamente não é exaustiva, mas os principais frameworks incluem-se:


### LangGraph


#### **Pontos fortes**

- Framework de orquestração modular baseado em grafos direcionados, cujos nós contêm unidades discretas de lógica (frequentemente chamadas a modelos de fundação) e cujas arestas gerenciam o fluxo de dados por meio de fluxos de trabalho complexos e potencialmente cíclicos.
- Excelente ergonomia para desenvolvedores.
- Suporte nativo para fluxos de trabalho assíncronos e mecanismos de repetição (_retries_).

#### **Compensações (_Trade-offs_)**

- Exige lógica personalizada para planejamento avançado e gerenciamento de memória.
- Suporte embutido mais limitado para colaboração multiagente.

#### **Melhor para**

- Equipes que constroem sistemas robustos de agente único ou multiagente leve, com controle de fluxo explícito e inspecionável.

### Autogen


#### **Pontos fortes**

- Orquestração multiagente poderosa.
- Atribuição dinâmica de papéis.
- Interação flexível entre agentes baseada em mensagens.

#### **Compensações (_Trade-offs_)**

- Pode ser pesado ou complexo para casos de uso simples.
- Mais opinativo em relação aos padrões de interação entre agentes.

#### **Melhor para**

- Sistemas de pesquisa e produção que envolvem diálogo entre múltiplos agentes (ex.: padrões _manager-worker_, _loops_ de autorreflexão).

### CrewAI


#### **Pontos fortes**

- Fácil de aprender e usar.
- Configuração rápida para prototipagem.
- Abstrações úteis como "equipe" (_crew_) e "tarefas" (_tasks_).

#### **Compensações (_Trade-offs_)**

- Personalização e controle limitados sobre os internals da orquestração.
- Menos maduro que LangGraph ou AutoGen para fluxos de trabalho complexos.

#### **Melhor para**

- Desenvolvedores que desejam começar rapidamente com agentes práticos e centrados no ser humano, como assistentes ou agentes de suporte.

### OpenAI Agents Software Development Kit (SDK)


#### **Pontos fortes**

- Integração profunda com o ecossistema de ferramentas da OpenAI.
- Chamada de funções segura e fácil de usar, primitivas de memória e roteamento de ferramentas.

#### **Compensações (_Trade-offs_)**

- Fortemente acoplado à infraestrutura da OpenAI.
- Pode ser menos flexível ou portátil para _stacks_ de agentes personalizados ou _toolchains_ de código aberto.

#### **Melhor para**

- Equipes que já utilizam a API da OpenAI e buscam uma maneira rápida de construir agentes seguros que utilizam ferramentas, com infraestrutura mínima (_scaffolding_).

## Considerações finais


Embora cada framework ofereça vantagens e limitações únicas, a inovação contínua e a competição neste espaço devem impulsionar uma evolução constante.

- Para **protótipos iniciais**, CrewAI ou OpenAI Agents SDK podem colocá-lo em operação rapidamente.
- Para **sistemas escaláveis em produção**, LangGraph e AutoGen oferecem mais controle e sofisticação.

Vale ressaltar que esses frameworks **não são obrigatórios**, e muitas equipes optam por construir diretamente contra as APIs dos provedores de modelos.


Este livro concentra-se principalmente no **LangGraph**, escolhido por sua abordagem direta, porém poderosa, para o desenvolvimento de sistemas de agentes. Por meio de explicações detalhadas, exemplos práticos e cenários do mundo real, demonstramos como o LangGraph aborda eficazmente a complexidade e a dinâmica exigidas pelos agentes inteligentes modernos.


## Conclusion


Os <span style="background:#fff88f">agentes autônomos</span> representam um avanço transformador na IA, <span style="background:#d3f8b6">capazes de executar tarefas complexas e dinâmicas com alto grau de autonomia</span>. Este capítulo apresentou os conceitos fundamentais dos agentes, destacou seus avanços em relação aos sistemas tradicionais de ML e discutiu suas aplicações práticas e limitações. À medida que nos aprofundamos no projeto e na implementação desses sistemas, fica claro que a integração criteriosa de agentes em diversos domínios tem o potencial de impulsionar inovação e ganhos de eficiência significativos.


Embora as diferentes abordagens para o design de agentes autônomos discutidas neste capítulo tenham demonstrado capacidades e potenciais consideráveis, elas também evidenciam a complexidade e os desafios envolvidos na criação de sistemas eficazes e adaptáveis. Cada método, desde sistemas baseados em regras até arquiteturas cognitivas avançadas, oferece pontos fortes exclusivos, mas também carrega limitações inerentes. Neste livro, meu objetivo é justamente preencher essas lacunas.

