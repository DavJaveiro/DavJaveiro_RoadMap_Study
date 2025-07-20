#flashcards/Mestrado/Introduction-Bioinformatics/4-Archives-And-Information


**Objetivos de Aprendizagem**
- Compreender os tipos gerais de dados que descrevem as moléculas e os processos da vida, reunidos nos bancos de dados que apoiam pesquisas e aplicações em biologia, medicina, agricultura e tecnologia.
- Conhecer a infraestrutura básica da bioinformática, em termos dos sítios e responsabilidades dos principais projetos de arquivamento de dados.
- Entender os conceitos básicos de recuperação de informação, incluindo como formular consultas.
- Desenvolver habilidade com mecanismos de busca gerais na web e com sítios específicos de bioinformática.
- Saber como buscar informações específicas sobre sequências, estruturas, vias metabólicas e relações com doenças, e como iniciar análises dos dados obtidos.

*A capacidade de formular consultas precisas em bancos de dados biológicos é essencial para a análise funcional de genomas e para estudos de associação entre variantes moleculares e fenótipos, especialmente em contextos clínicos e agrícolas.*

Este capítulo introduz habilidades especializadas de recuperação de informações que permitirão a você utilizar de forma eficaz os bancos de dados em biologia molecular. O objetivo é familiarizá-lo com operações básicas. A partir daí, será fácil aprimorar e desenvolver sua técnica, além de aprender em maior detalhe as funcionalidades, inter-relações e interações dos recursos disponíveis na web. Fontes convenientes de materiais de treinamento incluem os tutoriais integrados a muitos bancos de dados. Um exemplo é o site de tutoriais do ENTREZ no Centro Nacional de Informação Biotecnológica dos EUA (NCBI): [http://www.ncbi.nlm.nih.gov/education/tutorials/](http://www.ncbi.nlm.nih.gov/education/tutorials/) . O Instituto Europeu de Bioinformática (EBI) oferece diversos tutoriais sobre vários aspectos de experimentos, bancos de dados e bioinformática.

*O uso integrado de plataformas como NCBI e EBI potencializa a análise comparativa de dados genômicos e facilita a interpretação funcional em contextos evolutivos e translacionais, graças à padronização e interconectividade dos metadados.*

## Indexação de banco de dados e especificação de termos de busca
Um #índice é um conjunto de ponteiros para informações em um bando de dados. Já exploramos toda a web mundial com um mecanismo de busca geral, como o Google, e visitamos bancos de dados especializados em biologia molecular. Você propôs um ou mais termos de busca, e o programa de recuperação verificou sua existência nas tabelas de índices. O modelo adotado é que o banco de dados é composto por entradas: unidades discretas e coerentes de informação. O software identificou entradas cujo conteúdo era relevante para o nosso interesse. Um exemplo do paradigma mais simples é submetermos o termo *cavalo* e o programa retornar uma lista de entradas que contêm o termo "cavalo".
*A indexação eficiente de grandes conjuntos de dados biológicos é fundamental para a aceleração da descoberta funcional, especialmente em genômica comparativa e em estudos de expressão gênica, onde a precisão na recuperação de informações impacta diretamente a interpretação biológica.*

Uma busca completa na web retornaria informações sobre muitos aspectos diferentes de cavalos, biologia molecular, criações, corridas, poemas sobre cavalos, a maioria das quais não desejamos visualizar. Para que uma busca seja bem sucedida, não basta mencionar o que realmente queremos: é necessário especializar a nossa busca, garantindo que os resultados desejados não se percam em meio a uma massa de informações irrelevantes. *A capacidade de restringir e filtrar resultados de busca com operadores booleanos e filtros semânticos reflete diretamente a qualidade da análise em grandes volumes de dados biológicos, como em estudos de variantes genéticas associadas a doenças específicas.*

Para restringir os resultados, programas de recuperação de informações aceitam múltiplos termos de consulta ou palavras-chave. Uma busca por "*horse liver alcohol dehydrogenase*" produziria resultados especializados para esta enzima. A pesquisa provavelmente identificaria entradas que contêm todas as quatro palavras-chave submetidas:
*cavalo*
*fígado*
*álcool*
*desidrogenase*

Poemas sobre cavalos dificilmente apareceriam entre os primeiros resultados.

*O uso de múltiplos termos conectados por operadores lógicos AND melhora a especificidade da busca em bancos de dados genômicos, permitindo a identificação precisa de proteínas ou vias metabólicas com base em critérios moleculares e contextuais.*

É possível solicitar outras combinações lógicas de termos indexados. Por exemplo, se um mecanismo de busca não reconhecesse diferenças ortográficas transatlânticas, seria útil poder buscar por *hemoglobina ou haemoglobina*. Observe que uma busca por “_hemoglobina haemoglobina_ ” provavelmente seria interpretada como “_hemoglobina_ E _haemoglobina_ ”, resultando em documentos escritos por comitês internacionais ou expatriados com variações ortográficas. (Alguns sites incluem deliberadamente ambas as formas, usando um dicionário de sinônimos.) Considerações semelhantes se aplicam a termos como _enxofre_ /_enxofre_ (sulfur/sulphur), por exemplo.

Se quiséssemos informações sobre outras desidrogrenases, poderíamos usar a busca por *desidrogenase NOT alcohol*. Isso recuperaria entradas que contêm o termo desidrogenase, mas não incluiriam a palavra *álcool*. Você encontraria entradas sobre desidrogenase láctica, desidrogenase málica, etc. Porém, perderia referências a artigos de revisão que comparam desidrogenases alcoólicas com outras ou alinhamentos de sequências de várias desidrogenases, incluindo a desidrogenase alcoólica. Talvez você lamentasse essa omissão.

Muitos mecanismos de busca permitem expressões lógicas complexas, como (_haemoglobina_ OU _hemoglobina_ ) E (_desidrogenase_ NÃO _álcool_ ). A construção dessas expressões é um exercício de teoria dos conjuntos. Desenhar diagramas Venn ajuda a formular consultas. Embora a lógica de uma busca seja independente do software usado para consultar um banco de dados, diferentes programas exigem distintas sintaxes distintas para expressar as mesmas condições. Por exemplo, a consulta por desidrogenase NÃO álcool poderia ter de ser inserida como *DESIDROGENASE - ÁLCOOL* OU *DESIDROGENASE!ÁLCOOL*.
*A capacidade de montar consultas com operadores booleanos complexos é crítica para a análise de grandes conjuntos de dados em bioinformática, especialmente na identificação de famílias gênicas ou proteínas com funções específicas em genomas não-modelo.*

Bancos de dados especializados, incluindo os da biologia molecular, impõem uma estrutura sobre as informações para separar diferentes categorias de dados. Isso é essencial. A comunidade científica biomédica inclui pessoas com nomes como E(lisabetta) Coli, (John D.) Levedo, (Patrice) Rato e vários Coelhos, além de algumas Cristais e Blots. Se você quisesse encontrar artigos publicados por esses pesquisadores, seria ingênuo realizar uma busca geral no PubMed ou outro banco de dados molecular usando apenas seus nomes. Muitos bancos de dados permitem indexação e busca separadas em diferentes categorias de informação. Eles possibilitam a busca de artigos dos quais E. Coli é autor.

Certas categorias, como a taxonomia, possuem vocabulários controlados. Muitas vezes, o sistema de busca apresenta os termos do vocabulário como opções em menus suspensos. A estrutura das informações taxonômicas é importante para a recuperação de dados. Para realizar uma busca por “_globina_ NÃO _mamífero_ ” e selecionar as poucas entradas sobre globinas não mamíferas, em vez das muitas sobre globinas (incluindo hemoglobinas humanas) que não mencionam explicitamente o termo _mamífero_ , <span style="background:#affad1">é necessário um sistema de recuperação de informações que “entenda” a hierarquia taxonômica</span>. Vocabulários controlados — conjuntos limitados, explícitos e cuidadosamente definidos de termos, conhecidos como ontologias — também são importantes para distribuir consultas entre vários bancos de dados.
_Insight científico: O uso de vocabulários controlados e ontologias, como a Gene Ontology (GO), permite a integração semântica de dados heterogêneos, essencial para análises funcionais em escala genômica e para a descoberta de novas associações entre genes e fenótipos._

Um problema técnico que frequentemente causa dificuldades é como inserir termos que contenham caracteres não padrão, como acentos, trema, cedilha, letras gregas e, como já mencionado, diferenças entre a ortografia britânica e americana. O ENTREZ do NCBI consegue lidar com diferenças ortográficas entre variantes britânicas e americanas por meio de um dicionário de sinônimos. Programas que indexam toda a web geralmente não fazem isso. Ignore os acentos e espere pelo melhor.

**Pergunta:** Como os operadores lógicos (AND, OR, NOT) influenciam a eficácia de uma busca em bancos de dados biológicos?
?
**Resposta:** Os operadores lógicos permitem refinar consultas e aumentar a **especificidade** ou a **abrangência** da busca:
- **AND** restringe resultados (ex.: _desidrogenase_ E _álcool_ → apenas entradas com ambos os termos).
- **OR** amplia resultados (ex.: _hemoglobina_ OU _haemoglobina_ → captura ambas as variantes ortográficas).
- **NOT** exclui termos indesejados (ex.: _desidrogenase_ NÃO _álcool_ → outras desidrogenases, exceto a alcoólica).
Essa lógica é essencial para evitar resultados irrelevantes e encontrar informações precisas em grandes bases de dados genômicas e moleculares.
<!--SR:!2025-07-22,3,250-->

## Follow-up questions
Ao buscar informações em bancos de dados, raramente encontraremos exatamente o que desejamos na primeira rodada de consultas. Normalmente, é necessário modificar a consulta com base nos resultados inicialmente obtidos. A maioria dos softwares de recuperação de informações permitem buscas consecutivas e cumulativas, com conjuntos alterados de termos de busca e/ou relações lógicas. Por outro lado, uma vez que encontramos o que procuramos, frequentemente desejaremos estender a busca para encontrar material relacionado. <span style="background:#d4b106">Se encontrarmos uma sequência gênica, talvez queiramos saber sobre genes homólogos em outros organismos</span>, ou se há uma estrutura tridimensional da proteína correspondente disponível. Ou ainda, talvez queiramos ler artigos publicados sobre essa sequência. 
*A capacidade de navegar entre sequências gênicas, estruturas tridimensionais e literatura científica reflete a interconectividade essencial em bioinformática, fundamental para estudos de genômica funcional e estrutural, bem como para a medicina de precisão.*

Para essas consultas secundárias, precisamos de links de entradas do mesmo ou de diferentes bancos de dados. Isso ilustra o desafio de como se *navega* em bibliotecas eletrônicas, um problema complexo e tema de pesquisas atuais.

Suponhamos que estejamos interessados em um determinado gene. Para encontrar genes homólogos, gostaríamos de ter links para outros itens no mesmo banco de dados (um banco de dados de sequências gênicas). Para encontrar estruturas ou referências bibliográficas relacionadas a esse gene, desejaríamos ter links entre bancos de dados diferentes (do banco de dados de sequências gênicas para um banco de dados de estruturas tridimensionais, ou para um banco de dados bibliográfico). <span style="background:#d4b106">À medida que o número de bancos de dados e a variedade de seus conteúdos aumentam, a comunicação entre eles tornou-se um objetivo prioritário</span>. De fato, a interatividade entre bancos de dados biológicos está se tornando cada vez mais eficaz, de modo que essas operações são razoavelmente fáceis atualmente, antes, era necessário realizar buscas separadas em bancos de dados isolados. O #ENTREZ do #NCBI permite selecionar um conjunto de bancos de dados para busca. Alternativamente, a maioria das entradas em bancos de dados de biologia molecular contém um grande número de links embutidos. Isso representa uma generalização do modelo original de um banco de dados como um conjunto fechado de entradas independentes que só podem ser selecionadas com base em seus conteúdos indexados. É preciso pensar na web como um espaço de dimensão muito elevada.
*A web de dados biológicos interligados forma uma rede semântica de alta dimensionalidade, cuja exploração depende de padrões de metadados e ontologias bem definidos, essenciais para análises integrativas em sistemas biológicos complexos.*

A construção de bancos de dados em bioinformática envolve atividades que podem ser classificadas, em certa medida, em arquivamento, com os principais objetivos de conservação e curadoria de fatos, e interpretação e anotação, ou seja, a compilação de informações biológicas em uma forma que seja mais útil para apoiar pesquisas. (Inclui-se, dentro da anotação, o fornecimento de links para outros bancos de dados).

Muitos bancos de dados de arquivamento especializam-se em diferentes tipos de dados — sequências de ácidos nucleicos, sequências de proteínas ou estruturas macromoleculares — por razões em parte históricas e em parte devido às diferentes habilidades curatoriais exigidas. Em muitos casos, projetos de arquivamento e interpretação são realizados na mesma instituição e até mesmo pelas mesmas pessoas. No entanto, qualquer pessoa que deseje criar um novo banco de dados é livre para combinar e reempacotar informações provenientes de qualquer fonte disponível. A experiência prática em laboratório e o conhecimento especializado das técnicas experimentais utilizadas para gerar os dados são essenciais para a curadoria de um banco de dados de arquivamento, mas são apenas altamente desejáveis para um banco de dados interpretativo.

Dois aspectos recentes do desenvolvimento de bancos de dados em bioinformática destacam-se. Um é o surgimento de muitos projetos que reúnem os dados arquivados de formas diferentes. O outro é a fusão de muitos bancos de dados individuais em conglomerados cada vez maiores. Esses processos se sobrepõem e, às vezes, ocorrem simultaneamente. A maioria das uniões de bancos de dados é resultado de colaborações anteriores, com graus variáveis de integração no resultado final.

## The archives
Embora nosso conhecimento sobre dados biológicos ainda esteja longe de completo, ele já é de tamanho impressionante e cresce extremamente rápido. Muitos cientistas estão trabalhando para gerar esses dados e realizar projetos de pesquisa que analisem os resultados. Existe um fluxo contínuo e abundante de resultados saindo do laboratório até as organizações responsáveis pelo armazenamento de dados, para arquivamento, curadoria e distribuição aos laboratórios de pesquisa e à clínica. *O crescimento exponencial de dados biológicos reflete a revolução trazida pelas tecnologias de sequenciamento de nova geração (NGS) e pelas abordagens multiômicas, que exigem infraestrutura computacional e análise algorítmica avançada para interpretação eficaz.*

O arquivamento de dados em bioinformática foi originalmente realizado por grupos de pesquisa individuais motivados pelo interesse científico associado. À medida que os requisitos de equipamentos e pessoal aumentaram, e a natureza das habilidades necessárias se multiplicou, com ênfase crescente em ciências da computação, organizações nacionais e, na maioria dos casos, internacionais assumiram a responsabilidade. Para acompanhar o alto volume de produção de dados, esses projetos tornaram-se realmente de grande escala. Qualquer pessoa que tenha acompanhado toda a história do campo não pode deixar de se impressionar com a substituição de pequenos projetos de baixo perfil e com poucos recursos, conduzidos por alguns poucos indivíduos dedicadas, por uma indústria pesada multinacional, sujeita a aquisições hostis e ao equivalente científico de fusões alavancadas. *A profissionalização e institucionalização do arquivamento de dados biológicos reflete a importância crítica dessas bases para a ciência moderna, especialmente na medicina personalizada, na agricultura de precisão e na biotecnologia industrial.*

**Coleções primárias de dados relacionados a macromoléculas biológicas**
- Sequências de ácidos nucleicos, incluindo projetos de genomas completos
- Sequências de aminoácidos de proteínas
- Estruturas de proteínas e ácidos nucleicos
- Estruturas cristalográficas de moléculas pequenas
- Funções de proteínas
- Padrões de expressão gênica
- Redes: de vias metabólicas, de interações entre genes e proteínas, e de cascata de controle
- Publicações

## Nucleic acid sequence databases
O arquivo mundial de sequências de ácidos nucleicos é uma parceria tríplice entre o NCBI (EUA), o European Nucleotide Archive (ou ENA; no EBI, Reino Unido) e o DNA Data Bank of Japan (Instituto Nacional de Genético, Japão). Esses projetos curam, arquivam e distribuem sequências de DNA e RNA coletadas a partir de projetos genômicos, publicações científicas e solicitações de patentes. Os grupos trocam dados diariamente. <span style="background:#b1ffff">Como resultado, os dados brutos são idênticos</span>. No entanto, o formato em que são apresentados e a natureza da anotação variam entre esses bancos de dados. <span style="background:#affad1">Para garantir que esses dados fundamentais estejam livremente disponíveis</span>, as revistas científicas <span style="background:#ff4d4f">exigem o depósito de novas sequências de nucleotídeos</span> como condição para a publicação de um artigo. Condições semelhantes aplicam-se às estruturas de ácidos nucleicos e proteínas.
*A padronização e troca global de dados genômicos entre NCBI, ENA e DDBJ são os pilares da infraestrutura de dados em bioinformática, permitindo análises comparativas e estudos de variação genética em escala planetária, essenciais para epidemiologia molecular e saúde pública.*

Os bancos de dados de sequências de ácidos nucleicos, como distribuídos, são coleções de entradas. Cada entrada tem o formato de um arquivo de texto contendo dados e anotações para uma única sequência contígua. Algumas entradas são montadas a partir de vários artigos que relatam fragmentos sobrepostos de uma sequência completa. Atualmente, é mais comum o depósitos dos resultados de (a) sequenciamento e montagem de genomas completos e (b) sequências de fragmentos, sem montagem, provenientes de amostras metagenômicas.

As entradas possuem uma história de vida. Devido ao desejo da comunidade de usuários por acesso rápido aos dados, novas entradas são disponibilizadas antes da conclusão da anotação e verificação. As entradas amadurecem através das seguintes categorias:
Não anotada -> preliminar -> Não Revisada -> Padrão
*A categorização do ciclo de vida das entradas em bancos de dados genômicos reflete a dinâmica entre a necessidade de disponibilidade imediata de dados e a precisão científica, especialmente relevante em contextos de resposta rápida a surtos epidêmicos ou estudos de genômica ambiental.*

Raramente, uma entrada "morre": algumas poucas são removidas quando se determina que contêm erros.

Uma entrada de exemplo de sequência de DNA do European Nucleotide Archive, incluindo anotações além dos dados da sequência, é o gene **ATP7A** do **aardvark**. Ele codifica uma proteína envolvida na regulação dos níveis de cobre. Mutações no homólogo humano estão associadas à síndrome de Menkes, um distúrbio neurodegenerativo progressivo do metabolismo do cobre.

Uma **tabela de características** (linhas iniciadas com FT) é um componente da anotação de uma entrada que relata propriedades de regiões específicas, por exemplo, sequências codificantes (CDS). O gene **ATP7A** do aardvark contém apenas um único éxon. Como as tabelas de características são projetadas para serem lidas por programas computacionais, por exemplo, para extrair a sequência de aminoácidos, elas têm um formato mais cuidadosamente controlados e um vocabulário mais restrito.
*A padronização das tabelas de características permite a automação na extração e análise funcional de genes, essencial para pipelines de anotação genômica em larga escala e para a integração com bases de dados funcionais, como a Gene Ontology (GO).*

A tabela de características <span style="background:#d3f8b6">pode indicar regiões</span> que:
- desempenham ou afetam a função;
- interagem com outras moléculas;
- afetam a replicação;
- estão envolvidas na recombinação;
- são unidades repetidas;
- possuem estrutura secundária ou terciária;
- foram revisadas ou corrigidas.

```json
ID   AAG47427; SV 1; linear; DNA genômico; STD; MAM; 675 pb.
XX
PA   AY011392.1
XX
DE   Orycteropus afer (aardvark) ATP7A
XX
OS   Orycteropus afer (aardvark)
OC   Eukaryota; Metazoa; Chordata; Craniata; Vertebrata; Euteleostomi; Mammalia;
OC   Eutheria; Afrotheria; Tubulidentata; Orycteropodidae; Orycteropus.
OX   NCBI_TaxID=9818;
XX
FH   Key Location/Qualifiers FH
FT   source          1..675
FT                   /organism="Orycteropus afer"
FT                   /mol_type="DNA genômico"
FT   CDS             AY011392.1:\<1..>675
FT                   /codon_start=1
FT                   /gene="ATP7A"
FT                   /product="ATP7A"
FT                   /db_xref="GOA:Q9BFP6"
FT                   /db_xref="HSSP:Q04656"
FT                   /db_xref="InterPro:IPR001757"
FT                   /db_xref="InterPro:IPR006121"
FT                   /db_xref="UniProtKB/TrEMBL:Q9BFP6"
FT                   /protein_id="AAG47427.1"
FT                   /translation="IYQPHLITVEEIKKQIEAVGFPAFIKKQPKYLTLGAIDIERLKN
FT                   TSARSSEGSLQKSPSYTNDSTATFIIDGMHCKSCVSNIESALSTLQYVSSIAISLENRS
FT                   AIVKYNASSVTPETLRKAIEAVSPGQYTVSIISDVESIPNSPFSSSHQKIPLNIVSQPL
FT                   TQETVINISGMTCNSCVQSIEGVISKKAGVKSVQVSLADSSGVVEYDPLLTSPETLREE
FT                   IEN"
SQ   Sequence 675 BP; 233 A; 136 C; 124 G; 182 T; 0 other; 264016655 CRC32;
     attgtttatc agcctcatct tatcacagta gaggaaataa aaaagcagat tgaagctgtg 60
     ggttttccag cattcatcaa aaaacagccc aagtacctta cattgggagc tattgacata 120
     gaacgtctaa agaacacatc tgccagatcc tcagaaggat cactgcaaaa gagtccatca 180
     tataccaatg attcaacagc cacttttatc atagatggca tgcattgtaa atcatgtgtg 240
     tcaaatattg aaagtgcttt atctacactc caatatgtaa gcagcatagc aatttcttta 300
     gagaataggt ctgccattgt aaaatataat gcaagctcag tcactccaga aaccctgaga 360
     aaggcaatag aggcagtatc accagggcaa tatactgtta gtattataag tgatgttgag 420
     agtatcccaa actctccttt tagctcatct catcaaaaaa tccctttgaa catagtgagc 480
     cagcctctga ctcaagaaac tgtaataaac atcagtggca tgacttgtaa ttcttgtgta 540
     cagtctattg agggtgtcat atcaaaaaag gcaggtgtaa aatccgtaca agtctccctt 600
     gcagatagca gtggagttgt tgaatatgat cctctactaa cctctccaga aaccttgaga 660
     gaagaaatag aaaac 675
     //
```
*A riqueza de metadados e links cruzados em entradas de bancos genômicos, como db_xref e protein_id, permite a integração multidimensional de dados genéticos, estruturais e funcionais, essencial para estudos de genômica translacional e descoberta de alvos terapêuticos.*

- have secondary or tertiary structure;
- are revised or corrected.

**Pergunta:**
Qual das alternativas descreve corretamente a principal característica da cooperação entre NCBI, ENA e DDBJ?
**A)** Cada banco armazena apenas os dados gerados em seu país de origem.
**B)** Eles compartilham os dados semanalmente, com formatos e anotações totalmente idênticos.
**C)** Trocam dados diariamente, resultando em dados brutos idênticos, mas com formatos e anotações que podem variar.
**D)** Cada banco trabalha de forma isolada para evitar conflitos de anotação.
**E)** Os dados não são disponibilizados ao público para evitar duplicação de pesquisas.
?
✅ **Resposta correta:** C
🔍 **Explicação (Verso):**
NCBI (EUA), ENA (Europa) e DDBJ (Japão) trocam os dados diariamente, garantindo que o conteúdo das sequências brutas seja idêntico. No entanto, o modo como as informações são anotadas e apresentadas pode variar entre os três.
<!--SR:!2025-07-24,4,270-->

