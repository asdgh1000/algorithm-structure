package algorithm.offer.lambda;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ltw
 * on 2020-03-25.
 */
public class StreamTest {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        double result = StreamTest.calc(ints);
        double streamResult = StreamTest.calcStream(ints);
        System.out.println("calc:" + result);
        System.out.println("calcStream:" + streamResult);
    }


    private static double calc(List<Integer> ints) {
        //临时中间集合
        List<Point2D> point2DList = new ArrayList<>();
        for (Integer i : ints) {
            point2DList.add(new Point2D.Double((double) i % 3, (double) i / 3));
        }
        //临时变量，纯粹是为了获得最后结果需要的中间变量
        double total = 0;
        int count = 0;

        for (Point2D point2D : point2DList) {
            //过滤
            if (point2D.getY() > 1) {
                //算距离
                double distance = point2D.distance(0, 0);
                total += distance;
                count++;
            }
        }
        //注意count可能为0的可能
        return count > 0 ? total / count : 0;
    }

    private static double calcStream(List<Integer> ints) {

//如何用一行代码来实现，比较一下可读性
        return ints.stream()
                .map(i -> new Point2D.Double((double) i % 3, (double) i / 3))
                .filter(point -> point.getY() > 1)
                .mapToDouble(point -> point.distance(0, 0))
                .average()
                .orElse(0);
    }
}
