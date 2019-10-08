package algorithm.leetCode.heap.LastStoneWeight;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 第1046题
 * https://leetcode-cn.com/problems/last-stone-weight/
 * label:heap
 * <p>
 * 题目描述:
 * We have a collection of rocks, each rock has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 算法思路: 利用大顶堆 动态获取最大，次大元素。最大-次大 = x x再加入到堆中
 * time: 2 ms 89.22%
 * mem: 34.3 MB 100%
 *
 * 补充：大顶堆
 * 根节点元素是所有元素中最大的堆（通常用满二叉树构建）
 * 对于一个堆，如果除了堆顶元素不满足结点大于孩子结点的条件，
 * 它的两个子树已经是符合条件的最大堆，我们很容易就可以将其再维护成一个符合条件的最大堆。
 * 将堆顶元素与两个孩子结点中最大的那个进行交换，然后再对互换的子树递归地进行维护。
 *
 * 默认pq的实现是 小顶堆
 * 改造成大顶堆:
 * PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
 * @author ltw
 * on 2019-10-05.
 */
public class MySolution {
//    public static void main(String[] args) {
//        MySolution mySolution = new MySolution();
//        int[] test = {2};
//        System.out.print(mySolution.lastStoneWeight(test));
//    }

    public int lastStoneWeight(int[] stones) {
        // 实现最大堆
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(30, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        for (int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }
        Integer solution;
        while (true) {
            Integer first = maxHeap.poll();
            if (maxHeap.peek() == null || maxHeap.peek() == 0) {
                solution = first;
                break;
            }
            Integer secound = maxHeap.poll();
            Integer end = first - secound;
            maxHeap.offer(end);
        }
        return solution;

    }
}
