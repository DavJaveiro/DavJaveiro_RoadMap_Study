In the Preface, you read that DevOps consist of dozens of concepts. But it almost always start with just one question: "I wrote an app. Now what?"

Your and your team have spent months **putting together** (montando) an app. You picked a programming language, implemented the backend, designed and built a user interface (UI), and finally, it's time to expose the app to real users. How, exectly, do you do that?

There are so many questions to figure out here. Should you use AWS or Azure? (And what about Heroku or Vercel?) Do you need one server or multiple servers? (Or #servesless?) Do you need to use Docker? (Or Kubernets?) Do you need a VPC? (Or a VPN?) How do you get a domain name? (And what about a TLS certificate?) What's the riught way to set up your database? (And how do you back it up?) Why did that app crash? Why does nothing seem to be working? Why is this so hard?

Ok, easy now. Take a deep breath (respire fundo). If you're new to software delivery, you've worket as an app developer your whole career, or you're just starting out in operations, it can be overwhelming, and you can get stuck in analysis paralysis. This book is here to help. I will walk you through each of these questions, and many others you didn't think to ask, and help you figure out the answers, step-by-setp.

The first step will be to deploy the app on a server and get it running in the most basic way you can. In this chapter, you'll work through examples to deploy the same app on your own computer, on Render (a platform as a service), and on AWS (an infrastructure as service). After that, you'll see how to **envolve** your basic deployment as your company grows.

Without further ado, let's jump right in and start deploying some apps!

## Example: Deploy the Sample App locally
The first place you should be able to deploy any app is locally, on your own computer. This it typically how you'd build the app in the first place, writing and running your code locally depends on the technology. Throughout this book, you're going to be using a simple Node.js sample app.

Create a new folder on your computer, perhaps called something like *fundamentals-of-devops*, which you can use to store code for the examples you'll be running throughout the book. Tou can run the following commands in a terminal to create folder and go into it:

```bash
mkdir fundamentals-of-devops
cd fundamentals-of-devops
```
In that folder, create new subfolders for this chapter and the sample app:
```bash
mkdir -p ch1/sample-app
cd ch1/sample-app
```

The sample app we'll be using is a minimal "Hello World " Node.js app, written in JavaScript. You don't need to understand much JavaScript to make sense of the app. One of the nice things about getting started with Node.js is that's all the code for a simple web app fits in a single file that's about 10 lines long. Within the *sample-app* folder, create a file called *app.js*, with the contents shown in Example 1-1. 

*Example 1-1. A Node.js "Hello, World" sample app (ch1/sample-app/app.js)*
```js
const http = require('http');

const server = http.createServer((req, res) => {
	res.writeHead(200, {'Content-type': 'text/plain'});
	res.end('Hello, World!\n');
});

const port = process.env.PORT || 8080;
server.listen(port,() => {
	console.log(`Listening on port ${port}`);
});
```

This "Hello, World" app does the following:
1. Respond to all requests with a 200 status code and the next *Hello, World!*
2. Listen for requests on the port number specified via the **PORT** environment variable, or if PORT is not set, default to port 8080.

To run the app, we must first install Node.js (minimum version 21). We can then start the app with *node app.js*:
```bash
node app.js
```
Congrats, we're running the app locally! That's a great start, but if we want to expose our app to users, we'll need to run it on a server, as discussed next.

## Deploying an App on a Server
When we run an app on our computer, it is available only on *localhost*, a hostname configured to point to the loopback network interface, which means it bypasses any real network interface, and can be accessed only from your own computer and not from the outside world. This is by design and, for the most part, a good thing, as the way you run apps on a personal computer for development and testing is not the way you should run them when you want to expose them to outsiders.

**KEY TAKEAWAY 1** (LIÇÃO 1)
`You should never expose apps running on a personal computer to the outsied world.`

Instead, if you're going to expose your app to the outside world, you should run it on a server. A *server* is a computer specifically designed for running apps and exposing those apps to the outside world. A server and a personal computer differ in many ways, including the following:

**Security**: most servers run a stripped-down OS and are hardened against attacks (e.g., firewall, intrusion-prevention tools, file integrity monitoring). Your personal computer has all sorts of extra software (any of which could have a vulnerability) and is not hardened.

**Availability**: most servers are designed to be on all the time and have redundant power. Your personal computer may shut off at any time.

**Performance:** most servers run just the apps on them. You use your personal computer for others tasks (e.g., coding, browsing) that may impact your app's performance.

**Collaboration**: most apps are worked on by teams, and whereas other developers don't (and souldn't) have access to your personal computer, servers are usually designed for team access.

