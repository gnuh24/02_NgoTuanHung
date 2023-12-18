let multiply = (...para)  => {
    let product = 1;
    para.forEach( (ele) => {
        product*=ele;
    })
    console.log(product);
}

multiply(5);
multiply(5, 3);
multiply(5, 3, 2);

let printIn4 = (name: String, email?: String) => {
    console.log(`Xin chào tôi tên là ${name}`);
    if (email != null){
        console.log(`Email của tôi là ${email}`);
    }
}

printIn4("Suifeng")
printIn4("Suifeng", "suifeng@gmail.com")
