# A Arquitetura Dinâmica da Expressão Gênica: De Paisagens de Cromatina ao Controle Epitranscriptômico

## Introdução: O Controle em Múltiplas Camadas da Expressão Gênica

  

O dogma central da biologia molecular, que descreve o fluxo de informação do DNA para o RNA e para a proteína, fornece um arcabouço fundamental para a compreensão da vida. No entanto, a visão moderna revela que a expressão gênica está longe de ser um processo linear e simples. É, na verdade, uma rede de controle extraordinariamente complexa e finamente ajustada, operando em múltiplas camadas que garantem que os genes certos sejam expressos no momento certo, no local certo e na quantidade certa. Essa regulação precisa é a base da identidade celular, do desenvolvimento de organismos multicelulares e da homeostase dos tecidos, enquanto sua desregulação está no cerne de uma vasta gama de doenças humanas, incluindo o câncer e distúrbios do desenvolvimento.1

A regulação da expressão gênica começa no nível mais fundamental da própria molécula de DNA — sua acessibilidade. A organização do DNA em uma estrutura compacta chamada cromatina não é apenas uma solução de empacotamento, mas um mecanismo regulatório ativo. A paisagem epigenética, composta por modificações químicas no DNA e nas proteínas histonas associadas, dita quais regiões do genoma estão "abertas" ou "fechadas" para a maquinaria transcricional. Este relatório explorará as principais facetas dessa regulação, começando pela arquitetura tridimensional (3D) do genoma. Serão discutidos os avanços recentes na compreensão de como o dobramento do genoma em compartimentos, domínios topologicamente associados (TADs) e alças de cromatina de longo alcance orquestra a comunicação entre elementos regulatórios distantes, como intensificadores (enhancers) e promotores. Um conceito emergente e central nesta discussão é o papel da separação de fases líquido-líquido na formação de condensados transcricionais, que funcionam como centros de atividade para amplificar a expressão gênica.

Além da arquitetura canônica da cromatina, o genoma pode adotar estruturas de ácido nucleico não canônicas, como G-quadruplexes (G4s) e R-loops, que emergiram como elementos regulatórios ativos. Este relatório detalhará como essas estruturas dinâmicas se formam co-transcricionalmente e exercem papéis duplos, atuando tanto como bloqueios físicos quanto como plataformas de recrutamento para fatores regulatórios. Será dada atenção especial às descobertas recentes que ligam a acumulação patológica dessas estruturas à instabilidade genômica e à ativação de respostas imunes inatas, revelando uma conexão intrínseca entre a manutenção do genoma e a vigilância imunológica.

Após a transcrição, a regulação continua em um nível que agora é conhecido como "epitranscriptômica". Modificações químicas na própria molécula de RNA, como a N6-metiladenosina (m6A), adicionam uma camada adicional de informação que governa o destino do RNA, incluindo seu processamento, estabilidade, exportação e tradução. A par com as modificações naturais, avanços notáveis na biologia sintética permitiram o desenvolvimento de ferramentas para editar o RNA de forma programável, abrindo novas fronteiras para a pesquisa e a terapêutica.

Finalmente, o controle da expressão gênica culmina na tradução, o processo de síntese de proteínas. Tecnologias como o perfilamento de ribossomos (Ribosome Profiling) revelaram que a eficiência da tradução é uma camada de regulação generalizada e dinâmica, muitas vezes desacoplada dos níveis de RNA mensageiro (mRNA). Este relatório abordará como o controle translacional é utilizado para esculpir o proteoma durante o desenvolvimento e em resposta a estímulos, e como interruptores sintéticos de RNA podem ser projetados para controlar este processo final.

Para navegar neste campo complexo, os pesquisadores desenvolveram um arsenal de metodologias de alto rendimento. A Tabela 1 fornece uma referência essencial para as principais técnicas discutidas ao longo deste relatório, delineando seus princípios, alvos primários e aplicações na elucidação dos mecanismos de regulação gênica.

Tabela 1: Metodologias de Alto Rendimento na Pesquisa de Regulação Gênica.

|   |   |   |   |
|---|---|---|---|
|Técnica|Princípio|Alvo Primário e Aplicação|Fontes|
|Hi-C e derivados (HiChIP, TAC-C)|Ligação por proximidade de segmentos de cromatina, seguida de sequenciamento de alto rendimento para mapear interações genômicas em escala global.|Mapeamento da organização 3D do genoma, incluindo compartimentos A/B, Domínios Topologicamente Associados (TADs) e alças de cromatina (ex: enhancer-promotor).|3|
|G4-seq|Sequenciamento que explora a parada da DNA polimerase em estruturas G-quadruplex sob condições estabilizadoras (ex: íons K+).|Mapeamento em escala genômica de sequências com potencial para formar estruturas G-quadruplex in vitro.|7|
|DRIP-seq (Imunoprecipitação de DNA-RNA)|Utiliza um anticorpo específico (S9.6) que reconhece híbridos de RNA:DNA, seguido de sequenciamento para mapear suas localizações genômicas.|Mapeamento em escala genômica de R-loops, estruturas de três fitas formadas durante a transcrição.|11|
|Perfilamento de Ribossomos (Ribo-seq)|Sequenciamento de fragmentos de mRNA protegidos por ribossomos para obter um instantâneo de todos os transcritos sendo ativamente traduzidos.|Medição do "translatoma", quantificando a eficiência translacional (TE) e identificando novas fases de leitura abertas (ORFs) traduzidas.|13|

  

## Seção 1: O Projeto Arquitetônico: Cromatina e o Genoma 3D

  

A regulação da expressão gênica em eucariotos é fundamentalmente ditada pela forma como o genoma é organizado dentro do núcleo. Longe de ser um repositório passivo de informação, o genoma é uma estrutura dinâmica e tridimensional, cuja arquitetura em múltiplas escalas — desde a modificação de nucleossomos individuais até o dobramento de cromossomos inteiros — governa a acessibilidade do DNA e orquestra interações regulatórias complexas. Esta seção explora as camadas hierárquicas da organização da cromatina, desde a tela epigenética das modificações de histonas até a formação de domínios e condensados transcricionais, que coletivamente formam o projeto arquitetônico para o controle da expressão gênica.

  

### 1.1. A Tela Epigenética: Modificações de Histonas e sua Intercomunicação Regulatória

  

A unidade fundamental da cromatina, o nucleossomo, consiste em aproximadamente 147 pares de bases de DNA enrolados em um octâmero de proteínas histonas. As caudas N-terminais dessas histonas se projetam do núcleo do nucleossomo e são suscetíveis a uma vasta gama de modificações pós-traducionais (PTMs), incluindo acetilação, metilação, fosforilação e ubiquitinação.16 Essas modificações funcionam como um código complexo — muitas vezes chamado de "código de histonas" — que é "lido" por outras proteínas para modular a estrutura da cromatina e a atividade transcricional.18

A acetilação de resíduos de lisina, catalisada por histona acetiltransferases (HATs), neutraliza a carga positiva da lisina, enfraquecendo sua interação com o esqueleto de fosfato do DNA, o que geralmente resulta em uma estrutura de cromatina mais "aberta" ou relaxada (eucromatina), facilitando o acesso de fatores de transcrição e da RNA polimerase.18 Por outro lado, a remoção de grupos acetil por histona deacetilases (HDACs) restaura a carga positiva, promovendo uma cromatina mais compacta e repressão transcricional.

A metilação de histonas, catalisada por histona metiltransferases (HMTs), é mais complexa. O efeito regulatório depende do resíduo específico que é metilado (por exemplo, lisina ou arginina) e do estado de metilação (mono-, di- ou trimetilação). Por exemplo, a trimetilação da lisina 4 na histona H3 (H3K4me3) está fortemente associada a promotores de genes ativos, enquanto a trimetilação da lisina 9 (H3K9me3) e da lisina 27 (H3K27me3) são marcas canônicas de heterocromatina silenciosa e compactada.18

Crucialmente, essas modificações não atuam isoladamente, mas se envolvem em uma complexa "intercomunicação" (crosstalk). Uma modificação pode influenciar a deposição ou remoção de outra, criando uma rede regulatória robusta. Por exemplo, a acetilação de histonas pode criar um ambiente que favorece a ação de complexos remodeladores de cromatina, que por sua vez expõem sítios para outras modificações ativadoras. Essa intercomunicação é essencial para a plasticidade celular, permitindo que as células integrem múltiplos sinais e ajustem seus programas de expressão gênica de acordo. Um exemplo notável é a polarização de macrófagos, onde o estado metabólico da célula influencia a disponibilidade de cofatores (como acetil-CoA e S-adenosilmetionina) para HATs e HMTs, ligando diretamente o metabolismo celular à paisagem epigenética e ao destino funcional da célula.18 A desregulação das enzimas que "escrevem", "apagam" e "leem" essas marcas está frequentemente implicada em doenças, tornando-as alvos terapêuticos promissores.20

  

### 1.2. O Genoma Dobrado: Compartimentos e Domínios Topologicamente Associados (TADs)

  

Acima do nível do nucleossomo, a fibra de cromatina se dobra em uma arquitetura 3D complexa e hierárquica. Técnicas de captura de conformação de cromossomos, como o Hi-C, revelaram que os cromossomos não estão aleatoriamente dispostos no núcleo, mas ocupam territórios distintos e são organizados em múltiplos níveis de dobramento.4

Na escala de megabases, o genoma é segregado em dois grandes compartimentos espaciais: o compartimento 'A' e o compartimento 'B'. O compartimento A é geralmente associado à eucromatina, caracterizado por alta densidade gênica, replicação precoce e marcas de histonas ativas, como H3K4me3 e acetilação de histonas. Consequentemente, as regiões no compartimento A são transcricionalmente ativas. Em contraste, o compartimento B corresponde à heterocromatina, que é pobre em genes, replica-se tardiamente e é enriquecida em marcas repressivas como H3K9me3 e H3K27me3, sendo em grande parte transcricionalmente silenciosa.22 A compartimentalização é dinâmica e específica do tipo celular. A transição de regiões entre os compartimentos A e B é um mecanismo chave na regulação da expressão gênica durante o desenvolvimento e em resposta a estímulos. Por exemplo, em um estudo sobre fotomorfogênese induzida por luz em soja, observou-se que domínios que mudaram do compartimento B (no escuro) para o compartimento A (na luz) continham genes que foram ativados em resposta ao estímulo luminoso, demonstrando uma ligação direta entre a reorganização espacial do genoma e a ativação gênica.23

