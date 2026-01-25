import promptSync from "prompt-sync";

const prompt = promptSync();

// const não pode ser redeclarado
const input: string = prompt("Digite um número inteiro: ");
const listLength: number = parseInt(input, 10);


// usando const a variável não pode ser reatribuída
const listCreator = (number: number): number[] => {
    let contador: number[] = []; // array literal
    
    // let pode ser redeclarado
    for (let i = 0; i <= number; i++ ) {
        contador.push(i);
    }
    return contador;
} 

console.log("Veja a sua lista: " + listCreator(listLength));