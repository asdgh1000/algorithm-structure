package algorithm.leetCode.No215;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue((o1, o2) -> {
            if ((Integer) o1 < (Integer) o2) {
                return 1;
            }
            else return -1;
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int result = 0;
        int i = 0;
        while (!queue.isEmpty()) {
            result = queue.poll();
            i++;
            if (i == k) {
                return result;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}