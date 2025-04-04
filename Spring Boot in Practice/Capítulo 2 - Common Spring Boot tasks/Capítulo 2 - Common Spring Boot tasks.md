*This chapter covers*
- Gerenciando configurações em uma aplicação Spring Boot;
- Criando configurações personalizadas com @ConfigurationProperties;
- Explorando a interface *CommandLineRunner* para executar código de inicialização;
- Compreendendo o log padrão do Spring Boot e configurando o Log4j2;
- Validando dados de usuário em uma aplicação Spring Boot usando Bean Validation;

Até esse ponto, aprendemos um pouco sobre o que é o Spring Boot e seu propósito de melhorar a experiência de desenvolvimento de aplicações ao abstrair configurações de baixo nível.

Neste capítulo, nos aprofundaremos nesse entendimento explorando alguns conceitos fundamentais, como **gerenciamento de configuração da aplicação** e **criação de configurações personalizadas**. Além disso, usaremos o Spring Boot para executar tarefas comuns, que serão frequentemente utilizadas no desenvolvimento de aplicações Spring Boot.

## 2.1 Managing configurations
O gerenciamento de configurações é uma parte essencial de qualquer aplicação, e as aplicações **Spring Boot** não são exceção. Dependendo da forma como desenvolvemos e gerenciamos nossas aplicações, pode haver múltiplos ambientes (por exemplo, **dev**, **test**, staging e prod) dentro da nossa organização.

Por exemplo, podemos ter um ambiente para desenvolvimento, um para testes, um para homologação *staging* e outra para produção. Para todos esses ambientes, o código da aplicação geralmente permanece o mesmo, mas é necessário gerenciar diferentes configurações para cada um. Um exemplo comum é que as **configurações do banco de dados** ou as configurações de segurança variam entre os ambientes. Além disso, à medida que a aplicação cresce e novas funcionalidades são adicionadas, a gestão dessas configurações se torna mais complexa.

O Spring Boot oferece várias abordagens para externalizar configurações, sem a necessidade de alterar o código-fonte da aplicação. Entre essas abordagens estão:
- Arquivos de propriedades *.properties*;
- Arquivos YAML (*.yml*);
- Variáveis de ambiente;
- Argumento de linha de comando.

Nas próximas seções, exploraremos essas abordagens e aprenderemos a configurar corretamente uma aplicação Spring Boot. Em todas as subseções seguintes, os conceitos serão explicados em detalhes. Caso precise consultar o código, podemos baixar o projeto Spring Boot nos links do repositório Github fornecidos.

### 2.1.1 Using the SpringApplication class
Podemos usar a classe *SpringApplication* do Spring Boot para definir configurações na nossa aplicação. Essa classe fornece o método *setDefaultProperties()* que aceita uma instância de *java.util.Properties* ou *java.util.Map<String, Object>*, permitindo definir as configurações da aplicação. 

Podemos configurar todas as propriedades da aplicação dentro dessas estruturas. Essa abordagem é útil para **configurações estáticas**, ou seja, configurações que são definidas uma única vez e não precisam ser alteradas. Vamos explicar isso com um exemplo.

Em nosso arquivo *properties*, é possível importar arquivos adicionais de configuração (como arquivos *.properties* ou *.yml* que contenham outras configurações) usando a propriedade *spring.config.import* do Spring Boot.

Por exemplo, podemos adicionar a seguinte configuração no *application.properties:*
```properties
spring.config.import=classpath:additional-application.properties
```

Isso fará com que o Spring Boot carregue as configurações presentes no arquivo *additional-application.properties*.

**Atenção:** se esse arquivo não existir no classpath, o Spring Boot lançará uma exceção do tipo *ConfigDataLocationNotFoundException*. 

Com base na configuração da nossa aplicação, podemos optar por ignorar alguns arquivos de configuração e permitir que a aplicação continue o processo de inicialização normalmente. 

Para isso, pode configurar a propriedade:
spring.config.on-not-found=ignore

