*This chapter covers*
- Uma visão geral do Spring Security e das ameaças de segurança comuns;
- Habilitando o Spring Security em uma aplicação Spring Boot e entendendo a autoconfiguração do Spring Security;
- Personalizando o Spring Security com autenticação em memória, JDBC e LDAP;
- Implementando autenticação HTTP básica em um projeto Spring Boot.

Nos capítulos anteriores, aprendemos várias técnicas essenciais para construir aplicações Spring Boot e agora dominamos os conceitos fundamentais do Spring Boot. Aprendemos diversas técnicas de comunicação com o banco de dados, sabemos como monitorar aplicações Spring Boot com o Spring Boot Actuator e estamos prontos para começarmos a desenvolver aplicações Spring Boot de nível empresarial.

No entanto, antes de nos empolgarmos, há outra técnica essencial que precisamos dominar: a **segurança das nossas aplicações Spring Boot**.

Neste capítulo, exploraremos várias técnicas para proteger aplicações Spring Boot com **Spring Security**.

## 5.1 Introducing Spring Security
Nos capítulos anteriores, vimos a utilização de alguns dos principais módulos do Spring, como **Spring MVC** e o **Spring Data**, além de funcionalidades como **Spring Boot Actuator** e **DevTools**. O Spring Framework fornece um módulo dedicado chamado **Spring Security**, que foca nos aspectos de segurança das aplicações Spring. O **Spring Boot** facilita a integração com o **Spring Security** por meio da dependência *spring-boot-starter-security*. 

Neste capítulo, demonstraremos como utilizar o **Spring Security** em aplicações **Spring Boot**.

No entanto, antes de aprofundarmos nas técnicas para implementar diversos recursos de segurança oferecidos pelo **Spring Security**, vamos explorar algumas das funcionalidades padrão oferecidas pelo **Spring Security** em uma aplicação Spring Boot:
- O **Spring Security** exige que os usuários da aplicação sejam autenticados antes de acessá-la;
 - Se a aplicação não possuir uma página de login, o **Spring Security** <span style="background:#d4b106">gera uma página de login padrão para autenticação e permite que o usuário faça logout da aplicação</span>;
 - O Spring Security cria um usuário padrão chamado *user* e gera uma senha padrão (impressa no log do console) para login baseado em formulário. O Spring Security gera automaticamente uma página HTML de login (formulário) quando acessamos a URL protegida. 
 - São fornecidos diversos codificadores de senha para criptografar senhas em texto simples e armazená-las de forma segura no banco de dados.
 - O Spring Security <span style="background:#d4b106">previne ataques</span> de **fixação de sessão**, <span style="background:#d4b106">alterando o ID da sessão</span> após a autenticação bem-sucedida do usuário.
- O Spring Security oferece proteção contra ataques de **Cross-Site Request Forgery (CSRF)**. Ele inclui um token gerado aleatoriamente na resposta HTTP e espera que esse token esteja presente em todas as requisições baseadas em formulário que pretendam realizar operações que alterem o estado da aplicação. Um usuário mal-intencionado não terá acesso ao token e, portanto, não poderá realizar ataques **CSRF**. A figura 5.1 demonstra essa proteção no **Spring Security**.
- Por padrão, o **Spring Security** inclui vários cabeçalhos de resposta HTTP que ajudam a prevenir diversos tipos comuns de ataques. Esses cabeçalhos são mostrados na listagem a seguir.
![[Capítulo 5 - Securing Spring Boot Applications.png]]
1. O usuário se autentica e uma sessão HTTP é criada;
2. O servidor retornar o token CSRF na resposta HTTP;
3. O usuário acessa o site com as credenciais da sessão e o token CSRF;
Portanto, elas evitam que **requisições maliciosas** sejam aceitas quando feitas por sites ou scripts externos tentando agir em nome do usuário sem o seu consentimento.
Se o token não estiver presente ou estiver incorreto, a requisição é rejeitada - mesmo que o cookie de sessão seja válido.

