## Introduction
Um sistema de gerenciamento de banco de dados (DBMS) é uma coleção de dados inter-relacionados e um conjunto de programas para acessar esses dados. A coleção de dados, geralmente chamada de banco de dados, contém informações relevantes para uma empresa. <span style="background:#b1ffff">O principal objetivo de um DBMS é fornecer uma maneira de armazenar e recuperar informações do banco de dados</span> de forma conveniente e eficiente. 

Os sistemas de banco de dados são projetados para gerenciar grandes volumes de informação. O gerenciamento de dados envolve tanto a definição de estruturas para *armazenamento* das informações quanto a disponibilização de mecanismos para sua *manipulação*.  Além disso, o sistema de banco de dados deve <span style="background:#d4b106">garantir a segurança</span> das informações armazenadas, mesmo diante de falhas do sistema ou tentativas de acesso não autorizado. Se os dados forem compartilhados entre vários usuários, <span style="background:#b1ffff">o sistema deve evitar possíveis resultado anômalos</span>.

Como a informação é extremamente importante para a maioria das organizações, cientistas da computação desenvolveram um vasto conjunto de conceitos e técnicas para o gerenciamento de dados. Este capítulo apresenta brevemente os princípios dos sistemas de banco de dados.

## 1.1 Database-System Applications
Os primeiros sistemas de banco de dados surgiram na década de 1960 em resposta à necessidade de gerenciamento computacional de dados comerciais. Essas primeiras aplicações eram relativamente simples em comparação com as modernas aplicações de banco de dados, que hoje incluem operações altamente sofisticadas em escala global.

Todas as aplicações de banco de dados, antigas e novas, compartilham elementos fundamentais. O aspecto central da aplicação não é um programa realizando cálculos, mas sim os próprios dados. Atualmente, algumas das empresas mais valiosas do mundo não devem seu valor aos ativos físicos que possuem, mas sim às informações que detêm 

Os primeiros sistemas de banco de dados surgiram na década de 1960 em resposta à necessidade de gerenciamento computacional de dados comerciais. As aplicações anteriores eram relativamente simples em comparação com as aplicações de banco de dados modernas. As aplicações modernas incluem empresas altamente sofisticadas que operam em escala global.

Todas as aplicações de banco de dados, sejam antigas ou novas, compartilham elementos importantes em comum. O aspecto central da aplicação não é um programa realizando cálculos, <span style="background:#b1ffff">mas sim os próprios dados.</span> Hoje, algumas das corporações mais valiosas são valiosas não por causa de seus ativos físicos, mas sim pela informação que possuem.

Imagine um banco sem seus dados sobre contas e clientes, ou um site de rede social que perde as conexões entre seus usuários. Nestas circunstâncias, o valor dessas empresas estaria quase totalmente perdido.

Os sistemas de bancos de dados são usados para gerenciar coleções de dados que:
- são altamente valiosos;
- são relativamente grandes, e;
- são acessados por múltiplos usuários e aplicações, muitas vezes simultaneamente.

As primeiras aplicações de banco de dados lidavam apenas com dados simples, formatados de maneira precisa e estruturada. Hoje, as aplicações de banco de dados podem incluir dados com relacionamentos complexos e uma estrutura mais variável. Como exemplo de uma aplicação com dados estruturados, podemos considerar os registros de uma universidade sobre cursos, estudantes e matrículas em cursos, título, departamento, número do curso, etc., e similarmente para os estudantes: identificador do estudante, nome, endereço, telefone, etc. A matrícula em cursos é uma coleção de pares: um identificador de curso e um identificador de estudante. Informações desse tipo possuem uma estrutura padrão e repetitiva e são representativas do tipo de aplicação de banco de dados que remonta aos anos 1960.

Contraste essa simples aplicação de banco de dados universitário com um site de rede social. Os usuários do site postam diversos tipos de informações sobre si mesmos, que vão desde itens simples, como nome ou data de nascimento, até postagens complexas compostas de texto, imagens, vídeos e links para outros usuários. Há apenas uma quantidade limitada de estrutura comum entre esses dados. No entanto, ambas as aplicações compartilham as características básicas de um banco de dados.

Os sistemas de banco de dados modernos exploram as semelhanças na estrutura dos dados para ganhar eficiência, mas também permitem dados fracamente estruturados e dados cujos formatos são altamente variáveis. Como resultado, um sistema de banco de dados é um grande e complexo sistema de software cuja tarefa é gerenciar uma grande e complexa coleção de dados.

Gerenciar a complexidade é desafiador, não apenas no gerenciamento de dados, mas em qualquer domínio. O conceito central para o gerenciamento da complexidade é a **abstração**. A abstração permite que uma pessoa use um dispositivo ou sistema complexo sem precisar conhecer os detalhes de como esse dispositivo ou sistema foi construído.

