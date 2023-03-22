package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.TreeNode;

/**
 * @author Robin
 * @date 2022-01-27 17:27
 **/
public class BstSearchSolution {
    public int findKthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private int rank = 0;
    private int res = 0;
    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.value;
            return;
        }
        traverse(root.right, k);
    }
}