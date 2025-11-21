package six;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static BiFunction<Integer,Integer,Integer> biFunction = (a,b) -> a+b;

    public static BiFunction<Integer,Integer,Integer> subStraction = (a,b) -> a-b;

    public static void main(String[] args) {
        System.out.println(biFunction.apply(5,4));
        System.out.println(subStraction.apply(10,3));
    }
}
