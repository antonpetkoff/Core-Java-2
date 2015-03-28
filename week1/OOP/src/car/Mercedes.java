package car;

public class Mercedes extends Car {

    @Override
    public void drive() {
        System.out.println("Mercedes drives smootly");
    }

    @Override
    public void steer() {
        System.out.println("Mercedes steers");
    }    
}
