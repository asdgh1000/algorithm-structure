package algorithm.leetCode.array.TwoSum;

/**
 * 第1题
 * https://leetcode-cn.com/problems/two-sum/
 * label:array
 * <p>
 * 题目描述:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * time: 25 ms 54.12%
 * mem: 38 MB 77.82%
 *
 * @author ltw
 * on 2019-10-05.
 */
public class MySolution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int origin = target - nums[i];
            if(origin<0){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (origin - nums[j] == 0) {
                    solution[0] = i;
                    solution[1] = j;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int target = 9;
        MySolution mySolution = new MySolution();
        int[] end = mySolution.twoSum(nums, target);
        System.out.print("index0:" + end[0] + "---index1:" + end[1]);

    }
}
