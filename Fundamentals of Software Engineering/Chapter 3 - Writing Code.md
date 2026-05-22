*Any fool can write code that a computer can understand. Good programmers write code that humans can understand.* Martin Fowler.

As nuances de escrever um bom código, quase nunca é ensinado.  Para sermos bom em revisar código, devemos ser bom em escrevê-lo. Escrever código limpo e de qualidade é uma habilidade inestimável no mundo da IA.

No fim das contas, o código deve ser escrito para ser lido por humanos.

A programação é uma atividade de comunicação, e não apenas entre o programador e o compilador. O computador entende qualquer código sintaticamente correto, mas isso não garante que um humano seguirá sua intenção. <span style="background:#d3f8b6">Os melhores engenheiros focam em código conciso, organizado e que comunique clareza, facilitando a manutenção a longo prazo.</span>

**Não reivente a roda:** antes de começarmos a digitar linhas de código, devemos verificar se o problema já foi resolvido. Desenvolvedores costumam escrever código demais. Devemos procurar por bibliotecas, além de verificarmos se as nossas dependências seguem as políticas da nossa organização. Verifiquemos os recursos da nossa linguagem de programação; linguagens evoluem e cinco minutos de busca podem poupar horas de esforço.

Árvore de decisão para evitar trabalho desnecessário (Christopher M.):
1. Isso já está sendo feito em algum lugar da base de código atual?
2. O JDK já faz isso?
3. Existem projetos Spring Framework ou Spring Boot que resolvem isso?
4. Existe uma solução no Google Guava? https://github.com/google/guava
5. Existe uma solução no **Apache Commons?**
6. Já existem outras bibliotecas no projeto que resolvam isso?
7. Existem bibliotecas *open source* que resolvam isso?

Se a resposta for "não" para todas, escreva o código com testes. Se for "sim", aproveite o que já existe. As melhores práticas hoje, podem ser o *anti-patterns* de amanhã. O software evoluí rápido; mantenha uma perspectiva aberta e questione o *status quo*.

*Insights valiosos*
- **Engenheiro como Curador e Revisor:** em 2026, a produtividade não é medida por linhas de código, mas pela capacidade de **curadoria**. O trade-off aqui é velocidade vs. segurança: IAs geram código rápido, mas podem introduzir vulnerabilidades sutis ou alucinações arquiteturais. O domínio de **Clean Code** é o que permite ao revisor identificar se o código gerado segue os padrões de segurança e manutenibilidade da empresa.
- Adicionar código customizado onde uma biblioteca padrão resolveria aumenta a superfície de ataque e o custo de manutenção. Em arquiteturas **Cloud-native**, cada linha de código próprio é um ativo que precisar ser testado, escaneado e atualizado.
- **Trade-off de Bibliotecas em Microsserviços:** ao seguir a árvore de decisão, um arquiteto deve considerar o impacto no tamanho da imagem do container e no tempo de inicialização (Cold Start). Usar o Google Guava apenas para uma função simples em uma AWS Lambda pode ser ineficiente; devemos dar preferência para recursos nativos do **Java 21/25**.

*Desatualizado*
- **Dependência Crítica de Guava e Apache Commons:** com o lançamento do Java 21 e as evoluções no Java 25, muitas funções do Guava e Commons (como manipulações de coleções, strings e I/O) agora são nativas e mais performáticas via **Records, Sealed Classes e novas APIs de Stream.** O uso dessas bibliotecas externas hoje deve ser a exceção, não a regra, para reduzir o grafo de dependências (*Supply Chain Security*).
- **Code Review focado em Sintaxe:** revisões manuais focadas em estilo de código estão obsoletas. Em 2026, ferramentas de **AI-driven Linting** e **Static Analysis** integradas ao CI/CD cuidam da "limpeza", deixando para o humano a análise de **trade-offs arquiteturais**, consistência de estado e lógica de negócio.

## What is Good Code?
**O que é um bom código?** Nem sempre encontraremos biblioteca ou um recurso de linguagem para resolver o nosso problema. Teremos que escrever código! E podemos perguntar: afinal, o que é um bom código? 

Potter Stewart, um bom código pode ser difícil de definir, mas o reconheceremos quando o ver. Com o tempo, passamos a identificar o código ruim e ele parece até ter um cheiro *code smell*. 

Métodos excessivamente longos são geralmente algo ruim, mas ainda sim precisamos examinar o código; pode não existir uma abordagem tão simples.

