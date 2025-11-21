package six;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Java","Python","DotNet");
        //  using for loop
//        for (int i = 0;i< names.size();i++){
//            System.out.println(names.get(i));
//        }

        // using for each loop
//        for (String name:names){
//            System.out.println(name);
//        }

//        names.forEach(name -> System.out.println(name));

        names.forEach(System.out::println);


    }
}
