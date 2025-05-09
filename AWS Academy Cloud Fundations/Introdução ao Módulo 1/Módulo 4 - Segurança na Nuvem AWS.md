A segurança é de alta importância para a AWS. A capacidade de proteger e a natureza confidencial dos dados não pode ser exagerada, uma vulnerabilidade de segurança que é deixada de lado, pode potencialmente destruir anos de esforços em apenas alguns minutos.

**Tópicos**
- Modelo de responsabilidade compartilhada da AWS;
- AWS Identity and Access Management (IAM);
- Proteção de novas contas da AWS;
- Proteção de contas;
- Proteção de dados na AWS;
- Garantia de conformidade;

**Atividades**
- Atividade do modelo de responsabilidade compartilhada da AWS;

**AWS Identity and Access Management (IAM)**
- Use o IAM para gerenciar o acesso aos recursos da AWS:
	- Um recurso é uma entidade em uma conta da AWS com a qual podemos trabalhar;
	- Exemplo de recursos: uma instância do Amazon EC2 ou um bucket do Amazon S3;

**Exemplo:** controle quem pode encerrar instâncias do Amazon EC2;

Defina Direitos de acesso refinados:
- Quem pode acessar o recurso;
- Quais recursos podem ser acessados e o que o usuário pode fazer com o recurso;
- Como os recursos podem ser acessados;

O IAM é um recurso de conta da AWS gratuito.

IAM componentes essenciais:
**Usuário:** é uma pessoa ou aplicativo que pode se autenticar com uma conta da AWS. Cada usuário deve ter um nome exclusivo sem espaços no nome e deve ser atribuído uma maneira de se identificar, algo tão simples quanto uma uma senha.

**Grupo do IAM:** uma coleção de usuários do IAM que recebem autorização idêntica. Podemos adicionar ou remover usuário do grupo sem precisar anexar políticas diretamente a cada usuário. Os grupos são úteis para definir cuidadosamente o acesso a diferentes equipes de responsabilidade como DBAs, desenvolvedores e auditores.

**Política do IAM:** é o documento que define quais recursos podem ser acessados e o nível de acesso a cada recurso. As políticas são criadas de forma independente entre os grupos. 

**Função do IAM:** é o mecanismo útil para conceder um conjunto de permissões para fazer solicitações de serviço da AWS. Um usuário pode acessar um serviço que normalmente não está disponível. O usuário assume a função, lida com o serviço conforme necessário. Isso é semelhante ao comando sudo em sistemas operacionais Linux, onde um usuário pode executar uma função administrativa que normalmente não está disponível para ele. 

**Autenticar como um usuário do IAM para obter acesso**
Ao definir um usuário do IAM, selecionamentos **os tipos de acesso** que o usuário tem permissão para usar.

- **Acesso programático**: ele se autentica utilizando ID da chave de acesso e a chave de acesso secreta, onde será fornecido acesso à CLI e ao SDK da AWS, quando fizer uma chamada de API da AWS.

- **Acesso ao Console de Gerenciamento da AWS:** o usuário autentica-se usando o ID ou alias da conta com 12 dígitos, nome de usuário do IAM e a senha do IAM. Se ativada, a Multi-Factor Authentication (MFA) solicita um código de autenticação. A MFA oferece maior segurança. Além do nome de usuário e da senha, a MFA requer um código de autenticação exclusivo para acessar os serviços da AWS.

**Autorização: quais ações são permitidas?**
Depois que o usuário ou o aplicativo estiver conectado à conta da AWS,  o que ele poderá fazer?
![[Módulo 4 - Segurança na Nuvem AWS.png]]
**Bucket do S3** é como um *contêiner* ou *pasta raiz* onde armazenamos nossos arquivos (que no S3 são chamados de objetos). É a estrutura básica de organização no Amazon S3.

**IAM: autuorização**
- Atribua permissões criando uma política do IAM;
- As permissões determinam **quais recursos e operações** são permitidos:
	- Todas as permissões são implicitamente negadas por padrão;
	- Se algo for explicitamente negado, nunca será permitido/

**Prática recomendada:** siga o **princípio do privilégio mínimo.**

**Exemplo de uso de uma função do IAM**
![[Módulo 4 - Segurança na Nuvem AWS-1.png]]

**Acesso de usuário raiz da conta da AWS em comparação ao cesso do IAM**
*Usuários raiz da conta:* os privilégios não podem ser controlados e ele possuí acesso total a todos os recursos.

**Prática recomendada:** não use o usuário raiz da conta da AWS, exceto quando necessário. O acesso ao usuário raiz da conta requer o login com o endereço de e-mail (e a senha) que usamos para criar a conta.

**Ações de exemplo que só podem ser realizadas com o usuário raiz da conta:**
- Atualizar a senha do usuário raiz da conta
- Alterar o plano do AWS support
- Restaurar as permissões de um usuário do IAM
- Alterar as configurações dad conta (por exemplo, informações de contato, regiões permitidas)