Isso garante que, se um arquivo de configuração especificado não for encontrado, o Spring Boot não lançara uma exceção *ConfigDataLocationNotFoundException* e seguirá com o bootstrap da aplicação.

### 2.1.2 Using @PropertySource
Em nossas classes de configuração do Spring, podemos especificar a anotação *@PropertySource* com a localização do arquivo de propriedades para carregar as configurações. O exemplo a seguir demonstra essa abordagem:
```java
@Configuration
@PropertySource("classpath:dbConfig.properties")
public class DbConfiguration {

	@Autowired
	private Enviroment env;
}
```

O trecho de código no Listing 2.2 define uma classe de configuração do Spring que contém a anotação *@PropertySource*, permitindo a leitura de propriedade do arquivo dbConfig.properties localizado no classpath da aplicação.
```properties
user=sa
password=p@sswOrd
```

Além disso, foi realizada a injeção da instância do **Spring Environment** usando *@Autowired*, permitindo o acesso às propriedades definidas no arquivo *dbConfig.properties*.

Agora, vamos acessar a classe DbConfiguration para recuperar as configurações definidas, conforme demonstrado no exemplo:

Ao iniciarmos a aplicação, seremos notificados através de um print na tela o usuário e a senha das propriedades no console da aplicação.

## 2.1.3 Config data file
O Spring Boot permite definir as propriedades de configuração da aplicação nos arquivos *application.properties*. Essa abordagem é a mais utilizada para configurar uma aplicação Spring Boot.

Por padrão, os projetos gerados pelo Spring Initializr já incluem um arquivo *application.properties* vazio.

As configurações definidas nesses arquivos são carregadas no **Spring Environment**, permitindo o acesso à instância do **Environment** dentro das classes da aplicação. Além disso, essas propriedades também podem ser utilizadas por meio da anotação *@Value*.

**Properties or YML file**
O Spring Boot permite que especifiquemos as configurações da aplicação tanto em arquivos properties quanto em arquivos YML. Em um arquivo properties, podemos definir as propriedades no formato de par chave-valor, como mostrado abaixo, onde a chave da propriedade é separada do valor pelo símbolo =:
```properties
server.port=8081
spring.datasource.username=sa
spring.datasource.password=password
```

As mesmas propriedades podem ser configuradas em um arquivo YML da seguinte forma:
```yml
server:
  port: 8081
spring:
  datasource:
    username: sa
    password: password
```
A escolha entre usar arquivos properties ou YML é uma preferência do desenvolvedor. O Spring Boot funciona de forma similar com ambos os tipos de arquivo (com algumas exceções). Algumas pessoas preferem usar YML devido à maior clareza e à capacidade de representar dados hierárquicos de forma mais natural. Além disso, é menos repetitivo e tem capacidades aprimoradas para suportar estruturas de dados como listas, maps e outras.

No entanto, se você optar por usar arquivos YML na sua aplicação, deve ter cuidado com a sintaxe. É relativamente fácil esquecer um espaço extra ou definir uma indentação incorreta no arquivo YML. Adicionalmente, é muito mais fácil encontrar propriedades específicas pelo nome completo quando se usa o formato .properties. Com YML, você sempre precisa encontrar a propriedade desejada manualmente.

Se precisarmos alterar o nome do arquivo de *application.properties* para outros nomes personalizados, podemos fazer isso facilmente. É possível customizar o nome do arquivo *application.properties* usando a propriedade *spring.config.name*.

Em nossa aplicação Spring Boot, vamos criar um arquivo sbip.yml na pasta resources e definir a configuração *server.port* com o valor 8081.

Podemos construir a aplicação usando o comando *mvn package* a partir do local onde está o nosso arquivo *pom.xml*. No pom.xml, especificamos o tipo de empacotamento como JAR. 

Após construir a aplicação com sucesso, execute o JAR executável usando o comando:
java -jar < nomeDoJar>

