package algorithm.leetCode.sort.IntersectionOfTwoArrays;

import java.util.HashSet;

/**
 * 第349题
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/comments/
 * label:sort
 * <p>
 * 题目描述:
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 算法思路: 将两个数组先通过set去重 再通过retainAll来进行筛选(其实同样是个遍历remove操作 性能并不好，所以性能没什么大变化甚至不如暴力法)。
 *
 * time:4ms 91.32%
 * mem:36.3MB 73.93%
 *
 * @author ltw
 * on 2019-10-08.
 */
public class OtherSolution {
    public static void main(String[] args) {
        OtherSolution mySolution = new OtherSolution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;

    }
}
