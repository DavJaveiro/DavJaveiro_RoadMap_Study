para aprender como construir uma aplicação web full-stack usando os padrões que estão sendo utilizados na indústria de desenvolvimento. Este livro é adaptado com base nas aplicações que desenvolvemos em nossos treinamentos e workshops. Então, vamos começar nossa aventura.

Este capítulo servirá como uma breve recapitulação sobre os fundamentos do Java Spring Boot e do Angular para lhe dar uma ideia do que está por vir em termos de desenvolvimento web com eles. Você também aprenderá o quão grande é a comunidade e que o suporte disponível para o Angular o torna confiável para o desenvolvimento de aplicações.

Neste capítulo, abordaremos os seguintes tópicos:
- Introdução ao Spring Boot
- As vantagens de usar o Spring Boot
- O que há de novo no Java 17
- Introdução ao Angular
- As vantagens de usar o Angular

## The advantages of using Angular
O Angular é um framework baseado em componentes, o que significa que desenvolvemos partes de nossas aplicações em pedaços menores, e podemos reutilizar esses pedaços em toda a aplicação. Este recurso reduz o código repetitivo (*boilerplate*) e erros de código, garantindo que não haja tanto código repetido. Uma das principais vantagens do Angular é a sua linguagem. Vamos dar uma olhada mais de perto.

## Framework baseado em TypeScript
O Angular é um framework baseando na linguagem TypeScript. Essa linguagem é uma vantagem significativa, pois o TypeScript oferece recursos que são benéficos para o desenvolvimento. Além disso, é um superconjunto do JavaScript, que adicionou novos conceitos que tornam o código mais fácil de manter e eficaz.

Como podemos ver, o TypeScript é construído sobre o ES6 e o JavaScript, com o objetivo de adicionar mais recursos para o desenvolvimento. Alguns dos componentes do TypeScript incluem Gnerics, Types e Interfaces, que como sabemos, estão diretamente relacionados à programação orientada a objetos POO. Agora, vamos ver outra vantagem.

**Tipagem estática**
O TypeScript pode definir dados de tipo estático, o que permite que as variáveis sejam estritamente tipadas. Em comparação com o JavaScript puro, o compilador alerta se houver algum erro relacionado a tipos, ou seja, erros que seriam capturados em tempo de execução. Dessa forma, o TypeScript pode evitar erros em produção, informando sobre esses problemas em tempo de compilação.

**Previsibilidade e manutenibilidade**
Como o TypeScript é estritamente tipado, isso contribui para o conceito de previsibilidade. Por exemplo, uma variável é declarada como um número (number). Portanto, ela sempre permanecerá como um número em toda a aplicação, as funções especificarão como implementá-las, já que todos os parâmetros também são estritamente tipados. Além disso, o TypeScript também facilita a manutenção, pois dá aos desenvolvedores o poder de depurar aplicações em tempo de compilação.

**Single Page Application**
O Angular é uma aplicação de página única (single-page application ou SPA), o que significa que quando um usuário navega de uma página para outra, a página não recarrega, pois são os dados que estão sendo buscados no servidor. Além disso, os recursos do cliente são independentes e já estão carregados no navegador, o que contribui para o desempenho de carregamento da aplicação. 

**The Angular CLI**
Não precisamos criar ou configurar o Angular do zero. Em vez disso, podemos usar o Angular CLI, que ajuda a instalar as dependências necessárias para executar nossa aplicação Angular com sucesso. Embora os recursos de schematics sejam responsáveis por criar os arquivos necessários, instalar os pacotes e configurar os valores de que precisamos para nossa aplicação, o Angular CLI gera código repetitivo para módulos, componentes, serviços e diretivas, agilizando o desenvolvimento.
```shell
// comando para instalar o Angular CLI
npm install -g @angular/cli

// comando para criar uma nova App Angular
ng new <nome-do-projeto>

// comando para criar um novo Componente
ng generate component <nome-do-componente>

// comando para criar um novo Serviço
ng generate service <nome-do-servico>

// comando para criar um novo Módulo
ng generate module <nome-do-modulo>
```
