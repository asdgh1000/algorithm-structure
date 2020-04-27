package algorithm.offer;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 50亿int数据中找到重复的数并返回
 * 使用bitmap 保存 空间效率 是原来的 32倍
 *
 * @author ltw
 * on 2020-01-09.
 */
public class FindNum {
    //为了方便，假设数据是以数组的形式给我们的
    public static Set<Integer> test(int[] arr) {
        //用来把重复的数返回，存在Set里，这样避免返回重复的数。
        Set<Integer> output = new HashSet<>();
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            //判断该数是否存在bitSet里
            if (bitSet.get(value)) {
                output.add(value);
            } else {
                bitSet.set(value, true);
            }
        }
        return output;
    }

    //测试
    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 3, 4};
        Set<Integer> t2 = test(t);
        System.out.println(t2);
    }
}
