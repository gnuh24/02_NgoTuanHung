import { createSlice } from "@reduxjs/toolkit";
import { fetchContentAsync } from "../Middleware/contentMiddle";

const contentSlice = createSlice({
  name: "content",
  initialState: "=",
  reducers: {
    onChange: (state, action) => {
      return action.payload;
    },
  },
  extraReducers: (builder) => {
    // Xử lý action async khi hoàn thành
    builder.addCase(fetchContentAsync.fulfilled, (state) => {
      state += 1;
    });
  },
});

// Export các actions và reducer
export const { actions, reducer: contentReducer } = contentSlice;
export const { onChange } = actions;
