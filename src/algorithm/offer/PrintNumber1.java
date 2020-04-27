package algorithm.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印数字
 * 使用 ReentrantLock 和 condition
 *
 * @author ltw
 * on 2020-01-08.
 */
public class PrintNumber1 {

    private int i = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition(); //仅使用一个 condition也一样实现
    private Condition condition2 = lock.newCondition();

    private void print() {

        Thread a = new Thread(() -> {
            lock.lock();
            ThreadLocal t = new ThreadLocal();
            try {
                while (i <= 100) {
                    Thread.sleep(10000);
                    System.out.println("name:" + Thread.currentThread().getName() + "number:" + i++);
                    condition2.await();
                    condition1.signal();
                }
                condition1.signal();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            lock.lock();
            try {
                while (i <= 100) {
                    Thread.sleep(10000);
                    System.out.println("name:" + Thread.currentThread().getName() + "number:" + i++);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        a.start();
        b.start();
    }

    public static void main(String[] args) {
        PrintNumber1 printNumber1 = new PrintNumber1();
        printNumber1.print();
    }
}
