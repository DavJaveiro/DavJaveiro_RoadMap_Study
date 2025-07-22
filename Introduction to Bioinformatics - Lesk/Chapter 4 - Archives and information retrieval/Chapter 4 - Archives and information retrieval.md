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
<!--SR:!2025-07-24,3,252-->


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
<!--SR:!2025-07-24,3,250-->

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
<!--SR:!2025-07-24,3,250-->

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
<!--SR:!2025-07-24,3,250-->

## Protein Sequence databases
Em 2002, três bancos de dados de sequências de proteínas, o Protein Information Resource (PIR), sediado na **National Biomedical Research Foundation** do **Georgetown University Medical Center** em Washington, DC, EUA; o **SWISS-PROT** e o **TrEMBL**, desenvolvidos pelo **Swiss Institute of Bioinformatics** em Genebra, Suíça, e pelo **EBI** em Hinxton, Reino Unido, uniram seus esforços para formar o **consórcio UniProtKB**. Os parceiros compartilham o banco de dados, mas continuam oferecendo ferramentas independentes de recuperação de informações.

O #PIR surgiu a partir do primeiro banco de dados de sequências, desenvolvido por **Margaret O. Dayhoff**, pioneira no campo da bioinformática. O **SWISS-PROT** foi desenvolvido pelo **Swiss Institue of Bioinformatics**. O TrEMBL contém as traduções dos genes identificados dentro das sequências de DNA do European Nucleotide Archive. As entradas do TrEMBL são consideradas preliminares e são convertidas, após curadoria e anotação estendida, em entradas maduras.
*A convergência de PIR, SWISS-PROT e TrEMBL no UniProtKB reflete a necessidade de integração entre anotação automatizada e curadoria manual para lidar com a complexidade da biologia de proteínas, especialmente em organismos eucarióticos, onde modificações pós-traducionais e processamento do RNA desempenham papéis críticos.*

Hoje, quase toda a informação sobre sequências de aminoácidos provém da tradução de sequências gênicas. No entanto, mesmo a sequência de aminoácidos de uma proteína, em geral, não pode ser inferida com certeza a partir da sequência do gene. 

## Databases of protein families
As relações evolutivas são essenciais para dar sentido aos dados biológicos. A evolução fornece o quadro conceitual para uma apreciação integrada das propriedades de moléculas e processos, bem como suas similaridades e diferenças em várias espécies. Talvez menos óbvio é que estudos comparativos iluminam, de forma essencial, até mesmo moléculas individuais. Conhecendo apenas uma única sequência ou estrutura, é difícil compreender o significado de certas características. Padrões de conservação identificam características que a natureza julgou necessário preservar. (As assinaturas do PROSITE são um exemplo). *As assinaturas do #PROSITE são padrões conservados de sequências de aminoácidos ou motivos estruturais em proteínas que estão associados a funções biológicas específicas. Elas são usadas para identificar e classificar proteínas em famílias ou domínios estruturais, ajudando a prever a função de uma proteína com base em sua sequência.*

**Características das assinaturas do PROSITE:**
1. Padrões conservados: representam regiões altamente preservadas em proteínas relacionadas, que muitas vezes são críticas para a função ou estrutura da proteína.
2. Motivo de sequência: Podem ser descritos como:
	1. Padrões *patterns*: expressões regulares que definem combinações específicas de aminoácidos em uma sequência.
	2. Perfis (profiles): matrizes de pontuação que avaliam a similaridade de uma sequência a um modelo estatístico.
	3. Marcos (signatures): combinações de motivos que caracterizam uma família de proteínas.
3. **Baseados em funções:** muitas assinaturas estão ligadas a sítios ativos, domínios de ligação a ligantes ou outras regiões funcionais.

**Exemplos de assinaturas do PROSITE**
- O motivo "G-x-G-x-x-G" em #quinases (onde "G" é glicina e "x" é qualquer aminoácido) está associado à ligação de ATP.
- O padrão "[ LIVMF ]-G-E-x-[GAS]-[LIVM]-x(5,11)-R-[STAQ]-A-x-[LIVMA]-x-[STACV]" é típico da enzima #serina #protease.

**Importância**
- Anotação funcional: permitem inferir a função de proteínas não caracterizadas.
- Classificação: agrupam proteínas em famílias evolutivas ou funcionais.
- Descoberta de alvos terapêuticos: Motivos conservados podem indicar sítios importantes para drogas.
Portanto, o #PROSITE é um banco de dados de domínios proteicos, famílias e motivos funcionais, integrado ao #ExPASy (Expert Protein Analysis System). Suas assinaturas são ferramentas valiosas em bioinformática e biologia estrutural para entender a relação entre sequência, estrutura e função.

*A identificação de padrões conservados em famílias de proteínas é fundamental para a inferência funcional em genômica comparativa, especialmente para proteínas com função desconhecida, onde a conservação de motivos específicos pode sugerir atividade enzimática ou interações moleculares.*

O estudo de padrões evolutivos deve começar com a montagem de um conjunto de #homólogos. Ressaltamos novamente:
1. a distinção entre #homologia - descendência de um ancestral comum, uma propriedade binária (sim/não), e #similaridade, uma medida quantitativa da diferença entre dois objetos;
2. que a similaridade pode sempre ser medida, mas é raro observa a homologia diretamente; portanto, na maioria dos casos, a homologia é uma **inferência a partir da similaridade**.