Métricas podem fornecer insights sobre nossa base de código. Por exemplo, a **complexidade ciclomática** pode indicar o número de caminhos dentro do nosso código-fonte, com mais caminhos indicando um código mais complexo que provavelmente se beneficiaria de refatoração. Muitas linguagens possuem analisadores de código-fonte como #PMD, #SonarQube e #JSHint, que ajudam a evitar que certos tipos de bugs e más práticas infestem o código. Ferramentas como #SonarQube e CodeSense fornecem *insights* valiosos. Provavelmente nossa organização já possui algo; se não tivermos, <span style="background:#affad1">podemos liderar o esforço para trazer uma para o nosso projeto</span>.

**Adicionando Métricas a Projetos Existentes**
Em um mundo perfeito, o nosso projeto utilizaria ferramentas de análise desde o início, permitindo que o código "comece limpo e permaneça limpo". No entanto, nem sempre teremos esse luxo e precisaremos adicionar um *linter* ou analisador a um projeto em desenvolvimento há meses ou anos. É tentador ativar todas as regras de uma vez! Não faça isso. Primeiro, algumas regras se contradizem. Segundo, o excesso de alertas resulta em um número ingerível de avisos, o que é contraproducente e desmoralizante para o time. 

Devemos discutir com a equipe a escolha de regras em que todos concordem. Ative-as e trabalhem para corrigi-las. Uma vez feito, ative mais algumas. Repita o processo. **Em alguns meses, teremos um conjunto de regras em um código mais limpo**. Regras nunca devem ser seguidas cegamente; algumas complexidades são inevitáveis. Use o **Efeito Hawthorne:** as pessoas modificam seu comportamento quando estão sendo observadas. Se você quer mais coberturas de testes, exiba as estatísticas de cobertura de forma proeminente. 

**Aumentando a Cobertura de Código através de Métricas**
Anos atrás, entrei em um projeto com testes que eram ignorados porque "sempre falhavam". Métricas podem ser abusadas. Só porque algo pode ser medido, não significa que trará *insights* significativos. Forque na tendência das métricas: está melhorando ou piorando com o tempo?

## Less Is More
*The goal of software design is to create chunks or slices that fit into a human mind. The software keeps growing, but the human mind maxes out, so we have to keep chunking and slicing differently if we want to keep making changes.* - Kent Beck

Como o tamanho de algumas bases de código, podemos pensar que os desenvolvedores são pagos por caractere. Embora alguns problemas realmente exijam milhões de linhas para serem resolvidos, na maioria dos casos, devemos preferir bases de código menores. <span style="background:#d3f8b6">Quanto menor o código, menor será a quantidade de código a ser carregada no cérebro das pessoas</span>. Muitos projetos chegam a um tamanho em que não é mais possível para um desenvolvedor entender todo o código, o que é uma das forças que deram origem aos #microsserviços e às funções como serviço, #FaaS. 

As grandes bolas de lama típicas geralmente têm guias de introdução do tamanho de um dicionário e processos de compilação que são medidos por semanas e revoluções da lua. Quanto menor for a base de código, menos tempo será necessário para que um novo desenvolvedor se familiarize com o código e mais rapidamente ele poderá começar a contribuir; consulte o Capítulo 6 para obter mais detalhes. 

### The Zeroth Law of Computer Science
Muitas das práticas adotadas pelos engenheiros de software em um esforço para domar o código se resumem à lei zero da ciência da computação: alta coesão, baixo acoplamento. A coesão é uma medida de como as coisas se relacionam umas com as outras. Alta coesão significa essencialmente que coisas semelhantes estão juntas. A função de notificação que também contém lógica de impressão seria um exemplo de baixa coesão. O acoplamento refere-se à quantidade de interdependência entre módulos ou rotinas. (Código fortemente acoplado), o código com forte acoplamento pode ser difícil de modificar,<span style="background:#affad1"> pois as alterações em uma parte do código afetam inesperadamente outras partes do sistema</span>, aparentemente não relacionadas. A alteração do serviço de notificação não deve interromper o módulo de impressão. 

A alta coesão e o baixo acoplamento tendem a resultar em um código mais legível e mais simples de manter e evoluir. Muitos padrões são formas de obter alta coesão e baixo acoplamento, geralmente em diferentes níveis de abstração. Em sua melhor forma, sem dúvida, os microsserviços são de alta coesão e baixo acoplamento aplicados aos serviços.

