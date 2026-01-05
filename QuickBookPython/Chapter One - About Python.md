*This chapter covers*
- Why use Python?
- What Python does well?
- What Python is improving

This book is intended to help people get a solid general understanding of Python as quickly as possible, avoiding getting bogged down in advanced topics but covering the essentials to write and read Python code. In particular, this book is intended for people who are coming Python from other languages and for those who know a bit of Python but are looking to level up their skill as Python continues to gain popularity, particularly in areas like data science, machine learning, and the sciences. While no prior knowledge of Python is needed, some knowledge and experience with programming is necessary to get the most out of this book.

After introducing Python and offering some advice on getting started with a Python environment, the book provides a quick summary of Python's syntax, followed by chapters that build from the built-in data types up through creating functions, classes, and packages, as well as some more advanced features and a case study in handling data.

Com a ascensão das ferramentas de IA baseadas em modelos de linguagem de larga escala (LLMs), agora é possível gerar volumes crescentes de código utilizável, se (e este é um grande "se") tivermos conhecimento de programação o suficiente para guiar o processo de forma inteligente. Embora este livro não seja um tutorial sobre IA e seu uso na geração de código, os problemas de programação propostos ao fim de cada capítulo, começando pelo capítulo 5, trazem exemplos de respostas de IA para as mesmas questões, junto a uma breve discussão sobre o que a IA acertou (ou errou). Isso ajudará a construir uma compreensão de como utilizar ferramentas de IA para gerar códigos que realmente funcionem. 

*Como desenvolvedor Java,* podemos utilizar o #LangChain4j para integrar LLMs ao nosso ecossistema Spring Boot. Enquanto Python lidera em scripts de IA, o LangChain4j traz esse poder ao Java, permitindo criar aplicações corporativas robustas e inteligentes com facilidade. 

## 1.1 Why should I use Python?
Centenas de linguagens de programação estão disponíveis hoje, desde linguagens maduras como C e C++, passando por entradas mais recentes como Rust, Go e C#, até gigantes corporativos como Java e as mais voltadas para a web, como JavaScript e TypeScript. Essa abundância de escolhas torna difícil a decisão sobre qual linguagem de programação utilizar. Embora nenhuma linguagem seja a escolha certa para todas as situações possíveis, acredito que Python é uma boa escolha para um grande número de problemas de programação, sendo também uma ótima opção se estamos aprendendo a programar. Milhões de programadores ao redor do mundo usam Python, e esse número cresce a cada ano.

Python continua atraindo novos usuários por diversos motivos. É uma verdadeira linguagem multiplataforma, rodando igualmente bem em plataformas Windows, Linux/UNIX e iOS, assim como em outras, variando de supercomputadores a dispositivos móveis. Ela pode ser usada para desenvolver pequenas aplicações e protótipos rápidos, mas escala bem para permitir o desenvolvimento de programas. Ela vem com um kit de ferramentas de interface gráfica de usuário (GUI) poderoso e fácil de usar, bibliotecas de programação web e muito mais. Python também se tornou uma ferramenta vital para computação científica, ciência de dados, aprendizado de máquina e trabalhos com IA. E é gratuito. 

*Insight:* Python domina  inovação em IA, mas a integração com Java garante robustez corporativa. Arquiteturas poliglotas, utilizando ferramentas como TornadoVM para aceleração de hardware e execução heterogênea ou LangChain4j para orquestração, unem a flexibilidade da modelagem em Python à escalabilidade e segurança da JVM em produção. 

## 1.2 What Python does well
Python é uma linguagem de programação moderna desenvolvida por Guido van Rossum na década de 1990 (e nomeada em em homenagem a um famoso grupo de comédia). Embora Python não seja perfeito para todas as aplicações, seus pontos fortes o tornam  uma bola escolha para muitas situações, 

