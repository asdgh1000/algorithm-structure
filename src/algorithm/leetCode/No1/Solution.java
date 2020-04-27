package algorithm.leetCode.No1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltw
 * on 2020-01-14.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != 0 && map.get(tmp) != i) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = solution.twoSum(new int[]{1, 3, 4, 2}, 6);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
