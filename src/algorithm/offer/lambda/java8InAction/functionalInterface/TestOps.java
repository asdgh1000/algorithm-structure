package algorithm.offer.lambda.java8InAction.functionalInterface;

public class TestOps {
    public static void main(String[] args) {
        test((a1, a2) -> (Integer) a1 + (Integer) a2);
    }

    public static void test(OpFunction ops) {
        System.out.println("test:" + ops.ops(1, 2));
    }
}
