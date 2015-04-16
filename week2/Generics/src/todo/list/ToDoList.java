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
    
    /**
     * increment timeNeeded
     * 
     */
    public void addTask(Task task) {
//        if (task.getTimeNeeded() > remainingTime) {
//            throw new IllegalArgumentException("");
//        }
//        
//        while ((task.getTimeNeeded() + this.timeNeeded) > this.remainingTime) {
//            queue.remove();
//        }
//        
//        queue.add(task);
        queue.add(task);
        timeNeeded += task.getTimeNeeded();
    }
    
    /**
     * subtracts from the remaining time
     * subtract from timeNeeded to maintain accuracy
     */
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
        timeNeeded -= tempTask.getTimeNeeded();
    }
    
    /**
     * removes the task from the queue, without subtracting from remainingTime
     * subtract from timeNeeded to maintain accuracy
     */
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
        timeNeeded -= task.getTimeNeeded();
    }
    
    public boolean canFinish() {
        return remainingTime - timeNeeded >= 0;
    }
    
    public Task top() {
        return queue.peek();
    }
    
    public static void main(String[] args) {
        ToDoList todo = new ToDoList(11);       // 11 hours remaining!
        todo.addTask(new StudyForCalculusTask(10, 3.0f));
        todo.addTask(new HackBulgariaTask(7, 4.0f));
        todo.addTask(new GoOutTask(2, 3.0f));
        todo.addTask(new SleepTask(1, 8.0f));

        if (todo.canFinish()){
            System.out.println("Woohoo!");
        } else {
            System.out.println("I am ...screwed :(");
        }

        System.out.println(todo.top()); //StudyForAlgebraTask
        System.out.println(todo.getTimeNeeded()); //sum of the time needed for every task added in todo list
    }
    
}
