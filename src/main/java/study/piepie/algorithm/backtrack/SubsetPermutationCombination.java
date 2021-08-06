package study.piepie.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Robin
 * @date 2021-08-06 14:40
 **/
public class SubsetPermutationCombination {
    static List<LinkedList<Integer>> res = new ArrayList();

    public static List<LinkedList<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    public static void backtrack(int[] nums, int start, LinkedList<Integer> subset) {
        LinkedList<Integer> sub = new LinkedList<>(subset);
        res.add(sub);
        for (int i = start; i < nums.length; i++) {
            sub.add(i);
            backtrack(nums, i + 1, sub);
            sub.pollLast();
        }
    }
}