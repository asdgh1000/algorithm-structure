package algorithm.leetCode.string.ReverseString;

/**
 * @author ltw
 * on 2019-10-22.
 */
class Solution {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        Solution solution = new Solution();
        solution.reverseString(s);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            swap(i, (s.length - 1 - i), s);
        }
    }

    public void swap(int x, int y, char[] s) {
        if (s[x] == s[y]) {

        } else {
            char tmp = s[x];
            s[x] = s[y];
            s[y] = tmp;
        }
    }
}
