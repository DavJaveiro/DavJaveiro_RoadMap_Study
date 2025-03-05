*This chapter covers*
- Using the Spring web scopes;
- Implementing a simple login functionality for a web app;
- Redirecting from one page to another in a web app.

O Spring gerencia o ciclo de vida de um bean de maneira diferente, dependendo de como ele é declarado no contexto da aplicação. Neste capítulo, vamos explorar novas formas de gerenciamento de beans dentro do contexto do Spring. Perceberemos que o Spring possui abordagens específicas para gerenciar instâncias em aplicações web, utilizando a requisição HTTP como referência.

Em qualquer aplicação Spring, podemos declarar um bean com um dos seguintes escopos:
- #Singleton - o escopo padrão no Spring, no qual o framework identifica cada instância de forma única pelo nome dentro do contexto;
- #Prototype - um escopo no qual o Spring gerencia apenas o tipo do bean e cria uma nova instância da classe sempre que ela for solicitada (seja diretamente do contexto, via injeção de dependência ou autowiring). 

Neste capítulo, aprenderemos que, em aplicações web, é possível utilizar outros escopos de beans específicos para esse contexto. Chamamos esses escopos de web scopes:
- #Request-scope - o Spring cria uma nova instância do bean para cada requisição HTTP. Essa instância <span style="background:#d4b106">existe apenas durante a requisição</span> específica;
- #Session-scope: o Spring cria uma instância e a mantém na memória do servidor durante toda a sessão HTTP. O framework associa essa instância ao contexto da aplicação e à sessão do cliente.
- #Application-scope: a instância é única dentro do contexto da aplicação e permanece disponível enquanto a aplicação estiver em execução.

 A maioria das aplicações web hoje oferece aos usuários a possibilidade de fazer login e acessar uma conta.
 - Na seção 9.1, usaremos um bean com request-scope para capturar as credenciais do usuário no login, garantindo que a aplicação as utilize apenas durante a requisição de login.
- Na seção 9.2, usaremos um bean com Session-scope para armazenar todos os detalhes relevantes do usuário enquanto ele permanecer autenticado.
- Na seção 9.3, utilizaremos um bean com Application-scope para implementar um contador de logins.

![[Capítulo 9 - Using the Spring web scopes.png]]
Figura 9.1: Vamos implementar a funcionalidade de login em três etapas. Para cada etapa que implementarmos, precisaremos usar um escopo de bean diferente. 

- *Step 1:* Se o usuário fornecer um conjunto correto de credenciais, a aplicação reconhecerá o usuário e confirmará um login bem-sucedido. Não queremos que o Spring mantenha as credenciais na memória da aplicação por mais tempo do que o necessário para a requisição de login ser concluída, por isso, usaremos um **bean** *Request-scope* para implementar essa funcionalidade. 
- *Step 2:* Mantendo os detalhes do usuário autenticado. Após o usuário autenticar-se corretamente com suas credenciais, queremos mantê-lo logado por um período de tempo. Para armazenar os detalhes do usuário e manter o usuário logado por um período mais longo, usaremos a *session HTTP* por meio de um **bean** com #Session-scope.
- *Step 3:* Finalmente, queremos que nossa aplicação conte todas as requisições de login de todos os usuários. Precisamos armazenar o número total de requisições recebidas pela aplicação. Para implementar essa funcionalidade, precisaremos usar um **bean** #Application-scope.

## 9.1 Using the request scope in a Spring web app
As aplicações web são focadas em requisições e respostas HTTP. Por essa razão, e muitas vezes em aplicações web, certas funcionalidades são mais fáceis de gerenciar se o Spring oferecer uma maneira de controlar o ciclo de vida do bean em relação à requisição HTTP.

Com o uso do #Request-scope, o Spring cria uma nova instância a cada requisição HTTP. A aplicação pode usar a instância apenas para a requisição que a criou. Qualquer nova requisição HTTP (de clientes iguais ou diferentes) cria e usa uma instância diferente da mesma classe.

![[Capítulo 9 - Using the Spring web scopes-1.png]]
Richard é o usuário. Para a primeira requisição HTTP, o Spring cria uma instância do **bean LoginProcessor**, que tem escopo de requisição. O Spring gerencia o tipo do bean e cria uma nova instância para cada requisição HTTP. Nesta figura, a planta de café é o tipo de bean que o Spring gerencia, e o grão de café é a instância.

Para uma segunda requisição HTTP, Spring cria uma outra instância do bean LoginProcessor. Observamos que o hash da instância é diferente no Spring Context.

