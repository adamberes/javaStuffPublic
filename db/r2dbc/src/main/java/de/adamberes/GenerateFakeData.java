package de.adamberes;

import com.github.javafaker.Faker;

import java.util.stream.IntStream;

public class GenerateFakeData {
    public void GenerateFakeData() {
        IntStream.range(0, 1_000).forEach(i -> {
            Faker faker = new Faker();
            String fact = faker.chuckNorris().fact();
            fact = fact.replace("'", "");
            fact = fact.replace(";", "");
            System.out.println("insert into users values (" + i + ", '" +  fact + "');");
        });
    }
}
