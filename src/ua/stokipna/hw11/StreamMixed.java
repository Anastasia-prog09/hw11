package ua.stokipna.hw11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMixed {
    public static void main(String[] args) {
        Stream<String> first = Stream.of("1", "2", "3", "4 ");
        Stream<String> second = Stream.of("A", "B", "C");

        Stream<String> result = zipIterators(first, second);

        result.peek(System.out::println).collect(Collectors.toList());
    }

    public static <T> Stream<T> zipIterators(Stream<T> first, Stream<T> second) {
        List<T> resultList = new ArrayList<>();

        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            resultList.add(iteratorFirst.next());
            resultList.add(iteratorSecond.next());
        }
        return resultList.stream();
    }
}
