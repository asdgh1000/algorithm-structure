package algorithm.daily;

class Solution {
    public String reverseWords(String s) {
        if ("".equals(s.trim())) {
            return "";
        }
        String[] stringList = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (!"".equals(stringList[i])) {
                result.append(stringList[i]).append(" ");
            }
        }

//        System.out.println(result.toString());
        return result.substring(0, result.length() - 1).toString();
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.reverseWords(" ");
//    }
}