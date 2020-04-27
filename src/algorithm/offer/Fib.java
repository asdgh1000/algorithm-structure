package algorithm.offer;

/**
 * @author ltw
 * on 2020-03-15.
 */
public class Fib {
    public int fib(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }
}
