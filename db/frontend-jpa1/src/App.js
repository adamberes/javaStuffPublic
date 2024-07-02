import React from 'react';
import { useState,useEffect } from 'react';
import "./App.css";
import UserComps from './component/UserComps';

function App() {
  const [users, setUsers] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    getData();
  },[]);

  const getData = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/users');
      // check if response is ok
      if (!response.ok) {
        throw new Error('Server is not accessible');
      }
      const data = await response.json();
      setUsers(data);
    } catch (error) {
      // Set error state
      setError(error.message);
    }
  };

  if(error) {
    return <p>Error: {error}</p>;
  }

  console.log(users);

  if(error !== null ){
    return <div>Es ist ein Fehler aufgetreten</div>;
  }else {
    return (
      <div className={"App"}>
        <UserComps items={users}/>
      </div>
    );
  }
}

export default App;