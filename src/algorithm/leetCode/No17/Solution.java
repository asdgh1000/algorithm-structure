package algorithm.leetCode.No17;

import java.net.Socket;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations("45454623");
        for (String x : list) {
            System.out.println(x);
        }
    }

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

    private void search(int index, String digits, Map<Character, String> map, List<String> list, String currentString) {
        if (currentString.length() == digits.length()) {
            list.add(currentString);
            return;
        }
        for (int i = 0; i < map.get(digits.charAt(index)).length(); i++) {
            search(index + 1, digits, map, list, currentString + map.get(digits.charAt(index)).charAt(i));
        }

    }
}