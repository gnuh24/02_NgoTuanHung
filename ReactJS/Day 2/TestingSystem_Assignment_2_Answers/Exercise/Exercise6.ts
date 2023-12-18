function createUser(callBack){
    setTimeout(() => {
        console.log("Call API Create User (1)");
        var a = 1;
        if(a == 1){
            return callBack();
        }else{
            console.log("End");            
            return;
        }
    }, 1000);
}

function createGroup(callBack){
    setTimeout(() => {
        console.log("Call API Create Group (2)");
        var a = 2;
        if(a == 1){
            return callBack();
        }else{
            console.log("End");            
            return;
        }
    }, 1000);
}

function addUserToGroup(){
    setTimeout(() => {
        console.log("Call API Add User To Group (3)");
        var a = 1;
        if(a == 1){
            console.log("End");            
            return;
        }else{
            console.log("End With Error");            
            return;
        }
    }, 1000);
}

function getData(){
    createUser(function(){
        createGroup(function(){
            addUserToGroup();
        })
    });
}

function question1(){
    console.log("question1");
    getData();
}

export default {question1}