### Beware Boilerplate Code
O código boilerplate, mesmo que seja gerado por um editor ou uma estrutura, deve ser evitado. Embora não seja necessário escrevê-lo, ainda o carregaremos durante toda a vida útil do projeto. As classes devem ser curtas, com algumas páginas ou menos. As linguagens de programação afetarão nossa definição de curto, pois algumas linguagens são mais prolixas do que outras. 

## Favor Composition over Inheritance
Muitas linguagens permitem que as classes herdem de outras classes e, embora esse recurso possa ser muito poderoso e certamente exista uma relação no software, ele tende a ser usado em excesso. Alguns desenvolvedores usam a herança como um mecanismo de reutilização. A reutilização é um subproduto, não uma lógica!

Digamos que o nosso domínio envolva carros e caminhões. Podemos criar uma superclasse de veículo da qual carros e caminhões descendem e que inclui um motor de combustão, como todos os carros e caminhões têm um motor de combustão (desde que não seja um carro elétrico), definir o motor na superclasse garante que todos os carros e caminhões também tenham um moto de combustão. 

```ruby
class Vehicle {
	Engine engine
	Integer num_wheels
	Integer num_doors
	Function brake {}
	Function accelerate {}
}

Class Truck  < Vehicle {
	Number tow_capacity
}


Class ElectricVehicle < Vehicle {
	Number range
	# wait... EVs don't have engines...
}
```
Surgiram os veículos elétricos, sem nenhum motor de combustão. Um EV é um veículo, mas não como os outros veículos. A #composição <span style="background:#affad1">é mais flexível e deve ser preferida à herança.</span> Isso não quer dizer que nunca devamos utilizar herança, apenas que devemos preferir a composição. Quando implementamos motor, não precisamos saber como criar um motor, apenas como usá-lo, em composição. Para testabilidade fica mais fácil, ou seja, criar os #mocks ou #stubs em testes unitários.

## Favor Short Methods
Os métodos devem fazer uma coisa e somente uma coisa, e devem fazê-la bem, trabalhando em conjunto para atingir objetivos maiores. Qualquer nome de método que inclua conjunções (e, ou, mas) é um sinal de que o método está fazendo coisas demais. Os nomes dos métodos devem ser claros e concisos e não devem ser inteligentes. 

Em geral, devemos buscar bases de código menores e mais gerenciáveis para melhorar a compreensão e a produtividade do desenvolvedor.

### Write Code to Be Read
Algum desenvolvedor seguira os nossos passos, ele precisará ler o nosso código. Como poderíamos escrever o código para melhorar a vida do desenvolvedor que o lê? Existem diversas diretrizes que podemos aplicar quando se trata do comprimento correto de uma função, até a escolha do número de linhas arbitrárias. 

Martin Fowler oferece um conselho sábio: preste a atenção na separação entre intenção e implementação. 

Quanto tempo levamos para entender o que uma função está fazendo? Devemos conseguir entender o que a função faz, apenas lendo o seu nome, sem a necessidade de investigar o método a fundo. 

Devemos tornar as intenções claras, isso por si, tenderá a reduzir o tamanho da função. 

A classe fornecerá um contexto geral, e os nomes dos métodos vão dizer exatamente o que a classe faz.


**Nomear Coisas é Difícil**
Todo desenvolvedor fica lutando quando precisa nomear uma variável, um método ou uma classe. Criar nomes significativos pode consumir tempo. Não tenha pressa, leve o tempo que for necessário agora, para economizar tempo futuramente. Vale o esforço para criar bons nomes. Às vezes, ao explicar o que estamos fazendo, pode ser o suficiente para inspirar o apelido/nome perfeito para a nossa classe ou método.

Não hesite em refatorar código mal nomeado. 

Quando estamos trabalhando inicialmente no domínio, podemos inventar uma palavra e depois de fazer algumas análises adicionais, podemos ir em frente e substituir o nonsense por palavras reais. É provável que tenhamos chegado a algo muito diferente e mais claro do que a nossa primeira reação. 

### The problem with Code Comments
Comentar código liberalmente é um *code smell*. Comentários de código violam o princípio #DRY (Don't Repeat Yourself - Não se repita).

Enquanto veremos frequentemente o DRY sendo violado com código copiado e colado ou repleto de duplicação de lógica, os comentários também podem ser problemáticos. Na maioria dos casos, escrevemos o código e depois escrevemos novamente sobre o código. 

