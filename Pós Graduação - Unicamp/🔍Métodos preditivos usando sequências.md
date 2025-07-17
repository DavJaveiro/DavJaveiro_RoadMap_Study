# Métodos Preditivos Baseados em Sequências: Uma Análise da Revolução do Aprendizado Profundo na Biologia Molecular (2019-2025)

  

Resumo
Este relatório apresenta uma análise acadêmica exaustiva dos avanços em métodos preditivos baseados em sequências biológicas, com foco em artigos de alto impacto publicados entre 2019 e 2025. A investigação centra-se em dois problemas fundamentais da biologia molecular: a predição da estrutura tridimensional de proteínas a partir de sequências de aminoácidos e a predição da expressão gênica a partir de sequências de DNA. Analisam-se quatro modelos seminais que exemplificam a evolução do campo: AlphaFold2, que aperfeiçoou o uso de informação coevolutiva através de redes de atenção para atingir precisão atômica na predição de estruturas; ESMFold, que representa uma mudança de paradigma ao tratar a predição estrutural como uma tarefa de tradução de linguagem, operando a partir de sequências únicas com velocidade sem precedentes; Enformer, que aplicou arquiteturas Transformer para modelar interações regulatórias de longo alcance no genoma, melhorando significativamente a predição da expressão gênica; e ProstT5, que introduz o conceito de modelos "bilíngues" capazes de traduzir entre as modalidades de sequência (1D) e estrutura (3D), abrindo novas fronteiras em design de proteínas e busca por homologia. A análise crítica revela um tema unificador: o sucesso da arquitetura Transformer em capturar dependências de longo alcance em "linguagens" biológicas. Contudo, limitações significativas persistem, como a natureza estática das predições estruturais e a dificuldade em capturar a causalidade da variação genética interindividual. Conclui-se que o campo está a mover-se de modelos puramente preditivos para modelos generativos e multimodais, impulsionado por um ciclo virtuoso onde as predições de uma geração de modelos se tornam os dados de treino para a seguinte, redefinindo fundamentalmente a condução da pesquisa biológica.

  

## Introdução
O dogma central da biologia molecular, que descreve o fluxo de informação do DNA para o RNA e para a proteína, estabeleceu o alicerce da biologia moderna. Este princípio postula que a sequência linear de monômeros — nucleotídeos no DNA e aminoácidos nas proteínas — dita a forma tridimensional e, consequentemente, a função da molécula final (JUMPER et al., 2021). Durante décadas, decifrar este código, ou seja, prever a estrutura e a função a partir da sequência, permaneceu um dos desafios mais monumentais da ciência. A lacuna entre o vasto universo de sequências biológicas conhecidas, que cresce exponencialmente com os avanços no sequenciamento, e o número comparativamente diminuto de estruturas e funções caracterizadas experimentalmente, representou um gargalo crítico para a compreensão mecanicista dos processos vitais (JUMPER et al., 2021; VARADI et al., 2023).

Nos últimos anos, um profundo avanço tecnológico provocou uma mudança de paradigma na abordagem deste desafio. O advento e a maturação de técnicas de aprendizado profundo (deep learning), em particular as arquiteturas baseadas em mecanismos de atenção (attention), transformaram a predição biológica. O problema, antes dominado por abordagens baseadas em princípios físicos, termodinâmicos e estatísticos, começou a ser reformulado como um problema de processamento de linguagem natural (NLP) (AVSEC et al., 2021; LIN et al., 2023). As sequências de DNA e proteínas passaram a ser tratadas como "textos" ou "sentenças" escritos numa linguagem moldada pela evolução, e os modelos de aprendizado profundo, como ferramentas capazes de aprender a "gramática" e a "semântica" dessa linguagem para prever suas propriedades emergentes (HEINZINGER et al., 2024).

Este relatório disseca os avanços mais significativos neste campo, focando em dois eixos preditivos principais que foram revolucionados por estas novas abordagens. O primeiro eixo aborda a predição da estrutura tridimensional de proteínas a partir de sua sequência de aminoácidos, um problema que atormentou os cientistas por mais de 50 anos. O segundo eixo explora um desafio igualmente complexo: a predição da regulação e expressão gênica a partir da sequência de DNA, decifrando como elementos não codificantes distantes orquestram a atividade celular.

A estrutura deste documento seguirá uma trajetória lógica que espelha a evolução das ideias e metodologias no período de 2019 a 2025. Iniciaremos com a análise do AlphaFold2, um modelo que alcançou uma precisão sem precedentes ao sintetizar magistralmente a informação coevolutiva com uma arquitetura de atenção inovadora. Em seguida, exploraremos o ESMFold, que representa uma filosofia alternativa e radical, abandonando a necessidade de alinhamentos explícitos em favor de um modelo de linguagem puro, treinado em uma escala evolutiva. Posteriormente, a análise se deslocará para o domínio genômico com o Enformer, que adaptou a mesma tecnologia de atenção para modelar as interações de longo alcance que governam a expressão gênica. Finalmente, investigaremos a fronteira da multimodalidade com o ProstT5, um modelo "bilíngue" que aprende a traduzir entre as "linguagens" de sequência e estrutura, inaugurando uma era de capacidades generativas. Através desta análise, o relatório visa fornecer uma compreensão detalhada, crítica e integrada da revolução computacional que está a redefinir os limites do conhecimento em biologia molecular.

  

## Predição de Estrutura Proteica: A Mudança de Paradigma do Alinhamento à Linguagem

  

