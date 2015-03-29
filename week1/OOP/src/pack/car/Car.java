package pack.car;

public abstract class Car {
    
    protected String model;
    protected int mileage;
    protected int doorsCount;
    protected float topSpeed;
    
    public abstract void drive();
    public abstract void steer();
    
    public void accelerate() {
        System.out.println("Car vroom vroom");
    }
    
    public void stop() {
        System.out.println("Car stop");
    }
    
}

