package todo.list;

public class StudyForCalculusTask extends Task {

    public static final String name = "StudyForCalculusTask";
    public static final float defaultTimeNeeded = 3.0f;
    
    public StudyForCalculusTask(int priority) {
        super(priority, defaultTimeNeeded);
    }
    
    public StudyForCalculusTask(int priority, float timeNeeded) {
        super(priority, timeNeeded);
    }
    
    @Override
    public String toString() {
        return StudyForCalculusTask.name;
    }

}
