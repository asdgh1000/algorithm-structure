package algorithm.offer.lambda.java8InAction.functionalInterface;

import java.util.List;

@FunctionalInterface
public interface OpFunction<X> {
    X ops(X a, X b);

    default <T, R> R map(T t1, T t2) {
        return (R) t1;
    }
}
