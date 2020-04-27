package algorithm;

/**
 * @author ltw
 * on 2019-12-20.
 */
public class Bubble {
    public void bubleSort(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp.length - i - 1; j++) {
                if (tmp[j] > tmp[j + 1]) {
                    int temp = tmp[j + 1];
                    tmp[j + 1] = tmp[j];
                    tmp[j] = temp;
                }
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }
    }


    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] a = {3, 5, 3, 6, 2, 5, 7};
        bubble.bubleSort(a);
    }
}
