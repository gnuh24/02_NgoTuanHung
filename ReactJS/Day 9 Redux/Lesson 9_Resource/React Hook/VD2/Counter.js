import { useStore } from "react-redux";
import selectCounter from "../../redux/selectors/counterSelector";

function Counter() {

    const store = useStore();

    const counter = selectCounter(store.getState());

    return (
        <div>
            <p>Value: {counter}</p>
        </div>
    )
}

export default Counter;

