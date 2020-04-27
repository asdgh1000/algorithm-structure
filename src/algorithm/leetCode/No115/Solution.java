package algorithm.leetCode.No115;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        int x = height(root.left);
        int y = height(root.right);
        return (Math.abs(x - y) < 2) && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }


//    /**
//     * [3,9,20,null,null,15,7]
//     *     3
//     *    / \
//     *   9  20
//     *     /  \
//     *    15   7
//     * @param root
//     * @param origin
//     */
//    public void makeTree(TreeNode root, Integer[] origin) {
//        Integer[] test = new Integer[]{};
//        int sum = 0;
//        for (int i = 0; i < test.length; i++) {
//            if(i==1){
//                root.
//            }
//        }
//    }

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
        System.out.println(solution.isBalanced(treeNode));
    }
}