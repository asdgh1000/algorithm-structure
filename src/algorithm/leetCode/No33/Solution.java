//package algorithm.leetCode.No33;
//
//public class Solution {
////    解题思路：
////    题目要求 O(logN)O(logN) 的时间复杂度，基本可以断定本题是需要使用二分查找，怎么分是关键。
////    由于题目说数字了无重复，举个例子：
////            1 2 3 4 5 6 7 可以大致分为两类，
////    第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
////    这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
////    第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
////    这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。
//
//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int middle = (left + right) / 2;
//            if (nums[middle] == target) {
//                return middle;
//            }
//            if (nums[left] <= nums[middle]) { //表示前半部分有序
//                if (target >= nums[left] && target < nums[middle]) { //target在前半部分
//                    right = middle - 1;
//                } else {
//                    left = middle + 1;
//                }
//
//            } else {
//                if (target <= nums[right] && target > nums[middle]) { //target在后半部分
//                    left = middle + 1;
//                } else {
//                    right = middle - 1;
//                }
//
//            }
//        }
//    }
//}
