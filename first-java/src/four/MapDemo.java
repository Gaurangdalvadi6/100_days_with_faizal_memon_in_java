package four;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> userMap = new HashMap<>();
        userMap.put(1,"Vibhu");
        userMap.put(2,"Devanshu");
        userMap.put(3,"Sunil");

        System.out.println("All users : ");

        for (Map.Entry<Integer,String> entry: userMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
