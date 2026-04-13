No capítulo 1, expliquei que o PHP é a linguagem que usamos para fazer com que o servidor gere resultados dinâmicos, resultado que são potencialmente diferentes cada vez que um navegador solicita uma página. Neste capítulo, começaremos a aprender essa linguagem simples, mas poderosa; ela será o tópico dos capítulos seguintes até o Capítulo 7. Na produção, suas páginas da Web serão uma combinação de HTML, CSS, JavaScript, PHP e SQL. Além disso, cada página pode levar a outras páginas para fornecer aos usuários maneiras de clicar em links e preencher formulários. No entanto, podemos evitar toda essa complexidade ao aprender cada linguagem. Vamos nos concentrar, por enquanto, apenas em escrever código PHP e garantir que obtenhamos o resultado esperado, ou pelo menos, que entendamos o resultado que realmente obtemos.

## Incorporating PHP Within HTML
Por padrão, os documentos PHP terminam com a extensão .php. Quando um servidor da web encontra essa extensão em um arquivo solicitado, ele o passa automaticamente para o processador PHP. Obviamente, os servidores da Web são altamente configuráveis e alguns desenvolvedores optam por forçar os arquivos que terminam com .htm ou .html a também serem analisados pelo processador PHP, geralmente porque querem ocultar o uso do PHP. Se o nosso programa PHP é responsável por passar de volta um arquivo limpo adequado para exibição em um navegador da Web. Para provar isso, podemos pegar qualquer documento HTML normal e salvá-lo como um documento PHP (por exemplo, salvar index.html como index.php), e ele será exibido de forma idêntica ao original (desde que o arquivo esteja sendo servidor com o Apache e não diretamente do nosso sistema de arquivos).

Para acionar os comandos PHP, precisamos aprender uma nova tag. Aqui está a primeira parte:
`<?php`

A primeira coisa que podemos notar é que a tag não foi fechada. Isso ocorre porque seções inteiras de PHP podem ser colocadas dentro dessa tag e só terminam quando a parte de fechamento é encontrada, que tem a seguinte aparência:
`?>`.

A small PHP "Hello World" program might look like Example 3-1:
```php
<?php
	echo "Hello World"
?>
```

O uso dessa tag pode ser bastante flexível. Alguns programadores abrem a tag no início de um documento e a fecham logo no final, gerando qualquer HTML diretamente dos comandos PHP.

O último tipo de programador geralmente argumenta que seu estilo de codificação resulta em um código mais rápido, enquanto o primeiro diz que o aumento de velocidade é tão mínimo que não justifica a complexidade adicional de entrar e sair do PHP muitas vezes em um único documento. 

À medida que aprendermos mais, descobriremos o nosso estilo preferido de desenvolvimento PHP, mas, para facilitar o acompanhamento dos exemplos deste livro, adotei a abordagem de manter o número de transferência entre PHP e HTML no mínimo, geralmente apenas uma ou duas vezes em um documento.

Também podemos encontrar código em que a sintaxe de abertura e fechamento seja semelhante a esta:
```php
<?
	echo "Hello World";
?>
```

Embora não seja tão óbvio que o analisador PHP esteja sendo chamado, essa é uma sintaxe alternativa válida que também funciona. Mas não recomendo seu uso, pois ela e incompatível com XML e está obsoleta (o que significa que não é mais recomendada e o suporte pode ser removido em versões futuras).

## The Structure of PHP
Abordaremos muitos assuntos nesta seção e recomendo que leia com cuidado, pois ela estabelece a base para todo o restante do livro. Como sempre, há algumas perguntas úteis no final do capítulo que podemos usar para testarmos o nosso aprendizado.

### Using Comments
Há duas maneiras de adicionar comentários em nosso código PHP. A primeira transforma uma única linha em um comentário, precedendo-a com um par de barras:
```php
// This is a comment
```
Essa é a versão do recurso de comentário é uma ótima maneira de remover temporariamente uma linha de código de um programa que está apresentando erros.

Por exemplo, podemos usar esse comentário para ocultar uma linha de código de depuração até precisar dela, assim:
```php
// echo "X equals $x";
```

We can also use this type of comment directly after a line of code to describe its action, like this:
```php
$x += 10; // move 10 pixels for visual separation
```

**Single-line # Comments**
Além de usar // para indicar o início de um comentário de linha única, podemos usar o símbolo #. No entanto, isso é menos comum e, a partir da versão 8 do PHP, os comentários de linha única que começam com # agora têm um significado especial (sendo tratados como atributos).

When we need to use multiple lines, there's a second type of comment, which looks like **Example 3-2**
```<?php
/* This is a section
	of multiline comments
	which will not be interpreted */
	?>
```

Podemos usar os pares de caracteres para abrir e fechar comentários em praticamente qualquer lugar do nosso código. A maioria dos programadores usa essa construção para comentar temporariamente seções inteiras de código que não funcionam ou que, por um motivo ou outro, eles não desejam que sejam interpretadas. 

### Basic Syntax
O PHP é uma linguagem bastante simples, com raízes no C e no Perl (se já os encontramos), mas se parece mais com o Java. Ela também é muito flexível, mas precisamos aprender algumas regras sobre sua sintaxe e estrutura.

## Semicolons
Podemos ter notado nos exemplos anteriores que os comandos PHP terminavam com um ponto e vírgula, como este:
```php
$x += 10;
```

Uma das causas mais comuns de erros que encontraremos com o PHP é o esquecimento do ponto e vírgula. Isso faz com que o PHP trate várias declarações como uma única declaração, o que ele não consegue entender, levando-o a produzir uma mensagem de erro Parse.

### The $ symbol
O símbolo $ é usado de muitas maneiras diferentes por diferentes linguagens de programação.

No PHP, devemos colocar um $ na frente de todas as variáveis. Isso é necessário para tornar o interpretador PHP mais rápido, pois ele reconhece instantaneamente quando se deparada com uma variável. Sejam suas variáveis números, strings ou arrays, todas devem se parecer com algo como no Exemplo 3-3. 
Exemplo 3-3. Três tipos diferentes de atribuição de variável:
```php
$mycounter = 1;
$mystring = "Hello";
$myarray = array("One", "Two", "Three");
```

