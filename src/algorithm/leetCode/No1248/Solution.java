package algorithm.leetCode.No1248;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isODD(nums[i])) {
                tmp++;
                if (tmp == 1) {
                    left = i;
                }
                if (tmp == k) {
                    right = i;
                    break;
                }
            }
        }
        System.out.println("left:" + left);
        System.out.println("right:" + right);

        return 0;
    }

    private boolean isODD(int number) {
        return number % 2 != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }
}