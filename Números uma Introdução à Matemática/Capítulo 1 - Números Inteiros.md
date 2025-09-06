## 1.1 Introdução
A geometria costuma ser apresentada como uma ciência na qual todas as proposições podem ser logicamente demonstradas a partir de algumas afirmações iniciais chamadas #axiomas ou postulados. Essa apresentação é muito antiga; data do século IV a.C., quando Euclides de Alexandria escreveu seus famosos *Elementos*.

#Axioma é uma afirmação aceita como verdadeira **sem necessidade de prova.** Serve como ponto de partida para construir teorias. A partir dos axiomas, aplicam-se regras da lógica para deduzir outras verdades. Essas verdades deduzidas são chamadas de proposições ou teoremas. 
**Axioma:** "se dois números são iguais a um terceiro, então são iguais entre si."
**Proposição:** Se a = c e b = c, então a = b.
Os axiomas são como os tijolos básicos de uma construção matemática, tudo o que vem depois depende deles. 

**Axioma 1:** Todos os homens são mortas.
**Axioma 2:** Sócrates é um homem.
**Conclusão (proposição):** Sócrates é mortal.

Nesse caso, os axiomas são as **premissas** que usamos para aplicar uma **regra lógica** (o silogismo) e chegar a uma conclusão. 

Chamamos de **proposição** ou **sentença** toda oração declarativa que pode ser classificada em verdadeira ou em falsa.
Toda proposição apresenta três características obrigatórias:
1. Sendo oração, tem sujeito e predicado;
2. é declarativa (não é exclamativa nem interrogativa);
3. tem um, e somente um, dos dois valores lógicos: ou é verdadeira (V) ou é falsa (F).

Algo bem diferente acontece com a álgebra e, em particular, com a teoria elementar de números, que será o objeto destas notas. Parece claro que a noção de número natural desenvolveu-se gradativamente a partir da experiência cotidiana. Seu emprego foi-se generalizando aos poucos, e as propriedades das operações foram admitidas como um fato experimental.

Fato análogo aconteceu com a noção de racionais não-negativos, isto é, números da forma a/b em que a e b são números naturais, que surgiram ligados a problemas de grandezas geométricas.

O mesmo não aconteceu com os números inteiros negativos. O primeiro uso conhecido desses números encontra-se numa obra indiana, atribuída a #Brahmagupta (628 d.C. aproximadamente), na qual são interpretadas como dívidas.

Foi precisamente a possibilidade de dar diversas interpretações aos números negativos que fez com que eles fossem aceitos aos poucos na coletividade matemática. Porém, desde seu aparecimento, esses números suscitaram dúvidas quanto à sua legitimidade. Em 1543 #Stieffel ainda os chamava de números absurdos, e Cardano, contemporâneo de Stieffel, denominava-os soluções falsas de uma equação.

Foi o aparecimento dos números complexos, ligados a problemas de resolução de equações, mas sem uma interpretação empírica acessível, que levou a ciência europeia a refletir sobre a natureza dos números.

O primeiro a tentar dar à álgebra uma estrutura lógica comparável à geometria dos Elementos de Euclides foi o inglês Goerge Peacok que, no seu Treatise on Algebra, publicado em 1830 e ampliado a dois volumes em 1845, destacou pela primeira vez a importância das chamadas "leis formais", isto é, das propriedades das operações, marcando assim o início do pensamento axiomático em álgebra.

Atitude semelhante foi assumida por seu contemporâneo e amigo, Augusto de Morgan, na sua Trigonometry and Double Algebra, publicada também em 1830.

O processo histórico mostra que a realidade é diferente. No século XVIII, Leonhard Euler descobriu as famosas fórmulas que levam seu nome, relacionando exponenciais com números complexos, e Karl F. Gauss demonstrou o Teorema Fundamental da Álgebra, que afirma que toda equação polinomial com coeficientes reais admite pelo menos uma raiz complexa. Contudo, a primeira fundamentação precisa da noção de número complexo como par ordenado de números reais é atribuída a Sir William R. Hamilton e data de 1833.

## 1.2 Uma fundamentação axiomática
Os números inteiros foram um conjunto, que notaremos por ℤ, no qual estão definidas duas operações, que chamaremos de adição e multiplicação e denotaremos por + e * . Em ℤ também está definida uma relação que permite comparar os seus elementos, a relação "menor ou igual", que indicaremos por <=.

Os axiomas que passaremos a detalhar descreverão algumas das propriedades básicas das operações e da relação "menor ou igual", que tomaremos como base para desenvolver a teoria. Qualquer outra propriedade, mesmo que intuitivamente óbvia, poderá ser demonstrada a partir dessas. 

Observamos que em qualquer apresentação axiomática o começo tende a ser cansativo, precisamente por ser necessário demonstrar alguns fatos que são bem conhecidos. Tentamos poupar o leitor, na medida do possível, desse inevitável aborrecimento. Assim, nosso sistema de axiomas é superabundante, isto é, admitimos mais propriedades do que as estritamente necessárias, esperando tornar mais fluente a exposição. Para maiores detalhes, o leitor pode consultar os exercícios.

O primeiro grupo de axiomas descreverá algumas propriedades da soma que certamente são familiares ao leitor.

A.1 Propriedade #associativa: para toda terna a, b, c de inteiros tem-se que a + (b + c) = (a + b) + c.

A.2 Existência do Neutro: Existe um único elemento, denominado *neutro aditivo* ou *zero*, que indicaremos por 0, tal que a + 0 = a, para todo a 