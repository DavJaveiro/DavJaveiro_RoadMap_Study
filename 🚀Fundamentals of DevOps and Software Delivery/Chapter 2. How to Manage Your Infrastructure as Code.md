In Chapter 1, we learned how to deploy our app by using PaaS and IaaS, but it required a lot of manual steps clicking around a web UI. This is fine while you're learning and experimenting, but managing everything at a company this way, sometimes called *ClickOps*, quickly leads to problems:
*Deployments are slow and tedious*: we can't deploy frequently or respond to problems or opportunities quickly;

*Deployments are error prone and inconsistent*: 

## Os Benefícios da IaC
Quando a nossa infraestrutura é definida como código, podemos utilizar uma variedade de práticas de engenharia de software para melhorar drasticamente nossos processos de entrega de software, incluindo o seguinte:
- **Velocidade e segurança:** ao invés de uma pessoa realizar implantações (deployments) manualmente, o que é lento e propenso a erros, definir nossa infraestrutura como código permite que um computador execute as etapas de implantação, o que será significativamente mais rápido e confiável.
- **Documentação:** se nossa infraestrutura é definida como código, o estado da nossa infraestrutura está em arquivos-fonte que qualquer um pode ler, em vez de ficar trancado na cabeça de uma única pessoa. A IaC atua como uma forma de documentação, permitindo que todos na organização entendam como as coisas funcionam.
- **Controle de versão:** armazenar nossos arquivos-fonte de IaC em controle de versão facilita a colaboração em nossa infraestrutura, a depuração de problemas (por exemplo, verificando o histórico de versões para descobrir o que mudou) e a resolução de problemas (por exemplo, revertendo para uma versão anterior).
- **Validação:** se o estado de nossa infraestrutura é definido em código, para cada mudança, podemos realizar uma revisão de código, executar um conjunto de testes automatizados e passar o código por ferramentas de análise estática, todas as práticas conhecidas por reduzir significativamente a chance de defeitos.
- **Autoatendimento (Self-service):** se nossa infraestrutura for definida como código, os desenvolvedores podem iniciar suas próprias implantações em vez de depender de outros para fazê-lo. 
- **Reutilização:** podemos empacotar nossa infraestrutura em módulos reutilizáveis para que, em vez de fazer cada implantação para cada produto em casa ambiente do zero, possamos construir sobre peças conhecidas, documentadas e testadas em batalha.
- **Felicidade:** outra razão importante, e muitas vezes esquecida, pela qual podemos usar IaC é a felicidade. Implantações manuais são repetitivas e tediosas. A maioria das pessoas ressente esse tipo de trabalho, já que não envolve criatividade, desafio ou reconhecimento. Podemos implantar código perfeitamente por meses e ninguém notará, até aquele dia em que erramos. A IaC oferece uma melhor alternativa que permite aos computadores fazer o que fazem de melhor (automação) e aos desenvolvedores fazer o que fazem de melhor (criatividade). 

### Insights Valiosos
**IaC como Gestora de Configuração do Spring:**
No ecossistema Spring Boot, dependemos muito do *application.properties* ou *application.yml*. Com IaC (Terraform ou CloudFormation), injetamos as variáveis de ambiente (como **SPRING_DATASOURCE_URL** ou AWS_REGION)  diretamente na definição da tarefa do ECS ou na Lambda. Isso elimina o erro comum de ter credenciais ou configurações de produção "hardcoded" no código Java. A infraestrutura injeta a configuração; a aplicação Java apenas a consome.

**Imutabilidade e Segurança**
- Ao usar IaC, podemos realizar SSH nas máquinas para instalar o JDK ou configurar o Tomcat manualmente. Criamos uma imagem Docker (ou uma AMI) com tudo pronto.
- *Spring Security*: A IaC garante que nossos security Groups (firewall) na AWS estejam estritamente definidos. Se alguém abrir a porta 22 ou 8080 para o mundo manualmente (ClickOps), a próxima execução do script de IaC pode alertar ou reverter essa falha de segurança automaticamente (Conceito de Drift Detection).

**Validação em CI/CD (O "Shift Left")**
- O texto menciona "análise estática". Para um desenvolvedor Java, isso é como rodar o SonarQube, mas para infraestrutura.
- Ferramentas como #Checkov ou #TFLint podem rodar o nosso pipeline (GitHub Actions/Jenkins) antes mesmo do código chegar na AWS, garantindo que não estejamos criando um bucket S3 público ou um banco de dados sem criptografia.

**Documentação Viva:**
- O maior problema de documentação em projetos Java antigos é que o diagrama de arquitetura no Confluence nunca bate com a realidade da AWS. Com IaC, o código é a realidade. Se não está no código, não deveria existir.

**Reutilização (Módulos)**
- Pense nisso como criar uma "Biblioteca Java" para infraestrutura. Podemos criar um módulo padrão "Microsserviço Spring Boot com RDS" que á vem com Load Balancer, Logs no CloudWatch e Auto Scaling configurados. Outros times apenas instanciam esse módulo, acelerando o desenvolvimento. 

## Scripts Ad Hoc
A primeira abordagem que podemos considerar para gerenciar a nossa infraestrutura como código é um *script ad hoc* (um script dedicado/improvisado). Pegamos qualquer tarefa que estávamos fazendo manualmente, divide-a em etapas discretas e usa a nossa linguagem de script favorita (por exemplo, Bash, Ruby, Python) para capturar cada uma dessas etapas em código. Quando executamos esse código, ele pode automatizar o processo de criação de infraestrutura para a gente. A melhor maneira de entender isso é experimentando, então vamos passar por um exemplo de um script ad hoc escrito em Bash, e depois aprenderemos seus pontos fortes e fracos do uso de scripts para gerenciar nossa infraestrutura. 

**Exemplo: implantar uma instância ec2 usando um Script Bash**
Como exemplo, vamos criar um script Bash que automatiza todas as etapas manuais que fizemos no Capítulo 1 para implantar um aplicativo Node.js simples na AWS. Vá para a pasta *fundamentals-of-devops* que criamos no Capítulo 1 para trabalhar nos exemplos deste livro e cria uma nova subpasta para este capítulo e para o script Bash:
