package six;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class RealExample {

    public static void main(String[] args) {
        BiFunction<String ,Double, String> formatter = (title, price) -> title + " costs $ "+ price;

        System.out.println(formatter.apply("Java Basics ", 599.99));

        BiConsumer<String ,Double> formatter2 = (title, price) -> System.out.println(title + " costs $ "+ price);

        formatter2.accept(".Net",299.49);

        Predicate<Double> isExpensive = price -> price>500;

        System.out.println(isExpensive.test(799.45));
    }
}
