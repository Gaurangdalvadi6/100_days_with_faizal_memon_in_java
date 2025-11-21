package four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Car{
    String brand;

    public Car(String brand) {
        this.brand = brand;
    }
}
public class ListDemo {

    public static void main(String[] args) {
        List<String> users = new ArrayList<>();
        users.add("Abhay");
        users.add("Parth");
        users.add("Harsh");

        System.out.println("All user");

        for (String user:users){
            System.out.println(user);
        }

        System.out.println("Element using index : "+ users.get(1));

        Car car1 = new Car("Mercedes");
        Car car2 = new Car("Range Rover");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
//        carList.addAll(Arrays.asList(car1,car2));

        System.out.println("====All cars====");
        for (Car car:carList){
            System.out.println(car.brand);
        }
    }
}
