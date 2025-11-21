package seven;

import java.util.Optional;

public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        String name = "Java";
        if (name != null)
            System.out.println(name.length());
        else
            System.out.println("No name value");

        // Optional
        Optional<String> optionalString = Optional.of("Java");
        System.out.println(optionalString);

        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        Optional<String> nullable = Optional.ofNullable(null);
        System.out.println(nullable);

        // Checking values
        System.out.println(optionalString.isPresent());
        System.out.println(nullable.isPresent());

        System.out.println(optionalString.isEmpty());
        System.out.println(nullable.isEmpty());

        // get()
        System.out.println(optionalString.get());
//        System.out.println(nullable.get());

        // orElse()
        System.out.println(optionalString.orElse("default"));
        System.out.println(nullable.orElse("default"));

        // orElseGet()
        String result = nullable.orElseGet(() -> {
            System.out.println("Generating default value");
            return "Default";
        });
        System.out.println(result);
        String result2 = optionalString.orElseGet(() -> {
            System.out.println("Generating default value");
            return "Default";
        });
        System.out.println(result2);

        // orElseThrow()
        String newResult2 = optionalString.orElseThrow(()-> new RuntimeException("Not Found"));
        System.out.println(newResult2);
        String newResult = nullable.orElseThrow(()-> new RuntimeException("Not Found"));
        System.out.println(newResult);

    }
}
