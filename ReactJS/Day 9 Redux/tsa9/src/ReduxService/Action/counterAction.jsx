import { actions } from "../Reducer/counterReducer";

export const increaseAction = () => {
    return {
        type: actions.incremented,
    }
};

export const decreaseAction = () => {
    return {        
        type: actions.decremented,
    };
};
