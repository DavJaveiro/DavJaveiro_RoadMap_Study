O projeto Spring AI tem como objetivo simplificar o desenvolvimento de aplicações que incorporam funcionalidades de inteligência artificial, sem adicionar complexidade desnecessária.

A iniciativa se inspira em projetos Python consagrados, como **LangChain** e **LlamaIndex**, mas o Spring AI não é uma simples adaptação *port* desses frameworks. O projeto foi criado com a convicção de que a próxima onda de aplicações de IA Generativa não será restrita a desenvolvedores Python, mas tornará #ubíqua, abrangendo diversas linguagens de programação. 

> Observação: O Spring AI aborda o desafio fundamental da integração da IA: *Connecting our enterprise Data and APIs with AI Models.*

!![image-20264214340183.png](/image-20264214340183.png)

O <span style="background:#fff88f">Spring AI</span> fornece <span style="background:#d3f8b6">abstrações que servem como base para o desenvolvimento</span> de aplicações de IA. Essas <span style="background:#fff88f">abstrações</span> possuem <span style="background:#d3f8b6">múltiplas implementações</span>, permitindo a fácil troca de componentes com alterações mínimas no código.

O Spring AI oferece os seguintes recursos:
- Suporte a APIs portáteis em diversos provedores de IA para modelos de bate-papo, conversão de texto em imagem e incorporação. Opções de API síncrona e de streaming são suportadas. O acesso a recursos específicos  do modelo também está disponível.
- Suporte para todos os principais **fornecedores de modelos de IA,** como Anthropic, OpenAI, Microsoft, Amazon, Google e Ollama. Os tipos de modelos suportados incluem:
- <span style="background:#d2cbff">Conclusão de bate-papo</span> - Chat Completion
- Embedding
- Text to Image
- Audio Transcription
- Text to Speech
- Moderation
- Saídas Estruturadas - Mapeamento de saída do modelo de IA para POJOs.
- Suporte para todos os principais **provedores de banco de dados vetoriais**, como Apache Cassandra, Azure Cosmos DB, Azure Vector Search, Chroma, Elasticsearch, GemFire, MariaDB, Milvus, MongoDB Atlas, Neo4j, OpenSearch, Oracle, PostgreSQL/PGVector, Pinecone, Qdrant, Redis, SAP Hana, Typesense e Weaviate.
- API portátil para todos os provedores do Vector Store, incluindo uma nova API de filtro de metadados semelhantes a SQL.
- Chamada de ferramentas/funções, permite que o modelo solicite a execução de ferramentas e funções do lado do cliente, acessando assim as informações necessárias em tempo real conforme requerido e executando as ações necessárias.
- Observabilidade - Fornece informações sobre operações em Engenharia de Dados.
- Framework ETL para ingestão de documentos em Engenharia de Dados.
- Avaliação de Modelos de IA - ferramenta para ajudar a avaliar o conteúdo gerado e proteger contra respostas alucinatórias.
- Configuração automática e modelos iniciais do Spring Boot para modelos de IA e armazenamento de vetores.
- API ChatClient - API fluente para comunicação com modelos de bate-papo com IA, semelhante em termos de idioma às APIs WebClient e RestClient.
- API Advisors - encapsula padrões recorrentes de IA generativa, transforma dados enviados de e para Modelos de Linguagens LLMs e fornece portabilidade entre vários modelos e casos de uso.
- Suporte para Geração Aumentada de Memória e Recuperação de Conversas em Chat (RAG).

Este conjunto de funcionalidades permite implementar casos de uso comuns, como "Perguntas e respostas sobre a sua documentação" ou "Bate-papo com a sua documentação".

A [seção de conceitos](https://docs.spring.io/spring-ai/reference/concepts.html) fornece uma visão geral de alto nível dos conceitos de IA e sua representação no Spring AI.

A seção [Introdução](https://docs.spring.io/spring-ai/reference/getting-started.html) mostra como criar seu primeiro aplicativo de IA. As seções subsequentes exploram cada componente e casos de uso comuns com uma abordagem focada em código.