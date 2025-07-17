# Relatório Abrangente sobre Análise de Sequências de DNA e Proteínas e Bancos de Sequências (2021-2025)

## Resumo Executivo
A era pós-genômica, impulsionada pela explosão de dados biológicos de alta throughput, tem transformado fundamentalmente a análise de sequências de DNA e proteínas, bem como a arquitetura dos bancos de dados biológicos. Entre 2021 e 2025, o campo testemunhou avanços notáveis, predominantemente catalisados pela integração de Inteligência Artificial (IA) e Aprendizado de Máquina (AM). Essas tecnologias não apenas aprimoraram a velocidade e a precisão da análise de sequências, mas também permitiram a decifração de complexidades biológicas anteriormente inatingíveis, como a função do DNA não codificante e a estrutura tridimensional do genoma.

Na análise de DNA, a sinergia entre tecnologias de sequenciamento de leitura curta e longa, juntamente com a emergência de métodos de resolução de molécula única, revolucionou o diagnóstico molecular, a vigilância de patógenos e a compreensão da resistência antimicrobiana. Paralelamente, no domínio das proteínas, a predição de estruturas atingiu uma precisão quase experimental com o advento de modelos como o AlphaFold, redefinindo a biologia estrutural. Modelos de linguagem de proteínas (PLMs) estão agora permitindo o design de novo de proteínas, abrindo novas fronteiras na engenharia de proteínas e na descoberta de fármacos.

Os bancos de dados biológicos, por sua vez, evoluíram para ecossistemas mais especializados e integrados, capazes de gerenciar e interligar dados multi-ômicos e de célula única. A incorporação de estruturas preditas por IA nesses repositórios reflete uma mudança profunda na curadoria e disseminação do conhecimento biológico. Coletivamente, esses avanços estão pavimentando o caminho para uma medicina personalizada mais precisa, o desenvolvimento acelerado de novas terapias e uma capacidade aprimorada de resposta a desafios de saúde pública global.

  

## 1. Introdução
### 1.1. Contexto e Relevância da Análise de Sequências e Bancos de Dados Biológicos na Era Pós-Genômica
A era pós-genômica é caracterizada por uma proliferação sem precedentes de dados biológicos, impulsionada em grande parte pelas tecnologias de sequenciamento de alto rendimento. Essa avalanche de informações sublinha a importância crítica da análise avançada de sequências e de bancos de dados biológicos robustos para desvendar processos vitais fundamentais, compreender mecanismos de doenças e fomentar a inovação em biotecnologia e medicina personalizada.1

A escala colossal de dados gerados, que se prevê atingir 175 Zettabytes (ZB) até 2025 e mais de 435 ZB até 2030 em volume global 4, exige abordagens computacionais sofisticadas. O Plano Estratégico do NIH para os Anos Fiscais de 2021–2025 reconhece explicitamente essa necessidade, enfatizando o aumento da capacidade de armazenamento, gestão e análise de dados, e destacando o papel central da IA em ampliar as capacidades humanas para identificar padrões e prever resultados dentro desses vastos conjuntos de dados genômicos.5 A magnitude e complexidade dos dados biológicos, que se manifestam desde o sequenciamento de genomas completos até abordagens multi-ômicas de célula única, não representam apenas um aumento quantitativo. Em vez disso, essa expansão representa uma transformação fundamental que torna a adoção de IA e métodos computacionais avançados não apenas benéfica, mas essencial. As análises manuais ou de baixo rendimento, que antes eram viáveis, são agora insuficientes para extrair informações significativas de conjuntos de dados tão vastos e intrincados. Essa dinâmica estabelece uma relação de causa e efeito clara, onde a escala dos dados impulsiona a necessidade e o desenvolvimento de soluções baseadas em IA.

O campo está cada vez mais se orientando para abordagens multi-ômicas integradas, combinando genômica, transcriptômica e proteômica, para alcançar uma compreensão mais holística e abrangente de sistemas biológicos complexos.6 Essa integração é crucial para desvendar as interações complexas que governam a biologia, desde o nível molecular até o sistêmico.

  

### 1.2. Objetivo e Estrutura do Relatório
Este relatório tem como objetivo revisar sistematicamente os avanços mais significativos na análise de sequências de DNA e proteínas e em bancos de dados de sequências biológicas no período de 2021 a 2025. O conteúdo será extraído exclusivamente da literatura científica de alto impacto, apresentando os resultados em um texto acadêmico explicativo e linear. Cada avanço será discutido em seu contexto, mecanismos subjacentes e implicações mais amplas, com o suporte de citações de artigos específicos e seus respectivos DOIs.

  

## 2. Avanços Recentes na Análise de Sequências de DNA (2021-2025)
### 2.1. Inovações em Tecnologias de Sequenciamento (NGS, Leitura Longa e Single-Molecule)
A última década testemunhou uma evolução contínua nas tecnologias de sequenciamento de DNA, com o período de 2021 a 2025 marcando um amadurecimento significativo e a proliferação de abordagens híbridas. A combinação estratégica de sequenciamento de leitura curta (por exemplo, plataformas Illumina) e tecnologias de leitura longa (por exemplo, Oxford Nanopore Technologies) tornou-se fundamental para alcançar uma caracterização genômica abrangente e precisa.8 Essa abordagem híbrida é particularmente eficaz para resolver regiões genômicas complexas, como aquelas que contêm genes de resistência antimicrobiana (AMR) e fatores de virulência transportados em plasmídeos bacterianos, permitindo a montagem precisa de genomas completos.

