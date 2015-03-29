package pack.car;

public class Chevrolet extends Car implements RearWheelDrive {

    private int horsePower;
    
    public int getHorsePower() {
        return this.horsePower;
    }
    
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    
    @Override
    public void drive() {
        System.out.println("Chevrolet drives");
    }

    @Override
    public void steer() {
        System.out.println("Chevrolet steer very bad");
    }
    
    @Override
    public void drift() {
        System.out.println("Chevrolet drifts");
    }

    @Override
    public void crash() {
        System.out.println("Chevrolet crashes in the woods!");
    }
    
}
