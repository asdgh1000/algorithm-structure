package algorithm.leetCode.week03;

/**
 * @author ltw
 * on 2020-03-03.
 */
public class Solution {
    private int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
