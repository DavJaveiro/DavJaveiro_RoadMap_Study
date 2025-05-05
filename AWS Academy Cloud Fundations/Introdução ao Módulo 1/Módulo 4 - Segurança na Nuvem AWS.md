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

**Grupo do IAM:** uma coleção de usuários do IAM que recebem autorização idêntica.

