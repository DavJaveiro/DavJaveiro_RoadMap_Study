#flashcards/Mestrado/Building-Bioinformatics-Solutions/Chapter-2-Building-Biological-Databases

Um banco de dados é, em sua forma mais simples, um conjunto de informações armazenadas, como um armário de arquivos ou o disco rígido de um computador. Geralmente, peças de informação similares ou relacionadas são reunidas no mesmo local, como o bom senso ditaria e como provavelmente já fazemos ao criar pastas e subpastas para informações mantidas em nosso computador. Os conceitos de banco de dados fornecem uma maneira de formalizar a reunião desses dados, de modo que as relações entre as peças de informação sejam consistentes. Eles podem, portanto, ser usados de forma mais eficiente, seja por meio de processos manuais ou automatizados, e a estrutura fornece um meio pelo qual a consistência dos dados pode ser mantida.
*Em bioinformática, a consistência de dados garantida por bancos de dados é crucial. Ela permite a integração de dados genômicos, proteômicos e estruturais, revelando relações evolutivas e funcionais que, de outra forma, permaneceriam ocultas na desordem.*


Por que os bancos de dados são essenciais para a bioinformática?::Os bancos de dados são essenciais para a bioinformática porque garantem a **consistência na organização de dados genômicos, proteômicos e estruturais**. Essa consistência é o que permite integrar diferentes tipos de informações e descobrir **relações evolutivas e funcionais** que, sem essa estrutura organizada, permaneceriam ocultas em meio à desordem. Em outras palavras, eles funcionam como pontes que ligam dados complexos, revelando conexões fundamentais para avanços científicos.
<!--SR:!2025-07-18,1,230-->

Se quiser, posso transformar esse conteúdo em um mapa mental, resumo ou até montar uma apresentação com esses conceitos. Só dizer como prefere! 😊📚


Este capítulo foca primariamente em um tipo de dados chamado **banco de dados relacional**. Bancos de dados relacionais são poderosos porque impõem um alto grau de segurança e consistência aos dados contidos neles. As ferramentas de software usadas para criar e gerenciar bancos de dados relacionais são chamadas de **sistemas de gerenciamento de bancos de dados relacional** ou **RDBMSs**. Estes permitem que os dados contidos em um banco de dados sejam consultados de maneiras imensamente poderosas, muitas vezes usando comandos muito simples criado com uma linguagem de programação especial chamada de **Linguagem de Consulta Estruturada (SQL)**.
*A SQL permite aos biólogos fazer perguntas complexas aos dados, como "encontrar todos os genes humanos com homólogos em levedura que estão envolvidos no reparo do DNA". Essa capacidade de consulta é a  base da genômica comparativa.*

Também são brevemente introduzidos neste capítulo outros dois tipos de bancos de dados comumente encontrados em bioinformática: **arquivos de texto plano (flat text files)**, como os arquivos FASTA, que contêm informações de sequência, e arquivos de **Linguagem de Marcação Extensível (XML)**, que são um componente chave da maioria dos padrões de dados modernos, como os padrões #HUPO-PSI para dados proteômicos. <span style="background:#affad1">Compreender esses tipos de banco de dados é mais fácil do que os bancos de dados relacionais</span>, por isso eles não constituem a maior parte deste capítulo.
*Formatos padronizados como FASTA e XML são a "língua fraca" da bioinformática. Eles garantem a interoperabilidade entre ferramentas e bancos de dados, permitindo a colaboração global que impulsiona a pesquisa em evolução molecular e biologia estrutural.*

Finalmente, também introduziremos o conceito de banco de dados **NoSQL**, uma classe de diversas soluções para armazenamento e acesso a dados que surgiram em resposta à crescente necessidade de acessar registros em conjuntos de dados muito grandes em prazos muito curtos. <span style="background:rgba(160, 204, 246, 0.55)">Existem algumas instâncias em que o uso de tal tecnologia em aplicações de bioinformática é mais apropriado</span> do que o uso de um #RDBMS.
*O dilúvio de dados do sequenciamento de nova geração (NGS) tornou os bancos de dados NoSQL essenciais. Sua escalabilidade é vital para a análise de metagenômica e genômica populacional, onde a velocidade de acesso a terabytes de dados é fundamental.*

O **crescimento exponencial de dados biológicos** é mais bem concebido com o uso de bancos de dados NoSQL, portanto, tendo algumas vantagens:
1. **Escalabilidade horizontal**: 
	1. Bancos NoSQL (como MongoDB, Cassandra, etc.) são projetados para crescer facilmente **distribuindo** dados em vários servidores.
	2. Isso é crucial em bioinformática, onde datasets podem chegar a terabytes ou petabytes.
2. **Flexibilidade no esquema (schema-less)**
	1. Muitas vezes os dados biológicos são **semiestruturados** ou **variáveis** (diferentes formatos de anotação, metadados diversos)
	2. <span style="background:#d3f8b6">NoSQL permite armazenar documentos JSON</span>, por exemplo, onde cada registro pode ter uma estrutura diferente, sem exigir rigidez de um schema relacional
3. **Alta performance para leitura e escrita
	1. Operações rápidas são essenciais em análises de alto desempenho (ex.: pipelines de NGS que precisam consultar milhões de registros rapidamente).
	2. Bancos como **Redis** e **Cassandra** são otimizados para acessos em tempo real.

4. **Melhor suporte a dados hierárquicos e aninhados**
	1. Dados biológicos frequentemente possuem **relacionamentos complexos** (ex. uma anotação genômica com múltiplas isoformas, exons, variantes, evidências)
	2. Estruturas como documentos JSON (em MongoDB) armazenam essa hierarquia naturalmente.
5. **Alta disponibilidade e tolerância a falhas**
	1. Muitos bancos NoSQL foram projetados para ambientes distribuídos com **replicação automática e failover**, importante para aplicações críticas como monitoramento em tempo real de dados de saúde.
6. **Integração com Big Data e Machine Learning**
	1. É comum integrar bancos NoSQL com ferramentas de Big Data (Hadoop, Spark) ou pipelines de ML, para análises avançadas (ex.: detecção de variantes patogênicas, classificação de expressão gênica etc.).


À primeira vista, a ordem deste capítulo pode parecer estranha, a instalação de um sistema de banco de dados relacional segue seções extensas sobre bancos de dados e projeto de banco de dados, e o acesso ao banco de dados através do SQL é abordado por último. Isso é deliberado. <span style="background:rgba(205, 244, 105, 0.55)">Os aspectos mais difíceis de entender e lidar com bancos de dados ocorrem na</span> **fase de projeto**, que também é mais importante. Instalar um RDBMS é simples e também desnecessário para um bom projeto de bancos de dados. No entanto, um sistema funcional é necessário para experimentar o acesso a bancos de dados e, portanto, as questões de instalação e conexão são discutidas após o projeto do banco de dados, mas antes da interação com o banco de dados.
*Assim como um experimento de biologia molecular mal planejado gera resultados inúteis, um banco de dados mal projetado compromete a integridade de qualquer análise bioinformática subsequente. O design é a base sobre a qual o conhecimento é construído.*

## 2.1 Common database types
### 2.1.1 Flat text files
Como afirmado acima, um banco de dados é meramente um repositório de dados, e uma de suas formas mais simples seria escrever os dados como um conjunto de arquivos de texto, muitas vezes chamados de *flat files*. Esses *flat files* poderiam ser qualquer arquivo de texto criado em um formato comumente legível, como os arquivos .txt criados em editores de texto como o Bloco de Notas do Windows. Uma coleção de documentos de texto em um disco rígido é um exemplo de um banco de dados *flat files*.

Para auxiliar o acesso automatizado e, indiretamente, a legibilidade, ajuda se algum tipo de estrutura for imposta aos dados dentro de um arquivo de texto. Em termos de artigos científicos, essa ordem é frequentemente nos moldes de Introdução, Materiais e Métodos, Resultados, Discussão e Referências, ou variantes desse tipo. A estrutura ajuda o leitor a localizar rapidamente informações de interesse, navegando primeiro para a seção relevante. Subtítulos auxiliam ainda mais nessa causa. Para a leitura automatizada, ou *parsing*, dos dados dentro de um arquivo, ajuda se a estrutura for altamente consistente. Os cabeçalhos em artigos científicos podem diferir devido a uma série de fatores, como diferentes formatos de periódicos. Por outro lado, se considerarmos uma implementação básica do formato de arquivo plano FASTA para armazenar arquivos de sequência, apresentado abaixo, a estrutura é muito mais simples, mas permite uma leitura intuitiva tanto por humanos quanto por máquinas.
*A estrutura consistente dos flat files é a espinha dorsal da automação em bioinformática. O parsing eficiente é o primeiro passo em qualquer pipeline, permitindo análises em larga escala, da genômica comparativa à reconstrução de árvores filogenéticas.*

Um exemplo simples de um arquivo em formato FASTA seria:
`>ENSP00000630516 | a protein description` `SEQUENCEAPPEARSHERE` `>ENSP00000295897 | another protein description` `THESEQUENCEOFTHISPROTEIN`

O arquivo FASTA apresenta quatro elementos estruturais:
1. A informação sobre cada proteína é introduzida por um caractere de maior que (>).
2. O primeiro dado a seguir o caractere > é o número de acesso da proteína, neste caso, o número de acesso do Ensembl. Este é seguido por um caractere de barra vertical |; this is followed by a bar character;
3. Following the bar, we have the protein description. There is then a newline character that is not directly visible, but results in a new line being started. This is the indication that the protein sequence follows. In term of human readability, this is clearly indicated by the start of a new line on which text that looks like a sequence is presented, but in machine readability terms, it's the invisible newline character that is used to differentitate between protein description and protein sequence.
4. Outro caractere de nova linha é usado para terminar a sequência, seguido imediatamente por mais um caractere de nova linha. Visualmente, isso resulta em uma linha em branco separando as proteínas sucessivas.

O padrão desses elementos estruturais pode ser repetido até o final do arquivo, que pode conter qualquer número de proteínas.
*O formato FASTA, com sua estrutura minimalista de cabeçalho e sequência, tornou-se o padrão universal para o intercâmbio de dados em biologia molecular. Sua simplicidade garante a interoperabilidade entre a vasta gama de ferramentas de alinhamento e análise filogenética.*

