package algorithm.leetCode.list.LinkedListCycle;

/**
 * 使用快慢指针的思路 时间复杂度也低
 * 也可以考虑把所有遍历过的元素全部存在 set里，每次从set获取一次，但这样 空间复杂度高
 * @author ltw
 * on 2019-10-14.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
