package algorithm.leetCode.list.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ltw
 * on 2019-10-15.
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        if (head == null || head.next == null) {
            return null;
        }

        while (set.contains(head)) {
            if (head == null || head.next == null) {
                return null;
            }
            set.add(head);
            head = head.next;


        }
        return head;
    }
}