A tecnologia Nanopore, em particular, tem demonstrado avanços notáveis, oferecendo portabilidade, acessibilidade e tempos de resposta rápidos. Essas características a tornaram uma ferramenta complementar inestimável para a vigilância genômica em tempo real, como evidenciado por seu papel crítico no rastreamento de variantes do SARS-CoV-2 e suas dinâmicas evolutivas de 2021 a 2025.10 Além disso, a tecnologia Nanopore oferece flexibilidade para leituras longas e análise direta em tempo real tanto de DNA quanto de RNA, ampliando sua utilidade em diversas aplicações de pesquisa e saúde pública.11

Novas tecnologias de sequenciamento, como o Sequenciamento de Código de Barras de Gotas (DBS), permitiram a haplotipagem de genomas completos com resolução de molécula única e um rendimento sem precedentes.12 Essa capacidade é crucial para o estudo de amostras metagenômicas complexas e para a obtenção de informações de sequência de alta resolução e específicas da amostra, essenciais para identificar alterações nucleotídicas sutis ou raras que os métodos de sequenciamento em massa poderiam ignorar.13 A evolução das tecnologias de sequenciamento de DNA durante este período reflete uma mudança estratégica para além da mera geração de dados, visando aprimorar a qualidade, a completude e a acessibilidade das informações genômicas. A ênfase em abordagens híbridas, resolução de molécula única e plataformas portáteis indica que o campo está sendo impulsionado pela necessidade de abordar questões biológicas complexas, como a evolução de patógenos e variantes estruturais, e de democratizar as capacidades genômicas avançadas para além dos centros de pesquisa especializados.

Além de seu papel como modelo biológico, o DNA está sendo cada vez mais explorado como um meio de alta densidade e longo prazo para armazenamento de "dados frios", especialmente para registros médicos. Essa aplicação tira proveito das tecnologias de sequenciamento de próxima geração existentes para recuperação de dados, posicionando o DNA como uma solução potencial para a crescente carga de dados global.4

  

### 2.2. Aplicações de Inteligência Artificial e Aprendizado de Máquina na Interpretação de Dados de DNA
Algoritmos de IA tornaram-se indispensáveis para interpretar o vasto e complexo cenário dos dados de DNA, permitindo a detecção de padrões genéticos sutis que frequentemente são intratáveis para a análise humana. Isso levou a uma precisão diagnóstica significativamente aprimorada e ao avanço da medicina personalizada.1 Ferramentas específicas impulsionadas por IA, como AMELIE, AVADA, Exomiser, DeepGestalt e Fabric GEM, demonstraram sucesso notável, alcançando mais de 90% de precisão na identificação de variantes genômicas ligadas a doenças raras e acelerando diagnósticos em pacientes pediátricos gravemente enfermos.1

A capacidade computacional da IA permitiu uma compreensão mais profunda do DNA não codificante (ncDNA), anteriormente considerado "DNA lixo". Estudos recentes (por exemplo, Pagni et al., 2021) indicam que essas sequências são cruciais para regular a expressão gênica e o desenvolvimento de doenças, com a IA revelando informações e padrões perdidos pelas técnicas convencionais.1 Métodos impulsionados por IA, como o CT-SLEB desenvolvido pela Johns Hopkins (2023), estão aprimorando a precisão dos escores de risco poligênico, particularmente para populações não europeias, ao aproveitar eficazmente diversos conjuntos de dados genéticos. Isso aborda uma lacuna crítica na medicina genômica equitativa.1

Algoritmos de aprendizado de máquina (AM) e aprendizado profundo (AD) são cada vez mais aplicados ao sequenciamento de genoma completo (WGS) e dados de pangênoma para prever o potencial patogênico de cepas bacterianas (por exemplo, Vibrio parahaemolyticus). Esses métodos identificam genes de virulência críticos, analisam perfis de resistência antimicrobiana (AMR) e elucidam dinâmicas evolutivas, oferecendo novas ferramentas diagnósticas e contribuindo significativamente para a segurança alimentar e a vigilância da saúde pública.8

Técnicas avançadas de AM, incluindo Redes Neurais Gráficas (GNNs) como o TENET, estão sendo desenvolvidas para reconstruir redes de interação célula-célula a partir de dados de transcriptômica espacial. Isso proporciona uma compreensão mais sutil e espacialmente resolvida dos padrões de comunicação celular dentro dos tecidos.20 A aplicação generalizada de IA e AM na análise de sequências de DNA representa uma mudança fundamental de meramente identificar variações genéticas para interpretar suas consequências funcionais e prever resultados biológicos. Essa capacidade preditiva, especialmente em áreas complexas como DNA não codificante, risco poligênico e virulência de patógenos, está transformando a pesquisa genômica de uma ciência descritiva em uma disciplina verdadeiramente preditiva e acionável, impactando diretamente a prática clínica e as estratégias de saúde pública.
### 2.3. Análise de DNA Não Codificante e Estrutura Genômica 3D
O foco crescente no DNA não codificante e na estrutura genômica tridimensional representa um amadurecimento significativo da análise genômica, que transcende a sequência linear para compreender o complexo contexto espacial e regulatório da informação genética. Essa mudança é impulsionada pelo reconhecimento de que a função celular não é ditada apenas pelas sequências genéticas, mas também por sua organização tridimensional e pelos papéis regulatórios dos elementos não codificantes. A IA e as técnicas avançadas de imagem são cruciais para desvendar essa complexidade multidimensional.

Uma técnica inovadora, o "sequenciamento do genoma in situ por expansão", desenvolvida por pesquisadores do Broad Institute (publicada na Science em maio de 2025), permite o sequenciamento direto do DNA e o mapeamento de sua localização espacial em relação às proteínas dentro de núcleos celulares intactos.21 Esse método envolve a expansão física das células usando um gel, mantendo sua integridade, o que possibilita tanto o sequenciamento de alta resolução quanto a imagem dentro do mesmo contexto celular. Essa abordagem tem sido fundamental para revelar como as interrupções no núcleo celular podem impactar a saúde e as doenças, como na progéria, onde proteínas nucleares mutadas podem suprimir a expressão gênica.

