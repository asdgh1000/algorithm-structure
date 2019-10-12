package algorithm.tree.binaryTree.traversal.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * DLR (Preorder Traversal )前序遍历
 * 中->左->右
 * 递归形式
 * time:1ms 98.08%
 * mem:34.8MB 40.77%
 *
 * @author ltw
 * on 2019-10-10.
 */
public class DLR {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode node) {
        if (null == node) {
            return new ArrayList<>();
        }

        list.add(node.val);
        if (null != node.left) {
            preorderTraversal(node.left);
        }
        if (null != node.right) {
            preorderTraversal(node.right);
        }
        return list;
    }
}
