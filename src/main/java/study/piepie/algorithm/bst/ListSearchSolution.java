package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.Node;

/**
 * @author Robin
 * @date 2022-01-03 18:09
 **/
public class ListSearchSolution {
    public static Node findKthLast(Node head, int k) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}