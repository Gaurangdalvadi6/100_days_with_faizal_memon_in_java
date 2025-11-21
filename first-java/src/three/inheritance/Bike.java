package three.inheritance;

public class Bike extends Vehicle{
    private boolean hasCarrier;

    public Bike(String brand, int speed,boolean hasCarrier) {
        super(brand, speed);
        this.hasCarrier = hasCarrier;
    }

}
