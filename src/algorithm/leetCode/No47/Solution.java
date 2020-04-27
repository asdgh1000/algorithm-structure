//package algorithm.leetCode.No47;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        if (nums.length == 0) {
//            return new ArrayList<>();
//        }
//        List<List<Integer>> lists = new ArrayList<>();
//
//        helper(lists, new ArrayList<>(), nums, new boolean[]);
//    }
//
//    private void helper(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] visited) {
//        if (list.size() == nums.length) {
//            lists.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (visited[i]) continue;
//            list.add(nums[i]);
//            visited[i] = true;
//            helper(lists, list, nums, visited);
//            list.remove(list.size() - 1);
//            visited[i] = true;
//        }
//    }
//}