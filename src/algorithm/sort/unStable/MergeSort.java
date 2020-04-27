package algorithm.sort.unStable;

import algorithm.sort.Example;

import java.util.Comparator;

/**
 * @author ltw
 * on 2020-01-03.
 */
public class MergeSort extends Example {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int high) {
        if (high <= lo) {
            return;
        }
        int mid = lo + (high - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, high);
        merge(a, lo, mid, high);
    }

    private static void merge(Comparable[] a, int lo, int mid, int high) {
        int i = lo;
        int j = mid + 1;
        //复制待合并的数组到aux临时数组中
        for (int k = lo; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else a[k] = aux[i++];
        }

    }

    public static void main(String[] args) {
        String[] a = {"E", "E", "G" ,"M","R", "A", "C","E","R","T"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
