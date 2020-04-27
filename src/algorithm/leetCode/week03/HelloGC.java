package algorithm.leetCode.week03;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ltw
 * on 2020-03-03.
 */
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("Hello GC!");
        List list = new LinkedList();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }
}
