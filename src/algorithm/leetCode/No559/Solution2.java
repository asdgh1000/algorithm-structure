package algorithm.leetCode.No559;

import java.util.List;

public class Solution2 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }
        int result = 0;
        for (Node node : root.children) {
            result = Math.max(maxDepth(node), result);
        }
        return result+1;
    }

}
