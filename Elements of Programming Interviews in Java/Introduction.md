**"E deve-se lembrar que não há nada mais difícil de se empreender, mais perigoso de conduzir ou mais incerto em seus resultados do que assumir a liderança na introdução de uma nova ordem das coisas."**  
— N. Maquiavel, 1513

Mudar o mundo, criar algo novo, propor uma ideia ou sistema é uma das tarefas mais difíceis que existem. Quem lidera esse tipo de mudança corre riscos, porque vai enfrentar resistência de quem se beneficia da ordem atual. E não há garantia de sucesso, porque as pessoas têm medo do novo e preferem o que já conhecem, mesmo que não seja o melhor.

---
Elements of Programming Intervies, tem como objetivo ajudar engenheiros que estão se preparando para entrevistas de desenvolvimento de software. O foco principal do EPI está em estrutura de dados, algoritmos, design de sistemas e resolução de problemas. O conteúdo é apresentado principalmente por meio de questões.

**An interview problem**
Vamos começar com a Figura 1 abaixo. Ela mostra a variação no preço das ações de uma empresa ao longo de 40 dias. Especificamente, para cada dia, o gráfico exibe a máxima e a mínima do dia, além do preço na abertura do pregão (representado por um quadrado branco).

Agora imagine que, numa entrevista, te pedem para projetar um algoritmo que determine o maior lucro possível que poderia ser obtido comprando e depois vendendo uma única ação dentro de um terminado intervalo de dias - com a restrição de que a compra e a venda precisam acontecer na abertura do dia. 

**Primeiro, esclareça o problema:** qual é o formato da entrada?
Vamos supor que a entrada consista em três arrays L, H e S, contendo números de ponto flutuante não negativos, representando os preços mínimos, máximos e de abertura de cada dia.

A restrição de que a compra e a venda devem ocorrer no início do dia significa que basta considerar o array S.

Podemos ficar tentados em simplesmente retornar a diferença entre o menor e o maior valor de S. Mas, se testar alguns casos, veremos que o menor valor pode aparecer *depois* do maior valor, o que viola a exigência do enunciado - é preciso comprar antes de vender.

---

# Getting Ready Chapter 1
"Antes de tudo, estar preparado é o segredo do sucesso." - H. Ford

A parte mais importante da preparação para entrevistas é conhecer bem o conteúdo técnico e praticar a resolução de problemas.
No entanto, os aspectos não técnicos da entrevista também são muito importantes - e muitas vezes negligenciados.

Os capítulos 1 a 3 do livro tratam justamente dessas partes não técnicas, como:
1. Como preparar um currículo eficaz;
2. Como funcionam as decisões de contratação;
3. Como se portar durante o processo seletivo.

**Guia de Estudo**
Idealmente, você se prepararia para uma entrevista resolvendo todos os problemas do EPI, Isso é viável ao longo de 1 ano se resolvermos 1 problema por dia, onde resolver significa escrever um programa e fazê-lo funcionar em alguns casos de teste.

Como diferentes candidatos têm diferentes restrições de tempo, delineamos vários cenários de estudo e  recomendamos um subconjunto de problemas para cada cenário. Essas informações estão resumidas na Tabela 1.2 na página 9. Os cenários de preparação que consideramos são Hackathon (um fim de semana inteiramente dedicado à preparação), revisão final intensiva (uma semana, 3-4 horas por dia), projeto semestral (quatro semanas, 1,5-2,5 horas por dia) e curso de algoritmos (3-4 meses, 1 hora por dia).

Os problemas são representativos dos problemas que encontraremos em uma entrevista. Se precisarmos de uma revisão sobre estruturas de dados e algoritmos, dê uma olhada no site do EPI, que inclui uma coleção de problemas de revisão que o prepararão para o EPI de forma mais rápida do que um livro-texto faria.

A grande maioria das perguntas de entrevista no Google, Amazon, Microsoft e empresas semelhantes é retirada dos tópicos abordados nos Capítulos 5 a 15. Use o bom senso ao utilizar a Tabela 1.2; por exemplo, se estivermos nos candidatando a uma posição em uma empresa financeira, resolva mais problemas relacionados à probabilidade.

Embora um entrevistador ocasionalmente possa fazer uma pergunta diretamente do EPI, não podemos nos basear na nossa preparação na memorização de soluções. Aprender de forma mecânica provavelmente levar a fornecermos uma solução perfeita para o problema errado.

O capítulo 25 contém uma coleção diversificada de perguntas desafiadoras. Use-as para aprimorar suas habilidades de resolução de problemas, mas vá até elas apenas depois de ter feitos avanços significativos nos capítulos anteriores. 

