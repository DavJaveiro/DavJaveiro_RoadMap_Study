Podemos integrar o TypeScript em nossos projetos de várias maneiras, e todas são ligeiramente diferentes, dependendo das necessidades do projeto. Assim como o JavaScript é executado em muitos tempos de execução, há muitas maneiras de configurar o TypeScript para que ele atenda às necessidades do nosso alvo.

Este capítulo aborda todas as possibilidades de introduzir o TypeScript em nosso projeto, como uma extensão próxima ao JavaScript que oferece autocompletar básico e indicação de erros, até configurações completas para aplicativos de pilha completa no Node.js e no navegador. Como o ferramental JavaScript é um campo com infinitas possibilidades, alguns dizem que uma nova cadeia de compilação Java-Script é lançada a cada semana, quase tanto quanto novas estruturas, este capítulo se concentra mais no que podemos fazer apenas com o compilador TypeScript, sem nenhuma ferramenta extra.

O TypeScript oferece tudo o que você precisa para suas necessidades de transpilação, exceto a capacidade de criar pacotes minificados e otimizados para distribuição na Web. Bundlers como o ESBuild ou o WebPack cuidam dessa tarefa. Além disso, há configurações que incluem outros transpiladores, como o Babel.js, que podem funcionar bem com o TypeScript. Os empacotadores e outros transpiladores não fazem parte do escopo deste capítulo. 

Como o TypeScript é um projeto com mais de uma década de história, ele carrega alguns resquícios de tempos mais antigos dos quais, por uma questão de compatibilidade, não pode simplesmente se livrar. Portanto, este capítulo destacará a sintaxe moderna do JavaScript e os desenvolvimentos recentes nos padrões da Web.

## 1.1 Type-Checking JavaScript
**Problem**
Precisamos obter a verificação de tipo básica para JavaScript com o mínimo de esforço possível.

**Solução**
Adicione um comentário de linha única com <span style="background:#b1ffff">@ts-check </span>no início de cada arquivo JavaScript que deseja verificar. Com os editores certos, já obtemos linhas vermelhas onduladas sempre que o TypeScript encontra coisas que não batem certo.

**Discussion**
O TypeScript foi projetado como um superconjunto do JavaScript, e <span style="background:#affad1">todo JavaScript válido também é válido em TypeScript</span>. Isso significa que o TypeScript é muito bom em identificar possíveis erros em código JavaScript comum.

Podemos aproveitar isso se não quisermos configurar todo um ambiente TypeScript, mas quisermos algumas dicas básicas e verificações de tipos para facilitar nosso fluxo de desenvolvimento.

Um bom pré-requisito, caso queiramos verificar tipos em JavaScript, é ter um bom editor ou IDE. Um editor funciona bem com TypeScript é o VS Code. O Visual Studio Code — ou VSCode, para abreviar — foi o primeiro grande projeto a utilizar TypeScript, ainda antes do lançamento oficial do TypeScript.

Muitas pessoas recomendam o VSCode se desejamos escrever JavaScript ou TypeScript. 

Com o VSCode, temos uma coisa muito importante para a verificação de tipos em JavaScript: linhas vermelhas onduladas quando algo não está certo, como mostrado na Figura 1-1. Esse é o menor obstáculo de entrada. O sistema de tipos do TypeScript possui diferentes níveis de rigor ao trabalhar com uma base de código. 

Primeiro, o sistema de tipos tentará **inferir tipos a partir do uso do código JavaScript**. Se tivermos uma linha como essa em nosso código:
```js
let a_number = 1000;
```

O TypeScript irá inferir corretamente que o tipo de *a_number* é **number**.

Uma dificuldade com o JavaScript é que os tipos são dinâmicos. declarações com *let*, *var* ou *const* podem mudar de tipo dependendo do uso. Veja o exemplo:
```js
let a_number = 1000;
if (Math.random() < 0.5) {
	a_number = "Hello, World!";
}
console.log(a_number * 10);
```

Aqui, atribuímos um número *a_number* e depois mudamos a variável para uma string, caso a condição seja verdadeira. Isso não seria um grande problema se não tentássemos multiplicar *a_number* na última linha. Em aproximadamente 50% dos casos, esse exemplo produzirá um comportamento indesejado.

O Typescript pode ajudar nesse ponto. Com a adição de um **comentário de uma linha** com *@ts-check* no topo do arquivo JavaScript, o TypeScript ativa o próximo nível de rigor: **verificação de tipos em arquivos JavaScript** com base nas informações de tipo disponíveis. 

