package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {
    public Ex1() {
    }

    void get2ListFromOneWithStreams() {
        AtomicInteger counter = new AtomicInteger(1);
        AtomicInteger loverCaseLetter = new AtomicInteger('a');
        List<String> stringListSecondResult = new ArrayList<>();

        List<String> stringListLoverCase = Stream.iterate("a1",
                        s -> !s.isEmpty(), (s) -> String.format("%s", (char) loverCaseLetter.incrementAndGet()) + counter.incrementAndGet())
                .limit(10)
                .collect(Collectors.toList());

        List<String> stringListFirstResult = stringListLoverCase.stream()
                .map(s -> {
                    stringListSecondResult.add(s.substring(1));
                    return s.substring(0,1);
                })
                .collect(Collectors.toList());

        System.out.println("Input list: stringListLoverCase");
        System.out.println(stringListLoverCase);
        System.out.println("First ResultList stringListFirstResult");
        System.out.println(stringListFirstResult);
        System.out.println("Second ResultList stringListSecondResult");
        System.out.println(stringListSecondResult);

    }

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1();
        ex1.get2ListFromOneWithStreams();
    }
}