Seremos notificado que a aplicação iniciou na porta HTTP padrão 8080. Podemos parar a aplicação com o comando Ctrl-C e reiniciar com o comando abaixo:

Por padrão, o Spring Boot lê o arquivo *application.properties* ou *application.yml* dos seguintes locais:
1. A raiz do classpath;
2. O pacote */config* dentro do classpath
3. O diretório atual;
4. O subdiretório */config* dentro do diretório atual;
5. Diretórios filhos imediatos do subdiretório */config*.

Nota sobre as propriedades *spring.config.name* e *spring.config.location*
O Spring Boot carrega as propriedades *spring.config.name* e **spring.config.location** nas fases iniciais da inicialização da aplicação, antes mesmo dos arquivos **properties ou .yml**. Por isso, você **não pode** definir essas configurações dentro dos arquivos `application.properties` ou `application.yml`.
Para configurar essas propriedades, você pode usar:

- O método `SpringApplication.setDefaultProperties()`
    
- Variáveis de ambiente do sistema operacional (**OS environment variables**)
    
- Argumentos de linha de comando (**command-line arguments**), na hora de rodar a aplicação
    
Nos exemplos acima, utilizamos as opções de **argumentos de linha de comando**.

**Argumentos de Linha de Comando**
O **Spring Boot** permite que especifiquemos configurações diretamente como argumentos de linha de comando.

Isso significa que, ao criar um arquivo #JAR da aplicação, podemos passar essa propriedade como argumentos na hora de executar o JAR.

Por exemplo, nesta seção, as propriedades *spring.config.name* e *spring.config.location* foram especificadas diretamente na linha de comando ao executar a aplicação:
```cmd
java -jar minha-aplicação.jar --spring.config.name=meu-arquivo --spring.config.location=file:C:/config/
```

Este comando instrui o Spring Boot a:
- Procurar um arquivo de configuração chamado *meu-arquivo.properties* ou *meu-arquivo.yml*;
- Buscar esse arquivo no diretório C:/config/

Isso é útil quando queremos definir configurações sem alterar o código-fonte da aplicação.

O Spring Boot também permite que especifiquemos arquivos properties para um profile específico.

Os profiles do Spring permitem segregar partes da configuração da aplicação e torná-las disponíveis apenas em um determinado ambiente (por exemplo, um profile para o ambiente de **teste** ou um profile para o ambiente de produção).

Portanto, podemos definir arquivos de configuração adicionais dedicados a um profile, além do arquivo *application.properties* ou *.yml* padrão.

Os arquivos de propriedades específicos de um *profile* seguem o formato:
```
application-{profile}.properties
application-{profile}.yml
```

Por exemplo, se tivermos dois profiles -dev e test - podemos manter dois arquivos properties diferentes com os nomes:
- *application-dev.properties*;
- *application-test.properties*;

Portanto, dependendo do profile ativo, a porta da aplicação iniciará em Dev ou Test.
Podemos ativar um profile usando a propriedade do Spring Boot:
*spring.profile.active=dev*


### 2.1.4 OS environment variable

Podemos especificar as configurações como uma variável de ambiente e utilizar o nome dessa variável de ambiente no arquivo de configuração (config data file).

No arquivo *application.properties*, foi declarada a seguinte propriedade personalizada chamada **app.timeout**, conforme mostrado no trecho a seguir:
```properties
app.timeout=${TIMEOUT}
```

A variável de ambiente APP_TIMEOUT está configurada com o valor 30. No Windows, podemos definir uma variável de ambiente usando o comando *set < VAR>= < VALOR>* no prompt de comando...


## 2.2 Creating custom properties with *@ConfigurationProperties*
O Sring Boot oferece uma grande variedade de propriedades nativas para configurar diversos recursos da aplicação. O exemplo mais simples é a propriedade *server.port*, que utilizamos na seção anterior para definir a porta HTTP na qual a aplicação Spring Boot deve ser executada. 