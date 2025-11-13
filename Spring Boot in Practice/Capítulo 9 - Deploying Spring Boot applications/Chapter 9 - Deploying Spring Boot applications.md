*This chapters covers*
- Running Spring Boot applications as a JAR file or deploying as a WAR file;
- Deploying Spring Boot applications to Cloud Foundry and Heroku;
- Running Spring Boot applications as Docker containers;
- Developing Spring Boot applications for Kubernetes clusters and the Red Hat OpenShift platform

Once we are done with our application development and testing, we need to deploy the applications into our production server to serve the application users. Spring Boot applications can be deployed through an array of deployed strategies. Based on the application's scalability, availability, and resilience requirementes, we can decide on our application deployment strategy.
In this chapter, we'll introduce to various approaches to deploy the Spring Boot application. We can learn tradition deployment techniques, such as running the application as an executable JAR (Java Archive) or deploying it into an application server as a WAR (<span style="background:#affad1">Web Application Archive</span>). We'll then explore deploying into **Pivotal Cloud Foundry** and **Heroku**. Later, we'll also learn how to run Spring Boot applications as a Docker container and deploy them into a Kubernetes cluster. Finally, we'll show how to deploy the application into Red Hat OpenShift.

Spring Boot supports a wide range of deployment techniques. We can package our Spring Boot application as an executable JAR and run it without the need for any application server. Spring Boot provides built-in support for several embedded Web servers. Similarly, if we need to package our application as a WAR file and deploy it to an application server, Spring Boot has built-in suppor to prepare the WAR file. As we'll explore shortly, it is straightforward to package our Spring Boot application.

Deploying the applications through the JAR or WAR files approach has a prerequisite we need to build a package for our application. The Pivotal Cloud Foundry (PCF) offers an alternative approach with which we can use our source code directly to deploy the application, and PCF will perform the required steps. Similarly, if we don't have our on-premises infrastructure, we can leverage cloud provides, such as AWS, Azure, Google Cloud Platform, and Heroku to deploy your package application. 

<span style="background:#d4b106">Further, if we need to run our application as a container image, Spring Boot provides built-in support to generate a container image for our application. We can then use the image to run our application locally or deploy it to cloud environments.</span>

## 9.1 Running Spring Boot applications as executable JAR files
Previously, we've seen that we can package a Spring Boot application as an executable JAR file and execute it in <span style="background:#affad1">local machines or servers</span>. In this section, we'll explore this step in detail.

### 9.1.1 Technique: packaging and executing a Spring Boot application as an executable JAR file
In this technique, we'll demonstrate how to package and execute a Spring Boot application as an executable JAR file.

**Problem**
We have developed a Spring Boot application and need to execute it as an executable JAR file.

**Solution**
Once we are done with the application development, we need to execute it to see it in action. Spring Boot provides several options to deploy the application and run it.  In this technique, we'll explore Spring Boot's built-in approach <span style="background:#affad1">to package the application as an executable JAR file and run it</span>. This is one of the popular approaches to package and run a Spring Boot application.

To demonstrate how to package the application componentes and run the application as an executable JAR file, we'll use the Course Tracker Spring Boot application we've developed in the earlier chapters.

To ensure the application is package as an executable JAR file, we need to ensure the following two things:
1. The *packaging type* in the pom.xml file needs to be set as a JAR. This ensures the application componentes will be packaged as a JAR.
2. Configure the *spring-boot-maven-plugin* in the *plugins* section of the pom.xml file, as show in the following listing.

