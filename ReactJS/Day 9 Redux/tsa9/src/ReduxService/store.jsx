import { createStore } from "redux";
import mainReducer from "./Reducer/main";

const store = createStore(mainReducer);

export default store;

