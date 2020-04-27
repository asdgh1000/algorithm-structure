package algorithm.leetCode.geek.geekforgeeks.sort;

/**
 * 插入排序
 * 时间复杂度:O(n2)
 * 最好情况 O(n)
 * 最坏情况O(n2)
 * 空间复杂度:O(1)
 * 稳定排序
 */
public class InsertSort {

    // 插入排序，a表示数组，n表示数组大小
    public void sort(int[] a) {
        if (a.length <= 1) return;

        for (int i = 1; i < a.length; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
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