```json
Cache-Control: no-cache, no-store, max-age=0, must-revalidate Pragma: no-cache
Expires: 0
X-Content-Type-Options: nosniff
Strict-Transport-Security: max-age=31536000 ; includeSubDomains X-Frame-Options: DENY
X-XSS-Protection: 1; mode=block
```
Vamos explorar esses cabeçalhos e seu papel na proteção de uma aplicação **Spring Boot**:
- O cabeçalho **Cache-Control** instrui o navegador a desabilitar completamente o cache do navegador. Esse cabeçalho garante que o conteúdo sempre seja buscado do servidor, e nunca de uma versão armazenada em cache, o que é importante em: páginas com informações sensíveis; dados que mudam com frequência; respostas que não podem ficar salvas localmente por segurança.

- O cabeçalho **X-Content-Type-Options**: impede que o navegador tente adivinhar o tipo de conteúdo de uma requisição quando o cabeçalho **Content-Type** está **ausente** na requisição.

- O cabeçalho **Strict-Transport-Security** aplica a política de HTTP Strict Transport Security (HSTS). 

- O cabeçalho X-XSS-Protection com 1;mode=block previne ataques de **Cross-Site Scripting (XSS) reflexivo**. O valor 1 ativa o filtro XSS embutido no navegador, e a opção **mode=block** permite que o navegador impeça o carregamento de uma página se um ataque XSS for detectado.

## 5.2 Hello Spring Security with Spring Boot
Nesta seção, vamos introduzir o Spring Security na aplicação de controle acadêmico (course tracker).

### 5.2.1 Técnica: ativando a segurança da aplicação com Spring Security em uma aplicação Spring Boot
Nesta técnica, vamos demonstrar como ativar a segurança da aplicação com o Spring Security.

**Problem:** desenvolvemos uma aplicação Spring Boot. No entanto, não há nenhuma implementação de segurança da aplicação. Precisamos implementar uma segurança básica para a aplicação.

**Solution:** a forma mais simples de fornecer segurança em uma aplicação Spring Boot é incluir a dependência *spring-boot-starter-security* no arquivo **pom.xml**. Essa dependência é mostrada no seguinte trecho:

A dependência *spring-boot-starter-security* traz todas as bibliotecas necessárias e ativa o Spring Security na aplicação Spring Boot. Essa dependência inicial (starter) inclui as bibliotecas principais do Spring Security, como *spring-security-config* e *spring-security-web*, na aplicação.

Podemos iniciar a aplicação utilizando a opção de configuração de execução (run configuration) da IDE. Uma vez que a aplicação seja iniciada com sucesso, acessaremos a página inicial (index) da aplicação através da URL *http://localhost:8080/index*. Para nossa surpresa, encontraremos uma página de login pedindo que façamos a autenticação, em vez de exibir a página inicial da aplicação. Isso acontece porque incorporamos o Spring Security à nossa aplicação, e ele automaticamente ativou um login baseado em formulário. Por padrão, o Spring Security exibe a página de login, como mostrado na figura 5.2, para que possamos nos autenticar-se na aplicação.

O nome de usuário (username) padrão para a aplicação é **user**. O Spring Boot gera e exibe uma senha no log do console. Essa senha muda cada vez que a aplicação é reiniciada. Essa senha padrão pode não ser conveniente para uma aplicação em produção. 

Agora, estamos autenticados na aplicação e podemos acessar todas as funcionalidades, como adicionar um novo curso, editar um curso existente e excluir um curso existente. Também podemos sair da aplicação clicando no botão de logout (sair) localizado no canto superior direito da interface.

Por padrão, o Spring Security disponibiliza o endpoint */logout*. No exemplo do controle acadêmico (course tracker), incluímos o botão de logout na página inicial da aplicação. Ao clicar neste botão, o endpoint */logout* é acionado e somos desconectados da aplicação.