### 1.2.1 Python é fácil de usar
Programadores familiarizados com linguagens tradicionais acharão fácil aprender Python. Todas as construções familiares, loops, instruções condicionais arrays e assim por diante, estão incluídas, mas muitas são mais fáceis de usar em Python. Aqui estão algumas das razões:
- **Tipos são associados a objetos, não às variáveis:** uma variável pode receber um valor de qualquer tipo, e uma lista pode conter objetos de muitos tipos. Isso também significa que a conversão de tipos ( #type_casting) geralmente não é necessária e que o nosso código não fica preso na "camisa de força" dos tipos pré-declarados. Mas, embora os tipos não sejam exigidos para variáveis, o Python permite dicas de tipos (type hints) que possibilitam aos desenvolvedores verificar se o nosso código é consistente quanto ao tipo de objeto usado para parâmetros, valores de retorno, etc.; falaremos um pouco sobre dicas de tipo mais adiante.

- **O Python tipicamente opera em um nível de abstração muito mais alto.** Isso é, em parte, resultado da maneira como a linguagem é construída e, em parte, resultado de uma extensa biblioteca padrão de código que acompanha a distribuição Python. Um programa para baixar uma página web pode ser escrito em duas ou três linhas!

- **As regras de sintaxe são muito simples.** embora se tornar um Pythonista especialista leve tempo e esforço, mesmo iniciantes podem absorver sintaxe Python suficiente para escrever código útil rapidamente.

O Python é muito adequado para o desenvolvimento rápido de aplicações. Não é incomum que a codificação de uma aplicação em Python leve um quinto do tempo que levaria em C ou Java e ocupe apenas um quinto do número de linhas do programa equivalente em C. Isso depende da aplicação específica, é claro; para um algoritmo numérico realizando principalmente aritmética de inteiros em loops _for_, haveria muito menos ganho de produtividade. Para a aplicação média, o ganho de produtividade pode ser significativo.

> "Embora Python vença na velocidade de desenvolvimento (RAD), Java garante performance e tipagem estrita para o _backend_. Ao integrar **TornadoVM** para acelerar cálculos pesados (onde Python seria lento) e **LangChain4j** para IA no ecossistema Java, criamos arquiteturas híbridas que unem a facilidade sintática do Python à segurança e escalabilidade robusta da JVM."

### 1.2.2 Python é expressivo
Python é uma linguagem muito expressiva. Expressivo, neste contexto, significa que uma única linha de código Python pode fazer mais do que uma única linha de código na maioria das outras linguagens. As vantagens de uma linguagem mais expressiva são óbvias: quanto menos linhas de código tivermos que escrever, mais rápido podemos concluir um projeto. Quanto menos linhas de código existirem, mais fácil será manter e depurar o programa. 

Para se ter uma ideia de como a expressividade do Python pode simplificar o código, considere a troca *swapping* doas valores de duas variáveis, *var1* e *var2*. Em uma linguagem como Java, isso requer três linhas de código e uma variável extra:
```java
int temp = var1;
var1 = var2;
var2 = temp;
```

A variável *temp* é necessária para salvar o valor de *var1* quando *var2* é colocado nele, e então esse valor salvo é colocado em *var2*. O processo n]ao é terrivelmente complexo, mas ler essas três linhas e entender que uma troca ocorreu exige uma certa quantidade de esforço mental (overhead), mesmo para codificadores experientes.

Em contraste, o Python permite que façamos a mesma troca em uma linha e de uma maneira que torna óbvio que uma troca de valores ocorreu:
```python
var2, var1 = var1, var2
```
Claro, este é um exemplo muito simples, mas podemos encontrar as mesmas vantagens por toda a linguagem.

### 1.2.3 Python é legível
Outra vantagem do Python é que ele é fácil de ler. Podemos pensar que uma linguagem de programação precisa ser lida apenas por um computador, mas humanos também têm que ler seu código: quem depura seu código (muito possivelmente você), quem mantém o código (pode ser você novamente) e quem possa querer modificar o código no futuro. Em todas essas situações, quanto mais fácil for ler e entender o código, melhor. Quanto mais fácil for entender o código, mais fácil será depurar, manter e modificar.

A principal vantagem do Python neste departamento é o uso de indentação. Ao contrário da maioria das linguagens, o Python insiste que os blocos de código sejam indentados. Embora isso pareça estranho para algumas pessoas, tem o benefício de que o nosso código esteja sempre formatado em um estilo muito fácil de ler.

