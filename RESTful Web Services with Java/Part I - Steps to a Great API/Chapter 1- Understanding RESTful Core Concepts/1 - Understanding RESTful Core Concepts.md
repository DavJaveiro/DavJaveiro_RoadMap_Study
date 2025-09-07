A história dos serviços web é uma jornada fascinante através da evolução das formas pelas quais os sistemas são construídos, distribuídos e dimensionados.

Inicialmente, a abordagem monolítica, que envolvia desenvolver tudo dentro de uma única aplicação e máquina, foi o método arquitetural padrão por muitos anos. Contudo, a necessidade de dividir o software em componentes distintos com responsabilidades separadas transformou a maneira como projetamos e implementamos sistemas.

A necessidade de integrar sistemas distribuídos compostos por softwares executando em máquinas distintas existe desde os primórdios da computação, e sua importância está aumentando, à medida que a forma como desenvolvemos software evolui dos monólitos em direção a arquiteturas mais distribuídas.

A disseminação global da internet, especialmente da World Wide Web, trouxe a padronização de protocolos de comunicação, como o Internet Protocol (IP), Transmission Control Protocol (TCP) e Hypertext Transfer Protocol (HTTP). O sucesso da WWW e seu suporte por diferentes dispositivos, sistemas operacionais e aplicações levou à ideia de que a infraestrutura da web poderia ser usada para conectar aplicações em geral. Foi nesse momento que o termo web services passou a ser adotado para designar o uso de tecnologias web na criação de APIs.

Neste livro, você adquirirá os conhecimentos necessários para estar pronto para desenvolver e dominar a criação de web services RESTful, partindo dos conceitos até a implementação completa, seguindo as melhores práticas do mercado.

Vamos iniciar compreendendo o que é a arquitetura Representational State Transfer (REST) e os serviços RESTful API, como esses termos diferem entre si, os princípios, níveis de maturidade e diretrizes, bem como o projeto que criaremos ao longo destes capítulos para aplicar esse conhecimento.

O seguintes tópicos serão abordados neste capítulo:
- Por que REST?
- Princípios da arquitetura REST
- Níveis de um API RESTful
- Representação de dados com JavaScript Object Notation (JSON)
- A importância de diretrizes para o desenvolvimento de APIs REST
- Casos de uso comuns de APIs REST
- Impacto da arquitetura no design de APIs REST
- Alternativas ao REST

## Why REST?
Para entender por que o REST é o estilo arquitetural dominante na maioria dos serviços web, precisamos compreender o que estava disponível antes da ascensão do REST e os desafios que tornaram essa mudança tão importante na forma como os serviços distribuídos são construídos. 

## The pre-REST era
Antes do REST, o cenário de serviços web era dominado por protocolos como o Simple Object Access Protocol (SOAP) e o Extensible Markup Language-Remote Procedure Call (XML-RPC). Esses eram padrões poderosos, mas complexos, que permitiam uma comunicação detalhada entre clientes e servidores. No entanto, frequentemente eram vistos como inconvenientes devido à sua natureza verbosa e aos requisitos rígidos impostos aos desenvolvedores.

O SOAP, por exemplo, exigia que os desenvolvedores escrevessem extensos documentos XML com chamadas e respostas específicas. Tornou-se notório por sua complexidade e dificuldade de depuração. Da mesma forma, o XML-RPC, embora mais simples que o SOAP, ainda envolvia uma sobrecarga significativa para requisições e respostas simples (por exemplo, formatação XML verbosa e complexa, serialização e desserialização, um protocolo baseado em texto e complexidade de análise sintática). Tanto o SOAP quanto o XML-RPC utilizavam o protocolo HTTP apenas como meio de transporte, duplicando, cada um à sua maneira, diversas funcionalidades já oferecidas pelo próprio protocolo HTTP e suportadas pela infraestrutura web existente. 

Para superar esses desafios e melhorar a forma como os sistemas se comunicam entre si, o REST foi criado e tem sido amplamente implementado desde a sua concepção.

## Understanding REST
O REST foi criado em 2000 por Roy Fielding em sua tese de doutorado. Eles propôs um novo jeito de construir serviços web que fossem mais simples, eficiente e escalável, em comparação com tecnologias antigas como SOAP e XML-RPC.

