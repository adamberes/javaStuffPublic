package r2dbc_h2mem.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import r2dbc_h2mem.entities.Users;
import r2dbc_h2mem.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {

    @Autowired
    final private UserRepository userRepository;
    private List<Users> usersList;

    public List<Users> getUsers(){
        usersList = new ArrayList<>();
        userRepository.findAll()
                .subscribe(
                        wetter -> usersList.add(wetter),
                        error -> System.err.println("Error occurred: " + error),
                        () -> {
                            log.info("Completed fetching Wetters");
                            log.info("Wetters in the list:");
                            for (Users users : usersList) {
                                log.info(users.toString());
                            }
                        }
                );

        return usersList;
    }

}