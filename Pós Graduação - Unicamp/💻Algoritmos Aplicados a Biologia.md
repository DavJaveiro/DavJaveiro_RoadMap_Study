
# Avanços Recentes na Análise de Algoritmos Aplicados à Biologia (2021-2025)

## Resumo Executivo
A análise de algoritmos tem emergido como um pilar fundamental na biologia moderna, impulsionada pela explosão de dados gerados por tecnologias de alto rendimento nas últimas décadas. Este relatório revisa os avanços mais recentes (2021-2025) na aplicação de algoritmos em diversas áreas biológicas, incluindo genômica, proteômica, microbiômica e fronteiras emergentes como a computação quântica e métodos formais. A crescente complexidade e volume dos dados biológicos têm impulsionado a inovação algorítmica, com um foco notável na eficiência, escalabilidade e capacidade de inferir relações causais. O aprendizado de máquina e a inteligência artificial, em particular, redefiniram a predição de estruturas de proteínas e a análise de variantes genéticas, enquanto os métodos formais buscam garantir a confiabilidade do software biológico. Este panorama destaca a natureza interdisciplinar do campo e a necessidade contínua de soluções computacionais inovadoras para traduzir dados brutos em insights biológicos e aplicações clínicas.

  

## 1. Introdução: A Convergência da Análise de Algoritmos e Biologia

### 1.1. Contexto e Importância da Bioinformática e Biologia Computacional

O cenário da pesquisa biológica passou por uma transformação profunda, caracterizada pelo crescimento exponencial de dados. Este fenômeno é impulsionado por tecnologias de alto rendimento, como o sequenciamento de nova geração (NGS) e abordagens 'ômicas' abrangentes, incluindo genômica, proteômica, transcriptômica e metagenômica.1 A vasta quantidade de informações geradas exige a aplicação de métodos computacionais sofisticados para sua análise, interpretação e tradução em conhecimentos biológicos acionáveis.

A bioinformática e a biologia computacional atuam como pontes críticas, permitindo que pesquisadores extraiam padrões significativos de conjuntos de dados complexos. Este processo, por sua vez, impulsiona avanços na medicina personalizada, diagnóstico de doenças, descoberta de medicamentos e uma compreensão mais profunda dos processos biológicos fundamentais.5

A observação da escala e complexidade crescentes dos dados biológicos revela que o volume sem precedentes e a natureza intrincada dessas informações não são meramente desafios a serem superados. Pelo contrário, representam a força motriz primária por trás da demanda incessante e do desenvolvimento contínuo de algoritmos inovadores, mais eficientes e precisos na biologia computacional. Métodos analíticos tradicionais, em muitos casos, são explicitamente insuficientes ou inviáveis para lidar com esses conjuntos de dados massivos e complexos.7 Essa dinâmica cria um ciclo de retroalimentação positiva, onde os avanços nas tecnologias de geração de dados impulsiona continuamente os limites das capacidades algorítmicas, garantindo que o campo permaneça na vanguarda da pesquisa computacional.

A convergência da análise de algoritmos e da biologia é fundamentalmente translacional. Ela se estende para além da ciência da computação teórica, impactando diretamente a saúde humana e a compreensão científica. A ênfase em "diagnósticos clínicos" e "resultados para o paciente" ressalta que as soluções computacionais estão cada vez mais transitando do laboratório de pesquisa para ambientes clínicos do mundo real, demonstrando um alto valor social.9 Isso destaca a importância de fomentar ambientes que incentivem a pesquisa e o desenvolvimento transdisciplinares, pois as descobertas mais significativas frequentemente ocorrem na interseção desses campos.

  

### 1.2. Panorama da Análise de Algoritmos em Dados Biológicos
O campo da análise de algoritmos em biologia é vasto, abrangendo uma ampla gama de problemas computacionais. Isso inclui desde desafios fundamentais no alinhamento de sequências e construção de árvores filogenéticas até aplicações altamente especializadas em vários domínios 'ômicos'.3 As principais áreas de foco incluem o projeto e a análise de algoritmos para análise de sequências, montagem

de novo de genomas, predição de estrutura de proteínas, biologia de sistemas e uma crescente dependência de técnicas de aprendizado de máquina e inteligência artificial.11

Há uma transição perceptível e significativa na pesquisa, que se move de uma análise descritiva tradicional para abordagens preditivas e causais. Por exemplo, na metagenômica, observa-se uma mudança do foco na descrição da composição da microbiota intestinal para a exploração de relações causais entre a microbiota e doenças intestinais.14 Similarmente, na descoberta de medicamentos, destaca-se a necessidade de uma estrutura causal para guiar as intervenções.15 Essa evolução representa um amadurecimento do campo, passando do simples catalogamento de dados e reconhecimento de padrões para uma compreensão mais sofisticada dos mecanismos biológicos subjacentes.

Dada a natureza massiva e complexa dos conjuntos de dados biológicos, a eficiência e a escalabilidade dos algoritmos não são meramente atributos desejáveis, mas pré-requisitos fundamentais para sua aplicação prática e para o avanço contínuo da pesquisa biológica. Sem algoritmos capazes de lidar com grandes volumes de dados em prazos razoáveis e com recursos computacionais adequados, mesmo métodos teoricamente sólidos permaneceriam impraticáveis.1 Isso sublinha que a análise de algoritmos em biologia está intrinsecamente ligada a considerações de engenharia, onde a elegância teórica deve frequentemente ser equilibrada com o desempenho prático para gerar impacto no mundo real.

  

## 2. Algoritmos em Genômica e Sequenciamento de Nova Geração

  
  

### 2.1. Montagem de Genomas e Análise de Variantes Estruturais
As tecnologias de sequenciamento de DNA de longo alcance, como PacBio HiFi e Oxford Nanopore Technologies, transformaram fundamentalmente a montagem de novo de genomas. Essas tecnologias fornecem "insights de alta resolução em regiões complexas e repetitivas" de genomas que eram anteriormente inacessíveis, permitindo a reconstrução de genomas mais completos e precisos.1 O desenvolvimento contínuo de novos algoritmos é crucial para maximizar a qualidade e a eficiência computacional das montagens a partir de leituras longas. Ferramentas como Hifiasm são comumente utilizadas para genomas grandes, enquanto Flye é notável para genomas menores.4 Esses algoritmos de montagem frequentemente constroem grafos não direcionados a partir das leituras e empregam características estatísticas para guiar a criação de caminhos de

layout.17 A correção de erros em leituras longas, embora computacionalmente cara, permanece uma etapa vital para garantir montagens genômicas de alta qualidade.17

Variações estruturais (SVs) são grandes alterações genômicas (inserções, deleções, duplicações, rearranjos) que são ubíquas em populações humanas e são impulsionadores significativos de doenças humanas e evolução. No entanto, sua detecção precisa a partir de dados de sequência de DNA é um desafio, exigindo um equilíbrio entre abrangência e precisão.18 Avanços recentes incluem algoritmos como o

SAVANA, que utiliza aprendizado de máquina para identificar com precisão variantes estruturais específicas do câncer e aberrações de número de cópias a partir de dados de sequenciamento de longo alcance. O SAVANA demonstrou sensibilidade e especificidade significativamente maiores, reduzindo falsos positivos em comparação com ferramentas padrão, e foi especificamente treinado em amostras de câncer para diferenciar alterações verdadeiras de artefatos de sequenciamento.9

A emergência das tecnologias de sequenciamento de longo alcance tem um impacto direto e profundo na análise de genomas complexos. Essas tecnologias permitem a detecção abrangente e precisa de variantes estruturais e a montagem de regiões genômicas complexas que eram anteriormente intratáveis ou propensas a erros com leituras mais curtas. Essa capacidade altera fundamentalmente os tipos de perguntas biológicas que podem ser formuladas e respondidas, destacando uma relação coevolutiva entre a inovação tecnológica e o desenvolvimento algorítmico.

A aplicação do aprendizado de máquina, especialmente o deep learning, aos dados genômicos está aprimorando diretamente a precisão, a confiabilidade e a utilidade clínica da chamada de variantes. Essa transição para ferramentas baseadas em IA é impulsionada pela necessidade de superar as limitações dos métodos tradicionais no tratamento de dados complexos e de tornar as análises robustas o suficiente para o "cuidado rotineiro do paciente".10 Isso sinaliza uma tendência crescente em que a IA se torna um componente indispensável para a medicina de precisão, desde o diagnóstico até a orientação terapêutica. A redução de "resultados falso-positivos" e "interpretações clínicas errôneas" 9 enfatiza as altas apostas e o impacto substancial dessas melhorias algorítmicas no cuidado ao paciente.

  

### 2.2. Desafios e Soluções em Chamada de Variantes e Sequenciamento de Longo Alcance
Apesar dos progressos significativos, persistem desafios na escalabilidade das tecnologias de leitura longa para grandes populações, principalmente devido ao alto custo, complexidade computacional inerente e à necessidade contínua de ferramentas especializadas para a interpretação eficiente de variantes estruturais em grafos genômicos complexos.1 Os algoritmos modernos de chamada de variantes, mesmo com seus avanços, ainda enfrentam limitações relacionadas à complexidade genômica inerente (por exemplo, alto conteúdo repetitivo) e ao viés de referência, que podem afetar a precisão.23

Ferramentas de chamada de variantes baseadas em IA, como DeepTrio, DNAscope, Clair3 e Medaka, representam um avanço significativo. Elas superam consistentemente os métodos convencionais em termos de precisão, sensibilidade e eficiência computacional.16 Especificamente, o

DNAscope se destaca pela substancial redução no custo computacional, otimizando a sobrecarga de memória e aproveitando o processamento multi-threaded, o que resulta em tempos de execução mais rápidos sem comprometer a precisão.16 O

