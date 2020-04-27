package algorithm.leetCode.interview.No17;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] printNumbers(int n) {
        int[] result = new int[(int) Math.pow(10, n)-1];
        for (int j = 0; j < Math.pow(10, n)-1; j++) {
            result[j] = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.printNumbers(1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}