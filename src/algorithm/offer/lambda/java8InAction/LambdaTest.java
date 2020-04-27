package algorithm.offer.lambda.java8InAction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joooo
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Apple> redApples = filter(new ArrayList<>(), (Apple apple) -> "red".equals(apple.getColor()));
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }


    static class Apple {
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        private String color;
    }
}
