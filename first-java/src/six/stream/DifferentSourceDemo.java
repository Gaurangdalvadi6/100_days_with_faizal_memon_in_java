package six.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DifferentSourceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> integerStream = numbers.stream();
        integerStream.forEach(System.out::println);


        int[] numberArray = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(numberArray);
        intStream.forEach(System.out::println);

        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
        stringStream.forEach(System.out::println);

        List<String> stringList = Stream.of("A", "B", "C", "D").collect(Collectors.toList());
        System.out.println(stringList);
    }
}