**O ciclo de vida da entrevista**
1. Identifique empresas nas quais estamos interessado e, idealmente, encontre pessoas que conheçamos nessas empresas.
2. Prepare seu currículo usando as diretrizes da página a seguir e envie-o por meio de um contato pessoal (preferencial), ou através de um processo de inscrição online ou em uma feira de carreiras no campus.
3. Realize uma triagem inicial por telefone, que geralmente consiste em uma sessão de perguntas e respostas por telefone ou videochamada com um engenheiro. Você pode ser solicitado a enviar código por meio de um documento compartilhado ou de um site de codificação online, como ideone.com, collabedit.com ou coderpad.io. Não encare a triagem de forma casual — ela pode ser extremamente desafiadora
4. Vá para uma entrevista presencial — esta consiste em uma série de entrevistas individuais com engenheiros e gerentes, além de uma conversa com seu contato no Departamento de Recursos Humanos (HR).
5. Receba ofertas - estas geralmente são um ponto de partida para negociações.

Observe que pode haver variações - por exemplo, uma empresa pode entrar em contato com você, ou podemos nos candidatar por meio do centro de colocação profissional de nossa faculdade. A triagem pode envolver uma tarefa de casa a ser feita antes ou depois da conversa. A entrevista presencial pode ser realizada durante uma sessão de videoconferência. A maioria das entrevistas presenciais dura meio dia, mas outras podem durar o dia inteiro. Para qualquer coisa que envolva interação pela rede, certifique-se absolutamente de resolver as questões logísticas com antecedência (um local tranquilo para conversar com um telefone fixo em vez de um celular, familiaridade com o site de codificação e o software de chat, etc.).

Recomendamos que você faça entrevistas em quantos lugares puder, sem que isso atrapalhe seu trabalho ou suas aulas. A experiência o ajudará a se sentir mais confortável com o processo de entrevista, e você pode descobrir que realmente gosta de uma empresa sobre a qual não sabia muito.

O currículo
Sempre nos espanta ver candidatos que se dedicaram arduamente por pelo menos quatro anos na faculdade, e muitas vezes ainda mais no ambiente de trabalho, gastando apenas 30 minutos anotando informações aleatórias sobre si mesmos e chamando o resultado de currículo.

Um currículo precisa atender ao pessoal do RH, aos indivíduos que irão entrevistá-lo e ao gerente de contratação. O pessoal do RH, que geralmente revisa seu currículo primeiro, busca palavras-chave, então você precisa garantir que essas estejam bem representadas. As pessoas que irão entrevistá-lo e o gerente de contratação precisam saber o que você fez que o torna especial, então é necessário que você se diferencie
Aqui estão alguns pontos-chave a serem considerados ao escrever um currículo:
1. Tenha uma declaração clara de seu objetivo; em particular, certifique-se de adaptar seu currículo para um empregador específico.
	Ex. "Minha habilidade excepcional é desenvolver soluções para problemas computacionais desafiadores; comunicá-las por meio de formas escrita e oral; e trabalhar com equipes para implementá-las. Gostaria de aplicar essas habilidades na XYZ.

2. Os pontos mais importantes - aqueles que o diferenciam de todos os outros - devem vir primeiro. As pessoas que leem seu currículo o fazem em ordem sequencial, então você quer impressioná-las com o que o torna especial logo no início. Manter um fluxo lógico, embora desejável, é secundário em relação a esse princípio.
	Como consequência, não devemos listar nossas linguagens de programas, cursos, etc., no início, já que esses provavelmente são comuns a todos. Devemos listar projetos significativos de classes (isso também ajuda com palavra-chave para o RH), bem como palestras/artigos que apresentou e até notas de teste padronizados, se forem realmente excepcionais.

3. O currículo deve ser de alta qualidade: sem erros de ortografia; espaçamentos, capitalizações e numerações consistentes; e gramática e pontuação corretas. Use poucas fontes. O PDF é preferível, pois ele é renderizado bem em diferentes plataformas.

