package algorithm.offer.clockIn;

import com.sun.tools.javac.util.ArrayUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRU {
    public static void main(String[] args) {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        bigDecimals.add(new BigDecimal(1));
        bigDecimals.add(new BigDecimal(2));
        bigDecimals.add(new BigDecimal(3));
        bigDecimals.add(new BigDecimal(4));


        BigDecimal avaliableBalance = bigDecimals.stream().sorted(new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o2.compareTo(o1);
            }
        }).limit(10).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(avaliableBalance.doubleValue());
    }

}
