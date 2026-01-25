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

### 3.2.3 Tuplas
#Tuplas são semelhantes a listas, mas são imutáveis, ou seja, não podem ser modificadas após terem sido criadas.  Os operadores (in, + e * ) e as funções embutidas (len, max e min) operam nelas da mesma maneira que fazem listas, pois nenhum deles modifica o original. As anotações de índice e fatiamento funcionam da mesma maneira para obter elementos ou fatias, mas não podem ser usadas para adicionar, remover ou substituir elementos. Além disso, existem apenas dois métodos de tupla: *count* e index. Um propósito importante das tuplas é o uso como chaves para dicionários. Elas também são mais eficientes de usar quando não precisamos de modificabilidade:
```python
()
(1,)
(1, 2, 3, 4, 5, 6, 7, 8, 12)
(1, "two", 3, 4.0, ["a", "b"], (5, 6))
```
Uma tupla de um elemento precisa de uma vírgula. Uma tupla, assim como uma lista, pode conter uma mistura de outros tipos como seus elementos, incluindo strings, tuplas, listas, dicionários, funções, objetos de arquivo e qualquer tipo de número.

Uma lista pode ser convertida em uma tupla usando a função embutida #tuple
```run-python
x = [1, 2, 3, 4]
tuple(x)
print(x)
```

Inversamente, uma tupla pode ser convertida em uma lista usando a função embutida #list:
```python
x = (1, 2, 3, 4)
list(x)
[1, 2, 3, 4]
```

### 3.2.4 Strings
O processamento de strings é um dos pontos fortes do Python. Existem muitas opções para delimitar strings:
```python
"Uma string em aspas duplas pode conter caracteres de 'aspas simples'."
'Uma string em aspas simples pode conter caracteres de "aspas duplas".'
'''\tUma string que começa com um tab; termina com um caractere de nova linha.\n'''
"""Está é uma string de aspas triplas duplas - strings de apas triplas (simples ou duplas) são o único tipo que pode conter novas linhas reais."""
```

Strings podem ser delimitadas por aspas simples (' '), duplas (" "), triplas simples (''' ''') ou triplas (""" """) e podem conter caracteres de tabulação (\t) e nova linha (\n).

Strings também são imutáveis. Os operadores e funções que funcionam com elas retornam novas strings derivadas da original. Os operadores (in, + e * ) e as funções embutidas (len, max e min) operam em strings assim como fazem em listas e tuplas. A notação de índice e fatiamento funciona da mesma maneira para obter elementos ou fatias, mas não pode ser usada para adicionar, remover ou substituir elementos.

Comparação em Java: A classe String é **imutável por definição**, também.
```java
String s = "Java";
s = s.toUpperCase();
```

- "Java" continua existindo
- "JAVA" é uma nova string
- s apenas passa a referenciar o novo objeto

**Métodos de String sempre retornam novas strings**
**Exemplos clássicos**
```java
String s = "programador";

String a = s.toUpperCase();
String b = s.replace("a", "o");
String c = s.substring(0, 5);
```

Portanto, a comparação direta com Python, verificamos a mesma situação presente.


---
Strings possuem vários métodos para trabalhar com seu conteúdo, e o módulo de biblioteca *re* também contém funções para trabalhar com strings:
```run-python
x = "live and let \t \tlive"
x.split()
print(x)
['live', 'and', 'let, 'live']
x.replace("let \t \tlive", "enjoy life")
'live and enjoy life'
import re
regexpr = re.compile(r"[\t ]+")
regexpr.sub(" ", x)
'lives and let live'
```

#Split dividi uma string em várias substrings. Ele quebra uma string em parte, usando um separador (delimitador), e retorna uma coleção dessas partes, sem alterar a string original.

Em Java:
```java
String[] partes = texto.split(delimitador);

```
O #Split retorna um **array de String**.


O módulo #re fornece funcionalidade de expressões regulares. Ele oferece capacidades de extração e substituição de padrões mais sofisticados do que o módulo string.

A função #print exibe strings na saída. Outros tipos de dados Python podem ser facilmente convertidos para strings e formatados:
```python
e = 2.718
x = [1, "two", 3, 4.0, ["a", "b"], (5, 6)]
print("A constante e é:", e, "e a lista x é:", x)
```
Objetos são automaticamente convertidos para representação de string para impressão. O operador % fornece capacidade de formatação semelhante à do *sprintf* em C.

