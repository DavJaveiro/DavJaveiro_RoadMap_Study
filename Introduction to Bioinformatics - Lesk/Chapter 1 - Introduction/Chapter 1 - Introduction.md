*Learning Goals*
- Obter uma visão geral do assunto: os tópicos, as questões, o ponto de vista e exemplos de problemas específicos e como resolvê-los. Muitos dos tópicos neste capítulo são desenvolvidos em outras partes do livro.
- Revisar e reunir os princípios gerais da biologia molecular necessários para lidar com dados de sequências, estruturas, interações, metabolismo e regulação.
- Compreender a altíssima capacidade dos fluxos de dados que estão produzindo informações para a biologia molecular, especialmente, mas não exclusivamente, por meio do sequenciamento genômico completo rápido. O desafio de tornar esses dados manejáveis é o campo da bioinformática.
- Entender as características essenciais de um **banco de dados:** sua abrangência, sua organização e as rotas de acesso para recuperar as informações que ele contém.
- Reconhecer a importância do controle de qualidade e da anotação na **curadoria de dados**.
- Compreender o papel do **hardware e software** na infraestrutura da bioinformática. Avaliar seus próprios talentos, habilidades e interesses, e **decidir até que ponto** deseja <span style="background:#b1ffff">criar programas</span> ou <span style="background:#affad1">apenas desenvolver expertise no uso deles</span>.
- Conhecer os princípios básicos da **estrutura de proteínas**, e em que medida as estruturas proteicas podem ser previstas a partir de sequências de aminoácidos.
- Estar familiarizado com o tipo de questões abordadas pelos campos da **transcriptômica e proteômica,** e os métodos usados para coletar e analisar os dados necessários para respondê-las.
- Reconhecer as implicações clínicas das descobertas em biologia molecular e o papel da bioinformática na criação de vínculos entre o laboratório e a prática clínica.
- Distinguir entre dados *estáticos* - por exemplo, a sequência de DNA em uma célula, e dados *dinâmicos*, como os padrões de transcrição, e reconhecer que, por trás dos dados dinâmicos, existem mecanismos de controle extensos e complexos.

A biologia tem sido, tradicionalmente, uma ciência mais <span style="background:#b1ffff">observacional do que dedutiva</span>. Embora os avanços recentes não tenham alterado essa orientação fundamental, a natureza dos dados mudou radicalmente. Pode-se argumentar que, até pouco tempo atrás, a maioria das observações biológicas era fundamentalmente anedótica - ainda que, em alguns casos, com graus variados de precisão, alguns dos quais realmente muito altos.  No entanto, na geração mais recente, os dados se tornaram não apenas muito mais quantitativos e precisos, mas, no caso das sequências de nucleotídeos e aminoácidos, tornaram-se discretos. Hoje, é possível determinar a sequência genômica de um organismo individual ou de um clone não apenas de forma completa, mas, em princípio, com exatidão. O erro experimental nunca pode ser totalmente evitado, mas a qualidade dos métodos modernos de sequenciamento genômico é extremamente alta. Isso não significa, porém, que a biologia tenha se tornado uma ciência dedutiva. A vida obedece, sim, aos princípios da física e da química, mas, por ora, <span style="background:#b1ffff">ela é complexa demais</span>, e dependente demais de <span style="background:#fdbfff">contingências históricas</span>, para que possamos deduzir suas propriedades detalhadas a partir de princípios básicos. 
Uma segunda propriedade evidente dos dados de bioinformática é a <span style="background:#d4b106">sua quantidade extremamente grande</span>. Atualmente, os bancos de dados de sequências de nucleotídeos contêm 6 x 10<sup>11</sup> bases (abreviado para 600 Gbp, ou *gigabaseparis*). Se usarmos o tamanho aproximado do genoma humano - 3 x 10^9 letras, como unidade, isso equivale a 200 genomas humanos (ou 200 *huges*, um nome bastante apropriado; para um padrão de comparação mais compreensível, 1 huge é comparável ao número de caracteres presentes em seis anos completos de edições de New York Times).

Um banco de dados de estruturas macromoleculares contém mais de 100.000 entradas, com as coordenadas tridimensionais completas de proteínas, ácidos nucleicos e seus complexos, com comprimento típico de aproximadamente 400 resíduos.

Não apenas os bancos de dados individuais são grandes, como também seu tamanho está aumentando a uma taxa extremamente alta. A Figura 1.1 mostra o crescimento, na última década, dos bancos de dados de sequências de nucleotídeos (que arquivam sequências de ácidos nucleicos) e do Worldwide Protein Data Bank (que arquiva estruturas macromoleculares). <span style="background:#b1ffff">Fazer extrapolações seria arriscado</span>. Ou seja, a ciência dos dados em bioinformática está crescendo tão rápido que é tentador prever o futuro com base no passado, mas os autores alertam: isso pode ser enganoso.
![[Introduction to Bioinformatics - Lesk/Chapter 1 - Introduction/imagens/Chapter 1 - Introduction.png]]
1. a) Crescimento dos bancos de dados de sequências de nucleotídeos.
2. b) Crescimento do PDB, arquivo de estruturas tridimensionais de macromoléculas biológicas.

A crescente qualidade, quantidade e variedade dos dados tem incentivado os cientistas a buscar metas igualmente ambiciosas:
- Que se diga que eles *viram a vida com clareza e em sua totalidade*, ou seja, compreender aspectos integrados da biologia dos organismos, vistos como organizações complexas e coerentes, em níveis microscópico e macroscópico;
- Curar, anotar e importa uma estrutura aos dados disponíveis, além de oferecer meios de acesso e distribuição;
- Estabelecer relações entre sequência, estrutura tridimensional, padrão de expressão, interações e função.
- Utilizar!

De fato, a biologia tem sido uma ciência aplicada ao longo de toda a história humana. Agora, tanto quanto antes, a sociedade enfrenta diversos problemas extremamente sérios. Alguns deles têm possíveis soluções científicas, incluindo:
- Melhoria da saúde de seres humanos, animais e plantas. Contribuições possíveis incluem a identificação de estilos de vida que previnem ou, ao menos, reduzem o risco de doenças, e o tratamento de enfermidades quando elas surgem. Há consenso de que a bioinformática terá um papel essencial; por exemplo, a análise de dados de sequenciamento genômico pode identificar riscos, auxiliar no diagnóstico e prognóstico de doenças e orientar tratamentos personalizados para o paciente (farmacogenômica);
- Fornecimento de nutrição adequada para uma população em crescimento;
- Fornecimento de energia para sustentar indústrias, transporte, comunicações e aparelhos pessoais como computadores, telefones, tocadores de música, etc.;
- Desenvolvimento de novos materiais;
- Identificação das causas e efeitos das mudanças climáticas, além do desenvolvimento de formas de desacelerá-las;
- Orientação de esforços de conservação, especialmente na preservação de espécies ameaçadas.

Uma ou duas gerações atrás, a física representava a esperança de soluções técnicas para nossos problemas, especialmente por meio do fornecimento de energia limpa e barata. Agora é a vez da biologia. Ainda mais do que a física, <span style="background:#b1ffff">a biologia é orientada por dados</span>. Diante dos fluxos, ou, talvez, mais apropriadamente, inundanções de dados, a análise se tornou cada vez mais desafiadora.

A bioinformática não apenas desenvolveu ferramentas poderosas, como também seus métodos estão se tornando cada vez mais integrados ao empreendimento biomédico. Grandes centros de genoma normalmente contam com tantos especialistas em computação quanto cientistas de laboratório *úmido* (isto é, que trabalham diretamente com experimentos biológicos). Além disso, <span style="background:#b1ffff">a computação não é exclusiva dos especialistas</span>: cursos de bioinformáticas são componentes comuns nos currículos universitários.

Este livro tem como público **cientistas que não pretendem se tornar especialistas em computação**, mas que reconhecem que a contribuição da bioinformática para suas pesquisas é essencial.

## Life in space and time
É difícil definir vida, e pode ser necessário modificar essa definição à medida que os computadores se tornam mais potentes e a interface entre o silício e a vida se torna mais íntima. Por hora, tente esta definição: *um organismo biológico é um dispositivo naturalmente existente, autorreprodutivo, que realiza manipulações controladas de matéria, energia e informação.*

De uma perspectiva mais distante,  a vida na Terra é um sistema complexo, auto-perpertuante e em evolução, distribuído no espaço e no tempo. É de extrema importância o fato de que ela é, em grande parte, composta por organismos individuais e discretos, cada um com tempo de vida finito e, exceto em populações clonais, com características únicas. 

Espacialmente, começando de muito longe e aproximando progressivamente, pode-se distinguir, dentro da biosfera, ecossistemas locais, estáveis até que suas condições ambientais mudem ou sejam invadidos. Cada espécie dentro de um ecossistema é composta por organismos que realizam atividades individuais, ainda que não totalmente independentes.

Os organismos são compostos por células. Cada célula é um ecossistema local íntimo, não isolado do seu ambiente, mas que interage com ele de maneiras específicas e controladas. Células eucarióticas contêm uma estrutura interna complexa, incluindo núcleos, outras organelas subcelulares e um citoesqueleto. E, finalmente, chegamos ao nível das moléculas.

A vida se estende não apenas no espaço, mas também no tempo. O que vemos hoje é um **instantâneo de uma fase** na história da vida que se estende para trás no tempo por pelo menos 3,5 bilhões de anos. A teoria da seleção natural tem sido extremamente bem-sucedida em racionalizar o processo de desenvolvimento da vida. No entanto, acidentes históricos desempenham um papel dominante demais na determinação do curso dos eventos para permitir previsões detalhadas.

O DNA de organismos extintos fornece apenas um acesso limitado ao registro histórico no nível molecular. Em vez disso, devemos tentar ler o passado nos genomas contemporâneos. O juiz da Suprema Corte dos EUA, Felix Frankfurter, escreveu certa vez que *a constituição americana não é apenas um documento, é um fluxo histórico.* O mesmo vale para os genomas, que contêm registros de seu próprio passado.

## Phenotype = genotype + environment + life history + epigenetics
Até que ponto o conteúdo dos nossos genomas determina quem somos?
Cada leitor deste livro é um **indivíduo**, com características físicas, bioquímicas e psicológicas. (Não se surpreenda se essas distinções se tornarem cada vez mais tênues ao longo da nossa vida.) Cada um de nós possuímos uma **forma geral e metabolismo comuns** a todos os humanos e, no nível molecular, muito em comum com outras espécies também. No entanto, há uma variação considerável dentro da nossa espécie, o que confere a você uma aparência e um caráter individual. Nos encontramos em algum ponto do espectro entre uma boa saúde robusta e uma doença grave. Está, nesse momento, em algum estado psicológico e em algum humor, refletindo sua personalidade e suas atividades atuais.
- Seu genótipo é a sua sequência de DNA, tanto nuclear quanto mitocondrial. 
- Seu fenótipo é o conjunto de suas características observáveis, excetuando o genótipo. Isso inclui propriedades macroscópicas como altura, peso, cor dos olhos e dos cabelos; e também propriedades microscópicas como altura, peso, cor dos olhos e dos cabelos; e também propriedades microscópicas, como o fato de sofrermos ou não de anemia falciforme, e o seu haplótipo no locus do complexo principal de histocompatibilidade (MHC).
- Sua **história de vida** inclui o **total integrado de suas experiências**, bem como o **ambiente físico e psicológico** no qual você se desenvolveu. Sua **história nutricional** influenciou seu desenvolvimento físico. Para muitos, um ambiente acolhedor e **oportunidades educacionais** influenciaram o desenvolvimento psicológico. O que talvez seja menos óbvio do que a maioria dos aspectos da sua história de vida é o **reconhecimento crescente da importância do seu ambiente intrauterino** na determinação da sua curva de desenvolvimento e até mesmo de suas **características na vida adulta**. Não somos apenas resultados do nosso DNA e da nossa criação pós-natal, mas também da experiência vivida ainda no útero, algo que hoje é cada vez mais reconhecido pela ciência como fundamental para entender nossa saúde e comportamento na vida adulta.

- Na interface entre o genoma e a experiência de vida estão os fatores epigenéticos. É, em grande parte, verdade que todas as células do seu corpo, exceto os espermatozoides ou óvulos, os eritrócitos (glóbulos vermelhos) e as células do sistema imunológico, possuem praticamente a mesma sequência de DNA. Ainda assim, seus tecidos são diferenciados, com diferentes conjuntos de genes ativados ou silenciados no fígado, no cérebro, etc. Alguns desses **sinais regulatórios** sobrevivem à divisão celular. (Quando uma **célula hepática** se divide, ela dá origem a **duas células hepáticas**.) A **história de vida dos seus pais** pode ter alterado os **padrões epigenéticos** nas células deles, e o **óvulo fertilizado** do qual você se formou continha **alguns desses sinais “pré-diferenciacionais”**. Por meio da **epigenética**, a **herança de características adquiridas** — uma ideia que durante muito tempo foi desacreditada — voltou a fazer parte da **biologia respeitável e convencional**.
 
A importância relativa desses fatores na determinação do nosso fenótipo varia de característica para característica. Algumas são determinadas exclusivamente pelos nossos alelos para genes únicos e específicos. Outras dependem de interações complexas entre nossos genes e a nossa história de vida, além de sinais epigenéticos herdados dos nossos pais.

## Evolution is the change over time in the world of living things
Os processos evolutivos alteram as distribuições de genótipos e fenótipos ao longo das gerações. O **genótipo** é a **informação genética** de um organismo, ou seja, a **sequência do seu genoma**. Todas as demais características observáveis de um organismo, tanto macroscópicas quanto bioquímicas, compõem o nosso fenótipo.

O genótipo é herdado de um ou dois progenitores, sujeito a modificações por **mutações** ou por transferência lateral de material genético. Já o fenótipo depende do genótipo, incluindo os sinais epigenéticos, que controlam o desenvolvimento do organismo sob influência do ambiente. 

A assimetria entre genótipo e genótipo é o motor da evolução.
- Alterações nos genótipos são herdáveis. Já os efeitos do ambiente ou do estilo de vida sobre o fenótipo, por exemplo, nutrição melhor levando a um corpo maior, ou os efeitos debilitantes de doenças ou lesões, não são diretamente herdáveis.
- Durante o desenvolvimento de qualquer organismo, o genótipo impõe restrições ao fenótipo. <span style="background:#ff4d4f">O fenótipo não influencia o genótipo</span>.
- Vários genótipos podem gerar o mesmo fenótipo. Por exemplo:
	- Muitas <span style="background:#b1ffff">mutações em genes codificadores de proteínas</span> <span style="background:#affad1">não alteram a sequência de aminoácidos</span>, ou produzem modificações sem efeito aparente na função;
	- Alelos são formas diferentes (sequências) do mesmo gene. Qualquer organismo que possua duas cópias de um gene em posições equivalentes no genoma pode ter, nesse local, duas cópias do mesmo alelo (homozigose) ou dois alelos diferentes (heterozigose). (Em mamíferos, cerca de 20% dos loci são heterozigotos). Homozigotos e heterozigotos têm genótipos diferentes, mas se um único gene controla exclusivamente uma característica e um dos alelos é dominante, **homozigotos e heterozigotos podem apresentar o mesmo fenótipo**. Portanto, embora o genótipos AA (homozigoto dominante) e Aa (heterozigoto) sejam diferentes em sua composição genética, ambos resultarão no mesmo fenótipo de flores vermelhas, porque o alelo vermelho (A) é dominante.

A maior parte da vida é composta por organismos discretos. Uma população é um grupo de organismos semelhantes que interagem entre si. Populações de organismos que se reproduzem sexualmente cruzam-se entre si; os indivíduos, em todas as populações, competem por recursos.
Os processos evolutivos alteram a composição e a distribuição dos pools gênicos e dos fenótipos nas populações.
Pode-se argumentar que a população é a verdadeira unidade da atividade evolutiva. 

**Qual é o mecanismo da evolução?**
Dentro de uma população, surgem indivíduos com uma variedade de genótipos, exibindo uma variedade correspondente de fenótipos. Embora a seleção natural não atue diretamente sobre o genótipo, indivíduos com <span style="background:#b1ffff">diferentes fenótipos apresentam</span> sucesso reprodutivo diferencial. Como resultado, a nova geração pode apresentar uma **distribuição alterada** de genótipos e fenótipos.

A seleção natural, reprodução aumentada por indivíduos *mais aptos*, é o mecanismo mais importante da evolução. 

Outro mecanismo evolutivo é a deriva genética, que é a mudança aleatória nas frequências alélicas, sem relação direta com a seleção. A deriva genética é especialmente importante em <span style="background:#b1ffff">populações pequenas</span> e isoladas.

Os mecanismos que geram variedade genética criam o potencial para a evolução:
- **Mutações**, como<span style="background:#affad1"> substituições pontuais</span>, <span style="background:#affad1">inserções</span> e <span style="background:#d3f8b6">deleções</span>, e <span style="background:#affad1">transposições</span>. As taxas de ocorrência de mutações pontuais são estimadas entre 10<sup>-12</sup> e 10<sup>-10</sup> por par de bases por geração (isso não é o mesmo que a taxa de substituição alélica em uma população; mutações apenas propõem candidatos para a mudança evolutiva);
- **Recombinação,** que pode reunir diferentes loci ou separá-los. A recombinação dentro de um gene pode criar um novo *alelo*, enquanto a recombinação fora de genes pode afetar a relação entre **genes** e **elementos regulatórios**;
- **Duplicação gênica**, seguida por divergência;
- **Perda gênica**, seja por deleção ou por mutações que destroem a expressão ou função do gene;
- **Fluxo gênico**, proveniente da mistura de populações, ou da **transferência gênica entre espécies**.

A evolução pode **aumentar ou diminuir** a variedade nos pools gênicos. Se uma mutação nova confere vantagem seletiva apenas no estado **homozigoto**, o gene pode se espalhar por toda a população. 
A adoção do alelo por todos os membros de uma população pode  diminuir a variedade no pool gênico. 

Algumas mutações criam alelos recessivos que são prejudiciais apenas no estado homozigoto. Esses alelos são mais difíceis de serem eliminados de uma população, especialmente se os heterozigotos tiverem alguma vantagem compensatória. Um exemplo <span style="background:#affad1">é o gene da anemia falciforme</span>, que confere aos heterozigotos uma maior resistência à malária. 

O termo microevolução refere-se a mudanças relativamente pequenas em alguns genes, levando na maioria dos casos a alterações fenotípicas também pequenas. A microevolução afeta os indivíduos dentro de uma população. Técnicas modernas nos permitem acompanhar a microevolução no nível **molecular**, por meio de medições de sequências genômicas, padrões de transcrição de RNA e expressão de proteínas.

