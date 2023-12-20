import React from "react";
import "./Clock.css"


class Clock extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            time: new Date(),
            count: 0
        }
    }

   

    render(){
        return (
            <div >
                <h2>Time: {this.state.time.toLocaleTimeString()}</h2>
                <h3>Count: {this.state.count}</h3>
                <button className="clock" onClick={this.update}>Change</button>
            </div>
        );
    }

    update = () => {
        this.setState({
          time: new Date(),
          count: this.state.count + 1,
        });
      };
}

export default Clock;