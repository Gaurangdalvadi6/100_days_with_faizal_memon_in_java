package three.inheritance;

public class Car extends Vehicle{
    private int doors;

    public Car(String brand, int speed,int doors) {
        super(brand, speed);
        this.doors = doors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand : "+getBrand()+" , speed "+getSpeed()+" km/hr and "+doors+" doors");
    }
}
