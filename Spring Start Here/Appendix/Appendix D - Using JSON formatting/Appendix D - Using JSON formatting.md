Neste apêndice, discutimos o JavaScript Object Notation (JSON). JSON é uma forma frequentemente utilizada para formatar os dados trocados entre aplicativos em requisições e respostas HTTP ao usar endpoints REST para comunicação. Como os endpoints REST são um dos métodos mais comuns para estabelecer comunicação entre aplicativos, e o JSON é a principal maneira de formatar esses dados, entender e saber como usar essa formatação é essencial.

Neste apêndice, discutimos o JavaScript Object Notation (JSON). JSON é uma forma frequentemente utilizada para formatar os dados trocados entre aplicativos em requisições e respostas HTTP ao usar endpoints REST para comunicação. Se precisarmos representar esses dados em um JSON, precisamos levar em consideração as seguintes regras ou etapas:
- Para definir uma instância de objeto em JSON, usamos chaves {}
- Dentro das chaves, enumeramos os pares de atributo-valor, separando-os com vírgulas;
- Os nomes dos atributos são escritos entre aspas duplas "" 
- Os valores do tipo string são escritos entre aspas duplas "", qualquer aspas duplas dentro da string precisa ter uma barra invertida \ 
- Os valores numéricos são escritos sem aspas;
- O nome do atributo e seu valor são separados por dois pontos :

A Figura D.2 abaixo representa a instância de um produto no JSON formatada com o *atributo* name do tipo **chocolate** e o preço *5*:

![[Appendix D - Using JSON formatting.png]]
Em JSON, o próprio objeto não tem um nome ou um tipo. Em nenhuma lugar se afirma que o trecho descreve um produto. <span style="background:#d4b106">Os únicos elementos relevantes do objeto são seus atributos</span>. A figura D.2 detalha as regras do JSON para descrever um objeto. 

Um objeto pode conter outra instância de objeto como valor de um de seus atributos. Se o Produto tem uma Embalagem e a Embalagem é um objeto descrito por seu atributo cor, então uma representação de uma instância de Produto seria:
```json
{
	"nome": "chocolate",
	"preco": 5,
	"embalagem": {
		"cor": "azul"
	}
}
```

A mesma regra se repetem. Podemos ter vários atributos representando outros objetos e aninhá-los quantas vezes precisarmos.

Se quisermos definir uma coleção de objetos JSON, usamos colchetes [] e separamos as entradas com vírgulas. O próximo trecho de código mostra como definir uma coleção que contém duas instâncias de **Produto**:
```json
[
	{
		"nome": "chocolate",
		"preco": 5
	},
	{
		"nome": "bala",
		"preco": 3
	}
]
```