Pare de usar o usuário raiz da conta:
1. Enquanto estiver conectado como o usuário raiz da conta, **crie um usuário do IAM** para você mesmo. Salve as chaves de acesso, se necessário.
2. Crie um grupo do IAM, atribua a ele permissões completas de administrador e adicione o usuário do IAM ao grupo.
3. Desabilite e **remova as chaves de acesso do usuário raiz da conta**, se elas existirem;
4. Habilite uma política de senha para usuários.
5. Faça login com as novas credenciais de usuário do IAM;
6. Armazene as credenciais de usuário raiz da conta em um local seguro.

**Proteção de novas contas da AWS: AWS CloudTrail**
Etapa 3: Usar o AWS CloudTraill

# Laboratório 1: Introdução ao AWS IAM

O AWS Identify and Access Management (AWS IAM) é um serviço da web que **possibilita a clientes da Amazon** Web Services (AWS) <span style="background:#d4b106">gerenciar usuários e permissões de usuários na AWS</span>. Com o IAM, podemos gerenciar de forma centralizada os **usuários**, as **credenciais de segurança** (como chaves de acesso) e as **permissões** que controlam quais recursos da AWS os usuários podem acessar.

Esse laboratório demonstrará como:
![[Módulo 4 - Segurança na Nuvem AWS-2.png]]

- Como explorar **usuários e grupos do IAM** pré-criados
- Como inspecionar **políticas do IAM**, conforme aplicadas aos grupos pré-criados;
- Como seguir um **cenário real** adicionando usuários a grupos com recursos específicos ativados.
- Como localizar e usar a URL de login do IAM
- Como testar os efeitos das políticas no acesso ao serviço.

**Restrições de serviço da AWS**
Neste ambiente de laboratório, o acesso aos serviços e às ações de serviços da AWS podem ser restritos aos casos necessários para concluir as instruções do laboratório. 

**AWS Identity and Access Management**
O AWS Identity and Access Management (IAM) pode ser usado para:
- **Gerenciar usuários do IAM e o acesso:** podemos criar usuários e atribuir a eles credenciais de segurança individuais (chaves de acesso, senhas e dispositivos de autenticação multifator). É possível gerenciar as permissões para controlar quais operações um usuário pode executar;
- **Gerenciar perfis do IAM e as permissões:** um perfil do IAM é semelhante a um usuário, já que é uma identidade da AWS com políticas de permissão que definem o que a identidade pode e não pode fazer na AWS. Porém, a finalidade de uma função é poder ser assumida por qualquer pessoa que necessite dela e não associada exclusivamente a um único indivíduo.
- **Gerenciar usuários federados e as permissões:** você pode ativar a **federação de identidade** para permitir que os usuários existentes em nossa empresa acessem o Console de Gerenciamento da AWS, chamem as APIs da AWS e acessem recursos, sem precisar criar um usuário do IAM para cada identidade. 

**Tarefa 1: Explorar usuários e grupos**
Nesta tarefa, vamos explorar os usuários e grupos que foram criados no IAM.

![[Módulo 4 - Segurança na Nuvem AWS-3.png]]
Esse grupo tem uma política gerenciada associada a ele, chamada **AmazonEC2ReadOnlyAcess**. As políticas gerenciadas são políticas predefinidas (criadas pela AWS ou pelos administradores) que podem ser associadas a usuários e grupos do IAM. Quando a política é atualizada, as alterações são imediatamente aplicadas a todos os usuários e grupos vinculados a ela.

A estrutura básica das declarações de uma política do IAM são:
- **Efeito:** indica se deseja *permitir* ou *negar* as permissões;
- **Ação:** específica as chamadas de API que podem ser feitas em um serviço da AWS (por exemplo, *cloudwatch:ListMetrics*);
- **Recursos:** define o escopo das entidades cobertas pela regra de política (por exemplo, um bucket específico do Amazon S3 ou uma instância do Amazon EC2; ou * , que indica **qualquer recurso**). Está no formato JSON:
```JSON
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "ec2:Describe*",
                "ec2:GetSecurityGroupsForVpc"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "elasticloadbalancing:Describe*",
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "cloudwatch:ListMetrics",
                "cloudwatch:GetMetricStatistics",
                "cloudwatch:Describe*"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "autoscaling:Describe*",
            "Resource": "*"
        }
    ]
}
```

**AmazonS3ReadOnlyAccess** - 
```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:Get*",
                "s3:List*",
                "s3:Describe*",
                "s3-object-lambda:Get*",
                "s3-object-lambda:List*"
            ],
            "Resource": "*"
        }
    ]
}
```
Essa política concede permissões para ações [Obter] e [Listar] recursos no Amazon S3.

**EC2-Admin-Policy**:
```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "ec2:Describe*",
                "ec2:StartInstances",
                "ec2:StopInstances"
            ],
            "Resource": [
                "*"
            ],
            "Effect": "Allow"
        }
    ]
}
```

Esse grupo é um pouco diferente dos outros dois. Em vez de uma *política gerenciada*, ele tem uma **política em linha**, que é uma política atribuída a apenas um usuário ou grupo. As políticas em linha são normalmente usadas para aplicar permissões para situações pontuais.

