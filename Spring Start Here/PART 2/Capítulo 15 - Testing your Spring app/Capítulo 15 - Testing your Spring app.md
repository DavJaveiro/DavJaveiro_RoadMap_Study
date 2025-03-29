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

