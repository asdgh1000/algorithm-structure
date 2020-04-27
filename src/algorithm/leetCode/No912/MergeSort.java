package algorithm.leetCode.No912;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{5, 4, 7, 3, 2, 8, 9, 10, 12};
        int[] result = mergeSort.sort(array, 0, array.length - 1);
        for(int a : result){
            System.out.println(a);
        }
    }

    public int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 处理左边
            sort(nums, low, mid);
            // 处理右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;


    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= high) {
            if (nums[left] >= nums[right]) {
                tmp[index++] = nums[right++];
            } else {
                tmp[index++] = nums[left++];
            }
        }
        //处理数组中剩余的部分
        while (left <= mid) {
            tmp[index++] = nums[left++];
        }
        while (right <= high) {
            tmp[index++] = nums[right++];
        }

    }
}
