É curioso como, de fora, a área de TI costuma ser vista como uma ciência exata.  
Quando comecei como desenvolvedor, ouvia muito: _“Ah, você trabalha com TI, então deve ser bom em matemática.”_  
Nunca entendi por que alguém que supostamente é bom em matemática seria a pessoa certa para consertar uma impressora.

Com alguma experiência em desenvolvimento de aplicações, percebemos que TI não é uma ciência exata.
Existem várias soluções possíveis para um mesmo problema. 
Pergunte a cinco desenvolvedores qual é a melhor forma de montar um blog e provavelmente teremos cinco respostas diferentes. Cada sugestão virá com seus próprios prós e contras.

No nível mais detalhado, há inúmeras decisões interessantes a serem tomadas que não têm uma resposta definitiva:
- Podemos enviar um e-mail a partir de um controller?
- Qual deve ser o nome desse conceito?
- Onde salvar esse pedaço de lógica?
- Essa classe deveria ser final?

Não existem respostas definitivas para essas questões. Tudo depende de alguns fatores: o **tamanho do projeto**, as **preferências** individuais dos membros da equipe e os **acordos** que o grupo estabeleceu.

Programadores têm preferências bem particulares sobre como as coisas devem ser feitas. Alguns gostam de seguir à risca os princípios do SOLID. Outros preferem uma abordagem mais pragmática. A maioria dos desenvolvedores não estão em um extremo ou em outro. 

Essas preferências também variam em outros aspectos. Alguns se preocupam com “dívida visual”. Outros não ligam para isso. Alguns preferem manter a estrutura padrão de seus frameworks favoritos. Outros gostam de criar uma organização própria.

Não existe uma abordagem intrinsecamente certa ou errada. Projetos bonitos e fáceis de manter podem ser construídos tanto de forma pragmática quanto de forma extremamente rigorosa. Porém, a maioria dos projetos não são feitos por uma única pessoa. Há sempre um grupo envolvido, e cada integrante se posiciona em algum ponto diferente dessa escala entre o estrito e o pragmático.

Pela experiência, posso dizer: não é uma boa ideia deixar cada membro usar apenas o seu estilo preferido em um projeto. O resultado provavelmente será um código inconsistente, difícil de manter ou de expandir.

Em uma equipe bem organizada, os membros conversam e discutem os prós e contras e suas preferências individuais. Ao chegar a um consenso, é importante registrá-lo junto com os motivos da escolha. Isso pode se transformar em um conjunto de diretrizes que novos integrantes da equipe podem consultar. 

## Domain Oriented Laravel
*Humans think in categories, our code should be a reflection of that.*

Antes de mais nada: não fui eu que inventei o termo "domínio", eu o obtive do popular paradigma de programação DDD, ou "domain driven design". É um termo bastante genérico e, de acordo com o Oxford Dictionary, um "domínio" pode ser descrito como "uma esfera específica de atividade ou conhecimento".

Há varias semelhantes entre o uso do domínio aqui no livro e o seu uso na comunidade. 

Portanto, domínios. Também poderíamos chamá-los de "grupos" "módulos" ou, como algumas pessoas os chama, "serviços". Seja qual for o nome que preferirmos, os domínios descrevem um conjunto de *problemas comerciais* que estamos tentando resolver.

O problema de negócio - termo empresarial. 

Vamos dar um exemplo: um aplicativo para gerenciar reservas de hotéis.
Ele precisa gerenciar clientes, reservas, faturas, inventários de hotéis etc. As estruturas modernas da Web ensinam  a gente a pegar um grupo de conceitos relacionados e dividi-los em vários lugares em sua base de código: controladores com controladores, modelos com modelos e assim por diante.

Então, vamos parar e pensar um pouco sobre isso. Algum cliente provavelmente já nos disse para "trabalharmos nos controllers agora" ou "nos concentrarmos no diretório de modelos"? Não, eles pedem para que trabalhemos nos recursos de **faturamento**, gerenciamento de clientes ou reservas. <span style="background:#b1ffff">Esses grupos são o que chamamos de domínios</span>. Eles têm um objetivo de <span style="background:#b1ffff">agrupar os conceitos</span> em nosso projeto que pertencem um ao outro. Embora isso possa parecer trivial a princípio, é mais complicado do que possamos imaginar. É por isso que parte deste livro se concentrará em um conjunto de regras e práticas para manter o nosso código bem ordenado. 

