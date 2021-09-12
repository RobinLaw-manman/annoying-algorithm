package study.piepie.algorithm.datastructure;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Robin
 * @date 2021-09-12 10:54
 **/
public class MyStack {
    Queue<Integer> queue = new LinkedBlockingQueue<>();
    private Integer topElement;

    public Integer pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        topElement = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public void push(int value) {
        queue.offer(value);
    }

    public int maxElement() {
        return topElement;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}