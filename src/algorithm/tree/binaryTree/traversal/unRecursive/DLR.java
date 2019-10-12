package algorithm.tree.binaryTree.traversal.unRecursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * DLR (Preorder Traversal )前序遍历
 * 根->左->右
 * 非递归形式
 * 使用迭代法来遍历树 需要使用 stack来辅助存储节点数据
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
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

        }
        return list;

    }

}
