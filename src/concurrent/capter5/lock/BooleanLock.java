package concurrent.capter5.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltw
 * on 2019-12-24.
 */
public class BooleanLock implements Lock {
    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                if (!blockedList.contains(getCurrentThread())) {
                    blockedList.add(getCurrentThread());
                }
                this.wait();
            }

            blockedList.remove(Thread.currentThread());
            this.locked = true;
            this.currentThread = getCurrentThread();
        }
    }

    @Override
    public void lock(Long min) {
    }

    @Override
    public void unLock() {
        synchronized (this) {
            if (currentThread.equals(getCurrentThread())) {
                this.locked = false;
                this.notifyAll();
            }
        }
    }

    private Thread getCurrentThread() {
        return Thread.currentThread();
    }
}
