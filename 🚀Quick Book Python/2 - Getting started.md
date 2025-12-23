*This chapter covers*
- Available Python options
- Getting started with Colaboraty
- Accessubg tge GitHub repository for this book
- Writing a simple program and handling erros
- Using the *help()* and *dir()* functions
- AI tools for generating Python code

## 2.5 Using AI tools to write Python code
A ascensão de ferramentas baseadas em modelos de linguagem de grande porte, como ChatGPT, Copilot e muitas outras, está começando a revolucionar a forma como escrevemos software. Agora é possível que essas ferramentas gerem código funcional em resposta a um prompt de texto. Note, porém, que embora isso seja possível, ainda não é sempre confiável. Acreditamos que a compreensão humana ainda é o ingrediente vital para um bom código, mas que a experiência de usar ferramentas de IA para gerar código será cada vez mais útil no futuro, não temos dúvida.

### 2.5.1 Benefícios das ferramentas de IA
É inegável que a geração de código por IA se desenvolveu a ponto de apresentar várias vantagens. Primeiro, é rápida. Mesmo blocos relativamente grandes de código podem ser gerados em menos de um minuto, então, mesmo que gastemos algum tempo elaborando e inserindo um bom prompt para o chatbot trabalhar, a quantidade total de tempo necessária par obter uma boa parte de código é definitivamente menor do que o que até uma pessoa rápida e sabiá conseguiria.

Segundo, o código tende a estar livre de todos os pequenos erros que nós humanos cometemos ao digitar — um chatbot provavelmente vai escrever corretamente, usar a pontuação corretamente, etc. Mas — e este é um “mas” significativo — existem algumas desvantagens a considerar.

### 2.5.2 Desvantagens do uso de ferramentas de IA
Uma coisa a considerar é que os bots de IA usam muitos recursos. Nesta era de preocupação com o clima e o meio ambiente, muitos estarão preocupados com o consumo de recursos (particularmente energia e água) das máquinas por trás dessas ferramentas de programação. Só se pode esperar que os desenvolvimentos futuros reduzam esse consumo a níveis sustentáveis.

Em segundo lugar, usar um bot de IA para programar significa que, por definição, você está compartilhando seu código e utilizando o código de outros, e os mecanismos mais comuns para esse compartilhamento são frágeis em termos de proteção da privacidade e da propriedade intelectual.

Em terceiro lugar, nem todos os geradores de código por IA são gratuitos, e à medida que as empresas decidem recuperar os custos dos recursos consumidos por suas máquinas, é provável que menos deles permaneçam sem cobrança para usuários básicos.

Por fim, embora o código produzido seja surpreendentemente bom, está longe de ser perfeito. Os bugs e ineficiências no código gerado por IA nem sempre são óbvios e podem exigir um olhar treinado para serem identificados. Colocar código gerado por IA em produção sem uma revisão e testes cuidadosos é tão perigoso quanto usar, sem crítica, o código de um desenvolvedor júnior.

Embora nenhuma dessas desvantagens seja decisiva, todas são pontos que organizações e desenvolvedores responsáveis precisam considerar antes de decidir usar código gerado por IA.

O gerador de código de IA mais conveniente é o oferecido no #Colaboraty, que atualmente é gratuito para a maioria dos usuários. Para comparação, também discutiremos soluções geradas pelo **GitHub Copilot**, que funciona melhor com o IDE **VSCode da Microsoft** e uma versão local do **Python**. O Copilot também exige uma assinatura mensal de **US$ 10** no momento em que este texto foi escrito. Considerando que você precisa instalar o Python e o VSCode em sua máquina e pagar a assinatura, pode não valer a pena para os exemplos e problemas de código apresentados neste livro.

Há também outras opções, como o **Codeium**, que oferece uma camada gratuita e funciona melhor com o VSCode do que com o Colaboratory. Pessoalmente, se eu estivesse escrevendo código de produção, preferiria o Copilot, mas qualquer uma dessas ferramentas pode ser usada para experimentação, e o uso de uma ferramenta de IA é totalmente opcional — todos os resultados que obtive estão compartilhados no texto e nos notebooks de origem.