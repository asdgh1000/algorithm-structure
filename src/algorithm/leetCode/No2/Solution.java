package algorithm.leetCode.No2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode result = new ListNode(-1);
        result.next = listNode;
        int nextValue = 0;
        while (l1 != null || l2 != null) {
            int thisValue = 0;
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);

            int tmp = sum + nextValue;
            if (tmp >= 10) {
                thisValue = tmp % 10;
                nextValue = 1;
            } else {
                thisValue = tmp;
                nextValue = 0;
            }
            listNode.next = new ListNode(thisValue);
            listNode = listNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (nextValue == 1) {
            listNode.next = new ListNode(1);
        }
        return result.next.next;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(8);
////        ListNode l3 = new ListNode(3);
//
//        l1.next = l2;
////        l2.next = l3;
//
//        ListNode l4 = new ListNode(0);
////        ListNode l5 = new ListNode(6);
////        ListNode l6 = new ListNode(4);
//
////        l4.next = l5;
////        l5.next = l6;
//
//        ListNode listNode = solution.addTwoNumbers(l1, l4);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//    }

}