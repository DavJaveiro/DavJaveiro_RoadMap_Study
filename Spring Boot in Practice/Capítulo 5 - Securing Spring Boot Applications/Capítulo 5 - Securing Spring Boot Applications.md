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
 - Se a aplicação não possuir uma página de login, o **Spring Security** gera uma página de login padrão para autenticação e permite que o usuário faça logout da aplicação;
 - O Spring Security cria um usuário padrão chamado *user* e gera uma senha padrão (impressa no log do console) para login baseado em formulário. O Spring Security gera automaticamente uma página HTML de login (formulário) quando acessamos a URL protegida. 
 - São fornecidos diversos codificadores de senha para criptografar senhas em texto simples e armazená-las de forma segura no banco de dados.
 - O Spring Security previne ataques de **fixação de sessão**, alterando o ID da sessão após a autenticação bem-sucedida do usuário.
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

