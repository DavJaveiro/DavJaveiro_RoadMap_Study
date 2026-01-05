*This chapter covers*
- Surveying Python
- Using built-in data types
- Controlling program flow
- Creating modules
- Using object-oriented programming

O objetivo deste capítulo é dar a você uma noção básica da sintaxe, semântica, capacidades e filosofia da linguagem Python. Ele foi projetado para fornecer uma perspectiva inicial ou uma estrutura conceitual à qual você poderá adicionar detalhes conforme os encontrar ao longo do restante do livro.

Na primeira leitura, não é necessário se preocupar em trabalhar e compreender todos os detalhes dos trechos de código. Você estará indo bem se captar um pouco da ideia do que está sendo feito. Os capítulos seguintes o conduzirão pelos aspectos específicos desses recursos e não pressupõem conhecimento prévio. Você sempre poderá retornar a este capítulo e revisar os exemplos nas seções apropriadas como uma forma de revisão depois de ter lido os capítulos posteriores.

## 3.1 Python synopsis
O Python possui diversos tipos de dados embutidos, como inteiros, floats (pontos flutuantes), números complexos, strings, listas, tuplas, dicionários e objetos de arquivo. Esses tipos de dados podem ser manipulados usando operadores da linguagem, funções embutidas, funções de biblioteca ou os métodos próprios do tipo de dado.

Programadores também podem definir suas próprias classes e instanciar suas próprias instâncias de classe. Essas instâncias de classe podem ser manipuladas por métodos definidos pelo programador, bem como pelos operadores da linguagem e funções embutidas para os quais o programador definiu os atributos de métodos especiais apropriados. 

**NOTA:** a documentação do Python e este livro usam o termo "objeto" para se referir a instâncias de qualquer tipo de dado Python, não apenas ao que muitas outras linguagens chamariam de "instâncias de classe". Isso ocorre porque todos os objetos Python são instâncias de uma classe ou de outra.

O Python fornece fluxo de controle condicional e iterativo através de uma construção *if-elif-else*, juntamente com loops *while* e *for*, e um novo recurso de correspondência de padrões estruturais *match-case*. Ele permite a definição de funções com opções flexíveis de passagem de argumentos. Exceções (erros) podem ser levantadas usando a instrução raise, e podem ser capturadas e tratadas usando a construção *try-except-else-finally*.

Variáveis (ou identificadores) não precisam ser decladas e podem referenciar qualquer tipo de dado embutido, objeto definido pelo usuário, função ou módulo.

## 3.2 Tipos de dados embutidos
O Python possui vários tipos de dados embutidos, desde escalares, como números e Booleanos, até estruturas mais complexas, como listas, dicionários e arquivos.

**Nota:** Nos exemplos, o código está em fonte monoespaçada normal e a saída está em fonte **monoespaçada negrito**.

### 3.2.1 Números
Os quatro tipos numéricos do Python são inteiros, floats, números complexos e Booleanos:
- Inteiros - 1, -3, 42, 355, 888888888888, -7777777777777 (inteiros não limitados em tamanho, exceto pela memória disponível)
- Floats: 3.0, 31e12, -6e-4
- Números complexos: -3 + 2j, -4 -2j, 4.2 + 6.3j
- Booleanos: True, False.

Podemos manipulá-los usando os operadores aritméticos: + (adição), - (subtração), * (multiplicação), / (divisão), // (divisão com truncamento para inteiro), ** (exponenciação) e % (módulo).

**Exemplos que usam inteiros:**
```python
x = 5 + 2 - 3 * 2
5 / 2
5 // 2

```

A divisão de inteiros com / resulta em um float (Resultado float usando /), e a divisão de inteiros com // resulta em truncamento para um inteiro (Resultado forçado para inteiro usando //). Note que inteiros possuem tamanho ilimitado; eles crescem tanto quanto nós precisamos, limitados apenas pela memória disponível (Tamanho do inteiro limitado apenas pela memória disponível). Os exemplos a seguir trabalham com floats, que são baseados nos doubles em C:
```run-python
x = 4.3 ** 2.4
print(x)
```

```run-python
y = 3.5e30 * 2.77e45
print(y)
```

Números complexos consistem em um elemento real e um elemento imaginário, sufixados com j. 

