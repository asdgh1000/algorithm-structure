package algorithm.offer.lambda.java8InAction.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        System.out.println(forkJoinSUm(232392));
        long sum = 0;
        for (long i = 0; i <= 232392; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     * 通过forkjoin的方式实现数据累加
     *
     * @param n
     * @return
     */
    public static long forkJoinSUm(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
