É uma ferramenta que executa código automaticamente para verificar se o nosso código funciona. 
Ele responde apenas duas coisas, se o nosso código **passou** ou **falhou**. 

## Estrutura básica de um teste
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinhaClasseTeste {
	
	@Test
	void nomeDoTest() {
		// preparação
		// execução
		// verificação
	}
}
```

A peça mágica é o *@Test*. 

Isso é uma anotação, ele fala pro JUnit que aquele método é um teste; sem isso, o método é ignorado.

**O padrão mental do teste**:
Todo teste segue isso:
```java
// 1 Arrange (preparar)
dados

// 2. Act (executar)
resultado = funcao(dados)

// 3. Assert (verificar)
ver se resultado é o esperado
```

**Exemplo simples**
```java
@Test
void somaDeveFuncionar() {
	int resultado = 2 + 3;
	assertEquals(5, resultado);
}
```

Se o resultado for != 5,. falhou;

**O que são os asserts?**
São as verificações:

#assertEquals(a, b) a == b;
#assertTrue(condição) condição é verdadeira
#assertFalse(condição) condição é falsa
#assertNull(obj) é nulo
#AssertArrayEquals(a, b) - arrays são igual

o nosso Kata usa esse:

```java
assertArrayEquals(expected, kata.invert(input));
```

Teste não serve para provar que funciona
Teste serve para provar quando o nosso CÓDIGO QUEBRA!

**Exemplos de testes**
```java
@Test
@DisplayName("Sample Tests")
void sampleTestes()
```

@Test - marca o método para o JUnit executar;

@DisplayName("Sample Tests")
Só muda o nome que aparece na interface do teste;
runTest(expected, input);

```java
runTest(new int[]{-1, -2, -3, -4, -5}, new int[]{1, 2, 3, 4, 5});
```

javaspring.net/blog/helper-method-java/?utm_source=chatgpt.com