A predição da estrutura de proteínas testemunhou, no período analisado, uma cisão metodológica fundamental que redefiniu o campo. Esta seção irá dissecar esta divergência, contrastando duas filosofias distintas para extrair a informação evolutiva codificada nas sequências de aminoácidos. De um lado, o AlphaFold2 representa o ápice da abordagem baseada em coevolução, utilizando Alinhamentos de Múltiplas Sequências (MSAs) para inferir contatos espaciais e alimentando esta informação em uma sofisticada rede neural baseada em atenção (JUMPER et al., 2021). Do outro lado, o ESMFold encarna uma abordagem puramente linguística, tratando a predição como uma tarefa de "tradução" onde o conhecimento evolutivo é aprendido implicitamente a partir de uma escala massiva de sequências individuais, sem a necessidade de MSAs explícitos (LIN et al., 2023). A análise comparativa destas duas abordagens revela um compromisso fundamental entre precisão e velocidade, e entre a profundidade analítica de uma única família de proteínas e a amplitude do conhecimento extraído de todo o universo proteico. Esta dicotomia não representa apenas uma escolha técnica, mas aponta para uma futura convergência onde a força de ambas as filosofias poderá ser unificada.

  

### AlphaFold2: A Síntese do Conhecimento Evolutivo e Físico

  

O "problema do enovelamento de proteínas" — prever a estrutura tridimensional de uma proteína a partir de sua sequência de aminoácidos — persistiu como um grande desafio científico por mais de meio século.1 A determinação experimental de estruturas é um processo laborioso, caro e demorado, resultando numa vasta disparidade entre os bilhões de sequências de proteínas conhecidas e as aproximadamente 100.000 estruturas únicas depositadas no Protein Data Bank (PDB) antes desta revolução.1 O AlphaFold2, desenvolvido pela DeepMind, surgiu como uma solução computacional que alterou drasticamente este cenário.

A arquitetura do AlphaFold2 é uma rede neural profundamente redesenhada que integra de forma inovadora restrições evolutivas, físicas e geométricas.1 As suas entradas principais são a sequência de aminoácidos da proteína alvo e, crucialmente, um Alinhamento de Múltiplas Sequências (MSA) construído a partir de bancos de dados de sequências homólogas.3 O MSA fornece informação coevolutiva rica; resíduos que estão distantes na sequência linear mas que co-evoluem (mutam em conjunto) frequentemente estão em contato próximo na estrutura 3D.

O coração da rede é um módulo denominado Evoformer, uma arquitetura baseada em atenção projetada para processar e integrar a informação contida tanto no MSA (relações evolutivas) quanto numa representação de pares de resíduos (relações espaciais).3 O

Evoformer permite um fluxo de informação bidirecional entre estas duas representações, permitindo que o modelo raciocine simultaneamente sobre as restrições espaciais e evolutivas. Após o processamento pelo Evoformer, um "Módulo de Estrutura" traduz estas representações internas em coordenadas atômicas 3D explícitas. Este módulo refina iterativamente a estrutura da proteína, tratando-a como um "gás de resíduos" que se assenta numa conformação de baixa energia, resultando numa estrutura final altamente precisa.3

O impacto do AlphaFold2 foi imediato e profundo. Na 14ª Avaliação Crítica da Predição de Estruturas de Proteínas (CASP14), o modelo demonstrou uma precisão "competitiva com estruturas experimentais na maioria dos casos", superando drasticamente todos os outros métodos.1 Os resultados quantitativos foram impressionantes: o AlphaFold2 alcançou uma precisão mediana do esqueleto polipeptídico de 0.96 Å de desvio quadrático médio (RMSD), em comparação com 2.8 Å para o método concorrente mais próximo.2

Reconhecendo o potencial transformador deste avanço, os desenvolvedores disponibilizaram as predições em larga escala através do AlphaFold Protein Structure Database (AFDB) (VARADI et al., 2021). Este banco de dados cresceu exponencialmente e, em 2023, já fornecia cobertura estrutural para mais de 214 milhões de sequências de proteínas, democratizando o acesso a modelos estruturais de alta qualidade para a comunidade científica global.5 Para auxiliar na interpretação destes modelos, o AlphaFold2 fornece duas métricas de confiança cruciais: o pLDDT (

predicted Local Distance Difference Test), que avalia a confiança na predição da estrutura local de cada resíduo numa escala de 0 a 100, e o PAE (Predicted Aligned Error), que estima o erro esperado no posicionamento relativo de pares de resíduos, sendo particularmente útil para avaliar a confiança no arranjo de domínios.5

  

### A Alternativa dos Modelos de Linguagem: ESMFold e a Predição a partir de Sequência Única

  

Paralelamente ao aperfeiçoamento dos métodos baseados em MSA, uma filosofia radicalmente diferente emergiu, inspirada pelos sucessos da inteligência artificial no processamento de linguagem natural. Esta abordagem trata as sequências de proteínas como "sentenças" numa linguagem biológica, onde os aminoácidos são as "palavras".8 A hipótese central é que, ao treinar modelos de linguagem (

Large Language Models, LLMs) em vastos corpora de sequências de proteínas (na ordem de bilhões), estes modelos podem aprender de forma não supervisionada as regras gramaticais e semânticas desta linguagem, que encapsulam implicitamente padrões evolutivos, estruturais e funcionais.9

O ESMFold é a principal personificação desta abordagem. Ele é construído sobre o ESM-2, um modelo de linguagem proteica (pLM) que foi escalado para até 15 bilhões de parâmetros.11 A pesquisa demonstrou que, com o aumento da escala, estes modelos desenvolvem "capacidades emergentes", incluindo a habilidade de internalizar informação suficiente para prever a estrutura tridimensional de uma proteína com resolução atômica.10

A metodologia do ESMFold difere fundamentalmente da do AlphaFold2. É um modelo de ponta a ponta que utiliza as representações (embeddings) aprendidas pelo ESM-2 para prever diretamente as coordenadas atômicas a partir de uma única sequência de aminoácidos como entrada.11 Isto elimina a necessidade de realizar a busca, por vezes computacionalmente intensiva e nem sempre bem-sucedida, por sequências homólogas para construir um MSA. O ESMFold, portanto, aprende a informação evolutiva de forma implícita, a partir do vasto contexto de todas as sequências vistas durante o seu treinamento, em vez de explicitamente, a partir de um conjunto de homólogos para uma proteína específica.

