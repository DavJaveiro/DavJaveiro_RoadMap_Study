# Paradigmas e Fronteiras em Métodos Preditivos para Sequências: De Séries Temporais a Estruturas Biológicas com Deep Learning

## Introdução
Dados sequenciais são a linguagem fundamental de inúmeros fenômenos naturais e artificiais. Desde as flutuações diárias de mercados financeiros e as emissões de carbono ao longo de décadas até a sequência de aminoácidos que codifica a função de uma proteína, a capacidade de prever o comportamento futuro a partir de observações passadas constitui um desafio central e de alto impacto em toda a ciência e indústria.1 Historicamente, o domínio da previsão de sequências foi dominado por métodos estatísticos clássicos, como os modelos AutoRegressivos de Média Móvel Integrada (ARIMA). Embora robustos, esses métodos operam sob pressupostos de linearidade e estacionariedade que raramente se mantêm em dados do mundo real, limitando sua capacidade preditiva.4

A última década testemunhou uma disrupção paradigmática impulsionada pelo deep learning. Arquiteturas de redes neurais profundas demonstraram uma capacidade sem precedentes de aprender representações hierárquicas e capturar relações não-lineares complexas e dependências de longo prazo diretamente dos dados brutos.5 Essa capacidade transformou fundamentalmente o campo da análise preditiva de sequências.

Este relatório explora essa revolução através da lente de dois domínios de aplicação distintos, mas que compartilham uma surpreendente convergência metodológica: a previsão de séries temporais e a análise de sequências biológicas. A premissa central é que um conjunto comum de arquiteturas de deep learning, notavelmente as Redes Neurais Recorrentes (RNNs) e suas variantes como a Long Short-Term Memory (LSTM), e, mais recentemente, os Transformers, impulsionaram avanços paralelos e transformadores em ambos os campos.

A estrutura deste documento reflete essa narrativa de convergência. Primeiramente, serão revisados os fundamentos arquitetônicos das redes LSTM e Transformer. Em seguida, será analisada a aplicação e a evolução desses modelos no contexto da previsão de séries temporais em finanças, energia e meio ambiente. Posteriormente, o foco se voltará para o impacto monumental dessas mesmas arquiteturas na resolução de um dos maiores desafios da biologia: a predição da estrutura de proteínas. Por fim, uma análise crítica dos desafios remanescentes e das perspectivas futuras buscará sintetizar as lições aprendidas e delinear as próximas fronteiras da predição baseada em sequências.

  

## 1. Fundamentos da Modelagem Sequencial com Deep Learning: A Era Recorrente

### 1.1 Redes Neurais Recorrentes (RNNs) e o Desafio da Memória
As Redes Neurais Recorrentes (RNNs) representam a primeira classe de arquiteturas de deep learning projetada especificamente para processar dados sequenciais. Sua inovação fundamental reside em um laço de recorrência, que permite que a informação persista. A cada passo de tempo, a RNN processa uma entrada da sequência e atualiza seu "estado oculto", uma representação vetorial que atua como uma memória condensada de todas as entradas anteriores. Esse estado oculto é então utilizado, juntamente com a próxima entrada, para fazer a predição seguinte.9

Contudo, a simplicidade conceitual das RNNs esconde uma limitação crítica conhecida como o problema do "desvanecimento ou explosão de gradientes" (vanishing/exploding gradients). Durante o treinamento, os gradientes do erro são propagados para trás através do tempo. Em sequências longas, esses gradientes podem diminuir exponencialmente até se tornarem nulos (desvanecimento) ou crescer exponencialmente até se tornarem excessivamente grandes (explosão). O resultado prático é que as RNNs padrão têm extrema dificuldade em aprender e reter informações de dependências de longo prazo, ou seja, conectar eventos que estão distantes um do outro na sequência.13

  

### 1.2 A Solução Gated: Long Short-Term Memory (LSTM) e GRU

A arquitetura Long Short-Term Memory (LSTM) foi introduzida como uma forma especializada e mais sofisticada de RNN, projetada explicitamente para mitigar o problema dos gradientes e capturar dependências de longo alcance.11 O segredo de seu sucesso reside em uma estrutura interna mais complexa, baseada em um "estado de célula" e um "mecanismo de portões" (gating mechanism).

O estado da célula atua como uma via expressa de informação, percorrendo toda a sequência com mínimas interações lineares, o que permite que a informação flua inalterada. O fluxo de informação para dentro e para fora do estado da célula é regulado por três portões, que são redes neurais que aprendem a controlar a passagem de informação 11:

1. Portão de Esquecimento (Forget Gate): Decide qual informação do estado da célula anterior deve ser descartada.
    
2. Portão de Entrada (Input Gate): Decide quais novas informações da entrada atual devem ser armazenadas no estado da célula.
    
3. Portão de Saída (Output Gate): Decide qual parte do estado da célula será usada para gerar a saída (o estado oculto) no passo de tempo atual.
    

Essa arquitetura permite que a rede aprenda a reter seletivamente informações relevantes por longos períodos, tornando-a excepcionalmente poderosa para uma vasta gama de tarefas sequenciais. A Gated Recurrent Unit (GRU) é uma variação mais recente e simplificada da LSTM, que combina os portões de esquecimento e entrada em um único "portão de atualização" e possui menos parâmetros, muitas vezes alcançando desempenho comparável com maior eficiência computacional.6 A robustez e a capacidade comprovada das LSTMs as tornaram um componente central ou uma forte linha de base em inúmeros estudos recentes, desde a previsão de consumo de energia 10 e volatilidade financeira 16 até sua combinação com outras arquiteturas como as Redes Neurais Convolucionais (CNNs).13

  

## 2. A Revolução dos Transformers e o Mecanismo de Atenção
### 2.1 Superando a Recorrência: O Poder do Processamento Paralelo
A introdução da arquitetura Transformer em 2017 por Vaswani e colaboradores marcou uma mudança de paradigma na modelagem de sequências. Diferentemente das RNNs e LSTMs, que processam os dados de forma inerentemente sequencial, o Transformer abandona completamente a recorrência.11 Essa mudança fundamental permite que o modelo processe todos os elementos de uma sequência de entrada simultaneamente, uma característica que se alinha perfeitamente com a natureza paralela das modernas unidades de processamento gráfico (GPUs). O resultado é uma aceleração drástica nos tempos de treinamento e a capacidade de lidar com sequências muito mais longas do que era prático com modelos recorrentes.6

  