O ponto importante a ser notado na descrição acima é que ela separa os **dados** contidos no arquivo **estrutura** desses dados. Nenhuma informação sobre o que é uma convenção de nomenclatura de proteína, descrição ou sequência, ou como esses dados se parecem, é necessária para atribuir corretamente os elementos de dados a um dos três grupos: números de acesso de proteínas, descrições de proteínas e sequências de proteínas. Além disso, cada pedaço de dado está explicitamente relacionado, por sua localização no arquivo, aos outros dois que pertencem à mesma proteína. A estrutura de dados é, portanto, valiosa por si só, independentemente de quaisquer dados contidos no arquivo.
*Essa separação entre estrutura e conteúdo é um princípio fundamental da ciência de dados. Permite que algoritmos de bioinformática processem terabytes de sequências para estudos evolutivos sem "entender" a biologia, focando apenas nos padrões definidos pela estrutura.*

Existem formas muito mais complicadas de arquivos planos estruturados que são usadas em aplicações cotidianas de bioinformática. Um bom exemplo é o formato Gebbank, usado para armazenar dados de sequência, cada registro de sequência individual contém não apenas a sequência, mas muitos campos adicionais de metadados, como o nome da espécie e a localização genômica. Independente do formato específico, o princípio dos *flat files* permanece o mesmo: há um conjunto de elementos estruturais usados de forma consistente que permite que os dados sejam classificados em tipos semelhantes e também agrupados conforme apropriado, por exemplo, por proteína, como no exemplo anterior.
*Formatos como o Genbank enriquecem a sequência bruta com metadados cruciais. Essa contextualização (espécie, função, origem) é o que transforma uma simples cadeia de caracteres em informação biologicamente relevante para a análise evolutiva e funcional.*

### 2.1.2 XML
A **Linguagem de Marcação Extensível (XML)** é um formato de arquivo comumente usado em aplicações de bioinformática. Elas adiciona uma **sintaxe** ao conceito de um arquivo de texto estruturado. Uma sintaxe define a ordem dos elementos da linguagem de modo que o que é escrito seja geralmente compreensível. No caso da língua inglesa, as frases são mais facilmente estendidas se a gramática e a pontuação corretas forem usadas. Esses elementos, portanto, formam a sintaxe do inglês. Em outras linguagens, como Perl, ou neste caso XML, uma sintaxe estrita ajuda tanto humanos quanto computadores a entenderem exatamente o que se quer dizer.
*A sintaxe rigorosa do XML garante a representação inequívoca de dados biológicos complexos. Essa padronização é vital para a integração de dados de genômica, proteômica e metabolômica, permitindo uma visão sistêmica da evolução e da função celular.*

Assim como os arquivos FASTA, os arquivos XML podem ser escritos e visualizados em um editor de texto simples. No entanto, as estruturas foram projetadas para serem primariamente **legíveis por máquina**, não necessariamente legíveis por humanos, e, portanto, podem parecer muito mais difíceis de entender. Dito isso, a sintaxe básico do XML é composta por um pequeno número de elementos estruturais que são facilmente compreendidos.
*O XML prioriza a robustez computacional em detrimento da legibilidade humana. Essa escolha de design é fundamental para os pipelines de bioinformática de alto rendimento, onde a automação e a ausência de erros na interpretação de dados são cruciais para a análise genômica.*

Cada arquivo XML pode começar com uma declaração de certas informações, como o tipo de XML sendo usado, a forma como os caracteres no arquivo são codificados e outras informações, por exemplo:
`<?xml version="1.0" encoding="UTF-8"?>`
Encontramos isso no topo do arquivo XML antes do início do corpo do arquivo que contém as informações.

Os elementos estruturais genéricos em XML são chamados de **nomes**, **atributos** e **valores**. Essa estrutura também é usada para a declaração, mas note o uso dos pontos de interrogação, indicando que essa informação é parte da declaração, não da informação do corpo. O conteúdo textual também pode ser inserido em cada elemento. Genericamente, eles são escritos da seguinte forma: 
`<nome atributo_1="valor_1" atributo_2="valor_2"… atributo_n="valor_n">Algum texto sobre este elemento nomeado</nome>`

Um conjunto nomeado de informações é, portanto, introduzido usando a sintaxe `<nome`; os atributos e valores pertencentes a ele se seguem até o símbolo de fechamento >. Para fechar um grupo nomeado, a sintaxe `</nome>` é usada. Por exemplo, se estivéssemos representando as proteínas identificadas em um experimento de proteômica, o seguinte poderia ser usado:
`<protein_identified id_number="1" probability="1.00">Proteína identificada usando espectrometria de massa</protein_identified>`
*A estrutura de "tags" do XML torna os dados auto-descritivos. Em bioinformática, isso é crucial para anotar uma sequência ou proteína com sua origem, função e identificadores de múltiplos bancos de dados de forma inequivoca ou computacionalmente robusta.*

Elementos nomeados podem ser **aninhados** um abaixo do outro, de modo que um subconjunto de informações pertença ao elemento nomeado que o envolve. Assim, os vários nomes pelos quais uma proteína identificada pode ser conhecida seguem a abertura de `protein_identified`, mas precedem sua declaração de fechamento, como em:
```xml
<protein_identified id_number="1" probability="1.00">
...
<annotation protein_description="Cerulaplasmin precursor"
ipi_name="IPI00017601" refseq_name="NP_000087"
swissprot_name="P00450" ensembl_name="ENSP00000264613"
trembl_name="Q9UKS4" locus_link_name="1356">
...
</protein_identified>
```
*A capacidade de aninhar elementos em XML permite modelas as relações hierárquicas inerentes à biologia, de domínios dentro de proteínas a genes dentro de genomas. Essa estrutura espelha a complexidade dos sistemas biológicas de forma que arquivos planos não conseguem.*

Uma grande inovação do XML, e a razão pela qual ele tem "extensível" em seu nome, é que os nomes dos elementos e como eles podem ser usados em uma aplicação específica podem ser decididos por qualquer pessoa. O único requisito é que essa especificação seja codificada em um arquivo de **definição de esquema XML (XSD)** e disponibilizada em algum lugar na Internet. A URL do XSD ao qual um arquivo XML específico deve se conformar deve ser referenciada em uma seção especial no topo desse arquivo. O software pode, portanto, **validar** um determinado arquivo XML em relação ao XSD para verificar se os elementos estão sendo usados corretamente.
*A extensibilidade do XML, governada por esquemas (XSD), permitiu a criação de dialetos de dados específicos para cada área da biologia. Isso viabiliza padrões como mzML e SBML, essenciais para a reprodutibilidade e a integração de dados ômicos.*

**Um exemplo do mundo real**
Os exemplos acima foram formatados com algum texto em negrito para que fiquem mais claros para nós lermos. No entanto, essa formatação não faz parte do formato XML e a convenção pode não ser usada em todas as situações. Por exemplo, a Fig. 2.1 (reproduzida abaixo) fornece uma amostra de um arquivo XML que foi gerado pelo ProteinProphet, um sistema para identificar proteínas a partir de dados de espectrometria de massa. Neste arquivo, há pouca formatação, tornando-o inicialmente muito difícil de ler.
```xml
<?xml version="1.0 encoding="UTF -8"?><xml-stylesheet type="text/xsl" href="regis/sbeams/
archive/edeutsch/HUPOPPP12/HUPO12_run31/HsIPI_v2.21/interact-prot.xsl"?>
<protein_summary xmlns="http://regis-web.systemsbiology.net/protXML" xmlns:xsi="http://
www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://regis-web.systemsbiology.net/
protXML/tools/bin/TPP/tpp/schema/protXML_v3.xsd"
summary_xml="regis/sbeams/archive/edeutsch/HUPOPPP12/HUPO12_run31/HxIPI_v2.21/interact-prot.
xml">...
...<protein_group group_number="1" probability="1.00"><protein protein_name="IPI00017601"
n_indistinguishable_proteins="1" probability="1.00" percent_coverage="9.0"
unique_stripped_peptides="KLVYREYTDASFTNRK+IYHSHIDAPKDIASGLIGPLIICKK+LVYREYTDASFTNR+YKK
VVYR+LVYREYTDASFTNRK+KLISVDTEHSNIYLQNGPDR+HYYIGIIETTWDYASDHGEKK+IGGSYKKLVYREYT DASFTNRKER+IYH
SHIDAPK+IGGSYKKLVYREYTDASFTNRK" group_sibling_id="a" total_number_peptides="15" pct_spectrum_
ids="1.18"><annotation protein_description="ceruloplasmin precursor" ipi_name="IPI00017601"
refseq_name="NP_000087" swissprot_name="P00450" ensembl_name="ENSP00000264613"
tremble_name="Q9UKS4" locus_link_name="1356"/><peptide peptide_sequence="KLISVDTEHSNIYLQNGPDR"
charge="2" initial_probability="1.00" nsp_adjusted_probability="1.00" weight="1.00"
is_nondegenerate_evidence="Y" n_enzymatic_termini="2" n_sibling_peptides="8.00"
n_sibling_peptides_bin="6" n_instance="1" is_contributing_evidence="Y"
calc_neutral_pep_mass="2299.4919"></peptide><peptide peptide_sequence="IYHSHIDAPKDIASGLIGPLIIC
KK" charge="2" initial_probability="1.00" nsp_adjusted_probability="1.00" weight="1.00"
is_nondegenerate_evidence="Y" n_enzymatic_termini="2" n_sibling_peptides="8.00"
n_sibling_peptides_bin="6" n_instances="1" is_contributing_evidence="Y" calc_neutral_pep_
mass="2761.1919"><modification_info modified_peptide="IYHSHIDAPKDIASGLIGPLIICKK"
<mod_aminoacid_mass position="23" mass="161.138794"/></modification_info></peptide>
```

Isso é praticamente incompreensível para o olho não treinado, e mesmo que o leitor entendesse a estrutura XML, como nós entendemos agora, esta não seria a maneira preferida de visualizá-lo. Em vez disso, os arquivos XML são frequentemente visualizados por meio de uma interface, como um navegador da web, que por sua vez se refere a um segundo documento, uma **folha de estilo** ou (stylesheet, documento XLS), para obter instruções sobre como exibir os dados contidos na estrutura XML. Este arquivo XML, quando visualizado com sua folha de estilo, é mostrado na Fig. 2.2 (não incluída aqui).
![[Chapter 2 - Building Biological Databases with SQL.png]]
Fig. 2.2 The ProteinProphet XML file, shown in Figure 2.1, viewed in Internet Explorer with the help of a stylesheet.

