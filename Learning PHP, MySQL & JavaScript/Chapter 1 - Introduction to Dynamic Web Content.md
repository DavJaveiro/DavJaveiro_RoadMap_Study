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

Para páginas web dinâmicas, o procedimento é um pouco mais complexo, porque pode envolver tanto o PHP quanto o MySQL no processo. Por exemplo, podemos clicar na foto de uma capa de chuva. Então o PHP irá montar uma requisição usando a linguagem padrão de banco de dados, SQL, muitos cujos comandos aprenderemos neste livro, e enviar a requisição para o servidor MySQL. O servidor MySQL retornará informações sobre a capa de chuva que selecionamos, e o código PHP irá envolver tudo isso em HTML, que o servidor enviará para o seu navegador.

!![image-20263153229748.png](/image-20263153229748.png)

1. 1. Você digita `http://servidor.com` na barra de endereços do seu navegador.
2. Seu navegador consulta o endereço IP para `servidor.com`.
3. Seu navegador faz uma requisição para aquele endereço, solicitando a página inicial do servidor web.
4. A requisição atravessa a internet e chega ao servidor web de `servidor.com
5. O servidor web, tendo recebido a requisição, busca a página inicial em seu disco rígido.
6. Com a página inicial agora na memória, o servidor web percebe que é um arquivo que incorpora script PHP e passa a página para o interpretador PHP.
7. O interpretador PHP executa o código PHP.
8. 1. Parte do PHP contém instruções SQL, que o interpretador PHP agora passa para o mecanismo do banco de dados MySQL.
9. O banco de dados MySQL retorna os resultados das instruções para o interpretador PHP.
10. O interpretador PHP retorna os resultados do código PHP executado, juntamente com os resultados do banco de dados MySQL, para o servidor web.
11. O servidor web retorna a página para o cliente requisitante, que a exibe.

Embora seja útil estar ciente desse processo para saber como os três elementos funcionam juntos, na prática não precisamos nos preocupar com esses detalhes, pois tudo acontece automaticamente. As páginas HTML retornadas ao navegador em cada exemplo podem conter JavaScript, que será interpretado localmente pelo cliente e que pode iniciar outra solicitação.

## The Benefits of PHP, MySQL, JavaScript, CSS e HTML
No início deste capítulo, apresentei o mundo da Web 1.0, mas não demorou muito para que começasse a corrida para criar a Web 1.1, com o desenvolvimento de melhorias para navegadores como Java, JavaScript, Flash e ActiveX. No lado do servidor, avanços estavam sendo feitos no Common Gateway Interface (CGI) usando linguagens de script como Perl (uma alternativa ao PHP) e script no lado do servidor — inserindo dinamicamente o conteúdo de um arquivo (ou a saída da execução de um programa local) dentro de outro.

Quando a poeira baixou, três tecnologias principais se destacaram das demais. Embora Perl ainda fosse uma linguagem de script popular com muitos seguidores, a simplicidade do PHP e suas conexões integradas com o programa de banco de dados MySQL lhe renderam mais que o dobro de usuários. E o JavaScript, que havia se tornado uma parte essencial da equação para manipular dinamicamente o HTML, agora assumia a tarefa ainda mais robusta de lidar com o lado do cliente na comunicação assíncrona (troca de dados entre um cliente e servidor após o carregamento de uma página web). Usando comunicação assíncrona, as páginas web realizam manipulação de dados e enviam requisições para servidores web em segundo plano, sem que o usuário da web perceba que isso está acontecendo. 

Sem dúvida, a natureza simbólica e as licenças de código aberto do PHP e MySQL ajudaram a impulsionar ambos, mas o que atraiu os desenvolvedores para eles em primeiro lugar? A resposta simples é a facilidade com que podemos usá-los para criar rapidamente elementos dinâmicos em sites. MySQL é um sistema de banco de dados rápido, poderoso e fácil de usar que oferece praticamente tudo que um site precisa para encontrar e entregar dados aos navegadores.

E quando adicionamos JavaScript e CSS à mistura, temos uma receita para construir sites altamente dinâmicos e interativos, especialmente porque agora existe uma ampla game de frameworks sofisticados e funções JavaScript que podemos utilizar para acelerar o desenvolvimento web. Estes incluem o conhecido jQuery, que até recentemente era uma das formas mais comuns de programadores acessarem recursos de comunicação assíncrona.

A mais recente biblioteca JavaScript React também vem crescendo rapidamente em popularidade, e é agora um dos frameworks mais amplamente baixados e implementados, tanto que no momento em que este texto foi escrito, o site de empregos Indeed listava muito mais vagas para desenvolvedores React do que para jQuery.

React fornece funcionalidade de ponta para construir interações complexas de interface do usuário que se comunicam com o servidor em tempo real com páginas orientadas por JavaScript. Ele permite criar componentes que são os blocos de construção da aplicação React.

React fornece funcionalidade de ponta para construir interações complexas de interface do usuário que se comunicam com o servidor em tempo real com páginas orientadas por JavaScript. Ele permite criar componentes que são os blocos de construção da aplicação React. Um componente React pode ser qualquer coisa em sua aplicação web. Pode ser algo simples como um Botão, Texto, Rótulo ou Grade, ou até algo complexo como um widget de Login ou um modal popup com botões de controle. React também suporta renderização no servidor de seus componentes usando ferramentas como Next.js. Você pode até usar React em seus aplicativos existentes (ele foi projetado com isso em mente). Você pode mudar uma pequena parte da sua aplicação existente usando React e, se essa mudança funcionar, pode começar a converter toda a sua aplicação para React.js. No entanto, outros frameworks como Vue.js podem ser mais adequados para esse tipo de implementação iterativa.

## MariaDB: The MySQL Clone
Após a Oracle (a corporação de gerenciamento de banco de dados) comprar a Sun Microsystems (proprietária do MySQL), a comunidade ficou receosa de que o MySQL pudesse não permanecer totalmente código aberto, então o MariaDB foi criado a partir de um fork para mantê-lo livre sob a GNU GPL, a licença de software que garante aos usuários a liberdade de executar, estudar, compartilhar e modificar o software. O desenvolvimento do MariaDB é liderado por alguns dos desenvolvedores originais do MySQL, e ele mantém uma compatibilidade extremamente próxima com o MySQL. Portanto, é bem possível que você encontre o MariaDB em alguns servidores no lugar do MySQL — mas não se preocupe, tudo neste livro funciona igualmente bem tanto no MySQL quanto no MariaDB. Para todos os fins práticos, você pode substituir um pelo outro e não notar diferença.

Felizmente, muitos dos receios iniciais parecem ter sido amenizados, pois o MySQL permanece código aberto, com a Oracle cobrando apenas por suporte e por edições que fornecem recursos adicionais, como georeplicação e escalonamento automático. No entanto, diferentemente do MariaDB, o MySQL não é mais impulsionado pela comunidade, então saber que o MariaDB estará sempre disponível se necessário tranquilizará muitos desenvolvedores e provavelmente garantirá que o próprio MySQL permaneça código aberto.

## Using PHP
Com PHP, é simples incorporar atividade dinâmica em páginas web. Quando fornecemos a extensão *.php* às páginas, elas têm acesso instantâneo à linguagem de script. Do ponto de vista do desenvolvedor, tudo o que precisamos fazer é escrever código como:
```php
<?php
echo "Hoje é " . date("1"). ". ";
?>

