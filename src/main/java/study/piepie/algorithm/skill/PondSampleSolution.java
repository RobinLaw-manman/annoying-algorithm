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
    public static void main(String[] args) {
        Random random = new Random();
        System.out.print(random.nextInt(1));
    }
}