**Pergunta (Frente):**
Qual é a sequência correta de maturação de uma entrada em bancos de dados de ácidos nucleicos?
**A)** Rascunho → Anotado → Padrão → Arquivado
**B)** Prévia → Verificada → Publicada → Final
**C)** Submetida → Revisada → Valida → Completa
**D)** Não anotada → Anotações Preliminares → Não revisada → Padrão
**E)** Provisória → Curada → Consolidada → Validação final
?
✅ **Resposta correta:** D
🔍 **Explicação (Verso):**
As entradas genômicas passam por um ciclo de amadurecimento. Primeiro são disponibilizadas sem anotação, depois recebem anotações preliminares, passam por revisões e, por fim, tornam-se padrão quando consideradas completas e confiáveis.
<!--SR:!2025-07-23,3,252-->

**Pergunta (Frente):**
Qual é a principal finalidade das tabelas de características (linhas FT) em entradas genômicas?
**A)** Armazenar os dados de sequências cruas, sem anotações.
**B)** Indicar o número de genes presentes em cada cromossomo.
**C)** Fornecer informações de expressão gênica em tecidos específicos.
**D)** Relatar propriedades de regiões específicas da sequência, com vocabulário controlado para uso computacional.
**E)** Descrever as doenças associadas à mutação dos genes presentes na sequência.
?
✅ **Resposta correta:** D
🔍 **Explicação (Verso):**
As linhas FT detalham características como regiões codificantes, estruturas secundárias e locais de interação molecular. São escritas de forma padronizada para permitir interpretação automatizada por programas de bioinformática.
![[Chapter 4 - Archives and information retrieval.png]]
<!--SR:!2025-07-21,1,232-->


