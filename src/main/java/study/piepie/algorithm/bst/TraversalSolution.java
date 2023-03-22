package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.TreeNode;

/**
 * @author Robin
 * @date 2021-12-30 18:06
 **/
public class TraversalSolution {
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }
}