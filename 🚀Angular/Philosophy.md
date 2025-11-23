A filosofia do Angular é centrada em um conjunto de ideias que orientam como aplicações web modernas devem ser construídas: estruturadas, previsíveis, escaláveis e sustentáveis ao longo do tempo. O Angular não é apenas um framework, é um **ecossistema completo** com opinião forte (*opinionated framework*). 

### 1. Opinionated Framework (fortemente opinativo)
O Angular oferece **um caminho único e bem definido** para construir aplicações.
Isso reduz decisões arquiteturais e cria consistência:
- Estrutura padrão de projeto (*src/app*, módulos, componentes);
- Convenções claras para código
- Ferramentas integradas (CLI, builder, testes)
*Ideia:* "Se todos seguirem a mesma estrutura, qualquer desenvolvedor consegue entender o projeto."

### 2. Tudo baseado em Componentes
Angular adota uma arquitetura **component-based**, onde a aplicação é formada por blocos reutilizáveis contendo:
- HTML
- CSS
- Lógica de apresentação (TS)
*Ideia:* componentes pequenos e independentes criam sistemas grandes e fáceis de manter.

## 3. Programação Reativa
O Angular se baseia fortemente no **RxJS**, incentivando programação orientada a eventos:
- Streams de dados
- Transformações reativas
- Detecções de mudanças previsível
*Ideia:* "A web é assíncrona; então, o código precisa ser reativo."

## 4. Forte Integração entre Ferramentas
Parte fundamental da filosofia é: *o desenvolvedor não deve montar o ecossistema manualmente*.

Por isso o Angular entrega:
- Angular CLI (scaffolding, build, deploy, test). #Scaffolding é uma técnica de geração automática de código que cria a estrutura básica e repetitiva de uma aplicação. Assim como andaimes (significado literal de *scaffolding*), sustentam uma construção, essa técnica oferece um esqueleto do projeto, permitindo que os desenvolvedores se concentrem na lógica de negócio e nas funcionalidades específicas.
- Angular Material
- Ferramentas de i18n
- Testes integrados com Jasmine/Karma
- Schematics
*Ideia:* "um só framework deve atender todo o ciclo de desenvolvimento."

## 5. Segurança como padrão
Angular inclui proteções nativas:
- Sanitização automática contra XSS
- Binding seguro
- Rotas com guards
- Mecanismos de autenticação padronizados
*Ideia:* "Segurança não deve depender apenas do cuidado do programador."

## 6. Arquitetura baseada em módulos
Apesar das mudanças para Standalone Componentes, a filosofia tradicional sempre valorizou:
- Organização modular
- Encapsulamento lógico
- Lazy loading
Para aplicações grandes, continua sendo um dos pilares.
*Ideia:* "particionar a aplicação reduz complexidade e melhora performance."

**O que mudou com Standalone Components no Angular?**
Até o Angular 13/14, **toda aplicação Angular era obrigatoriamente organizada em módulos** #NgModule. 
Exemplo:
- #AppModule
- #HomeModule
- #SharedModule
- #AuthModule 

Os módulos eram necessários para:
- declarar componentes
- importar outros módulos
- organizar a aplicação
- permitir lazy loading

**🚀 Introdução dos Standalone Components**
A partir do Angular 14, o framework introduziu os **Standalone Componentes**, que são componentes que:
- não precisam ser declarados em um módulo
- conseguem importar diretamente outros componentes
-  podem ser usados para iniciar a aplicação
- reduzem a complexidade do projeto


## 7. Escalabilidade e Manutenibilidade
O Angular foi criado pensando em **grandes aplicações empresariais:**
- Tipagem forte com TypeScript
- Arquitetura rígida
- Padrões de projetos claros
- Build otimizado
*Ideia:* "Leitura e manutenção são prioridades maiores que simplicidade inicial."

## 8. Suporte de Longo Prazo (LTS)
O Angular oferece:
- Atualizações regulares e previsíveis
- Compatibilidade gradual
- Documentação robusta
*Ideia:* "Empresas precisam de estabilidade, não de moda."

## 9. Separação clara entre lógica, template e estilos
Angular preserva um modelo clássico MVC-like:
- Template (HTML)
- Lógica (TS)
- Estilo (CSS/SCSS)
*Ideia:* "Separar responsabilidades evita caos."

## 10. Framework completo > biblioteca
Ao contrário do React, o Angular não deixa vazio nenhum pedaço da stack:
- Roteamento nativo
- HttpClient nativo
- Formulário reativos
- Animações
- Injeção de dependência integrada
*Ideia:* "O framework precisa ser autosuficiente."

---
## Components in Angular

