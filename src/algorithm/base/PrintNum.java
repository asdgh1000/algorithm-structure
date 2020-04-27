package algorithm.base;

/**
 * @author ltw
 * on 2019-12-30.
 */
public class PrintNum {
    Object lock = new Object();
    int a = 0;
    Thread t1 = new Thread(() -> {
        while (true) {
            synchronized (lock) {
                lock.notify();
                if (a < 100)
                    System.out.println("thread:" + Thread.currentThread() + "a:" + a++);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    });
    Thread t2 = new Thread(() -> {
        while (true) {
            synchronized (lock) {
                lock.notify();
                if (a < 100)
                    System.out.println("thread:" + Thread.currentThread() + "a:" + a++);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    private void test() {
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        printNum.test();
    }
}
