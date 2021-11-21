package study.piepie.algorithm.classic;

/**
 * @author Robin
 * @date 2021-11-21 11:05
 **/
public class Duplicate {
    // 1 2 2 2 3 4 4 5
    public static int removeDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length - 1) {
            fast++;
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            // fast++; // 如果fast++放后面，那while循环的结束条件是nums.length
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 4, 4, 5};
        System.out.println(removeDuplicate(nums));
    }
}