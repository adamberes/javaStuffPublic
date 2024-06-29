import axios from 'axios'

//const USERS_FINDALL_REST_API_URL = 'http://localhost:8080/api/findallbyname';
const USERS_FINDALL_REST_API_URL = 'http://localhost:8080/api/users';

class UserServiceFindAll {

    getUsers2(){
        return axios.get(USERS_FINDALL_REST_API_URL);
    }
}

export default new UserServiceFindAll();