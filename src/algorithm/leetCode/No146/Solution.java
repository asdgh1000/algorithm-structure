package algorithm.leetCode.No146;

import algorithm.leetCode.No202.Solution;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {
    Map<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
         //boolean accessOrder用来控制访问顺序的，默认设置为false，在访问之后，不会将当前访问的元素插入到链表尾部
        cache = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println("size=" + size());
                //当前size()大于了cacheSize便删掉头部的元素
                return size() > capacity;
            }
        };

        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.get(key) == null ? -1 : cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */