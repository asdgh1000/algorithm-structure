package concurrent.capter1;

import java.util.concurrent.TimeUnit;

/**
 * @author ltw
 * on 2019-12-23.
 */
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(TryConcurrency::browserNews).start();
        new Thread(TryConcurrency::enjoyMusic).start();
    }

    private static void browserNews() {
        for (; ; ) {
            System.out.println("browser news");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("enjoy music");
            sleep(1);
        }

    }

    private static void sleep(int secound) {
        try {
            TimeUnit.SECONDS.sleep(secound);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
