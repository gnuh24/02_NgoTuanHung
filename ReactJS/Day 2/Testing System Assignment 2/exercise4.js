var question1 = function (a) {
    return a + 100;
};
var question2a = function (a, b) {
    return a + b + 100;
};
var question2b = function (a, b) {
    var chuck = 42;
    return a + b + chuck;
};
console.log(question1(10));
console.log(question2a(10, 20));
console.log(question2b(10, 20));