Dentro dos compartimentos, a cromatina é organizada em unidades estruturais e funcionais menores, chamadas Domínios Topologicamente Associados (TADs). Os TADs são regiões do genoma, tipicamente de centenas de quilobases a megabases de tamanho, que interagem preferencialmente consigo mesmas, mas são largamente isoladas de domínios vizinhos.4 As fronteiras dos TADs atuam como isolantes, restringindo as interações entre intensificadores e promotores, garantindo assim que os intensificadores ativem seus alvos corretos e não genes em TADs adjacentes.5 Em mamíferos, a formação e manutenção das fronteiras dos TADs são mediadas em grande parte pela proteína de ligação a CTCF e pelo complexo de coesina, que atuam através de um modelo de "extrusão de alça".3 A perturbação dos TADs ou de suas fronteiras pode levar a interações regulatórias anômalas e está associada a doenças do desenvolvimento e ao câncer.

  

### 1.3. Comunicação de Longo Alcance: Mecanismos de Especificidade Intensificador-Promotor

  

Uma das questões mais fundamentais na regulação gênica é como os intensificadores, elementos regulatórios de DNA que podem aumentar drasticamente a transcrição, se comunicam com seus promotores-alvo, que podem estar localizados a dezenas ou centenas de quilobases de distância.3 O modelo predominante sugere que essa comunicação de longo alcance é mediada pela formação de alças de cromatina físicas que aproximam espacialmente o intensificador e o promotor, facilitando a interação entre os fatores de transcrição ligados ao intensificador e a maquinaria de transcrição basal no promotor.27

A especificidade dessa interação é um processo notavelmente preciso e complexo. Embora a proximidade linear no genoma desempenhe um papel, não é o único determinante. Estudos recentes mostram que uma proporção significativa de intensificadores (mais de 60% em um estudo de desenvolvimento) "salta" genes vizinhos para regular alvos mais distantes, indicando a existência de regras de direcionamento sofisticadas.27 Essa especificidade parece ser determinada por uma combinação de fatores, incluindo a compatibilidade entre os fatores de transcrição ligados ao intensificador e os presentes no promotor, a força intrínseca do promotor, a presença de sequências isolantes e o contexto da arquitetura da cromatina local, como os TADs, que restringem o espaço de busca de um intensificador.3

A regulação da expressão gênica por intensificadores não é um simples interruptor "ligado/desligado", mas um processo dinâmico. A ativação de um intensificador, por exemplo, por um sinal celular, pode levar a um aumento na frequência de contato com seu promotor-alvo, o que se correlaciona com um aumento na expressão gênica. Por exemplo, a ativação do receptor de vitamina D leva a mudanças nas alças mediadas por CTCF, que por sua vez se correlacionam com mudanças na expressão dos genes-alvo da vitamina D, destacando a natureza dinâmica e funcional dessas interações 3D.5

  

### 1.4. Centros de Atividade: Condensados Transcricionais e Separação de Fases

  

Avanços recentes revelaram um princípio biofísico fundamental que sustenta a formação de centros de alta atividade transcricional: a separação de fases líquido-líquido (LLPS). A LLPS é o processo pelo qual biomoléculas, como proteínas e ácidos nucleicos, podem se desmisturar de seu ambiente circundante para formar condensados ou "gotículas" sem membrana, semelhantes a líquidos.30

No contexto da transcrição, descobriu-se que fatores de transcrição, coativadores e a RNA Polimerase II (Pol II), muitos dos quais contêm regiões intrinsecamente desordenadas (IDRs), podem se co-condensar em regiões genômicas específicas, como super-intensificadores, para formar condensados transcricionais.31 Esses condensados funcionam como "centros" ou "hubs" bioquímicos que concentram localmente os componentes necessários para a transcrição em altas concentrações, aumentando drasticamente a eficiência da iniciação e elongação da transcrição e, assim, amplificando a expressão gênica.31

A formação desses condensados não é um evento único, mas um processo em cascata e graduado. Estudos, como o trabalho seminal de Wei et al. (2020), sugerem um modelo de "condensados nucleados" onde o agrupamento inicial de fatores de transcrição em um intensificador "nucleia" a formação de um condensado maior, que então recruta eficientemente a Pol II e outros componentes da maquinaria transcricional.34 Esse modelo fornece uma explicação física para como os intensificadores podem exercer efeitos tão potentes sobre a expressão gênica e permite uma resposta transcricional graduada, em vez de um simples interruptor binário, em resposta a diferentes níveis de sinalização celular.36

É crucial notar que a relação entre a arquitetura da cromatina e a função transcricional é recíproca. A estrutura 3D do genoma não é um andaime estático sobre o qual a transcrição ocorre; em vez disso, a própria atividade transcricional e a formação de condensados podem remodelar ativamente a arquitetura da cromatina local.30 Por exemplo, a ativação transcricional em resposta à luz em soja está associada à condensação de TADs específicos, um processo mediado pela RNAPII.25 Isso sugere um ciclo de feedback dinâmico: a estrutura da cromatina existente pode predispor certas regiões à formação de condensados, e a formação desses condensados, impulsionada pela transcrição, pode então estabilizar ou reconfigurar ainda mais essa estrutura. Essa interdependência entre estrutura e função é fundamental para o estabelecimento e a manutenção de estados celulares estáveis durante o desenvolvimento e em resposta a mudanças ambientais.

  

## Seção 2: Além da Dupla Hélice: Os Papéis Regulatórios de Estruturas de Ácido Nucleico Não Canônicas

  

Enquanto a dupla hélice B-DNA é a forma predominante do material genético, o genoma é estruturalmente dinâmico e pode adotar uma variedade de conformações não canônicas. Essas estruturas, antes consideradas curiosidades de laboratório, são agora reconhecidas como elementos regulatórios funcionais que desempenham papéis críticos em processos biológicos fundamentais. Elas se formam transitoriamente em regiões genômicas específicas, muitas vezes em resposta à própria atividade transcricional, e atuam como interruptores moleculares, plataformas de reconhecimento e, por vezes, como fontes de instabilidade genômica. Esta seção explora duas das mais importantes estruturas não canônicas — G-quadruplexes e R-loops — e a maquinaria celular dedicada a sua regulação.

  

### 2.1. G-Quadruplexes (G4s): Reguladores Versáteis da Função Genômica

  

G-quadruplexes (G4s) são estruturas de quatro fitas formadas em sequências de DNA e RNA ricas em guanina. Sua unidade fundamental é a tétrade de guanina (G-quartet), um arranjo planar de quatro bases de guanina estabilizado por ligações de hidrogênio de Hoogsteen e coordenado por um cátion monovalente central, tipicamente K+.37 Pilhas de G-quartets formam a estrutura G4 helicoidal. Inicialmente identificados em telômeros, agora se sabe que os G4s estão distribuídos por todo o genoma, particularmente em regiões regulatórias como promotores e intensificadores, onde exercem uma influência profunda na expressão gênica.37

  

#### 2.1.1. Plasticidade Estrutural: De G4s Perfeitos a Imperfeitos

  

O modelo canônico de um G4 requer quatro tratos de guaninas contínuas. No entanto, análises bioinformáticas e validações experimentais recentes expandiram drasticamente o repertório de sequências formadoras de G4 ao demonstrar a existência e a funcionalidade de G4s imperfeitos ou com protuberância (buG4s). Essas estruturas contêm interrupções nos tratos de guanina por nucleotídeos que não são guanina (como A, C ou T), que formam "protuberâncias" (bulges) na estrutura.39

A estabilidade e a função dessas buG4s são criticamente influenciadas pela posição, tamanho e identidade da protuberância. Um estudo sistemático de Sarkar et al. demonstrou que as protuberâncias localizadas na extremidade 5' da sequência G4 têm o menor efeito desestabilizador, enquanto as protuberâncias nas posições centrais ou na extremidade 3' são mais prejudiciais à estabilidade.39 Além disso, o tipo de nucleotídeo na protuberância importa, com a adenina (A) sendo mais desestabilizadora do que a citosina (C) ou a timina (T), provavelmente devido ao seu maior tamanho estérico.39

Uma descoberta crucial é que o ambiente celular, que é altamente lotado com macromoléculas, estabiliza significativamente as estruturas G4, incluindo as buG4s. Experimentos que utilizam agentes de aglomeração molecular como o polietilenoglicol (PEG) para mimetizar as condições intracelulares mostram um aumento acentuado na estabilidade térmica das buG4s, tornando sua formação in vivo muito mais provável do que o previsto em soluções diluídas.39 A

Figura 2, adaptada de Sarkar et al., ilustra esses pontos, mostrando as curvas de fusão por UV que medem a estabilidade térmica (indicada pela temperatura de fusão, Tm​) de um G4 perfeito (pG4) e várias buG4s. Os painéis demonstram claramente como a presença de uma protuberância diminui a estabilidade em comparação com o pG4 e como a condição de aglomeração (presença de PEG) aumenta a estabilidade de todas as estruturas.

