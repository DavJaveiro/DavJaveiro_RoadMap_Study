This chapter focuses on the first step in any data science project: exploring the data.

A estatística clássica se concentrava quase que exclusivamente na inferência, um conjunto de procedimentos, às vezes complexo, para tirar conclusões sobre grandes populações com base em pequenas amostras. Em 1962, John W. Tukey pediu uma reforma da estatística em seu artigo seminal "The Future of Data Analysis" (O futuro da análise de dados). Ele propôs uma nova disciplina científica chamada análise de dados, que incluía a inferência estatística como apenas um componente. Tukey estabeleceu vínculos com as comunidades de engenharia e ciência da compuitação (ele cunhou os termos bit, abreviação de dígito binário, e software), e seus princípios originais são surpreendentemente duradouros e fazem parte da base da ciência de dados. O campo da análise exploratória de dados foi estabelecido com o agora clássico livro de Tukey, Exploratory Data Analaysis. Tukey apresentou gráficos simples, (por exemplo, boxplots, scat-terplots) que, juntamente com estatísticas resumidas (média, mediana, quantis, etc), ajudam a pintar uma imagem de um conjunto de dados. 

Com a disponibilidade imediata de capacidade de computação e softwares de análise de dados expressivos, a análise exploratória de dados evoluiu muito além de seu escopo original. Os principais impulsionadores dessa disciplina foram o rápido desenvolvimento de novas tecnologias, o acesso a dados cada vez maiores e o maior uso da análise quantitativa em diversas disciplinas. David Donoho, professor de estatística da Universidade de Stanford e ex-aluno de graduação de Tukey, escreveu um excelente artigo com base em sua apresentação no workshop do Centenário de Tukey em Princeton, Nova Jersey. Donoho traça a gênese da ciência de dados até o trabalho pioneiro de Tukey na análise de dados.

## Elements of Structured Data
Data comes from many sources: sensores de medição, eventos, textos, imagens e vídeos. A Internet das Coisas (IoT) está lançando fluxos de informações. Grande parte desses dados não é estruturada: as imagens são uma coleção de pixels, com cada pixel contendo informações de cores RGB (vermelho, verde, azul). Os textos são sequências de palavras e caracteres que não são palavras, geralmente organizados por seções, subseções e assim por diante. #Clickstreams são sequências de ações de um usuário que interage com um aplicativo ou uma página web. Da fato, um grande desafio da ciência de dados é aproveitar essa torrente de dados brutos em informações acionáveis. Para aplicar os conceitos estatísticos abordados neste livro, os dados brutos não estruturados devem ser processados e manipulados em uma forma estruturada. Uma das formas mais comuns de dados estruturados é uma tabela com linhas e colunas, como os dados que podem emergir de um banco de dados relacional ou ser coletado para um estudo. 

Há dois tipos básicos de dados estruturados: **numéricos** e **categóricos**. Os dados numéricos são apresentados de duas formas: contínua, como a velocidade do vento ou a duração do tempo, e discreta, como a contagem da ocorrência de um evento. Os dados categóricos assumem apenas um conjunto fixo de valores, como um tipo de tela de TV (plasma, LCD, LED etc) ou um nome de estado (Ala- bama, Alasca etc). 

Por que nos preocupamos com uma taxonomia de tipos de dados? Acontece que, para fins de análise de dados e modelagem preditiva, o tipo de dados é importante para ajudar a determinar o tipo de exibição visual, análise de dados ou modelo estatístico. De fato, os softwares de ciência de dados, como o R e o Python, usam esses tipos de dados para melhorar o desempenho computacional. Mais importante ainda, o tipo de dados de uma variável determina como o software lidará com os cálculos dessa variável.