Vamos demonstrar o uso de um **bean com escopo de requisição** em um exemplo. Implementaremos a funcionalidade de login de uma aplicação web e usaremos um **bean com escopo de requisição** para gerenciar as credenciais do usuário na lógica de login.

---
**Aspectos chave dos beans com escopo de requisição**
Antes de mergulharmos na implementação de uma aplicação Spring que usa beans com escopo de requisição, gostaria de enumerar brevemente os aspectos chave de como usar esse escopo de bean. Esses aspectos ajudarão você a analisar se um **bean com escopo de requisição** é a abordagem certa em um cenário do mundo real. Tenha em mente os aspectos muito relevantes dos beans com escopo de requisição, explicados na tabela a seguir.

| **Fato**                                                                            | **Consequência**                                                                                                                                                    | **A considerar**                                                                                                                                                                                                                                                                                                            | **Evitar**                                                                                                                                                                                                                                                                                     |
| ----------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| O Spring cria uma nova instância para cada requisição HTTP de qualquer cliente.     | O Spring cria muitas instâncias desse bean na memória da aplicação durante sua execução.                                                                            | O número de instâncias geralmente não é um grande problema, *pois essas instâncias têm vida curta*. A aplicação não precisa delas por mais tempo do que o necessário para a requisição HTTP ser concluída. Após a conclusão da requisição HTTP, a aplicação libera as instâncias, que são coletadas pelo garbage collector. | Certifique-se de não implementar uma lógica demorada que o Spring precise executar para criar a instância (como obter dados de um banco de dados ou realizar uma chamada de rede). Evite escrever lógica no construtor ou em um método **@PostConstruct** para beans com escopo de requisição. |
| Somente uma requisição pode usar uma instância de um bean com escopo de requisição. | Instâncias de beans com escopo de requisição não estão sujeitas a problemas relacionados a multithreading, pois apenas um thread (o da requisição) pode acessá-las. | Você pode usar os atributos da instância para armazenar dados usados pela requisição.                                                                                                                                                                                                                                       | Não use técnicas de sincronização para os atributos desses beans. Essas técnicas seriam redundantes e só afetariam o desempenho da sua aplicação.                                                                                                                                              |

**NOTA:** Um exemplo de login, como este, é excelente para fins didáticos. No entanto, em uma aplicação pronta para produção, é melhor evitar implementar mecanismos de autenticação e autorização por conta própria. Em uma aplicação Spring do mundo real, usamos o **Spring Security** para implementar qualquer coisa relacionada à autenticação e autorização. Usar o **Spring Security** (que também fazer parte do ecossistema Spring) simplifica suas implementações e garante que não introduzamos vulnerabilidade ao escrever a lógica de segurança no nível da aplicação. 

Para simplificar, vamos considerar um conjunto de credenciais que inserimos diretamente na nossa aplicação. Em uma aplicação real, os usuários são armazenados em um banco de dados. Além disso, as senhas são criptografadas para protegê-las. Por enquanto, focaremos apenas no objetivo deste capítulo: discutir os escopos do beans em aplicações web no Spring. Mais adiante, nos capítulos 11 e 12, aprenderemos mais sobre como armazenar dados em um banco de dados.

Vamos criar um projeto Spring Boot e adicionar as dependências necessárias. Você encontrará este exemplo no projeto “sq-ch9-ex1.” Você pode adicionar as dependências diretamente ao criar o projeto (por exemplo, usando start.spring.io) ou depois, em seu **pom.xml**. Para este exemplo, usaremos a dependência **web** e o **Thymeleaf** como mecanismo de template (como fizemos no capítulo 8). O próximo trecho de código mostra as dependências que você precisa ter no seu arquivo **pom.xml**:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
 Vamos criar uma página contendo um formulário de login que solicita o nome de usuário e a senha. O aplicativo comparará essas informações com um conjunto de credenciais predefinidas (neste caso, usuário "natalie" e senha "password").
- Se fornecermos credenciais corretas (que correspondem às armazenadas no sistema), a página exibirá a mensagem: "You are now logged in" abaixo do formulário de login.
- Caso as credenciais estejam incorretas, a aplicação exibirá a mensagem: "Login Failed".

Como já aprendemos, precisamos implementar uma página (que representa a view) e uma classe #controller. O #controller será responsável por processar a requisição e enviar a mensagem apropriada para a view, de acordo com o resultado do login.

![[Capítulo 9 - Using the Spring web scopes-2.png]]
- O cliente envia uma requisição HTTP contendo as credenciais de login;
- O controller verifica se as credenciais são válidas e envia uma mensagem para a view de acordo com o resultado do login.
- A view exibe a mensagem que recebeu através do controller.

