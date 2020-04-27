package algorithm.leetCode.No559;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size++;
            for (int j = 0; j < queue.size(); j++) {
                Node node = queue.poll();
                for (Node tmp : node.children) {
                    if (null != tmp) {
                        queue.add(tmp);
                    }
                }
            }
        }
        return size;
    }
}

