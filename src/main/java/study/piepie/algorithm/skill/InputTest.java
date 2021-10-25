package study.piepie.algorithm.skill;

import study.piepie.algorithm.entity.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Robin
 * @date 2021-10-10 15:31
 **/
public class InputTest {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.comparingInt(a -> a));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = bufferedReader.readLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        int root = Integer.parseInt(s[1]);
//        TreeNode[] tree = new TreeNode[n + 1];
//        int[][] leaf = new int[n + 1][2];

//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            System.out.println("Input from keyboard:" + sc.next());
//        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int root = Integer.parseInt(s[1]);
        TreeNode[] tree = new TreeNode[n + 1];
        int[][] leaf = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            String[] ss = reader.readLine().split(" ");
            int val_i = Integer.parseInt(ss[0]);
            int left_i = Integer.parseInt(ss[1]);
            int right_i = Integer.parseInt(ss[2]);
            TreeNode node = new TreeNode(val_i);
            leaf[i][0] = left_i;
            leaf[i][1] = right_i;
            tree[i] = node;
        }
        for (int i = 1; i <= n; i++) {
            int left = leaf[i][0];
            if (left != 0) {
                tree[i].left = tree[left];
            } else {
                tree[i].left = null;
            }
            int right = leaf[i][1];
            if (right != 0) {
                tree[i].right = tree[right];
            } else {
                tree[i].right = null;
            }
        }
        TreeNode head = tree[root];
    }


    private static boolean isBinarySearchTree(TreeNode node) {
        if(node == null){
            return true;
        }
        int pre = Integer.MIN_VALUE;
        Stack<TreeNode> s = new Stack<>();

        while(!s.isEmpty() || node != null){
            while(node != null){
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if(node == null){
                break;
            }
            if(pre > node.value){
                return false;
            }
            pre = node.value;
            node = node.right;
        }
        return true;
    }
}