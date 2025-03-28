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
Para compreender a finalidade dos sistemas de banco de dados, considere uma parte de uma organização universitária que, entre outros dados, mantém informações sobre todos os professores, alunos, departamentos e ofertas de cursos. Uma maneira de armazenar essas informações em um computador é salvá-las em arquivos do sistema operacional. Para permitir que os usuários manipulem essas informações, o sistema dispõe de vários programas e aplicativos que realizam operações nos arquivos, incluindo programas para:
- Adicionar novos alunos, professores e cursos. Registrar alunos em cursos e gerar lista de presença.
- Atribuir notas aos alunos, calcular médias ponderadas e gerar históricos acadêmicos.

Os programadores desenvolvem esses programas de aplicação para atender às necessidades da universidade. Novos programas de aplicação são adicionados ao sistema conforme a necessidade surgem. Por exemplo, suponha que uma universidade decida criar um novo curso de graduação. Como resultado, a universidade cria um novo departamento e decide criar um novo curso de graduação. Como resultado, a universidade cria um novo departamento e estabelece novos arquivos permanentes (ou adiciona informações a arquivos existentes) para registrar dados sobre todos os professores do departamento, os alunos matriculados neste curso, as disciplinas oferecidas, os requisitos para obtenção do diploma e assim por diante. A universidade pode precisar desenvolver novos programas de aplicação para lidar com regras específicas desse novo curso. Além disso, podem ser necessários novos programas de aplicação para implementar mudanças nas regras gerais da universidade. Assim, com o passar do tempo, o sistema adquire mais arquivos e mais programas de aplicação.

Esse típico sistema de processamento de arquivos é suportado por um sistema operacional convencional. O sistema armazena registros permanentes em vários arquivos e requer diferentes programas de aplicação para extrair registros de, ou adicionar registros aos, arquivos apropriados. 

Manter informações organizacionais *em um sistema de processamento de arquivo*s apresenta uma série de desvantagens significativas:
- **Redundância e inconsistências de dados.** Como diferentes programadores criam os arquivos e os programas de aplicação ao longo de um período, é provável que os diversos arquivos tenham estruturas diferentes, e os programas possam ser escritos em várias linguagens de programação. Além disso, as mesmas informações podem estar duplicadas em vários lugares (arquivos). Por exemplo, se um aluno tiver uma dupla graduação (digamos, Música e Matemática), o endereço e o número de telefone desse aluno podem aparecer em um arquivo que contém os registros dos alunos do departamento de Música e em outro arquivo que contém os registros dos alunos do departamento de Matemática. Essa redundância resulta em custos mais altos de armazenamento e acesso. Além disso, pode levar à inconsistência de dados; ou seja, as várias cópias dos mesmos dados podem não concordar entre si. Por exemplo, uma alteração no endereço do aluno pode ser refletida nos registros do departamento de Música, mas não em outros locais do sistema.

- **Dificuldade no acesso aos dados.** Suponha que um dos funcionários da universidade precise descobrir os nomes de todos os alunos que residem em uma determinada área de código postal. O funcionário solicita ao departamento de processamento de dados a geração de tal lista. No entanto, como os designers do sistema original não previram essa solicitação, não há nenhum programa de aplicação disponível para atendê-la. Existe, contudo, um programação de aplicação capaz de gerar a lista de todos os alunos. O funcionário da universidade agora tem duas opções: obter a lista de todos os alunos e extrair manualmente as informações necessárias ou solicitar a um programador que escreve o programa de aplicação necessário. Ambas as alternativas são, obviamente, insatisfatórias. Suponha que tal programa seja escrito e que, alguns dias depois, o mesmo funcionário precise refinar essa lista para incluir apenas os alunos que tenham cursado pelo menos 60 horas de crédito. Como era de se esperar, não existe um programa para gerar essa nova lista. Novamente, o funcionário enfrenta as mesmas duas opções anteriores, nenhuma das quais é satisfatória.

O ponto aqui é que os ambientes de processamento de arquivos convencionais não permitem que os dados necessários sejam recuperados de maneira conveniente e eficiente. <span style="background:#d4b106">Sistemas de recuperação de dados mais ágeis e responsivos são necessários para uso geral.</span>

