**  

# Alinhamento Múltiplo de Sequências: Dos Paradigmas Fundamentais à Revolução da Inteligência Artificial

  
  

## 1. Introdução: O Pilar da Biologia Comparativa

  
  

### 1.1. Definição e Centralidade do Alinhamento Múltiplo de Sequências (MSA)

  

O Alinhamento Múltiplo de Sequências, ou MSA (do inglês, Multiple Sequence Alignment), é um dos procedimentos mais fundamentais e ubíquos na bioinformática moderna. Em sua essência, o MSA consiste no processo de organizar um conjunto de três ou mais sequências biológicas — sejam elas de Ácido Desoxirribonucleico (DNA), Ácido Ribonucleico (RNA) ou proteínas — de modo a alinhar posições homólogas em colunas (IBRAHIM et al., 2024).1 O objetivo é identificar e destacar regiões de similaridade que podem ser consequência de relações funcionais, estruturais ou, mais fundamentalmente, evolutivas. A hipótese central é que um alto grau de semelhança entre sequências de diferentes organismos ou dentro de uma mesma família gênica sugere uma ancestralidade comum (CHOWDHURY; GARAI, 2017). A inserção estratégica de lacunas (gaps), que representam eventos de inserção ou deleção (indels) ocorridos ao longo da evolução, é o mecanismo pelo qual o alinhamento é otimizado para maximizar a correspondência entre os resíduos (aminoácidos ou nucleotídeos) (NOTREDAME, 2007).

A centralidade do MSA para a biologia molecular e computacional não pode ser subestimada. Ele serve como ponto de partida para uma vasta gama de análises in silico, sendo frequentemente um pré-requisito indispensável para métodos de modelagem biológica mais complexos (CEDER; NOTREDAME, 2007).2 Um alinhamento preciso é a pedra angular para a inferência de relações filogenéticas, permitindo a construção de árvores que representam a história evolutiva de genes, proteínas ou espécies (EDGAR, 2004).3 Além disso, o MSA é crucial para a predição da estrutura secundária e terciária de proteínas e RNAs, uma vez que regiões conservadas frequentemente correspondem a domínios funcionais ou elementos estruturais críticos (IBRAHIM et al., 2024).1 A identificação de resíduos conservados através de um MSA pode revelar sítios ativos de enzimas, locais de ligação de ligantes ou interfaces de interação proteína-proteína (SÁNCHEZ et al., 2025).4 Com o advento de tecnologias de inteligência artificial para predição de estruturas, como o AlphaFold, a qualidade do MSA de entrada tornou-se um fator ainda mais determinante para a acurácia dos modelos gerados, reforçando seu papel como uma ferramenta indispensável na pesquisa biológica contemporânea (DOTAN et al., 2025).5

  

### 1.2. Fundamentos da Estrutura e Função dos Ácidos Nucleicos: O Substrato do Alinhamento

  

Para compreender a complexidade e os desafios inerentes ao alinhamento de sequências, é essencial primeiro entender a natureza do substrato: os ácidos nucleicos. O DNA e o RNA não são meras cadeias lineares de letras; são macromoléculas com estruturas tridimensionais complexas que ditam sua função biológica. O DNA, o portador da informação genética na maioria dos organismos, existe predominantemente na forma de uma dupla-hélice (BIOSYNTH, 2022).7 Esta estrutura canônica, descrita por Watson e Crick, é composta por duas fitas de polinucleotídeos que correm em direções opostas (antiparalelas). O esqueleto de açúcar-fosfato de cada fita fica na parte externa da hélice, enquanto as bases nitrogenadas (Adenina, Timina, Guanina e Citosina) se projetam para o interior. A especificidade do pareamento de bases — Adenina (A) com Timina (T) e Guanina (G) com Citosina (C) — através de pontes de hidrogênio é o que garante a estabilidade da hélice e a fidelidade da replicação da informação genética (BIOSYNTH, 2022; HOUGHTON et al., 2006).7 Essa estrutura é altamente compactada no núcleo das células eucarióticas através do enrolamento em torno de proteínas histonas, formando nucleossomos, o que demonstra a organização hierárquica da informação genética (BIOSYNTH, 2022).7

Contudo, a visão do DNA como uma molécula estática e unicamente em sua forma B (a dupla-hélice clássica) é uma simplificação. A pesquisa recente tem revelado a importância biológica de estruturas não-canônicas ou "não-B", que podem se formar em sequências específicas e sob certas condições fisiológicas. Entre as mais estudadas estão os R-loops e os G-quadruplexes. Um R-loop é uma estrutura de três fitas formada co-transcricionalmente quando um transcrito de RNA nascente se anela à fita molde de DNA, deslocando a fita não-molde como DNA de fita simples (ssDNA) (PETROV et al., 2022).9 Na fita de ssDNA deslocada, sequências ricas em guanina podem se dobrar sobre si mesmas para formar G-quadruplexes (G4), estruturas de quatro fitas estabilizadas por arranjos planares de guaninas (LEE et al., 2020).10 Essas estruturas não são meras curiosidades; elas atuam como barreiras físicas à progressão do garfo de replicação e podem induzir instabilidade genômica se não forem resolvidas adequadamente (PETROV et al., 2022).9

O RNA, por sua vez, exibe uma versatilidade estrutural ainda maior. Embora seja tipicamente de fita simples, sua capacidade de se dobrar sobre si mesmo permite a formação de uma miríade de estruturas secundárias e terciárias complexas. Estruturas secundárias comuns incluem grampos (hairpins), alças internas (internal loops), protuberâncias (bulges) e junções de múltiplas hélices (YILDIRIM; HEEREMA; YIN, 2020).11 Essas estruturas não são aleatórias; elas são fundamentais para a função do RNA, permitindo-lhe atuar como uma máquina catalítica (ribozima), um andaime para a montagem de complexos ribonucleoproteicos (como o ribossomo e o spliceossomo) e um regulador preciso da expressão gênica (SOMAROWTHU; LEVENDOSKY; WESTHOF, 2015).12 A flexibilidade conferida pelo açúcar ribose (em contraste com a desoxirribose do DNA) facilita interações não-canônicas que são cruciais para a formação de estruturas terciárias compactas e funcionais (YILDIRIM; HEEREMA; YIN, 2020).11

A existência dessas estruturas complexas e dinâmicas tanto no DNA quanto no RNA apresenta um desafio profundo para os algoritmos de MSA. Um alinhamento que parece ótimo quando as sequências são tratadas como cadeias lineares de caracteres pode ser biologicamente sem sentido se destruir um G-quadruplex funcional ou um grampo de RNA essencial. Isso revela uma tensão fundamental no campo: a maioria dos algoritmos opera em uma representação unidimensional da molécula, enquanto a realidade biológica é tridimensional e dinâmica. Essa dissonância impulsiona a busca por algoritmos mais sofisticados que possam, de alguma forma, incorporar informações estruturais para produzir alinhamentos mais realistas e significativos.

  

### 1.3. O Desafio Computacional: A Busca pelo Alinhamento Ótimo

  

A tradução do problema biológico do MSA para uma formulação computacional revela sua imensa complexidade. O objetivo é encontrar o alinhamento que maximize uma função de pontuação (ou função objetivo), que quantifica a qualidade do alinhamento. Essa função tipicamente atribui pontuações positivas para resíduos correspondentes (substituições), pontuações negativas para resíduos não correspondentes (mismatches) e penalidades para a introdução de lacunas (gaps) (CHANG; GULKO; POLLARD, 2016).13 O desafio reside no fato de que o número de alinhamentos possíveis para um conjunto de sequências cresce exponencialmente com o número e o comprimento das sequências.

Formalmente, encontrar o alinhamento ótimo que maximiza a pontuação da "soma dos pares" (sum-of-pairs score), uma das métricas mais comuns, é um problema NP-difícil (NP-hard) (WANG; JIANG, 1994). Isso significa que não existe um algoritmo conhecido que possa encontrar a solução ótima garantida em tempo polinomial para um número arbitrário de sequências. A programação dinâmica, que resolve o alinhamento de duas sequências de forma ótima, torna-se computacionalmente intratável para mais de um pequeno número de sequências, pois sua complexidade cresce como o produto dos comprimentos das sequências (ALQURAN et al., 2024).14

Essa barreira computacional é a razão pela qual o campo do MSA é dominado por algoritmos heurísticos. As heurísticas são estratégias que buscam encontrar uma solução "boa" ou "próxima da ótima" em um tempo razoável, sacrificando a garantia de otimalidade. A história do desenvolvimento de algoritmos de MSA é, em grande parte, a história da invenção e do refinamento de heurísticas cada vez mais inteligentes e eficientes. Desde os métodos progressivos pioneiros até as abordagens iterativas e baseadas em consistência, e mais recentemente, as revoluções impulsionadas pela inteligência artificial, o objetivo tem sido o mesmo: aproximar-se da elusiva solução biologicamente correta dentro dos limites do que é computacionalmente viável (CHANG; GULKO; POLLARD, 2016).13

  

