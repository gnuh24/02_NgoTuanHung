function question1(){
    console.log("question1");
    
    var numArr : number[] = [2, 4, 6, 8, 10];
    var newNumArr : number[] = [...numArr, 5, 7, 9];
    console.log(newNumArr.sort());
    return newNumArr;
}

function question2(){
    console.log("question2");
    
    var newNumArr : number[] = [...question1()];
    console.log(newNumArr);
    
}

function question3(){
    console.log("question3");
    
    var cold : string[] = ["autumn", "winter"];
    var warm : string[] = ["spring", "summer"];
    var seasons : string[] = [...cold, ...warm];
    console.log(seasons);
    
}

export default {question1, question2, question3}