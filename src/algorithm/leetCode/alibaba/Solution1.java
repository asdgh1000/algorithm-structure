package algorithm.leetCode.alibaba;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 启动5个线程对 1-1000个线程进行求和
 */
public class Solution1 {
    volatile int result = 0;
    Lock lock = new ReentrantLock();

    private void print1(Runnable runnable) {
        if (result < 10000) {
            try {
                lock.lock();
                while (result <= 100000) {
                    runnable.run();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void print2(Runnable runnable) {
        if (result < 10000) {
            try {
                lock.lock();
                while (result <= 100000) {
                    runnable.run();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void print3(Runnable runnable) {
        if (result < 10000) {
            try {
                lock.lock();
                while (result <= 100000) {
                    runnable.run();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void print4(Runnable runnable) {
        if (result < 10000) {
            try {
                lock.lock();
                while (result <= 100000) {
                    runnable.run();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void print5(Runnable runnable) {
        if (result < 10000) {
            try {
                lock.lock();
                while (result <= 100000) {
                    runnable.run();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.test();
    }

    private void test() {
        Solution1 solution1 = new Solution1();

        new Thread(() -> solution1.print1(() -> {
            result++;
            System.out.println(result);
        })).start();

        new Thread(() -> solution1.print2(() -> {
            result++;
            System.out.println(result);
        })).start();
        new Thread(() -> solution1.print3(() -> {
            result++;
            System.out.println(result);
        })).start();

        new Thread(() -> solution1.print4(() -> {
            result++;
            System.out.println(result);
        })).start();
        new Thread(() -> solution1.print5(() -> {
            result++;
            System.out.println(result);
        })).start();


    }

}
