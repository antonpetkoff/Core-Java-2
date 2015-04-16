package todo.list;

public class SleepTask extends Task {

    public static final String name = "Sleep";
    private static final float defaultTimeNeeded = 8.0f;
    
    SleepTask(int priority) {
        super(priority, defaultTimeNeeded);
    }

    SleepTask(int priority, float timeNeeded) {
        super(priority, timeNeeded);
    }
    
    @Override
    public String toString() {
        return SleepTask.name;
    }

}
