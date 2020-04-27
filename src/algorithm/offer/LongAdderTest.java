package algorithm.offer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @author ltw
 * on 2020-03-24.
 */
public class LongAdderTest {
    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        int numberOfThreads = 4;
        int numberOfIncrements = 100;

        Runnable incrementAction = () -> IntStream
                .range(0, numberOfIncrements)
                .forEach(i -> counter.increment());

//        assertEquals(counter.sumThenReset(), numberOfIncrements * numberOfThreads);
//        assertEquals(counter.sum(), 0);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(incrementAction);
        }
    }
}
