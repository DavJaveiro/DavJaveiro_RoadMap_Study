*Quality is not an act, it is a habit - Will Durant, paraphrasing Aristotle*

Produzir software de alta qualidade e fácil manutenção é o resultado de prática consistente de bons hábitos ao escrever, revisar e testar o código. Escrever software de alta qualidade é uma disciplina que exige prática regular, mas, com o tempo, os nossos esforços de teste servirão como salvaguardas eficazes que o nossos colegas de equipe e nós mesmos, do futuro, apreciarão.

## Benefits of Automated Testing
Veremos como essa prática aumenta a qualidade do nosso código, eleva a nossa confiança no trabalho e, fundamentalmente, faz-nos tornarmos um engenheiro mais eficiente. Ao compreender essas vantagens, obteremos um foco claro para os nossos esforços de teste e entenderemos por que investir tempo em testes automatizados vale a pena para o nosso crescimento pessoal.

## Acts as Documentation
Ingressar em um projeto existente pode ser muito complicado. É um luxo que um projeto tenha documentação. Se tivermos sorte, podemos conversar com os principais desenvolvedores ou especialistas no domínio para obter uma visão geral de alto nível antes de começar a trabalhar. Isso nem sempre é possível, e a documentação pode ser escassa ou até mesmo inexistente. <span style="background:#affad1">A nossa salvação é um projeto que tenha testes bem escritos. </span> 

Consider a scenario where we're tasked with fixing payment-processing issues with a particular type of card. Without proper documentation or testes, we'd have to sift through unfamiliar (likely complex) code or rely on colleagues for guidance. 

Now imagine finding a comprehensive test suite for payments. We'd see a PaymentProcesserTest class with descriptive test name like these:
- shouldValidateValidCreditCardNumber
- shouldProcessCreditCardTransaction
- shouldProcessOrangePay

These tests provide insight into the module's fatures and point to relevant code sections. Modern IDEs allow easy navigation to the specific services being tested (sse Chapter 2 for effective code-reading strategies). A failing test leads we to the like culprit (culpado) within the codebase. 

We might discover a test name shoudlFailWhenCreditCardTypeIsOrangePay, revealing that Orange Pay ins't supported. This information helps we quickly identify and fix the issue, update the frontend, and improve documentation.

This example demonstrates how testes can serve as documentation, helping we learn a codebase faster. By focusing on improving test suites, we can enhance code quality, reduce production issues, and speed up our ability to contribute to projetcs.

## Improves Maintainability
Escrever um código bom e de fácil manutenção é uma habilidade que normalmente leva anos para ser desenvolvida. Escrever testes primeiro é como pensar antes de falar: isso ajuda a planejarmos e estruturarmos os nossos pensamentos. <span style="background:#d3f8b6">O objetivo principal dos iniciantes muitas vezes é apenas fazer o código funcionar</span>. Embora isso continue sendo importante, escrever testes ajuda a reconhecermos áreas de melhoria muito mais cedo.

Considere este exemplo de um **BlogPostController**:
```java
public class BlogPostController {
	public void publish(Post post) {
	
	}
}
```
À primeira vista, isso pode parecer perfeitamente aceitável. No entanto, se tentarmos escrever testes para esse método, logo perceberemos que ele está fazendo coisas demais:
- Comunicando-se com um banco de dados
- Registrando informações (log)
- Enviando e-mail

Essa abordagem viola o **princípio da responsabilidade única**, que afirma: "Uma classe deve ter apenas um motivo para mudar".

Ao pensar em como testar esse código, podemos naturalmente identificarmos a suas falhas. Então, refatoremos cada parte do processo de publicação em classes separadas, tornando-as mais fáceis de testar e manter.

Escrever testes não apenas verifica a funcionalidade, mas também nos orienta em direção a um design de código melhor. Isso ajuda a identificar problemas em potencial antes que eles se tornem problemas reais, levando a um software mais fácil de manter e reutilizar.

## Boosts Our Confidence
Entre muitos benefícios dos testes automatizados, um se destaca: a confiança para codificar livremente. Como em muitos cenários da vida, projetar confiança pode ajudar-nos a lidar com a pressão e a enfrentar desafios pessoais e profissionais. O desenvolvimento de software é inerentemente iterativo, pois escrevemos, experimentamos e refatoramos constantemente. Sem os testes, podemos codificar com cautela, tentando evitar a introdução de alterações que possam quebrar as coisas. Talvez, tenhamos medo de tentar novas técnicas ou uma solução criativa. Mas com um conjunto de testes robusto, temos uma rede de segurança. Essa liberdade muda fundamentalmente a forma como abordamos a codificação. Podemos fazer alterações, experimentar novas soluções e refatorar com confiança, sabendo que os nossos testes detectarão qualquer problema.

