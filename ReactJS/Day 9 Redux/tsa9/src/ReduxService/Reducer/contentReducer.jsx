const initialState = {
    text: "-"
}
  
export function contentReducer(state = initialState, action) {
    switch(action.type) {
        case 'content/onChange':
        return {
            ...state,
            text: action.payload
        };
        default:
            return state;
    }
}
  