//package algorithm.offer;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author ltw
// * on 2020-02-07.
// */
//public class Solution{
//
//    public int[] merge2Array(int[] a, int[] b) {
//
//        int[] mergedArray = new int[getLength(a, b)];
//        int x = 0;
//        int i = 0;
//        int j = 0;
//        while (i < a.length && j < b.length) {
//            if (a[i] >= b[j]) {
//                mergedArray[x++] = a[i];
//                i++;
//            } else {
//                mergedArray[x++] = b[j];
//                j++;
//            }
//        }
//        return mergedArray;
//    }
//
//    private int getLength(int[] a, int[] b) {
//        int count = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++)
//                if (a[i] == b[j]) {
//                    count++;
//                }
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        int[] a = {2, 10, 14, 19, 51, 71};
//        int[] b = {2, 10, 14, 19, 51, 71};
//        Solution solution = new Solution();
//        Solution.merge2Array(a, b);
//        for (int x : Solution.merge2Array(a, b)) {
//            System.out.println(x);
//        }
//    }
//}