A seguir, dois programas curtos, um escrito em Pert e outro em Python. Ambos recebem duas listas de números de tamanho igual e retorna a soma par a par dessas listas. Acredito que o código Python é mais legível do que o código Per; é visualmente mais limpo e contém menos símbolos inescrutáveis:
# Versão Perl.
sub pairwise_sum {
    my($arg1, $arg2) = @_;
    my @result;
    for(0 .. $#$arg1) {
        push(@result, $arg1->[$_] + $arg2->[$_]);
    }
    return(\@result);
}

```python
def pairwise_sum(list1, list2):
	result = []
	for i in range(len(list1)):
		result.append(list1[i] + list2[i])
	return result
```

Ambos os trechos de código fazem a mesma coisa, mas o código Python vence em termos de legiilidade. (Existem outras maneiras de fazer isso em Perl, é claro, algumas das quais são muito mais concisas, mas na minha opinião, são mais difíceis de ler do que a mostrada).

*A expressividade do Python acelera a prototipagem de modelos de IA, mas a verbosidade do Java garante manutenção em sistemas de missão crítica. Utilize LangChain4j para integrar a clareza dos prompts Python com a tipagem segura do Java, e TornadoVM para otimizar loops complexos, unindo legibilidade no desenvolvimento com performance bruta na execução.*

### 1.2.4 Python é completo: "Baterias incluídas"
Outra vantagem do Python é sua filosofia de "baterias incluídas" quando se trata de bibliotecas. A ideia é que, ao instalar o Python, precisamos ter tudo o que é necessário para realizar um trabalho real sem a necessidade de instalar bibliotecas adicionais. É por isso que a biblioteca padrão do Python vem com módulos para lidar com e-mail, páginas da web, bancos de dados, chamadas de sistema operacional, desenvolvimento de GUI (interface gráfica) e muito mais.

Por exemplo, com Python, podemos escrever um servidor web para compartilhar os arquivos em um diretório com apenas duas linhas de código:
```python
import http.server
http.server.test(HandlerClass=http.server.SImpleHTTPRequestHandler)
```
Não há necessidade de instalar bibliotecas para lidar com conexões de rede e HTTP; isso já está no Python, pronto para uso (right out of the box).

### 1.2.5 Python possui um rico ecossistema de bibliotecas de terceiros
Embora o Python tenha "baterias incluídas", ainda existem muitas situações em que é necessário ir além de uma biblioteca padrão bem abastecida, uma tarefa especializada, um novo formato de dados, aplicações mais complexas e assim por diante. Aqui o Python realmente assumiu a vanguarda na última década. Em muitas áreas, desde aplicações web e APIs até manipulação e visualização de dados, passando por aprendizado de máquina, ciência de dados e muito mais, o Python possui um dos ecossistemas mais ricos de pacotes, bibliotecas e frameworks entre qualquer linguagem atual. É muito improvável que nos encontremos em uma situação onde não exista pacotes Python para atender às nossas necessidades.

### 1.2.6 Python é multiplataforma
Python também é uma excelente linguagem multiplataforma. Ele roda em muitas plataformas, incluindo Windows, Mac, Linux, UNIX e outras. Por ser interpretado, o mesmo código pode rodar em qualquer plataforma que tenha um interpretador Python, e quase todas as plataformas atuais possuem um. Existem até versões do Python que rodam sobre Java (Jython), .NET (IronPython) e microcontroladores (MicroPython e CircuitPython), oferecendo ainda mais plataformas possíveis para executar Python. 

### 1.2.7 Python é gratuito
O Python também é gratuito. O Python foi originalmente, e continua sendo, desenvolvido sob o modelo de código aberto (*open source*), e está disponível gratuitamente. Podemos baixar e instalar praticamente qualquer versão do Python e usá-la para desenvolver software para aplicações comerciais ou pessoais, e não precisamos pagar um centavo.

