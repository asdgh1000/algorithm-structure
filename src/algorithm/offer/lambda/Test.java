package algorithm.offer.lambda;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

/**
 * @author ltw
 * on 2020-03-25.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.predicateTest();
        test.consumerTest();
        test.functionTest();
        test.supplierTest();
        test.binaryOperatorTest();

    }

    private void predicateTest() {
        System.out.println("------------------------predicate");
        //Predicate接口是输入一个参数，返回布尔值。我们通过and方法组合两个Predicate条件，判断是否值大于0并且是偶数
        Predicate<Integer> positiveNumber = i -> i > 0;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        System.out.println(positiveNumber);
        System.out.println(evenNumber);
        System.out.println(positiveNumber.and(evenNumber).test(2));
        System.out.println("------------------------predicate");
    }

    private void consumerTest() {
        System.out.println("------------------------consumer");
        //Consumer接口是消费一个数据。我们通过andThen方法组合调用两个Consumer，输出两行abcdefg
        Consumer<String> println = System.out::println;
        println.andThen(println).accept("test");
        System.out.println("------------------------consumer");
    }

    private void functionTest() {
        System.out.println("------------------------function");
        //Function接口是输入一个数据，计算后输出一个数据。我们先把字符串转换为大写，
        // 然后通过andThen组合另一个Function实现字符串拼接
        Function<String, String> upperCase = String::toUpperCase;
        Function<String, String> duplicate = s -> s.concat(s);
        System.out.println(upperCase.andThen(duplicate).apply("test"));
        System.out.println("------------------------function");
    }

    private void supplierTest() {
        System.out.println("------------------------supplier");
        //Supplier是提供一个数据的接口。这里我们实现获取一个随机数
        Supplier<Integer> random = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(random.get());
        System.out.println("------------------------supplier");

    }

    private void binaryOperatorTest() {
        System.out.println("------------------------binaryOperator");
        //BinaryOperator是输入两个同类型参数，输出一个同类型参数的接口。
        // 这里我们通过方法引用获得一个整数加法操作，通过Lambda表达式定义一个减法操作，然后依次调用
        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> subtraction = (a, b) -> a - b;
        System.out.println(subtraction.apply(add.apply(1, 2), 3));
        System.out.println("------------------------binaryOperator");

    }

}
