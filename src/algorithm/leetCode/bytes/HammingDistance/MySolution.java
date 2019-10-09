package algorithm.leetCode.bytes.HammingDistance;

/**
 * https://leetcode-cn.com/problems/hamming-distance/submissions/
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * time: 1ms 91.07%
 * mem: 33.4MB 77.38%
 *
 * @author ltw
 * on 2019-10-09.
 */
class MySolution {
    public static void main(String[] args) {
        MySolution solution = new MySolution();
        System.out.print(solution.hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        String end = Integer.toString(a, 2);
        int sum = 0;
        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == '1') {
                sum++;
            }
        }
        return sum;
    }
}