For these reasons, always use a server to run your production apps. Broadly speaking (em termos gerais), you have two ways to get access to servers (two options for #hosting your apps):
- You can buy and set up your won server (on premises);
- You can rent servers from other (the cloud).

We'll discuss each of these next.

## On-Prem and Cloud Hosting
The traditional way to run software is to buy servers and set them up *on premises* (on prem for short), in a physical location you own. When you are just starting out, the location could be a simple as closet in your office, but as a company grows, so do the computing demands, and you eventually need a *data center*, with all the requisite equipment (e.g., racks, servers, network administrators, security). So for decades, if you wanted to build a software company, you also had to invest quite a bit into hardware.

This stated to change in 2006 with de launch of Amazon Web Services  (AWS), the first *cloud computing platform* (cloud for short), which allowed you to rent servers using a software interface, either via a few clicks (which you'll do in this chapter) or via a few lines of code (which we'll do in chapter 2). This profound shift let you get up and running in minutes instead of months, at the cost of a few cents (or even free) instead of thousands of dollars.

There are two main cloud offerings: *infrastructure as a service (IaaS)* which gives you access to low-level computing resources (servers, hard drivers, networks), and leaves it up to you put them together into a software delivery process, and *platform as a service* (PaaS), which gives you access to higher-level primitives, including an opinionated software delivery process. To get a feel for the difference, you'll use a PaaS in the next section and an IaaS in the section after that.

### Example: Deploy an App via PaaS (Render)
Popular PaaS providers include #Heroku, Render, fly.ip, and Vercel. Heroku was on of the first PaaS providers, and it used to be my go-to choice, but it discontinued its free tier in 2022. Therefore, for the examples in this book, we'll be using Render, which offers a free Hobby tier and suport running apps in many languages and frameworks (including Node.js) without having to set up a build system or frameworks (topics you'll learn about later in the book). Render also has a good reputation in the community and is often described as the spiritual successor to Heroku. To deploy the sample app by using Render, go through the following steps:

**Steap 1: Sign up for a Render account**
Create a new account on *render.com.* 

**Step 2: Deploy a new web service**
Head to the Render Dashboard and click the Deploy a Web Service button. On the next page, select the Public Git Repository tab and enther the URL of this book's. This repo contains the Node.js code from **Example 1-1** in the ch1/sample-app folder, so this lets you deploy the app without creating your own GitHub repo.

When you're done experimenting with Render, undeploy your app by clicking the Settings tab, scrolling to the bottom, and clicking the Delete Web Service button.

Using a PaaS typically means you get not just a server, but a lot of powerful functionality out of the box: 
- scaling to multiple servers;
- domain names < NAME>.onrender.com
- encryption (HTTPS URLs)
- Monitoring (logs and metrics), and more...
This is the power of PaaS: is a matter of minutes, a good PaaS can take care of so many software delivery concerns for us. It's like magic (i don't believe in magic and nonsense). And that's the greatest strength of PaaS: it just works.

As a result, while many projects start on PaaS, if they grow big enough and require more control, they end up migrating to IaaS.

### Example: Deploy an App via IaaS (AWS)
Broadly speaking, the IaaS space falls into three buckets: (buckets = categorias)
- **Virtual private server**: Some companies primarily focus on giving you access to a *virtual private server* (VPS) for as cheap as possible (pelo melhor preço possível). These companies might offer a few other features (e.g., networking, storage) as well, but the main reason...

- **Content delivery networks**: other companies primarily focus on *content delivery network* (CDNs), which are server that are distributed all over the world, typically for serving and caching content. Again, these companies might offer a few other features (e.g., protection against attacks), but the main reason you'd go with one of these providers is that your user base is greographically distributed, and you need a fast and reliable way to serve them content with low latency. We'll learn all about CDNs in Chatper 9

