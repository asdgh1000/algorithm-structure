//package algorithm.leetCode.No108;
//
//import com.sun.jmx.remote.internal.ArrayQueue;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution {
//    public TreeNode sortedArrayToBST(int[] nums) {
//    }
//
//    private TreeNode help(int[] nums){
//        if (nums.length <= 0) return null;
//        int left = 0;
//        int right = nums.length - 1;
//        int middle = left + (right - left) / 2;
//        TreeNode root = new TreeNode(nums[middle]);
//        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, left, middle - 1));
//        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, right));
//        return
//
//    }
//
//    private TreeNode generate(int[] nums) {
//        if (nums.length <= 0) return null;
//
//        int left = 0;
//        int right = nums.length - 1;
//        int middle = left + (right - left) / 2;
//        return new TreeNode(nums[middle]);
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
