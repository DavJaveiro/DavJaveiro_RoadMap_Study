Machine Learning trata do design de algoritmos que automaticamente extraem informações valiosas a partir de dados. A ênfase aqui está em "automatic", ou seja, machine learning preocupa-se com metodologias de uso geral que podem ser aplicadas a muitos datasets, produzindo algo que seja significativo.

Existem três conceitos que estão no núcleo de machine learning: **data**, um **model** e **learning**. 

Como machine learning é inerentemente orientado por dados, **data** está no centro de machine learning. O objetivo de machine learning é projetar metodologias de uso geral para extrair padrões valiosos de **data**, idealmente sem muita expertise específica de domínio. Por exemplo, dado um grande corpus de documentos, métodos de machine learning podem ser usados para automaticamente encontrar tópicos relevantes que são compartilhados entre documentos. 

Para alcançar esse objetivo, projetamos models que normalmente estão relacionados ao processo que gera data, semelhante ao dataset que nos é fornecido. Por exemplo, em um cenário de regressão, o modelo descreveria uma função que mapeia entradas para saídas de valores reais. Parafraseando Mitchell (1997): um model é dito aprender a partir de data se sua performance em uma determinada tarefa melhora depois que os dados são considerados. O objetivo é encontrar bons modelos que generalizem bem para dados ainda não vistos, os quais podem nos interessar no futuro. O aprendizado pode ser entendido como uma forma de encontrar automaticamente padrões e estruturas nos dados por meio da otimização dos parâmetros do modelo.

Embora o aprendizado de máquina tenha registrado muitos casos de sucesso e exista software prontamente disponível para projetar e treinar sistemas de aprendizado de máquina ricos e flexíveis, acreditamos que os fundamentos matemáticos do aprendizado de máquina são importantes para compreender os princípios fundamentais sobre os quais sistemas mais complexos são construídos. Compreender esses princípios pode facilitar a criação de novas soluções de aprendizado de máquina, a compreensão e depuração de abordagens existentes, e o aprendizado sobre as suposições e limitações inerentes às metodologias com as quais trabalhamos.

## 1.1 Encontrando Palavras para Intuições
Um desafio que enfrentamos regularmente no aprendizado de máquina é que conceitos e palavras são escorregadios, e um componente específico do sistema de aprendizado de máquina pode ser abstraído para diferentes conceitos matemáticos. Por exemplo, a palavra algoritmo é usada em pelo menos dois sentidos diferentes no contexto do aprendizado de máquina.

No **primeiro sentido**, usamos a expressão "algoritmo de aprendizado de máquina" para nos referirmos a um sistema que faz previsões com base em dados de entrada. Referimo-nos a esses algoritmos como **preditores**. 

No **segundo sentido**, usamos exatamente a mesma expressão "algoritmo de aprendizado de máquina" para nos referirmos a um sistema que adapta alguns parâmetros internos do preditor para que ele tenha um bom desempenho em dados de entrada futuros e não vistos. Aqui, referimo-nos a essa adaptação como treinamento de um sistema. 

Esse livro não resolverá a questão da ambiguidade, mas queremos destacar desde já que, dependendo do contexto, as mesmas expressões podem significar coisas diferentes. No entanto, tentaremos tornar o contexto suficientemente claro para reduzir o nível de ambiguidade.

A **primeira parte** deste livro introduz os conceitos e fundamentos matemáticos necessários para discutir os três componentes principais de um sistema de aprendizado de máquina: **dados**, **modelos** e **aprendizado**. Vamos esboçar brevemente esses componentes aqui, e revisitá-los novamente no Capítulo 8, uma vez que tenhamos discutidos os conceitos matemáticos necessários. 

<<<<<<< HEAD
Embora nem todos os dados sejam numéricos, muitas vezes é útil considerar os dados em formato numérico. Vamos considerar que os dados já foram devidamente convertidos para uma representação numérica adequada para leitura em um programa. Pensaremos nos dados como vetores, existem (pelo menos) três maneiras diferentes de pensar sobre vetores:
1. um vetor como um **array de números** (visão da ciência da computação);
2. um vetor como uma **seta com direção e magnitude** (visão da física);
3. e um vetor como um **objeto que obedece às operações de adição e multiplicação por escalar** (visão matemática).

