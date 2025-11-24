In this chapter, we'll give an introduction to the concepts and principles of this book. A good way of summarizing the overall approach in *Practices and Principles over Technology.* There are already many books about specific technologies, and we aren't seeking to add to that enormous pile. 

## Themes
Ao longo do livro, usamos uma estrutura baseada em *project* para apoiar o aprendizado. Vale a pena refletir sobre os diferentes *themes* que percorrem os capítulos, como eles se conectam e por que os escolhemos. A seguir estão os quatro diferentes temas que se entrelaçam pelos capítulos.

Também veremos uma breve visão geral de expressões lambdas no Capítulo 3. Em seguida, *local variable type inferences* e *switch expressions* que serão explicadas no Capítulo 5, e finalmente *lambda expressions e method references* que serão abordados em detalhe no Capítulo 7. Os recursos da Java Language são importantes porque muito projetos de software são escritos em Java, então é útil conhecer seu funcionamento. Muitos desses recursos de *languages* também 

### Software Design and Architecture
Ao longo do livro, uma série de *padrões de design* são introduzidos para fornecer soluções comuns a problemas recorrentes que desenvolvedores enfrentam. É importante conhecê-los porque, mesmo que cada *software project* pareça diferente e traga seu próprio conjunto de desafios, na prática muito desses problemas já foram encontrados antes. Compreender problemas comuns e soluções já resolvidas por outros desenvolvedores evita que a gente "reinvente a roda" em um novo *software project* e permita entregar *software* mais rápido e de forma mais confiável.

Os conceitos de alto nível de *coupling* e *cohesion* são introduzidos logo no início, no Capítulo 2. O *Notification pattern* é apresentado no Capítulo 3. Como projetar uma *Fluent API* amigável e o **Builder pattern** são abordados no capítulo 5. Exploramos os conceitos de grande escala de _event-driven_ e _hexagonal architectures_ no Capítulo 6 e o _Repository pattern_ no Capítulo 7. Finalmente, você também é introduzido ao _functional programming_ no Capítulo 7.

### SOLID
Todos os princípios do SOLID são tratados ao longo de vários capítulos. Esses princípios foram criados para tornar o *software* mais fácil de manter. Embora gostemos de pensar que escrever *software* é a parte divertida, se o *software* que escrevemos for bem-sucedido, ele precisará evoluir, crescer e ser mantido. Tornar o *software* mais fácil possível de manter ajuda nessa evolução, manutenção e na adição de funcionalidades ao longo do prazo.

Os princípios *SOLID* e os capítulos em que são discutidos são:
- *Single Responsibility Principle (SRP)* - Capítulo 2
- *Open/Closed Principle (OCP)* - Capítulo 3
- *Liskov Substitution Principle (LS)* - Capítulo 4
- *Interface Segregation Principle (ISP)* - Capítulo 5
- *Dependency Inversion Principle (DIP)* - Capítulo 7

### Testing
Escrever _code_ confiável que possa ser facilmente evoluído ao longo do tempo é realmente importante.
*Automated tests* são fundamentais para isso. À medida que o software que escrevemos cresce em tamanho, torna-se cada vez mais difícil testar manualmente os diferentes casos possíveis. É necessário automatizar nossos processos de testing para evitar os dias de esforço humano que seriam necessários para testar seu _software_ sem essa automação.

Você aprende os conceitos básicos de escrita de _tests_ nos Capítulos 2 e 4. Isso é ampliado para _test-driven development (TDD)_ no Capítulo 5. No Capítulo 6, abordamos o uso de _test doubles_, incluindo _mocks_ e _stubs_.