import React from "react";

class Person extends React.Component{
    static defaultProps = {
        name: "Hưng",
        age: "19"
    }

    render(){
        return (
            <div className="person">
                <h3>Name: {this.props.name}</h3>
                <h4>Age: {this.props.age}</h4>
                <h4>Year of Birth: {new Date().getFullYear() - this.props.age}</h4>
            </div>
        );
    }
}
export default Person;