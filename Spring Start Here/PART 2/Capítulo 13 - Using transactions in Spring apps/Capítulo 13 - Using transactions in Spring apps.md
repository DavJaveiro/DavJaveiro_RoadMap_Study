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

O design de classes do aplicativo que implementaremos é simples. Usamos uma tabela em um banco de dados para armazenar os detalhes das contas (incluindo o saldo). Implementamos um repositório para manipular os dados dessa tabela e encapsulamos a lógica de negócio (o caso de uso de transferência de dinheiro) em uma classe de serviço. O método da classe de serviço que implementa essa lógica de negócio é onde precisamos utilizar uma transação. Exponhamos esse caso de uso implementando um endpoint na classe *controller*. Para transferir dinheiro de uma conta para outra, é necessário chamar esse endpoint. A figura abaixo ilustra o design de classes do nosso exemplo:
![[Capítulo 13 - Using transactions in Spring apps-1.png]]
- O *AccountController* é um REST controller que expõe o endpoint *POST /transfer*. Esse endpoint fornece uma maneira de chamar o caso de uso de transferência de dinheiro.
- A lógica do método *transferMoney()* implementa as etapas "sacar o dinheiro da conta de origem" e "depositar o dinheiro na conta de destino". <span style="background:#b1ffff">Essas são operações mutáveis</span>, por isso as encapsulamos **em uma transação** para garantir que, se alguma delas falhar, os dados possam ser revertidos para o estado em que estavam antes do início do caso de uso #rollback.
- O *TransferService* implementa o caso de uso de transferência de dinheiro por meio do método *transferMoney()*. <span style="background:#b1ffff">Precisamos executar esse método dentro de uma transação para garantir que evitamos inconsistências nos dados.</span>
- A classe *AccountRepository* implementa todas as operações que podem ser realizadas sobre a tabela *account* no banco de dados.

O aplicativo trabalha com apenas uma tabela no banco de dados, chamada *account*, que possui os seguintes campos:
- id - chave primária. Definimos este campo como um valor *INT* com auto incremento;
- name - Nome do proprietário da conta;
- amount - quantidade de dinheiro que o proprietário possui na conta.

Vamos criar dois registros que iremos utilizar para os testes futuramente:
```sql
INSERT INTO account VALUES (NULL, 'João Canabrava', 1000);
INSERT INTO account VALUES (NULL, 'Sr.Madruga)', 1000);
```

Também precisamos de uma classe model para os valores que criamos em nossa tabela: [[Account.java]]

Para implementar o caso de uso "transferir dinheiro", precisamos das seguintes funcionalidades na camada repository:
1. Encontrar os detalhes de uma conta usando o ID da conta;
	Usaremos o método *findAccountById(long id)*, que recebe o ID da conta como parâmetro e usa o JdbcTemplate para obter os detalhes da conta com aquele ID no banco de dados. 

2. Atualizar o valor de uma conta específica.
	Implementaremos um método chamado *changeAmount(long id, BigDecimal amount)*; esse método define o valor passado como o segundo parâmetro para a conta com o ID fornecido no primeiro parâmetro.

Vamos implementar essas funcionalidades como discutido no capítulo 10, utilizando o *JdbcTemplate*.

---
**Revisando o RowMapper**
O #RowMapper é uma interface do Spring Framework que tem como objetivo **mapear uma linha de um conjunto de resultados de uma consulta SQL para um objeto Java.** Ela é usada principalmente em conjunto com o *JdbcTemplate* para facilitar a conversão dos dados retornados do banco de dados em instâncias de objetos Java.

**Por que usar *RowMapper*?**
Quando realizamos consultas SQL no banco de dados, os resultados são retornados como um *ResultSet*, que é uma estrutura tabular onde cada linha contém colunas com os dados retornados. No entanto, para que esses dados sejam úteis dentro da aplicação, eles precisam ser convertidos para objetos Java correspondentes. O *RowMapper* abstrai esse processo, evitando a manipulação manual do *ResultSet* e tornando o código mais limpo e reutilizável.

**Funcionamento do RowMapper**
A interface *RowMapper< T>* possui apenas um método funcional:
```java
T mapRow(ResultSet resultSet, int rowNum) throws SQLExceptions;
```
- O *ResultSet resultSet* contém os dados retornados pela consulta.
- O *rowNum* representa o número da linha atual no conjunto de resultados.
- O método deve retornar um objeto do tipo T, que é a entidade que queremos mapear.

O #JdbcTemplate usa essa interface para percorrer cada linha do *ResultSet*, chamando o método *mapRow()* para convertê-la em um objeto do tipo *T*.

