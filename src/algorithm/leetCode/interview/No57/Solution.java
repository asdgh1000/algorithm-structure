package algorithm.leetCode.interview.No57;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        for (int i : nums) {
            if (set.contains(target - i)) {
                result[0] = target - i;
                result[1] = i;
                return result;
            }
            set.add(i);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
