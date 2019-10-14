package algorithm.tree.binaryTree.traversal.recursive;

/**
 * @author ltw
 * on 2019-10-12.
 */
public class MaxDepth {
    int rightDepth = 1;
    int leftDepth = 1;

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.right != null) {
            rightDepth++;
            maxDepth(root.right);

        }
        if (root.left != null) {
            leftDepth++;
            maxDepth(root.left);
        }
        return Math.max(rightDepth, leftDepth);
    }
}