Isso é praticamente toda a sintaxe que precisamos lembrar. Ao contrário de linguagens como Python, que são muito rígidas quando à indentação e organização do código, o PHP permite que usemos ou não toda a identação e espaçamentos que desejarmos. 

Na verdade, o uso sensato de espaços em branco é geralmente incentivado (junto com comentários abrangentes) para ajudar-nos a entender o nosso código quando voltarmos nele. Isso também ajuda outros programadores quando eles precisam dar manutenção no código.

### Variables
Uma metáfora simples nos ajudará a entender o que são as variáveis do PHP. Pense nelas como pequenas (ou grandes) caixas de fósforos! 

#### String Variables
Imagine que tenhamos uma caixa de fósforos na qual escrevemos a palavra nome de usuário. Em seguida, escrevemos Fred Smith em um pedaço de papel e colocamos dentro da caixa. Esse é o mesmo processo de atribuir um valor de string a uma variável, assim:
```php
$username = "Freed Smith";
```

As aspas indicam que "Fred Smith" é uma sequência de caracteres. Devemos colocar cada sequência entre aspas duplas ou apóstrofos (aspas simples), embora exista uma diferença sútil entre os dois tipos de aspas, como será explicado mais adiante.

Quando queremos ver o que está dentro da caixa, abrimos e removemos o pedaço de papel para ler. Em PHP, fazer isso se parece com o seguinte (o que exibe o conteúdo da variável):
```php
echo $username;
```

Podemos reatribuir a variável $username a outra variável (fotocopiar o papel e colocar a cópia em outra caixa de fósforos), assim:
```php
$current_user = $username;
```

*Example 3-4. Our first PHP program*
```php
<?php //test1.php
	$username = "Fred Smith";
	echo $username;
	echo "<br>";
	$current_user = $username;
	echo $current_user;
	?>
```

### Numeric variables
Variables don't have to contain just strings, they also can contain numbers. If we return to the matchbox analogy, to store the number 17 in te variable $count, the equivalent would be placing, say, 17 beads in a matchbox on which we have written the word *count:*
*$count = 17*;

Podemos também usar um número de ponto flutuante (contendo um ponto decimal). A sintaxe é a mesma:
```php
$count = 17.5;
```

Se quisermos usar o número no PHP, podemos atribuir o valor de *$count* a outra variável ou talvez apenas ecoá-la no navegador da Web. Qualquer uma dessas opções seria o equivalente a abrir a caixa de fósforos e contas a pagar.

### Arrays
Podemos pensar em arrays como várias caixas de fósforos coladas umas às outras. Por exemplo, imagine que queiramos armazenar os nomes dos jogadores de um time de futebol com cinco pessoas em um array chamado *$team*. Para isso, poderíamos colar cinco caixas de fósforos lado a lado e escrever os nomes de cada jogador em pedaços de papel separados, colocando um em cada caixa.
Na parte superior de todo esse conjunto de caixas, escreveríamos a palavra *team*. O equivalente disso em PHP seria:
```php
$team = array('Bill', 'Mary','Mike','Chris','Anne');
```

!![image-20263244133544.png](/image-20263244133544.png)

Essa sintaxe é mais complicada do que os exemplos que vimos até agora. O código de construção de array consiste na seguinte construção: 
array(); 
Com cinco strings dentro. Cada string é colocada entre apóstrofos ou aspas, e as strings devem ser separadas por vírgulas.

>Sintaxe Curta de Arrays
>Uma alternativa à sintaxe tradicional de arrays utiliza colchetes [...] em vez da construção array(...). O array anterior poderia ser escrito assim:
>$team = ['Bill', 'Mary', 'Mike', 'Chris', 'Anne'];

Se quisermos saber quem é o jogador 4, poderíamos usar este comando:
```php
echo $team[3];
```

O motivo de usarmos o número 3 e não o 4 é que o primeiro elemento de um array em PHP é, na verdade, o elemento de índice zero. Portanto, os números dos jogadores vão de 0 a 4.

### Two-dimensional arrays
Há muito mais que possamos fazer com matrizes. Por exemplo, em vez de serem linhas unidimensionais de caixas de fósforos, eles podem ser matrizes bidimensionais ou ter ainda mais dimensões.

Como exemplo de uma matriz bidimensional, digamos que queremos acompanhar um jogo de jogo da velha, que requer uma estrutura de dados de nove células dispostas em um quadrado 3 x 3. Para representar isso com caixas de fósforos, imagine nove delas coladas umas às outras em uma matriz de três linhas por três colunas usando uma matriz chamada $oxo.

Agora, podemos colocar um pedaço de papel com um x ou um o na caixa de fósforos correta para cada jogada. 

**Example 3-5. Edfining a two-dimensional array**
```php
<?php
$oxo = array(array('x',' ','o'),
			 array('o','o','x'),
			 array('x','o',' '));
?>
```

Subimos um degrau em complexidade, mas é fácil de entender se compreendermos a sintaxe básica do array. Há três construções de array() aninhadas dentro da construção de array() externa. Preenchemos cada linha com uma matriz que consiste em apenas um caractere: um x, um o ou um espaço em branco. (Usamos um espaço em branco para que todas as células tenham a mesma largura quando forem exibidas).

To then return the third element in the second row of this array, we would use the following PHP command, which will display an x:
```php
echo $oxo[1][2];
```

Lembre-se de que os índices de matriz (ponteiros para elementos em uma matriz) começam em zero, não em um; portanto, o [1] no comando anterior refere-se à segunda das três matrizes, e o [2] faz referência à terceira posição dentro dessa matriz. Esse comando retornará o conteúdo da caixa de fósforos três para cima e dois para baixo.

Conforme mencionado, podemos oferecer suporte a matrizes com ainda mais dimensões simplesmente criando mais matrizes dentro de matrizes. 

