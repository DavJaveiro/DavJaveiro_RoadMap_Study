*This chapter covers*
- Understanding REST services;
- Implementing REST endpoints;
- Managing the data that the server sends to the client in the HTTP response;
- Obtaining data from the client in the HTTP;
- Managing exceptions at the endpoint level.

Nos capítulos 7 a 9, mencionei os serviços de *Representational State Transfer (REST)* algumas vezes em relação a aplicações web. Neste capítulo, expandimos a discussão sobre os serviços REST, e aprenderemos que eles não estão relacionados apenas a aplicativos web.

Os serviços REST são uma das formas mais comuns de implementar a comunicação entre dois aplicativos. O REST oferece acesso à funcionalidades que o servidor expõe por meio de *endpoints* que um cliente pode chamar.

Usamos serviços REST para estabelecer a comunicação entre um cliente e um servidor em um aplicativo web. Mas também podemos usar serviços REST para desenvolver a comunicação entre um aplicativo móvel e um *backend* ou o mesmo entre dois serviços de *backend.*

![[Capítulo 10 - Implementing REST services.png]]
REST services are a communication method between two apps. Today, you can find REST services in many places. A web cliente app or mobile app may call its backend solution through REST endpoints, but even backend services might communicate using REST web service calls.

- Um endpoint REST é uma forma para implementar a comunicação entre dois aplicativos. Um desses aplicativos expõem uma funcionalidade tornando isto acessível através do protocolo HTTP;
- Um exemplo de aplicativo que pode usar um *endpoint REST* é um aplicativo móvel que se comunica com sua solução *backend*. A comunicação entre um aplicativo móvel e seu serviço de *backend* pode ser implementada por meio de *endpoints REST*.
- Um aplicativo web também pode usar REST para se comunicar com os serviço *BACKEND*. Em muitos casos atualmente, <span style="background:#d4b106">os aplicativos web são implementados como soluções JavaScript separadas</span>, executadas no navegador. Essas soluções, geralmente desenvolvidas como frameworks como *Angular*, ReactJS ou Vue.js, chamam endpoints REST para se comunicar com seus backends.

Como, em muitos aplicativos atuais, há grandes chances de encontrarmos e trabalharmos com serviços REST, considero esse assunto um conhecimento essencial para todo desenvolvedor Spring.

Começaremos discutindo o que exatamente são os serviços REST na seção 10.1. Aprenderemos que o Spring oferece suporte a serviços REST com o mesmo mecanismo do Spring MVC que discutimos nos capítulos 7 a 9.

Na seção 10.2, abordaremos as sintaxes essenciais que precisamos conhecer ao trabalhar com *endpoints REST*. Trabalharemos em vários exemplos para detalhar os aspectos críticos que todo desenvolvedor Spring precisa saber ao implementar a comunicação entre dois aplicativos usando serviços REST.

## 10.1 Using REST services to exchange data between apps
Nesta seção, discutimos os serviços REST e a forma como o Spring oferece suporte à <span style="background:#d4b106">implementação deles por meio</span> do Spring MVC. Os *endpoints* REST são simplesmente uma maneira de implementar a comunicação entre dois aplicativos. *Endpoints REST* são tão simples quanto implementar uma ação de controller mapeada para um método HTTP e um caminho (path). Um aplicativo chama essa ação do controlador por meio de HTTP. Como é assim que um aplicativo expõe um serviço por meio de um protocolo web, chamamos esse *endpoint* de *web service*.

No final das contas, no Spring, um *endpoint REST* ainda é uma ação de controlador mapeada para um método HTTP e um caminho. o Spring usa o mesmo mecanismo que aprendemos para aplicativos web para expor *endpoints* REST. A única diferença é que, para serviços REST, diremos ao *servlet DISPATCHER* do Spring MVC para não procurar uma view. No diagrama do Spring MVC que aprendemos no capítulo 7, o *view resolver* desaparece. O servidor envia de volta, na resposta HTTP ao cliente, diretamente o que a ação do controlador retorna. A figura 10.2 apresenta as mudanças no fluxo do Spring MVC.  

