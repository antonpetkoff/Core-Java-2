package todo.list;

import java.util.PriorityQueue;

public class ToDoList {
    
    private PriorityQueue<Task> queue;
    private float remainingTime;
    private float timeNeeded;
    
    ToDoList(float remainingTime) {
        this.remainingTime = remainingTime;
        this.queue = new PriorityQueue<Task>();
        this.timeNeeded = 0.0f;
    }
    
    public float getRemainingTime() {
        return remainingTime;
    }
    
    public float getTimeNeeded() {
        return timeNeeded;
    }
    
    public void addTask(Task task) {
        if (task.getTimeNeeded() > remainingTime) {
            throw new IllegalArgumentException("");
        }
    }
    
    public void markFinished(Task task) {
        if (queue.isEmpty() ) {
            throw new IllegalStateException("No tasks in queue!");
        }
        
        if (!queue.contains(task)) {
            throw new IllegalArgumentException("No such task in queue!");
        }
        
        PriorityQueue<Task> tempQueue = new PriorityQueue<Task>(queue);
        Task tempTask = tempQueue.remove();
        while (!tempQueue.isEmpty() && !tempTask.equals(task)) {
            tempTask = tempQueue.remove();
        }
        
        tempTask.setFinished(true);
    }
    
    public void markCanceled(Task task) {
        if (!queue.contains(task)) {
            throw new IllegalArgumentException("No such task in queue!");
        }
        
        PriorityQueue<Task> newQueue = new PriorityQueue<Task>();
        
        for (Task t : queue) {
            if (!t.equals(task)) {
                newQueue.add(t);
            }
        }
        
        queue = newQueue;
    }
    
}
