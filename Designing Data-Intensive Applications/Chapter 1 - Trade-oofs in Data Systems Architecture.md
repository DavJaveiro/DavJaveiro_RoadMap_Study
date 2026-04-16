## Preface
Existem centenas de bancos de dados para escolher. Qual devemos usar em nossa aplicação? A resposta curta é: "Depende". A resposta longa é... este livro.

Diferentes tecnologias para armazenar e processar dados fazem diferentes *trade-offs*, e nenhuma abordagem é a melhor para todas as situações. O sistema que é perfeito para uma aplicação pode ser totalmente inadequado para outra. Este livro é um guia por todo o panorama dos **data systems**, não apenas analisando um produto, mas comparando os pontos fortes e fracos de muitos sistemas.

Embora o cenário de tecnologias para processar e armazenar dados seja diverso e mude rapidamente, os princípios subjacentes permanecem. Se entendermos estes princípios, estaremos em posição de enxergar onde cada ferramenta se encaixa, como usá-la bem e como evitar suas armadilhas. Este livro foca nesses princípios.

Veremos neste livro, muitos exemplos de **data systems** bem-sucedidos: tecnologias que formam a base de inúmeras aplicações populares e que precisam atender a requisitos de escalabilidade, desempenho e confiabilidade em produção todos os dias. Vamos mergulhar no funcionamento interno desses sistemas, separar seus principais algoritmos e discutir os **trade-offs** que eles fizeram. Nesse jornada, tentaremos encontrar maneiras úteis de pensar sobre **data systems**, não apenas como eles funcionam, mas também por que funcionam dessa forma.

Depois de ler este livro, você estará em ótima posição para determinar quais tipos de tecnologias são apropriados para quais propósitos e para entender como ferramentas podem ser combinadas para formar a base de uma arquitetura de aplicação sólida. Você desenvolverá uma forte intuição sobre o que seus sistemas estão fazendo nos bastidores, para que possa raciocinar sobre seu comportamento, tomar boas decisões de design e rastrear quaisquer problemas que possam surgir.

## Trade-offs in Data Systems Architecture
*"Não existem soluções; existem apenas **trade-offs. [...]** Mas tentamos conseguir o melhor **trade-off** que pudermos, e é tudo o que podemos esperar.* - Thomas Sowell, entrevista com Fred Barnes (2005).