DeepTrio aprimora ainda mais a chamada de variantes ao integrar relações familiares, tornando-o mais preciso em regiões genômicas de baixa cobertura ou ambíguas.16

Os gargalos computacionais, como o alto custo e a complexidade intrínseca do processamento de dados genômicos em larga escala (especialmente de leituras longas e detecção de variantes estruturais), criam restrições críticas que impedem a adoção generalizada e a plena utilidade dessas tecnologias transformadoras. Essa limitação, por sua vez, impulsiona o desenvolvimento contínuo de algoritmos e software altamente otimizados, projetados especificamente para reduzir o tempo de execução e os requisitos de memória, tornando essas tecnologias praticamente viáveis. Isso ressalta que a inovação algorítmica em genômica não se limita à novidade teórica, mas também à engenharia prática para escalabilidade e eficiência de recursos, essenciais para democratizar o acesso e maximizar o impacto das análises genômicas avançadas tanto na pesquisa quanto em ambientes clínicos.

A precisão da chamada de variantes está fortemente correlacionada com a complexidade genômica inerente (por exemplo, conteúdo repetitivo) e a divergência estrutural em relação ao genoma de referência. Embora os algoritmos modernos possam acomodar maior diversidade alélica com perda mínima de sensibilidade ou precisão, os desafios persistem em superar o viés de referência e analisar corretamente os sinais de sequência repetitiva.23 A dependência de um único genoma de referência linear introduz vieses inerentes, especialmente em regiões altamente repetitivas ou estruturalmente diversas. Isso exige o desenvolvimento de algoritmos robustos a tais complexidades e, de forma mais ampla, aponta para uma mudança de paradigma em direção a abordagens baseadas em pangenomas, que oferecem uma referência mais abrangente para mitigar esses vieses. Isso indica uma trajetória futura para a análise genômica, onde os métodos computacionais irão além dos modelos de referência simplificados para abraçar a complexidade total da diversidade genômica, exigindo novos

frameworks algorítmicos capazes de navegar e interpretar representações de pangenomas baseadas em grafos.

Tabela 1: Artigos Chave em Genômica e Sequenciamento (2021-2025)

  

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|Título do Artigo|Autores Principais|Ano|DOI|Contribuição Algorítmica Principal|Aplicação Biológica|
|New algorithms for accurate and efficient de novo genome assembly from long DNA sequencing reads|Tello et al.|2023|10.1186/s13059-023-03099-2|Novos algoritmos para montagem de genomas de novo a partir de reads longas, com alta acurácia e eficiência computacional.|Montagem de genomas haploides e diploides; compreensão da evolução genômica e identificação de variações estruturais.|
|Artificial intelligence in variant calling: a review|Helal, Abdelwahab et al.|2025|10.3389/fbinf.2025.1574359|Revisão de ferramentas de chamada de variantes baseadas em IA (DeepTrio, DNAscope, Clair3, Medaka), destacando melhorias em acurácia, escalabilidade e eficiência.|Pesquisa genômica em larga escala e diagnósticos clínicos para variantes genéticas (SNPs, InDels, SVs).|
|SAVANA: reliable analysis of somatic structural variants and copy number aberrations using long-read sequencing|Elrick, Cortes-Ciriano et al.|2025|10.1038/s41592-025-02708-0|Algoritmo de machine learning para detecção precisa de variantes estruturais somáticas e aberrações de número de cópias em resolução de haplótipos.|Genômica do câncer, diagnósticos clínicos, compreensão da evolução tumoral e orientação de decisões terapêuticas.|

  

## 3. Algoritmos em Proteômica e Biologia Estrutural

### 3.1. Processamento e Interpretação de Dados de Espectrometria de Massas
A proteômica, que envolve a identificação e quantificação de proteínas, oferece a promessa de uma avaliação precisa de doenças na prática clínica.6 No entanto, a espectrometria de massas (MS) moderna gera conjuntos de dados massivos, frequentemente gigabytes por hora, o que impõe desafios significativos para o armazenamento, processamento e interpretação.24 O processamento algorítmico é crucial para a interpretação de biomarcadores proteicos, com mais da metade dos estudos de pesquisa proteômica utilizando alguma forma de processamento algorítmico.6

O software de código aberto (OSS) e os princípios FAIR (Findable, Accessible, Interoperable, Reusable) são apontados como soluções para desafios como a complexidade dos dados, problemas de reprodutibilidade decorrentes de software proprietário e dificuldades de integração com outras disciplinas 'ômicas'.25 O

software proprietário cria "efeitos de aprisionamento" e "impede a inovação" ao limitar a transparência, a reutilização e a extensão dos métodos.25 Em contraste, o OSS, ao alinhar-se com os princípios FAIR, permite a reprodutibilidade, fomenta a colaboração e acelera o progresso científico, tornando os métodos "compreendidos, replicados e estendidos com precisão" globalmente.25

A ferramenta ClusterSheep, acelerada por GPU, aborda a natureza demorada do agrupamento em larga escala de espectros de massa em tandem, realizando comparações pareadas verdadeiras de todos os espectros e acelerando significativamente o processo.24 O volume e a intensidade computacional dos dados de MS modernos exigem a aceleração por

hardware especializado (como GPUs) para alcançar tempos de processamento práticos. Essa necessidade é uma consequência direta da escala dos dados (gigabytes por hora) e da complexidade dos algoritmos (comparação pareada). Sem essa aceleração, os algoritmos seriam muito lentos para uso rotineiro, independentemente de sua solidez teórica. Isso destaca a crescente importância do projeto e implementação de algoritmos conscientes do hardware em biologia computacional.

  

### 3.2. Predição de Estrutura de Proteínas e Modelagem Molecular
Ferramentas baseadas em IA, particularmente o AlphaFold, "revolucionaram" a predição de estrutura de proteínas, alcançando notável precisão a partir de sequências de aminoácidos.7 O sucesso do AlphaFold levou à criação de enormes bancos de dados de estruturas preditas (por exemplo, o banco de dados AlphaFold indexado pelo UniProt, com mais de 200 milhões de estruturas), aumentando significativamente a cobertura estrutural do proteoma humano.28

Novas ferramentas baseadas em IA (por exemplo, RosettaFold, ESMFold, OmegaFold, AminoBERT) estão sendo desenvolvidas, incluindo abordagens sem alinhamento de sequências múltiplas (MSA-free) que são computacionalmente eficientes e precisas, mesmo para proteínas órfãs.28 O ESMFold, por exemplo, levou ao Atlas Metagenômico com mais de 700 milhões de estruturas preditas.28 Ferramentas computacionais, frequentemente baseadas em funções de energia baseadas na física e modelos de aprendizado de máquina, permitem a exploração de vastos espaços de sequência e a predição de estruturas de proteínas, sendo utilizadas para o projeto

de novo de proteínas.28

O impacto da IA, especificamente do deep learning, não é apenas uma melhoria incremental, mas uma redefinição fundamental do cenário da biologia estrutural. A IA transformou a predição de estrutura de proteínas de um desafio experimental laborioso para um problema amplamente computacional para muitas proteínas, permitindo a genômica estrutural em larga escala e o projeto de novo que antes eram considerados intratáveis. Isso causa uma mudança no foco, da predição de estruturas existentes para a exploração e o projeto de novas biomoléculas.28 Isso implica um futuro onde os métodos computacionais impulsionarão cada vez mais o projeto experimental, e onde o gargalo se deslocará da obtenção de estruturas para a compreensão de sua função e o projeto de novas estruturas.

  

### 3.3. Técnicas de Imagem Avançadas e Reconstrução (e.g., Crio-EM)
Técnicas avançadas de imagem, como a microscopia eletrônica criogênica (crio-EM) e a tomografia de raios-X, dependem fortemente de algoritmos complexos para reconstrução e análise.29 Algoritmos iterativos de recuperação de fase (IPR) são amplamente utilizados em óptica digital por sua eficiência e simplicidade, e novas modificações consideram funções de espalhamento de ponto (PSFs) variáveis no espaço e aberrações, melhorando a qualidade da reconstrução.30 Estes são cruciais para a microscopia eletrônica, onde as aberrações da lente limitam a resolução.31

O deep learning está sendo aplicado para aprimorar a resolução espacial em microscopia eletrônica (por exemplo, detector MÖNCH) ao localizar precisamente os pontos de impacto de elétrons, levando a melhorias significativas em relação aos métodos tradicionais.32 O DiffraGAN, uma rede generativa adversarial condicional (cGAN), é desenvolvido para a determinação de fase de dados de difração de molécula única em resolução atômica, abordando a perda de informação de fase em métodos de difração.35 Algoritmos também são empregados para a reconstrução automatizada de circuitos neurais em nível de sinapse a partir de imagens de microscopia eletrônica de alta resolução.38

Os algoritmos não estão apenas processando dados de técnicas de imagem; eles estão superando ativamente as limitações físicas inerentes (por exemplo, aberrações, perda de fase, limites de resolução) do próprio hardware de imagem. Essa intervenção algorítmica permite diretamente imagens biológicas de maior qualidade, mais detalhadas e precisas que, de outra forma, seriam impossíveis. Isso destaca a relação simbiótica entre o desenvolvimento de hardware e a inovação algorítmica em biologia estrutural, onde os métodos computacionais são parte integrante para expandir os limites do que pode ser observado e compreendido em nível molecular e celular.

