package algorithm.leetCode.No209;

class Solution {
    /**
     * 两种情况:
     * 6,7,0,1,2,4,5
     * <p>
     * 4,5,6,7,0,1,2
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle > 0 && nums[middle] < nums[middle - 1]) {
                return nums[middle];
            }

            if (middle < nums[left]) { //6,7,0,1,2,4,5
                right = middle - 1;
            }
            if (nums[middle] > nums[left]) {//4,5,6,7,0,1,2
                left = middle + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{6,7,0,1,2,4,5}));
    }
}