[[login.html]]

Uma *controller action* precisa receber a requisição HTTP (vinda do dispatcherServlet). Então, vamos definir o controller e a ação que processa a requisição da página que criamos.

```java
@Controller  
public class LoginController {  
  
    @GetMapping("/")  
    public String loginGet() {  
        return "login.html";  
    }  
}
```
- Aqui, nós usamos a annotation stereotype @Controller para definir a classe como um *Controller* do Spring MVC;
- Nós mapeamos a ação do *controller* para caminho raiz da aplicação "/";

Agora que temos uma página de login, queremos implementar a lógica de autenticação. Quando o usuário clicar no botão *submit*, a página deve exibir uma mensagem apropriada abaixo do formulário de login.

Para processar a requisição HTTP POST gerada pelo formulário HTML quando o usuário clica no botão **Submit**, precisamos adicionar mais uma ação ao nosso *LoginController*.

Essa ação receberá os parâmetros enviados pelo cliente (nome de usuário e senha) e determinará a mensagem apropriada para a visualização de acordo com o resultado do login.

Até agora, ainda não implementamos a lógica de login.

Nós apenas pegamos a requisição e enviamos uma mensagem em resposta com base em uma variável chamada *loggedIn*, que atualmente está sempre definida como *false*.

Nós próximos trechos de código desta seção, completaremos essa ação adicionando uma chamada para a lógica de login. Essa lógica verificará as credenciais enviadas pelo cliente e retornará o resultado apropriado.

Agora que temos um controller e uma view, onde está o *request scope* em tudo isso? A única classe que escrevemos é o *LoginController*, e a deixamos como um singleton, que é o escopo padrão do Spring. Não precisamos mudar o escopo do *LoginController*, desde que ele não armazene nenhum detalhe em seus atributos.
Mas lembre-se que precisamos implementar a lógica de login. Essa lógica depende das credenciais do usuário e devemos considerar dois pontos sobre essas credenciais:
- As credenciais são detalhes sensíveis, e não queremos armazená-las na memória do aplicativo por mais tempo do que o necessário para a requisição de login.
- Vários usuário com credenciais diferentes podem tentar fazer login simultaneamente.
Considerando esses dois pontos, precisamos garantir que, se usarmos um bean para implementar a lógica de login, cada instância seja única para cada requisição HTTP. Precisamos usar um bean com escopo de requisição. Vamos expandir o aplicativo conforme apresentado na figura 9.5. Adicionamos um bean com escopo de requisição, o LoginProcessor que recebe as credenciais na requisição e valida.

A listagem 9.4 mostra a implementação da classe LoginProcessor. Para alterar o escopo do bean, usamos a anotação `@RequestScoped`. Claro, ainda precisamos tornar um bean desse tipo na configuração do Spring, utilizando a anotação `@Bean` em uma classe de configuração ou uma anotação de estereótipo. Eu escolhi anotar a classe com a anotação de estereótipo `@Component`.

[[LoginProcessor.java]]

- We use the *@RequestScope* annotation to change the bean's scope to request scope. This way, Spring creates a new instance of the class for every HTTP request.\

Precisamos saber que, por padrão, o TomCat já fornece um provedor de sessão. Ele gerencia as sessões HTTP por padrão, o que significa que, quando usamos o Tomcat em uma aplicação web, ele cuida da criação, manutenção e expiração das sessões de usuário automaticamente.

Por exemplo, quando um usuário acessa a aplicação, o Tomcat cria uma sessão associada ao usuário e armazena o identificador dessa sessão em um cookie. Ele também oferece métodos para acessar e manipular os dados da sessão, como `request.getSession()` no contexto de um servlet. Esses dados ficam disponíveis enquanto a sessão estiver ativa.

Se você estiver utilizando o Spring, por exemplo, pode configurar beans de escopo de sessão com a anotação `@Scope("session")` para aproveitar a sessão gerenciada pelo Tomcat e integrar o gerenciamento de estado de sessão com o ciclo de vida dos beans no Spring.

## 9.2 Using the session scope in a Spring web app
Nesta seção, discutimos os *session-scoped beans*. Quando acessamos um aplicativo web e fazemos login, espera poder navegar pelas páginas desse aplicativo enquanto ele ainda se lembra que você está autenticado. Um *session-scoped bean* é um objeto gerenciado pelo Spring, para o qual o Spring cria uma instância e a vincula à HTTP Session. Essa instância pode ser reutilizada para o mesmo cliente enquanto nossa HTTP permanecer ativa. Os dados armazenados nos atributos do *session-scoped bean* ficam disponíveis para todas as requisições do cliente ao longo de uma *HTTP session*.

