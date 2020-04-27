package algorithm.leetCode.interview.No51;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.reversePairs(new int[]{7, 5, 6, 4}));
    }

    int result = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        sort(0, nums.length - 1, nums);
        return result;
    }

    private void sort(int left, int right, int[] nums) {
        if (left == right) {
            return;
        }
        int middle = left + (right - left) / 2;
        sort(left, middle, nums);
        sort(middle + 1, right, nums);
        merge(left, middle, right, nums);

    }

    private void merge(int left, int middle, int right, int[] nums) {
        // 临时数组，用来保存每次合并年之后的结果
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        // 临时数组的初始下标
        int k = 0;
        while (i <= middle && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                result += (middle + 1 - i);
            }
        }
        // 将左边序列中剩余的数放入临时数组
        while (i <= middle) {
            temp[k++] = nums[i++];
        }
        // 将右边序列中剩余的数放入临时数组
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // 将临时数组中的元素位置对应到真真实的数组中
        for (int m = 0; m < temp.length; m++) {
            nums[m + left] = temp[m];
        }
    }
}
