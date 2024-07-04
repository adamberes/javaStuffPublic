package de.adamberes.controller;

import de.adamberes.entities.Userx;
import de.adamberes.service.UserxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//url: r2dbc:h2:file:///C:/bin/1Project2024Java/javaStuffPublic/db.h2

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Slf4j
@RequestMapping(value = "api/")
@RequiredArgsConstructor
public class UserxController {
    @Autowired
    private final UserxService userxService;
    long start;

    @GetMapping("users")
    public List<Userx> getUserx() throws InterruptedException{
        start = System.nanoTime();
        List<Userx> userxList = userxService.getUsers();
        log.info(logTime());
        return userxList;
    }
    @GetMapping("add")
    public List<Userx> addUserx() throws InterruptedException{
        List<Userx> userxList = new ArrayList<>();
        start = System.nanoTime();
        Userx userx = new Userx();
        userx.setId(1004);
        userx.setName("test");
        userxList.add(userxService.saveUserx(userx));
        log.info(logTime());
        return userxList;
    }
    String logTime() {
        return "Time in MycrosSec : " + Long.valueOf(Long.valueOf(System.nanoTime()-start))/1_000;
    }
}
