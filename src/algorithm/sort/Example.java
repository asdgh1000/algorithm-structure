package algorithm.sort;

/**
 * @author ltw
 * on 2020-01-02.
 */
public class Example {
    public static void sort(Comparable[] a) {
    }

    /**
     * 判断v 是否小于 w
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中两个下标的值
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印排序后的数组
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断是否排序完成 (从小到大排序)
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {""};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
