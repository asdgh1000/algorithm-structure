package algorithm.offer;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ltw
 * on 2020-02-20.
 */
public class Print {
    //交替打印字母数字 先打印字母 后打印数字
    private static Thread t1 = null;
    private static Thread t2 = null;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            System.out.println("A");
            LockSupport.park();
            LockSupport.unpark(t2);
        });

        t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("A");
            LockSupport.unpark(t1);

        });

        t1.start();
        t2.start();

    }
}
