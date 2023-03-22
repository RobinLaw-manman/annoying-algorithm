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
        //输入描述:
        //第一行两个数n,root，分别表示二叉树有n个节点，第root个节点时二叉树的根
        //接下来共n行，第i行三个数val_i,left_i,right_i，
        //分别表示第i个节点的值val是val_i,左儿子left是第left_i个节点，右儿子right是第right_i个节点。
        //节点0表示空。
        //1<=n<=100000,保证是合法的二叉树
        //输入
        //5 1
        //5 2 3
        //1 0 0
        //3 4 5
        //4 0 0
        //6 0 0

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
            node = s.pop();// 左子树到底了POP，处理当前节点
            if(node == null){
                break;
            }
            if(pre > node.value){ // 中序遍历
                return false;
            }
            pre = node.value;
            node = node.right;// 遍历右子树
        }
        return true;
    }
}