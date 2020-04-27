package algorithm.leetCode.No11;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int sum = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            sum = Math.max(min * (right - left), sum);
            if (height[left] > height[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

//1.O(n2)挨个柱子确定最大值
//2.