# Análise de Algoritmos: Dos Fundamentos Teóricos às Fronteiras da Bioinformática

## Introdução
A Análise de Algoritmos constitui a disciplina fundamental que sustenta a ciência da computação moderna. Seu foco reside no desenvolvimento, análise e classificação de algoritmos — procedimentos passo a passo para a resolução de problemas — e no estudo dos recursos computacionais, como tempo e memória, que eles consomem.1 O objetivo primordial é projetar algoritmos ótimos, capazes de minimizar o uso de recursos enquanto garantem correção, escalabilidade e adaptabilidade a diversos cenários problemáticos.1 Este relatório serve como um "primer" acadêmico, introduzindo os conceitos essenciais de forma acessível para não especialistas, mas mantendo o rigor técnico necessário para contextualizar os avanços mais recentes, com um foco convergente na área da bioinformática.2

A eficiência de um algoritmo é quantificada através de sua complexidade. A complexidade de tempo é uma medida teórica que determina a quantidade de tempo que um algoritmo necessita para sua execução, enquanto a complexidade de espaço mede a quantidade de memória necessária.5 Para padronizar a descrição do comportamento de um algoritmo em relação ao tamanho de sua entrada (

N), utiliza-se a notação Big O. Essa notação descreve o limite superior do crescimento do tempo de execução ou do uso de espaço. Por exemplo, um algoritmo com complexidade $O(N)$ (linear) terá seu tempo de execução crescendo proporcionalmente ao tamanho da entrada. Outras classes comuns incluem $O(\log N)$ (logarítmica), $O(N \log N)$ (linearítmica) e $O(N^2)$ (quadrática), cada uma representando uma escala diferente de eficiência.5

No cerne da teoria da complexidade computacional reside uma das questões mais profundas e não resolvidas da ciência: o problema $P$ vs. $NP$.1 De maneira informal, a classe

$P$ (tempo polinomial) agrupa problemas que podem ser resolvidos rapidamente por um computador. A classe $NP$ (tempo polinomial não determinístico) agrupa problemas cujas soluções, uma vez fornecidas, podem ser verificadas rapidamente.6 A questão é se toda problema cuja solução pode ser verificada rapidamente também pode ser resolvido rapidamente, ou seja, se

$P = NP$. A crença majoritária entre os especialistas é que $P \neq NP$, o que implica a existência de uma classe de problemas que são inerentemente difíceis de resolver, embora suas soluções sejam fáceis de checar.6

Essa discussão teórica encontra um campo de aplicação prático e extremamente exigente na biologia moderna. Com a explosão de dados genômicos, proteômicos e de outras naturezas "ômicas", a bioinformática tornou-se um dos domínios mais férteis para o desenvolvimento e a aplicação de algoritmos avançados.8 Desafios computacionais de alta complexidade, como o alinhamento de sequências massivas, a predição da estrutura tridimensional de proteínas e a reconstrução de árvores filogenéticas com milhares de táxons, não apenas dependem de algoritmos eficientes, mas também impulsionam a fronteira da inovação algorítmica.9 Este relatório explorará essa jornada, partindo dos fundamentos da complexidade e convergindo para as soluções algorítmicas que estão revolucionando nossa compreensão dos sistemas vivos.

  

## Capítulo 1: Fundamentos da Complexidade Computacional e Paradigmas Algorítmicos Modernos

  
  

### 1.1 As Classes de Complexidade P, NP e NP-Completo: Uma Análise Detalhada

  

Para uma compreensão formal da dificuldade dos problemas computacionais, é essencial aprofundar as definições das classes de complexidade. Utilizando o modelo teórico da Máquina de Turing, a classe $P$ é definida como o conjunto de todos os problemas de decisão que podem ser resolvidos por uma Máquina de Turing determinística em tempo polinomial em relação ao tamanho da entrada.11 Essencialmente, são os problemas considerados "tratáveis" ou "eficientemente solucionáveis". A classe

$NP$, por sua vez, é o conjunto de problemas de decisão que podem ser resolvidos em tempo polinomial por uma Máquina de Turing não determinística — um modelo teórico que pode explorar todos os caminhos computacionais simultaneamente. Uma definição equivalente e mais intuitiva é que $NP$ contém todos os problemas para os quais uma dada solução (um "certificado") pode ser verificada como correta em tempo polinomial por uma máquina determinística.7

Dentro da classe $NP$, existe um subconjunto de problemas de particular interesse: os problemas $NP$-Completos. Um problema é $NP$-Completo se ele pertence a $NP$ e se todo outro problema em $NP$ pode ser reduzido a ele em tempo polinomial.11 Isso os posiciona como os problemas "mais difíceis" em

$NP$. A descoberta de um algoritmo de tempo polinomial para um único problema $NP$-Completo implicaria que todos os problemas em $NP$ poderiam ser resolvidos em tempo polinomial, provando assim que $P = NP$.11 Exemplos canônicos de problemas

$NP$-Completos incluem o Problema da Satisfatibilidade Booleana (SAT), o Problema do Caixeiro Viajante e o Problema da Clique.7

As implicações de uma potencial resolução de $P = NP$ seriam transformadoras. Por um lado, teria consequências devastadoras para a segurança digital, pois a criptografia de chave pública moderna, como o RSA, baseia-se na suposta dificuldade de problemas como a fatoração de inteiros grandes, um problema que se acredita estar em $NP$ mas não em $P$.11 Se

$P = NP$, esses sistemas criptográficos seriam quebrados. Por outro lado, uma prova construtiva de $P = NP$ revolucionaria campos como otimização, logística, pesquisa operacional, biologia computacional e inteligência artificial, fornecendo algoritmos eficientes para milhares de problemas práticos importantes que hoje são considerados intratáveis.7

  

### 1.2 A Lacuna entre Teoria e Prática e a Ascensão dos Métodos Preditivos

  

Apesar do rigor da teoria da complexidade, existe uma lacuna notória entre a análise teórica de pior caso e o desempenho de algoritmos em cenários do mundo real. Um exemplo clássico é o algoritmo Quicksort, cuja complexidade de tempo no pior caso é $O(N^2)$, mas que na prática exibe um desempenho médio de $O(N \log N)$ e é amplamente utilizado em bibliotecas padrão.16 Isso ilustra que a teoria formal, embora fundamental, nem sempre é um preditor perfeito do comportamento prático, especialmente porque a teoria da IA generativa, por exemplo, ainda não acompanhou a prática.16

