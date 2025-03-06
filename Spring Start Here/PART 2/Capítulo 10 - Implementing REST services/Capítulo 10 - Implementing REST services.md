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
