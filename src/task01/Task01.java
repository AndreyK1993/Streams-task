package task01;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.Arrays;

public class Task01 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("orange", "plum", "grape", "apple",
                "banana", "pear");

        Stream<String> nameStream = names.stream();

        AtomicInteger count = Counter();

        filterAndPrintNames(nameStream, count);
    }

    private static AtomicInteger Counter() {
        return new AtomicInteger(0);
    }

    private static void filterAndPrintNames(Stream<String> nameStream, AtomicInteger count) {
        nameStream
                .filter(str -> str.startsWith("a"))
                .forEach(str ->
                        System.out.println(count.incrementAndGet() + ") " + str)
                );
    }
}
