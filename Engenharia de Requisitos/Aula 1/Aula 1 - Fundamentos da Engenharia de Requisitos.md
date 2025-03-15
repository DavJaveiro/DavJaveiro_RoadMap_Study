A engenharia de requisitos é um processo que se concentra, basicamente, em avaliar se o sistema é útil para o negócio (estudo de #viabilidade), descobrir requisitos (elicitação e análise), converter esses requisitos em algum formato padrão (especificação) e verificar se os requisitos definem o sistema que o cliente deseja (validação).

## Introdução
Vamos iniciar definindo Engenharia de Requisitos. Engenharia de Requisitos é o ramo da Engenharia de Software preocupado com o objetivo do mundo real para as funções e restrições dos sistemas. 

## Compreensão de Requisitos de Software
Os requisitos envolvem a coleta (obtenção) de quais serviços devem ser fornecidos pelo sistema. Concentra-se, basicamente, em avaliar se o sistema é útil para o negócio.

Na prática, a Engenharia de Requisitos não é um processo sequencial, e sim interativo, no qual as atividades são intercaladas. Por exemplo, iteramos, primeiro, nos requisitos do usuário; elicitação, especificação e validação, e repete as mesmas etapas para os requisitos do sistema.

No início do processo, a maior parte do esforço será consumido na compreensão dos <span style="background:#d4b106">requisitos de negócios</span> e do usuário de alto nível. Mais tarde, mais esforços serão gastos na elicitação e compreensão dos requisitos detalhados do sistema.

## Requisitos do usuário e do sistema
Normalmente, os requisitos são apresentados em dois níveis de talhes:
- **Requisitos do usuário:** descreve os serviços que o sistema deve fornecer e a restrições sob as quais deve operar. Não esperamos ver nenhum nível de detalhe, ou o que exatamente o sistema fará, são mais requisitos genéricos. Geralmente, é escrito em linguagem natural e fornecido por diagramas. 
- **Requisitos do sistema:** significam uma descrição mais detalhada dos serviços do sistema e das restrições operacionais, como o sistema será usado e as restrições de desenvolvimento, como as linguagens de programação. Este nível de detalhe é necessário para aqueles que estão envolvidos no desenvolvimento do sistema, como engenheiros, arquitetos de sistemas, testados etc.

Vamos utilizar o sistema de Biblioteca Online, bem básico. 
Os requisitos do usuário descrevem o que o sistema deve permitir ao usuários fazer, sem entrar nos detalhes técnicos. São requisitos mais genéricos e intuitivos, escritos de forma simples.

- Exemplo de Requisitos do Usuário:
1. O sistema deve permitir que os usuários procurem livros pelo título, autor e gênero;
2. Os usuários devem poder visualizar detalhes dos livros, como autor, sinopse e disponibilidade;
3. O sistema deve possibilitar que usuário façam login para reservar livros.
4. Os administradores devem poder adicionar, editar e remover livros do catálogo.
5. O sistema deve operar 24 horas por dia, 7 dias por semana.

Podemos elaborar um digrama de Caso de Uso (<span style="background:#d4b106">Modelagem de Negócio, capítulo 2 Livro Análise e design orientados a objetos para sistemas de informação</span>).

Nesta etapa, não falamos como esses requisitos serão implementados, apenas o que o sistema deve fornecer. 