Várias funções embutidas podem operar em números. Além disso, o módulo de biblioteca *cmath* contém funções para números complexos, e o módulo de biblioteca *math* contém funções para os outros três tipos:
```run-python
import math
round(3.49)
print(math.ceil(3.49))
```

Funções embutidas estão sempre disponíveis e são chamadas usando uma sintaxe padrão de chamada de função. No código anterior, *round* é chamada com um float como seu argumento de entrada. As funções em módulos de biblioteca são disponibilizadas via instrução import. No código anterior, o módulo de biblioteca *math* é importado, e sua função *ceil* é chamada usando a notação de atributo: modulo.funcao(argumentos)

*Insights*
O texto destaca que tudo em Python é objeto. Em frameworks como #PyTorch ou #TensorFlow, isso é levado ao extremo. Um modelo de IA não é apenas código, é uma instância de classe (nn.Modulo ou PyTorck) que mantém estado (pesos).

**Precisão Numérica e o Custo da Inferência**
- **Tipagem Dinâmica vs. Tensores:** o texto mostra inteiros de tamanho arbitrário e floats baseados em C doubles (64-bit). Em IA, isso é um anti-padrão de performance.
- **Float64 vs. BFloat16**: enquanto o Python puro usa alta precisão por padrão, LLMs modernos exigem tipos de dados menores para caber na VRAM da GPU. Trabalhar com *float64* (padrão do Python) em vez de **float16**, **bfloat16** ou **int8** (quantização) pode aumentar o uso de memória em 4x a 8x, inviabilizando a execução de modelos como Llama-3 ou GPT-4-local.

**Uso de Floats Nativos para Cálculos Pesados**
**Desatualizado:** o texto foca em operações escalares (x = 4.3 ** 2.4). Em 2025, ninguém treina ou executa inferência de IA usando loops e escalares nativos do Python devido à lentidão extrema (Global Interpreter Lock - GIL).
**Abordagem 2025:** o padrão da indústria é a **computação vetorizada** e **tensorial**. Bibliotecas como #NumPy, #PyTorch e #JAX deslocam o cálculo para C++/CUDA. Além disso, o uso de #float (64-bit) padrão é substituído por tipos de baixa precisão como *FP8* (Float 8-bit) ou NF4 (Normal Float 4-bit) para rodar LLMs em dispositivos de borda e reduzir custos de nuvem.

**Importação Simples de #math para IA**
Embora math seja útil para scripts simples, ele não suporta operações em GPU ou diferenciação automática (autograd), que são a base do treinamento de redes neurais.
**Abordagem 2025**: utilizar #torch ou #jax.numpy. Isso garante que nossos dados permaneçam na GPU, evitando gargalos de transferência de dados entre CPU e GPU.

**Tratamentos de Exceções Genérico**
**Por que desatualizado:** O texto menciona `try-except`. Em orquestração de LLMs (ex: LangChain ou AutoGen), erros de API (RateLimit, ContextWindowExceeded) exigem estratégias de **Backoff Exponencial** e **Retry** automatizados, não apenas um `try-except` simples. Bibliotecas como `tenacity` são o padrão de mercado para resiliência em chamadas de LLM.

### 3.2.2 Listas
O Python possui um tipo de lista embutido poderoso:
```py
[]
[1]
[1, 2, 3, 4, 5, 6, 7, 8, 12]
[1, "two", 3, 4.0, ["a", "b"], (5,6)]
```
Uma lista pode conter uma mistura de outros tipos como seus elementos, incluindo strings, tuplas, listas, dicionários, funções, objetos de arquivo e qualquer tipo de número. Uma lista pode ser indexada a partir do seu início ou fim. Também podemos referir a um subsegmento, ou fatia (slice), de uma lista usando a notação de fatiamento (*slice notation*):
```python
x = ["first", "second", "third", "fourth"]
x[0]
'first'
x[2]
'third'
x[-1]
'fourth'
x[-2]
'third'
x[1:-1]
['second', 'third']
x[0:3]
['first', 'second', 'third']
x[-2:-1]
['third']
x[:3]
['first', 'second', 'third']
x[-2:]
['third', 'fourth']
```
Listas podem ser acessadas por índice a partir da frente usando índices positivos (começando com 0 como o primeiro elemento). Indexam-se a partir de trás usando índices negativos (começando com -1 como o último elemento). Obtém-se uma fatia usando [m:n], onde m é o ponto de partida inclusivo e *n* é o ponto final exclusivo (veja a tabela 3.1). Uma fatia [:n] começa no início da lista, e uma fatia *[m:]* vai até o seu final.

