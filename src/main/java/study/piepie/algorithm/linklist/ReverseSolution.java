package study.piepie.algorithm.linklist;

import study.piepie.algorithm.entity.Node;

/**
 * @author Robin
 * @date 2021-05-20 15:09
 **/
public class ReverseSolution {

    public Node reverseKGroup(Node head, int k) {
        if (head == null) {
            return head;
        }
        while (true) {
            Node tail = head;
            for (int i = 0; i < k; i++) {

            }
        }
    }

    public static Node reverse(Node a, Node b) {
        Node pre = b.getNext();
        Node cur = a;
        while (pre != b) {
            Node next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return b;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node tail = new Node(2);
        head.setNext(tail);

        Node newHead = reverse(head, tail);
        while (newHead != null) {
            System.out.println(newHead.getValue());
            newHead = newHead.getNext();
        }
    }
}