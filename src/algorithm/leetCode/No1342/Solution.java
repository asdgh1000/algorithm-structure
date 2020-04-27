package algorithm.leetCode.No1342;

class Solution {
    public int numberOfSteps(int num) {
        int result = 0;
        while (num != 0) {
            result++;
            if ((num & 1) == 0) num = num >> 1;
            else num--;
        }
        return result;
    }
}