## 2. Arquiteturas Clássicas e Heurísticas Fundamentais em MSA

  

A complexidade NP-difícil do MSA forçou o desenvolvimento de uma variedade de abordagens heurísticas, cada uma com suas próprias forças e fraquezas. Essas arquiteturas clássicas formaram a base da bioinformática por décadas e continuam a ser amplamente utilizadas. Compreender seus princípios é essencial para apreciar os avanços mais recentes.

  

### 2.1. O Método Progressivo: A Abordagem do "Guide Tree"

  

A heurística de alinhamento progressivo é, de longe, a abordagem mais popular e amplamente implementada para o MSA, principalmente devido à sua eficiência computacional. O método decompõe o complexo problema de alinhar N sequências em uma série de alinhamentos de pares, que são computacionalmente mais simples (EDGAR, 2004).3 O processo ocorre em três etapas principais:

1. Cálculo das Distâncias Par a Par: Primeiramente, todas as sequências no conjunto de entrada são comparadas duas a duas para gerar uma matriz de distâncias. Essa distância pode ser calculada rapidamente através da contagem de k-mers (subsequências de comprimento k) compartilhados, como no MUSCLE, ou através de alinhamentos de pares completos (CHANG; GULKO; POLLARD, 2016).13 O resultado é uma matriz que quantifica a dissimilaridade entre cada par de sequências.
    
2. Construção da Árvore Guia (Guide Tree): A matriz de distâncias é então usada para construir uma árvore guia, que é uma representação hierárquica das relações de similaridade entre as sequências. Métodos de agrupamento como UPGMA (Unweighted Pair Group Method with Arithmetic Mean) ou Neighbor-Joining são comumente empregados para este fim (EDGAR, 2004).3 A árvore guia não é necessariamente uma árvore filogenética precisa, mas serve como um roteiro para a etapa de alinhamento.
    
3. Alinhamento Progressivo: O alinhamento final é construído seguindo a ordem de ramificação da árvore guia, começando pelas folhas (sequências individuais) e subindo em direção à raiz. Em cada nó interno da árvore, um alinhamento de perfil-perfil (ou sequência-perfil, ou sequência-sequência) é realizado entre os alinhamentos dos dois nós filhos. Um "perfil" é uma representação do alinhamento de um subconjunto de sequências, contendo informações sobre as frequências de resíduos e lacunas em cada coluna. Esse processo continua até que todos os perfis sejam fundidos na raiz, resultando no MSA final (CEDER; NOTREDAME, 2007).2
    

A principal desvantagem dessa abordagem é sua natureza "gananciosa" (greedy): uma vez que um alinhamento é feito em um estágio inicial (por exemplo, entre as duas sequências mais próximas), ele é fixado e quaisquer erros introduzidos nesse ponto são propagados para os estágios posteriores sem possibilidade de correção (SIEVERS et al., 2011).15

  

#### Estudo de Caso: Clustal Omega

  

Clustal Omega representa a evolução moderna e altamente escalável da linhagem de algoritmos Clustal, que popularizou a abordagem progressiva (SIEVERS et al., 2011).15 Ele foi projetado para enfrentar o desafio de alinhar conjuntos de dados massivos, sendo capaz de lidar com centenas de milhares de sequências em um computador desktop padrão (SIEVERS; HIGGINS, 2014).16 Suas inovações-chave incluem:

- Construção Rápida da Árvore Guia: Em vez de calcular uma matriz de distância completa, que tem complexidade O(N2), Clustal Omega utiliza o algoritmo mBed (modified Basic Linear Space). Este método seleciona um subconjunto de sequências "semeadoras" e agrupa as sequências restantes com base em sua similaridade com essas sementes. Isso reduz a complexidade da construção da árvore guia para aproximadamente O(NlogN), permitindo uma escalabilidade sem precedentes (SIEVERS et al., 2011; SIEVERS; HIGGINS, 2018).15
    
- Motor de Alinhamento Baseado em HMM: Para o alinhamento de perfis, Clustal Omega abandonou a programação dinâmica tradicional de seus predecessores e adotou o pacote HHalign (SÖDING, 2005). O HHalign realiza alinhamentos de perfil-perfil usando Modelos Ocultos de Markov (HMMs), que são modelos probabilísticos que capturam informações de sequência de forma mais rica do que perfis simples. Essa mudança resultou em um aumento significativo na acurácia do alinhamento (SIEVERS et al., 2011; SIEVERS; HIGGINS, 2018).15
    
- Alinhamento de Perfil Externo (EPA): Uma característica poderosa do Clustal Omega é a capacidade de usar informações de alinhamentos pré-existentes ou HMMs de bancos de dados como o Pfam para guiar o novo alinhamento. Isso permite que o conhecimento acumulado sobre famílias de proteínas seja aproveitado para melhorar a precisão, especialmente ao alinhar um grande número de sequências a uma família bem caracterizada (SIEVERS; HIGGINS, 2014).16
    

Essas inovações posicionam o Clustal Omega como uma ferramenta de escolha para análises em larga escala, como em estudos filogenômicos ou na caracterização de grandes famílias de genes, onde a velocidade e a capacidade de lidar com um grande número de sequências são primordiais (SIEVERS et al., 2011).15 Por exemplo, na análise de famílias de receptores NLR em plantas, o Clustal Omega é frequentemente usado para alinhar sequências de proteínas coletadas para identificar motivos conservados e construir árvores filogenéticas (WANG et al., 2025).19

  

### 2.2. Refinamento Iterativo: Corrigindo os Erros Iniciais

  

Para mitigar a principal falha do método progressivo — a propagação de erros iniciais — foram desenvolvidos os métodos de refinamento iterativo. A ideia central é simples: após a obtenção de um alinhamento inicial (geralmente por um método progressivo), o algoritmo tenta melhorá-lo repetidamente. Cada "iteração" envolve a modificação do alinhamento de alguma forma e a avaliação se a nova versão é melhor, de acordo com a função de pontuação. Se for, o novo alinhamento é mantido; caso contrário, é descartado. O processo continua até que nenhuma melhoria adicional possa ser encontrada ou um número predefinido de iterações seja atingido (SIEVERS; HIGGINS, 2014).16

Existem várias estratégias para modificar o alinhamento. Uma comum é a "dividir e conquistar": o alinhamento é dividido em dois sub-alinhamentos, que são então realinhados um ao outro. Se o alinhamento resultante tiver uma pontuação melhor, ele substitui o anterior. Esse processo pode ser repetido para diferentes partições do alinhamento (LEE; GRASSO; SHARP, 2002). Essa abordagem permite que resíduos que foram mal alinhados nas etapas iniciais sejam reposicionados, corrigindo os erros da abordagem gananciosa (CHOI; JUNG; LEE, 2008).20

  

#### Estudo de Caso: MUSCLE

  

MUSCLE (MUltiple Sequence Comparison by Log-Expectation) é um dos algoritmos mais populares e eficazes que implementa o refinamento iterativo. Sua popularidade deriva de um excelente equilíbrio entre velocidade e alta precisão (EDGAR, 2004).3 O algoritmo opera em um processo de três estágios distintos:

1. Estágio Progressivo Rascunho (Draft Progressive): Este estágio visa gerar rapidamente um primeiro alinhamento. Ele utiliza uma medida de distância muito rápida baseada na contagem de k-mers para construir uma matriz de distância e uma árvore guia via UPGMA. Um alinhamento progressivo rápido é então realizado para produzir um MSA inicial (EDGAR, 2004).21
    
2. Estágio Progressivo Melhorado (Improved Progressive): A principal fonte de erro no primeiro estágio é a imprecisão da árvore guia. Neste segundo estágio, a árvore é recalculada. As distâncias par a par são reestimadas a partir do alinhamento inicial usando a distância de Kimura, que é mais precisa. Uma nova árvore guia é construída com UPGMA, e um segundo alinhamento progressivo é realizado usando esta árvore mais precisa. Este estágio utiliza uma função de pontuação de perfil sofisticada chamada pontuação de log-expectativa (log-expectation score). Esta pontuação é uma forma de log-odds que compara a probabilidade de alinhar dois perfis com a probabilidade de alinhá-los por acaso, resultando em maior acurácia (EDGAR, 2004).3
    
3. Estágio de Refinamento (Refinement): Este é o estágio iterativo. A árvore guia do segundo estágio é usada para particionar o alinhamento. Uma aresta da árvore é removida, dividindo as sequências em dois subconjuntos. Os perfis desses dois subconjuntos são extraídos do alinhamento atual e realinhados. Se o novo alinhamento tiver uma pontuação de soma dos pares (SP) maior, ele é mantido. Esse processo é repetido para todas as arestas da árvore, ou até que a convergência seja alcançada (EDGAR, 2004).21
    

