package algorithm.leetCode.No1114;

/**
 * @author ltw
 * on 2020-02-07.
 */
public class Solution {
    private Object lock = new Object();

    public void print() {

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("one");
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("two");
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print();
    }
}
