package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.Node;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Robin
 * @date 2022-01-03 16:13
 **/
public class ListMergeSolution {
    //
    public Node mergeTwoList(Node first, Node second) {
        Node head = new Node(-1);
        Node p = head; // head 和 p同时指向虚拟节点，但是head保持不动，p循环中不断前进
        Node p1 = first;
        Node p2 = second;
        while (p1 != null && p2 != null) {
            if (first.value >= second.value) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return head.next;
    }

    public static Node mergeKLists(List<Node> nodes) {
        Node dummy = new Node(-1);
        Node p = dummy;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.value));
        for (Node node : nodes) {
            queue.offer(node);
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            p.next = node;
            p = p.next;
            queue.offer(node.next);
        }
        return dummy.next;
    }
}