package algorithm.leetCode.No1116;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    Lock lock = new ReentrantLock();
    Condition zero = lock.newCondition();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        printNumber.accept(0);

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (n < atomicInteger.get()) {
                printNumber.accept(atomicInteger.getAndIncrement());
                lock.notifyAll();
            }
        } finally {
            lock.unlock();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (n < atomicInteger.get()) {
                printNumber.accept(atomicInteger.getAndIncrement());
                lock.notifyAll();
            }
        } finally {
            lock.unlock();
        }

    }
}