Um reflexo dessa complexidade é o fato de que determinar a complexidade de tempo exata de um trecho de código arbitrário é um problema teoricamente indecidível.5 Em resposta a essa limitação teórica, surgiram abordagens pragmáticas que utilizam aprendizado profundo (

deep learning) para prever a complexidade do tempo do código. Pesquisas pioneiras, como o trabalho de Sikka et al. (2020), introduziram conjuntos de dados como o CorCoD e o CodeComplex, que consistem em trechos de código rotulados com suas classes de complexidade (por exemplo, $O(1)$, $O(N)$, $O(N \log N)$, $O(N^2)$, $O(2^N)$).5 Esses datasets permitem o treinamento de modelos de redes neurais para classificar automaticamente a complexidade de novos códigos.

Abordagens mais sofisticadas, como o TCProF, demonstram o potencial dessa linha de pesquisa. O TCProF utiliza um módulo de análise simbólica para analisar o código e gerar "pseudo-rótulos" de complexidade. Esses pseudo-rótulos, juntamente com técnicas de co-treinamento e aumento de dados, são usados para aprimorar a generalização e a robustez do modelo preditivo, tornando-o uma alternativa viável, especialmente em cenários com poucos dados rotulados disponíveis.5 Essa mudança de uma análise determinística para uma predição probabilística representa uma mudança de paradigma na forma como a eficiência algorítmica é avaliada na prática.

  

### 1.3 A Revolução do Aprendizado de Máquina: Uma Análise Comparativa

  

Os avanços mais impactantes na análise de dados complexos, particularmente na bioinformática, não surgiram de novas provas na teoria da complexidade fundamental, mas de uma revolução pragmática e heurística impulsionada pelo aprendizado de máquina (ML). A escolha do algoritmo correto é crucial e depende fundamentalmente do cenário, da qualidade e da natureza dos dados, sem que haja uma solução universal.17 Uma análise comparativa dos paradigmas de ML mais proeminentes entre 2019 e 2025 revela um espectro de ferramentas com diferentes pontos fortes e fracos.

- Algoritmos de ML Clássicos: Métodos como Máquinas de Vetores de Suporte (SVM) e Regressão Logística continuam a ser ferramentas robustas e eficazes, especialmente para tarefas de classificação bem definidas. Em estudos de anotação de tipos celulares em dados de sequenciamento de RNA de célula única (scRNA-seq), por exemplo, o SVM demonstrou desempenho superior a outras técnicas, identificando com precisão tanto populações celulares majoritárias quanto raras.18 Sua relativa simplicidade e interpretabilidade os tornam uma escolha sólida para dados de dimensionalidade mais baixa.
    
- Algoritmos de Deep Learning (DL): Redes neurais profundas, incluindo Redes Neurais Convolucionais (CNNs) e Recorrentes (RNNs), destacam-se por sua capacidade de aprender automaticamente representações de características a partir de dados brutos. Isso as torna extremamente poderosas para processar dados complexos e de alta dimensão, como imagens médicas ou sequências genômicas.10 No entanto, essa capacidade tem um custo: o processo de treinamento é complexo, exige grandes volumes de dados de alta qualidade para evitar overfitting e o custo computacional associado é significativamente alto.17
    
- Algoritmos de Ensemble Learning: Métodos como LightGBM e XGBoost operam combinando as predições de múltiplos modelos mais fracos (geralmente árvores de decisão) para criar um único modelo robusto. Essa abordagem frequentemente leva a uma maior precisão e estabilidade preditiva.17 Por exemplo, o LightGBM demonstra uma forte capacidade de minerar relações não lineares complexas em dados, embora possa apresentar instabilidade. Em contraste, modelos como o Prophet são excelentes para lidar com sazonalidade em séries temporais, mas carecem de adaptabilidade a mudanças complexas.17
    