### 2.2 O Coração do Transformer: Mecanismo de Auto-Atenção (Self-Attention)

  

O componente central que permite ao Transformer operar sem recorrência é o mecanismo de auto-atenção. Em vez de depender de um estado oculto que agrega informações passo a passo, a auto-atenção permite que o modelo avalie a importância de todos os outros elementos da sequência ao processar um único elemento. Para cada elemento, o modelo calcula um conjunto de pontuações de "atenção" que determinam o quanto ele deve "prestar atenção" a cada um dos outros elementos. A representação de cada elemento é então atualizada como uma soma ponderada das representações de todos os elementos, onde os pesos são essas pontuações de atenção.6

Isso permite a captura direta de dependências globais, independentemente da distância entre os elementos na sequência. Enquanto uma LSTM precisa passar a informação passo a passo, arriscando perdê-la ao longo do caminho, a auto-atenção pode, em teoria, conectar o primeiro e o último elemento de uma sequência com a mesma facilidade.
### 2.3 Arquitetura Encoder-Decoder e Codificações Posicionais
A arquitetura canônica do Transformer consiste em um encoder e um decoder. O encoder processa a sequência de entrada e gera uma representação rica e contextualizada. O decoder, por sua vez, utiliza essa representação para gerar a sequência de saída.11

Uma vez que o mecanismo de auto-atenção é, por si só, invariante à permutação (ele não tem uma noção inerente da ordem dos elementos), uma peça crucial da arquitetura são as codificações posicionais (positional encodings). Trata-se de vetores que contêm informação sobre a posição de cada elemento na sequência. Esses vetores são adicionados às representações de entrada dos elementos, "injetando" na rede a informação sobre a ordem sequencial que, de outra forma, estaria ausente.19

O sucesso retumbante do Transformer original levou a uma rápida proliferação de modelos derivados, como Autoformer, Informer e Reformer, que se tornaram o estado da arte em muitas tarefas e são frequentemente utilizados como benchmarks em estudos comparativos.16

  

## 3. Aplicações em Previsão de Séries Temporais: Padrões no Tempo
A aplicação de modelos de deep learning à previsão de séries temporais revelou uma paisagem complexa e cheia de nuances, onde não existe uma única arquitetura dominante para todas as tarefas. A euforia inicial em torno dos Transformers, por exemplo, foi temperada por evidências empíricas que destacam a contínua relevância e, em alguns casos, superioridade de modelos baseados em LSTM e até mesmo de abordagens mais simples. Uma análise mais profunda dos resultados da pesquisa revela que a escolha do modelo ideal não é uma questão de "LSTM vs. Transformer", mas sim uma função da natureza específica dos dados e do problema em questão.

Estudos comparativos mostram que, embora os Transformers possam ter uma vantagem marginal na previsão de valores absolutos, como o preço de uma ação, os modelos LSTM demonstram ser mais robustos e superiores na previsão de sequências diferenciais, como a variação do preço de um dia para o outro — uma tarefa frequentemente mais útil para estratégias de negociação.20 Além disso, pesquisas como a de Zeng et al. (2022) demonstraram que modelos lineares simples podem, em certas condições de previsão de longo prazo, superar Transformers sofisticados, um lembrete do princípio do "Não Existe Almoço Grátis" na aprendizagem de máquina.16

Essa realidade impulsionou uma tendência em direção à hibridização inteligente. Em vez de buscar um "algoritmo mestre", os pesquisadores estão combinando as forças complementares de diferentes modelos. Abordagens como GARCH-LSTM e CNN-LSTM não são fusões aleatórias; são projetos deliberados que integram o rigor estatístico (GARCH) ou a capacidade de extração de características espaciais (CNN) com o poder de modelagem temporal da LSTM. A fronteira da previsão de séries temporais reside, portanto, na seleção de modelos baseada em princípios e na criação de sistemas híbridos que são mais precisos, interpretáveis e confiáveis do que as abordagens monolíticas.

### 3.1 Previsão em Mercados Financeiros e Econômicos
#### 3.1.1 Modelando a Volatilidade com Híbridos Estatístico-Neurais
A previsão da volatilidade financeira é uma tarefa notoriamente difícil, mas crucial. O modelo GARCH-LSTM surge como uma solução híbrida exemplar para este problema.16 Os modelos da família GARCH são o padrão-ouro em econometria para modelar "fatos estilizados" dos retornos financeiros, como o agrupamento de volatilidade (períodos de alta volatilidade tendem a ser seguidos por mais alta volatilidade). A inovação do GARCH-LSTM é desenvolver uma contraparte de rede neural do GARCH e integrá-la diretamente na arquitetura de uma LSTM. Esta abordagem "infunde perfeitamente os fatos estilizados da volatilidade" na rede neural, combinando o melhor de dois mundos.16 Os resultados experimentais validam essa fusão, mostrando que o modelo híbrido alcança uma precisão de previsão superior em comparação com o uso isolado de GARCH ou LSTM. Além disso, ele oferece um benefício crucial de interpretabilidade e confiança, pois se baseia em um modelo (GARCH) que já é bem compreendido e confiável pelos profissionais do mercado.16

  

#### 3.1.2 LSTM vs. Transformer na Previsão de Ações

  

A competição entre arquiteturas é evidente na previsão de preços de ações. Estudos comparativos mostram que a arquitetura Transformer consistentemente supera os modelos LSTM e GRU em vários horizontes de tempo, especialmente quando aprimorada com engenharia de características, como a inclusão de indicadores técnicos.6 Isso sugere que a capacidade do Transformer de processar informações globalmente lhe permite alavancar de forma mais eficaz dados adicionais. No entanto, como mencionado, essa superioridade não é absoluta. Outros estudos apontam que os LSTMs são mais consistentes e precisos para prever sequências diferenciais, que capturam a dinâmica de mudança do mercado.20 A escolha da arquitetura, portanto, depende se o objetivo é prever o nível do preço ou sua variação. Além disso, a previsão pode ser aprimorada pela incorporação de dados exógenos, como o sentimento extraído de notícias financeiras, o que demonstra que a sequência de preços por si só pode não conter toda a informação preditiva necessária.21

  