Alterar e refatorar o código pode ser uma experiência estressante. Talvez não tenhamos um entendimento completo do aplicativo, e pode ser difícil prever os efeitos colaterais. <span style="background:#d3f8b6">Trabalhar sem testes é como escalar uma montanha sem cordas. </span>Se tudo der certo, pode ser uma descarga de adrenalina, mas um erro pode ser catastrófico.

Os testes funcionam como uma rede de segurança ao navegar em uma base de código e nos dão a capacidade de agir com confiança. Embora o nosso objetivo inicial seja fazer com que um recurso funciona, precisamos considerar como as alterações podem afetar todo o sistema. Sem testes abrangentes, tudo pode parecer funcional e depois resultar em problemas durante a produção.

Uma suíte de testes robusta permite que a equipe faça o seguinte:
- Refatore o código com confiança;
- Garanta que as alterações não prejudiquem a funcionalidade existente;
- Identifique possíveis problemas antes que eles cheguem à produção

Ao escrever e manter um conjunto abrangente de testes, podemos fazer o seguinte:
- Entender melhor o comportamento do sistema;
- Detectar bugs logo no início do processo de desenvolvimento, quando eles são mais simples e baratos de corrigir;
- Reduzir a probabilidade de introduzir regressões;
- Garantir que os recursos atendam às especificações e manter a qualidade do código por meio de testes automatizados.

Essa abordagem não apenas melhora a qualidade do código, mas também aumenta a confiança como desenvolvedor. Podemos fazer alterações, adicionar recursos e refatorar com a certeza de que os nossos testes detectarão possíveis problemas. 

A confiança na codificação vem de uma combinação de conhecimento, experiência e ferramentas. Os testes automatizados são um parceiro poderoso na criação e manutenção da confiança em toda a nossa carreira de desenvolvimento.

## Leads to Consistency and Repeatability
Antigamente, os desenvolvedores dependiam de inúmeras horas de testes manuais. Criávamos uma lista de etapas para colocar pressão sobre o nosso novo recurso. Embora possamos ter seguido o roteiro na maior parte do tempo, uma abordagem manual é propensa a erros, não é repetível e exige muito trabalho e tempo. Os seres humanos são inerentemente incapazes de executar a mesma tarefa repetidamente sem variação.

Os testes automatizados oferecem resultados consistentes e repetíveis. Ao contrário dos seres humanos, os scripts de teste seguem exatamente as mesmas todas as vezes, sem erros ou omissões. Esses testes são executados rapidamente, com o mínimo de esforço, com o clique de um botão ou durante as complicações. Os testes de regressão verificam especificamente se a funcionalidade existente continua funcionando à medida que o nosso código é alterado.

Com um conjunto abrangente de testes, podemos garantir que eles sejam executados de forma consistente e repetida, independentemente do ambiente. Os testes automatizados podem ser executados com frequência, proporcionando testes de regressão eficazes. Esses testes garantem que os bugs corrigidos anteriormente não retornem misteriosamente; os testes também identificam novos bugs introduzidos por alterações na base de código. Ao testar um novo recurso, inore os caros testes manuais e confie nos testes automatizados. 

## Types of Automated Testing
Agora que já sabemos por que devemos testar, vamos explorar o que devemos e (não devemos) testar. Os testes automatizados são uma categoria ampla que abrange testes de interface do usuário, testes de ponta a ponta e testes de integração, bem como testes de unidade. É comum pensar nesses tipos de teste como uma pirâmide, conforme mostrado na Figura abaixo:
!![image-2026241912195.png](/image-2026241912195.png)

A pirâmide de testes é um conceito importante em testes de software, mas muitas vezes é mal compreendida ou totalmente ignorada. Criado por Mike Cohn, esse modelo fornece orientação visual para os tipos de testes que devemos ter em nosso aplicativo.

These are the three types of automated testing:
*Unit tests*
Designed to cover individual components for functions in isolation from the rest of the system, ensuring that each part works correctly on its own.

*Integration tests*
Verify how the different components or modules of a system work together as a cohesive unit.

*End-to-end tests*
Cobre todo o aplicativo, começando pela interface do usuário e indo até o sistema de back-end.

