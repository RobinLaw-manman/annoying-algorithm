package study.piepie.algorithm.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Robin
 * @date 2021-05-20 15:12
 **/
@Getter
@Setter
public class Node {
    private int value;
    public Node next;

    public Node(int val) {
        value = val;
    }
}