Se quisermos customizar o comportamento do logout (como mudar a URL, definir uma página específica após o logout ou desativar a proteção CSRF apenas para esse endpoint), podemos configurar isso dentro da classe de configuração de segurança do Spring, por exemplo:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .logout()
                .logoutUrl("/logout") // padrão, mas você pode alterar se quiser
                .logoutSuccessUrl("/login?logout") // redireciona após logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
            .csrf().disable(); // opcional, dependendo do caso

        return http.build();
    }
}
```

**Discussão**
Com essa técnica, aprendemos como ativar a segurança padrão de uma aplicação Spring Boot usando o Spring Security. Observamos que incluir a dependência *spring-boot-starter-security* no arquivo *pom.xml* ativa magicamente um certo nível de segurança na aplicação por meio de um login baseado em formulário. O Spring Boot também gera uma senha para acesso à aplicação. 

A inclusão da dependência *spring-boot-starter-security* integra o ecossistema do Spring Security à aplicação. Podemos verificar a dependência no arquivo **pom.xml** e verificar que ela possui dependências transitivas para as bibliotecas *spring-security-config* e *spring-security-web*. Juntas, essas duas bibliotecas fornecem o suporte necessário ao funcionamento do Spring Security.

Como já vimos anteriormente com a autoconfiguração do Spring Boot, a presença das bibliotecas do Spring Security no classpath da aplicação permite que o Spring Boot configure automaticamente os componentes necessários de segurança. Em breve, examinaremos quais são esses componentes e como eles são configurados na seção sobre autoconfiguração do Spring Security.

![[Capítulo 5 - Securing Spring Boot Applications.png]]

Antes de nos familiarizarmos com o funcionamento interno do Spring Security, vamos apresentar uma visão geral muito elevada do processo de autenticação em uma aplicação Web típica. O diagrama acima ilustra a sequência de etapas:
1. Tentamos acessar a página inicial da aplicação acessando uma URL Web (por exemplo, `http://localhost:8080`) na aplicação course tracker;
2. A requisição chega ao servidor, e ele verifica que estamos tentando acessar um recurso protegido;
3. Como ainda não estamos autenticado, o servidor responde indicando que é necessário autenticar-se. Essa resposta pode ser um código de resposta HTTP ou um <span style="background:#d4b106">redirecionamento para uma página Web</span>, dependendo da implementação de segurança no servidor.
4. Com base nos mecanismos de autenticação configurados no servidor, o navegador irá nos redirecionarmos para uma página de login ou recuperar as credenciais por outros meios, como a caixa de diálogo de autenticação básica HTTP ou um cookie. Aprenderemos como configurar esses mecanismos de autenticação no servidor em técnicas posteriores.
5. As credenciais são então enviadas de volta ao servidor. O navegador pode usar uma requisição HTTP POST (por exemplo, em uma página de login) ou um cabeçalho HTTP (por exemplo, em autenticação BASIC) para enviar as credenciais ao servidor.
6. O servidor valida as credenciais. Se forem válidas, o login é considerado bem-sucedido e o servidor avança para a próxima etapa. No entanto, se as credenciais forem inválidas, normalmente o navegador pede para tentar novamente, retornando à etapa 3.
7. Se o login for bem-sucedido e o usuário possuir as autoridades (permissões) necessárias, a requisição será concluída com sucesso. Caso contrário, o servidor retorna o código de erro HTTP 403 (*Forbidden*). 
8. Quando o usuário faz logout da aplicação, o servidor limpa a sessão e outras credenciais armazenadas e desconecta o usuário. Em seguida, redireciona o usuário para a página de login ou para a página inicial da aplicação, com base na configuração de segurança do servidor. 

Na próxima seção, iniciaremos com a arquitetura do Spring Security e aprenderemos como os passos acima são implementados dentro do Spring Security.


**Note:**
O Spring Security é um assunto extenso e contém diversas funcionalidades. Está além do escopo deste texto oferecer cobertura aprofundada dos conceitos do Spring Security e das várias funcionalidades que ele oferece. Neste livro, abordaremos os conceitos mínimos de Spring Security que precisamos para continuar com as técnicas subsequentes.

Neste capítulo e no próximo, aprenderemos várias técnicas que demonstram como implementar diferentes funcionalidades de segurança aproveitando o Spring Security. Como este é um livro sobre Spring Boot, manteremos nosso foco limitado ao uso do Spring Security no contexto do Spring Boot.

