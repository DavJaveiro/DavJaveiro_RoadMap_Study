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
>>>>>>> 0cfed6b65ee98d453d14e25a3520ba11122e5b03
