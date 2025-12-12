Machine Learning trata do design de algoritmos que automaticamente extraem informações valiosas a partir de dados. A ênfase aqui está em "automatic", ou seja, machine learning preocupa-se com metodologias de uso geral que podem ser aplicadas a muitos datasets, produzindo algo que seja significativo.

Existem três conceitos que estão no núcleo de machine learning: **data**, um **model** e **learning**. 

Como machine learning é inerentemente orientado por dados, **data** está no centro de machine learning. O objetivo de machine learning é projetar metodologias de uso geral para extrair padrões valiosos de **data**, idealmente sem muita expertise específica de domínio. Por exemplo, dado um grande corpus de documentos, métodos de machine learning podem ser usados para automaticamente encontrar tópicos relevantes que são compartilhados entre documentos. 

Para alcançar esse objetivo, projetamos models que normalmente estão relacionados ao processo que gera data, semelhante ao dataset que nos é fornecido. Por exemplo, em um cenário de regressão, o modelo descreveria uma função que mapeia entradas para saídas de valores reais. Parafraseando Mitchell (1997): um model é dito aprender a partir de data se sua performance em uma determinada tarefa melhora depois que os dados são considerados. O objetivo é encontrar bons modelos que generalizem bem para dados ainda não vistos, os quais podem nos interessar no futuro. O aprendizado pode ser entendido como uma forma de encontrar automaticamente padrões e estruturas nos dados por meio da otimização dos parâmetros do modelo.

Embora o aprendizado de máquina tenha registrado muitos casos de sucesso e exista software prontamente disponível para projetar e treinar sistemas de aprendizado de máquina ricos e flexíveis, acreditamos que os fundamentos matemáticos do aprendizado de máquina são importantes para compreender os princípios fundamentais sobre os quais sistemas mais complexos são construídos. Compreender esses princípios pode facilitar a criação de novas soluções de aprendizado de máquina, a compreensão e depuração de abordagens existentes, e o aprendizado sobre as suposições e limitações inerentes às metodologias com as quais trabalhamos.

## 1.1 Encontrando Palavras para Intuições
Um desafio que enfrentamos regularmente no aprendizado de máquina é que conceitos e palavras são escorregadios, e um componente específico do sistema de aprendizado de máquina pode ser abstraído

