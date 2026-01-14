*Em que discutimos a natureza dos agentes, perfeitos ou não, a diversidade de ambientes e a consequente variedade de tipos de agentes.*

O capítulo 1 identificou o conceito de **agentes racionais** como questão central para nossa abordagem da inteligência artificial. Neste capítulo, tornaremos essa noção mais concreta. Veremos que o conceito de racionalidade pode ser aplicado a uma ampla variedade de agentes que operam em qualquer ambiente imaginável. Nosso plano neste livro é usar esse conceito para desenvolver um pequeno conjunto de princípios de proje

to com a finalidade de construir sistemas de agentes bem-sucedidos, sistemas que possam ser adequadamente chamados **inteligentes**.

Começaremos examinando agentes, ambientes e o acoplamento entre eles. A observação de que alguns agentes se comportam melhor que outros leva naturalmente à ideia de agente racional, um agente que se comporta tão bem quanto possível. A medida da qualidade do comportamento de um agente depende da natureza do ambiente; <span style="background:#b1ffff">alguns ambientes são mais difíceis que outros</span>. Apresentaremos uma divisão geral dos ambientes em categorias e mostraremos como as propriedades de um ambiente influenciam o projeto de agentes adequados para esse ambiente. Descreveremos vários "esqueletos" básicos de projetos de agentes que serão utilizados no restante do livro.

## 2.1 Agentes e Ambientes
Um #agente é tudo o que pode ser considerado capaz de perceber seu **ambiente** por meio de **sensores** e de agir sobre esse ambiente por intermédio de **atuadores**. 
Essa ideia simples é ilustrada na Figura 2.1. Um agente humano tem olhos, ouvidos e outros órgãos como sensores, e tem mãos, pernas, boca e outras partes do corpo que servem como atuadores. Um agente robótico pode ter câmeras e detectores da faixa de infravermelho funcionando como sensores e vários motores como atuadores. Um agente de software recebe sequências de teclas digitadas, conteúdo de arquivos e pacotes de rede como  entradas sensórias e atua sobre o ambiente exibindo algo na tela, escrevendo em arquivos e enviando pacotes de rede.

Utilizamos o termo **percepção** para fazer referência às entradas perceptivas do agente em um dado instante. A **sequência de percepções** do agente é a história completa de tudo o que o agente já percebeu. Em geral, a escolha de ação de um agente em qualquer instante dado pode depender da sequência inteira de percepções recebidas até o momento, mas não de percepções não recebidas. Se pudermos especificar a escolha da ação do agente para toda sequência de percepções possível, teremos dito quase tudo o que existe a dizer sobre o agente. Em termos matemáticos, afirmamos que o comportamento do agente é descrito pela **função do agente** que mapeia qualquer sequência de percepções específica para uma ação.

Podemos imaginar a *tabulação* da função do agente que descreve qualquer agendado dado; para a maioria dos agentes, o resultado seria uma tabela muito grande, quase infinita, a menos que seja definido um limite sobre o comprimento das sequências de percepções que queremos considerar. Dado um agente para a realização de experimentos, podemos, em princípio, construir essa tabela tentando todas as sequências de percepções e registrando as ações que o agente executa em resposta. É claro que a tabela é uma caracterização *externa* do agente. Internamente, a função do agente para um agente artificial será implementada pelo **programa do agente**. 

**Função de agente:** é uma descrição matemática abstrata;
**Programa do agente:** é uma implementação concreta, executa em um sistema físico. 

!![image-202619243498.png](/image-202619243498.png)

Vamos imaginar o mundo de aspirador de pó. Esse mundo é tão simples que podemos descrever tudo o que acontece; ele também é um mundo inventado e, portanto, podemos criar muitas variações. Esse mundo particular tem apenas dois locais: os quadrados A e B. O agente aspirador de pó percebe em que quadrado está e se existe sujeira no quadrado. Ele pode optar por mover-se para a esquerda, mover-se para a direita, aspirar a sujeira ou não fazer nada. Uma função do agente muito simples é: se o quadrado atual estiver sujo, então aspirar, caso contrário, mover-se para o outro quadrado e não fazer nada. Uma tabulação parcial da função desse agente é mostrada na figura 2.3 e um programa do agente que o implementa aparece na Figura 2.8, página 43.

O que torna um agente bom ou ruim, inteligente ou estúpido? 

A nossa noção de um agente deve ser vista como uma ferramenta para analisar sistemas, não como uma caracterização absoluta que divide o mundo em agentes e não agentes. Poderíamos visualizar uma calculadora portátil como um agente que escolhe a ação de exibir "4" ao receber a sequência de percepções "2 + 2 = ", mas tal análise dificilmente ajudaria nossa compreensão da calculadora. Todas as áreas de engenharia podem ser vistas como projetar artefatos que interagem com o mundo; a IA opera no que os autores consideram ser o final mais interessante do espectro, onde os artefatos têm consideráveis recursos computacionais e o ambiente de tarefa requer uma tomada de decisão não trivial. 