Toda a informação apresentada na Fig. 2.3 (no exemplo acima) se relaciona ao **protein_group** com um **group_number** de 1, porque ela se encontra entre a abertura deste grupo (`<protein_group...n...>)` e a tag de fechamento (`</protein_group>)`. Mais adiante no arquivo, outro `protein_group` pode ser iniciado com um **group_number** de 2 . Esta seria uma proteína diferente e, portanto, teria um conjunto diferente de nomes de proteínas alternativos aninhados dentro dela como anotações. Desta forma, informações que são naturalmente relacionadas são ligadas dentro da estrutura XML, muito semelhante à forma como as informações são ligadas dentro das tabelas de um banco de dados relacional, como veremos na próxima seção.
*O XML encapsula dados hierárquicos, como um peptídeo e suas modificações dentro de uma proteína. A separação entre dados (XML) e apresentação (XLS) é um princípio poderoso, permitindo que a mesma informação biológica seja visualizada de múltiplas formas.*

### 2.1.3 Relational databases
Bancos de dados relacionais levam os conceitos de ordem e estrutura de dados um passo adiante. Isso é alcançado através da compartimentalização dos dados em caixas de elementos relacionados e, em seguida, ligando essas caixas de modo que os dados em uma caixa possar ser acessados juntamente com informações relacionadas em outra caixa. <span style="background:#affad1">A essência  de um banco de dados relacional, e grande parte de seu poder, vem do projeto dessas caixas e de suas relações umas com as outras</span>. 
*Bancos de dados relacionais espelham a organização da biologia. Genes, proteínas e vias metabólicas são "tabelas" distintas, e suas relações, definidas pelo design do banco de dados, permitem consultas complexas sobre suas interações evolutivas e funcionais.*

Como um exemplo físico de um banco de dados relacional, podemos considerar um sistemas de indexação de biblioteca. Podemos pensar em um uma biblioteca como um repositório de informações com todos os livros em uma caixa grande. Os livros são frequentemente armazenados em várias caixas menores, específicas por assunto, e depois indexados alfabeticamente pelo nome do autor. Para encontrar qualquer livro na biblioteca para o qual conhecemos o autor e a área de assunto, podemos procurar na área de assunto correta e percorrer os livros até encontrar o autor correto e, em seguida, percorrer todas as suas obras até encontrar o que deseja. No entanto, se o que queremos encontrar são todos os livro na biblioteca escritos por um autor específico, independentemente do assunto, podemos ter uma longa busca utilizando este método, teríamos de procurar em todas as áreas de assunto na biblioteca para ter certeza de encontrar todos os que foram escritos pelo autor de interesse. Para ajudar nesse caso, podemos criar outra caixa, como um armário de arquivos, na qual armazenar o autor, o título do livro e as informações-chave do assunto de outra maneira, como uma série de fichas ligando cada autor a todos os livros que ele escreveu. Agora, se sabemos o nome do autor, podemos procurar nesta caixa, percorrer a lista até encontrar o de interesse, e escrito ao lado do nome deve estar a lista de livros, cada um com a área de assunto correta atribuída. Seria então possível localizar rapidamente todos os livros na biblioteca que tivessem o mesmo autor.

Para recapitular, o exemplo acima apresenta duas caixas de itens de dados naturalmente relacionados. A primeira delas, a biblioteca, contém conjuntos de livros agrupados por assunto e depois pelo autor principal, e a segunda contém fichas listando, abaixo do nome de cada autor, seu conjunto completo de obras publicadas e as áreas de assunto em que poderiam ser encontradas. Em termos de banco de dados, essas caixas são chamadas de **tabelas**. Cada tabela tem várias peças de informação armazenadas dentro dela; assunto, nome do autor, título e conteúdo do livro no caso da biblioteca, e nome do autor, título do livro, assunto no caso do armário de arquivos. Mais importante, cada caixa também está ligada à outra por três peças de informação: autor, título e área de assunto.
*A analogia de biblioteca ilustra a necessidade de múltiplos índices para dados biológicos. Um banco de dados relacional permite navegar de um gene para sua proteína, estrutura e função, uma flexibilidade essencial para a pesquisa integrativa em genômica.*

Dessa forma, as duas caixas de informação estão relacionadas. Em termos de bancos de dados, as tabelas agora estão relacionadas por três de seus **campos**. Essa situação pode ser representada pictoricamente, como mostrado na figura 2.4.

![[Chapter 2 - Building Biological Databases with SQL-1.png]]

Um outro conceito importante destacado pelo exemplo acima é que, para descrever o processo de acesso aos dados e para representar a informação que está armazenada, não tivemos que nos referir a um autor, título ou editora específicos. Compare isso com os exemplos de arquivos de texto plano e formatos XML apresentados anteriormente. Em cada um deles, o exemplo contém os dados armazenados. No caso da Fig. 2.4, temos uma representação dos dados, mas nenhum dado é mostrado. A representação do banco de dados forma uma **camada abstrata** que descreve os dados subjacentes e, portanto, podemos discutir cada item de dados genericamente sem nos referir a um exemplo específico.
*A camada abstrata dos bancos de dados permite criar ferramentas de bioinformática genéricas. Um software que busca domínios proteicos pode operar sobre qualquer genoma, contando que os dados sigam o mesmo esquema (ou schema) de organização.*

Ao lidar com o projeto e o acesso a bancos de dados, podemos, portanto, falar sobre acesso e manipulação de forma genérica, um conceito muito poderoso. Por quê? Voltando ao exemplo da biblioteca, assume-se que os livros em cada seção estão ordenados alfabeticamente pelo nome do autor. Isso faz muito sentido, mas e se quisermos localizar um livro pelo título? Se não soubermos o autor, uma busca bastante longa pode ser necessária. Podemos contornar isso tendo um conjunto de fichas de índice que ligam títulos a autores, mas isso duplica dados, o que nos deixa propensos a erros causados por incompatibilidades entre os títulos e autores impressos nas capas dos próprios livros e aqueles nas fichas de índice. Nesse caso, como os dados e a representação dos dados estão inextricavelmente ligados, temos que escolher um mecanismo de ordenação e usar meios adicionais se quisermos usar uma ordem alternativa.

Com um banco de dados relacional, no entanto, podemos ordenar as informações contidas em uma tabela por qualquer atributo que desejarmos. É como ter uma biblioteca que reorganizará automaticamente todos os livros para se adequar ao tipo de busca que estamos fazendo, seja por área de assunto, por autor ou por título.
*Essa flexibilidade de ordenação é o que permite a descoberta em genômica. Pode-se analisar os mesmos dados sob a ótica da expressão gênica, da localização cromossômica ou da função evolutiva, simplesmente alterando a consulta ao banco de dados.*

Como vimos, os fundamentos de um banco de dados relacional não são complicados. No entanto, há muito jargão complicado e até mesmo matemática associada ao projeto formal de banco de dados que pode ser muito desanimador para iniciante. 

Na próxima seção, apresentamos uma abordagem natural para o projeto de banco de dados que, para a maioria das aplicações, permite que novos bancos de dados sejam criados sem a necessidade de percorrer essa complexidade.

## 2.2 Relational database design, the 'natural' approach
O objetivo de projetar um banco de dados é produzir um mapa funcional da estrutura do banco de dados, que chamamos de **esquema do banco de dados** (*database schema*). Os passos para produzir um esquema de banco de dados razoavelmente robusto e utilizável, sem se preocupar com as complexidades do projeto formal de banco de dados, são os seguintes:
1. Reúna uma lista de peças de dados a serem contidas no banco de dados.
2. Agrupe-as para que se encaixem naturalmente.
3. Atribua nomes curtos, consistentes e descritivos para cada peça de dado.
4. Defina o tipo de cada peça de dado: número, texto, binário, etc.
5. Verifique a atomicidade, algum item de dado pode ser subdividido ainda mais?
6. Indexe seu banco de dados.
7. Ligue as tabelas do banco de dados por meio de relacionamentos.

Cada um desses passos é descrito em detalhes através de um exemplo prático nas seções seguintes. Como será visto, os passos acima são ordenados, mas pode ser necessário repetir alguns deles como parte de um processo de projeto iterativo. Pode ser útil para tentarmos projetar um banco de dados próprio enquanto trabalhamos com os exemplos dados aqui, ou você pode preferir trabalhar com os exemplos e depois reler a seção com o projeto do seu próprio banco de dados em mente. De qualquer forma, para aproveitar ao máximo este capítulo, devemos considerar cada passo à medida que ele acontece: por que estamos fazendo isso e o que isso alcançou? Dessa forma, sua apreciação das operações será aprimorada e mais fácil acharemos aplicar esses conceitos em qualquer situação.

*O processo de design de um banco de dados é análogo ao planejamento de um experimento em biologia molecular. Um esquema bem definido e atômico é crucial para garantir a integridade e a validade de qualquer análise bioinformática subsequente.*

### 2.2.1 Steps 1-3: gather, group, and name the data
O primeiro ponto importante a ter em mente ao projetar um banco de dados é pensar no que queremos **obter** do banco de dados, não no que queremos **colocar** nele. Há uma série de razões para isso, send a mais convincente que estamos projetando um banco de dados com um propósito, e é esse propósito que deve definir sua forma e conteúdo. É improvável que estamos projetando um banco de dados apenas para armazenar seus dados, provavelmente, também desejaremos acessá-lo.

Dito isso, temos que começar de algum lugar, e muitas vezes o ponto mais fácil para começar é, de fato, considerar o que está disponível. Pelo resto deste capítulo, nos concentraremos em um exemplo específico para ilustrar o projeto e a implementação de um banco de dados. Neste exemplo, <span style="background:#affad1">estamos interessados em construir um repositório de informações sobre experimentos de PCR</span> que foram realizados em uma determinada organização. Os benefícios de tal repositório para a organização são tornar os resultados do PCR mais prontamente disponíveis, evitar a duplicação de esforços e facilitar o compartilhamento das melhores práticas entre os experimentalistas. O exemplo foi inspirado por um projeto de mestrado, se você quiser saber mais, indicamos a tese relevante (Simecek, 2007), que está disponível na web (dspace.lib.cranfield.ac.uk/handle/1826/1773).
*Projetar um banco de dados pelo seu resultado é análogo a definir uma hipótese antes de um experimento. Essa abordagem garante que a estrutura de dados seja otimizada para responder às questões biológicas ou evolutivas para as quais foi criada.*

**Dados a serem capturados de um experimento de PCR**
Ao invés de considerar o processo experimental como um todo, primeiro dividimos o processo em potenciais fontes de informação para o banco de dados. Aqui, podemos ter cinco fontes de informação de um experimento:
1. O **kit de PCR** utilizado;
2. **Parâmetros experimentais** (temperatura de anelamento, tempos de ciclo, etc.)
3. **Primers** utilizados.
4. O **cientista** que realizou o experimento
5. **Resultados** do experimento

Podemos discordar do exposto, desejar combinar ou reagrupar as fontes, ou dividi-las ainda mais, mas, em essência, alcançaremos o mesmo resultado, um conjunto de títulos sob os quais é mais simples listar as peças individuais de informação a serem armazenadas do que seria o caso se considerássemos o experimento inteiro de uma só vez. O resultado da atribuição de informações sob esses cinco títulos é mostrado na Tabela 2.1. *Essa decomposição de um processo experimental em entidades lógicas (kit, primers, parâmetros), é o primeiro passo para criar um esquema de banco de dados robusto. Em bioinformática, essa estruturação é essencial para garantir a reprodutibilidade dos dados e permitir análises comparativas em larga escala.*

É neste ponto do processo de design que começamos a fazer perguntas. A primeira pode ser: "isso está completo?". Essa seria uma pergunta justa, mas tende a atrair o projetista de banco de dados incauto para uma busca interminável <span style="background:#b1ffff">pela completude que não é necessária para atender à finalidade para a qual o banco de dados se destina</span>.

**Tabela 2.1 Itens de informação de exemplo de um experimento de PCR agrupados sob títulos de origem**

| Kit de PCR                   | Parâmetros Experimentais    | Primers Utilizados           | Cientista    | Resultados    |
| ---------------------------- | --------------------------- | ---------------------------- | ------------ | ------------- |
| Fabricante                   | Temperatura de desnaturação | Sequência do Primer 1        | Nome         | Imagem do gel |
| Nome do kit                  | Tempo de desnaturação       | Sequência do Primer 2        | Cargo        |               |
| Número do pedido             | Temperatura de anelamento   | Concentração do primer       | Departamento |               |
| Fornecedor e endereço        | Tempo de anelamento         | Software de design de primer | Telefone     |               |
| Custo                        | Temperatura de elongação    |                              | E-mail       |               |
| Tampão (_Buffer_)            | Tempo de elongação          |                              |              |               |
| Concentração do Tampão       | Número de ciclos            |                              |              |               |
| Enzima                       | Temperatura de finalização  |                              |              |               |
| Concentração da Enzima       | Tempo de finalização        |                              |              |               |
| Mix de Nucleotídeos          |                             |                              |              |               |
| Concentração de Nucleotídeos |                             |                              |              |               |
Existem alguns itens que, sem dúvida, estão faltando na Tabela acima e que talvez queiramos incluir. Um deles pode ser o **propósito** do experimento. Pode haver outros parâmetros experimentais que desejamos capturar, ou variações no protocolo que poderiam ser usadas. A coluna de resultados está atualmente muito esparsa, leituras que resumem o conteúdo de informação do gel resultante do PCR seriam úteis? Também podemos concluir que algumas das informações não são particularmente úteis e que podemos até estar equivocados em colocá-las. Por exemplo, se o laboratório segue um protocolo padrão para a maioria dos experimentos de PCR, não seria mais seguro (e mais eficiente) direcionar o usuário para a folha de protocolo padrão e, assim, <span style="background:rgba(205, 244, 105, 0.55)">eliminar a necessidade de armazenar, e potencialmente inserir incorretamente</span>, a maioria das informações nas duas primeiras colunas?

Portanto, para ter uma ideia melhor do que o banco de dados deve ser capaz de armazenar, precisamos considerar como pretendemos usá-lo. Para os fins deste exemplo, o objetivo é fornecer um registro de protocolos e kits que foram usados na tentativa de amplificar sequências que se mostraram difíceis de analisar usando métodos padrão. O benefício de armazenar os resultados desses experimentos é que <span style="background:rgba(205, 244, 105, 0.55)">o banco de dados</span> fornecerá um ponto de referência em todo o laboratório para que os cientistas determinem rapidamente se a sequência com a qual estão trabalhando já <span style="background:rgba(160, 204, 246, 0.55)">foi considerada antes</span> e, em caso afirmativo, qual é o melhor protocolo a ser usado.
*Esse processo iterativo de refinar os campos de um banco de dados espelha o método científico. A relevância de cada dado (parâmetro, resultado) é determinada pela hipótese ou questão que o sistema deve responder, garantindo que o design final seja útil e eficiente.*

Com isso em mente, pode-se ver que talvez as únicas peças extras de informação necessárias seriam as sequências a serem amplificadas e algum tipo de julgamento sobre o quão bem sucedido cada protocolo foi em amplificar cada sequência. Também queiramos adicionar mais alguns dados, como a hora e a data do experimento e também um número de identificação do experimento, para que possamos usá-lo como uma forma rápida de nos referirmos ao protocolo e seu resultado.

O refinamento da Tabela 2.1 para incluir essas peças adicionais de informação resulta na Tabela 2.2. Nesta fase, não parece haver nenhuma peça de informação que deva ser removida dessas listas.

**Tabela 2.2 Um refinamento dos itens de informação a serem armazenados de um experimento de PCR, novamente agrupados sob títulos de origem. Campos adicionais estão destacados em itálico.**

| Kit de PCR                   | Parâmetros Experimentais       | Informação de Sequência e Primer | Cientista    | Resultados            |
| ---------------------------- | ------------------------------ | -------------------------------- | ------------ | --------------------- |
| Fabricante                   | _Identificador do experimento_ | _Sequência a ser amplificada_    | Nome         | Imagem do gel         |
| Nome do kit                  | _Data_                         | _Propósito do experimento_       | Cargo        | _Avaliação do método_ |
| Número do pedido             | _Hora_                         | Sequência do Primer 1            | Departamento |                       |
| Fornecedor e endereço        | Temperatura de desnaturação    | Sequência do Primer 2            | Telefone     |                       |
| Custo                        | Tempo de desnaturação          | Concentração do primer           | E-mail       |                       |
| Tampão (_Buffer_)            | Temperatura de anelamento      | Software de design de primer     |              |                       |
| Concentração do Tampão       | Tempo de anelamento            | _Fornecedor do primer_           |              |                       |
| Enzima                       | Temperatura de elongação       | _Custo_                          |              |                       |
| Concentração da Enzima       | Tempo de elongação             |                                  |              |                       |
| Mix de Nucleotídeos          | Número de ciclos               |                                  |              |                       |
| Concentração de Nucleotídeos | Temperatura de finalização     |                                  |              |                       |
|                              | Tempo de finalização           |                                  |              |                       |
Um uso secundário do banco de dados poderia ser pesquisar se existem certas tendências nos dados que possam indicar pontos de partida adequados para amplificar sequências novas. Haveria mais alguma peça de informação necessária para isso?
*A adição de metadados como "propósito" e "avaliação" transforma um repositório de dados em uma base de conhecimento. Isso permite a mineração de dados para descobrir, por exemplo, quais protocolos funcionam melhor para tipos específicos de sequências.*

Uma vez que estejamos satisfeito que as peças de informação que coletamos são suficientes para cumprir o propósito do banco de dados, a próxima etapa é transformar essas listas em um **projeto de banco de dados**. 

**Projeto de esquema e normalização**
O projeto de banco de dados pode ser abordado de duas maneiras. A maneira oficialmente "correta" de projetar um banco de dados é começar com uma única tabela contendo todas as peças de informação que buscamos armazenar e, em seguida, usar um processo chamado **normalização** para dividir essa tabela em um conjunto de tabelas ligadas por peças de informação comuns.
*A normalização é o processo de organizar dados para reduzir a redundância  e melhorar a integridade. Em bioinformática, isso garante que um nome de gene seja armazenado uma vez e vinculado a todas as suas ocorrências, evitando erros e economizando espaço.*

 Uma abordagem mais natural para o design de bancos de dados pode ser seguida, aproveitando muito do pensamento que dedicamos à coleta das informações acima. Este é um método que evoluímos e testamos muitas vezes, com feedback indicando que ele é mais intuitivo que o método formal, e também permite uma compreensão mais rápida dos passos envolvidos no processo de normalização. Por essas razões, essa abordagem de "design natural" é apresentada neste capítulo. No entanto, ao trabalhar com banco de dados regularmente, devemos investigar outras abordagens de design, pois cada uma tem suas próprias forças e fraquezas e, portanto, adequação a diferentes tarefas. *Abordagens naturais em bioinformática, que priorizam a intuição biológica, são valiosas. Elas garantem que a estrutura dos dados reflita a lógica do sistema biológico estudado, em vez de se ater rigidamente a formalismos que podem não ser ideais para a descoberta.*

  *A Terceira Forma Normal (3NF) é um padrão de ouro para a integridade de dados biológicos. Ela minimiza a redundância e previne anomalias, garantindo que as relações entre, por exemplo, um gene, sua proteína e sua função permaneçam consistentes.*

**Presenting the schema**
As informações na Tabela 2.2 é razoavelmente clara para este pequeno exemplo, contendo nomes para as tabelas e os tipos de informação dentro de cada uma. Ela não se parece, no entanto, com um esquema de banco de dados. Antes de desenvolvermos o banco de dados, é útil desenhá-lo de uma maneira ligeiramente diferente. Especificamente, cada tabela deve ser apresentada em sua própria caixa, com o nome da tabela acima da caixa e os tipos de informação contidos em cada uma aparecendo dentro da caixa, como mostrado na figura abaixo:

![[Chapter 2 - Building Biological Databases with SQL-2.png]]
Neste ponto, é útil escolher nomes simples, mas descritivos, para cada uma das tabelas e para cada tipo de informação. Tais nomes devem ser consistentes entre si. Por exemplo, na Tabela 2.2 existe atualmente uma tabela chamada *Scientist* e outra chamada *Results*. A primeira está no singular e a segunda no plural. Embora isso pareça ser intuitivo, pode tornar o uso do banco de dados mais difícil no futuro, pois não só é preciso lembrar o nome da tabela, mas também se ele está no plural ou no singular. Uma convenção padrão é nomear todas as tabelas no singular, então *Results* se torna *Result*. *A padronização de nomes e a visualização clara do esquema são cruciais para a reprodutibilidade em bioinformática. Convenções consistentes evitam ambiguidades e erros em pipelines de análise, garantindo a integridade dos dados e a colaboração eficaz.*

Os tipos de dados contidos em cada banco de dados são chamados de **campos** (fields). Each field should also be named descriptively and consistently. Os nomes dos campos geralmente não devem ser longos, pois podem precisar ser digitados com frequência, o que se tornaria frustrante, mas devem transmitir o tipo de informação contida na tabela. Por exemplo, nomear cada campo como 'a', 'b', 'c' e assim por diante pode ser consistente e certamente acelera a digitação dos nomes, mas será impossível para qualquer pessoa, incluindo o projetista do banco de dados, lembrar o que está realmente contido no banco de dados. 

Foi com essas diretrizes em mente que o esquema mostrado na Fig. 2.5 foi criado. A melhoria imediata na clareza da apresentação de cada tabela é evidente ao comparar a Fig. 2.5 com a Tabela 2.2. Isso se parece muito mais em forma com o esquema simples da biblioteca apresentado na Seção 2.1.3.

Durante o processo de fornecer nomes curtos, mas descritivos, para tabelas e campos, várias questões interessantes vem à tona. Por exemplo, a informação agora contida em *Sequence* parece correta? Existem oito campos nesta tabela; seis deles estão relacionados a primers e ao design de primers, e os outros dois estão relacionados ao experimento. Neste caso, a operação de renomeação ajudou a guiar a formação do banco de dados, podemos ver agora que os campos **sequence** e **purpose** na tabela *Sequence* podem ser mais bem alocados na tabela *Experiment*, pois representam a sequência a ser amplificada neste experimento e a razão pela qual estamos fazendo o experimento. Uma vez removidos, todas as outras informações na tabela se referem a primers e, portanto, a tabela poderia ser melhor nomeada como *Primer*. Essas mudanças são mostradas em um esquema revisado mais adiante.
*O refinamento do esquema, movendo campos para tabelas mais lógicas, é análogo à classificação filogenética. Uma boa estrutura de dados, assim como uma boa taxonomia, agrupa entidades com base em relações funcionais ou evolutivas verdadeiras.*

### 2.2.2 Step 4: data types
Os processos acima foram razoavelmente intuitivos, coletar informações, agrupá-las e nomear cada peça. Agora precisamos atribuir um **tipo de dado** específico para cada peça de dado. Especificar os tipos de dados é importante porque ajuda a manter a **integridade** do banco de dados, além de ajudar a minimizar seu tamanho e maximizar a velocidade com que podemos inserir e extrair dados.
*Definir tipos de dados corretos, como 'inteiro' para coordenadas genômicas, é vital em bioinformática. Isso previne a corrupção de dados e otimiza a performance de buscas em bancos de dados com bilhões de sequências, garantindo a precisão das análises evolutivas.*

Existem um conjunto de dados padrão definidos nos padrões da ANSI (American National Standards Institute) para SQL. A maioria ou todos eles são usados em RDBMSs como MySQL, Oracle e Access, mas muitas vezes recebem nomes diferentes em cada RDBMS. Por essa razão, pode haver alguns problemas ao projetar um esquema de banco de dados para um RDBMS específico e implementá-lo em outro. Portanto, vale sempre verificar se os tipos de dados que estamos usando são compatíveis entre os dois e, se não, como eles devem ser modificados. *A variabilidade de tipos de dados entre RDBMSs espelha a diversidade de formatos em bioinformática. A interoperabilidade entre grandes bancos de dados como GenBank e Ensembl depende de um "mapeamento" cuidadoso, assim como se alinha sequências de espécies diferentes.*

Os tipos de dados discutidos nesta seção são para MySQL.
*A predominância do MySQL em bioinformática se deve ao seu caráter de código aberto, alinhado ao ethos de compartilhamento da ciência.*

**Numeric data types**
Vários dos tipos de dados numéricos mais comumente usados são apresentados na tabela 2.3. Eles podem ser divididos em dois tipos: tipos #inteiros e tipos de **ponto flutuante** (*floating point*). Uma vez que tenhamos decidido se os nossos dados requerem ou não um ponto decimal, a escolha do tipo exato dependerá de quão grandes esperamos que os nossos números armazenados sejam e com que nível de precisão queremos que o número seja armazenado. Por exemplo, se estamos armazenando apenas inteiros entre 1 e 10 em um campo, o tipo de dado #TINYINT do MySQL seria adequado. *A escolha do tipo de dados numéricos em bioinformática é crucial para a eficiência. usar TinyInt para o número de cromossomos de uma espécie, por exemplo, economiza espaço e acelera as buscas, otimizando  o banco de dados para análises genômicas em larga escala.*

Para armazenar dados de moeda, duas casas decimais podem ser sempre necessárias e, portanto, o tipo de dado poderia ser definido como *Decimal(n,d)*, onde **n** especifica a precisão total e **d** o número de dígitos que seguem o ponto decima, neste caso d = 2 e n define o valor máximo que pode ser armazenado na coluna (VALE A PENA NOTAR AQUI QUE as versões do MySQL desde a 4.1 armazenam os campos **DECIMAL** como uma string de texto, não como um tipo numérico, o que pode ter implicações na programação).
*A precisão do tipo DECIMAL é vital para dados quantitativos em biologia molecular, como concentrações de reagentes ou medições de atividade enzimática. A integridade desses valores é fundamental para a reprodutibilidade experimental e para a modelagem de vias metabólicas.*

Finalmente, para armazenar os resultados de cálculos que podem resultar em números reais, pode-se usar #FLOAT. EM geral, não é necessário definir uma precisão para #FLOAT, e, de fato, seu esquema será mais transferível se não o fizer, mas a opção existe no MySQL.
*Float é onipresente em bioinformática evolutiva sendo usado para armazenar os comprimentos de ramos em árvores filogenéticas e os valores de E-value em alinhamentos de sequência. E-value é basicamente quantos alinhamentos com a mesma pontuação (ou melhor) esperaríamos encontrar por acaso ao pesquisar em um banco de dados de determinado tamanho.*
 **Como interpretar:**

|**E-value**|**Interpretação**|
|---|---|
|**≈ 0**|Alinhamento muito significativo; improvável ser por acaso.|
|**< 1e-5**|Forte evidência de homologia (sequências relacionadas).|
|**1**|Pode haver 1 alinhamento semelhante **por acaso** no banco de dados.|
|**> 10**|Provavelmente **não** é uma correspondência real.|
Exemplo de aplicação prática:
No BLAST, veremos resultados como:
```json
Query: genA
Match: genB
E-value: 2e-100
```
A similaridade entre **genA** e **genB** é altamente significativa, portanto, há uma forte evidência de homologia (sequências relacionadas).

**Text data types**
Ao armazenar informações textuais em um banco de dados, existem diversas opções, cada uma com características específicas de armazenamento e uso. A escolha do tipo de dado correto é crucial para a integridade, eficiência e desempenho do banco de dados. Os tipos mais comuns são apresentados na Tabela 2.4, adaptado do Manual de Referência do MySQL.

Se o texto for armazenado de forma legível no banco de dados, utilizam-se os tipos de texto:
- #CHAR(n) - esse tipo reserva um espaço de armazenamento fixo para uma string de caracteres de comprimento 'n', sem mais nem menos. Isso significa que, mesmo que a string armazenada seja menor que 'n', o espaço total 'n' será ocupado.
- #VARCHAR(n): é um tipo de dado mais flexível que permite inserir strings de qualquer comprimento até um máximo de 'n' caracteres. O armazenamento é utilizado apenas para o comprimento aproximado da string inserida, tornando-o mais eficiente para dados de comprimento variável. Embora usar #VARCHAR(255) possa parecer uma opção atrativa para qualquer informação de texto (desde que tenha menos de 256 caracteres), se os dados inseridos <span style="background:rgba(205, 244, 105, 0.55)">forem de comprimento uniforme</span> (como número de série ou certos números de acesso), um #CHAR de comprimento adequado será geralmente mais eficiente em termos de espaço de armazenamento. 

Para strings de texto mais longas, podem ser utilizadas as variantes do tipo #TEXT. Embora possam parecer apenas strings #VARCHAR mais longas e se comportem de forma semelhante, é importante ter cuidado ao agrupar e ordenar valores TEXT. Por padrão, o MySQL utiliza apenas os primeiros 1024 caracteres para tais operações. Isso significa que, se duas strings TEXT começarem da mesma forma, mas divergirem após 1024 caracteres, elas serão tratadas como iguais para fins de ordenação e agrupamento, o que pode não produzir o resultado desejado.

Os *Binary Large Objects (BLOBs)* são tratados como strings binárias, em contraste com as strings de caracteres. Arquivos como PDFs, documentos do Microsoft Word, dados de imagem e outros podem ser armazenados no banco de dados como BLOBs, ordenados e pesquisados comparando suas strings binárias. Assim como ocorre com o tipo #TEXT, essas comparações são limitadas, por padrão, os primeiros 1024 bytes da string.

**Perguntas e Respostas para Revisão Ativa (Estilo Flashcards)**

Qual a principal diferença de alocação de espaço entre os tipos de dados **CHAR(n)** e **VARCHAR(n)** no MySQL e em qual situação cada um é mais eficiente
?
A principal diferença é que **CHAR(n)** aloca um espaço de armazenamento fixo de 'n' caracteres, independente do tamanho da string inserida, preenchendo o restante com espaços, se necessário, sendo mais eficiente para dados de comprimento uniforme/padronizado, como números de série. Já **VARCHAR(n)** aloca um espaço variável de até 'n' caracteres, utilizando apenas o espaço necessário para a string real, **VARCHAR(n)** é mais eficiente para dados de comprimento *variável*, como nomes ou descrições, pois economiza espaço de armazenamento ao não reservar espaço não utilizado.
<!--SR:!2025-07-19,2,248-->

Quais são as implicações de desempenho ao agrupar ou ordenar dados armazenados em tipos #TEXT ou #BLOB no #MySQL?
?
Ao agrupar ou ordenar dados do tipos TEXT e BLOB, o MySQL, por padrão, considera apenas os primeiros 1024 caracteres (para TEXT) ou bytes (para BLOB) para realizar essas operações. Isso implica que se duas strings TEXT ou BLOB forem idênticas nos primeiros 1024 caracteres/bytes, mas divergirem posteriormente, elas serão tratadas como iguais para fins de ordenação e agrupamento, o que pode levar a resultados inesperados ou incorretos na organização dos dados.
<!--SR:!2025-07-18,1,228-->

Para que servem os tipos de dados #BLOB e <span style="background:#affad1">qual a diferença fundamental</span> entre eles e os tipos #TEXT?
?
Os tipos de dados **BLOB** (Binary Large Objects) são utilizados para armazenar **dados binários** diretamente no banco de dados, isso inclui arquivos PDFs, documentos do Word, imagens, vídeos ou qualquer outro dado que não seja interpretado como texto legível. A diferença fundamental para os tipos **TEXT** é que, TEXT armazena strings de caracteres (dados legíveis e com codificação de texto), **BLOB** armazena strings de bytes brutos (dados binários).
<!--SR:!2025-07-19,2,248--> 

**Choosing and representing the data types for our example**
A figura 2.5 apresenta esses tipos de dados atribuídos a cada campo em formato de tabela. Considere os tipos sugeridos. Eles fazem sentido? Você consegue identificar algum problema com eles ou restrições? É importante destacar que não há problema em discordar de algumas dessas atribuições. Elas não são perfeitas para todos os casos, mas, ao projetar seu próprio banco de dados, você precisará considerar cuidadosamente a aplicação a que ele se destina e escolher os tipos de dados de forma apropriada. 

Como mencionado anteriormente, foi sugerido o uso de varchar(255) para a maioria dos campos de texto neste exemplo. Uma exceção é o campo *order_number* da tabela Kit, que assume que os números de pedidos atribuídos pelo departamento possuem exatamente 16 caracteres, o que elimina a necessidade de uma string com comprimento variável. 

Todas as temperaturas e durações foram consideradas como inteiros, com o tempo expresso em minutos. Essa suposição pode estar correta, <span style="background:rgba(160, 204, 246, 0.55)">ou pode ser necessário um nível de precisão maior para a temperatura ou o tempo</span>. Nesse caso, o tipo de dado #FLOAT poderia ser mais adequado.

Os tipos #DATE e #TIME são tipos especiais que ainda não haviam sido discutidos. O MySQL oferece várias formas de representá-los, que podem ser consultadas... no entanto, os formatos mais comuns são: #DATE representando o formato aaaa-mm-dd e #TIME no formato horas:minutos:segundos.

Os campos `kit_cost` (custo do kit) e `primer_cost` (custo do primer) foram representados como valores decimais com duas casas decimais e até seis dígitos no total, permitindo representar um custo máximo de 9999,99 em cada campo. A unidade monetária não é especificada nem armazenada nesses campos.

Como as imagens de gel podem ter tamanho grande, elas foram atribuídas ao tipo `MEDIUMBLOB`, que permite o armazenamento de arquivos com pouco mais de 16 MB. Alternativamente, poderia ser armazenado aqui um link para o local da imagem em um disco rígido ou servidor (na forma de uma string de texto), economizando espaço dentro do banco de dados e ainda assim permitindo acesso fácil à imagem. Essa abordagem costuma ser preferível ao armazenamento da imagem propriamente dita, <span style="background:#affad1">já que poucas operações de banco de dados seriam úteis sobre uma imagem</span>.

Por fim, a avaliação do resultado experimental foi atribuída ao tipo #TEXT, permitindo o armazenamento de descrições mais longas, de até aproximadamente 65.500 caracteres. Isso pode ser exagerado, talvez o tipo #TINYTEXT seja mais apropriado.

Um ponto interessante onde o uso de #VARCHAR(255) pode parecer estranho é o campo *tel_number* na tabela Scientist, intuitivamente poderia ser um INT. No entanto, números de telefone frequentemente incluem outros caracteres, como +, espaços e caracteres, como +, espaços e parênteses, os quais não são compatíveis com um tipo numérico. Esse problema ocorre, principalmente, porque o número de telefone não é um dado atômico, e isso nos leva ao próximo tópico.

🧠 **Perguntas**

Por que o campo **order_number** é do tipo **CHAR(16)** e não **VARCHAR(255)**?
?
Porque todos os números de pedido têm exatamente 16 caracteres, então um tipo de comprimento fixo (`CHAR`) é mais eficiente do que um tipo de tamanho variável (`VARCHAR`).
<!--SR:!2025-07-18,1,228-->

**Pergunta:** Quais tipos de dado são mais adequados para representar **temperatura** e **tempo** em experimentos com diferentes níveis de precisão?  
?
**Resposta:** `INT` pode ser usado para valores inteiros (ex.: 95°C, 30 min), mas `FLOAT` é melhor se forem necessários valores fracionários (ex.: 36,7°C ou 2,5 min).

**Pergunta:** O que `DECIMAL(6,2)` representa nos campos de custo do banco de dados?  
?
**Resposta:** Um número com até 6 dígitos no total, sendo 2 casas decimais (exemplo: 9999,99), usado para representar valores monetários com precisão.

**Pergunta:** Por que o campo `tel_number` foi definido como `VARCHAR(255)` em vez de `INT`? 
?
**Resposta:** Porque números de telefone podem conter caracteres especiais como **+**, espaços e parênteses, que não são aceitos em tipos numéricos (`INT`).

**Pergunta:** Qual o tamanho máximo de texto que pode ser armazenado em um campo `TEXT` no MySQL?
?
**Resposta:** Aproximadamente **65.535 caracteres**.


![[Chapter 2 - Building Biological Databases with SQL-3.png]]
### 2.2.3 Step 5: atomicity of data
O termo atomicidade pode parecer, a princípio, excessivamente abstrato, mas tudo o que ele significa é que cada pedaço de informação em <span style="background:#affad1">um campo deve ser o menor possível, ou seja, deve conter dados sobre apenas um item</span>.

Se considerarmos o exemplo do número de telefone, ele parece ser um único dado: um número de telefone. No entanto, esse campo <span style="background:#fdbfff">pode conter três</span> ou mais partes distintas de informação, como o código do país, o código de área e o número em si. Geralmente, as formas de representar essas informações exigem caracteres que não são números, como +, parênteses ou espaços. Isso por si só pode introduzir inconsistências e erros no banco de dados, e, portanto, <span style="background:#d4b106">qualquer forma de evitar isso é desejável.</span>

Uma forma de evitar esse problema é dividir os dados em partes menores, criando um campo para código do país, outro para código de área e outro para o número principal. Todos esses campos conterão  apenas valores inteiros, então o tipo #INT pode ser usado. Ao separarmos os campos, podemos pesquisar, por exemplo, por cientistas cientistas de um país específico utilizando o código do país como critério.

Outro exemplo está no campo *supplier_address* (endereço do fornecedor) na tabela kit. Um endereço normalmente é composto por várias partes, como: número ou nome do prédio, nome da rua, cidade, estado ou província, código postal e país. Portanto, *supplier_address* não é atômico. Para corrigir isso, seria necessário criar seis campos separados e remover o campo *supplier_address*.

O campo *name* na tabela Scientist também deve ser tratado de forma semelhante, separando, por exemplo, o primeiro nome, sobrenome e possíveis títulos.

Para garantir a atomicidade no seu banco de dados, revise cada campo e verifique se ele pode ser dividido em partes menores. Se não puder, alcançamos a atomicidade. Os benefícios completos desse princípio serão discutidos na próxima seção, mas, por hora, <span style="background:#affad1">é útil pensar na atomicidade como uma forma de tornar cada pedaço de dado o mais simples possível</span>, e coisas simples são sempre mais fáceis de lidar. 

**Flashcards**
**Pergunta:** O que significa o princípio de #atomicidade em modelagem de banco de dados #relacional?
?
**Resposta:** Significa que cada campo deve conter apenas uma informação indivisível, ou seja, não deve ser possível dividi-lo em partes menores e independentes.

**Pergunta:** Por que o campo *tel_number* pode violar o princípio da atomicidade?
?
**Resposta:** Porque ele pode conter múltiplas informações em apenas um único campo, como código do país, código de área e número de telefone, além de caracteres especiais.

### 2.2.4 Steps 6 and 7: indexing and linking tables
Agora que temos um banco de dados atômico contendo toda a informação que achamos necessária sobre os experimentos de PCR sendo realizados. No entanto, este banco de dados ainda não é relacional, não há ligações entre as tabelas, além das informações contidas nelas não estarem interligadas. Este formato funciona bem para um exemplo simples, pois podemos pensar intuitivamente que, se falássemos sobre dois diferentes experimentos, poderíamos imaginar duas páginas separadas contendo os dados, uma para cada experimento. Isso é muito parecido com uma visão em planilhas de dados. <span style="background:#d4b106">Muito do poder de um banco de dados relacional vem da capacidade de pesquisar através dos dados contidos nele para identificar tendências</span>, ordenar por diferentes variáveis, como cientistas ou fabricante, para identificar erros sistemáticos, e geralmente pesquisar os dados como um todo interligado, e não como uma série de itens discretos. Por essa razão, precisaremos adicionar alguns campos ao banco de dados que permitam que as tabelas sejam ligadas à tabela Experiment. Nesta tabela, cada experimento foi dado um número de identificação (ID). Se esse número de identificação fosse simplesmente um inteiro, cada um maior que o anterior, seria suficiente sozinho para identificar exclusivamente qualquer experimento na tabela.

Muitos designers de bancos de dados recomendam que cada tabela dentro do banco de dados tenha um identificador único **baseado em um número incremental**. Isso pode resultar em certos aumentos de desempenho em algumas circunstâncias, mas discordamos dessa abordagem em dois aspectos. O mais importante desses pontos é que isso complica o banco de dados ao introduzir campos artificiais, sem relação direta com os dados, em cada tabela. Isso torna o banco de dados mais difícil de entender, projetar e consultar. O segundo ponto é que isso quebra uma das regras formais ao projetar bancos de dados, que <span style="background:#b1ffff">é que toda a informação em uma tabela deve estar diretamente relacionada à chave</span> dessa tabela, se introduzirmos um número sequencial arbitrário na chave, quebramos essa relação. 

Então, como criar chaves sem usar identificadores numéricos? Da mesma forma que qualquer objeto é identificado no dia a dia, através de características distintivas. Como exemplo disso, consideremos a tabela Sciencist, nesta tabela, uma chave de índice poderia ser criada apenas com o sobrenome. Mas muitos sobrenomes são comuns, então podemos incluir o primeiro nome do cientista. Dessa forma, podemos construir uma chave composta para a tabela, consistindo tanto do primeiro nome quanto do sobrenome. Se pudéssemos garantir que nenhum dos cientistas terá a mesma combinação de primeiro nome e sobrenome, isso funcionaria bem, mas isso também não é verdade, muitas pessoas compartilham o mesmo nome. Nesse ponto, alguém pode sugerir adicionar o número de empregado e referenciar os cientistas usando isso. Fazê-lo tem algumas utilidades, especialmente se esse banco de dados for conectado ao sistema de recursos humanos da organização. No entanto, isso é improvável, e a maioria das pessoas não conhece seu número de empregado, então obter esses números pode ser difícil. É também tão contraintuitivo quanto usar o método de número incremental. Há uma opção melhor já presente nesta tabela — <span style="background:#fdbfff">o endereço de e-mail</span>. Por definição, isso será único para cada cientista, desde que ele tenha uma conta de e-mail. A maioria dos cientistas agora tem esses e-mails, e, se não tiverem, eles podem ser facilmente obtidos, mesmo que nunca sejam usados!

Por regra, um #ID deve ser:
- imutável
- sem significado
- curto
E-mail é mutável, com significado e com tamanho variável, geralmente, longo.

A tabela Primer, na sua forma atual, não parece ter nenhuma chave natural. Eventualmente, essa tabela também precisará ser ligada à tabela Experiment. <span style="background:#affad1">A ligação entre duas tabelas é alcançada quando elas compartilham pelo menos um campo</span>. Neste caso, nenhuma delas contém um campo presenta na outra, e portanto precisamos escolher pelo menos um campo de uma tabela para colocar na outra. Aqui, o ID parece uma boa escolha, pois as sequências de primers estarão relacionadas à sequência experimental que estamos tentando amplificar. Isso também permitirá que o ID seja usado como chave primária para a tabela Primer. Uma vez feito isso, pode-se ver que as duas tabelas agora têm ID como sua chave. Como toda a informação em ambas as tabelas é identificada de forma única pela mesma chave, logicamente toda essa informação deveria aparecer na mesma tabela, embora tenhamos pensado anteriormente que elas deveriam ser separadas. (Há um argumento de que as informações na tabela Primer devem permanecer separadas porque a mesma combinação de primers pode ser usada para mais de um experimento, e assim a mesma informação poderia ser repetida várias vezes na tabela Experiment, o que seria indesejável. A escolha final dependerá do uso final — cada experimento realizado neste laboratório geralmente usa primers diferentes ou não?)

Da mesma forma, nenhuma chave na tabela Result sugere-se naturalmente, e esses dados estão diretamente relacionados ao experimento. Esses campos, portanto, devem ser colocados dentro da tabela Experiment. A tabela Experiment agora é muito maior, conforme mostrado na Figura 2.8.
![[Chapter 2 - Building Biological Databases with SQL-4.png]]

Ao considerar a tabela Kit, uma chave adequada para a tabela poderia ser uma combinação de fabricante e nome do kit (manufacturer, name). Isso funciona para a maioria dos campos nessa tabela, exceto para aqueles relacionados ao fornecedor — um fornecedor pode fornecer muitas marcas e versões de kits, e portanto seus detalhes não são unicamente identificados por um único fabricante de kit e nome. Isso sugere que os detalhes do fornecedor devem ser retirados da tabela Kit e colocados em sua própria tabela, Supplier. Como os fornecedores de produtos similares devem ter nomes diferentes, assumimos que o fornecedor formará uma chave adequada para essa nova tabela, conforme mostrado na Figura 2.9.

No entanto, uma consideração mais profunda da tabela Kit mostra que essa chave primária também está incorreta. Se o mesmo kit for encomendado duas vezes, grande parte da informação dentro da tabela terá que ser repetida, pois isso terá um número de ordem diferente. Isso demonstra que ou (manufacturer, name) é uma chave primária incorreta, ou que essa tabela ainda não está adequadamente projetada. A resposta é a última: o número de ordem não deve estar nessa tabela, pois a maioria das outras informações na tabela não depende do número de ordem. Isso, portanto, deve ser retirado para outra tabela.

O número de ordem vincula de forma única ao fabricante e ao nome do kit e, portanto, esses campos podem também figurar na nova tabela e servir para ligar as duas tabelas. Além disso, o número de ordem é naturalmente atribuído a um fornecedor, e esse campo pode, portanto, aparecer na tabela Supplier. As tabelas resultantes e suas ligações são mostradas na Figura 2.10.

Para ligar a tabela Experiment à tabela Kit, pode ser tentador colocar o campo ID na tabela Kit, mas isso quebraria a restrição de que toda a informação na tabela Kit deve ser exclusivamente identificada por (manufacturer, name) — o número de identificação do experimento não tem nada a ver com isso. Uma escolha melhor de campos para ligar as duas tabelas é fazer isso indiretamente através da tabela Kit_order, colocando o order_number na tabela Experiment. Isso servirá para identificar de forma exclusiva qualquer kit utilizado em um experimento. Não é coincidência que a chave de uma tabela forme um bom link para outra tabela dessa maneira — elas são rotas para identificar qualquer linha única em sua própria tabela e, portanto, podem ser usadas para um propósito similar em tabelas relacionadas.

**Perguntas**
**Por que o uso de números incrementais como chaves primárias em tabelas de um banco de dados relacional pode ser problemático?**
?
**Resposta:**  
O uso de números incrementais como chaves primárias pode ser problemático por dois motivos principais:
1. **Introdução de Campos Artificiais:** Esses números não têm relação direta com os dados reais da tabela, tornando o banco de dados mais complexo e difícil de entender, projetar e consultar.
2. **Quebra de Regras Formais:** Em design de bancos de dados, todas as informações em uma tabela devem estar diretamente relacionadas à chave primária. Ao adicionar um número sequencial arbitrário, quebra-se essa relação formal.

**Como criar uma chave primária para a tabela Scientist sem usar números incrementais?**
?
Uma chave primária para a tabela Scientist pode ser criada utilizando características únicas dos cientistas. Um exemplo é o uso do endereço de e-mail, que é único para cada cientista (desde que todos tenham um e-mail). Outra alternativa seria combinar o primeiro nome e o sobrenome, mas isso pode não ser suficientemente distinto, já que muitas pessoas compartilham o mesmo nome completo. *Nem mesmo e-mail pode ser utilizado de forma eficaz, pois ele possuí significado, é mutável e até mesmo longo.*

**Defining relationships between tables**
Todos os bancos de dados do *schema* agora possuem chaves que podem ser usadas para identificar unicamente cada linha. Além disso, cada tabela está vinculada a pelo menos uma outra tabela. Essa estrutura é a base de um banco de dados relacional. Esta seção examina com mais detalhes como são formadas as relações entre as tabelas e a terminologia utilizada para descrevê-las.

As chaves definidas acima são conhecidas como *primary key* de suas respectivas tabelas (por exemplo, a *primary key* da tabela *Scientist* é e-mail). Um campo em uma tabela que faz referência a outra tabela, de modo que um valor específico só pode ser inserido se esse mesmo valor já existir na tabela referenciada, é chamado de *foreign key*. Esse mecanismo ajuda a manter a integridade dos dados e também implica uma ordem específica para a inserção de dados nas tabelas. A Figura 2.11 apresenta o *schema* completo, com as *primary keys* e *foreign keys* conectadas.

Leitores atentos notarão mudanças sutis em dois dos nomes de campos nesta figura. Especificamente, o número de ordem adicionado à tabela Experiment foi renomeado para kit_order_number, e o campo supplier na tabela Supplier foi alterado para supplier_name. Isso ocorre porque não é considerada uma boa prática usar nomes idênticos para campos relacionados entre tabelas — uma convenção que evita ambiguidades em _joins_ e melhora a legibilidade do modelo relacional.

*A anotação de boas práticas em modelagem de bancos de dados relacionais é essencial não apenas para a integridade dos dados, mas também para a escalabilidade de aplicações bioinformáticas. Quando se trata com grandes volumes de dados genômicos ou proteômicos, como em projetos de Biologia Molecular ou Sistemática Filogenética, um modelo bem projetado permite consultas eficientes e integração segura entre diferentes fontes de dados. Além disso, em ambientes de desenvolvimento modernos, como aqueles baseados em Java com Spring Framework ou Spring Boot, o uso de JPA (Java Persistence API) facilita a persistência de entidades com base nesse modelo relacional. O encapsulamento dessas aplicações em containers Docker garante portabilidade e consistência entre ambientes de desenvolvimento e produção, enquanto interfaces desenvolvidas com Angular permitem visualizações dinâmicas de dados evolutivos ou estruturais, como árvores filogenéticas ou modelos tridimensionais de proteínas. A precisão na modelagem de dados reflete diretamente na qualidade das análises em bioquímica e biofísica, onde a integridade dos parâmetros experimentais é crítica para simulações e previsões funcionais.*

Ao criar o projeto de banco de dados utilizando o método descrito anteriormente, espera-se que o *schema* resultante vincule campos de forma que, para qualquer instância de um campo em uma tabela, haja zero, uma ou várias ocorrências dessa instância em outra tabela. Por exemplo, na tabela *Scientist*, o endereço de e-mail de um pesquisador aparecerá apenas uma vez, enquanto poderá aparecer zero, uma ou várias vezes na tabela *Experiment*. Nesse último caso, esse tipo de relacionamento é descrito como *one-to-many* (um-para-muitos). No entanto, se o projeto de banco de dados ainda não estiver completamente refinado, pode-se deparar com uma situação em que várias instâncias de um campo em uma tabela estejam ligadas a múltiplas instâncias do mesmo campo em outra tabela, o que caracteriza um relacionamento *many-to-many* (muitos-para-muitos). 

Imagine que tivéssemos vinculado a tabela _Scientist_ à tabela _Experiment_ usando o _primeiro nome_ dos cientistas em vez de seus e-mails únicos. Se "Bob Andrews" tivesse realizado seis experimentos, seus dados de contatos apareceriam uma vez na tabela *Scientist*, e a string "**Bob**" apareceria seis vezes em *Experiment*. Se outro pesquisador, "Bob Barrows", também fizesse parte do grupo e realizasse quatro experimentos, seu registro apareceria uma vez em *Scientist*, mas "Bob" surgiria mais quatro vezes em *Experiment*. Nesse cenário, se as tabelas fossem ligadas pelo campo *first name*, ambas as instâncias de "Bob" surgiria mais quatro vezes em *Experiment*. Isso geraria um produto cartesiano incorreto das consultas, resultando em dados duplicados, informações imprecisas e desempenho drasticamente reduzido nas operações de busca.

Como indicado acima, esse tipo de situação não deve ocorrer em um *schema* bem projetado, e é difícil imaginar por que alguém implementaria um exemplo artificial como esse. No entanto, ele pode surgir, especialmente em bancos de dados mais complexos, geralmente devido à ausência de chaves primárias adequadas ou ao uso de campos não únicos como referências. por isso, é sempre recomendável verificar se todos os relacionamentos envolvem uma *primary key* de um lado; caso contrário, pode haver risco de criar acidentalmente um relacionamento *many-to-many* não intencional. 
*Em aplicações bioinformáticas, onde dados evolutivos, expressão gênica ou interações proteína-proteína frequentemente envolvem relações complexas entre entidades (como múltiplos genes associados a múltiplas vias metabólicas), o tratamento adequado de relacionamentos muitos-para-muitos é crucial. A solução padrão, a criação de uma tabela de junção (junction table), é não apenas uma prática recomendada em modelagem relacional, mas também essencial para a integridade semântica dos dados. Em ambientes baseados em Spring Boot com JPA, por exemplo, o uso de anotações com #ManyToMany permite mapear essas relações com precisão, facilitando consultas eficientes em grandes conjuntos de dados biológicos. Quando essas aplicações são empacotadas com Docker, a consistência do modelo de dados é preservada em diferentes ambientes, evitando falhas em pipelines de análise. Além disso, ao integrar com interfaces em Angular, torna-se possível visualizar redes biológicas complexas, como interações em vias de sinalização ou árvores filogenéticas com múltiplos mapeamentos de espécies. Em contextos de biofísica e bioquímica, onde dados estruturais e funcionais devem ser correlacionados com precisão, um modelo relacional robusto evita erros que poderiam comprometer simulações de docking molecular ou análises de dinâmica conformacional.*

### 2.2.5 Desvio do projeto
Uma vez que tenhamos finalizado o projeto do nosso banco de dados, estaremos prontos para começar a sua implementação no #SGBDR (*Relational Database Management System*) de nossa preferência. Como discutido na introdução deste capítulo, é tentador começar imediatamente a digitar comando no computador sem dedicar tempo suficiente ao planejamento do que se deseja alcançar. No entanto, se abordarmos cada novo projeto de banco de dados de forma estruturada, elaborando-o previamente no papel e investindo tempo e esforço em um design cuidadoso antes de tocar no teclado, a implementaçãoe o uso do banco de dados serão muito mais rápidos e significativamente mais simples.

A próxima seção aborda a instalação de um servidor de banco de dados MySQL em nosso computador e como utilizá-lo para, primeiramente, implementar o nosso *schema*, em seguida, povoá-lo com dados e, finalmente, consultar as informações armazenadas.

## 2.3 Installing and configuring a MySQL server
### 2.3.1 Download e instalação
Obter uma cópia do MySQL para instalar em nossa máquina é um processo simples, embora possa variar dependendo do sistema operacional em uso. O produto específico que devemos procurar, especialmente como iniciante, é a versão gratuita MySQL Community Edition em contraste com as alternativas pagas, como a **MySQL Enterprise Edition**.

Se estivermos usando o Windows, basta acessar a *Developer Zone* do site do MySQL, baixar o instalador do MySQL e executá-lo. O instalador guiará a gente...

Para tornar o MySQL e suas ferramentas associadas diretamente acessíveis pela linha de comando do Windows...

Durante a configuração do servidor MySQL, você terá a oportunidade de definir uma senha para o usuário **root** . Esse usuário é o administrador do servidor de banco de dados, com privilégios totais sobre todas as operações. É uma boa prática definir uma senha forte — desde que seja algo que você consiga lembrar! Você também pode criar contas para outros usuários nesse momento. É recomendado criar uma conta separada para uso cotidiano, evitando o uso constante do _root_ , mas abordaremos isso mais adiante; por ora, nenhuma ação adicional é necessária. Para todas as demais opções de configuração, as opções padrão ou recomendadas são suficientes.

Uma vez que o MySQL esteja instalado, você precisará iniciá-lo a partir da linha de comando do seu sistema operacional (veja o Apêndice A, caso não esteja familiarizado). Você pode iniciar o MySQL digitando `mysql` na linha de comando e pressionando _Enter_ . No entanto, se você configurou um usuário _root_ com senha durante a instalação, será necessário especificar essas credenciais com o seguinte comando:
```cmd
mysql -u root -p
```

### 2.3.2 Criação de um banco de dados e de uma conta de usuário
Neste momento, estamos conectados ao servidor MySQL como usuário root. Essa é uma posição extremamente privilegiada. Embora seja improvável que causemos danos ao nosso próprio sistema, se estivéssemos acessando um servidor de banco de dados compartilhado dentro de uma organização, esse nível de acesso poderia representar um risco significativo. Em ambos os casos, é uma boa prática criar uma conta de usuário distinta para acessar o nosso banco de dados, evitando o uso contínuo da conta *root*.

Primeiramente, precisamos de um banco de dados para trabalhar. Ele pode ser criado com o seguinte comando:
```sql
CREATE DATABASE dbname;
```

Aqui, *dbname* é um nome apropriado que escolhemos para o nosso banco de dados. (Ao longo deste livro, utilizamos itálico em exemplos genéricos de comandos para indicar placeholders, parâmetros que devem ser substituídos por valores específicos). Assim como nos nomes de tabelas, discutidos anteriormente, os nomes de bancos de dados devem ser descritivos e simples.

Observemos também o ponto e vírgula ao final do comando, ele é necessário para informar ao MySQL que o comando foi concluído. Se ele estiver ausente, ao pressionar *Enter*, o prompt mudará para ->, indicando que o MySQL espera mais comandos na linha seguinte. Nesse caso, podemos simplesmente digitar o ; em uma nova linha, e o comando será executado como se estivesse sido escrito em uma única linha. Esse é um recurso útil, embora às vezes confuso ou frustrante, que permite dividir comandos longos em múltiplas linhas, facilitando a leitura e depuração. As convenções do SQL serão discutidas com mais detalhes na seção 2.5.

Agora, podemos criar uma conta de usuário para acessar o nosos banco de dados, em vez de usar a conta *root*:
```SQL
GRANT ALL ON dbname.* TO 'username'@'localhost' IDENTIFIED by 'password';
```

Por exemplo, se você tivesse criado um banco de dados chamado _sandpit_ (um nome comum para ambientes usados para testes durante o aprendizado) e desejasse criar uma conta com o nome de usuário _Ian_ e senha _BBSbook_ , o comando seria:
```sql
GRANT ALL ON sandpit.* TO 'Ian'@'localhost' IDENTIFIED BY 'BBSbook';
```

Atenção especial deve ser dada à colocação das aspas, note, em particular, que 'Ian' e 'localhost' são entidades separadas. O asterisco * indica que todas as tabelas dentro do banco de dados *sandpit* estarão cobertas pela permissão *GRANT*. O termo *localhost* refere-se à máquina a partir da qual o acesso será feito. Se estivermos trabalhando localmente, com um servidor MySQL instalado em nossa máquina, esse valor é adequado. No entanto, se estivermos conectando de um computador remoto, será necessário substituir **localhost** pelo nome DNS completo ou pelo endereço IP da máquina de origem. Alternativamente, se desejar permitir que o novo usuário acesse o banco de dados de qualquer local (o que levanta sérias preocupações de segurança), podemos substituir **localhost** por **%**.

Após pressionar _Enter_ , o MySQL exibirá uma mensagem indicando que a operação foi concluída com sucesso, juntamente com o tempo de execução do comando — um detalhe pouco relevante neste caso, mas que ilustra como o desempenho se torna crítico à medida que os bancos de dados crescem em tamanho e complexidade.

### 2.4.5 Big Data and NoSQL databases
Uma estrutura além de um simples pareamento lógico de chaves e valores, que permita a programas do tipo *MapReduce* capturar e analisar as variáveis de interesse. Nesse contexto, o uso do SQL torna-se bastante redundante, e métodos de armazenamento de dados não estruturados, do tipo NoSQL, são geralmente preferidos.

Essa abordagem altamente flexível e pouco estruturada pode parecer desorganizada e difícil de compreender à primeira vista, mas diversos sistemas foram desenvolvidos para facilitar tanto o manuseio dos dados quanto o acesso programático a eles. Alguns destes sistemas chegam ao ponto de reintroduzir consultas semelhantes so SQL sobre os conjuntos de dados (embora com um custo significativo em desempenho), enquanto outros oferecem APIs que tornam mais acessível para programadores em geral a manipulação e execução de operações sobre os dados. Contudo, muitas vezes a abordagem **Big Data** exige uma mudança de paradigma na forma de pensar o problema, adaptando-o para ser mais compatível com esse estilo de processamento em larga escala. Como exemplo prático desse tipo de abordagem no espaço da bioinformática, Lewis et al. utilizaram #Hadoop para identificar proteínas a partir de chaves peptídicas (Lewis et al., 2012).

Esperamos que *Big Data* e os bancos de dados *NoSQL* se tornem cada vez mais importantes à medida que os conjuntos de dados biológicos continuem a crescer em volume, velocidade e diversidade. Se desejamos nos aprofundar no tema, recomendamos as leituras _Big Data Now_ (O’Reilly, 2012), _Big Data_ (Marz, 2013) e _NoSQL Databases_ (Strauch, 2011). No entanto, no futuro próximo, a maioria dos problemas de gerenciamento de dados em bioinformática ainda será bem atendida por soluções tradicionais baseadas em _SQL_ e _SGBDRs_ (Sistemas de Gerenciamento de Banco de Dados Relacionais), que são o foco do restante deste capítulo.
*Embora o paradigma NoSQL e o ecossistema Big Data, com ferramentas como Hadoopt, Spark e bancos como MongoDB ou Cassandra, ofereçam escalabilidade para lidar com sequenciamento de nova geração #NGS ou bancos de dados de variantes genéticas em escala populacional, a maioria dos projetos bioinformáticos ainda se beneficia da estrutura rigorosa do SQL. Isso é especialmente verdadeiro em áreas como sistemática filogenética, onde relações evolutivas precisam ser armazenadas com integridade referencial, ou em estudos de expressão gênica, onde metadados experimentais devem ser consistentes. Em aplicações modernas desenvolvidas com Spring Boot e Java, o uso de JPA sobre um RDBMS permite integração segura com pipelines de análise, enquanto o Docker facilita o versionamento de ambientes com dados estruturados. Já o Angular pode ser usado para visualizar resultados de consultas SQL complexas, como redes regulatórias ou perfis de expressão. Em contextos de bioquímica e biofísica, onde a precisão nos dados estruturas PDB e cinéticos é essencial, o controle transacional do SQL é insubstituível. Assim, enquanto o NoSQL brilha em ingestão massiva de dados brutos, o SQL continua sendo o alicerce para análise confiável, interpretação biológica e reprodutibilidade científica.*

## 2.5 Database access using SQL
#SQL é uma linguagem usada principalmente para consultar nosso banco de dados. Como esta seção demonstrará, para quase todas as operações que desejamos realizar com o nosso banco de dados, o comando SQL pode ser gerado de forma direta, utilizando apenas algumas palavras-chave simples. Assim como na estrutura do próprio banco de dados, não é a implementação em si que é mais importante, mas sim o design das nossas consultas que faz a diferença. É nesse estágio que a qualidade do pensamento por trás do projeto do banco de dados se revela. Uma estrutura mal projetada resultará em baixo desempenho durante as consultas, ou, pior ainda, em dados incompletos ou incorretos retornados por comandos SQL que, sintática e logicamente, podem parecer corretos.

Por convenção, todos os comandos SQL são escritos em letras maiúsculas. Isso ajuda a distingui-los de termos não SQL, como nomes de tabelas e campos. Essa convenção é adotada ao longo deste livro. No entanto, não é obrigatório digitar os comandos em maiúsculas ao executar consultas, o resultado será exatamente o mesmo, independentemente da caixa utilizada.

Um erro comum a ser evitado é o uso de palavras reservadas do SQL (como table, values, select, order, entre outras.) como nomes de objetos do banco de dados, como bancos de dados, tabelas ou campos. Esse tipo de uso pode confundir o RDBMS, provavelmente resultando em erros de sintaxe difíceis de diagnosticar, já que a consulta pode não parecer claramente incorreta. Nesses casos, é essencial verificar cuidadosamente se há conflitos entre os nomes escolhidos e as palavras reservadas do SQL.

### 2.5.1 Compatibility between RDBMSs
