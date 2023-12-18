function question1(){
    console.log("question1");
    
    var fullName: string = "Nguyễn Văn A";
    var age: number = 25;

    var mess = `Tôi tên là ${fullName}, năm nay tôi ${age} tuổi`;
    console.log(mess);
    
}

function question2(){
    console.log("question2");
    
    var a: number = 2;
    var b: number = 20;

    var mess = `Tổng của ${a} và ${b} là ${a + b}`;
    console.log(mess);
    
}

function question3(){
    console.log("question3");
    
    var menu: string[] = ["Chả giò nón lá", "Bò lúc lắc hạt điều", "Cá tai tượng chiên xù", "Cải thìa sốt thịt cua", "Cơm chiên cá mặn", "Lẩu hải sản", "Rau câu"];
    menu.map(function (val, key) {
        var result = `${key + 1}. ${val.toUpperCase()}`;
        console.log(result);
    });
    
}

export default {question1, question2, question3}