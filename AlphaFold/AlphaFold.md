Existem diferentes maneiras de acessar e executar o AlphaFold:
- **Através de interfaces web como o ColabFold:** o #ColabFold oferece uma maneira fácil de usar o AlphaFold2, geralmente executado no Google Colab, que utiliza GPUs para acelerar a previsão. Normalmente, precisamos colar a sequência da proteína em um campo de entrada no notebook Colab. O ColabFold também utiliza ferramentas como <span style="background:#d4b106">MMseqs2 para gerar alinhamentos de sequências múltiplas (MSAs), que são cruciais para a precisão do AlphaFold2</span>. (INVESTIGAR)
- **Utilizando o código open-source do AlphaFold2:** para usuários com recursos de computação adequados (principalmente GPUs), é possível baixar a executar o código AlphaFold2 diretamente. 
- **Bancos de dados de estruturas pré-computadas:** antes de executar uma previsão, vale a pena verificar bancos de dados como o AlphaFold Protein Structure Database, que contém estruturas 3D pré-computadas para muitas proteínas conhecidas. Se a estrutura da proteína H6V8J2 já estiver disponível, podemos simplesmente baixar.

Ao utilizar o AlphaFold2, a qualidade da previsão depende em grande parte da qualidade do alinhamento de sequências múltiplas (MSA) gerado. Um MSA mais profundo, com muitas sequências semelhantes, geralmente leva a uma melhor previsão. O AlphaFold2 gera saídas que incluem as estruturas previstas (geralmente vários modelos), métricas de confiança como pLDDT (que indica a confiança local por resíduo) e PAE (erro alinhado previsto, que indica a confiança global e a relação espacial entre diferentes partes da proteína). Essas métricas são importantes para avaliar a qualidade da previsão.

## Advanced settings
### **model_type**: define qual a versão ou tipo de modelo AlphaFold será usado na predição estrutural. O valor padrão é *auto*:
- <span style="background:#fff88f">Se fornecemos uma sequência única (monômero)</span>, o sistema usará o **alphafold2_ptm** que é o modelo padrão do AlphaFold2 com previsão de distâncias e confiança (pTM).
- Se fornecemos múltiplas cadeias (complexo/multímero), ele usará: o **alphafold2_multimer_v3**, versão ajustada do AlphaFold para predição de interações entre proteínas.
 🧬 Tipos de `model_type` que você pode escolher manualmente:
Mesmo que a entrada seja um monômero ou multímero, você pode **forçar o uso de qualquer modelo**, como por exemplo:

| `model_type`             | Uso principal                      | Observações                                          |
| ------------------------ | ---------------------------------- | ---------------------------------------------------- |
| `alphafold2`             | Monômeros simples                  | Versão padrão original                               |
| `alphafold2_ptm`         | Monômeros com **previsão de pTM**  | Mais útil para avaliação de confiança estrutural     |
| `alphafold2_multimer`    | Complexos proteicos                | Versão inicial para multímeros                       |
| `alphafold2_multimer_v2` | Complexos com melhorias            | Mais estável que v1                                  |
| `alphafold2_multimer_v3` | Complexos com melhorias adicionais | Versão mais recente e precisa para múltiplas cadeias |
**Quando escolher manualmente?**
- Se estivermos avaliando mutações em um monômero, **alphafold2_ptm** é ideal.
- Se estivermos tentando forçar predição de interações fracas entre proteínas, **alphafold2_multimer_V3** pode ser melhor, mesmo com apenas 2 sequências.
- Se quisermos controle fino sobre tempo/memória, podemos querer evitar versões multimer por serem mais pesadas.



## 🧬 O que é `num_recycles`?
No AlphaFold, **num_recycles** define quantas vezes a rede neural refina a estrutura prevista. Esse processo é chamado de reciclagem (recycling), o modelo faz uma predição da estrutura e depois realimenta essa predição como entrada para iterar e melhorar.

O **recycle** é como um artista que faz o primeiro rascunho de uma escultura, olha o resultado, corrige, refina... e repete isso várias vezes. Quando mais reciclagens (num_recycles), **mais polida e confiável tende a ser a estrutura final**, mas também mais lento e pesado para a máquina.

Complexos proteicos exigem **mais reciclagem** para convergirem bem. A predição da interface entre cadeias é mais difícil e precisa de mais refinamento.

 ⏱️ Impacto em performance

