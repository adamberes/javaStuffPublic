package de.adamberes.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.adamberes.entities.Users;
import de.adamberes.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    final private UserRepository userRepository;
    private List<Users> usersList;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers(){
        usersList = new ArrayList<>();
        userRepository.findAll()
                .subscribe(
                        wetter -> usersList.add(wetter),
                        error -> System.err.println("Error occurred: " + error),
                        () -> {
                            log.info("Completed fetching Wetters");
                            log.info("Wetters in the list:");
//                            for (Users users : usersList) {
//                                log.info(users.toString());
//                            }
                        }
                );
        return usersList;
    }

}