### 3.2 Modelagem de Sistemas Ambientais e Energéticos

  
  

#### 3.2.1 Híbridos CNN-LSTM para Captura Espaço-Temporal

  

A previsão de emissões de carbono é um problema complexo que envolve dependências tanto temporais quanto espaciais. Um estudo notável utilizou um modelo híbrido LSTM-CNN para prever as emissões de carbono em 30 províncias da China.13 A lógica por trás dessa arquitetura é clara: a Rede Neural Convolucional (CNN) é usada para extrair características espaciais dos dados (por exemplo, a relação entre províncias vizinhas), enquanto a LSTM modela a evolução dessas características ao longo do tempo.14 A inovação chave deste trabalho foi a incorporação de

pesos espaciais para levar em conta explicitamente a autocorrelação espacial (o fato de que as emissões de uma província influenciam as de suas vizinhas), o que melhorou significativamente o desempenho do modelo.13 A utilidade prática do modelo foi demonstrada por suas previsões de que a maioria das províncias chinesas poderia atingir o pico de emissões de carbono antes de 2030 sob cenários de desenvolvimento específicos.13

  

#### 3.2.2 Comparando Arquiteturas para Previsão de Consumo de Energia

  

No domínio das redes elétricas inteligentes (smart grids), a previsão precisa do consumo de energia é vital para a eficiência e sustentabilidade. Uma análise comparativa dos modelos RNN, LSTM e Transformer foi realizada usando dados reais de consumo de energia e meteorologia de Bolonha, Itália.10 Os resultados mostraram que o modelo LSTM demonstrou um desempenho superior, com o menor Erro Quadrático Médio (MSE) e a maior métrica R², indicando sua notável capacidade de capturar as dependências temporais neste conjunto de dados específico.10 Embora o Transformer também tenha apresentado um desempenho robusto, destacando seu potencial para capturar dependências de longo alcance, a superioridade da LSTM neste caso reforça a ideia de que o melhor modelo é dependente dos dados. Este estudo também ressaltou a importância crítica do pré-processamento de dados e da engenharia de características (como a inclusão de dados meteorológicos e variáveis baseadas em tempo) para o sucesso de qualquer modelo preditivo.10

  

## 4. A Nova Fronteira: Análise Preditiva de Sequências Biológicas

  

O campo da análise de sequências biológicas, particularmente a predição da estrutura de proteínas, passou por uma série de revoluções sucessivas e rápidas, cada uma redefinindo a fronteira do que é computacionalmente possível. A história recente deste campo não é a de um progresso linear, mas sim a de saltos quânticos onde a solução para um problema de primeira ordem imediatamente revela um novo conjunto de desafios, mais complexos e de segunda ordem.

A primeira revolução foi liderada pelo AlphaFold2. Seu avanço não foi simplesmente usar deep learning, mas sim aplicar de forma genial uma arquitetura baseada em Transformer (o Evoformer) para raciocinar sobre dados de coevolução extraídos de Alinhamentos de Múltiplas Sequências (MSAs).23 Foi a fusão de um princípio biológico fundamental (resíduos que interagem fisicamente tendem a coevoluir) com uma técnica de inteligência artificial de ponta (o mecanismo de atenção). Esta foi a era da IA dominando a homologia biológica, resolvendo o problema de 50 anos do enovelamento de proteínas estáticas.

No entanto, essa solução criou seu próprio gargalo: uma forte dependência de MSAs de alta qualidade, limitando a velocidade e a aplicabilidade a proteínas sem homólogos conhecidos (proteínas órfãs).26 Isso preparou o terreno para a segunda revolução, impulsionada pelos Modelos de Linguagem de Proteínas (pLMs) como o

ESMFold.26 Ao serem treinados em centenas de milhões de sequências, esses modelos aprenderam a "linguagem" intrínseca das proteínas, permitindo a predição da estrutura a partir de uma

única sequência, desvinculando a predição da necessidade de homologia explícita.

O sucesso dessas duas revoluções expôs imediatamente o que elas não podiam fazer: prever a dinâmica das proteínas, os efeitos funcionais de mutações ou suas interações com outras moléculas como DNA, RNA e pequenos ligantes.32 Esta é a nova fronteira. O desenvolvimento do

AlphaFold 3, que visa explicitamente prever essas interações complexas, é a resposta direta a essa fronteira em movimento.35 A trajetória da análise preditiva em biologia é, portanto, uma história de avanço contínuo, movendo-se da sequência para a estrutura estática, e agora da estrutura estática para a modelagem de sistemas funcionais, dinâmicos e multimoleculares.

  

### 4.1 O Desafio Histórico da Predição da Estrutura de Proteínas

  

O problema do enovelamento de proteínas, formalizado pela hipótese termodinâmica de Anfinsen, postula que a sequência linear de aminoácidos de uma proteína dita sua estrutura tridimensional única e funcional.23 Por décadas, prever essa estrutura a partir da sequência foi considerado um "grande desafio" da biologia, pois o espaço de possíveis conformações é astronomicamente vasto, tornando a busca por força bruta inviável.38 Métodos computacionais anteriores, como a modelagem por homologia, dependiam da existência de uma proteína homóloga com estrutura já conhecida e, embora úteis, deixaram uma enorme lacuna entre os bilhões de sequências de proteínas conhecidas e as poucas centenas de milhares de estruturas determinadas experimentalmente.24

  

### 4.2 AlphaFold: A Convergência de Deep Learning e Dados Evolutivos

  
  

#### 4.2.1 A Arquitetura do AlphaFold2

  

A performance do AlphaFold2 na 14ª edição do Critical Assessment of protein Structure Prediction (CASP14) foi descrita como um "avanço espantoso", alcançando precisão atômica em muitos casos e superando drasticamente todos os outros métodos.23 A arquitetura do modelo utiliza dois fluxos de informação principais como entrada: um Alinhamento de Múltiplas Sequências (MSA) de sequências homólogas e moldes estruturais (

templates) de proteínas relacionadas, quando disponíveis.24

