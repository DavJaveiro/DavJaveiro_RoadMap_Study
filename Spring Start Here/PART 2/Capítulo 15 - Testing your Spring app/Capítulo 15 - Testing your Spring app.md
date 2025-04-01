*This chapter covers*
- Why testing apps is important;
- How tests work;
- Implementing unit tests for Spring apps;
- Implementing Spring Integration tests.

Neste capítulo, aprenderemos a implementar test para nossos aplicativos Spring. Um test é um pequeno trecho de lógica cujo objetivo é validar que uma capacidade específica implementada pelo aplicativo funciona conforme o esperado. Podemos classificar os testes em duas categorias:
1. *Unit tests* - focam apenas em um trecho isolado de lógica;
2. *Integration tests* - focam em validar que múltiplos *components* interagem corretamente entre si.
Mas, quando nos referirmos a testes, estamos nos referindo a ambas as categorias.

Tests são essenciais para qualquer aplicação. Eles garantem que as mudanças feitas durante o processo de desenvolvimento da aplicação não quebrem capacidades existentes (ou pelo menos tornam erros menos prováveis) e também servem como uma documentação. Muitos developers (infelizmente) negligenciam testes porque eles não fazem parte da *business logic* da aplicação, e, claro, leva algum tempo para escrevê-los. Por isso, testes podem parecer não ter um impacto significativo. De fato, seu impacto geralmente não é visível no curto prazo, mas acredite, testes são inestimáveis no longo prazo. Não posso enfatizar o suficiente o quanto é importante garantir que usamos ele de forma adequada.

Por que devemos escrever testes ao invés de confiar apenas no teste manual de uma funcionalidade?

- **Porque você pode executar esse teste repetidamente para validar se as coisas estão funcionando conforme o esperado com o mínimo de esforço (valida continuamente que o aplicativo se comporta corretamente)**. 
- Ao ler as etapas do teste, podemos facilmente entender o propósito do caso de uso (serve como documentação);
- Porque os testes fornecem feedback antecipado sobre novos problemas no aplicativo durante o processo de desenvolvimento.

Por que as funcionalidades do aplicativo podem não funcionar uma segunda vez se inicialmente funcionaram?
- **Porque alteramos continuamente o código-fonte do aplicativo para corrigir bugs ou adicionar novas funcionalidades.** Quando alteramos o código-fonte, pode acabar quebrando capacidades implementadas anteriormente. 

Se escrevermos testes para essas funcionalidades, podemos executá-las a qualquer momento que alterarmos o aplicativo para validar se as coisas ainda estão funcionando conforme o esperado. Se afetarmos alguma funcionalidade existente, descobriremos o que aconteceu antes de entregar nosso código para produção. **Teste de regressão** é a abordagem de testar continuamente a funcionalidade existente para validar que ela ainda funciona corretamente. 

Uma boa abordagem é garantir que testemos todos os cenários relevantes para qualquer funcionalidade específica que implementarmos. Podemos executar os testes sempre que alterarmos algo para validar que as funcionalidades implementadas anteriormente não foram afetadas por nossas mudanças.

Hoje em dia, não dependemos apenas dos desenvolvedores executando os testes manualmente, mas tornamos a execução deles parte do processo de build do aplicativo. Em geral, as equipes de desenvolvimento usam o que chamamos de abordagem de *integração contínua (CI)*: elas configuram uma ferramenta como #Jenkins ou #TeamCity para executar um processo de build toda vez que um desenvolvedor faz alterações. Uma ferramenta de <span style="background:#d4b106">integração contínua</span> é um software que usamos para executar as etapas necessárias para compilar e, às vezes, instalar os aplicativos que implementamos durante o processo de desenvolvimento. Essa ferramenta CI também executa os testes e notifica os desenvolvedores se algo foi quebrado. 
![[Capítulo 15 - Testing your Spring app.png]]
1. O desenvolvedor envia o código para o repositório GIT;
2. Uma ferramenta de integração contínua, como o Jenkins executa os testes;
3. Se o teste falhar, Jenkins notifica o desenvolvedor.

Na seção 15.1, começamos traçando um panorama geral do que é um teste unitário e como ele funciona. 
Na seção 15.2, discutimos os dois tipos mais comuns de testes que encontraremos sendo utilizados em aplicativos Spring:
	- *Testes unitários*
	- *Testes de integração*

