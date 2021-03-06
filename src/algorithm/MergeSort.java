package algorithm;

/**
 * @author ltw
 * on 2019-12-22.
 */
public class MergeSort {
    /**
     * 递归拆分
     *
     * @param arr   待拆分数组
     * @param left  待拆分数组最小下标
     * @param right 待拆分数组最大下标
     */
    public static void mergeSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;  // 中间下标
        if (left < right) {
            mergeSort(arr, left, mid); // 递归拆分左边
            mergeSort(arr, mid + 1, right); // 递归拆分右边
            merge(arr, left, mid, right); // 合并左右
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 合并两个有序子序列
     *
     * @param arr   待合并数组
     * @param left  待合并数组最小下标
     * @param mid   待合并数组中间下标
     * @param right 待合并数组最大下标
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 临时数组，用来保存每次合并年之后的结果
        int i = left;
        int j = mid + 1;
        int k = 0; // 临时数组的初始下标
        // 这个while循环能够初步筛选出待合并的了两个子序列中的较小数
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 将左边序列中剩余的数放入临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 将右边序列中剩余的数放入临时数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 将临时数组中的元素位置对应到真真实的数组中
        for (int m = 0; m < temp.length; m++) {
            arr[m + left] = temp[m];
        }
    }


    public static void main(String[] agrs) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {3, 5, 3, 6, 2, 5, 7};
        mergeSort.mergeSort(a, 0, a.length - 1);
    }

}
