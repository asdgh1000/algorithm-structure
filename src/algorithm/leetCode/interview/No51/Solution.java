package algorithm.leetCode.interview.No51;

/**
 * 0 <= 数组长度 <= 50000
 * 7，5，6，4
 * 7，5
 * 6，4
 * 7，6
 * 7，4
 */
class Solution {

    public int reversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reversePairs(new int[]{7, 5, 6, 4});
    }
}


//7,5,6,4
// 7|5|6|4
// 5 7 | 4 6 +2
//