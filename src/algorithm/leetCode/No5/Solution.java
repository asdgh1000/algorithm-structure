package algorithm.leetCode.No5;

class Solution {
    //sliding window
    public String longestPalindrome(String s) {
        if (s.trim().length() == 0) {
            return "";
        }
        int left = 0;
        int right = s.length();
        while (left < right) {
            if (isPalindrome(s.substring(left, right))) {
                return s.substring(left, right);
            }
            if (isPalindrome(s.substring(left + 1, right))) {
                return s.substring(left + 1, right);
            }
            if (isPalindrome(s.substring(left, right - 1))) {
                return s.substring(left, right - 1);
            }
            left++;
            right--;
        }
        return s.charAt(0) + "";
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
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("eabcb"));

    }
}