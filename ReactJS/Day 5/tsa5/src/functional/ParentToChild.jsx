import React, { useState } from "react";
import ChildEx2 from "./ChildEx2";
import "./parent.css";

function ParentToChild (){
    const [count, setCount] = useState(0);

    return(
        <div className="parent">
            <h1>{count}</h1>
            <ChildEx2 setValue={setCount} />
        </div>

    )
}

export default ParentToChild;