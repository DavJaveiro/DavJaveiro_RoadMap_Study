*This chapter covers*
- **Configuring advanced security configurations, including securing password with Spring Cloud Vault, Remember Me, and Google reCAPTCHA**
- **Enabling multi-factor authentication, including email verification and two-factor authentication with Google Authentication**
- **Implementing login with OAuth2 in a Spring Boot application**
- **Securing Spring Boot Actuator endpoints with Spring Security**

No capítulo 5, apresentamos o Spring Security e fornecemos uma introdução a vários conceitos relacionados. Além disso, exploramos diversas técnicas para utilizar o Spring Security em uma aplicação Spring Boot. Neste capítulo, utilizaremos os conceitos fundamentais do capítulo anterior e implementaremos diversos recursos avançados de segurança em nossa aplicação Spring Boot usando o Spring Security. Algum desses recursos incluem: habilitação de HTTPS; armazenamento de senhas no **HashiCorp Vault**; e implementação de **Remember Me**, **reCAPTCHA**, verificação de e-mail, **autenticação em dois fatores (2FA)**, entre outros.

Podemos utilizar o Spring Security para implementar diversos recursos avançados de segurança e uma aplicação Spring Boot. Alguns desses recursos são amplamente utilizados em aplicações em produção, e implementá-los em nossa aplicação pode, sem dúvida, aumentar a segurança. Vamos resumir estes recursos:
- **Habilitação do HTTPS:** A interação entre cliente e servidor através do protocolo HTTP representa um risco sério de segurança. O protocolo HTTP transfere os dados em texto puro. Assim, usuários mal-intencionados podem interceptar o tráfego de rede e acessar os dados da aplicação. <span style="background:#b1ffff">O protocolo HTTPS criptografa a interação</span> entre cliente e servidor e protege os dados da aplicação. 
- **Gerenciamento de segredos (Secret Management)**: gerenciar segredos da aplicação (por exemplo, senhas, **chaves de API**, etc.) é uma preocupação fundamental em qualquer aplicação. Em uma aplicação Spring Boot, é comum armazenar segredos no arquivo *application.properties* ou *application.yml*; no entanto, isso contradiz o propósito do uso seguro desses segredos. Neste capítulo, demonstraremos como utilizar o **Spring Cloud Vault** para gerenciar os segredos da aplicação.

- **Registro de usuários (User registration)** - A maioria das aplicações web lidam com usuário, por isso gerenciar usuário de forma eficaz é uma tarefa essencial. Neste capítulo, aprenderemos a implementar um módulos de registro de usuários na aplicação que desenvolvemos anteriormente, permitindo que novos usuário se cadastrem com segurança, armazenando suas informações de forma adequada e preparando a base para autenticação e autorização futuras.

- **Verificação de e-mail**: durante o processo de registro de usuário em uma aplicação, é fundamental que eles forneçam um endereço de e-mail válido. Neste capítulo, aprenderemos a implementar a verificação de e-mail no fluxo de registro de usuários da aplicação *Course Tracker*, garantindo que apenas usuários com e-mails válidos possam ativar suas contas e acessar o sistema.

- **Bloqueio de conta de usuário (Locking user account)**: é uma prática comum bloquear contas de usuário após várias tentativas de login mal-sucedidas. Esse recurso ajuda a proteger as contas contra **ataque de força bruta**, realizados por usuários mal-intencionados ou bots da internet, aumentando significativamente a segurança do sistema.

- **Remember Me**: lembrar usuário em dispositivos confiáveis pode economizar tempo e melhorar a experiência de uso. O **Spring Security** oferece suporte nativo para habilitar o recurso **remember me** e uma aplicação Spring, permitindo que os usuários permaneçam autenticados mesmo após fechar o navegador ou reiniciar a sessão, desde que estejam utilizando um dispositivo confiável.

- **reCAPTCHA:** Bots da internet podem causar sérios danos a uma aplicação ao sobrecarregá-la com criação de usuários falsos, consumindo recursos computacionais e prejudicando o serviço prestado aos usuários reais. Para evitar esse tipo de abuso, é possível habilitar mecanismos de verificação como o **CAPTCHA**. Neste capítulo, implementaremos o Google reCAPTCHA, adicionando uma camada extra de proteção contra acessos automatizados. 

