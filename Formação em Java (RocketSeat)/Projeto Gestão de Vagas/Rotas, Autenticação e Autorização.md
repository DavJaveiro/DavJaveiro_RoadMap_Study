Para que serve o pacote Modules
O pacote ou diretório chamado modules pode conter vários módulos independentes, cada um com suas próprias dependências e responsabilidades. Isso é útil para:

- Organização do projeto: facilita a separação por domínio ou funcionalidades(ex: module-user, module-payments).
- Encapsulamento: os módulos expõem apenas o que precisa ser acessado por outros, escondendo implementação interna.
- Melhoria na manutenção: alterações em um módulo têm menos impacto nos demais.
- Reutilização: módulos podem ser reaproveitados em outros projetos.
- Segurança e controle de acesso: com module-info.java, definimos quais pacotes um módulo expõe e para quem.

Estrutura típica:
project-root/
├── modules/
│ ├── user/
│ │ ├── src/
│ │ └── module-info.java
│ ├── payments/
│ │ ├── src/
│ │ └── module-info.java

Cada pasta representa um módulo que pode conter seu próprio código-fonte, recursos e um arquivo module_info.java, que é onde declaramos:

module user {

exports com.exemplo.user;

requires payments;

}

Quando usar módulos?

Podemos começar a modularizar projetos quanto:

- Eles estão ficando grandes e difíceis de manter
- Há partes que podem ser reutilizadas em outros sistemas
- Quando queremos limitar as dependências entre partes do sistema

Padrões de mensagens de commit

Usar mensagens de commit padronizadas ajuda o time a entender rapidamente o que foi feito e por que.. No caso, seguindo o Git Flow, uma boa prática é usar convenções escritas e prefixos semânticos:

Formato básico recomendado:

< tipo>: <descrição sucinta e imperativa>

Exemplo:

feat: adiciona endpoint de cadastro de vagas

🏷️ Tipos mais comuns de commit

| Tipo | Significado | Exemplo |

| feat | Nova funcionalidade | feat: cria tela de listagem de empresas |

| fix | Correção de bug | fix: corrige erro de autenticação JWT |

| docs | Mudanças em documentação | docs: atualiza README com instruções |

| style | Alterações visuais ou de formatação de código | style: aplica padrão de indentação |

| refactor | Refatoração sem mudar comportamento externo | refactor: extrai lógica em service |

| test | Adição ou modificação de testes | test: adiciona teste unitário de vagas |

| chore | Tarefas gerais (atualizar dependências, configs) | chore: atualiza versão do Spring Boot |

| perf | Melhorias de desempenho | perf: otimiza consulta de vagas |

| build | Alterações no processo de build ou ferramentas CI | build: configura GitHub Actions |

| ci | Mudanças na configuração de integração contínua | ci: ajusta trigger do pipeline |

Complementos opcionais

Podemos adicionar mais contexto com escopos ou ticket IDs:

feat(vagas): adiciona ordenação por data [#15]

Dicais finais

- Considere adotar um linter de commits, como o Commitlint, para validar esses padrões automaticamente.

Formatando mensagem de validação

Criamos um package #exceptions e uma classe chamada ExceptionHandler, e dentro desta classe, usamos a anotação @ControllerAdvice.

A anotação @ControllerAdvice no Spring Boot é usada para tratar exceções de forma global, centralizando a lógica de tratamento de erros e evitando repetição de código em vários controllers. Ela permite:

1. Manipular exceções de todos os controllers em um único lugar.
2. Personalizar respostas de erro (HTTP status, mensagens, etc).
3. Aplicar comportamento globais, como validação ou logging.

Funcionamento Básico:

Quando uma exceção é lançada em qualquer controller, o Spring busca no @ControllerAdvice um método anotado com @ExceptionHandler que corresponda ao tipo da exceção.

Quando Usar:

- Validação de dados: para padronizar respostas de erro quando @Valid falhar
- Exceções customizadas: Ex: UsuarioNaoEncontradorException
- Loggin centralizado: Registrar erros em um serviço de monitoramento.

Vantagens:

- Código limpo: elimina a necessidade de blocos try-cath repetitivos;
- Consistência: respostas de erro uniformes em toda a API;

Diferença para @RestControllerAdvice:

É uma variação que combina @ControllerAdvice + @ResponseBody, evitando a necessidade de anotar métodos com @ResponseBody:

Quando Usar @ControllerAdvice ou @RestControllerAdvice

Ambas as anotações servem para tratar exceções globalmente, mas a escolha depende do tipo de resposta que a nossa API retorna:

- @ControllerAdvice - Quando a nossa aplicação mistura respostas HTTP (REST) e views (HTML, Thymeleaf, JSP). Apis não 100% REST (ex: aplicações web que retorna HTML + JSON);
- @RestControllerAdvice - Quando a nossa aplicação é puramente REST (sempre retornando JSON/XML). Microsserviços, APIs RESTful modernas (Spring Boot + React/Angular).

@RestControllerAdvice (Recomendado para APIs REST)

Herda @ControllerAdvice + @ResponseBody.

Todos os métodos já tratam respostas como JSON/XML (sem necessidade de @ResponseBody).

Padrão em APIs modernas.

Exemplo:

java

@RestControllerAdvice

public class GlobalExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)

@ResponseStatus(HttpStatus.BAD_REQUEST) // HTTP 400

public Map< String, String > handleValidationErrors(MethodArgumentNotValidException ex) {

Map< String, String > errors = new HashMap< >();

ex.getBindingResult().getFieldErrors().forEach(error ->

errors.put(error.getField(), error.getDefaultMessage()));

return errors; // Retorno automático como JSON

}

}

