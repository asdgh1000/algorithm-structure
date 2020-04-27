package algorithm.leetCode.No206;

/**
 * @author ltw
 * on 2020-01-16.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;

        }
        return newHead;
    }
}
