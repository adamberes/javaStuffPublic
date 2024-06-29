import './User.css';

function User(props){

  return(
    <tr className="user-item">
      <td>{props.items.id}</td>
      <td>{props.items.name}</td>
    </tr>
  );
}

export default User;