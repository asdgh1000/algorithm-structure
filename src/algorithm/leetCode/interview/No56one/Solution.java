package algorithm.leetCode.interview.No56one;

/**
 * 要求:
 * 时间复杂度O(n)
 * 空间复杂度:O(1)
 * 因此不能考虑嵌套循环
 */
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


