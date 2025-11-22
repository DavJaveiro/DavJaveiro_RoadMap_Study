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