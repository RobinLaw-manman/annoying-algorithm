package study.piepie.algorithm.stack;

import java.util.Stack;

/**
 * @author Robin
 * @date 2021-06-02 18:12
 **/
public class StackSolution {
    public static int[] nextGeneration(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 4, 3};
        int[] res = nextGeneration(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(res[i] + "   ");
        }
    }
}