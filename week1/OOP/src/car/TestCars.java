package car;

import java.util.ArrayList;

public class TestCars {

    public static void main(String[] args) {
        
        // Car[] cars = new Car[4];
        Car mercedes = new Mercedes();
        Car nissan = new Nissan();
        Car audi = new Audi();
        Car chevrolet = new Chevrolet();

        Car[] cars = { mercedes, nissan, audi, chevrolet };

        for (int i = 0; i < cars.length; i++) {
            cars[i].steer();
        }
        
        ArrayList<RearWheelDrive> rwd = new ArrayList<RearWheelDrive>();
        rwd.add((RearWheelDrive) nissan);
        rwd.add((RearWheelDrive) chevrolet);
        
        for (RearWheelDrive car : rwd) {
            car.drift();
            car.crash();
        }
        
        System.out.println();
        
    }
}
