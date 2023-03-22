package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.Node;

/**
 * @author Robin
 * @date 2022-01-04 11:32
 **/
public class ListIntersection {
    public static Node getIntersectionNode(Node a, Node b) {
        Node p1 = a;
        Node p2 = b;
        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = b;
            }
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = a;
            }
        }
        return p1;
    }
}