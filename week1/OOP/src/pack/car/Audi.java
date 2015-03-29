package pack.car;

public class Audi extends Car implements GetProperties, AllWheelDrive {

    public void putPigInTrunk() {
        System.out.println("oink oink");
    }

    @Override
    public void drive() {
        System.out.println("Audi drives");
    }

    @Override
    public void steer() {
        System.out.println("Audi steers");
    }
    
    @Override
    public int getMileage() {
        return this.mileage;
    }

    @Override
    public void climbMountain() {
        System.out.println("Audi is AWD and climbs the mountain");
    }

}
