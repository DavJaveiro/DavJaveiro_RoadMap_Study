**Conceitos em Computação em Nuvem**
A computação em nuvem refere-se ao uso de recursos computacionais, como armazenamento, processamento de dados e redes, que são fornecidos pela Internet. A ideia principal é fornecer acesso a recursos de computação sob demanda pela Internet, <font color="#d99694">em vez de depender de recursos locais ou de servidores físicos</font>. 

Alguns benefícios do real compreendimento da computação em nuvem:
- **Escalabilidade e elasticidade**: permite escalar recursos de computação de acordo com as necessidades, evitando a necessidade de investir em hardware adicional.
- **Custo-eficiência:** elimina a necessidade de investir em infraestrutura física, reduzindo custos iniciais e permitindo que as organizações paguem apenas pelos recursos que consomem.
- **Acessibilidade remota:** facilita o acesso a recursos computacionais de qualquer lugar com conexão à internet, promovendo a flexibilidade e o trabalho remoto.
- **Inovação rápida:** permite o rápido desenvolvimento, teste e implantação de aplicativos, acelerando os ciclos de inovação e reduzindo o tempo de chegada ao mercado.

A computação em nuvem oferece oportunidades para otimizar operações, impulsionar a inovação e fornecer soluções eficientes. É fundamental que os profissionais estejam familiarizadas com os conceitos e práticas relacionadas à nuvem para tirar o máximo proveito desses benefícios.


O conceito de nuvem é uma metáfora para um cenário no qual as aplicações podem ser acessadas remotamente, de qualquer lugar e dispositivo com conexão à Internet. O paradigma de computação em nuvem revolucionou a maneira como as organizações alocam e gerenciam recursos de Tecnologia da Informação.

Nesse novo modelo, recursos computacionais, como capacidade de processamento e armazenamento de dados  disponíveis em provedores, podem ser alocados sob demanda, com pagamento de acordo com a quantidade e o tempo de uso. A possibilidade de redução de custos e flexibilidade no uso dos recursos de TI motivaram uma rápida migração de servidores e aplicações para provedores de computação em nuvem.

A computação em nuvem dispensa o conhecimento ou controle direto sobre a infraestrutura subjacente.

Observe que os recursos computacionais disponíveis na nuvem podem ser os mais diversos e a alocação ou liberação dos recursos deve ser dinâmica. Isso foi possível, principalmente, em decorrência dos avanços nas tecnologias de virtualização e de redes. O conceito de virtualização permite que, em um mesmo computador, sejam criadas uma ou mais máquinas virtuais. Uma máquina virtual é um software que emula o funcionamento de um computador, ou seja, ela é capaz de executar programas como um computador real emulando, inclusive os componentes de uma máquina física, como disco, processador, monitor e placa de rede.

![image-2025101393131.png](Computa%C3%A7%C3%A3o%20em%20Nuvem/Anhanguera/Aula%201%20-%20Conceitos%20B%C3%A1sicos%20em%20Computa%C3%A7%C3%A3o%20em%20Nuvem/image-2025101393131.png)
A figura cima ilustra um provedor de serviços de computação com diversas máquinas virtuais (VMs - virtual machines) instanciadas na infraestrutura de máquinas físicas. O uso de virtualização permite o compartilhamento da infraestrutura entre vários clientes e também viabiliza a alocação dinâmica. Não seria possível instanciar rapidamente um servidor físico, mas isso pode ser realizado instantaneamente para uma máquina virtual. 

Um serviço de utilidade, *Utility Computing* é aquele distribuído amplamente ao público geral com pagamento baseado no uso, por exemplo, a distribuição de energia elétrica e outros serviços de utilidade pública. Esses serviços abrangem vários níveis, desde aplicações para usuários finais, até grandes infraestruturas computacionais para empresas.

Existem vários modelos de serviço na computação em nuvem, sendo os três principais:
- **Infraestrutura como Serviço:** IaaS, fornece acesso virtualizado a recursos de hardware, como capacidade de processamento, armazenamento e redes. Os usuários podem controlar e gerenciar sistemas operacionais, aplicativos e, em alguns casos, configurações de rede.
- **Plataforma como Serviço (PaaS):** oferece uma plataforma de desenvolvimento completa, na qual os desenvolvedores podem criar, implantar e gerenciar aplicativos sem se preocupar com a infraestrutura subjacente, essa abordagem simplifica o processo de desenvolvimento.
- **Software como Serviço (SaaS):** fornece aplicativos baseados na web que são acessados por meio de um navegador da web. Os usuários não precisam se preocupar com a manutenção, atualização ou gerenciamento do software, já que isso é tratado pelo provedor de serviços em nuvem.

