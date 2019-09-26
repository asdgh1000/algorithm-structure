package algorithm.sort;

/**
 * @author ltw
 * on 2019-09-26.
 */
public abstract class SortUtil extends SortDataCheck {

    public void swap(int[] origin, int i, int j) {
        int tmp = origin[i];
        origin[i] = origin[j];
        origin[j] = tmp;
    }

    public void printResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
