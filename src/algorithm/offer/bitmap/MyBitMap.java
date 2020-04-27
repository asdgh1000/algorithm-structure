package algorithm.offer.bitmap;

import javax.jws.soap.SOAPMessageHandlers;
import java.util.BitSet;

/**
 * @author ltw
 * on 2020-01-09.
 */
public class MyBitMap implements BitMap {
    private byte[] arr;

    private int capacity;

    public MyBitMap(int capacity) {
        arr = new byte[(capacity / 8 + 1)];

    }

    @Override
    public void add(int n) {
        int index = n >> 3;
        int pos = n % 8;
        arr[index] |= 1 << pos;
    }

    @Override
    public void delete(int n) {
        int index = n >> 3;
        int pos = n % 8;
        arr[index] &= ~(1 << pos);

    }

    @Override
    public boolean contain(int n) {
        int index = n >> 3;
        int pos = n % 8;
        return (arr[index] & (1 << pos)) != 0;

    }
}