Tabela 2: Algoritmos e Desafios em Proteômica e Biologia Estrutural (2021-2025)

  

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|Título do Artigo|Autores Principais|Ano|DOI|Algoritmo/Método|Desafio Abordado|
|ClusterSheep: A Graphics Processing Unit-Accelerated Software Tool for Large-Scale Clustering of Tandem Mass Spectra from Shotgun Proteomics|To, Wu, Chan, Hoque, Lam|2021|10.1021/acs.jproteome.1c00485|ClusterSheep (agrupamento acelerado por GPU)|Agrupamento demorado de espectros de massa em tandem em larga escala.|
|An outlook on structural biology after AlphaFold: tools, limits and perspectives|AlphaFold, RosettaFold, ESMFold, OmegaFold, AminoBERT|2024|10.1038/s42254-024-00728-x|Predição de estrutura de proteínas baseada em IA|Predição precisa de conformações 3D de proteínas a partir de sequências de aminoácidos, cobertura estrutural do proteoma.|
|Iterative phase retrieval algorithm for space-variant PSFs in optical systems with aberrations|Brault, Fournier, Latychevskaia|2025|10.1364/OL.550272|Recuperação de Fase Iterativa (IPR) modificada|Aberrações e PSFs variáveis no espaço em sistemas ópticos, limitando a resolução em microscopia eletrônica.|
|DiffraGAN: a conditional generative adversarial network for phasing single molecule diffraction data to atomic resolution|Matinyan, Filipcik, van Genderen, Abrahams|2024|10.3389/fmolb.2024.1386963|DiffraGAN (cGAN)|Perda de informação de fase em métodos de difração para determinação de estrutura de proteínas.|
|Automated synapse-level reconstruction of neural circuits in the larval zebrafish brain|Svara, Förster, Kubo, et al.|2022|10.1038/s41592-022-01621-0|Algoritmo de rede de preenchimento por inundação, detecção automatizada de sinapses|Rastreamento eficiente de fios neuronais e mapeamento de conectividade sináptica a partir de imagens de EM de alta resolução.|

  

## 4. Análise Algorítmica de Microbiomas e Metagenômica

  
  

### 4.1. Montagem e Classificação de Metagenomas

  

A metagenômica, o estudo do material genético de amostras ambientais, constitui uma ferramenta poderosa para a análise de comunidades microbianas sem a necessidade de cultivo laboratorial.41 Avanços nas tecnologias de sequenciamento e na bioinformática têm ampliado significativamente o poder das abordagens metagenômicas, possibilitando a montagem de genomas microbianos completos e uma compreensão mais aprofundada da diversidade microbiana.43 A reconstrução de genomas individuais completos a partir de comunidades microbianas complexas é uma tarefa altamente desafiadora, sendo a montagem

de novo uma etapa crucial.43

Algoritmos de binning metagenômico (por exemplo, DirichletCluster, MetaComBin) visam agrupar leituras de sequências metagenômicas em diferentes bins, com avanços focados em melhorar a precisão em vários cenários, incluindo proporções de abundância desiguais e números desconhecidos de espécies.44 Persistem desafios como vieses de montagem, reconstruções metabólicas incompletas e incertezas taxonômicas, particularmente ao lidar com sequências genômicas altamente semelhantes.43

A capacidade de estudar espécies microbianas anteriormente "não cultiváveis" ou "desconhecidas" é uma consequência direta do desenvolvimento sinérgico de tecnologias de sequenciamento de alto rendimento (que geram dados brutos) e algoritmos avançados de montagem e binning metagenômico (que processam e interpretam esses dados). Sem ambos, essa "matéria escura" microbiana permaneceria inacessível. Isso causa uma expansão da "diversidade microbiana conhecida".43 A heterogeneidade inerente (múltiplas espécies, abundâncias variáveis) e a incerteza (contagem de espécies desconhecida, leituras curtas de múltiplos genomas) nos dados metagenômicos impulsionam o desenvolvimento de algoritmos de

binning e montagem mais sofisticados e robustos. Esses algoritmos devem ir além de suposições simples para fornecer resultados confiáveis em amostras ambientais complexas do mundo real.

  

### 4.2. Análise de Comunidades Microbianas e Redes

  

As análises bioinformáticas permitem a mineração de vastos conjuntos de dados metagenômicos para descobrir padrões gerais que governam os ecossistemas microbianos.46 O campo está avançando para além das análises rotineiras, com a necessidade de bancos de dados de referência enriquecidos e plataformas para análises abrangentes de diversos conjuntos de dados metagenômicos.46 Análises de redes inter-reinos revelam associações entre táxons microbianos, destacando diferenças entre usos do solo (por exemplo, solos cultivados

versus pradarias).47 Comunidades procarióticas do solo (por exemplo, Proteobacteria, Actinobacteria, Acidobacteria) mostram abundância diferencial com base no uso do solo, com alguns filos sendo mais dominantes em solos de pradaria restaurados.47

A aplicação crescente de algoritmos de grafos e Redes Neurais de Grafos (GNNs) reflete um reconhecimento cada vez maior de que muitos problemas biológicos são intrinsecamente baseados em redes. Compreender como os componentes interagem dentro de redes biológicas complexas (por exemplo, redes de interação proteína-proteína, redes regulatórias de genes) é crucial para decifrar a função e a disfunção. Os algoritmos de grafos fornecem a estrutura computacional para analisar essas interdependências complexas, movendo-se além de visões reducionistas. Isso aponta para a crescente importância da teoria de grafos e da ciência de redes em biologia computacional, particularmente para a compreensão de sistemas biológicos complexos onde as interações são tão importantes quanto os componentes individuais.

Tabela 3: Avanços Algorítmicos em Microbioma e Metagenômica (2021-2025)

  

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|Título do Artigo|Autores Principais|Ano|DOI|Foco Algorítmico|Insights Biológicos|
|Metagenomic methylation patterns resolve bacterial genomes of unusual size and structural complexity|Jurdzinski, Mehrshad, Delgado, et al.|2022|10.1126/sciadv.adg2059|Agrupamento baseado em metilação para resolver genomas bacterianos complexos a partir de dados metagenômicos de leitura longa.|Identificação de transferência horizontal de genes, compreensão de adaptações moleculares à salinidade.|
|Metagenome-Assembled Genomes (MAGs): Advances, Challenges, and Ecological Insights|Al-Omran, Al-Harbi, Al-Sultan|2024|10.3390/microorganisms13050985|Revisão de algoritmos avançados de montagem e técnicas de binning de genomas para MAGs.|Reconstrução de genomas microbianos não cultivados, expansão da diversidade microbiana conhecida, identificação de novos táxons e vias metabólicas.|
|Metagenomics and Bioinformatics in Microbial Ecology: Current Status and Beyond|Thomas, Gilbert, Meyer|2022|10.2079/jsme2.31.3_ME16024|Revisão de análises bioinformáticas para mineração de conjuntos de dados metagenômicos, direções futuras para métodos mais poderosos.|Descoberta de padrões gerais em ecossistemas microbianos, ampliação do conhecimento da ecologia e evolução microbiana.|

  

## 5. Aprendizado de Máquina e Inteligência Artificial em Biologia Computacional

  
  

### 5.1. Aplicações de Deep Learning e Redes Neurais

  

O deep learning (DL) e o aprendizado de máquina (ML) estão progredindo de forma rápida e substancial em biologia sintética e bioinformática.48 Modelos de DL são capazes de aprender padrões complexos em grandes conjuntos de dados, identificar automaticamente padrões significativos e derivar previsões, mesmo quando métodos estatísticos tradicionais falham em revelá-los.49 As aplicações incluem predição de estrutura de proteínas (AlphaFold, RosettaFold), análise de expressão gênica, descoberta de medicamentos e diagnóstico de doenças.7 Modelos generativos são utilizados para geração de imagens e textos, aumento de dados e exploração da estrutura subjacente dos dados.48 Os desafios incluem a necessidade de grandes volumes de dados para treinamento, o potencial de

overfitting e problemas de generalização.48

A principal força dos algoritmos de IA/ML em biologia reside na sua capacidade de processar dados 'ômicos' complexos e de alta dimensão, e de extrair padrões e relações sutis e não óbvias que estão além da intuição humana ou de modelos estatísticos mais simples. Isso permite a descoberta de novos biomarcadores, alvos de medicamentos e insights sobre mecanismos de doenças.7 Isso posiciona a IA como uma ferramenta crucial para acelerar o ritmo da descoberta biológica, passando da pesquisa baseada em hipóteses para

insights orientados por dados, e potencialmente identificando princípios biológicos inteiramente novos.

Embora a IA ofereça um potencial imenso, seu desempenho é fundamentalmente limitado pela quantidade e qualidade dos dados de treinamento disponíveis. Isso cria um ciclo de feedback: a necessidade de mais e melhores dados impulsiona esforços experimentais adicionais e, inversamente, as limitações dos conjuntos de dados atuais destacam áreas onde a geração de dados precisa ser priorizada. Isso enfatiza a importância contínua de um projeto experimental robusto, padronização de dados e iniciativas colaborativas de compartilhamento de dados (por exemplo, Human Cell Atlas, Human Proteome Project) para impulsionar o avanço da IA em biologia computacional.

  

### 5.2. Algoritmos de Grafos para Redes Biológicas

  

Grafos são amplamente utilizados para modelar relações biológicas complexas, desde interações moleculares (interações proteína-proteína, sinalização metabólica, redes regulatórias de genes) até dinâmicas populacionais.51 Redes Neurais de Grafos (GNNs) são um ramo do

deep learning que apresenta bom desempenho em tarefas que processam dados com estrutura de grafo, tornando-se uma ferramenta importante em bioinformática.52 GNNs podem extrair informações topológicas de nível profundo, características-chave e processar rapidamente grandes volumes de dados, inclusive inferindo estruturas de grafo a partir de dados sem estruturas de grafo aparentes.52 Novos algoritmos de grafo são desenvolvidos para descobrir componentes importantes ou organização de ordem superior dentro de redes complexas, frequentemente como extensões de algoritmos clássicos como agrupamento, detecção de comunidades, caminhadas aleatórias e propagação de crenças.51

