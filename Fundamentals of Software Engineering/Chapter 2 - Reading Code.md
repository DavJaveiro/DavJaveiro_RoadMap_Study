*Code is read much more often than it is written* - Guido Van Rossum, creator of Python

Apesar da forma como a programação é ensinada, engenheiros de software passam muito mais tempo lendo código do que escrevendo. Na maioria dos cursos introdutórios, pulamos imediatamente para a escrita, focando em conceitos centrais e idiomas da linguagem sem reconhecer que você nunca aprenderia polonês ou português de maneira semelhante. E embora a maioria dos projetos acadêmicos comece do zero, desenvolvedores atuantes estão quase sempre trabalhando dentro dos confins de um código que levou anos para chegar ao seu estado atual. 

Com o advento da programação baseada em agentes ou orientada a chat, a leitura de código se tornará ainda mais importante para engenheiros de software. Embora possa não ser nossa primeira escolha, provavelmente trabalharemos com código que não escrevemos. Anime-se, existem técnicas para nos ajudar a orienta-se quando nos depararmos com código desconhecido. Este capítulo abordará por que a leitura de código pode ser desafiadora e daremos algumas dicas para tornar o processo mais simples.

**O desafio de trabalhar com código existente** 
Independentemente de como aprendemos a programar, provavelmente passamos muito tempo no espaço abençoado conhecido como desenvolvimento *greefield*, onde vivenciamos o trabalho de começar do zero, sem o peso de trabalhos anteriores. No entanto, em nossa vida profissional, nós provavelmente teremos pouquíssimas oportunidades de construir uma aplicação a partir de um editor em branco. Como um engenheiro de software praticanete, grande parte do nosso tempo será gasto em desenvolvimento *brownfield*, trabalhando dentro dos limites de uma base de código existente, lidando diariamente com código legado. 

**Código Legado por qualquer outro nome...**
Ler código antigo é frequentemente uma tarefa que a maioria dos desenvolvedores prefere evitar. Costumamos usar o termo "código legado" para descrevê-lo,  e esse termo raramente é um elogio. Existem várias definições: código escrito ontem, código sem cobertura de testes adequada (ou com testes demais), ou apenas código que você não escreveu.

No entanto não devemos depreciar o sucesso de uma aplicação existente. Se um produto entregou valor de negócio por anos e justificou o investimento contínuo, isso merece reconhecimento. <span style="background:#affad1">Preferimos um termo mais positivo, como "código de herança" ou "código existente"</span>.

Ao ser solicitado a resolver um problema em código existente, você tem, na verdade, quatro problemas para resolver:
1. **Entender o problema de negócio:** os domínios são cada vez mais complexos;
2. **Ver o problema através dos olhos do desenvolvedor anterior:** cada um possui hábitos e estilos diferentes (ex.: estilo funcional vs. imperativo);
3. **Lidar com o nível de abstração:** o código pode ser genérico demais ou falhar em capturar as nuances do domínio;
4. **Arqueologia técnica:** descascar camadas de dívida técnica e padrões antigos. Podemos até fazer  a "datação por carbono" do código observando quais frameworks ou recursos da linguagem são usados. Frameworks como **Spring** evoluíram por anos, suportando múltiplas abordagens; o que é considerado "certo" muda com o tempo.

Somado a isso, há o desafio de lidar com "remendos sobre remendos", prazos apertados e, agora, códigos gerados por IA que podem criar milhares de linhas rapidamente. Trabalhar com código existente apresenta desafios técnicos e vieses cognitivos que tornam essa uma das tarefas menos favoritas dos desenvolvedores.

- **Trade-off: Refatoração vs. Valor de Negócio:** o texto destaca que o código legado é, muitas vezes, um sucesso comercial. O erro comum de seniores é propor *rebuilds* (reescrita do zero) ignorando que o "código de herança" já resolveu nuances de negócio que o novo código ainda não conhece. O foco deve ser em **Refatoração Oportunista**.

## Vieses Cognitivos
Ao ler código existente, podemos compará-lo desfavoravelmente ao nosso próprio trabalho. Obviamente, você não escreve código ruim, escreve? Em mais de uma ocasião, nós, seus humildes autores, tivemos dificuldade com algum código, proferindo variações menos educadas de "Que idiota escreveu isso?", apenas para descobrir  que fomos nós mesmos. E, francamente, se você ler um código que escreveu há alguns anos, deve ficar um pouco decepcionado, isso é um sinal de crescimento; você sabe mais hoje do que sabia na época. Isso é algo bom!

Você também tem alguns vieses cognitivos trabalhando contra você ao lidar com código existente. O primeiro é o **Efeito IKEA**, que ocorre quando você atribui um valor maior a coisas que você mesmo criou. Um estudo descobriu que as pessoas pagariam 63% a mais por um produto que elas mesmas montaram em comparação a um produto idêntico montado por outra pessoa. No software, desenvolvedores costumam ter opiniões fortes obre a maneira "certa" de fazer as coisas e tendem a preferir seu próprio código e abordagem.

