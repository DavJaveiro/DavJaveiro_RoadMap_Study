1. Realizar o download do dump do banco de dados;
2. Criar uma instância MySQL no Docker com banco de dados *trilhante*;


## Meilisearch: 
3. Realizar a configuração do #Meilisearch: 
	Motor de busca ultrarrápido para pesquisar dados dentro da aplicação. Ele não **substitui o banco de dados**. Ele funciona como um **índice de busca** separado do banco de dados. 
	Sem Meilisearch, quando o usuário pesquisa algo:

"curso de java"
a aplicação consulta o **MySQL**:
```sql
SELECT * FROM cursos WHERE titulo LIKE '%java%'
```
Isso é **lento** quando existem muitos registros.

Com o Meilisearch, a aplicação faz:
buscar "java"
no índice de busca, que já está otimizado para isso.

Como resultado:
- Busca quase instantânea
- Ordenação por relevância
- autocomplete
- tolerância a erros de digitação

