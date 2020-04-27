package algorithm.leetCode.No88;

import java.util.Arrays;

/**
 * @author ltw
 * on 2020-01-13.
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j += 1;
        }
        //直接快排
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        solution.merge(num1, m, num2, n);
        for (int x : num1) {
            System.out.println(x);
        }
    }
}