R. Doolittle propôs uma calibração geral da similaridade de sequências para detecção de homologia. **Duas sequências completas (>= 100 resíduos) que compartilham 25% ou mais de identidade em um alinhamento ótimo, provavelmente são relacionadas. Abaixo de cerca de 15% de identidade em um alinhamento ótimo, entremos em um campo de ruído.** Nessa faixa de similaridade, não temos razão para acreditar que as sequências sejam relacionadas, embora possam ser. Doolittle definiu a faixa entre 18 e 25% de identidade como "a zona crepuscular", onde pode haver suspeitas tentadoras de uma relação, mas a evidência não é conclusiva. Em alguns casos, o **sítio ativo** é melhor conservado do que a maior parte da proteína. Nesses casos, o aparecimento de um **motivo**, como o padrão consenso do PROSITE para a inorgânica #pirofosfatase **D-[SGDN]-D-[PE]-[LIVMF]-D-[LIVMGAC]** — pode apoiar o caso para #homologia.

**Alinhamentos múltiplos de sequência** são muito mais poderosos do que alinhamento de pares. Primeiro, os dados adicionais permitem alinhamentos mais precisos. Segundo, os padrões de conservação se destacam muito mais claramente. 

<span style="background:#fff88f">A estrutura de proteínas muda de forma mais conservativa do que a sequência de aminoácidos.</span> Portanto, a inferência de homologia a partir da **similaridade estrutural** pode ligar parentes mais distantes do que a **similaridade de sequência** consegue. Em casos que estão na **zona crepuscular**, onde a similaridade de sequência é sugestiva, mas não convincente, a similaridade estrutural é o tribunal de última instância. Em muitos casos, a similaridade estrutural pode identificar homólogos mesmo quando **nenhum sinal**, pelo menos detectável pelas técnicas atuais, permanece nas sequências.

É comum referir-se a um grupo de proteínas relacionadas como uma **família**. Muitos bancos de dados classificam proteínas em famílias. Estes incluem bancos orientados por sequência, como #InterPro, #Pfarm e #COG, e bancos orientados por estrutura, como #SCOP e #CATCH. A atribuição de proteínas a famílias é semelhante, mas não idêntica, em diferentes fontes.

A maioria das famílias de proteínas contém muitos agrupamentos de parentes mais próximos. Esses formam subfamílias. Inversamente, duas ou mais famílias podem ser agrupadas em **superfamílias**. Enquanto a distinção entre proteínas homólogas e não homólogas é objetiva (mesmo que nem sempre possamos determiná-la com confiança), o agrupamento de homólogos em subfamílias ou superfamílias é parcialmente uma questão de convenção ou gosto. A definição de subfamílias e superfamílias pode legitimamente diferir entre diferentes bancos de dados.

**Pergunta (Frente):**
Qual é a principal função das assinaturas no banco de dados PROSITE?
**A)** Determinar a estrutura tridimensional exata de uma proteína.
**B)** Realizar simulações moleculares em tempo real.
**C)** Identificar e classificar proteínas com base em padrões conservados ligados à função.
**D)** Produzir proteínas recombinantes em larga escala.
**E)** Prever mutações espontâneas em genes codificadores.
?
✅ **Resposta correta:** C
🔍 **Explicação (Verso):**
As assinaturas do PROSITE são padrões conservados de sequência ou estrutura usados para reconhecer famílias ou domínios funcionais, auxiliando na previsão da função de proteínas com base na sequência.
<!--SR:!2025-07-24,3,250-->

**Pergunta (Frente):**
Segundo R. Doolittle, qual nível de identidade entre duas sequências (≥ 100 resíduos) é geralmente considerado indicativo de homologia?
**A)** Acima de 50%
**B)** Acima de 35%
**C)** Acima de 25%
**D)** Abaixo de 15%
**E)** Exatamente 18%
?
✅ **Resposta correta:** C
🔍 **Explicação (Verso):**
Para sequências com pelo menos 100 resíduos, uma identidade de 25% ou mais em um alinhamento ótimo é considerada evidência forte de homologia, segundo a calibração de Doolittle.
<!--SR:!2025-07-24,3,250-->

**Pergunta (Frente):**
Por que a similaridade estrutural pode ser mais confiável que a sequencial na identificação de homologia?
**A)** Porque estruturas são mais fáceis de serem comparadas do que sequências.
**B)** Porque a estrutura de proteínas muda de forma mais conservadora que a sequência.
**C)** Porque os dados de estrutura estão sempre mais atualizados.
**D)** Porque a estrutura permite prever diretamente a expressão gênica.
**E)** Porque proteínas não sofrem mutações estruturais.
?
✅ **Resposta correta:** B
🔍 **Explicação (Verso):**
Como a estrutura de proteínas é mais conservada evolutivamente do que sua sequência de aminoácidos, a similaridade estrutural pode revelar relações evolutivas ocultas em casos de baixa identidade de sequência — como na “zona crepuscular”.
<!--SR:!2025-07-24,3,250-->

## Bancos de dados de estruturas
Os bancos de estruturas arquivam, anotam e distribuem conjuntos de **coordenadas atômicas**. Iniciado pelo falecido **Walter Hamilton** no Brookhaven National Laboratories (EUA) em 1971, o principal banco de dados para estruturas de macromoléculas biológicas é agora o **Worldwide Protein Data Bank (wwPDB)**. É um esforço conjunto do **Research Collaboratory for Structural Bioinformatics (RCSB)**, uma organização descentralizada sediada na Rutgers Universite (Nova Jersey), no San Diego Supercomputer Center (Califórnia) e na Universidade de Wisconsin (EUA), do Protein Data Bank Europe (no EBI, Reino Unido) e do Protein Data Bank Japan (na Osaka University, Japão). O wwPDB contém estruturas de proteínas, ácidos nucleicos e alguns carboidratos. 

