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