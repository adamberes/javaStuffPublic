package de.adamberes.controller;

import de.adamberes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.adamberes.entities.Users;

import java.util.List;

//url: r2dbc:h2:file:///C:/bin/1Project2024Java/javaStuffPublic/db.h2

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Slf4j
@RequestMapping(value = "api/")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
        public List<Users> getUsers() throws InterruptedException{
        long start = System.nanoTime();
        List<Users> usersList = userService.getUsers();
        log.info("Time in MycrosSec : " + Long.valueOf(Long.valueOf(System.nanoTime()-start))/1_000);
        return usersList;
    }
}