- **Isolamento de dados.** Como os dados estão dispersos em vários arquivos, e esses arquivos podem estar em formatos diferentes, escrever novos programas de aplicação para recuperar os dados apropriados torna-se uma tarefa difícil.

- **Problemas de integridade.** Os valores de dados armazenados no banco de dados devem atender a determinados tipos de restrições de consistência. Suponha que a universidade mantenha uma conta para cada departamento e registre o saldo disponível em cada conta. Suponha também que a universidade exija que o saldo da conta de um departamento nunca fique abaixo de zero. Os desenvolvedores impõem essas restrições no sistema adicionando código apropriado nos diversos programas de aplicação. No entanto, quando novas restrições são introduzidas, é difícil alterar os programas para implementá-las. O problema se agrava quando as restrições envolvem vários itens de dados provenientes de diferentes arquivos. 

- **Problema de atomicidade.** Um sistema de computador, assim como qualquer outro dispositivo, está sujeito a falhas. Em muitas aplicações, é crucial que, caso ocorra uma falha, <span style="background:#b1ffff">os dados sejam revertidos para o estado consistente que existia antes da falha</span>. Considere um sistema bancário com um programa para transferir R$500,00 de uma conta para outra. Se ocorrer uma falha durante a execução do programa, é possível que os $500 tenham sido debitados do saldo da conta A, mas não tenham sido creditados ao saldo da conta B, resultando em um estado inconsistente do banco de dados. Claramente, é essencial para a consistência do banco de dados que ambas as operações (crédito e débito) ocorram, ou que nenhuma delas ocorra. Ou seja, a transferência de fundos deve ser atômica - ela deve acontecer por completo ou não acontecer de forma alguma. É difícil garantir atomicidade em um sistema convencional de processamento de arquivos.

- **Anomalias de acesso concorrente**. Em prol do desempenho geral do sistema e de uma resposta mais rápida, muitos sistemas permitem que vários usuários atualizem os dados simultaneamente. De fato, hoje em dia, os maiores varejistas da internet podem ter milhões de acessos por dia a seus dados por parte dos consumidores. Em tal ambiente, a interação entre atualizações concorrentes é possível e pode resultar em dados inconsistentes. Considere a conta A, com saldo de $10.000. Se dois funcionários do banco debitarem o saldo da conta A (por exemplo, $500 e $100, respectivamente) quase exatamente ao mesmo tempo, o resulta das execuções concorrentes pode deixar o saldo da conta em um estado incorreto (ou inconsistente). Suponhamos que os programas executados para cada saque leiam o saldo antigo, reduzam esse valor pelo montante que está sendo retirado e escrevam o resultado de volta. Se os dois programas forem executados concorrentemente, ambos podem ler o valor de $10.000 e escrever de volta $9.500 e $9.900, respetivamente. A supervisão é difícil de ser implementada por que os dados podem ser acessados por muitos programas de aplicação que não foram previamente coordenados. Como outro exemplo, suponha que um programa de registro mantenha um contador de estudantes matriculados em um curso para impor limites no número de inscrições. Quando um estudante se matricula, o programa lê o valor atual do contador, verifica se ele ainda não atingiu o limite, adiciona 1 ao contador e armazena o novo valor no banco de dados.
- **Problemas de segurança**. Nem todos os usuários do sistema de banco de dados devem ter acesso a todos os dados. Por exemplo, em uma universidade, o pessoal do setor de folha de pagamento precisa visualizar apenas a parte do banco de dados que contém informações financeiras. Eles não precisam acessar informações sobre registros acadêmicos. No entanto, como os programas de aplicação são adicionados ao sistema de processamento de arquivos de maneira ad hoc, impor essas restrições de segurança torna-se difícil. 

Essas dificuldades, entre outras, impulsionaram tanto o desenvolvimento inicial dos sistemas de banco de dados quanto a transição das aplicações baseadas em arquivos para sistemas de banco de dados, já nas décadas de 1960 e 1970.


