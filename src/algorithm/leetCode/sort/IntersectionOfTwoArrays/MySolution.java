package algorithm.leetCode.sort.IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

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
 * 算法思路: 暴力法 直接使用set的唯一性来筛选，但这个方法 使用的空间复杂度偏高
 * time:3ms 97.36%
 * mem:36.3MB 69.83%
 *
 * @author ltw
 * on 2019-10-08.
 */
public class MySolution {
    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set1.add(nums2[i]);
            }
        }
        Integer[] temp = set1.toArray(new Integer[]{});
        int[] intArray = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            intArray[i] = temp[i].intValue();
        }
        return intArray;
    }
}
