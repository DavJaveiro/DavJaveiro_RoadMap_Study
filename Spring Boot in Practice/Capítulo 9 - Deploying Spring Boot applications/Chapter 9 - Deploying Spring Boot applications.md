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

![image-20251152049341.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%209%20-%20Deploying%20Spring%20Boot%20applications/Chapter%209%20-%20Deploying%20Spring%20Boot%20applications/image-20251152049341.png)

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
