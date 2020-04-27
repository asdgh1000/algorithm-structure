package algorithm.leetCode.No1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ltw
 * on 2020-02-07.
 */
class Foo {

    public Foo() {

    }

    private Lock lock = new ReentrantLock();
    Condition first = lock.newCondition();
    Condition secound = lock.newCondition();
    Condition third = lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        secound.await();
        third.await();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock.unlock();
        secound.signal();

    }

    public void second(Runnable printSecond) throws InterruptedException {

        lock.lock();
        third.await();
        first.await();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printSecond.run();
        lock.unlock();
        third.signal();
    }

    public void third(Runnable printThird) throws InterruptedException {

        lock.lock();
        third.await();
        first.await();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printThird.run();
        lock.unlock();
        third.signal();
    }

}