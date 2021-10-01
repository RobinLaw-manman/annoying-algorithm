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

    public static Node reverse(Node head) {
        Node pre = null;
        Node current = head;
        while (current != null) {
            Node next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        return pre;
    }

    public static Node reverse2(Node node) {
        if (node.getNext() == null) {
            return node;
        }
        Node next = node.getNext();
        Node newHead = reverse2(node.getNext());
        next.setNext(node);
        node.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
//        Node head = new Node(1);
//        Node tail = new Node(2);
//        head.setNext(tail);
//
//        Node newHead = reverse(head, tail)[0];
//        while (newHead != null) {
//            System.out.println(newHead.getValue());
//            newHead = newHead.getNext();
//        }


        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(forth);

        Node newHead2 = reverse2(first);
        while (newHead2 != null) {
            System.out.println(newHead2.getValue());
            newHead2 = newHead2.getNext();
        }
    }
}