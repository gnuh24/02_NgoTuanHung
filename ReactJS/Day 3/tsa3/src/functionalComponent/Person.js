Person.defaultProps = {
    name: "THưng",
    age: 20
}

function Person(props){
   
    
    return (


        <div className="person">
            <h3>Name: {props.name}</h3>
            <h4>Age: {props.age}</h4>
            <h4>Year of Birth: {new Date().getFullYear() - props.age}</h4>
        </div>
    );
}

export default Person;