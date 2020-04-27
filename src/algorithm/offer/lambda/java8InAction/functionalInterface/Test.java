package algorithm.offer.lambda.java8InAction.functionalInterface;

/**
 * 仅有一个函数的接口是函数式接口
 *
 * @author joooo
 */
@FunctionalInterface
public interface Test {
    /**
     * 函数式接口
     * @return
     */
    int aaa();

    @Override
    boolean equals(Object obj);

    /**
     * test default
     */
    default void test() {
        System.out.println("test");
    }

}
