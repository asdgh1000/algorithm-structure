package algorithm.leetCode.No1114.No1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    Lock lock = new ReentrantLock();
    volatile int stage = 1;
    Condition secound = lock.newCondition();
    Condition third = lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            stage = 2;
            secound.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (stage != 2) {
                secound.await();
            }
            printSecond.run();
            stage = 3;
            third.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (stage != 3) {
                third.await();
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
        Foo foo = new Foo();
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