Os avanços na modelagem computacional, particularmente as simulações de polímeros 3D, estão fornecendo insights críticos sobre a organização do genoma e suas implicações funcionais. Esses modelos podem prever a localização nuclear de "fábricas de transcrição" e estimar as taxas de ativação de promotores em todo o genoma.22 Baseados nas forças físicas que impulsionam a conformação do genoma, esses modelos oferecem uma visão conceitual unificada da organização do genoma e da regulação gênica, com parâmetros transferíveis entre diferentes tipos de células.
### 2.4. Impacto no Diagnóstico Molecular e Vigilância de Patógenos
A análise de sequências de DNA, especialmente com o auxílio da IA, evoluiu de uma ferramenta puramente orientada para a pesquisa para se tornar um pilar da infraestrutura de saúde pública moderna. Sua aplicação em tempo real na vigilância de patógenos, investigação de surtos e diagnósticos rápidos se traduz diretamente em melhores resultados clínicos e maior segurança global da saúde, demonstrando um impacto translacional significativo.

A integração da IA com o sequenciamento avançado de DNA impactou profundamente o diagnóstico molecular. Ferramentas impulsionadas por IA (por exemplo, Exomiser, DeepGestalt, Fabric GEM) aceleram significativamente o diagnóstico de doenças genéticas raras, aprimorando a interpretação de dados complexos de sequenciamento genômico, o que leva a decisões clínicas mais rápidas e precisas.1

O sequenciamento de genoma completo (WGS), incluindo a poderosa combinação de tecnologias de leitura curta e longa, é agora um padrão para caracterizar perfis de resistência antimicrobiana (AMR) e genes de virulência em patógenos bacterianos, como Salmonella enterica e Enterobacterales produtores de carbapenemase (CPE).8 Isso fornece informações cruciais sobre a dinâmica de plasmídeos e a disseminação de genes de resistência, informando diretamente as intervenções de saúde pública. O Plano de Ação da FAO sobre AMR (2021-2025) sublinha o compromisso global com estratégias baseadas em dados para o monitoramento da AMR.16

Os dados de WGS são fundamentais para o desenvolvimento de métodos de genotipagem de alta resolução e sorotipagem molecular, permitindo a identificação de atributos de virulência e distinguindo cepas patogênicas de não patogênicas.3 A análise filogenética, por exemplo, do gene 16S rRNA, continua a fornecer informações valiosas sobre padrões de resistência a medicamentos e homologia genética entre isolados bacterianos.23

A vigilância genômica, aproveitando as tecnologias de sequenciamento de leitura curta e longa, provou ser crítica para rastrear as variantes do SARS-CoV-2 e suas dinâmicas evolutivas de 2021 a 2025. Isso destaca o papel vital das capacidades de sequenciamento rápido e descentralizado na segurança da saúde global e na prontidão para pandemias.10

  

## 3. Avanços Recentes na Análise de Sequências de Proteínas (2021-2025)
### 3.1. A Revolução da Predição de Estruturas Proteicas (AlphaFold e Modelos Baseados em IA)
O período de 2021-2025 foi marcado pelo impacto transformador do AlphaFold2 (AF2), lançado em 2021, que alcançou uma precisão quase experimental sem precedentes na previsão de estruturas proteicas monoméricas (Jumper et al., 2021).24 Seu sucessor, AlphaFold-Multimer (AFM), estendeu ainda mais essa capacidade para prever com precisão as estruturas quaternárias de complexos proteicos.24 O AF2 demonstrou alta precisão (GDT_TS > 70) para 87 dos 92 domínios, atingindo precisão experimental (GDT_TS > 90) para 58 domínios.26

O AlphaFold revolucionou a biologia estrutural ao acelerar a determinação experimental de estruturas, facilitar o design de proteínas e aprofundar a compreensão das interações proteína-proteína.25 O Banco de Dados de Estruturas Proteicas AlphaFold (AFDB) cresceu exponencialmente, contendo 214 milhões de estruturas até 2022 e cobrindo aproximadamente 90% do espaço de sequência do UniProt até 2024, tornando as informações estruturais amplamente acessíveis.25

A inovação do AlphaFold representa uma mudança de paradigma, onde a predição computacional se tornou um método primário, e frequentemente preferencial, para obter informações estruturais de proteínas, complementando e até mesmo orientando abordagens experimentais. Isso acelerou profundamente o ritmo da pesquisa em biologia estrutural e campos relacionados. O desenvolvimento subsequente de modelos como o AF3, que abordam as limitações anteriores, indica um avanço rápido e iterativo, expandindo os limites para prever estados proteicos dinâmicos e interativos, cruciais para a compreensão da função biológica em sistemas vivos.

Apesar de seu sucesso, o AF2 ainda enfrenta limitações na previsão precisa da dinâmica proteica, interações com pequenas moléculas (ligantes) e as estruturas de regiões intrinsecamente desordenadas.24 No entanto, modelos mais recentes como AlphaFold3 (AF3), NeuralPLexer, Chai-1 e Boltz-1 estão emergindo, mostrando melhorias significativas, particularmente na previsão de complexos proteína-ligante com precisão e poder discriminatório aprimorados.31

  

### 3.2. Progressos na Análise Proteômica Quantitativa Baseada em Espectrometria de Massas
A proteômica quantitativa baseada em espectrometria de massas tem demonstrado utilidade crescente em diagnósticos clínicos, especialmente para doenças raras como distúrbios mitocondriais (MDs). Ela oferece uma opção mais econômica e de aplicação mais ampla em comparação com ensaios funcionais tradicionais, muitas vezes invasivos, como a enzimologia da cadeia respiratória (RCE).6