Essa abordagem permite armazenar informações sobre as ações dos usuários enquanto eles navegam pelas páginas do nosso aplicativo.

![[Capítulo 9 - Using the Spring web scopes-3.png]]

O #Session-scope bean é criado pelo Spring e vinculado à *HTTP Session*, permitindo que os dados do usuário sejam mantidos durante toda a sessão. Já o #Request-scope bean é criado para cada requisição e descartado após sua conclusão.

![[Capítulo 9 - Using the Spring web scopes-4.png]]
**Request-scoped beans** - para cada requisição, o Spring cria uma instância do bean diferente.


**Session-scoped beans** - 
![[Capítulo 9 - Using the Spring web scopes-5.png]]
- Durante a mesma *HTTP Session*, duas requisições diferentes do mesmo cliente recebem a mesma instância do bean.

Alguns recursos que podem ser implementados com *session-scoped beans* incluem:
- **Login** - mantém os detalhes do usuário autenticado enquanto ele navega pelo aplicativo e faz várias requisições;
- **Carrinho de compras online** - armazena os produtos adicionados pelo usuário enquanto ele explora diferentes páginas do aplicativo.

Aqui está a tabela com os principais aspectos dos _session-scoped beans_:

|**Fato**|**Consequência**|**A Considerar**|**Evitar**|
|---|---|---|---|
|Os _session-scoped beans_ permanecem ativos durante toda a _HTTP session_.|Têm um ciclo de vida mais longo e são menos frequentemente coletados pelo _garbage collector_ do que os _request-scoped beans_.|Os dados armazenados nesses _beans_ permanecem disponíveis por mais tempo.|Armazenar grandes volumes de dados na sessão, pois pode impactar o desempenho. Nunca armazenar informações sensíveis (senhas, chaves privadas etc.).|
|Múltiplas requisições podem compartilhar a mesma instância do _session-scoped bean_.|Se um mesmo cliente fizer requisições concorrentes que alteram os dados do _bean_, podem ocorrer problemas de concorrência, como _race conditions_.|Se esse cenário for possível, pode ser necessário usar técnicas de sincronização.|Depender da sincronização como solução primária. O ideal é evitar esse tipo de concorrência sempre que possível.|
|Os _session-scoped beans_ permitem compartilhar dados entre requisições, armazenando-os no servidor.|A lógica implementada pode tornar as requisições dependentes umas das outras.|Manter o estado na memória do aplicativo pode criar dependência do cliente com uma instância específica do sistema.|Tornar as requisições dependentes entre si. Avalie armazenar os dados em um banco de dados para manter a independência das requisições.|

Continuamos usando um *session-scoped* bean para que o aplicativo reconheça que um usuário fez login e o identifique como autenticado enquanto ele acessa diferentes páginas. Dessa forma, o exemplo ensina todos os detalhes relevantes para trabalhar com aplicações em produção.

Vamos modificar a aplicação implementada na seção 9.1 para exibir uma página acessível apenas para usuários autenticados. Após o login, o aplicativo redireciona o usuário para esta página, que exibe uma mensagem de boas-vindas com seu nome de usuário e a opção de logout por meio de um link.

Esses são os passos necessários para implementar essa mudança:
1. Criar um *session-scoped* bean para armazenar os detalhes do usuário autenticado;
2. Criar a página que só pode ser acessada após o login;
3. Garantir que a página criada no passo 2 não possa ser acessada sem autenticação;
4. Redirecionar o usuário para a página principal após um login bem-sucedido.

Felizmente, criar um *session-scoped* bean no Spring é simples, basta usar a anotação *@SessionScope* na classe do bean. Vamos criar uma nova classe. *LoggedUserManagementService*, e torná-la *Session-scoped*, conforme apresentado na lista a seguir:
```java
@Sesssion
@SessionScope
public class LoggedUserManagementService {
	private String username;

	// Omitted getters and setters
}
```

- We add the @Service stereotype annotation to instruct Spring to manage this class as a bean in its context;
- We use the @SessionScope annotation to change the scope of the bean to session.

Sempre que um usuário faz login com sucesso, armazenamos o nome dele no *atributo* *username*. Auto-wiremos o *bean* *LoggedUserManagementService* na classe *LoginProcessor*, que implementamos na seção 9.1 para cuidar da lógica de autenticação.

Observe que o bean *LoginProcessor* permanece com escopo de requisição, continuamos utilizando o Spring para criar essa instância para cada requisição de login, precisamos apenas dos valores dos atributos username e password durante a requisição para executar a lógica de autenticação.

