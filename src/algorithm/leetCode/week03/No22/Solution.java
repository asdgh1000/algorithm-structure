package algorithm.leetCode.week03.No22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltw
 * on 2020-03-01.
 */
class Solution {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(0, 0, n, "");
        return result;
    }

    public void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }

}