```xml
<plugin>
	<groupId>org.springframwork.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

The spring-boot-maven-plugin prepares the executable JAR file when the Maven package goal is executed. We'll discuss more on this in the discussion section.

Open a terminal window, and browse to the location of the pom.xml file. Next, execute the *mvn package* command to build and package the application componentes. This ensures the application in compiled, built, and package as a JAR file. 

After successfully packaging, we'll find there is a *target* directory created in the same location as the *pom.xml* file. This target directory contains an executable JAR file. By default, the name of the JAR file is *< artifactId-< version>.jar* In our example, the JAR file name is *course-tracker-app-jar.1.0.0.jar*. We can execute this JAR file using the java -jar < jarname> command from our terminal from the target directory. 

**Discussion**
Previously, we discussed that Spring Boot projects have a parent POM called *spring-boot-starter-parent*. This POM file includes the necessary configuration to define the repackage goal. Further, in the same target directory, we'll notice that there is another JAR file with naming format < artifactId>-< version>.jar.original

## 9.2 Deploying Spring Boot applications as WAR in the WildFly application server
In this moment, we need to package our application components into a WAR file and deploy them into a Web server or application servers.

Before containerization and Kubernates, deploying applications into a Web server or application servers were the facto standards. Application servers offer a lot of enterprise features that help developers and application architects to leverage those features and plan application deployment strategies. For instance, most application servers provide features, such as support for database connection, session replication, sticky sessions, clustering, and more. For application server-based deployments, it is a common scenario to deploy the same instance of the application into multiple servers and use a load balancer to balance the incoming requests among the application instances.

The figure above shows a high-level diagram with the use of application server clustering to deploy Spring Boot applications. This cluster deployment provides capabilities, such as load balancing and high availability. 

![image-20251152049341.png](image-20251152049341.png)

**Alguns recursos do Loadbalancer**
1. Aumento de disponibilidade: se uma instância cair, o Load Balancer para de enviar requisições para ela e continua usando as outras. 
2. **Escalabilidade:** se o sistema receber muitas requisições, podemos subir novas instâncias da aplicação e o Load Balancer vai incluí-las automaticamente na distribuição.
3. **Melhora o desempenho:** distribuir a carga evita que uma instância fique sobrecarregada enquanto outras estão quase sem uso.
4. **Pode suportar atualizações sem downtime:** podemos atualizar uma instância pro ver (rolling update), enquanto o Load Balancer direciona o tráfego para as outras.

Portanto, sem o Load Balancer, todos os usuários acessam **uma única instância**, risco de gargalo e queda. 

### 9.2.1 Technique: packaging and deploying a Spring Boot application as WAR in the WildFly application server
In this technique, we'll discuss how to package a Spring Boot application as a WAR file and deploy into WildFly application server.

**Problem**
We have developed a Spring Boot application and need to package it as a WAR file and deploy it in the WildFly application server.

**Solution**
In this section, we'll demonstrate how to package a Spring Boot application and deploy it in the WildFly server. 

To <span style="background:#affad1">package the components as WAR </span>files, we need to make two changes:
1. In the pom.xml file, the packaging type should be war, as shown in the following listing.
2. Define an instance of a *WebApplicationInitializer* to run the application from a #WAR deployment. The *WebApplicationInitializer* allows us to configure the #servletContext programmatically in servlet 3.0+ environment. If we create our Spring Boot application through Spring Initializr... then by default Spring Boot provides a class called *ServletInitializer*. This class extends the #SpringBootServletInitializer class, which is an instance of #WebApplicationInitializer implementation provide by Spring Boot to run a Spring Boot application in a WAR deployment. If our are not creating the Spring Boot application from Spring Initializr, we have to perform this step manually.

The following listing shows the #ServletInitializer class:
```java
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CourseTrackerSpringBootApplication.class);
	}
}
```

We added the *CourseTrackerSpringBootApplication* class in **SpringApplicationBuilder**. Later on, this SpringApplicationBuilder is used to build an instance of SpringApplication, which is run to start the Spring Boot application.

Next, let's exclude the *logback-starter* dependency form the *spring-boot-starte-web dependency* in the pom.xml, as shown in the following listing.

We excluded this dependency, as it conflicts with the *slf4j-jboos-logmanager-1.1.0.Final.jar* of the WildFly server. O wildfly já possui seu próprio gerenciador de logs. Se levarmos outra implementação de SLF4J dentro da nossa aplicação, (no WAR), o servidor vai ter duas versões competindo. 

Next, let's define the context root of the application to "/". 
O context root é o nome que aparece na URL para acessar a aplicação. 
http://localhost:8080/meuapp, meu app é o contexto root.

Se definirmos para "/"
http://localhost:8080/
A nossa aplicação fica na raiz, sem nome extra no caminho.

```xml
<jboss-web>  
    <context-root>/app</context-root>  
