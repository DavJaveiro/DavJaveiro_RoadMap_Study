Components are the foundational building blocks for any Angular application. Each component has three parts:
- TypeScript class
- HTML template
- CSS styles

Note: learn more about *componentes in the essential*

---
## Components
*The fundamental building block for creating applications in Angular.*
Components are the main building blocks of Angular applications. Each component represents a part of a larger web page. Organizing an application into components helps provide structure to our project, clearly, separating code into specific parts that are easy to maintain and grow over time.

### Defining a component
Every component has a few main parts:
1. A *@Component* #decorator that contains some configuration used by Angular.
2. An HTML template that controls what renders into the DOM.
3. A CSS selector that defines how the component is used in HTML
4. A TypeScript class with behaviors, such as handling user input or marking request to a server.

```js
@Component({
	selector: 'user-profile',
	template: `
		<h1>User profile</h1>
		<p>This is the user profile page</p>
	`,
})
expor class UserProfile { /* Our component code goes here */}
```

The @Component decorator <span style="background:#b1ffff">also optionally</span> accepts a *styles* property for any CSS we want to apply for our template:
```js
// user-profile.ts
@Component({
	selector: 'user-profile',
	template:`
		<h1>User profile</h1>
		<p>This is the user profile page</p>
	`,
	styles: `h1 { font-size: 3em; }`,
})
export class UserProfile { /* Our component code goes here */ }
```

### Separating HTML and CSS into separate files
We can define a component's HTML and CSS in separate files using #templateUrl and #styleUrl:
```ts
// user-profile.ts
@Component({
	selector: 'user-profile',
	templateUrl:'user-profile.html',
	styleUrl: 'user-profile.css',
})
export class UserProfile {
	// Component behavior is defined in here
}
```

```ts
// user-profile.html
<h1>User profile</h1>
<p>This is the user profile page</p>
```

```css
/* user-profile.css */
h1 {
	font-size: 3em;
}
```

### Using components
We build an application by composing multiple components together. For example, if we are building a user profile page, we might break the page up into several components like this:
![image-20251120747445.png](/image-20251120747445.png)
Here, the *UserProfile* component uses several other components to produce the final page.

To import and use a component, we need to:
1. In our component's TypeScript file, add an *import* statement for the component we want to use.
2. In our *@Component* decorator, add an entry to the *imports* array for the component we want to use.
3. In our component's template, add an element that matches de selector of the component we want to use.
Here's an example of a *UserProfile* component importing a *ProfilePhoto* component:
```ts
//user-profile.ts
import {ProfilePhoto} from 'profile-photo.ts';

@Component({
	selector: 'user-profile',
	imports: [ProfilePhoto],
	template: `
		<h1> User profile </h1>
		<profile-photo />
		<p>This is the user profile page </p>
	`,
})
export class UserProfile {
	// Component behavior is defined in here
}
```

##


Every component mus have:
- A TypeScript class with *behaviors* such as <span style="background:#affad1">handling user input</span> (tratamento de entrada de usuário) and fetching data from a server
- An HTML template that controls what renders into the DOM
- A CSS selector that defines how the component is used in HTML

We provide Angular-specific information for a component by adding a *@Component* decorator on top of the TypeScript class:
```ts
@Component({
	selector: 'profile-photo',
	template: `<img src="profile-photo.jpg" alt="Your profile photo">`,
})
export class ProfilePhoto { }
```

For full details on writing Angular templates, including data binding, event handling, and control flow, see the https://angular.dev/guide/templates .

The object passed to the *@Component* decorator is called the component's #metadata. This includes the *selector*, *template*, and other properties described throughout this guide.

Components can optionally include a list of CSS styles that apply to that component's DOM:
```ts
// profile-photo.ts
@Component({
	selector: 'profile-photo',
	template: `<img src="profile-photo.jpg" alt="Your profile photo">`,
	styles: `img { border-radius: 50%; }`,
})
export class ProfilePhoto { }
```

Definindo um componente dessa forma, podemos renderizar a class *ProfilePhoto* em qualquer página apenas utilizando o nosso #selector:
```html
<profile-photo></profile-photo>
```

