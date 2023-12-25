
import React, { useState } from "react";

export function ButtonWithoutRedux(){
    const [count, setCount] = useState(0);

    const clickIncrease = () => {
        setCount( prev => ++prev )
    }

    const clickDecrease = () => {
        setCount( prev => --prev )
    }

    return(
        <div>
                <h1>Value: {count}</h1>
                <button onClick={clickIncrease}>Increase</button>
                <button onClick={clickDecrease}>Decrease</button>

        </div>
    );
}