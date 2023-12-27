import store from "../redux/store";

function Counter() {

    const increase = () => {
        store.dispatch({
            type: 'counter/incremented'
        });
    }

    const decrease = () => {
        store.dispatch({
            type: 'counter/decremented'
        });
    }

    const updateData = () => {
        store.subscribe(() => console.log(store.getState()));
    };

    updateData();

    return (
        <div>
            <p>Value: {store.getState().value}</p>
            <button onClick={increase}>Increase</button>
            <button onClick={decrease}>Decrease</button>
        </div>
    )
}

export default Counter;

