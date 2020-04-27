package concurrent.capter1.callnumber.thread;

/**
 * @author ltw
 * on 2019-12-23.
 */
public class Main {

    public static void main(String[] args) {
//        new TicketWindow("1").start();
//        new TicketWindow("2").start();
//        new TicketWindow("3").start();
//        new TicketWindow("4").start();
        TicketWindow test = new TicketWindow("1");
        new Thread(test,"1").start();
        new Thread(test,"2").start();
        new Thread(test,"3").start();
        new Thread(test,"4").start();

    }
}
