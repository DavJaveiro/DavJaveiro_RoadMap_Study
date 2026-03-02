Antes de falarmos sobre Facade, precisamos entender sobre Adapter, pois o Facade não vai resolver problemas de incompatibilidade, tradução de interface e conectar coisas que não se encaixam, logo, antes de entendermos como simplificarmos o nosso sistema, precisamos saber como **conectar** as partes do nosso quebra-cabeça. O Facade pressupõe que os nossos componentes já conseguem conversar entre si.

### Adapters all around us
Sabemos muito bem o que um adaptador faz: ele fica entre o plugue do nosso notebook e a tomada; a sua função é clara, adaptar a tomada britânica para que ela possa conectar ao leptop e o notebook.

Mas e os adaptadores orientados a objetos? Os adaptadores OO desempenham o mesmo papel que seus equivalentes no mundo real: eles pegam uma interface e a adaptam à interface que o cliente está esperando. 

Podemos realizar uma analogia na Biologia, O Adapter na biologia é como um mediador molecular que permite que duas estruturas incompatíveis consigam interagir. 

Temos um problema claro:  
O antibiótico original costuma funcionar da seguinte maneira (de forma simplificada):
`Antibiótico -> liga-se na bactéria -> ativa o mecanismo de destruição`
Porém, a bactéria possuí a capacidade de adaptar-se (evolução):
- O ponto de ligação do antibiótico na superfície bacteriana mudou;
- O antibiótico não encaixa mais;
- A "interface biológica" ficou incompatível.

**A solução: uma nova molécula #adaptadora**
Estudando e tentando compreender os novos mecanismos de funcionamento e reconhecimento bacteriano, os cientistas conseguiram criar uma nova molécula que:
1. Consegue se ligar à nova superfície da bactéria;
2. Consegue ativar o mecanismo antigo de destruição

Mas, precisamos deixar claro que:
Ela não é o antibiótico original
Não é uma outra bactéria
Não é um intermediário

...
Com essa analogia, podemos traduzir ela para o universo do desenvolvimento e arquitetural de software:
O sistema de destruição -> Cliente
Antibiótico Antigo - Interface esperada
Bactéria Resistente - Uma classe incompatível
Molécula adaptadora - Adapter.

O #Adapter resolve **incompatibilidade de interface**.

## Object-oriented adapters
Digamos que tenhamos um sistema de software existente no qual precisemos trabalhar com uma biblioteca de classes de um novo fornecedor, mas o novo fornecedor projetou suas interfaces de forma diferente de forma diferente do último fornecedor:
!![image-2026315533381.png](/image-2026315533381.png)

Não quero resolver o problema alterando o nosso código existente ( e não podemos alterar o código do fornecedor). Então, o que devemos fazer? Bom, podemos escrever uma classe que adapte a nova interface do fornecedor àquela que estamos esperando. 

!![image-20263126536.png](/image-20263126536.png)

O adaptador atua como um intermediário, recebendo solicitações do cliente e convertendo-as em solicitações que fazem sentido nas classes do fornecedor.

Adaptando para classe pato:
```java
public interface Duck {
	public void quack();
	public void fly();
}
```

Here's a subclass of Duck, the MallardDuck:
```java
public class MallarDuck implements Duck {
	public void quack() {
		System.out.println("Quack");
	}
	
	public void fly() {
		System.out.println("I'm flying");
	}
}
```

Its a newest fowl on the block:
```java
public interface Turkey {
	public void gobble(); // Turkeys don't quack, they gobble
	public void fly(); // turkeys can fly, although they can only fly short distances;
}
```

```java
public class WildTurkey implements Turkey {
	public void gobble() {
		System.out.println("Gobble gobble");
	}
	
	public void fly() {
		System.out.println("I'm flying a short distances");
	}
}
```


Now, let's say our're short on Duck objects and like to use some Turkey objects in their place. Obviously we can't use the turkeys outright because they have a different interface.

