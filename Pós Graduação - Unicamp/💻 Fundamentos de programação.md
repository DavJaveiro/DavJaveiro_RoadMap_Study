# Fundamentos da Programação na Era da Biologia Ômica: Uma Análise Didática Baseada em Pesquisas de Alto Impacto (2019-2025)

  
  

## Introdução
A biologia do século XXI é, inegavelmente, uma ciência de dados. Avanços transformadores em tecnologias de sequenciamento de nova geração (NGS), proteômica, metabolômica e outras abordagens "ômicas" geram volumes de dados biológicos em uma escala e complexidade sem precedentes.1 A capacidade de gerar dados superou em muito a capacidade de analisá-los manualmente, criando um desafio central para a ciência moderna: como transformar essa avalanche de informação bruta em conhecimento biológico acionável e hipóteses testáveis.2 A resposta a esse desafio reside no campo da bioinformática e da biologia computacional, disciplinas que se tornaram indispensáveis para a descoberta, diagnóstico e medicina personalizada.2

Este relatório postula que os "Fundamentos da Programação" — conceitos frequentemente relegados a cursos introdutórios de ciência da computação — não são meramente um conjunto de habilidades preliminares para biólogos. Pelo contrário, eles constituem a própria linguagem e a estrutura lógica através das quais a descoberta biológica moderna é articulada, executada e validada. O objetivo deste trabalho é demonstrar, utilizando exclusivamente como base artigos científicos de alto impacto publicados entre 2019 e 2025, que cada conceito fundamental da programação — desde os tipos de dados mais básicos e estruturas de controle, até a abstração, recursão e paradigmas algorítmicos complexos — encontra uma correspondência direta, sofisticada e indispensável nos métodos que estão atualmente revolucionando a biologia molecular.

A jornada através deste relatório será linear e didática, projetada para um público com sólida formação em ciências da vida, mas que busca aprofundar sua compreensão dos alicerces computacionais que impulsionam a pesquisa de ponta. A análise começará com o alicerce de toda a computação biológica: a representação de entidades da vida como dados que uma máquina pode manipular (Capítulo 1). Em seguida, explorará a lógica de controle que dita os fluxos de análise, espelhando o rigor de um protocolo experimental (Capítulo 2). O relatório então abordará como a complexidade é gerenciada através da abstração e do poderoso conceito de recursão, revelando sua manifestação moderna em sistemas de inteligência artificial (Capítulo 3). Finalmente, culminará em uma análise dos paradigmas algorítmicos que estão na vanguarda da resolução de problemas biológicos, desde a montagem de genomas até a predição da estrutura de proteínas e a análise de redes de interação complexas (Capítulo 4).

A compreensão desses fundamentos transcende a capacidade de desenvolver novas ferramentas computacionais. É, acima de tudo, essencial para utilizar criticamente as ferramentas existentes, interpretar seus resultados com discernimento, reconhecer suas limitações inerentes e, em última análise, garantir a robustez e a reprodutibilidade da ciência em uma era cada vez mais digital.5 Ao dissecar exemplos proeminentes como o AlphaFold, a análise de transcriptomas de célula única (scRNA-seq), a montagem de genomas e a análise de redes com Redes Neurais de Grafos (GNNs), este relatório visa iluminar a profunda e intrínseca conexão entre o código da computação e o código da vida.

  

## A Representação de Dados Biológicos: Tipos e Estruturas de Dados Fundamentais
A base de toda a biologia computacional reside em uma questão fundamental: como a informação complexa, analógica e tridimensional da vida pode ser traduzida em estruturas discretas e abstratas que um computador possa processar? A escolha de um tipo ou estrutura de dados não é uma mera conveniência técnica; ela é uma decisão epistemológica que define o escopo dos problemas que podem ser resolvidos e as perguntas que podem ser formuladas. Este capítulo explora como os blocos de construção da programação — de simples cadeias de caracteres a complexos grafos probabilísticos — são empregados para modelar a informação biológica em diferentes escalas de complexidade.

  

### A Linguagem da Vida como Cadeias de Caracteres (Strings) e Vetores Numéricos
A representação mais fundamental e onipresente de macromoléculas biológicas, como DNA, RNA e proteínas, é a de uma cadeia de caracteres, ou string. Formalmente, uma sequência de proteína de comprimento L é representada como s=(s1​,s2​,…,sL​), onde cada elemento si​ pertence ao conjunto A dos 20 aminoácidos padrão.8 De forma análoga, uma sequência de DNA utiliza um alfabeto de quatro caracteres,

A={A,C,G,T}. Essa abstração, que converte a molécula química em um objeto de dados discreto e linear, é a pedra angular sobre a qual algoritmos clássicos de alinhamento de sequências, busca de motivos e inúmeras outras análises textuais foram construídos.

Paralelamente, dados quantitativos, como os gerados em experimentos de alto rendimento, são armazenados como tipos de dados numéricos, como inteiros ou números de ponto flutuante. Na análise de sequenciamento de RNA de célula única (scRNA-seq), por exemplo, as contagens de transcritos, representadas por Identificadores Moleculares Únicos (UMIs), são armazenadas como vetores numéricos, onde cada elemento do vetor corresponde à contagem de um gene específico dentro de uma única célula.9 Essas representações lineares, embora simples, são a matéria-prima para análises estatísticas e de aprendizado de máquina.

  

### A Orquestração Celular em Matrizes e Tensores: O Caso do scRNA-seq e do AlphaFold
Quando a complexidade da questão biológica aumenta, passando da análise de uma única molécula para a de um sistema inteiro, as estruturas de dados lineares se tornam insuficientes. A análise de scRNA-seq exemplifica essa transição. Nela, a expressão gênica de milhares de células é organizada em uma matriz de contagem, uma estrutura de dados bidimensional onde, tipicamente, as linhas representam genes e as colunas representam células individuais.9 Esta matriz não é apenas uma coleção de vetores de expressão; ela é uma "fotografia" do estado transcricional de uma população celular heterogênea, permitindo a identificação de tipos celulares, estados de transição e a dinâmica do desenvolvimento ou da doença.11

