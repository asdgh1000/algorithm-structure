package algorithm.offer.lambda.java8InAction.functionalInterface;

import java.io.BufferedReader;

public class TestFunctionInterface {
    public static void main(String[] args) {
        System.out.println(functional(() -> 2));
    }

    public static int functional(Test test) {
        return test.aaa();
    }
}
