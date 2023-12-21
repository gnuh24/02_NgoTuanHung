import React, { useContext, useState } from "react";
import "./parent.css";
import Context from "./Context";

function ChildEx2 (prop){
    const [text, setText] = useState("");
    const { duLieu1, duLieu2, updateContextData } = useContext(Context);

    const handleButtonClick = () => {
        // Gọi hàm callback để cập nhật giá trị trong context
        updateContextData({ duLieu1: text });
      };
    

      return (
        <div className="son1">
            I'm your son
          <h2>{duLieu1}</h2>
          <input type="text" onChange={(event) => setText(event.target.value)} />
          <button onClick={handleButtonClick}>Click vào?</button>
        </div>
      );
}

export default ChildEx2;