A predição da estrutura de proteínas pelo AlphaFold representa um salto ainda maior na complexidade da representação de dados. O sistema não utiliza uma única matriz, mas um conjunto de estruturas de dados multidimensionais, ou tensores, que capturam diferentes facetas do problema simultaneamente. Os dados de entrada são processados para formar duas representações principais: um Alinhamento Múltiplo de Sequências (MSA), que pode ser visto como uma matriz de dimensões Nseq​×Nres​ (número de sequências alinhadas vs. número de resíduos), e uma representação de pares de resíduos, uma matriz de Nres​×Nres​ que codifica informações sobre as relações espaciais inferidas entre cada par de aminoácidos.12 O algoritmo RoseTTAFold, conceitualmente similar, formaliza essa ideia em uma arquitetura de "três trilhas", onde a informação flui e é transformada entre representações 1D (sequência), 2D (mapa de distâncias) e 3D (coordenadas atômicas).14 Essa abordagem tensorial permite que a rede neural "raciocine" coletivamente sobre a informação evolutiva, as restrições geométricas e a estrutura tridimensional emergente, uma capacidade que seria impossível com representações mais simples.12

  

### Modelando a Interconectividade Biológica: Grafos
Muitos sistemas biológicos são fundamentalmente redes de interações. A estrutura de dados mais natural e poderosa para modelar tais sistemas é o grafo. Um grafo consiste em um conjunto de nós (ou vértices), que representam entidades biológicas, e um conjunto de arestas (ou arcos), que representam as interações ou relações entre essas entidades.17

As aplicações são vastas e abrangem múltiplas escalas. Em nível molecular, uma proteína ou uma molécula de um fármaco pode ser representada como um grafo, onde os átomos são os nós e as ligações químicas são as arestas.17 Em nível celular, os grafos modelam redes de interação proteína-proteína (PPIs), redes de regulação gênica e vias metabólicas, permitindo a análise da função sistêmica e a identificação de alvos terapêuticos.17 Na genômica, algoritmos de montagem

de novo constroem grafos de sobreposição ou de De Bruijn, onde os nós são as leituras de sequenciamento (ou subsequências chamadas k-mers) e as arestas representam sobreposições. A tarefa de montar o genoma se traduz, então, no problema computacional de encontrar um caminho que percorra esse grafo da maneira mais parcimoniosa.22

O poder dos grafos reside em sua capacidade de representar dados "não-Euclideanos" — dados cuja topologia e relações são mais importantes do que uma estrutura de grade rígida, como a de uma imagem.18 Essa mudança de paradigma na representação de dados foi um pré-requisito fundamental para a aplicação de uma classe inteira de algoritmos de aprendizado de máquina, notadamente as Redes Neurais de Grafos (GNNs), que estão impulsionando novas descobertas na predição de função proteica e na descoberta de fármacos.17

  

### Estruturas de Dados Probabilísticas: O Modelo Oculto de Markov de Perfil (pHMM)
A representação de dados biológicos muitas vezes precisa ir além de simplesmente armazenar valores, para também capturar a incerteza e a variabilidade inerentes aos dados. O algoritmo Apollo, projetado para "polir" ou corrigir erros em montagens de genoma, exemplifica essa necessidade através do uso de uma estrutura de dados probabilística: o Modelo Oculto de Markov de Perfil (pHMM).26

O Apollo modela cada contig (fragmento montado do genoma) não como uma simples string, mas como um pHMM. Esta estrutura, que é em si um tipo de grafo, consiste em estados (estados de correspondência, que representam uma base no contig; e estados de inserção, para lidar com bases extras nas leituras) e transições direcionadas entre esses estados. Crucialmente, tanto os estados quanto as transições possuem probabilidades associadas: a probabilidade de emitir um determinado caractere (A, C, G ou T) em um estado de correspondência, e a probabilidade de transitar de um estado para outro.26 O pHMM, portanto, não representa uma única sequência, mas um modelo estatístico de uma família de sequências alinhadas, capturando a probabilidade de substituições, inserções e deleções em cada posição. Essa representação probabilística é o que permite que algoritmos como o de Viterbi (discutido no Capítulo 4) naveguem pelo espaço de possibilidades e determinem a sequência "verdadeira" mais provável, dadas as evidências ruidosas fornecidas pelas leituras de sequenciamento.

A progressão das estruturas de dados utilizadas na bioinformática espelha diretamente a crescente sofisticação da nossa compreensão dos sistemas biológicos. A jornada de representações lineares (uma string para um gene) para representações tabulares (uma matriz para um transcriptoma), e daí para representações relacionais (um grafo para uma rede de interação) e probabilísticas (um pHMM para um contig ruidoso), não é apenas um avanço técnico. É uma reformulação fundamental dos problemas biológicos, passando da análise de componentes isolados para a investigação de sistemas complexos, interconectados e inerentemente estocásticos. A estrutura de dados escolhida não é meramente um contêiner passivo; ela é a própria formulação do problema computacional e, como tal, predefine o universo de soluções algorítmicas possíveis. A revolução do aprendizado profundo em grafos, por exemplo, só se tornou possível após a adoção generalizada de grafos como uma representação primária para dados biológicos. Isso sugere que a próxima grande revolução algorítmica na biologia será, muito provavelmente, precedida por uma nova revolução na forma como representamos a informação da vida.

  

## Lógica e Controle de Fluxo em Algoritmos Bioinformáticos

  

Se as estruturas de dados são os substantivos da programação — as entidades sobre as quais operamos —, as estruturas de controle de fluxo são os verbos. Elas ditam a ação, a lógica e o processo sequencial que transforma dados brutos em insights. Este capítulo demonstra como os construtos mais simples de controle de fluxo — repetição (loops) e desvio (condicionais) — formam a espinha dorsal da análise bioinformática, permitindo o processamento em larga escala, a filtragem rigorosa e a tomada de decisões lógicas que espelham o próprio método científico. Em essência, um pipeline bioinformático pode ser visto como a digitalização de um protocolo de laboratório, onde cada loop e cada condicional correspondem a um passo metodológico que um cientista realizaria.

  

### A Força da Repetição: Processamento em Larga Escala com Estruturas de Loop
A natureza dos dados "ômicos" é a sua escala massiva. A análise desses dados envolve, inerentemente, a aplicação repetida de uma mesma operação a milhões ou bilhões de elementos de dados. As estruturas de repetição, como os laços for e while, são o mecanismo computacional que torna essa análise de alto rendimento (high-throughput) viável.

Por exemplo, no polimento de montagens de genoma, o algoritmo Apollo itera sobre cada alinhamento de uma leitura de sequenciamento ao contig genômico. Dentro deste loop, ele executa o complexo processo de treinamento do modelo pHMM para aquela região específica, atualizando as probabilidades com base na evidência daquela leitura.26 Sem um

