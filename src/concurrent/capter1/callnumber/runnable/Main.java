package concurrent.capter1.callnumber.runnable;

/**
 * @author ltw
 * on 2019-12-23.
 */
public class Main {

    public static void main(String[] args) {
        final TicketWindow ticketWindow = new TicketWindow();
        new Thread(ticketWindow,"1号").start();
        new Thread(ticketWindow,"2号").start();
        new Thread(ticketWindow,"3号").start();
        new Thread(ticketWindow,"4号").start();
    }
}
