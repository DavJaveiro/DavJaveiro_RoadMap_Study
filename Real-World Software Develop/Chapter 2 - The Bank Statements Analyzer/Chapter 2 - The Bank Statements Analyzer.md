## The Challenge
A indústria de FinTech está em alta neste momento. Mark Erbergzuck percebe que gasta muito dinheiro em diferentes compras e se beneficiaria de um <span style="background:#affad1">resumo automático de suas despesas</span>. Ele recebe extratos mensais de seu banco, mas os considera um pouco sobrecarregados. Ele encarregou você de desenvolver um _software_ que automatize o processamento de seus extratos bancários para que possa obter melhores insights sobre suas finanças. _Challenge accepted!_

## The Goal
Neste capítulo, você aprenderá as bases de um bom desenvolvimento de _software_ antes de avançar para técnicas mais complexas nos próximos capítulos. 

Começaremos implementando a definição do problema em uma única class. Em seguida, exploraremos por que essa abordagem traz vários desafios em termos de lidar com requisitos em mudança e na manutenção do projeto. 

Aprenderemos princípios e técnicas de *software design* para garantir que o *código* que escreveremos atenda a esses critérios. 

Conheceremos o #SRP Single Responsibility Principle, que ajuda a desenvolver software mais fácil de manter, mais simples de compreender e que reduz a possibilidade de introduzir novos bugs. Ao longo do caminho, aprenderemos também novos conceitos como *cohesion* e *coupling*, que são características úteis para orientar a qualidade do código e do software que desenvolveremos.

### **Requisitos do Bank Statements Analyzer**
ocê tomou um delicioso _hipster latte_ (sem açúcar) com Mark Erbergzuck para levantar os requisitos. Como Mark é bastante _tech-savvy_, ele explicou que o _bank statements analyzer_ precisa apenas ler um arquivo de texto contendo uma lista de transações bancárias. Ele baixa esse arquivo de seu portal de _online banking_. Esse texto é estruturado no formato _comma-separated values (CSV)_.
```csv
30-01-2017,-100,Deliveroo
30-01-2017,-50,Tesco
01-02-2017,6000,Salary
02-02-2017,2000,Royalties
02-02-2017,-4000,Rent
03-02-2017,3000,Tesco
05-02-2017,-30,Cinema
```

Ele gostaria de obter respostas para a seguintes consultas:
- Qual é o total de profits and loss da lista? O saldo é positivo ou negativo?
- Quantas transações bancárias existem em um determinado mês?
- Quais são suas top-10 gastos?
- Em qual categoria ele mais gasta dinheiro?

## KISS Principle
A primeiro consulta é: "qual é o total de profit and loss de uma lista de bank statements?"
Para isso, precisamos processar um arquivo CSV e calcular a soma de todos os valores. Como não há outros requisitos, podemos decidir que não é necessário criar uma aplicação complexa.

Seguindo o princípio KISS, o código pode estar em uma única classe. 

**NOTA**
O formato CSV não é totalmente padronizado. Muitas vezes é referido como valores separados por vírgulas. No entanto, algumas pessoas o consideram um formato *delimiter-separeted* que pode usar diferentes delimitadores, como ponto e vírgula ou tabulações. Esses requisitos podem adicionar mais complexidade à implementação de um *parser*. Neste capítulo, assumiremos que os valores são separados por vírgula ,

![[Real-World Software Develop/Chapter 2 - The Bank Statements Analyzer/bank-chapter-2/target/classes/br/com/byebyecupom/Main.class|Main]]

O código funciona, mas deixa de fora alguns corners cases que sempre é bom considerar ao escrever *production ready code*:
- E se o arquivo estiver vazio?
- E se o parsing do valor falhar porque os dados foram corrompidos?
- E se uma linha do statement tiver dados faltando?
Voltaremos ao tópico de tratamento de _exceptions_ no Capítulo 3, mas é um bom hábito manter esse tipo de questão em mente.

E quanto a segunda consulta: *quantas bank transactions existem em um determinado mês?*
O que você pode fazer? _Copy and paste_ é uma técnica simples, certo? Você poderia simplesmente copiar e colar o mesmo _code_ e substituir a lógica para que selecione o mês desejado, como mostrado no _Example 2-2_.
👉 Esse exemplo mostra como reutilizar a estrutura inicial, mas adaptando a filtragem para contar apenas as transações que pertencem ao mês especificado