**Tabela 3.1 índices de lista**: *x = ["first", "second", "third", "fourth"]*
- índices positivos: 0, 1, 2, 3
- índices negativos: -4, -3, -2, -1

Podemos usar essa notação para adicionar, remover e substituir elementos em uma lista, ou para obter um elemento ou uma nova lista que seja uma fatia dela:
```python
x = [1, 2, 3, 4, 5, 6, 7, 8, 9]
x[1] = "two"
x[8:9] = []
x
[1, 'two', 3, 4, 5, 6, 7, 8]
x[5:7] = [6.0, 6.5, 7.0]
x
[1, 'two', 3, 4, 5, 6.0, 6.5, 7.0, 8]
x[5:]
[6.0, 6.5, 7.0, 8]
```
O tamanho da lista aumenta ou diminui se a nova fatia for maior ou menos do que a fatia que está substituindo. 

Algumas funções embutidas (*len*, *max* e *min*), alguns operadores (*in*, + e * ), a instrução del e os métodos de lista (append, count, extend, index, insert, pop, remove, reverse e sort) operam em listas:
```python
x = [1, 2, 3, 4, 5, 6, 7, 8, 9]
len(x)
9
[-1, 0] + x
[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
x.reverse()
x
[9, 8, 7, 6, 5, 4, 3, 2, 1]
```

#reverse modifica a lista em memória e retorna None. Ou seja, y.reverse() inverte a lista, mas não retorna a lista invertida. Por isso z recebe None.

- **Pipeline de Dados:** em Deep Learning, raramente treinamos modelos diretamente com listas Python. No entanto, as listas são a estrutura fundamental de coleta e pré-processamento. Agregamos dados brutos (logs, textos, imagens) em listas antes de convertê-los em Tensores (torch.tensor ou numpy.array).

- **Heterogeneidade:** o testo mostra [1, "two", 3]. Isso é ótimo para flexibilidade, mas **péssimo para performance numérica**. Tensores exigem tipos homogêneos. Tentar converter essa lista mista para um tensor PyTorch resultará em erro ou coerção indesejada.

**O Poder do Slicing no Gerenciamento de Contexto**
**Janela Deslizante:** A notação `x[-N:]` (pegar os últimos N itens) é exatamente como implementamos **memória de curto prazo** em chatbots.
- _Cenário:_ Um LLM tem um limite de 4096 tokens. O histórico da conversa está numa lista.
    
- _Aplicação:_ `history = full_conversation[-10:]` mantém apenas as últimas 10 trocas de mensagens para enviar ao modelo, economizando tokens e dinheiro.

- **Chunking de Texto:** Para RAG (Retrieval-Augmented Generation), precisamos dividir textos longos em pedaços. O _slicing_ é a base lógica para algoritmos que "fatiam" documentos em trechos menores para indexação vetorial.

**Concatenação com `+` em Loops**

- **Por que desatualizado:** Usar `+` para adicionar itens (`lista = lista + [novo_item]`) cria uma nova lista na memória a cada iteração. Isso tem complexidade quadrática de tempo.
    
- **Abordagem 2025:** Use `lista.append()` (que é amortizado O(1)) ou, melhor ainda, **List Comprehensions** (`[x for x in dados]`). Para operações numéricas, use broadcasting de Tensores, nunca concatenação de listas em loop.

**3. Ordenação Manual**

- **Por que desatualizado:** O texto menciona `sort`. Em aplicações de RAG (Busca Vetorial), raramente ordenamos listas manualmente.
- **Abordagem 2025:** A ordenação é feita por **similaridade de cosseno** diretamente no banco de dados vetorial (como Pinecone, Weaviate ou FAISS). Recebemos a lista já ordenada ("Top-K results") da API, em vez de processar a ordenação bruta no Python.

