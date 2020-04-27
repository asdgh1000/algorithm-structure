//package algorithm.leetCode.again.No1116;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.function.IntConsumer;
//
//class ZeroEvenOdd {
//    private int n;
//
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    Lock lock = new ReentrantLock();
//    Condition condition1 = lock.newCondition();
//    Condition condition2 = lock.newCondition();
//    Condition condition3 = lock.newCondition();
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        lock.lock();
//        try {
//            if (2 * n % 4 == 1 || 2 * n % 4 == 3) {
//
//                printNumber.accept(0);
//            } else {
//                if (2 * n % 4 == 2) {
//                    condition1.signal();
//                    lock.unlock();
//                }
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    /**
//     * 偶数
//     * @param printNumber
//     * @throws InterruptedException
//     */
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        lock.lock();
//        try {
//            if(2*n%4==2) {
//                printNumber.accept(0);
//                condition1.signal();
//            }else if(){
//
//            }
//        } finally {
//            lock.unlock();
//        }
//
//    }
//
//    /**
//     * 奇数
//     * @param printNumber
//     * @throws InterruptedException
//     */
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        lock.lock();
//        try {
//            printNumber.accept(0);
//        } finally {
//            lock.unlock();
//        }
//
//    }
//
//    public static void main(String[] args) {
//    }
//
//    public void test() {
//        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
//        new Thread(() -> {
//            try {
//                zeroEvenOdd.zero((x) -> {
//                    System.out.println(x);
//                });
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                zeroEvenOdd.even((x) -> {
//                    System.out.println(x);
//                });
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                zeroEvenOdd.odd((x) -> {
//                    System.out.println(x);
//                });
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }
//}