No exemplo, o TypeScript perceberá que tentamos atribuir uma string a uma variável que ele inferiu como sendo um número. O editor mostrará um erro:
```js
// @ts-check
let a_number = 1000;
if (Math.random() < 0.5) {
  a_number = "Hello, World!";
  // ^-- Type 'string' is not assignable to type 'number'.ts(2322)
}
console.log(a_number * 10);
```

Esse trecho mostra bem como o TypeScript funciona como uma "camada de segurança" em cima do JavaScript. Quer que eu faça uma versão **resumida e didática**, como se fosse uma explicação rápida para iniciantes?

Agora, podemos começar a corrigir o nosso código, e o TypeScript vai nos guiar. A **inferência de tipos** para JavaScript é bastante poderosa. No exemplo a seguir, o TypeScript infere tipos observando operações como multiplicação e adição, além de valores padrão:
```js
function addVAT(price, vat = 0.2) {
	return price * (1 + vat);
}
```

A função *addVAT* recebe dois argumentos. O segundo é opcional, pois foi definido com valor padrão de *0.2*. O TypeScript irá alertar se tentarmos passar um valor incompatível:

```js
addVAT(1000, "a string");
// ^-- Argument of type 'string' is not assignable
// to parameter of type 'number'.ts(2345)
```

Além disso, como usamos operações de multiplicação e adição dentro da função, o TypeScript entende que o retorno será um número:
```js
addVAT(1000).toUpperCase();
// ^-- Property 'toUpperCase' does not
// exist on type 'number'.ts(2339)
```

Em algumas situações, precisaremos de mais do que inferência de tipos. Em arquivos JavaScript, é possível **anotar argumentos de funções e variáveis usando JSDoc**. O #JSDoc é uma convenção de comentários que permite descrever variáveis e funções. O TypeScript interpreta essas anotações e as utiliza como tipos:
```js
/** @type {number} */
let amount;
amount = '12';
// ^-- Argument of type 'string' is not assignable
// to parameter of type 'number'.ts(2345)
```

```js
/**
 * Adds VAT to a price
 *
 * @param {number} price The price without VAT
 * @param {number} vat The VAT [0-1]
 *
 * @returns {number}
 */
function addVAT(price, vat = 0.2) {
  return price * (1 + vat);
}
```

O JSDoc também permite definir **tipos complexos para objetos:**

```js
/**
 * @typedef {Object} Article
 * @property {number} price
 * @property {number} vat
 * @property {string} string
 * @property {boolean=} sold
 */

/**
 * Now we can use Article as a proper type
 * @param {[Article]} articles
 */
function totalAmount(articles) {
  return articles.reduce((total, article) => {
    return total + addVAT(article);
  }, 0);
}
```

A sintaxe pode parecer um pouco pesada, mas veremos maneiras melhores de anotar objetos mais adiante.

Se tivermos uma base de código JavaScript bem documentada com JSDoc, adicionar apenas **uma linha no topo dos arquivos** já dará uma ótima visão sobre possíveis erros em nosso código. 

>Esse trecho mostra como o TypeScript consegue **aproveitar tanto a inferência automática quanto as anotações JSDoc** para tornar o JavaScript mais seguro.


## 1.2 Installing TypeScript
**Problem**
As linhas vermelhas no editar não bastam: queremos um feedback na linha de comando, código de status, configuração e opções para verificar em JavaScript e compilar TypeScript.

**Solução**
Instalar o TypeScript usando o NPM, o gerenciador de pacotes do Node.js.

**Discussão**
- O TypeScript é escrito em TypeScript, compilado para JavaScript e roda sobre o *runtime do Node.js*.
- Mesmo que não estejamos criando um app Node, as ferramentas de JavaScript/TypeScript dependem do Node.
- Portanto, é essencial instalar o Node.js pelo site oficial e se familiarizar com seus comandos.
- Para um novo projeto, inicialize a pasta com um `package.json`, que descreve o projeto e suas dependências.
- Podemos gerar um *package.json* básico com:
`npm init -y`

Ou seja, o próximo passo para sair do "só ver avisos no editor" e realmente **rodar a checagem de tipos e compilar TypeScript** é instalar o TypeScript via NPM e configurar o nosso projeto.

