package algorithm.leetCode.No5;

public class Solution1 {
    String result = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                System.out.println(s.substring(i,j));
                if (isPalindrome(s.substring(i, j))) {
                    if (result.length() < s.substring(i, j).length()) {
                        result = s.substring(i, j);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String x) {
        int left = 0;
        int right = x.length() - 1;
        while (left <= right) {
            if (x.charAt(left) != x.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.longestPalindrome("fgrxnxofp"));

    }
}
