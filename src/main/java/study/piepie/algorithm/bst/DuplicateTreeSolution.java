package study.piepie.algorithm.bst;

import study.piepie.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Robin
 * @date 2022-01-24 17:47
 **/
public class DuplicateTreeSolution {
    Map<String, Integer> treeCountMap = new HashMap<>();
    List<TreeNode> nodes = new ArrayList<>();

    public List<TreeNode> findDuplicateTrees(TreeNode root) {
        traverse(root);
        return nodes;
    }

    public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String tree = traverse(root.left) + "" + traverse(root.right) + root.value;
        int freq = treeCountMap.getOrDefault(tree, 0);
        if (freq == 1) {
            nodes.add(root);
            treeCountMap.put(tree, 2);
        }
        treeCountMap.put(tree, freq + 1);
        return tree;
    }
}