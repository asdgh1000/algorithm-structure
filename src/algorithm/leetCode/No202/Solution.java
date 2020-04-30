package algorithm.leetCode.No202;

public class Solution {
    boolean tag = false;

    public boolean isHappy(int n) {
        help(n);
        return tag;
    }

    private void help(int n) {
        if (n == 1) {
            tag = false;
            return;
        }
        int x = 0;
        int times = n / 10 + 1;
        for (int i = 1; i <= times; i++) {
            x += (int) (Math.pow(n % 10 * i, 2));
            System.out.println(x);
        }
        help(x);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isHappy(19);
    }
}