As páginas iniciais dos parceiros do wwPDB contêm links para os arquivos de dados, material explicativo e tutoriais, incluindo notícias curtas e a **PDB Newsletter** , além de ferramentas especializadas para depósito de novas entradas e software de busca estrutural.

O **Quadro 4.2** mostra parte de uma entrada do Protein Data Bank para uma estrutura da **tiorredoxina do cloroplasto de espinafre** . As informações incluem:
- qual proteína é o objeto da entrada e de qual espécie ela veio;
- quem resolveu a estrutura e referências bibliográficas;
- detalhes experimentais sobre a determinação da estrutura, incluindo informações relacionadas à qualidade geral do resultado, como a **resolução** em determinações por raios X e estatísticas esteroquímicas.
- a sequência de aminoácidos
- as coordenadas atômicas (linhas iniciadas com ATOM);
- quais moléculas adicionais aparecem na estrutura, potencialmente incluindo cofatores, inibidores e moléculas de água (a palavra-chave HETATM identifica as coordenadas dessas entidades);
- atribuições de estrutura secundária: hélices e folhas beta;
- pontes dissulfeto.

O #PDB se sobrepõe a vários outros bancos de dados. O **Cambridge Crystallographic Data Centre (CCDC)** arquiva estruturas de moléculas pequenas; #oligonucleotídeos aparecem tanto no CCDC quanto no PDB. A combinação de dados estruturais dessas fontes é extremamente útil em estudos de conformações das unidades componentes de macromoléculas biológicas e em investigações de interações macromolécula-ligante, incluindo, mas não limitado a, aplicações no **design de medicamentos**.

O **Nucleic Acid Structure Databank (NDB)** na Rutgers University também complementa o PDB. O **BioMagResBank**, no Departamento de Bioquímica da Universidade de Wisconsin, um parceiro do RCSB, arquiva estruturas de proteínas determinadas por **ressonância magnética nuclear (NMR)**.

Os arquivos coletam não apenas os resultados da determinação estrutural, mas também as **medicições em que se baseiam.** o wwPDB mantém os dados de determinações por raios X e **BioMagResBank**, os de NMR.
*A integração entre dados experimentais brutos e estruturas depositadas no wwPDB e BioMagResBank é essencial para a validação rigorosa de modelos estruturais, particularmente em contextos de modelagem preditiva e estudos de dinâmica molecular*.

## Classifications of protein structures
Vários sites oferecem classificações hierárquicas de todas as proteínas cuja estrutura é conhecida, com base em seus padrões de dobramento (folding).
- #SCOP: classificação estrutural de proteínas (Structural Classification of Proteins);
- #CATH: Classe/Arquitetura/Topologia/Homologia
- #DALI: baseado na extração de estruturas similares a partir de matrizes de distância;
- #CE: um banco de dados de alinhamentos estruturais.

Esses sites são úteis como **pontos de entradas gerais aos dados estruturais de proteínas**. Por exemplo, o SCOP oferece ferramentas de busca por palavras-chave para identificar estruturas, navegação ascendente e descendente na hierarquia, geração de imagens, acesso aos registros de anotação nas entradas do PDB e links para bancos de dados relacionados.

*A classificação estrutural hierárquica, como a do SCOP e CATH, permite a identificação de relações evolutivas profundas entre proteínas que podem não ter similaridade de sequência, mas compartilham dobras comuns, essencial para a inferência funcional em proteômica estrutural.*

## Precisão e exatidão na determinação da estrutura proteica
*Cristalografia de Raios X*
A crystalografia de raios X produz estimativas das posições dos átomos em uma molécula. Ela também fornece estimativas de seus tamanhos efetivos, chamados de **fatores B**. Um aspecto importante dos dados experimentais (geralmente medidos são os valores absolutos dos coeficientes de Fourier da densidade eletrônica) é que todos os átomos contribuem para todas as observações. É difícil estimar erros nas posições individuais dos átomos. Para moléculas pequenas, que formam cristais bem ordenados, os fatores B refletem as amplitudes de vibração térmica. Para estruturas cristalinas de proteínas, os fatores B são um índice útil da precisão das posições dos átomos individuais. No entanto, os fatores B para proteínas não reportam exclusivamente as amplitudes de vibração, mas incluem contribuições da variabilidade conformacional. (Um colega que leu essa página em rascunho comentou sombriamente que, para muitas determinações de estrutura proteica, os fatores B "ocultam muitos pecados"). De fato, as determinações de estrutura cristalina estão à mercê do grau de ordem em diferentes partes da molécula. (Ordem refere-se ao quanto diferentes células unitárias do cristal são cópias exatas e estáticas uma da outra). O grau de ordem governa a resolução disponível dos dados experimentais.
*A interpretação dos fatores B em cristais de proteínas é complexa, pois eles incorporam tanto informações sobre a mobilidade térmica quanto sobre a variabilidade conformacional, tornando-os indicadores importantes, mas ambíguos, da qualidade da determinação.*

A resolução é um índice da qualidade potencial de uma determinação por raios X, medindo a razão entre o número de parâmetros a serem determinados e o número de observações. Em determinações de estruturas de pequenas moléculas orgânicas ou minerais, essa razão geralmente é generosa, aproximadamente 10. Mas para um cristal típico de proteína:
- A resolução mede a finura dos detalhes que podem ser distinguidos; portanto quanto menor o número, maior a resolução.

