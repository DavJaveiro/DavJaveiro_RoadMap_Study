## **Objetivos**
Os objetivos deste capítulo são introduzir requisitos de software e explicar o processo envolvido na descoberta e na documentação desses requisitos. Ao ler este capítulo, vamos:
- compreender os conceitos de <span style="background:#fff88f">requisitos de usuário</span> e <span style="background:#fff88f">requisitos de sistema</span> e por que eles devem ser escritos de maneiras diferentes;
- compreender <span style="background:#fff88f">as diferenças</span> entre <span style="background:#fff88f">requisitos de software</span> <span style="background:#d3f8b6">funcionais</span> e <span style="background:#d3f8b6">não funcionais</span>;
- compreender as <span style="background:#fff88f">principais atividades</span> da <span style="background:#fff88f">engenharia de requisitos</span>: <span style="background:#d3f8b6">elicitação</span>, <span style="background:#d3f8b6">análise</span> e <span style="background:#d3f8b6">validação</span>, e as relações entre elas;
- compreender por que o <span style="background:#fff88f">gerenciamento de requisitos</span> é necessário e como ele apoia outras atividades da engenharia de requisitos.

### **Conteúdo**
- 4.1 Requisitos funcionais e não funcionais;
- 4.2 Processos de engenharia de requisitos;
- 4.3 Elicitação de requisitos;
- 4.4 Especificação de requisitos;
- 4.5 Validação de requisitos;
- 4.6 Mudanças de requisitos

### Introdução
Os requisitos de um sistema são as descrições dos serviços que o sistema deve prestar ou fazer e as restrições a sua operação. Os requisitos estão relacionados com as necessidades dos clientes de um sistema que atende a um determinado propósito, como controlar um dispositivo, fazer um pedido ou encontrar informações. O processo de descoberta, análise, documentação e conferência desses serviços e restrições é chamado de <span style="background:#fff88f">engenharia de requisitos </span>(ER).

O termo *requisito* não é utilizado consistentemente. 

Alguns dos problemas que surgem durante o processo de engenharia de requisitos são consequências de não separar claramente os diferentes níveis de descrição. Os requisitos de *usuário* e requisitos de *sistema* podem ser definidos da seguinte forma:
1. Requisitos do usuário são declarações, em uma linguagem natural somada a diagramas, dos serviços que se espera que o sistema forneça para os usuários e das limitações sob as quais ele deve operar. 
2. Os requisitos de sistemas são descrições mais detalhadas das funções, dos serviços e das restrições operacionais do sistema de software. O documento de requisitos de sistema (chamado às vezes de especificação funcional) deve definir exatamente o que deve ser implementado. Pode fazer parte do contrato entre o adquirente do sistema e os desenvolvedores de software.

Posso resumir os requisitos de usuário as necessidades que os usuários tem para que o software resolva suas dores, ou seja, as funcionalidades que o software precisa ter para resolver uma dor ou problema dos usuários.

Os requisitos de usuário é bem genérico. Já os requisitos de sistema fornecem informações mais específicas sobre os serviços e funções que devem ser implementados.

Os diferentes tipos de leitores de documento exibidos na Figura 4.2 são exemplos de *stakeholders* do sistema. Assim como os usuários, muitas outras pessoas têm algum tipo de interesse no sistema. Os #stakeholders incluem qualquer um que seja afetado de alguma maneira pelo sistema e, portanto, tenha um interesse legítimo nele. Podem variar de usuários finais de um sistema a gerente e *stakeholders* externos, como autoridades reguladoras, que certificam a aceitabilidade do sistema. Por exemplo, os *stakeholders* do sistema Mentcare são:
1. Pacientes cujas informações estão registradas no sistema e familiares desses pacientes;
2. médicos responsáveis por avaliar e tratar os pacientes
3. profissionais de enfermagem que coordenam as consultas com os médicos e administram alguns tratamentos;
4. recepcionistas que marcam as consultas dos pacientes;
5. equipe de TI responsável pela instalação e manutenção do sistema.
6. um gestor de ética médica que deve assegurar que o sistema satisfaz as diretrizes éticas atuais de cuidados com os pacientes;
7. gestores de cuidados com a saúde que obtêm informações gerenciais do sistema;
8. o pessoal de controle do prontuário responsável por garantir que as informações do sistema possam ser mantidas e preservadas e que os procedimentos de manutenção de registros tenham sido adequadamente implementados.

A  engenharia de requisitos, tem se mostrado como a primeira etapa do processo de engenharia de software.

> Estudo de viabilidade:
> O estudo de viabilidade é um estudo curto e focalizado que deve ser feito no início do processo de ER. Ele deve responder três perguntas fundamentais:
> 1. O sistema contribui para os objetivos globais da organização?
> 2. O sistema pode ser implementado dentro do cronograma e orçamento usando a tecnologia atual?
> 3. O sistema pode ser integrado com outros sistemas utilizados?
> Se a resposta a qualquer uma dessas perguntas for não, provavelmente não se deve prosseguir com o projeto.

## 4.1 Requisitos Funcionais e Não Funcionais
Os requisitos de sistema de software são classificados frequentemente em:
1. *Requisitos funcionais:* são declarações dos <span style="background:#fff88f">serviços que o sistema deve fornecer</span>, do modo como o sistema deve reagir a determinadas entradas e de como deve se comportar em determinadas situações. Em alguns casos, os requisitos funcionais também podem declarar explicitamente o que o sistema não deve fazer.
2. *Requisitos não funcionais:* são restrições sobre os serviços ou funções oferecidas pelo sistema. Eles incluem restrições de tempo, restrições sobre o processo de desenvolvimento e restrições impostas por padrões. Os requisitos não funcionais se aplicam, frequentemente, ao sistema como um todo, em vez às características individuais ou ao serviços. 