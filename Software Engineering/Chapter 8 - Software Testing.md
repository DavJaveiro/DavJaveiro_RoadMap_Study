**Objetivos**
 O objetivo deste capítulo é apresentar o teste de software e os processos de teste de software. Depois de ler o capítulo, seremos capazes de:
 - Compreender os estágios do teste, desde o teste durante o desenvolvimento até o teste de aceitação pelos clientes do sistema;
 - Terá sido apresentado a técnicas que ajudam a escolher casos de teste voltados para a descoberta de defeitos do programa;
 - Compreenderá o desenvolvimento de teste em primeiro lugar, em que projetamos testes antes de escrever o código e executa esses testes automaticamente;
 - Conhecerá três tipos distintos de testes - testes de componentes, teste de sistema e teste de versão;
 - Compreenderá as distinções entre testes de desenvolvimento e teste de usuário.

**Contents**
8.1 Development testing
8.2 Test-driven development
8.3 Release testing
8.4 User testing

Testes de software têm como objetivo demonstrar que um programa faz aquilo para o qual foi projeto e identificar defeitos antes que seja colocado em uso. Ao testar um sistema, você o executa com dados artificiais e verifica os resultados em busca de erros, anomalias ou informações sobre atributos não funcionais do programa.

Testar software significa perseguir dois objetivos principais:
1. **Demonstrar conformidade com os requisitos.**
	- Para software sob encomenda, deve existir ao menos um teste para cada requisito especificado no documento de requisitos;
	- Para produtos genéricos, é necessário haver testes para todas as funcionalidades incluídas na versão de lançamento;
	- Também é recomendável testar combinações de funcionalidades para identificar interações indesejadas entre elas.
2. **Detectar comportamentos incorretos ou indesejáveis**
	- Isso envolve encontrar entradas ou sequências de entradas que provoquem resultados que não estejam de acordo com a especificação.
	- Esses problemas decorrem de defeitos (bugs) no software.
	- O objetivo é eliminar comportamentos indesejados, como falhas de sistema, interações inesperadas com outros sistemas, cálculos incorretos e corrupção de dados.

O primeiro deles é o **teste de validação**, em que se espera que o sistema funcione corretamente usando um conjunto de casos de teste que refletem o uso esperado do sistema. O segundo e o **teste de defeitos**, em que os casos de teste são projetados para expor falhas. Os casos de teste no teste de defeitos podem ser deliberadamente obscuros e não precisam refletir como o sistema é normalmente usado. É claro que não há uma fronteira definida entre essas duas abordagens de teste. Durante o teste de validação, encontraremos defeitos no sistema; durante o teste de defeitos, alguns testes mostrarão que o programa atende aos seus requisitos. A Figura 8.1 mostra as diferenças entre testes de **validação** e teste de **defeitos**. 

Pense no sistema sendo testado como uma caixa-preta. O sistema aceita entradas de um conjunto de entrada **I** e gera saídas em um conjunto de saída **O**. Algumas das saídas serão errôneas. Estas são as saídas no conjunto Oe, que são geradas pelo sistema em respostas às entradas no conjunto Ie. A prioridade no teste de defeitos é encontrar essas entradas no conjunto Ie, porque elas revelam problemas no sistema. O teste de validação envolve testar com entradas corretas que estão fora de Ie. Essas estimulam o sistema a gerar as saídas corretas esperadas.

Os testes não podem demonstrar que o software está livre de defeitos ou que ele se comportará conforme especificado em todas as circunstâncias. É sempre possível que um teste que tenhamos possa descobrir outros problemas no sistema. Como Edsger Dijkstra, um dos primeiros contribuintes para o desenvolvimento da Engenharia de Software, declarou eloquentemente (Dijkstra 1972):

"*O teste só pode mostrar a presença de erros, não sua ausência.*"

O teste faz parte de um processo mais amplo de verificação e validação de software (V&V). Verificação e validação não são a mesma coisa, embora sejam frequentemente confundidas. Barry Boehm, pioneiro da engenharia de software, expressou de forma sucinta a diferença entre elas (Boehm 1979):
!![image-2026323451697.png](/image-2026323451697.png)
Os processos de verificação e validação estão preocupados em verificar se o software que está sendo desenvolvido atende às suas especificações e oferece a funcionalidade esperada pelas pessoas que estão pelo software. Esses processos de verificação começam assim que os requisitos se tornam disponíveis e continuam em todos os estágios do processo de desenvolvimento.

A **verificação de software** é o processo de verificar se o software atende aos requisitos funcionais e não funcionais declarados. A validação é um processo mais geral. O objetivo da validação de software é garantir que o software atenda às expectativas do cliente. Ela vai além da verificação da conformidade com a especificação para demonstrar que o software faz o que o cliente espera que ele faça. A validação é essencial porque, conforme discutido no Capítulo 4, as declarações de requisitos nem sempre refletem os desejos ou as necessidades reais dos clientes e usuários do sistema. 

1. **Propósito do Software:**
Quanto mais crítico for o software, mais importante é que ele seja confiável. Por exemplo, o nível de confiança exigido para um software usado para controlar um **sistema crítico de segurança** é muito maior do que aquele exigido para um **sistema demonstrador** que serve para prototipar novas ideias de produtos.

2. **Expectativas dos usuários**
Devido às experiências anteriores com softwares cheios de erros e pouco confiáveis, os usuários às vezes têm **baixas expectativas quanto à qualidade do software.** Eles não ficam surpresos quando o software falha. Quando um novo sistema é instalado, os usuários  podem ter falhas, porque os benefícios de usar o sistema superam os custos de recupera-se dessas falhas. No entanto, à medida que um produto de software se torna mais estabelecido, os usuários esperam que ele se torne **mais confiável**. Consequentemente, pode ser necessário realizar testes mais completos nas versões posteriores do sistema. 

3. **Ambiente de mercado**
Quando uma empresa de software lança um sistema no mercado, ela precisa levar em consideração **os produtos concorrentes, o preço que os clientes estão dispostos a pagar pelo sistema e o prazo necessário para entregá-lo.**

Em um ambiente competitivo, a empresa pode decidir lançar um programa antes que ele tenha sido totalmente testado e depurado, porque deseja ser a primeira a entrar no mercado. 

Se um produto de software ou aplicativo for **muito barato**, os usuários podem estar dispostos a tolerar um nível menor de confiabilidade. 