Embora as atitudes estejam mudando, algumas pessoas ainda ficam receosas com software gratuito devido a preocupações sobre a falta de suporte, temendo que tal software não tenha o peso de clientes pagantes. Mas o Python é usado por muitas empresas estabelecidas como uma parte fundamental de seus negócios; Google, Bloomberg, NVIDIA e Capital One são apenas alguns exemplos. Essas empresas e muitas outras conhecem o Python pelo o que ele é: um produto muito estável, confiável e bem suportado, com uma comunidade de usuários ativa e conhecedora. 

**Python e software de código aberto**
Não apenas o Python é gratuito, mas seu código-fonte também está livremente disponível, e somos livres para modificá-lo, melhorá-lo e estendê-lo se quisermos. Como o código fonte está disponível gratuitamente, nós temos a capacidade de entrar e alterá-lo (ou contratar alguém para entrar e fazer isso por nós). Raramente temos essa opção a qualquer custo razoável com software proprietário.

Se esta é sua primeira incursão no mundo do software de código aberto, você deve entender que não é apenas livre para usar e modificar o Python, mas também capaz (e encorajado) a contribuir com ele e melhorá-lo. Dependendo de suas circunstâncias, interesses e habilidades, essas contribuições podem ser financeiras, como em uma doação para a _Python Software Foundation_, ou podem envolver a participação em um dos grupos de interesse especial, testando e dando feedback sobre lançamentos do núcleo do Python ou de um dos módulos auxiliares, ou contribuindo com algo do que você ou sua empresa desenvolvem de volta para a comunidade. O nível de contribuição (se houver) depende, é claro, de você; mas se você for capaz de retribuir, definitivamente considere fazê-lo. Algo de valor significativo está sendo criado aqui, e você tem a oportunidade de agregar a isso.

O Python tem muita coisa a seu favor: expressividade, legibilidade, ricas bibliotecas incluídas e capacidades multiplataforma. Além disso, é código aberto. Qual é a pegadinha?

*Insight* A filosofia 'baterias incluídas' do Python acelera a inovação em IA, mas a JVM garante a estabilidade corporativa. Em vez de implementações legadas como Jython, arquiteturas modernas utilizam GraalVM ou orquestradores como **LangChain4j** para integrar a vasta biblioteca de Data Science do Python com a segurança, escalabilidade e tipagem robusta do ecossistema Java."

## 1.3 Em que o Python está melhorando
Embora Python tenha muitas vantagens, nenhuma linguagem pode fazer tudo, então Python não é a solução perfeita para todas as suas necessidades. Enquanto Python está melhorando em todas as áreas a seguir, para decidir se é a linguagem certa para a nossa situação, também precisamos considerar essas áreas onde o Python não se sai tão bem.

### 1.3.1 Python está ficando mais rápido
Uma possível desvantagem do Python é a sua velocidade de execução. Não é uma linguagem totalmente compilada. Em vez disso, disso é primeiramente compilada para uma forma interna de *bytecode*, que então é executada por um interpretador Python. Existem algumas tarefas, como análise de string usando expressões regulares, para as quais o Python possui implementações eficientes e é tão rápido quanto, ou mais rápido que, qualquer programa em C que escreveríamos. No entanto, na maioria das vezes, usar Python resulta em programas mais lentos do que em uma linguagem como C.

Mas devemos manter isso em perspectiva. Computadores modernos têm tanto poder de processamento que, para a vasta maioria das aplicações, a velocidade do programa não é tão importante quanto a velocidade do desenvolvimento, e programas em Python podem tipicamente ser escrito muito mais rapidamente do que outros. Além disso, é fácil estender o Python com módulos escritos em C ou C++, que podem ser usados para executar as partes do programa intensivas em CPU.

Os desenvolvedores do núcleo do Python também estão trabalhando arduamente criando novas versões que são mais eficientes, carregam e rodam mais rápido, e tiram melhor proveito de múltiplos núcleos de processador. Esse trabalho já gerou melhorias significativas de desempenho, e o trabalho continuará no futuro; portanto, se temos uma aplicação de desempenho crítico, podemos querer considerar cuidadosamente se o Python fará o trabalho, mas não o descarte imediatamente.

