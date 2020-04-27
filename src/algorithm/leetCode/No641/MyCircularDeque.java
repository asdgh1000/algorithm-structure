package algorithm.leetCode.No641;

/**
 * @author ltw
 * on 2020-01-15.
 */
class MyCircularDeque {

    private int size = 0;

    private Node head;

    private Node end;

    private int initSize;

    public MyCircularDeque() {
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.initSize = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size >= initSize) {
            return false;
        }
        if (size == 0) {
            end = head = new Node(value);
            end.next = head;
            end.pre = head;
            size++;
            return true;

        }
        Node node = new Node(value);
        node.next = head;
        head = node;
        head.pre = end;
        size++;
        return true;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size >= initSize) {
            return false;
        }
        if (size == 0) {
            end = head = new Node(value);
            end.next = head;
            end.pre = head;
            size++;
        } else {
            Node node = new Node(value);
            node.pre = end;
            end = node;
            end.next = head;
            head.pre = end;
            size++;
            if (head.next == head) {
                head.next = end;
            }
        }
        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (head != null) {
            if (size == 1) {
                end = head = null;
                size--;
                return true;
            }
            if (head.next == null) {
                head = end = null;
                size--;
                return true;
            } else {
                end.next = end.next.next;
                head = end.next;
                size--;
                return true;
            }
        } else {
            //没有元素在队列中 无法删除
            return false;
        }

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (head != null) {
            if (size == 1) {
                end = head = null;
                size--;
                return true;
            }
            if (head.next == null) {
                head = end = null;
                size--;
                return true;
            } else {
                head.pre = head.pre.pre;
                end = head.pre;
                end.next = head;
                size--;
                return true;
            }
        } else {
            //没有元素在队列中 无法删除
            return false;
        }

    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return head.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return end.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == initSize;
    }

    class Node {
        public Node(int value) {
            this.value = value;
        }

        public int value;

        public Node pre;

        public Node next;


    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(5);
        boolean param_1 = obj.insertFront(4);
        boolean param_2 = obj.deleteLast();
        int param_3 = obj.getRear();
        int param_4 = obj.getFront();
        int param_5 = obj.getFront();
        boolean param_6 = obj.deleteFront();
        boolean param_7 = obj.insertFront(6);
        boolean param_8 = obj.insertLast(5);
        boolean param_9 = obj.insertFront(9);
        int param_10 = obj.getFront();
        boolean param_11 = obj.insertFront(6);

    }
}