Já a macroevolução refere-se a mudanças em escala maior, afetando populações inteiras, incluindo a formação de novas espécies. O registro fóssil fornece uma história parcial da macroevolução, revelando relações filogenéticas e utilizando métodos geológicos para datar os eventos. A anatomia comparada, a fisiologia e a embriologia oferecem pistas adicionais.

As observações de microevolução e macroevolução se complementam. As sequências genômicas auxiliam na classificação das espécies. O registro fóssil permite datar eventos passados que tiveram consequências em nível molecular, efeitos que podemos observar atualmente.

Um dos grandes desafios da biologia moderna é compreender como eventos de grande escala, como o surgimento de novas espécies, podem ocorrer como resultado composto de eventos microevolutivos.

## Dogmas: central and peripheral
O arquivo de informações de cada organismo, o repertório para seu desenvolvimento e atividade potenciais, é o material genético: DNA ou, em alguns vírus, RNA.

As moléculas de DNA e RNA são longas cadeias lineares que contêm uma mensagem escrita com um alfabeto de quatro letras.
Mesmo nos microrganismos, essa mensagem é extensa, tipicamente com cerca de 1 milhão de caracteres. 
Com certeza! Para ajustar a tabela, preciso de um pouco mais de informação sobre como você gostaria que ela fosse ajustada.



**Os quatro nucleotídeos que ocorrem naturalmente no DNA (RNA)*

|           |                           |
| --------- | ------------------------- |
| **Letra** | **Nome**                  |
| A         | Adenine                   |
| G         | Guanine                   |
| C         | Cytosine                  |
| T         | Thymine ( RNA - U Uracil) |

**Os vinte aminoácidos que ocorrem naturalmente em proteínas**

**Aminoácidos Não Polares**

|           |            |           |          |           |                                                       |           |            |
| --------- | ---------- | --------- | -------- | --------- | ----------------------------------------------------- | --------- | ---------- |
| **Letra** | **Nome**   | **Letra** | **Nome** | **Letra** | **Nome**                                              | **Letra** | **Nome**   |
| G         | Glycine    | A         | Alanine  | P         | Proline                                               | V         | Valine     |
| I         | Isoleucine | L         | Leucine  | F         | <span style="background:#affad1">Phenylalanine</span> | M         | Methionine |

**Aminoácidos Polares**

|           |           |           |                                                   |           |           |           |            |
| --------- | --------- | --------- | ------------------------------------------------- | --------- | --------- | --------- | ---------- |
| **Letra** | **Nome**  | **Letra** | **Nome**                                          | **Letra** | **Nome**  | **Letra** | **Nome**   |
| S         | Serine    | C         | Cysteine                                          | T         | Threonine | N         | Asparagine |
| Q         | Glutamine | H         | <span style="background:#affad1">Histidine</span> | Y         | Tyrosine  | W         | Tryptophan |

**Aminoácidos Carregados**

|   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|
|**Letra**|**Nome**|**Letra**|**Nome**|**Letra**|**Nome**|**Letra**|**Nome**|
|D|Aspartic acid|E|Glutamic acid|K|Lysine|R|Arginine|
Em condições fisiológicas típicas, muitos resíduos   de histidina estão carregados. Outras classificações de **aminoácidos** também podem ser úteis. Por exemplo, histidina, fenilalanina, tirosina e triptofano são aromáticos, e observa-se que desempenham papéis estruturais especiais em proteínas de membrana.

Além dos códigos de uma letra apresentados na tabela, os nomes dos aminoácidos são frequentemente abreviados pelas três primeiras letras: Gly para glicina. Há exceções: isoleucina, asparagina, glutamina e triptofano, que são abreviadas como lle, Asn, Gln e Trp, respectivamente.

O aminoácido raro selenocisteína é abreviado como Sec.

A dupla hélice e sua automcomplementaridade interna, que permite uma replicação precisa, são bem conhecidas. Uma replicação quase perfeita é essencial para a estabilidade da herança, mas uma certa dose de replicação imperfeita, ou algum mecanismo de entrada de material genético estrangeiro, também é fundamental. Caso contrário, <span style="background:#b1ffff">a evolução não poderia ocorrer em organismos assexuados</span>. 

As fitas da dupla hélice são antiparalelas; as direções ao longo de cada fita são chamadas de 3' (três linha) e 5' (cinco linha).

<span style="background:#d4b106">A implementação da informação genética ocorre</span>, inicialmente, por meio da síntese de RNA e proteínas.
O RNA referido no dogma central é o RNA mensageiro (mRNA). o #mRNA é copiado a partir de um **gene codificador de proteína** e, em eucariotos, pode requerer *splicing* para remover *íntrons não codificantes*.
O **splicing alternativo** pode levar à produção de várias proteínas diferentes a partir do mesmo gene, por meio de uma combinação variável de *éxons* ("mistura e combinação"). 

Hoje se reconhece que o mundo do RNA possui uma rica variedade de estruturas e funções. 
Ribozimas são moléculas de RNA com **atividade enzimática**.
O próprio **ribossomo** é um exemplo: embora seja um complexo RNA-proteína, sua atividade catalítica, a síntese da cadeia polipepetídicca dirigida pelo mRNA, reside no RNA.

Outros tipos de RNA, como o RNA interferente pequena (siRNA), microRNA (miRNA) e piwi-interacting RNAs (piRNAs), <span style="background:#b1ffff">atuam no controle da tradução</span>.

As proteínas são as moléculas responsáveis por grande parte da estrutura e da atividade bioquímica dos organismos.
Assim como os ácidos nucleicos, as proteínas são moléculas lineares e longas em cadeia. O código genético é, na verdade, uma cifra: trincas sucessivos de letras da sequência de DNA especificam aminoácidos sucessivos; **segmentos da sequência de DNA** codificam sequências de aminoácidos das proteínas.  Códigos genéticos alternativos aparecem em algumas organelas, como **cloroplastos e mitocôndrias**, e também em certas espécies. 

Tipicamente, <span style="background:#affad1">as proteínas possuem entre 200 e 400 aminoácidos</span>, exigindo de 600 a 1200 letras (pares de bases) da mensagem de DNA expressa para codificá-las. As sequências de DNA também direcionam a síntese de moléculas de RNA, como, por exemplo, os componentes de RNA do ribossomo. As sequências de DNA também direcionam a síntese de moléculas de RNA, como, por exemplo, os componentes de RNA do ribossomo.

No entanto, nem todo DNA é expresso como **proteína** ou **RNA estrutural**. A maioria dos genes em organismos superiores (eucariontes) contém regiões internas não traduzidas, chamadas de íntrons.

Algumas regiões da sequência de DNA são dedicadas a mecanismos de controle. E uma parte substancial dos genomas de organismos superiores tem sido chamada de *DNA lixo, junk DNA*, o que pode simplesmente significar que ainda não compreendemos sua função.

*O Projeto ENCODE*
Quando o genoma humana foi sequenciado pela primeira vez, estimou-se que havia apenas cerca de 23.000 genes codificadores de proteínas, o que representa cerca de 1,5% do genoma. Esse número foi menor do que o esperado, estimativas anteriores muito maiores, se examinadas com cuidado, não tinham base confiável. É verdade que o **splicing alternativo** permite que o número de proteínas produzidas não se limite ao número de genes codificadores. O sistema imunológico, por exemplo, gera a grande maioria das proteínas individuais do nosso corpo, mas utiliza um sistema de recombinação diferente, no nível do DNA, e não apenas do RNA.

Além das proteínas, existem regiões do DNA que codificam moléculas de RNA não mensageiro, incluindo, mas não se limitando a, **componentes de RNA do ribossomo** e **RNAs transportadores (tRNAs)**. 
Mesmo assim, a função de mais de **99% do DNA não codificador de proteínas** permanecia um mistério. Embora seja evidente que algumas dessas regiões não codificantes tenham função regulatória, havia uma tendência de se referir a grandes porções como DNA lixo. 
Mesmo assim, a função de mais de **99% do DNA não codificador de proteínas** permanecia um mistério. Embora seja evidente que algumas dessas regiões não codificantes tenham função regulatória, havia uma tendência de se referir a grandes porções como DNA lixo. 
O biólogo **Sydney Brenner** chegou a fazer uma distinção curiosa: **"junk"** seria material inútil que você guarda, enquanto **"garbage"** é o material inútil que você joga fora.
Existem duas maneiras principais pelas quais uma região não codificante do DNA pode ter função: mesmo que não seja transcrita, <span style="background:#affad1">pode participar de interações físicas dependentes da sequência</span>, dentro da cromatina, que a tornam acessível ou inacessível a proteínas ligantes.
![[Introduction to Bioinformatics - Lesk/Chapter 1 - Introduction/imagens/Chapter 1 - Introduction-2.png]]
Se for transcrita, pode originar RNAs com diversas funções possíveis, sendo a mais comum a regulação da transcrição.
As categorias dos resultados da análise do ENCODE incluem: 
- evidências de que **75% do genoma humano é transcrito;**
- um **mapeamento e um dicionário de regiões regulatórias** do genoma, trechos de DNA que se ligam a proteínas para controlar a transcrição. São **8,4 milhões** dessas regiões, correspondendo ao dobro da quantidade de DNA que codifica proteínas. A afinidade é **muito-para-um**: várias proteínas podem se ligar à mesma região regulatória. 
- um **esboço da estrutura da rede regulatória**, revelando uma lógica **detalhada e complexa** das interações que ativam ou inibem a expressão gênica, incluindo **circuitos de retroalimentação**. Muitas interações contribuem para a decisão final de expressão.
- um **mapeamento de regiões expostas na cromatina,** desprotegidas da clivagem pela enzima DNase I. Esse locais marcam regiões regulatórias tipicamente próximas aos genes, servindo como **pontos de ligação para reguladores da expressão**.

Os dados fornecidos pelo projeto ENCODE servirão como **plataforma de lançamento para muitos projetos de pesquisa futuros.**.
*Agora, isso não é o fim. Nem mesmo é o começo do fim. Mas talvez seja o fim do começo.*

No DNA, as moléculas que compõem o *alfabeto* são **quimicamente semelhantes**, e a estrutura do DNA é, em uma primeira aproximação, **uniforme** (embora algumas interações-DNA-proteína possam distorcer essa estrutura).
Em contraste, as proteínas e os RNAs estruturais apresentam grande variedade em suas conformações tridimensionais, o que é necessário para sustentar seus papéis **estruturais e funcionais altamente diversos**.

A sequência de aminoácido de uma proteína **determina sua estrutura tridimensional**. Para cada sequência natural de aminoácidos, existe um estado nativo estável e único, que é adotado **espontaneamente** sob condições adequadas. Se uma proteína purificada é aquecida ou exposta a condições muito diferentes do ambiente fisiológico normal, ela pode **desenrolar-se** (unfolding), assumindo uma estrutura desordenada e biologicamente inativa. (Por isso, nossos corpos possuem mecanismos para manter condições internas quase constantes).

Quando as condições normais são restauradas, as moléculas da proteína geralmente **retornam à sua estrutura nativa, indistinguível do estado original.** No entanto, há exceções importantes. 
A desnaturação irreversível, que leva à formação de agregados insolúveis, é um fenômeno bem conhecido no nosso dia a dia, por exemplo, quando cozinhamos um ovo. Tais agregados estão associados a diversas doenças, incluindo a **doença de Alzheimer** e as **encefalopatias espongiformes bovinas** (como a chamada **doença da vaca louca**).

As funções das proteínas dependem de sua capacidade de adotar sua estrutura tridimensional nativa.  Por exemplo, a estrutura nativa de uma **enzima** pode apresentar uma cavidade na superfície que se liga a uma molécula pequena e a posiciona próxima a **resíduos catalíticos**.
Muitos **mecanismos regulatórios** dependem da ligação de proteínas e **outras proteínas** ou ao **DNA**.
Dessa forma, temos o seguinte **paradigma:**
- a sequência de DNA determina a sequência da proteína; 
- a sequência da proteína determina a sua estrutura;
- a estrutura da proteína determina a sua função;
- os **mecanismos regulatórios**, incluindo, mas não se limitando ao controle de padrões de expressão, garantem a quantidade certa da função, no local certo, no momento certo.

Grande parte da atividade organizada em **bioinformática** tem se concentrado na análise de dados relacionados a esses processos.

## Statics and dynamics
A sequência genômica de uma célula, e o repertório de RNAs e proteínas que ela implica, expressa o que a célula pode ser e pode fazer. 
Mas as células fazem escolhas.
Redes densas e logicamente integradas de <span style="background:#affad1">mecanismos de controle</span> governam o estado dinâmico da atividade metabólica e transcricional da célula.

A dinâmica da biologia molecular de células e organismos inclui níveis acima do molecular, relacionados à estrutura e organização. Exemplos disso são questões de como os tecidos se especializam durante o desenvolvimento, ou mais geralmente, **como efeitos ambientais exercem controle sobre eventos genéticos**. Em alguns casos de circuitos de retroalimentação simples, entende-se em nível molecular como o aumento de um reagente leva ao aumento da produção de uma enzima que catalisa sua transformação.

O **operon lac** da *Escherichia coli* é um exemplo clássico.

Mais complexos são os **programas de desenvolvimento** que se desdobram ao longo da vida de um organismo.

O **aprendizado**, que precisa se refletir em **mudanças na estrutura e na dinâmica do sistema nervoso**, é de fato um **processo de desenvolvimento**.

Esses problemas fascinantes sobre **fluxo de informação e controle em um organismo** agora fazem parte do escopo da **bioinformática moderna**.

Por exemplo, foi relatado recentemente³ que, em **abelhas**, os **padrões de metilação do DNA** — ou seja, **sinais epigenéticos** — controlam de forma **reversível** os **padrões de comportamento**.

Diversos **novos fluxos de dados experimentais** refletem aspectos **dinâmicos da biologia molecular**. Entre as novas técnicas utilizadas, destacam-se:
- Sequenciamento do conteúdo de RNA de células para medir o transcritoma;
- Determinação dos padrões de metilação do DNA;
- Identificação de variantes de splicing e modificações pós-traducionais de proteínas;
- Identificação dos parceiros de interação em:
	- Interações proteína-proteína;
	- Interações DNA-proteína na regulação da transcrição: tanto a região do DNA quanto as proteínas que se ligam a ela;

- Integração das etapas regulatórias individuais em redes regulatórias complexas.

A aplicação sistemática de técnicas antigas e novas permitem **comparações controladas**, como:
- levantamento em larga escala de polimorfismos de nucleotídeo único SNPs em populações humanas;
- estudos filogenéticos, para entender a origem e as alterações de genes específicos ao longo da evolução;
- medições específicas de tecido, de doença e de idade envolvendo sequências, sinais epigenéticos e padrões de expressão.

## Networks
É crucial para a biologia saber como os sistemas vivos interagem.  Qualquer molécula pode ter vários parceiros com os quais interage de maneiras diferentes. O conjunto dessas interações entre moléculas formam redes. Existem redes de genes, proteínas e metabólitos. De fato, o mesmo conjunto de moléculas pode estar conectado por diferentes tipos de interações ou relacionamentos, formando assim redes distintas. 

| Network    | Element of Network | Connection Between Elements                                                                                                  |
| ---------- | ------------------ | ---------------------------------------------------------------------------------------------------------------------------- |
| Genomes    | Gene               | <span style="background:#affad1">Homology</span>, Linkage, <span style="background:#b1ffff">Shared expression pattern</span> |
| Protein    | Protein            | Homology, Regulatory relationship, Shared expression pattern, Physical complex formation                                     |
| Metabolite | Chemical compound  | Substrate and product of an enzymatic reaction, Similarity in structure, Similarity in reactivity                            |
Na células, operam dois tipos de redes de interação: uma rede física de complexos *proteína-proteína* e *proteína-ácido nucleico*, e uma **rede lógica** de cascatas de controle. <span style="background:#affad1">As redes físicas e lógicas funcionam em paralelo</span>. As interações podem ser físicas ou lógicas — muitas vezes, são ambas.

Um complexo macromolecular, como o *ribossomo*, é uma rede de **proteínas e RNAs** que interagem por meio de contatos físicos durante sua montagem. 

Já uma rede de regulação transcricional é uma rede de genes que exerce controle lógico sobre os padrões de expressão por meio de síntese de proteínas específicas que se ligam ao DNA.
Um **fator de transcrição** que atua ligando-se ao DNA pode nunca interagir fisicamente com as proteínas cuja expressão ele controla. 
As vias metabólicas apresentam uma dualidade semelhante: muitas, mas nem todas, são mediadas por interações físicas **proteína-proteínas** e reguladas por interações lógicas. 

Embora certos complexos possam participar tanto das redes físicas quanto das lógicas, as duas permanecem distintas em termos de sua organização e função biológica, sendo útil manter essa distinção em mente, especialmente quando elas se sobrepõem. 

## Observables and data archives
Bioinformática lida com **dados biológicos**, sua coleta, curadoria, distribuição e análise. A **unidade** de distribuição de uma coleção de determinado tipo de informação biológica é um **banco de dados (database)**.

Houve um grande crescimento e proliferação de bancos de dados, e, de forma talvez paradoxal, observa-se uma tendência à integração desses bancos em estruturas maiores e mais abrangentes, com o objetivo de combinar diferentes categorias de informação que antes eram domínio de projetos separados.

Esse movimento de integração está sendo impulsionado tanto por **forças acadêmicas** quanto por **forças políticas**. 
Um banco de dados inclui:
- 1. um arquivo de informações (archive)
- 2. uma organização lógica ou estrutura dessas informações, chamada de **esquema** (schema);
- 3. ferramentas de acesso a essas informações.

Os bancos de dados em biologia molecular contêm sequências de ácidos nucleicos e proteínas, estruturas e funções macromoleculares, padrões de expressão e redes de vias metabólicas e cascatas de controle. Eles incluem:
**Bancos de dados arquivísticos** de informação biológica, como:
- **Sequências de DNA e proteínas**, incluindo **anotações**;
- **Variações genéticas**, como **compilações de haplótipos** ou **mutações associadas a doenças;**

**Bancos de dados focados em organismos**, como **banco de dados genômicos**;
**Bancos de dados de padrões de expressão proteica**;
**Bancos de dados de vias metabólicas**;
**Bancos de dados de interações moleculares** e **redes regulatórias**;
**Bancos de dados derivados:** contêm informações **extraídas dos bancos arquivísticos**, ou **inferidas por análises** dos seus conteúdos. Por exemplo:
- **Motivos de sequência** (padrões característicos, assinaturas, de famílias de proteínas);
- **Classificações ou relações**, como **conexões** e **características compartilhadas** entre entradas dos arquivos.  

Exemplos incluem **bancos de dados de famílias de sequências proteicas**, ou **classificações hierárquicas de padrões de dobramento de proteínas**.