### Variable-naming rules
Ao criar variáveis em PHP, é importante seguir estas quatro regras:
- O nome da variável, depois do cifrão ($), deve começar com uma letra do alfabeto ou com um caractere _ (underscore);
- Os nomes podem conter apenas letras (a-z, A-Z), números (0-9) e o caractere _;
- Não é permitido usar espaços. Se precisar que o nome da variável tenha mais de uma palavra, utilize o _ para separá-las (por exemplo: $user_name);
- Os nomes de variáveis diferenciam maiúsculas de minúsculas. Assim, *$High_Score* não é a mesma coisa que *#high_score*. 

> Para permitir caracteres ASCII estendidos que incluem acentos, o PHP também suporte os bytes de 127 a 255 em nomes de variáveis, bem como caracteres Unicode. No entanto, esteja ciente de que os programadores que usam teclados em inglês terão dificuldade para acessar qualquer um dos caracteres que usarmos.

### Operators
Os operadores permitem que especifiquemos as operações matemáticas a serem executadas, como *adição*, *subtração*, *multiplicação* e *divisão*. Mas também existem vários outros tipos de operadores, como os operadores de cadeia de caracteres, de comparação e lógicos. 

```php
echo 6 + 2;
```
Before moving on to learn what PHP can do for us, let's take a moment to examine the various operators it provides.

### Arithmetic operators
Podemos usar os operadores aritméticos para quatro operações principais (adição, subtração, multiplicação e divisão), bem como para encontrar um módulo (o restante após uma divisão) e para incrementar ou decrementar um valor.

!![image-2026324932309.png](/image-2026324932309.png)

### Assignment operators
Operadores de atribuição atribuem valores a variáveis. Eles começam com o sinal de igualdade mais simples, =, e evoluem para +=, -=, e assim por diante. O operador += soma o valor do lado direito à variável do lado esquerdo, em vez de substituir totalmente o valor da esquerda. Assim, se *$count* começar com o valor 5, a instrução:
```php
$count += 1;
```
define *$count* como 6, exatamente como a instrução de atribuição mais familiar:
```php
$count = $count + 1;
```

Os operadores /= e * = são semelhantes, mas para divisão e multiplicação. O operador .= concatena variáveis, de modo que $a .="."

```php
$a = "Hello";
$a .= "."; // Equivalente a escrever $a = $a . ".";
echo $a; // A saída é Hello.
```

O operador %= atribui o módulo:
```php
$number = 12;
$number %= 10;
echo $number;
```

!![image-20263242817833.png](/image-20263242817833.png)

### Comparison operators
Comparison operators are generally used inside a construct such as an *if* statement in which we need to compare two items. For example, our may wish to know whether a variable our have been incrementing has reached a specific value, or whether another variable is less than a set value, and so on (see Table 3-3).

!![image-20263244046232.png](/image-20263244046232.png)

Observe a diferença entre = e == .  O primeiro é um operador de atribuição e o segundo é um operador de comparação.

Lembremos sempre que, == compara os dois valores para que sejam equivalentes, enquanto === exige que sejam idênticos. Até mesmo programadores avançados podem, às vezes confundir o uso desses operadores ao codificar com pressa, portanto, tenhamos cuidado.

### Logical operators
O código em PHP para o uso dos operadores lógicos, possuem a seguinte sintaxe:
```php
if ($hour > 12 && $hour < 14)dolunch();
```

Aqui, transferimos o conjunto de instruções para realmente ir almoçar para uma função que teremos de criar mais tarde chamada *dolunch*.

Como mostra o exemplo anterior, geralmente usamos um **operador lógica** para combinar os resultados de dois operadores de comparação mostrados em *Operadores de comparação*.

Um operador lógico também pode ser uma entrada para outro operador lógico: "Se o horário for depois das 12 horas e antes das 14 horas, ou se o cheiro de assado estiver permeando o corredor e houver pratos sobre a mesa."

Como regra geral, se algo tiver um valor VERDADEIRO ou FALSO, poderá ser inserido em um operador lógico. Um operador lógico recebe duas entradas verdadeiras ou falsas e produz um resultado verdadeiro ou falso.

!![image-2026324624909.png](/image-2026324624909.png)

Observe que && geralmente é intercambiável com and; o mesmo vale para || e or. Entretanto, como *and* e *or* têm uma precedência menor, devemos evitar seus devidos usos, exceto quando forem a única opção, como na instrução a seguir, que deve usar o operador || (or); não pode ser usado para forçar a execução de uma segunda instrução se a primeira falhar:
```php
$html = file_get_contents($site) or die("Cannot download from $site");
```

### Operator precedence
A precedência de operadores determina como determinadas expressões são agrupadas. O conceito também é usado na matemática comum, conforme ilustrado na instrução a seguir:
```php
5 + 2 * 3;
```

### Variable Assignment
A sintaxe para atribuir um valor a uma variável é sempre $variable = value. Ou, para reatribuir o valor a outra variável, é $other_variable = $variable, lembrando-se de preceder os nomes das variáveis com os símbolos $ no PHP.

Há alguns outros operadores de atribuição que acharemos úteis. Por exemplo, já vimos isso antes:
```php
$x += 10;
```
which tells the PHP *parser* to add the value on the right (in this instance, the value 10) to the variable $x. Likewise, we could subtract:
```php
$y -= 10;
```

#### Variable incrementing and decrementing
Adding or subtracting 1 (known as incrementing and decrementing) is such a common operation that PHP provides special operators for it. We can use on of the following in place of the += and -= operators:
```php
++$x;
--$y;
```

Em conjunto com um teste (uma instrução if), podemos usar esse código:
```php
if (++$x == 10) echo $x;
```

isso diz ao PHP para primeiro incrementar o valor de $x e, em seguida, testar se ele tem o valor 10 e, se tiver, exibir seu valor. Mas também podemos solicitar que o PHP incremente (ou, como no exemplo a seguir, decremente) uma variável depois de testar o valor, assim:
```php
if ($y-- == 0) echo $y;
```

que dá o resultado sutilmente diferente. 

