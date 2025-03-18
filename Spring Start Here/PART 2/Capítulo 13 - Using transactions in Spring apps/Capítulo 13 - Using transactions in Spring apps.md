*This chapter covers*
- O que de fato é *transaction*;
- Como o Spring administra as transações;
- Utilizando transações em aplicações Spring.

Uma das coisas mais importantes que levamos em consideração ao gerenciar dados é <span style="background:#d4b106">manter a precisão dos dados</span>. Não queremos que cenários específicos de execução resultem em dados errados ou inconsistentes. Suponhamos que estejamos implementando uma aplicação que faz compartilhamento ou que compartilha dinheiro - uma carteira eletrônica. Nesse aplicativo, um usuário possui contas onde armazena seu dinheiro. Implementamos uma funcionalidade onde um usuário pode transferir o dinheiro de uma conta para outra. Considerando uma implementação simplista para o nosso exemplo, isso implica duas etapas:
1. Sacar dinheiro da conta de origem;
2. Depositar dinheiro na conta de destino.

Ambas as etapas são operações que alteram dados (**operações mutáveis**) e precisam ser bem-sucedidas para que a transferência de dinheiro seja executada corretamente. Mas e se a segunda etapa encontrar um problema e não puder ser concluída? Se a primeira for finalizada, mas a segunda não puder ser completada, os dados se tornarão inconsistentes.

Se a segunda etapa falhar, acabamos em uma situação em que o dinheiro foi retirado da conta de John, mas Jane nunca o recebeu. John ficará com $900, enquanto Jane ainda terá apenas os $500. Para onde foram os $100? 

Para evitar cenários em que os dados se tornem inconsistentes, precisamos garantir que ambas as etapas sejam executadas corretamente ou que nenhuma delas seja. As transações nos oferecem a possibilidade de implementar múltiplas operações de forma que ou todas sejam executadas corretamente ou nenhuma delas seja.

## 13.1 Transactions
Uma transação é um conjunto definido de operações mutáveis (operações que alteram dados) que podem ser executadas corretamente todas juntas ou nenhuma delas.<span style="background:#b1ffff"> Isso é chamado ou referido a </span>#Atomicidade  #atomicity. As transações são essenciais em aplicativos porque garantem que os dados permaneçam consistentes se qualquer etapa do caso de uso falhar quando o aplicativo já tiver alterado os dados. 

Vamos considerar as duas etapas já citadas:
1. Sacar dinheiro da conta de origem;
2. Depositar dinheiro na conta de destino.

Podemos iniciar uma transação antes da etapa 1 e encerrá-la após a etapa 2. Nesse caso, se ambas as etapas forem executadas com sucesso, quando a transação terminar (após a etapa 2), o aplicativo persiste as mudanças feitas por ambas as etapas. Também dizemos, nesse caso, que a transação "comita". A operação de *commit* acontece quando a transação termina e todas as etapas são executadas com sucesso, assim o aplicativo persiste as alterações dos dados.

#Commit: O término bem-sucedido de uma transação quando o aplicativo armazena todas as mudanças feitas pelas operações mutáveis de transação.

Se a etapa 1 for executada sem problemas, mas a etapa 2 falhar por qualquer motivo, o aplicativo reverte as mudanças feitas pela etapa 1. Essa operação é chamada de #rollback.

#Rollback: *a transação termina com rollback quando o aplicativo restaura os dados ao estado em que estavam no início da transação para evitar inconsistências nos dados*.

## 13.2 How transactions work in Spring
Vamos discutir como as transações funcionam no Spring e as capacidades que o framework oferece para implementar código transacional. Na verdade, um aspecto AOP do Spring fica por trás de uma transação. 

Um aspecto é um trecho de código que intercepta a execução de métodos específicos de uma maneira que a gente define. Na maioria dos casos, <span style="background:#d4b106">usamos anotações para marcar os métodos cuja execução um aspecto deve interceptar e alterar</span>. Para transações no Spring, as coisas não são diferentes. Para marcar um método que queremos que o Spring envolva em uma transação, usamos uma anotação chamada *@Transactional*. Nos bastidores, o Spring configura um aspecto (não implementamos esse aspecto; o Spring fornece) e aplica a lógica de transação para as operações executadas por aquele método.

