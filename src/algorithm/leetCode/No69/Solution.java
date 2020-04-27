//package algorithm.leetCode.No69;
//
///**
// * @author ltw
// * on 2020-01-20.
// */
//class Solution {
//    public int mySqrt(int x) {
//        int left = 0;
//        int right = x;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            int result = mid;
//            if (x - mid * mid < 0.001) {
//                return mid;
//            }
//            if (mid > left) {
//                left = mid + 1;
//            }
//            if (mid < right) {
//
//            }
//        }
//    }
//}