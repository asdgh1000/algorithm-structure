package algorithm.tree.binaryTree.traversal.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * LRD (Postorder Traversal) 后序遍历
 * 左->右->根
 * <p>
 * 递归形式
 * time:1ms 98.48%
 * mem:34.7MB 37.21%
 *
 * @author ltw
 * on 2019-10-10.
 */
public class LRD {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode node) {

        if (null == node) {
            return new ArrayList<>();
        }
        if (null != node.left) {
            postorderTraversal(node.left);
        }
        if (null != node.right) {
            postorderTraversal(node.right);
        }
        list.add(node.val);
        return list;
    }
}