![[Capítulo 10 - Implementing REST services-1.png]]

Descobriremos que os serviços REST são confortáveis de usar. Sua simplicidade é uma das razões pelas quais são tão frequentemente utilizados hoje em dia, e o Spring torna sua implementação direta. No entanto, antes de começarmos com nosso primeiro exemplo, gostaria de alertá-lo sobre alguns problemas de comunicação que um *endpoint REST* pode trazer:
- **Tempo de execução longo:** se a ação do controller demorar muito para ser concluída, a chamada HTTP ao endpoint pode expirar (time out) e interromper a comunicação. 
- **Grande volume de dados:** enviar uma grande de dados em uma única chamada (por meio da requisição HTTP) pode causar *time out* e interromper a comunicação. Enviar mais do que alguns megabytes em uma chamada REST geralmente não é a escolha certa.
- **Chamadas concorrentes excessivas:** muitas chamadas simultâneas a um *endpoint* exposto por um componente de *backend* pode sobrecarregar o aplicativo e causar falhas;


- **Confiabilidade da rede:** as chamadas HTTP dependem da rede, e a rede nunca é 100% confiável. Sempre há a possibilidade de uma chamada a um *endpoint REST* falhar devido a problemas de rede. ()
O *Internet* #Checksum (Soma de Verificação da Internet) é um método usado para detectar erros em pacotes de dados transmitidos pela rede. Ele garante que os dados não cheguem corrompidos ao destino.

1. **Geração do Checksum:** antes de enviar um pacote, o remetente calcula um valor de verificação (checksum) somando os dados do pacote e armazenando esse valor.
2. **Envio e Recepção:** o pacote é enviado junto com o checksum.
3. **Verificação no Destino:** o receptor recalcula o checksum com os dados recebidos.
	- Se os valores coincidirem, os dados estão íntegros.
	- Se forem diferentes, houve erro na transmissão e o pacote pode ser descartado ou retransmitido.


---

Ao implementar a comunicação entre dois aplicativos usando REST, sempre precisamos considerar o que deve acontecer se uma chamada falhar e como isso pode afetar o aplicativo. Pergunte-se:
- Os dados podem ser afetados de alguma forma?
- O design do seu aplicativo pode levar a inconsistência de dados se uma chamada a um *endpoint* falhar?
- Caso o aplicativo precise exibir um erro ao usuário, como faríamos isso?

Esses são problemas complexos e exigem conhecimentos de arquitetura que vão além do escopo deste livro. No entanto, recomendo *API Design Pattern de J.J. Geewax*, um guia excelente que discute as melhores práticas para o design de APIS.

## 10.2 Implementing a REST endpoint
Nesta seção, aprenderemos a implementar endpoints REST com Spring. A boa notícia é que o Spring utiliza o mesmo mecanismo do Spring MVC por trás dos endpoints REST, então já conhecemos uma grande parte de como eles funcionam. 

Vamos começar transformando a nossa classe *controller* web simples em um *controller REST* para implementar serviços web REST.

A listagem abaixo mostra uma classe controller que implementa uma ação simples. Como aprendemos no capítulo 7, anotamos a classe controller com a anotação estereotipada *@Controller*. Dessa forma, uma instância da classe se torna um bean no contexto do Spring, e o Spring MVC sabe que este é um controller que mapeia seus métodos para caminhos HTTP específicos. Além disso, usamos a anotação *@GetMapping* para especificar o caminho da ação e o método HTTP. A única novidade que entramos nesta listagem é o uso da anotação #requestBody. A anotação #requestBody  informa ao servlet dispatcher que a ação do controller não retorna o nome de uma view, mas os são dados enviados diretamente na resposta HTTP. 

Uma boa prática é evitar a duplicação de código. Queremos, de alguma forma, prevenir a repetição da anotação *@ResponseBody* para cada método. Para nos ajudar nesse aspecto, o Spring oferece a anotação *@RestController*, que é uma combinação de *@Controller* e *@ResponseBody*. Podemos usar *@RestController* para instruir o Spring que todas as ações do controller são endpoints REST. Dessa forma, evitamos repetir a anotação *@ResponseBody*. A listagem 10.3 mostra o que precisamos alterar no controller para usar *@RestController* uma vez para a classe, em vez de *@ResponseBody* para cada método.