loop para processar sistematicamente cada uma das dezenas de milhares de leituras que cobrem um contig, a correção seria impossível.

De forma similar, na análise de scRNA-seq, os loops são onipresentes. Um pipeline típico irá iterar sobre cada célula (coluna) na matriz de contagem para calcular métricas de controle de qualidade, como a porcentagem de genes mitocondriais ou o número total de genes detectados. Em seguida, outro loop pode iterar sobre cada gene (linha) para filtrar aqueles que são expressos em um número muito baixo de células, removendo assim o ruído técnico.9

O paradigma de message passing (passagem de mensagens), central para as Redes Neurais de Grafos (GNNs), é fundamentalmente um processo iterativo. Por um número pré-definido de passos T (correspondendo ao número de camadas da rede), o algoritmo executa um loop. Em cada iteração t, ele atualiza o estado de cada nó no grafo agregando informações ("mensagens") de seus vizinhos no passo anterior, t−1.27 Esta repetição é o que permite que a informação se propague através da rede, permitindo que um nó "aprenda" sobre seu contexto topológico mais amplo.

  

### A Lógica da Descoberta: Tomada de Decisão com Estruturas de Desvio
A ciência é um processo de tomada de decisão baseado em evidências. As estruturas de desvio condicional, como as declarações if-then-else, são a implementação computacional dessa lógica. Elas traduzem heurísticas, limiares estatísticos e critérios de validação em operações executáveis, permitindo que um algoritmo navegue por diferentes caminhos de análise com base nas características dos dados.

Os pipelines de análise de scRNA-seq dependem fortemente de condicionais para o controle de qualidade. Por exemplo, um pipeline implementa a regra: SE (if) a contagem de genes de uma célula for menor que 200 OU (or) SE a porcentagem de transcritos mitocondriais for maior que 20%, ENTÃO (then) remova esta célula da análise. Da mesma forma, ferramentas como o Scrublet calculam uma pontuação de doublet (duas células capturadas como uma) para cada evento, e o pipeline aplica um condicional: SE a pontuação for maior que um limiar (e.g., 0.25), ENTÃO marque a célula como um doublet a ser removido.9

Na validação de montagens genômicas, o algoritmo CloseRead varre as sequências alinhadas e usa condicionais para identificar erros. SE um nucleotídeo na leitura não corresponde perfeitamente ao nucleotídeo na montagem, ENTÃO ele é sinalizado como um mismatch. SE uma região da montagem não tem leituras alinhadas, ENTÃO ela é sinalizada como uma quebra de cobertura (break).7 Essas decisões lógicas são cruciais para avaliar a qualidade de genomas recém-montados.

Mesmo em modelos de aprendizado profundo, a lógica condicional é vital para a interpretação dos resultados. O AlphaFold fornece uma métrica de confiança por resíduo, o pLDDT. Um pesquisador interpreta a estrutura usando uma lógica implícita: SE o pLDDT de uma região for baixo (e.g., < 70), ENTÃO a predição para essa região é provavelmente não confiável e pode ser desordenada. SENÃO SE (else if) o pLDDT for alto (e.g., > 90), ENTÃO a predição do esqueleto de carbono para essa região é provavelmente muito precisa.31 Essa tomada de decisão baseada em limiares é fundamental para o uso responsável do modelo.

A combinação de loops e condicionais forma o fluxo de controle que define a inteligência de um pipeline bioinformático. O fluxo lógico de um experimento de laboratório — com seus passos sequenciais, verificações de qualidade e pontos de decisão — é diretamente espelhado pela estrutura de controle do programa que o analisa. O if não é apenas um comando; é a implementação de um critério de validação. O for não é apenas um laço; é a automação de um processo repetitivo de medição ou análise. À medida que os pipelines se tornam cada vez mais complexos e automatizados, encapsulados em plataformas de software amigáveis 34, os cientistas podem interagir com eles sem escrever o código subjacente. Isso, no entanto, cria o risco de tratar a análise como uma "caixa-preta". A literacia computacional para biólogos, portanto, não deve se concentrar apenas em "como programar", mas em "como pensar algoritmicamente". A capacidade de decompor um

pipeline em seu fluxo lógico implícito — de entender os loops e os condicionais que governam seu comportamento — é fundamental para avaliar criticamente os resultados, diagnosticar falhas e garantir a transparência e reprodutibilidade da ciência computacional.

  

## Abstração, Modularidade e Recursão
À medida que os problemas biológicos e os conjuntos de dados se tornam mais complexos, a construção de soluções como um único bloco de código monolítico torna-se impraticável e insustentável. A engenharia de software e a ciência da computação desenvolveram princípios poderosos para gerenciar essa complexidade. Este capítulo explora dois dos mais importantes: a abstração, através de procedimentos e funções que promovem a modularidade; e a recursão, uma técnica elegante para resolver problemas que possuem uma subestrutura auto-similar ou que se beneficiam de refinamento iterativo. Veremos como esses princípios não são apenas teóricos, mas estão profundamente enraizados na arquitetura das ferramentas bioinformáticas mais avançadas da atualidade.

  

### O Poder da Abstração: Procedimentos e Funções em Pipelines Bioinformáticos
A abstração é a prática de esconder detalhes complexos de implementação por trás de uma interface simples. Em programação, a principal ferramenta para a abstração é o procedimento ou a função. Uma função encapsula uma tarefa específica (e.g., "alinhar duas sequências" ou "calcular a expressão diferencial") em uma unidade nomeada que pode ser chamada e reutilizada sem a necessidade de conhecer seu funcionamento interno.

As ferramentas de bioinformática modernas são exemplos claros de design modular baseado neste princípio. A plataforma OmicsBox, por exemplo, é dividida em módulos distintos para genômica, transcriptômica e análise de variação genética, onde cada módulo oferece um conjunto de funções específicas.37 Da mesma forma, a suíte de software da Illumina fornece ferramentas modulares para cada etapa do fluxo de trabalho de NGS, desde o gerenciamento de amostras e o controle do sequenciador até a análise secundária e a interpretação de dados.1 Essa modularidade permite que os pesquisadores construam

pipelines de análise complexos encadeando essas funções ou módulos como blocos de construção.34