![[Capítulo 13 - Using transactions in Spring apps.png]]
1. Algo (por exemplo, uma ação do controller) chama o método de serviço *service*. Como o método está anotado com *@Transactional*, o Spring configura  um aspecto que intercepta a chamada.
2. Esta é uma representação simplificada da lógica do aspecto de transação do Spring. Por padrão, <span style="background:#ff4d4f">se o método interceptado lançar qualquer exceção em tempo de execução</span>, o aspecto reverte a transação (rolls back transaction). Se o método interceptado não lançar uma exceção em tempo de execução, a transação é confirmada (commited).
3. The *@Transactional* annotation is what tells the Spring transaction aspecto to intercept this method.
```java
@Transactional
public void transferMoney() {
	// 1. withdraw money from the source account
	// 2. deposit money in the destionation account
}
```

Como toda chamada do método está encapsulada na transação, ambos os passos agora fazem parte da transação. Se o passo 1 for bem-sucedido, mas o passo 2 lançar uma exceção em tempo de execução, o aspecto de transação do Spring reverterá as alterações feitas no passo 1 utilizando a operação de reversão da transação (transaction rollback operation).

O Spring sabe reverter uma transação se o método lançar uma exceção em tempo de execução. Mas eu gostaria de enfatizar a palavra "lançar" (throws). Quando ensino Spring em sala de aula, os alunos frequentemente entendem que basta que alguma operação dentro do método transferMoney() lance uma exceção em tempo de execução. Mas isso não é suficiente! O <span style="background:#d4b106">método transacional deve propagar a exceção</span> para que o aspecto saiba que deve reverter as alterações. Se o método tratar a exceção dentro de sua lógica e não a propagar, o aspecto não conseguirá detectar que a exceção ocorreu. 

E quanto às exceções verificadas (checked exceptions) em transações?
Até agora, discutimos apenas as exceções em tempo de execução (runtime exceptions). Mas e as exceções verificadas? As exceções verificadas no Java são aquelas que precisamos tratar ou propagar com a cláusula *throws*; caso contrário, sua aplicação não irá compilar. Essas exceções também causam a reversão de uma transação se o método as lançar? Por padrão, não! **O comportamento padrão do Spring é reverter a transação apenas quando encontra uma exceção em tempo de execução**! É assim que as transações são usadas na maioria dos cenários reais. 

Ao lidar com uma exceção verificada, é necessário adicionar a cláusula *throws* na assinatura do método; caso contrário, o código não será compilado. Isso significa que sempre estaremos ciente de quando sua lógica pode lançar tal exceção. Por essa razão, situações representadas por exceções verificadas não são um problema que poderia causar inconsistência de dados, mas sim cenários controlados que devem ser gerenciados pela lógica implementada pelo desenvolvedor.

No entanto, se quisermos que o Spring também reverta transações para exceções verificadas, é possível alterar o comportamento padrão do framework. A anotação *@Transactional*, que aprenderemos na seção 13.3, possui atributos que permitem definir para quais exceções desejamos que o Spring reverta as transações.

Ainda assim, recomendamos que mantenhamos a nossa aplicação simples e, a menos que necessário, confie no comportamento padrão do framework.

## 13.3 Using transactions in Spring apps
Vamos começar com um exemplo que ensina como usar transações em um aplicativo Spring. Declarar uma transação em um aplicativo Spring é tão simples quanto usar uma anotação: *@Transactional* para <span style="background:#b1ffff">marcar um método que deseja que o Spring envolva em uma transação. </span> Não é necessário fazer mais nada. O spring configura um aspecto (aspect) que intercepta os métodos anotados com *@Transactional*. Esse aspecto inicia uma transação e, caso tudo ocorra bem, confirma as alterações do método; caso contrário, reverte as alterações se ocorrer alguma exceção em tempo de execução (*runtime exception*).

Escreveremos um aplicativo que armazena os detalhes das contas em uma tabela de banco de dados. Imagine que este é o backend de um aplicativo de carteira eletrônica que estamos implementando. Criar-se-á a funcionalidade de transferir dinheiro de uma conta para outra. **Para este caso de uso, será necessário usar uma transação para garantir que os dados permaneçam consistentes caso ocorra uma exceção**.

O design de classes do aplicativo que implementaremos é simples. Usamos uma tabela em um banco de dados para armazenar os detalhes das contas (incluindo o saldo).