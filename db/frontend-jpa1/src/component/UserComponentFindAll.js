import React from 'react';
import UserService from '../services/UserServiceFindAll';
import styled from 'styled-components';

const Button = styled.button`
  background-color: black;
  color: white;
  font-size: 20px;
  padding: 10px 60px;
  border-radius: 5px;
  margin: 10px 0px;
  cursor: pointer;
`;

function sayHello() {
    alert('You clicked me!');
}
class UserComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ users: response.data})
        });
    }

    render (){
        return (
            <div>
                <a href="https://react.school" target="_blank">
                    <Button> Link Button </Button>
                </a>
                <Button onClick={sayHello}>Default1</Button>
                <Button onClick={sayHello}>Default2</Button>
                <h1 className = "text-center"> Users List</h1>
                <form>
                    <label>
                        Name:
                        <input type="text" name="name" />
                    </label>
                    <input type="submit" value="Submit" />
                </form>
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> User Id</td>
                            <td> User Name</td>
                            <td> User Password2</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user => 
                                <tr key = {user.id}>
                                     <td> {user.id}</td>   
                                     <td> {user.name}</td>   
                                     <td> {user.passwort}</td>   
                                </tr>
                            )
                        }

                        </tbody>
                    </table>
    
                </div>
    
            )
        }
    }
    
    export default UserComponent