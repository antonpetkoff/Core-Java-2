package blocking.queue;

public class BlockingQueueDemo {
    
    public static final int BBQ_LIMIT = 3;
    public static final int POLL_COUNT = 20;
    public static final int POLL_FREQUENCY = 10;   // in milliseconds
    public static final int OFFER_COUNT = 20;
    public static final int OFFER_FREQUENCY = 1000;   // in milliseconds

    public static void main(String[] args) throws InterruptedException {
        final BlockingBoundedQueue<Integer> bq = new BlockingBoundedQueue<>(BBQ_LIMIT);
        
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < POLL_COUNT; ++i) {
                    try {
                        Thread.sleep(POLL_FREQUENCY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println("Trying to poll from BBQ...");
                    System.out.println("Element " + bq.poll() + " polled successfully!");
                }
            }
        });
        
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < OFFER_COUNT; ++i) {
                    try {
                        Thread.sleep(OFFER_FREQUENCY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println("Trying to offer to BBQ...");
                    bq.offer(i);
                    System.out.println("Element " + i + " offered to BlockingQueue.");
                }
            }
        });
        
        consumer.start();
        producer.start();
        
        consumer.join();
        producer.join();
    }
    
}
