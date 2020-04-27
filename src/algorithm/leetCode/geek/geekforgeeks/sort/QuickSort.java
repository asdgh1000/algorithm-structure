package algorithm.leetCode.geek.geekforgeeks.sort;

/**
 * 核心思想:
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，
 * 前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 * <p>
 * 递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)终止条件：p >= r
 * 时间复杂度:
 * 最好时间复杂度:O(nlogN)
 * 最坏时间复杂度:O(n2)
 * 空间复杂度:
 * O(1)
 */
public class QuickSort {

    private void sort(int[] nums) {
        if(nums.length==0){
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }


    //    partition(A, p, r) {
//        pivot := A[r]
//        i := p
//        for j := p to r-1 do {
//            if A[j] < pivot {
//                swap A[i] with A[j]
//                i := i+1
//            }
//        }
//        swap A[i] with A[r]
//        return i
//

    /**
     * 数组的插入操作还记得吗？在数组某个位置插入元素，需要搬移数据，非常耗时。当时我们也讲了一种处理技巧，
     * 就是交换，在 O(1) 的时间复杂度内完成插入操作。这里我们也借助这个思想，
     * 只需要将 A[i]与 A[j]交换，就可以在 O(1) 时间复杂度内将 A[j]放到下标为 i 的位置。
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = pivot; j < right - 1; j++) {
            if (nums[j] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[right];
        nums[right] = tmp;

        return pivot;
    }

    public static void main(String[] args) {
        BubleSort bubleSort = new BubleSort();
        int[] test = new int[]{5,2,3,1};
        bubleSort.sort(test);
        for (int i = 0; i < test.length; i++) {

            System.out.println(test[i]);
        }
    }
}
