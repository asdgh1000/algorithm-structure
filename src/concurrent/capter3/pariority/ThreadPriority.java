package concurrent.capter3.pariority;

/**
 * @author ltw
 * on 2019-12-23.
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
            }
        });
        t1.setPriority(2);

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("t2");
            }
        });
        t1.setPriority(10);
        t1.start();
        t2.start();


    }
}