Para um entendimento mais aprofundado do Spring Security, recomendamos consultar livros dedicados ao Spring Security ou o material de referência oficial...
### 5.2.2 Filter, FilterChain, and Spring Security
Em uma aplicação web Java típica, um cliente solicita ao servidor o acesso a um recurso por meio do protocolo HTTP ou HTTPS. A solicitação do cliente no servidor é tratada por um *servlet*. O *servlet* processa a requisição HTTP e fornece uma resposta HTTP. Essa resposta é enviada de volta ao cliente. Em uma aplicação web Spring, esse *servlet* é o *DespatecherServlet*, que trata todas as requisições recebidas pela aplicação.

Um componente fundamental da especificação de **Servlet** que desempenha um papel fundamental no processamento da requisição-resposta é o *Filter*. Um #Filter fica posicionado antes de um *Servlet* e <span style="background:#d4b106">intercepta a troca de requisição-resposta</span>. Ele pode realizar alterações nos objetos de requisição e resposta, como mostrado na Figura 5.6. Um ou mais filters podem ser configurados por meio de uma *FilterChain*, e todos os *filters* que fazem parte da cadeia podem interceptar e modificar os objetos de requisição e resposta.

Muitas das funcionalidades do Spring Security são baseadas nesses *filteres*. Tanto *Filter* quanto *FilterChain* são interfaces do pacote *javax.servlet*.

![[Capítulo 5 - Securing Spring Boot Applications-1.png]]

Assim como um *servlet* especial chamado *DispatcherServlet* lida com todas as requisições recebidas em uma aplicação **Spring Web**, um *filter* especial chamado **DelegatingFilterProxy** é usado para habilitar o **Spring Security**. Esse filter é registrado no *container de servlets* e começa a interceptar as requisições recebidas. Em uma aplicação **Spring Boot**, esse registro é feito pela **autoconfiguração do Spring Security** do Spring Boot. Vamos agora analisar a interface #Filter, como mostrado no *listing* a seguir. 

```java
public interface Filter {
	public default void init(FilterConfig filterConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;

	public default void destroy() {}
}
```

Uma implementação de *Filter* precisa implementar três métodos *init(), doFilter() e destroy(..)*, conforme mostrado na Figura 5.7.

---
**Entendendo o que está acontecendo**
O que o Spring Security faz?
- O Spring Security precisa interceptar as requisições antes do *DispatcherServlet*, para verificar se o usuário está autenticado, autorizado, etc.
- Para isso, ele usa um filtro especial chamado **DelegatingFilterProxy**.

**E o que é esse tal de DelegatingFilterProxy?**
- Ele é um filtro padrão do Java EE, mas com uma função especial: delegar a responsabilidade da segurança para um bean do Spring Security.
- Ou seja, ele é registrado no container de servlets, mas passa a bola pro Spring Security fazer o trabalho.

---
![[Capítulo 5 - Securing Spring Boot Applications-2.png]]
Figura 5.7: **Métodos do ciclo de vida do Filter.** O método *init()* contém um trecho de código que é invocado durante a inicialização do *filter*, e o método **destroy()** contém código que é invocado quando o *filter* está prestes a ser removido do container. O método **doFilter(..)** executa o tratamento da requisição (request handling) e retorna uma resposta (response) ao chamado *caller*.

Os três métodos do *filter* são descritos abaixo:
- **init()** - invocado pelo *Web container* para indicar que o *filter* está sendo colocado em serviço;
- **doFilter()** - método principal onde ocorre a ação efetiva do *FILTER*. Ele tem acesso aos objetos:
	- request
	- response
	- FilterChain (cadeia de filtros)

O FilterChain permite que o *filter* atual invoque o próximo *filter* na cadeia após terminar seu processamento.

- **destroy()** - chamado quando o *container* remove o *filter* de serviço.

O **FilterChain** é outro componente fornecido pelo *servlet container* que oferece uma visão da cadeia de invocação de uma requisição filtrada. A Figura 5.8 mostra um exemplo de cadeia de filtros *filters chain*.

Os *filters* utilizam o **FilterChain** para:
- Invocar o próximo *filter* na cadeia **OU**
- Invocar o recurso real (ex: o *servlet*), caso seja o último *filter* da cadeia

Um **FilterChain** possui apenas um método chamado **doFilter()**

