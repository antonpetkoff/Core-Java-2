package pack.car;

public class Nissan extends Car implements RearWheelDrive {

    private boolean hasNitrous;
    
    public boolean getHasNitrous() {
        return this.hasNitrous;
    }
    
    public void setHasNitrous(boolean arg) {
        this.hasNitrous = arg;
    }
    
    @Override
    public void drive() {
        System.out.println("Nissan drives");
    }

    @Override
    public void steer() {
        System.out.println("Nissan steers very well");
    }

    @Override
    public void drift() {
        System.out.println("Nissan drifts on turns!");
    }

    @Override
    public void crash() {
        System.out.println("Nissan crashes!");
    }

}
