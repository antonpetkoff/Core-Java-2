package todo.list;

public class Task implements Comparable<Task> {
    
    public static final String name = "Task";
    private static final float defaultTimeNeeded = 0.0f;
    
    protected int priority;
    protected float timeNeeded;
    protected boolean isFinished;
    
    Task(int priority) {
        this.priority = priority;
        this.timeNeeded = defaultTimeNeeded;
    }
    
    Task(int priority, float timeNeeded) {
        this.priority = priority;
        this.timeNeeded = timeNeeded;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public float getTimeNeeded() {
        return timeNeeded;
    }
    
    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    
    public boolean isFinished() {
        return this.isFinished;
    }

    @Override
    public int compareTo(Task o) {
        return o.getPriority() - this.priority;
    }
    
    @Override
    public String toString() {
        return Task.name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj instanceof Task) {
            Task other = (Task) obj;
            
            if (this.priority == other.getPriority()
                && this.timeNeeded == other.getTimeNeeded()
                && this.isFinished == other.isFinished()) {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        return new Float(timeNeeded).hashCode() ^ new Integer(priority).hashCode();
    }

}
