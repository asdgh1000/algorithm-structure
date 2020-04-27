package algorithm.leetCode.No374;

public class Solution {
    public boolean isPerfectSquare(int num) {
        long min = 0;
        long max = num;
        while (min <= max) {
            long middle = (min + max) / 2;
            if (num == middle * middle) {
                return true;
            }
            if (middle * middle < num) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(2147483647));
//        2147483648
    }
}