Para testar o aplicativo com mais facilidade, vamos adicionar também a capacidade de obter todos os detalhes da conta a partir do banco de dados, conforme mostrado na listagem a seguir. Utilizaremos essa funcionalidade ao verificar se o aplicativo funciona como esperado.

```java
@Repository
public class AccountRepository {
	// omitted code

	public List<Account> findAllAccounts() {
		String sql = "SELECT * FROM account";
		return jdbc.query(sql, new AccountRowMapper());
	}
}
```

Na classe de serviço, implementaremos a lógica para o caso de uso de *transferência de dinheiro*. A classe *TransferService* utiliza a classe *AccountRepository* para gerenciar os dados na tabela de contas. A lógica que o método implementa é a seguinte:
1. Obter os detalhes das contas de origem e destino para verificar o saldo em ambas;
2. Retirar o valor transferido da conta de origem, definindo um novo saldo que corresponde ao saldo atual menos o valor a ser transferido.
3. Depositar o valor transferido na conta de destino, definindo um novo saldo, que corresponde ao saldo atual da conta mais o valor transferido;

A Listagem 13.5 mostra como o método *transferMoney()* da classe de serviço implementa essa lógica. Observe que os pontos 2 e 3 definem operações mutáveis. Ambas  as operações alteram os dados persistidos (ou seja, atualizam os saldos das contas). Se não as envolvermos em uma transação, podemos acabar em situações onde os dados ficam inconsistentes devido à falha de uma das etapas.

Felizmente, só precisamos usar a anotação *@Transaction* para marcar o método como transacional e informar ao Spring que ele precisa interceptar as execuções desse métodos e envolvê-las em transações:

![[Capítulo 13 - Using transactions in Spring apps-2.png]]
1. **AccountController**: representa o controlador da camada de apresentação, responsável por receber as solicitações do usuário (por exemplo, uma requisição HTTP para realizar uma transferência);
2. **TransferService:** representa a camada de serviço, onde a lógica de negócios é implementada. Aqui, ocorre a chamada para os métodos que manipulam as contas.
3. **AccountRepository:** representa a camada de acesso ao banco de dados, onde são realizadas as operações como SELECT e UPDATE nas tabelas correspondentes às contas.
4. **Database:** o banco de dados onde as informações das contas são armazenadas.


## Using #Transactional
A anotação *@Transactional* também pode ser aplicada diretamente à classe. Se usada na classe (como apresentado no próximo trecho de código), a anotação se aplica a todos os métodos da classe. Frequentemente, em aplicativos do mundo real, a anotação *@Transactional* é utilizada na classe, pois os métodos de uma classe de serviço definem casos de uso e, em geral, todos os casos de uso precisam ser transacionais. Para evitar repetir a anotação em cada método. Por tanto, é mais fácil anotar a classe como um todo.
Quando a anotação *@Transactional* é usada tanto na classe quanto no método, a configuração no nível do método sobrescreve a da classe.

```java
public class TransferService {

	// Código omitido
	public void transferMoney(long idSender,
								long idReceiver,
								BigDecimal amount) {
								
								}
	)
}
```
Frequentemente, usamos a anotação *@Transactional* diretamente na classe. 

The next listing shows the implementation of the *getAllAccounts()* method, which returns a list of all the database's account records.

O diferencial desse exemplo é que utilizaremos um objeto do tipo *TransferRequest* como parâmetro da ação do controller *transferMoney()*. O objeto *TransferRequest* simplesmente modela o corpo da requisição HTTP. Os objetos como esse, cuja responsabilidade é modelar os dados transferidos entre dois aplicativos, são chamados de DTOs.

- *TransferRequest* é uma classe que serve para representar os dados que enviamos em uma requisição HTTP.
[[TransferRequest.java]]
Utilizamos um validador do *Jakarta Validation*.

Como podemos saber se a aplicação realiza o rollback caso algo no método lance uma exceção em tempo de execução?

**Nota:** uma das coisas mais importantes que temos como lição sobre aplicações é que nunca devemos confiar que algo funciona a menos que tenha testado adequadamente!

Enquanto não testarmos a nossa aplicação, podemos dizer que ela está em um **estado de Schrodinger**. Ela tanto funciona quanto não funciona até que provemos o seu estado! Vamos adicionar apenas um RunTimeException para realizar o teste.

![[Capítulo 13 - Using transactions in Spring apps-3.png]]

## Resumo
- Uma transação é um conjunto de operações que alteram dados, e essas operações ou são executadas juntas ou não são executadas de forma alguma. Em um cenário real, quase qualquer caso de uso deve ser parte de uma transação para evitar inconsistências de dados.