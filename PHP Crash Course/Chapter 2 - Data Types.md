In this chapter, we'll explore the data types avaible in PHP. We'll also consider how to force a value into a specifed data type (*type casting*), as well situations where PHP automatically attempts to convert data types to make the various parts of expressions work together (*type juggling*).

Um tipo de dado é uma categorização de um valor em um programa que especifica como o mecanismo PHP deve interpretar esse valor e, portanto, quais operações podem ser aplicadas a ele. Por exemplo, se um valor é um integer, o mecanismo PHP sabe que operações como addition e multiplication são permitidas e que os resultados são eles próprios integers; enquanto isso, o mecanismo PHP sabe que o resultado de division em um integer pode ser outro integer ou um floating-point (decimal). Entender quais data types estão disponíveis, e saber quando e como o data type de um valor pode mudar, é essencial ao trabalhar com inputs, realizar cálculos e gerar outputs. Se não soubermos o tipo de dado que estamos manipulando ou como esse dado responde a várias operações, podemos obter resultados inesperados.

## PHP Data Types
No Capítulo 1, armazenamos a palavra *matt* em uma variável e atribuímos o número 99 a uma constante. Esses valores são de diferentes data types: um é uma string, e o outro um integer. No total, o PHP possui 10 built-in data types divididos em três categorias, conforme mostrado na figura 2-1:
!![image-20263315858380.png](/image-20263315858380.png)

Por enquanto, vamos nos concentrar principalmente nos quatro scaler data types, que podem armazenar apenas um valor por vez. Também daremos atenção especial ao special NULL data type. Em capítulos posteriores, aprenderemos sobre dois dos compound data type, *array* e *object* (na parte V), que podem armazenar e manipular coleções de múltiplos valores. O resource special type e os compound types callable e iterable são usados apenas em casos complexos e especiais e não serão abordados neste livro.

## Scalar Data Types
Os quatro scalar data types (tipos de valor único) são string, int, float e bool. O tipo string é para texto, o tipo int é para números inteiros (integers), o tipo float é para números de ponto flutuante (decimais), e o tipo bool é para valores Boolean true/false.

Vamos usar o modo interativo do PHP para explorar os scalar data types. Este modo permite que insiramos instruções PHP individuais na linha de comando e veja imediatamente os resultados. Usaremos o modo interativo nos próximos capítulos para demonstrar rapidamente conceitos básicos e obter feedback instantâneo, em vez de ter que escrever scripts PHP completos. Basta digitarmos php -a na linha de comando para ativar o modo interativo e então inserir o seguinte:
```php
$username = "matt";
print gettype($username);
```

Aqui, novamente atribuímos o valor "matt" à variável $username. Em seguida, usamos a função embutida do PHP gettype() para exibir o tipo da variável. A saída confirma que $username contém uma string.

Se já vimos ou escrevemos código em linguagens fortemente tipadas como Java ou C#, podemos ter notado que não é necessário especificar o date type ao atribuir um valor a uma variável. PHP é uma linguagem *loosely typed*, o que significa que a mesma variável pode armazenar valores de diferentes data types em momentos diferentes e que o mecanismo PHP inferirá automaticamente o data type de uma expressão.

*Também podemos declarar explicitamente data types em PHP, algo que faremos a partir do capítulo 5, quando começarmos a escrever functions. Por enquanto, porém, ao trabalharmos com variáveis simples, deixaremos que o interpretador infira os data types.*

No caso da variável *$username*, o valor *matt* é inferido como sendo uma string. Podemos atribuir de forma semelhante valores numéricos a variáveis, com ou sem decimais, e o PHP os interpretará como integers ou floats conforme apropriado:
```php
php > $age = 21;  
php > print gettype($age);  
integer  
php > $price = 9.99;  
php > print gettype($price);  
double
```

