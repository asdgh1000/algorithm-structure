package algorithm.offer;

import java.util.concurrent.CountDownLatch;

/**
 * 交替打印数字
 * 使用synchronized
 *
 * @author ltw
 * on 2020-01-08.
 */
public class Print2 {

    private int i = 0;

    private final Object lock = new Object();

    private static volatile boolean aStart = false; //为了保证线程执行是有顺序的

//    private static CountDownLatch latch = new CountDownLatch(1);

    private void print() {
        Thread a = new Thread(() -> {
            //latch.await(); //当前线程 //或者用countDownLatch的方式 保证需要b线程执行后a线程才能执行 ，
            // 其实countDownLatch就是增加了 aStart这样的一个 标示 这个标识可以当作计数器
            synchronized (lock) {
                if (!aStart) { //加这个的目的主要是为了 让 b线程永远限制性
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (i < 100) {
                    System.out.println("A");
                    i++;
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify(); //为了使线程最后能够停止
            }
        });
        Thread b = new Thread(() -> {
            synchronized (lock) {
                aStart = true;
                while (i < 100) {
                    try {
                        System.out.println("1");
                        i++;
            //            latch.countDown();//打印完数字之后才允许另一个线程执行 这个操作实际上只会在线程启动时起到作用
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify(); //为了使线程最后能够停止
            }

        });
        a.start();
        b.start();

    }

    public static void main(String[] args) {
        Print2 printNumber = new Print2();
        printNumber.print();
    }
}