Uma inovação recente e significativa é o MUSCLEv5, que muda o paradigma de produzir um único alinhamento para gerar um ensemble de alinhamentos de alta acurácia. Ele faz isso perturbando um modelo oculto de Markov e permutando a árvore guia, reconhecendo que pode haver múltiplos alinhamentos plausíveis para um dado conjunto de sequências (EDGAR, 2021).21 Essa abordagem probabilística fornece uma medida de confiança sobre a robustez de diferentes regiões do alinhamento. O MUSCLE é amplamente utilizado em estudos filogenéticos e de caracterização de famílias de proteínas, como na análise de fatores de transcrição MYB em citros (DING et al., 2023) 23 ou na identificação de domínios conservados em proteínas PhaC (TANAKA et al., 2015).24

  

#### Estudo de Caso: MAFFT

  

MAFFT (Multiple Alignment using Fast Fourier Transform) é outro programa de MSA de ponta, conhecido por sua velocidade e flexibilidade, oferecendo uma gama de estratégias que equilibram velocidade e precisão (KATOH et al., 2002).25 Sua principal inovação, que lhe dá o nome, é o uso da Transformada Rápida de Fourier (FFT) para acelerar drasticamente a identificação de regiões homólogas.

- Identificação de Homologia via FFT: Em vez de realizar alinhamentos de pares completos, o MAFFT converte as sequências de aminoácidos em sequências de vetores numéricos que representam propriedades físico-químicas, como volume e polaridade. A correlação entre essas duas sequências de vetores é então calculada usando a FFT. A FFT é um algoritmo matemático extremamente eficiente que reduz a complexidade do cálculo da correlação de O(L2) para O(LlogL), onde L é o comprimento da sequência. Picos na função de correlação indicam regiões de alta similaridade, que são então usadas para ancorar o alinhamento (KATOH et al., 2002).25
    
- Estratégias Flexíveis: O MAFFT oferece várias estratégias, permitindo que os usuários escolham a mais adequada para seu problema:
    

- Métodos Progressivos Rápidos (e.g., FFT-NS-2): Usam a abordagem FFT para construir rapidamente uma árvore guia e realizar um alinhamento progressivo. São ideais para alinhar um grande número de sequências onde a velocidade é mais crítica que a precisão máxima (KATOH; KUMENI, 2008).26
    
- Métodos Iterativos de Alta Acurácia (e.g., L-INS-i, G-INS-i, E-INS-i): Esses métodos combinam a abordagem progressiva com múltiplos ciclos de refinamento iterativo. Eles também incorporam informações de consistência (semelhante ao T-Coffee, discutido abaixo) para melhorar ainda mais a precisão. O L-INS-i, por exemplo, é particularmente bom em alinhar sequências com grandes lacunas terminais, enquanto o E-INS-i é projetado para sequências com domínios conservados flanqueados por regiões não alinháveis (KATOH; TOH, 2008).27 Essas opções são consideradas entre as mais precisas disponíveis, embora sejam computacionalmente mais intensivas (KATOH; TOH, 2008).27
    

Devido à sua combinação de velocidade e acurácia, o MAFFT é uma ferramenta padrão em muitos pipelines de bioinformática, desde a análise de famílias de genes em plantas como Rosaceae (ZHAO et al., 2023) 28 até o alinhamento de proteínas de membrana como a família NAR2 (POPOV et al., 2025) 29 e a análise de domínios de proteínas em estudos de endossimbiontes (VANHOUTTE et al., 2021).30

  

### 2.3. A Abordagem Baseada em Consistência: Alinhando os Alinhamentos

  

A abordagem baseada em consistência representa um salto conceitual e de acurácia em relação aos métodos progressivos puros. O princípio fundamental é que a informação contida em todos os alinhamentos de pares possíveis dentro de um conjunto de sequências deve ser usada para guiar a construção do alinhamento múltiplo final. Em vez de confiar em uma única árvore guia, esses métodos buscam um MSA que seja o mais "consistente" possível com uma biblioteca de alinhamentos de pares de alta qualidade (CEDER; NOTREDAME, 2007).2

O fluxo de trabalho geral é o seguinte:

1. Construção da Biblioteca Primária: O algoritmo começa calculando alinhamentos de pares para todos os pares de sequências no conjunto de dados. Crucialmente, ele pode calcular tanto alinhamentos globais (que alinham as sequências de ponta a ponta) quanto locais (que encontram as melhores regiões de similaridade). Essa coleção de alinhamentos de pares forma a "biblioteca primária".
    
2. Extensão da Biblioteca e Ponderação: A biblioteca é então estendida. Para cada par de sequências (digamos, A e B), o algoritmo procura uma terceira sequência (C) e usa os alinhamentos (A, C) e (B, C) para inferir um novo alinhamento para (A, B). Esse processo é repetido para todas as sequências intermediárias, e os pares de resíduos que são consistentemente alinhados em diferentes caminhos recebem um peso maior.
    
3. Alinhamento Progressivo Guiado pela Consistência: Finalmente, um alinhamento progressivo é realizado, mas em vez de usar uma matriz de substituição padrão (como BLOSUM ou PAM), ele usa uma matriz de pontuação derivada da biblioteca de consistência. Posições que foram consistentemente alinhadas na biblioteca recebem pontuações altas, guiando o alinhamento para a solução mais consistente.
    

Embora essa abordagem seja significativamente mais precisa, ela também é muito mais intensiva em termos de computação e memória, geralmente limitando seu uso a conjuntos de dados menores (algumas centenas de sequências) (CEDER; NOTREDAME, 2007).2

  

#### Estudo de Caso: T-Coffee e M-Coffee

  

T-Coffee (Tree-based Consistency Objective Function For alignment Evaluation) foi o programa pioneiro que popularizou a abordagem baseada em consistência. Seu princípio é exatamente o descrito acima: compilar uma biblioteca de alinhamentos de pares e usá-la como uma matriz de substituição específica da posição durante um alinhamento progressivo regular (NOTREDAME; HIGGINS; HERINGA, 2000).

Uma extensão poderosa é o M-Coffee (Meta-Coffee). Em vez de gerar sua própria biblioteca primária a partir do zero, o M-Coffee executa vários programas de MSA diferentes (como Clustal Omega, MUSCLE, MAFFT, etc.) no mesmo conjunto de dados. Ele então trata os alinhamentos de saída desses programas como sua biblioteca. O alinhamento final do M-Coffee é aquele que é o mais consistente com os alinhamentos de entrada. Essa abordagem de "consenso" muitas vezes produz um alinhamento que é mais preciso do que qualquer um dos métodos individuais (WALLACE et al., 2006).

Uma das contribuições mais valiosas do M-Coffee é o índice CORE (Consistency-based Objective function for REliability). Para cada coluna do alinhamento final, o índice CORE fornece uma pontuação de confiabilidade local, indicando o quão bem essa coluna concorda com os alinhamentos de entrada da biblioteca. Colunas com pontuações altas são consideradas confiavelmente alinhadas, enquanto colunas com pontuações baixas são provavelmente regiões de alinhamento incerto. Essa pontuação de confiabilidade local é uma ferramenta inestimável para os pesquisadores, permitindo-lhes filtrar regiões não confiáveis do alinhamento antes de análises posteriores, como a modelagem de homologia ou a inferência filogenética (CEDER; NOTREDAME, 2007).2 Essa ideia de avaliar a confiabilidade local do alinhamento é um precursor importante das abordagens probabilísticas e de

ensemble que se tornariam mais proeminentes nos anos seguintes.

  

### Tabela 1: Panorama Comparativo dos Principais Algoritmos Clássicos de Alinhamento Múltiplo de Sequências

  
  

|   |   |   |   |   |
|---|---|---|---|---|
|Característica|Clustal Omega|MUSCLE|MAFFT|T-Coffee / M-Coffee|
|Paradigma Algorítmico|Progressivo com HMMs|Progressivo com Refinamento Iterativo|Progressivo com FFT e Refinamento Iterativo|Baseado em Consistência|
|Inovação-Chave|Algoritmo mBed para árvores guia rápidas; motor de alinhamento HHalign (HMM-HMM).|Processo de 3 estágios (rascunho, melhorado, refinamento); pontuação de log-expectativa; ensemble de alinhamentos (MUSCLEv5).|Uso da Transformada Rápida de Fourier (FFT) para identificação rápida de homologia; múltiplas estratégias (velocidade vs. acurácia).|Uso de uma biblioteca de alinhamentos de pares para guiar o MSA; M-Coffee combina saídas de múltiplos programas.|
|Força Principal|Escalabilidade massiva (100.000+ sequências); boa velocidade geral.|Excelente equilíbrio entre alta acurácia e boa velocidade; refinamento robusto.|Velocidade extremamente alta (modos rápidos); acurácia muito alta (modos iterativos); grande flexibilidade.|Acurácia muito alta, especialmente para sequências divergentes; fornece pontuações de confiabilidade local (índice CORE).|
|Limitação Principal|A natureza "gananciosa" do algoritmo progressivo pode propagar erros.|Menos escalável para dezenas de milhares de sequências em comparação com Clustal Omega.|A escolha da estratégia correta pode ser complexa para usuários iniciantes.|Computacionalmente muito intensivo; limitado a conjuntos de dados menores (centenas de sequências).|
|Caso de Uso Ideal|Alinhamento de conjuntos de dados muito grandes (genomas virais, famílias de genes extensas).|Alinhamentos de pequeno a médio porte (até alguns milhares de sequências) que exigem alta acurácia.|Uso geral, desde alinhamentos rápidos de rascunho até alinhamentos de alta qualidade para publicação.|Alinhamentos de pequeno porte de sequências difíceis e divergentes, onde a acurácia máxima é a prioridade.|