Os resultados desta abordagem delineiam um novo conjunto de compromissos no campo da predição de estruturas. A vantagem mais notável do ESMFold é a velocidade: sua inferência é uma ordem de magnitude mais rápida do que a do AlphaFold2.11 Esta eficiência computacional é crucial para aplicações em larga escala, como a exploração estrutural de vastos bancos de dados de sequências metagenômicas, onde a construção de MSAs para milhões de sequências seria impraticável.

A precisão do ESMFold está intrinsecamente ligada à "compreensão" que o modelo de linguagem tem de uma determinada sequência, medida por uma métrica chamada perplexidade. A perplexidade quantifica quão bem o modelo pode prever o próximo aminoácido numa sequência, dado o contexto anterior. Estudos demonstraram uma forte correlação negativa entre a perplexidade e a acurácia da predição estrutural: quanto menor a perplexidade (ou seja, quanto melhor o modelo "entende" a sequência), mais precisa é a estrutura prevista.11 Para sequências de baixa perplexidade, o ESMFold alcança uma precisão comparável à do AlphaFold2 e de outros métodos de ponta.11

  

### Análise Crítica e Comparativa: Limites da Predição Estrutural Estática

  

A comparação direta entre o AlphaFold2 e o ESMFold revela um claro compromisso (trade-off) entre precisão e velocidade/generalidade. O AlphaFold2 permanece o "padrão-ouro" em termos de precisão atômica, especialmente para proteínas com um número suficiente de sequências homólogas para construir um MSA robusto.4 No entanto, a sua dependência de MSAs torna-o mais lento e menos eficaz para "proteínas órfãs" que não têm homólogos conhecidos. O ESMFold, por outro lado, oferece uma alternativa extremamente rápida e valiosa para a triagem de estruturas em larga escala e para a análise de sequências sem homólogos detectáveis, embora a sua precisão possa ser inferior para sequências que o modelo de linguagem considera "difíceis" ou de alta perplexidade.14

Apesar de suas diferenças filosóficas, ambos os modelos partilham limitações fundamentais que definem as fronteiras atuais do campo. A mais significativa é a sua natureza estática. Tanto o AlphaFold2 quanto o ESMFold preveem uma única conformação de baixa energia, o que representa uma simplificação excessiva da realidade biológica.2 As proteínas são máquinas dinâmicas que frequentemente adotam múltiplas conformações para executar suas funções. Um estudo de 2024 investigou o desempenho do AlphaFold2 em proteínas que alternam entre duas conformações distintas (

fold-switching proteins) e descobriu que o modelo teve uma taxa de sucesso modesta (aproximadamente 25%) em prever ambas as estruturas. Crucialmente, as métricas de confiança do modelo, como o pLDDT, não conseguiram discriminar de forma confiável entre os estados de baixa e alta energia, indicando que o modelo ainda tem muito a aprender sobre a paisagem energética das proteínas.16

Outra limitação crítica é a falta de contexto biológico. Os modelos são treinados para prever a estrutura de uma cadeia polipeptídica isolada no vácuo. Eles não consideram explicitamente o ambiente celular complexo, incluindo a presença de ligantes, íons metálicos, modificações pós-traducionais (PTMs), ou interações com outras macromoléculas como DNA, RNA ou outras proteínas.6 Estes fatores são frequentemente essenciais para determinar a conformação funcional final de uma proteína.

Por estas razões, um consenso emergiu na comunidade científica: as predições computacionais, mesmo as de altíssima confiança, devem ser tratadas como "hipóteses valiosas" (TERWILLIGER et al., 2023). Elas são ferramentas extraordinariamente poderosas que aceleram a pesquisa e a formulação de hipóteses, mas não substituem a necessidade de validação e determinação experimental da estrutura para confirmar detalhes finos, especialmente aqueles que envolvem interações dinâmicas ou dependentes do contexto.6

  

## Decifrando o Código Regulatório: Predição da Expressão Gênica a partir do DNA

  

Enquanto a predição da estrutura proteica lida com o enovelamento de uma cadeia linear num objeto 3D relativamente estável, a predição da função regulatória do genoma apresenta um desafio de complexidade superior. A regulação gênica é um processo dinâmico, específico do tipo celular e do tempo, orquestrado por uma complexa interação entre a sequência de DNA e uma miríade de fatores proteicos. Elementos regulatórios como enhancers e silenciadores podem influenciar a expressão de um gene a partir de distâncias de centenas de quilobases, tornando a captura destas interações de longo alcance um problema computacional formidável.19 Esta seção explora como as arquiteturas de aprendizado profundo, em particular os Transformers, foram adaptadas para enfrentar este desafio. O modelo Enformer representa um salto significativo ao modelar com sucesso estas interações distais. No entanto, a sua subsequente falha em capturar com precisão a variação de expressão entre indivíduos expõe uma lacuna crítica entre a predição baseada em correlação e a compreensão mecanicista e causal. Este facto revela que o "código" regulatório não reside apenas na sequência de referência do genoma, mas emerge da interação única entre o genótipo de um indivíduo e o seu contexto celular específico.

  

### Enformer: Modelando Interações de Longo Alcance com Transformers

  

Para prever a expressão gênica a partir da sequência de DNA, um modelo deve ser capaz de integrar informação de regiões genômicas muito distantes. Modelos anteriores, baseados principalmente em Redes Neurais Convolucionais (CNNs), eram limitados pelo seu "campo receptivo" local, incapazes de conectar eficientemente um promotor de gene com um enhancer distal.19 O Enformer foi desenvolvido para superar esta limitação, adaptando a arquitetura Transformer, que se mostrou tão bem-sucedida no processamento de linguagem natural e na predição de estruturas proteicas.20

A arquitetura do Enformer utiliza camadas de atenção (self-attention) para permitir que cada posição numa longa sequência de DNA de entrada (até 200.000 pares de bases) "atenda" e troque informação com todas as outras posições dentro dessa janela.22 Isto cria um fluxo de informação global, permitindo que o modelo aprenda as relações funcionais entre elementos regulatórios distais e os genes que eles controlam. Para tornar o problema computacionalmente tratável, o Enformer primeiro usa uma série de blocos convolucionais para reduzir a resolução da sequência, antes de alimentar esta representação em blocos Transformer.22