Além da desordem, os erros nas estruturas cristalinas refletem tanto erros na medição dos dados quanto no processo de solução de estrutura. Uma comparação de quatro estruturas independentemente resolvidas do interleucina-1β mostrou uma variação média na posição dos átomos de 0,84Å, superior ao erro experimental esperado. Muitos cristalografistas depositam seus dados experimentais juntamente com as estruturas resolvidas. Isso permite verificações detalhadas dos resultados. No entanto, em muitos casos, os dados experimentais não estão disponíveis. Como então avaliar a qualidade de uma estrutura? Os fatores B fornecem pistas importantes; altos fatores B em uma região inteira sugerem que aquela região não foi bem determinada. Isso geralmente reflete uma ordem imperfeita no cristal. Programas podem sinalizar outliers estereoquímicos: exceções às regularidades comuns em estruturas proteicas bem determinadas. As entradas correspondentes às entradas do PDB descrevem análises diagnósticas e identificação de problemas e outliers.

_Insight científico: A disponibilidade dos fatores B e dos outliers estereoquímicos é essencial para a avaliação crítica de estruturas proteicas, mas decisões definitivas sobre sua qualidade exigem acesso aos dados experimentais brutos, reforçando a necessidade de arquivamento e disponibilização desses dados._

No entanto, embora os outliers sejam relativamente fáceis de detectar, é difícil decidir se eles representam características corretas, mas incomuns, da estrutura, ou se resultam de erros no modelo construído, ou ainda se são consequências inevitáveis da desordem no cristal. Uma avaliação adequada requer acesso aos dados experimentais; e corrigir erros reais pode exigir a atenção de um cristalografista experiente. Parece inescapável concluir que os fatores de estrutura devem ser arquivados e acessíveis.

**Frente (Pergunta):**  
**Qual das alternativas descreve corretamente o papel dos fatores B em estruturas proteicas obtidas por cristalografia de raios X?**
A) Representam exclusivamente os erros instrumentais durante a coleta dos dados.  
B) Medem apenas a mobilidade térmica dos átomos na estrutura.  
C) Indicam a variabilidade conformacional e mobilidade térmica, sendo úteis mas ambíguos.  
D) Servem como unidade de medida da resolução estrutural.
?
**Resposta correta: C)** Indicam a variabilidade conformacional e mobilidade térmica, sendo úteis mas ambíguos.  
_Explicação:_ Os fatores B refletem tanto vibrações térmicas quanto desordem conformacional. Assim, embora úteis para avaliar regiões mal definidas da estrutura, sua interpretação é complexa e pode ocultar problemas estruturais.

**Em uma estrutura cristalina de proteína, o que indica um valor consistentemente alto de fator B em uma determinada região?**
A) Alta confiabilidade estrutural e ordenamento cristalino.  
B) Mobilidade térmica nula e baixa variabilidade conformacional.  
C) Possível desordem ou baixa confiabilidade na determinação estrutural local.  
D) Presença de ligação covalente entre resíduos adjacentes.
?
**Resposta correta: C)** Possível desordem ou baixa confiabilidade na determinação estrutural local.  
_Explicação:_ Altos fatores B em uma região indicam baixa ordem ou variabilidade conformacional, sugerindo que aquela parte da estrutura pode não ter sido bem determinada.

**Sobre a resolução em cristalografia de proteínas, qual das opções é verdadeira?**
A) Uma resolução de 3,0 Å é mais detalhada que uma de 1,2 Å.   
B) A resolução está diretamente relacionada ao grau de ordem do cristal. 
C)A resolução aumenta quando há menos observações do que parâmetros.  
D) Resolução e fator B são sinônimos e intercambiáveis.
?
**Resposta correta: B)** A resolução está diretamente relacionada ao grau de ordem do cristal.  
_Explicação:_ Quanto maior a ordem no cristal, mais detalhes podem ser resolvidos, ou seja, menor é o valor numérico da resolução e melhor é a qualidade estrutural obtida.

*Nuclear Magnetic resonance*
A ressonância magnética nuclear (NMR) é a segunda técnica principal para a determinação de estruturas macromoleculares. Produz estruturas corretas em termos de topologia, mas frequentemente não tão precisas quanto uma boa determinação por cristalografia de raios X. Os cristalógrafos relatam um única estrutura ou apenas um pequeno número delas. Já os espectroscopistas de NMR geralmente produzem um conjunto de cerca de 10 a 20 estruturas relacionadas, ou até mais, calculadas a partir dos mesmos dados experimentais. A comparação entre essas estruturas indica a precisão: as regiões onde a variação local é pequena são bem definidas pelos dados. Isso equivale, de forma aproximada, ao fator B usado pelos cristalógrafos.

Existem duas fontes de variação estrutural entre os modelos reportados pelos espectroscopistas de NMR. Uma é a **desordem dinâmica real**, que ocorre porque a conformação não está fixa pelas forças de empacotamento cristalino. A outra é uma razão **desconfotavelmente baixa** entre o número de medições e os parâmetros que precisam ser determinados. Como resultado, várias conformações diferentes podem explicar os dados experimentais de forma igualmente plausível.

A análise dos dados de NMR pode distinguir esses efeitos, mas isso é realizado apenas numa minoria das determinações estruturais de proteínas por NMR.