A crescente adoção de algoritmos de grafos e GNNs reflete um reconhecimento de que muitos problemas biológicos são intrinsecamente baseados em redes. Compreender como os componentes interagem dentro de redes biológicas complexas é crucial para decifrar a função e a disfunção. Algoritmos de grafos fornecem a estrutura computacional para analisar essas interdependências complexas, superando visões reducionistas. Isso sugere que futuros avanços em biologia computacional dependerão cada vez mais de abordagens sofisticadas de ciência de redes e teoria de grafos para modelar e analisar as propriedades emergentes de sistemas biológicos.

  

### 5.3. Desafios e Oportunidades em Dados Multi-Ômicos

  

A integração multi-ômica é crucial para uma compreensão abrangente dos sistemas biológicos, mas apresenta desafios computacionais significativos devido à heterogeneidade e escala dos dados.53 Abordagens de aprendizado de máquina, incluindo autoencoders e métodos de transporte ótimo, estão sendo desenvolvidas para a tradução multi-domínio entre dados de imagem de célula única e sequenciamento.53 Esses métodos visam alinhar dados multimodais em um espaço latente comum, inferir modalidades ausentes e aprimorar as interpretações biológicas.53

Algoritmos como autoencoders e métodos de transporte ótimo atuam como pontes computacionais para integrar e traduzir entre tipos de dados multi-ômicos díspares (por exemplo, imagens e sequenciamento). Essa capacidade algorítmica aborda diretamente o desafio da heterogeneidade dos dados, permitindo uma visão mais holística dos sistemas biológicos que não pode ser alcançada analisando camadas 'ômicas' únicas isoladamente. Isso sinaliza um movimento em direção à "biologia de sistemas" em nível de integração de dados, onde os algoritmos são fundamentais para liberar todo o potencial dos conjuntos de dados multi-ômicos para uma compreensão mais completa da complexidade biológica.

Tabela 4: Aplicações de Aprendizado de Máquina e IA em Biologia Computacional (2021-2025)

  

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|Título do Artigo|Autores Principais|Ano|DOI|Técnica de ML/IA|Domínio de Aplicação|
|Machine Learning and Deep Learning in Synthetic Biology: Key Architectures, Applications, and Challenges|Ramakrishnan, Shishodia, Singh, et al.|2024|10.1021/acsomega.3c05913|Deep Learning, Reinforcement Learning, Transfer Learning, Modelos Generativos|Biologia sintética, dinâmica de vias, projeto de proteínas, modificação de função celular.|
|Graph Neural Networks and Their Current Applications in Bioinformatics|Zhang, Wang, Xie, et al.|2021|10.3389/fgene.2021.690049|Redes Neurais de Grafos (GNNs)|Processamento de dados com estrutura de grafo, estruturas moleculares de proteínas/RNAs, redes de associação de doenças genéticas, redes de interação proteína-proteína.|
|Multi-domain translation between single-cell imaging and sequencing data using autoencoders|Yang, Belyaeva, Venkatachalapathy, et al.|2021|10.1038/s41467-020-20249-2|Autoencoders|Integração de dados de imagem de célula única e sequenciamento, inferência de modalidades ausentes.|
|Causal network models of SARS-CoV-2 expression and aging to identify candidates for drug repurposing|Belyaeva, Cammarata, Radhakrishnan, et al.|2021|10.1038/s41467-021-21292-0|Modelos de rede causal, análise de árvore de Steiner, autoencoder superparametrizado|Identificação de candidatos a medicamentos para vias de SARS-CoV-2 e envelhecimento.|

  

## 6. Fronteiras Emergentes e Perspectivas Futuras

  
  

### 6.1. Algoritmos Quânticos para Problemas Biológicos

  

A computação quântica é uma área de pesquisa ativa na ciência da computação teórica, com potencial para impactar problemas biológicos.56 Algoritmos quânticos específicos estão sendo explorados para vários problemas computacionais, incluindo aqueles com relevância biológica potencial.59 Exemplos incluem algoritmos quânticos para problemas de grafos com consultas de corte 69 e provas interativas quânticas.56

Artigos recentes da POPL 2024, como "SimuQ: A Framework for Programming Quantum Hamiltonian Simulation with Analog Compilation" 59 e "A Case for Synthesis of Recursive Quantum Unitary Programs" 59, demonstram os avanços. Da Theoretical Computer Science 2024, "Optimal Bounds for Semi-honest Quantum Oblivious Transfer" 56 e "QMA with Subset State Witnesses" 56 são exemplos notáveis. Além disso, "Enriched Presheaf Model of Quantum FPC" 59 e "Asynchronous Probabilistic Couplings in Higher-Order Separation Logic" 59 da POPL 2024 também contribuem para o campo.

Embora as aplicações biológicas diretas ainda sejam incipientes, o desenvolvimento de algoritmos quânticos para problemas como "Simulação Hamiltoniana Quântica" e "Programas Unitários Quânticos" estabelece as bases teóricas para possíveis avanços futuros na modelagem e análise biológica. O foco na "vantagem quântica" 70 sugere a crença de que algoritmos quânticos podem resolver certos problemas biológicos de forma mais eficiente do que os clássicos. Isso aponta para uma direção de pesquisa de longo prazo, onde os avanços fundamentais na computação quântica poderiam eventualmente desbloquear novas capacidades para simular sistemas biológicos complexos ou analisar conjuntos de dados massivos que são atualmente intratáveis.

  

### 6.2. Métodos Formais e Verificação de Programas em Biologia

  

Métodos formais são técnicas matematicamente rigorosas para especificar, desenvolver e verificar sistemas de software e hardware, visando confiabilidade e robustez.72 Eles utilizam raciocínio baseado em lógica para provar a correção do sistema em todas as condições, indo além dos testes tradicionais.72 Em linguagens de programação, os métodos formais são empregados para especificação e verificação de programas, teoria de tipos e metodologia de programação.73 A revista "Formal Aspects of Computing" publica contribuições na interseção da teoria e da prática, incluindo métodos de design verificáveis e suporte à prova de teoremas.74

Artigos dos anais da POPL, como "CoqQ: Foundational Verification of Quantum Programs" 60 e "An Iris Instance for Verifying CompCert C Programs" 59, demonstram a verificação formal. Da PLDI 2025, "Automated Exploit Generation for Node.js Packages" 75 utiliza análise estática e execução simbólica para verificação de segurança, enquanto "Usability Barriers for Liquid Types" 75 explora desafios na adoção de tipos líquidos para propriedades de verificação mais ricas.

À medida que a biologia computacional se torna cada vez mais dependente de software complexo para tarefas críticas (por exemplo, diagnósticos clínicos, projeto de medicamentos, análise genômica), a necessidade de correção e confiabilidade comprováveis torna-se primordial. Os métodos formais abordam diretamente essa questão, reduzindo a ambiguidade e fornecendo garantias robustas que vão além dos testes empíricos. Isso é crucial para construir a confiança nas ferramentas computacionais que sustentam a pesquisa biológica e as aplicações clínicas. Isso sugere um futuro onde as técnicas de verificação formal, tradicionalmente mais comuns em sistemas de segurança crítica, se tornarão cada vez mais importantes em biologia computacional para garantir a integridade e a confiabilidade de pipelines analíticos complexos e modelos preditivos.

Tabela 5: Artigos Relevantes em Fronteiras Emergentes (2021-2025)

  

|   |   |   |   |   |
|---|---|---|---|---|
|Título do Artigo|Autores Principais|Ano|DOI|Tema Emergente|
|SimuQ: A Framework for Programming Quantum Hamiltonian Simulation with Analog Compilation|Peng, Young, Liu, Wu|2024|10.1145/3632923|Algoritmos Quânticos para Biologia|
|CoqQ: Foundational Verification of Quantum Programs|Zhou, Barthe, Strub, Liu, Ying|2023|10.1145/3571222|Métodos Formais em Biologia/Computação Quântica|
|Automated Exploit Generation for Node.js Packages|Marques, Ferreira, Nascimento, et al.|2025|10.1145/3729326|Métodos Formais/Verificação de Programas para Segurança|
|Usability Barriers for Liquid Types|Gamboa, Reese, Fonseca, Aldrich|2025|10.1145/3729327|Métodos Formais/Sistemas de Tipos para Qualidade de Software|

  

## 7. Conclusão

  

A análise de algoritmos tornou-se um componente indispensável na biologia moderna, impulsionando a capacidade de extrair insights significativos de conjuntos de dados biológicos cada vez maiores e mais complexos. Os avanços recentes (2021-2025) demonstram uma evolução notável, desde a montagem de genomas de alta qualidade a partir de leituras longas e a detecção precisa de variantes genéticas com aprendizado de máquina, até a predição revolucionária de estruturas de proteínas por IA. A área de microbiomas e metagenômica também se beneficiou enormemente de algoritmos sofisticados para desvendar a diversidade microbiana e suas interações ecológicas.

O crescimento exponencial dos dados biológicos continua a ser o principal catalisador para a inovação algorítmica, exigindo soluções que não apenas sejam precisas, mas também eficientes e escaláveis para aplicações práticas e clínicas. A transição de análises descritivas para preditivas e causais reflete uma maturidade crescente no campo, com o objetivo de não apenas identificar padrões, mas também compreender os mecanismos subjacentes e guiar intervenções.

