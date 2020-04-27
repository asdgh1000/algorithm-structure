package algorithm.leetCode.week02.No589;

import java.util.List;

/**
 * @author ltw
 * on 2020-02-19.
 */
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

