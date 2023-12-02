"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.printIn4 = exports.department = void 0;
var Department = /** @class */ (function () {
    function Department(id, name) {
        this.id = id;
        this.name = name;
    }
    /**
     * Getter id
     * @return {number}
     */
    Department.prototype.getId = function () {
        return this.id;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Department.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Getter name
     * @return {string}
     */
    Department.prototype.getName = function () {
        return this.name;
    };
    /**
     * Setter name
     * @param {string} value
     */
    Department.prototype.setName = function (value) {
        this.name = value;
    };
    return Department;
}());
exports.default = Department;
exports.department = new Department(1, "A");
function printIn4(department) {
    console.log("ID: ".concat(department.getId(), ", Name: ").concat(department.getName()));
}
exports.printIn4 = printIn4;
printIn4(exports.department);
