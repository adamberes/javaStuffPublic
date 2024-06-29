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
    const response = await fetch('http://localhost:8080/api/users')
      .then((response) => response.json());
      setUsers(response);};

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