Se revisarmos o Listing 5.3, observaremos que o método **doFilter()** da interface **Filter** tem acesso a:
1. O **FilterChain**
2. As instâncias **ServletRequest** e **ServletResponse**

Dessa forma, um **Filter** pode:
1. Executar sua tarefa designada;
2. Acessar o **FilterChain** para invocar o próximo *filter* na cadeia

![[Capítulo 5 - Securing Spring Boot Applications-3.png]]

```java
public interface FilterChain {
	public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException;
}
```
O Spring Security faz uso intensivo de *filters* para implementar diversos recursos de segurança. O núcleo fundamental do Spring Security é baseado nesses *filters*. Por exemplo:
- Para autenticação baseada em **username/password**, o Spring Security delega a requisição a um *filter* chamado **UsernamePasswordAuthenticationFilter**, responsável por autenticar o usuário com as credenciais fornecidas. 
- Para autenticação **HTTP Basic**, o Spring Security utiliza o **BasicAuthenticationFilter**

Agora, vamos discutir duas implementações principais de *filters* no Spring Security:
- **DelegatingFilterProxy**
- **FilterChainProxy**

Estes atuam como pronto de entrada para requisições HTTP na infraestrutura do Spring Security. Adicionalmente, podemos explorar a interface **SecurityFilterChain**.

### 5.2.3 Spring Security architecture
Na seção anterior, fornecemos uma visão geral de alto nível de **Filter** e **FilterChain** e discutimos como o Spring Security aproveita as funcionalidades fornecidas por esses componentes. Nesta seção, vamos discutir o **DelegatingFilterProxy**, o filtro **FilterChainProxy** e a classe **SecurityFilterChain**.

Um **filter** é um componente muito útil na especificação Servlet. O Spring Security o utiliza para implementar várias de suas funcionalidades centrais e estratégias de autenticação.

Apesar de útil, uma instância de **Filter** é um componente do container servlet e é gerenciado por esse container. O container é responsável por instanciar, inicializar e destruir o filtro. A especificação Servlet não exige nenhum tipo de integração com o Spring para lidar com um **Filter**.

O Spring Security fornece um filtro chamado **DelegatingFilterProxy** para preencher essa lacuna. Configuramos esse filtro com o container servlet, portanto seu ciclo de vida é gerenciado pelo container servlet. Em seguida, definimos uma implementação separada do **Filter** e a tornamos um bean gerenciado pelo Spring. Esse bean gerenciado pelo Spring é configurado.

A classe **FilterChainProxy** é a outra implementação de filtro para a qual o **DelegatingFilterProxy** delega as requisições HTTP. Ela contém uma ou mais **SecurityFilterChains** que processam a requisição HTTP. A figura 5.9 mostra uma visão geral de alto nível desses componentes.

![[Capítulo 5 - Securing Spring Boot Applications-4.png]]
**Visão Geral do Fluxo**
1. **Client (Cliente)** - faz uma requisição (por exemplo, acessar um */login* ou */api/users*).
2. A requisição **entra na cadeia de filtros padrão do servidor Java (*FilterChain*)** - que é um conjunto de filtros do próprio servlet container (como Tomcat, Jetty).
3. Um dos filtros dessa cadeia é o **DelegatingFilterProxy**.

**O que é o DelegatingFilterProxy**
Ele atua como um filtro fake, não implementa lógica própria, mas redireciona a requisição para um bean do Spring chamado #FilterChainProxy. Estando registrado no **web.xml** (em aplicações tradicionais) ou via Java config (em apps Spring Boot).

**O que o FilterChainProxy faz?**
Ele é o responsável de rodar todos os filtros de segurança do Spring, que estão dentro da *SecurityFilterChain*. Ele verifica qual conjunto de filtros deve ser aplicado com base na URL da requisição, e executa.

A interface *SecurityFilterChain* possui dois métodos: matches(..) e getFilters(..). O primeiro método permite que o Spring Security avalie se a *SecurityFilterChain* atual corresponde à requisição recebida. O Spring Security fornece a interface **RequestMatcher** e oferece várias implementações para realizar essa correspondência. Por exemplo, para corresponder a qualquer requisição, ele fornece o AnyRequestMatcher que corresponde a todos as requisições HTTP. O Spring Security também fornece um matcher no estilo ant com o AntPathRequestMatcher que corresponde aos caminhos de URL.

