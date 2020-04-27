package algorithm.leetCode.No190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(Long n) {
        StringBuffer stringBuffer = new StringBuffer(n+"");
        return Integer.parseInt(stringBuffer.reverse().toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseBits(1111010011100L);
    }
}