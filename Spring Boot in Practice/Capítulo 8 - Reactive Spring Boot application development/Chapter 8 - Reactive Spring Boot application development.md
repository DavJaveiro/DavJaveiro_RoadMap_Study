This chapter covers
- Introducing reactive programming with Spring WebFlux;
- Developing reactive RESTful APIs with annotated controller and functional endpoints;
- Accessing reactive RESTful APIs with WebClient
- Developing Spring Boot applications with RSocket
- Using WebSocket and Spring Boot to develop application

O Spring Framework oferece uma pilha de tecnologia alternativa com o **Spring WebFlux** para desenvolver aplicações reativas. O Spring WebFlux, que é baseado no **Project Reactor**, oferece utilitários que permitem projetar aplicações reativas com controles como **nonblocking, backpressure**, e escrita de código de forma **declarativa**. Ele também fornece o utilitário **WebClient** com uma fluent API para consumir as APIs.

Neste capítulo, veremos os protocolos **RSocket** e **WebSOCKET**, que oferecem <span style="background:#b1ffff">suporte à comunicação</span> **bidirecional** entre as partes comunicantes. Por fim, demonstraremos como usar esses protocolos em uma aplicação Spring Boot.

## 8.1 Introduction to reactive programming
**Programação reativa** é a programação com fluxo de dados assíncronos. Vamos abordar o conceito de fluxo de dados assíncrono discutindo os termos assíncrono e fluxo de dados (data stream).

Um fluxo de dados refere-se a uma sequência de dados em que as informações são **emitidas**, uma após a outra, dentro de um **intervalo de tempo**. Esse fluxo pode ser criado a partir de diversas fontes: **entradas de usuário**, **propriedades**, **caches**, **bancos de dados**, entre outros.
Vamos entender melhor esse conceito por meio de uma comparação entre o **processamento de dados tradicional** e o **processamento baseado em fluxos** (*stream processing*). 

![image-20251064126891.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251064126891.png)
Na figura, temos o método tradicional de processamento de dados, onde uma requisição do usuário é recebida pela aplicação, e os dados solicitados são recuperados do banco de dados pela aplicação. Em seguida, esses dados recuperados são **processados** e **retornados ao usuário**.

Já, ao lado direito, demonstramos o **processamento de fluxo (stream processing).** Nesse modelo, a aplicação se inscreve (subscribe) em um **fluxo de dados** (data stream) e recebe os dados assim que eles estão disponíveis. A aplicação então processa os dados e publica o resultado em outro fluxo. Na figura, há um fluxo de números ao qual a aplicação está inscrita. À medida que a aplicação recebe o fluxo de dados, ela processa cada elemento multiplicando por dois, e os resultados são publicados em outro fluxo.

Agora, vamos discutir o conceito de **processamento assíncrono**. O termo assíncrono significa que, para uma requisição, a resposta associada é retornada apenas quando estiver pronta, sem que a thread chamadora precisar aguardar por ela. A figura 8.2 mostra uma comparação entre o **processamento síncrono (syncronous)** e o **assíncrono**":

![image-20251062133192.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251062133192.png)

Antes de prosseguirmos, vamos discutir um **exemplo do mundo real** de **fluxos de dados assíncronos**. Os **eventos de clique do mouse** são um exemplo clássico. Os usuários de uma aplicação podem **clicar em um botão** e **gerar um evento**, que pode ser observado e reagido através de alguma ação na aplicação. Podemos imaginar esses eventos como um fluxo contínuo de eventos assíncronos. 

Logo, um fluxo (stream) é uma **sequência contínua de eventos ordenados no tempo**. Um fluxo pode emitir três tipos de sinais:
- um valor,
- um erro, ou
- um sinal de conclusão (complete signal)

O valor indica que o fluxo **emitiu uma informação** sobre a qual uma função pode ser aplicada para realizar alguma ação.
O erro significa que o fluxo **produziu uma falha**, permitindo acionar um **mecanismo de tratamento de erros( erros handling)**.
Por fim, o sinal de conclusão marca o fim do fluxo. 

Os eventos são **emitidos de forma assíncrona**, e nós ouvimos (listen) esses eventos definindo funções que reagem quando eles ocorrem, por exemplo:
- uma função para os dados emitidos
- uma para erros, e
- outra para a conclusão do fluxo.

