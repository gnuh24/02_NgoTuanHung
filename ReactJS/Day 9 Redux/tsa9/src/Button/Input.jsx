
// import React from "react";
// import store from "../ReduxService/store"
// import ContentSelector from "../ReduxService/Selector/ContentSelector"
// import { useSelector } from "react-redux";

// export function Input(){
//     const content = useSelector(ContentSelector);
    
//     const change = (event) => {
//         store.dispatch({
//             type: "content/onChange",
//             payload: event.target.value
//         })
//     }

//     return(
//         <div>
//                 <h1>Value: {content}</h1>
//                 <input type="text" onChange={change}/>

//         </div>
//     );
// }