Por exemplo, uma pessoa pode dirigir um carro sabendo como operar seus controles. No entanto, o motorista não precisa saber como o motor foi construído nem como ele funciona. Tudo o que o motorista precisa saber é uma abstração do que o motor faz. Da mesma forma, para uma grande e complexa coleção de dados, um sistema de banco de dados fornece uma visão mais simples e abstrata das informações, de modo que os usuários e os programadores de aplicativos não precisem estar cientes dos detalhes subjacentes de como os dados são armazenados e organizados. 

Ao oferecer um alto nível de abstração, um sistema de banco de dados possibilita que uma organização integre dados de diferentes tipos em um repositório unificado, reunindo todas as informações necessárias para o funcionamento da empresa.


Como essa lista ilustra, os bancos de dados formam uma parte essencial não apenas de toda empresa, mas também de grande parte das atividades diárias de uma pessoa.

As formas como as pessoas interagem com os bancos de dados mudaram ao longo do tempo. Os primeiros bancos de dados eram mantidos como sistemas back-office, com os quais os usuários interagiam por meio de relatórios impressos e formulários em papel para entrada de dados. À medida que os sistemas de banco de dados se tornaram mais sofisticados, linguagens melhores foram desenvolvidas para que os programadores pudessem interagir com os dados, juntamente com interfaces de usuário que permitiam aos usuários dentro da empresa consultar e atualizar os dados.

À medida que o suporte à interação dos programadores com os bancos de dados melhorou, e o desempenho do hardware aumentou enquanto os custos de hardware diminuíram, surgiram aplicações mais sofisticadas que trouxeram os dados dos bancos de dados para o contato mais direto, não apenas com o usuários finais dentro de uma empresa, mas também com o público em geral. Enquanto antes os clientes de bancos precisavam interagir com um caixa para cada transação, os caixas automáticos (ATMs) permitiram uma interação direta ao cliente. Hoje, praticamente todas as empresas utilizam aplicações web ou mobile para permitir que seus clientes interajam diretamente com o banco de dados da empresa e, consequentemente, com a própria empresa.

O usuário, ou cliente, pode se concentrar no produto ou serviço sem estar ciente dos detalhes do grande banco de dados que viabiliza essa interação. Por exemplo, ao ler uma postagem em uma rede social ou acessar uma livraria online para navegar por uma coleção de livros ou músicas, estamos acessando dados armazenados em um banco de dados. Quando faz um pedido online, sua solicitação é registrada em um banco de dados. Ao acessar o site de um banco para consultar o nosso saldo e informações de transações, esses dados são recuperados do sistema de banco de dados da instituição. Além disso, ao cessar um site, informações sobre você podem ser extraídas de um banco de dados para selecionar quais anúncios devem ser exibidos. Quase toda interação com um smartphone envolve algum tipo de acesso a um banco de dados. Além disso, dados sobre seus acessos à web podem ser armazenados em um banco de dados. 

Assim, embora as interfaces de usuário ocultem os detalhes do acesso a um banco de dados e a maioria das pessoas nem perceba que está lidando com um, o acesso a bancos de dados tornou-se uma parte essencial da vida cotidiana.

De forma geral, existem dois modos principais de uso dos bancos de dados:
- O primeiro modo é o suporte ao *online transaction processing (OLTP)*, onde o grande número de usuários acessa o banco de dados, cada um recuperando pequenas quantidades de dados e realizando pequenas atualizações. Esse é o modo de uso predominante para a maioria das aplicações de banco de dados mencionadas anteriormente.
- O segundo modo é o suporte à *data analytics*, ou seja, o processamento de dados para extrair conclusões, identificar padrões e definir regras ou procedimentos de decisão, que são então utilizados para orientar decisões empresariais.

Por exemplo, bancos precisam decidir se concedem ou não um empréstimo a um solicitante, e anunciantes online precisam determinar qual anúncio exibir para um usuário específico. Essas tarefas são abordadas em duas etapas.
1. Primeiro, técnicas de análise de dados tentam descobrir automaticamente regras e padrões nos dados e criar modelos preditivos. Esses modelos utilizam como entrada atributos (*features*) dos indivíduos e geram previsões, como a probabilidade de pagamento de um empréstimo ou de um clique em um anúncio, que são então usadas para tomar decisões de negócios.
2. Outro exemplo é a tomada de decisões por fabricantes e varejistas sobre quais produtos fabricar ou encomendar e em quais quantidades. Essas decisões são amplamente influenciadas por técnicas de análise de dados históricos e previsão de tendências. O custo de decisões erradas pode ser extremamente alto, e, por isso, **as organizações estão dispostas a investir grandes quantias** na coleta ou compra de dados necessários e no desenvolvimento de sistemas que possam utilizá-los para fazer previsões precisas. 

O campo de *data mining* combina técnicas de descoberta de conhecimento desenvolvidas por pesquisadores de inteligência artificial e estatísticos com implementações eficientes, permitindo sua aplicação em banco de dados extremamente grandes.

## Purpose of Database Systems