Podemos instalar o TypeScript globalmente para ter o compilador disponível em qualquer lugar, mas eu recomendo que o TypeScript seja instalado separadamente por projeto. Dependendo da frequência com que trabalhamos com os nossos projetos, podemos acabar com diferentes versões do TypeScript sincronizadas com o código de cada projeto. Instalar (e atualizar) o TypeScript globalmente pode quebrar projetos que não mexemos há algum tempo.

**Instalação do TypeScript em ambiente de desenvolvimento local**
`npm install -D typescript`

Se instalarmos a dependência de frontend via NPM, precisaremos de uma ferramenta adicional para garantir que o nosso código também rode no navegador: um **bundler**. O TypeScript não inclui um #bundler compatível com os sistemas de módulos suportados, então é necessário configurar a ferramenta adequada. Ferramentas como **Webpack** são comuns, assim como o **ESBuild**. Todas essas ferramentas são projetadas para executar TypeScript também. Ou você pode ir totalmente nativo, como descrito na Receita 1.8.

Com
`npx tsc --init`
Podemos executar a versão local do compilador TypeScript do nosso projeto e passar a flag *init* para criar um novo *tsconfig.json*.

O *tsconfig.json* é o principal arquivo de configuração do nosso projeto TypeScript. Ele contém todas as configurações necessárias para que o TypeScript entenda como interpretar o nosso código, como disponibilizar tipos para dependências e se precisamos ativar ou desativar certos recursos.

Por padrão, o TypeScript define essas opções:
```json
{
  "compilerOptions": {
    "target": "es2016",
    "module": "commonjs",
    "esModuleInterop": true,
    "forceConsistentCasingInFileNames": true,
    "strict": true,
    "skipLibCheck": true
  }
}
```

Vamos analisá-las em detalhe:
- **target** é `es2016`, o que significa que, ao compilar, o TypeScript gera código compatível com ECMAScript 2016. Dependendo dos navegadores ou ambientes que precisamos suportar, podemos definir algo mais recente (ECMAScript é nomeado pelo ano de lançamento) ou algo mais antigo, como es5, para suportar versões antigas do Internet Explorer.
- *module* é commonjs. Isso permite escrever sintaxe de módulos ECMAscript, mas o TypeScript compila para o formato CommonJS. Exemplo:
```ts
import { name } from "./my-module";
console.log(name);
```

Isso vira:
```js
const my_module_1 = require("./my-module");
console.log(my_module_1.name);
```

O CommonJS foi o sistema de módulos do Node.js e se tornou muito comum. Hoje o node também suporte módulos ECMAscript, assunto tratado na Receita 1.9.

- **esModuleInterop** garante que módulos que não são ECMAScript fiquem alinhados ao padrão quando importados.

- **forceConsistentCasingInFileNames** ajuda quem usa sistemas de arquivos sensíveis a maiúsculas/minúsculas a manter consistência com quem usa sistemas insensíveis.

- **skipLibCheck** assume que os arquivos de definição de tipos instalados não têm erros, acelerando a compilação.

Um dos rercursos mais interessante é o **modo estrito** do TypeScript. Com `"strict":true`, o compilador aplica regras mais rigorosas. Se houver mudanças na forma como o sistema de tipos deve se comportar, elas entram no modo estrito. Isso pode quebrar o código ao atualizar o TypeScript, mas podemos ativar ou desativar recursos específicos do modo estrito conforme necessário.

Além das configurações padrão, recomenda-se adicionar:
```json
{
  "compilerOptions": {
    //...
    "rootDir": "./src",
    "outDir": "./dist"
  }
}
```

Isso instrui o TypeScript a pegar os arquivos de origem da pasta `src` e colocar os compilados na pasta `dist`. Assim, você separa os arquivos escritos dos arquivos gerados. É preciso criar a pasta `src`; a pasta `dist` será criada após a compilação.

A extensão .ts indica que é um arquivo TypeScript. Agora podemos rodar com:
`npx tsc`

