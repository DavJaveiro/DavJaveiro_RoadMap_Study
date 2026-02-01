import http from 'node:http';

// Criar um usuário (name, email, senha)
// Rota para listagem de usuários
// Edição de usuário
// Remoção de usuários

const users = []

const server =  http.createServer((request, response) => {
    const { method, url} = request

    if (method === 'GET' && url === '/users') {
        return response
        .setHeader('Content-type', 'application/json')
        .end(JSON.stringify(users))
    }

    if (method === 'POST' && url === '/users') {
        users.push({
            id: 1,
            name: 'Carlos Petresco',
            email: 'Carlospetresco@gmai.com' 
        })
        return response.writeHead(201).end()
    }

    

    return response.writeHead(404).end()
})

server.listen(3333)

