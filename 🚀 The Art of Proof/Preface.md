We have written this book with several kinds of readers ind mind:
1. Undergraduates who have taken courses such as calculus and linear algebra, but who are not yet prepared for upper-level mathematics courses. We cover mathematical topics that these students should know. The book also provides a bridge to the upper-level courses, since we discuss formalities and conventions in detail, including the axiomatic method and how to deal with proofs.
2. Mathematics teachers and teachers-in-training. We present here some of the foundations of mathematics that anyone teaching mathematics beyond the most elementary levels should know.
3. High-school students with an unusually strong interest in mathematics. Such students should find this book interesting and (we hope) unconventional.
4. Scientists and social scientists who have found that the mathematics they studied as undergraduates is not sufficient for their present needs...

In so far as possible, we try to "work in" the formal methods indirectly, as we take the reader through some interesting mathematics. Our subjects is number systems: the integers and the natural numbers (that's the discrete Part I), the real numbers and the rational numbers (the continuous Part II). In this there is emphasis on induction, recursion, and convergence. We also introduce cardinal number, a topic that links the discrete to the continuous.

We teach method: how to organize a proof correctly, how to avoid fallacies, how to use quantifiers, how to negate a sentence correctly, the axiomatic method, etc. We assert that computer scientists, physicists, mathematics teachers, mathematically inclined economists, and biologists need to understand these things. Perhaps you too if you have read this far. 

We sometimes hear students speak of "theoretical math," usually in a negative tone, to describe mathematics that involves theorems and proofs rather than computations and applications. The trouble with this is that sooner or later, mathematics becomes sufficientyle subtle that fundamentals have to be understood. 

Nut who needs that level of precision? The answer is that almost all user of mathematics, excepts perhaps users at purely  computational levels, need to understand what they are doing, if only to have confidence that they are not making mistakes. Here are some examples?
- Toda essa pessoa com formação matemática deve compreender argumentos de indução e definições recursivas. É dificíil imagina como alguém poderia escrever um programa de computador não trivial sem esse entendimento básico. De fato, um engenheiro de software nosso conhecido nos conta que o software de sua (pequena) empresa possui 1,5 milhão de linhas de código, que devem ser fáceis de gerenciar; portanto, algoritmos, recursivos são proibidos, a menos que muito claramente marcados como tal, e a maioria de seus programadores não entende recursão profundamente o suficiente para que seus programas recursivos sejam confiáveis quanto a estarem livres de erros: então, eles apenas inserem um pacote de recursão retirado de uma biblioteca de software.

**Problema algorítmico:** você sabe desde a infância como somar uma coluna de números de muitos dígitos. Certamente, normalmente, fazemos isso na base 10. Conseguimos escrever, como uma recursão formalmente correta, o algoritmo que aprendemos quando criança para a adição de uma coluna de números inteiros na base 10. Nosso algoritmo deve ser tal que, em princípio, a entrada possa ser qualquer lista finita de números inteiros, e a saída deve imprimir os dígitos de nossa soma. E (agora a parte desafiadora), uma vez feito isso, você consegue provar que seu algoritmo sempre fornece a resposta correta? Você sequer sabe o que tal pergunta significa?

Às vezes ouvimos estudantes dizerem: "eu gosto de matemática, mas não gosto de demonstrações." Eles ainda não perceberam que uma demonstração nada mais é do que uma explicação do porque uma afirmação cuidadosamente formulada é verdadeira. A explicação também deve ser cuidadosamente formulada: o que é dito deve ser o que se quer dizer, e o que se quer dizer deve ser o que é dito.

**É melhor termos clareza sobre quais axiomas estamos assumindo para os números inteiros e naturais, algo discutido em detalhes neste livro.**

Aqui está uma questão simples de probabilidade: um baralho de *n* cartas diferentes é embaralhado e colocado à mesa pela sua mão esquerda, virado para baixo. Um baralho idêntico de cartas, embaralhado de forma independente, é colocado à sua direita, também virado para baixo. Começamos a virar as cartas no mesmo ritmo com ambas as mãos: primeiro a carta do topo de ambos os baralhos, depois a segunda carta de ambos os baralhos, e assim por diante. 

Qual é a probabilidade de que vire simultaneamente cartas idênticas dos dois baralhos? A resposta deve depender de *n*. À medida que *n* se torna muito grande, o que acontece com essa probabilidade? Ela converge para 0? Ou para 1? Ou para algum número entre eles? E, se for o caso, que número é esse? E o que exatamente significa dizer que esse número é o limite das probabilidades à medida que *n* fica cada vez maior? E quão rápido (em termos de *n*) a *n-ésima* probabilidade se aproxima desse número limite?

O nosso ponto não é que devamos resolver este pequeno problema, embora seja divertido fazê-lo e não seja difícil, mas sim que sejamos capaz de dizer com confiança que, em princípio, compreende todas as questões levantadas. Se não conseguimos dizer isso, talvez precisemos de algo como este livro.

Já ouvimos estudantes dizerem: "apenas os números inteiros, e talvez os racionais, têm alguma relevância no mundo; os número reais irracionais são construções acadêmicas artificais. Ora, não é possível sequer escrever suas expansões decimais".

Isso só é verdade no sentido mais estrito. Contra a noção de que números irracionais não aparecem na vida real, apresentamos:
- A diagonal de um quadrado com lado de um pé tem comprimento de raiz de 2 pés;
- A razão entre a circunferência de um círculo e seu diâmetro é pi;
- A resposta para o nosso problema de limite sobre os dois baralhos de cartas é 1 - 1/e. Encontra-se o número e também em cálculos de hipotecas e em crescimento ou decaimento exponencial.

Além disso, os números irracionais muitas vezes precisam ser aproximados por racionais dentro de uma margem de erro especificada. Como alguém pode fazer isso sem compreender as questões envolvidas na aproximação: algoritmos e cálculos de erros?

Há uma velha piada entre os físicos de que "todas as séries convergem uniforme e absolutamente em todo lugar". Frequentemente, um professor de física desconsiderará questões de convergência. Por exemplo, todos os termos de uma série de potências além da primeira ou segunda ordem serão descartados, sob a suposição de que são pequenos demais para influenciar a resposta de forma significativa.
Isso funciona em situações clássicas, nas quais se sabe há muitos anos que a série em discussão fornece respostas fisicamente plausíveis, alinhadas com dados experimentais medidos com frequência (e o professor ou sabe qual é a situação da convergência, ou sabe que outros a verificaram cuidadosamente).

Mas o seu conhecimento não deve ser tão fraco a ponto de você não ter certeza se a sua série "converge", "converge absolutamente" ou "converge uniformemente", e qual é a diferença entre isso.

Você estuda matemática importante e útil desde os três anos de idade. Muito provavelmente, o corpo de matemática que você conhece pode ser descrito como "da Vila Sésamo ao Cálculo". Tudo isso é matemática boa e séria — desde o belo algoritmo de adição, que todos aprendemos no ensino fundamental, passando pela álgebra e geometria do ensino médio, até o cálculo.

Agora, chegamos ao estágio em que os detalhes do que já sabemos precisam ser refinados. Precisamos compreendê-los de um ponto de vista mais avançado.

Na verdade, não examinaremos tudo o que você sabe — isso levaria muito tempo. Concentramo-nos aqui nos números: inteiros, frações, números reais, decimais, números complexos e números cardinais. Gostaríamos de ter tempo para fazer o mesmo tipo de exame detalhado da geometria do ensino médio, mas isso daria outro livro e, como treinamento matemático, apenas ensinaria as mesmas coisas novamente.

Uma vez que entendamos o que estamos ensinando neste livro, neste curso, seremos capaz de aplicar esses métodos e ideias a outras partes da matemática em cursos futuros.

Os tópicos cobertos aqui formam parte do "cânone" padrão que se pressupõe que todos com formação matemática saibam. Livros sobre a história da matemática, por exemplo, _Mathematics and Its History_ (de J. Stillwell, Springer, 2004) e _Math Through the Ages_ (de W. P. Berlinghoff e F. Q. Gouvea, Oxton House, 2002), discutem quem descobriu ou introduziu esses tópicos pela primeira vez. Alguns remontam a centenas de anos; outros foram desenvolvidos gradualmente e alcançaram sua forma atualmente aceita no início do século XX. Devemos dizer claramente que nenhuma matemática neste livro se origina de nós.

Somos matemáticos pesquisadores ativos e acreditamos, tanto para nós mesmos quanto para nossos alunos, que aprender matemática por meio de discussão oral é geralmente mais fácil do que aprender matemática por meio da leitura, embora a leitura e a escrita sejam necessárias para acertar os detalhes. Então, escrevemos uma espécie de manual ou guia para uma discussão de um semestre — dentro e fora da sala de aula.

Por favor, leia as Notas para Instrutores nas páginas seguintes. Há muito lá que é útil para você também. E boa sorte. A matemática é bela, satisfatória, divertida, profunda e rica.

## Notas para Instrutores
A lógica mova-se em uma direção: a direção da clareza, da coerência e da estrutura. A ambiguidade mova-se na outra direção: a da fluidez, da abertura e do desprendimento. A matemática mova-se para lá e para cá entre esses dois polos. [...] É a interação entre esses diferentes aspectos que dá à matemática seu poder. William Byers (_How Mathematicians Think_, Princeton University Press, 2007)

Este livro destina-se principalmente a estudantes que já estudaram cálculo ou álgebra linear e que agora desejam fazer cursos que envolvam teoremas e demonstrações de maneira essencial. O livro também é para estudantes que têm menos bagagem, mas possuem fortes interesses matemáticos.

Escrevemos o texto para um curso de um semestre ou dois trimestres; tipicamente, tal curso tem um título como "Portal para a Matemática", "Introdução a Demonstrações" ou "Introdução à Matemática Superior". Nosso livro é mais curto do que a maioria dos textos projetados para tais cursos. Nossa crença, baseada em muitos anos lecionando este tipo de curso, é que os papéis do instrutor e do livro-texto são menos importantes do que o grau em que o estudante é convidado/solicitado/obrigado a fazer o trabalho duro.

Aqui está o que estamos tentando alcançar:
1. Mostrar ao estudante uma matemática importante e interessante;
2. Mostrar ao estudante como ler e entender enunciados e demonstrações de teorems.
3. Ajudar o estudante a descobrir demonstrações de teoremas enunciados, e a redigir as demonstrações recém-descobertas corretamente e de maneira profissional.
4. Fomentar no estudante algo tão próximo quanto viável da experiência de fazer pesquisa em matemática. Assim, queremos que o estudante realmente descubra teoremas e redija demonstrações corretas e profissionais dessas descobertas. Isso é diferente de ser capaz de redigir demonstrações de teoremas que foram pré-certificados como verdadeiros por nós (no texto) ou pelo instrutor (em aula). 

Uma vez que o último destes objetivos tenha sido alcançado, o estudante é um matemático. Não temos nenhuma técnica mágica para levar o estudante a esse ponto rapidamente, mas este livro pode servir como um começo.

Muitos livros destinados a um curso de introdução (ou transição) são abstratos demais para o nosso gosto. Eles focam nos diferentes tipos de demonstrações e no desenvolvimento de técnicas para saber quando usar cada método. Nós preferimos começar com matemática útil logo no primeiro dia, e deixar que os vários métodos de demonstração, definição, etc., apresentem-se naturalmente conforme forem necessários no contexto.

Aqui está uma rápida indicação da nossa filosofia geral:

**Sobre a Escolha do Material**
Não começamos com os habituais capítulos secos sobre "Lógica" e "Teoria dos Conjuntos". Em vez disso, adotamos a visão de que o estudante é inteligente, tem considerável experiência com matemática e sabe, pelo senso comum, a diferença entre uma dedução lógica e uma bobagem.

Para dissipar o medo desde o início, dizemos ao estudante: "Um teorema é simplesmente uma sentença que expressa algo verdadeiro; uma demonstração é apenas uma explicação do porquê aquilo é verdade." Claro, isso abre muitas outras questões de método, que abordaremos gradualmente ao longo do curso.

Dizemos ao estudante algo como o seguinte: "Você estuda matemática importante e útil desde os três anos de idade; o corpo de matemática que conhecemos é 'da Vila Sésamo ao Cálculo'. Agora é hora de revisitar (parte dessa) boa matemática e organizá-la adequadamente. A primeira vez que a maioria de nós ouvimos um teorema ser provado foi quando perguntou a algum adulto: *Existe um maior número?* (Que resposta lhe deram? O que responderia agora se uma criança de quatro anos lhe fizesse essa pergunta?) Mais tarde, ensinaram-nos a representar números da base 10, e a somá-los e multiplicá-los. Você percebeu quanto está enterrado por trás disso (sistemas numéricos, axiomas, algoritmos...)? Nós desmontaremos o que você pensava saber e o remontaremos de uma maneira tão clara que você poderá prosseguir com confiança para uma matemática mais profunda."

**The Parts of the Book**
O material coberto neste livro consiste em duas partes de tamanho igual: uma parte discreta (inteiros, indução, aritmética modular, conjuntos finitos, etc.) e uma parte contínua (números reais, limites, decimais, números cardinais infinitos, etc.). Recomendamos que se dedique o mesmo tempo a ambas as partes.

Assim, o instrutor deve resistir à tentação de deixar a discussão em aula da Parte 1 se estender até a oitava semana de um semestre. Alguma disciplina em relação aos prazos das tarefas de casa também é necessária nesse ponto, para que os alunos dediquem tempo e atenção suficientes à segunda metade. (O instrutor que ignorar este conselho provavelmente será alvo de críticas dos colegas: este curso é frequentemente um pré-requisito para análise real.)

Ainda assim, um instrutor tem muita liberdade sobre como abordar o material. Para fins de planejamento, incluímos abaixo um diagrama mostrando as dependências das seções.

Para adicionar flexibilidade e material para leitura posterior, terminamos o livro com uma coleção de tópicos adicionais, por exemplo, grafos de Cayley de grupos e criptografia de chave pública.

Esses capítulos adicionais são independentes uns dos outros e podem ser inseridos no curso conforme desejado. Eles também devem ser adequados para apresentações de alunos em sala de aula.

**Problemas**
Existem três tipos de exercícios para os estudantes neste livro:
O corpo principal do texto consiste em proposições (chamadas de teoremas quando são particularmente importantes), nas quais a matemática é desenvolvida. Em princípio, pretende-se que essas proposições sejam provadas pelos estudantes; no entanto, provar todas elas provavelmente seria exaustivo, então o instrutor deve exercer julgamento. Além disso, algumas das proposições são provadas no texto para dar ao estudante uma noção de como desenvolver uma demonstração de uma determinada afirmação, e também para introduzir diferentes métodos de demonstração. Das proposições restantes, tendemos a provar aproximadamente metade em sala de aula no quadro-negro e passar a outra metade como problemas de casa. Mediante solicitação (veja [www.springer.com/instructors](https://www.springer.com/instructors)), o instrutor pode obter uma cópia gratuita deste livro (em formato PDF) na qual a maioria das demonstrações está resolvida em detalhes.

Há também exercícios chamados projetos. Estes são problemas mais exploratórios, às vezes de final aberto, para os estudantes trabalharem. Eles variam muito em dificuldade — alguns são mais elementares do que as proposições, alguns dizem respeito a conjecturas não resolvidas e alguns são projetos de redação destinados a fomentar a exploração pelos estudantes. Encorajaríamos os estudantes a fazê-los em grupos. Alguns poderiam ser a base para uma festa de pizza fora da sala de aula, um projeto por festa. Os tópicos adicionais no final do livro também se prestam a projetos em grupo.

Começamos cada capítulo com um projeto introdutório rotulado _Antes de Começar_ (Before You Get Started). Estes pretendem ser mais intensivos em escrita do que os projetos no texto principal. Eles tipicamente convidam os estudantes a refletir sobre o que já sabem de aulas anteriores como uma introdução ao capítulo. Estes projetos introdutórios encorajam o estudante a ser criativo, pensando sobre um tópico antes de estudá-lo formalmente.


Às vezes dizemos em aula que leremos a demonstração como se fosse um programa de computador: se o programa não roda, deve haver alguma primeira linha onde o problema ocorre. É aí que a linha vermelha está.

