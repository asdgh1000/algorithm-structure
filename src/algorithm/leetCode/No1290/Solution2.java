package algorithm.leetCode.No1290;


/**
 * 核心是链表反转 使用原地的方式完成 空间复杂度低
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public int getDecimalValue(ListNode head) {
        if (head == null)
            return 0;
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) + head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(1);
        a.next = b;
        b.next = c;

        System.out.println(solution.getDecimalValue(a));
    }
}