Atualizamos o código, temos tempo para atualizar o comentário também?

Os comentários podem frequentemente adicionar outra camada de "sedimento" aos desenvolvedores que encontram o código meses ou anos depois.

O código deve ser escrito para ser legível. O nosso tempo é mais bem gasto tornando o código o mais simples de ler do que o documentando. 

Linguagens mais expressivas definitivamente ajudam a alcançar um código legível, e podemos querer evitar os recursos mais sutis e "mágicos" da linguagem de nossa escolha. Bons nomes de métodos e variáveis são melhores do que comentários; 

Antes de escrevermos um comentário, a recomendação é que se tente renomear o método ou uma variável, fazer isso constantemente elimina a necessidade de um comentário.

Podemos usar comentários para explicar o motivo daquele uso e não o que fizemos. Com isso, quando estamos diante de uma situação onde não ficou tão claro os nossos objetivos, ou que não conseguimos transformar a ideia em um código tão óbvio com relação as nossas intenções, o comentário pode servir de ajuda em um momento futuro.

Resumindo: se o código precisa ser explicado, reescreva-o.

Comentários podem servir como lembretes para nossos futuros eus, ou como um aviso de que uma solução alternativa funciona, mas não entendemos (ainda) por que funciona. 

Alguns desenvolvedores deixam comentários como avisos para desenvolvedores futuros, como no exemplo a seguir:
```js
// Querido mantenedor:
//
// Quando você terminar de tentar
// "otimizar" esta rotina,
// e tiver percebido que erro terrível
// isso foi,
// por favor, incremente o seguinte
// contador como um aviso
// para a próxima pessoa:
//
// total_horas_despedicadas_aqui = 42
```

### Tests as Documentation
Ao invés de usarmos comentários, o correto é escrevermos testes. Testes, especialmente aqueles escritos em estilos mais fluidos, são especificações executáveis que evoluem junto com o código de produção. 

As documentações, sejam comentários de código, READMEs ou especificações, tende a divergir do código assim que é escrita. Testes escritos enquanto a gente escreve o código permite que refatoremos livremente e aumentemos a confiança na qualidade de nossa aplicação. Eles também atuam como sinalizações para os desenvolvedores que nos seguem. 

Adicionar testes a código existente permite que capturemos o que estamos aprendendo sobre como o código funciona e desbloqueia o nosso conhecimento de forma que outros desenvolvedores possam se beneficiar o nosso trabalho. Conforme renomeamos um método ou variável e removemos código morto, estamos ativamente deixando o código melhor do que encontramos. 

Testes servem como um mecanismo de documentação mais resiliente.

Utilizar *contratos orientados ao consumidor* (consumer-driven contracts) permite que transmitamos o que o nosso serviço faz, enquanto também nos da confiança para iterar conforme o necessário. Desde que não tenhamos violado o contrato, podemos evoluir o nosso código livremente da preocupação de quebrar inadvertidamente um sistema downstream.

O conjunto de testes simula o comportamento esperado do nosso código. 

Contratos orientados ao consumidor são uma parte vital de software confiável e resiliente.

Muitas linguagens e frameworks têm projetos que podemos (e devemos!) aproveitar em nossas aplicações. Desde Spring Cloud Contract até versões do Pact para quase todas as plataformas, você tem opções.

### Avoid Clever Code
Software é difícil, e os domínios em que trabalhamos são complexos. Mas nem toda complexidade é igual. Em seu amplamente citado ensaio *No Silver Bullet* (sem bala de prata), o essencial Fred Brooks faz a distinção entre complexidade **acidental** e **essencial**.

A complexidade **essencial** é inerente ao software, desde as nuances das regras de negócio, até a comunicação com a nossa equipe, passando pela natureza em constante mudança de uma base de código. Não há nada que possamos fazer para remover essa complexidade do software; ela vem com o salário.

A complexidade **acidental** são as maneiras pelas quais os desenvolvedores tornam as coisas mais difíceis do que precisam ser, desde tecnologias ruidosas até ferramentas pesadas. Em caso de dúvida, mantenha simples.

O software não está imune ao proverbial "óleo de cobra" (*snake oil*). Muitas empresas tentam vender produtos ou processos que revolucionarão a entrega de software. Vale a pena ser cético. É claro que sempre há oportunidades de melhoria, mas o método científico nos lembra que alegações extraordinárias requerem evidências extraordinárias.  