</jboss-web>
```

After successfully building, we'll notice that the application is packaged as a WAR file. We can deploy this WAR file on the WildFly server.

Before starting deployment, we need to ensure an instance of the WildFly application server is running. Open the browser window and access the http://localhost:9990 URL, and you'll notice the WildFly server  management console. Click on the Deployments menu and then the Upload Deployment button.

## 9.5 Running Spring Boot applications as Docker containers
In this section, we'll shift our attention to containers and use the most popular container implementation Docker to run the Course Tracker application as a containerized application. However, before we proceed to containerize the Cours Tracker application, let's understand what a container is and why **you should care** about it. 

A container image is a lightweight, standalone, executable software package that includes everything the application requires to run itself. These include application componentes, runtime, system tools, settings, and libraries. A container image turns into a container at its runtime, as shown in figure 9.6.

A container image can be used to create one or more containers.
![image-2025119156278.png](image-2025119156278.png)

The various componentes to run a container are shown in figure 9.7

One of the most importante reasons to use a container in the first place is due to its promise of reliable execution from one environment to another environment. It is a relatively common occurrence that in a typical infrastructure, applications may behave differently. For isntance, we often found that applications working perfectly in the Dev environment may have some issues while running in UAT. Containers remove this problem, as it is a standalone package that contains everything the application requires to run. Thus, if the same image is used to run the application in Dev or UAT, it is expected to run uniformly.

Docker is the most popular and dominant container technology platform and can be used to deal with container and container images. Docker is so popular that it is almost synonymous with containers and container technology. 

### 9.5.1 Technique: creating a container image and running a Spring Boot application as a container

**Problem**
You are running the Course Tracker application in your Unix server through the WildFly application server. However, you've heard a lot of good things about containers and want to run the application as a container.

**Solution**
To proceed with the next technique, we need to install and configure Docker. You can refer to Docker documentation...

In this section, we'll explore the following approaches to *Dockerize* the Course Tracker application:
1. Use #dockerfile to create the #container image and then run the image to create the container.
2. Use Spring Boot built-in containerization (requires Spring Boot version >=2.3). This use the **Paketo builpacks** to build the image.

In these approaches, we'll use H2 in-memory database with the application to keep the examples simple.

Let's begin with the first approach. We'll use a Dockerfile to create the Docker image. Before we define the Dockerfile, let's execute the *mvn clean install* commando to generate the JAR file of the Course Tracker applicaation. 

---
Pois o Docker file normalmente precisa do artefato final da nossa aplicação, o .jar para copiá-lo para dentro da imagem. 

*mvn clean install* faz duas coisas importantes:
1. **Compila o projeto  e executa os testes** para garantir que o código está funcionando.
2. **Empacota o resultado em um .jar** dentro de *target/*
No Dockerfile, geralmente temos uma linha como:
```bash
COPY target/meu-app.jar app.jar
```

Se não executaarmos *mvn clean isntall* antes, o arquivo *target/jar* simplesmente não existe, portanto, o docker build vai falhar porque não terá o artefato para copiar.

**Resumo direto:**
- **mvn clean install**, cria o .jar
- Dockerfile, copia o .jar para a imagem
- Sem o .jar não há o que rodar dentro do container

---

Let's now define the *Dockerfile* for the Course Tracker application. A *Dockerfile* is a text file that contains all the commands needed to assemble and create the image. This file is located under the root directory of the application.

FROM adoptopenjdk:11-jre-hotspot
ADD target/*.jar application.jar
ENTRYPOINT ["java", "-jar","application.jar"]
EXPOSE 8080

In listing 9.26, the Dockerfile contaains the following:
- FROM - we are using adoptopenjdk:11-jre-hotspot as the base image for our image. A base image is an image upon which your application Docker image is built. Essa imagem já vem com o Java 11 JRE instalado. Não precisamos instalar o java manualmente dentro do Docker.
Qual usar? E como atualizar no seu Dockerfile
Como você trabalha com Java, Spring Boot e contêineres, minha recomendação:
- Se você estiver confortável e seu projeto permitir, **migre para uma imagem baseada em Java 17** (ou superior, se já estiver compatível) — muitas bibliotecas (inclusive Spring Boot) já suportam Java 17 ou acima.
- Use uma imagem oficial e bem mantida, por exemplo `eclipse-temurin:17-jre` ou `openjdk:17-jdk-slim`.
- Em seu Dockerfile, substituir a linha base por algo como:
    `FROM eclipse-temurin:17-jre`
    ou
    `FROM openjdk:17-jdk-slim`

    dependendo de seus requisitos (runtime apenas ou JDK completo).
    
- Verifique se todas as dependências do seu projeto, bem como o Spring Boot que você está usando, são compatíveis com Java 17 ou a versão que você escolher.

- **ADD** - We then add the JARs from the target directory as application.jar in the image.
- **ENTRYPOINT** - This is the entry point where we run the image.
- **EXPOSE** - We expose HTTP port 8080 in the container.

Next, let's execute the command, as shown in listing 9.27 to create the image. You need to execute the command from the location where the *Dockerfile* is located.

`docker build --tag course-tracher:v1 .`

In listing 9.27, note the period (.) at the end of the command. This indicates that the docker files is available in the current directory. Besides, we tag the imagem with the name *courser-tracker:v1* to refer to the image, while creating a container from the image.

Once you execute the command, it will take a while to build the image. Once the image is successfully built, we can list the image using the command, a shown in the following listing.
`docker image ls`

We can run the image, and a Docker container will be created. The following listing shows the command to run the image.

`docker run -p 8080:8080 course-tracker:v1`

We've used the *docker run* command to run the container image. We've also used a port mapping of local machine HTTP port 8080 to the container's HTTP port 8080. The ensures the HTTP request to the port 8080 in the local machine is forwarded to the container's port 8080.

Once the command runs successfully, you'll notice the console log of the Course Tracker Application. Open a browser window, and access the application in the URL.

Let's now briefly discuss the container image structure we've created in listing 9.26. Your Docker container image consist of multiple layers. If you recall, we started with the base image. In our Dockerfile, we performed additional activities, such as adding the JAR file from the target location to the image. This has created an additional layer on top of the base image. 

In the Dockerfile, we've added the fat JAR inside the image. However, we could write a better Dockerfile for Spring Boot applications. Instead of adding the complete JAR, we could add the layers from the generated JAR file. Recall from section 9.1 that Spring Boot provides a means to layer the JAR file through the layers.xml file. 

In this technique, we've learned how to build a Docker image from a Spring Boot application and run the image as a Docker container. Containers provide excellent portability support, as the container images can be run anywhere reliably.

---
Review
O arquivo #Dockerfile é um arquivo de texto usado para definir as instruções de construção de uma imagem Docker. Ele descreve passo a passo **como o Docker deve montar o ambiente da aplicação**, incluindo o sistema operacional base, dependência, variáveis de ambiente, portas expostas, comandos e próprio aplicativo que será executado.

### Estrutura básica de um Dockerfile
```dockerfile
# Etapa 1: Escolher a imagem base (sistema + Java)
FROM eclipse-temurin:17-jdk