## Genomes databases and genomes browsers
Os bancos de dados gerais de ácidos nucleicos focam na coleta de sequências individuais. Associados a muitas sequências completas de genomas, existem navegadores genômicos (*genome browsers*), que reúnem todas as informações moleculares disponíveis sobre uma determinada espécie. 

#Ensembl 
O Ensembl tem como objetivo ser a fonte universal de informações para o genoma humano e de outras espécies. Um dos objetivos é coletar e anotar todas as informações disponíveis sobre sequências de DNA humano, vinculá-las à sequência mestre do genoma e disponibilizá-las para os muitos cientistas que abordarão esses dados sob diferentes perspectivas e com diferentes necessidades. Para isso, além de coletar e organizar as informações, um esforço computacional substancial foi dedicado ao desenvolvimento da infraestrutura, incluindo a definição de convenções de nomenclatura adequadas. Não é trivial criar um esquema que mantenha identificadores estáveis diante de dados que estarão em constante crescimento e revisão. O resultado mais visível desses esforços é o site, rico em funcionalidades tanto para navegação geral quanto para análise detalhada.
*A manutenção de identificadores estáveis em meio a atualizações frequentes do genoma é um desafio crítico para a reprodutibilidade em estudos genômicos, especialmente em contextos clínicos, onde variações podem impactar diagnósticos e terapias baseadas em sequências específicas.*