O AlphaFold é um exemplo magistral de abstração e modularidade em um sistema de aprendizado de máquina. Sua arquitetura é decomposta em módulos funcionais claros: um módulo de entrada que busca em bancos de dados e constrói o MSA, o módulo principal de inferência (o "tronco" da rede, contendo o Evoformer) que processa as representações de MSA e de pares, e um módulo de estrutura que finalmente gera as coordenadas 3D.12 Cada um desses módulos é, em si, uma função imensamente complexa, mas sua separação lógica permite o desenvolvimento, teste e otimização independentes. Essa abordagem modular não apenas torna o sistema mais gerenciável, mas também mais compreensível.

  

### A Elegância da Recursão: Refinamento Iterativo e Hierarquias Biológicas
A recursão é uma abordagem de resolução de problemas onde a solução para um problema depende de soluções para instâncias menores do mesmo problema. Embora classicamente associada a estruturas de dados hierárquicas como árvores, sua essência conceitual encontrou uma nova e poderosa manifestação nos sistemas de IA modernos.

O exemplo mais proeminente e inovador de um processo conceitualmente recursivo é a "reciclagem" (recycling) no AlphaFold.12 Neste processo, a saída da rede neural — o MSA processado, a representação de pares e a estrutura 3D prevista — é realimentada como entrada para a mesma rede por um número fixo de iterações. Cada iteração usa a predição anterior como um "template" aprimorado para gerar uma nova predição, mais refinada. Embora implementada como um

loop iterativo por razões de eficiência, a lógica é inerentemente recursiva: a função PreverEstrutura na iteração N+1 é chamada com a saída da iteração N, ou seja, PredicaoN+1​=Rede(PredicaoN​). Estudos demonstram que este processo de refinamento iterativo é crucial para a alta acurácia do modelo, permitindo que ele escape de mínimos locais e convirja para uma solução de maior qualidade, especialmente em casos difíceis.39

Este conceito de "reciclagem" pode ser contrastado com a aplicação mais clássica da recursão na bioinformática, como na reconstrução de árvores filogenéticas. Uma árvore filogenética é uma estrutura de dados inerentemente recursiva: uma árvore é uma raiz conectada a um conjunto de sub-árvores. Muitos algoritmos de reconstrução exploram essa propriedade. Por exemplo, um algoritmo de agrupamento hierárquico pode, recursivamente, encontrar o par de sub-árvores mais próximo (com base em uma matriz de distância), fundi-las em um novo nó (uma nova sub-árvore) e, em seguida, resolver o problema para o conjunto reduzido de sub-árvores até que reste apenas uma árvore completa.41 Outros algoritmos usam travessias recursivas (pós-ordem ou pré-ordem) para calcular eficientemente as verossimilhanças de diferentes topologias de árvores.42 Nesses casos, a recursão decompõe o problema em partes espacialmente ou hierarquicamente menores.

O processo de "reciclagem" do AlphaFold representa uma forma distinta e poderosa de pensamento recursivo, que pode ser denominada "recursão de hipótese". Diferente da recursão clássica que decompõe um problema em partes menores (como a reconstrução de uma árvore a partir de sub-árvores), a reciclagem refina iterativamente uma solução holística. A complexidade do problema (prever a estrutura inteira) permanece a mesma em cada passo; o que muda é a qualidade da informação de entrada, que é a própria hipótese gerada no passo anterior.

Este paradigma espelha notavelmente o próprio método científico: um cientista propõe uma hipótese inicial (Modelo 1). Essa hipótese é usada para interpretar dados, o que gera novos insights que permitem o refinamento da hipótese para o Modelo 2. O Modelo 2, por sua vez, é usado para reinterpretar os dados, e o ciclo continua. A reciclagem do AlphaFold automatiza e acelera vertiginosamente este ciclo de refinamento de hipóteses. A descoberta de que este processo iterativo pode até mesmo revelar intermediários de enovelamento de proteínas experimentalmente conhecidos 43 reforça a ideia de que o algoritmo não está apenas otimizando uma pontuação matemática, mas explorando um "espaço conformacional" biofísico que a rede aprendeu. Esta implicação é profunda: sugere que os futuros sistemas de IA para a ciência podem evoluir de "calculadoras de respostas" para "parceiros de raciocínio" iterativos, capazes de gerar, criticar e refinar suas próprias soluções de uma forma que imita, e talvez um dia aprimore, a própria descoberta humana.

  

## Paradigmas Algorítmicos na Fronteira da Biologia Computacional
Os paradigmas algorítmicos são estratégias gerais e de alto nível para resolver classes de problemas, unindo as estruturas de dados e o controle de fluxo em abordagens coesas. Na biologia computacional, a escolha do paradigma correto é crucial para decifrar os quebra-cabeças mais complexos, desde a reconstrução do livro da vida a partir de fragmentos até a predição da forma funcional das máquinas moleculares que o executam. Este capítulo examina como paradigmas clássicos e emergentes — programação dinâmica, algoritmos em grafos e aprendizado de máquina — são aplicados na vanguarda da pesquisa biológica.

  

### Otimização Sequencial: Programação Dinâmica no Polimento de Genomas

  

A programação dinâmica é um paradigma poderoso para resolver problemas de otimização que podem ser decompostos em subproblemas mais simples e sobrepostos. Sua aplicação canônica na bioinformática é o alinhamento de sequências, mas sua utilidade se estende a outros problemas sequenciais.

O algoritmo de Viterbi, que constitui o núcleo da etapa de decodificação do polidor de montagem Apollo, é um exemplo clássico de programação dinâmica.26 Após o Apollo ter construído e treinado um Modelo Oculto de Markov de Perfil (pHMM) para um contig genômico, o desafio é encontrar a sequência de bases (o "caminho" através dos estados do pHMM) que é mais provável, dadas as probabilidades aprendidas a partir das leituras de sequenciamento. O Viterbi resolve isso de forma eficiente, construindo a solução ótima de forma incremental. Ele calcula o caminho mais provável até a posição

i na sequência, baseando-se na solução já conhecida para a posição i−1. Ao armazenar e reutilizar as soluções dos subproblemas, ele evita o recálculo exponencial que uma busca ingênua exigiria, garantindo a descoberta do consenso globalmente mais provável.26

  

### Navegando em Redes Biológicas: Algoritmos em Grafos e Message Passing
Com a crescente compreensão de que a biologia opera através de redes complexas, os algoritmos em grafos tornaram-se centrais. A ascensão das Redes Neurais de Grafos (GNNs) na bioinformática é uma consequência direta dessa percepção.17 O paradigma algorítmico que impulsiona as GNNs é a

