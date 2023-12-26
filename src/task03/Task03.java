package task03;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Task03 {

    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(0);

        generateAndFilterTemperatures(count);
    }

    private static void generateAndFilterTemperatures(AtomicInteger count) {
        Stream<Integer> temperatureStream = generateTemperatureData();

        temperatureStream
                .filter(temperature -> temperature >= 10 && temperature <= 13)
                .forEach(temperature ->
                        System.out.println(count.incrementAndGet() + ") " + temperature + "°C")
                );
    }

    private static Stream<Integer> generateTemperatureData() {
        Random random = new Random();

        return Stream.generate(() -> random.nextInt(8) + 8)
                .limit(7);
    }
}
