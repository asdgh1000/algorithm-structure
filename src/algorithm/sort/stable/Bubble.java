package algorithm.sort.stable;

import algorithm.sort.SortUtil;

/**
 * 冒泡排序
 * 概念：
 * 冒泡排序只会操作相邻的两个数据，每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系的要求，如果不满足就让他俩互换。
 * （注意：每次冒泡会让至少一个元素移动到它应该的位置，重复n次就完成了n个数据的排序工作）
 * 时间复杂度O(n2)
 * 空间复杂度O(1)
 * 特性：
 * 原地排序算法
 * 稳定排序算法
 *
 * @author ltw
 * on 2019-08-26.
 */
public class Bubble extends SortUtil {
    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        bubble.check();
    }

    @Override
    public void sortArray(int[] origin) {
        for (int j = 0; j < origin.length; j++) {
            for (int i = 1; i < origin.length - j; i++) { //每次子循环只需要便利 length-j个
                //1.相邻两位比较 如果前一个比后一个大,就互换
                if (origin[i - 1] > origin[i]) {
                    swap(origin, i, i - 1);
                }
            }
        }
        printResult(origin);
    }

}