A análise desses algoritmos clássicos revela um cenário de compromissos: velocidade versus acurácia, escalabilidade versus rigor. Nenhum algoritmo único é universalmente superior; a escolha depende intrinsecamente da natureza do problema biológico em questão. Essa paisagem de ferramentas estabelecidas, com suas forças e limitações bem definidas, preparou o terreno para a próxima onda de inovação, impulsionada pelas demandas sem precedentes da era genômica e pelas novas capacidades da inteligência artificial.

  

## 3. A Nova Fronteira dos Algoritmos de MSA: Avanços e Descobertas (2019-2025)

  

A virada da década de 2020 marcou um ponto de inflexão para o campo do Alinhamento Múltiplo de Sequências. Duas forças motrizes convergiram para impulsionar uma nova onda de inovação: o dilúvio de dados gerado pelas tecnologias de sequenciamento de nova geração (NGS) e a maturação de algoritmos de inteligência artificial (IA), particularmente o deep learning. Essas forças deram origem a uma nova classe de ferramentas de MSA projetadas para superar as limitações de escalabilidade e de modelagem biológica das arquiteturas clássicas.

  

### 3.1. Escalabilidade na Era do "Big Data" Genômico: O Desafio dos Milhões de Sequências

  

Com o barateamento e a popularização do sequenciamento de DNA e RNA, os bioinformatas se depararam com um novo tipo de desafio. A tarefa não era mais alinhar dezenas ou centenas de sequências, mas sim dezenas de milhares, ou até milhões. Cenários como o rastreamento de genomas virais durante uma pandemia, a análise de dados metagenômicos de comunidades microbianas complexas ou a filogenômica em grande escala exigem ferramentas que possam lidar com essa magnitude de dados de forma eficiente em termos de tempo e memória. Os algoritmos clássicos, mesmo os otimizados como o Clustal Omega, começaram a atingir seus limites práticos.

  

#### Estudo de Caso: HAlign4

  

Em resposta direta a esse desafio, foi desenvolvido o HAlign4, um algoritmo projetado especificamente para o alinhamento de conjuntos de dados ultra-grandes (CHEN et al., 2024).31 Ele representa o ápice da otimização de uma abordagem clássica (alinhamento em estrela, uma forma simplificada de alinhamento progressivo) através do uso de estruturas de dados e algoritmos de ponta, herdados da ciência da computação teórica. As principais inovações do HAlign4 são:

- Índice da Transformada de Burrows-Wheeler (BWT): Em vez de armazenar as sequências em texto simples, o que consome muita memória, o HAlign4 utiliza a BWT para indexar as sequências. A BWT é uma transformação de dados reversível que tende a agrupar caracteres idênticos, tornando os dados altamente compressíveis. Mais importante, ela permite buscas de subcadeias extremamente rápidas com um consumo de memória muito baixo. No contexto do HAlign4, isso permite a identificação eficiente de substrings comuns que servem como âncoras para o alinhamento, sem a necessidade de carregar todas as sequências na memória RAM (CHEN et al., 2024).31
    
- Algoritmo de Alinhamento Wavefront: Para a etapa de programação dinâmica entre as âncoras, o HAlign4 emprega o algoritmo de alinhamento wavefront. Este é um algoritmo de programação dinâmica otimizado que explora a matriz de alinhamento de forma muito mais eficiente do que os métodos tradicionais de Needleman-Wunsch ou Smith-Waterman. Ele reduz a complexidade temporal e espacial do alinhamento, especialmente para sequências muito similares, ao calcular apenas as células da matriz que são relevantes (SANTIAGO, 2020).
    

A combinação dessas duas técnicas confere ao HAlign4 um desempenho notável. Em testes de benchmark, ele demonstrou ser capaz de alinhar milhões de sequências em uma fração do tempo e com um consumo de memória consideravelmente menor do que outros programas de ponta como MAFFT, MUSCLE e ClustalΩ. Em alguns casos, onde os outros programas falhavam por falta de memória, o HAlign4 completava o alinhamento com sucesso (CHEN et al., 2024).31 Crucialmente, essa otimização de performance não veio com um grande sacrifício na acurácia; o HAlign4 mantém uma qualidade de alinhamento comparável à do MAFFT, tornando-o uma ferramenta poderosa e acessível para laboratórios que enfrentam desafios de bioinformática em grande escala (CHEN et al., 2024).31

  

### 3.2. A Revolução da Inteligência Artificial e do Deep Learning

  

Paralelamente aos esforços para escalar os algoritmos existentes, uma abordagem radicalmente diferente emergiu: a aplicação de técnicas de inteligência artificial para reimaginar o problema do MSA desde seus fundamentos. Essa revolução pode ser dividida em duas correntes principais: os algoritmos bioinspirados e os modelos de deep learning.

  

#### Algoritmos Bioinspirados

  

Uma revisão sistemática publicada por Ibrahim e colaboradores em 2024 mapeou o crescente campo dos algoritmos bioinspirados para MSA (IBRAHIM et al., 2024).1 Essas abordagens reformulam o MSA como um problema de otimização combinatória e aplicam heurísticas inspiradas em processos naturais para explorar o vasto espaço de possíveis alinhamentos em busca de uma solução ótima ou próxima da ótima. Os principais métodos incluem:

- Algoritmos Genéticos (GA): Inspirados na teoria da evolução de Darwin, os GAs operam com uma "população" de alinhamentos candidatos. Os alinhamentos são submetidos a operadores de "crossover" (recombinação de partes de dois alinhamentos pais) e "mutação" (modificações aleatórias, como mover uma lacuna). A "aptidão" de cada alinhamento é avaliada usando uma função objetivo (como a pontuação de soma dos pares), e os alinhamentos mais aptos têm maior probabilidade de "sobreviver" e "reproduzir" na próxima geração. Esse processo iterativo evolui a população em direção a soluções de alta qualidade (IBRAHIM et al., 2024).1
    
- Otimização por Enxame de Partículas (PSO): Inspirado no comportamento social de bandos de pássaros ou cardumes de peixes, o PSO utiliza uma população de "partículas", cada uma representando um alinhamento. Cada partícula se move através do espaço de soluções, ajustando sua trajetória com base em sua própria melhor experiência passada e na melhor experiência de todo o enxame (IBRAHIM et al., 2024).1
    
- Outras Técnicas: Outras abordagens incluem o Simulated Annealing (SA), que imita o processo de recozimento em metalurgia para escapar de ótimos locais, e algoritmos de Colônia de Abelhas Artificiais (ABC) e Forrageamento Bacteriano (BFOA) (IBRAHIM et al., 2024).1
    

A validação desses métodos depende fortemente de benchmarks padronizados como BAliBASE, SABmark, OXBench e PREFAB. Esses conjuntos de dados contêm alinhamentos de referência, geralmente baseados em superposição de estruturas 3D, contra os quais a acurácia dos novos algoritmos pode ser medida objetivamente (IBRAHIM et al., 2024).1

  

#### Modelos de Linguagem e Arquitetura Transformer

  

A inovação mais disruptiva no campo do MSA veio da área de Processamento de Linguagem Natural (NLP). Em vez de tratar o MSA como um problema de otimização, essa nova abordagem o trata como um problema de tradução de máquina, onde um conjunto de sequências não alinhadas (a "língua de origem") é traduzido para um alinhamento múltiplo (a "língua de destino").

  

#### Estudo de Caso: BetaAlign

  

BetaAlign é o principal exemplo dessa nova filosofia, publicado por Dotan e colaboradores em 2025 (DOTAN et al., 2025).5 Ele utiliza a arquitetura

transformer, o mesmo tipo de modelo de deep learning que alimenta grandes modelos de linguagem como o GPT. O mecanismo é o seguinte:

1. Transformação da Entrada: As múltiplas sequências não alinhadas são concatenadas em uma única "sentença" de entrada, com um caractere especial (como "|") separando-as.
    
2. Processamento pelo Transformer: Essa sentença é alimentada em um modelo transformer treinado. O transformer, com seus mecanismos de encoder, decoder e attention, aprende as complexas relações entre os "tokens" (resíduos) da entrada.
    
