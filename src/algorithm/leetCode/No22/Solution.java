package algorithm.leetCode.No22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List list = new ArrayList();
        return generate(0, 2 * n, 0, 0, "", list);
    }

    private List generate(int index, int total, int leftNum, int rightNum, String currentString, List<String> list) {
        int num = total / 2;
        if (index >= total) {
            System.out.println(currentString);
            list.add(currentString);
            return list;
        }
        if (leftNum < num) {
            generate(index + 1, total, leftNum + 1, rightNum, currentString + "(", list);
        }
        if (rightNum < num && rightNum < leftNum) {
            generate(index + 1, total, leftNum, rightNum + 1, currentString + ")", list);
        }
        return list;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}