Na programação reativa, esse ato de "ouvir" é chamado de **subscribing**. As **funções** que reagem aos eventos são chamadas de **observers** (observadores), e o fluxo de dados é o **observable** (observável), que está sendo observado. Este conceito é conhecido como o **padrão de projeto Observer (observer design pattern)**.

**Note**
O #SpringWebFlux e a programação reativa em geral, é um tema extenso, e está além do escopo deste texto oferecer uma discussão mais aprofundada sobre o assunto.

Neste capítulo, nosso objetivo é introduzir a programação reativa e demonstrar como desenvolver aplicações reativas com Spring Boot. 

### 8.1.1 Backpressure
Vamos aprender outro conceito importante na programação reativa: o #backpressure.

No entanto, antes de discutir esse conceito, é importante entender as noções de métodos push e pull em uma relação de produtor e consumidor. 

Um consumidor se inscreve (subscribes) para receber dados de um **produtor**, e o **produtor envia (pushes)** esses dados ao consumidor. 
![image-20251061830250.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251061830250.png)

Na figura cima, um produtor    envia (pushes) eventos para o consumidor inscrito (subscribed  consumer). Essa configuração funciona bem quando a taxa de consumo do consumidor é igual à taxa de envio do produtor. 

No entanto, o que acontece se o consumidor processar os eventos mais lentamente do que o produtor os envia? Nesse caso, o consumidor pode colocar os eventos em uma fila (buffer) para armazená-los temporariamente.

![image-20251062249380.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251062249380.png)

O consumidor pode escolher entre um **buffer limitado** (bounded) ou um buffer ilimitado (unbounded) para armazenar os eventos adicionais.

Com um **bounded buffer**, alguns eventos serão descartados, pois o buffer possui **espaço limitado**. Neste caso, o produtor pode precisar reenviar os eventos perdidos, o que implica sobrecarga adicional de rede, processamento de CPU e uma configuração mais complexa de processamento de eventos.

Por outro lado, um **unbounded buffer** pode levar a um **erro de falta de memória (out of memory error)** se o buffer se encher rapidamente de eventos, podendo causar a indisponibilidade da aplicação. 

Para evitar esse problema, podemos optar pelo método pull em vez do push. 
No método pull, o consumidor solicita eventos ao produtor de acordo com sua capacidade de processamento, conforme mostrado na figura 8.6.

Na figura 8.6, o consumidor solicita três eventos ao produtor, e este retorna três eventos. Esse processo permite que o consumidor **decida dinamicamente quantos eventos deseja receber do produtor**, com base em sua capacidade,  e isso é conhecido como backpressure.

### 8.1.2 Benefits of reactive programming
- **No Blocking** - normalmente, no modelo de programação traidiconal, os desenvolvedores escrevem códigos bloqueantes. Por exemplo, a thread chamadora precisa aguardar os dados ao acessar uma API remota ou realizar uma chamada ao banco de dados. Embora funcione, este apresenta problemas de **escalabilidade e desempenho**, além de **desperdiçar recursos do sistema** apenas esperando os dados. O modelo reativo elimina esses gargalos.

- **Melhor modelo assíncrono na JVM** - O Java oferece duas abordagens principais para **programação assíncrona:** 
	- Callback
	- Future
Com #Callback, um método assíncrono recebe um **parâmetro extra** que é **invocado quando o resultado está disponível.** Com **Future**, os métodos assíncronos retornam imediatamente um Future< T>, enquanto o valor T é computador de forma assíncrona e encapsulado dentro do Future. O resultado dentro do **Future** só fica acessível **quando estiver pronto**.

- **Callbacks** são difíceis de compor e podem gerar o famoso **callback hell** (aninhamento excessivo e difícil de gerenciar).
- **Futures** são uma melhoria, mas ainda **não oferecem uma boa composição** de operações assíncronas.
- No modelo reativo, o código é **declarativo** — você define **o que deve ser feito**, e não **como deve ser feito**. Isso torna o código **mais legível** e **melhor estruturado**.
    
- Existe um **conjunto rico de operadores** que podem ser aplicados ao **data stream**.
    
- O **processamento** (ou as operações) **só começam quando o método `subscribe()` é invocado** no fluxo.
    
- O **conceito de backpressure** permite que o **consumidor sinalize ao produtor** quando a **taxa de emissão está muito alta**.

## 8.2 Understanding Project Reactor
