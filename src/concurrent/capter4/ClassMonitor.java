package concurrent.capter4;

import java.util.concurrent.TimeUnit;

/**
 * @author ltw
 * on 2019-12-23.
 */
public class ClassMonitor {
    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + "enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method2() {
        synchronized (ClassMonitor.class) {
            System.out.println(Thread.currentThread().getName() + "enter to method2");
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(ClassMonitor::method1).start();
        new Thread(ClassMonitor::method2).start();
    }

}
