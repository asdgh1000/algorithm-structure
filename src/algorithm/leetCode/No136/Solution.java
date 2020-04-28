package algorithm.leetCode.No136;

public class Solution {
    public int singleNumbers(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumbers(new int[]{2, 6, 8, 4, 8, 6, 4}));
    }
}