O modelo foi treinado num regime de aprendizagem multitarefa (multitask learning), onde foi otimizado para prever simultaneamente milhares de alvos genômicos diferentes a partir da mesma sequência de DNA de entrada.20 Estes alvos incluíam dados de expressão gênica de centenas de tipos de células e tecidos (medidos por CAGE-seq) e uma variedade de marcadores epigenéticos, como acessibilidade da cromatina (DNase-seq) e modificações de histonas (ChIP-seq). Esta abordagem multitarefa permite que o modelo aprenda representações mais robustas e generalizáveis do código regulatório.

Os resultados do Enformer demonstraram uma melhoria substancial na precisão da predição em comparação com os modelos de ponta anteriores, como o Basenji2.19 O modelo não só melhorou a correlação entre a expressão gênica prevista e a medida experimentalmente, como também se mostrou mais preciso na predição do impacto funcional de variantes genéticas em ensaios de mutagênese de saturação.21 Uma das suas capacidades mais notáveis foi a de aprender a prever interações

enhancer-promotor diretamente da sequência de DNA, alcançando um desempenho competitivo com métodos que dependem de dados experimentais de interação cromossômica como entrada.20

  

### O Desafio da Variação Interindividual: A Lacuna entre Predição e Compreensão

  

Apesar do sucesso do Enformer e de modelos similares (como Basenji2 e ExPecto) em prever os níveis médios de expressão gênica numa população, estudos de validação subsequentes revelaram uma limitação crítica e surpreendente. Quando testados na tarefa de prever a variação da expressão de um determinado gene entre diferentes indivíduos com genomas distintos, o desempenho destes modelos caiu drasticamente.27 De forma contraintuitiva, as predições do Enformer para a expressão gênica individual eram frequentemente não correlacionadas ou até mesmo

negativamente correlacionadas com os valores observados experimentalmente.28

Esta falha na predição direcional do efeito de variantes genéticas expõe uma lacuna fundamental entre correlação e causalidade. A hipótese que emergiu destes estudos é que os modelos não aprenderam verdadeiramente a "gramática cis-regulatória" subjacente — as regras que ditam como uma mudança na sequência (uma variante) causa uma mudança na expressão.29 Em vez disso, os modelos parecem ter aprendido a identificar padrões de sequência e variantes que são estatisticamente

correlacionados com níveis de expressão altos ou baixos na população de treinamento. Eles se tornaram excelentes correlacionadores, mas maus mecanicistas. Por exemplo, o modelo pode aprender que a presença de um certo SNP (Polimorfismo de Nucleotídeo Único) está associada a uma menor expressão de um gene, mas falha em prever que a introdução desse mesmo SNP no genoma de outro indivíduo (com um fundo genético diferente) poderia ter um efeito nulo ou até mesmo oposto.

Esta limitação é particularmente problemática para aplicações em medicina de precisão, onde o objetivo é prever o efeito de variantes genéticas no genoma de um paciente específico. Para superar esta lacuna, novas abordagens começaram a surgir. Um exemplo é o "Performer", um modelo que tenta corrigir este déficit através de uma estratégia de fine-tuning (WANG et al., 2024). O Performer utiliza o modelo Enformer pré-treinado, que já possui um vasto conhecimento sobre a gramática regulatória geral, e ajusta-o (fine-tunes) em genomas pessoais e dados de expressão correspondentes. Este processo permite que o modelo retenha o poder de representação do Enformer, ao mesmo tempo que adquire a capacidade de prever corretamente a direção dos efeitos das variantes, de forma semelhante ao que modelos lineares mais simples, como o PrediXcan, conseguem fazer.28 Esta tendência de hibridizar o poder de representação do aprendizado profundo com a robustez causal de modelos mais simples sinaliza um reconhecimento importante das limitações atuais e um caminho promissor para o futuro da genômica preditiva.

  

## A Fronteira da Multi-Modalidade: Modelos Bilíngues para Sequência e Estrutura

  

A evolução mais recente e conceitualmente mais avançada no campo dos métodos preditivos baseia-se na fusão de diferentes modalidades de informação biológica dentro de um único framework computacional. Esta abordagem trata a sequência linear de uma proteína (1D) e a sua estrutura tridimensional (3D) não como um problema e sua solução, mas como duas "linguagens" interconversíveis que descrevem a mesma entidade biológica (HEINZINGER et al., 2024). O modelo ProstT5 exemplifica esta nova fronteira, ao ser treinado para "traduzir" entre sequências de aminoácidos e uma representação simbólica e linear da estrutura. Este avanço não é apenas uma proeza técnica; representa um passo fundamental em direção a modelos verdadeiramente generativos, capazes de navegar no espaço de sequência-estrutura para projetar novas proteínas com funções desejadas (inverse folding). Este progresso é alimentado diretamente pelo sucesso de modelos como o AlphaFold2, num ciclo virtuoso onde as predições de alta qualidade de uma geração de modelos se tornam os dados de treinamento essenciais para a próxima, acelerando a inovação de forma exponencial.

  

### ProstT5: Traduzindo entre o Código e a Forma

  

O conceito central por trás do ProstT5 é o "bilinguismo": a capacidade de um único modelo de compreender e traduzir entre a linguagem da sequência (aminoácidos) e a linguagem da estrutura (interações espaciais).31 Para tornar a estrutura 3D, inerentemente geométrica, amena às arquiteturas de processamento de linguagem baseadas em texto, foi necessário primeiro convertê-la numa representação linear.

A metodologia do ProstT5 alcança isto ao utilizar o método Foldseek para transliterar as coordenadas 3D de uma estrutura proteica numa sequência 1D de tokens, denominados 3Di.8 Cada token

3Di representa de forma discreta o ambiente estrutural e as interações de um resíduo, criando um alfabeto estrutural. Uma vez que tanto a sequência de aminoácidos quanto a estrutura estão representadas como strings de tokens, o problema pode ser enquadrado como uma tarefa de tradução automática.

