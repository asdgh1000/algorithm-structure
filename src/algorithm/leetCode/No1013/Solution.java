package algorithm.leetCode.No1013;

public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum1 = 0;
        int sum2 = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        for (int i = 0; i < A.length-3; i++) {
            sum1 += A[i];
            sum2 = sum - sum1;
            if (sum1 * 2 == sum2) {
                int tmp = 0;
                for (int j = i + 1; j < A.length; j++) {
                    tmp += A[j];
                    if (sum2 == 2 * tmp) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
    }
}