3. Geração da Saída: O modelo gera uma única "sentença" de saída, que é então reformatada para produzir o MSA final. Cada "palavra" na saída corresponde a uma coluna do alinhamento.
    

As vantagens dessa abordagem são profundas e representam uma mudança de paradigma:

- Aprendizado de Dinâmicas Evolutivas Complexas: Ao contrário dos algoritmos clássicos que dependem de matrizes de substituição estáticas (como BLOSUM62), o BetaAlign pode ser treinado em conjuntos de dados simulados que refletem dinâmicas evolutivas específicas e complexas. Isso significa que ele pode aprender padrões de substituição e taxas de indel que são específicos para uma determinada família de proteínas ou árvore filogenética, levando a uma acurácia potencialmente maior (DOTAN et al., 2025).5
    
- Alta Acurácia e Avaliação de Confiança: Em testes, o BetaAlign demonstrou ser altamente preciso, muitas vezes superando as ferramentas de ponta. Além disso, ao permutar a ordem das sequências de entrada, ele pode gerar múltiplos alinhamentos alternativos. A concordância entre esses alinhamentos pode ser usada para derivar uma medida de confiança, semelhante ao que o MUSCLEv5 faz, mas gerada por um mecanismo fundamentalmente diferente (DOTAN et al., 2025).5
    
- Transferência de Conhecimento (Transfer Learning): O modelo pode ser pré-treinado em vastos conjuntos de dados de alinhamentos e depois ajustado para tarefas específicas, aproveitando o poder da transferência de conhecimento para melhorar o desempenho (DOTAN et al., 2025).5
    

A principal limitação atual é a escalabilidade, já que os transformers têm um custo computacional e de memória que cresce quadraticamente com o comprimento da sequência de entrada. No entanto, o BetaAlign representa uma prova de conceito poderosa de que os modelos de linguagem podem capturar a "gramática" da evolução molecular de uma forma que os algoritmos tradicionais não conseguem.

  

### 3.3. Otimização de Performance e Alinhamento Guiado por Informação Externa

  

Além dos avanços em escalabilidade e IA, outras tendências importantes continuam a moldar o campo, focando na otimização da performance e na integração de dados externos.

  

#### Computação Paralela

  

A natureza computacionalmente intensiva da programação dinâmica, que ainda está no cerne de muitos algoritmos de MSA, tornou-a um alvo natural para a otimização através da computação paralela. Pesquisadores têm explorado o uso de arquiteturas de hardware modernas, como Unidades de Processamento Gráfico (GPUs) e implementações híbridas CPU-GPU, para acelerar esses cálculos (SHEHAB et al., 2019).14 Abordagens como o

diagonal traversing (onde as células da matriz de DP são preenchidas em paralelo ao longo de diagonais), o blocking e o slicing (que dividem a matriz em blocos menores que podem ser processados independentemente) demonstraram ser capazes de acelerar significativamente o cálculo de alinhamentos exatos ou heurísticos, obtendo reduções no tempo de execução de até 4 vezes (ALQURAN et al., 2024).14

  

#### Alinhamento Guiado por Informação Externa

  

A ideia de usar informações externas para melhorar um alinhamento não é nova, como visto com o T-Coffee e o EPA do Clustal Omega. No entanto, uma mudança de paradigma sutil, mas importante, tem ocorrido: a transição do uso de informações externas para validar um alinhamento para usá-las para conduzir ativamente o processo de alinhamento. Essa abordagem, chamada de alinhamento baseado em modelo (template-based alignment), representa um passo em direção à integração global de dados biológicos (CEDER; NOTREDAME, 2007).2

Um exemplo notável é o uso de anotações estruturais para alinhar sequências com baixa identidade. Proteínas como os Receptores Acoplados à Proteína G (GPCRs) podem ter identidades de sequência muito baixas, tornando o alinhamento tradicional quase impossível. No entanto, eles compartilham uma estrutura tridimensional altamente conservada. Ferramentas como o GPCRdb fornecem um sistema de numeração de consenso que mapeia resíduos para posições estruturais equivalentes (KOOISTRA et al., 2021).33 Usando esses "rótulos de consenso" como um gabarito, é possível gerar um alinhamento estruturalmente correto de GPCRs distantes, algo que um alinhamento puramente baseado em sequência falharia em fazer (MARTÍ-SOLANO; DEUPÍ, 2023).33 Isso demonstra o poder de integrar dados de diferentes modalidades (sequência, estrutura) para resolver problemas difíceis de alinhamento.

A análise desses avanços recentes revela uma bifurcação fascinante no desenvolvimento de algoritmos de MSA. Por um lado, ferramentas como o HAlign4 representam o auge da otimização de abordagens clássicas, empurrando os limites da engenharia computacional para resolver o problema da escala. Por outro lado, ferramentas como o BetaAlign representam uma ruptura conceitual, abandonando os princípios clássicos para abraçar um novo paradigma de modelagem biológica baseado em IA. A primeira é uma vitória da eficiência, a segunda, uma vitória da expressividade. Essa divergência não é um sinal de um campo fraturado, mas sim de um campo vibrante que está desenvolvendo um conjunto de ferramentas diversificado para enfrentar os múltiplos desafios da biologia moderna. O futuro, muito provavelmente, reside na síntese dessas duas trajetórias: a criação de modelos de IA com a capacidade de aprendizado do BetaAlign, mas construídos sobre arquiteturas computacionais com a escalabilidade do HAlign4.

  

## 4. Discussão Crítica e Perspectivas Futuras

  

O cenário do Alinhamento Múltiplo de Sequências está em um estado de fluxo dinâmico, impulsionado pelas pressões duplas do volume de dados e da inovação algorítmica. Essa transição não é apenas técnica, mas também conceitual, forçando a comunidade científica a reavaliar o que significa um alinhamento "correto" e como a qualidade deve ser medida. As perspectivas futuras apontam para uma integração cada vez maior de diversas fontes de dados biológicos, movendo o MSA de uma análise de strings para uma modelagem biológica verdadeiramente multimodal.

  

### 4.1. O Fim do Alinhamento "Correto"? A Ascensão dos Modelos Probabilísticos e de Ensembles

  

Historicamente, o objetivo de um programa de MSA era produzir um único alinhamento ótimo, apresentado como "a resposta" para um determinado conjunto de sequências. No entanto, há um reconhecimento crescente de que, para sequências divergentes ou regiões com múltiplas inserções e deleções, pode não haver um único alinhamento inequivocamente correto. Em vez disso, pode existir um ensemble de alinhamentos alternativos com pontuações semelhantes, cada um representando uma hipótese evolutiva plausível.

Essa mudança filosófica está se manifestando em várias das ferramentas mais avançadas. A abordagem do M-Coffee, com seu índice CORE, foi uma das primeiras a introduzir a noção de confiabilidade local, sinalizando para o usuário que nem todas as colunas de um alinhamento são igualmente confiáveis (CEDER; NOTREDAME, 2007).2 O MUSCLEv5 deu um passo adiante ao gerar explicitamente um

ensemble de alinhamentos de alta qualidade, em vez de um único resultado. Isso permite que os pesquisadores avaliem a robustez do alinhamento: regiões que são consistentemente alinhadas em todo o ensemble são provavelmente corretas, enquanto regiões que variam muito são inerentemente incertas (EDGAR, 2021).21

A abordagem do BetaAlign reforça ainda mais essa tendência. Ao permutar a ordem das sequências de entrada, ele gera múltiplos alinhamentos alternativos e usa uma abordagem de "votação majoritária" para construir um alinhamento de consenso e, implicitamente, para avaliar a certeza em cada posição (DOTAN et al., 2025).5 Juntas, essas tendências indicam um afastamento da busca por uma única "verdade absoluta" e uma aproximação de uma visão mais probabilística e matizada do espaço de soluções de alinhamento. Isso representa um aumento na sofisticação, pois fornece aos pesquisadores não apenas uma hipótese (o alinhamento), mas também uma estimativa da incerteza associada a essa hipótese, o que é crucial para uma interpretação científica robusta.

  

### 4.2. A Co-evolução dos Algoritmos e dos Benchmarks

  

O progresso no desenvolvimento de algoritmos de MSA tem sido inextricavelmente ligado à evolução dos conjuntos de dados de benchmark. Ferramentas como BAliBASE, SABmark, OXBench e PREFAB têm sido indispensáveis para o campo, fornecendo um "padrão ouro" baseado em estruturas 3D contra o qual a acurácia dos algoritmos pode ser objetivamente comparada (IBRAHIM et al., 2024).1 Esses

benchmarks permitiram que os desenvolvedores validassem novas ideias e que os usuários fizessem escolhas informadas sobre qual ferramenta usar. A melhoria contínua da acurácia de programas como MAFFT e Clustal Omega ao longo dos anos pode ser diretamente atribuída a ciclos de desenvolvimento e teste contra esses conjuntos de dados de referência (SIEVERS; HIGGINS, 2014).16