Essa política concede permissão para ação Describe, para visualizar informações sobre o Amazon EC2 e para as ações Start (Iniciar) e Stop (Interromper) instâncias. 

## Cenários de Negócios
Para o restante deste laboratório, trabalharemos com esses Usuários e Grupos para ativar permissões que oferecem ao seguinte cenário de negócios:

Nossa empresa está aumentando o uso do Amazon Web Services e está usando muitas instâncias do **Amazon EC2** e uma grande quantidade do **Amazon S3**. Desejamos conceder acesso a novos membros da equipe de acordo com suas funções de trabalho:

**user-1** - S3-Support - Acesso de somente leitura ao Amazon S3;
**user-2** - EC2-Support - Acesso de somente leitura ao Amazon EC2;
**user-3** - EC2-Admin - Visualizar, iniciar e interromper instâncias do Amazon EC2.

## Tarefa 2: Adicionar usuários a grupos
Recentemente, contratamos o **user-1** para uma função de suporte ao Amazon S3. Devemos adicionar ele ao grupo **S3-Support** para que ele herde as permissões necessárias por meio da política *AmazonS3ReadOnlyAccess* associada.

Você pode ignorar todos os erros indicando "não autorizado" que aparecem durante essa tarefa.


## Seção 5: Proteção de dados na AWS
**Criptografia de dados em *repouso***
- A criptografia codifica dados com uma **chave secreta**, o que os torna ilegíveis. Somente quem tem a chave secreta pode decodificar os dados, o AWS KMS pode gerenciar nossas chaves secretas.

- A AWS oferece suporte à a criptografia de dados em repouso
	- Dados em repouso = dados armazenados fisicamente (em disco ou fita)
	- Podemos criptografar dados armazenados em qualquer serviço compatível com o AWS KMS, isso inclui:
		- Amazon S3
		- Amazon EBS
		- Amazon Elastic File System (Amazon EFS)
		- Banco de dados gerenciados do Amazon RDS

**Criptografia de dados em *trânsito***
- Criptografia de dados em trânsito (dados em movimentação por uma rede)
	- Transport Layer Security (TLS), anteriormente SSL, é um protocolo de padrão aberto;
	- AWS Certificate Manager oferece uma maneira de gerenciar, implantar e renovar certificados TLS ou SSL;

- O HTTP seguro (HTTPS) cria um túnel seguro
	- Ele usa TLS ou SSL para a troca bidirecional de dados

- Os serviços da AWS oferecem suporte à criptografia de dados em trânsito:
![[Módulo 4 - Segurança na Nuvem AWS-4.png]]

![[Módulo 4 - Segurança na Nuvem AWS-5.png]]

O tráfego da web executado por HTTP não é seguro.

O HTTP (Hypertext Transfer Protocol) é um protocolo de comunicação sem criptografia. Isso significa que:
- Tudo que é transmitido entre o navegador e o servidor pode ser interceptado por terceiros (como senhas, dados pessoas, cookies, etc). 
- É vulnerável a ataques como:
	- **Ataques Man-in-the-Middle (MitM) -** onde um invasor intercepta e possivelmente altera os dados;
	- **Espionagem de rede (sniffing)** - especialmente em redes públicas (Wi-fi de cafés, aeroportos etc).

O HTTPS (Hypertext Transfer Protocol Secure) é a versão segura do HTTP. Ele usa criptografia TLS/SSL para garantir:
- Confidencialidade - ninguém além do emissor e receptor pode ler os dados;
- Integridade - os dados não são alterados durante a transmissão;
- Autenticidade - temos garantir de que estamos falando com o servidor certo (via certificados digitais).
- O HTTPS cria um túnel seguro criptografado de forma bidirecional.

**Proteção de buckets e objetos do Amazon S3**
Os buckets e objetos do S3 recém-criados são **privados** e **protegidos** por padrão.

Quando os casos de uso exigem o compartilhamento de objetos de dados no Amazon S3:
	- É essencial gerenciar e controlar o acesso aos dados;
	- Siga as permissões que respeitam o princípio do privilégio mínimo e considere o uso da criptografia do Amazon S3;

**Ferramentas e opções para controlar o acesso aos dados do S3 incluem:**
- Recurso Amazon S3 Block Public Access: simples de usar;
- Políticas do IAM: uma boa opção quando o usuário pode autenticar usando o IAM;
- Políticas de buckets;
- Listas de controle de acesso (ACLs): um mecanismo de controle de acesso herdado.
- Verificação de permissão de bucket do AWS Trusted Advisor: um recurso gratuito.

## Seção 6: Trabalhar para garantir a conformidade
Os clientes estão sujeitos a muitos regulamentos e requisitos diferentes de segurança e conformidade.
A AWS contrata órgãos de certificação e auditores independentes para fornecer aos clientes informações detalhadas sobre as políticas, os processos e os controles estabelecidos e operados pela AWS.

Os programas de conformidade podem ser categorizados amplamente