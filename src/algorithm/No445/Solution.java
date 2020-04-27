package algorithm.No445;

import java.util.Stack;

/**
 * (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 7 -> 8 -> 0 -> 7
 */
class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;

        ListNode x1 = new ListNode(3);
//        ListNode x2 = new ListNode(6);
//        ListNode x3 = new ListNode(4);
//        x1.next = x2;
//        x2.next = x3;

        ListNode listNode = addTwoNumbers(l1, x1);
        printNumber(listNode);

    }

    public static void printNumber(ListNode listNode) {

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

            carry = sum / 10;
        }
        return head;
    }
}

