package six.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,10,30,40,55);

        // reduce()
        // full explain
        Stream<Integer> integerStream = numbers.stream();
//        Integer reduce = integerStream.reduce(0, (acc, num) -> acc + num);
        Integer reduce = integerStream.reduce(0, Integer::sum);
        System.out.println("Sum : "+ reduce);

        // short way to write
        int total = numbers.stream().reduce(0,Integer::sum);
        System.out.println("Total : " + total);

        // collect()
        //even number list
        List<Integer> integerList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even number list : " + integerList);

        // even number and remove duplicate value
        Set<Integer> integerSet = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println("Even number and remove duplicate : " + integerSet);

        // find & match
        System.out.println("Find First : "+ numbers.stream().findFirst().get());
        System.out.println("Find Any : "+ numbers.stream().findAny().get());
        boolean b = numbers.stream().anyMatch(n -> n == 400);
        System.out.println(b);

        // iteration
        numbers.stream()
                .forEach(System.out::println);

    }
}
