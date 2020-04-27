package algorithm.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ltw
 * on 2020-02-07.
 */
public class DeadLock {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    List list = new LinkedList();

    public void test() {
        new Thread(() -> {
            while (true) {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("test1");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock2) {
                    synchronized (lock1) {
                        System.out.println("test2");
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.test();
    }
}
