import React, { useState, useEffect } from 'react';
import "../classComponent/Clock.css"

// function Clock(){
//     const [time, setTime] = useState(new Date());
//     const [count, setCount] = useState(0);

//     return (
//         <div >
//                 <h2>Time: {time.toLocaleTimeString()}</h2>
//                 <h3>Count: {count}</h3>
//                 <button className="clock" onClick={update}>Change</button>
//         </div>
//     );

//     function update(){
//         setCount(count + 1);
//         setTime(new Date());
//     }
// }

function Clock() {
    const [time, setTime] = useState(new Date());
    const [count, setCount] = useState(0);
  
    // // useEffect sẽ chạy sau mỗi lần component render
    // useEffect(() => {
    //   // Cập nhật thời gian sau mỗi giây
    //   const interval = setInterval(() => {
    //     setTime(new Date());
    //   }, 1000);
  
    //   // Cleanup function khi component unmount hoặc dependency thay đổi
    //   return () => clearInterval(interval);
    // }, [count]); // Sẽ chạy lại khi count thay đổi
  
    function update(){

        // //Code này sẽ lấy giá trị Count tại thời điểm nó được lấy rồi cộng luôn
        // setCount( count + 1 );
        // console.log(count);

        //Code này sẽ lấy giá trị Count mới nhất sau đó mới cộng
        setCount( (count) => count + 1 );
        setTime(new Date());
    }

    useEffect( () => {
        console.log(count);
    }, [count])
  
    return (
      <div>
        <h2>Time: {time.toLocaleTimeString()}</h2>
        <h3>Count: {count}</h3>
        <button className="clock" onClick={update}>
          Change
        </button>
      </div>
    );
  }

export default Clock;