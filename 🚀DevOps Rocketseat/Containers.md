## Por que usar a mesma Docker network?
1. **Comunicação direta entre os containers**: dentro da mesma network, os containers conseguem se comunicar usando **DNS interno** do Docker.
Exemplo no *application.properties*:
```bash
spring.datasource.url=jdbc:postgresql://postgres:5432/meubanco
```
Aqui:
- postgres é o nome do container, não o IP fixo.
- O Docker faz a resolução automaticamente.

2. **Evita expor portas desnecessárias**: Se o app e o banco estão na mesma rede, não precisamos expor a porta do PostgreSQL para fora. Isso melhora a **segurança**, **isolamento**, *controle de acesso*.... o banco só será acessado pelo container da aplicação.

3. **Facilidade para subir tudo com docker-compose**:
Quando tudo está na mesma network, o compose se torna:
```json
services:
  app:
    build: .
    depends_on:
      - db
    networks:
      - minha-network

  db:
    image: postgres:15
    networks:
      - minha-network

networks:
  minha-network:
```
Tudo sobe junto, em ordem, com isolamento correto.

5. **Prática usada em produção**: Clusters Kubernetes, Docker Swarm e ambientes cloud seguem a mesma filosofia:
	- Os serviços ficam dentro da mesma **network virtual**
	- Comunicação interna é privada e isolada
	- Só a aplicação expõe portas públicas

Docker network ls
docker network connect < rede >  < image >

**Nascendo o container com a rede associada**: `docker run --network=<nome_da_rede> --rm -p <ip> `

## Arquivos e Containers
Esta aula, aborda a importância dos volumes em containers Docker para manter dados persistentes. Mostra como os arquivos são armazenados no container e como são perdidos ao reconstruir o container. Destacando a necessidade de separar as responsabilidades e exemplifica a criação de arquivos dentro do container. Demonstra como os arquivos são perdidos sem volumes persistentes.  

docker ps

**A maioria das aplicações *stateless* não precisa de volume, por exemplo:**
- APIs Java Spring Boot
- Serviços que só expõem endpoints
- Workers que processam mensagens
- Aplicações que não armazenam dados locais
- Scripts que apenas rodam e finalizam
Nesses casos, o filesystem interno do container é temporário e descartável.
- 100% reprodutível
- fácil de substituir por outro container idêntico
- sem necessidade de persistência.

**Quando é errado NÃO usar volume**
1. Bancos de dados. Sem volume, perdemos tudo ao reiniciar o container.
2. Armazenar arquivos do usuário. Uploads, relatórios, PDFs.
3. Aplicações que precisam compartilhar dados entre containers. Um backend e um worker lendo a mesma pasta.
4. Logs persistentes (em alguns casos). Com relação aos logs, o ideal seria enviá-los para um bucket (S3, GCS, Azure Blob). Ou enviar logs para serviço de Log Management (Grafana Loki, SPlunk, Datadog Logs, New Relic, CloudWatch Logs (AWS), Google Cloud Logging)...

Com relação aos Logs, a prática mais recomendada hoje, a aplicação envia logs para stdout/stderr -> Docker coleta -> log driver envia para um serviço de logs.

Declarativo vs Imperativo

**Modelo Declarativo**: 
- define o estado desejado; 
- engloba todos os recursos do fluxo; 
- mantém os estados passados no histórico;

**Modelo Imperativo:** 
- Define os comandos para criar o recurso (sequência de recursos que irá criar o recurso);
- Necessário execução em ordem (boa parte);
- Em alguns casos é possível manter o histórico do que foi feito;

---
## #Terraform 
É uma ferramenta open-source da HashiCorp usada para infraestrutura como código (IaC - Infrastructure as Code). Em outras palavras, ele permite criar, gerenciar e versionar infraestrutura de TI usando arquivos de configuração, em vez de clicar manualmente em consoles de nuvem.

1. O que ele faz
	- **Cria recursos de infraestrutura:** máquinas virtuais, redes, bancos de dados, balanceadores de carga, containers, etc.
	- **Gerencia alterações:** se mudarmos a configuração, o Terraform calcula o que precisa ser atualizado, criado ou removido.
	- **Automatiza provisionamento:** tudo é feito por código, tornando o processo **reprodutível e previsível**;
	- **Multicloud:** funciona com AWS, Azure, GCP, Oracle Cloud, VMware e até provedores on-premise.

