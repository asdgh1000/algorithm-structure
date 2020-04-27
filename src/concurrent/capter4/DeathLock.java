package concurrent.capter4;

/**
 * @author ltw
 * on 2019-12-23.
 */
public class DeathLock {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (LOCK1) {
                    synchronized (LOCK2) {
                        System.out.println("thread1");
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (LOCK2) {
                    synchronized (LOCK1) {
                        System.out.println("thread2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

}
