import { createAsyncThunk } from "@reduxjs/toolkit";

// Action async sử dụng Redux Thunk
export const fetchContentAsync = createAsyncThunk('content/fetchContent', async () => {
    // Gọi các API hoặc thực hiện các thao tác bất đồng bộ khác ở đây
    return new Promise(resolve => setTimeout(() => resolve(), 1000));
});