Testes merece sua própria prateleira de livros. Recomendo que leia o livro *JUnit in Action (Manning, 2020).*

## 15.1 Writing correctly implemented tests
Nesta seção, vamos discutir como os testes funcionam e o que constitui um teste implementado corretamente. Aprenderemos como escrever o código do nosso aplicativo para torná-lo fácil de testar e observaremos que há uma forte conexão entre tornar o aplicativo **testável** e torná-lo *mantenível* (ou seja, fácil de alterar para implementar novas funcionalidades e corrigir erros). A testabilidade e a manutenibilidade são qualidades de software que se apoiam mutuamente. Ao projetar seu aplicativo para ser testável, também ajudamos a torná-los mais  fácil de manter.

Escrevemos testes para validar se a lógica implementada por um método específico no projeto funciona de maneira desejada. Quando <span style="background:#d4b106">testamos um determinado método</span>, geralmente precisamos validar vários cenários (formas como o aplicativo se comporta dependendo de diferentes entradas). Para cada cenário, escrevemos um método de teste em uma classe de teste. Em um projeto Maven (como os exemplos que implementamos ao longo do livro), escrevemos as classes de teste na pasta de testes do projeto.

Uma classe de teste deve focar apenas em um método específico cuja lógica estamos testando. Mesmo uma lógica simples pode gerar diversos cenários. Para cada cenário, escreveremos um método na classe de teste que valida aquele caso específico.

![[Capítulo 15 - Testing your Spring app-1.png]]

Vamos pegar um exemplo. Lembra do caso de uso de transferência de dinheiro que discutimos? Esta foi nossa implementação simples de transferir um valor dado entre duas contas diferentes. O caso de uso tinha apenas quatro passos:
1. Encontrar os detalhes da conta de origem no banco de dados;
2. Encontrar os detalhes da conta de destino no banco de dados;
3. Calcular os novos valores para as duas contas após a transferência;
4. Atualizar os valores das contas no banco de dados.

Mesmo com apenas esses passos, ainda podemos encontrar vários cenários relevantes para testes:
1. Teste o que acontece se o aplicativo não conseguir encontrar os detalhes da conta de origem;
2. Teste o que acontece se o aplicativo não conseguir encontrar os detalhes da conta de destino;
3. Teste o que acontece se a conta de origem não tiver dinheiro suficiente;
4. Teste o que acontece se a atualização dos valores falhar;
5. Teste o que acontece se todas as etapas funcionarem corretamente.

Para cada cenário de teste, precisamos entender como o aplicativo deve se comportar e escrever um método de teste para validar se ele funciona conforme  o desejado. Por exemplo, para o caso de teste 3, se não quisermos permitir uma transferência caso a conta de origem não tenha dinheiro suficiente, testaremos se o aplicativo lança uma exceção específica e a transferência não ocorre. No entanto, dependendo dos requisitos do aplicativo, podemos permitir um limite de crédito definido para a conta de origem. Nesse caso, se teste também precisa levar esse limite em consideração.

A implementação do cenário de teste está fortemente relacionada a como o aplicativo deve funcionar, mas tecnicamente, a ideia é a mesma em qualquer aplicativo: identificamos os cenários de teste e escrevemos um método de teste para cada um;

Um ponto crítico a observar é que podemos encontrar vários cenários de teste relevantes, mesmo para um método pequeno - mais um motivo para manter os métodos em nosso aplicativo pequenos. Se escrevermos métodos grandes, com muitas linhas de código e parâmetros que lidam com várias coisas simultaneamente, identificar os cenários de teste relevantes se torna extremamente difícil. Dizemos que a *testabilidade* do aplicativo diminui quando não separamos adequadamente as diferentes responsabilidades em métodos pequenos e fáceis de ler.

**![[Capítulo 15 - Testing your Spring app-2.png]]

