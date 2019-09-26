package algorithm.sort.unStable;

import algorithm.sort.SortUtil;

/**
 * 选择排序
 * 概念：每次选择列表中最小的数和未选上数做交换，这样的操作进行 length-1次
 * 稳定性：不稳定
 * 时间复杂度：O(n2)
 * 空间复杂度:O(1)
 * 每次选择
 *
 * @author ltw
 * on 2019-09-26.
 */
public class SelectionSort extends SortUtil {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.check();
    }


    @Override
    public void sortArray(int[] origin) {

        int posMin = 0;

        for (int j = 0; j < origin.length; j++) {
            for (int i = j; i < origin.length; i++) {
                if (origin[posMin] > origin[i]) {
                    swap(origin, posMin, i);
                }
            }

            posMin = j;
        }
        printResult(origin);
    }
}
