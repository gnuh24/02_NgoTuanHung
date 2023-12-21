import React, { useState } from "react";
import "./parent.css";
import context from "./context";

function ChildEx2 (prop){
    const [text, setText] = useState("");

    return(

        <div className="son1">
            <input type="text" onChange={ (event) => setText(event.target.value) }/>
            <button onClick={ () => context.}>Click vào ?</button>
        </div>

    )
}

export default ChildEx2;