package ua.stokipna.hw11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    public static void main(String[] args) {
        System.out.println(
                namesFormatter(
                        Arrays.asList("Piter", "Ivan", "Sem", "Dmitro", "Alex")
                )
        );
        System.out.println(
                namesSorter(
                        Arrays.asList("Piter", "Ivan", "Sem", "Dmitro", "Alex")
                )
        );
        numberExtractor(
                new String[]{"1, 2, 0", "4, 5"}
        );
    }

    public static class NameHolder {
        private final String name;
        private final int index;

        public NameHolder(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return index + ". " + name;
        }
    }

    public static String namesFormatter(List<String> names) {
        int[] i = {0};
        return names.stream()
                .map(name -> {
                    i[0]++;
                    return new NameHolder(name, i[0]);
                })
                .filter(nameHolder -> nameHolder.getIndex() % 2 == 1)
                .map(NameHolder::toString)
                .collect(Collectors.joining(", "));
    }

    public static List<String> namesSorter(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted((o1, o2) -> o1.compareTo(o2) * -1)
                .collect(Collectors.toList());
    }

    public static void numberExtractor(String[] numberParts) {
        System.out.println(
                Stream.of(numberParts)
                        .flatMap(numberPart -> Stream.of(numberPart.split(",")))
                        .map(s -> Integer.parseInt(s.trim()))
                        .sorted()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
        );
    }

}
