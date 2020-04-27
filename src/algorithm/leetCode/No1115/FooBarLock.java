package algorithm.leetCode.No1115;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ltw
 * on 2020-01-15.
 */
class FooBarLock {
    private int n;

    public FooBarLock(int n) {
        this.n = n;
    }

    //核心在lock 设置为公平锁
    private Lock lock = new ReentrantLock(true);

    public void foo(Runnable printFoo) {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                printFoo.run();
            } finally {
                lock.unlock();
                //因为lock是公平锁，因此当这边解锁后，线程bar因为等待时间更长因此 会优先执行
            }
        }
    }

    public void bar(Runnable printBar) {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                printBar.run();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        FooBar fb = new FooBar(10);

        new Thread(() -> {
            try {
                fb.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
