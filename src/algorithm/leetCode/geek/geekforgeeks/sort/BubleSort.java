package algorithm.leetCode.geek.geekforgeeks.sort;

/**
 * 冒泡排序
 * 稳定排序
 * 时间复杂度o(n2)
 * 空间复杂度O(1)
 */
public class BubleSort {
    public void sort(int[] nums) {
        //增加提前结束标志，当一次遍历没有元素需要切换则提前结束
        boolean stop = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    stop = false;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (stop) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubleSort bubleSort = new BubleSort();
        int[] test = new int[]{5, 3, 6, 2, 7, 10, 9};
        bubleSort.sort(test);
        for (int i = 0; i < test.length; i++) {

            System.out.println(test[i]);
        }
    }

}
