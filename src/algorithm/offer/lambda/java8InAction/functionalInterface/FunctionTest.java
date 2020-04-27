package algorithm.offer.lambda.java8InAction.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author joooo
 */
public class FunctionTest<X> {
    public static <T extends String, R extends Integer> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {

            result.add(f.apply(s));
        }
        return result;
    }

    public void test(X x) {

    }

    public static void main(String[] args) {
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"), String::length);

    }
}
