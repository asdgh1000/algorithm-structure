package algorithm.sort.stable;

/**
 * 冒泡排序
 * 概念：
 * 冒泡排序只会操作相邻的两个数据，每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系的要求，如果不满足就让他俩呼唤。
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
public class Bubble {

    public static void main(String[] args) {
        Integer[] choas = {3, 5, 1, 5, 1, 8, 0, 3, 7, 1, 5};
        Bubble bubble = new Bubble();
        bubble.bubleSort(choas);

        for (Integer result : choas) {
            System.out.println(result);
        }
    }

    public void bubleSort(Integer[] choas) {
        /**
         * 最多需要length次交换过程
         */
        for (int i = 0; i < choas.length; i++) {
            boolean flag = false;
            /**
             * 将一个数字冒泡到相映位置
             */
            for (int j = 0; j < choas.length - i - 1; ++j) {
                //数据交换
                if (choas[j] > choas[j + 1]) {  //最好情况O(n) 这边完全不用交换，本来都是有序的
                    int tmp = choas[j]; //唯一需要的额外空间
                    choas[j] = choas[j + 1];
                    choas[j + 1] = tmp;
                    flag = true; //判断本次有数据需要交换，
                }
            }
            if (!flag)
                break;

        }
    }
}
