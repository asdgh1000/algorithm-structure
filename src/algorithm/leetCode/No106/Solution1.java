package algorithm.leetCode.No106;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_idx]);
        //获取在inorder中post_idx的下标，此时inorder中post_idx左边的是左子树 右边的是右子树
        int index = idx_map.get(postorder[post_idx]);

        //后序数组中 获得下一个子数的父亲节点下标
        post_idx--;

        root.right= helper(index + 1, right);

        root.left= helper(left, index - 1);
        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // start from the last postorder element
        post_idx = postorder.length - 1;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length - 1);
    }

}
