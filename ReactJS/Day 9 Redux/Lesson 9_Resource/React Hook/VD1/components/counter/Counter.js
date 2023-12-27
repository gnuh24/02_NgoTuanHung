import { useDispatch, useSelector } from "react-redux";
import { decrementedAction, incrementedAction } from "../../redux/actionCreators/counterActionCreator";
import selectCounter from "../../redux/selectors/counterSelector";

function Counter() {

    const counter = useSelector(selectCounter);
    const dispatch = useDispatch();

    const increase = () => {
        dispatch(incrementedAction());
    }

    const decrease = () => {
        dispatch(decrementedAction());
    }

    return (
        <div>
            <p>Value: {counter}</p>
            <button onClick={increase}>Increase</button>
            <button onClick={decrease}>Decrease</button>
        </div>
    )
}

export default Counter;