**Insights valiosos**
**Tuplas: Segurança e Configuração de Modelos**
- **Imutabilidade como Garantia:** Em *pipelines* de dados complexos (ex: PyTorch DataLoader), usamos tuplas para garantir que certos metadados ou configurações de hiperparâmetros não sejam alterados acidentalmente durante o treinamento. Se fosse uma lista, um bug poderia alterar o *learning rate* no meio do processo sem aviso.
- **Chaves de Cache (Memoization)**: como tuplas são "hashable" (por serem imutáveis), elas podem ser chaves de dicionário. Isso é crucial para sistemas de #caching. Exemplo: `cache[(model_name, prompt_id)] = response`. Não podemos fazer isso com listas. 
- **Unpacking de Retorno:** a maioria das bibliotecas de IA retorna tuplas.
	- Ex: `loss, logits = model(**inputs)` no Hugging Face Transformers. Entender o unpacking de tuplas é vital para escrever loops de treinamentos limpos.

**Strings: A Matéria-Prima dos LLMs**

- **Prompt Engineering é Manipulação de String:** A construção de prompts nada mais é do que injeção de strings em templates. O uso de **f-strings** (`f"Contexto: {contexto}. Pergunta: {pergunta}"`) é o padrão ouro para construir prompts dinâmicos, sendo mais performático e legível que concatenação.
- **Limpeza (Sanitization) vs. Tokenização:** O exemplo de `re.sub` e `replace` ilustra a etapa de _pré-tokenização_. Antes de enviar texto para o GPT-4 ou Llama-3, precisamos limpar caracteres invisíveis (`\t`, espaços duplos) que "comem" tokens valiosos e podem confundir a atenção do modelo.
- **Regex na Extração de Respostas:** Quando pedimos a um LLM para gerar código ou JSON, ele frequentemente coloca texto extra em volta ("Aqui está seu código..."). Expressões regulares (`re`) são fundamentais para extrair apenas o bloco de código ou o objeto JSON da resposta bruta do modelo antes de processá-lo na aplicação.

### 3.2.5 Dicionários
O tipo de dado embutido dicionário do Python fornece funcionalidade de array associativo implementada usando tabelas hash. A função embutida #len retorna o número de pares chave-valor em um dicionário. A instrução #del pode ser usada para excluir um par chave-valor. Assim como no caso das listas, vários métodos de dicionário (clear, copy, get, items, keys, update e values) estão disponíveis:
```python
x = {1: "one", 2: "two"}
x["first"] = "one"
x[("Delorme", "Ryan", 1995)] = (1, 2, 3)
list(x.keys())
[1, 2, 'first', ('Delorme', 'Ryan', 1995)]
x[1]
'one'
x.get(1, "not available")
'one'
x.get(4, "note available")
'not available'
```
As chaves devem ser de um tipo imutável, incluindo números, strings e tuplas. Os valores podem ser qualquer tipo de objeto, incluindo tipos mutáveis, como listas e dicionários. Se tentarmos acessar o valor de uma chave que não está no dicionário, uma exceção `KeyError` é levantada. Para evitar esse erro, o método de dicionário #get retorna opcionalmente um valor definível pelo usuário quando uma chave não está no dicionário.

### 3.2.6 Sets (Conjuntos), frozensets
Um conjunto #set em Python é uma coleção não ordenada de objetos, usada em situações onde a pertinência e a unicidade no conjunto são as principais coisas que precisamos saber sobre aquele objeto. Conjuntos se comportam como coleções de chaves de dicionário sem quaisquer valores associados:
```python
x = set([1, 2, 3, 1, 3, 5])
x
{1, 2, 3, 5}
1 in x
True
4 in x
False
```
Podemos criar um conjunto usando #set em uma sequência, como uma lista. <span style="background:#ff4d4f">Quando uma sequência é transformada em um conjunto, as duplicatas são removidas</span>. A plavra-chave #in é usada para verificar a pertinência de um objeto em um conjunto.

Um #frozenset é um conjunto que é imutável. Isso significa que após o conjunto ter sido criado com código como `x = frozenset([1, 2, 3, 1, 3, 5])`, ele não pode ser alterado, portanto nenhum elemento pode ser adicionado ou removido.

#Set em Java e Python
- Ambos não permitem elementos duplicados
- Não mantêm ordem (por padrão)
- Operações rápidas (O(1) médio para add, remove e contains)
- Baseados em **tabela hash**

**Outras implementações equivalentes em Java**
set - Python | HashSet Não ordenado
set (ordem de inserção a partir do Python 3.7) | **LinkedHashSet** mantém ordem de inserção

set + sorted() | TreeSet Ordenado automaticamente

