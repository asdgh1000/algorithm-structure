package algorithm.offer.bitmap;

/**
 * @author ltw
 * on 2020-01-09.
 */
public interface BitMap {
    /**
     * 向bitmap中增加元素
     * @param n
     */
    void add(int n);

    /**
     * 向bitmap中删除元素
     * @param n
     */
    void delete(int n);

    /**
     * 判断bitmap中是否存在该元素
     * @param n
     */
    boolean contain(int n);
}
