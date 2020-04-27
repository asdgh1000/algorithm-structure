package algorithm.leetCode.No842;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.splitIntoFibonacci("123456579"));
    }

    // 循环：从start 往后拆分
    // 剪枝：满足斐波那契数列条件、满足不以0开头（除非是0）
    // 结束：start==len ans内元素大于2个
    private boolean backtracking(String S, int start, List<Integer> ans) {
        if (start == S.length() && ans.size() >= 2) {
            return true;
        }
        for (int i = start; i < S.length(); i++) {
            String segment = S.substring(start, i + 1);
            // 剪枝
            // 数值超过范围
            if (Long.parseLong(segment) > Integer.MAX_VALUE) break;
            // 防止开头为 0
            if (!"0".equals(segment) && segment.startsWith("0")) break;
            if (isFibonacciSequence(Integer.valueOf(segment), ans)) {
                ans.add(Integer.valueOf(segment));
                // 找到一个结果就返回
                if (backtracking(S, i + 1, ans)) return true;
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    // 判断是否能组成斐波那契序列
    private boolean isFibonacciSequence(Integer num, List<Integer> ans) {
        int size = ans.size();
        if (size < 2) return true;
        return (ans.get(size - 2) + ans.get(size - 1) == num);
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        backtracking(S, 0, ans);
        return ans;
    }

}
