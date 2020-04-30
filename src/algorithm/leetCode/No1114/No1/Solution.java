package algorithm.leetCode.No1114.No1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    Lock lock = new ReentrantLock();
    Condition secoundCondition = lock.newCondition();
    Condition thirdCondition = lock.newCondition();

    volatile int times = 0;

    public Solution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            lock.lock();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            times = 2;
            secoundCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            while (times != 2) {
                secoundCondition.await();
            }
            printSecond.run();
            times = 3;
            thirdCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        try {
            lock.lock();
            // printFirst.run() outputs "first". Do not change or remove this line.
            while (times != 3) {
                thirdCondition.await();

            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FooTest01();
    }

    private static void FooTest01() {
        Solution foo = new Solution();
        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("one"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}