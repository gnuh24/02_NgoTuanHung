import { createSlice } from "@reduxjs/toolkit";
import { fetchIncrementAsync } from "../Middleware/counterMiddle";


const counterSlice = createSlice({
  name: "counter",
  initialState: 0,
  reducers: {
    incremented: state => state + 1,
    decremented: state => state - 1,
  },
  extraReducers: (builder) => {
    // Xử lý action async khi hoàn thành
    builder.addCase(fetchIncrementAsync.fulfilled, (state) => {
      state += 1;
    });
  },
});

// Export các actions và reducer
export const { actions, reducer: counterReducer } = counterSlice;
export const { incremented, decremented } = actions;

