var multiply = (a, b = 1) => console.log( a * b);    

function question1(){
    console.log("question1");
    multiply(5, 3);
    multiply(5);
}

var multiply2 = (...numParams) => {
    var result = 1;
    numParams.forEach(e => {
        result *= e;
    });
    console.log(result);    
}

function question2(){
    console.log("question2");
    multiply2(5);
    multiply2(5, 3);
    multiply2(5, 3, 2);
}

var printInformation = (name, mail?) => {
    if(mail != undefined){
        console.log(`Tôi là ${name}. Email của tôi là ${mail}`);
    }else{
        console.log(`Tôi là ${name}. Tôi chưa có mail`);
    }
}

function question3(){
    console.log("question3");
    printInformation("Nam", "nam20@gmail.com");
    printInformation("Nam");
}

export default {question1, question2, question3}