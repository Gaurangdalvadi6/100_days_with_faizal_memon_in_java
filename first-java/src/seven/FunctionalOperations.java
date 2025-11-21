package seven;

import java.util.Optional;

public class FunctionalOperations {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Java");
        Optional<String> nullable = Optional.ofNullable(null);

        // ifPresent()
//        name.ifPresent((value)-> System.out.println(value));
        name.ifPresent(System.out::println);
        nullable.ifPresent(value -> {
            System.out.println(value);
            System.out.println("Hello");
        });

        // map()
        String lowerCase = name.map(String::toLowerCase).orElse(null);
        System.out.println(lowerCase);
        String upperCaseName2 = nullable.map(String::toUpperCase).orElse(null);
        System.out.println(upperCaseName2);

        System.out.println();
        // filter()
        name.filter(s -> s.startsWith("K"))
                .ifPresent(System.out::println);

        System.out.println();
        // Combined Operation
        name.filter(s -> s.startsWith("J"))
                .map(s -> s.toUpperCase())
                .ifPresent(System.out::println);
    }
}
