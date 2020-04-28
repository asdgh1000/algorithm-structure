package algorithm.leetCode.No700;

public class Solution2 {
    //使用二分查找，因为原树是BST树
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) return root;
        TreeNode result = null;
        if (root.right != null && root.val < val) {
            TreeNode tmp = searchBST(root.right, val);
            if (tmp != null) result = tmp;

        }
        if (root.left != null && root.val > val) {
            TreeNode tmp = searchBST(root.left, val);
            if (tmp != null) result = tmp;
        }
        return result;
    }
//官方题解 更简洁
//    class Solution {
//        public TreeNode searchBST(TreeNode root, int val) {
//            if (root == null || val == root.val) return root;
//
//            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
//        }
//    }
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree/solution/er-cha-sou-suo-shu-zhong-de-sou-suo-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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
        Solution2 solution2 = new Solution2();
        TreeNode treeNode = solution2.searchBST(node3, 15);
        System.out.println(treeNode.val);

    }
}
