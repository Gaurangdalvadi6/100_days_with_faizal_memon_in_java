package four;

import java.util.*;

public class UserManagementDemo {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Parth",true,new HashSet<>(Arrays.asList("ADMIN","USER","Manager"))));
        users.add(new User("Abhay",false,new HashSet<>(Arrays.asList("USER"))));
        users.add(new User("Dev",true,new HashSet<>(Arrays.asList("Manager"))));

        // remove inactive user
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            if (!iterator.next().isActive()){
                iterator.remove();
            }
        }

        // active user
        System.out.println("ACTIVE users");
        for (User user:users){
            System.out.println(user.getName());
        }

        // count user per role
        Map<String,Integer> roleCount = new HashMap<>();
        for (User user:users){
            for (String role: user.getRoles()){
                roleCount.put(role,roleCount.getOrDefault(role,0)+1);
            }
        }

        System.out.println("All roles : count");
        for (Map.Entry<String,Integer> entry: roleCount.entrySet()){
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }
    }
}