Aqui estão as últimas nóticias
```

A abertura ``<?php`` informa ao servidor web para permitir que o programa PHP interprete todo o código seguinte até a tag ?>. 

Fora dessa construção, tudo é enviado ao cliente como HTML direto. Portanto, o texto "Aqui estão as últimas notícias" é simplesmente enviado para o navegador; dentro das tags PHP, a função embutido *date* exibe o dia atual da semana de acordo com a hora do sistema do servidor.

A saída final das duas partes se parece com isto:
```php
Hoje é <?php echo date("1";) ?>. Aqui estão as últimas notícias.
```

Existem ainda mais formas de formatar e exibir informações, que explicarei nos capítulos sobre PHP. O ponto principal é que, com PHP, os desenvolvedores web têm uma linguagem de script que, embora não seja tão rápida quanto compilar seu código em C ou linguagem similar, é incrivelmente rápida e também se integra perfeitamente com a marcação HTML.

Se você pretende digitar os exemplos de PHP deste livro em um editor de programas para acompanhar, lembre-se de adicionar `<?php` no início e `?>` após eles para garantir que o interpretador PHP os processe. Para facilitar, podemos preparar um arquivo chamado `example.php` com essas tags já inseridas.

Usando PHP, temos controle ilimitado sobre o nosso servidor web. Seja para modificar HTLM dinamicamente, processar um cartão de crédito, adicionar detalhes de usuário a um banco de dados ou buscar informações de um site de terceiros, podemos fazer tudo isso dentro dos mesmos arquivos PHP nos quais o próprio HTML reside.

## Using MySQL
Claro, não faz muito sentido ser capaz de alterar a saída HTML dinamicamente a menos que você também tenha uma forma de rastrear as informações que os usuários fornecem ao seu site enquanto o utilizam. Nos primórdios da web, muitos sites usavam arquivos de texto "planos" para armazenar dados como nomes de usuário e senhas. Mas essa abordagem poderia causar problemas se o arquivo não estivesse corretamente bloqueado contra corrupção devido a múltiplos acessos simultâneos. Além disso, um arquivo plano só pode crescer até certo ponto antes de se tornar difícil de gerenciar — sem mencionar a dificuldade de tentar mesclar arquivos e realizar buscas complexas em um tempo razoável.

É aqui que os bancos de dados relacionais com consultar estruturadas se tornam essenciais. E o MySQL, pode ser gratuito e instalado em um vasto número de servidores web na internet, surge perfeitamente para a ocasião. Ele é um **sistema de gerenciamento de banco de dados** robusto e excepcionalmente rápido que usa comandos similares ao inglês.

<span style="background:#d3f8b6">O nível mais alto da estrutura do MySQL é um banco de dados</span>, dentro do qual você pode ter uma ou mais tabelas que contêm seus dados. Isso é semelhante, digamos, a um arquivo de planilha Excel que consiste em múltiplas abas: o arquivo da planilha pode ser visto como um banco de dados e as abas individuais como tabelas.

Vamos supor que você esteja trabalhando em uma tabela chamada `usuarios`, dentro da qual você criou colunas para `sobrenome`, `nome` e `email`, e agora deseja adicionar outro usuário. Um comando que você poderia usar para isso é:
```sql
INSERT INTO usuarios VALUES('Silva', 'João', 'joao.silva@meusiste.com');
```

Você terá emitido **outros comandos anteriormente** para criar o banco de dados e a tabela e configurar todos os campos corretos, mas o comando *SQL INSERT* aqui mostra como pode ser simples adicionar novos dados a um banco de dados.

É igualmente fácil consultar dados. Vamos supor que você tenha o endereço de e-mail de um usuário e precise encontrar o nome dessa pessoa. Para isso, você poderia emitir uma consulta MySQL como:
```sql
SELECT sobrenome, nome FROM usuarios WHERE email='joao.silva@meusite.com';
```

O MySQL então retornará Silva, João e quaisquer outros pares de nomes associados a esse endereço de e-mail no banco de dados.

Como você pode imaginar, há muito mais que você pode fazer com MySQL do que apenas comandos simples INSERT e SELECT. Por exemplo, você pode combinar conjuntos de dados relacionados para trazer informações relacionadas, solicitar resultados em diversas ordens, <span style="background:#affad1">fazer correspondências parciais</span> quando você conhece apenas parte da string que está procurando, retornar apenas o enésimo resultado, e muito mais.

Usando PHP, <span style="background:#affad1">você pode fazer todas essas chamadas ao MySQL sem ter que acessar diretamente a interface de linha de comando do MySQL</span>. Isso significa que você pode salvar os resultados em arrays para processamento e realizar múltiplas consultas, cada uma dependente dos resultados retornados pelas anteriores, para aprofundar até o item de dados que você precisa.

Para ainda mais poder, como veremos mais tarde, funções adicionais são incorporadas diretamente ao MySQL para que possamos executar operações comuns de forma eficiente dentro do MySQL, em vez de criá-las a partir de múltiplas chamadas PHP ao MySQL.

## Using JavaScript
O JavaScript foi criado para permitir acesso via script a todos os elementos de um documento HTML. Em outras palavras, ele fornece um meio para interação dinâmica do usuário, como verificar a validade de endereços de e-mail em formulários de entrada e exibir avisos como "Você realmente quis dizer isso?" (embora não se possa confiar nele para segurança, que deve sempre ser realizada no servidor web).

Combinado com CSS (veja "Usando CSS" na página 10), o JavaScript é a força por trás de páginas web dinâmicas que mudam diante dos seus olhos, em vez de quando uma nova página é retornada pelo servidor.

No entanto, o JavaScript costumava ser complicado de usar, devido à forma como a linguagem foi inicialmente projetada e a algumas grandes diferenças na forma como diferentes navegadores escolheram implementá-lo. Isso aconteceu quando alguns fabricantes tentaram colocar funcionalidades adicionais em seus navegadores em detrimento da compatibilidade com seus rivais. Felizmente, a linguagem evolui, e os desenvolvedores de navegadores voltaram à razão, percebendo a necessidade de total compatibilidade entre si, então é menos necessário hoje em dia otimizar seu código para diferentes navegadores.

Por enquanto, vamos ver como usar o JavaScrpit básico, aceito por todos os navegadores:
```js
<script>
document.write("Hoje é " + Date() );
</script>
```

Este trecho de código instrui o navegador web a interpretar tudo dentro das tags *script* como JavaScript, o que o navegador faz escrevendo o texto "Hoje é" no documento. Em outras palavras, ela fornece um meio para interação dinâmica do usuário, como verificar a validade de endereços de e-mail em formulários de entrada e exibir avisos como "Você realmente quis dizer isso?" (embora não se possa confiar nela para segurança, que deve sempre ser realizada no servidor web).

Combinado com CSS (veja "Usando CSS" na página 10), JavaScript é a força por trás de páginas web dinâmicas que mudam diante dos seus olhos, em vez de quando uma nova página é retornada pelo servidor.

No entanto, JavaScript costumava ser complicado de usar, devido à forma como a linguagem foi inicialmente projetada e a algumas grandes diferenças na forma como diferentes navegadores escolheram implementá-la. Isso aconteceu quando alguns fabricantes tentaram colocar funcionalidades adicionais em seus navegadores em detrimento da compatibilidade com seus rivais. Felizmente, a linguagem evolui, e os desenvolvedores de navegadores voltaram à razão, percebendo a necessidade de total compatibilidade entre si, então é menos necessário hoje em dia otimizar seu código para diferentes navegadores.

**Aprendendo a Andar Antes de Correr**
A função *document.write* está sendo deliberadamente usada aqui da maneira como foi originalmente concebida, por simplicidade em trechos de código muito pequenos. No entanto, existem maneiras melhores de escrever em páginas web e de fornecer feedback durante a depuração, tudo isso será revelado nos momentos apropriados neste livro, juntamente com explicações sobre quando e por que as outras opções funcionarão melhor para a gente.

Como mencionado anteriormente, o JavaScript foi originalmente desenvolvido para oferecer controle dinâmico sobre os vários elementos dentro de um documento HTML, <span style="background:#affad1">e esse ainda é seu uso principal</span>. Mas, cada vez mais, o JavaScript está sendo usado como a linguagem principal para o desenvolvimento de aplicações web, com recursos como Ajax, o processo de acessar o servidor web em segundo plano.

A **comunicação assíncrona** permite que as páginas web comecem a se assemelhar a programas independentes, porque **não precisam ser recarregadas inteiramente para exibir novo conteúdo**. Em vez disso, uma chamada assíncrona pode capturar e atualizar um único elemento em uma página web, como alterar sua fotografia em um site de rede social ou substituir um botão em que você clica pela resposta a uma pergunta. Este assunto é totalmente abordado no Capítulo 17.

O JavaScript foi criado para permitir acesso via script a todos os elementos de um documento HTML. Em outras palavras, ele fornece um meio para interação dinâmica do usuário, como verificar a validade de endereços de e-mail em formulários de entrada e exibir avisos como "Você realmente quis dizer isso?" (embora não se possa confiar nele para segurança, que deve sempre ser realizada no servidor web).

Combinado com CSS (veja "Usando CSS" na página 10), o JavaScript é a força por trás de páginas web dinâmicas que mudam diante dos seus olhos, em vez de quando uma nova página é retornada pelo servidor.

No entanto, o JavaScript costumava ser complicado de usar, devido à forma como a linguagem foi inicialmente projetada e a algumas grandes diferenças na forma como diferentes navegadores escolheram implementá-lo. Isso aconteceu quando alguns fabricantes tentaram colocar funcionalidades adicionais em seus navegadores em detrimento da compatibilidade com seus rivais. Felizmente, a linguagem evolui, e os desenvolvedores de navegadores voltaram à razão, percebendo a necessidade de total compatibilidade entre si, então é menos necessário hoje em dia otimizar seu código para diferentes navegadores.


## The Apache Web Server
Além do PHP, MySQL, JavaScript, CSS e HTML, há um sexto herói na web dinâmica: o servidor web. Para este livro, isso significa o servidor web Apache. Já discutimos um pouco sobre o que um servidor web faz durante a troca HTTP entre servidor/cliente, mas ele faz muito mais nos bastidores.

Por exemplo, o Apache não serve apenas arquivos HTML — ele lida com uma ampla variedade de arquivos, desde imagens até arquivos de áudio MP3, feeds RSS (Really Simple Syndication), e assim por diante. E esses objetos não precisam ser arquivos estáticos como imagens GIF. Eles podem ser gerados por programas como scripts PHP. Isso mesmo: o PHP pode até criar imagens e outros arquivos para você, seja dinamicamente ou com antecedência para serem entregues posteriormente.

Para fazer isso, normalmente você tem módulos que são pré-compilados no Apache ou no PHP, ou chamados em tempo de execução. Um desses módulos é a biblioteca GD (Graphics Draw), que o PHP usa para criar e manipular gráficos.

O Apache também suporta uma enorme gama de módulos próprios. Além do módulo PHP, os mais importantes para seus propósitos como programador web são os módulos que lidam com segurança. Outros exemplos são o módulo Rewrite, que permite ao servidor web lidar com uma variedade de tipos de URL e reescrevê-las para atender a seus próprios requisitos internos, e o módulo Proxy, que você pode usar para servir páginas frequentemente solicitadas a partir de um cache para aliviar a carga no servidor.

Mais adiante no livro, você verá como usar alguns desses módulos para aprimorar os recursos fornecidos pelas três tecnologias principais.

## Node.js: An Alternative to Apache
Em 2009, o desenvolvedor Ryan Dahl estava insatisfeito com o Apache e suas dificuldades em lidar com um grande número de conexões simultâneas, e criou uma solução que chamou de Node.js, que utiliza o mecanismo V8 JavaScript do Google para permitir que desenvolvedores usem JavaScript para script no lado do servidor. Pouco depois, foi introduzido um gerenciador de pacotes para o ambiente Node.js chamado npm, que facilitou para programadores publicarem e compartilharem código fonte de pacotes Node.js, simplificando a instalação, atualização e desinstalação de pacotes.

Em 2024, o Node.js alcançou a versão 22.6.0 e se tornou uma alternativa totalmente estabelecida ao servidor web Apache. Esta nova edição do livro não poderia deixar de detalhar seus benefícios e fornecer informações suficientes para você começar a usá-lo, se assim desejar. Você pode fazer essa escolha por três razões discutidas a seguir.

O Node.js utiliza um modelo de I/O não bloqueante orientado a eventos, permitindo-lhe lidar eficientemente com um grande número de conexões simultâneas. Essa natureza não bloqueante possibilita aplicações escaláveis e de alto desempenho, tornando-o ideal para construir, por exemplo, aplicações web em tempo real, aplicações de chat e serviços de streaming.

Ele permite que desenvolvedores usem JavaScript tanto no frontend quanto no backend, tornando-se um ambiente de desenvolvimento full-stack. Isso elimina a necessidade de alternar entre diferentes linguagens de programação, permitindo melhor reutilização de código e simplificando o processo de desenvolvimento. Sim, isso significa que você não precisará se manter atualizado com PHP se fizer a mudança, e de fato o Node.js não conseguirá executar seus scripts PHP. No entanto, uma aplicação bastante complexa ainda pode usar tanto Node.js quanto Apache com PHP, cada um para diferentes partes ou tarefas.

Por ser construído sobre o mecanismo JavaScript V8, o Node.js oferece desempenho excepcional, executando código JavaScript de forma rápida e eficiente, resultando em tempos de resposta mais rápidos e melhoria no desempenho geral da aplicação. Além disso, o Node.js tem uma pegada de memória pequena, tornando-o eficiente em termos de recursos e adequado para implantação em plataformas de nuvem.

Como você aprenderá, existem muitas outras razões sólidas para usar Node.js, mas apenas estas poucas já são altamente persuasivas. O PHP continua sendo uma linguagem muito importante, prevalente em toda a internet, é ativamente desenvolvido, possui comunidades ativas e é frequentemente usado em conjunto com outras linguagens e ambientes, como o Node.js.