Resposta:

json

{

"username": "Username inválido",

"email": "E-mail é obrigatório"

}

@ControllerAdvice (Para Aplicações Híbridas)

Necessário se você precisa retornar views (HTML) ou redirecionamentos.

Requer @ResponseBody nos métodos que retornam JSON.

Exemplo:

java
@ControllerAdvice
public class GlobalExceptionHandler {}

 Retorna JSON (para APIs)

```java
@ResponseBody
@ExceptionHandler(UsuarioNaoEncontradoException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ErrorResponse handleUserNotFound(UsuarioNaoEncontradoException ex) {
return new ErrorResponse(ex.getMessage())
}
```

// Retorna uma view HTML (para erros front-end)
```java
@ExceptionHandler(Exception.class)
public String handleGenericError(Exception ex, Model model) {
model.addAttribute("error", ex.getMessage());
return "error-page"; // Nome do template Thymeleaf/JSP
}
}
```

Regra Prática:

Use #RestControllerAdvice se:
Sua aplicação é 100% API REST (Spring Boot + React/Angular/Vue).
Você sempre retorna JSON/XML.

Use #ControllerAdvice se:
Você tem partes da aplicação que renderizam HTML (ex: painel administrativo com Thymeleaf).

Precisa de flexibilidade para retornar diferentes tipos de resposta.

Resumo Final:
Aplicação Web (HTML + JSON) @ControllerAdvice
API REST pura (JSON/XML) @RestControllerAdvice
Microsserviços @RestControllerAdvice

### **Explicação Detalhada sobre `MessageSource`**

O `MessageSource` é uma interface do Spring usada para **internacionalização (i18n)** e **mensagens de validação customizadas**. No contexto do seu `ExceptionHandler`, ele permite:

1. **Traduzir mensagens de erro** para diferentes idiomas (ex: PT, EN, ES).

2. **Personalizar mensagens** sem hardcode (usando arquivos `.properties`).

3. **Resolver mensagens** dinamicamente com base no `Locale` (região do usuário).

---

### **Como Funciona no Seu Código**:

```java

private MessageSource messageSource; // Injetado pelo Spring

@ExceptionHandler(MethodArgumentNotValidException.class)

public void handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

ex.getBindingResult().getFieldErrors().forEach(error -> {

// Obtém a mensagem traduzida/com base no Locale

String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

System.out.println(message); // Exemplo: "Username é obrigatório"

});

}

```

---

### **Passo a Passo**:

1. **`MessageSource.getMessage()`**:
- Busca a mensagem associada ao erro (`error`) no arquivo de propriedades.
- Usa o `Locale` (idioma) atual do sistema (ex: `pt_BR`, `en_US`).

2. **`LocaleContextHolder.getLocale()`**:
- Retorna o **Locale configurado na aplicação** (gerenciado pelo Spring).

3. **Arquivos de Mensagens**:
- As mensagens são definidas em arquivos como:
- `messages.properties` (padrão)
- `messages_pt_BR.properties` (português)
- `messages_en_US.properties` (inglês)
### **Exemplo Prático**:

#### **1. Defina as mensagens** (em `src/main/resources/messages.properties`):

```properties

# Mensagens de validação

NotBlank.candidateEntity.username=Username é obrigatório

Pattern.candidateEntity.username=Username deve conter 3 a 20 caracteres (sem espaços)

```

#### **2. Configure o `MessageSource`** (em uma classe `@Configuration`):

```java

@Bean

public MessageSource messageSource() {

ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

messageSource.setBasename("classpath:messages"); // Nome base dos arquivos

messageSource.setDefaultEncoding("UTF-8");

return messageSource;

}

```

#### **3. Resultado**:

- Se o `Locale` for `pt_BR`, a mensagem será:

`"Username é obrigatório"`.

- Se for `en_US` (e houver um `messages_en.properties`), será:

`"Username is required"`.
### **Quando Usar?**
- **APIs multilíngues**: Para suportar vários idiomas nas respostas de erro.

- **Mensagens customizadas**: Evitar mensagens genéricas do Spring (ex: `"must not be blank"`).

- **Validações complexas**: Mensagens específicas para cada campo.
### **Dica Avançada**:
Para retornar as mensagens como resposta da API (em um `@RestControllerAdvice`):

```java
@ControllerAdvice  
public class ExceptionHandlerController {  
  
    private MessageSource messageSource;  
    public ExceptionHandlerController(MessageSource messageSource) {  
        this.messageSource = messageSource;  
    }  
    @ExceptionHandler(MethodArgumentNotValidException.class)  
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArggumentNotValidException(MethodArgumentNotValidException exceptionHandler) {  
        List<ErrorMessageDTO> dto = new ArrayList<>();  
        exceptionHandler.getBindingResult().getFieldErrors().forEach(error -> { 
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());  
            dto.add(new ErrorMessageDTO(error.getField(), message));  
        });        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);  
    }}

```

**Saída**:
```json
{
"username": "Username é obrigatório",
"email": "E-mail inválido"
}
```

### Resumo:
| Componente            | Função                                                      |
| --------------------- | ----------------------------------------------------------- |
| `MessageSource`       | Acessa mensagens de arquivos `.properties`.                 |
| `LocaleContextHolder` | Define o idioma atual (ex: `pt_BR`).                        |
| `getMessage()`        | Resgata a mensagem traduzida/com base no erro de validação. |
|                       |                                                             |
|                       |                                                             |

## Inserindo Spring Data JPA

