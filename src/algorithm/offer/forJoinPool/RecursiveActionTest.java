package algorithm.offer.forJoinPool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author ltw
 * on 2020-03-11.
 */
public class RecursiveActionTest {
    static class Sorter extends RecursiveAction {
        public static void sort(long[] array) {
            ForkJoinPool.commonPool().invoke(new Sorter(array, 0, array.length));
        }

        private final long[] array;
        private final int lo, hi;

        private Sorter(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        private static final int THRESHOLD = 1000;

        @Override
        protected void compute() {
            // 数组长度小于1000直接排序
            if (hi - lo < THRESHOLD)
                Arrays.sort(array, lo, hi);
            else {
                int mid = (lo + hi) >>> 1;
                // 数组长度大于1000，将数组平分为两份
                // 由两个子任务进行排序
                Sorter left = new Sorter(array, lo, mid);
                Sorter right = new Sorter(array, mid, hi);
                invokeAll(left, right);
                // 排序完成后合并排序结果
                merge(lo, mid, hi);
            }
        }

        private void merge(int lo, int mid, int hi) {
            long[] buf = Arrays.copyOfRange(array, lo, mid);
            for (int i = 0, j = lo, k = mid; i < buf.length; j++) {
                if (k == hi || buf[i] < array[k]) {
                    array[j] = buf[i++];
                } else {
                    array[j] = array[k++];
                }
            }
        }
    }

    public static void main(String[] args) {
        long[] array = new Random().longs(100_0000).toArray();
        Sorter.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
