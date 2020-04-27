package algorithm.leetCode.No21;

/**
 * @author ltw
 * on 2020-01-12.
 */

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.net.Socket;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //构造一个虚拟节点 保存头节点
        ListNode head = new ListNode(-1);

        ListNode point = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if (l1 == null) {
            point.next = l2;
        } else {
            point.next = l1;
        }

        return head.next;
    }

    public static void main(String[] arsg) {
        Solution solution = new Solution();
//        1->2->4, 1->3->4
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node14 = new ListNode(4);
        ListNode node21 = new ListNode(1);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        node11.next = node12;
        node12.next = node14;

        node21.next = node23;
        node23.next = node24;
        ListNode tmp = solution.mergeTwoLists(node11, node21);
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

}
