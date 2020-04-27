package algorithm.leetCode.No670;

/**
 * @author ltw
 * on 2020-01-09.
 */
class Solution {
    public int maximumSwap(int num) {
        int times = num / 10 + 1;
        int[] arr = new int[times];
        for (int i = 0; i < times; i++) {
            if (i == 0) {
                arr[i] = num % 10;
            } else {
                arr[i] = num % 10 * i;
            }
        }

        //1.调用findAnotherMax
        //2.如果找到做交换
        //遍历原数组下一个，如果交换完成两次 终止，返回最大数字
        return 0;
    }

    //1.倒序遍历index，找到比当前index大的最大数的最后一个数的index 如果找不到返回-1
    private int findAnotherMax(int index) {
        return 0;
    }
}