Como o bean *LoggedUserManagementService* tem escopo de sessão, o valor do username estará agora acessível por toda a sessão HTTP. Podemos usar esse valor para saber se alguém está logado e quem é. Não precisamos nos preocupar com o caso em que múltiplos usuários estão logados; o framework da aplicação garante que cada requisição HTTP seja vinculada à sessão correta. A figura abaixo descreve visualmente o fluxo de login.


![[Capítulo 9 - Using the Spring web scopes-6.png]]

- Are the credentials valid? *Yes*, Stores the username in the session-scoped bean. Redirect to the main page.

Agora criamos uma nova página e garantimos que um usuário possa acessá-la somente se ele já tiver feito login. Definimos um novo controlador (que chamaremos de MainController) para a nova página. Definiremos uma ação e a mapearemos para o caminho */main*. Para garantir que um usuário possar acessar esta caminho somente se ele tiver feito login, verificaremos se o bean *LoggedUserManagementService* armazena algum nome de usuário. Se não armazenar, redirecionamos o usuário para a página de loging. Para redirecionar o usuário para outra página, a ação do controller precisa retornar a string *redirect*: seguida pelo caminho para o qual a ação deseja redirecionar o usuário. 

*Is the username already in the session-scoped bean? Is equivalent with Did the user already log in?*

Permitir que o usuário também faça logout é fácil. Só precisarmos definir o nome de usuário no bean de sessão *LoggedUserManagementService* como *null*. Vamos criar um link de logout na página e também adicionar o nome de usuário logado na mensagem de boas-vindas. A listagem a seguir mostra as alterações na página *main.html* que define nossa visualização. 

[[main.html]]
We add a link on the page that sets an HTTP request parameter name "logout". When the controller gets this parameter, it will erase the value of the username from the session.

Essas alterações na página main.html também assumem algumas mudanças no controller para que a funcionalidade esteja completa. 

[[Spring Start Here/codes/sq-ch9-ex2/src/main/java/org/example/main/login/controller/MainController.java|MainController]]

To complete the app, we'd to change the *LoginController* to redirect users to the main page once they authenticate. To achieve this result, we need to change the *LoginController* action, as presented in the following listing.

## 9.3 Using the application scope in a Spring web app
Nesta seção, discutiremos o escopo da aplicação. Quero mencionar sua existência, torná-lo consciente de como ele funciona e enfatizar que é melhor não usá-lo em um aplicativo de produção. Todas as solicitações dos clientes compartilham um bean com escopo de aplicação.

O escopo da aplicação é semelhante ao funcionamento de um singleton. A diferença é que não podemos ter mais instâncias do mesmo tipo no contexto e que 
sempre usamos as solicitações HTTP como ponto de referência ao discutir o ciclo de vida dos escopos da web (incluindo o escopo da aplicação). Enfrentamos os mesmos problemas de concorrência discutidos no capítulo 5 para os beans singleton em relação aos beans com escopo de aplicação: é melhor ter atributos imutáveis para os beans singleton. O mesmo conselho é aplicável a um bean com escopo de aplicação. Mas, se você tornar os atributos imutáveis, então pode usar diretamente um bean singleton.

Geralmente, recomendo que os desenvolvedores evitem usar **beans com escopo de aplicação.** É melhor utilizar diretamente uma **camada de persistência**, como um banco de dados (que aprenderemos no **capítulo 11**).

Sempre é melhor ver um exemplo para compreender o caso. Vamos modificar o aplicativo em que trabalhamos neste capítulo e adicionar uma funcionalidade que **conte as tentativas de login.** Você encontrará este exemplo no projeto "sq-ch9-ex3".

![[Capítulo 9 - Using the Spring web scopes-7.png]]

O bean *LoginCountService* é um bean com escopo de aplicação. Existe apenas uma instância desse tipo no contexto do Spring. Qualquer requisição de qualquer cliente usa essa mesma instância. 

Como precisamos contar as tentativas de login de todos os usuários, armazenaremos essa contagem em um bean com escopo de aplicação.

Vamos criar um bean *LoginCountService* com escopo de 

[[LoginCountService.java]]
- The *@ApplicationScope* annotation changes the scope of this bean to the application scope.

O *LoginProcessor* pode então injetar automaticamente esse bean e chamar o método *increment()* para cada nova tentativa de login.

A última coisa que precisamos fazer é exibir esse valor. Como aprendemos nos exemplos anteriores, é possível usar um parâmetro *Model* na ação do controller para enviar o valor de contagem par aa view. Em seguida, usamos o thymeleaf para exibir esse valor na interface. 