O Ensembl é um projeto conjunto do **EBI** e do **Wellcome Trust Sanger Institute** . No entanto, o Ensembl é organizado como um projeto aberto, incentivando contribuições externas. Qualquer leitor minimamente experiente reconhecerá que isso impõe grandes exigências sobre os procedimentos de controle de qualidade.

Os dados coletados no Ensembl incluem genes, SNPs, regiões repetidas e homologias. Os genes podem ser conhecidos experimentalmente ou deduzidos a partir da sequência. Como o suporte experimental para a anotação do genoma humano é muito variável, o Ensembl registra e apresenta as evidências para a identificação e anotação de cada gene. Links extensivos com outros bancos de dados que contêm informações relacionadas, como **Online Mendelian Inheritance in Man (OMIM)** ou bases de dados de expressão, ampliam a quantidade de informações acessíveis.
*A integração entre anotação automatizada e evidências experimentais é essencial para a precisão na interpretação genômica, especialmente em variantes raras ou em regiões não codificantes, onde a incerteza é maior.*

O Ensembl e outros navegadores genômicos são estruturados em torno das próprias sequências. Para focar em uma região desejada, os usuário dispõem de várias formas de acesso seletivo ao sistema:
- navegação, começando no nível do cromossomo e depois aumentando o zoom;
- buscas BLAST em uma sequência ou fragmento;
- nome do gene;
- relação com doenças, via OMIM;
- ID do Ensembl, se o usuário o conhecer;
- busca textual geral.

