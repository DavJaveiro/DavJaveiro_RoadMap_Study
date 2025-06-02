## 1. Estrutura do Projeto
### 1.1 Dependências:
**Spring Actuator**:
Para resolução *4. Observabilidade*, 

**Spring Web**:
 Conjunto de módulos e funcionalidades dentro do ecossistema Spring dedicados à criação de aplicações web e *APIs RESTful* em Java. O módulo mais proeminente e central aqui é o Spring MVC (Model-View-Controller).
 1. **Spring MVC:**
	- O que é? É um framework robusto e flexível que implementa o padrão de design Model-View-Controller para aplicações web. Ele <span style="background:#b1ffff">fornece uma arquitetura clara para separar as responsabilidades da nossa aplicação</span>.
	- **DispatcherServlet:** é o coração do Spring MVC. Trata-se de um *front controller* que intercepta todas as requisições HTTP de entrada. Ele consulta manipuladores *handlers* e adaptadores para decidir qual controller deve processar a requisição e, em seguida, direciona a resposta de volta ao cliente, muitas vezes renderizando uma view.
	


**Projeto Lombok** 
Visando reduzir drasticamente a quantidade de código *boilerplate* (código repetitivo e previsível) que os desenvolvedores precisam escrever. Ele funciona "conectando-se" ao processo de compilação e gerando automaticamente métodos Java comuns, como **getters**, **setters**, **constructores (toString()), equals(), hashCode()**, entre outros, com base em anotações que adicionamos ao nosso código.

1. **Principais anotações e o que elas fazem:**
	- **@Getter** e **@Setter**: geram os métodos getter e setter para os campos.
	- **@ToString**: gera uma implementação do método **toString()**, exibindo o nome da classe e os valores dos campos.
	- **@EqualsAndHashCode**: gera os métodos **equals()** e **hashCode()** com base nos campos da classe, fundamental para coleções e comparações.
	
	**Construtores**:
	- **@NoArgsConstructor**: Gera um construtor sem argumentos
	- **@RequiredArgsConstructor**: Gera um construtor com argumentos para campos *final* ou marcados com *@NonNull* que não foram inicializados.
	- **@AllArgsConstructor**: gera um construtor com argumentos para todos os campos da classe.

## 2. TransacaoService
Complementar mais sobre a classe SERVICE

```java
@Service
@RequiredArgsConstructor
public class TransacaoService {
	
}
```


## 3. DTO
Podemos criar o DTO de duas formas:
### 3.1 record TransacaoRequestDTO
```java
public record TransacaoRequestDTO(Double valor, OffSetDateTime dataHora){}
```
**Vantagens:**
1. <span style="background:#b1ffff">Menos código</span>: o record já cria os **getters**, **equals**, **hashCode** e **toString** automaticamente.
2. **Imutabilidade por padrão:** os campos de um **record** são **final**. Isso ajuda a evitar efeitos colaterais em funções. 
3. **Sem boilerplate:** não precisamos de construtores, getters, nem sobrescrever métodos.
4. **Sem necessidade de Lombok:** é nativo do Java
5. **Mais seguro e conciso:** ideal para DTOs, mensagens de eventos, ou objetos de request/response.

**DesVantagens:**
1. Sem validação via anotações diretas em frameworks mais antigos:
	- Ex: as anotações **@NotNull**, **@DecimalMin**, etc, fucionam, mas devem ser colocadas diretamente nos parâmetros do record:
```java
public record TransacaoRequestDTO(@NotNull @DecimalMin("0.0") Double valor, @NotNull OffSetDateTime datahora) {

}
```

### 3.2 Classe Padrão
```java
public class TransacaoRequestDTO() {
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
	private Double valor;

	@NotNull
	private OffSetDateTime dataHora;


	public Double getValor() {
		return valor;
	}

	public OffSetDateTime getDataHora() {
		return dataHora;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
}
```

**Vantagens**:
1. Mais flexível:
	- Pode fazer lógica no construtor ou nos setters
	- Pode ter métodos auxiliares, como *toEntity()*, *isValidDate()*, etc.

2. Mais compatível com frameworks antigos ou bibliotecas específicas
3. Fácil de modificar se o DTO evoluir para ter mais comportamentos.

parei em 28:10 minutos de vídeo