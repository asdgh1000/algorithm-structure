package algorithm.tree.binaryTree.traversal.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * LDR (Inorder Traversal) 中序遍历
 * 左->根->右
 * 递归形式
 * time:1ms 97.88%
 * mem:34.9MB 39.36%
 * @author ltw
 * on 2019-10-10.
 */
public class LDR {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode node) {

        if (null == node) {
            return new ArrayList<>();
        }
        if (node.left != null) {
            inorderTraversal(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            inorderTraversal(node.right);
        }
        return list;
    }

}
