package algorithm;

/**
 * @author ltw
 * on 2020-02-19.
 */
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 为最近最少使用（LRU）缓存策略设计一个数据结构，
 * 它应该支持以下操作：获取数据（get）和写入数据（set）。
 * 获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 * 写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。
 * 当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 *
 */
public class LRUCache<K, V>{
    LinkedHashMap<K,V> cache = null;
    private int cacheSize;
    public LRUCache(int cacheSize){
        this.cacheSize = (int) Math.ceil (cacheSize / 0.75f) + 1;  // ceil浮点数向上取整数
        cache = new LinkedHashMap<K,V>(this.cacheSize,0.75f,true){  //boolean accessOrder用来控制访问顺序的，默认设置为false，在访问之后，不会将当前访问的元素插入到链表尾部
            //内部类来重写removeEldestEntry()方法
            @Override
            protected boolean removeEldestEntry (Map.Entry<K, V> eldest){
                System.out.println("size="+size());
                return size() > cacheSize; //当前size()大于了cacheSize便删掉头部的元素
            }
        };
    }

    public V get(K key){   //如果使用继承的话就用getE而不是get，防止覆盖了父类的该方法
        return (V) cache.get(key);
    }
    public V set(K key,V value){
        return cache.put(key, value);
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void printCache(){
        for(Iterator it = cache.entrySet().iterator();it.hasNext();){
            Entry<K,V> entry = (Entry<K, V>)it.next();
            if(!"".equals(entry.getValue())){
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }
        System.out.println("------");
    }

    public void PrintlnCache(){
        Set<Map.Entry<K,V>> set = cache.entrySet();
        for(Entry<K,V> entry : set){
            K key = entry.getKey();
            V value = entry.getValue();
            System.out.println("key:"+key+"value:"+value);
        }

    }

    public static void main(String[] args) {
        LRUCache<String,Integer> lrucache = new LRUCache<String,Integer>(3);
        lrucache.set("aaa", 1);
        lrucache.printCache();
        lrucache.set("bbb", 2);
        lrucache.printCache();
        lrucache.set("ccc", 3);
        lrucache.printCache();
        lrucache.set("ddd", 4);
        lrucache.printCache();
        lrucache.set("eee", 5);
        lrucache.printCache();
        System.out.println("这是访问了ddd后的结果");
        lrucache.get("ddd");
        lrucache.printCache();
        lrucache.set("fff", 6);
        lrucache.printCache();
        lrucache.set("aaa", 7);
        lrucache.printCache();
    }

}

