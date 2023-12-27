import { createSlice } from "@reduxjs/toolkit";

const counterSlide = createSlice({
  name: "counter",
  initialState: 0,
  reducers: {
    incremented: state => state + 1,
    decremented: state => state - 1
  }
}) 

export const{actions, reducer} = counterSlide;
export const{incremented, decremented} = actions;



// const initialState = {
//     value: 0
//   }
  
  // export function counterReducer(state = initialState, action) {
  //   switch(action.type) {
  //     case 'counter/increase':
  //       return {
  //         ...state,
  //         value: state.value + 1
  //       };
  //     case 'counter/decrease':
  //       return {
  //         ...state,
  //         value: state.value - 1
  //       };
  //     default:
  //       return state;
  //   }
  // }
  