Se houver correspondência, o método getFilters(..) retorna a lista de filtros que precisam ser aplicados à requisição recebida. Se você continuar com as configurações padrão do Spring Security, então ele configura uma SecurityFilterChain padrão chamada DefaultSecurityFilterChain e configura uma lista de filtros necessários. Ele também garante que todas as requisições HTTP passem por essa cadeia de filtros.

Com base no design da aplicação e em outros requisitos de segurança, você pode optar por sobrescrever as configurações de segurança padrão e configurar uma ou mais SecurityFilterChains em uma aplicação. Por exemplo, você pode configurar uma SecurityFilterChain para um conjunto de URLs da aplicação (ex: /courses) que tem acesso a um módulo da aplicação. Similarmente, você pode configurar outra SecurityFilterChain para outro conjunto de URLs (ex: /users). Como a SecurityFilterChain consiste em uma lista de filtros que fornecem segurança, essa abordagem oferece maior flexibilidade na sua implementação de segurança. Por exemplo, você pode optar por implementar autenticação baseada em formulário para o controlador de usuários da aplicação, enquanto para o controlador de cursos, você pode usar autenticação HTTP básica."

### 5.2.4 Authenticating a user
Antes de discutirmos os passos de autenticação em detalhes, vamos primeiro abordas algumas classes e conceitos notáveis que desempenham um papel importante na autenticação:
- **SecurityContextHolder**: essa classe associa a instância *SecurityContext* ao thread de execução atual. Um **SecurityContext** contém informações sobre um principal autenticado, como nome de usuário, autoridades do usuário e outros detalhes de identificação.
- **SecurityContextPersistenceFilter** - esse filtro gerencia a instância do SecurityContext. Ele tenta recuperar o **SecurityContext** de um **SecurityContextRepository**.
- Em uma aplicação web, a implementação **HttpSessionSecurityContextRepository** tenta carregar o **SecurityContext** a partir da **HttpSession**.
- No início, como não estamos autenticados, um **SecurityContext** vazio é adicionado ao **SecurityContextHolder**.


A imagem abaixo mostra como o **Spring Security** armazena os dados de autenticação do usuário logado. Cada caixinha representa uma *camada* onde essas informações são guardadas.
![[Capítulo 5 - Securing Spring Boot Applications-5.png]]

1. SecurityContextHolder: é o topo da hierarquia. Um objeto **estático** que guarda o **SecurityContext** atual. Ele mantém essas informações disponíveis **em qualquer parte do código**, enquanto durar a requisição (ou sessão, dependendo da estratégia).

2. **SecurityContext**: Ele armazena a autenticação atual (caso o usuário esteja autenticado).
```java
Authentication auth = context.getAuthentication();
```

3. **Authentication**: esse objeto representa os dados de autenticação do usuário logado.

Ele possuí três partes principais:
**Principal**: usuário autenticado: *UserDetails*, *username*, etc.
**Credentials**: as credenciais usadas (geralmente a senha, mas é apagada depois): *password, token*.
**Authorities**: são as permissões/perfis do usuário: *ROLE_ADMIN*, *ROLE_USER*, etc.

- **AuthenticationFilters**: esses filtros são usados para autenticar um **principal**, e o Spring Security fornece vários filtros de autenticação. Por exemplo: **BasicAuthenticationFilter** executa a autenticação HTTP Basic. O **DigestAuthenticationFilter** realiza a autenticação **Digest**.

- **ExceptionTranslationFilter** - desempenha um papel fundamental no processo de autenticação. Com base em se o usuário já está autenticado ou se possui o acesso necessário a um recurso, há dois tipos de exceção:
	- AuthenticationException
	- AcessDaniedException

O *ExceptionTranslationFilter* lida com ambos os tipos de exceção:

