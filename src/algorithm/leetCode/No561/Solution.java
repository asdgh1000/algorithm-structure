package algorithm.leetCode.No561;

import java.util.Arrays;

class Solution {
    //    public int arrayPairSum(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        int sum = 0;
//        while (left < right) {
//            sum += Math.max(nums[left], nums[right]);
//            left++;
//            right--;
//        }
//        return sum;
//    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1,4,3,2}));
    }
}