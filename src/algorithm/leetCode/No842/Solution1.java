//package algorithm.leetCode.No842;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution1 {
//
//    public List<Integer> splitIntoFibonacci(String s) {
//        List<Integer> list = new ArrayList<>();
//        if (dfs(0, s, list)) return list;
//        return new ArrayList<>();
//    }
//
//    private boolean dfs(int pos, String s, List<Integer> nums) {
//        if (pos == s.length()) {
//            //题目要求至少有3个数组成fib
//            return nums.size() >= 3;
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
