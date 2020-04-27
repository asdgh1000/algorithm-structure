package algorithm.leetCode.No22;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.generateParenthesis(3);
        System.out.println("");
    }

    public void generateParenthesis(int n) {
        generate(n, n, "");
    }

    public void generate(int left, int right, String currentString) {
        if (left == 0 && right == 0) {
            System.out.println(currentString);
            list.add(currentString);
            return;
        }
        if (left > 0) {
            generate(left - 1, right, currentString + "(");
        }
        if (right > left) {
            generate(left, right - 1, currentString + ")");
        }
    }
}
