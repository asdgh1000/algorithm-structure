package algorithm.offer;

/**
 * 交替打印数字
 * 使用synchronized
 *
 * @author ltw
 * on 2020-01-08.
 */
public class PrintNumber {

    private int i = 0;

    private Object lock = new Object();

    private void print() {
        Thread a = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    System.out.println("name:" + Thread.currentThread().getName() + "number:" + i++);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread b = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    System.out.println("name:" + Thread.currentThread().getName() + "number:" + i++);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        a.start();
        b.start();

    }

    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        printNumber.print();
    }
}