No que se segue, veremos os conceitos e algoritmos que permitem aos sistemas de banco de dados resolver os problemas dos sistemas de processamento de arquivos. Na maior parte deste livro, usaremos uma organização universitária como exemplo prático de uma aplicação típica de processamento de dados.

## View of Data
Um sistema de banco de dados é uma coleção de dados inter-relacionados e um conjunto de programas que permitem aos usuários acessar e modificar esses dados. Um dos principais objetivos de um sistema de banco de dados é <span style="background:#d4b106">fornecer aos usuários uma visão abstrata dos dados.</span> Ou seja, o sistema oculta certos detalhes como os dados são armazenados e mantidos.

### 1.3.1 Data Models
Por trás da estrutura de um banco de dados está o *data model* (modelo de dados): uma coleção de ferramentas conceituais para *descrever dados*, *relacionamentos* entre os dados, semântica dos dados e restrições de consistência.
Existem diversos modelos de dados diferentes que abordaremos no texto. Esses modelos podem ser classificados em quatro categorias distintas:

- **Relational Model (Modelo Relacional).** O modelo relacional utiliza uma coleção de tabelas para representar tanto os dados quanto os relacionamentos entre esses dados. Cada tabela possui múltiplas colunas, e cada coluna tem um nome único. As tabelas também são conhecidas como relações. O modelo relacional é um exemplo de um modelo baseado em registros (*record-based model*). Modelos baseados em registros recebem esse nome porque o banco de dados é estruturado em registros de formato fixo de vários tipos. <span style="background:#affad1">Cada tabela contém registros de um tipo específico</span>. Cada tipo de registro define um número fixo de campos ou atributos. As colunas da tabela correspondem aos atributos do tipo de registro. O modelo de dados relacional é o mais amplamente utilizado, e a grande maioria dos sistemas de banco de dados atuais é baseada no modelo relacional. O capítulo 2 e o Capítulo 7 abordam o modelo relacional em detalhes.

- **Entity-Relationship Model (Modelo Entidade-Relacionamento)**. O modelo de dados entidade-relacionamento (E-R) utiliza uma <span style="background:#b1ffff">coleção de objetos básicos</span>, <span style="background:#d4b106">chamados entidades</span>, e os relacionamentos entre esses objetos. uma entidade e uma "coisa" ou "objeto" do mundo real que pode ser distinguido de outros objetos. O modelo entidade-relacionamento é amplamente utilizado no design de banco de dados. O capítulo 6 explore esse modelo em detalhes. Aqui, o foco é entender como os objetos estão conectados, antes de decidir como eles serão armazenados. <span style="background:#affad1">Não foca diretamente na implementação em tabelas</span>.

- **Semi-structured Data Model (Modelo de Dados Semi-estruturado)**. O modelo de dados semi-estruturado permite a especificação de dados onde itens de dados individuais do mesmo tipo podem ter conjuntos diferentes de atributos. Isso contrasta com os modelos de dados mencionados anteriormente, nos quais todos os itens de dados de um determinado tipo devem possuir o mesmo conjuntos de atributos. JSON e XML são representações amplamente utilizadas de dados semi-estruturados. Os modelos de dados semi-estruturados são explorados em detalhes no Capítulo 8. <span style="background:#d4b106">Aqui, itens do mesmo tipo podem ter atributos diferentes. Não há necessidade de seguir um formato fixo. </span> 
- Considere um conjunto de dados sobre pessoas em JSON:
```json
  { "nome": "João", "idade": 20, "curso": "Engenharia" },
  { "nome": "Maria", "hobbies": ["leitura", "viagem"] }
```
- Uma pessoa tem o atributo *curso*, enquanto outra tem *hobbies*. Isso não seria possível em um modelo relacional. 
- É útil para lidar com dados, variáveis desconhecidas, como em APIs da web ou documentos XML/JSON.

