//package algorithm.leetCode.interview.No27;
//
//import javax.swing.tree.TreeNode;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Solution {
//        public TreeNode mirrorTree(TreeNode root) {
//            if (root == null) return null;
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.add(root);
//            while (!queue.isEmpty()) {
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//                TreeNode tmp = node.left;
//                node.left = node.right;
//                node.right = tmp;
//            }
//            return root;
//        }
//    }
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//}