Você deve estar vigilante sobre a remoção da complexidade acidental sempre que possível. 

Linguagens e frameworks frequentemente têm formas propensas a erros. Por exemplo, dê uma olhada no seguinte código Java. Você consegue identificar o problema?
```java
if (condition)
	doFoo();
	doBar();
```

O problema: doBar() será executado SEMPRE, independentemente da condição, porque sem colchetes, apenas a primeira declaração pertence ao *if*, ou seja, o *if* controle apenas uma única instrução quando não há bloco {};
```java
if (condition) {
	doFoo();
	doBar();
}
```
Agora, se *conition* for true, executará os dois, se *condition* for false, não executará nenhum.

Se tem amis de uma linha, use sempre os colchetes {};

A regra é não ter medo de atualizar (ou estabelecer) padrões de codificação para cobrir estes casos. Existem várias ferramentas de análise estática que podemos adicionar ao nosso pipeline de implantação para evitar que a nossa equipe introduzam inadvertidamente esses tipos de problemas. 

**Use ferramentas de linting/formatação**
- **Python:** Black, flake8
- **JavaScript/TypeScript:** ESLint, Prettier
- **Java:** Checkstyle, PMD
- **C#:** StyleCop, Roslyn Analyzers

### Code Reviews
A revisão pode variar desde um ou mais feedback a um colega sobre o que ele acha do método desenvolvido, até *walk-throughts* de várias horas com diversos desenvolvedores. Independentemente dos detalhes específicos de implementação, as revisões de código são uma excelente forma de se aprender, compartilhar experiências e socializar conhecimento. Mais olhos no código são proveitosas, e muitas empresas aprovam a <span style="background:#affad1">ideia de programação em par</span>. Sendo formal ou não, algumas práticas podem melhorar a nossa revisão de código.

**Primeiro e mais importante: não seja sarcástico**
Evite sarcasmo. Pedir feedback pode ser estressante para muitas pessoas, e muitas levam críticas para o lado pessoal. Seja sempre empático com seus colegas de equipe. Objetivo é sempre melhorar o código, não exibir a sua aparência técnica. 
*A única maneira de fazer algo grande é reconhecer que talvez ainda não esteja bom o bastante. O nosso objetivo é encontrar a melhor solução, não medir o nosso valor pessoal por ela."* - Jonas Downey, designer de software...

Foque a sua atenção nas coisas mais importantes. Podemos automatizar questões de formatação e estilo, deixando que o computador lide com esse trabalho. O nosso tempo e esforço deve ser gasto nas coisas que os computadores não conseguem detectar para a gente.

**Algumas perguntas-chave para uma revisão eficaz**
Clareza e Legibilidade:
- Os nomes de métodos e variáveis são claros e concisos?
- O código é legível?
- Há duplicação?

**Qualidade e Manutenibilidade:**
- O código tem o *logging*, rastreamento e métricas apropriados?
- As interfaces são consistentes com o resto do código?
- O desenvolvedor usou alguma forma propensa a erros?

**Design e Arquitetura**
- O modelo de negócio está correto?
- Eles escolheram a abstração errada?

**Práticas Recomendadas:**
- O código segue os princípios SOLID?
- As responsabilidades estão bem separadas?
- Os testes cobrem os casos importantes?

**Dicas práticas para revisões construtivas:**
1. **Comente com contexto:** em vez de "isso está errado", diga "Sugiro usar X porque Y"...
2. **Reconheça o que está bom:** destaque acertos antes de apontar melhorias.
3. **Seja específico:** em vez de "Isso é confuso", explique por que e sugira alternativas.
4. **Ofereça ajuda:** posso te mostrar como fizemos algo similar no módulo X...
5. **Limite o escopo:** pequenas revisões frequentes são mais eficazes que grandes maratonas...
6. **Use ferramentas:** GitHub/GitLab Reviews, Pull Requestes com verificações automatizadas.

O objetivo final é sempre **melhorar o código e a equipe**, não provar quem sabe mais.

### Avoid the Checkbox Code Review
Em alguns casos, as revisões de código não passam de uma simples caixa de seleção *checkbox* no sistema de gerenciamento de código-fonte. Algumas organizações exigem que todo código seja revisado antes de ser mesclado na linha principal (*mainline*). Embora este objetivo seja admirável, na maioria das vezes resulta apenas em um desenvolvedor pedindo a outro para revisar o código, o que geralmente significa apenas marcar a caixa para o seu colega.

