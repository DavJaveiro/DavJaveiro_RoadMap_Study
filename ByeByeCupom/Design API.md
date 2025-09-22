## Padrões recomendados para nossa API
1. Input/Output Pattern
	1. Aplicação direta: entrada é o XML do CF-e, saída é o PDF + QR code.
	2. Endpoint sugerido:
		*POST/cupom/gerar*

2. **Error Handling Pattern**
	1. Por que usar? Para lidar com XMLs malformados, falhas na geração do PDF ou QR code.
	2. Exemplo de resposta de erro:
```json
{
	"error": "XML inválido",
	"code": 400
}
```

3. **Resource Linking Pattern**: para retornar o link do PDF e  do QR code de forma organizada. Exemplo de resposta:
```json
{
	"pdfUrl": "https://api.seusite.com/downloads/123.pdf",
  "qrCodeUrl": "https://api.seusite.com/qrcode/123.png",
  "_links": {
    "self": "/cupom/123
}
```

## O que o padrão oferece
Estamos usando um padrão claro: o **Input/Output Pattern**, onde o cliente envia um XML e recebe um link para o PDF + QR code. Esse padrão nos fornece:
- Estrutura previsível
- Facilidade de integração
- Clareza na documentação
- Reutilização em outros serviços similares 

## O que o padrão pode limitar
Mesmo sendo útil,  esse padrão pode **impor restrições**. Por exemplo:
- **Limitação funcional:** se quisermos que o PDF seja baixado diretamente no navegador sem passar por uma URL intermediária, o padrão pode não prever isso. Ele assume que o cliente vai receber uma URL e decidir quando e como baixar.
- **Complexidade adicional:** se quisermos permitir configurações como *usar papel A4 ou térmico*, incluir logotipo, escolher  idioma, etc., o padrão pode exigir campos extras e validações que tornam a API mais complexa.
-  **Consistência de dados:** o PDF for gerado com base em dados que mudam (como preços ou impostos atualizados), o padrão pode não garantir que o conteúdo esteja 100% sincronizado com o sistema original — especialmente se houver cache ou fila de processamento.