package three.constructor;

public class Car {

    String brand;
    String color;
    int speed;

//    public Car(String brand, String color, int speed) {
//        System.out.println("Constructor is called...");
//        this.brand = brand;
//        this.color = color;
//        this.speed = speed;
//    }


    public Car() {
    }

    public Car(String brand, String color, int speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }

    public void drive() {
        System.out.println(brand+ " is driving at "+ speed + " km");
    }
}