!([https://academic.oup.com/nar/article/53/5/gkaf164/8086779#396264879](https://academic.oup.com/nar/article/53/5/gkaf164/8086779#396264879))

Figura 2: Curvas de fusão UV e análise termodinâmica de buG4s contendo uma única protuberância. (A) Curvas de fusão UV de pG4 e buG4s em condições não aglomeradas (sem PEG 200). (B) Curvas de fusão UV de pG4 e buG4s em condições de aglomeração (com 10% de PEG 200). (C) Gráfico da mudança na energia livre de Gibbs (ΔΔG°protubera^ncia​) com diferentes posições de protuberância. As curvas de fusão demonstram que as protuberâncias desestabilizam a estrutura G4 (menor Tm​) em comparação com o G4 perfeito (pG4), mas o ambiente de aglomeração aumenta a estabilidade de todas as estruturas. Fonte: Sarkar et al., Nucleic Acids Research, 2025.39 DOI: 10.1093/nar/gkaf164. Artigo de Acesso Aberto.

  

#### 2.1.2. G4s como Bloqueios e Aceleradores Transcricionais

  

A localização estratégica dos G4s em regiões regulatórias sugere um papel direto na modulação da transcrição. De fato, os G4s podem ter uma função dupla. Por um lado, uma estrutura G4 estável pode atuar como um bloqueio físico, impedindo a progressão da RNA polimerase ao longo do molde de DNA, resultando na parada ou arresto da transcrição.40 A eficiência desse bloqueio está diretamente correlacionada com a estabilidade termodinâmica da estrutura G4. Sarkar et al. propuseram um modelo preditivo onde buG4s com uma energia livre de Gibbs de formação (

ΔG°37​) de ≤ -3.3 kcal·mol⁻¹ são capazes de arrestar eficientemente a transcrição, enquanto aquelas com estabilidade menor não o fazem.39

A Figura 4, também de Sarkar et al., demonstra esse efeito funcional usando um ensaio de transcrição in vitro. O molde de DNA foi projetado para que a parada da RNA polimerase T7 pela estrutura G4 produzisse um transcrito curto de 15 nucleotídeos (nt), enquanto a transcrição completa resultaria em um produto de 55 nt. O gel de eletroforese (Painel B) mostra claramente a banda de 15 nt (indicada por estrelas) para o pG4 e para as buG4s mais estáveis, confirmando o arresto transcricional. A quantificação (Painel C) mostra como a eficiência do arresto (TE_arrest) varia com a posição da protuberância, ligando a estrutura à função.

!([https://academic.oup.com/nar/article/53/5/gkaf164/8086779#396264883](https://academic.oup.com/nar/article/53/5/gkaf164/8086779#396264883))

Figura 4: Impacto da posição da protuberância na regulação transcricional induzida por buG4. (A) Esquema do molde de DNA usado no ensaio. (B) Gel de eletroforese desnaturante mostrando os produtos da transcrição. A presença de uma banda de 15 nt (arrestada) indica o bloqueio da transcrição pela estrutura G4. (C) Eficiência de arresto da transcrição (TE_arrest) quantificada para G4s com protuberâncias em diferentes posições. Fonte: Sarkar et al., Nucleic Acids Research, 2025.39 DOI: 10.1093/nar/gkaf164. Artigo de Acesso Aberto.

Por outro lado, e talvez de forma contraintuitiva, os G4s também estão associados à ativação transcricional. Em vez de atuarem como bloqueios, eles podem funcionar como plataformas de reconhecimento que recrutam fatores de transcrição específicos ou complexos remodeladores de cromatina, ou podem facilitar a manutenção de uma região de cromatina aberta, promovendo assim a transcrição.43 Esse papel duplo destaca a natureza dependente do contexto da função do G4.

  

#### 2.1.3. G4s Multimoleculares, Separação de Fases e Alças de Cromatina

  

A formação de G4s não se limita a uma única fita de ácido nucleico (intramolecular). Estruturas G4 multimoleculares (mG4s) podem se formar entre duas ou mais fitas, permitindo a ligação física de locais genômicos distantes.43 Essa capacidade tem implicações profundas para a arquitetura do genoma 3D.

Uma descoberta transformadora recente é que as mG4s podem induzir a separação de fases líquido-líquido (LLPS) de forma independente de proteínas.43 Sequências ricas em guanina, como as repetições hexanucleotídicas (GGGGCC)n associadas a doenças neurodegenerativas, podem formar redes de mG4s que se agregam e se separam da solução para formar condensados de ácido nucleico.43 A

Figura 3 de um artigo de revisão de Yatsunyk et al. ilustra vividamente esse fenômeno, mostrando como as sequências (GGGGCC)n formam agregados microscópicos visíveis que são positivos para a coloração específica de G4.

Figura 3: Agrupamento de G4s multimoleculares e formação de uma entidade de fase separada na repetição hexanucleotídica (GGGGCC)n. (a) Mecanismo proposto de agregação mediada por G4. (b) Géis de eletroforese mostrando a formação de espécies de mG4 de alto peso molecular. (d) Imagens de microscopia de campo claro mostrando gotículas líquidas macroscópicas formadas pela agregação de mG4s, demonstrando a LLPS impulsionada por ácido nucleico. Fonte: Yatsunyk et al., Accounts of Chemical Research, 2024.43 DOI: 10.1021/acs.accounts.4c00574. Artigo de Acesso Aberto.

Esse mecanismo fornece uma nova maneira de pensar sobre a regulação gênica de longo alcance. A formação de mG4s em intensificadores e super-intensificadores pode criar "hubs" de condensados de DNA que recrutam e concentram a maquinaria transcricional, ligando a estrutura G4 diretamente ao conceito de condensados transcricionais discutido na Seção 1.4.43

  

#### 2.1.4. O Papel dos G4s no Câncer e na Regulação Imune

  

A alta prevalência de sequências formadoras de G4 em promotores de oncogenes (como MYC, KRAS) e em telômeros tornou os G4s alvos atraentes para a terapia do câncer.44 A estabilização dessas estruturas G4 com pequenas moléculas ligantes pode reprimir a transcrição de oncogenes ou inibir a atividade da telomerase, uma enzima crucial para a imortalidade das células cancerígenas.

Mais recentemente, o papel dos G4s na regulação imune emergiu como uma área de pesquisa de ponta. Evidências crescentes indicam que os G4s participam da regulação de genes de checkpoint imunológico, mais notavelmente o PD-L1 (Programmed Death-Ligand 1).44 O PD-L1, expresso em células tumorais, se liga ao seu receptor PD-1 em células T, suprimindo a resposta imune antitumoral. A descoberta de que a formação de G4s pode regular a expressão de PD-L1 abre uma nova avenida terapêutica. A estabilização de uma estrutura G4 no promotor do gene

PD-L1 pode reprimir sua transcrição, diminuindo os níveis de PD-L1 na superfície da célula tumoral e, assim, "liberando os freios" do sistema imunológico. Essa estratégia oferece o potencial para uma terapia de "duplo golpe" quando combinada com anticorpos anti-PD-1/PD-L1 existentes, atacando o mesmo eixo regulatório por dois mecanismos distintos.44 A

Figura 1 de Zhang et al. fornece um excelente resumo visual das diversas funções biológicas dos G4s, que servem como base para seu potencial terapêutico.

Figura 1: Funções dos G-quadruplexes. Este diagrama ilustra os múltiplos papéis dos G4s na regulação da replicação do DNA, transcrição, processamento de RNA, manutenção de telômeros e estabilidade do genoma. Também destaca sua implicação em patologias, incluindo câncer, doenças neurodegenerativas e infecções virais, ressaltando sua importância como alvos terapêuticos. Fonte: Zhang et al., Biomedicines, 2025.44 DOI: 10.3390/biomedicines13051057. Artigo de Acesso Aberto.

  

### 2.2. R-loops: Híbridos Dinâmicos na Encruzilhada da Transcrição e da Imunidade

  

Os R-loops são estruturas de três fitas compostas por um híbrido de RNA:DNA e uma fita de DNA deslocada e de fita simples. Eles se formam co-transcricionalmente quando o transcrito de RNA nascente se re-hibridiza com a fita molde de DNA.47 Embora os R-loops desempenhem papéis fisiológicos importantes, como na recombinação de troca de classe de imunoglobulinas e na terminação da transcrição, sua acumulação não programada é uma fonte significativa de estresse replicativo e instabilidade genômica, pois podem colidir com a maquinaria de replicação.49

  

#### 2.2.1. A Biologia da Formação e Resolução de R-loops

  

A formação de R-loops é favorecida por certas características genômicas, como o alto teor de GC e a inclinação de G na fita de DNA deslocada, que pode formar uma estrutura G4 para estabilizar o R-loop.52 A existência de R-loops é um equilíbrio dinâmico entre sua formação e sua resolução por uma maquinaria celular dedicada. A falha em resolver adequadamente os R-loops leva à sua acumulação patológica.

  

#### 2.2.2. R-loops como Gatilhos de Inflamação via a Via cGAS-STING

  

Uma das descobertas mais significativas dos últimos anos é a conexão entre R-loops e a imunidade inata. A acumulação de R-loops anormais ou de seus subprodutos (como híbridos RNA:DNA citoplasmáticos) atua como um sinal de perigo molecular que é detectado por sensores imunes inatos.54

Especificamente, esses ácidos nucleicos citoplasmáticos são reconhecidos pela cGAS (cyclic GMP-AMP synthase). Após a ligação, a cGAS é ativada e sintetiza o segundo mensageiro cGAMP (cyclic GMP-AMP). O cGAMP então se liga e ativa a proteína adaptadora STING (stimulator of interferon genes), localizada no retículo endoplasmático. A ativação da STING desencadeia uma cascata de sinalização a jusante que culmina na produção de citocinas inflamatórias, incluindo interferons do tipo I.48

Essa via liga diretamente a instabilidade do genoma e o processamento defeituoso de ácidos nucleicos a uma resposta inflamatória estéril. Essa conexão é central para a patogênese de várias doenças autoimunes e inflamatórias. Por exemplo, a síndrome de Aicardi-Goutières (AGS), uma doença inflamatória rara e grave, está intimamente ligada à acumulação de R-loops devido a mutações em genes envolvidos na sua resolução.48 Níveis elevados de R-loops e marcadores inflamatórios também são observados em doenças como a síndrome de Sjögren e o lúpus eritematoso sistêmico, destacando o papel dos R-loops como impulsionadores ocultos da desregulação imune.48

  

### 2.3. Mantendo a Ordem: A Maquinaria de Helicases e Nucleases

  

A natureza dinâmica e potencialmente perigosa das estruturas não canônicas exige uma vigilância constante e uma maquinaria de resolução eficiente. As células evoluíram um conjunto robusto de enzimas, principalmente helicases e nucleases, para desenrolar e degradar essas estruturas, mantendo a integridade do genoma. A Tabela 2 resume as principais enzimas envolvidas.

Tabela 2: Principais Enzimas na Resolução de Estruturas de Ácido Nucleico Não Canônicas.

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|Enzima|Família Enzimática|Substrato Primário|Função/Contexto Chave|Doença Associada à Mutação|Fontes|
|BLM|Helicase RecQ (3'-5')|G-quadruplex, intermediários de recombinação|Resolução de G4s, supressão de recombinação, manutenção de telômeros e estabilidade do garfo de replicação.|Síndrome de Bloom|37|
|WRN|Helicase RecQ (3'-5')|G-quadruplex, intermediários de recombinação|Resolução de G4s, replicação da fita tardia dos telômeros, reparo de quebras de fita dupla.|Síndrome de Werner|37|
|DHX36|Helicase DEAH-box|G-quadruplex (DNA e RNA)|Resolução de G4s em DNA e RNA, regula a tradução de mRNA e a função da telomerase.|-|37|
|FANCJ|Helicase Superfamília 2 (5'-3')|G-quadruplex|Desenrola G4s para prevenir o bloqueio da replicação; parte da via de reparo da Anemia de Fanconi.|Anemia de Fanconi|37|
|SETX (Senataxina)|Helicase Superfamília 1|R-loop|Resolução de R-loops, especialmente em regiões de terminação da transcrição.|Ataxia com apraxia oculomotora tipo 2 (AOA2)|50|
|RNase H1 / H2|Ribonuclease|R-loop (híbrido RNA:DNA)|Degrada a fita de RNA do híbrido RNA:DNA, o principal mecanismo de remoção de R-loops.|Síndrome de Aicardi-Goutières (AGS)|50|

As helicases da família RecQ, BLM e WRN, são cruciais para desenrolar G4s, prevenindo o bloqueio da replicação e a instabilidade telomérica.37 Mutações nesses genes causam síndromes de envelhecimento prematuro e predisposição ao câncer, ressaltando sua importância na manutenção do genoma. Outras helicases, como

DHX36, FANCJ e Pif1, também desempenham papéis especializados na resolução de G4s em diferentes contextos celulares.37

Para os R-loops, a principal linha de defesa são as ribonucleases H (RNase H1 e H2), que degradam especificamente a fita de RNA do híbrido RNA:DNA.50 A ausência dessas enzimas leva a uma acumulação maciça de R-loops e a graves defeitos genômicos. Além disso, helicases como a

senataxina (SETX) são especializadas em desenrolar a estrutura do R-loop, particularmente em locais de terminação da transcrição.50

A formação e resolução dessas estruturas não canônicas não devem ser vistas como eventos isolados, mas como parte integrante do próprio processo de transcrição. A transcrição ativa, ao desenrolar a dupla hélice de DNA, cria o substrato de fita simples necessário para a formação tanto de R-loops (no molde) quanto de G4s (na fita não-molde).38 De fato, a formação de G4 na fita deslocada é proposta como um mecanismo que estabiliza o R-loop adjacente, e mapas genômicos mostram uma sobreposição significativa entre sequências formadoras de G4 e locais de R-loops.61 Uma vez formadas, essas estruturas podem modular a atividade da RNA polimerase, criando um complexo centro de feedback onde a transcrição promove a formação de estruturas que, por sua vez, regulam a transcrição. A existência de uma maquinaria de resolução tão extensa e especializada (Tabela 2) sublinha a importância crítica de manter esse centro regulatório sob controle estrito para evitar consequências patológicas.

  

## Seção 3: O Epitranscriptoma e o Controle Translacional: Regulação Após a Transcrição

  

O controle da expressão gênica não termina com a produção de um transcrito de RNA mensageiro (mRNA). Pelo contrário, uma série de eventos regulatórios pós-transcricionais determina o destino final de cada molécula de mRNA, influenciando seu processamento, estabilidade, localização e, finalmente, sua eficiência de tradução em proteína. Esta seção explora duas fronteiras principais da regulação pós-transcricional: o campo emergente da epitranscriptômica, que estuda as modificações químicas do RNA, e o controle translacional, o ponto de verificação final que dita a produção de proteínas.

  

### 3.1. O Epitranscriptoma: Modificações Químicas do RNA

  

Análogo ao epigenoma, que descreve as modificações no DNA e nas histonas, o epitranscriptoma refere-se ao repertório de modificações químicas que ocorrem nas moléculas de RNA.62 Mais de 100 tipos diferentes de modificações de RNA foram descobertos, e embora muitas sejam abundantes em RNAs não codificantes como o RNA de transferência (tRNA) e o RNA ribossômico (rRNA), o foco recente tem se voltado para as modificações no mRNA, que adicionam uma camada crítica de regulação da expressão gênica.

A modificação interna mais prevalente e bem estudada no mRNA de eucariotos é a N6-metiladenosina (m6A). Assim como as marcas epigenéticas, a m6A é um processo dinâmico e reversível, regulado por um conjunto de proteínas:

- "Escritores" (Writers): Complexos de metiltransferases, como o complexo METTL3-METTL14, que catalisam a adição do grupo metil à posição N6 da adenosina.63
    
- "Apagadores" (Erasers): Demetilases, como FTO e ALKBH5, que removem a marca de m6A.41
    
- "Leitores" (Readers): Proteínas que se ligam especificamente à m6A e mediam seus efeitos a jusante. Essas proteínas, como as da família YTH, podem influenciar o splicing, a estabilidade, a exportação nuclear e a tradução do mRNA marcado com m6A.
    

A desregulação da via da m6A está profundamente implicada em uma variedade de contextos patológicos, mais notavelmente no câncer. Estudos mostraram que os escritores de m6A, METTL3 e METTL16, são essenciais para a manutenção da Leucemia Mieloide Aguda (LMA).63 Em outros tipos de câncer, como o Linfoma Anaplásico de Células Grandes (LACG) impulsionado por ALK, a sinalização oncogênica pode aumentar a expressão da maquinaria de m6A, promovendo a proliferação celular.63 Essa dependência das células cancerígenas da via da m6A tornou os escritores e apagadores de m6A alvos terapêuticos altamente promissores, com um esforço significativo em andamento para desenvolver inibidores de pequenas moléculas contra essas enzimas.63

  

### 3.2. Reescrevendo a Mensagem: Avanços na Edição Programável de RNA

  

Enquanto a epitranscriptômica estuda as modificações naturais do RNA, um campo paralelo e excitante da biologia sintética foca no desenvolvimento de ferramentas para editar o RNA de forma programável em células vivas. Essas tecnologias oferecem a capacidade de corrigir mutações causadoras de doenças no nível do RNA, sem alterar permanentemente o genoma.

  

#### 3.2.1. Uma Plataforma Inovadora para Edição Concorrente de A-para-I e C-para-U

  

Um avanço notável nesta área é a plataforma desenvolvida por Kronschnabl et al. (2021), que permite a edição seletiva e simultânea de dois tipos diferentes de bases de RNA dentro da mesma célula.67 A tecnologia se baseia em duas enzimas de auto-rotulagem ortogonais, a

SNAP-tag e a HALO-tag, que são fundidas a diferentes domínios de desaminase.

O sistema funciona da seguinte forma:

1. Uma proteína de fusão consiste na SNAP-tag ligada ao domínio da desaminase ADAR, que catalisa a edição de adenosina para inosina (A-para-I). A inosina é lida pela maquinaria celular como guanosina (G), permitindo a correção de mutações G-para-A.
    
2. Uma segunda proteína de fusão consiste na HALO-tag ligada ao domínio da desaminase APOBEC1, que catalisa a edição de citosina para uridina (C-para-U).
    
3. A especificidade do alvo é alcançada através de RNAs guia (gRNAs) curtos e sintéticos. Um gRNA projetado para direcionar a edição A-para-I é quimicamente ligado a um substrato de benzilguanina (BG), que se liga covalentemente e irreversivelmente à SNAP-tag. Um segundo gRNA, para a edição C-para-U, é ligado a um substrato de cloroalcano, que se liga covalentemente à HALO-tag.
    
4. Ao transfectar uma célula que expressa ambas as proteínas de fusão com os dois gRNAs correspondentes, é possível direcionar duas edições diferentes para dois locais de mRNA distintos (ou mesmo no mesmo mRNA) de forma independente e simultânea.
    

A Figura 1A do artigo de Kronschnabl et al. fornece um esquema conceitual claro desta plataforma ortogonal.

!([https://www.researchgate.net/figure/Recruitment-of-the-ADAR1-deaminase-domain-in-fusion-with-two-different-self-labeling_fig1_352915151](https://www.researchgate.net/figure/Recruitment-of-the-ADAR1-deaminase-domain-in-fusion-with-two-different-self-labeling_fig1_352915151))

Figura 1A: Recrutamento do domínio da desaminase ADAR1 em fusão com duas enzimas de auto-rotulagem diferentes. O esquema ilustra como enzimas de auto-rotulagem independentes, como a SNAP-tag e a HALO-tag, permitem o recrutamento ortogonal de múltiplos efetores (representados como Enzima A e Enzima B) para um alvo de RNA por meio de gRNAs específicos. No contexto do estudo, as enzimas A e B são as desaminases ADAR e APOBEC. Fonte: Kronschnabl et al., Nucleic Acids Research, 2021.67 DOI: 10.1093/nar/gkab541. Artigo de Acesso Aberto.

Esta tecnologia representa um avanço significativo porque supera as limitações de ferramentas de função única e oferece uma modularidade sem precedentes. O pequeno tamanho das proteínas de fusão permite sua fácil integração genômica, e a plataforma é prontamente adaptável para recrutar outros tipos de "escritores" e "apagadores" epitranscriptômicos, abrindo vastas possibilidades para a pesquisa fundamental e o desenvolvimento de terapias baseadas em RNA.67

  

### 3.3. Regulando a Síntese de Proteínas: De Interruptores Sintéticos ao Perfilamento Global

  

O ponto de verificação final e talvez o mais crucial na expressão gênica é a tradução, o processo pelo qual a informação codificada no mRNA é usada para sintetizar proteínas. A regulação neste nível permite respostas celulares rápidas, independentes de novas transcrições.

  

#### 3.3.1. Controle Sintético da Tradução com Interruptores de "Toehold"

  

Os interruptores de "toehold" são riborreguladores sintéticos engenhosamente projetados para controlar a tradução de um mRNA em resposta a uma molécula de RNA "gatilho" específica.68 O mecanismo baseia-se no deslocamento de fita mediado por "toehold" (TMSD):

- Estado "OFF": Na ausência do gatilho, o sítio de ligação do ribossomo (RBS) e o códon de início (AUG) do mRNA alvo são sequestrados dentro de uma estrutura de grampo (hairpin) de RNA estável. Isso impede fisicamente que o ribossomo se ligue e inicie a tradução.
    
- Estado "ON": O interruptor contém uma pequena região de fita simples saliente, o "toehold". A presença de um RNA gatilho, que é complementar tanto ao "toehold" quanto a uma porção do grampo, inicia uma reação de TMSD. O gatilho se liga ao "toehold" e, em seguida, invade e desenrola a estrutura do grampo.
    
- Ativação: A abertura do grampo expõe o RBS e o códon de início, permitindo que o ribossomo se ligue e inicie a tradução da proteína codificada.
    

Esses interruptores são altamente programáveis e podem ser projetados para responder a praticamente qualquer sequência de RNA gatilho, tornando-os ferramentas poderosas para biossensores (por exemplo, detecção de genomas virais como Zika ou SARS-CoV-2 em sistemas sem células) e para a construção de circuitos lógicos moleculares complexos (portas AND, OR) que podem executar computação dentro das células.68

  

#### 3.3.2. Revelando o Translatoma com o Perfilamento de Ribossomos

  

Enquanto os interruptores de "toehold" representam uma abordagem de engenharia de "baixo para cima", o perfilamento de ribossomos (Ribo-seq) oferece uma visão global de "cima para baixo" da regulação translacional. Esta técnica revolucionária fornece um instantâneo de alta resolução de toda a atividade de tradução em uma célula em um determinado momento.13 O processo envolve o tratamento de células com um inibidor de elongação para "congelar" os ribossomos em seus mRNAs, a digestão de todo o RNA não protegido pelos ribossomos e, em seguida, o sequenciamento profundo dos fragmentos de mRNA protegidos pelos ribossomos (ribosome footprints).

O Ribo-seq revela várias camadas de regulação que são invisíveis apenas com a análise do transcriptoma (RNA-seq):

- Eficiência Translacional (TE): Ao normalizar o número de "footprints" de ribossomos pela abundância de mRNA (medida por RNA-seq paralelo), pode-se calcular a TE para cada gene. Estudos mostraram que a TE varia drasticamente entre os genes e pode mudar dinamicamente durante processos como a diferenciação celular, indicando que o controle translacional é uma força motriz principal na remodelação do proteoma.14 Por exemplo, durante a eritropoiese (desenvolvimento de glóbulos vermelhos), muitos genes são regulados principalmente no nível da tradução, e não da transcrição.13
    
- Identificação de ORFs Não Canônicas: O Ribo-seq pode identificar a tradução de fases de leitura abertas (ORFs) que não foram previamente anotadas, como pequenas ORFs localizadas nas regiões 5' não traduzidas (uORFs). Muitas dessas uORFs atuam como elementos regulatórios que reprimem a tradução da ORF principal a jusante, e sua própria tradução pode ser dinamicamente regulada para controlar a produção da proteína principal.13
    
- Mecanismos Virais: A técnica tem sido fundamental para entender como os vírus sequestram a maquinaria de tradução do hospedeiro para favorecer a síntese de suas próprias proteínas.14
    

O campo da regulação pós-transcricional está passando por uma transformação notável, movendo-se de uma fase descritiva para uma fase prescritiva. Técnicas como Ribo-seq e mapeamento de m6A forneceram mapas detalhados da paisagem regulatória, revelando a profunda importância do controle pós-transcricional na saúde e na doença. Essa compreensão fundamental agora impulsiona o desenvolvimento de ferramentas de engenharia, como os editores de RNA programáveis e os interruptores sintéticos, que permitem aos cientistas não apenas observar, mas também reescrever e controlar ativamente o destino do RNA. Essa trajetória da observação à engenharia está na vanguarda da biologia sintética e promete inaugurar uma nova era de terapêuticas baseadas em RNA que podem modular a expressão gênica com uma precisão sem precedentes.

  

## Seção 4: Análise Aprofundada de Artigos Seminais

  

Para fornecer uma compreensão mais profunda das fronteiras da pesquisa em regulação gênica, esta seção realiza uma análise detalhada de quatro artigos-chave que formam a espinha dorsal deste relatório. Cada análise aborda três questões centrais: o tema teórico subjacente que o artigo investiga, as técnicas experimentais empregadas para testar a hipótese e a principal contribuição do trabalho para o conhecimento científico.

  

### 4.1. Análise do Artigo: Imperfect G-quadruplex as an emerging candidate for transcriptional regulation (Sarkar et al., 2025; DOI: 10.1093/nar/gkaf164)

39

  

- Qual é o tema teórico subjacente?  
    O tema teórico central deste artigo é o desafio e a expansão do paradigma canônico das estruturas G-quadruplex (G4). Tradicionalmente, os G4s funcionais eram definidos por sequências com tratos de guanina contínuos. Os autores postularam a hipótese de que estruturas G4 não canônicas, contendo "protuberâncias" (bulges) de nucleotídeos que não são guanina (denominadas buG4s), não são meramente estruturas malformadas e instáveis. Em vez disso, eles propuseram que essas buG4s poderiam ser suficientemente estáveis termodinamicamente sob condições que mimetizam o ambiente celular para serem reguladores funcionais da transcrição. O estudo buscou sistematicamente validar essa hipótese, movendo o campo de uma visão estritamente baseada em sequências para uma compreensão mais biofísica e funcionalmente orientada do que constitui um G4 regulatório.
    
- Qual(is) técnica(s) foi(ram) utilizada(s)?  
    O estudo empregou uma abordagem multidisciplinar que combinou técnicas biofísicas e bioquímicas para conectar a estrutura à função. As principais técnicas foram:
    

1. Análise Termodinâmica por Fusão UV (UV-melting): Esta foi a técnica central para quantificar a estabilidade das estruturas buG4. Ao monitorar a mudança na absorbância a 295 nm com o aumento da temperatura, os autores determinaram a temperatura de fusão (Tm​) e calcularam parâmetros termodinâmicos fundamentais como a mudança na energia livre de Gibbs (ΔG°), entalpia (ΔH°) e entropia (ΔS°). Isso permitiu uma comparação quantitativa rigorosa da estabilidade entre diferentes buG4s e o G4 perfeito (pG4).39
    
2. Dicroísmo Circular (CD): A espectroscopia de CD foi usada para confirmar que as sequências de DNA estavam de fato se dobrando na conformação G4 paralela esperada, caracterizada por um pico positivo em ~260 nm e um vale em ~240 nm.39
    
3. Eletroforese em Gel Nativo: Esta técnica foi utilizada para verificar que as estruturas G4 formadas eram monoméricas e não agregados multimoleculares, garantindo que as medições termodinâmicas fossem para estruturas unimoleculares.39
    
4. Ensaio de Transcrição in vitro: Para testar a consequência funcional das buG4s, foi realizado um ensaio de transcrição usando a RNA polimerase T7. A capacidade de uma estrutura buG4 de bloquear a polimerase foi medida pela produção de um transcrito curto e arrestado, que foi visualizado e quantificado por eletroforese em gel desnaturante.39
    

- Qual a contribuição do artigo para o conhecimento científico?  
    A principal contribuição deste artigo é a validação sistemática e quantitativa de que os G4s imperfeitos são elementos regulatórios biologicamente relevantes. O trabalho fez várias contribuições chave:
    

1. Expansão do "G4-oma" Funcional: Ao demonstrar que as buG4s podem ser estáveis e funcionalmente ativas, o estudo expande vastamente o número de potenciais sequências regulatórias G4 no genoma, que anteriormente eram descartadas por algoritmos de busca baseados em sequências canônicas.
    
2. Modelo Preditivo Quantitativo: Os autores estabeleceram um modelo preditivo que liga diretamente a estabilidade termodinâmica (ΔG°37​) à função regulatória (eficiência de arresto da transcrição). Eles propuseram um limiar de estabilidade (ΔG°37​ ≤ -3.3 kcal·mol⁻¹) acima do qual uma buG4 pode funcionar como um bloqueio transcricional. Isso fornece uma ferramenta valiosa para filtrar e priorizar candidatos a buG4 funcionais a partir de dados genômicos.39
    
3. Importância do Contexto Celular e Estrutural: O estudo destacou que a estabilidade e a função de uma buG4 não dependem apenas da sequência, mas também de sua posição dentro da estrutura G4 e do ambiente de aglomeração molecular da célula. Isso enfatiza a necessidade de considerar fatores biofísicos e o contexto celular ao prever a função de elementos de DNA.39
    

  

### 4.2. Análise do Artigo: Harnessing self-labeling enzymes for selective and concurrent A-to-I and C-to-U RNA base editing (Kronschnabl et al., 2021; DOI: 10.1093/nar/gkab541)

67

  

- Qual é o tema teórico subjacente?  
    O tema teórico subjacente é o avanço da biologia sintética através do desenvolvimento de plataformas moleculares modulares e ortogonais para a engenharia biológica programável. O trabalho aborda uma limitação fundamental das ferramentas de edição de RNA existentes, que normalmente executam uma única função. A hipótese central era que, ao utilizar enzimas de auto-rotulagem quimicamente ortogonais (SNAP-tag e HALO-tag), seria possível criar um sistema de dois efetores capaz de recrutar duas atividades de edição de RNA distintas (A-para-I e C-para-U) para alvos de mRNA endógenos de forma independente e simultânea dentro da mesma célula viva.
    
- Qual(is) técnica(s) foi(ram) utilizada(s)?  
    A metodologia deste estudo é um exemplo de engenharia de biologia sintética e celular:
    

1. Biologia Molecular e Clonagem: Construção de vetores de expressão para produzir as proteínas de fusão (SNAP-ADAR, HALO-APOBEC) em células de mamíferos.67
    
2. Cultura de Células e Engenharia de Linhagens Celulares: Uso do sistema Flp-In T-REx para gerar linhagens celulares humanas (HEK293) que expressam de forma estável e induzível as proteínas de fusão. Isso garante níveis de expressão consistentes e controlados, minimizando a toxicidade e os efeitos fora do alvo.67
    
3. Síntese Química de RNAs Guia: Os gRNAs, que conferem a especificidade do alvo, foram sintetizados quimicamente e modificados com os ligantes apropriados (benzilguanina para a SNAP-tag, cloroalcano para a HALO-tag).67
    
4. Transfecção e Edição Celular: As linhagens celulares estáveis foram transfectadas com os gRNAs para induzir a edição de RNA nos alvos endógenos.
    
5. Sequenciamento de Próxima Geração (NGS): Após a extração de RNA, o sequenciamento direcionado (para alvos específicos) e o RNA-seq de todo o transcriptoma foram usados para quantificar a eficiência da edição no alvo (on-target) e para avaliar a extensão da edição fora do alvo (off-target) em todo o genoma.67
    

- Qual a contribuição do artigo para o conhecimento científico?  
    Este artigo representa um salto tecnológico significativo no campo da edição de RNA, com várias contribuições importantes:
    

1. Primeira Demonstração de Edição de RNA Dupla e Ortogonal: É a primeira vez que um sistema foi demonstrado capaz de realizar duas manipulações de bases de RNA distintas (A-para-I e C-para-U) de forma concorrente e seletiva. Isso expande enormemente o escopo da manipulação do transcriptoma.67
    
2. Plataforma Modular e Flexível: A abordagem baseada em SNAP/HALO é inerentemente modular. Em princípio, qualquer domínio efetor de RNA (outras desaminases, metiltransferases, demetilases) pode ser fundido às tags, tornando a plataforma uma ferramenta versátil para estudar e manipular o epitranscriptoma com alta precisão molecular.67
    
3. Controle Aprimorado e Baixos Efeitos Fora do Alvo: Ao integrar as enzimas de edição no genoma e controlar seus níveis de expressão, a plataforma minimiza a edição global fora do alvo, um grande problema com a superexpressão de desaminases. A especificidade é ditada por gRNAs curtos e sintéticos, que são fáceis de projetar e otimizar.67
    
4. Avanço Terapêutico Potencial: Ao permitir a correção simultânea de diferentes tipos de mutações ou a manipulação de múltiplas vias em paralelo, esta tecnologia abre novas possibilidades para o desenvolvimento de terapias baseadas em RNA para doenças genéticas complexas.
    

  

### 4.3. Análise do Artigo: The Emerging Roles of Multimolecular G-Quadruplexes in Transcriptional Regulation and Chromatin Organization (Yatsunyk et al., 2024; DOI: 10.1021/acs.accounts.4c00574)

43

  

- Qual é o tema teórico subjacente?  
    Este artigo de revisão desafia o dogma predominante de que os G-quadruplexes (G4s) são primariamente elementos repressores da transcrição localizados em promotores. O tema teórico central é que os G4s, especialmente os G4s multimoleculares (mG4s) que se formam entre locais genômicos distantes, podem funcionar como potentes ativadores transcricionais. A hipótese unificadora proposta é que eles alcançam isso atuando como elementos arquitetônicos que remodelam ativamente o genoma 3D através de um mecanismo biofísico de separação de fases líquido-líquido (LLPS) independente de proteínas.
    
- Qual(is) técnica(s) foi(ram) utilizada(s)?  
    Sendo um artigo de revisão do tipo Account, o trabalho sintetiza as descobertas de vários estudos primários do grupo do autor e de outros. As técnicas-chave discutidas, que forneceram a evidência para o modelo proposto, incluem:
    

1. Microscopia Confocal e Eletroforese em Gel de Agarose: Usadas para visualizar a formação de agregados de mG4 de alto peso molecular e confirmar sua natureza G4 através da coloração com ligantes específicos como a N-metil mesoporfirina IX (NMM).43
    
2. Ensaios de Separação de Fases Líquido-Líquido (LLPS): Experimentos que demonstram que sequências de DNA ricas em guanina podem, por si só, formar gotículas líquidas macroscópicas (condensados) na ausência de proteínas, um achado central para a hipótese do artigo.43
    
3. Ensaios de Deslocamento de Mobilidade Eletroforética (EMSA): Usados para estudar as interações proteína-DNA, mostrando, por exemplo, que a proteína de reparo de DNA CSB se liga preferencialmente a mG4s em detrimento de G4s unimoleculares.43
    
4. Imunocoloração: Utilizada para visualizar a localização de proteínas (como a CSB) e estruturas G4 (usando o anticorpo BG4) dentro do núcleo celular.43
    

- Qual a contribuição do artigo para o conhecimento científico?  
    A principal contribuição deste artigo é a articulação de um novo e poderoso modelo para a função do G4 na regulação gênica, que integra os campos das estruturas de ácido nucleico não canônicas e dos condensados biomoleculares. Suas contribuições específicas são:
    

1. Mudança de Paradigma na Função do G4: O artigo argumenta convincentemente que os G4s não devem ser vistos apenas como repressores, mas também como importantes ativadores da transcrição, especialmente quando formados em elementos regulatórios distais como intensificadores.43
    
2. Mecanismo Biofísico para a Ativação Gênica: Ele propõe um mecanismo físico claro para essa ativação: a formação de mG4s impulsiona a LLPS para criar condensados de ácido nucleico. Esses condensados podem então funcionar como os "hubs" transcricionais discutidos na Seção 1.4, concentrando a maquinaria transcricional para amplificar a expressão gênica.43
    
3. Conexão com a Arquitetura da Cromatina: O artigo conecta a formação de mG4s diretamente à organização da cromatina, sugerindo que eles são elementos estruturais chave, mas subexplorados, na formação de alças de cromatina e na modelagem da arquitetura do genoma 3D. A ligação seletiva da proteína remodeladora de cromatina CSB aos mG4s fornece um elo mecanicista para essa função.43
    

  

### 4.4. Análise do Artigo: Unraveling R-loops: The hidden drivers of inflammation and immune dysregulation (Li et al., 2025; DOI: 10.1097/MD.0000000000042833)

48

  

- Qual é o tema teórico subjacente?  
    O tema teórico central deste artigo de revisão é que os R-loops, estruturas de três fitas de ácido nucleico, não são apenas subprodutos transcricionais ou fontes de dano ao DNA, mas sim moléculas de sinalização imunomoduladoras potentes. O artigo sintetiza a crescente evidência de que a acumulação patológica de R-loops, resultante de um desequilíbrio em sua formação e resolução, é um gatilho comum e um impulsionador oculto da inflamação estéril e da desregulação imune observada em uma variedade de doenças humanas.
    
- Qual(is) técnica(s) foi(ram) utilizada(s)?  
    Como um artigo de revisão, ele compila e analisa dados de estudos primários que utilizaram uma gama de técnicas genômicas, moleculares e celulares:
    

1. Análise Genômica de Pacientes: Estudos que sequenciaram os genomas de pacientes com doenças como a Síndrome de Aicardi-Goutières (AGS) para identificar mutações em genes envolvidos no metabolismo de ácidos nucleicos e na resolução de R-loops.48
    
2. Mapeamento Genômico de R-loops (DRIP-seq): A técnica de Imunoprecipitação de DNA-RNA seguida de sequenciamento (DRIP-seq) foi fundamental para mapear a distribuição de R-loops em todo o genoma e mostrar seu aumento em condições de doença.48
    
3. Ensaios Celulares de Sinalização Imune: Estudos que utilizaram modelos celulares (por exemplo, com knockdown de enzimas de resolução de R-loop como DDX41 ou senataxina) para investigar as vias de sinalização a jusante. Esses ensaios medem a ativação de vias como a cGAS-STING, a fosforilação de fatores como IRF3 e a produção de citocinas inflamatórias.48
    
4. Análise Computacional: O artigo também destaca o uso de métodos computacionais para prever a formação, distribuição e regulação de R-loops, ajudando a identificar novas vias para o desenvolvimento de imunoterapias.48
    

- Qual a contribuição do artigo para o conhecimento científico?  
    A principal contribuição do artigo é consolidar e destacar um paradigma emergente na biologia dos R-loops, posicionando-os como mediadores chave na interface entre a estabilidade do genoma e a imunidade inata. Suas contribuições específicas incluem:
    

1. Elucidação de um Mecanismo de Inflamação Estéril: O artigo articula claramente o mecanismo molecular pelo qual o excesso de R-loops citoplasmáticos ou seus subprodutos são detectados pelo sensor de DNA cGAS, ativando a via STING e desencadeando uma resposta inflamatória. Isso fornece uma explicação molecular unificadora para os fenótipos inflamatórios observados em um espectro de doenças de "R-loopopatias".48
    
2. Identificação de R-loops como Alvos Terapêuticos: Ao enquadrar os R-loops como moléculas imunomoduladoras, a revisão identifica sua homeostase como um novo e promissor alvo terapêutico. A modulação dos níveis de R-loops, seja aumentando-os para estimular a imunidade antitumoral ou diminuindo-os para amortecer a inflamação autoimune, representa uma nova fronteira para a imunoterapia.48
    
3. Síntese de um Campo em Rápida Evolução: O trabalho reúne descobertas díspares de campos como reparo de DNA, transcrição e imunologia em uma narrativa coesa, solidificando o conceito de que a desregulação dos R-loops é um princípio patológico fundamental em muitas doenças humanas.
    

  

## Conclusão: Uma Visão Integrada e Dinâmica da Regulação Gênica

  

Este relatório detalhou a paisagem multifacetada e interconectada da regulação da expressão gênica, revelando um sistema que é muito mais dinâmico e complexo do que o fluxo linear de informação sugerido pelo dogma central. A análise dos avanços recentes, de 2021 a 2025, aponta para uma conclusão abrangente: a expressão gênica é governada por uma rede profundamente integrada onde a arquitetura do genoma, as estruturas não canônicas do ácido nucleico, as modificações epitranscriptômicas e o controle translacional não são camadas isoladas, mas sim componentes interdependentes de um contínuo regulatório.

A arquitetura 3D do genoma emergiu não como um andaime estático, mas como uma tela dinâmica que é tanto uma causa quanto uma consequência da atividade transcricional. A organização hierárquica em compartimentos e TADs estabelece uma estrutura fundamental para a regulação, mas essa mesma estrutura é ativamente remodelada pela formação de condensados transcricionais impulsionados pela separação de fases. Esse ciclo de feedback, onde a função (transcrição) e a estrutura (arquitetura da cromatina) se influenciam mutuamente, é um princípio fundamental que sustenta a estabilidade e a plasticidade dos estados celulares.

Neste cenário dinâmico, estruturas não canônicas como G-quadruplexes e R-loops não são aberrações, mas sim participantes ativos. Eles funcionam como sensores e efetores do estado transcricional, formando-se em resposta à abertura da dupla hélice e, por sua vez, modulando a progressão da RNA polimerase. A descoberta de que G4s multimoleculares podem induzir a separação de fases de forma independente de proteínas e que os R-loops podem acionar diretamente as vias de imunidade inata, como a cGAS-STING, redefine-os como elementos arquitetônicos e de sinalização cruciais. A interconexão entre G4s e R-loops, onde a formação de um pode estabilizar o outro, sugere a existência de "hubs" regulatórios complexos no nexo da transcrição.

Além da transcrição, as camadas de regulação pós-transcricional e translacional oferecem pontos de verificação adicionais para o ajuste fino da expressão gênica. O campo da epitranscriptômica, liderado pelo estudo da modificação m6A, revelou como as marcas químicas no RNA governam seu destino. Paralelamente, o controle translacional, revelado por técnicas como o perfilamento de ribossomos, demonstrou ser uma força motriz principal na remodelação do proteoma, muitas vezes operando de forma independente dos níveis de mRNA.

A trajetória da pesquisa neste campo reflete uma transição da observação para a engenharia. Ferramentas como Hi-C, G4-seq, DRIP-seq e Ribo-seq forneceram mapas descritivos de alta resolução da paisagem regulatória. Essa compreensão fundamental agora alimenta o desenvolvimento de tecnologias prescritivas, como a edição de RNA programável e os interruptores translacionais sintéticos, que permitem aos pesquisadores controlar ativamente a expressão gênica.

As implicações terapêuticas dessa visão integrada são profundas. O tratamento de doenças complexas como o câncer pode exigir estratégias que vão além do alvo de uma única via. Terapias combinadas que, por exemplo, estabilizam G4s para reprimir um oncogene enquanto simultaneamente administram um inibidor de checkpoint imunológico para liberar a resposta imune 44, ou que modulam os níveis de R-loop para amortecer a inflamação patológica 48, representam a próxima geração de abordagens de medicina de precisão. A capacidade de editar diretamente o RNA 67 abre uma fronteira inteiramente nova, movendo o foco terapêutico do genoma estático para o mundo dinâmico e maleável do transcriptoma. Em suma, a compreensão da regulação gênica como um sistema integrado e dinâmico não apenas aprofunda nosso conhecimento da biologia fundamental, mas também ilumina um vasto horizonte de novas oportunidades para intervir em doenças humanas.

#### Referências citadas

1. A mechanism of global gene expression regulation is disrupted by multiple disease states and drug treatments - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/40341320/](https://pubmed.ncbi.nlm.nih.gov/40341320/)
    
2. Co-transcriptional gene regulation in eukaryotes and prokaryotes ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11199108/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11199108/)
    
3. Enhancer-promoter specificity in gene transcription: molecular ..., acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/38658702/](https://pubmed.ncbi.nlm.nih.gov/38658702/)
    
4. Hi-C, a chromatin 3D structure technique advancing the functional genomics of immune cells, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10995239/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10995239/)
    
5. Nuclear receptor activation shapes spatial genome organization ..., acessado em junho 22, 2025, [https://academic.oup.com/nar/article/50/7/3745/6553119](https://academic.oup.com/nar/article/50/7/3745/6553119)
    
6. New 3D genome mapping technology sheds light on how plants regulate photosynthesis, acessado em junho 22, 2025, [https://www.eurekalert.org/news-releases/1085637](https://www.eurekalert.org/news-releases/1085637)
    
7. DNA folds threaten genetic stability and can be leveraged for chemotherapy, acessado em junho 22, 2025, [https://pubs.rsc.org/en/content/articlehtml/2021/cb/d0cb00151a](https://pubs.rsc.org/en/content/articlehtml/2021/cb/d0cb00151a)
    
8. An updated overview of experimental and computational approaches to identify non-canonical DNA/RNA structures with emphasis on G-quadruplexes and R-loops - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC9677470/](https://pmc.ncbi.nlm.nih.gov/articles/PMC9677470/)
    
9. (PDF) High-throughput techniques enable advances in the roles of DNA and RNA secondary structures in transcriptional and post-transcriptional gene regulation - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/362078948_High-throughput_techniques_enable_advances_in_the_roles_of_DNA_and_RNA_secondary_structures_in_transcriptional_and_post-transcriptional_gene_regulation](https://www.researchgate.net/publication/362078948_High-throughput_techniques_enable_advances_in_the_roles_of_DNA_and_RNA_secondary_structures_in_transcriptional_and_post-transcriptional_gene_regulation)
    
10. (PDF) Stable bulged G-quadruplexes in the human genome: identification, experimental validation and functionalization - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/370229392_Stable_bulged_G-quadruplexes_in_the_human_genome_identification_experimental_validation_and_functionalization](https://www.researchgate.net/publication/370229392_Stable_bulged_G-quadruplexes_in_the_human_genome_identification_experimental_validation_and_functionalization)
    
11. DNA G-QUADRUPLEX STRUCTURES IN THE MAMMALIAN GENOME - CORE, acessado em junho 22, 2025, [https://core.ac.uk/download/516463992.pdf](https://core.ac.uk/download/516463992.pdf)
    
12. Biologia Cellulare e Molecolare - AMS Tesi di Dottorato, acessado em junho 22, 2025, [http://amsdottorato.unibo.it/9253/1/Russo_Marco_tesi.pdf](http://amsdottorato.unibo.it/9253/1/Russo_Marco_tesi.pdf)
    
13. Widespread and dynamic translational control of red blood cell ..., acessado em junho 22, 2025, [https://ashpublications.org/blood/article/129/5/619/36156/Widespread-and-dynamic-translational-control-of](https://ashpublications.org/blood/article/129/5/619/36156/Widespread-and-dynamic-translational-control-of)
    
14. RNA-seq and Ribosome Profiling Reveal the Translational Landscape of Rice in Response to Rice Stripe Virus Infection - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11680141/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11680141/)
    
15. Ribosome profiling: a powerful tool in oncological research - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10809610/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10809610/)
    
16. A predictive chromatin architecture nexus regulates transcription and DNA damage repair, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11931391/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11931391/)
    
17. Chromatin remodeling and cancer: the critical influence of the SWI/SNF complex - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12016160/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12016160/)
    
18. Crosstalk between metabolism and epigenetics during macrophage ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11954343/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11954343/)
    
19. A Comprehensive Examination of the Role of Epigenetic Factors in Multiple Sclerosis - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/1422-0067/25/16/8921](https://www.mdpi.com/1422-0067/25/16/8921)
    
20. Epigenetics of hypertension as a risk factor for the development of coronary artery disease in type 2 diabetes mellitus - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/endocrinology/articles/10.3389/fendo.2024.1365738/full](https://www.frontiersin.org/journals/endocrinology/articles/10.3389/fendo.2024.1365738/full)
    
21. Histone modification important for correct blood cell formation - ScienceDaily, acessado em junho 22, 2025, [https://www.sciencedaily.com/releases/2024/12/241218132142.htm](https://www.sciencedaily.com/releases/2024/12/241218132142.htm)
    
22. (PDF) Pan-3D genome analysis reveals structural and functional differentiation of soybean genomes - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/367271013_Pan-3D_genome_analysis_reveals_structural_and_functional_differentiation_of_soybean_genomes](https://www.researchgate.net/publication/367271013_Pan-3D_genome_analysis_reveals_structural_and_functional_differentiation_of_soybean_genomes)
    
23. Light control of three‐dimensional chromatin organization in soybean - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11331798/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11331798/)
    
24. Light control of three‐dimensional chromatin organization in soybean - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/380711847_Light_control_of_three-dimensional_chromatin_organization_in_soybean](https://www.researchgate.net/publication/380711847_Light_control_of_three-dimensional_chromatin_organization_in_soybean)
    
25. Light control of three-dimensional chromatin organization in soybean - PubMed, acessado em junho 22, 2025, [https://pubmed.ncbi.nlm.nih.gov/38762905/](https://pubmed.ncbi.nlm.nih.gov/38762905/)
    
26. Ekaterina Khrameeva (Associate Professor) - Skoltech, acessado em junho 22, 2025, [https://msc.skoltech.ru/khrameeva](https://msc.skoltech.ru/khrameeva)
    
27. Increased Enhancer—Promoter Interactions during Developmental Enhancer Activation in Mammals - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11203181/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11203181/)
    
28. Transcription decouples estrogen-dependent changes in enhancer-promoter contact frequencies and spatial proximity | PLOS Genetics, acessado em junho 22, 2025, [https://journals.plos.org/plosgenetics/article?id=10.1371/journal.pgen.1011277](https://journals.plos.org/plosgenetics/article?id=10.1371/journal.pgen.1011277)
    
29. Large-scale analysis of the integration of enhancer-enhancer signals by promoters - eLife, acessado em junho 22, 2025, [https://elifesciences.org/articles/91994](https://elifesciences.org/articles/91994)
    
30. Full article: Transcriptional condensates and phase separation: condensing information across scales and mechanisms, acessado em junho 22, 2025, [https://www.tandfonline.com/doi/full/10.1080/19491034.2023.2213551](https://www.tandfonline.com/doi/full/10.1080/19491034.2023.2213551)
    
31. Phase-separated chromatin compartments: Orchestrating gene expression through condensation - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11541479/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11541479/)
    
32. Shimobayashi Shunsuke | Researcher Information - J-Global, acessado em junho 22, 2025, [https://jglobal.jst.go.jp/en/detail?JGLOBAL_ID=202001013664843782](https://jglobal.jst.go.jp/en/detail?JGLOBAL_ID=202001013664843782)
    
33. Notch1 forms nuclear transcriptional condensates that drive target gene expression, acessado em junho 22, 2025, [https://www.researchgate.net/publication/369372660_Notch1_forms_nuclear_transcriptional_condensates_that_drive_target_gene_expression](https://www.researchgate.net/publication/369372660_Notch1_forms_nuclear_transcriptional_condensates_that_drive_target_gene_expression)
    
34. Yongdae Shin's research works | Princeton University and other places - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/scientific-contributions/Yongdae-Shin-2119878783](https://www.researchgate.net/scientific-contributions/Yongdae-Shin-2119878783)
    
35. Interplay of condensation and chromatin binding underlies BRD4 targeting, acessado em junho 22, 2025, [https://www.molbiolcell.org/doi/10.1091/mbc.E24-01-0046](https://www.molbiolcell.org/doi/10.1091/mbc.E24-01-0046)
    
36. Emergent 3D genome reorganization from the stepwise assembly of transcriptional condensates - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.02.23.639564v1.full.pdf](https://www.biorxiv.org/content/10.1101/2025.02.23.639564v1.full.pdf)
    
37. The regulation and functions of DNA and RNA G-quadruplexes - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC7115845/](https://pmc.ncbi.nlm.nih.gov/articles/PMC7115845/)
    
38. Epigenetic Modulation of Chromatin States and Gene Expression by G-Quadruplex Structures - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/1422-0067/21/11/4172](https://www.mdpi.com/1422-0067/21/11/4172)
    
39. Imperfect G-quadruplex as an emerging candidate for transcriptional ..., acessado em junho 22, 2025, [https://academic.oup.com/nar/article/53/5/gkaf164/8086779](https://academic.oup.com/nar/article/53/5/gkaf164/8086779)
    
40. The Interplay between G-quadruplex and Transcription - PMC - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC6026074/](https://pmc.ncbi.nlm.nih.gov/articles/PMC6026074/)
    
41. ATRX promotes transcription initiation of HSV-1 immediate early genes during early lytic infection | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.04.14.648792v1.full-text](https://www.biorxiv.org/content/10.1101/2025.04.14.648792v1.full-text)
    
42. RNA polymerase II 215kD subunit - Society for Developmental Biology, acessado em junho 22, 2025, [https://www.sdbonline.org/sites/fly/genebrief/pol2.htm](https://www.sdbonline.org/sites/fly/genebrief/pol2.htm)
    
43. The Emerging Roles of Multimolecular G-Quadruplexes in ..., acessado em junho 22, 2025, [https://pubs.acs.org/doi/10.1021/acs.accounts.4c00574](https://pubs.acs.org/doi/10.1021/acs.accounts.4c00574)
    
44. G-Quadruplexes in Tumor Immune Regulation: Molecular ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12109316/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12109316/)
    
45. MYC, MYCL and MYCN as therapeutic targets in lung cancer - Sci-Hub, acessado em junho 22, 2025, [https://sci-hub.se/downloads/2020-02-02/ae/10.1080@14728222.2020.1723548.pdf](https://sci-hub.se/downloads/2020-02-02/ae/10.1080@14728222.2020.1723548.pdf)
    
46. Inhibiting Myc and the Myc dependent inflammatory response as cancer therapies Daniel Massó Vallés - DDD UAB, acessado em junho 22, 2025, [https://ddd.uab.cat/pub/tesis/2017/hdl_10803_458137/dmv1de1.pdf](https://ddd.uab.cat/pub/tesis/2017/hdl_10803_458137/dmv1de1.pdf)
    
47. Regulation of R-Loops in DNA Tumor Viruses - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/2076-0817/13/10/863](https://www.mdpi.com/2076-0817/13/10/863)
    
48. Unraveling R-loops: The hidden drivers of inflammation and immune ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC12173303/](https://pmc.ncbi.nlm.nih.gov/articles/PMC12173303/)
    
49. Mechanisms underlining R-loop biology and implications for human disease - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/cell-and-developmental-biology/articles/10.3389/fcell.2025.1537731/full](https://www.frontiersin.org/journals/cell-and-developmental-biology/articles/10.3389/fcell.2025.1537731/full)
    
50. Mechanisms underlining R-loop biology and implications for human ..., acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11885306/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11885306/)
    
51. DNA damage response defects in hematologic malignancies: mechanistic insights and therapeutic strategies | Blood, acessado em junho 22, 2025, [https://ashpublications.org/blood/article/143/21/2123/515229/DNA-damage-response-defects-in-hematologic](https://ashpublications.org/blood/article/143/21/2123/515229/DNA-damage-response-defects-in-hematologic)
    
52. Protein-mediated stabilization and nicking of the non-template DNA strand dramatically affect R-loop formation in vitro | bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2025.04.24.649451v1.full](https://www.biorxiv.org/content/10.1101/2025.04.24.649451v1.full)
    
53. Global coupling of R-loop dynamics with RNA polymerase II modulates gene expression and early development of Drosophila | Nucleic Acids Research | Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/nar/article/52/21/13110/7848850](https://academic.oup.com/nar/article/52/21/13110/7848850)
    
54. R-Loops: Double-Edged Players in Genome Stability and Disease - Bioengineer.org, acessado em junho 22, 2025, [https://bioengineer.org/r-loops-double-edged-players-in-genome-stability-and-disease/](https://bioengineer.org/r-loops-double-edged-players-in-genome-stability-and-disease/)
    
55. Regulation of the cGAS-STING Pathway - Annual Reviews, acessado em junho 22, 2025, [https://www.annualreviews.org/content/journals/10.1146/annurev-immunol-101721-032910?crawler=true&mimetype=application/pdf](https://www.annualreviews.org/content/journals/10.1146/annurev-immunol-101721-032910?crawler=true&mimetype=application/pdf)
    
56. At the Crossroads of the cGAS-cGAMP-STING Pathway and the DNA Damage Response: Implications for Cancer Progression and Treatment - PubMed Central, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC10747911/](https://pmc.ncbi.nlm.nih.gov/articles/PMC10747911/)
    
57. Multiple functions of the ALT favorite helicase, BLM - PMC, acessado em junho 22, 2025, [https://pmc.ncbi.nlm.nih.gov/articles/PMC11871798/](https://pmc.ncbi.nlm.nih.gov/articles/PMC11871798/)
    
58. G-quadruplexes and their regulatory roles in biology - Oxford Academic, acessado em junho 22, 2025, [https://academic.oup.com/nar/article/43/18/8627/2414447](https://academic.oup.com/nar/article/43/18/8627/2414447)
    
59. HERC2 facilitates BLM and WRN helicase complex interaction with RPA to suppress G-quadruplex DNA | Request PDF - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/328034281_HERC2_facilitates_BLM_and_WRN_helicase_complex_interaction_with_RPA_to_suppress_G-quadruplex_DNA](https://www.researchgate.net/publication/328034281_HERC2_facilitates_BLM_and_WRN_helicase_complex_interaction_with_RPA_to_suppress_G-quadruplex_DNA)
    
60. Structural mechanisms of human RecQ helicases WRN and BLM - Frontiers, acessado em junho 22, 2025, [https://www.frontiersin.org/journals/genetics/articles/10.3389/fgene.2014.00366/full](https://www.frontiersin.org/journals/genetics/articles/10.3389/fgene.2014.00366/full)
    
61. From R-Loops to G-Quadruplexes: Emerging New Threats for the Replication Fork - MDPI, acessado em junho 22, 2025, [https://www.mdpi.com/1422-0067/21/4/1506](https://www.mdpi.com/1422-0067/21/4/1506)
    
62. Establishing Site-Directed A-to-I RNA Editing in Cell Culture - Universität Tübingen, acessado em junho 22, 2025, [https://publikationen.uni-tuebingen.de/xmlui/bitstream/handle/10900/83827/Promotionsarbeit_Paul_Vogel.pdf?sequence=1&isAllowed=y](https://publikationen.uni-tuebingen.de/xmlui/bitstream/handle/10900/83827/Promotionsarbeit_Paul_Vogel.pdf?sequence=1&isAllowed=y)
    
63. !"#"$%&'(!")*%+( ,-,./,-,0 - MBC UniTo, acessado em junho 22, 2025, [https://www.mbc.unito.it/sites/x027/files/2024-12/mbc_unito_research%20report_2023-2024_V1.pdf](https://www.mbc.unito.it/sites/x027/files/2024-12/mbc_unito_research%20report_2023-2024_V1.pdf)
    
64. Wei Yan (biologist) - Wikipedia, acessado em junho 22, 2025, [https://en.wikipedia.org/wiki/Wei_Yan_(biologist)](https://en.wikipedia.org/wiki/Wei_Yan_\(biologist\))
    
65. Additional Professor | All India Institute Of Medical Sciences, New Delhi, acessado em junho 22, 2025, [https://aiims.php-staging.com/taxonomy/term/413](https://aiims.php-staging.com/taxonomy/term/413)
    
66. OMB No. 0925-0001 and 0925-0002 (Rev. 10/2021 Approved Through 01/31/2026) BIOGRAPHICAL SKETCH NAME: Gina Lee, Ph.D. eRA COMMONS, acessado em junho 22, 2025, [https://bpb-us-e2.wpmucdn.com/sites.uci.edu/dist/6/3973/files/2020/05/Lee_Biosketch_2023Aug.pdf](https://bpb-us-e2.wpmucdn.com/sites.uci.edu/dist/6/3973/files/2020/05/Lee_Biosketch_2023Aug.pdf)
    
67. (PDF) Harnessing self-labeling enzymes for selective and ..., acessado em junho 22, 2025, [https://www.researchgate.net/publication/352915151_Harnessing_self-labeling_enzymes_for_selective_and_concurrent_A-to-I_and_C-to-U_RNA_base_editing](https://www.researchgate.net/publication/352915151_Harnessing_self-labeling_enzymes_for_selective_and_concurrent_A-to-I_and_C-to-U_RNA_base_editing)
    
68. (PDF) Nucleic acid strand displacement – from DNA ... - ResearchGate, acessado em junho 22, 2025, [https://www.researchgate.net/publication/370252603_Nucleic_acid_strand_displacement_-_from_DNA_nanotechnology_to_translational_regulation](https://www.researchgate.net/publication/370252603_Nucleic_acid_strand_displacement_-_from_DNA_nanotechnology_to_translational_regulation)
    
69. In vivo single-cell ribosome profiling reveals cell-type-specific translational programs during aging - bioRxiv, acessado em junho 22, 2025, [https://www.biorxiv.org/content/10.1101/2024.11.02.621639v1.full.pdf](https://www.biorxiv.org/content/10.1101/2024.11.02.621639v1.full.pdf)
    

**