#Agente na IA, **pode ser apenas um pedaços de código**.
Um filtro de spam é um agente, ele percebe o ambiente (os e-mails que chegam) através de "sensores" (o texto e o remetente) e "age" (move para o lixo ou para a caixa de entrada) através de seus "atuadores". 

O conceito mais importante aqui é o loop constante entre o agente e o mundo. Imaginemos o seguinte esquema:
1. Sensores: como o agente "lê" o mundo (Câmeras, microfones, leitura de arquivos, sensores de temperatura);
2. Processamento: onde a "mágica" acontece. O agente decide o que fazer com a informação. 
3. Atuadores: como agente muda o mundo (braços mecânicos, exibição de uma mensagem na tela, envio de um comando para outro software)...

Ser racional não significa que o agente nunca erra. Significa que ele faz **a melhor escolha possível** com a informação que tem no momento.

**O ambiente dita as regras do jogo**
O design de IA muda completamente dependendo de onde ela atua:
- Ambiente Simples: um jogo de Xadrez. As regras são claras, tudo está visível e nada muda a menos que alguém jogue.
- Ambiente Difícil: dirigir um carro na chuva. O ambiente é imprevisível, a visão é limitada (sensores ruins) e as regras mudam a cada segundo.

IA é pura engenharia.
**Ambiente**": portal do SEFAZ (servidores, páginas HTLM, protocolos de segurança);
**Sensores (Como ele percebe):** as respostas HTTP que o nosso código recebe. O código HTML da página (que o nosso scraper lê)
O status de uma requisição
Imagens de Captcha.

**O nosso agente é racional?**
O algoritmo é racional se ele:
1. Maximiza o sucesso: ele consegue extrair a NFC-e na maioria das vezes?
2. Lida com obstáculos: se o sefaz cai ou muda o layout, o nosso agente tem lógica para tentar novamente ou reportar o erro?

O nosso scraper é um **Agente de Reflexo Simples**.

Ele não aprende sozinho ainda; ele segue regras fixas ( o que chamamos de *condition-action rules*). 

Veremos que a "percepção" do nosso agente pode ser transformada em *vetores* e *matrizes*, e a "decisão" dele em um cálculo de probabilidade.

## 2.2 Bom Comportamento: o Conceito de Racionalidade
Um **agente racional** é aquele que faz tudo certo, em termos conceituais, toda entrada na tabela correspondente à função do agente é preenchida de forma correta. Fazer tudo certo é melhor do que fazer tudo errado; porém, o que significa fazer tudo certo?

Responderemos a essa antiga questão de uma forma antiquada: considerando as *consequências* do comportamento do agente. Quando um agente é colocado em um ambiente, gera uma sequência de ações de acordo com as percepções que recebe. Essa sequência de ações faz com que o ambiente passe por uma sequência de estados. Se a sequência for desejável, o agente teve bom desempenho. Essa noção de "desejável" é capturada por uma **medida de desempenho** que avalia qualquer sequência dada dos estados do ambiente. 

Observe que dissemos estados do *ambiente*, não estados do *agente*. Se definirmos sucesso em termos da opinião do agente do seu próprio desempenho, um agente poderia alcançar a racionalidade perfeita simplesmente iludindo-se de que seu desempenho foi perfeito. Os agentes humanos em particular são notórios por ficar com "dor de cotovelo", acreditando que realmente não queriam alguma coisa depois não conseguir. 

Obviamente, não há uma medida de desempenho fixa para todas as tarefas e agentes; normalmente, um projetista vai desenvolver uma adequada às circunstâncias. Não é tão fácil como parece. Considere, por exemplo, o agente aspirador de pó. Poderíamos propor medir o desempenho pela quantidade de sujeira aspirada em um único turno de oito horas. É claro que, no caso de um agente racional, obtemos aquilo que solicitamos. <span style="background:#fff88f">Um agente racional pode maximizar essa medida de desempenho limpando a sujeira e, em seguida, desejando-a toda no chão</span>, depois limpando novamente, e assim por diante. Uma medida de desempenho mais apropriada recompensaria o agente por deixar o chão limpo. Por exemplo, ele poderia ser recompensado por cada quadrado limpo e em cada período (talvez com uma penalidade pela eletricidade consumida e pelo ruído gerado). <span style="background:#b1ffff">Como regra geral, é melhor projetar medidas de desempenho de acordo com o resultado realmente desejado no ambiente, em vez de criá-las de acordo com o comportamento esperado do agente.</span>

Mesmo que as armadilhas óbvias sejam evitadas, ainda existem algumas questões complexas para desembaraçar. Por exemplo, a noção de "chão limpo" no parágrafo anterior se baseia na limpeza média ao longo do tempo. Ainda assim, a mesma limpeza média pode ser alcançada por dois agentes diferentes, um dos quais faz o trabalho tedioso de limpeza o tempo todo, enquanto o outro limpa energicamente, mas faz longas pausas. A estratégia preferível pode parecer um detalhe secundário da ciência do trabalho doméstico, mas de fato é uma profunda questão filosófica com extensas implicações. O que é melhor: uma vida aventureira, cheia de altos e baixos, ou uma existência segura, porém monótoma? O que é melhor: uma economia em que todos vivam em pobreza moderada ou aquela em que alguns vivem em plena riqueza enquanto outros são muito pobres? 8 ou 80

