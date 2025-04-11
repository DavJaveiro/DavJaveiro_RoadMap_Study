**Objetivos**
O objetivo deste capítulo é apresentá-lo aos métodos de desenvolvimento ágil de software. Ao ler este capítulo, vamos:
- Compreender a lógica dos métodos de desenvolvimento ágil de software, o manifesto ágil e as diferenças entre o desenvolvimento ágil e o dirigido por plano;
- conhecer as práticas importantes do desenvolvimento ágil, como as histórias do usuário, e a refatoração, a programação em pares e o desenvolvimento com testes a *priori (test-first)*;
- compreenderá desde a abordagem Scrum até o gerenciamento ágil de projetos;
- compreenderemos as questões de escalabilidade dos métodos de desenvolvimento ágil e a combinação das abordagens ágeis com as dirigidas por plano no desenvolvimento de grande sistemas de software.

**Conteúdo**
- [ ] 3.1 Métodos ágeis
- [ ] 3.2 Técnicas de desenvolvimento ágil
- [ ] 3.3 Gerenciamento ágil de projetos
- [ ] 3.4 Escalabilidade dos métodos ágeis


As empresas agora operam em um ambiente global e em constante mudança. Elas precisam responder a novas oportunidades e mercados, condições econômicas mutáveis e o surgimento de produtos e serviços concorrentes. O software é parte essencial de quase todas as operações comerciais, <span style="background:#b1ffff">então novos softwares precisam ser desenvolvidos rapidamente para aproveitar novas oportunidades e responder à pressão competitiva</span>. Portanto, o desenvolvimento e entrega rápidos de software são os requisitos mais críticos para a maioria dos sistemas empresariais.
De fato, as empresas podem estar dispostas a abrir mão da qualidade do software e até mesmo comprometer os requisitos se puderem implantar rapidamente um novo software essencial.

Como essas empresas operam em um ambiente em mudança, é praticamente impossível derivar um conjunto completo de requisitos estáveis. Os requisitos mudam porque os clientes acham difícil prever como um sistema afetará práticas de trabalho, como ele interagirá com outros sistemas e quais operações dos usuários devem ser automatizadas.  Pode ser apenas após a entrega de um sistema e depois que os usuários ganharem experiência com ele que os requisitos reais se tornam claros. E mesmo assim, fatores externos continuam impulsionando mudanças nos requisitos.

Processos de desenvolvimento de software orientados por planos, que especificam completamente os requisitos antes de projetar, construir e testar um sistema, <span style="background:#affad1">não são adequados para o desenvolvimento rápido de software</span>. À medida que os requisitos mudam os problemas nos requisitos são descobertos, o design ou a implementação do sistema precisa ser retrabalhada e retestada. Como consequência, um processo convencional baseado no modelo cascata (waterfall) ou em especificações tende a ser demorado, e o software final é entregue ao cliente muito tempo depois de sua especificação inicial.

Para alguns tipos de software, como sistemas de controle críticos para segurança, onde uma análise completa do sistema é essencial, essa abordagem orientada por planos é a mais adequada. No entanto, em um ambiente empresarial dinâmico, ela 