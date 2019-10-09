package algorithm.leetCode.concurrent.PrintInOrder;

/**
 * Suppose we have a class:
 * <p>
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 * <p>
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * time: 12 ms 94%
 * mem: 35.9 MB 100%
 * 补充: wait notify
 * 使用wait 和 notify wait:会在synchronized大锁下 进入锁等待 并阻塞代码执行。notify会 释放锁 让其他线程可以进行锁竞争 （必须在 synchronized范围内）
 *
 * @author ltw
 * on 2019-10-08.
 */
public class OtherSolution {

    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object(); //先把操作序列化

    public OtherSolution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) { //加一把大锁
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (!firstFinished) {  //之所以能直接判断 是因为 所有操作都有 synchronized大锁
                lock.wait(); //如果first变量没设置，释放lock锁
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll(); //secoundFinished设置后 释放lock锁
        }


    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