- **Modelos de Dados Baseado em Objetos**: a programação orientada a objetos (especialmente em Java, C++ ou C#) tornou-se a metodologia dominante no desenvolvimento de software. Isso inicialmente levou ao desenvolvimento de um **modelo de dados orientado a objetos distinto**, mas hoje o conceito de objetos está bem integrado aos bancos de dados relacionais. Existem padrões para armazenar objetos em tabelas relacionais. Os sistemas de banco de dados permitem que procedimentos sejam armazenados no sistema de banco de dados e executados pelo próprio sistema. Isso pode ser visto como uma extensão do modelo relacional com noções de *encapsulamento*, *métodos*  e *identidade de objetos*. Os modelos de dados baseados em objetos são resumidos no Capítulo 8.

### 1.3.2 Relational Data Model
No modelo relacional, os **dados** são representados na forma de *tabelas*. Cada tabela possui múltiplas colunas, e cada coluna tem um nome único. Cada linha da tabela representa uma única informação. A figura 1.1 apresenta um exemplo de banco de dados relacional composto por duas tabelas: uma mostra detalhes dos instrutores da universidade e a outra exibe detalhes dos diversos departamentos da universidade.

A primeira tabela, a tabela *instructor*, mostra, por exemplo, que um instrutor chamado Einstein, com ID 22222, é membro do departamento de Física e tem um salário anual de $95.000. A segunda tabela, *department*, mostra, por exemplo, que o departamento de Biologia está localizado no prédio Watson e tem um orçamento de $90.000. Claro, em uma universidade do mundo real, haveria muitos mais departamentos e instrutores. No texto, usamos tabelas pequenas para ilustrar conceitos. Um exemplo maior para o mesmo esquema está disponível online.

![[Chapter 1 - Introduction.png]]


### 1.3.3 Data Abstraction
Para que o sistema seja utilizável, ele <span style="background:#b1ffff">deve recuperar dados de forma eficiente</span>. A necessidade de eficiência levou os desenvolvedores de sistemas de banco de dados a utilizarem estruturas de dados complexas para representar os dados no banco de dados. Como muitos usuários de sistemas de banco de dados não possuem treinamento em computação, os desenvolvedores escondem essa complexidade dos usuários por meio de vários níveis de abstração de dados, simplificando as interações dos usuários com o sistema:
- **Nível físico:** o nível mais baixo de abstração descreve como os dados são realmente armazenados. O nível físico detalha estruturas de dados de baixo nível e complexas;
- **Nível lógico:** o próximo nível mais alto de abstração descreve quais dados estão armazenados no banco de dados e quais relações existem entre esses dados. O nível lógico descreve todo o banco de dados em termos de um pequeno número de estruturas relativamente simples. Embora a implementação dessas estruturas simples no nível lógico possa envolver estruturas complexas no nível físico, o usuário do nível lógico não precisa estar ciente dessa complexidade. Isso é chamado de *independência de dados física.* Os administradores de banco de dados, que devem decidir quais informações manter no banco de dados, utilizam o nível lógico de abstração.

- **View Level** o nível mais alto de abstração descreve apenas **parte do banco de dados completo**. Embora o nível lógico utilize estruturas simples, a complexidade ainda persiste devido à grande variedade de informações armazenadas em um banco de dados extenso. Muitos usuários do sistema de banco de dados não precisam de todo esse conjunto de informações; em vez disso, eles precisam acessar apenas uma **parte específica do banco de dados.** O nível de visão existe para simplificar essa interação dos usuários com o sistema. O sistema pode fornecer várias visões diferentes para o mesmo banco de dados.

![[Chapter 1 - Introduction-1.png]]

Uma analogia com o conceito de tipos de dados em linguagens de programação pode esclarecer a distinção entre os níveis de abstração. Muitas linguagens de programação de alto nível suportam a noção de um **tipo estruturado**. Podemos descrever o tipo de um registro de forma abstrata da seguinte maneira:
```python
type instructor = record
    ID : char(5);
    name : char(20);
    dept_name : char(20);
    salary : numeric(8,2);
end;
```

Esse código define um novo tipo de registro chamado *instructor* com quatro campos. Cada campo possui um nome e um tipo associado. Por exemplo:
- *char(20)* específica uma string com 20 caracteres;
- *numeric(8,2)* específica um número com 8 dígitos, dos quais dois estão à direita do ponto decimal;

Uma organização universitária pode ter vários tipos de registros semelhantes, incluindo:

1. **`department`**, com os campos:
   - `dept_name`: Nome do departamento.
   - `building`: Prédio onde o departamento está localizado.
   - `budget`: Orçamento do departamento.

2. **`course`**, com os campos:
   - `course_id`: Identificador único do curso.
   - `title`: Título ou nome do curso.
   - `dept_name`: Departamento ao qual o curso pertence.
   - `credits`: Número de créditos do curso.

3. **`student`**, com os campos:
   - `ID`: Identificador único do aluno.
   - `name`: Nome do aluno.
   - `dept_name`: Departamento ao qual o aluno está vinculado.
   - `tot_cred`: Total de créditos acumulados pelo aluno.

No nível físico, um registro de instrutor, departamento ou aluno pode ser descrito como um bloco de bytes consecutivos. O compilador esconde esse nível de detalhes dos programadores. Da mesma forma, o sistema de banco de dados oculta muito dos detalhes de armazenamento de baixo nível dos programadores de banco de dados. Os administradores de banco de dados, por outro lado, podem estar cientes de certos detalhes da organização física dos dados. Por exemplo, existem várias maneiras possíveis de armazenar tabelas em arquivos. Uma maneira é armazenar uma tabela como uma sequência de registros em um arquivo, com um caractere especial (como uma vírgula) usado para delimitar os diferentes atributos de um registro, e outro caractere especial (como um caractere de nova linha) pode ser usado para delimitar registros. Se todos os atributos tiverem comprimento fixo, os comprimentos dos atributos podem ser armazenados separadamente, e os delimitadores podem ser omitidos do arquivo. Atributos de comprimento variável podem ser tratados armazenando o comprimento, seguido pelos dados. Os bancos de dados utilizam um tipo de estrutura de dados chamada índice para suportar a recuperação eficiente de registros; esses também fazem parte do nível físico.

No nível lógico, cada um desses registros é descrito por uma definição de tipo, como no segmento de código anterior. A inter-relação desses tipos de registros também é definida no nível lógico; um requisito de que o valor de *dept_name* em um registro de instrutor deve aparecer na tabela de departamentos é um exemplo de tal inter-relação. Programadores que utilizam uma linguagem de programação trabalham nesse nível de abstração. Da mesma forma, administradores de banco de dados geralmente trabalham nesse nível de abstração.

Finalmente, no nível de visão, os usuários de computador veem um conjunto de programas de aplicação que ocultam detalhes dos tipos de dados. No nível de visão, várias visões do banco de dados são definidas, e um usuário do banco de dados vê algumas ou todas essas visões. Além de ocultar detalhes do nível lógico do banco de dados, as visões também fornecem um mecanismo de segurança para impedir que os usuários acessem determinadas partes do banco de dados. Por exemplo, os funcionários do escritório do registro universitário podem ver apenas aquela parte do banco de dados que contém informações sobre os alunos; eles não podem acessar informações sobre os salários dos instrutores.

### 1.3.4 Instances and Schemas
Os bancos de dados mudam ao longo do tempo à medida que informações são inseridas e excluídas. A coleção de informações armazenadas no banco de dados em um momento específico é chamada de *instância do banco de dados.* O design geral do banco de dados é chamado de *esquema do banco de dados*. O conceito de esquemas e instâncias de banco de dados pode ser entendido por analogia a um programa escrito em uma linguagem de programação. Um esquema de banco de dados corresponde às declarações de variáveis (juntamente com as definições de tipo associadas) em um programa. Cada variável possui um valor especifico em um determinado instante. Os valores das variáveis em um programa em um ponto no tempo correspondem a uma instância de um esquema de banco de dados.

Os sistemas de banco de dados possuem vários esquemas, divididos de acordo com os níveis de abstração. O **esquema físico** descreve o design do banco de dados no nível físico, enquanto o **esquema lógico descreve** o design do banco de dados no nível lógico. Um banco de dados também pode ter vários esquemas no nível de visão, às vezes chamados de **subesquemas**, que descrevem diferentes visões do banco de dados.

Desses, o **esquema lógico** é, de longe, o mais importante em termos de seu impacto nos programas de aplicação, pois os programadores constroem aplicações utilizando o esquema lógico. O esquema físico está oculto sob o esquema lógico e geralmente pode ser alterado facilmente sem afetar os programas de aplicação. Diz-se que os programas de aplicação exibem **independência de dados física** se não dependerem do esquema físico e, portanto, não precisarem ser reescritos se o esquema físico mudar. 

Também observamos que é possível criar esquemas que apresentam problemas, como informações duplicadas desnecessariamente. Por exemplo, suponha que armazenemos o orçamento do departamento como um atributo do registro de instrutor. Então, sempre que o valor do orçamento de um departamento (digamos, o departamento de Física) mudar, essa mudança deve ser refletida nos registros de todos os intrutores associados ao departamento. No capítulo 7, estudaremos como distinguir bons designs de esquemas de designs ruins.

## 1.4 Database Languages
Um sistema de banco de dados fornece uma linguagem de definição de dados (DDL - Data-Definition Language) para especificar o esquema do banco de dados e uma linguagem de manipulação de dados (DML - Data-Manipulation Language) para expressar consultas e atualizações no banco de dados.

Na prática, as linguagens de definição e manipulação de dados não são duas linguagens separadas; em vez disso, elas simplesmente formam partes de uma única linguagem de banco de dados, como a **linguagem SQL**. Quase todos os sistemas de banco de dados relacionais utilizam a linguagem SQL, que será abordada em detalhes.

### 1.4.1 Data-Definition Language
Um esquema de um banco de dados é especificado por um conjunto de definições expressas em uma linguagem especial chamada **linguagem de definição de dados (DDL - Data-Definition Language)**. A DDL também é utilizada para especificar propriedades adicionais dos dados.

A estrutura de armazenamento e os métodos de acesso utilizados pelo sistema de banco de dados são especificados por um conjunto de instruções em um tipo especial de DDL chamado **linguagem de definição e armazenamento de dados (Data Storage and Definition Language)**. Essas instruções definem os detalhes de implementação dos esquemas do banco de dados, que geralmente são ocultados dos usuários.

Os valores armazenados no banco de dados devem obedecer a restrições de consistência. Por exemplo, suponha que uma universidade exija que o saldo da conta de um departamento **nunca seja negativo**. A DDL fornece mecanismos para especificar tais **restrições de integridade**. O sistema de banco de dados verifica essas restrições toda vez que ocorre uma atualização.

Em geral, uma **restrição** ( #constraint) pode ser qualquer **predicado arbitrário** relacionado ao banco de dados. No entanto, testar predicados arbitrários pode ser **computacionalmente custoso**. Assim, os sistemas de banco de dados implementam apenas as restrições de integridade que podem ser verificadas com **mínimo impacto no desempenho.**

- **Restrição de domínio:** um domínio de possíveis valores deve ser associado a cada atributo (por exemplo, tipos inteiros, tipos de caracteres, tipos de data/hora). <span style="background:#affad1">Declarar um atributo como pertencente a um domínio específico atua como uma restrição sobre os valores que ele pode assumir.</span> As restrições de domínio são a forma mais elementar de restrição de integridade. Elas são facilmente testadas pelo sistema sempre que um novo item de dados é inserido no banco de dados. Java possui tipagem estática, o que significa que os tipos dos atributos e variáveis devem ser declaradas explicitamente no código. Essa característica impõe uma forma de restrição de domínio ( #domain-constraints), portanto o compilador verifica se os valores atribuídos a uma variável estão em conformidade com o tipo declarado. Portanto, o #compilador Java verifica automaticamente se os valores atribuídos respeitam o tipo declarado. Se tentarmos atribuir um valor fora do domínio permitido para aquele tipo, o compilador gerará um erro de compilação. <span style="background:#d4b106">Isso garante que a restrição de domínio seja aplicada antes mesmo de o programa ser executado</span>! Mas atenção, existem limitações, Domains constraints não garante total verificação e todas as possíveis validações de integridade. 

- #Autorização. Podemos querer diferenciar entre os usuários em relação ao tipo de acesso que eles têm permissão para realizar sobre diversos valores de dados no banco de dados. Essas diferenciações são expressas em termos de #autorização, sendo as mais comuns:
	- Autorização de leitura, que permite leitura, mas não a modificação, dos dados;
	- Autorização de inserção, que permite a inserção de novos dados, mas não a modificação dos dados existentes;
	- Autorização de atualização, que permite a modificação, mas não e exclusão, dos dados.
	- Autorização de exclusão, que permite a exclusão dos dados.
Podemos atribuir ao usuário todas, nenhuma ou uma combinação dessas categorias de autorização. 

O processamento de instruções DDL, assim como ocorre com qualquer outra linguagem de programação, gera uma saída. A saída da DDL é armazenada no **dicionário de dados**, que contém metadados - ou seja, dados sobre os dados. O dicionário de dados é considerado um tipo especial de tabela que pode ser acessado e atualizado apenas pelo próprio sistema de banco de dados (e não por um usuário comum). O sistema de banco de dados consulta o dicionário de dados antes de ler ou modificar os dados reais.

### 1.4.2 The SQL Data-Definition Language

O SQL fornece um DDL (Data Definition Language) rico, que permite definir tabelas com tipos de dados e restrições de integridade.

Por exemplo, a seguinte instrução DDL em SQL define a tabela *department* (departamento):
```sql
create table department
	(dept_name char(20),
	building char(15),
	budget numeric(12, 2)
	);
```
A execução da instrução DDL acima cria a tabela *department* com três colunas: *dept_name*, *building* e *budget*, cada uma delas associada a um tipo de dados específico. Discutiremos os tipos de dados em mais detalhes no Capítulo 3.

O SQL também oferece suporte a diversos tipos de #restrições de integridade. Por exemplo, pode-se especificar que o valor do atributo **dept_name** é uma chave primária, garantindo que nenhum departamento possar ter o mesmo nome de outro. Discutiremos o suporte do SQL para restrições de integridade e autorizações no Capítulo 3 e no Capítulo 4.

### 1.4.3 Data-Manipulation Language
Uma **linguagem de manipulação de dados (DML)** é uma linguagem que permite aos usuários acessar ou manipular dados organizados de acordo com o modelo de dados apropriado. Os tipos de acesso são:
- **Recuperação** de informações armazenadas no banco de dados;
- **Inserção** de novas informações no banco de dados;
- **Exclusão** de informações do banco de dados;
- **Modificação** de informações armazenadas no banco de dados.

Existem basicamente dois tipos de **linguagem de manipulação de dados (DML)**:
- **DMLs Procedurais** exigem que o usuário especifique quais dados são necessários e como obtê-los.
- **DMLs Declarativas** (também chamadas de DMLs não procedurais) exigem que o usuário especifique quais dados são necessários sem precisar especificar como obtê-los.

As DMLs declarativas geralmente são mais fáceis de aprender e usar do que as DMLs procedurais. No entanto, como o usuário não precisa especificar como obter os dados, os sistema de banco de dados precisa determinar uma maneira eficiente de acessar os dados.

Uma consulta é uma instrução que solicita a recuperação de informações. A parte da DML que envolve a recuperação de informações é chamada de **linguagem de consulta**. Embora tecnicamente incorreto, é prática comum usar os termos **linguagem de consulta** e **linguagem de manipulação de dados** como sinônimos.

Existem diversas linguagens de consulta de banco de dados em uso, seja comercialmente ou experimentalmente. Estudamos a linguagem de consulta mais amplamente utilizada, o SQL, nos capítulos 3 a 5.

Os níveis de abstração que discutimos na seção 1.3 aplicam-se não apenas à definição ou estruturação dos dados, mas também à manipulação dos dados. No nível físico, devemos definir algoritmos que permitam acesso eficiente aos dados. Em níveis mais altos de abstração, enfatizamos a facilidade de uso. O objetivo é permitir que os seres humanos interajam de forma eficiente com o sistema.

O componente *processador de consultas* do sistema de banco de dados (que estudamos nos Capítulos 15 e 16) traduz as consultas DML em sequências de ações no nível físico do sistema de banco de dados. No capítulo 22, estudamos o processamento de consultas nos cenários cada vez mais comuns de sistemas paralelos e distribuídos.

### 1.4.4 The SQL Data-Manipulation Language
A linguagem de consulta SQL não é procedural. Uma consulta recebe como entrada várias tabelas (possivelmente apenas uma) e sempre retorna uma única tabela. Aqui está um exemplo de uma consulta SQL que encontra os nomes de todos os instrutores no departamento de história:
```sql
select instructor.name from instructor where instructor.dept_name = 'History';
```

A consulta especifica que as linhas da tabela *instructor* onde o *dept_name* é *History* devem ser recuperadas, e o atributo *name* dessas linhas deve ser exibido. O resultado da execução dessa consulta é uma tabela com uma única coluna rotulada como *name* e um conjunto de linhas, cada uma das quais contém o nome de um instrutor cujo *dept_name* é **History**. Se a consulta for executada na tabela mostrada na figura 1.1, o resultado consistirá em duas linhas: uma com o nome *El Said* e outra com o nome *Califieri*. 

As consultas podem envolver informações de mais de uma tabela. Por exemplo, a seguinte consulta encontra o ID do instrutor e o nome do departamento de todos os instrutores associados a um departamento com um orçamento superior a $95.000.

```sql
select instructor, ID, department.dept_name
from instructor, department
where instructor.dept_name = department.dept_name and department.budget > 95000;
```

**Explicação Resumida**
- **Consulta Simples:** a primeira consulta demonstra como filtrar dados de uma única tabela *instructor* com base em um condição *dept_name = 'History'* e retornar apenas uma coluna específica (*name*).
- **Consulta com Múltiplas Tabelas:** a segunda consulta ilustra como combinar informações de duas tabelas *instructor e department* usando uma condição de junção *instructor.dept_name = department.dept_name* e aplicando um filtro adicional *department.budget > 9500*. O resulta inclui colunas de ambas as tabelas.

Essas consultas exemplificam a simplicidade e a flexibilidade do SQL como uma linguagem declarativa, permitindo que os usuários se concentrem no o quê (dados desejados) em vez de *como* (processo de recuperação).

Se a consulta anterior fosse executada nas tabelas da Figura 1.1, o sistema identificaria que existem dois departamentos com orçamento superior a $95000, Ciência da Computação e Finanças; além disso, há cinco instrutores associados a esses departamentos. Assim, o resultado consistiria em uma tabela com duas colunas (Id, dept_name) e cinco linhas;

### 1.4.5 Database Acess from Application Programs
Linguagens de consulta não procedurais, como o SQL, não são tão poderosas quanto uma máquina de Turing universal; isto é, existem alguns cálculos que são possíveis de serem realizados usando uma linguagem de programação de propósito geral, mas que não são possíveis usando o SQL. Além disso, o SQL não suporta ações como entrada de dados pelos usuários, saída para displays ou comunicação via rede. Esses cálculos e ações devem ser escritos em uma *linguagem hospedeira* (host language), como C/C++, Java ou Python, com consultas SQL embutidas que acessam os dados no banco de dados.

*Application programs* são programas que são usados para interagir com o banco de dados dessa maneira. Exemplos em um sistema universitário incluem programas que permitem que os alunos se matriculem em cursos, gerem listas de turmas, calculem o GPA (média de notas) dos alunos, emitam cheques de pagamento e realizem outras tarefas.

Para acessar o banco de dados, as instruções DML precisam ser enviadas do programa hospedeiro (host) para o banco de dados, onde serão executadas. Isso é mais comumente feito utilizando uma *interface de programação de aplicativos API*, que consiste em um conjunto de procedimentos que podem ser usados para enviar instruções DML e DDL ao banco de dados e recuperar os resultados. O padrão *Open Database Connectivity (ODBC)* define interfaces de programação de aplicativos para uso com C e várias outras linguagens. Já o padrão *Java Database Connectivity (JDBC)* define uma interface correspondente para a linguagem Java.

## 1.5 Database Design
