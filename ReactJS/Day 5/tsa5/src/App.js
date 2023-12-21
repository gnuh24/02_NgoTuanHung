import './App.css';
import ParentToChild from './functional/ParentToChild';
import Context from './functional/Context';
import React, {useState} from 'react';
import router from './router/routes';

function App() {
  const [contextData, setContextData] = useState({
    duLieu1: 40,
    duLieu2: 80,
  });

  const updateContextData = (newData) => {
    setContextData((prevData) => ({
      ...prevData, //Tất cả dữ liệu cũ (bao gồm cả duLieu1)
      ...newData, // Chỉ có duLieu1 được cập nhật

      // sau đó React sẽ tự so sánh sự thay đổi và cập nhật
    }));
  };

  return (
    <Context.Provider value={{ ...contextData, updateContextData }}>
      <div className="App">
        <header className="App-header">
          <ParentToChild/>
        </header>
      </div>
    </Context.Provider>
  );
}



export default App;