Os engenheiros de software e programadores de banco de dados podem se perguntar por que precisamos da noção de dados categóricos e ordinais para análise. Afinal, as categorias são apenas uma coleção de valores de texto (ou numéricos), e o banco de dados subjacentes manipula automaticamente a representação interna. No entanto, a identificação explícita dos dados como categóricos pode funcionar como um sinal que informa ao software como os procedimentos estatísticos, como a produção de um gráfico ou o ajuste de um modelo, devem se comportar. Em particular, os dados ordinais podem ser representados como um fator ordenado no R, preservando uma ordenação especificada pelo usuário em gráficos, tabelas e modelos. Em Python, o scikit-learn oferece suporte a dados ordinais com o sklearn.preprocessing. OrdinalEncoder, o armazenamento e a indexação podem ser otimizados (como em um banco de dados relacional), os valores possíveis que uma determinada variável categórica pode assumir são aplicados no software (como um enum).

O terceiro "benefício" pode levar a um comportamento não intencional ou inesperado: o comportamento padrão das funções de importação de dados no R (por exemplo, read.csv) é converter automaticamente uma coluna de texto em um fator. As operações subsequentes nessa coluna assumiarão que os únicos valores permitidos para essa coluna são os originalmente importados, e a atribuição de um novo valor de texto introduzirá um aviso e produzirá...
O pacote pandas em Python não fará essa conversão automaticamente. No entanto, podemos especificar uma coluna como categórica explicitamente na função read_csv.

## Rectangular Data
O quadro de referência típico para uma análise de ciência de dados é um objeto de dados retangular, como uma planilha ou uma tabela de banco de dados. Dados retangulares é o termo geral para uma matriz bidimensional com linhas indicando registros (Casos) e colunas indicando recursos (variáveis); quadro de dados é o formato específico em R e Python. 

Os dados nem sempre começam nesse formato: os dados não estruturados (por exemplo, texto) devem ser processados e manipulados para que possam ser representados como um conjunto de recursos nos dados retangulares ()

*Data Frame* os dados retangulares são a estrutura básica de dados para modelos estatísticos e de aprendizado de máquina.

*Feature:* Uma coluna em uma tabela é comumente chamada de recurso. 

*Outcome:* muitos projetos de ciência de dados envolvem a previsão de um resultado, geralmente um resultado do tipo sim/não 

*Records:* uma linha em uma tabela é comumente referida como um registro. 

!![image-20262241917645.png](/image-20262241917645.png)
há uma combinação de dados medidos ou contados (por exemplo, duração e preço) e dados categóricos (por exemplo, categoria e moeda). Como mencionado anteriormente, uma forma especial de variável categórica é uma variável binária (sim/não ou 0/1), vista na coluna mais à direita na Tabela 1-1, uma variável indicadora que mostra se um leilão foi competitivo (teve vários licitantes) ou não. Essa variável indicadora também é uma variável de resultado, quando o cenário é prever se um leilão é competitivo ou não. 

## Data Frames and Indexes
As tabelas de banco de dados tradicionais têm uma ou mais colunas designadas como índice, essencialmente um número de linha. Isso pode melhorar muito a eficiência de determinadas consultas a bancos de dados. Em python, com a biblioteca pandas, a estrutura de dados retangular básica é um objeto #DataFrame.

Por padrão, um índice inteiro automático é criado para um DataFrame com base na ordem das linhas. No pandas, também é possível definir índices multiníveis/hierárquicos para melhorar a eficiência de determinadas operações.  

Em R, a estrutura de dados retangular básica é um objeto data.frame. Um data.frame também tem um índice inteiro implícito baseado na ordem das linhas. O data.frame nativo do R não oferece suporte a índices especificados pelo usuário ou multiníveis, embora uma chave personalizada possa ser criada por meio do atributo row.names. Para superar essa deficiência, dois novos pacotes estão ganhando uso generalizado: data.table e dplyr. Ambos oferecem suporte a índices multiníveis e aumentam significativamente a velocidade de trabalho com um data.frame.


## Nonrectangular Data Structures