**Bases de dados bibliográficas**: a própria **literatura científica** é considerada um tipo de dado.

O PubMed é um banco de dados.

Pesquisadores realizam **mineração de dados (data mining)** no PubMed da mesma forma que fazem com qualquer outra banco de dados.
Existem também:
- **Bancos de dados de websites**
- **Bancos de dados de bancos de dados** contendo **informações biológicas**
- E **conexões** entre diferentes **bancos de dados**, que permitem a navegação cruzada e a integração da informação.

O arquivo de sequências de ácidos nucleicos é mantido por uma parceria tripla chamada **Colaboração Internacional de Banco de Dados de Sequência de Nucleotídeos**, que inclui o GenBank, com base no Centro Nacional de Informação em Biotecnologia dos EUA, em Bethesda, Maryland; o Arquivo Europeu de Nucleotídeos (ENA), no Instituto Europeu de Bioinformática (EBI), em Hinxton, Reino Unido; e o Centro de Biologia da Informação e Banco de Dados de DNA do Japão, no Instituto Nacional de Genética, em Mishima, Japão. Esses três centros trocam submissões diariamente para garantir uma cobertura comum. No entanto, o formato, a anotação e os links embutidos diferem entre as versões disponibilizadas por cada um dos bancos de dados. 

O arquivo de sequências de aminoácidos de proteínas, hoje obtidas quase exclusivamente por tradução de sequência gênicas, é mantido pelo Banco de Dados Unificado de Proteínas (UniProtKB), uma fusão dos bancos de dados SWISS-PROT, PIR (Protein Identification Resource) e TrEMBL (Translated EMBL).

Estão associados aos arquivos ferramentas para seleção e recuperação de sequências. O EBI possui diversos mecanismos de busca voltados para componentes distintos de seus bancos de dados. O Centro Nacional de Informação em Biotecnologia dos EUA oferece o ENTREZ. Ambos permitem buscas paralelas em múltiplos arquivos de dados.

Muitos projetos de sequenciamento genômico completo mantêm bancos de dados voltados para espécies específicas. Destacam-se o Ensembl (do Wellcome Trust Sanger Institute, em Hinxton, Reino Unido), os navegadores genômicos da Universidade da Califórnia em Santa Cruz para o genoma humano e outros, além do FlyBase.

Muitos bancos de dados derivados reúnem famílias de proteínas ou subunidades com base nas semelhanças entre suas sequências. Um banco de dados “guarda-chuva”, o InterPro, integra os conteúdos, características e anotações de vários bancos individuais de famílias de proteínas, domínios e locais funcionais, e contém links para outros bancos, incluindo a classificação funcional do Consórcio Gene Ontology. O InterPro pretende incorporar bancos de dados adicionais, incluindo bancos estruturais.

## A data without effective modes of access is merely a data graveyard
O acesso útil a dados exige um conjunto de ferramentas capazes de responder perguntas como:
- "O banco de dados contém a informação de que preciso?" *Exemplo: Posso recuperar a sequência de aminoácidos da desidrogenase alcoólica humana?*
- "Como posso reunir informações selecionadas do banco de dados de forma útil?" *Exemplo: Compilar uma lista de sequências de globinas, ou melhor ainda, uma tabela com essas sequências alinhadas.*
- "Onde posso encontrar uma informação específica?" *Exemplo: quais bancos de dados contêm a sequência de aminoácidos da tripsina do porco-espinho?*

Se eu souber exatamente o que estou procurando e puder especificar isso com clareza, o problema se torna relativamente simples.

Entretanto, os mecanismos que possibilitam um acesso eficaz aos dados são parte do projeto do banco de dados, e idealmente, devem ser invisíveis para o usuário. Hoje está claro que não se pode simplesmente *acoplar* um sistema de consultas a um arquivo desorganizado. Em vez disso, é essencial que a organização lógica do armazenamento da informação seja pensada com o acesso em mente, considerando os tipos de perguntas que os usuários farão. A estrutura do banco precisa se integrar perfeitamente ao software de recuperação da informação.

Na bioinformática, uma variedade de consultas a bancos de dados pode ser feita. Veja alguns exemplos típicos:
1. **Dada uma sequência ou fragmento de sequência, encontrar sequências semelhantes no banco de dados**. *Este é um problema central na bioinformática. Problemas de comparação de sequências (string-matching) são comuns também em outras áreas da ciência da computação, por exemplo, programas de edição de texto incluem funções de busca por palavras*.

2. **Dada uma estrutura proteica (ou fragmento), encontrar estruturas semelhantes no banco de dados.** *É a generalização do problema de comparação de sequências para o espaço tridimensional.*

3. **Dada a sequência de uma proteína cuja estrutura é desconhecida, encontrar estruturas no banco de dados que adotam conformações tridimensionais semelhantes.** *Pode parecer tentador, trapacear, procurando em banco de dados de sequência por proteínas com sequências semelhantes à da proteína-alvo. De fato, se duas proteínas têm sequências suficientemente parecidas, geralmente terão estruturas semelhantes. No entanto, o inverso não é verdadeiro: proteínas podem ter estruturas parecidas mesmo com sequências muito diferentes. Por isso, é desejável criar técnicas mais avançadas que identifiquem similaridades estruturais além da comparação direta de sequências.

4. **Dada uma estrutura proteica, encontrar no banco de dados as sequências que podem adotar estruturas semelhantes.** Novamente, pode-se tentar "trapacear", usando a estrutura para pesquisar diretamente em banco de dados estruturais. Mas isso tem sucesso limitado, porque existem muito mais sequências conhecidas do que estruturas tridimensionais resolvidas. Por isso, é desejável dispor de métodos capazes de prever a estrutura apenas com base na sequência. 

Os pontos 1 e 2 são problemas resolvidos; essas pesquisas são realizadas milhares de vezes por dia. Point 3 e 4 são campos ativos de pesquisa. 

## Information flow in bioinformatics
Os dados entram no universo da bioinformática quando um cientista deposita um resultado experimental em um repositório, ou quando um banco de dados registra um resultado publicado na literatura científica. O repositório (ou *archive*) então realiza a curadoria e anotação desses dados, criando uma entrada com conteúdo e formato apropriados. A curadoria inclui também verificações de qualidade. Após isso, a nova entrada é disponibilizada na versão pública do repositório.

A divisão do repositório em entradas é baseada na origem dos dados *provenance*; ou seja, cada entrada corresponde a um conjunto coerente de medições experimentais, frequentemente associado a um único artigo publicado. Em alguns casos, fragmentos de uma sequência completa são publicados em diferentes artigos. <span style="background:#affad1">Um banco de dados pode então reunir esses resultados</span> e formar uma entrada que represente a entidade biológica completa. Atualmente, muitos conjuntos de dados de sequências de nucleotídeos entram nos bancos de já como genomas anotados ou como fragmentos metagenômicos ainda não montados (*unassembled*).

Outros projetos de recuperação de informação, associados ou não a um repositório, podem integrar essas novas entradas em seus próprios sistemas. Esses projetos podem selecionar, reorganizar ou reestruturar os dados, e oferecer ferramentas inéditas de análise.

A reorganização dos dados pode envolver:
- Integração simples das novas entradas em mecanismos de busca gerais ou especializados.
- Extração de subconjuntos úteis dos dados.
	- Exemplos incluem:
	1. Identificação de genes em uma sequência contínua de DNA, como um genoma bacteriano ou um cromossomo eucariótico;
	2. extração de um conjunto não redundante de sequências de proteínas, com o objetivo de tornar as buscas mais rápidas e reduzir vieses estatísticos.

- **Derivação de novas informações a partir dos dados originais.** Um exemplo simples: quando um arquivo de DNA libera a informação de um gene codificador de proteína, isso gera automaticamente a inclusão da tradução da sequência em aminoácidos nos bancos de dados de proteínas. (Um aspecto mais complexo: sequências de DNA por si só não revelam variantes de splicing ou outras informações importante relacionadas à proteína).

- **Recombinação dos dados de diferentes formas.** Muitos projetos agrupam sequências ou estruturas de famílias de proteínas homólogas, ou proteínas que compartilham funções semelhantes. Exemplos: o banco de dados MEROPS (de proteases) e o Protein Kinase Resource. Alguns arquivos preferem manter entradas relacionadas separadas para preserver a clareza da origem dos dados. Outros bancos integram informações de um organismo específico ou de grupos relacionados, o FlyBase é um exemplo disso.

- **Reanotação dos dados, incluindo diferentes formas de interligação.** Essa integração pode ser horizontal ou vertical:
	- *Horizontal*: relaciona entradas do mesmo tipo, como genes homólogos em um genoma ou genes que participam da mesma via metabólica.
	- *Vertical*: relaciona um gene ou proteína a diversas informações adicionais, como os efeitos clínicos de suas mutações, por exemplo.

Essas estratégias ampliam significativamente a utilidade dos dados biológicos, permitindo buscas mais eficazes, análises mais ricas e novos caminhos para a descoberta científica.

Muitos sites atuam como **portais entre os arquivos biológicos e as ferramentas computacionais disponíveis para análise de dados.** A recuperação de informações permite a seleção e extração de dados que servirão como base para projetos de pesquisa. Vários recursos de bioinformática vão além da simples recuperação: também facilitam o processamento posterior ("dowstream") das entradas selecionadas.

Um exemplo típico seria recuperar as sequências de um **conjunto de genes homólogos** e, em seguida, alinhá-las. O objetivo é fornecer uma integração fluida de todas as etapas de processamento de dados exigidas em um projeto, conectando de forma eficiente as ferramentas de **armazenamento, recuperação e análise**.

O crescimento da importância do acesso simultâneo a múltiplos bancos de dados levou à pesquisa sobre interatividade entre bancos: como fazer com que bancos de dados *conversem entre si* sem sacrificar demais a liberdade de cada um estruturar seus dados da forma mais apropriada às características do conteúdo que armazena?

Por outro lado, há uma forte tendência à fusão e integração dos recursos de dados em bioinformática. Algumas razões para isso são políticas: o "alelo da construção de impérios" (*empire-building allele*) é relativamente comum na comunidade científica, e isso se soma ao argumento de que certos projetos são "grandes demais para falhar", justificando a manutenção ou ampliação de seus financiamentos.

Do ponto de vista científico, integrar bancos de dados oferece vantagens como:
- "Compra em um único lugar", com acesso fácil a diferentes categorias de informação;
- Facilidade na execução de consultas complexas que envolvam múltiplas áreas do conhecimento;
- Verificação cruzada de consistência entre categorias diferentes de dados durante a curadoria.

Além disso, grandes organizações responsáveis por bancos de dados costumam ter pessoal suficiente para oferecer tutoriais e guias de uso do site, auxiliando pesquisadores de diferentes níveis de experiência.

Além disso, grandes organizações que mantêm bancos de dados contam com equipes especializadas capazes de oferecer guias tutoriais, tanto sobre o uso do site quanto sobre o fundamento científico dos dados. Essas instituições também podem manter centrais de ajuda (help desks). É verdade que alguns usuários frustrados podem argumentar que a complexidade dos sites integrados exige esse tipo de orientação. No entanto, mesmo bancos de dados pequenos e especializados frequentemente geram confusão entre os usuários.

Na prática, apenas rivalidades nacionais ou comerciais impedem a fusão completa em um único banco de dados global. Dado o risco que uma unificação total se torne difícil de manejar, o acesso poderá ser personalizado conforme as necessidades de projetos específicos. Ou seja, a unificação dos arquivos será acompanhada por uma fragmentação nos caminhos de acesso.

Embora existam argumentos favoráveis a um controle único ou, no máximo, compartilhado sobre os arquivos primários, não há motivo para limitar as formas de acesso a eles, em outras palavras, a interface de uso *front-end* pode ser diversificada. Comunidades especializadas de usuários podem:
- extrair subconjuntos de dados;
- recombinar informações de diferentes fontes;
- e criar rotas personalizadas de acesso.

Esses chamados *bancos de dados boutique* dependem dos arquivos principais como fontes dos dados, mas redesenham sua estrutura e apresentação de acordo com propósitos específicos. Na verdade, diferentes bancos derivados podem organizar e interpretar as mesmas informações de maneiras distintas, o que explica a enorme proliferação de bancos de dados especializados registrada anualmente na coletânea da *NAR*.

Uma extrapolação razoável aponta para o surgimento de **“bancos de dados virtuais especializados”** — conceito proposto pela primeira vez há quase 50 anos. Esses bancos seriam **baseados nos arquivos principais**, mas **personalizados em escopo e funcionalidade**, adaptados às **necessidades de grupos de pesquisa específicos ou até de cientistas individuais**.

Apesar da unificação dos dados em arquivos centrais ser desejável e inevitável, a diversidade nas formas de acesso e uso é essencial, permitindo que cada comunidade científica adapte os dados às suas próprias necessidades.

## Curation, annotation, and quality control
As comunidades científica e médica dependem da qualidade dos bancos de dados. Indicadores de qualidade, mesmo que não permitam a correção de erros, podem nos ajudar a evitar conclusões equivocadas.

As entradas dos bancos de dados incluem resultados experimentais brutos e informações suplementares ou anotações. Cada um desses elementos possui suas próprias fontes de erro.

O principal fator determinante da qualidade dos próprios dados é o estado da arte das técnicas experimentais. Dados mais antigos eram limitados por técnicas mais antigas; por exemplo, sequências de aminoácidos de proteínas eram determinadas por sequenciamento de peptídeos, mas hoje são traduzidas a partir de sequências de DNA (exceto por sequenciamentos parciais por espectrometria de massas). Uma consequência da explosão de dados é que a maioria dos dados atualmente é nova, gerada por tecnologias modernas, que na maioria dos casos funcionam muito bem.

As anotações incluem informações sobre a origem dos dados e os métodos utilizados para obtê-los. Elas identificam os pesquisadores responsáveis e citam publicações relevantes. Também fornecem links para informações relacionadas em outros bancos de dados. Em alguns bancos de sequências, as anotações incluem tabelas de características *features tables*, que são listas de segmentos das sequências com significado biológico; por exemplo, regiões de uma sequência de DNA que codificam proteínas. Essa informações aparecem em formatos legíveis por computador, com conteúdo restrito a um vocabulário controlado. Vale destacar que uma declaração, por parte de cada banco de dados, sobre o vocabulário controlado e as definições que envolvem interações entre múltiplos bancos e consultas distribuídas. (Isso é como um *cartão de convenção*, em um torneio de bridge).

Antigamente, uma entrada típica de sequência de DNA era produzida por um único grupo de pesquisa, investigando um gene e seus produtos de maneira coerente. As anotações eram fundamentadas em dados experimentais e escritas por especialistas. Em contraste, projetos de sequenciamento genômico completo não oferecem confirmação experimental da expressão da maioria dos genes putativos, nem caracterização de seus produtos. Os curadores dos bancos de dados baseiam grande parte das anotações na análise computacional  das sequências.

O texto enfatiza que a anotação *annotation* é o elo mais frágil da bioinformática genômica, embora seja essencial para o aproveitamento corretos dos dados genéticos.

## The Worldwide web
Todos já utilizam a web. Atualmente, muitos cálculos em bioinformática são realizados por meio desses servidores web.

Quando os cálculos são longos, os resultados podem não ser retornados imediatamente na mesma sessão, em vez disso, são enviados por e-mail posteriormente.

---
**BOX 1.6 - Submetendo uma busca BLAST**
Uma busca BLAST é um exemplo comum e típico de uso de um servidor web na bioinformática. Ao acessar o servidor por meio de um navegador, o usuário pode colar uma sequência de interesse, escolher as opções desejadas e submeter o cálculo. O resultado aparecerá, posteriormente, na mesma janela do navegador.

O cálculo é realizado remotamente. Por exemplo, ao usar o servidor BLAST do EBI (European Bioinformatics Institute), no endereço, os processamentos são feitos em um centro de dados em Londres.

Atualmente, os usuários externos iniciam aproximadamente 3,7 milhões de buscas relacionadas à similaridade de sequências por mês (a maioria, mas não todas, são buscas BLAST). Para atender a essa demana, o EBI mantém um cluster com 216 nós dedicados exclusivamente a esse serviço. Foram realizados cerca de 660 milhões de jobs no ano de 2022. 

O principal passo para começar a usar a web de forma eficaz é **encontrar bons pontos de entrada**. Uma vez iniciada a sessão, os links nos levarão aos destino desejados.

## Electronic publication
Estamos vivendo uma era de transição para a publicação sem papel. Cada vez mais publicações estão sendo disponibilizadas diretamente na web. Um periódico científico pode publicar apenas seu índice, ou o índice acompanhado dos resumos dos artigos, ou ainda os artigos completos.

Diversas publicações institucionais, como boletins informativos e relatórios técnicos, também são publicadas online. Além disso, muitos jornais e revistas estão migrando para o formato digital. 

Hoje, muitas publicações impressas incluem **referências a links da web com materiais suplementares**, que **nunca aparecem na versão em papel**.

Entre as principais forças que impulsionam essa conversão do papel para bibliotecas eletrônicas estão:

- o surgimento de **revistas exclusivamente em formato eletrônico**;
    
- e o projeto do Google de **digitalizar o conteúdo de várias bibliotecas acadêmicas**.
    

Há também um movimento crescente em direção à **publicação em acesso aberto (open access)** — tema que será explorado com mais profundidade no **Capítulo 3**.

## Computadores e ciência da computação
A bioinformática não seria possível sem os avanços em hardware e software de computação. Mídias de armazenamento rápidas e com alta capacidade são essenciais até mesmo para manter os arquivos de dados. A recuperação e a análise das informações exigem programas, alguns relativamente simples, outros extremamente sofisticados. Já a distribuição dessas informações depende das redes de computadores e da web mundial. 

A ciência da computação é uma área relativamente jovem e em pleno crescimento, cujo objetivo é maximizar o uso eficiente das tecnologias de informação. Alguns ramos da computação impactam diretamente a bioinformática. Vamos considerar sua aplicação em um problema biológico específico: **recuperar de um banco de dados todas as sequências semelhantes à sequência humana do gene PAX-6**.

Uma boa solução para esse problema depende de conceitos da ciência da computação, como:

**Análise de algoritmos**
Um algoritmo é uma especificação completa e precisa de um método para resolver um problema.
Para recuperar sequências semelhantes, é necessário comparar a sequência-alvo com todas as sequências no banco de dados. 
Fazer isso de maneira ingênua, comparando posição por posição em todos os alinhamentos possíveis, seria extremamente ineficiente, mesmo sem considerar lacunas. Esse método teria um custo proporcional ao produto do número de caracteres da sequência de entrada pelo número de caracteres no banco de dados.

Felizmente, existe um ramo da computação chamado *stringologia*, especializado no desenvolvimento de métodos eficientes para resolver esse tipo de problema, além da análise do desempenho real desses métodos.