```java
public class TurkeyAdapter implements Duck {
	Turkey turkey;
	
	// Guardamos a referência do objeto adaptador
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	public void quack() {
		turkey.gobble();
	}
	
	public void fly() {
		for(int i=0; i <5; i++) {
			turkey.fly();
		}
	}
}
```
1. Primeiro, precisamos implementar a interface do tipo ao qual estamos adaptando-se. Essa é a interface que o nosso cliente espera ver.
2. Em seguida, precisamos obter uma referência ao objeto que estamos adaptando; fazemos isso por meio do construtor;
3. Agora, precisamos implementar todos os métodos da interface; a tradução de quack() entre classes é fácil: basta chamarmos o método globble();
4. Embora ambas as interfaces tenham um método fly(), os perus voam em curtos períodos, eles não podem voar a longa distância como os patos. Para mapear entre o método fly() de um pato e de um peru, precisamos chamar o método fly() do peru cinco vezes para compensar.

Portanto, o cliente continua usando Duck, o cliente não sabe que está usando um *Turkey*, não alteramos nenhuma das duas classes originais.

Portanto, em geral, um Adapter faz com que uma *interface* adaptada seja compatível com outra, dessa forma fornecendo uma abstração uniforme de diferentes interfaces. 

Adapter também pode ser reconhecido como *Wrapper*.

### Test drive the adapter
Agora, só precisamos de algum código para testarmos o nosso adaptador:

1. O cliente faz uma solicitação ao adaptador chamando um método nele usando a interface de destino;
2. O adaptador converte a solicitação em uma ou mais chamadas no adaptador usando a interface do adaptador;
3. O cliente recebe os resultados da chamada e nunca sabe que há um adaptador fazendo a tradução.

## Adapter Pattern Defined
O padrão Adapter converte a interface de uma classe em outra interface esperada pelos clientes. O adaptador permite que as classes trabalhem juntas, o que não seria possível devido a interfaces incompatíveis.

Agora, sabemos que esse padrão nos permite usar um cliente com uma interface incompatível criando um adaptador que faz a conversão. Isso age para desacoplar o cliente da interface implementada e, se esperamos que a interface mude com o tempo, o adaptador encapsula essa mudança para que o cliente não precise ser modificado toda vez que precisar operar com uma interface diferente.

Já demos uma olhada no comportamento do padrão em tempo de execução; vamos dar uma olhada também em seu diagrama de classes;

O padrão Adapter está repleto de bons princípios de design orientado a objetos: veja o uso da composição de objeto para envolver o adaptador com uma interface alterada. Essa abordagem tem a vantagem adicional de podermos usar um adaptador com qualquer subclasse do adaptador. Verifique também como o padrão vincula o cliente a uma interface, não a uma implementação; poderíamos usar vários adaptadores, cada um convertendo um conjunto de classes de backend diferente. Ou poderíamos adicionar novas implementações após o fato, desde que elas aderissem à interface Target.

### Object and class adapters
Agora, apesar de termos definido o padrão, ainda não lhe contamos toda a história. Na verdade, há dois tipos de adaptadores: adaptadores de objeto e adaptadores de classe. 

Este capítulo abordou os adaptadores de objeto, e o diagrama de classe na página anterior é um diagrama de um adaptador de objeto. Então, o que é um adaptador de classe e por que não falamos sobre ele? Porque precisamos de herança múltipla para implementá-lo, o que não é possível em Java. 

Parece familiar? A única diferença é que, com um adaptador de classe, subclassificamos o Target e o Adaptee, enquanto com um adaptador de objeto usamos a composição para transmitir solicitações a um Adaptee.

## Real-world adapters
Vamos dar uma olhada no uso de um adaptador simples no mundo real (algo mais sério do que o Ducks, pelo menos)...

**Enumertors**
Devemos nos lembrar que os primeiros tipos de coleção (Vector, Stack, Hashtable e alguns outros) implementam um método elements(), que retorna um Enum. A interface Enumeration permite que percorramos os elementos de uma coleção sem saber os detalhes de como eles são gerenciados na coleção.