O Angular então renderiza o template (< img ... >) e aplica o CSS definido dentro do próprio componente.

By default, a component's styles only affect elements defined in that component's template. See *Styling Components* for details on Angular's approach to styling.

We can alternatively choose to write our template and styles in separate files:
```ts
@Component({
  selector: 'profile-photo',
  templateUrl: 'profile-photo.html',
  styleUrl: 'profile-photo.css',
})
export class ProfilePhoto { }
```

This can help separate the concerns of *presentation* from *behavior* in our project. We can choose one approach for our entire project, or we decide which to use for each component.

Both *tempalteUrl* and *styleUrl* are relative to the directory in which the component resides.

## Using Components
Imports in the @Component decorator
To use a component, directive, or pipe, we must add it to the imports array in the @Component decorator:

```ts
import {ProfilePhoto} from './profile-photo';

@Component({
	// Import the `ProfilePhoto` component in 
	// order to use it in this component's template. 
	imports: [ProfilePhoto],
	/* ... */
})
export class UserProfile { }
```

By default, Angular components are *standalone*, meaning that we can directly add them to the *imports* array of other components. Components created with an earlier version of Angular may instead specify *standalone: false* in the *@Component* decorator. For these components, you instead import the NgModule in which the component is defined. See the full NgModule guide for details.

Important: In Angular versions before 19.0.0, the `standalone` option defaults to `false`.


## Showing components in a template
Every component defines a CSS selector:
```ts
@Component({
	selector: 'profile-photo',
	...
})
export class ProfilePhoto { }
```

