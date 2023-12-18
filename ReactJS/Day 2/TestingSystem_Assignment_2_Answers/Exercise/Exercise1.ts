function question1() {
    console.log("question1");
    
    var date: number[] = [2020, 12, 8];
    var [year, month, day] = date;
    console.log(year);
    console.log(month);
    console.log(day);
}

function question2() {
    console.log("question2");
    
    const person = {
        firstName: "Nguyen",
        lastName: "a",
        age: 20
    };

    var{firstName: f, lastName: l, age: a} = person;
    console.log(f);
    console.log(l);
    console.log(a);
}

export default {question1, question2}