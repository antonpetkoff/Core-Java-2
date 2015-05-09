package race.condition;

import java.util.concurrent.atomic.AtomicInteger;

import sun.awt.Mutex;

public class RaceConditionDemo {

    //public static AtomicInteger counter = new AtomicInteger(0);
    public static int counter = 0;
    public static Mutex mutex = new Mutex();
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                
                for (int i = 0; i < 2_000_000; ++i) {
                    mutex.lock();
                    //counter.incrementAndGet();
                    ++counter;
                    mutex.unlock();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

                for (int i = 0; i < 2_000_000; ++i) {
                    mutex.lock();    
                    //counter.incrementAndGet();
                    ++counter;
                    mutex.unlock();
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