Estudos analisaram o microcusto de testes proteômicos, estimando um custo médio de US$ 897 (US$ 607) por paciente em 2023, sendo o trabalho o maior componente (53%). Esforços para otimizar e automatizar fluxos de trabalho, e o uso de amostras menos invasivas, como células mononucleares do sangue periférico (PBMCs) em vez de fibroblastos, são estratégias-chave para reduzir ainda mais os custos e permitir uma adoção mais ampla na prática clínica de rotina.6

A proteômica está sendo cada vez mais integrada a outros dados "ômicos", como o sequenciamento de RNA, para aumentar o rendimento diagnóstico. Essa abordagem multi-ômica provou ser valiosa na identificação de causas subjacentes de doenças, especialmente em casos onde o sequenciamento inicial do genoma ou do exoma é inconclusivo, fornecendo informações funcionais sobre a expressão gênica e a função proteica.6 A proteômica quantitativa está em rápida transição de uma técnica de pesquisa especializada para uma ferramenta diagnóstica clinicamente viável e econômica. Isso é impulsionado por sua capacidade de fornecer informações funcionais diretas sobre a expressão e modificação de proteínas, que muitas vezes são perdidas apenas pelas análises genômicas. A crescente integração com outros fluxos de dados ômicos reflete um reconhecimento crescente da necessidade de uma compreensão holística e em nível de sistema no diagnóstico de doenças e na descoberta biológica.

Novos algoritmos estão sendo desenvolvidos para a identificação e quantificação precisas de proteoformas usando espectrometria de massas em tandem top-down. Esse avanço permite uma análise mais abrangente das variações proteicas, o que é crítico para a compreensão da função e disfunção das proteínas.11 A análise de sequências de proteínas em larga escala continua a descobrir características distintivas e adaptações evolutivas em diversas espécies, como os perfis de aminoácidos de microrganismos halofílicos. Isso levou ao desenvolvimento de ferramentas preditivas como o "HaloPredictor", que pode inferir adaptações específicas à salinidade com base em sequências de proteínas.33

  

### 3.3. Desenvolvimento e Aplicações de Modelos de Linguagem de Proteínas (PLMs)
Modelos de Linguagem Grandes específicos para proteínas (Protein LLMs) estão na vanguarda de uma nova revolução na ciência das proteínas. Eles estão permitindo uma previsão mais eficiente e precisa de estruturas proteicas, anotação abrangente de funções e design sofisticado de proteínas de novo.2

Traçando paralelos entre sequências de proteínas e dados textuais, os Protein LLMs utilizam técnicas avançadas de processamento de linguagem natural (NLP), como métodos de word embedding, para capturar e codificar diversos padrões biológicos em vetores estatísticos. Isso permite uma ampla gama de tarefas de análise de sequências de proteínas, desde a identificação de modificações pós-traducionais até a previsão de interações proteicas.2

Modelos como o ESM3 estão possibilitando o "design programável de proteínas".36 O ProtGPS, um modelo de IA, pode prever com precisão a localização de proteínas dentro de uma célula e até mesmo antecipar como mutações associadas a doenças podem alterar essa localização. Crucialmente, o ProtGPS também pode gerar sequências de aminoácidos inteiramente novas, projetadas para se localizar em compartimentos celulares específicos, abrindo novas vias para o desenvolvimento terapêutico direcionado.34

Um foco de pesquisa fundamental é o desenvolvimento de novos métodos de IA para integrar e modelar inteligentemente conjuntos de dados heterogêneos relacionados a proteínas. O objetivo final é avançar nossa compreensão das intrincadas conexões mecânicas entre a sequência de uma proteína, sua estrutura tridimensional e sua função biológica. Isso inclui o desenvolvimento de modelos generativos para evolução dirigida auxiliada por IA e co-design de sequência-estrutura de proteínas.35 Os Modelos de Linguagem de Proteínas representam um salto conceitual profundo, tratando as proteínas como uma "linguagem biológica" que pode ser compreendida, prevista e gerada pela IA. Isso estende a revolução da IA para além da mera previsão de estruturas proteicas existentes, permitindo o design e a engenharia racionais de novas proteínas com funções desejadas. Essa capacidade tem o potencial de transformar fundamentalmente campos como a biologia sintética e o desenvolvimento terapêutico, passando da descoberta empírica para o design inteligente.

  

### 3.4. Implicações para a Descoberta de Fármacos e Engenharia de Proteínas
A convergência da análise de sequências de proteínas de ponta, a predição avançada de estruturas e algoritmos sofisticados de IA/AM está se traduzindo diretamente em uma mudança de paradigma nas indústrias farmacêutica e biotecnológica. Essa transição move a descoberta de fármacos de um processo amplamente empírico, de tentativa e erro, para uma abordagem mais racional, orientada pelo design e significativamente acelerada, prometendo custos reduzidos e prazos de desenvolvimento mais rápidos para novas terapias.

Os avanços na análise de sequências de proteínas impulsionada por IA e na predição de estruturas, particularmente com AlphaFold2 e AlphaFold3, estão acelerando significativamente os pipelines de descoberta de fármacos. Essas ferramentas fornecem modelos de proteínas rápidos e de alta precisão para validação de alvos e facilitam o design de fármacos baseado em estrutura, permitindo que algoritmos analisem vastos conjuntos de dados moleculares e prevejam compostos eficazes contra doenças específicas.14

A capacidade da IA de analisar dados genéticos individuais e prever interações complexas entre fármacos e genes é um pilar para o desenvolvimento de terapias altamente personalizadas. Essa abordagem de medicina personalizada otimiza os tratamentos com base na composição genética única de um paciente, potencialmente minimizando os efeitos colaterais e aprimorando os resultados terapêuticos.1

