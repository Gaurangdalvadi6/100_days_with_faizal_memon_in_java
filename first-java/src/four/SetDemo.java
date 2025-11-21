package four;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> rules = new HashSet<>();
        rules.add("ADMIN");
        rules.add("USER");
        rules.add("MANAGER");

        System.out.println("Rules : ");

        for (String rule:rules) {
            System.out.println(rule);
        }
    }
}
