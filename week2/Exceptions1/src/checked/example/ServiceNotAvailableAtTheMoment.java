package checked.example;

public class ServiceNotAvailableAtTheMoment extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 7995360238199309758L;

    public ServiceNotAvailableAtTheMoment(String msg) {
        super(msg);
    }
    
}
