package algorithm.offer.lambda.java8InAction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<LambdaTest.Apple> list = new ArrayList<>();
        list.sort(new Comparator<LambdaTest.Apple>() {
            @Override
            public int compare(LambdaTest.Apple o1, LambdaTest.Apple o2) {
                return 0;
            }
        });
    }
}
