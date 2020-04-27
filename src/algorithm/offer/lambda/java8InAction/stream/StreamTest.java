package algorithm.offer.lambda.java8InAction.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 4, 4, 4, 6, 7, 8);

        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .limit(3)
                .skip(1)
                .forEach(System.out::println);
    }
}
