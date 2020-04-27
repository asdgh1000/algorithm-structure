package algorithm.offer.forJoinPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author ltw
 * on 2020-03-11.
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    ForkJoinPool forkJoinPool = new ForkJoinPool(2);

    public void test() {
        int[] test = {12, 22, 12, 22, 12, 22, 12, 22, 26, 25, 12, 22, 12, 22, 12, 22, 12, 22, 26, 25,
                12, 22, 12, 22, 12, 22, 12, 22, 26, 25, 12, 22, 12, 22, 12, 22, 12, 22, 26, 25};
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(test);
        forkJoinPool.execute(customRecursiveTask);
        System.out.println(customRecursiveTask.join());
    }

    public class CustomRecursiveTask extends RecursiveTask<Integer> {
        private int[] arr;

        private static final int THRESHOLD = 20;

        public CustomRecursiveTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        protected Integer compute() {
            if (arr.length > THRESHOLD) {
                return ForkJoinTask.invokeAll(createSubtasks())
                        .stream()
                        .mapToInt(ForkJoinTask::join)
                        .sum();
            } else {
                return processing(arr);
            }
        }

        private Collection<CustomRecursiveTask> createSubtasks() {
            List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
            dividedTasks.add(new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, 0, arr.length / 2)));
            dividedTasks.add(new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
            return dividedTasks;
        }

        private Integer processing(int[] arr) {
            return Arrays.stream(arr)
                    .filter(a -> a > 10 && a < 27)
                    .map(a -> a * 10)
                    .sum();
        }
    }
}
