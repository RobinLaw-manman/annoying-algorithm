package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.BstNode;

/**
 * @author Robin
 * @date 2021-05-28 11:00
 **/
public class LowestCommonAncestor {
    public static BstNode lowestCommonAncestor(BstNode root, BstNode p, BstNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q==root) {
            return root;
        }
        BstNode left = lowestCommonAncestor(root.getLeft(), p, q);
        BstNode right = lowestCommonAncestor(root.getRight(), p, q);

        // 1 左子树右子树返回都不为空，但是p,q不可能同时存在于左子树和右子树，所以一定是p,q分别在左右或者右左子树
        // 那么这边是后续遍历位置的第一个交汇点，所以root一定是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 2 都没找到返回空
        if (left == null && right == null) {
            return null;
        }
        // 3 只在左子树或者右子树找到了最近公共祖先，那该最近祖先即为结果
        return left == null ? right : left;
    }
}