### final Variables
Marcar uma variável local ou um *field* como *final* significa que ela não pode ser reatribuída. Usar ou não final em nossos projetos é uma decisão coletiva da equipe, já que seu uso possui tanto benefícios quanto desvantagens. Marcar o maior número possível de variáveis como *final* delimita claramente qual estado é mutado durante o ciclo de vida de um *object* e qual estado não é reatribuído.

O uso da palavra final não garante a imutabilidade do objeto em questão. É possível ter um final field que se refere a um objeto com estado mutável.
- final em Java garante que a variável não pode apontar para outro objeto depois de inicializada;
- Mas não garante que o objeto apontado é imutável.
- Se o objeto tiver estado mutável (por exemplo, uma List, um Map, ou uma classe com setters), ainda precisamos modificar o seu conteúdo.
**final congela a referência, não o objeto.**
O objeto pode mudar porque possuí *setters* (estado mutável)...

Uma área  em que há pouco sentido em usar a palavra-chave final, embora  Java permita, é em parâmetros de métodos abstratos; por exemplo, em *interfaces*. Isso ocorre porque a ausência de corpo significa que não há implicação ou significado real para a palavra *final*. 


## Code Maintainability and Anti-Patterns
Propriedades que o código deve ter:
- Deve ser simples localizar o código responsável por uma funcionalidade específica;
- Deve ser simples entender o que o código faz;
- Deve ser simples adicionar ou remover uma nova funcionalidade;
- Deve fornecer um bom encapsulamento. Em outras palavras, detalhes de implementação devem estar ocultos do usuário, tornando mais fácil compreender as mudanças.

Uma boa forma de pensar sobre o impacto do _code_ que você escreve é considerar o que aconteceria se um colega de trabalho tivesse que analisar seu _code_ daqui a seis meses, depois que você já tivesse mudado para outra empresa.

O nosso objetivo é gerenciar a complexidade da aplicação que estamos construindo, mas se continuarmos copiando e colando o mesmo código conforme novos requisitos surgem, acabaremos enfrentando os seguintes problemas, chamados de *anti-patterns* porque são soluções comuns, mas ineficazes:
- *Hard to understand code* porque teremos uma classe God enorme;
- *Code* frágil e facilmente quebrado por mudanças devido à duplicação do código;

**God Class**
Ao colocarmos todo o nosso código em um único arquivo, acabamos com uma classe enorme, tornando mais difícil compreender, já que essa classe será resonsável por tudo. Se for necessário atualizar a lógico do código existente (por exemplo, mudar como o *parsing* funciona), como localizar facilmente esse código e realizar mudanças? ctrl + f?? Esse é o problema do *anti-pattern* God Class. 

**Code Duplication**
Para cada consulta, estamos duplicando a lógica de leitura e parsing da entrada. E se a entrada deixar de ser um CSV e passar a ser um arquivo JSON? E se múltiplos formatos precisarem ser suportados? Adicionar esse tipo de funcionalidade será uma mudança dolorosa porque o nosso código está *hardcoded* para uma solução específica e duplicou esse comportamento em vários lugares. Consequentemente, todos esses pontos terão que ser alterados e poderemos introduzir novos bugs.

*Don't Repeat Yourself* DRY. Ao reduzirmos com sucesso a repetição, uma modificação da lógica não exige múltiplas alterações em nosso código.

Um problema relacionado é: e se o formato dos dados mudarem? O código só suporta um padrão específicos de formato. Se precisar ser expandido, ou se um formato diferente precisar ser suportado (por exemplo, nomes de atributos diferentes), novamente, será necessário fazer diversas alterações em todo o nosso código.

A conclusão é que é bom manter as coisas simples quando possível, mas não abusar do princípio *KISS*. Em vez disso, é necessário refletir sobre o *design* de toda a nossa aplicação e entender como dividir o problema em subproblemas separados, mais fáceis de gerenciar individualmente. O resultado será um código mais fácil de compreender, manter e adaptar a novos requisitos. 

## Single Responsibility Principle
É uma diretriz geral de desenvolvimento de software que ajuda a escrevemos código mais fácil de gerenciar e manter. Podemos pensar no SRP de duas maneiras complementares:
1. Uma classe deve ser responsável por **uma única funcionalidade**;
2. Deve existir **apenas um motivo** para uma classe mudar.

