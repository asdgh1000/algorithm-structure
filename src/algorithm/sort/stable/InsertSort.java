package algorithm.sort;

/**
 * 插入排序定义:
 * 一个有序数组，我们往里面添加一个新的数据后，只要便利数组找到数据应该插入的位置将其插入即可。
 * 算法核心思想是：把当前数组划分为两个区：前半部分作为已经排序区，后半部分作为未排序区，于是算法就成了 把后面未排序区插入到前面排序区的过程
 *
 * @author ltw
 * on 2019-08-26.
 */

public class InsertSort {

    public static void main(String[] args) {
        Integer[] choas = {3, 5, 1, 5, 1, 8, 0, 3, 7, 1, 5};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(choas);

        for (Integer result : choas) {
            System.out.println(result);
        }
    }


    public void insertSort(Integer[] choas) {
        for (int i = 1; i < choas.length; i++) {
            int currentData = choas[i];
            int beforeIndex = i - 1;
            while (beforeIndex >= 0 && choas[beforeIndex] > currentData) {
                choas[beforeIndex + 1] = choas[beforeIndex];
                beforeIndex--;
            }
            choas[beforeIndex + 1] = currentData;
        }
    }
}
