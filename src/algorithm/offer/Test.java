package algorithm.offer;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ltw
 * on 2020-01-10.
 */
public class Test {
    public static BigDecimal calculate(double amount, int people) {
        return BigDecimal.valueOf(amount / people).setScale(2, BigDecimal.ROUND_HALF_DOWN);

    }

}