**Modelo**
Um modelo é tipicamente usado para descrever um processo de geração de dados, semelhante ao conjunto de dados em questão. Um bom modelo pode ser usado para prever o que aconteceria no mundo real sem realizar experimentos reais. 

**Learning (aprendizado)**
Recebemos um conjunto de dados e um modelo adequado. Treinar o modelo significa usar os dados disponíveis para otimizar alguns parâmetros do modelo, com respeito a uma função de utilidade que avalia quão bem o modelo prevê os dados de treinamento. Na prática, estamos interessados em que o modelo tenha um bom desempenho em **dados não vistos**. Ir bem apenas nos dados que já vimos (dados de treinamento) pode significar apenas que encontramos uma boa maneira de memorizar os dados. Porém, isso pode não se generalizar bem para dados desconhecidos, e, em aplicações práticas, frequentemente precisamos expor nosso sistema de *machine learning* a situações que ele ainda não encontrou. 

**Vamos resumir os principais conceitos de machine learning que abordamos neste livro:**
- Representamos os dados como vetores;
- Escolhemos um modelo apropriado, usando a abordagem probabilística ou a abordagem de otimização;
- Aprendemos a partir dos dados disponíveis usando métodos de otimização numérica, com o objetivo de que o modelo tenha um bom desempenho em dados que **não** foram usados no treinamento.
=======
Embora nem todos os dados sejam numéricos, muitas vezes é útil considerar os dados em formato numérico. 

**Elementos de $\mathbb{R}^n$ (tuplas de $n$ números reais) são vetores.** O espaço $\mathbb{R}^n$ é mais abstrato que os polinômios, e é o conceito no qual focamos neste livro. Por exemplo, $$\mathbf{a} = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix} \in \mathbb{R}^3$$

é um exemplo de uma tripla de números. Somar dois vetores $\mathbf{a}, \mathbf{b} \in \mathbb{R}^n$ componente a componente resulta em outro vetor: $\mathbf{a} + \mathbf{b} = \mathbf{c} \in \mathbb{R}^n$. Além disso, multiplicar $\mathbf{a} \in \mathbb{R}^n$ por $\lambda \in \mathbb{R}$ resulta em um vetor escalado $\lambda \mathbf{a} \in \mathbb{R}^n$.

*Insight:* Rn padroniza a abstração. Ao convertermos problemas (sejam físicos, econômicos ou sociais) em listas ordenadas de números, criamos uma linguagem universal que permite aplicar as mesmas ferramentas matemáticas a fenômenos completamente distintos.

**$\mathbb{R}^n$ e Espaços de Dimensão Finita**
A álgebra linear concentra-se nas semelhanças entre esses conceitos vetoriais. Podemos somá-los e multiplicá-los por escalares. Focaremos principalmente em vetores no espaço $\mathbb{R}^n$, uma vez que a maioria dos algoritmos de álgebra linear é formulada nele. Veremos no Capítulo 8 que frequentemente consideramos dados como representações de vetores em $\mathbb{R}^n$. Neste livro, o foco será em espaços vetoriais de dimensão finita, nos quais existe uma correspondência de 1 para 1 entre qualquer tipo de vetor e o $\mathbb{R}^n$. Quando for conveniente, utilizaremos intuições sobre vetores geométricos e consideraremos algoritmos baseados em _arrays_.

**O conceito de Fechamento (Closure)**
Qual é o conjunto de todos os objetos que podem resultar das minhas operações propostas? No caso dos vetores, qual é o conjunto de vetores resultante ao iniciarmos com um pequeno conjunto de vetores e os somarmos e escalarmos entre si? Isso resulta em um espaço vetorial (Seção 2.4). O conceito de espaço vetorial e suas propriedades fundamentam grande parte do aprendizado de máquina *machine learning*. Os conceitos introduzidos neste capítulo estão resumido na Figura 2.2.

