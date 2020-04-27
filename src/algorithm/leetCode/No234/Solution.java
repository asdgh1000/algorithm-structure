package algorithm.leetCode.No234;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            if (list.get(i).equals(list.get(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(-129);
        ListNode n2 = new ListNode(-129);
        n1.next = n2;
        System.out.println(solution.isPalindrome(n1));
    }

}