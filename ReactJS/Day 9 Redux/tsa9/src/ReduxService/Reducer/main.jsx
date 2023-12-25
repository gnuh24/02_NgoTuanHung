import { combineReducers } from "redux";
import { counterReducer } from "./counterReducer";
import { contentReducer } from "./contentReducer";

const mainReducer = combineReducers({
    counter: counterReducer,
    content: contentReducer
})

export default mainReducer;

        