**SecurityAutoConfiguration**
O **SecurityAutoConfiguration** está no centro da autoconfiguração do Spring Security. Ele utiliza outras três classes:
- **SpringBootWebSecurityConfiguration**
- **WebSecurityEnablerConfiguration**
- **SecurityDataConfiguration**
para realizar a autoconfiguração. A listagem a seguir mostra esta classe.
```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(DefaultAuthenticationEventPublisher.class)
@EnableConfigurationProperties(SecurityProperties.class)
@Import({SpringBootWebSecurityConfiguration.class, WebSecurityEnablerConfiguration.class,SecurityDataConfiguration.class})

public class SecurityAutoConfiguration {
	@Bean
@ConditionalOnMissingBean(AuthenticationEventPublisher.class)
}
```
Ela é uma **auto-configuração** do Spring Boot que é ativada automaticamente quando a dependência **spring-boot-starter-security** está presente no classpath. Ela registra beans importantes relacionados à segurança e importa outras configurações de segurança padrão.

**Destrinchando as configurações**:
- **@EnableConfigurationProperties({SecurityProperties.class})**: Habilita o suporte a propriedades definidas em *application.properties* ou *application.yml*, mapeando-as para a classe *SecurityProperties.class*.
- Exemplo, podemos configurar coisas como *spring.security.user.name* e *spring.security.user.password*.

```java
@Import({
	SpringBootWebSecurityConfiguration.class,
	WebSecurityEnablerConfiguration.class,
	SecurityDataConfiguration.class,
	ErrorPageSecurityFilterConfiguration.class
})
```
A configuração acima, importa várias outras classes de configuração de segurança. Cada uma tem uma função específica:
- *SpringBootWebSecurityConfiguration* - configura a segurança padrão da aplicação web;
- *WebSecurityEnablerConfiguration* - Ativa o filtro de segurança (Spring Security Filter Chain)
- *SecurityDataConfiguration* - Integra segurança com dados, como configuração de *UserDetailsService*
- *ErrorPageSecurityFilterConfiguration* - Lida com segurança em páginas de erro (ex: redirecionamento para login).

**Método**
```java
@Bean
@ConditionalOnMissingBean({AuthenticationEventPublisher.class})
public DefaultAuthenticationEventPublisher authenticationEventPublisher(ApplicationEventPublisher publisher) {
	return new DefaultAuthenticationEventPublisher(publisher);
}
```

O método acima define um **@Bean** do tipo **DefaultAuthenticationEventPublisher**, que é responsável por **publicar eventos de autenticação** (login bem-sucedido, falha de login, etc.).

🔐 Em resumo

| <font color="#ff0000">O que ela faz?</font>       | <font color="#ff0000">Como?</font> |
| ------------------------------------------------- | ---------------------------------- |
| Ativa a segurança web básica                      | Importa outras configurações       |
| Suporta eventos de autenticação                   | Registra um bean padrão para isso  |
| Lê configurações do `application.properties`      | Usa `SecurityProperties`           |
| Só é ativada quando Spring Security está presente | Usa `@ConditionalOnClass`          |

Vamos discutir brevemente essas classes. A classe **SpringBootWebSecurityConfiguration** é carregada se o security estiver disponível e não tivermos definido nossa própria configuração. O código a seguir mostra a classe *WebSecurityEnablerConfiguration*:
```java
@Configuration(  
    proxyBeanMethods = false  
)  
@ConditionalOnMissingBean(  
    name = {"springSecurityFilterChain"}  
)  
@ConditionalOnClass({EnableWebSecurity.class})  
@ConditionalOnWebApplication(  
    type = Type.SERVLET  
)  
@EnableWebSecurity  
class WebSecurityEnablerConfiguration {  
    WebSecurityEnablerConfiguration() {  
    }  
}
```

A classe **WebSecurityEnablerConfiguration** é uma classe de configuração que adiciona a anotação **@EnableWebSecurity** na configuração do Spring caso o Spring Security esteja presente no *classpath*. Isso garante que a anotação **@EnableWebSecurity** esteja presente na autoconfiguração padrão do Spring Security. No entanto, se adicionarmos explicitamente essa anotação ao nosso arquivo de configuração do Spring Security ou definirmos um bean com o nome **springSecurityFilterChain**, essa configuração recua (backs off) e não faz nada.

