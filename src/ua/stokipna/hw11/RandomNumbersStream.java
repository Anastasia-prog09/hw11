package ua.stokipna.hw11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbersStream {
    public static void main(String[] args) {
        Stream<Long> stream = generateRandomLongStream(25214903917L, 11, 1L << 48);

        stream
                .limit(5)
                .peek(System.out::println)
                .count();
    }

    public static Stream<Long> generateRandomLongStream(long a, long c, long m) {
        return Stream.iterate((long) 0, e -> (a * e + c) % m);
    }
}
