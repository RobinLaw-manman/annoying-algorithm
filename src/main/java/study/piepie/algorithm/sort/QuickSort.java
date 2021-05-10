package study.piepie.algorithm.sort;

/**
 * @author Robin
 * @date 2021-05-09 14:52
 **/
public class QuickSort {
    // 指针j从右到左扫描比pivot小的
    // 指针i从左到右扫描比pivot大的
    // 交换两个人位置
    // 这样保证了[j,right]的一定大于pivot
    //     [left,i]的一定小于pivot
    // 所以结束循环一定是要么j左移超过了i, 要么是i右移超过了j
    //   无论是哪种情况j一定停留在一个小于pivot的数字上
    //   或者i==j 这个数字等于pivot
    //   用pivot和这个位置交换就可以确保pivot左边的都比它小，右边的都比pivot大
    // 8 4 7 9 10 6 11
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    public static void sort(int[] nums, int left , int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int i = left;
        int j = right + 1;
        int pivot = nums[left];
        while (true) {
            while (nums[++i] > pivot) {
                if (i > right) {
                    break;
                }
            }
            while (nums[--j] < pivot) {
                if (j < left) {
                    break;
                }
            }
            if (i == j) {
                break;
            }
            swap(nums, i, j);
        }
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
//        数组不能这么玩
//        nums[i] = nums[i] ^ nums[j];
//        nums[j] = nums[i] ^ nums[j];
//        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        // 结论while(i++) 比 while(++i)多执行一次操作，i多加了1
        int i = 0;
        while (i++ < 3) { // 0 < 3 ---> i=i+1=1 ----> 执行循环体
            System.out.println("hello i:"+ i); // 1 2 3
        }
        System.out.println(i); // 4
        int j = 0;
        while (++j < 3) { // i=i+1=1 ---> 1 < 3 ----> 执行循环体
            System.out.println("hello j:"+ j); // 1 2
        }
        System.out.println(j); // 3

        int[] nums = new int[]{1, 2};
        System.out.println(nums[0] + " " + nums[1]);
        swap(nums, 0, 1);
        System.out.println(nums[0] + " " + nums[1]);
    }
}