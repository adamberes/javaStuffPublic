import User from "./User";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import "./UserComps.css";
import "./Row"

function UserComps(props) {
  console.log(props);
  return (
    <div >
      <Stack spacing={1} direction="row">
      <Button variant="outlined"
        onClick={(e) => {
          e.preventDefault();
          window.location.href = 'http://localhost:8080/api/users';
        }}
      > Show Json Data
      </Button>
      </Stack>
      <TableContainer component={Paper}>
        <Table  sx={{ minWidth: 50 }} aria-label="simple table"
        >
          <TableHead >
            <TableRow sx={{ '&:last-child td, &:last-child th': { border: 4 } }}>
              <TableCell align="left">Id</TableCell>
              <TableCell align="left">Name</TableCell>
            </TableRow>
          </TableHead>
          <TableBody sx={{ '&:last-child td, &:last-child th': { border: 2 } }}>
          {props.items && props.items.map((user) => (
        <TableRow
          key={user.id}>
          <TableCell align="left">{user.id}</TableCell>
          <TableCell align="left">{user.name}</TableCell>
        </TableRow>
        ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

export default UserComps;