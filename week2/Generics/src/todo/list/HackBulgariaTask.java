package todo.list;

public class HackBulgariaTask extends Task{

    public static final String name = "HackBulgariaTask";
    public static final float defaultTimeNeeded = 4.0f;
    
    public HackBulgariaTask(int priority) {
        super(priority, defaultTimeNeeded);
    }
    
    public HackBulgariaTask(int priority, float timeNeeded) {
        super(priority, timeNeeded);
    }

    @Override
    public String toString() {
        return HackBulgariaTask.name;
    }
    
}