**Principais características da computação em nuvem**
Os serviços em nuvem podem ser acessados e gerenciados por uma aplicação web. No entanto, não podemos afirmar que toda aplicação disponível na Web é uma aplicação em nuvem. Algumas das vantagens:
- **Self-service:** o próprio cliente gerencia a alocação dos recursos, com a mínima interação com o provedor, na verdade, a alocação e uso dos serviços pode ser automatizada. 
- **Amplo acesso:** os recursos podem ser acessados remotamente, de qualquer lugar, por meio de tecnologias baseadas em padrões abertos, consequentemente, têm soluções multiplataforma, ou seja, soluções que não dependem do tipo do dispositivo ou sistema operacional.
- **Pooling de recursos**: o provedor mantém um robusto conjunto de recursos que são compartilhados entre os clientes, de forma que a localização e a manutenção dos equipamentos é transparente para os clientes.
- **Elasticidade:** os clientes podem alocar mais recursos diante de um aumento de demanda ou liberar recursos em uso no caso de diminuição da demanda; a alocação ou liberação de recursos deve ser feita rapidamente, inclusive de forma automatizada, por exemplo, por meio de um script que monitora a demanda e reage de acordo com as mudanças.
- **Serviço medido:** o uso de recursos pelos clientes é detalhadamente contabilizado para fins de tarifação e também para monitoramento da qualidade do serviço.

A elasticidade é uma das principais características dos serviços disponibilizados em ambiente de computação em nuvem. Essa característica cria a ilusão de que os recursos na nuvem são ilimitados, uma vez que é possível aumentar ou diminuir a quantidade de recursos sob demanda.

A elasticidade rápida depende das tecnologias de virtualização. Por exemplo, devido a um aumento brusco nas requisições a um serviço, diversas máquinas virtuais podem ser rapidamente instanciadas para atender ao aumento na carga de trabalho. Essa facilidade de alterar dinamicamente a quantidade de recursos alocados facilita o planejamento de capacidade computacional para o cliente, o que representa um dos principais benefícios que fomentaram o rápido desenvolvimento de soluções de computação em nuvem. Além disso, existe uma série de outros benefícios, entre os quais pode-se destacar a **redução de custos** e a **abstração da complexidade**.  

A redução de custos pode ser observada de várias formas. Uma delas é que o uso de recursos computacionais na nuvem sob demanda evita a necessidade do investimento inicial para montar toda a infraestrutura de TI. A flexibilidade da alocação dinâmica de recursos permite que os investimentos em TI sejam realizados de acordo com o crescimento do negócio do cliente. Os **componentes de software e hardware ficam obsoletos rapidamente**, quando um cliente acessa os recursos na forma de serviço em nuvem, os custos de atualização ficam por conta do provedor. 

**Desafios da computação em nuvem**
- **Segurança:** a segurança dos dados ainda é uma preocupação significativa. Embora os provedores de nuvem invistam em medidas de segurança robustas, os usuários também têm a responsabilidade de implementar práticas adequadas de segurança.
- **Disponibilidade e confiabilidade:** a dependência de serviços em nuvem significa que a disponibilidade está fora do controle direto da organização. Interrupções nos serviços do provedor podem impactar as operações dos usuários.
- **Privacidade e conformidade:** em alguns casos, regulamentações e requisitos de conformidade podem restringir o armazenamento e o processamento de dados em nuvem. Garantir a conformidade é crucial, especialmente em setores altamente regulamentados.
- **Interação de sistemas:** migrar sistemas existentes para a nuvem e garantir uma integração eficiente pode ser um desafio. A interoperabilidade entre sistemas locais e serviços em nuvem pode exigir esforço adicional.
- **Latência e desempenho:** dependendo da localização dos centros de dados do provedor de nuvem, pode haver latência na comunicação.
- **Gestão de custos:** embora a nuvem ofereça eficiência de custos, a gestão adequada dos custos pode ser desafiadora. Sem monitoramento cuidado, os custos podem aumentar à medida que os recursos são consumidos.
- **Dependência de fornecedores:** as organizações que dependem exclusivamente de um provedor de nuvem pode enfrentar desafios em termos de flexibilidade e portabilidade. Evitar um bloqueio de fornecedor é uma consideração importante.