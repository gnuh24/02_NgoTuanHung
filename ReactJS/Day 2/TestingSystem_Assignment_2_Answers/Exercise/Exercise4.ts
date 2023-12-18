var arrowFnc = (a) => a + 100;

function question1(){
    console.log("question1");
    console.log(arrowFnc(1));
}

var arrowFnc2 = (a, b) => a + b + 100;
var arrowFnc3 = (a, b) => {
    let chuck = 42; 
    return a + b + chuck;
};
var bob = (a) => a + 100;
function question2(){
    console.log("question2");
    
    console.log(arrowFnc2(1, 2));   
    console.log(arrowFnc3(1, 2));  
    console.log(bob(2));  
}

export default {question1, question2}