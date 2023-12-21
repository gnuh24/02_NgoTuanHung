import React, { useState } from "react";
import ChildEx2 from "./ChildEx2.jsx";
import "./parent.css";

function ParentToChild (){

    return(
        <div className="parent">
            <h1>I'm your dad</h1>
            <ChildEx2  />
        </div>
    )

}

export default ParentToChild;