[[HelloController.java]]
[[HelloControllerRest.java]]

Realmente é fácil implementar alguns endpoints. Mas como validamos se eles realmente funcionam? Vamos aprender a chamar nossos endpoints usando duas ferramentas que encontraremos frequentemente em cenários do mundo real:
- Postman - oferece uma interface gráfica agradável e é confortável de usar;

Ambas as ferramentas são essenciais para qualquer desenvolvedor. No capítulo 15, aprenderemos uma terceira abordagem para validar o comportamento de um endpoint, escrevendo um teste de integração.

Assim que pressionarmos o botão Send, o Postman enviará a solicitação HTTP. Quando a solicitação for concluída, o Postman exibirá os detalhes da resposta HTTP, conforme apresentado na figura 10.4.

Caso você não tenha uma interface gráfica (GUI), pode usar uma ferramenta de linha de comando para chamar um endpoint. Você também encontrará artigos e livros que frequentemente usam ferramentas de linha de comando para demonstrações, em vez de ferramentas gráficas, pois é uma maneira mais curta de representar o comando.

Se você optar por usar o **cURL** como uma ferramenta de linha de comando, como no caso do Postman, primeiro precisará garantir que ele esteja instalado. A instalação do cURL varia de acordo com o sistema operacional, conforme descrito na página oficial da ferramenta: [https://curl.se/](https://curl.se/).

Uma vez instalado e configurado, você pode usar o comando `curl` para enviar solicitações HTTP. O trecho a seguir mostra o comando que você pode usar para enviar uma solicitação HTTP e testar o endpoint `/hello` exposto pela nossa aplicação:
curl http://localhost:8080/hello

## 10.3 Managing the HTTP response
Nesta seção, discutimos como gerenciar a resposta HTTP na ação do controller. A resposta HTTP é a maneira como o aplicativo backend envia dados de volta ao cliente em resposta a uma solicitação do cliente. <span style="background:#d4b106">A resposta HTTP contém os seguintes elementos</span>:

- **Resposne headers** - pequenos fragmentos de dados na resposta (geralmente não mais do que algumas palavras);
- **Corpo da resposta (Response body)** - uma quantidade maior de dados que o backend precisa enviar na resposta.
- **Status da resposta (Response status)** - uma representação curta do resultado da solicitação.

Reserve alguns minutos para revisar o apêndice C e relembrar os detalhes sobre HTTP antes de prosseguir. Nas seções 10.3.1 e 10.3.2, discutiremos as opções que temos para enviar dados no corpo da resposta. Na seção 10.3.3, aprenderemos como definir o status e os cabeçalhos da resposta HTTP, se necessário.

### 10.3.1 Sending objects as a response body
Nesta seção, discutimos o envio de instâncias de objetos no corpo da resposta. A única coisa que precisamos fazer para enviar um objeto ao cliente em uma resposta é fazer com que a ação do controlador retorne esse objeto. No exemplo "sq-ch10-ex3", definimos um objeto de modelo chamado *Country* com os atributos *name* (representando o nome do país) e *population* (representando o número de milhões de pessoas localizadas naquele pais.). Implementamos uma ação do controller para retornar uma instância do tipo *Country*. 
A listagem a seguir mostra a classe que define o objeto *Country*. Quando usamos um objeto (como *Country*) para modelar os dados transferidos entre dois aplicativos, chamamos esse objeto de **objeto de transferência de dados (DTO, Data Transfer Object)**. Podemos dizer que *Country* é nosso DTO, cujas instâncias são retornadas pelo endpoint REST que implementamos no corpo da resposta HTTP.
[[Country.java]]
Para simplificar a criação de uma instância de *Country*, definimos um factory method que recebe o nome e a população. Esse método retorna uma instância de *Country* com os valores fornecidos definidos.



