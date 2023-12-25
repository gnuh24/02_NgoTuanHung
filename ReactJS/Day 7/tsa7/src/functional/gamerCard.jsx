import React, { useState, useEffect } from "react";
// import { AxiosService } from "../service/AxiosService";
import { GamerAPI } from "../service/GamerAPI";

function Gamer() {
  const [list, setList] = useState([]);

  useEffect(() => {
    getAllList();
  }, []); // Khi component mount, gọi getAllList một lần

  const getAllList = async () => {
     GamerAPI.get()
     .then((response) => {
        setList(response.data);
     })
    .catch( (error) => {
      console.log(error.toJSON());
    })
  };

  // const getAllListById = async (id) => {
  //   try {
  //     const response = await  GamerAPI.get(
  //       `/${id}`
  //     );
  //     setList((prevList) => [...prevList, response.data]);
  //   } catch (error) {
  //     console.log(error.toJSON());
  //   }
  // };

  const createNewGamer = async (data) => {
    GamerAPI.post(data) // Thêm url endpoint cần tạo mới gamer
        .then((response) => {
            getAllList();
            alert("Create thành công !!")

        })
        .catch((error) => {
            console.log(error);
        });
};


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
      GamerAPI.put(id, data)
        .then( (response) => { 
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


    const deleteGamerF = async (id) => {
      GamerAPI.deleteGamer(id)
          .then((response) => {
              alert("Delete done ");
          })
          .catch((error) => {
              console.log(error);
          });
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
