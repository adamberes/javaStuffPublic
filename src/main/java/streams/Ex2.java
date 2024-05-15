package streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2 {
    public Ex2() {
    }

    void combineDataFromTwoStreams() {
        AtomicInteger counter = new AtomicInteger(0);
        AtomicInteger loverCaseLetter = new AtomicInteger('a');
        AtomicInteger upperCaseLetter = new AtomicInteger('A');

        var stream1 = Stream.iterate("a",
                s -> !s.isEmpty(), (s) -> String.valueOf(String.format("%s", (char) loverCaseLetter.incrementAndGet()) + counter.incrementAndGet()))
                .limit(10)
                .collect(Collectors.toList());
        counter.set(0);
        var stream2 = Stream.iterate("A",
                s -> !s.isEmpty(), (s) -> String.valueOf(String.format("%s", (char) upperCaseLetter.incrementAndGet()) + counter.incrementAndGet()))
                .limit(10)
                .collect(Collectors.toList());
        counter.set(0);
        var stream3 = stream2.stream()
                .map(s -> s + stream1.get(counter.getAndIncrement()))
                .collect(Collectors.toList());
        System.out.println("Lover letter list: stream1");
        System.out.println(stream1);
        System.out.println("Capital letter list: stream2");
        System.out.println(stream2);
        System.out.println("Combined list: stream3 Elements from stream1 added to stream2");
        System.out.println(stream3);
    }

    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        ex2.combineDataFromTwoStreams();
    }
}


