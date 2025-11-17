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

- **Cloud providers**: finally, a handful of large companies are trying to provide general-purpose cloud solutions that offer overything: VPS, CDN, containers, serverless, data storage, file storage, machine learning, natural language processing, edge computing, and more. The big players in this space include AWS, Google Cloud, and Microsft Azure.
In general, the VPS and CDN providers are specialists in their respective areas, so in those areas, they will typically beat a general-purpose cloud provider in terms of features, pricing, and user experience.

For the examples in this book, the IaaS provider we'll be using is AWS, 