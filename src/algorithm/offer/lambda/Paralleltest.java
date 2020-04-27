package algorithm.offer.lambda;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * @author ltw
 * on 2020-03-25.
 */
public class Paralleltest {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).parallel().forEach(i -> {
            System.out.println(LocalDateTime.now() + ":" + i);
            try {
                Thread.sleep(10000);
                System.out.println("---------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
