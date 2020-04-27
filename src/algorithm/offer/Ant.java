//1、用java代码实现LinkedList的add()和remove()方法。要求自行设计LinkedList数据结构，
//        不要外部类库和辅助函数来处理。
//
//        2、有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC,请补充以下代码:
//public class LoopPrintABC implements Runnable{
//}
//
//3、红包算法，输入红包金额和领取人数，返回每个人领取的红包金额,金额单位为分
//
////1、用java代码实现LinkedList的add()和remove()方法。要求自行设计LinkedList数据结构，
//// 不要外部类库和辅助函数来处理。
//class Node<T> {
//    public T data;
//
//    public Node next;
//
//    public Node pre;
//}
//
//interface MyLinkedList<E> {
//
//    /**
//     * 通过index获取Node
//     **/
//    E get(int index);
//
//    /**
//     * 增加node到列表index后
//     **/
//    boolean add(Node<E> node,int index);
//
//    /**
//     * 添加node到列表尾部
//     **/
//    boolean add(Node<E> node);
//
//    /**
//     * 通过index删除某个Node
//     **/
//    boolean remove(int index);
//
//    /**
//     * 获取尾元素
//     **/
//    E getLast();
//
//    /**
//     * 获取头元素
//     **/
//    E getFirst();
//
//
//}
//
//
//class MyLinkedList<E> implement MyLinkedList<E> {
//
//private int size;
//
////尾节点
//private Node<E> last;
//
////头节点
//private Node<E> first;
//
//
//public MyLinkedList() {
//        }
//
//@Overide
//public E get(int index) {
//        if(!isIndexInScope(index)) {
//        throw new OutOfScopeException();
//        }
//
//        Node<E> node = first;
//        for(int i=0;i<index;i++) {
//        node = node.next;
//        }
//        return node.data;
//        }
//
////检查index是否符合范围
//private boolean isIndexInScope(int index) {
//        return (index < size) && (index >=0) ;
//        }
//
//@Overide
//public E getLast() {
//        return last.data;
//        }
//
//@Overide
//public E getFirst() {
//        return first.data;
//        }
//
//@Overide
//public void add(int index,Node node) {
//
//        if(!isIndexInScope(index)) {
//        throw new OutOfScopeException();
//        }
//
//        Node tmp = first;
//
//        for(int i = 0;i<index;i++) {
//        tmp = tmp.next;
//        if(tmp.next == null) {
//        tmp.next = node;
//        }
//        else {
//        Node tmp2 = tmp.next.next;
//        tmp.next = node;
//        node.next = tmp2;
//        }
//        last = node;
//        }
//        size ++;
//        return true;
//        }
//
//@Overide
//public boolean add(Node node) {
//
//        if(first == null) {
//        first = node;
//        last = node;
//        }
//        last.next = node;
//        size ++;
//        return true;
//        }
//
//@Overide
//public boolean remove(int index) {
//
//        if(!isIndexInScope(index)) {
//        throw new OutOfScopeException();
//        }
//
//        if(first == null) {
//        throw new XXXException();
//        }
//        Node tmp = first;
//        for(int i=0;i<index;i++) {
//        if(tmp.next == null) {
//        tmp == null;
//        }
//        else {
//        Node pre = tmp.pre;
//        pre.next = tmp.next;
//        tmp = null;
//        }
//        }
//        size--;
//        return true;
//        }
//
//        }
//
////2、有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC,请补充以下代码:
//public class LoopPrintABC implements Runnable {
//
//    private int num;
//    private String word;
//    private myCondition;
//    private nextCondition;

//    public LoopPrintABC(int num,String word,Condition myCondition,Condition nextCondition){
//        this.num = num;
//        this.word = word;
//        this.myCondition = myCondition;
//        this.nextCondition = nextCondition;
//    }
//
//    @Override
//    public void run () {
//        try{
//            for(int i=0;i<10;i++) {
//                lock.lock();
//                //0%3 = 0; 1%3 =1; 2%3=2;
//                if(i%3 == num) {
//                    System.out.println(word;);
//                    i++;
//                    myContidion.await();
//                    nextCondition.siginal();
//                }
//            }
//        }
//    } catch(IllegealException e){
//        e.printStatckTrace();
//    }
//}
//
//
//class PrintNum {
//    Lock lock = new ReentrantLock();
//
//    Condition conditionA = lock.newCondition();
//    Condition conditionB = lock.newCondition();
//    Condition conditionC = lock.newCondition();
//
//    Thread printA = new Thread(()->{
//        new LoopPrintABC(0,"A",conditionA,conditionB);
//    });
//    Thread printB = new Thread(()->{
//        new LoopPrintABC(1,"B",conditionB,conditionC);
//    });
//    Thread printC = new Thread(()->{
//        new LoopPrintABC(2,"C",conditionC,conditionA);
//    });
//    printA.start();
//    printB.start();
//    printC.start();
//
//
//
//}
//
//    //3、红包算法，输入红包金额和领取人数，返回每个人领取的红包金额,金额单位为分
//    public BigDecimal calculateRedPacket(double amount,int people) {
//        return BigDecimal.valueOf(amount/people).setScale(2,BigDecimal.ROUND_HALF_DOWN);
//    }