A arquitetura do ProstT5 é baseada no ProtT5, um poderoso pLM pré-treinado que utiliza a arquitetura T5 encoder-decoder.8 O modelo foi então submetido a um processo de

fine-tuning num vasto conjunto de dados composto por milhões de pares de sequências de aminoácidos e suas correspondentes sequências de tokens 3Di, derivados das predições de alta qualidade do AlphaFoldDB.31 Durante o treinamento, o modelo aprende a tarefa de tradução bidirecional. Tokens especiais, como

<AA2fold> (aminoácido para estrutura) e <fold2AA> (estrutura para aminoácido), são usados para instruir o modelo sobre a direção da tradução desejada.8

Uma consequência importante deste treinamento bilíngue é a melhoria das representações internas do modelo (os embeddings). Mesmo quando a entrada é apenas a sequência de aminoácidos, os embeddings do ProstT5 mostraram um desempenho superior em tarefas preditivas relacionadas com a estrutura, como a predição de estrutura secundária e a classificação hierárquica de domínios estruturais (CATH), em comparação com o seu modelo base, o ProtT5.8 Isto sugere que forçar o modelo a aprender a conexão explícita entre sequência e estrutura enriquece a sua compreensão implícita da biologia das proteínas.

  

### Novas Capacidades Preditivas: Dobramento Inverso e Busca por Homologia Acelerada

  

A arquitetura bilíngue do ProstT5 desbloqueia capacidades que vão muito além da predição unidirecional. A mais promissora é o dobramento inverso (inverse folding), que está no cerne do design de proteínas de novo.36 Nesta tarefa, o utilizador fornece um andaime estrutural desejado (na forma de uma sequência de tokens

3Di) e o modelo, operando na direção <fold2AA>, gera novas sequências de aminoácidos que são preditas como tendo alta probabilidade de se enovelarem na estrutura alvo.8 Esta capacidade tem o potencial de revolucionar a engenharia de proteínas, permitindo a criação de enzimas, anticorpos e outros bioterápicos com propriedades personalizadas.

Outra aplicação de impacto imediato é a busca por homologia estrutural acelerada.8 Tradicionalmente, encontrar proteínas com estruturas semelhantes (homólogos remotos) requer o alinhamento estrutural 3D, um processo computacionalmente lento. O ProstT5 oferece um atalho engenhoso. Em vez de prever a estrutura 3D completa de uma sequência de consulta, o que é lento, o modelo pode prever muito rapidamente a sua sequência de tokens

3Di correspondente. Esta sequência 3Di, sendo uma representação 1D, pode então ser usada com algoritmos de alinhamento de sequência altamente otimizados (como o próprio Foldseek) para pesquisar em vastos bancos de dados.35 O resultado é uma busca que mantém a sensibilidade de um alinhamento a nível estrutural, mas que é executada a uma velocidade ordens de magnitude (milhares de vezes) mais rápida.8 Esta capacidade é particularmente crucial para a anotação funcional dos enormes volumes de dados de sequências provenientes de projetos metagenômicos, onde a maioria das proteínas não tem função conhecida.8

  

## Conclusão e Perspectivas Futuras

  
  

### Síntese dos Avanços e o Papel Central da Arquitetura de Atenção

  

A jornada pelos métodos preditivos baseados em sequências entre 2019 e 2025 revela uma trajetória de avanço exponencial, impulsionada por uma convergência de poder computacional, disponibilidade de dados em larga escala e inovação algorítmica. O percurso começou com a solução do problema de enovelamento de proteínas com precisão atômica pelo AlphaFold2, que aperfeiçoou o uso de informação coevolutiva. Seguiu-se a emergência de uma filosofia alternativa com os modelos de linguagem proteica puros, como o ESMFold, que priorizaram a velocidade e a generalidade. O desafio da regulação gênica foi abordado pelo Enformer, que estendeu estas arquiteturas para decifrar interações de longo alcance no DNA, embora expondo os limites da predição correlacional. Finalmente, a fronteira foi empurrada para a multimodalidade com modelos como o ProstT5, que tratam sequência e estrutura como linguagens intertraduzíveis, abrindo caminho para o design generativo.

O fio condutor que une todos estes avanços é a adaptação e o sucesso da arquitetura Transformer e do seu mecanismo de atenção.19 Este mecanismo provou ser excecionalmente eficaz na captura das dependências de longo alcance que são intrínsecas às sequências biológicas, seja entre resíduos coevolutivos numa proteína, entre um

enhancer e um promotor distantes no genoma, ou entre as palavras da "linguagem" biológica.

Esta era de progresso também é caracterizada por um ciclo de feedback dados-modelo cada vez mais rápido. As predições de alta qualidade de um modelo de ponta (como as milhões de estruturas no AlphaFoldDB) tornam-se os dados de treinamento para a próxima geração de modelos (como o ProstT5). Este ciclo virtuoso acelera a inovação a um ritmo sem precedentes, mas também acarreta o risco de amplificar vieses e erros sistemáticos se não for continuamente ancorado e validado por novos dados experimentais.

  

### Tabela 1: Quadro Comparativo dos Principais Métodos Preditivos Baseados em Sequência (2019-2025)

  
  

|   |   |   |   |   |
|---|---|---|---|---|
|Característica|AlphaFold2|Enformer|ESMFold|ProstT5|
|Problema Preditivo Principal|Estrutura 3D de proteínas|Expressão gênica e regulação|Estrutura 3D de proteínas|Tradução sequência-estrutura|
|Tipo de Sequência de Entrada|Aminoácidos|DNA|Aminoácidos|Aminoácidos e/ou tokens 3Di|
|Arquitetura de IA Principal|Evoformer (baseado em atenção)|Transformer (baseado em atenção)|Transformer (pLM)|T5 (Encoder-Decoder Transformer)|
|Dependência de Dados Externos|MSA obrigatório|Nenhum (apenas sequência)|Nenhum (apenas sequência)|Banco de dados de estruturas para fine-tuning|
|Principal Vantagem|Precisão atômica|Captura de interações de longo alcance|Velocidade e predição de sequência única|Capacidades generativas (design) e busca rápida|
|Limitação Notável|Lento; requer homólogos; prediz conformação estática|Falha na predição direcional de variantes interindividuais|Menor precisão para sequências de alta perplexidade|Dependente da qualidade dos dados de estrutura para treinamento|

  

