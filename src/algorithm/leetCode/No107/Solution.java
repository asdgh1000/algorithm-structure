package algorithm.leetCode.No107;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int i = queue.size() - 1;
            while (i >= 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                tmp.add(node.val);
                i--;
            }
            list.add(0, tmp);
        }
        return list;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        List list = solution.levelOrderBottom(treeNode);
        System.out.println(list);
    }
}