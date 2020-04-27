package algorithm.leetCode.No466;

import java.util.HashMap;
import java.util.Map;

class Solution {

    //"baba"
    //11
    //"baab"
    //1
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxRepetitions("baba", 11, "baab", 1));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            Character character = s1.charAt(i);
            if (!map.containsKey(character)) {
                map.put(character, n1);
            } else {
                map.put(character, map.get(character) + n1);
            }
        }
        Map<Character, Integer> map1 = new HashMap();
        for (int i = 0; i < s2.length(); i++) {
            Character character = s2.charAt(i);
            if (!map1.containsKey(character)) {
                map1.put(character, n2);
            } else {
                map1.put(character, (Integer) map1.get(character) + n2);
            }
        }
        int count = 0;
        int times = 0;
        for (Character x : map1.keySet()) {
            times++;
            if (map.get(x) == null) {
                return 0;
            } else {
                if (times == 1) {
                    count = map.get(x) / map1.get(x);
                } else {
                    count = Math.min(count, map.get(x) / map1.get(x));
                }
            }
        }
        return count;
    }
}