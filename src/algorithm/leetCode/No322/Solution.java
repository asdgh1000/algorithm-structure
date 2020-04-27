package algorithm.leetCode.No322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int result = 0;
        int index = coins.length - 1;
        while (amount >= coins[0] && index >= 0) {
            if (amount - coins[index] >= 0) {
                amount -= coins[index];
                result++;
            } else {
                index--;
            }
        }
        return amount == 0 ? result : -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        [186,419,83,408]
//        6249
        System.out.println(solution.coinChange(new int[]{186,419,83,408}, 6249));
    }
}