Essa estrutura é baseada em compensações fundamentais nos testes de software. À medida que subimos na pirâmide, os testes se tornam mais lentos de executar, mais caros de manter e mais propensos a quebrar. Um teste de unidade pode ser executado em microssegundos, enquanto um teste de ponta a ponta pode levar vários minutos. 

Quando temos centenas ou milhares de testes, essas diferenças aumentam drasticamente. Vamos dar uma olhada mais de perto em cada uma delas.

## Unit Tests
Os testes unitários formam a base da pirâmide de testes, representando a maior parte do nosso conjunto de testes. Podemos pensar neles como um contrato que o nosso código deve cumprir. Se o código for alterado de alguma forma funcional, os testes de unidade correspondentes deverão ser interrompidos, alertando-o sobre possíveis problemas. Esses testes examinam componentes ou funções individuais isoladamente, garantindo que cada parte funcione corretamente por si só.

Os testes unitários servem como a nossa primeira linha de defesa contra defeitos, trabalhando em conjunto com a análise estática e as revisões de código. Eles devem ser rápidos de escrever e executar, fornecendo feedback rápido durante o desenvolvimento. Quando um teste de unidade falha, ele normalmente aponta para uma função ou linha de código específica, o que facilita a depuração. Essa velocidade e precisão tornam os testes unitários inestimáveis durante o desenvolvimento de recursos e a integração contínua, dando aos desenvolvedores a confiança para iterar e melhorar o nosso código rapidamente.

## Integration Tests
Um teste de integração é um processo detalhado que verifica minuciosamente como diferentes componentes ou módulos de um sistema funcionam juntos como uma unidade coesa. Enquanto os testes de unidade se concentram em partes individuais do código isoladamente, os testes de integração abrangem um escopo mais amplo, examinando as interações entre essas partes.

No entanto, o foco ainda é mais restrito em comparação com os testes completos do sistema, que avaliam o desempenho e a funcionalidade de todo o sistema. Os testes de integração são essenciais porque ajudam a detectar problemas que surgem somente quando os componentes testados individualmente são combinados, garantindo que o sistema integrado funcione de forma correta e eficiente.

Essa etapa é essencial no SDLC para manter a integridade e a confiabilidade do sistema como um todo. Devido ao seu escopo e à sua complexidade, os testes de integração normalmente levam mais tempo para serem executados do que os testes de unidade e, em geral, são executados com menos frequência. Quando os testes de integração falham, geralmente é necessária mais investigação para identificar qual interação entre os módulos causou o problema.

## End-to-End Tests
Um teste end-to-end (E2E) é um procedimento de teste abrangente que cobra todo o aplicativo, começando pela interface do usuário e se estendendo até os sistemas de back-end. Esses testes são projetados para simular cenários reais de usuários, garantindo que o aplicativo funcione conforme o esperado em um ambiente real.

Devido à sua natureza complexo e minuciosa, esses testes geralmente são de execução lente e exigem recursos e tempo significativos para serem executados. Como resultado, geralmente encontraremos menos testes de ponta a ponta em comparação com outros tipos. Estes são mais frágeis e estão suscetíveis a falsos negativos (é possível que um teste falhe devido a uma alteração trivial em um elemento da interface do usuário, em vez de um problema real com a funcionalidade). A falha nos testes de ponta a ponta pode exigir esforços substanciais de depuração para identificar e corrigir o problema.

Os testes de ponta a ponta são inestimáveis, pois proporcionam um alto grau de confiança na funcionalidade geral do sistema, ajudando a garantir que todos os componentes do aplicativo funcionem juntos sem problemas.

## What Mix of Tests Should We Be Writing?
O número real de testes varia de projeto para projeto, dependendo da complexidade do aplicativo, da pilha de tecnologia que está sendo usada e a da importância do aplicativo. Além disso, o número de testes pode se basear  nos padrões e nas práticas de nossa organização, que podem incluir diretrizes específicas ou padrões de referência para a cobertura e a qualidade dos testes. É importante adaptarmos a nossa estratégia de teste para atender às necessidades exclusivas do nosso projeto e, ao mesmo tempo, garantir uma abordagem equilibrada que abranja todos os aspectos necessários do aplicativo.

