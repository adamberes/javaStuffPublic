package de.jpah2.service;

import de.jpah2.entities.Userx;
import de.jpah2.repository.UserxRepositoryJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserxService {

    final private UserxRepositoryJpa userxRepositoryJpa;

    public UserxService(UserxRepositoryJpa userxRepositoryJpa) {
        this.userxRepositoryJpa = userxRepositoryJpa;
    }

    public List<Userx> getUsers(){
        return userxRepositoryJpa.findAll();
    }

}