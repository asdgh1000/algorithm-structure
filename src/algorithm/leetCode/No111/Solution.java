package algorithm.leetCode.No111;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右子树分别递归求各自的深度
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 如果左右子树都为空或者有一方为空，则直接返回两者的深度 + 1即可
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        // 若都不为空就选两者最小的深度 + 1
        return Math.min(left, right) + 1;
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
        System.out.println(solution.minDepth(treeNode));
    }
}