package algorithm.leetCode.No669;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<TreeNode> list = new LinkedList<>();

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        //右边部分直接不要了
        if (R < root.val) return trimBST(root.left, L, R);
        //左边部分直接不要了
        if (L > root.val) return trimBST(root.right, L, R);
        //没问题的修剪左子树
        root.left = trimBST(root.left, L, R);
        //没问题的修剪右子树
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
