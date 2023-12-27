import { configureStore } from "@reduxjs/toolkit";
import { counterReducer } from "./Reducer/counterReducer";
import { contentReducer } from "./Reducer/contentReducer";
import { thunk } from 'redux-thunk';

const store = configureStore({
  reducer: {
    counter: counterReducer,
    content: contentReducer
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(thunk),
  devTools: { trace: true },
});

export default store;