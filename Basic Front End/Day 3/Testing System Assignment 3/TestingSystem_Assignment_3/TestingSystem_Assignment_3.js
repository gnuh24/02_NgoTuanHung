document.addEventListener("copy", function (event) {
    alert("Copy thành công !!");
});

let button = document.getElementById("button");

let auPassElements = document.querySelectorAll('.anPass');

// Chuyển NodeList thành mảng và lặp qua từng phần tử để thêm sự kiện
Array.from(auPassElements).forEach(function(element) {
    element.addEventListener("keyup", function(event) {
        event.preventDefault();
        swap(); // Gọi swap()
    });
});

function swap(){
    var temp = 
}


button.addEventListener("click", function(event){
    event.preventDefault();
    let name = document.getElementById("inputName").value;
    let phone = document.getElementById("inputPhone").value;
    let email = document.getElementById("inputEmail").value;
    let pass = document.getElementById("inputPass").value;
    let comfirmPass = document.getElementById("confirmPass").value;


    if (isValue(name, phone, email, pass, comfirmPass)){
        alert("Bạn đã đăng ký với các thông tin sau: \n" +
        "Họ và tên: " + name + "\n" +
        "Số điện thoại: " + phone + "\n"+
        "Email: " + email);
    }
    else alert("Bạn hãy kiểm tra lại thông tin!!");
    
});

function isValue(name, phone, email, pass, comfirmPass ){
    if(name == "" || phone == "" || email == "" || pass == "" || comfirmPass == ""){
        console.log("Các ô không được để trống !!");
        return false;
    }
    else if(!email.includes("@")){
        console.log("Email phải bao gồm @");
        return false;
    }
    else if (pass != comfirmPass){
        console.log("Password và Xác nhận phải giống nhau !!");
        return false;
    }
    return true;
}


var list = document.getElementsByClassName("required");
console.log(list.length);