# Etapa 2: Definir o diretório de trabalho dentro do container
WORKDIR /app

# Etapa 3: Copiar o JAR da aplicação para dentro da imagem
COPY target/applicação.jar app.jar

# Etapa 4: definir o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

# Etapa 5: expor a porta (opcional)
EXPOSE 8080
```

**Exemplo de build (multi-stage build)**
Podemos realizar o processo de compilar e rodar a nossa aplicação dentro do Docker em duas etapas:
```dockerfile
# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final para rodar o app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/minha-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
```

A vantagem de realizar dessa forma é que a imagem final ficar menor, pois não leva o Maven nem os arquivos de build.

Todo #contianer possuí uma rede.

docker network ls
$ docker network ls
NETWORK ID     NAME                   DRIVER    SCOPE
d0f9854a8a4b   bridge                 bridge    local
af761ab69065   gestao_vagas_default   bridge    local
4b66b469b096   host                   host      local
dc45f11fb20c   none                   null      local

Se não especificarmos uma rede, o container será associado ao #bridge. Driver, é a rede padrão para qualquer container. Fornecerá uma interface que vai fazer a ponde com o docker0, do host. Neste caso, vamos conseguir realizar comunicação TCP por default. O ideal é que tenhamos as nossas redes com cada projeto.

- #none = isola o nosso container; podemos associar uma rede none para o container que não vai ter contato com o ambiente externo;
- #host: entregar todas as interfaces existentes; 

Para especificar o driver de criação da rede:
`docker network create --driver bridge second-network`

Nesta aula, foi abordado como associar uma rede a um container Docker. Foram apresentadas duas formas de fazer essa associação: utilizando o comando `docker network connect` para containers já em execução e definindo a rede no momento da criação do container com o parâmetro `--network`. Foi explicado como verificar a associação da rede ao container utilizando os comandos `docker network inspect` e `docker container inspect`. Também foi mencionado que um container pode estar associado a várias redes.


- docker run --rm -> isso garante que o container será apagado ao final do ciclo de uso do mesmo.

- docker run -p 8080:8080: referente a porta, logo, precisamos mapear uma porta que vai apontar para uma porta que esteja rodando o processo dentro do container;
