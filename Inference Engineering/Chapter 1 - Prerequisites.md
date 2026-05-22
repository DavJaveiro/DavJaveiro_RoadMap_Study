## Prefácio
Inference é a categoria mais valiosa na indústria de AI.

A *inference engineering*, por outro lado, ainda está em sua infância. Os *inference engineers* atuam em toda a stack, do CUDA ao Kubernetes, em busca de um serving mais rápido, econômico e confiável para  generative AI models em production.

Em 30 de novembro de 2022, dia do lançamento do ChatGPT, havia talvez algumas centenas de inference engineers no mundo, embora eles não se identificassem com esse nome na época. Esses especialistas trabalhavam majoritariamente em frontier labs como OpenAI, Midjourney e Anthropic, ou em big techs como Google e NVIDIA.

Naquela época, parecia que esse poderia ser o destino da indústria de AI. Talvez o training de generative AI models fosse tão difícil e custoso que apenas um punhado de empresas desenvolveria <span style="background:#d3f8b6">closed models e</span>, consequentemente, demandaria inference engineering para o serving em production. Nesse futuro alternativo, o resto do mundo seria mero consumidor de AI via APIs, alugando inteligência um token por vez.

Três anos depois, ficou claro que o training de generative AI models é difícil. É caro, mas não é tão difícil nem tão caro a ponto de ficar restrito a esse seleto grupo de players.

Em vez disso, um Cambrian Explosion de open models, mais de dois milhões e crescendo no Hugging Face, significa que todo engineer pode agora fazer deploy de sua própria intelligence para impulsionar seus AI products. Research labs ao redor do mundo, da OpenAI e da NVIDIA Nemotron na América à Mistral AI e à Black Forest Labs na Europa, passando pela Alibaba Qwen, DeepSeek AI, Z AI e Moonshot AI na China, lançam regularmente open models de todas as modalities.


!![image-2026514561805.png](/image-2026514561805.png)

Apesar de os closed models estarem ficando mais inteligentes e baratos, o movimento em direção aos open models está acelerando. Opens models diferem na disponibilidade de seus weights:
- **Closed model:** um modelo proprietário cujos eights não estão disponíveis ao público como GPT-5 ou Claude Sonnet.
- **Open model:** um modelo cujos weights estão publicamente disponíveis, como Llama ou DeepSeek, geralmente sob a licença MIT ou uma licença permissiva similar (embora alguns modelos restrinjam o uso comercial - sempre confira os termos da license).

Até dezembro de 2024, havia uma lacuna significativa de intelligence entre closed e open models. Quando o DeepSeek V3 e o R1 foram lançados, essa gap desapareceu.

Hoje, novos closed models são equiparados por open models em questão de meses, senão semanas, com ocasionais open models como o Kimi K2 Thinking chegando até a superar as capacidades dos closed models por breves períodos.

Mesmo que os open models estejam constantemente perseguindo os closed models em benchmarks, eles ainda alteram a equação para os AI product builders. À medida que ambos os tipos de model evoluem, closed e open models atravessam capability thresholds e habilitam novas classes de products.

Em 2022, era impossível construir os tipos de AI-native products que definem a indústria hoje.

Com o tempo, os closed models ficaram mais inteligentes e novas categorias, como costumer service voice agentes e AI-powered- IDEs, tornaram-se viáveis. Esses primeiros models eram lentos, caros e pouco confiáveis, mas as capabilities estavam lá, e os AI engineers começaram a construir empresas em torno dessas capacidades.

À medida que os open models atravessaram os mesmos capability thresholds, esses product builders começaram a usá-los para substituir os closed models. Muitos também passaram a fazer fine-tuning em open models para cruzar capability thresholds mais rapidamente e até superar a qualidade dos closed models para seu produto e domínio específicos. 

**Figura:** migrar para open models debloqueia a oportunidade de usar inference engineering para tornar os models que impulsionam AI products melhores em novas dimensões:
- **Latency:** APIs de closed models são construídas para throughput, mas open models podem ser otimizados para aplicações em real-time.
- **Availability**: enquanto as APIs de GPT e Claude estão limitadas a dois noves de uptime, é possível alcançar quatro noves ou mais com dedicated deployments de open models.
- **Cost:** Open Models frequentemente custam pelo menos 80% menos em scale.
Assim, onde há três anos pareceria que a inference engineering poderia ser um campo de nicho, hoje toda empresa que visa construir AI Producits verdadeiramente diferenciados e competitivos precisa de uma inference strategy.

Startups AI-native como Cursor, Clay, Gamma e Mercor estão redefinindo o hypergrowth ao construir products que dependem de open e in-house models.

Empresas digital native líderes como Notion e Superhuman estão prosperando ao integrar profundamente AI capabilities em products que centenas de milhões já amam. 

E uma nova geração de times blended de research e engineering - World Labs, Writer, Mirage e dezenas de outros, estão construindo negócios enormes ao treinar e productizar seus próprios foundation models.

A adoção é forte até mesmo em enterprise e indústrias reguladas, que historicamente têm sido lentas para se adaptar a novas tecnologias. Empresas como OpenEvidence, Abridge e Ambience estão tornando o generative AI ubíquo na healthcare, enquanto nas maiores empresas do mundo, AI initiatives estão ultrapassando a fase de pilot e avançando para adoção massiva de users.

Tive a incrível sorte de ter um assento na primeira fila para o mercado que mais se move na história nos últimos quatro anos...

A demanda incrível por inference em todo o mercado significa que todos, de developers a executives, têm a oportunidade de aprender inference engineering e usá-la para alavancar sua career e business.

---
#inference é o momento em que um modelo de machine learning ou AI "usa" o conhecimento que aprendeu durante o **training** para fazer previsões, gerar respostas ou tomar decisões com base em novos dados de entrada.

**Training vs. Inference: A Diferença Fundamental**

|**Training**|**Inference**|
|---|---|
|O modelo **aprende** padrões a partir de um dataset grande|O modelo **aplica** o que aprendeu a novos inputs|
|Consome muito tempo, computação e energia|Precisa ser rápido, eficiente e escalável|
|Acontece uma vez (ou periodicamente)|Acontece milhares/milhões de vezes por segundo em production|
|Exemplo: "Ler todos os livros do mundo para aprender a escrever"|Exemplo: "Escrever um e-mail sob demanda para um usuário"|

> 💡 **Analogia**: Pense no **training** como estudar para uma prova, e na **inference** como fazer a prova de verdade, respondendo às perguntas que aparecem.