2. **Conceitos principais**
	- **Provides:** define qual provedor de infraestrutura será usado (ex.: AWS, Azure, GCP);
	- **Resource:** um recurso de infraestrutura que criamos, como uma instância EC2, um bucket S3 ou uma VPC;
	- **Module**: um conjunto de recursos utilizáveis que podemos importar em diferentes projetos
	- **State**: arquivo que guarda o estado atual da infraestrutura, permitindo que o Terraform saiba o que já existe e o que precisa ser alterado.

O Terraforma costuma ser usado quando:
- Temos mais de uma nuvem;
- Precisamos de funcionalidades mais avançadas (ex: destroy-target, plan muito flexível, módulos externos)
- Quer complementar CD/CI com GitOps (ArgoCD, FluxCD).
## #CDK Cloud Development Kit
É uma ferramenta que permite definir infraestrutura de nuvem usando linguagens de programação, em vez de escrever arquivos de configuração declarativos (como YAML ou JSON).
Ele é usado principalmente em **projetos de infraestrutura como código (IaC)**.

1. **Como Funciona**: 
	- Escrevemos o código em linguagens como TypeScript, Python, Java ou C#;
	- Esse código descreve recursos de nuvem, como servidores, buckets, redes, bancos de dados, etc;
	- O CDK gera automaticamente os templates necessários (como CloudFormation na AWS) e provisiona a infraestrutura;
	- Integra facilmente com pipelines CI/CD;
	- Reduz a complexidade de escrever templates declarativos grandes e repetitivos.

Terraform e CDK não se misturam, eles pertencem a mundos diferentes.

Terraform 
- Criado pela HashiCorp
- Usa linguagem própria: HCL (HashiCorp Configuration Language)
- É declarativo
- É multicloud
- Fala direto com as APIs da AWS, Azure, GCP
- Não gera CloudFormation
- Não usa CDK em nenhuma etapa

Terraform (HCL) → Provedores → API das Clouds → Criar infraestrutura

Mas existe algo chamado CDK for Terraform CDKTF
A HashiCorp criou um projeto chamado CDK for Terraform (CDKTF)
Ele permite escrever Terraform usando TypeScript, Python, Go, Java.
Mas isso não tem nada a ver com AWS CDK.

CDK for Terraform (TS/Python/etc.) → Gera HCL → Terraform aplica

![[Pasted image 20251116221041.png]]


## AWS CloudFormation
É uma ferramenta nativa da AWS para Infraestrutura como Código (IaC). Ele entra como a base que a AWS usa para criar e gerenciar recursos a partir de arquivos declarativos em YAML ou JSON.

#### 🔹 **1. CloudFormation é o “motor” IaC nativo da AWS**
Ele permite criar recursos como:
- VPCs
- EC2
- S3
- IAM
- Lambda
- RDS
- e muito mais...

Tudo através de templates YAML/JSON que descrevem a infraestrutura.

Devemos pensar como:
*O CloudFormation é o jeito da AWS de entender arquiteturas prontas e criar tudo automaticamente.*

#### 🔹 **2. O AWS CDK usa o CloudFormation por baixo dos panos**
O AWS CDK (Cloud Development Kit) é uma camada mais amigável que gera automaticamente os templates do CloudFormation.

Fluxo:
1. Escrevemos infraestrutura em TypeScript/Python/Java/etc.
2. O CDK converte o nosso código -> YAML do CloudFormation
3. O CloudFormation cria os recursos na AWS

CDK é o Programador
CloudFormation é quem executa.

---
## Declarativo vs Imperativo
1. **Imperativo - "faça isso passo a passo"**
É como dar instruções detalhadas: "crie este servidor, depois instale isso..."
**Características:**
- Baseado em passo a passo;
- Focado em ações;
- O sistema só segue as instruções (não pensa sozinho);
- Se algo quebra no meio, nada garante o estado final;
Exemplos: CLI da AWS; Scripts bash; kubectl run, Playbooks...

1. **Declarativo - "quero que fique assim"**
Dizemos apenas o estado desejado, não como chegar lá.

- Terraform: declarativo
```hcl
resource "aws_instance" "app" {
	instance_type = "t2.micro"
}
```

Não dizemos como criar a VM, só dizemos que ela deve existir.

- Kubernetes -> declarativo 
```yaml
replicas: 3
```
Não dizemos "crie mais 2 pods", apenas, quero 3 pods e o k8s gerencia.


