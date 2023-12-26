package task03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Task03 {
    public static void main(String[] args) {

        List<Integer> temperatureData = generateTemperatureData();

        AtomicInteger count = new AtomicInteger(0);

        filterAndPrintTemperatures(temperatureData, count);
    }

    private static List<Integer> generateTemperatureData() {
        List<Integer> temperatureData = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            int temperature = random.nextInt(8) + 8; // Генеруємо температуру від +8 до +15 градусів
            temperatureData.add(temperature);
        }

        return temperatureData;
    }

    private static void filterAndPrintTemperatures(List<Integer> temperatureData, AtomicInteger count) {
        IntStream.range(0, temperatureData.size())
                .filter(i -> temperatureData.get(i) >= 10 && temperatureData.get(i) <= 13)
                .forEach(i ->
                        System.out.println(count.incrementAndGet() + ") " + temperatureData.get(i) + "°C")
                );
    }
}
