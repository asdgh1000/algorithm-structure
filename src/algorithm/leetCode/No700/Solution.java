package algorithm.leetCode.No700;

import apple.laf.JRSUIUtils;

public class Solution {
    //solution1 直接DFS
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) return root;
        TreeNode left = null;
        TreeNode right = null;
        if (null != root.left) {
            left = searchBST(root.left, val);
        }
        if (null != root.right) {
            right = searchBST(root.right, val);

        }
        if (null == left && right == null) {
            return null;
        }
        if (null != left) {
            return left;
        }
        if (null != right) {
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        Solution solution = new Solution();
        TreeNode treeNode = solution.searchBST(node3, 15);
        System.out.println(treeNode.val);

    }
}
