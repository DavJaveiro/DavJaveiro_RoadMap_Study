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

