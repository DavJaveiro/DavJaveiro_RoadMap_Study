Cada dado que podemos guardar em uma variável tem um tipo, seja numérico (inteiros, ponto flutuante), literal (strings), lógico etc. Uma variável precisa ter um tipo, pois o computador armazena cada tipo de dados de uma forma diferente na memória. Quando o Python acessa uma variável, o tipo da variável é verificado para saber como recuperar seu conteúdo na memória. 

Ao criamos uma variável pela primeira vez, Python verifica o que estamos querendo guardar nessa variável para criá-la com o tipo correto. Vejamos primeiro como dar nomes às nossas variáveis e depois veremos os principais tipos de dados e as operações que podemos fazer com estes dados.

## 3.1 Nomes de variáveis
Em Python, os nomes de variáveis devem iniciar obrigatoriamente com uma letra ou com um sublinhado (_ ). Após o primeiro caractere, podem conter letras, números e o underline. 

A versão 3 da linguagem Python permite a utilização de acentos em nomes de variáveis, pois, por padrão, os programas são interpretados utilizando-se um conjunto de caracteres chamado UTF-8, capaz de representar praticamente todas as letras dos alfabetos conhecidos.

Exemplos:
a1
velocidade
velocidade90
salário_médio - O símbolo underline é permitido e facilita a leitura de nomes grandes. Acentos são aceitos sem problemas.
salário médio (não permitido)
1a - nomes de variáveis não podem começar com números.

As variáveis também possuem tipo, definindo a natureza dos dados que uma variável armazena. 

## 3.2 Variáveis Numéricas
Python possui outros tipos de dados numéricos para representar números complexos (tipo **complex**, módulo **cmath**), ponto fixo ( #Decimal) e mesmo frações ( #Fraction).

#Fraction representa número racionais exatos, ou seja, números escritos na forma de **fração (numerador/denominador)**, sem erro de arredondamento.

Por qual motivo podemos usar **Fraction**?
Os números *float* possum erro de precisão:

Fraction(numerador, denominador)

Devemos usar #Fraction quando precisarmos de:
- Cálculos matemáticos exatos
- Álgebra simbólica simples
- Ensino de Matemática
- Sistemas financeiros simples
- Problemas envolvendo proporções

Não utilizamos a vírgula como separador de milhar. Exemplo: 1.000.000 (um milhão) é escrito 100000 ou 1_000_000 (uma forma alternativa de separar números grandes é utilizar o sublinha entre os dígitos, a partir do Python 3.6).

1_000 # mil
1_000_000
1_980.10 # Pode ser combinado com ponto

A representação de R$3.500,93
3500.93 ou 3_500.93

Portanto, de forma resumida, devemos usar o ponto para separar os decimais e (opcionalmente) o _ para separar os milhares.

## 3.2.1 Representação de valores numéricos
O sistema binário segue a mesma lógica do decimal:
número 1010 =
1 x 2³+ 1 x 2² + 1 x 2^0 = 10
Tem 1 na posição do 8 e tem 1 na posição do 2, 8 + 2 = 10

A utilização do sistema binário é transparente em Python, ou seja, se não solicitarmos explicitamente que esse sistema seja usado, tudo será apresentado na base 10 utilizada no dia a dia. A noção de diferença de base é importante, pois ela explica os limites da representação. O limite de representação é o valor mínimo e máximo que pode ser representado em uma variável numérica. Esse limite é causado pela quantidade de dígitos que foram reservados para armazenar o número em questão. Vejamos como funciona na base 10:

Se temos apenas 5 dígitos para representar um número, o maior número será 99999 e o menor seria -99999. O mesmo princípio é utilizado no sistema binário, sendo que lá reservamos um dígito para registrar os sinais de positivo e negativo.

Em números inteiros, Python utiliza um sistema de precisão ilimitada que permite a representação de números grandes. É como se sempre pudéssemos escrever novos dígitos à medida que for necessário. 

A versão 3.12 do Python, com relação a pontos flutuantes, tem como limites 2.2250738585072014 x 10^-308 e 2.2250738585072014 x 10^308 .

## 3.3 Variáveis do tipo lógico
