package algorithm.leetCode.concurrent.PrintInOrder;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 *
 *  
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * time: 12 ms 94%
 * mem: 35.9 MB 100%
 * 解题思路：
 * 这是一个典型的执行屏障的问题，可以通过构造屏障来实现。实现屏障的方式有几种，加锁 countDownLatch CyclicBarrier semaphore
 * 补充: CountDownLatch
 * CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 * 
 *
 * @author ltw
 * on 2019-10-08.
 */
class MySolution {
    CountDownLatch a = new CountDownLatch(1);
    CountDownLatch b = new CountDownLatch(1);

    public MySolution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        a.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        a.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        b.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        b.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}
