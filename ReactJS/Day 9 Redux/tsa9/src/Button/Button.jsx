
import React from "react";
import store from "../ReduxService/store"
import selectCounterList  from "../ReduxService/Selector/CounterSelector";
import { useDispatch, useSelector } from 'react-redux';
import { decreaseAction, increaseAction } from "../ReduxService/Action/counterAction";
import { decremented, incremented } from "../ReduxService/Reducer/counterReducer";


export function Button(){
    const count = useSelector((state) => state.counter);
    const dispatch = useDispatch();
    const clickIncrease = () => {
        dispatch(incremented())
    }

    const clickDecrease = () => {
        dispatch(decremented())
    }

    return(
        <div>
                <h1>Value: {count}</h1>
                <button onClick={clickIncrease}>Increase</button>
                <button onClick={clickDecrease}>Decrease</button>
        </div>
    );
}