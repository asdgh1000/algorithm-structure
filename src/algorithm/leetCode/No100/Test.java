package algorithm.leetCode.No100;

public class Test {
    public void preTree(TreeNode p) {
        System.out.println(p.val);
        if (null != p.left) {
            preTree(p.left);
        }
        if (null != p.right) {
            preTree(p.right);
        }
    }
}
