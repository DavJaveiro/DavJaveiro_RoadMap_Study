*O clichê do programador sujo e de cabelo comprido é, claro, um mito... na maior parte do tempo. Mesmo assim, programar exige entusiasmo. Isso não impede-nos de ir ao banheiro ou ao cabeleireiro, mas certamente exige tempo.*

Neste capítulo, aprenderemos a sintaxe do PHP, os principais elementos da linguagem e os conceitos básicos.

## 5.1 Operadores
Os operadores têm uma tarefa principal: conectar dados entre si. Os dados que são conectados são chamados de **operandos**.

Um operador pode trabalhar com **um, dois ou três operandos**. O caso mais comum é dois operandos.

Um operador pode ser uma variável ou um **valor literal**.
Exemplo com valores literais:
```
1 + 2
```

Exemplo com variáveis:
```php
$a + $b
```

### 5.1.1 Operadores Aritméticos
Adição, subtração, multiplicação e divisão: essas são as **operações aritméticas** que conhecemos das aulas de matemática. Elas são muito fáceis de usar em PHO.
```php
$a = 7;
$b = 3;
$result = $a * $b;
echo $result;
```
Os operadores aritméticos só podem ser aplicados **a números**.
Além dos operadores das operações aritméticas básicas e do sinal de menos para número negativos, também existe o **operador módulo**, representado pelo símbolo de **porcentagem (%).**

O **módulo** indica o **resto inteiro de uma divisão:**
```php
$a = 7;
$b = 3;
$result = $a % $b;
```
De acordo com essas linhas, a variável $result terá o valor 1.

**Formas Curtas (Short Forms)**
Se quisermos alterar o valor de uma variável, podemos fazer da seguinte forma:
```php
$result = 7;
$result = $result + 3;
```
No entanto, o último passo é **um pouco longo**. Por isso, existe uma **forma abreviada** que conecta diretamente o **operador aritmético** com o **operador de atribuição**:
