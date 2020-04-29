package algorithm.leetCode.interview.No54;

public class Solution {
    int k;
    int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        help(root);
        return res;
    }

    private void help(TreeNode root) {
        if (root == null) return;

        help(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        help(root.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(10);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(solution.kthLargest(treeNode, 3));

    }
}
