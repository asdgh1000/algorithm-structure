package algorithm.leetCode.geek.geekforgeeks.sort;

public class MergeSort {

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sort(nums, left, middle);
            sort(nums, middle + 1, right);
            merge(nums, left, middle, right);
        }
    }

    private void merge(int[] nums, int left, int middle, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int n = 0;
        while (i <= middle && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[n++] = nums[i++];
            } else {
                tmp[n++] = nums[j++];
            }
        }


        // 将左边序列中剩余的数放入临时数组
        while (i <= middle) {
            tmp[n++] = nums[i++];
        }
        // 将右边序列中剩余的数放入临时数组
        while (j <= right) {
            tmp[n++] = nums[j++];
        }

        for (int x = 0; x < tmp.length; x++) {
            nums[left++] = tmp[x];
        }
    }

    public static void main(String[] args) {
        BubleSort bubleSort = new BubleSort();
        int[] test = new int[]{5, 3, 6, 2, 7, 10, 9};
        bubleSort.sort(test);
        for (int i = 0; i < test.length; i++) {

            System.out.println(test[i]);
        }
    }
}