Essa divergência entre a busca por garantias teóricas e a priorização do desempenho empírico mostra que a ciência computacional aplicada encontrou um caminho de sucesso em métodos heurísticos. Enquanto o problema $P$ vs. NPpermanece sem solução, avanços práticos em algoritmos e hardware permitem que problemasNP`-completos sejam abordados eficazmente na prática, um fenômeno que impulsiona os resultados transformadores observados na biologia computacional.7

Tabela 1: Comparativo de Paradigmas Algorítmicos Modernos

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|Paradigma Algorítmico|Exemplos de Algoritmos|Principais Vantagens|Principais Desvantagens|Cenários de Aplicação Típicos|Fontes|
|ML Clássico|SVM, Regressão Logística, Naive Bayes|Interpretabilidade, bom desempenho com menos dados, robustez.|Dificuldade com dados de alta dimensão e relações não lineares complexas.|Classificação de tipos celulares (scRNA-seq), dados tabulares.|18|
|Deep Learning (DL)|CNN, RNN, Transformers|Aprendizagem automática de características, alta performance em dados complexos (imagens, sequências).|Alto custo computacional, necessidade de grandes datasets, "caixa-preta" (baixa interpretabilidade).|Análise de imagens médicas, predição de estrutura de proteínas, genômica.|10|
|Ensemble Learning|XGBoost, LightGBM, Random Forest|Alta precisão e estabilidade, bom manejo de dados tabulares e não lineares.|Propenso a overfitting sem ajuste cuidadoso, pode ser computacionalmente intensivo.|Predição de churn de clientes, classificação de moléculas pequenas.|17|
|Heurísticas/Metaheurísticas|Algoritmos Genéticos, JADEDO|Flexibilidade para problemas de otimização complexos, bom equilíbrio entre exploração e explotação.|Ausência de garantia de otimalidade, sensibilidade a parâmetros.|Otimização de design, problemas de agendamento, seleção de características.|17|

  

## Capítulo 2: A Convergência para a Bioinformática: Montagem Genômica na Era das Leituras Longas

  
  

### 2.1 O Desafio da Reconstrução Genômica: Complexidade e Tecnologia

  

A montagem de novo de genomas de eucariotos complexos representa uma das tarefas mais formidáveis da biotecnologia e da bioinformática contemporâneas.21 A complexidade computacional do problema não reside apenas no tamanho dos genomas, que podem atingir gigabases, mas em suas características intrínsecas. Regiões de alta heterozigosidade, onde os dois alelos de um organismo diploide diferem significativamente, podem criar "bolhas" no grafo de montagem que confundem os algoritmos. Sequências altamente repetitivas, que compõem uma porção substancial de muitos genomas de plantas e animais, dificultam a determinação da ordem e orientação corretas dos fragmentos sequenciados. Adicionalmente, a poliploidia, a presença de mais de dois conjuntos de cromossomos, comum em plantas, eleva a complexidade a um novo patamar.22

A resolução desses desafios tem sido impulsionada por uma co-evolução simbiótica entre tecnologia de sequenciamento e desenvolvimento de algoritmos. A transição das tecnologias de sequenciamento de leituras curtas (NGS) para as de leituras longas, como as oferecidas pela Pacific Biosciences (PacBio) e Oxford Nanopore, foi um ponto de inflexão. Leituras longas, que podem abranger dezenas ou centenas de milhares de pares de bases, são capazes de atravessar a maioria das regiões repetitivas, simplificando drasticamente o quebra-cabeça da montagem. Em 2025, o padrão-ouro para a montagem de novos genomas de alta qualidade combina leituras longas de alta fidelidade (PacBio HiFi) com dados de captura de conformação cromossômica (Hi-C), que fornecem informações sobre a proximidade espacial de diferentes partes do genoma, auxiliando na organização dos fragmentos montados (contigs) em andaimes de escala cromossômica.23 Apesar desses avanços, a montagem completa de cromossomos de ponta a ponta (telômero a telômero) para genomas grandes e complexos permanece um objetivo desafiador.22

  

### 2.2 Análise de Algoritmos de Montagem (Assemblers): Otimizando o Paradigma OLC

  

A maioria dos montadores de genoma projetados para leituras longas implementa o paradigma Overlap-Layout-Consensus (OLC).21 Este processo de três etapas envolve: 1) identificar todas as sobreposições (

overlaps) entre as leituras de DNA; 2) organizar essas leituras em um layout que represente a ordem correta ao longo dos cromossomos, geralmente construindo um grafo de sobreposição; e 3) gerar a sequência de consenso final a partir do alinhamento das leituras no layout. A inovação algorítmica recente tem se concentrado em tornar cada uma dessas etapas mais eficiente e precisa.

Um estudo de caso detalhado, apresentado por Gonzalez-Garcia et al. (2023), revela otimizações cruciais no modelo OLC.21

- Fase de Overlap Eficiente: A etapa de identificação de sobreposições é um gargalo computacional. Uma busca por alinhamento exaustivo entre todos os pares de leituras teria uma complexidade quadrática, tornando-a impraticável para grandes conjuntos de dados. A inovação chave é o uso de um esquema de hashing baseado em k-mers (substrings de comprimento k). Este método permite a identificação de sobreposições candidatas em tempo linear ($O(N)$, onde $N$ é o número total de bases sequenciadas), uma redução drástica na complexidade.21 O algoritmo vai além, utilizando a distribuição de contagem de  
    k-mers para priorizar aqueles que provavelmente vêm de regiões de cópia única do genoma, conferindo maior peso a sobreposições mais confiáveis, sem descartar completamente a informação de regiões repetitivas.21
    
- Fase de Layout Robusta: A construção do layout é tratada como um problema de seleção de arestas em um grafo de sobreposição. O algoritmo primeiro identifica um conjunto de arestas "seguras" — aquelas que são as melhores correspondências recíprocas entre duas leituras e não estão em regiões excessivamente complexas do grafo. Em seguida, as arestas restantes são avaliadas com base em um custo probabilístico derivado de suas características (como comprimento da sobreposição e identidade do alinhamento), e são adicionadas ao layout de forma iterativa, evitando a criação de ciclos que representariam montagens incorretas.21
    
- Haplotipagem Integrada: Um avanço crucial nos montadores modernos é a capacidade de serem "cientes de diploidia" (diploid-aware). Ferramentas como o Hifiasm são projetadas para não apenas montar uma sequência de consenso, mas para separar (ou "fasar") as sequências provenientes dos dois haplótipos (os conjuntos de cromossomos herdados de cada genitor).23 Isso é fundamental para estudar a variação alélica, a expressão específica de alelos e a base genética de traços complexos.21
    

  

### 2.3 Validação Algorítmica: A Necessidade de Avaliação de Qualidade

  

A produção de uma montagem genômica não é o fim do processo; sua qualidade deve ser rigorosamente avaliada. A comunidade científica desenvolveu ferramentas para essa finalidade. Uma ferramenta notável, descrita em um protocolo da Nature Protocols de 2025, é o Inspector. Sua principal vantagem sobre as ferramentas existentes é a capacidade de realizar avaliações tanto com o auxílio de um genoma de referência (reference-guided) quanto sem referência (reference-free), o que é essencial ao sequenciar uma nova espécie. Além disso, o Inspector é projetado para detectar uma ampla gama de erros, desde pequenas inserções/deleções até erros estruturais de grande escala, como inversões ou translocações.24

DOI: 10.1038/s41596-025-01149-5.

Apesar dos enormes progressos, a montagem de genomas permanece um campo em ativo desenvolvimento. Não existe um único programa ou algoritmo definitivo que seja ótimo para todos os tipos de genomas. A escolha do montador mais adequado e de seus parâmetros continua a ser uma decisão crítica que depende das características específicas do genoma em estudo, como seu tamanho, nível de repetitividade e ploidia.23

  

## Capítulo 3: Além do Genoma Linear: A Era dos Grafos de Pangenoma

  
  

### 3.1 Superando o Viés do Genoma de Referência: A Necessidade do Pangenoma

  

A prática de usar um único genoma de referência de alta qualidade, embora tenha sido a espinha dorsal da genômica por décadas, possui uma limitação fundamental: ele introduz um viés de representação. Um genoma de um único indivíduo, ou mesmo um consenso de alguns, não pode capturar a totalidade da diversidade genética presente em uma população ou espécie inteira, que inclui variações estruturais, genes acessórios e sequências divergentes.25 Para superar essa limitação, a comunidade de bioinformática está se movendo em direção a um novo paradigma: o

pangenoma. Um pangenoma visa representar o repertório genômico completo de um grupo de organismos, integrando informações de sequência de múltiplos genomas em uma única e abrangente estrutura de referência.25 Um artigo de revisão na

Nature Genetics de 2025 destaca a importância dos grafos de pangenoma para a genômica da biodiversidade e conservação.25

DOI: 10.1038/s41588-024-02029-6.

  

### 3.2 Estruturas de Dados e Algoritmos para Grafos de Pangenoma

  

A estrutura de dados central que torna os pangenomas computacionalmente tratáveis é o grafo de variação. Nesta representação, as sequências de DNA que são compartilhadas ou únicas entre os genomas são armazenadas como nós. As arestas conectam esses nós para representar a adjacência das sequências nos genomas originais. Cada genoma individual pode, então, ser reconstruído como um caminho específico através do grafo.26 A construção e análise desses grafos exigem uma nova geração de algoritmos.

- Algoritmos de Construção:
    

- Baseados em Alinhamento: Métodos como o PanGenome Graph Builder (PGGB) e o Minigraph-Cactus dependem de alinhamentos de genoma completo para construir o grafo.26 Para lidar com a escala massiva desses cálculos, foram desenvolvidos pipelines como o  
    nf-core/pangenome. Implementado em Nextflow, ele otimiza o PGGB para ambientes de computação de alto desempenho (HPC), distribuindo as tarefas de alinhamento entre múltiplos nós do cluster e alcançando acelerações de duas a três vezes em comparação com a implementação original.26
    
- Livres de Alinhamento (Alignment-Free): Uma abordagem inovadora é apresentada pelo algoritmo AlfaPang. Ele constrói grafos de pangenoma sem a necessidade da custosa etapa de alinhamento de genoma completo. Em vez disso, ele opera diretamente sobre k-mers. Sua complexidade computacional é de $O(kN)$, onde $k$ é o comprimento do k-mer e $N$ é o tamanho total das sequências de entrada. Essa eficiência permite a construção de grafos a partir de grandes coleções de genomas com um uso significativamente menor de recursos computacionais em comparação com os métodos baseados em alinhamento.28 O código está disponível em:  
    [https://github.com/AdamCicherski/AlfaPang](https://github.com/AdamCicherski/AlfaPang).
    

- Algoritmos de Genotipagem: Uma vez construído o pangenoma, é necessário genotipar novas amostras em relação a ele. O Varigraph é uma ferramenta projetada para essa tarefa. Ele se destaca por sua capacidade de genotipar variantes pequenas (SNPs, indels) e grandes (variações estruturais) em genomas complexos, incluindo os de organismos poliploides. Sua principal inovação é uma abordagem baseada em k-mers que compara diretamente os k-mers presentes nas leituras de sequenciamento com os k-mers nos locais variantes do grafo, evitando a demorada etapa de alinhamento de leituras.29
    

  

### 3.3 O Desafio da Visualização e Análise em Larga Escala

  

A complexidade biológica capturada em um grafo de pangenoma, que pode conter milhões de nós e arestas, apresenta um novo desafio: como visualizá-lo e compreendê-lo?.27 Para resolver isso, a análise de algoritmos está novamente se movendo para um nível mais alto de abstração. O algoritmo

Path-Guided Stochastic Gradient Descent (PG-SGD) foi desenvolvido especificamente para criar layouts 2D ou 3D legíveis de grafos de pangenoma massivos.27 Sua inovação reside em usar os próprios caminhos (os genomas) dentro do grafo como um sistema de coordenadas implícito para guiar o processo de otimização do layout. Isso garante que a disposição espacial dos nós no layout final reflita as distâncias genômicas reais, preservando a informação biológica.27 Em testes comparativos, o PG-SGD demonstrou ser ordens de magnitude mais rápido e eficiente em termos de memória do que ferramentas de layout de grafos genéricas como o BandageNG.27

Essa progressão — da sequência linear ao grafo e, em seguida, a uma representação vetorial de baixa dimensão (o layout) — é um padrão poderoso. Ela demonstra como a bioinformática lida com a complexidade crescente ao criar abstrações matemáticas sucessivas. Cada camada de abstração torna o problema tratável para a próxima etapa de análise. De fato, o layout gerado pelo PG-SGD pode ser visto não apenas como uma visualização, mas como um embedding de grafo. Esse embedding converte o grafo esparso e de alta dimensão em um espaço vetorial denso e contínuo, abrindo a porta para a aplicação de uma vasta gama de algoritmos de aprendizado de máquina para tarefas como detecção de variantes estruturais, classificação de genomas ou correção de erros de montagem.27

Tabela 2: Análise Comparativa de Algoritmos de Genômica e Pangenômica

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|Algoritmo|Problema Principal|Abordagem Técnica Central|Complexidade Computacional (se disponível)|Principal Vantagem/Inovação|Fontes|
|Hifiasm|Montagem de Genoma|OLC (Overlap-Layout-Consensus) com grafos de string|Não especificada|Diploid-aware, capaz de fasar haplótipos.|23|
|NGSEP-assembler|Montagem de Genoma|OLC otimizado com hashing de k-mers|$O(N)$ para a fase de overlap|Hashing baseado em contagem de k-mers para eficiência.|21|
|nf-core/pangenome|Construção de Pangenoma|PGGB (baseado em alinhamento) em pipeline Nextflow|Não especificada|Escalabilidade para ambientes HPC, paralelização de alinhamentos.|26|
|AlfaPang|Construção de Pangenoma|Alignment-free baseado em k-mers|$O(kN)$|Alta eficiência de recursos (tempo e memória) por evitar alinhamentos.|28|
|Varigraph|Genotipagem em Pangenoma|Comparação de k-mers sem alinhamento de leituras|Não especificada|Rápido e eficiente, suporta genomas poliploides complexos.|29|
|PG-SGD|Visualização de Pangenoma|Stochastic Gradient Descent guiado por caminhos|Não especificada (mas mais rápido que alternativas)|Gera layouts biologicamente informativos para grafos massivos.|27|

  

## Capítulo 4: O Problema do Enovelamento de Proteínas e a Solução por Deep Learning

  
  

### 4.1 O Marco do AlphaFold: Um Salto Quântico na Predição Estrutural

  

Por mais de 50 anos, prever a estrutura tridimensional de uma proteína a partir de sua sequência de aminoácidos — o "problema do enovelamento de proteínas" — permaneceu como um dos maiores desafios da biologia.30 A determinação experimental de estruturas é um processo lento e caro, resultando em uma vasta lacuna entre o número de sequências de proteínas conhecidas e o número de estruturas resolvidas. Em 2020, o campo testemunhou um avanço revolucionário com a chegada do

AlphaFold2, um sistema de inteligência artificial desenvolvido pela DeepMind do Google. Pela primeira vez, um método computacional demonstrou a capacidade de prever estruturas de proteínas com precisão atômica, alcançando um desempenho competitivo com técnicas experimentais como a cristalografia de raios-X, mesmo para proteínas sem estruturas homólogas conhecidas que pudessem servir como moldes.30

O artigo seminal publicado na Nature em 2021 detalha o método e seus resultados impressionantes na 14ª Avaliação Crítica de Predição de Estrutura (CASP14), onde superou drasticamente todos os outros métodos (JUMPER et al., 2021). DOI: 10.1038/s41586-021-03819-2. O impacto foi imediato e profundo. A disponibilização pública das predições através do AlphaFold Protein Structure Database, um projeto colaborativo com o EMBL-EBI, expandiu a cobertura estrutural do espaço de sequências de proteínas de centenas de milhares para mais de 200 milhões de estruturas, democratizando o acesso à informação estrutural para pesquisadores em todo o mundo.32

  

### 4.2 Desvendando a Arquitetura do AlphaFold 2: Evoformer e IPA

  

O sucesso do AlphaFold não se deve apenas ao poder bruto do aprendizado profundo, mas a um design de arquitetura engenhoso que incorpora conhecimento fundamental de biologia e física como um viés indutivo. Isso restringe o espaço de busca do modelo e o guia para soluções fisicamente e biologicamente plausíveis. A arquitetura do AlphaFold 2 pode ser dividida em três componentes principais: um Input Embedder, o bloco Evoformer e o Structure Module.34

- Evoformer: Este bloco é o coração do sistema, projetado para raciocinar sobre as informações evolutivas e espaciais. Ele recebe duas representações como entrada: (1) um Alinhamento Múltiplo de Sequências (MSA), que captura padrões de conservação e co-evolução entre proteínas homólogas, e (2) uma representação de pares de resíduos, que codifica informações sobre quais aminoácidos estão próximos no espaço. O Evoformer é composto por uma série de blocos que utilizam mecanismos de atenção para permitir um fluxo de informação bidirecional: a informação do MSA refina a representação de pares, e a representação de pares, por sua vez, refina o MSA.31 Uma inovação crucial dentro do Evoformer é a  
    atenção triangular, onde a informação sobre a relação entre dois resíduos (i, j) é atualizada considerando a relação de cada um deles com um terceiro resíduo (k). Isso permite que o modelo raciocine sobre relações geométricas de forma implícita.34
    
- Structure Module e Invariant Point Attention (IPA): Após o processamento pelo Evoformer, as representações refinadas são passadas para o Structure Module, que gera a estrutura 3D explícita. O algoritmo central deste módulo é a Invariant Point Attention (IPA). IPA é um mecanismo de atenção especializado que opera diretamente sobre um conjunto de pontos 3D (os resíduos) e é projetado para ser inerentemente invariante a rotações e translações globais.36 Isso significa que o modelo não precisa aprender a partir dos dados a lei física fundamental de que a identidade de uma molécula não muda se ela for girada ou movida no espaço; essa propriedade é embutida na própria arquitetura do algoritmo. Esse viés indutivo geométrico acelera drasticamente o treinamento e melhora o desempenho geral do modelo.36 A implementação original do IPA tinha uma complexidade computacional e de memória quadrática em relação ao comprimento da sequência (  
    $O(L^2)$). Para lidar com proteínas muito grandes, uma versão otimizada chamada FlashIPA foi desenvolvida, alcançando uma complexidade linear ($O(L)$) ao alavancar algoritmos eficientes de hardware como o FlashAttention.36
    

  

### 4.3 A Próxima Geração: AlphaFold 3 e a Predição de Complexos Moleculares

  

Em maio de 2024, a DeepMind e a Isomorphic Labs anunciaram o AlphaFold 3, a próxima geração do sistema, que expande drasticamente o escopo da predição estrutural.39 Enquanto o AlphaFold 2 se concentrava em cadeias proteicas individuais, o AlphaFold 3 é capaz de prever com alta precisão a estrutura de

complexos moleculares que envolvem interações entre proteínas, DNA, RNA, pequenos ligantes e íons.39

A nova versão relata uma melhoria de pelo menos 50% na precisão para interações proteína-outra molécula em comparação com os métodos existentes, e o dobro da precisão para algumas categorias importantes de interação.39 A arquitetura do AlphaFold 3 refina o modelo Evoformer e introduz uma

rede de difusão no estágio final de geração da estrutura. Este modelo de difusão, análogo aos usados em IA para geração de imagens, começa com uma nuvem de átomos desordenada e a refina iterativamente até convergir para a estrutura final mais provável.40 Para facilitar o acesso da comunidade científica, a maioria das capacidades do AlphaFold 3 foi disponibilizada gratuitamente para uso não comercial através do

AlphaFold Server.39 Este avanço promete acelerar a descoberta de medicamentos, a genômica e a compreensão fundamental dos processos celulares, que dependem da intrincada dança das interações moleculares.

  

## Capítulo 5: Reconstruindo a Árvore da Vida com Novos Algoritmos Filogenéticos

  
  

### 5.1 Limitações dos Métodos Filogenéticos Clássicos

  

A inferência filogenética, a reconstrução da história evolutiva de genes, proteínas ou espécies, é uma tarefa central em biologia. Por décadas, o campo foi dominado por métodos estatísticos, principalmente a Máxima Verossimilhança (ML) e a Inferência Bayesiana (BI).42 Esses métodos avaliam diferentes topologias de árvores filogenéticas com base em um modelo explícito de substituição de nucleotídeos ou aminoácidos. Apesar de sua robustez teórica, eles enfrentam limitações significativas na era da genômica em larga escala. Primeiramente, eles dependem de modelos de substituição predefinidos (ex: HKY, GTR), que são simplificações da complexidade real do processo evolutivo e podem não se ajustar bem aos dados, levando a inferências imprecisas.42 Em segundo lugar, esses métodos têm grande dificuldade em modelar inserções e deleções (

indels), que são eventos evolutivos importantes. Na maioria dos casos, os indels são tratados como dados faltantes ou caracteres indeterminados, resultando na perda de informações evolutivas valiosas.42 Por fim, a busca exaustiva ou heurística pelo espaço de todas as árvores possíveis é computacionalmente intensiva, tornando a análise de grandes conjuntos de dados (com muitas sequências) proibitivamente lenta, especialmente para a Inferência Bayesiana.42

  

### 5.2 A Abordagem por Deep Learning: O Caso do Fusang

  

Em resposta a essas limitações, pesquisadores começaram a aplicar técnicas de aprendizado profundo à inferência filogenética. Um marco nessa área é o Fusang, descrito por Wang et al. (2023) como a primeira ferramenta baseada em DL projetada para aplicações práticas e diárias de inferência de árvores filogenéticas.42

DOI: 10.1093/nar/gkad805. Em vez de depender de um modelo evolutivo explícito, o Fusang utiliza uma rede neural para aprender os padrões complexos diretamente do alinhamento de múltiplas sequências (MSA).

A arquitetura do Fusang é notavelmente híbrida, combinando duas das mais poderosas classes de redes neurais para análise de sequências:

- Uma Rede Neural Convolucional (CNN) é usada para extrair características filogenéticas locais e posicionais do MSA.
    
- Uma Rede Neural Recorrente Bidirecional (Bi-LSTM) é empregada em sequência para capturar as dependências de longo alcance e a informação sequencial ao longo do alinhamento.42
    

A vantagem mais significativa do Fusang sobre os métodos tradicionais é sua capacidade de utilizar a informação contida nos indels. Ao incluir indels nos dados de treinamento, o modelo aprende a reconhecer os padrões evolutivos que eles representam. Os autores demonstraram que a inclusão de informações de indel aumenta significativamente a precisão da inferência em comparação com modelos treinados sem elas, confirmando que os métodos clássicos de fato descartam informações cruciais.42 Para lidar com os desafios práticos de aplicar DL a dados de tamanhos variáveis, o Fusang adota soluções pragmáticas: um algoritmo de adição passo a passo para reconstruir árvores com um número variável de sequências e um algoritmo de janela deslizante para processar alinhamentos de comprimentos variáveis.42

  

### 5.3 Análise Crítica e Comparativa: DL vs. ML em Filogenia

  

A comparação direta do Fusang com ferramentas de ML de última geração, como RAxML e IQ-TREE, revela um cenário de trade-offs. Em termos de precisão topológica, o Fusang demonstrou um desempenho superior, especialmente em conjuntos de dados simulados onde os indels eram uma fonte de sinal filogenético.42 Em termos de

velocidade, o Fusang é computacionalmente comparável às ferramentas de ML para análises com um número menor de sequências (e.g., < 20). No entanto, sua eficiência diminui para conjuntos de dados muito grandes, indicando que, na sua versão atual, os métodos de DL ainda enfrentam desafios de escalabilidade para análises em escala genômica com milhares de táxons.42

Essa tendência de democratizar algoritmos complexos, encapsulando-os em ferramentas de "um clique" como o Phylogeny.fr 44 ou servidores web como o do Fusang 42 e o do AlphaFold 40, representa um paradigma de "Algoritmo-como-Serviço". Isso acelera a pesquisa, mas carrega riscos. O uso acrítico dessas ferramentas, sem a compreensão de suas limitações (como a escalabilidade do Fusang ou os tipos de predições em que o AlphaFold falha), pode levar a conclusões científicas incorretas.32 A longo prazo, isso pode desencorajar o aprofundamento nos princípios fundamentais, criando uma dependência de "caixas-pretas" e potencialmente limitando a inovação futura. O uso de Redes Neurais Artificiais (ANNs) para análises em larga escala, como a classificação de mais de 7.000 domínios de proteínas J para revelar assinaturas filogenéticas e funcionais ocultas, mostra o imenso potencial do DL para extrair conhecimento de dados massivos, mas também reforça a necessidade de uma aplicação cuidadosa e crítica.46

Tabela 3: Evolução dos Algoritmos de Predição Estrutural e Filogenia

|   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|
|Domínio|Abordagem|Algoritmo/Ferramenta Exemplo|Princípio Técnico Central|Tratamento de Dados-Chave|Salto de Desempenho/Inovação|Fontes|
|Predição de Estrutura|Tradicional|Rosetta|Minimização de energia baseada em física e estatística.|Uso de moldes de estruturas homólogas (templates).|Predição de estruturas para proteínas pequenas/médias.|32|
||Deep Learning|AlphaFold 2/3|Atenção (Evoformer) + Viés Indutivo Geométrico (IPA).|Uso massivo de Alinhamentos Múltiplos de Sequências (MSAs).|Predição com precisão atômica de novo e de complexos.|30|
|Inferência Filogenética|Baseada em Modelo|PhyML / RAxML|Máxima Verossimilhança (ML) baseada em modelos de substituição.|Indels são geralmente ignorados ou tratados como dados faltantes.|Inferência estatisticamente robusta para dados de tamanho moderado.|42|
||Deep Learning|Fusang|CNN + Bi-LSTM para aprender padrões evolutivos.|Indels são utilizados como uma fonte de informação filogenética.|Maior precisão topológica ao incorporar informação de indel.|42|

  

## Conclusão e Perspectivas Futuras

  

Este relatório traçou uma jornada através da análise de algoritmos, partindo dos fundamentos teóricos da complexidade computacional e culminando nas aplicações de vanguarda que estão redefinindo a biologia molecular e genômica. A narrativa central que emerge do período de 2019 a 2025 é a de uma revolução impulsionada pelo aprendizado profundo. Arquiteturas de redes neurais, notavelmente aquelas baseadas em mecanismos de atenção e a incorporação inteligente de vieses indutivos do domínio, demonstraram uma capacidade sem precedentes de resolver problemas antes considerados intratáveis. Desde a montagem de genomas de ponta a ponta e a representação da diversidade genética total em grafos de pangenoma, até a predição de estruturas de proteínas com precisão atômica e a reconstrução da árvore da vida com maior fidelidade, os algoritmos de DL não estão apenas melhorando os resultados, mas estão mudando a natureza das perguntas que os biólogos podem fazer.

Olhando para o futuro, várias tendências e desafios emergem como centrais. A crescente complexidade e a natureza de "caixa-preta" dos modelos de DL tornam a interpretabilidade (Explainable AI - XAI) uma necessidade crítica. Ir além da predição para entender como e por que um modelo chega a uma conclusão será fundamental para validar os resultados, gerar novas hipóteses biológicas e garantir a confiança, especialmente em aplicações clínicas.10 Concomitantemente, a gestão de

vieses algorítmicos é um desafio ético e científico primordial. Como esses modelos são treinados em dados existentes, eles podem aprender e amplificar vieses presentes nesses dados (por exemplo, a sub-representação de certas populações humanas em bancos de dados genômicos), levando a resultados injustos ou imprecisos.47

As próximas fronteiras da análise de algoritmos em biologia provavelmente se concentrarão em desafios de integração e dinâmica. Isso inclui a modelagem de sistemas biológicos complexos em múltiplas escalas, desde interações moleculares até ecossistemas inteiros, capturando sua natureza dinâmica e emergente.49 A integração de diversos tipos de dados (genômica, transcriptômica, proteômica, metabolômica — a chamada análise multi-ômica) em modelos preditivos unificados será essencial. Em última análise, o objetivo é avançar em direção a uma biologia verdadeiramente preditiva, onde algoritmos possam não apenas analisar sistemas existentes, mas também projetar novas moléculas e circuitos biológicos para a biologia sintética e informar estratégias de medicina personalizada com uma precisão sem precedentes.10

---

### Análise Final

  

Qual é o tema teórico subjacente?

O tema teórico subjacente que perpassa os avanços recentes é a tensão e a sinergia entre a teoria da complexidade computacional e a computação heurística de alto desempenho. Enquanto a teoria clássica, encapsulada pelo problema $P$ vs. NP`, define os limites formais da tratabilidade computacional, a ascensão do aprendizado profundo representa um paradigma pragmático. Neste novo paradigma, problemas formalmente intratáveis (como o enovelamento de proteínas ou a busca em espaços de soluções vastos) são abordados com sucesso por meio de aproximações poderosas. Essas aproximações são aprendidas a partir de dados massivos e, crucialmente, guiadas por vieses indutivos específicos do domínio, que embutem conhecimento físico e biológico na arquitetura do algoritmo.

