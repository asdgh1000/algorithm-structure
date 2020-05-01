package algorithm.leetCode.interview.No62;

import java.util.LinkedList;
import java.util.List;

/**
 * 执行用时 :
 * 1070 ms
 * , 在所有 Java 提交中击败了
 * 26.67%
 * 的用户
 * 这个方法不好的原因主要在于 linkedList删除元素时候其实并不是真正O(1)的，因为需要从头遍历找到元素 这部分时间也需要记录进去
 */
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(5, 3));
    }

}
//    O(n) + O(1)
//        0,1,2,3,4      3
//        0,1,3,4     5%3
//        0,1,4       4%3
