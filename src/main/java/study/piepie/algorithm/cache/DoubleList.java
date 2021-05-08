package study.piepie.algorithm.cache;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Robin
 * @date 2021-05-08 10:22
 **/
@Getter
@Setter
public class DoubleList {
    private final Node head;
    private final Node tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.setNext(tail);
        tail.setPre(head);
    }

    public void remove(Node node) {
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
        size--;
    }

    public void addLast(Node node) {
        Node pre = tail.getPre();
        pre.setNext(node);
        node.setPre(pre);
        node.setNext(tail);
        tail.setPre(node);
        size++;
    }

    public Node removeFirst() {
        Node next = head.getNext();
        if (next == tail) {
            return null;
        }
        remove(next);
        return next;
    }

}