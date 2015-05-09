package blocking.queue;

public class BlockingQueueDemo {

    public static void main(String[] args) {
        final BlockingQueue<Integer> bq = new BlockingQueue<>();
        
        Thread threadPoll = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Trying to poll from BoundedQueue");
                System.out.println("Element " + bq.poll() + " polled successfully!");
            }
        });
        
        Thread threadOffer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bq.offer(123);
                System.out.println("Element 123 offered to BlockingQueue.");
            }
        });
        
        threadPoll.start();
        threadOffer.start();
    }
    
}
