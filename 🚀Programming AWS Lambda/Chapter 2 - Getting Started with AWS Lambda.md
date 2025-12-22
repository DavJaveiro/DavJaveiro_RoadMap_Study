O Capítulo 1 forneceu a base para o restante deste livro: a nuvem, serverless, AWS e uma introdução ao que é o Lambda, como ele funciona e para que pode ser usado. Mas este é um livro prático, para pessoas práticas, então neste capítulo vamos arregaçar as mangas e implantar algumas funções funcionais na nuvem.

Começaremos nos familiarizando um pouco mais com o Console AWS e, em seguida, implantaremos e executaremos nossa primeira função Lambda. Depois disso, prepararemos um ambiente de desenvolvimento local e, finalmente, construiremos e implantaremos no Lambda uma função desenvolvida localmente.

**Lambda Hello World**
Nesta seção, vamos implantar e executar nossa primeira função Lambda. Vamos contar um segredinho: faremos isso com JavaScript. Shhh—não conte aos nossos editores—nós prometemos que este seria um livro de Java!

A razão para fazer este primeiro exemplo em JavaScript é que podemos realizar o exercício completo puramente no navegador web, dando-nos um gostinho do que é possível no Lambda em apenas alguns minutos.

Primeiro, volte para a tela inicial do Console Web da AWS e escolha Lambda. Se você nunca usou o Lambda nesta conta antes, verá uma tela parecida com a Figura 2-3. Se o Lambda já foi usado nesta conta, o console web se parecerá mais com a Figura 2-4 (Lista de funções Lambda). Novamente, pode parecer diferente dependendo de quando você ler isso, devido às constantes mudanças de design de interface da Amazon.

De qualquer forma, clique em _Create function_ (Criar função) e depois escolha _Author from scratch_ (Autorar do zero)—existem outras opções aqui para começar com funções mais complexas, mas faremos algo muito simples agora.

Na caixa de nome, digite `HelloWorld` e, em _Runtime_, clique em **Node.js 10.x**. Não se preocupe, trabalharemos com Java em breve! Agora clique em _Create function_.

Se, após fazer isso, o console expandir a seção de Permissões, selecione _Create a new role with basic Lambda permissions_ (Criar uma nova role com permissões básicas de Lambda) no menu suspenso _Execution role_ e clique em _Create function_ novamente.

O Lambda criará uma configuração de função dentro da plataforma e o levará para a página principal do console da função após uma breve espera. Se você rolar para baixo, verá que ele até forneceu à função algum código padrão—esse código serve perfeitamente para nós por enquanto.

Role de volta para o topo e clique no botão **Test**. Isso abrirá uma caixa de diálogo chamada _Configure test event_ (Configurar evento de teste)—digite `HelloWorldTest` na caixa _Event name_ e clique em _Create_. Isso o levará de volta à tela da função Lambda. Agora clique em **Test** novamente.

Desta vez, o Lambda realmente executará sua função, e haverá um pequeno atraso enquanto ele instancia um ambiente para o código. Em seguida, você verá uma caixa com _Execution result_ (Resultado da execução)—deve dizer que a função foi bem-sucedida! Expanda o controle _Details_ e você verá o valor retornado pela sua função, além de alguns outros diagnósticos.

**Configurando Seu Ambiente de Desenvolvimento**
Agora que você teve um gostinho de executar funções (sem servidores!), vamos nos voltar para a construção e implantação real de funções Lambda em Java, de uma maneira mais adequada para iteração rápida e automação. Primeiro, você precisa configurar um ambiente de desenvolvimento local.

**Interface de Linha de Comando da AWS (CLI)**
Amazon e AWS são construídas sobre APIs. [...] O que isso significa é que quase tudo que podemos fazer através da interface do Console Web da AWS, também podemos fazer usando a API e a CLI da AWS. [...] Por esse motivo, a AWS nos dá duas ferramentas para facilitar as coisas: SDKs e a CLI.

