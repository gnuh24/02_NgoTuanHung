import React, { useState, useEffect } from "react";
import Axios from "axios";

function Gamer() {
  const [list, setList] = useState([]);

  useEffect(() => {
    getAllList();
  }, []); // Khi component mount, gọi getAllList một lần

  const getAllList = async () => {
     Axios.get(`https://6528c32d931d71583df26e60.mockapi.io/Gamer`)
     .then((response) => {
        setList(response.data);
     })
    .catch( (error) => {
      console.log(error);
    })
  };

  const getAllListById = async (id) => {
    try {
      const response = await Axios.get(
        `https://6528c32d931d71583df26e60.mockapi.io/Gamer/${id}`
      );
      setList((prevList) => [...prevList, response.data]);
    } catch (error) {
      console.log(error);
    }
  };

  const createNewGamer =  async (data) => {
    Axios.post(`https://6528c32d931d71583df26e60.mockapi.io/Gamer`, data)
    .then((response) => {
       getAllList();
    })
   .catch( (error) => {
     console.log(error);
   })
  }

    const create = (event) => {
        event.preventDefault();
        const newGamer = {
            id: parseInt(event.target[0].value), // Chuyển đổi thành số
            name: event.target[1].value
        };
        createNewGamer(newGamer);
    }

  return (
    <div>
        <form onSubmit={create}>
                <input type="text" placeholder="id?"/>
                <input type="text" placeholder="name?"/>
                <button>Create ?</button>
        </form>
      {list.map((element) => (
        <GamerCard id={element.id} name={element.name} />
      ))}
    </div>
  );
}

function GamerCard(prop) {
    const [name, setName] = useState(prop.name);
    const updateGamerF =  async (id, data) => {
        Axios.put(`https://6528c32d931d71583df26e60.mockapi.io/Gamer/${id}`, data)
        .then((response) => { 
            alert("Update done  ")   
        })
       .catch( (error) => {
         console.log(error);
       })
      }

    const update = (event) => {
        event.preventDefault();
        const updateGamer = {
            id: prop.id,
            name: name
        }
        updateGamerF(prop.id, updateGamer);
    }


 const deleteGamerF =  async (id) => {
        Axios.delete(`https://6528c32d931d71583df26e60.mockapi.io/Gamer/${id}`)
        .then((response) => { 
            alert("Delete done  ")   
        })
       .catch( (error) => {
         console.log(error);
       })
      }
   
    const deleteF = (event) => {
        event.preventDefault();
        deleteGamerF(prop.id);
    }

  return (
    <div className="gamerIn4">
      <form onSubmit={update}>
            <div>{prop.id}</div>
            <div>{name}</div>
            <input type="text" onChange={ (event) => setName(event.target.value) }/>
            <button>Click ?</button>
        </form>    
        <form onSubmit={deleteF}>
            <button>Delete ?</button>
        </form>
    </div>
  );
}

export default Gamer;