Trabalhar em pequenos lotes torna as revisões mais simples e eficazes. <span style="background:#d3f8b6">Mudanças menores são</span>:
- Mais fáceis de entender e revisar;
- Menos propensas a erros não detectados;
- Mais rápidas para aprovar ou solicitar ajustes;
- Menos intimidadoras para revisores;

Algumas organizações usam *pull requests* (PRs) como forma de garantir qualidade de código. Embora possam ser mais confortáveis do que passar a tarde em uma chamada de vídeo discutindo código, os PRs nem sempre são propícios para construir coesão e confiança na equipe.
**Problemas comuns com PRs**:
- #Nitpicking: alguns desenvolvedores usam PRs como oportunidade para criticar detalhes insignificantes;
- **Batalhas de território:** disputas sobre "como as coisas devem ser feitas";
- Reabertura de questões: reacender problemas previamente resolvidos;
- **Respostas LFTM:** Looks Fine to Me (parece bom para mim), uma revisão superficial;

Comentários baseados em texto carecem do tom e linguagem corporal das conversas presenciais. Podemos desviar as nossas reais intenções, e um comentário pode soar de maneira ácida e cortante, mas pode ser assim interpretado por uma pessoa do outro lado da solicitação.

Não devemos nos surpreender se alguns dos nossos colegas de equipe, especialmente aqueles com menos experiência, temerem um PR. 


Os membros seniores da equipe devem liderar pelo exemplo:

### It is Hard to Be Criticized
É muito difícil não levar o feedback para o lado pessoa, muitos desenvolvedores investem muito de si mesmos em seu trabalho. Revisões de código não são uma oportunidade para constranger alguém porque não conhecia algum novo recurso da linguagem ou não viu imediatamente uma maneira mais simples de resolver um problema. Ninguém é perfeito; todo mundo comete erros.

Revisões de código são sobre construir aplicações melhores e são sobre o **código**, não sobre o codificador. Não seja pessoal em uma revisão de código. Seja humilde e faça perguntas úteis. As críticas são mais digeríveis quando são "sanduíches" por elogios, então certifique-se de apontar as coisas boas também.

Compartilhe suas experiências. Histórias pessoais carreguem um peso imenso e dissipam a resistências natural das pessoas à mudança. Ofereça assistência em coisas que você encontrou em projetos anteriores. Tenha cuidado com proclamações gerais. Certifique-se de ter todos os detalhes antes de declarar que algo não funcionará, pois podemos estar perdendo uma informação contextual importante. Há algum contexto que você não tem? Talvez haja restrições das quais você não esteja ciente.

*Cada um de nós está fazendo absolutamente o melhor que pode, dado nosso estado de consciência. - Deepak Chopra*

Se algo no código de alguém lhe preocupa, não tenha medo de falar diretamente com o desenvolvedor. As pessoas podem ser muito defensivas, especialmente em situações em grupo. Uma discussão rápida individual pode ser a resposta. Não embosque um colega de equipe; ninguém ganha nessas interações.

As revisões são uma chance de aprender, uma oportunidade de ensinar.

┌─────────────────────────────────────────┐
│  Camada Superior: **ELOGIOS**               │
│  • "Gostei da forma como você organizou"│
│  • "Essa solução é criativa"            │
└─────────────────────────────────────────┘
┌─────────────────────────────────────────┐
│  Recheio: **CONSTRUÇÃO**                    │
│  *• "Que tal considerar esta alternativa?"│*
*│  • "Aqui há uma oportunidade de melhoria"*│
└─────────────────────────────────────────┘
┌─────────────────────────────────────────┐
│  Camada Inferior: **ENCORAJAMENTO**         │
│  • *"Estou animado para ver a versão final"│*
*│  • "Você está no caminho certo"*         │
└─────────────────────────────────────────┘

### Fostering Trust
Independente do nosso processo de revisão de código, não perca de vista o nosso propósito. Devemos compartilhar experiências, aprender a crescer como uma equipe,, evitando práticas problemáticas confusas ou abordagens obsoletas.

Incentive seus colegas de equipe a fazer perguntas e fornecer feedback construtivo. Revisões de código devem promover a propriedade coletiva do código e fomentar a confiança entre a equipe. Promover um bug da semana ou reservar um tempo para compartilhar algo com que você se deparou pode ser incrivelmente poderoso.

