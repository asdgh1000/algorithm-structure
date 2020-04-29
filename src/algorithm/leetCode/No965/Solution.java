package algorithm.leetCode.No965;

public class Solution {
    boolean isUnivalTree = true;
    int value = -99;

    public boolean isUnivalTree(TreeNode root) {
        help(root);
        return isUnivalTree;
    }

    private void help(TreeNode node) {
        if (node == null) {
            return;
        }
        if (value != -99 && node.val != value) {
            isUnivalTree = false;
        }else {
            value = node.val;
        }
        help(node.left);
        help(node.right);
    }

}