Aqui, vemos que $age, com seu valor de número inteiro, foi interpretado como um integer, e $price, cujo valor inclui um decimal, foi interpretado como um... double? Embora a documentação se refira a valores de ponto flutuante como sendo do data type float, por razões históricas (o PHP é uma linguagem antiga!) a função gettype() retorna double quando usada em floats — uma referência ao formato double-precision para armazenar valores de ponto flutuante.

O PHP tem apenas um tipo de dado de ponto flutuante, no entanto, portanto, embora outras linguagens de programação possam ter diferentes representações de precisão e memória para floats, doubles, reais e assim por diante, todos os valores de ponto flutuante em PHP são do data type float (independentemente do que a função gettype retorna).

Vamos tentar criar uma variável do tipo **bool** em seguida. Digite o seguinte:
```php
$isDutyFree = true;
print gettype($isDutyFree);
boolean
print $isDutyFree;
```

Quando usamos gettype() na variável *$isDutyFree*, vemos **boolean** exibido. Este é um **alias** para **bool** em PHP; os dois são praticamente intercambiáveis, mas para evitar alguns casos onde os **aliases** não funcionam, sempre escreva **boolean** em nosso código.

Curiosamente, observe que quando tentamos imprimir o valor de $isDutyFree, vemos o número 1 em vez de **true** na saída. Isso não é um erro. Está relacionado à forma como os valores **bool** são convertidos, ou manipulados (**juggled**), para strings. O comando print espera uma string, então qualquer coisa que fornecermos após a palavra-chave print é automaticamente convertida em uma expressão do tipo string pelo mecanismo do PHP. Para o tipo bool, true é convertido para string "1", e false é convertido para uma string vazia (ou seja, uma string sem conteúdo, representada por um conjunto de aspas sem nada entre elas: ""). Discutiremos a conversão para outro tipo de dados através de casting manual e type juggling automático com mais detalhes ainda neste capítulo.

Para ver o valor **Boolean** real de $isDutyFree, use a função embutida *var_dump()* em vez de **print**. Esta função útil exibe informações sobre uma variável. É útil ao aprender PHP e para fins de **debugging** para saber o valor de uma variável em um determinado ponto da execução do seu código:
```php
$isDutyFree = true;
var_dump($isDutyFree);
bool(true)
```

A saída do *var_dump()* confirma que o tipo de dado (data type) de $isDutyFree é bool e que seu valor é true.

## The Special NULL type
O PHP possui um tipo de dado especial representado no código pela constante **NULL** ou **null** (é **case insensitive** - não diferencia maiúsculas de minúsculas). Uma variável é **NULL** em três situações. Na primeira, uma variável nunca recebeu um valor atribuído, como mostrado aqui:
```php
var_dump($lastName);
Warning: Undefined variable $lastName in php shell code on line 1
NULL
```

Quando tentamos usar *var_dump()* em *$lastName* sem atribuir um valor à variável, primeiro recebemos um **warning** (aviso) de que $lastName não está definida. Em seguida, vermos que a variável, por não ter recebido um valor, é avaliada com **NULL**. 

---
- #var_dump é uma função embutida no PHP que serve para exibir informações estruturadas sobre uma ou mais variáveis.
- Mostra tipo e valor juntos: diferente de funções como print ou echo, que convertem tudo para string, o <span style="background:#affad1">var_dump() </span>exibe:
	- O **tipo de dado** da variável;
	- O **valor** da variável;
	- O **tamanho** (para strings e arrays)

Em segundo lugar, ele Auxilia no debugging (deupração). Sendo extremamente útil para:
- Verificar o conteúdo de variáveis em pontos específicos do código;
- Descobrir qual tipo real de dado que uma função retornou;
- Inspecionar arrays e objetos de forma detalhada.

```php
$array = ["nome" => "João", "idade" => 30];
var_dump($array);
```

Ajuda bastante também na hora de distinguir situações que parecem iguais visualmente mas são diferentes:
```php
$var1 = null;
$var2 = "";
$var3 = false;

var_dump($var1); // NULL
var_dump($var2); // string(0) ""
var_dump($var3); // bool(false)
```

**Aceita quantos argumentos quisermos:**
```php
var_dump($nome, $idade, $email);
```

