package study.piepie.algorithm.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Robin
 * @date 2021-05-28 11:15
 **/
@Getter
@Setter
public class BstNode {
    private int value;
    private BstNode left;
    private BstNode right;
}