package algorithm.hanshunping.linkedList;

/**
 * @author ltw
 * on 2019-12-28.
 */
public class ReverseLinkedList {
    private Node solution(Node head) {
        if ((head.next == null) || (head.next.next == null)) {
            return head;
        }
        Node reverseHead = new Node();
        Node current = head.next;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = reverseHead.next;
            reverseHead.next = current;
            current = next;
        }
        head.next = reverseHead.next;
        return head;

    }

    public static void main(String[] args) {
    }
}
