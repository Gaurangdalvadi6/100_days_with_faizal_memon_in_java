package three.classdemo;

public class ClassObjectsDemo {

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Skoda";
        car1.speed = 100;
        car1.color = "blue";
        car1.drive();

        Car car2 = new Car();
        car2.brand = "Suzuki";
        car2.color = "Red";
        car2.speed = 80;
        car2.drive();
    }
}
