package algorithm.leetCode.No1115;

/**
 * @author ltw
 * on 2020-01-15.
 */
class FooBar {
    private int n;
    private final Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                printFoo.run();
                lock.notify();
                if(i==n-1){
                   break;
                }
                lock.wait();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                printBar.run();
                lock.notify();
                if(i==n-1){
                    break;
                }
                lock.wait();
            }


        }
    }


    public static void main(String[] args) {
        FooBar fb = new FooBar(10);

        new Thread(() -> {
            try {
                fb.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
