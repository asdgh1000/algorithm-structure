package algorithm.leetCode.No190;

public class Solution1 {
    //1.取当前 n 的最后一位：n & 1
    //2. 将最后一位移动到对应位置，第一次为 31 位，第二次是 30 位，即：31、30、29... 1、0，写作代码 bit << 31;
    //3.退出条件，二进制反转时，如果剩余位数全位 0，则可以不用再反转。

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 31; n != 0; n = n >>> 1, i--) {
            ans += (n & 1) << i;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.reverseBits(1111010101));
    }
}