| `num_recycles` | Qualidade | Tempo  | Memória |
| -------------- | --------- | ------ | ------- |
| 1–3            | Média     | Rápido | Leve    |
| 6–12           | Boa       | Médio  | Médio   |
| 20+            | Alta      | Lento  | Pesado  |

### 🔄 O que é `recycle_early_stop_tolerance` no AlphaFold?
Esse parâmetro serve para **interromper precocemente (early stopping)** o processo de reciclagem (num_recycles), se a estrutura prevista parar de melhorar significativamente de um ciclo para o outro.

**Como funciona?**
Durante os recycles, o AlphaFold avalia quanto a estrutura atual mudou em relação à anterior. Se a diferença for menor que um certo limiar (tolerância), ele entende que não está mais valendo a pena continuar reciclando e para antes de chegar no **num_recycles** máximo.

## AlphaFold 3
https://blog.google/technology/ai/google-deepmind-isomorphic-alphafold-3-ai-model/#life-molecules

AlphaFold 3 prevê a estrutura e as interações de todas as moléculas da vida.

Dentro de cada célula vegetal, animal e humana, existem bilhões de máquinas moleculares. Elas são compostas de proteínas, DNA e outras moléculas, mas nenhuma delas funciona sozinha. Somente observando como elas interagem entre si, através de milhões de tipos de combinações, podemos começar a entender verdadeiramente os processos da vida. 

Para as interações de proteínas com outros tipos de moléculas, observamos uma melhoria de pelo menos 50% em comparação com os métodos de previsão existentes e, para algumas categorias importantes de interação, dobramos a precisão da previsão.

## Como o AlphaFold 3 revela as moléculas da vida
Dada uma lista de moléculas, O AlphaFold 3 gera uma estrutura 3D conjunta, revelando como todas se encaixam. Ele modela grandes biomoléculas, como proteínas, DNA e RNA, bem como moléculas pequenas, também conhecidas como ligantes (uma categoria que abrange muitos fármacos). Além disso, o AlphaFold 3 pode modelar modificações químicas nessas moléculas, que controlam o funcionamento saudável das células, que, quando interrompidas, podem levar a doenças.

Os recursos do AlphaFold 3 vêm de sua arquitetura de última geração e do treinamento que agora abrange todas as moléculas da vida. No centro do modelo está uma versão aprimorada do nosso módulo Evoformer, uma arquitetura de aprendizado profundo que sustentou o incrível desempenho do AlphaFold 2. Após processar as entradas, o AlphaFold 3 monta suas previsões usando uma rede de difusão, semelhante às encontradas em geradores de imagens de IA. O processo de difusão começa com um nuvem de átomos e, ao longo de várias etapas, converge para sua estrutura molecular final e mais precisa.

As previsões de interações moleculares do AlphaFold 3 superam a precisão de todos os sistemas existentes. 

## Liderando a descoberta de medicamentos na Isomorphic Labs
O AlphaFold 3 cria recursos para design de medicamentos com previsões para moléculas comumente usadas em medicamentos, como ligantes e anticorpos, que se ligam a proteínas para mudar a maneira como elas interagem na saúde e nas doenças humanas.

O AlphaFold 3 alcança precisão sem precedente na previsão de interações semelhantes a medicamentos, incluindo a ligação de proteínas com ligantes e de anticorpos com suas proteínas-alvo. O AlphaFold 3 é 50% mais preciso do que os melhores métodos tradicionais, sem a necessidade de inserir nenhuma informação estrutural, tornando o AlphaFold 3 o primeiro sistema de IA a superar ferramentas baseas em física para previsão de estrutura biomolecular. A capacidade de prever a ligação anticorpo-proteína é fundamental para a compreensão de aspectos da resposta imune humana e o desenvolvimento de novos anticorpos - uma classe crescente de fármacos terapêuticos.

O recém-lançado [AlphaFold Server](http://alphafoldserver.com/) do Google DeepMind é a ferramenta mais precisa do mundo para prever como as proteínas interagem com outras moléculas na célula.  uma plataforma gratuita que cientistas do mundo todo podem usar para pesquisas não comerciais. Com apenas alguns cliques, biólogos podem aproveitar o poder do AlphaFold 3 para modelar estruturas compostas por proteínas, DNA, RNA e uma seleção de ligantes, íons e modificações químicas.

