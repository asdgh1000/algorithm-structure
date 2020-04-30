package algorithm.leetCode.No1188;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {
    //这道题里用不用atomicInteger都可以
    AtomicInteger atomicInteger = new AtomicInteger(0);
    //    int size = 0;
    Queue<Integer> queue;
    int capacity;
    Lock lock = new ReentrantLock();
    Condition consumer = lock.newCondition();
    Condition producer = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
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
//            size++;
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
            //这道题里用不用atomicInteger都可以
//            size--;
            int result = queue.poll();
            producer.signal();
            return result;
        } finally {
            lock.unlock();
        }

    }

    public int size() {
//        return atomicInteger.get();
//        try {
//            lock.lock();
//            return size;
//        } finally {
//            lock.unlock();
//        }
//    }
    }
}