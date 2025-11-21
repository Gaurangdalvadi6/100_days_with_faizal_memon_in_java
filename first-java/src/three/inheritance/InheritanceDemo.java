package three.inheritance;

public class InheritanceDemo {

    public static void main(String[] args) {
        Car c1 = new Car("BMW",200,5);
        c1.displayInfo();

        Bike bike = new Bike("Honda",80,true);
        bike.displayInfo();
    }
}
