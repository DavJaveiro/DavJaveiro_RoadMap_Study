
## Tratamento de Exceções:
- Evitar expor tech stack em nossa API (devemos tratar todos os erros de nossa API quanto possíveis, usando EXCEPTION HANDLING):

- [ ] **400 Bad Request** - evitar #payload incompleto/incorreto ao criar algum produto;


- [ ] **401 não autorizado** (não autenticado);


- [ ] **403 sem autorização** (sem autorização);


 - [ ] **404 Not Found** - caso tente encontrar, deletar ou editar um produto que não existe;


 - [ ] **429 Too Many Requests** - impor uma taxa de requisições (normalmente tratado por um gateway);

Tais tratamentos são realizados dentro da classe *ServiceImpl*.