## Bancos de dados especializados, ou "boutique"
Muitos indivíduos ou grupos selecionam, anotam e recompilam dados focados em tópicos específicos, incluindo links que permitem um acesso simplificado a informações sobre assuntos de interesse. Por exemplo, o **repositório de cinases protéicas** é uma compilação especializada que inclui sequências, estruturas, informações funcionais, procedimentos laboratoriais, listas de cientistas interessados, ferramentas de análise, um quadro de avisos e ligações externas.

O banco de dados da #protease do HIV arquiva estruturas das proteinases do vírus da imunodeficiência humana 1 (HIV-1), do vírus da imunodeficiência humana 2 (HIV-2) e do vírus da imunodeficiência dos símios (SIV), bem como os seus complexos, oferecendo também ferramentas para a sua análise e ligações para outros sites com informações relacionadas à SIDA. Este banco contém algumas estruturas cristalinas que não foram depositadas no PDB.

No campo da imunologia:

- **IMGT** , o banco internacional de imunogenética, é um repositório integrado e de alta qualidade especializado em imunoglobulinas (Ig), recetores de células T (TcR) e moléculas do complexo principal de histocompatibilidade (MHC) de todas as espécies de vertebrados. O servidor IMGT oferece acesso comum a todos os dados de imunogenética. Inclui o IMGT/LIGM-DB, um banco de dados abrangente de sequências de genes de imunoglobulinas e TcR de humanos e outros vertebrados, com traduções para sequências totalmente anotadas, e o IMGT/MH-DB, um banco de dados do MHC humano, ou antígenos leucocitários humanos (HLA). Veja [http://www.imgt.org](http://www.imgt.org/) .
    
- **IEDB** , o Banco de Dados e Recurso de Epitópios Imunológicos, gerido pelo Instituto de Alergia e Imunologia de La Jolla, contém dados relacionados a epitópios de anticorpos e de células T. Veja [http://www.iedb.org](http://www.iedb.org/) .
    
- **DIGIT** , o Banco de Dados de Imunoglobulinas com Ferramentas Integradas, reúne sequências anotadas dos domínios variáveis de imunoglobulinas e ferramentas para a sua análise. Veja [http://biocomputing.it/](http://biocomputing.it/) .
    
- O site [http://www.antibodyresource.com/antibody-database.html](http://www.antibodyresource.com/antibody-database.html) lista 19 diferentes sites com informações relacionadas a bancos de dados e software sobre anticorpos.

## Bancos de dados de expressão e proteómica
Lembre-se do dogma central: o DNA origina o RNA, que por sua vez origina as proteínas. Os bancos genômicos contém sequências de DNA. Os bancos de expressão registram medições dos níveis de mRNA. Alguns registram etiquetas de sequência expressas (ESTs), sequências curtas terminais de cDNA sintetizado a partir de mRNA, descrevendo padrões de transcrição genética. Os bancos de proteómica registram medições sobre proteínas, descrevendo padrões de tradução genética.

As comparações dos padrões de expressão fornecem pistas sobre:
1. A função e o mecanismo de ação dos produtos gênicos;
2. Como os organismos coordenam o controle dos seus processos metabólicos em diferentes condições (por exemplo, leveduras em condições aeróbicas ou anaeróbicas);
3. As variações na ativação dos genes em diferentes estágios do ciclo celular ou do desenvolvimento de um organismo;
4. Os mecanismos de resistência a antibióticos em bactérias e, consequentemente, sugestões de alvos para o desenvolvimento de medicamentos;
5. A resposta a uma infecção por um parasita;
6. A resposta a medicamentos de diferentes tipos de dosagens, para orientar uma terapia eficaz.

Existem muitos bancos de dados de ESTs. Na maioria deles, as entradas contêm campos que indicam o tecido de origem e/ou localização subcelular, o estado de desenvolvimento, as condições de crescimento e a quantificação do nível de expressão. No GenBank, a coleção dbEST contém atualmente mais de 74 milhões de entradas, provenientes de 2551 espécies, lideradas pelas da Tabela 4.1.

 **Tabela 4.1 – Espécies com maior número de entradas no dbEST**
Homo sapiens - 8.704.790
Mus musculus + domesticus (rato) - 4.853.570
Zea mays (milho) - 2.019.137

Algumas coleções de ESTs são especializadas em tecidos específicos (por exemplo, músculo, dente) ou em espécies. Em muitos casos, existe o esforço de ligar os padrões de expressão ao conhecimento geral do organismo. Por exemplo, o Projeto de Recursos de Informação sobre Expressão Gênica do Jackson Lab para o Desenvolvimento do Rato coordena dados sobre expressão genética e anatomia do desenvolvimento.

Muitos bancos de dados estabelecem ligações entre ESTs de diferentes espécies, por exemplo, entre genes homólogos humanos e de rato, ou entre genes humanos associados a doenças e proteínas de leveduras. Outras coleções de ESTs são especializadas em tipos específicos de proteínas, como citocinas. Um grande esforço tem sido direcionado ao estudo do cancro: integrando informações sobre mutações, rearranjos cromossômicos e alterações nos padrões de expressão, com o objetivo de identificar as mudanças durante a formação e progressão do tumor.

Embora exista uma relação estreita entre os padrões de transcrição e os de tradução, as medições diretas dos conteúdos proteicos em células e tecidos, a proteômica, fornece informações valiosas adicionais. Devido às taxas diferenciadas de tradução e degradação dos diferentes mRNAs, as medições diretas de proteínas fornecem uma descrição mais precisa dos padrões de expressão genética do que as medições de transcrição. Modificações pós-traducionais só podem ser detectadas ao examinar diretamente as proteínas. 

A análise proteômica envolve a separação, identificação e determinação quantitativa das proteínas presentes na amostra. Os bancos de proteômica armazenam imagens de géis e a sua interpretação em termos de padrões proteicos. Para cada proteína, uma entrada tipicamente registra:
- Identificação da proteína;
- Quantidade relativa;
- Função;
- Mecanismo de ação;
- Padrão de expressão;
- Localização subcelular;
- Proteínas relacionadas;
- Modificações pós-traducionais;
- Interações com outras proteínas;
- Ligações a outros bancos de dados.

## Bibliographics databases
O #Medline (com sede na Biblioteca Nacional de Medicina dos EUA) integra a literatura médica, incluindo um grande número de artigos sobre temas de biologia molecular que não têm conteúdo clínico explícito. Está integrado no PubMed, um banco de dados bibliográfico que disponibiliza resumos de artigos científicos, combinado com outras ferramentas de recuperação de informação do NCBI, da Biblioteca Nacional de Medicina.

Outra funcionalidade muito eficaz do PubMed é a opção de **recuperar artigos relacionados**. Esta é uma forma rápida de se introduzir na literatura sobre um determinado tema. Em combinação com o uso de um moto de busca geral para aceder a sites que não correspondem a artigos publicados em revistas científicas, torna-se fácil obter informações bastante abrangentes sobre a maioria dos temas. Aqui vai uma dica: se estiver a tentar começar a aprender sobre um assunto desconhecido, experimente adicionar a palavra-chave **tutorial** à sua pesquisa num motor de busca geral, ou a palavra-chave **review** à sua pesquisa no PubMed.

Atualmente, quase todas as revistas científicas disponibilizam os seus índices e, em muitos casos, edições completas em sítios *web*. Os **Institutos Nacionais de Saúde dos EUA** criaram uma biblioteca centralizada baseada na web de artigos científicos, denominada PubMed Central. Em colaboração com revistas científicas, o NCBI está a organizar a distribuição eletrônica dos textos completos dos artigos publicados.
*A integração entre bases bibliográficas como o PubMed e repositórios de acesso aberto como o PubMed Central permite uma exploração eficiente e sistemática da literatura biomédica, essencial para revisões sistemáticas, meta-anaálises e investigação translacional.*

### Inventários de bases de dados e servidores em biologia molecular
É muito comum encontrar listas de recursos *web* em biologia molecular. É difícil explorar qualquer tema nesta área na internet sem rapidamente deparar com uma lista deste tipo. Embora contenham, em grande parte, a mesma informação, diferem amplamente no seu aspecto e usabilidade. O problema real é que, se não forem devidamente curadas, tendem a degenerar em listas de hiperligações inativas. Um racunho desta secção incluía uma referência a um sítio que apresentava um levantamento razoável; ao regressar dois meses depois, o nome do sítio tinha mudado e mais de metade das ligações já não funcionavam.

Este livro não inclui uma longa lista anotada de sítios recomendados por duas razões: (1) o leitor não precisa de uma lista longa, mas sim de uma seleção breve e eficaz, e (2) a web é demasiado volátil para que tal lista permaneça útil por muito tempo. É muito mais eficaz recorrer a um motor de busca geral para encontrar aquilo de que se necessita, exatamente quando é necessário.

A minha recomendação é a seguinte: dedique algum tempo à navegação — não lhe levará muito tempo encontrar um sítio que pareça razoavelmente estável e cujo estilo se adeque ao seu modo de trabalhar. Alternativamente, o sítio **ExPASy** (ver a secção sobre o Instituto Suíço de Bioinformática) é abrangente e demonstra um compromisso claro em manter-se atualizado e completo.
*A volatilidade dos recursos online reforça a importância de utilizar ferramentas dinâmicas e interconectadas, como os portais integrados, que atuam como hubs funcionais na rede de dados biológicos, garantindo sustentabilidade e interoperabilidade em ambientes de investigação em rápida evolução.*

## Portais de acesso aos arquivos
Os bancos de dados em biologia molecular disponibilizam funcionalidades para uma grande variedade de operações de recuperação e análise de informação. As categoriais destas operações incluem as seguintes:
1. **Recuperação de sequências a partir de uma base de dados**. As sequências podem ser obtidas com base em características das anotações ou em padrões identificados dentro das próprias sequências.
2. **Comparação de sequências:** Isto não é apenas uma funcionalidade, é uma indústria intensiva! Foi introduzida no Capítulo 1 e será discutida em detalhe no Capítulo 5. Inclui pesquisas muito importantes para detectar sequências relacionadas #homólogas.
3. **Identificação de genes em sequências genômicas** e traduções de sequências codificadoras de proteínas nas respectivas sequências de aminoácidos.
4. **Tipos simples de análise e predição estrutura**, por exemplo, métodos estatísticos para prever a estrutura secundária de proteínas apenas a partir da sequência, como perfis de hidrofobicidade, através dos quais é geralmente possível identificar proteínas #transmembranares. Outros sítios oferecem predições completas de estruturas tridimensional a partir de sequência.
5. **Reconhecimento de padrões**, é possível procurar todas as sequências que contêm um determinado padrão ou combinação de padrões, expressos como probabilidades de encontrar certos conjuntos de resíduos em posições consecutivas. Estes padrões podem estender-se por grandes regiões da sequência e refletem frequentemente o padrão global de dobramento da proteína. Outros são curtos: em sequências de DNA, podem corresponder a locais de reconhecimento para enzimas, como as responsáveis pelo #splicing de genes interrompidos. Em proteínas, padrões curtos e localizados identificam geralmente moléculas com função comum.
6. **Gráficos moleculares**, necessários para representar de forma inteligível sistemas altamente complexos. Aplicações típicas incluem:
	1. fornecer uma impressão geral útil do padrão de dobramento de uma proteína;
	2. mapear resíduos suscetíveis de estar envolvidos na função sobre a estrutura tridimensional da proteína, o que frequentemente permite isolar o sítio ativo;
	3. classificar e comparar os padrões de dobramento de proteínas;
	4. analisar diferenças entre estruturas estreitamente relacionadas ou entre dois estados conformacionais de uma mesma molécula.
	5. estudar a interação entre uma pequena molécula e uma proteína, com vista à atribuição de função ou ao desenvolvimento de fármacos;
	6. ajuste interativo de um modelo à imagem ruidosa e difusa da molécula obtida inicialmente durante a resolução de estruturas proteicas por cristalografia de raios X;
	7. desenho e modelação de novas estruturas.

*A integração de múltiplas funcionalidades em portais como o ExPASy ou o NCBI reflete a natureza sistêmica da bioinformática moderna, onde a capacidade de transitar entre sequência, estrutura, função e interação é essencial para a descoberta biológica orientada por dados.*

## Access to databases in molecular biology
*How to learn web skills*
Seria difícil aprender a andar de bicicleta apenas lendo um livro que descreve os movimentos necessários, muito menos um tratado sobre a teoria do giroscópio. Da mesma forma, o lugar ideal para aprender competências na web é diante de um terminal, a utilizar um navegador. É verdade, mas existe sempre um período inicial de dificuldade e instabilidade. O objetivo aqui é apenas oferecer alguma ajuda provisória para ajudar a começar. 
Esta seção apresenta uma introdução a algumas principais bases de dados e sistemas de recuperação de informação em biologia molecular. Em cada caso, as ilustrações mostram pesquisas e aplicações relativamente simples. Sempre, serão destacadas funcionalidades únicas de cada sistema.

#ENTREZ 
O NCBI mantém bases de dados e formas de acesso a elas. O ENTREZ oferece acesso através de 35 divisões de bases de dados.
 **Tabela 4.2 – Sistema de bases de dados ENTREZ do NCBI**

|**Nome**|**Conteúdo**|
|---|---|
|Nucleotide|Subconjunto principal de registos de sequências de nucleótidos|
|EST|Registos de_Expressed Sequence Tags_|
|GSS|Registos de_Genome Survey Sequences_|
|Protein|Base de dados de sequências proteicas|
|Genome|Sequências completas de genomas|
|Structure|Estruturas tridimensionais de macromoléculas|
|Taxonomy|Organismos no GenBank|
|SNP|Variações genéticas curtas|
|dbVar|Variações estruturais genómicas|
|Gene|Informação centrada em genes|
|SRA|Arquivo de Leituras de Sequência (_Sequence Read Archive_)|
|BioSystems|Vias metabólicas e sistemas de moléculas interativas|
|HomoloGene|Grupos de homologia em eucariotas|
|OMIM|Herança Mendeliana em Humanos (_Online Mendelian Inheritance in Man_)|
|OMIA|Herança Mendeliana em Animais (_Online Mendelian Inheritance in Animals_)|
|Probe|Reagentes específicos por sequência|
|BioProject|Dados agregados de projetos de investigação biológica|
|dbGaP|Genótipos e fenótipos|
|UniGene|Agrupamentos orientados por gene de sequências de transcritos|
|CDD|Base de dados de domínios proteicos conservados|
|Clone|Dados integrados sobre recursos de clones|
|UniSTS|Marcadores e dados de mapeamento genético|
|PopSet|Conjuntos de dados de estudos populacionais|
|GEO Profiles|Perfis de expressão e abundância molecular|
|GEO DataSets|Conjuntos experimentais de dados do_Gene Expression Omnibus_(GEO)|
|Epigenomics|Mapas e conjuntos de dados epigenéticos|
|PubChem BioAssay|Ensaios de bioatividade de substâncias químicas|
|PubChem Compound|Estruturas químicas únicas de pequenas moléculas|
|PubChem Substance|Registos depositados de substâncias químicas|
|Protein Clusters|Coleção de sequências proteicas relacionadas|
|BioSample|Descrição de material biológico|
|PubMed|Citações e resumos da literatura biomédica|
|PubMed Central|Artigos científicos completos em acesso aberto|
|Site Search|Pesquisa nos sites web e FTP do NCBI|
|Books|Livros científicos online|
Para ver um diagrama com todas as bases de dados ENTREZ e as suas interligações, visite:  
[http://www.ncbi.nlm.nih.gov/Database/datamodel/index.html](http://www.ncbi.nlm.nih.gov/Database/datamodel/index.html?spm=a2ty_o01.29997173.0.0.5810c92122itUD)

A integração entre as diversas bases de dados, pelo menos do ponto de vista dos motores de busca, é um dos pontos fortes do sistema do NCBI.

Vamos escolher uma molécula, a **elastase de neutrófilos humanos**, e procurar entradas relevantes nas diferentes secções do ENTREZ.

## Pesquisas na base de dados ENTREZ Protein
Selecione **Protein** , introduza os termos de pesquisa **HUMAN ELASTASE** e clique em **Go** .

Os resultados, naturalmente, mudam ao longo do tempo à medida que as bases de dados crescem.

O **Quadro 4.3** mostra 14 "correspondências" (_hits_ ): as três primeiras, mais resultados selecionados mais abaixo na lista. O primeiro resultado é a **PRECURSORA DA ELASTASE LEUCOCITÁRIA** . Outras respostas incluem elastases de outras espécies, inibidores, uma proteína de sanguessuga e um regulador transcricional. (Por que razão uma proteína de sanguessuga e um regulador transcricional — que presumivelmente interage com DNA, não com proteínas — aparecem numa pesquisa por elastase humana?) Veremos mais à frente como refinar a consulta para eliminar estas respostas irrelevantes.

O formato das respostas é o seguinte: em cada caso, a primeira linha contém um identificador, cuja forma reflete a base de dados de origem. Por exemplo, na primeira resposta, **P08246** é um número de acesso do **SWISS-PROT** ; na segunda, **1HNEE** indica a cadeia E da entrada **1HNE** do **wwPDB** . A linha seguinte apresenta o nome e sinónimos da molécula, bem como a espécie de origem. Note-se que as letras gregas são escritas por extenso. A última linha fornece referências às bases de dados de origem: **gi** = identificador geninfo (ver Quadro 1.7); **gb** = número de acesso do GenBank; **sp** = SWISS-PROT; **pdb** = Protein Data Bank; **pir** = Protein Identification Resource; **dbj** = DNA Data Bank of Japan; **ref** = projeto de Sequência de Referência do NCBI. As entradas recuperadas incluem elastases humanas e de outras espécies, bem como inibidores da elastase.

A abertura da entrada correspondente ao primeiro resultado recupera um ficheiro com o conteúdo apresentado no **Quadro 4.4** . (O ficheiro completo tem 469 linhas.)

https://www.ncbi.nlm.nih.gov/protein/P08246/

As primeiras linhas são sobretudo informações administrativas da base de dados, como números de acesso, nome da molécula e data de depósito. Depois vêm dados descritivos como a origem (neste caso, humana), com a classificação taxonómica completa; créditos aos cientistas que depositaram a entrada; e referências bibliográficas. Existem extensas referências cruzadas com outras bases de dados. Por fim, aparece a informação científica específica: localização do gene e do seu produto (CDS = sequência codificante) e a sequência propriamente dita (ver Exercício 4.2). Mais uma vez, note-se que a sequência ocupa apenas uma pequena parte da entrada.

*A densidade de metadados em entradas como esta demonstra o valor da anotação curada: a integração de dados funcionais, clínicos (como mutações em ELA2 associadas à neutropenia cíclica) e de interação permite a transição de dados genômicos para interpretação biológica e clínica, essencial na medicina personalizada.*

Muitas referências bibliográficas e entradas da tabela de características foram omitidas. Palavras-chave (tipos de sítios ou nomes de regiões) associadas às entradas da tabela de características incluem: _Helical region_ , _Beta-strand region_ , _Domain_ , _Hydrogen bonded turn_ , _Disulphide bridge_ , _Mature chain_ , _Propeptide_ , _Signal_ , _Tryp_SPc_ (indicando pertença à família das serinoproteases semelhantes à tripsina), _Variant_ (por exemplo, um SNP observado), _Substrate-binding site_ , _Charge relay system_ e _Glycosylation site_ .

## Pesquisas na base de dados bibliográfica PubMed
Talvez seja altura de ver o que as pessoas têm dito sobre a nossa molécula. Naturalmente, a literatura sobre elastase é vasta. Uma pesquisa no **PubMed** por **HUMAN ELASTASE** devolve 10 453 entradas. Para refinar os resultados, vamos procurar citações a artigos que descrevam o papel da elastase na doença. Uma pesquisa por **HUMAN ELASTASE DISEASE** devolve 2 447 entradas. E quanto a mutações específicas da elastase associadas a doenças humanas? Uma pesquisa por **HUMAN ELASTASE DISEASE MUTATION** devolve 114 artigos, apresentados por ordem cronológica inversa. Eis os primeiros oito...

## Online Mendelian Inheritance in Man (OMIN)
A **Online Mendelian Inheritance in Man (OMIM™)** é uma base de dados de genes humanos e distúrbios genéticos. Foi originalmente compilada por V.A. McKusick, M. Smith e colegas, e publicada em formato impresso. O NCBI transformou-a numa base de dados acessível via web, integrando-a com links para outras fontes de informação relacionada, incluindo bancos de sequências e literatura médica. Atualmente, a OMIM está bem integrada no sistema de recuperação de informação do NCBI, o **ENTREZ** . Uma base relacionada, o **OMIM Morbid Map** , trata de doenças genéticas e das suas localizações cromossómicas.

A resposta à pesquisa por **ELASTASE** na OMIM descreve a ligação entre mutações no gene _ELA2_ e dois tipos de neutropenia: **cíclica** e **congénita (não cíclica)** . A OMIM lista nove variantes alélicas (embora sejam conhecidas muitas mais). Cinco estão associadas à neutropenia cíclica: três causam substituições de aminoácidos, uma afeta um local de _splicing_ e outra está num intrão. Quatro variantes (todas substituições) estão associadas à neutropenia congénita grave.

O conjunto de resultados sobre a elastase que reunimos poderia sustentar investigação sobre o sistema; por exemplo, poderíamos mapear as mutações da elastase na estrutura tridimensional da molécula para procurar pistas sobre as causas da neutropenia cíclica e não cíclica.

*A integração entre dados clínicos (OMIM), funcionais (PubMed) e estruturais permite a transição de variantes genéticas para mecanismos patofisiológicos, essencial para a medicina genômica e o desenvolvimento de terapias direcionadas.*

