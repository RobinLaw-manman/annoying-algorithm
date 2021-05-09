package study.piepie.algorithm.sort;

/**
 * @author Robin
 * @date 2021-05-09 14:52
 **/
public class QuickSort {
    public static void sort(int[] nums, int left , int right) {
        int i = left;
        int j = right;
        int pivot = nums[i];
        // 指针j从右到左扫描比pivot小的
        // 指针i从左到右扫描比pivot大的
        // 交换两个人位置
        // 这样保证了（j,right]的一定大于pivot
        //     [left,i)的一定小于pivot
        // 所以结束循环一定是要么j左移超过了i, 要么是i右移超过了j
        //   无论是哪种情况j一定停留在一个小于pivot的数字上
        //   用pivot和这个位置交换就可以确保pivot左边的都比它小，右边的都比pivot大
        while (i <= j) {
            while (nums[i++] < pivot);
            while (nums[j--] > pivot);
            nums[left] = nums[j];
            nums[j] = pivot;
        }
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }
}