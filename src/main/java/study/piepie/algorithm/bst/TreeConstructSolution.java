package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.TreeNode;

/**
 * @author Robin
 * @date 2022-01-20 15:00
 **/
public class TreeConstructSolution {
    public TreeNode constructMaximumBinarySearchTree(int[] values, int begin, int end) {
        if (values == null || values.length <= 0 || end < begin) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = begin; i <= end; i++) {
            int value = values[i];
            if (value > max) {
                max = value;
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinarySearchTree(values, begin, index - 1);
        root.right = constructMaximumBinarySearchTree(values, index + 1, end);
        return root;
    }

    /**
     * build binary search tree from preorder and inorder
     *
     * @param preorder [3,9,20,15,7]
     * @param inorder  [9,3,15,20,7]
     * @return
     */
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) { // base case很关键，这边只需要判断preStart<preEnd.
            // 因为节点通过preorder[preStart]构建
            // 至于inorder.for循环会判断
            // 前提条件已经包含了是合法二叉搜索树的条件
            return null;
        }
        int value = preorder[preStart];
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (value == inorder[i]) {
                index = i;
                break;
            }
        }
        // 到这边必不存在instart > inend的情况。因为不可能在preoder能找到的元素，在inorder找不到
        TreeNode root = new TreeNode(value);
        int leftSize = index - inStart; // 此处一定 >=0 . 因为如果preorder里面能找到，inorder里面一定也有这个value。index>=instart
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    /**
     *
     * @param inStart
     * @param inEnd
     * @param postStart
     * @param postEnd
     * @param inOrder   [9,3,15,20,7]
     * @param postOrder [9,15,7,20,3]
     * @return
     */
    public static TreeNode buildTreeFromInAndPostOrder(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        int value = postOrder[postEnd];
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == value) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(value);
        int leftSize = index - inStart;
        root.left = buildTreeFromInAndPostOrder(inOrder, inStart, index - 1, postOrder, postStart,postStart + leftSize - 1);
        root.right = buildTreeFromInAndPostOrder(inOrder, index + 1, inEnd, postOrder, postStart + leftSize, postEnd - 1);
        return root;
    }
    public static TreeNode buildTree (int[] inorder, int[] postorder) {
        return buildTreeFromInAndPostOrder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public static void main(String[] args) {
        int[] inorder = new int[]{7,9,10,3};
        int[] postorder = new int[]{7,10,9,3};
        TreeNode root = buildTree(inorder, postorder);
        traversal(root);
    }
    public static void  traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        System.out.print(" " + root.value);
        traversal(root.right);
    }
}