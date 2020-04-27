package algorithm.offer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

/**
 * @author ltw
 * on 2020-01-11.
 */
public class RedPacketTest2 {

    public String[] allocate(int amount, int number) {
        int[] people = new int[number];
        String[] solution = new String[number];

        //todo 分成 9个随机位点
        for (int i = 0; i < number; i++) {
            Integer random = new Random().nextInt(amount);
            people[i] = random;
        }
        Arrays.sort(people);
        for (int i = 0; i < people.length; i++) {
            if (i == 0) {
                solution[0] = people[0] + "";
            } else {
                solution[i] = (people[i] - people[i - 1]) + "";
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RedPacketTest2().allocate(1000, 10)));
    }

    private void checkArgument(boolean right, String message) {
        if (!right) {
            throw new RuntimeException(message);
        }
    }
}
