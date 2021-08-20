package study.piepie.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Robin
 * @date 2021-08-06 14:40
 **/
public class SubsetPermutationCombination {
    static List<LinkedList<Integer>> res = new ArrayList();

    public static List<LinkedList<Integer>> subsets(int n) {
        backtrack(n, 0, new LinkedList<>());
        return res;
    }

    /**
     * 子集
     * @param n
     * @param start
     * @param subset
     */
    public static void backtrack(int n, int start, LinkedList<Integer> subset) {
        // 和二叉树的遍历一样，关注当前节点该干什么
        // 当前节点就是已经加入了当前元素的subset
        LinkedList<Integer> sub = new LinkedList<>(subset);
        // 前序遍历，当前节点要做的就是把当前节点及之前的元素当成集合放入结果res
        res.add(sub);
        // 递归之后的节点（类似二叉树遍历左右子树）
        // 把子节点加入，并且子节点的子节点的起始位置
        for (int i = start; i < n; i++) {
            subset.add(i);
            backtrack(n, i + 1, subset);
            // 回溯和树的遍历区别在此，完成当前节点的事情之后
            // 从路径里面删掉当前节点，就会在循环中处理下一个孩子
            // 类似遍历完左子树后处理右子树
            subset.pollLast();
        }
    }

    /**
     * 组合
     * @param n
     * @param start
     * @param k
     * @param sub
     */
    public static void backtrack(int n, int start, int k, LinkedList<Integer> sub) {
        if (k == sub.size()) {
            res.add(new LinkedList<>(sub));
            return; // 很关键 不需要在遍历后面的子节点了
        }
        for (int i = start; i< n; i++) {
            sub.add(i);
            backtrack(n, i+1, k, sub);
            sub.pollLast();
        }
    }
}