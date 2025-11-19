É um dos tópicos mais cobrados na prova AWS Solutions Architect Associate.

**E mais da metade** das outras questões envolve IAM indiretamente (permissões, roles, policies, segurança de serviços, etc.).

O que mais cai em IAM na prova:
1. **IAM Roles**
	- Role para EC2
	- Role para Lambda
	- Role para ECS tasks
	- Role para Cognito
	- <span style="background:#d3f8b6">Cross-account role</span> (muito cobrado!)
	- Delegação de acesso temporário
2. **IAM Policies**
	1. Inline vc Managed
	2. AWS Managed vs Customer Managed
	3. Policy evaluation logic (Allow + Deny > Tudo)
	4. Como diagnosticar "AccessDeniedException"
....

Do you wish to conquer the IAM basics? Lets us unlock some advanced tactics to make our cloud security impenetrable. Imagine our team as a group of knights, each with unique strenghts.


## CloudTrail: Our all-seeing Eye

- O que o CloudTrail faz? Ele registra todas as chamadas de API feitas na AWS (console, CLI, SDK). Respondendo: "Quem fez o quê, quando e de onde?" Isso é cobrado DIRETAMENTE.