## What We Should Not Test
Devemos ser estratégicos em relação ao que testamos. Citemos algumas diretrizes sobre o que deve ser evitado em nossa estratégia de teste:
- O nosso foco deve estar no código, e não devemos testar recursos de linguagem ou código de estrutura;
- Evitar testar o código gerado, como *getters* e *setters*, métodos construtores e objetos de transferência de dados (DTOs) gerados automaticamente;
- Evite testar métodos privados diretamente. Em vez disso, devemos nos concentrarmos na interface pública que chama esses métodos privados.
- Devemos evitar testes que dependam de serviços externos. Em vez disso, usemos *mocks* para testes de *unidade* ou <span style="background:#b1ffff">teste duplo para testes de integração.</span>

Um conjunto de testes bem projetado deve ser abrangente e de fácil manutenção, fornecendo cobertura completa sem se tornar pesado. Ao nos concentrarmos em testes o nosso próprio código e evitar testes desnecessários, podemos criar conjuntos de testes mais eficazes e eficientes. 

## Code Coverage
A cobertura de código é uma métrica usada para medir a porcentagem do nosso código que é executada quando os testes são executados. Pensemos na cobertura de código como um mapa em um jogo. Quando começamos, todo o mapa está escuro, mas à medida que começamos a nos movimentarmos e a explorar as áreas, elas se tornam visíveis. Os testes que executam partes do nosso código "iluminam" essas seções, mostrando que estivemos lá. Uma cobertura alta significa que exploramos a maior parte do mapa, enquanto uma cobertura baixa significa que há pontos cegos onde os bugs podem estar escondidos.

Como a cobertura de código é importante no mundo dos testes, encontramos uma variedade de IDEs que oferecem suporte à cobertura de código, bem como ferramentas para a linguagem de nossa escolha. Como desenvolvedor, podemos executar a cobertura diretamente em nossa IDE para obter feedback instantâneo sobre a cobertura. Há também ferramentas que se integram ao pipeline de CI/CD para impor um limite mínimo de cobertura de código. Se a cobertura ficar abaixo desse limite, elas podem falhar, o que, por sua vez, impede que um PR seja mesclado. 

As ferramentas de cobertura de código analisam as nossas execuções de teste e geram relatórios que mostram exatamente quais linhas, ramificações e funções foram executadas. Podemos ver porcentagens como *85% line coverage* ou *75% branch coverage*, indicating how much of our code was executed during the testing.

Embora a cobertura de código forneça informações valiosas, é importante entender suas limitações. Um equívoco comum é que uma cobertura de código mais alta significa automaticamente um teste melhor. Algumas organizações chegam e exigir limites mínimos de cobertura de 80% a 90% antes que o código possa ser implantado. 

Como desenvolvedor, podemos escrever testes que executam o código sem realmente verificar o comportamento significativo, essencialmente "manipulando" as métricas de cobertura. Um teste que chama um método, mas não afirma nada de útil, ainda conta para a cobertura, mas não oferece nenhuma proteção real contra bugs.

Ao invés de nos esforçarmos para obtermos 100% de cobertura, que geralmente é uma métrica de vaidade, podemos utilizá-la como um mecanismo de feedback para os testes que estamos escrevendo. A baixa cobertura na lógica comercial de missão crítica pode indicar uma área do código que precisa de mais atenção. A alta cobertura em áreas que estamos simplesmente testando classes de suporte de dados ou configuração pode sugerir que estamos testando um código que não precisa disso.

Devemos nos concentrarmos em escrever testes significativos que verifiquem o comportamento e deixe que a cobertura do código nos guie para as áreas do código que precisam de mais atenção. O objetivo não é atingir um número arbitrário, apenas para atender a um requisito, o objetivo dos testes é criar confiança no código que estamos escrevendo e, por fim, enviar para a produção. 

---
Leitura do livro:
1. Leitura preliminar (exploratória):
Objetivo *construir um mapa mental* do conteúdo
- Ler título, subtítulos e seções;
- Ver figuras, tabelas, notas de rodapé;
- Dar folheada geral;

1. Leitura Seletiva: 
*Objetivo:* encontrar informações específicas
- Procurar definições
- Exemplos, fórmulas, palavras-chave
- Ler só trechos relevantes

**Quando usar:** 
- Revisões;
- Consulta rápida;
- Resolver exercícios;

**Leitura analítica (profunda)**
- Ler devagar;
- Parar e meditar sobre o assunto
- Relacionar os conceitos (banco de dados postgresql)
- Anotações à margem (transcrita) 

**Leitura de Revisão** (exercícios)
- Relendo problemas 
- Responder algumas perguntas mentalmente
- Revisar mapa mental


