package study.piepie.algorithm.skill;

import study.piepie.algorithm.entity.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Robin
 * @date 2021-10-12 14:48
 **/
public class TreeInputSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] strArr = line.split("},");
        String nodeStr = strArr[0].replace("{","");
        String nodeOne = strArr[1].replace("{","");
        String nodeTwo = strArr[2].replace("{","").replace("}","");

        String[] nodeValues = nodeStr.split(",");
        TreeNode root = buildBst(nodeValues);
        System.out.println(root.left.right.right.value);
    }

    //{3,5,1,6,2,0,8,#,#,7,4},{6},{4}
    public static TreeNode buildBst(String[] nodeValues) {
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean addLeft = true;
        for (int i = 1; i < nodeValues.length; i++) {
            String value = nodeValues[i];
            TreeNode node = null;
            if (!"#".equals(value)) {
                node = new TreeNode(Integer.parseInt(value));
            }
            if (addLeft) {
                addLeft = false;
                TreeNode parent = queue.element();
                parent.left = node;
            } else {
                addLeft = true;
                TreeNode parent = queue.remove();
                parent.right = node;
            }
            if (node != null) {
                queue.add(node);
            }
        }
        return root;
    }
}