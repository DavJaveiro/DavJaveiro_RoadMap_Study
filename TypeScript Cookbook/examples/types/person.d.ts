// @types/person.d.ts
export interface Person {
    name: string;
    age: number;
}

export interface Studen extends Person {
    semester: number;
}