### 1.3.2 O Python não impõe tipos de variáveis em tempo de compilação
Ao contrário de algumas linguagens, as variáveis do Python não funcionam como contêineres; em vez disso, são mais como rótulos que se referem a vários objetos: inters, strings, instâncias de classes, o que for. Isso significa que, embora esses objetos em si tenham tipos, as variáveis que se referem a eles não estão vinculadas a esses tipos específicos. 

É possível (embora não desejável) usar a variável x para referir-se a uma string em uma linha e a um inteiro em outra (nota: a saída do código está em negrito):
```python
x = "2"
x
'2' # Saída de x é a string 's'
x = int(x)
x
2 # Saída de x agora é o inteiro 2.
```
O fato de o Python associar tipos a objetos e não a variáveis significa que o interpretador não ajuda a detectar incompatibilidades de tipos de variáveis. Se pretendermos que uma variável **count** armazena um inteiro, o Python não reclama se atribuir a string "dois" a ela. Codificadores tradicionais contam isso como uma desvantagem, porque perdemos uma verificação gratuita adicional em nosso código. 

Em resposta a essa preocupação, o Python adicionou sintaxe e ferramentas para permitir que codificadores especifiquem o tipo desejado do objeto ao qual uma variável se refere, bem como parâmetros de função, valores de retorno e afins. Com essas dicas de tipo (*type hints*), como são chamadas, várias ferramentas podem sinalizar quaisquer incosisências nos tipos de objetos antes do tempo de execução (runtime). Em programas menores, erros de tipo geralmente não são difíceis de encontrar e corrigir mesmo sem dicas de tipo e, em qualquer caso, os recursos de teste do Python tornam a prevenção de erros de tipo gerenciável. 

#### 1.3.3 Python está melhorando o suporte móvel

Na última década, os números e tipos de dispositivos móveis explodiram, e smartphones, tablets, phablets, Chromebooks e outros estão em toda parte, rodando em uma variedade de sistemas operacionais. O Python não é um jogador forte neste espaço, mas vários projetos estão trabalhando no problema, desenvolvendo kits de ferramentas e frameworks que permitem escrever aplicativos tanto para plataformas iOS quanto Android. Essa situação está melhorando, mas, até o momento desta escrita, usar Python para escrever e distribuir aplicativos móveis comerciais é um pouco trabalhoso.

#### 1.3.4 Python está melhorando o suporte a múltiplos processadores

Processadores de múltiplos núcleos (_multiple-core_) estão em toda parte agora, produzindo aumentos significativos de desempenho em muitas situações. No entanto, a implementação padrão do Python não foi projetada para usar múltiplos núcleos, devido a um recurso chamado Bloqueio Global do Interpretador (_Global Interpreter Lock_ - GIL). Como mencionado no contexto de velocidade, a equipe de desenvolvimento do Python está atualmente trabalhando em maneiras de fazer o Python funcionar de forma mais integrada e eficiente com múltiplos núcleos de processador, e o desenvolvimento do Python _multicore_ continuará nos próximos anos.

### Resumo

- Python é uma linguagem moderna de alto nível com tipagem dinâmica e sintaxe e semântica simples e consistentes.
    
- Python é multiplataforma, altamente modular e adequado tanto para desenvolvimento rápido quanto para programação em larga escala.
    
- É razoavelmente rápido e pode ser facilmente estendido com módulos C ou C++ para velocidades maiores.
    
- Python possui recursos avançados integrados, como armazenamento persistente de objetos, tabelas de hash avançadas, sintaxe de classe expansível e funções de comparação universal.
    
- Python inclui uma ampla gama de bibliotecas, como processamento numérico, manipulação de imagens, interfaces de usuário e _scripting_ web.
    
- É apoiado por uma comunidade dinâmica.

---
**Insight do Instrutor**: 
"As limitações do Python em _multithreading_ (GIL) e tipagem são superadas em arquiteturas robustas ao delegar o processamento pesado ao Java. Utilize **TornadoVM** para execução paralela em hardware heterogêneo (GPUs/FPGAs), ignorando o GIL, e **LangChain4j** para integrar a flexibilidade da IA do Python com a segurança e escalabilidade de tipos da JVM."

