package algorithm.leetCode.alibaba;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {

    private Integer start;
    private Integer end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start < 100) {
            int sumResult = 0;
            for (int i = start; i <= end; i++) {
                sumResult += i;
            }
            return sumResult;
        } else {
            //大于一百时进行分割
            int middle = (end + start) / 2;
            SumTask leftSum = new SumTask(this.start, middle);
            SumTask rightSum = new SumTask(middle, this.end);
            leftSum.fork();
            rightSum.fork();
            return leftSum.join() + rightSum.join();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        SumTask sumTask = new SumTask(1, 100000);
        forkJoinPool.submit(sumTask);
        System.out.print("result:" + sumTask.join());
    }
}

