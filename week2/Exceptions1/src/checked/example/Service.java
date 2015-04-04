package checked.example;

public class Service {

    public static void useService() throws ServiceNotAvailableAtTheMoment {
        throw new ServiceNotAvailableAtTheMoment("Sad computer");
    }
    
    public static void main(String[] args) throws ServiceNotAvailableAtTheMoment {
        useService();
    }
    
}