Passagem de Mensagens (Message Passing).

Este é um paradigma iterativo onde os nós em um grafo atualizam suas próprias representações (vetores de características, ou embeddings) agregando informações, ou "mensagens", de seus vizinhos na rede.27 O processo geral, que ocorre em cada camada da GNN, pode ser definido por duas funções aprendidas: uma

função de mensagem (Mt​), que define qual informação um nó vizinho envia, e uma função de atualização (Ut​), que define como um nó combina as mensagens recebidas com sua própria representação anterior para criar sua nova representação.30 Ao repetir este processo por múltiplas camadas, a informação se propaga através do grafo, permitindo que a representação de um nó seja influenciada por vizinhos a múltiplas "distâncias" de aresta. Este paradigma permite que o modelo aprenda características que dependem intrinsecamente da topologia da rede, sendo fundamental para tarefas como prever a função de uma proteína com base em seus parceiros de interação, identificar novos alvos para fármacos ou integrar dados multi-ômicos em um único framework analítico.18

  

### Aprendizado de Máquina como um Paradigma Algorítmico Emergente
Tradicionalmente, um algoritmo é um conjunto de regras explícitas projetadas por um humano para resolver um problema. O aprendizado profundo (deep learning), exemplificado pelo AlphaFold, introduz um novo paradigma algorítmico: em vez de o humano projetar o algoritmo, ele projeta uma arquitetura de aprendizado e um processo de treinamento que permitem ao sistema aprender seu próprio algoritmo a partir de dados.3

O núcleo do AlphaFold, a rede neural Evoformer, não contém regras codificadas sobre as forças de van der Waals ou ligações de hidrogênio. Em vez disso, é uma arquitetura complexa, baseada em mecanismos de atenção, que aprende a integrar informações evolutivas (do MSA), físicas e geométricas (inferidas das relações de pares) para gerar uma estrutura 3D precisa.12 A "lógica" do algoritmo não é fixa; ela está contida nos milhões de pesos da rede neural, ajustados durante o treinamento em milhares de estruturas de proteínas conhecidas. Este paradigma de "algoritmo aprendido" tem se mostrado capaz de resolver problemas, como a predição de estrutura

ab initio, que eram considerados intratáveis por abordagens clássicas baseadas em física ou conhecimento.3 A capacidade demonstrada de "alucinar" novas proteínas estáveis que não existem na natureza é a prova máxima de que o sistema não está meramente memorizando, mas aprendeu princípios fundamentais da dobradura de proteínas.45

---

Tabela 4.1: Mapeamento de Algoritmos Bioinformáticos de Alto Impacto para Fundamentos de Programação

  

|   |   |   |   |   |
|---|---|---|---|---|
|Algoritmo/Método|Problema Biológico|Estrutura(s) de Dados Chave|Paradigma/Fundamento Ilustrado|Artigo de Referência Principal|
|Apollo|Polimento de montagem de genoma|Profile Hidden Markov Model (pHMM)|Programação Dinâmica (Algoritmo de Viterbi)|(FIRTINA; et al., 2020)|
|AlphaFold / RoseTTAFold|Predição de estrutura de proteína|Tensores (MSA, Pares), Coordenadas 3D|Recursão de Hipótese (Recycling), Deep Learning|(JUMPER; et al., 2021)|
|GNNs em Bioinformática|Predição de função/interação em redes|Grafo (Redes de interação, moléculas)|Algoritmos em Grafos (Message Passing)|(YI; et al., 2022)|
|CloseRead|Validação de montagem genômica|String, Vetores de Cobertura|Estruturas de Controle (Condicionais if-then)|(BANKEVICH; SAFONOVA, 2022)|
|Análise de scRNA-seq|Caracterização da heterogeneidade celular|Matriz (Contagem de UMI)|Estruturas de Controle (Loops for, Filtros if)|(LA Manno; et al., 2024)|

---

Uma análise mais profunda revela uma notável convergência conceitual entre esses paradigmas aparentemente distintos. A passagem de mensagens nas GNNs, a troca de informações entre as diferentes "trilhas" de representação no Evoformer/RoseTTAFold, e o processo de reciclagem no AlphaFold podem ser vistos como manifestações diferentes de um mesmo princípio subjacente: o refinamento iterativo de representações através da propagação de informação contextual.

Em uma GNN, um nó refina sua representação na camada l+1 ao receber contexto de seus vizinhos na camada l.30 A informação se propaga localmente através da topologia do grafo. No Evoformer, a representação do MSA é refinada ao receber contexto da representação de pares, e vice-versa, dentro de um mesmo bloco.12 A informação se propaga entre diferentes modalidades de representação (evolutiva e espacial). Na reciclagem, a predição inteira no passo

N+1 é refinada ao receber como contexto a predição global do passo N.12 A informação se propaga globalmente através do tempo computacional.

O sucesso desses modelos de ponta não reside em um único truque algorítmico, mas na criação de arquiteturas que facilitam um fluxo de informação rico e iterativo. O sistema continuamente se auto-corrige e enriquece suas representações internas, seja através de vizinhos em um grafo, de diferentes perspectivas sobre o mesmo problema, ou de suas próprias previsões passadas. Isso sugere que o futuro do projeto de algoritmos em IA para a ciência se concentrará menos em encontrar uma única função de mapeamento Entrada -> Saída e mais em projetar ecossistemas de informação dinâmicos, onde as representações são continuamente aprimoradas através de múltiplos canais de feedback. A programação do futuro pode ser menos sobre ditar uma lógica rígida e mais sobre orquestrar esses fluxos de informação.

  

## Conclusão e Perspectivas Futuras
Este relatório demonstrou que os fundamentos da programação não são um tópico preliminar ou isolado, mas sim o andaime conceitual e prático sobre o qual a biologia computacional moderna é construída. Através da análise de pesquisas de alto impacto publicadas entre 2019 e 2025, traçamos uma linha direta desde a representação de um gene como uma simples string até a concepção do AlphaFold como um sistema complexo que emprega tensores, modularidade e uma forma sofisticada de recursão. Cada conceito computacional — tipos de dados, estruturas de controle, abstração e paradigmas algorítmicos — encontra um análogo direto e poderoso na resolução dos problemas mais prementes da biologia molecular. A escolha de uma estrutura de dados define o problema, o controle de fluxo digitaliza a lógica experimental, a abstração gerencia a complexidade do sistema e os paradigmas algorítmicos impulsionam a fronteira da descoberta.

