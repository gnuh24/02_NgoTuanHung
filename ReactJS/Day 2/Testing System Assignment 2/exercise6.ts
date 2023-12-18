// function createUser(callback){
//     setTimeout( () => {
//         console.log("Create User");
//         callback();
//     }, 1000)
// }

// function createGroup(callback){
//     setTimeout( () => {
//         console.log("Create Group");
//         callback();
//     }, 1000)
// }

// function addUser(){
//     setTimeout( () => {
//         console.log("Add user to group");
//     }, 1000)
// }



// function callAPICallBack(){
//     createUser( () => {
//             createGroup( () => {
//                 addUser();
//             })
//         } 
//     );
   
// }

// function createUser(){
//     return new Promise( (resolve) => {
//         setTimeout( () => {
//             console.log("Create User");
//             resolve("Done 1");
            
//         }, 1000)  
//     })
// }

// function createGroup(){
//     return new Promise( (resolve) => {

//         setTimeout( () => {
//             console.log("Create Group");
//             resolve("Done 2");

//         }, 1000)
//     })
// }

// function addUser(){
//     return new Promise( (resolve) => {

//         setTimeout( () => {
//             console.log("Add user to group");
//             resolve("Done 3");

//         }, 1000)
//     })
// }


// let callAPIPromise = new Promise( (resolve, reject) => {
//     resolve("H");    

// })

// callAPIPromise
// .then(() => { return createUser();})
// .then(() => { return createGroup();})
// .then(() => { return addUser();})
// .catch((error) => { console.log(error); })

async function createUser(){
    return new Promise( (resolve) => {

        setTimeout( () => {
            console.log("Create User");
            resolve("Done 1");

        }, 1000)  
    })
}

async function createGroup(){
    return new Promise( (resolve) => {

        setTimeout( () => {
            console.log("Create Group");
            resolve("Done 2");

        }, 1000)
    })
}

async function addUser(){

    return new Promise( (resolve) => {
                setTimeout( () => {
                    console.log("Add user to group");
                    resolve("Done 3");
        
                }, 1000)
            })
   
}

async function callAPIAsynchorus() {
    await createUser();
    await createGroup();
    await addUser();
}

callAPIAsynchorus();
    
   