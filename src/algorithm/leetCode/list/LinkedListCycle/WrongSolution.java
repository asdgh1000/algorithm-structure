package algorithm.leetCode.list.LinkedListCycle;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *  
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 记录一下这个答案是错误的
 * 要判断一个链表是否有循环不能 设置固定指针，因为循环可能在中段开始 可能不会再经过这个固定指针。
 * 稍微变通一下 把固定指针变成慢指针，把移动指针变成快指针即可
 *
 * @author ltw
 * on 2019-10-14.
 */
public class WrongSolution {

//    public Solution(ListNode head) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = head;
//
//    }

//    public static void main(String[] args) {
//        ListNode head = new ListNode(0);
//        Solution solution = new Solution(head);
//        System.out.print(solution.hasCycle(head));
//    }

    public boolean hasCycle(ListNode head) {
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.equals(head))
                return true;
            tmp = tmp.next;
        }
        return false;
    }
}
