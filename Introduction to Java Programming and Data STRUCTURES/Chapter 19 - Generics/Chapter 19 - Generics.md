**Objetivos**
- Descrever os benefícios dos genéricos;
- Para definir classes e interfaces genéricas;
- Para explicar por que tipos genéricos podem melhorar a confiabilidade e a legibilidade;
- Para definir e utilizar métodos genéricos e tipos genéricos limitados;
- Para desenvolver um método de ordenação genérico para ordenar um array de objetos Comparable;
- Para utilizar tipos brutos (raw types) para compatibilidade com versões anteriores;
- Para explicar por que tipos genéricos com curinga wildcard são necessários;
- Para descrever a eliminação de tipos genéricos (type erasure) e listar certas restrições e limitações sobre tipos genéricos causadas pela eliminação de tipos;
- Para projetar e implementar classes de matrizes genéricas.

---

## 19.1 Introduction
*Os genéricos permitem que a gente detecte erros em tempo de compilação, em vez de em tempo de execução*.

Os genéricos permitem que a gente parametrize tipos. Com essa capacidade, podemos definir uma classe ou um método com tipos genéricos que o compilador pode substituir por tipos concretos. Por exemplo, o Java define uma classe genérica *ArrayList* para armazenar elementos de um tipo genérico. A partir dessa classe genérica, podemos criar um objeto *ArrayList* para armazenar *strings* e outro objeto *ArrayList* para armazenar *números*. Aqui, strings e números são tipos concretos que substituem o tipo genérico.

O principal benefício dos genéricos é permitir que os erros sejam detectados em tempo de **compilação**, em vez de serem detectados em tempo de **execução**. Uma classe ou um método genérico permite que especifiquemos os tipos de objetos permitidos com os quais a classe ou método pode trabalhar. Se tentarmos usar um objeto incompatível, o compilador detectará esse erro. 

Esse capítulo explica como definir e usar classes, interfaces e método genéricos e demonstra como os genéricos podem ser usados para melhorar a confiabilidade e a legibilidade do software. Ele pode ser integrado ao Capítulo 13, Classes Abstratas e Interfaces.

---

## 19.2 Motivações e Benefícios

A motivação para o uso de genéricos em Java é detectar erros em tempo de compilação. Desde o JDK 1.5, o Java permite que definamos classes, interfaces e métodos genéricos. Várias interfaces e classes na API do Java foram modificadas para usar genéricos. Por exemplo, antes do JDK 1.5, a interface *java.lang.Comparable* era definida como mostrado na figura 19.1a, mas desde o JDK 1.5, ela foi modificada conforme mostrado no código b.

<span style="background:#affad1">Antes</span> do JDK 1.5
```java
package java.lang;
public interface Comparable {
	public int compareTo(Object o)
}
```

<span style="background:#d2cbff">Após</span> o JDK 1.5:
```java
package java.lang;
public interface Comparable<T> {
	public int compareTo(T o)
}
```