Qual(is) as principais técnica(s) foi(ram) utilizada(s)?

As principais técnicas que impulsionaram os avanços transformadores no período de 2019 a 2025 são predominantemente do campo do aprendizado profundo (deep learning). Especificamente, três categorias se destacam:

1. Arquiteturas baseadas em Atenção e Transformers: Como exemplificado pelo bloco Evoformer do AlphaFold, esses modelos são excepcionais em capturar relações complexas e de longo alcance em dados sequenciais e de grafos, permitindo um raciocínio sofisticado sobre as interdependências nos dados biológicos.
    
2. Redes Neurais Híbridas (CNNs + RNNs/LSTMs): A combinação de Redes Neurais Convolucionais para extrair características locais/espaciais e Redes Neurais Recorrentes para capturar dependências sequenciais, como visto no Fusang, provou ser uma estratégia eficaz para analisar alinhamentos de múltiplas sequências.
    
3. Algoritmos de Otimização e Hardware-Específicos: O sucesso dos modelos de DL depende da capacidade de treiná-los. O desenvolvimento de algoritmos de otimização eficientes (como o FlashIPA, que reduz a complexidade do IPA) e de pipelines de software projetados para computação de alto desempenho (como o nf-core/pangenome) foi essencial para tornar o treinamento e a inferência desses modelos massivos computacionalmente viáveis.
    

