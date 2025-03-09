*This chapter covers*
- What a data source is;
- Configuring a data source in a Spring app;
- Using JdcbTemplate to work with a database.

Quase todos os aplicativos hoje precisam armazenar os dados com os quais trabalham, e muitas vezes os aplicativos utilizam bancos de dados para gerenciar os dados que persistem. Por muitos anos, os bancos de dados relacionais têm fornecido aos aplicativos uma maneira simples e elegante de armazenar os dados, que pode ser aplica com sucesso em muitos cenários. Aplicativos Spring, assim como outros aplicativos, muitas vezes precisam usar bancos de dados para persistir dados, e por essa razão, precisamos aprender como implementar essas funcionalidades em nossos aplicativos Spring.

Neste capítulo, discutimos o que é uma fonte de dados (**data source**) e a maneira mais direta de fazer seu aplicativo Spring trabalhar com um banco de dados. Essa maneira direta é a ferramenta **JdbcTemplate** que o Spring oferece. 

A figura 12.1 mostra o seu progresso nos capítulos anteriores ao aprender a usar o Spring para implementar várias funcionalidades fundamentais em um sistema. Fizemos um bom progresso, e agora podemos usar o Spring para implementar funcionalidades em várias partes de um sistema.

## 12.1 What a data source is
Nesta seção, discutimos um componente essencial que nosso aplicativo Spring precisa para acessar um banco de dados: a **fonte de dados**. A fonte de dados é um componente que gerencia as conexões com o servidor que manipula o banco de dados (o sistema de gerenciamento de banco de dados, também conhecido como **DBMS**). 

**NOTA:** o DBMS é um software cuja responsabilidade é permitir que gerenciemos dados persistentes de forma eficiente (adicionar, alterar, recuperar), mantendo-os seguros. Um DBMS gerencia os dados em bancos de dados. Um **banco de dados** é uma coleção persistente de dados.

![[Capítulo 12 - Using Data Sources in Spring Apps.png]]
1. A fonte de dados gerencia as conexões. Ela fornece ao aplicativo conexões quando solicitadas e garante que novas conexões sejam criadas apenas quando necessário.

2. Uma fonte de dados (data sources) usa o driver JDBC para conectar-se ao DBMS (sistema de gerenciamento de banco de dados).