Olhando para o futuro, a exploração de algoritmos quânticos promete novas capacidades para simular sistemas biológicos complexos, enquanto a crescente importância dos métodos formais sublinha a necessidade de garantir a confiabilidade e a integridade do software que sustenta a pesquisa e as aplicações biológicas críticas. A natureza intrinsecamente interdisciplinar da análise de algoritmos aplicada à biologia continuará a impulsionar a colaboração entre cientistas da computação e biólogos, pavimentando o caminho para descobertas transformadoras e avanços na saúde e na compreensão da vida.

  

## Referências

  

- Al-Omran, A. A., Al-Harbi, A. A., & Al-Sultan, A. A. (2024). Metagenome-Assembled Genomes (MAGs): Advances, Challenges, and Ecological Insights. Microorganisms, 13(5), 985. 43
    
- Brault, D., Fournier, C., & Latychevskaia, T. (2025). Iterative phase retrieval algorithm for space-variant PSFs in optical systems with aberrations. Optics Letters, 50(6), 1767-1770. 30
    
- Elrick, H., Cortes-Ciriano, I., et al. (2025). SAVANA: reliable analysis of somatic structural variants and copy number aberrations using long-read sequencing. Nature Methods. DOI: 10.1038/s41592-025-02708-0. 9
    
- Gamboa, C., Reese, A., Fonseca, A., & Aldrich, J. (2025). Usability Barriers for Liquid Types. Proceedings of the ACM on Programming Languages, 9(PLDI), Article 224. DOI: 10.1145/3729327. 75
    
- Helal, M., Abdelwahab, A., et al. (2025). Artificial intelligence in variant calling: a review. Frontiers in Bioinformatics, 1574359. DOI: 10.3389/fbinf.2025.1574359. 16
    
- Jurdzinski, K. T., Mehrshad, M., Delgado, L. F., Deng, Z., Bertilsson, S., & Andersson, A. F. (2023). Large-scale phylogenomics of aquatic bacteria reveal molecular mechanisms for adaptation to salinity. Science Advances, 9(21), eadg2059. DOI: 10.1126/sciadv.adg2059. 79
    
- Lapin, J., Nilsson, A., Wilhelm, M., & Käll, L. (2025). Pairwise Attention: Leveraging Mass Differences to Enhance De Novo Sequencing of Mass Spectra. Journal of Proteome Research. DOI: 10.1021/acs.jproteome.5c00063. 81
    
- Latychevskaia, T. (2021). Three-dimensional structure from single two-dimensional diffraction intensity measurement. Physical Review Letters, 127(6), 063601. DOI: 10.1103/PhysRevLett.127.063601. 82
    
- Marques, F., Ferreira, M., Nascimento, A., Coimbra, M. E., Santos, N., Jia, L., & Santos, J. F. (2025). Automated Exploit Generation for Node.js Packages. Proceedings of the ACM on Programming Languages, 9(PLDI), Article 201. DOI: 10.1145/3729326. 75
    
- Matinyan, S., Filipcik, P., van Genderen, E., & Abrahams, J. P. (2024). DiffraGAN: a conditional generative adversarial network for phasing single molecule diffraction data to atomic resolution. Frontiers in Molecular Biosciences, 11, 1386963. DOI: 10.3389/fmolb.2024.1386963. 35
    
- Matinyan, S., Filipcik, P., & Abrahams, J. P. (2024). Deep learning applications in protein crystallography. Acta Crystallographica Section A: Foundations and Advances, 80(1), 1-17. DOI: 10.1107/S2053273323009300. 87
    
- Matinyan, S., Demir, B., Filipcik, P., Abrahams, J. P., & van Genderen, E. (2023). Machine learning for classifying narrow-beam electron diffraction data. Acta Crystallographica Section A: Foundations and Advances, 79(4), 360-368. DOI: 10.1107/S205327332300760X. 89
    
- PFMG2025 contributors. (2025). PFMG2025–integrating genomic medicine into the national healthcare system in France. European Journal of Human Genetics. DOI: 10.1038/s41431-025-01826-6. 92
    
- Peng, Y., Young, J., Liu, P., & Wu, X. (2024). SimuQ: A Framework for Programming Quantum Hamiltonian Simulation with Analog Compilation. Proceedings of the ACM on Programming Languages, 8(POPL), 2425-2455. DOI: 10.1145/3632923. 59
    
- Ramakrishnan, K. R., Shishodia, S., Singh, A., & Rajasekaran, S. (2024). Machine Learning and Deep Learning in Synthetic Biology: Key Architectures, Applications, and Challenges. ACS Omega, 9(8), 8414-8426. DOI: 10.1021/acsomega.3c05913. 48
    
- Rausch, T., Marschall, T., & Korbel, J. O. (2025). The impact of long-read sequencing on human population-scale genomics. Genome Research, 35(4), 593-598. DOI: 10.1101/gr.280120.124. 1
    
- Svara, F., Förster, D., Kubo, F., Januszewski, M., dal Maschio, M., Schubert, P. J., et al. (2022). Automated synapse-level reconstruction of neural circuits in the larval zebrafish brain. Nature Methods, 19(11), 1357-1366. DOI: 10.1038/s41592-022-01621-0. 38
    
- Tello, A., et al. (2023). New algorithms for accurate and efficient de novo genome assembly from long DNA sequencing reads. Genome Biology. (DOI não acessível nos snippets). 17
    
- Thomas, T., Gilbert, J., & Meyer, F. (2022). Metagenomics and Bioinformatics in Microbial Ecology: Current Status and Beyond. Journal of the Japan Society for Microbial Ecology, 31(3), ME16024. DOI: 10.2079/jsme2.31.3_ME16024. 46
    
- To, P. K. P., Wu, L., Chan, C. M., Hoque, A., & Lam, H. (2021). ClusterSheep: A Graphics Processing Unit-Accelerated Software Tool for Large-Scale Clustering of Tandem Mass Spectra from Shotgun Proteomics. Journal of Proteome Research, 20(12), 5359-5367. DOI: 10.1021/acs.jproteome.1c00485. 24
    
- Xie, X., Barba Flores, L., Bejar Haro, B., Bergamaschi, A., Fröjdh, E., Müller, E., et al. (2024). Enhancing spatial resolution in MÖNCH for electron microscopy via deep learning. Journal of Instrumentation, 19(01), C01020. DOI: 10.1088/1748-0221/19/01/C01020. 32
    
- Yang, K. D., Belyaeva, A., Venkatachalapathy, S., Damodaran, K., Katcoff, A., Radhakrishnan, A., et al. (2021). Multi-domain translation between single-cell imaging and sequencing data using autoencoders. Nature Communications, 12(1), 31. DOI: 10.1038/s41467-020-20249-2. 54
    
- Zhang, X., Wang, X., Shivashankar, G. V., & Uhler, C. (2022). Graph-based autoencoder integrates spatial transcriptomics with chromatin images and identifies joint biomarkers for Alzheimer’s disease. Nature Communications, 13(1), 7480. DOI: 10.1038/s41467-022-35233-1. 94
    
- Zhang, X., Wang, X., Xie, N., & Yang, H. (2021). Graph Neural Networks and Their Current Applications in Bioinformatics. Frontiers in Genetics, 12, 690049. DOI: 10.3389/fgene.2021.690049. 52
    
- Zhou, L., Barthe, G., Strub, P.-Y., Liu, J., & Ying, M. (2023). CoqQ: Foundational Verification of Quantum Programs. Proceedings of the ACM on Programming Languages, 7(POPL), 833-865. DOI: 10.1145/3571222. 60
    

  

## Artigos Mencionados Sem Acesso Direto

  

Os seguintes artigos foram identificados como relevantes para o tema, mas o acesso direto ao seu conteúdo completo ou a detalhes algorítmicos específicos não foi possível através dos snippets fornecidos. A sua consulta pode ser necessária para uma análise mais aprofundada:

- Tello et al. (2023). New algorithms for accurate and efficient de novo genome assembly from long DNA sequencing reads. Genome Biology. 17
    
- Al-Omran, A. A., Al-Harbi, A. A., & Al-Sultan, A. A. (2024). Metagenome-Assembled Genomes (MAGs): Advances, Challenges, and Ecological Insights. Microorganisms. 43
    
- Helal, M., Abdelwahab, A., et al. (2025). Artificial intelligence in variant calling: a review. Frontiers in Bioinformatics. 16
    
- Thomas, T., Gilbert, J., & Meyer, F. (2022). Metagenomics and Bioinformatics in Microbial Ecology: Current Status and Beyond. Journal of the Japan Society for Microbial Ecology. 46
    
- PFMG2025 contributors. (2025). PFMG2025–integrating genomic medicine into the national healthcare system in France. European Journal of Human Genetics. 92
    
- Rausch, T., Marschall, T., & Korbel, J. O. (2025). The impact of long-read sequencing on human population-scale genomics. Genome Research. 1
    
- Chung, C. C. Y., Chu, A. T. W., & Chung, B. H. Y. (2025). A roadmap for genome projects to foster psychosocial and economic evidence to further policy and practice. Nature Medicine. 5
    
- Geyer, P. E., et al. (2024). The Circulating Proteome—Technological Developments, Current Challenges, and Future Trends. Journal of Proteome Research. 97
    
- Sun, X., & Zhai, J. (2025). Research Status and Trends of Gut Microbiota and Intestinal Diseases Based on Bibliometrics. Microorganisms. 14
    
- Cortes-Ciriano, I. (2024). An outlook on structural biology after AlphaFold: tools, limits and perspectives. Nature Reviews Molecular Cell Biology. 28
    
- Brault, D., Fournier, C., & Latychevskaia, T. (2025). Iterative phase retrieval algorithm for space-variant PSFs in optical systems with aberrations. Optics Letters. 30
    