Uma reunião regular em que as pessoas são incentivadas a falar sobre um defeito interessante que resolveram é uma técnica de aprendizado inestimável. Podemos presumir que todos sabem o que fazer quando se deparam com um problema específico, mas discutir essas situações com seus colegas de equipe dissemina o conhecimento. O simples ato de reservar um tempo durante a reunião de sexta-feira para discutir algo interessante que as pessoas experimentam durante a semana pode render dividendos.

Não é preciso dizer, mas trate seus colegas de equipe com respeito. Seja gentil, faça o que é certo, faça o que funciona. Não tenha medo de parar para analisar sua abordagem e perguntar se há uma maneira melhor. Quer esteja seguindo uma metodologia de desenvolvimento ágil ou não, você deve se adaptar e se ajustar regularmente. Se algo não estiver funcionando, mude!

### Learning New Languages
Se você quer melhorar sua capacidade de escrever código, você precisa, escrever código. Podemos acelerar essas habilidades aprendendo novas linguagens de programação. Pense em aprender um idioma estrangeiro. Durante meses, até mesmo anos, traduziremos esse idioma para a nossa língua nativa. Eventualmente, pensaremos, e até sonharemos com o novo idioma. As linguagens de programação não são diferentes. Bem, elas têm regras gramaticais muito exigentes e muito menos palavras-chave.

O segredo é a imersão. Aprender uma nova linguagem de programação é praticamente a mesma coisa. Crie um aplicativo na nova linguagem que resolva um problema que o atormenta no trabalho ou em casa. Siga a comunidade nas mídias, ouça podcasts relacionados ou assista vídeos da última conferência voltada para a linguagem. 

Os desenvolvedores tendem a se apegar muito ao seu primeiro idioma. Tenha cuidado com isso. As linguagens de programação são apenas ferramentas. Assim como um martelo é uma ferramenta melhor para bater em um prego do que uma chave de fenda, algumas linguagens são mais adequadas para determinados problemas do que outras. Por exemplo, muitos sistemas incorporados são escritos em C, pois é altamente portátil e confiável e poder ser altamente otimizado para plataformas específicas. Algumas pessoas influentes sugerem aprender uma nova linguagem a cada um ou dois anos. A linguagem não é o fim em si mesma.

---
**Programming is Fundamentally About Communication**
A programação é fundamentalmente uma questão de comunicação Antes de os departamentos de ciência da computação começarem a surgir nas universidades de todo o mundo, a programação geralmente ficava no departamento de matemática, e muitos presumiam que a aptidão matemática era um pré-requisito para o sucesso no software. Em alguns casos, as universidades ainda usam exames de matemática para recrutar alunos! Apesar dessa suposição, as pesquisas mostram que a aptidão para a linguagem é um indicador muito melhor da rapidez com que alguém aprende uma nova linguagem de programação do que a habilidade em matemática. Embora certos domínios possam ser muito pesados em termos de matemática, a arte da programação não é. <span style="background:#fff88f">A programação é</span>, antes de tudo, <span style="background:#d3f8b6">uma atividade de comunicação</span> - e ^não entre o programador e o compilador. Não se esqueça de que o computador entende qualquer código (pelo menos se estiver sintaticamente correto), mas isso não significa que um ser humano entenderá o que você está tentando realizar. Os melhores engenheiros de software se concentram na pessoa que está lendo o código. Os bons escritores (de qualquer tipo) sempre têm o público em mente

---
Aprender um novo idioma leva tempo. Como você justifica o investimento necessário para aprender algo que talvez não use diariamente no trabalho? Aprender uma nova linguagem mudará a forma como você codifica, mesmo que não use a nova ferramenta todos os dias. Ao buscar um novo desafio de linguagem, tente escolher algo que seja diferente do que você usa no trabalho. Se você for um desenvolvedor Java experiente, procure outras linguagens semelhantes ao C, como o C# (não que haja algo de errado em aprender C#, veja bem), em direção a paradigmas diferentes. Em vez disso, considere uma linguagem dinâmica como Ruby ou uma linguagem funcional como Haskell. Confie em nós, mesmo que seja apenas um exame superficial de uma linguagem fora de sua vizinhança normal, isso alterará fundamentalmente sua abordagem à programação. Talvez você passe a apreciar mais a sua linguagem habitual ou passe a escrever código de uma maneira diferente. Reserve um tempo para aprender coisas novas.

Aprender novos idiomas fica mais fácil com o tempo. Quanto mais idiomas você conhece, mais você tem o que comparar. 