O coração do AlphaFold2 é um módulo de rede neural baseado em atenção chamado "Evoformer". Este módulo refina iterativamente as representações tanto do MSA (informação evolutiva) quanto de uma matriz de distâncias par-a-par entre os resíduos (informação espacial). Crucialmente, o Evoformer permite que esses dois fluxos de informação "conversem" e se informem mutuamente, integrando a lógica evolutiva com restrições geométricas.23 Ao final do processo, um módulo de estrutura prevê diretamente as coordenadas 3D de todos os átomos pesados da proteína.24

  

#### 4.2.2 Impacto e Democratização da Biologia Estrutural

  

O impacto do AlphaFold2 foi imediato e profundo. A precisão de suas previsões é, em muitos casos, comparável à de métodos experimentais como a cristalografia de raios-X.23 Talvez ainda mais significativo tenha sido o lançamento do AlphaFold Protein Structure Database, uma colaboração que disponibilizou gratuitamente centenas de milhões de estruturas preditas para a comunidade científica. Este ato representou uma democratização massiva do conhecimento estrutural, colocando ferramentas de ponta nas mãos de pesquisadores em todo o mundo.35 Na descoberta de fármacos, o AlphaFold2 acelerou drasticamente a identificação de alvos terapêuticos e permitiu o design de drogas baseado em estrutura para proteínas cuja estrutura era anteriormente desconhecida, abrindo novos caminhos para o tratamento de doenças.38

  

### 4.3 ESMFold e a Ascensão dos Modelos de Linguagem de Proteínas (pLMs)

  
  

#### 4.3.1 O Paradigma da Linguagem

  

Os Modelos de Linguagem de Proteínas (pLMs) representam uma abordagem conceitualmente diferente. Traçando uma analogia com modelos de linguagem natural (NLP) como o BERT, os pLMs são treinados em bancos de dados massivos contendo centenas de milhões ou bilhões de sequências de proteínas. A tarefa de treinamento é tipicamente auto-supervisionada, como prever aminoácidos que foram artificialmente "mascarados" em uma sequência.29 Ao realizar essa tarefa em uma escala evolutiva, o modelo é forçado a aprender a "gramática" e a "semântica" estatística das sequências de proteínas. As representações internas que o modelo aprende capturam implicitamente informações profundas sobre a estrutura e a função da proteína, sem nunca ter sido treinado explicitamente com dados estruturais.30

  

#### 4.3.2 ESMFold: Predição Ultrarrápida a Partir de Sequência Única

  

O ESMFold é um modelo que capitaliza o poder dos pLMs. Ele utiliza as representações ricas geradas por um pLM massivo (o ESM-2) para prever a estrutura tridimensional de uma proteína diretamente a partir de sua sequência de aminoácidos única.26 A principal vantagem desta abordagem é a velocidade. Ao eliminar a necessidade da busca por MSAs, que consome muito tempo, o ESMFold é ordens de magnitude mais rápido (até 60 vezes) que o AlphaFold2.29 Essa velocidade tornou-o a ferramenta ideal para explorar domínios onde os MSAs são escassos ou inexistentes, como proteínas órfãs, proteínas sintéticas e o vasto e inexplorado universo da metagenômica. O ESM Metagenomic Atlas, com suas centenas de milhões de estruturas preditas, é um testemunho direto dessa capacidade.31

  

#### 4.3.3 Comparando os Paradigmas: Coevolução vs. Linguagem

  

Os dois modelos representam paradigmas distintos e complementares. O AlphaFold2 pode ser visto como um especialista em interpretar profundamente a informação evolutiva extrínseca, contida nos alinhamentos de múltiplas sequências. O ESMFold, por outro lado, é um mestre em decifrar a informação intrínseca contida na própria linguagem das sequências de proteínas. Em termos práticos, o AlphaFold2 tende a ser marginalmente mais preciso para proteínas com MSAs ricos e bem estabelecidos, enquanto o ESMFold é dramaticamente mais rápido e, muitas vezes, a única opção viável para proteínas sem homólogos conhecidos.26

  

## 5. Análise Crítica, Desafios Atuais e Perspectivas Futuras

  

A rápida evolução dos métodos preditivos para sequências, tanto em séries temporais quanto em biologia, revela um campo dinâmico que, apesar dos sucessos notáveis, enfrenta desafios significativos e se move em direção a fronteiras cada vez mais complexas.

  

### 5.1 Análise Comparativa de Arquiteturas (LSTM vs. Transformer) em Domínios Gerais

  

A análise dos resultados em múltiplos domínios reforça o princípio de que não há uma arquitetura universalmente superior.

- LSTMs: Continuam a ser altamente eficazes, especialmente em cenários onde seu viés indutivo sequencial é uma vantagem. Sua capacidade de modelar o fluxo de informação passo a passo as torna particularmente adequadas para tarefas onde a ordem temporal e o histórico recente são críticos, como na previsão de variações de preços financeiros.11
    
- Transformers: Seu poder reside na captura de dependências globais e na alta paralelização, o que os torna extremamente eficientes e potentes para uma vasta gama de tarefas. No entanto, seu desempenho pode ser inconsistente em dados ruidosos ou quando as dependências locais são mais importantes que as globais. Em alguns casos, podem ser superados por modelos mais simples ou especializados, dependendo do conjunto de dados e do horizonte de previsão.10
    
- Híbridos: A crescente proeminência de modelos híbridos, como GARCH-LSTM e CNN-LSTM, demonstra um amadurecimento do campo. Essas abordagens reconhecem que a combinação sinérgica das forças de diferentes arquiteturas (estatísticas, convolucionais, recorrentes) é frequentemente superior à dependência de um único modelo monolítico, levando a previsões mais precisas e robustas.10
    

  

### 5.2 Desafios na Predição de Estruturas Proteicas Pós-AlphaFold

  

O sucesso do AlphaFold e do ESMFold resolveu o problema da predição da estrutura estática, mas, ao fazê-lo, trouxe à tona uma série de desafios mais profundos, encapsulados na máxima de que "predição não é compreensão".

- Dinâmica e Múltiplas Conformaçōes: As proteínas são máquinas moleculares dinâmicas que frequentemente adotam múltiplas conformações para executar suas funções. Os modelos atuais preveem uma única estrutura estática de baixa energia, falhando em capturar essa flexibilidade essencial. Este é um dos maiores problemas não resolvidos na área.32
    