### Limitações Atuais e o Caminho a Seguir

  

Apesar dos avanços monumentais, as fronteiras atuais da predição baseada em sequências são claramente definidas pelas limitações dos modelos existentes. O caminho a seguir aponta para a superação destes desafios:

- Além da Estrutura Estática: Uma das limitações mais prementes é a incapacidade dos modelos atuais de capturar a natureza dinâmica das macromoléculas. O futuro exigirá modelos capazes de prever não apenas uma, mas um ensemble de conformações, representando diferentes estados funcionais, o impacto de modificações pós-traducionais e a interação com ligantes e outras moléculas.6
    
- Rumo à Compreensão Causal: Como demonstrado pelas falhas do Enformer, a correlação não é suficiente para a medicina de precisão. O desenvolvimento de modelos que capturem a causalidade biológica — a "gramática" fundamental da regulação — é um objetivo crítico. Isto pode envolver a integração de princípios de causalidade no design dos modelos ou o treinamento com dados de perturbação em larga escala.
    
- Integração Multi-ômica: A biologia funciona como um sistema integrado. O futuro da biologia preditiva reside na fusão de múltiplos tipos de dados (genômica, epigenômica, transcriptômica, proteômica estrutural) em modelos unificados. Abordagens emergentes que utilizam Redes Neurais de Grafos (GNNs) para integrar dados de interação, como redes de interação proteína-proteína ou mapas de contato da cromatina, representam um passo importante nesta direção.37
    
- Design Generativo: A transição de modelos puramente preditivos para modelos generativos, prenunciada pelo ProstT5, representa talvez a fronteira mais excitante. A capacidade de não apenas "ler" a linguagem da vida, mas também de a "escrever" — projetando novas sequências de proteínas ou elementos regulatórios com funções sob medida — tem o potencial de transformar a biotecnologia e a medicina.
    

Em suma, a revolução do aprendizado profundo moveu a biologia molecular para uma nova era. Os desafios que permanecem são tão grandes quanto os sucessos alcançados, prometendo um futuro de descobertas ainda mais profundas na intersecção entre a computação e as ciências da vida.

---

## Análise Final

  

Qual é o tema teórico subjacente?

O tema teórico subjacente que perpassa todos os avanços discutidos é a hipótese de que as sequências biológicas, tanto de DNA quanto de proteínas, podem ser eficazmente modeladas como uma forma de linguagem. A aplicação de arquiteturas computacionais desenvolvidas para o Processamento de Linguagem Natural (NLP), notavelmente a arquitetura Transformer com o seu mecanismo de atenção, permite decodificar a "gramática" (regras sintáticas, como a estrutura secundária) e a "semântica" (significado funcional, como a estrutura 3D ou a atividade regulatória) que estão codificadas nestas sequências. Este paradigma unifica problemas biológicos aparentemente díspares — como o enovelamento de proteínas e a regulação gênica — sob uma mesma e poderosa estrutura computacional, tratando-os como diferentes dialetos da linguagem da evolução.

Qual(is) as principais técnica(s) foi(ram) utilizada(s)?

A principal técnica que impulsionou a revolução descrita neste relatório é o Aprendizado Profundo (Deep Learning). Dentro deste vasto campo, a arquitetura Transformer e o seu componente fundamental, o mecanismo de atenção (attention mechanism), são a tecnologia chave que possibilitou os avanços seminais do AlphaFold2 (através do seu módulo Evoformer), Enformer, ESMFold e ProstT5 (baseado na arquitetura T5). Outras técnicas importantes incluem Redes Neurais Convolucionais (CNNs), frequentemente usadas em estágios de processamento inicial; aprendizagem multitarefa (multitask learning), para treinar modelos em diversos alvos simultaneamente e melhorar a generalização; e estratégias de aprendizagem por transferência (transfer learning) e ajuste fino (fine-tuning), que permitem aproveitar o conhecimento de modelos pré-treinados em dados massivos para tarefas mais específicas.

Qual a contribuição do artigo para o conhecimento científico de um modo geral, reflexivo?

Coletivamente, os artigos analisados marcam uma mudança de paradigma fundamental na biologia molecular, transitando de uma ciência primariamente observacional e experimental para uma que é também profundamente preditiva e, cada vez mais, generativa. A contribuição reflexiva mais importante é a demonstração empírica de que regras biológicas de enorme complexidade, esculpidas ao longo de éons de evolução, podem ser aprendidas de forma implícita por algoritmos de inteligência artificial a partir de dados em grande escala. Isto não só resolve problemas científicos que persistiram por mais de 50 anos, como o enovelamento de proteínas, mas também abre campos inteiramente novos, como o design de proteínas de novo em escala e a anotação funcional do vasto universo metagenômico. A reflexão final é que a fronteira entre a ciência da computação e a biologia fundamental está a dissolver-se, criando um ciclo virtuoso onde a predição computacional acelera a descoberta experimental, que por sua vez gera os dados necessários para treinar modelos ainda mais poderosos. Este ciclo está a redefinir fundamentalmente não apenas as ferramentas disponíveis para os biólogos, mas a própria natureza de como a pesquisa biológica é concebida e conduzida.

---

## Referências Bibliográficas

  

AVSEC, Ž. et al. Effective gene expression prediction from sequence by integrating long-range interactions. Nature Methods, v. 18, n. 10, p. 1196–1203, 2021. DOI: 10.1038/s41592-021-01252-x.

BIGNESS, J.; LOINAZ, X.; RAMACHANDRAN, S. Integrating Long-Range Regulatory Interactions to Predict Gene Expression with a Graph Convolutional Network. Journal of Computational Biology, v. 29, n. 6, p. 575-588, 2022. DOI: 10.1089/cmb.2021.0543.