No entanto, a nova geração de algoritmos e desafios está começando a expor as limitações dos benchmarks existentes. Primeiro, a maioria dos benchmarks tradicionais é composta por conjuntos de dados relativamente pequenos (dezenas a centenas de sequências), o que os torna inadequados para avaliar a performance e a acurácia de algoritmos projetados para a escala de milhões de sequências, como o HAlign4. Segundo, esses benchmarks são baseados principalmente em domínios de proteínas globulares e podem não capturar adequadamente a complexidade de outros tipos de problemas, como o alinhamento de regiões intrinsecamente desordenadas, proteínas de membrana ou sequências de ncRNA com estruturas secundárias conservadas.

Mais profundamente, algoritmos como o BetaAlign, que são treinados para reconhecer padrões evolutivos complexos aprendidos a partir de simulações, levantam uma questão fundamental: os benchmarks atuais, baseados em estruturas estáticas, são o árbitro final da "correção" biológica? É possível que um alinhamento que maximize a similaridade estrutural (o critério do benchmark) não seja o que melhor reflete a história evolutiva. Isso sugere a necessidade de desenvolver uma nova geração de benchmarks, talvez baseados em simulações evolutivas mais realistas ou em dados funcionais, para avaliar adequadamente as capacidades dos novos algoritmos baseados em IA. A co-evolução entre algoritmos e benchmarks deve continuar para que o campo avance.

  

### 4.3. O Futuro do MSA: Rumo à Integração Multimodal

  

Olhando para o futuro, a trajetória mais promissora para o MSA parece ser a da integração de dados multimodais. O paradigma de tratar o MSA como um problema que começa e termina com um arquivo FASTA de sequências primárias está se tornando obsoleto. A verdadeira biologia de uma sequência é definida por seu contexto estrutural, funcional e regulatório. O futuro do MSA reside na capacidade dos algoritmos de integrar essas diversas camadas de informação para construir modelos mais ricos e biologicamente significativos.

O conceito de "alinhamento baseado em modelo" (template-based alignment) é um vislumbre desse futuro (CEDER; NOTREDAME, 2007).2 O exemplo do alinhamento de GPCRs usando os rótulos de consenso estrutural do GPCRdb demonstra como a incorporação de informações de uma modalidade diferente (estrutura 3D) pode resolver um problema que é intratável apenas com a sequência primária (MARTÍ-SOLANO; DEUPÍ, 2023).33

A visão para uma ferramenta de MSA de próxima geração é a de uma plataforma de integração. Tal ferramenta aceitaria como entrada não apenas as sequências, mas também, opcionalmente, coordenadas de estruturas do PDB, anotações de domínios funcionais do Pfam, dados de expressão gênica, informações sobre modificações pós-traducionais e até mesmo redes de interação proteína-proteína. O algoritmo usaria essas informações para ponderar e guiar o processo de alinhamento. Por exemplo, ele poderia penalizar fortemente a inserção de uma lacuna no meio de uma hélice alfa conhecida ou priorizar o alinhamento de resíduos conhecidos por estarem em um sítio ativo.

Essa abordagem transformaria o MSA de uma tarefa de alinhamento de strings em uma tarefa de modelagem de homologia holística. A realização dessa visão dependerá criticamente dos avanços em IA, pois os modelos de deep learning são particularmente adequados para aprender relações complexas a partir de dados heterogêneos. O MSA do futuro não será apenas sobre encontrar a melhor correspondência entre letras, mas sobre construir a hipótese mais coerente sobre a homologia funcional e estrutural, com base em toda a evidência biológica disponível.

  

## 5. Análise Conclusiva

  

Este relatório traçou a evolução do Alinhamento Múltiplo de Sequências, desde suas heurísticas clássicas fundamentais até as fronteiras impulsionadas pela inteligência artificial e pelo desafio do big data. A análise da literatura científica publicada entre 2019 e 2025 revela um campo em profunda transformação, redefinindo não apenas suas ferramentas, mas também seus conceitos centrais.

  

### 5.1. Qual é o tema teórico subjacente?

  

O tema teórico subjacente que permeia toda a história e o desenvolvimento do Alinhamento Múltiplo de Sequências é a tensão fundamental entre a complexidade computacional e o realismo biológico. Por um lado, o MSA é um problema de otimização NP-difícil, o que impõe uma barreira intransponível à obtenção de soluções exatas para problemas de tamanho realista. Isso força o campo a depender de heurísticas, que são, por definição, aproximações. Por outro lado, a realidade biológica que o MSA tenta modelar — a evolução molecular — é um processo imensamente complexo, envolvendo não apenas substituições simples de resíduos, mas também inserções, deleções, duplicações, rearranjos e a influência onipresente da estrutura tridimensional e da função.

A trajetória do campo pode ser vista como uma busca contínua para reconciliar essa tensão. As heurísticas clássicas, como o alinhamento progressivo, priorizaram a tratabilidade computacional, simplificando o processo evolutivo a um modelo hierárquico. Métodos iterativos e baseados em consistência buscaram aumentar o realismo biológico ao custo de maior demanda computacional. Os avanços mais recentes exemplificam essa dicotomia de forma ainda mais clara. Ferramentas como o HAlign4 representam um tour de force na otimização da tratabilidade computacional, permitindo que heurísticas estabelecidas sejam aplicadas em uma escala sem precedentes. Em contrapartida, abordagens como o BetaAlign representam um salto em direção ao realismo biológico, utilizando o poder do deep learning para aprender modelos evolutivos muito mais ricos e matizados do que as matrizes de substituição estáticas jamais poderiam capturar. O tema subjacente, portanto, é essa busca incessante por heurísticas que sejam simultaneamente eficientes o suficiente para serem práticas e sofisticadas o suficiente para serem biologicamente significativas.

  

### 5.2. Qual(is) as principais técnica(s) foi(ram) utilizada(s)?

  

A literatura do período de 2019 a 2025 demonstra o uso e o desenvolvimento de um espectro diversificado de técnicas, que podem ser agrupadas em três categorias principais:

1. Heurísticas Clássicas e suas Otimizações: Os pilares do MSA continuam sendo as heurísticas fundamentais. O Alinhamento Progressivo, baseado em árvores guia, permanece como a abordagem mais comum, exemplificada pela escalabilidade massiva do Clustal Omega. O Refinamento Iterativo, que corrige os erros da abordagem progressiva, é a marca registrada de ferramentas de alta acurácia como MUSCLE e MAFFT. A abordagem Baseada em Consistência, que visa maximizar a concordância com uma biblioteca de alinhamentos de pares, continua a definir o padrão de ouro de acurácia com ferramentas como T-Coffee.
    
2. Estruturas de Dados e Algoritmos de Otimização de Performance: Para lidar com o volume de dados, foram empregadas técnicas avançadas da ciência da computação. O MAFFT utiliza a Transformada Rápida de Fourier (FFT) para acelerar a detecção de homologia. O HAlign4 eleva essa otimização a um novo patamar com o uso do índice da Transformada de Burrows-Wheeler (BWT) e do algoritmo de alinhamento wavefront para alcançar uma escalabilidade sem precedentes. Além disso, a aplicação de arquiteturas de Computação Paralela (CPU-GPU) tem sido explorada para acelerar os gargalos de programação dinâmica.
    
3. Inteligência Artificial e Aprendizado de Máquina: Esta é a área de inovação mais disruptiva. Por um lado, os Algoritmos Bioinspirados (e.g., Algoritmos Genéticos, Otimização por Enxame de Partículas) reformulam o MSA como um problema de otimização explorado por populações de soluções. Por outro lado, e de forma mais transformadora, o Deep Learning — especificamente a arquitetura Transformer, emprestada do Processamento de Linguagem Natural — foi aplicado no BetaAlign para tratar o MSA como uma tarefa de tradução sequência-a-sequência, permitindo o aprendizado de modelos evolutivos complexos diretamente dos dados.
    

  

### 5.3. Qual a contribuição do artigo para o conhecimento científico de um modo geral, reflexivo?

  

De forma reflexiva, a contribuição deste relatório para o conhecimento científico é fornecer uma síntese crítica e integrada de um campo que não está apenas evoluindo, mas passando por uma mudança de paradigma. Ele demonstra que o Alinhamento Múltiplo de Sequências, longe de ser um problema "resolvido" da bioinformática, é uma área de pesquisa vibrante e essencial, cuja trajetória serve como um microcosmo para as tendências mais amplas da biologia computacional.

A análise revela que o desenvolvimento do MSA é impulsionado por uma simbiose entre as necessidades da biologia empírica e as capacidades da ciência da computação. O "dilúvio de dados" do sequenciamento de nova geração criou a necessidade de escalabilidade, que foi atendida por inovações em algoritmos e estruturas de dados. Ao mesmo tempo, a crescente compreensão da complexidade da estrutura e função molecular criou a necessidade de modelos mais realistas, que está sendo atendida pela revolução da inteligência artificial.

