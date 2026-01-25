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
Software é difícil, e os domínios em que trabalhamos são complexos. Mas nem toda complexidade é igual. 