Suponha que $y comece como 0 antes de a instrução ser executada. A comparação retornará um resultado VERDADEIRO, mas $y será definido como -1 depois que a comparação for feita. Então, o que a instrução echo exibirá? 0 ou -1? Tente adivinhar e, em seguida, experimente a instrução em um processador PHP para confirmar. 

Como essa combinação de instruções é confusa, ela deve ser considerada um exemplo didático e não um guia de bom estilo de programação.

Em resumo, uma variável é incrementada ou decrementada antes do teste se o operador for colocado antes da variável, enquanto a variável.

A propósito, a resposta correta para a pergunta anterior é que a instrução echo exibirá o resultado -1, porque $y <span style="background:#affad1">foi decrementado logo após ter sido acessado na instrução if e antes da instrução echo</span>.

### String concatenation
Concatenação é um termo um tanto arcano para colocar algo depois de outro algo.
Assim, em PHP, **string concatenation** utiliza o ponto (.) para anexar uma string de caracteres a outra. A maneira mais simples de fazer isso é:
```php
echo "We have " . $msgs . " messages.";
```

Supondo que a variável $msgs esteja definida com o valor 5, a saída desta linha de código será:
```text
You have 5 messages.
```

Assim como podemos adicionar um valor a uma variável numérica com o operador +=, podemos anexar uma string a outra utilizando .=, desta forma:
```php
$bulletin = "This is a test of the broadcast system.";
$newsflash = "Huston, we have a problem.";
$bulletin .= " " . $newsflash;
echo $bulletin;
```

Neste caso, se $bulletin contém um boletim de notícias e $newsflash contém uma notícia de última hora, o comando anexa a notícia de última hora ao boletim de notícias, de modo que $bulletin agora compreende ambas as strings de texto.

### String types
O PHP suporte dois tipos de strings que são denotados pelo tipo de aspas que utilizamos. Se você deseja atribuir uma **literal string**, preservando o conteúdo exato, deve usar aspas simples (apóstrofos), desta forma: 
```php
$info = 'Preface variables with a $ like this: $variable'
```

Neste caso, cada caractere dentro da string com aspas simples é atribuído a $info. Se tivéssemos usado aspas duplas, o PHP teria tentado avaliar $variable como uma variável.

Por outro lado, quando desejamos incluir o valor de uma variável dentro de uma string, fazemos isso utilizando **double-quoted strings**. Podemos envolver o nome da variável em chaves {e} para especificar explicitamente o final do nome da variável:
```php
echo "This week {$count} people have viewed your profile";
```

Como podemos ver, a sintaxe também oferece uma opção mais simples em relação à concatenação, na qual não precisamos usar um ponto, nem fechar e reabrir aspas, para anexar uma string a outra. Isso é chamado de **variable substitution** ou **variable interpolation**, e alguns programadores utilizam isso extensivamente, enquanto outros não utilizam nada.

### Escaping characters
Às vezes, uma string precisa conter caracteres com significados especiais que podem ser interpretados incorretamente. Por exemplo, a seguinte linha de código não funcionará, porque a segunda aspas encontrada na palavra spelling's indicará ao parser do PHP que o fim da string foi alcançado. Consequentemente, o restante da linha serpa rejeitado como erro:
```php
$text = 'My spelling's atroshus'; // Erroneous syntax
```


Para corrigir isso, podemos adicionar uma barra invertida diretamente antes da aspas problemática para instruir o PHP a tratar o caractere literalmente e não interpretá-lo:
```php
$text = 'My spelling\'s still atroshus';
```

E podemos usar esse truque em quase todas as situações em que o PHP, de outra forma, retornaria um erro ao tentar interpretar um caractere. Por exemplo, a seguinte string com aspas duplas será atribuída corretamente:
```php
$text = "She wrote upon it, \"Return to sender\".";
```

Além disso, podemos usar caracteres de escape para inserir vários caracteres especiais em strings, como tabs, novas linhas e retornos de carro. Eles são representados, como podemos imaginar, por \t, \n e \r/. Aqui está um exemplo usando tabs para definir um cabeçalho, ele está incluído aqui apenas para ilustrar os escapes, porque em páginas web sempre há maneiras melhores de fazer o layout:
```run-php
<?php
	$heading = "Date\tName\tPaymenty";
	echo $heading
?>
```



### String Multilinha
Há momento em que precisamos exibir uma quantidade considerável de texto a partir do PHP, e usar várias instruções echo (ou print) seria demorado e confuso. Para resolver isso, o PHP oferece duas facilidades. A primeira é simplesmente colocar várias linhas entre aspas, como no Exemplo 3-6. Variáveis também poder ser atribuídas, como no Exemplo 3-7.
**Exemplo 3-6. Uma instrução echo com string multilinha**
```php
<?php
$author = "Steve Ballmer";
echo "Developers, developers, developers, developers, developers, developers, developers, developers, developers! - $author.";
```

**Exemplo 3-7. Uma atribuição de string multilinha**
```php
$author = "Bill Gates";
$text = "Measuring programming progress by lines of code is like measuring aircraft building progress by weight. - $author.";
```

**Exemplo 3-8. Instrução echo multilinha alternativa**
```php
<?php
$author = "Brian W. Kernighan";
echo <<<_END
Debugging is twice as hard as writing the code in the first place.
Therefore, if you write the code as cleverly as possible, you are,
by definition, not smart enough to debug it.
- $author.
_END;
?>
```

Este código acima instrui o PHP a exibir tudo entre as duas tags `_end` como se fosse uma string com aspas duplas (exceto que as aspas em um heredoc não precisam ser escapadas). Isso significa que é possível, por exemplo, que um desenvolvedor escreva seções inteiras de HTML diretamente no código PHP e depois substitua partes dinâmicas específicas por variáveis PHP.

É importante lembrar que o `_END;` de fechamento deve aparecer exatamente no início de uma nova linha e deve ser a única coisa nessa linha, nem mesmo um comentário é permitido após ele (nem mesmo um espaço simples). Depois de fechar um bloco multilinha, estamos livre para usar o mesmo nome de tag novamente.