A principal contribuição reflexiva é a articulação da transição de uma visão determinística para uma visão probabilística do alinhamento. A ascensão de métodos de ensemble (MUSCLEv5), pontuações de confiabilidade (M-Coffee) e abordagens de votação (BetaAlign) sinaliza uma maior maturidade no campo. Reconhece-se que o objetivo não é mais encontrar "o" alinhamento correto, mas sim explorar o espaço de hipóteses de alinhamento plausíveis e quantificar a incerteza. Isso capacita os cientistas a tomar decisões mais informadas e a extrair conclusões mais robustas de suas análises.

Em última análise, o relatório ilustra como uma ferramenta computacional fundamental co-evolui com a ciência que ela serve. O futuro do MSA, focado na integração de dados multimodais, reflete a própria direção da biologia moderna: uma ciência integrativa que busca compreender os sistemas vivos através da síntese de informações de diversas escalas e modalidades. A jornada do MSA, de alinhar algumas sequências à mão a alinhar milhões com IA, encapsula a extraordinária e contínua transformação da biologia em uma ciência quantitativa e preditiva.

---

Referências e DOIs dos Artigos Mencionados

- Alquran, H. et al. (2024). Accelerating Multiple Sequence Alignments Using Parallel Computing. IEEE Access. DOI: 10.1109/ACCESS.2024.3364582. 14
    
- Ceder, O.; Notredame, C. (2007). M-Coffee: combining multiple sequence alignment methods with T-Coffee. Nucleic Acids Research, 35(Web Server issue), W643–W646. DOI: 10.1093/nar/gkm397. 2
    
- Chang, J. M.; Gulko, B.; Pollard, K. S. (2016). Thematic review: multiple sequence alignment. Briefings in Bioinformatics, 17(6), 1009-1023. DOI: 10.1093/bib/bbv110. 13
    
- Chen, J. et al. (2024). HAlign4: an efficient multiple sequence alignment tool for ultra-large DNA/RNA datasets. Bioinformatics, 40(12), btae718. DOI: 10.1093/bioinformatics/btae718. 31
    
- Choi, J.; Jung, H. J.; Lee, S. (2008). Multiple sequence alignment by conformational space annealing. Nucleic Acids Research, 36(21), 6892-6899. DOI: 10.1093/nar/gkn781. 20
    
- Chowdhury, B.; Garai, G. (2017). A review on multiple sequence alignment from the perspective of genetic algorithm. Genomics, 109(5-6), 419-431. DOI: 10.1016/j.ygeno.2017.06.007.
    
- Ding, C. et al. (2023). CsMYB15 positively regulates lignin biosynthesis in low temperature-induced granulation in navel orange. Frontiers in Plant Science, 14, 1223820. DOI: 10.3389/fpls.2023.1223820. 23
    
- Dotan, E. et al. (2025). BetaAlign: a deep learning approach for multiple sequence alignment. Bioinformatics, 41(1), btaf009. DOI: 10.1093/bioinformatics/btaf009. 5
    
- Edgar, R. C. (2004). MUSCLE: multiple sequence alignment with high accuracy and high throughput. Nucleic Acids Research, 32(5), 1792-1797. DOI: 10.1093/nar/gkh340. 3
    
- Edgar, R. C. (2021). Personal communication/website documentation for MUSCLEv5. 21
    
- Houghton, J. et al. (2006). Modern Biotechnology: A Primer for Students. 8
    
- Ibrahim, M. K. et al. (2024). Bioinspired Algorithms for Multiple Sequence Alignment: A Systematic Review and Roadmap. Applied Sciences, 14(6), 2433. DOI: 10.3390/app14062433. 1
    
- Katoh, K. et al. (2002). MAFFT: a novel method for rapid multiple sequence alignment based on fast Fourier transform. Nucleic Acids Research, 30(14), 3059-3066. DOI: 10.1093/nar/gkf436. 25
    
- Katoh, K.; Kuma, K. (2008). MAFFT version 6: improvement in accuracy of multiple sequence alignment. Briefings in Bioinformatics, 9(4), 286-295. DOI: 10.1093/bib/bbn013. 26
    
- Katoh, K.; Toh, H. (2008). Recent developments in the MAFFT multiple sequence alignment program. Briefings in Bioinformatics, 9(4), 286-298. 27
    
- Kooistra, A. J. et al. (2021). GPCRdb in 2021: Integrating GPCR sequence, structure and function. Nucleic Acids Research, 49(D1), D335-D343. DOI: 10.1093/nar/gkaa1080. 33
    
- Lee, C.; Grasso, C.; Sharlow, M. F. (2002). Multiple sequence alignment using partial order graphs. Bioinformatics, 18(3), 452-464.
    
- Lee, K. et al. (2020). G-quadruplexes in the human genome are enriched at open chromatin regions and R-loops. Nucleic Acids Research, 48(14), 7756-7769. 10
    
- Martí-Solano, M.; Deupí, X. (2023). mdciao documentation. 33
    
- Notredame, C. (2007). Recent evolutions of multiple sequence alignment algorithms. PLoS Computational Biology, 3(8), e123. DOI: 10.1371/journal.pcbi.0030123.
    
- Notredame, C.; Higgins, D. G.; Heringa, J. (2000). T-Coffee: A novel method for fast and accurate multiple sequence alignment. Journal of Molecular Biology, 302(1), 205-217.
    
- Petrov, V. et al. (2022). The interplay of RNA:DNA hybrid structure and G-quadruplexes determines the outcome of R-loop-replisome collisions. eLife, 11, e78618. DOI: 10.7554/eLife.78618. 9
    
- Popov, V. N. et al. (2025). Molecular Cloning, In Silico Analysis and Expression of plasma membrane-associated NAR2 Protein, SaNAR2.2, from Euhalophyte Salicornia altissima. bioRxiv. DOI: 10.1101/2025.03.09.642219. 29
    
- Sánchez, A. A. et al. (2025). Secreted retropepsin-like enzymes are essential for stress tolerance and biofilm formation in Pseudomonas aeruginosa. bioRxiv. DOI: 10.1101/2025.03.18.643919. 4
    
- Santiago, D. (2020). The Wavefront Alignment algorithm. Sciprints.
    
- Shehab, M. et al. (2019). Enhancing the Performance of Multiple Pairwise Alignments for Protein Sequences Using Hybrid CPU-GPU Implementations. IEEE/ACM Transactions on Computational Biology and Bioinformatics, 16(1), 127-136. 14
    
- Sievers, F. et al. (2011). Fast, scalable generation of high-quality protein multiple sequence alignments using Clustal Omega. Molecular Systems Biology, 7, 539. DOI: 10.1038/msb.2011.75. 15
    
- Sievers, F.; Higgins, D. G. (2014). Clustal Omega, accurate alignment of very large numbers of sequences. Methods in Molecular Biology, 1079, 105-116. DOI: 10.1007/978-1-62703-646-7_6. 16
    
- Sievers, F.; Higgins, D. G. (2018). Clustal Omega for making accurate alignments of many protein sequences. Protein Science, 27(1), 135-145. DOI: 10.1002/pro.3290. 17
    
- Söding, J. (2005). Protein-protein detection by HMM-HMM comparison. Bioinformatics, 21(7), 951-960.
    
- Somarowthu, S.; Levendosky, R. F.; Westhof, E. (2015). Tackling Structures of Long Noncoding RNAs. Accounts of Chemical Research, 48(7), 1944-1953. DOI: 10.1021/acs.accounts.5b00159. 12
    
- Tanaka, K. et al. (2015). Whole genome amplification approach reveals novel polyhydroxyalkanoate synthases (PhaCs) from Japan Trench and Nankai Trough seawater. BMC Microbiology, 15, 21. DOI: 10.1186/s12866-015-0357-9. 24
    
- Vanhoutte, I. et al. (2021). Distinct EH domains of the endocytic TPLATE complex confer lipid and protein binding. Nature Communications, 12, 3093. DOI: 10.1038/s41467-021-23341-3. 30
    
- Wallace, I. M. et al. (2006). M-Coffee: combining multiple sequence alignment methods with T-Coffee. Nucleic Acids Research, 34(Web Server issue), W643-W646.
    
- Wang, L. et al. (2025). Assessment of Self-Activation and Inhibition of Wheat Coiled-Coil Domain Containing NLR Immune Receptor Yr10CG. International Journal of Molecular Sciences, 26(X), Y. DOI: (não disponível). 19
    
- Wang, L.; Jiang, T. (1994). On the complexity of multiple sequence alignment. Journal of Computational Biology, 1(4), 337-348.
    