*O fechamento define o tabuleiro do jogo. Se as operações (soma/escala) nunca criam algo fora do conjunto, o sistema é estável e previsível, permitindo a construção de estruturas complexas como subespaços e bases.*

Em matemática, **fechamento** significa:
>Se eu aplico certas operações a elementos de um conjunto, o resultado continua pertencendo a esse mesmo conjunto.

Normalmente:
- Um conjunto é **fechado** em relação a uma operação;
- Ao aplicarmos a operação, não saímos do conjunto.

- **Espaço vetorial gerado (ou span)**
Começamos com alguns vetores, aplicamos as operações entre eles, soma e multiplicação por escalar quantas vezes necessárias, <span style="background:#affad1">todos os resultados possíveis continuam sendo vetores do mesmo espaço</span>. Isso vai garantir que as operações sejam bem definidas. Portanto, as operações não quebram a estrutura matemática. Sem o fechamento (closure), não conseguimos construir a teoria. 

Em *machine learning*, os dados são representados como **vetores**, parâmetros são **vetores ou matrizes**, os modelos fazem combinações lineares, produtos matriciais, gradientes etc. Isso permite que a saída de uma operação possa ser a entrada da próxima, permite que algoritmos interativos (gradientes descendente) façam sentido. **Sem o fechamento**, o modelo deixaria de ser bem definido.  

>Dado um conjunto de objetos e um conjunto de operações, o fechamento garante que os resultados dessas operações permaneçam dentro do mesmo conjunto, preservando a estrutura matemática necessária para modelagem, análise e aprendizado.

!![image-202512133132170.png](/image-202512133132170.png)

**Sistema de Equações Lineares**
Os sistemas de equações lineares desempenham um papel central na álgebra linear. Muitos problemas podem ser formulados como sistemas de equações lineares, e a álgebra linear nos fornece as ferramentas para resolvê-los. 

*A essência da engenharia e da ciência de dados é a modelagem. A álgebra linear converte problemas complexos do mundo real em sistemas padronizados que computadores possam resolver eficientemente.*

Considere uma empresa que fabrica os produtos $N_1, \dots, N_n$, para os quais são necessários os recursos $R_1, \dots, R_m$. Para produzir uma unidade do produto $N_j$, são necessárias $a_{ij}$ unidades do recurso $R_i$, onde $i = 1, \dots, m$ e $j = 1, \dots, n$.

O objetivo é encontrar um plano de produção ideal, isto é, um plano que defina quantas unidades $x_{j}$ do produto $N_{j}$ devem ser fabricadas, dado que existe um total de $b_{i}$ unidades do recurso $R_{i}$ disponíveis e (idealmente) nenhum recurso deve sobrar. 

Se produzirmos $x_1, \dots, x_n$ unidades dos produtos correspondentes, precisaremos de um total de:

$$a_{i1}x_1 + \dots + a_{in}x_n \quad (2.2)$$
unidades de recurso $R_{i}$. 

Portanto, um plano de produção ideal $(x_1, \dots, x_n) \in \mathbb{R}^n$ deve satisfazer o seguinte sistema de equações:
$$\begin{matrix} a_{11}x_1 + \dots + a_{1n}x_n = b_1 \\ \vdots \\ a_{m1}x_1 + \dots + a_{mn}x_n = b_m \end{matrix} \quad (2.3)$$

onde $a_{ij} \in \mathbb{R}$ e $b_i \in \mathbb{R}$.

*Estrutura Ax=b. O lado esquerdo é o consumo planejado (matriz de coeficientes x vetor de decisão), e o lado direito é a restrição física (vetor de disponibilidade).*

A Equação (2.3) representa a forma geral de um sistema de equações lineares, e $x_1, \dots, x_n$ são as incógnitas desse sistema. Cada $n$-upla $(x_1, \dots, x_n) \in \mathbb{R}^n$ que satisfaz (2.3) é considerada uma solução do sistema de equações lineares.