Uma busca textual no navegador do genoma humano do Ensembl pelo termo BRCA1 produziu a página exibida na Figura IV, mostrando a região em torno do locus BRCA1. O quadro superior mostra um megabase, mapeado às bandas q21.2 e q21.31 do cromossomo 17. Ele relata marcadores e genes atribuídos. O quadro inferior mostra uma visão mais detalhada. Observe os painéis de controle entre os dois quadros, que permitem navegação e “zoom”. O quadro inferior mostra uma região de 0,1 megabase, com muitos mais detalhes, incluindo a estrutura detalhada do gene BRCA1 e os SNPs observados.

**Pergunta (Frente):**  
Qual é a principal função dos navegadores genômicos como o Ensembl?
**A)** Calcular automaticamente a expressão gênica em tempo real.  
**B)** Anotar exclusivamente genes codificantes com suporte experimental.  
**C)** Agregar, organizar e disponibilizar informações moleculares completas de uma espécie em torno de sua sequência genômica.  
**D)** Substituir bancos de dados de ácidos nucleicos como o NCBI e ENA.  
**E)** Gerar novas sequências genéticas usando simulações computacionais.
?
✅ **Resposta correta:** C  
🔍 **Explicação (Verso):**  
Navegadores genômicos como o Ensembl organizam dados moleculares (genes, SNPs, regiões repetidas, etc.) ao redor das sequências genômicas completas, facilitando visualizações e análises detalhadas por diversos pesquisadores.
![[Chapter 4 - Archives and information retrieval-1.png]]

