package task02;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Task02 {
    public static void main(String[] args) {

        Map<String, String> initialMap = getMapInit();
        Stream<String> nameStream = initialMap.keySet().stream();
        AtomicInteger count = Counter();
        updateAndPrintMap(nameStream, initialMap, count);
    }

    private static Map<String, String> getMapInit() {
        Map<String, String> map = new HashMap<>();
        Random random = new Random();

        map.put("laptop", String.format("%.2f", 1.05 + (3.15 - 1.05) * random.nextDouble()).replace(",", "."));
        map.put("smartphone", String.format("%.2f", 1.05 + (3.15 - 1.05) * random.nextDouble()).replace(",", "."));
        map.put("camera", String.format("%.2f", 1.05 + (3.15 - 1.05) * random.nextDouble()).replace(",", "."));
        map.put("headphones", String.format("%.2f", 1.05 + (3.15 - 1.05) * random.nextDouble()).replace(",", "."));
        map.put("printer", String.format("%.2f", 1.05 + (3.15 - 1.05) * random.nextDouble()).replace(",", "."));
        map.put("router", String.format("%.2f", 1.05 + (3.15 - 1.05) * random.nextDouble()).replace(",", "."));

        return map;
    }

    private static AtomicInteger Counter() {
        return new AtomicInteger(0);
    }

    private static void updateAndPrintMap(Stream<String> nameStream, Map<String, String> initialMap, AtomicInteger count) {
        nameStream
                .filter(name -> Double.parseDouble(initialMap.get(name)) <= 2.00)
                .forEach(name ->
                        System.out.println(count.incrementAndGet() + ") " + name + ": " + initialMap.get(name))
                );
    }
}
