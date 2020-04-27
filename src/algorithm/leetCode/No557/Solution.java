package algorithm.leetCode.No557;

class Solution {
    public String reverseWords(String s) {
        if ("".equals(s.trim())) {
            return "";
        }
        String[] tmp = s.split(" ");
        String result = "";
        for (int i = 0; i < tmp.length; i++) {
            String tmpString = "";
            for (int j = tmp[i].length() - 1; j >= 0; j--) {
                tmpString = tmpString + tmp[i].charAt(j);
            }
            result = result + tmpString + " ";

        }
        return result.substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}