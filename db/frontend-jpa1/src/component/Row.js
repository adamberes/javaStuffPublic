import TableCell from '@mui/material/TableCell';

function Row(props){

  return(
    <div>
    <tr className="user-item">
      <TableCell align="right">{props.items.id}</TableCell>
      <TableCell align="right">{props.items.name}</TableCell>
    </tr>
    </div>
  );
}

export default Row;