package algorithm.leetCode.No1115;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ltw
 * on 2020-01-16.
 */
public class FooBarCondownLatchBararrier {
    private int n;
    private CountDownLatch latch;
    private CyclicBarrier barrier;// 使用CyclicBarrier保证任务按组执行

    public FooBarCondownLatchBararrier(int n) {
        this.n = n;
        latch = new CountDownLatch(1);
        barrier = new CyclicBarrier(2);// 保证每组内有两个任务
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        try {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                latch.countDown();// printFoo方法完成调用countDown
                barrier.await();// 等待printBar方法执行完成
            }
        } catch (Exception e) {
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        try {
            for (int i = 0; i < n; i++) {
                latch.await();// 等待printFoo方法先执行
                printBar.run();
                latch = new CountDownLatch(1); // 保证下一次依旧等待printFoo方法先执行
                barrier.await();// 等待printFoo方法执行完成
            }
        } catch (Exception e) {
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