**Estruturas de dados e recuperação de informação**
Como podemos organizar os dados para que eles possam ser acessados de forma mais eficiente?
Por exemplo:
- É possível indexar ou pré-processar os dados para tornar as buscas por similaridade de sequência mais rápidas?
- Como podemos criar interfaces que ajudem o usuário a formular e executar suas consultas?

## Engenharia de software
Hoje em dia, raramente alguém escreve código diretamente na linguagem de máquina dos computadores. Em vez disso, programadores usam linguagens de alto nível, como C, C++, PERL, Python, Java ou até mesmo FORTRAN.

A escolha da linguagem depende:
- do tio de algoritmo;
- das estruturas de dados envolvidas;
- e do uso esperado do programa.

Naturalmente, os softwares mais complexos utilizados na bioinformática são desenvolvidos por especialistas, o que levanta uma questão importante:
*Quanta experiência em programação um bioinformata precisa ter?*
Esse é um tema central para a formação de profissionais da área.

## Programming
Programar está para a ciência da computação assim como assentar tijolos está para a arquitetura. Ambos são criativos; um é uma arte e o outro um ofício.
Muitos estudantes de bioinformática perguntam se é essencial aprender a escrever programas de computador complicados. Meu conselho (não consensual em toda a área) é: não, a menos que queiramos nos especializar nisso. Para trabalhar em bioinformática, precisaremos desenvolver experiência no uso de **ferramentas** disponíveis na web. Aprender a criar e manter um site é essencial. E, claro, precisaremos de facilidade no uso de sistema operacional do nosso computador, incluindo programas de aplicação de uso geral, como processadores de texto e ferramentas de apresentação. Alguma habilidade em escrever scripts simples em uma linguagem como PERL oferece uma extensão essencial às facilidades básicas do sistema operacional.
Por outro lado, o tamanho dos arquivos de dados e a crescente sofisticação das perguntas que desejamos abordar exigem respeito. A **programação** verdadeiramente criativa nesse campo é melhor deixada para especialistas, com treinamento avançado em ciência da computação. Nem mesmo o uso de programas, por meio de interfaces web altamente polidas (para não dizer chamativas), fornece qualquer indicação da natureza da atividade envolvida na escrita e depuração de programas. Bismarck disse uma vez: "Aqueles que ama salsichas ou a lei não deveriam assistir à sua feitura". Talvez os programas de computador devessem ser adicionados à sua lista.

