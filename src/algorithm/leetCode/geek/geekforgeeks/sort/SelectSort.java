package algorithm.leetCode.geek.geekforgeeks.sort;

/**
 * 选择排序
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 * 时间复杂度O(n2)
 * 时间复杂度o(1)
 * 空间复杂度
 *
 * 选择排序不是稳定的排序算法 ！
 */
public class SelectSort {


    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i + 1];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    int tmp = nums[j];
                    nums[i + 1] = tmp;
                    nums[j] = nums[i + 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] test = new int[]{5, 3, 6, 2, 7, 10, 9};
        insertSort.sort(test);
        for (int i = 0; i < test.length; i++) {

            System.out.println(test[i]);
        }
    }
}
