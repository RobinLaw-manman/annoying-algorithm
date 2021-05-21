package study.piepie.algorithm.linklist;

import study.piepie.algorithm.entity.Node;

/**
 * @author Robin
 * @date 2021-05-20 15:09
 **/
public class ReverseSolution {

    public Node reverseKGroup(Node head, int k) {
        Node hair = new Node(0);
        hair.setNext(head);
        Node pre = hair;
        while (head != null) {
            Node tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.getNext();
                if (tail ==null) {
                    return hair.getNext();
                }
            }
            Node[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            pre.setNext(head);
            pre = tail;
            head = tail.getNext();
        }
        return hair.getNext();
    }

    public static Node[] reverse(Node a, Node b) {
        Node pre = b.getNext();
        Node cur = a;
        while (pre != b) {
            Node next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return new Node[]{b, a};
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node tail = new Node(2);
        head.setNext(tail);

        Node newHead = reverse(head, tail)[0];
        while (newHead != null) {
            System.out.println(newHead.getValue());
            newHead = newHead.getNext();
        }
    }
}