Ferramentas impulsionadas por IA são instrumentais para superar o gargalo histórico da obtenção de estruturas proteicas determinadas experimentalmente. Ao fornecer previsões in silico altamente precisas, elas oferecem novas perspectivas e plataformas eficazes para o design racional de fármacos e vacinas, mesmo para proteínas que são difíceis de cristalizar.24

A capacidade dos modelos de IA (por exemplo, ProtGPS, ESM3) de projetar e gerar novas proteínas com propriedades funcionais específicas, como localização celular precisa, abre avenidas sem precedentes para o desenvolvimento de terapêuticas de próxima geração. Isso permite a criação de fármacos ou agentes biológicos projetados para interagir com alvos em compartimentos celulares específicos.34 Métodos de aprendizado profundo, como o DDGemb, podem prever com precisão as alterações de estabilidade proteica resultantes de variações de um ou múltiplos pontos, o que é crucial para a engenharia de proteínas. Além disso, modelos como o SP-DTI preveem interações fármaco-alvo analisando subbolsas de proteínas, aumentando a precisão do rastreamento virtual.11

  

## 4. Evolução e Novas Perspectivas em Bancos de Sequências Biológicas (2021-2025)
### 4.1. Panorama e Atualizações dos Principais Bancos de Dados de Ácidos Nucleicos e Proteínas

  

A edição anual do Nucleic Acids Research (NAR) Database Issue serve como o compêndio autoritário para bancos de dados biológicos novos e atualizados, fornecendo uma visão abrangente da rápida evolução do campo. O crescimento consistente e substancial, tanto em número quanto em especialização, dos bancos de dados biológicos, conforme meticulosamente documentado pelas edições do NAR Database Issue, salienta um ecossistema dinâmico e responsivo que se adapta à crescente granularidade e complexidade dos dados biológicos. Uma tendência crucial é a integração contínua de informações estruturais preditas por IA (por exemplo, modelos do AlphaFoldDB) em bancos de dados de proteínas estabelecidos e derivados experimentalmente (por exemplo, RCSB PDB, UniProt, Pfam). Essa integração significa uma mudança profunda na forma como o conhecimento biológico é curado, disseminado e validado, borrando as linhas tradicionais entre dados in silico e in vitro e acelerando o ritmo da descoberta.

- NAR Database Issue 2022 29:  
    Esta edição apresentou 185 artigos, incluindo 87 novos bancos de dados e 85 atualizações. Uma notável novidade foi o Banco de Dados de Estruturas Proteicas AlphaFold, juntamente com o Human Proteoform Atlas e o GproteinDb. Grandes bancos de dados de ácidos nucleicos como MODOMICS, JASPAR e miRTarBase relataram atualizações significativas, assim como recursos genômicos como Ensembl e UCSC Genome Browser.
    
- NAR Database Issue 2023 38:  
    Composto por 178 artigos (90 novos, 82 atualizações), esta edição introduziu novos bancos de dados de ácidos nucleicos como NACCDDB (para dados de dicroísmo circular de ácidos nucleicos), G4Atlas, QUADRAtlas e GAIA (todos focados em G-quadruplexes), e bancos de dados especializados em modificações de RNA, como tModBase, RM2Target e DirectRMDB. Para proteínas, surgiram novos recursos como TmAlphaFold (para previsões de incorporação em membranas) e HProteome-BSite (para sítios de ligação previstos), complementando atualizações de bancos de dados estabelecidos, incluindo RCSB PDB, GPCRdb, MobiDB, InterPro e UniProt.
    
- NAR Database Issue 2024 30:  
    Esta edição apresentou 180 artigos (90 novos, 83 atualizações). Um importante novo repositório de ácidos nucleicos, NAKB (Nucleic Acid Knowledgebase), foi introduzido para informações estruturais. Atualizações foram relatadas de recursos fundamentais como GenBank, ENA, GEO, Tarbase e JASPAR. O artigo de destaque ressaltou o NMPFamsDB, um banco de dados para novas famílias de proteínas procarióticas. Crucialmente, o Banco de Dados de Estruturas Proteicas AlphaFold também forneceu uma atualização importante, refletindo sua contínua expansão e refinamento. Recursos relacionados à genômica como Ensembl, UCSC Genome Browser e Monarch também publicaram atualizações.
    
- NAR Database Issue 2025 41:  
    A edição mais recente incluiu 185 artigos (73 novos, 101 atualizações). Seu artigo de destaque, EXPRESSO, focou na multi-ômica da estrutura genômica 3D. Novos bancos de dados de proteínas incluíram ASpdb (estruturas de isoformas de proteínas humanas derivadas de previsões AF2) e BFVD (estruturas de proteínas virais também de AF2). Atualizações contínuas foram fornecidas por UniProt, Pfam, InterPro, STRING, KEGG, CAZy, ClinVar, PubChem, DrugMAP, Ensembl, UCSC Genome Browser e dbSNP.
    

O blog EBI JDispatcher (maio de 2025) fornece um panorama do cenário dinâmico dos bancos de dados biológicos, indicando atualizações frequentes para os principais recursos, como AFDB, ChEMBL, ENA, Ens, PDB, UniProtKB, InterPro e Pfam, muitos dos quais receberam atualizações em 2025.43 Repositórios de sequências fundamentais como GenBank e EMBL continuam sendo essenciais, fornecendo acesso público a vastas quantidades de dados de sequências e ferramentas de consulta.44

  

### 4.2. Bancos de Dados Específicos e Integrados (Multi-Ômicos, Single-Cell)
A proliferação de bancos de dados altamente especializados e integrados reflete uma mudança crítica na investigação biológica em direção a uma granularidade e compreensão contextual cada vez maiores. A mudança para ômicas de célula única e espacial, em particular, exige novos paradigmas de banco de dados que possam gerenciar não apenas informações de sequência, mas também seu contexto preciso dentro de células individuais, tecidos e arranjos espaciais. Isso destaca uma progressão de dados em massa, média, para uma compreensão biológica de alta resolução e específica do contexto.