**Lembre-se:** usando a construção heredoc `<<<_END..._END;`, você não precisa adicionar caracteres de quebra de linha `\n` para enviar uma nova linha – basta pressionar Enter e começar uma nova linha. Além disso, ao contrário de uma string delimitada por aspas duplas ou aspas simples, você está livre para usar todas as aspas simples e duplas que desejar dentro de um heredoc, sem a necessidade de escapá-las com uma barra invertida (`\`).

O exemplo 3-9 mostra como usar a mesma sintaxe para atribuir múltiplas linhas a uma variável.

**Exemplo 3-9. Uma atribuição de variável com string multilinha**
```php
<?php
$author = "Scott Adams";
$out = <<<_END
Normal people believe that if it ain't broke, don't fix it.
Engineers believe that if it ain't broke, it doesn't have enough
features yet.
- $author.
_END;
echo $out;
?>****
```

A variável `$out` será então preenchida com o conteúdo entre as duas tags. Se você estivesse concatenando, em vez de atribuindo, também poderia ter usado `.=` no lugar de `=` para adicionar a string ao final de `$out`.

Cuidado para não colocar um ponto e vírgula imediatamente após a primeira ocorrência de `_END`, pois isso encerraria o bloco multilinha antes mesmo de ele começar e causaria uma mensagem de erro de sintaxe (_Parse error_).

A propósito, a tag `_END` é simplesmente uma que escolhi para estes exemplos porque é improvável que seja usada em qualquer outro lugar no código PHP e, portanto, é única. Você pode usar qualquer tag que desejar, como `_SECTION1` ou `_OUTPUT`, e assim por diante. Além disso, para ajudar a diferenciar tags como esta de variáveis ou funções, a prática geral é prefixá-las com um sublinhado.

### Usando um nowdoc
Se desejamos evitar que o PHP interprete quaisquer variáveis encontradas dentro de um heredoc, podemos usar um nowdoc. Ele funciona de forma quase idêntica, exceto que o nome escolhido para a tag de fechamento deve estar entre aspas simples no início do nowdoc, como no exemplo 3-10, onde a diferença entre ele e o Exemplo 3-9 é mostrada em negrito.

**Exemplo 3-10. Uma atribuição multilinha com nowdoc**
```php
<?php
$author = "Scott Adams";
$out = <<<'_END'
Normal people believe that if it ain't broke, don't fix it.
Engineers believe that if it ain't broke, it doesn't have enough
features yet.
- $author.
_END;
echo $out;
?>
```
Neste exemplo, `$author` não será substituído pela string "Scott Adams" e simplesmente permanecerá exibido como `$author`.

**Formatar texto em múltiplas linhas geralmente é apenas uma conveniência para tornar seu código PHP mais fácil de ler, porque, uma vez exibido em uma página web, as regras de formatação do HTML entram em ação e os espaços em branco são suprimidos (mas em um heredoc, `$author` no nosso exemplo ainda será substituído pelo valor da variável, ao contrário do que ocorre em um nowdoc).**
**Assim, por exemplo, se você carregar esses exemplos de saída multilinha em um navegador, eles não serão exibidos em várias linhas, porque todos os navegadores tratam novas linhas como se fossem espaços. No entanto, se você usar o recurso "Ver código-fonte" do navegador, verá que as novas linhas estão posicionadas corretamente e que o PHP preservou as quebras de linha.**

## Variable Typing
O PHP é uma linguagem de tipagem fraca (loosely typed). Isso significa que as variáveis não precisam ser declaradas antes de serem usadas e o PHP sempre converte as variáveis para o tipo exigido pelo contexto quando elas são acessadas.

Por exemplo, podemos criar um número com vários dígitos e extrair o enésimo dígito dele simplesmente assumindo que ele é uma string.  No exemplo 3-11, os números 12345 e 6789 são multiplicados, retornando um resultado de 838102050, que é então armazenado na variável $number.

```php
<?php
$number = 12345 * 67890;
echo substr($number, 3, 1); // Comece no índice 3 e pegue 1 caractere
?>
```

No momento da atribuição, $number é uma variável numérica. Mas na segunda linha, é feita uma chamada para a função PHP substr, que solicita o retorno de um caractere de $number, começando na quarta posição (lembre-se de que os offsets em PHP começam em zero). Para fazer isso, o PHP transforma $number em uma string de nove caracteres para que substr possa acessá-la e retornar o caractere, que neste caso é 1.

O mesmo vale para transformar uma string em um número, e assim por diante. No Exemplo 3-12, a variável `$pi` é definida com um valor de string, que é então automaticamente convertida para um número de ponto flutuante na terceira linha pela equação para calcular a área de um círculo, que exibe o valor `78.5398175`.
**Exemplo 3-12. Convertendo automaticamente uma string para número**
```php
<?php
$pi = "3.1415927";
$radius = 5;
echo $pi * ($radius * $radius);
?>
```

Na prática, isso significa que não precisamos nos preocupar muito com os tipos das nossas variáveis, embora seja possível adicionar declarações de tipo a argumentos de função, valores de retorno (a partir do PHP 7.4.0) propriedade de classe, garantindo que o valor seja do tipo especificado no momento da chamada; caso contrário, um *TypeError* é lançado.

Supondo que declarações de tipo não estejam sendo usadas, basta atribuir valores que façam sentido para a gente, e o PHP os converterá se necessário. Então, quando quisermos recuperar valores, basta solicitá-los, por exemplo, com uma instrução *echo*, mas lembre-se de que às vezes as conversões automáticas não funcionam exatamente como poderíamos esperar. 

Se as declarações de tipo estiverem sendo usadas para fazer o código se comportar de forma mais previsível, podemos alterar o tipo da variável prefixando-a com o tipo desejado entre parênteses, assim:
```php
$string = (string)$number;
$number = (int)$string;
$boolean = (bool)$stringer;
```

Às vezes, pode não estar tão claro à primeira vista como a conversão de tipo (às vezes chamada de *type casting*) será feita e qual será o resultado. O manual do PHP possui todas as regras de conversão muito bem documentadas.

## Constants
Constantes são semelhantes a variáveis, armazenando informações para serem acessadas posteriormente, exceto que elas são exatamente o que o nome sugere, constantes. Em outras palavras, uma vez que definimos uma constante, o seu valor é fixo para o restante do programa e não pode ser alterado.

Por exemplo, podemos usar uma constante para armazenar a localização da raiz do nosso servidor (a pasta com os arquivos do nosso site). Definimos a constante dessa forma:
```php
define("ROOT_LOCATION", "/usr/local/www/");
```

Então, para ler o conteúdo da constante, simplesmente referenciamos como uma variável normal (mas ela não é precedida por um cifrão):

```php
$directory = ROOT_LOCATION;
```

Agora, sempre que precisamos executar o nosso código PHP em um servidor diferente com uma configuração de pastas distina, teremos apenas uma única linha de código para alterar.

As duas coisas que devemos lembrar sobre constantes são que elas não devem ser precedidas por um $ ao contrário das variáveis comuns, e que podemos defini-las usando a função *define*.

É prática padrão usar apenas letras maiúsculas para nomes de constantes, especialmente se outras pessoas também forem ler seu código.

## Predefined Constants
O PHP vem com dezenas de constantes pré-definidas que você geralmente não usará como iniciante. No entanto, existem algumas—conhecidas como _constantes mágicas_—que você achará úteis. Os nomes das constantes mágicas sempre têm dois sublinhados no início e dois no final, para que você não acidentalmente tente nomear uma de suas próprias constantes com um nome que já está em uso. Elas estão detalhadas na Tabela 3-5. Os conceitos mencionados na tabela serão introduzidos em capítulos futuros.

**Tabela 3-5. Constantes mágicas do PHP**

| Constante mágica | Descrição                                                                                                                                                                                                                                                                       |
| ---------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `__LINE__`       | O número da linha atual do arquivo.                                                                                                                                                                                                                                             |
| `__FILE__`       | O caminho completo e o nome do arquivo. Se usado dentro de um include, o nome do arquivo incluído é retornado. Alguns sistemas operacionais permitem aliases para diretórios, chamados _links simbólicos_; em `__FILE__`, eles são sempre convertidos para os diretórios reais. |
| `__DIR__`        | O diretório do arquivo. Se usado dentro de um include, o diretório do arquivo incluído é retornado. Isso é equivalente a `dirname(__FILE__)`. Este nome de diretório não tem uma barra final, a menos que seja o diretório raiz.                                                |
| `__FUNCTION__`   | O nome da função. Retorna o nome da função conforme foi declarada (sensível a maiúsculas/minúsculas).                                                                                                                                                                           |
| `__CLASS__`      | O nome da classe. Retorna o nome da classe conforme foi declarada (sensível a maiúsculas/minúsculas).                                                                                                                                                                           |
| `__METHOD__`     | O nome do método da classe. O nome do método é retornado conforme foi declarado (sensível a maiúsculas/minúsculas).                                                                                                                                                             |
| `__NAMESPACE__`  | O nome do namespace atual. Esta constante é definida em tempo de compilação (sensível a maiúsculas/minúsculas).                                                                                                                                                                 |
Um uso útil dessas variáveis é para depuração, quando você precisa inserir uma linha de código para ver se o fluxo do programa a alcança:
echo "This is line " . __LINE__ . " of file " . __FILE__;

## The Difference Between the echo and print Commands
Agora que vimos o comando *echo* sendo usado de várias maneiras para enviar texto do servidor para o nosso navegador. Em alguns casos, um literal de string é exibido. Em outros, strings foram primeiro concatenadas ou variáveis foram avaliadas. Também mostrei a saída distribuída em várias linhas..

Mas existe uma alternativa ao *echo*: o *print*. Os dois comandos são bastante semelhantes, mas *print* é uma construção parecida com uma função que recebe um único parâmetro e tem um valor de retorno (que é sempre 1), enquanto *echo* é puramente uma construção da linguagem PHP. Como ambos os comandos são construções, nenhum deles exige parênteses.

De modo geral, o comando `echo` <span style="background:#affad1">será um pouco mais rápido que o</span> `print`, porque ele <span style="background:#fff88f">não define um valor de retorno</span>. Por outro lado, como não é implementado como uma função, *echo* não pode ser usado como parte de uma expressão mais complexa, enquanto *print* pode. 

Exemplo para exibir se o valor de uma variável é TRUE ou FALSE usando *print*, algo que não poderíamos fazer da mesma forma com *echo*, pois ele exibiria uma mensagem de erro de sintaxe (Parse error), já que o operador ternário espera uma expressão que retorna um valor e, enquanto por exemplo echo TRUE não retorna nada, print TRUE retorna 1:
```php
$b ? print "TRUE" : print "FALSE";
```

O ponto de interrogação é simplesmente uma forma de interrogar se a variável *$b* é *TRUE* ou *FALSE*. Qualquer comando que estiver à esquerda dos dois pontos será executada se $b for TRUE, enquanto o comando à direita dos dois pontos será executado se $b for FALSE. 

No geral, porém, os exemplos neste livro usam `echo`, <span style="background:#b1ffff">e eu recomendo que você faça o mesmo até chegar ao ponto em seu desenvolvimento com PHP em que você descubra a necessidade de usar</span> `print`.

## Functions
As funções <span style="background:#b1ffff">separam e encapsulam seções de código</span> que executam uma tarefa específica mais de uma vez. Por exemplo, talvez precisemos frequentemente consultar uma data e retorná-la em um determinado formato. Esse seria um bom exemplo para transformar em uma função. O código que faz isso pode ter apenas três linhas, mas se precisarmos colocá-lo em nosso programa uma dúzia de vezes, estaremos tornando o nosso programa desnecessariamente grande e complexo se não usar uma função. E se decidirmos o formato da data depois, colocar essa lógica em uma função significa que precisaríamos alterará-la em apenas um lugar.

Colocar código em uma função não apenas encurta seu programa e o torna mais legível, mas também <span style="background:#d3f8b6">adiciona funcionalidade extra</span>, porque as funções podem receber parâmetros para fazê-las se comportar de maneira diferente. Elas também podem retornar valores para o código que as chamou.

Para criar uma função, declare-a como mostrado no Exemplo 3-13.
```php
<?php
function longdate($timestamp)
{
	return date("l F jS Y", $timestamp);
}
?>
```

Esta função retorna uma data no formato "Sunday May 2nd 2027" (domingo, 2 de maio de 2027). Qualquer número de parâmetros pode ser passado entre os parênteses iniciais; escolhemos aceitar apenas um. As chaves `{}` englobam todo o código que é executado quando você chama a função posteriormente. Observe que a primeira letra dentro da chamada da função `date` neste exemplo é a letra minúscula "L" (de "l"), não deve ser confundida com o número 1.

Para exibir a data de hoje, usamos a seguinte chamada em nosso código:
```php
echo longdate(time());
```

Se precisamos exibir a data de 17 dias atrás, agora basta fazer esta chamada:
```php
echo longdate(time() - 17 * 24 * 60 * 60);
```

que passa para `longdate` o horário atual menos o número de segundos desde 17 dias atrás (17 dias × 24 horas × 60 minutos × 60 segundos).

As funções também podem aceitar múltiplos parâmetros e retornar múltiplos resultados, usando técnicas que apresentarei nos próximos capítulos.

## Variable Scope
Se temos um programa muito longo, é possível que comecemos a ficar sem bons nomes para as variáveis, mas com o PHP podemos decidir o escopo de uma variável. Em outras palavras, podemos, por exemplo, dizer que desejamos que a variável *$temp* seja usada apenas dentro de uma função específica e que ela seja esquecida quando a função retornar. Na verdade, este é o escopo padrão para variáveis em PHP.

Alternativamente, você pode informar ao PHP que uma variável tem escopo global e, portanto, pode ser acessada por todas as outras partes do seu programa.

### Variáveis Locais
Variáveis locais são variáveis criadas dentro de uma função e que podem ser acessadas apenas por ela. Geralmente, são variáveis temporárias usadas para armazenar resultados parcialmente processados antes do retorno da função.

Um conjunto de variáveis locais é a lista de argumentos de uma função. Em "funções" na página 55, definimos uma função que aceitava um parâmetro chamado *$timestamp*. Ele só tem significado dentro do corpo dessa função; não podemos obter ou definir seu valor fora da função.

Para outro exemplo de variável local, dê outra olhada na função *longdate*, que é ligeiramente modificada no Exemplo 3-14.
**Exemplo 3-14. Uma versão expandida da função longdate**
```php
<?php
function longdate($timestamp)
{
	$temp = date("l F jS Y", $timestamp);
	return "The date is $temp";
}
?>
```

Aqui, atribuímos o valor retornado pela função *date* à variável temporária *$temp*, que é então inserida na string retornada pela função. Assim que a função retorna, a variável $temp e seu conteúdo desaparecem, como se nunca tivessem sido usados. 

Para ver os efeitos do escopo de variável tornando uma variável externa invisível dentro de uma função, vamos examinar um código semelhante no Exemplo 3-15. Aqui, $temp foi criada antes de chamarmos a função *longdate*.

**Exemplo 3-15. Esta tentativa de acessar $temp na função longdate falhará**
```php
<?php
$temp = "The date is ";
echo longdate(time());

function longdate($timestamp)
{
	return $temp . date("l F jS Y", $timestamp);
}
?>
```

No entanto, como $temp não foi criada dentro da função *longdate* nem passada a ela como parâmetro, *longdate* não pode acessá-la. Portanto, este trecho de código exibe apenas a data, não o texto precedente. Na verdade, dependendo de como o PHP está configurado, ele pode primeiro exibir a mensagem de erro *Notice: Undefined variable: temp*, algo que não queremos que os usuários vejam. A razão para isso é que, por padrão, variáveis criadas dentro de uma função são locais a essa função, e variáveis criadas fora de qualquer função podem ser acessadas apenas por código que não está dentro de funções. 

Algumas maneiras de corrigir o Exemplo 3-15 aparecem abaixo:

**Exemplo 3-16. Reescrever para referenciar $temp dentro de seu escopo local resolve o problema**
```php
<?php
$temp = "The date is ";
echo $temp . longdate(time());

function longdate($timestamp)
{
    return date("l F jS Y", $timestamp);
}
?>
```
O Exemplo 3-16 move a referência a *$temp* para fora da função. A referência aparece no mesmo escopo onde a variável foi definida.

**Exemplo 3-17. Uma solução alternativa: passando $temp como argumento**
```php
<?php
$temp = "The date is ";
echo longdate($temp, time());

function longdate($text, $timestamp)
{
	return $text . date("l F jS Y", $timestamp);
}
?>
```


A solução no Exemplo 3-17 para $temp para a função *longdate* como um argumento extra. longdate a lê para uma variável temporária que ela cria chamada $text e exibe o resultado desejado.

Esquecer o escopo de uma variável é um erro comum de programação, então lembrar como o escopo de variáveis funciona faz a gente depurar alguns problemas bastante obscuros. Basta dizer que, a menos que tenhamos declarado uma variável de outra forma, seu escopo é limitado a ser local: seja para a função atual ou para o código fora de quaisquer funções, dependendo se ela foi criada ou acessada pela primeira vez dentro ou fora de uma função.

### Variáveis globais
Em alguns casos, precisamos de uma variável que tenha escopo global, porque deseja que todo o nosso código possa acessá-la. Além disso, alguns dados podem ser grandes e complexos, e não queremos ficar passando-os como argumentos para funções.

Para acessar variáveis do escopo global, adicione a palavra-chave *global*. Vamos supor que tenhamos uma forma de autenticar os nossos usuários em nosso site e queiramos que todo o nosso código saiba se está interagindo com um usuário logado ou com um convidado. Uma maneira de fazer isso é usar a palavra-chave *global* antes de uma variável, como $IS_LOGGED_IN:
```php
global $IS_LOGGED_IN;
```

Agora, a nossa função de login simplesmente precisa definir essa variável como 1 após a tentativa de login bem-sucedida ou como 0 em casa de falha. Como o escopo da variável é definido como global, todas as linhas de código do nosso programa podem acessá-la.

Você deve usar variáveis com acesso global com cautela, no entanto. Eu recomendo que você as crie apenas quando absolutamente não conseguir encontrar outra maneira de alcançar o resultado desejado. Em geral, programas que são divididos em pequenas partes e com dados segregados têm menos bugs e são mais fáceis de manter. Se você tem um programa de mil linhas (e um dia terá) e descobre que uma variável global está com o valor errado, quanto tempo levará para encontrar o código que a definiu incorretamente?

Além disso, se você tiver muitas variáveis com escopo global, corre o risco de usar um desses nomes novamente localmente, ou pelo menos pensar que o usou localmente, quando na verdade ele já foi declarado como global. Todos os tipos de bugs estranhos podem surgir dessas situações.

>**Nota:** Eu geralmente adoto a convenção de deixar em maiúsculas todos os nomes de variáveis que exigem acesso global (assim como é recomendado que constantes sejam em maiúsculas, exceto que constantes não são prefixadas com `$`) para que eu possa ver rapidamente o escopo de uma variável.

### Static variables
Em "variáveis locais" na página 56, mencionamos que o valor de uma variável local é apagado quando a função termina. Se uma função é executada muitas vezes, ela começa com uma nova cópia da variável, e a configuração anterior não tem efeito.

Aqui está um caso interessante. E se tivermos uma variável local dentro de uma função que não queiramos que nenhuma outra parte do nosso código tenha acesso, mas também gostaríamos de manter seu valor para a próxima vez que a função for chamada? Pelo fato de talvez queiramos um contador para rastrear quantas vezes uma função é chamada. A solução é declarar uma variável estática (*static*), como mostrado no Exemplo 3-18.

**Exemplo 3-18. Uma função usando uma variável estática**
```php
<?php
function test()
{
    static $count = 0;
    echo $count;
    $count++;
}
?>
```

Aqui, a primeira linha da função *test* cria uma variável estática chamada *$count* e a inicializa com o valor 0. A próxima linha exibe o valor da variável; a última linha a incrementa.

Na próxima vez que a função for chamada, como *$count* já foi declarada, a primeira linha da função é ignorada. Então, o valor previamente incrementado de $count é exibido antes que a variável seja incrementada novamente.

Se você planeja usar variáveis estáticas, deve notar que não é possível atribuir o resultado de uma expressão em suas definições. Elas só podem ser inicializadas com valores predeterminados (veja o Exemplo 3-19). No entanto, geralmente, assim como as variáveis globais, <span style="background:#affad1">variáveis estáticas tornam as funções menos determinísticas</span>, o que significa que a função pode ter uma saída diferente dada a mesma entrada, e é melhor evitá-las em favor de funções sem efeitos colaterais, como alterar uma variável estática.

**Exemplo 3-19. Declarações de variáveis estáticas permitidas e não permitidas**
```php
<?php
static $int = 0;          // Permitido
static $int = 1 + 2;      // Correto (a partir do PHP 5.6)
static $int = sqrt(144);  // Não permitido
?>
```

### Variáveis superglobais
Diversas variáveis predefinidas também estão disponíveis. Elas são conhecidas como *variáveis superglobais*, o que significa que são fornecidas pelo ambiente PHP, mas são globais dentro do programa, acessíveis em absolutamente todos os lugares.

Essas superglobais contêm muitas informações úteis sobre o programa em execução e seu ambiente (veja a Tabela 3-6). Elas são estruturadas como arrays associativos, um tópico discutido no Capítulo 6.

| Nome superglobal | Conteúdo                                                                                                                                                                                                       |
| ---------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `$GLOBALS`       | Todas as variáveis atualmente definidas no escopo global do script. Os nomes das variáveis são as chaves do array.                                                                                             |
| `$_SERVER`       | Informações como cabeçalhos, caminhos e localizações de scripts. As entradas neste array são criadas pelo servidor web, e não há garantia de que cada servidor web fornecerá qualquer um ou todos estes itens. |
| `$_GET`          | Variáveis passadas para o script atual através do método HTTP GET.                                                                                                                                             |
| `$_POST`         | Variáveis passadas para o script atual através do método HTTP POST.                                                                                                                                            |
| `$_FILES`        | Itens enviados para o script atual através do método HTTP POST.                                                                                                                                                |
| `$_COOKIE`       | Variáveis passadas para o script atual através de cookies HTTP.                                                                                                                                                |
| `$_SESSION`      | Variáveis de sessão disponíveis para o script atual.                                                                                                                                                           |
| `$_REQUEST`      | Conteúdo das informações passadas pelo navegador; por padrão, `$_GET`, `$_POST` e `$_COOKIE`.                                                                                                                  |
| `$_ENV`          | Variáveis passadas para o script atual através do método de ambiente.                                                                                                                                          |

Todas as superglobais (exceto $GLOBALS) são nomeadas com um único sublinhado inicial e apenas letras maiúsculas; portanto, devemos evitar nomear nossas próprias variáveis dessa forma para evitar confusão potencial.

Para ilustrar como usá-las, vejamos um exemplo comum. Entre os muitos fragmentos de informação fornecidos pelas variáveis superglobais está a URL da página que referenciou o usuário para a página web atual. Esta informação da página de referência pode ser acessada assim:

```php
$came_from = $_SERVER['HTTP_REFERER'];
```
É simples assim. Ah, e se o usuário veio diretamente para sua página web, por exemplo, digitando a URL diretamente no navegador, `$came_from` será definido como uma string vazia.

**Diferença entre Superglobais e Constantes**

As superglobais são variáveis comuns que têm o escopo completo de um programa durante a execução, sendo visíveis e utilizáveis em todos os lugares, enquanto as constantes, embora também visíveis dentro de funções, não têm escopo algum, porque são acessadas no início, em tempo de compilação, e "incorporadas" como valores fixos no código em execução antes que qualquer escopo seja criado.

