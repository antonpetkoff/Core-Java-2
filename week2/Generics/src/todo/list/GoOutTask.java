package todo.list;

public class GoOutTask extends Task {

    public static final String name = "GoOutTask";
    public static final float defaultTimeNeeded = 2.0f;
    
    public GoOutTask(int priority) {
        super(priority, defaultTimeNeeded);
    }
    
    public GoOutTask(int priority, float timeNeeded) {
        super(priority, timeNeeded);
    }

    @Override
    public String toString() {
        return GoOutTask.name;
    }
    
}
