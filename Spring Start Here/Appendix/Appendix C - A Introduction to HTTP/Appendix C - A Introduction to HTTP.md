Neste apêndice, discutimos os aspectos essenciais do HTTP que qualquer desenvolvedor precisa conhecer. Felizmente, não precisamos ser um especialista em HTTP ou conhecer sua referência de cor para implementar excelentos aplicativos web. Durante nossa jornada como desenvolvedor de software, aprenderemos outros aspectos do HTTP, mas quero garantir que tenhamos todas as informações necessárias para entender os exemplos que trabalhamos neste livro, começando no capítulo 7.

Por que aprender sobre HTTP em um livro sobre Spring? Porque hoje a maioria dos aplicativos que implementamos com um framework  de aplicação (como o Spring) são aplicativos web, e aplicativos web utilizam HTTP.

Começaremos com o que é HTTP e analisaremos sua definição por meio de uma abordagem visual. Em seguida, discutiremos os detalhes que precisamos conhecer sobre as requisições HTTP feitas por um cliente e como o servidor responde.

## C.1 What is HTTP?
Nesta seção, discutimos o que é HTTP. Prefiro definições simples, então eu o descrevo como a forma como um cliente se comunica com o servidor em um aplicativo web. As aplicações preferem ter maneiras rígidas de *se comunicar*, e **os protocolos oferecem as regras necessárias para a troca de informações.** Vamos analisar a definição de HTTP com uma boa abordagem visual.

HTTP é um protocolo sem estado, baseado em texto e de solicitação-resposta

![[Appendix C - A Introduction to HTTP.png]]
- O HTTP é um protocolo de solicitação-resposta sem estado, baseado em texto que usa o modelo de computação cliente-servidor. 

O HTTP é um protocolo que define a comunicação entre o cliente e um servidor. 

Sem estado (ou *stateless*) significa que, no protocolo HTTP, cada requisição que o cliente faz ao servidor é **tratada como uma transação independente**. O servidor não mantém nenhuma informação ou **memória** sobre requisições anteriores feitas pelo cliente.

Em outras palavras, o servidor não **lembra** do cliente entre requisiçõe sucessivas. Cada solicitação precisa conter todas as informações necessárias para que o servidor possa processá-la e responder adequadamente, sem depender de qualquer dado armazenado de interações passadas.

Isso traz vantagens, como simplicidade e escalabilidade, mas também exige soluções adicionas para aplicativos que precisam de persistência de estado, como sessões de usuário.

## C.2 The HTTP request as a language between client and server
Nesta seção, discutimos a requisição HTTP. Nos aplicativos que implementamos com Spring, será necessário usar a requisição HTTP para enviar dados do cliente para o servidor. Se você estiver implementando o cliente, precisará adicionar dados à requisição HTTP. De qualquer forma, é necessário entender a requisição HTTP. 

A requisição HTTP possui um formato simples. Os aspectos que você precisa levar em consideração são os seguintes:

1. **O URI da requisição**: o cliente usa o caminho para informar ao servidor qual recurso ele está solicitando. O URI da requisição se parece com este exemplo: http://www.manning,com/books/spring-start-here.
2. **O método da requisição -** um verbo que o cliente utiliza para indicar qual ação ele realizará com o recurso solicitado. Por exemplo, quando digitamos um endereço na barra de endereços de um navegador web, o navegador sempre usa um método HTTP chamado GET. Em outras circunstâncias, como veremos nos próximos parágrafos, o cliente pode emitir uma requisição HTTP com um método diferente, como POST, PUT ou DELETE.

3. **Os parâmetros da requisição (opcionais)** - Dados em pequena quantidade que o cliente envia ao servidor junto com a requisição. Quando digo *pequena quantidade*, refiro-me a algo que pode ser expresso em talvez 10 a 50 caracteres. Os parâmetros na requisição não são obrigatórios. Os parâmetros da requisição (também chamados de *query parameters*) são enviados no URI, acrescentando uma expressão de consulta.
4. **Os cabeçalhos da requisição (opcionais)** - dados em pequena quantidade enviados no cabeçalho da requisição. Ao contrário dos parâmetros da requisição, esses valores não são visíveis no URI.
5. **O corpo da requisição (opcional)** - uma quantidade maior de dados que o cliente envia ao servidor na requisição. Quando o cliente precisa enviar dados compostos por algumas centenas de caracteres, ele pode usar o corpo da requisição HTTP. Um corpo na requisição não é obrigatório.

A URI da requisição identifica um recurso no lado do servidor com o qual o cliente deseja trabalhar. O URI é a parte da requisição HTTP que a maioria das pessoas conhece, pois precisamos escrever um URI na barra de endereços do navegador sempre que acessamos um site. O URI tem um formato como o do trecho a seguir. No trecho, < server_location> é o endereço de rede do sistema onde o aplicativo do servidor está em execução, < application_port> é o número da porta que identifica a instância do aplicativo do servidor em execução, e < resource_path> é um caminho que o desenvolvedor associou a um recurso específico. O cliente precisa solicitar um caminho específico para trabalhar com um determinado recurso:
*http://<server_location>:<application_port>/<resource_path>*

![[Appendix C - A Introduction to HTTP-1.png]]
A figura c.2 analisa o formato de um URI de requisição HTTP.

**NOTA:** Um uniform resource identifier (URI) inclui um *uniform resource locator (URL)* e um caminho. Podemos dizer que a fórmula é URI = URL + caminho. No entanto, em muitos casos, você encontrará pessoas confundindo URI com o URL ou considerando-os como sendo a mesma coisa. É importante lembrar que o URL identifica

Uma vez que o cliente identifica o recurso na requisição, ele utiliza um verbo chamado **método de requisição HTTP** para especificar o que irá fazer com o recurso. A forma como o cliente especifica o método depende de como a chamada.