4. Inclua informações de contato, um perfil no Linkedin e, idealmente, uma URL para uma página pessoa com exemplos de nossos trabalhos. Essas amostras podem ser projetos de classe, uma tese e links para empresas e produtos nos quais já trabalhamos. Inclua documentos de design, bem como um link para o nosso repositório de controle de versão.
5. Se pudermos trabalhar na empresa sem necessitar de nenhuma processamento especial (por exemplo, se tiver um Green Card e estiver se candidatando para um emprego nos EUA), mencione isso.
6. Um currículo não precisa ter apenas uma página — duas páginas são perfeitamente adequadas. (Mais de duas páginas provavelmente não é uma boa ideia.
7.  Como regra geral, preferimos não ver uma lista de hobbies/atividades extracurriculares (por exemplo, "ler livros", "assistir TV", "organizar atividades de festas de chá"), a menos que elas sejam realmente diferentes (por exemplo, "remador olímpico") e não controversas.

Sempre que possível, tenha um amigo ou conhecido profissional na empresa para encaminhar seu currículo ao gerente ou contato de RH apropriado - as chances de ele chegar às mãos certas são muito maiores. Em uma empresa cujas práticas conhecemos, um currículo enviado por meio de um contato tem 50 vezes mais probabilidade de resultar em contratação do que um enviado online. Não se preocupe em desperdiçar o tempo do seu contato - os funcionários muitas vezes recebem um bônus de indicação, e ser responsável por trazer talentos valiosos também é visto de forma positiva.

**Mock interviews**
Entrevistas simuladas (mock interviews) são uma ótima maneira de se preparar para uma entrevista. Peça a um amigo que faça perguntas (do EPI ou de qualquer outra fonte) e resolva-as em um quadro branco, com caneta e papel, ou em um documento compartilhado. Peça ao seu amigo para tomar notas e dar feedback, tanto positivo quanto negativo. Faça uma gravação em vídeo da entrevista. Podemos sentir desconfortável ao assistir, mas é melhor identificar os tiques e maneirismo antecipadamente. Peça ao amigo que dê dicas quando ficarmos preso. Além de aprimorar nossas habilidades de resolução de problemas e apresentação, a experiência ajudará a reduzir a ansiedade no ambiente de uma entrevista real. Se não conseguir encontrar um amigo, ainda pode seguir o mesmo processo sozinho, gravando-se.

**Language review**
Os programas são escritos em Java 1.7. Algumas construções específicas do Java 1.7 que utilizamos são:
- O operador diamante (<>), que reduz a verbosidade ao declarar e instanciar variáveis, a **classe utilitária** *Objects*, facilita a escrita de funções de hash e comparadores, e **literais binários e underscores**, que tornam constantes integrais mais legíveis, por exemplo, 8b881_88881.

Normalmente, declaramos classes auxiliares como **static**, **inner classes** da classe de nível superior que fornece a solução. 

**Best practices for interview code**
Agora descrevemos práticas que utilizamos no EPI que não são adequadas para código de produção. Elas se tornam necessárias devido às restrições de tempo finito de uma entrevista. 
- Tornamos os **files** públicos, ao invés de utilizar getters e setters;
- Não protegemos contra entrada inválidas, por exemplo, referências **null**, entrada negativas em um array que deveria conter apenas valores negativos, **input streams** que contêm objetos que não são do tipo esperado, etc.
- Ocasionalmente usamos **static fields** para passar valores - isso reduz o número de classes que precisamos escrever, ao custo de perder a **thread safety**;

Agora descrevemos práticas que seguimos no EPI que são padrão na indústria, mas que não recomendaríamos para uma entrevista.
- Usamos identificadores longos para finds pedagógicos, por exemplo, *queuOfMaximalUsers*. Em uma entrevista real, você pode usar nomes mais curtos e menos descritivos do que usamos em nossos programas - escrever *queuOfMaximalUsers* repetidamente consome muito tempo comparado a simplesmente usar q;

## Strategies For a Great Interview
Uma entrevista típica de uma hora com um único entrevistador consiste em cinco minutos de apresentações e perguntas sobre o **résumé** do candidato. Em seguida, são feitos de cinco a quinze minutos de perguntas sobre conceitos básicos de programação. O núcleo da entrevista envolve uma ou duas questões de design detalhado, nas quais se espera que o candidato apresente uma solução completa em um **whiteboard**, papel ou IDE.

Dependendo do entrevistador e da pergunta, pode ser exigido que a solução inclua código com sintaxe correta e testes.

**Abordando o problema**
Não importa quão preparado ou esperto você esteja, a solução para um problema de entrevista pode não vir à mente imediatamente. Aqui estão algumas coisas para ter em mente quando isso acontecer:

**Esclareça a pergunta:** isso pode parecer óbvio, mas é impressionante quantas entrevistas vão mal porque o candidato passa a maior parte do tempo tentando resolver o **problema errado**. Se uma pergunta parecer excepcionalmente difícil, talvez tenhamos entendido de forma incorreta.,

Uma boa forma de esclarecer a pergunta é propor um exemplo concreto do problema. Por exemplo, se a pergunta for:
*Encontre a primeira ocorrência de um número maior que k em um array ordenado.*
**Podemos perguntar:**
*Se o array de entrada for (2, 20, 30) e k for 3, então devo retornar 1, o índice de 20?*

Essas perguntas podem ser formalizadas como **unit tests**. 

Sinta-se à vontade para perguntar ao entrevistador qual complexidade de tempo e espaço ele espera na solução. Se disserem que devemos implementar um algoritmo O(n) ou usar O(1) de espaço, isso pode simplificar bastante. É possível que ele se recuse a especificar isso, ou seja vaga sobre os requisitos de complexidade, mas não há problema em perguntar. 

**Trabalhe com exemplos concretos:** considere o problema de determinar o menor valor de troco que não conseguimos formar com um determinado conjunto de moedas. Esse problema pode parecer difícil a primeira vista. No entanto, se testarmos os menores valores que não podem ser formados com alguns exemplos simples, por exemplo, (1, 2), (1, 3), (1, 2, 4), (1, 2, 5), chegaremos a insights importantes: analise as moedas em **ordem** e procure por um **salto** grande - uma moeda que seja maior do que a soma das moedas anteriores.

**Explicite a solução brute-force:** os problemas apresentados em entrevistas geralmente têm uma solução força bruta óbvia, mas com alta complexidade de tempo em comparação com soluções mais sofisticadas. Por exemplo, ao invés de tentar imediatamente desenvolver uma solução com **programação dinâmica (DP)** para um problema, experimente todas as configurações possíveis:
1. Ela ajuda a identificarmos oportunidades de otimização e, assim, alcançar uma solução melhor;
2. Dá a chance de demonstrar nossas habilidades de **resolução de problemas e codificação**;
3. Garante que tanto eu quanto o entrevistador estamos prestando a atenção no mesmo problema.

**Pense em voz alta:** uma das piores coisas que podemos fazer em uma entrevista é travar diante de um problema. É sempre uma boa ideia **pensar em voz alta** para nos mantermos engajados. Por um lado, isso aumenta as nossas chances de encontrar a solução correta, pois obriga a organizarmos o nosso pensamento de forma coerente. Por outro, ajuda o entrevistador a guiar o nosso raciocínio na direção certa. Mesmo que não chegue à solução, o entrevistador ainda assim formará uma boa impressão de nossa **capacidade intelectual**. 

**Aplique padrões: Patterns** podem ser uma ótima forma de abordar um problema confuso., Exemplos incluem: identificar uma **estrutura de dados** apropriada, verificar se o problema se encaixa em alguma técnica algorítmica geral (como **divide-and-conquer**, **recursion** ou **dynamic programming**), ou transformá-lo em um problema de **graph**.

**Presenting the solution**

Uma vez que tenhamos o algoritmo, é importante apresentá-lo de forma clara.. Sua solução será muito mais simples se aproveitarmos bibliotecas como o **Java Collections** ou o **C++ Boost**. Por tanto, é muito mais importante usar a linguagem com a qual nos sentimos mais confortável. Aqui estão alguns pontos a considerar ao apresentar uma solução:
**Libraries:** não reivente a roda (a menos que seja solicitado isso). Em especial, domine as **libraries**, especialmente as **data structures**. Por exemplo, não perca tempo (e nem credibilidade) tentando lembrar como passar um **explicit comparator** para um construtor de BST. Lembre-se de que uma **hash function** deve usar exatamente os campos que são utilizados na verificação de igualdade. 

**Foque no algoritmo de alto nível:** não tem problema usar funções que vamos implementar depois. Isso permite que nos concentre na parte principal do algoritmo e seja menos penalizado caso não consiga completar tudo. Funções como **hash**, **equals** e **compare** são ótimos exemplos para deixar a implementação para depois. Deixe claro que vamos focar primeiramente no algoritmo principal e, depois, nos **corner cases**. Adicione comentário do tipo **TODO** nas partes que pretende voltar mais tarde.

**Gerencie o quadro branco:** provavelmente usaremos mais espaço do que podemos imaginar, então, comece no canto superior esquerdo. Faça o uso de funções - pule a implementação de qualquer coisa trivial (por exemplo, encontrar o valor máximo de um array) ou padrão (como configurar uma **thread poll**). As boas práticas de codificação no quadro branco são bem diferentes das práticas em um projeto real de produção. 

Adote uma convenção para os nomes de variáveis, como:
- i, j e k para índices de array;
- A, B e C para arrays;
- u, v, w para vetores;
- s para uma String;
- sb para um #StringBuild 

