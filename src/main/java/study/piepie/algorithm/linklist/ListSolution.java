package study.piepie.algorithm.linklist;

import study.piepie.algorithm.entity.Node;

/**
 * @author Robin
 * @date 2021-10-20 11:17
 **/
public class ListSolution {
    public static Node findkthNode(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}