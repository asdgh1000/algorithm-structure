package algorithm.hanshunping.linkedList;

/**
 * @author ltw
 * on 2019-12-29.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = new ListNode(1);
        ListNode current = head.next;
        ListNode next = null;

        while (head != null) {
            next = current.next;
            current.next = reverseHead.next;
            reverseHead.next = current;
            current = next;
        }
        head.next = reverseHead.next;
        return head;
    }
}