```json
{
  // Visit https://aka.ms/tsconfig to read more about this file

  "compilerOptions": {

    // File Layout

    // "rootDir": "./src",

    // "outDir": "./dist",

  

    // Environment Settings

    // See also https://aka.ms/tsconfig/module

    "module": "nodenext",

    "target": "esnext",

    "types": [],

    // For nodejs:

    // "lib": ["esnext"],

    // "types": ["node"],

    // and npm install -D @types/node

  

    // Other Outputs

    "sourceMap": true,

    "declaration": true,

    "declarationMap": true,

  

    // Stricter Typechecking Options

    "noUncheckedIndexedAccess": true,

    "exactOptionalPropertyTypes": true,

  

    // Style Options

    // "noImplicitReturns": true,

    // "noImplicitOverride": true,

    // "noUnusedLocals": true,

    // "noUnusedParameters": true,

    // "noFallthroughCasesInSwitch": true,

    // "noPropertyAccessFromIndexSignature": true,

  

    // Recommended Options

    "strict": true,

    "jsx": "react-jsx",

    "verbatimModuleSyntax": true,

    "isolatedModules": true,

    "noUncheckedSideEffectImports": true,

    "moduleDetection": "force",

    "skipLibCheck": true,

  }

}
```
Explicação das principais opções
- **module: "nodenext"** → usa o sistema de módulos ECMAScript nativo do Node.js (mais moderno que CommonJS).
- **target: "esnext"** → compila para a versão mais recente do ECMAScript disponível.
- **types: []** → lista de pacotes de tipos a serem incluídos; vazio significa que não há tipos extras carregados por padrão.
- **sourceMap: true** → gera arquivos `.map` para depuração (permite mapear o código compilado para o original).
- **declaration: true** → gera arquivos `.d.ts` com definições de tipos, útil para bibliotecas.
- **declarationMap: true** → gera mapas de declaração para facilitar navegação entre tipos e código.
- **noUncheckedIndexedAccess: true** → exige verificação ao acessar índices em arrays/objetos, evitando `undefined` inesperado.
- **exactOptionalPropertyTypes: true** → trata propriedades opcionais de forma mais rigorosa (não assume que podem ser `undefined` automaticamente).
- **strict: true** → ativa o modo estrito do TypeScript, com regras mais rígidas de tipagem.
- **jsx: "react-jsx"** → habilita suporte ao JSX moderno usado pelo React.
- **verbatimModuleSyntax: true** → mantém a sintaxe de módulos exatamente como escrita, sem transformações.
- **isolatedModules: true** → garante que cada arquivo possa ser compilado isoladamente, útil para ferramentas como Babel/ESBuild.
- **noUncheckedSideEffectImports: true** → impede imports que só executam efeitos colaterais sem exportar nada.
- **moduleDetection: "force"** → força o TypeScript a tratar arquivos como módulos.
- **skipLibCheck: true** → ignora checagem de erros em arquivos de definição de tipos (`.d.ts`), acelerando a compilação.

## 1.3 Keeping Types on the Side
**Problema**
Você quer escrever JavaScript normal, sem etapas extras de build, mas ainda assim obter suporte do editor e informações corretas de tipos para nossas funções. Porém, não quer definir tipos complexos de objetos com JSDoc.

**Solução**
Mantenha arquivos de definição de tipos "ao lado" e execute o compilador TypeScript no modo "check JavaScript".

**Dicussão**
A adoção gradual sempre foi um objetivo do TypeScript. Com essa técnica, chamada de *types on the side*, podemos escrever sintaxe TypeScript para tipos de objetos e recursos avançados como genéricos e tipos condicionais, em vez de comentários JSDoc pesados, mas ainda escrever JavaScript para a nossa aplicação real.

Em algum lugar do nosso projeto, por exemplo em uma pasta *@types*, crie um arquivo de definição de tipos. Ele deve terminar com *.d.ts* e, diferente dos arquivos .ts, serve apenas para declarações, sem código executável.

Esse comentário dis ao TypeScript para importar o tipo *Person* de *@types/person* e disponibilizá-lo no arquivo.

Agora, podemos usar esse identificador para anotar parâmetros de funções ou objetos, como faria com tipos primitivos:
```js
/**
 * @param {Person} person
 */
function printPerson(person) {
  console.log(person.name);
}
```

Para garantir feedback no editor, ainda é necessário colocar *//@ts-check* no início dos arquivos JavaScript, como descrito na Receita 1.1. Ou, alternativamente, configurar o projeto para sempre verificar JavaScript.

No *tsconfig.json*, defina:
```json
{
  "compilerOptions": {
    "checkJs": true,
    "noEmit": true
  }
}
```

- **checkJs: true** - ativa a checagem de tipos em arquivos .js
- **noEmit: true** - impede que o TypeScript transpile os arquivos, apenas verifica.

Assim, o TypeScript analisará seus arquivos de origem e fornecerá todas as informações de tipos necessárias, sem alterar no nosso código.

