package algorithm.leetCode.week03.Tmp;

/**
 * @author ltw
 * on 2020-03-02.
 */
public class Solution {
//    left, right = 0, len(array) - 1
//
//            while left <= right:
//    mid = (left + right) / 2
//            if array[mid] == target:
//            # find the target!!
//            break or return result
//    elif array[mid] < target:
//    left = mid + 1
//            else:
//    right = mid - 1

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
        return -1; //没找到
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] origin = {2, 3, 4, 5, 6, 7, 10, 12, 14, 16, 18};
        System.out.println(solution.binarySearch(origin, 11));
    }
}
