package algorithm.leetCode.No17;

import java.util.*;

public class Solution1 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new LinkedList<>();
        search(0, digits, map, res, "");
        return res;

    }

    private void search(int index, String digits, Map<Character, String> map, List<String> res, String current) {
        if (current.length() == digits.length()) {
            res.add(current);
            return;
        }

        String tmp = map.get(digits.charAt(index));
        for (int i = 0; i < tmp.length(); i++) {
            current += tmp.charAt(i);
            search(index + 1, digits, map, res, current);
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<String> result = solution1.letterCombinations("45454623");
        for (String s : result) {
            System.out.println(s);
        }

    }
}