## 15.2 Implementing tests in Spring apps
Nesta seção, nós vamos usar duas técnicas de testes para aplicações Spring que frequentemente encontramos em projetos do mundo real. Vamos demonstrar cada técnica considerando um caso de uso que implementamos nos capítulos anteriores e escrever os testes para ele. Essas técnicas são (na minha perspectiva) imprescindíveis para qualquer desenvolvedor:
- **Escrever testes unitários para validar a lógica de um método**: os testes unitários são curtos, rápidos de executar e focam em apenas um fluxo. Esses testes são uma maneira de focar na validação de uma pequena parte da lógica eliminando todas as dependências. 
- **Escrever testes de integração Spring para validar a lógica de um método e sua integração com recursos específicos fornecidos pelo framework.** Esses testes ajudam garantir que as capacidades do nosso aplicativo ainda funcionem quando atualizamos as dependências. 

### 15.2.1 Implementing unit tests
Testes unitários são métodos que chamam um determinado caso de uso em condições específicas para validar o comportamento. O método de teste unitário define as condições sob as quais o caso de uso é executado e valida o comportamento definido pelos requisitos do aplicativo. 
Eles eliminam todas as dependências da funcionalidade que estão testando, cobrindo apenas uma parte específica e isolada da lógica.

Os testes unitários são valiosos porque, quando um falha, você sabe que há um problema em uma parte específica do código e consegue identificar exatamente onde precisa corrigir. Um teste unitário é como um dos indicadores do painel do nosso carro.

Se tentarmos ligar o carro e ele não dá partida, pode ser porque acabou o combustível ou porque a bateria não está funcionando corretamente. Um carro é um sistema complexo (assim como um aplicativo), e nós não sabemos qual é o problema sem um indicador. Se o painel mostrar que o combustível acabou, então, identificamos o problema imediatamente!

O propósito dos testes unitários é validar o comportamento de uma única unidade de lógica e, assim como os indicadores do carro, eles ajudam a identificar problemas em um comportamento específico.


**Implementando o primeiro teste unitário**
Vamos analisar um dos casos de uso que escrevemos no capítulo 14: o caso de uso de transferência de dinheiro.
1. Encontrar os detalhes da conta que envia dinheiro;
2. Encontrar os detalhes da conta de destino (destination account details);
3. Calcular os novos valores para cada conta;
4. Atualizar o valor da conta do remetente;
5. Atualizar o valor da conta de destino.

Geralmente, os cenários mais óbvios e os primeiros para os quais escrevemos testes são os `fluxos felizes` ou *happy flows*: uma execução que não encontrou exceções ou erros. A figura 15.4 representa visualmente o fluxo feliz do nosso caso de uso de transferência de dinheiro:

![[Capítulo 15 - Testing your Spring app-3.png]]

Vamos escrever um teste unitário para este fluxo feliz do caso de uso de transferência de dinheiro. Qualquer teste possui três partes principais:
1. **Premissas:** precisamos definir quaisquer entradas e identificar quaisquer dependências da lógica que precisamos controlar para alcançar o cenário de fluxo desejado. Para este ponto, responderemos às seguintes perguntas: quais entradas devemos fornecer e como as dependências devem se comportar para que a lógica testada atua da maneira específica que queremos?
A primeira parte do teste unitário é definir as 
- **Entradas:** quais dados vamos fornecer ao teste? (Ex.: conta de origem, conta de destino, valor da transferência). 
- **Dependências:** como as classes externas (repository, services) devem se comportar para simular o cenário correto? (Ex.: garantir que as contas existem e têm saldo suficiente).

1. **Chamada/Execução:** precisamos chamar a lógica que estamos testando para validar o seu comportamento;

2.**Validações:** precisamos definir todas as validações que devem ser feitas para a lógica em questão. Responderemos a esta pergunta: o que deve acontecer quando essa lógica for chamada nas condições dadas? 
![[Capítulo 15 - Testing your Spring app-4.png]]

- **STEP 1:** defining the assumptions, before calling the tested method, decide the input values the methods depends on;
- **STEP 2:** call the tested method, call the method you test with the given inputs decided in the assumptions step.
- **STEP 3:** validations, write all the checks the tests need to perform to validate the tested method executed as expected, with the inputs given in the assumptions.

**NOTA:** às vezes, você encontrará essas três etapas (premissas, chamada e validações) nomeadas de forma um pouco diferente: *arrange, act e assert* ou *given, when e then*. Independentemente de como você prefira nomeá-las, a ideia de como escrever os testes permanece a mesma.

