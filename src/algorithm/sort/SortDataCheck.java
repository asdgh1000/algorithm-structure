package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ltw
 * on 2019-09-26.
 */
public abstract class SortDataCheck {
    public int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }

    public void check() {
        int[] array1 = generateRandomArray();
        int[] array2 = new int[array1.length];
        System.arraycopy(array1, 0, array2, 0, array1.length);
        Arrays.sort(array1);
        sortArray(array2);
        boolean same = true;
        for (int i = 0; i < array2.length; i++) {
            if (array1[i] != array2[i]) {
                same = false;
            }
        }
        System.out.println(same ? "Right" : "Wrong");
    }


    public abstract void sortArray(int[] origin);

}