**Adquirindo credenciais para a AWS CLI**
As credenciais que você usa com a AWS CLI são diferentes daquelas usadas para logar no Console Web. Para a CLI, você precisa de dois valores: um **Access Key ID** e sua **Secret Access Key**. [...] Se você não tiver um usuário IAM, precisará criar um.
Vá ao console IAM, clique em _Users_ -> _Add user_. Dê um nome e selecione **Programmatic access** (Acesso programático). [...] Na tela de permissões, selecione _Attach existing policies directly_ e escolha **Administrator Access**.

> _Nota do livro:_ Para aprender Lambda, ter um usuário com permissões totais facilitará nossa vida. **Você não deve fazer isso em contas de produção reais.**

Ao final, copie o Access Key ID e a Secret Access Key. Execute `aws configure` no terminal e cole esses valores. Defina a região padrão (ex: `us-west-2`) e o formato de saída como `json`.

**Configuração Java**
A AWS Lambda suporta Java 8 e Java 11 (e versões mais recentes agora). É fortemente recomendado que você tenha a mesma versão principal do JDK localmente que a configurada na sua função Lambda. Para validar seu ambiente, execute `java -version` e `mvn -v` (para o Maven).

**Instalação do AWS SAM CLI**
A ferramenta final que você precisa instalar é o AWS SAM CLI. SAM significa _Serverless Application Model_. O SAM CLI opera sobre a AWS CLI regular para nos dar ferramentas extras úteis.

**Lambda Hello World (Do Jeito Certo)**
Com nosso ambiente pronto, é hora de criar e implantar uma função Lambda escrita em Java.

**Criando Seu Primeiro Projeto Java Lambda**
Existe um "código clichê" (boilerplate) necessário para construir e implantar uma função Lambda de forma automatizada. [...] Para agilizar, criamos um template. 

<span style="background:#ff4d4f">**ATENÇÃO**</span>
> Execute: `$ sam init --location gh:symphoniacloud/sam-init-HelloWorldLambdaJava`
Isso gerará um diretório de projeto contendo:

**ESTE COMANDO ESTÁ PUXANDO UM REPOSITÓRIO DO GIT DESATUALIZADO COM JAVA8. REALIZAR O TESTE USANDO O COMANDO `sam init`**.


- `pom.xml`: Arquivo de projeto Maven.
    
- `template.yaml`: Arquivo de modelo SAM usado para implantar o projeto na AWS.
    
- `src/main/java/book/HelloWorld.java`: O código fonte.

```java
package book;
public class HelloWorld {
    public String handler(String s) {
        return "Hello, " + s;
    }
}
```
**Construindo o Hello World**

Nós implantamos código na plataforma Lambda enviando um arquivo ZIP (ou JAR). Por enquanto, criaremos um **uberjar**—um JAR que contém todo o nosso código mais todas as dependências de classpath. 
Execute `mvn package` para criar o artefato.

**Criando a Função Lambda**
Antes de implantar, precisamos de um _staging bucket_ no S3 para armazenar artefatos de build temporários. Crie um com: `$ aws s3 mb s3://nomedoseubucket` Anote este nome como `$CF_BUCKET`.

Como bucket pronto, execute (após o *mvn package*):
```bash
sam deploy --s3-bucket <nomeBucket> --stack-name HelloWorldLambdaJava --capabilities CAPABILITY-IAM
```

<span style="background:#ff4d4f">ATENÇÃO</span>

realizar o comando:
```bash
SAM deploy --guided
```

O SAM vai nos perguntar tudo:
- Stack Name
- Region
- Confirm changes y

Com isso, ele vai criar o arquivo samconfig.toml

**Regra:**
Se for o primeiro deploy daquele projeto, usamos o *--guided*

<span style="background:#affad1">usar:</span>
sam build
sam deploy

**Derrubando Recursos (Tearing Down)**

Para limpar sua conta AWS após testar, a maneira mais simples é encontrar a stack correspondente no CloudFormation e deletá-la, ou via linha de comando: `$ aws cloudformation delete-stack --stack-name HelloWorldLambdaJava`

Comando para listar as stacks no cloud formation:
`aws cloudformation list-stacks`

Opção mais usada (somente stacks ativas)
aws cloudformation list-stacks --stack-status-filter CREATE_COMPLETE UPDATE_COMPLETE UPDATE_ROLLBACK_COMPLETE
