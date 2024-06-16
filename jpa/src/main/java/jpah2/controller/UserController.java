package jpah2.controller;

import jpah2.entities.Wetter;
import jpah2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//url: r2dbc:h2:file:///C:/bin/1Project2024Java/javaStuffPublic/db.h2

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Slf4j
@RequestMapping(value = "api/")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("users")
        public List<Wetter> getUsers() throws InterruptedException{
        long start = System.nanoTime();
        List<Wetter> wetterList = userService.getUsers();
     //   wetterList = userService.getUsers();
        wetterList = userService.getUsers();
        log.info("Time in MycrosSec : " + Long.valueOf(Long.valueOf(System.nanoTime()-start))/1_000);
        return wetterList;
    }
}
