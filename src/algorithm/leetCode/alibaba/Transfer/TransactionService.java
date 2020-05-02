//package algorithm.leetCode.alibaba.Transfer;
//
//public class TransactionService {
//    public void transfer(TransactionDTO transactionDTO) {
//        //大体逻辑是 A->B转账需要加锁，
//        //但是有可能会造成deadLock，因此需要为A,B的锁创建优先级。可以使用A账户和B账户做对比
//        //永远保证A账户有限获得锁，B账户才获得锁
//        //2.
//        //保证上游传过来带transactionDTO中的sequenceNumber不为空（如果sequenceNumber不能保证唯一性，可以借助类似snowflake生成唯一Id），
//        //在单库的情况下每次到mysql的表中去做插入校验，
//        // 可以考虑将sequenceNumber作为 unique Key索引，这样每笔转账不会被重复消费。
//        //如果是分库分表情况下 需要单独创建表或其他做这个事情。
//        synchronized (A) {
//
//            synchronized (B) {
//
//            }
//
//        }
//    }
//}