- **Two-factor authentication:** a autenticação em dois fatores adiciona uma camada extra de segurança à aplicação, exigindo que o usuário forneça uma autenticação adicional além da senha. Vamos implementá-lo solicitando que os usuários informem uma senha de uso único (OTP) gerada pelo aplicativo **Google Authentication**, fortalecendo significativamente o processo de login.

- **Loggin in with Google:** A maioria dos usuários atualmente já possui contas em serviços como Google, Facebook, GitHub e outros. Permitir que eles usem essas contas existentes para acessar uma aplicação, oferece uma conveniência extra, pois elimina a necessidade de passar por um processo demorado de registro e ativação de conta. 

## 6.1 Enabling HTTPS in a Spring Boot application
Em aplicações modernas, é prática comum atender os usuários por meio de protocolos HTTPS em vez do HTTP. O HTTPS é o HTTP com criptografia TLS (Transport Layer Security). Com o HTTPS, as requisições e respostas HTTP são criptografadas, tornando a comunicação muito mais segura. Habilitar o HTTPS em uma aplicação Spring Boot é relativamente simples. 

**SOLUTION**
Habilitar o HTTPS em uma aplicação Spring Boot é um processo de duas etapas. Primeiro, precisamos obter um **certificado TLS**; depois, devemos configurar esse certificado em nossa aplicação. Um certificado TLS contém informações como as **chaves pública e privada** do proprietário do certificado. Esses dados têm dois propósitos principais: **criptografar os dados** e **garantir a identidade** do proprietário do certificado.

**Obtenção do certificado:** podemos obter o certificado por meio de uma **autoridade certificadora (CA)** confiável, como **Verisign, Entrust ou Let's Encrypt**; ou gerar um certificado autoassinado utilizando ferramentas como *keytool* ou *openssl*. Para aplicações em produção, recomenda-se sempre usar um certificado emitido por uma CA confiável.

Para fins de demonstração, neste caso geraremos um certificado autoassinado utilizando a ferramenta *keytool* do JDK. Podemos consultar o wiki do GitHub para seguir os passos de geração do certificado autoassinado.

#Keytool - é um utilitário de linha de comando que já vem incluído com o JDK (Java Development Kit), portanto, não precisamos instalar mais nada.

``` cmd
keytool -genkeypair -alias sbip -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore sbip.p12 -validity 3650 -storepass p@ssw0rd
```
**Entendendo Cada parte do Comando**
 - Keytool - nome do programa que estamos executando
 - -genkeypair - a ação que queremos realizar, que é gerar um par de chaves (uma chave pública e uma privada)
 - alias sbip - um "apelido" ou nome único para identificar este certificado dentro do keystore. No tutorial, foi utilizado sbip.
 - -keyalg RSa: o algoritmo criptográfico a ser usado para gerar as chaves. #RSA é o mais comum e amplamente suportado.
 - -keysize 2048: o tamanho da chave em bits. 2048 é um valor seguro e padrão para hoje em dia.
 - -storetype PKCS12: o formato do arquivo que armazenará as chaves. .p12 é o formato moderno e recomendado pelo Spring Boot.
 - -validty 3650: por quantos dias o certificado será válido. 3650 dias equivalem a 10 anos.
 - -storepass p@ssw0rd: a senha para proteger o nosso arquivo keystore. 

Com relação a série de perguntas, quando o programa keytool perguntar What is your first and last name? O ideal para um certificado de desenvolvimento é responder *localhost*. Isso garante que o navegador não reclamará do nome do host quando acessarmos *https://localhost:8443* durante os testes.

Ao final do processo, um arquivo chamado **sbip.p12** será criado e estará pronto para uso. Este é o nosso arquivo keystore, contendo o certificado autoassinado pronto para ser usado em nossa aplicação Spring Boot para habilitar o HTTPS.

Depois de obter o certificado, podemos prosseguir com a configuração do HTTPS em nossa aplicação Spring Boot. Criamos o nosso arquivo sbip.p12 dentro do diretório src\main\resources\kesystore.

O próximo passo é configurar a aplicação Spring Boot para user o keystore fornecido e, em seguida, habilitar o HTTPS.

