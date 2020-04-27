package algorithm.offer;


/**
 * @author ltw
 * on 2020-01-09.
 */
public class IpListImpl implements IpList {

    private long ipToLong(String ip) {
        long ret = 0;
        String[] ipStrArr = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret += Long.valueOf(ipStrArr[i]);
        }
        return ret;
    }

    @Override
    public boolean isInList(String ip) {
        System.out.println(ipToLong(ip));
        return false;
    }

    public static void main(String[] args) {
        IpListImpl ipList = new IpListImpl();
        ipList.isInList("192.168.0.124");
    }
}
