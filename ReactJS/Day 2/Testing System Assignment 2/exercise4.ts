let question1 = (a: number) => {
    return a + 100;
}

let question2a = (a: number, b: number) => {
    return a + b + 100;
}

let question2b = (a: number, b:number) => {
    let chuck = 42;
    return a+ b + chuck;
}

console.log(question1(10) );
console.log(question2a(10, 20));
console.log(question2b(10, 20));