CHAKRAVARTY, D. et al. AlphaFold2 has more to learn about protein energy landscapes. bioRxiv, 2023. DOI: 10.1101/2023.12.12.571380. Publicado em Nature Communications, 2024. DOI: 10.1038/s41467-024-51801-z.

DE ALMEIDA, T. P. et al. Deep learning models of cis-regulation fail to predict the impact of variants on expression. bioRxiv, 2023. DOI: 10.1101/2023.06.20.545763.

HEINZINGER, M. et al. Bilingual language model for protein sequence and structure. NAR Genomics and Bioinformatics, v. 6, n. 4, lqae150, 2024. DOI: 10.1093/nargab/lqae150.

JUMPER, J. et al. Highly accurate protein structure prediction with AlphaFold. Nature, v. 596, p. 583–589, 2021. DOI: 10.1038/s41586-021-03819-2.

KAPLAN, N. et al. Sequence-to-expression models predict transcription factor binding but not gene expression effects. Nature Genetics, v. 55, p. 1470–1483, 2023. DOI: 10.1038/s41588-023-01490-5.

LIN, Z. et al. Evolutionary-scale prediction of atomic-level protein structure with a language model. Science, v. 379, n. 6637, p. 1123–1130, 2023. DOI: 10.1126/science.ade2574.

TERWILLIGER, T. C. et al. AlphaFold predictions are valuable hypotheses, and accelerate but do not replace experimental structure determination. bioRxiv, 2023. DOI: 10.1101/2022.11.21.517405.

VARADI, M. et al. AlphaFold Protein Structure Database: massively expanding the structural coverage of protein-sequence space with high-accuracy models. Nucleic Acids Research, v. 50, n. D1, p. D439–D444, 2022. DOI: 10.1093/nar/gkab1061.

VARADI, M. et al. AlphaFold Protein Structure Database in 2024: Providing structure coverage for over 214 million protein sequences. Nucleic Acids Research, v. 52, n. D1, p. D368-D375, 2024. DOI: 10.1093/nar/gkad1011.

WANG, J. et al. Performer: a deep learning approach for personal gene expression prediction. bioRxiv, 2024. DOI: 10.1101/2024.07.27.605449.

WANG, J. et al. A spatial-graph-neural-network-based approach for gene expression prediction. Nucleic Acids Research, v. 52, n. 13, e60, 2024. DOI: 10.1093/nar/gkae425.

#### Referências citadas

1. Highly accurate protein structure prediction with AlphaFold - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/34265844/](https://pubmed.ncbi.nlm.nih.gov/34265844/)
    
2. Before and after AlphaFold2: An overview of protein structure prediction - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10011655/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10011655/)
    
