package algorithm.leetCode.No23;

import algorithm.leetCode.No1290.ListNode;

import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));

        for (ListNode listNode : lists) {
            if (listNode != null) heap.add(listNode);
        }
        while (!heap.isEmpty()) {
            tmp.next = heap.poll();
            tmp = tmp.next;
            if (tmp.next != null) heap.add(tmp.next);
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void test() {
        Solution solution = new Solution();
        ListNode[] listNodes = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;
        ListNode listNode = solution.mergeKLists(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test();
    }
}
