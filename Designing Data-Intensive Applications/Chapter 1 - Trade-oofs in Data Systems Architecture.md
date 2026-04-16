## Preface
Existem centenas de bancos de dados para escolher. Qual devemos usar em nossa aplicação? A resposta curta é: "Depende". A resposta longa é... este livro.

Diferentes tecnologias para armazenar e processar dados fazem diferentes *trade-offs*, e nenhuma abordagem é a melhor para todas as situações. O sistema que é perfeito para uma aplicação pode ser totalmente inadequado para outra. Este livro é um guia por todo o panorama dos **data systems**, não apenas analisando um produto, mas comparando os pontos fortes e fracos de muitos sistemas.

Embora o cenário de tecnologias para processar e armazenar dados seja diverso e mude rapidamente, os princípios subjacentes permanecem. Se entendermos estes princípios, estaremos em posição de enxergar onde cada ferramenta se encaixa, como usá-la bem e como evitar suas armadilhas. Este livro foca nesses princípios.

Veremos neste livro, muitos exemplos de **data systems** bem-sucedidos: tecnologias que formam a base de inúmeras aplicações populares e que precisam atender a requisitos de escalabilidade, desempenho e confiabilidade em produção todos os dias. Vamos mergulhar no funcionamento interno desses sistemas, separar seus principais algoritmos e discutir os **trade-offs** que eles fizeram. Nesse jornada, tentaremos encontrar maneiras úteis de pensar sobre **data systems**, não apenas como eles funcionam, mas também por que funcionam dessa forma.

Depois de ler este livro, você estará em ótima posição para determinar quais tipos de tecnologias são apropriados para quais propósitos e para entender como ferramentas podem ser combinadas para formar a base de uma arquitetura de aplicação sólida. Você desenvolverá uma forte intuição sobre o que seus sistemas estão fazendo nos bastidores, para que possa raciocinar sobre seu comportamento, tomar boas decisões de design e rastrear quaisquer problemas que possam surgir.

## Trade-offs in Data Systems Architecture
*"Não existem soluções; existem apenas **trade-offs. [...]** Mas tentamos conseguir o melhor **trade-off** que pudermos, e é tudo o que podemos esperar.* - Thomas Sowell, entrevista com Fred Barnes (2005).

Os dados são centrais para grande parte do desenvolvimento de aplicações hoje em dia. Com aplicações web e mobile, **software as as service (SaaS)** e serviços em nuvem, tornou-se normal armazenar dados de muitos usuários diferentes em uma infraestrutura de dados compartilhada baseada em servidor. Dados provenientes de atividade de usuários, transações comerciais, dispositivos e sensores precisam ser armazenados e disponibilizados para análise. Conforme os usuários interagem com uma aplicação, eles tanto leem os dados que estão armazenados quanto geram mais dados.

Pequenas quantidades de dados, que podem ser armazenadas e processadas em uma única máquina, costuma ser relativamente fáceis de gerenciar. No entanto, à medida que o volume de dados ou a taxa de consultas cresce, eles precisam ser distribuídos por múltiplas máquinas, o que introduz muitos desafios. Conforme as necessidades da aplicação se tornam mais complexas, não é mais suficiente armazenar tudo em um único sistema podendo ser necessário combinar múltiplos sistemas de armazenamento ou processamento que ofereçam diferentes capacidades.

Chamamos uma aplicação de **data-intensive** se o gerenciamento de dados for um dos principais desafios no desenvolvimento da aplicação. Enquanto em sistemas **compute-intensive** o desafio é paralelizar uma computação muito grande, em aplicações **data-intensive** geralmente <span style="background:#fff88f">nos preocupamos</span> mais com coisas como <span style="background:#d3f8b6">armazenar</span> e <span style="background:#d3f8b6">processar grandes volumes de dados</span>, gerenciar mudanças nos dados, <span style="background:#d3f8b6">garantir consistência</span> diante de falhas e concorrência, e assegurar que os serviços <span style="background:#d3f8b6">estejam altamente disponíveis</span>.

