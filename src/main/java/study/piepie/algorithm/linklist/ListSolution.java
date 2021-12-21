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

    public static boolean isPalindrom(Node node) {
        return isPalindrom(node, node);
    }

    // 错误实现，应该用一个类的属性来代替tmp
    public static boolean isPalindrom(Node tmp, Node node) {
        if (node == null) return true;
        boolean isPalindrom = isPalindrom(tmp, node.next);
        boolean equal =  node.getValue() == tmp.getValue();
        // 下面是一个错误的示范，没有充分理解，参数传递的时候，
        // 方法调用传递引用，只是让该方法的形参赋予了实参的值，
        // 也就是方法外面的实参变量，和方法内部的形参变量同时指向了同一块内存。
        // 所以方法内部对形参重新赋值，只是让形参变量和外面的实参又指向了不同的地址而已
        // 并不会改变外面实参的地址。
        tmp = tmp.next;
        return equal && isPalindrom;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(2);
        Node four = new Node(1);
        one.setNext(two);two.setNext(three);three.setNext(four);
        System.out.println(isPalindrom(one));
    }
}