Eu recomendo aprender algumas habilidades básicas com PERL, ou com uma das linguagens relacionadas PYTHON ou RUBY. A força do PERL no tratamento de strings de caracteres o torna adequado para tarefas de análise de sequência em biologia. Aqui está um programa PERL muito simples para traduzir uma sequência de nucleotídeos em uma sequência de aminoácidos de acordo com o código genético padrão. A primeira linha, `#!/usr/bin/perl`, é um sinal para o **sistema operacional UNIX** (ou **LINUX**) de que o que se segue é um **programa PERL** Dentro do programa, todo o texto que começa com um `#`, até o final da linha em que aparece, é apenas **comentário**. A linha `__END__` sinaliza que o programa terminou e o que se segue são os **dados de entrada**. (Todo o material que o leitor possa achar útil ter em formato legível por computador, incluindo todos os programas, aparece no centro de recursos online associado a este livro: [http://www.oxfordtextbooks.co.uk/orc/leskbioinf4e/](http://www.oxfordtextbooks.co.uk/orc/leskbioinf4e/).)

Até mesmo o programa simples no Estudo de Caso 1.1 exibe várias características da linguagem PERL. O arquivo contém dados de fundo (a tabela de tradução do código genético padrão), instruções que dizem ao computador o que fazer e os dados de entrada (aparecendo após a linha __END__). Comentários resume seções do programa e descrevem o efeito de cada *instrução*. 

O programa é estruturado em blocos delimitados por chaves, {...}, que são úteis para controlar o fluxo de execução. Dentro dos blocos, *instruções* individuais (cada uma terminando com um ponto e vírgula, ;) são executadas na ordem de sua aparição. No entanto, o bloco externo é um loop:
```PERL
while ($line = <DATA>) {
	
}
```

O código estabelece uma tabela de tradução do código genético padrão. Esta tabela é armazenada em um *hash* (um tipo de estrutura de dados em PERL que mapeia chaves para valores) chamada *%standardgeneticcode*. As chaves são os códons de nucleotídeos (sequências de três bases, como *ttt*, *tct*) e os valores são os aminoácidos correspondentes (como *Phe*, *Ser*, ou o termo de parada *TER*):
```perl
%standardgeneticcode = (
"ttt"=> "Phe", "tct"=> "Ser", "tat"=> "Tyr", "tgt"=> "Cys",
# ... (rest of the codons)
);
```

A parte central do programa é um loop *while* que processa os dados de entrada. A expressão *< DATA >* é um identificador de arquivo especial em PERL que se refere ao conteúdo que segue a linha END no próprio script. Isso significa que o programa lê os dados diretamente de si mesmo, após a marcação.

No programa que vimos, três tipos de estrutura de dados são utilizadas para gerenciar as informações:

1. **String de Caracteres Simples ($line)**
A linha de dados de entrada, referida como *$line*, é uma string de caracteres simples. Em termos mais comuns, é uma sequência de letras e números. Imagine uma única palavra ou frase: isso é uma string. No contexto do programa, $line contém a sequência de nucleotídeos que será traduzida.

2. **Array ou Vector de Tripletes (@triplets)**
A $line é então dividida em um **array** ou **vetor de tripletes**. Um array é como uma lista organizada de itens, onde cada item tem uma posição específica (um índice numérico, começando geralmente do zero). Pense numa lista de compras: <span style="background:#fdbfff">cada item está numa posição</span>, e podemos referir a ele pela sua ordem na lista ("o primeiro item", "o segundo item", etc.). No programa, *@triplets* armazena cada códon (grupo de três **nucleotídeos**) da sequência em sua ordem original, permitindo que o programa os processe um por um.


3. **Array Associativo (Hash Table) (%standardgeneticcode)**
Para facilitar a busca do **aminoácido** correspondente a cada triplete, o código genético é armazenado como um array associativo, também conhecido como tabela hash. Diferentemente de um array simples, onde os itens são acessados por número inteiros consecutivos, em um array associativo os elementos são indexados por strings de caracteres.

Neste caso, os **64 tripletes** possíveis (os **códons**) são as "chaves" (os "nomes" para acessar os dados), e os **aminoácidos** que eles codificam são os "valores" associados a essas chaves. Isso é extremamente útil porque o programa não precisa adivinhar a posição de um **códon** para encontrar seu **aminoácido**; ele simplesmente usa o **códon** como "nome" para obter diretamente o **aminoácido** correspondente. Isso permite acessar as informações do **código genético** em qualquer ordem que a sequência de entrada exigir.

Em resumo, o programa usa um array simples para manter a ordem dos tripletes de entrada e uma tabela hash para consultar rapidamente o aminoácido que cada triplete representa. Essa combinação de estruturas de dados é eficiente para processar e traduzir sequências biológicas.

## Biological classification and nomenclature
Voltando ao século XVIII, quando a vida acadêmica era mais simples, pelo menos em alguns aspectos. A nomenclatura biológica baseia-se na ideia de que os seres vivos são divididos em unidades chamadas **espécies**: grupos de organismos semelhantes com um **pool genético** comum. Lineu, um naturalista sueco, classificou os seres vivos de acordo com uma **hierarquia**: reino, filo, classe, ordem, família, gênero e espécie. Os taxonomistas modernos adicionaram níveis adicionais. Para identificação, geralmente basta especificar o **binômio gênero** e **espécie**; por exemplo, *Homo sapiens* para humanos ou *Drosophila melanogaster* para a **mosca-das-frutas**. Cada binômio específica unicamente uma espécie que também pode ser conhecida por um ou mais **nomes comuns**; por exemplo, Bos taurus = vaca. A maioria das espécies não possuem nomes comuns.

Originalmente, o **sistema lineano** era apenas uma **classificação baseada em semelhanças observadas.** Uma vez que a **evolução** foi compreendida, percebeu-se que o sistema reflete, em grande parte, a **ancestralidade biológica**.
Mas quais **semelhanças** realmente refletem uma **origem comum**?
Características derivadas de um ancestral comum são chamadas de **homólogas**; por exemplo, a **asa de uma águia** e o **braço de um humano**.

Outras características aparentemente semelhantes podem ter surgido **independentemente**, por meio de **evolução convergente**; por exemplo, a asa de uma água e a asa de uma abelha: o ancestral comum mais recente entre águias e abelhas **não possuía asas**.

Por outro lado, características **verdadeiramente homólogas** podem ter divergido ao ponto de se tornarem muito diferentes em estrutura e função.

Os ossos do nosso ouvido médio são homólogos aos ossos das mandíbulas de peixes primitivos; nossas trompas de Eustáquio são homólogas às fendas branquiais.

Na maioria dos casos, especialistas conseguem distinguir entre homologias verdadeiras e semelhanças resultantes de evolução convergente.

A análise de sequências fornece a evidência mais inequívoca para as relações entre espécies. O sistema funciona bem para organismos superiores, para os quais a análise de sequências e as ferramentas clássicas da anatomia comparada, paleontologia e embriologia geralmente fornecem um quadro consistente.

A classificação de microrganismos é mais difícil, em parte porque é menos óbvio como selecionar as características pelas quais classificá-los e, em parte, porque uma grande quantidade de **transferência lateral de genes** ameaça inverter completamente esse panorama. 

Os RNAs ribossômicos (rRNAs) revelaram ter a característica essencial de estarem presentes em todos os organismos, com o grau certo de divergência. (Divergência excessiva ou insuficiente torna as relações invisíveis, como é evidente ao se observar aos relações filogenéticas entre elefantes e mamutes; Ver estudo de Caso 1.5).

Com base nos rRNAs 15S, C. Woese dividiu os seres vivos, de forma mais fundamental, em três domínios (um nível acima de reino na hierarquia): **Bacteria**, **Archea** e **Eukarya**.

Bactérias e arqueas são procariontes; suas células não contém núcleos. Bactérias incluem os microrganismos típicos responsáveis por muitas doenças infecciosas e, é claro, a Escherichia coli, a base da biologia molecular.

As arqueas incluem, mas não se limitam a, termófilas extremas, halófilas, redutoras de sulfato e metanogênicas.

Nós mesmos somos *Eukarya*, organismos que contêm células com núcleos, assim como as leveduras e todos os demais organismos multicelulares.

Um censo das espécies com genomas sequenciados revela uma ênfase em **bactérias**, devido à sua importância clínica e à relativa facilidade de sequenciamento dos genomas de procariontes. No entanto, apesar das diferenças óbvias no modo de vida e da ausência de um núcleo, as arqueas estão, de certa forma, mais aproximadamente relacionadas em nível molecular aos eucariontes do que às bactérias.

Também é provável que as arqueas sejam os organismos vivos mais próximos da raiz da árvore da vida.

A Figura 1.2 mostra os níveis mais profundos da árvore. O ramo dos Eukarya inclui animais, plantas e fungos. Nas extremidades do ramo eucariótico estão os metazoários (Metazoa), ou seja, os organismos multicelulares. 

Nós e nossos parentes mais próximos somos **deuterostômios (Deuterostomia)**.

## Use of sequences to determine phylogenetic relationships

As seções anteriores apresentaram os bancos de dados de sequências e as relações biológicas. Os estudos de Caso 1,3, 1.4 e 1.5 são exemplos da aplicação da recuperação de sequências a partir desses bancos de dados e do uso de comparações de sequências para analisar relações biológicas. 

---
**Case Study 1.3 - Retrieve the amino acid sequence of horse pancreatic ribonuclease**
Use o servidor ExPASy do Instituto Suíço de Bioinformática. A URL é: http://www.expasy.org

Digite as palavras-chave:
**horse pancreatic ribonuclease**
E pressione a tecla ENTER.
Selecione RNP_HORSE e depois o formato FASTA. O código de identificação RNP_HORSE contém abreviações da molécula e da espécie. Isso produzirá a seguinte sequência (a primeira linha foi truncada, encurtada, ou seja, não está aparecendo por completo, apenas uma parte dela foi mostrada no exemplo.)
```fasta
>sp|P00674|RNAS1_HORSE Ribonuclease pancreatic OS=Equus caballus OX=9796 GN=RNASE1 PE=1 SV=1
KESPAMKFERQHMDSGSTSSSNPTYCNQMMKRRNMTQGWCKPVNTFVHEPLADVQAICLQ
KNITCKNGQSNCYQSSSSMHITDCRLTSGSKYPNCAYQTSQKERHIIVACEGNPYVPVHF
DASVEVST
```

Poderíamos recuperar várias sequências e alinhá-las. A análise dos **padrões de similaridade entre sequências** alinhadas é uma propriedade útil para avaliar o grau de proximidade entre relações biológicas.

---
**Box 1.7 FASTA format**
Um formato muito comum para dados de sequências é derivado das convenções do FASTA, um programa para alinhamento rápido desenvolvido por W.R. Pearson. Muitos programas utilizam o formato FASTA para **ler sequências** ou **relatar resultados**.
Uma sequência no formato FASTA:
- Começa com uma linha única de descrição. O símbolo > deve aparecer na primeira coluna. O restante da linha de título é arbitrário, mas deve ser informativo. 
- As linhas seguintes contêm a **sequência**, com um **caractere por resíduo**;
- Utilizam-se códigos de uma letra para nucleotídeos ou aminoácidos, conforme especificado pela União Internacional de Bioquímica e pela União Internacional de Química Pura e Aplicada (IUB/IUPAC)
- Para a #selenocisteína, usa-se Sec como código de três letras e U como código de uma letra. Selenocisteína contém selênio no lugar do átomo de enxofre, semelhante a #cisteína.
- As linhas podem ter **comprimentos diferentes**, ou seja, **margens irregulares à direita.**
- A maioria dos programas aceitam letras minúsculas como códigos de aminoácidos.

Exemplo do formato FASTA para a glutationa peroxidase bovina:
```FASTA
>gi|121664|sp|P00435|GSHC_BOVIN GLUTATHIONE PEROXIDASE  
MCAAQRSAAALAAAAPRTVYAFSARPLAGGEPFNLSSLRGKVLLIENVASLUGTTVRDYTQMNDLQRRLG  
PRGLVVLGFPCNQFGHQENAKNEEILNCLKYVRPGGGFEPNFMLFEKCEVNGEKAHPLFAFLREVLPTPS  
DDATALMTDPKFITWSPVCRNDVSWNFEKFLVGPDGVPVRRYSRRFLTIDIEPDIETLLSQGASA  
```
A linha do título contém os seguintes campos:
- O símbolo > é obrigatório na primeira coluna;
- `gi|121664` é o número gi (geninfo), um identificador atribuído pelo NCBI (Centro Nacional de Informação em Biotecnologia dos EUA) a cada sequência em seu banco de dados ENTREZ. O NCBI coleta sequências de várias fontes, incluindo bancos de dados primários e pedidos de patentes. Seus números gi fornecem um identificador comum e consistente, que unifica diferentes convenções de bancos de dados de origem.
	- Quando um banco de dados atualiza uma entrada e a sequência em si é modificada, o NCBI gera um novo número gi.
	- Se a atualização for apenas em informações não relacionadas à sequência (como uma citação bibliográfica), o NCBI mantém o mesmo número gi.
- `sp|P00435` indica que o banco de dados de origem é o SWISS-PROT, e que o número de acesso da entrada é *P00435*.
- `GSHC_BOVIN GLUTATHIONE PEROXIDADE` é o identificador no SWISS-RPT, indicando a sequência e a espécie (GSHC_BOVIN), seguido pelo nome da molécula.

---
**Box 1.8 - Alignment**
Alinhamento de sequências é o processo de atribuição de correspondência entre resíduos (resíduo-resíduo). Podemos querer encontrar:
- A Global match: allign all of one sequences with all of the other - alinhar toda uma sequência com toda a outra.
```json
And--so,.from.hour.to.hour,.we.ripen.and.ripen
||| |||||||||||||||||| |||||||| ||||||
And.then,.from.hour.to.hour,.we.rot.-.and.rot
```
Isso ilustra incompatibilidades ( #mismatches), inserções e deleções.
Este método é mais adequado quando se compara sequências que são presumivelmente homólogas e de tamanho semelhante, como genes #ortólogos em espécies próximas. O objetivo é obter a melhor pontuação de alinhamento possível em toda a extensão das sequências, penalizando aberturas (gaps) e mismatches (incompatibilidades) ao longo de todo o comprimento. O algoritmo clássico para realizar o alinhamento global é o de #Needleman-Wunsch

O alinhamento tenta encontrar a melhor correspondência para toda a frase, introduzindo gaps ("-") e reconhecendo mismatches para maximizar a similaridade geral.

- Alinhamento local ( #local_match): find a region in one sequence that matches a region of the other, portanto, encontra uma região em uma sequência que corresponda a uma região da outra.
![[Chapter 1 - Introduction.png]]
	Para alinhamento loca, partes excedentes nas extremidades não são tratadas como lacunas.
	Além das incompatibilidades, como visto nesse exemplo, inserções e deleções dentro da região alinhada também são possíveis.

Por outro lado, o **alinhamento local** é projetado para encontrar sub-regiões de maior similaridade entre duas sequências. Esta abordagem é particularmente útil quando se compara sequências que podem ser distantemente relacionadas, ter tamanhos diferentes ou compartilhar apenas domínios ou motivos conservados. O alinhamento local não penaliza os "excessos" nas extremidades das sequências que não se alinham. O algoritmo padrão para o alinhamento local é o de #Smith-Waterman.
Isso é ideal para, por exemplo, identificar um domínio funcional específico dentro de duas proteínas diferentes. 

Em resumo, a decisão de usar o alinhamento global ou local é estratégica. **Se o interesse é avaliar a relação evolutiva global** entre duas sequências muito parecidas, o alinhamento global é a escolha certa. Contudo, **se a meta é pescar pequenas ilhas de conservação funcional ou estrutural em um mar de divergência**, o alinhamento local é a ferramenta mais poderosa e apropriada. 

- Alinhamento por motivo (motif match):
Encontrar correspondências de uma curta sequência em uma ou mais regiões interna de uma sequência longa.
Encontrar correspondência de uma curta sequência em uma ou mais regiões internas de uma sequência longa.
Portanto, é uma abordagem mais específica que o alinhamento local e representa uma ferramenta crucial na biologia molecular e na bioinformática.

Enquanto o alinhamento global compara sequências inteiras e o local busca a melhor região de similaridade entre duas sequências, o alinhamento por motivo tem um objetivo diferente: **identificar a presença de um padrão curta e conservado (o motivo) dentro de uma ou várias sequências.**

**O que é um Motivo (Motif)?**
Um motivo (ou motif) é um padrão de sequência de nucleotídeos ou aminoácidos que se acredita ter uma importância biológica. Geralmente, esses padrões são curtos e estão associados a funções específicas, como:
- **Sítios de ligação de fatores de transcrição**: são regiões específicas no DNA onde proteínas reguladoras se ligam para ativar ou desativar genes.
- **Sítios de clivagem de enzimas de restrição:** sequências que são reconhecidas e cortadas por enzimas específicas.
- **Domínios funcionais em proteínas:** padrões de aminoácidos que formam uma unidade funcional ou estrutural, como um sítio de uma enzima ou uma região de ligação a outra molécula.
- **Padrões de modificação pós-traducional**: sequências que sinalizam onde uma proteína deve ser modificada (ex: fosforilação, glicosilação).

A principal característica de um motivo é que ele pode apresentar alguma variabilidade. Por exemplo, um sítio de ligação pode não ser uma sequência idêntica em todos os lugares onde aparece, mas sim um "consenso" ou um padrão probabilístico.

O alinhamento por motivo não busca o melhor alinhamento entre duas sequências longas. Em vez disso, ele funciona de duas maneiras principais:
1. **Busca de Motivo Conhecido (Motif Matching):** já temos um motivo definido (por exemplo, a partir de bancos de dados como PROSITE e JASPAR) e queremos verificar se ele está presente em uma nova sequência. A busca é feita para encontrar todas as ocorrências que correspondem a esse padrão pré-definido.
2. **Descoberta de Novos Motivos (Motif Finding)**:  neste caso, temos um conjunto de sequências que acreditamos compartilhar uma função comum (ex: genes regulados pelo mesmo fator de transcrição) e queremos descobrir qual padrão (motivo) elas compartilham. Ferramentas como #MEME ou #Gibbs Sampler são usadas para identificar esses novos motivos a partir de dados. 
Em resumo, o alinhamento por motivo é uma forma especializada de busca de padrões que se sobrepõe conceitualmente ao alinhamento local, mas é mais focado em identificar *assinaturas* biológicas curtas e funcionalmente importantes, em vez de simplesmente encontrar a região mais longa de alta similaridade.

- **Alinhamento múltiplo**
Alinhamento mútuo de várias sequências:
```json
no.sooner.---met.-----------but.they.look’d
no.sooner.look’d.-----------but.they.-lo’v’d
no.sooner.lo’v’d.-----------but.they.sigh’d
no.sooner.sigh’d.-----------but.they.--asked.one.another.the.reason
no.sooner.knew.the.reason.but.they.----------


```
![[Chapter 1 - Introduction-1.png]]
A última linha mostra os caracteres conservados em todas as sequências no alinhamento.

**Exemplo Prático**
Imagine que estamos estudando uma proteína e queremos saber se ela possui um "dedo de zinco" (*zinc finger*), um domínio conhecido por se ligar ao DNA.

- Não usaríamos o **alinhamento global**, a menos que estivéssemos comparando a nossa proteína com outra proteína de dedo de zinco muito similar em sua totalidade. 

- Poderíamos usar o **alinhamento local** para comparar  a nossa proteína com uma proteína dedo de zinco conhecida. Se houvesse uma alta pontuação em uma região, isso sugeriria a presença do domínio.
- Com o **alinhamento por motivo**, pegaríamos o padrão consenso da proteína *zinc finger*, e usaria uma ferramenta para buscar diretamente por esse padrão em sua sequência. Seria uma busca mais rápida e direcionada.

---
**Case Study 1.4 - Determine, a partir das sequências da ribonuclease pancreática do cavalo (*Equus caballus),*** da baleia minke (*Balaenoptera acutorostrata*) e do canguru-vermelho (*Macropus rufus*), quais dessas duas espécies estão mais próximas relacionadas.

Sabendo que o cavalo e a baleia são mamíferos placentários e que o canguru é um marsupial, espera-se que cavalo e baleia formem o par mais próximo.

>RNP_HORSE
>KESPAMKFERQHMDSGSTSSSNPTYCNQMMKRRNMTQGWCKPVNTFVHEP
LADVQAICLQKNITCKNGQSNCYQSSSSMHITDCRLTSGSKYPNCAYQTS
QKERHIIVACEGNPYVPVHFDASVEVST

>RNP_BALAC
RESPAMKFQRQHMDSGNSPGNNPNYCNQMMMRRKMTQGRCKPVNTFVHES
LEDVKAVCSQKNVLCKNGRTNCYESNSTMHITDCRQTGSSKYPNCAYKTS
QKEKHIIVACEGNPYVPVHFDNSV

>RNP_MACRU
ETPAEKFQRQHMDTEHSTASSSNYCNLMMKARDMTSGRCKPLNTFIHEPK
SVVDAVCHQENVTCKNGRTNCYKSNSRLSITNCRQTGASKYPNCQYETSN
LNKQIIVACEGQYVPVHFDAYV

Insira as sequências no programa de alinhamento múltiplo CLUSTAL-W ou alternativamente, no T-Coffe

Neta tabela, um **asterisco ( * )** sob as sequências indica uma **posição conservada** (ou seja, o mesmo resíduo em todas as sequências). Os símbolos **dois-pontos** (:) e **ponto** indicam posições onde todos os resíduos têm características físico-químicas muito semelhantes (:) ou moderadamente semelhantes (.) .

Grandes trechos das sequências são idênticos.
Houve diversas substituições, mas apenas uma deleção interna.
Ao comparar as sequências em pares, o número de resíduos idênticos compartilhados entre os pares (note que isso não é o mesmo que contar os asteristcos) é:

| <center>Par de espécies</center>    | <center>Nº de resíduos idênticos (de 122 a 128 totais)</center> |
| ----------------------------------- | --------------------------------------------------------------- |
| **Cavalo e baleia minke**           | <center>95</center>                                             |
| **Baleia minke e canguru-vermelho** | <center>82</center>                                             |
| **Cavalo e canguru-vermelho**       | <center>75</center>                                             |

Cavalos e baleia compartilham o maior número de resíduos idênticos. Esse resultado parece significativo e, portanto, confirma nossas expectativas: cavalo e baleia são os mais próximos entre os três, do ponto de vista evolutivo.
Ou será que a lógica é o oposto?
Essa última frase é uma provocação didática: ela convida o leitor a refletir criticamente sobre a inferência versus confirmação de hipótese.
Será que observar um maior número de resíduos idênticos _prova_ proximidade evolutiva, ou apenas está de acordo com uma suposição anterior.
Ou ainda — seria possível que essa semelhança tivesse surgido por convergência evolutiva (menos provável neste caso, mas importante como exercício de pensamento científico)?
Os dados sustem a hipótese evolutiva preexistente. Mas não *provam* proximidade por si só, pois:
Apesas dos dados susteram a hipótese evolutiva preexistente, ele não prova a proximidade por si só, pois:
E se a gente tivesse feito o caminho inverso?
	`Observei que cavalo e valeia têm 95 resíduos idênticos; portanto, devem ser evolutivamente mais próximos.`

Esse raciocínio é perigoso se isolado, pois:
- A semelhança de sequência não implica automaticamente ancestralidade comum recente;
- Podem ocorrer **convergências evolutivas** ou **conservação funcional** (por pressão seletiva), que mascaram distâncias reais;
- A quantidade de resíduos idênticos pode variar por acaso ou por artefatos técnicos.

Grupo externo (*outgroup*)
**PROCURAR NO LIVRO DE FUNDAMENTOS DE SISTEMÁTICA FILOGENÉTICA, DO DALTON DE SOUZA AMORIM, A RESPOSTA PARA A RESOLUÇÃO DESTE PROBLEMA, A PALAVRA ME FUGIU DA CABEÇA, MAS SERIA ALGO COMO ESPÉCIE EXTRA, ESPÉCIE AMOSTRAL OU FORA**.

O Canguru é o nosso <span style="background:#d3f8b6">grupo externo</span> da relação, permitindo concluir que, cavalo e baleia compartilham uma ancestralidade mais recente entre si do que com o canguru.
![[input.fa.final_tree.nw.png]]
Resultado gerado:
1. Cavalo (RNP_HORSE) e Baleia (RNP_BALAC) formam um clado com bootstrap 92.8%, indicando alta confiança estatística na relação próxima entre eles.
2. Esse clado dos placentários (horse + whale) é irmão do gambá (RNP_GAMB), o que é esperado: 
	- Ambos são mamíferos, mas o gambá é um **marsupial**, um grupo divergente mais antigo.

3. O canguru (RNP_MACRU) está ainda mais distante, separando-se mais cedo na árvore, o que reforça seu papel como grupo externo adicional e mais divergente.
4. As distâncias evolutivas (valores numéricos nos ramos) também refletem isso:
	- Distância entre cavalo e baleia: pequena (~0.08)
	- Distância entre canguru e qualquer outro: maior (~0.26)

---
Vamos tentar uma ideia mais difícil, os mamutes são mais próximos dos elefantes indianos ou dos africanos?
Nós "sabemos" que elefantes africanos, indianos e mamutes devem ser parentes próximos: basta olhar para eles.
Mas será que conseguiremos dizer, **apenas a partir dessas sequências**, que pertencem a espécies tão relacionadas?
- Dado que as diferenças são tão pequenas, elas representam uma verdadeira **divergência evolutiva** ou são apenas ruído aleatório ou deriva genética?
Como pano de fundo para essas questões, vamos reafirmar a distinção entre similaridade e homologia.

A distinção entre esses dois conceitos é o que permitiu a #Willi-Hennig revolucionar a Biologia Comparada. 

A principal diferença, pode ser resumida da seguinte forma:
- #Similaridade é uma observação geral de que duas estruturas se parecem. É um conceito amplo e descritivo, mas que não explica a causa dessa parecença.
- #Homologia é uma hipótese que explica a causa da similaridade. Ela afirma que a semelhança existe porque ambas as estruturas **derivam de uma mesma estrutura presente em um ancestral comum**. 

#Similaridade é a observação ou medição de semelhanças e diferenças, independente da origem dessa semelhança.

#Homologia significa, especificamente, que as sequências - e os organismos onde elas ocorrem, **descendem de um ancestral comum**, com a implicação de que as **semelhanças são características herdadas de um ancestral compartilhado**. 

A similaridade entre sequências (ou entre características biológicas macroscópicas) é algo observável nos dados coletados atualmente, e não requer hipóteses históricas.

Por outro lado, afirmar homologia **é fazer uma declaração sobre eventos históricos**, que são, na maioria das vezes, inobserváveis diretamente. 

A homologia precisa ser inferida a partir da observação da similaridade. Somente em alguns poucos casos a homologia pode ser demonstrada de forma diretamente observável por exemplo, em árvore genealógicas de famílias com fenótipos incomuns, como o lábio dos Habsburgo, ou em populações de laboratório, ou ainda em estudos clínicos que acompanham o curso de infecções virais no nível da sequência genética em pacientes individuais. 

O grande avanço da Sistemática Filogenética foi justamente entender que nem toda similaridade é igual. Existem diferentes tipos de semelhanças, e apenas um tipo serve para estabelecer relações de parentesco próximo.

- **Critérios para Inferir Homologia**: como não podemos ver o ancestral, o livro aponta que a homologia é inferida por critérios como:
	1. Semelhança notória de forma e partes componentes.
	2. Mesma posição relativa a outras estruturas do corpo (critério topológico)
	3. Origem a partir de células ou tecidos similares durante o desenvolvimento embrionário (critério ontogenético)

**Tipos de Homologia Úteis para a Filogenia**
O ponto crucial é que mesmo as estruturas homólogas podem ser de dois tipos em uma análise:
- #Sinapomorfia ( #apomorfia-compartilha): é uma característica derivada ( #apomórfica) e compartilhada por um grupo de táxons. É a verdadeira evidência de um parentesco exclusivo, pois indica que todos os que a possuem descendem do ancestral onde aquela novidade evolutiva surgiu. **Exemplo:** A presença de pelos é uma sinapomorfia que une os mamíferos.
- #Simplesiomorfia (Plesiomorfia Compartilhada): é uma característica ancestral (plesiomórfica) e compartilhada. Embora seja uma homologia, ela não serve para definir grupos monofiléticos mais restritos, pois foi herdade de um ancestral mais antigo, comum a outros grupos também. **Exemplo**: A ausência de asas em alguns insetos ("apterigotos") é uma simplesiomorfia em relação aos insetos alados, não indicando que todos os insetos sem asas formam um grupo monofilético exclusivo.

**Homoplasia**: A similaridade Sem Ancestralidade Comum Recente
A Homoplasia é a explicação de que as semelhanças que não são devidas a uma ancestralidade comum exclusiva, são características adquiridas de forma independente em duas ou mais linhagens. Elas são as *armadilhas* da sistemática, pois criam conflito nos dados e podem levar a agrupamentos incorretos. Portanto, não indica parentesco, é uma fonte de erro (ruído) que precisa ser identificada e minimizada pelo princípio da parcimônia.
Existem três tipos de homoplasia:
- **Paralelismo:** Ocorre quando uma mesma condição ancestral (plesiomórfica) se modifica de forma idêntica, mas independente, em duas linhagens. Exemplo: O surgimento de tufos de pelos brancos em diferentes grupos de primatas.
- **Convergência:** ocorre quando condições ancestrais diferentes se modificam e o resultado final é semelhante. Exemplo: as asas de morcegos e aves. O autor ressalta que a semelhança aqui é muito superficial, e um exame detalhado mostra que as estruturas são bem distintas.
- **Reversão:** é quando uma caraterística derivada (apomórfica) retorna a uma condição parecida com a ancestral (plesiomórfica). Exemplo do livro: a perda secundária das asas em pulgas. Elas se assemelham a insetos primitivamente sem asas, mas na verdade seus ancestrais possuíam asas.

Portanto, o trabalho do sistema filogeneticista, como descrito por Dalton de Souza Amroim, é analisar a similaridade, formular hipóteses de homologia (homologia primária) e, através da análise de todos os caracteres em conjunto (buscando congruência e parcimônia), separar as homologias que são sinapormórficas daquelas que são simplesiomórficas e, principalmente, identificar as similaridades que são, na verdade, homoplasias.



O novo campo da **metagenômica** fornecerá outros exemplos (veja o Capítulo 2 e *Introduction to Genomics*, Lesk 2011). 

A afirmação de que as cadeias α da hemoglobina dos elefantes africanos, elefantes indianos e mamutes são homólogas significa que houve um ancestral comum, presumivelmente contendo uma cadeia α de hemoglobina única, que por mutações distintas deu origem às proteínas dos mamute e dos elefantes modernos.

Mas será que o altíssimo grau de similaridade entre essas sequências é uma prova de homologia, ou existem outras explicações possíveis?

---
**RESPOSTA COM BASE NO DALTON**
Segundo o Dalton, um **altíssimo grau de similaridade** é uma **fortíssima evidência** para se propor homologia, mas não é uma prova definitiva. A obra apresenta uma explicação alternativa para a semelhança: a **homoplasia**. Isso significa que uma característica muito similar pode ter surgido mais de uma vez na evolução, de forma independente, o que criaria uma falsa semelhança do ponto de vista da ancestralidade comum exclusiva. O altíssimo grau de similaridade é o que permite ao pesquisador fazer uma **hipótese inicial de homologia** (chamada de *homologia primária*). No entanto, essa hipótese só é testada e corroborada quando analisada em conjunto com muitos outros caracteres. 

Portanto, de acordo com Dalton, a similaridade, por maior que seja, <span style="background:#affad1">não é uma prova irrefutável de homologia. Ela é o ponto de partida para se formular a hipótese de homologia, que será testada contra a evidência de outros caracteres em uma análise filogenética completa. </span>

---

1. **Pode ser que uma cadeia α de hemoglobina funcional** <span style="background:#fff88f">exija tantos resíduos conservados</span> que todas as hemoglobinas de todos os animais devam ser tão semelhantes entre si quanto as de elefantes e mamutes são entre si, independentemente de serem homólogas ou não.  Podemos testar essa hipótese observando as sequências da cadeia α de hemoglobina de outras espécies. (<span style="background:#ff4d4f">GRUPO EXTERNO</span>). <span style="background:#affad1">O resultado mostra que essas sequências em outros animais diferem substancialmente das dos elefantes e mamutes</span>. 
2. Uma segunda possibilidade é que exijam-se requisitos fisiológicos especiais para que uma cadeia α de hemoglobina funcione bem em um animal do tamanho e forma de um elefante, de forma que as três sequências tenham partido de ancestrais independentes, e pressões seletivas semelhantes tenham forçado sua **convergência evolutiva**. (*Lembre-se de que a pergunta aqui é o que pode ser deduzido apenas a partir dessas sequências*).
3. O mamute pode ser mais próximo do elefante africano, mas, desde o tempo do ancestral comum, a sequência da cadeia α da hemoglobina do elefante africano pode ter evoluído mais rapidamente do que a do elefante indiano ou do mamute, acumulando mais mutações.
4. Uma quarta hipótese é que todos os ancestrais comuns de elefantes e mamutes tinham sequências muito diferentes, mas que os elefantes vivos e os mamutes ganharam um gene comum por transferência horizontal, via um vírus proveniente de alguma outra família de espécies. (Ideias extraordinárias exigem evidências extraordinária).

Suponha, no entanto, que estejamos satisfeitos que a similaridade das sequências do elefante e do mamute seja alta o suficiente para implicar homologia: o que dizer então sobre as sequências de ribonuclease no Estudo de Caso 1.4? As diferenças maiores entre as ribonucleases pancreáticas de cavalo, baleia e canguru são evidências de que não são homólogas? *A homologia é uma hipótese sobre ancestralidade comum, não apenas uma medida de semelhança.*

Como podemos responder a essas perguntas? Especialistas realizaram calibrações cuidadosas das similaridades e divergências de sequências, entre muitas proteínas de muitas espécies para as quais as relações taxonômicas foram estabelecidas por métodos clássicos. No exemplo das ribonuclease pancreáticas, o raciocínio da similaridade para a homologia é justificado. Na segunda edição deste livro, eu escrevi: ‘A questão de se os mamutes são mais próximos dos elefantes africanos ou indianos foi decidida apenas recentemente, em favor dos elefantes africanos.’ Desde então, a opinião de especialistas — incluindo a de alguns dos mesmos especialistas — mudou para a conclusão de que os elefantes indianos são os parentes existentes mais próximos dos mamutes. Por que essa questão se provou tão difícil? Ela reflete o poder limitado de nossas ferramentas, aplicadas aos dados disponíveis, para resolver eventos que aconteceram muito próximos um do outro, há muito tempo. 

Os três principais grupos de elefantes são: elefantes africanos, elefantes asiáticos e mamutes. Esses táxons compõem uma família, a Elephantidade, contendo três gêneros principais _Loxodonta_, incluindo a espécie africana _L. africana_; _Elephas_, incluindo a espécie asiática _E. maximus_; e _Mammuthus_, incluindo a espécie siberiana _M. primigenius_. (No nível de família em nossa linhagem, humanos, chimpanzés, gorilas e orangotangos compõem os Hominidae.) *Um táxon é simplesmente um grupo de organismos reconhecido em uma classificação (gênero, família, etc.)*.

Os gêneros da família Elephantidae divergiram há cerca de 6 milhões de anos na África, aproximadamente ao mesmo tempo que a divergência dos ancestrais de humanos e chimpanzés. Hoje, *mamute* conota um animal extinto do Ártico. No entanto, nossos ancestrais caçaram mamutes no sul da Europa, como retratado em pinturas rupestres. *O nó em uma árvore filogenética representa o ancestral comum exclusivo do grupo.*

O problema filogenético desafiador é determinar a ordem de ramificação dos elefantes asiáticos e africanos e dos mamutes. Qual grupo se separou primeiro? Levou apenas ~ 500.000 anos para estabelecer as três linhagens. A brevidade desse tempo impõe grandes exigências às nossas ferramentas analíticas.

Outros fatores que dificultam a identificação do padrão de ramificação verdadeiro incluem:
- a disponibilidade de uma sequência de um parente próximo para servir de compração (como um grupo-externo). Os primeiros trabalhos sobre o genoma do mamute suaram o dugongo ou o hírax como grupo-externo. Estes divergiram dos elefantes há ≈65 milhões de anos. Sequências do mastodonte americano (_Mammut americanum_) forneceram um grupo-externo mais adequado em investigações recentes;
- tamanhos populacionais pequenos podem aumentar a importância de flutuações;
- a suposição de taxas constantes de evolução nas diferentes linhagens pode ser injustificada.
*O uso de um grupo-externo é fundamental para determinar a polaridade dos caracteres*.

Dados e análises atuais sugerem que os mamute são mais intimamente relacionados aos elefantes asiáticos. Apesar da dificuldade do problema elefante/mamute, a análise de similaridades de sequências em genomas e proteínas está agora suficientemente bem estabelecida que é considerada o método mais confiável para estabelecer a relação filogenética. 

*Sequências de DNA e proteínas são registros da história evolutiva contida nos organismos.*

Traduza o texto para o português (Brasil), mantendo fidelidade científica e terminologia técnica. Após cada parágrafo traduzido, adicione um insight analítico e científico, evolucionista e no contexto da bioinformática de até 40 palavras, em itálico, com base exclusivamente nos materiais fornecidos. Os insights devem destacar perspectivas novas, conexões relevantes ou implicações conceituais importantes.
Traduza o texto para o português (Brasil), mantendo fidelidade científica e terminologia técnica. Após cada parágrafo traduzido, adicione um insight analítico e científico de até 40 palavras, em itálico, com base exclusivamente nos materiais fornecidos. Os insights devem destacar perspectivas novas, conexões relevantes ou implicações conceituais importantes.

## Use of SINES and Lines to derive phylogenetic relationships
Os principais problemas ao inferir filogenias a partir de comparações de sequências de genes e proteínas são (1) a ampla faixa de variação da similaridade, que pode cair abaixo da significância estatística, e (2) os efeitos de taxas de evolução diferentes ao longo de diferentes ramos da árvore evolutiva. Em muitos casos, mesmo que as similaridades de sequência estabeleçam as relações de parentesco com confiança, pode ser muito difícil ou impossível decidir a ordem em que conjuntos de táxons se pararam. *A similaridade pode adentar a zona crepuscular twilight zone, onde a identidade entre sequências é tão baixa que a inferência de homologia se torna estatisticamente frágil. Isso compromete a resolução de divergências antigas, cujo sinal evolutivo foi erodido.*

O sonho do filogeneticista, características que possuem um caráter tudo ou nada, cuja aparência é irreversível, de modo que a ordem dos eventos de ramificação possa ser decidida, é, em alguns casos, proporcionado por certas sequências não codificantes nos genomas. *Este sonho descreve um caráter ideal, livre de homoplasia. A irreversebilidade evita reversões ao estado plesiomórfico, garantindo que a apomorfia compartilhada seja uma evidência robusta para um clado, solidificando a hipótese de monofiletismo daquele grupo.*

Elementos nucleares interespersos <span style="background:#ff4d4f">curtos</span> e <span style="background:#ff4d4f">longos</span>, ou SINEs e LINEs, são sequências repetitivas não codificantes que formam frações dos genomas eucarióticos; isto é, pelo menos 30% do DNA cromossômico humano e mais de 50% dos genomas de algumas plantas superiores. Tipicamente, os SINEs têm de aproximadamente 70 a 500 pares de bases de comprimento, e até 10^6 cópias podem aparecer. Os SINEs entram no genoma por <span style="background:#ff4d4f">transcrição reversa de RNA</span>. A maioria dos SINEs contém uma região 5' homóloga ao tRNA, uma região central não relacionada ao tRNA e uma região 3' rica em AT. *A massiva presença de SINEs e LINEs representa um desafio algorítmico significativo para a montagem de genomas (whole-genome shotgun), pois suas sequências repetitivas podem colapsar contings, exigindo abordagens computacionais específicas para a correta reconstrução genômica.*

As características dos SINEs que os tornam úteis para <span style="background:#b1ffff">estudos filogenéticos incluem</span> o seguinte. *A utilização de SINEs em filogenia exemplifica a transição da sistemática para o uso de caracteres moleculares, onde a natureza discreta e a clareza do evento evolutivo (inserção) fornecem dados robustos para a inferência de relações de parentesco.*

- Um SINE está presente ou ausente. A presença de um SINE em qualquer posição particular é uma propriedade que não acarreta nenhuma medida complicada e variável de similaridade.  *A natureza de presença ou ausência, transforma a inserção de um SINE em um caráter discreto (0 ou 1), ideal para a construção de matrizes de dados em análises filogenéticas, eliminando a ambiguidade de caracteres quantitativos contínuos.*
- Os SINEs são inseridos aleatoriamente na porção não codificante de um genoma. Portanto, o aparecimento de SINEs similares no mesmo loco em duas espécies implica que as espécies compartilham um ancestral comum no qual o evento de inserção ocorreu. <span style="background:#d3f8b6">Nenhum análogo da evolução convergente turva este cenário, porque não há seleção para o sítio de inserção.</span> *A inserção aleatória e a ausência de pressão seletiva sobre o local de inserção tornam a homoplasia (uma inserção independente no mesmo sítio) extremamente improvável. Assim, um SINE compartilhado é uma forte evidência de sinapomorfia.*
- A inserção de SINE parece ser irreversível: nenhum mecanismo para a perda de SINEs é conhecido, além de raras deleções ou translocações em grande escala que incluem o sítio do SINE. Portanto, se duas espécies compartilham um SINE em um *loco comun*, a ausência deste SINE em uma terceira espécie implica que as duas primeiras espécies devem ser mais proximamente relacionadas entre si do que qualquer uma delas é da terceira. *A aparente irreversibilidade da inserção estabelece uma polaridade clara para a transformação do caráter (ausência -> presença). Isso confere ao SINE o status de um marcador evolutivo quase perfeito, seguido o princípio da* #Lei-de-Dollo, *minimizando o ruído de reversões*. (*A Lei de Dollo, também conhecida como Lei da Irreversibilidade da Evolução, afirma que uma característica complexa perdida na evolução não pode ser recuperada, segundo o princípio estabelecido pelo paleontólogo belga. Em outras palavras, uma vez que uma característica complexa é perdida ao longo da evolução, a trajetória evolutiva não retornará exatamente àquela forma original, mesmo que as condições ambientais voltem a ser as mesmas.*)

- Os SINEs não apenas mostram relações, mas também implicam qual espécie se ramificou primeiro. O último ancestral comum de espécies que contêm um SINE comum deve ter surgido após o último ancestral comum que liga essas espécies a outra que não possui esse SINE. *Esse princípio permite o enraizamento relativo de clados. A presença de um SINE define um grupo monofilético derivado, enquanto a sua ausência em um grupo externo ajuda a determinar a sequência de eventos de ramificação na árvore filogenética.*

N. Okada e seus colaboradores aplicaram sequências de SINEs a questões de filogenia. Baleias, assim como os australianos, são mamíferos que adotaram um estilo de vida aquático. Mas quais — no caso das baleias — são seus parentes terrestres mais próximos? A paleontologia clássica ligava a ordem Cetacea — compreendendo baleias, golfinhos e botos — com a ordem Artiodactyla, os ungulados de dedos pares (incluindo vacas e ovelhas, por exemplo). Acreditava-se que os cetáceos haviam divergido antes do ancestral comum das três subordens de artiodáctilos existentes: Suiformes (porcos), Tylopoda (incluindo camelos e lhamas) e Ruminantia (incluindo veados, vacas, cabras, ovelhas, antílopes, girafas, etc.). Para posicionar os cetáceos adequadamente entre esses grupos, vários estudos foram realizados com sequências de DNA. Comparações de DNA mitocondrial e genes para a ribonuclease pancreática, fibrinogênio-γ e outras proteínas sugeriram que os parentes mais próximos das baleias são os hipopótamos, e que cetáceos e hipopótamos formam um grupo separado dentro dos artiodáctilos, mais proximamente relacionado aos Ruminantia.
*Este trecho ilustra um clássico caso de incongruência entre dados morfológicos e moleculares. A convergência de múltiplos marcadores moleculares independentes (mtDNA, genes nucleares) para a mesma hipótese (baleia-hipopótamo) fortalece a conclusão, demonstrando o poder do princípio da congruência de caracteres.*

A análise de SINEs confirma esta relação. Vários SINEs são comuns a Ruminantia, hipopótamos e cetáceos. Quatro SINEs aparecem apenas em hipopótamos e cetáceos. Essas observações implicam a árvore filogenética mostrada na Figura 1.5, na qual os eventos de inserção de SINEs estão marcados. *Os quatro SINEs exclusivos de hipopótamos e cetáceos funcionam como quatro sinapomorfias distintas e inequívocas. Essa evidência massiva corrobora o clado Cetartiodactyla e posiciona os hipopótamos como o grupo-irmão dos cetáceos, resolvendo a filogenia com alta confiança.* 

A Ausência de um Mecanismo de Remoção Precisa
A "irreversibilidade" decorre do fato de que as células **não possuem uma maquinaria enzimática capaz de realizar o processo inverso com precisão**. Para que a inserção fosse reversível, um sistema celular teria que:
1. **Reconhecer** a sequência específica do SINE/LINE inserido (que pode ter milhares de pares de bases) entre bilhões de outros pares de bases.
2. **Excisar (cortar)** a sequência inserida de forma exata em suas fronteiras, sem remover nenhum DNA flanqueador original.
3. **Reparar** o "buraco" no cromossomo, restaurando perfeitamente a sequência que existia _antes_ da inserção. A informação sobre o estado pré-inserção é perdida no momento da inserção, tornando este passo teoricamente muito improvável.

Não existe nenhum mecanismo molecular conhecido que realize essa tarefa de "excisão precisa e reparo perfeito".

O que pode ocorrer, como mencionado no texto anterior, são **deleções cromossômicas em larga escala**. Um segmento do cromossomo pode ser perdido aleatoriamente devido a um erro na replicação ou reparo do DNA. Se, por acaso, um SINE ou LINE estiver dentro desse segmento deletado, ele será removido junto com todo o DNA ao redor. 

Isso **não é uma reversão**, mas sim um evento de deleção aleatório e impreciso. Do ponto de vista filogenético, é um evento evolutivo completamente diferente e muito mais raro do que a inserção.
*A ausência de um mecanismo de excisão precisa é a chave para a baixa homoplasia desses marcadores. Enquanto mutações pontuais podem reverter, a remoção precisa de milhares de bases exigiria um mecanismo complexo e específico que não evoluiu.*

A função dos SINEs e LINEs é complexa, a resposta mais direta e fundamental é que, a princípio, **SINEs e LINEs não possuem uma função para o organismo hospedeiro**. A sua "função" primária é a sua própria sobrevivência e proliferação dentro do genoma.
- **LINEs (Elementos Autônomos):** A função de um LINE é executar seu próprio ciclo de retrotransposição. Os LINEs são autônomos porque codificam as enzimas (transcriptase reversa e endonuclease) necessárias para se copiar e se inserir em novos locais do genoma. Sua "função" é ser uma máquina de autorreplicação.
- **SINEs (Elementos Não Autônomos):** Os SINEs são ainda mais parasíticos. Eles não codificam suas próprias enzimas. A sua "função" é sequestrar a maquinaria de retrotransposição dos LINEs para criar cópias de si mesmos. Eles são, essencialmente, parasitas dos parasitas genômicos.
*A dinâmica SINE-LINE é um exemplo de coevolução parasitária no nível molecular. A análise bioinformática de genomas revela a dependência funcional dos SINEs, cuja abundância está correlacionada à presença de LINEs ativos no mesmo genoma.*

- **Criação de Novos Genes (Exonização):** Ocasionalmente, uma sequência de um SINE ou LINE inserida dentro de um gene pode ser reconhecida pela maquinaria de splicing da célula como um novo éxon. Esse processo, chamado **exonização**, incorpora o fragmento do elemento na proteína final, podendo gerar proteínas com novas funções.
-  **Arquitetura e Tamanho do Genoma:** A consequência mais óbvia da atividade desses elementos é o crescimento do tamanho do genoma. Eles são a principal razão pela qual o genoma humano, por exemplo, é tão grande e contém uma vasta quantidade de DNA não codificante.
*SINEs e LINEs são um motor de inovação evolutiva. Eles representam um reservatório de sequências que, por meio de processos estocásticos de inserção e cooptação, podem ser recrutadas para novas funções, ilustrando como a evolução aproveita o "ruído" genômico.*

---
## Searching for similar sequences in databases: PSI-BLAST
Um tema comum dos exemplos que tratamos é a busca em um banco de dados por itens similares a uma sonda (probe). Por exemplo, se estamos estudando um gene novo, ou se identificamos dentro do genoma humano um gene responsável por alguma doença, desejaremos determinar se genes aparentados aparecem em outras espécies. O método ideal é tanto sensível, isto é, ele detecta até mesmo relações muito distantes, quanto seletivo, isto é, todas as relações que ele reporta são verdadeiras. 
*A busca por homologia é um passo fundamental para inferir a função de um gene novo, baseando-se no princípio evolutivo da conservação funcional. A sensibilidade e a seletividade são cruciais para distinguir homólogos de análogos ou similaridades ao acaso.*

Uma ferramenta poderosa para buscar em bancos de dados de sequências com uma sequência sonda é o PSI-BLAST, do NCBI. PSI-BLAST é a sigla para *Position Specific Iterated - Basic Local Alignment Search Tool* (**Ferramenta de Busca por Alinhamento Local Básico Iterativo e Específico para a Posição**). Um programa anterior, o BLAST, funcionava identificando regiões locais de similaridade sem *gaps* e depois as unindo. O *PSI* em PSI-BLAST refere-se a melhorias que identificam padrões dentro das sequências em estágios preliminares da busca no banco de dados, e então os refinam progressivamente.
*A evolução do BLAST para o PSI-BLAST representa um avanço algorítimico. O método transcende a comparação simples e passa a construir um perfil, ou Matriz de Pontuação Específica para a Posição (PSSM), para capturar o contexto funcional de cada resíduo.*

O reconhecimento de padrões conservados pode aprimorar tanto a seletividade quanto a sensibilidade da busca. O PSI-BLAST envolve um processo repetitivo (ou interativo), à medida que o padrão emergente se torna mais bem definido em estágios sucessivos da busca.
*O processo iterativo do PSI-BLAST é uma forma de aprendizado de máquina. O perfil é refinado a cada rodada, permitindo a detecção de homólogos remotos cujo sinal evolutivo seria fraco demais para ser identificado em uma única busca com matrizes genéricas.*

Os poucos resultados do PSI-BLAST para a sequência sonda PAX-6, mostrados adiante, aparecem no formato:
*proteín paired box Pax-6 isoforma a homo sapiens*. Uma lista mais longa de resultados incluiria, obviamente, múltiplas sequências de muitas das espécies, e contribuições de muitas outras espécies. Como extrairíamos os nomes dessas espécies dos resultados? O que se segue é um exemplo típico dos recursos de identificação de padrões do PERL (Estudo de Caso 1.7).

---
**BOX 1.10 Sensibilidade e seletividade**
Os métodos de busca em bancos de dados envolvem um compromisso #tradeoff entre sensibilidade e seletividade. O método encontra todos ou a maioria dos exemplos que estão realmente presentes, ou ele perde uma grande fração? Inversamente, quantos dos *hits* que ele reporta estão incorretos? Suponha que um banco de dados contenham 1000 sequências de globina e que uma busca por globinas nete banco de dados reporte 900 resultados, dos quais 700 eram realmente sequências de globina e 200 não eram. Dir-se-ia que este resultado tem 300 falsos negativos (perdas) e 200 falsos positivos. Existe um compromisso entre sensibilidade e seletividade: diminuir um limiar de tolerância aumentará tanto o número de falsos negativos quanto o de falsos positivos. Frequentemente, está-se disposto a trabalhar com limiares baixos para ter certeza de não perder nada que possa ser importante, mas isso requer um exame detalhado dos resultados para eliminar os falsos positivos.

*Et in terra PAX hominibus, muscique...* (e na terra paz aos homens, e às moscas...)
Os olhos humanos, da mosca e do polvo são muito diferente em estrutura. O conhecimento convencional, notando a imensa vantagem seletiva conferida pela capacidade de enxergar, sustentava que os olhos surgiram independentemente em diferentes filos. Portanto, foi uma grande surpresa que um gene que contra o desenvolvimento ocular humano tenha um homólogo que governa o desenvolvimento ocular em *Drosophila*.

O gene PAX-6 foi primeiramente clonado no camundongo e no humano. É um gone regulador mestre, que controla uma complexa cascata de eventos no desenvolvimento ocular. Mutações no gene humano causam a condição clínica #aniridia, um defeito de desenvolvimento no qual a íris do olho está ausente ou deformada. O homólogo do PAX-6 em *Drosophila* - chamado de gene *eyeless*, tem uma função similar de controle sobre o desenvolvimento ocular. Moscas com mutação neste gente desenvolvem-se sem olhos; inversamente, a expressão deste gene na asa, perna ou antena de uma mosca produz olhos ectópicos (isto é, fora do lugar). (O mutante *eyeless de Drosophila foi descrito pela primeira vez em 1915*. Malta suspeitava, na época, de uma relação com um gene de mamífero.)

Não apenas os genes de insetos e mamíferos são similares em sequência, como também são tão proximamente relacionados que sua função cruza as fronteiras das espécies. A expressão do gene PAX-6 de camundongo na mosca causa o desenvolvimento de olhos ectópicos, assim como o faz a expressão do próprio gene eyeless da mosca. (Não se deve pensar, contudo, que o desenvolvimento ocular está sob o controle de um único gene. A expressão do PAX-6 de camundongo na mosca desencadeia uma complexa cascata de genes da mosca.)

O PAX-6 possui homólogos em outros filos, incluindo platelmintos, ascídias, ouriços-do-mar e nematoides. A observação de que as rodopsinas — uma família de proteínas que contêm retinal como cromóforo comum — funcionam como pigmentos sensíveis à luz em diferentes filos é uma evidência de suporte para uma origem comum de diferentes sistemas fotorreceptores. As genuínas diferenças estruturais na anatomia macroscópica de diferentes olhos refletem a divergência e o desenvolvimento independente da estrutura de ordem superior.

*O balanço entre sensibilidade e seletividade é um desafio central no design de algoritmos de bioinformática. Na prática, ao usar ferramentas como o BLAST, o ajuste do limiar (e.g., E-value) determina este compromisso. Um E-value mais baixo aumenta a seletividade (menos falsos positivos), mas pode diminuir a sensibilidade, perdendo homólogos distantes. A escolha depende do objetivo: descoberta exploratória (mais sensibilidade) versus anotação precisa (mais seletividade).*

**Sobre o parágrafo "Os olhos do humano, da mosca e do polvo...**
- *Este exemplo ilustra o conceito de homologia profunda. A descoberta de que estruturas análogas, como os olhos de vertebrados e insetos, são controladas por genes homólogos (PAX-6/eyeless) revolucionou a biologia evolutiva. Isso demonstra que a evolução não reinventou toda a cascata de desenvolvimento ocular, mas sim utilizou um programa genético ancestral comum, modificando-o para produzir resultados anatomicamente distintos em diferentes linhagens*

- *A funcionalidade do gene de camundongo em uma mosca é a prova experimental definitiva de ortologia—genes que divergiram por especiação. Este experimento demonstra uma conservação funcional extraordinária ao longo de mais de 500 milhões de anos de evolução. A bioinformática permite identificar essa homologia de sequência, mas a biologia experimental, como neste caso, confirma que a função do gene como um interruptor mestre da cascata de desenvolvimento ocular foi mantida intacta.*

**Sobre o parágrafo "O PAX-6 possui homólogos em outros filos...**:
- *E evolução atua em múltiplos níveis. A descoberta de PAX-6 e rodopsinas em diversos filos sugere que um kit de ferramentas genético para a fotorrecepção é ancestral e altamente conservado. A diversidade anatômica dos olhos resulta da divergência evolutiva das rede regulatórias que estão rio abaixo desses genes mestres. Portanto, a homologia no nível molecular profundo coexiste com a divergência na estrutura macroscópica, que evoluiu de forma independente em cada linhagem.*

**Estudo de Caso 1.7 - Quais espécies contêm homólogos ao PAX-6 humano detectáveis pelo PSI-BLAST?**
O PSI-BLAST reporta as espécies nas quais as sequências identificadas ocorrem (ver caixa intitulada Resultados de uma busca PSI-BLAST pela proteína PAX-6 humana.) Estas aparecem, embutidas no texto da saída, entre colchetes; por exemplo: 
``emb|CAA56038.1| (X79493) transcription factor [Drosophila melanogaster]``

O seguinte programa em PERL extrai os nomes das espécies da saída do PSI-BLAST:

```PERL
#!/usr/bin/perl
# extrai espécies da saída do psiblast
# Método:
# Para cada linha da entrada, verifica por um padrão da forma [Drosophila melanogaster]
# Usa cada padrão encontrado como o índice em um array associativo
# O valor correspondente a este índice é irrelevante
# Ao usar um array associativo, instâncias subsequentes da mesma
# espécie irão sobrescrever a primeira instância, mantendo apenas um conjunto
# único
# Após o processamento da entrada estar completo, ordena os resultados e imprime.

while (<>) { # lê uma linha da entrada
  if (/\[([A-Z][a-z]+ [a-z]+)\]/) { # seleciona linhas contendo strings da forma
                                  # [Drosophila melanogaster]
    $species{$1} = 1;             # cria ou sobrescreve a entrada no
  }                               # array associativo
}

foreach (sort(keys(%species))){ # em ordem alfabética,
  print "$_\n";                 # imprime os nomes das espécies
}
```

O programa faz uso dos ricos recursos de reconhecimento de padrões do PERL para buscar por strings de caracteres da forma `[Drosophila melanogaster]`. Queremos especificar o seguinte padrão:
- um colchete de abertura,
- seguido por uma palavra começando com uma letra maiúscula,
- seguida por um número variável de letras minúsculas,
- depois um espaço entre as palavras,
- depois uma palavra toda em letras minúsculas,
- depois um colchete de fechamento.

Esse tipo de padrão é chamado de **expressão regular** e aparece no programa PERL na seguinte forma: `\[([A-Z][a-z]+ [a-z]+)\]`.

Blocos de construção do padrão especificam intervalos de caracteres: `[A-Z]` = qualquer letra no intervalo A, B, C, ...Z `[a-z]` = qualquer letra no intervalo a, b, c, ...z

odemos especificar repetições: `[A-Z]` = uma letra maiúscula `[a-z]+` = uma ou mais letras minúsculas

e combinar os resultados: `[A-Z][a-z]+ [a-z]+` = uma letra maiúscula seguida por uma ou mais letras minúsculas (o nome do gênero), seguida por um espaço em branco, seguido por uma ou mais letras minúsculas (o nome da espécie).

Envolver isso em parênteses: `([A-Z][a-z]+ [a-z]+)` diz ao PERL para salvar o material que correspondeu ao padrão para referência futura. Em PERL, esse material correspondido é designado pela variável `$1`. 
Assim, se a linha de entrada contivesse `[Drosophila melanogaster]`, a instrução: `$species{$1} = 1;` seria efetivamente: `$species{"Drosophila melanogaster"} = 1;`

Finalmente, queremos incluir os colchetes que cercam o nome do gênero e da espécie, mas colchetes significam intervalos de caracteres. Portanto, devemos preceder os colchetes com barras invertidas `\[...\]` para obter o padrão final: `\[([A-Z][a-z]+ [a-z]+)\]`.

O uso do array associativo para reter apenas um conjunto único de espécies é outro aspecto instrutivo do programa. Lembre-se que um array associativo é uma generalização de um array ou vetor comum, no qual os elementos não são indexados por inteiros, mas por strings arbitrárias. Uma segunda referência a um array associativo com uma string de índice encontrada anteriormente poderia mudar o valor no array, mas não a lista de strings de índice. Neste caso, não nos importamos com o valor, mas apenas usamos as strings de índice para compilar uma lista única de espécies detectadas. Múltiplas referências à mesma espécie irão meramente sobrescrever a primeira referência, não criar uma lista repetitiva. O conjunto de índices (ou 'chaves') no array associativo `%species` coleta os nomes das espécies encontradas.

Versões mais novas do PSI-BLAST reportam a distribuição taxonômica dos _hits_. No entanto, o programa neste exemplo seria útil se alguém quisesse recuperar os alinhamentos ou realizar outros tipos de análise nos resultados.

O programa lidaria corretamente com identificadores contendo subespécies; por exemplo, `[Saimiri boliviensis boliviensis]`?

*Este script exemplifica uma tarefa fundamental da bioinformática: a análise sintática (parsing) de dados. Ferramentas de genômica frequentemente produzem saídas em texto semiestruturado, não em tabelas para uso. A programação, aqui demonstrada com PERL, é a habilidade indispensável para extrair, filtrar e reformatar informações relevantes de grandes arquivos de texto, transformando dados brutos em conhecimento estruturado e analisável, um pilar da biologia computacional.*

*As expressões regulares são uma ferramenta essencial e poderosa no arsenal da bioinformática para o reconhecimento de padrões. Elas fornecem uma linguagem concisa para descrever padrões complexos em sequências de DNA/proteínas ou em arquivos de anotação (GenBank). Dominar essa sintaxe é crucial para tarefas como encontrar sítios de restrição, validar formatos de dados e extrair informações específicas de forma robusta, evitando a criação de código complexo e propenso a erros.*

*A escolha da estrutura de dados correta é central para a eficiência de um algoritmo. O uso de um array associativo (ou hash) para garantir a unicidade dos nomes das espécies é uma solução elegante e computacionalmente eficiente. Em vez de percorrer uma lista a cada nova espécie para verificar se ela já existe, o hash permite acesso e inserção em tempo praticamente constante. Isso demonstra como o conhecimento de estruturas de dados básicas otimiza a resolução de problemas em genômica.*

Portanto, para garantir a unicidade de nomes de espécies (ou seja, evitar duplicatas), é melhor usar uma estrutura de dados que permita inserção e busca rápida. E para isso, ele cita: *Array associativo (ou hash)*, que, em Java, se refere a: #HashSet - só precisamos garantir a unicidade; #HashMap< String, ...>, se queremos associar algo a cada nome único (ex: contagem, dados da espécie etc.).
```java
import java.util.Hashset;

public class Exemplo {
	public static void main(String[] args) {
		HashSet<String> especies = new HashSet<>();

		String novaEspecie = "Panthera Leo";

		if (!especies.contain(novaEspecie)) {
			especies.add(novaEspecie);
			System.out.println("Especie adicionada.");
		} else {
			System.out.println("Espécie já existe.)
		}
	}
}
```
**Conslusão:** portanto, usar #HashMap ou #HashSet é mais eficiente do que um #ArrayList para garantir nomes únicos em problemas como os que aparecem em genômica computacional, onde o desempenho importa.


**Sobre a pergunta final, "O programa lidaria corretamente com subespécies?"**
- *A pergunta final expõe uma verdade fundamental da bioinformática: as ferramentas devem ser projetadas prevendo a complexidade e a inconsistência dos dados biológicos do mundo real. O script, como este, falharia com um nome de subespécie, pois a expressão regular espera exatamente duas palavras. Isso ensina que a validação, o tratamento de exceções e o design de algoritmos robustos são tão importantes quanto a lógica inicial, pois os formatos de dados biológicos raramente são perfeitamente uniformes.*

## Introduction to protein structure
Com as estruturas de proteínas, deixamos para trás o mundo unidimensional das sequências de nucleotídeos e aminoácidos e entramos no mundo espacial das estruturas moleculares. Alguns dos recursos para arquivar e recuperar informações de biologia molecular sobrevivem a essa mudança muito bem intactos, alguns devem ser substancialmente alterados, e outros não conseguem fazer a transição.

Bioquimicamente, as proteínas desempenham uma variedade de papéis nos processos vitais: existem proteínas estruturais (por exemplo, proteínas do capsídeo viral, a camada externa cornea da pele humana e animal, e proteínas do citoesqueleto); proteínas que catalisam reações químicas (as enzimas); proteínas de transporte e armazenamento (hemoglobina); proteínas reguladoras, incluindo hormônios e proteínas receptoras/ de transdução de sinal; proteínas que controlam a transcrição gênica; e proteínas envolvidas no reconhecimento, incluindo moléculas de adesão celular, e anticorpos e outras proteínas do sistema imune.

Proteínas são moléculas grandes. Em muitos casos, apenas uma pequena parte da estrutura, um sítio ativo, é diretamente funcional, com o resto existindo apenas criar e fixar a relação espacial entre os resíduos de sítio ativo.  As proteínas evoluem por meio de mudanças estruturais produzidas por mutações na sequência de aminoácidos e rearranjos genéticos que reúnem diferentes combinações de subunidades estruturais. 

Aproximadamente 100.000 estruturas de proteínas são agora conhecidas. A maioria foi determinada por cristalografia por raios-X ou ressonância magnética nuclear (RMN). A partir delas, derivamos nossa compreensão tanto das funções de proteínas individuais, por exemplo, a explicação química da atividade catalítica de enzimas, quanto dos princípios gerais de estrutura e enovelamento de proteínas.

Quimicamente, as moléculas de proteína são longos polímeros contendo tipicamente vários milhares de átomos, compostos por uma cadeia principal (ou *mainchain*) uniforme e repetitiva, com uma cadeia lateral particular ligada a cada resíduo. A sequência de aminoácidos de uma proteína registra a sucessão das cadeiras laterais.

A cadeia polipeptídica enovela-se em uma curva no espaço; o percurso da cadeia define um padrão de enovelamento. As proteínas exibem uma grande variedade de padrões de enovelamento. Subjacentes a estes, há um número de características estruturais comuns. Estas incluem a recorrência de paradigmas estruturas explícitos, por exemplo, α-hélices e folhas-β (Fig. 1.7), e princípios ou características comuns, como o empacotamento denso dos átomos no interior das proteínas. O enovelamento pode ser pensado como um tipo de condensação ou cristalização intramolecular.

*A transição do mundo 1D das sequências para o 3D das estruturas representa um salto fundamental na complexidade da bioinformática. Algoritmos de alinhamento de sequências, baseados em programação dinâmica, tornam-se insuficientes. Para comparar estruturas, são necessários algoritmos geometricamente complexos que operam sobre coordenadas atômicas para identificar sobreposições espaciais, definindo um campo inteiramente novo: a bioinformática estrutural, focada em predição de estruturas, docking e análise de superfícies moleculares.*

*Existe uma modularidade da evolução proteica. A existência de um andaime (scaffold) estrutural que suporta um pequeno sítio ativo explica como as proteínas podem acumular mutações em regiões não funcionais sem perder sua função essencial. Além disso, o conceito de rearranjos genéticos de subunidades (domínio) é um mecanismo evolutivo chave, permitindo que a natureza crie novas funções combinando domínios pré-existentes de maneiras novas, um processo análogo à recombinação de blocos de Lego funcionais.*

*O conjunto de estruturas experimentais (depositados em bancos de dados como o PDB), constitui o "padrão-ouro" par a genômica e a biologia computacional. Ela não apenas elucida a função, mas também serve como base de treinamento e validação para algoritmos de predição de estrutura. O desafio central da bioinformática estrutural é diminuir a lacuna entre o vasto número de sequências conhecidas e o número muito menor de estruturas determinadas experimentalmente, prevendo a estrutura 3D a partir da sequência 1D.*

*A existência de um repertório limitado de estruturas secundárias (α-hélices, folhas-β) é um princípio que torna a predição de estrutura computacionalmente tratável. Em vez de explorar um espaço conformacional infinito, os algoritmos podem primeiro prever a localização desses elementos estruturais locais a partir da sequência de aminoácidos. A etapa seguinte, muito mais complexa, é montar esses elementos em um arranjo terciário termodinamicamente estável, geralmente guiado pelo princípio do colapso hidrofóbico (empacotamento denso).*

## The hierarchical nature of protein architecture
O químico de proteínas dinamarquês K.U. Linderstrøm-Lang descreveu os seguintes níveis de estrutura de proteínas. A sequência de aminoácidos, o conjunto de ligações químicas primárias, é chamada de **estrutura primária**. A atribuição de hélices e folhas, o padrão de ligações de hidrogênio da cadeia principal, é chamada de **estrutura secundária**. A montagem e as interações das hélices e folhas são chamadas de **estrutura terciária**. Para proteínas compostas por mais de uma subunidade, J.D Bernal chamou a montagem dos monômeros de **estrutura quaternária**. Em alguns casos, a evolução pode fundir proteínas, mudando a estrutura quaternária para terciária. Por exemplo, cinco enzimas separadas na bactéria *E. coli* que catalisam etapas sucessivas na vida de biossíntese de aminoácidos aromáticos passaram por uma fusão gênica. Esses genes separados em _E. coli_ correspondem a cinco regiões de uma única proteína no fungo _Aspergillus nidulans_. Às vezes, monômeros homólogos foram oligômeros de maneiras diferentes; por exemplo, as globinas foram tetrâmeros nas hemoglobinas de mamíferos, e dímeros, usando uma interface diferente, no marisco arca Scapharca inaequivalvis.
*A evolução atua sobre todos os níveis de organização estrutural. O exemplo da fusão gênica é mecanisticamente poderoso: ele transforma uma interação de estrutura quaternária (entre proteínas separadas) em uma terciária (dentro de uma única cadeia), garantindo aa estequiometria e co-regulação dos componentes da vida. A bioinformática pode rastrear esses eventos evolutivos ao encontrar um único gene em um genoma que se alinha a múltiplos genes separados em outro, revelando a história da otimização de complexos proteicos.*
**Provou-se útil adicionar níveis adicionais à hierarquia, como se segue:**
- **Estruturas supersecundárias:** as proteínas mostram padrões recorrentes de interação entre hélices e folhas que estão próximas na sequência. Essas estruturas supersecundárias incluem o grampo de α-hélices (_α-helix hairpin_), o grampo-β (_β-hairpin_) e a unidade β-α-β (Fig. above): ![[Chapter 1 - Introduction-2.png]]

- **Domínios:** muitas proteínas contêm unidades compactas dentro do padrão de enovelamento de uma única cadeia que parecem ter estabilidade independente. Estes são chamados de domínios. (Não confunda domínios como subestruturas de proteínas com domínios como classes gerais de seres vivos: Archea, Bacteria e Eukarya). A proteína de ligação a RNA L1 (Fig. 1.9) tem características típicas de proteínas multidomínio: o sítio de ligação aparece em uma fenda entre os dois domínios, e a geometria relativa dos dois domínios é flexível, permitindo mudanças conformacionais induzidas por ligante. Na hierarquia, os domínios se situam entre as estruturas supersecundárias e a estrutura terciária de um monômero completo. 
*O domínio é a unidade fundamental da evolução e função das proteínas. Para a bioinformática, a anotação de uma sequência desconhecida com domínios conhecidos (usando bancos de dados como o Pfam) é frequentemente mais informativa do que um simples alinhamento global. A arquitetura de domínios de uma proteína, a sua combinação linear de domínios, serve como um poderoso preditor de sua função molecular, pois cada domínio geralmente corresponde a uma unidade funcional ou de enovelamento independente.*

- **Proteínas modulares:** proteínas modulares são proteínas multidomínio que frequentemente contêm muitas cópias de domínios proximamente relacionados. Os domínios recorrem em muitas proteínas em diferentes contextos estruturais; isto é, diferentes proteínas modulares podem *misturar e combinar* (mix and match) conjuntos de domínios. Por exemplo, a fibronectina, uma grande proteína extracelular envolvida na adesão e migração celular, contém 29 domínios, incluindo múltiplas repetições em tandem de três tipos de domínio, chamados F1, F2 e F3. É um arranjo linear da forma (F1)₆(F2)₂(F1)₃(F3)₁₅(F1)₃. Domínios de fibronectina também aparecem em outras proteínas modulares. (Veja [http://www.bork.embl-heidelberg.de/Modules/](http://www.bork.embl-heidelberg.de/Modules/) para figuras e nomenclatura.)
*A arquitetura modular é um motor primário da inovação evolutiva em eucariotos. O processo de embaralhamento de domínios (domain shuffling), facilitado pela estrutura de éxons e íntros, permite que a evolução experimente rapidamente com novas combinações de domínios funcionais. Isso gera uma vasta diversidade de proteínas com novas funções de reconhecimento, sinalização ou estruturais a partir de um repertório finito de blocos de construção, sendo um mecanismo chave para o aumento da complexidade biológica.*

## Classification of protein structures
A classificação mais geral das famílias de estruturas de proteínas é baseada nas estruturas secundária e terciária das proteínas.

**Tabela 1.2 Classificação de estruturas de proteínas com base na estrutura secundária e terciária**

| Classe                                              | Característica                                                                                                |
| :-------------------------------------------------- | :------------------------------------------------------------------------------------------------------------ |
| α-Helicoidal                                        | Estrutura secundária exclusiva ou quase exclusivamente de α-hélices.                                          |
| Folha-β                                             | Estrutura secundária exclusiva ou quase exclusivamente de folhas-β.                                           |
| α + β                                               | α-Hélices e folhas-β separadas em diferentes partes da molécula; ausência de estrutura supersecundária β-α-β. |
| α/β                                                 | Hélices e folhas montadas a partir de unidades β-α-β.                                                         |
| α/β-Linear                                          | A linha através dos centros das fitas da folha é aproximadamente linear.                                      |
| α/β-Barris                                          | A linha através dos centros das fitas da folha é aproximadamente circular.                                    |
| Proteínas com pouca ou nenhuma estrutura secundária |                                                                                                               |
Dentro dessas amplas categorias, as estruturas de proteínas exibem uma variedade de padrões de enovelamento. <span style="background:#affad1">Entre proteínas com padrões de enovelamento similares</span>, existem famílias que compartilham características de estrutura, sequência e função suficientes <span style="background:#affad1">para sugerir uma relação evolutiva</span>. No entanto, proteínas não aparentadas frequentemente exibem temas estruturas similares.
*A existência de dobras similares em proteínas não aparentadas destaca um desafio central da bioinformática: diferenciar homologia (ancestralidade comum) de analogia (convergência evolutiva para uma estrutura estável). Apenas a homologia permite inferir função com segurança.*

A classificação de estruturas de proteínas ocupa uma posição chave na bioinformática, inclusive como uma ponte entre sequência e função. Retornaremos a este tema para descrever resultados e websites relevantes. Enquanto isso, um álbum de pequenas estruturas oferece oportunidades para praticar a análise visual e o reconhecimento dos padrões espaciais importantes. 
*A estrutura é mais conservada na evolução do que a sequência. Quando a similaridade de sequência cai na "zona do crepúsculo" (twilight zone), a classificação estrutural torna-se a principal ferramenta para detectar relações evolutivas remotas e inferir função.*

**Acesso a estruturas macromoleculares**
O PDB é uma colaboração entre três projetos de arquivamento primários para integrar o arquivamento e a distribuição de estruturas macromoleculares biológicas:
- O Research Collaboratory for Structural Bioinformatics (RCSB) (EUA);
- O Protein Databank Europe Database (PDBe) (no EBI, Hinxton, Reino Unido);
- O Protein Data Bank/Japan (Osaka, Japão). Consulte o Weblem 1.
*A colaboração é crucial para padronizar o arquivamento de dados estruturais, um pré-requisito para criar os workflows de bioinformática robustos, necessários para processar o volume massivo de dados gerados por projetos de genômica e proteômica.*

Outros bancos de dados reorganizam e fornecem acesso aos dados, incluindo:
- O Structural Classification of Proteins (SCOP) e o Class, Architecture, Topology, Homologous superfamily (CATH) são bancos de dados cuidadosamente curados de todos os domínios de proteínas, classificados de acordo com a estrutura, função e evolução;
- O Molecular Modeling DataBase (MMDB) é o projeto dentro do sistema ENTREZ do NCBI, que trata de estruturas macromoleculares determinadas experimentalmente.
*A classificação hierárquica em bancos como SCOP e CATH reflete relações de homologia, permitindo que domínios estruturais sejam usados como caracteres filogenéticos para inferir a evolução molecular e as relações entre grupos de organismos.* (Baseado em Amorim, p. 27-31; Futuyma & Kirkpatrick, p. 48).

Naturalmente, há uma sobreposição considerável entre os sites. Cada um tem seus próprios pontos fortes, baseados em muitos casos nos interesses de pesquisa dos cientistas contribuintes. Por exemplo, o Macromolecular Structure Database no EBI mantém o site Protein Quaternary Structure, que indica o provável estado de montagem de proteínas multicadeia em suas formas biologicamente ativas. De fato, o grupo do EBI tem sido ativo na criação de uma série de ferramentas de software muito úteis para análise de estruturas de proteínas. Um exemplo é o PDBeMotif, uma ferramenta de busca rápida e poderosa que combina a pesquisa de sequências de proteínas, estruturas químicas (por exemplo, ligantes) e dados de coordenadas tridimensionais em uma única operação. Os diferentes sites também diferem em sua aparência e usabilidade (*look and feel*), e os usuários descobrirão suas próprias preferências.
*Ferramentas que integram dados de sequência, estrutura 3D e ligantes, como o PDBeMotif, superam as limitações da análise de sequência isolada, permitindo inferências funcionais mais precisas e alinhadas aos mecanismos de interação molecular da célula.* **(Baseado em Jones & Pevzner, Cap. 6; Alberts et al., p. 113, 131F).**

Estes e muitos outros sites fornecem facilidades de busca para identificar estruturas de interesse. Por exemplo, para localizar uma proteína de interesse no SCOP, o usuário pode percorrer a hierarquia estrutural ou pesquisar por meio de palavras-chave, como nome da proteína, código PDB, função (incluindo o número da Enzyme Commission) ou nome da dobra estrutural (por exemplo, barril). Para cada estrutura, o SCOP fornece informações textuais (incluindo o texto completo da entrada), imagens e links para outros bancos de dados. *A organização hierárquica do SCOP não é apenas um sistemas de catalogação, mas um modelo computacional da história evolutiva das proteínas, onde a posição de um domínio na árvore informa sobre sua origem e função provável.* **(Baseado em Amorim, p. 16-17; Deonier et al., p. 314).**

## Protein structure prediction and engineering
A sequência de aminoácidos de uma proteína dita sua estrutura tridimensional. Em um meio com solvente adequado e sob condições de temperatura como as do interior de uma célula, as proteínas enovelam-se (ou dobram-se) espontaneamente em seus estados ativos. As #chaperonas auxiliam as proteínas a se enovelarem corretamente, mas elas catalisam o processo em vez de dirigi-lo. 
*A informação na sequência de aminoácidos é o elo entre a mutação, no nível do gene, e a seleção natural, no nível fenotípico. A alteração da sequência pode impactar a estrutura e a função, sobre as quais a evolução atua.* **(Baseado em Futuyma & Kirkpatrick, Cap. 4; Alberts et al., p. 113).**

Se as sequências de aminoácidos contêm informação suficiente para especificar as estruturas tridimensionais das proteínas, deveria ser possível desenvolver um algoritmo para prever a estrutura de uma proteína a partir de sua sequência de aminoácidos. Isso tem se mostrado um desafio, embora o progresso recente seja impressionante. Consequentemente, além de se dedicarem ao problema fundamental da predição *a priori* da estrutura proteica a partir da sequência de aminoácidos, os cientistas definiram metas menos ambiciosas, como as seguintes:
*A divisão da predição estrutural em metas menores (estrutura secundária, reconhecimento de dobra), exemplifica uma estratégia comum em bioinformática: decompor um problema computacionalmente complexo em subproblemas que podem ser abordados com algoritmos e heurística eficientes.* **(Baseado em Jones & Pevzner, p. 7-10).**
1. **Predição de estrutura secundária:** quais segmentos da sequência formam hélices e quais formam fitas de uma folha-beta?
2. **Reconhecimento de dobra (fold recognition):** dada uma biblioteca de estruturas de proteínas conhecidas e suas sequências de aminoácidos, e a sequência de aminoácidos de uma proteína de estrutura desconhecida, podemos encontrar na biblioteca a estrutura que mais provavelmente possui um padrão de enovelamento similar ao da proteína de estrutura desconhecida?
3. **Modelagem por homologia:** suponha que uma proteína-alvo, de sequência de aminoácidos conhecida, mas de estrutura desconhecida, seja homóloga a uma ou mais proteínas de estrutura conhecida, Espera-se, então, que grande parte da estrutura da proteína-alvo se assemelhe à da proteína conhecida, e esta pode server de base para um modelo da estrutura-alvo. A completude e a qualidade do resultado dependem crucialmente do quão similares são as sequências. Como regra geral, se as sequências de duas proteínas relacionadas tiverem 50% ou mais de resíduos idênticos em um alinhamento ótimo, é provável que as estruturas tenham conformações similares em mais de 90% do modelo. 
*A modelagem por homologia aplica diretamente o princípio central da sistemática filogenética: a homologia, evidenciada pela similaridade de sequência, reflete um parentesco evolutivo que implica em semelhança estrutural e, frequentemente, funcional entre as moléculas* **(Baseado em Amorim, p. 27; Futuyma & Kirkpatrick, p. 48).**

Aqui estão as sequências alinhadas e as estruturas sobrepostas de duas proteínas relacionadas, a lisozima da clara do ovo de galinha (preto) e a α-lactalbumina de babuíno (verde). As sequências são proximamente relacionadas (37% de resíduos idênticos nas sequências alinhadas), e as estruturas são muito similares. Cada proteína pode servir como um bom modelo para a outra, pelo menos no que diz respeito ao traçado da cadeia principal. 
*O exemplo lisozima/α-lactalbumina ilustra como a duplicação gênica pode gerar novas funções (lactação) a partir de uma função ancestral (defesa), mantendo o arcabouço estrutural, evidenciando que a estrutura 3D é mais conservada que a sequência. (Baseado em Futuyma & Kirkpatrick, p. 505; Alberts et al., p. 129).*

## Critical Assessment of Structure Prediction
A avaliação de técnicas para predição de estruturas de proteínas requer testes cegos. Para este fim, J. Moult iniciou os programas bienais de Avaliação Crítica da Predição de Estruturas (CASP, na sigla em inglês). Cristalógrafos e espectroscopistas de RMN que estão no processo de determinar uma estrutura de proteína são convidados a (1) publicar a sequência de aminoácidos vários meses antes da data esperada para a conclusão de seu experimento e (2) comprometer-se a manter os resultados em segredo até uma data acordada. Os preditores submetem seus modelos, que são mantidos em sigilo até o prazo para a divulgação da estrutura experimental. Em seguida, as predições e os experimentos são comparados, para a alegria de poucos e a frustração da maioria.

Os resultados das avaliações do CASP registram o progresso na eficácia das predições, o que ocorreu em parte devido ao crescimento dos bancos de dados, mas também devido a melhorias...

*O modelo CASP exemplifica a necessidade de validação rigorosa em bioinformática, usando testes cegos par aevitar o sobreajuste (overfitting) de algoritmos e medir o progresso real dos métodos computacionais contra uma verdade experimental objetiva*. 

## Engenharia de Proteínas
Biólogos moleculares costumavam ser como astrônomos, no sentido de que podíamos observar nossos objetos de estudo, mas não modificá0los. Isso não é mais verdade. Em laboratório, podemos modificar ácidos nucleicos e proteínas à vontade. Podemos investigá-los por meio de mutações exaustivas para ver os efeitos na função. Podemos dotar proteínas antigas de novas funções, como no desenvolvimento de anticorpos catalíticos. Podemos até mesmo criar novas proteínas. 

Muitas regras sobre a estrutura de proteínas foram derivadas da observação de proteínas naturais. Essas regras não se aplicam necessariamente a proteínas engenheiradas. As proteínas naturais possuem características exigidas por princípios gerais da físico-química e pelo mecanismo da evolução proteica. As proteínas engenheiradas devem obedecer às leis da físico-química, mas não às restrições da evolução. As proteínas engenheiradas podem explorar um novo território. Isso inclui o aumento da termoestabilidade e da eficácia catalítica, características úteis para processos industriais. Os métodos de abordagem incluem a evolução dirigida para modificar uma estrutura inicial, o desenho *de novo* e combinações de técnicas. Os campos de aplicação de proteínas engenheiradas incluem, mas não se limitam a, medicina, indústria química, produção de biocombustíveis e biorremediação (a destruição de poluentes tóxicos no ambiente).
*A engenharia de proteínas permite saltar vales adaptativos do cenário evolutivo (fitness landscape), explorando funções que, embora físico-quimicamente possíveis, seriam inacessíveis à seleção natural por não haver um caminho gradual até elas.*

## Proteomics and transcriptomics
O proteoma, em analogia com o genoma, é o conjunto de proteínas de um organismo. A proteômica combina o censo, a distribuição, as interações, a dinâmica e os padrões de expressão de proteínas dentro de sistemas vivos. É uma área com uso intensivo de dados, dependente de medições de alto rendimento *high-throughput*. Estas incluem microarranjos de DNA, sequenciamento de RNA e espectrometria de massa. 

## Microarranjos de DNA
Microarranjos de DNA, ou chips de DNA, são dispositivos para verificar simultaneamente a presença de muitas sequências em uma amostra. Os microarranjos de DNA podem ser usados (1) para determinar padrões de expressão de diferentes proteínas pela detecção de mRNAs ou (2) para genotipagem, pela detecção de diferentes sequências de genes variantes, incluindo, mas não se limitando a, polimorfismos de nucleotídeo único (SNPs). É possível medir a simples presença ou ausência, ou quantificar a abundância relativa. 

Uma ressalva é que, devido a diferenças na meia-vida do mRNA e nas taxas de tradução, as concentrações de mRNAs e das proteínas correspondentes não são necessariamente proporcionais.
*A falta de proporcionalidade entre os níveis de mRNA e proteína revela a importância da regulação pós-transcricional. Isso demonstra que a transcriptômica sozinha é insuficiente, exigindo a proteômica para capturar o perfil funcional real da célula.* 

Do ponto de vista da bioinformática, os arranjos de DNA são mais um fluxo prolífico de criação de dados. Eles exigem o desenvolvimento eficaz de arquivos e sistemas de recuperação de informação. Uma vantagem é que os dados são todos t]ao novos que a área não está sobrecarregada com estruturas e formatos de dados baseados em gerações mais antigas de hardware e programas. 

**Quadro 1.11 Aplicações dos microarranjos de DNA**
- **Diagnóstico especializado de doenças.** Diferentes tipos de leucemia, por exemplo, podem ser identificados por diferentes padrões de expressão gênica. Conhecer o tipo exato da doença é importante para o prognóstico e para a seleção do tratamento. De forma mais geral, a análise do perfil de expressão de tumores permite a análise do desenvolvimento e da progressão da doença.
*A capacidade de subclassificar doenças com base em perfis de expressão, em vez de apenas morfologia, representa uma mudança na nosologia, permitindo diagnósticos mais precisos e terapias direcionadas, fundamentais para a medicina de precisão.*

- **Resistência de patógenos.** Comparações de genótipos ou padrões de expressão, entre cepas bacterianas suscetíveis e resistentes a um antibiótico, apontam para as proteínas envolvidas no mecanismo de resistência.
*A comparação de perfis entre linhagens resistentes e sensíveis é uma aplicação de genômica comparativa para estudar a evolução em tempo real, identificando os genes sob seleção positiva que conferem a vantagem adaptativa da resistência.*

### Transcriptomics and RNA sequencing
O sequenciamento direto de RNA está substituindo os microarranjos como o método de escolha para detectar padrões de transcrição. A transcrição reversa do RNA extraído de uma amostra de células em DNA complementar (cDNA) permite a aplicação de técnicas de sequenciamento de DNA de alto rendimento (*high-throughput*). Informações tanto estáticas versus dinâmicas quanto isoladas versus distribuídas estão disponíveis: a partir de sequências de células específicas em um momento particular, é possível detectar, por exemplo, abundâncias, variantes de splicing, SNPs e eventos de edição de RNA. Também é possível comparar diferentes tecidos, amostras de tecidos saudáveis versus doentes, e a dependência da idade da célula e do organismo.

## Systems biology
A palavra de ordem da biologia de sistemas é **integração**. A integração tem dois aspectos: Um é o estudo de padrões dentro de uma célula ou organismo: padrões de interações proteína-proteína e proteína-ácido nucleico, padrões de vias metabólicas e cascatas de controle, e padrões de expressão proteica. Os padrões têm aspectos tanto estáticos quanto dinâmicos. A identificação de pares de proteínas que se ligam umas às outras, e a montagem de interações pareadas em uma rede, produz um padrão estático. O fluxo de metabólitos através de uma rede de enzimas, ou o fluxo de informação por uma cascata de controle, é o padrão dinâmico.
*A biologia de sistemas supera a visão estática do interactoma, analisando os fluxos dinâmicos de matéria e informação. É a diferença entre possuir o mapa de uma cidade e compreender o trânsito e a comunicação que ocorrem nela.*

O outro aspecto da integração é a comparação da ocorrência, atividades e interações de genes e proteínas entre diferentes espécies. A razão pela qual a abordagem comparativa é tão poderosa em biologia é que os sistemas que estamos tentando entender surgiram através de processos de evolução. Espécies diferentes iluminam umas às outras. **Para entender o que significa ser humano, devemos apreciar tanto o que temos em comum com outras espécies quanto como nos diferenciamos.**
*Insight analítico: O poder da abordagem comparativa, central na biologia de sistemas, reside no princípio da homologia. A estrutura filogenética é o andaime que permite inferir a função e a evolução de redes moleculares conservadas entre as espécies. (Baseado em Amorim, p. 27; Futuyma & Kirkpatrick, Cap. 2).*

Métodos de alto rendimento (_high-throughput_) de genômica e proteômica fornecem dados sobre sequências, padrões de expressão e interações. A partir de sequências de genomas, podemos inferir as sequências de aminoácidos do complemente de proteínas de um organismo. A proteômica nos diz como os padrões de expressão dessas proteínas variam dentro do organismo, como mudam durante o desenvolvimento ou em resposta a mudanças nas condições, e como cooperam entre si. A biologia de sistemas considera esses dados como peças de um quebra-cabeças que se estende tanto no espaço quanto no tempo. Para entender o instrumento complexo e delicado que é a célula viva, devemos encaixar as peças em sua moldura. 