A anotação **@EnableWebSecurity** desempenha um papel fundamental na configuração do Spring Security. Ela fornece três configurações principais, além de outras funcionalidades:
1. **Configuração padrão:** 
	- *WebSecurityConfiguration*: é responsável por criar a instância **WebSecurity**, que gerencia a segurança baseada na web no Spring Security (como proteção de imagens, arquivos CSS e JS).
	- *HttpSecurityConfiguration*: cria o *bean* **HttpSecurity**, usado para configurar a segurança das requisições HTTP.

2. **Habilitação da autenticação global:**
	- *@EnableGlobalAuthentication*: fornece a configuração necessária para configurar a instância **AuthenticationManagerBuilder**, usada para definir o **AuthenticationManager**.

Se precisarmos personalizar a configuração padrão fornecida pelas classes mencionadas, podemos fazer facilmente definindo uma classe que estenda *WebSecurityConfigurerAdapter* ou implemente a interface *WebSecurityConfigurer*.

Nos próximos tópicos, perceberemos que utilizamos frequentemente a classe **WebSecurityConfigurerAdapter** para customizar as implementações de **WebSecurity** e **HttpSecurity**, além de empregar o **AuthenticationManagerBuilder** para configurar diferentes tipos de autenticação em uma aplicação Spring Boot.

**Integração com Spring Data**
A classe **SecurityDataConfiguration** fornece suporte à integração entre **Spring Data** e **Spring Security**. Ela define um **bean** chamado **SecurityEvaluationContextExtension**, que permite que o **Spring Security** seja exposto como expressões SpEL para criar consultas do Spring Data. 

Por exemplo, geralmente, para permitir que uma consulta no banco de dados seja realizada, é necessário que o usuário esteja logado. Só que, o Spring Data, por padrão, não sabe quem é o usuário logado. Nesse diferencial, entra o *SecurityEvaluationContextExtension*, ele é um **bean**, como mencionado, que expõe o Spring Security para dentro das expressões do Spring Data chamadas de *Spring Expression Language*.

Com isso, podemos fazer consultas mais poderosas assim:
```java
@Query("SELECT p FROM Pedido p WHERE p.usuario.username = ?#{authentication.name}")
List<Pedido> findPedidosDoUsuarioAutenticado();
```

Sem o *SecurityEvaluationContextExtension*, não conseguimos usar o *authentication.name* dentro das queries do Spring Data. Portanto, com o uso do bean, conseguimos acessar o contexto de segurança dentro das queries JPA. (RESUMIDAMENTE REVISAR EM OUTRO MOMENTO)...

**UserDetailsServiceAutoConfiguration**
A classe **UserDetailsServiceAutoConfiguration** configura automaticamente um **InMemoryUserDetailsManager** caso uma instância de **UserDetailsService** não tenha sido configurado na aplicação. 

A implementação padrão contém um usuário com:
- Nome:"user"
- senha gerada aleatoriamente (um UUID gerado aleatoriamente)

Podemos personalizar esses valores fornecendo nossa própria implementação da interface **UserDetailService**, e com isso a configuração padrão do Spring Security será ignorada (o termo técnico para isso é *back off*) e a nossa implementação personalizada entrará em ação.

## 5.3 Using Spring Security
Nesta seção, implementaremos várias técnicas que explicam o uso de diversos recursos do Spring Security em uma aplicação Web baseada em Spring Boot. Na próxima técnica, personalizaremos a página de login da aplicação **Course Tracker**.

### 5.3.1 Technique: Customizing the default Spring Security login page of a Spring Boot application
In this technique, we'll discuss how to customize the Spring Security provided default login page to an application-specific custom login page.

**Problem**
In the previous technique, we introduced Spring Security in the course tracker application and noticed that Spring Security has enabled user login in the application with a default **login** page. 

**Solution**
The **default** login page generated and provided by Spring is a basic one and just does the job. However, there are several reasons we'll be interested in customizing this page. For instance, we might want to keep the application login page in line with we application's Web page design. Podemos implementar estratégias adicionais de autenticação, como: um PIN de segurança adicional junto ao login regular, uma senha de uso único (OTTP - One-Time Password) ou um **CAPTCHA**.

Vamos adicionar uma nova página de login ao aplicativo, alinhada com o design do Course Tracker. 
