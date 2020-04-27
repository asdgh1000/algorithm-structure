package concurrent.capter5.lock;

/**
 * @author ltw
 * on 2019-12-24.
 */
public interface Lock {
    public void lock() throws InterruptedException;

    public void lock(Long min);

    public void unLock();
}
