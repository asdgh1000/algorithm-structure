package algorithm.leetCode.No45;

/**
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */

//class Solution {
//    public int jump(int[] nums) {
//        int length = nums.length;
//        int end = 0;
//        int maxPosition = 0;
//        int steps = 0;
//        for (int i = 0; i < length - 1; i++) {
//            maxPosition = Math.max(maxPosition, i + nums[i]);
//            if (i == end) {
//                end = maxPosition;
//                steps++;
//            }
//        }
//        return steps;
//    }
//}
//
class Solution {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int index = 0;
        int times = 1;
        //当前位置 + 可跳跃数量 < 总长度 说明到不了底
        while (!canSuccess(nums, index)) {
            index = getNext(nums, index);
            times++;
        }
        return times;

    }

    private boolean canSuccess(int[] nums, int index) {
        if ((index + nums[index]) < nums.length - 1) {
            return false;
        }
        return true;
    }

    private int getNext(int[] nums, int current) {
        int tmp = nums[current];
        if (tmp == 1) {
            return current + 1;
        }
        int times = 0;
        for (int i = current + 1; i <= nums[current]; i++) {
            tmp = Math.max(current + nums[i] + ++times, tmp);
        }
        return tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2,1,1,1,1}));
    }
}