Além disso, existe o **Efeito da Mera Exposição:** preferimos coisas com as quais já estamos familiarizados. Isso leva ao dogmatismo típico que muitos desenvolvedores têm em relação a linguagens de programação. Desenvolvedores tendem a pensar que o tempo começou com qualquer linguagem que aprenderam primeiro. Quando o Java introduziu as expressões Lambda, alguém em uma lista de discussão perguntou por que o Java precisava dessas "Lambdas modernas", sem perceber que Lambdas não são um conceito novo e faziam parte do plano original para o próprio Java!

Desenvolvedores podem ser provincianos em relação às suas ferramentas preferidas, algo que Paul Graham aborda em seu ensaio "Beating the Averages". https://www.oreilly.com/library/view/hackers-painters/0596006624/ch12.html. Graham diz que as linguagens de programação existem em um continuum de poder, mas muitas vezes você não consegue reconhecer por que uma linguagem é mais poderosa do que outra. Para demonstrar seu ponto, ele introduziu a hipotética linguagem "Blub" e um programador Blub produtivo. Quando o programador Blub olha para baixo no continuum de poder, tudo o que vê são linguagens que carecem de recursos que ele usa todos os dias. Quando olha para cima no continuum, tudo o que vê é um momento de recursos estranhos que ele não tem no Blub, e não conseguem imaginar por que alguém precisaria deles para ser produtivo.

## Abordando Código Desconhecido
Como você não pode gastar todo o seu tempo criando código novo, encontrará bases de código existentes ao longo da carreira. Como se atualizar sem perder a sanidade? Primeiro, comece com seus colegas. Uma visão geral do projeto deve fazer parte do onboarding. Passe algum tempo com a documentação: arquivos README, wikis e, crucialmente, ADRs (Architecture Decision Records). ADRs fornecem o contexto vital e o "porquê" das decisões, algo que desaparece na pressa de corrigir bugs. Ler os padrões de codificação do projeto o preparará para os padrões que encontrará. Se a documentação estiver desatualizada, atualize-a; se for inexistente, crie-a. Use testes como documentação executiva estilo BDD.

**Métricas Podem Enganar**
A cobertura de código pode ser útil, mas não é uma bala de prata. É possível falhar mesmo com 100% de cobertura. Uma colega descobriu um projeto com 92% de cobertura, mas que sofria regressões constantes. Ao analisar, notou que os testes não tinham #asserts. A lição é: cuidado com métricas, elas podem enganar se forem tratadas apenas como cerimônia.

## Software Archeology
Depois de consultar a equipe e familiarizar-se com a documentação existente, é hora de abrir seu editor de preferência e praticar um pouco de arqueologia de software. Arregace as mangas e vasculhe a base de código! Para parafrasear Sir Isaac Newton, procure por seixos mais lisos e conchas mais bonitas. Observe a estrutura do código, como ele está organizado? Algumas linguagens possuem construtos de primeira classe para empacotamento; outras dependem de convenções. Como o código se encaixa? Trata-se de um monólito ou de uma arquitetura distribuída com dezenas ou centenas de serviços? Quais conceitos de domínio estão expressos no código? Leia os testes, o que eles dizem sobre a funcionalidade? Com essas informações, você entende a intenção deste classe?

Se a intenção não estiver clara, aprofunde-se. Editores modernos tornam trivialmente simples ver quem chama uma determinada função, permitindo que você faça o caminho inverso. Os chamadores (*callers*) devem ajudá-lo a determinar o que uma classe faz e como é usada. Seu rastreamento pode levá-lo até um *endpoint* de serviços, como uma chamada HTTP, mas eventualmente você encontrará a conexão entre uma ação do usuário e o código.

Assim que se localizar, execute a aplicação. O que ela faz? Encontre um elemento específico, seja na interface do usuário ou um parâmetro em uma chamada de serviço, e mapeie-o de volta para o código. Olhe para a lista de problemas (*issue list*); veja se focar em uma única funcionalidade ou bug permite que você siga o caminho da codificação. Procure por um ponto de referência; se você sabe que uma ação resulta em uma atualização no banco de dados, encontre isso no código. Use seu *debugger* para percorrer o código, ele funcionou da maneira que você previu? Você acabou em um caminho de código vastamente diferente? No fim das contas, você está construindo um modelo mental do código; está carregando a aplicação em seu cérebro. 

## O Exemplo do Spring PetClinic
Ao clonarmos e rodarmos a aplicação, veremos que ela permite buscar proprietários. Se explorarmos os templates, veremos um chamado *findOwners.html*, que referencia um *endpoint* */owners*. Buscar no projeto por */owners* retorna vários resultados, mas a intuição o levará à anotação *@GetMapping("/owners")* no método *processFindForm* no arquivo *OwnerController*. Coloque um breakpoint, execute a busca e veja o que acontece.

Não devemos presumir o que o código faz; nomes de variáveis e métodos podem não refletir mais a realidade à medida que o código evolui. 

Devemos tomar cuidado com as exceções: elas podem enganar. Capturar exceções de alto nível (genéricas) tende a ofuscar problemas reais. 

Devemos olhar o histórico de alterações: o que muda com frequência? O comando git log pode mostrar as classes mais modificadas, os "hotspots". Ferramentas como *git blame* ajudam a visualizar quem fez as mudanças mais recentes. 

