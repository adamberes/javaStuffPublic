package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2 {
    public Ex2() {
    }

    void combineDataFromTwoStreams() {
        AtomicInteger counter = new AtomicInteger(1);
        AtomicInteger lowerCaseLetter = new AtomicInteger('a');
        AtomicInteger upperCaseLetter = new AtomicInteger('A');

        List<String> stringListLowerCase = Stream.iterate("a1",
                        s -> !s.isEmpty(), (s) -> String.format("%s", (char) lowerCaseLetter.incrementAndGet()) + counter.incrementAndGet())
                .limit(10)
                .toList();

        counter.set(1);
        List<String> stringListUpperCase = Stream.iterate("A1",
                        s -> !s.isEmpty(), (s) -> String.format("%s", (char) upperCaseLetter.incrementAndGet()) + counter.incrementAndGet())
                .limit(10)
                .collect(Collectors.toList());

        counter.set(0);
        List<String> mergedResultList = stringListUpperCase.stream()
                .map(s -> s + "-" + stringListLowerCase.get(counter.getAndIncrement()))
                .collect(Collectors.toList());

        System.out.println("Lower letter list: stringListLowerCase");
        System.out.println(stringListLowerCase);
        System.out.println("Capital letter list: stringListUpperCase");
        System.out.println(stringListUpperCase);
        System.out.println("Combined list: mergedResultList Elements from stringListLowerCase added to stringListUpperCase");
        System.out.println(mergedResultList);
    }

    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        ex2.combineDataFromTwoStreams();
    }
}