Nas premissas do teste, <span style="background:#d4b106">identificamos as dependências</span> para o caso de teste que estamos escrevendo. Escolhemos as entradas e definimos como as dependências devem se comportar para fazer com que a lógica testada atue de uma determinada maneira.

Quais são as dependências para o caso de uso de transferência de dinheiro? Dependências são qualquer coisa que o método utiliza, mas não cria por conta própria:
- Os parâmetros do método;
- Instâncias de objetos que o método utiliza, mas que não são criadas por ele:
![[Capítulo 15 - Testing your Spring app-5.png]]
- Os parâmetros são <span style="background:#d4b106">dependências de execução</span>. Com base em seus valores, o método pode se comportar de uma maneira ou de outra.
- Outros <span style="background:#d4b106">objetos externos ao método</span>, mas que o método utiliza para implementar sua lógica, também são dependências de execução. Com base no comportamento desses objetos, o método pode se comportar de uma maneira ou de outra.

Quando chamamos o método para testá-lo, podemos fornecer quaisquer valores para seus três parâmetros para controlar o fluxo de execução. No entanto, a instância de *AccountRepository* é um pouco mais complicada. A execução do método *transferMoney()* depende de como o método *findById()* da instância de *AccountRepository* se comporta.

Mas, um teste unitário, foca apenas em uma parte específica da lógica, então ele não deve chamar o método *findById()* diretamente. O teste unitário deve assumir que o *findById()* funciona de uma determinada maneira e verificar se a execução do método testado faz o que é esperado para a situação dada.

No entanto, o método testado chama o *findById()*. Como poderíamos controlar isso? Para controlar esse tipo de dependência, usamos *mocks*: objetos falsos cujo comportamento podemos controlar. Nesse caso, em vez de usar o objeto real *AccountRepository*, garantimos que o método testado utilize esse objeto falso. Aproveitaremos o controle sobre o comportamento desse objeto falso para induzir todas as diferentes execuções do método *transferMoney()* que queremos testar.

Ao invés de chamarmos o *findById()* real, fazemos o mock dele para retornar contas fictícias. Dessa forma, testamos apenas a lógica de transferência, sem depender do banco de dados.

![[Capítulo 15 - Testing your Spring app-6.png]]

Na listagem 15.2, começaremos a implementar o teste unitário. Após criar uma nova classe na paste de testes, iniciamos a implementação do primeiro cenário de teste escrevendo um novo método que anotamos com a anotação *@Test*.

**NOTAS:** para os exemplos neste livro, usamos **JUnit 5 Jupiter**, a versão mais recente do JUnit, para implementar os testes unitários e testes de integração. No entanto, em aplicativos do mundo real, podemos encontrar o JUnit 4 sendo usado frequentemente. 

Criamos a instância de *TrasnferService* para chamar o método *transferMoney()* que queremos testar. Em vez de usar uma instância de *AccountRepository*,  criamos um objeto falso #mock que podemos controlar. Para criar esse objeto falso, usamos um método chamado *mock()*. Esse método *mock()* é fornecido por uma dependência chamada **Mockito** (frequentemente usada com JUnit para implementar testes). 

[[TransferServiceUnitTests.java]]

