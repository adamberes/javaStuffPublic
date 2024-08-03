package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2 {
    public Ex2() {
    }

    void combineDataFromTwoStreams() {
        List<String> stringListLowerCase = IntStream.range('a', 'k')
                .mapToObj(i -> String.format("%s%d", (char) i, i - 'a' + 1))
                .collect(Collectors.toList());

        List<String> stringListUpperCase = IntStream.range('A', 'K')
                .mapToObj(i -> String.format("%s%d", (char) i, i - 'A' + 1))
                .collect(Collectors.toList());

        List<String> mergedResultList = IntStream.range(0, 10)
                .mapToObj(i -> stringListUpperCase.get(i) + "-" + stringListLowerCase.get(i))
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


