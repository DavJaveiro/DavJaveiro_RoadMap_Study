**Spring Boot Architecture**
O Spring Boot consiste em diferentes camadas e classes para processar os dados e a lógica em nosso backend. As quatro camadas e seu uso são os seguintes:
1. Camada de Apresentação (Presentation Layer): a camada de apresentação é responsável por interpretar parâmetros JSON como objetos. Esta é a camada superior, que também é responsável por lidar com a autenticação e as requisições HTTP. Após realizar a tradução do JSON e a autenticação, passamos para a camada de negócio. 
2. Camada de Negócio (Business Layer) a camada de negócio, como o nome sugere, lida com toda a lógica de negócio da aplicação. Ela é composta por classes de serviço que realizam autorização e validações adicionais. 
3. Camada de Persistência: a camada de persistência é a principal responsável pela lógica de armazenamento, que converte objetos de e para linhas do banco de dados para inserir e recuperar dados.
4. Camada de Banco de Dados (Database Layer): a camada de banco de dados realiza as operações de Criar, Ler, Atualizar e Excluir (CRUD). Essa camada pode consistir em múltiplos bancos de dados.

## Dependency Injection
Geramos com sucesso nosso próprio projeto Spring Boot e agora começaremos a aprender os conceitos do Spring. Um dos mais importantes que precisamos entender é a injeção de dependência. Ao desenvolvermos nosso backend com Spring Boot, usaremos principalmente a injeção de dependência durante o processo, pois isso torna nosso programa Java modular e facilita a troca de implementações.

A injeção de dependência é um recurso essencial das linguagens de programação orientada a objetos, mas primeiro, vamos discutir o conceito de **inversão de controle**, que é o que a injeção de dependência busca alcançar.

## Inversão de Controle
Inversão de Controle é um padrão de projeto *design pattern* usado em linguagens de programação orientada a objetos. O IoC é um conceito de inverter o fluxo do nosso programa e é usado para desacoplar os componentes em nossa aplicação, tornando o nosso código reutilizável e modular. Assim, o padrão de projeto IoC nos fornecerá uma maneira de injetar uma classe personalizada em outras classes de nossa aplicação.

A classe injetada será instanciada em diferentes partes de nossa aplicação. Em vez de deixar nossa classe decidir suas implementações ou fazer suas próprias correções de código, permitimos que a injeção de dependência altere o fluxo, o desempenho e o código da classe, dependendo do caso. Dessa forma, o IoC oferece principalmente flexibilidade e modularidade, mas também proporciona várias outras vantagens no design de nossa aplicação:
- Tendo o controle do **ciclo de vida de um objeto**, podemos definir alguns objetos como _singleton_ (instância única), enquanto outros objetos podem ter sua própria instância.
- Torna a aplicação **mais fácil de manter**, pois a quantidade de código é reduzida devido aos componentes reutilizáveis.
- **Testar componentes** é mais gerenciável, pois podemos isolar componentes e simular (_mockar_) suas dependências, sem abranger outro código que não será incluído no teste unitário.

Aprendemos sobre o padrão IoC e como ele é vantajoso para o desenvolvimento de nossa aplicação. Agora, usaremos a injeção de dependência, que nos permite alcançar esse padrão.

## The Basics of Dependency Injection
Já discutimos como o **IoC** funciona: ele é alcançado permitindo que a implementação de um objeto seja decidida pelas dependências que lhe são fornecidas. Essa ideia é, em essência, a **injeção de dependência**. 💉

Nós permitimos que objetos ou classes aceitem outras dependências que podem fornecer implementações de diferentes classes sem que precisemos escrevê-las novamente, tornando nosso código **flexível** e **reutilizável**. A injeção de dependência pode ser realizada de diferentes maneiras, e a seguir estão as suas implementações.

**Constructor-based dependency injection**