**Pergunta (Frente):**  
Qual é um dos principais desafios técnicos enfrentados pelo Ensembl em relação aos dados genômicos?
**A)** Automatizar a transcrição de RNA em proteínas.  
**B)** Padronizar enzimas de restrição para todas as espécies.  
**C)** Manter identificadores estáveis mesmo com atualizações frequentes do genoma.  
**D)** Traduzir sequências diretamente para estruturas tridimensionais.  
**E)** Controlar a duplicação de genes por meio de edição genética.
?
✅ **Resposta correta:** C  
🔍 **Explicação (Verso):**  
Como os dados genômicos estão sempre sendo revisados e expandidos, é um desafio técnico manter identificadores consistentes, algo crucial para garantir a reprodutibilidade e confiança em análises, especialmente clínicas.

**Pergunta (Frente):**  
Qual das opções **não** representa um método de acesso às regiões genômicas no Ensembl?
**A)** Navegação por cromossomos com zoom progressivo  
**B)** Busca por nome do gene  
**C)** Busca textual geral  
**D)** Busca por RNA mensageiro traduzido  
**E)** Busca por ID do Ensembl
?
✅ **Resposta correta:** D  
🔍 **Explicação (Verso):**  
O Ensembl permite diversas formas de acesso às regiões genômicas, mas não é projetado especificamente para buscas diretas por RNAs traduzidos. As buscas comuns envolvem cromossomos, nomes de genes, IDs e relações com doenças.