A rápida proliferação de tecnologias de ômicas de célula única (por exemplo, RNA-seq de célula única, proteômica de célula única) gerou conjuntos de dados massivos e altamente heterogêneos. Isso exigiu o desenvolvimento de estruturas robustas e bancos de dados especializados para integração e anotação de dados.7 A Ontologia Celular (CL) emergiu como um recurso fundamental para alcançar os princípios de dados FAIR (Findable, Accessible, Interoperable, and Reusable) neste domínio, fornecendo termos padronizados e agnósticos à espécie para tipos de células canônicos e facilitando a integração de dados entre espécies.7

Novas arquiteturas de banco de dados estão sendo desenvolvidas para lidar com a complexidade de dados biológicos multi-modais e espaciais. Exemplos da NAR DI de 2025 incluem o EXPRESSO, um banco de dados multi-ômico para explorar a organização genômica 3D humana em múltiplas camadas, integrando epigenômica e transcriptômica.41 Outros novos recursos focam em ômicas de célula única multi-modais pareadas (scMMO-atlas), células imunes (scImmOmics), genomas de célula única (HSCGD) e várias análises de transcriptômica espacial (SpatialRef, SPathDB, stSNV, Pairpot).41

O cenário dos bancos de dados está se diversificando para cobrir aspectos altamente específicos da biologia de proteínas e doenças. Novos bancos de dados de proteínas incluem ASpdb (estruturas de isoformas de proteínas humanas derivadas de previsões AF2) e BFVD (previsões AF2 de estruturas de proteínas virais).41 Outros focam em aminoácidos não canônicos (iNClusive) e proteínas multifuncionais (MultifacetedProtDB).40 Bancos de dados específicos para doenças como CVD Atlas (doenças cardiovasculares) e SV4GD (variações estruturais do genoma em doenças genéticas) compilam informações multi-ômicas com visualizações interativas.41

Novos recursos como MicrobiomeNet e GutMetaNet focam em associações microbianas e transferência horizontal de genes dentro do microbioma intestinal humano. Bancos de dados como COCONUT e Natural Products Magnetic Resonance Database (NP-MRD) estão se expandindo para cobrir produtos naturais e sua caracterização.41

  

## 5. Conclusões

  

O período de 2021 a 2025 representa um marco na análise de sequências de DNA e proteínas e na evolução dos bancos de dados biológicos, impulsionado pela convergência de avanços tecnológicos e metodologias computacionais sofisticadas, especialmente a Inteligência Artificial e o Aprendizado de Máquina. A capacidade de gerar, analisar e interpretar vastos e complexos conjuntos de dados biológicos atingiu níveis sem precedentes, transformando a pesquisa e a aplicação clínica.

Na análise de DNA, a integração de tecnologias de sequenciamento de leitura curta e longa, juntamente com a resolução de molécula única, permitiu uma caracterização genômica mais completa e precisa, essencial para o diagnóstico molecular e a vigilância de patógenos. A IA não apenas acelerou a interpretação desses dados, mas também revelou funções anteriormente desconhecidas do DNA não codificante e a importância da estrutura genômica tridimensional. Essa evolução indica que o campo passou de uma fase de mera aquisição de dados para uma de profunda compreensão funcional e preditiva.

No domínio das proteínas, o AlphaFold e seus sucessores redefiniram a predição de estruturas, tornando a determinação estrutural de alta precisão acessível em larga escala. Além disso, os Modelos de Linguagem de Proteínas estão inaugurando uma era de design racional de proteínas, permitindo a engenharia de novas moléculas com funções específicas. Essa capacidade de design é um avanço fundamental, movendo a ciência das proteínas de uma disciplina descritiva para uma construtiva, com implicações diretas na descoberta e desenvolvimento de fármacos. A proteômica quantitativa, por sua vez, está se consolidando como uma ferramenta diagnóstica clinicamente viável, oferecendo insights funcionais cruciais que complementam e, em alguns casos, superam as análises genômicas.

Os bancos de dados biológicos espelham essa evolução, crescendo exponencialmente em volume e especialização. A integração de dados multi-ômicos e de célula única, juntamente com a incorporação de estruturas preditas por IA, está criando repositórios de conhecimento mais ricos e interconectados. Essa infraestrutura de dados é vital para a disseminação do conhecimento e para a facilitação de novas descobertas.

Em suma, a análise de sequências de DNA e proteínas, juntamente com seus bancos de dados associados, está no cerne de uma revolução biotecnológica. As capacidades aprimoradas de predição e design, impulsionadas pela IA, estão acelerando a medicina personalizada, a descoberta de novos medicamentos e a capacidade de resposta a desafios globais de saúde, como a resistência antimicrobiana e as pandemias. O futuro promete uma integração ainda mais profunda dessas tecnologias, levando a uma compreensão mais abrangente da biologia e a soluções inovadoras para as maiores questões da saúde humana.

#### Referências citadas

1. 2025 DNA Day Essay Contest: Full Essays - ASHG, acessado em junho 22, 2025, [https://www.ashg.org/discover-genetics/k-12-education/dna-day/2025-dna-day-essay-contest-full-essays/](https://www.ashg.org/discover-genetics/k-12-education/dna-day/2025-dna-day-essay-contest-full-essays/)
    
2. Protein Sequence Analysis landscape: A Systematic Review of Task Types, Databases, Datasets, Word Embeddings Methods, and Language Models - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12125710/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12125710/)
    