O SRP normalmente é aplicado a classes e métodos. Ele se preocupa com um comportamento, conceito ou categoria específicos. Isso leva a um código mais robusto, porque existe apenas um motivo específico para uma mudança, em vez de várias preocupações misturadas.

Ter múltiplas responsabilidades é problemático porque, isso complica a manutenção, podendo introduzir bugs em vários pontos do nosso sistema. Também torna o código difícil de entender e modificar. 

Então, como podemos aplicar o SRP o nosso exemplo?

O primeiro passo natural é extrair a lógica de análise (parsing) do CSV para uma classe separada, para que possamos reutilizá-la para diferentes consultas de processamento. Vamos chamá-la de *BankStatementCSVParser* para que fique imediatamente claro o que ela faz.

Podemos perceber claramente que a classe *BankStatementCSVParser* declara dois métodos, *parseFromCSV()* e *parseLinesFromCSV()*, que geram objetos *BankTranstion*, que é uma classe de domínio que modela um extrato bancário.

A classe *BankTransiction* é útil para que diferentes partes da nossa aplicação compartilhe o mesmo entendimento comum do que é um extrato bancário. Notaremos que a classe fornece a implementação para os métodos *equals* e *hashCODE*. 

Agora, as diferentes consultas que implementamos não precisam mais saber sobre os detalhes internos da análise (parsing), já que agora, podemos usar objetos *BankTransaction* diretamente para extrair as informações necessárias.  Declaramos os métodos *calculateTotalAmount()* e *selectInMonth()*, que são responsáveis por processar a lista de transações e retornar um resultado apropriado. 

O benefício chave com essa refatoração é que a nossa aplicação principal não é mais responsável pela implementação da lógica da análise., Ela está agora delegando essa responsabilidade para uma classe separada e métodos que podem ser mantidos e atualizados independentemente. Conforme novos requisitos surgem para diferentes consultar, podemos reutilizar a funcionalidade encapsulada pela classe **BankStatementCSVParser**.

## Cohesion
Aprendemos os três princípios: KISS, DRY e SRP. Precisamos revisar os conceitos para raciocinar sobre a qualidade do nosso código. Em engenharia de software, frequentemente iremos nos deparar com o termo #coesão como uma característica importante de diferentes partes do código que escrevemos. 

Coesão diz respeito a quão relacionadas as coisas são. Para ser mais preciso, a coesão mede quão fortemente relacionadas são as responsabilidades de uma classe ou método. Em outras palavras, **quanto as coisas estão fortemente acopladas?** É uma forma de nos ajudarmos a pensar sobre a complexidade do nosso sistema. O que queremos alcançar é **alta coesão**, o que significa que o código é mais fácil para os outros localizarem, entenderem e usarem.

No código que criamos anteriormente, a classe *BankTransactionsCSVParser* é altamente coesa. Ela agrupa dois métodos que **estão relacionados à análise (parsing)** de dados CSV. Geralmente, o conceito de coesão é aplicado a classes (coesão em nível de classe), mas também pode ser aplicado a métodos (coesão de nível de método).

**Para não esquecer a coesão:**
```java
public class BankStatementCSVParser {
	public BankTransaction parseFromCSV(final String lines) {...}
	
	public List<BankTransaction> parseLinesFromCsv(final List<String> lines)) {...} 
}
```

- Coesão em nível de classe;
- Coesão em nível de método;

Estamos com um exemplo de baixa coesão em nossa classe, pois os cálculos declarados em nossa classe principal não estão diretamente relacionados à análise...

Vamos agrupar as operações de cálculo em uma classe *BankStatementProcessor*.

```java
public class BankStatementProcessor {
	public double calculateTotalAmount() {...}
	
	public double calculateTotalInMonth(final Month month) {...}
	
	public double calculalteTotalForCategory(final Stirng category) {...}
}
```

### Class-Level Cohesion
Na prática, encontraremos pelo menos seis maneiras comuns de agrupar métodos:
- Funcional
- Informacional
- Utilitária
- Lógica
- Sequencial
- Temporal

Se os métodos que estamos agrupando são fracamente relacionados, teremos uma baixa coesão.