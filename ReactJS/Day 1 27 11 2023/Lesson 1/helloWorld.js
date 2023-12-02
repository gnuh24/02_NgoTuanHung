// class Person{
//     private name: string;
//     private age: number;
//     constructor(name: string, age: number){
//         this.name = name;
//         this.age = age;
//     }
//     /**
//      * Getter name
//      * @return {string}
//      */
// 	public getName(): string {
// 		return this.name;
// 	}
//     /**
//      * Setter name
//      * @param {string} value
//      */
// 	public setName(value: string) {
// 		this.name = value;
// 	}
// }
// let 
// person : Person = new Person("Hưng", 12);
// console.log(person.getName());
//helloWorld.ts
// function outerFunction(){
//     let i = 0;
//     function innerFunction(){
//         console.log(`Hello ${i++}`);
//     }
//     return innerFunction;
// }
// export var saveHello = outerFunction();
// saveHello();
// saveHello();
// saveHello();
// function outerFunction() {
//     let outerValue = 10;
//     function innerFunction() {
//         // Inner function có thể truy cập và sử dụng giá trị của outerValue
//         console.log(`Inner value: ${outerValue}`);
//         // Tăng giá trị của outerValue mỗi lần innerFunction được gọi
//         outerValue++;
//     }
//     // Trả về inner function, tạo ra một closure
//     return innerFunction;
// }
// // Tạo một closure bằng cách gọi outerFunction
// const closure = outerFunction();
// // Gọi innerFunction từ closure
// closure(); // Kết quả: "Inner value: 10"
// // Gọi innerFunction lần thứ hai, outerValue tăng lên
// closure(); // Kết quả: "Inner value: 11"
var name1 = ["Hưng", "Tuấn", "Duy"];
name1.forEach(function (ele, index) {
    console.log(ele);
    console.log(index);
});
// function hello(name: string){
//     console.log(`Hello ${name}`);
// }
// var helloFunction = hello;
// var helloArrowFunction = (name: string) => {
//     console.log(`Hello ${name}`);
// }
// helloArrowFunction("Hưng");
