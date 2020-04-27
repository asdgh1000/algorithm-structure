package algorithm;

/**
 * @author ltw
 * on 2019-12-21.
 */
public class Select {

    public void selectSort(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            int min = tmp[i];
            int index = i;
            for (int j = i; j < tmp.length; j++) {
                if (tmp[j] < min) {
                    index = j;
                }
            }
            int temp = tmp[i];
            tmp[i] = tmp[index];
            tmp[index] = temp;
        }

        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }
    }

    public static void main(String[] agrs) {
        Select select = new Select();
        int[] a = {3, 5, 3, 6, 2, 5, 7};
        select.selectSort(a);
    }
}