### 2.2.1 Racionalidade
A definição do que é racional em qualquer instante dado depende de quatro fatores:
- A medida de desempenho que define o critério de sucesso;
- O conhecimento prévio que o agente tem do ambiente;
- As ações que o agente pode executar
- A sequência de percepções do agente até o momento

Isso conduz a uma **definição de um agente racional:**
Para cada sequência de percepções possível, um agente racional deve selecionar uma ação que se espera venha a maximizar sua medida de desempenho, dada a evidência fornecida pela sequência de percepções e por qualquer conhecimento interno do agente.

Consideramos o agente aspirador de pó simples que limpa um quadrado se ele estiver sujo e passa para o outro quadrado se o primeiro não estiver sujo; essa é a função do agente tabulada na Figura 2.3. Esse é um agente racional? Depende! Primeiro, precisamos dizer o que é a medida de desempenho, o que se conhece sobre o ambiente e quais são os sensores e atuadores que o agente tem. Vamos supor que:
- A medida que desempenho ofereça o prêmio de um ponto para cada quadrado limpo em cada período de tempo, ao longo de um "tempo de vida" de 1.000 passos de tempo;
- A "geografia" do ambiente seja conhecida *a priori*, mas a distribuição da sujeira e a posição inicial do agente não sejam previamente conhecidas. Quadrados limpos permanecem limpos, e a aspiração limpa o quadrado atual. As ações Esquerda e Direita movem o agente para fora do ambiente; nesse caso, o agente permanece onde está;
- As únicas ações disponíveis são *Esquerda, Direita e Aspirar*
- O agente percebe corretamente sua posição e se essa posição contém sujeira.

Afirmamos que, sob essas circunstâncias, o agente é de fato racional; espera-se que seu desempenho seja pelo menos tão alto quanto o de qualquer outra agente. 

Podemos ver facilmente que o mesmo agente seria irracional sob circunstâncias diferentes. Por exemplo, uma vez que toda a sujeira seja limpa, o agente oscila desnecessariamente de um lado para outro; se a medida de desempenho incluir uma penalidade de um ponto para cada movimento à esquerda ou à direita, o agente ficará em má situação. Um agente melhor para esse caso não faria nada se tivesse certeza de que todos os quadrados estão limpos. Se quadrados limpos puderem ficar sujos novamente, o agente deve ocasionalmente verificar e voltar a limpá-los, se necessário. Se a geografia do ambiente for desconhecida, o agente precisará explorá-la. 

### 2.2.2 Onisciência, aprendizado e autonomia
Precisamos ter o cuidado de distinguir entre racionalidade e **onisciência**. 

Um agente onisciente sabe o resultado real de suas ações e pode agir de acordo com ele; porém, a onisciência é impossível na realidade. 

A racionalidade não é o mesmo que perfeição. A racionalidade maximiza o **desempenho** esperado, enquanto a perfeição maximiza o desempenho real. Fugir à exigência de perfeição não é apenas uma questão de ser justa com os agentes. Se esperarmos que um agente realize aquela que virá a ser a melhor ação após o fato, será impossível projetar um agente para satisfazer essa especificação, a menos que melhoremos o desempenho de bolas de cristal ou máquinas do tempo.

**Coleta de Informações** é uma parte importante da racionalidade e é abordada em profundidade no Capítulo 16. Um segundo exemplo de coleta de informações é dado pela exploração que tem de ser empreendida por um agente aspirador de pó em um ambiente inicialmente desconhecido. 

Nossa definição exige um agente racional não apenas para coletar informações, mas também para **aprender** tanto quanto possível a partir do que ele percebe. A configuração inicial do agente poderia refletir algum conhecimento prévio do ambiente, mas, à medida que o agente ganha experiência, isso pode ser modificado e ampliado. 

Quando um agente se baseia no conhecimento anterior de seu projetista e não em suas próprias percepções, dizemos que o agente não tem **autonomia**. Um agente racional deve ser autônomo, ele deve aprender o que puder para compensar um conhecimento prévio parcial ou incorreto. 

Do mesmo modo que a evolução fornece aos animais reflexos internos suficientes para que eles possam sobreviver pelo tempo necessário para aprenderem por si mesmos, seria razoável fornecer a um agente de inteligência algum conhecimento inicial, bem como habilidade para aprender.

Depois de adquirir experiência suficiente sobre seu ambiente, o comportamento de um agente racional pode se tornar efetivamente *independente* de seu conhecimento anterior. Em consequência disso, a incorporação do aprendizado permite projetar um único agente racional que terá sucesso em ampla variedade de ambientes.

## 2.3 A Natureza dos Ambientes
Precisamos pensar em ambientes de tarefas, que são essencialmente os "problemas" para os quais os agentes racionais são as "solucções". Começamos mostrando como especificar um ambiente de tarefa ilustrando o processo com vários exemplos. Em seguida, mostrando que há vários tipos de ambientes de tarefas. O tipo de ambiente de tarefa afeta diretamente o projeto apropriado para o programa do agente.

### 2.3.1 Especificando o ambiente de tarefa
