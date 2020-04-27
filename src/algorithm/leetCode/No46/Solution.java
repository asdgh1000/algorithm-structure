package algorithm.leetCode.No46;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        help(lists, list, nums, new boolean[nums.length]);
        return lists;
    }

    private void help(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            else {
                list.add(nums[i]);
                visited[i] = true;
                //这边返回说明下面的已经完成递归，需要进行回溯
                help(res, list, nums, visited);

                //回溯
                list.remove(list.size() - 1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> tmp : list) {
            for (int tmp1 : tmp) {
                System.out.print(tmp1);
            }
            System.out.println();
        }
    }

}
