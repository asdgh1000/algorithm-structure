//package algorithm.leetCode.alibaba;
//
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * 启动5个线程对 1-1000个线程进行求和
// */
//public class Solution3 {
//    static CountDownLatch cdl = new CountDownLatch(5);
//    static AtomicInteger ai = new AtomicInteger(0);
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new MyTask());
//        ExecutorService exec = Executors.newFixedThreadPool(100);
//        cdl.await();
//        System.out.println(ai.get());
//        exec.shutdown();
//
//    }
//
//    private void test() {
//        Thread t1 = new Thread(new MyTask());
//        Thread t2 = new Thread(new MyTask());
//        Thread t3 = new Thread(new MyTask());
//        Thread t4 = new Thread(new MyTask());
//        Thread t5 = new Thread(new MyTask());
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//
//    }
//
//    class MyTask implements Runnable {
//
//        @Override
//        public void run() {
//            for (int i = 0; i < 1000; i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + ai.getAndIncrement());
//                cdl.countDown();
//            }
//
//        }
//    }
//
//}
