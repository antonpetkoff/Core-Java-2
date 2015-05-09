package race.condition;

public class RaceConditionDemo {

    public static int counter = 0;
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                
                synchronized (lock) {
                    for (int i = 0; i < 2_000_000; ++i) {
                        ++counter;
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

                synchronized (lock) {
                    for (int i = 0; i < 2_000_000; ++i) {
                        ++counter;
                    }
                }
            }
        });
        
        long startTime = System.currentTimeMillis();
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        
        System.out.println("counter = " + counter);
        System.out.println("Duration: " + (System.currentTimeMillis() - startTime));
    }
    
}
