//package algorithm.leetCode.alibaba;
//
//import algorithm.leetCode.No23.Solution;
//
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.RecursiveTask;
//import java.util.stream.Stream;
//
//public class Solution2 {
//
//    public class SumTask extends RecursiveTask<Integer> {
//
//        private Integer start = 0;
//        private Integer end = 0;
//
//        public SumTask(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        protected Integer compute() {
//
//            if (end - start < 100) {
//                int sumResult = 0;
//                for (int i = start; i <= end; i++) {
//                    sumResult += i;
//                }
//                return sumResult;
//            } else {
//                //大于一百时进行分割
//                int middle = (end + start) / 2;
//                SumTask leftSum = new SumTask(this.start, middle);
//                SumTask rightSum = new SumTask(middle, this.end);
//                leftSum.fork();
//                rightSum.fork();
//                return leftSum.join() + rightSum.join();
//            }
//        }
//
//        public static void main(String[] args) {
//            ForkJoinPool forkJoinPool = new ForkJoinPool(5);
//            SumTask sumTask = new SumTask(1, 999999);
//            forkJoinPool.submit(sumTask);
//            System.out.print("result:" + sumTask.join());
//        }
//    }
//
////    private void test() {
////        ForkJoinPool customThreadPool = new ForkJoinPool(5);
////
////        // 生成自然数无限流
////        return customThreadPool.submit(1L, i -> i + 1)
////                // 限制到前n个数
////                .limit(100000L)
////                // 将流转为并行流
////                .parallel(5)
////                // 对所有数字求和来归纳流
////                .reduce(0L, Long::sum);
////    }
//
//    public static void main(String[] args) {
//        Solution2 solution2 = new Solution2();
//        solution2.test();
//    }
//}