Qual a contribuição do artigo para o conhecimento científico de um modo geral, reflexivo?

De uma forma reflexiva, a contribuição coletiva dos artigos analisados para o conhecimento científico geral é a demonstração de que a complexidade computacional está se tornando menos uma barreira intransponível e mais um desafio de engenharia de representação. Os estudos mostram que, ao transformar problemas biológicos intrinsecamente complexos em representações de dados adequadas (seja um alinhamento de múltiplas sequências, um grafo de pangenoma ou um conjunto de coordenadas 3D), e ao projetar arquiteturas de algoritmos que inteligentemente incorporam conhecimento fundamental do domínio (como a invariância a transformações físicas ou padrões de co-evolução), podemos criar ferramentas que resolvem problemas de longa data, antes considerados intratáveis. Isso altera fundamentalmente a natureza da descoberta científica, mudando-a de um processo puramente baseado em observação e experimentação para um ciclo virtuoso que integra a simulação e a predição computacional como um terceiro pilar, indispensável e igualmente poderoso.

#### Referências citadas

1. Algorithms and Computational Complexity, acessado em junho 22, 2025, [https://highlights.cis.upenn.edu/algorithms-and-computational-complexity/](https://highlights.cis.upenn.edu/algorithms-and-computational-complexity/)
    
2. Complexity: A Primer - Szilagyi, Miklos: Kindle Store - Amazon.com, acessado em junho 22, 2025, [https://www.amazon.com/Complexity-Primer-Miklos-Szilagyi-ebook/dp/B078J6LXWV](https://www.amazon.com/Complexity-Primer-Miklos-Szilagyi-ebook/dp/B078J6LXWV)
    
3. The Theory of Intrinsic Time - arXiv, acessado em junho 22, 2025, [https://arxiv.org/html/2406.07354v1](https://arxiv.org/html/2406.07354v1)
    
4. The Theory of Intrinsic Time: A Primer - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/381319030_The_Theory_of_Intrinsic_Time_A_Primer](https://www.researchgate.net/publication/381319030_The_Theory_of_Intrinsic_Time_A_Primer)
    
5. arXiv:2502.15749v1 [cs.SE] 10 Feb 2025, acessado em junho 22, 2025, [https://arxiv.org/pdf/2502.15749](https://arxiv.org/pdf/2502.15749)
    
6. P versus NP problem - Wikipedia, acessado em junho 22, 2025, [https://en.wikipedia.org/wiki/P_versus_NP_problem](https://en.wikipedia.org/wiki/P_versus_NP_problem)
    
7. Fifty Years of P vs. NP and the Possibility of the Impossible ..., acessado em junho 22, 2025, [https://cacm.acm.org/research/fifty-years-of-p-vs-np-and-the-possibility-of-the-impossible/](https://cacm.acm.org/research/fifty-years-of-p-vs-np-and-the-possibility-of-the-impossible/)
    
8. Bioinformatics Algorithms: An Active Learning Approach | Request PDF - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/266318072_Bioinformatics_Algorithms_An_Active_Learning_Approach](https://www.researchgate.net/publication/266318072_Bioinformatics_Algorithms_An_Active_Learning_Approach)
    
9. Bioinformatics Algorithms: Techniques and Applications | Request PDF - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/265465836_Bioinformatics_Algorithms_Techniques_and_Applications](https://www.researchgate.net/publication/265465836_Bioinformatics_Algorithms_Techniques_and_Applications)
    
10. Review Article - BNAS, acessado em junho 22, 2025, [https://www.bnas.com.ng/journal/1516008.pdf](https://www.bnas.com.ng/journal/1516008.pdf)
    
11. The P vs NP Problem: A Deep Dive - Number Analytics, acessado em junho 22, 2025, [https://www.numberanalytics.com/blog/deep-dive-into-p-vs-np-problem](https://www.numberanalytics.com/blog/deep-dive-into-p-vs-np-problem)
    
12. The P versus NP problem - Clay Mathematics Institute, acessado em junho 22, 2025, [https://www.claymath.org/wp-content/uploads/2022/06/pvsnp.pdf](https://www.claymath.org/wp-content/uploads/2022/06/pvsnp.pdf)
    
13. (PDF) On the P versus NP Problem - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/386443294_On_the_P_versus_NP_Problem](https://www.researchgate.net/publication/386443294_On_the_P_versus_NP_Problem)
    
14. Theory - Communications of the ACM, acessado em junho 22, 2025, [https://cacm.acm.org/category/theory/](https://cacm.acm.org/category/theory/)
    
15. If I have solved the P vs. NP problem should I submit it? - Quora, acessado em junho 22, 2025, [https://www.quora.com/If-I-have-solved-the-P-vs-NP-problem-should-I-submit-it](https://www.quora.com/If-I-have-solved-the-P-vs-NP-problem-should-I-submit-it)
    
16. 2025 - Computational Complexity, acessado em junho 22, 2025, [https://blog.computationalcomplexity.org/2025/](https://blog.computationalcomplexity.org/2025/)
    
17. Algorithms, Volume 18, Issue 3 (March 2025) – 58 articles - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/1999-4893/18/3](https://www.mdpi.com/1999-4893/18/3)
    
18. Algorithms, Volume 18, Issue 4 (April 2025) – 62 articles, acessado em junho 22, 2025, [https://www.mdpi.com/1999-4893/18/4](https://www.mdpi.com/1999-4893/18/4)
    
19. Algorithms, Volume 18, Issue 5 (May 2025) – 60 articles - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/1999-4893/18/5](https://www.mdpi.com/1999-4893/18/5)
    
20. Algorithms, Volume 18, Issue 6 (June 2025) – 75 articles, acessado em junho 22, 2025, [https://www.mdpi.com/1999-4893/18/6](https://www.mdpi.com/1999-4893/18/6)
    
21. New algorithms for accurate and efficient de novo genome assembly ..., acessado em junho 22, 2025, [https://www.life-science-alliance.org/content/6/5/e202201719](https://www.life-science-alliance.org/content/6/5/e202201719)
    
22. Recent Advances in Assembly of Complex Plant Genomes - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/gpb/article/21/3/427/7588903](https://academic.oup.com/gpb/article/21/3/427/7588903)
    
23. Recent Advances in Genome Editing and Bioinformatics: Addressing Challenges in Genome Editing Implementation and Genome Sequencing - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11989416/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11989416/)
    
24. A detailed guide to assessing genome assembly based on long-read sequencing data using Inspector - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/40140633/](https://pubmed.ncbi.nlm.nih.gov/40140633/)
    
25. Pangenome graphs and their applications in biodiversity genomics, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/39779953/](https://pubmed.ncbi.nlm.nih.gov/39779953/)
    
26. Cluster-efficient pangenome graph construction with nf-core/pangenome - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article/40/11/btae609/7821182](https://academic.oup.com/bioinformatics/article/40/11/btae609/7821182)
    
27. Pangenome graph layout by Path-Guided Stochastic Gradient ..., acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article/40/7/btae363/7705520](https://academic.oup.com/bioinformatics/article/40/7/btae363/7705520)
    
28. AlfaPang: alignment free algorithm for pangenome graph construction - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12082865/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12082865/)
    
29. Varigraph: an accurate and widely applicable pangenome graph-based variant genotyper for diploid and polyploid genomes | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.02.17.638628v1.full-text](https://www.biorxiv.org/content/10.1101/2025.02.17.638628v1.full-text)
    
30. Highly accurate protein structure prediction with AlphaFold - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/34265844/](https://pubmed.ncbi.nlm.nih.gov/34265844/)
    
31. Before and after AlphaFold2: An overview of protein structure prediction - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10011655/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10011655/)
    
32. Before and after AlphaFold2: An overview of protein structure prediction - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/bioinformatics/articles/10.3389/fbinf.2023.1120370/full](https://www.frontiersin.org/journals/bioinformatics/articles/10.3389/fbinf.2023.1120370/full)
    
33. AlphaFold two years on: Validation and impact - PNAS, acessado em junho 22, 2025, [https://www.pnas.org/doi/10.1073/pnas.2315002121](https://www.pnas.org/doi/10.1073/pnas.2315002121)
    
34. How to Solve the Protein Folding Problem: AlphaFold2 | Towards Data Science, acessado em junho 22, 2025, [https://towardsdatascience.com/how-to-solve-the-protein-folding-problem-alphafold2-6c81faba670d/](https://towardsdatascience.com/how-to-solve-the-protein-folding-problem-alphafold2-6c81faba670d/)
    
35. AlphaFold 2: Attention Mechanism for Predicting 3D Protein Structures - PI IP LAW, acessado em junho 22, 2025, [https://piip.co.kr/en/blog/AlphaFold2_Architecture_Improvements](https://piip.co.kr/en/blog/AlphaFold2_Architecture_Improvements)
    
36. Flash Invariant Point Attention - arXiv, acessado em junho 22, 2025, [https://arxiv.org/html/2505.11580v1](https://arxiv.org/html/2505.11580v1)
    
37. lociPARSE: A Locality-aware Invariant Point Attention Model for Scoring RNA 3D Structures, acessado em junho 22, 2025, [https://pubs.acs.org/doi/10.1021/acs.jcim.4c01621](https://pubs.acs.org/doi/10.1021/acs.jcim.4c01621)
    
38. lociPARSE: a locality-aware invariant point attention model for scoring RNA 3D structures, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10635153/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10635153/)
    
39. AlphaFold 3 predicts the structure and interactions of all of life's molecules - Google Blog, acessado em junho 22, 2025, [https://blog.google/technology/ai/google-deepmind-isomorphic-alphafold-3-ai-model/](https://blog.google/technology/ai/google-deepmind-isomorphic-alphafold-3-ai-model/)
    
40. AlphaFold 3: Stepping into the future of structure prediction - Front Line Genomics, acessado em junho 22, 2025, [https://frontlinegenomics.com/alphafold-3-stepping-into-the-future-of-structure-prediction/](https://frontlinegenomics.com/alphafold-3-stepping-into-the-future-of-structure-prediction/)
    
41. AlphaFold - Wikipedia, acessado em junho 22, 2025, [https://en.wikipedia.org/wiki/AlphaFold](https://en.wikipedia.org/wiki/AlphaFold)
    
42. Fusang: a framework for phylogenetic tree inference via deep ..., acessado em junho 22, 2025, [https://academic.oup.com/nar/article/51/20/10909/7306672](https://academic.oup.com/nar/article/51/20/10909/7306672)
    
43. Phylogenetic Analysis of Protein Sequence Data Using the Randomized Axelerated Maximum Likelihood (RAXML) Program | Request PDF - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/51706649_Phylogenetic_Analysis_of_Protein_Sequence_Data_Using_the_Randomized_Axelerated_Maximum_Likelihood_RAXML_Program](https://www.researchgate.net/publication/51706649_Phylogenetic_Analysis_of_Protein_Sequence_Data_Using_the_Randomized_Axelerated_Maximum_Likelihood_RAXML_Program)
    
44. Phylogeny.fr: robust phylogenetic analysis for the non-specialist | Nucleic Acids Research | Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/nar/article/36/suppl_2/W465/2505761](https://academic.oup.com/nar/article/36/suppl_2/W465/2505761)
    
45. Full article: Bioinformatic approaches for studying the microbiome of fermented food, acessado em junho 22, 2025, [https://www.tandfonline.com/doi/full/10.1080/1040841X.2022.2132850](https://www.tandfonline.com/doi/full/10.1080/1040841X.2022.2132850)
    
46. Data-driven large-scale genomic analysis reveals an intricate phylogenetic and functional landscape in J-domain proteins - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10410713/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10410713/)
    
47. Interplay Between Humans and Algorithms the Focus of Journal Special Collection, acessado em junho 22, 2025, [https://www.psychologicalscience.org/news/2024-february-perspectives-algorithms.html](https://www.psychologicalscience.org/news/2024-february-perspectives-algorithms.html)
    
48. (PDF) Algorithmic Bias in Artificial Intelligence Systems - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/368951458_Algorithmic_Bias_in_Artificial_Intelligence_Systems](https://www.researchgate.net/publication/368951458_Algorithmic_Bias_in_Artificial_Intelligence_Systems)
    
49. PLOS Computational Biology - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/journal/PLOS-Computational-Biology-1553-7358](https://www.researchgate.net/journal/PLOS-Computational-Biology-1553-7358)
    
50. May 2025 - PLOS Computational Biology, acessado em junho 22, 2025, [https://journals.plos.org/ploscompbiol/issue](https://journals.plos.org/ploscompbiol/issue)
    

**