See [Component Selectors](https://angular.dev/guide/components/selectors) for details about which types of selectors Angular supports and guidance on choosing a selector.

You show a component by creating a matching HTML element in the template of other components:
```ts
@Component({
  selector: 'profile-photo',
})
export class ProfilePhoto { }

@Component({
imports: [ProfilePhoto],
template: `<profile-photo />`
})
export class UserProfile { }
```

Angular creates an instance of the component for every matching HTML element it encounters. The DOM element that matches a component's selector is referred to as that component's host element. The contents of a component's template are rendered inside its hots element.

The DOM rendered by a component, corresponding to that component's template, is called that component's view.

In composing components in this way, **you can think of your Angular application as a tree of components**.

!![image-20251120461028.png](/image-20251120461028.png)
This tree structure is important to understanding several other Angular concepts, including *dependency injection* and *child queries*.

## Signals Create and Manage dynamic data
In Angular, we use *signals* to create and manage state. A signal is a lightweight wrapper around a value.

Use the *signal* function to create a signal for holding (manter) local state:
```ts
import {signal} from '@angular/core';

// Create a signal with the `signal` function.
const firstName = signal('Morgan');

// Read a signal value by calling it signals are functions
console.log(firstName());

// Change the value of this signal by calling its `set` methods with a new value.
firstName.set('Jaime');

// We can also use the `update` method to change the value
// based on the previous value.
firstName.update(name => name.toUpperCase());
```

Angular tracks where signals are read and when they're updated. The framework uses this information to do additional work, such as updating the DOM with new state. This ability to respond to changing signal values over time is known as *reactivity*.

**Resumidamente:** signals servem para deixar a interface reativa. Ou seja, quando o valor muda, o Angular automaticamente atualiza a tela, sem que precisemos fazer nada manualmente.

Signals não buscam dados no banco e não atualizam sozinhos conforme o banco muda.
Eles funcionam assim:
- Recebemos ou alteramos os dados (ex: resposta de API, evento, clique, formulário)
- Colocamos esse valor dentro de um signal
- O Angular atualiza automaticamente o DOM quando esse signal muda

Signals não ficam ouvindo o banco automaticamente.
Para isso precisamos de:
- polling (requisições periódicas), ou
- WebSocket / SSE, ou
- Alguma action que atualiza os dados

### Computed Expressions
A #Computed is a signal that produces its value based on other signals.
```ts
import {signal, computed} from '@angular/core';

const firstName = signal('Morgan');
const firstNameCapitalized = computed(() => firstName().toUpperCase());


console.log(firstNameCapitalized()); // MORGAN
```

A computed signal is read-only; it does not have a set or an update method. Instead, the value of the computed signal automatically changes when any of the signals it reads change:
```ts
import {signal, computed} from '@angular/core';

const firstNaME = signal('Morgan');
const firstNameCapitalized = computed(() => firstName().toUpperCase());
console.log(firstNamecapitalized()); // MORGAN

firstName.set('Jaime');
console.log(firstNameCapitalized()); // JAIME
```

**Cenário: carrinho de Compras**
Temos o preço de um tênis e a quantidade que o usuário escolheu. O **subtotal** deve ser calculado automaticamente. Nunca setamos o subtotal manualmente, ele é apenas uma consequência do preço e da quantidade.
```ts
import { signal, computed} from '@angular/core';

// sinais básicos(o estado que muda)
const precoTenis = signal(200.00);
const quantidade = signal(1);

// computed (a reação automática)
// Ele escuta o sinal de quantidade. Se a quantidade mudar, ele recalcula.
const subtotal = computed(() => precoTenis() * quantidade());

console.log(subtotal()); // saída: 200

// simula o usuário clicando no botão de "+" no carrinho
quantidade.set(3);
console.log(subtotal()); // Saída: 600 (Atualizou magicamente!)
```

**Cenário: Resumo Financeiro (Patrimônio Total)**
Em uma dashboard financeira, queremos mostrar o Saldo Total do usuário, somando o que ele tem na conta corrente e nos investimentos. O total é apenas uma leitura da soma das partas.
```ts
import {signal, computed} from '@angular/core';

// O dinheiro que o usuário tem nas contas (Estado)
const saldoContaCorrent = signal(1500);
const saldoInvestimentos = signal(5000);

// O valor que aparece no card "Patrimônio Total" (Derivado)
// Se qualquer conta receber dinheiro, esse total atualiza sozinho.
const patrimonioTotal = computed(() => saldoContaCorrente() + saldoInvestimentos());

console.log(patrimonioTotal()); // Saída: 6500

// o usuário recebeu um PIX de 500 reais na conta corrente
saldoContaCorrente.update(valor => valor + 500);

console.log(patrimonioTotal()); // SAÍDA: 7000 (O total reagiu automaticamente)

```

**Por que usar aqui?** Em apps financeiros, a precisão é crítica. Usar `computed` evita o erro comum de atualizar o saldo de uma conta individual mas "esquecer" de somar isso no painel principal de patrimônio.

## Using signals in componentes
Use signal and computed inside our componentes to create and manage state:
```ts
@Component({/* ... */})
export class UserProfile {
	isTrial = signal(false);
	isTrialExpired = signal(false);
	showTrialDuration = computed(() => this.isTrial() && !this.isTrialExpired());
	
	
	activateTrial() {
		this.isTrial.set(true);
	}
}
```

**E-commerce: Botão "Comprar" Dinâmico**:
Imagine a página de um produto. O botão de "Adicionar ao Carrinho" só deve estar habilitado se houver estoque. Se o estoque acabar, o botão desabilita sozinho.
```ts
@Component({ /* ... */ })
export class ProdutoDetalheComponent {
	// Sinais de estado
	estoque = signal(2); // Temos 2 unidades
	
	// Computed: Decide se o botão fica habilitado 
	// Reage imediatamente se o estoque chegar a 0
	podeComprar = computed(() => this.estoque() > 0);
	
	adicionarAoCarrinho() {
		// Diminui 1 do estoque. O computed "podeComprar" vai notar isso.
		this.estoque.update(qtd => qtd -1)
	}
	
}
```

**Fintech: Modo privacidade olhinho**
```ts
@Component({/* ... */})
export class SaldoHeaderComponent {
	saldo = signal(5000.00);
	modoPrivacidade = signal(true); 
	
	displaySaldo = compouted(() => this.modoPrivacidade()? 'R$ •••••' : `R$ ${this.saldo()}`
	);
	
	alternarVisibilidade() {
		// Inverte true/false
		this.modoPrivacidade.update(v => !v);
	}
}
```

## Templates
Use Angular's template syntax to create dynamic user interfaces. 