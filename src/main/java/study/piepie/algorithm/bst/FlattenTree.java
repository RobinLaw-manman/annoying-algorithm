package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.BstNode;

/**
 * @author Robin
 * @date 2021-10-05 22:55
 **/
public class FlattenTree {
    public static void flatten(BstNode root) {
        if (root == null) return;
        BstNode right = root.getRight();
        BstNode left = root.getLeft();
        flatten(left);
        flatten(right);

        root.setLeft(null);
        if (left != null) {
            root.setRight(left);
            BstNode last = left;
            while (last.getRight() != null) {
                last = last.getRight();
            }
            last.setRight(right);
        }
    }
}