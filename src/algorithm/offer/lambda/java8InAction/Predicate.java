package algorithm.offer.lambda.java8InAction;

/**
 * @author joooo
 */
public interface Predicate<T> {
    /**
     * lambda和范形组合使用
     *
     * @param t
     * @return
     */
    boolean test(T t);
}
