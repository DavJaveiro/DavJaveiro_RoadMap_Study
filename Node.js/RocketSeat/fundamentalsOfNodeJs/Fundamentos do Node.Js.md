Para iniciarmos um projeto node, usamos o seguinte comando:
`npm init -y`, a flag **-y** é responsável por responder sim para todas as perguntas que o NPM nos fará.

No Node.js existem 3 origens possíveis para um *import*:
1. **Módulos nativos do Node (core modules)**
```node
import http from 'node:http'
```
ou
```node
import http from 'http'
```

Esses vêm do próprio Node, e não do nosso projeto e nem do *node_modules*.


🔎 Como reconhecer

| Forma                                 | O que significa                                                  |
| ------------------------------------- | ---------------------------------------------------------------- |
| `'node:http'`                         | ✅ **Módulo interno oficial do Node** (forma moderna e explícita) |
| `'http'`                              | ✅ Também é interno, mas forma antiga                             |
| `'fs'`, `'path'`, `'url'`, `'crypto'` | Todos são core modules                                           |
O prefixo *node:* foi criado para deixar *inegável* que é interno e evitar conflito com pacotes externos de mesmo nome.

2. **Pacotes externos (do npm)**
Exemplo:
```node
import express from 'express'
import _ from 'lodash'
import mongoose from 'mongoose'
```

Esses vêm de:
`node_modules/`
- O nome **não começa com `./` nem `../`**
- **Não é** um módulo nativo conhecido
- Está listado no `package.json`
```json
"dependencies": {
	"express":  "^4.18.0"
}
```

Se apagarmos *node_modules* e rodar **npm install**, ele baixará novamente. 

3. **Arquivos do nosso próprio projeto**
```js
import userService from './services/userServices.js'
import config from '../config/env.js'
```

**O Node não reinicia sozinho** quando mudamos o nosso código. Ele carrega o arquivo uma vez na memória e fica rodando aquele "snapshot" até o processor morrer.

**Solução certa: usar um "watcher" (auto-reload)**
- A opção mais usada: nodemon
```node
npm install -g nodemon
```

- Devemos rodar assim:
```java
nodemon server.js
```

**Alternativa moderna (Node 18+)**
O próprio Node já tem modo watch:
```bash
node --watch server.js
```

## Estrutura da aplicação
### Rotas de criação e listagem
**GET** => Buscar um recurso no back-end
**POST** => Criar um recurso no back-end
**PUT** => Atualizar um recurso no back-end
**PATCH** => Atualizar uma informação específica de um recurso no back-end.

#stateful 
#stateless 

**O servidor guarda memória do usuário entre requisições?**

**Stateful (com estado)**
O servidor lembra da gente.
Ele guarda informações da nossa sessão na memória ou em algum armazenamento ligado à sessão.
**Exemplo clássico**
Login tradicional com sessão:
1. Fazemos o login
2. Servidor cria uma sessão:
	1. sessao 123 -> usuário Davidson
3. Essa sessão fica guardada no servidor
4. Toda requisição depois disso usa aquele estado

**O servidor guarda coisas como**
1. Usuário logado
2. Carrinho de compras
3. Permissões
4. Progresso de jogo
5. Conexões abertas

**Stateless (Sem estado)**
O servidor não guarda nada entre requisições
Cada requisição é independente
Tudo que o servidor precisa saber vem **na própria requisição**

### Exemplo moderno:

API com **JWT**
1. Você faz login
2. Recebe um token
3. A cada requisição:
    `Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...`
4. O servidor valida o token e responde

Ele **não precisa lembrar de você**.

O que caracteriza stateless
- Não usa sessão no servidor
- Cada request carrega contexto
- Ideal para APIs REST

