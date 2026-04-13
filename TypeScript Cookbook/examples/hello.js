//@ts-check
let a_number = 100;

if (Math.random() < 0.5) {
    a_number = "Hello World";
}

console.log(a_number * 10);

function addVat(price, vat = 0.2) {
    return price * (1 + vat)
}

//@ts-expect-error
addVat(1000, "0.2")

//@ts-expect-error
addVAT(1000).toUpperCase()