Essa técnica também escala bem. Bibliotecas JavaScript conhecidas, como **Preact**, funcionam dessa forma e oferecem excelente suporte tanto para usuários quanto para contribuidores.

## 1.4 Migrating a Project to TypeScript
**Problema**
Queremos aproveitar todos os benefícios do TypeScript em nosso projeto, mas precisamos migrar uma base de código inteira.

**Solução**
Renomear os módulos, arquivo por arquivo, de *.js* para *.ts*. Usamos algumas opções do compilador e recursos que ajudam a corrigir erros.

**Discussão**
A vantagem de ter arquivos TypeScript em vez de arquivos JavaScript com tipos separados é que seus **tipos e implementações ficam juntos**, o que oferece melhor suporte no editor, acesso a mais recursos do TypeScript e maior compatibilidade com outras ferramentas.

No entanto, simplesmente renomear todos os arquivos de *.js* para *.ts* provavelmente resultará em uma enxurrada de erros. Por isso, é melhor migrar **gradualmente**, **arquivo por arquivo**, aumentando a segurança de tipos aos poucos.

O maior desafio da migração é que podemos passar a lidar com um projeto TypeScript, não mais apenas JavaScript. Muitos módulos ainda estarão em JS e, sem informações de tipo, falharão na verificação.

Para facilitar, podemos **desativar a checagem de tipos de arquivos JavaScript**, mas permitir que módulos TypeScript importem arquivos JS:
```json
{
  "compilerOptions": {
    "checkJs": false,
    "allowJs": true
  }
}
```

Ao rodar *npx tsc*, o TypeScript processará todos os arquivos *.js* e *.ts* da pasta de origem e criará os respectivos arquivos JavaScript na pasta de destino, além de transpilar o código para ser compatível com a versão alvo definida.

Se usamos dependência, perceberemos que algumas não vêm com definições e tipos, o que gera erros:
```ts
import _ from "lodash";
// ^- Não foi encontrado um arquivo de declaração
// para o múdulo 'loadsh'.
```

Nesse caso, instale definições de tipos de terceiros para resolver o problema.

Durante a migração, podemos notar que não conseguiremos tipar completamente um arquivo de uma só vez, já que há dependências entre módulos. Muitas vezes será necessário ajustar vários arquivos antes de conseguir tipar o que realmente precisa.

Também podemos optar por **conviver com alguns erros**. Por padrão, o TypeScript define *noEmitOnError* como *false*:
```json
{
	"compilerOptions": {
		"noEmitOnError": false
	}
}
```
Isso significa que, mesmo com erros, o TypeScript continuará gerando os arquivos de saída, sem bloquear o processo. Esse pode ser um bom comportamento durante a migração, mas talvez queiramos ativar a opção depois que terminarmos.

No modo estrigo, a flag *noImplicityAny* é *true*. Ela garante que não esqueçamos de atribuir um tipo a variáveis, constantes ou parâmetros de função. Mesmo que seja apenas *any*:
```ts
function printPerson(person: any) {
	console.log(person.gobbleydegook);
}
printPerson(123);
```

O tipo *any* é um coringa: aceita qualquer valor e permite acessar qualquer propriedade ou método. Na prática, ele desliga a checagem de tipos, dando mais liberdade durante a migração.

Uma alternativa é usar #unknown, que também aceita qualquer valor, mas não permite usá-lo sem antes verificar o tipo.

Podemos ainda ignorar erros com comentários:
- *@ts-ignore* antes da linha desativa a checagem alie;
- *@ts-nocheck* no início do arquivo desativa a checagem inteira;
- *@ts-expect-error* funciona como o @ts-ignore, mas gera alerta se não houver erro.

Esse último é ótimo para migração: quando não houver mais diretivas *ts-expect-error*, significa que concluímos a tipagem.
```ts
function printPerson(person: Person) {
	console.log(person.name);
}
// @ts-expect-error
printPerson(123);

function printNumber(nr: number) {
	console.log(nr);
}

// @ts-expect-error
printNumber(123);
```
A vantagem dessa técnica é inverter a responsabilidade: em vez de garantir que passemos os valores corretos, garantimos que a função aceita apenas os valores certos.

No fim, todas as formas de contornar erros durante a migração têm algo em comum:
**são explícitas**. Precisamos marcar com *@ts-expect-error*, usa *any*, ou ignorar arquivos. Isso permite rastrear esses pontos e, com o tempo, eliminá-los até que sua base esteja totalmente tipada.

## 1.5 Loading Types from Definitely Typed
