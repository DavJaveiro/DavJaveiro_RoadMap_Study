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

### 2.2.2 Step 5: atomicity of data

