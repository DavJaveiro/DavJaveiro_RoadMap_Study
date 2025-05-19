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