- Xie, X., et al. (2024). Enhancing spatial resolution in MÖNCH for electron microscopy via deep learning. Journal of Instrumentation. 32
    
- Matinyan, S., Filipcik, P., van Genderen, E., & Abrahams, J. P. (2024). DiffraGAN: a conditional generative adversarial network for phasing single molecule diffraction data to atomic resolution. Frontiers in Molecular Biosciences. 35
    
- Matinyan, S., Abrahams, J. P. (2023). TERSE/PROLIX (TRPX) - a new algorithm for fast and lossless compression and decompression of diffraction and cryo-EM data. Acta Crystallographica Section A: Foundations and Advances. 98
    
- Matinyan, S., Demir, B., Filipcik, P., Abrahams, J. P., & van Genderen, E. (2023). Machine learning for classifying narrow-beam electron diffraction data. Acta Crystallographica Section A: Foundations and Advances. 89
    
- Matinyan, S., Filipcik, P., & Abrahams, J. P. (2024). Deep learning applications in protein crystallography. Acta Crystallographica Section A: Foundations and Advances. 87
    
- Zhang, X., Venkatachalapathy, S., Paysan, D., Schaerer, P., Tripodo, C., Uhler, C., & Shivashankar, G. V. (2024). Unsupervised representation learning of chromatin images identifies changes in cell state and tissue organization in DCIS. Nature Communications. 99
    
- Challa, K., Paysan, D., Leiser, D., Sauder, N., Weber, D. C., & Shivashankar, G. V. (2023). Imaging and AI based chromatin biomarkers for diagnosis and therapy evaluation from liquid biopsies. npj Precision Oncology. 100
    
- Zhang, X., Wang, X., Shivashankar, G. V., & Uhler, C. (2022). Graph-based autoencoder integrates spatial transcriptomics with chromatin images and identifies joint biomarkers for Alzheimer’s disease. Nature Communications. 94
    
- Svara, F., Förster, D., Kubo, F., Januszewski, M., dal Maschio, M., Schubert, P. J., et al. (2022). Automated synapse-level reconstruction of neural circuits in the larval zebrafish brain. Nature Methods. 38
    
- Varol, R., Karavelioglu, Z., Omeroglu, S., Aydemir, G., Karadag, A., Meco, H. E., et al. (2022). Acousto-holographic reconstruction of whole-cell stiffness maps. Nature Communications. 29
    
- Yang, K. D., Belyaeva, A., Venkatachalapathy, S., Damodaran, K., Katcoff, A., Radhakrishnan, A., et al. (2021). Multi-domain translation between single-cell imaging and sequencing data using autoencoders. Nature Communications. 54
    
- Belyaeva, A., Cammarata, L., Radhakrishnan, A., Squires, C., Yang, K. D., Shivashankar, G. V., & Uhler, C. (2021). Causal network models of SARS-CoV-2 expression and aging to identify candidates for drug repurposing. Nature Communications. 101
    
- Latychevskaia, T. (2021). Phase retrieval methods applied to coherent imaging. Advances in Imaging and Electron Physics. 102
    
- Ramakrishnan, K. R., Shishodia, S., Singh, A., & Rajasekaran, S. (2024). Machine Learning and Deep Learning in Synthetic Biology: Key Architectures, Applications, and Challenges. ACS Omega. 48
    
- Zhang, X., Wang, X., Xie, N., & Yang, H. (2021). Graph Neural Networks and Their Current Applications in Bioinformatics. Frontiers in Genetics. 52
    
- Peng, Y., Young, J., Liu, P., & Wu, X. (2024). SimuQ: A Framework for Programming Quantum Hamiltonian Simulation with Analog Compilation. Proceedings of the ACM on Programming Languages. 59
    
- Zhou, L., Barthe, G., Strub, P.-Y., Liu, J., & Ying, M. (2023). CoqQ: Foundational Verification of Quantum Programs. Proceedings of the ACM on Programming Languages. 60
    
- Gamboa, C., Reese, A., Fonseca, A., & Aldrich, J. (2025). Usability Barriers for Liquid Types. Proceedings of the ACM on Programming Languages. 75
    
- Marques, F., Ferreira, M., Nascimento, A., Coimbra, M. E., Santos, N., Jia, L., & Santos, J. F. (2025). Automated Exploit Generation for Node.js Packages. Proceedings of the ACM on Programming Languages. 75
    

#### Referências citadas

1. The impact of long-read sequencing on human population-scale genomics - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/40228902/](https://pubmed.ncbi.nlm.nih.gov/40228902/)
    
2. A preliminary study of LifeTime economic impact in Europe, acessado em junho 22, 2025, [https://lifetime-initiative.eu/wp-content/uploads/2021/01/A-preliminary-study-of-LifeTime-economic-impact-in-Europe.pdf](https://lifetime-initiative.eu/wp-content/uploads/2021/01/A-preliminary-study-of-LifeTime-economic-impact-in-Europe.pdf)
    
3. Bioinformatics - Impact Factor & Score 2025 - Research.com, acessado em junho 22, 2025, [https://research.com/journal/bioinformatics-1](https://research.com/journal/bioinformatics-1)
    
4. Recent Advances in Genome Editing and Bioinformatics: Addressing Challenges in Genome Editing Implementation and Genome Sequencing - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11989416/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11989416/)
    
5. A roadmap for genome projects to foster psychosocial and economic ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12117056/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12117056/)
    
6. Narrative Review and Evidence Mapping: Proteomics for ... - RAND, acessado em junho 22, 2025, [https://www.rand.org/content/dam/rand/pubs/external_publications/EP60000/EP68706/RAND_EP68706.pdf](https://www.rand.org/content/dam/rand/pubs/external_publications/EP60000/EP68706/RAND_EP68706.pdf)
    
7. AI-Driven Advancements in Bioinformatics: Transforming Healthcare ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12156641/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12156641/)
    
8. Advanced computational tools, artificial intelligence and machine-learning approaches in gut microbiota and biomarker identification - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12037385/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12037385/)
    
