package algorithm.sort.stable;

/**
 * 规则：
 * 需要构造一个所有源数据可能出现的桶的列表，将源数据一一填进去，并进行计数，在最后根据桶进行遍历，当计数不是1的桶需要按计数多次取桶中数据
 * 时间复杂度: //待补充
 * 空间复杂度:
 * 桶排序的时间复杂度和空间复杂度是矛盾的，空间复杂度越高，时间复杂度就越低
 *
 * @author ltw
 * on 2019-08-28.
 */
public class SimpleBucketSort {
    public static void main(String[] args) {
        Integer[] choas = {3, 5, 1, 5, 1, 8, 0, 3, 7, 1, 5};
        SimpleBucketSort simpleBucketSort = new SimpleBucketSort();
        simpleBucketSort.bucketSort(choas);

//        for (Integer result : choas) {
//            System.out.println(result);
//        }
    }

    public void bucketSort(Integer[] choas) {
        Integer[] buckets = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < choas.length; i++) {
            buckets[choas[i]] = +1;
        }
        for (int j = 0; j < buckets.length; j++) {
            for (int h = 0; h < buckets[j]; h++) {
                System.out.println(choas[j]);
            }
        }
    }
}
