package algorithm.leetCode.No75;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] > nums[right]) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[]{2, 0, 2, 2, 1, 2, 1, 0, 1, 0}; //0,0,1,1,2,2,
        solution.sortColors(test);
        for (int i : test) {
            System.out.println(i);
        }
    }
}