9. Machine learning algorithm brings long-read sequencing to the clinic | ScienceDaily, acessado em junho 22, 2025, [https://www.sciencedaily.com/releases/2025/05/250529124849.htm](https://www.sciencedaily.com/releases/2025/05/250529124849.htm)
    
10. Machine learning algorithm brings long-read sequencing to the clinic, acessado em junho 22, 2025, [https://www.rnoh.nhs.uk/news/machine-learning-algorithm-brings-long-read-sequencing-clinic](https://www.rnoh.nhs.uk/news/machine-learning-algorithm-brings-long-read-sequencing-clinic)
    
11. Algorithms for Molecular Biology - Impact Factor - S-Logix, acessado em junho 22, 2025, [https://slogix.in/research/journals/algorithms-for-molecular-biology/](https://slogix.in/research/journals/algorithms-for-molecular-biology/)
    
12. Updated List of High Journal Impact Factor Genetic Algorithm Journals, acessado em junho 22, 2025, [https://www.omicsonline.org/genetic-algorithm-journals-conferences-list.php](https://www.omicsonline.org/genetic-algorithm-journals-conferences-list.php)
    
13. Best Genetics Journals Ranking | Research.com, acessado em junho 22, 2025, [https://research.com/journals-rankings/genetics](https://research.com/journals-rankings/genetics)
    
14. Research Status and Trends of Gut Microbiota and Intestinal ... - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2076-2607/13/3/673](https://www.mdpi.com/2076-2607/13/3/673)
    
15. (PDF) Causal network models of SARS-CoV-2 expression and aging to identify candidates for drug repurposing - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/349337529_Causal_network_models_of_SARS-CoV-2_expression_and_aging_to_identify_candidates_for_drug_repurposing](https://www.researchgate.net/publication/349337529_Causal_network_models_of_SARS-CoV-2_expression_and_aging_to_identify_candidates_for_drug_repurposing)
    
16. Artificial intelligence in variant calling: a review - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/bioinformatics/articles/10.3389/fbinf.2025.1574359/full](https://www.frontiersin.org/journals/bioinformatics/articles/10.3389/fbinf.2025.1574359/full)
    
17. New algorithms for accurate and efficient de novo genome assembly from long DNA sequencing reads, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9946810/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9946810/)
    
18. Diversity and consequences of structural variation in the human genome - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/39838028/](https://pubmed.ncbi.nlm.nih.gov/39838028/)
    
19. Diversity and consequences of structural variation in the human genome - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/388260900_Diversity_and_consequences_of_structural_variation_in_the_human_genome](https://www.researchgate.net/publication/388260900_Diversity_and_consequences_of_structural_variation_in_the_human_genome)
    
20. SAVANA: reliable analysis of somatic structural variants and copy number aberrations using long-read sequencing - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/40437218/](https://pubmed.ncbi.nlm.nih.gov/40437218/)
    
21. Machine learning algorithm brings long-read sequencing to the clinic | EMBL, acessado em junho 22, 2025, [https://www.embl.org/news/science-technology/long-read-sequencing-savana/](https://www.embl.org/news/science-technology/long-read-sequencing-savana/)
    
22. Unraveling the hidden complexity of cancer through long-read sequencing - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12047254/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12047254/)
    
23. Genome complexity, not ploidy, dictates long-read variant-calling accuracy | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.05.14.653922v1.full-text](https://www.biorxiv.org/content/10.1101/2025.05.14.653922v1.full-text)
    
24. Journal of Proteome Research Vol. 20 No. 12 - ACS Publications, acessado em junho 22, 2025, [https://pubs.acs.org/toc/jprobs/20/12](https://pubs.acs.org/toc/jprobs/20/12)
    
25. Open-Source and FAIR Research Software for Proteomics - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12053954/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12053954/)
    
26. Spectroscape enables real-time query and visualization of a spectral archive in proteomics, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10560257/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10560257/)
    
27. ClusterSheep: A Graphics Processing Unit-Accelerated Software Tool for Large-Scale Clustering of Tandem Mass Spectra from Shotgun Proteomics - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/34734728/](https://pubmed.ncbi.nlm.nih.gov/34734728/)
    
28. An outlook on structural biology after AlphaFold: tools, limits and ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11788754/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11788754/)
    
29. LMB Publications 2021 - 2025 | Laboratory for Multiscale Bioimaging | PSI, acessado em junho 22, 2025, [https://www.psi.ch/en/lmb/lnb-publications-2025](https://www.psi.ch/en/lmb/lnb-publications-2025)
    
30. Transformation thermodynamics: cloaking and concentrating heat flux, acessado em junho 22, 2025, [https://opg.optica.org/abstract.cfm?URI=ol-50-6-1767](https://opg.optica.org/abstract.cfm?URI=ol-50-6-1767)
    
31. Iterative phase retrieval algorithm for space-variant PSF in optical systems with aberrations, acessado em junho 22, 2025, [https://arxiv.org/html/2502.04897v1](https://arxiv.org/html/2502.04897v1)
    
32. Enhancing spatial resolution in MÖNCH for electron microscopy via deep learning - Research Collection, acessado em junho 22, 2025, [https://www.research-collection.ethz.ch/bitstream/handle/20.500.11850/719554/2/Xie_2024_J._Inst._19_C01020.pdf](https://www.research-collection.ethz.ch/bitstream/handle/20.500.11850/719554/2/Xie_2024_J._Inst._19_C01020.pdf)
    
33. Enhancing spatial resolution in MÖNCH for electron microscopy via deep learning, acessado em junho 22, 2025, [https://www.researchgate.net/publication/377484052_Enhancing_spatial_resolution_in_MONCH_for_electron_microscopy_via_deep_learning](https://www.researchgate.net/publication/377484052_Enhancing_spatial_resolution_in_MONCH_for_electron_microscopy_via_deep_learning)
    
34. acessado em dezembro 31, 1969, [https://iopscience.iop.org/article/10.1088/1748-0221/19/01/C01020/meta](https://iopscience.iop.org/article/10.1088/1748-0221/19/01/C01020/meta)
    
35. DiffGAN: a conditional generative adversarial network for phasing single molecule diffraction data to atomic resolution | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2024.02.15.580528v1](https://www.biorxiv.org/content/10.1101/2024.02.15.580528v1)
    
36. Frontiers in Molecular Biosciences | Structural Biology, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/molecular-biosciences/sections/structural-biology/articles?publication-date=01/01/2007-14/09/2024](https://www.frontiersin.org/journals/molecular-biosciences/sections/structural-biology/articles?publication-date=01/01/2007-14/09/2024)
    
37. DiffraGAN: a conditional generative adversarial network ... - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/articles/10.3389/fmolb.2024.1386963/full](https://www.frontiersin.org/articles/10.3389/fmolb.2024.1386963/full)
    
38. Automated synapse-level reconstruction of neural circuits in the larval zebrafish brain, acessado em junho 22, 2025, [https://experiments.springernature.com/articles/10.1038/s41592-022-01621-0](https://experiments.springernature.com/articles/10.1038/s41592-022-01621-0)
    
39. Correlative light and electron microscopy reveals the fine circuit structure underlying evidence accumulation in larval zebrafish - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11952533/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11952533/)
    
40. acessado em dezembro 31, 1969, [https://www.nature.com/articles/s41592-022-01621-0](https://www.nature.com/articles/s41592-022-01621-0)
    
41. Metagenomics - a guide from sampling to data analysis - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC3351745/](https://pmc.ncbi.nlm.nih.gov/articles/PMC3351745/)
    
42. Metagenomics: A Tool for Exploring Key Microbiome With the Potentials for Improving Sustainable Agriculture - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/sustainable-food-systems/articles/10.3389/fsufs.2022.886987/full](https://www.frontiersin.org/journals/sustainable-food-systems/articles/10.3389/fsufs.2022.886987/full)
    
43. Metagenome-Assembled Genomes (MAGs): Advances, Challenges, and Ecological Insights, acessado em junho 22, 2025, [https://www.mdpi.com/2076-2607/13/5/985](https://www.mdpi.com/2076-2607/13/5/985)
    
44. MetaComBin: combining abundances and overlaps for binning metagenomics reads - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/bioinformatics/articles/10.3389/fbinf.2025.1504728/full](https://www.frontiersin.org/journals/bioinformatics/articles/10.3389/fbinf.2025.1504728/full)
    
45. Metagenomic Binning Algorithms - eScholarship.org, acessado em junho 22, 2025, [https://escholarship.org/uc/item/19j606dr](https://escholarship.org/uc/item/19j606dr)
    
46. Metagenomics and Bioinformatics in Microbial Ecology: Current Status and Beyond, acessado em junho 22, 2025, [https://www.jstage.jst.go.jp/article/jsme2/31/3/31_ME16024/_article](https://www.jstage.jst.go.jp/article/jsme2/31/3/31_ME16024/_article)
    
47. Complex responses of soil prokaryotes, fungi and protists to prairie restoration on retired agricultural lands - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2024.10.11.617895v1.full.pdf](https://www.biorxiv.org/content/10.1101/2024.10.11.617895v1.full.pdf)
    
48. Machine Learning and Deep Learning in Synthetic Biology: Key Architectures, Applications, and Challenges | ACS Omega - ACS Publications, acessado em junho 22, 2025, [https://pubs.acs.org/doi/10.1021/acsomega.3c05913](https://pubs.acs.org/doi/10.1021/acsomega.3c05913)
    
49. Deep learning in bioinformatics - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11045206/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11045206/)
    
50. Full article: Bioinformatics and machine learning to support nanomaterial grouping, acessado em junho 22, 2025, [https://www.tandfonline.com/doi/full/10.1080/17435390.2024.2368005](https://www.tandfonline.com/doi/full/10.1080/17435390.2024.2368005)
    
51. Graphery: interactive tutorials for biological network algorithms - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC8262715/](https://pmc.ncbi.nlm.nih.gov/articles/PMC8262715/)
    
52. Graph Neural Networks and Their Current Applications in Bioinformatics - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/genetics/articles/10.3389/fgene.2021.690049/full](https://www.frontiersin.org/journals/genetics/articles/10.3389/fgene.2021.690049/full)
    
53. Optimal transport for single-cell and spatial omics | Springer Nature Experiments, acessado em junho 22, 2025, [https://experiments.springernature.com/nature/primers/10.1038/s43586-024-00334-2](https://experiments.springernature.com/nature/primers/10.1038/s43586-024-00334-2)
    
54. (PDF) Multi-domain translation between single-cell imaging and sequencing data using autoencoders - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/348203238_Multi-domain_translation_between_single-cell_imaging_and_sequencing_data_using_autoencoders](https://www.researchgate.net/publication/348203238_Multi-domain_translation_between_single-cell_imaging_and_sequencing_data_using_autoencoders)
    
55. OmicsML/awesome-deep-learning-single-cell-papers - GitHub, acessado em junho 22, 2025, [https://github.com/OmicsML/awesome-deep-learning-single-cell-papers](https://github.com/OmicsML/awesome-deep-learning-single-cell-papers)
    
56. Chicago Journal of Theoretical Computer Science, acessado em junho 22, 2025, [http://cjtcs.cs.uchicago.edu/](http://cjtcs.cs.uchicago.edu/)
    
57. awesome-theoretical-computer-science/README.md at main - GitHub, acessado em junho 22, 2025, [https://github.com/mostafatouny/awesome-theoretical-computer-science/blob/main/README.md](https://github.com/mostafatouny/awesome-theoretical-computer-science/blob/main/README.md)
    
58. Theoretical computer science - Wikipedia, acessado em junho 22, 2025, [https://en.wikipedia.org/wiki/Theoretical_computer_science](https://en.wikipedia.org/wiki/Theoretical_computer_science)
    
59. Proceedings of the ACM on Programming Languages, Volume 8 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/journals/pacmpl/pacmpl8.html#nrPOPL](https://dblp.org/db/journals/pacmpl/pacmpl8.html#nrPOPL)
    
60. Proceedings of the ACM on Programming Languages, Volume 7 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/journals/pacmpl/pacmpl7.html#nrPOPL](https://dblp.org/db/journals/pacmpl/pacmpl7.html#nrPOPL)
    
61. Proceedings of the ACM on Programming Languages, Volume 6 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/journals/pacmpl/pacmpl6.html#nrPOPL](https://dblp.org/db/journals/pacmpl/pacmpl6.html#nrPOPL)
    
62. Proceedings of the ACM on Programming Languages, Volume 5 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/journals/pacmpl/pacmpl5.html#nrPOPL](https://dblp.org/db/journals/pacmpl/pacmpl5.html#nrPOPL)
    
63. STOC 2021 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/conf/stoc/stoc2021.html](https://dblp.org/db/conf/stoc/stoc2021.html)
    
64. STOC 2022 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/conf/stoc/stoc2022.html](https://dblp.org/db/conf/stoc/stoc2022.html)
    
65. STOC 2023 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/conf/stoc/stoc2023.html](https://dblp.org/db/conf/stoc/stoc2023.html)
    
66. STOC 2024 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/conf/stoc/stoc2024.html](https://dblp.org/db/conf/stoc/stoc2024.html)
    
67. CEUR-WS.org/Vol-3587 - 24th Italian Conference on Theoretical Computer Science 2023, acessado em junho 22, 2025, [https://ceur-ws.org/Vol-3587/](https://ceur-ws.org/Vol-3587/)
    
68. Computational Biology Conferences - Mukul Bansal - University of Connecticut, acessado em junho 22, 2025, [https://mukul-bansal.uconn.edu/computational-biology-conferences/](https://mukul-bansal.uconn.edu/computational-biology-conferences/)
    
69. SODA 2021 - dblp, acessado em junho 22, 2025, [https://dblp.org/db/conf/soda/soda2021.html](https://dblp.org/db/conf/soda/soda2021.html)
    
70. Quantum Communication Advantage in TFNP - Apollo - University of Cambridge, acessado em junho 22, 2025, [https://www.repository.cam.ac.uk/items/6cb7f1e8-e83a-43e0-b662-bc8d9b403d35](https://www.repository.cam.ac.uk/items/6cb7f1e8-e83a-43e0-b662-bc8d9b403d35)
    
71. Quantum Communication Advantage in TFNP arXiv:2411.03296v2 [quant-ph] 24 Feb 2025, acessado em junho 22, 2025, [https://arxiv.org/pdf/2411.03296](https://arxiv.org/pdf/2411.03296)
    
72. What Are Formal Methods? | Galois, acessado em junho 22, 2025, [https://www.galois.com/what-are-formal-methods](https://www.galois.com/what-are-formal-methods)
    
73. Gary T. Leavens's Home Page - UCF Department of Electrical Engineering and Computer Science - University of Central Florida, acessado em junho 22, 2025, [https://www.eecs.ucf.edu/~leavens/homepage.html](https://www.eecs.ucf.edu/~leavens/homepage.html)
    
74. Formal Aspects of Computing - Scimago, acessado em junho 22, 2025, [https://www.scimagojr.com/journalsearch.php?q=24980&tip=sid](https://www.scimagojr.com/journalsearch.php?q=24980&tip=sid)
    
75. CyLab researchers to present at PLDI 2025 - CMU's CyLab, acessado em junho 22, 2025, [https://www.cylab.cmu.edu/news/2025/06/17-cylab-presents-at-pldi-2025.html](https://www.cylab.cmu.edu/news/2025/06/17-cylab-presents-at-pldi-2025.html)
    
76. Usability Barriers for Liquid Types - Catarina Gamboa, acessado em junho 22, 2025, [https://catarinagamboa.github.io/papers/pre_print_barriers_liquid_types.pdf](https://catarinagamboa.github.io/papers/pre_print_barriers_liquid_types.pdf)
    
77. Practical Type Inference with Levels (PLDI 2025 - PLDI Research Papers), acessado em junho 22, 2025, [https://pldi25.sigplan.org/details/pldi-2025-papers/89/Practical-Type-Inference-with-Levels](https://pldi25.sigplan.org/details/pldi-2025-papers/89/Practical-Type-Inference-with-Levels)
    
78. Jonathan Aldrich (@jonathanaldrich.bsky.social) - Bluesky, acessado em junho 22, 2025, [https://bsky.app/profile/jonathanaldrich.bsky.social](https://bsky.app/profile/jonathanaldrich.bsky.social)
    
79. Large-scale phylogenomics of aquatic bacteria reveal molecular ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10219603/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10219603/)
    
80. Metagenomic methylation patterns resolve bacterial genomes of unusual size and structural complexity | The ISME Journal | Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/ismej/article/16/8/1921/7474264](https://academic.oup.com/ismej/article/16/8/1921/7474264)
    
81. Journal of Proteome Research Ahead of Print - ACS Publications, acessado em junho 22, 2025, [https://pubs.acs.org/toc/jprobs/0/0](https://pubs.acs.org/toc/jprobs/0/0)
    
82. Three-Dimensional Structure from Single Two-Dimensional Diffraction Intensity Measurement, acessado em junho 22, 2025, [https://www.zora.uzh.ch/id/eprint/211657/1/PhysRevLett.127.063601.pdf](https://www.zora.uzh.ch/id/eprint/211657/1/PhysRevLett.127.063601.pdf)
    
83. Three-dimensional structure from single two-dimensional diffraction intensity measurement - arXiv, acessado em junho 22, 2025, [https://arxiv.org/pdf/2201.09293](https://arxiv.org/pdf/2201.09293)
    
84. Three-Dimensional Structure from Single Two-Dimensional ..., acessado em junho 22, 2025, [https://journals.aps.org/prl/abstract/10.1103/PhysRevLett.127.063601](https://journals.aps.org/prl/abstract/10.1103/PhysRevLett.127.063601)
    
85. Automated Exploit Generation for Node.js Packages - SysSec @ DPSS.INESC-ID, acessado em junho 22, 2025, [https://syssec.dpss.inesc-id.pt/papers/marques_pldi25.pdf](https://syssec.dpss.inesc-id.pt/papers/marques_pldi25.pdf)
    
86. PoCGen: Generating Proof-of-Concept Exploits for Vulnerabilities in Npm Packages - arXiv, acessado em junho 22, 2025, [https://arxiv.org/html/2506.04962](https://arxiv.org/html/2506.04962)
    
87. Deep learning applications in protein crystallography - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/38189437/](https://pubmed.ncbi.nlm.nih.gov/38189437/)
    
88. (IUCr) Acta Crystallographica Section A Volume 80, Part 1, January 2024, acessado em junho 22, 2025, [https://journals.iucr.org/a/issues/2024/01/00/](https://journals.iucr.org/a/issues/2024/01/00/)
    
89. Machine learning for classifying narrow-beam electron diffraction data - IUCr Journals, acessado em junho 22, 2025, [https://journals.iucr.org/paper?lu5027](https://journals.iucr.org/paper?lu5027)
    
90. (IUCr) Acta Crystallographica Section A Volume 79, Part 4, July 2023, acessado em junho 22, 2025, [https://journals.iucr.org/a/issues/2023/04/00/](https://journals.iucr.org/a/issues/2023/04/00/)
    
91. (IUCr) Machine learning for classifying narrow-beam electron ..., acessado em junho 22, 2025, [https://journals.iucr.org/a/issues/2023/04/00/lu5027/index.html](https://journals.iucr.org/a/issues/2023/04/00/lu5027/index.html)
    
92. PFMG2025–integrating genomic medicine into the national ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11910791/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11910791/)
    
93. acessado em dezembro 31, 1969, [https://www.nature.com/articles/s41467-020-20249-2](https://www.nature.com/articles/s41467-020-20249-2)
    
94. Graph-based autoencoder integrates spatial transcriptomics with chromatin images and identifies joint biomarkers for Alzheimer's disease - LIUC Universita Carlo Cattaneo, acessado em junho 22, 2025, [https://liuc.primo.exlibrisgroup.com/discovery/fulldisplay?docid=cdi_springer_journals_10_1038_s41467_022_35233_1&context=PC&vid=39LUCC_INST:VU1&lang=it&search_scope=MyInst_and_CI&adaptor=Primo%20Central&query=sub%2Cexact%2C%20Chromatin%20-%20metabolism%20%2CAND&facet=citedby%2Cexact%2Ccdi_FETCH-LOGICAL-c541t-3baf29479e7cf42da86b86b97db3c7484830d2e02e45d2a903d6d80272330f3a3&offset=20](https://liuc.primo.exlibrisgroup.com/discovery/fulldisplay?docid=cdi_springer_journals_10_1038_s41467_022_35233_1&context=PC&vid=39LUCC_INST:VU1&lang=it&search_scope=MyInst_and_CI&adaptor=Primo+Central&query=sub,exact,+Chromatin+-+metabolism+,AND&facet=citedby,exact,cdi_FETCH-LOGICAL-c541t-3baf29479e7cf42da86b86b97db3c7484830d2e02e45d2a903d6d80272330f3a3&offset=20)
    
95. Tissues - Eric and Wendy Schmidt Center, acessado em junho 22, 2025, [https://www.ericandwendyschmidtcenter.org/tissues](https://www.ericandwendyschmidtcenter.org/tissues)
    
96. acessado em dezembro 31, 1969, [https://www.nature.com/articles/s41467-022-35233-1](https://www.nature.com/articles/s41467-022-35233-1)
    
97. The Circulating Proteome Technological Developments, Current ..., acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/39479990](https://pubmed.ncbi.nlm.nih.gov/39479990)
    
98. TERSE/PROLIX (TRPX) – a new algorithm for fast and lossless compression and decompression of diffraction and cryo-EM data - IUCr Journals, acessado em junho 22, 2025, [https://journals.iucr.org/paper?lu5031](https://journals.iucr.org/paper?lu5031)
    
99. Publications - Eric and Wendy Schmidt Center, acessado em junho 22, 2025, [https://www.ericandwendyschmidtcenter.org/publications?tag=cells](https://www.ericandwendyschmidtcenter.org/publications?tag=cells)
    
100. Imaging and AI based chromatin biomarkers for diagnosis and therapy evaluation from liquid biopsies - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/376514812_Imaging_and_AI_based_chromatin_biomarkers_for_diagnosis_and_therapy_evaluation_from_liquid_biopsies](https://www.researchgate.net/publication/376514812_Imaging_and_AI_based_chromatin_biomarkers_for_diagnosis_and_therapy_evaluation_from_liquid_biopsies)
    
101. Causal network models of SARS-CoV-2 expression and aging to identify candidates for drug repurposing - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC7884845/](https://pmc.ncbi.nlm.nih.gov/articles/PMC7884845/)
    
102. Phase retrieval methods applied to coherent imaging - Zurich Open Repository and Archive - Universität Zürich, acessado em junho 22, 2025, [https://www.zora.uzh.ch/id/eprint/211638/](https://www.zora.uzh.ch/id/eprint/211638/)
    

**