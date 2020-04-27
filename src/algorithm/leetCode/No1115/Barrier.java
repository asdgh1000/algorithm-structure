package algorithm.leetCode.No1115;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ltw
 * on 2020-01-16.
 */
public class Barrier {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
            () -> System.out.println("全部到达同步屏障" + LocalDateTime.now())); //当屏障拦截掉全部 4 个后执行 屏障操作 执行完成后 释放拦截线程

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Runnable runnable = () -> {
        while (true) {
            System.out.println("到达同步屏障" + LocalDateTime.now());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("继续执行");
        }
        };
        List<Runnable> list = Arrays.asList(runnable, runnable, runnable);
        list.forEach(runnable1 -> new Thread(runnable1).start());
        Thread.sleep(1000);
        System.out.println("最后一个线程到达同步屏障");
        cyclicBarrier.await();
        cyclicBarrier.reset();

    }

}
