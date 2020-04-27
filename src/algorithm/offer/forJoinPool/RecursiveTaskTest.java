package algorithm.offer.forJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * @author ltw
 * on 2020-03-11.
 */
public class RecursiveTaskTest {
    static class Sum extends RecursiveTask<Long> {
        public static long sum(int[] array) {
            return ForkJoinPool.commonPool().invoke(new Sum(array, 0, array.length));
        }

        private final int[] array;
        private final int lo, hi;

        private Sum(int[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        private static final int THRESHOLD = 600;

        @Override
        protected Long compute() {
            if (hi - lo < THRESHOLD) {
                AtomicLong i = new AtomicLong();
                i.incrementAndGet();
                return sumSequentially();
            } else {
                int middle = (lo + hi) >>> 1;
                Sum left = new Sum(array, lo, middle);
                Sum right = new Sum(array, middle, hi);
                right.fork();
                long leftAns = left.compute();
                long rightAns = right.join();
                // 注意subTask2.fork要在subTask1.compute之前
                // 因为这里的subTask1.compute实际上是同步计算的
                return leftAns + rightAns;
            }
        }

        private long sumSequentially() {
            long sum = 0;
            for (int i = lo; i < hi; i++) {
                sum += array[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] array = IntStream.rangeClosed(1, 100_0000).toArray();
        Long sum = Sum.sum(array);
        System.out.println(sum);
    }
}
