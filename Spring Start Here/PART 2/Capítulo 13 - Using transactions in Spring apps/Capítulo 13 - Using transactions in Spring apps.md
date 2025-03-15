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

#Rollback: a transação termina com rollback quando o aplicativo restaura os dados ao estado em que estavam no início da transação para evitar inconsistências nos dados.

## 13.2 How transactions work in Spring
Vamos discutir como as transações funcionam no Spring e as capacidades que o framework oferece para implementar código transacional. Na verdade, um aspecto AOP do Spring fica por trás de uma transação. 

Um aspecto é um trecho de código que intercepta a execução de métodos específicos de uma maneira que a gente define. Na maioria dos casos, <span style="background:#d4b106">usamos anotações para marcar os métodos cuja execução um aspecto deve interceptar e alterar</span>. Para transações no Spring, as coisas não são diferentes. Para marcar um método que queremos que o Spring envolva em uma transação, usamos uma anotação chamada *@Transactional*. Nos bastidores, o Spring configura um aspecto (não implementamos esse aspecto; o Spring fornece) e aplica a lógica de transação para as operações executadas por aquele método.

![[Capítulo 13 - Using transactions in Spring apps.png]]
1. Algo (por exemplo, uma ação do controller) chama o método de serviço *service*. Como o método está anotado com *@Transactional*, o Spring configura  um aspecto que intercepta a chamada.
2. Esta é uma representação simplificada da lógica do aspecto de transação do Spring. 