
## Tratamento de Exceções:
- Evitar expor tech stack em nossa API (devemos tratar todos os erros de nossa API quanto possíveis, usando EXCEPTION HANDLING):

- [ ] **400 Bad Request** - evitar #payload incompleto/incorreto ao criar algum produto: podemos realizar essas validações utilizando o *Jakarta Validation*, utilizando as anotações *@NotNull, @NotBlank, @MinSize...* Adicionamos o *@Valid* no nosso PostMapping e depois adicionamos o código para capturar as exceções em nosso Global Exception Handler:
[[CourseTrackerGlobalExceptionHandler.java]]

As validações @NotNull, @NotBlank, são adicionadas nos DTOs. 


- [ ] **401 não autorizado** (não autenticado);


- [ ] **403 sem autorização** (sem autorização);


 - [ ] **404 Not Found** - caso tente encontrar, deletar ou editar um produto que não existe;


 - [ ] **429 Too Many Requests** - impor uma taxa de requisições (normalmente tratado por um gateway);

Tais tratamentos são realizados dentro da classe *ServiceImpl*.

## DTOs
O consenso é que os DTOs pertencem às camadas mais externas da aplicação, servindo como contratos de dados para a comunicação com o mundo exterior, como APIs REST, clientes de mensageria ou interfaces de usuário. Eles não devem ser confundidos com as entidades de domínio, que representam o núcleo do negócio e contêm as regras de negócio.

A principal função dos DTOs é  modelar os dados que serão enviados ou recebidos, permitindo a dissociação entre a representação interna do domínio e a exposição para os clientes. Isso evita o vazamento de detalhes de implementação e oferece flexibilidade para evoluir a API sem impactar o modelo de domínio.

**Abordagem Comuns para a Estruturação de Pastas**
Existem duas estratégias principais para organizar os DTOs em um projeto: por camada e por funcionalidade.

1. Organização por Camada: nesta abordagem, os DTOs são agrupados em uma pasta específica que reflete a sua responsabilidade na arquitetura.
2. Todo *record* é implicitamente final por padrão. Isso significa que o compilador já trata qualquer record como uma classe que não pode ser estendida (herdada).