"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const prompt_sync_1 = __importDefault(require("prompt-sync"));
const prompt = (0, prompt_sync_1.default)();
// const não pode ser redeclarado
const input = prompt("Digite um número inteiro: ");
const listLength = parseInt(input, 10);
// usando const a variável não pode ser reatribuída
const listCreator = (number) => {
    let contador = []; // array literal
    // let pode ser redeclarado
    for (let i = 0; i <= number; i++) {
        contador.push(i);
    }
    return contador;
};
console.log("Veja a sua lista: " + listCreator(listLength));
//# sourceMappingURL=exampleOne.js.map