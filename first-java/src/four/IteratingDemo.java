package four;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratingDemo {
    public static void main(String[] args) {

        List<String> users = new ArrayList<>();
        users.add("Abhay");
        users.add("Parth");
        users.add("Harsh");

        // for each loop
        System.out.println("Using for each loop");

        for (String user:users){
            System.out.println(user);
        }

        // for loop
        System.out.println("Using for loop");

        for (int i=0;i< users.size(); i++){
            System.out.println(users.get(i));
        }

        // ITERATOR
        System.out.println("Printing using iterator");
        Iterator<String> iterator = users.iterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if (iterator.next().equals("Harsh")){
                iterator.remove();
            }
        }

        for (String  user:users){
            System.out.println(user);
        }

    }
}
