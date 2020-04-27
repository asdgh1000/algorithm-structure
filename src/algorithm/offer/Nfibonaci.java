package algorithm.offer;

/**
 * @author ltw
 * on 2020-01-09.
 */
public class Nfibonaci {
    private static int printFibonaci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return printFibonaci(n - 1) + printFibonaci(n - 2);
        }
    }

    private static int getN(int n){

        int num = 0;
        for (int i = 1; i < n; i++) {
            num += Nfibonaci.printFibonaci(i);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(Nfibonaci.getN(26));
    }
}
