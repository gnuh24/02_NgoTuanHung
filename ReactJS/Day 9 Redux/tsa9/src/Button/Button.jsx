import React from "react";
import { useDispatch, useSelector } from 'react-redux';
import { decremented, incremented } from "../ReduxService/Reducer/counterReducer";

export function Button(){
    // useSelector lấy thẳng state từ trong store.jsx ra 
    const count = useSelector( (state) => state.counter );
    
    //useDispatch() được tạo dùng để gửi dispatch
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