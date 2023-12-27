
import React from "react";
import store from "../ReduxService/store"
import { useDispatch, useSelector } from "react-redux";
import { onChange } from "../ReduxService/Reducer/contentReducer";

export function Input(){
    const content = useSelector( state => state.content );
    const dispatch = useDispatch();
    
    const handleChange = (event) => {
        dispatch(onChange(event.target.value));
      };

    return(
        <div>
                <h1>Text: {content} </h1>
                <input type="text" onChange={handleChange}/>

        </div>
    );
}