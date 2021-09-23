package study.piepie.algorithm.skill;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Robin
 * @date 2021-09-23 16:03
 **/
public class MedianSolution {
    private final PriorityQueue<Integer> larger = new PriorityQueue<>();
    private final PriorityQueue<Integer> smaller = new PriorityQueue<>((a, b) -> b - a);

    public int findMedian() {
        if (larger.size() == smaller.size() && !larger.isEmpty()) {
            return (larger.peek() + smaller.peek()) / 2;
        }
        return !larger.isEmpty() ? larger.peek() : 0;
    }

    public void addNum(int num) {
        if (larger.size() > smaller.size()) {
            larger.offer(num);
            smaller.offer(larger.poll());
        } else {
            smaller.offer(num);
            larger.offer(smaller.poll());
        }
    }
}