- **Cloud providers**: finally, a handful of large companies are trying to provide general-purpose cloud solutions that offer overything: <span style="background:#affad1">VPS, CDN, containers, serverless, data storage, file storage, machine learning, natural language processing, edge computing, and more.</span> The big players in this space include AWS, Google Cloud, and Microsft Azure.
In general, the VPS and CDN providers are specialists in their respective areas, so in those areas, they will typically beat a general-purpose cloud provider in terms of features, pricing, and user experience.

For the examples in this book, the IaaS provider we'll be using is AWS.

---
## Serverless
É um modelo de computação em nuvem onde não gerenciamos servidores, toda a infraestrutura é gerenciada automaticamente pelo *cloud provider* (AWS, Azure, GCP).

Só escrevemos o código da função ou o serviço, fazemos o deploy, e o cloud provider cuida de todo o resto:
- Criação de servidores;
- Escalabilidade automática; etc

---

Id addition, AWS is widely recognized as the dominant cloud provider - it has a 31 % share of the market and has been the leader in the Gartner Magic Quadrant for the last 13 years. 


To deploy the sample app in AWS, go through the following steps:
- **Setp 1: Choose an AWS region**
AWS has data center all over the world, grouped into regions and availability zones. An *AWS region* is a separate geographic area, such as *us-east-2* (Ohio), eu-west-1 (Ireland), and *ap-southeast-2* (Sydney). Within each region are multiple isolated data centers know as availability zones (AZs). Just about all the examples in this book will use the us-east-2 (Ohio) region, so go into the AWS Console, and in the top right, pick us-east-2 as the region to use, as shown in Figure about:
!![image-202511171859446.png](image-202511171859446.png)

**Step 2: deploy an EC2 instance**
To deploy a server in AWS, called an *Amazon Elastic Compute Cloud (EC2) instance*, head over to the EC2 Console and click the "Launch instance" button. This will take you to a page for configuring our EC2 instance in Figure 1-4.

!![image-202511172341534.png](image-202511172341534.png)