No início de nossas carreiras, devemos nos concentrar em se aprofundar o máximo possível nas linguagens e estruturas que usamos diariamente. Entretanto, não deixe de explorar outras opções. 

### Wrapping Up
Os desenvolvedores escrevem código; isso é parte integrante do trabalho. 
Evitar formulários propensos a erros e códigos excessivamente inteligentes pode ser a diferença entre uma base de código que é um prazer trabalhar e uma que os desenvolvedores evitam como uma praga. 
De revisões de código a ferramentas de análise, há muitas maneiras de ajudá-lo a escrever um código melhor. Prefira escrever testes em vez de fazer comentários extensos. 
Ao criticar o código, seja empático. Nunca se esqueça de que o código deve ser escrito para ser lido por seres humanos; aderir a esse princípio ajuda muito a garantir que você escreva um código que será carimbado por outras pessoas com o elusivo rótulo de "bom"! Escrever um bom código é um processo de aprendizado contínuo. 
Esteja aberto para aprender novas habilidades e aprimorar as que você já desenvolveu. 
Manter-se atualizado sobre as práticas recomendadas em engenharia de software é fundamental para seu sucesso de longo prazo na área.

### Putting It into Practice
Não há atalhos; se você quiser melhorar como desenvolvedor, precisará escrever código! Como diz a velha piada: Um pedestre na 57th Street vê um músico saindo de um táxi e pergunta: "Como você chega ao Carnegie Hall?" Sem pausa, o artista responde cansativamente: "Pratique". Se quiser ser um desenvolvedor melhor, você precisa praticar.

Considere a possibilidade de acrescentar um estudo intenso à sua rotina. Periodicamente, digamos, a cada dois meses, reserve algumas horas para estudar um código kata. Nas artes marciais, os katas são uma série de bloqueios, chutes e socos que os alunos estudam e repetem inúmeras vezes. Os katas de código trazem essa ideia para o software, fornecendo problemas simples que lhe dão a chance de praticar sua arte e trabalhar em coisas que talvez você não encontre no seu dia a dia de codificação.

Você pode aproveitar os katas de código de várias maneiras. Você pode escolher um e resolvê-lo em duas ou três linguagens de programação. Você pode formar uma dupla com um amigo ou colega para trabalhar em um kata. Há várias maneiras de resolver um determinado kata; desafie-se a resolver o mesmo kata de duas ou três maneiras. Faça uma revisão de código em um kata que você resolveu há alguns meses (ou anos!) - o que você faria diferente hoje? 

Mais uma vez, você pode aproveitar o universo do software de código aberto. Reserve algumas horas para contribuir com uma biblioteca de código aberto que você usa (ou deseja usar). Se não tiver certeza de por onde começar, dê uma olhada nos repositórios de tendências no GitHub. Contribuir com o código-fonte aberto é um excelente laboratório de aprendizado e não é tão difícil de começar quanto você imagina.

Você ainda pode aprender muito sobre como escrever um bom código sem contribuir. Escolha um projeto e passe algumas horas lendo o código. Do que você gosta? Do que você não gosta? O que você faria diferente? Execute um analisador de código-fonte no código: o que isso lhe diz sobre o projeto? Se você vir algum problema evidente, não tenha medo de levantá-lo ou contribuir com um PR.

Acompanhar as mudanças é um componente essencial para uma carreira bem-sucedida em software; crie o hábito de atualizar seus conhecimentos sobre suas principais linguagens e estruturas. Talvez você não encontre organicamente novos recursos em seu trabalho diário, portanto, dedique algumas horas uma ou duas vezes por ano para ver o que foi adicionado ao seu kit de ferramentas. A maioria das tecnologias tem defensores ou campeões, portanto, siga ou se inscreva para ficar a par das mudanças. Nem todas as novidades brilhantes funcionarão para seus aplicativos, pelo menos hoje, mas é mais simples digerir periodicamente um pequeno punhado de atualizações do que tentar aprender sobre dezenas ou centenas de novidades a cada poucos anos.

Por último, mas não menos importante, considere a possibilidade de oferecer seu talento em programação para uma instituição de caridade local ou sem fins lucrativos. Muitas organizações merecedoras estão constantemente procurando ajuda da comunidade técnica. O voluntariado pode dar a você a chance de praticar seu ofício, talvez usando uma linguagem ou estrutura que esteja tentando aprender, e ao mesmo tempo ajudar uma causa com a qual você se importa.