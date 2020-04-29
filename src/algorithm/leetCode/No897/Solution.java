package algorithm.leetCode.No897;

public class Solution {
    TreeNode tmp = new TreeNode(-1);
    TreeNode result = tmp;

    public TreeNode increasingBST(TreeNode root) {
        help(root);
        return result.right;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        tmp.right = new TreeNode(root.val);
        tmp = tmp.right;
//        System.out.println(root);
        help(root.right);

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
        solution.increasingBST(treeNode);

    }
}
