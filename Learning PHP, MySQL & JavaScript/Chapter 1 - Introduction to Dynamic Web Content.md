A World Wide Web é uma rede em constante evolução que já foi muito além de sua concepção no início dos anos 90, quando foi criada para resolver um problema específico. Os experimentos de última geração no CERN (Laboratório Europeu de Física de Partículas, hoje mais conhecido como o operador do Grande Colisor de Hádrons) estavam produzindo quantidades incríveis de dados, tanto que era difícil distribuí-los aos cientistas participantes, que estavam espalhados pelo mundo.

Nessa época, a Internet já estava funcionando, conectando várias centenas de milhares de computadores, de modo que **Tim Berners-Lee** (um bolsista do CERN) desenvolveu um método de navegação entre eles usando uma estrutura de hiperlinks, que ficou conhecida como Hypertext Transfer Protocol, ou HTTP. Ele também criou uma linguagem de marcação chamada Hypertext Markup Language, ou HTML. Para reunir tudo isso, ele escreveu o primeiro navegador e servidor da Web.

> O advento da Web 1.0 A Web 1.0 recebeu esse nome somente quando o termo Web 2.0 foi cunhado. Durante a era 1.0, a maioria dos usuários eram consumidores de conteúdo e, embora houvesse algumas páginas pessoais na Web, não havia redes sociais. Alguns sites já usavam bancos de dados, mas os recursos do servidor e a largura de banda eram muito limitados. A navegação e o layout na Web 1.0 eram gerenciados com botões e gráficos simples, enquanto a interação era muito limitada.

Hoje em dia, consideramos essas ferramentas simples como algo natural, mas, naquela época, o conceito era revolucionário. O máximo de conectividade experimentada pelos usuários de modem em casa naquela época era discar e conectar-se a um quadro de avisos, onde era possível se comunicar e trocar dados apenas com outros usuários desse serviço. Consequentemente, era preciso ser membro de muitos sistemas de quadro de avisos para se comunicar eletronicamente de forma eficaz com seus colegas e amigos.

Mas Berners-Lee mudou tudo isso de uma só vez, e em meados da década de 1990, três grandes navegadores gráficos disputavam a atenção de cinco milhões de usuários.
Logo ficou óbvio, no entanto, que algo estava faltando. Sim, páginas de texto e gráficos com hyperlinks para levar você a outras páginas era um conceito brilhante, mas os resultados não refletiam o potencial instantâneo dos computadores e da internet para atender às necessidades específicas de cada usuário com conteúdo dinamicamente mutável. Usar a web era uma experiência muito seca e simples, mesmo com textos rolantes e GIFs animados!

Carrinhos de compras, mecanismos de busca e redes sociais alteraram claramente a forma como usamos a web. Neste capítulo, veremos brevemente os vários componentes que compõem a web e o software que ajuda a tornar sua utilização uma experiência rica e dinâmica.

> É necessário começar a usar algumas siglas mais cedo ou mais tarde. Tentei explicá-las claramente antes de prosseguir, mas não se preocupe muito com o significado desses nomes, pois os detalhes ficarão claros à medida que você ler.

## HTTP and HTML: Berners-Lee's Basics
HTTP é um padrão de comunicação que rege as requisições e respostas enviadas entre o navegador executado no computador do usuário final e o servidor web.

O trabalho do servidor é aceitar uma requisição do cliente e tentar respondê-la de maneira significativa, geralmente entregando uma página web solicitada, é por isso que o termo "servidor" é usado. A contraprte natural de um servidor é um cliente, então esse termo é aplicado tanto ao navegador web quanto ao computador no qual ele está sendo executado.

Entre o cliente e o servidor podem existir vários outros dispositivos, como roteadores, proxies, gateways e assim por diante. Eles desempenham diferentes funções para garantir que as requisições e respostas sejam transferidas corretamente entre o cliente e o servidor. Tipicamente, eles usam a internet para enviar essas informações. Alguns desses dispositivos intermediários também podem ajudar a acelerar a internet, armazenando páginas ou informações localmente no que é chamado de cache e então entregando esse conteúdo diretamente aos clientes a partir do cache, em vez de buscá-lo completamente no servidor de origem.

Um servidor web geralmente pode lidar com múltiplas conexões simultâneas e, quando não está se comunicando com um cliente, ele passa o tempo "ouvindo" por uma conexão de entrada. Quando uma chega, o servidor envia de volta uma resposta.

## The Request/Response Procedure
No seu nível mais básico, o processo de requisição/resposta consiste em um navegador web ou outro cliente pedir ao servidor web que envie uma página e o servidor web que envie uma página e o servidor enviar a página de volta. O navegador então cuida de exibir ou renderizar a página.
!![image-20263153517754.png](/image-20263153517754.png)

As etapas na sequência de requisição e resposta são:
1. Digitamos http://servidor.com na barra de endereços do nosso navegador.
2. O nosso navegador consulta o endereço de Protocolo de Internet (IP) para servidor.com
3. Seu navegador faz uma requisição para a página inicial em `servidor.com`
4. A requisição atravessa a internet e chega ao servidor web de `servidor.com`
5. O servidor web, tendo recebido a requisição, procura pela página web em seu disco
6. O servidor web recupera a página e a retorna para o navegador
7. O nosso navegador exibe a página web.

Em uma página da Web comum, esse processo também ocorre uma vez para cada objeto da página, como um gráfico, um vídeo incorporado ou uma folha de estilo CSS.

No passo 2, observamos que o navegador consulta o endereço IP de servidor.com. Toda máquina conectada à internet tem um endereço IP, incluindo o seu computador, mas geralmente acessamos os servidores web por nome, como google.com. O navegador consulta um serviço adicional de internet chamado Sistema de Nomes de Domínio (DNS) para encontrar o endereço IP associado ao servidor e então o utiliza para se comunicar com o computador.

