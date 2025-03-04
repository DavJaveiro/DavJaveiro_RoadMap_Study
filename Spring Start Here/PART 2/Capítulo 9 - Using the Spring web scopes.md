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