- Efeito de Mutações: Os modelos atuais não foram projetados para prever as consequências estruturais e funcionais de mutações pontuais. A capacidade de prever como uma única mudança de aminoácido afeta a estabilidade ou a função de uma proteína é crítica para a compreensão de doenças genéticas e o desenvolvimento de medicina personalizada, mas permanece um desafio.32
    
- Interações Multimoleculares: A biologia opera através de complexos. A predição de como as proteínas interagem entre si, com ácidos nucleicos (DNA/RNA) e com pequenas moléculas (ligantes), é a próxima fronteira. Embora o AlphaFold 3 represente o primeiro grande passo nessa direção, o problema é imensamente complexo devido à maior complexidade química e à relativa escassez de dados de treinamento para essas interações, especialmente para pares antígeno-anticorpo.32
    
- Limitações dos Dados de Treinamento: Os modelos são tão bons quanto os dados com os quais são treinados. O Protein Data Bank (PDB) é enviesado para proteínas que são estáveis e cristalizam bem. Isso limita o desempenho dos modelos em classes de proteínas sub-representadas, como proteínas intrinsecamente desordenadas (IDPs) e proteínas de membrana, que são biologicamente cruciais.23
    
- Interpretabilidade e Uso Correto: Um desafio social e científico significativo é o risco de uso indevido das previsões por não especialistas. É crucial que os usuários tratem as estruturas como hipóteses computacionais, e não como dados experimentais infalíveis, prestando atenção às métricas de confiança (como o pLDDT) e compreendendo as limitações inerentes dos modelos.33
    

  

### 5.3 O Futuro dos Métodos Preditivos para Sequências

  

As tendências atuais apontam para várias direções futuras promissoras:

- Modelos Maiores e Mais Gerais: A trajetória do ESM-2 (onde o escalonamento de 8 milhões para 15 bilhões de parâmetros melhorou o desempenho) 30 e o desenvolvimento do AlphaFold 3 37 indicam um movimento em direção a modelos de fundação cada vez maiores e mais generalizados, capazes de lidar com múltiplas tarefas (por exemplo, predição de estrutura e interação) dentro de um único framework.
    
- IA Explicável (XAI): À medida que esses modelos se tornam ferramentas indispensáveis na ciência e nas finanças, a demanda por interpretabilidade e transparência aumentará. Abordagens que podem explicar suas previsões, como a integração de modelos estatísticos no GARCH-LSTM 16, ou o desenvolvimento de novas técnicas de XAI, serão cruciais para a confiança e a validação.
    
- Integração de Dados Multimodais: O futuro da predição reside na capacidade de integrar dados de sequência com outras modalidades de informação. Em biologia, isso significa combinar sequências com dados experimentais de baixa resolução (como mapas de crio-microscopia eletrônica), dados funcionais (como expressão gênica) ou informação química (para ligantes).
    
- Rumo à Biologia de Sistemas Dinâmicos: O objetivo final é transcender as predições estáticas para modelar sistemas biológicos dinâmicos e interativos. Isso significa passar da predição da estrutura de um componente para a simulação de um processo celular, uma ambição que representa a verdadeira convergência da biologia computacional e da inteligência artificial.
    

  

## Conclusão

  

A jornada dos métodos preditivos para sequências na era do deep learning tem sido marcada por uma evolução notável e paralela em domínios aparentemente díspares. Em séries temporais, a transição das Redes Neurais Recorrentes e LSTMs, mestres das dependências temporais, para os Transformers, com sua atenção global e paralelismo, culminou em uma compreensão mais madura de que a hibridização inteligente, e não uma única arquitetura, muitas vezes produz os resultados mais robustos e confiáveis.

Na biologia, essa jornada foi ainda mais dramática. A revolução do AlphaFold, que dominou a informação de coevolução para resolver o problema do enovelamento de proteínas, foi rapidamente seguida pela revolução dos Modelos de Linguagem de Proteínas como o ESMFold, que aprenderam a linguagem intrínseca das sequências. Agora, a fronteira avança novamente com o AlphaFold 3, que busca prever não apenas estruturas isoladas, mas complexos moleculares dinâmicos e funcionais.

O insight central que emerge dessa análise dupla é que os avanços não "resolvem" a predição de forma definitiva. Em vez disso, eles elevam a natureza dos desafios que enfrentamos. A capacidade de prever com precisão uma estrutura estática ou um valor futuro nos força a confrontar a necessidade de compreender a dinâmica, a função, a interação e o sistema como um todo. A sinergia contínua entre a inovação algorítmica, o poder computacional exponencialmente crescente e a disponibilidade de conjuntos de dados em escala massiva garante que o campo da análise preditiva de sequências continuará a ser uma das áreas mais vibrantes e impactantes da investigação científica nas próximas décadas.

---

Nota sobre o Acesso aos Artigos: Conforme solicitado, informa-se que não foi possível obter os detalhes completos (citação, metodologia, etc.) para os seguintes artigos a partir das fontes fornecidas, pois o acesso era restrito ou as informações não estavam disponíveis nos documentos consultados:

- "From GARCH to Neural Network for Volatility Forecast" (arXiv:2402.06642v1).17
    
- "Evolutionary-scale prediction of atomic-level protein structure with a language model" por Lin et al. (Science, 2023).55
    
- "Deep Learning for Time Series Forecasting: A Survey" (arXiv:2503.10198v1).1
    

A tabela a seguir resume os artigos para os quais os dados puderam ser extraídos ou sintetizados.

  

### Apêndice A

  

Tabela A1: Sumário dos Artigos de Referência em Métodos Preditivos para Sequências (2021-2025)

  

