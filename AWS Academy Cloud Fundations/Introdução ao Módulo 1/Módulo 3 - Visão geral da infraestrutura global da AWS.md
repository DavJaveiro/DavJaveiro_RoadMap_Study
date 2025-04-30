**Tópicos abordados:**
- Infraestrutura global da AWS;
- Visão geral dos serviços e das categorias de serviços da AWS;

**Demonstração**
- Infraestrutura global da AWS;

**Atividades**
- Navegando no Console de Gerenciamento da AWS;

Vamos aprender a identificar a diferença entre regiões, zonas de disponibilidade e pontos de presença da AWS.

- Também identificar categorias de serviços da AWS;


## Seção 1 - Infraestrutura global da AWS
A AWS possuí 36 regiões lançadas, atualmente, cada uma com várias zonas de disponibilidade;
114 zonas de disponibilidades
Mais de 700 POPs do CloudFront.

**Região da AWS**
Uma região da AWS é uma área geográfica;
- Portanto, a replicação dos dados entre as regiões são controlados por nós.
- A comunicação entre regiões usa a infraestrutura de rede **backbone** da AWS.

- Cada região fornece redundância total e conectividade com a rede.
- Uma região normalmente consiste em duas ou mais **zonas de disponibilidade**.

Portanto, os dados não são replicados automaticamente. 

Para obter informações sobre ping, podemos usar o cloudping.info https://www.cloudping.info/

Cada região tem várias zonas de disponibilidade e, cada zona de disponibilidade, é uma partição totalmente isolada da infraestrutura da AWS.

As **zonas de disponibilidade** consistem em **datacenters** distintos. Sendo projetados para isolar falhas, e são conectados a outras zonas de disponibilidade usando redes privadas de alta velocidade. Escolhemos nossas zonas de disponibilidade. 

![[Módulo 3 - Visão geral da infraestrutura global da AWS.png]]

Os datacenters da AWS são projetados para segurança, uma zona de disponibilidade é a unidade mais granular. Os *datacenters* são os locais onde os dados residem  e o processamento de dados ocorre. Cada datacenter tem energia, redes e conectividade redundantes e está hospedado em uma instalação separada.
Normalmente, um datacenter tem de 50.000 a 80.000 servidores físicos. 

Elasticidade e escalabi