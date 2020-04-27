package algorithm.offer;

/**
 * @author ltw
 * on 2020-03-23.
 */
public class Interesting {
    public static void main(String[] args) {

        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }

    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add() {
        System.out.println("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        System.out.println("add done");
    }

    public synchronized void compare() {
        System.out.println("compare start");
        for (int i = 0; i < 10000; i++) { //a始终等于b吗？
            if (a < b) {
                System.out.println("a:{},b:{},{}" + a + "  " + b + "   " + (a > b)); //最后的a>b应该始终是false吗？
            }
            System.out.println("a:{},b:{},{}" + a + "  " + b + "   " + (a > b)); //最后的a>b应该始终是false吗？
        }
        System.out.println("compare done");
    }
}