|   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|
|ID do Artigo|Citação Completa|DOI|Metodologia Principal|Domínio de Aplicação|Principais Conclusões/Contribuições|Acesso|
|Jumper et al., 2021|Jumper, J., Evans, R., Pritzel, A. et al. Highly accurate protein structure prediction with AlphaFold. Nature 596, 583–589 (2021).|https://doi.org/10.1038/s41586-021-03819-2|Rede neural profunda (Evoformer, baseada em atenção) usando alinhamentos de múltiplas sequências (MSAs) para prever coordenadas atômicas 3D.|Predição de Estrutura de Proteínas|Alcançou precisão atômica comparável a métodos experimentais, resolvendo um grande desafio de 50 anos da biologia.|Restrito|
|Lin et al., 2023|Lin, Z., Akin, H., Rao, R. et al. Evolutionary-scale prediction of atomic-level protein structure with a language model. Science 379, 1123-1130 (2023).|https://doi.org/10.1126/science.ade2574|Modelo de linguagem de proteína (ESM-2) para prever a estrutura 3D diretamente de uma única sequência de aminoácidos, sem MSA.|Predição de Estrutura de Proteínas|Permite a predição de estruturas até 60x mais rápido que métodos baseados em MSA, viabilizando a análise em escala metagenômica.|Restrito|
|Han et al., 2023|Han, Z.; Cui, B.; Xu, L.; Wang, J.; Guo, Z. Coupling LSTM and CNN Neural Networks for Accurate Carbon Emission Prediction in 30 Chinese Provinces. Sustainability 2023, 15, 13934.|https://doi.org/10.3390/su151813934|Modelo combinado LSTM-CNN com pesos espaciais para capturar dependências temporais e espaciais.|Previsão de Emissões de Carbono|O modelo híbrido com pesos espaciais superou outros modelos; a maioria das províncias chinesas pode atingir o pico de carbono antes de 2030.|Aberto|
|Abubakar et al., 2024|Abubakar, J. A., Bujari, A., & Corradi, A. (2024). Advanced Forecasting Techniques for Smart Grids to Enhance Energy Efficiency and Sustainability. In GoodIT '24: International Conference on Information Technology for Social Good.|https://doi.org/10.1145/3677525.3678669|Análise comparativa de RNN, LSTM e Transformer para previsão de consumo de energia.|Previsão de Energia em Smart Grids|O modelo LSTM demonstrou desempenho superior, com menor erro e maior R², destacando sua eficácia na captura de dependências temporais.|Aberto|
|WJAETS, 2025|Time series forecasting in financial markets using deep learning models. World Journal of Advanced Engineering Technology and Sciences, 2025, 15(01), 709-719.|DOI não fornecido na fonte|Análise comparativa de ARIMA, LSTM, GRU e Transformer para previsão de preços de ações.|Previsão de Séries Temporais Financeiras|Modelos de deep learning, especialmente o Transformer, superam métodos tradicionais. O Transformer se destaca em todos os horizontes de tempo e condições de mercado.|Aberto|

#### Referências citadas