O REST aproveita o protocolo HTTP da forma como ele foi planejado, usando métodos como GET, POST, códigos de status, cache, etc. - para tornar a comunicação entre sistemas mais natural e alinhada com a própria estrutura da web.

Os **princípios fundamentais do REST** são:
- Sem estado (statelessness): cada requisição contém todas as informações necessárias;
- Interface uniforme: padronização na forma como os recursos são acessados.
- Cacheável: respostas podem ser armazenadas para melhorar o desempenho.
- Arquitetura cliente-servidor: separação entre interface e lógica de negócios. 

Quando uma API web segue todos esses princípios, ela é chamada de **RESTful API**.
Ou seja:
REST = estilo arquitetural
RESTful API = uma API que implementa corretamente esse estilo


## Unpacking RESTful
As APIs RESTful representam uma abordagem para projetar serviços web que seguem os princípios do REST, portanto, **não são a mesma coisa**.

Enquanto o REST fornece o **framework teórico** para a construção de sistemas escaláveis e interoperáveis, as APIs RESTful colocam esses princípios em prática, permitindo que os desenvolvedores criem APIs robustas, flexíveis, fáceis de entender, manter e estender.

A introdução das APIs RESTful marcou uma mudança significativa no cenário de serviços web, já que os desenvolvedores adotaram rapidamente o REST devido à sua simplicidade e á forma como facilitou o desenvolvimento de aplicações web escaláveis e com bom desempenho. As APIs RESTful tornaram-se a espinha dorsal da comunicação web, impulsionando desde plataformas de mídias sociais até sites de comércio eletrônico.

Agora que temos uma compreensão clara de REST e RESTful, vamos nos aprofundar nos princípios da arquitetura REST. Isso nos dará uma visão mais clara desses princípios fundamentais e de como implementá-los.

## Principles of REST architecture
Imagine um sistema de bibliotecas onde cada livro é um recurso identificado por um número ISBN - esse é o URI (identificação do recurso).
Quando desejamos pegar um livro emprestado, recebe uma representação do recurso (como uma ficha com título, autor, etc.). 
Essa ficha vem com instruções claras sobre como proceder (exÇ "apresente no balcão"), isso representa **mensagens auto-descritivas**.
Além disso, o catálogo da biblioteca sugere que outros livros do mesmo autor ou da mesma categoria, isso simula o **HATEOAS**, guiando-nos para próximos passos com base no estado atual da aplicação.

Em resumo, a interface uniforme torna as APIs RESTful previsíveis, padronizadas e fáceis de usar, porque todos os recursos são acessados e manipulados da mesma forma, seguindo convenções claras e bem definidas.

## Client-server separation
Esse princípio promove a separação de responsabilidades ao dividir as preocupações da interface do usuário das preocupações com o armazenamento de dados. Essa separação permite que os componentes cliente e servidor evoluam independentemente, resultando em uma arquitetura de aplicação mais flexível e escalável.
![image-20259718969.png](RESTful%20Web%20Services%20with%20Java/Part%20I%20-%20Steps%20to%20a%20Great%20API/Chapter%201-%20Understanding%20RESTful%20Core%20Concepts/1%20-%20Understanding%20RESTful%20Core%20Concepts/image-20259718969.png)
**Exemplo:** um usuário envia um formulário em um site com seus dados para finalizar uma compra (cliente enviando a requisição); esse envio será feito no formato **JSON**, utilizando o verbo HTTP POST, e será recebido pelo servidor. O servidor receberá os dados, criará um novo recurso com as informações do cliente, armazenará esses dados, realizará um novo pedido e retornará ao usuário uma resposta apropriada (por exemplo, um código de status HTTP 201 Created e os detalhes do pedido criado).

Esse fluxo ilustra claramente a separação entre cliente e servidor: o cliente se preocupa apenas com a interface e envio dos dados, enquanto o servidor lida com a lógica de negócio, persistência e resposta, ambos podendo ser desenvolvidos e atualizados independentemente, desde que a interface (API) permaneça compatível.

