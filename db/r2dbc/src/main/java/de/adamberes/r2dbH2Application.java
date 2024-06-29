package de.adamberes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class r2dbH2Application {

    public static void main(String[] args) {
        //new GenerateFakeData().GenerateFakeData();
        SpringApplication.run(r2dbH2Application.class, args); }


}
