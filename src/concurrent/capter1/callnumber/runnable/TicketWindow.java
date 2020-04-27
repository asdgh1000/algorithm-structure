package concurrent.capter1.callnumber.runnable;

/**
 * 模拟银行叫号，一个线程只能叫到50个号
 * on 2019-12-23.
 */
public class TicketWindow implements Runnable {

    private static final int MAX = 50;


    private int times = 0;


    @Override
    public void run() {
        while (times < MAX) {
            System.out.println(Thread.currentThread().getName() + ":接客:" + times);
            times++;
        }
    }

}