Agora, para habilitar o HTTPS em nossa aplicação Spring Boot, vamos abrir o arquivo *application.properties* ou *application.yml* e definir as propriedades da certificação HTTPS.:
```json
# HTTPS Certification
server.ssl.key-store-type=PKCS12
server.ssl.key-store=classpath:keystore/sbip.p12
server.ssl.key-store-password=p@ssw0rd
server.ssl.key-alias=sbip
server.port=8433
```

The next change we'll implement is enforcing HTTPS for every request. This can be done in the *SecurityConfiguration* class that extends the *WebSecurityConfigurerAdapter* class.

O trecho de código que adicionamos na classe *SecurityConfiguration* indica que todas as requisições precisam ser seguras (ou sejam feitas via HTTPS). 
```java
@Configuration  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override  
	protected void configure(HttpSecurity http) throws Exception {  
	    http.requiresChannel().anyRequest().requiresSecure()  
	            .and()  
	            .authorizeRequests()  
	            .antMatchers("/login").permitAll()  
	            .anyRequest().authenticated().and().formLogin().loginPage("/login");  
}
```

A mensagem do navegador informando que o site não é confiável/seguro aparece porque estamos utilizando um certificado TLS autoassinado, ou seja, um certificado que não foi emitido por uma autoridade certificadora (CA) confiável reconhecida pelo navegador (como Let's Encrypt, Verisign, etc)...

Now that we've implemented HTTPS, and the application blocks all HTTP requests, we need to redirect all traffic to HTTPS automatically. In the application.propertiies fie, we've already confirued the HTTPS configuration (through the server.port=8433 property).

Vamos configurar o conector HTTP do servidor Tomcat de forma programática, para que todas as requisições HTTP recebidas sejam automaticamente redirecionadas para HTTPS. 

**DISCUSSION**
Em qualquer aplicação com nível de produção, é sempre recomendado utilizar HTTPS em vez de HTTP. No protocolo HTTP, as requisições e respostas são transferidas em texto puro, o que torna a nossa aplicação vulnerável à exposição de informações sensíveis. Se os nossos dados forem transmitidos sem criptografia, usuários mal-intencionados poderiam interceptar essas informações facilmente.

<span style="background:#d4b106">O protocolo HTTPS criptografa as requisições e respostas, evitando a exposição de dados durante o tráfego</span>. Por isso, aplicações que usam HTTPS transmitem mais confiança aos usuários, além de proporcionarem segurança tanto para os usuários quanto para os responsáveis pela aplicação.

Em aplicações reais, é essencial utilizar certificados emitidos por uma autoridade certificadora confiável CA.

Por fim, é importante destacar que, em ambientes de produção ou setups corporativos, é comum que a gestão do HTTPS seja feita por **balanceadores de carga (load balancers)** que ficam à frente das aplicações Spring Boot. Neste caso, o próprio balanceador lida com o tráfego seguro, e não a aplicação diretamente. A técnica que acabamos de aprender é útil quando não há um load balancer, ou quando se deseja habilitar HTTPS diretamente na aplicação Spring Boot como último recurso ou em projetos internos da empresa.

Testando com **Wireshark**...
## 6.2 Securing secrets in Spring Cloud Vault
Gerenciar segredos de aplicação é um dos principais desafios para qualquer aplicação, e as aplicações Spring Boot não são uma exceção. Uma aplicação pode conter vários tipos de segredos, como senhas, chaves de API, certificados TLS e chaves de criptografias. Expor esses segredos a agentes mal-intencionados pode causar danos catastróficos a uma aplicação. Por exemplo, imagine as consequências se a senha do banco de dados de uma aplicação bancária for exposta a usuários maliciosos.

O Spring Boot permite gerenciar as propriedades da aplicação (incluindo secrets) por meio do arquivo *application.properties* para uma configuração de aplicação mais fluida. Embora essa abordagem seja amigável ao desenvolvedor, ela pode permitir que os secrets sejam colocados acidentalmente em texto simples e expostos externamente. É comum que desenvolvedores acidentalmente façam commit de segredos em repositórios públicos e comprometam a segurança geral da aplicação. Na técnica anterior, armazenamos a senha do keystore em nosso arquivo **application.properties**.

Nesta seção, iremos ver o Vault da HashiCorp, trata-se de uma ferramenta popular que permite gerenciar com segurança e eficiência os secrets de uma aplicação. 

O HashiCorp Vault oferece diversas configurações e opções para gerenciar e utilizar o cofre. Algumas dessas configurações incluem armazenamento persistente do cofre, integração com a nuvem, geração dinâmica de segredos e outras. 

## 6.2.1 Technique: Managing application secrets with HashiCorp Vault in a Spring Boot application

Antes de prosseguirmos com esta técnica, precisamos configurar o servidor Vault e ajustá-lo para armazenar seus segredos. Podemos consultar https://github.com/spring-boot-in-practice/repo/wiki/Installing-and-Configuring-HashiCorp-Vault, para realizar essa configuração. 

Em seguida, vamos incluir o Spring Cloud Config em nosso arquivo maven. 

Em seguida, vamos configurar o vault em nosso *application.properties*:
```json
spring.cloud.vault.token=s.YGgzy5qOtEf4d6Xo0i6qqQGL spring.cloud.vault.authentication=token
spring.cloud.vault.host=localhost
spring.cloud.vault.port=8200
spring.cloud.vault.scheme=http
spring.config.import=vault://secret/coursetracker   
spring.application.name=coursetracker server.ssl.key-store-password=${keystore}
```

1. Utilizamos **modo de autenticação baseado em token**. O vault oferece vários outros modos de autenticação.
2. Especificamos host, porta e scheme do vault. Estamos usando HTTP porque configuramos o vault para rodar com HTTP. Isso é apenas para simplificar o exemplo, mas em um ambiente de produção devemos sempre utilizar HTTPS.
3. Definimos configuração de segredos, usando *secret/course-tracker* no Vault para armazenar a senha do keystore. Também específicamos o nome da aplicação como coursetracker.
4. Substituímos a senha do keystore pelo vault key, configurado como um keystore dentro vault.

**Discussion**
Com esta técnica, exploramos o uso do **HashiCorp Vault** para armazenar segredos da aplicação e utilizá-los em uma aplicação **Spring Boot**. O HashiCorp Vault é um cofre poderoso e repleto de recursos, sendo flexível e permitindo que configuremos conforme as nossas necessidades.

A Figura 6.1 ilustra a interação entre o usuário, a aplicação Spring Boot e o Vault. Nesta abordagem, incluímos o token raiz inicial no nosso *application.properties*. O vault gera esse token ao ser inicializado com o comando *vault operator init*. No entanto, em um ambiente de produção, recomenda-se utilizar uma variável de ambiente ou outro método seguro para fornecer esse token à aplicação. 

Além disso, estamos utilizando HTTP para a comunicação com o Vault, o que pode comprometer a segurança dos segredos. Por isso, recomenda-se configurar HTTPS para proteger a comunicação em uma ambiente de produção.

## 6.3 Implementing user registration
Registrar e gerenciar usuário é uma das funcionalidades essenciais de uma aplicação web. Nesta seção, discutiremos como podemos criar novos usuário em nossa aplicação **Course Tracker**. Vamos implementar.

### 6.3.1 Técnica: Implementando o registro de usuário com Spring Security em uma aplicação Spring Boot
Nesta técnica, discutiremos a implementação do registro de usuários em uma aplicação Spring Boot.

**Problema** 
Precisamos implementar um módulo de registro de usuário em nossa aplicação **Course Tracker**. Os dados do novo usuário devem ser persistidos na aplicação, e o usuário deve conseguir fazer o login.

**Solução**
Antes de mergulharmos na implementação do registro de usuário em si, vamos apresentar um panorama das mudanças que faremos na aplicação existente Course Tracker:
- Definir uma página HTML de registro de usuário (**add-user.html**) para capturar os dados do novo usuário.
- Definir uma classe de entidade de domínio **ApplicationUser**, que representa o usuário na aplicação Course Tracker. Vale notar que a classe **UserDto** representa os dados capturados na página HTML e pode conter parâmetros adicionais que não são necessários na entidade **ApplicationUser** (por exemplo, o campo **ConfirmPassword** na classe **UserDto**).
- Criar as implementações de serviço e os repositórios do Spring Data correspondentes.

Para adicionar um novo usuário, vamos começar definindo uma página de registro de usuário. 
Essa página de registro de usuário é semelhante às páginas HTML que utilizamos anteriormente. Ela possui um formulário HTML que permite aos usuários inserirem informações básicas e se registrarem na aplicação.

Vamos adicionar uma classe Java do tipo POJO (Plain Old Java Object) que capturará essas informações. 

```java
package com.manning.sbip.ch06.dto;  
  
import lombok.AllArgsConstructor;  
import lombok.Data;  
import lombok.NoArgsConstructor;  
import lombok.ToString;  
  
import javax.validation.constraints.Email;  
import javax.validation.constraints.NotEmpty;  
  
  
@Data  
@ToString(exclude = "password")  
@NoArgsConstructor  
@AllArgsConstructor  
public class UserDto {  
  
    @NotEmpty(message ="Enter your firstname")  
    private String firstName;  
  
    @NotEmpty(message ="Enter your lastname")  
    private String lastName;  
  
    @NotEmpty(message ="Enter a username")  
    private String username;  
  
    @NotEmpty(message ="Enter an email")  
    @Email(message ="Email is not valid")  
    private String email;  
  
    @NotEmpty(message ="Enter a password")  
    private String password;  
  
    @NotEmpty(message ="Please, confirm your password")  
    private String confirmPassword;   
}
```

A classe **UserDto** é uma classe Java simples (POJO) que contém os mesmos campos presentes na página de registro, com anotações de validação do pacote *javax.validation.constraints*, usadas para realizar validações. 

```java
package com.manning.sbip.ch06.model;  
  
import lombok.Data;  
import lombok.NoArgsConstructor;  
  
import javax.persistence.*;  
  
@Data  
@Entity  
@Table(name = "CT_USERS")  
@NoArgsConstructor  
public class ApplicationUser {  
  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
  
    private String firstName;  
    private String lastName;  
    private String username;  
    private String email;  
    private String password;  
}
```
Essa classe é uma entidade JPA, e estamos utilizando claramente uma tabela personalizada chamada *CT_USERS* para armazenar os dados dos usuários da aplicação.

É uma prática comum adicionar a sigla do módulo da aplicação (por exemplo, CT para o sistema CourseTracker) ao nome da tabela. Isso ajuda a identificar a que módulo cada tabela pertence, especialmente em bancos de dados maiores.

Let's define the *UserRepository* interface that lets us manage the **ApplicationUser** details in the applicatiom:
```java
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername (String username);
}
```

O código acima define um método personalizado que nos permite encontrar o **ApplicationUser** com base no nome de usuário fornecido. No capítulo 3, discutimos em detalhes como o Spring Data utiliza esses métodos personalizados e recupera dados do banco de dados.

Vamos definir uma interface *UserService* que fornece as operações que podem ser realizadas para manter os usuários na aplicação, conforme mostrado na listagem abaixo:
```java
public interface UserService {
	ApplicationUser createUser(UserDto userDot);
	ApplicationUser findByUsername(String username);
}
```

No código acima, estamos definindo duas operações:
- O método **createUser(..)**, que permite criar um novo usuário.
- O método **findByUsername(..)**, que localiza o usuário a partir do nome de usuário fornecido. 

Agora, precisamos realizar a implementação desta interface:

```java
@Service  
public class DefaultUserService implements UserService {  
    @Autowired  
    private UserRepository userRepository;  
    @Autowired  
    private PasswordEncoder passwordEncoder;  
  
    public ApplicationUser createUser(UserDto userDto) {  
        ApplicationUser applicationUser = new ApplicationUser(); // instan  
        applicationUser.setFirstName(userDto.getFirstName());  
        applicationUser.setLastName(userDto.getLastName());  
        applicationUser.setEmail(userDto.getEmail());  
        applicationUser.setUsername(userDto.getUsername());  
        applicationUser.setPassword(passwordEncoder.encode(userDto.getPassword()));  
  
        return userRepository.save(applicationUser);  
    }  
    public ApplicationUser findByUsername(String username) {  
        return userRepository.findByUsername(username);  
    }}
```

No código acima, implementamos o método **createUser(..)**. Criamos uma instância de **ApplicationUser** e preenchemos o objeto usando os dados do objeto **userDto**. Em seguida, salvamos os detalhes do objeto da aplicação na tabela **CT_USERS** utilizando o **userRepository**. Utilizamos o codificador de senha para codificar a senha, de forma que ela fosse armazenada codificada na tabela do banco de dados.

Também fornecemos uma implementação do método **findByUsername(..)**, que localiza o **ApplicationUser** usando o nome de usuário fornecido. Veremos o uso desse método ao implementarmos o nosso **UserDetailsService** personalizado para carregar os dados na tabela CT_USERS.

A interface **UserDetailsService** fornece uma ponte entre o repositório de identidades personalizado e o gerenciamento de usuários do Spring Security. O próximo passo será fornecer uma implementação do **UserDetailsService**.

Let's now add a Spring controller that manages the user registration. The following listing shows this.
```java
@Controller  
public class RegistrationController {  
  
    @Autowired  
    private UserService userService;  
  
    @GetMapping("/adduser")  
    public String register(Model model) {  
        model.addAttribute("user", new UserDto());  
        return "adduser";  
    }  
    @PostMapping("/adduser")  
    public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {  
        if (bindingResult.hasErrors()) {  
            return "adduser";  
        }        
        userService.createUser(userDto);  
        return "redirect:adduser?sucess= " + userDto.getUsername();  
    }}
```

No código acima, nós adicionamos dois endpoints: o **adduser** HTTP GET endpoint, o qual irá retornar a página **add-user.html** e o **adduser** HTTP POST endpoint, que irá checar se o objeto UserDto está valido e se todos os detalhes necessários foram fornecidos. Se os detalhes estiverem inválidos, retornamos a página add-user.html com a lista de erros. Se estiver tudo ok, o usuário é criado na tabela CT_USERS.

Vamos agora lidar com a falha de login do usuário na classe **LoginController**. LoginController exibe a página de login para o usuário.
```java
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
}
```
<<<<<<< HEAD

Arquitetura MVC, separando responsabilidades em 
=======
Para erros de login, o endpoint */login-error* é invocado. Ele define a flag *loginError* como **true** e, com base nisso, a página de login exibe a mensagem de erro ao usuário. Podemos perceber que estamos utilizando a instância do **Model** do Spring MVC para **transportar o atributo** *loginError* para a página **login.html**.
Portanto, essa abordagem comum no **Spring MVC** serve para tratar falhas de login:
- Quando o login falha, o Spring redireciona para o endpoint *login-error*.
- Dentro desse método, o atributo *loginError* é adicionado ao **Model**, que funciona como uma caixa de atributos, enviando do controller para a view (login.html).
- A view então pode verificar esse atributo (${loginError}) e exibir, por exemplo, uma mensagem como: *Usuário ou senha incorretos.*
Isso permite uma **separação clara** entre a lógica de controle (Java) e a camada de apresentação (HTML/Thymeleaf).

The last change we'll perform is updating the **SecurityConfiguration** class:
- Adicionamos o endpoint *login-error* à lista de rotas acessíveis sem autenticação;
- Configuramos a URL de falha de login (*failureUrl*) apontando para o endpoint **login-error**, que redireciona o usuário ao login novamente em caso de falha. O **Spring Security** realiza esse redirecionamento internamente. 
- Definimos o **BCryptPaasswordEncoder** como codificador de senhas.

Essa configuração reflete um **padrão de segurança robusto** no ecossistema Spring, promovendo:
1. Separação clara entre acesso público e protegido: a configuração de #andMatchers define com clareza o que pode ser acessado anonimamente (como login e cadastro) e o que exige autenticação. Isso reforça o **princípio do menor privilégio** e permite regras de segurança específicas para cada rota.
2. Tratamento explícito de falhas de login: Ao usar *failureUrl("/login-error")*, o Spring redireciona automaticamente para o ponto de falha, o que permite à interface informar ao usuário que suas credenciais estão incorretas, mantendo a mesma página de login. Isso melhora a **UX** (experiência do usuário) sem comprometer a lógica de segurança.
3. Uso do BCrypt para hashing de senhas: o #BCryptPasswordEncoder é um padrão atual e recomendado para proteção de senhas, pois:
	- Introduz salt automático, o que dificulta ataques de rainbow table;
	- É adaptável ao tempo de processamento, permitindo aumento de segurança no futuro;

**Comparando com o Angular (front-end moderno)**
Se fosse utilizado com **Angular como front-end** e Spring como back-end via API REST:
- O tratamento de login seria **stateless** e não baseado em **formLogin**, mas sim com JWT (JSON Web Token). Portanto, a cada requisição HTTP, o cliente (Angular) envia todas as informações necessárias para se autenticar, geralmente via um token JWT. O servidor (Spring), não armazena sessões nem histórico do usuário entre as requisições, isso torna a aplicação escalável, pois cada requisição é independente. 

Fluxo simplificado:
1. O usuário faz login pelo **Angular**, enviando *username* e *password* para o endpoint */auth/login* (por exemplo);
2. O Spring valida as credenciais e gera um JWT assinado.
3. O servidor envia o JWT de volta para o cliente Angular
4. O Angular armazena o token (geralmente no **localStorage** ou **sessionStorage**).
5. Em cada nova requisição para APIs protegidas,  o Angular envia o JWT no cabeçalho Authorization: ``Authorization: Bearer <token>``
6. O Spring valida o token, extrai os dados e autoriza o acesso com base nas roles contidas no token.

- Com Angular, ao invés de usarmos o **failureUlr**, o back-end retornaria uma resposta **401 Unauthorized**, e o Angular mostraria mensagens personalizadas usando *Reactive Forms* ou *Toasts*.

- A codificação de senha com #BCrypt continuaria válida no back-end, mas o envio da senha do lado do Angular seria feito com HTTPS, e o login consumiria um endpoint */api/login*.

## 6.4 Implementing email verification at user registration
Na seção anterior, durante o registro de um usuário, coletamos o endereço de e-mail do usuário. Na página de registro, aplicamos uma **validação estrutural de e-mail**, que garante que o usuário forneça um endereço com formato válido. No entanto, ainda não validamos se o e-mail informado realmente existe ou se ele pertence ao usuário.

A validação do e-mail do usuário é uma ação importante realizada pela maioria das aplicações web e existem várias razões para isso:
- Estamos verificando se o usuário é quem ele realmente afirma ser, e não está se passando por outra pessoa;
- Evitamos que o registro seja feito por um bot da internet, garantindo que é um usuário legítimo;
- Um e-mail válido também é útil para informar o usuário sobre marketing, promoções e ofertas de produto.  

Vamos demonstrar como validar o e-mail do usuário enviando um **link de verificação para o e-mail fornecido**. 

Portanto, a validação de e-mail por meio de link de verificação é uma prática essencial e moderna, transcendendo a simples verificação de formato `@dominio.com` e parte para a validação de propriedade, um passo fundamental para:
- Evitar #spoofing (usuário fingindo ser outra pessoa);
- Reduz o risco de **ataques automatizados**, especialmente quando associada ao uso de **captcha** e **rate limiting**;
- Permite o uso futuro do e-mail para recuperação de senha, confirmação de ações sensíveis 2FA, comunicação transacional e promocional;

**Como funciona tecnicamente**
O processo típico de verificação de e-mail envolve:
1. O usuário se cadastra com um e-mail;
2. A aplicação gera um **token de verificação único**, com tempo de expiração
3. Ao clicar, o sistema valida o token e ativa a conta.

**Arquitetura frontend-backend separada**
Em uma arquitetura separada:
1. O Angular cuida da tela de cadastro e da resposta visual pós-verificação
2. O Spring Boot fornece endpoints RESTful:
	1. `/api/register` - para criação e envio do token
	2. `/api/verify-email?token=...` - ativa a conta

O Spring Security pode auxiliar bloqueando o login até a verificação ser completada.

Um usuário se registra na aplicação Course Tracker criando uma nova conta. A aplicação salva com sucesso os dados do usuário na tabela CT_USERS. No entanto, a conta do usuário é marcada como **desabilitada**, pois o e-mail ainda não foi verificado.

Como parte do processo de registro, a aplicação envia um e-mail para o endereço fornecido com um **link de verificação**, que permite ativar a conta.

Se o usuário tentar acessar a conta antes de ativá-la, ele será **redirecionado para uma página de erro**, que solicita a ativação da conta. Após a verificação ser concluída com sucesso, a conta é ativada no sistema e o usuário pode fazer login normalmente.

Neste exemplo, usamos o #Gmail como servidor de e-mail preferido, apenas para fins de demonstração. Podemos usar outros provedores de e-mail ou até mesmo um servidor de e-mail próprio. Caso opte por outro, certifique de fornecer as configurações adequadas do servidor SMTP no lugar das configurações do Gmail. 

A primeira mudança no código é adicionar a dependência **spring-boot-starter-mail** no arquivo *pom.xml* da aplicação. Essa dependência contém as bibliotecas necessárias que permitem o envio de e-mail para o endereço eletrônico do usuário.

Essa técnica implementa um **workflow de verificação por e-mail**, que é prática comum em sistemas de autenticação modernos por motivos de segurança.

Cada serviço de e-mail (Gmail, Outlook, Yahoo, etc.) possui seu próprio servidor SMTP e requer configurações específicas. No Spring Boot, podemos configurar isso facilmente no *application.properties*.

**Dica: deixar genérico por ambiente**
Se quisermos tornar isso mais flexível, podemos usar variáveis de ambiente ou *application-{profile}.properties*:
```json
spring.mail.host=${MAIL_HOST}
spring.mail.port=${MAIL_PORT}
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
```

Incluindo a dependency *spring-boot-starter-mail*:
```json
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

Vamos atualizar o arquivo **application.properties** para fornecer os detalhes do servidor de e-mail que será utilizado para o envio das mensagens. Nesta demonstração, usaremos o Gmail como servidor de e-mail.

Configurações:
```json
# Outras propriedades da aplicação

# Configurações do servidor SMTP do Gmail
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<Digite seu e-mail do Gmail>
spring.mail.password=<Digite a senha ou senha de aplicativo>

# Habilita autenticação SMTP e STARTTLS
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Define o protocolo como SMTP
spring.mail.protocol=smtp

# Desativa o teste automático de conexão
spring.mail.test-connection=false

```

**Entendendo o que significa cada propriedade**
- *spring.mail.host*: define o host do servidor de e-mail a ser usado para enviar e-mail.
- *spring.mail.port:* define a porta do servidor de e-mail a ser usada para enviar e-mails.
- *spring.mail.username:* define o nome de usuário usado para autenticar com o servidor de e-mail.
- *spring.mail.password*: define a senha usada para autenticar com o servidor de e-mail.

**Dicas de Segurança**
1. Não exponha credenciais no código, ou seja, nunca deixar *spring.mail.username* e *spring.mail.password* direto no *application.properties* ou *application.yml* versionado no Git. Devemos utilizar variáveis de ambiente ou *application-prod.yml* fora do controle de versão.
2. **Usar conexões seguras**
Certificar-se de usar SMTP seguro (TLS/SSL), com as propriedades:
```json
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.protocol=smtp
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

**Estrutura do Código**
3. Criar um serviço de envio de e-mails separado. Encapsulamento da lógica de envio de e-mail em uma classe de serviço (**EmailService**), em vez de colocar dentro de controllers ou outras classes:
```java
@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void enviarEmailSimples(String para, String assunto, String corpo) {
		SimpleMailMessage mensagem = new SimpleMailMessage();
		mensagem.setTo(para);
		mensagem.setSubject(assunto);
		mensagem.setText(corpo);
		mensagem.setFrom("segu@email.com");

		mailSender.send(mensagem);
	}
}
```

4. Devemos usar #MimeMessageHelper para e-mails HTML ou com anexos. Quando quisermos enviar e-mails mais ricos (HTML ou com anexos):
```java
MimeMessage message = mailSender.createMimeMessage();
MimeMessageHelper helper = new MimeMessageHelper(message, true);
helper.setTo("destino@example.com");
helper.setSubject("Assunto");
helper.setText("<b>Mensagem com HTML</b>", true);
helper.addAttachment("arquivo.pdf", new File("caminho/arquivo.pdf"));

```

Vamos realizar os testes com o #MailHog. 
- MailHog é um servidor SMTP local de testes. Ele recebe e-mails da nossa aplicação, mas nao envia de verdade, apenas captura para visualizarmos em um navegador. 
- instalação via Docker: `docker run -d -p 1025:1025 -p 8025:8025 mailhog/mailhog`
- Porta 1025 = SMTP local
- Porta 8025 = interface web para ver os e-mails.