No entanto, o poder crescente e a abstração desses modelos trazem consigo desafios críticos. A ascensão de algoritmos de aprendizado profundo como o AlphaFold, que podem "alucinar" novas estruturas de proteínas 45 ou cujos processos de tomada de decisão internos não são totalmente transparentes, levanta o risco de uma ciência menos interpretável.33 A confiança cega em ferramentas "caixa-preta" sem uma compreensão de suas suposições e limitações fundamentais pode levar a conclusões errôneas.6 Portanto, a necessidade de validação experimental rigorosa e de uma compreensão profunda dos fundamentos computacionais por parte dos biólogos nunca foi tão crucial.

Olhando para o futuro, as tendências apontam para uma integração ainda mais profunda entre os paradigmas computacionais e os sistemas biológicos. A fronteira da pesquisa está se movendo em direção à criação de "gêmeos digitais" de células ou tecidos, onde múltiplos paradigmas algorítmicos são combinados em um único framework para simular processos biológicos complexos.49 Nesses sistemas, GNNs poderiam modelar as interações proteína-proteína, modelos baseados em atenção poderiam processar a informação genômica, e solucionadores de equações diferenciais poderiam simular a dinâmica temporal, todos operando em conjunto. Além disso, a crescente necessidade de treinar modelos em dados clínicos e genômicos sensíveis e distribuídos geograficamente impulsionará a adoção de abordagens como a

aprendizagem federada. Neste paradigma, o modelo é treinado localmente em cada fonte de dados, e apenas as atualizações do modelo — não os dados brutos — são compartilhadas com um servidor central, preservando a privacidade e a segurança.49 Isso representa uma mudança fundamental em como os procedimentos de treinamento (um tipo de algoritmo) são implementados, adaptando-se às realidades legais e éticas do mundo real. A programação na biologia do futuro será, cada vez mais, a arte de compor, treinar e validar esses sistemas complexos, distribuídos e multi-paradigmáticos, exigindo uma fluência ainda maior na linguagem fundamental da computação.

---

### Análise Final

  

Qual é o tema teórico subjacente?

O tema teórico subjacente que permeia este relatório é a Tese de Church-Turing manifestada no domínio biológico. Esta tese postula que qualquer função computável pode ser calculada por uma máquina de Turing, ou seja, por um algoritmo. O relatório demonstra, através de exemplos de ponta de 2019-2025, como a biologia computacional está progressivamente validando esta tese em uma escala cada vez mais complexa. Estamos nos movendo da modelagem de processos biológicos simples (e.g., encontrar um motivo em uma sequência) para a simulação de sistemas biológicos complexos (e.g., o enovelamento de uma proteína, a dinâmica de uma rede celular) e até mesmo para a modelagem do próprio processo de descoberta científica (como visto na "recursão de hipótese" do AlphaFold). O tema, portanto, é a crescente isomorfia entre a lógica da computação, expressa através dos fundamentos da programação, e a lógica da vida, revelando que os processos biológicos, em sua essência, são informacionais e, portanto, computáveis.

Qual(is) as principais técnica(s) foi(ram) utilizada(s)?

As principais técnicas metodológicas empregadas na elaboração deste relatório foram:

1. Análise Comparativa de Paradigmas: A técnica central foi a análise comparativa, que justapôs conceitos fundamentais da ciência da computação (tipos de dados, controle de fluxo, recursão, programação dinâmica) com suas implementações de vanguarda em diferentes domínios da bioinformática (genômica, proteômica, biologia de sistemas), conforme publicado em literatura de alto impacto.
    
2. Estudo de Caso Aprofundado: Foram utilizados estudos de caso de algoritmos e sistemas emblemáticos (AlphaFold, Apollo, GNNs) para dissecar e ilustrar esses fundamentos em ação, mostrando como os princípios teóricos se traduzem em soluções práticas para problemas biológicos concretos.
    
3. Síntese Interdisciplinar: A abordagem fundamental foi a síntese de conhecimento de dois campos distintos — ciência da computação teórica e biologia computacional aplicada — utilizando os artigos científicos como a ponte conceitual que conecta os dois domínios, garantindo rigor e relevância contemporânea.
    

Qual a contribuição do artigo para o conhecimento científico de um modo geral, reflexivo?

De uma perspectiva reflexiva, a contribuição deste relatório para o conhecimento científico é multifacetada:

1. Recontextualização Pedagógica: Ele recontextualiza o ensino dos fundamentos da programação para a era da biologia orientada por IA. Argumenta que, em vez de serem um currículo introdutório estático, esses fundamentos devem ser compreendidos como um conjunto dinâmico de ferramentas conceituais que co-evoluem com os desafios científicos. Ele oferece uma nova abordagem didática para cientistas da vida, ensinando computação não através de exemplos abstratos, mas através das ferramentas e problemas que definem a fronteira de sua própria área de pesquisa.
    
2. Promoção da Literacia Crítica: Ao desmistificar a arquitetura interna de ferramentas complexas como o AlphaFold, o relatório promove uma literacia computacional crítica. Ele capacita os pesquisadores a não serem meros usuários, mas avaliadores informados da tecnologia, cientes de suas premissas, capacidades e limitações, o que é essencial para a integridade e reprodutibilidade da ciência.
    
3. Contribuição à Filosofia da Ciência Computacional: O relatório contribui para a reflexão sobre a natureza da descoberta científica na era digital. Ele postula que o projeto de algoritmos e a arquitetura de modelos de IA, como o processo iterativo do AlphaFold, tornaram-se um modo primário de formulação e teste de hipóteses científicas. Isso sugere uma mudança fundamental na epistemologia da biologia, onde o próprio ato de programar e treinar um modelo se torna uma forma de investigação científica, transformando a computação de uma ferramenta de análise em um parceiro no processo de raciocínio e descoberta.
    

#### Referências citadas