1. Deep Learning for Time Series Forecasting: A Survey - arXiv, acessado em junho 22, 2025, [https://arxiv.org/html/2503.10198v1](https://arxiv.org/html/2503.10198v1)
    
2. [2503.10198] Deep Learning for Time Series Forecasting: A Survey - arXiv, acessado em junho 22, 2025, [https://arxiv.org/abs/2503.10198](https://arxiv.org/abs/2503.10198)
    
3. Deep Learning Models for Time Series Forecasting: A Review - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/381970036_Deep_Learning_Models_for_Time_Series_Forecasting_A_Review](https://www.researchgate.net/publication/381970036_Deep_Learning_Models_for_Time_Series_Forecasting_A_Review)
    
4. PDF 1.07 M - Journal of Mathematics and Modeling in Finance, acessado em junho 22, 2025, [https://jmmf.atu.ac.ir/article_18671_e0c6b51659aba3765b1e0b22c6d5ba10.pdf](https://jmmf.atu.ac.ir/article_18671_e0c6b51659aba3765b1e0b22c6d5ba10.pdf)
    
5. Continual Deep Learning for Time Series Modeling - Semantic Scholar, acessado em junho 22, 2025, [https://pdfs.semanticscholar.org/97c0/376ff034b3975c3d807b586aec2d7ca878a8.pdf](https://pdfs.semanticscholar.org/97c0/376ff034b3975c3d807b586aec2d7ca878a8.pdf)
    
6. Time series forecasting in financial markets using deep learning ..., acessado em junho 22, 2025, [https://journalwjaets.com/sites/default/files/fulltext_pdf/WJAETS-2025-0167.pdf](https://journalwjaets.com/sites/default/files/fulltext_pdf/WJAETS-2025-0167.pdf)
    
7. Financial Time-Series Prediction Using Deep Learning - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/390423095_Financial_Time-Series_Prediction_Using_Deep_Learning](https://www.researchgate.net/publication/390423095_Financial_Time-Series_Prediction_Using_Deep_Learning)
    
8. Deep Learning Methods for Time Series Forecasting: A Comparative Review, acessado em junho 22, 2025, [https://ashpress.org/index.php/jcts/article/view/37](https://ashpress.org/index.php/jcts/article/view/37)
    
9. Forecasting Sales of Iraqi Dates Using Artificial Intelligence - Semantic Scholar, acessado em junho 22, 2025, [https://pdfs.semanticscholar.org/3ee8/1a41ad78f29e1939ef8e1892919cc122f72d.pdf](https://pdfs.semanticscholar.org/3ee8/1a41ad78f29e1939ef8e1892919cc122f72d.pdf)
    
10. (PDF) Advanced Forecasting Techniques for Smart Grids to Enhance Energy Efficiency and Sustainability - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/383748294_Advanced_Forecasting_Techniques_for_Smart_Grids_to_Enhance_Energy_Efficiency_and_Sustainability](https://www.researchgate.net/publication/383748294_Advanced_Forecasting_Techniques_for_Smart_Grids_to_Enhance_Energy_Efficiency_and_Sustainability)
    
11. Transformer vs. LSTM: 4 Key Differences and How to Choose - Kolena, acessado em junho 22, 2025, [https://www.kolena.com/guides/transformer-vs-lstm-4-key-differences-and-how-to-choose/](https://www.kolena.com/guides/transformer-vs-lstm-4-key-differences-and-how-to-choose/)
    
12. Sequence Models Compared: RNNs, LSTMs, GRUs, and Transformers - AIML.com, acessado em junho 22, 2025, [https://aiml.com/compare-the-different-sequence-models-rnn-lstm-gru-and-transformers/](https://aiml.com/compare-the-different-sequence-models-rnn-lstm-gru-and-transformers/)
    
13. Coupling LSTM and CNN Neural Networks for Accurate Carbon Emission Prediction in 30 Chinese Provinces - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/390975754_Coupling_LSTM_and_CNN_Neural_Networks_for_Accurate_Carbon_Emission_Prediction_in_30_Chinese_Provinces](https://www.researchgate.net/publication/390975754_Coupling_LSTM_and_CNN_Neural_Networks_for_Accurate_Carbon_Emission_Prediction_in_30_Chinese_Provinces)
    
14. Coupling LSTM and CNN Neural Networks for Accurate Carbon Emission Prediction in 30 Chinese Provinces - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2071-1050/15/18/13934](https://www.mdpi.com/2071-1050/15/18/13934)
    
15. LSTM versus Transformers: A Practical Comparison of Deep Learning Models for Trading Financial Instruments - SciTePress, acessado em junho 22, 2025, [https://www.scitepress.org/Papers/2024/129811/129811.pdf](https://www.scitepress.org/Papers/2024/129811/129811.pdf)
    
16. From GARCH to Neural Network for Volatility Forecast, acessado em junho 22, 2025, [https://ojs.aaai.org/index.php/AAAI/article/view/29643/31092](https://ojs.aaai.org/index.php/AAAI/article/view/29643/31092)
    
17. arxiv.org, acessado em junho 22, 2025, [https://arxiv.org/html/2402.06642v1](https://arxiv.org/html/2402.06642v1)
    
18. A CNN-LSTM based deep learning model with high accuracy and robustness for carbon price forecasting: A case of Shenzhen's carbon market in China - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/38266520/](https://pubmed.ncbi.nlm.nih.gov/38266520/)
    
19. Deep Learning for Time Series Forecasting: Advances and Open Problems - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2078-2489/14/11/598](https://www.mdpi.com/2078-2489/14/11/598)
    
20. Transformers versus LSTMs for electronic trading - OpenReview, acessado em junho 22, 2025, [https://openreview.net/forum?id=2L1OxhQCwS](https://openreview.net/forum?id=2L1OxhQCwS)
    
21. Explainable Machine Learning Exploiting News and Domain-Specific Lexicon for Stock Market Forecasting - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/349318992_Explainable_Machine_Learning_Exploiting_News_and_Domain-Specific_Lexicon_for_Stock_Market_Forecasting](https://www.researchgate.net/publication/349318992_Explainable_Machine_Learning_Exploiting_News_and_Domain-Specific_Lexicon_for_Stock_Market_Forecasting)
    
22. Coupling LSTM and CNN Neural Networks for Accurate Carbon Emission Prediction in 30 Chinese Provinces - IDEAS/RePEc, acessado em junho 22, 2025, [https://ideas.repec.org/a/gam/jsusta/v15y2023i18p13934-d1243471.html](https://ideas.repec.org/a/gam/jsusta/v15y2023i18p13934-d1243471.html)
    
23. Protein structure prediction by AlphaFold2: are attention and symmetries all you need?, acessado em junho 22, 2025, [https://journals.iucr.org/d/issues/2021/08/00/rr5212/index.html](https://journals.iucr.org/d/issues/2021/08/00/rr5212/index.html)
    
24. Highly accurate protein structure prediction with AlphaFold - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/34265844/](https://pubmed.ncbi.nlm.nih.gov/34265844/)
    
25. Highly accurate protein structure prediction with AlphaFold, acessado em junho 22, 2025, [https://dasher.wustl.edu/bio5357/readings/nature-596-583-21.pdf](https://dasher.wustl.edu/bio5357/readings/nature-596-583-21.pdf)
    
26. DeepProSite: structure-aware protein binding site prediction using ESMFold and pretrained language model | Bioinformatics | Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article/39/12/btad718/7453375](https://academic.oup.com/bioinformatics/article/39/12/btad718/7453375)
    
27. Single-sequence protein structure prediction by integrating protein language models - PNAS, acessado em junho 22, 2025, [https://www.pnas.org/doi/10.1073/pnas.2308788121](https://www.pnas.org/doi/10.1073/pnas.2308788121)
    
28. Unlocking the Secrets of Life: AI Protein Models Demystified - ML6, acessado em junho 22, 2025, [https://www.ml6.eu/blogpost/unlocking-the-secrets-of-life-ai-protein-models-demystified](https://www.ml6.eu/blogpost/unlocking-the-secrets-of-life-ai-protein-models-demystified)
    
29. ESMFold - Bohrium, acessado em junho 22, 2025, [https://bohrium.dp.tech/apps/esmfold](https://bohrium.dp.tech/apps/esmfold)
    
30. Evolutionary-scale prediction of atomic level protein structure with a language model - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2022.07.20.500902v2.full.pdf](https://www.biorxiv.org/content/10.1101/2022.07.20.500902v2.full.pdf)
    
31. ESM Metagenomic Atlas: The first view of the 'dark matter' of the protein universe - Meta AI, acessado em junho 22, 2025, [https://ai.meta.com/blog/protein-folding-esmfold-metagenomics/](https://ai.meta.com/blog/protein-folding-esmfold-metagenomics/)
    
32. Emerging frontiers in protein structure prediction following the AlphaFold revolution | Journal of The Royal Society Interface, acessado em junho 22, 2025, [https://royalsocietypublishing.org/doi/10.1098/rsif.2024.0886](https://royalsocietypublishing.org/doi/10.1098/rsif.2024.0886)
    
33. Protein structure prediction in the era of AI: Challenges and limitations when applying to in silico force spectroscopy - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9580946/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9580946/)
    
34. AlphaFold two years on: Validation and impact - PNAS, acessado em junho 22, 2025, [https://www.pnas.org/doi/10.1073/pnas.2315002121](https://www.pnas.org/doi/10.1073/pnas.2315002121)
    
35. AlphaFold - Wikipedia, acessado em junho 22, 2025, [https://en.wikipedia.org/wiki/AlphaFold](https://en.wikipedia.org/wiki/AlphaFold)
    
36. Google DeepMind AlphaFold-latest l What's different from previous AlphaFolds, how they differ, acessado em junho 22, 2025, [https://hyperlab.hits.ai/en/blog/google-deepmind-alphafoldlatest](https://hyperlab.hits.ai/en/blog/google-deepmind-alphafoldlatest)
    
37. AlphaFold 3 predicts the structure and interactions of all of life's molecules - Google Blog, acessado em junho 22, 2025, [https://blog.google/technology/ai/google-deepmind-isomorphic-alphafold-3-ai-model/](https://blog.google/technology/ai/google-deepmind-isomorphic-alphafold-3-ai-model/)
    
38. The Revolutionary Impact of AlphaFold on Drug Discovery: Decoding the Mystery of Protein Folding - Lindus Health, acessado em junho 22, 2025, [https://www.lindushealth.com/blog/the-revolutionary-impact-of-alphafold-on-drug-discovery-decoding-the-mystery-of-protein-folding](https://www.lindushealth.com/blog/the-revolutionary-impact-of-alphafold-on-drug-discovery-decoding-the-mystery-of-protein-folding)
    
39. Biophysics. Current status and future trends, acessado em junho 22, 2025, [https://digilib.nipne.ro/colectii/files/original/ddf70dd2cfc745ffa6879488d30381c86c13b9d6.pdf](https://digilib.nipne.ro/colectii/files/original/ddf70dd2cfc745ffa6879488d30381c86c13b9d6.pdf)
    
40. Deep learning for protein structure prediction and design—progress and applications | Molecular Systems Biology - EMBO Press, acessado em junho 22, 2025, [https://www.embopress.org/doi/10.1038/s44320-024-00016-x](https://www.embopress.org/doi/10.1038/s44320-024-00016-x)
    
41. AlphaFold—for predicting protein structures - Lasker Foundation, acessado em junho 22, 2025, [https://laskerfoundation.org/winners/alphafold-a-technology-for-predicting-protein-structures/](https://laskerfoundation.org/winners/alphafold-a-technology-for-predicting-protein-structures/)
    
42. Reflecting on DeepMind's AlphaFold artificial intelligence success – what's the real significance for protein folding research and drug discovery?, acessado em junho 22, 2025, [https://www.icr.ac.uk/research-and-discoveries/cancer-blogs/detail/the-drug-discoverer/reflecting-on-deepmind-s-alphafold-artificial-intelligence-success-what-s-the-real-significance-for-protein-folding-research-and-drug-discovery](https://www.icr.ac.uk/research-and-discoveries/cancer-blogs/detail/the-drug-discoverer/reflecting-on-deepmind-s-alphafold-artificial-intelligence-success-what-s-the-real-significance-for-protein-folding-research-and-drug-discovery)
    
43. Frequently asked questions - AlphaFold Protein Structure Database, acessado em junho 22, 2025, [https://alphafold.ebi.ac.uk/faq](https://alphafold.ebi.ac.uk/faq)
    
44. ACES: AlphaFold Protein Structure Prediction - High Performance Research Computing, acessado em junho 22, 2025, [https://hprc.tamu.edu/files/training/2025/Spring/ACES_AlphaFold_Protein_Structure_Prediction_2025_spring.pdf](https://hprc.tamu.edu/files/training/2025/Spring/ACES_AlphaFold_Protein_Structure_Prediction_2025_spring.pdf)
    
45. Boost medical discoveries with AlphaFold on Vertex AI | Google Cloud Blog, acessado em junho 22, 2025, [https://cloud.google.com/blog/topics/developers-practitioners/boost-medical-discoveries-alphafold-vertex-ai](https://cloud.google.com/blog/topics/developers-practitioners/boost-medical-discoveries-alphafold-vertex-ai)
    
46. What Does AlphaFold Mean for Drug Discovery? - GeeksforGeeks, acessado em junho 22, 2025, [https://www.geeksforgeeks.org/deep-learning/what-does-alphafold-mean-for-drug-discovery/](https://www.geeksforgeeks.org/deep-learning/what-does-alphafold-mean-for-drug-discovery/)
    
47. AlphaFold3: Revolutionizing drug discovery and development - Labiotech.eu, acessado em junho 22, 2025, [https://www.labiotech.eu/in-depth/alpha-fold-3-drug-discovery/](https://www.labiotech.eu/in-depth/alpha-fold-3-drug-discovery/)
    
48. Alphafold2 protein structure prediction : Implications for drug discovery - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC7614146/](https://pmc.ncbi.nlm.nih.gov/articles/PMC7614146/)
    
49. Predicting metal-binding proteins and structures through integration of evolutionary-scale and physics-based modeling - OSTI, acessado em junho 22, 2025, [https://www.osti.gov/pages/servlets/purl/2507436](https://www.osti.gov/pages/servlets/purl/2507436)
    
50. Genomic language model predicts protein co-regulation and function - OpenReview, acessado em junho 22, 2025, [https://openreview.net/pdf?id=DpbMk2KOOX](https://openreview.net/pdf?id=DpbMk2KOOX)
    
51. Accelerate protein structure prediction with the ESMFold language model on Amazon SageMaker | Artificial Intelligence and Machine Learning - AWS, acessado em junho 22, 2025, [https://aws.amazon.com/blogs/machine-learning/accelerate-protein-structure-prediction-with-the-esmfold-language-model-on-amazon-sagemaker/](https://aws.amazon.com/blogs/machine-learning/accelerate-protein-structure-prediction-with-the-esmfold-language-model-on-amazon-sagemaker/)
    
52. Evolutionary-scale prediction of atomic level protein structure with a language model - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2022.07.20.500902v3.full.pdf](https://www.biorxiv.org/content/10.1101/2022.07.20.500902v3.full.pdf)
    
53. ESM Metagenomic Atlas by Meta AI, acessado em junho 22, 2025, [https://esmatlas.com/about](https://esmatlas.com/about)
    
54. People are overestimating Alphafold and it's a problem : r/labrats - Reddit, acessado em junho 22, 2025, [https://www.reddit.com/r/labrats/comments/1b1l68p/people_are_overestimating_alphafold_and_its_a/](https://www.reddit.com/r/labrats/comments/1b1l68p/people_are_overestimating_alphafold_and_its_a/)
    
55. acessado em dezembro 31, 1969, [https://www.science.org/doi/10.1126/science.ade2574](https://www.science.org/doi/10.1126/science.ade2574)
    

**