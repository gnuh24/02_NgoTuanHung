var multiply = function () {
    var para = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        para[_i] = arguments[_i];
    }
    var product = 1;
    para.forEach(function (ele) {
        product *= ele;
    });
    console.log(product);
};
multiply(5);
multiply(5, 3);
multiply(5, 3, 2);
var printIn4 = function (name, email) {
    console.log("Xin ch\u00E0o t\u00F4i t\u00EAn l\u00E0 ".concat(name));
    if (email != null) {
        console.log("Email c\u1EE7a t\u00F4i l\u00E0 ".concat(email));
    }
};
printIn4("Suifeng");
printIn4("Suifeng", "suifeng@gmail.com");