Obviamente, não há uma fórmula matemática que possamos obter porque quase tudo depende do projeto específico em que estamos trabalhando. Portanto, não devemos pensar neste livro como um conjunto fixo de regras. Em vez disso, devemos pensar nele como uma coleção de ideia que podemos usar e desenvolver da maneira como quisermos. É uma oportunidade de aprendizado, muito mais do que uma solução que podemos aplicar a qualquer problema que encontrarmos.

**Domains and Applications**
Se estivermos agrupando ideia, evidentemente surge a pergunta: até onde podemos ir? Podemos agrupar tudo relacionado a faturas: modelos, controllers, resources, validation rules, jobs...

No entanto, essa abordagem levante um problema em aplicativos HTTP clássicos: <span style="background:#d3f8b6">geralmente não há um mapeamento de um para um entre controllers e models</span>. É verdade que, nas APIs REST e para a maioria dos seus controllers CRUD clássicos, pode haver um mapeamento estrito de um para um. Infelizmente, há exceções às regras, e essas exceções nos darão trabalho.

As faturas, por exemplo, simplesmente não são tratadas de forma isolada; elas precisam de um cliente para serem enviadas, precisam de reservas para faturas etc. É por isso que precisamos fazer uma distinção adicional entre o que é <span style="background:#d3f8b6">código de domínio</span> e o que não é. 

Por um lado, <span style="background:#d3f8b6">há um domínio</span>, que representa toda a lógica de negócios e, por outro lado, temos o código que usa, ou seja, consome, esse domínio para integrá-lo à estrutura e expô-lo ao usuário final. 

Os aplicativos fornecem a infraestrutura para que os usuários finais acessem e manipulem a funcionalidade do domínio de forma amigável. Agora, dedicaremos um capítulo para aprofundar as diferenças entre o código de domínio e o código de aplicativo, mas neste ponto já é importante saber que faremos uma distinção entre os dois. Prometo que, em breve, abordaremos várias perguntas que podem estar surgindo em nossas cabeças agora mesmo.

**Domains in practice**
O código de domínio consistirá em classes como models, query builders, domain eventos, validations rules and more; we will look at all these concepts in-depth. 

A camada de aplicativos será um ou vários aplicativos. Cada aplicativo pode ser visto como um aplicativo isolado que tem permissão para usar todo o código do domínio. Em geral, os aplicativos não se comunicam entre si, pelo menos não diferentemente.

Um exemplo poderia ser um painel adm HTTP padrão, e outro poderia ser uma API REST. Também gosto de pensar no console, o artisan do Laravel, como um aplicativo próprio.

Como uma visão geral de alto nível, veja como pode ser a estrutura de pastas de um projeto orientado por domínio:

!![image-2026323046319.png](/image-2026323046319.png)

E é assim que a camada de aplicativos se pareceria:
!![image-2026323349549.png](/image-2026323349549.png)

Podemos notar que o exemplo acima não segue a convenção do Laravel de \App como um único namespace raiz. Como os aplicativos são apenas parte do nosso projeto, e como pode haver vários, não faz sentido usar \App como raiz para tudo.

Se preferir ficar mais próximo da estrutura padrão do Laravel, podemos fazer isso. Lembre-se de que este livro não se trata de fornecer um conjunto fixo de regras, mas de ensinar uma mentalidade. 

Se quisermos separar os namespaces raiz, podemos fazê-lo realizando uma pequena alteração no arquivo *composer.json*:
!![image-202632372145.png](/image-202632372145.png)

Observe que também temos um espaço de nome raiz Support; podemos pensar nele como um local de despejo de todos os pequenos auxiliares que não pertencem a lugar algum. Veremos alguns usos práticos do espaço de nomes Support nos próximos capítulos.

Infelizmente, há mais uma coisa que precisamos fazer para que o Laravel ofereça suporte total aos nossos namespace personalizados. Por padrão, o Laravel examinará a pasta *app/* que contém todo o código do aplicativo, e esse padrão é codificado na classe \illuminate\Foundation\Application

Felizmente, podemos criar facilmente nossa própria versão, da seguinte forma:
```php
namespace App;

class Application extends \Illuminate\Foundation\Application
{
	protected $namespace = 'App\\';
}
```

