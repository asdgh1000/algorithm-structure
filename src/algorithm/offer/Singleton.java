package algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltw
 * on 2020-01-08.
 */
public class Singleton {
    private volatile static Singleton singleton = null; //volatile 防止new Singleton()指令重排序 造成对象创建失败

    private Singleton() {

    }

    private static final Object lock = new Object();
    public static Singleton getInstance() {
        synchronized (lock) {
            if (singleton == null) {
                return new Singleton();
            } else {
                return singleton;
            }
        }
    }

    //两次判断 减少加锁操作
    public static Singleton getInstance2() {
        if (singleton == null) {
            synchronized (lock) {
                if (singleton == null) { //double check
                    return new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
