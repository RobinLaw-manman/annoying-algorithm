package study.piepie.algorithm.cache;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Robin
 * @date 2021-05-08 10:02
 **/
@Setter
@Getter
public class Node {
    private Node pre;
    private Node next;
    private int key;
    private int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}