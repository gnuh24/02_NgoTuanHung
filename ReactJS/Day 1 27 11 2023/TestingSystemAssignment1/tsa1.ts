/*Exercise 1
    Question1: Đếm số lượng các từ trong xâu kí tự "Tiên học lễ, Hậu học văn"
    Question2: Viết hoa chữ cái đầu của mỗi từ trong câu sau "cách tốt nhất để làm mọi thứ là ngừng nói và làm ngay bây giờ" và in ra màn hình
    Question3: Thay thế ký tự * trong câu "Họ* đi đôi *ới hàn*" để câu trở thành có nghĩa*/

function ex1_question1(){
    let chuoi = "Tiên học lễ, hậu học văn".split(" ");
    console.log(chuoi);
    console.log(chuoi.length);
}

function ex1_question2(){
    let chuoi = "cách tốt nhất để làm mọi thứ là ngừng nói và làm ngay bây giờ và in ra màn hình".split(" ");
    console.log(chuoi);
    chuoi.forEach( (ele) => {
        ele = ele.charAt(0).toUpperCase() + ele.substring(1);
        console.log(ele);
    })
}

function ex1_question3(){
    let chuoi = "Họ* đi đôi *ới hàn*";
    chuoi = chuoi.substring(0, 2) + chuoi.charAt(2).replace("*", "c") + chuoi.substring(3);
    chuoi = chuoi.substring(0, 11) + chuoi.charAt(11).replace("*", "v") + chuoi.substring(12);
    chuoi = chuoi.substring(0, 18) + chuoi.charAt(18).replace("*", "h") + chuoi.substring(19);
 
    console.log(chuoi);

}

//Ex2:    Question1: tìm và in ra phần tử có giá trị nhỏ nhất trong mảng sau [10, 6, 8, 9, 3]
let ex2_question1 = (array) => {
    let min = array[0];
    for (let i=1; i< array.length; i++){
        if (min > array[i]){
            min = array[i];
        }
    }
    return min;
}

/*
Ex4
    Question 1: Scope
    Khai báo biến fullName và function hello() để in ra fullName theo 3
    cách
    a) Khai báo fullName là Global scope
    b) Khai báo fullName là Function scope
    c) Khai báo fullName là Lexical Scope
*/
var fullNameGlobal = "Ngô Tuấn Hưng"
function ex4_question1(){
    console.log("Global scope: " + fullNameGlobal)


    let fullNameFunction = fullNameGlobal;
    console.log( "Function scope:  " +fullNameFunction);

    let fullNameLexicalScope = fullNameGlobal;
    function hello(){
        console.log( "Lexical scope:  " + fullNameLexicalScope);
    }
    hello();

}

function ex4_question2(){
    var myName = () => {
        console.log("Hello Ngô Tuấn Hưng" );
    }
    return  myName;
}

function ex4_question3(firstName: string, lastName: string){
    function getting(){
        return firstName + " " + lastName;
    }
    return getting;
}

import * as DepartmentFile from "./Department";


DepartmentFile.printIn4(DepartmentFile.department);


