package algorithm.leetCode.alibaba;

public class Solution4 {
    private static final Object lock = new Object();
    int result = 0;

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.count();
    }

    private void count() {
        for (int i = 0; i < 4; i++) {
            new Thread(new MyTask()).start();
        }

    }

    class MyTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (result >= 100000) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":result:" + (++result));
                    Thread.yield();
                }

            }
        }

    }

}
