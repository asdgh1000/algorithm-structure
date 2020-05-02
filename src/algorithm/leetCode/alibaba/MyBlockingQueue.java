package algorithm.leetCode.alibaba;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {

    AtomicInteger atomicInteger = new AtomicInteger(0);
    Queue<Integer> queue;
    int capacity;
    Lock lock = new ReentrantLock();
    Condition consumer = lock.newCondition();
    Condition producer = lock.newCondition();

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<>(capacity);
    }


    public void enqueue(int element) throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() == capacity) {
                producer.await();
            }
            queue.add(element);
            atomicInteger.incrementAndGet();
            consumer.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                consumer.await();
            }
            atomicInteger.decrementAndGet();
            int result = queue.poll();
            producer.signal();
            return result;
        } finally {
            lock.unlock();
        }

    }

    public boolean isEmpty() {
        lock.lock();
        try {
            return capacity == 0;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return atomicInteger.get();
    }

    public static void main(String[] args) {
        AtomicInteger result = new AtomicInteger();
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(100);
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    myBlockingQueue.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (!myBlockingQueue.isEmpty()) {
                try {
                    System.out.println(result.addAndGet(myBlockingQueue.dequeue()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