**Diferença para outras funções:**

| `print` / `echo` | Exibe apenas o valor convertido para string            |
| ---------------- | ------------------------------------------------------ |
| `print_r()`      | Exibe o valor de forma legível, mas sem mostrar o tipo |
| **`var_dump()`** | Exibe tipo, tamanho e valor - mais completo para debug |
|                  |                                                        |
|                  |                                                        |

É uma ferramenta essencial principalmente durante o aprendizado e no desenvolvimento, pois ajuda a entender exatamente o que está acontecendo com suas variáveis.

Por fim, uma variável será **NULL** se tiver sido **unset** (desfeita), ou seja, limpa de seu valor, com a função embutida **unset()**:
```php
$lastName = "Smith"
var_dump($lastName); // string(5) "Smith"
unset($lastName);
var_dump($lastName); // Warning: Undefined variable $lastName in php shell code on line 1
NULL
```

Aqui, atribuímos um valor a $lastName e então usamos *unset()* para remover esse valor. Quando tentamos usar **var_dump()** em $lastName após removê-lo (**unset**), recebemos o mesmo **warning** de antes e vemos que ele é avaliado como **null**. Remover (**unsetting**) uma variável é o mesmo que nunca ter atribuído um valor a ela em primeiro lugar.

Ao trabalhar com variáveis e itens de dados em programas mais complexos, às vezes precisamos projetar uma lógica para lidar com encontros com NULL. Por exemplo, se estivermos criando uma conexão com um banco de dados mas tiver um problema ao conectar, a variável de conexão será definida como **NULL**. Em outro exemplo, se esperarmos receber uma referência a um objeto (como o usuário logado) mas nenhum objeto desse tipo existe, então uma variável será **NULL**. Exploraremos esses tipos de situações nas Partes V e VI, quando discutirmos **object-oriented programming** (programação orientada a objetos) e banco de dados.


## Functions to Test for a Data Type
O PHP possui muitas funções que retornam **true** ou **false** com base no fato de a variável ou expressão fornecida ser de um determinado tipo de dado (**data type**). Estas incluem *is_string()*, *is_int()*, *is_float()*, *is_bool()* e *is_null()*. Tais funções são úteis se você precisar confirmar que uma variável é de um tipo específico antes de tentar trabalhar com ela ou, inversamente, se precisar verificar se uma variável não é **NULL.** Aqui estão alguns exemplos dessas funções em ação:
```php
$gpa = 3.5;
var_dump(is_string($gpa));
bool(false)

var_dump(is_int($gpa));
bool(false)

var_dump(is_float($gpa));
bool(true)

$middleName = NULL;
var_dump(is_bool($middleName));
bool(false)

var_dimp(is_null($middleName)); // bool(true)

```

Nossa variável *$gpa* contém um valor decimal, então apenas *is_float()* é **true** para ela.
Da mesma forma, $middleName contém **NULL**, então passá-la para *is_null()* resulta em true.

Algumas funções de verificação de tipo do PHP são verdadeiras para categorias mais amplas de tipos de dados. Por exemplo, a função *is_numeric()* é **true** para variáveis do tipo **int** ou **float**:
```php
$gpa = 3.5;
$age = 21;
var_dump(is_numeric($gpa)); // bool(true)
var_dump(is_numeric($age)); // bool(true)
```

Aqui vemos que tanto o valor decimal 3.5 quanto o número inteiro 21 passam no teste is_numeric(). A mesma função também retorna true para **strings** que contenham apenas caracteres numéricos, mas não se caracteres não numéricos forem misturados:
```php
$price = "9.99";
var_dump(is_numeric($price));
bool(true)

$price = "9.99 dollars";
var_dump(is_numeric($price));
bool(false)
```

Quando `$price` contém a **string** `"9.99"`, `is_numeric()` é **true**. Quando adicionamos  
a palavra **dollars** ao final da **string**, no entanto, `is_numeric()` torna-se **false**.

## Type Juggling
