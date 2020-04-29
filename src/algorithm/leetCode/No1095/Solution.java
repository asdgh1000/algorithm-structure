package algorithm.leetCode.No1095;


class Solution {
//    public int findInMountainArray(int target, ) {
//        int res;
//        int peak = findMountainPeak(mountainArr, 0, mountainArr.length - 1);
//        int res = findLeft(target, mountainArr, 0, peak - 1);
//        if (res != -1) {
//            return res;
//        }
//        return findRight(target, mountainArr, peak + 1, mountainArr.length - 1);
//    }

    private int findLeft(int target, int[] mountainArr, int left, int right) {
        while (left <= right) {
            int tmp = left + (right - left) / 2;
            if (mountainArr[tmp] == target) {
                return tmp;
            }
            if (mountainArr[tmp] < target) {
                left = ++tmp;
            }
            if (mountainArr[tmp] > target) {
                right = --tmp;
            }
        }
        return -1;

    }

//    public int findInMountainArray(int target, MountainArray mountainArr) {
//        int middle = findMountainPeak(mountainArr, 0, mountainArr.length() - 1);
//        int left = 0;
//        int right = middle;
//        while (left <= right) {
//            int tmp = left + (right - left) / 2;
//            if (mountainArr.get(tmp) == target) {
//                return tmp;
//            }
//            if (mountainArr.get(middle) < target) {
//                left = ++tmp;
//            }
//            if (mountainArr.get(middle) > target) {
//                right = --tmp;
//            }
//        }
//        return -1;
//
//    }
//
    /**
     * 先找山峰
     *
     * @param mountainArray
     * @return
     */
    private int findMountainPeak(MountainArray mountainArray, int left, int right) {
        while (left < right) {
            int middle = left + (right - left) / 2;
            //说明山峰在右半边
            if (mountainArray.get(middle) < mountainArray.get(middle + 1)) {
                left = middle + 1;
                //说明山峰在左半边
            } else {
                right = middle;
            }
        }
        //left == right
        return left;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.findInMountainArray(2, new int[]{1, 5, 2}));
//    }

}


//1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2