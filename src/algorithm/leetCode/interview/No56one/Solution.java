package algorithm.leetCode.interview.No56one;

/**
 * 要求:
 * 时间复杂度O(n)
 * 空间复杂度:O(1)
 * 因此不能考虑嵌套循环
 * 题解：
 * 先找到 end = result[0]^result[1]
 * 因为这两个数不一样 因此 可以找到 end 最末位是1的 这意味着 在这一位 result[0] 和 result[1]是不同的，因此可以根据这个来分组
 * 分成两组后 就变成
 * {x1,x2,x3,x4,result[0]}
 * {x5,x6,x7,x8,result[1]}
 * 再对两组进行^ 可以求出结果
 */
class Solution {

    public int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for (int num : nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumbers(new int[]{2, 6, 8, 4, 8, 6, 4}));
    }
}


