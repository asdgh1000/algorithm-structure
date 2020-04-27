package algorithm.leetCode.No07;

import algorithm.leetCode.No06.ListNode;


public class Solution1 {
    public TreeNode buildTree(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int value = pre[preLeft];
        TreeNode node = new TreeNode(value);
//        for (int i = inLeft; i < inRight; i++) {
//            if (value == in[i]) {
//
//            }
//        }

        //计算中序遍历中父节点的位置
        int count = preLeft;
        while (in[count] != value) {
            count++;
        }
        count -= preLeft;

        node.left = buildTree(pre, in, preLeft + 1, preLeft + count, inLeft, inLeft + count - 1);
        node.right = buildTree(pre, in, preLeft + count + 1, preRight, inLeft + count + 1, inRight);
        return node;
    }
}
