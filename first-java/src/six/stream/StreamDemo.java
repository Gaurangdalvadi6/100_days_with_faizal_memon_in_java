package six.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Gujarati","Hindi","English");

//        for (int i = 0; i < languages.size(); i++) {
//            System.out.println(languages.get(i));
//        }

//        for (String language:languages){
//            System.out.println(language);
//        }

//        languages.forEach(language -> System.out.println(language));

        Stream<String> stream = languages.stream();
        stream.forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("Filtered stream");
        Stream<String> streamNew = languages.stream().filter(name -> name.startsWith("G"));
        streamNew.forEach(System.out::println);
    }
}
