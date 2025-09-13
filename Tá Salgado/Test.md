## Evitar
- *Field Injection* (**@Autowired**), pois é considerado uma má prática na maioria dos casos, justamente por dificultar testabilidade e esconder dependêmncias, <span style="background:rgba(74, 82, 199, 0.2)">constructor injection é melhor por design e testabilidade</span>...

## Annotation and beans
Anotações e beans são partes essenciais no desenvolvimento de nossas aplicações Spring. Eles são considerados os blocos de construção do Spring e tornam nosso código menos repetitivo (boilerplate) e mais fácil de manter (maintainable).

As anotações do Spring são usadas para definir os diferentes tipos de beans. Elas são simplesmente uma forma de metadados que marcam nosso código para fornecer informações. Por outro lado, os beans são objetos que são instanciados, criados e podem ser injetados com outros beans.

**Tipos de anotações**
As anotações do Spring são categorizadas em diferentes tipos, dependendo de sua funcionalidade. A seguir estão as anotações agrupadas em suas respectivas categorias.

**Core Annotations**
As anotações principais são usadas para potencializar o mecanismo de Injeção de Dependência (DI) do Spring em nossas aplicações. Elas podem ser encontradas nos pacotes *org.springframework.beans.factory.annotation* e *org.springframework.context.annotation*. A seguir, uma lista de anotações principais:
- @Required: é aplicada nos métodos setter de um bean e implica que a dependência deve ser injetada no bean durante a configuração. Caso contrário, uma exceção **BeanInitializationException** será lançada:
```java
public class Car {
	private String brand;
	@Required
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public Integer getBrand() {
		return brand;
	}

}
```
No exemplo anterior, podemos ver que o método setBrand() foi anotado com *@Required*; isso indica que a propriedade brand deve ser preenchida na inicialização.

- **@Autowired**: já encontramos a anotação auwotired, e ela é usada principalmente para injetar dependências sem o uso de construtores e métodos setter. Vejamos o exemplo a seguir de como usar a anotação *@Autowired:*
- 