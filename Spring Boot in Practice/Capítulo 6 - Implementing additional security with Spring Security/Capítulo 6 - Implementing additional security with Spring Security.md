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