Fill in a name for the instance, such as "sample-app". Below that, we need to pick the *Amazon Machine Image (AMI)* to use, which specifies what OS and other software will be installed (you'll learn more about machine images in Chapter 2). For now, stick with de default, which should be Amazon Linux.

**Step 3: Configure the EC2 instance**
Configure the instance type and key pair, as shown about:
!![image-202511172931384.png](image-202511172931384.png)

The *instance type* specifies the type of server to use: that is, what sort of CPU, memory, hard drive, etc. it'll have. For this quick test, you can use the default, which should be something like *t2.micro* or *t3.micro*, small instances (1 CPU 1G of memory) that are part of the AWS free tier. The *key pair* can be used to connect to the EC2 instance via Secure Shell (SSH), a topic we'll learn more about in Chapter 7. We're not going to be using SSH for this example, so select "Proceed without a key pair."

**Step 4; Configure the network settings**
Scroll down to the network settings, as shown in Figure 1-6. You'll learn about networking in Chapter 7. For now, we can leave most of these settings at their defaults: 
- Network should be set to our default VPC;
- Subnet should be set to "No preference";
- Auto-assign public IP should be set to Enable;

The only thing we should change is the Firewall (security groups) setting
select the "Create security group" radio button, disable the "Allow SSH traffic from" checkbox, and enable the "Allow HTTP traffic from the internet" checkbox, as shown in Figure 1-6. By default, EC2 instances have firewalls, called *security groups*, that don't allow any network traffic in or out.. Allowing HTTP traffic tells the security group to allow inbound TCP traffic on port 80 so that the sample app can receive requests.

!![image-202511174934330.png](image-202511174934330.png)

**Step 5: Configure advanced details**
Open the "Advanced details" section and scroll down to "User data," as shown in Figure 1-7.
!![image-202511173219129.png](image-202511173219129.png)

*User data* is a script that the EC2 instance will execute the first time it boots up. Copy and paste the script shown in... 

**Step 6: Lauch the EC2 instance**
Leave all the other settings at their defaults and click "Launch instance". Once the EC2 instance has launched , you should see its ID on the page (something like i....). Click the ID to go the EC2 instances page, where you should see our EC2 instance booting up (you' ll see the isntance state change from Pending to Running), which typically takes 1-2minutes, click the row with your instance. In a drawer that pops up at the bottom of the page, you should see more details about our EC2 instance, including its public IP address...

## Comparing Deployment Options
You've now seen several options for hosting our application; you could go with on prem (local) or the cloud, and if you go with the cloud, you could go with IaaS or PaaS. This section compares these options, starting with on prem versus the cloud, followed by IaaS versus PaaS.

**On Prem versus the Cloud**
When should you go with on prem, and when should you use the cloud? To start answering these questions, let's look at the key reasons to go with the cloud.

**When to go with the cloud**
If you're starting somethin new, in the majority of cases you should go with the cloud. Here are just a few of the advantages:

*Elasticity and pay as you go*
On prem, you pay up-front for capacity that may go unused; for example, if you need 10 servers most of the time but anticipate traffic spikes, you may have yo buy 50 servers. The cloud offers *pay-as-you-go* princing, which start out cheap or free, increases only with usage, and allows you to scale *elastically*; for example, you pay for 10 servers most of the time, and pay 50 servers only while there's a traffic spike (pico de tráfico).

*Speed*
Getting new hardware takes weeks on prem but just minutes in the cloud.

*Maintenance and expertise*
Data centers require a lot of expertise (in hardware, cooling, and power) and maintenance (replacing broken or obsolete equipment), all of which the cloud handles for us.

*Managed services*
With the cloud, we get not only servers but also services such as managed databases, load balancers, filo stores, networking, analytics, and machine learning.

*Security*
Despite the myth that on prem is more secure, the world's most secure data center belong to the cloud providers; for example, AWS complies with 143 security standards (e.g., PCI DSS, HIPAA, and NIST 800-171) and has dozens of *third-party audits and attestations* (e.g., SOC, ISO, and FedRAMP).

*Global reach*
The cloud gives you instant access to dozens of data centers around the world.

*Scale*
Major cloud providers can invest more than almost anyone else in data centers. For example, AWS made $107 billion in 2014, and it's still growing.

For all these reasons, the cloud is the facto option for most new startups, as well as new projects in many established companies.

**When to go with on prem**
Running servers yourself is the better option in the following cases:
*You already have an on-prem presence*
If our company already has its own data centers and they are working well for you, stick with them! If it ain't broke, don't fix it.

*We have usage patterns that are a better fit for on prem*
Certain usage patterns may be a better fit for on prem, for instance, steady, predictable usage that doesn't benefit from elasticity (see Basecamp for an example) or usage that requires lots of bandwidth...


## IaaS versus PaaS
If we're using the cloud, when should you go with IaaS, and when should you go with PaaS? To start answering this question, let's look at the key reasons to go with PaaS.

**When to go with PaaS**
This many seem like a strange thing to say in a book about DevOps and software delivery, but if you can create a great product without having to invest much in DevOps and software delivery, *that's a good thing*. Your customers don't care what kind of deployment pipelines you have, or whether you are running a fancy Kubernetes cluster or the newest type of database. All that matter is that you ca create a product that meets your customers' needs.

That's precisely what a good PaaS offers: out-of-the-box software delivery. If we can find a PaaS that meets your requirements, you should use it, stick with it for as long as you can, and avoid having to re-create all those software delivery pieces until you absolutely have to. PaaS is a good choice in these cases:

*Side projects*
If you're working on a **side project** (projeto paralelo), the last thing you want to do is kill you passion for that project by spending all you time fighting with builds or pipelines or networking. Instead, **let a PaaS to the heavy lifting** (deixe o trabalho pesado para PaaS). 

*Startups and small companies*
If you're building  a new company, you should almost always start with a PaaS. Startups are a race against time: can you build something the market wants before you run out of money? As you saw earlier in this chapter, you can get live on a PaaS in *minutes*, and for most startups, the scalability, availability, security, and compliance needs are minimal, so you can keep running on a PaaS for years before you run into the limitations. It's only when you find product/market fit and start hitting the problem of having to scale your company, which is a good problem to have, that you many need to move off PaaS.

*New and experimental projects*
If you're at an established company that has a slow software delivery process, using a PaaS can be a great way to quickly try ou new and experimental projects, especially if those projects don't have the same scalability, availability, security, and compliance needs as your company's more mature products.

As a general rule, you want to use a **PaaS whenever you can**, and move on to IaaS only when a PaaS can no longer meet your requirements. 

**É possível iniciar com PaaS, mas deixando o campo preparado para migrarmos para IaaS?**

**When to go with IaaS**
In the following cases, an IaaS is usually a better fit:
*Load*
If we're dealing with a lot of traffic, PaaS pricing may become prohibitively expensive.  Moreover, PaaS usually limits the types of apps and architectures you can use, so you may have to migrate to IaaS to scale your systems.

*Company size*
As you shift from a handful of developers to dozens of teams with hundreds of developers, not only can PaaS pricing become untenable, but you may also hit limits with governance and access controls (e.g., allowing some teams to make some types of changes but not others).

*Availability*
Your business may need to provide uptime guarantees that are higher than what your PaaS can provide. Moreover, when your app has an outage or a bug, PaaS offerings are often limited in the type of visibility and connectivity options they provide (e.g., Herokut doesn't let you connect to server over SSH), so you may have to migrate to IaaS to improve your ability to debug and introspect your systems.

*Security and compliance*
One of the most common reasons to move off PaaS is that most of them (with the notable exception of Aptible) do not provide sufficient visibility, access, or control to meet security and compliance requirements (e.g., SOC2, ISO 27001, PCI DSS).

You go with IaaS whenever you need more control, more performance, and/or more security. If your company gets big enough, one or more of these needs will likely push you from PaaS to IaaS; that's jutst the price of success.

## The Evolution of DevOps
One thing that struck me is that the architecture and software delivery processes at just about every one hf these software companies evolved along similar lines. They had individual differences here and there, but far more similarities than differences, and the broad shape of the evolution repeated again and again. In this section, I share this evolutionary process, broken into time high-level steps.

If you're new to DevOps and software delivery, you may be unfamiliar with some of the terms used here. Don't panic. The ideia is to start with a top-down overview, a bit like a high-level map, to help we understand the various ingredientes and how they fit together. You can think of this content as a high-level preview of the topics you'll cover in the following chapters. As you go through each chapter, you'll zoom in on each of these topics, study each one in detail, and try most of them out with real examples. You can then zoom back out and revisit this high-level map at any time to see the big picture and get your bearings again. 

Let's begin with step 1, as shown Figure 1-10, which is where most projects start, including including new startups, new initiatives at established companies, and side projects.

![image-202511185452350.png](image-202511185452350.png)

*Single server*
All your application code runs on a single server.

*ClickOps*
You manage all your infrastructure and deployments manually.

Does this familiar? It's what you just did earlier in this chapter, using Render and AWS. So congrats, you've complete step 1! But this is only the beginning. As traffic and team sized grow, you move on to step 2, shown in Figure 1-11.

!![image-202511185956910.png](image-202511185956910.png)

*Standalone database*
As your database increasingly becomes the bottleneck, you move it onto a separate server. 

*Version control*
As your teams grows, you use a version-control system to collaborate on your code and track all changes.

*Continuous integration*
To reduce bugs and outages, you set up automated tests (Chapter 4) and continuous integration (Chapter 5).

As traffic continues to grow, you move on to step 3, shown in Figure 1-12:
!![image-20251118716739.png](image-20251118716739.png)

*Multiple servers*
As traffic increases further, a single server is no longer enough, so you run your app across multiple servers (chapter 3).

*Load balancing*
You distribute traffic across the servers by using a *load balancer*.

*Networking*
To protect your servers, you put them into a private network (Chapter 7).

*Data management*
You set up schema migrations and backups for your data stores.

*Monitoring*
To get better visibility into ours systems, you set up monitoring (chapter 10).

Most software projects never need to make it past these first three steps. If you're one of them, don't fret: this is a good thing. The first three steps are relatively simple. The technologies involved are fast to learn, easy to set up, and fun to work with. If you're forced into the subsequent steps, it's because you're facing new problemas that require more-complex architectures and processes to solve, and this additional complexity has a considerable cost. If you aren't facing those problemas, you can, and should, avoid that cost. 

That said, larger, more established companies, with more users, may have to move on to step 4, shown in Figure 1-13:
!![image-20251118432382.png](image-20251118432382.png)

*Caching for data stores*
Your database continues to be a bottleneck, so we add read replicas and caches (Chapter 9).

*Caching for static content*
As traffic continues to grow, you add a content delivery network (CDN) to cache content that doesn't change often (chapter 9).

At this point, our team size if often the biggest problem, so you have to move on to step 5, shown in Figure 1-14:
![image-202511185053429.png](image-202511185053429.png)

*Multiple environments*
To help teams do better testing, you set up multiple environments (e.g., stage, prod), each of which has a full copy of our infrastructure.

*Continuous delivery*
To make deployments faster and more realiable, you set up continuous delivery (chapter 5).

*Secure communication and storage*
To keep all the new environments secure, we work on secrets management and encrypting all data at rest and in transit (Chapter 8).

As our team keep growing, to be able to keep moving quickly, we'll need to update our architecture and processes to step 6, as shown in Figure 1-15.

!![image-20251118561414.png](image-20251118561414.png)

*Microservices*
To allow teams to work more independently, you break your monolith into multiple microservices, each with its own data store and caches (Chapter 6).

*Infrastructure as Code*
Maintaining this many environments manually is hard, so we start to manage our infrastructure as code. 

These steps representes a significant increase in complexity: our architecture has more moving parts, our processes are more complicated, and we most likely need a dedicated infrastructure team to manage all this. For a small percentage of companies, typically, large enterprises with massive user bases, even this ins't engoughm and we are forced to move on to step 7.

!![image-20251118595423.png](image-20251118595423.png)

*Service discovery*
As the number of microservices increases, you set up a service discovery system to help them communicate with one another.

*Observability*
To get even more visibility into our microservices, we start using structured events, tracing, and observability tools (chapter 10).

*Hardening*
To meet various compliance standards (e.g., NIST, CIS, PCI) we work on server and network hardening,

*Microservish mesh*
With even more microservices, we start using service mesh tools are a unified solution for the preceding items (observability, service discovery, hardening), as well as for traffic control and erros handling.

Large companies produce a lot of data, and the need to analyze and leverage this data leads to step 8, shown in Figure 1-17.

!![image-20251118553821.png](image-20251118553821.png)

*Analytics tools*
To able to process and analyze your company's data, we set up data warehouse, big data systems, and fast data systems.

*Event streams*
With even more microservices communication and more data to move around, we set up an event-streaming platform and move around, we set up an event-streaming platform and move to an event-driven architecture.

*Feature toggles*
We start using feature toggles in our code to A/B test new features and to make deployments more reliable.

Finally, as our user base and employee base keeps growing, we move on to step 9, shown in Figure 1.18.

*Multiple data centers*
To handle a global user base, we set up multiple data centers around the world.
*Advanced networking*
We connect all our data centers together over the network.

*Internal developer platform*
To help boost developer productivity and to standardize coding practices, we set up an internal developer platform (chapter 11). 

The last three steps are for companies that face the toughest problems and have to deal with the most complexity: global deployments, thousands of developers, millions of customers. Even the architecture you see in step 9 is still a simplification comparad to what the top 0.1% of companies face, but if that's where you're at, we'll need more than this introductory book!


*All models are wrong, but some are useful!*

**Adopting DevOps Practices**
As we read through the nine steps, the ideia is to match our company to one of the steps and to porsue the architecture and processes in that step. What we don't want to do is to immediately jump to the end and use the architecture and processes of the largest companies. Let's be honest here: our company probably isn't Google or Netflix; we don't have the same scale, we don't have the same problems do solve, and therefore, the same solutions won't be a good fit. 

I've learned in my career is that most large software projects fail. Whereas rougly 3 out of 4 small it projects (less than $1 million) are completed successfully, only 1 ou of 10 large projects (greater than $10 million) are completed on time and on budget, and more than one-third of large projects are never completed at all.

To understand why this is so important, consider the opposite, suppose that we have a huge migration project, broken into the following steps:
1. Redesign the UI.
2. Rewrite the backend
3. Migrate the data.

We complete the first step, but we can't launch the UI because it relies on the new backend in the second step.

p