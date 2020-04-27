package algorithm.offer.lambda.java8InAction.parallelism;

import java.util.function.Function;
import java.util.stream.Stream;

public class ParallelismTest {
    public static void main(String[] args) {
        measureSumPerf(ParallelismTest::parallelSum, 100);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result:" + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    /**
     * 使用stream的方式累加 1累加到n
     *
     * @param
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, (a, b) -> a + b);
//                .reduce(0L, Long::sum);
    }

    /**
     * 不实用stream的方式进行累加 从1累加到n
     *
     * @param n
     * @return
     */
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