- Yildirim, S.; Heerema, C. J.; Yin, P. (2020). Biotechnological and Therapeutic Applications of Natural Nucleic Acid Structural Motifs. Advanced Therapeutics, 3(10), 2000090. DOI: 10.1002/adtp.202000090. 11
    
- Zhao, D. et al. (2023). Genome-wide identification and expression analysis of RVE gene family in seven Rosaceae species. BMC Genomics, 24(1), 22. DOI: 10.1186/s12864-022-09094-1. 28
    

#### Referências citadas

1. Bioinspired Algorithms for Multiple Sequence Alignment: A ... - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2076-3417/14/6/2433](https://www.mdpi.com/2076-3417/14/6/2433)
    
2. Recent Evolutions of Multiple Sequence Alignment Algorithms - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC1963500/](https://pmc.ncbi.nlm.nih.gov/articles/PMC1963500/)
    
3. MUSCLE: multiple sequence alignment with high accuracy and high throughput - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC390337/](https://pmc.ncbi.nlm.nih.gov/articles/PMC390337/)
    
4. A class of secreted retropepsin-like enzymes is required for osmotic stress tolerance, antibiotic resistance and biofilm formati - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.03.18.643919v1.full.pdf](https://www.biorxiv.org/content/10.1101/2025.03.18.643919v1.full.pdf)
    
5. BetaAlign: a deep learning approach for multiple sequence ..., acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article/41/1/btaf009/7945664](https://academic.oup.com/bioinformatics/article/41/1/btaf009/7945664)
    
6. The Historical Evolution and Significance of Multiple Sequence Alignment in Molecular Structure and Function Prediction - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2218-273X/14/12/1531](https://www.mdpi.com/2218-273X/14/12/1531)
    
7. Nucleosides, Nucleotides and Nucleic Acids Toolbox - Part II - Biosynth, acessado em junho 22, 2025, [https://www.biosynth.com/uploads/Brochures/E-Books/Nucleotide%2C%20Nucleoside%20and%20Nucleic%20Acids%20-%20Part%20II.pdf](https://www.biosynth.com/uploads/Brochures/E-Books/Nucleotide%2C%20Nucleoside%20and%20Nucleic%20Acids%20-%20Part%20II.pdf)
    
8. Modern Biotechnology Microbiology, Biochemistry&Engineering | PDF - Scribd, acessado em junho 22, 2025, [https://www.scribd.com/document/55459591/Modern-Biotechnology-Microbiology-Biochemistry-Engineering](https://www.scribd.com/document/55459591/Modern-Biotechnology-Microbiology-Biochemistry-Engineering)
    
9. The interplay of RNA:DNA hybrid structure and G-quadruplexes determines the outcome of R-loop-replisome collisions - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC8479836/](https://pmc.ncbi.nlm.nih.gov/articles/PMC8479836/)
    
10. Human immunodeficiency virus-1 induces host genomic R-loops and preferentially integrates its genome near the R-loop regions | eLife, acessado em junho 22, 2025, [https://elifesciences.org/articles/97348](https://elifesciences.org/articles/97348)
    
11. MIT Open Access Articles Biotechnological and Therapeutic Applications of Natural Nucleic Acid Structural Motifs, acessado em junho 22, 2025, [https://dspace.mit.edu/bitstream/handle/1721.1/131486/41061_2020_290_ReferencePDF.pdf?sequence=1&isAllowed=y](https://dspace.mit.edu/bitstream/handle/1721.1/131486/41061_2020_290_ReferencePDF.pdf?sequence=1&isAllowed=y)
    
12. Tackling Structures of Long Noncoding RNAs (Journal Article) | OSTI.GOV, acessado em junho 22, 2025, [https://www.osti.gov/pages/biblio/1628370](https://www.osti.gov/pages/biblio/1628370)
    
13. Multiple sequence alignment modeling: methods and applications - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/bib/article/17/6/1009/2606431](https://academic.oup.com/bib/article/17/6/1009/2606431)
    
14. Accelerating Multiple Sequence Alignments Using Parallel Computing - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/378111919_Accelerating_Multiple_Sequence_Alignments_Using_Parallel_Computing](https://www.researchgate.net/publication/378111919_Accelerating_Multiple_Sequence_Alignments_Using_Parallel_Computing)
    
15. Fast, scalable generation of high-quality protein multiple sequence alignments using Clustal Omega - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC3261699/](https://pmc.ncbi.nlm.nih.gov/articles/PMC3261699/)
    
16. PDF - BIOINFORMATICS ORIGINAL PAPER - Oxford University Press, acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article-pdf/29/8/989/48900723/bioinformatics_29_8_989.pdf](https://academic.oup.com/bioinformatics/article-pdf/29/8/989/48900723/bioinformatics_29_8_989.pdf)
    
17. (PDF) Clustal Omega for making accurate alignments of many protein sequences, acessado em junho 22, 2025, [https://www.researchgate.net/publication/319558348_Clustal_Omega_for_making_accurate_alignments_of_many_protein_sequences](https://www.researchgate.net/publication/319558348_Clustal_Omega_for_making_accurate_alignments_of_many_protein_sequences)
    
18. Fast, scalable generation of high‐quality protein multiple sequence ..., acessado em junho 22, 2025, [https://www.embopress.org/doi/abs/10.1038/msb.2011.75](https://www.embopress.org/doi/abs/10.1038/msb.2011.75)
    
19. Assessment of Self-Activation and Inhibition of Wheat Coiled-Coil Domain Containing NLR Immune Receptor Yr10 CG - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2223-7747/14/2/278](https://www.mdpi.com/2223-7747/14/2/278)
    
20. Multiple Sequence Alignment by Conformational Space Annealing - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC2576407/](https://pmc.ncbi.nlm.nih.gov/articles/PMC2576407/)
    
21. MUSCLE (alignment software) - Wikipedia, acessado em junho 22, 2025, [https://en.wikipedia.org/wiki/MUSCLE_(alignment_software)](https://en.wikipedia.org/wiki/MUSCLE_\(alignment_software\))
    
22. MUSCLE: multiple sequence alignment with high accuracy and high ..., acessado em junho 22, 2025, [https://www.ncbi.nlm.nih.gov/pmc/articles/PMC390337/](https://www.ncbi.nlm.nih.gov/pmc/articles/PMC390337/)
    
23. CsMYB15 positively regulates Cs4CL2-mediated lignin biosynthesis during juice sac granulation in navel orange - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2023.1223820/full](https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2023.1223820/full)
    
24. Whole genome amplification approach reveals novel polyhydroxyalkanoate synthases (PhaCs) from Japan Trench and Nankai Trough seawater - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC4326521/](https://pmc.ncbi.nlm.nih.gov/articles/PMC4326521/)
    
25. MAFFT: a novel method for rapid multiple sequence alignment ..., acessado em junho 22, 2025, [https://academic.oup.com/nar/article/30/14/3059/2904316](https://academic.oup.com/nar/article/30/14/3059/2904316)
    
26. Recent developments in the MAFFT multiple sequence alignment program | Briefings in Bioinformatics | Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/bib/article/9/4/286/266493](https://academic.oup.com/bib/article/9/4/286/266493)
    
27. a multiple sequence alignment program - Mafft, acessado em junho 22, 2025, [https://mafft.cbrc.jp/alignment/software/eval/accuracy.html](https://mafft.cbrc.jp/alignment/software/eval/accuracy.html)
    
28. Characterization of the REVEILLE family in Rosaceae and role of PbLHY in flowering time regulation - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9883883/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9883883/)
    
29. Molecular Cloning, In Silico Analysis and Expression of plasma membrane-associated NAR2 Protein, SaNAR2.2, from Euhalophyt - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.03.09.642219v1.full.pdf](https://www.biorxiv.org/content/10.1101/2025.03.09.642219v1.full.pdf)
    
30. Distinct EH domains of the endocytic TPLATE complex confer lipid and protein binding - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC8144573/](https://pmc.ncbi.nlm.nih.gov/articles/PMC8144573/)
    
31. HAlign 4: a new strategy for rapidly aligning millions of sequences ..., acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article/40/12/btae718/7912339](https://academic.oup.com/bioinformatics/article/40/12/btae718/7912339)
    
32. Overview of the modern approach of sequence alignment algorithms - AIP Publishing, acessado em junho 22, 2025, [https://pubs.aip.org/aip/acp/article/3274/1/040006/3338116/Overview-of-the-modern-approach-of-sequence?searchresult=1](https://pubs.aip.org/aip/acp/article/3274/1/040006/3338116/Overview-of-the-modern-approach-of-sequence?searchresult=1)
    
33. Use Consensus Labels as Multiple-Sequence-Alignment (MSA) — mdciao documentation, acessado em junho 22, 2025, [https://proteinformatics.uni-leipzig.de/mdciao/notebooks/06.MSA_via_Consensus_Labels.html](https://proteinformatics.uni-leipzig.de/mdciao/notebooks/06.MSA_via_Consensus_Labels.html)
    

**