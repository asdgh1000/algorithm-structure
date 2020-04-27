package algorithm.leetCode.No542;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            threadId.remove();
            new Thread(() -> {
                System.out.println("threadName=" +
                        Thread.currentThread().getName() +
                        ",threadId" + ThreadId.get());
            }).start();
        }
    }
}
