package study.piepie.algorithm.skill;

import study.piepie.algorithm.entity.Node;

import java.util.Random;

/**
 * @author Robin
 * @date 2021-06-25 16:55
 **/
public class PondSampleSolution {
    public static int getRandom(Node head) {
        int res = 0;
        int i = 0;
        Random random = new Random();
        Node node = head;
        while (node != null) {
            // random [0, i] == 0的概率为1/i
            if (random.nextInt(++i) == 0) {
                res = node.getValue();
            }
            node = node.getNext();
        }
        return res;
    }

    public static int[] getRandom(Node head, int k) {
        int[] res = new int[k];
        Node node = head;
        for (int i=0;i < k && node != null; i++) {
            res[i] = head.getValue();
            node = node.getNext();
        }
        Random random = new Random();
        int i = k;
        while (node != null) {
            int j = random.nextInt(++i);
            // j < k 的概率为k/i
            // 第i个数以k/i的概率选择
            // 后面的元素也是res[j]出现在j的位置，且小于k的概率为k/(i+1)*1/k. 因为有k个数，出现在j的概率为1/k
            // 所以后续不改变这个res[j]的值的概率为1-k/(i+1)*1/k 类推
            if (j < k) {
                res[j] = node.getValue();
            }
            node = node.getNext();
        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.print(random.nextInt(1));
    }
}