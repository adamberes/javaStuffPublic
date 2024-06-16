package jpah2.service;

import jpah2.repository.UserRepositoryJpa;
import jpah2.entities.Wetter;
import jpah2.repository.UserRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {

    @Autowired
    final private UserRepositoryJpa userRepository;

    public List<Wetter> getUsers(){
        return userRepository.findAll();
    }

}