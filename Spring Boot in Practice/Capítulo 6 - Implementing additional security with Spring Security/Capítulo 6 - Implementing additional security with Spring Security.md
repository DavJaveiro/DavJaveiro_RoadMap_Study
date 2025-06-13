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