1. Bioinformatics Software Tools | For genomic data management and interpretation - Illumina, acessado em junho 22, 2025, [https://www.illumina.com/informatics.html](https://www.illumina.com/informatics.html)
    
2. Computational Biology Industry 2025-2033 Trends: Unveiling Growth Opportunities and Competitor Dynamics, acessado em junho 22, 2025, [https://www.datainsightsmarket.com/reports/computational-biology-industry-9558](https://www.datainsightsmarket.com/reports/computational-biology-industry-9558)
    
3. Protein structure prediction via deep learning: an in-depth review - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/pharmacology/articles/10.3389/fphar.2025.1498662/full](https://www.frontiersin.org/journals/pharmacology/articles/10.3389/fphar.2025.1498662/full)
    
4. Definition of Bioinformatics - Applications, Subfields & Resources, acessado em junho 22, 2025, [https://www.healthcaredegree.com/faq/what-is-bioinformatics](https://www.healthcaredegree.com/faq/what-is-bioinformatics)
    
5. A bioinformatics-driven CURE extension increases student self-efficacy and interest in biomedical research | Journal of Microbiology & Biology Education, acessado em junho 22, 2025, [https://journals.asm.org/doi/10.1128/jmbe.00231-24](https://journals.asm.org/doi/10.1128/jmbe.00231-24)
    
6. Computational Biology: The Future of Cell Biology - Number Analytics, acessado em junho 22, 2025, [https://www.numberanalytics.com/blog/future-computational-biology-cell-biology](https://www.numberanalytics.com/blog/future-computational-biology-cell-biology)
    
7. Understanding us: Researchers apply algorithm to decode complex genome sequences, acessado em junho 22, 2025, [https://www.psu.edu/news/engineering/story/understanding-us-researchers-apply-algorithm-decode-complex-genome-sequences](https://www.psu.edu/news/engineering/story/understanding-us-researchers-apply-algorithm-decode-complex-genome-sequences)
    
8. Deep Learning for Protein Structure Prediction: Advancements in Structural Bioinformatics, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2023.04.26.538026v3.full-text](https://www.biorxiv.org/content/10.1101/2023.04.26.538026v3.full-text)
    
9. comprehensive analysis framework for evaluating commercial single ..., acessado em junho 22, 2025, [https://academic.oup.com/nar/article/53/2/gkae1186/7924191](https://academic.oup.com/nar/article/53/2/gkae1186/7924191)
    
10. Single‑cell RNA sequencing data dimensionality reduction (Review), acessado em junho 22, 2025, [https://www.spandidos-publications.com/10.3892/wasj.2025.315](https://www.spandidos-publications.com/10.3892/wasj.2025.315)
    
11. Single-cell RNA-seq analysis reveals the multi-step process of cellular senescence - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12138942/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12138942/)
    
12. Highly accurate protein structure prediction with AlphaFold, acessado em junho 22, 2025, [https://computingbiology.github.io/docs/alphafold2-jumper2021.pdf](https://computingbiology.github.io/docs/alphafold2-jumper2021.pdf)
    
13. Highly accurate protein structure prediction with AlphaFold - Qi Group@NIBS, acessado em junho 22, 2025, [http://qigroup.nibs.ac.cn/wp-content/uploads/2022/10/%E7%99%BD%E6%9D%BE%E9%9C%96-Highly-accurate-protein-structure-prediction-1.pdf](http://qigroup.nibs.ac.cn/wp-content/uploads/2022/10/%E7%99%BD%E6%9D%BE%E9%9C%96-Highly-accurate-protein-structure-prediction-1.pdf)
    
14. Accurate prediction of protein structures and interactions using a three-track neural network, acessado em junho 22, 2025, [https://www.osti.gov/biblio/2470900](https://www.osti.gov/biblio/2470900)
    
15. Accurate prediction of protein structures and interactions using a three-track neural network., acessado em junho 22, 2025, [https://www.repository.cam.ac.uk/items/2dfc089c-ea8d-4d27-b7cf-6da9dcd25d79](https://www.repository.cam.ac.uk/items/2dfc089c-ea8d-4d27-b7cf-6da9dcd25d79)
    
16. Accurate prediction of protein structures and interactions using a three-track neural network, acessado em junho 22, 2025, [https://www.ipd.uw.edu/wp-content/uploads/2021/07/Baek_etal_Science2021_RoseTTAFold.pdf](https://www.ipd.uw.edu/wp-content/uploads/2021/07/Baek_etal_Science2021_RoseTTAFold.pdf)
    
17. new graph learning approaches for exploring gene and protein function - Research Collection, acessado em junho 22, 2025, [https://www.research-collection.ethz.ch/bitstream/handle/20.500.11850/675454/Thesis_GiuliaMuzio.pdf?sequence=1&isAllowed=y](https://www.research-collection.ethz.ch/bitstream/handle/20.500.11850/675454/Thesis_GiuliaMuzio.pdf?sequence=1&isAllowed=y)
    
18. Graph representation learning in bioinformatics: trends, methods and applications, acessado em junho 22, 2025, [https://www.researchgate.net/publication/354327323_Graph_representation_learning_in_bioinformatics_trends_methods_and_applications](https://www.researchgate.net/publication/354327323_Graph_representation_learning_in_bioinformatics_trends_methods_and_applications)
    
19. Graph representation learning in bioinformatics: trends, methods ..., acessado em junho 22, 2025, [https://academic.oup.com/bib/article/23/1/bbab340/6361044](https://academic.oup.com/bib/article/23/1/bbab340/6361044)
    
20. Graph representation learning | BMBL - U.OSU, acessado em junho 22, 2025, [https://u.osu.edu/bmbl/resources/graph-representation-learning/](https://u.osu.edu/bmbl/resources/graph-representation-learning/)
    
21. Graph representation learning in bioinformatics: trends, methods and applications - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/bib/article-pdf/23/1/bbab340/42229638/bbab340.pdf](https://academic.oup.com/bib/article-pdf/23/1/bbab340/42229638/bbab340.pdf)
    
22. New algorithms for accurate and efficient de novo genome assembly from long DNA sequencing reads, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9946810/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9946810/)
    
23. New algorithms for accurate and efficient de novo genome assembly from long DNA sequencing reads | Life Science Alliance, acessado em junho 22, 2025, [https://www.life-science-alliance.org/content/6/5/e202201719](https://www.life-science-alliance.org/content/6/5/e202201719)
    
24. Graph representation learning in bioinformatics: trends, methods and applications - OUCI, acessado em junho 22, 2025, [https://ouci.dntb.gov.ua/en/works/9Qy63GJ9/](https://ouci.dntb.gov.ua/en/works/9Qy63GJ9/)
    
25. Graph representation learning in bioinformatics: trends, methods and applications - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/34471921/](https://pubmed.ncbi.nlm.nih.gov/34471921/)
    
26. Apollo: a sequencing-technology-independent, scalable and ..., acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article/36/12/3669/5804978](https://academic.oup.com/bioinformatics/article/36/12/3669/5804978)
    
27. arXiv:2302.02926v2 [cs.LG] 12 Mar 2024, acessado em junho 22, 2025, [https://arxiv.org/pdf/2302.02926](https://arxiv.org/pdf/2302.02926)
    
28. Neural Message Passing for Multi-Relational Ordered and Recursive Hypergraphs, acessado em junho 22, 2025, [https://proceedings.neurips.cc/paper/2020/file/217eedd1ba8c592db97d0dbe54c7adfc-Paper.pdf](https://proceedings.neurips.cc/paper/2020/file/217eedd1ba8c592db97d0dbe54c7adfc-Paper.pdf)
    
29. Graph-based deep learning for graphics classification - UAB, acessado em junho 22, 2025, [https://refbase.cvc.uab.es/files/RDL2017b.pdf](https://refbase.cvc.uab.es/files/RDL2017b.pdf)
    
30. Neural Message Passing for Quantum Chemistry - arXiv, acessado em junho 22, 2025, [https://arxiv.org/pdf/1704.01212](https://arxiv.org/pdf/1704.01212)
    
31. AlphaFold two years on: Validation and impact - PNAS, acessado em junho 22, 2025, [https://www.pnas.org/doi/10.1073/pnas.2315002121](https://www.pnas.org/doi/10.1073/pnas.2315002121)
    
32. Highly accurate protein structure prediction for the human proteome, acessado em junho 22, 2025, [https://storage.prod.researchhub.com/uploads/papers/2024/02/07/s41586-021-03828-1.pdf](https://storage.prod.researchhub.com/uploads/papers/2024/02/07/s41586-021-03828-1.pdf)
    
33. From AI Dream to Reality: Unfolding the Story of AlphaFold's Protein Predictions, acessado em junho 22, 2025, [https://www.biolifehealthcenter.com/post/from-ai-dream-to-reality-unfolding-the-story-of-alphafold-s-protein-predictions](https://www.biolifehealthcenter.com/post/from-ai-dream-to-reality-unfolding-the-story-of-alphafold-s-protein-predictions)
    
34. Cloud Pipeline: Genomic Data Analysis Software | EPAM SolutionsHub, acessado em junho 22, 2025, [https://solutionshub.epam.com/solution/cloud-pipeline](https://solutionshub.epam.com/solution/cloud-pipeline)
    
35. Geneious | Bioinformatics Software for Sequence Data Analysis, acessado em junho 22, 2025, [https://www.geneious.com/](https://www.geneious.com/)
    
36. Computational Systems Biology of Cancer - 8th edition - Institut Curie Advanced Training, acessado em junho 22, 2025, [https://training.institut-curie.org/courses/csbc2025](https://training.institut-curie.org/courses/csbc2025)
    
37. Top Genomics Data Analysis Software in 2025 - Slashdot, acessado em junho 22, 2025, [https://slashdot.org/software/genomics-data-analysis/](https://slashdot.org/software/genomics-data-analysis/)
    
38. AlphaFold2: A high-level overview | AlphaFold - EMBL-EBI, acessado em junho 22, 2025, [https://www.ebi.ac.uk/training/online/courses/alphafold/inputs-and-outputs/a-high-level-overview/](https://www.ebi.ac.uk/training/online/courses/alphafold/inputs-and-outputs/a-high-level-overview/)
    
39. De novo protein design by inversion of the AlphaFold structure prediction network - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10204179/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10204179/)
    
40. Improvement of protein tertiary and quaternary structure predictions using the ReFOLD4 refinement method and the AlphaFold2 recy - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2022.12.06.519289v1.full.pdf](https://www.biorxiv.org/content/10.1101/2022.12.06.519289v1.full.pdf)
    
41. A recursive algorithm for tree reconstruction from its generated quartet matrix. - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/figure/A-recursive-algorithm-for-tree-reconstruction-from-its-generated-quartet-matrix_fig2_220949011](https://www.researchgate.net/figure/A-recursive-algorithm-for-tree-reconstruction-from-its-generated-quartet-matrix_fig2_220949011)
    
42. TreeTime: Maximum-likelihood phylodynamic analysis | Virus Evolution | Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/ve/article/4/1/vex042/4794731](https://academic.oup.com/ve/article/4/1/vex042/4794731)
    
43. AlphaFold2 knows some protein folding principles - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2024.08.25.609581v1.full-text](https://www.biorxiv.org/content/10.1101/2024.08.25.609581v1.full-text)
    
44. Framelet Message Passing - KAUST Repository, acessado em junho 22, 2025, [https://repository.kaust.edu.sa/bitstreams/628cff46-95d0-4ec8-b988-7ad8bcfe67e4/download](https://repository.kaust.edu.sa/bitstreams/628cff46-95d0-4ec8-b988-7ad8bcfe67e4/download)
    
45. Deep Learning Generates New Protein Structures Using AI - Innovations Report, acessado em junho 22, 2025, [https://www.innovations-report.com/health-life/life-sciences/deep-learning-dreams-up-new-protein-structures/](https://www.innovations-report.com/health-life/life-sciences/deep-learning-dreams-up-new-protein-structures/)
    
46. Deep learning for protein structure prediction and design—progress and applications - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10912668/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10912668/)
    
47. Highly accurate protein structure prediction with AlphaFold - EconPapers, acessado em junho 22, 2025, [https://econpapers.repec.org/RePEc:nat:nature:v:596:y:2021:i:7873:d:10.1038_s41586-021-03819-2](https://econpapers.repec.org/RePEc:nat:nature:v:596:y:2021:i:7873:d:10.1038_s41586-021-03819-2)
    
48. Machine learning approaches to cryoEM density modification differentially affect biomacromolecule and ligand density quality - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/molecular-biosciences/articles/10.3389/fmolb.2024.1404885/full](https://www.frontiersin.org/journals/molecular-biosciences/articles/10.3389/fmolb.2024.1404885/full)
    
49. arXiv:2503.09649v2 [q-bio.OT] 2 May 2025, acessado em junho 22, 2025, [https://arxiv.org/pdf/2503.09649](https://arxiv.org/pdf/2503.09649)
    

**