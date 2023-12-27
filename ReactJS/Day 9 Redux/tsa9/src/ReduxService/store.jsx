import { configureStore } from "@reduxjs/toolkit";
import { reducer as counterReducer } from "./Reducer/counterReducer";

const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
  devTools: true,
});

export default store;
