package algorithm.leetCode.No374;

import sun.tools.attach.HotSpotVirtualMachine;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                max = --middle;
            } else {
                min = ++middle;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5,6,7,8,9},2));
    }

}

