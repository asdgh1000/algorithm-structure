package algorithm.leetCode.No06;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode newHead = null;
        ListNode currentHead = head;
        int size = 0;
        while (currentHead.next != null) {
            ListNode next = head.next;
            currentHead.next = newHead;
            newHead = currentHead;
            currentHead = next;
            size++;
        }
        int[] res = new int[size];
        for (int i = size - 1; i > -1; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}