Ela é extremamente simples e possui apenas dois métodos:
1. *hashMoreElements()*: o equivalente ao *hasNext()*;
2. *nextElement():* o equivalente ao *next()*;

**Iterators**
As classes Collection mais recentes usam uma interface Iterator que, como a interface Enumeration, permite iterar por um conjunto de itens em uma coleção e adiciona a capacidade de remover itens.
```java
public interface Iterator<E> {
	// Returns true if the iteration has more elements. (In other words, returns true if next would return an element rather tahn throwing an exception.)
	boolean hasNext();
	
	E next();
	
	default void remove() {throw new UnsupportedOperationExcep[tion("remove");}
}
```

### Using Enumerators with code that expects Iterators
Às vezes, nos deparamos com código legado que expõe a interface Enumeration, mas gostaríamos que nosso novo código usasse apenas Iterators. Parece que precisamos criar um adaptador.

## Adapting an Enumeration to an Iterator
Primeiro, examinaremos as duas interfaces para descobrir como os métodos são mapeados de uma para a outra. Em outras palavras, descobriremos o que chamar no adaptador quando o cliente invocar um método no destino.

!![image-2026314310476.png](/image-2026314310476.png)

**Design the Adapter**
Veja como as classes devem ser: precisamos de um adaptador que implemente a interface Target e seja composto por um adaptador. Os métodos hasNext() e next() serão fáceis de mapear do target para o adapte: basta passá-los diretamente. Mas o que fazer com o remove()? 
!![image-20263145360.png](/image-20263145360.png)

**Dealing with the remove() method**
Bem. sabemos que a Enumeration não oferece suporte a remove(). É uma interface 'somente leitura'. Não há como implementar um método remove() totalmente funcional no adaptador. O melhor que podemos fazer é lançar uma exceção em tempo de execução. Felizmente, os criadores da interface Iterator previram essa necessidade e definiram o método remove() de modo que ele seja compatível com UnsupportedOperationException. Esse é um caso em que o adaptador não é perfeito; os clientes terão de ficar atentos a possíveis exceções, mas, desde que o cliente seja cuidadoso e o adaptador esteja bem documentado, essa é uma solução perfeitamente razoável.

```java
public class EnumerationIterator implements Iterator<Object> {
	Enumeration<?> enumeration;
	
	public EnumerationIterator(Enumeration<?> enumeration) {
		this.enumeration = enumeration;
	}
	
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}
	
	public Object next() {
		return enumeration.nextElement();
	}
	
	public void remove() {
		thorw new UnsupportedOperationException();
	}
}
```

## Aplicabilidade
Use o padrão Adapter quando:
- quisermos usar uma classe existente, mas a nossa interface não corresponder à interface que precisamos; 
- quando quisermos criar uma classe reutilizável que coopere com classes não-relacionadas ou não-previstas, ou seja, classes que não necessariamente tenham interfaces compatíveis;
- (somente para adaptadores de objetos)

Portanto, um adaptador de classe usa a herança múltipla para adaptar uma interface à outra.

No nosso exemplo acima, o **Target** é a interface com a qual queremos trabalhar no presente, que é o *Iterator< Object>*. Portanto, o *Iterator* é o alvo, pois ele define os métodos (hasNext, next) que o código moderno do Java consome. 

- **Adapter**: *EnumerationIterator*. Essa é a classe que escrevemos. O adapter implementa a interface, o nosso Target e envolve (wraper) do objeto que possui a interface incompatível. Ele traduz as chamadas de hasNext() para hasMoreElements() e de next() para nextElement();

- **Adaptee**: *Enumeration< ?>*. Este é o Adaptee. É a interface antiga (legada) que possui a funcionalidade que precisamos, mas cujo "encaixe" é incompatível com os novos Iterators.

- **Client**: o cliente seria qualquer classe ou método que utilize o nosso *EnumerationIterator*. 