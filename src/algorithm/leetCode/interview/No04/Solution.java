package algorithm.leetCode.interview.No04;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int middle = (nums.length - 1) / 2;
        int left = middle - 1;
        int right = middle + 1;
        TreeNode root = new TreeNode(nums[middle]);
        return sort(nums, left, right, root);

    }
//    class Solution {
//        public TreeNode sortedArrayToBST(int[] nums) {
//            if(nums.length==0) return null;
//            TreeNode n = new TreeNode(nums[nums.length/2]);
//            n.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
//            n.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
//            return n;
//        }
//    }

//    private TreeNode helper(int[] nums,int left,int right){
//        if(left==right){
//            return null;
//        }
//        int mid=left+(right-left)/2;
//        TreeNode node = new TreeNode(nums[mid]);
//        node.left = helper(nums,left,mid);
//        node.right = helper(nums,mid+1,right);
//        return node;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