3. Highly accurate protein structure prediction with AlphaFold - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC8371605/](https://pmc.ncbi.nlm.nih.gov/articles/PMC8371605/)
    
4. Highly accurate protein structure prediction with AlphaFold - PMC, acessado em junho 22, 2025, [https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8371605/](https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8371605/)
    
5. How to cite AlphaFold - EMBL-EBI, acessado em junho 22, 2025, [https://www.ebi.ac.uk/training/online/courses/alphafold/accessing-and-predicting-protein-structures-with-alphafold/how-to-cite-alphafold/](https://www.ebi.ac.uk/training/online/courses/alphafold/accessing-and-predicting-protein-structures-with-alphafold/how-to-cite-alphafold/)
    
6. AlphaFold two years on: Validation and impact - PNAS, acessado em junho 22, 2025, [https://www.pnas.org/doi/10.1073/pnas.2315002121](https://www.pnas.org/doi/10.1073/pnas.2315002121)
    
7. AlphaFold two years on: Validation and impact - PNAS, acessado em junho 22, 2025, [https://www.pnas.org/doi/abs/10.1073/pnas.2315002121?af=R](https://www.pnas.org/doi/abs/10.1073/pnas.2315002121?af=R)
    
8. Bilingual language model for protein sequence and structure | NAR ..., acessado em junho 22, 2025, [https://academic.oup.com/nargab/article/6/4/lqae150/7901286](https://academic.oup.com/nargab/article/6/4/lqae150/7901286)
    
9. Evolutionary Scale Modeling (esm): Pretrained language models for proteins - GitHub, acessado em junho 22, 2025, [https://github.com/facebookresearch/esm](https://github.com/facebookresearch/esm)
    
10. Language models of protein sequences at the scale of evolution enable accurate structure prediction - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/362180327_Language_models_of_protein_sequences_at_the_scale_of_evolution_enable_accurate_structure_prediction](https://www.researchgate.net/publication/362180327_Language_models_of_protein_sequences_at_the_scale_of_evolution_enable_accurate_structure_prediction)
    
11. Language models of protein sequences at the scale of evolution enable accurate structure prediction - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2022.07.20.500902v1.full.pdf](https://www.biorxiv.org/content/10.1101/2022.07.20.500902v1.full.pdf)
    
12. Language models of protein sequences at the scale of evolution enable accurate structure prediction | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2022.07.20.500902v1](https://www.biorxiv.org/content/10.1101/2022.07.20.500902v1)
    
13. Protein language models meet reduced amino acid alphabets - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/bioinformatics/article/40/2/btae061/7600424](https://academic.oup.com/bioinformatics/article/40/2/btae061/7600424)
    
14. Protein–Peptide Docking with ESMFold Language Model - ACS Publications, acessado em junho 22, 2025, [https://pubs.acs.org/doi/10.1021/acs.jctc.4c01585](https://pubs.acs.org/doi/10.1021/acs.jctc.4c01585)
    
15. Protein–Peptide Docking with ESMFold Language Model - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11948316/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11948316/)
    
16. AlphaFold2 has more to learn about protein energy landscapes - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2023.12.12.571380v1](https://www.biorxiv.org/content/10.1101/2023.12.12.571380v1)
    
17. AlphaFold predictions are valuable hypotheses and accelerate but do not replace experimental structure determination, acessado em junho 22, 2025, [https://experiments.springernature.com/articles/10.1038/s41592-023-02087-4](https://experiments.springernature.com/articles/10.1038/s41592-023-02087-4)
    
18. AlphaFold predictions are valuable hypotheses and accelerate but do not replace experimental structure determination, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10776388/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10776388/)
    
19. Effective Gene Expression Prediction From Sequence by Integrating Long-Range Interactions | PDF - Scribd, acessado em junho 22, 2025, [https://www.scribd.com/document/678637482/s41592-021-01252-x](https://www.scribd.com/document/678637482/s41592-021-01252-x)
    
20. Deep learning and genomics: predicting gene expression from DNA sequence, acessado em junho 22, 2025, [https://network.febs.org/posts/deep-learning-and-genomics-predicting-gene-expression-from-dna-sequence](https://network.febs.org/posts/deep-learning-and-genomics-predicting-gene-expression-from-dna-sequence)
    
21. Effective gene expression prediction from sequence by integrating ..., acessado em junho 22, 2025, [https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8490152/](https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8490152/)
    
22. Effective gene expression prediction from sequence by integrating long-range interactions - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC8490152/](https://pmc.ncbi.nlm.nih.gov/articles/PMC8490152/)
    
23. Effective gene expression prediction from sequence by integrating long-range interactions, acessado em junho 22, 2025, [https://experiments.springernature.com/articles/10.1038/s41592-021-01252-x](https://experiments.springernature.com/articles/10.1038/s41592-021-01252-x)
    
24. (PDF) Effective gene expression prediction from sequence by integrating long-range interactions - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/355058013_Effective_gene_expression_prediction_from_sequence_by_integrating_long-range_interactions](https://www.researchgate.net/publication/355058013_Effective_gene_expression_prediction_from_sequence_by_integrating_long-range_interactions)
    
25. Effective gene expression prediction from sequence by integrating long-range interactions - City University of Hong Kong (Dongguan), acessado em junho 22, 2025, [https://cityu-dg.primo.exlibrisgroup.com.cn/discovery/fulldisplay?docid=cdi_pubmedcentral_primary_oai_pubmedcentral_nih_gov_8490152&context=PC&vid=86CITYU_DG:cityu_dg&lang=en&adaptor=Primo%20Central&tab=Everything&query=creator%2Cexact%2C%20Leslie%2C%20Christina%20%2CAND&facet=citing%2Cexact%2Ccdi_FETCH-LOGICAL-c475t-61f6edfb7dd3ee501cbbfbaef599de04a164621f80f4c6be27b566aa28fa4f9c3&offset=0](https://cityu-dg.primo.exlibrisgroup.com.cn/discovery/fulldisplay?docid=cdi_pubmedcentral_primary_oai_pubmedcentral_nih_gov_8490152&context=PC&vid=86CITYU_DG:cityu_dg&lang=en&adaptor=Primo+Central&tab=Everything&query=creator,exact,+Leslie,+Christina+,AND&facet=citing,exact,cdi_FETCH-LOGICAL-c475t-61f6edfb7dd3ee501cbbfbaef599de04a164621f80f4c6be27b566aa28fa4f9c3&offset=0)
    
26. Effective gene expression prediction from sequence by integrating long-range interactions - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/34608324/](https://pubmed.ncbi.nlm.nih.gov/34608324/)
    
27. Personal transcriptome variation is poorly explained by current genomic deep learning models - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10703684/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10703684/)
    
28. Deep-learning prediction of gene expression from personal genomes | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2024.07.27.605449v1.full-text](https://www.biorxiv.org/content/10.1101/2024.07.27.605449v1.full-text)
    
29. Benchmarking of deep neural networks for predicting personal gene expression from DNA sequence highlights shortcomings - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10055057/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10055057/)
    
30. Enformer provides effective gene expression prediction for endogenous... - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/figure/Enformer-provides-effective-gene-expression-prediction-for-endogenous-genes-A-Pearson_fig2_369556173](https://www.researchgate.net/figure/Enformer-provides-effective-gene-expression-prediction-for-endogenous-genes-A-Pearson_fig2_369556173)
    
31. Bilingual language model for protein sequence and structure - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/39633723/](https://pubmed.ncbi.nlm.nih.gov/39633723/)
    
32. Bilingual language model for protein sequence and structure - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/386011205_Bilingual_language_model_for_protein_sequence_and_structure](https://www.researchgate.net/publication/386011205_Bilingual_language_model_for_protein_sequence_and_structure)
    
33. mheinzinger/ProstT5: Bilingual Language Model for Protein Sequence and Structure, acessado em junho 22, 2025, [https://github.com/mheinzinger/ProstT5](https://github.com/mheinzinger/ProstT5)
    
34. ProstT5: Bilingual Language Model for Protein Sequence and Structure - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2023.07.23.550085v1](https://www.biorxiv.org/content/10.1101/2023.07.23.550085v1)
    
35. Bilingual language model for protein sequence and structure - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/nargab/article-pdf/6/4/lqae150/60777547/lqae150.pdf](https://academic.oup.com/nargab/article-pdf/6/4/lqae150/60777547/lqae150.pdf)
    
36. ProstT5: Bilingual Language Model for Protein Sequence and Structure - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2023.07.23.550085v1.full.pdf](https://www.biorxiv.org/content/10.1101/2023.07.23.550085v1.full.pdf)
    
37. Reinventing gene expression connectivity through regulatory and spatial structural empowerment via principal node aggregation graph neural network | Nucleic Acids Research | Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/nar/article/52/13/e60/7694275](https://academic.oup.com/nar/article/52/13/e60/7694275)
    
38. Integrating Long-Range Regulatory Interactions to Predict Gene Expression Using Graph Convolutional Networks - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9125570/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9125570/)
    
39. Reinventing gene expression connectivity through regulatory and spatial structural empowerment via principal node aggregation graph neural network, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11260459/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11260459/)
    

**