3. ARS National Program 108 Food Safety 2021-2025 Retrospective Review Accomplishment Report - USDA ARS, acessado em junho 22, 2025, [https://www.ars.usda.gov/ARSUserFiles/np108/Retrospective%20Review%20(accomplishment%20reports)/108%20Retrospective%20Review%202024%20-%20Final%20For%20Web%2011202024.pdf](https://www.ars.usda.gov/ARSUserFiles/np108/Retrospective%20Review%20\(accomplishment%20reports\)/108%20Retrospective%20Review%202024%20-%20Final%20For%20Web%2011202024.pdf)
    
4. DNA storage: The future direction for medical cold data storage - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11999466/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11999466/)
    
5. NIH-Wide Strategic Plan, Fiscal Years 2021-2025, acessado em junho 22, 2025, [https://www.nih.gov/sites/default/files/2025-01/strategic-plan-fy2021-2025.pdf](https://www.nih.gov/sites/default/files/2025-01/strategic-plan-fy2021-2025.pdf)
    
6. (PDF) A micro-costing study of mass-spectrometry based quantitative proteomics testing applied to the diagnostic pipeline of mitochondrial and other rare disorders - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/386247752_A_micro-costing_study_of_mass-spectrometry_based_quantitative_proteomics_testing_applied_to_the_diagnostic_pipeline_of_mitochondrial_and_other_rare_disorders](https://www.researchgate.net/publication/386247752_A_micro-costing_study_of_mass-spectrometry_based_quantitative_proteomics_testing_applied_to_the_diagnostic_pipeline_of_mitochondrial_and_other_rare_disorders)
    
7. The Cell Ontology in the age of single-cell omics - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/392629047_The_Cell_Ontology_in_the_age_of_single-cell_omics](https://www.researchgate.net/publication/392629047_The_Cell_Ontology_in_the_age_of_single-cell_omics)
    
8. Plasmid Composition, Antimicrobial Resistance and Virulence Genes Profiles of Ciprofloxacin- and Third-Generation Cephalosporin-Resistant Foodborne Salmonella enterica Isolates from Russia - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2076-2607/11/2/347](https://www.mdpi.com/2076-2607/11/2/347)
    
9. Spatiotemporal and genomic analysis of carbapenem resistance elements in Enterobacterales from hospital inpatients and natural water ecosystems of an Irish city | Microbiology Spectrum - ASM Journals, acessado em junho 22, 2025, [https://journals.asm.org/doi/10.1128/spectrum.00904-24](https://journals.asm.org/doi/10.1128/spectrum.00904-24)
    
10. A Genomic Surveillance Circuit for Emerging Viral Pathogens - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12029405/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12029405/)
    
11. Top 39 Bioinformatics papers published in 2025 - SciSpace, acessado em junho 22, 2025, [https://scispace.com/journals/bioinformatics-1awxxbj3/2025](https://scispace.com/journals/bioinformatics-1awxxbj3/2025)
    
12. Panel 2 Biotechnology - KTH, acessado em junho 22, 2025, [https://www.kth.se/social/files/60ab646425308ed34e766535/final-panel-2-report-rae2021.pdf](https://www.kth.se/social/files/60ab646425308ed34e766535/final-panel-2-report-rae2021.pdf)
    
13. US7666593B2 - Single molecule sequencing of captured nucleic acids - Google Patents, acessado em junho 22, 2025, [https://patents.google.com/patent/US7666593B2/en](https://patents.google.com/patent/US7666593B2/en)
    
14. LPBI Newsletters, acessado em junho 22, 2025, [https://pharmaceuticalintelligence.com/newsletter/](https://pharmaceuticalintelligence.com/newsletter/)
    
15. Adee | PDF | Personalized Medicine | Artificial Intelligence - Scribd, acessado em junho 22, 2025, [https://www.scribd.com/document/814765674/Adee](https://www.scribd.com/document/814765674/Adee)
    
16. Contents To Our Readers - Scientific, technical publications in the nuclear field | IAEA, acessado em junho 22, 2025, [https://www-pub.iaea.org/MTCD/Publications/PDF/p15892-aph-nl-81.pdf](https://www-pub.iaea.org/MTCD/Publications/PDF/p15892-aph-nl-81.pdf)
    
17. How many mammal species are there now? Updates and trends in taxonomic, nomenclatural, and geographic knowledge - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.02.27.640393v1.full.pdf](https://www.biorxiv.org/content/10.1101/2025.02.27.640393v1.full.pdf)
    
18. Pathogenic potential prediction of Vibrio parahaemolyticus by using pangenome data with high performance machine learning algorithms | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.04.08.647818v1.full](https://www.biorxiv.org/content/10.1101/2025.04.08.647818v1.full)
    
19. Pathogenic potential prediction of Vibrio parahaemolyticus by using pangenome data with high performance machine learning algori - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.04.08.647818v1.full.pdf](https://www.biorxiv.org/content/10.1101/2025.04.08.647818v1.full.pdf)
    
20. (PDF) TENET: Triple-Enhancement based Graph Neural Network for Cell-cell Interaction Network Reconstruction from Spatial Transcriptomics - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/379063311_TENET_Triple-Enhancement_based_Graph_Neural_Network_for_Cell-cell_Interaction_Network_Reconstruction_from_Spatial_Transcriptomics](https://www.researchgate.net/publication/379063311_TENET_Triple-Enhancement_based_Graph_Neural_Network_for_Cell-cell_Interaction_Network_Reconstruction_from_Spatial_Transcriptomics)
    
21. New technique expands cells to sequence DNA and capture fine structural details, acessado em junho 22, 2025, [https://www.broadinstitute.org/news/new-technique-expands-cells-sequence-dna-and-capture-fine-structural-details](https://www.broadinstitute.org/news/new-technique-expands-cells-sequence-dna-and-capture-fine-structural-details)
    
22. A unified-field theory of genome organization and gene regulation - University of Oxford, acessado em junho 22, 2025, [http://users.path.ox.ac.uk/~pcook/pdf/2021-2025/UnifiedTheory.pdf](http://users.path.ox.ac.uk/~pcook/pdf/2021-2025/UnifiedTheory.pdf)
    
23. Identification and Evolutionary Relationship of Corynebacterium striatum Clinical Isolates, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9501166/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9501166/)
    
24. Recent Advances and Challenges in Protein Structure Prediction - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/376632843_Recent_Advances_and_Challenges_in_Protein_Structure_Prediction](https://www.researchgate.net/publication/376632843_Recent_Advances_and_Challenges_in_Protein_Structure_Prediction)
    
25. AlphaFold two years on: Validation and impact - PNAS, acessado em junho 22, 2025, [https://www.pnas.org/doi/10.1073/pnas.2315002121](https://www.pnas.org/doi/10.1073/pnas.2315002121)
    
26. Full article: AlphaFold and what is next: bridging functional, systems and structural biology, acessado em junho 22, 2025, [https://www.tandfonline.com/doi/full/10.1080/14789450.2025.2456046?src=](https://www.tandfonline.com/doi/full/10.1080/14789450.2025.2456046?src)
    
27. (PDF) Protein Large Language Models: A Comprehensive Survey - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/389351444_Protein_Large_Language_Models_A_Comprehensive_Survey](https://www.researchgate.net/publication/389351444_Protein_Large_Language_Models_A_Comprehensive_Survey)
    
28. Structural biology of cell surface receptors implicated in Alzheimer's disease - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC8921391/](https://pmc.ncbi.nlm.nih.gov/articles/PMC8921391/)
    
29. The 2022 Nucleic Acids Research database issue and the online ..., acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/34986604/](https://pubmed.ncbi.nlm.nih.gov/34986604/)
    
30. The 2024 Nucleic Acids Research database issue and the online molecular biology database collection - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10767945/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10767945/)
    
31. Scrutinization on Docking Against Individually Generated Target Pockets for Each Ligand - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.01.01.630989v2.full.pdf](https://www.biorxiv.org/content/10.1101/2025.01.01.630989v2.full.pdf)
    
32. A micro-costing study of mass-spectrometry based quantitative proteomics testing applied to the diagnostic pipeline of mitochondrial and other rare disorders, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11605922/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11605922/)
    
33. PhD dissertation Comparative genomic analysis of halophilic organisms, acessado em junho 22, 2025, [https://www.vliz.be/imisdocs/publications/406979.pdf](https://www.vliz.be/imisdocs/publications/406979.pdf)
    
34. AI model deciphers the code in proteins that tells them where to go | MIT News, acessado em junho 22, 2025, [https://news.mit.edu/2025/ai-model-deciphers-code-proteins-tells-them-where-to-go-0213](https://news.mit.edu/2025/ai-model-deciphers-code-proteins-tells-them-where-to-go-0213)
    
35. Integrative deep learning algorithms for understanding protein sequence-structure-function relationships: representation, prediction, and discovery - NIH RePORTER, acessado em junho 22, 2025, [https://reporter.nih.gov/project-details/10919777](https://reporter.nih.gov/project-details/10919777)
    
36. PROTEIN DESIGN, acessado em junho 22, 2025, [https://psv4.userapi.com/s/v1/d/5I4vUvZEmbj0ycJgNVvoKDyRM6LCSpCLS4UIAqLS5lofP1yObhUGvM9_fk1nhKlvjd0AGrrnvmUnXvJ5uFCqpVZupX3UahrCzTJ0F1wNS45TSDQx/Science_-_Issue_6736_Volume_387_21_February_2025.pdf](https://psv4.userapi.com/s/v1/d/5I4vUvZEmbj0ycJgNVvoKDyRM6LCSpCLS4UIAqLS5lofP1yObhUGvM9_fk1nhKlvjd0AGrrnvmUnXvJ5uFCqpVZupX3UahrCzTJ0F1wNS45TSDQx/Science_-_Issue_6736_Volume_387_21_February_2025.pdf)
    
37. The 2022 Nucleic Acids Research database issue and the online molecular biology database collection - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC8728296/](https://pmc.ncbi.nlm.nih.gov/articles/PMC8728296/)
    
38. The 2023 Nucleic Acids Research Database Issue and the online ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9825711/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9825711/)
    
39. 2023 Nucleic Acids Research Database Issue and the online molecular biology database collection - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/nar/article/51/D1/D1/6964796](https://academic.oup.com/nar/article/51/D1/D1/6964796)
    
40. 2024 Nucleic Acids Research database issue and the online ..., acessado em junho 22, 2025, [https://academic.oup.com/nar/article-abstract/52/D1/D1/7456037](https://academic.oup.com/nar/article-abstract/52/D1/D1/7456037)
    
41. 2025 Nucleic Acids Research database issue and the online ..., acessado em junho 22, 2025, [https://academic.oup.com/nar/article/53/D1/D1/7919991](https://academic.oup.com/nar/article/53/D1/D1/7919991)
    
42. 2025 Nucleic Acids Research database issue and the online molecular biology database collection - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/nar/advance-article-abstract/doi/10.1093/nar/gkae1220/7919991](https://academic.oup.com/nar/advance-article-abstract/doi/10.1093/nar/gkae1220/7919991)
    
43. Dataset updates for May 2025 - EMBL-EBI, acessado em junho 22, 2025, [https://www.ebi.ac.uk/jdispatcher/blog/2025-05-31-may-updates](https://www.ebi.ac.uk/jdispatcher/blog/2025-05-31-may-updates)
    
44. The Princeton Protein Orthology Database (P-POD): A Comparative Genomics Analysis Tool for Biologists | PLOS One, acessado em junho 22, 2025, [https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0000766](https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0000766)
    

**