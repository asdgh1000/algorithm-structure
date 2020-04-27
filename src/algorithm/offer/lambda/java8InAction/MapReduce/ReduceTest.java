package algorithm.offer.lambda.java8InAction.MapReduce;

import java.util.ArrayList;
import java.util.List;

/**
 * 用map和reduce方法进行数量计算
 * 和 内置count方法结果一样
 * long count = appleList.stream().count();
 * 1.先将对象映射成1 apple->1
 * 2.reduce 求和
 */
public class ReduceTest {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple());
        appleList.add(new Apple());
        appleList.add(new Apple());
        appleList.add(new Apple());

        System.out.println(appleList.stream()
                .map(apple -> 1)
                .reduce(0, (a, b) -> a + b));
    }

    static class Apple {
        private String name;
    }
}
