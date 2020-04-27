package algorithm.offer;

import algorithm.leetCode.No1290.ListNode;


/**
 * @author ltw
 * on 2020-01-10.
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode currentHead = head;
        while (currentHead.next != null) {
            ListNode next = currentHead.next;
            currentHead.next = newHead;
            newHead = currentHead;
            currentHead = next;

        }
        return newHead;
    }
}