Essas aplicações são tipicamente construídas a partir de blocos de construção padrão que fornecem funcionalidades comumente necessárias. Por exemplo, muitas aplicações precisam fazer o seguinte:
- Armazenar dados para que eles, ou outra aplicação, possam encontrá-los novamente mais tarde (**database**);
- Lembrar o resultado de uma operação cara, para acelerar leituras ( #caches);
- Permitir que usuários busquem dados por palavra-chave ou os filtrem de várias maneiras ( #search-indexes);
- Lidar com eventos e mudanças nos dados assim que eles ocorrem ( #stream-processing);
- Processar periodicamente um grande volume de dados acumulados ( #batch-processing)

Ao construir uma aplicação, normalmente pegamos vários sistemas ou serviços de software, como #databases ou #APIs, e os integramos com código de aplicação. Se estivermos realizando exatamente aquilo para o qual os #data-systems foram projetados, esse processo pode ser bastante fácil.

No entanto, à medida que a nossa aplicação se torna mais ambiciosa, surgem desafios. Existem muitos sistemas de banco de dados com características diferentes, adequados para diferentes propósitos, como escolher qual usar? Existem várias abordagens para cache, diversas maneiras de construir índices de pesquisa e assim por diante — como você raciocina sobre os prós e contras de cada um? Você precisa descobrir quais ferramentas e quais abordagens são as mais apropriadas para a tarefa em questão, e pode ser difícil combinar ferramentas quando você precisa fazer algo que uma única ferramenta não consegue fazer sozinha.

Nenhuma abordagem é fundamentalmente melhor que as outras; tudo tem prós e contras. Com este livro, aprenderemos a fazer perguntas certas para avaliar e comparar sistemas de dados, para que possamos descobrir qual a abordagem atenderá melhor às necessidades da nossa aplicação específica.

Começaremos a nossa jornada analisando algumas das maneiras como os dados são tipicamente usados nas organizações hoje. Muitas das ideias aqui têm origem em software corporativo (ou seja, as necessidades de software e práticas de engenharia de grandes organizações, como grandes corporações e governos), já que historicamente apenas as grandes organizações tinham os grandes volumes de dados que exigiam soluções técnicas sofisticadas. Se o seu volume de dados for pequeno o suficiente, você pode simplesmente mantê-lo em uma planilha! No entanto, mais recentemente também se tornou comum que empresas menores e startups gerenciem grandes volumes de dados e construam sistemas com uso intensivo de dados.

Um dos principais desafios com sistemas de dados é que pessoas diferentes precisam fazer coisas muito diferentes com os dados. Se trabalhamos em uma empresa, eu e a minha equipe teremos um conjunto de prioridades, enquanto outra equipe pode ter objetivos totalmente diferentes, mesmo que estejamos trabalhando com o mesmo conjuntos de dados! Além disso, esses objetivos podem não ser articulados explicitamente, o que pode levar a mal-entendidos e discordâncias sobre a abordagem correta. 

---
 2. Insights Valiosos
- **Ecossistema Spring e a Facilidade de Integração:** O Spring Boot abstrai grande parte da complexidade de conectar diferentes fontes de dados. É muito simples adicionar o `spring-boot-starter-data-jpa` para um PostgreSQL e o `spring-boot-starter-data-redis` para cache no mesmo projeto. No entanto, essa facilidade técnica pode mascarar o custo arquitetural. O erro comum é introduzir tecnologias apenas porque o *framework* facilita, sem avaliar se o _trade-off_ operacional (manutenção, custo) se justifica.

Não existe bala de prata. Tudo tem prós e contras. O nosso trabalho como engenheiros não é buscar a tecnologia perfeita, mas sim fazer as perguntas certas para combinar as ferramentas que resolvem o problema atual do negócio. 

---
Para ajudá-lo a entender suas escolhas, este capítulo compara vários conceitos contrastantes e explora seus prós e contras (_trade-offs_). Consideraremos os seguintes tópicos:
- A diferença entre sistemas operacionais e analísticos ((“Sistemas Operacionais Versus Analíticos” na página 3));
- Os prós e contras de serviços em nuvem e sistemas auto-hospedados (“Nuvem Versus Auto-hospedagem” na página 12)
- Quando migrar de sistemas de nó único para sistemas distribuídos (“Sistemas Distribuídos Versus Sistemas de Nó Único” na página 19)
- Equilibrando as necessidades do negócio e os direitos do usuário (“Sistemas de Dados, Lei e Sociedade” na página 24)
Este capítulo também definirá as terminologias que iremos precisar para o restante do livro.

**Terminologia: Frontends e Backends**