Agora podemos especificar como o objeto fictício ( #mock) deve se comportar, chamar o método testado e provar que ele funciona conforme o esperado nas condições dadas. Controlamos o comportamento do #mock usando o método *giver()*. Usando o método *given()*, <span style="background:#b1ffff">informamos ao mock como ele deve se comportar quando um de seus métodos for chamado</span>. No nosso caso, querermos que o método *findById()* de *AccountRepository* retorne uma instância específica de *Account* para um determinado valor de parâmetro.

**NOTA:** em um aplicativo do mundo real, uma boa prática é usar a anotação *@DisplayName* para descrever o cenário de teste. Nos nossos exemplos, omiti a anotação *@DisplayName* para economizar espaço e permitir que você se concentre na lógica do teste. No entanto, usá-la em um aplicativo real pode ajudar você, assim como outros desenvolvedores da equipe, a entender melhor o cenário de teste implementado.

[[TransferServiceUnitTests.java]]

A última coisa que precisamos fazer é informar ao teste o que deve acontecer quando método testado for executado. O que esperamos? Sabemos que a finalidade desse método é transferir dinheiro de uma conta para outra. Portanto, esperamos que ele chame a instância do  repositório para alterar os valores das contas com os valores corretos. Para verificar se um método de um objeto *mock* foi chamado, usamos o método *verify()*, conforme:
```java
	transferService.transferMoney(
		sender.getId(),
		destination.getId(),
		new BigDecimal(100)
	);

	verify(accountRepository).changeAmount(1L, new BigDecimal(900));
	verify(accountRepository).changeAmount(2L, new BigDecimal(2100));
```

Se executarmos o teste agora, vamos observar que os testes passam. 

A figura abaixo resume o teste que construímos. Nesta representação visual, encontramos as etapas e o código que escrevemos para resolver cada uma das etapas que enumeramos ao começarmos a escreve o teste:
1. **Premissas** - enumerar e controlar as dependências;
2. **Chamada** - executar o método testado;
3. **Validações** - verificar se o método executado teve o comportamento esperado.
![[Capítulo 15 - Testing your Spring app-7.png]]

**1. Premissas (Given)** - Essa fase define e controla as dependências do teste. Aqui, criamos os objetos necessários e configuramos o comportamento esperado dos mocks.
```java
@Mock
private AccountRepository accountRepository;

@InjectMocks
private TransferService transferService;
```

Isso significa que o *accountRepository* será um #mock gerenciado pelo #Mockito, e o *transferService* terá esse mock injetado automaticamente.

```java
    Account sender = new Account();
    sender.setId(1);
    sender.setAmount(new BigDecimal(1000));

    Account destination = new Account();
    destination.setId(2);
    destination.setAmount(new BigDecimal(2000));
```
Aqui, criamos duas contas fictícias: uma que envia dinheiro *sender* e outra que recebe *destination*. 

Depois, definimos o comportamento do mock através do método #given:
```java
given(accountRepository.findById(sender.getid())).willReturn(Optional.of(sender));

given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));
```

Portanto, quando o *findyById(1)* ou *findById(2)* forem chamados dentro do *transferService*, o mock retornará as contas criadas.

**2. Chamada (When)**
Nesta etapa, executamos a ação que queremos testar:
```java
transferService.transferMoney(1, 2, new BigDecimal(100));
```
Chamamos o método *transferMoney(1, 2, 100)*, que transfere 100 unidades monetárias da conta de ID 1 para a conta de ID 2.

Essa é a ação principal do teste, que determinará se o código está funcionando corretamente. 

**3. Validações (Then)**
Nesta última etapa, verificamos se o comportamento do código foi o esperado.
```java
verify(accountRepository).changeAmount(1, new BigDecimal(900));
verify(accountRepository).changeAmount(2, new BigDecimal(2100));
```

**Resumo da Estrutura**

|Fase|O que acontece no código?|
|---|---|
|**Premissas (Given)**|Configuramos os mocks e os dados de entrada (contas e valores iniciais).|
|**Chamada (When)**|Executamos a transferência chamando `transferMoney()`.|
|**Validações (Then)**|Verificamos se os métodos `changeAmount()` foram chamados com os valores esperados.|

**Writing a test for Exception Flow**
Os fluxos felizes não são os únicos que precisamos testar. O método precisa ser executado da maneira desejada ao encontrar uma exceção. Esse tipo de fluxo é chamado de <span style="background:#b1ffff">fluxo de exceção</span>. Em nosso exemplo, um fluxo de exceção pode ocorrer caso os detalhes da conta do remetente ou do destino não sejam encontrados para o ID fornecido.
![[Capítulo 15 - Testing your Spring app-8.png]]
Os fluxos de exceção também desempenham um papel crucial em garantir a robustez e confiabilidade de um sistema. Eles ajudam a identificar como a aplicação se comporta em condições adversas ou inesperadas. Implementar testes para fluxos de exceção é essencial para validar que o sistema responde adequadamente, lidando com falhas de maneira controlada, o que evita comportamentos indesejados ou erros críticos em produção.

A listagem abaixo demonstra como escrever o teste de unidade para um fluxo de exceção. Para verificar se o método lança uma exceção, usamos o *assertThrows()*. Nesse caso, especificamos a exceção que esperamos que o método lance e identificamos o método testado. O método *assertThrows()* chama o método testado e valida que ele lança a exceção esperada.

