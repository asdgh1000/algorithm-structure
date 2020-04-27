package algorithm;

/**
 * @author ltw
 * on 2019-12-21.
 */
public class Insert {
    public void insertSort(int[] tmp) {
        for (int i = 0; i < tmp.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (tmp[j] < tmp[i]) {
                    int temp = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = temp;
                    i--;
                }
                else {
                    break;
                }
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }
    }

    public static void main(String[] agrs) {
        Insert insert = new Insert();
        int[] a = {3, 5, 3, 6, 2, 5, 7};
        insert.insertSort(a);
    }
}