### 3.2.7 Objetos de arquivo
Um arquivo é acessado através de um objeto de arquivo Python:
```python
f = open("myfile", "w")
f.write("First line with necessary newline character\n")
44
f.write("Second line to write to the file\n")
33
f.close()
f = open("myfile", "r")
line1 = f.readline()
line2 = f.readline()

```

Esse código cria (ou sobrescreve) um arquivo de texto e escreve uma linha dentro dele.

`f = open("myfile", "w")`
Abre (ou cria) o arquivo *myfile*
Modo *w* (write)

O modo write "w" permite escrita e apaga todo o conteúdo anterior, se o arquivo existir. Se o arquivo não existir ele escreve em cima.

`f.write("First line with necessary newline character\n")`

Escreve o texto no arquivo. O \n é o caractere de nova linha. O conteúdo ficará assim no arquivo:
`First line with necessary newline character`

Write() não pula linha automaticamente, por isso, o \n é necessário.

A instrução #open cria um objeto de arquivo. Aqui, o arquivo #myfile no diretório de trabalho atual está sendo aberto em modo de escrita "w". Após escrever duas linhas nele e fechá-lo, você abre o mesmo arquivo novamente, desta vez em modo de leitura ("r"). O módulo *os* fornece várias funções para navegar pelo sistema de arquivos e trabalhar com os nomes de caminho de arquivos e diretórios. Aqui, se nos movermos para outro diretório. Mas ao referirmos ao arquivo por um nome de caminho absoluto, ainda somos capazes de acessá-lo. 

Várias outras capacidades de entrada/saída estão disponíveis. Como veremos mais tarde, podemos usar a função #input para solicitar e obter uma string do usuário. O módulo de biblioteca #sys permite acesso a #stdin, #stdout e #stderr. O módulo de biblioteca #struct fornece suporte para leitura e escrita de arquivos que foram gerados por, ou devem ser usados por, programas em C. O módulo de biblioteca #Pickle entrega persistência de dados através da capacidade de facilmente ler e escrever os tipos de dados Python de e para arquivos.

Toda interação com APIs de LLM (OpenAI, Anthropic) trafega dados em formato JSON, que o Python converte para dicionários. Saber manipular dicionários aninhados (dict[str, Any]) é a habilidade número 1 de um Engenheiro de IA Backend.

## Type hints in Python
Ao contrário de muitas linguagens de programação, o Python, por design, não utiliza #type variables, nem typed return values. Embora isso torne a linguagem mais flexível e legível, significa que, em muitos casos, o **type** de um objeto referenciado por uma variável, ou exigido como um **parameter**, ou retornado por uma **function** ou **method**, nem sempre é imediatamente óbvio. Embora misturar inadvertidamente tipos de objetos incompatíveis causem uma **runtime exception** em Python, isso não gera um erro em tempo de compilação. Particularmente em projetos grandes, há muitas situações em que ter os types dos objetos disponíveis de forma mais explícita seria útil. Para isso, o Python adicionou #type-hints.

Com isso, podemos indicar explicitamente os tipos de dados das variáveis e dos retornos de funções. Diferente de outras linguagens de programação, Python não obriga o uso de type hints (dicas de tipos), mas eles podem ser extremamente úteis para guiar quem está lendo o código.

```python
x: int = 10
y: float = 5.5
nome: str = 'Juliano'
```

Para funções, podemos indicar tanto o tipo dos parâmetros quanto o tipo do retorno:
```python
def somar(a: int, b: int) -> int: return a + b
```
A notação de **type hinting** pode ser lida por ferramentas de **type-checking** como *mypy*, *pyright*, *pyre* ou *pytype*, assim como por várias IDEs comuns, para sinalizar o uso de um **incompatible** ou **unexpected type**. Embora essas ferramentas possam reportar o erro, o próprio Python não lança um **runtime error** caso os types hints não sejam seguidos.

## 3.7 Entrada de dados

### 3.7.1 Conversão da entrada de dados
A função #input sempre retorna valores do tipo string, ou seja, não importa se digitamos números, o resultado sempre será do tipo string. Para resolver esse pequeno problema, vamos utilizar a função *int* para converter o valor retornado em um número inteiro, e a função #float para convertê-lo em um número decimal ou de ponto flutuante. Vejamos outro exemplo usando essas funções:
```run-python
anos = int(input("Anos de serviço: "))
valor_por_ano = float(input("Valor por ano: "))
bonus = anos * valor_por_ano
print(f"Bônus de R$ {bonus:5.2f}")
print(anos)
```

> Exercício 3.7: Faça um programa que peça dois números inteiros. Imprima a soma desses dois números na tela.

