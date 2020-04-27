package algorithm.leetCode.No189;

/**
 * @author ltw
 * on 2020-01-11.
 */
class Solution {
    public void rotate(int[] nums, int k) {
        //空间复杂度O(1)
        //保存最后一个元素
        //每次移动除最后一个元素之外所有元素
        int times = k % nums.length;
        while (times > 0) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = tmp;
            times--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {-1, -100, 3, 99};
        solution.rotate(test, 2);
    }
}