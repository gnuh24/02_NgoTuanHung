
import React from "react";
import store from "../ReduxService/store"
import selectCounterList  from "../ReduxService/Selector/CounterSelector";
import { useSelector } from 'react-redux';


export function Button(){
    const count = useSelector(selectCounterList);

    const clickIncrease = () => {
        store.dispatch({
            type: "counter/increase",
        })
    }

    const clickDecrease = () => {

        store.dispatch({
            type: "counter/decrease",
        })
    }

    return(
        <div>
                <h1>Value: {count}</h1>
                <button onClick={clickIncrease}>Increase</button>
                <button onClick={clickDecrease}>Decrease</button>

        </div>
    );
}