## Protein Sequence databases
Em 2002, três bancos de dados de sequências de proteínas, o Protein Information Resource (PIR), sediado na **National Biomedical Research Foundation** do **Georgetown University Medical Center** em Washington, DC, EUA; o **SWISS-PROT** e o **TrEMBL**, desenvolvidos pelo **Swiss Institute of Bioinformatics** em Genebra, Suíça, e pelo **EBI** em Hinxton, Reino Unido, uniram seus esforços para formar o **consórcio UniProtKB**. Os parceiros compartilham o banco de dados, mas continuam oferecendo ferramentas independentes de recuperação de informações.

O #PIR surgiu a partir do primeiro banco de dados de sequências, desenvolvido por **Margaret O. Dayhoff**, pioneira no campo da bioinformática. O **SWISS-PROT** foi desenvolvido pelo **Swiss Institue of Bioinformatics**. O TrEMBL contém as traduções dos genes identificados dentro das sequências de DNA do European Nucleotide Archive. As entradas do TrEMBL são consideradas preliminares e são convertidas, após curadoria e anotação estendida, em entradas maduras.
*A convergência de PIR, SWISS-PROT e TrEMBL no UniProtKB reflete a necessidade de integração entre anotação automatizada e curadoria manual para lidar com a complexidade da biologia de proteínas, especialmente em organismos eucarióticos, onde modificações pós-traducionais e processamento do RNA desempenham papéis críticos.*

Hoje, quase toda a informação sobre sequências de aminoácidos provém da tradução de sequências gênicas. No entanto, mesmo a sequência de aminoácidos de uma proteína, em geral, não pode ser inferida com certeza a partir da sequência do gene. 