*É vital distinguir o espaço de busca ($\mathbb{R}^n$, todas as combinações possíveis) do conjunto solução (apenas as combinações que satisfazem todas as restrições simultaneamente). Resolver o sistema é filtrar o $\mathbb{R}^n$* .

Podemos nos perguntar, com base no insight:
>"Qual é o espaço de busca do problema, quais são as restrições e qual é a geometria do conjunto solução?"

Espaço de busca (ℝⁿ) inclui todas as combinações possíveis de parâmetros, isso incluirá todas as soluções mesmo as boas, ruins, absurdas e as instáveis, é um conjunto muito grande (que cresce de forma exponencial). 

**Conjunto Solução (subconjunto restrito de R^n)**
Considera apenas os pontos que satisfazem todas as restrições, dados + modelo + função de custo. E, quando resolvemos o sistema, buscamos **reduzir dimensionalmente o caos**.

O sistema de equações lineares
$$\begin{aligned} x_1 + x_2 + x_3 &= 3 \quad (1) \\ x_1 - x_2 + 2x_3 &= 2 \quad (2) \\ 2x_1 + 3x_3 &= 1 \quad (3) \end{aligned} \quad (2.4)$$
não possui solução: somar as duas primeiras equações resulta em $2x_1 + 3x_3 = 5$, contradizendo diretamente a terceira equação (3), que afirma que essa soma deve ser igual a 1. 

*Geometricamente, cada equação é um plano. Uma contradição algébrica (como 5 = 1) indica que não há nenhum ponto onde todos os planos se cruzam. O sistema é impossível ou incosistente.*

Vamos analisar o sistema de equações lineares:

$$\begin{aligned} x_1 + x_2 + x_3 &= 3 \quad (1) \\ x_1 - x_2 + 2x_3 &= 2 \quad (2) \\ x_2 + x_3 &= 2 \quad (3) \end{aligned} \quad (2.5)$$

Das equações (1) e (3), segue-se que $x_1 = 1$ (substituindo $x_2+x_3=2$ na primeira). De $(1)+(2)$, obtemos $2x_1 + 3x_3 = 5$; substituindo $x_1$, temos $2(1) + 3x_3 = 5$, logo $x_3 = 1$. Da equação (3), obtemos então que $x_2 = 1$. Portanto, $(1, 1, 1)$ é a única solução possível e exclusiva (verifique que $(1, 1, 1)$ é uma solução substituindo os valores).

Como terceiro exemplo, consideramos:
$$\begin{aligned} x_1 + x_2 + x_3 &= 3 \quad (1) \\ x_1 - x_2 + 2x_3 &= 2 \quad (2) \\ 2x_1 + 3x_3 &= 5 \quad (3) \end{aligned} \quad (2.6)$$
Visto que (1) + (2) = (3), podemos omitir a terceira equação *(redundância)*. Das equações (1) e (2), obtemos $2x_1 = 5 - 3x_3$ e $2x_2 = 1 + x_3$. Definimos $x_3 = a \in \mathbb{R}$ como uma variável livre, de modo que qualquer tripla:
$$\left( \frac{5}{2} - \frac{3}{2}a, \quad \frac{1}{2} + \frac{1}{2}a, \quad a \right), \quad a \in \mathbb{R} \quad (2.7)$$

é uma solução.

*A redundância significa que uma restrição não adiciona nova informação (é dependente). Isso cria graus de liberdade. A solução não é um ponto, mas uma reta inteira através do espaço 3D, parametrizada por a.*

Em geral, para um sistema de equações lineares com valores reais, obtemos **nenhuma, exatamente uma ou infinitas** soluções. A regressão linear resolve uma versão do Exemplo 2.1 para os casos em que não conseguimos resolver o sistema de equações lineares (isto é, quando não há solução exata).

>*Insight:* Aqui está a ponte para a Ciência de Dados: na vida real, dados raramente se alinham perfeitamente (Ax=b não tem solução). A Regressão Linear não busca a perfeição, mas a "melhor aproximação possível" (minimizar o erro).

**Observação**, em um sistema de equações lineares com duas variáveis x1 e x2, cada equação linear define uma reta no plano x1x2/ 